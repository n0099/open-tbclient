package com.baidu.tieba;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.push.PushExtData;
import com.baidu.tieba.push.PushGeneralData;
import com.baidu.tieba.push.PushRemindInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class sx9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final View a;
    public final RelativeLayout b;
    public final EMTextView c;
    public final EMTextView d;
    public final EMTextView e;
    public final TbImageView f;
    public final TBSpecificationBtn g;
    public final TBLottieAnimationView h;
    public final RelativeLayout i;
    public final EMTextView j;
    public String k;
    public TbPageContext l;
    public PushExtData m;
    public PushRemindInfo n;
    public e o;
    public int p;
    public boolean q;
    public float r;
    public float s;

    /* loaded from: classes8.dex */
    public interface e {
        void a(View view2);
    }

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sx9 a;

        public a(sx9 sx9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sx9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sx9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.a.k();
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sx9 a;

        public b(sx9 sx9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sx9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sx9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.a.k();
        }
    }

    /* loaded from: classes8.dex */
    public class c implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sx9 a;

        public c(sx9 sx9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sx9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sx9Var;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                int action = motionEvent.getAction();
                if (action != 0) {
                    if (action != 1) {
                        if (action == 2) {
                            if (this.a.r == 0.0f) {
                                this.a.r = motionEvent.getY();
                            }
                            this.a.s = motionEvent.getY() - this.a.r;
                            if (this.a.s < 0.0f) {
                                this.a.q = true;
                            } else {
                                this.a.q = false;
                            }
                        }
                    } else if (this.a.q && this.a.o != null) {
                        this.a.o.a(this.a.b);
                        return true;
                    }
                } else {
                    this.a.r = motionEvent.getY();
                    this.a.q = false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sx9 a;

        public d(sx9 sx9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sx9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sx9Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.h.playAnimation();
            }
        }
    }

    public sx9(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.q = false;
        this.s = 0.0f;
        this.l = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getContext()).inflate(R.layout.push_open_private_chat, (ViewGroup) null);
        this.a = inflate;
        this.b = (RelativeLayout) inflate.findViewById(R.id.top_mian_view);
        this.c = (EMTextView) this.a.findViewById(R.id.desc_tv);
        this.d = (EMTextView) this.a.findViewById(R.id.title_tv);
        this.e = (EMTextView) this.a.findViewById(R.id.obfuscated_res_0x7f09241c);
        this.h = (TBLottieAnimationView) this.a.findViewById(R.id.avar_lottie);
        this.f = (TbImageView) this.a.findViewById(R.id.avar_image);
        this.g = (TBSpecificationBtn) this.a.findViewById(R.id.right_btn);
        this.j = (EMTextView) this.a.findViewById(R.id.jump_tv);
        this.i = (RelativeLayout) this.a.findViewById(R.id.rl_content);
        this.f.setPlaceHolder(1);
        this.f.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f.setConrers(15);
        this.f.setRadiusById(R.string.J_X01);
        this.f.setDrawCorner(true);
        z45 z45Var = new z45();
        z45Var.n(UtilHelper.getDimenPixelSize(R.dimen.M_W_X006));
        this.g.setTextSize(R.dimen.T_X08);
        this.g.setConfig(z45Var);
        this.g.setOnClickListener(new a(this));
        this.b.setOnClickListener(new b(this));
        this.b.setOnTouchListener(new c(this));
        n();
    }

    public void p(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, eVar) == null) {
            this.o = eVar;
        }
    }

    public final void k() {
        String str;
        String userId;
        String gameId;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            UrlManager.getInstance().dealOneLink(this.l, new String[]{this.k});
            int i = this.p;
            if (i != 3) {
                if (i != 6) {
                    if (i != 7) {
                        return;
                    }
                    str = TbadkCoreStatisticKey.KEY_GAME_PLAY_PUSH_REJECT_CLICK;
                } else {
                    str = TbadkCoreStatisticKey.KEY_GAME_PLAY_PUSH_ACCEPT_CLICK;
                }
            } else {
                str = TbadkCoreStatisticKey.KEY_GAME_PLAY_PUSH_ATTENTION_ACCEPT_CLICK;
            }
            StatisticItem statisticItem = new StatisticItem(str);
            PushExtData pushExtData = this.m;
            String str2 = "";
            if (pushExtData == null) {
                userId = "";
            } else {
                userId = pushExtData.getUserId();
            }
            StatisticItem addParam = statisticItem.addParam("uid", userId);
            PushExtData pushExtData2 = this.m;
            if (pushExtData2 == null) {
                gameId = "";
            } else {
                gameId = pushExtData2.getGameId();
            }
            StatisticItem addParam2 = addParam.addParam("obj_id", gameId);
            PushExtData pushExtData3 = this.m;
            if (pushExtData3 != null) {
                str2 = pushExtData3.getGameName();
            }
            TiebaStatic.log(addParam2.addParam("obj_name", str2));
            e eVar = this.o;
            if (eVar != null) {
                eVar.a(this.g);
            }
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            EMManager.from(this.d).setTextColor(R.color.CAM_X0105).setTextStyle(R.string.F_X02).setTextSize(R.dimen.T_X06);
            EMManager.from(this.c).setTextColor(R.color.CAM_X0109).setTextSize(R.dimen.T_X09);
            EMManager.from(this.j).setTextColor(R.color.CAM_X0109).setTextSize(R.dimen.T_X08);
            EMManager.from(this.b).setCorner(R.string.J_X05).setCardType(0).setBackGroundColor(R.color.CAM_X0207);
            EMManager.from(this.e).setTextSize(R.dimen.T_X10).setTextColor(R.color.CAM_X0101).setCorner(R.string.J_X04).setBackGroundColor(R.color.CAM_X0311);
            SkinManager.setLottieAnimation(this.h, R.raw.card_live_header_bg);
            this.g.k();
        }
    }

    public void l() {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (tBLottieAnimationView = this.h) != null) {
            tBLottieAnimationView.cancelAnimation();
        }
    }

    public View m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.a;
        }
        return (View) invokeV.objValue;
    }

    public void o(PushGeneralData pushGeneralData) {
        int type;
        int measureText;
        String str;
        String userId;
        String gameId;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, pushGeneralData) == null) {
            this.n = pushGeneralData.getForegroundShowData().getRemindInfo();
            PushExtData extData = pushGeneralData.getForegroundShowData().getExtData();
            this.m = extData;
            if (extData == null) {
                type = -1;
            } else {
                type = extData.getType();
            }
            this.p = type;
            this.d.setText(this.n.getTitle());
            this.c.setText(this.n.getDesc());
            this.f.startLoad(this.n.getImage(), 10, false);
            this.g.setText(this.n.getBtnText());
            this.k = this.n.getScheme();
            if (TextUtils.isEmpty(this.n.getTagText())) {
                this.e.setVisibility(8);
                measureText = 0;
            } else {
                this.e.setVisibility(0);
                this.e.setText(this.n.getTagText());
                measureText = (int) this.e.getPaint().measureText(this.n.getTagText());
            }
            int equipmentWidth = BdUtilHelper.getEquipmentWidth(this.l.getContext());
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X007);
            int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.M_W_X006);
            int dimenPixelSize3 = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            int dimenPixelSize4 = UtilHelper.getDimenPixelSize(R.dimen.M_W_X002);
            int dimenPixelSize5 = ((((equipmentWidth - (dimenPixelSize * 2)) - UtilHelper.getDimenPixelSize(R.dimen.tbds94)) - (dimenPixelSize2 * 3)) - measureText) - (dimenPixelSize3 * 2);
            this.d.setMaxWidth(((dimenPixelSize5 - ((int) this.j.getPaint().measureText(this.n.getBtnText()))) - (dimenPixelSize2 * 2)) - (dimenPixelSize4 * 3));
            int i = this.p;
            if (i != 3) {
                if (i != 6) {
                    if (i != 7) {
                        return;
                    }
                    str = TbadkCoreStatisticKey.KEY_GAME_PLAY_PUSH_REJECT_SHOW;
                } else {
                    str = TbadkCoreStatisticKey.KEY_GAME_PLAY_PUSH_ACCEPT_SHOW;
                }
            } else {
                str = TbadkCoreStatisticKey.KEY_GAME_PLAY_PUSH_ATTENTION_SHOW;
            }
            StatisticItem statisticItem = new StatisticItem(str);
            PushExtData pushExtData = this.m;
            String str2 = "";
            if (pushExtData == null) {
                userId = "";
            } else {
                userId = pushExtData.getUserId();
            }
            StatisticItem addParam = statisticItem.addParam("uid", userId);
            PushExtData pushExtData2 = this.m;
            if (pushExtData2 == null) {
                gameId = "";
            } else {
                gameId = pushExtData2.getGameId();
            }
            StatisticItem addParam2 = addParam.addParam("obj_id", gameId);
            PushExtData pushExtData3 = this.m;
            if (pushExtData3 != null) {
                str2 = pushExtData3.getGameName();
            }
            TiebaStatic.log(addParam2.addParam("obj_name", str2));
            if (this.n.getIsBreathe()) {
                this.h.setVisibility(0);
                if (!this.h.isAnimating()) {
                    this.h.setSpeed(0.8f);
                    this.h.setRepeatCount(-1);
                    this.h.post(new d(this));
                }
            }
        }
    }
}
