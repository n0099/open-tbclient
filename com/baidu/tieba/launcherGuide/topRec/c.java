package com.baidu.tieba.launcherGuide.topRec;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.tbadkCore.x;
import com.baidu.tieba.tbadkCore.y;
/* loaded from: classes.dex */
class c extends com.baidu.adp.base.g {
    final /* synthetic */ TopRecActivity cjE;
    private final /* synthetic */ int val$id;
    private final /* synthetic */ int val$position;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(TopRecActivity topRecActivity, int i, int i2) {
        this.cjE = topRecActivity;
        this.val$position = i;
        this.val$id = i2;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        x xVar;
        x xVar2;
        d dVar;
        if (this.cjE.cjy != null && this.cjE.cjy.forum_list[this.val$position] != null) {
            xVar = this.cjE.Ml;
            if (xVar.getErrorCode() != 22) {
                xVar2 = this.cjE.Ml;
                if (xVar2.getErrorCode() != 0) {
                    this.cjE.av(this.val$position, this.val$id);
                    return;
                } else if (((y) obj) == null) {
                    this.cjE.av(this.val$position, this.val$id);
                    return;
                } else {
                    this.cjE.aeM();
                    TbadkApplication.getInst().addLikeForum(this.cjE.cjy.forum_list[this.val$position].forum_name);
                    return;
                }
            }
            this.cjE.cjy.forum_list[this.val$position].is_like = 1;
            dVar = this.cjE.cjv;
            dVar.notifyDataSetChanged();
        }
    }
}
