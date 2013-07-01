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
public class g {

    /* renamed from: a  reason: collision with root package name */
    private Context f1459a;
    private int b;
    private int c;
    private a d;
    private View.OnClickListener e;
    private boolean f = false;
    private int g = -16777216;

    public g(Context context) {
        this.f1459a = context;
        TextView textView = new TextView(this.f1459a);
        textView.setLineSpacing(0.0f, 1.2f);
        textView.setTextSize(com.baidu.tieba.data.g.n());
        this.b = textView.getLineHeight();
        this.c = (int) textView.getTextSize();
    }

    public void a(boolean z) {
        this.f = z;
    }

    public void a(TextView textView, LinearLayout linearLayout, List list, boolean z) {
        TextView textView2;
        int i;
        if (textView != null && linearLayout != null && list != null) {
            if (list != null && list.size() > 0) {
                if (this.f) {
                    list = a(list);
                }
                com.baidu.tieba.data.i iVar = (com.baidu.tieba.data.i) list.get(0);
                if (iVar == null || !(iVar.a() == 0 || iVar.a() == 2)) {
                    textView2 = null;
                    i = 0;
                } else {
                    textView.setTextSize(com.baidu.tieba.data.g.n());
                    textView.setVisibility(0);
                    a(textView, iVar);
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
                            com.baidu.tieba.data.i iVar2 = (com.baidu.tieba.data.i) list.get(i3);
                            if (iVar2.a() == 3) {
                                if (z) {
                                    int i5 = i4 + 1;
                                    linearLayout.addView(a(list, iVar2, i5));
                                    i2 = i5;
                                    textView2 = null;
                                } else {
                                    i2 = i4;
                                    textView2 = textView3;
                                }
                            } else if (textView3 != null) {
                                if (iVar2.a() == 2) {
                                    textView3.append(iVar2.a(this.f1459a, this.b, this.c));
                                    i2 = i4;
                                    textView2 = textView3;
                                } else {
                                    textView3.append(iVar2.e());
                                    i2 = i4;
                                    textView2 = textView3;
                                }
                            } else {
                                TextView a2 = a(iVar2);
                                linearLayout.addView(a2);
                                i2 = i4;
                                textView2 = a2;
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

    private List a(List list) {
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
            com.baidu.tieba.data.i iVar = (com.baidu.tieba.data.i) list.get(i);
            int a2 = iVar.a();
            if (a2 == 0 || a2 == 4 || a2 == 1) {
                length = iVar.e() != null ? iVar.e().length() + i2 : i2;
            } else {
                length = i2 + 1;
            }
            if (length > 50) {
                if (a2 == 0 || a2 == 4 || a2 == 1) {
                    SpannableStringBuilder valueOf = SpannableStringBuilder.valueOf(iVar.e().subSequence(0, 50 - i2));
                    com.baidu.tieba.data.i iVar2 = new com.baidu.tieba.data.i();
                    iVar2.a(valueOf);
                    iVar2.a(a2);
                    arrayList.add(iVar2);
                    z = true;
                } else {
                    z = true;
                }
            } else {
                arrayList.add(iVar);
                i++;
                i2 = length;
            }
        }
        if (z) {
            com.baidu.tieba.data.i iVar3 = new com.baidu.tieba.data.i();
            iVar3.a(SpannableStringBuilder.valueOf("..."));
            iVar3.a(0);
            arrayList.add(iVar3);
            return arrayList;
        }
        return list;
    }

    private void a(TextView textView, com.baidu.tieba.data.i iVar) {
        if (textView != null && iVar != null) {
            if (iVar.a() == 2) {
                textView.setText(iVar.a(this.f1459a, this.b, this.c));
            } else {
                textView.setText(iVar.e());
            }
        }
    }

    private TextView a(com.baidu.tieba.data.i iVar) {
        CustomTextView customTextView = new CustomTextView(this.f1459a);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        int a2 = ab.a(this.f1459a, 15.0f);
        layoutParams.rightMargin = 0;
        layoutParams.leftMargin = 0;
        layoutParams.topMargin = a2;
        layoutParams.bottomMargin = 0;
        customTextView.setLineSpacing(0.0f, 1.2f);
        customTextView.setTextSize(com.baidu.tieba.data.g.n());
        if (TiebaApplication.f().at() == 1) {
            customTextView.setTextColor(x.a(1));
        } else {
            customTextView.setTextColor(this.g);
        }
        a(customTextView, iVar);
        customTextView.setMovementMethod(LinkMovementMethod.getInstance());
        customTextView.setFocusable(false);
        customTextView.setLayoutParams(layoutParams);
        return customTextView;
    }

    private ImageView a(List list, com.baidu.tieba.data.i iVar, int i) {
        ImageView imageView = new ImageView(this.f1459a);
        int a2 = ab.a(this.f1459a, 105.0f);
        int a3 = ab.a(this.f1459a, 105.0f);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, a2);
        layoutParams.topMargin = ab.a(this.f1459a, 15.0f);
        layoutParams.bottomMargin = 0;
        com.baidu.adp.widget.a.b c = this.d.c(iVar.f());
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        imageView.setMaxWidth(a3);
        if (c != null) {
            imageView.setTag(null);
            c.b(imageView);
        } else {
            imageView.setTag(iVar.f());
            imageView.setImageBitmap(d.a((int) R.drawable.image_default));
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
