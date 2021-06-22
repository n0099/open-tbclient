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
import d.a.c.e.p.j;
import d.a.c.e.p.l;
import d.a.o0.e2.h.o;
import d.a.o0.e2.k.e.t0;
import d.a.o0.e3.h0.r;
import java.util.ArrayList;
import java.util.List;
import tbclient.PbPage.PbSortType;
/* loaded from: classes5.dex */
public class PbReplyTitleViewHolder extends TypeAdapter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public int f19289a;

    /* renamed from: b  reason: collision with root package name */
    public View f19290b;

    /* renamed from: c  reason: collision with root package name */
    public TextLineView f19291c;

    /* renamed from: d  reason: collision with root package name */
    public TextLineView f19292d;

    /* renamed from: e  reason: collision with root package name */
    public SortSwitchButton f19293e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f19294f;

    /* renamed from: g  reason: collision with root package name */
    public View f19295g;

    /* renamed from: h  reason: collision with root package name */
    public View f19296h;

    /* renamed from: i  reason: collision with root package name */
    public View f19297i;
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

    /* loaded from: classes5.dex */
    public class a implements SortSwitchButton.f {
        public a() {
        }

        @Override // com.baidu.tieba.view.SortSwitchButton.f
        public boolean a(int i2) {
            if (PbReplyTitleViewHolder.this.p != null) {
                return PbReplyTitleViewHolder.this.p.a(i2);
            }
            return true;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public b(PbReplyTitleViewHolder pbReplyTitleViewHolder) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PbReplyTitleViewHolder.this.o != null) {
                PbReplyTitleViewHolder.this.o.onClick(PbReplyTitleViewHolder.this.f19297i);
            }
        }
    }

    /* loaded from: classes5.dex */
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

    /* loaded from: classes5.dex */
    public class e extends CustomMessageListener {
        public e(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbReplyTitleViewHolder.this.q != null && PbReplyTitleViewHolder.this.q.f56770f == o.l && customResponsedMessage != null && getTag() == PbReplyTitleViewHolder.this.r && (customResponsedMessage.getData() instanceof t0.l0)) {
                ((t0.l0) customResponsedMessage.getData()).f57302c = PbReplyTitleViewHolder.this;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f extends CustomMessageListener {
        public f(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbReplyTitleViewHolder.this.q == null || PbReplyTitleViewHolder.this.q.f56770f != o.m || customResponsedMessage == null || getTag() != PbReplyTitleViewHolder.this.s || !(customResponsedMessage.getData() instanceof t0.l0)) {
            }
        }
    }

    public PbReplyTitleViewHolder(TbPageContext tbPageContext, View view) {
        super(view);
        this.f19289a = 3;
        this.u = true;
        this.v = new a();
        this.w = new d();
        this.x = new e(2004013);
        this.y = new f(2004013);
        if (view == null) {
            return;
        }
        this.f19290b = view;
        this.t = tbPageContext;
        view.setOnClickListener(new b(this));
        TextLineView textLineView = (TextLineView) view.findViewById(R.id.reply_title);
        this.f19291c = textLineView;
        textLineView.setOnClickListener(this.w);
        this.f19297i = view.findViewById(R.id.reply_god_title_group);
        TextLineView textLineView2 = (TextLineView) view.findViewById(R.id.reply_god_title);
        this.j = textLineView2;
        textLineView2.setSelected(false);
        this.l = view.findViewById(R.id.reply_all_title_frame);
        this.k = view.findViewById(R.id.reply_all_title);
        this.m = (TextView) view.findViewById(R.id.reply_title_dynamic);
        TextLineView textLineView3 = (TextLineView) view.findViewById(R.id.floor_owner_reply);
        this.f19292d = textLineView3;
        textLineView3.setOnClickListener(this.w);
        SortSwitchButton sortSwitchButton = (SortSwitchButton) view.findViewById(R.id.pb_sort_switch_btn);
        this.f19293e = sortSwitchButton;
        sortSwitchButton.setOnSwitchChangeListener(this.v);
        this.f19293e.setVisibility(0);
        this.f19294f = (TextView) view.findViewById(R.id.pb_god_reply_entrance_text);
        this.f19291c.setSelected(true);
        this.f19292d.setSelected(false);
        ArrayList arrayList = new ArrayList();
        this.n = arrayList;
        arrayList.add(this.f19291c);
        this.n.add(this.f19292d);
        this.f19295g = view.findViewById(R.id.divider_with_reply_title);
        this.f19296h = view.findViewById(R.id.divider_bottom);
        this.f19293e.u(2);
        l(TbadkCoreApplication.getInst().getSkinType());
    }

    public void h(o oVar) {
        this.q = oVar;
        if (oVar == null) {
            return;
        }
        BdUniqueId bdUniqueId = oVar.f56770f;
        if (bdUniqueId == o.m) {
            this.f19297i.getContext();
            if (TextUtils.isEmpty(oVar.f56769e)) {
                this.l.setVisibility(0);
                this.f19297i.setVisibility(8);
                this.f19291c.setVisibility(0);
                this.f19291c.setSelected(false);
                this.f19291c.setClickable(false);
                this.f19291c.setText(TbadkCoreApplication.getInst().getString(R.string.god_reply));
            } else {
                this.l.setVisibility(8);
                this.f19291c.setVisibility(8);
                this.f19297i.setVisibility(0);
                this.f19297i.setOnClickListener(new c());
            }
            this.f19293e.setVisibility(8);
            this.f19292d.setVisibility(8);
            this.f19296h.setVisibility(8);
        } else if (bdUniqueId == o.l) {
            this.f19297i.setVisibility(8);
            this.l.setVisibility(0);
            this.f19291c.setClickable(true);
            this.f19291c.setText(TbadkCoreApplication.getInst().getString(R.string.all_reply));
            this.f19292d.setVisibility(0);
            i(oVar.f56772h);
            if (oVar.k != null) {
                this.f19293e.setVisibility(0);
                int i2 = 0;
                while (true) {
                    if (i2 >= oVar.k.size()) {
                        i2 = 0;
                        break;
                    } else if (oVar.k.get(i2) != null && oVar.f56771g == oVar.k.get(i2).sort_type.intValue()) {
                        break;
                    } else {
                        i2++;
                    }
                }
                k(oVar.k, i2);
            }
            this.f19296h.setVisibility(0);
        }
        if (this.u) {
            this.f19296h.getLayoutParams().height = l.g(TbadkCoreApplication.getInst(), R.dimen.L_X01);
            SkinManager.setBackgroundColor(this.l, R.color.CAM_X0207);
        } else {
            this.f19296h.getLayoutParams().height = 0;
            SkinManager.setBackgroundColor(this.l, R.color.CAM_X0205);
        }
        if (oVar.f56773i) {
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
            this.f19292d.setSelected(true);
            this.f19291c.setSelected(false);
            return;
        }
        this.f19292d.setSelected(false);
        this.f19291c.setSelected(true);
    }

    public View j() {
        return this.f19290b;
    }

    public void k(List<PbSortType> list, int i2) {
        if (ListUtils.isEmpty(list)) {
            this.f19293e.setVisibility(8);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (PbSortType pbSortType : list) {
            r rVar = new r();
            rVar.c(pbSortType.sort_type.intValue());
            rVar.d(pbSortType.sort_name);
            arrayList.add(rVar);
        }
        this.f19293e.setVisibility(0);
        this.f19293e.setData(arrayList, i2);
    }

    public void l(int i2) {
        if (this.f19289a != i2) {
            SkinManager.setBackgroundColor(this.l, R.color.CAM_X0201);
            SkinManager.setBackgroundColor(this.f19297i, R.color.CAM_X0201);
            this.f19291c.b(i2);
            this.f19292d.b(i2);
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0105);
            o oVar = this.q;
            if (oVar != null && oVar.f56770f == o.m) {
                SkinManager.setViewTextColor(this.f19291c, R.color.CAM_X0107, 1);
            }
            SkinManager.setViewTextColor(this.f19294f, R.color.CAM_X0107);
            this.f19294f.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(R.drawable.icon_gob_reply_jump), (Drawable) null);
            this.f19293e.F();
            SkinManager.setBackgroundColor(this.f19295g, R.color.CAM_X0204);
            if (this.u) {
                SkinManager.setBackgroundColor(this.f19296h, R.color.CAM_X0203);
                SkinManager.setBackgroundColor(this.l, R.color.CAM_X0207);
            } else {
                SkinManager.setBackgroundColor(this.l, R.color.CAM_X0205);
            }
            SkinManager.setViewTextColor(this.m, R.color.CAM_X0105, 1);
        }
        this.f19289a = i2;
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
        SortSwitchButton sortSwitchButton = this.f19293e;
        if (sortSwitchButton != null) {
            sortSwitchButton.setListenerTag(bdUniqueId);
            this.f19293e.setCommenId(bdUniqueId);
        }
    }

    public void r(int i2) {
        View view = this.f19290b;
        if (view != null) {
            view.setVisibility(i2);
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
