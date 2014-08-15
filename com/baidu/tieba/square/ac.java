package com.baidu.tieba.square;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class ac extends ViewGroup implements com.baidu.tbadk.imageManager.d, com.baidu.tieba.view.s {
    private Context a;
    private LayoutInflater b;
    private final int c;
    private final int d;
    private final int e;
    private final int f;
    private ArrayList<TbImageView> g;
    private int h;
    private int i;
    private float j;
    private int k;
    private ArrayList<ap> l;
    private View m;

    public ac(Context context) {
        this(context, null);
    }

    public ac(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = null;
        this.b = null;
        this.g = new ArrayList<>(4);
        this.h = 0;
        this.i = 0;
        this.j = 0.62222224f;
        this.k = 0;
        this.l = null;
        this.m = null;
        this.a = context;
        this.e = com.baidu.adp.lib.util.j.b(context);
        this.c = context.getResources().getDimensionPixelSize(com.baidu.tieba.s.square_page_padding);
        this.d = context.getResources().getDimensionPixelSize(com.baidu.tieba.s.square_forum_topic_margin);
        this.f = context.getResources().getDimensionPixelSize(com.baidu.tieba.s.square_forum_topic_paddingBottom);
        this.b = (LayoutInflater) context.getSystemService("layout_inflater");
        ViewGroup viewGroup = (ViewGroup) this.b.inflate(com.baidu.tieba.v.forums_topics_recommend, (ViewGroup) this, true);
        this.g.add((TbImageView) viewGroup.findViewById(com.baidu.tieba.u.forum_topic_pic1));
        this.g.add((TbImageView) viewGroup.findViewById(com.baidu.tieba.u.forum_topic_pic2));
        this.g.add((TbImageView) viewGroup.findViewById(com.baidu.tieba.u.forum_topic_pic3));
        this.g.add((TbImageView) viewGroup.findViewById(com.baidu.tieba.u.forum_topic_pic4));
        this.h = ((this.e - (this.c * 2)) - this.d) / 2;
        this.i = (int) (this.h * this.j);
        setPadding(this.c, 0, this.c, 0);
    }

    public boolean a(ArrayList<ap> arrayList) {
        this.l = b(arrayList);
        Iterator<TbImageView> it = this.g.iterator();
        while (it.hasNext()) {
            it.next().setVisibility(8);
        }
        if (this.l != null) {
            setVisibility(0);
            c(this.l);
            return true;
        }
        setVisibility(8);
        return false;
    }

    private ArrayList<ap> b(ArrayList<ap> arrayList) {
        if (arrayList != null) {
            int size = (arrayList.size() / 2) * 2;
            int i = size <= 4 ? size : 4;
            if (i > 0) {
                return new ArrayList<>(arrayList.subList(0, i));
            }
            return null;
        }
        return null;
    }

    private void c(ArrayList<ap> arrayList) {
        int size = arrayList.size();
        this.k = size;
        requestLayout();
        for (int i = 0; i < size; i++) {
            TbImageView tbImageView = this.g.get(i);
            ap apVar = arrayList.get(i);
            tbImageView.setVisibility(0);
            tbImageView.setTag(apVar.a());
            tbImageView.setOnClickListener(new ad(this, apVar, i));
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3 = i & 1073741823;
        int childCount = getChildCount();
        int i4 = i3 - (this.c * 2);
        int i5 = (int) (0.5f + (((i4 - this.d) / 2) * this.j));
        for (int i6 = 0; i6 < childCount; i6++) {
            getChildAt(i6).measure(((i4 - this.d) / 2) + 1073741824, i5 + 1073741824);
        }
        int i7 = this.k / 2;
        setMeasuredDimension(i3, ((i7 - 1) * this.d) + (i7 * i5) + this.f);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int childCount = getChildCount();
        int i7 = 0;
        int i8 = paddingLeft;
        while (i7 < childCount) {
            View childAt = getChildAt(i7);
            if (childAt == null) {
                int i9 = paddingTop;
                i6 = i8;
                i5 = i9;
            } else {
                if (i7 % 2 == 0) {
                    i8 = getPaddingLeft();
                }
                childAt.layout(i8, paddingTop, childAt.getMeasuredWidth() + i8, childAt.getMeasuredHeight() + paddingTop);
                int measuredWidth = childAt.getMeasuredWidth() + this.d + i8;
                if (i7 % 2 != 0) {
                    i5 = childAt.getMeasuredHeight() + this.d + paddingTop;
                    i6 = measuredWidth;
                } else {
                    i5 = paddingTop;
                    i6 = measuredWidth;
                }
            }
            i7++;
            int i10 = i5;
            i8 = i6;
            paddingTop = i10;
        }
    }

    @Override // com.baidu.tieba.view.s
    public void b() {
    }

    @Override // com.baidu.tieba.view.s
    public void a(View view, int i, int i2) {
        int i3 = 0;
        this.m = view;
        try {
            if (this.l == null || this.l.size() <= 0) {
                return;
            }
            while (true) {
                int i4 = i3;
                if (i4 < this.l.size()) {
                    String a = this.l.get(i4).a();
                    if (a != null && a.length() > 0 && view != null) {
                        HeadImageView headImageView = (HeadImageView) this.m.findViewWithTag(a);
                        headImageView.setDefaultScaleType(ImageView.ScaleType.CENTER);
                        headImageView.a(a, 10, this.h, this.i, false);
                    }
                    i3 = i4 + 1;
                } else {
                    return;
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        a(str);
    }

    private void a(String str) {
        HeadImageView headImageView;
        if (this.m != null && (headImageView = (HeadImageView) this.m.findViewWithTag(str)) != null) {
            headImageView.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            headImageView.invalidate();
        }
    }
}
