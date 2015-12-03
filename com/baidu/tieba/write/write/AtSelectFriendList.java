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
import com.baidu.tieba.n;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class AtSelectFriendList extends HorizontalCustomScrollView {
    private int ZH;
    private final View.OnClickListener aNE;
    private LinearLayout ccA;
    private int ccB;
    private int ccC;
    private int ccD;
    private HeadImageView ccE;
    private a dPw;
    private final Context mContext;

    /* loaded from: classes.dex */
    public interface a {
        void a(View view, Object obj);
    }

    public AtSelectFriendList(Context context) {
        super(context);
        this.ZH = -1;
        this.ccB = -1;
        this.ccC = -1;
        this.ccD = 4;
        this.aNE = new n(this);
        this.mContext = context;
        initialize();
    }

    public AtSelectFriendList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ZH = -1;
        this.ccB = -1;
        this.ccC = -1;
        this.ccD = 4;
        this.aNE = new n(this);
        this.mContext = context;
        initialize();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMaxCount(int i) {
        this.ccD = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setItemOPerationHandler(a aVar) {
        this.dPw = aVar;
    }

    private void initialize() {
        this.ZH = this.mContext.getResources().getDimensionPixelSize(n.d.invite_friend_candidate_item_width);
        this.ccB = this.mContext.getResources().getDimensionPixelSize(n.d.invite_friend_candidate_item_height);
        this.ccC = this.mContext.getResources().getDimensionPixelSize(n.d.invite_friend_candidate_item_margin);
        this.ccA = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.ccA.setLayoutParams(layoutParams);
        this.ccA.setHorizontalScrollBarEnabled(true);
        this.ccA.setOrientation(0);
        acF();
        addView(this.ccA);
        setSmoothScrollingEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void acF() {
        if (this.ccE == null) {
            this.ccE = acJ();
            this.ccE.setDrawBorder(false);
        }
        this.ccE.setImageBitmap(com.baidu.tbadk.core.util.as.cE(n.e.icon_add_pop));
        this.ccA.addView(this.ccE);
    }

    private void acG() {
        if (acH()) {
            this.ccA.removeView(this.ccE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean acH() {
        int childCount = this.ccA.getChildCount();
        return childCount > 0 && this.ccA.getChildAt(childCount + (-1)) == this.ccE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(MetaData metaData) {
        if (getItemLength() < this.ccD) {
            HeadImageView acJ = acJ();
            acJ.setIsRound(false);
            acJ.d(metaData.getPortrait(), 12, false);
            if (acH()) {
                acJ.setTag(metaData);
                acJ.setOnClickListener(this.aNE);
                this.ccA.addView(acJ, getItemLength());
                scrollTo(getItemLength() * (this.ZH + this.ccC), 0);
                this.ccA.requestLayout();
            }
            if (getItemLength() >= this.ccD) {
                acG();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(MetaData metaData) {
        Object tag;
        int childCount = this.ccA.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.ccA.getChildAt(i);
            if (childAt != this.ccE && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && metaData != null) {
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
        int childCount = this.ccA.getChildCount();
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.ccA.getChildAt(i);
            if (childAt != this.ccE && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && (name_show = ((MetaData) tag).getName_show()) != null) {
                arrayList.add(name_show);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(MetaData metaData) {
        View findViewWithTag = this.ccA.findViewWithTag(metaData);
        if (findViewWithTag != null) {
            this.ccA.removeView(findViewWithTag);
            if (!acH()) {
                acF();
            }
        }
    }

    private HeadImageView acJ() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.ZH, this.ccB);
        layoutParams.setMargins(this.ccC, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getItemLength() {
        return acH() ? this.ccA.getChildCount() - 1 : this.ccA.getChildCount();
    }
}
