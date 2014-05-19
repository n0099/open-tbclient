package com.baidu.tieba.topRec;

import com.baidu.tieba.ad;
import com.baidu.tieba.data.z;
import com.baidu.tieba.model.af;
/* loaded from: classes.dex */
class c extends com.baidu.adp.base.g {
    final /* synthetic */ TopRecActivity a;
    private final /* synthetic */ int b;
    private final /* synthetic */ int c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(TopRecActivity topRecActivity, int i, int i2) {
        this.a = topRecActivity;
        this.b = i;
        this.c = i2;
    }

    @Override // com.baidu.adp.base.g
    public void a(Object obj) {
        TRForumListData tRForumListData;
        TRForumListData tRForumListData2;
        af afVar;
        af afVar2;
        TRForumListData tRForumListData3;
        TRForumListData tRForumListData4;
        e eVar;
        tRForumListData = this.a.f;
        if (tRForumListData != null) {
            tRForumListData2 = this.a.f;
            if (tRForumListData2.forum_list[this.b] != null) {
                afVar = this.a.d;
                if (afVar.getErrorCode() != 22) {
                    afVar2 = this.a.d;
                    if (afVar2.getErrorCode() != 0) {
                        this.a.b(this.b, this.c);
                        return;
                    } else if (((z) obj) == null) {
                        this.a.b(this.b, this.c);
                        return;
                    } else {
                        this.a.c();
                        ad c = ad.c();
                        tRForumListData3 = this.a.f;
                        c.e(tRForumListData3.forum_list[this.b].forum_name);
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
