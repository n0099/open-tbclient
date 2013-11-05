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
public final class bk implements bo {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f2444a;
    final /* synthetic */ boolean b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bk(int i, boolean z) {
        this.f2444a = i;
        this.b = z;
    }

    @Override // com.baidu.tieba.util.bo
    public boolean a(View view) {
        Object tag = view.getTag();
        if (tag != null) {
            if ("skin_text_group".equals(tag)) {
                bj.b((TextView) view, this.f2444a);
                return false;
            } else if ("skin_text_content".equals(tag)) {
                bj.b((TextView) view, this.f2444a);
                return false;
            } else if ("skin_text_num".equals(tag)) {
                bj.a((TextView) view, this.f2444a);
                return false;
            } else if ("skin_check_box".equals(tag)) {
                bj.a((CheckBox) view, this.f2444a);
                return false;
            } else if ("skin_sidebar_content".equals(tag)) {
                ((TextView) view).setTextAppearance(TiebaApplication.g(), this.b ? R.style.sidebar_content_1 : R.style.sidebar_content);
                return false;
            } else if ("skin_more_up".equals(tag)) {
                if (view instanceof RadioButton) {
                    ((RadioButton) view).setTextColor(this.b ? bj.f2443a : bj.b);
                }
                bb.e(view, this.b ? R.drawable.more_up_1 : R.drawable.more_up);
                return false;
            } else if ("skin_more_middle".equals(tag)) {
                if (view instanceof RadioButton) {
                    ((RadioButton) view).setTextColor(this.b ? bj.f2443a : bj.b);
                }
                bb.e(view, this.b ? R.drawable.more_middle_1 : R.drawable.more_middle);
                return false;
            } else if ("skin_more_down".equals(tag)) {
                if (view instanceof RadioButton) {
                    ((RadioButton) view).setTextColor(this.b ? bj.f2443a : bj.b);
                }
                bb.e(view, this.b ? R.drawable.more_down_1 : R.drawable.more_down);
                return false;
            } else if ("skin_more_all".equals(tag)) {
                if (view instanceof RadioButton) {
                    ((RadioButton) view).setTextColor(this.b ? bj.f2443a : bj.b);
                }
                bb.e(view, this.b ? R.drawable.more_all_1 : R.drawable.more_all);
                return false;
            } else if ("skin_arrow".equals(tag)) {
                ((ImageView) view).setImageResource(this.b ? R.drawable.icon_arrow_right_1 : R.drawable.icon_arrow_right);
                return false;
            } else if ("skin_list_line".equals(tag)) {
                bj.a(view, this.f2444a);
                return false;
            } else {
                return false;
            }
        }
        return false;
    }
}
