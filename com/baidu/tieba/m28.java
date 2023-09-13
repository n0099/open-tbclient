package com.baidu.tieba;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tieba.c28;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class m28 implements vx {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TbPageContext<?> a;
    public View b;
    public HorizontalScrollView c;
    public TextView d;
    public LinearLayout e;
    public LinearLayout f;
    public ArrayList<TextView> g;

    public m28(TbPageContext<?> mPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(mPageContext, "mPageContext");
        this.a = mPageContext;
        this.g = new ArrayList<>();
        d();
    }

    public final void f(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, textView) == null) {
            EMManager.from(textView).setTextColor(R.color.CAM_X0105).setTextSize(R.dimen.T_X08).setTextStyle(R.string.F_X02).setCorner(R.string.J_X07).setBackGroundColor(R.color.CAM_X0204);
        }
    }

    public static final void b(c28.b itemData, m28 this$0, c28 data, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65537, null, itemData, this$0, data, view2) == null) {
            Intrinsics.checkNotNullParameter(itemData, "$itemData");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(data, "$data");
            UrlManager.getInstance().dealOneLink(itemData.c());
            if (Intrinsics.areEqual(itemData.b(), "topic")) {
                String str = data.g;
                Intrinsics.checkNotNullExpressionValue(str, "data.tid");
                this$0.h(str, itemData.a(), 1);
            }
        }
    }

    public final void a(final c28.b bVar, final c28 c28Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, bVar, c28Var) == null) {
            TextView textView = new TextView(this.a.getPageActivity());
            textView.setText(bVar.d());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.leftMargin = BdUtilHelper.getDimens(this.a.getPageActivity(), R.dimen.M_W_X004);
            textView.setLayoutParams(layoutParams);
            textView.setGravity(17);
            textView.setPadding(BdUtilHelper.getDimens(this.a.getPageActivity(), R.dimen.M_W_X006), BdUtilHelper.getDimens(this.a.getPageActivity(), R.dimen.tbds24), BdUtilHelper.getDimens(this.a.getPageActivity(), R.dimen.M_W_X006), BdUtilHelper.getDimens(this.a.getPageActivity(), R.dimen.tbds24));
            textView.setMaxLines(1);
            f(textView);
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.g28
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        m28.b(c28.b.this, this, c28Var, view2);
                    }
                }
            });
            this.g.add(textView);
            LinearLayout linearLayout = this.f;
            if (linearLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRecomBackTagLayout");
                linearLayout = null;
            }
            linearLayout.addView(textView);
        }
    }

    public final View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            View view2 = this.b;
            if (view2 != null) {
                return view2;
            }
            Intrinsics.throwUninitializedPropertyAccessException("rootView");
            return null;
        }
        return (View) invokeV.objValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            TextView textView = null;
            View inflate = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0860, (ViewGroup) null);
            Intrinsics.checkNotNullExpressionValue(inflate, "from(mPageContext.pageAc…nd_back_topic_card, null)");
            g(inflate);
            View findViewById = c().findViewById(R.id.obfuscated_res_0x7f091e8d);
            Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.recom_back_scrollview)");
            this.c = (HorizontalScrollView) findViewById;
            View findViewById2 = c().findViewById(R.id.obfuscated_res_0x7f091e8c);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.recom_back_layout)");
            this.e = (LinearLayout) findViewById2;
            View findViewById3 = c().findViewById(R.id.obfuscated_res_0x7f091e8e);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.recom_back_tags)");
            this.f = (LinearLayout) findViewById3;
            View findViewById4 = c().findViewById(R.id.obfuscated_res_0x7f091e8f);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.id.recom_back_title)");
            this.d = (TextView) findViewById4;
            EMManager.from(c()).setCardType(0).setCorner(R.string.J_X06).setBackGroundColor(R.color.CAM_X0205);
            TextView textView2 = this.d;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRecomBackTitle");
            } else {
                textView = textView2;
            }
            EMManager.from(textView).setTextColor(R.color.CAM_X0105).setTextStyle(R.string.F_X02);
        }
    }

    public final void e(c28 c28Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, c28Var) == null) {
            if (!c28.U0.b(c28Var)) {
                c().setVisibility(8);
                return;
            }
            HorizontalScrollView horizontalScrollView = this.c;
            TextView textView = null;
            if (horizontalScrollView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRecomBackScrollView");
                horizontalScrollView = null;
            }
            horizontalScrollView.scrollTo(0, 0);
            this.g.clear();
            LinearLayout linearLayout = this.f;
            if (linearLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRecomBackTagLayout");
                linearLayout = null;
            }
            linearLayout.removeAllViews();
            c().setVisibility(0);
            TextView textView2 = this.d;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRecomBackTitle");
            } else {
                textView = textView2;
            }
            Intrinsics.checkNotNull(c28Var);
            textView.setText(c28Var.W());
            for (c28.b bVar : c28Var.V()) {
                a(bVar, c28Var);
            }
            i(c28Var);
        }
    }

    public final void i(c28 c28Var) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, c28Var) == null) {
            StatisticItem statisticItem = new StatisticItem("c15368");
            statisticItem.param("tid", c28Var.g);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            StringBuilder sb = new StringBuilder();
            for (c28.b bVar : c28Var.V()) {
                if (bVar != null && Intrinsics.areEqual(bVar.b(), "topic")) {
                    sb.append(bVar.a());
                    sb.append(',');
                }
            }
            if (sb.length() > 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                sb.delete(sb.length() - 1, sb.length());
            }
            statisticItem.param("topic_id", sb.toString());
            TiebaStatic.log(statisticItem);
        }
    }

    public final void g(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view2) == null) {
            Intrinsics.checkNotNullParameter(view2, "<set-?>");
            this.b = view2;
        }
    }

    public final void h(String str, long j, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{str, Long.valueOf(j), Integer.valueOf(i)}) == null) {
            StatisticItem statisticItem = new StatisticItem("c15369");
            statisticItem.param("tid", str);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("topic_id", j);
            statisticItem.param("obj_locate", i);
            TiebaStatic.log(statisticItem);
        }
    }

    @Override // com.baidu.tieba.vx
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, tbPageContext, i) == null) {
            EMManager.from(c()).setCardType(0).setCorner(R.string.J_X06).setBackGroundColor(R.color.CAM_X0205);
            TextView textView = this.d;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRecomBackTitle");
                textView = null;
            }
            EMManager.from(textView).setTextColor(R.color.CAM_X0105).setTextStyle(R.string.F_X02);
            Iterator<TextView> it = this.g.iterator();
            while (it.hasNext()) {
                f(it.next());
            }
        }
    }
}
