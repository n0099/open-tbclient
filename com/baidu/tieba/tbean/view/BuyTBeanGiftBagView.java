package com.baidu.tieba.tbean.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tbclient.GetIconList.Custom;
/* loaded from: classes5.dex */
public class BuyTBeanGiftBagView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public LinkedList<d.a.o0.g3.e.a> f21078e;

    /* renamed from: f  reason: collision with root package name */
    public b f21079f;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.g3.e.a f21080e;

        public a(d.a.o0.g3.e.a aVar) {
            this.f21080e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (BuyTBeanGiftBagView.this.f21079f != null) {
                BuyTBeanGiftBagView.this.f21079f.a(this.f21080e);
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a(d.a.o0.g3.e.a aVar);
    }

    public BuyTBeanGiftBagView(Context context) {
        super(context);
        this.f21078e = new LinkedList<>();
        c();
    }

    public final void b(d.a.o0.g3.e.a aVar) {
        if (aVar == null) {
            return;
        }
        TbImageView tbImageView = new TbImageView(getContext());
        tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        tbImageView.setDrawerType(1);
        tbImageView.setRadius(getContext().getResources().getDimensionPixelSize(R.dimen.tbds10));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, getContext().getResources().getDimensionPixelSize(R.dimen.tbds182));
        layoutParams.bottomMargin = getContext().getResources().getDimensionPixelSize(R.dimen.tbds20);
        addView(tbImageView, layoutParams);
        Custom custom = aVar.f59052e;
        if (custom != null && !StringUtils.isNull(custom.package_pic)) {
            tbImageView.U(aVar.f59052e.package_pic, 10, false);
        }
        tbImageView.setOnClickListener(new a(aVar));
    }

    public final void c() {
        setOrientation(1);
    }

    public void d(List<d.a.o0.g3.e.a> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        this.f21078e.clear();
        this.f21078e.addAll(list);
        removeAllViews();
        Iterator<d.a.o0.g3.e.a> it = this.f21078e.iterator();
        while (it.hasNext()) {
            b(it.next());
        }
    }

    public void setClickListener(b bVar) {
        this.f21079f = bVar;
    }

    public BuyTBeanGiftBagView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f21078e = new LinkedList<>();
        c();
    }

    public BuyTBeanGiftBagView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f21078e = new LinkedList<>();
        c();
    }
}
