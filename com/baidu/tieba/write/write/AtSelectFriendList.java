package com.baidu.tieba.write.write;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HorizontalCustomScrollView;
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class AtSelectFriendList extends HorizontalCustomScrollView {
    private int Ze;
    private int aRh;
    private final View.OnClickListener bdv;
    private int dqx;
    private int dqy;
    private HeadImageView dqz;
    private a gdU;
    private final Context mContext;
    private LinearLayout mLayout;

    /* loaded from: classes.dex */
    public interface a {
        void a(View view, Object obj);
    }

    public AtSelectFriendList(Context context) {
        super(context);
        this.Ze = -1;
        this.dqx = -1;
        this.dqy = -1;
        this.aRh = 4;
        this.bdv = new o(this);
        this.mContext = context;
        initialize();
    }

    public AtSelectFriendList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Ze = -1;
        this.dqx = -1;
        this.dqy = -1;
        this.aRh = 4;
        this.bdv = new o(this);
        this.mContext = context;
        initialize();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMaxCount(int i) {
        this.aRh = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setItemOPerationHandler(a aVar) {
        this.gdU = aVar;
    }

    private void initialize() {
        this.Ze = this.mContext.getResources().getDimensionPixelSize(t.e.ds80);
        this.dqx = this.mContext.getResources().getDimensionPixelSize(t.e.ds80);
        this.dqy = this.mContext.getResources().getDimensionPixelSize(t.e.ds12);
        this.mLayout = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.mLayout.setLayoutParams(layoutParams);
        this.mLayout.setHorizontalScrollBarEnabled(true);
        this.mLayout.setOrientation(0);
        ayn();
        addView(this.mLayout);
        setSmoothScrollingEnabled(true);
        setFocusable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayn() {
        if (this.dqz == null) {
            this.dqz = ayr();
            this.dqz.setDrawBorder(false);
        }
        this.dqz.setImageBitmap(com.baidu.tbadk.core.util.av.cN(t.f.icon_add_pop));
        this.mLayout.addView(this.dqz);
    }

    private void ayo() {
        if (ayp()) {
            this.mLayout.removeView(this.dqz);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ayp() {
        int childCount = this.mLayout.getChildCount();
        return childCount > 0 && this.mLayout.getChildAt(childCount + (-1)) == this.dqz;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(MetaData metaData) {
        if (getItemLength() < this.aRh) {
            HeadImageView ayr = ayr();
            ayr.setIsRound(false);
            ayr.c(metaData.getPortrait(), 12, false);
            if (ayp()) {
                ayr.setTag(metaData);
                ayr.setOnClickListener(this.bdv);
                this.mLayout.addView(ayr, getItemLength());
                scrollTo(getItemLength() * (this.Ze + this.dqy), 0);
                this.mLayout.requestLayout();
            }
            if (getItemLength() >= this.aRh) {
                ayo();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(MetaData metaData) {
        Object tag;
        int childCount = this.mLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mLayout.getChildAt(i);
            if (childAt != this.dqz && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && metaData != null) {
                MetaData metaData2 = (MetaData) tag;
                if (metaData2.getUserName() != null && metaData2.getUserName().equals(metaData.getUserName())) {
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
            if (childAt != this.dqz && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && (name_show = ((MetaData) tag).getName_show()) != null) {
                arrayList.add(name_show);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(MetaData metaData) {
        View findViewWithTag = this.mLayout.findViewWithTag(metaData);
        if (findViewWithTag != null) {
            this.mLayout.removeView(findViewWithTag);
            if (!ayp()) {
                ayn();
            }
        }
    }

    private HeadImageView ayr() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.Ze, this.dqx);
        layoutParams.setMargins(this.dqy, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getItemLength() {
        return ayp() ? this.mLayout.getChildCount() - 1 : this.mLayout.getChildCount();
    }
}
