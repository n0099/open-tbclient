package com.baidu.tieba;

import android.app.Activity;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.view.progressball.ProgressBall;
import com.baidu.tieba.xl6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class zk6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int a;
    public final int b;
    public final List<String> c;
    public ProgressBall d;
    public xl6 e;
    public al6 f;
    public View.OnClickListener g;
    public View.OnClickListener h;

    /* loaded from: classes7.dex */
    public static final class a implements sj9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zk6 a;

        public a(zk6 zk6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zk6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zk6Var;
        }

        @Override // com.baidu.tieba.sj9
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                zk6 zk6Var = this.a;
                zk6Var.i(zk6Var.a());
            }
        }
    }

    public zk6(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.a = 2;
        this.b = 2;
        this.c = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"LogoActivity", "ImageViewerActivity", "InterestGuideActivity", "TBWebViewActivity", "NewWriteActivity", "NewSquareSearchActivity", "VideoPlayActivity", "FrsVideoTabPlayActivity", "VideoRecommentPlayActivity", "AlbumFloatActivity", "SelectForumActivity", "NewSubPbActivity", "PbCommentFloatActivity", "TbFileVideoActivity", "TbEditVideoActivity", "WorkPublishActivity", "SelectClassDialogActivity", "SelectTagActivity", "PbFullScreenEditorActivity", "GiftTabActivity", "AtListActivity", "TBWebContainerActivity"});
        this.f = new al6();
        ProgressBall progressBall = new ProgressBall(TbadkCoreApplication.getInst().getContext());
        this.d = progressBall;
        xl6.e eVar = new xl6.e(activity, progressBall);
        eVar.b(this.c);
        xl6 a2 = eVar.a();
        this.e = a2;
        a2.k(new a(this));
    }

    public final al6 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.f;
        }
        return (al6) invokeV.objValue;
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.e.f();
        }
    }

    public final boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.e.g();
        }
        return invokeV.booleanValue;
    }

    public final boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.e.h();
        }
        return invokeV.booleanValue;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0037: INVOKE  (r4v1 int A[REMOVE]) = (r0v2 com.baidu.tieba.uj9) type: VIRTUAL call: com.baidu.tieba.uj9.e():int), ('%' char)] */
    public final uj9 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            uj9 uj9Var = new uj9();
            String c = this.f.c();
            if (c == null) {
                c = "";
            }
            uj9Var.h(c);
            uj9Var.j(R.drawable.progress_ball_dynamic);
            uj9Var.l(Math.min(Math.max(this.f.f(), 0), 100));
            StringBuilder sb = new StringBuilder();
            sb.append(uj9Var.e());
            sb.append('%');
            uj9Var.m(new SpannableString(sb.toString()));
            uj9Var.f().setSpan(new AbsoluteSizeSpan(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.T_X06)), 0, uj9Var.f().length() - 1, 17);
            return uj9Var;
        }
        return (uj9) invokeV.objValue;
    }

    public final uj9 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            uj9 uj9Var = new uj9();
            String c = this.f.c();
            if (c == null) {
                c = "";
            }
            uj9Var.h(c);
            uj9Var.i(R.color.CAM_X0302);
            uj9Var.l(100);
            uj9Var.m(new SpannableString(this.f.b()));
            return uj9Var;
        }
        return (uj9) invokeV.objValue;
    }

    public final uj9 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            uj9 uj9Var = new uj9();
            String c = this.f.c();
            if (c == null) {
                c = "";
            }
            uj9Var.h(c);
            uj9Var.i(R.color.CAM_X0305);
            uj9Var.l(Math.min(Math.max(this.f.f(), 0), 100));
            uj9Var.m(new SpannableString(this.f.b()));
            return uj9Var;
        }
        return (uj9) invokeV.objValue;
    }

    public final uj9 e() {
        InterceptResult invokeV;
        uj9 c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f.a() == 7) {
                c = d();
            } else if (this.f.a() == 1) {
                c = b();
            } else {
                c = c();
            }
            if (!g() && !TextUtils.isEmpty(this.f.g())) {
                c.m(new SpannableString(this.f.g()));
                c.n(this.b);
                c.k(this.a);
            }
            return c;
        }
        return (uj9) invokeV.objValue;
    }

    public final void i(al6 data) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, data) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            this.f = data;
            this.d.b(e());
        }
    }

    public final void j(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, onClickListener) == null) {
            this.g = onClickListener;
            this.e.j(onClickListener);
        }
    }

    public final void k(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, onClickListener) == null) {
            this.h = onClickListener;
            this.e.l(onClickListener);
        }
    }

    public final void l(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048587, this, z) != null) || h()) {
            return;
        }
        this.e.n();
        m(TbadkCoreStatisticKey.DOWNLOAD_FLOAT_BALL_SHOW, false, z);
    }

    public final void m(String key, boolean z, boolean z2) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{key, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            Intrinsics.checkNotNullParameter(key, "key");
            StatisticItem statisticItem = new StatisticItem(key);
            statisticItem.param("obj_source", this.f.d());
            int i2 = 2;
            if (dw8.i(this.f.e())) {
                i = 4;
            } else {
                if (!z2) {
                    int a2 = this.f.a();
                    if (a2 != 0) {
                        if (a2 != 1) {
                            if (a2 != 3) {
                                if (a2 != 7) {
                                    i = 5;
                                } else {
                                    i = 2;
                                }
                            }
                        }
                    }
                    i = 3;
                }
                i = 1;
            }
            statisticItem.param("obj_param1", i);
            if (z) {
                i2 = 3;
            } else if (g()) {
                i2 = 1;
            }
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, i2);
            TiebaStatic.log(statisticItem);
        }
    }
}
