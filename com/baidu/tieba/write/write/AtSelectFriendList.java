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
    private a odo;

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
                if (!AtSelectFriendList.this.dat()) {
                    AtSelectFriendList.this.dar();
                }
                if (AtSelectFriendList.this.odo != null) {
                    AtSelectFriendList.this.odo.b(view, view.getTag());
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
                if (!AtSelectFriendList.this.dat()) {
                    AtSelectFriendList.this.dar();
                }
                if (AtSelectFriendList.this.odo != null) {
                    AtSelectFriendList.this.odo.b(view, view.getTag());
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
        this.odo = aVar;
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
        dar();
        addView(this.kLr);
        setSmoothScrollingEnabled(true);
        setFocusable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dar() {
        if (this.kLt == null) {
            this.kLt = dau();
            this.kLt.setDrawBorder(false);
        }
        this.kLt.setImageBitmap(ao.getBitmap(R.drawable.icon_add_pop));
        this.kLr.addView(this.kLt);
    }

    private void das() {
        if (dat()) {
            this.kLr.removeView(this.kLt);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dat() {
        int childCount = this.kLr.getChildCount();
        return childCount > 0 && this.kLr.getChildAt(childCount + (-1)) == this.kLt;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(MetaData metaData) {
        if (getItemLength() < this.mMaxCount) {
            HeadImageView dau = dau();
            dau.setIsRound(false);
            dau.startLoad(metaData.getAvater(), 12, false);
            if (dat()) {
                dau.setTag(metaData);
                dau.setOnClickListener(this.aHh);
                this.kLr.addView(dau, getItemLength());
                scrollTo(getItemLength() * (this.mItemWidth + this.kLs), 0);
                this.kLr.requestLayout();
            }
            if (getItemLength() >= this.mMaxCount) {
                das();
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
            if (!dat()) {
                dar();
            }
        }
    }

    private HeadImageView dau() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.mItemWidth, this.dmK);
        layoutParams.setMargins(this.kLs, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    public int getItemLength() {
        return dat() ? this.kLr.getChildCount() - 1 : this.kLr.getChildCount();
    }
}
