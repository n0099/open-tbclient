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
    private final View.OnClickListener aTD;
    private int aaJ;
    private LinearLayout cla;
    private int clb;
    private int clc;
    private int cld;
    private HeadImageView cle;
    private a erO;
    private final Context mContext;

    /* loaded from: classes.dex */
    public interface a {
        void a(View view, Object obj);
    }

    public AtSelectFriendList(Context context) {
        super(context);
        this.aaJ = -1;
        this.clb = -1;
        this.clc = -1;
        this.cld = 4;
        this.aTD = new n(this);
        this.mContext = context;
        initialize();
    }

    public AtSelectFriendList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aaJ = -1;
        this.clb = -1;
        this.clc = -1;
        this.cld = 4;
        this.aTD = new n(this);
        this.mContext = context;
        initialize();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMaxCount(int i) {
        this.cld = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setItemOPerationHandler(a aVar) {
        this.erO = aVar;
    }

    private void initialize() {
        this.aaJ = this.mContext.getResources().getDimensionPixelSize(t.e.invite_friend_candidate_item_width);
        this.clb = this.mContext.getResources().getDimensionPixelSize(t.e.invite_friend_candidate_item_height);
        this.clc = this.mContext.getResources().getDimensionPixelSize(t.e.invite_friend_candidate_item_margin);
        this.cla = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.cla.setLayoutParams(layoutParams);
        this.cla.setHorizontalScrollBarEnabled(true);
        this.cla.setOrientation(0);
        agY();
        addView(this.cla);
        setSmoothScrollingEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void agY() {
        if (this.cle == null) {
            this.cle = ahc();
            this.cle.setDrawBorder(false);
        }
        this.cle.setImageBitmap(com.baidu.tbadk.core.util.ar.cO(t.f.icon_add_pop));
        this.cla.addView(this.cle);
    }

    private void agZ() {
        if (aha()) {
            this.cla.removeView(this.cle);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aha() {
        int childCount = this.cla.getChildCount();
        return childCount > 0 && this.cla.getChildAt(childCount + (-1)) == this.cle;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(MetaData metaData) {
        if (getItemLength() < this.cld) {
            HeadImageView ahc = ahc();
            ahc.setIsRound(false);
            ahc.d(metaData.getPortrait(), 12, false);
            if (aha()) {
                ahc.setTag(metaData);
                ahc.setOnClickListener(this.aTD);
                this.cla.addView(ahc, getItemLength());
                scrollTo(getItemLength() * (this.aaJ + this.clc), 0);
                this.cla.requestLayout();
            }
            if (getItemLength() >= this.cld) {
                agZ();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(MetaData metaData) {
        Object tag;
        int childCount = this.cla.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.cla.getChildAt(i);
            if (childAt != this.cle && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && metaData != null) {
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
        int childCount = this.cla.getChildCount();
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.cla.getChildAt(i);
            if (childAt != this.cle && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && (name_show = ((MetaData) tag).getName_show()) != null) {
                arrayList.add(name_show);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(MetaData metaData) {
        View findViewWithTag = this.cla.findViewWithTag(metaData);
        if (findViewWithTag != null) {
            this.cla.removeView(findViewWithTag);
            if (!aha()) {
                agY();
            }
        }
    }

    private HeadImageView ahc() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.aaJ, this.clb);
        layoutParams.setMargins(this.clc, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getItemLength() {
        return aha() ? this.cla.getChildCount() - 1 : this.cla.getChildCount();
    }
}
