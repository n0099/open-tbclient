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
import d.a.c.e.p.l;
import d.a.c.k.d.a;
import d.a.n0.a0.b;
import java.util.ArrayList;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
/* loaded from: classes5.dex */
public class ForumsTopicsRecommendView extends ViewGroup implements b {

    /* renamed from: e  reason: collision with root package name */
    public Context f20843e;

    /* renamed from: f  reason: collision with root package name */
    public final int f20844f;

    /* renamed from: g  reason: collision with root package name */
    public final int f20845g;

    /* renamed from: h  reason: collision with root package name */
    public final int f20846h;

    /* renamed from: i  reason: collision with root package name */
    public final int f20847i;
    public ArrayList<TbImageView> j;
    public int k;
    public float l;
    public int m;
    public View n;

    public ForumsTopicsRecommendView(Context context) {
        this(context, null);
    }

    @Override // d.a.n0.a0.b
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
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt != null) {
                int i7 = i6 % 2;
                if (i7 == 0) {
                    paddingLeft = getPaddingLeft();
                }
                childAt.layout(paddingLeft, paddingTop, childAt.getMeasuredWidth() + paddingLeft, childAt.getMeasuredHeight() + paddingTop);
                paddingLeft += childAt.getMeasuredWidth() + this.f20845g;
                if (i7 != 0) {
                    paddingTop += childAt.getMeasuredHeight() + this.f20845g;
                }
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        int i4 = i2 & LockFreeTaskQueueCore.MAX_CAPACITY_MASK;
        int childCount = getChildCount();
        int i5 = i4 - (this.f20844f * 2);
        int i6 = (int) ((((i5 - this.f20845g) / 2.0f) * this.l) + 0.5f);
        for (int i7 = 0; i7 < childCount; i7++) {
            getChildAt(i7).measure(((i5 - this.f20845g) / 2) + 1073741824, 1073741824 + i6);
        }
        int i8 = this.m / 2;
        setMeasuredDimension(i4, (i6 * i8) + ((i8 - 1) * this.f20845g) + this.f20847i);
    }

    public ForumsTopicsRecommendView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.j = new ArrayList<>(4);
        this.k = 0;
        this.l = 0.62222224f;
        this.m = 0;
        this.n = null;
        this.f20843e = context;
        this.f20846h = l.k(context);
        this.f20844f = context.getResources().getDimensionPixelSize(R.dimen.ds20);
        this.f20845g = context.getResources().getDimensionPixelSize(R.dimen.ds14);
        this.f20847i = context.getResources().getDimensionPixelSize(R.dimen.ds22);
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.forums_topics_recommend, (ViewGroup) this, true);
        this.j.add((TbImageView) viewGroup.findViewById(R.id.forum_topic_pic1));
        this.j.add((TbImageView) viewGroup.findViewById(R.id.forum_topic_pic2));
        this.j.add((TbImageView) viewGroup.findViewById(R.id.forum_topic_pic3));
        this.j.add((TbImageView) viewGroup.findViewById(R.id.forum_topic_pic4));
        int i2 = this.f20846h;
        int i3 = this.f20844f;
        this.k = ((i2 - (i3 * 2)) - this.f20845g) / 2;
        setPadding(i3, 0, i3, 0);
    }
}
