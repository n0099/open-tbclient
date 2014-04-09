package com.baidu.tieba.util;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.view.CustomTextView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public final class j {
    private final Context a;
    private final int b;
    private final int c;
    private boolean d = false;
    private int e = -16777216;

    public j(Context context) {
        this.a = context;
        TextView textView = new TextView(this.a);
        textView.setLineSpacing(0.0f, 1.2f);
        textView.setTextSize(com.baidu.tbadk.core.data.n.p());
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
    public final void a(TextView textView, LinearLayout linearLayout, List<com.baidu.tieba.data.f> list, boolean z) {
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
                        com.baidu.tieba.data.f fVar = list.get(i3);
                        int a = fVar.a();
                        int length = (a == 0 || a == 4 || a == 1) ? fVar.d() != null ? fVar.d().length() + i2 : i2 : i2 + 1;
                        if (length > 50) {
                            z3 = true;
                            if (a == 0 || a == 4 || a == 1) {
                                SpannableStringBuilder valueOf = SpannableStringBuilder.valueOf(fVar.d().subSequence(0, 50 - i2));
                                com.baidu.tieba.data.f fVar2 = new com.baidu.tieba.data.f();
                                fVar2.a(valueOf);
                                fVar2.a(a);
                                arrayList.add(fVar2);
                                z2 = true;
                            }
                        } else {
                            arrayList.add(fVar);
                            i2 = length;
                            i3++;
                        }
                    }
                    if (z2) {
                        com.baidu.tieba.data.f fVar3 = new com.baidu.tieba.data.f();
                        fVar3.a(SpannableStringBuilder.valueOf("..."));
                        fVar3.a(0);
                        arrayList.add(fVar3);
                        list = arrayList;
                    }
                }
                CustomTextView customTextView = null;
                com.baidu.tieba.data.f fVar4 = list.get(0);
                if (fVar4 == null || (fVar4.a() != 0 && fVar4.a() != 2 && fVar4.a() != 11)) {
                    i = 0;
                } else {
                    textView.setTextSize(com.baidu.tbadk.core.data.n.p());
                    textView.setVisibility(0);
                    a(textView, fVar4);
                    i = 1;
                    customTextView = textView;
                }
                if (linearLayout != null) {
                    linearLayout.setVisibility(8);
                    int i4 = i;
                    while (i4 < list.size()) {
                        linearLayout.setVisibility(0);
                        com.baidu.tieba.data.f fVar5 = list.get(i4);
                        if (fVar5.a() != 3) {
                            if (customTextView != null) {
                                if (fVar5.a() == 2) {
                                    Context context = this.a;
                                    d = fVar5.c(this.b, this.c);
                                } else {
                                    d = fVar5.d();
                                }
                                if (d != null) {
                                    customTextView.append(d);
                                }
                            } else {
                                customTextView = new CustomTextView(this.a);
                                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                                int a2 = com.baidu.adp.lib.util.i.a(this.a, 15.0f);
                                layoutParams.rightMargin = 0;
                                layoutParams.leftMargin = 0;
                                layoutParams.topMargin = a2;
                                layoutParams.bottomMargin = 0;
                                customTextView.setLineSpacing(0.0f, 1.2f);
                                customTextView.setTextSize(com.baidu.tbadk.core.data.n.p());
                                if (TbadkApplication.j().l() == 1) {
                                    customTextView.setTextColor(ba.a(1));
                                } else {
                                    customTextView.setTextColor(this.e);
                                }
                                a(customTextView, fVar5);
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

    private void a(TextView textView, com.baidu.tieba.data.f fVar) {
        if (textView != null && fVar != null) {
            if (fVar.a() == 2) {
                Context context = this.a;
                textView.setText(fVar.c(this.b, this.c));
            } else if (fVar.a() == 11) {
                textView.setText("[" + fVar.c() + "]");
            } else {
                textView.setText(fVar.d());
            }
        }
    }

    public final void a(int i) {
        this.e = -13421773;
    }
}
