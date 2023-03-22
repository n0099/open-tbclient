package com.baidu.ugc.editvideo.editvideo.muxer;

import android.text.TextUtils;
import android.util.Pair;
import com.baidu.tieba.e8a;
import com.baidu.tieba.g8a;
import com.baidu.tieba.h8a;
import com.baidu.tieba.i6a;
import com.baidu.tieba.j6a;
import com.baidu.tieba.p3a;
import com.baidu.ugc.editvideo.data.VideoMuxerData;
import com.baidu.ugc.utils.FileUtils;
import com.google.android.exoplayer2.source.hls.DefaultHlsExtractorFactory;
import java.io.File;
import java.util.LinkedList;
/* loaded from: classes7.dex */
public class a {
    public LinkedList<Pair<String, Object>> a = new LinkedList<>();
    public InterfaceC0508a b;
    public String c;
    public boolean d;

    /* renamed from: com.baidu.ugc.editvideo.editvideo.muxer.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0508a {
        void onAudioVideoMuxerCancel();

        void onAudioVideoMuxerFail(i6a i6aVar);

        void onAudioVideoMuxerFinish(String str);
    }

    /* loaded from: classes7.dex */
    public static class b {
        public i6a a;
        public String b;

        public b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final b bVar) {
        e8a.a().postDelayed(new Runnable() { // from class: com.baidu.ugc.editvideo.editvideo.muxer.a.2
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.d) {
                    a.this.a();
                } else if (a.this.b != null) {
                    b bVar2 = bVar;
                    if (bVar2 != null) {
                        if (g8a.a(bVar2.b) || !FileUtils.checkFile(bVar.b)) {
                            a.this.b.onAudioVideoMuxerFail(bVar.a);
                            return;
                        } else {
                            a.this.b.onAudioVideoMuxerFinish(bVar.b);
                            return;
                        }
                    }
                    i6a i6aVar = new i6a();
                    i6aVar.b = true;
                    i6aVar.a = 24;
                    i6aVar.c = "error_mixtrue";
                    i6aVar.e = "合成音乐失败 MuxerMusicResult is null";
                    a.this.b.onAudioVideoMuxerFail(i6aVar);
                }
            }
        }, 200L);
    }

    public void a() {
        this.d = true;
        InterfaceC0508a interfaceC0508a = this.b;
        if (interfaceC0508a != null) {
            interfaceC0508a.onAudioVideoMuxerCancel();
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
        j6a.b("muxerAV2Mp4", "音视频混合 to mp4");
        this.d = false;
        if (videoMuxerData == null) {
            if (this.b != null) {
                i6a i6aVar = new i6a();
                i6aVar.b = true;
                i6aVar.a = 24;
                i6aVar.c = "error_mixtrue";
                i6aVar.e = "音视频合成VideoMuxerData为空合成失败";
                this.b.onAudioVideoMuxerFail(i6aVar);
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
                    String f = p3a.c().f();
                    if (TextUtils.isEmpty(f)) {
                        sb.append("getMixVideoAudioDir 是空");
                        return;
                    }
                    FileUtils.mkdirs(f);
                    a aVar = a.this;
                    aVar.c = f + File.separator + "audio_video_" + System.currentTimeMillis() + DefaultHlsExtractorFactory.MP4_FILE_EXTENSION;
                    boolean j = h8a.j(sb, videoMuxerData.getFinalAudioPath(), videoMuxerData.getVideoPath(), a.this.c, 0L, -1L);
                    b bVar = new b();
                    if (j) {
                        bVar.b = a.this.c;
                    } else {
                        i6a i6aVar2 = new i6a();
                        i6aVar2.b = true;
                        i6aVar2.a = 24;
                        i6aVar2.c = "error_mixtrue";
                        i6aVar2.e = " 预处理音乐合成失败-4 musicPath" + videoMuxerData.getFinalAudioPath() + " ,videoPath" + videoMuxerData.getVideoPath() + " ,outputVideoPath" + a.this.c + " ,muxResult:" + j + ",errorMsg" + sb.toString() + " ,audio file size =" + fileSize;
                        bVar.a = i6aVar2;
                    }
                    j6a.b("avMuxThead", "音视频混合:" + j);
                    a.this.a(bVar);
                }
            }).start();
        } else if (this.b != null) {
            i6a i6aVar2 = new i6a();
            i6aVar2.b = true;
            i6aVar2.a = 24;
            i6aVar2.c = "error_mixtrue";
            i6aVar2.e = "musicPath" + videoMuxerData.getFinalAudioPath() + "outputVideoPath" + this.c + "videoPath: " + videoMuxerData.getVideoPath() + "muxResult:false 合成音乐视频路径丢失";
            this.b.onAudioVideoMuxerFail(i6aVar2);
        }
    }

    public void a(InterfaceC0508a interfaceC0508a) {
        this.b = interfaceC0508a;
    }
}
