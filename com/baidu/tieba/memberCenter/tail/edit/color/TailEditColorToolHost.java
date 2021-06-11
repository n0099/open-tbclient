package com.baidu.tieba.memberCenter.tail.edit.color;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.NoPressedLinearLayout;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.R;
import d.a.m0.w.n;
import d.a.n0.s1.h.b.c.b;
import d.a.n0.s1.h.b.c.c;
import d.a.n0.s1.h.b.c.e;
/* loaded from: classes3.dex */
public class TailEditColorToolHost extends NoPressedLinearLayout implements n {

    /* renamed from: e  reason: collision with root package name */
    public int f18391e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.n0.s1.h.b.c.a f18392f;

    /* renamed from: g  reason: collision with root package name */
    public c f18393g;

    /* renamed from: h  reason: collision with root package name */
    public e f18394h;

    /* renamed from: i  reason: collision with root package name */
    public EditorTools f18395i;
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
            TailEditColorToolHost.this.f18393g.c(bVar.b());
            TailEditColorToolHost.this.f18392f.notifyDataSetChanged();
            TailEditColorToolHost.this.f18395i.A(new d.a.m0.w.a(26, -1, bVar.b()));
        }
    }

    public TailEditColorToolHost(TbPageContext<?> tbPageContext, String str) {
        super(tbPageContext.getPageActivity());
        this.f18391e = 0;
        this.j = new a();
        i(tbPageContext, str);
    }

    @Override // d.a.m0.w.n
    public void b() {
        setVisibility(0);
    }

    @Override // d.a.m0.w.n
    public void d(d.a.m0.w.a aVar) {
        EditorTools editorTools = this.f18395i;
        if (editorTools != null) {
            editorTools.A(aVar);
        }
    }

    @Override // d.a.m0.w.n
    public int getToolId() {
        return this.f18391e;
    }

    @Override // d.a.m0.w.n
    public void hide() {
        setVisibility(8);
    }

    public final void i(TbPageContext<?> tbPageContext, String str) {
        LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.tail_edit_color, (ViewGroup) this, true);
        this.f18394h = new e(this);
        c cVar = new c(tbPageContext);
        this.f18393g = cVar;
        cVar.c(str);
        d.a.n0.s1.h.b.c.a aVar = new d.a.n0.s1.h.b.c.a(tbPageContext, this.f18393g, this.j);
        this.f18392f = aVar;
        this.f18394h.a(aVar);
    }

    @Override // d.a.m0.w.n
    public void init() {
    }

    @Override // d.a.m0.w.b
    public void onAction(d.a.m0.w.a aVar) {
    }

    @Override // d.a.m0.w.n
    public void onChangeSkinType(int i2) {
    }

    @Override // d.a.m0.w.n
    public void setEditorTools(EditorTools editorTools) {
        this.f18395i = editorTools;
    }

    @Override // d.a.m0.w.n
    public void setToolId(int i2) {
        this.f18391e = i2;
    }
}
