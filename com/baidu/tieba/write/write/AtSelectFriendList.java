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
    private final View.OnClickListener aEX;
    private LinearLayout jZF;
    private int jZG;
    private int jZH;
    private HeadImageView jZI;
    private final Context mContext;
    private int mItemHeight;
    private int mItemWidth;
    private a nsO;

    /* loaded from: classes3.dex */
    public interface a {
        void a(View view, Object obj);
    }

    public AtSelectFriendList(Context context) {
        super(context);
        this.mItemWidth = -1;
        this.mItemHeight = -1;
        this.jZG = -1;
        this.jZH = 4;
        this.aEX = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtSelectFriendList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtSelectFriendList.this.jZF.removeView(view);
                if (!AtSelectFriendList.this.cQp()) {
                    AtSelectFriendList.this.cQn();
                }
                if (AtSelectFriendList.this.nsO != null) {
                    AtSelectFriendList.this.nsO.a(view, view.getTag());
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
        this.jZG = -1;
        this.jZH = 4;
        this.aEX = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtSelectFriendList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtSelectFriendList.this.jZF.removeView(view);
                if (!AtSelectFriendList.this.cQp()) {
                    AtSelectFriendList.this.cQn();
                }
                if (AtSelectFriendList.this.nsO != null) {
                    AtSelectFriendList.this.nsO.a(view, view.getTag());
                }
            }
        };
        this.mContext = context;
        initialize();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMaxCount(int i) {
        this.jZH = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setItemOPerationHandler(a aVar) {
        this.nsO = aVar;
    }

    private void initialize() {
        this.mItemWidth = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds80);
        this.mItemHeight = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds80);
        this.jZG = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds12);
        this.jZF = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.jZF.setLayoutParams(layoutParams);
        this.jZF.setHorizontalScrollBarEnabled(true);
        this.jZF.setOrientation(0);
        cQn();
        addView(this.jZF);
        setSmoothScrollingEnabled(true);
        setFocusable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cQn() {
        if (this.jZI == null) {
            this.jZI = cQq();
            this.jZI.setDrawBorder(false);
        }
        this.jZI.setImageBitmap(ap.getBitmap(R.drawable.icon_add_pop));
        this.jZF.addView(this.jZI);
    }

    private void cQo() {
        if (cQp()) {
            this.jZF.removeView(this.jZI);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cQp() {
        int childCount = this.jZF.getChildCount();
        return childCount > 0 && this.jZF.getChildAt(childCount + (-1)) == this.jZI;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(MetaData metaData) {
        if (getItemLength() < this.jZH) {
            HeadImageView cQq = cQq();
            cQq.setIsRound(false);
            cQq.startLoad(metaData.getAvater(), 12, false);
            if (cQp()) {
                cQq.setTag(metaData);
                cQq.setOnClickListener(this.aEX);
                this.jZF.addView(cQq, getItemLength());
                scrollTo(getItemLength() * (this.mItemWidth + this.jZG), 0);
                this.jZF.requestLayout();
            }
            if (getItemLength() >= this.jZH) {
                cQo();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(MetaData metaData) {
        Object tag;
        int childCount = this.jZF.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.jZF.getChildAt(i);
            if (childAt != this.jZI && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && metaData != null) {
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
        int childCount = this.jZF.getChildCount();
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.jZF.getChildAt(i);
            if (childAt != this.jZI && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && (name_show = ((MetaData) tag).getName_show()) != null) {
                arrayList.add(name_show);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(MetaData metaData) {
        View findViewWithTag = this.jZF.findViewWithTag(metaData);
        if (findViewWithTag != null) {
            this.jZF.removeView(findViewWithTag);
            if (!cQp()) {
                cQn();
            }
        }
    }

    private HeadImageView cQq() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.mItemWidth, this.mItemHeight);
        layoutParams.setMargins(this.jZG, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    public int getItemLength() {
        return cQp() ? this.jZF.getChildCount() - 1 : this.jZF.getChildCount();
    }
}
