package com.baidu.tieba;

import android.content.Intent;
import android.graphics.Bitmap;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrackConfig;
import com.baidu.minivideo.plugin.capture.bean.FaceItem;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.album.VideoFileInfo;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.WorkPublishActivityConfig;
import com.baidu.tbadk.core.atomData.WorkPublishOpenHelper;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.MediaScannerClient;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.data.TbMultiMediaData;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.effect.ImageOperation;
import com.baidu.tieba.core.edit.TbMediaTrackConfig;
import com.baidu.tieba.kc6;
import com.baidu.tieba.video.EditVideoData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.data.MultiMediaData;
import com.baidu.ugc.editvideo.data.TextWordsEntity;
import com.baidu.ugc.editvideo.data.VideoMuxerData;
import com.baidu.ugc.editvideo.muxer.VideoMuxer;
import com.baidu.ugc.editvideo.player.AudioPlayTrackData;
import com.baidu.ugc.editvideo.record.preview.GLMediaPreviewView;
import com.baidu.ugc.editvideo.record.processor.adapter.MultiMediaDataSourceViewAdapter;
import com.baidu.ugc.editvideo.record.source.multimedia.VlogEditManager;
import com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer;
import com.baidu.ugc.utils.FileUtils;
import com.google.gson.Gson;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
/* loaded from: classes5.dex */
public class qz8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TbPageContext a;
    public final String b;
    public final d c;
    public TbMultiMediaData d;
    public bc6 e;
    public VlogEditManager f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948109242, "Lcom/baidu/tieba/qz8;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948109242, "Lcom/baidu/tieba/qz8;");
        }
    }

    /* loaded from: classes5.dex */
    public final class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbPageContext a;
        public final /* synthetic */ VideoInfo b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;

        public a(TbPageContext tbPageContext, VideoInfo videoInfo, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbPageContext, videoInfo, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbPageContext;
            this.b = videoInfo;
            this.c = str;
            this.d = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ld9.c().k(null);
                qz8.l(this.a, this.b, this.c, this.d);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements ac6 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qz8 a;

        public b(qz8 qz8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qz8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qz8Var;
        }

        @Override // com.baidu.tieba.ac6
        public void h0(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.a.c.h(str);
                this.a.d.coverPath = str;
                o85 o85Var = new o85();
                ImageFileInfo imageFileInfo = new ImageFileInfo();
                imageFileInfo.setFilePath(str);
                ImageOperation g = x85.g(fj.k(this.a.a.getPageActivity()) - (UtilHelper.getDimenPixelSize(R.dimen.M_W_X007) * 2), fj.f(this.a.a.getPageActivity(), R.dimen.tbds866));
                imageFileInfo.clearPageActions();
                imageFileInfo.addPageAction(g);
                o85Var.d(imageFileInfo, null, false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements md9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qz8 a;

        @Override // com.baidu.tieba.md9
        public te9 c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return null;
            }
            return (te9) invokeV.objValue;
        }

        @Override // com.baidu.tieba.md9
        public String e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "tieba_unknown" : (String) invokeV.objValue;
        }

        public c(qz8 qz8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qz8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qz8Var;
        }

        @Override // com.baidu.tieba.md9
        public IMediaPlayer a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return new q09(this.a.a.getPageActivity());
            }
            return (IMediaPlayer) invokeV.objValue;
        }

        @Override // com.baidu.tieba.md9
        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return mv8.c;
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public abstract class d implements pd9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        @Override // com.baidu.tieba.pd9
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // com.baidu.tieba.pd9
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        @Override // com.baidu.tieba.pd9
        public void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            }
        }

        public abstract void g(String str, String str2);

        public d() {
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

        @Override // com.baidu.tieba.pd9
        public final void d(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                g(str, this.a);
            }
        }

        public void h(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
                this.a = str;
            }
        }
    }

    public qz8(TbPageContext tbPageContext, String str, d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, str, dVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = tbPageContext;
        this.b = str;
        this.c = dVar;
        e();
        f();
    }

    public static VideoMuxer p(TbPageContext tbPageContext, String str, List list, d dVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65545, null, tbPageContext, str, list, dVar)) == null) {
            return new qz8(tbPageContext, str, dVar).o(list);
        }
        return (VideoMuxer) invokeLLLL.objValue;
    }

    public static void l(TbPageContext tbPageContext, VideoInfo videoInfo, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65542, null, tbPageContext, videoInfo, str, str2) == null) {
            Intent intent = new Intent();
            intent.putExtra("topic", str);
            intent.putExtra("topicId", str2);
            intent.putExtra("is_video_topic", "0");
            intent.putExtra(WorkPublishActivityConfig.VIDEO_MIXING, false);
            intent.putExtra(WorkPublishActivityConfig.NEED_PUBLISH_END_JUMP_HOME, true);
            WorkPublishOpenHelper.Companion.e(intent, videoInfo, tbPageContext.getPageActivity(), true, false);
        }
    }

    public static String m(TbPageContext tbPageContext, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, tbPageContext, str)) == null) {
            File file = new File(str);
            File file2 = new File(mv8.g);
            if (!file2.exists()) {
                file2.mkdir();
            }
            String str2 = mv8.g + file.getName();
            if (!str2.equals(file.getAbsolutePath())) {
                FileHelper.copyFileByAbsolutelyPath(file.getAbsolutePath(), str2);
            }
            new MediaScannerClient(tbPageContext.getPageActivity()).saveVideo(str2);
            try {
                Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
                intent.setData(UtilHelper.getUriFromFile(file, intent, tbPageContext.getPageActivity()));
                tbPageContext.getPageActivity().sendBroadcast(intent);
            } catch (Exception e) {
                BdLog.d(e.getMessage());
            }
            return str2;
        }
        return (String) invokeLL.objValue;
    }

    public static void n(TbPageContext tbPageContext, String str, String str2, String str3, String str4) {
        VideoFileInfo c2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLLL(65544, null, tbPageContext, str, str2, str3, str4) != null) || (c2 = bv8.c(str)) == null) {
            return;
        }
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(str);
        videoInfo.setVideoDuration((int) (c2.videoDuration / 1000.0f));
        videoInfo.setVideoWidth(c2.videoWidth);
        videoInfo.setVideoHeight(c2.videoHeight);
        videoInfo.setVideoLength(new File(str).length());
        videoInfo.setVideoSource(2);
        videoInfo.setIsCompressedVideo(true);
        videoInfo.setThumbPath(str2);
        EditVideoData editVideoData = new EditVideoData();
        if (StringUtils.isNull(videoInfo.getThumbPath())) {
            editVideoData.coverPath = mv8.b;
        } else {
            editVideoData.coverPath = videoInfo.getThumbPath();
        }
        editVideoData.originPath = videoInfo.getVideoPath();
        videoInfo.setEditVideoData(editVideoData);
        videoInfo.setMultiMediaData(x09.a(videoInfo));
        hh.a().post(new a(tbPageContext, videoInfo, str3, str4));
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            VideoFileInfo c2 = bv8.c(this.b);
            if (c2 == null) {
                this.a.getPageActivity().finish();
                return;
            }
            TbMultiMediaData tbMultiMediaData = new TbMultiMediaData();
            this.d = tbMultiMediaData;
            tbMultiMediaData.path = c2.videoPath;
            tbMultiMediaData.coverPath = c2.thumbPath;
            int i = c2.videoHeight;
            tbMultiMediaData.height = i;
            int i2 = c2.videoWidth;
            tbMultiMediaData.width = i2;
            tbMultiMediaData.type = 1;
            tbMultiMediaData.start = 0L;
            int i3 = c2.videoDuration;
            tbMultiMediaData.end = i3;
            tbMultiMediaData.originalDuration = i3;
            tbMultiMediaData.scaleType = "center_inside";
            tbMultiMediaData.videoInfoSource = 2;
            tbMultiMediaData.coverSource = 1;
            tbMultiMediaData.videoRatio = (i * 1.0f) / i2;
        }
    }

    public final void h() {
        MultiMediaData multiMediaData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            kc6.a aVar = new kc6.a();
            aVar.t(this.d.width);
            aVar.o(this.d.height);
            aVar.p(true);
            aVar.r(this.d.videoRatio);
            VlogEditManager vlogEditManager = this.f;
            if (vlogEditManager == null) {
                multiMediaData = null;
            } else {
                multiMediaData = vlogEditManager.getMultiMediaData(vlogEditManager.getCurrentIndex());
            }
            aVar.q(multiMediaData);
            aVar.s("manual");
            kc6 m = aVar.m();
            this.e.e(new b(this));
            this.e.d(false);
            this.e.b(m, "default");
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (!av8.a()) {
                this.a.getPageActivity().finish();
                return;
            }
            g();
            MultiMediaDataSourceViewAdapter multiMediaDataSourceViewAdapter = new MultiMediaDataSourceViewAdapter();
            this.f = new VlogEditManager(multiMediaDataSourceViewAdapter);
            GLMediaPreviewView gLMediaPreviewView = new GLMediaPreviewView(TbadkCoreApplication.getInst());
            gLMediaPreviewView.setZOrderMediaOverlay(true);
            gLMediaPreviewView.setMultiMediaDataSourceViewAdapter(multiMediaDataSourceViewAdapter, false);
            gLMediaPreviewView.setCanMeasure(false);
            gLMediaPreviewView.setVideoRatio(this.d.videoRatio);
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.d);
            this.f.setMultiMediaData(arrayList);
            this.f.setVideoRatio(this.d.videoRatio);
            this.e = new bc6(true);
            h();
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ld9.c().h(TbadkCoreApplication.getInst());
            ld9.c().j(FileHelper.getCacheDir());
            ld9.c().k(new c(this));
        }
    }

    public final void i(String str, long j, long j2, double d2, double d3, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{str, Long.valueOf(j), Long.valueOf(j2), Double.valueOf(d2), Double.valueOf(d3), Integer.valueOf(i), Integer.valueOf(i2)}) == null) {
            MultiMediaData multiMediaData = new MultiMediaData();
            Bitmap image = FileHelper.getImage(str);
            if (image != null) {
                multiMediaData.path = str;
                multiMediaData.width = i;
                multiMediaData.height = i2;
                multiMediaData.scaleType = "adaptive";
                multiMediaData.type = 0;
                multiMediaData.start = j;
                multiMediaData.end = j2;
                multiMediaData.x = ((int) d2) - (i >> 1);
                multiMediaData.y = ((int) d3) - (i2 >> 1);
                image.recycle();
                this.f.seek(j);
                this.f.addStickerData(multiMediaData, FaceItem.DIR_STICKER);
            }
        }
    }

    public final void j(tz8 tz8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, tz8Var) == null) {
            int i = tz8Var.b;
            if (i == 1) {
                k(tz8Var.a, tz8Var.e, tz8Var.f, tz8Var.g, tz8Var.h, tz8Var.i, tz8Var.j, tz8Var.k);
            } else if (i == 2) {
                i(tz8Var.a, tz8Var.e, tz8Var.f, tz8Var.g, tz8Var.h, tz8Var.c, tz8Var.d);
            }
        }
    }

    public final void k(String str, long j, long j2, double d2, double d3, double d4, double d5, String str2) {
        int f;
        int height;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{str, Long.valueOf(j), Long.valueOf(j2), Double.valueOf(d2), Double.valueOf(d3), Double.valueOf(d4), Double.valueOf(d5), str2}) == null) {
            dv8.d().k((int) d5);
            String videoTmpDir = FileHelper.getVideoTmpDir();
            String str3 = System.currentTimeMillis() + ".jpg";
            TextWordsEntity.TextStyleEntity textStyleEntity = new TextWordsEntity.TextStyleEntity();
            textStyleEntity.mTextInfoList = new ArrayList();
            textStyleEntity.mStrokeInfoList = new ArrayList();
            TextWordsEntity.StyleTextInfoEntity styleTextInfoEntity = new TextWordsEntity.StyleTextInfoEntity();
            if (!vl8.e(vl8.f(str2)) && str2 != null && str2.startsWith("#") && str2.length() >= 7) {
                styleTextInfoEntity.mTextAlpha = String.format(Locale.CHINA, "%.1f", Double.valueOf(((f >>> 24) * 1.0d) / 255.0d));
                styleTextInfoEntity.mTextColor = str2.substring(str2.length() - 6, str2.length());
            } else {
                styleTextInfoEntity.mTextAlpha = "0.0";
                styleTextInfoEntity.mTextColor = "000000";
            }
            textStyleEntity.mTextInfoList.add(styleTextInfoEntity);
            Bitmap h = dv8.d().h(TbadkCoreApplication.getInst(), str, textStyleEntity, null);
            MultiMediaData multiMediaData = new MultiMediaData();
            FileUtils.saveBitmap2PNG(videoTmpDir, str3, h, 100);
            multiMediaData.path = videoTmpDir + File.separator + str3;
            multiMediaData.width = h.getWidth();
            multiMediaData.height = h.getHeight();
            multiMediaData.scaleType = "adaptive";
            multiMediaData.type = 0;
            multiMediaData.start = j;
            multiMediaData.end = j2;
            if (d4 == 1.0d) {
                multiMediaData.x = ((int) d2) - (multiMediaData.width >> 1);
                multiMediaData.y = ((int) d3) - (height >> 1);
            } else if (d4 == 2.0d) {
                dv8.d();
                multiMediaData.x = ((int) d2) - 20;
                multiMediaData.y = ((int) d3) - (multiMediaData.height >> 1);
            } else if (d4 == 3.0d) {
                dv8.d();
                multiMediaData.x = (((int) d2) - multiMediaData.width) + 20;
                multiMediaData.y = ((int) d3) - (multiMediaData.height >> 1);
            } else {
                multiMediaData.x = (int) d2;
                multiMediaData.y = (int) d3;
            }
            h.recycle();
            this.f.seek(j);
            this.f.addStickerData(multiMediaData, FaceItem.DIR_STICKER);
        }
    }

    public final VideoMuxer o(List list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, list)) == null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                j((tz8) it.next());
            }
            VideoMuxerData videoMuxerData = new VideoMuxerData();
            videoMuxerData.setCompat(true);
            videoMuxerData.setPhotoDataList(this.f.getInputMultiMediaData());
            videoMuxerData.setStickerDataList(this.f.getStickerMultiMediaDataList(false));
            videoMuxerData.setUserNewAudioMixture(true);
            ArrayList arrayList = new ArrayList();
            AudioPlayTrackData audioPlayTrackData = new AudioPlayTrackData();
            audioPlayTrackData.mAudioPlayDataList = new ArrayList();
            arrayList.add(audioPlayTrackData);
            videoMuxerData.setAudioPlayTrackDataList(arrayList);
            videoMuxerData.setPreviewWidth(this.f.getMultiMediaData(0).width);
            videoMuxerData.setPreviewHeight(this.f.getMultiMediaData(0).height);
            videoMuxerData.setOutWidth(this.f.getMultiMediaData(0).width);
            videoMuxerData.setOutHeight(this.f.getMultiMediaData(0).height);
            videoMuxerData.setOutBitRate(this.f.getMultiMediaData(0).width * this.f.getMultiMediaData(0).height * 6);
            videoMuxerData.setComposeNecessary(true);
            videoMuxerData.setCurrThemeEffect((MediaTrackConfig) new Gson().fromJson(this.f.exportConfigJson(MediaTrackConfig.AE_IMPORT_DRAFT), (Class<Object>) TbMediaTrackConfig.class));
            VideoMuxer videoMuxer = new VideoMuxer();
            videoMuxer.setListener(this.c);
            videoMuxer.startMuxer(videoMuxerData);
            return videoMuxer;
        }
        return (VideoMuxer) invokeL.objValue;
    }
}
