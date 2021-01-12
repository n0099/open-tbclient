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
/* loaded from: classes10.dex */
public class a {
    private static a ozc;
    private cd aOf;
    private HttpMessageListener ibi;
    private List<av> ozd;
    private List<av> oze;
    private boolean ozf = false;

    private a() {
    }

    public static a ecb() {
        if (ozc == null) {
            synchronized (a.class) {
                if (ozc == null) {
                    ozc = new a();
                }
            }
        }
        return ozc;
    }

    public void bcU() {
        final an anVar = com.baidu.live.af.a.OJ().bru;
        if (anVar == null || anVar.aKD == null || anVar.aKD.aOf == null) {
            bWb();
        } else {
            new BdAsyncTask<cd, Void, Boolean>() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.a.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
                /* renamed from: a */
                public Boolean doInBackground(cd... cdVarArr) {
                    boolean z = false;
                    if (cdVarArr != null && cdVarArr.length != 0) {
                        if (!a.this.ozf) {
                            a.this.ozf = true;
                            cd cdVar = cdVarArr[0];
                            cd fg = cd.fg(d.xf().getString("audio_live_dating_anim", ""));
                            if (fg != null) {
                                if (a.this.a(cdVar.Bp(), fg.Bp())) {
                                    a.this.b(fg.Bp());
                                    z = true;
                                }
                                if (a.this.a(cdVar.Bq(), fg.Bq())) {
                                    a.this.b(fg.Bq());
                                    z = true;
                                }
                                if (a.this.a(cdVar.Br(), fg.Br())) {
                                    a.this.b(fg.Br());
                                    z = true;
                                }
                                if (a.this.a(cdVar.Bs(), fg.Bs())) {
                                    a.this.b(fg.Bs());
                                    z = true;
                                }
                                if (a.this.a(cdVar.Bt(), fg.Bt())) {
                                    a.this.b(fg.Bt());
                                    z = true;
                                }
                                if (a.this.a(cdVar.Bu(), fg.Bu())) {
                                    a.this.b(fg.Bu());
                                    z = true;
                                }
                                if (a.this.a(cdVar.Bv(), fg.Bv())) {
                                    a.this.b(fg.Bv());
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
                    a.this.aOf = anVar.aKD.aOf;
                    if (bool != null && bool.booleanValue()) {
                        d.xf().putString("audio_live_dating_anim", cd.a(a.this.aOf));
                    }
                    a.this.ecc();
                    a.this.zU(false);
                }
            }.execute(anVar.aKD.aOf);
        }
    }

    public void release() {
        MessageManager.getInstance().unRegisterListener(this.ibi);
        this.ibi = null;
        com.baidu.live.i.b.cz(23);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ecc() {
        if (this.aOf != null) {
            if (this.ozd == null) {
                this.ozd = new ArrayList();
            } else {
                this.ozd.clear();
            }
            ListUtils.add(this.ozd, this.aOf.Bs());
            ListUtils.add(this.ozd, this.aOf.Bp());
            ListUtils.add(this.ozd, this.aOf.Bq());
            ListUtils.add(this.ozd, this.aOf.Br());
            ListUtils.add(this.ozd, this.aOf.Bt());
            ListUtils.add(this.ozd, this.aOf.Bu());
            ListUtils.add(this.ozd, this.aOf.Bv());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zU(final boolean z) {
        if (!ListUtils.isEmpty(z ? this.oze : this.ozd)) {
            final av gr = gr(z ? this.oze : this.ozd);
            if (gr == null) {
                zU(z);
            } else {
                c.b(gr.getDownloadUrl(), gr.Bi(), new b.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.a.2
                    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.b.a
                    public void zV(boolean z2) {
                        if (!z && !z2) {
                            if (a.this.oze == null) {
                                a.this.oze = new ArrayList();
                            }
                            a.this.oze.add(gr);
                        }
                        a.this.zU(z || ListUtils.isEmpty(a.this.ozd));
                    }
                });
            }
        }
    }

    private void bWb() {
        if (this.ibi == null) {
            this.ibi = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_SYNC) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.a.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021011 && (httpResponsedMessage instanceof AlaSyncHttpResponseMessage)) {
                        a.this.bcU();
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.ibi);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(av avVar, av avVar2) {
        return (avVar2 == null || avVar == null || TextUtils.equals(avVar2.getDownloadUrl(), avVar.getDownloadUrl()) || TextUtils.equals(avVar2.Bi(), avVar.Bi())) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(av avVar) {
        if (!c(avVar)) {
            com.baidu.live.i.a.cleanDir(new File(com.baidu.live.ah.b.hk(avVar.Bi())));
        }
    }

    private static av gr(List<av> list) {
        if (ListUtils.isEmpty(list)) {
            return null;
        }
        return list.remove(0);
    }

    private static boolean c(av avVar) {
        return avVar == null || StringUtils.isNull(avVar.Bi(), true);
    }
}
