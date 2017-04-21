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
import com.baidu.tieba.w;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class AtSelectFriendList extends HorizontalCustomScrollView {
    private int aeb;
    private final View.OnClickListener biY;
    private int cgk;
    private int ctu;
    private int dkV;
    private HeadImageView dkW;
    private a fTf;
    private final Context mContext;
    private LinearLayout mLayout;

    /* loaded from: classes.dex */
    public interface a {
        void a(View view, Object obj);
    }

    public AtSelectFriendList(Context context) {
        super(context);
        this.aeb = -1;
        this.cgk = -1;
        this.dkV = -1;
        this.ctu = 4;
        this.biY = new o(this);
        this.mContext = context;
        xk();
    }

    public AtSelectFriendList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aeb = -1;
        this.cgk = -1;
        this.dkV = -1;
        this.ctu = 4;
        this.biY = new o(this);
        this.mContext = context;
        xk();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMaxCount(int i) {
        this.ctu = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setItemOPerationHandler(a aVar) {
        this.fTf = aVar;
    }

    private void xk() {
        this.aeb = this.mContext.getResources().getDimensionPixelSize(w.f.ds80);
        this.cgk = this.mContext.getResources().getDimensionPixelSize(w.f.ds80);
        this.dkV = this.mContext.getResources().getDimensionPixelSize(w.f.ds12);
        this.mLayout = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.mLayout.setLayoutParams(layoutParams);
        this.mLayout.setHorizontalScrollBarEnabled(true);
        this.mLayout.setOrientation(0);
        avz();
        addView(this.mLayout);
        setSmoothScrollingEnabled(true);
        setFocusable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void avz() {
        if (this.dkW == null) {
            this.dkW = avD();
            this.dkW.setDrawBorder(false);
        }
        this.dkW.setImageBitmap(com.baidu.tbadk.core.util.aq.cO(w.g.icon_add_pop));
        this.mLayout.addView(this.dkW);
    }

    private void avA() {
        if (avB()) {
            this.mLayout.removeView(this.dkW);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean avB() {
        int childCount = this.mLayout.getChildCount();
        return childCount > 0 && this.mLayout.getChildAt(childCount + (-1)) == this.dkW;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(MetaData metaData) {
        if (getItemLength() < this.ctu) {
            HeadImageView avD = avD();
            avD.setIsRound(false);
            avD.c(metaData.getPortrait(), 12, false);
            if (avB()) {
                avD.setTag(metaData);
                avD.setOnClickListener(this.biY);
                this.mLayout.addView(avD, getItemLength());
                scrollTo(getItemLength() * (this.aeb + this.dkV), 0);
                this.mLayout.requestLayout();
            }
            if (getItemLength() >= this.ctu) {
                avA();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(MetaData metaData) {
        Object tag;
        int childCount = this.mLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mLayout.getChildAt(i);
            if (childAt != this.dkW && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && metaData != null) {
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
            if (childAt != this.dkW && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && (name_show = ((MetaData) tag).getName_show()) != null) {
                arrayList.add(name_show);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(MetaData metaData) {
        View findViewWithTag = this.mLayout.findViewWithTag(metaData);
        if (findViewWithTag != null) {
            this.mLayout.removeView(findViewWithTag);
            if (!avB()) {
                avz();
            }
        }
    }

    private HeadImageView avD() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.aeb, this.cgk);
        layoutParams.setMargins(this.dkV, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getItemLength() {
        return avB() ? this.mLayout.getChildCount() - 1 : this.mLayout.getChildCount();
    }
}
