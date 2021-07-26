package com.baidu.ugc.editvideo.record.renderer;

import android.graphics.PointF;
import android.opengl.Matrix;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
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
import d.a.w0.t.h;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
/* loaded from: classes5.dex */
public class MultiMediaEditBaseRenderer extends MediaBaseRenderer implements OnMediaPreviewTouchEventListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int STATUS_CLICK = 104;
    public static final int STATUS_DELETE = 101;
    public static final int STATUS_EDIT = 106;
    public static final int STATUS_IDLE = 100;
    public static final int STATUS_MOVE = 102;
    public static final int STATUS_POINTER_ROTATE = 105;
    public static final int STATUS_ROTATE = 103;
    public static final int TOUCH_OFFSET = 3;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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

    /* JADX WARN: Code restructure failed: missing block: B:19:0x004e, code lost:
        if (105 == r3) goto L12;
     */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0100  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void handleTouchDrag(float f2, float f3, float f4, float f5) {
        MultiMediaData b2;
        int i2;
        GLViewPortLocation gLViewPortLocation;
        float f6;
        float f7;
        OnChangeStickerListener onChangeStickerListener;
        GLViewPortLocation gLViewPortLocation2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65537, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)}) == null) || this.mCurrentItem == null || (b2 = this.mCurrentItem.b()) == null) {
            return;
        }
        float f8 = b2.x;
        float f9 = b2.y;
        int i3 = this.mSelectStatus;
        if (103 != i3) {
            if (102 == i3) {
                b2.x = f8 + f2;
                b2.y = f9 + f3;
                if (f2 > 0.0f || f3 > 0.0f) {
                    this.mChangeMoveProperty = true;
                }
            }
            i2 = this.mSelectStatus;
            if (105 != i2 || 103 == i2) {
                float min = Math.min(b2.scaleX, this.mMaxScale);
                b2.scaleX = min;
                b2.scaleX = Math.max(min, this.mMinScale);
                float min2 = Math.min(b2.scaleY, this.mMaxScale);
                b2.scaleY = min2;
                b2.scaleY = Math.max(min2, this.mMinScale);
            }
            if (102 == this.mSelectStatus && this.mCheckMoveBounds && (gLViewPortLocation2 = this.mGLViewPortLocation) != null) {
                float min3 = Math.min(b2.x, gLViewPortLocation2.width - (b2.width / 2.0f));
                b2.x = min3;
                b2.x = Math.max(min3, (-b2.width) / 2.0f);
                float min4 = Math.min(b2.y, this.mGLViewPortLocation.height - (b2.height / 2.0f));
                b2.y = min4;
                b2.y = Math.max(min4, (-b2.height) / 2.0f);
            }
            if (checkForSubline() && (gLViewPortLocation = this.mGLViewPortLocation) != null) {
                f6 = (gLViewPortLocation.width - b2.width) / 2.0f;
                f7 = (gLViewPortLocation.height - b2.height) / 2.0f;
                boolean z = false;
                if (Math.abs(f6 - b2.x) <= 3.0f) {
                    b2.x = f6;
                    if (Math.abs(f6 - f8) > 3.0f) {
                        z = true;
                    }
                }
                if (Math.abs(f7 - b2.y) <= 3.0f) {
                    b2.y = f7;
                    if (Math.abs(f7 - f9) > 3.0f) {
                        z = true;
                    }
                }
                onChangeStickerListener = this.mInnerOnChangeStickerListener;
                if (onChangeStickerListener != null && z) {
                    this.mChangeMoveProperty = true;
                    onChangeStickerListener.onAutoAdjust(this.mEditTrackType);
                }
            }
            if (this.mInnerOnChangeStickerListener == null && isEditStatus()) {
                this.mInnerOnChangeStickerListener.onChangeSticker(this.mSelectStatus, this.mCurrentItem.b(), this.mEditTrackType);
                return;
            }
        }
        float f10 = b2.angle + f5;
        b2.angle = f10;
        b2.angle = f10 % 360.0f;
        b2.scaleX *= f4;
        b2.scaleY *= f4;
        i2 = this.mSelectStatus;
        if (105 != i2) {
        }
        float min5 = Math.min(b2.scaleX, this.mMaxScale);
        b2.scaleX = min5;
        b2.scaleX = Math.max(min5, this.mMinScale);
        float min22 = Math.min(b2.scaleY, this.mMaxScale);
        b2.scaleY = min22;
        b2.scaleY = Math.max(min22, this.mMinScale);
        if (102 == this.mSelectStatus) {
            float min32 = Math.min(b2.x, gLViewPortLocation2.width - (b2.width / 2.0f));
            b2.x = min32;
            b2.x = Math.max(min32, (-b2.width) / 2.0f);
            float min42 = Math.min(b2.y, this.mGLViewPortLocation.height - (b2.height / 2.0f));
            b2.y = min42;
            b2.y = Math.max(min42, (-b2.height) / 2.0f);
        }
        if (checkForSubline()) {
            f6 = (gLViewPortLocation.width - b2.width) / 2.0f;
            f7 = (gLViewPortLocation.height - b2.height) / 2.0f;
            boolean z2 = false;
            if (Math.abs(f6 - b2.x) <= 3.0f) {
            }
            if (Math.abs(f7 - b2.y) <= 3.0f) {
            }
            onChangeStickerListener = this.mInnerOnChangeStickerListener;
            if (onChangeStickerListener != null) {
                this.mChangeMoveProperty = true;
                onChangeStickerListener.onAutoAdjust(this.mEditTrackType);
            }
        }
        if (this.mInnerOnChangeStickerListener == null) {
        }
    }

    private boolean handleTouchPress(float f2, float f3, float f4, float f5) {
        InterceptResult invokeCommon;
        boolean z;
        OnChangeStickerListener onChangeStickerListener;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)})) == null) {
            this.mSelectStatus = 100;
            this.mChangeMoveProperty = false;
            List<a> list = this.mVisibleStickerItems;
            ListIterator<a> listIterator = list.listIterator(list.size());
            while (listIterator.hasPrevious()) {
                a previous = listIterator.previous();
                if (previous != null && previous.a()) {
                    if (previous.c(f2, f3)) {
                        i2 = 101;
                    } else if (previous.b(f2, f3)) {
                        i2 = 103;
                    } else if (previous.d(f2, f3)) {
                        i2 = 106;
                    } else if (previous.a(f2, f3)) {
                        this.mSelectStatus = 102;
                        setCurrentItem(previous);
                        z = true;
                        break;
                    }
                    this.mSelectStatus = i2;
                    this.mCurrentItem = previous;
                    z = true;
                    break;
                }
            }
            z = false;
            if (this.mCurrentItem != null && this.mCurrentItem.a(f2, f3) && this.mCurrentItem.a(f4, f5)) {
                this.mSelectStatus = 105;
            }
            if (!z) {
                this.mCurrentItem = null;
            }
            if (this.mCurrentItem == null && (onChangeStickerListener = this.mInnerOnChangeStickerListener) != null) {
                onChangeStickerListener.onClickStickerOutside(this.mEditTrackType);
            }
            return this.mCurrentItem != null;
        }
        return invokeCommon.booleanValue;
    }

    private void handleTouchUp(float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            if (this.mCurrentItem == null) {
                this.mChangeMoveProperty = false;
                this.mSelectStatus = 100;
                return;
            }
            int i2 = this.mSelectStatus;
            if (i2 == 101) {
                deleteCurrentStickerItem(this.mCurrentItem, this.mEditTrackType, false);
            } else if (i2 == 106) {
                OnChangeStickerListener onChangeStickerListener = this.mInnerOnChangeStickerListener;
                if (onChangeStickerListener != null) {
                    onChangeStickerListener.onEditSticker(this.mCurrentItem.b(), this.mEditTrackType);
                }
            } else if (this.mChangeMoveProperty || !this.mCurrentItem.a(f2, f3)) {
                this.mSelectStatus = 100;
            } else {
                this.mSelectStatus = 104;
                OnChangeStickerListener onChangeStickerListener2 = this.mInnerOnChangeStickerListener;
                if (onChangeStickerListener2 != null) {
                    onChangeStickerListener2.onClickSticker(this.mCurrentItem.b(), this.mEditTrackType, false);
                }
            }
            this.mChangeMoveProperty = false;
        }
    }

    private boolean isEditStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            int i2 = this.mSelectStatus;
            return 103 == i2 || 102 == i2 || 105 == i2;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mCurrentItem != null && 102 == this.mSelectStatus && (TextUtils.equals(this.mEditTrackType, "text") || TextUtils.equals(this.mEditTrackType, SubtitleLog.TAG) || TextUtils.equals(this.mEditTrackType, "cover_sticker")) : invokeV.booleanValue;
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
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(1048579, this, aVar, str, z) == null) || aVar == null || h.e(this.mStickerItems)) {
            return;
        }
        if (TextUtils.equals(SubtitleLog.TAG, str)) {
            i2 = 0;
        } else {
            i2 = this.mStickerItems.indexOf(aVar);
            this.mStickerItems.remove(aVar);
            if (!h.e(this.mVisibleStickerItems)) {
                this.mVisibleStickerItems.remove(aVar);
            }
        }
        OnChangeStickerListener onChangeStickerListener = this.mInnerOnChangeStickerListener;
        if (onChangeStickerListener == null || i2 == -1) {
            return;
        }
        onChangeStickerListener.onDeleteSticker(aVar.b(), i2, str, z);
    }

    public void deleteStickerData(MultiMediaData multiMediaData, String str) {
        MultiMediaData b2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, multiMediaData, str) == null) || multiMediaData == null || TextUtils.isEmpty(str)) {
            return;
        }
        a aVar = null;
        for (int i2 = 0; i2 < this.mStickerItems.size() && ((aVar = this.mStickerItems.get(i2)) == null || (b2 = aVar.b()) == null || !b2.uuid.equals(multiMediaData.uuid)); i2++) {
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

    public boolean onTouchDown(float f2, float f3, float f4, float f5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)})) == null) ? handleTouchPress(f2, f3, f4, f5) : invokeCommon.booleanValue;
    }

    @Override // com.baidu.ugc.editvideo.record.preview.OnMediaPreviewTouchEventListener
    public void onTouchMove(float f2, float f3, float f4, float f5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)}) == null) {
            handleTouchDrag(f2, f3, f4, f5);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.preview.OnMediaPreviewTouchEventListener
    public void onTouchUp(float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            handleTouchUp(f2, f3);
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

    public void setStickerMaxScale(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048596, this, f2) == null) {
            this.mMaxScale = f2;
        }
    }

    public void setStickerMinScale(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048597, this, f2) == null) {
            this.mMinScale = f2;
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
