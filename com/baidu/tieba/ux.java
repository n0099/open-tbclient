package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.Align;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class ux extends qw implements gx<ThreadData>, hx {
    public static /* synthetic */ Interceptable $ic;
    public static final int o;
    public transient /* synthetic */ FieldHolder $fh;
    public RelativeLayout e;
    public ImageView f;
    public FrameLayout g;
    public ThreadData h;
    public BdUniqueId i;
    public int j;
    public int k;
    public int l;
    public Align m;
    public View.OnClickListener n;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ux a;

        public a(ux uxVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uxVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = uxVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || this.a.h == null) {
                return;
            }
            CustomMessage customMessage = new CustomMessage(2921428, this.a.i);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921428, this.a.h);
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448319338, "Lcom/baidu/tieba/ux;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448319338, "Lcom/baidu/tieba/ux;");
                return;
            }
        }
        o = hi.g(TbadkCoreApplication.getInst(), R.dimen.tbds62);
    }

    public ux(Context context, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.j = 0;
        this.k = R.drawable.ic_icon_pure_card_delete_svg;
        this.l = R.color.CAM_X0111;
        this.n = new a(this);
        this.j = i;
        this.e = new RelativeLayout(context);
        this.f = new ImageView(context);
        FrameLayout frameLayout = new FrameLayout(context);
        this.g = frameLayout;
        ImageView imageView = this.f;
        int i4 = o;
        frameLayout.addView(imageView, new FrameLayout.LayoutParams(i4, i4));
        this.g.setOnClickListener(this.n);
        m(Align.ALIGN_RIGHT_BOTTOM);
        this.e.addView(this.g);
        g(this.e);
        h(-1);
        i(new RelativeLayout.LayoutParams(-1, -1));
    }

    public void n(hw4 hw4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, hw4Var) == null) {
            m(Align.ALIGN_RIGHT_TOP);
        }
    }

    public final boolean o(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            if ((i & this.j) > 0) {
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public void q(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bdUniqueId) == null) {
            this.i = bdUniqueId;
        }
    }

    public void m(Align align) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, align) != null) || align == this.m) {
            return;
        }
        if (align == Align.ALIGN_RIGHT_TOP) {
            int g = hi.g(TbadkCoreApplication.getInst(), R.dimen.tbds77);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            layoutParams.rightMargin = hi.g(TbadkCoreApplication.getInst(), R.dimen.tbds42);
            layoutParams.topMargin = g;
            layoutParams.bottomMargin = 0;
            this.g.setLayoutParams(layoutParams);
        } else if (align == Align.ALIGN_RIGHT_CENTER) {
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.addRule(11);
            layoutParams2.addRule(15);
            layoutParams2.rightMargin = hi.g(TbadkCoreApplication.getInst(), R.dimen.tbds42);
            layoutParams2.topMargin = 0;
            layoutParams2.bottomMargin = 0;
            this.g.setLayoutParams(layoutParams2);
        } else if (align == Align.ALIGN_RIGHT_BOTTOM) {
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams3.addRule(11);
            layoutParams3.addRule(12);
            layoutParams3.rightMargin = hi.g(TbadkCoreApplication.getInst(), R.dimen.tbds42);
            layoutParams3.bottomMargin = hi.g(TbadkCoreApplication.getInst(), R.dimen.tbds51);
            layoutParams3.topMargin = 0;
            this.g.setLayoutParams(layoutParams3);
        }
        this.m = align;
    }

    @Override // com.baidu.tieba.hx
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, tbPageContext, i) == null) {
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f, this.k, this.l, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.gx
    /* renamed from: p */
    public void a(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, threadData) == null) {
            this.h = threadData;
            if (threadData == null) {
                this.g.setVisibility(8);
            } else if (!o(4)) {
                this.g.setVisibility(8);
            } else {
                this.g.setVisibility(0);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f, this.k, this.l, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
        }
    }
}
