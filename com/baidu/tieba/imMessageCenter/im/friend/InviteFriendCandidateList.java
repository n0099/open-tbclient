package com.baidu.tieba.imMessageCenter.im.friend;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HorizontalCustomScrollView;
import com.baidu.tieba.w;
import com.xiaomi.mipush.sdk.Constants;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class InviteFriendCandidateList extends HorizontalCustomScrollView {
    private int adU;
    private int bVr;
    private View.OnClickListener boh;
    private int cEA;
    private int dso;
    private HeadImageView dsp;
    private a dsq;
    private Context mContext;
    private LinearLayout mLayout;

    /* loaded from: classes2.dex */
    public interface a {
        void b(View view, Object obj);
    }

    public InviteFriendCandidateList(Context context) {
        super(context);
        this.adU = -1;
        this.bVr = -1;
        this.dso = -1;
        this.cEA = 4;
        this.boh = new i(this);
        this.mContext = context;
        wJ();
    }

    public InviteFriendCandidateList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.adU = -1;
        this.bVr = -1;
        this.dso = -1;
        this.cEA = 4;
        this.boh = new i(this);
        this.mContext = context;
        wJ();
    }

    public void setMaxCount(int i) {
        this.cEA = i;
    }

    public void a(a aVar) {
        this.dsq = aVar;
    }

    private void wJ() {
        this.adU = this.mContext.getResources().getDimensionPixelSize(w.f.ds80);
        this.bVr = this.mContext.getResources().getDimensionPixelSize(w.f.ds80);
        this.dso = this.mContext.getResources().getDimensionPixelSize(w.f.ds12);
        this.mLayout = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.mLayout.setLayoutParams(layoutParams);
        this.mLayout.setHorizontalScrollBarEnabled(true);
        this.mLayout.setOrientation(0);
        awY();
        addView(this.mLayout);
        setSmoothScrollingEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awY() {
        if (this.dsp == null) {
            this.dsp = axc();
            this.dsp.setDrawBorder(false);
        }
        this.dsp.setImageBitmap(as.cO(w.g.icon_add_pop));
        this.mLayout.addView(this.dsp);
    }

    private void awZ() {
        if (axa()) {
            this.mLayout.removeView(this.dsp);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean axa() {
        int childCount = this.mLayout.getChildCount();
        return childCount > 0 && this.mLayout.getChildAt(childCount + (-1)) == this.dsp;
    }

    public void d(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (getItemLength() < this.cEA) {
            HeadImageView axc = axc();
            axc.setIsRound(false);
            axc.c(aVar.Av(), 12, false);
            if (axa()) {
                axc.setTag(aVar);
                axc.setOnClickListener(this.boh);
                this.mLayout.addView(axc, getItemLength());
                scrollTo(getItemLength() * (this.adU + this.dso), 0);
            }
            if (getItemLength() >= this.cEA) {
                awZ();
            }
        }
    }

    public boolean e(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        Object tag;
        int childCount = this.mLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mLayout.getChildAt(i);
            if (childAt != this.dsp && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a) && ((com.baidu.tbadk.coreExtra.relationship.a) tag).equals(aVar)) {
                aVar.setChecked(true);
                childAt.setTag(aVar);
                return true;
            }
        }
        return false;
    }

    public String axb() {
        Object tag;
        int childCount = this.mLayout.getChildCount();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mLayout.getChildAt(i);
            if (childAt != this.dsp && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
                if (i > 0) {
                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
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
            if (!axa()) {
                awY();
            }
        }
    }

    private HeadImageView axc() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.adU, this.bVr);
        layoutParams.setMargins(this.dso, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    public int getItemLength() {
        return axa() ? this.mLayout.getChildCount() - 1 : this.mLayout.getChildCount();
    }
}
