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
    private int Zj;
    private int aTH;
    private int bRt;
    private final View.OnClickListener bgh;
    private int daA;
    private HeadImageView daB;
    private a fCl;
    private final Context mContext;
    private LinearLayout mLayout;

    /* loaded from: classes.dex */
    public interface a {
        void a(View view, Object obj);
    }

    public AtSelectFriendList(Context context) {
        super(context);
        this.Zj = -1;
        this.bRt = -1;
        this.daA = -1;
        this.aTH = 4;
        this.bgh = new o(this);
        this.mContext = context;
        ww();
    }

    public AtSelectFriendList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Zj = -1;
        this.bRt = -1;
        this.daA = -1;
        this.aTH = 4;
        this.bgh = new o(this);
        this.mContext = context;
        ww();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMaxCount(int i) {
        this.aTH = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setItemOPerationHandler(a aVar) {
        this.fCl = aVar;
    }

    private void ww() {
        this.Zj = this.mContext.getResources().getDimensionPixelSize(r.e.ds80);
        this.bRt = this.mContext.getResources().getDimensionPixelSize(r.e.ds80);
        this.daA = this.mContext.getResources().getDimensionPixelSize(r.e.ds12);
        this.mLayout = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.mLayout.setLayoutParams(layoutParams);
        this.mLayout.setHorizontalScrollBarEnabled(true);
        this.mLayout.setOrientation(0);
        aue();
        addView(this.mLayout);
        setSmoothScrollingEnabled(true);
        setFocusable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aue() {
        if (this.daB == null) {
            this.daB = aui();
            this.daB.setDrawBorder(false);
        }
        this.daB.setImageBitmap(com.baidu.tbadk.core.util.ar.cQ(r.f.icon_add_pop));
        this.mLayout.addView(this.daB);
    }

    private void auf() {
        if (aug()) {
            this.mLayout.removeView(this.daB);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aug() {
        int childCount = this.mLayout.getChildCount();
        return childCount > 0 && this.mLayout.getChildAt(childCount + (-1)) == this.daB;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(MetaData metaData) {
        if (getItemLength() < this.aTH) {
            HeadImageView aui = aui();
            aui.setIsRound(false);
            aui.c(metaData.getPortrait(), 12, false);
            if (aug()) {
                aui.setTag(metaData);
                aui.setOnClickListener(this.bgh);
                this.mLayout.addView(aui, getItemLength());
                scrollTo(getItemLength() * (this.Zj + this.daA), 0);
                this.mLayout.requestLayout();
            }
            if (getItemLength() >= this.aTH) {
                auf();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(MetaData metaData) {
        Object tag;
        int childCount = this.mLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mLayout.getChildAt(i);
            if (childAt != this.daB && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && metaData != null) {
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
            if (childAt != this.daB && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && (name_show = ((MetaData) tag).getName_show()) != null) {
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
            if (!aug()) {
                aue();
            }
        }
    }

    private HeadImageView aui() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.Zj, this.bRt);
        layoutParams.setMargins(this.daA, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getItemLength() {
        return aug() ? this.mLayout.getChildCount() - 1 : this.mLayout.getChildCount();
    }
}
