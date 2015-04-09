package com.baidu.tieba.imageProblem.cdnOptimize;

import com.baidu.adp.base.f;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.network.http.e;
import com.baidu.adp.lib.util.ab;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.httpNet.ImgHttpClient;
import com.baidu.tbadk.core.util.t;
import com.baidu.tbadk.game.GameInfoData;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.util.g;
/* loaded from: classes.dex */
public class TbCdnTachometerModel<T> extends f<T> {
    public static final String bvu = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/checkcdn";
    private TbCdnTachometerModelCallBack bvt;
    private HttpMessageListener bvv;

    /* loaded from: classes.dex */
    public interface TbCdnTachometerModelCallBack {
        void callBack(TbCdnIpListData tbCdnIpListData);
    }

    public TbCdnTachometerModel(TbPageContext<T> tbPageContext) {
        super(tbPageContext);
        this.bvt = null;
        this.bvv = new HttpMessageListener(CmdConfigHttp.CDN_IPLIST_CMD) { // from class: com.baidu.tieba.imageProblem.cdnOptimize.TbCdnTachometerModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                String str;
                boolean z;
                boolean z2;
                int i;
                if (httpResponsedMessage != null && TbCdnTachometerModel.this.unique_id == httpResponsedMessage.getOrginalMessage().getTag() && (httpResponsedMessage instanceof TbCdnGetIPListHttpResponseMsg)) {
                    TbCdnIpListData tbCdnIpListData = ((TbCdnGetIPListHttpResponseMsg) httpResponsedMessage).ipListData;
                    if (httpResponsedMessage.getError() != 0 || tbCdnIpListData == null || tbCdnIpListData.bvi != 0) {
                        if (TbCdnTachometerModel.this.bvt != null) {
                            int error = httpResponsedMessage.getError();
                            String errorString = httpResponsedMessage.getErrorString();
                            if (httpResponsedMessage.getError() == 0) {
                                z2 = false;
                                z = false;
                                i = tbCdnIpListData.bvi;
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
                        if (TbCdnTachometerModel.this.bvt != null) {
                            TbCdnTachometerModel.this.bvt.callBack(tbCdnIpListData);
                        }
                        if (tbCdnIpListData.bvk.size() == 0) {
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
                    t.a(z2, z, String.valueOf(i), str);
                }
            }
        };
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CDN_IPLIST_CMD, bvu);
        tbHttpMessageTask.setResponsedClass(TbCdnGetIPListHttpResponseMsg.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().unRegisterListener(this.bvv);
        MessageManager.getInstance().registerListener(this.bvv);
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CDN_IPLIST_CMD);
        MessageManager.getInstance().unRegisterListener(this.bvv);
    }

    @Override // com.baidu.adp.base.f
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.f
    public boolean cancelLoadData() {
        return false;
    }

    public void setCndTachometerModelCallBack(TbCdnTachometerModelCallBack tbCdnTachometerModelCallBack) {
        this.bvt = tbCdnTachometerModelCallBack;
    }

    public void getCDNIPList() {
        sendMessage(new HttpMessage(CmdConfigHttp.CDN_IPLIST_CMD));
    }

    public boolean getTestImageData(String str, String str2, String str3, String str4, boolean z) {
        boolean z2;
        if (str == null || str2 == null || str3 == null || str4 == null || !g.eK(str)) {
            return false;
        }
        try {
            long currentTimeMillis = System.currentTimeMillis();
            e eVar = new e();
            ImgHttpClient imgHttpClient = new ImgHttpClient(eVar);
            eVar.hm().setUrl(str);
            imgHttpClient.e(str2, str3, 1);
            byte[] bArr = eVar.hn().vY;
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            boolean hs = eVar.hn().hs();
            int i = 0;
            String str5 = "";
            if (bArr != null) {
                i = bArr.length;
                String p = ab.p(bArr);
                if (str4.equalsIgnoreCase(p)) {
                    z2 = hs;
                } else {
                    str5 = "MD5Error_" + p + "_" + str4;
                    z2 = false;
                }
            } else {
                str5 = "downSizeZero";
                z2 = hs;
            }
            t.a(hs, str, str2, GameInfoData.NOT_FROM_DETAIL, str5, String.valueOf(i), currentTimeMillis2, z);
            return z2;
        } catch (Exception e) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("class");
            stringBuffer.append(e.getClass());
            stringBuffer.append(" message");
            stringBuffer.append(e.getMessage());
            t.a(false, str, str2, "-1", stringBuffer.toString(), GameInfoData.NOT_FROM_DETAIL, 0L, z);
            return false;
        }
    }
}
