package com.baidu.tieba.imMessageCenter.im.friend;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HorizontalCustomScrollView;
import com.baidu.tieba.R;
import com.xiaomi.mipush.sdk.Constants;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes22.dex */
public class InviteFriendCandidateList extends HorizontalCustomScrollView {
    private View.OnClickListener aFf;
    private LinearLayout kmf;
    private int kmg;
    private int kmh;
    private HeadImageView kmi;
    private a kmj;
    private Context mContext;
    private int mItemHeight;
    private int mItemWidth;

    /* loaded from: classes22.dex */
    public interface a {
        void a(View view, Object obj);
    }

    public InviteFriendCandidateList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mItemWidth = -1;
        this.mItemHeight = -1;
        this.kmg = -1;
        this.kmh = 4;
        this.aFf = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                InviteFriendCandidateList.this.kmf.removeView(view);
                if (!InviteFriendCandidateList.this.cTw()) {
                    InviteFriendCandidateList.this.cTu();
                }
                if (InviteFriendCandidateList.this.kmj != null) {
                    InviteFriendCandidateList.this.kmj.a(view, view.getTag());
                }
            }
        };
        this.mContext = context;
        initialize();
    }

    public void setMaxCount(int i) {
        this.kmh = i;
    }

    public void a(a aVar) {
        this.kmj = aVar;
    }

    private void initialize() {
        this.mItemWidth = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds80);
        this.mItemHeight = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds80);
        this.kmg = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds12);
        this.kmf = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.kmf.setLayoutParams(layoutParams);
        this.kmf.setHorizontalScrollBarEnabled(true);
        this.kmf.setOrientation(0);
        cTu();
        addView(this.kmf);
        setSmoothScrollingEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cTu() {
        if (this.kmi == null) {
            this.kmi = cTx();
            this.kmi.setDrawBorder(false);
        }
        this.kmi.setImageBitmap(ap.getBitmap(R.drawable.icon_add_pop));
        this.kmf.addView(this.kmi);
    }

    private void cTv() {
        if (cTw()) {
            this.kmf.removeView(this.kmi);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cTw() {
        int childCount = this.kmf.getChildCount();
        return childCount > 0 && this.kmf.getChildAt(childCount + (-1)) == this.kmi;
    }

    public void d(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (getItemLength() < this.kmh) {
            HeadImageView cTx = cTx();
            cTx.setIsRound(false);
            cTx.startLoad(aVar.buQ(), 12, false);
            if (cTw()) {
                cTx.setTag(aVar);
                cTx.setOnClickListener(this.aFf);
                this.kmf.addView(cTx, getItemLength());
                scrollTo(getItemLength() * (this.mItemWidth + this.kmg), 0);
            }
            if (getItemLength() >= this.kmh) {
                cTv();
            }
        }
    }

    public boolean e(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        Object tag;
        int childCount = this.kmf.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.kmf.getChildAt(i);
            if (childAt != this.kmi && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a) && ((com.baidu.tbadk.coreExtra.relationship.a) tag).equals(aVar)) {
                aVar.setChecked(true);
                childAt.setTag(aVar);
                return true;
            }
        }
        return false;
    }

    public String getDataList() {
        Object tag;
        int childCount = this.kmf.getChildCount();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.kmf.getChildAt(i);
            if (childAt != this.kmi && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
                if (i > 0) {
                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(((com.baidu.tbadk.coreExtra.relationship.a) tag).getUserId());
            }
        }
        return sb.toString();
    }

    public void f(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        View findViewWithTag = this.kmf.findViewWithTag(aVar);
        if (findViewWithTag != null) {
            this.kmf.removeView(findViewWithTag);
            if (!cTw()) {
                cTu();
            }
        }
    }

    private HeadImageView cTx() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.mItemWidth, this.mItemHeight);
        layoutParams.setMargins(this.kmg, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    public int getItemLength() {
        return cTw() ? this.kmf.getChildCount() - 1 : this.kmf.getChildCount();
    }
}
