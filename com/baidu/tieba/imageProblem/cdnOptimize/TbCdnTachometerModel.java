package com.baidu.tieba.imageProblem.cdnOptimize;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.network.http.e;
import com.baidu.searchbox.ng.ai.apps.media.audio.AiAppsAudioPlayer;
import com.baidu.searchbox.ng.ai.apps.network.BaseRequestAction;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.a.f;
import com.baidu.tbadk.core.util.s;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.util.i;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes4.dex */
public class TbCdnTachometerModel<T> extends BdBaseModel<T> {
    private TbCdnTachometerModelCallBack fab;
    private HttpMessageListener fac;
    public static final String IPLIST_ADDRESS_PATH = "c/s/checkcdn";
    public static final String IPLIST_ADDRESS = TbConfig.SERVER_ADDRESS + IPLIST_ADDRESS_PATH;

    /* loaded from: classes4.dex */
    public interface TbCdnTachometerModelCallBack {
        void callBack(TbCdnIpListData tbCdnIpListData);
    }

    public TbCdnTachometerModel(TbPageContext<T> tbPageContext) {
        super(tbPageContext);
        this.fab = null;
        this.fac = new HttpMessageListener(CmdConfigHttp.CDN_IPLIST_CMD) { // from class: com.baidu.tieba.imageProblem.cdnOptimize.TbCdnTachometerModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                int i;
                boolean z;
                String str;
                boolean z2;
                if (httpResponsedMessage != null && TbCdnTachometerModel.this.unique_id == httpResponsedMessage.getOrginalMessage().getTag() && (httpResponsedMessage instanceof TbCdnGetIPListHttpResponseMsg)) {
                    TbCdnIpListData tbCdnIpListData = ((TbCdnGetIPListHttpResponseMsg) httpResponsedMessage).ipListData;
                    if (httpResponsedMessage.getError() != 0 || tbCdnIpListData == null || tbCdnIpListData.eZS != 0) {
                        if (TbCdnTachometerModel.this.fab != null) {
                            int error = httpResponsedMessage.getError();
                            String errorString = httpResponsedMessage.getErrorString();
                            if (httpResponsedMessage.getError() == 0) {
                                i = tbCdnIpListData.eZS;
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
                        if (TbCdnTachometerModel.this.fab != null) {
                            TbCdnTachometerModel.this.fab.callBack(tbCdnIpListData);
                        }
                        if (tbCdnIpListData.eZU.size() == 0) {
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
                    s.a(z, z2, String.valueOf(i), str);
                }
            }
        };
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CDN_IPLIST_CMD, IPLIST_ADDRESS);
        tbHttpMessageTask.setResponsedClass(TbCdnGetIPListHttpResponseMsg.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().unRegisterListener(this.fac);
        MessageManager.getInstance().registerListener(this.fac);
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CDN_IPLIST_CMD);
        MessageManager.getInstance().unRegisterListener(this.fac);
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
        this.fab = tbCdnTachometerModelCallBack;
    }

    public void getCDNIPList() {
        sendMessage(new HttpMessage(CmdConfigHttp.CDN_IPLIST_CMD));
    }

    public boolean getTestImageData(String str, String str2, String str3, String str4, boolean z) {
        String str5;
        boolean z2;
        int i;
        boolean z3 = false;
        if (str == null || str2 == null || str3 == null || str4 == null || !i.ii(str)) {
            return false;
        }
        try {
            long currentTimeMillis = System.currentTimeMillis();
            e eVar = new e();
            f fVar = new f(eVar);
            eVar.jr().setUrl(str);
            fVar.e(str2, str3, 1);
            byte[] bArr = eVar.js().Dc;
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            boolean z4 = eVar.js().responseCode == 200;
            String str6 = "";
            if (z4) {
                if (bArr != null) {
                    int length = bArr.length;
                    String md5 = com.baidu.adp.lib.util.s.toMd5(bArr);
                    if (!str4.equalsIgnoreCase(md5)) {
                        str6 = "MD5Error_" + md5 + BaseRequestAction.SPLITE + str4;
                        if (eVar.ju() != null && eVar.ju().CH != null && eVar.ju().CH.length() != 0) {
                            str6 = str6 + ":" + eVar.js().responseCode + Constants.ACCEPT_TIME_SEPARATOR_SERVER + eVar.ju().CH;
                            eVar.b(null);
                        }
                        z4 = false;
                    }
                    str5 = str6;
                    z2 = z4;
                    i = length;
                } else {
                    str5 = "downSizeZero";
                    if (eVar.ju() == null || eVar.ju().CH == null || eVar.ju().CH.length() == 0) {
                        z2 = z4;
                        i = 0;
                    } else {
                        str5 = "downSizeZero:" + eVar.js().responseCode + Constants.ACCEPT_TIME_SEPARATOR_SERVER + eVar.ju().CH;
                        eVar.b(null);
                        z2 = z4;
                        i = 0;
                    }
                }
            } else {
                str5 = "NETError_" + eVar.js().responseCode + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (eVar.ju() != null ? eVar.ju().CH : null);
                z2 = z4;
                i = 0;
            }
            s.a(z2, str, str2, "0", str5, String.valueOf(i), currentTimeMillis2, z);
            z3 = z2;
            return z3;
        } catch (Exception e) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("class");
            stringBuffer.append(e.getClass());
            stringBuffer.append(" message");
            stringBuffer.append(e.getMessage());
            s.a(z3, str, str2, AiAppsAudioPlayer.ERROR_UNKNOWN, stringBuffer.toString(), "0", 0L, z);
            return z3;
        }
    }
}
