package com.baidu.tieba.write.write;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HorizontalCustomScrollView;
import com.baidu.tieba.e;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class AtSelectFriendList extends HorizontalCustomScrollView {
    private int aqI;
    private final View.OnClickListener cgg;
    private int eMl;
    private int eMm;
    private HeadImageView eMn;
    private a hGD;
    private final Context mContext;
    private int mItemHeight;
    private LinearLayout mLayout;

    /* loaded from: classes3.dex */
    public interface a {
        void b(View view, Object obj);
    }

    public AtSelectFriendList(Context context) {
        super(context);
        this.aqI = -1;
        this.mItemHeight = -1;
        this.eMl = -1;
        this.eMm = 4;
        this.cgg = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtSelectFriendList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtSelectFriendList.this.mLayout.removeView(view);
                if (!AtSelectFriendList.this.aQx()) {
                    AtSelectFriendList.this.aQv();
                }
                if (AtSelectFriendList.this.hGD != null) {
                    AtSelectFriendList.this.hGD.b(view, view.getTag());
                }
            }
        };
        this.mContext = context;
        BP();
    }

    public AtSelectFriendList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aqI = -1;
        this.mItemHeight = -1;
        this.eMl = -1;
        this.eMm = 4;
        this.cgg = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtSelectFriendList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtSelectFriendList.this.mLayout.removeView(view);
                if (!AtSelectFriendList.this.aQx()) {
                    AtSelectFriendList.this.aQv();
                }
                if (AtSelectFriendList.this.hGD != null) {
                    AtSelectFriendList.this.hGD.b(view, view.getTag());
                }
            }
        };
        this.mContext = context;
        BP();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMaxCount(int i) {
        this.eMm = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setItemOPerationHandler(a aVar) {
        this.hGD = aVar;
    }

    private void BP() {
        this.aqI = this.mContext.getResources().getDimensionPixelSize(e.C0141e.ds80);
        this.mItemHeight = this.mContext.getResources().getDimensionPixelSize(e.C0141e.ds80);
        this.eMl = this.mContext.getResources().getDimensionPixelSize(e.C0141e.ds12);
        this.mLayout = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.mLayout.setLayoutParams(layoutParams);
        this.mLayout.setHorizontalScrollBarEnabled(true);
        this.mLayout.setOrientation(0);
        aQv();
        addView(this.mLayout);
        setSmoothScrollingEnabled(true);
        setFocusable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQv() {
        if (this.eMn == null) {
            this.eMn = aQz();
            this.eMn.setDrawBorder(false);
        }
        this.eMn.setImageBitmap(al.dc(e.f.icon_add_pop));
        this.mLayout.addView(this.eMn);
    }

    private void aQw() {
        if (aQx()) {
            this.mLayout.removeView(this.eMn);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aQx() {
        int childCount = this.mLayout.getChildCount();
        return childCount > 0 && this.mLayout.getChildAt(childCount + (-1)) == this.eMn;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(MetaData metaData) {
        if (getItemLength() < this.eMm) {
            HeadImageView aQz = aQz();
            aQz.setIsRound(false);
            aQz.startLoad(metaData.getPortrait(), 12, false);
            if (aQx()) {
                aQz.setTag(metaData);
                aQz.setOnClickListener(this.cgg);
                this.mLayout.addView(aQz, getItemLength());
                scrollTo(getItemLength() * (this.aqI + this.eMl), 0);
                this.mLayout.requestLayout();
            }
            if (getItemLength() >= this.eMm) {
                aQw();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(MetaData metaData) {
        Object tag;
        int childCount = this.mLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mLayout.getChildAt(i);
            if (childAt != this.eMn && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && metaData != null) {
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
            if (childAt != this.eMn && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && (name_show = ((MetaData) tag).getName_show()) != null) {
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
            if (!aQx()) {
                aQv();
            }
        }
    }

    private HeadImageView aQz() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.aqI, this.mItemHeight);
        layoutParams.setMargins(this.eMl, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getItemLength() {
        return aQx() ? this.mLayout.getChildCount() - 1 : this.mLayout.getChildCount();
    }
}
