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
import com.baidu.tieba.u;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class AtSelectFriendList extends HorizontalCustomScrollView {
    private int Wq;
    private int aLN;
    private final View.OnClickListener aXC;
    private int deQ;
    private int deR;
    private HeadImageView deS;
    private a fTQ;
    private final Context mContext;
    private LinearLayout mLayout;

    /* loaded from: classes.dex */
    public interface a {
        void a(View view, Object obj);
    }

    public AtSelectFriendList(Context context) {
        super(context);
        this.Wq = -1;
        this.deQ = -1;
        this.deR = -1;
        this.aLN = 4;
        this.aXC = new o(this);
        this.mContext = context;
        initialize();
    }

    public AtSelectFriendList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Wq = -1;
        this.deQ = -1;
        this.deR = -1;
        this.aLN = 4;
        this.aXC = new o(this);
        this.mContext = context;
        initialize();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMaxCount(int i) {
        this.aLN = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setItemOPerationHandler(a aVar) {
        this.fTQ = aVar;
    }

    private void initialize() {
        this.Wq = this.mContext.getResources().getDimensionPixelSize(u.e.ds80);
        this.deQ = this.mContext.getResources().getDimensionPixelSize(u.e.ds80);
        this.deR = this.mContext.getResources().getDimensionPixelSize(u.e.ds12);
        this.mLayout = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.mLayout.setLayoutParams(layoutParams);
        this.mLayout.setHorizontalScrollBarEnabled(true);
        this.mLayout.setOrientation(0);
        atz();
        addView(this.mLayout);
        setSmoothScrollingEnabled(true);
        setFocusable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void atz() {
        if (this.deS == null) {
            this.deS = atD();
            this.deS.setDrawBorder(false);
        }
        this.deS.setImageBitmap(com.baidu.tbadk.core.util.av.cA(u.f.icon_add_pop));
        this.mLayout.addView(this.deS);
    }

    private void atA() {
        if (atB()) {
            this.mLayout.removeView(this.deS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean atB() {
        int childCount = this.mLayout.getChildCount();
        return childCount > 0 && this.mLayout.getChildAt(childCount + (-1)) == this.deS;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(MetaData metaData) {
        if (getItemLength() < this.aLN) {
            HeadImageView atD = atD();
            atD.setIsRound(false);
            atD.c(metaData.getPortrait(), 12, false);
            if (atB()) {
                atD.setTag(metaData);
                atD.setOnClickListener(this.aXC);
                this.mLayout.addView(atD, getItemLength());
                scrollTo(getItemLength() * (this.Wq + this.deR), 0);
                this.mLayout.requestLayout();
            }
            if (getItemLength() >= this.aLN) {
                atA();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(MetaData metaData) {
        Object tag;
        int childCount = this.mLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mLayout.getChildAt(i);
            if (childAt != this.deS && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && metaData != null) {
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
        int childCount = this.mLayout.getChildCount();
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mLayout.getChildAt(i);
            if (childAt != this.deS && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && (name_show = ((MetaData) tag).getName_show()) != null) {
                arrayList.add(name_show);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(MetaData metaData) {
        View findViewWithTag = this.mLayout.findViewWithTag(metaData);
        if (findViewWithTag != null) {
            this.mLayout.removeView(findViewWithTag);
            if (!atB()) {
                atz();
            }
        }
    }

    private HeadImageView atD() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.Wq, this.deQ);
        layoutParams.setMargins(this.deR, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getItemLength() {
        return atB() ? this.mLayout.getChildCount() - 1 : this.mLayout.getChildCount();
    }
}
