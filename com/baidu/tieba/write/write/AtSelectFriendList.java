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
    private int adt;
    private final View.OnClickListener bjv;
    private int cdg;
    private int cqs;
    private int deY;
    private HeadImageView deZ;
    private a fRj;
    private final Context mContext;
    private LinearLayout mLayout;

    /* loaded from: classes.dex */
    public interface a {
        void a(View view, Object obj);
    }

    public AtSelectFriendList(Context context) {
        super(context);
        this.adt = -1;
        this.cdg = -1;
        this.deY = -1;
        this.cqs = 4;
        this.bjv = new o(this);
        this.mContext = context;
        wv();
    }

    public AtSelectFriendList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.adt = -1;
        this.cdg = -1;
        this.deY = -1;
        this.cqs = 4;
        this.bjv = new o(this);
        this.mContext = context;
        wv();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMaxCount(int i) {
        this.cqs = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setItemOPerationHandler(a aVar) {
        this.fRj = aVar;
    }

    private void wv() {
        this.adt = this.mContext.getResources().getDimensionPixelSize(w.f.ds80);
        this.cdg = this.mContext.getResources().getDimensionPixelSize(w.f.ds80);
        this.deY = this.mContext.getResources().getDimensionPixelSize(w.f.ds12);
        this.mLayout = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.mLayout.setLayoutParams(layoutParams);
        this.mLayout.setHorizontalScrollBarEnabled(true);
        this.mLayout.setOrientation(0);
        asu();
        addView(this.mLayout);
        setSmoothScrollingEnabled(true);
        setFocusable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void asu() {
        if (this.deZ == null) {
            this.deZ = asy();
            this.deZ.setDrawBorder(false);
        }
        this.deZ.setImageBitmap(com.baidu.tbadk.core.util.aq.cL(w.g.icon_add_pop));
        this.mLayout.addView(this.deZ);
    }

    private void asv() {
        if (asw()) {
            this.mLayout.removeView(this.deZ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean asw() {
        int childCount = this.mLayout.getChildCount();
        return childCount > 0 && this.mLayout.getChildAt(childCount + (-1)) == this.deZ;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(MetaData metaData) {
        if (getItemLength() < this.cqs) {
            HeadImageView asy = asy();
            asy.setIsRound(false);
            asy.c(metaData.getPortrait(), 12, false);
            if (asw()) {
                asy.setTag(metaData);
                asy.setOnClickListener(this.bjv);
                this.mLayout.addView(asy, getItemLength());
                scrollTo(getItemLength() * (this.adt + this.deY), 0);
                this.mLayout.requestLayout();
            }
            if (getItemLength() >= this.cqs) {
                asv();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(MetaData metaData) {
        Object tag;
        int childCount = this.mLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mLayout.getChildAt(i);
            if (childAt != this.deZ && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && metaData != null) {
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
            if (childAt != this.deZ && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && (name_show = ((MetaData) tag).getName_show()) != null) {
                arrayList.add(name_show);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(MetaData metaData) {
        View findViewWithTag = this.mLayout.findViewWithTag(metaData);
        if (findViewWithTag != null) {
            this.mLayout.removeView(findViewWithTag);
            if (!asw()) {
                asu();
            }
        }
    }

    private HeadImageView asy() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.adt, this.cdg);
        layoutParams.setMargins(this.deY, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getItemLength() {
        return asw() ? this.mLayout.getChildCount() - 1 : this.mLayout.getChildCount();
    }
}
