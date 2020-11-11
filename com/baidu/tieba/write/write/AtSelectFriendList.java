package com.baidu.tieba.write.write;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HorizontalCustomScrollView;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class AtSelectFriendList extends HorizontalCustomScrollView {
    private final View.OnClickListener aFV;
    private LinearLayout ksb;
    private int ksc;
    private int ksd;
    private HeadImageView kse;
    private final Context mContext;
    private int mItemHeight;
    private int mItemWidth;
    private a nLh;

    /* loaded from: classes3.dex */
    public interface a {
        void a(View view, Object obj);
    }

    public AtSelectFriendList(Context context) {
        super(context);
        this.mItemWidth = -1;
        this.mItemHeight = -1;
        this.ksc = -1;
        this.ksd = 4;
        this.aFV = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtSelectFriendList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtSelectFriendList.this.ksb.removeView(view);
                if (!AtSelectFriendList.this.cVX()) {
                    AtSelectFriendList.this.cVV();
                }
                if (AtSelectFriendList.this.nLh != null) {
                    AtSelectFriendList.this.nLh.a(view, view.getTag());
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
        this.ksc = -1;
        this.ksd = 4;
        this.aFV = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtSelectFriendList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtSelectFriendList.this.ksb.removeView(view);
                if (!AtSelectFriendList.this.cVX()) {
                    AtSelectFriendList.this.cVV();
                }
                if (AtSelectFriendList.this.nLh != null) {
                    AtSelectFriendList.this.nLh.a(view, view.getTag());
                }
            }
        };
        this.mContext = context;
        initialize();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMaxCount(int i) {
        this.ksd = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setItemOPerationHandler(a aVar) {
        this.nLh = aVar;
    }

    private void initialize() {
        this.mItemWidth = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds80);
        this.mItemHeight = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds80);
        this.ksc = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds12);
        this.ksb = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.ksb.setLayoutParams(layoutParams);
        this.ksb.setHorizontalScrollBarEnabled(true);
        this.ksb.setOrientation(0);
        cVV();
        addView(this.ksb);
        setSmoothScrollingEnabled(true);
        setFocusable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cVV() {
        if (this.kse == null) {
            this.kse = cVY();
            this.kse.setDrawBorder(false);
        }
        this.kse.setImageBitmap(ap.getBitmap(R.drawable.icon_add_pop));
        this.ksb.addView(this.kse);
    }

    private void cVW() {
        if (cVX()) {
            this.ksb.removeView(this.kse);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cVX() {
        int childCount = this.ksb.getChildCount();
        return childCount > 0 && this.ksb.getChildAt(childCount + (-1)) == this.kse;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(MetaData metaData) {
        if (getItemLength() < this.ksd) {
            HeadImageView cVY = cVY();
            cVY.setIsRound(false);
            cVY.startLoad(metaData.getAvater(), 12, false);
            if (cVX()) {
                cVY.setTag(metaData);
                cVY.setOnClickListener(this.aFV);
                this.ksb.addView(cVY, getItemLength());
                scrollTo(getItemLength() * (this.mItemWidth + this.ksc), 0);
                this.ksb.requestLayout();
            }
            if (getItemLength() >= this.ksd) {
                cVW();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(MetaData metaData) {
        Object tag;
        int childCount = this.ksb.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.ksb.getChildAt(i);
            if (childAt != this.kse && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && metaData != null) {
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
        int childCount = this.ksb.getChildCount();
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.ksb.getChildAt(i);
            if (childAt != this.kse && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && (name_show = ((MetaData) tag).getName_show()) != null) {
                arrayList.add(name_show);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(MetaData metaData) {
        View findViewWithTag = this.ksb.findViewWithTag(metaData);
        if (findViewWithTag != null) {
            this.ksb.removeView(findViewWithTag);
            if (!cVX()) {
                cVV();
            }
        }
    }

    private HeadImageView cVY() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.mItemWidth, this.mItemHeight);
        layoutParams.setMargins(this.ksc, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    public int getItemLength() {
        return cVX() ? this.ksb.getChildCount() - 1 : this.ksb.getChildCount();
    }
}
