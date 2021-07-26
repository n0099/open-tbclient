package com.baidu.ugc.editvideo.editvideo.muxer;

import android.text.TextUtils;
import android.util.Pair;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.data.VideoMuxerData;
import com.baidu.ugc.utils.FileUtils;
import d.a.w0.t.u;
import d.a.w0.t.w;
import d.a.w0.t.x;
import java.io.File;
import java.util.LinkedList;
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public LinkedList<Pair<String, Object>> f23863a;

    /* renamed from: b  reason: collision with root package name */
    public InterfaceC0253a f23864b;

    /* renamed from: c  reason: collision with root package name */
    public String f23865c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f23866d;

    /* renamed from: com.baidu.ugc.editvideo.editvideo.muxer.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0253a {
        void onAudioVideoMuxerCancel();

        void onAudioVideoMuxerFail(d.a.w0.m.a aVar);

        void onAudioVideoMuxerFinish(String str);
    }

    /* loaded from: classes5.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public d.a.w0.m.a f23872a;

        /* renamed from: b  reason: collision with root package name */
        public String f23873b;

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
        this.f23863a = new LinkedList<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, bVar) == null) {
            u.a().postDelayed(new Runnable(this, bVar) { // from class: com.baidu.ugc.editvideo.editvideo.muxer.a.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f23870a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ a f23871b;

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
                    this.f23871b = this;
                    this.f23870a = bVar;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (this.f23871b.f23866d) {
                            this.f23871b.a();
                        } else if (this.f23871b.f23864b != null) {
                            b bVar2 = this.f23870a;
                            if (bVar2 != null) {
                                if (w.a(bVar2.f23873b) || !FileUtils.checkFile(this.f23870a.f23873b)) {
                                    this.f23871b.f23864b.onAudioVideoMuxerFail(this.f23870a.f23872a);
                                    return;
                                } else {
                                    this.f23871b.f23864b.onAudioVideoMuxerFinish(this.f23870a.f23873b);
                                    return;
                                }
                            }
                            d.a.w0.m.a aVar = new d.a.w0.m.a();
                            aVar.f68763b = true;
                            aVar.f68762a = 24;
                            aVar.f68764c = "error_mixtrue";
                            aVar.f68766e = "合成音乐失败 MuxerMusicResult is null";
                            this.f23871b.f23864b.onAudioVideoMuxerFail(aVar);
                        }
                    }
                }
            }, 200L);
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f23866d = true;
            InterfaceC0253a interfaceC0253a = this.f23864b;
            if (interfaceC0253a != null) {
                interfaceC0253a.onAudioVideoMuxerCancel();
            }
            try {
                File file = new File(this.f23865c);
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
            d.a.w0.m.b.b("muxerAV2Mp4", "音视频混合 to mp4");
            this.f23866d = false;
            if (videoMuxerData == null) {
                if (this.f23864b != null) {
                    d.a.w0.m.a aVar = new d.a.w0.m.a();
                    aVar.f68763b = true;
                    aVar.f68762a = 24;
                    aVar.f68764c = "error_mixtrue";
                    aVar.f68766e = "音视频合成VideoMuxerData为空合成失败";
                    this.f23864b.onAudioVideoMuxerFail(aVar);
                    return;
                }
                return;
            }
            this.f23863a.add(new Pair<>("type", videoMuxerData.getLogType()));
            long fileSize = FileUtils.getFileSize(videoMuxerData.getFinalAudioPath());
            if (FileUtils.checkFile(videoMuxerData.getVideoPath())) {
                new Thread(new Runnable(this, videoMuxerData, fileSize) { // from class: com.baidu.ugc.editvideo.editvideo.muxer.a.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ VideoMuxerData f23867a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ long f23868b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ a f23869c;

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
                        this.f23869c = this;
                        this.f23867a = videoMuxerData;
                        this.f23868b = fileSize;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            StringBuilder sb = new StringBuilder();
                            String g2 = d.a.w0.b.d().g();
                            if (TextUtils.isEmpty(g2)) {
                                sb.append("getMixVideoAudioDir 是空");
                                return;
                            }
                            FileUtils.mkdirs(g2);
                            a aVar2 = this.f23869c;
                            aVar2.f23865c = g2 + File.separator + "audio_video_" + System.currentTimeMillis() + ".mp4";
                            boolean j = x.j(sb, this.f23867a.getFinalAudioPath(), this.f23867a.getVideoPath(), this.f23869c.f23865c, 0L, -1L);
                            b bVar = new b();
                            if (j) {
                                bVar.f23873b = this.f23869c.f23865c;
                            } else {
                                d.a.w0.m.a aVar3 = new d.a.w0.m.a();
                                aVar3.f68763b = true;
                                aVar3.f68762a = 24;
                                aVar3.f68764c = "error_mixtrue";
                                aVar3.f68766e = " 预处理音乐合成失败-4 musicPath" + this.f23867a.getFinalAudioPath() + " ,videoPath" + this.f23867a.getVideoPath() + " ,outputVideoPath" + this.f23869c.f23865c + " ,muxResult:" + j + ",errorMsg" + sb.toString() + " ,audio file size =" + this.f23868b;
                                bVar.f23872a = aVar3;
                            }
                            d.a.w0.m.b.b("avMuxThead", "音视频混合:" + j);
                            this.f23869c.a(bVar);
                        }
                    }
                }).start();
            } else if (this.f23864b != null) {
                d.a.w0.m.a aVar2 = new d.a.w0.m.a();
                aVar2.f68763b = true;
                aVar2.f68762a = 24;
                aVar2.f68764c = "error_mixtrue";
                aVar2.f68766e = "musicPath" + videoMuxerData.getFinalAudioPath() + "outputVideoPath" + this.f23865c + "videoPath: " + videoMuxerData.getVideoPath() + "muxResult:false 合成音乐视频路径丢失";
                this.f23864b.onAudioVideoMuxerFail(aVar2);
            }
        }
    }

    public void a(InterfaceC0253a interfaceC0253a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, interfaceC0253a) == null) {
            this.f23864b = interfaceC0253a;
        }
    }
}
