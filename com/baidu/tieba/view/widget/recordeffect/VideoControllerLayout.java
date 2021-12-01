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
import c.a.q0.d1.n0;
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
/* loaded from: classes11.dex */
public class VideoControllerLayout extends RelativeLayout implements View.OnTouchListener, c.a.r0.w0.c.b {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int TAB_PHOTO = 1;
    public static final int TAB_RECORD = 2;
    public static final int TYPE_FILTER = 1;
    public static final int TYPE_MUSIC = 2;
    public static final int TYPE_STICKER = 3;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public RelativeLayout f50726e;

    /* renamed from: f  reason: collision with root package name */
    public CaptureRecordButton f50727f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f50728g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.r0.l0.c.a f50729h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.r0.w0.c.a f50730i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.r0.e0.a.a f50731j;

    /* renamed from: k  reason: collision with root package name */
    public long f50732k;
    public boolean l;
    public List<ObjectAnimator> m;
    public e n;
    public boolean o;
    public boolean p;
    public boolean q;
    public List<c.a.r0.k4.m.e.c.b> r;
    public List<c.a.r0.k4.m.e.c.b> s;
    public List<QmStickerItem> t;
    public List<c.a.r0.k4.m.e.c.b> u;
    public RecordEffectLayout v;
    public Handler w;
    public int x;

