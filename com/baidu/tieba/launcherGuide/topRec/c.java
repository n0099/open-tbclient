package com.baidu.tieba.launcherGuide.topRec;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.tbadkCore.w;
import com.baidu.tieba.tbadkCore.x;
/* loaded from: classes.dex */
class c extends com.baidu.adp.base.g {
    final /* synthetic */ TopRecActivity bTq;
    private final /* synthetic */ int val$id;
    private final /* synthetic */ int val$position;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(TopRecActivity topRecActivity, int i, int i2) {
        this.bTq = topRecActivity;
        this.val$position = i;
        this.val$id = i2;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        w wVar;
        w wVar2;
        d dVar;
        if (this.bTq.bTk != null && this.bTq.bTk.forum_list[this.val$position] != null) {
            wVar = this.bTq.LU;
            if (wVar.getErrorCode() != 22) {
                wVar2 = this.bTq.LU;
                if (wVar2.getErrorCode() != 0) {
                    this.bTq.at(this.val$position, this.val$id);
                    return;
                } else if (((x) obj) == null) {
                    this.bTq.at(this.val$position, this.val$id);
                    return;
                } else {
                    this.bTq.abg();
                    TbadkApplication.getInst().addLikeForum(this.bTq.bTk.forum_list[this.val$position].forum_name);
                    return;
                }
            }
            this.bTq.bTk.forum_list[this.val$position].is_like = 1;
            dVar = this.bTq.bTh;
            dVar.notifyDataSetChanged();
        }
    }
}
