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
    private int aeq;
    private final View.OnClickListener bsc;
    private int cLK;
    private int cad;
    private int dAQ;
    private HeadImageView dAR;
    private a gEa;
    private final Context mContext;
    private LinearLayout mLayout;

    /* loaded from: classes.dex */
    public interface a {
        void b(View view, Object obj);
    }

    public AtSelectFriendList(Context context) {
        super(context);
        this.aeq = -1;
        this.cad = -1;
        this.dAQ = -1;
        this.cLK = 4;
        this.bsc = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtSelectFriendList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtSelectFriendList.this.mLayout.removeView(view);
                if (!AtSelectFriendList.this.ayD()) {
                    AtSelectFriendList.this.ayB();
                }
                if (AtSelectFriendList.this.gEa != null) {
                    AtSelectFriendList.this.gEa.b(view, view.getTag());
                }
            }
        };
        this.mContext = context;
        wU();
    }

    public AtSelectFriendList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aeq = -1;
        this.cad = -1;
        this.dAQ = -1;
        this.cLK = 4;
        this.bsc = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtSelectFriendList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtSelectFriendList.this.mLayout.removeView(view);
                if (!AtSelectFriendList.this.ayD()) {
                    AtSelectFriendList.this.ayB();
                }
                if (AtSelectFriendList.this.gEa != null) {
                    AtSelectFriendList.this.gEa.b(view, view.getTag());
                }
            }
        };
        this.mContext = context;
        wU();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMaxCount(int i) {
        this.cLK = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setItemOPerationHandler(a aVar) {
        this.gEa = aVar;
    }

    private void wU() {
        this.aeq = this.mContext.getResources().getDimensionPixelSize(d.f.ds80);
        this.cad = this.mContext.getResources().getDimensionPixelSize(d.f.ds80);
        this.dAQ = this.mContext.getResources().getDimensionPixelSize(d.f.ds12);
        this.mLayout = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.mLayout.setLayoutParams(layoutParams);
        this.mLayout.setHorizontalScrollBarEnabled(true);
        this.mLayout.setOrientation(0);
        ayB();
        addView(this.mLayout);
        setSmoothScrollingEnabled(true);
        setFocusable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayB() {
        if (this.dAR == null) {
            this.dAR = ayF();
            this.dAR.setDrawBorder(false);
        }
        this.dAR.setImageBitmap(ai.cQ(d.g.icon_add_pop));
        this.mLayout.addView(this.dAR);
    }

    private void ayC() {
        if (ayD()) {
            this.mLayout.removeView(this.dAR);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ayD() {
        int childCount = this.mLayout.getChildCount();
        return childCount > 0 && this.mLayout.getChildAt(childCount + (-1)) == this.dAR;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(MetaData metaData) {
        if (getItemLength() < this.cLK) {
            HeadImageView ayF = ayF();
            ayF.setIsRound(false);
            ayF.c(metaData.getPortrait(), 12, false);
            if (ayD()) {
                ayF.setTag(metaData);
                ayF.setOnClickListener(this.bsc);
                this.mLayout.addView(ayF, getItemLength());
                scrollTo(getItemLength() * (this.aeq + this.dAQ), 0);
                this.mLayout.requestLayout();
            }
            if (getItemLength() >= this.cLK) {
                ayC();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(MetaData metaData) {
        Object tag;
        int childCount = this.mLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mLayout.getChildAt(i);
            if (childAt != this.dAR && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && metaData != null) {
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
            if (childAt != this.dAR && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && (name_show = ((MetaData) tag).getName_show()) != null) {
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
            if (!ayD()) {
                ayB();
            }
        }
    }

    private HeadImageView ayF() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.aeq, this.cad);
        layoutParams.setMargins(this.dAQ, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getItemLength() {
        return ayD() ? this.mLayout.getChildCount() - 1 : this.mLayout.getChildCount();
    }
}
