package com.baidu.tieba.recommendfrs.control;

import android.text.TextUtils;
import com.baidu.tieba.i;
import com.baidu.tieba.recommendfrs.control.a.b;
import com.baidu.tieba.recommendfrs.indicator.ScrollFragmentTabHost;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements b.a {
    final /* synthetic */ a cIc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar) {
        this.cIc = aVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0075, code lost:
        if (r0.aqt() == false) goto L27;
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
                scrollFragmentTabHost8 = this.cIc.cHW;
                if (!scrollFragmentTabHost8.aqt() && gVar != null && gVar.isEmpty()) {
                    if (this.cIc.getPageContext() == null || this.cIc.getPageContext().getResources() == null) {
                        return;
                    }
                    this.cIc.ap(this.cIc.getView());
                    this.cIc.showNetRefreshView(this.cIc.getView(), this.cIc.getPageContext().getResources().getString(i.h.neterror), false);
                    return;
                }
            }
            if (gVar != null && gVar.aqm() != null && "头条".equals(str)) {
                if (!z) {
                    scrollFragmentTabHost7 = this.cIc.cHW;
                }
                this.cIc.ap(this.cIc.getView());
                list = this.cIc.cHY;
                if (list.containsAll(gVar.aqm())) {
                    List<String> aqm = gVar.aqm();
                    list4 = this.cIc.cHY;
                }
                list2 = this.cIc.cHY;
                list2.clear();
                list3 = this.cIc.cHY;
                list3.addAll(gVar.aqm());
                scrollFragmentTabHost3 = this.cIc.cHW;
                scrollFragmentTabHost3.reset();
                scrollFragmentTabHost4 = this.cIc.cHW;
                aVar = this.cIc.cIb;
                scrollFragmentTabHost4.b(aVar);
                scrollFragmentTabHost5 = this.cIc.cHW;
                scrollFragmentTabHost5.bo(gVar.aqm());
                scrollFragmentTabHost6 = this.cIc.cHW;
                scrollFragmentTabHost6.setCurrentTab(0);
            }
            scrollFragmentTabHost = this.cIc.cHW;
            if (scrollFragmentTabHost.aqt()) {
                scrollFragmentTabHost2 = this.cIc.cHW;
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
        this.cIc.ap(this.cIc.getView());
        scrollFragmentTabHost = this.cIc.cHW;
        if (scrollFragmentTabHost.aqt()) {
            scrollFragmentTabHost2 = this.cIc.cHW;
            scrollFragmentTabHost2.j(str, str2, i);
        } else if (this.cIc.getPageContext() == null || this.cIc.getPageContext().getResources() == null) {
        } else {
            this.cIc.showNetRefreshView(this.cIc.getView(), this.cIc.getPageContext().getResources().getString(i.h.net_error_text, str2, Integer.valueOf(i)), false);
        }
    }
}
