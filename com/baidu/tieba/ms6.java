package com.baidu.tieba;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.videoPreload.IVideoNeedPreload;
import com.baidu.tieba.b67;
import com.baidu.tieba.gv9;
import com.baidu.tieba.tbadkCore.data.WorksInfoData;
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
/* loaded from: classes7.dex */
public final class ms6 implements b67.q {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final g78 a;
    public final ViewGroup b;
    public String c;

    /* loaded from: classes7.dex */
    public static final class a implements t77 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ms6 a;

        public a(ms6 ms6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ms6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ms6Var;
        }

        @Override // com.baidu.tieba.t77
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

    public ms6(Context context, ViewGroup rootView) {
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
        this.a = new g78(context, rootView);
        this.b = rootView;
        this.c = "";
    }

    public static final void c(ms6 this$0, o77 state) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, this$0, state) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(state, "$state");
            Rect rect = new Rect();
            this$0.b.getGlobalVisibleRect(rect);
            Function3<Context, Rect, y97, Unit> i = state.i();
            Context context = this$0.b.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "rootView.context");
            i.invoke(context, rect, state.j());
            for (u97 u97Var : state.k()) {
                sc7.a.b(u97Var, state.g() + 1);
                state.f().invoke(u97Var);
            }
        }
    }

    @Override // com.baidu.tieba.b67.q
    public void onBackground(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.a.onBackground(z);
        }
    }

    @Override // com.baidu.tieba.b67.q
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a.c();
        }
    }

    @Override // com.baidu.tieba.iu9
    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.a.getCurrentPosition();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.iu9
    public String getPlayUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.c;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.iu9
    public View getVideoContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.b;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.iu9
    public boolean isFullScreen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.a.isFullScreen();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.iu9
    public boolean isPlayStarted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.a.isPlaying();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.iu9
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.a.isPlaying();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.b67.q
    public void onVolumeUp() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.a.onVolumeUp();
        }
    }

    @Override // com.baidu.tieba.iu9
    public void stopPlay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.a.stopPlay();
        }
    }

    @Override // com.baidu.tieba.iu9
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

    @Override // com.baidu.tieba.b67.q
    public void update(final o77 state) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, state) == null) {
            Intrinsics.checkNotNullParameter(state, "state");
            x97 l = state.l();
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
                threadData.setFid(wg.g(map.get("forum_id"), 0L));
                threadData.tid = map.get("thread_id");
                if (Intrinsics.areEqual(map.get("is_video_work"), "1")) {
                    WorksInfoData worksInfoData = new WorksInfoData();
                    worksInfoData.isWorks = true;
                    threadData.worksInfoData = worksInfoData;
                }
            }
            this.a.setData(threadData);
            av9 av9Var = new av9();
            Map<String, String> map2 = l.i;
            if (map2 != null) {
                if (Intrinsics.areEqual(map2.get("page_from"), "recommend")) {
                    av9Var.a = "1";
                }
                av9Var.c = map2.get("thread_id");
                av9Var.d = map2.get("forum_id");
                av9Var.v = map2.get("nid");
                av9Var.m = "";
                if (!l.d) {
                    str4 = "0";
                }
                av9Var.p = str4;
                String str5 = map2.get("extra");
                if (str5 == null) {
                    str5 = "";
                }
                av9Var.k = str5;
                String str6 = map2.get("source");
                if (str6 == null) {
                    str6 = "";
                }
                av9Var.f = str6;
                String str7 = map2.get("abtest_tag");
                if (str7 == null) {
                    str7 = "";
                }
                av9Var.l = str7;
                String str8 = map2.get("weight");
                if (str8 != null) {
                    str2 = str8;
                }
                av9Var.h = str2;
                av9Var.e = TbadkCoreApplication.getCurrentAccount();
                av9Var.q = String.valueOf(state.g() + 1);
            }
            this.a.setStatistic(av9Var);
            state.n(new a(this));
            this.a.d(new gv9.a() { // from class: com.baidu.tieba.hr6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.gv9.a
                public final void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        ms6.c(ms6.this, state);
                    }
                }
            });
        }
    }
}
