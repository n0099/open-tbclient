package com.baidu.tieba.signall;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Scroller;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Random;
/* loaded from: classes11.dex */
public class SignAllForumProgressView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CAN_NOT_SIGN = 3;
    public static final int MIN_DURATION = 2000;
    public static final int PER_EACH = 50;
    public static final int SIGNING = 1;
    public static final int SIGN_BEFORE = 0;
    public static final int SIGN_SUCCESS = 2;
    public static final int SLOW_DURATION = 5000;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f49052e;

    /* renamed from: f  reason: collision with root package name */
    public Context f49053f;

    /* renamed from: g  reason: collision with root package name */
    public ProgressBar f49054g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f49055h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f49056i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f49057j;

    /* renamed from: k  reason: collision with root package name */
    public TextView f49058k;
    public Scroller l;
    public TbImageView m;
    public RelativeLayout n;
    public int o;
    public boolean p;
    public Runnable q;
    public Runnable r;
    public Runnable s;

    /* loaded from: classes11.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SignAllForumProgressView f49059e;

        public a(SignAllForumProgressView signAllForumProgressView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {signAllForumProgressView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49059e = signAllForumProgressView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f49059e.l.computeScrollOffset()) {
                    int currX = this.f49059e.l.getCurrX();
                    if (currX < (this.f49059e.f49054g.getMax() * 9) / 10 || this.f49059e.f49052e == 2) {
                        this.f49059e.f49054g.setProgress(currX);
                        SignAllForumProgressView signAllForumProgressView = this.f49059e;
                        signAllForumProgressView.postDelayed(signAllForumProgressView.q, 16L);
                        return;
                    }
                    this.f49059e.l.forceFinished(true);
                    SignAllForumProgressView signAllForumProgressView2 = this.f49059e;
                    signAllForumProgressView2.postDelayed(signAllForumProgressView2.r, 2000L);
                    return;
                }
                int progress = this.f49059e.f49054g.getProgress();
                int max = (this.f49059e.f49054g.getMax() * 9) / 10;
                if (progress < max) {
                    this.f49059e.l.startScroll(progress, 0, max - progress, 0, 5000);
                    this.f49059e.post(this);
                }
            }
        }
    }

    /* loaded from: classes11.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SignAllForumProgressView f49060e;

        public b(SignAllForumProgressView signAllForumProgressView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {signAllForumProgressView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49060e = signAllForumProgressView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f49060e.postDelayed(this, 2000L);
            }
        }
    }

    /* loaded from: classes11.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SignAllForumProgressView f49061e;

        public c(SignAllForumProgressView signAllForumProgressView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {signAllForumProgressView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49061e = signAllForumProgressView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int d2 = l.d(this.f49061e.f49053f, 6.0f);
                int d3 = l.d(this.f49061e.f49053f, 100.0f);
                int i2 = d3 - (d2 * 2);
                int i3 = (d3 - i2) / 2;
                int i4 = i2 + i3;
                this.f49061e.f49054g.getProgressDrawable().setBounds(i3, i3, i4, i4);
            }
        }
    }

    /* loaded from: classes11.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f49062e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f49063f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ BaseActivity f49064g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ SignAllForumProgressView f49065h;

        /* loaded from: classes11.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d f49066e;

            public a(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f49066e = dVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    if (!UrlManager.getInstance().dealOneLinkWithDialog(this.f49066e.f49064g.getPageContext(), "", new String[]{this.f49066e.f49063f}, false, null, true) && !UrlManager.getInstance().UrlValidated(this.f49066e.f49063f)) {
                        this.f49066e.f49064g.showToast(R.string.pluginstatus_tip_unknown);
                    } else {
                        TiebaStatic.log("c11758");
                    }
                }
            }
        }

        public d(SignAllForumProgressView signAllForumProgressView, String str, String str2, BaseActivity baseActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {signAllForumProgressView, str, str2, baseActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49065h = signAllForumProgressView;
            this.f49062e = str;
            this.f49063f = str2;
            this.f49064g = baseActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f49065h.n.getVisibility() != 0) {
                    TiebaStatic.log("c11822");
                }
                this.f49065h.n.setVisibility(0);
                this.f49065h.m.startLoad(this.f49062e, 10, true);
                if (StringUtils.isNull(this.f49063f)) {
                    return;
                }
                this.f49065h.n.setOnClickListener(new a(this));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SignAllForumProgressView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f49052e = 0;
        this.o = 2000;
        this.q = new a(this);
        this.r = new b(this);
        this.s = new c(this);
        i();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchSetPressed(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
        }
    }

    public int getCurrentStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f49052e : invokeV.intValue;
    }

    public TextView getMessage1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f49057j : (TextView) invokeV.objValue;
    }

    public TextView getMessage2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f49058k : (TextView) invokeV.objValue;
    }

    public ProgressBar getProgressBar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f49054g : (ProgressBar) invokeV.objValue;
    }

    public void hideBanner() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.n.setVisibility(8);
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            Context context = getContext();
            this.f49053f = context;
            LayoutInflater.from(context).inflate(R.layout.signallforum_progress_view, this);
            this.f49054g = (ProgressBar) findViewById(R.id.signallforum_progress);
            this.f49055h = (ImageView) findViewById(R.id.signallforum_icon);
            this.f49056i = (TextView) findViewById(R.id.signallforun_status);
            this.f49057j = (TextView) findViewById(R.id.signallforun_message1);
            this.f49058k = (TextView) findViewById(R.id.signallforun_message2);
            this.m = (TbImageView) findViewById(R.id.signallforum_banner_image);
            this.n = (RelativeLayout) findViewById(R.id.signallforum_banner_layout);
            updateUI();
            this.l = new Scroller(this.f49053f, new DecelerateInterpolator());
            BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(), BitmapFactory.decodeResource(getResources(), R.drawable.bg_all_sign));
            Shader.TileMode tileMode = Shader.TileMode.REPEAT;
            bitmapDrawable.setTileModeXY(tileMode, tileMode);
            setBackgroundDrawable(bitmapDrawable);
            SkinManager.setBackgroundColor(this, R.color.CAM_X0201_1);
        }
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            SkinManager.setBackgroundColor(this, R.color.CAM_X0201_1);
        }
    }

    public void setDuration(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.o = i2;
        }
    }

    public void setHasPrivilege(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.p = z;
            updateUI();
        }
    }

    public void setSignBefore(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.f49054g.setProgress(i2);
            this.f49052e = 0;
            updateUI();
        }
    }

    public void setSignSuccess() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || this.f49052e == 2) {
            return;
        }
        this.f49052e = 2;
        updateUI();
    }

    public void setSigning(int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048588, this, i2) == null) && (i3 = this.f49052e) != 1 && i3 == 0) {
            this.f49054g.setProgress(i2);
            this.f49052e = 1;
            updateUI();
        }
    }

    public void setmCurrentStatus(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            this.f49052e = i2;
            updateUI();
        }
    }

    public void showBanner(BaseActivity<?> baseActivity, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048590, this, baseActivity, str, str2) == null) {
            new Handler().postDelayed(new d(this, str, str2, baseActivity), 3000L);
        }
    }

    public void updateUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            removeCallbacks(this.q);
            removeCallbacks(this.r);
            if (this.p) {
                this.f49054g.setProgressDrawable(getResources().getDrawable(R.drawable.vip_singnallforum_progress));
            } else {
                this.f49054g.setProgressDrawable(getResources().getDrawable(R.drawable.singnallforum_progress));
            }
            int i2 = this.f49052e;
            if (i2 == 0) {
                this.f49054g.setClickable(true);
                this.f49054g.setProgress(0);
                this.f49054g.setSecondaryProgress(0);
                if (this.p) {
                    SkinManager.setBackgroundResource(this.f49054g, R.drawable.btn_vip_all_sign);
                    SkinManager.setImageResource(this.f49055h, R.drawable.icon_vip_sign);
                } else {
                    SkinManager.setBackgroundResource(this.f49054g, R.drawable.btn_all_sign);
                    SkinManager.setImageResource(this.f49055h, R.drawable.icon_all_sign);
                }
                this.f49056i.setText(R.string.signallforum_begin);
            } else if (i2 == 1) {
                post(this.s);
                this.f49054g.setClickable(false);
                SkinManager.setBackgroundResource(this.f49054g, R.drawable.bg_all_sign_conduct);
                if (this.p) {
                    SkinManager.setImageResource(this.f49055h, R.drawable.icon_vip_sign);
                } else {
                    SkinManager.setImageResource(this.f49055h, R.drawable.icon_all_sign);
                }
                this.f49056i.setText(R.string.signallforum_ing);
                int max = (this.f49054g.getMax() * (new Random(System.currentTimeMillis()).nextInt(30) + 50)) / 100;
                if (max - this.f49054g.getProgress() < 0) {
                    this.l.startScroll(max, 0, this.f49054g.getProgress() - max, 0, this.o);
                } else {
                    this.l.startScroll(this.f49054g.getProgress(), 0, max - this.f49054g.getProgress(), 0, this.o);
                }
                post(this.q);
            } else if (i2 != 2) {
                if (i2 != 3) {
                    return;
                }
                this.f49054g.setClickable(false);
                if (this.p) {
                    SkinManager.setImageResource(this.f49055h, R.drawable.icon_vip_sign);
                } else {
                    SkinManager.setImageResource(this.f49055h, R.drawable.icon_all_sign);
                }
                SkinManager.setBackgroundResource(this.f49054g, R.drawable.bg_all_sign_conduct);
                this.f49056i.setText(R.string.can_not_sign);
            } else {
                this.f49054g.setClickable(true);
                if (this.p) {
                    SkinManager.setBackgroundResource(this.f49054g, R.drawable.bg_vip_sign_ok_d);
                    SkinManager.setImageResource(this.f49055h, R.drawable.icon_vip_sign_ok);
                } else {
                    SkinManager.setBackgroundResource(this.f49054g, R.drawable.bg_all_sign_ok_d);
                    SkinManager.setImageResource(this.f49055h, R.drawable.icon_all_sign_ok);
                }
                this.f49054g.setProgress(0);
                this.f49056i.setText(R.string.signallforum_success);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SignAllForumProgressView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f49052e = 0;
        this.o = 2000;
        this.q = new a(this);
        this.r = new b(this);
        this.s = new c(this);
        i();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SignAllForumProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f49052e = 0;
        this.o = 2000;
        this.q = new a(this);
        this.r = new b(this);
        this.s = new c(this);
        i();
    }
}
