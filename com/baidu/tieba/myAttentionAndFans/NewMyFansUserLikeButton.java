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
import d.a.c.a.f;
import d.a.c.e.m.g;
import d.a.r0.r.s.h;
import d.a.r0.r.s.j;
import d.a.r0.r.s.l;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class NewMyFansUserLikeButton extends FollowUserButton {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public boolean B;
    public b C;
    public String v;
    public String w;
    public f x;
    public j y;
    public String z;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View.OnClickListener f18671e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ NewMyFansUserLikeButton f18672f;

        /* renamed from: com.baidu.tieba.myAttentionAndFans.NewMyFansUserLikeButton$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0217a implements l.d {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ View f18673a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ a f18674b;

            public C0217a(a aVar, View view) {
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
                this.f18674b = aVar;
                this.f18673a = view;
            }

            @Override // d.a.r0.r.s.l.d
            public void onClick() {
                View.OnClickListener onClickListener;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (onClickListener = this.f18674b.f18671e) == null) {
                    return;
                }
                onClickListener.onClick(this.f18673a);
                if (this.f18674b.f18672f.A != 1) {
                    if (this.f18674b.f18672f.A == 2) {
                        TiebaStatic.log(new StatisticItem("C12603").param("obj_param1", this.f18674b.f18672f.z));
                    }
                } else {
                    TiebaStatic.log(new StatisticItem("c12773").param("obj_param1", this.f18674b.f18672f.z));
                }
                g.b(this.f18674b.f18672f.y, this.f18674b.f18672f.x);
            }
        }

        /* loaded from: classes5.dex */
        public class b implements l.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f18675a;

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
                this.f18675a = aVar;
            }

            @Override // d.a.r0.r.s.l.c
            public void onClick() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f18675a.f18672f.y == null) {
                    return;
                }
                g.b(this.f18675a.f18672f.y, this.f18675a.f18672f.x);
            }
        }

        public a(NewMyFansUserLikeButton newMyFansUserLikeButton, View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newMyFansUserLikeButton, onClickListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18672f = newMyFansUserLikeButton;
            this.f18671e = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f18672f.A != 1) {
                    if (this.f18672f.A == 2) {
                        TiebaStatic.log(new StatisticItem("c12605").param("obj_locate", this.f18672f.B ? 3 : 2).param("obj_param1", this.f18672f.z));
                    }
                } else {
                    TiebaStatic.log(new StatisticItem("c12772").param("obj_locate", this.f18672f.B ? "3" : "2").param("obj_param1", this.f18672f.z));
                }
                if (this.f18672f.B) {
                    if (this.f18672f.x != null) {
                        if (this.f18672f.y == null) {
                            l lVar = new l(this.f18672f.x.getContext());
                            lVar.q(this.f18672f.x.getString(R.string.confirm_unlike));
                            ArrayList arrayList = new ArrayList();
                            h hVar = new h(this.f18672f.x.getString(R.string.confirm), lVar);
                            hVar.m(new C0217a(this, view));
                            arrayList.add(hVar);
                            lVar.m(new b(this));
                            lVar.k(arrayList);
                            this.f18672f.y = new j(this.f18672f.x, lVar);
                            this.f18672f.y.k(0.7f);
                        }
                        g.j(this.f18672f.y, this.f18672f.x);
                    }
                } else {
                    this.f18671e.onClick(view);
                }
                if (this.f18672f.C != null) {
                    this.f18672f.C.callback();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void callback();
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.v = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.w = TbadkCoreApplication.getInst().getString(R.string.attention);
        this.A = 1;
        this.B = false;
    }

    @Override // com.baidu.tbadk.core.view.FollowUserButton, d.a.r0.r.f0.s.b
    public void b(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, onClickListener) == null) {
            setOnClickListener(new a(this, onClickListener));
        }
    }

    @Override // com.baidu.tbadk.core.view.FollowUserButton, d.a.r0.r.f0.s.b
    public void e(boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            super.e(z, i2);
            this.B = z;
            if (!z) {
                setText(this.w);
            } else if (i2 == 1) {
                setText(this.v);
            } else if (i2 != 2) {
                setText(this.v);
            } else {
                setText(this.x.getString(R.string.each_concerned));
            }
            r(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void setCallback(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.C = bVar;
        }
    }

    public void setContext(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fVar) == null) {
            this.x = fVar;
        }
    }

    public void setStatsParams(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048580, this, i2, str) == null) {
            this.A = i2;
            this.z = str;
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
        this.v = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.w = TbadkCoreApplication.getInst().getString(R.string.attention);
        this.A = 1;
        this.B = false;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewMyFansUserLikeButton(Context context, @Nullable AttributeSet attributeSet, int i2) {
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
        this.v = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.w = TbadkCoreApplication.getInst().getString(R.string.attention);
        this.A = 1;
        this.B = false;
    }
}
