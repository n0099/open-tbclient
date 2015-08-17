package com.baidu.tieba.recommendfrs.control;

import android.text.TextUtils;
import com.baidu.tieba.i;
import com.baidu.tieba.recommendfrs.control.a.b;
import com.baidu.tieba.recommendfrs.indicator.ScrollFragmentTabHost;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements b.a {
    final /* synthetic */ a csI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar) {
        this.csI = aVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0075, code lost:
        if (r0.ajV() == false) goto L27;
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
                scrollFragmentTabHost8 = this.csI.csC;
                if (!scrollFragmentTabHost8.ajV() && gVar != null && gVar.isEmpty()) {
                    if (this.csI.getPageContext() == null || this.csI.getPageContext().getResources() == null) {
                        return;
                    }
                    this.csI.af(this.csI.getView());
                    this.csI.showNetRefreshView(this.csI.getView(), this.csI.getPageContext().getResources().getString(i.C0057i.neterror), false);
                    return;
                }
            }
            if (gVar != null && gVar.ajO() != null && "头条".equals(str)) {
                if (!z) {
                    scrollFragmentTabHost7 = this.csI.csC;
                }
                this.csI.af(this.csI.getView());
                list = this.csI.csE;
                if (list.containsAll(gVar.ajO())) {
                    List<String> ajO = gVar.ajO();
                    list4 = this.csI.csE;
                }
                list2 = this.csI.csE;
                list2.clear();
                list3 = this.csI.csE;
                list3.addAll(gVar.ajO());
                scrollFragmentTabHost3 = this.csI.csC;
                scrollFragmentTabHost3.reset();
                scrollFragmentTabHost4 = this.csI.csC;
                aVar = this.csI.csH;
                scrollFragmentTabHost4.b(aVar);
                scrollFragmentTabHost5 = this.csI.csC;
                scrollFragmentTabHost5.be(gVar.ajO());
                scrollFragmentTabHost6 = this.csI.csC;
                scrollFragmentTabHost6.setCurrentTab(0);
            }
            scrollFragmentTabHost = this.csI.csC;
            if (scrollFragmentTabHost.ajV()) {
                scrollFragmentTabHost2 = this.csI.csC;
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
        this.csI.af(this.csI.getView());
        scrollFragmentTabHost = this.csI.csC;
        if (scrollFragmentTabHost.ajV()) {
            scrollFragmentTabHost2 = this.csI.csC;
            scrollFragmentTabHost2.i(str, str2, i);
        } else if (this.csI.getPageContext() == null || this.csI.getPageContext().getResources() == null) {
        } else {
            this.csI.showNetRefreshView(this.csI.getView(), this.csI.getPageContext().getResources().getString(i.C0057i.net_error_text, str2, Integer.valueOf(i)), false);
        }
    }
}
