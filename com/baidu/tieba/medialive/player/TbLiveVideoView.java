package com.baidu.tieba.medialive.player;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.BVideoView;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class TbLiveVideoView extends BVideoView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Uri I;
    public a J;

    /* loaded from: classes5.dex */
    public interface a {
        void onBufferingUpdate(int i2);

        void onCompletion();

        void onError(int i2, int i3);

        void onInfo(int i2, int i3);

        void onPrepared();

        void onSeekComplete();

        void onVideoSizeChanged(int i2, int i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TbLiveVideoView(Context context, AttributeSet attributeSet) {
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
        g();
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            setOption(CyberPlayerManager.OPT_IS_LIVE_VIDEO, "true");
            HashMap hashMap = new HashMap();
            hashMap.put(CyberPlayerManager.STAGE_INFO_TYPE, "live");
            hashMap.put(CyberPlayerManager.STAGE_INFO_TITLE, "tieba");
            setExternalInfo(CyberPlayerManager.STR_STAGE_INFO, hashMap);
        }
    }

    public Uri getVideoURI() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.I : (Uri) invokeV.objValue;
    }

    @Override // com.baidu.cyberplayer.sdk.BVideoView, com.baidu.cyberplayer.sdk.CyberPlayerManager.OnBufferingUpdateListener
    public void onBufferingUpdate(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            super.onBufferingUpdate(i2);
            a aVar = this.J;
            if (aVar != null) {
                aVar.onBufferingUpdate(i2);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.BVideoView, com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
    public void onCompletion() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onCompletion();
            a aVar = this.J;
            if (aVar != null) {
                aVar.onCompletion();
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.BVideoView, com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
    public boolean onError(int i2, int i3, Object obj) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048580, this, i2, i3, obj)) == null) {
            a aVar = this.J;
            if (aVar != null) {
                aVar.onError(i2, i3);
            }
            return super.onError(i2, i3, obj);
        }
        return invokeIIL.booleanValue;
    }

    @Override // com.baidu.cyberplayer.sdk.BVideoView, com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
    public boolean onInfo(int i2, int i3, Object obj) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048581, this, i2, i3, obj)) == null) {
            a aVar = this.J;
            if (aVar != null) {
                aVar.onInfo(i2, i3);
            }
            return super.onInfo(i2, i3, obj);
        }
        return invokeIIL.booleanValue;
    }

    @Override // com.baidu.cyberplayer.sdk.BVideoView, com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
    public void onPrepared() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onPrepared();
            a aVar = this.J;
            if (aVar != null) {
                aVar.onPrepared();
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.BVideoView, com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
    public void onSeekComplete() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onSeekComplete();
            a aVar = this.J;
            if (aVar != null) {
                aVar.onSeekComplete();
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.BVideoView, com.baidu.cyberplayer.sdk.CyberPlayerManager.OnVideoSizeChangedListener
    public void onVideoSizeChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3, i4, i5) == null) {
            super.onVideoSizeChanged(i2, i3, i4, i5);
            a aVar = this.J;
            if (aVar != null) {
                aVar.onVideoSizeChanged(i2, i3);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.BVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.pause();
        }
    }

    public void setPlayerCallback(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, aVar) == null) {
            this.J = aVar;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.BVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setVideoURI(Uri uri) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, uri) == null) {
            super.setVideoURI(uri);
            this.I = uri;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.BVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.start();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TbLiveVideoView(Context context) {
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
        g();
    }

    @Override // com.baidu.cyberplayer.sdk.BVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setVideoURI(Uri uri, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, uri, map) == null) {
            super.setVideoURI(uri, map);
            this.I = uri;
        }
    }
}
