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
import c.a.d.f.p.n;
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
/* loaded from: classes13.dex */
public class PickCoverLayout extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public RecyclerView f51450e;

    /* renamed from: f  reason: collision with root package name */
    public VideoClipAdapter f51451f;

    /* renamed from: g  reason: collision with root package name */
    public CustomLinearLayoutManager f51452g;

    /* renamed from: h  reason: collision with root package name */
    public int f51453h;

    /* renamed from: i  reason: collision with root package name */
    public SlideBarView f51454i;

    /* renamed from: j  reason: collision with root package name */
    public GestureDetector f51455j;

    /* renamed from: k  reason: collision with root package name */
    public View f51456k;
    public EMTextView l;
    public i m;
    public int n;
    public int o;
    public int p;
    public float q;
    public float r;
    public int s;
    public boolean t;

    /* loaded from: classes13.dex */
    public class a implements SlideBarView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PickCoverLayout a;

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
            this.a = pickCoverLayout;
        }

        @Override // com.baidu.tieba.view.widget.pickcover.SlideBarView.c
        public void a(float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(1048576, this, f2) == null) {
                this.a.updateVideoCover(f2);
            }
        }

        @Override // com.baidu.tieba.view.widget.pickcover.SlideBarView.c
        public void onProgress(float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f2) == null) {
                this.a.updateVideoCover(f2);
            }
        }
    }

    /* loaded from: classes13.dex */
    public class b extends GestureDetector.SimpleOnGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PickCoverLayout f51457e;

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
            this.f51457e = pickCoverLayout;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
                this.f51457e.f51454i.moveToPosition(motionEvent);
                this.f51457e.updateVideoCover(this.f51457e.f51454i.getCurrentPercent());
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes13.dex */
    public class c implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PickCoverLayout f51458e;

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
            this.f51458e = pickCoverLayout;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) ? this.f51458e.f51455j.onTouchEvent(motionEvent) : invokeLL.booleanValue;
        }
    }

    /* loaded from: classes13.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ float f51459e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PickCoverLayout f51460f;

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
            this.f51460f = pickCoverLayout;
            this.f51459e = f2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f51460f.f51454i == null) {
                return;
            }
            this.f51460f.j();
            this.f51460f.updateVideoCover(this.f51459e);
            this.f51460f.f51454i.setProgress(this.f51459e);
            this.f51460f.l.setVisibility(8);
        }
    }

    /* loaded from: classes13.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PickCoverLayout f51461e;

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
            this.f51461e = pickCoverLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f51461e.f51454i == null) {
                return;
            }
            this.f51461e.updateVideoCover(0.0f);
            this.f51461e.f51454i.setProgress(0.0f);
            this.f51461e.f51454i.setSlideRange(0.0f, -UtilHelper.getDimenPixelSize(R.dimen.L_X04));
            this.f51461e.l.setVisibility(0);
        }
    }

    /* loaded from: classes13.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PickCoverLayout f51462e;

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
            this.f51462e = pickCoverLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ViewGroup.LayoutParams layoutParams = this.f51462e.f51454i.getLayoutParams();
                layoutParams.width = this.f51462e.o + (UtilHelper.getDimenPixelSize(R.dimen.L_X04) * 2);
                this.f51462e.f51454i.setLayoutParams(layoutParams);
            }
        }
    }

    /* loaded from: classes13.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PickCoverLayout f51463e;

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
            this.f51463e = pickCoverLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f51463e.j();
                float lasterPersent = this.f51463e.getLasterPersent();
                this.f51463e.updateVideoCover(lasterPersent);
                this.f51463e.f51454i.setProgress(lasterPersent);
            }
        }
    }

    /* loaded from: classes13.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PickCoverLayout f51464e;

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
            this.f51464e = pickCoverLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f51464e.j();
                float lasterPersent = this.f51464e.getLasterPersent();
                this.f51464e.updateVideoCover(lasterPersent);
                this.f51464e.f51454i.setProgress(lasterPersent);
            }
        }
    }

    /* loaded from: classes13.dex */
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
            this.f51451f = videoClipAdapter;
            this.f51450e.setAdapter(videoClipAdapter);
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f51454i.setOnProgressListener(new a(this));
            this.f51455j = new GestureDetector(new b(this));
            this.f51450e.setOnTouchListener(new c(this));
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
            double k2 = n.k(getContext()) - (UtilHelper.getDimenPixelSize(R.dimen.M_W_X007) * 2);
            this.o = UtilHelper.getDimenPixelSize(R.dimen.tbds112);
            this.p = UtilHelper.getDimenPixelSize(R.dimen.tbds144);
            int i2 = (int) (k2 / this.o);
            this.n = i2;
            if (i2 < 5) {
                this.n = 5;
            }
            this.o = (int) (k2 / this.n);
            ViewGroup.LayoutParams layoutParams = this.f51450e.getLayoutParams();
            layoutParams.width = (this.o * this.n) - (UtilHelper.getDimenPixelSize(R.dimen.L_X04) * 2);
            this.f51450e.setLayoutParams(layoutParams);
            c.a.d.f.m.e.a().postDelayed(new f(this), 50L);
        }
    }

    public void hideCoverImage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f51454i.setCoverStyle(true);
            this.f51454i.setImageBitmap(null);
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.ugc_capture_pick_cover_view, (ViewGroup) null);
            this.f51450e = (RecyclerView) inflate.findViewById(R.id.ugc_video_recycler);
            this.f51454i = (SlideBarView) inflate.findViewById(R.id.ugc_pick_cover_slideBar);
            this.f51456k = inflate.findViewById(R.id.ugc_pick_cover_bg);
            EMTextView eMTextView = (EMTextView) inflate.findViewById(R.id.change_image_cover);
            this.l = eMTextView;
            c.a.s0.s.u.c.d(eMTextView).y(R.array.S_O_X001);
            addView(inflate);
            CustomLinearLayoutManager customLinearLayoutManager = new CustomLinearLayoutManager(getContext(), 0, false);
            this.f51452g = customLinearLayoutManager;
            customLinearLayoutManager.setScrollEnabled(true);
            this.f51450e.setLayoutManager(this.f51452g);
        }
    }

    public final void j() {
        SlideBarView slideBarView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (slideBarView = this.f51454i) == null) {
            return;
        }
        slideBarView.setSlideRange(this.f51450e.getLeft(), (this.f51450e.getRight() - this.f51454i.getWidth()) - UtilHelper.getDimenPixelSize(R.dimen.L_X04));
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
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (videoClipAdapter = this.f51451f) == null) {
            return;
        }
        videoClipAdapter.release();
    }

    public void setDataByCartoon(MultiMediaData multiMediaData, long j2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{multiMediaData, Long.valueOf(j2), Integer.valueOf(i2)}) == null) {
            int i3 = (int) j2;
            this.f51453h = i3;
            this.s = i2;
            this.t = true;
            if (i3 > 0) {
                h();
            }
            VideoClipAdapter videoClipAdapter = this.f51451f;
            if (videoClipAdapter != null) {
                int i4 = this.o;
                videoClipAdapter.setImageConfig(1, 0.0d, i4, this.p, i4, UtilHelper.getDimenPixelSize(R.dimen.tbds144));
            }
            VideoClipAdapter videoClipAdapter2 = this.f51451f;
            if (videoClipAdapter2 != null) {
                videoClipAdapter2.setData(multiMediaData, this.n);
            }
            if (this.f51454i != null) {
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
        this.f51453h = duration;
        if (duration > 0) {
            h();
        }
        VideoClipAdapter videoClipAdapter = this.f51451f;
        if (videoClipAdapter != null) {
            int i2 = this.o;
            videoClipAdapter.setImageConfig(1, 0.0d, i2, this.p, i2, UtilHelper.getDimenPixelSize(R.dimen.tbds144));
        }
        VideoClipAdapter videoClipAdapter2 = this.f51451f;
        if (videoClipAdapter2 != null) {
            videoClipAdapter2.setData(multiMediaData, this.n);
        }
        if (this.f51454i != null) {
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
            this.f51456k.setBackgroundColor(i2);
        }
    }

    public void setSlideBarMask(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            this.f51454i.setPickDrawable(z ? R.drawable.pick_image_cover_slide : R.drawable.pick_cover_slide);
        }
    }

    public void updateCoverImage(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, bitmap) == null) {
            this.f51454i.setCoverStyle(true);
            this.f51454i.setImageBitmap(bitmap);
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
            long j2 = this.f51453h * f2;
            this.q = f2;
            setLastPercent();
            if (this.t && this.s == 1) {
                j2 = j2 + this.f51453h + 1;
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
