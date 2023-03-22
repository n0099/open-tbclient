package com.baidu.ugc.editvideo.editvideo.addfilter;

import android.opengl.GLES20;
import android.opengl.Matrix;
import com.baidu.tieba.m7a;
import com.baidu.ugc.editvideo.faceunity.gles.FullFrameRect;
import com.baidu.ugc.editvideo.faceunity.gles.Texture2dProgram;
import com.faceunity.gles.GeneratedTexture;
/* loaded from: classes7.dex */
public class TransOesTo2dHelper {
    public int mFrameBuffer;
    public int[] mFramebuffers = new int[1];
    public FullFrameRect mFullScreen2D;
    public FullFrameRect mFullScreenEXT;
    public int mTexture2DId;

    public void release() {
        FullFrameRect fullFrameRect = this.mFullScreenEXT;
        if (fullFrameRect != null) {
            fullFrameRect.release(false);
            this.mFullScreenEXT = null;
        }
        FullFrameRect fullFrameRect2 = this.mFullScreen2D;
        if (fullFrameRect2 != null) {
            fullFrameRect2.release(false);
            this.mFullScreen2D = null;
        }
        if (this.mTexture2DId != 0) {
            GLES20.glDeleteFramebuffers(1, this.mFramebuffers, 0);
            GLES20.glDeleteTextures(1, new int[]{this.mTexture2DId}, 0);
            this.mTexture2DId = 0;
        }
    }

    public int trans(int i, float[] fArr, int i2, int i3) {
        try {
            if (this.mFullScreenEXT == null) {
                this.mFullScreenEXT = new FullFrameRect(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_EXT));
            }
            if (this.mFullScreen2D == null) {
                this.mFullScreen2D = new FullFrameRect(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
            }
            if (this.mTexture2DId == 0) {
                this.mTexture2DId = this.mFullScreen2D.createTexture2DObject();
                GLES20.glTexImage2D(3553, 0, GeneratedTexture.FORMAT, i2, i3, 0, GeneratedTexture.FORMAT, 5121, null);
                GLES20.glBindTexture(3553, 0);
                GLES20.glGenFramebuffers(1, this.mFramebuffers, 0);
                this.mFrameBuffer = this.mFramebuffers[0];
            }
            GLES20.glBindFramebuffer(36160, this.mFrameBuffer);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.mTexture2DId, 0);
            GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES20.glClear(16640);
            GLES20.glViewport(0, 0, i2, i3);
            this.mFullScreenEXT.setScale(1.0f, 1.0f);
            this.mFullScreenEXT.setAlpha(1.0f);
            this.mFullScreenEXT.drawFrame(i, fArr);
            GLES20.glBindFramebuffer(36160, 0);
            Matrix.setIdentityM(fArr, 0);
        } catch (Exception e) {
            release();
            m7a.g(e);
        }
        return this.mTexture2DId;
    }
}
