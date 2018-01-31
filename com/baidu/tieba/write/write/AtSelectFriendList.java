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
    private int aTh;
    private final View.OnClickListener ctZ;
    private int eMt;
    private int eMu;
    private HeadImageView eMv;
    private a hIy;
    private final Context mContext;
    private int mItemHeight;
    private LinearLayout mLayout;

    /* loaded from: classes2.dex */
    public interface a {
        void b(View view, Object obj);
    }

    public AtSelectFriendList(Context context) {
        super(context);
        this.aTh = -1;
        this.mItemHeight = -1;
        this.eMt = -1;
        this.eMu = 4;
        this.ctZ = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtSelectFriendList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtSelectFriendList.this.mLayout.removeView(view);
                if (!AtSelectFriendList.this.aLp()) {
                    AtSelectFriendList.this.aLn();
                }
                if (AtSelectFriendList.this.hIy != null) {
                    AtSelectFriendList.this.hIy.b(view, view.getTag());
                }
            }
        };
        this.mContext = context;
        DS();
    }

    public AtSelectFriendList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aTh = -1;
        this.mItemHeight = -1;
        this.eMt = -1;
        this.eMu = 4;
        this.ctZ = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtSelectFriendList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtSelectFriendList.this.mLayout.removeView(view);
                if (!AtSelectFriendList.this.aLp()) {
                    AtSelectFriendList.this.aLn();
                }
                if (AtSelectFriendList.this.hIy != null) {
                    AtSelectFriendList.this.hIy.b(view, view.getTag());
                }
            }
        };
        this.mContext = context;
        DS();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMaxCount(int i) {
        this.eMu = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setItemOPerationHandler(a aVar) {
        this.hIy = aVar;
    }

    private void DS() {
        this.aTh = this.mContext.getResources().getDimensionPixelSize(d.e.ds80);
        this.mItemHeight = this.mContext.getResources().getDimensionPixelSize(d.e.ds80);
        this.eMt = this.mContext.getResources().getDimensionPixelSize(d.e.ds12);
        this.mLayout = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.mLayout.setLayoutParams(layoutParams);
        this.mLayout.setHorizontalScrollBarEnabled(true);
        this.mLayout.setOrientation(0);
        aLn();
        addView(this.mLayout);
        setSmoothScrollingEnabled(true);
        setFocusable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aLn() {
        if (this.eMv == null) {
            this.eMv = aLr();
            this.eMv.setDrawBorder(false);
        }
        this.eMv.setImageBitmap(aj.fO(d.f.icon_add_pop));
        this.mLayout.addView(this.eMv);
    }

    private void aLo() {
        if (aLp()) {
            this.mLayout.removeView(this.eMv);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aLp() {
        int childCount = this.mLayout.getChildCount();
        return childCount > 0 && this.mLayout.getChildAt(childCount + (-1)) == this.eMv;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(MetaData metaData) {
        if (getItemLength() < this.eMu) {
            HeadImageView aLr = aLr();
            aLr.setIsRound(false);
            aLr.startLoad(metaData.getPortrait(), 12, false);
            if (aLp()) {
                aLr.setTag(metaData);
                aLr.setOnClickListener(this.ctZ);
                this.mLayout.addView(aLr, getItemLength());
                scrollTo(getItemLength() * (this.aTh + this.eMt), 0);
                this.mLayout.requestLayout();
            }
            if (getItemLength() >= this.eMu) {
                aLo();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(MetaData metaData) {
        Object tag;
        int childCount = this.mLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mLayout.getChildAt(i);
            if (childAt != this.eMv && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && metaData != null) {
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
            if (childAt != this.eMv && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && (name_show = ((MetaData) tag).getName_show()) != null) {
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
            if (!aLp()) {
                aLn();
            }
        }
    }

    private HeadImageView aLr() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.aTh, this.mItemHeight);
        layoutParams.setMargins(this.eMt, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getItemLength() {
        return aLp() ? this.mLayout.getChildCount() - 1 : this.mLayout.getChildCount();
    }
}
