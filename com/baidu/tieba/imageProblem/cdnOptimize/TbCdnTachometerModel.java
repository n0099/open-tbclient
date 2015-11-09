package com.baidu.tieba.imageProblem.cdnOptimize;

import com.baidu.adp.base.e;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.t;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.a.f;
import com.baidu.tbadk.core.util.r;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes.dex */
public class TbCdnTachometerModel<T> extends e<T> {
    public static final String bQG = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/checkcdn";
    private TbCdnTachometerModelCallBack bQF;
    private HttpMessageListener bQH;

    /* loaded from: classes.dex */
    public interface TbCdnTachometerModelCallBack {
        void callBack(TbCdnIpListData tbCdnIpListData);
    }

    public TbCdnTachometerModel(TbPageContext<T> tbPageContext) {
        super(tbPageContext);
        this.bQF = null;
        this.bQH = new HttpMessageListener(CmdConfigHttp.CDN_IPLIST_CMD) { // from class: com.baidu.tieba.imageProblem.cdnOptimize.TbCdnTachometerModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                int i;
                boolean z;
                String str;
                boolean z2;
                if (httpResponsedMessage != null && TbCdnTachometerModel.this.unique_id == httpResponsedMessage.getOrginalMessage().getTag() && (httpResponsedMessage instanceof TbCdnGetIPListHttpResponseMsg)) {
                    TbCdnIpListData tbCdnIpListData = ((TbCdnGetIPListHttpResponseMsg) httpResponsedMessage).ipListData;
                    if (httpResponsedMessage.getError() != 0 || tbCdnIpListData == null || tbCdnIpListData.errorNum != 0) {
                        if (TbCdnTachometerModel.this.bQF != null) {
                            int error = httpResponsedMessage.getError();
                            String errorString = httpResponsedMessage.getErrorString();
                            if (httpResponsedMessage.getError() == 0) {
                                i = tbCdnIpListData.errorNum;
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
                        if (TbCdnTachometerModel.this.bQF != null) {
                            TbCdnTachometerModel.this.bQF.callBack(tbCdnIpListData);
                        }
                        if (tbCdnIpListData.bQw.size() == 0) {
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
                    r.a(z, z2, String.valueOf(i), str);
                }
            }
        };
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CDN_IPLIST_CMD, bQG);
        tbHttpMessageTask.setResponsedClass(TbCdnGetIPListHttpResponseMsg.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().unRegisterListener(this.bQH);
        MessageManager.getInstance().registerListener(this.bQH);
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CDN_IPLIST_CMD);
        MessageManager.getInstance().unRegisterListener(this.bQH);
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    public void setCndTachometerModelCallBack(TbCdnTachometerModelCallBack tbCdnTachometerModelCallBack) {
        this.bQF = tbCdnTachometerModelCallBack;
    }

    public void getCDNIPList() {
        sendMessage(new HttpMessage(CmdConfigHttp.CDN_IPLIST_CMD));
    }

    public boolean getTestImageData(String str, String str2, String str3, String str4, boolean z) {
        boolean z2;
        if (str == null || str2 == null || str3 == null || str4 == null || !com.baidu.tbadk.util.e.fM(str)) {
            return false;
        }
        try {
            long currentTimeMillis = System.currentTimeMillis();
            com.baidu.adp.lib.network.http.e eVar = new com.baidu.adp.lib.network.http.e();
            f fVar = new f(eVar);
            eVar.gQ().setUrl(str);
            fVar.e(str2, str3, 1);
            byte[] bArr = eVar.gR().vf;
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            boolean z3 = eVar.gR().responseCode == 200 || eVar.gR().responseCode / 100 == 3;
            int i = 0;
            String str5 = "";
            if (z3) {
                if (bArr != null) {
                    int length = bArr.length;
                    String B = t.B(bArr);
                    if (str4.equalsIgnoreCase(B)) {
                        i = length;
                        z2 = z3;
                    } else {
                        String str6 = "MD5Error_" + B + "_" + str4;
                        if (eVar.gT() != null && eVar.gT().uR != null && eVar.gT().uR.length() != 0) {
                            str6 = String.valueOf(str6) + ":" + eVar.gR().responseCode + "-" + eVar.gT().uR;
                            eVar.b(null);
                        }
                        z2 = false;
                        str5 = str6;
                        i = length;
                    }
                } else {
                    str5 = "downSizeZero";
                    if (eVar.gT() == null || eVar.gT().uR == null || eVar.gT().uR.length() == 0) {
                        z2 = z3;
                    } else {
                        str5 = String.valueOf("downSizeZero") + ":" + eVar.gR().responseCode + "-" + eVar.gT().uR;
                        eVar.b(null);
                        z2 = z3;
                    }
                }
            } else {
                String str7 = null;
                if (eVar.gT() != null) {
                    str7 = eVar.gT().uR;
                }
                str5 = "NETError_" + eVar.gR().responseCode + "-" + str7;
                z2 = z3;
            }
            r.a(z3, str, str2, "0", str5, String.valueOf(i), currentTimeMillis2, z);
            return z2;
        } catch (Exception e) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("class");
            stringBuffer.append(e.getClass());
            stringBuffer.append(" message");
            stringBuffer.append(e.getMessage());
            r.a(false, str, str2, "-1", stringBuffer.toString(), "0", 0L, z);
            return false;
        }
    }
}
