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
import com.baidu.tieba.fj;
import com.baidu.tieba.gx8;
import com.baidu.tieba.kx8;
import com.baidu.tieba.ox8;
import com.baidu.tieba.tv8;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.record.VideoEffectButtonLayout;
import com.baidu.tieba.video.record.VideoEffectLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public class VideoControllerLayout extends RelativeLayout implements View.OnClickListener, View.OnTouchListener, VideoEffectButtonLayout.a, tv8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView a;
    public RelativeLayout b;
    public VideoRecordButton c;
    public ImageView d;
    public kx8 e;
    public long f;
    public boolean g;
    public AnimatorSet h;
    public AnimatorSet i;
    public List j;
    public f k;
    public boolean l;
    public List m;
    public List n;
    public List o;
    public List p;
    public VideoEffectLayout q;
    public Handler r;
    public int s;

    /* loaded from: classes6.dex */
    public interface f {
        void H0();

        void P();

        void Z();

        void k();

        void l();

        void o();

        void p();

        void r();

        void s0();

        void y0();
    }

    @Override // com.baidu.tieba.tv8
    public void p1(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048596, this, str, i, str2) == null) {
        }
    }

    public void setHasLocalVideo(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class a extends ox8 {
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

        @Override // com.baidu.tieba.ox8, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                if (this.c.e.f() != 6 && !this.c.e.j()) {
                    return;
                }
                this.c.B(this.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends ox8 {
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

        @Override // com.baidu.tieba.ox8, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, animator) == null) && !this.a) {
                this.b.a.setVisibility(8);
                this.b.d.setVisibility(8);
            }
        }
    }

    /* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
    public class d extends ox8 {
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

        @Override // com.baidu.tieba.ox8, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, animator) == null) && this.b.k != null) {
                this.b.k.k();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e extends ox8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ox8 b;
        public final /* synthetic */ VideoControllerLayout c;

        public e(VideoControllerLayout videoControllerLayout, ox8 ox8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoControllerLayout, ox8Var};
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
            this.b = ox8Var;
        }

        @Override // com.baidu.tieba.ox8, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, animator) != null) || this.a) {
                return;
            }
            this.c.q.setVisibility(8);
            if (this.c.k != null) {
                this.c.k.s0();
            }
            ox8 ox8Var = this.b;
            if (ox8Var != null) {
                ox8Var.onAnimationEnd(animator);
            }
        }
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

    public void setCurrentTab(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i) == null) {
            this.s = i;
            if (i != 1) {
                if (i == 2) {
                    if (this.e.f() != 1) {
                        this.a.setVisibility(0);
                        this.d.setVisibility(0);
                    }
                    this.c.getLayer1().setVisibility(0);
                    return;
                }
                return;
            }
            this.a.setVisibility(4);
            this.d.setVisibility(4);
            this.c.getLayer1().setVisibility(8);
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

    public final void k(View view2, MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, view2, motionEvent) == null) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 1) {
                    this.c.e();
                }
            } else if (this.e.f() == 6) {
                this.e.m(1);
                f fVar = this.k;
                if (fVar != null) {
                    fVar.Z();
                    this.k.l();
                }
                this.c.getTvTip().setText("");
                this.c.getTvTip().setVisibility(8);
            } else if (this.q.getVisibility() == 0) {
                m(null);
            } else {
                f fVar2 = this.k;
                if (fVar2 != null) {
                    fVar2.p();
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
                fVar.o();
            }
            if (this.e.f() != 7 && this.e.f() != 6) {
                kx8 kx8Var = this.e;
                if (kx8Var != null && kx8Var.i()) {
                    this.l = true;
                    CustomToast.newInstance().showToast(R.string.obfuscated_res_0x7f0f0b52);
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                this.f = currentTimeMillis;
                this.g = true;
                this.r.postDelayed(new c(this, currentTimeMillis), 200L);
            }
        }
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

    public void setDownLoadSticker(StickerItem stickerItem) {
        VideoEffectLayout videoEffectLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048600, this, stickerItem) == null) && (videoEffectLayout = this.q) != null) {
            videoEffectLayout.setDownLoadStrick(stickerItem);
        }
    }

    public void setEffectChoosedListener(VideoEffectLayout.h hVar) {
        VideoEffectLayout videoEffectLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048601, this, hVar) == null) && (videoEffectLayout = this.q) != null) {
            videoEffectLayout.setListener(hVar);
        }
    }

    public void setRecordControlListener(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, fVar) == null) {
            this.k = fVar;
        }
    }

    public void setRecordController(kx8 kx8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, kx8Var) == null) {
            this.e = kx8Var;
            j(1);
        }
    }

    public void setStickerItems(List list) {
        VideoEffectLayout videoEffectLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048606, this, list) == null) && (videoEffectLayout = this.q) != null) {
            videoEffectLayout.setStickerItems(list);
        }
    }

    public final void u(List list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048608, this, list) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        list.remove(list.size() - 1);
    }

    public void y(StickerItem stickerItem) {
        VideoEffectLayout videoEffectLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048612, this, stickerItem) == null) && (videoEffectLayout = this.q) != null) {
            videoEffectLayout.x(stickerItem);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view2, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048594, this, view2, motionEvent)) == null) {
            int i = this.s;
            if (i != 1) {
                if (i == 2) {
                    l(view2, motionEvent);
                }
            } else {
                k(view2, motionEvent);
            }
            return true;
        }
        return invokeLL.booleanValue;
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
            kx8 kx8Var = this.e;
            if (kx8Var != null) {
                kx8Var.n();
            }
            f fVar2 = this.k;
            if (fVar2 != null) {
                fVar2.r();
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

    public void j(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            this.e.m(i);
            f fVar = this.k;
            if (fVar != null) {
                fVar.P();
            }
            if (i == 1) {
                this.a.setVisibility(8);
                this.d.setVisibility(8);
            } else if (i == 3) {
                this.a.setImageResource(R.drawable.obfuscated_res_0x7f081288);
                this.d.setImageResource(R.drawable.obfuscated_res_0x7f080b23);
            } else if (i == 4) {
                this.a.setImageResource(R.drawable.obfuscated_res_0x7f081288);
                this.d.setImageResource(R.drawable.obfuscated_res_0x7f08128b);
            } else if (i == 5) {
                this.a.setImageResource(R.drawable.obfuscated_res_0x7f08128c);
                kx8 kx8Var = this.e;
                if (kx8Var != null && kx8Var.g() >= 3000.0f) {
                    this.d.setImageResource(R.drawable.obfuscated_res_0x7f08128b);
                } else {
                    this.d.setImageResource(R.drawable.obfuscated_res_0x7f080b23);
                }
            }
        }
    }

    public void m(ox8 ox8Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048589, this, ox8Var) != null) || this.q.getVisibility() == 8) {
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
            ObjectAnimator objectAnimator = (ObjectAnimator) this.j.get(i);
            if (objectAnimator != null) {
                objectAnimator.setDuration(500L);
                objectAnimator.cancel();
                objectAnimator.removeAllListeners();
                if (i == this.j.size() - 1) {
                    objectAnimator.addListener(new e(this, ox8Var));
                }
                objectAnimator.reverse();
            }
        }
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            D();
            int f2 = this.e.f();
            kx8 kx8Var = this.e;
            if (kx8Var != null) {
                if (!kx8Var.h() && this.e.j()) {
                    this.e.o();
                }
                E();
            }
            f fVar = this.k;
            if (fVar != null) {
                fVar.l();
                if (f2 == 6) {
                    this.k.Z();
                }
            }
        }
    }

    public void E() {
        kx8 kx8Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048580, this) != null) || (kx8Var = this.e) == null) {
            return;
        }
        if (kx8Var.g() >= 3000.0f) {
            j(4);
        } else if (this.e.g() > 0) {
            j(3);
        } else {
            j(1);
        }
    }

    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            kx8 kx8Var = this.e;
            if (kx8Var != null && !kx8Var.j() && this.e.f() != 6) {
                return;
            }
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

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d077d, this);
            this.q = (VideoEffectLayout) findViewById(R.id.obfuscated_res_0x7f09127c);
            this.b = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f091298);
            ImageView imageView = (ImageView) findViewById(R.id.obfuscated_res_0x7f09079d);
            this.a = imageView;
            imageView.setOnClickListener(this);
            VideoRecordButton videoRecordButton = (VideoRecordButton) findViewById(R.id.obfuscated_res_0x7f091299);
            this.c = videoRecordButton;
            videoRecordButton.setOnTouchListener(this);
            ImageView imageView2 = (ImageView) findViewById(R.id.obfuscated_res_0x7f0906d6);
            this.d = imageView2;
            imageView2.setOnClickListener(this);
            this.p.add(0, new gx8(3, getResources().getString(R.string.obfuscated_res_0x7f0f0b53), new MusicData(com.baidu.tieba.external.music.data.MusicData.MUSIC_NORMAL_ID, 1, getResources().getString(R.string.obfuscated_res_0x7f0f0b53)), R.drawable.obfuscated_res_0x7f080b38));
            this.p.add(1, new gx8(3, getResources().getString(R.string.obfuscated_res_0x7f0f0b51), new MusicData(com.baidu.tieba.external.music.data.MusicData.MUSIC_CLOUD_ID, 2, getResources().getString(R.string.obfuscated_res_0x7f0f0b51)), R.drawable.obfuscated_res_0x7f080b22));
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void E0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (p() && this.q.getCurrentEffectLayout() == 3) {
                m(null);
                return;
            }
            if (!p()) {
                z();
            }
            this.q.E0();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void T0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (p() && this.q.getCurrentEffectLayout() == 2) {
                m(null);
                return;
            }
            if (!p()) {
                z();
            }
            this.q.T0();
        }
    }

    public List getChoosedBeautyList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.m;
        }
        return (List) invokeV.objValue;
    }

    public List getChoosedFilterList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.n;
        }
        return (List) invokeV.objValue;
    }

    public List getChoosedStickerList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.o;
        }
        return (List) invokeV.objValue;
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

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            if (this.q.getVisibility() == 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            VideoEffectLayout videoEffectLayout = this.q;
            if (videoEffectLayout != null) {
                return videoEffectLayout.t();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            if (p() && this.q.getCurrentEffectLayout() == 0) {
                m(null);
                return;
            }
            if (!p()) {
                z();
            }
            this.q.v();
        }
    }

    public void w() {
        VideoEffectLayout videoEffectLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048610, this) == null) && (videoEffectLayout = this.q) != null) {
            videoEffectLayout.u();
        }
    }

    public void x() {
        VideoEffectLayout videoEffectLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048611, this) == null) && (videoEffectLayout = this.q) != null) {
            videoEffectLayout.w();
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && ListUtils.isEmpty(this.j)) {
            ArrayList arrayList = new ArrayList();
            this.j = arrayList;
            arrayList.add(ObjectAnimator.ofFloat(this.q, Key.TRANSLATION_Y, 1000.0f, 0.0f));
            this.j.add(ObjectAnimator.ofFloat(this.b, Key.TRANSLATION_Y, 0.0f, fj.f(getContext(), R.dimen.obfuscated_res_0x7f07019a)));
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
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, view2) == null) {
            if (view2 == this.a) {
                f fVar = this.k;
                if (fVar != null) {
                    fVar.o();
                }
                int f2 = this.e.f();
                kx8 kx8Var = this.e;
                if (kx8Var != null && kx8Var.g() > 0 && f2 > 2) {
                    if (f2 == 5) {
                        TiebaStatic.log("c12299");
                        this.e.d();
                        u(this.m);
                        u(this.n);
                        u(this.o);
                        if (this.e.g() >= 3000.0f) {
                            j(4);
                            return;
                        }
                        if (this.e.g() > 0) {
                            i = 3;
                        } else {
                            i = 1;
                        }
                        j(i);
                        return;
                    }
                    this.e.l();
                    j(5);
                }
            } else if (view2 == this.d) {
                TiebaStatic.log("c12300");
                kx8 kx8Var2 = this.e;
                if (kx8Var2 != null && kx8Var2.f() > 2 && this.k != null) {
                    if (this.e.g() >= 3000.0f) {
                        this.k.y0();
                    } else {
                        this.k.H0();
                    }
                }
            }
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
            this.c.getTvTip().setText(getResources().getText(R.string.obfuscated_res_0x7f0f156d));
            this.c.getTvTip().setVisibility(0);
            f fVar = this.k;
            if (fVar != null) {
                fVar.r();
            }
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048607, this) == null) && this.e.f() == 6) {
            if (this.s == 2) {
                j(7);
                this.c.setAlpha(1.0f);
                this.a.setVisibility(8);
                this.d.setVisibility(8);
                this.c.getTvTip().setText(getResources().getString(R.string.obfuscated_res_0x7f0f156e));
                kx8 kx8Var = this.e;
                if (kx8Var != null) {
                    kx8Var.n();
                    return;
                }
                return;
            }
            this.c.getTvTip().setVisibility(8);
            f fVar = this.k;
            if (fVar != null) {
                fVar.p();
            }
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048613, this) != null) || this.q.getVisibility() == 0) {
            return;
        }
        this.q.setVisibility(0);
        o();
        this.d.setEnabled(false);
        this.a.setEnabled(false);
        for (int i = 0; i < this.j.size(); i++) {
            ObjectAnimator objectAnimator = (ObjectAnimator) this.j.get(i);
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

    @Override // com.baidu.tieba.tv8
    public void setMusicData(List list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, list) == null) {
            if (list != null && list.size() > 0) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    MusicData musicData = (MusicData) it.next();
                    this.p.add(new gx8(3, musicData.name, musicData, -1));
                }
            }
            VideoEffectLayout videoEffectLayout = this.q;
            if (videoEffectLayout != null) {
                videoEffectLayout.setMusicList(this.p);
            }
        }
    }
}
