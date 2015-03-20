package com.baidu.tieba.launcherGuide.topRec;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.tbadkCore.af;
import com.baidu.tieba.tbadkCore.ah;
/* loaded from: classes.dex */
class c extends com.baidu.adp.base.i {
    private final /* synthetic */ int Rx;
    final /* synthetic */ TopRecActivity bxJ;
    private final /* synthetic */ int val$id;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(TopRecActivity topRecActivity, int i, int i2) {
        this.bxJ = topRecActivity;
        this.Rx = i;
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
        tRForumListData = this.bxJ.bxD;
        if (tRForumListData != null) {
            tRForumListData2 = this.bxJ.bxD;
            if (tRForumListData2.forum_list[this.Rx] != null) {
                afVar = this.bxJ.LO;
                if (afVar.getErrorCode() != 22) {
                    afVar2 = this.bxJ.LO;
                    if (afVar2.getErrorCode() != 0) {
                        this.bxJ.ab(this.Rx, this.val$id);
                        return;
                    } else if (((ah) obj) == null) {
                        this.bxJ.ab(this.Rx, this.val$id);
                        return;
                    } else {
                        this.bxJ.Wq();
                        TbadkApplication inst = TbadkApplication.getInst();
                        tRForumListData3 = this.bxJ.bxD;
                        inst.addLikeForum(tRForumListData3.forum_list[this.Rx].forum_name);
                        return;
                    }
                }
                tRForumListData4 = this.bxJ.bxD;
                tRForumListData4.forum_list[this.Rx].is_like = 1;
                eVar = this.bxJ.bxA;
                eVar.notifyDataSetChanged();
            }
        }
    }
}
