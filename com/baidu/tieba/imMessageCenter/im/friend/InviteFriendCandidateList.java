package com.baidu.tieba.imMessageCenter.im.friend;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HorizontalCustomScrollView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class InviteFriendCandidateList extends HorizontalCustomScrollView {

    /* renamed from: f  reason: collision with root package name */
    public Context f17919f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f17920g;

    /* renamed from: h  reason: collision with root package name */
    public int f17921h;
    public int i;
    public int j;
    public int k;
    public HeadImageView l;
    public b m;
    public View.OnClickListener n;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            InviteFriendCandidateList.this.f17920g.removeView(view);
            if (!InviteFriendCandidateList.this.i()) {
                InviteFriendCandidateList.this.k();
            }
            if (InviteFriendCandidateList.this.m != null) {
                InviteFriendCandidateList.this.m.a(view, view.getTag());
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(View view, Object obj);
    }

    public InviteFriendCandidateList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17921h = -1;
        this.i = -1;
        this.j = -1;
        this.k = 4;
        this.n = new a();
        this.f17919f = context;
        j();
    }

    public void e(d.b.i0.s.f.a aVar) {
        if (getItemLength() >= this.k) {
            return;
        }
        HeadImageView f2 = f();
        f2.setIsRound(false);
        f2.W(aVar.h(), 12, false);
        if (i()) {
            f2.setTag(aVar);
            f2.setOnClickListener(this.n);
            this.f17920g.addView(f2, getItemLength());
            scrollTo(getItemLength() * (this.f17921h + this.j), 0);
        }
        if (getItemLength() >= this.k) {
            m();
        }
    }

    public final HeadImageView f() {
        HeadImageView headImageView = new HeadImageView(this.f17919f);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.f17921h, this.i);
        layoutParams.setMargins(this.j, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    public String g() {
        Object tag;
        int childCount = this.f17920g.getChildCount();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.f17920g.getChildAt(i);
            if (childAt != this.l && (tag = childAt.getTag()) != null && (tag instanceof d.b.i0.s.f.a)) {
                if (i > 0) {
                    sb.append(",");
                }
                sb.append(((d.b.i0.s.f.a) tag).e());
            }
        }
        return sb.toString();
    }

    public int getItemLength() {
        if (i()) {
            return this.f17920g.getChildCount() - 1;
        }
        return this.f17920g.getChildCount();
    }

    public boolean h(d.b.i0.s.f.a aVar) {
        Object tag;
        int childCount = this.f17920g.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.f17920g.getChildAt(i);
            if (childAt != this.l && (tag = childAt.getTag()) != null && (tag instanceof d.b.i0.s.f.a) && ((d.b.i0.s.f.a) tag).equals(aVar)) {
                aVar.setChecked(true);
                childAt.setTag(aVar);
                return true;
            }
        }
        return false;
    }

    public final boolean i() {
        int childCount = this.f17920g.getChildCount();
        return childCount > 0 && this.f17920g.getChildAt(childCount - 1) == this.l;
    }

    public final void j() {
        this.f17921h = this.f17919f.getResources().getDimensionPixelSize(R.dimen.ds80);
        this.i = this.f17919f.getResources().getDimensionPixelSize(R.dimen.ds80);
        this.j = this.f17919f.getResources().getDimensionPixelSize(R.dimen.ds12);
        this.f17920g = new LinearLayout(this.f17919f);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.f17920g.setLayoutParams(layoutParams);
        this.f17920g.setHorizontalScrollBarEnabled(true);
        this.f17920g.setOrientation(0);
        k();
        addView(this.f17920g);
        setSmoothScrollingEnabled(true);
    }

    public final void k() {
        if (this.l == null) {
            HeadImageView f2 = f();
            this.l = f2;
            f2.setDrawBorder(false);
        }
        this.l.setImageBitmap(SkinManager.getBitmap(R.drawable.icon_add_pop));
        this.f17920g.addView(this.l);
    }

    public void l(d.b.i0.s.f.a aVar) {
        View findViewWithTag = this.f17920g.findViewWithTag(aVar);
        if (findViewWithTag != null) {
            this.f17920g.removeView(findViewWithTag);
            if (i()) {
                return;
            }
            k();
        }
    }

    public final void m() {
        if (i()) {
            this.f17920g.removeView(this.l);
        }
    }

    public void n(b bVar) {
        this.m = bVar;
    }

    public void setMaxCount(int i) {
        this.k = i;
    }
}
