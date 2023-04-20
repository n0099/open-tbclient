package com.baidu.ugc.editvideo.record.renderer;

import android.graphics.PointF;
import android.opengl.Matrix;
import android.text.TextUtils;
import com.baidu.tieba.qha;
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
/* loaded from: classes7.dex */
public class MultiMediaEditBaseRenderer extends MediaBaseRenderer implements OnMediaPreviewTouchEventListener {
    public static final int STATUS_DELETE = 106;
    public static final int STATUS_EDIT = 105;
    public static final int STATUS_IDLE = 100;
    public static final int STATUS_IN = 101;
    public static final int STATUS_MOVE = 107;
    public static final int STATUS_OUT = 102;
    public static final int STATUS_POINTER_ROTATE = 103;
    public static final int STATUS_ROTATE = 104;
    public static final int TOUCH_OFFSET = 5;
    public boolean mChangeMoveProperty;
    public volatile a mCurrentItem;
    public String mCurrentStickerDataChangeType;
    public MultiMediaData mDeleteBtnData;
    public MultiMediaData mEditBtnData;
    public String mEditTrackType;
    public FullFrameRect mFrameRect;
    public OnChangeStickerListener mInnerOnChangeStickerListener;
    public MultiMediaData mRotationBtnData;
    public int mSelectStatus;
    public MultiMediaData mSublineData;
    public String TAG = "StickerRenderer";
    public float mMaxScale = 5.0f;
    public float mMinScale = 0.5f;
    public boolean mCheckMoveBounds = true;
    public float[] mProjectionMatrix = new float[16];
    public String mDeleteButtonPosition = "left_top";
    public String mRotationButtonPosition = "right_bottom";
    public List<a> mStickerItems = new ArrayList();
    public List<a> mVisibleStickerItems = new ArrayList();
    public String mEditButtonPosition = "right_top";

