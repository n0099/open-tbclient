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
import d.a.c.e.p.l;
import d.a.p0.v3.j.i;
import d.a.p0.v3.j.m;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class VideoControllerLayout extends RelativeLayout implements View.OnClickListener, View.OnTouchListener, VideoEffectButtonLayout.a, d.a.p0.v3.g.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f21698e;

    /* renamed from: f  reason: collision with root package name */
    public RelativeLayout f21699f;

    /* renamed from: g  reason: collision with root package name */
    public VideoRecordButton f21700g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f21701h;

    /* renamed from: i  reason: collision with root package name */
    public i f21702i;
    public long j;
    public boolean k;
    public AnimatorSet l;
    public AnimatorSet m;
    public List<ObjectAnimator> n;
    public f o;
    public boolean p;
    public List<d.a.p0.v3.j.e> q;
    public List<d.a.p0.v3.j.e> r;
    public List<StickerItem> s;
    public List<d.a.p0.v3.j.e> t;
    public VideoEffectLayout u;
    public Handler v;
    public int w;

    /* loaded from: classes4.dex */
    public class a extends m {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f21703f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ VideoControllerLayout f21704g;

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
            this.f21704g = videoControllerLayout;
            this.f21703f = z;
        }

        @Override // d.a.p0.v3.j.m, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                if (this.f21704g.f21702i.f() == 6 || this.f21704g.f21702i.j()) {
                    this.f21704g.z(this.f21703f);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends m {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ VideoControllerLayout f21705f;

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
            this.f21705f = videoControllerLayout;
        }

        @Override // d.a.p0.v3.j.m, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, animator) == null) || this.f65667e) {
                return;
            }
            this.f21705f.f21698e.setVisibility(8);
            this.f21705f.f21701h.setVisibility(8);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f21706e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ VideoControllerLayout f21707f;

        public c(VideoControllerLayout videoControllerLayout, long j) {
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
            this.f21707f = videoControllerLayout;
            this.f21706e = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f21707f.k && this.f21707f.j == this.f21706e) {
                TiebaStatic.log("c12297");
                this.f21707f.y(true);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends m {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ VideoControllerLayout f21708f;

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
            this.f21708f = videoControllerLayout;
        }

        @Override // d.a.p0.v3.j.m, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, animator) == null) || this.f21708f.o == null) {
                return;
            }
            this.f21708f.o.onShowEffectLayout();
        }
    }

    /* loaded from: classes4.dex */
    public class e extends m {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ m f21709f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ VideoControllerLayout f21710g;

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
            this.f21710g = videoControllerLayout;
            this.f21709f = mVar;
        }

        @Override // d.a.p0.v3.j.m, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, animator) == null) || this.f65667e) {
                return;
            }
            this.f21710g.u.setVisibility(8);
            if (this.f21710g.o != null) {
                this.f21710g.o.onHideEffectLayout();
            }
            m mVar = this.f21709f;
            if (mVar != null) {
                mVar.onAnimationEnd(animator);
            }
        }
    }

    /* loaded from: classes4.dex */
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
        this.j = 0L;
        this.k = false;
        this.q = new ArrayList();
        this.r = new ArrayList();
        this.s = new ArrayList();
        this.t = new ArrayList();
        this.v = new Handler();
        n();
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            B();
            int f2 = this.f21702i.f();
            i iVar = this.f21702i;
            if (iVar != null) {
                if (!iVar.h() && this.f21702i.j()) {
                    this.f21702i.o();
                }
                F();
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

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            i iVar = this.f21702i;
            if (iVar == null || iVar.j() || this.f21702i.f() == 6) {
                AnimatorSet animatorSet = this.l;
                if (animatorSet != null && animatorSet.isRunning()) {
                    this.l.cancel();
                }
                if (this.m == null) {
                    AnimatorSet animatorSet2 = new AnimatorSet();
                    this.m = animatorSet2;
                    animatorSet2.playTogether(ObjectAnimator.ofFloat(this.f21698e, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.f21701h, "alpha", 0.0f, 1.0f));
                    this.m.setDuration(300L);
                }
                this.f21698e.setVisibility(0);
                this.f21701h.setVisibility(0);
                this.m.start();
                if (this.f21702i.f() != 7 && this.f21702i.f() != 6) {
                    this.f21700g.d();
                    return;
                }
                this.f21700g.getTvTip().setVisibility(8);
                if (this.w == 2) {
                    this.f21700g.getLayer1().setVisibility(0);
                }
            }
        }
    }

    public void F() {
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (iVar = this.f21702i) == null) {
            return;
        }
        if (iVar.g() >= 3000.0f) {
            j(4);
        } else if (this.f21702i.g() > 0) {
            j(3);
        } else {
            j(1);
        }
    }

    public List<d.a.p0.v3.j.e> getChoosedBeautyList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.q : (List) invokeV.objValue;
    }

    public List<d.a.p0.v3.j.e> getChoosedFilterList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.r : (List) invokeV.objValue;
    }

    public List<StickerItem> getChoosedStickerList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.s : (List) invokeV.objValue;
    }

    public void j(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.f21702i.m(i2);
            f fVar = this.o;
            if (fVar != null) {
                fVar.onStatusChange();
            }
            if (i2 == 1) {
                this.f21698e.setVisibility(8);
                this.f21701h.setVisibility(8);
            } else if (i2 == 3) {
                this.f21698e.setImageResource(R.drawable.video_back_selector);
                this.f21701h.setImageResource(R.drawable.icon_video_confirm_d);
            } else if (i2 == 4) {
                this.f21698e.setImageResource(R.drawable.video_back_selector);
                this.f21701h.setImageResource(R.drawable.video_confirm_selector);
            } else if (i2 == 5) {
                this.f21698e.setImageResource(R.drawable.video_delete_selector);
                i iVar = this.f21702i;
                if (iVar != null && iVar.g() >= 3000.0f) {
                    this.f21701h.setImageResource(R.drawable.video_confirm_selector);
                } else {
                    this.f21701h.setImageResource(R.drawable.icon_video_confirm_d);
                }
            }
        }
    }

    public final void k(View view, MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, view, motionEvent) == null) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    return;
                }
                this.f21700g.e();
            } else if (this.f21702i.f() == 6) {
                this.f21702i.m(1);
                f fVar = this.o;
                if (fVar != null) {
                    fVar.onCancelCountDowning();
                    this.o.onStopRecord();
                }
                this.f21700g.getTvTip().setText("");
                this.f21700g.getTvTip().setVisibility(8);
            } else if (this.u.getVisibility() == 0) {
                m(null);
            } else {
                f fVar2 = this.o;
                if (fVar2 != null) {
                    fVar2.onTakePhoto();
                    this.f21700g.c();
                }
            }
        }
    }

    public final void l(View view, MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view, motionEvent) == null) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 1 || action == 3) {
                    if (this.p) {
                        this.p = false;
                        return;
                    }
                    this.k = false;
                    if (!this.f21702i.j() && this.f21702i.f() != 6) {
                        if (this.f21702i.f() != 8) {
                            y(false);
                            return;
                        }
                        return;
                    }
                    TiebaStatic.log("c12298");
                    A();
                    return;
                }
                return;
            }
            f fVar = this.o;
            if (fVar != null) {
                fVar.hideMinVideoTips();
            }
            if (this.f21702i.f() == 7 || this.f21702i.f() == 6) {
                return;
            }
            i iVar = this.f21702i;
            if (iVar != null && iVar.i()) {
                this.p = true;
                CustomToast.newInstance().showToast(R.string.music_is_downloading);
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            this.j = currentTimeMillis;
            this.k = true;
            this.v.postDelayed(new c(this, currentTimeMillis), 200L);
        }
    }

    public void m(m mVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, mVar) == null) || this.u.getVisibility() == 8) {
            return;
        }
        o();
        this.f21701h.setEnabled(true);
        this.f21698e.setEnabled(true);
        if (this.f21702i.f() != 6 && !this.f21702i.j()) {
            j(this.f21702i.f());
        } else {
            this.f21698e.setVisibility(8);
            this.f21701h.setVisibility(8);
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

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.record_controller_layout, this);
            this.u = (VideoEffectLayout) findViewById(R.id.layout_effect);
            this.f21699f = (RelativeLayout) findViewById(R.id.layout_record);
            ImageView imageView = (ImageView) findViewById(R.id.delete_video);
            this.f21698e = imageView;
            imageView.setOnClickListener(this);
            VideoRecordButton videoRecordButton = (VideoRecordButton) findViewById(R.id.layout_record_button);
            this.f21700g = videoRecordButton;
            videoRecordButton.setOnTouchListener(this);
            ImageView imageView2 = (ImageView) findViewById(R.id.confirm_video);
            this.f21701h = imageView2;
            imageView2.setOnClickListener(this);
            this.t.add(0, new d.a.p0.v3.j.e(3, getResources().getString(R.string.music_normal), new MusicData(com.baidu.tieba.external.music.data.MusicData.MUSIC_NORMAL_ID, 1, getResources().getString(R.string.music_normal)), R.drawable.icon_video_mute));
            this.t.add(1, new d.a.p0.v3.j.e(3, getResources().getString(R.string.music_cloud), new MusicData(com.baidu.tieba.external.music.data.MusicData.MUSIC_CLOUD_ID, 2, getResources().getString(R.string.music_cloud)), R.drawable.icon_video_cloudmusic));
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && ListUtils.isEmpty(this.n)) {
            ArrayList arrayList = new ArrayList();
            this.n = arrayList;
            arrayList.add(ObjectAnimator.ofFloat(this.u, "translationY", 1000.0f, 0.0f));
            this.n.add(ObjectAnimator.ofFloat(this.f21699f, "translationY", 0.0f, l.g(getContext(), R.dimen.ds100)));
            this.n.add(ObjectAnimator.ofFloat(this.f21700g.getLayer3(), "scaleX", 0.766f, 0.585f));
            this.n.add(ObjectAnimator.ofFloat(this.f21700g.getLayer3(), "scaleY", 0.766f, 0.585f));
            this.n.add(ObjectAnimator.ofFloat(this.f21700g.getLayer2(), "scaleX", 1.0f, 0.82f));
            this.n.add(ObjectAnimator.ofFloat(this.f21700g.getLayer2(), "scaleY", 1.0f, 0.82f));
            this.n.add(ObjectAnimator.ofFloat(this.f21701h, "scaleX", 1.0f, 0.7f));
            this.n.add(ObjectAnimator.ofFloat(this.f21701h, "scaleY", 1.0f, 0.7f));
            this.n.add(ObjectAnimator.ofFloat(this.f21698e, "scaleX", 1.0f, 0.7f));
            this.n.add(ObjectAnimator.ofFloat(this.f21698e, "scaleY", 1.0f, 0.7f));
            this.n.add(ObjectAnimator.ofFloat(this.f21701h, "alpha", 1.0f, 0.0f));
            this.n.add(ObjectAnimator.ofFloat(this.f21698e, "alpha", 1.0f, 0.0f));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, view) == null) {
            if (view == this.f21698e) {
                f fVar = this.o;
                if (fVar != null) {
                    fVar.hideMinVideoTips();
                }
                int f2 = this.f21702i.f();
                i iVar = this.f21702i;
                if (iVar == null || iVar.g() <= 0 || f2 <= 2) {
                    return;
                }
                if (f2 == 5) {
                    TiebaStatic.log("c12299");
                    this.f21702i.d();
                    t(this.q);
                    t(this.r);
                    t(this.s);
                    if (this.f21702i.g() >= 3000.0f) {
                        j(4);
                        return;
                    } else {
                        j(this.f21702i.g() > 0 ? 3 : 1);
                        return;
                    }
                }
                this.f21702i.l();
                j(5);
            } else if (view == this.f21701h) {
                TiebaStatic.log("c12300");
                i iVar2 = this.f21702i;
                if (iVar2 == null || iVar2.f() <= 2 || this.o == null) {
                    return;
                }
                if (this.f21702i.g() >= 3000.0f) {
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
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            if (p() && this.u.getCurrentEffectLayout() == 1) {
                m(null);
                return;
            }
            if (!p()) {
                x();
            }
            this.u.onClickBeauty();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void onClickFilter() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            if (p() && this.u.getCurrentEffectLayout() == 2) {
                m(null);
                return;
            }
            if (!p()) {
                x();
            }
            this.u.onClickFilter();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void onClickMusic() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            if (p() && this.u.getCurrentEffectLayout() == 3) {
                m(null);
                return;
            }
            if (!p()) {
                x();
            }
            this.u.onClickMusic();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void onClickSticker() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            if (p() && this.u.getCurrentEffectLayout() == 0) {
                m(null);
                return;
            }
            if (!p()) {
                x();
            }
            this.u.onClickSticker();
        }
    }

    @Override // d.a.p0.v3.g.b
    public void onSaveMusicVideo(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048593, this, str, i2, str2) == null) {
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048594, this, view, motionEvent)) == null) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.u.getVisibility() == 0 : invokeV.booleanValue;
    }

    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            VideoEffectLayout videoEffectLayout = this.u;
            if (videoEffectLayout != null) {
                return videoEffectLayout.t();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            if (this.u.getVisibility() == 0) {
                m(null);
            }
            z(false);
            this.f21700g.getLayer1().setVisibility(8);
            this.f21700g.getTvTip().setText(getResources().getText(R.string.video_record_button_cancel));
            this.f21700g.getTvTip().setVisibility(0);
            f fVar = this.o;
            if (fVar != null) {
                fVar.onStartRecord();
            }
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048598, this) == null) && this.f21702i.f() == 6) {
            if (this.w == 2) {
                j(7);
                this.f21700g.setAlpha(1.0f);
                this.f21698e.setVisibility(8);
                this.f21701h.setVisibility(8);
                this.f21700g.getTvTip().setText(getResources().getString(R.string.video_record_button_pasue));
                i iVar = this.f21702i;
                if (iVar != null) {
                    iVar.n();
                    return;
                }
                return;
            }
            this.f21700g.getTvTip().setVisibility(8);
            f fVar = this.o;
            if (fVar != null) {
                fVar.onTakePhoto();
            }
        }
    }

    public void setCurrentTab(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i2) == null) {
            this.w = i2;
            if (i2 == 1) {
                this.f21698e.setVisibility(4);
                this.f21701h.setVisibility(4);
                this.f21700g.getLayer1().setVisibility(8);
            } else if (i2 != 2) {
            } else {
                if (this.f21702i.f() != 1) {
                    this.f21698e.setVisibility(0);
                    this.f21701h.setVisibility(0);
                }
                this.f21700g.getLayer1().setVisibility(0);
            }
        }
    }

    public void setDownLoadSticker(StickerItem stickerItem) {
        VideoEffectLayout videoEffectLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048600, this, stickerItem) == null) || (videoEffectLayout = this.u) == null) {
            return;
        }
        videoEffectLayout.setDownLoadStrick(stickerItem);
    }

    public void setEffectChoosedListener(VideoEffectLayout.h hVar) {
        VideoEffectLayout videoEffectLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048601, this, hVar) == null) || (videoEffectLayout = this.u) == null) {
            return;
        }
        videoEffectLayout.setListener(hVar);
    }

    public void setHasLocalVideo(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
        }
    }

    @Override // d.a.p0.v3.g.b
    public void setMusicData(List<MusicData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, list) == null) {
            if (list != null && list.size() > 0) {
                for (MusicData musicData : list) {
                    this.t.add(new d.a.p0.v3.j.e(3, musicData.name, musicData, -1));
                }
            }
            VideoEffectLayout videoEffectLayout = this.u;
            if (videoEffectLayout != null) {
                videoEffectLayout.setMusicList(this.t);
            }
        }
    }

    public void setRecordControlListener(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, fVar) == null) {
            this.o = fVar;
        }
    }

    public void setRecordController(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, iVar) == null) {
            this.f21702i = iVar;
            j(1);
        }
    }

    public void setStickerItems(List<StickerItem> list) {
        VideoEffectLayout videoEffectLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048606, this, list) == null) || (videoEffectLayout = this.u) == null) {
            return;
        }
        videoEffectLayout.setStickerItems(list);
    }

    public final void t(List list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048607, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        list.remove(list.size() - 1);
    }

    public void u() {
        VideoEffectLayout videoEffectLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048608, this) == null) || (videoEffectLayout = this.u) == null) {
            return;
        }
        videoEffectLayout.u();
    }

    public void v() {
        VideoEffectLayout videoEffectLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048609, this) == null) || (videoEffectLayout = this.u) == null) {
            return;
        }
        videoEffectLayout.v();
    }

    public void w(StickerItem stickerItem) {
        VideoEffectLayout videoEffectLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048610, this, stickerItem) == null) || (videoEffectLayout = this.u) == null) {
            return;
        }
        videoEffectLayout.w(stickerItem);
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048611, this) == null) || this.u.getVisibility() == 0) {
            return;
        }
        this.u.setVisibility(0);
        o();
        this.f21701h.setEnabled(false);
        this.f21698e.setEnabled(false);
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

    public final void y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048612, this, z) == null) {
            if (this.f21702i.e() >= 100) {
                f fVar = this.o;
                if (fVar != null) {
                    fVar.onRecordDone();
                    return;
                }
                return;
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
            j(2);
            if (this.u.getVisibility() == 0) {
                m(new a(this, z));
            } else {
                z(z);
            }
            i iVar = this.f21702i;
            if (iVar != null) {
                iVar.n();
            }
            f fVar2 = this.o;
            if (fVar2 != null) {
                fVar2.onStartRecord();
            }
        }
    }

    public final void z(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048613, this, z) == null) {
            AnimatorSet animatorSet = this.m;
            if (animatorSet != null && animatorSet.isRunning()) {
                this.m.cancel();
            }
            if (this.l == null) {
                AnimatorSet animatorSet2 = new AnimatorSet();
                this.l = animatorSet2;
                animatorSet2.playTogether(ObjectAnimator.ofFloat(this.f21698e, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.f21701h, "alpha", 1.0f, 0.0f));
                this.l.addListener(new b(this));
                this.l.setDuration(300L);
            }
            this.l.start();
            if (this.f21702i.f() != 6) {
                this.f21700g.b(z);
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
        this.j = 0L;
        this.k = false;
        this.q = new ArrayList();
        this.r = new ArrayList();
        this.s = new ArrayList();
        this.t = new ArrayList();
        this.v = new Handler();
        n();
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
        this.j = 0L;
        this.k = false;
        this.q = new ArrayList();
        this.r = new ArrayList();
        this.s = new ArrayList();
        this.t = new ArrayList();
        this.v = new Handler();
        n();
    }
}
