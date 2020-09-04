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
    private final View.OnClickListener aBm;
    private LinearLayout jCg;
    private int jCh;
    private int jCi;
    private HeadImageView jCj;
    private final Context mContext;
    private int mItemHeight;
    private int mItemWidth;
    private a mTw;

    /* loaded from: classes3.dex */
    public interface a {
        void a(View view, Object obj);
    }

    public AtSelectFriendList(Context context) {
        super(context);
        this.mItemWidth = -1;
        this.mItemHeight = -1;
        this.jCh = -1;
        this.jCi = 4;
        this.aBm = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtSelectFriendList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtSelectFriendList.this.jCg.removeView(view);
                if (!AtSelectFriendList.this.cJb()) {
                    AtSelectFriendList.this.cIZ();
                }
                if (AtSelectFriendList.this.mTw != null) {
                    AtSelectFriendList.this.mTw.a(view, view.getTag());
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
        this.jCh = -1;
        this.jCi = 4;
        this.aBm = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtSelectFriendList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtSelectFriendList.this.jCg.removeView(view);
                if (!AtSelectFriendList.this.cJb()) {
                    AtSelectFriendList.this.cIZ();
                }
                if (AtSelectFriendList.this.mTw != null) {
                    AtSelectFriendList.this.mTw.a(view, view.getTag());
                }
            }
        };
        this.mContext = context;
        initialize();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMaxCount(int i) {
        this.jCi = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setItemOPerationHandler(a aVar) {
        this.mTw = aVar;
    }

    private void initialize() {
        this.mItemWidth = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds80);
        this.mItemHeight = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds80);
        this.jCh = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds12);
        this.jCg = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.jCg.setLayoutParams(layoutParams);
        this.jCg.setHorizontalScrollBarEnabled(true);
        this.jCg.setOrientation(0);
        cIZ();
        addView(this.jCg);
        setSmoothScrollingEnabled(true);
        setFocusable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cIZ() {
        if (this.jCj == null) {
            this.jCj = cJc();
            this.jCj.setDrawBorder(false);
        }
        this.jCj.setImageBitmap(ap.getBitmap(R.drawable.icon_add_pop));
        this.jCg.addView(this.jCj);
    }

    private void cJa() {
        if (cJb()) {
            this.jCg.removeView(this.jCj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cJb() {
        int childCount = this.jCg.getChildCount();
        return childCount > 0 && this.jCg.getChildAt(childCount + (-1)) == this.jCj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(MetaData metaData) {
        if (getItemLength() < this.jCi) {
            HeadImageView cJc = cJc();
            cJc.setIsRound(false);
            cJc.startLoad(metaData.getAvater(), 12, false);
            if (cJb()) {
                cJc.setTag(metaData);
                cJc.setOnClickListener(this.aBm);
                this.jCg.addView(cJc, getItemLength());
                scrollTo(getItemLength() * (this.mItemWidth + this.jCh), 0);
                this.jCg.requestLayout();
            }
            if (getItemLength() >= this.jCi) {
                cJa();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(MetaData metaData) {
        Object tag;
        int childCount = this.jCg.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.jCg.getChildAt(i);
            if (childAt != this.jCj && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && metaData != null) {
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
        int childCount = this.jCg.getChildCount();
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.jCg.getChildAt(i);
            if (childAt != this.jCj && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && (name_show = ((MetaData) tag).getName_show()) != null) {
                arrayList.add(name_show);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(MetaData metaData) {
        View findViewWithTag = this.jCg.findViewWithTag(metaData);
        if (findViewWithTag != null) {
            this.jCg.removeView(findViewWithTag);
            if (!cJb()) {
                cIZ();
            }
        }
    }

    private HeadImageView cJc() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.mItemWidth, this.mItemHeight);
        layoutParams.setMargins(this.jCh, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    public int getItemLength() {
        return cJb() ? this.jCg.getChildCount() - 1 : this.jCg.getChildCount();
    }
}
