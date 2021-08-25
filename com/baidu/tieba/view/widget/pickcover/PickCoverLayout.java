package com.baidu.tieba.view.widget.pickcover;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import c.a.e.e.p.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.view.widget.mediaedit.adapter.rangerslider.VideoClipAdapter;
import com.baidu.tieba.view.widget.mediaedit.manager.CustomLinearLayoutManager;
import com.baidu.tieba.view.widget.pickcover.SlideBarView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.data.MultiMediaData;
/* loaded from: classes7.dex */
public class PickCoverLayout extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public RecyclerView f58437e;

    /* renamed from: f  reason: collision with root package name */
    public VideoClipAdapter f58438f;

    /* renamed from: g  reason: collision with root package name */
    public CustomLinearLayoutManager f58439g;

    /* renamed from: h  reason: collision with root package name */
    public int f58440h;

    /* renamed from: i  reason: collision with root package name */
    public SlideBarView f58441i;

    /* renamed from: j  reason: collision with root package name */
    public GestureDetector f58442j;
    public View k;
    public EMTextView l;
    public i m;
    public int n;
    public int o;
    public int p;
    public float q;
    public float r;
    public int s;
    public boolean t;

    /* loaded from: classes7.dex */
    public class a implements SlideBarView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PickCoverLayout f58443a;

        public a(PickCoverLayout pickCoverLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pickCoverLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58443a = pickCoverLayout;
        }

        @Override // com.baidu.tieba.view.widget.pickcover.SlideBarView.c
        public void a(float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(1048576, this, f2) == null) {
                this.f58443a.updateVideoCover(f2);
            }
        }

        @Override // com.baidu.tieba.view.widget.pickcover.SlideBarView.c
        public void onProgress(float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f2) == null) {
                this.f58443a.updateVideoCover(f2);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends GestureDetector.SimpleOnGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PickCoverLayout f58444e;

        public b(PickCoverLayout pickCoverLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pickCoverLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58444e = pickCoverLayout;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
                this.f58444e.f58441i.moveToPosition(motionEvent);
                this.f58444e.updateVideoCover(this.f58444e.f58441i.getCurrentPercent());
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PickCoverLayout f58445e;

        public c(PickCoverLayout pickCoverLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pickCoverLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58445e = pickCoverLayout;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) ? this.f58445e.f58442j.onTouchEvent(motionEvent) : invokeLL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ float f58446e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PickCoverLayout f58447f;

        public d(PickCoverLayout pickCoverLayout, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pickCoverLayout, Float.valueOf(f2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58447f = pickCoverLayout;
            this.f58446e = f2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f58447f.f58441i == null) {
                return;
            }
            this.f58447f.j();
            this.f58447f.updateVideoCover(this.f58446e);
            this.f58447f.f58441i.setProgress(this.f58446e);
            this.f58447f.l.setVisibility(8);
        }
    }

    /* loaded from: classes7.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PickCoverLayout f58448e;

        public e(PickCoverLayout pickCoverLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pickCoverLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58448e = pickCoverLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f58448e.f58441i == null) {
                return;
            }
            this.f58448e.updateVideoCover(0.0f);
            this.f58448e.f58441i.setProgress(0.0f);
            this.f58448e.f58441i.setSlideRange(0.0f, -UtilHelper.getDimenPixelSize(R.dimen.L_X04));
            this.f58448e.l.setVisibility(0);
        }
    }

    /* loaded from: classes7.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PickCoverLayout f58449e;

        public f(PickCoverLayout pickCoverLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pickCoverLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58449e = pickCoverLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ViewGroup.LayoutParams layoutParams = this.f58449e.f58441i.getLayoutParams();
                layoutParams.width = this.f58449e.o + (UtilHelper.getDimenPixelSize(R.dimen.L_X04) * 2);
                this.f58449e.f58441i.setLayoutParams(layoutParams);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PickCoverLayout f58450e;

        public g(PickCoverLayout pickCoverLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pickCoverLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58450e = pickCoverLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f58450e.j();
                float lasterPersent = this.f58450e.getLasterPersent();
                this.f58450e.updateVideoCover(lasterPersent);
                this.f58450e.f58441i.setProgress(lasterPersent);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PickCoverLayout f58451e;

        public h(PickCoverLayout pickCoverLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pickCoverLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58451e = pickCoverLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f58451e.j();
                float lasterPersent = this.f58451e.getLasterPersent();
                this.f58451e.updateVideoCover(lasterPersent);
                this.f58451e.f58441i.setProgress(lasterPersent);
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface i {
        void updateVideoCover(long j2);

        void updateVideoCoverPercent(float f2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PickCoverLayout(@NonNull Context context) {
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

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            VideoClipAdapter videoClipAdapter = new VideoClipAdapter(getContext());
            this.f58438f = videoClipAdapter;
            this.f58437e.setAdapter(videoClipAdapter);
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f58441i.setOnProgressListener(new a(this));
            this.f58442j = new GestureDetector(new b(this));
            this.f58437e.setOnTouchListener(new c(this));
        }
    }

    public View getChangeImageCover() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.l : (View) invokeV.objValue;
    }

    public int getItemImageHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.p : invokeV.intValue;
    }

    public int getItemImageWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.o : invokeV.intValue;
    }

    public float getLasterPersent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.r : invokeV.floatValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            double k = l.k(getContext()) - (UtilHelper.getDimenPixelSize(R.dimen.M_W_X007) * 2);
            this.o = UtilHelper.getDimenPixelSize(R.dimen.tbds112);
            this.p = UtilHelper.getDimenPixelSize(R.dimen.tbds144);
            int i2 = (int) (k / this.o);
            this.n = i2;
            if (i2 < 5) {
                this.n = 5;
            }
            this.o = (int) (k / this.n);
            ViewGroup.LayoutParams layoutParams = this.f58437e.getLayoutParams();
            layoutParams.width = (this.o * this.n) - (UtilHelper.getDimenPixelSize(R.dimen.L_X04) * 2);
            this.f58437e.setLayoutParams(layoutParams);
            c.a.e.e.m.e.a().postDelayed(new f(this), 50L);
        }
    }

    public void hideCoverImage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f58441i.setCoverStyle(true);
            this.f58441i.setImageBitmap(null);
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.ugc_capture_pick_cover_view, (ViewGroup) null);
            this.f58437e = (RecyclerView) inflate.findViewById(R.id.ugc_video_recycler);
            this.f58441i = (SlideBarView) inflate.findViewById(R.id.ugc_pick_cover_slideBar);
            this.k = inflate.findViewById(R.id.ugc_pick_cover_bg);
            EMTextView eMTextView = (EMTextView) inflate.findViewById(R.id.change_image_cover);
            this.l = eMTextView;
            c.a.p0.s.u.c.d(eMTextView).x(R.array.S_O_X001);
            addView(inflate);
            CustomLinearLayoutManager customLinearLayoutManager = new CustomLinearLayoutManager(getContext(), 0, false);
            this.f58439g = customLinearLayoutManager;
            customLinearLayoutManager.setScrollEnabled(true);
            this.f58437e.setLayoutManager(this.f58439g);
        }
    }

    public final void j() {
        SlideBarView slideBarView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (slideBarView = this.f58441i) == null) {
            return;
        }
        slideBarView.setSlideRange(this.f58437e.getLeft(), (this.f58437e.getRight() - this.f58441i.getWidth()) - UtilHelper.getDimenPixelSize(R.dimen.L_X04));
    }

    public void makeSlideRangeStable() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            postDelayed(new e(this), 350L);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onAttachedToWindow();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onDetachedFromWindow();
        }
    }

    public void release() {
        VideoClipAdapter videoClipAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (videoClipAdapter = this.f58438f) == null) {
            return;
        }
        videoClipAdapter.release();
    }

    public void setDataByCartoon(MultiMediaData multiMediaData, long j2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{multiMediaData, Long.valueOf(j2), Integer.valueOf(i2)}) == null) {
            int i3 = (int) j2;
            this.f58440h = i3;
            this.s = i2;
            this.t = true;
            if (i3 > 0) {
                h();
            }
            VideoClipAdapter videoClipAdapter = this.f58438f;
            if (videoClipAdapter != null) {
                int i4 = this.o;
                videoClipAdapter.setImageConfig(1, 0.0d, i4, this.p, i4, UtilHelper.getDimenPixelSize(R.dimen.tbds144));
            }
            VideoClipAdapter videoClipAdapter2 = this.f58438f;
            if (videoClipAdapter2 != null) {
                videoClipAdapter2.setData(multiMediaData, this.n);
            }
            if (this.f58441i != null) {
                postDelayed(new h(this), 350L);
            }
        }
    }

    public void setLastPercent() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            setLastPercent(this.q);
        }
    }

    public void setMultiMeidaData(MultiMediaData multiMediaData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, multiMediaData) == null) || multiMediaData == null) {
            return;
        }
        int duration = (int) multiMediaData.getDuration();
        this.f58440h = duration;
        if (duration > 0) {
            h();
        }
        VideoClipAdapter videoClipAdapter = this.f58438f;
        if (videoClipAdapter != null) {
            int i2 = this.o;
            videoClipAdapter.setImageConfig(1, 0.0d, i2, this.p, i2, UtilHelper.getDimenPixelSize(R.dimen.tbds144));
        }
        VideoClipAdapter videoClipAdapter2 = this.f58438f;
        if (videoClipAdapter2 != null) {
            videoClipAdapter2.setData(multiMediaData, this.n);
        }
        if (this.f58441i != null) {
            postDelayed(new g(this), 350L);
        }
    }

    public void setPickCoverListener(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, iVar) == null) {
            this.m = iVar;
        }
    }

    public void setPickCoverMask(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            this.k.setBackgroundColor(i2);
        }
    }

    public void setSlideBarMask(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            this.f58441i.setPickDrawable(z ? R.drawable.pick_image_cover_slide : R.drawable.pick_cover_slide);
        }
    }

    public void updateCoverImage(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, bitmap) == null) {
            this.f58441i.setCoverStyle(true);
            this.f58441i.setImageBitmap(bitmap);
        }
    }

    public void updateSlide(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048598, this, f2) == null) {
            postDelayed(new d(this, f2), 350L);
        }
    }

    public void updateVideoCover(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048599, this, f2) == null) {
            long j2 = this.f58440h * f2;
            this.q = f2;
            setLastPercent();
            if (this.t && this.s == 1) {
                j2 = j2 + this.f58440h + 1;
            }
            this.m.updateVideoCover(j2);
            this.m.updateVideoCoverPercent(f2);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PickCoverLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
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
    }

    public void setLastPercent(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048592, this, f2) == null) {
            this.r = f2;
            this.q = f2;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PickCoverLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
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
        i();
        g();
        f();
    }
}
