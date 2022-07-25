package com.baidu.tieba.view.videoedit;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.model.response.TaskResponseData;
import com.baidu.minivideo.arface.bean.Filter;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.album.VideoFileInfo;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.AlbumFloatActivityConfig;
import com.baidu.tbadk.core.atomData.CloudMusicActivityConfig;
import com.baidu.tbadk.core.atomData.TbEditVideoActivityConfig;
import com.baidu.tbadk.core.atomData.TbFileVideoActivityConfig;
import com.baidu.tbadk.core.atomData.VideoCoverSelectActivityConfig;
import com.baidu.tbadk.core.atomData.WorkPublishManager;
import com.baidu.tbadk.core.atomData.WorkPublishOpenHelper;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.MediaScannerClient;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.TbMultiMediaData;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.data.QmFilterItem;
import com.baidu.tbadk.data.TbMusicData;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.external.filter.ResponseGetQmFiltersMessage;
import com.baidu.tieba.external.filter.TbFilterValue;
import com.baidu.tieba.external.music.data.MusicData;
import com.baidu.tieba.external.sticker.data.QmStickerItem;
import com.baidu.tieba.frs.FrsTabInfoData;
import com.baidu.tieba.video.EditVideoData;
import com.baidu.tieba.view.widget.RecordPreviewContainer;
import com.baidu.tieba.view.widget.TbGLMediaPreviewView;
import com.baidu.tieba.view.widget.pickcover.PreViewPickCoverView;
import com.baidu.tieba.view.widget.recordeffect.RecordEffectLayout;
import com.baidu.tieba.view.widget.recordeffect.VideoControllerLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.data.MultiMediaData;
import com.baidubce.auth.NTLMEngineImpl;
import com.google.protobuf.CodedInputStream;
import com.repackage.b06;
import com.repackage.c06;
import com.repackage.d86;
import com.repackage.dw8;
import com.repackage.e06;
import com.repackage.e86;
import com.repackage.ed0;
import com.repackage.f06;
import com.repackage.f86;
import com.repackage.g06;
import com.repackage.h86;
import com.repackage.mr4;
import com.repackage.ng;
import com.repackage.np8;
import com.repackage.op8;
import com.repackage.or4;
import com.repackage.pi;
import com.repackage.qg;
import com.repackage.r76;
import com.repackage.re5;
import com.repackage.rp8;
import com.repackage.s76;
import com.repackage.u76;
import com.repackage.vr4;
import com.repackage.wz5;
import com.repackage.yp8;
import com.repackage.yt4;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class TbEditVideoActivity extends BaseActivity<TbEditVideoActivity> implements s76 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public VideoInfo A;
    public float B;
    public String C;
    public String D;
    public float E;
    public boolean F;
    public boolean G;
    public int H;
    public boolean I;
    public TbMusicData J;
    public TbMusicData K;
    public int L;
    public float M;
    public float N;
    public e06.a O;
    public Runnable P;
    public RecordPreviewContainer.f Q;
    public HttpMessageListener R;
    public d86.b S;
    public RecordEffectLayout.i T;
    @NonNull
    public final re5 U;
    public NavigationBar a;
    public TextView b;
    public TextView c;
    public View d;
    public ViewGroup e;
    public ImageView f;
    public ImageView g;
    public TextView h;
    public TextView i;
    public PreViewPickCoverView j;
    public TbGLMediaPreviewView k;
    public LinearLayout l;
    public RelativeLayout m;
    public RecordPreviewContainer n;
    public RelativeLayout o;
    public RelativeLayout p;
    public RelativeLayout q;
    public RelativeLayout r;
    public VideoControllerLayout s;
    public b06 t;
    public f86 u;
    public e86 v;
    public e06 w;
    public r76 x;
    public boolean y;
    public TbMultiMediaData z;

    /* loaded from: classes4.dex */
    public class a implements e06.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbEditVideoActivity a;

        /* renamed from: com.baidu.tieba.view.videoedit.TbEditVideoActivity$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC0258a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CustomResponsedMessage a;

            public RunnableC0258a(a aVar, CustomResponsedMessage customResponsedMessage) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, customResponsedMessage};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = customResponsedMessage;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    MessageManager.getInstance().dispatchResponsedMessage(this.a);
                }
            }
        }

        /* loaded from: classes4.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CustomResponsedMessage a;
            public final /* synthetic */ a b;

            public b(a aVar, CustomResponsedMessage customResponsedMessage) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, customResponsedMessage};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = aVar;
                this.a = customResponsedMessage;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    MessageManager.getInstance().dispatchResponsedMessage(this.a);
                    if (this.b.a.t != null) {
                        this.b.a.t.e();
                    }
                    this.b.a.finish();
                }
            }
        }

        /* loaded from: classes4.dex */
        public class c implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public c(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    TbEditVideoActivity tbEditVideoActivity = this.a.a;
                    tbEditVideoActivity.hideLoadingView(tbEditVideoActivity.e);
                }
            }
        }

        public a(TbEditVideoActivity tbEditVideoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbEditVideoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbEditVideoActivity;
        }

        @Override // com.repackage.e06.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.runOnUiThread(new c(this));
            }
        }

        @Override // com.repackage.e06.a
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                TbEditVideoActivity tbEditVideoActivity = this.a;
                tbEditVideoActivity.showLoadingView(tbEditVideoActivity.e);
            }
        }

        @Override // com.repackage.e06.a
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                if (this.a.F) {
                    File file = new File(str);
                    File file2 = new File(yp8.g);
                    if (!file2.exists()) {
                        file2.mkdir();
                    }
                    String str2 = yp8.g + file.getName();
                    if (!str2.equals(file.getAbsolutePath())) {
                        FileHelper.copyFileByAbsolutelyPath(file.getAbsolutePath(), str2);
                    }
                    new MediaScannerClient(this.a).saveVideo(str2);
                    try {
                        Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
                        intent.setData(UtilHelper.getUriFromFile(file, intent, this.a.getPageContext().getPageActivity()));
                        this.a.sendBroadcast(intent);
                    } catch (Exception e) {
                        this.a.F = false;
                        this.a.s2();
                        this.a.t2();
                        BdLog.d(e.getMessage());
                    }
                    this.a.F = false;
                    TbEditVideoActivity tbEditVideoActivity = this.a;
                    tbEditVideoActivity.showToast(tbEditVideoActivity.getResources().getString(R.string.obfuscated_res_0x7f0f1052));
                    this.a.s2();
                    this.a.t2();
                } else {
                    qg.a().post(new RunnableC0258a(this, new CustomResponsedMessage(2921584, 100)));
                    VideoFileInfo c2 = np8.c(str);
                    if (c2 == null) {
                        return;
                    }
                    this.a.A = new VideoInfo();
                    this.a.A.setVideoPath(str);
                    this.a.A.setThumbPath(this.a.C);
                    this.a.A.setVideoDuration((int) (c2.videoDuration / 1000.0f));
                    this.a.A.setVideoWidth(c2.videoWidth);
                    this.a.A.setVideoHeight(c2.videoHeight);
                    this.a.A.setVideoLength(new File(str).length());
                    this.a.A.setVideoSource(this.a.z.videoInfoSource);
                    this.a.A.setIsCompressedVideo(true);
                    EditVideoData editVideoData = new EditVideoData();
                    if (!StringUtils.isNull(this.a.C)) {
                        editVideoData.coverPath = this.a.C;
                    } else {
                        editVideoData.coverPath = yp8.b;
                    }
                    editVideoData.originPath = this.a.z.path;
                    editVideoData.finalPath = str;
                    this.a.A.setEditVideoData(editVideoData);
                    this.a.z.coverSource = this.a.j.getCurrentMode();
                    this.a.z.coverPath = this.a.C;
                    this.a.z.orignalCoverPath = this.a.D;
                    this.a.z.lastCoverPercent = this.a.E;
                    this.a.A.setMultiMediaData(this.a.z);
                    qg.a().post(new b(this, new CustomResponsedMessage(2921593, this.a.A)));
                }
                TbEditVideoActivity tbEditVideoActivity2 = this.a;
                tbEditVideoActivity2.hideLoadingView(tbEditVideoActivity2.e);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbEditVideoActivity a;

        public b(TbEditVideoActivity tbEditVideoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbEditVideoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbEditVideoActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            VideoFileInfo c;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (c = np8.c(this.a.z.path)) == null) {
                return;
            }
            this.a.A = new VideoInfo();
            this.a.A.setVideoPath(this.a.z.path);
            this.a.A.setThumbPath(this.a.C);
            this.a.A.setVideoDuration((int) (c.videoDuration / 1000.0f));
            this.a.A.setVideoWidth(c.videoWidth);
            this.a.A.setVideoHeight(c.videoHeight);
            this.a.A.setVideoLength(new File(this.a.z.path).length());
            this.a.A.setVideoSource(this.a.z.videoInfoSource);
            this.a.A.setIsCompressedVideo(true);
            EditVideoData editVideoData = new EditVideoData();
            if (!StringUtils.isNull(this.a.C)) {
                editVideoData.coverPath = this.a.C;
            } else {
                editVideoData.coverPath = yp8.b;
            }
            editVideoData.originPath = this.a.A.getVideoPath();
            this.a.A.setEditVideoData(editVideoData);
            this.a.z.coverSource = this.a.j.getCurrentMode();
            this.a.z.coverPath = this.a.C;
            this.a.z.orignalCoverPath = this.a.D;
            this.a.z.lastCoverPercent = this.a.E;
            this.a.A.setMultiMediaData(this.a.z);
            if (WorkPublishOpenHelper.Companion.e(this.a.getIntent(), this.a.A, this.a.getPageContext().getPageActivity(), false, true)) {
                return;
            }
            WriteActivityConfig newInstance = WriteActivityConfig.newInstance(this.a.getPageContext().getPageActivity());
            newInstance.getIntent().putExtras(this.a.getIntent());
            String stringExtra = newInstance.getIntent().getStringExtra("forum_id");
            if (TextUtils.isEmpty(stringExtra)) {
                stringExtra = "0";
            }
            newInstance.getIntent().putExtra("forum_id", stringExtra);
            newInstance.getIntent().setFlags(NTLMEngineImpl.FLAG_REQUEST_128BIT_KEY_EXCH);
            newInstance.getIntent().setFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
            newInstance.setType(9).setVideoInfo(this.a.A).send();
            this.a.finish();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements b06.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbEditVideoActivity a;

        public c(TbEditVideoActivity tbEditVideoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbEditVideoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbEditVideoActivity;
        }

        @Override // com.repackage.b06.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // com.repackage.b06.a
        public void b() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.a.u == null) {
                return;
            }
            this.a.u.a(0.0f);
        }

        @Override // com.repackage.b06.a
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                if (this.a.H != 1) {
                    this.a.u2();
                }
                this.a.U.a();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements or4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mr4 a;
        public final /* synthetic */ TbEditVideoActivity b;

        public d(TbEditVideoActivity tbEditVideoActivity, mr4 mr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbEditVideoActivity, mr4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = tbEditVideoActivity;
            this.a = mr4Var;
        }

        @Override // com.repackage.or4.e
        public void N(or4 or4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, or4Var, i, view2) == null) {
                if (i == 0) {
                    this.b.finish();
                } else {
                    this.a.dismiss();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbEditVideoActivity a;

        public e(TbEditVideoActivity tbEditVideoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbEditVideoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbEditVideoActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.t != null) {
                    this.a.t.start();
                }
                if (this.a.u != null) {
                    this.a.u.onResume();
                    if (this.a.t != null) {
                        this.a.u.a(((float) this.a.t.getCurrentPlayTime()) / 1000.0f);
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbEditVideoActivity a;

        public f(TbEditVideoActivity tbEditVideoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbEditVideoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbEditVideoActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.j.setVisibility(0);
                int height = this.a.a.getHeight();
                int height2 = this.a.j.getHeight();
                int i = pi.i(this.a.getPageContext().getPageActivity());
                float k = pi.k(this.a.getPageContext().getPageActivity()) * this.a.B;
                this.a.M = (i - height) - height2;
                float k2 = (this.a.M * 1.0f) / pi.k(this.a.getPageContext().getPageActivity());
                TbEditVideoActivity tbEditVideoActivity = this.a;
                tbEditVideoActivity.N = height - ((i - tbEditVideoActivity.M) * 0.5f);
                this.a.n.setTranslationY(this.a.N);
                if (this.a.B > k2) {
                    this.a.k.setScaleX(this.a.M / k);
                    this.a.k.setScaleY(this.a.M / k);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbEditVideoActivity a;

        /* loaded from: classes4.dex */
        public class a extends AnimatorListenerAdapter {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ g a;

            public a(g gVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = gVar;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                    this.a.a.j.setVisibility(0);
                }
            }
        }

        /* loaded from: classes4.dex */
        public class b implements ValueAnimator.AnimatorUpdateListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ float a;
            public final /* synthetic */ g b;

            public b(g gVar, float f) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar, Float.valueOf(f)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = gVar;
                this.a = f;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    this.b.a.k.setScaleX(floatValue / this.a);
                    this.b.a.k.setScaleY(floatValue / this.a);
                }
            }
        }

        public g(TbEditVideoActivity tbEditVideoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbEditVideoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbEditVideoActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.a.j, "translationY", this.a.j.getHeight(), 0.0f);
                ofFloat.setDuration(250L);
                ofFloat.addListener(new a(this));
                int height = this.a.a.getHeight();
                int height2 = this.a.j.getHeight();
                int i = pi.i(this.a.getPageContext().getPageActivity());
                float k = pi.k(this.a.getPageContext().getPageActivity()) * this.a.B;
                this.a.M = (i - height) - height2;
                float k2 = (this.a.M * 1.0f) / pi.k(this.a.getPageContext().getPageActivity());
                TbEditVideoActivity tbEditVideoActivity = this.a;
                tbEditVideoActivity.N = height - ((i - tbEditVideoActivity.M) * 0.5f);
                ObjectAnimator duration = ObjectAnimator.ofFloat(this.a.n, "translationY", 0.0f, this.a.N).setDuration(250L);
                if (this.a.B > k2) {
                    ValueAnimator ofFloat2 = ValueAnimator.ofFloat(k, this.a.M);
                    ofFloat2.addUpdateListener(new b(this, k));
                    ofFloat2.setDuration(250L);
                    ofFloat2.start();
                }
                ofFloat.start();
                duration.start();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbEditVideoActivity a;

        /* loaded from: classes4.dex */
        public class a extends AnimatorListenerAdapter {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ h a;

            public a(h hVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {hVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = hVar;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                    this.a.a.j.setVisibility(8);
                }
            }
        }

        /* loaded from: classes4.dex */
        public class b implements ValueAnimator.AnimatorUpdateListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ float a;
            public final /* synthetic */ h b;

            public b(h hVar, float f) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {hVar, Float.valueOf(f)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = hVar;
                this.a = f;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    this.b.a.k.setScaleX(floatValue / this.a);
                    this.b.a.k.setScaleY(floatValue / this.a);
                }
            }
        }

        public h(TbEditVideoActivity tbEditVideoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbEditVideoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbEditVideoActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.a.j, "translationY", 0.0f, this.a.j.getHeight());
                ofFloat.setDuration(250L);
                ofFloat.addListener(new a(this));
                int height = this.a.a.getHeight();
                int height2 = this.a.j.getHeight();
                int i = pi.i(this.a.getPageContext().getPageActivity());
                float k = pi.k(this.a.getPageContext().getPageActivity()) * this.a.B;
                this.a.M = (i - height) - height2;
                float k2 = (this.a.M * 1.0f) / pi.k(this.a.getPageContext().getPageActivity());
                TbEditVideoActivity tbEditVideoActivity = this.a;
                tbEditVideoActivity.N = height - ((i - tbEditVideoActivity.M) * 0.5f);
                ObjectAnimator duration = ObjectAnimator.ofFloat(this.a.n, "translationY", 0.0f, this.a.N).setDuration(250L);
                if (this.a.B > k2) {
                    ValueAnimator ofFloat2 = ValueAnimator.ofFloat(k, this.a.M);
                    ofFloat2.addUpdateListener(new b(this, k));
                    ofFloat2.setDuration(250L);
                    ofFloat2.reverse();
                }
                ofFloat.start();
                duration.reverse();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbEditVideoActivity a;

        public i(TbEditVideoActivity tbEditVideoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbEditVideoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbEditVideoActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.s.setMusicName(this.a.K.title, this.a.K.icon);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbEditVideoActivity a;

        public j(TbEditVideoActivity tbEditVideoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbEditVideoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbEditVideoActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.h.setVisibility(8);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k implements RecordPreviewContainer.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbEditVideoActivity a;

        public k(TbEditVideoActivity tbEditVideoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbEditVideoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbEditVideoActivity;
        }

        @Override // com.baidu.tieba.view.widget.RecordPreviewContainer.f
        public void a(MotionEvent motionEvent) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, motionEvent) == null) && this.a.H == 1 && this.a.v != null) {
                this.a.v.g();
                String currentFilterName = this.a.s.getCurrentFilterName();
                if (StringUtils.isNull(currentFilterName)) {
                    return;
                }
                this.a.h.removeCallbacks(this.a.P);
                this.a.h.setText(currentFilterName);
                this.a.h.setVisibility(0);
                this.a.h.postDelayed(this.a.P, 800L);
            }
        }

        @Override // com.baidu.tieba.view.widget.RecordPreviewContainer.f
        public void b(MotionEvent motionEvent) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent) == null) && this.a.H == 1 && this.a.v != null) {
                this.a.v.e();
                String currentFilterName = this.a.s.getCurrentFilterName();
                if (StringUtils.isNull(currentFilterName)) {
                    return;
                }
                this.a.h.removeCallbacks(this.a.P);
                this.a.h.setText(currentFilterName);
                this.a.h.setVisibility(0);
                this.a.h.postDelayed(this.a.P, 800L);
            }
        }

        @Override // com.baidu.tieba.view.widget.RecordPreviewContainer.f
        public void c(MotionEvent motionEvent, float f, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{motionEvent, Float.valueOf(f), Float.valueOf(f2)}) == null) {
                this.a.v2();
                if (this.a.s == null || !this.a.s.p()) {
                    return;
                }
                this.a.s.m(null, false);
            }
        }

        @Override // com.baidu.tieba.view.widget.RecordPreviewContainer.f
        public void d(MotionEvent motionEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, motionEvent) == null) {
                this.a.v2();
                if (this.a.s == null || !this.a.s.p()) {
                    return;
                }
                this.a.s.m(null, false);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class l extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbEditVideoActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(TbEditVideoActivity tbEditVideoActivity, int i, boolean z) {
            super(i, z);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbEditVideoActivity, Integer.valueOf(i), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Boolean) objArr2[1]).booleanValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbEditVideoActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && (httpResponsedMessage instanceof ResponseGetQmFiltersMessage)) {
                List<QmFilterItem> filterItems = httpResponsedMessage.getError() == 0 ? ((ResponseGetQmFiltersMessage) httpResponsedMessage).getFilterItems() : null;
                if (this.a.s != null) {
                    if (filterItems == null) {
                        filterItems = new ArrayList<>();
                    }
                    QmFilterItem qmFilterItem = new QmFilterItem();
                    qmFilterItem.id = "-1";
                    qmFilterItem.bgurl = R.drawable.obfuscated_res_0x7f0809f8 + "";
                    qmFilterItem.name = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0618);
                    qmFilterItem.isSelect = true;
                    qmFilterItem.localPath = "origin";
                    filterItems.add(0, qmFilterItem);
                    this.a.s.setFilterData(filterItems);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class m implements d86.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbEditVideoActivity a;

        public m(TbEditVideoActivity tbEditVideoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbEditVideoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbEditVideoActivity;
        }

        @Override // com.repackage.d86.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (this.a.s != null) {
                    QmFilterItem qmFilterItem = new QmFilterItem();
                    qmFilterItem.id = "-1";
                    qmFilterItem.bgurl = R.drawable.obfuscated_res_0x7f0809f8 + "";
                    qmFilterItem.name = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0618);
                    qmFilterItem.isSelect = true;
                    qmFilterItem.localPath = "origin";
                    this.a.s.z(qmFilterItem);
                    if (this.a.v != null) {
                        this.a.v.a(null);
                    }
                    this.a.s.setDownLoadFilter(null);
                }
                if (StringUtils.isNull(str)) {
                    str = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f11b8);
                }
                this.a.showToast(str);
            }
        }

        @Override // com.repackage.d86.b
        public void b() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.a.s == null) {
                return;
            }
            this.a.s.setDownLoadFilter(null);
        }

        @Override // com.repackage.d86.b
        public void c(QmFilterItem qmFilterItem) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, qmFilterItem) == null) {
                if (this.a.v != null) {
                    this.a.v.a(qmFilterItem);
                }
                if (this.a.s != null) {
                    this.a.s.setDownLoadFilter(null);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class n implements RecordEffectLayout.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbEditVideoActivity a;

        public n(TbEditVideoActivity tbEditVideoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbEditVideoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbEditVideoActivity;
        }

        @Override // com.baidu.tieba.view.widget.recordeffect.RecordEffectLayout.i
        public void a(QmStickerItem qmStickerItem) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, qmStickerItem) == null) {
            }
        }

        @Override // com.baidu.tieba.view.widget.recordeffect.RecordEffectLayout.i
        public void b(dw8 dw8Var, Object obj) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dw8Var, obj) == null) || dw8Var == null) {
                return;
            }
            int type = dw8Var.getType();
            if (type == 2) {
                if (this.a.v != null && (dw8Var.c() instanceof QmFilterItem)) {
                    QmFilterItem qmFilterItem = (QmFilterItem) dw8Var.c();
                    String f = this.a.v.f(qmFilterItem.fileUrl);
                    if (StringUtils.isNull(f) && !"-1".equals(qmFilterItem.id)) {
                        if (this.a.s != null) {
                            this.a.s.setDownLoadFilter(qmFilterItem);
                        }
                        this.a.v.c(qmFilterItem);
                    } else {
                        qmFilterItem.localPath = f;
                        this.a.v.a(qmFilterItem);
                        if (this.a.s != null) {
                            this.a.s.setDownLoadFilter(null);
                        }
                    }
                    this.a.y = true;
                }
            } else if (type == 3 && (dw8Var.c() instanceof MusicData)) {
                MusicData musicData = (MusicData) dw8Var.c();
                TbMusicData tbMusicData = new TbMusicData();
                tbMusicData.id = musicData.id;
                tbMusicData.title = musicData.name;
                tbMusicData.url = musicData.resource;
                tbMusicData.icon = musicData.img;
                tbMusicData.type = ng.e(musicData.type, 1);
                if (MusicData.MUSIC_NORMAL_ID.equals(musicData.id) || MusicData.MUSIC_CLOUD_ID.equals(musicData.id)) {
                    this.a.u.e(this.a.K);
                    this.a.K = tbMusicData;
                    if (!MusicData.MUSIC_CLOUD_ID.equals(musicData.id)) {
                        this.a.s.setMusicName(this.a.K.title, "");
                    }
                } else {
                    this.a.K = tbMusicData;
                    this.a.u.e(this.a.K);
                    this.a.s.setMusicName(this.a.K.title, "");
                }
                if (!MusicData.MUSIC_CLOUD_ID.equals(musicData.id)) {
                    this.a.s.setMusicName(this.a.K.title, "");
                }
                this.a.u.c((MusicData) dw8Var.c(), obj);
                if (this.a.t != null) {
                    this.a.u.a(((float) this.a.t.getCurrentPlayTime()) / 1000.0f);
                }
                this.a.y = true;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class o implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbEditVideoActivity a;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ o a;

            public a(o oVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {oVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = oVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.a.x.c();
                }
            }
        }

        public o(TbEditVideoActivity tbEditVideoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbEditVideoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbEditVideoActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.H == 3) {
                    boolean z = this.a.z != null && this.a.z.coverSource == 2;
                    if (this.a.x != null) {
                        if (z) {
                            if (!StringUtils.isNull(this.a.D)) {
                                this.a.x.m(this.a.D);
                            } else {
                                this.a.x.l();
                            }
                        } else {
                            this.a.x.i(this.a.E);
                        }
                        this.a.x.q(this.a.z.getCoverStickerList());
                    }
                }
                if (this.a.x == null || !TextUtils.isEmpty(this.a.C)) {
                    return;
                }
                qg.a().postDelayed(new a(this), 300L);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class p implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbEditVideoActivity a;

        public p(TbEditVideoActivity tbEditVideoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbEditVideoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbEditVideoActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.v == null || this.a.v.b() == null) {
                return;
            }
            this.a.t.a(this.a.v.b());
        }
    }

    /* loaded from: classes4.dex */
    public class q implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbEditVideoActivity a;

        public q(TbEditVideoActivity tbEditVideoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbEditVideoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbEditVideoActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                TbEditVideoActivity tbEditVideoActivity = this.a;
                tbEditVideoActivity.showToast(tbEditVideoActivity.getString(R.string.obfuscated_res_0x7f0f051f));
            }
        }
    }

    public TbEditVideoActivity() {
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
        this.y = false;
        this.F = false;
        this.G = false;
        this.H = 1;
        this.I = false;
        this.M = pi.i(getPageContext().getPageActivity());
        this.N = 0.0f;
        this.O = new a(this);
        this.P = new j(this);
        this.Q = new k(this);
        this.R = new l(this, CmdConfigHttp.CMD_GET_QM_FILTERS, true);
        this.S = new m(this);
        this.T = new n(this);
        this.U = new re5(new o(this));
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
        }
    }

    @Override // com.repackage.s76
    public void h0(String str) {
        List<MultiMediaData> j2;
        r76 r76Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || StringUtils.isNull(str) || str.equals(this.C)) {
            return;
        }
        r76 r76Var2 = this.x;
        if (r76Var2 != null) {
            this.E = r76Var2.p();
        }
        this.C = str;
        if (this.j.getCurrentMode() == 2 && (r76Var = this.x) != null) {
            r76Var.l();
        }
        if (this.I) {
            qg.a().post(new q(this));
            if (this.H != 3) {
                b06 b06Var = this.t;
                if (b06Var != null) {
                    b06Var.start();
                }
                f86 f86Var = this.u;
                if (f86Var != null) {
                    f86Var.onResume();
                    b06 b06Var2 = this.t;
                    if (b06Var2 != null) {
                        this.u.a(((float) b06Var2.getCurrentPlayTime()) / 1000.0f);
                    }
                }
            }
            this.y = true;
        }
        r76 r76Var3 = this.x;
        if (r76Var3 != null && (j2 = r76Var3.j()) != null) {
            this.z.setCoverStickerList(j2);
        }
        if (this.H == 3) {
            qg.a().post(new b(this));
        }
    }

    public final void i2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.y) {
                mr4 mr4Var = new mr4(getPageContext(), new or4(getPageContext().getPageActivity()));
                mr4Var.j(getResources().getString(R.string.obfuscated_res_0x7f0f051e), new String[]{getResources().getString(R.string.obfuscated_res_0x7f0f0f40)}, new d(this, mr4Var));
                mr4Var.m();
                return;
            }
            finish();
        }
    }

    public final void j2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.b.setVisibility(0);
            this.c.setVisibility(0);
            this.j.post(new f(this));
            this.l.setVisibility(8);
            this.m.setVisibility(8);
            this.i.setVisibility(8);
            SkinManager.setBackgroundColor(this.e, R.color.CAM_X0611, 0);
        }
    }

    public final void k2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.a.setVisibility(8);
            this.l.setVisibility(8);
            this.m.setVisibility(8);
            this.i.setVisibility(8);
        }
    }

    public final void l2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.a.setVisibility(0);
            this.l.setVisibility(0);
            this.m.setVisibility(0);
            this.i.setVisibility(0);
        }
    }

    public final f06 m2() {
        InterceptResult invokeV;
        f86 f86Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            f06 f06Var = new f06();
            TbMultiMediaData tbMultiMediaData = this.z;
            float f2 = 0.0f;
            if (tbMultiMediaData != null) {
                f06Var.j(tbMultiMediaData);
                f06Var.n(this.B);
                TbMultiMediaData tbMultiMediaData2 = this.z;
                int i2 = tbMultiMediaData2.width;
                int i3 = tbMultiMediaData2.height;
                float f3 = tbMultiMediaData2.angle;
                if (f3 == 90.0f || f3 == 270.0f) {
                    i3 = i2;
                    i2 = i3;
                }
                if (i2 != 0) {
                    float f4 = i3;
                    float f5 = i2;
                    float f6 = this.B;
                    if (f6 > (f4 * 1.0f) / f5) {
                        i3 = (int) (f5 * f6);
                    } else if (f6 != 0.0f) {
                        i2 = (int) (f4 / f6);
                    }
                    f06Var.m(i2);
                    f06Var.l(i3);
                }
            }
            e86 e86Var = this.v;
            if (e86Var != null && e86Var.b() != null) {
                QmFilterItem b2 = this.v.b();
                String str = b2.localPath;
                Filter filter = new Filter();
                if (!StringUtils.isNull(str) && !"origin".equals(str)) {
                    f2 = (ng.d(b2.effect, 100.0f) * 1.0f) / 100.0f;
                    filter.setDataType(1);
                    filter.setLevel(f2);
                    filter.setFile(new File(b2.localPath));
                }
                TbFilterValue tbFilterValue = new TbFilterValue();
                tbFilterValue.setId(b2.id);
                tbFilterValue.setLevel(f2);
                tbFilterValue.setName(b2.name);
                tbFilterValue.setFilterType(2);
                tbFilterValue.setFilterPath(str);
                tbFilterValue.mFilter = filter;
                tbFilterValue.mComplex = ng.e(b2.complex, 0);
                tbFilterValue.mRootFilePath = str;
                f06Var.h(tbFilterValue);
            }
            b06 b06Var = this.t;
            if (b06Var != null) {
                f06Var.i(b06Var.getMediaTrackConfig());
            }
            TbMusicData tbMusicData = this.K;
            if (tbMusicData != null && (f86Var = this.u) != null) {
                tbMusicData.localPath = f86Var.b();
                f06Var.k(this.K);
            }
            return f06Var;
        }
        return (f06) invokeV.objValue;
    }

    public final void n2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.H = 1;
            SkinManager.setBackgroundColor(this.e, R.color.CAM_X0105, 0);
            this.b.setVisibility(8);
            this.c.setVisibility(8);
            qg.a().post(new h(this));
            this.l.setVisibility(0);
            this.m.setVisibility(0);
            this.i.setVisibility(0);
        }
    }

    public final void o2() {
        TbMusicData tbMusicData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            boolean booleanExtra = getIntent().getBooleanExtra(AlbumActivityConfig.KEY_DIRECT_TO_WORK_PUBLISH_PAGE, false);
            this.k = (TbGLMediaPreviewView) findViewById(R.id.obfuscated_res_0x7f090832);
            this.j = (PreViewPickCoverView) findViewById(R.id.obfuscated_res_0x7f0918bb);
            u76 u76Var = new u76(getPageContext(), this.k, this.j, this.z, booleanExtra);
            this.x = u76Var;
            u76Var.d(this);
            this.I = false;
            c06 c06Var = new c06(getPageContext(), this.k, this.z, this.x, booleanExtra);
            this.t = c06Var;
            c06Var.f(this.B);
            this.t.b(new c(this));
            this.s = (VideoControllerLayout) findViewById(R.id.obfuscated_res_0x7f091a88);
            h86 h86Var = new h86(getPageContext(), this.s);
            this.u = h86Var;
            this.s.setMusicManager(h86Var);
            if (this.u != null && (tbMusicData = this.K) != null && !TextUtils.isEmpty(tbMusicData.localPath) && !TextUtils.isEmpty(this.K.id)) {
                TbMusicData tbMusicData2 = this.K;
                if (tbMusicData2.type == 2) {
                    this.s.setEffectLayoutCurrentMusicName(getResources().getString(R.string.obfuscated_res_0x7f0f0b04));
                } else {
                    this.s.setEffectLayoutCurrentMusicName(tbMusicData2.title);
                }
                f86 f86Var = this.u;
                TbMusicData tbMusicData3 = this.K;
                f86Var.f(tbMusicData3.localPath, tbMusicData3.id);
                b06 b06Var = this.t;
                if (b06Var != null) {
                    this.u.a(((float) b06Var.getCurrentPlayTime()) / 1000.0f);
                }
                this.s.setMusicName(this.K.title, "");
            }
            d86 d86Var = new d86(null, this.t, this.s);
            this.v = d86Var;
            d86Var.d(this.S);
            this.v.h();
            this.s.setEditManager(this.t);
            this.w = new g06(getPageContext(), this.O);
            r2();
            QmFilterItem videoFilter = this.z.getVideoFilter();
            if (videoFilter != null) {
                this.v.a(videoFilter);
                this.s.setCurrentFilterWithQmFilterItem(videoFilter);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        r76 r76Var;
        TbMultiMediaData tbMultiMediaData;
        TbMultiMediaData tbMultiMediaData2;
        r76 r76Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048585, this, i2, i3, intent) == null) {
            if (intent == null) {
                if (this.j.getCurrentMode() != 2 || i2 != 12002 || (r76Var2 = this.x) == null || r76Var2.o()) {
                    return;
                }
                this.j.setCurrentMode(1);
                this.x.l();
            } else if (i2 == 25032) {
                if (i3 != -1) {
                    return;
                }
                String stringExtra = intent.getStringExtra(CloudMusicActivityConfig.MUSIC_ID);
                TbMusicData tbMusicData = (TbMusicData) intent.getSerializableExtra(CloudMusicActivityConfig.MUSIC_DATA);
                if (tbMusicData != null) {
                    this.K = tbMusicData;
                    if (TextUtils.isEmpty(tbMusicData.localPath) || TextUtils.isEmpty(stringExtra)) {
                        return;
                    }
                    String str = tbMusicData.localPath;
                    if (this.u == null || TextUtils.isEmpty(str)) {
                        return;
                    }
                    this.u.f(str, stringExtra);
                    b06 b06Var = this.t;
                    if (b06Var != null) {
                        this.u.a(((float) b06Var.getCurrentPlayTime()) / 1000.0f);
                    }
                    this.s.y(tbMusicData);
                }
            } else if (i2 == 25062) {
                rp8.c(intent, this.k);
                if (i3 == -1 && (tbMultiMediaData = (TbMultiMediaData) intent.getParcelableExtra(TbEditVideoActivityConfig.KEY_EDIT_VIDEO_DATA)) != null && this.t != null && (tbMultiMediaData2 = this.z) != null && (tbMultiMediaData.start != tbMultiMediaData2.start || tbMultiMediaData.end != tbMultiMediaData2.end)) {
                    this.z = tbMultiMediaData;
                    this.t.c(tbMultiMediaData);
                    this.s.post(new p(this));
                    this.y = true;
                }
                l2();
            } else if (i2 == 12002) {
                if (i3 == -1) {
                    String stringExtra2 = intent.getStringExtra(VideoCoverSelectActivityConfig.KEY_VIDEO_COVER_IMAGE_PATH);
                    if (TextUtils.isEmpty(stringExtra2) || (r76Var = this.x) == null) {
                        return;
                    }
                    r76Var.m(stringExtra2);
                    this.D = stringExtra2;
                    return;
                }
                r76 r76Var3 = this.x;
                if (r76Var3 == null || r76Var3.o()) {
                    return;
                }
                this.j.setCurrentMode(1);
                this.x.l();
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        r76 r76Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (this.H == 2) {
                if (this.j.getCurrentMode() == 2 && (r76Var = this.x) != null) {
                    r76Var.l();
                }
                r76 r76Var2 = this.x;
                if (r76Var2 != null) {
                    r76Var2.reset();
                }
                qg.a().post(new e(this));
                n2();
                return;
            }
            i2();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        r76 r76Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, view2) == null) {
            super.onClick(view2);
            if (view2.getId() == R.id.obfuscated_res_0x7f090493) {
                v2();
                if (this.s.q()) {
                    this.f.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f0809f7));
                } else {
                    this.f.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f0809f9));
                }
                this.s.v();
                if (this.s.t()) {
                    r2();
                    return;
                }
                return;
            }
            if (view2.getId() == R.id.obfuscated_res_0x7f090495) {
                v2();
                if (this.s.s()) {
                    this.g.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f0809fa));
                } else {
                    this.g.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f0809fb));
                }
                this.s.w();
                TbMusicData tbMusicData = this.K;
                if (tbMusicData == null || tbMusicData.type != 2) {
                    return;
                }
                this.s.postDelayed(new i(this), 300L);
            } else if (view2.getId() == R.id.obfuscated_res_0x7f090491) {
                TbFileVideoActivityConfig tbFileVideoActivityConfig = new TbFileVideoActivityConfig(getPageContext().getPageActivity());
                tbFileVideoActivityConfig.setForResult();
                tbFileVideoActivityConfig.setFrom(2);
                tbFileVideoActivityConfig.setTbMultiMediaData(this.z);
                e86 e86Var = this.v;
                if (e86Var != null && e86Var.b() != null) {
                    tbFileVideoActivityConfig.setFilter(this.v.b());
                }
                tbFileVideoActivityConfig.setEnterAnimValues(rp8.a(this.k));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921582, tbFileVideoActivityConfig));
                k2();
            } else if (view2.getId() == R.id.obfuscated_res_0x7f09048f) {
                r76 r76Var2 = this.x;
                if (r76Var2 != null) {
                    r76Var2.i(this.E);
                    u2();
                    if (this.j.getCurrentMode() == 2 && !StringUtils.isNull(this.D)) {
                        this.x.m(this.D);
                    } else {
                        this.j.setCurrentMode(1);
                    }
                    this.x.q(this.z.getCoverStickerList());
                    w2();
                }
                yt4.k().u("key_edit_video_pick_cover_tip_show", true);
            } else if (view2.getId() == R.id.obfuscated_res_0x7f09082f) {
                if (this.w != null) {
                    this.F = true;
                    u2();
                    this.w.a(m2());
                }
            } else if (view2.getId() == R.id.obfuscated_res_0x7f09082e) {
                if (WorkPublishManager.isWorkPublishLocate()) {
                    int i2 = this.L;
                    TiebaStatic.log(new StatisticItem("c14310").param("obj_source", i2 != 1 ? i2 == 2 ? 1 : 0 : 2));
                }
                if (!yt4.k().h("key_edit_video_pick_cover_tip_show", false)) {
                    wz5 wz5Var = new wz5(getPageContext(), this.r);
                    wz5Var.e0(R.drawable.obfuscated_res_0x7f080f00);
                    wz5Var.L(1);
                    wz5Var.f0(true);
                    wz5Var.X(R.color.CAM_X0101);
                    wz5Var.c0(R.dimen.T_X08);
                    wz5Var.P(R.dimen.T_X08);
                    wz5Var.a0(UtilHelper.getDimenPixelSize(R.dimen.tbds26));
                    wz5Var.b0(UtilHelper.getDimenPixelSize(R.dimen.tbds26));
                    wz5Var.j0(getResources().getString(R.string.obfuscated_res_0x7f0f0520));
                    yt4.k().u("key_edit_video_pick_cover_tip_show", true);
                    return;
                }
                u2();
                this.w.a(m2());
                VideoFileInfo c2 = np8.c(this.z.path);
                if (c2 == null) {
                    return;
                }
                VideoInfo videoInfo = new VideoInfo();
                this.A = videoInfo;
                videoInfo.setVideoPath(this.z.path);
                this.A.setThumbPath(this.C);
                this.A.setVideoDuration((int) (c2.videoDuration / 1000.0f));
                this.A.setVideoWidth(c2.videoWidth);
                this.A.setVideoHeight(c2.videoHeight);
                this.A.setVideoLength(new File(this.z.path).length());
                this.A.setVideoSource(this.z.videoInfoSource);
                this.A.setIsCompressedVideo(true);
                EditVideoData editVideoData = new EditVideoData();
                if (StringUtils.isNull(this.C)) {
                    editVideoData.coverPath = yp8.b;
                } else {
                    editVideoData.coverPath = this.C;
                }
                editVideoData.originPath = this.A.getVideoPath();
                this.A.setEditVideoData(editVideoData);
                this.z.coverSource = this.j.getCurrentMode();
                TbMultiMediaData tbMultiMediaData = this.z;
                tbMultiMediaData.coverPath = this.C;
                tbMultiMediaData.orignalCoverPath = this.D;
                List<MultiMediaData> j2 = this.x.j();
                if (j2 != null) {
                    this.z.setCoverStickerList(j2);
                }
                this.z.setOrignalVideoPath(this.A.getVideoPath());
                this.z.setVideoFilter(this.v.b());
                this.A.setMultiMediaData(this.z);
                this.G = true;
                if (WorkPublishOpenHelper.Companion.e(getIntent(), this.A, getPageContext().getPageActivity(), true, true)) {
                    return;
                }
                WriteActivityConfig newInstance = WriteActivityConfig.newInstance(getPageContext().getPageActivity());
                newInstance.getIntent().putExtras(getIntent());
                String stringExtra = newInstance.getIntent().getStringExtra("forum_id");
                if (TextUtils.isEmpty(stringExtra)) {
                    stringExtra = "0";
                }
                newInstance.getIntent().putExtra("forum_id", stringExtra);
                newInstance.getIntent().setFlags(NTLMEngineImpl.FLAG_REQUEST_128BIT_KEY_EXCH);
                newInstance.getIntent().setFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
                newInstance.setType(9).setVideoInfo(this.A).setNeedClosePrePage(true).send();
                finish();
            } else if (view2 == this.d) {
                onBackPressed();
            } else if (view2 == this.c) {
                int i3 = this.H;
                if (i3 == 2) {
                    r76 r76Var3 = this.x;
                    if (r76Var3 != null) {
                        this.I = true;
                        r76Var3.f();
                    }
                    n2();
                } else if (i3 != 3 || (r76Var = this.x) == null) {
                } else {
                    this.I = true;
                    r76Var.f();
                }
            } else if (view2.getId() == this.j.getVideoPick().getId()) {
                if (this.j.getCurrentMode() != 1) {
                    this.j.setCurrentMode(1);
                    r76 r76Var4 = this.x;
                    if (r76Var4 != null) {
                        r76Var4.i(this.E);
                        this.x.l();
                    }
                }
            } else if (view2.getId() == this.j.getImagePick().getId()) {
                if (this.j.getCurrentMode() != 2) {
                    this.j.setCurrentMode(2);
                    r76 r76Var5 = this.x;
                    if (r76Var5 != null) {
                        this.E = r76Var5.p();
                    }
                    q2();
                }
            } else if (view2.getId() == this.j.getCoverImageView().getId() && this.j.getCurrentMode() == 2) {
                q2();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d0053);
            setSwipeBackEnabled(false);
            if (getIntent() != null) {
                this.H = getIntent().getIntExtra(TbEditVideoActivityConfig.KEY_EDIT_PAGE_MODE_TYPE, 1);
                this.z = (TbMultiMediaData) getIntent().getParcelableExtra(TbEditVideoActivityConfig.KEY_EDIT_VIDEO_DATA);
                this.B = getIntent().getFloatExtra(TbEditVideoActivityConfig.KEY_EDIT_VIDEO_RATIO, 0.0f);
                this.L = getIntent().getIntExtra(TbEditVideoActivityConfig.KEY_EDIT_VIDEO_FROM, 0);
                TbMusicData tbMusicData = (TbMusicData) getIntent().getSerializableExtra(TbEditVideoActivityConfig.KEY_EDIT_VIDEO_MUSIC_DATA);
                this.J = tbMusicData;
                this.K = tbMusicData;
                TbMultiMediaData tbMultiMediaData = this.z;
                tbMultiMediaData.videoRatio = this.B;
                this.C = tbMultiMediaData.coverPath;
                this.D = tbMultiMediaData.orignalCoverPath;
                this.E = tbMultiMediaData.lastCoverPercent;
            }
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_QM_FILTERS, TbConfig.SERVER_ADDRESS + TbConfig.GET_QM_FILTERS);
            tbHttpMessageTask.setResponsedClass(ResponseGetQmFiltersMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            o2();
            p2();
            registerListener(this.R);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onDestroy();
            b06 b06Var = this.t;
            if (b06Var != null) {
                b06Var.onDestroy();
                if (!this.G) {
                    this.t.e();
                }
            }
            f86 f86Var = this.u;
            if (f86Var != null) {
                f86Var.releasePlayer();
                this.u.d();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onPause();
            s2();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onResume();
            t2();
        }
    }

    public final void p2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.e = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f091b4c);
            this.a = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f091568);
            this.h = (TextView) findViewById(R.id.obfuscated_res_0x7f090827);
            this.f = (ImageView) findViewById(R.id.obfuscated_res_0x7f090492);
            this.g = (ImageView) findViewById(R.id.obfuscated_res_0x7f090494);
            this.i = (TextView) findViewById(R.id.obfuscated_res_0x7f09082e);
            this.m = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f09082f);
            this.l = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f09048d);
            this.p = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f090493);
            this.q = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f090495);
            this.r = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f09048f);
            this.j.setVisibility(4);
            RecordPreviewContainer recordPreviewContainer = (RecordPreviewContainer) findViewById(R.id.obfuscated_res_0x7f09082d);
            this.n = recordPreviewContainer;
            recordPreviewContainer.setOnViewClickListener(this.Q);
            TextView centerTextTitle = this.a.setCenterTextTitle(getString(R.string.obfuscated_res_0x7f0f0e4d));
            this.b = centerTextTitle;
            centerTextTitle.setTextColor(getResources().getColor(R.color.CAM_X0101));
            this.b.setVisibility(8);
            View addSystemImageButton = this.a.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.d = addSystemImageButton;
            ((ImageView) addSystemImageButton.findViewById(R.id.obfuscated_res_0x7f0924ef)).setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f0809e0));
            TextView addTextButton = this.a.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(R.string.obfuscated_res_0x7f0f104a));
            this.c = addTextButton;
            addTextButton.setTextColor(getResources().getColor(R.color.CAM_X0101));
            this.c.setVisibility(8);
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f090491);
            this.o = relativeLayout;
            int i2 = 0;
            if (this.L == 1) {
                relativeLayout.setVisibility(8);
            } else {
                relativeLayout.setVisibility(0);
            }
            if (this.s.getRecrodButton() != null) {
                this.s.getRecrodButton().setVisibility(8);
            }
            this.s.setEffectChoosedListener(this.T);
            this.d.setOnClickListener(this);
            this.c.setOnClickListener(this);
            this.j.setOnClickListener(this);
            this.i.setOnClickListener(this);
            this.m.setOnClickListener(this);
            this.o.setOnClickListener(this);
            this.p.setOnClickListener(this);
            this.q.setOnClickListener(this);
            this.r.setOnClickListener(this);
            vr4 d2 = vr4.d(this.h);
            d2.A(R.string.F_X02);
            d2.y(R.array.S_O_X001);
            vr4 d3 = vr4.d(findViewById(R.id.obfuscated_res_0x7f09082e));
            d3.n(R.string.J_X01);
            d3.f(R.color.CAM_X0302);
            vr4.d(findViewById(R.id.obfuscated_res_0x7f090831)).y(R.array.S_O_X001);
            vr4.d(findViewById(R.id.obfuscated_res_0x7f090497)).y(R.array.S_O_X001);
            vr4.d(findViewById(R.id.obfuscated_res_0x7f090498)).y(R.array.S_O_X001);
            vr4.d(findViewById(R.id.obfuscated_res_0x7f090496)).y(R.array.S_O_X001);
            vr4.d(findViewById(R.id.obfuscated_res_0x7f090499)).y(R.array.S_O_X001);
            TbMultiMediaData tbMultiMediaData = this.z;
            if (tbMultiMediaData != null && tbMultiMediaData.coverSource == 2) {
                this.j.setCurrentMode(2);
            } else {
                this.j.setCurrentMode(1);
            }
            if (this.H == 3) {
                j2();
                this.U.b();
            } else if (WorkPublishManager.isWorkPublishLocate()) {
                int i3 = this.L;
                if (i3 == 1) {
                    i2 = 2;
                } else if (i3 == 2) {
                    i2 = 1;
                }
                TiebaStatic.log(new StatisticItem("c14309").param("obj_source", i2));
            }
        }
    }

    public final void q2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            WriteData writeData = new WriteData();
            new FrsTabInfoData();
            new PostPrefixData();
            boolean booleanExtra = getIntent().getBooleanExtra(AlbumActivityConfig.KEY_DIRECT_TO_WORK_PUBLISH_PAGE, false);
            AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(getPageContext().getPageActivity(), writeImagesInfo.toJsonString(), true, true);
            albumFloatActivityConfig.getIntent().putExtra(AlbumActivityConfig.IS_SELECT_DIRECTLY, true);
            albumFloatActivityConfig.getIntent().putExtra("forum_id", writeData.getForumId());
            albumFloatActivityConfig.getIntent().putExtra("forum_name", writeData.getForumName());
            albumFloatActivityConfig.getIntent().putExtra("from", AlbumActivityConfig.FROM_WRITE);
            albumFloatActivityConfig.getIntent().putExtra(AlbumActivityConfig.KEY_DIRECT_TO_WORK_PUBLISH_PAGE, booleanExtra);
            albumFloatActivityConfig.setRequestCode(TaskResponseData.ERROR_NO_TASK_OFFLINE_03);
            albumFloatActivityConfig.setAlbumThread(0);
            albumFloatActivityConfig.setCanSelectVideo(false);
            albumFloatActivityConfig.setCanSelectGif(false);
            albumFloatActivityConfig.setCanEditImage(false);
            albumFloatActivityConfig.setNeedClipImage(true);
            albumFloatActivityConfig.setImageClipType(this.B > 1.0f ? 2 : 1);
            albumFloatActivityConfig.setAlbumShowCapture(false);
            albumFloatActivityConfig.setAlbumDirectDoneOnlyOne(true);
            sendMessage(new CustomMessage(2002001, albumFloatActivityConfig));
        }
    }

    public final void r2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_QM_FILTERS);
            httpMessage.addParam("uh", Build.MANUFACTURER + "," + Build.HARDWARE + "," + Build.BOARD + "," + (op8.b(this) ? 1 : 0));
            httpMessage.addParam("ut", Build.MODEL + "_" + Build.VERSION.RELEASE + "_" + op8.a() + "_" + Build.BRAND.replace("_", ""));
            StringBuilder sb = new StringBuilder();
            sb.append(ed0.h());
            sb.append("");
            httpMessage.addParam("sdk_version", sb.toString());
            sendMessage(httpMessage);
        }
    }

    public final void s2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            b06 b06Var = this.t;
            if (b06Var != null) {
                b06Var.onPause();
            }
            f86 f86Var = this.u;
            if (f86Var != null) {
                f86Var.onPause();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, view2) == null) {
            super.showLoadingView(view2);
            if (getLoadingView() == null || getLoadingView().k() == null) {
                return;
            }
            getLoadingView().k().setVisibility(8);
        }
    }

    public final void t2() {
        f86 f86Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            ViewGroup viewGroup = this.e;
            if (viewGroup != null) {
                viewGroup.setSystemUiVisibility(4100);
            }
            b06 b06Var = this.t;
            if (b06Var != null) {
                b06Var.onResume();
            }
            if (this.H == 1 && (f86Var = this.u) != null) {
                f86Var.onResume();
                b06 b06Var2 = this.t;
                if (b06Var2 != null) {
                    this.u.a(((float) b06Var2.getCurrentPlayTime()) / 1000.0f);
                }
            }
            e86 e86Var = this.v;
            if (e86Var != null) {
                e86Var.h();
            }
        }
    }

    public final void u2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            b06 b06Var = this.t;
            if (b06Var != null) {
                b06Var.pause();
            }
            f86 f86Var = this.u;
            if (f86Var != null) {
                f86Var.onPause();
            }
        }
    }

    public final void v2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            this.f.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f0809f7));
            this.g.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f0809fa));
        }
    }

    public final void w2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            this.H = 2;
            SkinManager.setBackgroundColor(this.e, R.color.CAM_X0611, 0);
            v2();
            VideoControllerLayout videoControllerLayout = this.s;
            if (videoControllerLayout != null && videoControllerLayout.p()) {
                this.s.m(null, false);
            }
            this.b.setVisibility(0);
            this.c.setVisibility(0);
            qg.a().post(new g(this));
            this.l.setVisibility(8);
            this.m.setVisibility(8);
            this.i.setVisibility(8);
        }
    }
}
