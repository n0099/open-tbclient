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
    private int YN;
    private final View.OnClickListener aKT;
    private LinearLayout bJe;
    private int bJf;
    private int bJg;
    private int bJh;
    private HeadImageView bJi;
    private a cTq;
    private final Context mContext;

    /* loaded from: classes.dex */
    public interface a {
        void a(View view, Object obj);
    }

    public AtSelectFriendList(Context context) {
        super(context);
        this.YN = -1;
        this.bJf = -1;
        this.bJg = -1;
        this.bJh = 4;
        this.aKT = new n(this);
        this.mContext = context;
        initialize();
    }

    public AtSelectFriendList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.YN = -1;
        this.bJf = -1;
        this.bJg = -1;
        this.bJh = 4;
        this.aKT = new n(this);
        this.mContext = context;
        initialize();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMaxCount(int i) {
        this.bJh = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setItemOPerationHandler(a aVar) {
        this.cTq = aVar;
    }

    private void initialize() {
        this.YN = this.mContext.getResources().getDimensionPixelSize(i.d.invite_friend_candidate_item_width);
        this.bJf = this.mContext.getResources().getDimensionPixelSize(i.d.invite_friend_candidate_item_height);
        this.bJg = this.mContext.getResources().getDimensionPixelSize(i.d.invite_friend_candidate_item_margin);
        this.bJe = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.bJe.setLayoutParams(layoutParams);
        this.bJe.setHorizontalScrollBarEnabled(true);
        this.bJe.setOrientation(0);
        Yy();
        addView(this.bJe);
        setSmoothScrollingEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Yy() {
        if (this.bJi == null) {
            this.bJi = YC();
            this.bJi.setDrawBorder(false);
        }
        this.bJi.setImageBitmap(com.baidu.tbadk.core.util.al.cq(i.e.icon_add_pop));
        this.bJe.addView(this.bJi);
    }

    private void Yz() {
        if (YA()) {
            this.bJe.removeView(this.bJi);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean YA() {
        int childCount = this.bJe.getChildCount();
        return childCount > 0 && this.bJe.getChildAt(childCount + (-1)) == this.bJi;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(MetaData metaData) {
        if (getItemLength() < this.bJh) {
            HeadImageView YC = YC();
            YC.setIsRound(false);
            YC.d(metaData.getPortrait(), 12, false);
            if (YA()) {
                YC.setTag(metaData);
                YC.setOnClickListener(this.aKT);
                this.bJe.addView(YC, getItemLength());
                scrollTo(getItemLength() * (this.YN + this.bJg), 0);
                this.bJe.requestLayout();
            }
            if (getItemLength() >= this.bJh) {
                Yz();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(MetaData metaData) {
        Object tag;
        int childCount = this.bJe.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bJe.getChildAt(i);
            if (childAt != this.bJi && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && metaData != null) {
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
        int childCount = this.bJe.getChildCount();
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bJe.getChildAt(i);
            if (childAt != this.bJi && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && (name_show = ((MetaData) tag).getName_show()) != null) {
                arrayList.add(name_show);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(MetaData metaData) {
        View findViewWithTag = this.bJe.findViewWithTag(metaData);
        if (findViewWithTag != null) {
            this.bJe.removeView(findViewWithTag);
            if (!YA()) {
                Yy();
            }
        }
    }

    private HeadImageView YC() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.YN, this.bJf);
        layoutParams.setMargins(this.bJg, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getItemLength() {
        return YA() ? this.bJe.getChildCount() - 1 : this.bJe.getChildCount();
    }
}
