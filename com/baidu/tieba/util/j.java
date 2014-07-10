package com.baidu.tieba.util;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.bk;
import com.baidu.tbadk.editortool.aa;
import com.baidu.tieba.u;
import com.baidu.tieba.view.CustomTextView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class j {
    private final Context a;
    private final int b;
    private final int c;
    private aa d;
    private View.OnClickListener e;
    private boolean f = false;
    private int g = -16777216;

    public j(Context context) {
        this.a = context;
        TextView textView = new TextView(this.a);
        textView.setLineSpacing(0.0f, 1.2f);
        textView.setTextSize(TbConfig.getContentSize());
        this.b = textView.getLineHeight();
        this.c = (int) textView.getTextSize();
    }

    public void a(boolean z) {
        this.f = z;
    }

    public void a(TextView textView, LinearLayout linearLayout, List<com.baidu.tieba.data.g> list, boolean z) {
        TextView textView2;
        int i;
        CharSequence d;
        if (textView != null && linearLayout != null && list != null) {
            if (list != null && list.size() > 0) {
                if (this.f) {
                    list = a(list);
                }
                com.baidu.tieba.data.g gVar = list.get(0);
                if (gVar == null || !(gVar.a() == 0 || gVar.a() == 2 || gVar.a() == 11)) {
                    textView2 = null;
                    i = 0;
                } else {
                    textView.setTextSize(TbConfig.getContentSize());
                    textView.setVisibility(0);
                    a(textView, gVar);
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
                            com.baidu.tieba.data.g gVar2 = list.get(i3);
                            if (gVar2.a() == 3) {
                                if (z) {
                                    int i5 = i4 + 1;
                                    linearLayout.addView(a(list, gVar2, i5));
                                    i2 = i5;
                                    textView2 = null;
                                }
                                i2 = i4;
                                textView2 = textView3;
                            } else if (textView3 != null) {
                                if (gVar2.a() == 2) {
                                    d = gVar2.a(this.a, this.b, this.c);
                                } else {
                                    d = gVar2.d();
                                }
                                if (d != null) {
                                    textView3.append(d);
                                    i2 = i4;
                                    textView2 = textView3;
                                }
                                i2 = i4;
                                textView2 = textView3;
                            } else {
                                TextView a = a(gVar2);
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

    private List<com.baidu.tieba.data.g> a(List<com.baidu.tieba.data.g> list) {
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
            com.baidu.tieba.data.g gVar = list.get(i);
            int a = gVar.a();
            if (a == 0 || a == 4 || a == 1) {
                length = gVar.d() != null ? gVar.d().length() + i2 : i2;
            } else {
                length = i2 + 1;
            }
            if (length > 50) {
                if (a == 0 || a == 4 || a == 1) {
                    SpannableStringBuilder valueOf = SpannableStringBuilder.valueOf(gVar.d().subSequence(0, 50 - i2));
                    com.baidu.tieba.data.g gVar2 = new com.baidu.tieba.data.g();
                    gVar2.a(valueOf);
                    gVar2.a(a);
                    arrayList.add(gVar2);
                    z = true;
                } else {
                    z = true;
                }
            } else {
                arrayList.add(gVar);
                i++;
                i2 = length;
            }
        }
        if (z) {
            com.baidu.tieba.data.g gVar3 = new com.baidu.tieba.data.g();
            gVar3.a(SpannableStringBuilder.valueOf("..."));
            gVar3.a(0);
            arrayList.add(gVar3);
            return arrayList;
        }
        return list;
    }

    private void a(TextView textView, com.baidu.tieba.data.g gVar) {
        if (textView != null && gVar != null) {
            if (gVar.a() == 2) {
                textView.setText(gVar.a(this.a, this.b, this.c));
            } else if (gVar.a() == 11) {
                textView.setText("[" + gVar.c() + "]");
            } else {
                textView.setText(gVar.d());
            }
        }
    }

    private TextView a(com.baidu.tieba.data.g gVar) {
        CustomTextView customTextView = new CustomTextView(this.a);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        int a = com.baidu.adp.lib.util.j.a(this.a, 15.0f);
        layoutParams.rightMargin = 0;
        layoutParams.leftMargin = 0;
        layoutParams.topMargin = a;
        layoutParams.bottomMargin = 0;
        customTextView.setLineSpacing(0.0f, 1.2f);
        customTextView.setTextSize(TbConfig.getContentSize());
        if (TbadkApplication.m252getInst().getSkinType() == 1) {
            customTextView.setTextColor(bk.a(1));
        } else {
            customTextView.setTextColor(this.g);
        }
        a(customTextView, gVar);
        customTextView.setMovementMethod(LinkMovementMethod.getInstance());
        customTextView.setFocusable(false);
        customTextView.setLayoutParams(layoutParams);
        return customTextView;
    }

    private ImageView a(List<com.baidu.tieba.data.g> list, com.baidu.tieba.data.g gVar, int i) {
        ImageView imageView = new ImageView(this.a);
        int a = com.baidu.adp.lib.util.j.a(this.a, 105.0f);
        int a2 = com.baidu.adp.lib.util.j.a(this.a, 105.0f);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, a);
        layoutParams.topMargin = com.baidu.adp.lib.util.j.a(this.a, 15.0f);
        layoutParams.bottomMargin = 0;
        com.baidu.adp.widget.a.a d = this.d.d(gVar.e());
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        imageView.setMaxWidth(a2);
        if (d != null) {
            imageView.setTag(null);
            d.a(imageView);
        } else {
            imageView.setTag(gVar.e());
            imageView.setImageBitmap(com.baidu.tbadk.core.util.h.a(u.image_default));
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
