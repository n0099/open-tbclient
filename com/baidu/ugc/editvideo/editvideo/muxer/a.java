package com.baidu.ugc.editvideo.editvideo.muxer;

import android.text.TextUtils;
import android.util.Pair;
import c.a.v0.t.u;
import c.a.v0.t.w;
import c.a.v0.t.x;
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
    public LinkedList<Pair<String, Object>> f59602a;

    /* renamed from: b  reason: collision with root package name */
    public InterfaceC1810a f59603b;

    /* renamed from: c  reason: collision with root package name */
    public String f59604c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f59605d;

    /* renamed from: com.baidu.ugc.editvideo.editvideo.muxer.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC1810a {
        void onAudioVideoMuxerCancel();

        void onAudioVideoMuxerFail(c.a.v0.m.a aVar);

        void onAudioVideoMuxerFinish(String str);
    }

    /* loaded from: classes8.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public c.a.v0.m.a f59611a;

        /* renamed from: b  reason: collision with root package name */
        public String f59612b;

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
        this.f59602a = new LinkedList<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, bVar) == null) {
            u.a().postDelayed(new Runnable(this, bVar) { // from class: com.baidu.ugc.editvideo.editvideo.muxer.a.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f59609a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ a f59610b;

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
                    this.f59610b = this;
                    this.f59609a = bVar;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (this.f59610b.f59605d) {
                            this.f59610b.a();
                        } else if (this.f59610b.f59603b != null) {
                            b bVar2 = this.f59609a;
                            if (bVar2 != null) {
                                if (w.a(bVar2.f59612b) || !FileUtils.checkFile(this.f59609a.f59612b)) {
                                    this.f59610b.f59603b.onAudioVideoMuxerFail(this.f59609a.f59611a);
                                    return;
                                } else {
                                    this.f59610b.f59603b.onAudioVideoMuxerFinish(this.f59609a.f59612b);
                                    return;
                                }
                            }
                            c.a.v0.m.a aVar = new c.a.v0.m.a();
                            aVar.f30419b = true;
                            aVar.f30418a = 24;
                            aVar.f30420c = "error_mixtrue";
                            aVar.f30422e = "合成音乐失败 MuxerMusicResult is null";
                            this.f59610b.f59603b.onAudioVideoMuxerFail(aVar);
                        }
                    }
                }
            }, 200L);
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f59605d = true;
            InterfaceC1810a interfaceC1810a = this.f59603b;
            if (interfaceC1810a != null) {
                interfaceC1810a.onAudioVideoMuxerCancel();
            }
            try {
                File file = new File(this.f59604c);
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
            this.f59605d = false;
            if (videoMuxerData == null) {
                if (this.f59603b != null) {
                    c.a.v0.m.a aVar = new c.a.v0.m.a();
                    aVar.f30419b = true;
                    aVar.f30418a = 24;
                    aVar.f30420c = "error_mixtrue";
                    aVar.f30422e = "音视频合成VideoMuxerData为空合成失败";
                    this.f59603b.onAudioVideoMuxerFail(aVar);
                    return;
                }
                return;
            }
            this.f59602a.add(new Pair<>("type", videoMuxerData.getLogType()));
            long fileSize = FileUtils.getFileSize(videoMuxerData.getFinalAudioPath());
            if (FileUtils.checkFile(videoMuxerData.getVideoPath())) {
                new Thread(new Runnable(this, videoMuxerData, fileSize) { // from class: com.baidu.ugc.editvideo.editvideo.muxer.a.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ VideoMuxerData f59606a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ long f59607b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ a f59608c;

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
                        this.f59608c = this;
                        this.f59606a = videoMuxerData;
                        this.f59607b = fileSize;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            StringBuilder sb = new StringBuilder();
                            String g2 = c.a.v0.b.d().g();
                            if (TextUtils.isEmpty(g2)) {
                                sb.append("getMixVideoAudioDir 是空");
                                return;
                            }
                            FileUtils.mkdirs(g2);
                            a aVar2 = this.f59608c;
                            aVar2.f59604c = g2 + File.separator + "audio_video_" + System.currentTimeMillis() + ".mp4";
                            boolean j2 = x.j(sb, this.f59606a.getFinalAudioPath(), this.f59606a.getVideoPath(), this.f59608c.f59604c, 0L, -1L);
                            b bVar = new b();
                            if (j2) {
                                bVar.f59612b = this.f59608c.f59604c;
                            } else {
                                c.a.v0.m.a aVar3 = new c.a.v0.m.a();
                                aVar3.f30419b = true;
                                aVar3.f30418a = 24;
                                aVar3.f30420c = "error_mixtrue";
                                aVar3.f30422e = " 预处理音乐合成失败-4 musicPath" + this.f59606a.getFinalAudioPath() + " ,videoPath" + this.f59606a.getVideoPath() + " ,outputVideoPath" + this.f59608c.f59604c + " ,muxResult:" + j2 + ",errorMsg" + sb.toString() + " ,audio file size =" + this.f59607b;
                                bVar.f59611a = aVar3;
                            }
                            c.a.v0.m.b.b("avMuxThead", "音视频混合:" + j2);
                            this.f59608c.a(bVar);
                        }
                    }
                }).start();
            } else if (this.f59603b != null) {
                c.a.v0.m.a aVar2 = new c.a.v0.m.a();
                aVar2.f30419b = true;
                aVar2.f30418a = 24;
                aVar2.f30420c = "error_mixtrue";
                aVar2.f30422e = "musicPath" + videoMuxerData.getFinalAudioPath() + "outputVideoPath" + this.f59604c + "videoPath: " + videoMuxerData.getVideoPath() + "muxResult:false 合成音乐视频路径丢失";
                this.f59603b.onAudioVideoMuxerFail(aVar2);
            }
        }
    }

    public void a(InterfaceC1810a interfaceC1810a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, interfaceC1810a) == null) {
            this.f59603b = interfaceC1810a;
        }
    }
}
