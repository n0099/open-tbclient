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
    private int afN;
    private final View.OnClickListener btC;
    private int cPc;
    private int cbV;
    private int dEe;
    private HeadImageView dEf;
    private a gHd;
    private final Context mContext;
    private LinearLayout mLayout;

    /* loaded from: classes.dex */
    public interface a {
        void b(View view, Object obj);
    }

    public AtSelectFriendList(Context context) {
        super(context);
        this.afN = -1;
        this.cbV = -1;
        this.dEe = -1;
        this.cPc = 4;
        this.btC = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtSelectFriendList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtSelectFriendList.this.mLayout.removeView(view);
                if (!AtSelectFriendList.this.azv()) {
                    AtSelectFriendList.this.azt();
                }
                if (AtSelectFriendList.this.gHd != null) {
                    AtSelectFriendList.this.gHd.b(view, view.getTag());
                }
            }
        };
        this.mContext = context;
        bg();
    }

    public AtSelectFriendList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.afN = -1;
        this.cbV = -1;
        this.dEe = -1;
        this.cPc = 4;
        this.btC = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtSelectFriendList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtSelectFriendList.this.mLayout.removeView(view);
                if (!AtSelectFriendList.this.azv()) {
                    AtSelectFriendList.this.azt();
                }
                if (AtSelectFriendList.this.gHd != null) {
                    AtSelectFriendList.this.gHd.b(view, view.getTag());
                }
            }
        };
        this.mContext = context;
        bg();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMaxCount(int i) {
        this.cPc = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setItemOPerationHandler(a aVar) {
        this.gHd = aVar;
    }

    private void bg() {
        this.afN = this.mContext.getResources().getDimensionPixelSize(d.f.ds80);
        this.cbV = this.mContext.getResources().getDimensionPixelSize(d.f.ds80);
        this.dEe = this.mContext.getResources().getDimensionPixelSize(d.f.ds12);
        this.mLayout = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.mLayout.setLayoutParams(layoutParams);
        this.mLayout.setHorizontalScrollBarEnabled(true);
        this.mLayout.setOrientation(0);
        azt();
        addView(this.mLayout);
        setSmoothScrollingEnabled(true);
        setFocusable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azt() {
        if (this.dEf == null) {
            this.dEf = azx();
            this.dEf.setDrawBorder(false);
        }
        this.dEf.setImageBitmap(ai.cS(d.g.icon_add_pop));
        this.mLayout.addView(this.dEf);
    }

    private void azu() {
        if (azv()) {
            this.mLayout.removeView(this.dEf);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean azv() {
        int childCount = this.mLayout.getChildCount();
        return childCount > 0 && this.mLayout.getChildAt(childCount + (-1)) == this.dEf;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(MetaData metaData) {
        if (getItemLength() < this.cPc) {
            HeadImageView azx = azx();
            azx.setIsRound(false);
            azx.c(metaData.getPortrait(), 12, false);
            if (azv()) {
                azx.setTag(metaData);
                azx.setOnClickListener(this.btC);
                this.mLayout.addView(azx, getItemLength());
                scrollTo(getItemLength() * (this.afN + this.dEe), 0);
                this.mLayout.requestLayout();
            }
            if (getItemLength() >= this.cPc) {
                azu();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(MetaData metaData) {
        Object tag;
        int childCount = this.mLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mLayout.getChildAt(i);
            if (childAt != this.dEf && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && metaData != null) {
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
            if (childAt != this.dEf && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && (name_show = ((MetaData) tag).getName_show()) != null) {
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
            if (!azv()) {
                azt();
            }
        }
    }

    private HeadImageView azx() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.afN, this.cbV);
        layoutParams.setMargins(this.dEe, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getItemLength() {
        return azv() ? this.mLayout.getChildCount() - 1 : this.mLayout.getChildCount();
    }
}
