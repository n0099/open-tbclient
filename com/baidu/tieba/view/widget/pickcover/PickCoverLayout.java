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
import com.repackage.gs4;
import com.repackage.mi;
import com.repackage.ng;
/* loaded from: classes4.dex */
public class PickCoverLayout extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RecyclerView a;
    public VideoClipAdapter b;
    public CustomLinearLayoutManager c;
    public int d;
    public SlideBarView e;
    public GestureDetector f;
    public View g;
    public EMTextView h;
    public i i;
    public int j;
    public int k;
    public int l;
    public float m;
    public float n;
    public int o;
    public boolean p;

    /* loaded from: classes4.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pickCoverLayout;
        }

        @Override // com.baidu.tieba.view.widget.pickcover.SlideBarView.c
        public void a(float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(1048576, this, f) == null) {
                this.a.p(f);
            }
        }

        @Override // com.baidu.tieba.view.widget.pickcover.SlideBarView.c
        public void onProgress(float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f) == null) {
                this.a.p(f);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends GestureDetector.SimpleOnGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PickCoverLayout a;

        public b(PickCoverLayout pickCoverLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pickCoverLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pickCoverLayout;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
                this.a.e.d(motionEvent);
                this.a.p(this.a.e.getCurrentPercent());
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PickCoverLayout a;

        public c(PickCoverLayout pickCoverLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pickCoverLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pickCoverLayout;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) ? this.a.f.onTouchEvent(motionEvent) : invokeLL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ float a;
        public final /* synthetic */ PickCoverLayout b;

        public d(PickCoverLayout pickCoverLayout, float f) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pickCoverLayout, Float.valueOf(f)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = pickCoverLayout;
            this.a = f;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.b.e == null) {
                return;
            }
            this.b.o();
            this.b.p(this.a);
            this.b.e.setProgress(this.a);
            this.b.h.setVisibility(8);
        }
    }

    /* loaded from: classes4.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PickCoverLayout a;

        public e(PickCoverLayout pickCoverLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pickCoverLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pickCoverLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.e == null) {
                return;
            }
            this.a.p(0.0f);
            this.a.e.setProgress(0.0f);
            this.a.e.setSlideRange(0.0f, -UtilHelper.getDimenPixelSize(R.dimen.L_X04));
            this.a.h.setVisibility(0);
        }
    }

    /* loaded from: classes4.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PickCoverLayout a;

        public f(PickCoverLayout pickCoverLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pickCoverLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pickCoverLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ViewGroup.LayoutParams layoutParams = this.a.e.getLayoutParams();
                layoutParams.width = this.a.k + (UtilHelper.getDimenPixelSize(R.dimen.L_X04) * 2);
                this.a.e.setLayoutParams(layoutParams);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PickCoverLayout a;

        public g(PickCoverLayout pickCoverLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pickCoverLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pickCoverLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.o();
                float lasterPersent = this.a.getLasterPersent();
                this.a.p(lasterPersent);
                this.a.e.setProgress(lasterPersent);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PickCoverLayout a;

        public h(PickCoverLayout pickCoverLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pickCoverLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pickCoverLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.o();
                float lasterPersent = this.a.getLasterPersent();
                this.a.p(lasterPersent);
                this.a.e.setProgress(lasterPersent);
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface i {
        void a(float f);

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
            this.e.setCoverStyle(true);
            this.e.setImageBitmap(null);
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            VideoClipAdapter videoClipAdapter = new VideoClipAdapter(getContext());
            this.b = videoClipAdapter;
            this.a.setAdapter(videoClipAdapter);
        }
    }

    public View getChangeImageCover() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.h : (View) invokeV.objValue;
    }

    public int getItemImageHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.l : invokeV.intValue;
    }

    public int getItemImageWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.k : invokeV.intValue;
    }

    public float getLasterPersent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.n : invokeV.floatValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.e.setOnProgressListener(new a(this));
            this.f = new GestureDetector(new b(this));
            this.a.setOnTouchListener(new c(this));
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            double k = mi.k(getContext()) - (UtilHelper.getDimenPixelSize(R.dimen.M_W_X007) * 2);
            this.k = UtilHelper.getDimenPixelSize(R.dimen.tbds112);
            this.l = UtilHelper.getDimenPixelSize(R.dimen.tbds144);
            int i2 = (int) (k / this.k);
            this.j = i2;
            if (i2 < 5) {
                this.j = 5;
            }
            this.k = (int) (k / this.j);
            ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
            layoutParams.width = (this.k * this.j) - (UtilHelper.getDimenPixelSize(R.dimen.L_X04) * 2);
            this.a.setLayoutParams(layoutParams);
            ng.a().postDelayed(new f(this), 50L);
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d0847, (ViewGroup) null);
            this.a = (RecyclerView) inflate.findViewById(R.id.obfuscated_res_0x7f0922a0);
            this.e = (SlideBarView) inflate.findViewById(R.id.obfuscated_res_0x7f09229e);
            this.g = inflate.findViewById(R.id.obfuscated_res_0x7f09229d);
            EMTextView eMTextView = (EMTextView) inflate.findViewById(R.id.obfuscated_res_0x7f0905e5);
            this.h = eMTextView;
            gs4.d(eMTextView).y(R.array.S_O_X001);
            addView(inflate);
            CustomLinearLayoutManager customLinearLayoutManager = new CustomLinearLayoutManager(getContext(), 0, false);
            this.c = customLinearLayoutManager;
            customLinearLayoutManager.a(true);
            this.a.setLayoutManager(this.c);
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
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (videoClipAdapter = this.b) == null) {
            return;
        }
        videoClipAdapter.d();
    }

    public void m(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bitmap) == null) {
            this.e.setCoverStyle(true);
            this.e.setImageBitmap(bitmap);
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
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (slideBarView = this.e) == null) {
            return;
        }
        slideBarView.setSlideRange(this.a.getLeft(), (this.a.getRight() - this.e.getWidth()) - UtilHelper.getDimenPixelSize(R.dimen.L_X04));
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
            long j = this.d * f2;
            this.m = f2;
            setLastPercent();
            if (this.p && this.o == 1) {
                j = j + this.d + 1;
            }
            this.i.b(j);
            this.i.a(f2);
        }
    }

    public void setDataByCartoon(MultiMediaData multiMediaData, long j, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{multiMediaData, Long.valueOf(j), Integer.valueOf(i2)}) == null) {
            int i3 = (int) j;
            this.d = i3;
            this.o = i2;
            this.p = true;
            if (i3 > 0) {
                i();
            }
            VideoClipAdapter videoClipAdapter = this.b;
            if (videoClipAdapter != null) {
                int i4 = this.k;
                videoClipAdapter.g(1, 0.0d, i4, this.l, i4, UtilHelper.getDimenPixelSize(R.dimen.tbds144));
            }
            VideoClipAdapter videoClipAdapter2 = this.b;
            if (videoClipAdapter2 != null) {
                videoClipAdapter2.e(multiMediaData, this.j);
            }
            if (this.e != null) {
                postDelayed(new h(this), 350L);
            }
        }
    }

    public void setLastPercent() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            setLastPercent(this.m);
        }
    }

    public void setMultiMeidaData(MultiMediaData multiMediaData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, multiMediaData) == null) || multiMediaData == null) {
            return;
        }
        int duration = (int) multiMediaData.getDuration();
        this.d = duration;
        if (duration > 0) {
            i();
        }
        VideoClipAdapter videoClipAdapter = this.b;
        if (videoClipAdapter != null) {
            int i2 = this.k;
            videoClipAdapter.g(1, 0.0d, i2, this.l, i2, UtilHelper.getDimenPixelSize(R.dimen.tbds144));
        }
        VideoClipAdapter videoClipAdapter2 = this.b;
        if (videoClipAdapter2 != null) {
            videoClipAdapter2.e(multiMediaData, this.j);
        }
        if (this.e != null) {
            postDelayed(new g(this), 350L);
        }
    }

    public void setPickCoverListener(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, iVar) == null) {
            this.i = iVar;
        }
    }

    public void setPickCoverMask(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
            this.g.setBackgroundColor(i2);
        }
    }

    public void setSlideBarMask(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            this.e.setPickDrawable(z ? R.drawable.obfuscated_res_0x7f080f95 : R.drawable.obfuscated_res_0x7f080f94);
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
            this.n = f2;
            this.m = f2;
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
