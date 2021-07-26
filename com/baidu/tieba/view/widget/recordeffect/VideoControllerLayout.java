package com.baidu.tieba.view.widget.recordeffect;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.CustomToast;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.data.QmFilterItem;
import com.baidu.tbadk.data.TbMusicData;
import com.baidu.tieba.R;
import com.baidu.tieba.external.music.data.MusicData;
import com.baidu.tieba.external.sticker.data.QmStickerItem;
import com.baidu.tieba.view.widget.CaptureRecordButton;
import com.baidu.tieba.view.widget.recordeffect.RecordEffectLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.p0.b1.k0;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class VideoControllerLayout extends RelativeLayout implements View.OnTouchListener, d.a.q0.n0.c.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public RelativeLayout f22680e;

    /* renamed from: f  reason: collision with root package name */
    public CaptureRecordButton f22681f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f22682g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.q0.f0.c.a f22683h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.q0.n0.c.a f22684i;
    public d.a.q0.y.a.a j;
    public long k;
    public boolean l;
    public List<ObjectAnimator> m;
    public e n;
    public boolean o;
    public boolean p;
    public List<d.a.q0.z3.m.e.c.b> q;
    public List<d.a.q0.z3.m.e.c.b> r;
    public List<QmStickerItem> s;
    public List<d.a.q0.z3.m.e.c.b> t;
    public RecordEffectLayout u;
    public Handler v;
    public int w;

    /* loaded from: classes4.dex */
    public class a extends d.a.q0.z3.m.e.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ VideoControllerLayout f22685f;

        public a(VideoControllerLayout videoControllerLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoControllerLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22685f = videoControllerLayout;
        }

        @Override // d.a.q0.z3.m.e.a, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                super.onAnimationEnd(animator);
                if ((this.f22685f.f22683h == null || !this.f22685f.f22683h.c()) && this.f22685f.n != null) {
                    this.f22685f.n.onStartRecord();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f22686e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ VideoControllerLayout f22687f;

        public b(VideoControllerLayout videoControllerLayout, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoControllerLayout, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22687f = videoControllerLayout;
            this.f22686e = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f22687f.l && this.f22687f.k == this.f22686e) {
                this.f22687f.p = true;
                this.f22687f.B();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends d.a.q0.z3.m.e.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ VideoControllerLayout f22688f;

        public c(VideoControllerLayout videoControllerLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoControllerLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22688f = videoControllerLayout;
        }

        @Override // d.a.q0.z3.m.e.a, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, animator) == null) || this.f22688f.n == null) {
                return;
            }
            this.f22688f.n.onShowEffectLayout();
        }
    }

    /* loaded from: classes4.dex */
    public class d extends d.a.q0.z3.m.e.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f22689f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.z3.m.e.a f22690g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ VideoControllerLayout f22691h;

        public d(VideoControllerLayout videoControllerLayout, boolean z, d.a.q0.z3.m.e.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoControllerLayout, Boolean.valueOf(z), aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22691h = videoControllerLayout;
            this.f22689f = z;
            this.f22690g = aVar;
        }

        @Override // d.a.q0.z3.m.e.a, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, animator) == null) || this.f67620e) {
                return;
            }
            this.f22691h.u.setVisibility(8);
            if (this.f22691h.j == null || this.f22691h.j.getProgress() <= 0.0f) {
                this.f22691h.f22682g.setVisibility(8);
            } else {
                this.f22691h.f22682g.setVisibility(0);
            }
            if (this.f22691h.n != null) {
                this.f22691h.n.a(this.f22689f);
            }
            d.a.q0.z3.m.e.a aVar = this.f22690g;
            if (aVar != null) {
                aVar.onAnimationEnd(animator);
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface e {
        void a(boolean z);

        void hideMinVideoTips();

        void onShowEffectLayout();

        void onStartRecord();

        void onStopRecord();

        void onTakePhoto();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public VideoControllerLayout(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.u.getVisibility() == 0) {
            return;
        }
        this.u.setVisibility(0);
        this.f22682g.setVisibility(8);
        o();
        for (int i2 = 0; i2 < this.m.size(); i2++) {
            ObjectAnimator objectAnimator = this.m.get(i2);
            if (objectAnimator != null) {
                objectAnimator.cancel();
                objectAnimator.setDuration(320L);
                objectAnimator.removeAllListeners();
                if (i2 == this.m.size() - 1) {
                    objectAnimator.addListener(new c(this));
                }
                objectAnimator.start();
            }
        }
        d.a.q0.y.a.a aVar = this.j;
        if (aVar != null && aVar.getProgress() > 0.0f) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f22681f.getLayer2(), "alpha", 0.0f, 1.0f);
            ofFloat.setDuration(320L);
            ofFloat.start();
            ObjectAnimator.ofFloat(this.f22681f.getLayer1(), "scaleX", 0.388f, 0.276f).setDuration(320L).start();
            ObjectAnimator.ofFloat(this.f22681f.getLayer1(), "scaleY", 0.388f, 0.276f).setDuration(320L).start();
            return;
        }
        ObjectAnimator.ofFloat(this.f22681f.getLayer1(), "scaleX", 1.0f, 0.681f).setDuration(320L).start();
        ObjectAnimator.ofFloat(this.f22681f.getLayer1(), "scaleY", 1.0f, 0.681f).setDuration(320L).start();
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            d.a.q0.f0.c.a aVar = this.f22683h;
            if (aVar == null || !aVar.c()) {
                d.a.q0.y.a.a aVar2 = this.j;
                if (aVar2 != null && aVar2.getProgress() > 0.0f) {
                    this.f22681f.g();
                }
                if (this.u.getCurrentBeautyItem() != null) {
                    this.q.add(this.u.getCurrentBeautyItem());
                }
                if (this.u.getCurrentFilterItem() != null) {
                    this.r.add(this.u.getCurrentFilterItem());
                }
                if (this.u.getCurrentStickItem() != null) {
                    this.s.add(this.u.getCurrentStickItem());
                }
                if (this.u.getVisibility() == 0) {
                    m(new a(this), true);
                    return;
                }
                e eVar = this.n;
                if (eVar != null) {
                    eVar.onStartRecord();
                }
            }
        }
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f22682g.setVisibility(0);
            this.f22681f.h(this.p);
        }
    }

    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            d.a.q0.f0.c.a aVar = this.f22683h;
            if (aVar != null && !aVar.c()) {
                d.a.q0.y.a.a aVar2 = this.j;
                if (aVar2 == null || aVar2.getProgress() < this.j.getMaxDuration()) {
                    return;
                }
                this.f22681f.f();
                return;
            }
            d.a.q0.y.a.a aVar3 = this.j;
            if (aVar3 != null && aVar3.getProgress() > 0.0f) {
                this.f22681f.f();
            }
            e eVar = this.n;
            if (eVar != null) {
                eVar.onStopRecord();
            }
        }
    }

    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f22681f.j();
            this.f22682g.setVisibility(8);
        }
    }

    public List<d.a.q0.z3.m.e.c.b> getChoosedBeautyList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.q : (List) invokeV.objValue;
    }

    public List<d.a.q0.z3.m.e.c.b> getChoosedFilterList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.r : (List) invokeV.objValue;
    }

    public List<QmStickerItem> getChoosedStickerList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.s : (List) invokeV.objValue;
    }

    public String getCurrentFilterName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            RecordEffectLayout recordEffectLayout = this.u;
            return (recordEffectLayout == null || recordEffectLayout.getCurrentFilterItem() == null) ? "" : this.u.getCurrentFilterItem().b();
        }
        return (String) invokeV.objValue;
    }

    public TextView getRecordTimeView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f22682g : (TextView) invokeV.objValue;
    }

    public d.a.q0.z3.m.a getRecrodButton() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f22681f : (d.a.q0.z3.m.a) invokeV.objValue;
    }

    public final void j(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.u.getLayoutParams();
            if (i2 == 1) {
                layoutParams.height = UtilHelper.getDimenPixelSize(R.dimen.tbds528);
            } else if (i2 == 2) {
                layoutParams.height = UtilHelper.getDimenPixelSize(R.dimen.tbds580);
            } else if (i2 != 3) {
            } else {
                layoutParams.height = UtilHelper.getDimenPixelSize(R.dimen.tbds648);
            }
        }
    }

    public final void k(View view, MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, view, motionEvent) == null) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    return;
                }
                this.f22681f.k();
            } else if (this.u.getVisibility() == 0) {
                m(null, true);
            } else {
                e eVar = this.n;
                if (eVar != null) {
                    eVar.onTakePhoto();
                    this.f22681f.i();
                }
            }
        }
    }

    public final void l(View view, MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, view, motionEvent) == null) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if ((action == 1 || action == 3) && !k0.b()) {
                    if (this.o) {
                        this.o = false;
                        return;
                    }
                    this.l = false;
                    if (this.f22683h.c()) {
                        D();
                        return;
                    }
                    this.p = false;
                    B();
                    return;
                }
                return;
            }
            e eVar = this.n;
            if (eVar != null) {
                eVar.hideMinVideoTips();
            }
            d.a.q0.n0.c.a aVar = this.f22684i;
            if (aVar != null && aVar.g()) {
                this.o = true;
                CustomToast.newInstance().showToast(R.string.music_is_downloading);
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            this.k = currentTimeMillis;
            this.l = true;
            this.v.postDelayed(new b(this, currentTimeMillis), 200L);
        }
    }

    public void m(d.a.q0.z3.m.e.a aVar, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048590, this, aVar, z) == null) || this.u.getVisibility() == 8) {
            return;
        }
        o();
        for (int i2 = 0; i2 < this.m.size(); i2++) {
            ObjectAnimator objectAnimator = this.m.get(i2);
            if (objectAnimator != null) {
                objectAnimator.setDuration(320L);
                objectAnimator.cancel();
                objectAnimator.removeAllListeners();
                if (i2 == this.m.size() - 1) {
                    objectAnimator.addListener(new d(this, z, aVar));
                }
                objectAnimator.reverse();
            }
        }
        d.a.q0.y.a.a aVar2 = this.j;
        if (aVar2 != null && aVar2.getProgress() > 0.0f) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f22681f.getLayer2(), "alpha", 0.0f, 1.0f);
            ofFloat.setDuration(100L);
            ofFloat.reverse();
            ObjectAnimator.ofFloat(this.f22681f.getLayer1(), "scaleX", 0.388f, 0.276f).setDuration(320L).reverse();
            ObjectAnimator.ofFloat(this.f22681f.getLayer1(), "scaleY", 0.388f, 0.276f).setDuration(320L).reverse();
            return;
        }
        ObjectAnimator.ofFloat(this.f22681f.getLayer1(), "scaleX", 1.0f, 0.681f).setDuration(320L).reverse();
        ObjectAnimator.ofFloat(this.f22681f.getLayer1(), "scaleY", 1.0f, 0.681f).setDuration(320L).reverse();
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.record_layout, this);
            RecordEffectLayout recordEffectLayout = (RecordEffectLayout) findViewById(R.id.layout_effect);
            this.u = recordEffectLayout;
            d.a.p0.s.u.c d2 = d.a.p0.s.u.c.d(recordEffectLayout);
            d2.n(R.string.J_X14);
            d2.f(R.color.CAM_X0214);
            this.f22680e = (RelativeLayout) findViewById(R.id.layout_record);
            CaptureRecordButton captureRecordButton = (CaptureRecordButton) findViewById(R.id.layout_record_button);
            this.f22681f = captureRecordButton;
            captureRecordButton.setOnTouchListener(this);
            TextView textView = (TextView) findViewById(R.id.layout_record_time);
            this.f22682g = textView;
            d.a.p0.s.u.c d3 = d.a.p0.s.u.c.d(textView);
            d3.y(R.string.F_X02);
            d3.w(R.array.S_O_X001);
            this.t.add(0, new d.a.q0.z3.m.e.c.b(3, getResources().getString(R.string.music_normal), new MusicData(MusicData.MUSIC_NORMAL_ID, 1, getResources().getString(R.string.music_normal)), R.drawable.icon_video_mute));
            this.t.add(1, new d.a.q0.z3.m.e.c.b(3, getResources().getString(R.string.music_cloud), new MusicData(MusicData.MUSIC_CLOUD_ID, 2, getResources().getString(R.string.music_cloud)), R.drawable.icon_video_cloudmusic));
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && ListUtils.isEmpty(this.m)) {
            ArrayList arrayList = new ArrayList();
            this.m = arrayList;
            arrayList.add(ObjectAnimator.ofFloat(this.u, "translationY", UtilHelper.getDimenPixelSize(R.dimen.tbds656), 0.0f));
            this.m.add(ObjectAnimator.ofFloat(this.f22680e, "translationY", 0.0f, UtilHelper.getDimenPixelSize(R.dimen.tbds207)));
            this.m.add(ObjectAnimator.ofFloat(this.f22681f.getPause(), "scaleX", 1.0f, 0.681f));
            this.m.add(ObjectAnimator.ofFloat(this.f22681f.getPause(), "scaleY", 1.0f, 0.681f));
            this.m.add(ObjectAnimator.ofFloat(this.f22681f.getLayer2(), "scaleX", 0.8f, 0.57f));
            this.m.add(ObjectAnimator.ofFloat(this.f22681f.getLayer2(), "scaleY", 0.8f, 0.57f));
            this.m.add(ObjectAnimator.ofFloat(this.f22681f.getLayer3(), "scaleX", 1.0f, 0.57f));
            this.m.add(ObjectAnimator.ofFloat(this.f22681f.getLayer3(), "scaleY", 1.0f, 0.57f));
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.u, "alpha", 0.0f, 1.0f);
            ofFloat.setStartDelay(120L);
            this.m.add(ofFloat);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048593, this, view, motionEvent)) == null) {
            int i2 = this.w;
            if (i2 == 1) {
                k(view, motionEvent);
            } else if (i2 == 2) {
                l(view, motionEvent);
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.u.getVisibility() == 0 : invokeV.booleanValue;
    }

    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.u.getCurrentEffectLayout() == 2 && this.u.getVisibility() == 0 : invokeV.booleanValue;
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.u.getCurrentEffectLayout() == 3 && this.u.getVisibility() == 0 : invokeV.booleanValue;
    }

    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            RecordEffectLayout recordEffectLayout = this.u;
            if (recordEffectLayout != null) {
                return recordEffectLayout.s();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void setCurrentTab(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
            this.w = i2;
            if (i2 == 1) {
                this.f22681f.getLayer1().setVisibility(8);
            } else if (i2 != 2) {
            } else {
                this.f22681f.getLayer1().setVisibility(0);
            }
        }
    }

    public void setDownLoadFilter(QmFilterItem qmFilterItem) {
        RecordEffectLayout recordEffectLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048599, this, qmFilterItem) == null) || (recordEffectLayout = this.u) == null) {
            return;
        }
        recordEffectLayout.setDownLoadFilter(qmFilterItem);
    }

    public void setDownLoadSticker(QmStickerItem qmStickerItem, boolean z) {
        RecordEffectLayout recordEffectLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048600, this, qmStickerItem, z) == null) || (recordEffectLayout = this.u) == null) {
            return;
        }
        recordEffectLayout.setDownLoadStrick(qmStickerItem, z);
    }

    public void setDurationManager(d.a.q0.y.a.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, aVar) == null) {
            this.j = aVar;
        }
    }

    public void setEditManager(d.a.q0.f0.a.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, aVar) == null) {
        }
    }

    public void setEffectChoosedListener(RecordEffectLayout.i iVar) {
        RecordEffectLayout recordEffectLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048603, this, iVar) == null) || (recordEffectLayout = this.u) == null) {
            return;
        }
        recordEffectLayout.setListener(iVar);
    }

    public void setEffectLayoutCurrentMusicName(String str) {
        RecordEffectLayout recordEffectLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048604, this, str) == null) || (recordEffectLayout = this.u) == null) {
            return;
        }
        recordEffectLayout.setCurrentMusicName(str);
    }

    public void setFilterData(List<QmFilterItem> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, list) == null) {
            ArrayList arrayList = new ArrayList();
            if (list != null && list.size() > 0) {
                for (QmFilterItem qmFilterItem : list) {
                    arrayList.add(new d.a.q0.z3.m.e.c.b(2, qmFilterItem.name, qmFilterItem, -1));
                }
            }
            RecordEffectLayout recordEffectLayout = this.u;
            if (recordEffectLayout != null) {
                recordEffectLayout.setFilterList(arrayList);
            }
        }
    }

    public void setHasLocalVideo(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048606, this, z) == null) {
        }
    }

    @Override // d.a.q0.n0.c.b
    public void setMusicData(List<MusicData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, list) == null) {
            if (list != null && list.size() > 0) {
                for (MusicData musicData : list) {
                    this.t.add(new d.a.q0.z3.m.e.c.b(3, musicData.name, musicData, -1));
                }
            }
            RecordEffectLayout recordEffectLayout = this.u;
            if (recordEffectLayout != null) {
                recordEffectLayout.setMusicList(this.t);
            }
        }
    }

    public void setMusicManager(d.a.q0.n0.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, aVar) == null) {
            this.f22684i = aVar;
        }
    }

    public void setMusicName(String str, String str2) {
        RecordEffectLayout recordEffectLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048609, this, str, str2) == null) || (recordEffectLayout = this.u) == null) {
            return;
        }
        recordEffectLayout.setMusicName(str, str2);
    }

    public void setRecordControlListener(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, eVar) == null) {
            this.n = eVar;
        }
    }

    public void setRecordManager(d.a.q0.f0.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, aVar) == null) {
            this.f22683h = aVar;
        }
    }

    public void setSelectedToLeftIndex() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            this.u.y();
        }
    }

    public void setSelectedToRightIndex() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            this.u.x();
        }
    }

    public void setStickerItems(List<QmStickerItem> list) {
        RecordEffectLayout recordEffectLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048614, this, list) == null) || (recordEffectLayout = this.u) == null) {
            return;
        }
        recordEffectLayout.setStickerItems(list);
    }

    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            RecordEffectLayout recordEffectLayout = this.u;
            if (recordEffectLayout != null) {
                return recordEffectLayout.t();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            j(1);
            if (p() && this.u.getCurrentEffectLayout() == 2) {
                m(null, false);
                return;
            }
            if (!p()) {
                A();
            }
            this.u.u();
        }
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            j(2);
            if (p() && this.u.getCurrentEffectLayout() == 3) {
                m(null, false);
                return;
            }
            if (!p()) {
                A();
            }
            this.u.v();
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            j(3);
            if (p() && this.u.getCurrentEffectLayout() == 0) {
                m(null, false);
                return;
            }
            if (!p()) {
                A();
            }
            this.u.w();
        }
    }

    public void x(TbMusicData tbMusicData) {
        RecordEffectLayout recordEffectLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048619, this, tbMusicData) == null) || (recordEffectLayout = this.u) == null) {
            return;
        }
        recordEffectLayout.z(tbMusicData);
    }

    public void y(QmFilterItem qmFilterItem) {
        RecordEffectLayout recordEffectLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048620, this, qmFilterItem) == null) || (recordEffectLayout = this.u) == null) {
            return;
        }
        recordEffectLayout.A(new d.a.q0.z3.m.e.c.b(2, qmFilterItem.name, qmFilterItem, -1));
    }

    public void z(QmStickerItem qmStickerItem) {
        RecordEffectLayout recordEffectLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048621, this, qmStickerItem) == null) || (recordEffectLayout = this.u) == null) {
            return;
        }
        recordEffectLayout.B(qmStickerItem);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public VideoControllerLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoControllerLayout(Context context, AttributeSet attributeSet, int i2) {
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
        this.k = 0L;
        this.l = false;
        this.q = new ArrayList();
        this.r = new ArrayList();
        this.s = new ArrayList();
        this.t = new ArrayList();
        this.v = new Handler();
        this.w = 2;
        n();
    }
}
