package com.baidu.ugc.editvideo.record.renderer;

import android.opengl.GLES20;
import com.baidu.minivideo.effect.core.vlogedit.MediaSegment;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrack;
import com.baidu.searchbox.launch.stats.SpeedStatsStampTable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.faceunity.gles.GlUtil;
import com.baidu.ugc.editvideo.record.entity.GLViewPortLocation;
import com.repackage.ke0;
import com.repackage.se0;
/* loaded from: classes4.dex */
public class BackgroundRenderer extends MediaBaseRenderer {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public BackgroundRenderer() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.ugc.editvideo.record.renderer.MediaBaseRenderer, com.baidu.ugc.editvideo.record.renderer.IMediaRenderer
    public void onDrawFrame(ke0 ke0Var, int i, float[] fArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(1048576, this, ke0Var, i, fArr) == null) || ke0Var == null || ke0Var.l() == null) {
            return;
        }
        for (int i2 = 1; i2 < ke0Var.l().size(); i2++) {
            MediaTrack mediaTrack = ke0Var.l().get(i2);
            if (mediaTrack != null && se0.m(mediaTrack, "only_background")) {
                long a = ke0Var.a();
                for (MediaSegment mediaSegment : mediaTrack.mediaSegments) {
                    if (mediaSegment.start != 0 || mediaSegment.end != 0) {
                        long j = mediaSegment.start;
                        long j2 = mediaSegment.end;
                        if (j != j2 && a >= j && a <= j2) {
                        }
                    }
                    GLViewPortLocation gLViewPortLocation = this.mGLViewPortLocation;
                    GLES20.glViewport(gLViewPortLocation.x, gLViewPortLocation.y, gLViewPortLocation.width, gLViewPortLocation.height);
                    GLES20.glEnable(SpeedStatsStampTable.MAINACTIVITY_ONRESUME_END_STAMP_KEY);
                    GLES20.glBlendFunc(770, 771);
                    this.mFullScreen2D.setVertexPoint(GlUtil.IDENTITY_MATRIX);
                    this.mFullScreen2D.setScaleAndTranslate(this.mScaleX, this.mScaleY, this.mTx, this.mTy);
                    this.mFullScreen2D.drawFrame(mediaSegment.textureId, fArr);
                    this.mFullScreen2D.setScaleAndTranslate(1.0f, 1.0f, 0.0f, 0.0f);
                    GLES20.glDisable(SpeedStatsStampTable.MAINACTIVITY_ONRESUME_END_STAMP_KEY);
                }
                return;
            }
        }
    }
}
