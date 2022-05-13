package com.baidu.ugc.editvideo.record.renderer;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.stats.SpeedStatsStampTable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.data.MultiMediaData;
import com.baidu.ugc.editvideo.faceunity.gles.FullFrameRect;
import com.baidu.ugc.editvideo.record.entity.GLViewPortLocation;
import com.baidu.ugc.editvideo.record.source.multimedia.utils.MultiDataSourceUtil;
import com.baidu.ugc.editvideo.sticker.OnChangeStickerListener;
import com.baidu.ugc.editvideo.sticker.StickerDataChangeType;
import com.baidu.ugc.editvideo.sticker.a;
import com.repackage.ab9;
import com.repackage.sf0;
import com.repackage.va9;
import com.repackage.wa9;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class MultiMediaCoverStickerRenderer extends MultiMediaEditBaseRenderer {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<MultiMediaData> mCoverStickerDataList;

    public MultiMediaCoverStickerRenderer() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mCoverStickerDataList = new ArrayList();
    }

    private void initMultiMedia(MultiMediaData multiMediaData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, this, multiMediaData) == null) && multiMediaData != null && !TextUtils.isEmpty(multiMediaData.path) && multiMediaData.textureId == 0 && multiMediaData.type == 0) {
            Bitmap decodeBitmap = MultiDataSourceUtil.decodeBitmap(multiMediaData.path);
            try {
                int type = GLUtils.getType(decodeBitmap);
                int internalFormat = GLUtils.getInternalFormat(decodeBitmap);
                va9.b("type : " + type + " internalFormat : " + internalFormat);
            } catch (Exception unused) {
                decodeBitmap = wa9.c(decodeBitmap, Bitmap.CompressFormat.PNG, 100);
            }
            multiMediaData.textureId = MultiDataSourceUtil.initImageByBitmap(multiMediaData, decodeBitmap);
        }
    }

    private void initStickerItem(int i, MultiMediaData multiMediaData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65539, this, i, multiMediaData) == null) {
            initMultiMedia(multiMediaData);
            a aVar = new a(multiMediaData);
            this.mStickerItems.add(i, aVar);
            this.mCurrentItem = aVar;
        }
    }

    public void cancelStickerSelected() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.mCurrentStickerDataChangeType = "init";
            this.mCurrentItem = null;
        }
    }

    public void deleteCoverStickerData(MultiMediaData multiMediaData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, multiMediaData) == null) || multiMediaData == null) {
            return;
        }
        int i = -1;
        int i2 = 0;
        while (true) {
            if (i2 >= this.mCoverStickerDataList.size()) {
                break;
            } else if (multiMediaData.equals(this.mCoverStickerDataList.get(i2))) {
                i = i2;
                break;
            } else {
                i2++;
            }
        }
        ab9.g(this.mCoverStickerDataList, i);
        deleteStickerData(multiMediaData, "cover_sticker");
    }

    @Override // com.baidu.ugc.editvideo.record.renderer.MultiMediaEditBaseRenderer
    public void deleteTexture() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.deleteTexture();
            if (ab9.e(this.mCoverStickerDataList)) {
                return;
            }
            for (MultiMediaData multiMediaData : this.mCoverStickerDataList) {
                MultiDataSourceUtil.glDeleteTextures(multiMediaData);
            }
        }
    }

    public List<MultiMediaData> getCoverStickerDataList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mCoverStickerDataList : (List) invokeV.objValue;
    }

    @Override // com.baidu.ugc.editvideo.record.renderer.MediaBaseRenderer, com.baidu.ugc.editvideo.record.renderer.IMediaRenderer
    public void onDrawFrame(sf0 sf0Var, int i, float[] fArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(1048580, this, sf0Var, i, fArr) == null) || sf0Var == null || this.mCoverStickerDataList == null || !TextUtils.equals(this.mEditTrackType, "cover_sticker")) {
            return;
        }
        GLViewPortLocation gLViewPortLocation = this.mGLViewPortLocation;
        float f = this.mScaleX;
        int i2 = gLViewPortLocation.width;
        float f2 = this.mScaleY;
        int i3 = gLViewPortLocation.height;
        GLES20.glViewport((int) (gLViewPortLocation.x + (((1.0f - f) * i2) / 2.0f) + ((i2 * this.mTx) / 2.0f)), (int) (gLViewPortLocation.y + (((1.0f - f2) * i3) / 2.0f) + ((i3 * this.mTy) / 2.0f)), (int) (i2 * f), (int) (i3 * f2));
        GLES20.glEnable(SpeedStatsStampTable.MAINACTIVITY_ONRESUME_END_STAMP_KEY);
        GLES20.glBlendFunc(1, 771);
        for (int i4 = 0; i4 < this.mCoverStickerDataList.size(); i4++) {
            MultiMediaData multiMediaData = this.mCoverStickerDataList.get(i4);
            if (multiMediaData != null && multiMediaData.textureId != 0) {
                a aVar = this.mStickerItems.get(i4);
                if (checkForSubline()) {
                    MultiMediaData checkForInitBtn = checkForInitBtn(this.mSublineData, "video_dotted_line");
                    this.mSublineData = checkForInitBtn;
                    aVar.a(this.mFullScreen2D, checkForInitBtn);
                }
                aVar.a(true);
                aVar.a(this.mPreviewWidth, this.mPreviewHeight);
                aVar.a(this.mGLViewPortLocation);
                aVar.a(this.mProjectionMatrix);
                aVar.a(this.mScaleX, this.mScaleY, this.mTx, this.mTy);
                aVar.a(this.mFullScreen2D, this.mFullScreenEXT);
                if (this.mCurrentItem != null && this.mCurrentItem.equals(aVar)) {
                    createButtonTexture();
                    aVar.a(this.mDeleteBtnData, this.mDeleteButtonPosition);
                    aVar.b(this.mRotationBtnData, this.mRotationButtonPosition);
                    aVar.c(this.mEditBtnData, this.mEditButtonPosition);
                    aVar.b(this.mFullScreen2D, this.mFrameRect);
                    aVar.a(this.mFullScreen2D);
                }
            }
        }
        GLES20.glDisable(SpeedStatsStampTable.MAINACTIVITY_ONRESUME_END_STAMP_KEY);
    }

    @Override // com.baidu.ugc.editvideo.record.renderer.MultiMediaEditBaseRenderer, com.baidu.ugc.editvideo.record.renderer.MediaBaseRenderer, com.baidu.ugc.editvideo.record.renderer.IMediaRenderer
    public void onSurfaceCreate(FullFrameRect fullFrameRect, FullFrameRect fullFrameRect2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, fullFrameRect, fullFrameRect2) == null) {
            super.onSurfaceCreate(fullFrameRect, fullFrameRect2);
            reInitMultiMediaList();
        }
    }

    @Override // com.baidu.ugc.editvideo.record.renderer.MultiMediaEditBaseRenderer, com.baidu.ugc.editvideo.record.preview.OnMediaPreviewTouchEventListener
    public boolean onTouchDown(float f, float f2, float f3, float f4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) {
            if (ab9.e(this.mCoverStickerDataList)) {
                return false;
            }
            this.mVisibleStickerItems.clear();
            if (TextUtils.equals(this.mEditTrackType, "cover_sticker")) {
                this.mVisibleStickerItems.addAll(this.mStickerItems);
            }
            return super.onTouchDown(f, f2, f3, f4);
        }
        return invokeCommon.booleanValue;
    }

    public void reInitMultiMediaList() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || ab9.e(this.mCoverStickerDataList)) {
            return;
        }
        for (int i = 0; i < this.mCoverStickerDataList.size(); i++) {
            initMultiMedia(this.mCoverStickerDataList.get(i));
        }
    }

    public void replaceCoverStickerData(MultiMediaData multiMediaData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, multiMediaData) == null) || multiMediaData == null) {
            return;
        }
        int i = 0;
        while (true) {
            if (i >= this.mCoverStickerDataList.size()) {
                i = -1;
                break;
            } else if (multiMediaData.equals(this.mCoverStickerDataList.get(i))) {
                break;
            } else {
                i++;
            }
        }
        if (i == -1 || i >= this.mStickerItems.size()) {
            return;
        }
        ab9.g(this.mStickerItems, i);
        MultiDataSourceUtil.glDeleteTextures(multiMediaData);
        initStickerItem(i, multiMediaData);
    }

    public void setCoverStickerData(MultiMediaData multiMediaData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, multiMediaData) == null) || multiMediaData == null) {
            return;
        }
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= this.mCoverStickerDataList.size()) {
                z = true;
                break;
            } else if (multiMediaData.equals(this.mCoverStickerDataList.get(i))) {
                break;
            } else {
                i++;
            }
        }
        if (z) {
            int size = this.mCoverStickerDataList.size();
            initStickerItem(size, multiMediaData);
            this.mCoverStickerDataList.add(size, multiMediaData);
        }
    }

    public void setCoverStickerDataList(List<MultiMediaData> list) {
        boolean z;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, list) == null) || ab9.e(list)) {
            return;
        }
        this.mCoverStickerDataList = list;
        for (int i = 0; i < this.mCoverStickerDataList.size(); i++) {
            MultiMediaData multiMediaData = this.mCoverStickerDataList.get(i);
            int i2 = 0;
            while (true) {
                if (i2 >= this.mStickerItems.size()) {
                    z = true;
                    break;
                } else if (this.mStickerItems.get(i2).b().equals(multiMediaData)) {
                    z = false;
                    break;
                } else {
                    i2++;
                }
            }
            if (z) {
                initStickerItem(this.mStickerItems.size(), multiMediaData);
            }
        }
        if (this.mCurrentItem != null) {
            cancelStickerSelected();
        }
    }

    @Override // com.baidu.ugc.editvideo.record.renderer.MultiMediaEditBaseRenderer
    public void setCurrentItem(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, aVar) == null) {
            boolean z = aVar != this.mCurrentItem;
            super.setCurrentItem(aVar);
            List<a> list = this.mStickerItems;
            int indexOf = list.indexOf(aVar);
            ab9.h(list, indexOf, list.size() - 1);
            if (!ab9.e(this.mCoverStickerDataList)) {
                List<MultiMediaData> list2 = this.mCoverStickerDataList;
                ab9.h(list2, indexOf, list2.size() - 1);
            }
            if (z) {
                notifyStickerDataChange(StickerDataChangeType.SWAP);
            }
        }
    }

    public void setOnChangeStickerListener(OnChangeStickerListener onChangeStickerListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, onChangeStickerListener) == null) {
            setInnerOnChangeStickerListener(new OnChangeStickerListener(this, onChangeStickerListener) { // from class: com.baidu.ugc.editvideo.record.renderer.MultiMediaCoverStickerRenderer.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MultiMediaCoverStickerRenderer this$0;
                public final /* synthetic */ OnChangeStickerListener val$onChangeStickerListener;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, onChangeStickerListener};
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
                public void onChangeSticker(int i, MultiMediaData multiMediaData, String str) {
                    OnChangeStickerListener onChangeStickerListener2;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, multiMediaData, str) == null) || (onChangeStickerListener2 = this.val$onChangeStickerListener) == null) {
                        return;
                    }
                    onChangeStickerListener2.onChangeSticker(i, multiMediaData, str);
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
                public void onDeleteSticker(MultiMediaData multiMediaData, int i, String str, boolean z) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(1048580, this, new Object[]{multiMediaData, Integer.valueOf(i), str, Boolean.valueOf(z)}) == null) {
                        if (this.this$0.mCoverStickerDataList != null) {
                            this.this$0.mCoverStickerDataList.remove(multiMediaData);
                        }
                        OnChangeStickerListener onChangeStickerListener2 = this.val$onChangeStickerListener;
                        if (onChangeStickerListener2 != null) {
                            onChangeStickerListener2.onDeleteSticker(multiMediaData, i, str, z);
                        }
                    }
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
