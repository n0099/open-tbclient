package com.baidu.tieba.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.data.IconData;
import java.util.List;
/* loaded from: classes.dex */
public class UserIconBox extends LinearLayout {
    com.baidu.tbadk.imageManager.c a;
    private com.baidu.adp.lib.d.b<TbImageView> b;
    private cy c;
    private Context d;
    private com.baidu.tieba.util.i e;
    private LinearLayout.LayoutParams f;
    private View.OnClickListener g;

    public UserIconBox(Context context) {
        super(context);
        this.b = null;
        this.c = null;
        this.g = null;
        this.a = new cw(this);
        a(context);
    }

    public UserIconBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = null;
        this.c = null;
        this.g = null;
        this.a = new cw(this);
        a(context);
    }

    private void a(Context context) {
        this.d = context;
        setOrientation(0);
        setGravity(16);
        this.e = new com.baidu.tieba.util.i(this.d);
        if (this.d instanceof cz) {
            cz czVar = (cz) this.d;
            this.b = czVar.G();
            if (czVar.c() != null && this.c == null) {
                this.c = new cy(czVar.a());
                czVar.c().setRecyclerListener(this.c);
            }
        }
        setOnHierarchyChangeListener(new cv(this));
    }

    private LinearLayout.LayoutParams a(int i, int i2, int i3) {
        this.f = new LinearLayout.LayoutParams(i, i2);
        this.f.leftMargin = i3;
        return this.f;
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        this.g = onClickListener;
    }

    public void a(List<IconData> list, int i, int i2, int i3, int i4, boolean z) {
        removeAllViews();
        if (list == null || list.size() != 1 || !TextUtils.isEmpty(list.get(0).getIcon())) {
            if (list != null && list.size() > 0) {
                this.e.a(i2, i3);
                LinearLayout.LayoutParams a = a(i2, i3, i4);
                LinearLayout.LayoutParams a2 = a(i2, i3, 0);
                setVisibility(0);
                for (int i5 = 0; i5 < i && i5 < list.size(); i5++) {
                    TbImageView b = b(this.d);
                    if (b != null) {
                        if (i5 == 0 && z) {
                            b.setLayoutParams(a2);
                        } else {
                            b.setLayoutParams(a);
                        }
                        b.setTag(list.get(i5).getIcon());
                        b.setClickable(false);
                        this.e.e(list.get(i5).getIcon(), this.a);
                        addView(b);
                    }
                }
                return;
            }
            setVisibility(8);
        }
    }

    public void a(List<IconData> list, int i, int i2, int i3, int i4) {
        a(list, i, i2, i3, i4, false);
    }

    private TbImageView b(Context context) {
        TbImageView tbImageView = null;
        if (this.b != null) {
            tbImageView = this.b.a();
        }
        if (tbImageView == null || tbImageView.getParent() != null) {
            return new TbImageView(context);
        }
        return tbImageView;
    }

    public static com.baidu.adp.lib.d.b<TbImageView> a(Context context, int i) {
        return new com.baidu.adp.lib.d.b<>(new cx(context), i, 0);
    }
}
