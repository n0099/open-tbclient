package com.baidu.tieba.topRec;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.af;
import com.baidu.tieba.model.ar;
/* loaded from: classes.dex */
class c extends com.baidu.adp.a.g {
    final /* synthetic */ TopRecActivity a;
    private final /* synthetic */ int b;
    private final /* synthetic */ int c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(TopRecActivity topRecActivity, int i, int i2) {
        this.a = topRecActivity;
        this.b = i;
        this.c = i2;
    }

    @Override // com.baidu.adp.a.g
    public void a(Object obj) {
        TRForumListData tRForumListData;
        TRForumListData tRForumListData2;
        ar arVar;
        ar arVar2;
        TRForumListData tRForumListData3;
        TRForumListData tRForumListData4;
        e eVar;
        tRForumListData = this.a.f;
        if (tRForumListData != null) {
            tRForumListData2 = this.a.f;
            if (tRForumListData2.forum_list[this.b] != null) {
                arVar = this.a.d;
                if (arVar.getErrorCode() != 22) {
                    arVar2 = this.a.d;
                    if (arVar2.getErrorCode() != 0) {
                        this.a.b(this.b, this.c);
                        return;
                    } else if (((af) obj) == null) {
                        this.a.b(this.b, this.c);
                        return;
                    } else {
                        this.a.c();
                        TiebaApplication g = TiebaApplication.g();
                        tRForumListData3 = this.a.f;
                        g.e(tRForumListData3.forum_list[this.b].forum_name);
                        return;
                    }
                }
                tRForumListData4 = this.a.f;
                tRForumListData4.forum_list[this.b].is_like = 1;
                eVar = this.a.b;
                eVar.notifyDataSetChanged();
            }
        }
    }
}
