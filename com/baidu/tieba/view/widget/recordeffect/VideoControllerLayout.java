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
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.c1.p0;
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
import com.tachikoma.core.component.anim.AnimationProperty;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class VideoControllerLayout extends RelativeLayout implements View.OnTouchListener, c.a.p0.y0.c.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RelativeLayout a;

    /* renamed from: b  reason: collision with root package name */
    public CaptureRecordButton f37241b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f37242c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.p0.m0.c.a f37243d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.p0.y0.c.a f37244e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.p0.f0.a.a f37245f;

    /* renamed from: g  reason: collision with root package name */
    public long f37246g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f37247h;
    public List<ObjectAnimator> i;
    public e j;
    public boolean k;
    public boolean l;
    public List<c.a.p0.q4.n.e.c.b> m;
    public List<c.a.p0.q4.n.e.c.b> n;
    public List<QmStickerItem> o;
    public List<c.a.p0.q4.n.e.c.b> p;
    public RecordEffectLayout q;
    public Handler r;
    public int s;

    /* loaded from: classes6.dex */
    public class a extends c.a.p0.q4.n.e.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ VideoControllerLayout f37248b;

        public a(VideoControllerLayout videoControllerLayout) {
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
            this.f37248b = videoControllerLayout;
        }

        @Override // c.a.p0.q4.n.e.a, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                super.onAnimationEnd(animator);
                if ((this.f37248b.f37243d == null || !this.f37248b.f37243d.c()) && this.f37248b.j != null) {
                    this.f37248b.j.onStartRecord();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ VideoControllerLayout f37249b;

        public b(VideoControllerLayout videoControllerLayout, long j) {
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
            this.f37249b = videoControllerLayout;
            this.a = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f37249b.f37247h && this.f37249b.f37246g == this.a) {
                this.f37249b.l = true;
                this.f37249b.D();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends c.a.p0.q4.n.e.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ VideoControllerLayout f37250b;

        public c(VideoControllerLayout videoControllerLayout) {
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
            this.f37250b = videoControllerLayout;
        }

        @Override // c.a.p0.q4.n.e.a, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, animator) == null) || this.f37250b.j == null) {
                return;
            }
            this.f37250b.j.onShowEffectLayout();
        }
    }

    /* loaded from: classes6.dex */
    public class d extends c.a.p0.q4.n.e.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f37251b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.q4.n.e.a f37252c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ VideoControllerLayout f37253d;

        public d(VideoControllerLayout videoControllerLayout, boolean z, c.a.p0.q4.n.e.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoControllerLayout, Boolean.valueOf(z), aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f37253d = videoControllerLayout;
            this.f37251b = z;
            this.f37252c = aVar;
        }

        @Override // c.a.p0.q4.n.e.a, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, animator) == null) || this.a) {
                return;
            }
            this.f37253d.q.setVisibility(8);
            if (this.f37253d.f37245f == null || this.f37253d.f37245f.getProgress() <= 0.0f) {
                this.f37253d.f37242c.setVisibility(8);
            } else {
                this.f37253d.f37242c.setVisibility(0);
            }
            if (this.f37253d.j != null) {
                this.f37253d.j.a(this.f37251b);
            }
            c.a.p0.q4.n.e.a aVar = this.f37252c;
            if (aVar != null) {
                aVar.onAnimationEnd(animator);
            }
        }
    }

    /* loaded from: classes6.dex */
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public void A(QmFilterItem qmFilterItem) {
        RecordEffectLayout recordEffectLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, qmFilterItem) == null) || (recordEffectLayout = this.q) == null) {
            return;
        }
        recordEffectLayout.A(new c.a.p0.q4.n.e.c.b(2, qmFilterItem.name, qmFilterItem, -1));
    }

    public void B(QmStickerItem qmStickerItem) {
        RecordEffectLayout recordEffectLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, qmStickerItem) == null) || (recordEffectLayout = this.q) == null) {
            return;
        }
        recordEffectLayout.B(qmStickerItem);
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.q.getVisibility() == 0) {
            return;
        }
        this.q.setVisibility(0);
        this.f37242c.setVisibility(8);
        p();
        for (int i = 0; i < this.i.size(); i++) {
            ObjectAnimator objectAnimator = this.i.get(i);
            if (objectAnimator != null) {
                objectAnimator.cancel();
                objectAnimator.setDuration(320L);
                objectAnimator.removeAllListeners();
                if (i == this.i.size() - 1) {
                    objectAnimator.addListener(new c(this));
                }
                objectAnimator.start();
            }
        }
        c.a.p0.f0.a.a aVar = this.f37245f;
        if (aVar != null && aVar.getProgress() > 0.0f) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f37241b.getLayer2(), AnimationProperty.OPACITY, 0.0f, 1.0f);
            ofFloat.setDuration(320L);
            ofFloat.start();
            ObjectAnimator.ofFloat(this.f37241b.getLayer1(), AnimationProperty.SCALE_X, 0.388f, 0.276f).setDuration(320L).start();
            ObjectAnimator.ofFloat(this.f37241b.getLayer1(), AnimationProperty.SCALE_Y, 0.388f, 0.276f).setDuration(320L).start();
            return;
        }
        ObjectAnimator.ofFloat(this.f37241b.getLayer1(), AnimationProperty.SCALE_X, 1.0f, 0.681f).setDuration(320L).start();
        ObjectAnimator.ofFloat(this.f37241b.getLayer1(), AnimationProperty.SCALE_Y, 1.0f, 0.681f).setDuration(320L).start();
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            c.a.p0.m0.c.a aVar = this.f37243d;
            if (aVar == null || !aVar.c()) {
                c.a.p0.f0.a.a aVar2 = this.f37245f;
                if (aVar2 != null && aVar2.getProgress() > 0.0f) {
                    this.f37241b.g();
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
                if (this.q.getVisibility() == 0) {
                    n(new a(this), true);
                    return;
                }
                e eVar = this.j;
                if (eVar != null) {
                    eVar.onStartRecord();
                }
            }
        }
    }

    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f37242c.setVisibility(0);
            this.f37241b.h(this.l);
        }
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            c.a.p0.m0.c.a aVar = this.f37243d;
            if (aVar != null && !aVar.c()) {
                c.a.p0.f0.a.a aVar2 = this.f37245f;
                if (aVar2 == null || aVar2.getProgress() < this.f37245f.getMaxDuration()) {
                    return;
                }
                this.f37241b.f();
                return;
            }
            c.a.p0.f0.a.a aVar3 = this.f37245f;
            if (aVar3 != null && aVar3.getProgress() > 0.0f) {
                this.f37241b.f();
            }
            e eVar = this.j;
            if (eVar != null) {
                eVar.onStopRecord();
            }
        }
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f37241b.j();
            this.f37242c.setVisibility(8);
        }
    }

    public List<c.a.p0.q4.n.e.c.b> getChoosedBeautyList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.m : (List) invokeV.objValue;
    }

    public List<c.a.p0.q4.n.e.c.b> getChoosedFilterList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.n : (List) invokeV.objValue;
    }

    public List<QmStickerItem> getChoosedStickerList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.o : (List) invokeV.objValue;
    }

    public String getCurrentFilterName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            RecordEffectLayout recordEffectLayout = this.q;
            return (recordEffectLayout == null || recordEffectLayout.getCurrentFilterItem() == null) ? "" : this.q.getCurrentFilterItem().b();
        }
        return (String) invokeV.objValue;
    }

    public TextView getRecordTimeView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f37242c : (TextView) invokeV.objValue;
    }

    public c.a.p0.q4.n.a getRecrodButton() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f37241b : (c.a.p0.q4.n.a) invokeV.objValue;
    }

    public final void k(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.q.getLayoutParams();
            if (i == 1) {
                layoutParams.height = UtilHelper.getDimenPixelSize(R.dimen.tbds528);
            } else if (i == 2) {
                layoutParams.height = UtilHelper.getDimenPixelSize(R.dimen.tbds580);
            } else if (i != 3) {
            } else {
                layoutParams.height = UtilHelper.getDimenPixelSize(R.dimen.tbds648);
            }
        }
    }

    public final void l(View view, MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, view, motionEvent) == null) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    return;
                }
                this.f37241b.k();
            } else if (this.q.getVisibility() == 0) {
                n(null, true);
            } else {
                e eVar = this.j;
                if (eVar != null) {
                    eVar.onTakePhoto();
                    this.f37241b.i();
                }
            }
        }
    }

    public final void m(View view, MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, view, motionEvent) == null) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if ((action == 1 || action == 3) && !p0.b()) {
                    if (this.k) {
                        this.k = false;
                        return;
                    }
                    this.f37247h = false;
                    if (this.f37243d.c()) {
                        F();
                        return;
                    }
                    this.l = false;
                    D();
                    return;
                }
                return;
            }
            e eVar = this.j;
            if (eVar != null) {
                eVar.hideMinVideoTips();
            }
            c.a.p0.y0.c.a aVar = this.f37244e;
            if (aVar != null && aVar.g()) {
                this.k = true;
                CustomToast.newInstance().showToast(R.string.obfuscated_res_0x7f0f0b0d);
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            this.f37246g = currentTimeMillis;
            this.f37247h = true;
            this.r.postDelayed(new b(this, currentTimeMillis), 200L);
        }
    }

    public void n(c.a.p0.q4.n.e.a aVar, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048592, this, aVar, z) == null) || this.q.getVisibility() == 8) {
            return;
        }
        p();
        for (int i = 0; i < this.i.size(); i++) {
            ObjectAnimator objectAnimator = this.i.get(i);
            if (objectAnimator != null) {
                objectAnimator.setDuration(320L);
                objectAnimator.cancel();
                objectAnimator.removeAllListeners();
                if (i == this.i.size() - 1) {
                    objectAnimator.addListener(new d(this, z, aVar));
                }
                objectAnimator.reverse();
            }
        }
        c.a.p0.f0.a.a aVar2 = this.f37245f;
        if (aVar2 != null && aVar2.getProgress() > 0.0f) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f37241b.getLayer2(), AnimationProperty.OPACITY, 0.0f, 1.0f);
            ofFloat.setDuration(100L);
            ofFloat.reverse();
            ObjectAnimator.ofFloat(this.f37241b.getLayer1(), AnimationProperty.SCALE_X, 0.388f, 0.276f).setDuration(320L).reverse();
            ObjectAnimator.ofFloat(this.f37241b.getLayer1(), AnimationProperty.SCALE_Y, 0.388f, 0.276f).setDuration(320L).reverse();
            return;
        }
        ObjectAnimator.ofFloat(this.f37241b.getLayer1(), AnimationProperty.SCALE_X, 1.0f, 0.681f).setDuration(320L).reverse();
        ObjectAnimator.ofFloat(this.f37241b.getLayer1(), AnimationProperty.SCALE_Y, 1.0f, 0.681f).setDuration(320L).reverse();
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d0733, this);
            RecordEffectLayout recordEffectLayout = (RecordEffectLayout) findViewById(R.id.obfuscated_res_0x7f0911d6);
            this.q = recordEffectLayout;
            c.a.o0.r.v.c d2 = c.a.o0.r.v.c.d(recordEffectLayout);
            d2.n(R.string.J_X14);
            d2.f(R.color.CAM_X0214);
            this.a = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f0911f2);
            CaptureRecordButton captureRecordButton = (CaptureRecordButton) findViewById(R.id.obfuscated_res_0x7f0911f3);
            this.f37241b = captureRecordButton;
            captureRecordButton.setOnTouchListener(this);
            TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f0911f4);
            this.f37242c = textView;
            c.a.o0.r.v.c d3 = c.a.o0.r.v.c.d(textView);
            d3.A(R.string.F_X02);
            d3.y(R.array.S_O_X001);
            this.p.add(0, new c.a.p0.q4.n.e.c.b(3, getResources().getString(R.string.obfuscated_res_0x7f0f0b0e), new MusicData(MusicData.MUSIC_NORMAL_ID, 1, getResources().getString(R.string.obfuscated_res_0x7f0f0b0e)), R.drawable.obfuscated_res_0x7f080ac2));
            this.p.add(1, new c.a.p0.q4.n.e.c.b(3, getResources().getString(R.string.obfuscated_res_0x7f0f0b0c), new MusicData(MusicData.MUSIC_CLOUD_ID, 2, getResources().getString(R.string.obfuscated_res_0x7f0f0b0c)), R.drawable.obfuscated_res_0x7f080aad));
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048594, this, view, motionEvent)) == null) {
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
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && ListUtils.isEmpty(this.i)) {
            ArrayList arrayList = new ArrayList();
            this.i = arrayList;
            arrayList.add(ObjectAnimator.ofFloat(this.q, AnimationProperty.TRANSLATE_Y, UtilHelper.getDimenPixelSize(R.dimen.tbds656), 0.0f));
            this.i.add(ObjectAnimator.ofFloat(this.a, AnimationProperty.TRANSLATE_Y, 0.0f, UtilHelper.getDimenPixelSize(R.dimen.tbds207)));
            this.i.add(ObjectAnimator.ofFloat(this.f37241b.getPause(), AnimationProperty.SCALE_X, 1.0f, 0.681f));
            this.i.add(ObjectAnimator.ofFloat(this.f37241b.getPause(), AnimationProperty.SCALE_Y, 1.0f, 0.681f));
            this.i.add(ObjectAnimator.ofFloat(this.f37241b.getLayer2(), AnimationProperty.SCALE_X, 0.8f, 0.57f));
            this.i.add(ObjectAnimator.ofFloat(this.f37241b.getLayer2(), AnimationProperty.SCALE_Y, 0.8f, 0.57f));
            this.i.add(ObjectAnimator.ofFloat(this.f37241b.getLayer3(), AnimationProperty.SCALE_X, 1.0f, 0.57f));
            this.i.add(ObjectAnimator.ofFloat(this.f37241b.getLayer3(), AnimationProperty.SCALE_Y, 1.0f, 0.57f));
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.q, AnimationProperty.OPACITY, 0.0f, 1.0f);
            ofFloat.setStartDelay(120L);
            this.i.add(ofFloat);
        }
    }

    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.q.getVisibility() == 0 : invokeV.booleanValue;
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.q.getCurrentEffectLayout() == 2 && this.q.getVisibility() == 0 : invokeV.booleanValue;
    }

    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.q.getCurrentEffectLayout() == 3 && this.q.getVisibility() == 0 : invokeV.booleanValue;
    }

    public void setCurrentFilterWithQmFilterItem(@NonNull QmFilterItem qmFilterItem) {
        RecordEffectLayout recordEffectLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048599, this, qmFilterItem) == null) || (recordEffectLayout = this.q) == null) {
            return;
        }
        recordEffectLayout.setCurrentFilterWithQmFilterItem(qmFilterItem);
    }

    public void setCurrentTab(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i) == null) {
            this.s = i;
            if (i == 1) {
                this.f37241b.getLayer1().setVisibility(8);
            } else if (i != 2) {
            } else {
                this.f37241b.getLayer1().setVisibility(0);
            }
        }
    }

    public void setDownLoadFilter(QmFilterItem qmFilterItem) {
        RecordEffectLayout recordEffectLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048601, this, qmFilterItem) == null) || (recordEffectLayout = this.q) == null) {
            return;
        }
        recordEffectLayout.setDownLoadFilter(qmFilterItem);
    }

    public void setDownLoadSticker(QmStickerItem qmStickerItem, boolean z) {
        RecordEffectLayout recordEffectLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048602, this, qmStickerItem, z) == null) || (recordEffectLayout = this.q) == null) {
            return;
        }
        recordEffectLayout.setDownLoadStrick(qmStickerItem, z);
    }

    public void setDurationManager(c.a.p0.f0.a.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, aVar) == null) {
            this.f37245f = aVar;
        }
    }

    public void setEditManager(c.a.p0.m0.a.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, aVar) == null) {
        }
    }

    public void setEffectChoosedListener(RecordEffectLayout.i iVar) {
        RecordEffectLayout recordEffectLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048605, this, iVar) == null) || (recordEffectLayout = this.q) == null) {
            return;
        }
        recordEffectLayout.setListener(iVar);
    }

    public void setEffectLayoutCurrentMusicName(String str) {
        RecordEffectLayout recordEffectLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048606, this, str) == null) || (recordEffectLayout = this.q) == null) {
            return;
        }
        recordEffectLayout.setCurrentMusicName(str);
    }

    public void setFilterData(List<QmFilterItem> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, list) == null) {
            ArrayList arrayList = new ArrayList();
            if (list != null && list.size() > 0) {
                for (QmFilterItem qmFilterItem : list) {
                    arrayList.add(new c.a.p0.q4.n.e.c.b(2, qmFilterItem.name, qmFilterItem, -1));
                }
            }
            RecordEffectLayout recordEffectLayout = this.q;
            if (recordEffectLayout != null) {
                recordEffectLayout.setFilterList(arrayList);
            }
        }
    }

    public void setHasLocalVideo(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048608, this, z) == null) {
        }
    }

    @Override // c.a.p0.y0.c.b
    public void setMusicData(List<MusicData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, list) == null) {
            if (list != null && list.size() > 0) {
                for (MusicData musicData : list) {
                    this.p.add(new c.a.p0.q4.n.e.c.b(3, musicData.name, musicData, -1));
                }
            }
            RecordEffectLayout recordEffectLayout = this.q;
            if (recordEffectLayout != null) {
                recordEffectLayout.setMusicList(this.p);
            }
        }
    }

    public void setMusicManager(c.a.p0.y0.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, aVar) == null) {
            this.f37244e = aVar;
        }
    }

    public void setMusicName(String str, String str2) {
        RecordEffectLayout recordEffectLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048611, this, str, str2) == null) || (recordEffectLayout = this.q) == null) {
            return;
        }
        recordEffectLayout.setMusicName(str, str2);
    }

    public void setRecordControlListener(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, eVar) == null) {
            this.j = eVar;
        }
    }

    public void setRecordManager(c.a.p0.m0.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, aVar) == null) {
            this.f37243d = aVar;
        }
    }

    public void setSelectedToLeftIndex() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            this.q.y();
        }
    }

    public void setSelectedToRightIndex() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            this.q.x();
        }
    }

    public void setStickerItems(List<QmStickerItem> list) {
        RecordEffectLayout recordEffectLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048616, this, list) == null) || (recordEffectLayout = this.q) == null) {
            return;
        }
        recordEffectLayout.setStickerItems(list);
    }

    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            RecordEffectLayout recordEffectLayout = this.q;
            if (recordEffectLayout != null) {
                return recordEffectLayout.s();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            RecordEffectLayout recordEffectLayout = this.q;
            if (recordEffectLayout != null) {
                return recordEffectLayout.t();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            k(1);
            if (q() && this.q.getCurrentEffectLayout() == 2) {
                n(null, false);
                return;
            }
            if (!q()) {
                C();
            }
            this.q.u();
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            k(2);
            if (q() && this.q.getCurrentEffectLayout() == 3) {
                n(null, false);
                return;
            }
            if (!q()) {
                C();
            }
            this.q.v();
        }
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            k(3);
            if (q() && this.q.getCurrentEffectLayout() == 0) {
                n(null, false);
                return;
            }
            if (!q()) {
                C();
            }
            this.q.w();
        }
    }

    public void z(TbMusicData tbMusicData) {
        RecordEffectLayout recordEffectLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048622, this, tbMusicData) == null) || (recordEffectLayout = this.q) == null) {
            return;
        }
        recordEffectLayout.z(tbMusicData);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
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
        this.f37246g = 0L;
        this.f37247h = false;
        this.m = new ArrayList();
        this.n = new ArrayList();
        this.o = new ArrayList();
        this.p = new ArrayList();
        this.r = new Handler();
        this.s = 2;
        o();
    }
}
