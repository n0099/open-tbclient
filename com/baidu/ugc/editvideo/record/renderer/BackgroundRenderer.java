package com.baidu.ugc.editvideo.record.renderer;

import android.opengl.GLES20;
import c.a.z.b.a.e;
import c.a.z.b.a.k.c;
import com.baidu.minivideo.effect.core.vlogedit.MediaSegment;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrack;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.faceunity.gles.GlUtil;
import com.baidu.ugc.editvideo.record.entity.GLViewPortLocation;
import com.baidu.wallet.paysdk.banksign.beans.BankSignFactory;
/* loaded from: classes8.dex */
public class BackgroundRenderer extends MediaBaseRenderer {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public BackgroundRenderer() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.ugc.editvideo.record.renderer.MediaBaseRenderer, com.baidu.ugc.editvideo.record.renderer.IMediaRenderer
    public void onDrawFrame(e eVar, int i2, float[] fArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(1048576, this, eVar, i2, fArr) == null) || eVar == null || eVar.l() == null) {
            return;
        }
        for (int i3 = 1; i3 < eVar.l().size(); i3++) {
            MediaTrack mediaTrack = eVar.l().get(i3);
            if (mediaTrack != null && c.m(mediaTrack, "only_background")) {
                long a2 = eVar.a();
                for (MediaSegment mediaSegment : mediaTrack.mediaSegments) {
                    if (mediaSegment.start != 0 || mediaSegment.end != 0) {
                        long j2 = mediaSegment.start;
                        long j3 = mediaSegment.end;
                        if (j2 != j3 && a2 >= j2 && a2 <= j3) {
                        }
                    }
                    GLViewPortLocation gLViewPortLocation = this.mGLViewPortLocation;
                    GLES20.glViewport(gLViewPortLocation.x, gLViewPortLocation.y, gLViewPortLocation.width, gLViewPortLocation.height);
                    GLES20.glEnable(3042);
                    GLES20.glBlendFunc(BankSignFactory.BEAN_ID_QUERY, BankSignFactory.BEAN_ID_BIND_CARD);
                    this.mFullScreen2D.setVertexPoint(GlUtil.IDENTITY_MATRIX);
                    this.mFullScreen2D.setScaleAndTranslate(this.mScaleX, this.mScaleY, this.mTx, this.mTy);
                    this.mFullScreen2D.drawFrame(mediaSegment.textureId, fArr);
                    this.mFullScreen2D.setScaleAndTranslate(1.0f, 1.0f, 0.0f, 0.0f);
                    GLES20.glDisable(3042);
                }
                return;
            }
        }
    }
}
