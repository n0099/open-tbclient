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
import com.baidu.tieba.i;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class AtSelectFriendList extends HorizontalCustomScrollView {
    private int YR;
    private final View.OnClickListener aKj;
    private LinearLayout bNb;
    private int bNc;
    private int bNd;
    private int bNe;
    private HeadImageView bNf;
    private a doE;
    private final Context mContext;

    /* loaded from: classes.dex */
    public interface a {
        void a(View view, Object obj);
    }

    public AtSelectFriendList(Context context) {
        super(context);
        this.YR = -1;
        this.bNc = -1;
        this.bNd = -1;
        this.bNe = 4;
        this.aKj = new n(this);
        this.mContext = context;
        initialize();
    }

    public AtSelectFriendList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.YR = -1;
        this.bNc = -1;
        this.bNd = -1;
        this.bNe = 4;
        this.aKj = new n(this);
        this.mContext = context;
        initialize();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMaxCount(int i) {
        this.bNe = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setItemOPerationHandler(a aVar) {
        this.doE = aVar;
    }

    private void initialize() {
        this.YR = this.mContext.getResources().getDimensionPixelSize(i.d.invite_friend_candidate_item_width);
        this.bNc = this.mContext.getResources().getDimensionPixelSize(i.d.invite_friend_candidate_item_height);
        this.bNd = this.mContext.getResources().getDimensionPixelSize(i.d.invite_friend_candidate_item_margin);
        this.bNb = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.bNb.setLayoutParams(layoutParams);
        this.bNb.setHorizontalScrollBarEnabled(true);
        this.bNb.setOrientation(0);
        Zi();
        addView(this.bNb);
        setSmoothScrollingEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Zi() {
        if (this.bNf == null) {
            this.bNf = Zm();
            this.bNf.setDrawBorder(false);
        }
        this.bNf.setImageBitmap(com.baidu.tbadk.core.util.an.cw(i.e.icon_add_pop));
        this.bNb.addView(this.bNf);
    }

    private void Zj() {
        if (Zk()) {
            this.bNb.removeView(this.bNf);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Zk() {
        int childCount = this.bNb.getChildCount();
        return childCount > 0 && this.bNb.getChildAt(childCount + (-1)) == this.bNf;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(MetaData metaData) {
        if (getItemLength() < this.bNe) {
            HeadImageView Zm = Zm();
            Zm.setIsRound(false);
            Zm.d(metaData.getPortrait(), 12, false);
            if (Zk()) {
                Zm.setTag(metaData);
                Zm.setOnClickListener(this.aKj);
                this.bNb.addView(Zm, getItemLength());
                scrollTo(getItemLength() * (this.YR + this.bNd), 0);
                this.bNb.requestLayout();
            }
            if (getItemLength() >= this.bNe) {
                Zj();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(MetaData metaData) {
        Object tag;
        int childCount = this.bNb.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bNb.getChildAt(i);
            if (childAt != this.bNf && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && metaData != null) {
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
        int childCount = this.bNb.getChildCount();
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bNb.getChildAt(i);
            if (childAt != this.bNf && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && (name_show = ((MetaData) tag).getName_show()) != null) {
                arrayList.add(name_show);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(MetaData metaData) {
        View findViewWithTag = this.bNb.findViewWithTag(metaData);
        if (findViewWithTag != null) {
            this.bNb.removeView(findViewWithTag);
            if (!Zk()) {
                Zi();
            }
        }
    }

    private HeadImageView Zm() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.YR, this.bNc);
        layoutParams.setMargins(this.bNd, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getItemLength() {
        return Zk() ? this.bNb.getChildCount() - 1 : this.bNb.getChildCount();
    }
}
