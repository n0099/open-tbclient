package com.baidu.tieba;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.card.ala.AlaVideoContainer;
import com.baidu.tieba.h79;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class zg6 implements e79 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AlaVideoContainer a;
    public ThreadData b;
    public AlaInfoData c;
    public boolean d;
    public h79 e;
    public h79.b f;

    @Override // com.baidu.tieba.e79
    public boolean isFullScreen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.e79
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.e79
    public void startPlay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
        }
    }

    /* loaded from: classes7.dex */
    public class a implements h79.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zg6 a;

        public a(zg6 zg6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zg6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zg6Var;
        }

        @Override // com.baidu.tieba.h79.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.b();
            }
        }
    }

    public zg6(AlaVideoContainer alaVideoContainer) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {alaVideoContainer};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = false;
        this.f = new a(this);
        this.a = alaVideoContainer;
        if (alaVideoContainer != null) {
            h79 h79Var = new h79();
            this.e = h79Var;
            h79Var.l(this.a.getVideoView());
            this.e.i(this.f);
        }
    }

    public final void b() {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || (threadData = this.b) == null || threadData.getThreadVideoInfo() == null) {
        }
    }

    public void c() {
        AlaVideoContainer alaVideoContainer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (alaVideoContainer = this.a) != null) {
            alaVideoContainer.q();
        }
    }

    @Override // com.baidu.tieba.e79
    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            AlaVideoContainer alaVideoContainer = this.a;
            if (alaVideoContainer != null && alaVideoContainer.getVideoView() != null) {
                return this.a.getVideoView().getCurrentPositionSync();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.e79
    public String getPlayUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            ThreadData threadData = this.b;
            if (threadData != null && threadData.getThreadVideoInfo() != null) {
                return this.b.getThreadVideoInfo().video_url;
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.e79
    public View getVideoContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            AlaVideoContainer alaVideoContainer = this.a;
            if (alaVideoContainer != null) {
                return alaVideoContainer.getView();
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.e79
    public boolean isPlayStarted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.d;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.e79
    public void stopPlay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            AlaVideoContainer alaVideoContainer = this.a;
            if (alaVideoContainer != null && alaVideoContainer.getVideoView() != null) {
                this.a.getVideoView().stopPlayback();
                this.a.p();
                h79 h79Var = this.e;
                if (h79Var != null) {
                    h79Var.n();
                }
            }
            this.d = false;
        }
    }

    public void d(ThreadData threadData, String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{threadData, str, str2, Boolean.valueOf(z)}) != null) || threadData == null) {
            return;
        }
        this.b = threadData;
        if (this.a != null && threadData.getThreadAlaInfo() != null) {
            AlaInfoData threadAlaInfo = this.b.getThreadAlaInfo();
            this.c = threadAlaInfo;
            this.a.setVideoThumbnail(threadAlaInfo.cover);
            if (z) {
                this.a.setTitle(this.b.getTitle());
            } else {
                this.a.setTitle("");
            }
            this.a.setPlayCount(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.ala_audience_count_prefix), StringHelper.numFormatOverWan(this.b.getThreadAlaInfo().audience_count)));
        }
    }
}
