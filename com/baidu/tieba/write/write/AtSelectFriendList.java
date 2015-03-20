package com.baidu.tieba.write.write;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HorizontalCustomScrollView;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class AtSelectFriendList extends HorizontalCustomScrollView {
    private int Ta;
    private final View.OnClickListener aBr;
    private LinearLayout bsl;
    private int bsm;
    private int bsn;
    private int bso;
    private HeadImageView bsp;
    private r cwN;
    private final Context mContext;

    public AtSelectFriendList(Context context) {
        super(context);
        this.Ta = -1;
        this.bsm = -1;
        this.bsn = -1;
        this.bso = 4;
        this.aBr = new q(this);
        this.mContext = context;
        initialize();
    }

    public AtSelectFriendList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Ta = -1;
        this.bsm = -1;
        this.bsn = -1;
        this.bso = 4;
        this.aBr = new q(this);
        this.mContext = context;
        initialize();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMaxCount(int i) {
        this.bso = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setItemOPerationHandler(r rVar) {
        this.cwN = rVar;
    }

    private void initialize() {
        this.Ta = this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.t.invite_friend_candidate_item_width);
        this.bsm = this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.t.invite_friend_candidate_item_height);
        this.bsn = this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.t.invite_friend_candidate_item_margin);
        this.bsl = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.bsl.setLayoutParams(layoutParams);
        this.bsl.setHorizontalScrollBarEnabled(true);
        this.bsl.setOrientation(0);
        Vo();
        addView(this.bsl);
        setSmoothScrollingEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vo() {
        if (this.bsp == null) {
            this.bsp = Vs();
            this.bsp.setDrawBorder(false);
        }
        this.bsp.setImageBitmap(com.baidu.tbadk.core.util.ba.cg(com.baidu.tieba.u.icon_add_pop));
        this.bsl.addView(this.bsp);
    }

    private void Vp() {
        if (Vq()) {
            this.bsl.removeView(this.bsp);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Vq() {
        int childCount = this.bsl.getChildCount();
        return childCount > 0 && this.bsl.getChildAt(childCount + (-1)) == this.bsp;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(MetaData metaData) {
        if (getItemLength() < this.bso) {
            HeadImageView Vs = Vs();
            Vs.setIsRound(false);
            Vs.c(metaData.getPortrait(), 12, false);
            if (Vq()) {
                Vs.setTag(metaData);
                Vs.setOnClickListener(this.aBr);
                this.bsl.addView(Vs, getItemLength());
                scrollTo(getItemLength() * (this.Ta + this.bsn), 0);
                this.bsl.requestLayout();
            }
            if (getItemLength() >= this.bso) {
                Vp();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(MetaData metaData) {
        Object tag;
        int childCount = this.bsl.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bsl.getChildAt(i);
            if (childAt != this.bsp && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && metaData != null) {
                MetaData metaData2 = (MetaData) tag;
                if (metaData2.getUserName() != null && metaData2.getUserName().equals(metaData.getUserName())) {
                    metaData.setChecked(true);
                    childAt.setTag(metaData);
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<String> getDataList() {
        Object tag;
        String name_show;
        int childCount = this.bsl.getChildCount();
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bsl.getChildAt(i);
            if (childAt != this.bsp && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && (name_show = ((MetaData) tag).getName_show()) != null) {
                arrayList.add(name_show);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(MetaData metaData) {
        View findViewWithTag = this.bsl.findViewWithTag(metaData);
        if (findViewWithTag != null) {
            this.bsl.removeView(findViewWithTag);
            if (!Vq()) {
                Vo();
            }
        }
    }

    private HeadImageView Vs() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.Ta, this.bsm);
        layoutParams.setMargins(this.bsn, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getItemLength() {
        return Vq() ? this.bsl.getChildCount() - 1 : this.bsl.getChildCount();
    }
}
