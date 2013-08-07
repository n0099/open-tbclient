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
public class aq implements au {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ int f1756a;
    private final /* synthetic */ boolean b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(int i, boolean z) {
        this.f1756a = i;
        this.b = z;
    }

    @Override // com.baidu.tieba.util.au
    public boolean a(View view) {
        int i;
        int i2;
        int i3;
        int i4;
        Object tag = view.getTag();
        if (tag != null) {
            if ("skin_text_group".equals(tag)) {
                ap.b((TextView) view, this.f1756a);
                return false;
            } else if ("skin_text_content".equals(tag)) {
                ap.b((TextView) view, this.f1756a);
                return false;
            } else if ("skin_text_num".equals(tag)) {
                ap.a((TextView) view, this.f1756a);
                return false;
            } else if ("skin_check_box".equals(tag)) {
                ap.a((CheckBox) view, this.f1756a);
                return false;
            } else if ("skin_sidebar_content".equals(tag)) {
                ((TextView) view).setTextAppearance(TiebaApplication.f(), this.b ? R.style.sidebar_content_1 : R.style.sidebar_content);
                return false;
            } else if ("skin_more_up".equals(tag)) {
                if (view instanceof RadioButton) {
                    RadioButton radioButton = (RadioButton) view;
                    if (this.b) {
                        i4 = ap.f1755a;
                    } else {
                        i4 = ap.b;
                    }
                    radioButton.setTextColor(i4);
                }
                ah.h(view, this.b ? R.drawable.more_up_1 : R.drawable.more_up);
                return false;
            } else if ("skin_more_middle".equals(tag)) {
                if (view instanceof RadioButton) {
                    RadioButton radioButton2 = (RadioButton) view;
                    if (this.b) {
                        i3 = ap.f1755a;
                    } else {
                        i3 = ap.b;
                    }
                    radioButton2.setTextColor(i3);
                }
                ah.h(view, this.b ? R.drawable.more_middle_1 : R.drawable.more_middle);
                return false;
            } else if ("skin_more_down".equals(tag)) {
                if (view instanceof RadioButton) {
                    RadioButton radioButton3 = (RadioButton) view;
                    if (this.b) {
                        i2 = ap.f1755a;
                    } else {
                        i2 = ap.b;
                    }
                    radioButton3.setTextColor(i2);
                }
                ah.h(view, this.b ? R.drawable.more_down_1 : R.drawable.more_down);
                return false;
            } else if ("skin_more_all".equals(tag)) {
                if (view instanceof RadioButton) {
                    RadioButton radioButton4 = (RadioButton) view;
                    if (this.b) {
                        i = ap.f1755a;
                    } else {
                        i = ap.b;
                    }
                    radioButton4.setTextColor(i);
                }
                ah.h(view, this.b ? R.drawable.more_all_1 : R.drawable.more_all);
                return false;
            } else if ("skin_arrow".equals(tag)) {
                ((ImageView) view).setImageResource(this.b ? R.drawable.icon_arrow_right_1 : R.drawable.icon_arrow_right);
                return false;
            } else if ("skin_list_line".equals(tag)) {
                ap.a(view, this.f1756a);
                return false;
            } else {
                return false;
            }
        }
        return false;
    }
}
