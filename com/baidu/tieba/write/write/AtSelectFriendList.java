package com.baidu.tieba.write.write;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HorizontalCustomScrollView;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class AtSelectFriendList extends HorizontalCustomScrollView {
    private int bPX;
    private final View.OnClickListener dSP;
    private int gMQ;
    private int gMR;
    private HeadImageView gMS;
    private a jKV;
    private final Context mContext;
    private int mItemHeight;
    private LinearLayout mLayout;

    /* loaded from: classes3.dex */
    public interface a {
        void b(View view, Object obj);
    }

    public AtSelectFriendList(Context context) {
        super(context);
        this.bPX = -1;
        this.mItemHeight = -1;
        this.gMQ = -1;
        this.gMR = 4;
        this.dSP = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtSelectFriendList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtSelectFriendList.this.mLayout.removeView(view);
                if (!AtSelectFriendList.this.bEB()) {
                    AtSelectFriendList.this.bEz();
                }
                if (AtSelectFriendList.this.jKV != null) {
                    AtSelectFriendList.this.jKV.b(view, view.getTag());
                }
            }
        };
        this.mContext = context;
        initialize();
    }

    public AtSelectFriendList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bPX = -1;
        this.mItemHeight = -1;
        this.gMQ = -1;
        this.gMR = 4;
        this.dSP = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtSelectFriendList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtSelectFriendList.this.mLayout.removeView(view);
                if (!AtSelectFriendList.this.bEB()) {
                    AtSelectFriendList.this.bEz();
                }
                if (AtSelectFriendList.this.jKV != null) {
                    AtSelectFriendList.this.jKV.b(view, view.getTag());
                }
            }
        };
        this.mContext = context;
        initialize();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMaxCount(int i) {
        this.gMR = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setItemOPerationHandler(a aVar) {
        this.jKV = aVar;
    }

    private void initialize() {
        this.bPX = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds80);
        this.mItemHeight = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds80);
        this.gMQ = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds12);
        this.mLayout = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.mLayout.setLayoutParams(layoutParams);
        this.mLayout.setHorizontalScrollBarEnabled(true);
        this.mLayout.setOrientation(0);
        bEz();
        addView(this.mLayout);
        setSmoothScrollingEnabled(true);
        setFocusable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEz() {
        if (this.gMS == null) {
            this.gMS = bED();
            this.gMS.setDrawBorder(false);
        }
        this.gMS.setImageBitmap(al.id(R.drawable.icon_add_pop));
        this.mLayout.addView(this.gMS);
    }

    private void bEA() {
        if (bEB()) {
            this.mLayout.removeView(this.gMS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bEB() {
        int childCount = this.mLayout.getChildCount();
        return childCount > 0 && this.mLayout.getChildAt(childCount + (-1)) == this.gMS;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(MetaData metaData) {
        if (getItemLength() < this.gMR) {
            HeadImageView bED = bED();
            bED.setIsRound(false);
            bED.startLoad(metaData.getPortrait(), 12, false);
            if (bEB()) {
                bED.setTag(metaData);
                bED.setOnClickListener(this.dSP);
                this.mLayout.addView(bED, getItemLength());
                scrollTo(getItemLength() * (this.bPX + this.gMQ), 0);
                this.mLayout.requestLayout();
            }
            if (getItemLength() >= this.gMR) {
                bEA();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(MetaData metaData) {
        Object tag;
        int childCount = this.mLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mLayout.getChildAt(i);
            if (childAt != this.gMS && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && metaData != null) {
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
        int childCount = this.mLayout.getChildCount();
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mLayout.getChildAt(i);
            if (childAt != this.gMS && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && (name_show = ((MetaData) tag).getName_show()) != null) {
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
            if (!bEB()) {
                bEz();
            }
        }
    }

    private HeadImageView bED() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.bPX, this.mItemHeight);
        layoutParams.setMargins(this.gMQ, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getItemLength() {
        return bEB() ? this.mLayout.getChildCount() - 1 : this.mLayout.getChildCount();
    }
}
