package com.baidu.ugc.editvideo.editvideo.muxer;

import android.text.TextUtils;
import android.util.Pair;
import com.baidu.tieba.kxb;
import com.baidu.tieba.mxb;
import com.baidu.tieba.nxb;
import com.baidu.tieba.ovb;
import com.baidu.tieba.pvb;
import com.baidu.tieba.vsb;
import com.baidu.ugc.editvideo.data.VideoMuxerData;
import com.baidu.ugc.utils.FileUtils;
import com.google.android.exoplayer2.source.hls.DefaultHlsExtractorFactory;
import java.io.File;
import java.util.LinkedList;
/* loaded from: classes9.dex */
public class a {
    public LinkedList<Pair<String, Object>> a = new LinkedList<>();
    public InterfaceC0558a b;
    public String c;
    public boolean d;

    /* renamed from: com.baidu.ugc.editvideo.editvideo.muxer.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0558a {
        void onAudioVideoMuxerCancel();

        void onAudioVideoMuxerFail(ovb ovbVar);

        void onAudioVideoMuxerFinish(String str);
    }

    /* loaded from: classes9.dex */
    public static class b {
        public ovb a;
        public String b;

        public b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final b bVar) {
        kxb.a().postDelayed(new Runnable() { // from class: com.baidu.ugc.editvideo.editvideo.muxer.a.2
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.d) {
                    a.this.a();
                } else if (a.this.b != null) {
                    b bVar2 = bVar;
                    if (bVar2 != null) {
                        if (mxb.a(bVar2.b) || !FileUtils.checkFile(bVar.b)) {
                            a.this.b.onAudioVideoMuxerFail(bVar.a);
                            return;
                        } else {
                            a.this.b.onAudioVideoMuxerFinish(bVar.b);
                            return;
                        }
                    }
                    ovb ovbVar = new ovb();
                    ovbVar.b = true;
                    ovbVar.a = 24;
                    ovbVar.c = "error_mixtrue";
                    ovbVar.e = "合成音乐失败 MuxerMusicResult is null";
                    a.this.b.onAudioVideoMuxerFail(ovbVar);
                }
            }
        }, 200L);
    }

    public void a() {
        this.d = true;
        InterfaceC0558a interfaceC0558a = this.b;
        if (interfaceC0558a != null) {
            interfaceC0558a.onAudioVideoMuxerCancel();
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
        pvb.b("muxerAV2Mp4", "音视频混合 to mp4");
        this.d = false;
        if (videoMuxerData == null) {
            if (this.b != null) {
                ovb ovbVar = new ovb();
                ovbVar.b = true;
                ovbVar.a = 24;
                ovbVar.c = "error_mixtrue";
                ovbVar.e = "音视频合成VideoMuxerData为空合成失败";
                this.b.onAudioVideoMuxerFail(ovbVar);
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
                    String g = vsb.d().g();
                    if (TextUtils.isEmpty(g)) {
                        sb.append("getMixVideoAudioDir 是空");
                        return;
                    }
                    FileUtils.mkdirs(g);
                    a aVar = a.this;
                    aVar.c = g + File.separator + "audio_video_" + System.currentTimeMillis() + DefaultHlsExtractorFactory.MP4_FILE_EXTENSION;
                    boolean j = nxb.j(sb, videoMuxerData.getFinalAudioPath(), videoMuxerData.getVideoPath(), a.this.c, 0L, -1L);
                    b bVar = new b();
                    if (j) {
                        bVar.b = a.this.c;
                    } else {
                        ovb ovbVar2 = new ovb();
                        ovbVar2.b = true;
                        ovbVar2.a = 24;
                        ovbVar2.c = "error_mixtrue";
                        ovbVar2.e = " 预处理音乐合成失败-4 musicPath" + videoMuxerData.getFinalAudioPath() + " ,videoPath" + videoMuxerData.getVideoPath() + " ,outputVideoPath" + a.this.c + " ,muxResult:" + j + ",errorMsg" + sb.toString() + " ,audio file size =" + fileSize;
                        bVar.a = ovbVar2;
                    }
                    pvb.b("avMuxThead", "音视频混合:" + j);
                    a.this.a(bVar);
                }
            }).start();
        } else if (this.b != null) {
            ovb ovbVar2 = new ovb();
            ovbVar2.b = true;
            ovbVar2.a = 24;
            ovbVar2.c = "error_mixtrue";
            ovbVar2.e = "musicPath" + videoMuxerData.getFinalAudioPath() + "outputVideoPath" + this.c + "videoPath: " + videoMuxerData.getVideoPath() + "muxResult:false 合成音乐视频路径丢失";
            this.b.onAudioVideoMuxerFail(ovbVar2);
        }
    }

    public void a(InterfaceC0558a interfaceC0558a) {
        this.b = interfaceC0558a;
    }
}
