package com.baidu.tieba.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tbadk.widget.TbImageView;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class UserIconBox extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    com.baidu.tbadk.imageManager.c f2551a;
    private com.baidu.adp.lib.d.b<TbImageView> b;
    private bt c;
    private Context d;
    private com.baidu.tieba.util.i e;
    private LinearLayout.LayoutParams f;
    private View.OnClickListener g;

    public UserIconBox(Context context) {
        super(context);
        this.b = null;
        this.c = null;
        this.g = null;
        this.f2551a = new br(this);
        a(context);
    }

    public UserIconBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = null;
        this.c = null;
        this.g = null;
        this.f2551a = new br(this);
        a(context);
    }

    private void a(Context context) {
        this.d = context;
        setOrientation(0);
        setGravity(16);
        this.e = new com.baidu.tieba.util.i(this.d);
        if (this.d instanceof bu) {
            bu buVar = (bu) this.d;
            this.b = buVar.G();
            if (buVar.c() != null && this.c == null) {
                this.c = new bt(buVar.a());
                buVar.c().setRecyclerListener(this.c);
            }
        }
        setOnHierarchyChangeListener(new bq(this));
    }

    public LinearLayout.LayoutParams a(int i, int i2, int i3) {
        this.f = new LinearLayout.LayoutParams(i, i2);
        this.f.leftMargin = i3;
        return this.f;
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        this.g = onClickListener;
    }

    public void a(LinkedList<com.baidu.tieba.data.aa> linkedList, int i, int i2, int i3, int i4) {
        removeAllViews();
        if (linkedList != null && linkedList.size() > 0) {
            this.e.a(i2, i3);
            LinearLayout.LayoutParams a2 = a(i2, i3, i4);
            setVisibility(0);
            for (int i5 = 0; i5 < i && i5 < linkedList.size(); i5++) {
                TbImageView b = b(this.d);
                if (b != null) {
                    b.setLayoutParams(a2);
                    b.setTag(linkedList.get(i5).a());
                    this.e.e(linkedList.get(i5).a(), this.f2551a);
                    addView(b);
                }
                if (this.g != null) {
                    b.setOnClickListener(this.g);
                }
            }
            return;
        }
        setVisibility(8);
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
        return new com.baidu.adp.lib.d.b<>(new bs(context), i, 0);
    }
}
