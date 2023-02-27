package com.baidu.ugc.editvideo.editvideo.muxer;

import android.text.TextUtils;
import android.util.Pair;
import com.baidu.tieba.a0a;
import com.baidu.tieba.gx9;
import com.baidu.tieba.v1a;
import com.baidu.tieba.x1a;
import com.baidu.tieba.y1a;
import com.baidu.tieba.zz9;
import com.baidu.ugc.editvideo.data.VideoMuxerData;
import com.baidu.ugc.utils.FileUtils;
import com.google.android.exoplayer2.source.hls.DefaultHlsExtractorFactory;
import java.io.File;
import java.util.LinkedList;
/* loaded from: classes7.dex */
public class a {
    public LinkedList<Pair<String, Object>> a = new LinkedList<>();
    public InterfaceC0503a b;
    public String c;
    public boolean d;

    /* renamed from: com.baidu.ugc.editvideo.editvideo.muxer.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0503a {
        void onAudioVideoMuxerCancel();

        void onAudioVideoMuxerFail(zz9 zz9Var);

        void onAudioVideoMuxerFinish(String str);
    }

    /* loaded from: classes7.dex */
    public static class b {
        public zz9 a;
        public String b;

        public b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final b bVar) {
        v1a.a().postDelayed(new Runnable() { // from class: com.baidu.ugc.editvideo.editvideo.muxer.a.2
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.d) {
                    a.this.a();
                } else if (a.this.b != null) {
                    b bVar2 = bVar;
                    if (bVar2 != null) {
                        if (x1a.a(bVar2.b) || !FileUtils.checkFile(bVar.b)) {
                            a.this.b.onAudioVideoMuxerFail(bVar.a);
                            return;
                        } else {
                            a.this.b.onAudioVideoMuxerFinish(bVar.b);
                            return;
                        }
                    }
                    zz9 zz9Var = new zz9();
                    zz9Var.b = true;
                    zz9Var.a = 24;
                    zz9Var.c = "error_mixtrue";
                    zz9Var.e = "合成音乐失败 MuxerMusicResult is null";
                    a.this.b.onAudioVideoMuxerFail(zz9Var);
                }
            }
        }, 200L);
    }

    public void a() {
        this.d = true;
        InterfaceC0503a interfaceC0503a = this.b;
        if (interfaceC0503a != null) {
            interfaceC0503a.onAudioVideoMuxerCancel();
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
        a0a.b("muxerAV2Mp4", "音视频混合 to mp4");
        this.d = false;
        if (videoMuxerData == null) {
            if (this.b != null) {
                zz9 zz9Var = new zz9();
                zz9Var.b = true;
                zz9Var.a = 24;
                zz9Var.c = "error_mixtrue";
                zz9Var.e = "音视频合成VideoMuxerData为空合成失败";
                this.b.onAudioVideoMuxerFail(zz9Var);
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
                    String f = gx9.c().f();
                    if (TextUtils.isEmpty(f)) {
                        sb.append("getMixVideoAudioDir 是空");
                        return;
                    }
                    FileUtils.mkdirs(f);
                    a aVar = a.this;
                    aVar.c = f + File.separator + "audio_video_" + System.currentTimeMillis() + DefaultHlsExtractorFactory.MP4_FILE_EXTENSION;
                    boolean j = y1a.j(sb, videoMuxerData.getFinalAudioPath(), videoMuxerData.getVideoPath(), a.this.c, 0L, -1L);
                    b bVar = new b();
                    if (j) {
                        bVar.b = a.this.c;
                    } else {
                        zz9 zz9Var2 = new zz9();
                        zz9Var2.b = true;
                        zz9Var2.a = 24;
                        zz9Var2.c = "error_mixtrue";
                        zz9Var2.e = " 预处理音乐合成失败-4 musicPath" + videoMuxerData.getFinalAudioPath() + " ,videoPath" + videoMuxerData.getVideoPath() + " ,outputVideoPath" + a.this.c + " ,muxResult:" + j + ",errorMsg" + sb.toString() + " ,audio file size =" + fileSize;
                        bVar.a = zz9Var2;
                    }
                    a0a.b("avMuxThead", "音视频混合:" + j);
                    a.this.a(bVar);
                }
            }).start();
        } else if (this.b != null) {
            zz9 zz9Var2 = new zz9();
            zz9Var2.b = true;
            zz9Var2.a = 24;
            zz9Var2.c = "error_mixtrue";
            zz9Var2.e = "musicPath" + videoMuxerData.getFinalAudioPath() + "outputVideoPath" + this.c + "videoPath: " + videoMuxerData.getVideoPath() + "muxResult:false 合成音乐视频路径丢失";
            this.b.onAudioVideoMuxerFail(zz9Var2);
        }
    }

    public void a(InterfaceC0503a interfaceC0503a) {
        this.b = interfaceC0503a;
    }
}
