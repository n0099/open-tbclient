package com.baidu.tieba.pb.pb.main;

import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.view.TextLineView;
import com.baidu.tieba.view.SortSwitchButton;
import d.b.c.e.p.j;
import d.b.c.e.p.l;
import d.b.i0.d2.h.o;
import d.b.i0.d2.k.e.s0;
import d.b.i0.d3.h0.r;
import java.util.ArrayList;
import java.util.List;
import tbclient.PbPage.PbSortType;
/* loaded from: classes3.dex */
public class PbReplyTitleViewHolder extends TypeAdapter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public int f19448a;

    /* renamed from: b  reason: collision with root package name */
    public View f19449b;

    /* renamed from: c  reason: collision with root package name */
    public TextLineView f19450c;

    /* renamed from: d  reason: collision with root package name */
    public TextLineView f19451d;

    /* renamed from: e  reason: collision with root package name */
    public SortSwitchButton f19452e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f19453f;

    /* renamed from: g  reason: collision with root package name */
    public View f19454g;

    /* renamed from: h  reason: collision with root package name */
    public View f19455h;
    public View i;
    public TextLineView j;
    public View k;
    public View l;
    public TextView m;
    public List<TextLineView> n;
    public View.OnClickListener o;
    public SortSwitchButton.f p;
    public o q;
    public BdUniqueId r;
    public BdUniqueId s;
    public TbPageContext t;
    public boolean u;
    public SortSwitchButton.f v;
    public View.OnClickListener w;
    public CustomMessageListener x;
    public CustomMessageListener y;

    /* loaded from: classes3.dex */
    public class a implements SortSwitchButton.f {
        public a() {
        }

        @Override // com.baidu.tieba.view.SortSwitchButton.f
        public boolean a(int i) {
            if (PbReplyTitleViewHolder.this.p != null) {
                return PbReplyTitleViewHolder.this.p.a(i);
            }
            return true;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public b(PbReplyTitleViewHolder pbReplyTitleViewHolder) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PbReplyTitleViewHolder.this.o != null) {
                PbReplyTitleViewHolder.this.o.onClick(PbReplyTitleViewHolder.this.i);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PbReplyTitleViewHolder.this.o != null) {
                PbReplyTitleViewHolder.this.o.onClick(view);
            }
            if (j.z()) {
                if (view == null || !(view.getTag() instanceof Boolean) || ((Boolean) view.getTag()).booleanValue()) {
                    for (TextLineView textLineView : PbReplyTitleViewHolder.this.n) {
                        if (textLineView != null) {
                            if (textLineView != view) {
                                textLineView.setSelected(false);
                            } else {
                                textLineView.setSelected(true);
                            }
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e extends CustomMessageListener {
        public e(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbReplyTitleViewHolder.this.q != null && PbReplyTitleViewHolder.this.q.f53850f == o.l && customResponsedMessage != null && getTag() == PbReplyTitleViewHolder.this.r && (customResponsedMessage.getData() instanceof s0.j0)) {
                ((s0.j0) customResponsedMessage.getData()).f54288c = PbReplyTitleViewHolder.this;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f extends CustomMessageListener {
        public f(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbReplyTitleViewHolder.this.q == null || PbReplyTitleViewHolder.this.q.f53850f != o.m || customResponsedMessage == null || getTag() != PbReplyTitleViewHolder.this.s || !(customResponsedMessage.getData() instanceof s0.j0)) {
            }
        }
    }

    public PbReplyTitleViewHolder(TbPageContext tbPageContext, View view) {
        super(view);
        this.f19448a = 3;
        this.u = true;
        this.v = new a();
        this.w = new d();
        this.x = new e(2004013);
        this.y = new f(2004013);
        if (view == null) {
            return;
        }
        this.f19449b = view;
        this.t = tbPageContext;
        view.setOnClickListener(new b(this));
        TextLineView textLineView = (TextLineView) view.findViewById(R.id.reply_title);
        this.f19450c = textLineView;
        textLineView.setOnClickListener(this.w);
        this.i = view.findViewById(R.id.reply_god_title_group);
        TextLineView textLineView2 = (TextLineView) view.findViewById(R.id.reply_god_title);
        this.j = textLineView2;
        textLineView2.setSelected(false);
        this.l = view.findViewById(R.id.reply_all_title_frame);
        this.k = view.findViewById(R.id.reply_all_title);
        this.m = (TextView) view.findViewById(R.id.reply_title_dynamic);
        TextLineView textLineView3 = (TextLineView) view.findViewById(R.id.floor_owner_reply);
        this.f19451d = textLineView3;
        textLineView3.setOnClickListener(this.w);
        SortSwitchButton sortSwitchButton = (SortSwitchButton) view.findViewById(R.id.pb_sort_switch_btn);
        this.f19452e = sortSwitchButton;
        sortSwitchButton.setOnSwitchChangeListener(this.v);
        this.f19452e.setVisibility(0);
        this.f19453f = (TextView) view.findViewById(R.id.pb_god_reply_entrance_text);
        this.f19450c.setSelected(true);
        this.f19451d.setSelected(false);
        ArrayList arrayList = new ArrayList();
        this.n = arrayList;
        arrayList.add(this.f19450c);
        this.n.add(this.f19451d);
        this.f19454g = view.findViewById(R.id.divider_with_reply_title);
        this.f19455h = view.findViewById(R.id.divider_bottom);
        this.f19452e.u(2);
        l(TbadkCoreApplication.getInst().getSkinType());
    }

    public void h(o oVar) {
        this.q = oVar;
        if (oVar == null) {
            return;
        }
        BdUniqueId bdUniqueId = oVar.f53850f;
        if (bdUniqueId == o.m) {
            this.i.getContext();
            if (TextUtils.isEmpty(oVar.f53849e)) {
                this.l.setVisibility(0);
                this.i.setVisibility(8);
                this.f19450c.setVisibility(0);
                this.f19450c.setSelected(false);
                this.f19450c.setClickable(false);
                this.f19450c.setText(TbadkCoreApplication.getInst().getString(R.string.god_reply));
            } else {
                this.l.setVisibility(8);
                this.f19450c.setVisibility(8);
                this.i.setVisibility(0);
                this.i.setOnClickListener(new c());
            }
            this.f19452e.setVisibility(8);
            this.f19451d.setVisibility(8);
            this.f19455h.setVisibility(8);
        } else if (bdUniqueId == o.l) {
            this.i.setVisibility(8);
            this.l.setVisibility(0);
            this.f19450c.setClickable(true);
            this.f19450c.setText(TbadkCoreApplication.getInst().getString(R.string.all_reply));
            this.f19451d.setVisibility(0);
            i(oVar.f53852h);
            if (oVar.k != null) {
                this.f19452e.setVisibility(0);
                int i = 0;
                while (true) {
                    if (i >= oVar.k.size()) {
                        i = 0;
                        break;
                    } else if (oVar.k.get(i) != null && oVar.f53851g == oVar.k.get(i).sort_type.intValue()) {
                        break;
                    } else {
                        i++;
                    }
                }
                k(oVar.k, i);
            }
            this.f19455h.setVisibility(0);
        }
        if (this.u) {
            this.f19455h.getLayoutParams().height = l.g(TbadkCoreApplication.getInst(), R.dimen.L_X01);
            SkinManager.setBackgroundColor(this.l, R.color.CAM_X0207);
        } else {
            this.f19455h.getLayoutParams().height = 0;
            SkinManager.setBackgroundColor(this.l, R.color.CAM_X0205);
        }
        if (oVar.i) {
            this.m.setVisibility(0);
            this.k.setVisibility(8);
        } else {
            this.m.setVisibility(8);
            this.k.setVisibility(0);
        }
        l(TbadkCoreApplication.getInst().getSkinType());
    }

    public void i(boolean z) {
        if (z) {
            this.f19451d.setSelected(true);
            this.f19450c.setSelected(false);
            return;
        }
        this.f19451d.setSelected(false);
        this.f19450c.setSelected(true);
    }

    public View j() {
        return this.f19449b;
    }

    public void k(List<PbSortType> list, int i) {
        if (ListUtils.isEmpty(list)) {
            this.f19452e.setVisibility(8);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (PbSortType pbSortType : list) {
            r rVar = new r();
            rVar.c(pbSortType.sort_type.intValue());
            rVar.d(pbSortType.sort_name);
            arrayList.add(rVar);
        }
        this.f19452e.setVisibility(0);
        this.f19452e.setData(arrayList, i);
    }

    public void l(int i) {
        if (this.f19448a != i) {
            SkinManager.setBackgroundColor(this.l, R.color.CAM_X0201);
            SkinManager.setBackgroundColor(this.i, R.color.CAM_X0201);
            this.f19450c.b(i);
            this.f19451d.b(i);
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0105);
            o oVar = this.q;
            if (oVar != null && oVar.f53850f == o.m) {
                SkinManager.setViewTextColor(this.f19450c, R.color.CAM_X0107, 1);
            }
            SkinManager.setViewTextColor(this.f19453f, R.color.CAM_X0107);
            this.f19453f.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(R.drawable.icon_gob_reply_jump), (Drawable) null);
            this.f19452e.F();
            SkinManager.setBackgroundColor(this.f19454g, R.color.CAM_X0204);
            if (this.u) {
                SkinManager.setBackgroundColor(this.f19455h, R.color.CAM_X0203);
                SkinManager.setBackgroundColor(this.l, R.color.CAM_X0207);
            } else {
                SkinManager.setBackgroundColor(this.l, R.color.CAM_X0205);
            }
            SkinManager.setViewTextColor(this.m, R.color.CAM_X0105, 1);
        }
        this.f19448a = i;
    }

    public void m(BdUniqueId bdUniqueId) {
        this.s = bdUniqueId;
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.y.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.y);
    }

    public void n(BdUniqueId bdUniqueId) {
        this.r = bdUniqueId;
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.x.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.x);
    }

    public void o(SortSwitchButton.f fVar) {
        this.p = fVar;
    }

    public void p(View.OnClickListener onClickListener) {
        this.o = onClickListener;
    }

    public void q(BdUniqueId bdUniqueId) {
        SortSwitchButton sortSwitchButton = this.f19452e;
        if (sortSwitchButton != null) {
            sortSwitchButton.setListenerTag(bdUniqueId);
            this.f19452e.setCommenId(bdUniqueId);
        }
    }

    public void r(int i) {
        View view = this.f19449b;
        if (view != null) {
            view.setVisibility(i);
        }
    }

    public void s(boolean z) {
        if (z) {
            this.m.setText(R.string.hot_recommendation);
            this.m.setTypeface(Typeface.defaultFromStyle(1));
            this.m.setTextSize(0, l.g(this.t.getPageActivity(), R.dimen.T_X07));
            this.m.setVisibility(0);
            this.k.setVisibility(8);
            return;
        }
        this.m.setVisibility(8);
        this.k.setVisibility(0);
        this.m.setTypeface(Typeface.defaultFromStyle(0));
        this.m.setTextSize(0, l.g(this.t.getPageActivity(), R.dimen.tbfontsize42));
    }
}
