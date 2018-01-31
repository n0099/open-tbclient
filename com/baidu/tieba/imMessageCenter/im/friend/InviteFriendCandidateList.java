package com.baidu.tieba.imMessageCenter.im.friend;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
import com.xiaomi.mipush.sdk.Constants;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class InviteFriendCandidateList extends com.baidu.tbadk.core.view.d {
    private int aTh;
    private View.OnClickListener ctZ;
    private int eMt;
    private int eMu;
    private HeadImageView eMv;
    private a eMw;
    private Context mContext;
    private int mItemHeight;
    private LinearLayout mLayout;

    /* loaded from: classes2.dex */
    public interface a {
        void b(View view, Object obj);
    }

    public InviteFriendCandidateList(Context context) {
        super(context);
        this.aTh = -1;
        this.mItemHeight = -1;
        this.eMt = -1;
        this.eMu = 4;
        this.ctZ = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                InviteFriendCandidateList.this.mLayout.removeView(view);
                if (!InviteFriendCandidateList.this.aLp()) {
                    InviteFriendCandidateList.this.aLn();
                }
                if (InviteFriendCandidateList.this.eMw != null) {
                    InviteFriendCandidateList.this.eMw.b(view, view.getTag());
                }
            }
        };
        this.mContext = context;
        DS();
    }

    public InviteFriendCandidateList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aTh = -1;
        this.mItemHeight = -1;
        this.eMt = -1;
        this.eMu = 4;
        this.ctZ = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                InviteFriendCandidateList.this.mLayout.removeView(view);
                if (!InviteFriendCandidateList.this.aLp()) {
                    InviteFriendCandidateList.this.aLn();
                }
                if (InviteFriendCandidateList.this.eMw != null) {
                    InviteFriendCandidateList.this.eMw.b(view, view.getTag());
                }
            }
        };
        this.mContext = context;
        DS();
    }

    public void setMaxCount(int i) {
        this.eMu = i;
    }

    public void a(a aVar) {
        this.eMw = aVar;
    }

    private void DS() {
        this.aTh = this.mContext.getResources().getDimensionPixelSize(d.e.ds80);
        this.mItemHeight = this.mContext.getResources().getDimensionPixelSize(d.e.ds80);
        this.eMt = this.mContext.getResources().getDimensionPixelSize(d.e.ds12);
        this.mLayout = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.mLayout.setLayoutParams(layoutParams);
        this.mLayout.setHorizontalScrollBarEnabled(true);
        this.mLayout.setOrientation(0);
        aLn();
        addView(this.mLayout);
        setSmoothScrollingEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aLn() {
        if (this.eMv == null) {
            this.eMv = aLr();
            this.eMv.setDrawBorder(false);
        }
        this.eMv.setImageBitmap(aj.fO(d.f.icon_add_pop));
        this.mLayout.addView(this.eMv);
    }

    private void aLo() {
        if (aLp()) {
            this.mLayout.removeView(this.eMv);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aLp() {
        int childCount = this.mLayout.getChildCount();
        return childCount > 0 && this.mLayout.getChildAt(childCount + (-1)) == this.eMv;
    }

    public void d(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (getItemLength() < this.eMu) {
            HeadImageView aLr = aLr();
            aLr.setIsRound(false);
            aLr.startLoad(aVar.In(), 12, false);
            if (aLp()) {
                aLr.setTag(aVar);
                aLr.setOnClickListener(this.ctZ);
                this.mLayout.addView(aLr, getItemLength());
                scrollTo(getItemLength() * (this.aTh + this.eMt), 0);
            }
            if (getItemLength() >= this.eMu) {
                aLo();
            }
        }
    }

    public boolean e(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        Object tag;
        int childCount = this.mLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mLayout.getChildAt(i);
            if (childAt != this.eMv && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a) && ((com.baidu.tbadk.coreExtra.relationship.a) tag).equals(aVar)) {
                aVar.setChecked(true);
                childAt.setTag(aVar);
                return true;
            }
        }
        return false;
    }

    public String aLq() {
        Object tag;
        int childCount = this.mLayout.getChildCount();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mLayout.getChildAt(i);
            if (childAt != this.eMv && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
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
            if (!aLp()) {
                aLn();
            }
        }
    }

    private HeadImageView aLr() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.aTh, this.mItemHeight);
        layoutParams.setMargins(this.eMt, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    public int getItemLength() {
        return aLp() ? this.mLayout.getChildCount() - 1 : this.mLayout.getChildCount();
    }
}
