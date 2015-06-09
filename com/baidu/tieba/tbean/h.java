package com.baidu.tieba.tbean;

import java.util.Comparator;
import tbclient.GetIconList.IconInfo;
/* loaded from: classes.dex */
class h implements Comparator<IconInfo> {
    final /* synthetic */ d cuN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(d dVar) {
        this.cuN = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(IconInfo iconInfo, IconInfo iconInfo2) {
        return iconInfo.non_member_t.intValue() <= iconInfo2.non_member_t.intValue() ? -1 : 1;
    }
}
