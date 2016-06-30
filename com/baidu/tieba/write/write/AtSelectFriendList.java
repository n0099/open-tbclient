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
    private int VH;
    private int aKU;
    private final View.OnClickListener aWE;
    private int dbS;
    private int dbT;
    private HeadImageView dbU;
    private a fHZ;
    private final Context mContext;
    private LinearLayout mLayout;

    /* loaded from: classes.dex */
    public interface a {
        void a(View view, Object obj);
    }

    public AtSelectFriendList(Context context) {
        super(context);
        this.VH = -1;
        this.dbS = -1;
        this.dbT = -1;
        this.aKU = 4;
        this.aWE = new o(this);
        this.mContext = context;
        initialize();
    }

    public AtSelectFriendList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.VH = -1;
        this.dbS = -1;
        this.dbT = -1;
        this.aKU = 4;
        this.aWE = new o(this);
        this.mContext = context;
        initialize();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMaxCount(int i) {
        this.aKU = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setItemOPerationHandler(a aVar) {
        this.fHZ = aVar;
    }

    private void initialize() {
        this.VH = this.mContext.getResources().getDimensionPixelSize(u.e.ds80);
        this.dbS = this.mContext.getResources().getDimensionPixelSize(u.e.ds80);
        this.dbT = this.mContext.getResources().getDimensionPixelSize(u.e.ds12);
        this.mLayout = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.mLayout.setLayoutParams(layoutParams);
        this.mLayout.setHorizontalScrollBarEnabled(true);
        this.mLayout.setOrientation(0);
        asN();
        addView(this.mLayout);
        setSmoothScrollingEnabled(true);
        setFocusable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void asN() {
        if (this.dbU == null) {
            this.dbU = asR();
            this.dbU.setDrawBorder(false);
        }
        this.dbU.setImageBitmap(com.baidu.tbadk.core.util.av.cA(u.f.icon_add_pop));
        this.mLayout.addView(this.dbU);
    }

    private void asO() {
        if (asP()) {
            this.mLayout.removeView(this.dbU);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean asP() {
        int childCount = this.mLayout.getChildCount();
        return childCount > 0 && this.mLayout.getChildAt(childCount + (-1)) == this.dbU;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(MetaData metaData) {
        if (getItemLength() < this.aKU) {
            HeadImageView asR = asR();
            asR.setIsRound(false);
            asR.c(metaData.getPortrait(), 12, false);
            if (asP()) {
                asR.setTag(metaData);
                asR.setOnClickListener(this.aWE);
                this.mLayout.addView(asR, getItemLength());
                scrollTo(getItemLength() * (this.VH + this.dbT), 0);
                this.mLayout.requestLayout();
            }
            if (getItemLength() >= this.aKU) {
                asO();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(MetaData metaData) {
        Object tag;
        int childCount = this.mLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mLayout.getChildAt(i);
            if (childAt != this.dbU && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && metaData != null) {
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
            if (childAt != this.dbU && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && (name_show = ((MetaData) tag).getName_show()) != null) {
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
            if (!asP()) {
                asN();
            }
        }
    }

    private HeadImageView asR() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.VH, this.dbS);
        layoutParams.setMargins(this.dbT, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getItemLength() {
        return asP() ? this.mLayout.getChildCount() - 1 : this.mLayout.getChildCount();
    }
}
