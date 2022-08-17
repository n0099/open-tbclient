package com.baidu.tieba.video.record;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.CustomToast;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.record.VideoEffectButtonLayout;
import com.baidu.tieba.video.record.VideoEffectLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ju8;
import com.repackage.nu8;
import com.repackage.qi;
import com.repackage.ru8;
import com.repackage.ws8;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class VideoControllerLayout extends RelativeLayout implements View.OnClickListener, View.OnTouchListener, VideoEffectButtonLayout.a, ws8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView a;
    public RelativeLayout b;
    public VideoRecordButton c;
    public ImageView d;
    public nu8 e;
    public long f;
    public boolean g;
    public AnimatorSet h;
    public AnimatorSet i;
    public List<ObjectAnimator> j;
    public f k;
    public boolean l;
    public List<ju8> m;
    public List<ju8> n;
    public List<StickerItem> o;
    public List<ju8> p;
    public VideoEffectLayout q;
    public Handler r;
    public int s;

    /* loaded from: classes4.dex */
    public class a extends ru8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ VideoControllerLayout c;

        public a(VideoControllerLayout videoControllerLayout, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoControllerLayout, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = videoControllerLayout;
            this.b = z;
        }

        @Override // com.repackage.ru8, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                if (this.c.e.f() == 6 || this.c.e.j()) {
                    this.c.B(this.b);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends ru8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoControllerLayout b;

        public b(VideoControllerLayout videoControllerLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoControllerLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = videoControllerLayout;
        }

        @Override // com.repackage.ru8, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, animator) == null) || this.a) {
                return;
            }
            this.b.a.setVisibility(8);
            this.b.d.setVisibility(8);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;
        public final /* synthetic */ VideoControllerLayout b;

        public c(VideoControllerLayout videoControllerLayout, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoControllerLayout, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = videoControllerLayout;
            this.a = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b.g && this.b.f == this.a) {
                TiebaStatic.log("c12297");
                this.b.A(true);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends ru8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoControllerLayout b;

        public d(VideoControllerLayout videoControllerLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoControllerLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = videoControllerLayout;
        }

        @Override // com.repackage.ru8, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, animator) == null) || this.b.k == null) {
                return;
            }
            this.b.k.k();
        }
    }

    /* loaded from: classes4.dex */
    public class e extends ru8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ru8 b;
        public final /* synthetic */ VideoControllerLayout c;

        public e(VideoControllerLayout videoControllerLayout, ru8 ru8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoControllerLayout, ru8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = videoControllerLayout;
            this.b = ru8Var;
        }

        @Override // com.repackage.ru8, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, animator) == null) || this.a) {
                return;
            }
            this.c.q.setVisibility(8);
            if (this.c.k != null) {
                this.c.k.s0();
            }
            ru8 ru8Var = this.b;
            if (ru8Var != null) {
                ru8Var.onAnimationEnd(animator);
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface f {
        void I0();

        void M();

        void X();

        void k();

        void l();

        void n();

        void o();

        void q();

        void s0();

        void y0();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoControllerLayout(Context context) {
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
        this.f = 0L;
        this.g = false;
        this.m = new ArrayList();
        this.n = new ArrayList();
        this.o = new ArrayList();
        this.p = new ArrayList();
        this.r = new Handler();
        n();
    }

    public final void A(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            if (this.e.e() >= 100) {
                f fVar = this.k;
                if (fVar != null) {
                    fVar.y0();
                    return;
                }
                return;
            }
            if (this.q.getCurrentBeautyItem() != null) {
                this.m.add(this.q.getCurrentBeautyItem());
            }
            if (this.q.getCurrentFilterItem() != null) {
                this.n.add(this.q.getCurrentFilterItem());
            }
            if (this.q.getCurrentStickItem() != null) {
                this.o.add(this.q.getCurrentStickItem());
            }
            j(2);
            if (this.q.getVisibility() == 0) {
                m(new a(this, z));
            } else {
                B(z);
            }
            nu8 nu8Var = this.e;
            if (nu8Var != null) {
                nu8Var.n();
            }
            f fVar2 = this.k;
            if (fVar2 != null) {
                fVar2.q();
            }
        }
    }

    public final void B(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            AnimatorSet animatorSet = this.i;
            if (animatorSet != null && animatorSet.isRunning()) {
                this.i.cancel();
            }
            if (this.h == null) {
                AnimatorSet animatorSet2 = new AnimatorSet();
                this.h = animatorSet2;
                animatorSet2.playTogether(ObjectAnimator.ofFloat(this.a, Key.ALPHA, 1.0f, 0.0f), ObjectAnimator.ofFloat(this.d, Key.ALPHA, 1.0f, 0.0f));
                this.h.addListener(new b(this));
                this.h.setDuration(300L);
            }
            this.h.start();
            if (this.e.f() != 6) {
                this.c.b(z);
            }
        }
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            D();
            int f2 = this.e.f();
            nu8 nu8Var = this.e;
            if (nu8Var != null) {
                if (!nu8Var.h() && this.e.j()) {
                    this.e.o();
                }
                E();
            }
            f fVar = this.k;
            if (fVar != null) {
                fVar.l();
                if (f2 == 6) {
                    this.k.X();
                }
            }
        }
    }

    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            nu8 nu8Var = this.e;
            if (nu8Var == null || nu8Var.j() || this.e.f() == 6) {
                AnimatorSet animatorSet = this.h;
                if (animatorSet != null && animatorSet.isRunning()) {
                    this.h.cancel();
                }
                if (this.i == null) {
                    AnimatorSet animatorSet2 = new AnimatorSet();
                    this.i = animatorSet2;
                    animatorSet2.playTogether(ObjectAnimator.ofFloat(this.a, Key.ALPHA, 0.0f, 1.0f), ObjectAnimator.ofFloat(this.d, Key.ALPHA, 0.0f, 1.0f));
                    this.i.setDuration(300L);
                }
                this.a.setVisibility(0);
                this.d.setVisibility(0);
                this.i.start();
                if (this.e.f() != 7 && this.e.f() != 6) {
                    this.c.d();
                    return;
                }
                this.c.getTvTip().setVisibility(8);
                if (this.s == 2) {
                    this.c.getLayer1().setVisibility(0);
                }
            }
        }
    }

    public void E() {
        nu8 nu8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (nu8Var = this.e) == null) {
            return;
        }
        if (nu8Var.g() >= 3000.0f) {
            j(4);
        } else if (this.e.g() > 0) {
            j(3);
        } else {
            j(1);
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void F0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (p() && this.q.getCurrentEffectLayout() == 3) {
                m(null);
                return;
            }
            if (!p()) {
                z();
            }
            this.q.F0();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void U0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (p() && this.q.getCurrentEffectLayout() == 2) {
                m(null);
                return;
            }
            if (!p()) {
                z();
            }
            this.q.U0();
        }
    }

    public List<ju8> getChoosedBeautyList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.m : (List) invokeV.objValue;
    }

    public List<ju8> getChoosedFilterList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.n : (List) invokeV.objValue;
    }

    public List<StickerItem> getChoosedStickerList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.o : (List) invokeV.objValue;
    }

    public void j(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            this.e.m(i);
            f fVar = this.k;
            if (fVar != null) {
                fVar.M();
            }
            if (i == 1) {
                this.a.setVisibility(8);
                this.d.setVisibility(8);
            } else if (i == 3) {
                this.a.setImageResource(R.drawable.obfuscated_res_0x7f081232);
                this.d.setImageResource(R.drawable.obfuscated_res_0x7f080af3);
            } else if (i == 4) {
                this.a.setImageResource(R.drawable.obfuscated_res_0x7f081232);
                this.d.setImageResource(R.drawable.obfuscated_res_0x7f081235);
            } else if (i == 5) {
                this.a.setImageResource(R.drawable.obfuscated_res_0x7f081236);
                nu8 nu8Var = this.e;
                if (nu8Var != null && nu8Var.g() >= 3000.0f) {
                    this.d.setImageResource(R.drawable.obfuscated_res_0x7f081235);
                } else {
                    this.d.setImageResource(R.drawable.obfuscated_res_0x7f080af3);
                }
            }
        }
    }

    public final void k(View view2, MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, view2, motionEvent) == null) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    return;
                }
                this.c.e();
            } else if (this.e.f() == 6) {
                this.e.m(1);
                f fVar = this.k;
                if (fVar != null) {
                    fVar.X();
                    this.k.l();
                }
                this.c.getTvTip().setText("");
                this.c.getTvTip().setVisibility(8);
            } else if (this.q.getVisibility() == 0) {
                m(null);
            } else {
                f fVar2 = this.k;
                if (fVar2 != null) {
                    fVar2.o();
                    this.c.c();
                }
            }
        }
    }

    public final void l(View view2, MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, view2, motionEvent) == null) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 1 || action == 3) {
                    if (this.l) {
                        this.l = false;
                        return;
                    }
                    this.g = false;
                    if (!this.e.j() && this.e.f() != 6) {
                        if (this.e.f() != 8) {
                            A(false);
                            return;
                        }
                        return;
                    }
                    TiebaStatic.log("c12298");
                    C();
                    return;
                }
                return;
            }
            f fVar = this.k;
            if (fVar != null) {
                fVar.n();
            }
            if (this.e.f() == 7 || this.e.f() == 6) {
                return;
            }
            nu8 nu8Var = this.e;
            if (nu8Var != null && nu8Var.i()) {
                this.l = true;
                CustomToast.newInstance().showToast(R.string.obfuscated_res_0x7f0f0b2a);
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            this.f = currentTimeMillis;
            this.g = true;
            this.r.postDelayed(new c(this, currentTimeMillis), 200L);
        }
    }

    public void m(ru8 ru8Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, ru8Var) == null) || this.q.getVisibility() == 8) {
            return;
        }
        o();
        this.d.setEnabled(true);
        this.a.setEnabled(true);
        if (this.e.f() != 6 && !this.e.j()) {
            j(this.e.f());
        } else {
            this.a.setVisibility(8);
            this.d.setVisibility(8);
        }
        for (int i = 0; i < this.j.size(); i++) {
            ObjectAnimator objectAnimator = this.j.get(i);
            if (objectAnimator != null) {
                objectAnimator.setDuration(500L);
                objectAnimator.cancel();
                objectAnimator.removeAllListeners();
                if (i == this.j.size() - 1) {
                    objectAnimator.addListener(new e(this, ru8Var));
                }
                objectAnimator.reverse();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void m0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            if (p() && this.q.getCurrentEffectLayout() == 1) {
                m(null);
                return;
            }
            if (!p()) {
                z();
            }
            this.q.m0();
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d0760, this);
            this.q = (VideoEffectLayout) findViewById(R.id.obfuscated_res_0x7f091268);
            this.b = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f091284);
            ImageView imageView = (ImageView) findViewById(R.id.obfuscated_res_0x7f09077c);
            this.a = imageView;
            imageView.setOnClickListener(this);
            VideoRecordButton videoRecordButton = (VideoRecordButton) findViewById(R.id.obfuscated_res_0x7f091285);
            this.c = videoRecordButton;
            videoRecordButton.setOnTouchListener(this);
            ImageView imageView2 = (ImageView) findViewById(R.id.obfuscated_res_0x7f0906b7);
            this.d = imageView2;
            imageView2.setOnClickListener(this);
            this.p.add(0, new ju8(3, getResources().getString(R.string.obfuscated_res_0x7f0f0b2b), new MusicData(com.baidu.tieba.external.music.data.MusicData.MUSIC_NORMAL_ID, 1, getResources().getString(R.string.obfuscated_res_0x7f0f0b2b)), R.drawable.obfuscated_res_0x7f080b08));
            this.p.add(1, new ju8(3, getResources().getString(R.string.obfuscated_res_0x7f0f0b29), new MusicData(com.baidu.tieba.external.music.data.MusicData.MUSIC_CLOUD_ID, 2, getResources().getString(R.string.obfuscated_res_0x7f0f0b29)), R.drawable.obfuscated_res_0x7f080af2));
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && ListUtils.isEmpty(this.j)) {
            ArrayList arrayList = new ArrayList();
            this.j = arrayList;
            arrayList.add(ObjectAnimator.ofFloat(this.q, Key.TRANSLATION_Y, 1000.0f, 0.0f));
            this.j.add(ObjectAnimator.ofFloat(this.b, Key.TRANSLATION_Y, 0.0f, qi.f(getContext(), R.dimen.obfuscated_res_0x7f07019a)));
            this.j.add(ObjectAnimator.ofFloat(this.c.getLayer3(), Key.SCALE_X, 0.766f, 0.585f));
            this.j.add(ObjectAnimator.ofFloat(this.c.getLayer3(), Key.SCALE_Y, 0.766f, 0.585f));
            this.j.add(ObjectAnimator.ofFloat(this.c.getLayer2(), Key.SCALE_X, 1.0f, 0.82f));
            this.j.add(ObjectAnimator.ofFloat(this.c.getLayer2(), Key.SCALE_Y, 1.0f, 0.82f));
            this.j.add(ObjectAnimator.ofFloat(this.d, Key.SCALE_X, 1.0f, 0.7f));
            this.j.add(ObjectAnimator.ofFloat(this.d, Key.SCALE_Y, 1.0f, 0.7f));
            this.j.add(ObjectAnimator.ofFloat(this.a, Key.SCALE_X, 1.0f, 0.7f));
            this.j.add(ObjectAnimator.ofFloat(this.a, Key.SCALE_Y, 1.0f, 0.7f));
            this.j.add(ObjectAnimator.ofFloat(this.d, Key.ALPHA, 1.0f, 0.0f));
            this.j.add(ObjectAnimator.ofFloat(this.a, Key.ALPHA, 1.0f, 0.0f));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, view2) == null) {
            if (view2 == this.a) {
                f fVar = this.k;
                if (fVar != null) {
                    fVar.n();
                }
                int f2 = this.e.f();
                nu8 nu8Var = this.e;
                if (nu8Var == null || nu8Var.g() <= 0 || f2 <= 2) {
                    return;
                }
                if (f2 == 5) {
                    TiebaStatic.log("c12299");
                    this.e.d();
                    v(this.m);
                    v(this.n);
                    v(this.o);
                    if (this.e.g() >= 3000.0f) {
                        j(4);
                        return;
                    } else {
                        j(this.e.g() > 0 ? 3 : 1);
                        return;
                    }
                }
                this.e.l();
                j(5);
            } else if (view2 == this.d) {
                TiebaStatic.log("c12300");
                nu8 nu8Var2 = this.e;
                if (nu8Var2 == null || nu8Var2.f() <= 2 || this.k == null) {
                    return;
                }
                if (this.e.g() >= 3000.0f) {
                    this.k.y0();
                } else {
                    this.k.I0();
                }
            }
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view2, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048594, this, view2, motionEvent)) == null) {
            int i = this.s;
            if (i == 1) {
                k(view2, motionEvent);
            } else if (i == 2) {
                l(view2, motionEvent);
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.q.getVisibility() == 0 : invokeV.booleanValue;
    }

    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            VideoEffectLayout videoEffectLayout = this.q;
            if (videoEffectLayout != null) {
                return videoEffectLayout.t();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.ws8
    public void q1(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048597, this, str, i, str2) == null) {
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            if (this.q.getVisibility() == 0) {
                m(null);
            }
            B(false);
            this.c.getLayer1().setVisibility(8);
            this.c.getTvTip().setText(getResources().getText(R.string.obfuscated_res_0x7f0f152f));
            this.c.getTvTip().setVisibility(0);
            f fVar = this.k;
            if (fVar != null) {
                fVar.q();
            }
        }
    }

    public void setCurrentTab(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i) == null) {
            this.s = i;
            if (i == 1) {
                this.a.setVisibility(4);
                this.d.setVisibility(4);
                this.c.getLayer1().setVisibility(8);
            } else if (i != 2) {
            } else {
                if (this.e.f() != 1) {
                    this.a.setVisibility(0);
                    this.d.setVisibility(0);
                }
                this.c.getLayer1().setVisibility(0);
            }
        }
    }

    public void setDownLoadSticker(StickerItem stickerItem) {
        VideoEffectLayout videoEffectLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048600, this, stickerItem) == null) || (videoEffectLayout = this.q) == null) {
            return;
        }
        videoEffectLayout.setDownLoadStrick(stickerItem);
    }

    public void setEffectChoosedListener(VideoEffectLayout.h hVar) {
        VideoEffectLayout videoEffectLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048601, this, hVar) == null) || (videoEffectLayout = this.q) == null) {
            return;
        }
        videoEffectLayout.setListener(hVar);
    }

    public void setHasLocalVideo(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
        }
    }

    @Override // com.repackage.ws8
    public void setMusicData(List<MusicData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, list) == null) {
            if (list != null && list.size() > 0) {
                for (MusicData musicData : list) {
                    this.p.add(new ju8(3, musicData.name, musicData, -1));
                }
            }
            VideoEffectLayout videoEffectLayout = this.q;
            if (videoEffectLayout != null) {
                videoEffectLayout.setMusicList(this.p);
            }
        }
    }

    public void setRecordControlListener(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, fVar) == null) {
            this.k = fVar;
        }
    }

    public void setRecordController(nu8 nu8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, nu8Var) == null) {
            this.e = nu8Var;
            j(1);
        }
    }

    public void setStickerItems(List<StickerItem> list) {
        VideoEffectLayout videoEffectLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048606, this, list) == null) || (videoEffectLayout = this.q) == null) {
            return;
        }
        videoEffectLayout.setStickerItems(list);
    }

    public void t() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048607, this) == null) && this.e.f() == 6) {
            if (this.s == 2) {
                j(7);
                this.c.setAlpha(1.0f);
                this.a.setVisibility(8);
                this.d.setVisibility(8);
                this.c.getTvTip().setText(getResources().getString(R.string.obfuscated_res_0x7f0f1530));
                nu8 nu8Var = this.e;
                if (nu8Var != null) {
                    nu8Var.n();
                    return;
                }
                return;
            }
            this.c.getTvTip().setVisibility(8);
            f fVar = this.k;
            if (fVar != null) {
                fVar.o();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            if (p() && this.q.getCurrentEffectLayout() == 0) {
                m(null);
                return;
            }
            if (!p()) {
                z();
            }
            this.q.u();
        }
    }

    public final void v(List list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048609, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        list.remove(list.size() - 1);
    }

    public void w() {
        VideoEffectLayout videoEffectLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048610, this) == null) || (videoEffectLayout = this.q) == null) {
            return;
        }
        videoEffectLayout.v();
    }

    public void x() {
        VideoEffectLayout videoEffectLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048611, this) == null) || (videoEffectLayout = this.q) == null) {
            return;
        }
        videoEffectLayout.w();
    }

    public void y(StickerItem stickerItem) {
        VideoEffectLayout videoEffectLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048612, this, stickerItem) == null) || (videoEffectLayout = this.q) == null) {
            return;
        }
        videoEffectLayout.x(stickerItem);
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048613, this) == null) || this.q.getVisibility() == 0) {
            return;
        }
        this.q.setVisibility(0);
        o();
        this.d.setEnabled(false);
        this.a.setEnabled(false);
        for (int i = 0; i < this.j.size(); i++) {
            ObjectAnimator objectAnimator = this.j.get(i);
            if (objectAnimator != null) {
                objectAnimator.cancel();
                objectAnimator.setDuration(500L);
                objectAnimator.removeAllListeners();
                if (i == this.j.size() - 1) {
                    objectAnimator.addListener(new d(this));
                }
                objectAnimator.start();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoControllerLayout(Context context, AttributeSet attributeSet) {
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
        this.f = 0L;
        this.g = false;
        this.m = new ArrayList();
        this.n = new ArrayList();
        this.o = new ArrayList();
        this.p = new ArrayList();
        this.r = new Handler();
        n();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoControllerLayout(Context context, AttributeSet attributeSet, int i) {
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
        this.f = 0L;
        this.g = false;
        this.m = new ArrayList();
        this.n = new ArrayList();
        this.o = new ArrayList();
        this.p = new ArrayList();
        this.r = new Handler();
        n();
    }
}
