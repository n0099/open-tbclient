package com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a;

import android.text.TextUtils;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.asynctask.BdAsyncTask;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.d;
import com.baidu.live.data.ak;
import com.baidu.live.data.as;
import com.baidu.live.data.ca;
import com.baidu.live.message.AlaSyncHttpResponseMessage;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.b;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    private static a ogi;
    private ca aQG;
    private HttpMessageListener hJG;
    private List<as> ogj;
    private List<as> ogk;
    private boolean ogl = false;

    private a() {
    }

    public static a eae() {
        if (ogi == null) {
            synchronized (a.class) {
                if (ogi == null) {
                    ogi = new a();
                }
            }
        }
        return ogi;
    }

    public void bbU() {
        final ak akVar = com.baidu.live.aa.a.PQ().bod;
        if (akVar == null || akVar.aNy == null || akVar.aNy.aQG == null) {
            bUk();
        } else {
            new BdAsyncTask<ca, Void, Boolean>() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.a.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
                /* renamed from: a */
                public Boolean doInBackground(ca... caVarArr) {
                    boolean z = false;
                    if (caVarArr != null && caVarArr.length != 0) {
                        if (!a.this.ogl) {
                            a.this.ogl = true;
                            ca caVar = caVarArr[0];
                            ca gt = ca.gt(d.AZ().getString("audio_live_dating_anim", ""));
                            if (gt != null) {
                                if (a.this.a(caVar.ES(), gt.ES())) {
                                    a.this.b(gt.ES());
                                    z = true;
                                }
                                if (a.this.a(caVar.ET(), gt.ET())) {
                                    a.this.b(gt.ET());
                                    z = true;
                                }
                                if (a.this.a(caVar.EU(), gt.EU())) {
                                    a.this.b(gt.EU());
                                    z = true;
                                }
                                if (a.this.a(caVar.EV(), gt.EV())) {
                                    a.this.b(gt.EV());
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
                    a.this.aQG = akVar.aNy.aQG;
                    if (bool != null && bool.booleanValue()) {
                        d.AZ().putString("audio_live_dating_anim", ca.a(a.this.aQG));
                    }
                    a.this.eaf();
                    a.this.zl(false);
                }
            }.execute(akVar.aNy.aQG);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eaf() {
        if (this.aQG != null) {
            if (this.ogj == null) {
                this.ogj = new ArrayList();
            } else {
                this.ogj.clear();
            }
            ListUtils.add(this.ogj, this.aQG.EV());
            ListUtils.add(this.ogj, this.aQG.ES());
            ListUtils.add(this.ogj, this.aQG.ET());
            ListUtils.add(this.ogj, this.aQG.EU());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zl(final boolean z) {
        if (!ListUtils.isEmpty(z ? this.ogk : this.ogj)) {
            final as gl = gl(z ? this.ogk : this.ogj);
            if (gl == null) {
                zl(z);
            } else {
                c.b(gl.getDownloadUrl(), gl.EL(), new b.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.a.2
                    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.b.a
                    public void zm(boolean z2) {
                        if (!z && !z2) {
                            if (a.this.ogk == null) {
                                a.this.ogk = new ArrayList();
                            }
                            a.this.ogk.add(gl);
                        }
                        a.this.zl(z || ListUtils.isEmpty(a.this.ogj));
                    }
                });
            }
        }
    }

    private void bUk() {
        if (this.hJG == null) {
            this.hJG = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_SYNC) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.a.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021011 && (httpResponsedMessage instanceof AlaSyncHttpResponseMessage)) {
                        a.this.bbU();
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.hJG);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(as asVar, as asVar2) {
        return (asVar2 == null || asVar == null || TextUtils.equals(asVar2.getDownloadUrl(), asVar.getDownloadUrl()) || TextUtils.equals(asVar2.EL(), asVar.EL())) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(as asVar) {
        if (!c(asVar)) {
            com.baidu.live.f.a.cleanDir(new File(com.baidu.live.ac.b.ij(asVar.EL())));
        }
    }

    private static as gl(List<as> list) {
        if (ListUtils.isEmpty(list)) {
            return null;
        }
        return list.remove(0);
    }

    private static boolean c(as asVar) {
        return asVar == null || StringUtils.isNull(asVar.EL(), true);
    }
}
