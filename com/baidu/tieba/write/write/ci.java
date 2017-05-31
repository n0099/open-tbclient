package com.baidu.tieba.write.write;

import android.app.Activity;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class ci implements View.OnClickListener {
    final /* synthetic */ WriteUrlActivity gbF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ci(WriteUrlActivity writeUrlActivity) {
        this.gbF = writeUrlActivity;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0064, code lost:
        if (com.baidu.adp.lib.util.StringUtils.isNull(r0.bqs()) == false) goto L24;
     */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onClick(View view) {
        cs csVar;
        cs csVar2;
        cs csVar3;
        cs csVar4;
        boolean z;
        cs csVar5;
        boolean z2;
        cs csVar6;
        com.baidu.tieba.write.model.a aVar;
        com.baidu.tieba.write.model.a aVar2;
        cs csVar7;
        cs csVar8;
        cs csVar9;
        cs csVar10;
        cs csVar11;
        com.baidu.tieba.write.a.a aVar3;
        boolean z3;
        com.baidu.tieba.write.a.a aVar4;
        com.baidu.tieba.write.a.a aVar5;
        com.baidu.tieba.write.a.a aVar6;
        com.baidu.tieba.write.a.a aVar7;
        com.baidu.tieba.write.a.a aVar8;
        cs csVar12;
        com.baidu.tieba.write.a.a aVar9;
        com.baidu.tieba.write.a.a aVar10;
        boolean z4;
        com.baidu.tieba.write.a.a aVar11;
        cm cmVar;
        cs csVar13;
        cs csVar14;
        com.baidu.tieba.write.a.a aVar12;
        cs csVar15;
        cs csVar16;
        cs csVar17;
        cs csVar18;
        cs csVar19;
        if (view != null) {
            csVar = this.gbF.gbz;
            if (csVar != null) {
                csVar2 = this.gbF.gbz;
                if (view == csVar2.TZ()) {
                    csVar14 = this.gbF.gbz;
                    if (csVar14 != null) {
                        csVar17 = this.gbF.gbz;
                        if (csVar17.bqB() != null) {
                            csVar18 = this.gbF.gbz;
                            if (csVar18.bqB().getVisibility() == 0) {
                                csVar19 = this.gbF.gbz;
                                csVar19.bqy();
                                return;
                            }
                        }
                    }
                    aVar12 = this.gbF.gbC;
                    if (aVar12 == null) {
                        csVar15 = this.gbF.gbz;
                        if (csVar15 != null) {
                            csVar16 = this.gbF.gbz;
                        }
                        this.gbF.finish();
                        return;
                    }
                    this.gbF.bcE();
                    return;
                }
                csVar3 = this.gbF.gbz;
                if (view != csVar3.bqt()) {
                    csVar4 = this.gbF.gbz;
                    if (view != csVar4.bqv()) {
                        csVar7 = this.gbF.gbz;
                        if (view != csVar7.bqw()) {
                            csVar8 = this.gbF.gbz;
                            if (view == csVar8.bqx()) {
                                csVar12 = this.gbF.gbz;
                                aVar9 = this.gbF.gbC;
                                csVar12.b(aVar9);
                                return;
                            }
                            csVar9 = this.gbF.gbz;
                            if (view != csVar9.getVideoContainer()) {
                                csVar10 = this.gbF.gbz;
                                if (view == csVar10.getRootView()) {
                                    Activity activity = this.gbF.getActivity();
                                    csVar11 = this.gbF.gbz;
                                    com.baidu.adp.lib.util.k.c(activity, csVar11.bqu());
                                    return;
                                }
                                return;
                            }
                            aVar3 = this.gbF.gbC;
                            if (aVar3 != null) {
                                z3 = this.gbF.isLoading;
                                if (!z3) {
                                    aVar4 = this.gbF.gbC;
                                    if (StringUtils.isNull(aVar4.videoUrl)) {
                                        this.gbF.showToast(w.l.tip_play_video);
                                        return;
                                    }
                                    TiebaStatic.log("c12170");
                                    Activity pageActivity = this.gbF.getPageContext().getPageActivity();
                                    aVar5 = this.gbF.gbC;
                                    String str = aVar5.videoUrl;
                                    aVar6 = this.gbF.gbC;
                                    int i = aVar6.videoWidth;
                                    aVar7 = this.gbF.gbC;
                                    int i2 = aVar7.videoHeight;
                                    aVar8 = this.gbF.gbC;
                                    XiaoyingUtil.startPlayXiaoyingVideo(pageActivity, str, i, i2, aVar8.fWc);
                                    return;
                                }
                                this.gbF.showToast(w.l.tip_loading_to_publish);
                                return;
                            }
                            this.gbF.showToast(w.l.tip_no_data_to_publish);
                            return;
                        }
                    }
                    z = this.gbF.isLoading;
                    if (z) {
                        aVar = this.gbF.gbA;
                        if (aVar != null) {
                            aVar2 = this.gbF.gbA;
                            aVar2.boo();
                        }
                    }
                    this.gbF.gbC = null;
                    this.gbF.isLoading = false;
                    csVar5 = this.gbF.gbz;
                    z2 = this.gbF.isLoading;
                    csVar5.a(null, z2);
                    csVar6 = this.gbF.gbz;
                    csVar6.b((com.baidu.tieba.write.a.a) null);
                    TiebaStatic.log(new com.baidu.tbadk.core.util.as("c12167"));
                    return;
                }
                aVar10 = this.gbF.gbC;
                if (aVar10 != null) {
                    z4 = this.gbF.isLoading;
                    if (z4) {
                        this.gbF.showToast(w.l.tip_loading_to_publish);
                        return;
                    }
                    if (!com.baidu.adp.lib.util.i.hk()) {
                        this.gbF.showToast(w.l.neterror);
                    }
                    aVar11 = this.gbF.gbC;
                    if (aVar11.fVW == 2) {
                        csVar13 = this.gbF.gbz;
                        if (csVar13.bqs().length() > 31) {
                            this.gbF.showToast(w.l.tip_publish_video_link_limit);
                            return;
                        }
                    }
                    cmVar = this.gbF.gbD;
                    cmVar.bqq();
                    return;
                }
                this.gbF.showToast(w.l.tip_no_data_to_publish);
            }
        }
    }
}
