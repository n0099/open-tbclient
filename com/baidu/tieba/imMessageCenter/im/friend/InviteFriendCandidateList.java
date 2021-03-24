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
    public Context f18233f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f18234g;

    /* renamed from: h  reason: collision with root package name */
    public int f18235h;
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
            InviteFriendCandidateList.this.f18234g.removeView(view);
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
        this.f18235h = -1;
        this.i = -1;
        this.j = -1;
        this.k = 4;
        this.n = new a();
        this.f18233f = context;
        j();
    }

    public void e(d.b.h0.s.f.a aVar) {
        if (getItemLength() >= this.k) {
            return;
        }
        HeadImageView f2 = f();
        f2.setIsRound(false);
        f2.W(aVar.h(), 12, false);
        if (i()) {
            f2.setTag(aVar);
            f2.setOnClickListener(this.n);
            this.f18234g.addView(f2, getItemLength());
            scrollTo(getItemLength() * (this.f18235h + this.j), 0);
        }
        if (getItemLength() >= this.k) {
            m();
        }
    }

    public final HeadImageView f() {
        HeadImageView headImageView = new HeadImageView(this.f18233f);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.f18235h, this.i);
        layoutParams.setMargins(this.j, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    public String g() {
        Object tag;
        int childCount = this.f18234g.getChildCount();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.f18234g.getChildAt(i);
            if (childAt != this.l && (tag = childAt.getTag()) != null && (tag instanceof d.b.h0.s.f.a)) {
                if (i > 0) {
                    sb.append(",");
                }
                sb.append(((d.b.h0.s.f.a) tag).e());
            }
        }
        return sb.toString();
    }

    public int getItemLength() {
        if (i()) {
            return this.f18234g.getChildCount() - 1;
        }
        return this.f18234g.getChildCount();
    }

    public boolean h(d.b.h0.s.f.a aVar) {
        Object tag;
        int childCount = this.f18234g.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.f18234g.getChildAt(i);
            if (childAt != this.l && (tag = childAt.getTag()) != null && (tag instanceof d.b.h0.s.f.a) && ((d.b.h0.s.f.a) tag).equals(aVar)) {
                aVar.setChecked(true);
                childAt.setTag(aVar);
                return true;
            }
        }
        return false;
    }

    public final boolean i() {
        int childCount = this.f18234g.getChildCount();
        return childCount > 0 && this.f18234g.getChildAt(childCount - 1) == this.l;
    }

    public final void j() {
        this.f18235h = this.f18233f.getResources().getDimensionPixelSize(R.dimen.ds80);
        this.i = this.f18233f.getResources().getDimensionPixelSize(R.dimen.ds80);
        this.j = this.f18233f.getResources().getDimensionPixelSize(R.dimen.ds12);
        this.f18234g = new LinearLayout(this.f18233f);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.f18234g.setLayoutParams(layoutParams);
        this.f18234g.setHorizontalScrollBarEnabled(true);
        this.f18234g.setOrientation(0);
        k();
        addView(this.f18234g);
        setSmoothScrollingEnabled(true);
    }

    public final void k() {
        if (this.l == null) {
            HeadImageView f2 = f();
            this.l = f2;
            f2.setDrawBorder(false);
        }
        this.l.setImageBitmap(SkinManager.getBitmap(R.drawable.icon_add_pop));
        this.f18234g.addView(this.l);
    }

    public void l(d.b.h0.s.f.a aVar) {
        View findViewWithTag = this.f18234g.findViewWithTag(aVar);
        if (findViewWithTag != null) {
            this.f18234g.removeView(findViewWithTag);
            if (i()) {
                return;
            }
            k();
        }
    }

    public final void m() {
        if (i()) {
            this.f18234g.removeView(this.l);
        }
    }

    public void n(b bVar) {
        this.m = bVar;
    }

    public void setMaxCount(int i) {
        this.k = i;
    }
}
