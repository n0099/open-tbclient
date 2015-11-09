package com.baidu.tieba.recommendfrs.control;

import android.text.TextUtils;
import com.baidu.tieba.i;
import com.baidu.tieba.recommendfrs.control.a.b;
import com.baidu.tieba.recommendfrs.indicator.ScrollFragmentTabHost;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements b.a {
    final /* synthetic */ a cJX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar) {
        this.cJX = aVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0075, code lost:
        if (r0.arb() == false) goto L27;
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
                scrollFragmentTabHost8 = this.cJX.cJR;
                if (!scrollFragmentTabHost8.arb() && gVar != null && gVar.isEmpty()) {
                    if (this.cJX.getPageContext() == null || this.cJX.getPageContext().getResources() == null) {
                        return;
                    }
                    this.cJX.ao(this.cJX.getView());
                    this.cJX.showNetRefreshView(this.cJX.getView(), this.cJX.getPageContext().getResources().getString(i.h.neterror), false);
                    return;
                }
            }
            if (gVar != null && gVar.aqU() != null && "头条".equals(str)) {
                if (!z) {
                    scrollFragmentTabHost7 = this.cJX.cJR;
                }
                this.cJX.ao(this.cJX.getView());
                list = this.cJX.cJT;
                if (list.containsAll(gVar.aqU())) {
                    List<String> aqU = gVar.aqU();
                    list4 = this.cJX.cJT;
                }
                list2 = this.cJX.cJT;
                list2.clear();
                list3 = this.cJX.cJT;
                list3.addAll(gVar.aqU());
                scrollFragmentTabHost3 = this.cJX.cJR;
                scrollFragmentTabHost3.reset();
                scrollFragmentTabHost4 = this.cJX.cJR;
                aVar = this.cJX.cJW;
                scrollFragmentTabHost4.b(aVar);
                scrollFragmentTabHost5 = this.cJX.cJR;
                scrollFragmentTabHost5.bt(gVar.aqU());
                scrollFragmentTabHost6 = this.cJX.cJR;
                scrollFragmentTabHost6.setCurrentTab(0);
            }
            scrollFragmentTabHost = this.cJX.cJR;
            if (scrollFragmentTabHost.arb()) {
                scrollFragmentTabHost2 = this.cJX.cJR;
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
        this.cJX.ao(this.cJX.getView());
        scrollFragmentTabHost = this.cJX.cJR;
        if (scrollFragmentTabHost.arb()) {
            scrollFragmentTabHost2 = this.cJX.cJR;
            scrollFragmentTabHost2.j(str, str2, i);
        } else if (this.cJX.getPageContext() == null || this.cJX.getPageContext().getResources() == null) {
        } else {
            this.cJX.showNetRefreshView(this.cJX.getView(), this.cJX.getPageContext().getResources().getString(i.h.net_error_text, str2, Integer.valueOf(i)), false);
        }
    }
}
