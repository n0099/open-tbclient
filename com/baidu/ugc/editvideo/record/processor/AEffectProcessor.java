package com.baidu.ugc.editvideo.record.processor;

import android.text.TextUtils;
import com.baidu.minivideo.effect.core.vlogedit.MediaSegment;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrack;
import com.baidu.minivideo.effect.core.vlogedit.ShaderConfig;
import com.baidu.tieba.m5b;
import com.baidu.tieba.o9b;
import com.baidu.tieba.pg0;
import com.baidu.tieba.ug0;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
/* loaded from: classes9.dex */
public class AEffectProcessor extends BaseEffectProcessor {
    public boolean isCamera;
    public Map<String, ShaderConfig> mTrackConfig;
    public List<MediaTrack> mUpdateMediaTracks;
    public ug0 mVlogEditCore;
    public final LinkedList<Runnable> runOnDraw = new LinkedList<>();

    @Override // com.baidu.ugc.editvideo.record.processor.BaseEffectProcessor
    public void release() {
    }

    public AEffectProcessor() {
        ug0 ug0Var = new ug0();
        this.mVlogEditCore = ug0Var;
        ug0Var.a(m5b.c().getContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkCamera() {
        MediaSegment mediaSegment;
        this.isCamera = false;
        MediaTrack mediaTrack = (MediaTrack) o9b.c(this.mUpdateMediaTracks, 0);
        if (mediaTrack != null && (mediaSegment = (MediaSegment) o9b.c(mediaTrack.mediaSegments, 0)) != null && TextUtils.equals(mediaSegment.type, "camera")) {
            this.isCamera = true;
        }
    }

    private void runPendingOnDrawTasks() {
        while (!this.runOnDraw.isEmpty()) {
            this.runOnDraw.removeFirst().run();
        }
    }

    @Override // com.baidu.ugc.editvideo.record.processor.BaseEffectProcessor, com.baidu.ugc.editvideo.record.IMediaLifeCycle
    public void onResume() {
        super.onResume();
        changeEffect(this.mTrackConfig, this.mUpdateMediaTracks);
    }

    @Override // com.baidu.ugc.editvideo.record.processor.BaseEffectProcessor
    public void releaseInGlThread() {
        this.mVlogEditCore.release();
    }

    public void updateMediaTracks(final List<MediaTrack> list) {
        this.mUpdateMediaTracks = list;
        this.runOnDraw.add(new Runnable() { // from class: com.baidu.ugc.editvideo.record.processor.AEffectProcessor.2
            @Override // java.lang.Runnable
            public void run() {
                AEffectProcessor.this.checkCamera();
                AEffectProcessor.this.mVlogEditCore.n(list);
            }
        });
    }

    public void changeEffect(final Map<String, ShaderConfig> map, final List<MediaTrack> list) {
        this.mTrackConfig = map;
        this.mUpdateMediaTracks = list;
        this.runOnDraw.add(new Runnable() { // from class: com.baidu.ugc.editvideo.record.processor.AEffectProcessor.1
            @Override // java.lang.Runnable
            public void run() {
                AEffectProcessor.this.checkCamera();
                if (AEffectProcessor.this.mTrackConfig != null) {
                    AEffectProcessor.this.mVlogEditCore.f(list, map);
                } else {
                    AEffectProcessor.this.mVlogEditCore.f(null, null);
                }
            }
        });
    }

    public int onProcessFrame(int i, float[] fArr) {
        int d;
        runPendingOnDrawTasks();
        HashMap hashMap = new HashMap();
        if (this.isCamera) {
            d = this.mVlogEditCore.m(i, null, fArr, this.mInputTextureMode, this.mPreviewWidth, this.mPreviewHeight, hashMap);
        } else {
            d = this.mVlogEditCore.d(this.mPreviewWidth, this.mPreviewHeight, hashMap);
        }
        if (d != 0) {
            return d;
        }
        return i;
    }

    public void startRecordAnim(final int i, final long j) {
        this.runOnDraw.add(new Runnable() { // from class: com.baidu.ugc.editvideo.record.processor.AEffectProcessor.3
            @Override // java.lang.Runnable
            public void run() {
                AEffectProcessor.this.mVlogEditCore.h(i, j);
            }
        });
    }

    @Override // com.baidu.ugc.editvideo.record.processor.IEffectProcessor
    public int onProcessFrame(pg0 pg0Var, int i, float[] fArr) {
        int d;
        runPendingOnDrawTasks();
        HashMap hashMap = new HashMap();
        if (this.isCamera) {
            d = this.mVlogEditCore.m(i, null, fArr, this.mInputTextureMode, this.mPreviewWidth, this.mPreviewHeight, hashMap);
        } else {
            d = this.mVlogEditCore.d(this.mPreviewWidth, this.mPreviewHeight, hashMap);
        }
        if (d != 0) {
            return d;
        }
        return i;
    }
}
