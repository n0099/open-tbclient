package com.baidu.tieba.launcherGuide.topRec;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.tbadkCore.x;
import com.baidu.tieba.tbadkCore.y;
/* loaded from: classes.dex */
class c extends com.baidu.adp.base.g {
    private final /* synthetic */ int Wf;
    final /* synthetic */ TopRecActivity dAh;
    private final /* synthetic */ int val$id;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(TopRecActivity topRecActivity, int i, int i2) {
        this.dAh = topRecActivity;
        this.Wf = i;
        this.val$id = i2;
    }

    @Override // com.baidu.adp.base.g
    public void g(Object obj) {
        x xVar;
        x xVar2;
        d dVar;
        if (this.dAh.dAb != null && this.dAh.dAb.forum_list[this.Wf] != null) {
            xVar = this.dAh.Ge;
            if (xVar.getErrorCode() != 22) {
                xVar2 = this.dAh.Ge;
                if (xVar2.getErrorCode() != 0) {
                    this.dAh.be(this.Wf, this.val$id);
                    return;
                } else if (((y) obj) == null) {
                    this.dAh.be(this.Wf, this.val$id);
                    return;
                } else {
                    this.dAh.aBy();
                    TbadkApplication.getInst().addLikeForum(this.dAh.dAb.forum_list[this.Wf].forum_name);
                    return;
                }
            }
            this.dAh.dAb.forum_list[this.Wf].is_like = 1;
            dVar = this.dAh.dzY;
            dVar.notifyDataSetChanged();
        }
    }
}
