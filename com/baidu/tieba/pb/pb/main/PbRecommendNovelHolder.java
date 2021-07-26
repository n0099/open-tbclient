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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.a.j;
import d.a.d.e.p.l;
import d.a.p0.s.q.e1;
import d.a.p0.s.q.z0;
import java.util.List;
/* loaded from: classes4.dex */
public class PbRecommendNovelHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f19536a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f19537b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f19538c;

    /* renamed from: d  reason: collision with root package name */
    public TbImageView f19539d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f19540e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f19541f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f19542g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f19543h;

    /* renamed from: i  reason: collision with root package name */
    public TbImageView f19544i;
    public LinearLayout j;
    public View k;
    public e1 l;
    public b m;
    public View.OnClickListener n;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbRecommendNovelHolder f19545e;

        public a(PbRecommendNovelHolder pbRecommendNovelHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbRecommendNovelHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19545e = pbRecommendNovelHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && ViewHelper.checkUpIsLogin(this.f19545e.f19536a.getPageActivity()) && l.D() && this.f19545e.l != null && !StringUtils.isNull(this.f19545e.l.F0)) {
                if (!TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                    l.L(this.f19545e.f19536a.getPageActivity(), R.string.book_plugin_not_install_tip);
                    return;
                }
                if (this.f19545e.m != null) {
                    this.f19545e.m.a(this.f19545e.l);
                }
                PbRecommendNovelHolder pbRecommendNovelHolder = this.f19545e;
                if (view == pbRecommendNovelHolder.f19543h) {
                    String str = pbRecommendNovelHolder.l.F0;
                    z0 z0Var = new z0();
                    TbPageContext tbPageContext = (TbPageContext) j.a(this.f19545e.f19536a.getPageActivity());
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001417, z0Var));
                    TiebaStatic.log(new StatisticItem("c11387").param("obj_source", 6).param("obj_locate", "0").param("obj_param1", str));
                    TiebaStatic.log(new StatisticItem("c11442").param("obj_id", this.f19545e.l.F0).param("obj_locate", "3"));
                } else if (view == pbRecommendNovelHolder.j) {
                    this.f19545e.f19536a.sendMessage(new CustomMessage(2002001, new BookCoverActivityConfig(this.f19545e.f19536a.getPageActivity(), this.f19545e.l.F0)));
                    TiebaStatic.log(new StatisticItem("c11442").param("obj_id", this.f19545e.l.F0).param("obj_locate", "1"));
                } else if (view != pbRecommendNovelHolder.f19538c || StringUtils.isNull(pbRecommendNovelHolder.l.E0)) {
                } else {
                    UrlManager.getInstance().dealOneLink((TbPageContext) j.a(this.f19545e.f19536a.getPageActivity()), new String[]{this.f19545e.l.E0});
                    TiebaStatic.log(new StatisticItem("c11442").param("obj_id", this.f19545e.l.F0).param("obj_locate", "2"));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(e1 e1Var);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbRecommendNovelHolder(TbPageContext tbPageContext, View view, b bVar) {
        super(view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view, bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((View) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = new a(this);
        this.f19536a = tbPageContext;
        this.m = bVar;
        this.f19537b = (TextView) view.findViewById(R.id.textview_recommend_title);
        this.f19538c = (TextView) view.findViewById(R.id.textview_recommend_option_btn);
        this.f19539d = (TbImageView) view.findViewById(R.id.novel_cover);
        this.f19540e = (TextView) view.findViewById(R.id.novel_title);
        this.f19541f = (TextView) view.findViewById(R.id.novel_author);
        this.f19542g = (TextView) view.findViewById(R.id.novel_read_number);
        this.f19543h = (TextView) view.findViewById(R.id.novel_read_btn);
        this.j = (LinearLayout) view.findViewById(R.id.novel_recommend_item_layout);
        TbImageView tbImageView = (TbImageView) view.findViewById(R.id.novel_subscription);
        this.f19544i = tbImageView;
        tbImageView.setDefaultResource(R.drawable.transparent_bg);
        this.f19544i.setDefaultBgResource(R.drawable.transparent_bg);
        this.k = view.findViewById(R.id.recommend_devider);
        this.f19543h.setOnClickListener(this.n);
        this.j.setOnClickListener(this.n);
        this.f19538c.setOnClickListener(this.n);
    }

    public void e(e1 e1Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, e1Var) == null) || e1Var == null) {
            return;
        }
        this.l = e1Var;
        this.f19537b.setText(e1Var.C0);
        this.f19538c.setText(e1Var.D0);
        this.f19544i.M(e1Var.K0, 10, false);
        this.f19539d.M(e1Var.G0, 10, false);
        this.f19543h.setText(e1Var.J0);
        this.f19540e.setText(e1Var.H0);
        List<String> list = e1Var.I0;
        if (list != null) {
            int size = list.size();
            if (size != 1) {
                if (size == 2) {
                    if (list.get(0) != null) {
                        this.f19541f.setText(list.get(0));
                    }
                    if (list.get(1) != null) {
                        this.f19542g.setText(list.get(1));
                    }
                }
            } else if (list.get(0) != null) {
                this.f19541f.setText(list.get(0));
            }
        }
        SkinManager.setViewTextColor(this.f19537b, R.color.CAM_X0109, 1);
        SkinManager.setViewTextColor(this.f19538c, R.color.CAM_X0302, 1);
        SkinManager.setViewTextColor(this.f19540e, R.color.CAM_X0105, 1);
        SkinManager.setViewTextColor(this.f19541f, R.color.CAM_X0109, 1);
        SkinManager.setViewTextColor(this.f19542g, R.color.CAM_X0109, 1);
        SkinManager.setViewTextColor(this.f19543h, R.color.CAM_X0302, 1);
        SkinManager.setBackgroundColor(this.k, R.color.CAM_X0204);
        SkinManager.setBackgroundResource(this.f19543h, R.drawable.btn_pb_novel_recommend_read);
        TiebaStatic.log(new StatisticItem("c11441").param("obj_id", this.l.F0));
    }
}
