package com.baidu.tieba.launcherGuide.topRec;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.tbadkCore.w;
import com.baidu.tieba.tbadkCore.x;
/* loaded from: classes.dex */
class c extends com.baidu.adp.base.g {
    private final /* synthetic */ int WS;
    final /* synthetic */ TopRecActivity cER;
    private final /* synthetic */ int val$id;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(TopRecActivity topRecActivity, int i, int i2) {
        this.cER = topRecActivity;
        this.WS = i;
        this.val$id = i2;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        w wVar;
        w wVar2;
        d dVar;
        if (this.cER.cEL != null && this.cER.cEL.forum_list[this.WS] != null) {
            wVar = this.cER.MY;
            if (wVar.getErrorCode() != 22) {
                wVar2 = this.cER.MY;
                if (wVar2.getErrorCode() != 0) {
                    this.cER.aF(this.WS, this.val$id);
                    return;
                } else if (((x) obj) == null) {
                    this.cER.aF(this.WS, this.val$id);
                    return;
                } else {
                    this.cER.anq();
                    TbadkApplication.getInst().addLikeForum(this.cER.cEL.forum_list[this.WS].forum_name);
                    return;
                }
            }
            this.cER.cEL.forum_list[this.WS].is_like = 1;
            dVar = this.cER.cEI;
            dVar.notifyDataSetChanged();
        }
    }
}
