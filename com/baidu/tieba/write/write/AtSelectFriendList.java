package com.baidu.tieba.write.write;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HorizontalCustomScrollView;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class AtSelectFriendList extends HorizontalCustomScrollView {
    private final View.OnClickListener aXG;
    private LinearLayout jeE;
    private int jeF;
    private int jeG;
    private HeadImageView jeH;
    private final Context mContext;
    private int mItemHeight;
    private int mItemWidth;
    private a msF;

    /* loaded from: classes2.dex */
    public interface a {
        void a(View view, Object obj);
    }

    public AtSelectFriendList(Context context) {
        super(context);
        this.mItemWidth = -1;
        this.mItemHeight = -1;
        this.jeF = -1;
        this.jeG = 4;
        this.aXG = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtSelectFriendList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtSelectFriendList.this.jeE.removeView(view);
                if (!AtSelectFriendList.this.cug()) {
                    AtSelectFriendList.this.cue();
                }
                if (AtSelectFriendList.this.msF != null) {
                    AtSelectFriendList.this.msF.a(view, view.getTag());
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
        this.jeF = -1;
        this.jeG = 4;
        this.aXG = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtSelectFriendList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtSelectFriendList.this.jeE.removeView(view);
                if (!AtSelectFriendList.this.cug()) {
                    AtSelectFriendList.this.cue();
                }
                if (AtSelectFriendList.this.msF != null) {
                    AtSelectFriendList.this.msF.a(view, view.getTag());
                }
            }
        };
        this.mContext = context;
        initialize();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMaxCount(int i) {
        this.jeG = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setItemOPerationHandler(a aVar) {
        this.msF = aVar;
    }

    private void initialize() {
        this.mItemWidth = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds80);
        this.mItemHeight = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds80);
        this.jeF = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds12);
        this.jeE = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.jeE.setLayoutParams(layoutParams);
        this.jeE.setHorizontalScrollBarEnabled(true);
        this.jeE.setOrientation(0);
        cue();
        addView(this.jeE);
        setSmoothScrollingEnabled(true);
        setFocusable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cue() {
        if (this.jeH == null) {
            this.jeH = cuh();
            this.jeH.setDrawBorder(false);
        }
        this.jeH.setImageBitmap(an.getBitmap(R.drawable.icon_add_pop));
        this.jeE.addView(this.jeH);
    }

    private void cuf() {
        if (cug()) {
            this.jeE.removeView(this.jeH);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cug() {
        int childCount = this.jeE.getChildCount();
        return childCount > 0 && this.jeE.getChildAt(childCount + (-1)) == this.jeH;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(MetaData metaData) {
        if (getItemLength() < this.jeG) {
            HeadImageView cuh = cuh();
            cuh.setIsRound(false);
            cuh.startLoad(metaData.getAvater(), 12, false);
            if (cug()) {
                cuh.setTag(metaData);
                cuh.setOnClickListener(this.aXG);
                this.jeE.addView(cuh, getItemLength());
                scrollTo(getItemLength() * (this.mItemWidth + this.jeF), 0);
                this.jeE.requestLayout();
            }
            if (getItemLength() >= this.jeG) {
                cuf();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(MetaData metaData) {
        Object tag;
        int childCount = this.jeE.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.jeE.getChildAt(i);
            if (childAt != this.jeH && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && metaData != null) {
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
        int childCount = this.jeE.getChildCount();
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.jeE.getChildAt(i);
            if (childAt != this.jeH && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && (name_show = ((MetaData) tag).getName_show()) != null) {
                arrayList.add(name_show);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(MetaData metaData) {
        View findViewWithTag = this.jeE.findViewWithTag(metaData);
        if (findViewWithTag != null) {
            this.jeE.removeView(findViewWithTag);
            if (!cug()) {
                cue();
            }
        }
    }

    private HeadImageView cuh() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.mItemWidth, this.mItemHeight);
        layoutParams.setMargins(this.jeF, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    public int getItemLength() {
        return cug() ? this.jeE.getChildCount() - 1 : this.jeE.getChildCount();
    }
}
