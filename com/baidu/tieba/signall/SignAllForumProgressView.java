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
import com.repackage.qi;
import java.util.Random;
/* loaded from: classes4.dex */
public class SignAllForumProgressView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public Context b;
    public ProgressBar c;
    public ImageView d;
    public TextView e;
    public TextView f;
    public TextView g;
    public Scroller h;
    public TbImageView i;
    public RelativeLayout j;
    public int k;
    public boolean l;
    public Runnable m;
    public Runnable n;
    public Runnable o;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SignAllForumProgressView a;

        public a(SignAllForumProgressView signAllForumProgressView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {signAllForumProgressView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = signAllForumProgressView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.h.computeScrollOffset()) {
                    int currX = this.a.h.getCurrX();
                    if (currX < (this.a.c.getMax() * 9) / 10 || this.a.a == 2) {
                        this.a.c.setProgress(currX);
                        SignAllForumProgressView signAllForumProgressView = this.a;
                        signAllForumProgressView.postDelayed(signAllForumProgressView.m, 16L);
                        return;
                    }
                    this.a.h.forceFinished(true);
                    SignAllForumProgressView signAllForumProgressView2 = this.a;
                    signAllForumProgressView2.postDelayed(signAllForumProgressView2.n, 2000L);
                    return;
                }
                int progress = this.a.c.getProgress();
                int max = (this.a.c.getMax() * 9) / 10;
                if (progress < max) {
                    this.a.h.startScroll(progress, 0, max - progress, 0, 5000);
                    this.a.post(this);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SignAllForumProgressView a;

        public b(SignAllForumProgressView signAllForumProgressView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {signAllForumProgressView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = signAllForumProgressView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.postDelayed(this, 2000L);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SignAllForumProgressView a;

        public c(SignAllForumProgressView signAllForumProgressView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {signAllForumProgressView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = signAllForumProgressView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int d = qi.d(this.a.b, 6.0f);
                int d2 = qi.d(this.a.b, 100.0f);
                int i = d2 - (d * 2);
                int i2 = (d2 - i) / 2;
                int i3 = i + i2;
                this.a.c.getProgressDrawable().setBounds(i2, i2, i3, i3);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ BaseActivity c;
        public final /* synthetic */ SignAllForumProgressView d;

        /* loaded from: classes4.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d a;

            public a(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = dVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    if (!UrlManager.getInstance().dealOneLinkWithDialog(this.a.c.getPageContext(), "", new String[]{this.a.b}, false, null, true) && !UrlManager.getInstance().UrlValidated(this.a.b)) {
                        this.a.c.showToast(R.string.obfuscated_res_0x7f0f0ec7);
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = signAllForumProgressView;
            this.a = str;
            this.b = str2;
            this.c = baseActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.d.j.getVisibility() != 0) {
                    TiebaStatic.log("c11822");
                }
                this.d.j.setVisibility(0);
                this.d.i.K(this.a, 10, true);
                if (StringUtils.isNull(this.b)) {
                    return;
                }
                this.d.j.setOnClickListener(new a(this));
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 0;
        this.k = 2000;
        this.m = new a(this);
        this.n = new b(this);
        this.o = new c(this);
        j();
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a : invokeV.intValue;
    }

    public TextView getMessage1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f : (TextView) invokeV.objValue;
    }

    public TextView getMessage2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.g : (TextView) invokeV.objValue;
    }

    public ProgressBar getProgressBar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.c : (ProgressBar) invokeV.objValue;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.j.setVisibility(8);
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            Context context = getContext();
            this.b = context;
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d07af, this);
            this.c = (ProgressBar) findViewById(R.id.obfuscated_res_0x7f091e9e);
            this.d = (ImageView) findViewById(R.id.obfuscated_res_0x7f091e8e);
            this.e = (TextView) findViewById(R.id.obfuscated_res_0x7f091ea1);
            this.f = (TextView) findViewById(R.id.obfuscated_res_0x7f091e9f);
            this.g = (TextView) findViewById(R.id.obfuscated_res_0x7f091ea0);
            this.i = (TbImageView) findViewById(R.id.obfuscated_res_0x7f091e8a);
            this.j = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f091e8b);
            m();
            this.h = new Scroller(this.b, new DecelerateInterpolator());
            BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(), BitmapFactory.decodeResource(getResources(), R.drawable.obfuscated_res_0x7f08023c));
            Shader.TileMode tileMode = Shader.TileMode.REPEAT;
            bitmapDrawable.setTileModeXY(tileMode, tileMode);
            setBackgroundDrawable(bitmapDrawable);
            SkinManager.setBackgroundColor(this, R.color.CAM_X0201_1);
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            SkinManager.setBackgroundColor(this, R.color.CAM_X0201_1);
        }
    }

    public void l(BaseActivity<?> baseActivity, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, baseActivity, str, str2) == null) {
            new Handler().postDelayed(new d(this, str, str2, baseActivity), 3000L);
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            removeCallbacks(this.m);
            removeCallbacks(this.n);
            if (this.l) {
                this.c.setProgressDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f081252));
            } else {
                this.c.setProgressDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f0810d8));
            }
            int i = this.a;
            if (i == 0) {
                this.c.setClickable(true);
                this.c.setProgress(0);
                this.c.setSecondaryProgress(0);
                if (this.l) {
                    SkinManager.setBackgroundResource(this.c, R.drawable.btn_vip_all_sign);
                    SkinManager.setImageResource(this.d, R.drawable.icon_vip_sign);
                } else {
                    SkinManager.setBackgroundResource(this.c, R.drawable.btn_all_sign);
                    SkinManager.setImageResource(this.d, R.drawable.icon_all_sign);
                }
                this.e.setText(R.string.obfuscated_res_0x7f0f118e);
            } else if (i == 1) {
                post(this.o);
                this.c.setClickable(false);
                SkinManager.setBackgroundResource(this.c, R.drawable.bg_all_sign_conduct);
                if (this.l) {
                    SkinManager.setImageResource(this.d, R.drawable.icon_vip_sign);
                } else {
                    SkinManager.setImageResource(this.d, R.drawable.icon_all_sign);
                }
                this.e.setText(R.string.obfuscated_res_0x7f0f1193);
                int max = (this.c.getMax() * (new Random(System.currentTimeMillis()).nextInt(30) + 50)) / 100;
                if (max - this.c.getProgress() < 0) {
                    this.h.startScroll(max, 0, this.c.getProgress() - max, 0, this.k);
                } else {
                    this.h.startScroll(this.c.getProgress(), 0, max - this.c.getProgress(), 0, this.k);
                }
                post(this.m);
            } else if (i != 2) {
                if (i != 3) {
                    return;
                }
                this.c.setClickable(false);
                if (this.l) {
                    SkinManager.setImageResource(this.d, R.drawable.icon_vip_sign);
                } else {
                    SkinManager.setImageResource(this.d, R.drawable.icon_all_sign);
                }
                SkinManager.setBackgroundResource(this.c, R.drawable.bg_all_sign_conduct);
                this.e.setText(R.string.obfuscated_res_0x7f0f036e);
            } else {
                this.c.setClickable(true);
                if (this.l) {
                    SkinManager.setBackgroundResource(this.c, R.drawable.bg_vip_sign_ok_d);
                    SkinManager.setImageResource(this.d, R.drawable.icon_vip_sign_ok);
                } else {
                    SkinManager.setBackgroundResource(this.c, R.drawable.bg_all_sign_ok_d);
                    SkinManager.setImageResource(this.d, R.drawable.icon_all_sign_ok);
                }
                this.c.setProgress(0);
                this.e.setText(R.string.obfuscated_res_0x7f0f1199);
            }
        }
    }

    public void setDuration(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            this.k = i;
        }
    }

    public void setHasPrivilege(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.l = z;
            m();
        }
    }

    public void setSignBefore(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.c.setProgress(i);
            this.a = 0;
            m();
        }
    }

    public void setSignSuccess() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || this.a == 2) {
            return;
        }
        this.a = 2;
        m();
    }

    public void setSigning(int i) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048590, this, i) == null) && (i2 = this.a) != 1 && i2 == 0) {
            this.c.setProgress(i);
            this.a = 1;
            m();
        }
    }

    public void setmCurrentStatus(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            this.a = i;
            m();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SignAllForumProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = 0;
        this.k = 2000;
        this.m = new a(this);
        this.n = new b(this);
        this.o = new c(this);
        j();
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = 0;
        this.k = 2000;
        this.m = new a(this);
        this.n = new b(this);
        this.o = new c(this);
        j();
    }
}
