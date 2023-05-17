package com.baidu.ugc.editvideo.record.renderer;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.text.TextUtils;
import com.baidu.searchbox.launch.stats.SpeedStatsStampTable;
import com.baidu.tieba.dg0;
import com.baidu.tieba.fna;
import com.baidu.tieba.gna;
import com.baidu.tieba.kna;
import com.baidu.ugc.editvideo.data.MultiMediaData;
import com.baidu.ugc.editvideo.faceunity.gles.FullFrameRect;
import com.baidu.ugc.editvideo.record.entity.GLViewPortLocation;
import com.baidu.ugc.editvideo.record.source.multimedia.utils.MultiDataSourceUtil;
import com.baidu.ugc.editvideo.sticker.OnChangeStickerListener;
import com.baidu.ugc.editvideo.sticker.StickerDataChangeType;
import com.baidu.ugc.editvideo.sticker.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class MultiMediaCoverStickerRenderer extends MultiMediaEditBaseRenderer {
    public List<MultiMediaData> mCoverStickerDataList = new ArrayList();

    private void initMultiMedia(MultiMediaData multiMediaData) {
        if (multiMediaData == null || TextUtils.isEmpty(multiMediaData.path) || multiMediaData.textureId != 0 || multiMediaData.type != 0) {
            return;
        }
        Bitmap decodeBitmap = MultiDataSourceUtil.decodeBitmap(multiMediaData.path);
        try {
            int type = GLUtils.getType(decodeBitmap);
            int internalFormat = GLUtils.getInternalFormat(decodeBitmap);
            fna.b("type : " + type + " internalFormat : " + internalFormat);
        } catch (Exception unused) {
            decodeBitmap = gna.c(decodeBitmap, Bitmap.CompressFormat.PNG, 100);
        }
        multiMediaData.textureId = MultiDataSourceUtil.initImageByBitmap(multiMediaData, decodeBitmap);
    }

    private void initStickerItem(int i, MultiMediaData multiMediaData) {
        initMultiMedia(multiMediaData);
        a aVar = new a(multiMediaData);
        this.mStickerItems.add(i, aVar);
        this.mCurrentItem = aVar;
    }

    public void cancelStickerSelected() {
        this.mCurrentStickerDataChangeType = "init";
        this.mCurrentItem = null;
    }

    public void deleteCoverStickerData(MultiMediaData multiMediaData) {
        if (multiMediaData == null) {
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
        kna.g(this.mCoverStickerDataList, i);
        deleteStickerData(multiMediaData, "cover_sticker");
    }

    @Override // com.baidu.ugc.editvideo.record.renderer.MultiMediaEditBaseRenderer
    public void deleteTexture() {
        super.deleteTexture();
        if (kna.e(this.mCoverStickerDataList)) {
            return;
        }
        for (MultiMediaData multiMediaData : this.mCoverStickerDataList) {
            MultiDataSourceUtil.glDeleteTextures(multiMediaData);
        }
    }

    public List<MultiMediaData> getCoverStickerDataList() {
        return this.mCoverStickerDataList;
    }

    @Override // com.baidu.ugc.editvideo.record.renderer.MediaBaseRenderer, com.baidu.ugc.editvideo.record.renderer.IMediaRenderer
    public void onDrawFrame(dg0 dg0Var, int i, float[] fArr) {
        if (dg0Var == null || this.mCoverStickerDataList == null || !TextUtils.equals(this.mEditTrackType, "cover_sticker")) {
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
        super.onSurfaceCreate(fullFrameRect, fullFrameRect2);
        reInitMultiMediaList();
    }

    @Override // com.baidu.ugc.editvideo.record.renderer.MultiMediaEditBaseRenderer, com.baidu.ugc.editvideo.record.preview.OnMediaPreviewTouchEventListener
    public boolean onTouchDown(float f, float f2, float f3, float f4) {
        if (kna.e(this.mCoverStickerDataList)) {
            return false;
        }
        this.mVisibleStickerItems.clear();
        if (TextUtils.equals(this.mEditTrackType, "cover_sticker")) {
            this.mVisibleStickerItems.addAll(this.mStickerItems);
        }
        return super.onTouchDown(f, f2, f3, f4);
    }

    public void reInitMultiMediaList() {
        if (kna.e(this.mCoverStickerDataList)) {
            return;
        }
        for (int i = 0; i < this.mCoverStickerDataList.size(); i++) {
            initMultiMedia(this.mCoverStickerDataList.get(i));
        }
    }

    public void replaceCoverStickerData(MultiMediaData multiMediaData) {
        if (multiMediaData == null) {
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
        kna.g(this.mStickerItems, i);
        MultiDataSourceUtil.glDeleteTextures(multiMediaData);
        initStickerItem(i, multiMediaData);
    }

    public void setCoverStickerData(MultiMediaData multiMediaData) {
        if (multiMediaData == null) {
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
        if (kna.e(list)) {
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
        boolean z = aVar != this.mCurrentItem;
        super.setCurrentItem(aVar);
        List<a> list = this.mStickerItems;
        int indexOf = list.indexOf(aVar);
        kna.h(list, indexOf, list.size() - 1);
        if (!kna.e(this.mCoverStickerDataList)) {
            List<MultiMediaData> list2 = this.mCoverStickerDataList;
            kna.h(list2, indexOf, list2.size() - 1);
        }
        if (z) {
            notifyStickerDataChange(StickerDataChangeType.SWAP);
        }
    }

    public void setOnChangeStickerListener(final OnChangeStickerListener onChangeStickerListener) {
        setInnerOnChangeStickerListener(new OnChangeStickerListener() { // from class: com.baidu.ugc.editvideo.record.renderer.MultiMediaCoverStickerRenderer.1
            @Override // com.baidu.ugc.editvideo.sticker.OnChangeStickerListener
            public void onAutoAdjust(String str) {
                OnChangeStickerListener onChangeStickerListener2 = onChangeStickerListener;
                if (onChangeStickerListener2 != null) {
                    onChangeStickerListener2.onAutoAdjust(str);
                }
            }

            @Override // com.baidu.ugc.editvideo.sticker.OnChangeStickerListener
            public void onChangeSticker(int i, MultiMediaData multiMediaData, String str) {
                OnChangeStickerListener onChangeStickerListener2 = onChangeStickerListener;
                if (onChangeStickerListener2 != null) {
                    onChangeStickerListener2.onChangeSticker(i, multiMediaData, str);
                }
            }

            @Override // com.baidu.ugc.editvideo.sticker.OnChangeStickerListener
            public void onClickSticker(MultiMediaData multiMediaData, String str, boolean z) {
                OnChangeStickerListener onChangeStickerListener2 = onChangeStickerListener;
                if (onChangeStickerListener2 != null) {
                    onChangeStickerListener2.onClickSticker(multiMediaData, str, z);
                }
            }

            @Override // com.baidu.ugc.editvideo.sticker.OnChangeStickerListener
            public void onClickStickerOutside(String str) {
                OnChangeStickerListener onChangeStickerListener2 = onChangeStickerListener;
                if (onChangeStickerListener2 != null) {
                    onChangeStickerListener2.onClickStickerOutside(str);
                }
            }

            @Override // com.baidu.ugc.editvideo.sticker.OnChangeStickerListener
            public void onDeleteSticker(MultiMediaData multiMediaData, int i, String str, boolean z) {
                if (MultiMediaCoverStickerRenderer.this.mCoverStickerDataList != null) {
                    MultiMediaCoverStickerRenderer.this.mCoverStickerDataList.remove(multiMediaData);
                }
                OnChangeStickerListener onChangeStickerListener2 = onChangeStickerListener;
                if (onChangeStickerListener2 != null) {
                    onChangeStickerListener2.onDeleteSticker(multiMediaData, i, str, z);
                }
            }

            @Override // com.baidu.ugc.editvideo.sticker.OnChangeStickerListener
            public void onEditSticker(MultiMediaData multiMediaData, String str) {
                OnChangeStickerListener onChangeStickerListener2 = onChangeStickerListener;
                if (onChangeStickerListener2 != null) {
                    onChangeStickerListener2.onEditSticker(multiMediaData, str);
                }
            }

            @Override // com.baidu.ugc.editvideo.sticker.OnChangeStickerListener
            public void onStickerDataChanged(String str, MultiMediaData multiMediaData, String str2) {
                OnChangeStickerListener onChangeStickerListener2 = onChangeStickerListener;
                if (onChangeStickerListener2 != null) {
                    onChangeStickerListener2.onStickerDataChanged(str, multiMediaData, str2);
                }
            }
        });
    }
}
