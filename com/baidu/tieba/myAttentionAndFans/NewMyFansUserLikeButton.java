package com.baidu.tieba.myAttentionAndFans;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.FollowUserButton;
import com.baidu.tieba.R;
import com.baidu.tieba.a9;
import com.baidu.tieba.g05;
import com.baidu.tieba.i05;
import com.baidu.tieba.k05;
import com.baidu.tieba.lg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class NewMyFansUserLikeButton extends FollowUserButton {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String r;
    public String s;
    public a9 t;
    public i05 u;
    public String v;
    public int w;
    public boolean x;
    public b y;

    /* loaded from: classes5.dex */
    public interface b {
        void a();
    }

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View.OnClickListener a;
        public final /* synthetic */ NewMyFansUserLikeButton b;

        /* renamed from: com.baidu.tieba.myAttentionAndFans.NewMyFansUserLikeButton$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0342a implements k05.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ View a;
            public final /* synthetic */ a b;

            public C0342a(a aVar, View view2) {
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

            @Override // com.baidu.tieba.k05.e
            public void onClick() {
                View.OnClickListener onClickListener;
                Interceptable interceptable = $ic;
                if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || (onClickListener = this.b.a) == null) {
                    return;
                }
                onClickListener.onClick(this.a);
                if (this.b.b.w == 1) {
                    TiebaStatic.log(new StatisticItem("c12773").param("obj_param1", this.b.b.v));
                } else if (this.b.b.w == 2) {
                    TiebaStatic.log(new StatisticItem("C12603").param("obj_param1", this.b.b.v));
                }
                lg.b(this.b.b.u, this.b.b.t);
            }
        }

        /* loaded from: classes5.dex */
        public class b implements k05.c {
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

            @Override // com.baidu.tieba.k05.c
            public void onClick() {
                Interceptable interceptable = $ic;
                if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.a.b.u == null) {
                    return;
                }
                lg.b(this.a.b.u, this.a.b.t);
            }
        }

        public a(NewMyFansUserLikeButton newMyFansUserLikeButton, View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newMyFansUserLikeButton, onClickListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = newMyFansUserLikeButton;
            this.a = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.b.w == 1) {
                    StatisticItem statisticItem = new StatisticItem("c12772");
                    if (this.b.x) {
                        str = "3";
                    } else {
                        str = "2";
                    }
                    TiebaStatic.log(statisticItem.param("obj_locate", str).param("obj_param1", this.b.v));
                } else {
                    int i = 2;
                    if (this.b.w == 2) {
                        StatisticItem statisticItem2 = new StatisticItem("c12605");
                        if (this.b.x) {
                            i = 3;
                        }
                        TiebaStatic.log(statisticItem2.param("obj_locate", i).param("obj_param1", this.b.v));
                    }
                }
                if (!this.b.x) {
                    this.a.onClick(view2);
                } else if (this.b.t != null) {
                    if (this.b.u == null) {
                        k05 k05Var = new k05(this.b.t.getContext());
                        k05Var.s(this.b.t.getString(R.string.confirm_unlike));
                        ArrayList arrayList = new ArrayList();
                        g05 g05Var = new g05(this.b.t.getString(R.string.obfuscated_res_0x7f0f045e), k05Var);
                        g05Var.m(new C0342a(this, view2));
                        arrayList.add(g05Var);
                        k05Var.n(new b(this));
                        k05Var.k(arrayList);
                        this.b.u = new i05(this.b.t, k05Var);
                        this.b.u.j(0.7f);
                    }
                    lg.j(this.b.u, this.b.t);
                }
                if (this.b.y != null) {
                    this.b.y.a();
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewMyFansUserLikeButton(Context context) {
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
        this.r = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.s = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f02ba);
        this.w = 1;
        this.x = false;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewMyFansUserLikeButton(Context context, @Nullable AttributeSet attributeSet) {
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
        this.r = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.s = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f02ba);
        this.w = 1;
        this.x = false;
    }

    @Override // com.baidu.tbadk.core.view.FollowUserButton, com.baidu.tieba.m55
    public void d(boolean z, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            super.d(z, i);
            this.x = z;
            if (z) {
                if (i != 1) {
                    if (i != 2) {
                        setText(this.r);
                    } else {
                        setText(this.t.getString(R.string.each_concerned));
                    }
                } else {
                    setText(this.r);
                }
            } else {
                setText(this.s);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewMyFansUserLikeButton(Context context, @Nullable AttributeSet attributeSet, int i) {
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
        this.r = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.s = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f02ba);
        this.w = 1;
        this.x = false;
    }

    @Override // com.baidu.tbadk.core.view.FollowUserButton, com.baidu.tieba.m55
    public void e(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onClickListener) == null) {
            setOnClickListener(new a(this, onClickListener));
        }
    }

    public void setCallback(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.y = bVar;
        }
    }

    public void setContext(a9 a9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, a9Var) == null) {
            this.t = a9Var;
        }
    }

    public void setStatsParams(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048580, this, i, str) == null) {
            this.w = i;
            this.v = str;
        }
    }
}
