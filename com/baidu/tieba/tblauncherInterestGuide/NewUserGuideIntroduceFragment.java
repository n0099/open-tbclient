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
/* loaded from: classes4.dex */
public class NewUserGuideIntroduceFragment extends BaseFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public boolean f21480e;

    /* renamed from: f  reason: collision with root package name */
    public ViewGroup f21481f;

    /* renamed from: g  reason: collision with root package name */
    public Bitmap f21482g;

    /* renamed from: h  reason: collision with root package name */
    public NewUserGuideActivity f21483h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f21484i;
    public ImageView j;
    public ImageView k;
    public GoOnAnimView l;
    public Handler m;

    /* loaded from: classes4.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NewUserGuideIntroduceFragment f21485a;

        public a(NewUserGuideIntroduceFragment newUserGuideIntroduceFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newUserGuideIntroduceFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21485a = newUserGuideIntroduceFragment;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                int i2 = message.what;
                if (i2 == 0) {
                    this.f21485a.Q0();
                } else if (i2 != 1) {
                } else {
                    this.f21485a.P0();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ NewUserGuideIntroduceFragment f21486e;

        public b(NewUserGuideIntroduceFragment newUserGuideIntroduceFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newUserGuideIntroduceFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21486e = newUserGuideIntroduceFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f21486e.f21483h == null) {
                return;
            }
            if (this.f21486e.f21483h.getNewUserGuideModel().z()) {
                this.f21486e.f21483h.startMainTabEnterFourm();
                return;
            }
            RightSlideViewPager viewPager = this.f21486e.f21483h.getViewPager();
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f21480e = false;
        this.f21482g = null;
        this.m = new a(this);
    }

    public final void O0(ImageView imageView, boolean z, long j) {
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

    public final void P0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f21484i.setImageResource(R.drawable.pic_startpage1_one);
            this.j.setImageResource(R.drawable.pic_startpage1_two);
            this.k.setImageResource(R.drawable.pic_startpage1_three);
            O0(this.f21484i, true, 0L);
            O0(this.j, false, 100L);
            O0(this.k, true, 250L);
        }
    }

    public void Q0() {
        GoOnAnimView goOnAnimView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (goOnAnimView = this.l) == null) {
            return;
        }
        goOnAnimView.j();
    }

    public final void R0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.f21480e) {
            this.f21481f.setBackgroundDrawable(null);
            Bitmap bitmap = this.f21482g;
            if (bitmap != null) {
                if (!bitmap.isRecycled()) {
                    this.f21482g.recycle();
                }
                this.f21482g = null;
            }
            this.f21484i.clearAnimation();
            this.f21484i.setImageDrawable(null);
            this.j.clearAnimation();
            this.j.setImageDrawable(null);
            this.k.clearAnimation();
            this.k.setImageDrawable(null);
            GoOnAnimView goOnAnimView = this.l;
            if (goOnAnimView != null) {
                goOnAnimView.i();
            }
            this.m.removeMessages(0);
            this.m.removeMessages(1);
        }
    }

    public void S0() {
        GoOnAnimView goOnAnimView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (goOnAnimView = this.l) == null) {
            return;
        }
        goOnAnimView.k();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            super.onCreate(bundle);
            this.f21483h = (NewUserGuideActivity) getBaseFragmentActivity();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, layoutInflater, viewGroup, bundle)) == null) {
            try {
                ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R.layout.guide_introduce, (ViewGroup) null);
                this.f21480e = true;
                this.f21481f = (ViewGroup) viewGroup2.findViewById(R.id.root_view);
                this.f21484i = (ImageView) viewGroup2.findViewById(R.id.image_tip_1);
                this.j = (ImageView) viewGroup2.findViewById(R.id.image_tip_2);
                this.k = (ImageView) viewGroup2.findViewById(R.id.image_tip_3);
                Bitmap resBitmap = BitmapHelper.getResBitmap(this.f21483h.getPageContext().getPageActivity(), R.drawable.pic_bg_startpage);
                this.f21482g = resBitmap;
                if (resBitmap != null) {
                    this.f21481f.setBackgroundDrawable(new BitmapDrawable(this.f21483h.getResources(), this.f21482g));
                }
                this.l = (GoOnAnimView) viewGroup2.findViewById(R.id.tip_go_on);
                this.m.removeMessages(0);
                this.m.removeMessages(1);
                this.m.sendEmptyMessageDelayed(0, 750L);
                this.m.sendEmptyMessageDelayed(1, 70L);
                this.l.setOnClickListener(new b(this));
                return viewGroup2;
            } catch (InflateException e2) {
                this.f21480e = false;
                if (!TbadkApplication.getInst().isDebugMode()) {
                    BdLog.e(e2);
                    this.f21483h.startMainTabEnterFourm();
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
            R0();
        }
    }
}
