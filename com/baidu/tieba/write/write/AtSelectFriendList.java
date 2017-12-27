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
    private int aTf;
    private final View.OnClickListener ctG;
    private HeadImageView eKA;
    private int eKy;
    private int eKz;
    private a hSv;
    private final Context mContext;
    private int mItemHeight;
    private LinearLayout mLayout;

    /* loaded from: classes2.dex */
    public interface a {
        void b(View view, Object obj);
    }

    public AtSelectFriendList(Context context) {
        super(context);
        this.aTf = -1;
        this.mItemHeight = -1;
        this.eKy = -1;
        this.eKz = 4;
        this.ctG = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtSelectFriendList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtSelectFriendList.this.mLayout.removeView(view);
                if (!AtSelectFriendList.this.aLf()) {
                    AtSelectFriendList.this.aLd();
                }
                if (AtSelectFriendList.this.hSv != null) {
                    AtSelectFriendList.this.hSv.b(view, view.getTag());
                }
            }
        };
        this.mContext = context;
        DZ();
    }

    public AtSelectFriendList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aTf = -1;
        this.mItemHeight = -1;
        this.eKy = -1;
        this.eKz = 4;
        this.ctG = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtSelectFriendList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtSelectFriendList.this.mLayout.removeView(view);
                if (!AtSelectFriendList.this.aLf()) {
                    AtSelectFriendList.this.aLd();
                }
                if (AtSelectFriendList.this.hSv != null) {
                    AtSelectFriendList.this.hSv.b(view, view.getTag());
                }
            }
        };
        this.mContext = context;
        DZ();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMaxCount(int i) {
        this.eKz = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setItemOPerationHandler(a aVar) {
        this.hSv = aVar;
    }

    private void DZ() {
        this.aTf = this.mContext.getResources().getDimensionPixelSize(d.e.ds80);
        this.mItemHeight = this.mContext.getResources().getDimensionPixelSize(d.e.ds80);
        this.eKy = this.mContext.getResources().getDimensionPixelSize(d.e.ds12);
        this.mLayout = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.mLayout.setLayoutParams(layoutParams);
        this.mLayout.setHorizontalScrollBarEnabled(true);
        this.mLayout.setOrientation(0);
        aLd();
        addView(this.mLayout);
        setSmoothScrollingEnabled(true);
        setFocusable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aLd() {
        if (this.eKA == null) {
            this.eKA = aLh();
            this.eKA.setDrawBorder(false);
        }
        this.eKA.setImageBitmap(aj.fQ(d.f.icon_add_pop));
        this.mLayout.addView(this.eKA);
    }

    private void aLe() {
        if (aLf()) {
            this.mLayout.removeView(this.eKA);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aLf() {
        int childCount = this.mLayout.getChildCount();
        return childCount > 0 && this.mLayout.getChildAt(childCount + (-1)) == this.eKA;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(MetaData metaData) {
        if (getItemLength() < this.eKz) {
            HeadImageView aLh = aLh();
            aLh.setIsRound(false);
            aLh.startLoad(metaData.getPortrait(), 12, false);
            if (aLf()) {
                aLh.setTag(metaData);
                aLh.setOnClickListener(this.ctG);
                this.mLayout.addView(aLh, getItemLength());
                scrollTo(getItemLength() * (this.aTf + this.eKy), 0);
                this.mLayout.requestLayout();
            }
            if (getItemLength() >= this.eKz) {
                aLe();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(MetaData metaData) {
        Object tag;
        int childCount = this.mLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mLayout.getChildAt(i);
            if (childAt != this.eKA && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && metaData != null) {
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
            if (childAt != this.eKA && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && (name_show = ((MetaData) tag).getName_show()) != null) {
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
            if (!aLf()) {
                aLd();
            }
        }
    }

    private HeadImageView aLh() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.aTf, this.mItemHeight);
        layoutParams.setMargins(this.eKy, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getItemLength() {
        return aLf() ? this.mLayout.getChildCount() - 1 : this.mLayout.getChildCount();
    }
}
