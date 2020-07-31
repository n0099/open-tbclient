package com.baidu.tieba.imMessageCenter.im.friend;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HorizontalCustomScrollView;
import com.baidu.tieba.R;
import com.xiaomi.mipush.sdk.Constants;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes16.dex */
public class InviteFriendCandidateList extends HorizontalCustomScrollView {
    private View.OnClickListener awi;
    private LinearLayout jna;
    private int jnb;
    private int jnc;
    private HeadImageView jnd;
    private a jne;
    private Context mContext;
    private int mItemHeight;
    private int mItemWidth;

    /* loaded from: classes16.dex */
    public interface a {
        void a(View view, Object obj);
    }

    public InviteFriendCandidateList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mItemWidth = -1;
        this.mItemHeight = -1;
        this.jnb = -1;
        this.jnc = 4;
        this.awi = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                InviteFriendCandidateList.this.jna.removeView(view);
                if (!InviteFriendCandidateList.this.cyj()) {
                    InviteFriendCandidateList.this.cyh();
                }
                if (InviteFriendCandidateList.this.jne != null) {
                    InviteFriendCandidateList.this.jne.a(view, view.getTag());
                }
            }
        };
        this.mContext = context;
        initialize();
    }

    public void setMaxCount(int i) {
        this.jnc = i;
    }

    public void a(a aVar) {
        this.jne = aVar;
    }

    private void initialize() {
        this.mItemWidth = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds80);
        this.mItemHeight = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds80);
        this.jnb = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds12);
        this.jna = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.jna.setLayoutParams(layoutParams);
        this.jna.setHorizontalScrollBarEnabled(true);
        this.jna.setOrientation(0);
        cyh();
        addView(this.jna);
        setSmoothScrollingEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyh() {
        if (this.jnd == null) {
            this.jnd = cyk();
            this.jnd.setDrawBorder(false);
        }
        this.jnd.setImageBitmap(ao.getBitmap(R.drawable.icon_add_pop));
        this.jna.addView(this.jnd);
    }

    private void cyi() {
        if (cyj()) {
            this.jna.removeView(this.jnd);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cyj() {
        int childCount = this.jna.getChildCount();
        return childCount > 0 && this.jna.getChildAt(childCount + (-1)) == this.jnd;
    }

    public void d(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (getItemLength() < this.jnc) {
            HeadImageView cyk = cyk();
            cyk.setIsRound(false);
            cyk.startLoad(aVar.bgH(), 12, false);
            if (cyj()) {
                cyk.setTag(aVar);
                cyk.setOnClickListener(this.awi);
                this.jna.addView(cyk, getItemLength());
                scrollTo(getItemLength() * (this.mItemWidth + this.jnb), 0);
            }
            if (getItemLength() >= this.jnc) {
                cyi();
            }
        }
    }

    public boolean e(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        Object tag;
        int childCount = this.jna.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.jna.getChildAt(i);
            if (childAt != this.jnd && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a) && ((com.baidu.tbadk.coreExtra.relationship.a) tag).equals(aVar)) {
                aVar.setChecked(true);
                childAt.setTag(aVar);
                return true;
            }
        }
        return false;
    }

    public String getDataList() {
        Object tag;
        int childCount = this.jna.getChildCount();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.jna.getChildAt(i);
            if (childAt != this.jnd && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
                if (i > 0) {
                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(((com.baidu.tbadk.coreExtra.relationship.a) tag).getUserId());
            }
        }
        return sb.toString();
    }

    public void f(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        View findViewWithTag = this.jna.findViewWithTag(aVar);
        if (findViewWithTag != null) {
            this.jna.removeView(findViewWithTag);
            if (!cyj()) {
                cyh();
            }
        }
    }

    private HeadImageView cyk() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.mItemWidth, this.mItemHeight);
        layoutParams.setMargins(this.jnb, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    public int getItemLength() {
        return cyj() ? this.jna.getChildCount() - 1 : this.jna.getChildCount();
    }
}
