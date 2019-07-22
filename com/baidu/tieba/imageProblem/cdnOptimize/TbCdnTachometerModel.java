package com.baidu.tieba.imageProblem.cdnOptimize;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.network.http.e;
import com.baidu.pass.biometrics.face.liveness.stat.LivenessStat;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.a.f;
import com.baidu.tbadk.core.util.s;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.util.l;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes2.dex */
public class TbCdnTachometerModel<T> extends BdBaseModel<T> {
    private HttpMessageListener gZA;
    private TbCdnTachometerModelCallBack gZz;
    public static final String IPLIST_ADDRESS_PATH = "c/s/checkcdn";
    public static final String IPLIST_ADDRESS = TbConfig.SERVER_ADDRESS + IPLIST_ADDRESS_PATH;

    /* loaded from: classes2.dex */
    public interface TbCdnTachometerModelCallBack {
        void callBack(TbCdnIpListData tbCdnIpListData);
    }

    public TbCdnTachometerModel(TbPageContext<T> tbPageContext) {
        super(tbPageContext);
        this.gZz = null;
        this.gZA = new HttpMessageListener(CmdConfigHttp.CDN_IPLIST_CMD) { // from class: com.baidu.tieba.imageProblem.cdnOptimize.TbCdnTachometerModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                int i;
                boolean z;
                String str;
                boolean z2;
                if (httpResponsedMessage != null && TbCdnTachometerModel.this.unique_id == httpResponsedMessage.getOrginalMessage().getTag() && (httpResponsedMessage instanceof TbCdnGetIPListHttpResponseMsg)) {
                    TbCdnIpListData tbCdnIpListData = ((TbCdnGetIPListHttpResponseMsg) httpResponsedMessage).ipListData;
                    if (httpResponsedMessage.getError() != 0 || tbCdnIpListData == null || tbCdnIpListData.gZq != 0) {
                        if (TbCdnTachometerModel.this.gZz != null) {
                            int error = httpResponsedMessage.getError();
                            String errorString = httpResponsedMessage.getErrorString();
                            if (httpResponsedMessage.getError() == 0) {
                                i = tbCdnIpListData.gZq;
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
                        if (TbCdnTachometerModel.this.gZz != null) {
                            TbCdnTachometerModel.this.gZz.callBack(tbCdnIpListData);
                        }
                        if (tbCdnIpListData.gZs.size() == 0) {
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
        MessageManager.getInstance().unRegisterListener(this.gZA);
        MessageManager.getInstance().registerListener(this.gZA);
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CDN_IPLIST_CMD);
        MessageManager.getInstance().unRegisterListener(this.gZA);
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
        this.gZz = tbCdnTachometerModelCallBack;
    }

    public void getCDNIPList() {
        sendMessage(new HttpMessage(CmdConfigHttp.CDN_IPLIST_CMD));
    }

    public boolean getTestImageData(String str, String str2, String str3, String str4, boolean z) {
        String str5;
        boolean z2;
        int i;
        boolean z3 = false;
        if (str == null || str2 == null || str3 == null || str4 == null || !l.rf(str)) {
            return false;
        }
        try {
            long currentTimeMillis = System.currentTimeMillis();
            e eVar = new e();
            f fVar = new f(eVar);
            eVar.iu().setUrl(str);
            fVar.l(str2, str3, 1);
            byte[] bArr = eVar.iv().AU;
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            boolean z4 = eVar.iv().responseCode == 200;
            String str6 = "";
            if (z4) {
                if (bArr != null) {
                    int length = bArr.length;
                    String m = com.baidu.adp.lib.util.s.m(bArr);
                    if (!str4.equalsIgnoreCase(m)) {
                        str6 = "MD5Error_" + m + "_" + str4;
                        if (eVar.ix() != null && eVar.ix().Az != null && eVar.ix().Az.length() != 0) {
                            str6 = str6 + ":" + eVar.iv().responseCode + Constants.ACCEPT_TIME_SEPARATOR_SERVER + eVar.ix().Az;
                            eVar.b(null);
                        }
                        z4 = false;
                    }
                    str5 = str6;
                    z2 = z4;
                    i = length;
                } else {
                    str5 = "downSizeZero";
                    if (eVar.ix() == null || eVar.ix().Az == null || eVar.ix().Az.length() == 0) {
                        z2 = z4;
                        i = 0;
                    } else {
                        str5 = "downSizeZero:" + eVar.iv().responseCode + Constants.ACCEPT_TIME_SEPARATOR_SERVER + eVar.ix().Az;
                        eVar.b(null);
                        z2 = z4;
                        i = 0;
                    }
                }
            } else {
                str5 = "NETError_" + eVar.iv().responseCode + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (eVar.ix() != null ? eVar.ix().Az : null);
                z2 = z4;
                i = 0;
            }
            s.a(z2, str, str2, "0", str5, String.valueOf(i), currentTimeMillis2, z);
            z3 = z2;
            return z3;
        } catch (Exception e) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(DealIntentService.KEY_CLASS);
            stringBuffer.append(e.getClass());
            stringBuffer.append(" message");
            stringBuffer.append(e.getMessage());
            s.a(z3, str, str2, LivenessStat.TYPE_STRING_DEFAULT, stringBuffer.toString(), "0", 0L, z);
            return z3;
        }
    }
}
