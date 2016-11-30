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
    private int ZP;
    private int aUq;
    private final View.OnClickListener bgP;
    private int cmj;
    private int dxB;
    private HeadImageView dxC;
    private a gnI;
    private final Context mContext;
    private LinearLayout mLayout;

    /* loaded from: classes.dex */
    public interface a {
        void a(View view, Object obj);
    }

    public AtSelectFriendList(Context context) {
        super(context);
        this.ZP = -1;
        this.cmj = -1;
        this.dxB = -1;
        this.aUq = 4;
        this.bgP = new o(this);
        this.mContext = context;
        initialize();
    }

    public AtSelectFriendList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ZP = -1;
        this.cmj = -1;
        this.dxB = -1;
        this.aUq = 4;
        this.bgP = new o(this);
        this.mContext = context;
        initialize();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMaxCount(int i) {
        this.aUq = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setItemOPerationHandler(a aVar) {
        this.gnI = aVar;
    }

    private void initialize() {
        this.ZP = this.mContext.getResources().getDimensionPixelSize(r.e.ds80);
        this.cmj = this.mContext.getResources().getDimensionPixelSize(r.e.ds80);
        this.dxB = this.mContext.getResources().getDimensionPixelSize(r.e.ds12);
        this.mLayout = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.mLayout.setLayoutParams(layoutParams);
        this.mLayout.setHorizontalScrollBarEnabled(true);
        this.mLayout.setOrientation(0);
        aAI();
        addView(this.mLayout);
        setSmoothScrollingEnabled(true);
        setFocusable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAI() {
        if (this.dxC == null) {
            this.dxC = aAM();
            this.dxC.setDrawBorder(false);
        }
        this.dxC.setImageBitmap(com.baidu.tbadk.core.util.at.cO(r.f.icon_add_pop));
        this.mLayout.addView(this.dxC);
    }

    private void aAJ() {
        if (aAK()) {
            this.mLayout.removeView(this.dxC);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aAK() {
        int childCount = this.mLayout.getChildCount();
        return childCount > 0 && this.mLayout.getChildAt(childCount + (-1)) == this.dxC;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(MetaData metaData) {
        if (getItemLength() < this.aUq) {
            HeadImageView aAM = aAM();
            aAM.setIsRound(false);
            aAM.c(metaData.getPortrait(), 12, false);
            if (aAK()) {
                aAM.setTag(metaData);
                aAM.setOnClickListener(this.bgP);
                this.mLayout.addView(aAM, getItemLength());
                scrollTo(getItemLength() * (this.ZP + this.dxB), 0);
                this.mLayout.requestLayout();
            }
            if (getItemLength() >= this.aUq) {
                aAJ();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(MetaData metaData) {
        Object tag;
        int childCount = this.mLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mLayout.getChildAt(i);
            if (childAt != this.dxC && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && metaData != null) {
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
            if (childAt != this.dxC && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && (name_show = ((MetaData) tag).getName_show()) != null) {
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
            if (!aAK()) {
                aAI();
            }
        }
    }

    private HeadImageView aAM() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.ZP, this.cmj);
        layoutParams.setMargins(this.dxB, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getItemLength() {
        return aAK() ? this.mLayout.getChildCount() - 1 : this.mLayout.getChildCount();
    }
}
