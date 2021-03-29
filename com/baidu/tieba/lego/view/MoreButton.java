package com.baidu.tieba.lego.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import d.b.i0.c3.v;
import d.b.i0.i1.o.j.c;
/* loaded from: classes3.dex */
public class MoreButton extends TextView {

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f18754e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f18755f;

        public a(TbPageContext tbPageContext, c cVar) {
            this.f18754e = tbPageContext;
            this.f18755f = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            v.c(this.f18754e, this.f18755f.d());
        }
    }

    public MoreButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setData(c cVar, TbPageContext tbPageContext) {
        if (cVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        setText(cVar.e());
        if (!TextUtils.isEmpty(cVar.d())) {
            setOnClickListener(new a(tbPageContext, cVar));
        } else {
            setOnClickListener(null);
        }
    }

    public MoreButton(Context context) {
        super(context, null, 0);
    }

    public MoreButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
