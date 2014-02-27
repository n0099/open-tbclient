package com.baidu.tieba.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.widget.TbImageView;
import java.util.List;
/* loaded from: classes.dex */
public class UserIconBox extends LinearLayout {
    com.baidu.tbadk.imageManager.d a;
    private com.baidu.adp.lib.d.b<TbImageView> b;
    private de c;
    private Context d;
    private com.baidu.tieba.util.i e;
    private LinearLayout.LayoutParams f;
    private View.OnClickListener g;

    public UserIconBox(Context context) {
        super(context);
        this.b = null;
        this.c = null;
        this.g = null;
        this.a = new da(this);
        a(context);
    }

    public UserIconBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = null;
        this.c = null;
        this.g = null;
        this.a = new da(this);
        a(context);
    }

    private void a(Context context) {
        this.d = context;
        setOrientation(0);
        setGravity(16);
        this.e = new com.baidu.tieba.util.i(this.d);
        if (this.d instanceof df) {
            df dfVar = (df) this.d;
            this.b = dfVar.b();
            if (dfVar.c() != null && this.c == null) {
                this.c = new de(dfVar.a());
                dfVar.c().setRecyclerListener(this.c);
            }
        }
        setOnHierarchyChangeListener(new dc(this));
    }

    private LinearLayout.LayoutParams a(int i, int i2, int i3) {
        this.f = new LinearLayout.LayoutParams(i, i2);
        this.f.leftMargin = i3;
        return this.f;
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        this.g = onClickListener;
    }

    public final void a(List<IconData> list, int i, int i2, int i3, int i4, boolean z) {
        removeAllViews();
        if (list == null || list.size() != 1 || !TextUtils.isEmpty(list.get(0).getIcon())) {
            if (list != null && list.size() > 0) {
                this.e.a(i2, i3);
                LinearLayout.LayoutParams a = a(i2, i3, i4);
                LinearLayout.LayoutParams a2 = a(i2, i3, 0);
                setVisibility(0);
                for (int i5 = 0; i5 < i && i5 < list.size(); i5++) {
                    Context context = this.d;
                    TbImageView a3 = this.b != null ? this.b.a() : null;
                    TbImageView tbImageView = (a3 == null || a3.getParent() != null) ? new TbImageView(context) : a3;
                    if (tbImageView != null) {
                        if (i5 == 0 && z) {
                            tbImageView.setLayoutParams(a2);
                        } else {
                            tbImageView.setLayoutParams(a);
                        }
                        tbImageView.setTag(list.get(i5).getIcon());
                        tbImageView.setClickable(false);
                        this.e.e(list.get(i5).getIcon(), this.a);
                        addView(tbImageView);
                        tbImageView.invalidate();
                    }
                }
                return;
            }
            setVisibility(8);
        }
    }

    public final void a(List<IconData> list, int i, int i2, int i3, int i4) {
        a(list, i, i2, i3, i4, false);
    }

    public static com.baidu.adp.lib.d.b<TbImageView> a(Context context, int i) {
        return new com.baidu.adp.lib.d.b<>(new dd(context), 8, 0);
    }
}
