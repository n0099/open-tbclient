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
import b.a.e.e.p.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.R$styleable;
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
/* loaded from: classes9.dex */
public class VideoClipLayout extends FrameLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static int K = 3;
    public static int L = 1;
    public static final int LEVEL_10_M = 600;
    public static final int LEVEL_10_S = 10;
    public static final int LEVEL_20_S = 20;
    public static final int LEVEL_2_M = 120;
    public static final int LEVEL_30_S = 30;
    public static final int LEVEL_5_M = 300;
    public static final int LEVEL_60_S = 60;
    public static double M = 10.0d;
    public static double N;
    public transient /* synthetic */ FieldHolder $fh;
    public double A;
    public double B;
    public boolean C;
    public int D;
    public int E;
    public g F;
    public boolean G;
    public int H;
    public boolean I;
    public int J;

    /* renamed from: e  reason: collision with root package name */
    public int f55630e;

    /* renamed from: f  reason: collision with root package name */
    public RecyclerView f55631f;

    /* renamed from: g  reason: collision with root package name */
    public RangeSlider f55632g;

    /* renamed from: h  reason: collision with root package name */
    public VideoClipAdapter f55633h;

    /* renamed from: i  reason: collision with root package name */
    public CustomLinearLayoutManager f55634i;
    public List<MultiMediaData> j;
    public double k;
    public double l;
    public double m;
    public int n;
    public double o;
    public double p;
    public int q;
    public double r;
    public double s;
    public int t;
    public double u;
    public double v;
    public double w;
    public long x;
    @IntRange(from = 0, to = 2)
    public int y;
    public boolean z;

    /* loaded from: classes9.dex */
    public class a extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int[] f55635a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ VideoClipLayout f55636b;

        public a(VideoClipLayout videoClipLayout, int[] iArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoClipLayout, iArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55636b = videoClipLayout;
            this.f55635a = iArr;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) {
                if (i2 == 0) {
                    this.f55636b.B(5);
                }
                if (this.f55636b.I && i2 == 0) {
                    this.f55636b.I = false;
                    VideoClipLayout videoClipLayout = this.f55636b;
                    videoClipLayout.P(videoClipLayout.f55631f, this.f55636b.J, 0);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i2, i3) == null) {
                if (this.f55636b.f55634i.findFirstVisibleItemPosition() == 0) {
                    this.f55636b.f55632g.updateLeftCoverOffset(recyclerView.computeHorizontalScrollOffset());
                } else {
                    this.f55636b.f55632g.updateAbsoluteLeftCoverOffset(0.0f);
                }
                if (this.f55636b.f55634i.findLastVisibleItemPosition() == recyclerView.getAdapter().getItemCount() - 1) {
                    this.f55636b.f55634i.getChildAt(this.f55636b.f55634i.getChildCount() - 1).getLocationOnScreen(this.f55635a);
                    this.f55636b.f55632g.updateAbsoluteRightOffset(this.f55635a[0]);
                } else {
                    this.f55636b.f55632g.updateAbsoluteRightOffset((int) ((this.f55636b.o - this.f55636b.k) - recyclerView.computeHorizontalScrollOffset()));
                }
                if (this.f55636b.z) {
                    this.f55636b.z = false;
                } else {
                    this.f55636b.B(6);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements RangeSlider.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoClipLayout f55637a;

        public b(VideoClipLayout videoClipLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoClipLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55637a = videoClipLayout;
        }

        @Override // com.baidu.tieba.view.widget.mediaedit.RangeSlider.b
        public void a(float f2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeF(1048576, this, f2) == null) || this.f55637a.F == null) {
                return;
            }
            this.f55637a.F.onDraging(this.f55637a.D(f2) * 1000.0d);
        }

        @Override // com.baidu.tieba.view.widget.mediaedit.RangeSlider.b
        public void onDragCancel(float f2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f2) == null) || this.f55637a.F == null) {
                return;
            }
            this.f55637a.F.onDragCancel(((float) this.f55637a.D(f2)) * 1000.0f);
        }
    }

    /* loaded from: classes9.dex */
    public class c implements RangeSlider.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoClipLayout f55638a;

        public c(VideoClipLayout videoClipLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoClipLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55638a = videoClipLayout;
        }

        @Override // com.baidu.tieba.view.widget.mediaedit.RangeSlider.a
        public void a(RangeSlider rangeSlider, int i2, float f2, float f3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{rangeSlider, Integer.valueOf(i2), Float.valueOf(f2), Float.valueOf(f3)}) == null) {
                this.f55638a.v = f2;
                this.f55638a.w = f3;
                this.f55638a.B(i2);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoClipLayout f55639e;

        public d(VideoClipLayout videoClipLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoClipLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55639e = videoClipLayout;
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
            if (this.f55639e.K()) {
                float N = this.f55639e.N();
                int[] C = this.f55639e.C((int) N);
                if (N == 0.0f) {
                    this.f55639e.f55632g.updateSelectedRange(this.f55639e.getLeftRangeSliderX(), this.f55639e.getRightRangeSliderX());
                } else {
                    VideoClipLayout videoClipLayout = this.f55639e;
                    videoClipLayout.P(videoClipLayout.f55631f, C[0], C[1]);
                    this.f55639e.f55632g.updateSelectedRange(this.f55639e.getLeftRangeSliderX() - N, this.f55639e.getRightRangeSliderX() - N);
                    z = true;
                    if (this.f55639e.G && !this.f55639e.K()) {
                        this.f55639e.G = false;
                        float thumbWidth = (float) (this.f55639e.k - this.f55639e.f55632g.getThumbWidth());
                        if (VideoClipLayout.N > VideoClipLayout.M) {
                            d2 = this.f55639e.m * VideoClipLayout.N;
                            d3 = this.f55639e.k;
                        } else {
                            d2 = this.f55639e.m * VideoClipLayout.M;
                            d3 = this.f55639e.k;
                        }
                        this.f55639e.f55632g.updateSelectedRange(thumbWidth, (float) (d2 + d3));
                    }
                    if (((int) VideoClipLayout.N) > VideoClipLayout.M) {
                        this.f55639e.f55634i.setScrollEnabled(false);
                    } else {
                        this.f55639e.f55634i.setScrollEnabled(true);
                    }
                    this.f55639e.f55632g.updateAbsoluteRightOffset((int) (this.f55639e.o - this.f55639e.k));
                    VideoClipLayout videoClipLayout2 = this.f55639e;
                    videoClipLayout2.v = videoClipLayout2.f55632g.getLeftThumbX();
                    VideoClipLayout videoClipLayout3 = this.f55639e;
                    videoClipLayout3.w = videoClipLayout3.f55632g.getRightThumbX();
                    if (this.f55639e.K() || z) {
                        if (this.f55639e.K()) {
                            this.f55639e.B(0);
                            return;
                        }
                        return;
                    }
                    this.f55639e.B(0);
                    return;
                }
            }
            z = false;
            if (this.f55639e.G) {
                this.f55639e.G = false;
                float thumbWidth2 = (float) (this.f55639e.k - this.f55639e.f55632g.getThumbWidth());
                if (VideoClipLayout.N > VideoClipLayout.M) {
                }
                this.f55639e.f55632g.updateSelectedRange(thumbWidth2, (float) (d2 + d3));
            }
            if (((int) VideoClipLayout.N) > VideoClipLayout.M) {
            }
            this.f55639e.f55632g.updateAbsoluteRightOffset((int) (this.f55639e.o - this.f55639e.k));
            VideoClipLayout videoClipLayout22 = this.f55639e;
            videoClipLayout22.v = videoClipLayout22.f55632g.getLeftThumbX();
            VideoClipLayout videoClipLayout32 = this.f55639e;
            videoClipLayout32.w = videoClipLayout32.f55632g.getRightThumbX();
            if (this.f55639e.K()) {
            }
            if (this.f55639e.K()) {
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f55640e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f55641f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ VideoClipLayout f55642g;

        public e(VideoClipLayout videoClipLayout, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoClipLayout, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55642g = videoClipLayout;
            this.f55640e = i2;
            this.f55641f = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f55642g.G = false;
                this.f55642g.f55632g.updateSelectedRange((float) ((((this.f55642g.m * this.f55640e) / 1000.0d) + this.f55642g.k) - this.f55642g.f55632g.getThumbWidth()), (float) (((this.f55642g.m * this.f55641f) / 1000.0d) + this.f55642g.k));
                if (((int) VideoClipLayout.N) <= VideoClipLayout.M) {
                    this.f55642g.f55634i.setScrollEnabled(false);
                } else {
                    this.f55642g.f55634i.setScrollEnabled(true);
                }
                this.f55642g.f55632g.updateAbsoluteRightOffset((int) (this.f55642g.o - this.f55642g.k));
                VideoClipLayout videoClipLayout = this.f55642g;
                videoClipLayout.v = videoClipLayout.f55632g.getLeftThumbX();
                VideoClipLayout videoClipLayout2 = this.f55642g;
                videoClipLayout2.w = videoClipLayout2.f55632g.getRightThumbX();
                if (this.f55642g.K()) {
                    this.f55642g.B(0);
                } else {
                    this.f55642g.B(0);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoClipLayout f55643e;

        public f(VideoClipLayout videoClipLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoClipLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55643e = videoClipLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                VideoClipLayout.super.setVisibility(8);
            }
        }
    }

    /* loaded from: classes9.dex */
    public interface g {
        void onClipTime(int i2, int i3);

        void onDragCancel(float f2);

        void onDraging(double d2);

        void onHaveSelectedTime(long j);

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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
            List<MultiMediaData> list = this.j;
            if (list == null || list.size() <= 0 || this.f55632g == null) {
                return 0.0f;
            }
            return (float) (((this.m * ((((float) this.j.get(0).start) / this.j.get(0).mSpeed) / 1000.0f)) + this.k) - this.f55632g.getThumbWidth());
        }
        return invokeV.floatValue;
    }

    private int getMinDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, this)) == null) {
            int i2 = this.f55630e;
            return i2 > 0 ? i2 : K() ? L : K;
        }
        return invokeV.intValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getRightRangeSliderX() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, this)) == null) {
            List<MultiMediaData> list = this.j;
            if (list == null || list.size() <= 0) {
                return 0.0f;
            }
            long j = ((float) this.j.get(0).start) / this.j.get(0).mSpeed;
            long j2 = ((float) this.j.get(0).end) / this.j.get(0).mSpeed;
            if (j > 0 && j + (M * 1000.0d) >= j2) {
                return (float) ((this.m * (((float) j2) / 1000.0f)) + this.k);
            }
            double d2 = j;
            double d3 = M;
            if ((d3 * 1000.0d) + d2 <= j2) {
                return (float) ((this.m * ((d2 + (d3 * 1000.0d)) / 1000.0d)) + this.k);
            }
            return (float) ((this.m * (((float) j2) / 1000.0f)) + this.k);
        }
        return invokeV.floatValue;
    }

    public final void B(int i2) {
        CustomLinearLayoutManager customLinearLayoutManager;
        View childAt;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || (customLinearLayoutManager = this.f55634i) == null) {
            return;
        }
        int findFirstVisibleItemPosition = customLinearLayoutManager.findFirstVisibleItemPosition();
        int findFirstCompletelyVisibleItemPosition = this.f55634i.findFirstCompletelyVisibleItemPosition();
        if (findFirstCompletelyVisibleItemPosition == 0) {
            double d2 = this.v;
            double d3 = this.k;
            double d4 = this.m;
            this.A = (d2 - d3) / d4;
            this.B = (this.w - d3) / d4;
        } else {
            int[] iArr = new int[2];
            if (findFirstVisibleItemPosition == findFirstCompletelyVisibleItemPosition) {
                childAt = this.f55634i.getChildAt(0);
            } else {
                childAt = this.f55634i.getChildAt(1);
            }
            if (childAt == null) {
                return;
            }
            childAt.getLocationOnScreen(iArr);
            if (findFirstCompletelyVisibleItemPosition == 1) {
                double d5 = this.v - iArr[0];
                double d6 = this.m;
                this.A = d5 / d6;
                this.B = (this.w - iArr[0]) / d6;
            } else if (findFirstCompletelyVisibleItemPosition > 1) {
                int i3 = findFirstCompletelyVisibleItemPosition - 1;
                int i4 = this.q;
                double d7 = (i3 * i4) + (this.v - iArr[0]);
                double d8 = this.m;
                this.A = d7 / d8;
                this.B = ((i3 * i4) + (this.w - iArr[0])) / d8;
            }
        }
        double d9 = this.A * 1000.0d;
        this.A = d9;
        this.B *= 1000.0d;
        int i5 = (int) d9;
        if (i5 < 0) {
            i5 = 0;
        }
        int i6 = (int) this.B;
        int i7 = i6 - i5;
        double d10 = M;
        if (i7 > d10 * 1000.0d) {
            i7 = (int) (d10 * 1000.0d);
            i6 = i5 + i7;
        }
        if (i7 < getMinDuration() * 1000) {
            int minDuration = (getMinDuration() * 1000) - i7;
            int i8 = i5 - minDuration;
            if (i8 >= 0) {
                i5 = i8;
            } else {
                int i9 = minDuration + i6;
                if (i9 <= N * 1000.0d) {
                    i6 = i9;
                }
            }
            i7 = i6 - i5;
        }
        g gVar = this.F;
        if (gVar != null) {
            gVar.onHaveSelectedTime(i7);
        }
        this.f55632g.playValueAnimator(i7);
        if (i2 == 0 || i2 == 3 || i2 == 4 || i2 == 5) {
            O(i5, i6);
            L(false);
        } else if (i2 == 1 || i2 == 6) {
            L(true);
            g gVar2 = this.F;
            if (gVar2 != null) {
                gVar2.onSeekTo(i5);
            }
            this.f55632g.setCurrentAbsolutePosition((float) this.v);
        } else if (i2 == 2) {
            L(true);
            g gVar3 = this.F;
            if (gVar3 != null) {
                gVar3.onSeekTo(i5);
            }
            RangeSlider rangeSlider = this.f55632g;
            rangeSlider.setCurrentAbsolutePosition(((float) this.w) - rangeSlider.getVerticalLineSize());
        }
    }

    public final int[] C(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            int[] iArr = new int[2];
            if (this.f55634i != null) {
                int i3 = 0;
                for (int i4 = 0; i4 < this.f55634i.getItemCount(); i4++) {
                    if (i4 == 0) {
                        double d2 = i3;
                        double d3 = this.k;
                        if (i2 < d2 + d3) {
                            iArr[0] = i4;
                            iArr[1] = i2 - i3;
                            return iArr;
                        }
                        i3 = (int) (d2 + d3);
                    } else if (this.f55634i.getChildAt(i4) == null) {
                        continue;
                    } else {
                        int measuredWidth = this.f55634i.getChildAt(i4).getMeasuredWidth() + i3;
                        if (i2 < measuredWidth) {
                            iArr[0] = i4;
                            iArr[1] = i2 - i3;
                            return iArr;
                        }
                        i3 = measuredWidth;
                    }
                }
            }
            return iArr;
        }
        return (int[]) invokeI.objValue;
    }

    public final double D(float f2) {
        InterceptResult invokeF;
        View childAt;
        double d2;
        double d3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(Constants.METHOD_SEND_USER_MSG, this, f2)) == null) {
            CustomLinearLayoutManager customLinearLayoutManager = this.f55634i;
            if (customLinearLayoutManager == null) {
                return 0.0d;
            }
            int findFirstVisibleItemPosition = customLinearLayoutManager.findFirstVisibleItemPosition();
            int findFirstCompletelyVisibleItemPosition = this.f55634i.findFirstCompletelyVisibleItemPosition();
            if (findFirstCompletelyVisibleItemPosition == 0) {
                d2 = f2 - this.k;
                d3 = this.m;
            } else {
                int[] iArr = new int[2];
                if (findFirstVisibleItemPosition == findFirstCompletelyVisibleItemPosition) {
                    childAt = this.f55634i.getChildAt(0);
                } else {
                    childAt = this.f55634i.getChildAt(1);
                }
                if (childAt == null) {
                    return 0.0d;
                }
                childAt.getLocationOnScreen(iArr);
                if (findFirstCompletelyVisibleItemPosition == 1) {
                    d2 = f2 - iArr[0];
                    d3 = this.m;
                } else if (findFirstCompletelyVisibleItemPosition <= 1) {
                    return 0.0d;
                } else {
                    d2 = ((findFirstCompletelyVisibleItemPosition - 1) * this.q) + (f2 - iArr[0]);
                    d3 = this.m;
                }
            }
            return d2 / d3;
        }
        return invokeF.doubleValue;
    }

    public final void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            VideoClipAdapter videoClipAdapter = new VideoClipAdapter(getContext());
            this.f55633h = videoClipAdapter;
            this.f55631f.setAdapter(videoClipAdapter);
        }
    }

    public final void F(AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, attributeSet) == null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.VideoClipLayout);
            this.y = obtainStyledAttributes.getInt(R$styleable.VideoClipLayout_videoClipType, 0);
            obtainStyledAttributes.recycle();
        }
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f55631f.addOnScrollListener(new a(this, new int[2]));
            this.f55632g.setVideoPointerViewDragListener(new b(this));
        }
    }

    public final void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            L = 1;
        }
    }

    public final void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            double d2 = ((float) this.x) / 1000.0f;
            N = d2;
            M(d2);
            this.k = UtilHelper.getDimenPixelSize(R.dimen.tbds31);
            this.r = UtilHelper.getDimenPixelSize(R.dimen.tbds130);
            this.q = UtilHelper.getDimenPixelSize(R.dimen.tbds89);
            double k = ((l.k(getContext()) - UtilHelper.getDimenPixelSize(R.dimen.tbds187)) - this.k) - (UtilHelper.getDimenPixelSize(R.dimen.tbds31) * 2);
            this.l = k;
            double d3 = k / M;
            this.m = d3;
            this.n = (int) Math.ceil(d3 * getMinDuration());
            double d4 = this.m;
            double d5 = N;
            double d6 = this.k;
            this.o = (d4 * d5) + (d6 * 2.0d);
            this.p = (d4 * d5) + (d6 * 2.0d);
            double d7 = (d4 * d5) / this.q;
            this.s = d7;
            int ceil = (int) Math.ceil(d7);
            this.t = ceil;
            double d8 = this.s;
            if (ceil == ((int) d8) + 1) {
                this.u = (d8 % 1.0d) * this.q;
            } else {
                this.u = this.q;
            }
            this.f55632g.setMinRangeWidth(this.n);
            this.f55632g.setRangeChangeListener(new c(this));
            ViewGroup.LayoutParams layoutParams = this.f55631f.getLayoutParams();
            ViewGroup.LayoutParams layoutParams2 = this.f55632g.getLayoutParams();
            layoutParams.width = (int) this.o;
            layoutParams2.width = (int) this.p;
            this.f55631f.setLayoutParams(layoutParams);
            this.f55632g.setLayoutParams(layoutParams2);
            this.f55632g.postDelayed(new d(this), 50L);
        }
    }

    public final void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.ugc_capture_multi_video_clip_view, (ViewGroup) null);
            this.f55631f = (RecyclerView) inflate.findViewById(R.id.ugc_video_recycler);
            this.f55632g = (RangeSlider) inflate.findViewById(R.id.ugc_video_range_slider);
            addView(inflate);
            CustomLinearLayoutManager customLinearLayoutManager = new CustomLinearLayoutManager(getContext(), 0, false);
            this.f55634i = customLinearLayoutManager;
            customLinearLayoutManager.setScrollEnabled(true);
            this.f55631f.setLayoutManager(this.f55634i);
        }
    }

    public final boolean K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.y == 2 : invokeV.booleanValue;
    }

    public final void L(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048586, this, z) == null) || this.C == z) {
            return;
        }
        this.C = z;
        if (z) {
            g gVar = this.F;
            if (gVar != null) {
                gVar.onPause();
                return;
            }
            return;
        }
        g gVar2 = this.F;
        if (gVar2 != null) {
            gVar2.onStart();
        }
    }

    public final void M(double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Double.valueOf(d2)}) == null) {
            K = 3;
            double d3 = 600;
            if (d3 > d2) {
                int i2 = (M > d3 ? 1 : (M == d3 ? 0 : -1));
                M = d2;
                return;
            }
            M = d3;
        }
    }

    public final float N() {
        InterceptResult invokeV;
        double d2;
        double d3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            List<MultiMediaData> list = this.j;
            if (list != null && list.size() > 0) {
                long j = ((float) this.j.get(0).start) / this.j.get(0).mSpeed;
                long j2 = ((float) this.j.get(0).end) / this.j.get(0).mSpeed;
                if (j > 0) {
                    if (j2 > M * 1000.0d) {
                        return (float) ((this.m * ((long) (d2 - (d3 * 1000.0d)))) / 1000.0d);
                    }
                }
            }
            return 0.0f;
        }
        return invokeV.floatValue;
    }

    public final void O(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048589, this, i2, i3) == null) {
            if (i2 < 0) {
                i2 = 0;
            }
            long j = i3;
            long j2 = this.x;
            if (j > j2 || j2 - j < 50) {
                i3 = (int) this.x;
            }
            if (i2 == this.D && i3 == this.E) {
                return;
            }
            if (i2 < 0) {
                i2 = 0;
            }
            this.D = i2;
            if (K()) {
                List<MultiMediaData> list = this.j;
                if (list != null && list.size() == 1) {
                    int i4 = (int) this.j.get(0).originalDuration;
                    if (i3 >= i4) {
                        i3 = i4;
                    }
                    this.E = i3;
                } else {
                    this.E = i3;
                }
            } else {
                int i5 = (int) (N * 1000.0d);
                if (i3 >= i5) {
                    i3 = i5;
                }
                this.E = i3;
            }
            int i6 = this.E;
            long j3 = this.x;
            if (i6 > j3 || j3 - i6 < 50) {
                this.E = (int) this.x;
            }
            g gVar = this.F;
            if (gVar != null) {
                gVar.onClipTime(this.D, this.E);
            }
        }
    }

    public final void P(RecyclerView recyclerView, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048590, this, recyclerView, i2, i3) == null) {
            int childLayoutPosition = recyclerView.getChildLayoutPosition(recyclerView.getChildAt(0));
            int childLayoutPosition2 = recyclerView.getChildLayoutPosition(recyclerView.getChildAt(recyclerView.getChildCount() - 1));
            if (i2 < childLayoutPosition) {
                this.f55634i.scrollToPositionWithOffset(i2, i3);
                recyclerView.offsetChildrenHorizontal(i3);
            } else if (i2 <= childLayoutPosition2) {
                int i4 = i2 - childLayoutPosition;
                if (i4 < 0 || i4 >= recyclerView.getChildCount()) {
                    return;
                }
                recyclerView.smoothScrollBy(recyclerView.getChildAt(i4).getLeft() + i3, 0);
            } else {
                recyclerView.smoothScrollToPosition(i2);
                this.J = i2;
                this.I = true;
            }
        }
    }

    public void doCheckProgress(int i2) {
        int i3;
        double d2;
        double d3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            int i4 = this.E;
            if (i4 >= 0 && i2 >= i4) {
                i3 = this.D;
                d3 = this.B;
            } else {
                i3 = this.D;
                d3 = this.B;
            }
            float min = Math.min(1.0f, Math.max((float) (d2 / (d3 - i3)), 0.0f));
            RangeSlider rangeSlider = this.f55632g;
            if (rangeSlider != null) {
                rangeSlider.setCurrentRelativelyPosition(min);
            }
        }
    }

    public int getFromTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.D : invokeV.intValue;
    }

    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            B(3);
        }
    }

    public void release() {
        VideoClipAdapter videoClipAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (videoClipAdapter = this.f55633h) == null) {
            return;
        }
        videoClipAdapter.release();
    }

    public void resetRangeSlider() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || K()) {
            return;
        }
        this.G = true;
    }

    public void setIsCortoon(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
        }
    }

    public void setLocalAlbumInfoData(VlogEditManager vlogEditManager, List<MultiMediaData> list, boolean z) {
        VideoClipAdapter videoClipAdapter;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048597, this, vlogEditManager, list, z) == null) {
            this.j = list;
            this.x = 0L;
            if (list != null) {
                if (K()) {
                    if (this.j.size() >= 1) {
                        this.x = ((float) this.j.get(0).originalDuration) / this.j.get(0).getCurrentSpeed();
                    }
                } else {
                    for (int i2 = 0; i2 < this.j.size(); i2++) {
                        this.x += ((float) this.j.get(i2).originalDuration) / this.j.get(i2).getCurrentSpeed();
                    }
                }
            }
            if (this.x > 0) {
                I();
            }
            if (z && (videoClipAdapter = this.f55633h) != null) {
                videoClipAdapter.setImageConfig(this.y, this.k, this.q, this.r, this.u, UtilHelper.getDimenPixelSize(R.dimen.tbds130));
                if (vlogEditManager == null) {
                    return;
                }
                if (this.H >= 0) {
                    this.f55633h.setData((MultiMediaData) ListUtils.getItem(vlogEditManager.getInputMultiMediaData(), this.H), this.t);
                } else {
                    this.f55633h.setData(vlogEditManager, this.t);
                }
            }
        }
    }

    public void setMediaIndex(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
            this.H = i2;
        }
    }

    public void setMinDuration(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i2) == null) {
            this.f55630e = i2;
        }
    }

    public void setRange(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048600, this, i2, i3) == null) {
            this.f55632g.postDelayed(new e(this, i2, i3), 100L);
        }
    }

    public void setVideoClipListener(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, gVar) == null) {
            this.F = gVar;
        }
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i2) == null) {
            if (K() && i2 == 8) {
                super.setVisibility(4);
                this.f55631f.scrollToPosition(0);
                this.D = 0;
                this.E = 0;
                postDelayed(new f(this), 30L);
                return;
            }
            super.setVisibility(i2);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoClipLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.z = true;
        this.H = -1;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        F(attributeSet);
        H();
        J();
        G();
        E();
    }
}
