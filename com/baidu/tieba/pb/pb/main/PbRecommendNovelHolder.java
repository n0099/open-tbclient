package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BookCoverActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import d.a.c.a.j;
import d.a.c.e.p.l;
import d.a.n0.r.q.d1;
import d.a.n0.r.q.y0;
import java.util.List;
/* loaded from: classes5.dex */
public class PbRecommendNovelHolder extends TypeAdapter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f19279a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f19280b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f19281c;

    /* renamed from: d  reason: collision with root package name */
    public TbImageView f19282d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f19283e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f19284f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f19285g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f19286h;

    /* renamed from: i  reason: collision with root package name */
    public TbImageView f19287i;
    public LinearLayout j;
    public View k;
    public d1 l;
    public b m;
    public View.OnClickListener n;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ViewHelper.checkUpIsLogin(PbRecommendNovelHolder.this.f19279a.getPageActivity()) && l.D() && PbRecommendNovelHolder.this.l != null && !StringUtils.isNull(PbRecommendNovelHolder.this.l.F0)) {
                if (!TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                    l.L(PbRecommendNovelHolder.this.f19279a.getPageActivity(), R.string.book_plugin_not_install_tip);
                    return;
                }
                if (PbRecommendNovelHolder.this.m != null) {
                    PbRecommendNovelHolder.this.m.a(PbRecommendNovelHolder.this.l);
                }
                PbRecommendNovelHolder pbRecommendNovelHolder = PbRecommendNovelHolder.this;
                if (view == pbRecommendNovelHolder.f19286h) {
                    String str = pbRecommendNovelHolder.l.F0;
                    y0 y0Var = new y0();
                    TbPageContext tbPageContext = (TbPageContext) j.a(PbRecommendNovelHolder.this.f19279a.getPageActivity());
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001417, y0Var));
                    TiebaStatic.log(new StatisticItem("c11387").param("obj_source", 6).param("obj_locate", "0").param("obj_param1", str));
                    TiebaStatic.log(new StatisticItem("c11442").param("obj_id", PbRecommendNovelHolder.this.l.F0).param("obj_locate", "3"));
                } else if (view == pbRecommendNovelHolder.j) {
                    PbRecommendNovelHolder.this.f19279a.sendMessage(new CustomMessage(2002001, new BookCoverActivityConfig(PbRecommendNovelHolder.this.f19279a.getPageActivity(), PbRecommendNovelHolder.this.l.F0)));
                    TiebaStatic.log(new StatisticItem("c11442").param("obj_id", PbRecommendNovelHolder.this.l.F0).param("obj_locate", "1"));
                } else if (view != pbRecommendNovelHolder.f19281c || StringUtils.isNull(pbRecommendNovelHolder.l.E0)) {
                } else {
                    UrlManager.getInstance().dealOneLink((TbPageContext) j.a(PbRecommendNovelHolder.this.f19279a.getPageActivity()), new String[]{PbRecommendNovelHolder.this.l.E0});
                    TiebaStatic.log(new StatisticItem("c11442").param("obj_id", PbRecommendNovelHolder.this.l.F0).param("obj_locate", "2"));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a(d1 d1Var);
    }

    public PbRecommendNovelHolder(TbPageContext tbPageContext, View view, b bVar) {
        super(view);
        this.n = new a();
        this.f19279a = tbPageContext;
        this.m = bVar;
        this.f19280b = (TextView) view.findViewById(R.id.textview_recommend_title);
        this.f19281c = (TextView) view.findViewById(R.id.textview_recommend_option_btn);
        this.f19282d = (TbImageView) view.findViewById(R.id.novel_cover);
        this.f19283e = (TextView) view.findViewById(R.id.novel_title);
        this.f19284f = (TextView) view.findViewById(R.id.novel_author);
        this.f19285g = (TextView) view.findViewById(R.id.novel_read_number);
        this.f19286h = (TextView) view.findViewById(R.id.novel_read_btn);
        this.j = (LinearLayout) view.findViewById(R.id.novel_recommend_item_layout);
        TbImageView tbImageView = (TbImageView) view.findViewById(R.id.novel_subscription);
        this.f19287i = tbImageView;
        tbImageView.setDefaultResource(R.drawable.transparent_bg);
        this.f19287i.setDefaultBgResource(R.drawable.transparent_bg);
        this.k = view.findViewById(R.id.recommend_devider);
        this.f19286h.setOnClickListener(this.n);
        this.j.setOnClickListener(this.n);
        this.f19281c.setOnClickListener(this.n);
    }

    public void e(d1 d1Var) {
        if (d1Var == null) {
            return;
        }
        this.l = d1Var;
        this.f19280b.setText(d1Var.C0);
        this.f19281c.setText(d1Var.D0);
        this.f19287i.U(d1Var.K0, 10, false);
        this.f19282d.U(d1Var.G0, 10, false);
        this.f19286h.setText(d1Var.J0);
        this.f19283e.setText(d1Var.H0);
        List<String> list = d1Var.I0;
        if (list != null) {
            int size = list.size();
            if (size != 1) {
                if (size == 2) {
                    if (list.get(0) != null) {
                        this.f19284f.setText(list.get(0));
                    }
                    if (list.get(1) != null) {
                        this.f19285g.setText(list.get(1));
                    }
                }
            } else if (list.get(0) != null) {
                this.f19284f.setText(list.get(0));
            }
        }
        SkinManager.setViewTextColor(this.f19280b, R.color.CAM_X0109, 1);
        SkinManager.setViewTextColor(this.f19281c, R.color.CAM_X0302, 1);
        SkinManager.setViewTextColor(this.f19283e, R.color.CAM_X0105, 1);
        SkinManager.setViewTextColor(this.f19284f, R.color.CAM_X0109, 1);
        SkinManager.setViewTextColor(this.f19285g, R.color.CAM_X0109, 1);
        SkinManager.setViewTextColor(this.f19286h, R.color.CAM_X0302, 1);
        SkinManager.setBackgroundColor(this.k, R.color.CAM_X0204);
        SkinManager.setBackgroundResource(this.f19286h, R.drawable.btn_pb_novel_recommend_read);
        TiebaStatic.log(new StatisticItem("c11441").param("obj_id", this.l.F0));
    }
}
