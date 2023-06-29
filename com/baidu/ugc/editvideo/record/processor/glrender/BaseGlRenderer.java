package com.baidu.ugc.editvideo.record.processor.glrender;

import com.baidu.tieba.h1b;
import com.baidu.tieba.m1b;
import com.baidu.ugc.editvideo.faceunity.gles.FullFrameRect;
import java.util.LinkedList;
/* loaded from: classes8.dex */
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
            if (m1b.b(this.runOnProcess) > 0) {
                h1b.b("runPendingOnProcessTasks : " + this.runOnProcess.size());
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
