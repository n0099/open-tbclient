package com.baidu.ugc.editvideo.record.processor;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import com.baidu.minivideo.arface.utils.ThreadPool;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrack;
import com.baidu.tieba.lva;
import com.baidu.tieba.mh0;
import com.baidu.tieba.uh0;
import com.baidu.tieba.yua;
import com.baidu.ugc.editvideo.faceunity.gles.FullFrameRect;
import com.baidu.ugc.editvideo.faceunity.gles.GlUtil;
import com.baidu.ugc.editvideo.faceunity.gles.Texture2dProgram;
import com.baidu.ugc.editvideo.record.source.multimedia.utils.MultiDataSourceUtil;
import com.baidu.ugc.utils.FileUtils;
import java.io.File;
/* loaded from: classes8.dex */
public class InputProcessor extends BaseEffectProcessor {
    public int mTestSavePicCount;

    private void testPic(int i, String str) {
        int i2 = this.mTestSavePicCount;
        if (i2 < 10) {
            if (i2 == 0) {
                lva.a().post(new Runnable() { // from class: com.baidu.ugc.editvideo.record.processor.InputProcessor.1
                    @Override // java.lang.Runnable
                    public void run() {
                        FileUtils.deleteFileOrDir(new File("/sdcard/zhmy/"));
                    }
                });
            }
            final String str2 = str + "-test-" + this.mTestSavePicCount + "—" + System.currentTimeMillis() + ".png";
            FullFrameRect fullFrameRect = new FullFrameRect(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
            GLES20.glViewport(0, 0, this.mPreviewWidth, this.mPreviewHeight);
            GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            fullFrameRect.drawFrame(i, GlUtil.IDENTITY_MATRIX);
            final Bitmap saveOffscreenBitmap = MultiDataSourceUtil.saveOffscreenBitmap(this.mPreviewWidth, this.mPreviewHeight);
            ThreadPool.b().e(new Runnable() { // from class: com.baidu.ugc.editvideo.record.processor.InputProcessor.2
                @Override // java.lang.Runnable
                public void run() {
                    FileUtils.saveBitmap2PNG("/sdcard/zhmy/", str2, saveOffscreenBitmap, 100);
                }
            });
            this.mTestSavePicCount++;
        }
    }

    @Override // com.baidu.ugc.editvideo.record.processor.IEffectProcessor
    public int onProcessFrame(mh0 mh0Var, int i, float[] fArr) {
        if (mh0Var == null || mh0Var.l() == null) {
            return i;
        }
        MediaTrack mediaTrack = (MediaTrack) yua.c(mh0Var.l(), 0);
        boolean m = uh0.m(mediaTrack, "input_blank");
        int g = !m ? mh0Var.g(mediaTrack, mh0Var.g(mediaTrack, mh0Var.g(mediaTrack, mh0Var.g(mediaTrack, mh0Var.g(mediaTrack, i, 1, null), 5, null), 2, null), 3, null), 4, null) : i;
        if (m) {
            for (int i2 = 1; i2 < mh0Var.l().size(); i2++) {
                MediaTrack mediaTrack2 = mh0Var.l().get(i2);
                if (mediaTrack2 != null && uh0.m(mediaTrack2, "multi_input")) {
                    g = mh0Var.j(mediaTrack2, g, null);
                }
            }
            g = mh0Var.g(mediaTrack, g, 1, null);
        }
        return g == 0 ? i : g;
    }

    @Override // com.baidu.ugc.editvideo.record.processor.BaseEffectProcessor
    public void release() {
    }

    @Override // com.baidu.ugc.editvideo.record.processor.BaseEffectProcessor
    public void releaseInGlThread() {
    }
}
