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
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import c.a.p0.n4.l.h;
import c.a.p0.n4.l.l;
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
import com.tachikoma.core.component.anim.AnimationProperty;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class VideoControllerLayout extends RelativeLayout implements View.OnClickListener, View.OnTouchListener, VideoEffectButtonLayout.a, c.a.p0.n4.i.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView a;

    /* renamed from: b  reason: collision with root package name */
    public RelativeLayout f36511b;

    /* renamed from: c  reason: collision with root package name */
    public VideoRecordButton f36512c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f36513d;

    /* renamed from: e  reason: collision with root package name */
    public h f36514e;

    /* renamed from: f  reason: collision with root package name */
    public long f36515f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f36516g;

    /* renamed from: h  reason: collision with root package name */
    public AnimatorSet f36517h;
    public AnimatorSet i;
    public List<ObjectAnimator> j;
    public f k;
    public boolean l;
    public List<c.a.p0.n4.l.d> m;
    public List<c.a.p0.n4.l.d> n;
    public List<StickerItem> o;
    public List<c.a.p0.n4.l.d> p;
    public VideoEffectLayout q;
    public Handler r;
    public int s;

    /* loaded from: classes6.dex */
    public class a extends l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f36518b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ VideoControllerLayout f36519c;

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
            this.f36519c = videoControllerLayout;
            this.f36518b = z;
        }

        @Override // c.a.p0.n4.l.l, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                if (this.f36519c.f36514e.f() == 6 || this.f36519c.f36514e.j()) {
                    this.f36519c.B(this.f36518b);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ VideoControllerLayout f36520b;

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
            this.f36520b = videoControllerLayout;
        }

        @Override // c.a.p0.n4.l.l, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, animator) == null) || this.a) {
                return;
            }
            this.f36520b.a.setVisibility(8);
            this.f36520b.f36513d.setVisibility(8);
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ VideoControllerLayout f36521b;

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
            this.f36521b = videoControllerLayout;
            this.a = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f36521b.f36516g && this.f36521b.f36515f == this.a) {
                TiebaStatic.log("c12297");
                this.f36521b.A(true);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d extends l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ VideoControllerLayout f36522b;

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
            this.f36522b = videoControllerLayout;
        }

        @Override // c.a.p0.n4.l.l, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, animator) == null) || this.f36522b.k == null) {
                return;
            }
            this.f36522b.k.onShowEffectLayout();
        }
    }

    /* loaded from: classes6.dex */
    public class e extends l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ l f36523b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ VideoControllerLayout f36524c;

        public e(VideoControllerLayout videoControllerLayout, l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoControllerLayout, lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f36524c = videoControllerLayout;
            this.f36523b = lVar;
        }

        @Override // c.a.p0.n4.l.l, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, animator) == null) || this.a) {
                return;
            }
            this.f36524c.q.setVisibility(8);
            if (this.f36524c.k != null) {
                this.f36524c.k.onHideEffectLayout();
            }
            l lVar = this.f36523b;
            if (lVar != null) {
                lVar.onAnimationEnd(animator);
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface f {
        void hideMinVideoTips();

        void onCancelCountDowning();

        void onHideEffectLayout();

        void onRecordDone();

        void onRecordShort();

        void onShowEffectLayout();

        void onStartRecord();

        void onStatusChange();

        void onStopRecord();

        void onTakePhoto();
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
        this.f36515f = 0L;
        this.f36516g = false;
        this.m = new ArrayList();
        this.n = new ArrayList();
        this.o = new ArrayList();
        this.p = new ArrayList();
        this.r = new Handler();
        o();
    }

    public final void A(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            if (this.f36514e.e() >= 100) {
                f fVar = this.k;
                if (fVar != null) {
                    fVar.onRecordDone();
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
            k(2);
            if (this.q.getVisibility() == 0) {
                n(new a(this, z));
            } else {
                B(z);
            }
            h hVar = this.f36514e;
            if (hVar != null) {
                hVar.n();
            }
            f fVar2 = this.k;
            if (fVar2 != null) {
                fVar2.onStartRecord();
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
            if (this.f36517h == null) {
                AnimatorSet animatorSet2 = new AnimatorSet();
                this.f36517h = animatorSet2;
                animatorSet2.playTogether(ObjectAnimator.ofFloat(this.a, AnimationProperty.OPACITY, 1.0f, 0.0f), ObjectAnimator.ofFloat(this.f36513d, AnimationProperty.OPACITY, 1.0f, 0.0f));
                this.f36517h.addListener(new b(this));
                this.f36517h.setDuration(300L);
            }
            this.f36517h.start();
            if (this.f36514e.f() != 6) {
                this.f36512c.b(z);
            }
        }
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            D();
            int f2 = this.f36514e.f();
            h hVar = this.f36514e;
            if (hVar != null) {
                if (!hVar.h() && this.f36514e.j()) {
                    this.f36514e.o();
                }
                E();
            }
            f fVar = this.k;
            if (fVar != null) {
                fVar.onStopRecord();
                if (f2 == 6) {
                    this.k.onCancelCountDowning();
                }
            }
        }
    }

    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            h hVar = this.f36514e;
            if (hVar == null || hVar.j() || this.f36514e.f() == 6) {
                AnimatorSet animatorSet = this.f36517h;
                if (animatorSet != null && animatorSet.isRunning()) {
                    this.f36517h.cancel();
                }
                if (this.i == null) {
                    AnimatorSet animatorSet2 = new AnimatorSet();
                    this.i = animatorSet2;
                    animatorSet2.playTogether(ObjectAnimator.ofFloat(this.a, AnimationProperty.OPACITY, 0.0f, 1.0f), ObjectAnimator.ofFloat(this.f36513d, AnimationProperty.OPACITY, 0.0f, 1.0f));
                    this.i.setDuration(300L);
                }
                this.a.setVisibility(0);
                this.f36513d.setVisibility(0);
                this.i.start();
                if (this.f36514e.f() != 7 && this.f36514e.f() != 6) {
                    this.f36512c.d();
                    return;
                }
                this.f36512c.getTvTip().setVisibility(8);
                if (this.s == 2) {
                    this.f36512c.getLayer1().setVisibility(0);
                }
            }
        }
    }

    public void E() {
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (hVar = this.f36514e) == null) {
            return;
        }
        if (hVar.g() >= 3000.0f) {
            k(4);
        } else if (this.f36514e.g() > 0) {
            k(3);
        } else {
            k(1);
        }
    }

    public List<c.a.p0.n4.l.d> getChoosedBeautyList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.m : (List) invokeV.objValue;
    }

    public List<c.a.p0.n4.l.d> getChoosedFilterList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.n : (List) invokeV.objValue;
    }

    public List<StickerItem> getChoosedStickerList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.o : (List) invokeV.objValue;
    }

    public void k(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.f36514e.m(i);
            f fVar = this.k;
            if (fVar != null) {
                fVar.onStatusChange();
            }
            if (i == 1) {
                this.a.setVisibility(8);
                this.f36513d.setVisibility(8);
            } else if (i == 3) {
                this.a.setImageResource(R.drawable.obfuscated_res_0x7f081225);
                this.f36513d.setImageResource(R.drawable.obfuscated_res_0x7f080aae);
            } else if (i == 4) {
                this.a.setImageResource(R.drawable.obfuscated_res_0x7f081225);
                this.f36513d.setImageResource(R.drawable.obfuscated_res_0x7f081228);
            } else if (i == 5) {
                this.a.setImageResource(R.drawable.obfuscated_res_0x7f081229);
                h hVar = this.f36514e;
                if (hVar != null && hVar.g() >= 3000.0f) {
                    this.f36513d.setImageResource(R.drawable.obfuscated_res_0x7f081228);
                } else {
                    this.f36513d.setImageResource(R.drawable.obfuscated_res_0x7f080aae);
                }
            }
        }
    }

    public final void l(View view, MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, view, motionEvent) == null) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    return;
                }
                this.f36512c.e();
            } else if (this.f36514e.f() == 6) {
                this.f36514e.m(1);
                f fVar = this.k;
                if (fVar != null) {
                    fVar.onCancelCountDowning();
                    this.k.onStopRecord();
                }
                this.f36512c.getTvTip().setText("");
                this.f36512c.getTvTip().setVisibility(8);
            } else if (this.q.getVisibility() == 0) {
                n(null);
            } else {
                f fVar2 = this.k;
                if (fVar2 != null) {
                    fVar2.onTakePhoto();
                    this.f36512c.c();
                }
            }
        }
    }

    public final void m(View view, MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, view, motionEvent) == null) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 1 || action == 3) {
                    if (this.l) {
                        this.l = false;
                        return;
                    }
                    this.f36516g = false;
                    if (!this.f36514e.j() && this.f36514e.f() != 6) {
                        if (this.f36514e.f() != 8) {
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
                fVar.hideMinVideoTips();
            }
            if (this.f36514e.f() == 7 || this.f36514e.f() == 6) {
                return;
            }
            h hVar = this.f36514e;
            if (hVar != null && hVar.i()) {
                this.l = true;
                CustomToast.newInstance().showToast(R.string.obfuscated_res_0x7f0f0b0d);
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            this.f36515f = currentTimeMillis;
            this.f36516g = true;
            this.r.postDelayed(new c(this, currentTimeMillis), 200L);
        }
    }

    public void n(l lVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, lVar) == null) || this.q.getVisibility() == 8) {
            return;
        }
        p();
        this.f36513d.setEnabled(true);
        this.a.setEnabled(true);
        if (this.f36514e.f() != 6 && !this.f36514e.j()) {
            k(this.f36514e.f());
        } else {
            this.a.setVisibility(8);
            this.f36513d.setVisibility(8);
        }
        for (int i = 0; i < this.j.size(); i++) {
            ObjectAnimator objectAnimator = this.j.get(i);
            if (objectAnimator != null) {
                objectAnimator.setDuration(500L);
                objectAnimator.cancel();
                objectAnimator.removeAllListeners();
                if (i == this.j.size() - 1) {
                    objectAnimator.addListener(new e(this, lVar));
                }
                objectAnimator.reverse();
            }
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d0732, this);
            this.q = (VideoEffectLayout) findViewById(R.id.obfuscated_res_0x7f0911d6);
            this.f36511b = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f0911f2);
            ImageView imageView = (ImageView) findViewById(R.id.obfuscated_res_0x7f090776);
            this.a = imageView;
            imageView.setOnClickListener(this);
            VideoRecordButton videoRecordButton = (VideoRecordButton) findViewById(R.id.obfuscated_res_0x7f0911f3);
            this.f36512c = videoRecordButton;
            videoRecordButton.setOnTouchListener(this);
            ImageView imageView2 = (ImageView) findViewById(R.id.obfuscated_res_0x7f0906c3);
            this.f36513d = imageView2;
            imageView2.setOnClickListener(this);
            this.p.add(0, new c.a.p0.n4.l.d(3, getResources().getString(R.string.obfuscated_res_0x7f0f0b0e), new MusicData(com.baidu.tieba.external.music.data.MusicData.MUSIC_NORMAL_ID, 1, getResources().getString(R.string.obfuscated_res_0x7f0f0b0e)), R.drawable.obfuscated_res_0x7f080ac2));
            this.p.add(1, new c.a.p0.n4.l.d(3, getResources().getString(R.string.obfuscated_res_0x7f0f0b0c), new MusicData(com.baidu.tieba.external.music.data.MusicData.MUSIC_CLOUD_ID, 2, getResources().getString(R.string.obfuscated_res_0x7f0f0b0c)), R.drawable.obfuscated_res_0x7f080aad));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, view) == null) {
            if (view == this.a) {
                f fVar = this.k;
                if (fVar != null) {
                    fVar.hideMinVideoTips();
                }
                int f2 = this.f36514e.f();
                h hVar = this.f36514e;
                if (hVar == null || hVar.g() <= 0 || f2 <= 2) {
                    return;
                }
                if (f2 == 5) {
                    TiebaStatic.log("c12299");
                    this.f36514e.d();
                    u(this.m);
                    u(this.n);
                    u(this.o);
                    if (this.f36514e.g() >= 3000.0f) {
                        k(4);
                        return;
                    } else {
                        k(this.f36514e.g() > 0 ? 3 : 1);
                        return;
                    }
                }
                this.f36514e.l();
                k(5);
            } else if (view == this.f36513d) {
                TiebaStatic.log("c12300");
                h hVar2 = this.f36514e;
                if (hVar2 == null || hVar2.f() <= 2 || this.k == null) {
                    return;
                }
                if (this.f36514e.g() >= 3000.0f) {
                    this.k.onRecordDone();
                } else {
                    this.k.onRecordShort();
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void onClickBeauty() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            if (q() && this.q.getCurrentEffectLayout() == 1) {
                n(null);
                return;
            }
            if (!q()) {
                z();
            }
            this.q.onClickBeauty();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void onClickFilter() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            if (q() && this.q.getCurrentEffectLayout() == 2) {
                n(null);
                return;
            }
            if (!q()) {
                z();
            }
            this.q.onClickFilter();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void onClickMusic() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            if (q() && this.q.getCurrentEffectLayout() == 3) {
                n(null);
                return;
            }
            if (!q()) {
                z();
            }
            this.q.onClickMusic();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void onClickSticker() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            if (q() && this.q.getCurrentEffectLayout() == 0) {
                n(null);
                return;
            }
            if (!q()) {
                z();
            }
            this.q.onClickSticker();
        }
    }

    @Override // c.a.p0.n4.i.b
    public void onSaveMusicVideo(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048594, this, str, i, str2) == null) {
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048595, this, view, motionEvent)) == null) {
            int i = this.s;
            if (i == 1) {
                l(view, motionEvent);
            } else if (i == 2) {
                m(view, motionEvent);
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && ListUtils.isEmpty(this.j)) {
            ArrayList arrayList = new ArrayList();
            this.j = arrayList;
            arrayList.add(ObjectAnimator.ofFloat(this.q, AnimationProperty.TRANSLATE_Y, 1000.0f, 0.0f));
            this.j.add(ObjectAnimator.ofFloat(this.f36511b, AnimationProperty.TRANSLATE_Y, 0.0f, n.f(getContext(), R.dimen.obfuscated_res_0x7f07019a)));
            this.j.add(ObjectAnimator.ofFloat(this.f36512c.getLayer3(), AnimationProperty.SCALE_X, 0.766f, 0.585f));
            this.j.add(ObjectAnimator.ofFloat(this.f36512c.getLayer3(), AnimationProperty.SCALE_Y, 0.766f, 0.585f));
            this.j.add(ObjectAnimator.ofFloat(this.f36512c.getLayer2(), AnimationProperty.SCALE_X, 1.0f, 0.82f));
            this.j.add(ObjectAnimator.ofFloat(this.f36512c.getLayer2(), AnimationProperty.SCALE_Y, 1.0f, 0.82f));
            this.j.add(ObjectAnimator.ofFloat(this.f36513d, AnimationProperty.SCALE_X, 1.0f, 0.7f));
            this.j.add(ObjectAnimator.ofFloat(this.f36513d, AnimationProperty.SCALE_Y, 1.0f, 0.7f));
            this.j.add(ObjectAnimator.ofFloat(this.a, AnimationProperty.SCALE_X, 1.0f, 0.7f));
            this.j.add(ObjectAnimator.ofFloat(this.a, AnimationProperty.SCALE_Y, 1.0f, 0.7f));
            this.j.add(ObjectAnimator.ofFloat(this.f36513d, AnimationProperty.OPACITY, 1.0f, 0.0f));
            this.j.add(ObjectAnimator.ofFloat(this.a, AnimationProperty.OPACITY, 1.0f, 0.0f));
        }
    }

    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.q.getVisibility() == 0 : invokeV.booleanValue;
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            VideoEffectLayout videoEffectLayout = this.q;
            if (videoEffectLayout != null) {
                return videoEffectLayout.t();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            if (this.q.getVisibility() == 0) {
                n(null);
            }
            B(false);
            this.f36512c.getLayer1().setVisibility(8);
            this.f36512c.getTvTip().setText(getResources().getText(R.string.obfuscated_res_0x7f0f14eb));
            this.f36512c.getTvTip().setVisibility(0);
            f fVar = this.k;
            if (fVar != null) {
                fVar.onStartRecord();
            }
        }
    }

    public void setCurrentTab(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i) == null) {
            this.s = i;
            if (i == 1) {
                this.a.setVisibility(4);
                this.f36513d.setVisibility(4);
                this.f36512c.getLayer1().setVisibility(8);
            } else if (i != 2) {
            } else {
                if (this.f36514e.f() != 1) {
                    this.a.setVisibility(0);
                    this.f36513d.setVisibility(0);
                }
                this.f36512c.getLayer1().setVisibility(0);
            }
        }
    }

    public void setDownLoadSticker(StickerItem stickerItem) {
        VideoEffectLayout videoEffectLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048601, this, stickerItem) == null) || (videoEffectLayout = this.q) == null) {
            return;
        }
        videoEffectLayout.setDownLoadStrick(stickerItem);
    }

    public void setEffectChoosedListener(VideoEffectLayout.h hVar) {
        VideoEffectLayout videoEffectLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048602, this, hVar) == null) || (videoEffectLayout = this.q) == null) {
            return;
        }
        videoEffectLayout.setListener(hVar);
    }

    public void setHasLocalVideo(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
        }
    }

    @Override // c.a.p0.n4.i.b
    public void setMusicData(List<MusicData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, list) == null) {
            if (list != null && list.size() > 0) {
                for (MusicData musicData : list) {
                    this.p.add(new c.a.p0.n4.l.d(3, musicData.name, musicData, -1));
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
        if (interceptable == null || interceptable.invokeL(1048605, this, fVar) == null) {
            this.k = fVar;
        }
    }

    public void setRecordController(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, hVar) == null) {
            this.f36514e = hVar;
            k(1);
        }
    }

    public void setStickerItems(List<StickerItem> list) {
        VideoEffectLayout videoEffectLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048607, this, list) == null) || (videoEffectLayout = this.q) == null) {
            return;
        }
        videoEffectLayout.setStickerItems(list);
    }

    public void t() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048608, this) == null) && this.f36514e.f() == 6) {
            if (this.s == 2) {
                k(7);
                this.f36512c.setAlpha(1.0f);
                this.a.setVisibility(8);
                this.f36513d.setVisibility(8);
                this.f36512c.getTvTip().setText(getResources().getString(R.string.obfuscated_res_0x7f0f14ec));
                h hVar = this.f36514e;
                if (hVar != null) {
                    hVar.n();
                    return;
                }
                return;
            }
            this.f36512c.getTvTip().setVisibility(8);
            f fVar = this.k;
            if (fVar != null) {
                fVar.onTakePhoto();
            }
        }
    }

    public final void u(List list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048609, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        list.remove(list.size() - 1);
    }

    public void v() {
        VideoEffectLayout videoEffectLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048610, this) == null) || (videoEffectLayout = this.q) == null) {
            return;
        }
        videoEffectLayout.u();
    }

    public void w() {
        VideoEffectLayout videoEffectLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048611, this) == null) || (videoEffectLayout = this.q) == null) {
            return;
        }
        videoEffectLayout.v();
    }

    public void x(StickerItem stickerItem) {
        VideoEffectLayout videoEffectLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048612, this, stickerItem) == null) || (videoEffectLayout = this.q) == null) {
            return;
        }
        videoEffectLayout.w(stickerItem);
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048613, this) == null) || this.q.getVisibility() == 0) {
            return;
        }
        this.q.setVisibility(0);
        p();
        this.f36513d.setEnabled(false);
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
        this.f36515f = 0L;
        this.f36516g = false;
        this.m = new ArrayList();
        this.n = new ArrayList();
        this.o = new ArrayList();
        this.p = new ArrayList();
        this.r = new Handler();
        o();
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
        this.f36515f = 0L;
        this.f36516g = false;
        this.m = new ArrayList();
        this.n = new ArrayList();
        this.o = new ArrayList();
        this.p = new ArrayList();
        this.r = new Handler();
        o();
    }
}
