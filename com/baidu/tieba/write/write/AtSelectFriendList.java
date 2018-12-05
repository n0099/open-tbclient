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
    private int azM;
    private final View.OnClickListener csN;
    private int fcb;
    private int fcc;
    private HeadImageView fcd;
    private a hWK;
    private final Context mContext;
    private int mItemHeight;
    private LinearLayout mLayout;

    /* loaded from: classes3.dex */
    public interface a {
        void b(View view, Object obj);
    }

    public AtSelectFriendList(Context context) {
        super(context);
        this.azM = -1;
        this.mItemHeight = -1;
        this.fcb = -1;
        this.fcc = 4;
        this.csN = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtSelectFriendList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtSelectFriendList.this.mLayout.removeView(view);
                if (!AtSelectFriendList.this.aVa()) {
                    AtSelectFriendList.this.aUY();
                }
                if (AtSelectFriendList.this.hWK != null) {
                    AtSelectFriendList.this.hWK.b(view, view.getTag());
                }
            }
        };
        this.mContext = context;
        initialize();
    }

    public AtSelectFriendList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.azM = -1;
        this.mItemHeight = -1;
        this.fcb = -1;
        this.fcc = 4;
        this.csN = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtSelectFriendList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtSelectFriendList.this.mLayout.removeView(view);
                if (!AtSelectFriendList.this.aVa()) {
                    AtSelectFriendList.this.aUY();
                }
                if (AtSelectFriendList.this.hWK != null) {
                    AtSelectFriendList.this.hWK.b(view, view.getTag());
                }
            }
        };
        this.mContext = context;
        initialize();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMaxCount(int i) {
        this.fcc = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setItemOPerationHandler(a aVar) {
        this.hWK = aVar;
    }

    private void initialize() {
        this.azM = this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds80);
        this.mItemHeight = this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds80);
        this.fcb = this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds12);
        this.mLayout = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.mLayout.setLayoutParams(layoutParams);
        this.mLayout.setHorizontalScrollBarEnabled(true);
        this.mLayout.setOrientation(0);
        aUY();
        addView(this.mLayout);
        setSmoothScrollingEnabled(true);
        setFocusable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aUY() {
        if (this.fcd == null) {
            this.fcd = aVc();
            this.fcd.setDrawBorder(false);
        }
        this.fcd.setImageBitmap(al.dO(e.f.icon_add_pop));
        this.mLayout.addView(this.fcd);
    }

    private void aUZ() {
        if (aVa()) {
            this.mLayout.removeView(this.fcd);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aVa() {
        int childCount = this.mLayout.getChildCount();
        return childCount > 0 && this.mLayout.getChildAt(childCount + (-1)) == this.fcd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(MetaData metaData) {
        if (getItemLength() < this.fcc) {
            HeadImageView aVc = aVc();
            aVc.setIsRound(false);
            aVc.startLoad(metaData.getPortrait(), 12, false);
            if (aVa()) {
                aVc.setTag(metaData);
                aVc.setOnClickListener(this.csN);
                this.mLayout.addView(aVc, getItemLength());
                scrollTo(getItemLength() * (this.azM + this.fcb), 0);
                this.mLayout.requestLayout();
            }
            if (getItemLength() >= this.fcc) {
                aUZ();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(MetaData metaData) {
        Object tag;
        int childCount = this.mLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mLayout.getChildAt(i);
            if (childAt != this.fcd && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && metaData != null) {
                MetaData metaData2 = (MetaData) tag;
                if ((metaData2.getUserName() != null && metaData2.getUserName().equals(metaData.getUserName())) || (metaData2.getName_show() != null && metaData2.getName_show().equals(metaData.getName_show()))) {
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
            if (childAt != this.fcd && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && (name_show = ((MetaData) tag).getName_show()) != null) {
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
            if (!aVa()) {
                aUY();
            }
        }
    }

    private HeadImageView aVc() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.azM, this.mItemHeight);
        layoutParams.setMargins(this.fcb, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getItemLength() {
        return aVa() ? this.mLayout.getChildCount() - 1 : this.mLayout.getChildCount();
    }
}
