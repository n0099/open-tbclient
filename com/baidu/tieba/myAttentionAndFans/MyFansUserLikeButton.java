package com.baidu.tieba.myAttentionAndFans;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
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
import d.a.c.a.f;
import d.a.c.e.m.g;
import d.a.r0.r.s.h;
import d.a.r0.r.s.j;
import d.a.r0.r.s.l;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class MyFansUserLikeButton extends CommonUserLikeButton {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public f k;
    public j l;
    public String m;
    public int n;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View.OnClickListener f18666e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ MyFansUserLikeButton f18667f;

        /* renamed from: com.baidu.tieba.myAttentionAndFans.MyFansUserLikeButton$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0216a implements l.d {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ View f18668a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ a f18669b;

            public C0216a(a aVar, View view) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, view};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f18669b = aVar;
                this.f18668a = view;
            }

            @Override // d.a.r0.r.s.l.d
            public void onClick() {
                View.OnClickListener onClickListener;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (onClickListener = this.f18669b.f18666e) == null) {
                    return;
                }
                onClickListener.onClick(this.f18668a);
                if (this.f18669b.f18667f.n != 1) {
                    if (this.f18669b.f18667f.n == 2) {
                        TiebaStatic.log(new StatisticItem("C12603").param("obj_param1", this.f18669b.f18667f.m));
                    }
                } else {
                    TiebaStatic.log(new StatisticItem("c12773").param("obj_param1", this.f18669b.f18667f.m));
                }
                g.b(this.f18669b.f18667f.l, this.f18669b.f18667f.k);
            }
        }

        /* loaded from: classes5.dex */
        public class b implements l.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f18670a;

            public b(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f18670a = aVar;
            }

            @Override // d.a.r0.r.s.l.c
            public void onClick() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f18670a.f18667f.l == null) {
                    return;
                }
                g.b(this.f18670a.f18667f.l, this.f18670a.f18667f.k);
            }
        }

        public a(MyFansUserLikeButton myFansUserLikeButton, View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {myFansUserLikeButton, onClickListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18667f = myFansUserLikeButton;
            this.f18666e = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f18667f.n != 1) {
                    if (this.f18667f.n == 2) {
                        TiebaStatic.log(new StatisticItem("c12605").param("obj_locate", this.f18667f.f12741g ? 3 : 2).param("obj_param1", this.f18667f.m));
                    }
                } else {
                    TiebaStatic.log(new StatisticItem("c12772").param("obj_locate", this.f18667f.f12741g ? "3" : "2").param("obj_param1", this.f18667f.m));
                }
                if (this.f18667f.f12741g) {
                    if (this.f18667f.k != null) {
                        if (this.f18667f.l == null) {
                            l lVar = new l(this.f18667f.k.getContext());
                            lVar.q(this.f18667f.k.getString(R.string.confirm_unlike));
                            ArrayList arrayList = new ArrayList();
                            h hVar = new h(this.f18667f.k.getString(R.string.confirm), lVar);
                            hVar.m(new C0216a(this, view));
                            arrayList.add(hVar);
                            lVar.m(new b(this));
                            lVar.k(arrayList);
                            this.f18667f.l = new j(this.f18667f.k, lVar);
                            this.f18667f.l.k(0.7f);
                        }
                        g.j(this.f18667f.l, this.f18667f.k);
                        return;
                    }
                    return;
                }
                this.f18666e.onClick(view);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = 1;
    }

    @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton, d.a.r0.r.f0.s.b
    public void b(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, onClickListener) == null) {
            setOnClickListener(new a(this, onClickListener));
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton, d.a.r0.r.f0.s.b
    public void e(boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            this.f12741g = z;
            if (!z) {
                setTextSize(0, d.a.c.e.p.l.g(getContext(), R.dimen.ds26));
                setText(this.f12740f);
            } else if (i2 == 1) {
                setTextSize(0, d.a.c.e.p.l.g(getContext(), R.dimen.ds26));
                setText(this.f12739e);
            } else if (i2 != 2) {
                setTextSize(0, d.a.c.e.p.l.g(getContext(), R.dimen.ds26));
                setText(this.f12739e);
            } else {
                setTextSize(0, d.a.c.e.p.l.g(getContext(), R.dimen.ds24));
                setText(R.string.each_concerned);
            }
            g(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton
    public void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            if (this.f12741g) {
                SkinManager.setViewTextColor(this, R.color.btn_forum_focus_gray_color);
                SkinManager.setBackgroundResource(this, R.drawable.btn_transparent_gray_border);
                return;
            }
            SkinManager.setViewTextColor(this, R.color.btn_forum_focus_color);
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
            this.k = fVar;
        }
    }

    public void setStatsParams(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048581, this, i2, str) == null) {
            this.n = i2;
            this.m = str;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.n = 1;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MyFansUserLikeButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.n = 1;
    }
}
