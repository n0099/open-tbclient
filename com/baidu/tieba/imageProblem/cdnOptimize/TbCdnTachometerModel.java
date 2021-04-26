package com.baidu.tieba.imageProblem.cdnOptimize;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ImageLogger;
import com.baidu.tbadk.core.util.httpNet.ImgHttpClient;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tbadk.task.TbHttpMessageTask;
import d.a.c.e.j.a.e;
import d.a.c.e.p.q;
import d.a.i0.z0.o;
/* loaded from: classes4.dex */
public class TbCdnTachometerModel<T> extends BdBaseModel<T> {

    /* renamed from: e  reason: collision with root package name */
    public TbCdnTachometerModelCallBack f18453e;

    /* renamed from: f  reason: collision with root package name */
    public HttpMessageListener f18454f;
    public static final String IPLIST_ADDRESS_PATH = "c/s/checkcdn";
    public static final String IPLIST_ADDRESS = TbConfig.SERVER_ADDRESS + IPLIST_ADDRESS_PATH;

    /* loaded from: classes4.dex */
    public interface TbCdnTachometerModelCallBack {
        void callBack(TbCdnIpListData tbCdnIpListData);
    }

    public TbCdnTachometerModel(TbPageContext<T> tbPageContext) {
        super(tbPageContext);
        this.f18453e = null;
        this.f18454f = new HttpMessageListener(CmdConfigHttp.CDN_IPLIST_CMD) { // from class: com.baidu.tieba.imageProblem.cdnOptimize.TbCdnTachometerModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                String str;
                if (httpResponsedMessage != null && TbCdnTachometerModel.this.unique_id == httpResponsedMessage.getOrginalMessage().getTag() && (httpResponsedMessage instanceof TbCdnGetIPListHttpResponseMsg)) {
                    TbCdnIpListData tbCdnIpListData = ((TbCdnGetIPListHttpResponseMsg) httpResponsedMessage).ipListData;
                    int i2 = -1;
                    boolean z = false;
                    boolean z2 = true;
                    if (httpResponsedMessage.getError() != 0 || tbCdnIpListData == null || tbCdnIpListData.f18434a != 0) {
                        if (TbCdnTachometerModel.this.f18453e != null) {
                            i2 = httpResponsedMessage.getError();
                            String errorString = httpResponsedMessage.getErrorString();
                            if (httpResponsedMessage.getError() == 0) {
                                i2 = tbCdnIpListData.f18434a;
                                str = tbCdnIpListData.f18435b;
                                ImageLogger.getCDNListError(z, z2, String.valueOf(i2), str);
                            }
                            str = errorString;
                            z2 = false;
                            ImageLogger.getCDNListError(z, z2, String.valueOf(i2), str);
                        }
                    } else {
                        if (TbCdnTachometerModel.this.f18453e != null) {
                            TbCdnTachometerModel.this.f18453e.callBack(tbCdnIpListData);
                        }
                        if (tbCdnIpListData.f18438e.size() == 0) {
                            str = "noList";
                            z = true;
                            z2 = false;
                            ImageLogger.getCDNListError(z, z2, String.valueOf(i2), str);
                        }
                    }
                    str = "";
                    z = true;
                    z2 = false;
                    ImageLogger.getCDNListError(z, z2, String.valueOf(i2), str);
                }
            }
        };
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CDN_IPLIST_CMD, IPLIST_ADDRESS);
        tbHttpMessageTask.setResponsedClass(TbCdnGetIPListHttpResponseMsg.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().unRegisterListener(this.f18454f);
        MessageManager.getInstance().registerListener(this.f18454f);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CDN_IPLIST_CMD);
        MessageManager.getInstance().unRegisterListener(this.f18454f);
    }

    public void getCDNIPList() {
        sendMessage(new HttpMessage(CmdConfigHttp.CDN_IPLIST_CMD));
    }

    public boolean getTestImageData(String str, String str2, String str3, String str4, boolean z) {
        String str5;
        String str6;
        boolean z2;
        int i2;
        if (str == null || str2 == null || str3 == null || str4 == null || !o.b(str)) {
            return false;
        }
        try {
            long currentTimeMillis = System.currentTimeMillis();
            e eVar = new e();
            ImgHttpClient imgHttpClient = new ImgHttpClient(eVar);
            eVar.b().s(str);
            boolean z3 = true;
            imgHttpClient.getNetDataWithIp(str2, str3, 1);
            byte[] bArr = eVar.c().f39739h;
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            if (eVar.c().f39733b != 200) {
                z3 = false;
            }
            String str7 = "";
            if (!z3) {
                str5 = "NETError_" + eVar.c().f39733b + "-" + (eVar.a() != null ? eVar.a().f39719h : null);
            } else if (bArr != null) {
                i2 = bArr.length;
                String d2 = q.d(bArr);
                if (!str4.equalsIgnoreCase(d2)) {
                    String str8 = "MD5Error_" + d2 + "_" + str4;
                    if (eVar.a() != null && eVar.a().f39719h != null && eVar.a().f39719h.length() != 0) {
                        str8 = str8 + ":" + eVar.c().f39733b + "-" + eVar.a().f39719h;
                        eVar.f(null);
                    }
                    str7 = str8;
                    z3 = false;
                }
                str6 = str7;
                z2 = z3;
                ImageLogger.tachometerCdnIpLog(z2, str, str2, "0", str6, String.valueOf(i2), currentTimeMillis2, z);
                return z2;
            } else {
                str5 = "downSizeZero";
                if (eVar.a() != null && eVar.a().f39719h != null && eVar.a().f39719h.length() != 0) {
                    str5 = "downSizeZero:" + eVar.c().f39733b + "-" + eVar.a().f39719h;
                    eVar.f(null);
                }
            }
            str6 = str5;
            z2 = z3;
            i2 = 0;
            ImageLogger.tachometerCdnIpLog(z2, str, str2, "0", str6, String.valueOf(i2), currentTimeMillis2, z);
            return z2;
        } catch (Exception e2) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(DealIntentService.KEY_CLASS);
            stringBuffer.append(e2.getClass());
            stringBuffer.append(" message");
            stringBuffer.append(e2.getMessage());
            ImageLogger.tachometerCdnIpLog(false, str, str2, "-1", stringBuffer.toString(), "0", 0L, z);
            return false;
        }
    }

    public void setCndTachometerModelCallBack(TbCdnTachometerModelCallBack tbCdnTachometerModelCallBack) {
        this.f18453e = tbCdnTachometerModelCallBack;
    }
}
