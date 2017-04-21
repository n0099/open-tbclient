package com.baidu.tieba.imageProblem.cdnOptimize;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.network.http.f;
import com.baidu.adp.lib.util.t;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.u;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.util.g;
/* loaded from: classes.dex */
public class TbCdnTachometerModel<T> extends BdBaseModel<T> {
    private TbCdnTachometerModelCallBack dpx;
    private HttpMessageListener dpy;
    public static final String IPLIST_ADDRESS_PATH = "c/s/checkcdn";
    public static final String IPLIST_ADDRESS = String.valueOf(TbConfig.SERVER_ADDRESS) + IPLIST_ADDRESS_PATH;

    /* loaded from: classes.dex */
    public interface TbCdnTachometerModelCallBack {
        void callBack(TbCdnIpListData tbCdnIpListData);
    }

    public TbCdnTachometerModel(TbPageContext<T> tbPageContext) {
        super(tbPageContext);
        this.dpx = null;
        this.dpy = new HttpMessageListener(CmdConfigHttp.CDN_IPLIST_CMD) { // from class: com.baidu.tieba.imageProblem.cdnOptimize.TbCdnTachometerModel.1
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
                        if (TbCdnTachometerModel.this.dpx != null) {
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
                        if (TbCdnTachometerModel.this.dpx != null) {
                            TbCdnTachometerModel.this.dpx.callBack(tbCdnIpListData);
                        }
                        if (tbCdnIpListData.dpq.size() == 0) {
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
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CDN_IPLIST_CMD, IPLIST_ADDRESS);
        tbHttpMessageTask.setResponsedClass(TbCdnGetIPListHttpResponseMsg.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().unRegisterListener(this.dpy);
        MessageManager.getInstance().registerListener(this.dpy);
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CDN_IPLIST_CMD);
        MessageManager.getInstance().unRegisterListener(this.dpy);
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
        this.dpx = tbCdnTachometerModelCallBack;
    }

    public void getCDNIPList() {
        sendMessage(new HttpMessage(CmdConfigHttp.CDN_IPLIST_CMD));
    }

    public boolean getTestImageData(String str, String str2, String str3, String str4, boolean z) {
        int i;
        if (str == null || str2 == null || str3 == null || str4 == null) {
            return false;
        }
        if (g.gf(str)) {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                f fVar = new f();
                com.baidu.tbadk.core.util.a.f fVar2 = new com.baidu.tbadk.core.util.a.f(fVar);
                fVar.fB().setUrl(str);
                fVar2.d(str2, str3, 1);
                byte[] bArr = fVar.fC().vS;
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                boolean z2 = fVar.fC().responseCode == 200;
                String str5 = "";
                if (z2) {
                    if (bArr != null) {
                        i = bArr.length;
                        String md5 = t.toMd5(bArr);
                        if (!str4.equalsIgnoreCase(md5)) {
                            String str6 = "MD5Error_" + md5 + "_" + str4;
                            if (fVar.fE() != null && fVar.fE().vz != null && fVar.fE().vz.length() != 0) {
                                str6 = String.valueOf(str6) + ":" + fVar.fC().responseCode + "-" + fVar.fE().vz;
                                fVar.b(null);
                            }
                            str5 = str6;
                            z2 = false;
                        }
                    } else {
                        str5 = "downSizeZero";
                        if (fVar.fE() == null || fVar.fE().vz == null || fVar.fE().vz.length() == 0) {
                            i = 0;
                        } else {
                            str5 = String.valueOf("downSizeZero") + ":" + fVar.fC().responseCode + "-" + fVar.fE().vz;
                            fVar.b(null);
                            i = 0;
                        }
                    }
                } else {
                    str5 = "NETError_" + fVar.fC().responseCode + "-" + (fVar.fE() != null ? fVar.fE().vz : null);
                    i = 0;
                }
                u.a(z2, str, str2, "0", str5, String.valueOf(i), currentTimeMillis2, z);
                return z2;
            } catch (Exception e) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("class");
                stringBuffer.append(e.getClass());
                stringBuffer.append(" message");
                stringBuffer.append(e.getMessage());
                u.a(false, str, str2, "-1", stringBuffer.toString(), "0", 0L, z);
                return false;
            }
        }
        return false;
    }
}
