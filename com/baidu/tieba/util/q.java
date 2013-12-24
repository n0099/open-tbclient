package com.baidu.tieba.util;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.view.CustomTextView;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class q {
    private Context a;
    private int b;
    private int c;
    private i d;
    private View.OnClickListener e;
    private boolean f = false;
    private int g = -16777216;

    public q(Context context) {
        this.a = context;
        TextView textView = new TextView(this.a);
        textView.setLineSpacing(0.0f, 1.2f);
        textView.setTextSize(com.baidu.tieba.data.h.q());
        this.b = textView.getLineHeight();
        this.c = (int) textView.getTextSize();
    }

    public void a(boolean z) {
        this.f = z;
    }

    public void a(TextView textView, LinearLayout linearLayout, List<com.baidu.tieba.data.j> list, boolean z) {
        TextView textView2;
        int i;
        if (textView != null && linearLayout != null && list != null) {
            if (list != null && list.size() > 0) {
                if (this.f) {
                    list = a(list);
                }
                com.baidu.tieba.data.j jVar = list.get(0);
                if (jVar == null || !(jVar.a() == 0 || jVar.a() == 2)) {
                    textView2 = null;
                    i = 0;
                } else {
                    textView.setTextSize(com.baidu.tieba.data.h.q());
                    textView.setVisibility(0);
                    a(textView, jVar);
                    i = 1;
                    textView2 = textView;
                }
                if (linearLayout != null) {
                    int i2 = -1;
                    linearLayout.setVisibility(8);
                    while (true) {
                        int i3 = i;
                        TextView textView3 = textView2;
                        int i4 = i2;
                        if (i3 < list.size()) {
                            linearLayout.setVisibility(0);
                            com.baidu.tieba.data.j jVar2 = list.get(i3);
                            if (jVar2.a() == 3) {
                                if (z) {
                                    int i5 = i4 + 1;
                                    linearLayout.addView(a(list, jVar2, i5));
                                    i2 = i5;
                                    textView2 = null;
                                } else {
                                    i2 = i4;
                                    textView2 = textView3;
                                }
                            } else if (textView3 != null) {
                                if (jVar2.a() == 2) {
                                    textView3.append(jVar2.a(this.a, this.b, this.c));
                                    i2 = i4;
                                    textView2 = textView3;
                                } else {
                                    textView3.append(jVar2.c());
                                    i2 = i4;
                                    textView2 = textView3;
                                }
                            } else {
                                TextView a = a(jVar2);
                                linearLayout.addView(a);
                                i2 = i4;
                                textView2 = a;
                            }
                            i = i3 + 1;
                        } else {
                            return;
                        }
                    }
                }
            } else {
                textView.setVisibility(0);
                textView.setText((CharSequence) null);
            }
        }
    }

    private List<com.baidu.tieba.data.j> a(List<com.baidu.tieba.data.j> list) {
        boolean z;
        int length;
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i >= size) {
                z = false;
                break;
            }
            com.baidu.tieba.data.j jVar = list.get(i);
            int a = jVar.a();
            if (a == 0 || a == 4 || a == 1) {
                length = jVar.c() != null ? jVar.c().length() + i2 : i2;
            } else {
                length = i2 + 1;
            }
            if (length > 50) {
                if (a == 0 || a == 4 || a == 1) {
                    SpannableStringBuilder valueOf = SpannableStringBuilder.valueOf(jVar.c().subSequence(0, 50 - i2));
                    com.baidu.tieba.data.j jVar2 = new com.baidu.tieba.data.j();
                    jVar2.a(valueOf);
                    jVar2.a(a);
                    arrayList.add(jVar2);
                    z = true;
                } else {
                    z = true;
                }
            } else {
                arrayList.add(jVar);
                i++;
                i2 = length;
            }
        }
        if (z) {
            com.baidu.tieba.data.j jVar3 = new com.baidu.tieba.data.j();
            jVar3.a(SpannableStringBuilder.valueOf("..."));
            jVar3.a(0);
            arrayList.add(jVar3);
            return arrayList;
        }
        return list;
    }

    private void a(TextView textView, com.baidu.tieba.data.j jVar) {
        if (textView != null && jVar != null) {
            if (jVar.a() == 2) {
                textView.setText(jVar.a(this.a, this.b, this.c));
            } else {
                textView.setText(jVar.c());
            }
        }
    }

    private TextView a(com.baidu.tieba.data.j jVar) {
        CustomTextView customTextView = new CustomTextView(this.a);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        int a = com.baidu.adp.lib.h.g.a(this.a, 15.0f);
        layoutParams.rightMargin = 0;
        layoutParams.leftMargin = 0;
        layoutParams.topMargin = a;
        layoutParams.bottomMargin = 0;
        customTextView.setLineSpacing(0.0f, 1.2f);
        customTextView.setTextSize(com.baidu.tieba.data.h.q());
        if (TiebaApplication.h().an() == 1) {
            customTextView.setTextColor(bb.a(1));
        } else {
            customTextView.setTextColor(this.g);
        }
        a(customTextView, jVar);
        customTextView.setMovementMethod(LinkMovementMethod.getInstance());
        customTextView.setFocusable(false);
        customTextView.setLayoutParams(layoutParams);
        return customTextView;
    }

    private ImageView a(List<com.baidu.tieba.data.j> list, com.baidu.tieba.data.j jVar, int i) {
        ImageView imageView = new ImageView(this.a);
        int a = com.baidu.adp.lib.h.g.a(this.a, 105.0f);
        int a2 = com.baidu.adp.lib.h.g.a(this.a, 105.0f);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, a);
        layoutParams.topMargin = com.baidu.adp.lib.h.g.a(this.a, 15.0f);
        layoutParams.bottomMargin = 0;
        com.baidu.adp.widget.ImageView.e d = this.d.d(jVar.d());
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        imageView.setMaxWidth(a2);
        if (d != null) {
            imageView.setTag(null);
            d.a(imageView);
        } else {
            imageView.setTag(jVar.d());
            imageView.setImageBitmap(m.a((int) R.drawable.image_default));
        }
        imageView.setClickable(true);
        imageView.setFocusable(false);
        imageView.setOnClickListener(this.e);
        imageView.setLayoutParams(layoutParams);
        return imageView;
    }

    public void a(int i) {
        this.g = i;
    }
}
