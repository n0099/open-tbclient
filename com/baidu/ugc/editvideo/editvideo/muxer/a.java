package com.baidu.ugc.editvideo.editvideo.muxer;

import android.text.TextUtils;
import android.util.Pair;
import c.a.v0.r.u;
import c.a.v0.r.w;
import c.a.v0.r.x;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.data.VideoMuxerData;
import com.baidu.ugc.utils.FileUtils;
import com.google.android.exoplayer2.source.hls.DefaultHlsExtractorFactory;
import java.io.File;
import java.util.LinkedList;
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinkedList<Pair<String, Object>> a;

    /* renamed from: b  reason: collision with root package name */
    public InterfaceC1908a f37809b;

    /* renamed from: c  reason: collision with root package name */
    public String f37810c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f37811d;

    /* renamed from: com.baidu.ugc.editvideo.editvideo.muxer.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC1908a {
        void onAudioVideoMuxerCancel();

        void onAudioVideoMuxerFail(c.a.v0.m.a aVar);

        void onAudioVideoMuxerFinish(String str);
    }

    /* loaded from: classes6.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public c.a.v0.m.a a;

        /* renamed from: b  reason: collision with root package name */
        public String f37815b;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new LinkedList<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, bVar) == null) {
            u.a().postDelayed(new Runnable(this, bVar) { // from class: com.baidu.ugc.editvideo.editvideo.muxer.a.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ b a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ a f37814b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, bVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f37814b = this;
                    this.a = bVar;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (this.f37814b.f37811d) {
                            this.f37814b.a();
                        } else if (this.f37814b.f37809b != null) {
                            b bVar2 = this.a;
                            if (bVar2 != null) {
                                if (w.a(bVar2.f37815b) || !FileUtils.checkFile(this.a.f37815b)) {
                                    this.f37814b.f37809b.onAudioVideoMuxerFail(this.a.a);
                                    return;
                                } else {
                                    this.f37814b.f37809b.onAudioVideoMuxerFinish(this.a.f37815b);
                                    return;
                                }
                            }
                            c.a.v0.m.a aVar = new c.a.v0.m.a();
                            aVar.f21727b = true;
                            aVar.a = 24;
                            aVar.f21728c = "error_mixtrue";
                            aVar.f21730e = "合成音乐失败 MuxerMusicResult is null";
                            this.f37814b.f37809b.onAudioVideoMuxerFail(aVar);
                        }
                    }
                }
            }, 200L);
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f37811d = true;
            InterfaceC1908a interfaceC1908a = this.f37809b;
            if (interfaceC1908a != null) {
                interfaceC1908a.onAudioVideoMuxerCancel();
            }
            try {
                File file = new File(this.f37810c);
                if (file.exists()) {
                    file.delete();
                }
            } catch (Exception unused) {
            }
        }
    }

    public void a(VideoMuxerData videoMuxerData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, videoMuxerData) == null) {
            c.a.v0.m.b.b("muxerAV2Mp4", "音视频混合 to mp4");
            this.f37811d = false;
            if (videoMuxerData == null) {
                if (this.f37809b != null) {
                    c.a.v0.m.a aVar = new c.a.v0.m.a();
                    aVar.f21727b = true;
                    aVar.a = 24;
                    aVar.f21728c = "error_mixtrue";
                    aVar.f21730e = "音视频合成VideoMuxerData为空合成失败";
                    this.f37809b.onAudioVideoMuxerFail(aVar);
                    return;
                }
                return;
            }
            this.a.add(new Pair<>("type", videoMuxerData.getLogType()));
            long fileSize = FileUtils.getFileSize(videoMuxerData.getFinalAudioPath());
            if (FileUtils.checkFile(videoMuxerData.getVideoPath())) {
                new Thread(new Runnable(this, videoMuxerData, fileSize) { // from class: com.baidu.ugc.editvideo.editvideo.muxer.a.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ VideoMuxerData a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ long f37812b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ a f37813c;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, videoMuxerData, Long.valueOf(fileSize)};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f37813c = this;
                        this.a = videoMuxerData;
                        this.f37812b = fileSize;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            StringBuilder sb = new StringBuilder();
                            String f2 = c.a.v0.b.c().f();
                            if (TextUtils.isEmpty(f2)) {
                                sb.append("getMixVideoAudioDir 是空");
                                return;
                            }
                            FileUtils.mkdirs(f2);
                            a aVar2 = this.f37813c;
                            aVar2.f37810c = f2 + File.separator + "audio_video_" + System.currentTimeMillis() + DefaultHlsExtractorFactory.MP4_FILE_EXTENSION;
                            boolean j = x.j(sb, this.a.getFinalAudioPath(), this.a.getVideoPath(), this.f37813c.f37810c, 0L, -1L);
                            b bVar = new b();
                            if (j) {
                                bVar.f37815b = this.f37813c.f37810c;
                            } else {
                                c.a.v0.m.a aVar3 = new c.a.v0.m.a();
                                aVar3.f21727b = true;
                                aVar3.a = 24;
                                aVar3.f21728c = "error_mixtrue";
                                aVar3.f21730e = " 预处理音乐合成失败-4 musicPath" + this.a.getFinalAudioPath() + " ,videoPath" + this.a.getVideoPath() + " ,outputVideoPath" + this.f37813c.f37810c + " ,muxResult:" + j + ",errorMsg" + sb.toString() + " ,audio file size =" + this.f37812b;
                                bVar.a = aVar3;
                            }
                            c.a.v0.m.b.b("avMuxThead", "音视频混合:" + j);
                            this.f37813c.a(bVar);
                        }
                    }
                }).start();
            } else if (this.f37809b != null) {
                c.a.v0.m.a aVar2 = new c.a.v0.m.a();
                aVar2.f21727b = true;
                aVar2.a = 24;
                aVar2.f21728c = "error_mixtrue";
                aVar2.f21730e = "musicPath" + videoMuxerData.getFinalAudioPath() + "outputVideoPath" + this.f37810c + "videoPath: " + videoMuxerData.getVideoPath() + "muxResult:false 合成音乐视频路径丢失";
                this.f37809b.onAudioVideoMuxerFail(aVar2);
            }
        }
    }

    public void a(InterfaceC1908a interfaceC1908a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, interfaceC1908a) == null) {
            this.f37809b = interfaceC1908a;
        }
    }
}
