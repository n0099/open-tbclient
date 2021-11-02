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
    public LinkedList<Pair<String, Object>> f57064a;

    /* renamed from: b  reason: collision with root package name */
    public InterfaceC1778a f57065b;

    /* renamed from: c  reason: collision with root package name */
    public String f57066c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f57067d;

    /* renamed from: com.baidu.ugc.editvideo.editvideo.muxer.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC1778a {
        void onAudioVideoMuxerCancel();

        void onAudioVideoMuxerFail(b.a.x0.m.a aVar);

        void onAudioVideoMuxerFinish(String str);
    }

    /* loaded from: classes10.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public b.a.x0.m.a f57073a;

        /* renamed from: b  reason: collision with root package name */
        public String f57074b;

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
        this.f57064a = new LinkedList<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, bVar) == null) {
            u.a().postDelayed(new Runnable(this, bVar) { // from class: com.baidu.ugc.editvideo.editvideo.muxer.a.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f57071a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ a f57072b;

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
                    this.f57072b = this;
                    this.f57071a = bVar;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (this.f57072b.f57067d) {
                            this.f57072b.a();
                        } else if (this.f57072b.f57065b != null) {
                            b bVar2 = this.f57071a;
                            if (bVar2 != null) {
                                if (w.a(bVar2.f57074b) || !FileUtils.checkFile(this.f57071a.f57074b)) {
                                    this.f57072b.f57065b.onAudioVideoMuxerFail(this.f57071a.f57073a);
                                    return;
                                } else {
                                    this.f57072b.f57065b.onAudioVideoMuxerFinish(this.f57071a.f57074b);
                                    return;
                                }
                            }
                            b.a.x0.m.a aVar = new b.a.x0.m.a();
                            aVar.f29760b = true;
                            aVar.f29759a = 24;
                            aVar.f29761c = "error_mixtrue";
                            aVar.f29763e = "合成音乐失败 MuxerMusicResult is null";
                            this.f57072b.f57065b.onAudioVideoMuxerFail(aVar);
                        }
                    }
                }
            }, 200L);
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f57067d = true;
            InterfaceC1778a interfaceC1778a = this.f57065b;
            if (interfaceC1778a != null) {
                interfaceC1778a.onAudioVideoMuxerCancel();
            }
            try {
                File file = new File(this.f57066c);
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
            this.f57067d = false;
            if (videoMuxerData == null) {
                if (this.f57065b != null) {
                    b.a.x0.m.a aVar = new b.a.x0.m.a();
                    aVar.f29760b = true;
                    aVar.f29759a = 24;
                    aVar.f29761c = "error_mixtrue";
                    aVar.f29763e = "音视频合成VideoMuxerData为空合成失败";
                    this.f57065b.onAudioVideoMuxerFail(aVar);
                    return;
                }
                return;
            }
            this.f57064a.add(new Pair<>("type", videoMuxerData.getLogType()));
            long fileSize = FileUtils.getFileSize(videoMuxerData.getFinalAudioPath());
            if (FileUtils.checkFile(videoMuxerData.getVideoPath())) {
                new Thread(new Runnable(this, videoMuxerData, fileSize) { // from class: com.baidu.ugc.editvideo.editvideo.muxer.a.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ VideoMuxerData f57068a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ long f57069b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ a f57070c;

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
                        this.f57070c = this;
                        this.f57068a = videoMuxerData;
                        this.f57069b = fileSize;
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
                            a aVar2 = this.f57070c;
                            aVar2.f57066c = f2 + File.separator + "audio_video_" + System.currentTimeMillis() + ".mp4";
                            boolean j = x.j(sb, this.f57068a.getFinalAudioPath(), this.f57068a.getVideoPath(), this.f57070c.f57066c, 0L, -1L);
                            b bVar = new b();
                            if (j) {
                                bVar.f57074b = this.f57070c.f57066c;
                            } else {
                                b.a.x0.m.a aVar3 = new b.a.x0.m.a();
                                aVar3.f29760b = true;
                                aVar3.f29759a = 24;
                                aVar3.f29761c = "error_mixtrue";
                                aVar3.f29763e = " 预处理音乐合成失败-4 musicPath" + this.f57068a.getFinalAudioPath() + " ,videoPath" + this.f57068a.getVideoPath() + " ,outputVideoPath" + this.f57070c.f57066c + " ,muxResult:" + j + ",errorMsg" + sb.toString() + " ,audio file size =" + this.f57069b;
                                bVar.f57073a = aVar3;
                            }
                            b.a.x0.m.b.b("avMuxThead", "音视频混合:" + j);
                            this.f57070c.a(bVar);
                        }
                    }
                }).start();
            } else if (this.f57065b != null) {
                b.a.x0.m.a aVar2 = new b.a.x0.m.a();
                aVar2.f29760b = true;
                aVar2.f29759a = 24;
                aVar2.f29761c = "error_mixtrue";
                aVar2.f29763e = "musicPath" + videoMuxerData.getFinalAudioPath() + "outputVideoPath" + this.f57066c + "videoPath: " + videoMuxerData.getVideoPath() + "muxResult:false 合成音乐视频路径丢失";
                this.f57065b.onAudioVideoMuxerFail(aVar2);
            }
        }
    }

    public void a(InterfaceC1778a interfaceC1778a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, interfaceC1778a) == null) {
            this.f57065b = interfaceC1778a;
        }
    }
}
