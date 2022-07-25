package com.baidu.tieba.video.record;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.CloudMusicActivityConfig;
import com.baidu.tbadk.core.atomData.EditVideoActivityConfig;
import com.baidu.tbadk.core.atomData.RecordVideoActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.DeviceInfoUtil;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.RomTypeUtil;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.editvideo.model.SelectMusicModel;
import com.baidu.tieba.video.record.GLVideoPreviewView;
import com.baidu.tieba.video.record.RecordLayout;
import com.baidu.tieba.video.record.RecordTabLayout;
import com.baidu.tieba.video.record.VideoControllerLayout;
import com.baidu.tieba.video.record.VideoEffectButtonLayout;
import com.baidu.tieba.video.record.VideoEffectLayout;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.as8;
import com.repackage.br8;
import com.repackage.cr8;
import com.repackage.dr4;
import com.repackage.kl7;
import com.repackage.lp8;
import com.repackage.lr8;
import com.repackage.mr8;
import com.repackage.ol7;
import com.repackage.pi;
import com.repackage.qr8;
import com.repackage.sq8;
import com.repackage.sr8;
import com.repackage.ur8;
import com.repackage.vr8;
import com.repackage.wp8;
import com.repackage.wr8;
import com.repackage.xr8;
import com.repackage.zr8;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes4.dex */
public class RecordVideoActivity extends BaseActivity implements VideoEffectButtonLayout.a, VideoControllerLayout.f, VideoEffectLayout.h, vr8.l, RecordTabLayout.c, RecordLayout.a, GLVideoPreviewView.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ForumWriteData A;
    public WriteImagesInfo B;
    public String C;
    public boolean D;
    public boolean E;
    public zr8 F;
    public StickerItem G;
    public SelectMusicModel H;
    public xr8 I;
    public RecordTabLayout J;
    public int K;
    public ImageFileInfo L;
    public kl7 M;
    public CustomMessageListener N;
    public br8.a O;
    public HttpMessageListener P;
    public qr8 Q;
    public boolean R;
    public final CustomMessageListener S;
    public final CustomMessageListener T;
    public RecordLayout a;
    public wr8 b;
    public VideoControllerLayout c;
    public RelativeLayout d;
    public ImageView e;
    public ImageView f;
    public ImageView g;
    public ImageView h;
    public dr4 i;
    public PreviewViewContainer j;
    public vr8 k;
    public TextView l;
    public VideoEffectButtonLayout m;
    public View n;
    public TextView o;
    public View p;
    public RoundProgressBar q;
    public TextView r;
    public AnimatorSet s;
    public AnimatorSet t;
    public ScaleAnimation u;
    public ObjectAnimator v;
    public ObjectAnimator w;
    public Context x;
    public int y;
    public int z;

    /* loaded from: classes4.dex */
    public class a implements ur8.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RecordVideoActivity a;

        public a(RecordVideoActivity recordVideoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recordVideoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = recordVideoActivity;
        }

        @Override // com.repackage.ur8.a
        public void a(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, str) == null) {
                this.a.b.m(1);
                this.a.l();
                if (z) {
                    if (this.a.B != null) {
                        if (this.a.L != null && !ListUtils.isEmpty(this.a.B.getChosedFiles()) && this.a.B.getChosedFiles().contains(this.a.L)) {
                            this.a.B.getChosedFiles().remove(this.a.L);
                        }
                    } else {
                        this.a.B = new WriteImagesInfo();
                    }
                    this.a.L = new ImageFileInfo();
                    this.a.L.setFilePath(str);
                    this.a.L.setContentUriStr(null);
                    this.a.L.setTempFile(true);
                    this.a.L.setAlbumnId(null);
                    this.a.L.setIsFromCamera(true);
                    this.a.B.addChooseFile(this.a.L);
                    if (this.a.getIntent().getIntExtra("from_type", 0) == 2) {
                        Intent intent = new Intent();
                        intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.a.B.toJsonString());
                        this.a.setResult(-1, intent);
                        this.a.finish();
                        ActivityPendingTransitionFactory.closeAnimation(this.a.getPageContext(), 0);
                        return;
                    }
                    WriteMulitImageActivityConfig writeMulitImageActivityConfig = new WriteMulitImageActivityConfig(this.a.getPageContext().getPageActivity(), 12012, this.a.B, this.a.B.size() - 1, this.a.A, this.a.y);
                    writeMulitImageActivityConfig.getIntent().putExtras(this.a.getIntent());
                    this.a.sendMessage(new CustomMessage(2002001, writeMulitImageActivityConfig));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends as8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RecordVideoActivity b;

        public b(RecordVideoActivity recordVideoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recordVideoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = recordVideoActivity;
        }

        @Override // com.repackage.as8, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, animator) == null) || this.a) {
                return;
            }
            this.b.J.setVisibility(8);
        }
    }

    /* loaded from: classes4.dex */
    public class c extends BdAsyncTask<Void, Void, mr8> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public Handler b;
        public final /* synthetic */ RecordVideoActivity c;

        /* loaded from: classes4.dex */
        public class a extends Handler {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(c cVar, Looper looper) {
                super(looper);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, looper};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        super((Looper) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = cVar;
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                c cVar;
                int i;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 1 && (i = (cVar = this.a).a) >= 0) {
                    cVar.a = (i + 5) % 100;
                    cVar.c.q.b(this.a.a);
                    this.a.d();
                }
            }
        }

        public c(RecordVideoActivity recordVideoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recordVideoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = recordVideoActivity;
            this.b = new a(this, Looper.getMainLooper());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public mr8 doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                d();
                xr8 xr8Var = this.c.I;
                boolean z = xr8Var == null || TextUtils.isEmpty(xr8Var.h()) || !new File(this.c.I.h()).exists();
                if (this.c.k.q.size() > 1) {
                    lr8 e = lr8.e();
                    vr8 vr8Var = this.c.k;
                    return e.i(vr8Var.q, vr8Var.g(), z);
                }
                File file = new File(this.c.k.q.get(0));
                if (file.exists()) {
                    if (z) {
                        try {
                            FileHelper.copyFileByAbsolutelyPath(file.getPath(), this.c.k.g());
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                        return new mr8(0, "");
                    }
                    lr8 e3 = lr8.e();
                    vr8 vr8Var2 = this.c.k;
                    return e3.i(vr8Var2.q, vr8Var2.g(), z);
                }
                return null;
            }
            return (mr8) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(mr8 mr8Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mr8Var) == null) {
                this.a = -1;
                this.c.mHandler.removeMessages(1);
                this.c.c.v();
                if (mr8Var != null && mr8Var.a == 0) {
                    this.c.a2();
                    this.c.g2(102);
                    this.c.p.setVisibility(8);
                    return;
                }
                RecordVideoActivity recordVideoActivity = this.c;
                pi.O(recordVideoActivity, recordVideoActivity.getString(R.string.obfuscated_res_0x7f0f0ab9));
                this.c.p.setVisibility(8);
                if (mr8Var != null) {
                    this.c.h2(mr8Var.a, mr8Var.b);
                }
                this.c.q.b(0.0f);
            }
        }

        public void d() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.a < 0) {
                return;
            }
            this.b.sendEmptyMessageDelayed(1, 50L);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RecordVideoActivity a;

        public d(RecordVideoActivity recordVideoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recordVideoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = recordVideoActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.o.setVisibility(8);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RecordVideoActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(RecordVideoActivity recordVideoActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recordVideoActivity, Integer.valueOf(i)};
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
            this.a = recordVideoActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                this.a.finish();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RecordVideoActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(RecordVideoActivity recordVideoActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recordVideoActivity, Integer.valueOf(i)};
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
            this.a = recordVideoActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            this.a.finish();
        }
    }

    /* loaded from: classes4.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RecordVideoActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(RecordVideoActivity recordVideoActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recordVideoActivity, Integer.valueOf(i)};
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
            this.a = recordVideoActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.a.finish();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements br8.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RecordVideoActivity a;

        public h(RecordVideoActivity recordVideoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recordVideoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = recordVideoActivity;
        }

        @Override // com.repackage.br8.a
        public void a(List<cr8> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
                if (ListUtils.isEmpty(list)) {
                    if (this.a.c != null) {
                        this.a.c.setHasLocalVideo(false);
                    }
                } else if (this.a.c != null) {
                    this.a.c.setHasLocalVideo(true);
                    this.a.E = false;
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RecordVideoActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(RecordVideoActivity recordVideoActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recordVideoActivity, Integer.valueOf(i)};
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
            this.a = recordVideoActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && (httpResponsedMessage instanceof ResponseGetStickersMessage)) {
                List<StickerItem> stickerItems = httpResponsedMessage.getError() == 0 ? ((ResponseGetStickersMessage) httpResponsedMessage).getStickerItems() : null;
                if (this.a.c != null) {
                    StickerItem stickerItem = new StickerItem();
                    stickerItem.id = -1;
                    stickerItem.isSelect = true;
                    stickerItem.name = "nosticker";
                    if (stickerItems == null) {
                        stickerItems = new ArrayList<>();
                    }
                    stickerItems.add(0, stickerItem);
                    this.a.c.setStickerItems(stickerItems);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j implements vr8.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RecordVideoActivity a;

        public j(RecordVideoActivity recordVideoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recordVideoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = recordVideoActivity;
        }

        @Override // com.repackage.vr8.k
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.c.p()) {
                this.a.c.m(null);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k implements zr8.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RecordVideoActivity a;

        public k(RecordVideoActivity recordVideoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recordVideoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = recordVideoActivity;
        }

        @Override // com.repackage.zr8.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (this.a.c != null) {
                    StickerItem stickerItem = new StickerItem();
                    stickerItem.id = -1;
                    this.a.c.y(stickerItem);
                    vr8 vr8Var = this.a.k;
                    if (vr8Var != null) {
                        vr8Var.H(null);
                    }
                }
                if (this.a.c != null) {
                    this.a.c.setDownLoadSticker(null);
                }
                if (StringUtils.isNull(str)) {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f11b8);
                } else {
                    this.a.showToast(str);
                }
                RecordVideoActivity recordVideoActivity = this.a;
                if (StringUtils.isNull(str)) {
                    str = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f11b8);
                }
                recordVideoActivity.h2(5, str);
            }
        }

        @Override // com.repackage.zr8.b
        public void b() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.a.c == null) {
                return;
            }
            this.a.c.setDownLoadSticker(null);
        }

        @Override // com.repackage.zr8.b
        public void c(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
                RecordVideoActivity recordVideoActivity = this.a;
                recordVideoActivity.j2(recordVideoActivity.G, str2);
                if (this.a.c != null) {
                    this.a.c.setDownLoadSticker(null);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class l implements dr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RecordVideoActivity a;

        public l(RecordVideoActivity recordVideoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recordVideoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = recordVideoActivity;
        }

        @Override // com.repackage.dr4.e
        public void onClick(dr4 dr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dr4Var) == null) {
                dr4Var.dismiss();
                this.a.finish();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class m implements dr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RecordVideoActivity a;

        public m(RecordVideoActivity recordVideoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recordVideoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = recordVideoActivity;
        }

        @Override // com.repackage.dr4.e
        public void onClick(dr4 dr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dr4Var) == null) {
                dr4Var.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class n implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AtomicInteger a;
        public final /* synthetic */ RecordVideoActivity b;

        public n(RecordVideoActivity recordVideoActivity, AtomicInteger atomicInteger) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recordVideoActivity, atomicInteger};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = recordVideoActivity;
            this.a = atomicInteger;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.b.l.setVisibility(8);
                if (this.b.b.f() == 6) {
                    this.b.c.t();
                }
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) && this.b.b.f() == 6) {
                if (this.a.decrementAndGet() > 1) {
                    this.b.l.setText(String.valueOf(this.a.get() / 2));
                } else {
                    this.b.l.setText("");
                }
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) && this.b.b.f() == 6) {
                this.a.set(7);
                this.b.l.setVisibility(0);
                this.b.l.setText(String.valueOf(this.a.get() / 2));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class o extends as8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RecordVideoActivity b;

        public o(RecordVideoActivity recordVideoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recordVideoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = recordVideoActivity;
        }

        @Override // com.repackage.as8, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, animator) == null) || this.a) {
                return;
            }
            this.b.d.setVisibility(8);
            this.b.m.setVisibility(8);
            this.b.J.setVisibility(8);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(441813758, "Lcom/baidu/tieba/video/record/RecordVideoActivity;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(441813758, "Lcom/baidu/tieba/video/record/RecordVideoActivity;");
                return;
            }
        }
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_STICKERS, TbConfig.SERVER_ADDRESS + TbConfig.GET_STICKERS);
        tbHttpMessageTask.setResponsedClass(ResponseGetStickersMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public RecordVideoActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.E = true;
        this.N = new g(this, 2921583);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, ol7.class);
        ol7 ol7Var = runTask != null ? (ol7) runTask.getData() : null;
        if (ol7Var != null) {
            this.M = ol7Var.get();
        }
        kl7 kl7Var = this.M;
        if (kl7Var != null) {
            kl7Var.g();
        }
        this.O = new h(this);
        this.P = new i(this, CmdConfigHttp.CMD_GET_STICKERS);
        this.S = new e(this, 2001374);
        this.T = new f(this, 2001373);
    }

    @Override // com.baidu.tieba.video.record.GLVideoPreviewView.b
    public void D0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            wr8 wr8Var = this.b;
            if (wr8Var != null && (wr8Var.f() == 1 || this.b.f() == 3 || this.b.f() == 4)) {
                if (!z && this.R) {
                    this.j.b();
                    return;
                } else {
                    this.j.a();
                    return;
                }
            }
            this.j.a();
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void F0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.b.f() == 1 && !this.c.p()) {
            y(2, true);
            this.J.setCurrentTab(2, true);
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void G0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.b.f() == 1) {
            this.r.setVisibility(4);
            if (this.b.f() == 6) {
                return;
            }
            this.c.G0();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.f
    public void J0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.r.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.f
    public void S() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.b.f() == 1) {
            this.J.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void V0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.r.setVisibility(4);
            if (this.b.f() == 6) {
                return;
            }
            this.c.V0();
        }
    }

    public final void V1(int i2) {
        RecordTabLayout recordTabLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048582, this, i2) == null) || (recordTabLayout = this.J) == null) {
            return;
        }
        if (i2 == 0) {
            recordTabLayout.d(1, getString(R.string.obfuscated_res_0x7f0f1316));
            this.J.d(2, getString(R.string.obfuscated_res_0x7f0f1317));
            this.J.setListener(this);
            this.J.setCurrentTab(2, false);
            y(2, false);
        } else if (i2 == 1) {
            recordTabLayout.d(1, getString(R.string.obfuscated_res_0x7f0f1316));
            this.J.setShowIndicator(false);
            this.J.setCurrentTab(1, false);
            y(1, false);
        } else {
            recordTabLayout.d(2, getString(R.string.obfuscated_res_0x7f0f1317));
            this.J.setShowIndicator(false);
            this.J.setCurrentTab(2, false);
            y(2, false);
        }
    }

    public List<String> W1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            ArrayList arrayList = new ArrayList();
            VideoControllerLayout videoControllerLayout = this.c;
            if (videoControllerLayout != null && !ListUtils.isEmpty(videoControllerLayout.getChoosedBeautyList())) {
                for (sr8 sr8Var : this.c.getChoosedBeautyList()) {
                    if (sr8Var != null) {
                        String b2 = sr8Var.b();
                        if (!TextUtils.isEmpty(b2)) {
                            if (b2.equals("Normal")) {
                                b2 = "0";
                            }
                            arrayList.add(b2);
                        }
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.repackage.vr8.l
    public void X(int i2, int i3) {
        int dimensionPixelOffset;
        int i4;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3) == null) || (dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f0702a4)) <= 0 || i3 <= 0 || (i4 = (pi.r(this).heightPixels - i3) - dimensionPixelOffset) <= 0) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.c.getLayoutParams();
        layoutParams.height = dimensionPixelOffset + i4;
        this.c.setLayoutParams(layoutParams);
    }

    public List<String> X1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            ArrayList arrayList = new ArrayList();
            VideoControllerLayout videoControllerLayout = this.c;
            if (videoControllerLayout != null && !ListUtils.isEmpty(videoControllerLayout.getChoosedFilterList())) {
                for (sr8 sr8Var : this.c.getChoosedFilterList()) {
                    if (sr8Var != null) {
                        String str = (String) sr8Var.c();
                        if (!TextUtils.isEmpty(str)) {
                            arrayList.add(str);
                        }
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public List<String> Y1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            ArrayList arrayList = new ArrayList();
            VideoControllerLayout videoControllerLayout = this.c;
            if (videoControllerLayout != null && !ListUtils.isEmpty(videoControllerLayout.getChoosedStickerList())) {
                for (StickerItem stickerItem : this.c.getChoosedStickerList()) {
                    if (stickerItem != null) {
                        arrayList.add(String.valueOf(stickerItem.id));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.f
    public void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.u.cancel();
            this.u.setAnimationListener(null);
            this.l.clearAnimation();
            this.l.setVisibility(8);
            xr8 xr8Var = this.I;
            if (xr8Var != null) {
                xr8Var.m();
            }
        }
    }

    public FrameLayout Z1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.j : (FrameLayout) invokeV.objValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v11, types: [com.baidu.tbadk.core.data.PostPrefixData] */
    public final void a2() {
        PostPrefixData postPrefixData;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            VideoInfo videoInfo = new VideoInfo();
            videoInfo.setVideoPath(this.k.r);
            videoInfo.setVideoDuration(this.b.g() / 1000);
            videoInfo.setVideoWidth(720);
            videoInfo.setVideoHeight(960);
            videoInfo.setVideoLength(new File(this.k.r).length());
            videoInfo.setVideoSource(1);
            videoInfo.setIsCompressedVideo(false);
            videoInfo.setBeautifyListInfo(W1());
            videoInfo.setFilterListInfo(X1());
            videoInfo.setStickListInfo(Y1());
            ForumWriteData forumWriteData = this.A;
            String str2 = "";
            String str3 = forumWriteData == null ? "" : forumWriteData.forumName;
            ForumWriteData forumWriteData2 = this.A;
            String str4 = forumWriteData2 == null ? "" : forumWriteData2.forumId;
            ForumWriteData forumWriteData3 = this.A;
            int i2 = forumWriteData3 == null ? -1 : forumWriteData3.defaultZone;
            EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this, this.A.writeCallFrom, str3, str4, this.C, videoInfo);
            editVideoActivityConfig.addFromType(EditVideoActivityConfig.FROM_TYPE_RECORD_VIDEO_ACTIVITY);
            editVideoActivityConfig.addRequestForResult(25036);
            editVideoActivityConfig.setProZone(i2);
            editVideoActivityConfig.setStatisticFrom(this.A.statisticFrom);
            ForumWriteData forumWriteData4 = this.A;
            editVideoActivityConfig.setFrsTabInfo(forumWriteData4 != null ? forumWriteData4.frsTabInfo : null);
            ForumWriteData forumWriteData5 = this.A;
            editVideoActivityConfig.setForumLevel(forumWriteData5 != null ? forumWriteData5.forumLevel : -1);
            if (getIntent() != null) {
                Serializable serializableExtra = getIntent().getSerializableExtra("anti_data");
                AntiData antiData = serializableExtra instanceof AntiData ? (AntiData) serializableExtra : null;
                Serializable serializableExtra2 = getIntent().getSerializableExtra("prefix_data");
                r1 = serializableExtra2 instanceof PostPrefixData ? (PostPrefixData) serializableExtra2 : null;
                str2 = getIntent().getStringExtra(IntentConfig.FORUM_FIRST_DIR);
                str = getIntent().getStringExtra(IntentConfig.FORUM_SECOND_DIR);
                AntiData antiData2 = r1;
                r1 = antiData;
                postPrefixData = antiData2;
            } else {
                postPrefixData = null;
                str = "";
            }
            editVideoActivityConfig.setExtraData(r1, postPrefixData, str2, str);
            editVideoActivityConfig.setFrom(this.A.mFrom);
            xr8 xr8Var = this.I;
            if (xr8Var != null) {
                xr8Var.g(editVideoActivityConfig);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, editVideoActivityConfig));
            kl7 kl7Var = this.M;
            if (kl7Var != null) {
                kl7Var.d();
            }
        }
    }

    public final void b2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            ObjectAnimator objectAnimator = this.v;
            if (objectAnimator != null) {
                objectAnimator.cancel();
            }
            if (this.w == null) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.J, "alpha", 1.0f, 0.0f);
                this.w = ofFloat;
                ofFloat.setDuration(500L);
                this.w.addListener(new b(this));
            }
            this.w.start();
        }
    }

    public final void c2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            RecordLayout recordLayout = (RecordLayout) findViewById(R.id.obfuscated_res_0x7f091b44);
            this.a = recordLayout;
            recordLayout.setListener(this);
            this.b = new wr8(this);
            VideoControllerLayout videoControllerLayout = (VideoControllerLayout) findViewById(R.id.obfuscated_res_0x7f091a88);
            this.c = videoControllerLayout;
            videoControllerLayout.setRecordController(this.b);
            this.c.setRecordControlListener(this);
            this.c.setEffectChoosedListener(this);
            this.d = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f09213d);
            ImageView imageView = (ImageView) findViewById(R.id.obfuscated_res_0x7f090634);
            this.e = imageView;
            imageView.setOnClickListener(this);
            ImageView imageView2 = (ImageView) findViewById(R.id.obfuscated_res_0x7f090997);
            this.f = imageView2;
            imageView2.setOnClickListener(this);
            ImageView imageView3 = (ImageView) findViewById(R.id.obfuscated_res_0x7f09046b);
            this.g = imageView3;
            imageView3.setOnClickListener(this);
            ImageView imageView4 = (ImageView) findViewById(R.id.obfuscated_res_0x7f0906d1);
            this.h = imageView4;
            imageView4.setOnClickListener(this);
            this.j = (PreviewViewContainer) findViewById(R.id.obfuscated_res_0x7f0923e2);
            vr8 vr8Var = new vr8(this);
            this.k = vr8Var;
            vr8Var.I(this);
            this.k.D(this);
            this.k.F(new j(this));
            VideoEffectButtonLayout videoEffectButtonLayout = (VideoEffectButtonLayout) findViewById(R.id.obfuscated_res_0x7f091210);
            this.m = videoEffectButtonLayout;
            videoEffectButtonLayout.setListener(this);
            this.b.c(this.m);
            this.m.setViewChoosed(2, true);
            this.l = (TextView) findViewById(R.id.obfuscated_res_0x7f09221f);
            this.o = (TextView) findViewById(R.id.obfuscated_res_0x7f090c3c);
            int i2 = ((pi.i(this.x) - pi.f(this.x, R.dimen.obfuscated_res_0x7f0702a4)) / 2) - pi.f(this.x, R.dimen.obfuscated_res_0x7f07024d);
            if (this.l.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.l.getLayoutParams()).topMargin = i2;
            }
            if (Build.VERSION.SDK_INT < 18) {
                this.m.setVisibility(8);
            }
            View findViewById = findViewById(R.id.obfuscated_res_0x7f0919ab);
            this.p = findViewById;
            this.q = (RoundProgressBar) findViewById.findViewById(R.id.obfuscated_res_0x7f0923d8);
            TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f091463);
            this.r = textView;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) textView.getLayoutParams();
            layoutParams.leftMargin = ((int) (pi.k(this.x) * 0.2d)) - pi.f(this.x, R.dimen.obfuscated_res_0x7f07021d);
            this.r.setLayoutParams(layoutParams);
            this.J = (RecordTabLayout) findViewById(R.id.obfuscated_res_0x7f091ecd);
            WriteImagesInfo writeImagesInfo = this.B;
            if (writeImagesInfo != null && !ListUtils.isEmpty(writeImagesInfo.getChosedFiles())) {
                V1(1);
            } else {
                V1(this.z);
            }
            l2();
        }
    }

    public final void d2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            br8 br8Var = new br8(this);
            br8Var.d(this.O);
            br8Var.execute(new Void[0]);
        }
    }

    public final void e2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_STICKERS);
            httpMessage.addParam(Config.PACKAGE_NAME, 1);
            httpMessage.addParam("rn", 999);
            sendMessage(httpMessage);
        }
    }

    public void f2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.r.setVisibility(4);
            if (this.b.f() == 6) {
                return;
            }
            this.b.m(6);
            q();
            AtomicInteger atomicInteger = new AtomicInteger();
            if (this.u == null) {
                ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
                this.u = scaleAnimation;
                scaleAnimation.setDuration(500L);
                this.u.setRepeatCount(5);
                this.u.setRepeatMode(2);
                this.u.setInterpolator(new DecelerateInterpolator(2.0f));
            }
            this.u.setAnimationListener(new n(this, atomicInteger));
            this.l.setAnimation(this.u);
            this.u.startNow();
            this.c.s();
            xr8 xr8Var = this.I;
            if (xr8Var != null) {
                xr8Var.o();
            }
        }
    }

    public final void g2(int i2) {
        kl7 kl7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048595, this, i2) == null) || (kl7Var = this.M) == null) {
            return;
        }
        kl7Var.i(i2, "record");
    }

    public final void h2(int i2, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048596, this, i2, str) == null) || this.M == null) {
            return;
        }
        if (StringUtils.isNull(str)) {
            str = "";
        }
        this.M.b(i2, str);
    }

    public final void i2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            if (this.k.m()) {
                this.f.setVisibility(8);
            } else {
                this.f.setVisibility(0);
            }
            if (this.k.l()) {
                this.f.setImageResource(R.drawable.obfuscated_res_0x7f080ad8);
            } else {
                this.f.setImageResource(R.drawable.obfuscated_res_0x7f080ad7);
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectLayout.h
    public void j1(sr8 sr8Var, Object obj) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048598, this, sr8Var, obj) == null) || this.k == null || sr8Var == null) {
            return;
        }
        int type = sr8Var.getType();
        if (type == 1) {
            if (sr8Var.c() instanceof wp8) {
                this.k.B((wp8) sr8Var.c());
                TiebaStatic.log(new StatisticItem("c12421").param("obj_id", ((wp8) sr8Var.c()).a));
                if (((wp8) sr8Var.c()).a == 0) {
                    this.m.setViewChoosed(2, false);
                } else {
                    this.m.setViewChoosed(2, true);
                }
            }
        } else if (type != 2) {
            if (type == 3 && (sr8Var.c() instanceof MusicData)) {
                this.I.k((MusicData) sr8Var.c(), obj);
                if (((MusicData) sr8Var.c()).editMusicType == 1) {
                    this.m.setViewChoosed(0, false);
                } else {
                    this.m.setViewChoosed(0, true);
                }
            }
        } else if (sr8Var.c() instanceof String) {
            this.k.E((String) sr8Var.c());
            StatisticItem statisticItem = new StatisticItem("c12496");
            statisticItem.param("obj_id", (String) sr8Var.c());
            if (this.b.f() == 1) {
                statisticItem.param("obj_type", 1);
            } else {
                statisticItem.param("obj_type", 2);
            }
            if (sr8Var.c().equals("origin")) {
                this.m.setViewChoosed(3, false);
            } else {
                this.m.setViewChoosed(3, true);
            }
        }
    }

    public final void j2(StickerItem stickerItem, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048599, this, stickerItem, str) == null) || stickerItem == null || StringUtils.isNull(str)) {
            return;
        }
        stickerItem.localPath = str;
        vr8 vr8Var = this.k;
        if (vr8Var != null) {
            vr8Var.H(stickerItem);
            this.R = true;
        }
        if (!StringUtils.isNull(stickerItem.desc)) {
            this.o.setText(stickerItem.desc);
            this.o.setVisibility(0);
            this.o.postDelayed(new d(this), 3000L);
            return;
        }
        this.o.setVisibility(8);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.f
    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            b2();
        }
    }

    public final void k2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            ObjectAnimator objectAnimator = this.w;
            if (objectAnimator != null) {
                objectAnimator.cancel();
            }
            if (this.v == null) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.J, "alpha", 0.0f, 1.0f);
                this.v = ofFloat;
                ofFloat.setDuration(500L);
            }
            this.J.setVisibility(0);
            this.v.start();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.f
    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            if (this.K == 2) {
                if (!this.D) {
                    return;
                }
                this.D = false;
                xr8 xr8Var = this.I;
                if (xr8Var != null) {
                    xr8Var.o();
                }
            }
            AnimatorSet animatorSet = this.s;
            if (animatorSet != null && animatorSet.isRunning()) {
                this.s.cancel();
            }
            if (this.t == null) {
                AnimatorSet animatorSet2 = new AnimatorSet();
                this.t = animatorSet2;
                animatorSet2.playTogether(ObjectAnimator.ofFloat(this.d, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.m, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.J, "alpha", 0.0f, 1.0f));
                this.t.setDuration(300L);
            }
            this.d.setVisibility(0);
            if (Build.VERSION.SDK_INT >= 18) {
                this.m.setVisibility(0);
            }
            if (this.b.f() == 1) {
                this.J.setVisibility(0);
            }
            this.t.start();
        }
    }

    public final void l2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048603, this) == null) && DeviceInfoUtil.isfullScreen()) {
            View findViewById = findViewById(R.id.obfuscated_res_0x7f091e3f);
            this.n = findViewById;
            ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight();
            this.n.setLayoutParams(layoutParams);
            this.n.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.f
    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            this.r.setVisibility(4);
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void n0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            this.r.setVisibility(4);
            if (this.b.f() == 6) {
                return;
            }
            this.c.n0();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.f
    public void o() {
        vr8 vr8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048606, this) == null) || (vr8Var = this.k) == null) {
            return;
        }
        vr8Var.N(new a(this));
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048607, this, i2, i3, intent) == null) {
            if (intent == null || i2 != 25032) {
                if (i2 == 12012 && i3 == -1) {
                    Intent intent2 = new Intent();
                    if (intent != null) {
                        intent2.putExtra(AlbumActivityConfig.ALBUM_RESULT, intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT));
                        if (!StringUtils.isNull(intent.getStringExtra("file_name"))) {
                            intent2.putExtra("file_name", intent.getStringExtra("file_name"));
                        }
                    }
                    setResult(-1, intent2);
                    finish();
                    ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
                    return;
                }
                return;
            }
            String stringExtra = intent.getStringExtra(CloudMusicActivityConfig.MUSIC_RESOURCE);
            String stringExtra2 = intent.getStringExtra(CloudMusicActivityConfig.MUSIC_ID);
            if (TextUtils.isEmpty(stringExtra) || TextUtils.isEmpty(stringExtra2)) {
                return;
            }
            String f2 = sq8.g().f(stringExtra);
            if (this.I == null || TextUtils.isEmpty(f2)) {
                return;
            }
            this.I.j(f2, stringExtra2);
            this.c.x();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            wr8 wr8Var = this.b;
            if (wr8Var == null || wr8Var.f() != 7) {
                wr8 wr8Var2 = this.b;
                if (wr8Var2 != null && wr8Var2.f() == 6) {
                    VideoControllerLayout videoControllerLayout = this.c;
                    if (videoControllerLayout != null) {
                        videoControllerLayout.C();
                    }
                    Z();
                    return;
                }
                wr8 wr8Var3 = this.b;
                if (wr8Var3 != null && wr8Var3.k()) {
                    finish();
                    return;
                }
                if (this.i == null) {
                    dr4 dr4Var = new dr4(getPageContext().getPageActivity());
                    this.i = dr4Var;
                    dr4Var.setMessageId(R.string.obfuscated_res_0x7f0f14e3);
                    this.i.setPositiveButton(R.string.obfuscated_res_0x7f0f04e1, new l(this));
                    this.i.setNegativeButton(R.string.obfuscated_res_0x7f0f04dc, new m(this));
                    this.i.setCancelable(true);
                    this.i.create(getPageContext());
                }
                this.i.show();
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, view2) == null) {
            this.r.setVisibility(4);
            if (view2 == this.e) {
                onBackPressed();
            } else if (view2 == this.f) {
                if (this.b.f() == 1) {
                    TiebaStatic.log("c12294");
                } else {
                    TiebaStatic.log("c12301");
                }
                this.k.i();
                i2();
            } else if (view2 == this.g) {
                if (this.b.f() == 1) {
                    TiebaStatic.log("c12295");
                } else {
                    TiebaStatic.log("c12302");
                }
                this.g.setOnClickListener(null);
                this.k.f();
                if (this.k.m() && this.k.l()) {
                    this.k.i();
                }
                i2();
                this.g.setOnClickListener(this);
            } else if (view2 == this.h) {
                f2();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, bundle) == null) {
            TiebaStatic.log("c12293");
            this.x = getPageContext().getPageActivity();
            setIsAddSwipeBackLayout(false);
            requestWindowFeature(1);
            getWindow().setFlags(1024, 1024);
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d0738);
            this.y = getIntent().getIntExtra(RecordVideoActivityConfig.ENTRANCE_FLAG, 0);
            this.z = getIntent().getIntExtra(RecordVideoActivityConfig.SHOW_TYPE, 0);
            if (getIntent().getSerializableExtra(RecordVideoActivityConfig.FORUM_WRITE_DATA) instanceof ForumWriteData) {
                this.A = (ForumWriteData) getIntent().getSerializableExtra(RecordVideoActivityConfig.FORUM_WRITE_DATA);
            }
            if (getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO) instanceof WriteImagesInfo) {
                this.B = (WriteImagesInfo) getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO);
            }
            this.C = getIntent().getStringExtra("video_title");
            c2();
            SelectMusicModel selectMusicModel = new SelectMusicModel(getPageContext(), this.c);
            this.H = selectMusicModel;
            selectMusicModel.B();
            xr8 xr8Var = new xr8(this);
            this.I = xr8Var;
            xr8Var.t(this.H);
            this.b.c(this.I);
            registerListener(this.P);
            registerListener(this.S);
            registerListener(this.T);
            registerListener(this.N);
            e2();
            if (Build.VERSION.SDK_INT >= 28 && RomTypeUtil.isOPPO() && TbSingleton.getInstance().isCutoutScreen(this)) {
                lp8.b(1, getWindow().getAttributes(), getWindow());
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            super.onDestroy();
            wr8 wr8Var = this.b;
            if (wr8Var != null && wr8Var.j()) {
                this.b.o();
            }
            SelectMusicModel selectMusicModel = this.H;
            if (selectMusicModel != null) {
                selectMusicModel.cancelLoadData();
            }
            kl7 kl7Var = this.M;
            if (kl7Var != null) {
                kl7Var.k("record");
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            super.onPause();
            this.k.u();
            if (this.c != null) {
                wr8 wr8Var = this.b;
                if (wr8Var != null && wr8Var.f() == 6) {
                    this.c.C();
                    Z();
                }
                wr8 wr8Var2 = this.b;
                if (wr8Var2 != null && wr8Var2.j()) {
                    this.c.C();
                }
            }
            xr8 xr8Var = this.I;
            if (xr8Var != null) {
                xr8Var.l();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRestart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            super.onRestart();
            if (this.b.f() == 8) {
                this.c.E();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            super.onResume();
            this.k.v();
            qr8 k2 = this.k.k();
            this.Q = k2;
            if (k2 != null) {
                k2.c(this.b);
                this.j.setZoomHelper(this.Q);
            }
            i2();
            if (this.F == null) {
                zr8 zr8Var = new zr8();
                this.F = zr8Var;
                zr8Var.k(new k(this));
            }
            this.F.e();
            if (this.c != null && this.E) {
                d2();
            }
            kl7 kl7Var = this.M;
            if (kl7Var != null) {
                kl7Var.e("album");
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            super.onStart();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            super.onStop();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.f
    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            this.D = true;
            AnimatorSet animatorSet = this.t;
            if (animatorSet != null && animatorSet.isRunning()) {
                this.t.cancel();
            }
            if (this.s == null) {
                AnimatorSet animatorSet2 = new AnimatorSet();
                this.s = animatorSet2;
                animatorSet2.playTogether(ObjectAnimator.ofFloat(this.d, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.m, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.J, "alpha", 1.0f, 0.0f));
                this.s.addListener(new o(this));
                this.s.setDuration(300L);
            }
            this.s.start();
            this.m.c();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.f
    public void t0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            this.m.c();
            if (this.b.f() == 1) {
                k2();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void u1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048619, this) == null) && this.b.f() == 1 && !this.c.p()) {
            y(1, true);
            this.J.setCurrentTab(1, true);
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            this.r.setVisibility(4);
            if (this.b.f() == 6) {
                return;
            }
            this.c.w();
            if (this.c.q()) {
                e2();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectLayout.h
    public void x1(StickerItem stickerItem) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048621, this, stickerItem) == null) || stickerItem == null) {
            return;
        }
        this.G = stickerItem;
        this.F.j(stickerItem.resource);
        if (stickerItem.id == -1) {
            vr8 vr8Var = this.k;
            if (vr8Var != null) {
                vr8Var.H(null);
                this.R = false;
            }
            VideoControllerLayout videoControllerLayout = this.c;
            if (videoControllerLayout != null) {
                videoControllerLayout.setDownLoadSticker(null);
            }
            this.o.setVisibility(8);
            this.m.setViewChoosed(1, false);
            return;
        }
        String g2 = this.F.g(stickerItem.resource);
        if (!StringUtils.isNull(g2)) {
            j2(stickerItem, g2);
            VideoControllerLayout videoControllerLayout2 = this.c;
            if (videoControllerLayout2 != null) {
                videoControllerLayout2.setDownLoadSticker(null);
            }
        } else {
            VideoControllerLayout videoControllerLayout3 = this.c;
            if (videoControllerLayout3 != null) {
                videoControllerLayout3.setDownLoadSticker(stickerItem);
            }
            this.F.f(stickerItem.resource);
        }
        this.m.setViewChoosed(1, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    @Override // com.baidu.tieba.video.record.RecordTabLayout.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void y(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048622, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || this.K == i2) {
            return;
        }
        int i3 = 2;
        if (i2 == 1) {
            xr8 xr8Var = this.I;
            if (xr8Var != null) {
                xr8Var.r();
            }
            this.k.E("origin");
            this.m.setViewChoosed(0, false);
            this.m.setViewChoosed(3, false);
            this.c.j(1);
            this.m.setViewVisibility(0, 8);
            this.m.setViewVisibility(3, 8);
        } else if (i2 == 2) {
            this.m.setViewVisibility(0, 0);
            this.m.setViewVisibility(3, 0);
            this.K = i2;
            this.c.setCurrentTab(i2);
            if (z) {
                return;
            }
            TiebaStatic.log(new StatisticItem().param("obj_type", i3));
            return;
        }
        i3 = 1;
        this.K = i2;
        this.c.setCurrentTab(i2);
        if (z) {
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.f
    public void z0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048623, this) == null) || this.p.getVisibility() == 0) {
            return;
        }
        this.c.D();
        this.b.m(8);
        l();
        List<String> list = this.k.q;
        if (list == null || list.size() <= 0) {
            return;
        }
        this.p.setVisibility(0);
        new c(this).execute(new Void[0]);
    }
}
