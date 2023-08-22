package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.searchbox.live.interfaces.player.DuMediaConstants;
import com.baidu.searchbox.live.interfaces.player.DuMediaView;
import com.baidu.searchbox.live.interfaces.player.IDuMediaPnPController;
import com.baidu.searchbox.live.interfaces.player.LiveDlnaSearchListener;
import com.baidu.searchbox.live.interfaces.service.player.IDuMediaService;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.util.MimeTypes;
/* loaded from: classes8.dex */
public class y69 implements IDuMediaService {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.searchbox.live.interfaces.service.player.IDuMediaService
    public void dlnaRefresh(@NonNull LiveDlnaSearchListener liveDlnaSearchListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, liveDlnaSearchListener) == null) {
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.service.player.IDuMediaService
    public void dlnaStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.service.player.IDuMediaService
    @Nullable
    public IDuMediaPnPController getCtrlPoint(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            return null;
        }
        return (IDuMediaPnPController) invokeL.objValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.service.player.IDuMediaService
    @Nullable
    public DuMediaView getDuMediaView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return null;
        }
        return (DuMediaView) invokeV.objValue;
    }

    public y69() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.service.player.IDuMediaService
    @Nullable
    public Integer getDevicePlayQualityScore(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048579, this, i, i2)) == null) {
            return Integer.valueOf(CyberPlayerManager.getDevicePlayQualityScore(MimeTypes.VIDEO_H265, 0, i, i2, null));
        }
        return (Integer) invokeII.objValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.service.player.IDuMediaService
    @Nullable
    public Integer getMediaIntConstant(@Nullable DuMediaConstants.Key key) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, key)) == null) {
            if (key == DuMediaConstants.Key.VIDEO_SCALING_MODE_SCALE_TO_FILL_WITH_CROPPING) {
                return 0;
            }
            if (key == DuMediaConstants.Key.VIDEO_SCALING_MODE_SCALE_TO_FIT_WITH_CROPPING) {
                return 2;
            }
            if (key == DuMediaConstants.Key.INSTALL_TYPE_CYBER_MEDIA) {
                return 1;
            }
            if (key == DuMediaConstants.Key.SEEK_PREVIOUS_SYNC) {
                return 0;
            }
            if (key == DuMediaConstants.Key.SEEK_CLOSEST) {
                return 3;
            }
            if (key == DuMediaConstants.Key.MEDIA_INFO_RESTART_PLAYED) {
                return 956;
            }
            if (key == DuMediaConstants.Key.MEDIA_INFO_FIRST_DISP_INTERVAL) {
                return 904;
            }
            if (key == DuMediaConstants.Key.MEDIA_INFO_BUFFERING_START) {
                return 701;
            }
            if (key == DuMediaConstants.Key.MEDIA_INFO_BUFFERING_END) {
                return 702;
            }
            if (key == DuMediaConstants.Key.DLNA_PLAY_STATUS) {
                return 0;
            }
            if (key == DuMediaConstants.Key.DLNA_PLAY_SUB_STATUS_UNKNOW) {
                return -1;
            }
            if (key == DuMediaConstants.Key.DLNA_PLAY_SUB_STATUS_IDLE) {
                return 0;
            }
            if (key == DuMediaConstants.Key.DLNA_PLAY_SUB_STATUS_PLAYING) {
                return 1;
            }
            if (key == DuMediaConstants.Key.DLNA_PLAY_SUB_STATUS_PAUSED) {
                return 2;
            }
            if (key == DuMediaConstants.Key.DLNA_PLAY_SUB_STATUS_PREPARED) {
                return 3;
            }
            if (key == DuMediaConstants.Key.DLNA_PLAY_SUB_STATUS_COMPLETE) {
                return 4;
            }
            if (key != DuMediaConstants.Key.DLNA_PLAY_SUB_STATUS_CONNECTED) {
                return 0;
            }
            return 5;
        }
        return (Integer) invokeL.objValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.service.player.IDuMediaService
    @Nullable
    public Boolean isCoreLoaded(@Nullable Integer num) {
        InterceptResult invokeL;
        int intValue;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, num)) == null) {
            if (num == null) {
                intValue = 1;
            } else {
                intValue = num.intValue();
            }
            return Boolean.valueOf(CyberPlayerManager.isCoreLoaded(intValue));
        }
        return (Boolean) invokeL.objValue;
    }
}
