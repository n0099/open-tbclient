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
import com.repackage.f9;
import com.repackage.oi;
import com.repackage.op4;
import com.repackage.tp4;
import java.util.List;
/* loaded from: classes3.dex */
public class PbRecommendNovelHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public TextView b;
    public TextView c;
    public TbImageView d;
    public TextView e;
    public TextView f;
    public TextView g;
    public TextView h;
    public TbImageView i;
    public LinearLayout j;
    public View k;
    public tp4 l;
    public b m;
    public View.OnClickListener n;

    /* loaded from: classes3.dex */
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
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && ViewHelper.checkUpIsLogin(this.a.a.getPageActivity()) && oi.C() && this.a.l != null && !StringUtils.isNull(this.a.l.I0)) {
                if (!TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                    oi.M(this.a.a.getPageActivity(), R.string.obfuscated_res_0x7f0f0319);
                    return;
                }
                if (this.a.m != null) {
                    this.a.m.a(this.a.l);
                }
                PbRecommendNovelHolder pbRecommendNovelHolder = this.a;
                if (view2 == pbRecommendNovelHolder.h) {
                    String str = pbRecommendNovelHolder.l.I0;
                    op4 op4Var = new op4();
                    TbPageContext tbPageContext = (TbPageContext) f9.a(this.a.a.getPageActivity());
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001417, op4Var));
                    TiebaStatic.log(new StatisticItem("c11387").param("obj_source", 6).param("obj_locate", "0").param("obj_param1", str));
                    TiebaStatic.log(new StatisticItem("c11442").param("obj_id", this.a.l.I0).param("obj_locate", "3"));
                } else if (view2 == pbRecommendNovelHolder.j) {
                    this.a.a.sendMessage(new CustomMessage(2002001, new BookCoverActivityConfig(this.a.a.getPageActivity(), this.a.l.I0)));
                    TiebaStatic.log(new StatisticItem("c11442").param("obj_id", this.a.l.I0).param("obj_locate", "1"));
                } else if (view2 != pbRecommendNovelHolder.c || StringUtils.isNull(pbRecommendNovelHolder.l.H0)) {
                } else {
                    UrlManager.getInstance().dealOneLink((TbPageContext) f9.a(this.a.a.getPageActivity()), new String[]{this.a.l.H0});
                    TiebaStatic.log(new StatisticItem("c11442").param("obj_id", this.a.l.I0).param("obj_locate", "2"));
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(tp4 tp4Var);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbRecommendNovelHolder(TbPageContext tbPageContext, View view2, b bVar) {
        super(view2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view2, bVar};
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
        this.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091f5d);
        this.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091f5c);
        this.d = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f0915c6);
        this.e = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0915d8);
        this.f = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0915c2);
        this.g = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0915d4);
        this.h = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0915d3);
        this.j = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f0915d5);
        TbImageView tbImageView = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f0915d7);
        this.i = tbImageView;
        tbImageView.setDefaultResource(R.drawable.obfuscated_res_0x7f08120b);
        this.i.setDefaultBgResource(R.drawable.obfuscated_res_0x7f08120b);
        this.k = view2.findViewById(R.id.obfuscated_res_0x7f0919f0);
        this.h.setOnClickListener(this.n);
        this.j.setOnClickListener(this.n);
        this.c.setOnClickListener(this.n);
    }

    public void f(tp4 tp4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, tp4Var) == null) || tp4Var == null) {
            return;
        }
        this.l = tp4Var;
        this.b.setText(tp4Var.F0);
        this.c.setText(tp4Var.G0);
        this.i.K(tp4Var.N0, 10, false);
        this.d.K(tp4Var.J0, 10, false);
        this.h.setText(tp4Var.M0);
        this.e.setText(tp4Var.K0);
        List<String> list = tp4Var.L0;
        if (list != null) {
            int size = list.size();
            if (size != 1) {
                if (size == 2) {
                    if (list.get(0) != null) {
                        this.f.setText(list.get(0));
                    }
                    if (list.get(1) != null) {
                        this.g.setText(list.get(1));
                    }
                }
            } else if (list.get(0) != null) {
                this.f.setText(list.get(0));
            }
        }
        SkinManager.setViewTextColor(this.b, R.color.CAM_X0109, 1);
        SkinManager.setViewTextColor(this.c, R.color.CAM_X0302, 1);
        SkinManager.setViewTextColor(this.e, R.color.CAM_X0105, 1);
        SkinManager.setViewTextColor(this.f, R.color.CAM_X0109, 1);
        SkinManager.setViewTextColor(this.g, R.color.CAM_X0109, 1);
        SkinManager.setViewTextColor(this.h, R.color.CAM_X0302, 1);
        SkinManager.setBackgroundColor(this.k, R.color.CAM_X0204);
        SkinManager.setBackgroundResource(this.h, R.drawable.btn_pb_novel_recommend_read);
        TiebaStatic.log(new StatisticItem("c11441").param("obj_id", this.l.I0));
    }
}
