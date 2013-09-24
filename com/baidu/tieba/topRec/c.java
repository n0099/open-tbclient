package com.baidu.tieba.topRec;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.ag;
import com.baidu.tieba.model.as;
/* loaded from: classes.dex */
class c extends com.baidu.adp.a.e {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TopRecActivity f1865a;
    private final /* synthetic */ int b;
    private final /* synthetic */ int c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(TopRecActivity topRecActivity, int i, int i2) {
        this.f1865a = topRecActivity;
        this.b = i;
        this.c = i2;
    }

    @Override // com.baidu.adp.a.e
    public void a(Object obj) {
        TRForumListData tRForumListData;
        TRForumListData tRForumListData2;
        as asVar;
        as asVar2;
        TRForumListData tRForumListData3;
        TRForumListData tRForumListData4;
        e eVar;
        tRForumListData = this.f1865a.f;
        if (tRForumListData != null) {
            tRForumListData2 = this.f1865a.f;
            if (tRForumListData2.forum_list[this.b] != null) {
                asVar = this.f1865a.d;
                if (asVar.getErrorCode() != 22) {
                    asVar2 = this.f1865a.d;
                    if (asVar2.getErrorCode() != 0) {
                        this.f1865a.b(this.b, this.c);
                        return;
                    } else if (((ag) obj) == null) {
                        this.f1865a.b(this.b, this.c);
                        return;
                    } else {
                        this.f1865a.d();
                        TiebaApplication g = TiebaApplication.g();
                        tRForumListData3 = this.f1865a.f;
                        g.e(tRForumListData3.forum_list[this.b].forum_name);
                        return;
                    }
                }
                tRForumListData4 = this.f1865a.f;
                tRForumListData4.forum_list[this.b].is_like = 1;
                eVar = this.f1865a.b;
                eVar.notifyDataSetChanged();
            }
        }
    }
}
