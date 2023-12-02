package com.baidu.tieba.myAttentionAndFans;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.adp.base.BdPageContext;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tieba.R;
import com.baidu.tieba.l05;
import com.baidu.tieba.n05;
import com.baidu.tieba.p05;
import com.baidu.tieba.yb;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class MyFansUserLikeButton extends CommonUserLikeButton {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdPageContext g;
    public n05 h;
    public String i;
    public int j;

    @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton
    public void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
        }
    }

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View.OnClickListener a;
        public final /* synthetic */ MyFansUserLikeButton b;

        /* renamed from: com.baidu.tieba.myAttentionAndFans.MyFansUserLikeButton$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0398a implements p05.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ View a;
            public final /* synthetic */ a b;

            public C0398a(a aVar, View view2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, view2};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = aVar;
                this.a = view2;
            }

            @Override // com.baidu.tieba.p05.e
            public void onClick() {
                View.OnClickListener onClickListener;
                Interceptable interceptable = $ic;
                if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || (onClickListener = this.b.a) == null) {
                    return;
                }
                onClickListener.onClick(this.a);
                if (this.b.b.j == 1) {
                    TiebaStatic.log(new StatisticItem("c12773").param("obj_param1", this.b.b.i));
                } else if (this.b.b.j == 2) {
                    TiebaStatic.log(new StatisticItem("C12603").param("obj_param1", this.b.b.i));
                }
                yb.b(this.b.b.h, this.b.b.g);
            }
        }

        /* loaded from: classes7.dex */
        public class b implements p05.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public b(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // com.baidu.tieba.p05.c
            public void onClick() {
                Interceptable interceptable = $ic;
                if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.a.b.h == null) {
                    return;
                }
                yb.b(this.a.b.h, this.a.b.g);
            }
        }

        public a(MyFansUserLikeButton myFansUserLikeButton, View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {myFansUserLikeButton, onClickListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = myFansUserLikeButton;
            this.a = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.b.j == 1) {
                    StatisticItem statisticItem = new StatisticItem("c12772");
                    if (this.b.c) {
                        str = "3";
                    } else {
                        str = "2";
                    }
                    TiebaStatic.log(statisticItem.param("obj_locate", str).param("obj_param1", this.b.i));
                } else {
                    int i = 2;
                    if (this.b.j == 2) {
                        StatisticItem statisticItem2 = new StatisticItem("c12605");
                        if (this.b.c) {
                            i = 3;
                        }
                        TiebaStatic.log(statisticItem2.param("obj_locate", i).param("obj_param1", this.b.i));
                    }
                }
                if (!this.b.c) {
                    this.a.onClick(view2);
                } else if (this.b.g != null) {
                    if (this.b.h == null) {
                        p05 p05Var = new p05(this.b.g.getContext());
                        p05Var.u(this.b.g.getString(R.string.confirm_unlike));
                        ArrayList arrayList = new ArrayList();
                        l05 l05Var = new l05(this.b.g.getString(R.string.obfuscated_res_0x7f0f04d2), p05Var);
                        l05Var.n(new C0398a(this, view2));
                        arrayList.add(l05Var);
                        p05Var.p(new b(this));
                        p05Var.m(arrayList);
                        this.b.h = new n05(this.b.g, p05Var);
                        this.b.h.k(0.7f);
                    }
                    yb.j(this.b.h, this.b.g);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MyFansUserLikeButton(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = 1;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MyFansUserLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.j = 1;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MyFansUserLikeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.j = 1;
    }

    @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton, com.baidu.tieba.f75
    public void e(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onClickListener) == null) {
            setOnClickListener(new a(this, onClickListener));
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton
    public void g(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            if (this.c) {
                SkinManager.setViewTextColor(this, (int) R.color.btn_forum_focus_gray_color);
                SkinManager.setBackgroundResource(this, R.drawable.btn_transparent_gray_border);
                return;
            }
            SkinManager.setViewTextColor(this, (int) R.color.btn_forum_focus_color);
            SkinManager.setBackgroundResource(this, R.drawable.btn_transparent_focus_border_bg);
        }
    }

    public void setContext(BdPageContext bdPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bdPageContext) == null) {
            this.g = bdPageContext;
        }
    }

    public void setStatsParams(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048581, this, i, str) == null) {
            this.j = i;
            this.i = str;
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton, com.baidu.tieba.f75
    public void d(boolean z, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            this.c = z;
            if (z) {
                if (i != 1) {
                    if (i != 2) {
                        setTextSize(0, BdUtilHelper.getDimens(getContext(), R.dimen.obfuscated_res_0x7f0701f0));
                        setText(this.a);
                    } else {
                        setTextSize(0, BdUtilHelper.getDimens(getContext(), R.dimen.obfuscated_res_0x7f0701e8));
                        setText(R.string.each_concerned);
                    }
                } else {
                    setTextSize(0, BdUtilHelper.getDimens(getContext(), R.dimen.obfuscated_res_0x7f0701f0));
                    setText(this.a);
                }
            } else {
                setTextSize(0, BdUtilHelper.getDimens(getContext(), R.dimen.obfuscated_res_0x7f0701f0));
                setText(this.b);
            }
            g(TbadkCoreApplication.getInst().getSkinType());
        }
    }
}
