package com.baidu.ugc.editvideo.editvideo.muxer;

import android.text.TextUtils;
import android.util.Pair;
import b.a.x0.t.u;
import b.a.x0.t.w;
import b.a.x0.t.x;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.data.VideoMuxerData;
import com.baidu.ugc.utils.FileUtils;
import java.io.File;
import java.util.LinkedList;
/* loaded from: classes10.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public LinkedList<Pair<String, Object>> f57985a;

    /* renamed from: b  reason: collision with root package name */
    public InterfaceC1819a f57986b;

    /* renamed from: c  reason: collision with root package name */
    public String f57987c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f57988d;

    /* renamed from: com.baidu.ugc.editvideo.editvideo.muxer.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC1819a {
        void onAudioVideoMuxerCancel();

        void onAudioVideoMuxerFail(b.a.x0.m.a aVar);

        void onAudioVideoMuxerFinish(String str);
    }

    /* loaded from: classes10.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public b.a.x0.m.a f57994a;

        /* renamed from: b  reason: collision with root package name */
        public String f57995b;

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
        this.f57985a = new LinkedList<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, bVar) == null) {
            u.a().postDelayed(new Runnable(this, bVar) { // from class: com.baidu.ugc.editvideo.editvideo.muxer.a.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f57992a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ a f57993b;

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
                    this.f57993b = this;
                    this.f57992a = bVar;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (this.f57993b.f57988d) {
                            this.f57993b.a();
                        } else if (this.f57993b.f57986b != null) {
                            b bVar2 = this.f57992a;
                            if (bVar2 != null) {
                                if (w.a(bVar2.f57995b) || !FileUtils.checkFile(this.f57992a.f57995b)) {
                                    this.f57993b.f57986b.onAudioVideoMuxerFail(this.f57992a.f57994a);
                                    return;
                                } else {
                                    this.f57993b.f57986b.onAudioVideoMuxerFinish(this.f57992a.f57995b);
                                    return;
                                }
                            }
                            b.a.x0.m.a aVar = new b.a.x0.m.a();
                            aVar.f30629b = true;
                            aVar.f30628a = 24;
                            aVar.f30630c = "error_mixtrue";
                            aVar.f30632e = "合成音乐失败 MuxerMusicResult is null";
                            this.f57993b.f57986b.onAudioVideoMuxerFail(aVar);
                        }
                    }
                }
            }, 200L);
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f57988d = true;
            InterfaceC1819a interfaceC1819a = this.f57986b;
            if (interfaceC1819a != null) {
                interfaceC1819a.onAudioVideoMuxerCancel();
            }
            try {
                File file = new File(this.f57987c);
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
            b.a.x0.m.b.b("muxerAV2Mp4", "音视频混合 to mp4");
            this.f57988d = false;
            if (videoMuxerData == null) {
                if (this.f57986b != null) {
                    b.a.x0.m.a aVar = new b.a.x0.m.a();
                    aVar.f30629b = true;
                    aVar.f30628a = 24;
                    aVar.f30630c = "error_mixtrue";
                    aVar.f30632e = "音视频合成VideoMuxerData为空合成失败";
                    this.f57986b.onAudioVideoMuxerFail(aVar);
                    return;
                }
                return;
            }
            this.f57985a.add(new Pair<>("type", videoMuxerData.getLogType()));
            long fileSize = FileUtils.getFileSize(videoMuxerData.getFinalAudioPath());
            if (FileUtils.checkFile(videoMuxerData.getVideoPath())) {
                new Thread(new Runnable(this, videoMuxerData, fileSize) { // from class: com.baidu.ugc.editvideo.editvideo.muxer.a.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ VideoMuxerData f57989a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ long f57990b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ a f57991c;

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
                        this.f57991c = this;
                        this.f57989a = videoMuxerData;
                        this.f57990b = fileSize;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            StringBuilder sb = new StringBuilder();
                            String f2 = b.a.x0.b.c().f();
                            if (TextUtils.isEmpty(f2)) {
                                sb.append("getMixVideoAudioDir 是空");
                                return;
                            }
                            FileUtils.mkdirs(f2);
                            a aVar2 = this.f57991c;
                            aVar2.f57987c = f2 + File.separator + "audio_video_" + System.currentTimeMillis() + ".mp4";
                            boolean j = x.j(sb, this.f57989a.getFinalAudioPath(), this.f57989a.getVideoPath(), this.f57991c.f57987c, 0L, -1L);
                            b bVar = new b();
                            if (j) {
                                bVar.f57995b = this.f57991c.f57987c;
                            } else {
                                b.a.x0.m.a aVar3 = new b.a.x0.m.a();
                                aVar3.f30629b = true;
                                aVar3.f30628a = 24;
                                aVar3.f30630c = "error_mixtrue";
                                aVar3.f30632e = " 预处理音乐合成失败-4 musicPath" + this.f57989a.getFinalAudioPath() + " ,videoPath" + this.f57989a.getVideoPath() + " ,outputVideoPath" + this.f57991c.f57987c + " ,muxResult:" + j + ",errorMsg" + sb.toString() + " ,audio file size =" + this.f57990b;
                                bVar.f57994a = aVar3;
                            }
                            b.a.x0.m.b.b("avMuxThead", "音视频混合:" + j);
                            this.f57991c.a(bVar);
                        }
                    }
                }).start();
            } else if (this.f57986b != null) {
                b.a.x0.m.a aVar2 = new b.a.x0.m.a();
                aVar2.f30629b = true;
                aVar2.f30628a = 24;
                aVar2.f30630c = "error_mixtrue";
                aVar2.f30632e = "musicPath" + videoMuxerData.getFinalAudioPath() + "outputVideoPath" + this.f57987c + "videoPath: " + videoMuxerData.getVideoPath() + "muxResult:false 合成音乐视频路径丢失";
                this.f57986b.onAudioVideoMuxerFail(aVar2);
            }
        }
    }

    public void a(InterfaceC1819a interfaceC1819a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, interfaceC1819a) == null) {
            this.f57986b = interfaceC1819a;
        }
    }
}
