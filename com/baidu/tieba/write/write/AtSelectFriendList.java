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
    private int YP;
    private final View.OnClickListener aJY;
    private LinearLayout bMQ;
    private int bMR;
    private int bMS;
    private int bMT;
    private HeadImageView bMU;
    private a doe;
    private final Context mContext;

    /* loaded from: classes.dex */
    public interface a {
        void a(View view, Object obj);
    }

    public AtSelectFriendList(Context context) {
        super(context);
        this.YP = -1;
        this.bMR = -1;
        this.bMS = -1;
        this.bMT = 4;
        this.aJY = new n(this);
        this.mContext = context;
        initialize();
    }

    public AtSelectFriendList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.YP = -1;
        this.bMR = -1;
        this.bMS = -1;
        this.bMT = 4;
        this.aJY = new n(this);
        this.mContext = context;
        initialize();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMaxCount(int i) {
        this.bMT = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setItemOPerationHandler(a aVar) {
        this.doe = aVar;
    }

    private void initialize() {
        this.YP = this.mContext.getResources().getDimensionPixelSize(i.d.invite_friend_candidate_item_width);
        this.bMR = this.mContext.getResources().getDimensionPixelSize(i.d.invite_friend_candidate_item_height);
        this.bMS = this.mContext.getResources().getDimensionPixelSize(i.d.invite_friend_candidate_item_margin);
        this.bMQ = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.bMQ.setLayoutParams(layoutParams);
        this.bMQ.setHorizontalScrollBarEnabled(true);
        this.bMQ.setOrientation(0);
        Zi();
        addView(this.bMQ);
        setSmoothScrollingEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Zi() {
        if (this.bMU == null) {
            this.bMU = Zm();
            this.bMU.setDrawBorder(false);
        }
        this.bMU.setImageBitmap(com.baidu.tbadk.core.util.am.cw(i.e.icon_add_pop));
        this.bMQ.addView(this.bMU);
    }

    private void Zj() {
        if (Zk()) {
            this.bMQ.removeView(this.bMU);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Zk() {
        int childCount = this.bMQ.getChildCount();
        return childCount > 0 && this.bMQ.getChildAt(childCount + (-1)) == this.bMU;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(MetaData metaData) {
        if (getItemLength() < this.bMT) {
            HeadImageView Zm = Zm();
            Zm.setIsRound(false);
            Zm.d(metaData.getPortrait(), 12, false);
            if (Zk()) {
                Zm.setTag(metaData);
                Zm.setOnClickListener(this.aJY);
                this.bMQ.addView(Zm, getItemLength());
                scrollTo(getItemLength() * (this.YP + this.bMS), 0);
                this.bMQ.requestLayout();
            }
            if (getItemLength() >= this.bMT) {
                Zj();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(MetaData metaData) {
        Object tag;
        int childCount = this.bMQ.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bMQ.getChildAt(i);
            if (childAt != this.bMU && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && metaData != null) {
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
        int childCount = this.bMQ.getChildCount();
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bMQ.getChildAt(i);
            if (childAt != this.bMU && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && (name_show = ((MetaData) tag).getName_show()) != null) {
                arrayList.add(name_show);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(MetaData metaData) {
        View findViewWithTag = this.bMQ.findViewWithTag(metaData);
        if (findViewWithTag != null) {
            this.bMQ.removeView(findViewWithTag);
            if (!Zk()) {
                Zi();
            }
        }
    }

    private HeadImageView Zm() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.YP, this.bMR);
        layoutParams.setMargins(this.bMS, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getItemLength() {
        return Zk() ? this.bMQ.getChildCount() - 1 : this.bMQ.getChildCount();
    }
}
