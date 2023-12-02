package com.baidu.tieba;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class ya6 extends nl6<d86> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int i;
    public TbPageContext<?> j;
    public c k;
    public cb6 l;
    public ThreadData m;
    public int n;
    public String o;
    public boolean p;
    public View.OnClickListener q;
    public View.OnClickListener r;

    @Override // com.baidu.tieba.nl6
    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? R.layout.obfuscated_res_0x7f0d011b : invokeV.intValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view2) == null) {
        }
    }

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ya6 a;

        public a(ya6 ya6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ya6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ya6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    BdUtilHelper.showLongToast(this.a.j.getPageActivity(), this.a.j.getPageActivity().getString(R.string.no_network_guide));
                } else if (this.a.m != null && this.a.m.getThreadAlaInfo() != null && this.a.l != null) {
                    this.a.l.a(this.a.n, this.a.o, this.a.m);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ya6 a;

        public b(ya6 ya6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ya6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ya6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.m != null && this.a.m.getAuthor() != null && !StringUtils.isNull(this.a.m.getAuthor().getUserId())) {
                long j = JavaTypesHelper.toLong(this.a.m.getAuthor().getUserId(), 0L);
                if (j == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                    z = true;
                } else {
                    z = false;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.a.j.getPageActivity()).createNormalConfig(j, z, this.a.m.getAuthor().isBigV())));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;
        public TbImageView b;
        public TextView c;
        public TextView d;
        public RelativeLayout e;
        public ClickableHeaderImageView f;
        public TextView g;
        public TextView h;
        public TextView i;

        public c(ya6 ya6Var, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ya6Var, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = view2;
            this.b = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f091136);
            this.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0927be);
            this.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0927bd);
            this.e = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f09202e);
            this.f = (ClickableHeaderImageView) view2.findViewById(R.id.obfuscated_res_0x7f091137);
            this.g = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0927ca);
            this.h = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0927c6);
            this.i = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0927c3);
            view2.setOnClickListener(ya6Var.q);
            this.b.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.b.setDrawerType(0);
            this.f.setIsRound(true);
            this.f.setDrawBorder(true);
            this.f.setBorderColor(ya6Var.j.getPageActivity().getResources().getColor(R.color.white_alpha100));
            this.f.setBorderWidth(ya6Var.j.getPageActivity().getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f070198));
            this.f.setIsGod(false);
            this.f.setIsBigV(false);
            this.f.setShowV(false);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.e.getLayoutParams();
            int equipmentWidth = (BdUtilHelper.getEquipmentWidth(view2.getContext()) - view2.getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070224)) / 2;
            layoutParams.width = equipmentWidth;
            layoutParams.height = (equipmentWidth * 9) / 16;
            this.e.setLayoutParams(layoutParams);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ya6(TbPageContext<?> tbPageContext, boolean z) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = 3;
        this.p = false;
        this.q = new a(this);
        this.r = new b(this);
        this.j = tbPageContext;
        this.k = new c(this, i());
        this.p = z;
    }

    public void C(cb6 cb6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cb6Var) == null) {
            this.l = cb6Var;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.nl6
    /* renamed from: B */
    public void j(d86 d86Var) {
        ThreadData threadData;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, d86Var) == null) {
            if (d86Var != null && (threadData = d86Var.d) != null && threadData.getThreadAlaInfo() != null) {
                i().setVisibility(0);
                this.m = d86Var.d;
                this.n = d86Var.a;
                if (!TextUtils.isEmpty(d86Var.c)) {
                    str = d86Var.c;
                } else {
                    str = d86Var.b;
                }
                this.o = str;
                this.k.b.startLoad(this.m.getThreadAlaInfo().cover, 10, false);
                this.k.d.setText(this.j.getPageActivity().getResources().getString(R.string.obfuscated_res_0x7f0f14a0, StringHelper.numberUniformFormatExtra(this.m.getThreadAlaInfo().audience_count)));
                this.k.f.setData(this.m, false);
                this.k.h.setText(this.m.getTitle());
                if (this.m.getAuthor() != null) {
                    String name_show = this.m.getAuthor().getName_show();
                    if (uu5.e(name_show) > 10) {
                        name_show = uu5.m(name_show, 10) + "...";
                    }
                    this.k.g.setText(name_show);
                }
                String str2 = this.m.getThreadAlaInfo().label_name;
                if (this.p && !StringUtils.isNull(str2)) {
                    this.k.c.setText(str2);
                    this.k.c.setVisibility(0);
                } else {
                    this.k.c.setVisibility(8);
                }
                if (d86Var.e) {
                    this.k.i.setText(this.j.getPageActivity().getResources().getString(R.string.obfuscated_res_0x7f0f149f, StringHelper.numberUniformFormatExtra((long) (this.m.getThreadAlaInfo().distance / 1000.0d))));
                    this.k.i.setVisibility(0);
                } else {
                    this.k.i.setVisibility(8);
                }
                this.k.g.setOnClickListener(this.r);
                k(this.j, TbadkCoreApplication.getInst().getSkinType());
                return;
            }
            i().setVisibility(4);
        }
    }

    @Override // com.baidu.tieba.nl6
    public void k(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048580, this, tbPageContext, i) == null) && this.i != i) {
            SkinManager.setBackgroundResource(this.k.e, R.drawable.addresslist_item_bg);
            SkinManager.setViewTextColor(this.k.d, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.k.g, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.k.h, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.k.i, (int) R.color.CAM_X0109);
            this.i = i;
        }
    }
}
