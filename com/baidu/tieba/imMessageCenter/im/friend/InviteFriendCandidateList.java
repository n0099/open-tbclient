package com.baidu.tieba.imMessageCenter.im.friend;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HorizontalCustomScrollView;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class InviteFriendCandidateList extends HorizontalCustomScrollView {
    private int YR;
    private View.OnClickListener aKj;
    private LinearLayout bNb;
    private int bNc;
    private int bNd;
    private int bNe;
    private HeadImageView bNf;
    private a bNg;
    private Context mContext;

    /* loaded from: classes.dex */
    public interface a {
        void a(View view, Object obj);
    }

    public InviteFriendCandidateList(Context context) {
        super(context);
        this.YR = -1;
        this.bNc = -1;
        this.bNd = -1;
        this.bNe = 4;
        this.aKj = new i(this);
        this.mContext = context;
        initialize();
    }

    public InviteFriendCandidateList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.YR = -1;
        this.bNc = -1;
        this.bNd = -1;
        this.bNe = 4;
        this.aKj = new i(this);
        this.mContext = context;
        initialize();
    }

    public void setMaxCount(int i) {
        this.bNe = i;
    }

    public void a(a aVar) {
        this.bNg = aVar;
    }

    private void initialize() {
        this.YR = this.mContext.getResources().getDimensionPixelSize(i.d.invite_friend_candidate_item_width);
        this.bNc = this.mContext.getResources().getDimensionPixelSize(i.d.invite_friend_candidate_item_height);
        this.bNd = this.mContext.getResources().getDimensionPixelSize(i.d.invite_friend_candidate_item_margin);
        this.bNb = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.bNb.setLayoutParams(layoutParams);
        this.bNb.setHorizontalScrollBarEnabled(true);
        this.bNb.setOrientation(0);
        Zi();
        addView(this.bNb);
        setSmoothScrollingEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Zi() {
        if (this.bNf == null) {
            this.bNf = Zm();
            this.bNf.setDrawBorder(false);
        }
        this.bNf.setImageBitmap(an.cw(i.e.icon_add_pop));
        this.bNb.addView(this.bNf);
    }

    private void Zj() {
        if (Zk()) {
            this.bNb.removeView(this.bNf);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Zk() {
        int childCount = this.bNb.getChildCount();
        return childCount > 0 && this.bNb.getChildAt(childCount + (-1)) == this.bNf;
    }

    public void d(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (getItemLength() < this.bNe) {
            HeadImageView Zm = Zm();
            Zm.setIsRound(false);
            Zm.d(aVar.getUserPortrait(), 12, false);
            if (Zk()) {
                Zm.setTag(aVar);
                Zm.setOnClickListener(this.aKj);
                this.bNb.addView(Zm, getItemLength());
                scrollTo(getItemLength() * (this.YR + this.bNd), 0);
            }
            if (getItemLength() >= this.bNe) {
                Zj();
            }
        }
    }

    public boolean e(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        Object tag;
        int childCount = this.bNb.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bNb.getChildAt(i);
            if (childAt != this.bNf && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a) && ((com.baidu.tbadk.coreExtra.relationship.a) tag).equals(aVar)) {
                aVar.setChecked(true);
                childAt.setTag(aVar);
                return true;
            }
        }
        return false;
    }

    public String Zl() {
        Object tag;
        int childCount = this.bNb.getChildCount();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bNb.getChildAt(i);
            if (childAt != this.bNf && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
                if (i > 0) {
                    sb.append(",");
                }
                sb.append(((com.baidu.tbadk.coreExtra.relationship.a) tag).getUserId());
            }
        }
        return sb.toString();
    }

    public void f(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        View findViewWithTag = this.bNb.findViewWithTag(aVar);
        if (findViewWithTag != null) {
            this.bNb.removeView(findViewWithTag);
            if (!Zk()) {
                Zi();
            }
        }
    }

    private HeadImageView Zm() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.YR, this.bNc);
        layoutParams.setMargins(this.bNd, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    public int getItemLength() {
        return Zk() ? this.bNb.getChildCount() - 1 : this.bNb.getChildCount();
    }
}
