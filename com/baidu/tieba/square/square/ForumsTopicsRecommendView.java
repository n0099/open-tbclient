package com.baidu.tieba.square.square;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import d.b.c.e.p.l;
import d.b.c.j.d.a;
import d.b.i0.a0.b;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class ForumsTopicsRecommendView extends ViewGroup implements b {

    /* renamed from: e  reason: collision with root package name */
    public Context f20948e;

    /* renamed from: f  reason: collision with root package name */
    public final int f20949f;

    /* renamed from: g  reason: collision with root package name */
    public final int f20950g;

    /* renamed from: h  reason: collision with root package name */
    public final int f20951h;
    public final int i;
    public ArrayList<TbImageView> j;
    public int k;
    public float l;
    public int m;
    public View n;

    public ForumsTopicsRecommendView(Context context) {
        this(context, null);
    }

    @Override // d.b.i0.a0.b
    public void a(a aVar, String str, boolean z) {
        b(str);
    }

    public final void b(String str) {
        HeadImageView headImageView;
        View view = this.n;
        if (view == null || (headImageView = (HeadImageView) view.findViewWithTag(str)) == null) {
            return;
        }
        headImageView.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        headImageView.invalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt != null) {
                int i6 = i5 % 2;
                if (i6 == 0) {
                    paddingLeft = getPaddingLeft();
                }
                childAt.layout(paddingLeft, paddingTop, childAt.getMeasuredWidth() + paddingLeft, childAt.getMeasuredHeight() + paddingTop);
                paddingLeft += childAt.getMeasuredWidth() + this.f20950g;
                if (i6 != 0) {
                    paddingTop += childAt.getMeasuredHeight() + this.f20950g;
                }
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int i3 = i & 1073741823;
        int childCount = getChildCount();
        int i4 = i3 - (this.f20949f * 2);
        int i5 = (int) ((((i4 - this.f20950g) / 2.0f) * this.l) + 0.5f);
        for (int i6 = 0; i6 < childCount; i6++) {
            getChildAt(i6).measure(((i4 - this.f20950g) / 2) + 1073741824, 1073741824 + i5);
        }
        int i7 = this.m / 2;
        setMeasuredDimension(i3, (i5 * i7) + ((i7 - 1) * this.f20950g) + this.i);
    }

    public ForumsTopicsRecommendView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.j = new ArrayList<>(4);
        this.k = 0;
        this.l = 0.62222224f;
        this.m = 0;
        this.n = null;
        this.f20948e = context;
        this.f20951h = l.k(context);
        this.f20949f = context.getResources().getDimensionPixelSize(R.dimen.ds20);
        this.f20950g = context.getResources().getDimensionPixelSize(R.dimen.ds14);
        this.i = context.getResources().getDimensionPixelSize(R.dimen.ds22);
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.forums_topics_recommend, (ViewGroup) this, true);
        this.j.add((TbImageView) viewGroup.findViewById(R.id.forum_topic_pic1));
        this.j.add((TbImageView) viewGroup.findViewById(R.id.forum_topic_pic2));
        this.j.add((TbImageView) viewGroup.findViewById(R.id.forum_topic_pic3));
        this.j.add((TbImageView) viewGroup.findViewById(R.id.forum_topic_pic4));
        int i = this.f20951h;
        int i2 = this.f20949f;
        this.k = ((i - (i2 * 2)) - this.f20950g) / 2;
        setPadding(i2, 0, i2, 0);
    }
}
