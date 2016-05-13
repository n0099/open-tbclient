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
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class AtSelectFriendList extends HorizontalCustomScrollView {
    private int Vr;
    private final View.OnClickListener aTj;
    private int bNW;
    private LinearLayout cwC;
    private int cwD;
    private int cwE;
    private HeadImageView cwF;
    private a fcv;
    private final Context mContext;

    /* loaded from: classes.dex */
    public interface a {
        void a(View view, Object obj);
    }

    public AtSelectFriendList(Context context) {
        super(context);
        this.Vr = -1;
        this.cwD = -1;
        this.cwE = -1;
        this.bNW = 4;
        this.aTj = new o(this);
        this.mContext = context;
        vl();
    }

    public AtSelectFriendList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Vr = -1;
        this.cwD = -1;
        this.cwE = -1;
        this.bNW = 4;
        this.aTj = new o(this);
        this.mContext = context;
        vl();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMaxCount(int i) {
        this.bNW = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setItemOPerationHandler(a aVar) {
        this.fcv = aVar;
    }

    private void vl() {
        this.Vr = this.mContext.getResources().getDimensionPixelSize(t.e.invite_friend_candidate_item_width);
        this.cwD = this.mContext.getResources().getDimensionPixelSize(t.e.invite_friend_candidate_item_height);
        this.cwE = this.mContext.getResources().getDimensionPixelSize(t.e.invite_friend_candidate_item_margin);
        this.cwC = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.cwC.setLayoutParams(layoutParams);
        this.cwC.setHorizontalScrollBarEnabled(true);
        this.cwC.setOrientation(0);
        akA();
        addView(this.cwC);
        setSmoothScrollingEnabled(true);
        setFocusable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akA() {
        if (this.cwF == null) {
            this.cwF = akE();
            this.cwF.setDrawBorder(false);
        }
        this.cwF.setImageBitmap(com.baidu.tbadk.core.util.at.cz(t.f.icon_add_pop));
        this.cwC.addView(this.cwF);
    }

    private void akB() {
        if (akC()) {
            this.cwC.removeView(this.cwF);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean akC() {
        int childCount = this.cwC.getChildCount();
        return childCount > 0 && this.cwC.getChildAt(childCount + (-1)) == this.cwF;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(MetaData metaData) {
        if (getItemLength() < this.bNW) {
            HeadImageView akE = akE();
            akE.setIsRound(false);
            akE.c(metaData.getPortrait(), 12, false);
            if (akC()) {
                akE.setTag(metaData);
                akE.setOnClickListener(this.aTj);
                this.cwC.addView(akE, getItemLength());
                scrollTo(getItemLength() * (this.Vr + this.cwE), 0);
                this.cwC.requestLayout();
            }
            if (getItemLength() >= this.bNW) {
                akB();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(MetaData metaData) {
        Object tag;
        int childCount = this.cwC.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.cwC.getChildAt(i);
            if (childAt != this.cwF && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && metaData != null) {
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
        int childCount = this.cwC.getChildCount();
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.cwC.getChildAt(i);
            if (childAt != this.cwF && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && (name_show = ((MetaData) tag).getName_show()) != null) {
                arrayList.add(name_show);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(MetaData metaData) {
        View findViewWithTag = this.cwC.findViewWithTag(metaData);
        if (findViewWithTag != null) {
            this.cwC.removeView(findViewWithTag);
            if (!akC()) {
                akA();
            }
        }
    }

    private HeadImageView akE() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.Vr, this.cwD);
        layoutParams.setMargins(this.cwE, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getItemLength() {
        return akC() ? this.cwC.getChildCount() - 1 : this.cwC.getChildCount();
    }
}
