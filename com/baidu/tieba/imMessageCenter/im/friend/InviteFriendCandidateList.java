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
    private LinearLayout jnc;
    private int jnd;
    private int jne;
    private HeadImageView jnf;
    private a jng;
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
        this.jnd = -1;
        this.jne = 4;
        this.awi = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                InviteFriendCandidateList.this.jnc.removeView(view);
                if (!InviteFriendCandidateList.this.cyj()) {
                    InviteFriendCandidateList.this.cyh();
                }
                if (InviteFriendCandidateList.this.jng != null) {
                    InviteFriendCandidateList.this.jng.a(view, view.getTag());
                }
            }
        };
        this.mContext = context;
        initialize();
    }

    public void setMaxCount(int i) {
        this.jne = i;
    }

    public void a(a aVar) {
        this.jng = aVar;
    }

    private void initialize() {
        this.mItemWidth = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds80);
        this.mItemHeight = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds80);
        this.jnd = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds12);
        this.jnc = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.jnc.setLayoutParams(layoutParams);
        this.jnc.setHorizontalScrollBarEnabled(true);
        this.jnc.setOrientation(0);
        cyh();
        addView(this.jnc);
        setSmoothScrollingEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyh() {
        if (this.jnf == null) {
            this.jnf = cyk();
            this.jnf.setDrawBorder(false);
        }
        this.jnf.setImageBitmap(ao.getBitmap(R.drawable.icon_add_pop));
        this.jnc.addView(this.jnf);
    }

    private void cyi() {
        if (cyj()) {
            this.jnc.removeView(this.jnf);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cyj() {
        int childCount = this.jnc.getChildCount();
        return childCount > 0 && this.jnc.getChildAt(childCount + (-1)) == this.jnf;
    }

    public void d(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (getItemLength() < this.jne) {
            HeadImageView cyk = cyk();
            cyk.setIsRound(false);
            cyk.startLoad(aVar.bgH(), 12, false);
            if (cyj()) {
                cyk.setTag(aVar);
                cyk.setOnClickListener(this.awi);
                this.jnc.addView(cyk, getItemLength());
                scrollTo(getItemLength() * (this.mItemWidth + this.jnd), 0);
            }
            if (getItemLength() >= this.jne) {
                cyi();
            }
        }
    }

    public boolean e(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        Object tag;
        int childCount = this.jnc.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.jnc.getChildAt(i);
            if (childAt != this.jnf && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a) && ((com.baidu.tbadk.coreExtra.relationship.a) tag).equals(aVar)) {
                aVar.setChecked(true);
                childAt.setTag(aVar);
                return true;
            }
        }
        return false;
    }

    public String getDataList() {
        Object tag;
        int childCount = this.jnc.getChildCount();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.jnc.getChildAt(i);
            if (childAt != this.jnf && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
                if (i > 0) {
                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(((com.baidu.tbadk.coreExtra.relationship.a) tag).getUserId());
            }
        }
        return sb.toString();
    }

    public void f(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        View findViewWithTag = this.jnc.findViewWithTag(aVar);
        if (findViewWithTag != null) {
            this.jnc.removeView(findViewWithTag);
            if (!cyj()) {
                cyh();
            }
        }
    }

    private HeadImageView cyk() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.mItemWidth, this.mItemHeight);
        layoutParams.setMargins(this.jnd, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    public int getItemLength() {
        return cyj() ? this.jnc.getChildCount() - 1 : this.jnc.getChildCount();
    }
}
