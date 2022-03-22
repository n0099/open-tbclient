package com.baidu.tieba.myAttentionAndFans;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import c.a.d.a.f;
import c.a.d.f.m.g;
import c.a.d.f.p.n;
import c.a.o0.r.t.h;
import c.a.o0.r.t.j;
import c.a.o0.r.t.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class MyFansUserLikeButton extends CommonUserLikeButton {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: g  reason: collision with root package name */
    public f f34556g;

    /* renamed from: h  reason: collision with root package name */
    public j f34557h;
    public String i;
    public int j;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View.OnClickListener a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ MyFansUserLikeButton f34558b;

        /* renamed from: com.baidu.tieba.myAttentionAndFans.MyFansUserLikeButton$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C1866a implements l.d {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ View a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ a f34559b;

            public C1866a(a aVar, View view) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, view};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f34559b = aVar;
                this.a = view;
            }

            @Override // c.a.o0.r.t.l.d
            public void onClick() {
                View.OnClickListener onClickListener;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (onClickListener = this.f34559b.a) == null) {
                    return;
                }
                onClickListener.onClick(this.a);
                if (this.f34559b.f34558b.j != 1) {
                    if (this.f34559b.f34558b.j == 2) {
                        TiebaStatic.log(new StatisticItem("C12603").param("obj_param1", this.f34559b.f34558b.i));
                    }
                } else {
                    TiebaStatic.log(new StatisticItem("c12773").param("obj_param1", this.f34559b.f34558b.i));
                }
                g.b(this.f34559b.f34558b.f34557h, this.f34559b.f34558b.f34556g);
            }
        }

        /* loaded from: classes5.dex */
        public class b implements l.c {
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

            @Override // c.a.o0.r.t.l.c
            public void onClick() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.f34558b.f34557h == null) {
                    return;
                }
                g.b(this.a.f34558b.f34557h, this.a.f34558b.f34556g);
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
            this.f34558b = myFansUserLikeButton;
            this.a = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f34558b.j != 1) {
                    if (this.f34558b.j == 2) {
                        TiebaStatic.log(new StatisticItem("c12605").param("obj_locate", this.f34558b.f30301c ? 3 : 2).param("obj_param1", this.f34558b.i));
                    }
                } else {
                    TiebaStatic.log(new StatisticItem("c12772").param("obj_locate", this.f34558b.f30301c ? "3" : "2").param("obj_param1", this.f34558b.i));
                }
                if (this.f34558b.f30301c) {
                    if (this.f34558b.f34556g != null) {
                        if (this.f34558b.f34557h == null) {
                            l lVar = new l(this.f34558b.f34556g.getContext());
                            lVar.q(this.f34558b.f34556g.getString(R.string.obfuscated_res_0x7f0f0424));
                            ArrayList arrayList = new ArrayList();
                            h hVar = new h(this.f34558b.f34556g.getString(R.string.obfuscated_res_0x7f0f041a), lVar);
                            hVar.m(new C1866a(this, view));
                            arrayList.add(hVar);
                            lVar.m(new b(this));
                            lVar.j(arrayList);
                            this.f34558b.f34557h = new j(this.f34558b.f34556g, lVar);
                            this.f34558b.f34557h.l(0.7f);
                        }
                        g.j(this.f34558b.f34557h, this.f34558b.f34556g);
                        return;
                    }
                    return;
                }
                this.a.onClick(view);
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

    @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton, c.a.o0.r.l0.t.b
    public void b(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, onClickListener) == null) {
            setOnClickListener(new a(this, onClickListener));
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton, c.a.o0.r.l0.t.b
    public void e(boolean z, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            this.f30301c = z;
            if (!z) {
                setTextSize(0, n.f(getContext(), R.dimen.obfuscated_res_0x7f0701f0));
                setText(this.f30300b);
            } else if (i == 1) {
                setTextSize(0, n.f(getContext(), R.dimen.obfuscated_res_0x7f0701f0));
                setText(this.a);
            } else if (i != 2) {
                setTextSize(0, n.f(getContext(), R.dimen.obfuscated_res_0x7f0701f0));
                setText(this.a);
            } else {
                setTextSize(0, n.f(getContext(), R.dimen.obfuscated_res_0x7f0701e8));
                setText(R.string.obfuscated_res_0x7f0f0507);
            }
            g(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton
    public void g(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            if (this.f30301c) {
                SkinManager.setViewTextColor(this, (int) R.color.btn_forum_focus_gray_color);
                SkinManager.setBackgroundResource(this, R.drawable.btn_transparent_gray_border);
                return;
            }
            SkinManager.setViewTextColor(this, (int) R.color.btn_forum_focus_color);
            SkinManager.setBackgroundResource(this, R.drawable.btn_transparent_focus_border_bg);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton
    public void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
        }
    }

    public void setContext(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, fVar) == null) {
            this.f34556g = fVar;
        }
    }

    public void setStatsParams(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048581, this, i, str) == null) {
            this.j = i;
            this.i = str;
        }
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
}
