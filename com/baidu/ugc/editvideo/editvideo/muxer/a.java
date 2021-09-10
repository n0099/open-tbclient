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
    public LinkedList<Pair<String, Object>> f59982a;

    /* renamed from: b  reason: collision with root package name */
    public InterfaceC1814a f59983b;

    /* renamed from: c  reason: collision with root package name */
    public String f59984c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f59985d;

    /* renamed from: com.baidu.ugc.editvideo.editvideo.muxer.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC1814a {
        void onAudioVideoMuxerCancel();

        void onAudioVideoMuxerFail(c.a.x0.m.a aVar);

        void onAudioVideoMuxerFinish(String str);
    }

    /* loaded from: classes8.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public c.a.x0.m.a f59991a;

        /* renamed from: b  reason: collision with root package name */
        public String f59992b;

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
        this.f59982a = new LinkedList<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, bVar) == null) {
            u.a().postDelayed(new Runnable(this, bVar) { // from class: com.baidu.ugc.editvideo.editvideo.muxer.a.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f59989a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ a f59990b;

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
                    this.f59990b = this;
                    this.f59989a = bVar;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (this.f59990b.f59985d) {
                            this.f59990b.a();
                        } else if (this.f59990b.f59983b != null) {
                            b bVar2 = this.f59989a;
                            if (bVar2 != null) {
                                if (w.a(bVar2.f59992b) || !FileUtils.checkFile(this.f59989a.f59992b)) {
                                    this.f59990b.f59983b.onAudioVideoMuxerFail(this.f59989a.f59991a);
                                    return;
                                } else {
                                    this.f59990b.f59983b.onAudioVideoMuxerFinish(this.f59989a.f59992b);
                                    return;
                                }
                            }
                            c.a.x0.m.a aVar = new c.a.x0.m.a();
                            aVar.f30992b = true;
                            aVar.f30991a = 24;
                            aVar.f30993c = "error_mixtrue";
                            aVar.f30995e = "合成音乐失败 MuxerMusicResult is null";
                            this.f59990b.f59983b.onAudioVideoMuxerFail(aVar);
                        }
                    }
                }
            }, 200L);
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f59985d = true;
            InterfaceC1814a interfaceC1814a = this.f59983b;
            if (interfaceC1814a != null) {
                interfaceC1814a.onAudioVideoMuxerCancel();
            }
            try {
                File file = new File(this.f59984c);
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
            this.f59985d = false;
            if (videoMuxerData == null) {
                if (this.f59983b != null) {
                    c.a.x0.m.a aVar = new c.a.x0.m.a();
                    aVar.f30992b = true;
                    aVar.f30991a = 24;
                    aVar.f30993c = "error_mixtrue";
                    aVar.f30995e = "音视频合成VideoMuxerData为空合成失败";
                    this.f59983b.onAudioVideoMuxerFail(aVar);
                    return;
                }
                return;
            }
            this.f59982a.add(new Pair<>("type", videoMuxerData.getLogType()));
            long fileSize = FileUtils.getFileSize(videoMuxerData.getFinalAudioPath());
            if (FileUtils.checkFile(videoMuxerData.getVideoPath())) {
                new Thread(new Runnable(this, videoMuxerData, fileSize) { // from class: com.baidu.ugc.editvideo.editvideo.muxer.a.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ VideoMuxerData f59986a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ long f59987b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ a f59988c;

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
                        this.f59988c = this;
                        this.f59986a = videoMuxerData;
                        this.f59987b = fileSize;
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
                            a aVar2 = this.f59988c;
                            aVar2.f59984c = g2 + File.separator + "audio_video_" + System.currentTimeMillis() + ".mp4";
                            boolean j2 = x.j(sb, this.f59986a.getFinalAudioPath(), this.f59986a.getVideoPath(), this.f59988c.f59984c, 0L, -1L);
                            b bVar = new b();
                            if (j2) {
                                bVar.f59992b = this.f59988c.f59984c;
                            } else {
                                c.a.x0.m.a aVar3 = new c.a.x0.m.a();
                                aVar3.f30992b = true;
                                aVar3.f30991a = 24;
                                aVar3.f30993c = "error_mixtrue";
                                aVar3.f30995e = " 预处理音乐合成失败-4 musicPath" + this.f59986a.getFinalAudioPath() + " ,videoPath" + this.f59986a.getVideoPath() + " ,outputVideoPath" + this.f59988c.f59984c + " ,muxResult:" + j2 + ",errorMsg" + sb.toString() + " ,audio file size =" + this.f59987b;
                                bVar.f59991a = aVar3;
                            }
                            c.a.x0.m.b.b("avMuxThead", "音视频混合:" + j2);
                            this.f59988c.a(bVar);
                        }
                    }
                }).start();
            } else if (this.f59983b != null) {
                c.a.x0.m.a aVar2 = new c.a.x0.m.a();
                aVar2.f30992b = true;
                aVar2.f30991a = 24;
                aVar2.f30993c = "error_mixtrue";
                aVar2.f30995e = "musicPath" + videoMuxerData.getFinalAudioPath() + "outputVideoPath" + this.f59984c + "videoPath: " + videoMuxerData.getVideoPath() + "muxResult:false 合成音乐视频路径丢失";
                this.f59983b.onAudioVideoMuxerFail(aVar2);
            }
        }
    }

    public void a(InterfaceC1814a interfaceC1814a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, interfaceC1814a) == null) {
            this.f59983b = interfaceC1814a;
        }
    }
}
