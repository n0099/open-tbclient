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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
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
public class sc8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Activity a;
    public final Context b;
    public View c;
    public TextView d;
    public TBSpecificationBtn e;
    public TBLottieAnimationView f;
    public Animation g;
    public CountDownTimer h;
    public final PushExtData i;
    public final PushRemindInfo j;
    public final int k;
    public Ringtone l;

    /* loaded from: classes5.dex */
    public class a implements oh5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.oh5
        /* renamed from: a */
        public void onReturnDataInUI(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
            }
        }

        public a(sc8 sc8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sc8Var};
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
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sc8 a;

        public b(sc8 sc8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sc8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sc8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.m();
                this.a.q(true);
                if (this.a.k == 5) {
                    vc8.e(this.a.b, this.a.j.getScheme(), true);
                    sc8 sc8Var = this.a;
                    sc8Var.n(sc8Var.i.getUserId(), this.a.i.getGameId());
                } else if (this.a.k != 1 && this.a.k != 2 && this.a.k != 8 && this.a.k != 9) {
                    if (this.a.k == 4) {
                        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GAME_PLAY_ATTENTION_ACCEPT, TbConfig.SERVER_GAME_PLAY_ADRESS + this.a.i.getUri());
                        tbHttpMessageTask.setIsNeedAddCommenParam(true);
                        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
                        MessageManager.getInstance().registerTask(tbHttpMessageTask);
                        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GAME_PLAY_ATTENTION_ACCEPT);
                        httpMessage.addParam(BdUniDispatchSchemeController.PARAM_ORDER_ID, this.a.i.getOrderId());
                        MessageManager.getInstance().sendMessage(httpMessage);
                        vc8.c(this.a.b, this.a.j.getScheme());
                    }
                } else {
                    vc8.e(this.a.b, this.a.j.getScheme(), true);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sc8 a;

        public c(sc8 sc8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sc8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sc8Var;
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
    public class d extends CountDownTimer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sc8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(sc8 sc8Var, long j, long j2) {
            super(j, j2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sc8Var, Long.valueOf(j), Long.valueOf(j2)};
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
            this.a = sc8Var;
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
                textView.setText(valueOf + this.a.b.getString(R.string.obfuscated_res_0x7f0f0e38));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sc8 a;

        public e(sc8 sc8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sc8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sc8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GAME_PLAY_ATTENTION_ACCEPT, TbConfig.SERVER_GAME_PLAY_ADRESS + this.a.i.getUriReject());
                tbHttpMessageTask.setIsNeedAddCommenParam(true);
                tbHttpMessageTask.setIsUseCurrentBDUSS(true);
                MessageManager.getInstance().registerTask(tbHttpMessageTask);
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GAME_PLAY_ATTENTION_ACCEPT);
                httpMessage.addParam(BdUniDispatchSchemeController.PARAM_ORDER_ID, this.a.i.getOrderId());
                MessageManager.getInstance().sendMessage(httpMessage);
                this.a.q(false);
                this.a.m();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f extends CountDownTimer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sc8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(sc8 sc8Var, long j, long j2) {
            super(j, j2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sc8Var, Long.valueOf(j), Long.valueOf(j2)};
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
            this.a = sc8Var;
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
                this.a.e.setText(this.a.j.getBtnText() + " " + valueOf + ":" + valueOf2);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            }
        }

        public g(sc8 sc8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sc8Var};
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
    public class h implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sc8 a;

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

        public h(sc8 sc8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sc8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sc8Var;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, animation) != null) {
                return;
            }
            this.a.t();
            if (this.a.h != null) {
                this.a.h.start();
            }
            this.a.r();
        }
    }

    /* loaded from: classes5.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sc8 a;

        public i(sc8 sc8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sc8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sc8Var;
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
    public class j extends ii5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;

        public j(sc8 sc8Var, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sc8Var, str, str2};
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
        @Override // com.baidu.tieba.ii5
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

    public sc8(Activity activity, PushExtData pushExtData, PushRemindInfo pushRemindInfo) {
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
        this.i = pushExtData;
        this.j = pushRemindInfo;
        this.k = pushExtData.getType();
        o();
    }

    public final void n(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
            mi5.b(new j(this, str, str2), new a(this));
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            u();
            Animation animation = this.g;
            if (animation != null) {
                animation.cancel();
            }
            CountDownTimer countDownTimer = this.h;
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            Activity activity = this.a;
            if (activity != null) {
                ((FrameLayout) activity.findViewById(16908290)).removeView(this.c);
            }
            Ringtone ringtone = this.l;
            if (ringtone != null) {
                ringtone.stop();
            }
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            View inflate = LayoutInflater.from(this.b).inflate(R.layout.obfuscated_res_0x7f0d0372, (ViewGroup) null);
            this.c = inflate;
            this.d = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0918ad);
            HeadImageView headImageView = (HeadImageView) this.c.findViewById(R.id.obfuscated_res_0x7f0918b1);
            headImageView.setIsRound(true);
            headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            headImageView.L(this.j.getImage(), 12, false);
            TextView textView = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f0918b2);
            textView.setText(this.j.getTitle());
            TextView textView2 = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f0918b0);
            textView2.setText(this.j.getDesc());
            nv4.d(textView).v(R.color.CAM_X0101);
            nv4.d(textView2).v(R.color.CAM_X0103);
            nv4 d2 = nv4.d(this.d);
            d2.v(R.color.CAM_X0103);
            d2.z(R.dimen.T_X08);
            TBLottieAnimationView tBLottieAnimationView = (TBLottieAnimationView) this.c.findViewById(R.id.obfuscated_res_0x7f0918ab);
            this.f = tBLottieAnimationView;
            tBLottieAnimationView.setAnimation(R.raw.obfuscated_res_0x7f110047);
            this.f.setRepeatMode(1);
            this.f.setRepeatCount(-1);
            TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) this.c.findViewById(R.id.obfuscated_res_0x7f0918ae);
            this.e = tBSpecificationBtn;
            tBSpecificationBtn.setTextSize(R.dimen.T_X07);
            ty4 ty4Var = new ty4();
            ty4Var.p(R.color.CAM_X0101, R.color.CAM_X0302);
            ty4Var.l(UtilHelper.getDimenPixelSize(R.dimen.M_W_X019));
            this.e.setConfig(ty4Var);
            this.e.k();
            this.e.setText(this.j.getBtnText());
            this.e.setOnClickListener(new b(this));
            p();
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            int i2 = this.k;
            if (i2 != 1 && i2 != 2 && i2 != 5 && i2 != 8 && i2 != 9) {
                if (i2 == 4) {
                    this.d.setText(this.b.getString(R.string.obfuscated_res_0x7f0f0e37));
                    this.d.setOnClickListener(new e(this));
                    this.h = new f(this, this.j.getShowtime(), 1000L);
                    return;
                }
                return;
            }
            TextView textView = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f0918ac);
            textView.setText(this.j.getTagText());
            textView.setVisibility(0);
            View findViewById = this.c.findViewById(R.id.obfuscated_res_0x7f0918af);
            findViewById.setVisibility(0);
            findViewById.setOnClickListener(new c(this));
            this.h = new d(this, this.j.getShowtime(), 1000L);
        }
    }

    public final void r() {
        String str;
        String currentAccount;
        String userId;
        String gameName;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.k == 4) {
                str = TbadkCoreStatisticKey.KEY_GAME_PLAY_PUSH_ORDER_SHOW;
            } else {
                str = TbadkCoreStatisticKey.KEY_GAME_PLAY_PUSH_RING_DIALOG_COMMON;
            }
            StatisticItem statisticItem = new StatisticItem(str);
            String str2 = "";
            if (this.i == null) {
                currentAccount = "";
            } else {
                currentAccount = TbadkCoreApplication.getCurrentAccount();
            }
            StatisticItem addParam = statisticItem.addParam("uid", currentAccount);
            PushExtData pushExtData = this.i;
            if (pushExtData == null) {
                userId = "";
            } else {
                userId = pushExtData.getUserId();
            }
            StatisticItem addParam2 = addParam.addParam("obj_id", userId);
            PushExtData pushExtData2 = this.i;
            if (pushExtData2 == null) {
                gameName = "";
            } else {
                gameName = pushExtData2.getGameName();
            }
            StatisticItem addParam3 = addParam2.addParam("obj_name", gameName);
            PushExtData pushExtData3 = this.i;
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
            layoutParams.topMargin = h75.a(this.b);
            int f2 = fj.f(this.b, R.dimen.M_W_X007);
            layoutParams.leftMargin = f2;
            layoutParams.rightMargin = f2;
            this.c.setLayoutParams(layoutParams);
            this.c.setOnClickListener(new g(this));
            ((FrameLayout) this.a.findViewById(16908290)).addView(this.c);
            Animation loadAnimation = AnimationUtils.loadAnimation(this.b, R.anim.obfuscated_res_0x7f010102);
            this.g = loadAnimation;
            loadAnimation.setDuration(400L);
            this.g.setAnimationListener(new h(this));
            this.c.startAnimation(this.g);
            this.c.findViewById(R.id.obfuscated_res_0x7f0918af).setOnClickListener(new i(this));
            this.l = vc8.f();
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
            if (this.k == 4) {
                if (z) {
                    str = TbadkCoreStatisticKey.KEY_GAME_PLAY_PUSH_ORDER_ACCEPT_CLICK;
                } else {
                    str = TbadkCoreStatisticKey.KEY_GAME_PLAY_PUSH_ORDER_REJECT_CLICK;
                }
            } else {
                str = TbadkCoreStatisticKey.KEY_GAME_PLAY_PUSH_RING_DIALOG_COMMON;
            }
            StatisticItem statisticItem = new StatisticItem(str);
            String str3 = "";
            if (this.i == null) {
                currentAccount = "";
            } else {
                currentAccount = TbadkCoreApplication.getCurrentAccount();
            }
            StatisticItem addParam = statisticItem.addParam("uid", currentAccount);
            PushExtData pushExtData = this.i;
            if (pushExtData == null) {
                userId = "";
            } else {
                userId = pushExtData.getUserId();
            }
            StatisticItem addParam2 = addParam.addParam("obj_id", userId);
            PushExtData pushExtData2 = this.i;
            if (pushExtData2 == null) {
                gameName = "";
            } else {
                gameName = pushExtData2.getGameName();
            }
            StatisticItem addParam3 = addParam2.addParam("obj_name", gameName);
            PushExtData pushExtData3 = this.i;
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

    public final void t() {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (tBLottieAnimationView = this.f) != null) {
            tBLottieAnimationView.playAnimation();
        }
    }

    public final void u() {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (tBLottieAnimationView = this.f) != null) {
            tBLottieAnimationView.cancelAnimation();
            this.f.setFrame(0);
        }
    }
}
