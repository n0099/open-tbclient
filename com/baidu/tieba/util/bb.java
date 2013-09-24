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
public class bb implements bf {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ int f1914a;
    private final /* synthetic */ boolean b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(int i, boolean z) {
        this.f1914a = i;
        this.b = z;
    }

    @Override // com.baidu.tieba.util.bf
    public boolean a(View view) {
        int i;
        int i2;
        int i3;
        int i4;
        Object tag = view.getTag();
        if (tag != null) {
            if ("skin_text_group".equals(tag)) {
                ba.b((TextView) view, this.f1914a);
                return false;
            } else if ("skin_text_content".equals(tag)) {
                ba.b((TextView) view, this.f1914a);
                return false;
            } else if ("skin_text_num".equals(tag)) {
                ba.a((TextView) view, this.f1914a);
                return false;
            } else if ("skin_check_box".equals(tag)) {
                ba.a((CheckBox) view, this.f1914a);
                return false;
            } else if ("skin_sidebar_content".equals(tag)) {
                ((TextView) view).setTextAppearance(TiebaApplication.g(), this.b ? R.style.sidebar_content_1 : R.style.sidebar_content);
                return false;
            } else if ("skin_more_up".equals(tag)) {
                if (view instanceof RadioButton) {
                    RadioButton radioButton = (RadioButton) view;
                    if (this.b) {
                        i4 = ba.f1913a;
                    } else {
                        i4 = ba.b;
                    }
                    radioButton.setTextColor(i4);
                }
                as.e(view, this.b ? R.drawable.more_up_1 : R.drawable.more_up);
                return false;
            } else if ("skin_more_middle".equals(tag)) {
                if (view instanceof RadioButton) {
                    RadioButton radioButton2 = (RadioButton) view;
                    if (this.b) {
                        i3 = ba.f1913a;
                    } else {
                        i3 = ba.b;
                    }
                    radioButton2.setTextColor(i3);
                }
                as.e(view, this.b ? R.drawable.more_middle_1 : R.drawable.more_middle);
                return false;
            } else if ("skin_more_down".equals(tag)) {
                if (view instanceof RadioButton) {
                    RadioButton radioButton3 = (RadioButton) view;
                    if (this.b) {
                        i2 = ba.f1913a;
                    } else {
                        i2 = ba.b;
                    }
                    radioButton3.setTextColor(i2);
                }
                as.e(view, this.b ? R.drawable.more_down_1 : R.drawable.more_down);
                return false;
            } else if ("skin_more_all".equals(tag)) {
                if (view instanceof RadioButton) {
                    RadioButton radioButton4 = (RadioButton) view;
                    if (this.b) {
                        i = ba.f1913a;
                    } else {
                        i = ba.b;
                    }
                    radioButton4.setTextColor(i);
                }
                as.e(view, this.b ? R.drawable.more_all_1 : R.drawable.more_all);
                return false;
            } else if ("skin_arrow".equals(tag)) {
                ((ImageView) view).setImageResource(this.b ? R.drawable.icon_arrow_right_1 : R.drawable.icon_arrow_right);
                return false;
            } else if ("skin_list_line".equals(tag)) {
                ba.a(view, this.f1914a);
                return false;
            } else {
                return false;
            }
        }
        return false;
    }
}
