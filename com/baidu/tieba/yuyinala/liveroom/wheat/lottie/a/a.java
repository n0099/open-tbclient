package com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a;

import android.text.TextUtils;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.asynctask.BdAsyncTask;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.d;
import com.baidu.live.data.an;
import com.baidu.live.data.av;
import com.baidu.live.data.cd;
import com.baidu.live.message.AlaSyncHttpResponseMessage;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.b;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class a {
    private static a oDI;
    private cd aSS;
    private HttpMessageListener ifT;
    private List<av> oDJ;
    private List<av> oDK;
    private boolean oDL = false;

    private a() {
    }

    public static a efS() {
        if (oDI == null) {
            synchronized (a.class) {
                if (oDI == null) {
                    oDI = new a();
                }
            }
        }
        return oDI;
    }

    public void bgN() {
        final an anVar = com.baidu.live.af.a.SE().bwi;
        if (anVar == null || anVar.aPq == null || anVar.aPq.aSS == null) {
            bZS();
        } else {
            new BdAsyncTask<cd, Void, Boolean>() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.a.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
                /* renamed from: a */
                public Boolean doInBackground(cd... cdVarArr) {
                    boolean z = false;
                    if (cdVarArr != null && cdVarArr.length != 0) {
                        if (!a.this.oDL) {
                            a.this.oDL = true;
                            cd cdVar = cdVarArr[0];
                            cd gr = cd.gr(d.Ba().getString("audio_live_dating_anim", ""));
                            if (gr != null) {
                                if (a.this.a(cdVar.Fk(), gr.Fk())) {
                                    a.this.b(gr.Fk());
                                    z = true;
                                }
                                if (a.this.a(cdVar.Fl(), gr.Fl())) {
                                    a.this.b(gr.Fl());
                                    z = true;
                                }
                                if (a.this.a(cdVar.Fm(), gr.Fm())) {
                                    a.this.b(gr.Fm());
                                    z = true;
                                }
                                if (a.this.a(cdVar.Fn(), gr.Fn())) {
                                    a.this.b(gr.Fn());
                                    z = true;
                                }
                                if (a.this.a(cdVar.Fo(), gr.Fo())) {
                                    a.this.b(gr.Fo());
                                    z = true;
                                }
                                if (a.this.a(cdVar.Fp(), gr.Fp())) {
                                    a.this.b(gr.Fp());
                                    z = true;
                                }
                                if (a.this.a(cdVar.Fq(), gr.Fq())) {
                                    a.this.b(gr.Fq());
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
                    a.this.aSS = anVar.aPq.aSS;
                    if (bool != null && bool.booleanValue()) {
                        d.Ba().putString("audio_live_dating_anim", cd.a(a.this.aSS));
                    }
                    a.this.efT();
                    a.this.zY(false);
                }
            }.execute(anVar.aPq.aSS);
        }
    }

    public void release() {
        MessageManager.getInstance().unRegisterListener(this.ifT);
        this.ifT = null;
        com.baidu.live.i.b.ef(23);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void efT() {
        if (this.aSS != null) {
            if (this.oDJ == null) {
                this.oDJ = new ArrayList();
            } else {
                this.oDJ.clear();
            }
            ListUtils.add(this.oDJ, this.aSS.Fn());
            ListUtils.add(this.oDJ, this.aSS.Fk());
            ListUtils.add(this.oDJ, this.aSS.Fl());
            ListUtils.add(this.oDJ, this.aSS.Fm());
            ListUtils.add(this.oDJ, this.aSS.Fo());
            ListUtils.add(this.oDJ, this.aSS.Fp());
            ListUtils.add(this.oDJ, this.aSS.Fq());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zY(final boolean z) {
        if (!ListUtils.isEmpty(z ? this.oDK : this.oDJ)) {
            final av gr = gr(z ? this.oDK : this.oDJ);
            if (gr == null) {
                zY(z);
            } else {
                c.b(gr.getDownloadUrl(), gr.Fd(), new b.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.a.2
                    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.b.a
                    public void zZ(boolean z2) {
                        if (!z && !z2) {
                            if (a.this.oDK == null) {
                                a.this.oDK = new ArrayList();
                            }
                            a.this.oDK.add(gr);
                        }
                        a.this.zY(z || ListUtils.isEmpty(a.this.oDJ));
                    }
                });
            }
        }
    }

    private void bZS() {
        if (this.ifT == null) {
            this.ifT = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_SYNC) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.a.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021011 && (httpResponsedMessage instanceof AlaSyncHttpResponseMessage)) {
                        a.this.bgN();
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.ifT);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(av avVar, av avVar2) {
        return (avVar2 == null || avVar == null || TextUtils.equals(avVar2.getDownloadUrl(), avVar.getDownloadUrl()) || TextUtils.equals(avVar2.Fd(), avVar.Fd())) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(av avVar) {
        if (!c(avVar)) {
            com.baidu.live.i.a.cleanDir(new File(com.baidu.live.ah.b.iv(avVar.Fd())));
        }
    }

    private static av gr(List<av> list) {
        if (ListUtils.isEmpty(list)) {
            return null;
        }
        return list.remove(0);
    }

    private static boolean c(av avVar) {
        return avVar == null || StringUtils.isNull(avVar.Fd(), true);
    }
}
