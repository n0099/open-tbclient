package com.baidu.ugc.editvideo.editvideo.addfilter;

import android.content.Context;
import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.os.Handler;
import com.baidu.searchbox.launch.stats.SpeedStatsStampTable;
import com.baidu.tieba.bcb;
import com.baidu.ugc.editvideo.faceunity.gles.FullFrameRect;
import com.baidu.ugc.editvideo.faceunity.gles.GlUtil;
import com.baidu.ugc.editvideo.faceunity.gles.Texture2dProgram;
import com.baidu.ugc.editvideo.filter.FilterValue;
import com.baidu.ugc.editvideo.magicmusic.effect.BaseEffect;
import java.util.List;
/* loaded from: classes9.dex */
public class OutputSurfaceWithFilter extends BaseOutputSurface {
    public boolean isAr;
    public boolean isInitFu;
    public Context mContext;
    public FilterValue mFilterValue;
    public FullFrameRect mFullScreenFUDisplay;
    public boolean mIsAddWaterMark;
    public List<BaseEffect> mMagicEffectList;
    public Bitmap mWaterMarkBitmap;
    public int mWaterMarkTextureId;

    public OutputSurfaceWithFilter(Context context) {
        this.mIsAddWaterMark = false;
        this.isAr = false;
        this.mContext = context;
    }

    public OutputSurfaceWithFilter(Context context, FilterValue filterValue, boolean z, int i, int i2) {
        this.mIsAddWaterMark = false;
        this.isAr = false;
        this.mIsAddWaterMark = z;
        this.mContext = context;
        if (filterValue != null) {
            this.mFilterValue = filterValue;
        }
        init(i, i2);
    }

    public OutputSurfaceWithFilter(Context context, FilterValue filterValue, boolean z, int i, int i2, boolean z2, Handler handler) {
        this.mIsAddWaterMark = false;
        this.isAr = false;
        this.mIsAddWaterMark = z;
        this.mContext = context;
        if (filterValue != null) {
            this.mFilterValue = filterValue;
        }
        init(i, i2, z2, handler);
    }

    @Override // com.baidu.ugc.editvideo.editvideo.addfilter.BaseOutputSurface
    public void drawImage(int i) {
        super.drawImage(i);
        if (!this.mIsAddWaterMark) {
            this.mFullScreenEXT.drawFrame(this.mTextureId, this.mSTMatrix);
            return;
        }
        if (this.mWaterMarkBitmap != null && this.mWaterMarkTextureId == 0) {
            this.mWaterMarkTextureId = this.mFullScreenFUDisplay.createTexture2DObject();
            GLUtils.texImage2D(3553, 0, this.mWaterMarkBitmap, 0);
        }
        this.mFullScreenEXT.drawFrame(this.mTextureId, this.mSTMatrix);
        int min = Math.min(this.mVideoWidth, this.mVideoHeight);
        int i2 = (min * 16) / 720;
        int i3 = (min * 112) / 720;
        GLES20.glViewport(i2, (this.mVideoHeight - i3) - i2, (min * 300) / 720, i3);
        GLES20.glDisable(2929);
        GLES20.glEnable(SpeedStatsStampTable.MAINACTIVITY_ONRESUME_END_STAMP_KEY);
        GLES20.glBlendFunc(1, 771);
        this.mFullScreenFUDisplay.setAngle(180.0f);
        this.mFullScreenFUDisplay.setScale(1.0f, -1.0f);
        this.mFullScreenFUDisplay.drawFrame(this.mWaterMarkTextureId, GlUtil.IDENTITY_MATRIX, true);
        GLES20.glDisable(SpeedStatsStampTable.MAINACTIVITY_ONRESUME_END_STAMP_KEY);
        GLES20.glViewport(0, 0, this.mVideoWidth, this.mVideoHeight);
    }

    @Override // com.baidu.ugc.editvideo.editvideo.addfilter.BaseOutputSurface
    public void release() {
        super.release();
        FullFrameRect fullFrameRect = this.mFullScreenFUDisplay;
        if (fullFrameRect != null) {
            fullFrameRect.release(false);
            this.mFullScreenFUDisplay = null;
        }
    }

    public void setAddWaterMark(boolean z) {
        this.mIsAddWaterMark = z;
    }

    public void setFilterValue(FilterValue filterValue) {
        this.mFilterValue = filterValue;
    }

    public void setMagicEffectList(List<BaseEffect> list) {
        this.mMagicEffectList = list;
    }

    public void setWaterMarkBitmap(Bitmap bitmap) {
        this.mWaterMarkBitmap = bitmap;
    }

    @Override // com.baidu.ugc.editvideo.editvideo.addfilter.BaseOutputSurface
    public void setup() {
        super.setup();
        this.isAr = bcb.c().i();
        this.mFullScreenFUDisplay = new FullFrameRect(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
    }
}
