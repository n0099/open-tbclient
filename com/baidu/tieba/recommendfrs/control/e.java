package com.baidu.tieba.recommendfrs.control;

import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.n;
import com.baidu.tieba.recommendfrs.control.a.b;
import com.baidu.tieba.recommendfrs.indicator.ScrollFragmentTabHost;
import java.util.List;
import tbclient.ExcFrsPage.ExcellentTagInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements b.a {
    final /* synthetic */ a diB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar) {
        this.diB = aVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x006e, code lost:
        if (r0.awz() == false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0080, code lost:
        if (r0 != false) goto L30;
     */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
    @Override // com.baidu.tieba.recommendfrs.control.a.b.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(boolean z, com.baidu.tieba.recommendfrs.data.c cVar, boolean z2, long j) {
        long j2;
        ScrollFragmentTabHost scrollFragmentTabHost;
        ScrollFragmentTabHost scrollFragmentTabHost2;
        boolean bE;
        List list;
        List list2;
        ScrollFragmentTabHost scrollFragmentTabHost3;
        ScrollFragmentTabHost scrollFragmentTabHost4;
        com.baidu.tieba.recommendfrs.a aVar;
        ScrollFragmentTabHost scrollFragmentTabHost5;
        ScrollFragmentTabHost scrollFragmentTabHost6;
        boolean a;
        ScrollFragmentTabHost scrollFragmentTabHost7;
        ScrollFragmentTabHost scrollFragmentTabHost8;
        if (z) {
            this.diB.ao(this.diB.getView());
        }
        if (z) {
            scrollFragmentTabHost8 = this.diB.div;
            if (!scrollFragmentTabHost8.awz() && cVar != null && cVar.isEmpty()) {
                if (this.diB.getPageContext() == null || this.diB.getPageContext().getResources() == null) {
                    return;
                }
                this.diB.showNetRefreshView(this.diB.getView(), this.diB.getPageContext().getResources().getString(n.i.neterror), false);
                return;
            }
        }
        if (!z2 && cVar != null && y.k(cVar.awk()) != 0) {
            if (!z) {
                scrollFragmentTabHost7 = this.diB.div;
            }
            if (0 != j) {
                a = this.diB.a(cVar.awk(), j);
            }
            bE = this.diB.bE(cVar.awk());
            if (!bE) {
                list = this.diB.dix;
                list.clear();
                list2 = this.diB.dix;
                list2.addAll(cVar.awk());
                scrollFragmentTabHost3 = this.diB.div;
                scrollFragmentTabHost3.reset();
                scrollFragmentTabHost4 = this.diB.div;
                aVar = this.diB.diA;
                scrollFragmentTabHost4.b(aVar);
                scrollFragmentTabHost5 = this.diB.div;
                scrollFragmentTabHost5.bF(cVar.awk());
                scrollFragmentTabHost6 = this.diB.div;
                scrollFragmentTabHost6.setCurrentTab(0);
                ExcellentTagInfo excellentTagInfo = (ExcellentTagInfo) y.b(cVar.awk(), 0);
                if (excellentTagInfo != null) {
                    j2 = excellentTagInfo.tag_code.longValue();
                    scrollFragmentTabHost = this.diB.div;
                    if (!scrollFragmentTabHost.awz()) {
                        scrollFragmentTabHost2 = this.diB.div;
                        scrollFragmentTabHost2.b(z, j2, cVar, z2);
                        return;
                    }
                    return;
                }
            }
        }
        j2 = j;
        scrollFragmentTabHost = this.diB.div;
        if (!scrollFragmentTabHost.awz()) {
        }
    }

    @Override // com.baidu.tieba.recommendfrs.control.a.b.a
    public void a(long j, String str, int i) {
        ScrollFragmentTabHost scrollFragmentTabHost;
        ScrollFragmentTabHost scrollFragmentTabHost2;
        this.diB.ao(this.diB.getView());
        scrollFragmentTabHost = this.diB.div;
        if (scrollFragmentTabHost.awz()) {
            scrollFragmentTabHost2 = this.diB.div;
            scrollFragmentTabHost2.b(j, str, i);
        } else if (this.diB.getPageContext() == null || this.diB.getPageContext().getResources() == null) {
        } else {
            this.diB.showNetRefreshView(this.diB.getView(), this.diB.getPageContext().getResources().getString(n.i.net_error_text, str, Integer.valueOf(i)), false);
        }
    }
}
