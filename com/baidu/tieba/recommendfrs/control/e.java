package com.baidu.tieba.recommendfrs.control;

import android.text.TextUtils;
import com.baidu.tieba.i;
import com.baidu.tieba.recommendfrs.control.a.b;
import com.baidu.tieba.recommendfrs.indicator.ScrollFragmentTabHost;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements b.a {
    final /* synthetic */ a cBa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar) {
        this.cBa = aVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0075, code lost:
        if (r0.aob() == false) goto L27;
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
                scrollFragmentTabHost8 = this.cBa.cAU;
                if (!scrollFragmentTabHost8.aob() && gVar != null && gVar.isEmpty()) {
                    if (this.cBa.getPageContext() == null || this.cBa.getPageContext().getResources() == null) {
                        return;
                    }
                    this.cBa.ao(this.cBa.getView());
                    this.cBa.showNetRefreshView(this.cBa.getView(), this.cBa.getPageContext().getResources().getString(i.h.neterror), false);
                    return;
                }
            }
            if (gVar != null && gVar.anU() != null && "头条".equals(str)) {
                if (!z) {
                    scrollFragmentTabHost7 = this.cBa.cAU;
                }
                this.cBa.ao(this.cBa.getView());
                list = this.cBa.cAW;
                if (list.containsAll(gVar.anU())) {
                    List<String> anU = gVar.anU();
                    list4 = this.cBa.cAW;
                }
                list2 = this.cBa.cAW;
                list2.clear();
                list3 = this.cBa.cAW;
                list3.addAll(gVar.anU());
                scrollFragmentTabHost3 = this.cBa.cAU;
                scrollFragmentTabHost3.reset();
                scrollFragmentTabHost4 = this.cBa.cAU;
                aVar = this.cBa.cAZ;
                scrollFragmentTabHost4.b(aVar);
                scrollFragmentTabHost5 = this.cBa.cAU;
                scrollFragmentTabHost5.bm(gVar.anU());
                scrollFragmentTabHost6 = this.cBa.cAU;
                scrollFragmentTabHost6.setCurrentTab(0);
            }
            scrollFragmentTabHost = this.cBa.cAU;
            if (scrollFragmentTabHost.aob()) {
                scrollFragmentTabHost2 = this.cBa.cAU;
                scrollFragmentTabHost2.b(z, str, gVar, z2);
            }
        }
    }

    @Override // com.baidu.tieba.recommendfrs.control.a.b.a
    public void h(String str, String str2, int i) {
        ScrollFragmentTabHost scrollFragmentTabHost;
        ScrollFragmentTabHost scrollFragmentTabHost2;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.cBa.ao(this.cBa.getView());
        scrollFragmentTabHost = this.cBa.cAU;
        if (scrollFragmentTabHost.aob()) {
            scrollFragmentTabHost2 = this.cBa.cAU;
            scrollFragmentTabHost2.i(str, str2, i);
        } else if (this.cBa.getPageContext() == null || this.cBa.getPageContext().getResources() == null) {
        } else {
            this.cBa.showNetRefreshView(this.cBa.getView(), this.cBa.getPageContext().getResources().getString(i.h.net_error_text, str2, Integer.valueOf(i)), false);
        }
    }
}
