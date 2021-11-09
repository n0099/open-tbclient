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
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.view.InputDeviceCompat;
import b.a.q0.d1.n0;
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
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class VideoControllerLayout extends RelativeLayout implements View.OnTouchListener, b.a.r0.q0.c.b {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int TAB_PHOTO = 1;
    public static final int TAB_RECORD = 2;
    public static final int TYPE_FILTER = 1;
    public static final int TYPE_MUSIC = 2;
    public static final int TYPE_STICKER = 3;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public RelativeLayout f55735e;

    /* renamed from: f  reason: collision with root package name */
    public CaptureRecordButton f55736f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f55737g;

    /* renamed from: h  reason: collision with root package name */
    public b.a.r0.g0.c.a f55738h;

    /* renamed from: i  reason: collision with root package name */
    public b.a.r0.q0.c.a f55739i;
    public b.a.r0.z.a.a j;
    public long k;
    public boolean l;
    public List<ObjectAnimator> m;
    public e n;
    public boolean o;
    public boolean p;
    public boolean q;
    public List<b.a.r0.c4.l.e.c.b> r;
    public List<b.a.r0.c4.l.e.c.b> s;
    public List<QmStickerItem> t;
    public List<b.a.r0.c4.l.e.c.b> u;
    public RecordEffectLayout v;
    public Handler w;
    public int x;

    /* loaded from: classes9.dex */
    public class a extends b.a.r0.c4.l.e.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ VideoControllerLayout f55740f;

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
            this.f55740f = videoControllerLayout;
        }

        @Override // b.a.r0.c4.l.e.a, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                super.onAnimationEnd(animator);
                if ((this.f55740f.f55738h == null || !this.f55740f.f55738h.c()) && this.f55740f.n != null) {
                    this.f55740f.n.onStartRecord();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f55741e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ VideoControllerLayout f55742f;

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
            this.f55742f = videoControllerLayout;
            this.f55741e = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f55742f.l && this.f55742f.k == this.f55741e) {
                this.f55742f.q = true;
                this.f55742f.o();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c extends b.a.r0.c4.l.e.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ VideoControllerLayout f55743f;

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
            this.f55743f = videoControllerLayout;
        }

        @Override // b.a.r0.c4.l.e.a, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, animator) == null) || this.f55743f.n == null) {
                return;
            }
            this.f55743f.n.onShowEffectLayout();
        }
    }

    /* loaded from: classes9.dex */
    public class d extends b.a.r0.c4.l.e.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f55744f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b.a.r0.c4.l.e.a f55745g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ VideoControllerLayout f55746h;

        public d(VideoControllerLayout videoControllerLayout, boolean z, b.a.r0.c4.l.e.a aVar) {
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
            this.f55746h = videoControllerLayout;
            this.f55744f = z;
            this.f55745g = aVar;
        }

        @Override // b.a.r0.c4.l.e.a, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, animator) == null) || this.f15566e) {
                return;
            }
            this.f55746h.v.setVisibility(8);
            if (this.f55746h.j == null || this.f55746h.j.getProgress() <= 0.0f) {
                this.f55746h.f55737g.setVisibility(8);
            } else {
                this.f55746h.f55737g.setVisibility(0);
            }
            if (this.f55746h.n != null) {
                this.f55746h.n.a(this.f55744f);
            }
            b.a.r0.c4.l.e.a aVar = this.f55745g;
            if (aVar != null) {
                aVar.onAnimationEnd(animator);
            }
        }
    }

    /* loaded from: classes9.dex */
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

    public List<b.a.r0.c4.l.e.c.b> getChoosedBeautyList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.r : (List) invokeV.objValue;
    }

    public List<b.a.r0.c4.l.e.c.b> getChoosedFilterList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.s : (List) invokeV.objValue;
    }

    public List<QmStickerItem> getChoosedStickerList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.t : (List) invokeV.objValue;
    }

    public String getCurrentFilterName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            RecordEffectLayout recordEffectLayout = this.v;
            return (recordEffectLayout == null || recordEffectLayout.getCurrentFilterItem() == null) ? "" : this.v.getCurrentFilterItem().b();
        }
        return (String) invokeV.objValue;
    }

    public TextView getRecordTimeView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f55737g : (TextView) invokeV.objValue;
    }

    public b.a.r0.c4.l.a getRecrodButton() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f55736f : (b.a.r0.c4.l.a) invokeV.objValue;
    }

    public void hideEffectLayout(b.a.r0.c4.l.e.a aVar, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048582, this, aVar, z) == null) || this.v.getVisibility() == 8) {
            return;
        }
        m();
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
        b.a.r0.z.a.a aVar2 = this.j;
        if (aVar2 != null && aVar2.getProgress() > 0.0f) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f55736f.getLayer2(), Key.ALPHA, 0.0f, 1.0f);
            ofFloat.setDuration(100L);
            ofFloat.reverse();
            ObjectAnimator.ofFloat(this.f55736f.getLayer1(), Key.SCALE_X, 0.388f, 0.276f).setDuration(320L).reverse();
            ObjectAnimator.ofFloat(this.f55736f.getLayer1(), Key.SCALE_Y, 0.388f, 0.276f).setDuration(320L).reverse();
            return;
        }
        ObjectAnimator.ofFloat(this.f55736f.getLayer1(), Key.SCALE_X, 1.0f, 0.681f).setDuration(320L).reverse();
        ObjectAnimator.ofFloat(this.f55736f.getLayer1(), Key.SCALE_Y, 1.0f, 0.681f).setDuration(320L).reverse();
    }

    public boolean init() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.record_layout, this);
            RecordEffectLayout recordEffectLayout = (RecordEffectLayout) findViewById(R.id.layout_effect);
            this.v = recordEffectLayout;
            b.a.q0.s.u.c d2 = b.a.q0.s.u.c.d(recordEffectLayout);
            d2.n(R.string.J_X14);
            d2.f(R.color.CAM_X0214);
            this.f55735e = (RelativeLayout) findViewById(R.id.layout_record);
            CaptureRecordButton captureRecordButton = (CaptureRecordButton) findViewById(R.id.layout_record_button);
            this.f55736f = captureRecordButton;
            captureRecordButton.setOnTouchListener(this);
            TextView textView = (TextView) findViewById(R.id.layout_record_time);
            this.f55737g = textView;
            b.a.q0.s.u.c d3 = b.a.q0.s.u.c.d(textView);
            d3.A(R.string.F_X02);
            d3.y(R.array.S_O_X001);
            this.u.add(0, new b.a.r0.c4.l.e.c.b(3, getResources().getString(R.string.music_normal), new MusicData(MusicData.MUSIC_NORMAL_ID, 1, getResources().getString(R.string.music_normal)), R.drawable.icon_video_mute));
            this.u.add(1, new b.a.r0.c4.l.e.c.b(3, getResources().getString(R.string.music_cloud), new MusicData(MusicData.MUSIC_CLOUD_ID, 2, getResources().getString(R.string.music_cloud)), R.drawable.icon_video_cloudmusic));
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean isEffectLayoutVisible() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.v.getVisibility() == 0 : invokeV.booleanValue;
    }

    public boolean isFilterEffectLayoutVisible() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.v.getCurrentEffectLayout() == 2 && this.v.getVisibility() == 0 : invokeV.booleanValue;
    }

    public boolean isHasLocalVideo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.o : invokeV.booleanValue;
    }

    public boolean isMusicEffectLayoutVisible() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.v.getCurrentEffectLayout() == 3 && this.v.getVisibility() == 0 : invokeV.booleanValue;
    }

    public boolean isNeedLoadFilter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            RecordEffectLayout recordEffectLayout = this.v;
            if (recordEffectLayout != null) {
                return recordEffectLayout.isNeedLoadFilter();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isNeedLoadSticker() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            RecordEffectLayout recordEffectLayout = this.v;
            if (recordEffectLayout != null) {
                return recordEffectLayout.isNeedLoadSticker();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void j(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.v.getLayoutParams();
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
        if (interceptable == null || interceptable.invokeLL(1048591, this, view, motionEvent) == null) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    return;
                }
                this.f55736f.stopTakePhotoAnimator();
            } else if (this.v.getVisibility() == 0) {
                hideEffectLayout(null, true);
            } else {
                e eVar = this.n;
                if (eVar != null) {
                    eVar.onTakePhoto();
                    this.f55736f.startTakePhotoAnimator();
                }
            }
        }
    }

    public final void l(View view, MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, view, motionEvent) == null) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if ((action == 1 || action == 3) && !n0.b()) {
                    if (this.p) {
                        this.p = false;
                        return;
                    }
                    this.l = false;
                    if (this.f55738h.c()) {
                        stopRecord();
                        return;
                    }
                    this.q = false;
                    o();
                    return;
                }
                return;
            }
            e eVar = this.n;
            if (eVar != null) {
                eVar.hideMinVideoTips();
            }
            b.a.r0.q0.c.a aVar = this.f55739i;
            if (aVar != null && aVar.g()) {
                this.p = true;
                CustomToast.newInstance().showToast(R.string.music_is_downloading);
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            this.k = currentTimeMillis;
            this.l = true;
            this.w.postDelayed(new b(this, currentTimeMillis), 200L);
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && ListUtils.isEmpty(this.m)) {
            ArrayList arrayList = new ArrayList();
            this.m = arrayList;
            arrayList.add(ObjectAnimator.ofFloat(this.v, Key.TRANSLATION_Y, UtilHelper.getDimenPixelSize(R.dimen.tbds656), 0.0f));
            this.m.add(ObjectAnimator.ofFloat(this.f55735e, Key.TRANSLATION_Y, 0.0f, UtilHelper.getDimenPixelSize(R.dimen.tbds207)));
            this.m.add(ObjectAnimator.ofFloat(this.f55736f.getPause(), Key.SCALE_X, 1.0f, 0.681f));
            this.m.add(ObjectAnimator.ofFloat(this.f55736f.getPause(), Key.SCALE_Y, 1.0f, 0.681f));
            this.m.add(ObjectAnimator.ofFloat(this.f55736f.getLayer2(), Key.SCALE_X, 0.8f, 0.57f));
            this.m.add(ObjectAnimator.ofFloat(this.f55736f.getLayer2(), Key.SCALE_Y, 0.8f, 0.57f));
            this.m.add(ObjectAnimator.ofFloat(this.f55736f.getLayer3(), Key.SCALE_X, 1.0f, 0.57f));
            this.m.add(ObjectAnimator.ofFloat(this.f55736f.getLayer3(), Key.SCALE_Y, 1.0f, 0.57f));
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.v, Key.ALPHA, 0.0f, 1.0f);
            ofFloat.setStartDelay(120L);
            this.m.add(ofFloat);
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || this.v.getVisibility() == 0) {
            return;
        }
        this.v.setVisibility(0);
        this.f55737g.setVisibility(8);
        m();
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
        b.a.r0.z.a.a aVar = this.j;
        if (aVar != null && aVar.getProgress() > 0.0f) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f55736f.getLayer2(), Key.ALPHA, 0.0f, 1.0f);
            ofFloat.setDuration(320L);
            ofFloat.start();
            ObjectAnimator.ofFloat(this.f55736f.getLayer1(), Key.SCALE_X, 0.388f, 0.276f).setDuration(320L).start();
            ObjectAnimator.ofFloat(this.f55736f.getLayer1(), Key.SCALE_Y, 0.388f, 0.276f).setDuration(320L).start();
            return;
        }
        ObjectAnimator.ofFloat(this.f55736f.getLayer1(), Key.SCALE_X, 1.0f, 0.681f).setDuration(320L).start();
        ObjectAnimator.ofFloat(this.f55736f.getLayer1(), Key.SCALE_Y, 1.0f, 0.681f).setDuration(320L).start();
    }

    public void notifyStickerDataChanged() {
        RecordEffectLayout recordEffectLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (recordEffectLayout = this.v) == null) {
            return;
        }
        recordEffectLayout.notifyStickerDataChanged();
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            b.a.r0.g0.c.a aVar = this.f55738h;
            if (aVar == null || !aVar.c()) {
                b.a.r0.z.a.a aVar2 = this.j;
                if (aVar2 != null && aVar2.getProgress() > 0.0f) {
                    this.f55736f.resumeRecordAnimator();
                }
                if (this.v.getCurrentBeautyItem() != null) {
                    this.r.add(this.v.getCurrentBeautyItem());
                }
                if (this.v.getCurrentFilterItem() != null) {
                    this.s.add(this.v.getCurrentFilterItem());
                }
                if (this.v.getCurrentStickItem() != null) {
                    this.t.add(this.v.getCurrentStickItem());
                }
                if (this.v.getVisibility() == 0) {
                    hideEffectLayout(new a(this), true);
                    return;
                }
                e eVar = this.n;
                if (eVar != null) {
                    eVar.onStartRecord();
                }
            }
        }
    }

    public void onClickBeauty() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            j(1);
            if (isEffectLayoutVisible() && this.v.getCurrentEffectLayout() == 1) {
                hideEffectLayout(null, false);
                return;
            }
            if (!isEffectLayoutVisible()) {
                n();
            }
            this.v.onClickBeauty();
        }
    }

    public void onClickFilter() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            j(1);
            if (isEffectLayoutVisible() && this.v.getCurrentEffectLayout() == 2) {
                hideEffectLayout(null, false);
                return;
            }
            if (!isEffectLayoutVisible()) {
                n();
            }
            this.v.onClickFilter();
        }
    }

    public void onClickMusic() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            j(2);
            if (isEffectLayoutVisible() && this.v.getCurrentEffectLayout() == 3) {
                hideEffectLayout(null, false);
                return;
            }
            if (!isEffectLayoutVisible()) {
                n();
            }
            this.v.onClickMusic();
        }
    }

    public void onClickSticker() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            j(3);
            if (isEffectLayoutVisible() && this.v.getCurrentEffectLayout() == 0) {
                hideEffectLayout(null, false);
                return;
            }
            if (!isEffectLayoutVisible()) {
                n();
            }
            this.v.onClickSticker();
        }
    }

    public void onSaveMusicVideo(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048601, this, str, i2, str2) == null) {
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048602, this, view, motionEvent)) == null) {
            int i2 = this.x;
            if (i2 == 1) {
                k(view, motionEvent);
            } else if (i2 == 2) {
                l(view, motionEvent);
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public void resetEffect() {
        RecordEffectLayout recordEffectLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048603, this) == null) || (recordEffectLayout = this.v) == null) {
            return;
        }
        recordEffectLayout.resetEffect();
    }

    public void resetMusicPos() {
        RecordEffectLayout recordEffectLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048604, this) == null) || (recordEffectLayout = this.v) == null) {
            return;
        }
        recordEffectLayout.resetMusicPos();
    }

    public void selectCloudMusic(TbMusicData tbMusicData) {
        RecordEffectLayout recordEffectLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048605, this, tbMusicData) == null) || (recordEffectLayout = this.v) == null) {
            return;
        }
        recordEffectLayout.selectCloudMusic(tbMusicData);
    }

    public void selectFilter(QmFilterItem qmFilterItem) {
        RecordEffectLayout recordEffectLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048606, this, qmFilterItem) == null) || (recordEffectLayout = this.v) == null) {
            return;
        }
        recordEffectLayout.selectFilter(new b.a.r0.c4.l.e.c.b(2, qmFilterItem.name, qmFilterItem, -1));
    }

    public void selectSticker(QmStickerItem qmStickerItem) {
        RecordEffectLayout recordEffectLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048607, this, qmStickerItem) == null) || (recordEffectLayout = this.v) == null) {
            return;
        }
        recordEffectLayout.selectStrick(qmStickerItem);
    }

    public void setCurrentFilterWithQmFilterItem(@NonNull QmFilterItem qmFilterItem) {
        RecordEffectLayout recordEffectLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048608, this, qmFilterItem) == null) || (recordEffectLayout = this.v) == null) {
            return;
        }
        recordEffectLayout.setCurrentFilterWithQmFilterItem(qmFilterItem);
    }

    public void setCurrentTab(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048609, this, i2) == null) {
            this.x = i2;
            if (i2 == 1) {
                this.f55736f.getLayer1().setVisibility(8);
            } else if (i2 != 2) {
            } else {
                this.f55736f.getLayer1().setVisibility(0);
            }
        }
    }

    public void setDownLoadFilter(QmFilterItem qmFilterItem) {
        RecordEffectLayout recordEffectLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048610, this, qmFilterItem) == null) || (recordEffectLayout = this.v) == null) {
            return;
        }
        recordEffectLayout.setDownLoadFilter(qmFilterItem);
    }

    public void setDownLoadSticker(QmStickerItem qmStickerItem, boolean z) {
        RecordEffectLayout recordEffectLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048611, this, qmStickerItem, z) == null) || (recordEffectLayout = this.v) == null) {
            return;
        }
        recordEffectLayout.setDownLoadStrick(qmStickerItem, z);
    }

    public void setDurationManager(b.a.r0.z.a.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, aVar) == null) {
            this.j = aVar;
        }
    }

    public void setEditManager(b.a.r0.g0.a.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, aVar) == null) {
        }
    }

    public void setEffectChoosedListener(RecordEffectLayout.i iVar) {
        RecordEffectLayout recordEffectLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048614, this, iVar) == null) || (recordEffectLayout = this.v) == null) {
            return;
        }
        recordEffectLayout.setListener(iVar);
    }

    public void setEffectLayoutCurrentMusicName(String str) {
        RecordEffectLayout recordEffectLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048615, this, str) == null) || (recordEffectLayout = this.v) == null) {
            return;
        }
        recordEffectLayout.setCurrentMusicName(str);
    }

    public void setFilterData(List<QmFilterItem> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, list) == null) {
            ArrayList arrayList = new ArrayList();
            if (list != null && list.size() > 0) {
                for (QmFilterItem qmFilterItem : list) {
                    arrayList.add(new b.a.r0.c4.l.e.c.b(2, qmFilterItem.name, qmFilterItem, -1));
                }
            }
            RecordEffectLayout recordEffectLayout = this.v;
            if (recordEffectLayout != null) {
                recordEffectLayout.setFilterList(arrayList);
            }
        }
    }

    public void setHasLocalVideo(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048617, this, z) == null) {
            this.o = z;
        }
    }

    @Override // b.a.r0.q0.c.b
    public void setMusicData(List<MusicData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, list) == null) {
            if (list != null && list.size() > 0) {
                for (MusicData musicData : list) {
                    this.u.add(new b.a.r0.c4.l.e.c.b(3, musicData.name, musicData, -1));
                }
            }
            RecordEffectLayout recordEffectLayout = this.v;
            if (recordEffectLayout != null) {
                recordEffectLayout.setMusicList(this.u);
            }
        }
    }

    public void setMusicManager(b.a.r0.q0.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, aVar) == null) {
            this.f55739i = aVar;
        }
    }

    public void setMusicName(String str, String str2) {
        RecordEffectLayout recordEffectLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048620, this, str, str2) == null) || (recordEffectLayout = this.v) == null) {
            return;
        }
        recordEffectLayout.setMusicName(str, str2);
    }

    public void setRecordControlListener(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, eVar) == null) {
            this.n = eVar;
        }
    }

    public void setRecordManager(b.a.r0.g0.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, aVar) == null) {
            this.f55738h = aVar;
        }
    }

    public void setSelectedToLeftIndex() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            this.v.selectBeforeFilter();
        }
    }

    public void setSelectedToRightIndex() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            this.v.selectAfterFilter();
        }
    }

    public void setStickerItems(List<QmStickerItem> list) {
        RecordEffectLayout recordEffectLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048625, this, list) == null) || (recordEffectLayout = this.v) == null) {
            return;
        }
        recordEffectLayout.setStickerItems(list);
    }

    public void startRecordAnimator() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            this.f55737g.setVisibility(0);
            this.f55736f.startRecordAnimator(this.q);
        }
    }

    public void stopRecord() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            b.a.r0.g0.c.a aVar = this.f55738h;
            if (aVar != null && !aVar.c()) {
                b.a.r0.z.a.a aVar2 = this.j;
                if (aVar2 == null || aVar2.getProgress() < this.j.getMaxDuration()) {
                    return;
                }
                this.f55736f.pauseRecordAnimator();
                return;
            }
            b.a.r0.z.a.a aVar3 = this.j;
            if (aVar3 != null && aVar3.getProgress() > 0.0f) {
                this.f55736f.pauseRecordAnimator();
            }
            e eVar = this.n;
            if (eVar != null) {
                eVar.onStopRecord();
            }
        }
    }

    public void stopRecordAnimator() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            this.f55736f.stopRecordAnimator();
            this.f55737g.setVisibility(8);
        }
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
        this.o = true;
        this.r = new ArrayList();
        this.s = new ArrayList();
        this.t = new ArrayList();
        this.u = new ArrayList();
        this.w = new Handler();
        this.x = 2;
        init();
    }
}
