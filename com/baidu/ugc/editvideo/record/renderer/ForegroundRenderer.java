package com.baidu.ugc.editvideo.record.renderer;

import android.opengl.GLES20;
import com.baidu.minivideo.effect.core.vlogedit.MediaSegment;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrack;
import com.baidu.searchbox.launch.stats.SpeedStatsStampTable;
import com.baidu.tieba.ah0;
import com.baidu.tieba.sg0;
import com.baidu.ugc.editvideo.faceunity.gles.GlUtil;
import com.baidu.ugc.editvideo.record.entity.GLViewPortLocation;
/* loaded from: classes9.dex */
public class ForegroundRenderer extends MediaBaseRenderer {
    @Override // com.baidu.ugc.editvideo.record.renderer.MediaBaseRenderer, com.baidu.ugc.editvideo.record.renderer.IMediaRenderer
    public void onDrawFrame(sg0 sg0Var, int i, float[] fArr) {
        if (sg0Var == null || sg0Var.l() == null) {
            return;
        }
        for (int i2 = 1; i2 < sg0Var.l().size(); i2++) {
            MediaTrack mediaTrack = sg0Var.l().get(i2);
            if (mediaTrack != null && ah0.m(mediaTrack, "watermark")) {
                long b = sg0Var.b();
                for (MediaSegment mediaSegment : mediaTrack.mediaSegments) {
                    if (mediaSegment.start != 0 || mediaSegment.end != 0) {
                        long j = mediaSegment.start;
                        long j2 = mediaSegment.end;
                        if (j != j2 && b >= j && b <= j2) {
                        }
                    }
                    int i3 = sg0Var.i(mediaSegment, mediaSegment.textureId, null);
                    GLViewPortLocation gLViewPortLocation = this.mGLViewPortLocation;
                    GLES20.glViewport(gLViewPortLocation.x, gLViewPortLocation.y, gLViewPortLocation.width, gLViewPortLocation.height);
                    GLES20.glEnable(SpeedStatsStampTable.MAINACTIVITY_ONRESUME_END_STAMP_KEY);
                    GLES20.glBlendFunc(770, 771);
                    this.mFullScreen2D.setVertexPoint(GlUtil.IDENTITY_MATRIX);
                    this.mFullScreen2D.setScaleAndTranslate(this.mScaleX, this.mScaleY, this.mTx, this.mTy);
                    this.mFullScreen2D.drawFrame(i3, fArr);
                    this.mFullScreen2D.setScaleAndTranslate(1.0f, 1.0f, 0.0f, 0.0f);
                    GLES20.glDisable(SpeedStatsStampTable.MAINACTIVITY_ONRESUME_END_STAMP_KEY);
                }
                return;
            }
        }
    }
}
