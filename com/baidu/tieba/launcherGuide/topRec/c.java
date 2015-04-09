package com.baidu.tieba.launcherGuide.topRec;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.tbadkCore.af;
import com.baidu.tieba.tbadkCore.ah;
/* loaded from: classes.dex */
class c extends com.baidu.adp.base.i {
    private final /* synthetic */ int Rz;
    final /* synthetic */ TopRecActivity bxZ;
    private final /* synthetic */ int val$id;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(TopRecActivity topRecActivity, int i, int i2) {
        this.bxZ = topRecActivity;
        this.Rz = i;
        this.val$id = i2;
    }

    @Override // com.baidu.adp.base.i
    public void c(Object obj) {
        TRForumListData tRForumListData;
        TRForumListData tRForumListData2;
        af afVar;
        af afVar2;
        TRForumListData tRForumListData3;
        TRForumListData tRForumListData4;
        e eVar;
        tRForumListData = this.bxZ.bxT;
        if (tRForumListData != null) {
            tRForumListData2 = this.bxZ.bxT;
            if (tRForumListData2.forum_list[this.Rz] != null) {
                afVar = this.bxZ.LQ;
                if (afVar.getErrorCode() != 22) {
                    afVar2 = this.bxZ.LQ;
                    if (afVar2.getErrorCode() != 0) {
                        this.bxZ.ab(this.Rz, this.val$id);
                        return;
                    } else if (((ah) obj) == null) {
                        this.bxZ.ab(this.Rz, this.val$id);
                        return;
                    } else {
                        this.bxZ.WD();
                        TbadkApplication inst = TbadkApplication.getInst();
                        tRForumListData3 = this.bxZ.bxT;
                        inst.addLikeForum(tRForumListData3.forum_list[this.Rz].forum_name);
                        return;
                    }
                }
                tRForumListData4 = this.bxZ.bxT;
                tRForumListData4.forum_list[this.Rz].is_like = 1;
                eVar = this.bxZ.bxQ;
                eVar.notifyDataSetChanged();
            }
        }
    }
}
