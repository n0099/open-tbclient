package com.baidu.tieba.topRec;

import com.baidu.tieba.aj;
import com.baidu.tieba.data.aa;
import com.baidu.tieba.model.ag;
/* loaded from: classes.dex */
class c extends com.baidu.adp.base.h {
    private final /* synthetic */ int BF;
    final /* synthetic */ TopRecActivity bPw;
    private final /* synthetic */ int val$id;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(TopRecActivity topRecActivity, int i, int i2) {
        this.bPw = topRecActivity;
        this.BF = i;
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
        tRForumListData = this.bPw.bPq;
        if (tRForumListData != null) {
            tRForumListData2 = this.bPw.bPq;
            if (tRForumListData2.forum_list[this.BF] != null) {
                agVar = this.bPw.avr;
                if (agVar.getErrorCode() != 22) {
                    agVar2 = this.bPw.avr;
                    if (agVar2.getErrorCode() != 0) {
                        this.bPw.X(this.BF, this.val$id);
                        return;
                    } else if (((aa) obj) == null) {
                        this.bPw.X(this.BF, this.val$id);
                        return;
                    } else {
                        this.bPw.aeo();
                        aj wk = aj.wk();
                        tRForumListData3 = this.bPw.bPq;
                        wk.dW(tRForumListData3.forum_list[this.BF].forum_name);
                        return;
                    }
                }
                tRForumListData4 = this.bPw.bPq;
                tRForumListData4.forum_list[this.BF].is_like = 1;
                eVar = this.bPw.bPn;
                eVar.notifyDataSetChanged();
            }
        }
    }
}
