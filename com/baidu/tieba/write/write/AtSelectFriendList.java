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
    private int adM;
    private final View.OnClickListener bgU;
    private int cft;
    private int csD;
    private int dkf;
    private HeadImageView dkg;
    private a fOZ;
    private final Context mContext;
    private LinearLayout mLayout;

    /* loaded from: classes.dex */
    public interface a {
        void a(View view, Object obj);
    }

    public AtSelectFriendList(Context context) {
        super(context);
        this.adM = -1;
        this.cft = -1;
        this.dkf = -1;
        this.csD = 4;
        this.bgU = new o(this);
        this.mContext = context;
        wO();
    }

    public AtSelectFriendList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.adM = -1;
        this.cft = -1;
        this.dkf = -1;
        this.csD = 4;
        this.bgU = new o(this);
        this.mContext = context;
        wO();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMaxCount(int i) {
        this.csD = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setItemOPerationHandler(a aVar) {
        this.fOZ = aVar;
    }

    private void wO() {
        this.adM = this.mContext.getResources().getDimensionPixelSize(w.f.ds80);
        this.cft = this.mContext.getResources().getDimensionPixelSize(w.f.ds80);
        this.dkf = this.mContext.getResources().getDimensionPixelSize(w.f.ds12);
        this.mLayout = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.mLayout.setLayoutParams(layoutParams);
        this.mLayout.setHorizontalScrollBarEnabled(true);
        this.mLayout.setOrientation(0);
        auF();
        addView(this.mLayout);
        setSmoothScrollingEnabled(true);
        setFocusable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void auF() {
        if (this.dkg == null) {
            this.dkg = auJ();
            this.dkg.setDrawBorder(false);
        }
        this.dkg.setImageBitmap(com.baidu.tbadk.core.util.aq.cL(w.g.icon_add_pop));
        this.mLayout.addView(this.dkg);
    }

    private void auG() {
        if (auH()) {
            this.mLayout.removeView(this.dkg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean auH() {
        int childCount = this.mLayout.getChildCount();
        return childCount > 0 && this.mLayout.getChildAt(childCount + (-1)) == this.dkg;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(MetaData metaData) {
        if (getItemLength() < this.csD) {
            HeadImageView auJ = auJ();
            auJ.setIsRound(false);
            auJ.c(metaData.getPortrait(), 12, false);
            if (auH()) {
                auJ.setTag(metaData);
                auJ.setOnClickListener(this.bgU);
                this.mLayout.addView(auJ, getItemLength());
                scrollTo(getItemLength() * (this.adM + this.dkf), 0);
                this.mLayout.requestLayout();
            }
            if (getItemLength() >= this.csD) {
                auG();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(MetaData metaData) {
        Object tag;
        int childCount = this.mLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mLayout.getChildAt(i);
            if (childAt != this.dkg && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && metaData != null) {
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
            if (childAt != this.dkg && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && (name_show = ((MetaData) tag).getName_show()) != null) {
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
            if (!auH()) {
                auF();
            }
        }
    }

    private HeadImageView auJ() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.adM, this.cft);
        layoutParams.setMargins(this.dkf, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getItemLength() {
        return auH() ? this.mLayout.getChildCount() - 1 : this.mLayout.getChildCount();
    }
}
