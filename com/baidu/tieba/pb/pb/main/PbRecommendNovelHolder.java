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
import d.a.j0.r.q.d1;
import d.a.j0.r.q.y0;
import java.util.List;
/* loaded from: classes5.dex */
public class PbRecommendNovelHolder extends TypeAdapter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f19204a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f19205b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f19206c;

    /* renamed from: d  reason: collision with root package name */
    public TbImageView f19207d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f19208e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f19209f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f19210g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f19211h;

    /* renamed from: i  reason: collision with root package name */
    public TbImageView f19212i;
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
            if (ViewHelper.checkUpIsLogin(PbRecommendNovelHolder.this.f19204a.getPageActivity()) && l.D() && PbRecommendNovelHolder.this.l != null && !StringUtils.isNull(PbRecommendNovelHolder.this.l.A0)) {
                if (!TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                    l.L(PbRecommendNovelHolder.this.f19204a.getPageActivity(), R.string.book_plugin_not_install_tip);
                    return;
                }
                if (PbRecommendNovelHolder.this.m != null) {
                    PbRecommendNovelHolder.this.m.a(PbRecommendNovelHolder.this.l);
                }
                PbRecommendNovelHolder pbRecommendNovelHolder = PbRecommendNovelHolder.this;
                if (view == pbRecommendNovelHolder.f19211h) {
                    String str = pbRecommendNovelHolder.l.A0;
                    y0 y0Var = new y0();
                    TbPageContext tbPageContext = (TbPageContext) j.a(PbRecommendNovelHolder.this.f19204a.getPageActivity());
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001417, y0Var));
                    TiebaStatic.log(new StatisticItem("c11387").param("obj_source", 6).param("obj_locate", "0").param("obj_param1", str));
                    TiebaStatic.log(new StatisticItem("c11442").param("obj_id", PbRecommendNovelHolder.this.l.A0).param("obj_locate", "3"));
                } else if (view == pbRecommendNovelHolder.j) {
                    PbRecommendNovelHolder.this.f19204a.sendMessage(new CustomMessage(2002001, new BookCoverActivityConfig(PbRecommendNovelHolder.this.f19204a.getPageActivity(), PbRecommendNovelHolder.this.l.A0)));
                    TiebaStatic.log(new StatisticItem("c11442").param("obj_id", PbRecommendNovelHolder.this.l.A0).param("obj_locate", "1"));
                } else if (view != pbRecommendNovelHolder.f19206c || StringUtils.isNull(pbRecommendNovelHolder.l.z0)) {
                } else {
                    UrlManager.getInstance().dealOneLink((TbPageContext) j.a(PbRecommendNovelHolder.this.f19204a.getPageActivity()), new String[]{PbRecommendNovelHolder.this.l.z0});
                    TiebaStatic.log(new StatisticItem("c11442").param("obj_id", PbRecommendNovelHolder.this.l.A0).param("obj_locate", "2"));
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
        this.f19204a = tbPageContext;
        this.m = bVar;
        this.f19205b = (TextView) view.findViewById(R.id.textview_recommend_title);
        this.f19206c = (TextView) view.findViewById(R.id.textview_recommend_option_btn);
        this.f19207d = (TbImageView) view.findViewById(R.id.novel_cover);
        this.f19208e = (TextView) view.findViewById(R.id.novel_title);
        this.f19209f = (TextView) view.findViewById(R.id.novel_author);
        this.f19210g = (TextView) view.findViewById(R.id.novel_read_number);
        this.f19211h = (TextView) view.findViewById(R.id.novel_read_btn);
        this.j = (LinearLayout) view.findViewById(R.id.novel_recommend_item_layout);
        TbImageView tbImageView = (TbImageView) view.findViewById(R.id.novel_subscription);
        this.f19212i = tbImageView;
        tbImageView.setDefaultResource(R.drawable.transparent_bg);
        this.f19212i.setDefaultBgResource(R.drawable.transparent_bg);
        this.k = view.findViewById(R.id.recommend_devider);
        this.f19211h.setOnClickListener(this.n);
        this.j.setOnClickListener(this.n);
        this.f19206c.setOnClickListener(this.n);
    }

    public void e(d1 d1Var) {
        if (d1Var == null) {
            return;
        }
        this.l = d1Var;
        this.f19205b.setText(d1Var.x0);
        this.f19206c.setText(d1Var.y0);
        this.f19212i.V(d1Var.K0, 10, false);
        this.f19207d.V(d1Var.B0, 10, false);
        this.f19211h.setText(d1Var.E0);
        this.f19208e.setText(d1Var.C0);
        List<String> list = d1Var.D0;
        if (list != null) {
            int size = list.size();
            if (size != 1) {
                if (size == 2) {
                    if (list.get(0) != null) {
                        this.f19209f.setText(list.get(0));
                    }
                    if (list.get(1) != null) {
                        this.f19210g.setText(list.get(1));
                    }
                }
            } else if (list.get(0) != null) {
                this.f19209f.setText(list.get(0));
            }
        }
        SkinManager.setViewTextColor(this.f19205b, R.color.CAM_X0109, 1);
        SkinManager.setViewTextColor(this.f19206c, R.color.CAM_X0302, 1);
        SkinManager.setViewTextColor(this.f19208e, R.color.CAM_X0105, 1);
        SkinManager.setViewTextColor(this.f19209f, R.color.CAM_X0109, 1);
        SkinManager.setViewTextColor(this.f19210g, R.color.CAM_X0109, 1);
        SkinManager.setViewTextColor(this.f19211h, R.color.CAM_X0302, 1);
        SkinManager.setBackgroundColor(this.k, R.color.CAM_X0204);
        SkinManager.setBackgroundResource(this.f19211h, R.drawable.btn_pb_novel_recommend_read);
        TiebaStatic.log(new StatisticItem("c11441").param("obj_id", this.l.A0));
    }
}
