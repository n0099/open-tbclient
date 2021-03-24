package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.data.PbGoodsData;
import com.baidu.tbadk.core.data.PbLinkData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.core.view.SingleLinkCardView;
import com.baidu.tbadk.core.view.ThreadForumEnterGoodsButton;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.videopb.VideoPbFragment;
import d.b.b.e.p.k;
import d.b.b.e.p.l;
import d.b.h0.r.q.a2;
import d.b.i0.c2.h.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class PbLinkGoodsRootView extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public c f19705e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f19706f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f19707g;

    /* renamed from: h  reason: collision with root package name */
    public RelativeLayout f19708h;
    public ThreadForumEnterGoodsButton i;
    public Context j;
    public BdRecyclerView k;
    public LinearLayout l;
    public int m;
    public int n;
    public int o;
    public int p;
    public List<d.b.i0.x.e0.c> q;
    public int r;
    public int s;
    public boolean t;
    public PbFragment u;
    public VideoPbFragment v;
    public a2 w;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PbLinkGoodsRootView.this.m();
        }
    }

    /* loaded from: classes4.dex */
    public class b extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public SingleLinkCardView f19710a;

        /* renamed from: b  reason: collision with root package name */
        public View f19711b;

        public b(View view) {
            super(view);
            this.f19711b = view.findViewById(R.id.mask_view);
            this.f19710a = (SingleLinkCardView) view.findViewById(R.id.pb_item_single_link_card);
        }
    }

    /* loaded from: classes4.dex */
    public class c extends RecyclerView.Adapter {

        /* loaded from: classes4.dex */
        public class a implements View.OnClickListener {
            public a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbLinkGoodsRootView.this.m();
            }
        }

        /* loaded from: classes4.dex */
        public class b implements View.OnClickListener {
            public b() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbLinkGoodsRootView.this.m();
            }
        }

        /* renamed from: com.baidu.tieba.pb.pb.main.PbLinkGoodsRootView$c$c  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class View$OnClickListenerC0216c implements View.OnClickListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f19716e;

            public View$OnClickListenerC0216c(int i) {
                this.f19716e = i;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbLinkGoodsRootView pbLinkGoodsRootView = PbLinkGoodsRootView.this;
                pbLinkGoodsRootView.p((d.b.i0.x.e0.c) pbLinkGoodsRootView.q.get(this.f19716e));
            }
        }

        public c() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return PbLinkGoodsRootView.this.r;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
            if (viewHolder instanceof b) {
                b bVar = (b) viewHolder;
                if (i >= PbLinkGoodsRootView.this.q.size() || PbLinkGoodsRootView.this.q.get(i) == null) {
                    return;
                }
                if (PbLinkGoodsRootView.this.u == null || PbLinkGoodsRootView.this.u.x4() || i != 2 || PbLinkGoodsRootView.this.q.size() <= 3) {
                    if (PbLinkGoodsRootView.this.v == null || PbLinkGoodsRootView.this.v.S2() || i != 2 || PbLinkGoodsRootView.this.q.size() <= 3) {
                        bVar.f19711b.setVisibility(8);
                    } else {
                        bVar.f19711b.setOnClickListener(new b());
                        bVar.f19711b.setVisibility(0);
                        TBSelector.makeDrawableSelector().setShape(0).gradientLinear(R.color.cp_bg_line_d_alpha70, R.color.CAM_X0201).into(bVar.f19711b);
                    }
                } else {
                    bVar.f19711b.setOnClickListener(new a());
                    bVar.f19711b.setVisibility(0);
                    TBSelector.makeDrawableSelector().setShape(0).gradientLinear(R.color.cp_bg_line_d_alpha70, R.color.CAM_X0201).into(bVar.f19711b);
                }
                bVar.f19710a.a((d.b.i0.x.e0.c) PbLinkGoodsRootView.this.q.get(i));
                bVar.f19710a.setOnClickListener(new View$OnClickListenerC0216c(i));
                if (!(PbLinkGoodsRootView.this.q.get(i) instanceof PbLinkData) || PbLinkGoodsRootView.this.q.get(i) == null) {
                    if (PbLinkGoodsRootView.this.q.get(i) instanceof PbGoodsData) {
                        PbLinkGoodsRootView.this.o("c13961", 2);
                    }
                } else if (((PbLinkData) PbLinkGoodsRootView.this.q.get(i)).urlType == 2) {
                    PbLinkGoodsRootView.this.o("c13961", 1);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            return new b(LayoutInflater.from(PbLinkGoodsRootView.this.j).inflate(R.layout.pb_link_goods_item_layout, (ViewGroup) null));
        }
    }

    public PbLinkGoodsRootView(Context context) {
        this(context, null);
    }

    public void i(e eVar, List<d.b.i0.x.e0.c> list, String str, PbFragment pbFragment, boolean z) {
        this.u = pbFragment;
        k(eVar, list, str, z);
        PbFragment pbFragment2 = this.u;
        if (pbFragment2 != null) {
            l(pbFragment2.x4());
        }
    }

    public void j(e eVar, List<d.b.i0.x.e0.c> list, String str, VideoPbFragment videoPbFragment, boolean z) {
        this.v = videoPbFragment;
        k(eVar, list, str, z);
        VideoPbFragment videoPbFragment2 = this.v;
        if (videoPbFragment2 != null) {
            l(videoPbFragment2.S2());
        }
    }

    public void k(e eVar, List<d.b.i0.x.e0.c> list, String str, boolean z) {
        this.q = list;
        a2 L = eVar.L();
        this.w = L;
        L.x3(eVar.n());
        this.w.t3(Long.valueOf(eVar.m()).longValue());
        this.t = z;
        this.r = list.size();
        if (list.size() < 4) {
            this.l.setVisibility(8);
        } else {
            this.l.setVisibility(0);
        }
        if (this.t) {
            this.t = z;
            this.i.setFrom(1);
            this.i.a(this.w);
            this.i.setVisibility(0);
            return;
        }
        this.i.setVisibility(8);
    }

    public final void l(boolean z) {
        Resources resources;
        int i;
        Resources resources2;
        int i2;
        if (z) {
            this.r = this.q.size();
            TextView textView = this.f19706f;
            if (this.t) {
                resources2 = getResources();
                i2 = R.string.pb_first_goods_more_close;
            } else {
                resources2 = getResources();
                i2 = R.string.pb_first_link_more_close;
            }
            textView.setText(resources2.getString(i2));
            this.s = R.drawable.icon_pure_fold12_svg;
        } else {
            if (this.r > 3) {
                this.r = 3;
            }
            TextView textView2 = this.f19706f;
            if (this.t) {
                resources = getResources();
                i = R.string.pb_first_goods_more_open;
            } else {
                resources = getResources();
                i = R.string.pb_first_link_more_open;
            }
            textView2.setText(resources.getString(i));
            this.s = R.drawable.icon_pure_unfold12_svg;
        }
        this.f19705e.notifyDataSetChanged();
        setMarginTop(z);
        SkinManager.setViewTextColor(this.f19706f, R.color.CAM_X0107);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f19707g, this.s, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public final void m() {
        PbFragment pbFragment = this.u;
        if (pbFragment != null) {
            if (pbFragment.x4()) {
                this.u.J5(false);
                l(false);
                return;
            }
            this.u.J5(true);
            l(true);
            n();
            return;
        }
        VideoPbFragment videoPbFragment = this.v;
        if (videoPbFragment != null) {
            if (videoPbFragment.S2()) {
                this.v.m4(false);
                l(false);
                return;
            }
            this.v.m4(true);
            l(true);
            n();
        }
    }

    public final void n() {
        if (this.w == null || !this.t) {
            return;
        }
        TiebaStatic.log(new StatisticItem("c13968").param("fid", this.w.c0()).param("fname", this.w.i0()).param("tid", this.w.w1()));
    }

    public final void o(String str, int i) {
        if (this.w != null) {
            TiebaStatic.log(new StatisticItem(str).param("obj_type", i).param("fid", this.w.c0()).param("fname", this.w.i0()).param("tid", this.w.w1()));
        }
    }

    public final void p(d.b.i0.x.e0.c cVar) {
        if (cVar instanceof PbLinkData) {
            PbLinkData pbLinkData = (PbLinkData) cVar;
            if (pbLinkData == null) {
                return;
            }
            TbPageContextSupport tbPageContextSupport = (TbPageContextSupport) this.j;
            if (pbLinkData.urlType == 1) {
                UrlManager.getInstance().dealOneLink(tbPageContextSupport.getPageContext(), new String[]{pbLinkData.linkUrl});
            } else {
                UrlManager urlManager = UrlManager.getInstance();
                TbPageContext<?> pageContext = tbPageContextSupport.getPageContext();
                urlManager.dealOneLink(pageContext, new String[]{"http://tieba.baidu.com/mo/q/checkurl?url=" + k.getUrlEncode(pbLinkData.linkUrl)});
            }
            if (pbLinkData.urlType == 2) {
                o("c13962", 1);
            }
        } else if (cVar instanceof PbGoodsData) {
            TbPageContextSupport tbPageContextSupport2 = (TbPageContextSupport) this.j;
            PbGoodsData pbGoodsData = (PbGoodsData) cVar;
            if (pbGoodsData == null) {
                return;
            }
            if (!TextUtils.isEmpty(pbGoodsData.linkUrl)) {
                if (pbGoodsData.linkUrl.startsWith("tiebaclient://")) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921361, pbGoodsData.linkUrl));
                } else {
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(pbGoodsData.linkUrl));
                    intent.addFlags(268468224);
                    if (UtilHelper.isHaveActivityCanHandleIntent(intent)) {
                        this.j.startActivity(intent);
                    } else if (!TextUtils.isEmpty(pbGoodsData.goodsUrlH5)) {
                        UrlManager urlManager2 = UrlManager.getInstance();
                        TbPageContext<?> pageContext2 = tbPageContextSupport2.getPageContext();
                        urlManager2.dealOneLink(pageContext2, new String[]{"http://tieba.baidu.com/mo/q/checkurl?url=" + k.getUrlEncode(pbGoodsData.goodsUrlH5)});
                    }
                }
            } else {
                UrlManager urlManager3 = UrlManager.getInstance();
                TbPageContext<?> pageContext3 = tbPageContextSupport2.getPageContext();
                urlManager3.dealOneLink(pageContext3, new String[]{"http://tieba.baidu.com/mo/q/checkurl?url=" + k.getUrlEncode(pbGoodsData.goodsUrlH5)});
            }
            o("c13962", 2);
        }
    }

    public void setMarginTop(boolean z) {
        if (z) {
            this.l.setPadding(0, this.o, 0, this.p);
        } else {
            this.l.setPadding(0, this.m, 0, this.n);
        }
    }

    public PbLinkGoodsRootView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PbLinkGoodsRootView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.q = new ArrayList();
        this.r = 3;
        this.t = false;
        this.j = context;
        LayoutInflater.from(context).inflate(R.layout.pb_link_goods_layout, this);
        BdRecyclerView bdRecyclerView = (BdRecyclerView) findViewById(R.id.pb_link_goods_rv);
        this.k = bdRecyclerView;
        bdRecyclerView.setNestedScrollingEnabled(false);
        this.l = (LinearLayout) findViewById(R.id.pb_more_post_rl);
        this.f19706f = (TextView) findViewById(R.id.tv_post);
        this.f19708h = (RelativeLayout) findViewById(R.id.rl_more_post);
        this.f19707g = (ImageView) findViewById(R.id.iv_arrow);
        this.i = (ThreadForumEnterGoodsButton) findViewById(R.id.pb_tip_enter_button);
        this.m = l.g(this.j, R.dimen.tbds14);
        this.n = l.g(this.j, R.dimen.tbds44);
        this.o = l.g(this.j, R.dimen.tbds36);
        this.p = l.g(this.j, R.dimen.tbds22);
        this.f19705e = new c();
        this.k.setLayoutManager(new LinearLayoutManager(this.j));
        this.k.setAdapter(this.f19705e);
        this.f19708h.setOnClickListener(new a());
    }
}
