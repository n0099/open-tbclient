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
import c.a.r0.l4.l.h;
import c.a.r0.l4.l.l;
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
public class VideoControllerLayout extends RelativeLayout implements View.OnClickListener, View.OnTouchListener, VideoEffectButtonLayout.a, c.a.r0.l4.i.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f47252e;

    /* renamed from: f  reason: collision with root package name */
    public RelativeLayout f47253f;

    /* renamed from: g  reason: collision with root package name */
    public VideoRecordButton f47254g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f47255h;

    /* renamed from: i  reason: collision with root package name */
    public h f47256i;

    /* renamed from: j  reason: collision with root package name */
    public long f47257j;
    public boolean k;
    public AnimatorSet l;
    public AnimatorSet m;
    public List<ObjectAnimator> n;
    public f o;
    public boolean p;
    public boolean q;
    public List<c.a.r0.l4.l.d> r;
    public List<c.a.r0.l4.l.d> s;
    public List<StickerItem> t;
    public List<c.a.r0.l4.l.d> u;
    public VideoEffectLayout v;
    public Handler w;
    public int x;

    /* loaded from: classes6.dex */
    public class a extends l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f47258f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ VideoControllerLayout f47259g;

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
            this.f47259g = videoControllerLayout;
            this.f47258f = z;
        }

        @Override // c.a.r0.l4.l.l, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                if (this.f47259g.f47256i.f() == 6 || this.f47259g.f47256i.j()) {
                    this.f47259g.u(this.f47258f);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ VideoControllerLayout f47260f;

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
            this.f47260f = videoControllerLayout;
        }

        @Override // c.a.r0.l4.l.l, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, animator) == null) || this.f19239e) {
                return;
            }
            this.f47260f.f47252e.setVisibility(8);
            this.f47260f.f47255h.setVisibility(8);
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f47261e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ VideoControllerLayout f47262f;

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
            this.f47262f = videoControllerLayout;
            this.f47261e = j2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f47262f.k && this.f47262f.f47257j == this.f47261e) {
                TiebaStatic.log("c12297");
                this.f47262f.t(true);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d extends l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ VideoControllerLayout f47263f;

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
            this.f47263f = videoControllerLayout;
        }

        @Override // c.a.r0.l4.l.l, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, animator) == null) || this.f47263f.o == null) {
                return;
            }
            this.f47263f.o.onShowEffectLayout();
        }
    }

    /* loaded from: classes6.dex */
    public class e extends l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ l f47264f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ VideoControllerLayout f47265g;

        public e(VideoControllerLayout videoControllerLayout, l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoControllerLayout, lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47265g = videoControllerLayout;
            this.f47264f = lVar;
        }

        @Override // c.a.r0.l4.l.l, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, animator) == null) || this.f19239e) {
                return;
            }
            this.f47265g.v.setVisibility(8);
            if (this.f47265g.o != null) {
                this.f47265g.o.onHideEffectLayout();
            }
            l lVar = this.f47264f;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f47257j = 0L;
        this.k = false;
        this.p = true;
        this.r = new ArrayList();
        this.s = new ArrayList();
        this.t = new ArrayList();
        this.u = new ArrayList();
        this.w = new Handler();
        p();
    }

    public void changeStatue(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.f47256i.m(i2);
            f fVar = this.o;
            if (fVar != null) {
                fVar.onStatusChange();
            }
            if (i2 == 1) {
                this.f47252e.setVisibility(8);
                this.f47255h.setVisibility(8);
            } else if (i2 == 3) {
                this.f47252e.setImageResource(R.drawable.video_back_selector);
                this.f47255h.setImageResource(R.drawable.icon_video_confirm_d);
            } else if (i2 == 4) {
                this.f47252e.setImageResource(R.drawable.video_back_selector);
                this.f47255h.setImageResource(R.drawable.video_confirm_selector);
            } else if (i2 == 5) {
                this.f47252e.setImageResource(R.drawable.video_delete_selector);
                h hVar = this.f47256i;
                if (hVar != null && hVar.g() >= 3000.0f) {
                    this.f47255h.setImageResource(R.drawable.video_confirm_selector);
                } else {
                    this.f47255h.setImageResource(R.drawable.icon_video_confirm_d);
                }
            }
        }
    }

    public List<c.a.r0.l4.l.d> getChoosedBeautyList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.r : (List) invokeV.objValue;
    }

    public List<c.a.r0.l4.l.d> getChoosedFilterList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.s : (List) invokeV.objValue;
    }

    public List<StickerItem> getChoosedStickerList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.t : (List) invokeV.objValue;
    }

    public void hideEffectLayout(l lVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, lVar) == null) || this.v.getVisibility() == 8) {
            return;
        }
        q();
        this.f47255h.setEnabled(true);
        this.f47252e.setEnabled(true);
        if (this.f47256i.f() != 6 && !this.f47256i.j()) {
            changeStatue(this.f47256i.f());
        } else {
            this.f47252e.setVisibility(8);
            this.f47255h.setVisibility(8);
        }
        for (int i2 = 0; i2 < this.n.size(); i2++) {
            ObjectAnimator objectAnimator = this.n.get(i2);
            if (objectAnimator != null) {
                objectAnimator.setDuration(500L);
                objectAnimator.cancel();
                objectAnimator.removeAllListeners();
                if (i2 == this.n.size() - 1) {
                    objectAnimator.addListener(new e(this, lVar));
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

    public final void n(View view, MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view, motionEvent) == null) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    return;
                }
                this.f47254g.stopTakePhotoAnimator();
            } else if (this.f47256i.f() == 6) {
                this.f47256i.m(1);
                f fVar = this.o;
                if (fVar != null) {
                    fVar.onCancelCountDowning();
                    this.o.onStopRecord();
                }
                this.f47254g.getTvTip().setText("");
                this.f47254g.getTvTip().setVisibility(8);
            } else if (this.v.getVisibility() == 0) {
                hideEffectLayout(null);
            } else {
                f fVar2 = this.o;
                if (fVar2 != null) {
                    fVar2.onTakePhoto();
                    this.f47254g.startTakePhotoAnimator();
                }
            }
        }
    }

    public void notifyStickerDataChanged() {
        VideoEffectLayout videoEffectLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (videoEffectLayout = this.v) == null) {
            return;
        }
        videoEffectLayout.notifyStickerDataChanged();
    }

    public final void o(View view, MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, view, motionEvent) == null) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 1 || action == 3) {
                    if (this.q) {
                        this.q = false;
                        return;
                    }
                    this.k = false;
                    if (!this.f47256i.j() && this.f47256i.f() != 6) {
                        if (this.f47256i.f() != 8) {
                            t(false);
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
            if (this.f47256i.f() == 7 || this.f47256i.f() == 6) {
                return;
            }
            h hVar = this.f47256i;
            if (hVar != null && hVar.i()) {
                this.q = true;
                CustomToast.newInstance().showToast(R.string.music_is_downloading);
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            this.f47257j = currentTimeMillis;
            this.k = true;
            this.w.postDelayed(new c(this, currentTimeMillis), 200L);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, view) == null) {
            if (view == this.f47252e) {
                f fVar = this.o;
                if (fVar != null) {
                    fVar.hideMinVideoTips();
                }
                int f2 = this.f47256i.f();
                h hVar = this.f47256i;
                if (hVar == null || hVar.g() <= 0 || f2 <= 2) {
                    return;
                }
                if (f2 == 5) {
                    TiebaStatic.log("c12299");
                    this.f47256i.d();
                    r(this.r);
                    r(this.s);
                    r(this.t);
                    if (this.f47256i.g() >= 3000.0f) {
                        changeStatue(4);
                        return;
                    } else {
                        changeStatue(this.f47256i.g() > 0 ? 3 : 1);
                        return;
                    }
                }
                this.f47256i.l();
                changeStatue(5);
            } else if (view == this.f47255h) {
                TiebaStatic.log("c12300");
                h hVar2 = this.f47256i;
                if (hVar2 == null || hVar2.f() <= 2 || this.o == null) {
                    return;
                }
                if (this.f47256i.g() >= 3000.0f) {
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
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            if (isEffectLayoutVisible() && this.v.getCurrentEffectLayout() == 1) {
                hideEffectLayout(null);
                return;
            }
            if (!isEffectLayoutVisible()) {
                s();
            }
            this.v.onClickBeauty();
        }
    }

    public void onClickCountDown() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            if (this.v.getVisibility() == 0) {
                hideEffectLayout(null);
            }
            u(false);
            this.f47254g.getLayer1().setVisibility(8);
            this.f47254g.getTvTip().setText(getResources().getText(R.string.video_record_button_cancel));
            this.f47254g.getTvTip().setVisibility(0);
            f fVar = this.o;
            if (fVar != null) {
                fVar.onStartRecord();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void onClickFilter() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            if (isEffectLayoutVisible() && this.v.getCurrentEffectLayout() == 2) {
                hideEffectLayout(null);
                return;
            }
            if (!isEffectLayoutVisible()) {
                s();
            }
            this.v.onClickFilter();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void onClickMusic() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            if (isEffectLayoutVisible() && this.v.getCurrentEffectLayout() == 3) {
                hideEffectLayout(null);
                return;
            }
            if (!isEffectLayoutVisible()) {
                s();
            }
            this.v.onClickMusic();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void onClickSticker() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            if (isEffectLayoutVisible() && this.v.getCurrentEffectLayout() == 0) {
                hideEffectLayout(null);
                return;
            }
            if (!isEffectLayoutVisible()) {
                s();
            }
            this.v.onClickSticker();
        }
    }

    public void onCountDownEnd() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && this.f47256i.f() == 6) {
            if (this.x == 2) {
                changeStatue(7);
                this.f47254g.setAlpha(1.0f);
                this.f47252e.setVisibility(8);
                this.f47255h.setVisibility(8);
                this.f47254g.getTvTip().setText(getResources().getString(R.string.video_record_button_pasue));
                h hVar = this.f47256i;
                if (hVar != null) {
                    hVar.n();
                    return;
                }
                return;
            }
            this.f47254g.getTvTip().setVisibility(8);
            f fVar = this.o;
            if (fVar != null) {
                fVar.onTakePhoto();
            }
        }
    }

    @Override // c.a.r0.l4.i.b
    public void onSaveMusicVideo(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048594, this, str, i2, str2) == null) {
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048595, this, view, motionEvent)) == null) {
            int i2 = this.x;
            if (i2 == 1) {
                n(view, motionEvent);
            } else if (i2 == 2) {
                o(view, motionEvent);
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.record_controller_layout, this);
            this.v = (VideoEffectLayout) findViewById(R.id.layout_effect);
            this.f47253f = (RelativeLayout) findViewById(R.id.layout_record);
            ImageView imageView = (ImageView) findViewById(R.id.delete_video);
            this.f47252e = imageView;
            imageView.setOnClickListener(this);
            VideoRecordButton videoRecordButton = (VideoRecordButton) findViewById(R.id.layout_record_button);
            this.f47254g = videoRecordButton;
            videoRecordButton.setOnTouchListener(this);
            ImageView imageView2 = (ImageView) findViewById(R.id.confirm_video);
            this.f47255h = imageView2;
            imageView2.setOnClickListener(this);
            this.u.add(0, new c.a.r0.l4.l.d(3, getResources().getString(R.string.music_normal), new MusicData(com.baidu.tieba.external.music.data.MusicData.MUSIC_NORMAL_ID, 1, getResources().getString(R.string.music_normal)), R.drawable.icon_video_mute));
            this.u.add(1, new c.a.r0.l4.l.d(3, getResources().getString(R.string.music_cloud), new MusicData(com.baidu.tieba.external.music.data.MusicData.MUSIC_CLOUD_ID, 2, getResources().getString(R.string.music_cloud)), R.drawable.icon_video_cloudmusic));
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048597, this) == null) && ListUtils.isEmpty(this.n)) {
            ArrayList arrayList = new ArrayList();
            this.n = arrayList;
            arrayList.add(ObjectAnimator.ofFloat(this.v, AnimationProperty.TRANSLATE_Y, 1000.0f, 0.0f));
            this.n.add(ObjectAnimator.ofFloat(this.f47253f, AnimationProperty.TRANSLATE_Y, 0.0f, n.f(getContext(), R.dimen.ds100)));
            this.n.add(ObjectAnimator.ofFloat(this.f47254g.getLayer3(), AnimationProperty.SCALE_X, 0.766f, 0.585f));
            this.n.add(ObjectAnimator.ofFloat(this.f47254g.getLayer3(), AnimationProperty.SCALE_Y, 0.766f, 0.585f));
            this.n.add(ObjectAnimator.ofFloat(this.f47254g.getLayer2(), AnimationProperty.SCALE_X, 1.0f, 0.82f));
            this.n.add(ObjectAnimator.ofFloat(this.f47254g.getLayer2(), AnimationProperty.SCALE_Y, 1.0f, 0.82f));
            this.n.add(ObjectAnimator.ofFloat(this.f47255h, AnimationProperty.SCALE_X, 1.0f, 0.7f));
            this.n.add(ObjectAnimator.ofFloat(this.f47255h, AnimationProperty.SCALE_Y, 1.0f, 0.7f));
            this.n.add(ObjectAnimator.ofFloat(this.f47252e, AnimationProperty.SCALE_X, 1.0f, 0.7f));
            this.n.add(ObjectAnimator.ofFloat(this.f47252e, AnimationProperty.SCALE_Y, 1.0f, 0.7f));
            this.n.add(ObjectAnimator.ofFloat(this.f47255h, AnimationProperty.OPACITY, 1.0f, 0.0f));
            this.n.add(ObjectAnimator.ofFloat(this.f47252e, AnimationProperty.OPACITY, 1.0f, 0.0f));
        }
    }

    public final void r(List list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        list.remove(list.size() - 1);
    }

    public void resetEffect() {
        VideoEffectLayout videoEffectLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048599, this) == null) || (videoEffectLayout = this.v) == null) {
            return;
        }
        videoEffectLayout.resetEffect();
    }

    public void resetMusicPos() {
        VideoEffectLayout videoEffectLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048600, this) == null) || (videoEffectLayout = this.v) == null) {
            return;
        }
        videoEffectLayout.resetMusicPos();
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048601, this) == null) || this.v.getVisibility() == 0) {
            return;
        }
        this.v.setVisibility(0);
        q();
        this.f47255h.setEnabled(false);
        this.f47252e.setEnabled(false);
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

    public void selectCloudMusic() {
        VideoEffectLayout videoEffectLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048602, this) == null) || (videoEffectLayout = this.v) == null) {
            return;
        }
        videoEffectLayout.selectCloudMusic();
    }

    public void selectSticker(StickerItem stickerItem) {
        VideoEffectLayout videoEffectLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048603, this, stickerItem) == null) || (videoEffectLayout = this.v) == null) {
            return;
        }
        videoEffectLayout.selectStrick(stickerItem);
    }

    public void setCurrentTab(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i2) == null) {
            this.x = i2;
            if (i2 == 1) {
                this.f47252e.setVisibility(4);
                this.f47255h.setVisibility(4);
                this.f47254g.getLayer1().setVisibility(8);
            } else if (i2 != 2) {
            } else {
                if (this.f47256i.f() != 1) {
                    this.f47252e.setVisibility(0);
                    this.f47255h.setVisibility(0);
                }
                this.f47254g.getLayer1().setVisibility(0);
            }
        }
    }

    public void setDownLoadSticker(StickerItem stickerItem) {
        VideoEffectLayout videoEffectLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048605, this, stickerItem) == null) || (videoEffectLayout = this.v) == null) {
            return;
        }
        videoEffectLayout.setDownLoadStrick(stickerItem);
    }

    public void setEffectChoosedListener(VideoEffectLayout.h hVar) {
        VideoEffectLayout videoEffectLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048606, this, hVar) == null) || (videoEffectLayout = this.v) == null) {
            return;
        }
        videoEffectLayout.setListener(hVar);
    }

    public void setHasLocalVideo(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048607, this, z) == null) {
            this.p = z;
        }
    }

    @Override // c.a.r0.l4.i.b
    public void setMusicData(List<MusicData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, list) == null) {
            if (list != null && list.size() > 0) {
                for (MusicData musicData : list) {
                    this.u.add(new c.a.r0.l4.l.d(3, musicData.name, musicData, -1));
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
        if (interceptable == null || interceptable.invokeL(1048609, this, fVar) == null) {
            this.o = fVar;
        }
    }

    public void setRecordController(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, hVar) == null) {
            this.f47256i = hVar;
            changeStatue(1);
        }
    }

    public void setStickerItems(List<StickerItem> list) {
        VideoEffectLayout videoEffectLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048611, this, list) == null) || (videoEffectLayout = this.v) == null) {
            return;
        }
        videoEffectLayout.setStickerItems(list);
    }

    public void stopRecord() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            stopRecordAnimator();
            int f2 = this.f47256i.f();
            h hVar = this.f47256i;
            if (hVar != null) {
                if (!hVar.h() && this.f47256i.j()) {
                    this.f47256i.o();
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
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            h hVar = this.f47256i;
            if (hVar == null || hVar.j() || this.f47256i.f() == 6) {
                AnimatorSet animatorSet = this.l;
                if (animatorSet != null && animatorSet.isRunning()) {
                    this.l.cancel();
                }
                if (this.m == null) {
                    AnimatorSet animatorSet2 = new AnimatorSet();
                    this.m = animatorSet2;
                    animatorSet2.playTogether(ObjectAnimator.ofFloat(this.f47252e, AnimationProperty.OPACITY, 0.0f, 1.0f), ObjectAnimator.ofFloat(this.f47255h, AnimationProperty.OPACITY, 0.0f, 1.0f));
                    this.m.setDuration(300L);
                }
                this.f47252e.setVisibility(0);
                this.f47255h.setVisibility(0);
                this.m.start();
                if (this.f47256i.f() != 7 && this.f47256i.f() != 6) {
                    this.f47254g.stopRecordAnimator();
                    return;
                }
                this.f47254g.getTvTip().setVisibility(8);
                if (this.x == 2) {
                    this.f47254g.getLayer1().setVisibility(0);
                }
            }
        }
    }

    public final void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048614, this, z) == null) {
            if (this.f47256i.e() >= 100) {
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
                u(z);
            }
            h hVar = this.f47256i;
            if (hVar != null) {
                hVar.n();
            }
            f fVar2 = this.o;
            if (fVar2 != null) {
                fVar2.onStartRecord();
            }
        }
    }

    public final void u(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048615, this, z) == null) {
            AnimatorSet animatorSet = this.m;
            if (animatorSet != null && animatorSet.isRunning()) {
                this.m.cancel();
            }
            if (this.l == null) {
                AnimatorSet animatorSet2 = new AnimatorSet();
                this.l = animatorSet2;
                animatorSet2.playTogether(ObjectAnimator.ofFloat(this.f47252e, AnimationProperty.OPACITY, 1.0f, 0.0f), ObjectAnimator.ofFloat(this.f47255h, AnimationProperty.OPACITY, 1.0f, 0.0f));
                this.l.addListener(new b(this));
                this.l.setDuration(300L);
            }
            this.l.start();
            if (this.f47256i.f() != 6) {
                this.f47254g.startRecordAnimator(z);
            }
        }
    }

    public void updateStatus() {
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048616, this) == null) || (hVar = this.f47256i) == null) {
            return;
        }
        if (hVar.g() >= 3000.0f) {
            changeStatue(4);
        } else if (this.f47256i.g() > 0) {
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
        this.f47257j = 0L;
        this.k = false;
        this.p = true;
        this.r = new ArrayList();
        this.s = new ArrayList();
        this.t = new ArrayList();
        this.u = new ArrayList();
        this.w = new Handler();
        p();
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
        this.f47257j = 0L;
        this.k = false;
        this.p = true;
        this.r = new ArrayList();
        this.s = new ArrayList();
        this.t = new ArrayList();
        this.u = new ArrayList();
        this.w = new Handler();
        p();
    }
}
