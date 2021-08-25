package com.baidu.ugc.editvideo.editvideo.muxer;

import android.text.TextUtils;
import android.util.Pair;
import c.a.w0.t.u;
import c.a.w0.t.w;
import c.a.w0.t.x;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.data.VideoMuxerData;
import com.baidu.ugc.utils.FileUtils;
import java.io.File;
import java.util.LinkedList;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public LinkedList<Pair<String, Object>> f59802a;

    /* renamed from: b  reason: collision with root package name */
    public InterfaceC1814a f59803b;

    /* renamed from: c  reason: collision with root package name */
    public String f59804c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f59805d;

    /* renamed from: com.baidu.ugc.editvideo.editvideo.muxer.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC1814a {
        void onAudioVideoMuxerCancel();

        void onAudioVideoMuxerFail(c.a.w0.m.a aVar);

        void onAudioVideoMuxerFinish(String str);
    }

    /* loaded from: classes8.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public c.a.w0.m.a f59811a;

        /* renamed from: b  reason: collision with root package name */
        public String f59812b;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f59802a = new LinkedList<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, bVar) == null) {
            u.a().postDelayed(new Runnable(this, bVar) { // from class: com.baidu.ugc.editvideo.editvideo.muxer.a.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f59809a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ a f59810b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, bVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f59810b = this;
                    this.f59809a = bVar;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (this.f59810b.f59805d) {
                            this.f59810b.a();
                        } else if (this.f59810b.f59803b != null) {
                            b bVar2 = this.f59809a;
                            if (bVar2 != null) {
                                if (w.a(bVar2.f59812b) || !FileUtils.checkFile(this.f59809a.f59812b)) {
                                    this.f59810b.f59803b.onAudioVideoMuxerFail(this.f59809a.f59811a);
                                    return;
                                } else {
                                    this.f59810b.f59803b.onAudioVideoMuxerFinish(this.f59809a.f59812b);
                                    return;
                                }
                            }
                            c.a.w0.m.a aVar = new c.a.w0.m.a();
                            aVar.f30760b = true;
                            aVar.f30759a = 24;
                            aVar.f30761c = "error_mixtrue";
                            aVar.f30763e = "合成音乐失败 MuxerMusicResult is null";
                            this.f59810b.f59803b.onAudioVideoMuxerFail(aVar);
                        }
                    }
                }
            }, 200L);
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f59805d = true;
            InterfaceC1814a interfaceC1814a = this.f59803b;
            if (interfaceC1814a != null) {
                interfaceC1814a.onAudioVideoMuxerCancel();
            }
            try {
                File file = new File(this.f59804c);
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
            c.a.w0.m.b.b("muxerAV2Mp4", "音视频混合 to mp4");
            this.f59805d = false;
            if (videoMuxerData == null) {
                if (this.f59803b != null) {
                    c.a.w0.m.a aVar = new c.a.w0.m.a();
                    aVar.f30760b = true;
                    aVar.f30759a = 24;
                    aVar.f30761c = "error_mixtrue";
                    aVar.f30763e = "音视频合成VideoMuxerData为空合成失败";
                    this.f59803b.onAudioVideoMuxerFail(aVar);
                    return;
                }
                return;
            }
            this.f59802a.add(new Pair<>("type", videoMuxerData.getLogType()));
            long fileSize = FileUtils.getFileSize(videoMuxerData.getFinalAudioPath());
            if (FileUtils.checkFile(videoMuxerData.getVideoPath())) {
                new Thread(new Runnable(this, videoMuxerData, fileSize) { // from class: com.baidu.ugc.editvideo.editvideo.muxer.a.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ VideoMuxerData f59806a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ long f59807b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ a f59808c;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, videoMuxerData, Long.valueOf(fileSize)};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f59808c = this;
                        this.f59806a = videoMuxerData;
                        this.f59807b = fileSize;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            StringBuilder sb = new StringBuilder();
                            String g2 = c.a.w0.b.d().g();
                            if (TextUtils.isEmpty(g2)) {
                                sb.append("getMixVideoAudioDir 是空");
                                return;
                            }
                            FileUtils.mkdirs(g2);
                            a aVar2 = this.f59808c;
                            aVar2.f59804c = g2 + File.separator + "audio_video_" + System.currentTimeMillis() + ".mp4";
                            boolean j2 = x.j(sb, this.f59806a.getFinalAudioPath(), this.f59806a.getVideoPath(), this.f59808c.f59804c, 0L, -1L);
                            b bVar = new b();
                            if (j2) {
                                bVar.f59812b = this.f59808c.f59804c;
                            } else {
                                c.a.w0.m.a aVar3 = new c.a.w0.m.a();
                                aVar3.f30760b = true;
                                aVar3.f30759a = 24;
                                aVar3.f30761c = "error_mixtrue";
                                aVar3.f30763e = " 预处理音乐合成失败-4 musicPath" + this.f59806a.getFinalAudioPath() + " ,videoPath" + this.f59806a.getVideoPath() + " ,outputVideoPath" + this.f59808c.f59804c + " ,muxResult:" + j2 + ",errorMsg" + sb.toString() + " ,audio file size =" + this.f59807b;
                                bVar.f59811a = aVar3;
                            }
                            c.a.w0.m.b.b("avMuxThead", "音视频混合:" + j2);
                            this.f59808c.a(bVar);
                        }
                    }
                }).start();
            } else if (this.f59803b != null) {
                c.a.w0.m.a aVar2 = new c.a.w0.m.a();
                aVar2.f30760b = true;
                aVar2.f30759a = 24;
                aVar2.f30761c = "error_mixtrue";
                aVar2.f30763e = "musicPath" + videoMuxerData.getFinalAudioPath() + "outputVideoPath" + this.f59804c + "videoPath: " + videoMuxerData.getVideoPath() + "muxResult:false 合成音乐视频路径丢失";
                this.f59803b.onAudioVideoMuxerFail(aVar2);
            }
        }
    }

    public void a(InterfaceC1814a interfaceC1814a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, interfaceC1814a) == null) {
            this.f59803b = interfaceC1814a;
        }
    }
}
