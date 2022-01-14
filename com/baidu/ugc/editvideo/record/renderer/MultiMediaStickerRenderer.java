package com.baidu.ugc.editvideo.record.renderer;

import android.opengl.GLES20;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.a1.t.h;
import c.a.b0.b.a.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.minivideo.effect.core.vlogedit.MediaSegment;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrack;
import com.baidu.minivideo.plugin.capture.bean.FaceItem;
import com.baidu.searchbox.launch.stats.SpeedStatsStampTable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.data.MultiMediaData;
import com.baidu.ugc.editvideo.data.MultiMediaDataTrack;
import com.baidu.ugc.editvideo.record.entity.GLViewPortLocation;
import com.baidu.ugc.editvideo.record.source.multimedia.utils.MultiDataSourceUtil;
import com.baidu.ugc.editvideo.sticker.OnChangeStickerListener;
import com.baidu.ugc.editvideo.sticker.StickerDataChangeType;
import com.baidu.ugc.editvideo.sticker.a;
import com.baidu.ugc.editvideo.subtitle.SubtitleLog;
import com.baidu.wallet.paysdk.banksign.beans.BankSignFactory;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes13.dex */
public class MultiMediaStickerRenderer extends MultiMediaEditBaseRenderer {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long mCurrentPos;
    public MultiMediaDataTrack mMultiMediaDataTrack;
    public MediaTrack mSubtitleAndStickerTrack;
    public List<a> mTempStickerItemList;

