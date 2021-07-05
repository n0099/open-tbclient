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
import d.a.y0.t.u;
import d.a.y0.t.w;
import d.a.y0.t.x;
import java.io.File;
import java.util.LinkedList;
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public LinkedList<Pair<String, Object>> f23595a;

    /* renamed from: b  reason: collision with root package name */
    public InterfaceC0251a f23596b;

    /* renamed from: c  reason: collision with root package name */
    public String f23597c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f23598d;

    /* renamed from: com.baidu.ugc.editvideo.editvideo.muxer.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0251a {
        void onAudioVideoMuxerCancel();

        void onAudioVideoMuxerFail(d.a.y0.m.a aVar);

        void onAudioVideoMuxerFinish(String str);
    }

    /* loaded from: classes6.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public d.a.y0.m.a f23604a;

        /* renamed from: b  reason: collision with root package name */
        public String f23605b;

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
        this.f23595a = new LinkedList<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, bVar) == null) {
            u.a().postDelayed(new Runnable(this, bVar) { // from class: com.baidu.ugc.editvideo.editvideo.muxer.a.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f23602a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ a f23603b;

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
                    this.f23603b = this;
                    this.f23602a = bVar;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (this.f23603b.f23598d) {
                            this.f23603b.a();
                        } else if (this.f23603b.f23596b != null) {
                            b bVar2 = this.f23602a;
                            if (bVar2 != null) {
                                if (w.a(bVar2.f23605b) || !FileUtils.checkFile(this.f23602a.f23605b)) {
                                    this.f23603b.f23596b.onAudioVideoMuxerFail(this.f23602a.f23604a);
                                    return;
                                } else {
                                    this.f23603b.f23596b.onAudioVideoMuxerFinish(this.f23602a.f23605b);
                                    return;
                                }
                            }
                            d.a.y0.m.a aVar = new d.a.y0.m.a();
                            aVar.f71282b = true;
                            aVar.f71281a = 24;
                            aVar.f71283c = "error_mixtrue";
                            aVar.f71285e = "合成音乐失败 MuxerMusicResult is null";
                            this.f23603b.f23596b.onAudioVideoMuxerFail(aVar);
                        }
                    }
                }
            }, 200L);
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f23598d = true;
            InterfaceC0251a interfaceC0251a = this.f23596b;
            if (interfaceC0251a != null) {
                interfaceC0251a.onAudioVideoMuxerCancel();
            }
            try {
                File file = new File(this.f23597c);
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
            d.a.y0.m.b.b("muxerAV2Mp4", "音视频混合 to mp4");
            this.f23598d = false;
            if (videoMuxerData == null) {
                if (this.f23596b != null) {
                    d.a.y0.m.a aVar = new d.a.y0.m.a();
                    aVar.f71282b = true;
                    aVar.f71281a = 24;
                    aVar.f71283c = "error_mixtrue";
                    aVar.f71285e = "音视频合成VideoMuxerData为空合成失败";
                    this.f23596b.onAudioVideoMuxerFail(aVar);
                    return;
                }
                return;
            }
            this.f23595a.add(new Pair<>("type", videoMuxerData.getLogType()));
            long fileSize = FileUtils.getFileSize(videoMuxerData.getFinalAudioPath());
            if (FileUtils.checkFile(videoMuxerData.getVideoPath())) {
                new Thread(new Runnable(this, videoMuxerData, fileSize) { // from class: com.baidu.ugc.editvideo.editvideo.muxer.a.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ VideoMuxerData f23599a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ long f23600b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ a f23601c;

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
                        this.f23601c = this;
                        this.f23599a = videoMuxerData;
                        this.f23600b = fileSize;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            StringBuilder sb = new StringBuilder();
                            String g2 = d.a.y0.b.d().g();
                            if (TextUtils.isEmpty(g2)) {
                                sb.append("getMixVideoAudioDir 是空");
                                return;
                            }
                            FileUtils.mkdirs(g2);
                            a aVar2 = this.f23601c;
                            aVar2.f23597c = g2 + File.separator + "audio_video_" + System.currentTimeMillis() + ".mp4";
                            boolean j = x.j(sb, this.f23599a.getFinalAudioPath(), this.f23599a.getVideoPath(), this.f23601c.f23597c, 0L, -1L);
                            b bVar = new b();
                            if (j) {
                                bVar.f23605b = this.f23601c.f23597c;
                            } else {
                                d.a.y0.m.a aVar3 = new d.a.y0.m.a();
                                aVar3.f71282b = true;
                                aVar3.f71281a = 24;
                                aVar3.f71283c = "error_mixtrue";
                                aVar3.f71285e = " 预处理音乐合成失败-4 musicPath" + this.f23599a.getFinalAudioPath() + " ,videoPath" + this.f23599a.getVideoPath() + " ,outputVideoPath" + this.f23601c.f23597c + " ,muxResult:" + j + ",errorMsg" + sb.toString() + " ,audio file size =" + this.f23600b;
                                bVar.f23604a = aVar3;
                            }
                            d.a.y0.m.b.b("avMuxThead", "音视频混合:" + j);
                            this.f23601c.a(bVar);
                        }
                    }
                }).start();
            } else if (this.f23596b != null) {
                d.a.y0.m.a aVar2 = new d.a.y0.m.a();
                aVar2.f71282b = true;
                aVar2.f71281a = 24;
                aVar2.f71283c = "error_mixtrue";
                aVar2.f71285e = "musicPath" + videoMuxerData.getFinalAudioPath() + "outputVideoPath" + this.f23597c + "videoPath: " + videoMuxerData.getVideoPath() + "muxResult:false 合成音乐视频路径丢失";
                this.f23596b.onAudioVideoMuxerFail(aVar2);
            }
        }
    }

    public void a(InterfaceC0251a interfaceC0251a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, interfaceC0251a) == null) {
            this.f23596b = interfaceC0251a;
        }
    }
}
