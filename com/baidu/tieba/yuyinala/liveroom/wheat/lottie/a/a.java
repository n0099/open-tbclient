package com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a;

import android.text.TextUtils;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.asynctask.BdAsyncTask;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.d;
import com.baidu.live.data.ar;
import com.baidu.live.data.az;
import com.baidu.live.data.ck;
import com.baidu.live.message.AlaSyncHttpResponseMessage;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.b;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class a {
    private static a oLp;
    private HttpMessageListener ihD;
    private ck oLq;
    private List<az> oLr;
    private List<az> oLs;
    private boolean oLt = false;

    private a() {
    }

    public static a eeF() {
        if (oLp == null) {
            synchronized (a.class) {
                if (oLp == null) {
                    oLp = new a();
                }
            }
        }
        return oLp;
    }

    public void bdj() {
        final ar arVar = com.baidu.live.ae.a.Qm().bwx;
        if (arVar == null || arVar.aOT == null || arVar.aOT.aSI == null) {
            bWS();
        } else {
            new BdAsyncTask<ck, Void, Boolean>() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.a.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
                /* renamed from: a */
                public Boolean doInBackground(ck... ckVarArr) {
                    boolean z = false;
                    if (ckVarArr != null && ckVarArr.length != 0) {
                        if (!a.this.oLt) {
                            a.this.oLt = true;
                            ck ckVar = ckVarArr[0];
                            ck fH = ck.fH(d.xf().getString("audio_live_dating_anim", ""));
                            if (fH != null) {
                                if (a.this.a(ckVar.CF(), fH.CF())) {
                                    a.this.b(fH.CF());
                                    z = true;
                                }
                                if (a.this.a(ckVar.CG(), fH.CG())) {
                                    a.this.b(fH.CG());
                                    z = true;
                                }
                                if (a.this.a(ckVar.CH(), fH.CH())) {
                                    a.this.b(fH.CH());
                                    z = true;
                                }
                                if (a.this.a(ckVar.CI(), fH.CI())) {
                                    a.this.b(fH.CI());
                                    z = true;
                                }
                                if (a.this.a(ckVar.CJ(), fH.CJ())) {
                                    a.this.b(fH.CJ());
                                    z = true;
                                }
                                if (a.this.a(ckVar.CK(), fH.CK())) {
                                    a.this.b(fH.CK());
                                    z = true;
                                }
                                if (a.this.a(ckVar.CL(), fH.CL())) {
                                    a.this.b(fH.CL());
                                    z = true;
                                }
                                if (a.this.a(ckVar.CM(), fH.CM())) {
                                    a.this.b(fH.CM());
                                    z = true;
                                }
                            }
                            return Boolean.valueOf(z);
                        }
                        return false;
                    }
                    return false;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
                public void onPostExecute(Boolean bool) {
                    super.onPostExecute((AnonymousClass1) bool);
                    a.this.oLq = arVar.aOT.aSI;
                    if (bool != null && bool.booleanValue()) {
                        d.xf().putString("audio_live_dating_anim", ck.a(a.this.oLq));
                    }
                    a.this.eeG();
                    a.this.Am(false);
                }
            }.execute(arVar.aOT.aSI);
        }
    }

    public void release() {
        MessageManager.getInstance().unRegisterListener(this.ihD);
        this.ihD = null;
        com.baidu.live.h.b.cF(23);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eeG() {
        if (this.oLq != null) {
            if (this.oLr == null) {
                this.oLr = new ArrayList();
            } else {
                this.oLr.clear();
            }
            ListUtils.add(this.oLr, this.oLq.CI());
            ListUtils.add(this.oLr, this.oLq.CF());
            ListUtils.add(this.oLr, this.oLq.CG());
            ListUtils.add(this.oLr, this.oLq.CH());
            ListUtils.add(this.oLr, this.oLq.CJ());
            ListUtils.add(this.oLr, this.oLq.CK());
            ListUtils.add(this.oLr, this.oLq.CL());
            ListUtils.add(this.oLr, this.oLq.CM());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Am(final boolean z) {
        if (!ListUtils.isEmpty(z ? this.oLs : this.oLr)) {
            final az gp = gp(z ? this.oLs : this.oLr);
            if (gp == null) {
                Am(z);
            } else {
                c.b(gp.getDownloadUrl(), gp.Cy(), new b.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.a.2
                    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.b.a
                    public void An(boolean z2) {
                        if (!z && !z2) {
                            if (a.this.oLs == null) {
                                a.this.oLs = new ArrayList();
                            }
                            a.this.oLs.add(gp);
                        }
                        a.this.Am(z || ListUtils.isEmpty(a.this.oLr));
                    }
                });
            }
        }
    }

    private void bWS() {
        if (this.ihD == null) {
            this.ihD = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_SYNC) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.a.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021011 && (httpResponsedMessage instanceof AlaSyncHttpResponseMessage)) {
                        a.this.bdj();
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.ihD);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(az azVar, az azVar2) {
        return (azVar2 == null || azVar == null || TextUtils.equals(azVar2.getDownloadUrl(), azVar.getDownloadUrl()) || TextUtils.equals(azVar2.Cy(), azVar.Cy())) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(az azVar) {
        if (!c(azVar)) {
            com.baidu.live.h.a.cleanDir(new File(com.baidu.live.storage.b.hM(azVar.Cy())));
        }
    }

    private static az gp(List<az> list) {
        if (ListUtils.isEmpty(list)) {
            return null;
        }
        return list.remove(0);
    }

    private static boolean c(az azVar) {
        return azVar == null || StringUtils.isNull(azVar.Cy(), true);
    }
}
