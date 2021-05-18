package com.baidu.tieba.write.write;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HorizontalCustomScrollView;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class AtSelectFriendList extends HorizontalCustomScrollView {

    /* renamed from: f  reason: collision with root package name */
    public final Context f22039f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f22040g;

    /* renamed from: h  reason: collision with root package name */
    public int f22041h;

    /* renamed from: i  reason: collision with root package name */
    public int f22042i;
    public int j;
    public int k;
    public HeadImageView l;
    public b m;
    public final View.OnClickListener n;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AtSelectFriendList.this.f22040g.removeView(view);
            if (!AtSelectFriendList.this.h()) {
                AtSelectFriendList.this.j();
            }
            if (AtSelectFriendList.this.m != null) {
                AtSelectFriendList.this.m.a(view, view.getTag());
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a(View view, Object obj);
    }

    public AtSelectFriendList(Context context) {
        super(context);
        this.f22041h = -1;
        this.f22042i = -1;
        this.j = -1;
        this.k = 4;
        this.n = new a();
        this.f22039f = context;
        i();
    }

    public void e(MetaData metaData) {
        if (getItemLength() >= this.k) {
            return;
        }
        HeadImageView f2 = f();
        f2.setIsRound(false);
        f2.V(metaData.getAvater(), 12, false);
        if (h()) {
            f2.setTag(metaData);
            f2.setOnClickListener(this.n);
            this.f22040g.addView(f2, getItemLength());
            scrollTo(getItemLength() * (this.f22041h + this.j), 0);
            this.f22040g.requestLayout();
        }
        if (getItemLength() >= this.k) {
            l();
        }
    }

    public final HeadImageView f() {
        HeadImageView headImageView = new HeadImageView(this.f22039f);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.f22041h, this.f22042i);
        layoutParams.setMargins(this.j, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    public void g(MetaData metaData) {
        Object tag;
        int childCount = this.f22040g.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.f22040g.getChildAt(i2);
            if (childAt != this.l && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && metaData != null) {
                MetaData metaData2 = (MetaData) tag;
                if ((metaData2.getUserName() != null && metaData2.getUserName().equals(metaData.getUserName())) || (metaData2.getName_show() != null && metaData2.getName_show().equals(metaData.getName_show()))) {
                    metaData.setChecked(true);
                    childAt.setTag(metaData);
                    return;
                }
            }
        }
    }

    public ArrayList<String> getDataList() {
        Object tag;
        String name_show;
        int childCount = this.f22040g.getChildCount();
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.f22040g.getChildAt(i2);
            if (childAt != this.l && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && (name_show = ((MetaData) tag).getName_show()) != null) {
                arrayList.add(name_show);
            }
        }
        return arrayList;
    }

    public int getItemLength() {
        if (h()) {
            return this.f22040g.getChildCount() - 1;
        }
        return this.f22040g.getChildCount();
    }

    public final boolean h() {
        int childCount = this.f22040g.getChildCount();
        return childCount > 0 && this.f22040g.getChildAt(childCount - 1) == this.l;
    }

    public final void i() {
        this.f22041h = this.f22039f.getResources().getDimensionPixelSize(R.dimen.ds80);
        this.f22042i = this.f22039f.getResources().getDimensionPixelSize(R.dimen.ds80);
        this.j = this.f22039f.getResources().getDimensionPixelSize(R.dimen.ds12);
        this.f22040g = new LinearLayout(this.f22039f);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.f22040g.setLayoutParams(layoutParams);
        this.f22040g.setHorizontalScrollBarEnabled(true);
        this.f22040g.setOrientation(0);
        j();
        addView(this.f22040g);
        setSmoothScrollingEnabled(true);
        setFocusable(false);
    }

    public final void j() {
        if (this.l == null) {
            HeadImageView f2 = f();
            this.l = f2;
            f2.setDrawBorder(false);
        }
        this.l.setImageBitmap(SkinManager.getBitmap(R.drawable.icon_add_pop));
        this.f22040g.addView(this.l);
    }

    public void k(MetaData metaData) {
        View findViewWithTag = this.f22040g.findViewWithTag(metaData);
        if (findViewWithTag != null) {
            this.f22040g.removeView(findViewWithTag);
            if (h()) {
                return;
            }
            j();
        }
    }

    public final void l() {
        if (h()) {
            this.f22040g.removeView(this.l);
        }
    }

    public void setItemOPerationHandler(b bVar) {
        this.m = bVar;
    }

    public void setMaxCount(int i2) {
        this.k = i2;
    }

    public AtSelectFriendList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f22041h = -1;
        this.f22042i = -1;
        this.j = -1;
        this.k = 4;
        this.n = new a();
        this.f22039f = context;
        i();
    }
}
