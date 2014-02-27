package com.baidu.tieba.util;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.view.CustomTextView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public final class t {
    private Context a;
    private int b;
    private int c;
    private boolean d = false;
    private int e = -16777216;

    public t(Context context) {
        this.a = context;
        TextView textView = new TextView(this.a);
        textView.setLineSpacing(0.0f, 1.2f);
        textView.setTextSize(com.baidu.tieba.data.i.B());
        this.b = textView.getLineHeight();
        this.c = (int) textView.getTextSize();
    }

    public final void a(boolean z) {
        this.d = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0022, code lost:
        r0 = r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(TextView textView, LinearLayout linearLayout, List<com.baidu.tieba.data.k> list, boolean z) {
        int i;
        CharSequence d;
        boolean z2;
        if (textView != null && linearLayout != null && list != null) {
            if (list != null && list.size() > 0) {
                if (this.d) {
                    ArrayList arrayList = new ArrayList();
                    int i2 = 0;
                    int size = list.size();
                    boolean z3 = false;
                    int i3 = 0;
                    while (true) {
                        if (i3 >= size) {
                            break;
                        }
                        com.baidu.tieba.data.k kVar = list.get(i3);
                        int a = kVar.a();
                        int length = (a == 0 || a == 4 || a == 1) ? kVar.d() != null ? kVar.d().length() + i2 : i2 : i2 + 1;
                        if (length > 50) {
                            z3 = true;
                            if (a == 0 || a == 4 || a == 1) {
                                SpannableStringBuilder valueOf = SpannableStringBuilder.valueOf(kVar.d().subSequence(0, 50 - i2));
                                com.baidu.tieba.data.k kVar2 = new com.baidu.tieba.data.k();
                                kVar2.a(valueOf);
                                kVar2.a(a);
                                arrayList.add(kVar2);
                                z2 = true;
                            }
                        } else {
                            arrayList.add(kVar);
                            i2 = length;
                            i3++;
                        }
                    }
                    if (z2) {
                        com.baidu.tieba.data.k kVar3 = new com.baidu.tieba.data.k();
                        kVar3.a(SpannableStringBuilder.valueOf("..."));
                        kVar3.a(0);
                        arrayList.add(kVar3);
                        list = arrayList;
                    }
                }
                CustomTextView customTextView = null;
                com.baidu.tieba.data.k kVar4 = list.get(0);
                if (kVar4 == null || (kVar4.a() != 0 && kVar4.a() != 2)) {
                    i = 0;
                } else {
                    textView.setTextSize(com.baidu.tieba.data.i.B());
                    textView.setVisibility(0);
                    a(textView, kVar4);
                    i = 1;
                    customTextView = textView;
                }
                if (linearLayout != null) {
                    linearLayout.setVisibility(8);
                    int i4 = i;
                    while (i4 < list.size()) {
                        linearLayout.setVisibility(0);
                        com.baidu.tieba.data.k kVar5 = list.get(i4);
                        if (kVar5.a() != 3) {
                            if (customTextView != null) {
                                if (kVar5.a() == 2) {
                                    Context context = this.a;
                                    d = kVar5.c(this.b, this.c);
                                } else {
                                    d = kVar5.d();
                                }
                                if (d != null) {
                                    customTextView.append(d);
                                }
                            } else {
                                customTextView = new CustomTextView(this.a);
                                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                                int a2 = BdUtilHelper.a(this.a, 15.0f);
                                layoutParams.rightMargin = 0;
                                layoutParams.leftMargin = 0;
                                layoutParams.topMargin = a2;
                                layoutParams.bottomMargin = 0;
                                customTextView.setLineSpacing(0.0f, 1.2f);
                                customTextView.setTextSize(com.baidu.tieba.data.i.B());
                                if (TiebaApplication.g().ae() == 1) {
                                    customTextView.setTextColor(bq.a(1));
                                } else {
                                    customTextView.setTextColor(this.e);
                                }
                                a(customTextView, kVar5);
                                customTextView.setMovementMethod(LinkMovementMethod.getInstance());
                                customTextView.setFocusable(false);
                                customTextView.setLayoutParams(layoutParams);
                                linearLayout.addView(customTextView);
                            }
                        }
                        i4++;
                        customTextView = customTextView;
                    }
                    return;
                }
                return;
            }
            textView.setVisibility(0);
            textView.setText((CharSequence) null);
        }
    }

    private void a(TextView textView, com.baidu.tieba.data.k kVar) {
        if (textView != null && kVar != null) {
            if (kVar.a() == 2) {
                Context context = this.a;
                textView.setText(kVar.c(this.b, this.c));
                return;
            }
            textView.setText(kVar.d());
        }
    }

    public final void a(int i) {
        this.e = -13421773;
    }
}
