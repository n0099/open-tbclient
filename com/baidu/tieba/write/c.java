package com.baidu.tieba.write;

import com.baidu.tieba.likedForum.a;
import java.util.List;
import tbclient.RecommendForumListForBottle.ForumInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements a.InterfaceC0073a {
    final /* synthetic */ a gdz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.gdz = aVar;
    }

    @Override // com.baidu.tieba.likedForum.a.InterfaceC0073a
    public void a(boolean z, int i, String str, List<ForumInfo> list) {
        this.gdz.gdt = true;
        this.gdz.gdw = list;
        this.gdz.brs();
    }
}
