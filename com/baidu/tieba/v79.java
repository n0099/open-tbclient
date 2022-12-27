package com.baidu.tieba;

import android.content.Intent;
import android.media.MediaMetadataRetriever;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.album.VideoFileInfo;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.TbFileVideoActivityConfig;
import com.baidu.tbadk.core.atomData.WorkPublishManager;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.TbMultiMediaData;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tieba.cf6;
import com.baidu.tieba.frs.FrsTabInfoData;
import com.baidu.tieba.lv4;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.video.VideoConvertUtil;
import com.baidu.tieba.write.video.AlbumVideoCompressingDialogView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.source.hls.DefaultHlsExtractorFactory;
import java.io.File;
/* loaded from: classes6.dex */
public class v79 implements s09, Handler.Callback, se6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseFragmentActivity a;
    public VideoFileInfo b;
    public String c;
    public boolean d;
    public boolean e;
    public boolean f;
    public AlbumVideoCompressingDialogView g;
    public VideoConvertUtil h;
    public Handler i;
    public nu7 j;
    public boolean k;
    public String l;
    public te6 m;
    public VideoInfo n;
    public d o;
    public final CustomMessageListener p;

    /* loaded from: classes6.dex */
    public interface d {
        void a(String str, VideoInfo videoInfo);
    }

    @Override // com.baidu.tieba.s09
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    public void r(AntiData antiData, PostPrefixData postPrefixData, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048595, this, antiData, postPrefixData, str, str2) == null) {
        }
    }

    public void s(FrsTabInfoData frsTabInfoData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, frsTabInfoData) == null) {
        }
    }

    public void u(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i) == null) {
        }
    }

    public void v(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class a implements lv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(v79 v79Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v79Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.lv4.e
        public void onClick(lv4 lv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, lv4Var) == null) {
                lv4Var.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v79 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(v79 v79Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v79Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v79Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                return;
            }
            Intent intent = new Intent();
            intent.putExtra(AlbumActivityConfig.FINISH_SELF, true);
            this.a.a.setResult(-1, intent);
            this.a.a.finish();
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ v79 b;

        public c(v79 v79Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v79Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = v79Var;
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.b.a != null) {
                    this.b.a.closeLoadingDialog();
                }
                if (!TextUtils.isEmpty(this.a) && this.b.o != null) {
                    this.b.o.a(this.a, this.b.n);
                }
            }
        }
    }

    public v79(BaseFragmentActivity baseFragmentActivity, String str, String str2, String str3) {
        ru7 ru7Var;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragmentActivity, str, str2, str3};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = false;
        this.e = false;
        this.f = false;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, ru7.class);
        if (runTask != null) {
            ru7Var = (ru7) runTask.getData();
        } else {
            ru7Var = null;
        }
        if (ru7Var != null) {
            this.j = ru7Var.get();
        }
        nu7 nu7Var = this.j;
        if (nu7Var != null) {
            nu7Var.g();
        }
        this.p = new b(this, 2001374);
        this.a = baseFragmentActivity;
        VideoConvertUtil videoConvertUtil = new VideoConvertUtil(baseFragmentActivity);
        this.h = videoConvertUtil;
        videoConvertUtil.o(this);
        this.i = new Handler(Looper.getMainLooper(), this);
        MessageManager.getInstance().registerListener(this.p);
    }

    @Override // com.baidu.tieba.s09
    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            this.i.sendEmptyMessage(2);
        }
    }

    @Override // com.baidu.tieba.se6
    public void d0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            ah.a().post(new c(this, str));
        }
    }

    @Override // com.baidu.tieba.s09
    public void onConvertProgress(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.arg1 = i;
            this.i.sendMessage(obtain);
        }
    }

    public final void q(int i) {
        nu7 nu7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048594, this, i) == null) && (nu7Var = this.j) != null) {
            nu7Var.i(i, "album");
        }
    }

    public void t(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, dVar) == null) {
            this.o = dVar;
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE] complete} */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0082 -> B:25:0x0085). Please submit an issue!!! */
    public static VideoFileInfo h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            File file = new File(str);
            if (file.exists() && file.isFile()) {
                VideoFileInfo videoFileInfo = new VideoFileInfo();
                videoFileInfo.videoPath = str;
                videoFileInfo.lastModified = file.lastModified();
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                try {
                    try {
                        try {
                            mediaMetadataRetriever.setDataSource(str);
                            videoFileInfo.videoDuration = xg.e(mediaMetadataRetriever.extractMetadata(9), 0);
                            videoFileInfo.mimeType = mediaMetadataRetriever.extractMetadata(12);
                            videoFileInfo.videoWidth = xg.e(mediaMetadataRetriever.extractMetadata(18), 0);
                            videoFileInfo.videoHeight = xg.e(mediaMetadataRetriever.extractMetadata(19), 0);
                            int e = xg.e(mediaMetadataRetriever.extractMetadata(24), 0);
                            if (e == 90 || e == 270) {
                                int i = videoFileInfo.videoWidth;
                                videoFileInfo.videoWidth = videoFileInfo.videoHeight;
                                videoFileInfo.videoHeight = i;
                            }
                            mediaMetadataRetriever.release();
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            mediaMetadataRetriever.release();
                        }
                    } catch (Throwable th) {
                        try {
                            mediaMetadataRetriever.release();
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                        throw th;
                    }
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
                return videoFileInfo;
            }
            return null;
        }
        return (VideoFileInfo) invokeL.objValue;
    }

    public final void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.a.showLoadingDialog(null);
            VideoFileInfo h = h(this.c);
            VideoInfo videoInfo = new VideoInfo();
            videoInfo.setVideoPath(this.c);
            videoInfo.setVideoDuration(h.videoDuration / 1000);
            videoInfo.setVideoWidth(h.videoWidth);
            videoInfo.setVideoHeight(h.videoHeight);
            videoInfo.setVideoLength(new File(h.videoPath).length());
            videoInfo.setVideoSource(2);
            videoInfo.setIsCompressedVideo(z);
            int i = 1;
            if (AlbumActivityConfig.FROM_FLUTTER_GAME_VIDEO.equals(this.l)) {
                g(videoInfo);
            } else {
                TbFileVideoActivityConfig tbFileVideoActivityConfig = new TbFileVideoActivityConfig(this.a);
                tbFileVideoActivityConfig.getIntent().putExtras(this.a.getIntent());
                tbFileVideoActivityConfig.setFrom(1);
                tbFileVideoActivityConfig.setVideoInfo(videoInfo);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921582, tbFileVideoActivityConfig));
            }
            if (WorkPublishManager.isWorkPublishLocate()) {
                if (WorkPublishManager.isWorkPublishLocateVideoCenter()) {
                    i = 2;
                }
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_WORK_PUBLISH_ENTER_TYPE_CLICK).param("obj_locate", 2).param("obj_source", i));
            }
            this.e = false;
            this.c = null;
            nu7 nu7Var = this.j;
            if (nu7Var != null) {
                nu7Var.d();
            }
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            VideoConvertUtil videoConvertUtil = this.h;
            if (videoConvertUtil != null) {
                videoConvertUtil.a();
            }
            this.f = true;
            if (this.c != null) {
                File file = new File(this.c);
                if (file.exists()) {
                    file.delete();
                }
            }
            k();
            this.c = null;
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            if (this.e && !TextUtils.isEmpty(this.c) && new File(this.c).exists()) {
                i(true);
                q(101);
            }
            nu7 nu7Var = this.j;
            if (nu7Var != null) {
                nu7Var.e("album");
            }
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            lv4 positiveButton = new lv4(this.a).setTitle(R.string.obfuscated_res_0x7f0f0ba6).setPositiveButton(R.string.group_create_private_isee, new a(this));
            positiveButton.create(this.a.getPageContext());
            positiveButton.setCanceledOnTouchOutside(false);
            positiveButton.show();
        }
    }

    public final void g(VideoInfo videoInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, videoInfo) == null) {
            this.n = videoInfo;
            if (this.m == null) {
                this.m = new te6(false);
            }
            TbMultiMediaData a2 = c69.a(videoInfo);
            cf6.a aVar = new cf6.a();
            aVar.t(videoInfo.getVideoWidth());
            aVar.o(videoInfo.getVideoHeight());
            aVar.p(true);
            aVar.n(null);
            aVar.r(1.0f);
            aVar.q(a2);
            aVar.s("default");
            cf6 m = aVar.m();
            this.m.e(this);
            this.m.d(false);
            this.m.b(m, "default");
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, message)) == null) {
            this.i.removeMessages(5);
            int i = message.what;
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i == 5) {
                                this.k = false;
                                yi.P(this.a, R.string.obfuscated_res_0x7f0f0ba4);
                                VideoConvertUtil videoConvertUtil = this.h;
                                if (videoConvertUtil != null && videoConvertUtil.n()) {
                                    f();
                                }
                                q(105);
                            }
                        } else {
                            this.k = false;
                            this.e = false;
                            k();
                            q(104);
                        }
                    } else {
                        this.k = false;
                        this.e = true;
                        if (!StringUtils.isNull(this.c)) {
                            File file = new File(this.c);
                            this.c = this.c.replace("_tiebaconverting.mp4", DefaultHlsExtractorFactory.MP4_FILE_EXTENSION);
                            file.renameTo(new File(this.c));
                        }
                        k();
                        if (!this.d) {
                            i(true);
                            nu7 nu7Var = this.j;
                            if (nu7Var != null) {
                                nu7Var.d();
                            }
                        }
                    }
                } else {
                    if (!this.f) {
                        yi.P(this.a, R.string.obfuscated_res_0x7f0f0ba4);
                        q(103);
                    }
                    this.k = false;
                    this.e = false;
                    k();
                }
            } else {
                this.i.removeMessages(1);
                AlbumVideoCompressingDialogView albumVideoCompressingDialogView = this.g;
                if (albumVideoCompressingDialogView != null && albumVideoCompressingDialogView.b()) {
                    this.g.setPercent(message.arg1);
                }
                Handler handler = this.i;
                handler.sendMessageDelayed(handler.obtainMessage(5), 60000L);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void j(VideoFileInfo videoFileInfo, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048583, this, videoFileInfo, str, str2) == null) {
            this.b = videoFileInfo;
            this.l = str2;
            if (videoFileInfo != null && this.a != null) {
                if (videoFileInfo.videoDuration > 600000) {
                    w();
                    return;
                }
                VideoConvertUtil videoConvertUtil = this.h;
                if (videoConvertUtil != null && videoConvertUtil.n()) {
                    return;
                }
                String str3 = this.b.videoPath;
                if (TextUtils.isEmpty(str3)) {
                    yi.P(this.a, R.string.obfuscated_res_0x7f0f0ba7);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016328, str3));
                    q(107);
                } else if (!new File(str3).exists()) {
                    yi.P(this.a, R.string.obfuscated_res_0x7f0f0ba7);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016328, str3));
                    q(106);
                } else {
                    VideoFileInfo videoFileInfo2 = this.b;
                    if (videoFileInfo2 != null) {
                        this.c = videoFileInfo2.videoPath;
                        i(false);
                        q(102);
                    }
                }
            }
        }
    }

    public final void k() {
        RelativeLayout relativeLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (relativeLayout = (RelativeLayout) this.a.findViewById(R.id.obfuscated_res_0x7f091835)) != null && this.g.getParent() != null) {
            relativeLayout.removeView(this.g);
        }
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.k;
        }
        return invokeV.booleanValue;
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            VideoConvertUtil videoConvertUtil = this.h;
            if (videoConvertUtil != null) {
                videoConvertUtil.l();
            }
            Handler handler = this.i;
            if (handler != null) {
                handler.removeMessages(5);
            }
            nu7 nu7Var = this.j;
            if (nu7Var != null) {
                nu7Var.k("album");
            }
            MessageManager.getInstance().unRegisterListener(this.p);
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.d = false;
        }
    }

    @Override // com.baidu.tieba.s09
    public void onConvertAborted() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.i.sendEmptyMessage(4);
        }
    }

    @Override // com.baidu.tieba.s09
    public void onConvertFailed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.i.sendEmptyMessage(2);
        }
    }

    @Override // com.baidu.tieba.s09
    public void onConvertSuccess() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.i.sendEmptyMessage(3);
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.d = true;
            this.a.closeLoadingDialog();
        }
    }
}
