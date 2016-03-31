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
    private int ZV;
    private final View.OnClickListener aXp;
    private int bNN;
    private LinearLayout cvF;
    private int cvG;
    private int cvH;
    private HeadImageView cvI;
    private a eLI;
    private final Context mContext;

    /* loaded from: classes.dex */
    public interface a {
        void a(View view, Object obj);
    }

    public AtSelectFriendList(Context context) {
        super(context);
        this.ZV = -1;
        this.cvG = -1;
        this.cvH = -1;
        this.bNN = 4;
        this.aXp = new o(this);
        this.mContext = context;
        initialize();
    }

    public AtSelectFriendList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ZV = -1;
        this.cvG = -1;
        this.cvH = -1;
        this.bNN = 4;
        this.aXp = new o(this);
        this.mContext = context;
        initialize();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMaxCount(int i) {
        this.bNN = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setItemOPerationHandler(a aVar) {
        this.eLI = aVar;
    }

    private void initialize() {
        this.ZV = this.mContext.getResources().getDimensionPixelSize(t.e.invite_friend_candidate_item_width);
        this.cvG = this.mContext.getResources().getDimensionPixelSize(t.e.invite_friend_candidate_item_height);
        this.cvH = this.mContext.getResources().getDimensionPixelSize(t.e.invite_friend_candidate_item_margin);
        this.cvF = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.cvF.setLayoutParams(layoutParams);
        this.cvF.setHorizontalScrollBarEnabled(true);
        this.cvF.setOrientation(0);
        aks();
        addView(this.cvF);
        setSmoothScrollingEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aks() {
        if (this.cvI == null) {
            this.cvI = akw();
            this.cvI.setDrawBorder(false);
        }
        this.cvI.setImageBitmap(com.baidu.tbadk.core.util.at.cR(t.f.icon_add_pop));
        this.cvF.addView(this.cvI);
    }

    private void akt() {
        if (aku()) {
            this.cvF.removeView(this.cvI);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aku() {
        int childCount = this.cvF.getChildCount();
        return childCount > 0 && this.cvF.getChildAt(childCount + (-1)) == this.cvI;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(MetaData metaData) {
        if (getItemLength() < this.bNN) {
            HeadImageView akw = akw();
            akw.setIsRound(false);
            akw.c(metaData.getPortrait(), 12, false);
            if (aku()) {
                akw.setTag(metaData);
                akw.setOnClickListener(this.aXp);
                this.cvF.addView(akw, getItemLength());
                scrollTo(getItemLength() * (this.ZV + this.cvH), 0);
                this.cvF.requestLayout();
            }
            if (getItemLength() >= this.bNN) {
                akt();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(MetaData metaData) {
        Object tag;
        int childCount = this.cvF.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.cvF.getChildAt(i);
            if (childAt != this.cvI && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && metaData != null) {
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
        int childCount = this.cvF.getChildCount();
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.cvF.getChildAt(i);
            if (childAt != this.cvI && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && (name_show = ((MetaData) tag).getName_show()) != null) {
                arrayList.add(name_show);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(MetaData metaData) {
        View findViewWithTag = this.cvF.findViewWithTag(metaData);
        if (findViewWithTag != null) {
            this.cvF.removeView(findViewWithTag);
            if (!aku()) {
                aks();
            }
        }
    }

    private HeadImageView akw() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.ZV, this.cvG);
        layoutParams.setMargins(this.cvH, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getItemLength() {
        return aku() ? this.cvF.getChildCount() - 1 : this.cvF.getChildCount();
    }
}
