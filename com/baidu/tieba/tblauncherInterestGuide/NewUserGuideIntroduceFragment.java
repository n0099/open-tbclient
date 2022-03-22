package com.baidu.tieba.tblauncherInterestGuide;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.tblauncherInterestGuide.view.GoOnAnimView;
import com.baidu.tieba.tblauncherInterestGuide.view.RightSlideViewPager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class NewUserGuideIntroduceFragment extends BaseFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f36257b;

    /* renamed from: c  reason: collision with root package name */
    public Bitmap f36258c;

    /* renamed from: d  reason: collision with root package name */
    public NewUserGuideActivity f36259d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f36260e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f36261f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f36262g;

    /* renamed from: h  reason: collision with root package name */
    public GoOnAnimView f36263h;
    public Handler i;

    /* loaded from: classes6.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewUserGuideIntroduceFragment a;

        public a(NewUserGuideIntroduceFragment newUserGuideIntroduceFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newUserGuideIntroduceFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newUserGuideIntroduceFragment;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                int i = message.what;
                if (i == 0) {
                    this.a.G0();
                } else if (i != 1) {
                } else {
                    this.a.F0();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewUserGuideIntroduceFragment a;

        public b(NewUserGuideIntroduceFragment newUserGuideIntroduceFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newUserGuideIntroduceFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newUserGuideIntroduceFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.a.f36259d == null) {
                return;
            }
            if (this.a.f36259d.getNewUserGuideModel().B()) {
                this.a.f36259d.startMainTabEnterFourm();
                return;
            }
            RightSlideViewPager viewPager = this.a.f36259d.getViewPager();
            if (viewPager != null) {
                viewPager.setCurrentItem(1, true);
            }
        }
    }

    public NewUserGuideIntroduceFragment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = false;
        this.f36258c = null;
        this.i = new a(this);
    }

    public final void E0(ImageView imageView, boolean z, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{imageView, Boolean.valueOf(z), Long.valueOf(j)}) == null) {
            TranslateAnimation translateAnimation = new TranslateAnimation(2, z ? 1.0f : -1.0f, 1, 0.0f, 1, 0.0f, 1, 0.0f);
            translateAnimation.setInterpolator(new LinearInterpolator());
            translateAnimation.setDuration(500L);
            translateAnimation.setStartOffset(j);
            translateAnimation.setFillAfter(true);
            imageView.startAnimation(translateAnimation);
        }
    }

    public final void F0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f36260e.setImageResource(R.drawable.obfuscated_res_0x7f080f59);
            this.f36261f.setImageResource(R.drawable.obfuscated_res_0x7f080f5b);
            this.f36262g.setImageResource(R.drawable.obfuscated_res_0x7f080f5a);
            E0(this.f36260e, true, 0L);
            E0(this.f36261f, false, 100L);
            E0(this.f36262g, true, 250L);
        }
    }

    public void G0() {
        GoOnAnimView goOnAnimView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (goOnAnimView = this.f36263h) == null) {
            return;
        }
        goOnAnimView.j();
    }

    public final void H0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.a) {
            this.f36257b.setBackgroundDrawable(null);
            Bitmap bitmap = this.f36258c;
            if (bitmap != null) {
                if (!bitmap.isRecycled()) {
                    this.f36258c.recycle();
                }
                this.f36258c = null;
            }
            this.f36260e.clearAnimation();
            this.f36260e.setImageDrawable(null);
            this.f36261f.clearAnimation();
            this.f36261f.setImageDrawable(null);
            this.f36262g.clearAnimation();
            this.f36262g.setImageDrawable(null);
            GoOnAnimView goOnAnimView = this.f36263h;
            if (goOnAnimView != null) {
                goOnAnimView.i();
            }
            this.i.removeMessages(0);
            this.i.removeMessages(1);
        }
    }

    public void I0() {
        GoOnAnimView goOnAnimView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (goOnAnimView = this.f36263h) == null) {
            return;
        }
        goOnAnimView.k();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            super.onCreate(bundle);
            this.f36259d = (NewUserGuideActivity) getBaseFragmentActivity();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, layoutInflater, viewGroup, bundle)) == null) {
            try {
                ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0392, (ViewGroup) null);
                this.a = true;
                this.f36257b = (ViewGroup) viewGroup2.findViewById(R.id.obfuscated_res_0x7f091aee);
                this.f36260e = (ImageView) viewGroup2.findViewById(R.id.obfuscated_res_0x7f090e81);
                this.f36261f = (ImageView) viewGroup2.findViewById(R.id.obfuscated_res_0x7f090e82);
                this.f36262g = (ImageView) viewGroup2.findViewById(R.id.obfuscated_res_0x7f090e83);
                Bitmap resBitmap = BitmapHelper.getResBitmap(this.f36259d.getPageContext().getPageActivity(), R.drawable.obfuscated_res_0x7f080eea);
                this.f36258c = resBitmap;
                if (resBitmap != null) {
                    this.f36257b.setBackgroundDrawable(new BitmapDrawable(this.f36259d.getResources(), this.f36258c));
                }
                this.f36263h = (GoOnAnimView) viewGroup2.findViewById(R.id.obfuscated_res_0x7f092014);
                this.i.removeMessages(0);
                this.i.removeMessages(1);
                this.i.sendEmptyMessageDelayed(0, 750L);
                this.i.sendEmptyMessageDelayed(1, 70L);
                this.f36263h.setOnClickListener(new b(this));
                return viewGroup2;
            } catch (InflateException e2) {
                this.a = false;
                if (!TbadkApplication.getInst().isDebugMode()) {
                    BdLog.e(e2);
                    this.f36259d.startMainTabEnterFourm();
                    TbadkApplication.getInst().onAppMemoryLow();
                    return new FrameLayout(layoutInflater.getContext());
                }
                throw e2;
            }
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onDestroy();
            H0();
        }
    }
}
