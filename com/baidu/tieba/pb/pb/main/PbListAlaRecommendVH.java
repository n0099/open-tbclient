package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import d.b.b.e.p.k;
import d.b.b.e.p.l;
import d.b.h0.r.q.v0;
import d.b.h0.r.u.c;
import d.b.i0.c2.h.e;
import d.b.i0.c2.k.e.y;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class PbListAlaRecommendVH extends TypeAdapter.ViewHolder implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public int f19719e;

    /* renamed from: f  reason: collision with root package name */
    public PbActivity f19720f;

    /* renamed from: g  reason: collision with root package name */
    public y f19721g;

    /* renamed from: h  reason: collision with root package name */
    public View f19722h;
    public TbImageView i;
    public TBLottieAnimationView j;
    public TextView k;
    public TextView l;
    public TextView m;
    public NEGFeedBackView n;
    public RelativeLayout o;
    public View p;
    public e q;

    /* loaded from: classes4.dex */
    public class a implements View.OnAttachStateChangeListener {
        public a() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            PbListAlaRecommendVH.this.j.playAnimation();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            PbListAlaRecommendVH.this.j.cancelAnimation();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements NEGFeedBackView.b {
        public b(PbListAlaRecommendVH pbListAlaRecommendVH) {
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void onCheckedChanged(v0 v0Var, CompoundButton compoundButton, boolean z) {
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void onNEGFeedbackConfirm(ArrayList<Integer> arrayList, String str, v0 v0Var) {
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void onNEGFeedbackWindowShow(v0 v0Var) {
            TiebaStatic.log(new StatisticItem("c13858").param("obj_type", 2));
        }
    }

    public PbListAlaRecommendVH(View view, PbActivity pbActivity) {
        super(view);
        this.f19719e = 3;
        this.f19720f = pbActivity;
        this.f19722h = view.findViewById(R.id.rootLayout);
        this.i = (TbImageView) view.findViewById(R.id.coverView);
        TBLottieAnimationView tBLottieAnimationView = (TBLottieAnimationView) view.findViewById(R.id.alaStateView);
        this.j = tBLottieAnimationView;
        tBLottieAnimationView.loop(true);
        SkinManager.setLottieAnimation(this.j, R.raw.ala_live2);
        this.j.addOnAttachStateChangeListener(new a());
        this.k = (TextView) view.findViewById(R.id.descView);
        this.l = (TextView) view.findViewById(R.id.userInfoView);
        this.m = (TextView) view.findViewById(R.id.audienceCountInfoView);
        this.o = (RelativeLayout) view.findViewById(R.id.layout_left);
        this.p = view.findViewById(R.id.ala_item_cross_line);
        this.i.setConrers(15);
        this.i.setRadius(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds21));
        this.i.setPlaceHolder(2);
        this.j.playAnimation();
    }

    public void c(y yVar) {
        d(TbadkCoreApplication.getInst().getSkinType());
        if (yVar == null) {
            return;
        }
        this.f19721g = yVar;
        this.f19722h.setOnClickListener(this);
        this.i.W(yVar.i, 10, false);
        if (yVar.f52935f == 1 && yVar.j > 0) {
            this.j.setVisibility(0);
        } else {
            this.j.setVisibility(8);
        }
        this.k.setText(yVar.f52937h);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.m.getLayoutParams();
        if (!k.isEmpty(yVar.f52934e)) {
            this.l.setText(yVar.f52934e);
            this.l.setVisibility(0);
            layoutParams.leftMargin = l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X004);
        } else {
            this.l.setVisibility(8);
            layoutParams.leftMargin = 0;
        }
        this.m.setLayoutParams(layoutParams);
        this.m.setText(String.format(this.f19720f.getResources().getString(R.string.pb_ala_audience_count), StringHelper.numFormatOverWan(yVar.f52936g)));
        i(yVar.r);
    }

    public final void d(int i) {
        if (this.f19719e != i) {
            SkinManager.setBackgroundSelector(this.f19722h, R.color.CAM_X0205, R.color.CAM_X0204, i);
            SkinManager.setViewTextColor(this.k, R.color.CAM_X0105, 1, i);
            SkinManager.setViewTextColor(this.l, R.color.CAM_X0109, 1, i);
            SkinManager.setViewTextColor(this.m, R.color.CAM_X0109, 1, i);
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0101, 1, i);
            NEGFeedBackView nEGFeedBackView = this.n;
            if (nEGFeedBackView != null) {
                nEGFeedBackView.q();
            }
            c a2 = c.a(this.j);
            a2.h(R.string.J_X01);
            a2.c(R.color.CAM_X0310);
            SkinManager.setBackgroundColor(this.p, R.color.CAM_X0203, i);
        }
        this.f19719e = i;
    }

    public final void e(y yVar) {
        if (yVar == null || yVar.f52935f != 1) {
            return;
        }
        if (yVar.m) {
            f(yVar.o, yVar.n);
        } else if (yVar.j > 0) {
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.liveID = yVar.j;
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.f19720f, alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_VIDEO_PB_CROSS_RECOMMEND, null, false, "")));
        }
    }

    public final void f(String str, String str2) {
        UrlManager urlManager = UrlManager.getInstance();
        TbPageContext<BaseFragmentActivity> pageContext = this.f19720f.getPageContext();
        urlManager.dealOneLink(pageContext, new String[]{"tiebachushou://liveroom?roomid=" + str + "&livetype=" + str2});
    }

    public final void g(y yVar) {
        e eVar = this.q;
        if (eVar == null || eVar.l() == null) {
            return;
        }
        StatisticItem param = new StatisticItem("c13717").param("fid", this.q.l().getId()).param("fname", this.q.l().getName()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.q.N());
        MetaData metaData = yVar.k;
        TiebaStatic.log(param.param("obj_param1", metaData != null ? metaData.getUserId() : ""));
    }

    public void h(e eVar) {
        y yVar;
        if (eVar == null || eVar.l() == null || (yVar = this.f19721g) == null || yVar.q) {
            return;
        }
        this.q = eVar;
        StatisticItem param = new StatisticItem("c13716").param("fid", eVar.l().getId()).param("fname", eVar.l().getName()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", eVar.N());
        MetaData metaData = this.f19721g.k;
        TiebaStatic.log(param.param("obj_param1", metaData != null ? metaData.getUserId() : ""));
        this.f19721g.q = true;
    }

    public final void i(v0 v0Var) {
        if (this.f19720f == null) {
            return;
        }
        if (v0Var == null) {
            NEGFeedBackView nEGFeedBackView = this.n;
            if (nEGFeedBackView != null) {
                nEGFeedBackView.setVisibility(8);
                return;
            }
            return;
        }
        if (this.n == null) {
            this.n = new NEGFeedBackView(this.f19720f.getPageContext());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(l.g(this.f19720f, R.dimen.tbds50), l.g(this.f19720f, R.dimen.tbds50));
            layoutParams.addRule(11);
            layoutParams.addRule(3, R.id.descView);
            layoutParams.topMargin = l.g(this.f19720f, R.dimen.tbds12);
            this.o.addView(this.n, layoutParams);
            this.n.setEventCallback(new b(this));
        }
        this.n.setWebPResId(R.drawable.icon_home_delete_n, R.color.CAM_X0111);
        this.n.setVisibility(0);
        this.n.setData(v0Var);
        this.n.q();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        y yVar = this.f19721g;
        if (yVar != null && id == R.id.rootLayout) {
            e(yVar);
            g(this.f19721g);
        }
    }
}
