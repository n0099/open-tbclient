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
    private int aea;
    private final View.OnClickListener bgO;
    private int cdT;
    private int crd;
    private int diE;
    private HeadImageView diF;
    private a fQJ;
    private final Context mContext;
    private LinearLayout mLayout;

    /* loaded from: classes.dex */
    public interface a {
        void a(View view, Object obj);
    }

    public AtSelectFriendList(Context context) {
        super(context);
        this.aea = -1;
        this.cdT = -1;
        this.diE = -1;
        this.crd = 4;
        this.bgO = new o(this);
        this.mContext = context;
        xk();
    }

    public AtSelectFriendList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aea = -1;
        this.cdT = -1;
        this.diE = -1;
        this.crd = 4;
        this.bgO = new o(this);
        this.mContext = context;
        xk();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMaxCount(int i) {
        this.crd = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setItemOPerationHandler(a aVar) {
        this.fQJ = aVar;
    }

    private void xk() {
        this.aea = this.mContext.getResources().getDimensionPixelSize(w.f.ds80);
        this.cdT = this.mContext.getResources().getDimensionPixelSize(w.f.ds80);
        this.diE = this.mContext.getResources().getDimensionPixelSize(w.f.ds12);
        this.mLayout = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.mLayout.setLayoutParams(layoutParams);
        this.mLayout.setHorizontalScrollBarEnabled(true);
        this.mLayout.setOrientation(0);
        auy();
        addView(this.mLayout);
        setSmoothScrollingEnabled(true);
        setFocusable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void auy() {
        if (this.diF == null) {
            this.diF = auC();
            this.diF.setDrawBorder(false);
        }
        this.diF.setImageBitmap(com.baidu.tbadk.core.util.aq.cO(w.g.icon_add_pop));
        this.mLayout.addView(this.diF);
    }

    private void auz() {
        if (auA()) {
            this.mLayout.removeView(this.diF);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean auA() {
        int childCount = this.mLayout.getChildCount();
        return childCount > 0 && this.mLayout.getChildAt(childCount + (-1)) == this.diF;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(MetaData metaData) {
        if (getItemLength() < this.crd) {
            HeadImageView auC = auC();
            auC.setIsRound(false);
            auC.c(metaData.getPortrait(), 12, false);
            if (auA()) {
                auC.setTag(metaData);
                auC.setOnClickListener(this.bgO);
                this.mLayout.addView(auC, getItemLength());
                scrollTo(getItemLength() * (this.aea + this.diE), 0);
                this.mLayout.requestLayout();
            }
            if (getItemLength() >= this.crd) {
                auz();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(MetaData metaData) {
        Object tag;
        int childCount = this.mLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mLayout.getChildAt(i);
            if (childAt != this.diF && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && metaData != null) {
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
            if (childAt != this.diF && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && (name_show = ((MetaData) tag).getName_show()) != null) {
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
            if (!auA()) {
                auy();
            }
        }
    }

    private HeadImageView auC() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.aea, this.cdT);
        layoutParams.setMargins(this.diE, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getItemLength() {
        return auA() ? this.mLayout.getChildCount() - 1 : this.mLayout.getChildCount();
    }
}
