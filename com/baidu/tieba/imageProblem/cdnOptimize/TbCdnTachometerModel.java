package com.baidu.tieba.imageProblem.cdnOptimize;

import com.baidu.adp.base.e;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.network.http.f;
import com.baidu.adp.lib.util.t;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.util.h;
/* loaded from: classes.dex */
public class TbCdnTachometerModel<T> extends e<T> {
    public static final String cAZ = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/checkcdn";
    private TbCdnTachometerModelCallBack cAY;
    private HttpMessageListener cBa;

    /* loaded from: classes.dex */
    public interface TbCdnTachometerModelCallBack {
        void callBack(TbCdnIpListData tbCdnIpListData);
    }

    public TbCdnTachometerModel(TbPageContext<T> tbPageContext) {
        super(tbPageContext);
        this.cAY = null;
        this.cBa = new HttpMessageListener(CmdConfigHttp.CDN_IPLIST_CMD) { // from class: com.baidu.tieba.imageProblem.cdnOptimize.TbCdnTachometerModel.1
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
                        if (TbCdnTachometerModel.this.cAY != null) {
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
                        if (TbCdnTachometerModel.this.cAY != null) {
                            TbCdnTachometerModel.this.cAY.callBack(tbCdnIpListData);
                        }
                        if (tbCdnIpListData.cAR.size() == 0) {
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
                    v.a(z, z2, String.valueOf(i), str);
                }
            }
        };
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CDN_IPLIST_CMD, cAZ);
        tbHttpMessageTask.setResponsedClass(TbCdnGetIPListHttpResponseMsg.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().unRegisterListener(this.cBa);
        MessageManager.getInstance().registerListener(this.cBa);
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CDN_IPLIST_CMD);
        MessageManager.getInstance().unRegisterListener(this.cBa);
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
        this.cAY = tbCdnTachometerModelCallBack;
    }

    public void getCDNIPList() {
        sendMessage(new HttpMessage(CmdConfigHttp.CDN_IPLIST_CMD));
    }

    public boolean getTestImageData(String str, String str2, String str3, String str4, boolean z) {
        int i;
        if (str == null || str2 == null || str3 == null || str4 == null) {
            return false;
        }
        if (h.gh(str)) {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                f fVar = new f();
                com.baidu.tbadk.core.util.a.f fVar2 = new com.baidu.tbadk.core.util.a.f(fVar);
                fVar.du().setUrl(str);
                fVar2.d(str2, str3, 1);
                byte[] bArr = fVar.dv().lG;
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                boolean z2 = fVar.dv().responseCode == 200;
                String str5 = "";
                if (z2) {
                    if (bArr != null) {
                        i = bArr.length;
                        String md5 = t.toMd5(bArr);
                        if (!str4.equalsIgnoreCase(md5)) {
                            String str6 = "MD5Error_" + md5 + "_" + str4;
                            if (fVar.dx() != null && fVar.dx().ln != null && fVar.dx().ln.length() != 0) {
                                str6 = String.valueOf(str6) + ":" + fVar.dv().responseCode + "-" + fVar.dx().ln;
                                fVar.b(null);
                            }
                            str5 = str6;
                            z2 = false;
                        }
                    } else {
                        str5 = "downSizeZero";
                        if (fVar.dx() == null || fVar.dx().ln == null || fVar.dx().ln.length() == 0) {
                            i = 0;
                        } else {
                            str5 = String.valueOf("downSizeZero") + ":" + fVar.dv().responseCode + "-" + fVar.dx().ln;
                            fVar.b(null);
                            i = 0;
                        }
                    }
                } else {
                    str5 = "NETError_" + fVar.dv().responseCode + "-" + (fVar.dx() != null ? fVar.dx().ln : null);
                    i = 0;
                }
                v.a(z2, str, str2, "0", str5, String.valueOf(i), currentTimeMillis2, z);
                return z2;
            } catch (Exception e) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("class");
                stringBuffer.append(e.getClass());
                stringBuffer.append(" message");
                stringBuffer.append(e.getMessage());
                v.a(false, str, str2, "-1", stringBuffer.toString(), "0", 0L, z);
                return false;
            }
        }
        return false;
    }
}
