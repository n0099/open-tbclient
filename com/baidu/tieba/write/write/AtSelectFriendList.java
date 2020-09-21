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
    private final View.OnClickListener aBS;
    private LinearLayout jKI;
    private int jKJ;
    private int jKK;
    private HeadImageView jKL;
    private final Context mContext;
    private int mItemHeight;
    private int mItemWidth;
    private a ndp;

    /* loaded from: classes3.dex */
    public interface a {
        void a(View view, Object obj);
    }

    public AtSelectFriendList(Context context) {
        super(context);
        this.mItemWidth = -1;
        this.mItemHeight = -1;
        this.jKJ = -1;
        this.jKK = 4;
        this.aBS = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtSelectFriendList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtSelectFriendList.this.jKI.removeView(view);
                if (!AtSelectFriendList.this.cMH()) {
                    AtSelectFriendList.this.cMF();
                }
                if (AtSelectFriendList.this.ndp != null) {
                    AtSelectFriendList.this.ndp.a(view, view.getTag());
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
        this.jKJ = -1;
        this.jKK = 4;
        this.aBS = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtSelectFriendList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtSelectFriendList.this.jKI.removeView(view);
                if (!AtSelectFriendList.this.cMH()) {
                    AtSelectFriendList.this.cMF();
                }
                if (AtSelectFriendList.this.ndp != null) {
                    AtSelectFriendList.this.ndp.a(view, view.getTag());
                }
            }
        };
        this.mContext = context;
        initialize();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMaxCount(int i) {
        this.jKK = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setItemOPerationHandler(a aVar) {
        this.ndp = aVar;
    }

    private void initialize() {
        this.mItemWidth = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds80);
        this.mItemHeight = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds80);
        this.jKJ = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds12);
        this.jKI = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.jKI.setLayoutParams(layoutParams);
        this.jKI.setHorizontalScrollBarEnabled(true);
        this.jKI.setOrientation(0);
        cMF();
        addView(this.jKI);
        setSmoothScrollingEnabled(true);
        setFocusable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cMF() {
        if (this.jKL == null) {
            this.jKL = cMI();
            this.jKL.setDrawBorder(false);
        }
        this.jKL.setImageBitmap(ap.getBitmap(R.drawable.icon_add_pop));
        this.jKI.addView(this.jKL);
    }

    private void cMG() {
        if (cMH()) {
            this.jKI.removeView(this.jKL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cMH() {
        int childCount = this.jKI.getChildCount();
        return childCount > 0 && this.jKI.getChildAt(childCount + (-1)) == this.jKL;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(MetaData metaData) {
        if (getItemLength() < this.jKK) {
            HeadImageView cMI = cMI();
            cMI.setIsRound(false);
            cMI.startLoad(metaData.getAvater(), 12, false);
            if (cMH()) {
                cMI.setTag(metaData);
                cMI.setOnClickListener(this.aBS);
                this.jKI.addView(cMI, getItemLength());
                scrollTo(getItemLength() * (this.mItemWidth + this.jKJ), 0);
                this.jKI.requestLayout();
            }
            if (getItemLength() >= this.jKK) {
                cMG();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(MetaData metaData) {
        Object tag;
        int childCount = this.jKI.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.jKI.getChildAt(i);
            if (childAt != this.jKL && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && metaData != null) {
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
        int childCount = this.jKI.getChildCount();
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.jKI.getChildAt(i);
            if (childAt != this.jKL && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && (name_show = ((MetaData) tag).getName_show()) != null) {
                arrayList.add(name_show);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(MetaData metaData) {
        View findViewWithTag = this.jKI.findViewWithTag(metaData);
        if (findViewWithTag != null) {
            this.jKI.removeView(findViewWithTag);
            if (!cMH()) {
                cMF();
            }
        }
    }

    private HeadImageView cMI() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.mItemWidth, this.mItemHeight);
        layoutParams.setMargins(this.jKJ, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    public int getItemLength() {
        return cMH() ? this.jKI.getChildCount() - 1 : this.jKI.getChildCount();
    }
}
