package com.baidu.tieba.memberCenter.tail.tool;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.view.NoPressedLinearLayout;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.R;
import com.baidu.tieba.memberCenter.tail.data.TailEditActivityConfig;
import d.a.n0.w.n;
import d.a.o0.s1.h.e.g;
import d.a.o0.s1.h.e.h;
/* loaded from: classes4.dex */
public class TailToolController extends NoPressedLinearLayout implements n {

    /* renamed from: e  reason: collision with root package name */
    public int f18485e;

    /* renamed from: f  reason: collision with root package name */
    public h f18486f;

    /* renamed from: g  reason: collision with root package name */
    public g f18487g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.o0.s1.h.e.b f18488h;

    /* renamed from: i  reason: collision with root package name */
    public Context f18489i;
    public EditorTools j;
    public CustomMessageListener k;
    public CustomMessageListener l;
    public View.OnClickListener m;

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Boolean bool;
            if (customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Boolean) || (bool = (Boolean) customResponsedMessage.getData()) == null) {
                return;
            }
            TailToolController.this.m(bool.booleanValue());
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && TailToolController.this.f18487g.h()) {
                TailToolController.this.setVisibility(0);
                TailToolController.this.f18487g.m(false);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TailToolController.this.k();
            TailToolController.this.l();
        }
    }

    public TailToolController(Context context) {
        super(context);
        this.f18485e = 0;
        this.k = new a(2001344);
        this.l = new b(2001348);
        this.m = new c();
        j(context);
    }

    @Override // d.a.n0.w.n
    public void b() {
        setVisibility(0);
        this.f18487g.j();
    }

    @Override // d.a.n0.w.n
    public void d(d.a.n0.w.a aVar) {
        EditorTools editorTools = this.j;
        if (editorTools != null) {
            editorTools.A(aVar);
        }
    }

    @Override // d.a.n0.w.n
    public int getToolId() {
        return this.f18485e;
    }

    @Override // d.a.n0.w.n
    public void hide() {
        setVisibility(8);
    }

    @Override // d.a.n0.w.n
    public void init() {
        n();
    }

    public final void j(Context context) {
        this.f18489i = context;
        this.f18486f = new h((ViewGroup) LayoutInflater.from(context).inflate(R.layout.tail_tool, (ViewGroup) this, true));
        this.f18487g = new g(context);
        d.a.o0.s1.h.e.b bVar = new d.a.o0.s1.h.e.b(context, this.f18487g, this.m);
        this.f18488h = bVar;
        this.f18486f.a(bVar);
    }

    public final void k() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TailEditActivityConfig(this.f18489i, this.f18487g.i().isEmpty())));
    }

    public final void l() {
        hide();
        this.f18487g.m(true);
    }

    public final void m(boolean z) {
        if (z) {
            d(new d.a.n0.w.a(2, 16, " "));
        } else {
            d(new d.a.n0.w.a(2, 16, null));
        }
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            currentAccountObj.setIsSelectTail(z);
        }
    }

    public final void n() {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            m(currentAccountObj.getIsSelectTail());
        }
    }

    @Override // d.a.n0.w.b
    public void onAction(d.a.n0.w.a aVar) {
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f18487g.k();
        MessageManager.getInstance().registerListener(this.k);
        MessageManager.getInstance().registerListener(this.l);
    }

    @Override // d.a.n0.w.n
    public void onChangeSkinType(int i2) {
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f18487g.l();
        MessageManager.getInstance().unRegisterListener(this.k);
        MessageManager.getInstance().unRegisterListener(this.l);
    }

    @Override // d.a.n0.w.n
    public void setEditorTools(EditorTools editorTools) {
        this.j = editorTools;
    }

    @Override // d.a.n0.w.n
    public void setToolId(int i2) {
        this.f18485e = i2;
    }

    public TailToolController(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f18485e = 0;
        this.k = new a(2001344);
        this.l = new b(2001348);
        this.m = new c();
        j(context);
    }
}
