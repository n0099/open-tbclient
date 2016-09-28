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
import com.baidu.tieba.r;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class AtSelectFriendList extends HorizontalCustomScrollView {
    private int Zr;
    private int aSp;
    private final View.OnClickListener bdP;
    private int drU;
    private int drV;
    private HeadImageView drW;
    private a gge;
    private final Context mContext;
    private LinearLayout mLayout;

    /* loaded from: classes.dex */
    public interface a {
        void a(View view, Object obj);
    }

    public AtSelectFriendList(Context context) {
        super(context);
        this.Zr = -1;
        this.drU = -1;
        this.drV = -1;
        this.aSp = 4;
        this.bdP = new o(this);
        this.mContext = context;
        initialize();
    }

    public AtSelectFriendList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Zr = -1;
        this.drU = -1;
        this.drV = -1;
        this.aSp = 4;
        this.bdP = new o(this);
        this.mContext = context;
        initialize();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMaxCount(int i) {
        this.aSp = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setItemOPerationHandler(a aVar) {
        this.gge = aVar;
    }

    private void initialize() {
        this.Zr = this.mContext.getResources().getDimensionPixelSize(r.e.ds80);
        this.drU = this.mContext.getResources().getDimensionPixelSize(r.e.ds80);
        this.drV = this.mContext.getResources().getDimensionPixelSize(r.e.ds12);
        this.mLayout = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.mLayout.setLayoutParams(layoutParams);
        this.mLayout.setHorizontalScrollBarEnabled(true);
        this.mLayout.setOrientation(0);
        ayL();
        addView(this.mLayout);
        setSmoothScrollingEnabled(true);
        setFocusable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayL() {
        if (this.drW == null) {
            this.drW = ayP();
            this.drW.setDrawBorder(false);
        }
        this.drW.setImageBitmap(com.baidu.tbadk.core.util.av.cN(r.f.icon_add_pop));
        this.mLayout.addView(this.drW);
    }

    private void ayM() {
        if (ayN()) {
            this.mLayout.removeView(this.drW);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ayN() {
        int childCount = this.mLayout.getChildCount();
        return childCount > 0 && this.mLayout.getChildAt(childCount + (-1)) == this.drW;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(MetaData metaData) {
        if (getItemLength() < this.aSp) {
            HeadImageView ayP = ayP();
            ayP.setIsRound(false);
            ayP.c(metaData.getPortrait(), 12, false);
            if (ayN()) {
                ayP.setTag(metaData);
                ayP.setOnClickListener(this.bdP);
                this.mLayout.addView(ayP, getItemLength());
                scrollTo(getItemLength() * (this.Zr + this.drV), 0);
                this.mLayout.requestLayout();
            }
            if (getItemLength() >= this.aSp) {
                ayM();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(MetaData metaData) {
        Object tag;
        int childCount = this.mLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mLayout.getChildAt(i);
            if (childAt != this.drW && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && metaData != null) {
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
            if (childAt != this.drW && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && (name_show = ((MetaData) tag).getName_show()) != null) {
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
            if (!ayN()) {
                ayL();
            }
        }
    }

    private HeadImageView ayP() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.Zr, this.drU);
        layoutParams.setMargins(this.drV, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getItemLength() {
        return ayN() ? this.mLayout.getChildCount() - 1 : this.mLayout.getChildCount();
    }
}
