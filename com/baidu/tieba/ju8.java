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
import com.baidu.tbadk.core.util.dimen.TbDimenUtil;
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
public class ju8 {
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
    public HeadImageView i;
    public CountDownTimer j;
    public final PushExtData k;
    public final PushRemindInfo l;
    public final int m;
    public Ringtone n;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ju8 a;

        public a(ju8 ju8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ju8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ju8Var;
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
    public class b extends yq5<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;

        public b(ju8 ju8Var, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ju8Var, str, str2};
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
        @Override // com.baidu.tieba.yq5
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
    public class c implements cq5<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.cq5
        /* renamed from: a */
        public void onReturnDataInUI(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
            }
        }

        public c(ju8 ju8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ju8Var};
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
        public final /* synthetic */ ju8 a;

        public d(ju8 ju8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ju8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ju8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.m();
                this.a.q(true);
                if (this.a.m == 5) {
                    mu8.e(this.a.b, this.a.l.getScheme(), true);
                    ju8 ju8Var = this.a;
                    ju8Var.n(ju8Var.k.getUserId(), this.a.k.getGameId());
                } else if (this.a.m != 1 && this.a.m != 2 && this.a.m != 8 && this.a.m != 9) {
                    if (this.a.m == 4) {
                        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GAME_PLAY_ATTENTION_ACCEPT, TbConfig.SERVER_GAME_PLAY_ADRESS + this.a.k.getUri());
                        tbHttpMessageTask.setIsNeedAddCommenParam(true);
                        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
                        MessageManager.getInstance().registerTask(tbHttpMessageTask);
                        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GAME_PLAY_ATTENTION_ACCEPT);
                        httpMessage.addParam(BdUniDispatchSchemeController.PARAM_ORDER_ID, this.a.k.getOrderId());
                        MessageManager.getInstance().sendMessage(httpMessage);
                        mu8.c(this.a.b, this.a.l.getScheme());
                    } else if (this.a.m == 10) {
                        TbPageContextSupport tbPageContextSupport = (TbPageContextSupport) TbadkApplication.getInst().getCurrentActivity();
                        if (this.a.l != null && tbPageContextSupport != null && tbPageContextSupport.getPageContext() != null) {
                            UrlManager.getInstance().dealOneLink(tbPageContextSupport.getPageContext(), new String[]{this.a.l.getScheme()});
                        }
                    }
                } else {
                    mu8.e(this.a.b, this.a.l.getScheme(), true);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ju8 a;

        public e(ju8 ju8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ju8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ju8Var;
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
        public final /* synthetic */ ju8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(ju8 ju8Var, long j, long j2) {
            super(j, j2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ju8Var, Long.valueOf(j), Long.valueOf(j2)};
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
            this.a = ju8Var;
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
                textView.setText(valueOf + this.a.b.getString(R.string.peiwan_ring_group_auto_title));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ju8 a;

        public g(ju8 ju8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ju8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ju8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GAME_PLAY_ATTENTION_ACCEPT, TbConfig.SERVER_GAME_PLAY_ADRESS + this.a.k.getUriReject());
                tbHttpMessageTask.setIsNeedAddCommenParam(true);
                tbHttpMessageTask.setIsUseCurrentBDUSS(true);
                MessageManager.getInstance().registerTask(tbHttpMessageTask);
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GAME_PLAY_ATTENTION_ACCEPT);
                httpMessage.addParam(BdUniDispatchSchemeController.PARAM_ORDER_ID, this.a.k.getOrderId());
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
        public final /* synthetic */ ju8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(ju8 ju8Var, long j, long j2) {
            super(j, j2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ju8Var, Long.valueOf(j), Long.valueOf(j2)};
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
            this.a = ju8Var;
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
                this.a.f.setText(this.a.l.getBtnText() + " " + valueOf + ":" + valueOf2);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ju8 a;

        public i(ju8 ju8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ju8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ju8Var;
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
        public final /* synthetic */ ju8 a;

        public j(ju8 ju8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ju8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ju8Var;
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

        public k(ju8 ju8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ju8Var};
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
        public final /* synthetic */ ju8 a;

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

        public l(ju8 ju8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ju8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ju8Var;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, animation) != null) {
                return;
            }
            this.a.u();
            if (this.a.j != null) {
                this.a.j.start();
            }
            this.a.r();
        }
    }

    public ju8(Activity activity, PushExtData pushExtData, PushRemindInfo pushRemindInfo) {
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
        this.k = pushExtData;
        this.l = pushRemindInfo;
        this.m = pushExtData.getType();
        o();
    }

    public final void n(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
            cr5.b(new b(this, str, str2), new c(this));
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            v();
            Animation animation = this.h;
            if (animation != null) {
                animation.cancel();
            }
            CountDownTimer countDownTimer = this.j;
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            Activity activity = this.a;
            if (activity != null) {
                ((FrameLayout) activity.findViewById(16908290)).removeView(this.c);
            }
            Ringtone ringtone = this.n;
            if (ringtone != null) {
                ringtone.stop();
            }
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            View inflate = LayoutInflater.from(this.b).inflate(R.layout.game_play_push_big_dialog, (ViewGroup) null);
            this.c = inflate;
            this.d = (TextView) inflate.findViewById(R.id.peiwan_ring_auto_close);
            this.e = (ImageView) this.c.findViewById(R.id.iv_bell_type);
            HeadImageView headImageView = (HeadImageView) this.c.findViewById(R.id.peiwan_ring_header);
            this.i = headImageView;
            headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.i.K(this.l.getImage(), 12, false);
            s();
            TextView textView = (TextView) this.c.findViewById(R.id.peiwan_ring_title);
            textView.setText(this.l.getTitle());
            TextView textView2 = (TextView) this.c.findViewById(R.id.peiwan_ring_des);
            textView2.setText(this.l.getDesc());
            b35.d(textView).v(R.color.CAM_X0101);
            b35.d(textView2).v(R.color.CAM_X0103);
            b35 d2 = b35.d(this.d);
            d2.v(R.color.CAM_X0103);
            d2.z(R.dimen.T_X08);
            TBLottieAnimationView tBLottieAnimationView = (TBLottieAnimationView) this.c.findViewById(R.id.peiwan_anim_circle);
            this.g = tBLottieAnimationView;
            tBLottieAnimationView.setAnimation(R.raw.lottie_peiwan_ring_header);
            this.g.setRepeatMode(1);
            this.g.setRepeatCount(-1);
            TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) this.c.findViewById(R.id.peiwan_ring_button);
            this.f = tBSpecificationBtn;
            tBSpecificationBtn.setTextSize(R.dimen.T_X07);
            z55 z55Var = new z55();
            z55Var.r(R.color.CAM_X0101, R.color.CAM_X0302);
            z55Var.m(UtilHelper.getDimenPixelSize(R.dimen.M_W_X019));
            this.f.setConfig(z55Var);
            this.f.k();
            this.f.setText(this.l.getBtnText());
            this.f.setOnClickListener(new d(this));
            p();
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            int i2 = this.m;
            if (i2 != 1 && i2 != 2 && i2 != 5 && i2 != 8 && i2 != 9) {
                if (i2 == 4) {
                    ImageView imageView = this.e;
                    if (imageView != null) {
                        imageView.setImageResource(R.drawable.game_play_bell_group_apply_bg);
                    }
                    this.d.setText(this.b.getString(R.string.peiwan_reject_order));
                    this.d.setOnClickListener(new g(this));
                    this.j = new h(this, this.l.getShowtime(), 1000L);
                    return;
                } else if (i2 == 10) {
                    ImageView imageView2 = this.e;
                    if (imageView2 != null) {
                        imageView2.setImageResource(R.drawable.game_play_bell_audio_room_bg);
                    }
                    TextView textView = this.d;
                    if (textView != null) {
                        textView.setText(this.b.getString(R.string.peiwan_reject_audition));
                        this.d.setOnClickListener(new i(this));
                    }
                    View findViewById = this.c.findViewById(R.id.peiwan_ring_del);
                    findViewById.setVisibility(0);
                    findViewById.setOnClickListener(new j(this));
                    return;
                } else {
                    return;
                }
            }
            ((FrameLayout) this.c.findViewById(R.id.fl_peiwan_level)).setVisibility(0);
            TextView textView2 = (TextView) this.c.findViewById(R.id.peiwan_level);
            textView2.setText(this.l.getTagText());
            textView2.setVisibility(0);
            View findViewById2 = this.c.findViewById(R.id.peiwan_ring_del);
            findViewById2.setVisibility(0);
            findViewById2.setOnClickListener(new e(this));
            ImageView imageView3 = this.e;
            if (imageView3 != null) {
                imageView3.setImageResource(R.drawable.game_play_bell_group_apply_bg);
            }
            this.j = new f(this, this.l.getShowtime(), 1000L);
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
            int i2 = this.m;
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
            if (this.k == null) {
                currentAccount = "";
            } else {
                currentAccount = TbadkCoreApplication.getCurrentAccount();
            }
            StatisticItem addParam = statisticItem.addParam("uid", currentAccount);
            PushExtData pushExtData = this.k;
            if (pushExtData == null) {
                userId = "";
            } else {
                userId = pushExtData.getUserId();
            }
            StatisticItem addParam2 = addParam.addParam("obj_id", userId);
            PushExtData pushExtData2 = this.k;
            if (pushExtData2 == null) {
                gameName = "";
            } else {
                gameName = pushExtData2.getGameName();
            }
            StatisticItem addParam3 = addParam2.addParam("obj_name", gameName);
            PushExtData pushExtData3 = this.k;
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
            int i2 = this.m;
            if (i2 == 4) {
                str = TbadkCoreStatisticKey.KEY_GAME_PLAY_PUSH_ORDER_SHOW;
            } else if (i2 == 10) {
                str = TbadkCoreStatisticKey.KEY_GAME_PLAY_PUSH_DISPATCH_ORDER_SHOW;
            } else {
                str = TbadkCoreStatisticKey.KEY_GAME_PLAY_PUSH_RING_DIALOG_COMMON;
            }
            StatisticItem statisticItem = new StatisticItem(str);
            String str2 = "";
            if (this.k == null) {
                currentAccount = "";
            } else {
                currentAccount = TbadkCoreApplication.getCurrentAccount();
            }
            StatisticItem addParam = statisticItem.addParam("uid", currentAccount);
            PushExtData pushExtData = this.k;
            if (pushExtData == null) {
                userId = "";
            } else {
                userId = pushExtData.getUserId();
            }
            StatisticItem addParam2 = addParam.addParam("obj_id", userId);
            PushExtData pushExtData2 = this.k;
            if (pushExtData2 == null) {
                gameName = "";
            } else {
                gameName = pushExtData2.getGameName();
            }
            StatisticItem addParam3 = addParam2.addParam("obj_name", gameName);
            PushExtData pushExtData3 = this.k;
            if (pushExtData3 != null) {
                str2 = pushExtData3.getSource();
            }
            TiebaStatic.log(addParam3.addParam("obj_source", str2).addParam("obj_type", "1"));
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 48;
            layoutParams.topMargin = ue5.a(this.b);
            int g2 = ej.g(this.b, R.dimen.M_W_X007);
            layoutParams.leftMargin = g2;
            layoutParams.rightMargin = g2;
            this.c.setLayoutParams(layoutParams);
            this.c.setOnClickListener(new k(this));
            ((FrameLayout) this.a.findViewById(16908290)).addView(this.c);
            Animation loadAnimation = AnimationUtils.loadAnimation(this.b, R.anim.push_top_in);
            this.h = loadAnimation;
            loadAnimation.setDuration(400L);
            this.h.setAnimationListener(new l(this));
            this.c.startAnimation(this.h);
            this.c.findViewById(R.id.peiwan_ring_del).setOnClickListener(new a(this));
            this.n = mu8.f();
        }
    }

    public final void s() {
        HeadImageView headImageView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048582, this) != null) || (headImageView = this.i) == null) {
            return;
        }
        if (this.m == 10) {
            headImageView.setRadius(TbDimenUtil.dp2px(TbadkCoreApplication.getInst().getContext(), 12.0f));
        } else {
            headImageView.setIsRound(true);
        }
    }

    public final void u() {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (tBLottieAnimationView = this.g) != null) {
            tBLottieAnimationView.playAnimation();
        }
    }

    public final void v() {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (tBLottieAnimationView = this.g) != null) {
            tBLottieAnimationView.cancelAnimation();
            this.g.setFrame(0);
        }
    }
}
