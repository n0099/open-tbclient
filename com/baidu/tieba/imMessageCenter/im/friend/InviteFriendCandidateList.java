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
    private int adl;
    private View.OnClickListener bkC;
    private int cju;
    private int cwN;
    private int dks;
    private HeadImageView dkt;
    private a dku;
    private Context mContext;
    private LinearLayout mLayout;

    /* loaded from: classes2.dex */
    public interface a {
        void b(View view, Object obj);
    }

    public InviteFriendCandidateList(Context context) {
        super(context);
        this.adl = -1;
        this.cju = -1;
        this.dks = -1;
        this.cwN = 4;
        this.bkC = new i(this);
        this.mContext = context;
        wr();
    }

    public InviteFriendCandidateList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.adl = -1;
        this.cju = -1;
        this.dks = -1;
        this.cwN = 4;
        this.bkC = new i(this);
        this.mContext = context;
        wr();
    }

    public void setMaxCount(int i) {
        this.cwN = i;
    }

    public void a(a aVar) {
        this.dku = aVar;
    }

    private void wr() {
        this.adl = this.mContext.getResources().getDimensionPixelSize(w.f.ds80);
        this.cju = this.mContext.getResources().getDimensionPixelSize(w.f.ds80);
        this.dks = this.mContext.getResources().getDimensionPixelSize(w.f.ds12);
        this.mLayout = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.mLayout.setLayoutParams(layoutParams);
        this.mLayout.setHorizontalScrollBarEnabled(true);
        this.mLayout.setOrientation(0);
        atq();
        addView(this.mLayout);
        setSmoothScrollingEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void atq() {
        if (this.dkt == null) {
            this.dkt = atu();
            this.dkt.setDrawBorder(false);
        }
        this.dkt.setImageBitmap(aq.cM(w.g.icon_add_pop));
        this.mLayout.addView(this.dkt);
    }

    private void atr() {
        if (ats()) {
            this.mLayout.removeView(this.dkt);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ats() {
        int childCount = this.mLayout.getChildCount();
        return childCount > 0 && this.mLayout.getChildAt(childCount + (-1)) == this.dkt;
    }

    public void d(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (getItemLength() < this.cwN) {
            HeadImageView atu = atu();
            atu.setIsRound(false);
            atu.c(aVar.Aa(), 12, false);
            if (ats()) {
                atu.setTag(aVar);
                atu.setOnClickListener(this.bkC);
                this.mLayout.addView(atu, getItemLength());
                scrollTo(getItemLength() * (this.adl + this.dks), 0);
            }
            if (getItemLength() >= this.cwN) {
                atr();
            }
        }
    }

    public boolean e(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        Object tag;
        int childCount = this.mLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mLayout.getChildAt(i);
            if (childAt != this.dkt && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a) && ((com.baidu.tbadk.coreExtra.relationship.a) tag).equals(aVar)) {
                aVar.setChecked(true);
                childAt.setTag(aVar);
                return true;
            }
        }
        return false;
    }

    public String att() {
        Object tag;
        int childCount = this.mLayout.getChildCount();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mLayout.getChildAt(i);
            if (childAt != this.dkt && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
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
            if (!ats()) {
                atq();
            }
        }
    }

    private HeadImageView atu() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.adl, this.cju);
        layoutParams.setMargins(this.dks, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    public int getItemLength() {
        return ats() ? this.mLayout.getChildCount() - 1 : this.mLayout.getChildCount();
    }
}
