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
    private LinearLayout jnc;
    private int jnd;
    private int jne;
    private HeadImageView jnf;
    private a mAJ;
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
        this.jnd = -1;
        this.jne = 4;
        this.awi = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtSelectFriendList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtSelectFriendList.this.jnc.removeView(view);
                if (!AtSelectFriendList.this.cyj()) {
                    AtSelectFriendList.this.cyh();
                }
                if (AtSelectFriendList.this.mAJ != null) {
                    AtSelectFriendList.this.mAJ.a(view, view.getTag());
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
        this.jnd = -1;
        this.jne = 4;
        this.awi = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtSelectFriendList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtSelectFriendList.this.jnc.removeView(view);
                if (!AtSelectFriendList.this.cyj()) {
                    AtSelectFriendList.this.cyh();
                }
                if (AtSelectFriendList.this.mAJ != null) {
                    AtSelectFriendList.this.mAJ.a(view, view.getTag());
                }
            }
        };
        this.mContext = context;
        initialize();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMaxCount(int i) {
        this.jne = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setItemOPerationHandler(a aVar) {
        this.mAJ = aVar;
    }

    private void initialize() {
        this.mItemWidth = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds80);
        this.mItemHeight = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds80);
        this.jnd = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds12);
        this.jnc = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.jnc.setLayoutParams(layoutParams);
        this.jnc.setHorizontalScrollBarEnabled(true);
        this.jnc.setOrientation(0);
        cyh();
        addView(this.jnc);
        setSmoothScrollingEnabled(true);
        setFocusable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyh() {
        if (this.jnf == null) {
            this.jnf = cyk();
            this.jnf.setDrawBorder(false);
        }
        this.jnf.setImageBitmap(ao.getBitmap(R.drawable.icon_add_pop));
        this.jnc.addView(this.jnf);
    }

    private void cyi() {
        if (cyj()) {
            this.jnc.removeView(this.jnf);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cyj() {
        int childCount = this.jnc.getChildCount();
        return childCount > 0 && this.jnc.getChildAt(childCount + (-1)) == this.jnf;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(MetaData metaData) {
        if (getItemLength() < this.jne) {
            HeadImageView cyk = cyk();
            cyk.setIsRound(false);
            cyk.startLoad(metaData.getAvater(), 12, false);
            if (cyj()) {
                cyk.setTag(metaData);
                cyk.setOnClickListener(this.awi);
                this.jnc.addView(cyk, getItemLength());
                scrollTo(getItemLength() * (this.mItemWidth + this.jnd), 0);
                this.jnc.requestLayout();
            }
            if (getItemLength() >= this.jne) {
                cyi();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(MetaData metaData) {
        Object tag;
        int childCount = this.jnc.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.jnc.getChildAt(i);
            if (childAt != this.jnf && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && metaData != null) {
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
        int childCount = this.jnc.getChildCount();
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.jnc.getChildAt(i);
            if (childAt != this.jnf && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && (name_show = ((MetaData) tag).getName_show()) != null) {
                arrayList.add(name_show);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(MetaData metaData) {
        View findViewWithTag = this.jnc.findViewWithTag(metaData);
        if (findViewWithTag != null) {
            this.jnc.removeView(findViewWithTag);
            if (!cyj()) {
                cyh();
            }
        }
    }

    private HeadImageView cyk() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.mItemWidth, this.mItemHeight);
        layoutParams.setMargins(this.jnd, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    public int getItemLength() {
        return cyj() ? this.jnc.getChildCount() - 1 : this.jnc.getChildCount();
    }
}
