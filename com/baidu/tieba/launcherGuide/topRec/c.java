package com.baidu.tieba.launcherGuide.topRec;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.tbadkCore.x;
import com.baidu.tieba.tbadkCore.y;
/* loaded from: classes.dex */
class c extends com.baidu.adp.base.g {
    private final /* synthetic */ int WD;
    final /* synthetic */ TopRecActivity dFL;
    private final /* synthetic */ int val$id;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(TopRecActivity topRecActivity, int i, int i2) {
        this.dFL = topRecActivity;
        this.WD = i;
        this.val$id = i2;
    }

    @Override // com.baidu.adp.base.g
    public void g(Object obj) {
        x xVar;
        x xVar2;
        d dVar;
        if (this.dFL.dFF != null && this.dFL.dFF.forum_list[this.WD] != null) {
            xVar = this.dFL.Gg;
            if (xVar.getErrorCode() != 22) {
                xVar2 = this.dFL.Gg;
                if (xVar2.getErrorCode() != 0) {
                    this.dFL.bf(this.WD, this.val$id);
                    return;
                } else if (((y) obj) == null) {
                    this.dFL.bf(this.WD, this.val$id);
                    return;
                } else {
                    this.dFL.aDu();
                    TbadkApplication.getInst().addLikeForum(this.dFL.dFF.forum_list[this.WD].forum_name);
                    return;
                }
            }
            this.dFL.dFF.forum_list[this.WD].is_like = 1;
            dVar = this.dFL.dFC;
            dVar.notifyDataSetChanged();
        }
    }
}
