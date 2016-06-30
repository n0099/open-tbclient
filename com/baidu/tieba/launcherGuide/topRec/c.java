package com.baidu.tieba.launcherGuide.topRec;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.tbadkCore.y;
import com.baidu.tieba.tbadkCore.z;
/* loaded from: classes.dex */
class c extends com.baidu.adp.base.g {
    private final /* synthetic */ int Sx;
    final /* synthetic */ TopRecActivity dkj;
    private final /* synthetic */ int val$id;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(TopRecActivity topRecActivity, int i, int i2) {
        this.dkj = topRecActivity;
        this.Sx = i;
        this.val$id = i2;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        y yVar;
        y yVar2;
        d dVar;
        if (this.dkj.dkd != null && this.dkj.dkd.forum_list[this.Sx] != null) {
            yVar = this.dkj.Dq;
            if (yVar.getErrorCode() != 22) {
                yVar2 = this.dkj.Dq;
                if (yVar2.getErrorCode() != 0) {
                    this.dkj.aV(this.Sx, this.val$id);
                    return;
                } else if (((z) obj) == null) {
                    this.dkj.aV(this.Sx, this.val$id);
                    return;
                } else {
                    this.dkj.avB();
                    TbadkApplication.getInst().addLikeForum(this.dkj.dkd.forum_list[this.Sx].forum_name);
                    return;
                }
            }
            this.dkj.dkd.forum_list[this.Sx].is_like = 1;
            dVar = this.dkj.dka;
            dVar.notifyDataSetChanged();
        }
    }
}
