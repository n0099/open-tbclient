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
    private int aeh;
    private final View.OnClickListener bwB;
    private int dHE;
    private int dHF;
    private HeadImageView dHG;
    private a gLh;
    private final Context mContext;
    private int mItemHeight;
    private LinearLayout mLayout;

    /* loaded from: classes2.dex */
    public interface a {
        void b(View view, Object obj);
    }

    public AtSelectFriendList(Context context) {
        super(context);
        this.aeh = -1;
        this.mItemHeight = -1;
        this.dHE = -1;
        this.dHF = 4;
        this.bwB = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtSelectFriendList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtSelectFriendList.this.mLayout.removeView(view);
                if (!AtSelectFriendList.this.azW()) {
                    AtSelectFriendList.this.azU();
                }
                if (AtSelectFriendList.this.gLh != null) {
                    AtSelectFriendList.this.gLh.b(view, view.getTag());
                }
            }
        };
        this.mContext = context;
        wt();
    }

    public AtSelectFriendList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aeh = -1;
        this.mItemHeight = -1;
        this.dHE = -1;
        this.dHF = 4;
        this.bwB = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtSelectFriendList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtSelectFriendList.this.mLayout.removeView(view);
                if (!AtSelectFriendList.this.azW()) {
                    AtSelectFriendList.this.azU();
                }
                if (AtSelectFriendList.this.gLh != null) {
                    AtSelectFriendList.this.gLh.b(view, view.getTag());
                }
            }
        };
        this.mContext = context;
        wt();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMaxCount(int i) {
        this.dHF = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setItemOPerationHandler(a aVar) {
        this.gLh = aVar;
    }

    private void wt() {
        this.aeh = this.mContext.getResources().getDimensionPixelSize(d.f.ds80);
        this.mItemHeight = this.mContext.getResources().getDimensionPixelSize(d.f.ds80);
        this.dHE = this.mContext.getResources().getDimensionPixelSize(d.f.ds12);
        this.mLayout = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.mLayout.setLayoutParams(layoutParams);
        this.mLayout.setHorizontalScrollBarEnabled(true);
        this.mLayout.setOrientation(0);
        azU();
        addView(this.mLayout);
        setSmoothScrollingEnabled(true);
        setFocusable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azU() {
        if (this.dHG == null) {
            this.dHG = azY();
            this.dHG.setDrawBorder(false);
        }
        this.dHG.setImageBitmap(aj.cQ(d.g.icon_add_pop));
        this.mLayout.addView(this.dHG);
    }

    private void azV() {
        if (azW()) {
            this.mLayout.removeView(this.dHG);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean azW() {
        int childCount = this.mLayout.getChildCount();
        return childCount > 0 && this.mLayout.getChildAt(childCount + (-1)) == this.dHG;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(MetaData metaData) {
        if (getItemLength() < this.dHF) {
            HeadImageView azY = azY();
            azY.setIsRound(false);
            azY.c(metaData.getPortrait(), 12, false);
            if (azW()) {
                azY.setTag(metaData);
                azY.setOnClickListener(this.bwB);
                this.mLayout.addView(azY, getItemLength());
                scrollTo(getItemLength() * (this.aeh + this.dHE), 0);
                this.mLayout.requestLayout();
            }
            if (getItemLength() >= this.dHF) {
                azV();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(MetaData metaData) {
        Object tag;
        int childCount = this.mLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mLayout.getChildAt(i);
            if (childAt != this.dHG && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && metaData != null) {
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
            if (childAt != this.dHG && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && (name_show = ((MetaData) tag).getName_show()) != null) {
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
            if (!azW()) {
                azU();
            }
        }
    }

    private HeadImageView azY() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.aeh, this.mItemHeight);
        layoutParams.setMargins(this.dHE, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getItemLength() {
        return azW() ? this.mLayout.getChildCount() - 1 : this.mLayout.getChildCount();
    }
}
