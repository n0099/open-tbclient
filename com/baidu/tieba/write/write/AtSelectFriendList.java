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
    private int adl;
    private final View.OnClickListener bkC;
    private int cju;
    private int cwN;
    private int dks;
    private HeadImageView dkt;
    private a fZf;
    private final Context mContext;
    private LinearLayout mLayout;

    /* loaded from: classes.dex */
    public interface a {
        void b(View view, Object obj);
    }

    public AtSelectFriendList(Context context) {
        super(context);
        this.adl = -1;
        this.cju = -1;
        this.dks = -1;
        this.cwN = 4;
        this.bkC = new o(this);
        this.mContext = context;
        wr();
    }

    public AtSelectFriendList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.adl = -1;
        this.cju = -1;
        this.dks = -1;
        this.cwN = 4;
        this.bkC = new o(this);
        this.mContext = context;
        wr();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMaxCount(int i) {
        this.cwN = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setItemOPerationHandler(a aVar) {
        this.fZf = aVar;
    }

    private void wr() {
        this.adl = this.mContext.getResources().getDimensionPixelSize(w.f.ds80);
        this.cju = this.mContext.getResources().getDimensionPixelSize(w.f.ds80);
        this.dks = this.mContext.getResources().getDimensionPixelSize(w.f.ds12);
        this.mLayout = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.mLayout.setLayoutParams(layoutParams);
        this.mLayout.setHorizontalScrollBarEnabled(true);
        this.mLayout.setOrientation(0);
        atq();
        addView(this.mLayout);
        setSmoothScrollingEnabled(true);
        setFocusable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void atq() {
        if (this.dkt == null) {
            this.dkt = atu();
            this.dkt.setDrawBorder(false);
        }
        this.dkt.setImageBitmap(com.baidu.tbadk.core.util.aq.cM(w.g.icon_add_pop));
        this.mLayout.addView(this.dkt);
    }

    private void atr() {
        if (ats()) {
            this.mLayout.removeView(this.dkt);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ats() {
        int childCount = this.mLayout.getChildCount();
        return childCount > 0 && this.mLayout.getChildAt(childCount + (-1)) == this.dkt;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(MetaData metaData) {
        if (getItemLength() < this.cwN) {
            HeadImageView atu = atu();
            atu.setIsRound(false);
            atu.c(metaData.getPortrait(), 12, false);
            if (ats()) {
                atu.setTag(metaData);
                atu.setOnClickListener(this.bkC);
                this.mLayout.addView(atu, getItemLength());
                scrollTo(getItemLength() * (this.adl + this.dks), 0);
                this.mLayout.requestLayout();
            }
            if (getItemLength() >= this.cwN) {
                atr();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(MetaData metaData) {
        Object tag;
        int childCount = this.mLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mLayout.getChildAt(i);
            if (childAt != this.dkt && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && metaData != null) {
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
            if (childAt != this.dkt && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && (name_show = ((MetaData) tag).getName_show()) != null) {
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
            if (!ats()) {
                atq();
            }
        }
    }

    private HeadImageView atu() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.adl, this.cju);
        layoutParams.setMargins(this.dks, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getItemLength() {
        return ats() ? this.mLayout.getChildCount() - 1 : this.mLayout.getChildCount();
    }
}
