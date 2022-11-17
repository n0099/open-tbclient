package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.media.Ringtone;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BdToken.BdUniDispatchSchemeController;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.push.PushExtData;
import com.baidu.tieba.push.PushRemindInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class oe8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Activity a;
    public final Context b;
    public View c;
    public TextView d;
    public ImageView e;
    public TBSpecificationBtn f;
    public TBLottieAnimationView g;
    public Animation h;
    public CountDownTimer i;
    public final PushExtData j;
    public final PushRemindInfo k;
    public final int l;
    public Ringtone m;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oe8 a;

        public a(oe8 oe8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oe8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oe8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.a.m();
        }
    }

    /* loaded from: classes5.dex */
    public class b extends oj5<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;

        public b(oe8 oe8Var, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oe8Var, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.b = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.tieba.oj5
        public Boolean doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                NetWork netWork = new NetWork("https://peiwan.baidu.com/peiwan/api/team/click");
                netWork.addPostData("god_id", this.a);
                netWork.addPostData("game_id", this.b);
                netWork.setNeedBdussForGet(true);
                netWork.getNetString();
                return Boolean.valueOf(netWork.getNetContext().getResponse().isRequestSuccess());
            }
            return (Boolean) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class c implements ti5<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ti5
        /* renamed from: a */
        public void onReturnDataInUI(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
            }
        }

        public c(oe8 oe8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oe8Var};
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

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oe8 a;

        public d(oe8 oe8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oe8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oe8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.m();
                this.a.q(true);
                if (this.a.l == 5) {
                    re8.e(this.a.b, this.a.k.getScheme(), true);
                    oe8 oe8Var = this.a;
                    oe8Var.n(oe8Var.j.getUserId(), this.a.j.getGameId());
                } else if (this.a.l != 1 && this.a.l != 2 && this.a.l != 8 && this.a.l != 9) {
                    if (this.a.l == 4) {
                        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GAME_PLAY_ATTENTION_ACCEPT, TbConfig.SERVER_GAME_PLAY_ADRESS + this.a.j.getUri());
                        tbHttpMessageTask.setIsNeedAddCommenParam(true);
                        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
                        MessageManager.getInstance().registerTask(tbHttpMessageTask);
                        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GAME_PLAY_ATTENTION_ACCEPT);
                        httpMessage.addParam(BdUniDispatchSchemeController.PARAM_ORDER_ID, this.a.j.getOrderId());
                        MessageManager.getInstance().sendMessage(httpMessage);
                        re8.c(this.a.b, this.a.k.getScheme());
                    } else if (this.a.l == 10) {
                        TbPageContextSupport tbPageContextSupport = (TbPageContextSupport) TbadkApplication.getInst().getCurrentActivity();
                        if (this.a.k != null && tbPageContextSupport != null && tbPageContextSupport.getPageContext() != null) {
                            UrlManager.getInstance().dealOneLink(tbPageContextSupport.getPageContext(), new String[]{this.a.k.getScheme()});
                        }
                    }
                } else {
                    re8.e(this.a.b, this.a.k.getScheme(), true);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oe8 a;

        public e(oe8 oe8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oe8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oe8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.a.q(false);
            this.a.m();
        }
    }

    /* loaded from: classes5.dex */
    public class f extends CountDownTimer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oe8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(oe8 oe8Var, long j, long j2) {
            super(j, j2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oe8Var, Long.valueOf(j), Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Long) objArr2[0]).longValue(), ((Long) objArr2[1]).longValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oe8Var;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.m();
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                String valueOf = String.valueOf((int) (j / 1000));
                TextView textView = this.a.d;
                textView.setText(valueOf + this.a.b.getString(R.string.obfuscated_res_0x7f0f0e55));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oe8 a;

        public g(oe8 oe8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oe8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oe8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GAME_PLAY_ATTENTION_ACCEPT, TbConfig.SERVER_GAME_PLAY_ADRESS + this.a.j.getUriReject());
                tbHttpMessageTask.setIsNeedAddCommenParam(true);
                tbHttpMessageTask.setIsUseCurrentBDUSS(true);
                MessageManager.getInstance().registerTask(tbHttpMessageTask);
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GAME_PLAY_ATTENTION_ACCEPT);
                httpMessage.addParam(BdUniDispatchSchemeController.PARAM_ORDER_ID, this.a.j.getOrderId());
                MessageManager.getInstance().sendMessage(httpMessage);
                this.a.q(false);
                this.a.m();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h extends CountDownTimer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oe8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(oe8 oe8Var, long j, long j2) {
            super(j, j2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oe8Var, Long.valueOf(j), Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Long) objArr2[0]).longValue(), ((Long) objArr2[1]).longValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oe8Var;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.m();
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                String valueOf = String.valueOf(j / 60000);
                String valueOf2 = String.valueOf((j % 60000) / 1000);
                this.a.f.setText(this.a.k.getBtnText() + " " + valueOf + ":" + valueOf2);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oe8 a;

        public i(oe8 oe8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oe8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oe8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.a.q(false);
            this.a.m();
        }
    }

    /* loaded from: classes5.dex */
    public class j implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oe8 a;

        public j(oe8 oe8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oe8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oe8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.a.q(false);
            this.a.m();
        }
    }

    /* loaded from: classes5.dex */
    public class k implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            }
        }

        public k(oe8 oe8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oe8Var};
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

    /* loaded from: classes5.dex */
    public class l implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oe8 a;

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
            }
        }

        public l(oe8 oe8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oe8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oe8Var;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, animation) != null) {
                return;
            }
            this.a.t();
            if (this.a.i != null) {
                this.a.i.start();
            }
            this.a.r();
        }
    }

    public oe8(Activity activity, PushExtData pushExtData, PushRemindInfo pushRemindInfo) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, pushExtData, pushRemindInfo};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = activity;
        this.b = activity.getBaseContext();
        this.j = pushExtData;
        this.k = pushRemindInfo;
        this.l = pushExtData.getType();
        o();
    }

    public final void n(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
            sj5.b(new b(this, str, str2), new c(this));
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            u();
            Animation animation = this.h;
            if (animation != null) {
                animation.cancel();
            }
            CountDownTimer countDownTimer = this.i;
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            Activity activity = this.a;
            if (activity != null) {
                ((FrameLayout) activity.findViewById(16908290)).removeView(this.c);
            }
            Ringtone ringtone = this.m;
            if (ringtone != null) {
                ringtone.stop();
            }
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            View inflate = LayoutInflater.from(this.b).inflate(R.layout.obfuscated_res_0x7f0d0375, (ViewGroup) null);
            this.c = inflate;
            this.d = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0918f9);
            this.e = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f09102a);
            HeadImageView headImageView = (HeadImageView) this.c.findViewById(R.id.obfuscated_res_0x7f0918fd);
            headImageView.setIsRound(true);
            headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            headImageView.K(this.k.getImage(), 12, false);
            TextView textView = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f0918fe);
            textView.setText(this.k.getTitle());
            TextView textView2 = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f0918fc);
            textView2.setText(this.k.getDesc());
            qw4.d(textView).v(R.color.CAM_X0101);
            qw4.d(textView2).v(R.color.CAM_X0103);
            qw4 d2 = qw4.d(this.d);
            d2.v(R.color.CAM_X0103);
            d2.z(R.dimen.T_X08);
            TBLottieAnimationView tBLottieAnimationView = (TBLottieAnimationView) this.c.findViewById(R.id.obfuscated_res_0x7f0918f7);
            this.g = tBLottieAnimationView;
            tBLottieAnimationView.setAnimation(R.raw.obfuscated_res_0x7f110049);
            this.g.setRepeatMode(1);
            this.g.setRepeatCount(-1);
            TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) this.c.findViewById(R.id.obfuscated_res_0x7f0918fa);
            this.f = tBSpecificationBtn;
            tBSpecificationBtn.setTextSize(R.dimen.T_X07);
            pz4 pz4Var = new pz4();
            pz4Var.p(R.color.CAM_X0101, R.color.CAM_X0302);
            pz4Var.l(UtilHelper.getDimenPixelSize(R.dimen.M_W_X019));
            this.f.setConfig(pz4Var);
            this.f.k();
            this.f.setText(this.k.getBtnText());
            this.f.setOnClickListener(new d(this));
            p();
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            int i2 = this.l;
            if (i2 != 1 && i2 != 2 && i2 != 5 && i2 != 8 && i2 != 9) {
                if (i2 == 4) {
                    ImageView imageView = this.e;
                    if (imageView != null) {
                        imageView.setImageResource(R.drawable.obfuscated_res_0x7f0805b6);
                    }
                    this.d.setText(this.b.getString(R.string.obfuscated_res_0x7f0f0e54));
                    this.d.setOnClickListener(new g(this));
                    this.i = new h(this, this.k.getShowtime(), 1000L);
                    return;
                } else if (i2 == 10) {
                    ImageView imageView2 = this.e;
                    if (imageView2 != null) {
                        imageView2.setImageResource(R.drawable.obfuscated_res_0x7f0805b4);
                    }
                    TextView textView = this.d;
                    if (textView != null) {
                        textView.setText(this.b.getString(R.string.obfuscated_res_0x7f0f0e53));
                        this.d.setOnClickListener(new i(this));
                    }
                    View findViewById = this.c.findViewById(R.id.obfuscated_res_0x7f0918fb);
                    findViewById.setVisibility(0);
                    findViewById.setOnClickListener(new j(this));
                    return;
                } else {
                    return;
                }
            }
            ((FrameLayout) this.c.findViewById(R.id.obfuscated_res_0x7f090a01)).setVisibility(0);
            TextView textView2 = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f0918f8);
            textView2.setText(this.k.getTagText());
            textView2.setVisibility(0);
            View findViewById2 = this.c.findViewById(R.id.obfuscated_res_0x7f0918fb);
            findViewById2.setVisibility(0);
            findViewById2.setOnClickListener(new e(this));
            ImageView imageView3 = this.e;
            if (imageView3 != null) {
                imageView3.setImageResource(R.drawable.obfuscated_res_0x7f0805b6);
            }
            this.i = new f(this, this.k.getShowtime(), 1000L);
        }
    }

    public final void q(boolean z) {
        String str;
        String currentAccount;
        String userId;
        String gameName;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            int i2 = this.l;
            if (i2 == 4) {
                if (z) {
                    str = TbadkCoreStatisticKey.KEY_GAME_PLAY_PUSH_ORDER_ACCEPT_CLICK;
                } else {
                    str = TbadkCoreStatisticKey.KEY_GAME_PLAY_PUSH_ORDER_REJECT_CLICK;
                }
            } else if (i2 == 10) {
                str = TbadkCoreStatisticKey.KEY_GAME_PLAY_PUSH_DISPATCH_ORDER_SHOW;
            } else {
                str = TbadkCoreStatisticKey.KEY_GAME_PLAY_PUSH_RING_DIALOG_COMMON;
            }
            StatisticItem statisticItem = new StatisticItem(str);
            String str3 = "";
            if (this.j == null) {
                currentAccount = "";
            } else {
                currentAccount = TbadkCoreApplication.getCurrentAccount();
            }
            StatisticItem addParam = statisticItem.addParam("uid", currentAccount);
            PushExtData pushExtData = this.j;
            if (pushExtData == null) {
                userId = "";
            } else {
                userId = pushExtData.getUserId();
            }
            StatisticItem addParam2 = addParam.addParam("obj_id", userId);
            PushExtData pushExtData2 = this.j;
            if (pushExtData2 == null) {
                gameName = "";
            } else {
                gameName = pushExtData2.getGameName();
            }
            StatisticItem addParam3 = addParam2.addParam("obj_name", gameName);
            PushExtData pushExtData3 = this.j;
            if (pushExtData3 != null) {
                str3 = pushExtData3.getSource();
            }
            StatisticItem addParam4 = addParam3.addParam("obj_source", str3);
            if (z) {
                str2 = "2";
            } else {
                str2 = "3";
            }
            TiebaStatic.log(addParam4.addParam("obj_type", str2));
        }
    }

    public final void r() {
        String str;
        String currentAccount;
        String userId;
        String gameName;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            int i2 = this.l;
            if (i2 == 4) {
                str = TbadkCoreStatisticKey.KEY_GAME_PLAY_PUSH_ORDER_SHOW;
            } else if (i2 == 10) {
                str = TbadkCoreStatisticKey.KEY_GAME_PLAY_PUSH_DISPATCH_ORDER_SHOW;
            } else {
                str = TbadkCoreStatisticKey.KEY_GAME_PLAY_PUSH_RING_DIALOG_COMMON;
            }
            StatisticItem statisticItem = new StatisticItem(str);
            String str2 = "";
            if (this.j == null) {
                currentAccount = "";
            } else {
                currentAccount = TbadkCoreApplication.getCurrentAccount();
            }
            StatisticItem addParam = statisticItem.addParam("uid", currentAccount);
            PushExtData pushExtData = this.j;
            if (pushExtData == null) {
                userId = "";
            } else {
                userId = pushExtData.getUserId();
            }
            StatisticItem addParam2 = addParam.addParam("obj_id", userId);
            PushExtData pushExtData2 = this.j;
            if (pushExtData2 == null) {
                gameName = "";
            } else {
                gameName = pushExtData2.getGameName();
            }
            StatisticItem addParam3 = addParam2.addParam("obj_name", gameName);
            PushExtData pushExtData3 = this.j;
            if (pushExtData3 != null) {
                str2 = pushExtData3.getSource();
            }
            TiebaStatic.log(addParam3.addParam("obj_source", str2).addParam("obj_type", "1"));
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 48;
            layoutParams.topMargin = h85.a(this.b);
            int g2 = yi.g(this.b, R.dimen.M_W_X007);
            layoutParams.leftMargin = g2;
            layoutParams.rightMargin = g2;
            this.c.setLayoutParams(layoutParams);
            this.c.setOnClickListener(new k(this));
            ((FrameLayout) this.a.findViewById(16908290)).addView(this.c);
            Animation loadAnimation = AnimationUtils.loadAnimation(this.b, R.anim.obfuscated_res_0x7f010102);
            this.h = loadAnimation;
            loadAnimation.setDuration(400L);
            this.h.setAnimationListener(new l(this));
            this.c.startAnimation(this.h);
            this.c.findViewById(R.id.obfuscated_res_0x7f0918fb).setOnClickListener(new a(this));
            this.m = re8.f();
        }
    }

    public final void t() {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (tBLottieAnimationView = this.g) != null) {
            tBLottieAnimationView.playAnimation();
        }
    }

    public final void u() {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (tBLottieAnimationView = this.g) != null) {
            tBLottieAnimationView.cancelAnimation();
            this.g.setFrame(0);
        }
    }
}