    /* loaded from: classes11.dex */
    public class a extends c.a.r0.k4.m.e.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ VideoControllerLayout f50733f;

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
            this.f50733f = videoControllerLayout;
        }

        @Override // c.a.r0.k4.m.e.a, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                super.onAnimationEnd(animator);
                if ((this.f50733f.f50729h == null || !this.f50733f.f50729h.c()) && this.f50733f.n != null) {
                    this.f50733f.n.onStartRecord();
                }
            }
        }
    }

    /* loaded from: classes11.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f50734e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ VideoControllerLayout f50735f;

        public b(VideoControllerLayout videoControllerLayout, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoControllerLayout, Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50735f = videoControllerLayout;
            this.f50734e = j2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f50735f.l && this.f50735f.f50732k == this.f50734e) {
                this.f50735f.q = true;
                this.f50735f.s();
            }
        }
    }

    /* loaded from: classes11.dex */
    public class c extends c.a.r0.k4.m.e.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ VideoControllerLayout f50736f;

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
            this.f50736f = videoControllerLayout;
        }

        @Override // c.a.r0.k4.m.e.a, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, animator) == null) || this.f50736f.n == null) {
                return;
            }
            this.f50736f.n.onShowEffectLayout();
        }
    }

    /* loaded from: classes11.dex */
    public class d extends c.a.r0.k4.m.e.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f50737f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.k4.m.e.a f50738g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ VideoControllerLayout f50739h;

        public d(VideoControllerLayout videoControllerLayout, boolean z, c.a.r0.k4.m.e.a aVar) {
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
            this.f50739h = videoControllerLayout;
            this.f50737f = z;
            this.f50738g = aVar;
        }

        @Override // c.a.r0.k4.m.e.a, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, animator) == null) || this.f19051e) {
                return;
            }
            this.f50739h.v.setVisibility(8);
            if (this.f50739h.f50731j == null || this.f50739h.f50731j.getProgress() <= 0.0f) {
                this.f50739h.f50728g.setVisibility(8);
            } else {
                this.f50739h.f50728g.setVisibility(0);
            }
            if (this.f50739h.n != null) {
                this.f50739h.n.a(this.f50737f);
            }
            c.a.r0.k4.m.e.a aVar = this.f50738g;
            if (aVar != null) {
                aVar.onAnimationEnd(animator);
            }
        }
    }

    /* loaded from: classes11.dex */
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

    public List<c.a.r0.k4.m.e.c.b> getChoosedBeautyList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.r : (List) invokeV.objValue;
    }

    public List<c.a.r0.k4.m.e.c.b> getChoosedFilterList() {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f50728g : (TextView) invokeV.objValue;
    }

    public c.a.r0.k4.m.a getRecrodButton() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f50727f : (c.a.r0.k4.m.a) invokeV.objValue;
    }

    public void hideEffectLayout(c.a.r0.k4.m.e.a aVar, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048582, this, aVar, z) == null) || this.v.getVisibility() == 8) {
            return;
        }
        q();
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
        c.a.r0.e0.a.a aVar2 = this.f50731j;
        if (aVar2 != null && aVar2.getProgress() > 0.0f) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f50727f.getLayer2(), AnimationProperty.OPACITY, 0.0f, 1.0f);
            ofFloat.setDuration(100L);
            ofFloat.reverse();
            ObjectAnimator.ofFloat(this.f50727f.getLayer1(), AnimationProperty.SCALE_X, 0.388f, 0.276f).setDuration(320L).reverse();
            ObjectAnimator.ofFloat(this.f50727f.getLayer1(), AnimationProperty.SCALE_Y, 0.388f, 0.276f).setDuration(320L).reverse();
            return;
        }
        ObjectAnimator.ofFloat(this.f50727f.getLayer1(), AnimationProperty.SCALE_X, 1.0f, 0.681f).setDuration(320L).reverse();
        ObjectAnimator.ofFloat(this.f50727f.getLayer1(), AnimationProperty.SCALE_Y, 1.0f, 0.681f).setDuration(320L).reverse();
    }

    public boolean init() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.record_layout, this);
            RecordEffectLayout recordEffectLayout = (RecordEffectLayout) findViewById(R.id.layout_effect);
            this.v = recordEffectLayout;
            c.a.q0.s.u.c d2 = c.a.q0.s.u.c.d(recordEffectLayout);
            d2.n(R.string.J_X14);
            d2.f(R.color.CAM_X0214);
            this.f50726e = (RelativeLayout) findViewById(R.id.layout_record);
            CaptureRecordButton captureRecordButton = (CaptureRecordButton) findViewById(R.id.layout_record_button);
            this.f50727f = captureRecordButton;
            captureRecordButton.setOnTouchListener(this);
            TextView textView = (TextView) findViewById(R.id.layout_record_time);
            this.f50728g = textView;
            c.a.q0.s.u.c d3 = c.a.q0.s.u.c.d(textView);
            d3.A(R.string.F_X02);
            d3.y(R.array.S_O_X001);
            this.u.add(0, new c.a.r0.k4.m.e.c.b(3, getResources().getString(R.string.music_normal), new MusicData(MusicData.MUSIC_NORMAL_ID, 1, getResources().getString(R.string.music_normal)), R.drawable.icon_video_mute));
            this.u.add(1, new c.a.r0.k4.m.e.c.b(3, getResources().getString(R.string.music_cloud), new MusicData(MusicData.MUSIC_CLOUD_ID, 2, getResources().getString(R.string.music_cloud)), R.drawable.icon_video_cloudmusic));
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

    public final void n(int i2) {
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

    public void notifyStickerDataChanged() {
        RecordEffectLayout recordEffectLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (recordEffectLayout = this.v) == null) {
            return;
        }
        recordEffectLayout.notifyStickerDataChanged();
    }

    public final void o(View view, MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, view, motionEvent) == null) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    return;
                }
                this.f50727f.stopTakePhotoAnimator();
            } else if (this.v.getVisibility() == 0) {
                hideEffectLayout(null, true);
            } else {
                e eVar = this.n;
                if (eVar != null) {
                    eVar.onTakePhoto();
                    this.f50727f.startTakePhotoAnimator();
                }
            }
        }
    }

    public void onClickBeauty() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            n(1);
            if (isEffectLayoutVisible() && this.v.getCurrentEffectLayout() == 1) {
                hideEffectLayout(null, false);
                return;
            }
            if (!isEffectLayoutVisible()) {
                r();
            }
            this.v.onClickBeauty();
        }
    }

    public void onClickFilter() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            n(1);
            if (isEffectLayoutVisible() && this.v.getCurrentEffectLayout() == 2) {
                hideEffectLayout(null, false);
                return;
            }
            if (!isEffectLayoutVisible()) {
                r();
            }
            this.v.onClickFilter();
        }
    }

    public void onClickMusic() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            n(2);
            if (isEffectLayoutVisible() && this.v.getCurrentEffectLayout() == 3) {
                hideEffectLayout(null, false);
                return;
            }
            if (!isEffectLayoutVisible()) {
                r();
            }
            this.v.onClickMusic();
        }
    }

    public void onClickSticker() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            n(3);
            if (isEffectLayoutVisible() && this.v.getCurrentEffectLayout() == 0) {
                hideEffectLayout(null, false);
                return;
            }
            if (!isEffectLayoutVisible()) {
                r();
            }
            this.v.onClickSticker();
        }
    }

    public void onSaveMusicVideo(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048597, this, str, i2, str2) == null) {
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048598, this, view, motionEvent)) == null) {
            int i2 = this.x;
            if (i2 == 1) {
                o(view, motionEvent);
            } else if (i2 == 2) {
                p(view, motionEvent);
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public final void p(View view, MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048599, this, view, motionEvent) == null) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if ((action == 1 || action == 3) && !n0.b()) {
                    if (this.p) {
                        this.p = false;
                        return;
                    }
                    this.l = false;
                    if (this.f50729h.c()) {
                        stopRecord();
                        return;
                    }
                    this.q = false;
                    s();
                    return;
                }
                return;
            }
            e eVar = this.n;
            if (eVar != null) {
                eVar.hideMinVideoTips();
            }
            c.a.r0.w0.c.a aVar = this.f50730i;
            if (aVar != null && aVar.g()) {
                this.p = true;
                CustomToast.newInstance().showToast(R.string.music_is_downloading);
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            this.f50732k = currentTimeMillis;
            this.l = true;
            this.w.postDelayed(new b(this, currentTimeMillis), 200L);
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048600, this) == null) && ListUtils.isEmpty(this.m)) {
            ArrayList arrayList = new ArrayList();
            this.m = arrayList;
            arrayList.add(ObjectAnimator.ofFloat(this.v, AnimationProperty.TRANSLATE_Y, UtilHelper.getDimenPixelSize(R.dimen.tbds656), 0.0f));
            this.m.add(ObjectAnimator.ofFloat(this.f50726e, AnimationProperty.TRANSLATE_Y, 0.0f, UtilHelper.getDimenPixelSize(R.dimen.tbds207)));
            this.m.add(ObjectAnimator.ofFloat(this.f50727f.getPause(), AnimationProperty.SCALE_X, 1.0f, 0.681f));
            this.m.add(ObjectAnimator.ofFloat(this.f50727f.getPause(), AnimationProperty.SCALE_Y, 1.0f, 0.681f));
            this.m.add(ObjectAnimator.ofFloat(this.f50727f.getLayer2(), AnimationProperty.SCALE_X, 0.8f, 0.57f));
            this.m.add(ObjectAnimator.ofFloat(this.f50727f.getLayer2(), AnimationProperty.SCALE_Y, 0.8f, 0.57f));
            this.m.add(ObjectAnimator.ofFloat(this.f50727f.getLayer3(), AnimationProperty.SCALE_X, 1.0f, 0.57f));
            this.m.add(ObjectAnimator.ofFloat(this.f50727f.getLayer3(), AnimationProperty.SCALE_Y, 1.0f, 0.57f));
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.v, AnimationProperty.OPACITY, 0.0f, 1.0f);
            ofFloat.setStartDelay(120L);
            this.m.add(ofFloat);
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048601, this) == null) || this.v.getVisibility() == 0) {
            return;
        }
        this.v.setVisibility(0);
        this.f50728g.setVisibility(8);
        q();
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
        c.a.r0.e0.a.a aVar = this.f50731j;
        if (aVar != null && aVar.getProgress() > 0.0f) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f50727f.getLayer2(), AnimationProperty.OPACITY, 0.0f, 1.0f);
            ofFloat.setDuration(320L);
            ofFloat.start();
            ObjectAnimator.ofFloat(this.f50727f.getLayer1(), AnimationProperty.SCALE_X, 0.388f, 0.276f).setDuration(320L).start();
            ObjectAnimator.ofFloat(this.f50727f.getLayer1(), AnimationProperty.SCALE_Y, 0.388f, 0.276f).setDuration(320L).start();
            return;
        }
        ObjectAnimator.ofFloat(this.f50727f.getLayer1(), AnimationProperty.SCALE_X, 1.0f, 0.681f).setDuration(320L).start();
        ObjectAnimator.ofFloat(this.f50727f.getLayer1(), AnimationProperty.SCALE_Y, 1.0f, 0.681f).setDuration(320L).start();
    }

    public void resetEffect() {
        RecordEffectLayout recordEffectLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048602, this) == null) || (recordEffectLayout = this.v) == null) {
            return;
        }
        recordEffectLayout.resetEffect();
    }

    public void resetMusicPos() {
        RecordEffectLayout recordEffectLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048603, this) == null) || (recordEffectLayout = this.v) == null) {
            return;
        }
        recordEffectLayout.resetMusicPos();
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            c.a.r0.l0.c.a aVar = this.f50729h;
            if (aVar == null || !aVar.c()) {
                c.a.r0.e0.a.a aVar2 = this.f50731j;
                if (aVar2 != null && aVar2.getProgress() > 0.0f) {
                    this.f50727f.resumeRecordAnimator();
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
        recordEffectLayout.selectFilter(new c.a.r0.k4.m.e.c.b(2, qmFilterItem.name, qmFilterItem, -1));
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
                this.f50727f.getLayer1().setVisibility(8);
            } else if (i2 != 2) {
            } else {
                this.f50727f.getLayer1().setVisibility(0);
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

    public void setDurationManager(c.a.r0.e0.a.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, aVar) == null) {
            this.f50731j = aVar;
        }
    }

    public void setEditManager(c.a.r0.l0.a.a aVar) {
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
                    arrayList.add(new c.a.r0.k4.m.e.c.b(2, qmFilterItem.name, qmFilterItem, -1));
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

    @Override // c.a.r0.w0.c.b
    public void setMusicData(List<MusicData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, list) == null) {
            if (list != null && list.size() > 0) {
                for (MusicData musicData : list) {
                    this.u.add(new c.a.r0.k4.m.e.c.b(3, musicData.name, musicData, -1));
                }
            }
            RecordEffectLayout recordEffectLayout = this.v;
            if (recordEffectLayout != null) {
                recordEffectLayout.setMusicList(this.u);
            }
        }
    }

    public void setMusicManager(c.a.r0.w0.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, aVar) == null) {
            this.f50730i = aVar;
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

    public void setRecordManager(c.a.r0.l0.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, aVar) == null) {
            this.f50729h = aVar;
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
            this.f50728g.setVisibility(0);
            this.f50727f.startRecordAnimator(this.q);
        }
    }

    public void stopRecord() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            c.a.r0.l0.c.a aVar = this.f50729h;
            if (aVar != null && !aVar.c()) {
                c.a.r0.e0.a.a aVar2 = this.f50731j;
                if (aVar2 == null || aVar2.getProgress() < this.f50731j.getMaxDuration()) {
                    return;
                }
                this.f50727f.pauseRecordAnimator();
                return;
            }
            c.a.r0.e0.a.a aVar3 = this.f50731j;
            if (aVar3 != null && aVar3.getProgress() > 0.0f) {
                this.f50727f.pauseRecordAnimator();
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
            this.f50727f.stopRecordAnimator();
            this.f50728g.setVisibility(8);
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
        this.f50732k = 0L;
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
