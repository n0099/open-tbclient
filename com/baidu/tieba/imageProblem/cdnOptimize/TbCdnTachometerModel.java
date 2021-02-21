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
import com.baidu.tbadk.core.util.u;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.util.n;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes8.dex */
public class TbCdnTachometerModel<T> extends BdBaseModel<T> {
    private TbCdnTachometerModelCallBack kWR;
    private HttpMessageListener kWS;
    public static final String IPLIST_ADDRESS_PATH = "c/s/checkcdn";
    public static final String IPLIST_ADDRESS = TbConfig.SERVER_ADDRESS + IPLIST_ADDRESS_PATH;

    /* loaded from: classes8.dex */
    public interface TbCdnTachometerModelCallBack {
        void callBack(TbCdnIpListData tbCdnIpListData);
    }

    public TbCdnTachometerModel(TbPageContext<T> tbPageContext) {
        super(tbPageContext);
        this.kWR = null;
        this.kWS = new HttpMessageListener(1002600) { // from class: com.baidu.tieba.imageProblem.cdnOptimize.TbCdnTachometerModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                boolean z;
                boolean z2;
                if (httpResponsedMessage != null && TbCdnTachometerModel.this.unique_id == httpResponsedMessage.getOrginalMessage().getTag() && (httpResponsedMessage instanceof TbCdnGetIPListHttpResponseMsg)) {
                    TbCdnIpListData tbCdnIpListData = ((TbCdnGetIPListHttpResponseMsg) httpResponsedMessage).ipListData;
                    int i = -1;
                    String str = "";
                    if (httpResponsedMessage.getError() != 0 || tbCdnIpListData == null || tbCdnIpListData.bjQ != 0) {
                        if (TbCdnTachometerModel.this.kWR != null) {
                            i = httpResponsedMessage.getError();
                            str = httpResponsedMessage.getErrorString();
                            if (httpResponsedMessage.getError() == 0) {
                                i = tbCdnIpListData.bjQ;
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
                        if (TbCdnTachometerModel.this.kWR != null) {
                            TbCdnTachometerModel.this.kWR.callBack(tbCdnIpListData);
                        }
                        if (tbCdnIpListData.kWK.size() == 0) {
                            str = "noList";
                            z = false;
                            z2 = true;
                        }
                        z = false;
                        z2 = true;
                    }
                    u.a(z2, z, String.valueOf(i), str);
                }
            }
        };
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1002600, IPLIST_ADDRESS);
        tbHttpMessageTask.setResponsedClass(TbCdnGetIPListHttpResponseMsg.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().unRegisterListener(this.kWS);
        MessageManager.getInstance().registerListener(this.kWS);
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterTask(1002600);
        MessageManager.getInstance().unRegisterListener(this.kWS);
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
        this.kWR = tbCdnTachometerModelCallBack;
    }

    public void getCDNIPList() {
        sendMessage(new HttpMessage(1002600));
    }

    public boolean getTestImageData(String str, String str2, String str3, String str4, boolean z) {
        String str5;
        int i;
        boolean z2;
        String str6;
        if (str == null || str2 == null || str3 == null || str4 == null || !n.isCdn(str)) {
            return false;
        }
        try {
            long currentTimeMillis = System.currentTimeMillis();
            e eVar = new e();
            f fVar = new f(eVar);
            eVar.lU().setUrl(str);
            fVar.q(str2, str3, 1);
            byte[] bArr = eVar.lV().retBytes;
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            boolean z3 = eVar.lV().responseCode == 200;
            if (z3) {
                if (bArr != null) {
                    int length = bArr.length;
                    String md5 = s.toMd5(bArr);
                    if (str4.equalsIgnoreCase(md5)) {
                        str6 = "";
                    } else {
                        String str7 = "MD5Error_" + md5 + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str4;
                        if (eVar.lX() != null && eVar.lX().exception != null && eVar.lX().exception.length() != 0) {
                            str7 = str7 + ":" + eVar.lV().responseCode + Constants.ACCEPT_TIME_SEPARATOR_SERVER + eVar.lX().exception;
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
                    if (eVar.lX() == null || eVar.lX().exception == null || eVar.lX().exception.length() == 0) {
                        i = 0;
                        z2 = z3;
                    } else {
                        str5 = "downSizeZero:" + eVar.lV().responseCode + Constants.ACCEPT_TIME_SEPARATOR_SERVER + eVar.lX().exception;
                        eVar.b(null);
                        i = 0;
                        z2 = z3;
                    }
                }
            } else {
                String str8 = null;
                if (eVar.lX() != null) {
                    str8 = eVar.lX().exception;
                }
                str5 = "NETError_" + eVar.lV().responseCode + Constants.ACCEPT_TIME_SEPARATOR_SERVER + str8;
                i = 0;
                z2 = z3;
            }
            u.a(z2, str, str2, "0", str5, String.valueOf(i), currentTimeMillis2, z);
            return z2;
        } catch (Exception e) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(DealIntentService.KEY_CLASS);
            stringBuffer.append(e.getClass());
            stringBuffer.append(" message");
            stringBuffer.append(e.getMessage());
            u.a(false, str, str2, "-1", stringBuffer.toString(), "0", 0L, z);
            return false;
        }
    }
}
