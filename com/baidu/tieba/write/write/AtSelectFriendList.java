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
    private int Yx;
    private int bXX;
    private final View.OnClickListener baj;
    private int cre;
    private int dhN;
    private HeadImageView dhO;
    private a fKG;
    private final Context mContext;
    private LinearLayout mLayout;

    /* loaded from: classes.dex */
    public interface a {
        void a(View view, Object obj);
    }

    public AtSelectFriendList(Context context) {
        super(context);
        this.Yx = -1;
        this.bXX = -1;
        this.dhN = -1;
        this.cre = 4;
        this.baj = new o(this);
        this.mContext = context;
        wr();
    }

    public AtSelectFriendList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Yx = -1;
        this.bXX = -1;
        this.dhN = -1;
        this.cre = 4;
        this.baj = new o(this);
        this.mContext = context;
        wr();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMaxCount(int i) {
        this.cre = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setItemOPerationHandler(a aVar) {
        this.fKG = aVar;
    }

    private void wr() {
        this.Yx = this.mContext.getResources().getDimensionPixelSize(r.f.ds80);
        this.bXX = this.mContext.getResources().getDimensionPixelSize(r.f.ds80);
        this.dhN = this.mContext.getResources().getDimensionPixelSize(r.f.ds12);
        this.mLayout = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.mLayout.setLayoutParams(layoutParams);
        this.mLayout.setHorizontalScrollBarEnabled(true);
        this.mLayout.setOrientation(0);
        avk();
        addView(this.mLayout);
        setSmoothScrollingEnabled(true);
        setFocusable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void avk() {
        if (this.dhO == null) {
            this.dhO = avo();
            this.dhO.setDrawBorder(false);
        }
        this.dhO.setImageBitmap(com.baidu.tbadk.core.util.ap.cP(r.g.icon_add_pop));
        this.mLayout.addView(this.dhO);
    }

    private void avl() {
        if (avm()) {
            this.mLayout.removeView(this.dhO);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean avm() {
        int childCount = this.mLayout.getChildCount();
        return childCount > 0 && this.mLayout.getChildAt(childCount + (-1)) == this.dhO;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(MetaData metaData) {
        if (getItemLength() < this.cre) {
            HeadImageView avo = avo();
            avo.setIsRound(false);
            avo.c(metaData.getPortrait(), 12, false);
            if (avm()) {
                avo.setTag(metaData);
                avo.setOnClickListener(this.baj);
                this.mLayout.addView(avo, getItemLength());
                scrollTo(getItemLength() * (this.Yx + this.dhN), 0);
                this.mLayout.requestLayout();
            }
            if (getItemLength() >= this.cre) {
                avl();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(MetaData metaData) {
        Object tag;
        int childCount = this.mLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mLayout.getChildAt(i);
            if (childAt != this.dhO && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && metaData != null) {
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
            if (childAt != this.dhO && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && (name_show = ((MetaData) tag).getName_show()) != null) {
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
            if (!avm()) {
                avk();
            }
        }
    }

    private HeadImageView avo() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.Yx, this.bXX);
        layoutParams.setMargins(this.dhN, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getItemLength() {
        return avm() ? this.mLayout.getChildCount() - 1 : this.mLayout.getChildCount();
    }
}
