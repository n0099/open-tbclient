package com.baidu.tieba.square;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tieba.view.HeadImageView;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class af extends ViewGroup implements com.baidu.tbadk.imageManager.c, com.baidu.tieba.view.ai {
    private Context a;
    private LayoutInflater b;
    private final int c;
    private final int d;
    private final int e;
    private final int f;
    private ArrayList<HeadImageView> g;
    private int h;
    private int i;
    private float j;
    private int k;
    private ArrayList<au> l;
    private com.baidu.tieba.util.i m;
    private View n;

    public af(Context context) {
        this(context, null);
    }

    public af(Context context, AttributeSet attributeSet) {
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
        this.n = null;
        this.a = context;
        this.e = com.baidu.adp.lib.h.g.b(context);
        this.c = context.getResources().getDimensionPixelSize(R.dimen.square_page_padding);
        this.d = context.getResources().getDimensionPixelSize(R.dimen.square_forum_topic_margin);
        this.f = context.getResources().getDimensionPixelSize(R.dimen.square_forum_topic_paddingBottom);
        this.b = (LayoutInflater) context.getSystemService("layout_inflater");
        ViewGroup viewGroup = (ViewGroup) this.b.inflate(R.layout.forums_topics_recommend, (ViewGroup) this, true);
        this.g.add((HeadImageView) viewGroup.findViewById(R.id.forum_topic_pic1));
        this.g.add((HeadImageView) viewGroup.findViewById(R.id.forum_topic_pic2));
        this.g.add((HeadImageView) viewGroup.findViewById(R.id.forum_topic_pic3));
        this.g.add((HeadImageView) viewGroup.findViewById(R.id.forum_topic_pic4));
        this.h = ((this.e - (this.c * 2)) - this.d) / 2;
        this.i = (int) (this.h * this.j);
        this.m = new com.baidu.tieba.util.i(context);
        this.m.a(this.h, this.i);
        setPadding(this.c, 0, this.c, 0);
    }

    public boolean a(ArrayList<au> arrayList) {
        this.l = b(arrayList);
        Iterator<HeadImageView> it = this.g.iterator();
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

    private ArrayList<au> b(ArrayList<au> arrayList) {
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

    private void c(ArrayList<au> arrayList) {
        int size = arrayList.size();
        this.k = size;
        requestLayout();
        for (int i = 0; i < size; i++) {
            HeadImageView headImageView = this.g.get(i);
            au auVar = arrayList.get(i);
            headImageView.setVisibility(0);
            headImageView.setTag(auVar.a());
            headImageView.setOnClickListener(new ag(this, auVar, i));
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

    @Override // com.baidu.tieba.view.ai
    public void d() {
        if (this.m != null) {
            this.m.b();
        }
    }

    @Override // com.baidu.tieba.view.ai
    public void a(View view, int i, int i2) {
        this.n = view;
        try {
            if (this.m != null) {
                this.m.a();
                if (this.l != null && this.l.size() > 0) {
                    int i3 = 0;
                    while (true) {
                        int i4 = i3;
                        if (i4 < this.l.size()) {
                            String a = this.l.get(i4).a();
                            if (a != null && a.length() > 0) {
                                if (view != null) {
                                    ((HeadImageView) this.n.findViewWithTag(a)).setDefaultScaleType(ImageView.ScaleType.CENTER);
                                }
                                com.baidu.adp.widget.ImageView.e a2 = this.m.a(a, this);
                                if (a2 != null) {
                                    a(a2.h());
                                }
                            }
                            i3 = i4 + 1;
                        } else {
                            return;
                        }
                    }
                }
            }
        } catch (Exception e) {
            com.baidu.tieba.util.be.b("ForumsTopicsRecommendView", "mGetImageRunnble.run", "error = " + e.getMessage());
        }
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.e eVar, String str, boolean z) {
        a(str);
    }

    private void a(String str) {
        HeadImageView headImageView;
        if (this.n != null && (headImageView = (HeadImageView) this.n.findViewWithTag(str)) != null) {
            headImageView.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            headImageView.invalidate();
        }
    }
}
