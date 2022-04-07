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
import com.repackage.gd5;
import com.repackage.hw5;
import com.repackage.l86;
import com.repackage.m86;
import com.repackage.oy8;
import com.repackage.pz5;
import com.repackage.qx8;
import com.repackage.sy8;
import com.repackage.vz5;
import com.repackage.wr4;
import com.tachikoma.core.component.anim.AnimationProperty;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class VideoControllerLayout extends RelativeLayout implements View.OnTouchListener, m86 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RelativeLayout a;
    public CaptureRecordButton b;
    public TextView c;
    public vz5 d;
    public l86 e;
    public hw5 f;
    public long g;
    public boolean h;
    public List<ObjectAnimator> i;
    public e j;
    public boolean k;
    public boolean l;
    public List<sy8> m;
    public List<sy8> n;
    public List<QmStickerItem> o;
    public List<sy8> p;
    public RecordEffectLayout q;
    public Handler r;
    public int s;

    /* loaded from: classes4.dex */
    public class a extends oy8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoControllerLayout b;

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
            this.b = videoControllerLayout;
        }

        @Override // com.repackage.oy8, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                super.onAnimationEnd(animator);
                if ((this.b.d == null || !this.b.d.c()) && this.b.j != null) {
                    this.b.j.onStartRecord();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;
        public final /* synthetic */ VideoControllerLayout b;

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
            this.b = videoControllerLayout;
            this.a = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b.h && this.b.g == this.a) {
                this.b.l = true;
                this.b.D();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends oy8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoControllerLayout b;

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
            this.b = videoControllerLayout;
        }

        @Override // com.repackage.oy8, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, animator) == null) || this.b.j == null) {
                return;
            }
            this.b.j.onShowEffectLayout();
        }
    }

    /* loaded from: classes4.dex */
    public class d extends oy8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ oy8 c;
        public final /* synthetic */ VideoControllerLayout d;

        public d(VideoControllerLayout videoControllerLayout, boolean z, oy8 oy8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoControllerLayout, Boolean.valueOf(z), oy8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = videoControllerLayout;
            this.b = z;
            this.c = oy8Var;
        }

        @Override // com.repackage.oy8, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, animator) == null) || this.a) {
                return;
            }
            this.d.q.setVisibility(8);
            if (this.d.f == null || this.d.f.getProgress() <= 0.0f) {
                this.d.c.setVisibility(8);
            } else {
                this.d.c.setVisibility(0);
            }
            if (this.d.j != null) {
                this.d.j.a(this.b);
            }
            oy8 oy8Var = this.c;
            if (oy8Var != null) {
                oy8Var.onAnimationEnd(animator);
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
        recordEffectLayout.A(new sy8(2, qmFilterItem.name, qmFilterItem, -1));
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
        this.c.setVisibility(8);
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
        hw5 hw5Var = this.f;
        if (hw5Var != null && hw5Var.getProgress() > 0.0f) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.b.getLayer2(), AnimationProperty.OPACITY, 0.0f, 1.0f);
            ofFloat.setDuration(320L);
            ofFloat.start();
            ObjectAnimator.ofFloat(this.b.getLayer1(), AnimationProperty.SCALE_X, 0.388f, 0.276f).setDuration(320L).start();
            ObjectAnimator.ofFloat(this.b.getLayer1(), AnimationProperty.SCALE_Y, 0.388f, 0.276f).setDuration(320L).start();
            return;
        }
        ObjectAnimator.ofFloat(this.b.getLayer1(), AnimationProperty.SCALE_X, 1.0f, 0.681f).setDuration(320L).start();
        ObjectAnimator.ofFloat(this.b.getLayer1(), AnimationProperty.SCALE_Y, 1.0f, 0.681f).setDuration(320L).start();
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            vz5 vz5Var = this.d;
            if (vz5Var == null || !vz5Var.c()) {
                hw5 hw5Var = this.f;
                if (hw5Var != null && hw5Var.getProgress() > 0.0f) {
                    this.b.g();
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
            this.c.setVisibility(0);
            this.b.h(this.l);
        }
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            vz5 vz5Var = this.d;
            if (vz5Var != null && !vz5Var.c()) {
                hw5 hw5Var = this.f;
                if (hw5Var == null || hw5Var.getProgress() < this.f.getMaxDuration()) {
                    return;
                }
                this.b.f();
                return;
            }
            hw5 hw5Var2 = this.f;
            if (hw5Var2 != null && hw5Var2.getProgress() > 0.0f) {
                this.b.f();
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
            this.b.j();
            this.c.setVisibility(8);
        }
    }

    public List<sy8> getChoosedBeautyList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.m : (List) invokeV.objValue;
    }

    public List<sy8> getChoosedFilterList() {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.c : (TextView) invokeV.objValue;
    }

    public qx8 getRecrodButton() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.b : (qx8) invokeV.objValue;
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

    public final void l(View view2, MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, view2, motionEvent) == null) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    return;
                }
                this.b.k();
            } else if (this.q.getVisibility() == 0) {
                n(null, true);
            } else {
                e eVar = this.j;
                if (eVar != null) {
                    eVar.onTakePhoto();
                    this.b.i();
                }
            }
        }
    }

    public final void m(View view2, MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, view2, motionEvent) == null) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if ((action == 1 || action == 3) && !gd5.b()) {
                    if (this.k) {
                        this.k = false;
                        return;
                    }
                    this.h = false;
                    if (this.d.c()) {
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
            l86 l86Var = this.e;
            if (l86Var != null && l86Var.g()) {
                this.k = true;
                CustomToast.newInstance().showToast(R.string.obfuscated_res_0x7f0f0b0f);
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            this.g = currentTimeMillis;
            this.h = true;
            this.r.postDelayed(new b(this, currentTimeMillis), 200L);
        }
    }

    public void n(oy8 oy8Var, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048592, this, oy8Var, z) == null) || this.q.getVisibility() == 8) {
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
                    objectAnimator.addListener(new d(this, z, oy8Var));
                }
                objectAnimator.reverse();
            }
        }
        hw5 hw5Var = this.f;
        if (hw5Var != null && hw5Var.getProgress() > 0.0f) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.b.getLayer2(), AnimationProperty.OPACITY, 0.0f, 1.0f);
            ofFloat.setDuration(100L);
            ofFloat.reverse();
            ObjectAnimator.ofFloat(this.b.getLayer1(), AnimationProperty.SCALE_X, 0.388f, 0.276f).setDuration(320L).reverse();
            ObjectAnimator.ofFloat(this.b.getLayer1(), AnimationProperty.SCALE_Y, 0.388f, 0.276f).setDuration(320L).reverse();
            return;
        }
        ObjectAnimator.ofFloat(this.b.getLayer1(), AnimationProperty.SCALE_X, 1.0f, 0.681f).setDuration(320L).reverse();
        ObjectAnimator.ofFloat(this.b.getLayer1(), AnimationProperty.SCALE_Y, 1.0f, 0.681f).setDuration(320L).reverse();
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d072a, this);
            RecordEffectLayout recordEffectLayout = (RecordEffectLayout) findViewById(R.id.obfuscated_res_0x7f0911cb);
            this.q = recordEffectLayout;
            wr4 d2 = wr4.d(recordEffectLayout);
            d2.n(R.string.J_X14);
            d2.f(R.color.CAM_X0214);
            this.a = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f0911e7);
            CaptureRecordButton captureRecordButton = (CaptureRecordButton) findViewById(R.id.obfuscated_res_0x7f0911e8);
            this.b = captureRecordButton;
            captureRecordButton.setOnTouchListener(this);
            TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f0911e9);
            this.c = textView;
            wr4 d3 = wr4.d(textView);
            d3.A(R.string.F_X02);
            d3.y(R.array.S_O_X001);
            this.p.add(0, new sy8(3, getResources().getString(R.string.obfuscated_res_0x7f0f0b10), new MusicData(MusicData.MUSIC_NORMAL_ID, 1, getResources().getString(R.string.obfuscated_res_0x7f0f0b10)), R.drawable.obfuscated_res_0x7f080ac3));
            this.p.add(1, new sy8(3, getResources().getString(R.string.obfuscated_res_0x7f0f0b0e), new MusicData(MusicData.MUSIC_CLOUD_ID, 2, getResources().getString(R.string.obfuscated_res_0x7f0f0b0e)), R.drawable.obfuscated_res_0x7f080aad));
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view2, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048594, this, view2, motionEvent)) == null) {
            int i = this.s;
            if (i == 1) {
                l(view2, motionEvent);
            } else if (i == 2) {
                m(view2, motionEvent);
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
            this.i.add(ObjectAnimator.ofFloat(this.b.getPause(), AnimationProperty.SCALE_X, 1.0f, 0.681f));
            this.i.add(ObjectAnimator.ofFloat(this.b.getPause(), AnimationProperty.SCALE_Y, 1.0f, 0.681f));
            this.i.add(ObjectAnimator.ofFloat(this.b.getLayer2(), AnimationProperty.SCALE_X, 0.8f, 0.57f));
            this.i.add(ObjectAnimator.ofFloat(this.b.getLayer2(), AnimationProperty.SCALE_Y, 0.8f, 0.57f));
            this.i.add(ObjectAnimator.ofFloat(this.b.getLayer3(), AnimationProperty.SCALE_X, 1.0f, 0.57f));
            this.i.add(ObjectAnimator.ofFloat(this.b.getLayer3(), AnimationProperty.SCALE_Y, 1.0f, 0.57f));
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
                this.b.getLayer1().setVisibility(8);
            } else if (i != 2) {
            } else {
                this.b.getLayer1().setVisibility(0);
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

    public void setDurationManager(hw5 hw5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, hw5Var) == null) {
            this.f = hw5Var;
        }
    }

    public void setEditManager(pz5 pz5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, pz5Var) == null) {
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
                    arrayList.add(new sy8(2, qmFilterItem.name, qmFilterItem, -1));
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

    @Override // com.repackage.m86
    public void setMusicData(List<MusicData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, list) == null) {
            if (list != null && list.size() > 0) {
                for (MusicData musicData : list) {
                    this.p.add(new sy8(3, musicData.name, musicData, -1));
                }
            }
            RecordEffectLayout recordEffectLayout = this.q;
            if (recordEffectLayout != null) {
                recordEffectLayout.setMusicList(this.p);
            }
        }
    }

    public void setMusicManager(l86 l86Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, l86Var) == null) {
            this.e = l86Var;
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

    public void setRecordManager(vz5 vz5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, vz5Var) == null) {
            this.d = vz5Var;
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
        this.g = 0L;
        this.h = false;
        this.m = new ArrayList();
        this.n = new ArrayList();
        this.o = new ArrayList();
        this.p = new ArrayList();
        this.r = new Handler();
        this.s = 2;
        o();
    }
}
