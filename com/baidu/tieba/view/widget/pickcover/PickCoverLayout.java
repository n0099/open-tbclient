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
import d.a.c.e.p.l;
/* loaded from: classes5.dex */
public class PickCoverLayout extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public RecyclerView f22396e;

    /* renamed from: f  reason: collision with root package name */
    public VideoClipAdapter f22397f;

    /* renamed from: g  reason: collision with root package name */
    public CustomLinearLayoutManager f22398g;

    /* renamed from: h  reason: collision with root package name */
    public int f22399h;

    /* renamed from: i  reason: collision with root package name */
    public SlideBarView f22400i;
    public GestureDetector j;
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

    /* loaded from: classes5.dex */
    public class a implements SlideBarView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PickCoverLayout f22401a;

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
            this.f22401a = pickCoverLayout;
        }

        @Override // com.baidu.tieba.view.widget.pickcover.SlideBarView.c
        public void a(float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(1048576, this, f2) == null) {
                this.f22401a.p(f2);
            }
        }

        @Override // com.baidu.tieba.view.widget.pickcover.SlideBarView.c
        public void onProgress(float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f2) == null) {
                this.f22401a.p(f2);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends GestureDetector.SimpleOnGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PickCoverLayout f22402e;

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
            this.f22402e = pickCoverLayout;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
                this.f22402e.f22400i.d(motionEvent);
                this.f22402e.p(this.f22402e.f22400i.getCurrentPercent());
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PickCoverLayout f22403e;

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
            this.f22403e = pickCoverLayout;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) ? this.f22403e.j.onTouchEvent(motionEvent) : invokeLL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ float f22404e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PickCoverLayout f22405f;

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
            this.f22405f = pickCoverLayout;
            this.f22404e = f2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f22405f.f22400i == null) {
                return;
            }
            this.f22405f.o();
            this.f22405f.p(this.f22404e);
            this.f22405f.f22400i.setProgress(this.f22404e);
            this.f22405f.l.setVisibility(8);
        }
    }

    /* loaded from: classes5.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PickCoverLayout f22406e;

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
            this.f22406e = pickCoverLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f22406e.f22400i == null) {
                return;
            }
            this.f22406e.p(0.0f);
            this.f22406e.f22400i.setProgress(0.0f);
            this.f22406e.f22400i.setSlideRange(0.0f, -UtilHelper.getDimenPixelSize(R.dimen.L_X04));
            this.f22406e.l.setVisibility(0);
        }
    }

    /* loaded from: classes5.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PickCoverLayout f22407e;

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
            this.f22407e = pickCoverLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ViewGroup.LayoutParams layoutParams = this.f22407e.f22400i.getLayoutParams();
                layoutParams.width = this.f22407e.o + (UtilHelper.getDimenPixelSize(R.dimen.L_X04) * 2);
                this.f22407e.f22400i.setLayoutParams(layoutParams);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PickCoverLayout f22408e;

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
            this.f22408e = pickCoverLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f22408e.o();
                float lasterPersent = this.f22408e.getLasterPersent();
                this.f22408e.p(lasterPersent);
                this.f22408e.f22400i.setProgress(lasterPersent);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PickCoverLayout f22409e;

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
            this.f22409e = pickCoverLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f22409e.o();
                float lasterPersent = this.f22409e.getLasterPersent();
                this.f22409e.p(lasterPersent);
                this.f22409e.f22400i.setProgress(lasterPersent);
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface i {
        void a(float f2);

        void b(long j);
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

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f22400i.setCoverStyle(true);
            this.f22400i.setImageBitmap(null);
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            VideoClipAdapter videoClipAdapter = new VideoClipAdapter(getContext());
            this.f22397f = videoClipAdapter;
            this.f22396e.setAdapter(videoClipAdapter);
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
            this.f22400i.setOnProgressListener(new a(this));
            this.j = new GestureDetector(new b(this));
            this.f22396e.setOnTouchListener(new c(this));
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            double k = l.k(getContext()) - (UtilHelper.getDimenPixelSize(R.dimen.M_W_X007) * 2);
            this.o = UtilHelper.getDimenPixelSize(R.dimen.tbds112);
            this.p = UtilHelper.getDimenPixelSize(R.dimen.tbds144);
            int i2 = (int) (k / this.o);
            this.n = i2;
            if (i2 < 5) {
                this.n = 5;
            }
            this.o = (int) (k / this.n);
            ViewGroup.LayoutParams layoutParams = this.f22396e.getLayoutParams();
            layoutParams.width = (this.o * this.n) - (UtilHelper.getDimenPixelSize(R.dimen.L_X04) * 2);
            this.f22396e.setLayoutParams(layoutParams);
            d.a.c.e.m.e.a().postDelayed(new f(this), 50L);
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.ugc_capture_pick_cover_view, (ViewGroup) null);
            this.f22396e = (RecyclerView) inflate.findViewById(R.id.ugc_video_recycler);
            this.f22400i = (SlideBarView) inflate.findViewById(R.id.ugc_pick_cover_slideBar);
            this.k = inflate.findViewById(R.id.ugc_pick_cover_bg);
            EMTextView eMTextView = (EMTextView) inflate.findViewById(R.id.change_image_cover);
            this.l = eMTextView;
            d.a.r0.r.u.c.d(eMTextView).w(R.array.S_O_X001);
            addView(inflate);
            CustomLinearLayoutManager customLinearLayoutManager = new CustomLinearLayoutManager(getContext(), 0, false);
            this.f22398g = customLinearLayoutManager;
            customLinearLayoutManager.a(true);
            this.f22396e.setLayoutManager(this.f22398g);
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            postDelayed(new e(this), 350L);
        }
    }

    public void l() {
        VideoClipAdapter videoClipAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (videoClipAdapter = this.f22397f) == null) {
            return;
        }
        videoClipAdapter.m();
    }

    public void m(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bitmap) == null) {
            this.f22400i.setCoverStyle(true);
            this.f22400i.setImageBitmap(bitmap);
        }
    }

    public void n(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048588, this, f2) == null) {
            postDelayed(new d(this, f2), 350L);
        }
    }

    public final void o() {
        SlideBarView slideBarView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (slideBarView = this.f22400i) == null) {
            return;
        }
        slideBarView.setSlideRange(this.f22396e.getLeft(), (this.f22396e.getRight() - this.f22400i.getWidth()) - UtilHelper.getDimenPixelSize(R.dimen.L_X04));
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onAttachedToWindow();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onDetachedFromWindow();
        }
    }

    public void p(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048592, this, f2) == null) {
            long j = this.f22399h * f2;
            this.q = f2;
            setLastPercent();
            if (this.t && this.s == 1) {
                j = j + this.f22399h + 1;
            }
            this.m.b(j);
            this.m.a(f2);
        }
    }

    public void setDataByCartoon(MultiMediaData multiMediaData, long j, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{multiMediaData, Long.valueOf(j), Integer.valueOf(i2)}) == null) {
            int i3 = (int) j;
            this.f22399h = i3;
            this.s = i2;
            this.t = true;
            if (i3 > 0) {
                i();
            }
            VideoClipAdapter videoClipAdapter = this.f22397f;
            if (videoClipAdapter != null) {
                int i4 = this.o;
                videoClipAdapter.p(1, 0.0d, i4, this.p, i4, UtilHelper.getDimenPixelSize(R.dimen.tbds144));
            }
            VideoClipAdapter videoClipAdapter2 = this.f22397f;
            if (videoClipAdapter2 != null) {
                videoClipAdapter2.n(multiMediaData, this.n);
            }
            if (this.f22400i != null) {
                postDelayed(new h(this), 350L);
            }
        }
    }

    public void setLastPercent() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            setLastPercent(this.q);
        }
    }

    public void setMultiMeidaData(MultiMediaData multiMediaData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, multiMediaData) == null) || multiMediaData == null) {
            return;
        }
        int duration = (int) multiMediaData.getDuration();
        this.f22399h = duration;
        if (duration > 0) {
            i();
        }
        VideoClipAdapter videoClipAdapter = this.f22397f;
        if (videoClipAdapter != null) {
            int i2 = this.o;
            videoClipAdapter.p(1, 0.0d, i2, this.p, i2, UtilHelper.getDimenPixelSize(R.dimen.tbds144));
        }
        VideoClipAdapter videoClipAdapter2 = this.f22397f;
        if (videoClipAdapter2 != null) {
            videoClipAdapter2.n(multiMediaData, this.n);
        }
        if (this.f22400i != null) {
            postDelayed(new g(this), 350L);
        }
    }

    public void setPickCoverListener(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, iVar) == null) {
            this.m = iVar;
        }
    }

    public void setPickCoverMask(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
            this.k.setBackgroundColor(i2);
        }
    }

    public void setSlideBarMask(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            this.f22400i.setPickDrawable(z ? R.drawable.pick_image_cover_slide : R.drawable.pick_cover_slide);
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
        if (interceptable == null || interceptable.invokeF(1048595, this, f2) == null) {
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
        j();
        h();
        g();
    }
}
