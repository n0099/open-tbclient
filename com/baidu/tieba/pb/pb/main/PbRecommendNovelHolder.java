package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdUtilHelper;
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
import com.baidu.tieba.d35;
import com.baidu.tieba.i35;
import com.baidu.tieba.m9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes7.dex */
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
    public i35 l;
    public b m;
    public View.OnClickListener n;

    /* loaded from: classes7.dex */
    public interface b {
        void a(i35 i35Var);
    }

    /* loaded from: classes7.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && ViewHelper.checkUpIsLogin(this.a.a.getPageActivity()) && BdUtilHelper.isNetOk() && this.a.l != null && !StringUtils.isNull(this.a.l.j1)) {
                if (!TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                    BdUtilHelper.showToast(this.a.a.getPageActivity(), (int) R.string.book_plugin_not_install_tip);
                    return;
                }
                if (this.a.m != null) {
                    this.a.m.a(this.a.l);
                }
                PbRecommendNovelHolder pbRecommendNovelHolder = this.a;
                if (view2 == pbRecommendNovelHolder.h) {
                    String str = pbRecommendNovelHolder.l.j1;
                    d35 d35Var = new d35();
                    TbPageContext tbPageContext = (TbPageContext) m9.a(this.a.a.getPageActivity());
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001417, d35Var));
                    TiebaStatic.log(new StatisticItem("c11387").param("obj_source", 6).param("obj_locate", "0").param("obj_param1", str));
                    TiebaStatic.log(new StatisticItem("c11442").param("obj_id", this.a.l.j1).param("obj_locate", "3"));
                } else if (view2 == pbRecommendNovelHolder.j) {
                    this.a.a.sendMessage(new CustomMessage(2002001, new BookCoverActivityConfig(this.a.a.getPageActivity(), this.a.l.j1)));
                    TiebaStatic.log(new StatisticItem("c11442").param("obj_id", this.a.l.j1).param("obj_locate", "1"));
                } else if (view2 != pbRecommendNovelHolder.c || StringUtils.isNull(pbRecommendNovelHolder.l.i1)) {
                } else {
                    UrlManager.getInstance().dealOneLink((TbPageContext) m9.a(this.a.a.getPageActivity()), new String[]{this.a.l.i1});
                    TiebaStatic.log(new StatisticItem("c11442").param("obj_id", this.a.l.j1).param("obj_locate", "2"));
                }
            }
        }
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
        this.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092522);
        this.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092521);
        this.d = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f0919dc);
        this.e = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0919ec);
        this.f = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0919d8);
        this.g = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0919e6);
        this.h = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0919e4);
        this.j = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f0919e7);
        TbImageView tbImageView = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f0919eb);
        this.i = tbImageView;
        tbImageView.setDefaultResource(R.drawable.transparent_bg);
        this.i.setDefaultBgResource(R.drawable.transparent_bg);
        this.k = view2.findViewById(R.id.obfuscated_res_0x7f091eaa);
        this.h.setOnClickListener(this.n);
        this.j.setOnClickListener(this.n);
        this.c.setOnClickListener(this.n);
    }

    public void d(i35 i35Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, i35Var) != null) || i35Var == null) {
            return;
        }
        this.l = i35Var;
        this.b.setText(i35Var.g1);
        this.c.setText(i35Var.h1);
        this.i.startLoad(i35Var.o1, 10, false);
        this.d.startLoad(i35Var.k1, 10, false);
        this.h.setText(i35Var.n1);
        this.e.setText(i35Var.l1);
        List<String> list = i35Var.m1;
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
        TiebaStatic.log(new StatisticItem("c11441").param("obj_id", this.l.j1));
    }
}
