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
/* loaded from: classes7.dex */
public class AtSelectFriendList extends HorizontalCustomScrollView {
    private final View.OnClickListener aCu;
    private int dhV;
    private LinearLayout kGM;
    private int kGN;
    private HeadImageView kGO;
    private final Context mContext;
    private int mItemWidth;
    private int mMaxCount;
    private a nYH;

    /* loaded from: classes7.dex */
    public interface a {
        void b(View view, Object obj);
    }

    public AtSelectFriendList(Context context) {
        super(context);
        this.mItemWidth = -1;
        this.dhV = -1;
        this.kGN = -1;
        this.mMaxCount = 4;
        this.aCu = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtSelectFriendList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtSelectFriendList.this.kGM.removeView(view);
                if (!AtSelectFriendList.this.cWC()) {
                    AtSelectFriendList.this.cWA();
                }
                if (AtSelectFriendList.this.nYH != null) {
                    AtSelectFriendList.this.nYH.b(view, view.getTag());
                }
            }
        };
        this.mContext = context;
        initialize();
    }

    public AtSelectFriendList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mItemWidth = -1;
        this.dhV = -1;
        this.kGN = -1;
        this.mMaxCount = 4;
        this.aCu = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtSelectFriendList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtSelectFriendList.this.kGM.removeView(view);
                if (!AtSelectFriendList.this.cWC()) {
                    AtSelectFriendList.this.cWA();
                }
                if (AtSelectFriendList.this.nYH != null) {
                    AtSelectFriendList.this.nYH.b(view, view.getTag());
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
        this.nYH = aVar;
    }

    private void initialize() {
        this.mItemWidth = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds80);
        this.dhV = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds80);
        this.kGN = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds12);
        this.kGM = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.kGM.setLayoutParams(layoutParams);
        this.kGM.setHorizontalScrollBarEnabled(true);
        this.kGM.setOrientation(0);
        cWA();
        addView(this.kGM);
        setSmoothScrollingEnabled(true);
        setFocusable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cWA() {
        if (this.kGO == null) {
            this.kGO = cWD();
            this.kGO.setDrawBorder(false);
        }
        this.kGO.setImageBitmap(ao.getBitmap(R.drawable.icon_add_pop));
        this.kGM.addView(this.kGO);
    }

    private void cWB() {
        if (cWC()) {
            this.kGM.removeView(this.kGO);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cWC() {
        int childCount = this.kGM.getChildCount();
        return childCount > 0 && this.kGM.getChildAt(childCount + (-1)) == this.kGO;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(MetaData metaData) {
        if (getItemLength() < this.mMaxCount) {
            HeadImageView cWD = cWD();
            cWD.setIsRound(false);
            cWD.startLoad(metaData.getAvater(), 12, false);
            if (cWC()) {
                cWD.setTag(metaData);
                cWD.setOnClickListener(this.aCu);
                this.kGM.addView(cWD, getItemLength());
                scrollTo(getItemLength() * (this.mItemWidth + this.kGN), 0);
                this.kGM.requestLayout();
            }
            if (getItemLength() >= this.mMaxCount) {
                cWB();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(MetaData metaData) {
        Object tag;
        int childCount = this.kGM.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.kGM.getChildAt(i);
            if (childAt != this.kGO && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && metaData != null) {
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
        int childCount = this.kGM.getChildCount();
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.kGM.getChildAt(i);
            if (childAt != this.kGO && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && (name_show = ((MetaData) tag).getName_show()) != null) {
                arrayList.add(name_show);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(MetaData metaData) {
        View findViewWithTag = this.kGM.findViewWithTag(metaData);
        if (findViewWithTag != null) {
            this.kGM.removeView(findViewWithTag);
            if (!cWC()) {
                cWA();
            }
        }
    }

    private HeadImageView cWD() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.mItemWidth, this.dhV);
        layoutParams.setMargins(this.kGN, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    public int getItemLength() {
        return cWC() ? this.kGM.getChildCount() - 1 : this.kGM.getChildCount();
    }
}