    public MultiMediaStickerRenderer() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    private void checkDataChange() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65539, this) == null) || this.mMultiMediaDataTrack == null || this.mSubtitleAndStickerTrack == null) {
            return;
        }
        if (this.mTempStickerItemList == null) {
            this.mTempStickerItemList = new ArrayList();
        }
        this.mTempStickerItemList.addAll(this.mStickerItems);
        this.mStickerItems.clear();
        int size = this.mMultiMediaDataTrack.multiMediaDataList.size();
        for (int i2 = 0; i2 < size; i2++) {
            a aVar = new a(this.mMultiMediaDataTrack.multiMediaDataList.get(i2));
            this.mStickerItems.add(aVar);
            if (i2 == size - 1) {
                if (TextUtils.equals(this.mCurrentStickerDataChangeType, "init")) {
                    this.mCurrentItem = null;
                } else {
                    this.mCurrentItem = aVar;
                }
            }
        }
    }

    private void releaseTempStickerItemList() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) || h.e(this.mTempStickerItemList)) {
            return;
        }
        for (a aVar : this.mTempStickerItemList) {
            aVar.d();
        }
        this.mTempStickerItemList.clear();
    }

    public void cancelStickerSelected() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.mCurrentStickerDataChangeType = "init";
            this.mCurrentItem = null;
        }
    }

    @Override // com.baidu.ugc.editvideo.record.renderer.MultiMediaEditBaseRenderer
    public void deleteTexture() {
        List<MultiMediaData> list;
        List<MediaSegment> list2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.deleteTexture();
            MediaTrack mediaTrack = this.mSubtitleAndStickerTrack;
            if (mediaTrack != null && (list2 = mediaTrack.mediaSegments) != null) {
                for (MediaSegment mediaSegment : list2) {
                    MultiDataSourceUtil.glDeleteTextures(mediaSegment.textureId);
                    mediaSegment.textureId = 0;
                }
            }
            MultiMediaDataTrack multiMediaDataTrack = this.mMultiMediaDataTrack;
            if (multiMediaDataTrack != null && (list = multiMediaDataTrack.multiMediaDataList) != null) {
                for (MultiMediaData multiMediaData : list) {
                    MultiDataSourceUtil.glDeleteTextures(multiMediaData);
                }
            }
            releaseTempStickerItemList();
        }
    }

    @Override // com.baidu.ugc.editvideo.record.renderer.MediaBaseRenderer, com.baidu.ugc.editvideo.record.renderer.IMediaRenderer
    public void onDrawFrame(e eVar, int i2, float[] fArr) {
        MediaTrack mediaTrack;
        MultiMediaDataTrack multiMediaDataTrack;
        List<MediaSegment> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, eVar, i2, fArr) == null) || eVar == null || (mediaTrack = this.mSubtitleAndStickerTrack) == null || (multiMediaDataTrack = this.mMultiMediaDataTrack) == null || (list = mediaTrack.mediaSegments) == null || multiMediaDataTrack.multiMediaDataList == null || this.mStickerItems == null || list.size() != this.mMultiMediaDataTrack.multiMediaDataList.size() || this.mStickerItems.size() == 0 || this.mStickerItems.size() != this.mMultiMediaDataTrack.multiMediaDataList.size()) {
            return;
        }
        this.mCurrentPos = eVar.a();
        releaseTempStickerItemList();
        GLViewPortLocation gLViewPortLocation = this.mGLViewPortLocation;
        float f2 = this.mScaleX;
        int i3 = gLViewPortLocation.width;
        int i4 = (int) (gLViewPortLocation.x + (((1.0f - f2) * i3) / 2.0f) + ((i3 * this.mTx) / 2.0f));
        float f3 = this.mScaleY;
        int i5 = gLViewPortLocation.height;
        int i6 = (int) (gLViewPortLocation.y + (((1.0f - f3) * i5) / 2.0f) + ((i5 * this.mTy) / 2.0f));
        int i7 = (int) (i3 * f2);
        int i8 = (int) (i5 * f3);
        GLES20.glViewport(i4, i6, i7, i8);
        GLES20.glEnable(SpeedStatsStampTable.MAINACTIVITY_ONRESUME_END_STAMP_KEY);
        GLES20.glBlendFunc(1, BankSignFactory.BEAN_ID_BIND_CARD);
        for (int i9 = 0; i9 < this.mSubtitleAndStickerTrack.mediaSegments.size(); i9++) {
            MediaSegment mediaSegment = this.mSubtitleAndStickerTrack.mediaSegments.get(i9);
            MultiMediaData multiMediaData = this.mMultiMediaDataTrack.multiMediaDataList.get(i9);
            if (mediaSegment != null && multiMediaData != null) {
                long j2 = mediaSegment.start;
                if (j2 == 0 || j2 <= eVar.a()) {
                    long j3 = mediaSegment.end;
                    if ((j3 == 0 || j3 >= eVar.a()) && multiMediaData.textureId != 0) {
                        a aVar = this.mStickerItems.get(i9);
                        if (checkForSubline()) {
                            MultiMediaData checkForInitBtn = checkForInitBtn(this.mSublineData, "video_dotted_line");
                            this.mSublineData = checkForInitBtn;
                            aVar.a(this.mFullScreen2D, checkForInitBtn);
                        }
                        aVar.a(TextUtils.equals(this.mEditTrackType, mediaSegment.type));
                        aVar.a(this.mPreviewWidth, this.mPreviewHeight);
                        aVar.a(this.mGLViewPortLocation);
                        aVar.a(this.mProjectionMatrix);
                        if (TextUtils.equals(this.mEditTrackType, FaceItem.DIR_STICKER)) {
                            aVar.a(1.1f);
                        }
                        aVar.a(this.mScaleX, this.mScaleY, this.mTx, this.mTy);
                        if (mediaSegment.mediaAEffect == null) {
                            aVar.a(this.mFullScreen2D, this.mFullScreenEXT);
                        } else {
                            aVar.b(this.mFullScreen2D);
                            GLES20.glBindFramebuffer(36160, aVar.a[0]);
                            GLViewPortLocation gLViewPortLocation2 = this.mGLViewPortLocation;
                            GLES20.glViewport(0, 0, gLViewPortLocation2.width, gLViewPortLocation2.height);
                            GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
                            GLES20.glClear(16640);
                            aVar.a(this.mFullScreen2D, this.mFullScreenEXT);
                            GLES20.glBindFramebuffer(36160, 0);
                            int h2 = eVar.h(mediaSegment, aVar.f50298b[0], null);
                            GLES20.glViewport(i4, i6, i7, i8);
                            this.mFullScreen2D.drawFrame(h2, fArr);
                        }
                        if (TextUtils.equals(this.mEditTrackType, mediaSegment.type) && this.mCurrentItem != null && this.mCurrentItem.equals(aVar)) {
                            createButtonTexture();
                            aVar.a(this.mDeleteBtnData, this.mDeleteButtonPosition);
                            aVar.b(this.mRotationBtnData, this.mRotationButtonPosition);
                            aVar.c(this.mEditBtnData, this.mEditButtonPosition);
                            aVar.b(this.mFullScreen2D, this.mFrameRect);
                            if (TextUtils.equals(this.mEditTrackType, "text") || TextUtils.equals(this.mEditTrackType, SubtitleLog.TAG)) {
                                aVar.a(this.mFullScreen2D);
                            }
                        }
                    }
                }
            }
        }
        GLES20.glDisable(SpeedStatsStampTable.MAINACTIVITY_ONRESUME_END_STAMP_KEY);
    }

    @Override // com.baidu.ugc.editvideo.record.renderer.MultiMediaEditBaseRenderer, com.baidu.ugc.editvideo.record.preview.OnMediaPreviewTouchEventListener
    public boolean onTouchDown(float f2, float f3, float f4, float f5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)})) == null) {
            if (this.mSubtitleAndStickerTrack == null) {
                return false;
            }
            this.mVisibleStickerItems.clear();
            for (int i2 = 0; i2 < this.mSubtitleAndStickerTrack.mediaSegments.size(); i2++) {
                MediaSegment mediaSegment = this.mSubtitleAndStickerTrack.mediaSegments.get(i2);
                if (i2 >= this.mMultiMediaDataTrack.multiMediaDataList.size()) {
                    return super.onTouchDown(f2, f3, f4, f5);
                }
                MultiMediaData multiMediaData = this.mMultiMediaDataTrack.multiMediaDataList.get(i2);
                if (mediaSegment != null && multiMediaData != null) {
                    long j2 = mediaSegment.start;
                    if (j2 == 0 || j2 <= this.mCurrentPos) {
                        long j3 = mediaSegment.end;
                        if ((j3 == 0 || j3 >= this.mCurrentPos) && multiMediaData.textureId != 0 && TextUtils.equals(this.mEditTrackType, mediaSegment.type)) {
                            this.mVisibleStickerItems.add((a) h.c(this.mStickerItems, i2));
                        }
                    }
                }
            }
            return super.onTouchDown(f2, f3, f4, f5);
        }
        return invokeCommon.booleanValue;
    }

    @Override // com.baidu.ugc.editvideo.record.renderer.MultiMediaEditBaseRenderer
    public void setCurrentItem(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            boolean z = aVar != this.mCurrentItem;
            super.setCurrentItem(aVar);
            List<a> list = this.mStickerItems;
            int indexOf = list.indexOf(aVar);
            h.h(list, indexOf, list.size() - 1);
            MultiMediaDataTrack multiMediaDataTrack = this.mMultiMediaDataTrack;
            if (multiMediaDataTrack != null) {
                List<MultiMediaData> list2 = multiMediaDataTrack.multiMediaDataList;
                h.h(list2, indexOf, list2.size() - 1);
            }
            MediaTrack mediaTrack = this.mSubtitleAndStickerTrack;
            if (mediaTrack != null) {
                List<MediaSegment> list3 = mediaTrack.mediaSegments;
                h.h(list3, indexOf, list3.size() - 1);
            }
            if (z) {
                notifyStickerDataChange(StickerDataChangeType.SWAP);
            }
        }
    }

    public void setCurrentStickerData(int i2, String str) {
        MediaSegment mediaSegment;
        int indexOf;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048581, this, i2, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        List<MediaSegment> stickerSegmentsDataByType = MultiDataSourceUtil.getStickerSegmentsDataByType(this.mSubtitleAndStickerTrack, str);
        if (h.e(stickerSegmentsDataByType) || (mediaSegment = (MediaSegment) h.c(stickerSegmentsDataByType, i2)) == null || (indexOf = this.mSubtitleAndStickerTrack.mediaSegments.indexOf(mediaSegment)) < 0) {
            return;
        }
        a aVar = (a) h.c(this.mStickerItems, indexOf);
        if (aVar != null) {
            setCurrentItem(aVar);
        }
        if (this.mInnerOnChangeStickerListener == null || this.mCurrentItem == null) {
            return;
        }
        this.mInnerOnChangeStickerListener.onClickSticker(this.mCurrentItem.b(), this.mEditTrackType, true);
    }

    public void setData(MediaTrack mediaTrack, MultiMediaDataTrack multiMediaDataTrack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, mediaTrack, multiMediaDataTrack) == null) {
            this.mSubtitleAndStickerTrack = mediaTrack;
            this.mMultiMediaDataTrack = multiMediaDataTrack;
            checkDataChange();
        }
    }

    public void setOnChangeStickerListener(OnChangeStickerListener onChangeStickerListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, onChangeStickerListener) == null) {
            setInnerOnChangeStickerListener(new OnChangeStickerListener(this, onChangeStickerListener) { // from class: com.baidu.ugc.editvideo.record.renderer.MultiMediaStickerRenderer.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MultiMediaStickerRenderer this$0;
                public final /* synthetic */ OnChangeStickerListener val$onChangeStickerListener;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, onChangeStickerListener};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$onChangeStickerListener = onChangeStickerListener;
                }

                @Override // com.baidu.ugc.editvideo.sticker.OnChangeStickerListener
                public void onAutoAdjust(String str) {
                    OnChangeStickerListener onChangeStickerListener2;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, str) == null) || (onChangeStickerListener2 = this.val$onChangeStickerListener) == null) {
                        return;
                    }
                    onChangeStickerListener2.onAutoAdjust(str);
                }

                @Override // com.baidu.ugc.editvideo.sticker.OnChangeStickerListener
                public void onChangeSticker(int i2, MultiMediaData multiMediaData, String str) {
                    OnChangeStickerListener onChangeStickerListener2;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, multiMediaData, str) == null) || (onChangeStickerListener2 = this.val$onChangeStickerListener) == null) {
                        return;
                    }
                    onChangeStickerListener2.onChangeSticker(i2, multiMediaData, str);
                }

                @Override // com.baidu.ugc.editvideo.sticker.OnChangeStickerListener
                public void onClickSticker(MultiMediaData multiMediaData, String str, boolean z) {
                    OnChangeStickerListener onChangeStickerListener2;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeLLZ(Constants.METHOD_SEND_USER_MSG, this, multiMediaData, str, z) == null) || (onChangeStickerListener2 = this.val$onChangeStickerListener) == null) {
                        return;
                    }
                    onChangeStickerListener2.onClickSticker(multiMediaData, str, z);
                }

                @Override // com.baidu.ugc.editvideo.sticker.OnChangeStickerListener
                public void onClickStickerOutside(String str) {
                    OnChangeStickerListener onChangeStickerListener2;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048579, this, str) == null) || (onChangeStickerListener2 = this.val$onChangeStickerListener) == null) {
                        return;
                    }
                    onChangeStickerListener2.onClickStickerOutside(str);
                }

                @Override // com.baidu.ugc.editvideo.sticker.OnChangeStickerListener
                public void onDeleteSticker(MultiMediaData multiMediaData, int i2, String str, boolean z) {
                    int indexOf;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeCommon(1048580, this, new Object[]{multiMediaData, Integer.valueOf(i2), str, Boolean.valueOf(z)}) == null) || this.this$0.mMultiMediaDataTrack == null || this.this$0.mSubtitleAndStickerTrack == null) {
                        return;
                    }
                    if (TextUtils.equals(SubtitleLog.TAG, this.this$0.mEditTrackType)) {
                        OnChangeStickerListener onChangeStickerListener2 = this.val$onChangeStickerListener;
                        if (onChangeStickerListener2 != null) {
                            onChangeStickerListener2.onDeleteSticker(multiMediaData, i2, str, z);
                        }
                        if (z) {
                            return;
                        }
                    } else {
                        MediaSegment mediaSegment = this.this$0.mSubtitleAndStickerTrack.mediaSegments.get(i2);
                        List<MediaSegment> stickerSegmentsDataByType = MultiDataSourceUtil.getStickerSegmentsDataByType(this.this$0.mSubtitleAndStickerTrack, this.this$0.mEditTrackType);
                        if (stickerSegmentsDataByType == null || (indexOf = stickerSegmentsDataByType.indexOf(mediaSegment)) < 0) {
                            return;
                        }
                        this.this$0.mMultiMediaDataTrack.multiMediaDataList.remove(i2);
                        this.this$0.mSubtitleAndStickerTrack.mediaSegments.remove(i2);
                        OnChangeStickerListener onChangeStickerListener3 = this.val$onChangeStickerListener;
                        if (onChangeStickerListener3 != null) {
                            onChangeStickerListener3.onDeleteSticker(multiMediaData, indexOf, str, z);
                        }
                        if (z) {
                            return;
                        }
                    }
                    this.this$0.notifyStickerDataChange("delete");
                }

                @Override // com.baidu.ugc.editvideo.sticker.OnChangeStickerListener
                public void onEditSticker(MultiMediaData multiMediaData, String str) {
                    OnChangeStickerListener onChangeStickerListener2;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeLL(1048581, this, multiMediaData, str) == null) || (onChangeStickerListener2 = this.val$onChangeStickerListener) == null) {
                        return;
                    }
                    onChangeStickerListener2.onEditSticker(multiMediaData, str);
                }

                @Override // com.baidu.ugc.editvideo.sticker.OnChangeStickerListener
                public void onStickerDataChanged(String str, MultiMediaData multiMediaData, String str2) {
                    OnChangeStickerListener onChangeStickerListener2;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeLLL(1048582, this, str, multiMediaData, str2) == null) || (onChangeStickerListener2 = this.val$onChangeStickerListener) == null) {
                        return;
                    }
                    onChangeStickerListener2.onStickerDataChanged(str, multiMediaData, str2);
                }
            });
        }
    }
}
