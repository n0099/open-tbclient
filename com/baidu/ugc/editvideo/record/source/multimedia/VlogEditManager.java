package com.baidu.ugc.editvideo.record.source.multimedia;

import android.graphics.SurfaceTexture;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.minivideo.effect.core.vlogedit.MediaAEffectConfig;
import com.baidu.minivideo.effect.core.vlogedit.MediaSegment;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrack;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrackConfig;
import com.baidu.minivideo.effect.core.vlogedit.MediaTransitionConfig;
import com.baidu.minivideo.effect.core.vlogedit.ShaderConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.data.MultiMediaData;
import com.baidu.ugc.editvideo.data.MultiMediaDataTrack;
import com.baidu.ugc.editvideo.record.processor.observer.EffectChangeObserver;
import com.baidu.ugc.editvideo.record.processor.observer.MediaTrackChangeObserver;
import com.baidu.ugc.editvideo.record.source.multimedia.IVLogPlayControlProtocol;
import com.baidu.ugc.editvideo.record.source.multimedia.utils.MultiDataSourceUtil;
import com.baidu.ugc.editvideo.sticker.StickerDataChangeType;
import com.baidu.ugc.editvideo.subtitle.SubTitleConfig;
import com.baidu.ugc.editvideo.subtitle.SubTitleUnit;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes7.dex */
public class VlogEditManager implements IMultiMediaDataSource, IVLogCommunicateProtocol, IVlogEditManager, IVlogEditViewManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int STATE_ERROR = -1;
    public static final int STATE_IDLE = 0;
    public static final int STATE_PAUSED = 4;
    public static final int STATE_PLAYBACK_COMPLETED = 5;
    public static final int STATE_PLAYING = 3;
    public static final int STATE_PREPARED = 2;
    public static final int STATE_PREPARING = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile int mCurrentState;
    public MultiMediaDataSource mMultiMediaDataSource;
    public IMultiMediaDataSourceView mOnMultiMediaEntireProtocol;
    public volatile int mTargetState;

    public VlogEditManager(IMultiMediaDataSourceView iMultiMediaDataSourceView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iMultiMediaDataSourceView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mCurrentState = 0;
        this.mTargetState = 0;
        this.mOnMultiMediaEntireProtocol = iMultiMediaDataSourceView;
        MultiMediaDataSource multiMediaDataSource = new MultiMediaDataSource();
        this.mMultiMediaDataSource = multiMediaDataSource;
        if (iMultiMediaDataSourceView != null) {
            multiMediaDataSource.setOnFrameAvailableListener(new SurfaceTexture.OnFrameAvailableListener(this, iMultiMediaDataSourceView) { // from class: com.baidu.ugc.editvideo.record.source.multimedia.VlogEditManager.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ VlogEditManager this$0;
                public final /* synthetic */ IMultiMediaDataSourceView val$protocol;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext2 = TitanRuntime.newInitContext();
                        newInitContext2.initArgs = r2;
                        Object[] objArr2 = {this, iMultiMediaDataSourceView};
                        interceptable2.invokeUnInit(65536, newInitContext2);
                        int i3 = newInitContext2.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext2.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext2);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$protocol = iMultiMediaDataSourceView;
                }

                @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
                public void onFrameAvailable(SurfaceTexture surfaceTexture) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, surfaceTexture) == null) {
                        this.this$0.notifyFrameAvailable();
                        if (surfaceTexture != null) {
                            this.val$protocol.seek(this.this$0.mMultiMediaDataSource.getCurrentPlayTime());
                        }
                    }
                }
            });
            setPreRunnableTask(iMultiMediaDataSourceView);
            iMultiMediaDataSourceView.setIMultiMediaDataSource(this.mMultiMediaDataSource);
        }
        this.mCurrentState = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyFrameAvailable() {
        IMultiMediaDataSourceView iMultiMediaDataSourceView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) || (iMultiMediaDataSourceView = this.mOnMultiMediaEntireProtocol) == null) {
            return;
        }
        iMultiMediaDataSourceView.onFrameAvailable(null);
    }

    public void addCoverStickerData(MultiMediaData multiMediaData) {
        IMultiMediaDataSourceView iMultiMediaDataSourceView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, multiMediaData) == null) || (iMultiMediaDataSourceView = this.mOnMultiMediaEntireProtocol) == null) {
            return;
        }
        iMultiMediaDataSourceView.addCoverStickerData(multiMediaData);
    }

    public void addCoverStickerDataList(List<MultiMediaData> list) {
        IMultiMediaDataSourceView iMultiMediaDataSourceView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) || (iMultiMediaDataSourceView = this.mOnMultiMediaEntireProtocol) == null) {
            return;
        }
        iMultiMediaDataSourceView.addCoverStickerDataList(list);
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public void addMultiMediaData(int i, List<MultiMediaData> list) {
        MultiMediaDataSource multiMediaDataSource;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, list) == null) || (multiMediaDataSource = this.mMultiMediaDataSource) == null) {
            return;
        }
        multiMediaDataSource.addMultiMediaData(i, list);
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public void addOneTrack(MediaTrack mediaTrack) {
        MultiMediaDataSource multiMediaDataSource;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, mediaTrack) == null) || (multiMediaDataSource = this.mMultiMediaDataSource) == null) {
            return;
        }
        multiMediaDataSource.addOneTrack(mediaTrack);
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public void addStickerData(MultiMediaData multiMediaData, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, multiMediaData, str) == null) {
            MultiMediaDataSource multiMediaDataSource = this.mMultiMediaDataSource;
            if (multiMediaDataSource != null) {
                multiMediaDataSource.addStickerData(multiMediaData, str);
            }
            IMultiMediaDataSourceView iMultiMediaDataSourceView = this.mOnMultiMediaEntireProtocol;
            if (iMultiMediaDataSourceView != null) {
                iMultiMediaDataSourceView.notifyStickerDataChange(StickerDataChangeType.ADD);
            }
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditViewManager
    public void cancelStickerSelected() {
        IMultiMediaDataSourceView iMultiMediaDataSourceView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (iMultiMediaDataSourceView = this.mOnMultiMediaEntireProtocol) == null) {
            return;
        }
        iMultiMediaDataSourceView.cancelStickerSelected();
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditViewManager
    public Buffer captureVideoCover(int i, long j, int i2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            IMultiMediaDataSourceView iMultiMediaDataSourceView = this.mOnMultiMediaEntireProtocol;
            if (iMultiMediaDataSourceView != null) {
                iMultiMediaDataSourceView.capture(i, j, i2, i3);
            }
            return MultiDataSourceUtil.saveOffscreenBuffer(i2, i3, true);
        }
        return (Buffer) invokeCommon.objValue;
    }

    public void deleteCoverStickerData(MultiMediaData multiMediaData) {
        IMultiMediaDataSourceView iMultiMediaDataSourceView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, multiMediaData) == null) || (iMultiMediaDataSourceView = this.mOnMultiMediaEntireProtocol) == null) {
            return;
        }
        iMultiMediaDataSourceView.deleteCoverStickerData(multiMediaData);
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public void deleteMultiMediaData(int i) {
        MultiMediaDataSource multiMediaDataSource;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) || (multiMediaDataSource = this.mMultiMediaDataSource) == null) {
            return;
        }
        multiMediaDataSource.deleteMultiMediaData(i);
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditViewManager
    public void deleteStickerData(MultiMediaData multiMediaData, String str) {
        IMultiMediaDataSourceView iMultiMediaDataSourceView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048585, this, multiMediaData, str) == null) || (iMultiMediaDataSourceView = this.mOnMultiMediaEntireProtocol) == null) {
            return;
        }
        iMultiMediaDataSourceView.deleteStickerData(multiMediaData, str);
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public int editOneEffect(int i, MediaAEffectConfig mediaAEffectConfig, long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i), mediaAEffectConfig, Long.valueOf(j), Long.valueOf(j2)})) == null) {
            MultiMediaDataSource multiMediaDataSource = this.mMultiMediaDataSource;
            if (multiMediaDataSource != null) {
                return multiMediaDataSource.editOneEffect(i, mediaAEffectConfig, j, j2);
            }
            return 0;
        }
        return invokeCommon.intValue;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public String exportConfigJson(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            MultiMediaDataSource multiMediaDataSource = this.mMultiMediaDataSource;
            if (multiMediaDataSource != null) {
                return multiMediaDataSource.exportConfigJson(str);
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public List<MultiMediaData> getCoverStickerDataList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            IMultiMediaDataSourceView iMultiMediaDataSourceView = this.mOnMultiMediaEntireProtocol;
            return iMultiMediaDataSourceView != null ? iMultiMediaDataSourceView.getCoverStickerDataList() : new ArrayList();
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaDataSource
    public int getCurrentIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            MultiMediaDataSource multiMediaDataSource = this.mMultiMediaDataSource;
            if (multiMediaDataSource != null) {
                return multiMediaDataSource.getCurrentIndex();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaDataSource
    public long getCurrentPlayTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            MultiMediaDataSource multiMediaDataSource = this.mMultiMediaDataSource;
            if (multiMediaDataSource != null) {
                return multiMediaDataSource.getCurrentPlayTime();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public SubTitleUnit getCurrentSubtitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            MultiMediaDataSource multiMediaDataSource = this.mMultiMediaDataSource;
            if (multiMediaDataSource != null) {
                return multiMediaDataSource.getCurrentSubtitle();
            }
            return null;
        }
        return (SubTitleUnit) invokeV.objValue;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaDataSource
    public long getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            MultiMediaDataSource multiMediaDataSource = this.mMultiMediaDataSource;
            if (multiMediaDataSource != null) {
                return multiMediaDataSource.getDuration();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public ArrayList<MultiMediaData> getInputMultiMediaData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            MultiMediaDataSource multiMediaDataSource = this.mMultiMediaDataSource;
            if (multiMediaDataSource != null) {
                return multiMediaDataSource.getInputMultiMediaData();
            }
            return null;
        }
        return (ArrayList) invokeV.objValue;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaDataSource
    public MediaTrackConfig getMediaTrackConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            MultiMediaDataSource multiMediaDataSource = this.mMultiMediaDataSource;
            if (multiMediaDataSource != null) {
                return multiMediaDataSource.getMediaTrackConfig();
            }
            return null;
        }
        return (MediaTrackConfig) invokeV.objValue;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public MultiMediaData getMultiMediaData(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048595, this, i)) == null) {
            MultiMediaDataSource multiMediaDataSource = this.mMultiMediaDataSource;
            if (multiMediaDataSource != null) {
                return multiMediaDataSource.getMultiMediaData(i);
            }
            return null;
        }
        return (MultiMediaData) invokeI.objValue;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaDataSource
    public List<MultiMediaDataTrack> getMultiMediaDataTrack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            MultiMediaDataSource multiMediaDataSource = this.mMultiMediaDataSource;
            if (multiMediaDataSource != null) {
                return multiMediaDataSource.getMultiMediaDataTrack();
            }
            return null;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public MediaTrack getOriginEffectTrack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            MultiMediaDataSource multiMediaDataSource = this.mMultiMediaDataSource;
            if (multiMediaDataSource != null) {
                return multiMediaDataSource.getOriginEffectTrack();
            }
            return null;
        }
        return (MediaTrack) invokeV.objValue;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaDataSource
    public Map<String, ShaderConfig> getShaderConfigMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            MultiMediaDataSource multiMediaDataSource = this.mMultiMediaDataSource;
            if (multiMediaDataSource != null) {
                return multiMediaDataSource.getShaderConfigMap();
            }
            return null;
        }
        return (Map) invokeV.objValue;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public List<MultiMediaData> getStickerMultiMediaDataList(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048599, this, z)) == null) {
            MultiMediaDataSource multiMediaDataSource = this.mMultiMediaDataSource;
            if (multiMediaDataSource != null) {
                return multiMediaDataSource.getStickerMultiMediaDataList(z);
            }
            return null;
        }
        return (List) invokeZ.objValue;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public List<MediaSegment> getStickerSegmentsData(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048600, this, z)) == null) {
            MultiMediaDataSource multiMediaDataSource = this.mMultiMediaDataSource;
            if (multiMediaDataSource != null) {
                return multiMediaDataSource.getStickerSegmentsData(z);
            }
            return null;
        }
        return (List) invokeZ.objValue;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public List<MediaSegment> getStickerSegmentsDataByType(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, str)) == null) {
            MultiMediaDataSource multiMediaDataSource = this.mMultiMediaDataSource;
            if (multiMediaDataSource != null) {
                return multiMediaDataSource.getStickerSegmentsDataByType(str);
            }
            return null;
        }
        return (List) invokeL.objValue;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaDataSource
    public List<MediaTrack> getUpdateMediaTracks() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            MultiMediaDataSource multiMediaDataSource = this.mMultiMediaDataSource;
            if (multiMediaDataSource != null) {
                return multiMediaDataSource.getUpdateMediaTracks();
            }
            return null;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public float getVideoRatio() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            MultiMediaDataSource multiMediaDataSource = this.mMultiMediaDataSource;
            if (multiMediaDataSource != null) {
                return multiMediaDataSource.getVideoRatio();
            }
            return 0.0f;
        }
        return invokeV.floatValue;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogPlayControlProtocol
    public float getVolume(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048604, this, i)) == null) {
            MultiMediaDataSource multiMediaDataSource = this.mMultiMediaDataSource;
            if (multiMediaDataSource != null) {
                return multiMediaDataSource.getVolume(i);
            }
            return 1.0f;
        }
        return invokeI.floatValue;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogPlayControlProtocol
    public boolean isMute() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            MultiMediaDataSource multiMediaDataSource = this.mMultiMediaDataSource;
            if (multiMediaDataSource != null) {
                return multiMediaDataSource.isMute();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaDataSource
    public boolean isPaused() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            MultiMediaDataSource multiMediaDataSource = this.mMultiMediaDataSource;
            if (multiMediaDataSource != null) {
                return multiMediaDataSource.isPaused();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogPlayControlProtocol
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            MultiMediaDataSource multiMediaDataSource = this.mMultiMediaDataSource;
            if (multiMediaDataSource != null) {
                return multiMediaDataSource.isPlaying();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaDataSource
    public boolean isResourceReady() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            MultiMediaDataSource multiMediaDataSource = this.mMultiMediaDataSource;
            if (multiMediaDataSource != null) {
                return multiMediaDataSource.isResourceReady();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public void modifyTimeByRange(long j, long j2) {
        MultiMediaDataSource multiMediaDataSource;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048609, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) || (multiMediaDataSource = this.mMultiMediaDataSource) == null) {
            return;
        }
        multiMediaDataSource.modifyTimeByRange(j, j2);
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditViewManager
    public void moveBoundsCheckEnabled(boolean z) {
        IMultiMediaDataSourceView iMultiMediaDataSourceView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048610, this, z) == null) || (iMultiMediaDataSourceView = this.mOnMultiMediaEntireProtocol) == null) {
            return;
        }
        iMultiMediaDataSourceView.moveBoundsCheckEnabled(z);
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public void needDrawEffect(boolean z) {
        IMultiMediaDataSourceView iMultiMediaDataSourceView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048611, this, z) == null) || (iMultiMediaDataSourceView = this.mOnMultiMediaEntireProtocol) == null) {
            return;
        }
        iMultiMediaDataSourceView.needDrawEffect(z);
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogLifeProtocol
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            MultiMediaDataSource multiMediaDataSource = this.mMultiMediaDataSource;
            if (multiMediaDataSource != null) {
                multiMediaDataSource.onDestroy();
            }
            this.mCurrentState = 0;
            this.mTargetState = 0;
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaDataSource
    public void onInit() {
        MultiMediaDataSource multiMediaDataSource;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048613, this) == null) || (multiMediaDataSource = this.mMultiMediaDataSource) == null) {
            return;
        }
        multiMediaDataSource.onInit();
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogLifeProtocol
    public void onPause() {
        MultiMediaDataSource multiMediaDataSource;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048614, this) == null) || (multiMediaDataSource = this.mMultiMediaDataSource) == null) {
            return;
        }
        multiMediaDataSource.onPause();
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogLifeProtocol
    public void onResume() {
        MultiMediaDataSource multiMediaDataSource;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048615, this) == null) || (multiMediaDataSource = this.mMultiMediaDataSource) == null) {
            return;
        }
        multiMediaDataSource.onResume();
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogPlayControlProtocol
    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            this.mTargetState = 4;
            MultiMediaDataSource multiMediaDataSource = this.mMultiMediaDataSource;
            if (multiMediaDataSource != null) {
                multiMediaDataSource.pause();
            }
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogPlayControlProtocol
    public void prepareAsync() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            MultiMediaDataSource multiMediaDataSource = this.mMultiMediaDataSource;
            if (multiMediaDataSource != null) {
                multiMediaDataSource.prepareAsync();
            }
            this.mCurrentState = 1;
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public boolean rangeSegmentScope(int i, long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048618, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2)})) == null) {
            MultiMediaDataSource multiMediaDataSource = this.mMultiMediaDataSource;
            if (multiMediaDataSource != null) {
                return multiMediaDataSource.rangeSegmentScope(i, j, j2);
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaDataSource
    public void registerObserver(EffectChangeObserver effectChangeObserver) {
        MultiMediaDataSource multiMediaDataSource;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048619, this, effectChangeObserver) == null) || (multiMediaDataSource = this.mMultiMediaDataSource) == null) {
            return;
        }
        multiMediaDataSource.registerObserver(effectChangeObserver);
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaDataSource
    public void registerObserver(MediaTrackChangeObserver mediaTrackChangeObserver) {
        MultiMediaDataSource multiMediaDataSource;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048620, this, mediaTrackChangeObserver) == null) || (multiMediaDataSource = this.mMultiMediaDataSource) == null) {
            return;
        }
        multiMediaDataSource.registerObserver(mediaTrackChangeObserver);
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogPlayControlProtocol
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            MultiMediaDataSource multiMediaDataSource = this.mMultiMediaDataSource;
            if (multiMediaDataSource != null) {
                multiMediaDataSource.release();
            }
            this.mCurrentState = 0;
            this.mTargetState = 0;
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaDataSource
    public void releaseTextures() {
        MultiMediaDataSource multiMediaDataSource;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048622, this) == null) || (multiMediaDataSource = this.mMultiMediaDataSource) == null) {
            return;
        }
        multiMediaDataSource.releaseTextures();
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public void removeLastEffect() {
        MultiMediaDataSource multiMediaDataSource;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048623, this) == null) || (multiMediaDataSource = this.mMultiMediaDataSource) == null) {
            return;
        }
        multiMediaDataSource.removeLastEffect();
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public void removeOneTrack(String str) {
        MultiMediaDataSource multiMediaDataSource;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048624, this, str) == null) || (multiMediaDataSource = this.mMultiMediaDataSource) == null) {
            return;
        }
        multiMediaDataSource.removeOneTrack(str);
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogPlayControlProtocol
    public void repeatIndex(int i) {
        MultiMediaDataSource multiMediaDataSource;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048625, this, i) == null) || (multiMediaDataSource = this.mMultiMediaDataSource) == null) {
            return;
        }
        multiMediaDataSource.repeatIndex(i);
    }

    public void replaceCoverStickerData(MultiMediaData multiMediaData) {
        IMultiMediaDataSourceView iMultiMediaDataSourceView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048626, this, multiMediaData) == null) || (iMultiMediaDataSourceView = this.mOnMultiMediaEntireProtocol) == null) {
            return;
        }
        iMultiMediaDataSourceView.replaceCoverStickerData(multiMediaData);
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public void replaceStickerData(int i, MultiMediaData multiMediaData, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048627, this, i, multiMediaData, str) == null) {
            MultiMediaDataSource multiMediaDataSource = this.mMultiMediaDataSource;
            if (multiMediaDataSource != null) {
                multiMediaDataSource.replaceStickerData(i, multiMediaData, str);
            }
            IMultiMediaDataSourceView iMultiMediaDataSourceView = this.mOnMultiMediaEntireProtocol;
            if (iMultiMediaDataSourceView != null) {
                iMultiMediaDataSourceView.notifyStickerDataChange(StickerDataChangeType.REPLACE);
            }
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogPlayControlProtocol
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            MultiMediaDataSource multiMediaDataSource = this.mMultiMediaDataSource;
            if (multiMediaDataSource != null) {
                multiMediaDataSource.reset();
            }
            this.mCurrentState = 0;
            this.mTargetState = 0;
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogPlayControlProtocol
    public void seek(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048629, this, j) == null) {
            MultiMediaDataSource multiMediaDataSource = this.mMultiMediaDataSource;
            if (multiMediaDataSource != null) {
                multiMediaDataSource.seek(j);
            }
            IMultiMediaDataSourceView iMultiMediaDataSourceView = this.mOnMultiMediaEntireProtocol;
            if (iMultiMediaDataSourceView != null) {
                iMultiMediaDataSourceView.seek(j);
            }
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogPlayControlProtocol
    public void seek(long j, int i) {
        MultiMediaDataSource multiMediaDataSource;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048630, this, new Object[]{Long.valueOf(j), Integer.valueOf(i)}) == null) || (multiMediaDataSource = this.mMultiMediaDataSource) == null) {
            return;
        }
        multiMediaDataSource.seek(j, i);
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public void setAngle(int i, float f) {
        MultiMediaDataSource multiMediaDataSource;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048631, this, new Object[]{Integer.valueOf(i), Float.valueOf(f)}) == null) || (multiMediaDataSource = this.mMultiMediaDataSource) == null) {
            return;
        }
        multiMediaDataSource.setAngle(i, f);
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    @Deprecated
    public void setAngle(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048632, this, i, i2) == null) {
            setAngle(i, i2);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public void setAudioChangeType(int i) {
        MultiMediaDataSource multiMediaDataSource;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048633, this, i) == null) || (multiMediaDataSource = this.mMultiMediaDataSource) == null) {
            return;
        }
        multiMediaDataSource.setAudioChangeType(i);
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public void setAudioChangeType(int[] iArr) {
        MultiMediaDataSource multiMediaDataSource;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048634, this, iArr) == null) || (multiMediaDataSource = this.mMultiMediaDataSource) == null) {
            return;
        }
        multiMediaDataSource.setAudioChangeType(iArr);
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public void setAudioChangeType(int[] iArr, double[] dArr, int[] iArr2) {
        MultiMediaDataSource multiMediaDataSource;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048635, this, iArr, dArr, iArr2) == null) || (multiMediaDataSource = this.mMultiMediaDataSource) == null) {
            return;
        }
        multiMediaDataSource.setAudioChangeType(iArr, dArr, iArr2);
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditViewManager
    public void setCurrentStickerData(int i, String str) {
        IMultiMediaDataSourceView iMultiMediaDataSourceView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048636, this, i, str) == null) || (iMultiMediaDataSourceView = this.mOnMultiMediaEntireProtocol) == null) {
            return;
        }
        iMultiMediaDataSourceView.setCurrentStickerData(i, str);
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public void setEffectList(List<MediaSegment> list, Map<String, ShaderConfig> map) {
        MultiMediaDataSource multiMediaDataSource;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048637, this, list, map) == null) || (multiMediaDataSource = this.mMultiMediaDataSource) == null) {
            return;
        }
        multiMediaDataSource.setEffectList(list, map);
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public void setFilter(float f, String str) {
        MultiMediaDataSource multiMediaDataSource;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048638, this, new Object[]{Float.valueOf(f), str}) == null) || (multiMediaDataSource = this.mMultiMediaDataSource) == null) {
            return;
        }
        multiMediaDataSource.setFilter(f, str);
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public void setFilter(int i, float f, String str) {
        MultiMediaDataSource multiMediaDataSource;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048639, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), str}) == null) || (multiMediaDataSource = this.mMultiMediaDataSource) == null) {
            return;
        }
        multiMediaDataSource.setFilter(i, f, str);
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public void setFrameRate(int i) {
        MultiMediaDataSource multiMediaDataSource;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048640, this, i) == null) || (multiMediaDataSource = this.mMultiMediaDataSource) == null) {
            return;
        }
        multiMediaDataSource.setFrameRate(i);
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogPlayControlProtocol
    public void setLooping(boolean z) {
        MultiMediaDataSource multiMediaDataSource;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048641, this, z) == null) || (multiMediaDataSource = this.mMultiMediaDataSource) == null) {
            return;
        }
        multiMediaDataSource.setLooping(z);
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public void setMediaTrackConfig(MediaTrackConfig mediaTrackConfig) {
        MultiMediaDataSource multiMediaDataSource;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048642, this, mediaTrackConfig) == null) || (multiMediaDataSource = this.mMultiMediaDataSource) == null) {
            return;
        }
        multiMediaDataSource.setMediaTrackConfig(mediaTrackConfig);
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public void setMultiMediaData(List<MultiMediaData> list) {
        MultiMediaDataSource multiMediaDataSource;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048643, this, list) == null) || (multiMediaDataSource = this.mMultiMediaDataSource) == null) {
            return;
        }
        multiMediaDataSource.setMultiMediaData(list);
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogCommunicateProtocol
    public void setMultiMediaStateEventListener(MultiMediaStateEventListener multiMediaStateEventListener) {
        MultiMediaDataSource multiMediaDataSource;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048644, this, multiMediaStateEventListener) == null) || (multiMediaDataSource = this.mMultiMediaDataSource) == null) {
            return;
        }
        multiMediaDataSource.setMultiMediaStateEventListener(multiMediaStateEventListener);
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogCommunicateProtocol
    public void setMultiMediaTimelineUpdateListener(MultiMediaTimelineUpdateListener multiMediaTimelineUpdateListener, boolean z) {
        MultiMediaDataSource multiMediaDataSource;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048645, this, multiMediaTimelineUpdateListener, z) == null) || (multiMediaDataSource = this.mMultiMediaDataSource) == null) {
            return;
        }
        multiMediaDataSource.setMultiMediaTimelineUpdateListener(multiMediaTimelineUpdateListener, z);
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogPlayControlProtocol
    public void setMute(boolean z) {
        MultiMediaDataSource multiMediaDataSource;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048646, this, z) == null) || (multiMediaDataSource = this.mMultiMediaDataSource) == null) {
            return;
        }
        multiMediaDataSource.setMute(z);
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogCommunicateProtocol
    public void setOnFrameAvailableListener(SurfaceTexture.OnFrameAvailableListener onFrameAvailableListener) {
        MultiMediaDataSource multiMediaDataSource;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048647, this, onFrameAvailableListener) == null) || (multiMediaDataSource = this.mMultiMediaDataSource) == null) {
            return;
        }
        multiMediaDataSource.setOnFrameAvailableListener(onFrameAvailableListener);
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogPlayControlProtocol
    public void setOnPlayStateListener(IVLogPlayControlProtocol.OnPlayStateListener onPlayStateListener) {
        MultiMediaDataSource multiMediaDataSource;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048648, this, onPlayStateListener) == null) || (multiMediaDataSource = this.mMultiMediaDataSource) == null) {
            return;
        }
        multiMediaDataSource.setOnPlayStateListener(onPlayStateListener);
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogCommunicateProtocol
    public void setPreRunnableTask(OnPreRunnableTask onPreRunnableTask) {
        MultiMediaDataSource multiMediaDataSource;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048649, this, onPreRunnableTask) == null) || (multiMediaDataSource = this.mMultiMediaDataSource) == null) {
            return;
        }
        multiMediaDataSource.setPreRunnableTask(onPreRunnableTask);
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogPlayControlProtocol
    public void setPreparedListener(IMultiMediaPreparedListener iMultiMediaPreparedListener) {
        MultiMediaDataSource multiMediaDataSource;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048650, this, iMultiMediaPreparedListener) == null) || (multiMediaDataSource = this.mMultiMediaDataSource) == null) {
            return;
        }
        multiMediaDataSource.setPreparedListener(new IMultiMediaPreparedListener(this, iMultiMediaPreparedListener) { // from class: com.baidu.ugc.editvideo.record.source.multimedia.VlogEditManager.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ VlogEditManager this$0;
            public final /* synthetic */ IMultiMediaPreparedListener val$listener;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, iMultiMediaPreparedListener};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
                this.val$listener = iMultiMediaPreparedListener;
            }

            @Override // com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaPreparedListener
            public void onPrepared() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    IMultiMediaPreparedListener iMultiMediaPreparedListener2 = this.val$listener;
                    if (iMultiMediaPreparedListener2 != null) {
                        iMultiMediaPreparedListener2.onPrepared();
                    }
                    this.this$0.mCurrentState = 2;
                }
            }
        });
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public void setScale(float f, float f2) {
        MultiMediaDataSource multiMediaDataSource;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048651, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)}) == null) || (multiMediaDataSource = this.mMultiMediaDataSource) == null) {
            return;
        }
        multiMediaDataSource.setScale(f, f2);
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public void setScaleType(String str) {
        MultiMediaDataSource multiMediaDataSource;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048652, this, str) == null) || (multiMediaDataSource = this.mMultiMediaDataSource) == null) {
            return;
        }
        multiMediaDataSource.setScaleType(str);
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public void setStickerDataList(List<MultiMediaData> list, List<MediaSegment> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048653, this, list, list2) == null) {
            MultiMediaDataSource multiMediaDataSource = this.mMultiMediaDataSource;
            if (multiMediaDataSource != null) {
                multiMediaDataSource.setStickerDataList(list, list2);
            }
            IMultiMediaDataSourceView iMultiMediaDataSourceView = this.mOnMultiMediaEntireProtocol;
            if (iMultiMediaDataSourceView != null) {
                iMultiMediaDataSourceView.notifyStickerDataChange("init");
            }
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditViewManager
    public void setStickerDeleteButton(String str, String str2) {
        IMultiMediaDataSourceView iMultiMediaDataSourceView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048654, this, str, str2) == null) || (iMultiMediaDataSourceView = this.mOnMultiMediaEntireProtocol) == null) {
            return;
        }
        iMultiMediaDataSourceView.setStickerDeleteButton(str, str2);
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditViewManager
    public void setStickerEditButton(String str, String str2) {
        IMultiMediaDataSourceView iMultiMediaDataSourceView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048655, this, str, str2) == null) || (iMultiMediaDataSourceView = this.mOnMultiMediaEntireProtocol) == null) {
            return;
        }
        iMultiMediaDataSourceView.setStickerEditButton(str, str2);
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditViewManager
    public void setStickerMaxScale(float f) {
        IMultiMediaDataSourceView iMultiMediaDataSourceView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048656, this, f) == null) || (iMultiMediaDataSourceView = this.mOnMultiMediaEntireProtocol) == null) {
            return;
        }
        iMultiMediaDataSourceView.setStickerMaxScale(f);
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditViewManager
    public void setStickerMinScale(float f) {
        IMultiMediaDataSourceView iMultiMediaDataSourceView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048657, this, f) == null) || (iMultiMediaDataSourceView = this.mOnMultiMediaEntireProtocol) == null) {
            return;
        }
        iMultiMediaDataSourceView.setStickerMinScale(f);
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditViewManager
    public void setStickerRotationButton(String str, String str2) {
        IMultiMediaDataSourceView iMultiMediaDataSourceView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048658, this, str, str2) == null) || (iMultiMediaDataSourceView = this.mOnMultiMediaEntireProtocol) == null) {
            return;
        }
        iMultiMediaDataSourceView.setStickerRotationButton(str, str2);
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public void setSubtitle(List<SubTitleUnit> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048659, this, list) == null) {
            MultiMediaDataSource multiMediaDataSource = this.mMultiMediaDataSource;
            if (multiMediaDataSource != null) {
                multiMediaDataSource.setSubtitle(list);
            }
            IMultiMediaDataSourceView iMultiMediaDataSourceView = this.mOnMultiMediaEntireProtocol;
            if (iMultiMediaDataSourceView != null) {
                iMultiMediaDataSourceView.notifyStickerDataChange("init");
            }
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public void setSubtitleConfig(SubTitleConfig subTitleConfig) {
        MultiMediaDataSource multiMediaDataSource;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048660, this, subTitleConfig) == null) || (multiMediaDataSource = this.mMultiMediaDataSource) == null) {
            return;
        }
        multiMediaDataSource.setSubtitleConfig(subTitleConfig);
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public void setSubtitleOnStickerLayerTop() {
        MultiMediaDataSource multiMediaDataSource;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048661, this) == null) || (multiMediaDataSource = this.mMultiMediaDataSource) == null) {
            return;
        }
        multiMediaDataSource.setSubtitleOnStickerLayerTop();
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public void setTransitionByIndex(int i, MediaTransitionConfig mediaTransitionConfig) {
        MultiMediaDataSource multiMediaDataSource;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048662, this, i, mediaTransitionConfig) == null) || (multiMediaDataSource = this.mMultiMediaDataSource) == null) {
            return;
        }
        multiMediaDataSource.setTransitionByIndex(i, mediaTransitionConfig);
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditViewManager
    public void setUpEditLayer(String str) {
        IMultiMediaDataSourceView iMultiMediaDataSourceView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048663, this, str) == null) || (iMultiMediaDataSourceView = this.mOnMultiMediaEntireProtocol) == null) {
            return;
        }
        iMultiMediaDataSourceView.setUpEditLayer(str);
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public void setVideoRatio(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048664, this, f) == null) {
            MultiMediaDataSource multiMediaDataSource = this.mMultiMediaDataSource;
            if (multiMediaDataSource != null) {
                multiMediaDataSource.setVideoRatio(f);
            }
            IMultiMediaDataSourceView iMultiMediaDataSourceView = this.mOnMultiMediaEntireProtocol;
            if (iMultiMediaDataSourceView != null) {
                iMultiMediaDataSourceView.setVideoRatio(f);
            }
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogPlayControlProtocol
    public void setVolume(float f) {
        MultiMediaDataSource multiMediaDataSource;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048665, this, f) == null) || (multiMediaDataSource = this.mMultiMediaDataSource) == null) {
            return;
        }
        multiMediaDataSource.setVolume(f);
        setMute(f == 0.0f);
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogPlayControlProtocol
    public void setVolume(int i, float f) {
        MultiMediaDataSource multiMediaDataSource;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048666, this, new Object[]{Integer.valueOf(i), Float.valueOf(f)}) == null) || (multiMediaDataSource = this.mMultiMediaDataSource) == null) {
            return;
        }
        multiMediaDataSource.setVolume(i, f);
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public void setX(float f) {
        MultiMediaDataSource multiMediaDataSource;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048667, this, f) == null) || (multiMediaDataSource = this.mMultiMediaDataSource) == null) {
            return;
        }
        multiMediaDataSource.setX(f);
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public void setY(float f) {
        MultiMediaDataSource multiMediaDataSource;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048668, this, f) == null) || (multiMediaDataSource = this.mMultiMediaDataSource) == null) {
            return;
        }
        multiMediaDataSource.setY(f);
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public void split(int i, long j, OnMultiMediaSplitListener onMultiMediaSplitListener) {
        MultiMediaDataSource multiMediaDataSource;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048669, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), onMultiMediaSplitListener}) == null) || (multiMediaDataSource = this.mMultiMediaDataSource) == null) {
            return;
        }
        multiMediaDataSource.split(i, j, onMultiMediaSplitListener);
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogPlayControlProtocol
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048670, this) == null) {
            this.mTargetState = 3;
            MultiMediaDataSource multiMediaDataSource = this.mMultiMediaDataSource;
            if (multiMediaDataSource != null) {
                multiMediaDataSource.start();
            }
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public void updateInputDataOrder(List<MultiMediaData> list) {
        MultiMediaDataSource multiMediaDataSource;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048671, this, list) == null) || (multiMediaDataSource = this.mMultiMediaDataSource) == null) {
            return;
        }
        multiMediaDataSource.updateInputDataOrder(list);
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public void updateStickerDataRange(int i, String str, long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048672, this, new Object[]{Integer.valueOf(i), str, Long.valueOf(j), Long.valueOf(j2)}) == null) {
            MultiMediaDataSource multiMediaDataSource = this.mMultiMediaDataSource;
            if (multiMediaDataSource != null) {
                multiMediaDataSource.updateStickerDataRange(i, str, j, j2);
            }
            IMultiMediaDataSourceView iMultiMediaDataSourceView = this.mOnMultiMediaEntireProtocol;
            if (iMultiMediaDataSourceView != null) {
                iMultiMediaDataSourceView.notifyStickerDataChange(StickerDataChangeType.UPDATE);
            }
        }
    }
}
