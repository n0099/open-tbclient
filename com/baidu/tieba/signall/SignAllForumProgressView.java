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
import c.a.d.f.p.m;
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
/* loaded from: classes12.dex */
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
    public int f49566e;

    /* renamed from: f  reason: collision with root package name */
    public Context f49567f;

    /* renamed from: g  reason: collision with root package name */
    public ProgressBar f49568g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f49569h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f49570i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f49571j;

    /* renamed from: k  reason: collision with root package name */
    public TextView f49572k;
    public Scroller l;
    public TbImageView m;
    public RelativeLayout n;
    public int o;
    public boolean p;
    public Runnable q;
    public Runnable r;
    public Runnable s;

    /* loaded from: classes12.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SignAllForumProgressView f49573e;

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
            this.f49573e = signAllForumProgressView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f49573e.l.computeScrollOffset()) {
                    int currX = this.f49573e.l.getCurrX();
                    if (currX < (this.f49573e.f49568g.getMax() * 9) / 10 || this.f49573e.f49566e == 2) {
                        this.f49573e.f49568g.setProgress(currX);
                        SignAllForumProgressView signAllForumProgressView = this.f49573e;
                        signAllForumProgressView.postDelayed(signAllForumProgressView.q, 16L);
                        return;
                    }
                    this.f49573e.l.forceFinished(true);
                    SignAllForumProgressView signAllForumProgressView2 = this.f49573e;
                    signAllForumProgressView2.postDelayed(signAllForumProgressView2.r, 2000L);
                    return;
                }
                int progress = this.f49573e.f49568g.getProgress();
                int max = (this.f49573e.f49568g.getMax() * 9) / 10;
                if (progress < max) {
                    this.f49573e.l.startScroll(progress, 0, max - progress, 0, 5000);
                    this.f49573e.post(this);
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SignAllForumProgressView f49574e;

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
            this.f49574e = signAllForumProgressView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f49574e.postDelayed(this, 2000L);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SignAllForumProgressView f49575e;

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
            this.f49575e = signAllForumProgressView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int d2 = m.d(this.f49575e.f49567f, 6.0f);
                int d3 = m.d(this.f49575e.f49567f, 100.0f);
                int i2 = d3 - (d2 * 2);
                int i3 = (d3 - i2) / 2;
                int i4 = i2 + i3;
                this.f49575e.f49568g.getProgressDrawable().setBounds(i3, i3, i4, i4);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f49576e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f49577f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ BaseActivity f49578g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ SignAllForumProgressView f49579h;

        /* loaded from: classes12.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d f49580e;

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
                this.f49580e = dVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    if (!UrlManager.getInstance().dealOneLinkWithDialog(this.f49580e.f49578g.getPageContext(), "", new String[]{this.f49580e.f49577f}, false, null, true) && !UrlManager.getInstance().UrlValidated(this.f49580e.f49577f)) {
                        this.f49580e.f49578g.showToast(R.string.pluginstatus_tip_unknown);
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
            this.f49579h = signAllForumProgressView;
            this.f49576e = str;
            this.f49577f = str2;
            this.f49578g = baseActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f49579h.n.getVisibility() != 0) {
                    TiebaStatic.log("c11822");
                }
                this.f49579h.n.setVisibility(0);
                this.f49579h.m.startLoad(this.f49576e, 10, true);
                if (StringUtils.isNull(this.f49577f)) {
                    return;
                }
                this.f49579h.n.setOnClickListener(new a(this));
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
        this.f49566e = 0;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f49566e : invokeV.intValue;
    }

    public TextView getMessage1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f49571j : (TextView) invokeV.objValue;
    }

    public TextView getMessage2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f49572k : (TextView) invokeV.objValue;
    }

    public ProgressBar getProgressBar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f49568g : (ProgressBar) invokeV.objValue;
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
            this.f49567f = context;
            LayoutInflater.from(context).inflate(R.layout.signallforum_progress_view, this);
            this.f49568g = (ProgressBar) findViewById(R.id.signallforum_progress);
            this.f49569h = (ImageView) findViewById(R.id.signallforum_icon);
            this.f49570i = (TextView) findViewById(R.id.signallforun_status);
            this.f49571j = (TextView) findViewById(R.id.signallforun_message1);
            this.f49572k = (TextView) findViewById(R.id.signallforun_message2);
            this.m = (TbImageView) findViewById(R.id.signallforum_banner_image);
            this.n = (RelativeLayout) findViewById(R.id.signallforum_banner_layout);
            updateUI();
            this.l = new Scroller(this.f49567f, new DecelerateInterpolator());
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
            this.f49568g.setProgress(i2);
            this.f49566e = 0;
            updateUI();
        }
    }

    public void setSignSuccess() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || this.f49566e == 2) {
            return;
        }
        this.f49566e = 2;
        updateUI();
    }

    public void setSigning(int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048588, this, i2) == null) && (i3 = this.f49566e) != 1 && i3 == 0) {
            this.f49568g.setProgress(i2);
            this.f49566e = 1;
            updateUI();
        }
    }

    public void setmCurrentStatus(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            this.f49566e = i2;
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
                this.f49568g.setProgressDrawable(getResources().getDrawable(R.drawable.vip_singnallforum_progress));
            } else {
                this.f49568g.setProgressDrawable(getResources().getDrawable(R.drawable.singnallforum_progress));
            }
            int i2 = this.f49566e;
            if (i2 == 0) {
                this.f49568g.setClickable(true);
                this.f49568g.setProgress(0);
                this.f49568g.setSecondaryProgress(0);
                if (this.p) {
                    SkinManager.setBackgroundResource(this.f49568g, R.drawable.btn_vip_all_sign);
                    SkinManager.setImageResource(this.f49569h, R.drawable.icon_vip_sign);
                } else {
                    SkinManager.setBackgroundResource(this.f49568g, R.drawable.btn_all_sign);
                    SkinManager.setImageResource(this.f49569h, R.drawable.icon_all_sign);
                }
                this.f49570i.setText(R.string.signallforum_begin);
            } else if (i2 == 1) {
                post(this.s);
                this.f49568g.setClickable(false);
                SkinManager.setBackgroundResource(this.f49568g, R.drawable.bg_all_sign_conduct);
                if (this.p) {
                    SkinManager.setImageResource(this.f49569h, R.drawable.icon_vip_sign);
                } else {
                    SkinManager.setImageResource(this.f49569h, R.drawable.icon_all_sign);
                }
                this.f49570i.setText(R.string.signallforum_ing);
                int max = (this.f49568g.getMax() * (new Random(System.currentTimeMillis()).nextInt(30) + 50)) / 100;
                if (max - this.f49568g.getProgress() < 0) {
                    this.l.startScroll(max, 0, this.f49568g.getProgress() - max, 0, this.o);
                } else {
                    this.l.startScroll(this.f49568g.getProgress(), 0, max - this.f49568g.getProgress(), 0, this.o);
                }
                post(this.q);
            } else if (i2 != 2) {
                if (i2 != 3) {
                    return;
                }
                this.f49568g.setClickable(false);
                if (this.p) {
                    SkinManager.setImageResource(this.f49569h, R.drawable.icon_vip_sign);
                } else {
                    SkinManager.setImageResource(this.f49569h, R.drawable.icon_all_sign);
                }
                SkinManager.setBackgroundResource(this.f49568g, R.drawable.bg_all_sign_conduct);
                this.f49570i.setText(R.string.can_not_sign);
            } else {
                this.f49568g.setClickable(true);
                if (this.p) {
                    SkinManager.setBackgroundResource(this.f49568g, R.drawable.bg_vip_sign_ok_d);
                    SkinManager.setImageResource(this.f49569h, R.drawable.icon_vip_sign_ok);
                } else {
                    SkinManager.setBackgroundResource(this.f49568g, R.drawable.bg_all_sign_ok_d);
                    SkinManager.setImageResource(this.f49569h, R.drawable.icon_all_sign_ok);
                }
                this.f49568g.setProgress(0);
                this.f49570i.setText(R.string.signallforum_success);
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
        this.f49566e = 0;
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
        this.f49566e = 0;
        this.o = 2000;
        this.q = new a(this);
        this.r = new b(this);
        this.s = new c(this);
        i();
    }
}
