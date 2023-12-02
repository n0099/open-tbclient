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
import com.baidu.adp.lib.util.BdUtilHelper;
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
/* loaded from: classes8.dex */
public class ut extends qs implements it<ThreadData>, jt {
    public static /* synthetic */ Interceptable $ic;
    public static final int k;
    public transient /* synthetic */ FieldHolder $fh;
    public RelativeLayout a;
    public ImageView b;
    public FrameLayout c;
    public ThreadData d;
    public BdUniqueId e;
    public int f;
    public int g;
    public int h;
    public Align i;
    public View.OnClickListener j;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ut a;

        public a(ut utVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {utVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = utVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || this.a.d == null) {
                return;
            }
            CustomMessage customMessage = new CustomMessage(2921428, this.a.e);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921428, this.a.d);
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448319214, "Lcom/baidu/tieba/ut;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448319214, "Lcom/baidu/tieba/ut;");
                return;
            }
        }
        k = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds62);
    }

    public ut(Context context, int i) {
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
        this.f = 0;
        this.g = R.drawable.ic_icon_pure_card_delete_svg;
        this.h = R.color.CAM_X0111;
        this.j = new a(this);
        this.f = i;
        this.a = new RelativeLayout(context);
        this.b = new ImageView(context);
        FrameLayout frameLayout = new FrameLayout(context);
        this.c = frameLayout;
        ImageView imageView = this.b;
        int i4 = k;
        frameLayout.addView(imageView, new FrameLayout.LayoutParams(i4, i4));
        this.c.setOnClickListener(this.j);
        c(Align.ALIGN_RIGHT_BOTTOM);
        this.a.addView(this.c);
        setDecorView(this.a);
        setInsertIndex(-1);
        setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    }

    public void autoAlignParent(fw4 fw4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, fw4Var) == null) {
            c(Align.ALIGN_RIGHT_TOP);
        }
    }

    public final boolean d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            if ((i & this.f) > 0) {
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public void f(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bdUniqueId) == null) {
            this.e = bdUniqueId;
        }
    }

    public void c(Align align) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, align) != null) || align == this.i) {
            return;
        }
        if (align == Align.ALIGN_RIGHT_TOP) {
            int dimens = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds77);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            layoutParams.rightMargin = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds42);
            layoutParams.topMargin = dimens;
            layoutParams.bottomMargin = 0;
            this.c.setLayoutParams(layoutParams);
        } else if (align == Align.ALIGN_RIGHT_CENTER) {
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.addRule(11);
            layoutParams2.addRule(15);
            layoutParams2.rightMargin = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds42);
            layoutParams2.topMargin = 0;
            layoutParams2.bottomMargin = 0;
            this.c.setLayoutParams(layoutParams2);
        } else if (align == Align.ALIGN_RIGHT_BOTTOM) {
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams3.addRule(11);
            layoutParams3.addRule(12);
            layoutParams3.rightMargin = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds42);
            layoutParams3.bottomMargin = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds51);
            layoutParams3.topMargin = 0;
            this.c.setLayoutParams(layoutParams3);
        }
        this.i = align;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.it
    /* renamed from: e */
    public void onBindDataToView(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, threadData) == null) {
            this.d = threadData;
            if (threadData == null) {
                this.c.setVisibility(8);
            } else if (!d(4)) {
                this.c.setVisibility(8);
            } else {
                this.c.setVisibility(0);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.b, this.g, this.h, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
        }
    }

    @Override // com.baidu.tieba.jt
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, tbPageContext, i) == null) {
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.b, this.g, this.h, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }
}
