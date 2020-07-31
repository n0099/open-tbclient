package com.baidu.tieba.write.write;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HorizontalCustomScrollView;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class AtSelectFriendList extends HorizontalCustomScrollView {
    private final View.OnClickListener awi;
    private LinearLayout jna;
    private int jnb;
    private int jnc;
    private HeadImageView jnd;
    private a mAH;
    private final Context mContext;
    private int mItemHeight;
    private int mItemWidth;

    /* loaded from: classes3.dex */
    public interface a {
        void a(View view, Object obj);
    }

    public AtSelectFriendList(Context context) {
        super(context);
        this.mItemWidth = -1;
        this.mItemHeight = -1;
        this.jnb = -1;
        this.jnc = 4;
        this.awi = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtSelectFriendList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtSelectFriendList.this.jna.removeView(view);
                if (!AtSelectFriendList.this.cyj()) {
                    AtSelectFriendList.this.cyh();
                }
                if (AtSelectFriendList.this.mAH != null) {
                    AtSelectFriendList.this.mAH.a(view, view.getTag());
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
        this.jnb = -1;
        this.jnc = 4;
        this.awi = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtSelectFriendList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtSelectFriendList.this.jna.removeView(view);
                if (!AtSelectFriendList.this.cyj()) {
                    AtSelectFriendList.this.cyh();
                }
                if (AtSelectFriendList.this.mAH != null) {
                    AtSelectFriendList.this.mAH.a(view, view.getTag());
                }
            }
        };
        this.mContext = context;
        initialize();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMaxCount(int i) {
        this.jnc = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setItemOPerationHandler(a aVar) {
        this.mAH = aVar;
    }

    private void initialize() {
        this.mItemWidth = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds80);
        this.mItemHeight = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds80);
        this.jnb = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds12);
        this.jna = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.jna.setLayoutParams(layoutParams);
        this.jna.setHorizontalScrollBarEnabled(true);
        this.jna.setOrientation(0);
        cyh();
        addView(this.jna);
        setSmoothScrollingEnabled(true);
        setFocusable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyh() {
        if (this.jnd == null) {
            this.jnd = cyk();
            this.jnd.setDrawBorder(false);
        }
        this.jnd.setImageBitmap(ao.getBitmap(R.drawable.icon_add_pop));
        this.jna.addView(this.jnd);
    }

    private void cyi() {
        if (cyj()) {
            this.jna.removeView(this.jnd);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cyj() {
        int childCount = this.jna.getChildCount();
        return childCount > 0 && this.jna.getChildAt(childCount + (-1)) == this.jnd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(MetaData metaData) {
        if (getItemLength() < this.jnc) {
            HeadImageView cyk = cyk();
            cyk.setIsRound(false);
            cyk.startLoad(metaData.getAvater(), 12, false);
            if (cyj()) {
                cyk.setTag(metaData);
                cyk.setOnClickListener(this.awi);
                this.jna.addView(cyk, getItemLength());
                scrollTo(getItemLength() * (this.mItemWidth + this.jnb), 0);
                this.jna.requestLayout();
            }
            if (getItemLength() >= this.jnc) {
                cyi();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(MetaData metaData) {
        Object tag;
        int childCount = this.jna.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.jna.getChildAt(i);
            if (childAt != this.jnd && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && metaData != null) {
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
        int childCount = this.jna.getChildCount();
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.jna.getChildAt(i);
            if (childAt != this.jnd && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && (name_show = ((MetaData) tag).getName_show()) != null) {
                arrayList.add(name_show);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(MetaData metaData) {
        View findViewWithTag = this.jna.findViewWithTag(metaData);
        if (findViewWithTag != null) {
            this.jna.removeView(findViewWithTag);
            if (!cyj()) {
                cyh();
            }
        }
    }

    private HeadImageView cyk() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.mItemWidth, this.mItemHeight);
        layoutParams.setMargins(this.jnb, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    public int getItemLength() {
        return cyj() ? this.jna.getChildCount() - 1 : this.jna.getChildCount();
    }
}
