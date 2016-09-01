package com.baidu.tieba.imMessageCenter.im.friend;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HorizontalCustomScrollView;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class InviteFriendCandidateList extends HorizontalCustomScrollView {
    private int Ze;
    private int aRh;
    private View.OnClickListener bdv;
    private a dqA;
    private int dqx;
    private int dqy;
    private HeadImageView dqz;
    private Context mContext;
    private LinearLayout mLayout;

    /* loaded from: classes.dex */
    public interface a {
        void a(View view, Object obj);
    }

    public InviteFriendCandidateList(Context context) {
        super(context);
        this.Ze = -1;
        this.dqx = -1;
        this.dqy = -1;
        this.aRh = 4;
        this.bdv = new i(this);
        this.mContext = context;
        initialize();
    }

    public InviteFriendCandidateList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Ze = -1;
        this.dqx = -1;
        this.dqy = -1;
        this.aRh = 4;
        this.bdv = new i(this);
        this.mContext = context;
        initialize();
    }

    public void setMaxCount(int i) {
        this.aRh = i;
    }

    public void a(a aVar) {
        this.dqA = aVar;
    }

    private void initialize() {
        this.Ze = this.mContext.getResources().getDimensionPixelSize(t.e.ds80);
        this.dqx = this.mContext.getResources().getDimensionPixelSize(t.e.ds80);
        this.dqy = this.mContext.getResources().getDimensionPixelSize(t.e.ds12);
        this.mLayout = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.mLayout.setLayoutParams(layoutParams);
        this.mLayout.setHorizontalScrollBarEnabled(true);
        this.mLayout.setOrientation(0);
        ayn();
        addView(this.mLayout);
        setSmoothScrollingEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayn() {
        if (this.dqz == null) {
            this.dqz = ayr();
            this.dqz.setDrawBorder(false);
        }
        this.dqz.setImageBitmap(av.cN(t.f.icon_add_pop));
        this.mLayout.addView(this.dqz);
    }

    private void ayo() {
        if (ayp()) {
            this.mLayout.removeView(this.dqz);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ayp() {
        int childCount = this.mLayout.getChildCount();
        return childCount > 0 && this.mLayout.getChildAt(childCount + (-1)) == this.dqz;
    }

    public void d(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (getItemLength() < this.aRh) {
            HeadImageView ayr = ayr();
            ayr.setIsRound(false);
            ayr.c(aVar.Ao(), 12, false);
            if (ayp()) {
                ayr.setTag(aVar);
                ayr.setOnClickListener(this.bdv);
                this.mLayout.addView(ayr, getItemLength());
                scrollTo(getItemLength() * (this.Ze + this.dqy), 0);
            }
            if (getItemLength() >= this.aRh) {
                ayo();
            }
        }
    }

    public boolean e(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        Object tag;
        int childCount = this.mLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mLayout.getChildAt(i);
            if (childAt != this.dqz && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a) && ((com.baidu.tbadk.coreExtra.relationship.a) tag).equals(aVar)) {
                aVar.setChecked(true);
                childAt.setTag(aVar);
                return true;
            }
        }
        return false;
    }

    public String ayq() {
        Object tag;
        int childCount = this.mLayout.getChildCount();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mLayout.getChildAt(i);
            if (childAt != this.dqz && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
                if (i > 0) {
                    sb.append(",");
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
            if (!ayp()) {
                ayn();
            }
        }
    }

    private HeadImageView ayr() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.Ze, this.dqx);
        layoutParams.setMargins(this.dqy, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    public int getItemLength() {
        return ayp() ? this.mLayout.getChildCount() - 1 : this.mLayout.getChildCount();
    }
}
