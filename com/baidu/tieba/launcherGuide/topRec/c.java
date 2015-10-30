package com.baidu.tieba.launcherGuide.topRec;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.tbadkCore.w;
import com.baidu.tieba.tbadkCore.x;
/* loaded from: classes.dex */
class c extends com.baidu.adp.base.g {
    final /* synthetic */ TopRecActivity bSV;
    private final /* synthetic */ int val$id;
    private final /* synthetic */ int val$position;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(TopRecActivity topRecActivity, int i, int i2) {
        this.bSV = topRecActivity;
        this.val$position = i;
        this.val$id = i2;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        w wVar;
        w wVar2;
        d dVar;
        if (this.bSV.bSP != null && this.bSV.bSP.forum_list[this.val$position] != null) {
            wVar = this.bSV.LT;
            if (wVar.getErrorCode() != 22) {
                wVar2 = this.bSV.LT;
                if (wVar2.getErrorCode() != 0) {
                    this.bSV.ar(this.val$position, this.val$id);
                    return;
                } else if (((x) obj) == null) {
                    this.bSV.ar(this.val$position, this.val$id);
                    return;
                } else {
                    this.bSV.aaL();
                    TbadkApplication.getInst().addLikeForum(this.bSV.bSP.forum_list[this.val$position].forum_name);
                    return;
                }
            }
            this.bSV.bSP.forum_list[this.val$position].is_like = 1;
            dVar = this.bSV.bSM;
            dVar.notifyDataSetChanged();
        }
    }
}
