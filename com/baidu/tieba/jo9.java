package com.baidu.tieba;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class jo9 extends lm9<xi9, b> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ko9 g;
    public xi9 h;
    public aj9 i;
    public View.OnClickListener j;

    /* loaded from: classes6.dex */
    public static class b extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;
        public TbImageView b;
        public TextView c;
        public ProgressBar d;
        public TextView e;
        public View f;
        public View.OnClickListener g;

        /* loaded from: classes6.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.g != null) {
                    this.a.g.onClick(view2);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(View view2) {
            super(view2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2};
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
            this.f = view2.findViewById(R.id.obfuscated_res_0x7f0903df);
            this.b = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f0910c9);
            this.a = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092809);
            this.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0904b8);
            this.d = (ProgressBar) view2.findViewById(R.id.obfuscated_res_0x7f091daf);
            this.e = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09280d);
            this.b.setRadius(BdUtilHelper.getDimens(getView().getContext(), R.dimen.tbds20));
            this.b.setConrers(5);
            this.b.setDefaultBgResource(R.color.cp_atp_a);
            this.b.setDrawCorner(true);
            this.c.setOnClickListener(new a(this));
            this.d.setMax(100);
        }

        public /* synthetic */ b(View view2, a aVar) {
            this(view2);
        }

        public void d(View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onClickListener) == null) {
                this.g = onClickListener;
            }
        }

        public final void c(Context context, yi9 yi9Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLL(1048576, this, context, yi9Var) != null) || yi9Var == null) {
                return;
            }
            this.e.setText(yi9Var.c);
            this.b.startLoad(yi9Var.b, 38, false);
            this.a.setText(context.getResources().getString(R.string.obfuscated_res_0x7f0f0fd4, yi9Var.d) + "%");
            int i = JavaTypesHelper.toInt(yi9Var.d, 0);
            if (i > 100) {
                i = 100;
            } else if (i < 0) {
                i = 0;
            }
            this.d.setProgress(i);
            if (yi9Var.a()) {
                this.c.setText(R.string.obfuscated_res_0x7f0f0fd2);
                SkinManager.setViewTextColor(this.c, (int) R.color.CAM_X0101);
                SkinManager.setBackgroundResource(this.c, R.drawable.btn_pb_ad_card_gift_get);
                this.c.setClickable(true);
            } else if (yi9Var.b()) {
                this.c.setText(R.string.obfuscated_res_0x7f0f0fd9);
                SkinManager.setViewTextColor(this.c, (int) R.color.CAM_X0101);
                SkinManager.setBackgroundResource(this.c, R.drawable.obfuscated_res_0x7f08043d);
                this.c.setClickable(true);
            } else {
                this.c.setText(R.string.obfuscated_res_0x7f0f0fd3);
                SkinManager.setViewTextColor(this.c, (int) R.color.CAM_X0109);
                this.c.setBackgroundResource(R.drawable.transparent_bg);
                this.c.setClickable(false);
            }
            onChangeSkinType();
        }

        public final void onChangeSkinType() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                SkinManager.setBackgroundResource(this.f, R.drawable.bg_pb_ad_card_gift);
                SkinManager.setViewTextColor(this.e, (int) R.color.CAM_X0105);
                SkinManager.setViewTextColor(this.a, (int) R.color.CAM_X0107);
                this.d.setProgressDrawable(SkinManager.getDrawable(R.drawable.bg_pb_ad_card_gift_progress));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jo9 a;

        public a(jo9 jo9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jo9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jo9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || this.a.h == null || this.a.h.a == null || xw5.a()) {
                return;
            }
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.checkUpIsLogin(this.a.b.getPageContext().getPageActivity());
                return;
            }
            jo9 jo9Var = this.a;
            jo9Var.B(jo9Var.h);
            if (this.a.h.a.b()) {
                UrlManager.getInstance().dealOneLink((TbPageContext<?>) this.a.b.getPageContext(), new String[]{TbConfig.URL_JUMP_TAG_CARDBOX}, true);
            } else if (this.a.h.a.a()) {
                this.a.g.u(this.a.h);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jo9(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pbFragment, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((rr9) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = new a(this);
        this.g = new ko9(pbFragment);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pm
    /* renamed from: D */
    public b onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            b bVar = new b(LayoutInflater.from(this.mContext).inflate(R.layout.obfuscated_res_0x7f0d079c, viewGroup, false), null);
            bVar.d(this.j);
            return bVar;
        }
        return (b) invokeL.objValue;
    }

    public void r(aj9 aj9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, aj9Var) == null) {
            this.i = aj9Var;
            ko9 ko9Var = this.g;
            if (ko9Var != null) {
                ko9Var.v(aj9Var);
            }
        }
    }

    public final void B(xi9 xi9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, xi9Var) == null) {
            vfa.g().c(this.b.getUniqueId(), sfa.c(this.i.O(), "a005", "common_click", 1, xi9Var.b, true, xi9Var.a.a + "", null, 18));
        }
    }

    public final void C(xi9 xi9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, xi9Var) == null) {
            String str = xi9Var.a.a + "";
            vfa.g().d(this.b.getUniqueId(), sfa.b(this.i.O().getTid(), str, "", null), sfa.d(this.i.O(), "a005", "common_exp", xi9Var.b, true, str, "", 18));
        }
    }

    public View E(int i, View view2, ViewGroup viewGroup, xi9 xi9Var, b bVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, xi9Var, bVar})) == null) {
            super.onFillViewHolder(i, view2, viewGroup, (ViewGroup) xi9Var, (xi9) bVar);
            if (xi9Var != null && bVar != null) {
                xi9Var.b = i + 1;
                this.h = xi9Var;
                C(xi9Var);
                bVar.c(this.mContext, xi9Var.a);
            }
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    public void onDestroy() {
        ko9 ko9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (ko9Var = this.g) != null) {
            ko9Var.q();
        }
    }

    @Override // com.baidu.tieba.lm9, com.baidu.tieba.pm
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i, View view2, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        E(i, view2, viewGroup, (xi9) obj, (b) viewHolder);
        return view2;
    }
}
