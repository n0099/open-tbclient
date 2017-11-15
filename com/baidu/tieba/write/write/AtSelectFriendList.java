package com.baidu.tieba.write.write;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HorizontalCustomScrollView;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class AtSelectFriendList extends HorizontalCustomScrollView {
    private int aeC;
    private final View.OnClickListener byr;
    private int dPx;
    private int dPy;
    private HeadImageView dPz;
    private a gWr;
    private final Context mContext;
    private int mItemHeight;
    private LinearLayout mLayout;

    /* loaded from: classes2.dex */
    public interface a {
        void b(View view, Object obj);
    }

    public AtSelectFriendList(Context context) {
        super(context);
        this.aeC = -1;
        this.mItemHeight = -1;
        this.dPx = -1;
        this.dPy = 4;
        this.byr = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtSelectFriendList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtSelectFriendList.this.mLayout.removeView(view);
                if (!AtSelectFriendList.this.aCv()) {
                    AtSelectFriendList.this.aCt();
                }
                if (AtSelectFriendList.this.gWr != null) {
                    AtSelectFriendList.this.gWr.b(view, view.getTag());
                }
            }
        };
        this.mContext = context;
        wA();
    }

    public AtSelectFriendList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aeC = -1;
        this.mItemHeight = -1;
        this.dPx = -1;
        this.dPy = 4;
        this.byr = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtSelectFriendList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtSelectFriendList.this.mLayout.removeView(view);
                if (!AtSelectFriendList.this.aCv()) {
                    AtSelectFriendList.this.aCt();
                }
                if (AtSelectFriendList.this.gWr != null) {
                    AtSelectFriendList.this.gWr.b(view, view.getTag());
                }
            }
        };
        this.mContext = context;
        wA();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMaxCount(int i) {
        this.dPy = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setItemOPerationHandler(a aVar) {
        this.gWr = aVar;
    }

    private void wA() {
        this.aeC = this.mContext.getResources().getDimensionPixelSize(d.e.ds80);
        this.mItemHeight = this.mContext.getResources().getDimensionPixelSize(d.e.ds80);
        this.dPx = this.mContext.getResources().getDimensionPixelSize(d.e.ds12);
        this.mLayout = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.mLayout.setLayoutParams(layoutParams);
        this.mLayout.setHorizontalScrollBarEnabled(true);
        this.mLayout.setOrientation(0);
        aCt();
        addView(this.mLayout);
        setSmoothScrollingEnabled(true);
        setFocusable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aCt() {
        if (this.dPz == null) {
            this.dPz = aCx();
            this.dPz.setDrawBorder(false);
        }
        this.dPz.setImageBitmap(aj.cQ(d.f.icon_add_pop));
        this.mLayout.addView(this.dPz);
    }

    private void aCu() {
        if (aCv()) {
            this.mLayout.removeView(this.dPz);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aCv() {
        int childCount = this.mLayout.getChildCount();
        return childCount > 0 && this.mLayout.getChildAt(childCount + (-1)) == this.dPz;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(MetaData metaData) {
        if (getItemLength() < this.dPy) {
            HeadImageView aCx = aCx();
            aCx.setIsRound(false);
            aCx.startLoad(metaData.getPortrait(), 12, false);
            if (aCv()) {
                aCx.setTag(metaData);
                aCx.setOnClickListener(this.byr);
                this.mLayout.addView(aCx, getItemLength());
                scrollTo(getItemLength() * (this.aeC + this.dPx), 0);
                this.mLayout.requestLayout();
            }
            if (getItemLength() >= this.dPy) {
                aCu();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(MetaData metaData) {
        Object tag;
        int childCount = this.mLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mLayout.getChildAt(i);
            if (childAt != this.dPz && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && metaData != null) {
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
            if (childAt != this.dPz && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && (name_show = ((MetaData) tag).getName_show()) != null) {
                arrayList.add(name_show);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(MetaData metaData) {
        View findViewWithTag = this.mLayout.findViewWithTag(metaData);
        if (findViewWithTag != null) {
            this.mLayout.removeView(findViewWithTag);
            if (!aCv()) {
                aCt();
            }
        }
    }

    private HeadImageView aCx() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.aeC, this.mItemHeight);
        layoutParams.setMargins(this.dPx, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getItemLength() {
        return aCv() ? this.mLayout.getChildCount() - 1 : this.mLayout.getChildCount();
    }
}
