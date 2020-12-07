package com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a;

import android.text.TextUtils;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.asynctask.BdAsyncTask;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.d;
import com.baidu.live.data.al;
import com.baidu.live.data.at;
import com.baidu.live.data.cc;
import com.baidu.live.message.AlaSyncHttpResponseMessage;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.b;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    private static a owL;
    private cc aRX;
    private HttpMessageListener hTr;
    private List<at> owM;
    private List<at> owN;
    private boolean owO = false;

    private a() {
    }

    public static a efI() {
        if (owL == null) {
            synchronized (a.class) {
                if (owL == null) {
                    owL = new a();
                }
            }
        }
        return owL;
    }

    public void bes() {
        final al alVar = com.baidu.live.ae.a.RB().brA;
        if (alVar == null || alVar.aOJ == null || alVar.aOJ.aRX == null) {
            bXm();
        } else {
            new BdAsyncTask<cc, Void, Boolean>() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.a.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
                /* renamed from: a */
                public Boolean doInBackground(cc... ccVarArr) {
                    boolean z = false;
                    if (ccVarArr != null && ccVarArr.length != 0) {
                        if (!a.this.owO) {
                            a.this.owO = true;
                            cc ccVar = ccVarArr[0];
                            cc gI = cc.gI(d.BM().getString("audio_live_dating_anim", ""));
                            if (gI != null) {
                                if (a.this.a(ccVar.FU(), gI.FU())) {
                                    a.this.b(gI.FU());
                                    z = true;
                                }
                                if (a.this.a(ccVar.FV(), gI.FV())) {
                                    a.this.b(gI.FV());
                                    z = true;
                                }
                                if (a.this.a(ccVar.FW(), gI.FW())) {
                                    a.this.b(gI.FW());
                                    z = true;
                                }
                                if (a.this.a(ccVar.FX(), gI.FX())) {
                                    a.this.b(gI.FX());
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
                    a.this.aRX = alVar.aOJ.aRX;
                    if (bool != null && bool.booleanValue()) {
                        d.BM().putString("audio_live_dating_anim", cc.a(a.this.aRX));
                    }
                    a.this.efJ();
                    a.this.zW(false);
                }
            }.execute(alVar.aOJ.aRX);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void efJ() {
        if (this.aRX != null) {
            if (this.owM == null) {
                this.owM = new ArrayList();
            } else {
                this.owM.clear();
            }
            ListUtils.add(this.owM, this.aRX.FX());
            ListUtils.add(this.owM, this.aRX.FU());
            ListUtils.add(this.owM, this.aRX.FV());
            ListUtils.add(this.owM, this.aRX.FW());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zW(final boolean z) {
        if (!ListUtils.isEmpty(z ? this.owN : this.owM)) {
            final at gz = gz(z ? this.owN : this.owM);
            if (gz == null) {
                zW(z);
            } else {
                c.b(gz.getDownloadUrl(), gz.FN(), new b.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.a.2
                    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.b.a
                    public void zX(boolean z2) {
                        if (!z && !z2) {
                            if (a.this.owN == null) {
                                a.this.owN = new ArrayList();
                            }
                            a.this.owN.add(gz);
                        }
                        a.this.zW(z || ListUtils.isEmpty(a.this.owM));
                    }
                });
            }
        }
    }

    private void bXm() {
        if (this.hTr == null) {
            this.hTr = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_SYNC) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.a.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021011 && (httpResponsedMessage instanceof AlaSyncHttpResponseMessage)) {
                        a.this.bes();
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.hTr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(at atVar, at atVar2) {
        return (atVar2 == null || atVar == null || TextUtils.equals(atVar2.getDownloadUrl(), atVar.getDownloadUrl()) || TextUtils.equals(atVar2.FN(), atVar.FN())) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(at atVar) {
        if (!c(atVar)) {
            com.baidu.live.h.a.cleanDir(new File(com.baidu.live.ag.b.iH(atVar.FN())));
        }
    }

    private static at gz(List<at> list) {
        if (ListUtils.isEmpty(list)) {
            return null;
        }
        return list.remove(0);
    }

    private static boolean c(at atVar) {
        return atVar == null || StringUtils.isNull(atVar.FN(), true);
    }
}
