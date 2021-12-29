package com.baidu.ugc.editvideo.record.renderer;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.a1.t.c;
import c.a.a1.t.d;
import c.a.a1.t.h;
import c.a.b0.b.a.e;
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
import com.baidu.wallet.paysdk.banksign.beans.BankSignFactory;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes13.dex */
public class MultiMediaCoverStickerRenderer extends MultiMediaEditBaseRenderer {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<MultiMediaData> mCoverStickerDataList;

    public MultiMediaCoverStickerRenderer() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
                c.b("type : " + type + " internalFormat : " + internalFormat);
            } catch (Exception unused) {
                decodeBitmap = d.c(decodeBitmap, Bitmap.CompressFormat.PNG, 100);
            }
            multiMediaData.textureId = MultiDataSourceUtil.initImageByBitmap(multiMediaData, decodeBitmap);
        }
    }

    private void initStickerItem(int i2, MultiMediaData multiMediaData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65539, this, i2, multiMediaData) == null) {
            initMultiMedia(multiMediaData);
            a aVar = new a(multiMediaData);
            this.mStickerItems.add(i2, aVar);
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
        int i2 = -1;
        int i3 = 0;
        while (true) {
            if (i3 >= this.mCoverStickerDataList.size()) {
                break;
            } else if (multiMediaData.equals(this.mCoverStickerDataList.get(i3))) {
                i2 = i3;
                break;
            } else {
                i3++;
            }
        }
        h.g(this.mCoverStickerDataList, i2);
        deleteStickerData(multiMediaData, "cover_sticker");
    }

    @Override // com.baidu.ugc.editvideo.record.renderer.MultiMediaEditBaseRenderer
    public void deleteTexture() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.deleteTexture();
            if (h.e(this.mCoverStickerDataList)) {
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
    public void onDrawFrame(e eVar, int i2, float[] fArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(1048580, this, eVar, i2, fArr) == null) || eVar == null || this.mCoverStickerDataList == null || !TextUtils.equals(this.mEditTrackType, "cover_sticker")) {
            return;
        }
        GLViewPortLocation gLViewPortLocation = this.mGLViewPortLocation;
        float f2 = this.mScaleX;
        int i3 = gLViewPortLocation.width;
        float f3 = this.mScaleY;
        int i4 = gLViewPortLocation.height;
        GLES20.glViewport((int) (gLViewPortLocation.x + (((1.0f - f2) * i3) / 2.0f) + ((i3 * this.mTx) / 2.0f)), (int) (gLViewPortLocation.y + (((1.0f - f3) * i4) / 2.0f) + ((i4 * this.mTy) / 2.0f)), (int) (i3 * f2), (int) (i4 * f3));
        GLES20.glEnable(SpeedStatsStampTable.MAINACTIVITY_ONRESUME_END_STAMP_KEY);
        GLES20.glBlendFunc(1, BankSignFactory.BEAN_ID_BIND_CARD);
        for (int i5 = 0; i5 < this.mCoverStickerDataList.size(); i5++) {
            MultiMediaData multiMediaData = this.mCoverStickerDataList.get(i5);
            if (multiMediaData != null && multiMediaData.textureId != 0) {
                a aVar = this.mStickerItems.get(i5);
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
    public boolean onTouchDown(float f2, float f3, float f4, float f5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)})) == null) {
            if (h.e(this.mCoverStickerDataList)) {
                return false;
            }
            this.mVisibleStickerItems.clear();
            if (TextUtils.equals(this.mEditTrackType, "cover_sticker")) {
                this.mVisibleStickerItems.addAll(this.mStickerItems);
            }
            return super.onTouchDown(f2, f3, f4, f5);
        }
        return invokeCommon.booleanValue;
    }

    public void reInitMultiMediaList() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || h.e(this.mCoverStickerDataList)) {
            return;
        }
        for (int i2 = 0; i2 < this.mCoverStickerDataList.size(); i2++) {
            initMultiMedia(this.mCoverStickerDataList.get(i2));
        }
    }

    public void replaceCoverStickerData(MultiMediaData multiMediaData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, multiMediaData) == null) || multiMediaData == null) {
            return;
        }
        int i2 = 0;
        while (true) {
            if (i2 >= this.mCoverStickerDataList.size()) {
                i2 = -1;
                break;
            } else if (multiMediaData.equals(this.mCoverStickerDataList.get(i2))) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 == -1 || i2 >= this.mStickerItems.size()) {
            return;
        }
        h.g(this.mStickerItems, i2);
        MultiDataSourceUtil.glDeleteTextures(multiMediaData);
        initStickerItem(i2, multiMediaData);
    }

    public void setCoverStickerData(MultiMediaData multiMediaData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, multiMediaData) == null) || multiMediaData == null) {
            return;
        }
        boolean z = false;
        int i2 = 0;
        while (true) {
            if (i2 >= this.mCoverStickerDataList.size()) {
                z = true;
                break;
            } else if (multiMediaData.equals(this.mCoverStickerDataList.get(i2))) {
                break;
            } else {
                i2++;
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
        if (!(interceptable == null || interceptable.invokeL(1048586, this, list) == null) || h.e(list)) {
            return;
        }
        this.mCoverStickerDataList = list;
        for (int i2 = 0; i2 < this.mCoverStickerDataList.size(); i2++) {
            MultiMediaData multiMediaData = this.mCoverStickerDataList.get(i2);
            int i3 = 0;
            while (true) {
                if (i3 >= this.mStickerItems.size()) {
                    z = true;
                    break;
                } else if (this.mStickerItems.get(i3).b().equals(multiMediaData)) {
                    z = false;
                    break;
                } else {
                    i3++;
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
            h.h(list, indexOf, list.size() - 1);
            if (!h.e(this.mCoverStickerDataList)) {
                List<MultiMediaData> list2 = this.mCoverStickerDataList;
                h.h(list2, indexOf, list2.size() - 1);
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
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(1048580, this, new Object[]{multiMediaData, Integer.valueOf(i2), str, Boolean.valueOf(z)}) == null) {
                        if (this.this$0.mCoverStickerDataList != null) {
                            this.this$0.mCoverStickerDataList.remove(multiMediaData);
                        }
                        OnChangeStickerListener onChangeStickerListener2 = this.val$onChangeStickerListener;
                        if (onChangeStickerListener2 != null) {
                            onChangeStickerListener2.onDeleteSticker(multiMediaData, i2, str, z);
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
