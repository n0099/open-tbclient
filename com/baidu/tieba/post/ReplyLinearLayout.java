package com.baidu.tieba.post;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class ReplyLinearLayout extends LinearLayout {

    /* renamed from: g  reason: collision with root package name */
    public static ViewGroup.LayoutParams f20117g;

    /* renamed from: e  reason: collision with root package name */
    public List<TextView> f20118e;

    /* renamed from: f  reason: collision with root package name */
    public View.OnClickListener f20119f;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String[] strArr = (String[]) view.getTag();
            if (strArr != null) {
                Context context = ReplyLinearLayout.this.getContext();
                if ("0".equals(strArr[3])) {
                    PbActivityConfig createNormalCfg = new PbActivityConfig(context).createNormalCfg(strArr[1], strArr[2], "person_page");
                    createNormalCfg.setStartFrom(4);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
                    return;
                }
                SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(context).createSubPbActivityConfig(strArr[1], strArr[2], "person_post_reply", false, null, false);
                createSubPbActivityConfig.setKeyPageStartFrom(4);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createSubPbActivityConfig));
            }
        }
    }

    public ReplyLinearLayout(Context context) {
        this(context, null);
    }

    public final void a(TextView textView, int i2) {
        if (i2 == 0) {
            SkinManager.setViewTextColor(textView, R.color.common_color_10039, 1);
            textView.setPadding(0, l.e(getContext(), 10.0f), 0, l.e(getContext(), 10.0f));
            return;
        }
        int i3 = i2 % 3;
        if (i3 == 2) {
            SkinManager.setViewTextColor(textView, R.color.common_color_10081, 1);
            textView.setPadding(0, l.e(getContext(), 10.0f), 0, l.e(getContext(), 2.0f));
        } else if (i3 == 0) {
            SkinManager.setViewTextColor(textView, R.color.common_color_10005, 1);
            textView.setPadding(0, l.e(getContext(), 2.0f), 0, l.e(getContext(), 10.0f));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setContent(ArrayList<String[]> arrayList) {
        int i2;
        CharSequence[] charSequenceArr;
        int i3;
        int i4;
        if (f20117g == null) {
            f20117g = new LinearLayout.LayoutParams(-1, -2);
        }
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 1);
        int size = ((arrayList.size() - 1) * 3) + 1;
        int size2 = size - this.f20118e.size();
        for (int i5 = 0; i5 < size2; i5++) {
            TextView textView = new TextView(getContext());
            this.f20118e.add(textView);
            addView(textView);
        }
        for (int i6 = 0; i6 < this.f20118e.size(); i6++) {
            TextView textView2 = this.f20118e.get(i6);
            if (i6 < size) {
                if (i6 != 0 && i6 != 1) {
                    int i7 = i6 % 3;
                    if (i7 == 0 || i7 == 1) {
                        i2 = i6 / 3;
                    } else if (i7 == 2) {
                        i2 = (i6 / 3) + 1;
                    }
                    charSequenceArr = (String[]) arrayList.get(i2);
                    if (i6 != 0 || (i4 = i6 % 3) == 2) {
                        textView2.setText(charSequenceArr[0]);
                    } else if (i4 == 0) {
                        textView2.setText(charSequenceArr[4]);
                    }
                    textView2.setTag(charSequenceArr);
                    textView2.setOnClickListener(this.f20119f);
                    a(textView2, i6);
                    if (i6 != 0) {
                        textView2.setTextSize(17.0f);
                        textView2.setMaxLines(3);
                        textView2.setLayoutParams(f20117g);
                        SkinManager.setViewTextColor(textView2, R.color.CAM_X0105, 1);
                    } else if (i6 == 1 || (i3 = i6 % 3) == 1) {
                        textView2.setLayoutParams(layoutParams);
                        SkinManager.setBackgroundResource(textView2, R.color.CAM_X0204);
                    } else if (i3 == 2) {
                        textView2.setTextSize(15.0f);
                        textView2.setMaxLines(2);
                        textView2.setLayoutParams(f20117g);
                        SkinManager.setViewTextColor(textView2, R.color.CAM_X0106, 1);
                    } else if (i3 == 0) {
                        textView2.setTextSize(10.0f);
                        textView2.setLayoutParams(f20117g);
                        SkinManager.setViewTextColor(textView2, R.color.CAM_X0109, 1);
                    }
                    textView2.setVisibility(0);
                }
                i2 = 0;
                charSequenceArr = (String[]) arrayList.get(i2);
                if (i6 != 0) {
                }
                textView2.setText(charSequenceArr[0]);
                textView2.setTag(charSequenceArr);
                textView2.setOnClickListener(this.f20119f);
                a(textView2, i6);
                if (i6 != 0) {
                }
                textView2.setVisibility(0);
            } else {
                textView2.setVisibility(8);
            }
        }
    }

    public ReplyLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f20119f = new a();
        this.f20118e = new ArrayList();
    }
}
