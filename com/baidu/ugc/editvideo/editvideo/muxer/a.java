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
    public LinkedList<Pair<String, Object>> f60113a;

    /* renamed from: b  reason: collision with root package name */
    public InterfaceC1817a f60114b;

    /* renamed from: c  reason: collision with root package name */
    public String f60115c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f60116d;

    /* renamed from: com.baidu.ugc.editvideo.editvideo.muxer.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC1817a {
        void onAudioVideoMuxerCancel();

        void onAudioVideoMuxerFail(c.a.x0.m.a aVar);

        void onAudioVideoMuxerFinish(String str);
    }

    /* loaded from: classes8.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public c.a.x0.m.a f60122a;

        /* renamed from: b  reason: collision with root package name */
        public String f60123b;

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
        this.f60113a = new LinkedList<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, bVar) == null) {
            u.a().postDelayed(new Runnable(this, bVar) { // from class: com.baidu.ugc.editvideo.editvideo.muxer.a.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f60120a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ a f60121b;

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
                    this.f60121b = this;
                    this.f60120a = bVar;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (this.f60121b.f60116d) {
                            this.f60121b.a();
                        } else if (this.f60121b.f60114b != null) {
                            b bVar2 = this.f60120a;
                            if (bVar2 != null) {
                                if (w.a(bVar2.f60123b) || !FileUtils.checkFile(this.f60120a.f60123b)) {
                                    this.f60121b.f60114b.onAudioVideoMuxerFail(this.f60120a.f60122a);
                                    return;
                                } else {
                                    this.f60121b.f60114b.onAudioVideoMuxerFinish(this.f60120a.f60123b);
                                    return;
                                }
                            }
                            c.a.x0.m.a aVar = new c.a.x0.m.a();
                            aVar.f31013b = true;
                            aVar.f31012a = 24;
                            aVar.f31014c = "error_mixtrue";
                            aVar.f31016e = "合成音乐失败 MuxerMusicResult is null";
                            this.f60121b.f60114b.onAudioVideoMuxerFail(aVar);
                        }
                    }
                }
            }, 200L);
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f60116d = true;
            InterfaceC1817a interfaceC1817a = this.f60114b;
            if (interfaceC1817a != null) {
                interfaceC1817a.onAudioVideoMuxerCancel();
            }
            try {
                File file = new File(this.f60115c);
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
            this.f60116d = false;
            if (videoMuxerData == null) {
                if (this.f60114b != null) {
                    c.a.x0.m.a aVar = new c.a.x0.m.a();
                    aVar.f31013b = true;
                    aVar.f31012a = 24;
                    aVar.f31014c = "error_mixtrue";
                    aVar.f31016e = "音视频合成VideoMuxerData为空合成失败";
                    this.f60114b.onAudioVideoMuxerFail(aVar);
                    return;
                }
                return;
            }
            this.f60113a.add(new Pair<>("type", videoMuxerData.getLogType()));
            long fileSize = FileUtils.getFileSize(videoMuxerData.getFinalAudioPath());
            if (FileUtils.checkFile(videoMuxerData.getVideoPath())) {
                new Thread(new Runnable(this, videoMuxerData, fileSize) { // from class: com.baidu.ugc.editvideo.editvideo.muxer.a.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ VideoMuxerData f60117a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ long f60118b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ a f60119c;

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
                        this.f60119c = this;
                        this.f60117a = videoMuxerData;
                        this.f60118b = fileSize;
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
                            a aVar2 = this.f60119c;
                            aVar2.f60115c = g2 + File.separator + "audio_video_" + System.currentTimeMillis() + ".mp4";
                            boolean j2 = x.j(sb, this.f60117a.getFinalAudioPath(), this.f60117a.getVideoPath(), this.f60119c.f60115c, 0L, -1L);
                            b bVar = new b();
                            if (j2) {
                                bVar.f60123b = this.f60119c.f60115c;
                            } else {
                                c.a.x0.m.a aVar3 = new c.a.x0.m.a();
                                aVar3.f31013b = true;
                                aVar3.f31012a = 24;
                                aVar3.f31014c = "error_mixtrue";
                                aVar3.f31016e = " 预处理音乐合成失败-4 musicPath" + this.f60117a.getFinalAudioPath() + " ,videoPath" + this.f60117a.getVideoPath() + " ,outputVideoPath" + this.f60119c.f60115c + " ,muxResult:" + j2 + ",errorMsg" + sb.toString() + " ,audio file size =" + this.f60118b;
                                bVar.f60122a = aVar3;
                            }
                            c.a.x0.m.b.b("avMuxThead", "音视频混合:" + j2);
                            this.f60119c.a(bVar);
                        }
                    }
                }).start();
            } else if (this.f60114b != null) {
                c.a.x0.m.a aVar2 = new c.a.x0.m.a();
                aVar2.f31013b = true;
                aVar2.f31012a = 24;
                aVar2.f31014c = "error_mixtrue";
                aVar2.f31016e = "musicPath" + videoMuxerData.getFinalAudioPath() + "outputVideoPath" + this.f60115c + "videoPath: " + videoMuxerData.getVideoPath() + "muxResult:false 合成音乐视频路径丢失";
                this.f60114b.onAudioVideoMuxerFail(aVar2);
            }
        }
    }

    public void a(InterfaceC1817a interfaceC1817a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, interfaceC1817a) == null) {
            this.f60114b = interfaceC1817a;
        }
    }
}
