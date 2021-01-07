package com.baidu.tieba.write.write;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HorizontalCustomScrollView;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class AtSelectFriendList extends HorizontalCustomScrollView {
    private final View.OnClickListener aHh;
    private int dmK;
    private LinearLayout kLr;
    private int kLs;
    private HeadImageView kLt;
    private final Context mContext;
    private int mItemWidth;
    private int mMaxCount;
    private a odn;

    /* loaded from: classes8.dex */
    public interface a {
        void b(View view, Object obj);
    }

    public AtSelectFriendList(Context context) {
        super(context);
        this.mItemWidth = -1;
        this.dmK = -1;
        this.kLs = -1;
        this.mMaxCount = 4;
        this.aHh = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtSelectFriendList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtSelectFriendList.this.kLr.removeView(view);
                if (!AtSelectFriendList.this.dau()) {
                    AtSelectFriendList.this.das();
                }
                if (AtSelectFriendList.this.odn != null) {
                    AtSelectFriendList.this.odn.b(view, view.getTag());
                }
            }
        };
        this.mContext = context;
        initialize();
    }

    public AtSelectFriendList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mItemWidth = -1;
        this.dmK = -1;
        this.kLs = -1;
        this.mMaxCount = 4;
        this.aHh = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtSelectFriendList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtSelectFriendList.this.kLr.removeView(view);
                if (!AtSelectFriendList.this.dau()) {
                    AtSelectFriendList.this.das();
                }
                if (AtSelectFriendList.this.odn != null) {
                    AtSelectFriendList.this.odn.b(view, view.getTag());
                }
            }
        };
        this.mContext = context;
        initialize();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMaxCount(int i) {
        this.mMaxCount = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setItemOPerationHandler(a aVar) {
        this.odn = aVar;
    }

    private void initialize() {
        this.mItemWidth = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds80);
        this.dmK = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds80);
        this.kLs = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds12);
        this.kLr = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.kLr.setLayoutParams(layoutParams);
        this.kLr.setHorizontalScrollBarEnabled(true);
        this.kLr.setOrientation(0);
        das();
        addView(this.kLr);
        setSmoothScrollingEnabled(true);
        setFocusable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void das() {
        if (this.kLt == null) {
            this.kLt = dav();
            this.kLt.setDrawBorder(false);
        }
        this.kLt.setImageBitmap(ao.getBitmap(R.drawable.icon_add_pop));
        this.kLr.addView(this.kLt);
    }

    private void dat() {
        if (dau()) {
            this.kLr.removeView(this.kLt);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dau() {
        int childCount = this.kLr.getChildCount();
        return childCount > 0 && this.kLr.getChildAt(childCount + (-1)) == this.kLt;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(MetaData metaData) {
        if (getItemLength() < this.mMaxCount) {
            HeadImageView dav = dav();
            dav.setIsRound(false);
            dav.startLoad(metaData.getAvater(), 12, false);
            if (dau()) {
                dav.setTag(metaData);
                dav.setOnClickListener(this.aHh);
                this.kLr.addView(dav, getItemLength());
                scrollTo(getItemLength() * (this.mItemWidth + this.kLs), 0);
                this.kLr.requestLayout();
            }
            if (getItemLength() >= this.mMaxCount) {
                dat();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(MetaData metaData) {
        Object tag;
        int childCount = this.kLr.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.kLr.getChildAt(i);
            if (childAt != this.kLt && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && metaData != null) {
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
        int childCount = this.kLr.getChildCount();
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.kLr.getChildAt(i);
            if (childAt != this.kLt && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && (name_show = ((MetaData) tag).getName_show()) != null) {
                arrayList.add(name_show);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(MetaData metaData) {
        View findViewWithTag = this.kLr.findViewWithTag(metaData);
        if (findViewWithTag != null) {
            this.kLr.removeView(findViewWithTag);
            if (!dau()) {
                das();
            }
        }
    }

    private HeadImageView dav() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.mItemWidth, this.dmK);
        layoutParams.setMargins(this.kLs, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    public int getItemLength() {
        return dau() ? this.kLr.getChildCount() - 1 : this.kLr.getChildCount();
    }
}
