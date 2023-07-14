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
/* loaded from: classes8.dex */
public class uj9 extends wh9<we9, b> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public vj9 g;
    public we9 h;
    public ze9 i;
    public View.OnClickListener j;

    /* loaded from: classes8.dex */
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

        /* loaded from: classes8.dex */
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
            this.f = view2.findViewById(R.id.obfuscated_res_0x7f0903d4);
            this.b = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f0910a4);
            this.a = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092785);
            this.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09049f);
            this.d = (ProgressBar) view2.findViewById(R.id.obfuscated_res_0x7f091d4a);
            this.e = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092789);
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

        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SkinManager.setBackgroundResource(this.f, R.drawable.bg_pb_ad_card_gift);
                SkinManager.setViewTextColor(this.e, (int) R.color.CAM_X0105);
                SkinManager.setViewTextColor(this.a, (int) R.color.CAM_X0107);
                this.d.setProgressDrawable(SkinManager.getDrawable(R.drawable.bg_pb_ad_card_gift_progress));
            }
        }

        public final void d(Context context, xe9 xe9Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, xe9Var) != null) || xe9Var == null) {
                return;
            }
            this.e.setText(xe9Var.c);
            this.b.N(xe9Var.b, 38, false);
            this.a.setText(context.getResources().getString(R.string.obfuscated_res_0x7f0f0fb1, xe9Var.d) + "%");
            int e = wg.e(xe9Var.d, 0);
            if (e > 100) {
                e = 100;
            } else if (e < 0) {
                e = 0;
            }
            this.d.setProgress(e);
            if (xe9Var.a()) {
                this.c.setText(R.string.obfuscated_res_0x7f0f0faf);
                SkinManager.setViewTextColor(this.c, (int) R.color.CAM_X0101);
                SkinManager.setBackgroundResource(this.c, R.drawable.btn_pb_ad_card_gift_get);
                this.c.setClickable(true);
            } else if (xe9Var.b()) {
                this.c.setText(R.string.obfuscated_res_0x7f0f0fb6);
                SkinManager.setViewTextColor(this.c, (int) R.color.CAM_X0101);
                SkinManager.setBackgroundResource(this.c, R.drawable.obfuscated_res_0x7f080435);
                this.c.setClickable(true);
            } else {
                this.c.setText(R.string.obfuscated_res_0x7f0f0fb0);
                SkinManager.setViewTextColor(this.c, (int) R.color.CAM_X0109);
                this.c.setBackgroundResource(R.drawable.transparent_bg);
                this.c.setClickable(false);
            }
            a();
        }
    }

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uj9 a;

        public a(uj9 uj9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uj9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = uj9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || this.a.h == null || this.a.h.a == null || vx5.a()) {
                return;
            }
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.checkUpIsLogin(this.a.b.getPageContext().getPageActivity());
                return;
            }
            uj9 uj9Var = this.a;
            uj9Var.B(uj9Var.h);
            if (this.a.h.a.b()) {
                UrlManager.getInstance().dealOneLink((TbPageContext<?>) this.a.b.getPageContext(), new String[]{TbConfig.URL_JUMP_TAG_CARDBOX}, true);
            } else if (this.a.h.a.a()) {
                this.a.g.u(this.a.h);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public uj9(PbFragment pbFragment, BdUniqueId bdUniqueId) {
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
                super((bn9) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = new a(this);
        this.g = new vj9(pbFragment);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ln
    /* renamed from: D */
    public b onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            b bVar = new b(LayoutInflater.from(this.mContext).inflate(R.layout.obfuscated_res_0x7f0d077c, viewGroup, false), null);
            bVar.e(this.j);
            return bVar;
        }
        return (b) invokeL.objValue;
    }

    public void r(ze9 ze9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, ze9Var) == null) {
            this.i = ze9Var;
            vj9 vj9Var = this.g;
            if (vj9Var != null) {
                vj9Var.v(ze9Var);
            }
        }
    }

    public final void B(we9 we9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, we9Var) == null) {
            aba.g().c(this.b.getUniqueId(), yaa.c(this.i.N(), "a005", "common_click", 1, we9Var.b, true, we9Var.a.a + "", null, 18));
        }
    }

    public final void C(we9 we9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, we9Var) == null) {
            String str = we9Var.a.a + "";
            aba.g().d(this.b.getUniqueId(), yaa.b(this.i.N().getTid(), str, "", null), yaa.d(this.i.N(), "a005", "common_exp", we9Var.b, true, str, "", 18));
        }
    }

    public View E(int i, View view2, ViewGroup viewGroup, we9 we9Var, b bVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, we9Var, bVar})) == null) {
            super.onFillViewHolder(i, view2, viewGroup, (ViewGroup) we9Var, (we9) bVar);
            if (we9Var != null && bVar != null) {
                we9Var.b = i + 1;
                this.h = we9Var;
                C(we9Var);
                bVar.d(this.mContext, we9Var.a);
            }
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    public void onDestroy() {
        vj9 vj9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (vj9Var = this.g) != null) {
            vj9Var.q();
        }
    }

    @Override // com.baidu.tieba.wh9, com.baidu.tieba.ln
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i, View view2, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        E(i, view2, viewGroup, (we9) obj, (b) viewHolder);
        return view2;
    }
}
