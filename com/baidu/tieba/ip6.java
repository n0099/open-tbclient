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
import com.baidu.tieba.j37;
import com.baidu.tieba.mea;
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
/* loaded from: classes6.dex */
public final class ip6 implements j37.r {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final si8 a;
    public final ViewGroup b;
    public String c;

    /* loaded from: classes6.dex */
    public static final class a implements g57 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ip6 a;

        public a(ip6 ip6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ip6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ip6Var;
        }

        @Override // com.baidu.tieba.g57
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

    public ip6(Context context, ViewGroup rootView) {
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
        this.a = new si8(context, rootView);
        this.b = rootView;
        this.c = "";
    }

    public static final void b(ip6 this$0, b57 state) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, this$0, state) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(state, "$state");
            Rect rect = new Rect();
            this$0.b.getGlobalVisibleRect(rect);
            Function3<Context, Rect, b57, Unit> m = state.m();
            Context context = this$0.b.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "rootView.context");
            m.invoke(context, rect, state);
            for (e87 e87Var : state.o()) {
                ac7.a.f(e87Var, state.k() + 1);
                state.j().invoke(e87Var);
            }
        }
    }

    @Override // com.baidu.tieba.j37.r
    public void onBackground(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.a.onBackground(z);
        }
    }

    @Override // com.baidu.tieba.pda
    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a.getCurrentPosition();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.pda
    public String getPlayUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.c;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.pda
    public View getVideoContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.b;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.pda
    public boolean isFullScreen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.a.isFullScreen();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.pda
    public boolean isPlayStarted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.a.isPlaying();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.pda
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.a.isPlaying();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.j37.r
    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.a.c();
        }
    }

    @Override // com.baidu.tieba.j37.r
    public void onVolumeUp() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.a.onVolumeUp();
        }
    }

    @Override // com.baidu.tieba.pda
    public void stopPlay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.a.stopPlay();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x00d5, code lost:
        if (r8.equals("6") == false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00de, code lost:
        if (r8.equals("5") == false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00f5, code lost:
        if (r8.equals("3") == false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00fc, code lost:
        if (r8.equals("2") == false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00ff, code lost:
        r1.a = "2";
     */
    @Override // com.baidu.tieba.j37.r
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void j(final b57 state) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, state) == null) {
            Intrinsics.checkNotNullParameter(state, "state");
            l87 p = state.p();
            String str = p.e;
            String str2 = "";
            if (str == null) {
                str = "";
            }
            this.c = str;
            ThreadData threadData = new ThreadData();
            VideoInfo.Builder builder = new VideoInfo.Builder();
            builder.video_md5 = p.i;
            builder.video_url = p.e;
            builder.video_duration = Integer.valueOf(p.f);
            builder.video_width = Integer.valueOf(p.b);
            builder.video_height = Integer.valueOf(p.c);
            String str3 = p.a;
            builder.first_frame_thumbnail = str3;
            builder.thumbnail_url = str3;
            builder.video_length = Integer.valueOf(p.g);
            builder.play_count = Integer.valueOf(p.h);
            if (p.d) {
                i = 1;
            } else {
                i = 0;
            }
            builder.is_vertical = i;
            builder.mcn_ad_card = null;
            threadData.setVideoInfo(builder.build(false));
            threadData.videoBottomPlaceInfo = state.l();
            Map<String, String> map = p.j;
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
            gea geaVar = new gea();
            Map<String, String> map2 = p.j;
            if (map2 != null) {
                String str5 = map2.get("feed_social_source");
                if (str5 != null) {
                    switch (str5.hashCode()) {
                        case 49:
                            if (str5.equals("1")) {
                                geaVar.a = "1";
                                break;
                            }
                            break;
                        case 52:
                            if (str5.equals("4")) {
                                geaVar.a = "25";
                                break;
                            }
                            break;
                    }
                }
                geaVar.c = map2.get("thread_id");
                geaVar.d = map2.get("forum_id");
                geaVar.v = map2.get("nid");
                geaVar.m = p.i;
                if (!p.d) {
                    str4 = "0";
                }
                geaVar.p = str4;
                String str6 = map2.get("extra");
                if (str6 == null) {
                    str6 = "";
                }
                geaVar.k = str6;
                String str7 = map2.get("source");
                if (str7 == null) {
                    str7 = "";
                }
                geaVar.f = str7;
                String str8 = map2.get("abtest_tag");
                if (str8 == null) {
                    str8 = "";
                }
                geaVar.l = str8;
                String str9 = map2.get("weight");
                if (str9 != null) {
                    str2 = str9;
                }
                geaVar.h = str2;
                geaVar.e = TbadkCoreApplication.getCurrentAccount();
                geaVar.q = String.valueOf(state.k() + 1);
            }
            this.a.setStatistic(geaVar);
            state.r(new a(this));
            this.a.d(new mea.a() { // from class: com.baidu.tieba.do6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.mea.a
                public final void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        ip6.b(ip6.this, state);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.pda
    public void startPlay() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (this.b.getContext() instanceof IVideoNeedPreload)) {
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
}
