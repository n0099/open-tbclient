package com.baidu.tieba.write.write;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HorizontalCustomScrollView;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class AtSelectFriendList extends HorizontalCustomScrollView {
    private int afL;
    private final View.OnClickListener btm;
    private int cNf;
    private int cbj;
    private int dCh;
    private HeadImageView dCi;
    private a gFl;
    private final Context mContext;
    private LinearLayout mLayout;

    /* loaded from: classes.dex */
    public interface a {
        void b(View view, Object obj);
    }

    public AtSelectFriendList(Context context) {
        super(context);
        this.afL = -1;
        this.cbj = -1;
        this.dCh = -1;
        this.cNf = 4;
        this.btm = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtSelectFriendList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtSelectFriendList.this.mLayout.removeView(view);
                if (!AtSelectFriendList.this.ayO()) {
                    AtSelectFriendList.this.ayM();
                }
                if (AtSelectFriendList.this.gFl != null) {
                    AtSelectFriendList.this.gFl.b(view, view.getTag());
                }
            }
        };
        this.mContext = context;
        bg();
    }

    public AtSelectFriendList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.afL = -1;
        this.cbj = -1;
        this.dCh = -1;
        this.cNf = 4;
        this.btm = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtSelectFriendList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtSelectFriendList.this.mLayout.removeView(view);
                if (!AtSelectFriendList.this.ayO()) {
                    AtSelectFriendList.this.ayM();
                }
                if (AtSelectFriendList.this.gFl != null) {
                    AtSelectFriendList.this.gFl.b(view, view.getTag());
                }
            }
        };
        this.mContext = context;
        bg();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMaxCount(int i) {
        this.cNf = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setItemOPerationHandler(a aVar) {
        this.gFl = aVar;
    }

    private void bg() {
        this.afL = this.mContext.getResources().getDimensionPixelSize(d.f.ds80);
        this.cbj = this.mContext.getResources().getDimensionPixelSize(d.f.ds80);
        this.dCh = this.mContext.getResources().getDimensionPixelSize(d.f.ds12);
        this.mLayout = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.mLayout.setLayoutParams(layoutParams);
        this.mLayout.setHorizontalScrollBarEnabled(true);
        this.mLayout.setOrientation(0);
        ayM();
        addView(this.mLayout);
        setSmoothScrollingEnabled(true);
        setFocusable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayM() {
        if (this.dCi == null) {
            this.dCi = ayQ();
            this.dCi.setDrawBorder(false);
        }
        this.dCi.setImageBitmap(ai.cS(d.g.icon_add_pop));
        this.mLayout.addView(this.dCi);
    }

    private void ayN() {
        if (ayO()) {
            this.mLayout.removeView(this.dCi);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ayO() {
        int childCount = this.mLayout.getChildCount();
        return childCount > 0 && this.mLayout.getChildAt(childCount + (-1)) == this.dCi;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(MetaData metaData) {
        if (getItemLength() < this.cNf) {
            HeadImageView ayQ = ayQ();
            ayQ.setIsRound(false);
            ayQ.c(metaData.getPortrait(), 12, false);
            if (ayO()) {
                ayQ.setTag(metaData);
                ayQ.setOnClickListener(this.btm);
                this.mLayout.addView(ayQ, getItemLength());
                scrollTo(getItemLength() * (this.afL + this.dCh), 0);
                this.mLayout.requestLayout();
            }
            if (getItemLength() >= this.cNf) {
                ayN();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(MetaData metaData) {
        Object tag;
        int childCount = this.mLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mLayout.getChildAt(i);
            if (childAt != this.dCi && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && metaData != null) {
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
            if (childAt != this.dCi && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && (name_show = ((MetaData) tag).getName_show()) != null) {
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
            if (!ayO()) {
                ayM();
            }
        }
    }

    private HeadImageView ayQ() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.afL, this.cbj);
        layoutParams.setMargins(this.dCh, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getItemLength() {
        return ayO() ? this.mLayout.getChildCount() - 1 : this.mLayout.getChildCount();
    }
}
