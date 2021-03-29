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
import d.b.b.a.j;
import d.b.b.e.p.l;
import d.b.h0.r.q.d1;
import d.b.h0.r.q.y0;
import java.util.List;
/* loaded from: classes4.dex */
public class PbRecommendNovelHolder extends TypeAdapter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f19754a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f19755b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f19756c;

    /* renamed from: d  reason: collision with root package name */
    public TbImageView f19757d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f19758e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f19759f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f19760g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f19761h;
    public TbImageView i;
    public LinearLayout j;
    public View k;
    public d1 l;
    public b m;
    public View.OnClickListener n;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ViewHelper.checkUpIsLogin(PbRecommendNovelHolder.this.f19754a.getPageActivity()) && l.C() && PbRecommendNovelHolder.this.l != null && !StringUtils.isNull(PbRecommendNovelHolder.this.l.z0)) {
                if (!TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                    l.K(PbRecommendNovelHolder.this.f19754a.getPageActivity(), R.string.book_plugin_not_install_tip);
                    return;
                }
                if (PbRecommendNovelHolder.this.m != null) {
                    PbRecommendNovelHolder.this.m.a(PbRecommendNovelHolder.this.l);
                }
                PbRecommendNovelHolder pbRecommendNovelHolder = PbRecommendNovelHolder.this;
                if (view == pbRecommendNovelHolder.f19761h) {
                    String str = pbRecommendNovelHolder.l.z0;
                    y0 y0Var = new y0();
                    TbPageContext tbPageContext = (TbPageContext) j.a(PbRecommendNovelHolder.this.f19754a.getPageActivity());
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001417, y0Var));
                    TiebaStatic.log(new StatisticItem("c11387").param("obj_source", 6).param("obj_locate", "0").param("obj_param1", str));
                    TiebaStatic.log(new StatisticItem("c11442").param("obj_id", PbRecommendNovelHolder.this.l.z0).param("obj_locate", "3"));
                } else if (view == pbRecommendNovelHolder.j) {
                    PbRecommendNovelHolder.this.f19754a.sendMessage(new CustomMessage(2002001, new BookCoverActivityConfig(PbRecommendNovelHolder.this.f19754a.getPageActivity(), PbRecommendNovelHolder.this.l.z0)));
                    TiebaStatic.log(new StatisticItem("c11442").param("obj_id", PbRecommendNovelHolder.this.l.z0).param("obj_locate", "1"));
                } else if (view != pbRecommendNovelHolder.f19756c || StringUtils.isNull(pbRecommendNovelHolder.l.y0)) {
                } else {
                    UrlManager.getInstance().dealOneLink((TbPageContext) j.a(PbRecommendNovelHolder.this.f19754a.getPageActivity()), new String[]{PbRecommendNovelHolder.this.l.y0});
                    TiebaStatic.log(new StatisticItem("c11442").param("obj_id", PbRecommendNovelHolder.this.l.z0).param("obj_locate", "2"));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(d1 d1Var);
    }

    public PbRecommendNovelHolder(TbPageContext tbPageContext, View view, b bVar) {
        super(view);
        this.n = new a();
        this.f19754a = tbPageContext;
        this.m = bVar;
        this.f19755b = (TextView) view.findViewById(R.id.textview_recommend_title);
        this.f19756c = (TextView) view.findViewById(R.id.textview_recommend_option_btn);
        this.f19757d = (TbImageView) view.findViewById(R.id.novel_cover);
        this.f19758e = (TextView) view.findViewById(R.id.novel_title);
        this.f19759f = (TextView) view.findViewById(R.id.novel_author);
        this.f19760g = (TextView) view.findViewById(R.id.novel_read_number);
        this.f19761h = (TextView) view.findViewById(R.id.novel_read_btn);
        this.j = (LinearLayout) view.findViewById(R.id.novel_recommend_item_layout);
        TbImageView tbImageView = (TbImageView) view.findViewById(R.id.novel_subscription);
        this.i = tbImageView;
        tbImageView.setDefaultResource(R.drawable.transparent_bg);
        this.i.setDefaultBgResource(R.drawable.transparent_bg);
        this.k = view.findViewById(R.id.recommend_devider);
        this.f19761h.setOnClickListener(this.n);
        this.j.setOnClickListener(this.n);
        this.f19756c.setOnClickListener(this.n);
    }

    public void e(d1 d1Var) {
        if (d1Var == null) {
            return;
        }
        this.l = d1Var;
        this.f19755b.setText(d1Var.w0);
        this.f19756c.setText(d1Var.x0);
        this.i.W(d1Var.E0, 10, false);
        this.f19757d.W(d1Var.A0, 10, false);
        this.f19761h.setText(d1Var.D0);
        this.f19758e.setText(d1Var.B0);
        List<String> list = d1Var.C0;
        if (list != null) {
            int size = list.size();
            if (size != 1) {
                if (size == 2) {
                    if (list.get(0) != null) {
                        this.f19759f.setText(list.get(0));
                    }
                    if (list.get(1) != null) {
                        this.f19760g.setText(list.get(1));
                    }
                }
            } else if (list.get(0) != null) {
                this.f19759f.setText(list.get(0));
            }
        }
        SkinManager.setViewTextColor(this.f19755b, R.color.CAM_X0109, 1);
        SkinManager.setViewTextColor(this.f19756c, R.color.CAM_X0302, 1);
        SkinManager.setViewTextColor(this.f19758e, R.color.CAM_X0105, 1);
        SkinManager.setViewTextColor(this.f19759f, R.color.CAM_X0109, 1);
        SkinManager.setViewTextColor(this.f19760g, R.color.CAM_X0109, 1);
        SkinManager.setViewTextColor(this.f19761h, R.color.CAM_X0302, 1);
        SkinManager.setBackgroundColor(this.k, R.color.CAM_X0204);
        SkinManager.setBackgroundResource(this.f19761h, R.drawable.btn_pb_novel_recommend_read);
        TiebaStatic.log(new StatisticItem("c11441").param("obj_id", this.l.z0));
    }
}
