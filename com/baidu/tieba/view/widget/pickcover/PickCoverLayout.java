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
    public RecyclerView f58692e;

    /* renamed from: f  reason: collision with root package name */
    public VideoClipAdapter f58693f;

    /* renamed from: g  reason: collision with root package name */
    public CustomLinearLayoutManager f58694g;

    /* renamed from: h  reason: collision with root package name */
    public int f58695h;

    /* renamed from: i  reason: collision with root package name */
    public SlideBarView f58696i;

    /* renamed from: j  reason: collision with root package name */
    public GestureDetector f58697j;
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
        public final /* synthetic */ PickCoverLayout f58698a;

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
            this.f58698a = pickCoverLayout;
        }

        @Override // com.baidu.tieba.view.widget.pickcover.SlideBarView.c
        public void a(float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(1048576, this, f2) == null) {
                this.f58698a.updateVideoCover(f2);
            }
        }

        @Override // com.baidu.tieba.view.widget.pickcover.SlideBarView.c
        public void onProgress(float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f2) == null) {
                this.f58698a.updateVideoCover(f2);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends GestureDetector.SimpleOnGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PickCoverLayout f58699e;

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
            this.f58699e = pickCoverLayout;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
                this.f58699e.f58696i.moveToPosition(motionEvent);
                this.f58699e.updateVideoCover(this.f58699e.f58696i.getCurrentPercent());
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
        public final /* synthetic */ PickCoverLayout f58700e;

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
            this.f58700e = pickCoverLayout;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) ? this.f58700e.f58697j.onTouchEvent(motionEvent) : invokeLL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ float f58701e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PickCoverLayout f58702f;

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
            this.f58702f = pickCoverLayout;
            this.f58701e = f2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f58702f.f58696i == null) {
                return;
            }
            this.f58702f.j();
            this.f58702f.updateVideoCover(this.f58701e);
            this.f58702f.f58696i.setProgress(this.f58701e);
            this.f58702f.l.setVisibility(8);
        }
    }

    /* loaded from: classes7.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PickCoverLayout f58703e;

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
            this.f58703e = pickCoverLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f58703e.f58696i == null) {
                return;
            }
            this.f58703e.updateVideoCover(0.0f);
            this.f58703e.f58696i.setProgress(0.0f);
            this.f58703e.f58696i.setSlideRange(0.0f, -UtilHelper.getDimenPixelSize(R.dimen.L_X04));
            this.f58703e.l.setVisibility(0);
        }
    }

    /* loaded from: classes7.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PickCoverLayout f58704e;

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
            this.f58704e = pickCoverLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ViewGroup.LayoutParams layoutParams = this.f58704e.f58696i.getLayoutParams();
                layoutParams.width = this.f58704e.o + (UtilHelper.getDimenPixelSize(R.dimen.L_X04) * 2);
                this.f58704e.f58696i.setLayoutParams(layoutParams);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PickCoverLayout f58705e;

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
            this.f58705e = pickCoverLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f58705e.j();
                float lasterPersent = this.f58705e.getLasterPersent();
                this.f58705e.updateVideoCover(lasterPersent);
                this.f58705e.f58696i.setProgress(lasterPersent);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PickCoverLayout f58706e;

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
            this.f58706e = pickCoverLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f58706e.j();
                float lasterPersent = this.f58706e.getLasterPersent();
                this.f58706e.updateVideoCover(lasterPersent);
                this.f58706e.f58696i.setProgress(lasterPersent);
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
            this.f58693f = videoClipAdapter;
            this.f58692e.setAdapter(videoClipAdapter);
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f58696i.setOnProgressListener(new a(this));
            this.f58697j = new GestureDetector(new b(this));
            this.f58692e.setOnTouchListener(new c(this));
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
            ViewGroup.LayoutParams layoutParams = this.f58692e.getLayoutParams();
            layoutParams.width = (this.o * this.n) - (UtilHelper.getDimenPixelSize(R.dimen.L_X04) * 2);
            this.f58692e.setLayoutParams(layoutParams);
            c.a.e.e.m.e.a().postDelayed(new f(this), 50L);
        }
    }

    public void hideCoverImage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f58696i.setCoverStyle(true);
            this.f58696i.setImageBitmap(null);
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.ugc_capture_pick_cover_view, (ViewGroup) null);
            this.f58692e = (RecyclerView) inflate.findViewById(R.id.ugc_video_recycler);
            this.f58696i = (SlideBarView) inflate.findViewById(R.id.ugc_pick_cover_slideBar);
            this.k = inflate.findViewById(R.id.ugc_pick_cover_bg);
            EMTextView eMTextView = (EMTextView) inflate.findViewById(R.id.change_image_cover);
            this.l = eMTextView;
            c.a.q0.s.u.c.d(eMTextView).y(R.array.S_O_X001);
            addView(inflate);
            CustomLinearLayoutManager customLinearLayoutManager = new CustomLinearLayoutManager(getContext(), 0, false);
            this.f58694g = customLinearLayoutManager;
            customLinearLayoutManager.setScrollEnabled(true);
            this.f58692e.setLayoutManager(this.f58694g);
        }
    }

    public final void j() {
        SlideBarView slideBarView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (slideBarView = this.f58696i) == null) {
            return;
        }
        slideBarView.setSlideRange(this.f58692e.getLeft(), (this.f58692e.getRight() - this.f58696i.getWidth()) - UtilHelper.getDimenPixelSize(R.dimen.L_X04));
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
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (videoClipAdapter = this.f58693f) == null) {
            return;
        }
        videoClipAdapter.release();
    }

    public void setDataByCartoon(MultiMediaData multiMediaData, long j2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{multiMediaData, Long.valueOf(j2), Integer.valueOf(i2)}) == null) {
            int i3 = (int) j2;
            this.f58695h = i3;
            this.s = i2;
            this.t = true;
            if (i3 > 0) {
                h();
            }
            VideoClipAdapter videoClipAdapter = this.f58693f;
            if (videoClipAdapter != null) {
                int i4 = this.o;
                videoClipAdapter.setImageConfig(1, 0.0d, i4, this.p, i4, UtilHelper.getDimenPixelSize(R.dimen.tbds144));
            }
            VideoClipAdapter videoClipAdapter2 = this.f58693f;
            if (videoClipAdapter2 != null) {
                videoClipAdapter2.setData(multiMediaData, this.n);
            }
            if (this.f58696i != null) {
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
        this.f58695h = duration;
        if (duration > 0) {
            h();
        }
        VideoClipAdapter videoClipAdapter = this.f58693f;
        if (videoClipAdapter != null) {
            int i2 = this.o;
            videoClipAdapter.setImageConfig(1, 0.0d, i2, this.p, i2, UtilHelper.getDimenPixelSize(R.dimen.tbds144));
        }
        VideoClipAdapter videoClipAdapter2 = this.f58693f;
        if (videoClipAdapter2 != null) {
            videoClipAdapter2.setData(multiMediaData, this.n);
        }
        if (this.f58696i != null) {
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
            this.f58696i.setPickDrawable(z ? R.drawable.pick_image_cover_slide : R.drawable.pick_cover_slide);
        }
    }

    public void updateCoverImage(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, bitmap) == null) {
            this.f58696i.setCoverStyle(true);
            this.f58696i.setImageBitmap(bitmap);
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
            long j2 = this.f58695h * f2;
            this.q = f2;
            setLastPercent();
            if (this.t && this.s == 1) {
                j2 = j2 + this.f58695h + 1;
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
