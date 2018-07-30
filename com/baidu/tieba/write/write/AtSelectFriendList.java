package com.baidu.tieba.write.write;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HorizontalCustomScrollView;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class AtSelectFriendList extends HorizontalCustomScrollView {
    private int aob;
    private final View.OnClickListener cas;
    private int eEZ;
    private int eFa;
    private HeadImageView eFb;
    private a hye;
    private final Context mContext;
    private int mItemHeight;
    private LinearLayout mLayout;

    /* loaded from: classes3.dex */
    public interface a {
        void b(View view, Object obj);
    }

    public AtSelectFriendList(Context context) {
        super(context);
        this.aob = -1;
        this.mItemHeight = -1;
        this.eEZ = -1;
        this.eFa = 4;
        this.cas = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtSelectFriendList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtSelectFriendList.this.mLayout.removeView(view);
                if (!AtSelectFriendList.this.aOl()) {
                    AtSelectFriendList.this.aOj();
                }
                if (AtSelectFriendList.this.hye != null) {
                    AtSelectFriendList.this.hye.b(view, view.getTag());
                }
            }
        };
        this.mContext = context;
        AF();
    }

    public AtSelectFriendList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aob = -1;
        this.mItemHeight = -1;
        this.eEZ = -1;
        this.eFa = 4;
        this.cas = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtSelectFriendList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtSelectFriendList.this.mLayout.removeView(view);
                if (!AtSelectFriendList.this.aOl()) {
                    AtSelectFriendList.this.aOj();
                }
                if (AtSelectFriendList.this.hye != null) {
                    AtSelectFriendList.this.hye.b(view, view.getTag());
                }
            }
        };
        this.mContext = context;
        AF();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMaxCount(int i) {
        this.eFa = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setItemOPerationHandler(a aVar) {
        this.hye = aVar;
    }

    private void AF() {
        this.aob = this.mContext.getResources().getDimensionPixelSize(d.e.ds80);
        this.mItemHeight = this.mContext.getResources().getDimensionPixelSize(d.e.ds80);
        this.eEZ = this.mContext.getResources().getDimensionPixelSize(d.e.ds12);
        this.mLayout = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.mLayout.setLayoutParams(layoutParams);
        this.mLayout.setHorizontalScrollBarEnabled(true);
        this.mLayout.setOrientation(0);
        aOj();
        addView(this.mLayout);
        setSmoothScrollingEnabled(true);
        setFocusable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOj() {
        if (this.eFb == null) {
            this.eFb = aOn();
            this.eFb.setDrawBorder(false);
        }
        this.eFb.setImageBitmap(am.cT(d.f.icon_add_pop));
        this.mLayout.addView(this.eFb);
    }

    private void aOk() {
        if (aOl()) {
            this.mLayout.removeView(this.eFb);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aOl() {
        int childCount = this.mLayout.getChildCount();
        return childCount > 0 && this.mLayout.getChildAt(childCount + (-1)) == this.eFb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(MetaData metaData) {
        if (getItemLength() < this.eFa) {
            HeadImageView aOn = aOn();
            aOn.setIsRound(false);
            aOn.startLoad(metaData.getPortrait(), 12, false);
            if (aOl()) {
                aOn.setTag(metaData);
                aOn.setOnClickListener(this.cas);
                this.mLayout.addView(aOn, getItemLength());
                scrollTo(getItemLength() * (this.aob + this.eEZ), 0);
                this.mLayout.requestLayout();
            }
            if (getItemLength() >= this.eFa) {
                aOk();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(MetaData metaData) {
        Object tag;
        int childCount = this.mLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mLayout.getChildAt(i);
            if (childAt != this.eFb && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && metaData != null) {
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
            if (childAt != this.eFb && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && (name_show = ((MetaData) tag).getName_show()) != null) {
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
            if (!aOl()) {
                aOj();
            }
        }
    }

    private HeadImageView aOn() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.aob, this.mItemHeight);
        layoutParams.setMargins(this.eEZ, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getItemLength() {
        return aOl() ? this.mLayout.getChildCount() - 1 : this.mLayout.getChildCount();
    }
}
