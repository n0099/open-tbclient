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
import com.baidu.tbadk.core.util.httpNet.f;
import com.baidu.tbadk.core.util.r;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.util.d;
/* loaded from: classes.dex */
public class TbCdnTachometerModel<T> extends e<T> {
    public static final String bLS = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/checkcdn";
    private TbCdnTachometerModelCallBack bLR;
    private HttpMessageListener bLT;

    /* loaded from: classes.dex */
    public interface TbCdnTachometerModelCallBack {
        void callBack(TbCdnIpListData tbCdnIpListData);
    }

    public TbCdnTachometerModel(TbPageContext<T> tbPageContext) {
        super(tbPageContext);
        this.bLR = null;
        this.bLT = new HttpMessageListener(CmdConfigHttp.CDN_IPLIST_CMD) { // from class: com.baidu.tieba.imageProblem.cdnOptimize.TbCdnTachometerModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                String str;
                boolean z;
                boolean z2;
                int i;
                if (httpResponsedMessage != null && TbCdnTachometerModel.this.unique_id == httpResponsedMessage.getOrginalMessage().getTag() && (httpResponsedMessage instanceof TbCdnGetIPListHttpResponseMsg)) {
                    TbCdnIpListData tbCdnIpListData = ((TbCdnGetIPListHttpResponseMsg) httpResponsedMessage).ipListData;
                    if (httpResponsedMessage.getError() != 0 || tbCdnIpListData == null || tbCdnIpListData.bLG != 0) {
                        if (TbCdnTachometerModel.this.bLR != null) {
                            int error = httpResponsedMessage.getError();
                            String errorString = httpResponsedMessage.getErrorString();
                            if (httpResponsedMessage.getError() == 0) {
                                z2 = false;
                                z = false;
                                i = tbCdnIpListData.bLG;
                                str = tbCdnIpListData.errorString;
                            } else {
                                str = errorString;
                                z = true;
                                z2 = false;
                                i = error;
                            }
                        }
                        i = -1;
                        z2 = true;
                        str = "";
                        z = true;
                    } else {
                        if (TbCdnTachometerModel.this.bLR != null) {
                            TbCdnTachometerModel.this.bLR.callBack(tbCdnIpListData);
                        }
                        if (tbCdnIpListData.bLI.size() == 0) {
                            i = -1;
                            z2 = true;
                            str = "noList";
                            z = true;
                        }
                        i = -1;
                        z2 = true;
                        str = "";
                        z = true;
                    }
                    r.a(z2, z, String.valueOf(i), str);
                }
            }
        };
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CDN_IPLIST_CMD, bLS);
        tbHttpMessageTask.setResponsedClass(TbCdnGetIPListHttpResponseMsg.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().unRegisterListener(this.bLT);
        MessageManager.getInstance().registerListener(this.bLT);
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CDN_IPLIST_CMD);
        MessageManager.getInstance().unRegisterListener(this.bLT);
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
        this.bLR = tbCdnTachometerModelCallBack;
    }

    public void getCDNIPList() {
        sendMessage(new HttpMessage(CmdConfigHttp.CDN_IPLIST_CMD));
    }

    public boolean getTestImageData(String str, String str2, String str3, String str4, boolean z) {
        boolean z2;
        if (str == null || str2 == null || str3 == null || str4 == null || !d.fx(str)) {
            return false;
        }
        try {
            long currentTimeMillis = System.currentTimeMillis();
            com.baidu.adp.lib.network.http.e eVar = new com.baidu.adp.lib.network.http.e();
            f fVar = new f(eVar);
            eVar.gS().setUrl(str);
            fVar.e(str2, str3, 1);
            byte[] bArr = eVar.gT().vg;
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            boolean gY = eVar.gT().gY();
            int i = 0;
            String str5 = "";
            if (bArr != null) {
                i = bArr.length;
                String B = t.B(bArr);
                if (str4.equalsIgnoreCase(B)) {
                    z2 = gY;
                } else {
                    str5 = "MD5Error_" + B + "_" + str4;
                    z2 = false;
                }
            } else {
                str5 = "downSizeZero";
                z2 = gY;
            }
            r.a(gY, str, str2, "0", str5, String.valueOf(i), currentTimeMillis2, z);
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
