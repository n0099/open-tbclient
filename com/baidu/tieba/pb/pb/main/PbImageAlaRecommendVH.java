package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.core.util.tbselector.selector.DrawableSelector;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.view.DynamicUserLikeButton;
import d.b.b.e.p.l;
import d.b.h0.r.f0.q.c;
import d.b.h0.r.q.v0;
import d.b.i0.c2.h.e;
import d.b.i0.c2.k.e.w;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class PbImageAlaRecommendVH extends TypeAdapter.ViewHolder implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public int f19693e;

    /* renamed from: f  reason: collision with root package name */
    public w f19694f;

    /* renamed from: g  reason: collision with root package name */
    public TbPageContext f19695g;

    /* renamed from: h  reason: collision with root package name */
    public View f19696h;
    public TextView i;
    public DynamicUserLikeButton j;
    public TextView k;
    public TbImageView l;
    public TextView m;
    public TextView n;
    public View o;
    public View p;
    public View q;
    public NEGFeedBackView r;
    public c s;
    public BdUniqueId t;
    public e u;

    /* loaded from: classes4.dex */
    public class a implements NEGFeedBackView.b {
        public a(PbImageAlaRecommendVH pbImageAlaRecommendVH) {
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void onCheckedChanged(v0 v0Var, CompoundButton compoundButton, boolean z) {
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void onNEGFeedbackConfirm(ArrayList<Integer> arrayList, String str, v0 v0Var) {
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void onNEGFeedbackWindowShow(v0 v0Var) {
            TiebaStatic.log(new StatisticItem("c13858").param("obj_type", 1));
        }
    }

    /* loaded from: classes4.dex */
    public class b implements DynamicUserLikeButton.a {
        public b() {
        }

        @Override // com.baidu.tieba.view.DynamicUserLikeButton.a
        public void a(View view) {
            if (PbImageAlaRecommendVH.this.u == null || PbImageAlaRecommendVH.this.u.l() == null || PbImageAlaRecommendVH.this.f19694f == null || PbImageAlaRecommendVH.this.f19694f.k == null) {
                return;
            }
            TiebaStatic.log(new StatisticItem("c13718").param("fid", PbImageAlaRecommendVH.this.u.l().getId()).param("fname", PbImageAlaRecommendVH.this.u.l().getName()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", PbImageAlaRecommendVH.this.u.N()).param(TiebaStatic.Params.FRIEND_UID, PbImageAlaRecommendVH.this.f19694f.k != null ? PbImageAlaRecommendVH.this.f19694f.k.getUserId() : "").param("obj_type", !PbImageAlaRecommendVH.this.f19694f.k.getIsLike()));
        }
    }

    public PbImageAlaRecommendVH(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(view);
        this.f19693e = 3;
        this.f19695g = tbPageContext;
        this.t = bdUniqueId;
        if (view == null) {
            return;
        }
        this.o = view.findViewById(R.id.rootLayout);
        this.f19696h = view.findViewById(R.id.top_divider_line);
        this.i = (TextView) view.findViewById(R.id.titleView);
        this.j = (DynamicUserLikeButton) view.findViewById(R.id.followBtn);
        this.k = (TextView) view.findViewById(R.id.alaStateView);
        this.l = (TbImageView) view.findViewById(R.id.coverView);
        this.m = (TextView) view.findViewById(R.id.descView);
        this.n = (TextView) view.findViewById(R.id.hotView);
        this.p = view.findViewById(R.id.hotPoint);
        this.q = view.findViewById(R.id.bottomSpaceView);
        this.j.setTextSize(R.dimen.tbds28);
        this.l.setPlaceHolder(2);
        this.l.setRadius(l.g(view.getContext(), R.dimen.tbds10));
        this.l.setConrers(15);
    }

    public void d(w wVar) {
        g(TbadkCoreApplication.getInst().getSkinType());
        if (wVar == null) {
            return;
        }
        this.f19694f = wVar;
        this.o.setOnClickListener(this);
        this.l.W(wVar.f52856h, 10, false);
        if (wVar.i == 1 && wVar.j > 0) {
            this.k.setVisibility(0);
        } else {
            this.k.setVisibility(8);
        }
        this.m.setText(wVar.f52855g);
        TextView textView = this.i;
        textView.setText(String.format(textView.getContext().getResources().getString(R.string.pb_ala_name), StringHelper.getFixedText(wVar.f52853e, 7, true)));
        TextView textView2 = this.n;
        textView2.setText(String.format(textView2.getContext().getResources().getString(R.string.pb_ala_audience_count), StringHelper.numFormatOverWan(wVar.f52854f)));
        this.q.setVisibility(wVar.r ? 8 : 0);
        j(wVar.s);
        k();
    }

    public final void e(w wVar) {
        if (wVar == null || wVar.i != 1) {
            return;
        }
        if (wVar.m) {
            f(wVar.o, wVar.n);
        } else if (wVar.j > 0) {
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.liveID = wVar.j;
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.o.getContext(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_ARTICLE_PB_RECOMMEND, null, false, "")));
        }
    }

    public final void f(String str, String str2) {
        UrlManager urlManager = UrlManager.getInstance();
        TbPageContext<?> tbPageContext = this.f19695g;
        urlManager.dealOneLink(tbPageContext, new String[]{"tiebachushou://liveroom?roomid=" + str + "&livetype=" + str2});
    }

    public final void g(int i) {
        if (this.f19693e != i) {
            SkinManager.setBackgroundSelector(this.o, R.color.CAM_X0205, R.color.CAM_X0204, i);
            SkinManager.setBackgroundColor(this.f19696h, R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.m, R.color.CAM_X0105, 1, i);
            SkinManager.setViewTextColor(this.i, R.color.CAM_X0105, 1, i);
            SkinManager.setViewTextColor(this.n, R.color.CAM_X0109, 1, i);
            SkinManager.setViewTextColor(this.k, R.color.CAM_X0101, 1, i);
            NEGFeedBackView nEGFeedBackView = this.r;
            if (nEGFeedBackView != null) {
                nEGFeedBackView.q();
            }
            View view = this.p;
            view.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(l.g(view.getContext(), R.dimen.tbds32), SkinManager.getColor(R.color.CAM_X0309)));
            float g2 = l.g(this.k.getContext(), R.dimen.tbds10);
            TBSelector.makeDrawableSelector().setShape(0).gradientLinear(DrawableSelector.TL_BR, R.color.CAM_X0308, R.color.CAM_X0301).tlRadius(g2).brRadius(g2).into(this.k);
            this.j.r(i);
        }
        this.f19693e = i;
    }

    public final void h(w wVar) {
        e eVar = this.u;
        if (eVar == null || eVar.l() == null) {
            return;
        }
        StatisticItem param = new StatisticItem("c13709").param("fid", this.u.l().getId()).param("fname", this.u.l().getName()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.u.N());
        MetaData metaData = wVar.k;
        TiebaStatic.log(param.param("obj_param1", metaData != null ? metaData.getUserId() : ""));
    }

    public void i(e eVar) {
        w wVar;
        if (eVar == null || eVar.l() == null || (wVar = this.f19694f) == null || wVar.q) {
            return;
        }
        this.u = eVar;
        StatisticItem param = new StatisticItem("c13708").param("fid", eVar.l().getId()).param("fname", eVar.l().getName()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", eVar.N());
        MetaData metaData = this.f19694f.k;
        TiebaStatic.log(param.param("obj_param1", metaData != null ? metaData.getUserId() : ""));
        this.f19694f.q = true;
    }

    public final void j(v0 v0Var) {
        TbPageContext tbPageContext = this.f19695g;
        if (tbPageContext == null) {
            return;
        }
        if (v0Var == null) {
            NEGFeedBackView nEGFeedBackView = this.r;
            if (nEGFeedBackView != null) {
                nEGFeedBackView.setVisibility(8);
                return;
            }
            return;
        }
        if (this.r == null) {
            int g2 = l.g(tbPageContext.getPageActivity(), R.dimen.tbds44);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(l.g(this.f19695g.getPageActivity(), R.dimen.tbds130), l.g(this.f19695g.getPageActivity(), R.dimen.tbds86));
            layoutParams.addRule(11);
            layoutParams.addRule(8, R.id.coverView);
            NEGFeedBackView nEGFeedBackView2 = new NEGFeedBackView(this.f19695g);
            this.r = nEGFeedBackView2;
            nEGFeedBackView2.setPadding(g2, g2, g2, 0);
            ((RelativeLayout) this.o.findViewById(R.id.contentLayout)).addView(this.r, layoutParams);
            this.r.setEventCallback(new a(this));
        }
        this.r.setVisibility(0);
        this.r.setData(v0Var);
        this.r.q();
    }

    public final void k() {
        w wVar = this.f19694f;
        if (wVar != null && wVar.k != null) {
            this.j.setVisibility(0);
            if (this.s == null) {
                c cVar = new c(this.f19695g, this.j);
                this.s = cVar;
                cVar.l(this.t);
            }
            this.s.n(this.f19694f.k);
            this.j.setOnClickEvent(new b());
            return;
        }
        this.j.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        w wVar = this.f19694f;
        if (wVar != null && id == R.id.rootLayout) {
            e(wVar);
            h(this.f19694f);
        }
    }
}
