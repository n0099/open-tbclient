package com.baidu.tieba.imMessageCenter.im.friend;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HorizontalCustomScrollView;
import com.baidu.tieba.R;
import com.xiaomi.mipush.sdk.Constants;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class InviteFriendCandidateList extends HorizontalCustomScrollView {
    private int bPX;
    private View.OnClickListener dSP;
    private int gMQ;
    private int gMR;
    private HeadImageView gMS;
    private a gMT;
    private Context mContext;
    private int mItemHeight;
    private LinearLayout mLayout;

    /* loaded from: classes4.dex */
    public interface a {
        void b(View view, Object obj);
    }

    public InviteFriendCandidateList(Context context) {
        super(context);
        this.bPX = -1;
        this.mItemHeight = -1;
        this.gMQ = -1;
        this.gMR = 4;
        this.dSP = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                InviteFriendCandidateList.this.mLayout.removeView(view);
                if (!InviteFriendCandidateList.this.bEB()) {
                    InviteFriendCandidateList.this.bEz();
                }
                if (InviteFriendCandidateList.this.gMT != null) {
                    InviteFriendCandidateList.this.gMT.b(view, view.getTag());
                }
            }
        };
        this.mContext = context;
        initialize();
    }

    public InviteFriendCandidateList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bPX = -1;
        this.mItemHeight = -1;
        this.gMQ = -1;
        this.gMR = 4;
        this.dSP = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                InviteFriendCandidateList.this.mLayout.removeView(view);
                if (!InviteFriendCandidateList.this.bEB()) {
                    InviteFriendCandidateList.this.bEz();
                }
                if (InviteFriendCandidateList.this.gMT != null) {
                    InviteFriendCandidateList.this.gMT.b(view, view.getTag());
                }
            }
        };
        this.mContext = context;
        initialize();
    }

    public void setMaxCount(int i) {
        this.gMR = i;
    }

    public void a(a aVar) {
        this.gMT = aVar;
    }

    private void initialize() {
        this.bPX = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds80);
        this.mItemHeight = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds80);
        this.gMQ = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds12);
        this.mLayout = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.mLayout.setLayoutParams(layoutParams);
        this.mLayout.setHorizontalScrollBarEnabled(true);
        this.mLayout.setOrientation(0);
        bEz();
        addView(this.mLayout);
        setSmoothScrollingEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEz() {
        if (this.gMS == null) {
            this.gMS = bED();
            this.gMS.setDrawBorder(false);
        }
        this.gMS.setImageBitmap(al.id(R.drawable.icon_add_pop));
        this.mLayout.addView(this.gMS);
    }

    private void bEA() {
        if (bEB()) {
            this.mLayout.removeView(this.gMS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bEB() {
        int childCount = this.mLayout.getChildCount();
        return childCount > 0 && this.mLayout.getChildAt(childCount + (-1)) == this.gMS;
    }

    public void d(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (getItemLength() < this.gMR) {
            HeadImageView bED = bED();
            bED.setIsRound(false);
            bED.startLoad(aVar.aoM(), 12, false);
            if (bEB()) {
                bED.setTag(aVar);
                bED.setOnClickListener(this.dSP);
                this.mLayout.addView(bED, getItemLength());
                scrollTo(getItemLength() * (this.bPX + this.gMQ), 0);
            }
            if (getItemLength() >= this.gMR) {
                bEA();
            }
        }
    }

    public boolean e(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        Object tag;
        int childCount = this.mLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mLayout.getChildAt(i);
            if (childAt != this.gMS && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a) && ((com.baidu.tbadk.coreExtra.relationship.a) tag).equals(aVar)) {
                aVar.setChecked(true);
                childAt.setTag(aVar);
                return true;
            }
        }
        return false;
    }

    public String bEC() {
        Object tag;
        int childCount = this.mLayout.getChildCount();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mLayout.getChildAt(i);
            if (childAt != this.gMS && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
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
            if (!bEB()) {
                bEz();
            }
        }
    }

    private HeadImageView bED() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.bPX, this.mItemHeight);
        layoutParams.setMargins(this.gMQ, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    public int getItemLength() {
        return bEB() ? this.mLayout.getChildCount() - 1 : this.mLayout.getChildCount();
    }
}
