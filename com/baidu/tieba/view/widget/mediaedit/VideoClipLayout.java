package com.baidu.tieba.view.widget.mediaedit;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import c.a.d.f.p.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.view.widget.mediaedit.RangeSlider;
import com.baidu.tieba.view.widget.mediaedit.adapter.rangerslider.VideoClipAdapter;
import com.baidu.tieba.view.widget.mediaedit.manager.CustomLinearLayoutManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.data.MultiMediaData;
import com.baidu.ugc.editvideo.record.source.multimedia.VlogEditManager;
import java.util.List;
/* loaded from: classes6.dex */
public class VideoClipLayout extends FrameLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static int G = 3;
    public static int H = 1;
    public static double I = 10.0d;
    public static double J;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public g B;
    public boolean C;
    public int D;
    public boolean E;
    public int F;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public RecyclerView f37153b;

    /* renamed from: c  reason: collision with root package name */
    public RangeSlider f37154c;

    /* renamed from: d  reason: collision with root package name */
    public VideoClipAdapter f37155d;

    /* renamed from: e  reason: collision with root package name */
    public CustomLinearLayoutManager f37156e;

    /* renamed from: f  reason: collision with root package name */
    public List<MultiMediaData> f37157f;

    /* renamed from: g  reason: collision with root package name */
    public double f37158g;

    /* renamed from: h  reason: collision with root package name */
    public double f37159h;
    public double i;
    public int j;
    public double k;
    public double l;
    public int m;
    public double n;
    public double o;
    public int p;
    public double q;
    public double r;
    public double s;
    public long t;
    @IntRange(from = 0, to = 2)
    public int u;
    public boolean v;
    public double w;
    public double x;
    public boolean y;
    public int z;

    /* loaded from: classes6.dex */
    public class a extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int[] a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ VideoClipLayout f37160b;

        public a(VideoClipLayout videoClipLayout, int[] iArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoClipLayout, iArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f37160b = videoClipLayout;
            this.a = iArr;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i) == null) {
                if (i == 0) {
                    this.f37160b.B(5);
                }
                if (this.f37160b.E && i == 0) {
                    this.f37160b.E = false;
                    VideoClipLayout videoClipLayout = this.f37160b;
                    videoClipLayout.S(videoClipLayout.f37153b, this.f37160b.F, 0);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i, i2) == null) {
                if (this.f37160b.f37156e.findFirstVisibleItemPosition() == 0) {
                    this.f37160b.f37154c.m(recyclerView.computeHorizontalScrollOffset());
                } else {
                    this.f37160b.f37154c.k(0.0f);
                }
                if (this.f37160b.f37156e.findLastVisibleItemPosition() == recyclerView.getAdapter().getItemCount() - 1) {
                    this.f37160b.f37156e.getChildAt(this.f37160b.f37156e.getChildCount() - 1).getLocationOnScreen(this.a);
                    this.f37160b.f37154c.l(this.a[0]);
                } else {
                    this.f37160b.f37154c.l((int) ((this.f37160b.k - this.f37160b.f37158g) - recyclerView.computeHorizontalScrollOffset()));
                }
                if (this.f37160b.v) {
                    this.f37160b.v = false;
                } else {
                    this.f37160b.B(6);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements RangeSlider.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoClipLayout a;

        public b(VideoClipLayout videoClipLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoClipLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoClipLayout;
        }

        @Override // com.baidu.tieba.view.widget.mediaedit.RangeSlider.b
        public void a(float f2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeF(1048576, this, f2) == null) || this.a.B == null) {
                return;
            }
            this.a.B.a(((float) this.a.E(f2)) * 1000.0f);
        }

        @Override // com.baidu.tieba.view.widget.mediaedit.RangeSlider.b
        public void b(float f2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f2) == null) || this.a.B == null) {
                return;
            }
            this.a.B.g(this.a.E(f2) * 1000.0d);
        }
    }

    /* loaded from: classes6.dex */
    public class c implements RangeSlider.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoClipLayout a;

        public c(VideoClipLayout videoClipLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoClipLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoClipLayout;
        }

        @Override // com.baidu.tieba.view.widget.mediaedit.RangeSlider.a
        public void a(RangeSlider rangeSlider, int i, float f2, float f3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{rangeSlider, Integer.valueOf(i), Float.valueOf(f2), Float.valueOf(f3)}) == null) {
                this.a.r = f2;
                this.a.s = f3;
                this.a.B(i);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoClipLayout a;

        public d(VideoClipLayout videoClipLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoClipLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoClipLayout;
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x0090  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x00a3  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x00ce  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x00d8  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x012c  */
        /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            boolean z;
            double d2;
            double d3;
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            if (this.a.L()) {
                float Q = this.a.Q();
                int[] D = this.a.D((int) Q);
                if (Q == 0.0f) {
                    this.a.f37154c.n(this.a.getLeftRangeSliderX(), this.a.getRightRangeSliderX());
                } else {
                    VideoClipLayout videoClipLayout = this.a;
                    videoClipLayout.S(videoClipLayout.f37153b, D[0], D[1]);
                    this.a.f37154c.n(this.a.getLeftRangeSliderX() - Q, this.a.getRightRangeSliderX() - Q);
                    z = true;
                    if (this.a.C && !this.a.L()) {
                        this.a.C = false;
                        float thumbWidth = (float) (this.a.f37158g - this.a.f37154c.getThumbWidth());
                        if (VideoClipLayout.J > VideoClipLayout.I) {
                            d2 = this.a.i * VideoClipLayout.J;
                            d3 = this.a.f37158g;
                        } else {
                            d2 = this.a.i * VideoClipLayout.I;
                            d3 = this.a.f37158g;
                        }
                        this.a.f37154c.n(thumbWidth, (float) (d2 + d3));
                    }
                    if (((int) VideoClipLayout.J) > VideoClipLayout.I) {
                        this.a.f37156e.a(false);
                    } else {
                        this.a.f37156e.a(true);
                    }
                    this.a.f37154c.l((int) (this.a.k - this.a.f37158g));
                    VideoClipLayout videoClipLayout2 = this.a;
                    videoClipLayout2.r = videoClipLayout2.f37154c.getLeftThumbX();
                    VideoClipLayout videoClipLayout3 = this.a;
                    videoClipLayout3.s = videoClipLayout3.f37154c.getRightThumbX();
                    if (this.a.L() || z) {
                        if (this.a.L()) {
                            this.a.B(0);
                            return;
                        }
                        return;
                    }
                    this.a.B(0);
                    return;
                }
            }
            z = false;
            if (this.a.C) {
                this.a.C = false;
                float thumbWidth2 = (float) (this.a.f37158g - this.a.f37154c.getThumbWidth());
                if (VideoClipLayout.J > VideoClipLayout.I) {
                }
                this.a.f37154c.n(thumbWidth2, (float) (d2 + d3));
            }
            if (((int) VideoClipLayout.J) > VideoClipLayout.I) {
            }
            this.a.f37154c.l((int) (this.a.k - this.a.f37158g));
            VideoClipLayout videoClipLayout22 = this.a;
            videoClipLayout22.r = videoClipLayout22.f37154c.getLeftThumbX();
            VideoClipLayout videoClipLayout32 = this.a;
            videoClipLayout32.s = videoClipLayout32.f37154c.getRightThumbX();
            if (this.a.L()) {
            }
            if (this.a.L()) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f37161b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ VideoClipLayout f37162c;

        public e(VideoClipLayout videoClipLayout, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoClipLayout, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f37162c = videoClipLayout;
            this.a = i;
            this.f37161b = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f37162c.C = false;
                this.f37162c.f37154c.n((float) ((((this.f37162c.i * this.a) / 1000.0d) + this.f37162c.f37158g) - this.f37162c.f37154c.getThumbWidth()), (float) (((this.f37162c.i * this.f37161b) / 1000.0d) + this.f37162c.f37158g));
                if (((int) VideoClipLayout.J) <= VideoClipLayout.I) {
                    this.f37162c.f37156e.a(false);
                } else {
                    this.f37162c.f37156e.a(true);
                }
                this.f37162c.f37154c.l((int) (this.f37162c.k - this.f37162c.f37158g));
                VideoClipLayout videoClipLayout = this.f37162c;
                videoClipLayout.r = videoClipLayout.f37154c.getLeftThumbX();
                VideoClipLayout videoClipLayout2 = this.f37162c;
                videoClipLayout2.s = videoClipLayout2.f37154c.getRightThumbX();
                if (this.f37162c.L()) {
                    this.f37162c.B(0);
                } else {
                    this.f37162c.B(0);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoClipLayout a;

        public f(VideoClipLayout videoClipLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoClipLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoClipLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                VideoClipLayout.super.setVisibility(8);
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface g {
        void a(float f2);

        void b(long j);

        void d(int i, int i2);

        void g(double d2);

        void onPause();

        void onSeekTo(long j);

        void onStart();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1691612522, "Lcom/baidu/tieba/view/widget/mediaedit/VideoClipLayout;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1691612522, "Lcom/baidu/tieba/view/widget/mediaedit/VideoClipLayout;");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public VideoClipLayout(@NonNull Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getLeftRangeSliderX() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, this)) == null) {
            List<MultiMediaData> list = this.f37157f;
            if (list == null || list.size() <= 0 || this.f37154c == null) {
                return 0.0f;
            }
            return (float) (((this.i * ((((float) this.f37157f.get(0).start) / this.f37157f.get(0).mSpeed) / 1000.0f)) + this.f37158g) - this.f37154c.getThumbWidth());
        }
        return invokeV.floatValue;
    }

    private int getMinDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, this)) == null) {
            int i = this.a;
            return i > 0 ? i : L() ? H : G;
        }
        return invokeV.intValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getRightRangeSliderX() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, this)) == null) {
            List<MultiMediaData> list = this.f37157f;
            if (list == null || list.size() <= 0) {
                return 0.0f;
            }
            long j = ((float) this.f37157f.get(0).start) / this.f37157f.get(0).mSpeed;
            long j2 = ((float) this.f37157f.get(0).end) / this.f37157f.get(0).mSpeed;
            if (j > 0 && j + (I * 1000.0d) >= j2) {
                return (float) ((this.i * (((float) j2) / 1000.0f)) + this.f37158g);
            }
            double d2 = j;
            double d3 = I;
            if ((d3 * 1000.0d) + d2 <= j2) {
                return (float) ((this.i * ((d2 + (d3 * 1000.0d)) / 1000.0d)) + this.f37158g);
            }
            return (float) ((this.i * (((float) j2) / 1000.0f)) + this.f37158g);
        }
        return invokeV.floatValue;
    }

    public final void B(int i) {
        CustomLinearLayoutManager customLinearLayoutManager;
        View childAt;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048576, this, i) == null) || (customLinearLayoutManager = this.f37156e) == null) {
            return;
        }
        int findFirstVisibleItemPosition = customLinearLayoutManager.findFirstVisibleItemPosition();
        int findFirstCompletelyVisibleItemPosition = this.f37156e.findFirstCompletelyVisibleItemPosition();
        if (findFirstCompletelyVisibleItemPosition == 0) {
            double d2 = this.r;
            double d3 = this.f37158g;
            double d4 = this.i;
            this.w = (d2 - d3) / d4;
            this.x = (this.s - d3) / d4;
        } else {
            int[] iArr = new int[2];
            if (findFirstVisibleItemPosition == findFirstCompletelyVisibleItemPosition) {
                childAt = this.f37156e.getChildAt(0);
            } else {
                childAt = this.f37156e.getChildAt(1);
            }
            if (childAt == null) {
                return;
            }
            childAt.getLocationOnScreen(iArr);
            if (findFirstCompletelyVisibleItemPosition == 1) {
                double d5 = this.r - iArr[0];
                double d6 = this.i;
                this.w = d5 / d6;
                this.x = (this.s - iArr[0]) / d6;
            } else if (findFirstCompletelyVisibleItemPosition > 1) {
                int i2 = findFirstCompletelyVisibleItemPosition - 1;
                int i3 = this.m;
                double d7 = (i2 * i3) + (this.r - iArr[0]);
                double d8 = this.i;
                this.w = d7 / d8;
                this.x = ((i2 * i3) + (this.s - iArr[0])) / d8;
            }
        }
        double d9 = this.w * 1000.0d;
        this.w = d9;
        this.x *= 1000.0d;
        int i4 = (int) d9;
        if (i4 < 0) {
            i4 = 0;
        }
        int i5 = (int) this.x;
        int i6 = i5 - i4;
        double d10 = I;
        if (i6 > d10 * 1000.0d) {
            i6 = (int) (d10 * 1000.0d);
            i5 = i4 + i6;
        }
        if (i6 < getMinDuration() * 1000) {
            int minDuration = (getMinDuration() * 1000) - i6;
            int i7 = i4 - minDuration;
            if (i7 >= 0) {
                i4 = i7;
            } else {
                int i8 = minDuration + i5;
                if (i8 <= J * 1000.0d) {
                    i5 = i8;
                }
            }
            i6 = i5 - i4;
        }
        g gVar = this.B;
        if (gVar != null) {
            gVar.b(i6);
        }
        this.f37154c.f(i6);
        if (i == 0 || i == 3 || i == 4 || i == 5) {
            R(i4, i5);
            M(false);
        } else if (i == 1 || i == 6) {
            M(true);
            g gVar2 = this.B;
            if (gVar2 != null) {
                gVar2.onSeekTo(i4);
            }
            this.f37154c.setCurrentAbsolutePosition((float) this.r);
        } else if (i == 2) {
            M(true);
            g gVar3 = this.B;
            if (gVar3 != null) {
                gVar3.onSeekTo(i4);
            }
            RangeSlider rangeSlider = this.f37154c;
            rangeSlider.setCurrentAbsolutePosition(((float) this.s) - rangeSlider.getVerticalLineSize());
        }
    }

    public void C(int i) {
        int i2;
        double d2;
        double d3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            int i3 = this.A;
            if (i3 >= 0 && i >= i3) {
                i2 = this.z;
                d3 = this.x;
            } else {
                i2 = this.z;
                d3 = this.x;
            }
            float min = Math.min(1.0f, Math.max((float) (d2 / (d3 - i2)), 0.0f));
            RangeSlider rangeSlider = this.f37154c;
            if (rangeSlider != null) {
                rangeSlider.setCurrentRelativelyPosition(min);
            }
        }
    }

    public final int[] D(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            int[] iArr = new int[2];
            if (this.f37156e != null) {
                int i2 = 0;
                for (int i3 = 0; i3 < this.f37156e.getItemCount(); i3++) {
                    if (i3 == 0) {
                        double d2 = i2;
                        double d3 = this.f37158g;
                        if (i < d2 + d3) {
                            iArr[0] = i3;
                            iArr[1] = i - i2;
                            return iArr;
                        }
                        i2 = (int) (d2 + d3);
                    } else if (this.f37156e.getChildAt(i3) == null) {
                        continue;
                    } else {
                        int measuredWidth = this.f37156e.getChildAt(i3).getMeasuredWidth() + i2;
                        if (i < measuredWidth) {
                            iArr[0] = i3;
                            iArr[1] = i - i2;
                            return iArr;
                        }
                        i2 = measuredWidth;
                    }
                }
            }
            return iArr;
        }
        return (int[]) invokeI.objValue;
    }

    public final double E(float f2) {
        InterceptResult invokeF;
        View childAt;
        double d2;
        double d3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048579, this, f2)) == null) {
            CustomLinearLayoutManager customLinearLayoutManager = this.f37156e;
            if (customLinearLayoutManager == null) {
                return 0.0d;
            }
            int findFirstVisibleItemPosition = customLinearLayoutManager.findFirstVisibleItemPosition();
            int findFirstCompletelyVisibleItemPosition = this.f37156e.findFirstCompletelyVisibleItemPosition();
            if (findFirstCompletelyVisibleItemPosition == 0) {
                d2 = f2 - this.f37158g;
                d3 = this.i;
            } else {
                int[] iArr = new int[2];
                if (findFirstVisibleItemPosition == findFirstCompletelyVisibleItemPosition) {
                    childAt = this.f37156e.getChildAt(0);
                } else {
                    childAt = this.f37156e.getChildAt(1);
                }
                if (childAt == null) {
                    return 0.0d;
                }
                childAt.getLocationOnScreen(iArr);
                if (findFirstCompletelyVisibleItemPosition == 1) {
                    d2 = f2 - iArr[0];
                    d3 = this.i;
                } else if (findFirstCompletelyVisibleItemPosition <= 1) {
                    return 0.0d;
                } else {
                    d2 = ((findFirstCompletelyVisibleItemPosition - 1) * this.m) + (f2 - iArr[0]);
                    d3 = this.i;
                }
            }
            return d2 / d3;
        }
        return invokeF.doubleValue;
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            VideoClipAdapter videoClipAdapter = new VideoClipAdapter(getContext());
            this.f37155d = videoClipAdapter;
            this.f37153b.setAdapter(videoClipAdapter);
        }
    }

    public final void G(AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, attributeSet) == null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, new int[]{R.attr.obfuscated_res_0x7f040684});
            this.u = obtainStyledAttributes.getInt(0, 0);
            obtainStyledAttributes.recycle();
        }
    }

    public final void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f37153b.addOnScrollListener(new a(this, new int[2]));
            this.f37154c.setVideoPointerViewDragListener(new b(this));
        }
    }

    public final void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            H = 1;
        }
    }

    public final void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            double d2 = ((float) this.t) / 1000.0f;
            J = d2;
            N(d2);
            this.f37158g = UtilHelper.getDimenPixelSize(R.dimen.tbds31);
            this.n = UtilHelper.getDimenPixelSize(R.dimen.tbds130);
            this.m = UtilHelper.getDimenPixelSize(R.dimen.tbds89);
            double k = ((n.k(getContext()) - UtilHelper.getDimenPixelSize(R.dimen.tbds187)) - this.f37158g) - (UtilHelper.getDimenPixelSize(R.dimen.tbds31) * 2);
            this.f37159h = k;
            double d3 = k / I;
            this.i = d3;
            this.j = (int) Math.ceil(d3 * getMinDuration());
            double d4 = this.i;
            double d5 = J;
            double d6 = this.f37158g;
            this.k = (d4 * d5) + (d6 * 2.0d);
            this.l = (d4 * d5) + (d6 * 2.0d);
            double d7 = (d4 * d5) / this.m;
            this.o = d7;
            int ceil = (int) Math.ceil(d7);
            this.p = ceil;
            double d8 = this.o;
            if (ceil == ((int) d8) + 1) {
                this.q = (d8 % 1.0d) * this.m;
            } else {
                this.q = this.m;
            }
            this.f37154c.setMinRangeWidth(this.j);
            this.f37154c.setRangeChangeListener(new c(this));
            ViewGroup.LayoutParams layoutParams = this.f37153b.getLayoutParams();
            ViewGroup.LayoutParams layoutParams2 = this.f37154c.getLayoutParams();
            layoutParams.width = (int) this.k;
            layoutParams2.width = (int) this.l;
            this.f37153b.setLayoutParams(layoutParams);
            this.f37154c.setLayoutParams(layoutParams2);
            this.f37154c.postDelayed(new d(this), 50L);
        }
    }

    public final void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d0858, (ViewGroup) null);
            this.f37153b = (RecyclerView) inflate.findViewById(R.id.obfuscated_res_0x7f092263);
            this.f37154c = (RangeSlider) inflate.findViewById(R.id.obfuscated_res_0x7f092262);
            addView(inflate);
            CustomLinearLayoutManager customLinearLayoutManager = new CustomLinearLayoutManager(getContext(), 0, false);
            this.f37156e = customLinearLayoutManager;
            customLinearLayoutManager.a(true);
            this.f37153b.setLayoutManager(this.f37156e);
        }
    }

    public final boolean L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.u == 2 : invokeV.booleanValue;
    }

    public final void M(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048587, this, z) == null) || this.y == z) {
            return;
        }
        this.y = z;
        if (z) {
            g gVar = this.B;
            if (gVar != null) {
                gVar.onPause();
                return;
            }
            return;
        }
        g gVar2 = this.B;
        if (gVar2 != null) {
            gVar2.onStart();
        }
    }

    public final void N(double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Double.valueOf(d2)}) == null) {
            G = 3;
            double d3 = 600;
            if (d3 > d2) {
                int i = (I > d3 ? 1 : (I == d3 ? 0 : -1));
                I = d2;
                return;
            }
            I = d3;
        }
    }

    public void O() {
        VideoClipAdapter videoClipAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (videoClipAdapter = this.f37155d) == null) {
            return;
        }
        videoClipAdapter.d();
    }

    public void P() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || L()) {
            return;
        }
        this.C = true;
    }

    public final float Q() {
        InterceptResult invokeV;
        double d2;
        double d3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            List<MultiMediaData> list = this.f37157f;
            if (list != null && list.size() > 0) {
                long j = ((float) this.f37157f.get(0).start) / this.f37157f.get(0).mSpeed;
                long j2 = ((float) this.f37157f.get(0).end) / this.f37157f.get(0).mSpeed;
                if (j > 0) {
                    if (j2 > I * 1000.0d) {
                        return (float) ((this.i * ((long) (d2 - (d3 * 1000.0d)))) / 1000.0d);
                    }
                }
            }
            return 0.0f;
        }
        return invokeV.floatValue;
    }

    public final void R(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048592, this, i, i2) == null) {
            if (i < 0) {
                i = 0;
            }
            long j = i2;
            long j2 = this.t;
            if (j > j2 || j2 - j < 50) {
                i2 = (int) this.t;
            }
            if (i == this.z && i2 == this.A) {
                return;
            }
            if (i < 0) {
                i = 0;
            }
            this.z = i;
            if (L()) {
                List<MultiMediaData> list = this.f37157f;
                if (list != null && list.size() == 1) {
                    int i3 = (int) this.f37157f.get(0).originalDuration;
                    if (i2 >= i3) {
                        i2 = i3;
                    }
                    this.A = i2;
                } else {
                    this.A = i2;
                }
            } else {
                int i4 = (int) (J * 1000.0d);
                if (i2 >= i4) {
                    i2 = i4;
                }
                this.A = i2;
            }
            int i5 = this.A;
            long j3 = this.t;
            if (i5 > j3 || j3 - i5 < 50) {
                this.A = (int) this.t;
            }
            g gVar = this.B;
            if (gVar != null) {
                gVar.d(this.z, this.A);
            }
        }
    }

    public final void S(RecyclerView recyclerView, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048593, this, recyclerView, i, i2) == null) {
            int childLayoutPosition = recyclerView.getChildLayoutPosition(recyclerView.getChildAt(0));
            int childLayoutPosition2 = recyclerView.getChildLayoutPosition(recyclerView.getChildAt(recyclerView.getChildCount() - 1));
            if (i < childLayoutPosition) {
                this.f37156e.scrollToPositionWithOffset(i, i2);
                recyclerView.offsetChildrenHorizontal(i2);
            } else if (i <= childLayoutPosition2) {
                int i3 = i - childLayoutPosition;
                if (i3 < 0 || i3 >= recyclerView.getChildCount()) {
                    return;
                }
                recyclerView.smoothScrollBy(recyclerView.getChildAt(i3).getLeft() + i2, 0);
            } else {
                recyclerView.smoothScrollToPosition(i);
                this.F = i;
                this.E = true;
            }
        }
    }

    public int getFromTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.z : invokeV.intValue;
    }

    public void setIsCortoon(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
        }
    }

    public void setLocalAlbumInfoData(VlogEditManager vlogEditManager, List<MultiMediaData> list, boolean z) {
        VideoClipAdapter videoClipAdapter;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048596, this, vlogEditManager, list, z) == null) {
            this.f37157f = list;
            this.t = 0L;
            if (list != null) {
                if (L()) {
                    if (this.f37157f.size() >= 1) {
                        this.t = ((float) this.f37157f.get(0).originalDuration) / this.f37157f.get(0).getCurrentSpeed();
                    }
                } else {
                    for (int i = 0; i < this.f37157f.size(); i++) {
                        this.t += ((float) this.f37157f.get(i).originalDuration) / this.f37157f.get(i).getCurrentSpeed();
                    }
                }
            }
            if (this.t > 0) {
                J();
            }
            if (z && (videoClipAdapter = this.f37155d) != null) {
                videoClipAdapter.g(this.u, this.f37158g, this.m, this.n, this.q, UtilHelper.getDimenPixelSize(R.dimen.tbds130));
                if (vlogEditManager == null) {
                    return;
                }
                if (this.D >= 0) {
                    this.f37155d.e((MultiMediaData) ListUtils.getItem(vlogEditManager.getInputMultiMediaData(), this.D), this.p);
                } else {
                    this.f37155d.f(vlogEditManager, this.p);
                }
            }
        }
    }

    public void setMediaIndex(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i) == null) {
            this.D = i;
        }
    }

    public void setMinDuration(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i) == null) {
            this.a = i;
        }
    }

    public void setRange(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048599, this, i, i2) == null) {
            this.f37154c.postDelayed(new e(this, i, i2), 100L);
        }
    }

    public void setVideoClipListener(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, gVar) == null) {
            this.B = gVar;
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i) == null) {
            if (L() && i == 8) {
                super.setVisibility(4);
                this.f37153b.scrollToPosition(0);
                this.z = 0;
                this.A = 0;
                postDelayed(new f(this), 30L);
                return;
            }
            super.setVisibility(i);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoClipLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.v = true;
        this.D = -1;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public VideoClipLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        G(attributeSet);
        I();
        K();
        H();
        F();
    }
}
