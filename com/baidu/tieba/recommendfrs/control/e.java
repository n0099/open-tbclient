package com.baidu.tieba.recommendfrs.control;

import android.text.TextUtils;
import com.baidu.tieba.i;
import com.baidu.tieba.recommendfrs.control.a.b;
import com.baidu.tieba.recommendfrs.indicator.ScrollFragmentTabHost;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements b.a {
    final /* synthetic */ a cIB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar) {
        this.cIB = aVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0075, code lost:
        if (r0.aqv() == false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00a0, code lost:
        if (r0.containsAll(r1) == false) goto L31;
     */
    @Override // com.baidu.tieba.recommendfrs.control.a.b.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(boolean z, com.baidu.tieba.recommendfrs.data.g gVar, boolean z2, String str) {
        ScrollFragmentTabHost scrollFragmentTabHost;
        ScrollFragmentTabHost scrollFragmentTabHost2;
        List list;
        List list2;
        List list3;
        ScrollFragmentTabHost scrollFragmentTabHost3;
        ScrollFragmentTabHost scrollFragmentTabHost4;
        com.baidu.tieba.recommendfrs.a aVar;
        ScrollFragmentTabHost scrollFragmentTabHost5;
        ScrollFragmentTabHost scrollFragmentTabHost6;
        List list4;
        ScrollFragmentTabHost scrollFragmentTabHost7;
        ScrollFragmentTabHost scrollFragmentTabHost8;
        if (!TextUtils.isEmpty(str)) {
            if (z) {
                scrollFragmentTabHost8 = this.cIB.cIv;
                if (!scrollFragmentTabHost8.aqv() && gVar != null && gVar.isEmpty()) {
                    if (this.cIB.getPageContext() == null || this.cIB.getPageContext().getResources() == null) {
                        return;
                    }
                    this.cIB.ap(this.cIB.getView());
                    this.cIB.showNetRefreshView(this.cIB.getView(), this.cIB.getPageContext().getResources().getString(i.h.neterror), false);
                    return;
                }
            }
            if (gVar != null && gVar.aqo() != null && "头条".equals(str)) {
                if (!z) {
                    scrollFragmentTabHost7 = this.cIB.cIv;
                }
                this.cIB.ap(this.cIB.getView());
                list = this.cIB.cIx;
                if (list.containsAll(gVar.aqo())) {
                    List<String> aqo = gVar.aqo();
                    list4 = this.cIB.cIx;
                }
                list2 = this.cIB.cIx;
                list2.clear();
                list3 = this.cIB.cIx;
                list3.addAll(gVar.aqo());
                scrollFragmentTabHost3 = this.cIB.cIv;
                scrollFragmentTabHost3.reset();
                scrollFragmentTabHost4 = this.cIB.cIv;
                aVar = this.cIB.cIA;
                scrollFragmentTabHost4.b(aVar);
                scrollFragmentTabHost5 = this.cIB.cIv;
                scrollFragmentTabHost5.bp(gVar.aqo());
                scrollFragmentTabHost6 = this.cIB.cIv;
                scrollFragmentTabHost6.setCurrentTab(0);
            }
            scrollFragmentTabHost = this.cIB.cIv;
            if (scrollFragmentTabHost.aqv()) {
                scrollFragmentTabHost2 = this.cIB.cIv;
                scrollFragmentTabHost2.b(z, str, gVar, z2);
            }
        }
    }

    @Override // com.baidu.tieba.recommendfrs.control.a.b.a
    public void i(String str, String str2, int i) {
        ScrollFragmentTabHost scrollFragmentTabHost;
        ScrollFragmentTabHost scrollFragmentTabHost2;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.cIB.ap(this.cIB.getView());
        scrollFragmentTabHost = this.cIB.cIv;
        if (scrollFragmentTabHost.aqv()) {
            scrollFragmentTabHost2 = this.cIB.cIv;
            scrollFragmentTabHost2.j(str, str2, i);
        } else if (this.cIB.getPageContext() == null || this.cIB.getPageContext().getResources() == null) {
        } else {
            this.cIB.showNetRefreshView(this.cIB.getView(), this.cIB.getPageContext().getResources().getString(i.h.net_error_text, str2, Integer.valueOf(i)), false);
        }
    }
}
