package com.baidu.tieba.imMessageCenter.im.friend;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HorizontalCustomScrollView;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class InviteFriendCandidateList extends HorizontalCustomScrollView {
    private int adt;
    private View.OnClickListener bjv;
    private int cdg;
    private int cqs;
    private int deY;
    private HeadImageView deZ;
    private a dfa;
    private Context mContext;
    private LinearLayout mLayout;

    /* loaded from: classes2.dex */
    public interface a {
        void a(View view, Object obj);
    }

    public InviteFriendCandidateList(Context context) {
        super(context);
        this.adt = -1;
        this.cdg = -1;
        this.deY = -1;
        this.cqs = 4;
        this.bjv = new i(this);
        this.mContext = context;
        wv();
    }

    public InviteFriendCandidateList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.adt = -1;
        this.cdg = -1;
        this.deY = -1;
        this.cqs = 4;
        this.bjv = new i(this);
        this.mContext = context;
        wv();
    }

    public void setMaxCount(int i) {
        this.cqs = i;
    }

    public void a(a aVar) {
        this.dfa = aVar;
    }

    private void wv() {
        this.adt = this.mContext.getResources().getDimensionPixelSize(w.f.ds80);
        this.cdg = this.mContext.getResources().getDimensionPixelSize(w.f.ds80);
        this.deY = this.mContext.getResources().getDimensionPixelSize(w.f.ds12);
        this.mLayout = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.mLayout.setLayoutParams(layoutParams);
        this.mLayout.setHorizontalScrollBarEnabled(true);
        this.mLayout.setOrientation(0);
        asu();
        addView(this.mLayout);
        setSmoothScrollingEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void asu() {
        if (this.deZ == null) {
            this.deZ = asy();
            this.deZ.setDrawBorder(false);
        }
        this.deZ.setImageBitmap(aq.cL(w.g.icon_add_pop));
        this.mLayout.addView(this.deZ);
    }

    private void asv() {
        if (asw()) {
            this.mLayout.removeView(this.deZ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean asw() {
        int childCount = this.mLayout.getChildCount();
        return childCount > 0 && this.mLayout.getChildAt(childCount + (-1)) == this.deZ;
    }

    public void d(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (getItemLength() < this.cqs) {
            HeadImageView asy = asy();
            asy.setIsRound(false);
            asy.c(aVar.Ah(), 12, false);
            if (asw()) {
                asy.setTag(aVar);
                asy.setOnClickListener(this.bjv);
                this.mLayout.addView(asy, getItemLength());
                scrollTo(getItemLength() * (this.adt + this.deY), 0);
            }
            if (getItemLength() >= this.cqs) {
                asv();
            }
        }
    }

    public boolean e(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        Object tag;
        int childCount = this.mLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mLayout.getChildAt(i);
            if (childAt != this.deZ && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a) && ((com.baidu.tbadk.coreExtra.relationship.a) tag).equals(aVar)) {
                aVar.setChecked(true);
                childAt.setTag(aVar);
                return true;
            }
        }
        return false;
    }

    public String asx() {
        Object tag;
        int childCount = this.mLayout.getChildCount();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mLayout.getChildAt(i);
            if (childAt != this.deZ && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
                if (i > 0) {
                    sb.append(",");
                }
                sb.append(((com.baidu.tbadk.coreExtra.relationship.a) tag).getUserId());
            }
        }
        return sb.toString();
    }

    public void f(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        View findViewWithTag = this.mLayout.findViewWithTag(aVar);
        if (findViewWithTag != null) {
            this.mLayout.removeView(findViewWithTag);
            if (!asw()) {
                asu();
            }
        }
    }

    private HeadImageView asy() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.adt, this.cdg);
        layoutParams.setMargins(this.deY, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    public int getItemLength() {
        return asw() ? this.mLayout.getChildCount() - 1 : this.mLayout.getChildCount();
    }
}
