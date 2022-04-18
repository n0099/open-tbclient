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
import com.repackage.oi;
import java.util.List;
/* loaded from: classes4.dex */
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
    public RecyclerView b;
    public RangeSlider c;
    public VideoClipAdapter d;
    public CustomLinearLayoutManager e;
    public List<MultiMediaData> f;
    public double g;
    public double h;
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

    /* loaded from: classes4.dex */
    public class a extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int[] a;
        public final /* synthetic */ VideoClipLayout b;

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
            this.b = videoClipLayout;
            this.a = iArr;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i) == null) {
                if (i == 0) {
                    this.b.B(5);
                }
                if (this.b.E && i == 0) {
                    this.b.E = false;
                    VideoClipLayout videoClipLayout = this.b;
                    videoClipLayout.S(videoClipLayout.b, this.b.F, 0);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i, i2) == null) {
                if (this.b.e.findFirstVisibleItemPosition() == 0) {
                    this.b.c.m(recyclerView.computeHorizontalScrollOffset());
                } else {
                    this.b.c.k(0.0f);
                }
                if (this.b.e.findLastVisibleItemPosition() == recyclerView.getAdapter().getItemCount() - 1) {
                    this.b.e.getChildAt(this.b.e.getChildCount() - 1).getLocationOnScreen(this.a);
                    this.b.c.l(this.a[0]);
                } else {
                    this.b.c.l((int) ((this.b.k - this.b.g) - recyclerView.computeHorizontalScrollOffset()));
                }
                if (this.b.v) {
                    this.b.v = false;
                } else {
                    this.b.B(6);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
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
        public void a(float f) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeF(1048576, this, f) == null) || this.a.B == null) {
                return;
            }
            this.a.B.a(((float) this.a.E(f)) * 1000.0f);
        }

        @Override // com.baidu.tieba.view.widget.mediaedit.RangeSlider.b
        public void b(float f) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f) == null) || this.a.B == null) {
                return;
            }
            this.a.B.g(this.a.E(f) * 1000.0d);
        }
    }

    /* loaded from: classes4.dex */
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
        public void a(RangeSlider rangeSlider, int i, float f, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{rangeSlider, Integer.valueOf(i), Float.valueOf(f), Float.valueOf(f2)}) == null) {
                this.a.r = f;
                this.a.s = f2;
                this.a.B(i);
            }
        }
    }

    /* loaded from: classes4.dex */
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
            double d;
            double d2;
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            if (this.a.L()) {
                float Q = this.a.Q();
                int[] D = this.a.D((int) Q);
                if (Q == 0.0f) {
                    this.a.c.n(this.a.getLeftRangeSliderX(), this.a.getRightRangeSliderX());
                } else {
                    VideoClipLayout videoClipLayout = this.a;
                    videoClipLayout.S(videoClipLayout.b, D[0], D[1]);
                    this.a.c.n(this.a.getLeftRangeSliderX() - Q, this.a.getRightRangeSliderX() - Q);
                    z = true;
                    if (this.a.C && !this.a.L()) {
                        this.a.C = false;
                        float thumbWidth = (float) (this.a.g - this.a.c.getThumbWidth());
                        if (VideoClipLayout.J > VideoClipLayout.I) {
                            d = this.a.i * VideoClipLayout.J;
                            d2 = this.a.g;
                        } else {
                            d = this.a.i * VideoClipLayout.I;
                            d2 = this.a.g;
                        }
                        this.a.c.n(thumbWidth, (float) (d + d2));
                    }
                    if (((int) VideoClipLayout.J) > VideoClipLayout.I) {
                        this.a.e.a(false);
                    } else {
                        this.a.e.a(true);
                    }
                    this.a.c.l((int) (this.a.k - this.a.g));
                    VideoClipLayout videoClipLayout2 = this.a;
                    videoClipLayout2.r = videoClipLayout2.c.getLeftThumbX();
                    VideoClipLayout videoClipLayout3 = this.a;
                    videoClipLayout3.s = videoClipLayout3.c.getRightThumbX();
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
                float thumbWidth2 = (float) (this.a.g - this.a.c.getThumbWidth());
                if (VideoClipLayout.J > VideoClipLayout.I) {
                }
                this.a.c.n(thumbWidth2, (float) (d + d2));
            }
            if (((int) VideoClipLayout.J) > VideoClipLayout.I) {
            }
            this.a.c.l((int) (this.a.k - this.a.g));
            VideoClipLayout videoClipLayout22 = this.a;
            videoClipLayout22.r = videoClipLayout22.c.getLeftThumbX();
            VideoClipLayout videoClipLayout32 = this.a;
            videoClipLayout32.s = videoClipLayout32.c.getRightThumbX();
            if (this.a.L()) {
            }
            if (this.a.L()) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;
        public final /* synthetic */ VideoClipLayout c;

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
            this.c = videoClipLayout;
            this.a = i;
            this.b = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.c.C = false;
                this.c.c.n((float) ((((this.c.i * this.a) / 1000.0d) + this.c.g) - this.c.c.getThumbWidth()), (float) (((this.c.i * this.b) / 1000.0d) + this.c.g));
                if (((int) VideoClipLayout.J) <= VideoClipLayout.I) {
                    this.c.e.a(false);
                } else {
                    this.c.e.a(true);
                }
                this.c.c.l((int) (this.c.k - this.c.g));
                VideoClipLayout videoClipLayout = this.c;
                videoClipLayout.r = videoClipLayout.c.getLeftThumbX();
                VideoClipLayout videoClipLayout2 = this.c;
                videoClipLayout2.s = videoClipLayout2.c.getRightThumbX();
                if (this.c.L()) {
                    this.c.B(0);
                } else {
                    this.c.B(0);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
    public interface g {
        void a(float f);

        void b(long j);

        void d(int i, int i2);

        void g(double d);

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
            List<MultiMediaData> list = this.f;
            if (list == null || list.size() <= 0 || this.c == null) {
                return 0.0f;
            }
            return (float) (((this.i * ((((float) this.f.get(0).start) / this.f.get(0).mSpeed) / 1000.0f)) + this.g) - this.c.getThumbWidth());
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
            List<MultiMediaData> list = this.f;
            if (list == null || list.size() <= 0) {
                return 0.0f;
            }
            long j = ((float) this.f.get(0).start) / this.f.get(0).mSpeed;
            long j2 = ((float) this.f.get(0).end) / this.f.get(0).mSpeed;
            if (j > 0 && j + (I * 1000.0d) >= j2) {
                return (float) ((this.i * (((float) j2) / 1000.0f)) + this.g);
            }
            double d2 = j;
            double d3 = I;
            if ((d3 * 1000.0d) + d2 <= j2) {
                return (float) ((this.i * ((d2 + (d3 * 1000.0d)) / 1000.0d)) + this.g);
            }
            return (float) ((this.i * (((float) j2) / 1000.0f)) + this.g);
        }
        return invokeV.floatValue;
    }

    public final void B(int i) {
        CustomLinearLayoutManager customLinearLayoutManager;
        View childAt;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048576, this, i) == null) || (customLinearLayoutManager = this.e) == null) {
            return;
        }
        int findFirstVisibleItemPosition = customLinearLayoutManager.findFirstVisibleItemPosition();
        int findFirstCompletelyVisibleItemPosition = this.e.findFirstCompletelyVisibleItemPosition();
        if (findFirstCompletelyVisibleItemPosition == 0) {
            double d2 = this.r;
            double d3 = this.g;
            double d4 = this.i;
            this.w = (d2 - d3) / d4;
            this.x = (this.s - d3) / d4;
        } else {
            int[] iArr = new int[2];
            if (findFirstVisibleItemPosition == findFirstCompletelyVisibleItemPosition) {
                childAt = this.e.getChildAt(0);
            } else {
                childAt = this.e.getChildAt(1);
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
        this.c.f(i6);
        if (i == 0 || i == 3 || i == 4 || i == 5) {
            R(i4, i5);
            M(false);
        } else if (i == 1 || i == 6) {
            M(true);
            g gVar2 = this.B;
            if (gVar2 != null) {
                gVar2.onSeekTo(i4);
            }
            this.c.setCurrentAbsolutePosition((float) this.r);
        } else if (i == 2) {
            M(true);
            g gVar3 = this.B;
            if (gVar3 != null) {
                gVar3.onSeekTo(i4);
            }
            RangeSlider rangeSlider = this.c;
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
            RangeSlider rangeSlider = this.c;
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
            if (this.e != null) {
                int i2 = 0;
                for (int i3 = 0; i3 < this.e.getItemCount(); i3++) {
                    if (i3 == 0) {
                        double d2 = i2;
                        double d3 = this.g;
                        if (i < d2 + d3) {
                            iArr[0] = i3;
                            iArr[1] = i - i2;
                            return iArr;
                        }
                        i2 = (int) (d2 + d3);
                    } else if (this.e.getChildAt(i3) == null) {
                        continue;
                    } else {
                        int measuredWidth = this.e.getChildAt(i3).getMeasuredWidth() + i2;
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
            CustomLinearLayoutManager customLinearLayoutManager = this.e;
            if (customLinearLayoutManager == null) {
                return 0.0d;
            }
            int findFirstVisibleItemPosition = customLinearLayoutManager.findFirstVisibleItemPosition();
            int findFirstCompletelyVisibleItemPosition = this.e.findFirstCompletelyVisibleItemPosition();
            if (findFirstCompletelyVisibleItemPosition == 0) {
                d2 = f2 - this.g;
                d3 = this.i;
            } else {
                int[] iArr = new int[2];
                if (findFirstVisibleItemPosition == findFirstCompletelyVisibleItemPosition) {
                    childAt = this.e.getChildAt(0);
                } else {
                    childAt = this.e.getChildAt(1);
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
            this.d = videoClipAdapter;
            this.b.setAdapter(videoClipAdapter);
        }
    }

    public final void G(AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, attributeSet) == null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, new int[]{R.attr.obfuscated_res_0x7f0406c2});
            this.u = obtainStyledAttributes.getInt(0, 0);
            obtainStyledAttributes.recycle();
        }
    }

    public final void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.b.addOnScrollListener(new a(this, new int[2]));
            this.c.setVideoPointerViewDragListener(new b(this));
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
            this.g = UtilHelper.getDimenPixelSize(R.dimen.tbds31);
            this.n = UtilHelper.getDimenPixelSize(R.dimen.tbds130);
            this.m = UtilHelper.getDimenPixelSize(R.dimen.tbds89);
            double k = ((oi.k(getContext()) - UtilHelper.getDimenPixelSize(R.dimen.tbds187)) - this.g) - (UtilHelper.getDimenPixelSize(R.dimen.tbds31) * 2);
            this.h = k;
            double d3 = k / I;
            this.i = d3;
            this.j = (int) Math.ceil(d3 * getMinDuration());
            double d4 = this.i;
            double d5 = J;
            double d6 = this.g;
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
            this.c.setMinRangeWidth(this.j);
            this.c.setRangeChangeListener(new c(this));
            ViewGroup.LayoutParams layoutParams = this.b.getLayoutParams();
            ViewGroup.LayoutParams layoutParams2 = this.c.getLayoutParams();
            layoutParams.width = (int) this.k;
            layoutParams2.width = (int) this.l;
            this.b.setLayoutParams(layoutParams);
            this.c.setLayoutParams(layoutParams2);
            this.c.postDelayed(new d(this), 50L);
        }
    }

    public final void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d084f, (ViewGroup) null);
            this.b = (RecyclerView) inflate.findViewById(R.id.obfuscated_res_0x7f092248);
            this.c = (RangeSlider) inflate.findViewById(R.id.obfuscated_res_0x7f092247);
            addView(inflate);
            CustomLinearLayoutManager customLinearLayoutManager = new CustomLinearLayoutManager(getContext(), 0, false);
            this.e = customLinearLayoutManager;
            customLinearLayoutManager.a(true);
            this.b.setLayoutManager(this.e);
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
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (videoClipAdapter = this.d) == null) {
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
            List<MultiMediaData> list = this.f;
            if (list != null && list.size() > 0) {
                long j = ((float) this.f.get(0).start) / this.f.get(0).mSpeed;
                long j2 = ((float) this.f.get(0).end) / this.f.get(0).mSpeed;
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
                List<MultiMediaData> list = this.f;
                if (list != null && list.size() == 1) {
                    int i3 = (int) this.f.get(0).originalDuration;
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
                this.e.scrollToPositionWithOffset(i, i2);
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
            this.f = list;
            this.t = 0L;
            if (list != null) {
                if (L()) {
                    if (this.f.size() >= 1) {
                        this.t = ((float) this.f.get(0).originalDuration) / this.f.get(0).getCurrentSpeed();
                    }
                } else {
                    for (int i = 0; i < this.f.size(); i++) {
                        this.t += ((float) this.f.get(i).originalDuration) / this.f.get(i).getCurrentSpeed();
                    }
                }
            }
            if (this.t > 0) {
                J();
            }
            if (z && (videoClipAdapter = this.d) != null) {
                videoClipAdapter.g(this.u, this.g, this.m, this.n, this.q, UtilHelper.getDimenPixelSize(R.dimen.tbds130));
                if (vlogEditManager == null) {
                    return;
                }
                if (this.D >= 0) {
                    this.d.e((MultiMediaData) ListUtils.getItem(vlogEditManager.getInputMultiMediaData(), this.D), this.p);
                } else {
                    this.d.f(vlogEditManager, this.p);
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
            this.c.postDelayed(new e(this, i, i2), 100L);
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
                this.b.scrollToPosition(0);
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
