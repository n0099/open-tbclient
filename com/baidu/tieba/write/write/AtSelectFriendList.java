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
    private final View.OnClickListener aRw;
    private int aal;
    private LinearLayout cgA;
    private int cgB;
    private int cgC;
    private int cgD;
    private HeadImageView cgE;
    private a dWV;
    private final Context mContext;

    /* loaded from: classes.dex */
    public interface a {
        void a(View view, Object obj);
    }

    public AtSelectFriendList(Context context) {
        super(context);
        this.aal = -1;
        this.cgB = -1;
        this.cgC = -1;
        this.cgD = 4;
        this.aRw = new n(this);
        this.mContext = context;
        initialize();
    }

    public AtSelectFriendList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aal = -1;
        this.cgB = -1;
        this.cgC = -1;
        this.cgD = 4;
        this.aRw = new n(this);
        this.mContext = context;
        initialize();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMaxCount(int i) {
        this.cgD = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setItemOPerationHandler(a aVar) {
        this.dWV = aVar;
    }

    private void initialize() {
        this.aal = this.mContext.getResources().getDimensionPixelSize(n.e.invite_friend_candidate_item_width);
        this.cgB = this.mContext.getResources().getDimensionPixelSize(n.e.invite_friend_candidate_item_height);
        this.cgC = this.mContext.getResources().getDimensionPixelSize(n.e.invite_friend_candidate_item_margin);
        this.cgA = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.cgA.setLayoutParams(layoutParams);
        this.cgA.setHorizontalScrollBarEnabled(true);
        this.cgA.setOrientation(0);
        adO();
        addView(this.cgA);
        setSmoothScrollingEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adO() {
        if (this.cgE == null) {
            this.cgE = adS();
            this.cgE.setDrawBorder(false);
        }
        this.cgE.setImageBitmap(com.baidu.tbadk.core.util.as.cx(n.f.icon_add_pop));
        this.cgA.addView(this.cgE);
    }

    private void adP() {
        if (adQ()) {
            this.cgA.removeView(this.cgE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean adQ() {
        int childCount = this.cgA.getChildCount();
        return childCount > 0 && this.cgA.getChildAt(childCount + (-1)) == this.cgE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(MetaData metaData) {
        if (getItemLength() < this.cgD) {
            HeadImageView adS = adS();
            adS.setIsRound(false);
            adS.d(metaData.getPortrait(), 12, false);
            if (adQ()) {
                adS.setTag(metaData);
                adS.setOnClickListener(this.aRw);
                this.cgA.addView(adS, getItemLength());
                scrollTo(getItemLength() * (this.aal + this.cgC), 0);
                this.cgA.requestLayout();
            }
            if (getItemLength() >= this.cgD) {
                adP();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(MetaData metaData) {
        Object tag;
        int childCount = this.cgA.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.cgA.getChildAt(i);
            if (childAt != this.cgE && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && metaData != null) {
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
        int childCount = this.cgA.getChildCount();
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.cgA.getChildAt(i);
            if (childAt != this.cgE && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && (name_show = ((MetaData) tag).getName_show()) != null) {
                arrayList.add(name_show);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(MetaData metaData) {
        View findViewWithTag = this.cgA.findViewWithTag(metaData);
        if (findViewWithTag != null) {
            this.cgA.removeView(findViewWithTag);
            if (!adQ()) {
                adO();
            }
        }
    }

    private HeadImageView adS() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.aal, this.cgB);
        layoutParams.setMargins(this.cgC, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getItemLength() {
        return adQ() ? this.cgA.getChildCount() - 1 : this.cgA.getChildCount();
    }
}
