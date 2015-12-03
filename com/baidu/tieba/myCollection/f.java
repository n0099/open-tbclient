package com.baidu.tieba.myCollection;

import java.util.Calendar;
import java.util.Comparator;
/* loaded from: classes.dex */
class f implements Comparator<Calendar> {
    final /* synthetic */ e ctX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.ctX = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(Calendar calendar, Calendar calendar2) {
        return calendar.before(calendar2) ? -1 : 1;
    }
}
