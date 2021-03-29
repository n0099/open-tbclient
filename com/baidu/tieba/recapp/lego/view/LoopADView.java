package com.baidu.tieba.recapp.lego.view;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.lego.model.AdCard;
import d.b.b.e.p.l;
/* loaded from: classes5.dex */
public class LoopADView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public Context f20778e;

    /* renamed from: f  reason: collision with root package name */
    public a f20779f;

    /* renamed from: g  reason: collision with root package name */
    public int f20780g;

    /* renamed from: h  reason: collision with root package name */
    public int f20781h;
    public Resources i;
    public AdCard.d[] j;
    public int k;

    /* loaded from: classes5.dex */
    public enum ItemType {
        WITH_BOTTOM_TITLE,
        WITHOUT_BOTTOM_TITLE
    }

    /* loaded from: classes5.dex */
    public interface a {
        void a(TbImageView tbImageView, AdCard.b bVar);

        String b(String str);

        void reset();
    }

    public LoopADView(Context context) {
        this(context, null);
    }

    public final void a(float f2, float f3, int i) {
        float dimension;
        float f4 = f2 / f3;
        int i2 = this.k;
        if (i2 != 1 && i2 != 2) {
            dimension = i2 == 4 ? this.i.getDimension(R.dimen.ds40) + this.i.getDimension(R.dimen.ds60) + this.i.getDimension(R.dimen.ds16) : 0.0f;
        } else {
            dimension = this.i.getDimension(R.dimen.ds40);
        }
        int dimension2 = (int) (((int) ((l.p(this.f20778e)[0] - dimension) - ((int) this.i.getDimension(R.dimen.ds4)))) * 0.75f);
        this.f20780g = dimension2;
        this.f20781h = (int) (dimension2 / f4);
    }

    public void b() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt != null) {
                SkinManager.setViewTextColor((TextView) childAt.findViewById(R.id.loop_text_view), R.color.CAM_X0105, 1);
            }
        }
    }

    public final void c(View view, AdCard.d dVar, int i, ItemType itemType) {
        if (view == null || dVar == null) {
            return;
        }
        TbImageView tbImageView = (TbImageView) view.findViewById(R.id.loop_image_view);
        TextView textView = (TextView) view.findViewById(R.id.loop_text_view);
        g(tbImageView, this.f20780g, this.f20781h);
        g(view, this.f20780g, -2);
        a aVar = this.f20779f;
        if (aVar != null) {
            aVar.a(tbImageView, dVar.f20709c);
        }
        tbImageView.W(dVar.f20707a, i, false);
        if (itemType == ItemType.WITHOUT_BOTTOM_TITLE) {
            textView.setText("");
            textView.setVisibility(8);
        } else if (itemType == ItemType.WITH_BOTTOM_TITLE) {
            textView.setVisibility(0);
            a aVar2 = this.f20779f;
            if (aVar2 != null) {
                textView.setText(aVar2.b(dVar.f20710d));
            }
        }
    }

    public final void d(AdCard.d[] dVarArr, int i) {
        ItemType itemType;
        if (e(dVarArr)) {
            itemType = ItemType.WITH_BOTTOM_TITLE;
        } else {
            itemType = ItemType.WITHOUT_BOTTOM_TITLE;
        }
        try {
            boolean z = false;
            for (AdCard.d dVar : dVarArr) {
                View inflate = LayoutInflater.from(this.f20778e).inflate(R.layout.loop_ad_item, (ViewGroup) null);
                if (inflate == null) {
                    return;
                }
                if (!z) {
                    inflate.setPadding(0, 0, 0, 0);
                    z = true;
                }
                c(inflate, dVar, i, itemType);
                addView(inflate);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final boolean e(AdCard.d[] dVarArr) {
        for (AdCard.d dVar : dVarArr) {
            if (TextUtils.isEmpty(dVar.f20710d)) {
                return false;
            }
        }
        return true;
    }

    public final void f() {
        removeAllViews();
    }

    public final void g(View view, int i, int i2) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = i;
            layoutParams.height = i2;
            return;
        }
        view.setLayoutParams(new LinearLayout.LayoutParams(i, i2));
    }

    public void h(AdCard.d[] dVarArr, int i, int i2, int i3, int i4) {
        float dimension;
        if (dVarArr == null || dVarArr.length <= 0 || i3 > i2 || dVarArr == this.j) {
            return;
        }
        this.j = dVarArr;
        if (i2 == 0 || i3 == 0) {
            int i5 = this.k;
            if (i5 == 2 || i5 == 1) {
                i2 = (int) this.i.getDimension(R.dimen.ds570);
                dimension = this.i.getDimension(R.dimen.ds302);
            } else if (i5 == 4) {
                i2 = (int) this.i.getDimension(R.dimen.ds500);
                dimension = this.i.getDimension(R.dimen.ds265);
            }
            i3 = (int) dimension;
        }
        a(i2, i3, i4);
        a aVar = this.f20779f;
        if (aVar != null) {
            aVar.reset();
        }
        f();
        d(dVarArr, i);
    }

    public void setBussinessType(int i) {
        this.k = i;
    }

    public void setOnClickCallbackListener(a aVar) {
        this.f20779f = aVar;
    }

    public LoopADView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LoopADView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f20778e = null;
        this.f20779f = null;
        this.f20780g = 0;
        this.f20781h = 0;
        this.i = null;
        this.j = null;
        Context applicationContext = context.getApplicationContext();
        this.f20778e = applicationContext;
        this.i = applicationContext.getResources();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        setLayoutParams(layoutParams);
        setOrientation(0);
    }
}
