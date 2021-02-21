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
/* loaded from: classes11.dex */
public class a {
    private static a oJk;
    private HttpMessageListener ifU;
    private ck oJl;
    private List<az> oJm;
    private List<az> oJn;
    private boolean oJo = false;

    private a() {
    }

    public static a eex() {
        if (oJk == null) {
            synchronized (a.class) {
                if (oJk == null) {
                    oJk = new a();
                }
            }
        }
        return oJk;
    }

    public void bdh() {
        final ar arVar = com.baidu.live.ae.a.Qj().buX;
        if (arVar == null || arVar.aNt == null || arVar.aNt.aRi == null) {
            bWM();
        } else {
            new BdAsyncTask<ck, Void, Boolean>() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.a.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
                /* renamed from: a */
                public Boolean doInBackground(ck... ckVarArr) {
                    boolean z = false;
                    if (ckVarArr != null && ckVarArr.length != 0) {
                        if (!a.this.oJo) {
                            a.this.oJo = true;
                            ck ckVar = ckVarArr[0];
                            ck fB = ck.fB(d.xc().getString("audio_live_dating_anim", ""));
                            if (fB != null) {
                                if (a.this.a(ckVar.CC(), fB.CC())) {
                                    a.this.b(fB.CC());
                                    z = true;
                                }
                                if (a.this.a(ckVar.CD(), fB.CD())) {
                                    a.this.b(fB.CD());
                                    z = true;
                                }
                                if (a.this.a(ckVar.CE(), fB.CE())) {
                                    a.this.b(fB.CE());
                                    z = true;
                                }
                                if (a.this.a(ckVar.CF(), fB.CF())) {
                                    a.this.b(fB.CF());
                                    z = true;
                                }
                                if (a.this.a(ckVar.CG(), fB.CG())) {
                                    a.this.b(fB.CG());
                                    z = true;
                                }
                                if (a.this.a(ckVar.CH(), fB.CH())) {
                                    a.this.b(fB.CH());
                                    z = true;
                                }
                                if (a.this.a(ckVar.CI(), fB.CI())) {
                                    a.this.b(fB.CI());
                                    z = true;
                                }
                                if (a.this.a(ckVar.CJ(), fB.CJ())) {
                                    a.this.b(fB.CJ());
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
                    a.this.oJl = arVar.aNt.aRi;
                    if (bool != null && bool.booleanValue()) {
                        d.xc().putString("audio_live_dating_anim", ck.a(a.this.oJl));
                    }
                    a.this.eey();
                    a.this.An(false);
                }
            }.execute(arVar.aNt.aRi);
        }
    }

    public void release() {
        MessageManager.getInstance().unRegisterListener(this.ifU);
        this.ifU = null;
        com.baidu.live.h.b.cE(23);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eey() {
        if (this.oJl != null) {
            if (this.oJm == null) {
                this.oJm = new ArrayList();
            } else {
                this.oJm.clear();
            }
            ListUtils.add(this.oJm, this.oJl.CF());
            ListUtils.add(this.oJm, this.oJl.CC());
            ListUtils.add(this.oJm, this.oJl.CD());
            ListUtils.add(this.oJm, this.oJl.CE());
            ListUtils.add(this.oJm, this.oJl.CG());
            ListUtils.add(this.oJm, this.oJl.CH());
            ListUtils.add(this.oJm, this.oJl.CI());
            ListUtils.add(this.oJm, this.oJl.CJ());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void An(final boolean z) {
        if (!ListUtils.isEmpty(z ? this.oJn : this.oJm)) {
            final az gp = gp(z ? this.oJn : this.oJm);
            if (gp == null) {
                An(z);
            } else {
                c.b(gp.getDownloadUrl(), gp.Cv(), new b.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.a.2
                    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.b.a
                    public void Ao(boolean z2) {
                        if (!z && !z2) {
                            if (a.this.oJn == null) {
                                a.this.oJn = new ArrayList();
                            }
                            a.this.oJn.add(gp);
                        }
                        a.this.An(z || ListUtils.isEmpty(a.this.oJm));
                    }
                });
            }
        }
    }

    private void bWM() {
        if (this.ifU == null) {
            this.ifU = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_SYNC) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.a.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021011 && (httpResponsedMessage instanceof AlaSyncHttpResponseMessage)) {
                        a.this.bdh();
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.ifU);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(az azVar, az azVar2) {
        return (azVar2 == null || azVar == null || TextUtils.equals(azVar2.getDownloadUrl(), azVar.getDownloadUrl()) || TextUtils.equals(azVar2.Cv(), azVar.Cv())) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(az azVar) {
        if (!c(azVar)) {
            com.baidu.live.h.a.cleanDir(new File(com.baidu.live.storage.b.hG(azVar.Cv())));
        }
    }

    private static az gp(List<az> list) {
        if (ListUtils.isEmpty(list)) {
            return null;
        }
        return list.remove(0);
    }

    private static boolean c(az azVar) {
        return azVar == null || StringUtils.isNull(azVar.Cv(), true);
    }
}
