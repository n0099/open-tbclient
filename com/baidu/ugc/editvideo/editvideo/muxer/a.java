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
import com.google.android.exoplayer2.source.hls.DefaultHlsExtractorFactory;
import com.repackage.jc9;
import com.repackage.lc9;
import com.repackage.mc9;
import com.repackage.na9;
import com.repackage.oa9;
import com.repackage.u79;
import java.io.File;
import java.util.LinkedList;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinkedList<Pair<String, Object>> a;
    public InterfaceC0274a b;
    public String c;
    public boolean d;

    /* renamed from: com.baidu.ugc.editvideo.editvideo.muxer.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0274a {
        void onAudioVideoMuxerCancel();

        void onAudioVideoMuxerFail(na9 na9Var);

        void onAudioVideoMuxerFinish(String str);
    }

    /* loaded from: classes4.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public na9 a;
        public String b;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
            jc9.a().postDelayed(new Runnable(this, bVar) { // from class: com.baidu.ugc.editvideo.editvideo.muxer.a.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ b a;
                public final /* synthetic */ a b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, bVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.b = this;
                    this.a = bVar;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (this.b.d) {
                            this.b.a();
                        } else if (this.b.b != null) {
                            b bVar2 = this.a;
                            if (bVar2 != null) {
                                if (lc9.a(bVar2.b) || !FileUtils.checkFile(this.a.b)) {
                                    this.b.b.onAudioVideoMuxerFail(this.a.a);
                                    return;
                                } else {
                                    this.b.b.onAudioVideoMuxerFinish(this.a.b);
                                    return;
                                }
                            }
                            na9 na9Var = new na9();
                            na9Var.b = true;
                            na9Var.a = 24;
                            na9Var.c = "error_mixtrue";
                            na9Var.e = "合成音乐失败 MuxerMusicResult is null";
                            this.b.b.onAudioVideoMuxerFail(na9Var);
                        }
                    }
                }
            }, 200L);
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.d = true;
            InterfaceC0274a interfaceC0274a = this.b;
            if (interfaceC0274a != null) {
                interfaceC0274a.onAudioVideoMuxerCancel();
            }
            try {
                File file = new File(this.c);
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
            oa9.b("muxerAV2Mp4", "音视频混合 to mp4");
            this.d = false;
            if (videoMuxerData == null) {
                if (this.b != null) {
                    na9 na9Var = new na9();
                    na9Var.b = true;
                    na9Var.a = 24;
                    na9Var.c = "error_mixtrue";
                    na9Var.e = "音视频合成VideoMuxerData为空合成失败";
                    this.b.onAudioVideoMuxerFail(na9Var);
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
                    public final /* synthetic */ long b;
                    public final /* synthetic */ a c;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, videoMuxerData, Long.valueOf(fileSize)};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.c = this;
                        this.a = videoMuxerData;
                        this.b = fileSize;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            StringBuilder sb = new StringBuilder();
                            String f = u79.c().f();
                            if (TextUtils.isEmpty(f)) {
                                sb.append("getMixVideoAudioDir 是空");
                                return;
                            }
                            FileUtils.mkdirs(f);
                            a aVar = this.c;
                            aVar.c = f + File.separator + "audio_video_" + System.currentTimeMillis() + DefaultHlsExtractorFactory.MP4_FILE_EXTENSION;
                            boolean j = mc9.j(sb, this.a.getFinalAudioPath(), this.a.getVideoPath(), this.c.c, 0L, -1L);
                            b bVar = new b();
                            if (j) {
                                bVar.b = this.c.c;
                            } else {
                                na9 na9Var2 = new na9();
                                na9Var2.b = true;
                                na9Var2.a = 24;
                                na9Var2.c = "error_mixtrue";
                                na9Var2.e = " 预处理音乐合成失败-4 musicPath" + this.a.getFinalAudioPath() + " ,videoPath" + this.a.getVideoPath() + " ,outputVideoPath" + this.c.c + " ,muxResult:" + j + ",errorMsg" + sb.toString() + " ,audio file size =" + this.b;
                                bVar.a = na9Var2;
                            }
                            oa9.b("avMuxThead", "音视频混合:" + j);
                            this.c.a(bVar);
                        }
                    }
                }).start();
            } else if (this.b != null) {
                na9 na9Var2 = new na9();
                na9Var2.b = true;
                na9Var2.a = 24;
                na9Var2.c = "error_mixtrue";
                na9Var2.e = "musicPath" + videoMuxerData.getFinalAudioPath() + "outputVideoPath" + this.c + "videoPath: " + videoMuxerData.getVideoPath() + "muxResult:false 合成音乐视频路径丢失";
                this.b.onAudioVideoMuxerFail(na9Var2);
            }
        }
    }

    public void a(InterfaceC0274a interfaceC0274a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, interfaceC0274a) == null) {
            this.b = interfaceC0274a;
        }
    }
}
