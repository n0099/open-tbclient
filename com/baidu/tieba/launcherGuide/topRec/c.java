package com.baidu.tieba.launcherGuide.topRec;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.tbadkCore.x;
import com.baidu.tieba.tbadkCore.y;
/* loaded from: classes.dex */
class c extends com.baidu.adp.base.g {
    private final /* synthetic */ int VV;
    final /* synthetic */ TopRecActivity dyQ;
    private final /* synthetic */ int val$id;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(TopRecActivity topRecActivity, int i, int i2) {
        this.dyQ = topRecActivity;
        this.VV = i;
        this.val$id = i2;
    }

    @Override // com.baidu.adp.base.g
    public void g(Object obj) {
        x xVar;
        x xVar2;
        d dVar;
        if (this.dyQ.dyK != null && this.dyQ.dyK.forum_list[this.VV] != null) {
            xVar = this.dyQ.Ge;
            if (xVar.getErrorCode() != 22) {
                xVar2 = this.dyQ.Ge;
                if (xVar2.getErrorCode() != 0) {
                    this.dyQ.bc(this.VV, this.val$id);
                    return;
                } else if (((y) obj) == null) {
                    this.dyQ.bc(this.VV, this.val$id);
                    return;
                } else {
                    this.dyQ.aBa();
                    TbadkApplication.getInst().addLikeForum(this.dyQ.dyK.forum_list[this.VV].forum_name);
                    return;
                }
            }
            this.dyQ.dyK.forum_list[this.VV].is_like = 1;
            dVar = this.dyQ.dyH;
            dVar.notifyDataSetChanged();
        }
    }
}
