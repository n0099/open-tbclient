package com.baidu.tieba;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.videoPreload.IVideoNeedPreload;
import com.baidu.tieba.k37;
import com.baidu.tieba.tbadkCore.data.WorksInfoData;
import com.baidu.tieba.zt9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import tbclient.VideoInfo;
/* loaded from: classes8.dex */
public final class up6 implements k37.q {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final a58 a;
    public final ViewGroup b;
    public String c;

    /* loaded from: classes8.dex */
    public static final class a implements c57 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ up6 a;

        public a(up6 up6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {up6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = up6Var;
        }

        @Override // com.baidu.tieba.c57
        public Rect a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                Rect rect = new Rect();
                this.a.b.getGlobalVisibleRect(rect);
                return rect;
            }
            return (Rect) invokeV.objValue;
        }
    }

    public up6(Context context, ViewGroup rootView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, rootView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        this.a = new a58(context, rootView);
        this.b = rootView;
        this.c = "";
    }

    public static final void c(up6 this$0, x47 state) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, this$0, state) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(state, "$state");
            Rect rect = new Rect();
            this$0.b.getGlobalVisibleRect(rect);
            Function3<Context, Rect, h77, Unit> i = state.i();
            Context context = this$0.b.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "rootView.context");
            i.invoke(context, rect, state.j());
            for (d77 d77Var : state.k()) {
                ba7.a.b(d77Var, state.g() + 1);
                state.f().invoke(d77Var);
            }
        }
    }

    @Override // com.baidu.tieba.k37.q
    public void onBackground(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.a.onBackground(z);
        }
    }

    @Override // com.baidu.tieba.k37.q
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a.c();
        }
    }

    @Override // com.baidu.tieba.ct9
    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.a.getCurrentPosition();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.ct9
    public String getPlayUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.c;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ct9
    public View getVideoContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.b;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ct9
    public boolean isFullScreen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.a.isFullScreen();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ct9
    public boolean isPlayStarted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.a.isPlaying();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ct9
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.a.isPlaying();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.k37.q
    public void onVolumeUp() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.a.onVolumeUp();
        }
    }

    @Override // com.baidu.tieba.ct9
    public void stopPlay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.a.stopPlay();
        }
    }

    @Override // com.baidu.tieba.ct9
    public void startPlay() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (this.b.getContext() instanceof IVideoNeedPreload)) {
            Context context = this.b.getContext();
            if (context != null) {
                if (((IVideoNeedPreload) context).videoNeedPreload()) {
                    this.a.startPlay();
                    return;
                }
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.baidu.tbadk.core.util.videoPreload.IVideoNeedPreload");
        }
    }

    @Override // com.baidu.tieba.k37.q
    public void update(final x47 state) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, state) == null) {
            Intrinsics.checkNotNullParameter(state, "state");
            g77 l = state.l();
            String str = l.e;
            String str2 = "";
            if (str == null) {
                str = "";
            }
            this.c = str;
            ThreadData threadData = new ThreadData();
            VideoInfo.Builder builder = new VideoInfo.Builder();
            builder.video_md5 = "";
            builder.video_url = l.e;
            builder.video_duration = Integer.valueOf(l.f);
            builder.video_width = Integer.valueOf(l.b);
            builder.video_height = Integer.valueOf(l.c);
            String str3 = l.a;
            builder.first_frame_thumbnail = str3;
            builder.thumbnail_url = str3;
            builder.video_length = Integer.valueOf(l.g);
            builder.play_count = Integer.valueOf(l.h);
            if (l.d) {
                i = 1;
            } else {
                i = 0;
            }
            builder.is_vertical = i;
            builder.mcn_ad_card = null;
            threadData.setVideoInfo(builder.build(false));
            threadData.videoBottomPlaceInfo = state.h();
            Map<String, String> map = l.i;
            String str4 = "1";
            if (map != null) {
                threadData.setFid(JavaTypesHelper.toLong(map.get("forum_id"), 0L));
                threadData.tid = map.get("thread_id");
                if (Intrinsics.areEqual(map.get("is_video_work"), "1")) {
                    WorksInfoData worksInfoData = new WorksInfoData();
                    worksInfoData.isWorks = true;
                    threadData.worksInfoData = worksInfoData;
                }
            }
            this.a.setData(threadData);
            tt9 tt9Var = new tt9();
            Map<String, String> map2 = l.i;
            if (map2 != null) {
                if (Intrinsics.areEqual(map2.get("page_from"), "recommend")) {
                    tt9Var.a = "1";
                }
                tt9Var.c = map2.get("thread_id");
                tt9Var.d = map2.get("forum_id");
                tt9Var.v = map2.get("nid");
                tt9Var.m = "";
                if (!l.d) {
                    str4 = "0";
                }
                tt9Var.p = str4;
                String str5 = map2.get("extra");
                if (str5 == null) {
                    str5 = "";
                }
                tt9Var.k = str5;
                String str6 = map2.get("source");
                if (str6 == null) {
                    str6 = "";
                }
                tt9Var.f = str6;
                String str7 = map2.get("abtest_tag");
                if (str7 == null) {
                    str7 = "";
                }
                tt9Var.l = str7;
                String str8 = map2.get("weight");
                if (str8 != null) {
                    str2 = str8;
                }
                tt9Var.h = str2;
                tt9Var.e = TbadkCoreApplication.getCurrentAccount();
                tt9Var.q = String.valueOf(state.g() + 1);
            }
            this.a.setStatistic(tt9Var);
            state.n(new a(this));
            this.a.d(new zt9.a() { // from class: com.baidu.tieba.po6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.zt9.a
                public final void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        up6.c(up6.this, state);
                    }
                }
            });
        }
    }
}
