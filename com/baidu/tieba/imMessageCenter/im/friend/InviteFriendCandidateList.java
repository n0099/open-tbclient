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
    private int afL;
    private View.OnClickListener btm;
    private int cNf;
    private int cbj;
    private int dCh;
    private HeadImageView dCi;
    private a dCj;
    private Context mContext;
    private LinearLayout mLayout;

    /* loaded from: classes2.dex */
    public interface a {
        void b(View view, Object obj);
    }

    public InviteFriendCandidateList(Context context) {
        super(context);
        this.afL = -1;
        this.cbj = -1;
        this.dCh = -1;
        this.cNf = 4;
        this.btm = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                InviteFriendCandidateList.this.mLayout.removeView(view);
                if (!InviteFriendCandidateList.this.ayO()) {
                    InviteFriendCandidateList.this.ayM();
                }
                if (InviteFriendCandidateList.this.dCj != null) {
                    InviteFriendCandidateList.this.dCj.b(view, view.getTag());
                }
            }
        };
        this.mContext = context;
        bg();
    }

    public InviteFriendCandidateList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.afL = -1;
        this.cbj = -1;
        this.dCh = -1;
        this.cNf = 4;
        this.btm = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                InviteFriendCandidateList.this.mLayout.removeView(view);
                if (!InviteFriendCandidateList.this.ayO()) {
                    InviteFriendCandidateList.this.ayM();
                }
                if (InviteFriendCandidateList.this.dCj != null) {
                    InviteFriendCandidateList.this.dCj.b(view, view.getTag());
                }
            }
        };
        this.mContext = context;
        bg();
    }

    public void setMaxCount(int i) {
        this.cNf = i;
    }

    public void a(a aVar) {
        this.dCj = aVar;
    }

    private void bg() {
        this.afL = this.mContext.getResources().getDimensionPixelSize(d.f.ds80);
        this.cbj = this.mContext.getResources().getDimensionPixelSize(d.f.ds80);
        this.dCh = this.mContext.getResources().getDimensionPixelSize(d.f.ds12);
        this.mLayout = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.mLayout.setLayoutParams(layoutParams);
        this.mLayout.setHorizontalScrollBarEnabled(true);
        this.mLayout.setOrientation(0);
        ayM();
        addView(this.mLayout);
        setSmoothScrollingEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayM() {
        if (this.dCi == null) {
            this.dCi = ayQ();
            this.dCi.setDrawBorder(false);
        }
        this.dCi.setImageBitmap(ai.cS(d.g.icon_add_pop));
        this.mLayout.addView(this.dCi);
    }

    private void ayN() {
        if (ayO()) {
            this.mLayout.removeView(this.dCi);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ayO() {
        int childCount = this.mLayout.getChildCount();
        return childCount > 0 && this.mLayout.getChildAt(childCount + (-1)) == this.dCi;
    }

    public void d(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (getItemLength() < this.cNf) {
            HeadImageView ayQ = ayQ();
            ayQ.setIsRound(false);
            ayQ.c(aVar.AO(), 12, false);
            if (ayO()) {
                ayQ.setTag(aVar);
                ayQ.setOnClickListener(this.btm);
                this.mLayout.addView(ayQ, getItemLength());
                scrollTo(getItemLength() * (this.afL + this.dCh), 0);
            }
            if (getItemLength() >= this.cNf) {
                ayN();
            }
        }
    }

    public boolean e(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        Object tag;
        int childCount = this.mLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mLayout.getChildAt(i);
            if (childAt != this.dCi && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a) && ((com.baidu.tbadk.coreExtra.relationship.a) tag).equals(aVar)) {
                aVar.setChecked(true);
                childAt.setTag(aVar);
                return true;
            }
        }
        return false;
    }

    public String ayP() {
        Object tag;
        int childCount = this.mLayout.getChildCount();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mLayout.getChildAt(i);
            if (childAt != this.dCi && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
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
            if (!ayO()) {
                ayM();
            }
        }
    }

    private HeadImageView ayQ() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.afL, this.cbj);
        layoutParams.setMargins(this.dCh, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    public int getItemLength() {
        return ayO() ? this.mLayout.getChildCount() - 1 : this.mLayout.getChildCount();
    }
}
