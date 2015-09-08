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
    private int YW;
    private final View.OnClickListener aLg;
    private LinearLayout bJL;
    private int bJM;
    private int bJN;
    private int bJO;
    private HeadImageView bJP;
    private a dcn;
    private final Context mContext;

    /* loaded from: classes.dex */
    public interface a {
        void a(View view, Object obj);
    }

    public AtSelectFriendList(Context context) {
        super(context);
        this.YW = -1;
        this.bJM = -1;
        this.bJN = -1;
        this.bJO = 4;
        this.aLg = new n(this);
        this.mContext = context;
        initialize();
    }

    public AtSelectFriendList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.YW = -1;
        this.bJM = -1;
        this.bJN = -1;
        this.bJO = 4;
        this.aLg = new n(this);
        this.mContext = context;
        initialize();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMaxCount(int i) {
        this.bJO = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setItemOPerationHandler(a aVar) {
        this.dcn = aVar;
    }

    private void initialize() {
        this.YW = this.mContext.getResources().getDimensionPixelSize(i.d.invite_friend_candidate_item_width);
        this.bJM = this.mContext.getResources().getDimensionPixelSize(i.d.invite_friend_candidate_item_height);
        this.bJN = this.mContext.getResources().getDimensionPixelSize(i.d.invite_friend_candidate_item_margin);
        this.bJL = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.bJL.setLayoutParams(layoutParams);
        this.bJL.setHorizontalScrollBarEnabled(true);
        this.bJL.setOrientation(0);
        YA();
        addView(this.bJL);
        setSmoothScrollingEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void YA() {
        if (this.bJP == null) {
            this.bJP = YE();
            this.bJP.setDrawBorder(false);
        }
        this.bJP.setImageBitmap(com.baidu.tbadk.core.util.al.cu(i.e.icon_add_pop));
        this.bJL.addView(this.bJP);
    }

    private void YB() {
        if (YC()) {
            this.bJL.removeView(this.bJP);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean YC() {
        int childCount = this.bJL.getChildCount();
        return childCount > 0 && this.bJL.getChildAt(childCount + (-1)) == this.bJP;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(MetaData metaData) {
        if (getItemLength() < this.bJO) {
            HeadImageView YE = YE();
            YE.setIsRound(false);
            YE.d(metaData.getPortrait(), 12, false);
            if (YC()) {
                YE.setTag(metaData);
                YE.setOnClickListener(this.aLg);
                this.bJL.addView(YE, getItemLength());
                scrollTo(getItemLength() * (this.YW + this.bJN), 0);
                this.bJL.requestLayout();
            }
            if (getItemLength() >= this.bJO) {
                YB();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(MetaData metaData) {
        Object tag;
        int childCount = this.bJL.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bJL.getChildAt(i);
            if (childAt != this.bJP && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && metaData != null) {
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
        int childCount = this.bJL.getChildCount();
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bJL.getChildAt(i);
            if (childAt != this.bJP && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && (name_show = ((MetaData) tag).getName_show()) != null) {
                arrayList.add(name_show);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(MetaData metaData) {
        View findViewWithTag = this.bJL.findViewWithTag(metaData);
        if (findViewWithTag != null) {
            this.bJL.removeView(findViewWithTag);
            if (!YC()) {
                YA();
            }
        }
    }

    private HeadImageView YE() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.YW, this.bJM);
        layoutParams.setMargins(this.bJN, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getItemLength() {
        return YC() ? this.bJL.getChildCount() - 1 : this.bJL.getChildCount();
    }
}
