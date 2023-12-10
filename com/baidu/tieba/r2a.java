package com.baidu.tieba;

import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.elementsMaven.span.EMRichTextAnyIconSpan;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class r2a {
    public static /* synthetic */ Interceptable $ic;
    public static final String g;
    public transient /* synthetic */ FieldHolder $fh;
    public FrameLayout a;
    public LinearLayout b;
    public EMTextView c;
    public EMTextView d;
    public String e;
    public int f;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbPageContext a;
        public final /* synthetic */ r2a b;

        public a(r2a r2aVar, TbPageContext tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r2aVar, tbPageContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = r2aVar;
            this.a = tbPageContext;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                UrlManager urlManager = UrlManager.getInstance();
                TbPageContext<?> tbPageContext = this.a;
                urlManager.dealOneLink(tbPageContext, new String[]{r2a.g + this.b.e});
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_UEG_POST_CLICKED).param("obj_locate", this.b.f));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948071112, "Lcom/baidu/tieba/r2a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948071112, "Lcom/baidu/tieba/r2a;");
                return;
            }
        }
        g = TbConfig.TIEBA_ADDRESS + "mo/q/wise-bawu-core/recycle-station#/recycle-post?noshare=1&postId=";
    }

    public r2a(TbPageContext<?> tbPageContext, FrameLayout frameLayout) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, frameLayout};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = frameLayout;
        i(tbPageContext);
    }

    public r2a(PbFragment pbFragment) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pbFragment};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        d(pbFragment.getPageContext());
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public r2a(AbsVideoPbFragment absVideoPbFragment, FrameLayout frameLayout) {
        this(absVideoPbFragment.getPageContext(), frameLayout);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {absVideoPbFragment, frameLayout};
            interceptable.invokeUnInit(65539, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((TbPageContext) objArr2[0], (FrameLayout) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            EMManager.from(this.b).setCorner(R.string.J_X05).setBackGroundColor(R.color.CAM_X0206);
            SkinManager.setViewTextColor(this.c, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.d, (int) R.color.CAM_X0109);
        }
    }

    public final void d(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext) != null) || this.a != null) {
            return;
        }
        this.a = (FrameLayout) LayoutInflater.from(tbPageContext.getContext()).inflate(R.layout.obfuscated_res_0x7f0d07cd, (ViewGroup) null);
        i(tbPageContext);
    }

    public void f(BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, bdTypeListView) == null) && bdTypeListView != null) {
            bdTypeListView.removeHeaderView(this.a);
        }
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.e = str;
        }
    }

    public void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.a.setVisibility(i);
        }
    }

    public void c(BdTypeListView bdTypeListView, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048576, this, bdTypeListView, i) == null) && bdTypeListView != null) {
            bdTypeListView.w(this.a, i);
        }
    }

    public final void i(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, tbPageContext) == null) {
            this.b = (LinearLayout) this.a.findViewById(R.id.obfuscated_res_0x7f0907f7);
            this.c = (EMTextView) this.a.findViewById(R.id.tv_title);
            this.d = (EMTextView) this.a.findViewById(R.id.tv_content);
            EMManager.from(this.c).setTextColor(R.color.CAM_X0109).setTextStyle(R.string.F_X01);
            EMManager.from(this.d).setTextLinePadding(R.dimen.M_H_X003).setTextColor(R.color.CAM_X0109).setTextStyle(R.string.F_X01);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(tbPageContext.getResources().getString(R.string.pb_head_block_title));
            EMRichTextAnyIconSpan eMRichTextAnyIconSpan = new EMRichTextAnyIconSpan(R.drawable.icon_pure_barrules_careful12, R.color.CAM_X0109, EMRichTextAnyIconSpan.IconType.WEBP);
            eMRichTextAnyIconSpan.l(BdUtilHelper.getDimens(tbPageContext.getContext(), R.dimen.tbds31));
            eMRichTextAnyIconSpan.j(BdUtilHelper.getDimens(tbPageContext.getContext(), R.dimen.M_W_X002));
            eMRichTextAnyIconSpan.f(0);
            spannableStringBuilder.setSpan(eMRichTextAnyIconSpan, 0, 1, 33);
            this.c.setText(spannableStringBuilder);
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(tbPageContext.getResources().getString(R.string.pb_head_block_content));
            EMRichTextAnyIconSpan eMRichTextAnyIconSpan2 = new EMRichTextAnyIconSpan(R.drawable.icon_pure_arrow12_right_n, R.color.CAM_X0109, EMRichTextAnyIconSpan.IconType.WEBP);
            eMRichTextAnyIconSpan2.f(BdUtilHelper.getDimens(tbPageContext.getContext(), R.dimen.tbds3));
            spannableStringBuilder2.setSpan(eMRichTextAnyIconSpan2, spannableStringBuilder2.length() - 1, spannableStringBuilder2.length(), 33);
            this.d.setText(spannableStringBuilder2);
            this.b.setOnClickListener(new a(this, tbPageContext));
        }
    }
}
