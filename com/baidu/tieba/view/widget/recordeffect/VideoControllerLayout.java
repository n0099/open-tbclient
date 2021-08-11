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
import c.a.o0.b1.m0;
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
/* loaded from: classes7.dex */
public class VideoControllerLayout extends RelativeLayout implements View.OnTouchListener, c.a.p0.o0.c.b {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int TAB_PHOTO = 1;
    public static final int TAB_RECORD = 2;
    public static final int TYPE_FILTER = 1;
    public static final int TYPE_MUSIC = 2;
    public static final int TYPE_STICKER = 3;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public RelativeLayout f58316e;

    /* renamed from: f  reason: collision with root package name */
    public CaptureRecordButton f58317f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f58318g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.p0.f0.c.a f58319h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.p0.o0.c.a f58320i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.p0.y.a.a f58321j;
    public long k;
    public boolean l;
    public List<ObjectAnimator> m;
    public e n;
    public boolean o;
    public boolean p;
    public boolean q;
    public List<c.a.p0.a4.l.e.c.b> r;
    public List<c.a.p0.a4.l.e.c.b> s;
    public List<QmStickerItem> t;
    public List<c.a.p0.a4.l.e.c.b> u;
    public RecordEffectLayout v;
    public Handler w;
    public int x;

    /* loaded from: classes7.dex */
    public class a extends c.a.p0.a4.l.e.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ VideoControllerLayout f58322f;

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
            this.f58322f = videoControllerLayout;
        }

        @Override // c.a.p0.a4.l.e.a, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                super.onAnimationEnd(animator);
                if ((this.f58322f.f58319h == null || !this.f58322f.f58319h.c()) && this.f58322f.n != null) {
                    this.f58322f.n.onStartRecord();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f58323e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ VideoControllerLayout f58324f;

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
            this.f58324f = videoControllerLayout;
            this.f58323e = j2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f58324f.l && this.f58324f.k == this.f58323e) {
                this.f58324f.q = true;
                this.f58324f.o();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends c.a.p0.a4.l.e.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ VideoControllerLayout f58325f;

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
            this.f58325f = videoControllerLayout;
        }

        @Override // c.a.p0.a4.l.e.a, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, animator) == null) || this.f58325f.n == null) {
                return;
            }
            this.f58325f.n.onShowEffectLayout();
        }
    }

    /* loaded from: classes7.dex */
    public class d extends c.a.p0.a4.l.e.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f58326f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a4.l.e.a f58327g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ VideoControllerLayout f58328h;

        public d(VideoControllerLayout videoControllerLayout, boolean z, c.a.p0.a4.l.e.a aVar) {
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
            this.f58328h = videoControllerLayout;
            this.f58326f = z;
            this.f58327g = aVar;
        }

        @Override // c.a.p0.a4.l.e.a, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, animator) == null) || this.f15565e) {
                return;
            }
            this.f58328h.v.setVisibility(8);
            if (this.f58328h.f58321j == null || this.f58328h.f58321j.getProgress() <= 0.0f) {
                this.f58328h.f58318g.setVisibility(8);
            } else {
                this.f58328h.f58318g.setVisibility(0);
            }
            if (this.f58328h.n != null) {
                this.f58328h.n.a(this.f58326f);
            }
            c.a.p0.a4.l.e.a aVar = this.f58327g;
            if (aVar != null) {
                aVar.onAnimationEnd(animator);
            }
        }
    }

    /* loaded from: classes7.dex */
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

    public List<c.a.p0.a4.l.e.c.b> getChoosedBeautyList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.r : (List) invokeV.objValue;
    }

    public List<c.a.p0.a4.l.e.c.b> getChoosedFilterList() {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f58318g : (TextView) invokeV.objValue;
    }

    public c.a.p0.a4.l.a getRecrodButton() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f58317f : (c.a.p0.a4.l.a) invokeV.objValue;
    }

    public void hideEffectLayout(c.a.p0.a4.l.e.a aVar, boolean z) {
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
        c.a.p0.y.a.a aVar2 = this.f58321j;
        if (aVar2 != null && aVar2.getProgress() > 0.0f) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f58317f.getLayer2(), "alpha", 0.0f, 1.0f);
            ofFloat.setDuration(100L);
            ofFloat.reverse();
            ObjectAnimator.ofFloat(this.f58317f.getLayer1(), "scaleX", 0.388f, 0.276f).setDuration(320L).reverse();
            ObjectAnimator.ofFloat(this.f58317f.getLayer1(), "scaleY", 0.388f, 0.276f).setDuration(320L).reverse();
            return;
        }
        ObjectAnimator.ofFloat(this.f58317f.getLayer1(), "scaleX", 1.0f, 0.681f).setDuration(320L).reverse();
        ObjectAnimator.ofFloat(this.f58317f.getLayer1(), "scaleY", 1.0f, 0.681f).setDuration(320L).reverse();
    }

    public boolean init() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.record_layout, this);
            RecordEffectLayout recordEffectLayout = (RecordEffectLayout) findViewById(R.id.layout_effect);
            this.v = recordEffectLayout;
            c.a.o0.s.u.c d2 = c.a.o0.s.u.c.d(recordEffectLayout);
            d2.n(R.string.J_X14);
            d2.f(R.color.CAM_X0214);
            this.f58316e = (RelativeLayout) findViewById(R.id.layout_record);
            CaptureRecordButton captureRecordButton = (CaptureRecordButton) findViewById(R.id.layout_record_button);
            this.f58317f = captureRecordButton;
            captureRecordButton.setOnTouchListener(this);
            TextView textView = (TextView) findViewById(R.id.layout_record_time);
            this.f58318g = textView;
            c.a.o0.s.u.c d3 = c.a.o0.s.u.c.d(textView);
            d3.y(R.string.F_X02);
            d3.w(R.array.S_O_X001);
            this.u.add(0, new c.a.p0.a4.l.e.c.b(3, getResources().getString(R.string.music_normal), new MusicData(MusicData.MUSIC_NORMAL_ID, 1, getResources().getString(R.string.music_normal)), R.drawable.icon_video_mute));
            this.u.add(1, new c.a.p0.a4.l.e.c.b(3, getResources().getString(R.string.music_cloud), new MusicData(MusicData.MUSIC_CLOUD_ID, 2, getResources().getString(R.string.music_cloud)), R.drawable.icon_video_cloudmusic));
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
                this.f58317f.stopTakePhotoAnimator();
            } else if (this.v.getVisibility() == 0) {
                hideEffectLayout(null, true);
            } else {
                e eVar = this.n;
                if (eVar != null) {
                    eVar.onTakePhoto();
                    this.f58317f.startTakePhotoAnimator();
                }
            }
        }
    }

    public final void l(View view, MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, view, motionEvent) == null) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if ((action == 1 || action == 3) && !m0.b()) {
                    if (this.p) {
                        this.p = false;
                        return;
                    }
                    this.l = false;
                    if (this.f58319h.c()) {
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
            c.a.p0.o0.c.a aVar = this.f58320i;
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
            arrayList.add(ObjectAnimator.ofFloat(this.v, "translationY", UtilHelper.getDimenPixelSize(R.dimen.tbds656), 0.0f));
            this.m.add(ObjectAnimator.ofFloat(this.f58316e, "translationY", 0.0f, UtilHelper.getDimenPixelSize(R.dimen.tbds207)));
            this.m.add(ObjectAnimator.ofFloat(this.f58317f.getPause(), "scaleX", 1.0f, 0.681f));
            this.m.add(ObjectAnimator.ofFloat(this.f58317f.getPause(), "scaleY", 1.0f, 0.681f));
            this.m.add(ObjectAnimator.ofFloat(this.f58317f.getLayer2(), "scaleX", 0.8f, 0.57f));
            this.m.add(ObjectAnimator.ofFloat(this.f58317f.getLayer2(), "scaleY", 0.8f, 0.57f));
            this.m.add(ObjectAnimator.ofFloat(this.f58317f.getLayer3(), "scaleX", 1.0f, 0.57f));
            this.m.add(ObjectAnimator.ofFloat(this.f58317f.getLayer3(), "scaleY", 1.0f, 0.57f));
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.v, "alpha", 0.0f, 1.0f);
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
        this.f58318g.setVisibility(8);
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
        c.a.p0.y.a.a aVar = this.f58321j;
        if (aVar != null && aVar.getProgress() > 0.0f) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f58317f.getLayer2(), "alpha", 0.0f, 1.0f);
            ofFloat.setDuration(320L);
            ofFloat.start();
            ObjectAnimator.ofFloat(this.f58317f.getLayer1(), "scaleX", 0.388f, 0.276f).setDuration(320L).start();
            ObjectAnimator.ofFloat(this.f58317f.getLayer1(), "scaleY", 0.388f, 0.276f).setDuration(320L).start();
            return;
        }
        ObjectAnimator.ofFloat(this.f58317f.getLayer1(), "scaleX", 1.0f, 0.681f).setDuration(320L).start();
        ObjectAnimator.ofFloat(this.f58317f.getLayer1(), "scaleY", 1.0f, 0.681f).setDuration(320L).start();
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
            c.a.p0.f0.c.a aVar = this.f58319h;
            if (aVar == null || !aVar.c()) {
                c.a.p0.y.a.a aVar2 = this.f58321j;
                if (aVar2 != null && aVar2.getProgress() > 0.0f) {
                    this.f58317f.resumeRecordAnimator();
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
        recordEffectLayout.selectFilter(new c.a.p0.a4.l.e.c.b(2, qmFilterItem.name, qmFilterItem, -1));
    }

    public void selectSticker(QmStickerItem qmStickerItem) {
        RecordEffectLayout recordEffectLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048607, this, qmStickerItem) == null) || (recordEffectLayout = this.v) == null) {
            return;
        }
        recordEffectLayout.selectStrick(qmStickerItem);
    }

    public void setCurrentTab(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i2) == null) {
            this.x = i2;
            if (i2 == 1) {
                this.f58317f.getLayer1().setVisibility(8);
            } else if (i2 != 2) {
            } else {
                this.f58317f.getLayer1().setVisibility(0);
            }
        }
    }

    public void setDownLoadFilter(QmFilterItem qmFilterItem) {
        RecordEffectLayout recordEffectLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048609, this, qmFilterItem) == null) || (recordEffectLayout = this.v) == null) {
            return;
        }
        recordEffectLayout.setDownLoadFilter(qmFilterItem);
    }

    public void setDownLoadSticker(QmStickerItem qmStickerItem, boolean z) {
        RecordEffectLayout recordEffectLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048610, this, qmStickerItem, z) == null) || (recordEffectLayout = this.v) == null) {
            return;
        }
        recordEffectLayout.setDownLoadStrick(qmStickerItem, z);
    }

    public void setDurationManager(c.a.p0.y.a.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, aVar) == null) {
            this.f58321j = aVar;
        }
    }

    public void setEditManager(c.a.p0.f0.a.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, aVar) == null) {
        }
    }

    public void setEffectChoosedListener(RecordEffectLayout.i iVar) {
        RecordEffectLayout recordEffectLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048613, this, iVar) == null) || (recordEffectLayout = this.v) == null) {
            return;
        }
        recordEffectLayout.setListener(iVar);
    }

    public void setEffectLayoutCurrentMusicName(String str) {
        RecordEffectLayout recordEffectLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048614, this, str) == null) || (recordEffectLayout = this.v) == null) {
            return;
        }
        recordEffectLayout.setCurrentMusicName(str);
    }

    public void setFilterData(List<QmFilterItem> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, list) == null) {
            ArrayList arrayList = new ArrayList();
            if (list != null && list.size() > 0) {
                for (QmFilterItem qmFilterItem : list) {
                    arrayList.add(new c.a.p0.a4.l.e.c.b(2, qmFilterItem.name, qmFilterItem, -1));
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
        if (interceptable == null || interceptable.invokeZ(1048616, this, z) == null) {
            this.o = z;
        }
    }

    @Override // c.a.p0.o0.c.b
    public void setMusicData(List<MusicData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, list) == null) {
            if (list != null && list.size() > 0) {
                for (MusicData musicData : list) {
                    this.u.add(new c.a.p0.a4.l.e.c.b(3, musicData.name, musicData, -1));
                }
            }
            RecordEffectLayout recordEffectLayout = this.v;
            if (recordEffectLayout != null) {
                recordEffectLayout.setMusicList(this.u);
            }
        }
    }

    public void setMusicManager(c.a.p0.o0.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, aVar) == null) {
            this.f58320i = aVar;
        }
    }

    public void setMusicName(String str, String str2) {
        RecordEffectLayout recordEffectLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048619, this, str, str2) == null) || (recordEffectLayout = this.v) == null) {
            return;
        }
        recordEffectLayout.setMusicName(str, str2);
    }

    public void setRecordControlListener(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, eVar) == null) {
            this.n = eVar;
        }
    }

    public void setRecordManager(c.a.p0.f0.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, aVar) == null) {
            this.f58319h = aVar;
        }
    }

    public void setSelectedToLeftIndex() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            this.v.selectBeforeFilter();
        }
    }

    public void setSelectedToRightIndex() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            this.v.selectAfterFilter();
        }
    }

    public void setStickerItems(List<QmStickerItem> list) {
        RecordEffectLayout recordEffectLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048624, this, list) == null) || (recordEffectLayout = this.v) == null) {
            return;
        }
        recordEffectLayout.setStickerItems(list);
    }

    public void startRecordAnimator() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048625, this) == null) {
            this.f58318g.setVisibility(0);
            this.f58317f.startRecordAnimator(this.q);
        }
    }

    public void stopRecord() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            c.a.p0.f0.c.a aVar = this.f58319h;
            if (aVar != null && !aVar.c()) {
                c.a.p0.y.a.a aVar2 = this.f58321j;
                if (aVar2 == null || aVar2.getProgress() < this.f58321j.getMaxDuration()) {
                    return;
                }
                this.f58317f.pauseRecordAnimator();
                return;
            }
            c.a.p0.y.a.a aVar3 = this.f58321j;
            if (aVar3 != null && aVar3.getProgress() > 0.0f) {
                this.f58317f.pauseRecordAnimator();
            }
            e eVar = this.n;
            if (eVar != null) {
                eVar.onStopRecord();
            }
        }
    }

    public void stopRecordAnimator() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            this.f58317f.stopRecordAnimator();
            this.f58318g.setVisibility(8);
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
