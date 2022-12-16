package com.baidu.tieba;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
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
public class t48 extends y28<c08, b> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public u48 g;
    public c08 h;
    public h08 i;
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
            this.f = view2.findViewById(R.id.obfuscated_res_0x7f090390);
            this.b = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f090f50);
            this.a = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0924f4);
            this.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09043c);
            this.d = (ProgressBar) view2.findViewById(R.id.obfuscated_res_0x7f091b74);
            this.e = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0924f8);
            this.b.setRadius(yi.g(getView().getContext(), R.dimen.tbds20));
            this.b.setConrers(5);
            this.b.setDefaultBgResource(R.color.cp_atp_a);
            this.b.setDrawCorner(true);
            this.c.setOnClickListener(new a(this));
            this.d.setMax(100);
        }

        public /* synthetic */ b(View view2, a aVar) {
            this(view2);
        }

        public void e(View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onClickListener) == null) {
                this.g = onClickListener;
            }
        }

        public final void c(Context context, d08 d08Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLL(1048576, this, context, d08Var) != null) || d08Var == null) {
                return;
            }
            this.e.setText(d08Var.c);
            this.b.K(d08Var.b, 38, false);
            this.a.setText(context.getResources().getString(R.string.obfuscated_res_0x7f0f0e33, d08Var.d) + "%");
            int e = xg.e(d08Var.d, 0);
            if (e > 100) {
                e = 100;
            } else if (e < 0) {
                e = 0;
            }
            this.d.setProgress(e);
            if (d08Var.a()) {
                this.c.setText(R.string.obfuscated_res_0x7f0f0e31);
                SkinManager.setViewTextColor(this.c, (int) R.color.CAM_X0101);
                SkinManager.setBackgroundResource(this.c, R.drawable.btn_pb_ad_card_gift_get);
                this.c.setClickable(true);
            } else if (d08Var.b()) {
                this.c.setText(R.string.obfuscated_res_0x7f0f0e38);
                SkinManager.setViewTextColor(this.c, (int) R.color.CAM_X0101);
                SkinManager.setBackgroundResource(this.c, R.drawable.obfuscated_res_0x7f0803ca);
                this.c.setClickable(true);
            } else {
                this.c.setText(R.string.obfuscated_res_0x7f0f0e32);
                SkinManager.setViewTextColor(this.c, (int) R.color.CAM_X0109);
                this.c.setBackgroundResource(R.drawable.transparent_bg);
                this.c.setClickable(false);
            }
            d();
        }

        public final void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
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
        public final /* synthetic */ t48 a;

        public a(t48 t48Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t48Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t48Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || this.a.h == null || this.a.h.a == null || hj5.a()) {
                return;
            }
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.checkUpIsLogin(this.a.b.getPageContext().getPageActivity());
                return;
            }
            t48 t48Var = this.a;
            t48Var.z(t48Var.h);
            if (this.a.h.a.b()) {
                UrlManager.getInstance().dealOneLink((TbPageContext<?>) this.a.b.getPageContext(), new String[]{TbConfig.URL_JUMP_TAG_CARDBOX}, true);
            } else if (this.a.h.a.a()) {
                this.a.g.u(this.a.h);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t48(PbFragment pbFragment, BdUniqueId bdUniqueId) {
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
                super((s78) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = new a(this);
        this.g = new u48(pbFragment);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kn
    /* renamed from: B */
    public b onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup)) == null) {
            b bVar = new b(LayoutInflater.from(this.mContext).inflate(R.layout.obfuscated_res_0x7f0d06e2, viewGroup, false), null);
            bVar.e(this.j);
            return bVar;
        }
        return (b) invokeL.objValue;
    }

    public void r(h08 h08Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, h08Var) == null) {
            this.i = h08Var;
            u48 u48Var = this.g;
            if (u48Var != null) {
                u48Var.v(h08Var);
            }
        }
    }

    public final void A(c08 c08Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, c08Var) == null) {
            String str = c08Var.a.a + "";
            nq8.g().d(this.b.getUniqueId(), lq8.b(this.i.Q().getTid(), str, "", null), lq8.d(this.i.Q(), "a005", "common_exp", c08Var.b, true, str, "", 18));
        }
    }

    public final void z(c08 c08Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, c08Var) == null) {
            nq8.g().c(this.b.getUniqueId(), lq8.c(this.i.Q(), "a005", "common_click", 1, c08Var.b, true, c08Var.a.a + "", null, 18));
        }
    }

    public View C(int i, View view2, ViewGroup viewGroup, c08 c08Var, b bVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), view2, viewGroup, c08Var, bVar})) == null) {
            super.onFillViewHolder(i, view2, viewGroup, (ViewGroup) c08Var, (c08) bVar);
            if (c08Var != null && bVar != null) {
                c08Var.b = i + 1;
                this.h = c08Var;
                A(c08Var);
                bVar.c(this.mContext, c08Var.a);
            }
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    public void onDestroy() {
        u48 u48Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (u48Var = this.g) != null) {
            u48Var.q();
        }
    }

    @Override // com.baidu.tieba.y28, com.baidu.tieba.kn
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i, View view2, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        C(i, view2, viewGroup, (c08) obj, (b) viewHolder);
        return view2;
    }
}
