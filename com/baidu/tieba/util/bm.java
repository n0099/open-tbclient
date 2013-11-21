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
public final class bm implements bn {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f2489a;
    final /* synthetic */ boolean b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bm(int i, boolean z) {
        this.f2489a = i;
        this.b = z;
    }

    @Override // com.baidu.tieba.util.bn
    public boolean a(View view) {
        Object tag = view.getTag();
        if (tag != null) {
            if ("skin_text_group".equals(tag)) {
                bl.b((TextView) view, this.f2489a);
                return false;
            } else if ("skin_text_content".equals(tag)) {
                bl.b((TextView) view, this.f2489a);
                return false;
            } else if ("skin_text_num".equals(tag)) {
                bl.a((TextView) view, this.f2489a);
                return false;
            } else if ("skin_check_box".equals(tag)) {
                bl.a((CheckBox) view, this.f2489a);
                return false;
            } else if ("skin_sidebar_content".equals(tag)) {
                ((TextView) view).setTextAppearance(TiebaApplication.g(), this.b ? R.style.sidebar_content_1 : R.style.sidebar_content);
                return false;
            } else if ("skin_more_up".equals(tag)) {
                if (view instanceof RadioButton) {
                    ((RadioButton) view).setTextColor(this.b ? bl.f2488a : bl.b);
                }
                bd.e(view, this.b ? R.drawable.more_up_1 : R.drawable.more_up);
                return false;
            } else if ("skin_more_middle".equals(tag)) {
                if (view instanceof RadioButton) {
                    ((RadioButton) view).setTextColor(this.b ? bl.f2488a : bl.b);
                }
                bd.e(view, this.b ? R.drawable.more_middle_1 : R.drawable.more_middle);
                return false;
            } else if ("skin_more_down".equals(tag)) {
                if (view instanceof RadioButton) {
                    ((RadioButton) view).setTextColor(this.b ? bl.f2488a : bl.b);
                }
                bd.e(view, this.b ? R.drawable.more_down_1 : R.drawable.more_down);
                return false;
            } else if ("skin_more_all".equals(tag)) {
                if (view instanceof RadioButton) {
                    ((RadioButton) view).setTextColor(this.b ? bl.f2488a : bl.b);
                }
                bd.e(view, this.b ? R.drawable.more_all_1 : R.drawable.more_all);
                return false;
            } else if ("skin_arrow".equals(tag)) {
                ((ImageView) view).setImageResource(this.b ? R.drawable.icon_ba_top_arrow_big_1 : R.drawable.icon_ba_top_arrow_big);
                return false;
            } else if ("skin_list_line".equals(tag)) {
                bl.a(view, this.f2489a);
                return false;
            } else {
                return false;
            }
        }
        return false;
    }
}
