package com.baidu.tieba.recommendfrs.control;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.o;
import com.baidu.tieba.recommendfrs.data.f;
import com.baidu.tieba.recommendfrs.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.t;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements com.baidu.tieba.recommendfrs.control.a.e {
    final /* synthetic */ a cbN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.cbN = aVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0024, code lost:
        if (r0.getTabcount() == 0) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0044, code lost:
        if (r0.containsAll(r1) == false) goto L17;
     */
    @Override // com.baidu.tieba.recommendfrs.control.a.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(boolean z, f fVar, boolean z2, String str) {
        ScrollFragmentTabHost scrollFragmentTabHost;
        ScrollFragmentTabHost scrollFragmentTabHost2;
        List list;
        List list2;
        List list3;
        ScrollFragmentTabHost scrollFragmentTabHost3;
        ScrollFragmentTabHost scrollFragmentTabHost4;
        ScrollFragmentTabHost scrollFragmentTabHost5;
        com.baidu.tieba.recommendfrs.control.a.b bVar;
        ScrollFragmentTabHost scrollFragmentTabHost6;
        List list4;
        ScrollFragmentTabHost scrollFragmentTabHost7;
        if (!TextUtils.isEmpty(str)) {
            if (fVar != null && fVar.ahG() != null && "头条".equals(str)) {
                if (!z) {
                    scrollFragmentTabHost7 = this.cbN.cbG;
                }
                list = this.cbN.cbK;
                if (list.containsAll(fVar.ahG())) {
                    List<String> ahG = fVar.ahG();
                    list4 = this.cbN.cbK;
                }
                this.cbN.cbI = true;
                this.cbN.T(this.cbN.getView());
                list2 = this.cbN.cbK;
                list2.clear();
                list3 = this.cbN.cbK;
                list3.addAll(fVar.ahG());
                scrollFragmentTabHost3 = this.cbN.cbG;
                scrollFragmentTabHost3.reset();
                float dimension = this.cbN.getResources().getDimension(o.ds28);
                for (String str2 : fVar.ahG()) {
                    if (!StringUtils.isNull(str2)) {
                        String fixedText = UtilHelper.getFixedText(str2, 4, false);
                        FragmentActivity activity = this.cbN.getActivity();
                        bVar = this.cbN.cbH;
                        com.baidu.tieba.recommendfrs.indicator.e eVar = new com.baidu.tieba.recommendfrs.indicator.e(activity, bVar, fixedText, dimension);
                        scrollFragmentTabHost6 = this.cbN.cbG;
                        scrollFragmentTabHost6.a(eVar);
                    }
                }
                scrollFragmentTabHost4 = this.cbN.cbG;
                scrollFragmentTabHost4.initViewPager();
                scrollFragmentTabHost5 = this.cbN.cbG;
                scrollFragmentTabHost5.setCurrentTab(0);
                return;
            }
            scrollFragmentTabHost = this.cbN.cbG;
            if (scrollFragmentTabHost.getTabcount() > 0) {
                scrollFragmentTabHost2 = this.cbN.cbG;
                Fragment jc = scrollFragmentTabHost2.jc(str);
                if (jc instanceof com.baidu.tieba.recommendfrs.b) {
                    ((com.baidu.tieba.recommendfrs.b) jc).a(z, fVar, z2);
                }
            }
        }
    }

    @Override // com.baidu.tieba.recommendfrs.control.a.e
    public void h(String str, String str2, int i) {
        ScrollFragmentTabHost scrollFragmentTabHost;
        ScrollFragmentTabHost scrollFragmentTabHost2;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.cbN.T(this.cbN.getView());
        scrollFragmentTabHost = this.cbN.cbG;
        if (scrollFragmentTabHost.getTabcount() > 0) {
            scrollFragmentTabHost2 = this.cbN.cbG;
            Fragment jc = scrollFragmentTabHost2.jc(str);
            if (jc instanceof com.baidu.tieba.recommendfrs.b) {
                ((com.baidu.tieba.recommendfrs.b) jc).Q(str2, i);
            }
        } else if (this.cbN.getPageContext() == null || this.cbN.getPageContext().getResources() == null) {
        } else {
            this.cbN.showNetRefreshView(this.cbN.getView(), this.cbN.getPageContext().getResources().getString(t.net_error_text, str2, Integer.valueOf(i)), false);
        }
    }
}
