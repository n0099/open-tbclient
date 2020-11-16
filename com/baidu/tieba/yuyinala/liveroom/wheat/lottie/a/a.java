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
    private static a ohL;
    private ca aOV;
    private HttpMessageListener hJn;
    private List<as> ohM;
    private List<as> ohN;
    private boolean ohO = false;

    private a() {
    }

    public static a ead() {
        if (ohL == null) {
            synchronized (a.class) {
                if (ohL == null) {
                    ohL = new a();
                }
            }
        }
        return ohL;
    }

    public void bbn() {
        final ak akVar = com.baidu.live.aa.a.Ph().bms;
        if (akVar == null || akVar.aLN == null || akVar.aLN.aOV == null) {
            bTD();
        } else {
            new BdAsyncTask<ca, Void, Boolean>() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.a.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
                /* renamed from: a */
                public Boolean doInBackground(ca... caVarArr) {
                    boolean z = false;
                    if (caVarArr != null && caVarArr.length != 0) {
                        if (!a.this.ohO) {
                            a.this.ohO = true;
                            ca caVar = caVarArr[0];
                            ca gm = ca.gm(d.Aq().getString("audio_live_dating_anim", ""));
                            if (gm != null) {
                                if (a.this.a(caVar.Ej(), gm.Ej())) {
                                    a.this.b(gm.Ej());
                                    z = true;
                                }
                                if (a.this.a(caVar.Ek(), gm.Ek())) {
                                    a.this.b(gm.Ek());
                                    z = true;
                                }
                                if (a.this.a(caVar.El(), gm.El())) {
                                    a.this.b(gm.El());
                                    z = true;
                                }
                                if (a.this.a(caVar.Em(), gm.Em())) {
                                    a.this.b(gm.Em());
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
                    a.this.aOV = akVar.aLN.aOV;
                    if (bool != null && bool.booleanValue()) {
                        d.Aq().putString("audio_live_dating_anim", ca.a(a.this.aOV));
                    }
                    a.this.eae();
                    a.this.zs(false);
                }
            }.execute(akVar.aLN.aOV);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eae() {
        if (this.aOV != null) {
            if (this.ohM == null) {
                this.ohM = new ArrayList();
            } else {
                this.ohM.clear();
            }
            ListUtils.add(this.ohM, this.aOV.Em());
            ListUtils.add(this.ohM, this.aOV.Ej());
            ListUtils.add(this.ohM, this.aOV.Ek());
            ListUtils.add(this.ohM, this.aOV.El());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zs(final boolean z) {
        if (!ListUtils.isEmpty(z ? this.ohN : this.ohM)) {
            final as gl = gl(z ? this.ohN : this.ohM);
            if (gl == null) {
                zs(z);
            } else {
                c.b(gl.getDownloadUrl(), gl.Ec(), new b.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.a.2
                    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.b.a
                    public void zt(boolean z2) {
                        if (!z && !z2) {
                            if (a.this.ohN == null) {
                                a.this.ohN = new ArrayList();
                            }
                            a.this.ohN.add(gl);
                        }
                        a.this.zs(z || ListUtils.isEmpty(a.this.ohM));
                    }
                });
            }
        }
    }

    private void bTD() {
        if (this.hJn == null) {
            this.hJn = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_SYNC) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.a.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021011 && (httpResponsedMessage instanceof AlaSyncHttpResponseMessage)) {
                        a.this.bbn();
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.hJn);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(as asVar, as asVar2) {
        return (asVar2 == null || asVar == null || TextUtils.equals(asVar2.getDownloadUrl(), asVar.getDownloadUrl()) || TextUtils.equals(asVar2.Ec(), asVar.Ec())) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(as asVar) {
        if (!c(asVar)) {
            com.baidu.live.f.a.cleanDir(new File(com.baidu.live.ac.b.id(asVar.Ec())));
        }
    }

    private static as gl(List<as> list) {
        if (ListUtils.isEmpty(list)) {
            return null;
        }
        return list.remove(0);
    }

    private static boolean c(as asVar) {
        return asVar == null || StringUtils.isNull(asVar.Ec(), true);
    }
}
