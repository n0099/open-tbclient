package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.d.a.j;
import c.a.d.f.p.n;
import c.a.o0.r.r.d1;
import c.a.o0.r.r.y0;
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
import java.util.List;
/* loaded from: classes5.dex */
public class PbRecommendNovelHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f34987b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f34988c;

    /* renamed from: d  reason: collision with root package name */
    public TbImageView f34989d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f34990e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f34991f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f34992g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f34993h;
    public TbImageView i;
    public LinearLayout j;
    public View k;
    public d1 l;
    public b m;
    public View.OnClickListener n;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbRecommendNovelHolder a;

        public a(PbRecommendNovelHolder pbRecommendNovelHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbRecommendNovelHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbRecommendNovelHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && ViewHelper.checkUpIsLogin(this.a.a.getPageActivity()) && n.C() && this.a.l != null && !StringUtils.isNull(this.a.l.H0)) {
                if (!TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                    n.M(this.a.a.getPageActivity(), R.string.obfuscated_res_0x7f0f0317);
                    return;
                }
                if (this.a.m != null) {
                    this.a.m.a(this.a.l);
                }
                PbRecommendNovelHolder pbRecommendNovelHolder = this.a;
                if (view == pbRecommendNovelHolder.f34993h) {
                    String str = pbRecommendNovelHolder.l.H0;
                    y0 y0Var = new y0();
                    TbPageContext tbPageContext = (TbPageContext) j.a(this.a.a.getPageActivity());
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001417, y0Var));
                    TiebaStatic.log(new StatisticItem("c11387").param("obj_source", 6).param("obj_locate", "0").param("obj_param1", str));
                    TiebaStatic.log(new StatisticItem("c11442").param("obj_id", this.a.l.H0).param("obj_locate", "3"));
                } else if (view == pbRecommendNovelHolder.j) {
                    this.a.a.sendMessage(new CustomMessage(2002001, new BookCoverActivityConfig(this.a.a.getPageActivity(), this.a.l.H0)));
                    TiebaStatic.log(new StatisticItem("c11442").param("obj_id", this.a.l.H0).param("obj_locate", "1"));
                } else if (view != pbRecommendNovelHolder.f34988c || StringUtils.isNull(pbRecommendNovelHolder.l.G0)) {
                } else {
                    UrlManager.getInstance().dealOneLink((TbPageContext) j.a(this.a.a.getPageActivity()), new String[]{this.a.l.G0});
                    TiebaStatic.log(new StatisticItem("c11442").param("obj_id", this.a.l.H0).param("obj_locate", "2"));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a(d1 d1Var);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((View) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = new a(this);
        this.a = tbPageContext;
        this.m = bVar;
        this.f34987b = (TextView) view.findViewById(R.id.obfuscated_res_0x7f091f70);
        this.f34988c = (TextView) view.findViewById(R.id.obfuscated_res_0x7f091f6f);
        this.f34989d = (TbImageView) view.findViewById(R.id.obfuscated_res_0x7f0915ca);
        this.f34990e = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0915dc);
        this.f34991f = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0915c6);
        this.f34992g = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0915d8);
        this.f34993h = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0915d7);
        this.j = (LinearLayout) view.findViewById(R.id.obfuscated_res_0x7f0915d9);
        TbImageView tbImageView = (TbImageView) view.findViewById(R.id.obfuscated_res_0x7f0915db);
        this.i = tbImageView;
        tbImageView.setDefaultResource(R.drawable.obfuscated_res_0x7f081200);
        this.i.setDefaultBgResource(R.drawable.obfuscated_res_0x7f081200);
        this.k = view.findViewById(R.id.obfuscated_res_0x7f0919ff);
        this.f34993h.setOnClickListener(this.n);
        this.j.setOnClickListener(this.n);
        this.f34988c.setOnClickListener(this.n);
    }

    public void f(d1 d1Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, d1Var) == null) || d1Var == null) {
            return;
        }
        this.l = d1Var;
        this.f34987b.setText(d1Var.E0);
        this.f34988c.setText(d1Var.F0);
        this.i.J(d1Var.M0, 10, false);
        this.f34989d.J(d1Var.I0, 10, false);
        this.f34993h.setText(d1Var.L0);
        this.f34990e.setText(d1Var.J0);
        List<String> list = d1Var.K0;
        if (list != null) {
            int size = list.size();
            if (size != 1) {
                if (size == 2) {
                    if (list.get(0) != null) {
                        this.f34991f.setText(list.get(0));
                    }
                    if (list.get(1) != null) {
                        this.f34992g.setText(list.get(1));
                    }
                }
            } else if (list.get(0) != null) {
                this.f34991f.setText(list.get(0));
            }
        }
        SkinManager.setViewTextColor(this.f34987b, R.color.CAM_X0109, 1);
        SkinManager.setViewTextColor(this.f34988c, R.color.CAM_X0302, 1);
        SkinManager.setViewTextColor(this.f34990e, R.color.CAM_X0105, 1);
        SkinManager.setViewTextColor(this.f34991f, R.color.CAM_X0109, 1);
        SkinManager.setViewTextColor(this.f34992g, R.color.CAM_X0109, 1);
        SkinManager.setViewTextColor(this.f34993h, R.color.CAM_X0302, 1);
        SkinManager.setBackgroundColor(this.k, R.color.CAM_X0204);
        SkinManager.setBackgroundResource(this.f34993h, R.drawable.btn_pb_novel_recommend_read);
        TiebaStatic.log(new StatisticItem("c11441").param("obj_id", this.l.H0));
    }
}
