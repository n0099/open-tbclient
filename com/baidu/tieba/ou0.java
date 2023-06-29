package com.baidu.tieba;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.player.strategy.IVideoUpdateStrategy;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideoAd;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideoSeries;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class ou0 implements mu0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final fu0 b;
    public ju0 c;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public class b implements kv0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ou0 a;

        public b(ou0 ou0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ou0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ou0Var;
        }

        @Override // com.baidu.tieba.kv0
        public void a(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(1048576, this, i) == null) && this.a.c != null) {
                this.a.c.a(i);
            }
        }

        @Override // com.baidu.tieba.kv0
        public void onEnd(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(1048579, this, i) == null) && this.a.c != null) {
                this.a.c.onEnd(i);
            }
        }

        public /* synthetic */ b(ou0 ou0Var, a aVar) {
            this(ou0Var);
        }

        @Override // com.baidu.tieba.kv0
        public void onInfo(int i, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeII(1048581, this, i, i2) == null) && this.a.c != null) {
                this.a.c.onInfo(i, i2);
            }
        }

        @Override // com.baidu.tieba.kv0
        public void onVideoSizeChanged(int i, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeII(1048588, this, i, i2) == null) && this.a.c != null) {
                this.a.c.onVideoSizeChanged(i, i2);
            }
        }

        @Override // com.baidu.tieba.kv0
        public void onBufferEnd() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.a.c != null) {
                this.a.c.onBufferEnd();
            }
        }

        @Override // com.baidu.tieba.kv0
        public void onBufferStart() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.a.c != null) {
                this.a.c.onBufferStart();
            }
        }

        @Override // com.baidu.tieba.kv0
        public void onPause() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && this.a.c != null) {
                this.a.c.onPause();
            }
        }

        @Override // com.baidu.tieba.kv0
        public void onPrepared() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && this.a.c != null) {
                this.a.c.onPrepared();
            }
        }

        @Override // com.baidu.tieba.kv0
        public void onResume() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && this.a.c != null) {
                this.a.c.onResume();
            }
        }

        @Override // com.baidu.tieba.kv0
        public void onSeekEnd() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && this.a.c != null) {
                this.a.c.onSeekEnd();
            }
        }

        @Override // com.baidu.tieba.kv0
        public void onStart() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && this.a.c != null) {
                this.a.c.onStart();
            }
        }

        @Override // com.baidu.tieba.kv0
        public void onError(int i, int i2, String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeIIL(1048580, this, i, i2, str) == null) && this.a.c != null) {
                this.a.c.onError(i, i2, str);
            }
        }

        @Override // com.baidu.tieba.kv0
        public void onUpdateProgress(int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeIII(1048587, this, i, i2, i3) == null) && this.a.c != null) {
                this.a.c.onUpdateProgress(i, i2, i3);
            }
        }
    }

    public ou0(fu0 fu0Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fu0Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = fu0Var;
        fu0Var.y0(new b(this, null));
    }

    @Override // com.baidu.tieba.mu0
    public void a(ju0 ju0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ju0Var) == null) {
            this.c = ju0Var;
        }
    }

    @Override // com.baidu.tieba.mu0
    public void attachToContainer(@NonNull ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup) == null) {
            this.b.f(viewGroup);
        }
    }

    @Override // com.baidu.tieba.mu0
    public void d(@NonNull IVideoUpdateStrategy iVideoUpdateStrategy) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, iVideoUpdateStrategy) == null) {
            this.b.z1(iVideoUpdateStrategy);
        }
    }

    public final BdVideoAd f(ds0 ds0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, ds0Var)) == null) {
            if (ds0Var == null) {
                return null;
            }
            BdVideoAd.b bVar = new BdVideoAd.b();
            bVar.b(ds0Var);
            bVar.c(true);
            return bVar.a();
        }
        return (BdVideoAd) invokeL.objValue;
    }

    @Override // com.baidu.tieba.ku0
    public void mute(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.b.c0(z);
        }
    }

    @Override // com.baidu.tieba.ku0
    public void setLooping(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.b.v0(z);
        }
    }

    @Override // com.baidu.tieba.ku0
    public void setVideoScalingMode(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            this.b.B0(i);
        }
    }

    @Override // com.baidu.tieba.iu0
    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.b.D();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.iu0
    public boolean isPause() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.b.W();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.iu0
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.b.Y();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ku0
    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.b.e0();
        }
    }

    @Override // com.baidu.tieba.mu0
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.b.g0();
        }
    }

    @Override // com.baidu.tieba.ku0
    public void resume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.b.l0();
        }
    }

    @Override // com.baidu.tieba.ku0
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.b.K0();
        }
    }

    @Override // com.baidu.tieba.ku0
    public void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.b.L0();
        }
    }

    @Override // com.baidu.tieba.mu0
    public void c(@NonNull bs0 bs0Var) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bs0Var) == null) {
            BdVideoSeries c = p71.c(bs0Var.j);
            IVideoUpdateStrategy n1 = this.b.n1();
            if (c != null) {
                c.setVideoAd(f(bs0Var.i));
                if (n1.h()) {
                    i = 0;
                } else {
                    i = -1;
                }
                c.setStartPosition(i);
                c.setPlayLoop(n1.e());
                this.b.A1(c);
            } else if (!du0.f()) {
            } else {
                throw new IllegalArgumentException("Invalid video info");
            }
        }
    }
}
