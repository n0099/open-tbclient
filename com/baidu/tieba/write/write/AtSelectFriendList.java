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
    private final View.OnClickListener aEk;
    private LinearLayout ksL;
    private int ksM;
    private int ksN;
    private HeadImageView ksO;
    private final Context mContext;
    private int mItemHeight;
    private int mItemWidth;
    private a nMI;

    /* loaded from: classes3.dex */
    public interface a {
        void a(View view, Object obj);
    }

    public AtSelectFriendList(Context context) {
        super(context);
        this.mItemWidth = -1;
        this.mItemHeight = -1;
        this.ksM = -1;
        this.ksN = 4;
        this.aEk = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtSelectFriendList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtSelectFriendList.this.ksL.removeView(view);
                if (!AtSelectFriendList.this.cVD()) {
                    AtSelectFriendList.this.cVB();
                }
                if (AtSelectFriendList.this.nMI != null) {
                    AtSelectFriendList.this.nMI.a(view, view.getTag());
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
        this.ksM = -1;
        this.ksN = 4;
        this.aEk = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtSelectFriendList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtSelectFriendList.this.ksL.removeView(view);
                if (!AtSelectFriendList.this.cVD()) {
                    AtSelectFriendList.this.cVB();
                }
                if (AtSelectFriendList.this.nMI != null) {
                    AtSelectFriendList.this.nMI.a(view, view.getTag());
                }
            }
        };
        this.mContext = context;
        initialize();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMaxCount(int i) {
        this.ksN = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setItemOPerationHandler(a aVar) {
        this.nMI = aVar;
    }

    private void initialize() {
        this.mItemWidth = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds80);
        this.mItemHeight = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds80);
        this.ksM = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds12);
        this.ksL = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.ksL.setLayoutParams(layoutParams);
        this.ksL.setHorizontalScrollBarEnabled(true);
        this.ksL.setOrientation(0);
        cVB();
        addView(this.ksL);
        setSmoothScrollingEnabled(true);
        setFocusable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cVB() {
        if (this.ksO == null) {
            this.ksO = cVE();
            this.ksO.setDrawBorder(false);
        }
        this.ksO.setImageBitmap(ap.getBitmap(R.drawable.icon_add_pop));
        this.ksL.addView(this.ksO);
    }

    private void cVC() {
        if (cVD()) {
            this.ksL.removeView(this.ksO);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cVD() {
        int childCount = this.ksL.getChildCount();
        return childCount > 0 && this.ksL.getChildAt(childCount + (-1)) == this.ksO;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(MetaData metaData) {
        if (getItemLength() < this.ksN) {
            HeadImageView cVE = cVE();
            cVE.setIsRound(false);
            cVE.startLoad(metaData.getAvater(), 12, false);
            if (cVD()) {
                cVE.setTag(metaData);
                cVE.setOnClickListener(this.aEk);
                this.ksL.addView(cVE, getItemLength());
                scrollTo(getItemLength() * (this.mItemWidth + this.ksM), 0);
                this.ksL.requestLayout();
            }
            if (getItemLength() >= this.ksN) {
                cVC();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(MetaData metaData) {
        Object tag;
        int childCount = this.ksL.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.ksL.getChildAt(i);
            if (childAt != this.ksO && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && metaData != null) {
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
        int childCount = this.ksL.getChildCount();
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.ksL.getChildAt(i);
            if (childAt != this.ksO && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && (name_show = ((MetaData) tag).getName_show()) != null) {
                arrayList.add(name_show);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(MetaData metaData) {
        View findViewWithTag = this.ksL.findViewWithTag(metaData);
        if (findViewWithTag != null) {
            this.ksL.removeView(findViewWithTag);
            if (!cVD()) {
                cVB();
            }
        }
    }

    private HeadImageView cVE() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.mItemWidth, this.mItemHeight);
        layoutParams.setMargins(this.ksM, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    public int getItemLength() {
        return cVD() ? this.ksL.getChildCount() - 1 : this.ksL.getChildCount();
    }
}
