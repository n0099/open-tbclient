package com.baidu.ugc.editvideo.record.renderer;

import android.opengl.GLES20;
import android.text.TextUtils;
import com.baidu.minivideo.effect.core.vlogedit.MediaSegment;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrack;
import com.baidu.minivideo.plugin.capture.bean.FaceItem;
import com.baidu.searchbox.launch.stats.SpeedStatsStampTable;
import com.baidu.tieba.dg0;
import com.baidu.tieba.kna;
import com.baidu.ugc.editvideo.data.MultiMediaData;
import com.baidu.ugc.editvideo.data.MultiMediaDataTrack;
import com.baidu.ugc.editvideo.record.entity.GLViewPortLocation;
import com.baidu.ugc.editvideo.record.source.multimedia.utils.MultiDataSourceUtil;
import com.baidu.ugc.editvideo.sticker.OnChangeStickerListener;
import com.baidu.ugc.editvideo.sticker.StickerDataChangeType;
import com.baidu.ugc.editvideo.sticker.a;
import com.baidu.ugc.editvideo.subtitle.SubtitleLog;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class MultiMediaStickerRenderer extends MultiMediaEditBaseRenderer {
    public long mCurrentPos;
    public MultiMediaDataTrack mMultiMediaDataTrack;
    public MediaTrack mSubtitleAndStickerTrack;
    public List<a> mTempStickerItemList;

    private void checkDataChange() {
        if (this.mMultiMediaDataTrack == null || this.mSubtitleAndStickerTrack == null) {
            return;
        }
        if (this.mTempStickerItemList == null) {
            this.mTempStickerItemList = new ArrayList();
        }
        this.mTempStickerItemList.addAll(this.mStickerItems);
        this.mStickerItems.clear();
        int size = this.mMultiMediaDataTrack.multiMediaDataList.size();
        for (int i = 0; i < size; i++) {
            a aVar = new a(this.mMultiMediaDataTrack.multiMediaDataList.get(i));
            this.mStickerItems.add(aVar);
            if (i == size - 1) {
                if (TextUtils.equals(this.mCurrentStickerDataChangeType, "init")) {
                    this.mCurrentItem = null;
                } else {
                    this.mCurrentItem = aVar;
                }
            }
        }
    }

    private void releaseTempStickerItemList() {
        if (kna.e(this.mTempStickerItemList)) {
            return;
        }
        for (a aVar : this.mTempStickerItemList) {
            aVar.d();
        }
        this.mTempStickerItemList.clear();
    }

    public void cancelStickerSelected() {
        this.mCurrentStickerDataChangeType = "init";
        this.mCurrentItem = null;
    }

    @Override // com.baidu.ugc.editvideo.record.renderer.MultiMediaEditBaseRenderer
    public void deleteTexture() {
        List<MultiMediaData> list;
        List<MediaSegment> list2;
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

    @Override // com.baidu.ugc.editvideo.record.renderer.MediaBaseRenderer, com.baidu.ugc.editvideo.record.renderer.IMediaRenderer
    public void onDrawFrame(dg0 dg0Var, int i, float[] fArr) {
        MediaTrack mediaTrack;
        MultiMediaDataTrack multiMediaDataTrack;
        List<MediaSegment> list;
        if (dg0Var == null || (mediaTrack = this.mSubtitleAndStickerTrack) == null || (multiMediaDataTrack = this.mMultiMediaDataTrack) == null || (list = mediaTrack.mediaSegments) == null || multiMediaDataTrack.multiMediaDataList == null || this.mStickerItems == null || list.size() != this.mMultiMediaDataTrack.multiMediaDataList.size() || this.mStickerItems.size() == 0 || this.mStickerItems.size() != this.mMultiMediaDataTrack.multiMediaDataList.size()) {
            return;
        }
        this.mCurrentPos = dg0Var.b();
        releaseTempStickerItemList();
        GLViewPortLocation gLViewPortLocation = this.mGLViewPortLocation;
        float f = this.mScaleX;
        int i2 = gLViewPortLocation.width;
        int i3 = (int) (gLViewPortLocation.x + (((1.0f - f) * i2) / 2.0f) + ((i2 * this.mTx) / 2.0f));
        float f2 = this.mScaleY;
        int i4 = gLViewPortLocation.height;
        int i5 = (int) (gLViewPortLocation.y + (((1.0f - f2) * i4) / 2.0f) + ((i4 * this.mTy) / 2.0f));
        int i6 = (int) (i2 * f);
        int i7 = (int) (i4 * f2);
        GLES20.glViewport(i3, i5, i6, i7);
        GLES20.glEnable(SpeedStatsStampTable.MAINACTIVITY_ONRESUME_END_STAMP_KEY);
        GLES20.glBlendFunc(1, 771);
        for (int i8 = 0; i8 < this.mSubtitleAndStickerTrack.mediaSegments.size(); i8++) {
            MediaSegment mediaSegment = this.mSubtitleAndStickerTrack.mediaSegments.get(i8);
            MultiMediaData multiMediaData = this.mMultiMediaDataTrack.multiMediaDataList.get(i8);
            if (mediaSegment != null && multiMediaData != null) {
                long j = mediaSegment.start;
                if (j == 0 || j <= dg0Var.b()) {
                    long j2 = mediaSegment.end;
                    if ((j2 == 0 || j2 >= dg0Var.b()) && multiMediaData.textureId != 0) {
                        a aVar = this.mStickerItems.get(i8);
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
                            int i9 = dg0Var.i(mediaSegment, aVar.b[0], null);
                            GLES20.glViewport(i3, i5, i6, i7);
                            this.mFullScreen2D.drawFrame(i9, fArr);
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
    public boolean onTouchDown(float f, float f2, float f3, float f4) {
        if (this.mSubtitleAndStickerTrack == null) {
            return false;
        }
        this.mVisibleStickerItems.clear();
        for (int i = 0; i < this.mSubtitleAndStickerTrack.mediaSegments.size(); i++) {
            MediaSegment mediaSegment = this.mSubtitleAndStickerTrack.mediaSegments.get(i);
            if (i >= this.mMultiMediaDataTrack.multiMediaDataList.size()) {
                return super.onTouchDown(f, f2, f3, f4);
            }
            MultiMediaData multiMediaData = this.mMultiMediaDataTrack.multiMediaDataList.get(i);
            if (mediaSegment != null && multiMediaData != null) {
                long j = mediaSegment.start;
                if (j == 0 || j <= this.mCurrentPos) {
                    long j2 = mediaSegment.end;
                    if ((j2 == 0 || j2 >= this.mCurrentPos) && multiMediaData.textureId != 0 && TextUtils.equals(this.mEditTrackType, mediaSegment.type)) {
                        this.mVisibleStickerItems.add((a) kna.c(this.mStickerItems, i));
                    }
                }
            }
        }
        return super.onTouchDown(f, f2, f3, f4);
    }

    @Override // com.baidu.ugc.editvideo.record.renderer.MultiMediaEditBaseRenderer
    public void setCurrentItem(a aVar) {
        boolean z = aVar != this.mCurrentItem;
        super.setCurrentItem(aVar);
        List<a> list = this.mStickerItems;
        int indexOf = list.indexOf(aVar);
        kna.h(list, indexOf, list.size() - 1);
        MultiMediaDataTrack multiMediaDataTrack = this.mMultiMediaDataTrack;
        if (multiMediaDataTrack != null) {
            List<MultiMediaData> list2 = multiMediaDataTrack.multiMediaDataList;
            kna.h(list2, indexOf, list2.size() - 1);
        }
        MediaTrack mediaTrack = this.mSubtitleAndStickerTrack;
        if (mediaTrack != null) {
            List<MediaSegment> list3 = mediaTrack.mediaSegments;
            kna.h(list3, indexOf, list3.size() - 1);
        }
        if (z) {
            notifyStickerDataChange(StickerDataChangeType.SWAP);
        }
    }

    public void setCurrentStickerData(int i, String str) {
        MediaSegment mediaSegment;
        int indexOf;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        List<MediaSegment> stickerSegmentsDataByType = MultiDataSourceUtil.getStickerSegmentsDataByType(this.mSubtitleAndStickerTrack, str);
        if (kna.e(stickerSegmentsDataByType) || (mediaSegment = (MediaSegment) kna.c(stickerSegmentsDataByType, i)) == null || (indexOf = this.mSubtitleAndStickerTrack.mediaSegments.indexOf(mediaSegment)) < 0) {
            return;
        }
        a aVar = (a) kna.c(this.mStickerItems, indexOf);
        if (aVar != null) {
            setCurrentItem(aVar);
        }
        if (this.mInnerOnChangeStickerListener == null || this.mCurrentItem == null) {
            return;
        }
        this.mInnerOnChangeStickerListener.onClickSticker(this.mCurrentItem.b(), this.mEditTrackType, true);
    }

    public void setData(MediaTrack mediaTrack, MultiMediaDataTrack multiMediaDataTrack) {
        this.mSubtitleAndStickerTrack = mediaTrack;
        this.mMultiMediaDataTrack = multiMediaDataTrack;
        checkDataChange();
    }

    public void setOnChangeStickerListener(final OnChangeStickerListener onChangeStickerListener) {
        setInnerOnChangeStickerListener(new OnChangeStickerListener() { // from class: com.baidu.ugc.editvideo.record.renderer.MultiMediaStickerRenderer.1
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
                int indexOf;
                if (MultiMediaStickerRenderer.this.mMultiMediaDataTrack == null || MultiMediaStickerRenderer.this.mSubtitleAndStickerTrack == null) {
                    return;
                }
                if (TextUtils.equals(SubtitleLog.TAG, MultiMediaStickerRenderer.this.mEditTrackType)) {
                    OnChangeStickerListener onChangeStickerListener2 = onChangeStickerListener;
                    if (onChangeStickerListener2 != null) {
                        onChangeStickerListener2.onDeleteSticker(multiMediaData, i, str, z);
                    }
                    if (z) {
                        return;
                    }
                } else {
                    MediaSegment mediaSegment = MultiMediaStickerRenderer.this.mSubtitleAndStickerTrack.mediaSegments.get(i);
                    List<MediaSegment> stickerSegmentsDataByType = MultiDataSourceUtil.getStickerSegmentsDataByType(MultiMediaStickerRenderer.this.mSubtitleAndStickerTrack, MultiMediaStickerRenderer.this.mEditTrackType);
                    if (stickerSegmentsDataByType == null || (indexOf = stickerSegmentsDataByType.indexOf(mediaSegment)) < 0) {
                        return;
                    }
                    MultiMediaStickerRenderer.this.mMultiMediaDataTrack.multiMediaDataList.remove(i);
                    MultiMediaStickerRenderer.this.mSubtitleAndStickerTrack.mediaSegments.remove(i);
                    OnChangeStickerListener onChangeStickerListener3 = onChangeStickerListener;
                    if (onChangeStickerListener3 != null) {
                        onChangeStickerListener3.onDeleteSticker(multiMediaData, indexOf, str, z);
                    }
                    if (z) {
                        return;
                    }
                }
                MultiMediaStickerRenderer.this.notifyStickerDataChange("delete");
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
