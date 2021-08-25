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
import c.a.e.e.p.l;
import c.a.q0.w3.l.i;
import c.a.q0.w3.l.m;
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
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class VideoControllerLayout extends RelativeLayout implements View.OnClickListener, View.OnTouchListener, VideoEffectButtonLayout.a, c.a.q0.w3.i.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f57553e;

    /* renamed from: f  reason: collision with root package name */
    public RelativeLayout f57554f;

    /* renamed from: g  reason: collision with root package name */
    public VideoRecordButton f57555g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f57556h;

    /* renamed from: i  reason: collision with root package name */
    public i f57557i;

    /* renamed from: j  reason: collision with root package name */
    public long f57558j;
    public boolean k;
    public AnimatorSet l;
    public AnimatorSet m;
    public List<ObjectAnimator> n;
    public f o;
    public boolean p;
    public boolean q;
    public List<c.a.q0.w3.l.e> r;
    public List<c.a.q0.w3.l.e> s;
    public List<StickerItem> t;
    public List<c.a.q0.w3.l.e> u;
    public VideoEffectLayout v;
    public Handler w;
    public int x;

    /* loaded from: classes7.dex */
    public class a extends m {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f57559f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ VideoControllerLayout f57560g;

        public a(VideoControllerLayout videoControllerLayout, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoControllerLayout, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57560g = videoControllerLayout;
            this.f57559f = z;
        }

        @Override // c.a.q0.w3.l.m, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                if (this.f57560g.f57557i.f() == 6 || this.f57560g.f57557i.j()) {
                    this.f57560g.q(this.f57559f);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends m {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ VideoControllerLayout f57561f;

        public b(VideoControllerLayout videoControllerLayout) {
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
            this.f57561f = videoControllerLayout;
        }

        @Override // c.a.q0.w3.l.m, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, animator) == null) || this.f28508e) {
                return;
            }
            this.f57561f.f57553e.setVisibility(8);
            this.f57561f.f57556h.setVisibility(8);
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f57562e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ VideoControllerLayout f57563f;

        public c(VideoControllerLayout videoControllerLayout, long j2) {
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
            this.f57563f = videoControllerLayout;
            this.f57562e = j2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f57563f.k && this.f57563f.f57558j == this.f57562e) {
                TiebaStatic.log("c12297");
                this.f57563f.p(true);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d extends m {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ VideoControllerLayout f57564f;

        public d(VideoControllerLayout videoControllerLayout) {
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
            this.f57564f = videoControllerLayout;
        }

        @Override // c.a.q0.w3.l.m, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, animator) == null) || this.f57564f.o == null) {
                return;
            }
            this.f57564f.o.onShowEffectLayout();
        }
    }

    /* loaded from: classes7.dex */
    public class e extends m {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ m f57565f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ VideoControllerLayout f57566g;

        public e(VideoControllerLayout videoControllerLayout, m mVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoControllerLayout, mVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57566g = videoControllerLayout;
            this.f57565f = mVar;
        }

        @Override // c.a.q0.w3.l.m, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, animator) == null) || this.f28508e) {
                return;
            }
            this.f57566g.v.setVisibility(8);
            if (this.f57566g.o != null) {
                this.f57566g.o.onHideEffectLayout();
            }
            m mVar = this.f57565f;
            if (mVar != null) {
                mVar.onAnimationEnd(animator);
            }
        }
    }

    /* loaded from: classes7.dex */
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f57558j = 0L;
        this.k = false;
        this.p = true;
        this.r = new ArrayList();
        this.s = new ArrayList();
        this.t = new ArrayList();
        this.u = new ArrayList();
        this.w = new Handler();
        l();
    }

    public void changeStatue(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.f57557i.m(i2);
            f fVar = this.o;
            if (fVar != null) {
                fVar.onStatusChange();
            }
            if (i2 == 1) {
                this.f57553e.setVisibility(8);
                this.f57556h.setVisibility(8);
            } else if (i2 == 3) {
                this.f57553e.setImageResource(R.drawable.video_back_selector);
                this.f57556h.setImageResource(R.drawable.icon_video_confirm_d);
            } else if (i2 == 4) {
                this.f57553e.setImageResource(R.drawable.video_back_selector);
                this.f57556h.setImageResource(R.drawable.video_confirm_selector);
            } else if (i2 == 5) {
                this.f57553e.setImageResource(R.drawable.video_delete_selector);
                i iVar = this.f57557i;
                if (iVar != null && iVar.g() >= 3000.0f) {
                    this.f57556h.setImageResource(R.drawable.video_confirm_selector);
                } else {
                    this.f57556h.setImageResource(R.drawable.icon_video_confirm_d);
                }
            }
        }
    }

    public List<c.a.q0.w3.l.e> getChoosedBeautyList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.r : (List) invokeV.objValue;
    }

    public List<c.a.q0.w3.l.e> getChoosedFilterList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.s : (List) invokeV.objValue;
    }

    public List<StickerItem> getChoosedStickerList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.t : (List) invokeV.objValue;
    }

    public void hideEffectLayout(m mVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, mVar) == null) || this.v.getVisibility() == 8) {
            return;
        }
        m();
        this.f57556h.setEnabled(true);
        this.f57553e.setEnabled(true);
        if (this.f57557i.f() != 6 && !this.f57557i.j()) {
            changeStatue(this.f57557i.f());
        } else {
            this.f57553e.setVisibility(8);
            this.f57556h.setVisibility(8);
        }
        for (int i2 = 0; i2 < this.n.size(); i2++) {
            ObjectAnimator objectAnimator = this.n.get(i2);
            if (objectAnimator != null) {
                objectAnimator.setDuration(500L);
                objectAnimator.cancel();
                objectAnimator.removeAllListeners();
                if (i2 == this.n.size() - 1) {
                    objectAnimator.addListener(new e(this, mVar));
                }
                objectAnimator.reverse();
            }
        }
    }

    public boolean isEffectLayoutVisible() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.v.getVisibility() == 0 : invokeV.booleanValue;
    }

    public boolean isHasLocalVideo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.p : invokeV.booleanValue;
    }

    public boolean isNeedLoadSticker() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            VideoEffectLayout videoEffectLayout = this.v;
            if (videoEffectLayout != null) {
                return videoEffectLayout.isNeedLoadSticker();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void j(View view, MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view, motionEvent) == null) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    return;
                }
                this.f57555g.stopTakePhotoAnimator();
            } else if (this.f57557i.f() == 6) {
                this.f57557i.m(1);
                f fVar = this.o;
                if (fVar != null) {
                    fVar.onCancelCountDowning();
                    this.o.onStopRecord();
                }
                this.f57555g.getTvTip().setText("");
                this.f57555g.getTvTip().setVisibility(8);
            } else if (this.v.getVisibility() == 0) {
                hideEffectLayout(null);
            } else {
                f fVar2 = this.o;
                if (fVar2 != null) {
                    fVar2.onTakePhoto();
                    this.f57555g.startTakePhotoAnimator();
                }
            }
        }
    }

    public final void k(View view, MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, view, motionEvent) == null) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 1 || action == 3) {
                    if (this.q) {
                        this.q = false;
                        return;
                    }
                    this.k = false;
                    if (!this.f57557i.j() && this.f57557i.f() != 6) {
                        if (this.f57557i.f() != 8) {
                            p(false);
                            return;
                        }
                        return;
                    }
                    TiebaStatic.log("c12298");
                    stopRecord();
                    return;
                }
                return;
            }
            f fVar = this.o;
            if (fVar != null) {
                fVar.hideMinVideoTips();
            }
            if (this.f57557i.f() == 7 || this.f57557i.f() == 6) {
                return;
            }
            i iVar = this.f57557i;
            if (iVar != null && iVar.i()) {
                this.q = true;
                CustomToast.newInstance().showToast(R.string.music_is_downloading);
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            this.f57558j = currentTimeMillis;
            this.k = true;
            this.w.postDelayed(new c(this, currentTimeMillis), 200L);
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.record_controller_layout, this);
            this.v = (VideoEffectLayout) findViewById(R.id.layout_effect);
            this.f57554f = (RelativeLayout) findViewById(R.id.layout_record);
            ImageView imageView = (ImageView) findViewById(R.id.delete_video);
            this.f57553e = imageView;
            imageView.setOnClickListener(this);
            VideoRecordButton videoRecordButton = (VideoRecordButton) findViewById(R.id.layout_record_button);
            this.f57555g = videoRecordButton;
            videoRecordButton.setOnTouchListener(this);
            ImageView imageView2 = (ImageView) findViewById(R.id.confirm_video);
            this.f57556h = imageView2;
            imageView2.setOnClickListener(this);
            this.u.add(0, new c.a.q0.w3.l.e(3, getResources().getString(R.string.music_normal), new MusicData(com.baidu.tieba.external.music.data.MusicData.MUSIC_NORMAL_ID, 1, getResources().getString(R.string.music_normal)), R.drawable.icon_video_mute));
            this.u.add(1, new c.a.q0.w3.l.e(3, getResources().getString(R.string.music_cloud), new MusicData(com.baidu.tieba.external.music.data.MusicData.MUSIC_CLOUD_ID, 2, getResources().getString(R.string.music_cloud)), R.drawable.icon_video_cloudmusic));
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && ListUtils.isEmpty(this.n)) {
            ArrayList arrayList = new ArrayList();
            this.n = arrayList;
            arrayList.add(ObjectAnimator.ofFloat(this.v, "translationY", 1000.0f, 0.0f));
            this.n.add(ObjectAnimator.ofFloat(this.f57554f, "translationY", 0.0f, l.g(getContext(), R.dimen.ds100)));
            this.n.add(ObjectAnimator.ofFloat(this.f57555g.getLayer3(), "scaleX", 0.766f, 0.585f));
            this.n.add(ObjectAnimator.ofFloat(this.f57555g.getLayer3(), "scaleY", 0.766f, 0.585f));
            this.n.add(ObjectAnimator.ofFloat(this.f57555g.getLayer2(), "scaleX", 1.0f, 0.82f));
            this.n.add(ObjectAnimator.ofFloat(this.f57555g.getLayer2(), "scaleY", 1.0f, 0.82f));
            this.n.add(ObjectAnimator.ofFloat(this.f57556h, "scaleX", 1.0f, 0.7f));
            this.n.add(ObjectAnimator.ofFloat(this.f57556h, "scaleY", 1.0f, 0.7f));
            this.n.add(ObjectAnimator.ofFloat(this.f57553e, "scaleX", 1.0f, 0.7f));
            this.n.add(ObjectAnimator.ofFloat(this.f57553e, "scaleY", 1.0f, 0.7f));
            this.n.add(ObjectAnimator.ofFloat(this.f57556h, "alpha", 1.0f, 0.0f));
            this.n.add(ObjectAnimator.ofFloat(this.f57553e, "alpha", 1.0f, 0.0f));
        }
    }

    public final void n(List list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        list.remove(list.size() - 1);
    }

    public void notifyStickerDataChanged() {
        VideoEffectLayout videoEffectLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (videoEffectLayout = this.v) == null) {
            return;
        }
        videoEffectLayout.notifyStickerDataChanged();
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || this.v.getVisibility() == 0) {
            return;
        }
        this.v.setVisibility(0);
        m();
        this.f57556h.setEnabled(false);
        this.f57553e.setEnabled(false);
        for (int i2 = 0; i2 < this.n.size(); i2++) {
            ObjectAnimator objectAnimator = this.n.get(i2);
            if (objectAnimator != null) {
                objectAnimator.cancel();
                objectAnimator.setDuration(500L);
                objectAnimator.removeAllListeners();
                if (i2 == this.n.size() - 1) {
                    objectAnimator.addListener(new d(this));
                }
                objectAnimator.start();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, view) == null) {
            if (view == this.f57553e) {
                f fVar = this.o;
                if (fVar != null) {
                    fVar.hideMinVideoTips();
                }
                int f2 = this.f57557i.f();
                i iVar = this.f57557i;
                if (iVar == null || iVar.g() <= 0 || f2 <= 2) {
                    return;
                }
                if (f2 == 5) {
                    TiebaStatic.log("c12299");
                    this.f57557i.d();
                    n(this.r);
                    n(this.s);
                    n(this.t);
                    if (this.f57557i.g() >= 3000.0f) {
                        changeStatue(4);
                        return;
                    } else {
                        changeStatue(this.f57557i.g() > 0 ? 3 : 1);
                        return;
                    }
                }
                this.f57557i.l();
                changeStatue(5);
            } else if (view == this.f57556h) {
                TiebaStatic.log("c12300");
                i iVar2 = this.f57557i;
                if (iVar2 == null || iVar2.f() <= 2 || this.o == null) {
                    return;
                }
                if (this.f57557i.g() >= 3000.0f) {
                    this.o.onRecordDone();
                } else {
                    this.o.onRecordShort();
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void onClickBeauty() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            if (isEffectLayoutVisible() && this.v.getCurrentEffectLayout() == 1) {
                hideEffectLayout(null);
                return;
            }
            if (!isEffectLayoutVisible()) {
                o();
            }
            this.v.onClickBeauty();
        }
    }

    public void onClickCountDown() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            if (this.v.getVisibility() == 0) {
                hideEffectLayout(null);
            }
            q(false);
            this.f57555g.getLayer1().setVisibility(8);
            this.f57555g.getTvTip().setText(getResources().getText(R.string.video_record_button_cancel));
            this.f57555g.getTvTip().setVisibility(0);
            f fVar = this.o;
            if (fVar != null) {
                fVar.onStartRecord();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void onClickFilter() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            if (isEffectLayoutVisible() && this.v.getCurrentEffectLayout() == 2) {
                hideEffectLayout(null);
                return;
            }
            if (!isEffectLayoutVisible()) {
                o();
            }
            this.v.onClickFilter();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void onClickMusic() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            if (isEffectLayoutVisible() && this.v.getCurrentEffectLayout() == 3) {
                hideEffectLayout(null);
                return;
            }
            if (!isEffectLayoutVisible()) {
                o();
            }
            this.v.onClickMusic();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void onClickSticker() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            if (isEffectLayoutVisible() && this.v.getCurrentEffectLayout() == 0) {
                hideEffectLayout(null);
                return;
            }
            if (!isEffectLayoutVisible()) {
                o();
            }
            this.v.onClickSticker();
        }
    }

    public void onCountDownEnd() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048597, this) == null) && this.f57557i.f() == 6) {
            if (this.x == 2) {
                changeStatue(7);
                this.f57555g.setAlpha(1.0f);
                this.f57553e.setVisibility(8);
                this.f57556h.setVisibility(8);
                this.f57555g.getTvTip().setText(getResources().getString(R.string.video_record_button_pasue));
                i iVar = this.f57557i;
                if (iVar != null) {
                    iVar.n();
                    return;
                }
                return;
            }
            this.f57555g.getTvTip().setVisibility(8);
            f fVar = this.o;
            if (fVar != null) {
                fVar.onTakePhoto();
            }
        }
    }

    @Override // c.a.q0.w3.i.b
    public void onSaveMusicVideo(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048598, this, str, i2, str2) == null) {
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048599, this, view, motionEvent)) == null) {
            int i2 = this.x;
            if (i2 == 1) {
                j(view, motionEvent);
            } else if (i2 == 2) {
                k(view, motionEvent);
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public final void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            if (this.f57557i.e() >= 100) {
                f fVar = this.o;
                if (fVar != null) {
                    fVar.onRecordDone();
                    return;
                }
                return;
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
            changeStatue(2);
            if (this.v.getVisibility() == 0) {
                hideEffectLayout(new a(this, z));
            } else {
                q(z);
            }
            i iVar = this.f57557i;
            if (iVar != null) {
                iVar.n();
            }
            f fVar2 = this.o;
            if (fVar2 != null) {
                fVar2.onStartRecord();
            }
        }
    }

    public final void q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            AnimatorSet animatorSet = this.m;
            if (animatorSet != null && animatorSet.isRunning()) {
                this.m.cancel();
            }
            if (this.l == null) {
                AnimatorSet animatorSet2 = new AnimatorSet();
                this.l = animatorSet2;
                animatorSet2.playTogether(ObjectAnimator.ofFloat(this.f57553e, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.f57556h, "alpha", 1.0f, 0.0f));
                this.l.addListener(new b(this));
                this.l.setDuration(300L);
            }
            this.l.start();
            if (this.f57557i.f() != 6) {
                this.f57555g.startRecordAnimator(z);
            }
        }
    }

    public void resetEffect() {
        VideoEffectLayout videoEffectLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048602, this) == null) || (videoEffectLayout = this.v) == null) {
            return;
        }
        videoEffectLayout.resetEffect();
    }

    public void resetMusicPos() {
        VideoEffectLayout videoEffectLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048603, this) == null) || (videoEffectLayout = this.v) == null) {
            return;
        }
        videoEffectLayout.resetMusicPos();
    }

    public void selectCloudMusic() {
        VideoEffectLayout videoEffectLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048604, this) == null) || (videoEffectLayout = this.v) == null) {
            return;
        }
        videoEffectLayout.selectCloudMusic();
    }

    public void selectSticker(StickerItem stickerItem) {
        VideoEffectLayout videoEffectLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048605, this, stickerItem) == null) || (videoEffectLayout = this.v) == null) {
            return;
        }
        videoEffectLayout.selectStrick(stickerItem);
    }

    public void setCurrentTab(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048606, this, i2) == null) {
            this.x = i2;
            if (i2 == 1) {
                this.f57553e.setVisibility(4);
                this.f57556h.setVisibility(4);
                this.f57555g.getLayer1().setVisibility(8);
            } else if (i2 != 2) {
            } else {
                if (this.f57557i.f() != 1) {
                    this.f57553e.setVisibility(0);
                    this.f57556h.setVisibility(0);
                }
                this.f57555g.getLayer1().setVisibility(0);
            }
        }
    }

    public void setDownLoadSticker(StickerItem stickerItem) {
        VideoEffectLayout videoEffectLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048607, this, stickerItem) == null) || (videoEffectLayout = this.v) == null) {
            return;
        }
        videoEffectLayout.setDownLoadStrick(stickerItem);
    }

    public void setEffectChoosedListener(VideoEffectLayout.h hVar) {
        VideoEffectLayout videoEffectLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048608, this, hVar) == null) || (videoEffectLayout = this.v) == null) {
            return;
        }
        videoEffectLayout.setListener(hVar);
    }

    public void setHasLocalVideo(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048609, this, z) == null) {
            this.p = z;
        }
    }

    @Override // c.a.q0.w3.i.b
    public void setMusicData(List<MusicData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, list) == null) {
            if (list != null && list.size() > 0) {
                for (MusicData musicData : list) {
                    this.u.add(new c.a.q0.w3.l.e(3, musicData.name, musicData, -1));
                }
            }
            VideoEffectLayout videoEffectLayout = this.v;
            if (videoEffectLayout != null) {
                videoEffectLayout.setMusicList(this.u);
            }
        }
    }

    public void setRecordControlListener(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, fVar) == null) {
            this.o = fVar;
        }
    }

    public void setRecordController(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, iVar) == null) {
            this.f57557i = iVar;
            changeStatue(1);
        }
    }

    public void setStickerItems(List<StickerItem> list) {
        VideoEffectLayout videoEffectLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048613, this, list) == null) || (videoEffectLayout = this.v) == null) {
            return;
        }
        videoEffectLayout.setStickerItems(list);
    }

    public void stopRecord() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            stopRecordAnimator();
            int f2 = this.f57557i.f();
            i iVar = this.f57557i;
            if (iVar != null) {
                if (!iVar.h() && this.f57557i.j()) {
                    this.f57557i.o();
                }
                updateStatus();
            }
            f fVar = this.o;
            if (fVar != null) {
                fVar.onStopRecord();
                if (f2 == 6) {
                    this.o.onCancelCountDowning();
                }
            }
        }
    }

    public void stopRecordAnimator() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            i iVar = this.f57557i;
            if (iVar == null || iVar.j() || this.f57557i.f() == 6) {
                AnimatorSet animatorSet = this.l;
                if (animatorSet != null && animatorSet.isRunning()) {
                    this.l.cancel();
                }
                if (this.m == null) {
                    AnimatorSet animatorSet2 = new AnimatorSet();
                    this.m = animatorSet2;
                    animatorSet2.playTogether(ObjectAnimator.ofFloat(this.f57553e, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.f57556h, "alpha", 0.0f, 1.0f));
                    this.m.setDuration(300L);
                }
                this.f57553e.setVisibility(0);
                this.f57556h.setVisibility(0);
                this.m.start();
                if (this.f57557i.f() != 7 && this.f57557i.f() != 6) {
                    this.f57555g.stopRecordAnimator();
                    return;
                }
                this.f57555g.getTvTip().setVisibility(8);
                if (this.x == 2) {
                    this.f57555g.getLayer1().setVisibility(0);
                }
            }
        }
    }

    public void updateStatus() {
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048616, this) == null) || (iVar = this.f57557i) == null) {
            return;
        }
        if (iVar.g() >= 3000.0f) {
            changeStatue(4);
        } else if (this.f57557i.g() > 0) {
            changeStatue(3);
        } else {
            changeStatue(1);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f57558j = 0L;
        this.k = false;
        this.p = true;
        this.r = new ArrayList();
        this.s = new ArrayList();
        this.t = new ArrayList();
        this.u = new ArrayList();
        this.w = new Handler();
        l();
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
        this.f57558j = 0L;
        this.k = false;
        this.p = true;
        this.r = new ArrayList();
        this.s = new ArrayList();
        this.t = new ArrayList();
        this.u = new ArrayList();
        this.w = new Handler();
        l();
    }
}
