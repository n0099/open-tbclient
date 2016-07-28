package com.baidu.tieba.launcherGuide.topRec;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.tbadkCore.y;
import com.baidu.tieba.tbadkCore.z;
/* loaded from: classes.dex */
class c extends com.baidu.adp.base.g {
    private final /* synthetic */ int Tf;
    final /* synthetic */ TopRecActivity dni;
    private final /* synthetic */ int val$id;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(TopRecActivity topRecActivity, int i, int i2) {
        this.dni = topRecActivity;
        this.Tf = i;
        this.val$id = i2;
    }

    @Override // com.baidu.adp.base.g
    public void g(Object obj) {
        y yVar;
        y yVar2;
        d dVar;
        if (this.dni.dnc != null && this.dni.dnc.forum_list[this.Tf] != null) {
            yVar = this.dni.DR;
            if (yVar.getErrorCode() != 22) {
                yVar2 = this.dni.DR;
                if (yVar2.getErrorCode() != 0) {
                    this.dni.aY(this.Tf, this.val$id);
                    return;
                } else if (((z) obj) == null) {
                    this.dni.aY(this.Tf, this.val$id);
                    return;
                } else {
                    this.dni.awn();
                    TbadkApplication.getInst().addLikeForum(this.dni.dnc.forum_list[this.Tf].forum_name);
                    return;
                }
            }
            this.dni.dnc.forum_list[this.Tf].is_like = 1;
            dVar = this.dni.dmZ;
            dVar.notifyDataSetChanged();
        }
    }
}
