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
    final /* synthetic */ a cbM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.cbM = aVar;
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
            if (fVar != null && fVar.ahF() != null && "头条".equals(str)) {
                if (!z) {
                    scrollFragmentTabHost7 = this.cbM.cbF;
                }
                list = this.cbM.cbJ;
                if (list.containsAll(fVar.ahF())) {
                    List<String> ahF = fVar.ahF();
                    list4 = this.cbM.cbJ;
                }
                this.cbM.cbH = true;
                this.cbM.T(this.cbM.getView());
                list2 = this.cbM.cbJ;
                list2.clear();
                list3 = this.cbM.cbJ;
                list3.addAll(fVar.ahF());
                scrollFragmentTabHost3 = this.cbM.cbF;
                scrollFragmentTabHost3.reset();
                float dimension = this.cbM.getResources().getDimension(o.ds28);
                for (String str2 : fVar.ahF()) {
                    if (!StringUtils.isNull(str2)) {
                        String fixedText = UtilHelper.getFixedText(str2, 4, false);
                        FragmentActivity activity = this.cbM.getActivity();
                        bVar = this.cbM.cbG;
                        com.baidu.tieba.recommendfrs.indicator.e eVar = new com.baidu.tieba.recommendfrs.indicator.e(activity, bVar, fixedText, dimension);
                        scrollFragmentTabHost6 = this.cbM.cbF;
                        scrollFragmentTabHost6.a(eVar);
                    }
                }
                scrollFragmentTabHost4 = this.cbM.cbF;
                scrollFragmentTabHost4.initViewPager();
                scrollFragmentTabHost5 = this.cbM.cbF;
                scrollFragmentTabHost5.setCurrentTab(0);
                return;
            }
            scrollFragmentTabHost = this.cbM.cbF;
            if (scrollFragmentTabHost.getTabcount() > 0) {
                scrollFragmentTabHost2 = this.cbM.cbF;
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
        this.cbM.T(this.cbM.getView());
        scrollFragmentTabHost = this.cbM.cbF;
        if (scrollFragmentTabHost.getTabcount() > 0) {
            scrollFragmentTabHost2 = this.cbM.cbF;
            Fragment jc = scrollFragmentTabHost2.jc(str);
            if (jc instanceof com.baidu.tieba.recommendfrs.b) {
                ((com.baidu.tieba.recommendfrs.b) jc).Q(str2, i);
            }
        } else if (this.cbM.getPageContext() == null || this.cbM.getPageContext().getResources() == null) {
        } else {
            this.cbM.showNetRefreshView(this.cbM.getView(), this.cbM.getPageContext().getResources().getString(t.net_error_text, str2, Integer.valueOf(i)), false);
        }
    }
}
