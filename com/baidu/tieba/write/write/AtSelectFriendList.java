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
import com.baidu.tieba.e;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class AtSelectFriendList extends HorizontalCustomScrollView {
    private int aAo;
    private final View.OnClickListener cud;
    private int ffF;
    private int ffG;
    private HeadImageView ffH;
    private a ibc;
    private final Context mContext;
    private int mItemHeight;
    private LinearLayout mLayout;

    /* loaded from: classes3.dex */
    public interface a {
        void b(View view, Object obj);
    }

    public AtSelectFriendList(Context context) {
        super(context);
        this.aAo = -1;
        this.mItemHeight = -1;
        this.ffF = -1;
        this.ffG = 4;
        this.cud = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtSelectFriendList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtSelectFriendList.this.mLayout.removeView(view);
                if (!AtSelectFriendList.this.aWn()) {
                    AtSelectFriendList.this.aWl();
                }
                if (AtSelectFriendList.this.ibc != null) {
                    AtSelectFriendList.this.ibc.b(view, view.getTag());
                }
            }
        };
        this.mContext = context;
        initialize();
    }

    public AtSelectFriendList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aAo = -1;
        this.mItemHeight = -1;
        this.ffF = -1;
        this.ffG = 4;
        this.cud = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtSelectFriendList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtSelectFriendList.this.mLayout.removeView(view);
                if (!AtSelectFriendList.this.aWn()) {
                    AtSelectFriendList.this.aWl();
                }
                if (AtSelectFriendList.this.ibc != null) {
                    AtSelectFriendList.this.ibc.b(view, view.getTag());
                }
            }
        };
        this.mContext = context;
        initialize();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMaxCount(int i) {
        this.ffG = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setItemOPerationHandler(a aVar) {
        this.ibc = aVar;
    }

    private void initialize() {
        this.aAo = this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds80);
        this.mItemHeight = this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds80);
        this.ffF = this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds12);
        this.mLayout = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.mLayout.setLayoutParams(layoutParams);
        this.mLayout.setHorizontalScrollBarEnabled(true);
        this.mLayout.setOrientation(0);
        aWl();
        addView(this.mLayout);
        setSmoothScrollingEnabled(true);
        setFocusable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWl() {
        if (this.ffH == null) {
            this.ffH = aWp();
            this.ffH.setDrawBorder(false);
        }
        this.ffH.setImageBitmap(al.dO(e.f.icon_add_pop));
        this.mLayout.addView(this.ffH);
    }

    private void aWm() {
        if (aWn()) {
            this.mLayout.removeView(this.ffH);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aWn() {
        int childCount = this.mLayout.getChildCount();
        return childCount > 0 && this.mLayout.getChildAt(childCount + (-1)) == this.ffH;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(MetaData metaData) {
        if (getItemLength() < this.ffG) {
            HeadImageView aWp = aWp();
            aWp.setIsRound(false);
            aWp.startLoad(metaData.getPortrait(), 12, false);
            if (aWn()) {
                aWp.setTag(metaData);
                aWp.setOnClickListener(this.cud);
                this.mLayout.addView(aWp, getItemLength());
                scrollTo(getItemLength() * (this.aAo + this.ffF), 0);
                this.mLayout.requestLayout();
            }
            if (getItemLength() >= this.ffG) {
                aWm();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(MetaData metaData) {
        Object tag;
        int childCount = this.mLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mLayout.getChildAt(i);
            if (childAt != this.ffH && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && metaData != null) {
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
            if (childAt != this.ffH && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && (name_show = ((MetaData) tag).getName_show()) != null) {
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
            if (!aWn()) {
                aWl();
            }
        }
    }

    private HeadImageView aWp() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.aAo, this.mItemHeight);
        layoutParams.setMargins(this.ffF, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getItemLength() {
        return aWn() ? this.mLayout.getChildCount() - 1 : this.mLayout.getChildCount();
    }
}
