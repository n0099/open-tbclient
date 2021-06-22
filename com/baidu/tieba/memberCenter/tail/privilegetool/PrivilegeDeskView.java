package com.baidu.tieba.memberCenter.tail.privilegetool;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.editortools.DLauncher;
import com.baidu.tbadk.editortools.view.CommonTabHost;
import com.baidu.tieba.R;
import d.a.n0.w.g;
import d.a.n0.w.h;
import java.util.LinkedList;
/* loaded from: classes4.dex */
public class PrivilegeDeskView extends CommonTabHost {
    public LinkedList<h> q;
    public int r;
    public DLauncher s;
    public DLauncher t;
    public Context u;
    public CustomMessageListener v;
    public CustomMessageListener w;
    public View.OnClickListener x;
    public View.OnClickListener y;

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Boolean)) {
                return;
            }
            if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                PrivilegeDeskView.this.s.c(" ");
            } else {
                PrivilegeDeskView.this.s.f();
            }
            PrivilegeDeskView.this.y();
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
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof Boolean)) {
                return;
            }
            if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                PrivilegeDeskView.this.t.c(" ");
            } else {
                PrivilegeDeskView.this.t.f();
            }
            PrivilegeDeskView.this.y();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PrivilegeDeskView.this.hide();
            PrivilegeDeskView.this.d(new d.a.n0.w.a(1, 16, null));
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PrivilegeDeskView.this.hide();
            PrivilegeDeskView.this.d(new d.a.n0.w.a(1, 12, null));
        }
    }

    public PrivilegeDeskView(Context context) {
        super(context);
        this.r = 0;
        this.v = new a(2001344);
        this.w = new b(2001353);
        this.x = new c();
        this.y = new d();
        u(context);
        d.a.o0.s1.h.e.a aVar = new d.a.o0.s1.h.e.a(context, 1);
        s(new d.a.o0.s1.b.b(context));
        t(aVar);
        this.u = context;
    }

    @Override // com.baidu.tbadk.editortools.view.CommonTabHost, d.a.n0.w.n
    public void init() {
        setShowDelete(false);
        d.a.o0.s1.h.d.a aVar = new d.a.o0.s1.h.d.a();
        aVar.C(this.q);
        k(aVar);
        w();
        v();
    }

    @Override // com.baidu.tbadk.editortools.view.CommonTabHost, d.a.n0.w.b
    public void onAction(d.a.n0.w.a aVar) {
        super.onAction(aVar);
        if (aVar == null) {
            return;
        }
        if (aVar.f54625a == 2) {
            Object obj = aVar.f54627c;
            if (obj == null) {
                this.r--;
            } else if (obj instanceof String) {
                String str = (String) obj;
                if (TextUtils.isEmpty(str)) {
                    this.r--;
                } else if (TextUtils.isEmpty(str.trim())) {
                    this.r++;
                } else {
                    this.r += d.a.c.e.m.b.d(str, 1);
                }
            }
            if (this.r > 0) {
                d(new d.a.n0.w.a(2, 18, " "));
            } else {
                d(new d.a.n0.w.a(2, 18, null));
            }
        }
        if (aVar.f54625a == 1) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FUNCTION_PANEL_CLIKED).param("obj_locate", 2));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.v);
        MessageManager.getInstance().registerListener(this.w);
        y();
    }

    @Override // com.baidu.tbadk.editortools.view.CommonTabHost, d.a.n0.w.n
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        this.s.onChangeSkinType(i2);
        this.t.onChangeSkinType(i2);
    }

    @Override // com.baidu.tbadk.editortools.view.CommonTabHost, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.v);
        MessageManager.getInstance().unRegisterListener(this.w);
    }

    public final void s(d.a.o0.s1.b.b bVar) {
        DLauncher dLauncher = (DLauncher) g.a(getContext(), bVar, 6);
        this.t = dLauncher;
        dLauncher.setOnClickListener(this.y);
        this.q.add(this.t);
    }

    public final void t(d.a.o0.s1.h.e.a aVar) {
        DLauncher dLauncher = (DLauncher) g.a(getContext(), aVar, 6);
        this.s = dLauncher;
        dLauncher.setOnClickListener(this.x);
        this.q.add(this.s);
    }

    public final void u(Context context) {
        setBackgroundColorId(R.color.CAM_X0206);
        setToolId(18);
        this.q = new LinkedList<>();
    }

    public final void v() {
        if (!StringUtils.isNull(TbadkCoreApplication.getInst().getDefaultBubble())) {
            this.t.c(" ");
        } else {
            this.t.f();
        }
        y();
    }

    public final void w() {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj == null) {
            return;
        }
        if (currentAccountObj.getIsSelectTail()) {
            this.s.c(" ");
        } else {
            this.s.f();
        }
        y();
    }

    public final void x(boolean z) {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            currentAccountObj.setIsSelectTail(z);
        }
    }

    public final void y() {
        boolean z;
        String text = this.s.getText();
        String text2 = this.t.getText();
        if (text != null && !text.equals("")) {
            z = true;
            d(new d.a.n0.w.a(2, 18, " "));
            d(new d.a.n0.w.a(2, 16, " "));
        } else {
            if (text2 != null && !text2.equals("")) {
                d(new d.a.n0.w.a(2, 18, " "));
            } else {
                d(new d.a.n0.w.a(2, 18, null));
            }
            z = false;
        }
        x(z);
    }
}
