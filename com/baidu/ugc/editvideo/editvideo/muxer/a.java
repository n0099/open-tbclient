package com.baidu.ugc.editvideo.editvideo.muxer;

import android.text.TextUtils;
import android.util.Pair;
import c.a.a1.t.u;
import c.a.a1.t.w;
import c.a.a1.t.x;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.data.VideoMuxerData;
import com.baidu.ugc.utils.FileUtils;
import java.io.File;
import java.util.LinkedList;
/* loaded from: classes13.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinkedList<Pair<String, Object>> a;

    /* renamed from: b  reason: collision with root package name */
    public InterfaceC1980a f50334b;

    /* renamed from: c  reason: collision with root package name */
    public String f50335c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f50336d;

    /* renamed from: com.baidu.ugc.editvideo.editvideo.muxer.a$a  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public interface InterfaceC1980a {
        void onAudioVideoMuxerCancel();

        void onAudioVideoMuxerFail(c.a.a1.m.a aVar);

        void onAudioVideoMuxerFinish(String str);
    }

    /* loaded from: classes13.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public c.a.a1.m.a a;

        /* renamed from: b  reason: collision with root package name */
        public String f50340b;

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
                public final /* synthetic */ a f50339b;

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
                    this.f50339b = this;
                    this.a = bVar;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (this.f50339b.f50336d) {
                            this.f50339b.a();
                        } else if (this.f50339b.f50334b != null) {
                            b bVar2 = this.a;
                            if (bVar2 != null) {
                                if (w.a(bVar2.f50340b) || !FileUtils.checkFile(this.a.f50340b)) {
                                    this.f50339b.f50334b.onAudioVideoMuxerFail(this.a.a);
                                    return;
                                } else {
                                    this.f50339b.f50334b.onAudioVideoMuxerFinish(this.a.f50340b);
                                    return;
                                }
                            }
                            c.a.a1.m.a aVar = new c.a.a1.m.a();
                            aVar.f1336b = true;
                            aVar.a = 24;
                            aVar.f1337c = "error_mixtrue";
                            aVar.f1339e = "合成音乐失败 MuxerMusicResult is null";
                            this.f50339b.f50334b.onAudioVideoMuxerFail(aVar);
                        }
                    }
                }
            }, 200L);
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f50336d = true;
            InterfaceC1980a interfaceC1980a = this.f50334b;
            if (interfaceC1980a != null) {
                interfaceC1980a.onAudioVideoMuxerCancel();
            }
            try {
                File file = new File(this.f50335c);
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
            c.a.a1.m.b.b("muxerAV2Mp4", "音视频混合 to mp4");
            this.f50336d = false;
            if (videoMuxerData == null) {
                if (this.f50334b != null) {
                    c.a.a1.m.a aVar = new c.a.a1.m.a();
                    aVar.f1336b = true;
                    aVar.a = 24;
                    aVar.f1337c = "error_mixtrue";
                    aVar.f1339e = "音视频合成VideoMuxerData为空合成失败";
                    this.f50334b.onAudioVideoMuxerFail(aVar);
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
                    public final /* synthetic */ long f50337b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ a f50338c;

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
                        this.f50338c = this;
                        this.a = videoMuxerData;
                        this.f50337b = fileSize;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            StringBuilder sb = new StringBuilder();
                            String f2 = c.a.a1.b.c().f();
                            if (TextUtils.isEmpty(f2)) {
                                sb.append("getMixVideoAudioDir 是空");
                                return;
                            }
                            FileUtils.mkdirs(f2);
                            a aVar2 = this.f50338c;
                            aVar2.f50335c = f2 + File.separator + "audio_video_" + System.currentTimeMillis() + ".mp4";
                            boolean j2 = x.j(sb, this.a.getFinalAudioPath(), this.a.getVideoPath(), this.f50338c.f50335c, 0L, -1L);
                            b bVar = new b();
                            if (j2) {
                                bVar.f50340b = this.f50338c.f50335c;
                            } else {
                                c.a.a1.m.a aVar3 = new c.a.a1.m.a();
                                aVar3.f1336b = true;
                                aVar3.a = 24;
                                aVar3.f1337c = "error_mixtrue";
                                aVar3.f1339e = " 预处理音乐合成失败-4 musicPath" + this.a.getFinalAudioPath() + " ,videoPath" + this.a.getVideoPath() + " ,outputVideoPath" + this.f50338c.f50335c + " ,muxResult:" + j2 + ",errorMsg" + sb.toString() + " ,audio file size =" + this.f50337b;
                                bVar.a = aVar3;
                            }
                            c.a.a1.m.b.b("avMuxThead", "音视频混合:" + j2);
                            this.f50338c.a(bVar);
                        }
                    }
                }).start();
            } else if (this.f50334b != null) {
                c.a.a1.m.a aVar2 = new c.a.a1.m.a();
                aVar2.f1336b = true;
                aVar2.a = 24;
                aVar2.f1337c = "error_mixtrue";
                aVar2.f1339e = "musicPath" + videoMuxerData.getFinalAudioPath() + "outputVideoPath" + this.f50335c + "videoPath: " + videoMuxerData.getVideoPath() + "muxResult:false 合成音乐视频路径丢失";
                this.f50334b.onAudioVideoMuxerFail(aVar2);
            }
        }
    }

    public void a(InterfaceC1980a interfaceC1980a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, interfaceC1980a) == null) {
            this.f50334b = interfaceC1980a;
        }
    }
}
