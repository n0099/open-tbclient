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
    private int aeX;
    private final View.OnClickListener bER;
    private int dXm;
    private int dXn;
    private HeadImageView dXo;
    private a hhs;
    private final Context mContext;
    private int mItemHeight;
    private LinearLayout mLayout;

    /* loaded from: classes2.dex */
    public interface a {
        void b(View view, Object obj);
    }

    public AtSelectFriendList(Context context) {
        super(context);
        this.aeX = -1;
        this.mItemHeight = -1;
        this.dXm = -1;
        this.dXn = 4;
        this.bER = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtSelectFriendList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtSelectFriendList.this.mLayout.removeView(view);
                if (!AtSelectFriendList.this.aDV()) {
                    AtSelectFriendList.this.aDT();
                }
                if (AtSelectFriendList.this.hhs != null) {
                    AtSelectFriendList.this.hhs.b(view, view.getTag());
                }
            }
        };
        this.mContext = context;
        wD();
    }

    public AtSelectFriendList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aeX = -1;
        this.mItemHeight = -1;
        this.dXm = -1;
        this.dXn = 4;
        this.bER = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtSelectFriendList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtSelectFriendList.this.mLayout.removeView(view);
                if (!AtSelectFriendList.this.aDV()) {
                    AtSelectFriendList.this.aDT();
                }
                if (AtSelectFriendList.this.hhs != null) {
                    AtSelectFriendList.this.hhs.b(view, view.getTag());
                }
            }
        };
        this.mContext = context;
        wD();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMaxCount(int i) {
        this.dXn = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setItemOPerationHandler(a aVar) {
        this.hhs = aVar;
    }

    private void wD() {
        this.aeX = this.mContext.getResources().getDimensionPixelSize(d.e.ds80);
        this.mItemHeight = this.mContext.getResources().getDimensionPixelSize(d.e.ds80);
        this.dXm = this.mContext.getResources().getDimensionPixelSize(d.e.ds12);
        this.mLayout = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.mLayout.setLayoutParams(layoutParams);
        this.mLayout.setHorizontalScrollBarEnabled(true);
        this.mLayout.setOrientation(0);
        aDT();
        addView(this.mLayout);
        setSmoothScrollingEnabled(true);
        setFocusable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aDT() {
        if (this.dXo == null) {
            this.dXo = aDX();
            this.dXo.setDrawBorder(false);
        }
        this.dXo.setImageBitmap(aj.cR(d.f.icon_add_pop));
        this.mLayout.addView(this.dXo);
    }

    private void aDU() {
        if (aDV()) {
            this.mLayout.removeView(this.dXo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aDV() {
        int childCount = this.mLayout.getChildCount();
        return childCount > 0 && this.mLayout.getChildAt(childCount + (-1)) == this.dXo;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(MetaData metaData) {
        if (getItemLength() < this.dXn) {
            HeadImageView aDX = aDX();
            aDX.setIsRound(false);
            aDX.startLoad(metaData.getPortrait(), 12, false);
            if (aDV()) {
                aDX.setTag(metaData);
                aDX.setOnClickListener(this.bER);
                this.mLayout.addView(aDX, getItemLength());
                scrollTo(getItemLength() * (this.aeX + this.dXm), 0);
                this.mLayout.requestLayout();
            }
            if (getItemLength() >= this.dXn) {
                aDU();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(MetaData metaData) {
        Object tag;
        int childCount = this.mLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mLayout.getChildAt(i);
            if (childAt != this.dXo && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && metaData != null) {
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
            if (childAt != this.dXo && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && (name_show = ((MetaData) tag).getName_show()) != null) {
                arrayList.add(name_show);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(MetaData metaData) {
        View findViewWithTag = this.mLayout.findViewWithTag(metaData);
        if (findViewWithTag != null) {
            this.mLayout.removeView(findViewWithTag);
            if (!aDV()) {
                aDT();
            }
        }
    }

    private HeadImageView aDX() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.aeX, this.mItemHeight);
        layoutParams.setMargins(this.dXm, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getItemLength() {
        return aDV() ? this.mLayout.getChildCount() - 1 : this.mLayout.getChildCount();
    }
}
