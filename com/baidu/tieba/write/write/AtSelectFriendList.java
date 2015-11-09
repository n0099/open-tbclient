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
import com.baidu.tieba.i;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class AtSelectFriendList extends HorizontalCustomScrollView {
    private int YV;
    private final View.OnClickListener aJd;
    private HeadImageView bNA;
    private LinearLayout bNw;
    private int bNx;
    private int bNy;
    private int bNz;
    private a dqt;
    private final Context mContext;

    /* loaded from: classes.dex */
    public interface a {
        void a(View view, Object obj);
    }

    public AtSelectFriendList(Context context) {
        super(context);
        this.YV = -1;
        this.bNx = -1;
        this.bNy = -1;
        this.bNz = 4;
        this.aJd = new n(this);
        this.mContext = context;
        initialize();
    }

    public AtSelectFriendList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.YV = -1;
        this.bNx = -1;
        this.bNy = -1;
        this.bNz = 4;
        this.aJd = new n(this);
        this.mContext = context;
        initialize();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMaxCount(int i) {
        this.bNz = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setItemOPerationHandler(a aVar) {
        this.dqt = aVar;
    }

    private void initialize() {
        this.YV = this.mContext.getResources().getDimensionPixelSize(i.d.invite_friend_candidate_item_width);
        this.bNx = this.mContext.getResources().getDimensionPixelSize(i.d.invite_friend_candidate_item_height);
        this.bNy = this.mContext.getResources().getDimensionPixelSize(i.d.invite_friend_candidate_item_margin);
        this.bNw = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.bNw.setLayoutParams(layoutParams);
        this.bNw.setHorizontalScrollBarEnabled(true);
        this.bNw.setOrientation(0);
        Zz();
        addView(this.bNw);
        setSmoothScrollingEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Zz() {
        if (this.bNA == null) {
            this.bNA = ZD();
            this.bNA.setDrawBorder(false);
        }
        this.bNA.setImageBitmap(com.baidu.tbadk.core.util.an.cw(i.e.icon_add_pop));
        this.bNw.addView(this.bNA);
    }

    private void ZA() {
        if (ZB()) {
            this.bNw.removeView(this.bNA);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ZB() {
        int childCount = this.bNw.getChildCount();
        return childCount > 0 && this.bNw.getChildAt(childCount + (-1)) == this.bNA;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(MetaData metaData) {
        if (getItemLength() < this.bNz) {
            HeadImageView ZD = ZD();
            ZD.setIsRound(false);
            ZD.d(metaData.getPortrait(), 12, false);
            if (ZB()) {
                ZD.setTag(metaData);
                ZD.setOnClickListener(this.aJd);
                this.bNw.addView(ZD, getItemLength());
                scrollTo(getItemLength() * (this.YV + this.bNy), 0);
                this.bNw.requestLayout();
            }
            if (getItemLength() >= this.bNz) {
                ZA();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(MetaData metaData) {
        Object tag;
        int childCount = this.bNw.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bNw.getChildAt(i);
            if (childAt != this.bNA && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && metaData != null) {
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
        int childCount = this.bNw.getChildCount();
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bNw.getChildAt(i);
            if (childAt != this.bNA && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && (name_show = ((MetaData) tag).getName_show()) != null) {
                arrayList.add(name_show);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(MetaData metaData) {
        View findViewWithTag = this.bNw.findViewWithTag(metaData);
        if (findViewWithTag != null) {
            this.bNw.removeView(findViewWithTag);
            if (!ZB()) {
                Zz();
            }
        }
    }

    private HeadImageView ZD() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.YV, this.bNx);
        layoutParams.setMargins(this.bNy, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getItemLength() {
        return ZB() ? this.bNw.getChildCount() - 1 : this.bNw.getChildCount();
    }
}
