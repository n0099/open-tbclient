package com.baidu.ugc.editvideo.record.processor.glrender;

import com.baidu.tieba.iib;
import com.baidu.tieba.nib;
import com.baidu.ugc.editvideo.faceunity.gles.FullFrameRect;
import java.util.LinkedList;
/* loaded from: classes9.dex */
public class BaseGlRenderer implements IGlRenderer {
    public FullFrameRect mFullScreen2D;
    public FullFrameRect mFullScreenEXT;
    public int mOutHeight;
    public int mOutWidth;
    public LinkedList<Runnable> runOnProcess = new LinkedList<>();

    @Override // com.baidu.ugc.editvideo.record.processor.glrender.IGlRenderer
    public void initProgram() {
    }

    @Override // com.baidu.ugc.editvideo.record.processor.glrender.IGlRenderer
    public void initProgram(FullFrameRect fullFrameRect, FullFrameRect fullFrameRect2) {
        this.mFullScreenEXT = fullFrameRect;
        this.mFullScreen2D = fullFrameRect2;
    }

    @Override // com.baidu.ugc.editvideo.record.processor.glrender.IGlRenderer
    public void onPreProcess() {
        runPendingOnProcessTasks();
    }

    @Override // com.baidu.ugc.editvideo.record.processor.glrender.IGlRenderer
    public void onSizeChange(int i, int i2) {
        this.mOutWidth = i;
        this.mOutHeight = i2;
    }

    @Override // com.baidu.ugc.editvideo.record.processor.glrender.IGlRenderer
    public void releaseProgram() {
    }

    public void runPendingOnProcessTasks() {
        try {
            if (nib.b(this.runOnProcess) > 0) {
                iib.b("runPendingOnProcessTasks : " + this.runOnProcess.size());
            }
            while (!this.runOnProcess.isEmpty()) {
                this.runOnProcess.removeFirst().run();
            }
        } catch (Exception e) {
            this.runOnProcess.clear();
            e.printStackTrace();
        }
    }
}
