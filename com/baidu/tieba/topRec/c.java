package com.baidu.tieba.topRec;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.ag;
import com.baidu.tieba.model.ba;
/* loaded from: classes.dex */
class c extends com.baidu.adp.a.g {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f2387a;
    final /* synthetic */ int b;
    final /* synthetic */ TopRecActivity c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(TopRecActivity topRecActivity, int i, int i2) {
        this.c = topRecActivity;
        this.f2387a = i;
        this.b = i2;
    }

    @Override // com.baidu.adp.a.g
    public void a(Object obj) {
        TRForumListData tRForumListData;
        TRForumListData tRForumListData2;
        ba baVar;
        ba baVar2;
        TRForumListData tRForumListData3;
        TRForumListData tRForumListData4;
        e eVar;
        tRForumListData = this.c.f;
        if (tRForumListData != null) {
            tRForumListData2 = this.c.f;
            if (tRForumListData2.forum_list[this.f2387a] != null) {
                baVar = this.c.d;
                if (baVar.getErrorCode() == 22) {
                    tRForumListData4 = this.c.f;
                    tRForumListData4.forum_list[this.f2387a].is_like = 1;
                    eVar = this.c.b;
                    eVar.notifyDataSetChanged();
                    return;
                }
                baVar2 = this.c.d;
                if (baVar2.getErrorCode() != 0) {
                    this.c.c(this.f2387a, this.b);
                } else if (((ag) obj) != null) {
                    this.c.d();
                    TiebaApplication g = TiebaApplication.g();
                    tRForumListData3 = this.c.f;
                    g.e(tRForumListData3.forum_list[this.f2387a].forum_name);
                } else {
                    this.c.c(this.f2387a, this.b);
                }
            }
        }
    }
}
