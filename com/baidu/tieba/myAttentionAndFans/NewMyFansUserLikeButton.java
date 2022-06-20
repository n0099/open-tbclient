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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.d9;
import com.repackage.sg;
import com.repackage.uq4;
import com.repackage.wq4;
import com.repackage.yq4;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class NewMyFansUserLikeButton extends FollowUserButton {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String r;
    public String s;
    public d9 t;
    public wq4 u;
    public String v;
    public int w;
    public boolean x;
    public b y;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View.OnClickListener a;
        public final /* synthetic */ NewMyFansUserLikeButton b;

        /* renamed from: com.baidu.tieba.myAttentionAndFans.NewMyFansUserLikeButton$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0214a implements yq4.d {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ View a;
            public final /* synthetic */ a b;

            public C0214a(a aVar, View view2) {
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

            @Override // com.repackage.yq4.d
            public void onClick() {
                View.OnClickListener onClickListener;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (onClickListener = this.b.a) == null) {
                    return;
                }
                onClickListener.onClick(this.a);
                if (this.b.b.w != 1) {
                    if (this.b.b.w == 2) {
                        TiebaStatic.log(new StatisticItem("C12603").param("obj_param1", this.b.b.v));
                    }
                } else {
                    TiebaStatic.log(new StatisticItem("c12773").param("obj_param1", this.b.b.v));
                }
                sg.b(this.b.b.u, this.b.b.t);
            }
        }

        /* loaded from: classes3.dex */
        public class b implements yq4.c {
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

            @Override // com.repackage.yq4.c
            public void onClick() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.b.u == null) {
                    return;
                }
                sg.b(this.a.b.u, this.a.b.t);
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
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.b.w != 1) {
                    if (this.b.w == 2) {
                        TiebaStatic.log(new StatisticItem("c12605").param("obj_locate", this.b.x ? 3 : 2).param("obj_param1", this.b.v));
                    }
                } else {
                    TiebaStatic.log(new StatisticItem("c12772").param("obj_locate", this.b.x ? "3" : "2").param("obj_param1", this.b.v));
                }
                if (this.b.x) {
                    if (this.b.t != null) {
                        if (this.b.u == null) {
                            yq4 yq4Var = new yq4(this.b.t.getContext());
                            yq4Var.q(this.b.t.getString(R.string.obfuscated_res_0x7f0f0429));
                            ArrayList arrayList = new ArrayList();
                            uq4 uq4Var = new uq4(this.b.t.getString(R.string.obfuscated_res_0x7f0f041f), yq4Var);
                            uq4Var.m(new C0214a(this, view2));
                            arrayList.add(uq4Var);
                            yq4Var.m(new b(this));
                            yq4Var.j(arrayList);
                            this.b.u = new wq4(this.b.t, yq4Var);
                            this.b.u.l(0.7f);
                        }
                        sg.j(this.b.u, this.b.t);
                    }
                } else {
                    this.a.onClick(view2);
                }
                if (this.b.y != null) {
                    this.b.y.a();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a();
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
        this.r = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0fa3);
        this.s = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f02a4);
        this.w = 1;
        this.x = false;
    }

    @Override // com.baidu.tbadk.core.view.FollowUserButton, com.repackage.zu4
    public void b(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, onClickListener) == null) {
            setOnClickListener(new a(this, onClickListener));
        }
    }

    @Override // com.baidu.tbadk.core.view.FollowUserButton, com.repackage.zu4
    public void e(boolean z, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            super.e(z, i);
            this.x = z;
            if (!z) {
                setText(this.s);
            } else if (i == 1) {
                setText(this.r);
            } else if (i != 2) {
                setText(this.r);
            } else {
                setText(this.t.getString(R.string.obfuscated_res_0x7f0f050e));
            }
            r(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void setCallback(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.y = bVar;
        }
    }

    public void setContext(d9 d9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, d9Var) == null) {
            this.t = d9Var;
        }
    }

    public void setStatsParams(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048580, this, i, str) == null) {
            this.w = i;
            this.v = str;
        }
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
        this.r = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0fa3);
        this.s = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f02a4);
        this.w = 1;
        this.x = false;
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
        this.r = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0fa3);
        this.s = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f02a4);
        this.w = 1;
        this.x = false;
    }
}
