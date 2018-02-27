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
    private int aUA;
    private final View.OnClickListener cxV;
    private int eQq;
    private int eQr;
    private HeadImageView eQs;
    private a hJI;
    private final Context mContext;
    private int mItemHeight;
    private LinearLayout mLayout;

    /* loaded from: classes2.dex */
    public interface a {
        void b(View view, Object obj);
    }

    public AtSelectFriendList(Context context) {
        super(context);
        this.aUA = -1;
        this.mItemHeight = -1;
        this.eQq = -1;
        this.eQr = 4;
        this.cxV = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtSelectFriendList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtSelectFriendList.this.mLayout.removeView(view);
                if (!AtSelectFriendList.this.aMQ()) {
                    AtSelectFriendList.this.aMO();
                }
                if (AtSelectFriendList.this.hJI != null) {
                    AtSelectFriendList.this.hJI.b(view, view.getTag());
                }
            }
        };
        this.mContext = context;
        El();
    }

    public AtSelectFriendList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aUA = -1;
        this.mItemHeight = -1;
        this.eQq = -1;
        this.eQr = 4;
        this.cxV = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtSelectFriendList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtSelectFriendList.this.mLayout.removeView(view);
                if (!AtSelectFriendList.this.aMQ()) {
                    AtSelectFriendList.this.aMO();
                }
                if (AtSelectFriendList.this.hJI != null) {
                    AtSelectFriendList.this.hJI.b(view, view.getTag());
                }
            }
        };
        this.mContext = context;
        El();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMaxCount(int i) {
        this.eQr = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setItemOPerationHandler(a aVar) {
        this.hJI = aVar;
    }

    private void El() {
        this.aUA = this.mContext.getResources().getDimensionPixelSize(d.e.ds80);
        this.mItemHeight = this.mContext.getResources().getDimensionPixelSize(d.e.ds80);
        this.eQq = this.mContext.getResources().getDimensionPixelSize(d.e.ds12);
        this.mLayout = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.mLayout.setLayoutParams(layoutParams);
        this.mLayout.setHorizontalScrollBarEnabled(true);
        this.mLayout.setOrientation(0);
        aMO();
        addView(this.mLayout);
        setSmoothScrollingEnabled(true);
        setFocusable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aMO() {
        if (this.eQs == null) {
            this.eQs = aMS();
            this.eQs.setDrawBorder(false);
        }
        this.eQs.setImageBitmap(aj.fO(d.f.icon_add_pop));
        this.mLayout.addView(this.eQs);
    }

    private void aMP() {
        if (aMQ()) {
            this.mLayout.removeView(this.eQs);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aMQ() {
        int childCount = this.mLayout.getChildCount();
        return childCount > 0 && this.mLayout.getChildAt(childCount + (-1)) == this.eQs;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(MetaData metaData) {
        if (getItemLength() < this.eQr) {
            HeadImageView aMS = aMS();
            aMS.setIsRound(false);
            aMS.startLoad(metaData.getPortrait(), 12, false);
            if (aMQ()) {
                aMS.setTag(metaData);
                aMS.setOnClickListener(this.cxV);
                this.mLayout.addView(aMS, getItemLength());
                scrollTo(getItemLength() * (this.aUA + this.eQq), 0);
                this.mLayout.requestLayout();
            }
            if (getItemLength() >= this.eQr) {
                aMP();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(MetaData metaData) {
        Object tag;
        int childCount = this.mLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mLayout.getChildAt(i);
            if (childAt != this.eQs && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && metaData != null) {
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
            if (childAt != this.eQs && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && (name_show = ((MetaData) tag).getName_show()) != null) {
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
            if (!aMQ()) {
                aMO();
            }
        }
    }

    private HeadImageView aMS() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.aUA, this.mItemHeight);
        layoutParams.setMargins(this.eQq, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getItemLength() {
        return aMQ() ? this.mLayout.getChildCount() - 1 : this.mLayout.getChildCount();
    }
}
