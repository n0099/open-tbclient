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
    private final View.OnClickListener aFf;
    private LinearLayout kmf;
    private int kmg;
    private int kmh;
    private HeadImageView kmi;
    private final Context mContext;
    private int mItemHeight;
    private int mItemWidth;
    private a nFn;

    /* loaded from: classes3.dex */
    public interface a {
        void a(View view, Object obj);
    }

    public AtSelectFriendList(Context context) {
        super(context);
        this.mItemWidth = -1;
        this.mItemHeight = -1;
        this.kmg = -1;
        this.kmh = 4;
        this.aFf = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtSelectFriendList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtSelectFriendList.this.kmf.removeView(view);
                if (!AtSelectFriendList.this.cTw()) {
                    AtSelectFriendList.this.cTu();
                }
                if (AtSelectFriendList.this.nFn != null) {
                    AtSelectFriendList.this.nFn.a(view, view.getTag());
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
        this.kmg = -1;
        this.kmh = 4;
        this.aFf = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtSelectFriendList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtSelectFriendList.this.kmf.removeView(view);
                if (!AtSelectFriendList.this.cTw()) {
                    AtSelectFriendList.this.cTu();
                }
                if (AtSelectFriendList.this.nFn != null) {
                    AtSelectFriendList.this.nFn.a(view, view.getTag());
                }
            }
        };
        this.mContext = context;
        initialize();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMaxCount(int i) {
        this.kmh = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setItemOPerationHandler(a aVar) {
        this.nFn = aVar;
    }

    private void initialize() {
        this.mItemWidth = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds80);
        this.mItemHeight = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds80);
        this.kmg = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds12);
        this.kmf = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.kmf.setLayoutParams(layoutParams);
        this.kmf.setHorizontalScrollBarEnabled(true);
        this.kmf.setOrientation(0);
        cTu();
        addView(this.kmf);
        setSmoothScrollingEnabled(true);
        setFocusable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cTu() {
        if (this.kmi == null) {
            this.kmi = cTx();
            this.kmi.setDrawBorder(false);
        }
        this.kmi.setImageBitmap(ap.getBitmap(R.drawable.icon_add_pop));
        this.kmf.addView(this.kmi);
    }

    private void cTv() {
        if (cTw()) {
            this.kmf.removeView(this.kmi);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cTw() {
        int childCount = this.kmf.getChildCount();
        return childCount > 0 && this.kmf.getChildAt(childCount + (-1)) == this.kmi;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(MetaData metaData) {
        if (getItemLength() < this.kmh) {
            HeadImageView cTx = cTx();
            cTx.setIsRound(false);
            cTx.startLoad(metaData.getAvater(), 12, false);
            if (cTw()) {
                cTx.setTag(metaData);
                cTx.setOnClickListener(this.aFf);
                this.kmf.addView(cTx, getItemLength());
                scrollTo(getItemLength() * (this.mItemWidth + this.kmg), 0);
                this.kmf.requestLayout();
            }
            if (getItemLength() >= this.kmh) {
                cTv();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(MetaData metaData) {
        Object tag;
        int childCount = this.kmf.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.kmf.getChildAt(i);
            if (childAt != this.kmi && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && metaData != null) {
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
        int childCount = this.kmf.getChildCount();
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.kmf.getChildAt(i);
            if (childAt != this.kmi && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && (name_show = ((MetaData) tag).getName_show()) != null) {
                arrayList.add(name_show);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(MetaData metaData) {
        View findViewWithTag = this.kmf.findViewWithTag(metaData);
        if (findViewWithTag != null) {
            this.kmf.removeView(findViewWithTag);
            if (!cTw()) {
                cTu();
            }
        }
    }

    private HeadImageView cTx() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.mItemWidth, this.mItemHeight);
        layoutParams.setMargins(this.kmg, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    public int getItemLength() {
        return cTw() ? this.kmf.getChildCount() - 1 : this.kmf.getChildCount();
    }
}
