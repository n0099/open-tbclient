package com.baidu.tieba;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.flow.CoverFlowView;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.p27;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes6.dex */
public class l27 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Pattern a;
    public TbPageContext<?> b;
    public View c;
    public CoverFlowView<q75> d;
    public p27 e;
    public t75<q75> f;

    public void f(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, bdUniqueId) != null) || bdUniqueId == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class a extends r75 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l27 a;

        public a(l27 l27Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l27Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l27Var;
        }

        @Override // com.baidu.tieba.r75, com.baidu.tieba.p75
        public TbImageView d(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) {
                TbImageView tbImageView = new TbImageView(context);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                tbImageView.setGifIconSupport(false);
                return tbImageView;
            }
            return (TbImageView) invokeL.objValue;
        }

        @Override // com.baidu.tieba.r75, com.baidu.tieba.p75
        public s75 a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                s75 a = super.a();
                if (a != null) {
                    a.d(81);
                    a.e(R.dimen.obfuscated_res_0x7f0701d5);
                }
                return a;
            }
            return (s75) invokeV.objValue;
        }

        @Override // com.baidu.tieba.r75, com.baidu.tieba.p75
        public v75 c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                v75 v75Var = new v75();
                v75Var.a((int) (vi.l(this.a.b.getPageActivity()) / 2.5714285f));
                return v75Var;
            }
            return (v75) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b implements t75<q75> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l27 a;

        @Override // com.baidu.tieba.t75
        public void a(int i, q75 q75Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeIL(1048576, this, i, q75Var) != null) || q75Var == null) {
            }
        }

        public b(l27 l27Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l27Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l27Var;
        }

        @Override // com.baidu.tieba.t75
        public void b(int i, String str) {
            p27.a aVar;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) != null) || (aVar = (p27.a) this.a.d.o(i)) == null) {
                return;
            }
            Matcher matcher = this.a.a.matcher(aVar.getPicLinkUrl());
            if (matcher.find()) {
                this.a.b.sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.a.b.getPageActivity()).createNormalCfg(matcher.group(1), null, null)));
            }
        }
    }

    public l27(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = Pattern.compile(UrlSchemaHelper.PB_URL);
        this.b = null;
        this.d = null;
        this.e = null;
        this.f = new b(this);
        this.b = tbPageContext;
        d();
    }

    public void e(p27 p27Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, p27Var) == null) && p27Var != null && p27Var != this.e) {
            this.d.setData(p27Var.a());
            this.e = p27Var;
        }
    }

    public void g(boolean z) {
        CoverFlowView<q75> coverFlowView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048580, this, z) != null) || (coverFlowView = this.d) == null) {
            return;
        }
        if (z) {
            coverFlowView.m();
        } else {
            coverFlowView.x();
        }
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.c;
        }
        return (View) invokeV.objValue;
    }

    public void h() {
        CoverFlowView<q75> coverFlowView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (coverFlowView = this.d) != null) {
            coverFlowView.w();
        }
    }

    public final void d() {
        TbPageContext<?> tbPageContext;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || (tbPageContext = this.b) == null) {
            return;
        }
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d08a7, (ViewGroup) null);
        this.c = inflate;
        if (inflate == null) {
            return;
        }
        this.d = (CoverFlowView) inflate.findViewById(R.id.obfuscated_res_0x7f0921b8);
        a aVar = new a(this);
        this.d.setDisableParentEvent(false);
        this.d.setCoverFlowFactory(aVar);
        this.d.setCallback(this.f);
    }
}
