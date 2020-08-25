package com.baidu.tieba.write.write;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HorizontalCustomScrollView;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class AtSelectFriendList extends HorizontalCustomScrollView {
    private final View.OnClickListener aBk;
    private LinearLayout jCa;
    private int jCb;
    private int jCc;
    private HeadImageView jCd;
    private final Context mContext;
    private int mItemHeight;
    private int mItemWidth;
    private a mTc;

    /* loaded from: classes3.dex */
    public interface a {
        void a(View view, Object obj);
    }

    public AtSelectFriendList(Context context) {
        super(context);
        this.mItemWidth = -1;
        this.mItemHeight = -1;
        this.jCb = -1;
        this.jCc = 4;
        this.aBk = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtSelectFriendList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtSelectFriendList.this.jCa.removeView(view);
                if (!AtSelectFriendList.this.cJa()) {
                    AtSelectFriendList.this.cIY();
                }
                if (AtSelectFriendList.this.mTc != null) {
                    AtSelectFriendList.this.mTc.a(view, view.getTag());
                }
            }
        };
        this.mContext = context;
        initialize();
    }

    public AtSelectFriendList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mItemWidth = -1;
        this.mItemHeight = -1;
        this.jCb = -1;
        this.jCc = 4;
        this.aBk = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtSelectFriendList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtSelectFriendList.this.jCa.removeView(view);
                if (!AtSelectFriendList.this.cJa()) {
                    AtSelectFriendList.this.cIY();
                }
                if (AtSelectFriendList.this.mTc != null) {
                    AtSelectFriendList.this.mTc.a(view, view.getTag());
                }
            }
        };
        this.mContext = context;
        initialize();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMaxCount(int i) {
        this.jCc = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setItemOPerationHandler(a aVar) {
        this.mTc = aVar;
    }

    private void initialize() {
        this.mItemWidth = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds80);
        this.mItemHeight = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds80);
        this.jCb = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds12);
        this.jCa = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.jCa.setLayoutParams(layoutParams);
        this.jCa.setHorizontalScrollBarEnabled(true);
        this.jCa.setOrientation(0);
        cIY();
        addView(this.jCa);
        setSmoothScrollingEnabled(true);
        setFocusable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cIY() {
        if (this.jCd == null) {
            this.jCd = cJb();
            this.jCd.setDrawBorder(false);
        }
        this.jCd.setImageBitmap(ap.getBitmap(R.drawable.icon_add_pop));
        this.jCa.addView(this.jCd);
    }

    private void cIZ() {
        if (cJa()) {
            this.jCa.removeView(this.jCd);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cJa() {
        int childCount = this.jCa.getChildCount();
        return childCount > 0 && this.jCa.getChildAt(childCount + (-1)) == this.jCd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(MetaData metaData) {
        if (getItemLength() < this.jCc) {
            HeadImageView cJb = cJb();
            cJb.setIsRound(false);
            cJb.startLoad(metaData.getAvater(), 12, false);
            if (cJa()) {
                cJb.setTag(metaData);
                cJb.setOnClickListener(this.aBk);
                this.jCa.addView(cJb, getItemLength());
                scrollTo(getItemLength() * (this.mItemWidth + this.jCb), 0);
                this.jCa.requestLayout();
            }
            if (getItemLength() >= this.jCc) {
                cIZ();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(MetaData metaData) {
        Object tag;
        int childCount = this.jCa.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.jCa.getChildAt(i);
            if (childAt != this.jCd && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && metaData != null) {
                MetaData metaData2 = (MetaData) tag;
                if ((metaData2.getUserName() != null && metaData2.getUserName().equals(metaData.getUserName())) || (metaData2.getName_show() != null && metaData2.getName_show().equals(metaData.getName_show()))) {
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
        int childCount = this.jCa.getChildCount();
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.jCa.getChildAt(i);
            if (childAt != this.jCd && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && (name_show = ((MetaData) tag).getName_show()) != null) {
                arrayList.add(name_show);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(MetaData metaData) {
        View findViewWithTag = this.jCa.findViewWithTag(metaData);
        if (findViewWithTag != null) {
            this.jCa.removeView(findViewWithTag);
            if (!cJa()) {
                cIY();
            }
        }
    }

    private HeadImageView cJb() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.mItemWidth, this.mItemHeight);
        layoutParams.setMargins(this.jCb, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    public int getItemLength() {
        return cJa() ? this.jCa.getChildCount() - 1 : this.jCa.getChildCount();
    }
}
