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
import d.a.i0.w.n;
import d.a.j0.r1.h.e.g;
import d.a.j0.r1.h.e.h;
/* loaded from: classes3.dex */
public class TailToolController extends NoPressedLinearLayout implements n {

    /* renamed from: e  reason: collision with root package name */
    public int f19129e;

    /* renamed from: f  reason: collision with root package name */
    public h f19130f;

    /* renamed from: g  reason: collision with root package name */
    public g f19131g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.j0.r1.h.e.b f19132h;

    /* renamed from: i  reason: collision with root package name */
    public Context f19133i;
    public EditorTools j;
    public CustomMessageListener k;
    public CustomMessageListener l;
    public View.OnClickListener m;

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
    public class b extends CustomMessageListener {
        public b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && TailToolController.this.f19131g.h()) {
                TailToolController.this.setVisibility(0);
                TailToolController.this.f19131g.m(false);
            }
        }
    }

    /* loaded from: classes3.dex */
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
        this.f19129e = 0;
        this.k = new a(2001344);
        this.l = new b(2001348);
        this.m = new c();
        j(context);
    }

    @Override // d.a.i0.w.n
    public void b() {
        setVisibility(0);
        this.f19131g.j();
    }

    @Override // d.a.i0.w.n
    public void d(d.a.i0.w.a aVar) {
        EditorTools editorTools = this.j;
        if (editorTools != null) {
            editorTools.A(aVar);
        }
    }

    @Override // d.a.i0.w.n
    public int getToolId() {
        return this.f19129e;
    }

    @Override // d.a.i0.w.n
    public void hide() {
        setVisibility(8);
    }

    @Override // d.a.i0.w.n
    public void init() {
        n();
    }

    public final void j(Context context) {
        this.f19133i = context;
        this.f19130f = new h((ViewGroup) LayoutInflater.from(context).inflate(R.layout.tail_tool, (ViewGroup) this, true));
        this.f19131g = new g(context);
        d.a.j0.r1.h.e.b bVar = new d.a.j0.r1.h.e.b(context, this.f19131g, this.m);
        this.f19132h = bVar;
        this.f19130f.a(bVar);
    }

    public final void k() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TailEditActivityConfig(this.f19133i, this.f19131g.i().isEmpty())));
    }

    public final void l() {
        hide();
        this.f19131g.m(true);
    }

    public final void m(boolean z) {
        if (z) {
            d(new d.a.i0.w.a(2, 16, " "));
        } else {
            d(new d.a.i0.w.a(2, 16, null));
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

    @Override // d.a.i0.w.b
    public void onAction(d.a.i0.w.a aVar) {
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f19131g.k();
        MessageManager.getInstance().registerListener(this.k);
        MessageManager.getInstance().registerListener(this.l);
    }

    @Override // d.a.i0.w.n
    public void onChangeSkinType(int i2) {
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f19131g.l();
        MessageManager.getInstance().unRegisterListener(this.k);
        MessageManager.getInstance().unRegisterListener(this.l);
    }

    @Override // d.a.i0.w.n
    public void setEditorTools(EditorTools editorTools) {
        this.j = editorTools;
    }

    @Override // d.a.i0.w.n
    public void setToolId(int i2) {
        this.f19129e = i2;
    }

    public TailToolController(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f19129e = 0;
        this.k = new a(2001344);
        this.l = new b(2001348);
        this.m = new c();
        j(context);
    }
}
