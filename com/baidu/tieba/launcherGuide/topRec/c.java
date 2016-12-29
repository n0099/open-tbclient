package com.baidu.tieba.launcherGuide.topRec;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.tbadkCore.w;
import com.baidu.tieba.tbadkCore.x;
/* loaded from: classes.dex */
class c extends com.baidu.adp.base.g {
    private final /* synthetic */ int VX;
    final /* synthetic */ TopRecActivity diJ;
    private final /* synthetic */ int val$id;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(TopRecActivity topRecActivity, int i, int i2) {
        this.diJ = topRecActivity;
        this.VX = i;
        this.val$id = i2;
    }

    @Override // com.baidu.adp.base.g
    public void g(Object obj) {
        w wVar;
        w wVar2;
        d dVar;
        if (this.diJ.diD != null && this.diJ.diD.forum_list[this.VX] != null) {
            wVar = this.diJ.Gg;
            if (wVar.getErrorCode() != 22) {
                wVar2 = this.diJ.Gg;
                if (wVar2.getErrorCode() != 0) {
                    this.diJ.aU(this.VX, this.val$id);
                    return;
                } else if (((x) obj) == null) {
                    this.diJ.aU(this.VX, this.val$id);
                    return;
                } else {
                    this.diJ.awH();
                    TbadkApplication.getInst().addLikeForum(this.diJ.diD.forum_list[this.VX].forum_name);
                    return;
                }
            }
            this.diJ.diD.forum_list[this.VX].is_like = 1;
            dVar = this.diJ.diA;
            dVar.notifyDataSetChanged();
        }
    }
}
