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
import com.baidu.tbadk.core.util.b.f;
import com.baidu.tbadk.core.util.t;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.util.m;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes7.dex */
public class TbCdnTachometerModel<T> extends BdBaseModel<T> {
    private TbCdnTachometerModelCallBack kOB;
    private HttpMessageListener kOC;
    public static final String IPLIST_ADDRESS_PATH = "c/s/checkcdn";
    public static final String IPLIST_ADDRESS = TbConfig.SERVER_ADDRESS + IPLIST_ADDRESS_PATH;

    /* loaded from: classes7.dex */
    public interface TbCdnTachometerModelCallBack {
        void callBack(TbCdnIpListData tbCdnIpListData);
    }

    public TbCdnTachometerModel(TbPageContext<T> tbPageContext) {
        super(tbPageContext);
        this.kOB = null;
        this.kOC = new HttpMessageListener(1002600) { // from class: com.baidu.tieba.imageProblem.cdnOptimize.TbCdnTachometerModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                boolean z;
                boolean z2;
                if (httpResponsedMessage != null && TbCdnTachometerModel.this.unique_id == httpResponsedMessage.getOrginalMessage().getTag() && (httpResponsedMessage instanceof TbCdnGetIPListHttpResponseMsg)) {
                    TbCdnIpListData tbCdnIpListData = ((TbCdnGetIPListHttpResponseMsg) httpResponsedMessage).ipListData;
                    int i = -1;
                    String str = "";
                    if (httpResponsedMessage.getError() != 0 || tbCdnIpListData == null || tbCdnIpListData.kOs != 0) {
                        if (TbCdnTachometerModel.this.kOB != null) {
                            i = httpResponsedMessage.getError();
                            str = httpResponsedMessage.getErrorString();
                            if (httpResponsedMessage.getError() == 0) {
                                i = tbCdnIpListData.kOs;
                                str = tbCdnIpListData.errorString;
                                z = true;
                                z2 = false;
                            } else {
                                z = false;
                                z2 = false;
                            }
                        }
                        z = false;
                        z2 = true;
                    } else {
                        if (TbCdnTachometerModel.this.kOB != null) {
                            TbCdnTachometerModel.this.kOB.callBack(tbCdnIpListData);
                        }
                        if (tbCdnIpListData.kOu.size() == 0) {
                            str = "noList";
                            z = false;
                            z2 = true;
                        }
                        z = false;
                        z2 = true;
                    }
                    t.a(z2, z, String.valueOf(i), str);
                }
            }
        };
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1002600, IPLIST_ADDRESS);
        tbHttpMessageTask.setResponsedClass(TbCdnGetIPListHttpResponseMsg.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().unRegisterListener(this.kOC);
        MessageManager.getInstance().registerListener(this.kOC);
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterTask(1002600);
        MessageManager.getInstance().unRegisterListener(this.kOC);
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
        this.kOB = tbCdnTachometerModelCallBack;
    }

    public void getCDNIPList() {
        sendMessage(new HttpMessage(1002600));
    }

    public boolean getTestImageData(String str, String str2, String str3, String str4, boolean z) {
        String str5;
        int i;
        boolean z2;
        String str6;
        if (str == null || str2 == null || str3 == null || str4 == null || !m.isCdn(str)) {
            return false;
        }
        try {
            long currentTimeMillis = System.currentTimeMillis();
            e eVar = new e();
            f fVar = new f(eVar);
            eVar.lV().setUrl(str);
            fVar.q(str2, str3, 1);
            byte[] bArr = eVar.lW().retBytes;
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            boolean z3 = eVar.lW().responseCode == 200;
            if (z3) {
                if (bArr != null) {
                    int length = bArr.length;
                    String md5 = s.toMd5(bArr);
                    if (str4.equalsIgnoreCase(md5)) {
                        str6 = "";
                    } else {
                        String str7 = "MD5Error_" + md5 + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str4;
                        if (eVar.lY() != null && eVar.lY().exception != null && eVar.lY().exception.length() != 0) {
                            str7 = str7 + ":" + eVar.lW().responseCode + Constants.ACCEPT_TIME_SEPARATOR_SERVER + eVar.lY().exception;
                            eVar.b(null);
                        }
                        z3 = false;
                        str6 = str7;
                    }
                    str5 = str6;
                    i = length;
                    z2 = z3;
                } else {
                    str5 = "downSizeZero";
                    if (eVar.lY() == null || eVar.lY().exception == null || eVar.lY().exception.length() == 0) {
                        i = 0;
                        z2 = z3;
                    } else {
                        str5 = "downSizeZero:" + eVar.lW().responseCode + Constants.ACCEPT_TIME_SEPARATOR_SERVER + eVar.lY().exception;
                        eVar.b(null);
                        i = 0;
                        z2 = z3;
                    }
                }
            } else {
                String str8 = null;
                if (eVar.lY() != null) {
                    str8 = eVar.lY().exception;
                }
                str5 = "NETError_" + eVar.lW().responseCode + Constants.ACCEPT_TIME_SEPARATOR_SERVER + str8;
                i = 0;
                z2 = z3;
            }
            t.a(z2, str, str2, "0", str5, String.valueOf(i), currentTimeMillis2, z);
            return z2;
        } catch (Exception e) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(DealIntentService.KEY_CLASS);
            stringBuffer.append(e.getClass());
            stringBuffer.append(" message");
            stringBuffer.append(e.getMessage());
            t.a(false, str, str2, "-1", stringBuffer.toString(), "0", 0L, z);
            return false;
        }
    }
}
