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
/* loaded from: classes11.dex */
public class AtSelectFriendList extends HorizontalCustomScrollView {
    private final View.OnClickListener arL;
    private int hKA;
    private int hKB;
    private HeadImageView hKC;
    private a kQY;
    private final Context mContext;
    private int mItemHeight;
    private int mItemWidth;
    private LinearLayout mLayout;

    /* loaded from: classes11.dex */
    public interface a {
        void a(View view, Object obj);
    }

    public AtSelectFriendList(Context context) {
        super(context);
        this.mItemWidth = -1;
        this.mItemHeight = -1;
        this.hKA = -1;
        this.hKB = 4;
        this.arL = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtSelectFriendList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtSelectFriendList.this.mLayout.removeView(view);
                if (!AtSelectFriendList.this.bXo()) {
                    AtSelectFriendList.this.bXm();
                }
                if (AtSelectFriendList.this.kQY != null) {
                    AtSelectFriendList.this.kQY.a(view, view.getTag());
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
        this.hKA = -1;
        this.hKB = 4;
        this.arL = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtSelectFriendList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtSelectFriendList.this.mLayout.removeView(view);
                if (!AtSelectFriendList.this.bXo()) {
                    AtSelectFriendList.this.bXm();
                }
                if (AtSelectFriendList.this.kQY != null) {
                    AtSelectFriendList.this.kQY.a(view, view.getTag());
                }
            }
        };
        this.mContext = context;
        initialize();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMaxCount(int i) {
        this.hKB = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setItemOPerationHandler(a aVar) {
        this.kQY = aVar;
    }

    private void initialize() {
        this.mItemWidth = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds80);
        this.mItemHeight = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds80);
        this.hKA = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds12);
        this.mLayout = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.mLayout.setLayoutParams(layoutParams);
        this.mLayout.setHorizontalScrollBarEnabled(true);
        this.mLayout.setOrientation(0);
        bXm();
        addView(this.mLayout);
        setSmoothScrollingEnabled(true);
        setFocusable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXm() {
        if (this.hKC == null) {
            this.hKC = bXp();
            this.hKC.setDrawBorder(false);
        }
        this.hKC.setImageBitmap(am.getBitmap(R.drawable.icon_add_pop));
        this.mLayout.addView(this.hKC);
    }

    private void bXn() {
        if (bXo()) {
            this.mLayout.removeView(this.hKC);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bXo() {
        int childCount = this.mLayout.getChildCount();
        return childCount > 0 && this.mLayout.getChildAt(childCount + (-1)) == this.hKC;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(MetaData metaData) {
        if (getItemLength() < this.hKB) {
            HeadImageView bXp = bXp();
            bXp.setIsRound(false);
            bXp.startLoad(metaData.getPortrait(), 12, false);
            if (bXo()) {
                bXp.setTag(metaData);
                bXp.setOnClickListener(this.arL);
                this.mLayout.addView(bXp, getItemLength());
                scrollTo(getItemLength() * (this.mItemWidth + this.hKA), 0);
                this.mLayout.requestLayout();
            }
            if (getItemLength() >= this.hKB) {
                bXn();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(MetaData metaData) {
        Object tag;
        int childCount = this.mLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mLayout.getChildAt(i);
            if (childAt != this.hKC && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && metaData != null) {
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
        int childCount = this.mLayout.getChildCount();
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mLayout.getChildAt(i);
            if (childAt != this.hKC && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && (name_show = ((MetaData) tag).getName_show()) != null) {
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
            if (!bXo()) {
                bXm();
            }
        }
    }

    private HeadImageView bXp() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.mItemWidth, this.mItemHeight);
        layoutParams.setMargins(this.hKA, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getItemLength() {
        return bXo() ? this.mLayout.getChildCount() - 1 : this.mLayout.getChildCount();
    }
}
