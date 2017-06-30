package com.baidu.tieba.write.write;

import android.app.Activity;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class cg implements View.OnClickListener {
    final /* synthetic */ WriteUrlActivity gmD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cg(WriteUrlActivity writeUrlActivity) {
        this.gmD = writeUrlActivity;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0064, code lost:
        if (com.baidu.adp.lib.util.StringUtils.isNull(r0.buT()) == false) goto L24;
     */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onClick(View view) {
        cq cqVar;
        cq cqVar2;
        cq cqVar3;
        cq cqVar4;
        boolean z;
        cq cqVar5;
        boolean z2;
        cq cqVar6;
        com.baidu.tieba.write.model.a aVar;
        com.baidu.tieba.write.model.a aVar2;
        cq cqVar7;
        cq cqVar8;
        cq cqVar9;
        cq cqVar10;
        cq cqVar11;
        com.baidu.tieba.write.a.a aVar3;
        boolean z3;
        com.baidu.tieba.write.a.a aVar4;
        com.baidu.tieba.write.a.a aVar5;
        com.baidu.tieba.write.a.a aVar6;
        com.baidu.tieba.write.a.a aVar7;
        com.baidu.tieba.write.a.a aVar8;
        cq cqVar12;
        com.baidu.tieba.write.a.a aVar9;
        com.baidu.tieba.write.a.a aVar10;
        boolean z4;
        com.baidu.tieba.write.a.a aVar11;
        ck ckVar;
        cq cqVar13;
        cq cqVar14;
        com.baidu.tieba.write.a.a aVar12;
        cq cqVar15;
        cq cqVar16;
        cq cqVar17;
        cq cqVar18;
        cq cqVar19;
        if (view != null) {
            cqVar = this.gmD.gmx;
            if (cqVar != null) {
                cqVar2 = this.gmD.gmx;
                if (view == cqVar2.Vo()) {
                    cqVar14 = this.gmD.gmx;
                    if (cqVar14 != null) {
                        cqVar17 = this.gmD.gmx;
                        if (cqVar17.bvc() != null) {
                            cqVar18 = this.gmD.gmx;
                            if (cqVar18.bvc().getVisibility() == 0) {
                                cqVar19 = this.gmD.gmx;
                                cqVar19.buZ();
                                return;
                            }
                        }
                    }
                    aVar12 = this.gmD.gmA;
                    if (aVar12 == null) {
                        cqVar15 = this.gmD.gmx;
                        if (cqVar15 != null) {
                            cqVar16 = this.gmD.gmx;
                        }
                        this.gmD.finish();
                        return;
                    }
                    this.gmD.bgT();
                    return;
                }
                cqVar3 = this.gmD.gmx;
                if (view != cqVar3.buU()) {
                    cqVar4 = this.gmD.gmx;
                    if (view != cqVar4.buW()) {
                        cqVar7 = this.gmD.gmx;
                        if (view != cqVar7.buX()) {
                            cqVar8 = this.gmD.gmx;
                            if (view == cqVar8.buY()) {
                                cqVar12 = this.gmD.gmx;
                                aVar9 = this.gmD.gmA;
                                cqVar12.b(aVar9);
                                return;
                            }
                            cqVar9 = this.gmD.gmx;
                            if (view != cqVar9.getVideoContainer()) {
                                cqVar10 = this.gmD.gmx;
                                if (view == cqVar10.getRootView()) {
                                    Activity activity = this.gmD.getActivity();
                                    cqVar11 = this.gmD.gmx;
                                    com.baidu.adp.lib.util.k.c(activity, cqVar11.buV());
                                    return;
                                }
                                return;
                            }
                            aVar3 = this.gmD.gmA;
                            if (aVar3 != null) {
                                z3 = this.gmD.isLoading;
                                if (!z3) {
                                    aVar4 = this.gmD.gmA;
                                    if (StringUtils.isNull(aVar4.videoUrl)) {
                                        this.gmD.showToast(w.l.tip_play_video);
                                        return;
                                    }
                                    TiebaStatic.log("c12170");
                                    Activity pageActivity = this.gmD.getPageContext().getPageActivity();
                                    aVar5 = this.gmD.gmA;
                                    String str = aVar5.videoUrl;
                                    aVar6 = this.gmD.gmA;
                                    int i = aVar6.videoWidth;
                                    aVar7 = this.gmD.gmA;
                                    int i2 = aVar7.videoHeight;
                                    aVar8 = this.gmD.gmA;
                                    XiaoyingUtil.startPlayXiaoyingVideo(pageActivity, str, i, i2, aVar8.ggN);
                                    return;
                                }
                                this.gmD.showToast(w.l.tip_loading_to_publish);
                                return;
                            }
                            this.gmD.showToast(w.l.tip_no_data_to_publish);
                            return;
                        }
                    }
                    z = this.gmD.isLoading;
                    if (z) {
                        aVar = this.gmD.gmy;
                        if (aVar != null) {
                            aVar2 = this.gmD.gmy;
                            aVar2.bsM();
                        }
                    }
                    this.gmD.gmA = null;
                    this.gmD.isLoading = false;
                    cqVar5 = this.gmD.gmx;
                    z2 = this.gmD.isLoading;
                    cqVar5.a(null, z2);
                    cqVar6 = this.gmD.gmx;
                    cqVar6.b((com.baidu.tieba.write.a.a) null);
                    TiebaStatic.log(new com.baidu.tbadk.core.util.au("c12167"));
                    return;
                }
                aVar10 = this.gmD.gmA;
                if (aVar10 != null) {
                    z4 = this.gmD.isLoading;
                    if (z4) {
                        this.gmD.showToast(w.l.tip_loading_to_publish);
                        return;
                    }
                    if (!com.baidu.adp.lib.util.i.hj()) {
                        this.gmD.showToast(w.l.neterror);
                    }
                    aVar11 = this.gmD.gmA;
                    if (aVar11.ggH == 2) {
                        cqVar13 = this.gmD.gmx;
                        if (cqVar13.buT().length() > 31) {
                            this.gmD.showToast(w.l.tip_publish_video_link_limit);
                            return;
                        }
                    }
                    ckVar = this.gmD.gmB;
                    ckVar.buQ();
                    return;
                }
                this.gmD.showToast(w.l.tip_no_data_to_publish);
            }
        }
    }
}
