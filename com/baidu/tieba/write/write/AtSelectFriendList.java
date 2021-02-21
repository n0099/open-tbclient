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
/* loaded from: classes8.dex */
public class AtSelectFriendList extends HorizontalCustomScrollView {
    private final View.OnClickListener aEh;
    private int dkj;
    private LinearLayout kPe;
    private int kPf;
    private HeadImageView kPg;
    private final Context mContext;
    private int mItemWidth;
    private int mMaxCount;
    private a ojn;

    /* loaded from: classes8.dex */
    public interface a {
        void b(View view, Object obj);
    }

    public AtSelectFriendList(Context context) {
        super(context);
        this.mItemWidth = -1;
        this.dkj = -1;
        this.kPf = -1;
        this.mMaxCount = 4;
        this.aEh = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtSelectFriendList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtSelectFriendList.this.kPe.removeView(view);
                if (!AtSelectFriendList.this.cYH()) {
                    AtSelectFriendList.this.cYF();
                }
                if (AtSelectFriendList.this.ojn != null) {
                    AtSelectFriendList.this.ojn.b(view, view.getTag());
                }
            }
        };
        this.mContext = context;
        initialize();
    }

    public AtSelectFriendList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mItemWidth = -1;
        this.dkj = -1;
        this.kPf = -1;
        this.mMaxCount = 4;
        this.aEh = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtSelectFriendList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtSelectFriendList.this.kPe.removeView(view);
                if (!AtSelectFriendList.this.cYH()) {
                    AtSelectFriendList.this.cYF();
                }
                if (AtSelectFriendList.this.ojn != null) {
                    AtSelectFriendList.this.ojn.b(view, view.getTag());
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
        this.ojn = aVar;
    }

    private void initialize() {
        this.mItemWidth = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds80);
        this.dkj = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds80);
        this.kPf = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds12);
        this.kPe = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.kPe.setLayoutParams(layoutParams);
        this.kPe.setHorizontalScrollBarEnabled(true);
        this.kPe.setOrientation(0);
        cYF();
        addView(this.kPe);
        setSmoothScrollingEnabled(true);
        setFocusable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cYF() {
        if (this.kPg == null) {
            this.kPg = cYI();
            this.kPg.setDrawBorder(false);
        }
        this.kPg.setImageBitmap(ap.getBitmap(R.drawable.icon_add_pop));
        this.kPe.addView(this.kPg);
    }

    private void cYG() {
        if (cYH()) {
            this.kPe.removeView(this.kPg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cYH() {
        int childCount = this.kPe.getChildCount();
        return childCount > 0 && this.kPe.getChildAt(childCount + (-1)) == this.kPg;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(MetaData metaData) {
        if (getItemLength() < this.mMaxCount) {
            HeadImageView cYI = cYI();
            cYI.setIsRound(false);
            cYI.startLoad(metaData.getAvater(), 12, false);
            if (cYH()) {
                cYI.setTag(metaData);
                cYI.setOnClickListener(this.aEh);
                this.kPe.addView(cYI, getItemLength());
                scrollTo(getItemLength() * (this.mItemWidth + this.kPf), 0);
                this.kPe.requestLayout();
            }
            if (getItemLength() >= this.mMaxCount) {
                cYG();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(MetaData metaData) {
        Object tag;
        int childCount = this.kPe.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.kPe.getChildAt(i);
            if (childAt != this.kPg && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && metaData != null) {
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
        int childCount = this.kPe.getChildCount();
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.kPe.getChildAt(i);
            if (childAt != this.kPg && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && (name_show = ((MetaData) tag).getName_show()) != null) {
                arrayList.add(name_show);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(MetaData metaData) {
        View findViewWithTag = this.kPe.findViewWithTag(metaData);
        if (findViewWithTag != null) {
            this.kPe.removeView(findViewWithTag);
            if (!cYH()) {
                cYF();
            }
        }
    }

    private HeadImageView cYI() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.mItemWidth, this.dkj);
        layoutParams.setMargins(this.kPf, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    public int getItemLength() {
        return cYH() ? this.kPe.getChildCount() - 1 : this.kPe.getChildCount();
    }
}
