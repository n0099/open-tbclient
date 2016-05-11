package com.baidu.tieba.imMessageCenter.im.friend;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HorizontalCustomScrollView;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class InviteFriendCandidateList extends HorizontalCustomScrollView {
    private int Vr;
    private View.OnClickListener aTj;
    private int bNW;
    private LinearLayout cwC;
    private int cwD;
    private int cwE;
    private HeadImageView cwF;
    private a cwG;
    private Context mContext;

    /* loaded from: classes.dex */
    public interface a {
        void a(View view, Object obj);
    }

    public InviteFriendCandidateList(Context context) {
        super(context);
        this.Vr = -1;
        this.cwD = -1;
        this.cwE = -1;
        this.bNW = 4;
        this.aTj = new i(this);
        this.mContext = context;
        vk();
    }

    public InviteFriendCandidateList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Vr = -1;
        this.cwD = -1;
        this.cwE = -1;
        this.bNW = 4;
        this.aTj = new i(this);
        this.mContext = context;
        vk();
    }

    public void setMaxCount(int i) {
        this.bNW = i;
    }

    public void a(a aVar) {
        this.cwG = aVar;
    }

    private void vk() {
        this.Vr = this.mContext.getResources().getDimensionPixelSize(t.e.invite_friend_candidate_item_width);
        this.cwD = this.mContext.getResources().getDimensionPixelSize(t.e.invite_friend_candidate_item_height);
        this.cwE = this.mContext.getResources().getDimensionPixelSize(t.e.invite_friend_candidate_item_margin);
        this.cwC = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.cwC.setLayoutParams(layoutParams);
        this.cwC.setHorizontalScrollBarEnabled(true);
        this.cwC.setOrientation(0);
        aky();
        addView(this.cwC);
        setSmoothScrollingEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aky() {
        if (this.cwF == null) {
            this.cwF = akC();
            this.cwF.setDrawBorder(false);
        }
        this.cwF.setImageBitmap(at.cA(t.f.icon_add_pop));
        this.cwC.addView(this.cwF);
    }

    private void akz() {
        if (akA()) {
            this.cwC.removeView(this.cwF);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean akA() {
        int childCount = this.cwC.getChildCount();
        return childCount > 0 && this.cwC.getChildAt(childCount + (-1)) == this.cwF;
    }

    public void d(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (getItemLength() < this.bNW) {
            HeadImageView akC = akC();
            akC.setIsRound(false);
            akC.c(aVar.getUserPortrait(), 12, false);
            if (akA()) {
                akC.setTag(aVar);
                akC.setOnClickListener(this.aTj);
                this.cwC.addView(akC, getItemLength());
                scrollTo(getItemLength() * (this.Vr + this.cwE), 0);
            }
            if (getItemLength() >= this.bNW) {
                akz();
            }
        }
    }

    public boolean e(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        Object tag;
        int childCount = this.cwC.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.cwC.getChildAt(i);
            if (childAt != this.cwF && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a) && ((com.baidu.tbadk.coreExtra.relationship.a) tag).equals(aVar)) {
                aVar.setChecked(true);
                childAt.setTag(aVar);
                return true;
            }
        }
        return false;
    }

    public String akB() {
        Object tag;
        int childCount = this.cwC.getChildCount();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.cwC.getChildAt(i);
            if (childAt != this.cwF && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
                if (i > 0) {
                    sb.append(",");
                }
                sb.append(((com.baidu.tbadk.coreExtra.relationship.a) tag).getUserId());
            }
        }
        return sb.toString();
    }

    public void f(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        View findViewWithTag = this.cwC.findViewWithTag(aVar);
        if (findViewWithTag != null) {
            this.cwC.removeView(findViewWithTag);
            if (!akA()) {
                aky();
            }
        }
    }

    private HeadImageView akC() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.Vr, this.cwD);
        layoutParams.setMargins(this.cwE, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    public int getItemLength() {
        return akA() ? this.cwC.getChildCount() - 1 : this.cwC.getChildCount();
    }
}
