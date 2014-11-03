package com.baidu.tieba.topRec;

import com.baidu.tieba.aj;
import com.baidu.tieba.data.aa;
import com.baidu.tieba.model.ag;
/* loaded from: classes.dex */
class c extends com.baidu.adp.base.h {
    private final /* synthetic */ int BG;
    final /* synthetic */ TopRecActivity bPL;
    private final /* synthetic */ int val$id;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(TopRecActivity topRecActivity, int i, int i2) {
        this.bPL = topRecActivity;
        this.BG = i;
        this.val$id = i2;
    }

    @Override // com.baidu.adp.base.h
    public void a(Object obj) {
        TRForumListData tRForumListData;
        TRForumListData tRForumListData2;
        ag agVar;
        ag agVar2;
        TRForumListData tRForumListData3;
        TRForumListData tRForumListData4;
        e eVar;
        tRForumListData = this.bPL.bPF;
        if (tRForumListData != null) {
            tRForumListData2 = this.bPL.bPF;
            if (tRForumListData2.forum_list[this.BG] != null) {
                agVar = this.bPL.avA;
                if (agVar.getErrorCode() != 22) {
                    agVar2 = this.bPL.avA;
                    if (agVar2.getErrorCode() != 0) {
                        this.bPL.X(this.BG, this.val$id);
                        return;
                    } else if (((aa) obj) == null) {
                        this.bPL.X(this.BG, this.val$id);
                        return;
                    } else {
                        this.bPL.aer();
                        aj wm = aj.wm();
                        tRForumListData3 = this.bPL.bPF;
                        wm.dW(tRForumListData3.forum_list[this.BG].forum_name);
                        return;
                    }
                }
                tRForumListData4 = this.bPL.bPF;
                tRForumListData4.forum_list[this.BG].is_like = 1;
                eVar = this.bPL.bPC;
                eVar.notifyDataSetChanged();
            }
        }
    }
}
