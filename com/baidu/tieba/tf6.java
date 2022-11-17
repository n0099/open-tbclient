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
import com.baidu.tieba.xf6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes6.dex */
public class tf6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Pattern a;
    public TbPageContext<?> b;
    public View c;
    public CoverFlowView<vw4> d;
    public xf6 e;
    public yw4<vw4> f;

    public void f(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, bdUniqueId) != null) || bdUniqueId == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class a extends ww4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tf6 a;

        public a(tf6 tf6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tf6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tf6Var;
        }

        @Override // com.baidu.tieba.ww4, com.baidu.tieba.uw4
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

        @Override // com.baidu.tieba.ww4, com.baidu.tieba.uw4
        public xw4 a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                xw4 a = super.a();
                if (a != null) {
                    a.d(81);
                    a.e(R.dimen.obfuscated_res_0x7f0701d5);
                }
                return a;
            }
            return (xw4) invokeV.objValue;
        }

        @Override // com.baidu.tieba.ww4, com.baidu.tieba.uw4
        public ax4 c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                ax4 ax4Var = new ax4();
                ax4Var.a((int) (yi.l(this.a.b.getPageActivity()) / 2.5714285f));
                return ax4Var;
            }
            return (ax4) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b implements yw4<vw4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tf6 a;

        @Override // com.baidu.tieba.yw4
        public void a(int i, vw4 vw4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeIL(1048576, this, i, vw4Var) != null) || vw4Var == null) {
            }
        }

        public b(tf6 tf6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tf6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tf6Var;
        }

        @Override // com.baidu.tieba.yw4
        public void b(int i, String str) {
            xf6.a aVar;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) != null) || (aVar = (xf6.a) this.a.d.n(i)) == null) {
                return;
            }
            Matcher matcher = this.a.a.matcher(aVar.getPicLinkUrl());
            if (matcher.find()) {
                this.a.b.sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.a.b.getPageActivity()).createNormalCfg(matcher.group(1), null, null)));
            }
        }
    }

    public tf6(TbPageContext<?> tbPageContext) {
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

    public void e(xf6 xf6Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, xf6Var) == null) && xf6Var != null && xf6Var != this.e) {
            this.d.setData(xf6Var.a());
            this.e = xf6Var;
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

    public void g() {
        CoverFlowView<vw4> coverFlowView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (coverFlowView = this.d) != null) {
            coverFlowView.v();
        }
    }

    public final void d() {
        TbPageContext<?> tbPageContext;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || (tbPageContext = this.b) == null) {
            return;
        }
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0800, (ViewGroup) null);
        this.c = inflate;
        if (inflate == null) {
            return;
        }
        this.d = (CoverFlowView) inflate.findViewById(R.id.obfuscated_res_0x7f091f97);
        a aVar = new a(this);
        this.d.setDisableParentEvent(false);
        this.d.setCoverFlowFactory(aVar);
        this.d.setCallback(this.f);
    }
}
