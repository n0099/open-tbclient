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
import d.a.c.e.p.l;
/* loaded from: classes3.dex */
public class LoopADView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public Context f21013e;

    /* renamed from: f  reason: collision with root package name */
    public a f21014f;

    /* renamed from: g  reason: collision with root package name */
    public int f21015g;

    /* renamed from: h  reason: collision with root package name */
    public int f21016h;

    /* renamed from: i  reason: collision with root package name */
    public Resources f21017i;
    public AdCard.d[] j;
    public int k;

    /* loaded from: classes3.dex */
    public enum ItemType {
        WITH_BOTTOM_TITLE,
        WITHOUT_BOTTOM_TITLE
    }

    /* loaded from: classes3.dex */
    public interface a {
        void a(TbImageView tbImageView, AdCard.b bVar);

        String b(String str);

        void reset();
    }

    public LoopADView(Context context) {
        this(context, null);
    }

    public final void a(float f2, float f3, int i2) {
        float dimension;
        float f4 = f2 / f3;
        int i3 = this.k;
        if (i3 != 1 && i3 != 2) {
            dimension = i3 == 4 ? this.f21017i.getDimension(R.dimen.ds40) + this.f21017i.getDimension(R.dimen.ds60) + this.f21017i.getDimension(R.dimen.ds16) : 0.0f;
        } else {
            dimension = this.f21017i.getDimension(R.dimen.ds40);
        }
        int dimension2 = (int) (((int) ((l.p(this.f21013e)[0] - dimension) - ((int) this.f21017i.getDimension(R.dimen.ds4)))) * 0.75f);
        this.f21015g = dimension2;
        this.f21016h = (int) (dimension2 / f4);
    }

    public void b() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt != null) {
                SkinManager.setViewTextColor((TextView) childAt.findViewById(R.id.loop_text_view), R.color.CAM_X0105, 1);
            }
        }
    }

    public final void c(View view, AdCard.d dVar, int i2, ItemType itemType) {
        if (view == null || dVar == null) {
            return;
        }
        TbImageView tbImageView = (TbImageView) view.findViewById(R.id.loop_image_view);
        TextView textView = (TextView) view.findViewById(R.id.loop_text_view);
        g(tbImageView, this.f21015g, this.f21016h);
        g(view, this.f21015g, -2);
        a aVar = this.f21014f;
        if (aVar != null) {
            aVar.a(tbImageView, dVar.f20952c);
        }
        tbImageView.V(dVar.f20950a, i2, false);
        if (itemType == ItemType.WITHOUT_BOTTOM_TITLE) {
            textView.setText("");
            textView.setVisibility(8);
        } else if (itemType == ItemType.WITH_BOTTOM_TITLE) {
            textView.setVisibility(0);
            a aVar2 = this.f21014f;
            if (aVar2 != null) {
                textView.setText(aVar2.b(dVar.f20953d));
            }
        }
    }

    public final void d(AdCard.d[] dVarArr, int i2) {
        ItemType itemType;
        if (e(dVarArr)) {
            itemType = ItemType.WITH_BOTTOM_TITLE;
        } else {
            itemType = ItemType.WITHOUT_BOTTOM_TITLE;
        }
        try {
            boolean z = false;
            for (AdCard.d dVar : dVarArr) {
                View inflate = LayoutInflater.from(this.f21013e).inflate(R.layout.loop_ad_item, (ViewGroup) null);
                if (inflate == null) {
                    return;
                }
                if (!z) {
                    inflate.setPadding(0, 0, 0, 0);
                    z = true;
                }
                c(inflate, dVar, i2, itemType);
                addView(inflate);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final boolean e(AdCard.d[] dVarArr) {
        for (AdCard.d dVar : dVarArr) {
            if (TextUtils.isEmpty(dVar.f20953d)) {
                return false;
            }
        }
        return true;
    }

    public final void f() {
        removeAllViews();
    }

    public final void g(View view, int i2, int i3) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = i2;
            layoutParams.height = i3;
            return;
        }
        view.setLayoutParams(new LinearLayout.LayoutParams(i2, i3));
    }

    public void h(AdCard.d[] dVarArr, int i2, int i3, int i4, int i5) {
        float dimension;
        if (dVarArr == null || dVarArr.length <= 0 || i4 > i3 || dVarArr == this.j) {
            return;
        }
        this.j = dVarArr;
        if (i3 == 0 || i4 == 0) {
            int i6 = this.k;
            if (i6 == 2 || i6 == 1) {
                i3 = (int) this.f21017i.getDimension(R.dimen.ds570);
                dimension = this.f21017i.getDimension(R.dimen.ds302);
            } else if (i6 == 4) {
                i3 = (int) this.f21017i.getDimension(R.dimen.ds500);
                dimension = this.f21017i.getDimension(R.dimen.ds265);
            }
            i4 = (int) dimension;
        }
        a(i3, i4, i5);
        a aVar = this.f21014f;
        if (aVar != null) {
            aVar.reset();
        }
        f();
        d(dVarArr, i2);
    }

    public void setBussinessType(int i2) {
        this.k = i2;
    }

    public void setOnClickCallbackListener(a aVar) {
        this.f21014f = aVar;
    }

    public LoopADView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LoopADView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f21013e = null;
        this.f21014f = null;
        this.f21015g = 0;
        this.f21016h = 0;
        this.f21017i = null;
        this.j = null;
        Context applicationContext = context.getApplicationContext();
        this.f21013e = applicationContext;
        this.f21017i = applicationContext.getResources();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        setLayoutParams(layoutParams);
        setOrientation(0);
    }
}
