package com.baidu.tieba.memberCenter.tail.edit.color;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.NoPressedLinearLayout;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.R;
import d.b.h0.w.n;
import d.b.i0.q1.h.b.c.b;
import d.b.i0.q1.h.b.c.c;
import d.b.i0.q1.h.b.c.e;
/* loaded from: classes3.dex */
public class TailEditColorToolHost extends NoPressedLinearLayout implements n {

    /* renamed from: e  reason: collision with root package name */
    public int f19006e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.i0.q1.h.b.c.a f19007f;

    /* renamed from: g  reason: collision with root package name */
    public c f19008g;

    /* renamed from: h  reason: collision with root package name */
    public e f19009h;
    public EditorTools i;
    public View.OnClickListener j;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b bVar = (b) view.getTag();
            if (bVar == null) {
                return;
            }
            TailEditColorToolHost.this.f19008g.c(bVar.b());
            TailEditColorToolHost.this.f19007f.notifyDataSetChanged();
            TailEditColorToolHost.this.i.A(new d.b.h0.w.a(26, -1, bVar.b()));
        }
    }

    public TailEditColorToolHost(TbPageContext<?> tbPageContext, String str) {
        super(tbPageContext.getPageActivity());
        this.f19006e = 0;
        this.j = new a();
        i(tbPageContext, str);
    }

    @Override // d.b.h0.w.n
    public void b() {
        setVisibility(0);
    }

    @Override // d.b.h0.w.n
    public void d(d.b.h0.w.a aVar) {
        EditorTools editorTools = this.i;
        if (editorTools != null) {
            editorTools.A(aVar);
        }
    }

    @Override // d.b.h0.w.n
    public int getToolId() {
        return this.f19006e;
    }

    @Override // d.b.h0.w.n
    public void hide() {
        setVisibility(8);
    }

    public final void i(TbPageContext<?> tbPageContext, String str) {
        LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.tail_edit_color, (ViewGroup) this, true);
        this.f19009h = new e(this);
        c cVar = new c(tbPageContext);
        this.f19008g = cVar;
        cVar.c(str);
        d.b.i0.q1.h.b.c.a aVar = new d.b.i0.q1.h.b.c.a(tbPageContext, this.f19008g, this.j);
        this.f19007f = aVar;
        this.f19009h.a(aVar);
    }

    @Override // d.b.h0.w.n
    public void init() {
    }

    @Override // d.b.h0.w.b
    public void onAction(d.b.h0.w.a aVar) {
    }

    @Override // d.b.h0.w.n
    public void onChangeSkinType(int i) {
    }

    @Override // d.b.h0.w.n
    public void setEditorTools(EditorTools editorTools) {
        this.i = editorTools;
    }

    @Override // d.b.h0.w.n
    public void setToolId(int i) {
        this.f19006e = i;
    }
}
