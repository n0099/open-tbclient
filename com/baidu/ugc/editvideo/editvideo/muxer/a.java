package com.baidu.ugc.editvideo.editvideo.muxer;

import android.text.TextUtils;
import android.util.Pair;
import c.a.x0.t.u;
import c.a.x0.t.w;
import c.a.x0.t.x;
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
    public LinkedList<Pair<String, Object>> f60148a;

    /* renamed from: b  reason: collision with root package name */
    public InterfaceC1819a f60149b;

    /* renamed from: c  reason: collision with root package name */
    public String f60150c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f60151d;

    /* renamed from: com.baidu.ugc.editvideo.editvideo.muxer.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC1819a {
        void onAudioVideoMuxerCancel();

        void onAudioVideoMuxerFail(c.a.x0.m.a aVar);

        void onAudioVideoMuxerFinish(String str);
    }

    /* loaded from: classes8.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public c.a.x0.m.a f60157a;

        /* renamed from: b  reason: collision with root package name */
        public String f60158b;

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
        this.f60148a = new LinkedList<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, bVar) == null) {
            u.a().postDelayed(new Runnable(this, bVar) { // from class: com.baidu.ugc.editvideo.editvideo.muxer.a.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f60155a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ a f60156b;

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
                    this.f60156b = this;
                    this.f60155a = bVar;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (this.f60156b.f60151d) {
                            this.f60156b.a();
                        } else if (this.f60156b.f60149b != null) {
                            b bVar2 = this.f60155a;
                            if (bVar2 != null) {
                                if (w.a(bVar2.f60158b) || !FileUtils.checkFile(this.f60155a.f60158b)) {
                                    this.f60156b.f60149b.onAudioVideoMuxerFail(this.f60155a.f60157a);
                                    return;
                                } else {
                                    this.f60156b.f60149b.onAudioVideoMuxerFinish(this.f60155a.f60158b);
                                    return;
                                }
                            }
                            c.a.x0.m.a aVar = new c.a.x0.m.a();
                            aVar.f31060b = true;
                            aVar.f31059a = 24;
                            aVar.f31061c = "error_mixtrue";
                            aVar.f31063e = "合成音乐失败 MuxerMusicResult is null";
                            this.f60156b.f60149b.onAudioVideoMuxerFail(aVar);
                        }
                    }
                }
            }, 200L);
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f60151d = true;
            InterfaceC1819a interfaceC1819a = this.f60149b;
            if (interfaceC1819a != null) {
                interfaceC1819a.onAudioVideoMuxerCancel();
            }
            try {
                File file = new File(this.f60150c);
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
            c.a.x0.m.b.b("muxerAV2Mp4", "音视频混合 to mp4");
            this.f60151d = false;
            if (videoMuxerData == null) {
                if (this.f60149b != null) {
                    c.a.x0.m.a aVar = new c.a.x0.m.a();
                    aVar.f31060b = true;
                    aVar.f31059a = 24;
                    aVar.f31061c = "error_mixtrue";
                    aVar.f31063e = "音视频合成VideoMuxerData为空合成失败";
                    this.f60149b.onAudioVideoMuxerFail(aVar);
                    return;
                }
                return;
            }
            this.f60148a.add(new Pair<>("type", videoMuxerData.getLogType()));
            long fileSize = FileUtils.getFileSize(videoMuxerData.getFinalAudioPath());
            if (FileUtils.checkFile(videoMuxerData.getVideoPath())) {
                new Thread(new Runnable(this, videoMuxerData, fileSize) { // from class: com.baidu.ugc.editvideo.editvideo.muxer.a.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ VideoMuxerData f60152a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ long f60153b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ a f60154c;

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
                        this.f60154c = this;
                        this.f60152a = videoMuxerData;
                        this.f60153b = fileSize;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            StringBuilder sb = new StringBuilder();
                            String g2 = c.a.x0.b.d().g();
                            if (TextUtils.isEmpty(g2)) {
                                sb.append("getMixVideoAudioDir 是空");
                                return;
                            }
                            FileUtils.mkdirs(g2);
                            a aVar2 = this.f60154c;
                            aVar2.f60150c = g2 + File.separator + "audio_video_" + System.currentTimeMillis() + ".mp4";
                            boolean j2 = x.j(sb, this.f60152a.getFinalAudioPath(), this.f60152a.getVideoPath(), this.f60154c.f60150c, 0L, -1L);
                            b bVar = new b();
                            if (j2) {
                                bVar.f60158b = this.f60154c.f60150c;
                            } else {
                                c.a.x0.m.a aVar3 = new c.a.x0.m.a();
                                aVar3.f31060b = true;
                                aVar3.f31059a = 24;
                                aVar3.f31061c = "error_mixtrue";
                                aVar3.f31063e = " 预处理音乐合成失败-4 musicPath" + this.f60152a.getFinalAudioPath() + " ,videoPath" + this.f60152a.getVideoPath() + " ,outputVideoPath" + this.f60154c.f60150c + " ,muxResult:" + j2 + ",errorMsg" + sb.toString() + " ,audio file size =" + this.f60153b;
                                bVar.f60157a = aVar3;
                            }
                            c.a.x0.m.b.b("avMuxThead", "音视频混合:" + j2);
                            this.f60154c.a(bVar);
                        }
                    }
                }).start();
            } else if (this.f60149b != null) {
                c.a.x0.m.a aVar2 = new c.a.x0.m.a();
                aVar2.f31060b = true;
                aVar2.f31059a = 24;
                aVar2.f31061c = "error_mixtrue";
                aVar2.f31063e = "musicPath" + videoMuxerData.getFinalAudioPath() + "outputVideoPath" + this.f60150c + "videoPath: " + videoMuxerData.getVideoPath() + "muxResult:false 合成音乐视频路径丢失";
                this.f60149b.onAudioVideoMuxerFail(aVar2);
            }
        }
    }

    public void a(InterfaceC1819a interfaceC1819a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, interfaceC1819a) == null) {
            this.f60149b = interfaceC1819a;
        }
    }
}
