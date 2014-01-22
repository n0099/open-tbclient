package com.baidu.tieba.util;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class cf implements cg {
    final /* synthetic */ int a;
    final /* synthetic */ boolean b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cf(int i, boolean z) {
        this.a = i;
        this.b = z;
    }

    @Override // com.baidu.tieba.util.cg
    public boolean a(View view) {
        int b;
        int b2;
        int b3;
        int b4;
        Object tag = view.getTag();
        if (tag != null) {
            if ("skin_text_group".equals(tag)) {
                ce.b((TextView) view, this.a);
                return false;
            } else if ("skin_text_content".equals(tag)) {
                ce.b((TextView) view, this.a);
                return false;
            } else if ("skin_text_num".equals(tag)) {
                ce.a((TextView) view, this.a);
                return false;
            } else if ("skin_check_box".equals(tag)) {
                ce.a((CheckBox) view, this.a);
                return false;
            } else if ("skin_sidebar_content".equals(tag)) {
                ((TextView) view).setTextAppearance(TiebaApplication.h(), this.b ? R.style.sidebar_content_1 : R.style.sidebar_content);
                return false;
            } else if ("skin_more_up".equals(tag)) {
                if (view instanceof RadioButton) {
                    b4 = ce.b(this.b);
                    ((RadioButton) view).setTextColor(b4);
                }
                bs.e(view, this.b ? R.drawable.more_up_1 : R.drawable.more_up);
                return false;
            } else if ("skin_more_middle".equals(tag)) {
                if (view instanceof RadioButton) {
                    b3 = ce.b(this.b);
                    ((RadioButton) view).setTextColor(b3);
                }
                bs.e(view, this.b ? R.drawable.more_middle_1 : R.drawable.more_middle);
                return false;
            } else if ("skin_more_down".equals(tag)) {
                if (view instanceof RadioButton) {
                    b2 = ce.b(this.b);
                    ((RadioButton) view).setTextColor(b2);
                }
                bs.e(view, this.b ? R.drawable.more_down_1 : R.drawable.more_down);
                return false;
            } else if ("skin_more_all".equals(tag)) {
                if (view instanceof RadioButton) {
                    b = ce.b(this.b);
                    ((RadioButton) view).setTextColor(b);
                }
                bs.e(view, this.b ? R.drawable.more_all_1 : R.drawable.more_all);
                return false;
            } else if ("skin_arrow".equals(tag)) {
                ((ImageView) view).setImageResource(this.b ? R.drawable.icon_ba_top_arrow_big_1 : R.drawable.icon_ba_top_arrow_big);
                return false;
            } else if ("skin_list_line".equals(tag)) {
                ce.a(view, this.a);
                return false;
            } else {
                return false;
            }
        }
        return false;
    }
}
