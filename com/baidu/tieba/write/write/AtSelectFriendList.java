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
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class AtSelectFriendList extends HorizontalCustomScrollView {
    private final View.OnClickListener aUZ;
    private LinearLayout iMP;
    private int iMQ;
    private int iMR;
    private HeadImageView iMS;
    private a lWN;
    private final Context mContext;
    private int mItemHeight;
    private int mItemWidth;

    /* loaded from: classes2.dex */
    public interface a {
        void a(View view, Object obj);
    }

    public AtSelectFriendList(Context context) {
        super(context);
        this.mItemWidth = -1;
        this.mItemHeight = -1;
        this.iMQ = -1;
        this.iMR = 4;
        this.aUZ = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtSelectFriendList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtSelectFriendList.this.iMP.removeView(view);
                if (!AtSelectFriendList.this.cqi()) {
                    AtSelectFriendList.this.cqg();
                }
                if (AtSelectFriendList.this.lWN != null) {
                    AtSelectFriendList.this.lWN.a(view, view.getTag());
                }
            }
        };
        this.mContext = context;
        initialize();
    }

    public AtSelectFriendList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mItemWidth = -1;
        this.mItemHeight = -1;
        this.iMQ = -1;
        this.iMR = 4;
        this.aUZ = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtSelectFriendList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtSelectFriendList.this.iMP.removeView(view);
                if (!AtSelectFriendList.this.cqi()) {
                    AtSelectFriendList.this.cqg();
                }
                if (AtSelectFriendList.this.lWN != null) {
                    AtSelectFriendList.this.lWN.a(view, view.getTag());
                }
            }
        };
        this.mContext = context;
        initialize();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMaxCount(int i) {
        this.iMR = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setItemOPerationHandler(a aVar) {
        this.lWN = aVar;
    }

    private void initialize() {
        this.mItemWidth = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds80);
        this.mItemHeight = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds80);
        this.iMQ = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds12);
        this.iMP = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.iMP.setLayoutParams(layoutParams);
        this.iMP.setHorizontalScrollBarEnabled(true);
        this.iMP.setOrientation(0);
        cqg();
        addView(this.iMP);
        setSmoothScrollingEnabled(true);
        setFocusable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cqg() {
        if (this.iMS == null) {
            this.iMS = cqj();
            this.iMS.setDrawBorder(false);
        }
        this.iMS.setImageBitmap(am.getBitmap(R.drawable.icon_add_pop));
        this.iMP.addView(this.iMS);
    }

    private void cqh() {
        if (cqi()) {
            this.iMP.removeView(this.iMS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cqi() {
        int childCount = this.iMP.getChildCount();
        return childCount > 0 && this.iMP.getChildAt(childCount + (-1)) == this.iMS;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(MetaData metaData) {
        if (getItemLength() < this.iMR) {
            HeadImageView cqj = cqj();
            cqj.setIsRound(false);
            cqj.startLoad(metaData.getPortrait(), 12, false);
            if (cqi()) {
                cqj.setTag(metaData);
                cqj.setOnClickListener(this.aUZ);
                this.iMP.addView(cqj, getItemLength());
                scrollTo(getItemLength() * (this.mItemWidth + this.iMQ), 0);
                this.iMP.requestLayout();
            }
            if (getItemLength() >= this.iMR) {
                cqh();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(MetaData metaData) {
        Object tag;
        int childCount = this.iMP.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.iMP.getChildAt(i);
            if (childAt != this.iMS && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && metaData != null) {
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
        int childCount = this.iMP.getChildCount();
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.iMP.getChildAt(i);
            if (childAt != this.iMS && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && (name_show = ((MetaData) tag).getName_show()) != null) {
                arrayList.add(name_show);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(MetaData metaData) {
        View findViewWithTag = this.iMP.findViewWithTag(metaData);
        if (findViewWithTag != null) {
            this.iMP.removeView(findViewWithTag);
            if (!cqi()) {
                cqg();
            }
        }
    }

    private HeadImageView cqj() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.mItemWidth, this.mItemHeight);
        layoutParams.setMargins(this.iMQ, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getItemLength() {
        return cqi() ? this.iMP.getChildCount() - 1 : this.iMP.getChildCount();
    }
}
