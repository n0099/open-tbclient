package com.baidu.tieba.imMessageCenter.im.friend;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HorizontalCustomScrollView;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class InviteFriendCandidateList extends HorizontalCustomScrollView {
    private int YP;
    private View.OnClickListener aJY;
    private LinearLayout bMQ;
    private int bMR;
    private int bMS;
    private int bMT;
    private HeadImageView bMU;
    private a bMV;
    private Context mContext;

    /* loaded from: classes.dex */
    public interface a {
        void a(View view, Object obj);
    }

    public InviteFriendCandidateList(Context context) {
        super(context);
        this.YP = -1;
        this.bMR = -1;
        this.bMS = -1;
        this.bMT = 4;
        this.aJY = new i(this);
        this.mContext = context;
        initialize();
    }

    public InviteFriendCandidateList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.YP = -1;
        this.bMR = -1;
        this.bMS = -1;
        this.bMT = 4;
        this.aJY = new i(this);
        this.mContext = context;
        initialize();
    }

    public void setMaxCount(int i) {
        this.bMT = i;
    }

    public void a(a aVar) {
        this.bMV = aVar;
    }

    private void initialize() {
        this.YP = this.mContext.getResources().getDimensionPixelSize(i.d.invite_friend_candidate_item_width);
        this.bMR = this.mContext.getResources().getDimensionPixelSize(i.d.invite_friend_candidate_item_height);
        this.bMS = this.mContext.getResources().getDimensionPixelSize(i.d.invite_friend_candidate_item_margin);
        this.bMQ = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.bMQ.setLayoutParams(layoutParams);
        this.bMQ.setHorizontalScrollBarEnabled(true);
        this.bMQ.setOrientation(0);
        Zi();
        addView(this.bMQ);
        setSmoothScrollingEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Zi() {
        if (this.bMU == null) {
            this.bMU = Zm();
            this.bMU.setDrawBorder(false);
        }
        this.bMU.setImageBitmap(am.cw(i.e.icon_add_pop));
        this.bMQ.addView(this.bMU);
    }

    private void Zj() {
        if (Zk()) {
            this.bMQ.removeView(this.bMU);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Zk() {
        int childCount = this.bMQ.getChildCount();
        return childCount > 0 && this.bMQ.getChildAt(childCount + (-1)) == this.bMU;
    }

    public void d(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (getItemLength() < this.bMT) {
            HeadImageView Zm = Zm();
            Zm.setIsRound(false);
            Zm.d(aVar.getUserPortrait(), 12, false);
            if (Zk()) {
                Zm.setTag(aVar);
                Zm.setOnClickListener(this.aJY);
                this.bMQ.addView(Zm, getItemLength());
                scrollTo(getItemLength() * (this.YP + this.bMS), 0);
            }
            if (getItemLength() >= this.bMT) {
                Zj();
            }
        }
    }

    public boolean e(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        Object tag;
        int childCount = this.bMQ.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bMQ.getChildAt(i);
            if (childAt != this.bMU && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a) && ((com.baidu.tbadk.coreExtra.relationship.a) tag).equals(aVar)) {
                aVar.setChecked(true);
                childAt.setTag(aVar);
                return true;
            }
        }
        return false;
    }

    public String Zl() {
        Object tag;
        int childCount = this.bMQ.getChildCount();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bMQ.getChildAt(i);
            if (childAt != this.bMU && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
                if (i > 0) {
                    sb.append(",");
                }
                sb.append(((com.baidu.tbadk.coreExtra.relationship.a) tag).getUserId());
            }
        }
        return sb.toString();
    }

    public void f(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        View findViewWithTag = this.bMQ.findViewWithTag(aVar);
        if (findViewWithTag != null) {
            this.bMQ.removeView(findViewWithTag);
            if (!Zk()) {
                Zi();
            }
        }
    }

    private HeadImageView Zm() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.YP, this.bMR);
        layoutParams.setMargins(this.bMS, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    public int getItemLength() {
        return Zk() ? this.bMQ.getChildCount() - 1 : this.bMQ.getChildCount();
    }
}
