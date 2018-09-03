package com.baidu.tieba.write.write;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HorizontalCustomScrollView;
import com.baidu.tieba.f;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class AtSelectFriendList extends HorizontalCustomScrollView {
    private int aoc;
    private final View.OnClickListener caq;
    private int eEV;
    private int eEW;
    private HeadImageView eEX;
    private a hyg;
    private final Context mContext;
    private int mItemHeight;
    private LinearLayout mLayout;

    /* loaded from: classes3.dex */
    public interface a {
        void b(View view, Object obj);
    }

    public AtSelectFriendList(Context context) {
        super(context);
        this.aoc = -1;
        this.mItemHeight = -1;
        this.eEV = -1;
        this.eEW = 4;
        this.caq = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtSelectFriendList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtSelectFriendList.this.mLayout.removeView(view);
                if (!AtSelectFriendList.this.aOi()) {
                    AtSelectFriendList.this.aOg();
                }
                if (AtSelectFriendList.this.hyg != null) {
                    AtSelectFriendList.this.hyg.b(view, view.getTag());
                }
            }
        };
        this.mContext = context;
        AC();
    }

    public AtSelectFriendList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aoc = -1;
        this.mItemHeight = -1;
        this.eEV = -1;
        this.eEW = 4;
        this.caq = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtSelectFriendList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtSelectFriendList.this.mLayout.removeView(view);
                if (!AtSelectFriendList.this.aOi()) {
                    AtSelectFriendList.this.aOg();
                }
                if (AtSelectFriendList.this.hyg != null) {
                    AtSelectFriendList.this.hyg.b(view, view.getTag());
                }
            }
        };
        this.mContext = context;
        AC();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMaxCount(int i) {
        this.eEW = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setItemOPerationHandler(a aVar) {
        this.hyg = aVar;
    }

    private void AC() {
        this.aoc = this.mContext.getResources().getDimensionPixelSize(f.e.ds80);
        this.mItemHeight = this.mContext.getResources().getDimensionPixelSize(f.e.ds80);
        this.eEV = this.mContext.getResources().getDimensionPixelSize(f.e.ds12);
        this.mLayout = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.mLayout.setLayoutParams(layoutParams);
        this.mLayout.setHorizontalScrollBarEnabled(true);
        this.mLayout.setOrientation(0);
        aOg();
        addView(this.mLayout);
        setSmoothScrollingEnabled(true);
        setFocusable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOg() {
        if (this.eEX == null) {
            this.eEX = aOk();
            this.eEX.setDrawBorder(false);
        }
        this.eEX.setImageBitmap(am.cT(f.C0146f.icon_add_pop));
        this.mLayout.addView(this.eEX);
    }

    private void aOh() {
        if (aOi()) {
            this.mLayout.removeView(this.eEX);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aOi() {
        int childCount = this.mLayout.getChildCount();
        return childCount > 0 && this.mLayout.getChildAt(childCount + (-1)) == this.eEX;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(MetaData metaData) {
        if (getItemLength() < this.eEW) {
            HeadImageView aOk = aOk();
            aOk.setIsRound(false);
            aOk.startLoad(metaData.getPortrait(), 12, false);
            if (aOi()) {
                aOk.setTag(metaData);
                aOk.setOnClickListener(this.caq);
                this.mLayout.addView(aOk, getItemLength());
                scrollTo(getItemLength() * (this.aoc + this.eEV), 0);
                this.mLayout.requestLayout();
            }
            if (getItemLength() >= this.eEW) {
                aOh();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(MetaData metaData) {
        Object tag;
        int childCount = this.mLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mLayout.getChildAt(i);
            if (childAt != this.eEX && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && metaData != null) {
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
            if (childAt != this.eEX && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && (name_show = ((MetaData) tag).getName_show()) != null) {
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
            if (!aOi()) {
                aOg();
            }
        }
    }

    private HeadImageView aOk() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.aoc, this.mItemHeight);
        layoutParams.setMargins(this.eEV, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getItemLength() {
        return aOi() ? this.mLayout.getChildCount() - 1 : this.mLayout.getChildCount();
    }
}
