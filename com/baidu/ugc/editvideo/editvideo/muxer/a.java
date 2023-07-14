package com.baidu.ugc.editvideo.editvideo.muxer;

import android.text.TextUtils;
import android.util.Pair;
import com.baidu.tieba.abb;
import com.baidu.tieba.b9b;
import com.baidu.tieba.c9b;
import com.baidu.tieba.i6b;
import com.baidu.tieba.xab;
import com.baidu.tieba.zab;
import com.baidu.ugc.editvideo.data.VideoMuxerData;
import com.baidu.ugc.utils.FileUtils;
import com.google.android.exoplayer2.source.hls.DefaultHlsExtractorFactory;
import java.io.File;
import java.util.LinkedList;
/* loaded from: classes9.dex */
public class a {
    public LinkedList<Pair<String, Object>> a = new LinkedList<>();
    public InterfaceC0560a b;
    public String c;
    public boolean d;

    /* renamed from: com.baidu.ugc.editvideo.editvideo.muxer.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0560a {
        void onAudioVideoMuxerCancel();

        void onAudioVideoMuxerFail(b9b b9bVar);

        void onAudioVideoMuxerFinish(String str);
    }

    /* loaded from: classes9.dex */
    public static class b {
        public b9b a;
        public String b;

        public b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final b bVar) {
        xab.a().postDelayed(new Runnable() { // from class: com.baidu.ugc.editvideo.editvideo.muxer.a.2
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.d) {
                    a.this.a();
                } else if (a.this.b != null) {
                    b bVar2 = bVar;
                    if (bVar2 != null) {
                        if (zab.a(bVar2.b) || !FileUtils.checkFile(bVar.b)) {
                            a.this.b.onAudioVideoMuxerFail(bVar.a);
                            return;
                        } else {
                            a.this.b.onAudioVideoMuxerFinish(bVar.b);
                            return;
                        }
                    }
                    b9b b9bVar = new b9b();
                    b9bVar.b = true;
                    b9bVar.a = 24;
                    b9bVar.c = "error_mixtrue";
                    b9bVar.e = "合成音乐失败 MuxerMusicResult is null";
                    a.this.b.onAudioVideoMuxerFail(b9bVar);
                }
            }
        }, 200L);
    }

    public void a() {
        this.d = true;
        InterfaceC0560a interfaceC0560a = this.b;
        if (interfaceC0560a != null) {
            interfaceC0560a.onAudioVideoMuxerCancel();
        }
        try {
            File file = new File(this.c);
            if (file.exists()) {
                file.delete();
            }
        } catch (Exception unused) {
        }
    }

    public void a(final VideoMuxerData videoMuxerData) {
        c9b.b("muxerAV2Mp4", "音视频混合 to mp4");
        this.d = false;
        if (videoMuxerData == null) {
            if (this.b != null) {
                b9b b9bVar = new b9b();
                b9bVar.b = true;
                b9bVar.a = 24;
                b9bVar.c = "error_mixtrue";
                b9bVar.e = "音视频合成VideoMuxerData为空合成失败";
                this.b.onAudioVideoMuxerFail(b9bVar);
                return;
            }
            return;
        }
        this.a.add(new Pair<>("type", videoMuxerData.getLogType()));
        final long fileSize = FileUtils.getFileSize(videoMuxerData.getFinalAudioPath());
        if (FileUtils.checkFile(videoMuxerData.getVideoPath())) {
            new Thread(new Runnable() { // from class: com.baidu.ugc.editvideo.editvideo.muxer.a.1
                @Override // java.lang.Runnable
                public void run() {
                    StringBuilder sb = new StringBuilder();
                    String f = i6b.c().f();
                    if (TextUtils.isEmpty(f)) {
                        sb.append("getMixVideoAudioDir 是空");
                        return;
                    }
                    FileUtils.mkdirs(f);
                    a aVar = a.this;
                    aVar.c = f + File.separator + "audio_video_" + System.currentTimeMillis() + DefaultHlsExtractorFactory.MP4_FILE_EXTENSION;
                    boolean j = abb.j(sb, videoMuxerData.getFinalAudioPath(), videoMuxerData.getVideoPath(), a.this.c, 0L, -1L);
                    b bVar = new b();
                    if (j) {
                        bVar.b = a.this.c;
                    } else {
                        b9b b9bVar2 = new b9b();
                        b9bVar2.b = true;
                        b9bVar2.a = 24;
                        b9bVar2.c = "error_mixtrue";
                        b9bVar2.e = " 预处理音乐合成失败-4 musicPath" + videoMuxerData.getFinalAudioPath() + " ,videoPath" + videoMuxerData.getVideoPath() + " ,outputVideoPath" + a.this.c + " ,muxResult:" + j + ",errorMsg" + sb.toString() + " ,audio file size =" + fileSize;
                        bVar.a = b9bVar2;
                    }
                    c9b.b("avMuxThead", "音视频混合:" + j);
                    a.this.a(bVar);
                }
            }).start();
        } else if (this.b != null) {
            b9b b9bVar2 = new b9b();
            b9bVar2.b = true;
            b9bVar2.a = 24;
            b9bVar2.c = "error_mixtrue";
            b9bVar2.e = "musicPath" + videoMuxerData.getFinalAudioPath() + "outputVideoPath" + this.c + "videoPath: " + videoMuxerData.getVideoPath() + "muxResult:false 合成音乐视频路径丢失";
            this.b.onAudioVideoMuxerFail(b9bVar2);
        }
    }

    public void a(InterfaceC0560a interfaceC0560a) {
        this.b = interfaceC0560a;
    }
}
