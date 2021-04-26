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
import d.a.c.e.p.k;
import d.a.c.e.p.l;
import d.a.i0.r.q.v0;
import d.a.i0.r.u.c;
import d.a.j0.d2.h.e;
import d.a.j0.d2.k.e.a0;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class PbListAlaRecommendVH extends TypeAdapter.ViewHolder implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public int f19878e;

    /* renamed from: f  reason: collision with root package name */
    public PbActivity f19879f;

    /* renamed from: g  reason: collision with root package name */
    public a0 f19880g;

    /* renamed from: h  reason: collision with root package name */
    public View f19881h;

    /* renamed from: i  reason: collision with root package name */
    public TbImageView f19882i;
    public TBLottieAnimationView j;
    public TextView k;
    public TextView l;
    public TextView m;
    public NEGFeedBackView n;
    public RelativeLayout o;
    public View p;
    public e q;

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
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
        this.f19878e = 3;
        this.f19879f = pbActivity;
        this.f19881h = view.findViewById(R.id.rootLayout);
        this.f19882i = (TbImageView) view.findViewById(R.id.coverView);
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
        this.f19882i.setConrers(15);
        this.f19882i.setRadius(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds21));
        this.f19882i.setPlaceHolder(2);
        this.j.playAnimation();
    }

    public void c(a0 a0Var) {
        d(TbadkCoreApplication.getInst().getSkinType());
        if (a0Var == null) {
            return;
        }
        this.f19880g = a0Var;
        this.f19881h.setOnClickListener(this);
        this.f19882i.V(a0Var.f52175i, 10, false);
        if (a0Var.f52172f == 1 && a0Var.j > 0) {
            this.j.setVisibility(0);
        } else {
            this.j.setVisibility(8);
        }
        this.k.setText(a0Var.f52174h);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.m.getLayoutParams();
        if (!k.isEmpty(a0Var.f52171e)) {
            this.l.setText(a0Var.f52171e);
            this.l.setVisibility(0);
            layoutParams.leftMargin = l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X004);
        } else {
            this.l.setVisibility(8);
            layoutParams.leftMargin = 0;
        }
        this.m.setLayoutParams(layoutParams);
        this.m.setText(String.format(this.f19879f.getResources().getString(R.string.pb_ala_audience_count), StringHelper.numFormatOverWan(a0Var.f52173g)));
        i(a0Var.r);
    }

    public final void d(int i2) {
        if (this.f19878e != i2) {
            SkinManager.setBackgroundSelector(this.f19881h, R.color.CAM_X0205, R.color.CAM_X0204, i2);
            SkinManager.setViewTextColor(this.k, R.color.CAM_X0105, 1, i2);
            SkinManager.setViewTextColor(this.l, R.color.CAM_X0109, 1, i2);
            SkinManager.setViewTextColor(this.m, R.color.CAM_X0109, 1, i2);
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0101, 1, i2);
            NEGFeedBackView nEGFeedBackView = this.n;
            if (nEGFeedBackView != null) {
                nEGFeedBackView.q();
            }
            c d2 = c.d(this.j);
            d2.k(R.string.J_X01);
            d2.f(R.color.CAM_X0310);
            SkinManager.setBackgroundColor(this.p, R.color.CAM_X0203, i2);
        }
        this.f19878e = i2;
    }

    public final void e(a0 a0Var) {
        if (a0Var == null || a0Var.f52172f != 1) {
            return;
        }
        if (a0Var.m) {
            f(a0Var.o, a0Var.n);
        } else if (a0Var.j > 0) {
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.liveID = a0Var.j;
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.f19879f, alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_VIDEO_PB_CROSS_RECOMMEND, null, false, "")));
        }
    }

    public final void f(String str, String str2) {
        UrlManager urlManager = UrlManager.getInstance();
        TbPageContext<BaseFragmentActivity> pageContext = this.f19879f.getPageContext();
        urlManager.dealOneLink(pageContext, new String[]{"tiebachushou://liveroom?roomid=" + str + "&livetype=" + str2});
    }

    public final void g(a0 a0Var) {
        e eVar = this.q;
        if (eVar == null || eVar.l() == null) {
            return;
        }
        StatisticItem param = new StatisticItem("c13717").param("fid", this.q.l().getId()).param("fname", this.q.l().getName()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.q.N());
        MetaData metaData = a0Var.k;
        TiebaStatic.log(param.param("obj_param1", metaData != null ? metaData.getUserId() : ""));
    }

    public void h(e eVar) {
        a0 a0Var;
        if (eVar == null || eVar.l() == null || (a0Var = this.f19880g) == null || a0Var.q) {
            return;
        }
        this.q = eVar;
        StatisticItem param = new StatisticItem("c13716").param("fid", eVar.l().getId()).param("fname", eVar.l().getName()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", eVar.N());
        MetaData metaData = this.f19880g.k;
        TiebaStatic.log(param.param("obj_param1", metaData != null ? metaData.getUserId() : ""));
        this.f19880g.q = true;
    }

    public final void i(v0 v0Var) {
        if (this.f19879f == null) {
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
            this.n = new NEGFeedBackView(this.f19879f.getPageContext());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(l.g(this.f19879f, R.dimen.tbds50), l.g(this.f19879f, R.dimen.tbds50));
            layoutParams.addRule(11);
            layoutParams.addRule(3, R.id.descView);
            layoutParams.topMargin = l.g(this.f19879f, R.dimen.tbds12);
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
        a0 a0Var = this.f19880g;
        if (a0Var != null && id == R.id.rootLayout) {
            e(a0Var);
            g(this.f19880g);
        }
    }
}
