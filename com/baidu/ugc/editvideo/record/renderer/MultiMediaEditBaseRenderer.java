package com.baidu.ugc.editvideo.record.renderer;

import android.graphics.PointF;
import android.opengl.Matrix;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.vg9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.data.MultiMediaData;
import com.baidu.ugc.editvideo.faceunity.gles.FullFrameRect;
import com.baidu.ugc.editvideo.faceunity.gles.Texture2dProgram;
import com.baidu.ugc.editvideo.record.entity.GLViewPortLocation;
import com.baidu.ugc.editvideo.record.preview.OnMediaPreviewTouchEventListener;
import com.baidu.ugc.editvideo.record.source.multimedia.utils.MultiDataSourceUtil;
import com.baidu.ugc.editvideo.sticker.OnChangeStickerListener;
import com.baidu.ugc.editvideo.sticker.a;
import com.baidu.ugc.editvideo.subtitle.SubtitleLog;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
/* loaded from: classes6.dex */
public class MultiMediaEditBaseRenderer extends MediaBaseRenderer implements OnMediaPreviewTouchEventListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int STATUS_DELETE = 106;
    public static final int STATUS_EDIT = 105;
    public static final int STATUS_IDLE = 100;
    public static final int STATUS_IN = 101;
    public static final int STATUS_MOVE = 107;
    public static final int STATUS_OUT = 102;
    public static final int STATUS_POINTER_ROTATE = 103;
    public static final int STATUS_ROTATE = 104;
    public static final int TOUCH_OFFSET = 5;
    public transient /* synthetic */ FieldHolder $fh;
    public String TAG;
    public boolean mChangeMoveProperty;
    public boolean mCheckMoveBounds;
    public volatile a mCurrentItem;
    public String mCurrentStickerDataChangeType;
    public MultiMediaData mDeleteBtnData;
    public String mDeleteButtonPosition;
    public MultiMediaData mEditBtnData;
    public String mEditButtonPosition;
    public String mEditTrackType;
    public FullFrameRect mFrameRect;
    public OnChangeStickerListener mInnerOnChangeStickerListener;
    public float mMaxScale;
    public float mMinScale;
    public float[] mProjectionMatrix;
    public MultiMediaData mRotationBtnData;
    public String mRotationButtonPosition;
    public int mSelectStatus;
    public List<a> mStickerItems;
    public MultiMediaData mSublineData;
    public List<a> mVisibleStickerItems;

    public MultiMediaEditBaseRenderer() {
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
        this.TAG = "StickerRenderer";
        this.mMaxScale = 5.0f;
        this.mMinScale = 0.5f;
        this.mCheckMoveBounds = true;
        this.mProjectionMatrix = new float[16];
        this.mDeleteButtonPosition = "left_top";
        this.mRotationButtonPosition = "right_bottom";
        this.mStickerItems = new ArrayList();
        this.mVisibleStickerItems = new ArrayList();
        this.mEditButtonPosition = "right_top";
    }

    private void handleTouchDrag(float f, float f2, float f3, float f4) {
        MultiMediaData b;
        GLViewPortLocation gLViewPortLocation;
        GLViewPortLocation gLViewPortLocation2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65537, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) || this.mCurrentItem == null || (b = this.mCurrentItem.b()) == null) {
            return;
        }
        float f5 = b.x;
        float f6 = b.y;
        int i = this.mSelectStatus;
        if (104 == i || 103 == i) {
            float f7 = b.angle + f4;
            b.angle = f7;
            b.angle = f7 % 360.0f;
            b.scaleX *= f3;
            b.scaleY *= f3;
        } else {
            b.x = f5 + f;
            b.y = f6 + f2;
            if (f > 0.0f || f2 > 0.0f) {
                this.mSelectStatus = 107;
                this.mChangeMoveProperty = true;
            }
        }
        int i2 = this.mSelectStatus;
        if (103 == i2 || 104 == i2) {
            float min = Math.min(b.scaleX, this.mMaxScale);
            b.scaleX = min;
            b.scaleX = Math.max(min, this.mMinScale);
            float min2 = Math.min(b.scaleY, this.mMaxScale);
            b.scaleY = min2;
            b.scaleY = Math.max(min2, this.mMinScale);
        }
        if (107 == this.mSelectStatus && this.mCheckMoveBounds && (gLViewPortLocation2 = this.mGLViewPortLocation) != null) {
            float min3 = Math.min(b.x, gLViewPortLocation2.width - (b.width / 2.0f));
            b.x = min3;
            b.x = Math.max(min3, (-b.width) / 2.0f);
            float min4 = Math.min(b.y, this.mGLViewPortLocation.height - (b.height / 2.0f));
            b.y = min4;
            b.y = Math.max(min4, (-b.height) / 2.0f);
        }
        if (checkForSubline() && (gLViewPortLocation = this.mGLViewPortLocation) != null) {
            float f8 = (gLViewPortLocation.width - b.width) / 2.0f;
            float f9 = (gLViewPortLocation.height - b.height) / 2.0f;
            boolean z = false;
            if (Math.abs(f8 - b.x) <= 5.0f) {
                b.x = f8;
                if (Math.abs(f8 - f5) > 5.0f) {
                    z = true;
                }
            }
            if (Math.abs(f9 - b.y) <= 5.0f) {
                b.y = f9;
                if (Math.abs(f9 - f6) > 5.0f) {
                    z = true;
                }
            }
            OnChangeStickerListener onChangeStickerListener = this.mInnerOnChangeStickerListener;
            if (onChangeStickerListener != null && z) {
                this.mChangeMoveProperty = true;
                onChangeStickerListener.onAutoAdjust(this.mEditTrackType);
            }
        }
        if (this.mInnerOnChangeStickerListener == null || !isEditStatus()) {
            return;
        }
        this.mInnerOnChangeStickerListener.onChangeSticker(this.mSelectStatus, this.mCurrentItem.b(), this.mEditTrackType);
    }

    private boolean handleTouchPress(float f, float f2, float f3, float f4) {
        InterceptResult invokeCommon;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) {
            this.mChangeMoveProperty = false;
            if (this.mSelectStatus == 100 || this.mCurrentItem == null) {
                List<a> list = this.mVisibleStickerItems;
                ListIterator<a> listIterator = list.listIterator(list.size());
                while (true) {
                    if (!listIterator.hasPrevious()) {
                        break;
                    }
                    a previous = listIterator.previous();
                    if (previous != null && previous.a()) {
                        if (previous.a(f, f2)) {
                            this.mSelectStatus = 101;
                            setCurrentItem(previous);
                            break;
                        }
                        this.mSelectStatus = 102;
                    }
                }
            } else {
                if (this.mCurrentItem.c(f, f2)) {
                    i = 106;
                } else if (this.mCurrentItem.b(f, f2)) {
                    i = 104;
                } else if (this.mCurrentItem.d(f, f2)) {
                    i = 105;
                } else {
                    if (this.mCurrentItem.a(f, f2)) {
                        this.mSelectStatus = 101;
                    } else {
                        this.mSelectStatus = 102;
                    }
                    if (this.mCurrentItem != null && f3 > -2.1474836E9f && f4 > -2.1474836E9f) {
                        this.mSelectStatus = 103;
                    }
                }
                this.mSelectStatus = i;
                if (this.mCurrentItem != null) {
                    this.mSelectStatus = 103;
                }
            }
            return this.mCurrentItem != null;
        }
        return invokeCommon.booleanValue;
    }

    private void handleTouchUp(float f, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)}) == null) {
            if (this.mCurrentItem == null) {
                this.mChangeMoveProperty = false;
                this.mSelectStatus = 100;
                return;
            }
            int i = this.mSelectStatus;
            if (i != 106) {
                if (i == 105) {
                    OnChangeStickerListener onChangeStickerListener = this.mInnerOnChangeStickerListener;
                    if (onChangeStickerListener != null) {
                        onChangeStickerListener.onEditSticker(this.mCurrentItem.b(), this.mEditTrackType);
                    }
                } else if (this.mChangeMoveProperty || !this.mCurrentItem.a(f, f2)) {
                    int i2 = this.mSelectStatus;
                    if (i2 == 102) {
                        if (this.mCurrentItem != null && this.mInnerOnChangeStickerListener != null) {
                            this.mCurrentItem = null;
                            this.mInnerOnChangeStickerListener.onClickStickerOutside(this.mEditTrackType);
                        }
                    } else if (i2 == 107) {
                        this.mSelectStatus = 101;
                    }
                } else {
                    OnChangeStickerListener onChangeStickerListener2 = this.mInnerOnChangeStickerListener;
                    if (onChangeStickerListener2 != null) {
                        onChangeStickerListener2.onClickSticker(this.mCurrentItem.b(), this.mEditTrackType, false);
                    }
                }
                this.mChangeMoveProperty = false;
            }
            deleteCurrentStickerItem(this.mCurrentItem, this.mEditTrackType, false);
            this.mSelectStatus = 100;
            this.mChangeMoveProperty = false;
        }
    }

    private boolean isEditStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            int i = this.mSelectStatus;
            return 104 == i || 107 == i || 103 == i;
        }
        return invokeV.booleanValue;
    }

    public MultiMediaData checkForInitBtn(MultiMediaData multiMediaData, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, multiMediaData, str)) == null) {
            if (multiMediaData == null) {
                multiMediaData = new MultiMediaData();
            }
            if (multiMediaData.textureId == 0) {
                if (!TextUtils.isEmpty(multiMediaData.path)) {
                    str = multiMediaData.path;
                }
                multiMediaData.textureId = MultiDataSourceUtil.initImageByBitmap(multiMediaData, MultiDataSourceUtil.decodeBitmap(str));
            }
            return multiMediaData;
        }
        return (MultiMediaData) invokeLL.objValue;
    }

    public boolean checkForSubline() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mCurrentItem != null && this.mSelectStatus == 107 && (TextUtils.equals(this.mEditTrackType, "text") || TextUtils.equals(this.mEditTrackType, SubtitleLog.TAG) || TextUtils.equals(this.mEditTrackType, "cover_sticker")) : invokeV.booleanValue;
    }

    public void createButtonTexture() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.mFrameRect == null) {
                this.mFrameRect = new FullFrameRect(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D_LINE));
            }
            this.mDeleteBtnData = checkForInitBtn(this.mDeleteBtnData, "ic_delete");
            this.mRotationBtnData = checkForInitBtn(this.mRotationBtnData, "ic_scale");
            if (TextUtils.equals(this.mEditTrackType, "text") || TextUtils.equals(this.mEditTrackType, SubtitleLog.TAG) || TextUtils.equals(this.mEditTrackType, "cover_sticker")) {
                this.mEditBtnData = checkForInitBtn(this.mEditBtnData, "ic_edit");
            }
        }
    }

    public void deleteCurrentStickerItem(a aVar, String str, boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(1048579, this, aVar, str, z) == null) || aVar == null || vg9.e(this.mStickerItems)) {
            return;
        }
        if (TextUtils.equals(SubtitleLog.TAG, str)) {
            i = 0;
        } else {
            i = this.mStickerItems.indexOf(aVar);
            this.mStickerItems.remove(aVar);
            if (!vg9.e(this.mVisibleStickerItems)) {
                this.mVisibleStickerItems.remove(aVar);
            }
        }
        OnChangeStickerListener onChangeStickerListener = this.mInnerOnChangeStickerListener;
        if (onChangeStickerListener == null || i == -1) {
            return;
        }
        onChangeStickerListener.onDeleteSticker(aVar.b(), i, str, z);
    }

    public void deleteStickerData(MultiMediaData multiMediaData, String str) {
        MultiMediaData b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, multiMediaData, str) == null) || multiMediaData == null || TextUtils.isEmpty(str)) {
            return;
        }
        a aVar = null;
        for (int i = 0; i < this.mStickerItems.size() && ((aVar = this.mStickerItems.get(i)) == null || (b = aVar.b()) == null || !b.uuid.equals(multiMediaData.uuid)); i++) {
        }
        if (aVar == null) {
            return;
        }
        deleteCurrentStickerItem(aVar, str, true);
    }

    public void deleteTexture() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            for (a aVar : this.mStickerItems) {
                aVar.d();
            }
            MultiDataSourceUtil.glDeleteTextures(this.mDeleteBtnData);
            MultiDataSourceUtil.glDeleteTextures(this.mRotationBtnData);
            MultiDataSourceUtil.glDeleteTextures(this.mEditBtnData);
            MultiDataSourceUtil.glDeleteTextures(this.mSublineData);
            FullFrameRect fullFrameRect = this.mFrameRect;
            if (fullFrameRect != null) {
                fullFrameRect.release(true);
                this.mFrameRect = null;
            }
        }
    }

    @Override // com.baidu.ugc.editvideo.record.preview.OnMediaPreviewTouchEventListener
    public PointF getStickerCenterPoint() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.mCurrentItem != null) {
                return this.mCurrentItem.c();
            }
            return null;
        }
        return (PointF) invokeV.objValue;
    }

    public void moveBoundsCheckEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.mCheckMoveBounds = z;
        }
    }

    public void notifyStickerDataChange(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.mCurrentStickerDataChangeType = str;
            if (TextUtils.equals("init", str)) {
                this.mCurrentItem = null;
            }
            OnChangeStickerListener onChangeStickerListener = this.mInnerOnChangeStickerListener;
            if (onChangeStickerListener != null) {
                onChangeStickerListener.onStickerDataChanged(str, this.mCurrentItem != null ? this.mCurrentItem.b() : null, this.mEditTrackType);
            }
        }
    }

    @Override // com.baidu.ugc.editvideo.record.renderer.MediaBaseRenderer, com.baidu.ugc.editvideo.record.IMediaLifeCycleIncludeGlThread
    public void onDestroyInGlThread() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onDestroyInGlThread();
            deleteTexture();
        }
    }

    @Override // com.baidu.ugc.editvideo.record.renderer.MediaBaseRenderer, com.baidu.ugc.editvideo.record.renderer.IMediaRenderer
    public void onGLLocation(GLViewPortLocation gLViewPortLocation) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, gLViewPortLocation) == null) {
            super.onGLLocation(gLViewPortLocation);
            Matrix.orthoM(this.mProjectionMatrix, 0, 0.0f, gLViewPortLocation.width, 0.0f, gLViewPortLocation.height, -1.0f, 1.0f);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.renderer.MediaBaseRenderer, com.baidu.ugc.editvideo.record.IMediaLifeCycleIncludeGlThread
    public void onPauseInGlThread() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onPauseInGlThread();
            deleteTexture();
        }
    }

    @Override // com.baidu.ugc.editvideo.record.renderer.MediaBaseRenderer, com.baidu.ugc.editvideo.record.renderer.IMediaRenderer
    public void onSurfaceCreate(FullFrameRect fullFrameRect, FullFrameRect fullFrameRect2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, fullFrameRect, fullFrameRect2) == null) {
            super.onSurfaceCreate(fullFrameRect, fullFrameRect2);
            createButtonTexture();
        }
    }

    public boolean onTouchDown(float f, float f2, float f3, float f4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) ? handleTouchPress(f, f2, f3, f4) : invokeCommon.booleanValue;
    }

    @Override // com.baidu.ugc.editvideo.record.preview.OnMediaPreviewTouchEventListener
    public void onTouchMove(float f, float f2, float f3, float f4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) {
            handleTouchDrag(f, f2, f3, f4);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.preview.OnMediaPreviewTouchEventListener
    public void onTouchUp(float f, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)}) == null) {
            handleTouchUp(f, f2);
        }
    }

    public void setCurrentItem(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, aVar) == null) {
            this.mCurrentItem = aVar;
        }
    }

    public void setInnerOnChangeStickerListener(OnChangeStickerListener onChangeStickerListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, onChangeStickerListener) == null) {
            this.mInnerOnChangeStickerListener = onChangeStickerListener;
        }
    }

    public void setStickerDeleteButton(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048594, this, str, str2) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        if (this.mDeleteBtnData == null) {
            this.mDeleteBtnData = new MultiMediaData();
        }
        this.mDeleteBtnData.path = str;
        this.mDeleteButtonPosition = str2;
    }

    public void setStickerEditButton(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048595, this, str, str2) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        if (this.mEditBtnData == null) {
            this.mEditBtnData = new MultiMediaData();
        }
        this.mEditBtnData.path = str;
        this.mEditButtonPosition = str2;
    }

    public void setStickerMaxScale(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048596, this, f) == null) {
            this.mMaxScale = f;
        }
    }

    public void setStickerMinScale(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048597, this, f) == null) {
            this.mMinScale = f;
        }
    }

    public void setStickerRotationButton(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048598, this, str, str2) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        if (this.mRotationBtnData == null) {
            this.mRotationBtnData = new MultiMediaData();
        }
        this.mRotationBtnData.path = str;
        this.mRotationButtonPosition = str2;
    }

    public void setUpEditLayer(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, str) == null) {
            this.mEditTrackType = str;
        }
    }
}
