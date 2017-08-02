package com.baidu.tieba.imMessageCenter.im.friend;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HorizontalCustomScrollView;
import com.baidu.tieba.d;
import com.xiaomi.mipush.sdk.Constants;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class InviteFriendCandidateList extends HorizontalCustomScrollView {
    private int aeq;
    private View.OnClickListener bsc;
    private int cLK;
    private int cad;
    private int dAQ;
    private HeadImageView dAR;
    private a dAS;
    private Context mContext;
    private LinearLayout mLayout;

    /* loaded from: classes2.dex */
    public interface a {
        void b(View view, Object obj);
    }

    public InviteFriendCandidateList(Context context) {
        super(context);
        this.aeq = -1;
        this.cad = -1;
        this.dAQ = -1;
        this.cLK = 4;
        this.bsc = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                InviteFriendCandidateList.this.mLayout.removeView(view);
                if (!InviteFriendCandidateList.this.ayD()) {
                    InviteFriendCandidateList.this.ayB();
                }
                if (InviteFriendCandidateList.this.dAS != null) {
                    InviteFriendCandidateList.this.dAS.b(view, view.getTag());
                }
            }
        };
        this.mContext = context;
        wU();
    }

    public InviteFriendCandidateList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aeq = -1;
        this.cad = -1;
        this.dAQ = -1;
        this.cLK = 4;
        this.bsc = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                InviteFriendCandidateList.this.mLayout.removeView(view);
                if (!InviteFriendCandidateList.this.ayD()) {
                    InviteFriendCandidateList.this.ayB();
                }
                if (InviteFriendCandidateList.this.dAS != null) {
                    InviteFriendCandidateList.this.dAS.b(view, view.getTag());
                }
            }
        };
        this.mContext = context;
        wU();
    }

    public void setMaxCount(int i) {
        this.cLK = i;
    }

    public void a(a aVar) {
        this.dAS = aVar;
    }

    private void wU() {
        this.aeq = this.mContext.getResources().getDimensionPixelSize(d.f.ds80);
        this.cad = this.mContext.getResources().getDimensionPixelSize(d.f.ds80);
        this.dAQ = this.mContext.getResources().getDimensionPixelSize(d.f.ds12);
        this.mLayout = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.mLayout.setLayoutParams(layoutParams);
        this.mLayout.setHorizontalScrollBarEnabled(true);
        this.mLayout.setOrientation(0);
        ayB();
        addView(this.mLayout);
        setSmoothScrollingEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayB() {
        if (this.dAR == null) {
            this.dAR = ayF();
            this.dAR.setDrawBorder(false);
        }
        this.dAR.setImageBitmap(ai.cQ(d.g.icon_add_pop));
        this.mLayout.addView(this.dAR);
    }

    private void ayC() {
        if (ayD()) {
            this.mLayout.removeView(this.dAR);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ayD() {
        int childCount = this.mLayout.getChildCount();
        return childCount > 0 && this.mLayout.getChildAt(childCount + (-1)) == this.dAR;
    }

    public void d(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (getItemLength() < this.cLK) {
            HeadImageView ayF = ayF();
            ayF.setIsRound(false);
            ayF.c(aVar.AG(), 12, false);
            if (ayD()) {
                ayF.setTag(aVar);
                ayF.setOnClickListener(this.bsc);
                this.mLayout.addView(ayF, getItemLength());
                scrollTo(getItemLength() * (this.aeq + this.dAQ), 0);
            }
            if (getItemLength() >= this.cLK) {
                ayC();
            }
        }
    }

    public boolean e(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        Object tag;
        int childCount = this.mLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mLayout.getChildAt(i);
            if (childAt != this.dAR && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a) && ((com.baidu.tbadk.coreExtra.relationship.a) tag).equals(aVar)) {
                aVar.setChecked(true);
                childAt.setTag(aVar);
                return true;
            }
        }
        return false;
    }

    public String ayE() {
        Object tag;
        int childCount = this.mLayout.getChildCount();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mLayout.getChildAt(i);
            if (childAt != this.dAR && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
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
            if (!ayD()) {
                ayB();
            }
        }
    }

    private HeadImageView ayF() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.aeq, this.cad);
        layoutParams.setMargins(this.dAQ, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    public int getItemLength() {
        return ayD() ? this.mLayout.getChildCount() - 1 : this.mLayout.getChildCount();
    }
}
