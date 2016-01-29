package com.baidu.tieba.imMessageCenter.im.friend;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HorizontalCustomScrollView;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class InviteFriendCandidateList extends HorizontalCustomScrollView {
    private View.OnClickListener aTD;
    private int aaJ;
    private LinearLayout cla;
    private int clb;
    private int clc;
    private int cld;
    private HeadImageView cle;
    private a clf;
    private Context mContext;

    /* loaded from: classes.dex */
    public interface a {
        void a(View view, Object obj);
    }

    public InviteFriendCandidateList(Context context) {
        super(context);
        this.aaJ = -1;
        this.clb = -1;
        this.clc = -1;
        this.cld = 4;
        this.aTD = new i(this);
        this.mContext = context;
        initialize();
    }

    public InviteFriendCandidateList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aaJ = -1;
        this.clb = -1;
        this.clc = -1;
        this.cld = 4;
        this.aTD = new i(this);
        this.mContext = context;
        initialize();
    }

    public void setMaxCount(int i) {
        this.cld = i;
    }

    public void a(a aVar) {
        this.clf = aVar;
    }

    private void initialize() {
        this.aaJ = this.mContext.getResources().getDimensionPixelSize(t.e.invite_friend_candidate_item_width);
        this.clb = this.mContext.getResources().getDimensionPixelSize(t.e.invite_friend_candidate_item_height);
        this.clc = this.mContext.getResources().getDimensionPixelSize(t.e.invite_friend_candidate_item_margin);
        this.cla = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.cla.setLayoutParams(layoutParams);
        this.cla.setHorizontalScrollBarEnabled(true);
        this.cla.setOrientation(0);
        agY();
        addView(this.cla);
        setSmoothScrollingEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void agY() {
        if (this.cle == null) {
            this.cle = ahc();
            this.cle.setDrawBorder(false);
        }
        this.cle.setImageBitmap(ar.cO(t.f.icon_add_pop));
        this.cla.addView(this.cle);
    }

    private void agZ() {
        if (aha()) {
            this.cla.removeView(this.cle);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aha() {
        int childCount = this.cla.getChildCount();
        return childCount > 0 && this.cla.getChildAt(childCount + (-1)) == this.cle;
    }

    public void d(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (getItemLength() < this.cld) {
            HeadImageView ahc = ahc();
            ahc.setIsRound(false);
            ahc.d(aVar.getUserPortrait(), 12, false);
            if (aha()) {
                ahc.setTag(aVar);
                ahc.setOnClickListener(this.aTD);
                this.cla.addView(ahc, getItemLength());
                scrollTo(getItemLength() * (this.aaJ + this.clc), 0);
            }
            if (getItemLength() >= this.cld) {
                agZ();
            }
        }
    }

    public boolean e(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        Object tag;
        int childCount = this.cla.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.cla.getChildAt(i);
            if (childAt != this.cle && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a) && ((com.baidu.tbadk.coreExtra.relationship.a) tag).equals(aVar)) {
                aVar.setChecked(true);
                childAt.setTag(aVar);
                return true;
            }
        }
        return false;
    }

    public String ahb() {
        Object tag;
        int childCount = this.cla.getChildCount();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.cla.getChildAt(i);
            if (childAt != this.cle && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
                if (i > 0) {
                    sb.append(",");
                }
                sb.append(((com.baidu.tbadk.coreExtra.relationship.a) tag).getUserId());
            }
        }
        return sb.toString();
    }

    public void f(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        View findViewWithTag = this.cla.findViewWithTag(aVar);
        if (findViewWithTag != null) {
            this.cla.removeView(findViewWithTag);
            if (!aha()) {
                agY();
            }
        }
    }

    private HeadImageView ahc() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.aaJ, this.clb);
        layoutParams.setMargins(this.clc, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    public int getItemLength() {
        return aha() ? this.cla.getChildCount() - 1 : this.cla.getChildCount();
    }
}
