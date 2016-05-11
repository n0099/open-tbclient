package com.baidu.tieba.launcherGuide.topRec;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.tbadkCore.x;
import com.baidu.tieba.tbadkCore.y;
/* loaded from: classes.dex */
class c extends com.baidu.adp.base.g {
    private final /* synthetic */ int Sg;
    final /* synthetic */ TopRecActivity cEJ;
    private final /* synthetic */ int val$id;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(TopRecActivity topRecActivity, int i, int i2) {
        this.cEJ = topRecActivity;
        this.Sg = i;
        this.val$id = i2;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        x xVar;
        x xVar2;
        d dVar;
        if (this.cEJ.cED != null && this.cEJ.cED.forum_list[this.Sg] != null) {
            xVar = this.cEJ.Dp;
            if (xVar.getErrorCode() != 22) {
                xVar2 = this.cEJ.Dp;
                if (xVar2.getErrorCode() != 0) {
                    this.cEJ.aE(this.Sg, this.val$id);
                    return;
                } else if (((y) obj) == null) {
                    this.cEJ.aE(this.Sg, this.val$id);
                    return;
                } else {
                    this.cEJ.anm();
                    TbadkApplication.getInst().addLikeForum(this.cEJ.cED.forum_list[this.Sg].forum_name);
                    return;
                }
            }
            this.cEJ.cED.forum_list[this.Sg].is_like = 1;
            dVar = this.cEJ.cEA;
            dVar.notifyDataSetChanged();
        }
    }
}
