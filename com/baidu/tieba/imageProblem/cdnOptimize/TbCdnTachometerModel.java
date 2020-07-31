package com.baidu.tieba.imageProblem.cdnOptimize;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.network.http.e;
import com.baidu.adp.lib.util.s;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.a.f;
import com.baidu.tbadk.core.util.u;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.util.m;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes13.dex */
public class TbCdnTachometerModel<T> extends BdBaseModel<T> {
    private TbCdnTachometerModelCallBack juv;
    private HttpMessageListener juw;
    public static final String IPLIST_ADDRESS_PATH = "c/s/checkcdn";
    public static final String IPLIST_ADDRESS = TbConfig.SERVER_ADDRESS + IPLIST_ADDRESS_PATH;

    /* loaded from: classes13.dex */
    public interface TbCdnTachometerModelCallBack {
        void callBack(TbCdnIpListData tbCdnIpListData);
    }

    public TbCdnTachometerModel(TbPageContext<T> tbPageContext) {
        super(tbPageContext);
        this.juv = null;
        this.juw = new HttpMessageListener(1002600) { // from class: com.baidu.tieba.imageProblem.cdnOptimize.TbCdnTachometerModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                int i;
                boolean z;
                String str;
                boolean z2;
                if (httpResponsedMessage != null && TbCdnTachometerModel.this.unique_id == httpResponsedMessage.getOrginalMessage().getTag() && (httpResponsedMessage instanceof TbCdnGetIPListHttpResponseMsg)) {
                    TbCdnIpListData tbCdnIpListData = ((TbCdnGetIPListHttpResponseMsg) httpResponsedMessage).ipListData;
                    if (httpResponsedMessage.getError() != 0 || tbCdnIpListData == null || tbCdnIpListData.jum != 0) {
                        if (TbCdnTachometerModel.this.juv != null) {
                            int error = httpResponsedMessage.getError();
                            String errorString = httpResponsedMessage.getErrorString();
                            if (httpResponsedMessage.getError() == 0) {
                                i = tbCdnIpListData.jum;
                                z = false;
                                str = tbCdnIpListData.errorString;
                                z2 = true;
                            } else {
                                i = error;
                                z = false;
                                str = errorString;
                                z2 = false;
                            }
                        }
                        str = "";
                        z2 = false;
                        z = true;
                        i = -1;
                    } else {
                        if (TbCdnTachometerModel.this.juv != null) {
                            TbCdnTachometerModel.this.juv.callBack(tbCdnIpListData);
                        }
                        if (tbCdnIpListData.juo.size() == 0) {
                            str = "noList";
                            z2 = false;
                            z = true;
                            i = -1;
                        }
                        str = "";
                        z2 = false;
                        z = true;
                        i = -1;
                    }
                    u.a(z, z2, String.valueOf(i), str);
                }
            }
        };
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1002600, IPLIST_ADDRESS);
        tbHttpMessageTask.setResponsedClass(TbCdnGetIPListHttpResponseMsg.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().unRegisterListener(this.juw);
        MessageManager.getInstance().registerListener(this.juw);
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterTask(1002600);
        MessageManager.getInstance().unRegisterListener(this.juw);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void setCndTachometerModelCallBack(TbCdnTachometerModelCallBack tbCdnTachometerModelCallBack) {
        this.juv = tbCdnTachometerModelCallBack;
    }

    public void getCDNIPList() {
        sendMessage(new HttpMessage(1002600));
    }

    public boolean getTestImageData(String str, String str2, String str3, String str4, boolean z) {
        String str5;
        boolean z2;
        int i;
        boolean z3 = false;
        if (str == null || str2 == null || str3 == null || str4 == null || !m.isCdn(str)) {
            return false;
        }
        try {
            long currentTimeMillis = System.currentTimeMillis();
            e eVar = new e();
            f fVar = new f(eVar);
            eVar.kT().setUrl(str);
            fVar.l(str2, str3, 1);
            byte[] bArr = eVar.kU().retBytes;
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            boolean z4 = eVar.kU().responseCode == 200;
            String str6 = "";
            if (z4) {
                if (bArr != null) {
                    int length = bArr.length;
                    String md5 = s.toMd5(bArr);
                    if (!str4.equalsIgnoreCase(md5)) {
                        str6 = "MD5Error_" + md5 + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str4;
                        if (eVar.kW() != null && eVar.kW().exception != null && eVar.kW().exception.length() != 0) {
                            str6 = str6 + ":" + eVar.kU().responseCode + Constants.ACCEPT_TIME_SEPARATOR_SERVER + eVar.kW().exception;
                            eVar.b(null);
                        }
                        z4 = false;
                    }
                    str5 = str6;
                    z2 = z4;
                    i = length;
                } else {
                    str5 = "downSizeZero";
                    if (eVar.kW() == null || eVar.kW().exception == null || eVar.kW().exception.length() == 0) {
                        z2 = z4;
                        i = 0;
                    } else {
                        str5 = "downSizeZero:" + eVar.kU().responseCode + Constants.ACCEPT_TIME_SEPARATOR_SERVER + eVar.kW().exception;
                        eVar.b(null);
                        z2 = z4;
                        i = 0;
                    }
                }
            } else {
                str5 = "NETError_" + eVar.kU().responseCode + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (eVar.kW() != null ? eVar.kW().exception : null);
                z2 = z4;
                i = 0;
            }
            u.a(z2, str, str2, "0", str5, String.valueOf(i), currentTimeMillis2, z);
            z3 = z2;
            return z3;
        } catch (Exception e) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(DealIntentService.KEY_CLASS);
            stringBuffer.append(e.getClass());
            stringBuffer.append(" message");
            stringBuffer.append(e.getMessage());
            u.a(z3, str, str2, "-1", stringBuffer.toString(), "0", 0L, z);
            return z3;
        }
    }
}
