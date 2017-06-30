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
import com.baidu.tieba.w;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class AtSelectFriendList extends HorizontalCustomScrollView {
    private int adU;
    private int bVr;
    private final View.OnClickListener boh;
    private int cEA;
    private int dso;
    private HeadImageView dsp;
    private a gke;
    private final Context mContext;
    private LinearLayout mLayout;

    /* loaded from: classes.dex */
    public interface a {
        void b(View view, Object obj);
    }

    public AtSelectFriendList(Context context) {
        super(context);
        this.adU = -1;
        this.bVr = -1;
        this.dso = -1;
        this.cEA = 4;
        this.boh = new o(this);
        this.mContext = context;
        wJ();
    }

    public AtSelectFriendList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.adU = -1;
        this.bVr = -1;
        this.dso = -1;
        this.cEA = 4;
        this.boh = new o(this);
        this.mContext = context;
        wJ();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMaxCount(int i) {
        this.cEA = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setItemOPerationHandler(a aVar) {
        this.gke = aVar;
    }

    private void wJ() {
        this.adU = this.mContext.getResources().getDimensionPixelSize(w.f.ds80);
        this.bVr = this.mContext.getResources().getDimensionPixelSize(w.f.ds80);
        this.dso = this.mContext.getResources().getDimensionPixelSize(w.f.ds12);
        this.mLayout = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.mLayout.setLayoutParams(layoutParams);
        this.mLayout.setHorizontalScrollBarEnabled(true);
        this.mLayout.setOrientation(0);
        awY();
        addView(this.mLayout);
        setSmoothScrollingEnabled(true);
        setFocusable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awY() {
        if (this.dsp == null) {
            this.dsp = axc();
            this.dsp.setDrawBorder(false);
        }
        this.dsp.setImageBitmap(com.baidu.tbadk.core.util.as.cO(w.g.icon_add_pop));
        this.mLayout.addView(this.dsp);
    }

    private void awZ() {
        if (axa()) {
            this.mLayout.removeView(this.dsp);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean axa() {
        int childCount = this.mLayout.getChildCount();
        return childCount > 0 && this.mLayout.getChildAt(childCount + (-1)) == this.dsp;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(MetaData metaData) {
        if (getItemLength() < this.cEA) {
            HeadImageView axc = axc();
            axc.setIsRound(false);
            axc.c(metaData.getPortrait(), 12, false);
            if (axa()) {
                axc.setTag(metaData);
                axc.setOnClickListener(this.boh);
                this.mLayout.addView(axc, getItemLength());
                scrollTo(getItemLength() * (this.adU + this.dso), 0);
                this.mLayout.requestLayout();
            }
            if (getItemLength() >= this.cEA) {
                awZ();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(MetaData metaData) {
        Object tag;
        int childCount = this.mLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mLayout.getChildAt(i);
            if (childAt != this.dsp && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && metaData != null) {
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
            if (childAt != this.dsp && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && (name_show = ((MetaData) tag).getName_show()) != null) {
                arrayList.add(name_show);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(MetaData metaData) {
        View findViewWithTag = this.mLayout.findViewWithTag(metaData);
        if (findViewWithTag != null) {
            this.mLayout.removeView(findViewWithTag);
            if (!axa()) {
                awY();
            }
        }
    }

    private HeadImageView axc() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.adU, this.bVr);
        layoutParams.setMargins(this.dso, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getItemLength() {
        return axa() ? this.mLayout.getChildCount() - 1 : this.mLayout.getChildCount();
    }
}
