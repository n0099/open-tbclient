package com.baidu.tieba.topRec;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.tbadkCore.ac;
import com.baidu.tieba.tbadkCore.ae;
/* loaded from: classes.dex */
class c extends com.baidu.adp.base.i {
    final /* synthetic */ TopRecActivity ccL;
    private final /* synthetic */ int val$id;
    private final /* synthetic */ int val$position;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(TopRecActivity topRecActivity, int i, int i2) {
        this.ccL = topRecActivity;
        this.val$position = i;
        this.val$id = i2;
    }

    @Override // com.baidu.adp.base.i
    public void c(Object obj) {
        TRForumListData tRForumListData;
        TRForumListData tRForumListData2;
        ac acVar;
        ac acVar2;
        TRForumListData tRForumListData3;
        TRForumListData tRForumListData4;
        e eVar;
        tRForumListData = this.ccL.ccF;
        if (tRForumListData != null) {
            tRForumListData2 = this.ccL.ccF;
            if (tRForumListData2.forum_list[this.val$position] != null) {
                acVar = this.ccL.zm;
                if (acVar.getErrorCode() != 22) {
                    acVar2 = this.ccL.zm;
                    if (acVar2.getErrorCode() != 0) {
                        this.ccL.ai(this.val$position, this.val$id);
                        return;
                    } else if (((ae) obj) == null) {
                        this.ccL.ai(this.val$position, this.val$id);
                        return;
                    } else {
                        this.ccL.ajv();
                        TbadkApplication inst = TbadkApplication.getInst();
                        tRForumListData3 = this.ccL.ccF;
                        inst.addLikeForum(tRForumListData3.forum_list[this.val$position].forum_name);
                        return;
                    }
                }
                tRForumListData4 = this.ccL.ccF;
                tRForumListData4.forum_list[this.val$position].is_like = 1;
                eVar = this.ccL.ccC;
                eVar.notifyDataSetChanged();
            }
        }
    }
}
