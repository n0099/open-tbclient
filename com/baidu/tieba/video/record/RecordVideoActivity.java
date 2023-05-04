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
import androidx.constraintlayout.motion.widget.Key;
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
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.BaseWriteConfig;
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
import com.baidu.tieba.aq8;
import com.baidu.tieba.c0a;
import com.baidu.tieba.e0a;
import com.baidu.tieba.ez9;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.frs.FrsTabInfoData;
import com.baidu.tieba.g0a;
import com.baidu.tieba.h0a;
import com.baidu.tieba.i0a;
import com.baidu.tieba.ii;
import com.baidu.tieba.iy9;
import com.baidu.tieba.j0a;
import com.baidu.tieba.l0a;
import com.baidu.tieba.m0a;
import com.baidu.tieba.nz9;
import com.baidu.tieba.oz9;
import com.baidu.tieba.qx9;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.u05;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.editvideo.model.SelectMusicModel;
import com.baidu.tieba.video.record.GLVideoPreviewView;
import com.baidu.tieba.video.record.RecordLayout;
import com.baidu.tieba.video.record.RecordTabLayout;
import com.baidu.tieba.video.record.VideoControllerLayout;
import com.baidu.tieba.video.record.VideoEffectButtonLayout;
import com.baidu.tieba.video.record.VideoEffectLayout;
import com.baidu.tieba.wp8;
import com.baidu.tieba.xz9;
import com.baidu.tieba.yz9;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes6.dex */
public class RecordVideoActivity extends BaseActivity implements VideoEffectButtonLayout.a, VideoControllerLayout.f, VideoEffectLayout.h, h0a.l, RecordTabLayout.c, RecordLayout.a, GLVideoPreviewView.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ForumWriteData A;
    public WriteImagesInfo B;
    public String C;
    public boolean D;
    public boolean E;
    public l0a F;
    public StickerItem G;
    public SelectMusicModel H;
    public j0a I;
    public RecordTabLayout J;
    public int K;
    public ImageFileInfo L;
    public wp8 M;
    public CustomMessageListener N;
    public nz9.a O;
    public HttpMessageListener P;
    public c0a Q;
    public boolean R;
    public final CustomMessageListener S;
    public final CustomMessageListener T;
    public RecordLayout a;
    public i0a b;
    public VideoControllerLayout c;
    public RelativeLayout d;
    public ImageView e;
    public ImageView f;
    public ImageView g;
    public ImageView h;
    public u05 i;
    public PreviewViewContainer j;
    public h0a k;
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

    /* loaded from: classes6.dex */
    public class c extends BdAsyncTask<Void, Void, yz9> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public Handler b;
        public final /* synthetic */ RecordVideoActivity c;

        /* loaded from: classes6.dex */
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
        public yz9 doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                d();
                j0a j0aVar = this.c.I;
                if (j0aVar != null && !TextUtils.isEmpty(j0aVar.h()) && new File(this.c.I.h()).exists()) {
                    z = false;
                } else {
                    z = true;
                }
                if (this.c.k.q.size() > 1) {
                    xz9 e = xz9.e();
                    h0a h0aVar = this.c.k;
                    return e.i(h0aVar.q, h0aVar.g(), z);
                }
                File file = new File(this.c.k.q.get(0));
                if (file.exists()) {
                    if (z) {
                        try {
                            FileHelper.copyFileByAbsolutelyPath(file.getPath(), this.c.k.g());
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                        return new yz9(0, "");
                    }
                    xz9 e3 = xz9.e();
                    h0a h0aVar2 = this.c.k;
                    return e3.i(h0aVar2.q, h0aVar2.g(), z);
                }
                return null;
            }
            return (yz9) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(yz9 yz9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, yz9Var) == null) {
                this.a = -1;
                this.c.mHandler.removeMessages(1);
                this.c.c.y();
                if (yz9Var == null || yz9Var.a != 0) {
                    RecordVideoActivity recordVideoActivity = this.c;
                    ii.Q(recordVideoActivity, recordVideoActivity.getString(R.string.obfuscated_res_0x7f0f0bbb));
                    this.c.p.setVisibility(8);
                    if (yz9Var != null) {
                        this.c.g2(yz9Var.a, yz9Var.b);
                    }
                    this.c.q.b(0.0f);
                    return;
                }
                this.c.Z1();
                this.c.f2(102);
                this.c.p.setVisibility(8);
            }
        }

        public void d() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.a >= 0) {
                this.b.sendEmptyMessageDelayed(1, 50L);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a implements g0a.a {
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

        @Override // com.baidu.tieba.g0a.a
        public void a(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, str) == null) {
                this.a.b.m(1);
                this.a.l();
                if (z) {
                    if (this.a.B == null) {
                        this.a.B = new WriteImagesInfo();
                    } else if (this.a.L != null && !ListUtils.isEmpty(this.a.B.getChosedFiles()) && this.a.B.getChosedFiles().contains(this.a.L)) {
                        this.a.B.getChosedFiles().remove(this.a.L);
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

    /* loaded from: classes6.dex */
    public class b extends m0a {
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

        @Override // com.baidu.tieba.m0a, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, animator) == null) && !this.a) {
                this.b.J.setVisibility(8);
            }
        }
    }

    /* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                return;
            }
            this.a.finish();
        }
    }

    /* loaded from: classes6.dex */
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null) {
                return;
            }
            this.a.finish();
        }
    }

    /* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
    public class h implements nz9.a {
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

        @Override // com.baidu.tieba.nz9.a
        public void a(List<oz9> list) {
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

    /* loaded from: classes6.dex */
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, httpResponsedMessage) != null) || !(httpResponsedMessage instanceof ResponseGetStickersMessage)) {
                return;
            }
            List<StickerItem> list = null;
            ResponseGetStickersMessage responseGetStickersMessage = (ResponseGetStickersMessage) httpResponsedMessage;
            if (httpResponsedMessage.getError() == 0) {
                list = responseGetStickersMessage.getStickerItems();
            }
            if (this.a.c != null) {
                StickerItem stickerItem = new StickerItem();
                stickerItem.id = -1;
                stickerItem.isSelect = true;
                stickerItem.name = "nosticker";
                if (list == null) {
                    list = new ArrayList<>();
                }
                list.add(0, stickerItem);
                this.a.c.setStickerItems(list);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j implements h0a.k {
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

        @Override // com.baidu.tieba.h0a.k
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.c.p()) {
                this.a.c.m(null);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class k implements l0a.b {
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

        @Override // com.baidu.tieba.l0a.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (this.a.c != null) {
                    StickerItem stickerItem = new StickerItem();
                    stickerItem.id = -1;
                    this.a.c.A(stickerItem);
                    h0a h0aVar = this.a.k;
                    if (h0aVar != null) {
                        h0aVar.H(null);
                    }
                }
                if (this.a.c != null) {
                    this.a.c.setDownLoadSticker(null);
                }
                if (StringUtils.isNull(str)) {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f12fa);
                } else {
                    this.a.showToast(str);
                }
                RecordVideoActivity recordVideoActivity = this.a;
                if (StringUtils.isNull(str)) {
                    str = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f12fa);
                }
                recordVideoActivity.g2(5, str);
            }
        }

        @Override // com.baidu.tieba.l0a.b
        public void b() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.a.c != null) {
                this.a.c.setDownLoadSticker(null);
            }
        }

        @Override // com.baidu.tieba.l0a.b
        public void c(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
                RecordVideoActivity recordVideoActivity = this.a;
                recordVideoActivity.i2(recordVideoActivity.G, str2);
                if (this.a.c != null) {
                    this.a.c.setDownLoadSticker(null);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class l implements u05.e {
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

        @Override // com.baidu.tieba.u05.e
        public void onClick(u05 u05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, u05Var) == null) {
                u05Var.dismiss();
                this.a.finish();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class m implements u05.e {
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

        @Override // com.baidu.tieba.u05.e
        public void onClick(u05 u05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, u05Var) == null) {
                u05Var.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
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
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) != null) || this.b.b.f() != 6) {
                return;
            }
            if (this.a.decrementAndGet() > 1) {
                this.b.l.setText(String.valueOf(this.a.get() / 2));
            } else {
                this.b.l.setText("");
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) != null) || this.b.b.f() != 6) {
                return;
            }
            this.a.set(7);
            this.b.l.setVisibility(0);
            this.b.l.setText(String.valueOf(this.a.get() / 2));
        }
    }

    /* loaded from: classes6.dex */
    public class o extends m0a {
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

        @Override // com.baidu.tieba.m0a, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, animator) == null) && !this.a) {
                this.b.d.setVisibility(8);
                this.b.m.setVisibility(8);
                this.b.J.setVisibility(8);
            }
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

    public List<String> V1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            ArrayList arrayList = new ArrayList();
            VideoControllerLayout videoControllerLayout = this.c;
            if (videoControllerLayout != null && !ListUtils.isEmpty(videoControllerLayout.getChoosedBeautyList())) {
                for (e0a e0aVar : this.c.getChoosedBeautyList()) {
                    if (e0aVar != null) {
                        String b2 = e0aVar.b();
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

    public List<String> W1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            ArrayList arrayList = new ArrayList();
            VideoControllerLayout videoControllerLayout = this.c;
            if (videoControllerLayout != null && !ListUtils.isEmpty(videoControllerLayout.getChoosedFilterList())) {
                for (e0a e0aVar : this.c.getChoosedFilterList()) {
                    if (e0aVar != null) {
                        String str = (String) e0aVar.c();
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

    public List<String> X1() {
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

    public final void a2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            ObjectAnimator objectAnimator = this.v;
            if (objectAnimator != null) {
                objectAnimator.cancel();
            }
            if (this.w == null) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.J, Key.ALPHA, 1.0f, 0.0f);
                this.w = ofFloat;
                ofFloat.setDuration(500L);
                this.w.addListener(new b(this));
            }
            this.w.start();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            super.onResume();
            this.k.v();
            c0a k2 = this.k.k();
            this.Q = k2;
            if (k2 != null) {
                k2.c(this.b);
                this.j.setZoomHelper(this.Q);
            }
            h2();
            if (this.F == null) {
                l0a l0aVar = new l0a();
                this.F = l0aVar;
                l0aVar.k(new k(this));
            }
            this.F.e();
            if (this.c != null && this.E) {
                c2();
            }
            wp8 wp8Var = this.M;
            if (wp8Var != null) {
                wp8Var.e("album");
            }
        }
    }

    public RecordVideoActivity() {
        aq8 aq8Var;
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
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, aq8.class);
        if (runTask != null) {
            aq8Var = (aq8) runTask.getData();
        } else {
            aq8Var = null;
        }
        if (aq8Var != null) {
            this.M = aq8Var.get();
        }
        wp8 wp8Var = this.M;
        if (wp8Var != null) {
            wp8Var.g();
        }
        this.O = new h(this);
        this.P = new i(this, CmdConfigHttp.CMD_GET_STICKERS);
        this.S = new e(this, 2001374);
        this.T = new f(this, 2001373);
    }

    public void e2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
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
            this.c.r();
            j0a j0aVar = this.I;
            if (j0aVar != null) {
                j0aVar.o();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            i0a i0aVar = this.b;
            if (i0aVar != null && i0aVar.f() == 7) {
                return;
            }
            i0a i0aVar2 = this.b;
            if (i0aVar2 != null && i0aVar2.f() == 6) {
                VideoControllerLayout videoControllerLayout = this.c;
                if (videoControllerLayout != null) {
                    videoControllerLayout.E();
                }
                R();
                return;
            }
            i0a i0aVar3 = this.b;
            if (i0aVar3 != null && i0aVar3.k()) {
                finish();
                return;
            }
            if (this.i == null) {
                u05 u05Var = new u05(getPageContext().getPageActivity());
                this.i = u05Var;
                u05Var.setMessageId(R.string.obfuscated_res_0x7f0f167e);
                this.i.setPositiveButton(R.string.obfuscated_res_0x7f0f052e, new l(this));
                this.i.setNegativeButton(R.string.obfuscated_res_0x7f0f0526, new m(this));
                this.i.setCancelable(true);
                this.i.create(getPageContext());
            }
            this.i.show();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.f
    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            this.D = true;
            AnimatorSet animatorSet = this.t;
            if (animatorSet != null && animatorSet.isRunning()) {
                this.t.cancel();
            }
            if (this.s == null) {
                AnimatorSet animatorSet2 = new AnimatorSet();
                this.s = animatorSet2;
                animatorSet2.playTogether(ObjectAnimator.ofFloat(this.d, Key.ALPHA, 1.0f, 0.0f), ObjectAnimator.ofFloat(this.m, Key.ALPHA, 1.0f, 0.0f), ObjectAnimator.ofFloat(this.J, Key.ALPHA, 1.0f, 0.0f));
                this.s.addListener(new o(this));
                this.s.setDuration(300L);
            }
            this.s.start();
            this.m.c();
        }
    }

    public final void g2(int i2, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048595, this, i2, str) == null) && this.M != null) {
            if (StringUtils.isNull(str)) {
                str = "";
            }
            this.M.b(i2, str);
        }
    }

    public final void f2(int i2) {
        wp8 wp8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048594, this, i2) == null) && (wp8Var = this.M) != null) {
            wp8Var.i(i2, "record");
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void A0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b.f() == 1 && !this.c.p()) {
            y(2, true);
            this.J.setCurrentTab(2, true);
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void B0() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || this.b.f() != 1) {
            return;
        }
        this.r.setVisibility(4);
        if (this.b.f() == 6) {
            return;
        }
        this.c.B0();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.f
    public void D0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.r.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.f
    public void N() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.b.f() == 1) {
            this.J.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.f
    public void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.u.cancel();
            this.u.setAnimationListener(null);
            this.l.clearAnimation();
            this.l.setVisibility(8);
            j0a j0aVar = this.I;
            if (j0aVar != null) {
                j0aVar.m();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void T0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.r.setVisibility(4);
            if (this.b.f() == 6) {
                return;
            }
            this.c.T0();
        }
    }

    public FrameLayout Y1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.j;
        }
        return (FrameLayout) invokeV.objValue;
    }

    public final void c2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            nz9 nz9Var = new nz9(this);
            nz9Var.d(this.O);
            nz9Var.execute(new Void[0]);
        }
    }

    public final void d2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_STICKERS);
            httpMessage.addParam("pn", 1);
            httpMessage.addParam("rn", 999);
            sendMessage(httpMessage);
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void h0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.r.setVisibility(4);
            if (this.b.f() == 6) {
                return;
            }
            this.c.h0();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.f
    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            a2();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.f
    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            this.r.setVisibility(4);
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.f
    public void o() {
        h0a h0aVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048605, this) != null) || (h0aVar = this.k) == null) {
            return;
        }
        h0aVar.N(new a(this));
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            super.onDestroy();
            i0a i0aVar = this.b;
            if (i0aVar != null && i0aVar.j()) {
                this.b.o();
            }
            SelectMusicModel selectMusicModel = this.H;
            if (selectMusicModel != null) {
                selectMusicModel.cancelLoadData();
            }
            wp8 wp8Var = this.M;
            if (wp8Var != null) {
                wp8Var.k("record");
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRestart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            super.onRestart();
            if (this.b.f() == 8) {
                this.c.G();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            super.onStart();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            super.onStop();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.f
    public void r0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            this.m.c();
            if (this.b.f() == 1) {
                j2();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void s1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048618, this) == null) && this.b.f() == 1 && !this.c.p()) {
            y(1, true);
            this.J.setCurrentTab(1, true);
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            this.r.setVisibility(4);
            if (this.b.f() == 6) {
                return;
            }
            this.c.u();
            if (this.c.q()) {
                d2();
            }
        }
    }

    @Override // com.baidu.tieba.h0a.l
    public void Q(int i2, int i3) {
        int dimensionPixelOffset;
        int i4;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeII(1048580, this, i2, i3) == null) && (dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f0702a5)) > 0 && i3 > 0 && (i4 = (ii.t(this).heightPixels - i3) - dimensionPixelOffset) > 0) {
            ViewGroup.LayoutParams layoutParams = this.c.getLayoutParams();
            layoutParams.height = dimensionPixelOffset + i4;
            this.c.setLayoutParams(layoutParams);
        }
    }

    public final void U1(int i2) {
        RecordTabLayout recordTabLayout;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048583, this, i2) != null) || (recordTabLayout = this.J) == null) {
            return;
        }
        if (i2 == 0) {
            recordTabLayout.d(1, getString(R.string.obfuscated_res_0x7f0f145e));
            this.J.d(2, getString(R.string.obfuscated_res_0x7f0f145f));
            this.J.setListener(this);
            this.J.setCurrentTab(2, false);
            y(2, false);
        } else if (i2 == 1) {
            recordTabLayout.d(1, getString(R.string.obfuscated_res_0x7f0f145e));
            this.J.setShowIndicator(false);
            this.J.setCurrentTab(1, false);
            y(1, false);
        } else {
            recordTabLayout.d(2, getString(R.string.obfuscated_res_0x7f0f145f));
            this.J.setShowIndicator(false);
            this.J.setCurrentTab(2, false);
            y(2, false);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, view2) == null) {
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
                h2();
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
                h2();
                this.g.setOnClickListener(this);
            } else if (view2 == this.h) {
                e2();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectLayout.h
    public void v1(StickerItem stickerItem) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048621, this, stickerItem) == null) && stickerItem != null) {
            this.G = stickerItem;
            this.F.j(stickerItem.resource);
            if (stickerItem.id == -1) {
                h0a h0aVar = this.k;
                if (h0aVar != null) {
                    h0aVar.H(null);
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
                i2(stickerItem, g2);
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
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v11, types: [com.baidu.tbadk.core.data.PostPrefixData] */
    public final void Z1() {
        String str;
        String str2;
        FrsTabInfoData frsTabInfoData;
        int i2;
        PostPrefixData postPrefixData;
        String str3;
        AntiData antiData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            VideoInfo videoInfo = new VideoInfo();
            videoInfo.setVideoPath(this.k.r);
            videoInfo.setVideoDuration(this.b.g() / 1000);
            videoInfo.setVideoWidth(720);
            videoInfo.setVideoHeight(960);
            videoInfo.setVideoLength(new File(this.k.r).length());
            videoInfo.setVideoSource(1);
            videoInfo.setIsCompressedVideo(false);
            videoInfo.setBeautifyListInfo(V1());
            videoInfo.setFilterListInfo(W1());
            videoInfo.setStickListInfo(X1());
            ForumWriteData forumWriteData = this.A;
            String str4 = "";
            if (forumWriteData == null) {
                str = "";
            } else {
                str = forumWriteData.forumName;
            }
            ForumWriteData forumWriteData2 = this.A;
            if (forumWriteData2 == null) {
                str2 = "";
            } else {
                str2 = forumWriteData2.forumId;
            }
            EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this, this.A.writeCallFrom, str, str2, this.C, videoInfo);
            editVideoActivityConfig.addFromType(EditVideoActivityConfig.FROM_TYPE_RECORD_VIDEO_ACTIVITY);
            editVideoActivityConfig.addRequestForResult(25036);
            editVideoActivityConfig.setStatisticFrom(this.A.statisticFrom);
            ForumWriteData forumWriteData3 = this.A;
            AntiData antiData2 = null;
            if (forumWriteData3 != null) {
                frsTabInfoData = forumWriteData3.frsTabInfo;
            } else {
                frsTabInfoData = null;
            }
            editVideoActivityConfig.setFrsTabInfo(frsTabInfoData);
            ForumWriteData forumWriteData4 = this.A;
            if (forumWriteData4 != null) {
                i2 = forumWriteData4.forumLevel;
            } else {
                i2 = -1;
            }
            editVideoActivityConfig.setForumLevel(i2);
            if (getIntent() != null) {
                Serializable serializableExtra = getIntent().getSerializableExtra("anti_data");
                if (serializableExtra instanceof AntiData) {
                    antiData = (AntiData) serializableExtra;
                } else {
                    antiData = null;
                }
                Serializable serializableExtra2 = getIntent().getSerializableExtra(BaseWriteConfig.PREFIX_DATA);
                if (serializableExtra2 instanceof PostPrefixData) {
                    antiData2 = (PostPrefixData) serializableExtra2;
                }
                str4 = getIntent().getStringExtra(IntentConfig.FORUM_FIRST_DIR);
                str3 = getIntent().getStringExtra(IntentConfig.FORUM_SECOND_DIR);
                AntiData antiData3 = antiData2;
                antiData2 = antiData;
                postPrefixData = antiData3;
            } else {
                postPrefixData = null;
                str3 = "";
            }
            editVideoActivityConfig.setExtraData(antiData2, postPrefixData, str4, str3);
            editVideoActivityConfig.setFrom(this.A.mFrom);
            j0a j0aVar = this.I;
            if (j0aVar != null) {
                j0aVar.g(editVideoActivityConfig);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, editVideoActivityConfig));
            wp8 wp8Var = this.M;
            if (wp8Var != null) {
                wp8Var.d();
            }
        }
    }

    public final void b2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            RecordLayout recordLayout = (RecordLayout) findViewById(R.id.root_layout);
            this.a = recordLayout;
            recordLayout.setListener(this);
            this.b = new i0a(this);
            VideoControllerLayout videoControllerLayout = (VideoControllerLayout) findViewById(R.id.obfuscated_res_0x7f091d53);
            this.c = videoControllerLayout;
            videoControllerLayout.setRecordController(this.b);
            this.c.setRecordControlListener(this);
            this.c.setEffectChoosedListener(this);
            this.d = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f092492);
            ImageView imageView = (ImageView) findViewById(R.id.obfuscated_res_0x7f090707);
            this.e = imageView;
            imageView.setOnClickListener(this);
            ImageView imageView2 = (ImageView) findViewById(R.id.obfuscated_res_0x7f090ae8);
            this.f = imageView2;
            imageView2.setOnClickListener(this);
            ImageView imageView3 = (ImageView) findViewById(R.id.obfuscated_res_0x7f09050c);
            this.g = imageView3;
            imageView3.setOnClickListener(this);
            ImageView imageView4 = (ImageView) findViewById(R.id.obfuscated_res_0x7f0907b2);
            this.h = imageView4;
            imageView4.setOnClickListener(this);
            this.j = (PreviewViewContainer) findViewById(R.id.obfuscated_res_0x7f09278b);
            h0a h0aVar = new h0a(this);
            this.k = h0aVar;
            h0aVar.I(this);
            this.k.D(this);
            this.k.F(new j(this));
            VideoEffectButtonLayout videoEffectButtonLayout = (VideoEffectButtonLayout) findViewById(R.id.obfuscated_res_0x7f091403);
            this.m = videoEffectButtonLayout;
            videoEffectButtonLayout.setListener(this);
            this.b.c(this.m);
            this.m.setViewChoosed(2, true);
            this.l = (TextView) findViewById(R.id.obfuscated_res_0x7f092586);
            this.o = (TextView) findViewById(R.id.obfuscated_res_0x7f090db4);
            int j2 = ((ii.j(this.x) - ii.g(this.x, R.dimen.obfuscated_res_0x7f0702a5)) / 2) - ii.g(this.x, R.dimen.obfuscated_res_0x7f07024e);
            if (this.l.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.l.getLayoutParams()).topMargin = j2;
            }
            if (Build.VERSION.SDK_INT < 18) {
                this.m.setVisibility(8);
            }
            View findViewById = findViewById(R.id.obfuscated_res_0x7f091c54);
            this.p = findViewById;
            this.q = (RoundProgressBar) findViewById.findViewById(R.id.obfuscated_res_0x7f092780);
            TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f0916bc);
            this.r = textView;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) textView.getLayoutParams();
            layoutParams.leftMargin = ((int) (ii.l(this.x) * 0.2d)) - ii.g(this.x, R.dimen.obfuscated_res_0x7f07021d);
            this.r.setLayoutParams(layoutParams);
            this.J = (RecordTabLayout) findViewById(R.id.obfuscated_res_0x7f092201);
            WriteImagesInfo writeImagesInfo = this.B;
            if (writeImagesInfo != null && !ListUtils.isEmpty(writeImagesInfo.getChosedFiles())) {
                U1(1);
            } else {
                U1(this.z);
            }
            k2();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectLayout.h
    public void h1(e0a e0aVar, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048597, this, e0aVar, obj) == null) && this.k != null && e0aVar != null) {
            int type = e0aVar.getType();
            if (type != 1) {
                if (type != 2) {
                    if (type == 3 && (e0aVar.c() instanceof MusicData)) {
                        this.I.k((MusicData) e0aVar.c(), obj);
                        if (((MusicData) e0aVar.c()).editMusicType == 1) {
                            this.m.setViewChoosed(0, false);
                        } else {
                            this.m.setViewChoosed(0, true);
                        }
                    }
                } else if (e0aVar.c() instanceof String) {
                    this.k.E((String) e0aVar.c());
                    StatisticItem statisticItem = new StatisticItem("c12496");
                    statisticItem.param("obj_id", (String) e0aVar.c());
                    if (this.b.f() == 1) {
                        statisticItem.param("obj_type", 1);
                    } else {
                        statisticItem.param("obj_type", 2);
                    }
                    if (e0aVar.c().equals("origin")) {
                        this.m.setViewChoosed(3, false);
                    } else {
                        this.m.setViewChoosed(3, true);
                    }
                }
            } else if (e0aVar.c() instanceof iy9) {
                this.k.B((iy9) e0aVar.c());
                TiebaStatic.log(new StatisticItem("c12421").param("obj_id", ((iy9) e0aVar.c()).a));
                if (((iy9) e0aVar.c()).a == 0) {
                    this.m.setViewChoosed(2, false);
                } else {
                    this.m.setViewChoosed(2, true);
                }
            }
        }
    }

    public final void h2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            if (this.k.m()) {
                this.f.setVisibility(8);
            } else {
                this.f.setVisibility(0);
            }
            if (this.k.l()) {
                this.f.setImageResource(R.drawable.obfuscated_res_0x7f080bbc);
            } else {
                this.f.setImageResource(R.drawable.obfuscated_res_0x7f080bbb);
            }
        }
    }

    public final void j2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            ObjectAnimator objectAnimator = this.w;
            if (objectAnimator != null) {
                objectAnimator.cancel();
            }
            if (this.v == null) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.J, Key.ALPHA, 0.0f, 1.0f);
                this.v = ofFloat;
                ofFloat.setDuration(500L);
            }
            this.J.setVisibility(0);
            this.v.start();
        }
    }

    public final void k2() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048602, this) != null) || !DeviceInfoUtil.isfullScreen()) {
            return;
        }
        View findViewById = findViewById(R.id.statusbar_view);
        this.n = findViewById;
        ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
        layoutParams.height = UtilHelper.getStatusBarHeight();
        this.n.setLayoutParams(layoutParams);
        this.n.setVisibility(0);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            super.onPause();
            this.k.u();
            if (this.c != null) {
                i0a i0aVar = this.b;
                if (i0aVar != null && i0aVar.f() == 6) {
                    this.c.E();
                    R();
                }
                i0a i0aVar2 = this.b;
                if (i0aVar2 != null && i0aVar2.j()) {
                    this.c.E();
                }
            }
            j0a j0aVar = this.I;
            if (j0aVar != null) {
                j0aVar.l();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.f
    public void v0() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048620, this) != null) || this.p.getVisibility() == 0) {
            return;
        }
        this.c.F();
        this.b.m(8);
        l();
        List<String> list = this.k.q;
        if (list != null && list.size() > 0) {
            this.p.setVisibility(0);
            new c(this).execute(new Void[0]);
        }
    }

    public final void i2(StickerItem stickerItem, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048599, this, stickerItem, str) == null) && stickerItem != null && !StringUtils.isNull(str)) {
            stickerItem.localPath = str;
            h0a h0aVar = this.k;
            if (h0aVar != null) {
                h0aVar.H(stickerItem);
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
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.f
    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            if (this.K == 2) {
                if (!this.D) {
                    return;
                }
                this.D = false;
                j0a j0aVar = this.I;
                if (j0aVar != null) {
                    j0aVar.o();
                }
            }
            AnimatorSet animatorSet = this.s;
            if (animatorSet != null && animatorSet.isRunning()) {
                this.s.cancel();
            }
            if (this.t == null) {
                AnimatorSet animatorSet2 = new AnimatorSet();
                this.t = animatorSet2;
                animatorSet2.playTogether(ObjectAnimator.ofFloat(this.d, Key.ALPHA, 0.0f, 1.0f), ObjectAnimator.ofFloat(this.m, Key.ALPHA, 0.0f, 1.0f), ObjectAnimator.ofFloat(this.J, Key.ALPHA, 0.0f, 1.0f));
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

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048606, this, i2, i3, intent) == null) {
            if (intent != null && i2 == 25032) {
                String stringExtra = intent.getStringExtra(CloudMusicActivityConfig.MUSIC_RESOURCE);
                String stringExtra2 = intent.getStringExtra(CloudMusicActivityConfig.MUSIC_ID);
                if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                    String f2 = ez9.g().f(stringExtra);
                    if (this.I != null && !TextUtils.isEmpty(f2)) {
                        this.I.j(f2, stringExtra2);
                        this.c.z();
                    }
                }
            } else if (i2 == 12012 && i3 == -1) {
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
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, bundle) == null) {
            TiebaStatic.log("c12293");
            this.x = getPageContext().getPageActivity();
            setIsAddSwipeBackLayout(false);
            requestWindowFeature(1);
            getWindow().setFlags(1024, 1024);
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d07e6);
            this.y = getIntent().getIntExtra(RecordVideoActivityConfig.ENTRANCE_FLAG, 0);
            this.z = getIntent().getIntExtra(RecordVideoActivityConfig.SHOW_TYPE, 0);
            if (getIntent().getSerializableExtra(RecordVideoActivityConfig.FORUM_WRITE_DATA) instanceof ForumWriteData) {
                this.A = (ForumWriteData) getIntent().getSerializableExtra(RecordVideoActivityConfig.FORUM_WRITE_DATA);
            }
            if (getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO) instanceof WriteImagesInfo) {
                this.B = (WriteImagesInfo) getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO);
            }
            this.C = getIntent().getStringExtra("video_title");
            b2();
            SelectMusicModel selectMusicModel = new SelectMusicModel(getPageContext(), this.c);
            this.H = selectMusicModel;
            selectMusicModel.W();
            j0a j0aVar = new j0a(this);
            this.I = j0aVar;
            j0aVar.t(this.H);
            this.b.c(this.I);
            registerListener(this.P);
            registerListener(this.S);
            registerListener(this.T);
            registerListener(this.N);
            d2();
            if (Build.VERSION.SDK_INT >= 28 && RomTypeUtil.isOPPO() && TbSingleton.getInstance().isCutoutScreen(this)) {
                qx9.b(1, getWindow().getAttributes(), getWindow());
            }
        }
    }

    @Override // com.baidu.tieba.video.record.GLVideoPreviewView.b
    public void x0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048622, this, z) == null) {
            i0a i0aVar = this.b;
            if (i0aVar != null && (i0aVar.f() == 1 || this.b.f() == 3 || this.b.f() == 4)) {
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

    /* JADX WARN: Removed duplicated region for block: B:18:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    @Override // com.baidu.tieba.video.record.RecordTabLayout.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void y(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048623, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) != null) || this.K == i2) {
            return;
        }
        int i3 = 2;
        if (i2 != 1) {
            if (i2 == 2) {
                this.m.setViewVisibility(0, 0);
                this.m.setViewVisibility(3, 0);
                this.K = i2;
                this.c.setCurrentTab(i2);
                if (!z) {
                    TiebaStatic.log(new StatisticItem().param("obj_type", i3));
                    return;
                }
                return;
            }
        } else {
            j0a j0aVar = this.I;
            if (j0aVar != null) {
                j0aVar.r();
            }
            this.k.E("origin");
            this.m.setViewChoosed(0, false);
            this.m.setViewChoosed(3, false);
            this.c.j(1);
            this.m.setViewVisibility(0, 8);
            this.m.setViewVisibility(3, 8);
        }
        i3 = 1;
        this.K = i2;
        this.c.setCurrentTab(i2);
        if (!z) {
        }
    }
}
