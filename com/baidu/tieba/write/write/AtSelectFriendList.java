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
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class AtSelectFriendList extends com.baidu.tbadk.core.view.d {
    private int aUM;
    private final View.OnClickListener cyh;
    private int eQC;
    private int eQD;
    private HeadImageView eQE;
    private a hJV;
    private final Context mContext;
    private int mItemHeight;
    private LinearLayout mLayout;

    /* loaded from: classes2.dex */
    public interface a {
        void b(View view, Object obj);
    }

    public AtSelectFriendList(Context context) {
        super(context);
        this.aUM = -1;
        this.mItemHeight = -1;
        this.eQC = -1;
        this.eQD = 4;
        this.cyh = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtSelectFriendList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtSelectFriendList.this.mLayout.removeView(view);
                if (!AtSelectFriendList.this.aMR()) {
                    AtSelectFriendList.this.aMP();
                }
                if (AtSelectFriendList.this.hJV != null) {
                    AtSelectFriendList.this.hJV.b(view, view.getTag());
                }
            }
        };
        this.mContext = context;
        Em();
    }

    public AtSelectFriendList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aUM = -1;
        this.mItemHeight = -1;
        this.eQC = -1;
        this.eQD = 4;
        this.cyh = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtSelectFriendList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtSelectFriendList.this.mLayout.removeView(view);
                if (!AtSelectFriendList.this.aMR()) {
                    AtSelectFriendList.this.aMP();
                }
                if (AtSelectFriendList.this.hJV != null) {
                    AtSelectFriendList.this.hJV.b(view, view.getTag());
                }
            }
        };
        this.mContext = context;
        Em();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMaxCount(int i) {
        this.eQD = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setItemOPerationHandler(a aVar) {
        this.hJV = aVar;
    }

    private void Em() {
        this.aUM = this.mContext.getResources().getDimensionPixelSize(d.e.ds80);
        this.mItemHeight = this.mContext.getResources().getDimensionPixelSize(d.e.ds80);
        this.eQC = this.mContext.getResources().getDimensionPixelSize(d.e.ds12);
        this.mLayout = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.mLayout.setLayoutParams(layoutParams);
        this.mLayout.setHorizontalScrollBarEnabled(true);
        this.mLayout.setOrientation(0);
        aMP();
        addView(this.mLayout);
        setSmoothScrollingEnabled(true);
        setFocusable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aMP() {
        if (this.eQE == null) {
            this.eQE = aMT();
            this.eQE.setDrawBorder(false);
        }
        this.eQE.setImageBitmap(aj.fO(d.f.icon_add_pop));
        this.mLayout.addView(this.eQE);
    }

    private void aMQ() {
        if (aMR()) {
            this.mLayout.removeView(this.eQE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aMR() {
        int childCount = this.mLayout.getChildCount();
        return childCount > 0 && this.mLayout.getChildAt(childCount + (-1)) == this.eQE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(MetaData metaData) {
        if (getItemLength() < this.eQD) {
            HeadImageView aMT = aMT();
            aMT.setIsRound(false);
            aMT.startLoad(metaData.getPortrait(), 12, false);
            if (aMR()) {
                aMT.setTag(metaData);
                aMT.setOnClickListener(this.cyh);
                this.mLayout.addView(aMT, getItemLength());
                scrollTo(getItemLength() * (this.aUM + this.eQC), 0);
                this.mLayout.requestLayout();
            }
            if (getItemLength() >= this.eQD) {
                aMQ();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(MetaData metaData) {
        Object tag;
        int childCount = this.mLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mLayout.getChildAt(i);
            if (childAt != this.eQE && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && metaData != null) {
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
            if (childAt != this.eQE && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && (name_show = ((MetaData) tag).getName_show()) != null) {
                arrayList.add(name_show);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(MetaData metaData) {
        View findViewWithTag = this.mLayout.findViewWithTag(metaData);
        if (findViewWithTag != null) {
            this.mLayout.removeView(findViewWithTag);
            if (!aMR()) {
                aMP();
            }
        }
    }

    private HeadImageView aMT() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.aUM, this.mItemHeight);
        layoutParams.setMargins(this.eQC, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getItemLength() {
        return aMR() ? this.mLayout.getChildCount() - 1 : this.mLayout.getChildCount();
    }
}