    private void handleTouchDrag(float f, float f2, float f3, float f4) {
        MultiMediaData b;
        GLViewPortLocation gLViewPortLocation;
        GLViewPortLocation gLViewPortLocation2;
        if (this.mCurrentItem == null || (b = this.mCurrentItem.b()) == null) {
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
        int i;
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

    private void handleTouchUp(float f, float f2) {
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

    private boolean isEditStatus() {
        int i = this.mSelectStatus;
        return 104 == i || 107 == i || 103 == i;
    }

    public MultiMediaData checkForInitBtn(MultiMediaData multiMediaData, String str) {
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

    public boolean checkForSubline() {
        return this.mCurrentItem != null && this.mSelectStatus == 107 && (TextUtils.equals(this.mEditTrackType, "text") || TextUtils.equals(this.mEditTrackType, SubtitleLog.TAG) || TextUtils.equals(this.mEditTrackType, "cover_sticker"));
    }

    public void createButtonTexture() {
        if (this.mFrameRect == null) {
            this.mFrameRect = new FullFrameRect(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D_LINE));
        }
        this.mDeleteBtnData = checkForInitBtn(this.mDeleteBtnData, "ic_delete");
        this.mRotationBtnData = checkForInitBtn(this.mRotationBtnData, "ic_scale");
        if (TextUtils.equals(this.mEditTrackType, "text") || TextUtils.equals(this.mEditTrackType, SubtitleLog.TAG) || TextUtils.equals(this.mEditTrackType, "cover_sticker")) {
            this.mEditBtnData = checkForInitBtn(this.mEditBtnData, "ic_edit");
        }
    }

    public void deleteCurrentStickerItem(a aVar, String str, boolean z) {
        int i;
        if (aVar == null || qha.e(this.mStickerItems)) {
            return;
        }
        if (TextUtils.equals(SubtitleLog.TAG, str)) {
            i = 0;
        } else {
            i = this.mStickerItems.indexOf(aVar);
            this.mStickerItems.remove(aVar);
            if (!qha.e(this.mVisibleStickerItems)) {
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
        if (multiMediaData == null || TextUtils.isEmpty(str)) {
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

    @Override // com.baidu.ugc.editvideo.record.preview.OnMediaPreviewTouchEventListener
    public PointF getStickerCenterPoint() {
        if (this.mCurrentItem != null) {
            return this.mCurrentItem.c();
        }
        return null;
    }

    public void moveBoundsCheckEnabled(boolean z) {
        this.mCheckMoveBounds = z;
    }

    public void notifyStickerDataChange(String str) {
        this.mCurrentStickerDataChangeType = str;
        if (TextUtils.equals("init", str)) {
            this.mCurrentItem = null;
        }
        OnChangeStickerListener onChangeStickerListener = this.mInnerOnChangeStickerListener;
        if (onChangeStickerListener != null) {
            onChangeStickerListener.onStickerDataChanged(str, this.mCurrentItem != null ? this.mCurrentItem.b() : null, this.mEditTrackType);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.renderer.MediaBaseRenderer, com.baidu.ugc.editvideo.record.IMediaLifeCycleIncludeGlThread
    public void onDestroyInGlThread() {
        super.onDestroyInGlThread();
        deleteTexture();
    }

    @Override // com.baidu.ugc.editvideo.record.renderer.MediaBaseRenderer, com.baidu.ugc.editvideo.record.renderer.IMediaRenderer
    public void onGLLocation(GLViewPortLocation gLViewPortLocation) {
        super.onGLLocation(gLViewPortLocation);
        Matrix.orthoM(this.mProjectionMatrix, 0, 0.0f, gLViewPortLocation.width, 0.0f, gLViewPortLocation.height, -1.0f, 1.0f);
    }

    @Override // com.baidu.ugc.editvideo.record.renderer.MediaBaseRenderer, com.baidu.ugc.editvideo.record.IMediaLifeCycleIncludeGlThread
    public void onPauseInGlThread() {
        super.onPauseInGlThread();
        deleteTexture();
    }

    @Override // com.baidu.ugc.editvideo.record.renderer.MediaBaseRenderer, com.baidu.ugc.editvideo.record.renderer.IMediaRenderer
    public void onSurfaceCreate(FullFrameRect fullFrameRect, FullFrameRect fullFrameRect2) {
        super.onSurfaceCreate(fullFrameRect, fullFrameRect2);
        createButtonTexture();
    }

    public boolean onTouchDown(float f, float f2, float f3, float f4) {
        return handleTouchPress(f, f2, f3, f4);
    }

    @Override // com.baidu.ugc.editvideo.record.preview.OnMediaPreviewTouchEventListener
    public void onTouchMove(float f, float f2, float f3, float f4) {
        handleTouchDrag(f, f2, f3, f4);
    }

    @Override // com.baidu.ugc.editvideo.record.preview.OnMediaPreviewTouchEventListener
    public void onTouchUp(float f, float f2) {
        handleTouchUp(f, f2);
    }

    public void setCurrentItem(a aVar) {
        this.mCurrentItem = aVar;
    }

    public void setInnerOnChangeStickerListener(OnChangeStickerListener onChangeStickerListener) {
        this.mInnerOnChangeStickerListener = onChangeStickerListener;
    }

    public void setStickerDeleteButton(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (this.mDeleteBtnData == null) {
            this.mDeleteBtnData = new MultiMediaData();
        }
        this.mDeleteBtnData.path = str;
        this.mDeleteButtonPosition = str2;
    }

    public void setStickerEditButton(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (this.mEditBtnData == null) {
            this.mEditBtnData = new MultiMediaData();
        }
        this.mEditBtnData.path = str;
        this.mEditButtonPosition = str2;
    }

    public void setStickerMaxScale(float f) {
        this.mMaxScale = f;
    }

    public void setStickerMinScale(float f) {
        this.mMinScale = f;
    }

    public void setStickerRotationButton(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (this.mRotationBtnData == null) {
            this.mRotationBtnData = new MultiMediaData();
        }
        this.mRotationBtnData.path = str;
        this.mRotationButtonPosition = str2;
    }

    public void setUpEditLayer(String str) {
        this.mEditTrackType = str;
    }
}
