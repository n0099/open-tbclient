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
    private int aeW;
    private final View.OnClickListener buo;
    private int cVt;
    private int dKI;
    private HeadImageView dKJ;
    private a gFI;
    private final Context mContext;
    private int mItemHeight;
    private LinearLayout mLayout;

    /* loaded from: classes2.dex */
    public interface a {
        void b(View view, Object obj);
    }

    public AtSelectFriendList(Context context) {
        super(context);
        this.aeW = -1;
        this.mItemHeight = -1;
        this.dKI = -1;
        this.cVt = 4;
        this.buo = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtSelectFriendList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtSelectFriendList.this.mLayout.removeView(view);
                if (!AtSelectFriendList.this.aBf()) {
                    AtSelectFriendList.this.aBd();
                }
                if (AtSelectFriendList.this.gFI != null) {
                    AtSelectFriendList.this.gFI.b(view, view.getTag());
                }
            }
        };
        this.mContext = context;
        xb();
    }

    public AtSelectFriendList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aeW = -1;
        this.mItemHeight = -1;
        this.dKI = -1;
        this.cVt = 4;
        this.buo = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtSelectFriendList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtSelectFriendList.this.mLayout.removeView(view);
                if (!AtSelectFriendList.this.aBf()) {
                    AtSelectFriendList.this.aBd();
                }
                if (AtSelectFriendList.this.gFI != null) {
                    AtSelectFriendList.this.gFI.b(view, view.getTag());
                }
            }
        };
        this.mContext = context;
        xb();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMaxCount(int i) {
        this.cVt = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setItemOPerationHandler(a aVar) {
        this.gFI = aVar;
    }

    private void xb() {
        this.aeW = this.mContext.getResources().getDimensionPixelSize(d.f.ds80);
        this.mItemHeight = this.mContext.getResources().getDimensionPixelSize(d.f.ds80);
        this.dKI = this.mContext.getResources().getDimensionPixelSize(d.f.ds12);
        this.mLayout = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.mLayout.setLayoutParams(layoutParams);
        this.mLayout.setHorizontalScrollBarEnabled(true);
        this.mLayout.setOrientation(0);
        aBd();
        addView(this.mLayout);
        setSmoothScrollingEnabled(true);
        setFocusable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBd() {
        if (this.dKJ == null) {
            this.dKJ = aBh();
            this.dKJ.setDrawBorder(false);
        }
        this.dKJ.setImageBitmap(aj.cT(d.g.icon_add_pop));
        this.mLayout.addView(this.dKJ);
    }

    private void aBe() {
        if (aBf()) {
            this.mLayout.removeView(this.dKJ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aBf() {
        int childCount = this.mLayout.getChildCount();
        return childCount > 0 && this.mLayout.getChildAt(childCount + (-1)) == this.dKJ;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(MetaData metaData) {
        if (getItemLength() < this.cVt) {
            HeadImageView aBh = aBh();
            aBh.setIsRound(false);
            aBh.c(metaData.getPortrait(), 12, false);
            if (aBf()) {
                aBh.setTag(metaData);
                aBh.setOnClickListener(this.buo);
                this.mLayout.addView(aBh, getItemLength());
                scrollTo(getItemLength() * (this.aeW + this.dKI), 0);
                this.mLayout.requestLayout();
            }
            if (getItemLength() >= this.cVt) {
                aBe();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(MetaData metaData) {
        Object tag;
        int childCount = this.mLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mLayout.getChildAt(i);
            if (childAt != this.dKJ && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && metaData != null) {
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
            if (childAt != this.dKJ && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && (name_show = ((MetaData) tag).getName_show()) != null) {
                arrayList.add(name_show);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(MetaData metaData) {
        View findViewWithTag = this.mLayout.findViewWithTag(metaData);
        if (findViewWithTag != null) {
            this.mLayout.removeView(findViewWithTag);
            if (!aBf()) {
                aBd();
            }
        }
    }

    private HeadImageView aBh() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.aeW, this.mItemHeight);
        layoutParams.setMargins(this.dKI, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getItemLength() {
        return aBf() ? this.mLayout.getChildCount() - 1 : this.mLayout.getChildCount();
    }
}
