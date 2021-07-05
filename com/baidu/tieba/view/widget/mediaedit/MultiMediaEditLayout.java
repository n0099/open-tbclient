package com.baidu.tieba.view.widget.mediaedit;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import com.baidu.tieba.view.widget.mediaedit.VideoClipLayout;
import com.baidu.tieba.view.widget.mediaedit.adapter.MultiMediaAdapter;
import com.baidu.tieba.view.widget.mediaedit.listener.DragMultiMediaItemCallback;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.data.MultiMediaData;
import com.baidu.ugc.editvideo.record.source.multimedia.VlogEditManager;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.RoundingParams;
import d.a.c.e.m.e;
import d.a.c.e.p.l;
import d.a.y0.t.t;
import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes5.dex */
public class MultiMediaEditLayout extends FrameLayout implements MultiMediaAdapter.a, View.OnClickListener, VideoClipLayout.g, d.a.s0.z3.m.c.e.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public boolean B;
    public int C;
    public int D;
    public int E;
    public ItemTouchHelper F;
    public boolean G;
    public boolean H;
    public Timer I;

    /* renamed from: e  reason: collision with root package name */
    public RecyclerView f22334e;

    /* renamed from: f  reason: collision with root package name */
    public MultiMediaAdapter f22335f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f22336g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f22337h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f22338i;
    public ImageView j;
    public TextView k;
    public TextView l;
    public SimpleDraweeView m;
    public int n;
    public VideoClipLayout o;
    public VideoClipLayout p;
    public d.a.s0.z3.m.c.a q;
    public View r;
    public int s;
    public long t;
    public long u;
    public int v;
    public int w;
    public int x;
    public int y;
    public float z;

    /* loaded from: classes5.dex */
    public class a extends RecyclerView.ItemDecoration {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MultiMediaEditLayout f22339a;

        public a(MultiMediaEditLayout multiMediaEditLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {multiMediaEditLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22339a = multiMediaEditLayout;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLLL(1048576, this, rect, view, recyclerView, state) == null) || recyclerView == null) {
                return;
            }
            int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
            int itemCount = recyclerView.getAdapter() != null ? recyclerView.getAdapter().getItemCount() : 0;
            if (childAdapterPosition == 0) {
                MultiMediaEditLayout multiMediaEditLayout = this.f22339a;
                if (!multiMediaEditLayout.H && !multiMediaEditLayout.G) {
                    rect.left = (int) t.i(R.dimen.ds32);
                } else {
                    MultiMediaEditLayout multiMediaEditLayout2 = this.f22339a;
                    if (multiMediaEditLayout2.H || multiMediaEditLayout2.G) {
                        if (this.f22339a.C == 0) {
                            rect.left = ((int) t.i(R.dimen.ds32)) + (this.f22339a.D * ((int) t.i(R.dimen.ds100)));
                        } else if (this.f22339a.E > this.f22339a.C * ((int) t.i(R.dimen.ds104))) {
                            rect.left = ((((int) t.i(R.dimen.ds32)) + this.f22339a.E) - (this.f22339a.C * ((int) t.i(R.dimen.ds104)))) + (this.f22339a.D * ((int) t.i(R.dimen.ds100)));
                        }
                    }
                }
            } else {
                rect.left = -((int) t.i(R.dimen.ds26));
            }
            if (childAdapterPosition == itemCount - 1) {
                MultiMediaEditLayout multiMediaEditLayout3 = this.f22339a;
                if ((multiMediaEditLayout3.H || multiMediaEditLayout3.G) && this.f22339a.C > 0 && l.k(this.f22339a.getContext()) - this.f22339a.E >= (this.f22339a.f22335f.getItemCount() - this.f22339a.C) * ((int) t.i(R.dimen.ds104))) {
                    rect.right = (l.k(this.f22339a.getContext()) - this.f22339a.E) - (((this.f22339a.f22335f.getItemCount() - this.f22339a.C) + this.f22339a.D) * ((int) t.i(R.dimen.ds104)));
                } else {
                    rect.right = (int) t.i(R.dimen.ds32);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f22340e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ MultiMediaEditLayout f22341f;

        public b(MultiMediaEditLayout multiMediaEditLayout, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {multiMediaEditLayout, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22341f = multiMediaEditLayout;
            this.f22340e = z;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                this.f22341f.B = false;
                if (!this.f22340e) {
                    this.f22341f.f22334e.setVisibility(8);
                    this.f22341f.m.setAlpha(1.0f);
                    this.f22341f.m.setVisibility(0);
                } else if (this.f22341f.q != null) {
                    this.f22341f.q.a();
                }
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                super.onAnimationStart(animator);
                if (this.f22340e) {
                    return;
                }
                this.f22341f.m.setAlpha(0.01f);
                this.f22341f.m.setVisibility(0);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MultiMediaEditLayout f22342e;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f22343e;

            public a(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f22343e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    MultiMediaEditLayout multiMediaEditLayout = this.f22343e.f22342e;
                    if (multiMediaEditLayout.G) {
                        multiMediaEditLayout.H = true;
                        multiMediaEditLayout.G = false;
                        multiMediaEditLayout.f22335f.r(false);
                        MultiMediaEditLayout multiMediaEditLayout2 = this.f22343e.f22342e;
                        multiMediaEditLayout2.F.startDrag(multiMediaEditLayout2.f22334e.findViewHolderForAdapterPosition(this.f22343e.f22342e.C));
                    }
                }
            }
        }

        public c(MultiMediaEditLayout multiMediaEditLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {multiMediaEditLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22342e = multiMediaEditLayout;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                e.a().post(new a(this));
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MultiMediaEditLayout(@NonNull Context context) {
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

    @Override // com.baidu.tieba.view.widget.mediaedit.VideoClipLayout.g
    public void a(float f2) {
        d.a.s0.z3.m.c.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048576, this, f2) == null) || (aVar = this.q) == null) {
            return;
        }
        aVar.c(this.s + f2);
    }

    @Override // com.baidu.tieba.view.widget.mediaedit.VideoClipLayout.g
    public void b(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
            float f2 = (((float) j) * 1.0f) / 1000.0f;
            if (!r()) {
                if (f2 < 3.0f) {
                    this.l.setTextColor(getResources().getColor(R.color.CAM_X0302));
                } else {
                    this.l.setTextColor(getResources().getColor(R.color.CAM_X0201));
                }
                this.l.setText(getResources().getString(R.string.ugc_all_select_time, Float.valueOf(f2)));
                return;
            }
            this.l.setText(getResources().getString(R.string.ugc_single_select_time, Float.valueOf(f2)));
            this.l.setTextColor(getResources().getColor(R.color.CAM_X0201));
        }
    }

    @Override // d.a.s0.z3.m.c.e.a
    public void c(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
            u();
            this.q.f(i2, i3);
        }
    }

    @Override // com.baidu.tieba.view.widget.mediaedit.VideoClipLayout.g
    public void d(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048579, this, i2, i3) == null) || this.q == null) {
            return;
        }
        if (r()) {
            long j = i2;
            this.t = j;
            long j2 = i3;
            this.u = j2;
            this.q.n(j + this.s, j2);
            return;
        }
        this.v = i2;
        this.w = i3;
        this.q.o(i2, i3);
    }

    @Override // com.baidu.tieba.view.widget.mediaedit.adapter.MultiMediaAdapter.a
    public void e(int i2, View view, d.a.s0.z3.m.c.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048580, this, i2, view, aVar) == null) {
            this.A = true;
            this.f22338i.setVisibility(8);
            p(i2, false);
            this.n = i2;
            this.f22336g.setVisibility(0);
            this.p.setVisibility(0);
            this.o.setVisibility(8);
            this.k.setVisibility(4);
            this.m.setImageURI(Uri.fromFile(new File(aVar.a().path)));
            d.a.s0.z3.m.c.a aVar2 = this.q;
            if (aVar2 != null) {
                aVar2.j(i2, aVar);
            }
        }
    }

    @Override // d.a.s0.z3.m.c.e.a
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.G = true;
            this.f22335f.r(true);
        }
    }

    @Override // com.baidu.tieba.view.widget.mediaedit.VideoClipLayout.g
    public void g(double d2) {
        d.a.s0.z3.m.c.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Double.valueOf(d2)}) == null) || (aVar = this.q) == null) {
            return;
        }
        aVar.l(this.s + d2);
    }

    public int getAllClipFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.v : invokeV.intValue;
    }

    public int getAllClipTo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.w : invokeV.intValue;
    }

    public int getCurrentMediaPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.n : invokeV.intValue;
    }

    public int[] getRatioGuideTransPos() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            int[] iArr = new int[2];
            ImageView imageView = this.f22338i;
            if (imageView != null && imageView.getVisibility() == 0) {
                this.f22338i.getLocationOnScreen(iArr);
                iArr[0] = iArr[0] + (this.f22338i.getWidth() >> 1);
            }
            return iArr;
        }
        return (int[]) invokeV.objValue;
    }

    public long getSingleClipFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.t : invokeV.longValue;
    }

    public long getSingleClipTo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.u : invokeV.longValue;
    }

    public int getSingleMediaStartDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.s : invokeV.intValue;
    }

    public int getSingleRotation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.y : invokeV.intValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        d.a.s0.z3.m.c.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, view) == null) {
            if (view == this.f22336g) {
                d.a.s0.z3.m.c.a aVar2 = this.q;
                if (aVar2 != null) {
                    aVar2.d(this.n);
                }
            } else if (view == this.f22337h) {
                if (this.q != null) {
                    if (r()) {
                        if (this.x == 0) {
                            this.x = 360;
                        }
                        int i2 = this.x;
                        int i3 = i2 - 90;
                        this.x = i3;
                        this.q.g(this.n, i2, i3);
                    } else {
                        if (this.y == 0) {
                            this.y = 360;
                        }
                        int i4 = this.y;
                        int i5 = i4 - 90;
                        this.y = i5;
                        this.q.e(i4, i5);
                    }
                }
            } else if (view == this.j) {
                d.a.s0.z3.m.c.a aVar3 = this.q;
                if (aVar3 != null) {
                    aVar3.m();
                }
            } else if (view == this.f22338i && (aVar = this.q) != null) {
                aVar.k();
            }
            d.a.s0.z3.m.c.a aVar4 = this.q;
            if (aVar4 != null) {
                aVar4.onClick();
            }
        }
    }

    @Override // com.baidu.tieba.view.widget.mediaedit.VideoClipLayout.g
    public void onPause() {
        d.a.s0.z3.m.c.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (aVar = this.q) == null) {
            return;
        }
        aVar.i();
    }

    @Override // com.baidu.tieba.view.widget.mediaedit.VideoClipLayout.g
    public void onSeekTo(long j) {
        d.a.s0.z3.m.c.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048593, this, j) == null) || (aVar = this.q) == null) {
            return;
        }
        aVar.b(this.s + j);
    }

    @Override // com.baidu.tieba.view.widget.mediaedit.VideoClipLayout.g
    public void onStart() {
        d.a.s0.z3.m.c.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (aVar = this.q) == null) {
            return;
        }
        aVar.h();
    }

    public final void p(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < this.f22334e.getChildCount(); i3++) {
                View childAt = this.f22334e.getChildAt(i3);
                if (childAt != null) {
                    int childAdapterPosition = this.f22334e.getChildAdapterPosition(childAt);
                    if (childAdapterPosition > i2) {
                        float k = l.k(getContext());
                        if (z) {
                            arrayList.add(ObjectAnimator.ofFloat(childAt, "translationX", k, 0.0f));
                        } else {
                            arrayList.add(ObjectAnimator.ofFloat(childAt, "translationX", 0.0f, k));
                        }
                    } else if (childAdapterPosition < i2) {
                        float f2 = -l.k(getContext());
                        if (z) {
                            arrayList.add(ObjectAnimator.ofFloat(childAt, "translationX", f2, 0.0f));
                        } else {
                            arrayList.add(ObjectAnimator.ofFloat(childAt, "translationX", 0.0f, f2));
                        }
                    } else {
                        if (!z) {
                            this.z = this.m.getX() - childAt.getX();
                        }
                        if (z) {
                            arrayList.add(ObjectAnimator.ofFloat(childAt, "translationX", this.z, 0.0f));
                        } else {
                            arrayList.add(ObjectAnimator.ofFloat(childAt, "translationX", 0.0f, this.z));
                        }
                    }
                }
            }
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.addListener(new b(this, z));
            this.B = true;
            animatorSet.setDuration(500L);
            animatorSet.playTogether(arrayList);
            animatorSet.start();
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.f22338i.setVisibility(0);
        }
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.A : invokeV.booleanValue;
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            VideoClipLayout videoClipLayout = this.p;
            if (videoClipLayout != null) {
                videoClipLayout.O();
            }
            VideoClipLayout videoClipLayout2 = this.o;
            if (videoClipLayout2 != null) {
                videoClipLayout2.O();
            }
        }
    }

    @Override // d.a.s0.z3.m.c.e.a
    public void setDragMode(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048599, this, i2, i3) == null) {
            if (i2 < 0) {
                if (this.G) {
                    return;
                }
                this.H = false;
                return;
            }
            this.C = i2;
            if (this.H) {
                return;
            }
            this.E = i3;
            try {
                Field declaredField = this.F.getClass().getDeclaredField("mInitialTouchX");
                declaredField.setAccessible(true);
                this.D = ((((int) ((Float) declaredField.get(this.F)).floatValue()) - this.E) - ((int) t.i(R.dimen.ds32))) / ((int) t.i(R.dimen.ds100));
                this.f22335f.notifyDataSetChanged();
                int k = l.k(getContext());
                if (this.E + (this.D * ((int) t.i(R.dimen.ds100))) > this.C * ((int) t.i(R.dimen.ds104))) {
                    this.f22334e.scrollToPosition(i2);
                    this.f22334e.smoothScrollBy((-this.D) * ((int) t.i(R.dimen.ds100)), 0);
                }
                if (this.E < this.C * ((int) t.i(R.dimen.ds104)) && k - this.E < (this.f22335f.getItemCount() - this.C) * ((int) t.i(R.dimen.ds100))) {
                    this.f22334e.scrollToPosition(i2);
                    this.f22334e.smoothScrollBy((-this.D) * ((int) t.i(R.dimen.ds100)), 0);
                }
                if (this.I == null) {
                    this.I = new Timer();
                }
                this.I.schedule(new c(this), 300L);
            } catch (Exception unused) {
            }
        }
    }

    public void setIMultiMediaEditView(d.a.s0.z3.m.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, aVar) == null) {
            this.q = aVar;
        }
    }

    public void setIsCortoon(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            VideoClipLayout videoClipLayout = this.o;
            if (videoClipLayout != null) {
                videoClipLayout.setIsCortoon(z);
            }
            q();
        }
    }

    public void setIsShowSpeedChanger(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
            this.j.setSelected(z);
        }
    }

    public void setLocalAlbumInfoData(VlogEditManager vlogEditManager, List<MultiMediaData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048603, this, vlogEditManager, list) == null) {
            setLocalAlbumInfoData(vlogEditManager, list, true);
        }
    }

    public void setMultiVideoClipLayoutRange(int i2, int i3) {
        VideoClipLayout videoClipLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048605, this, i2, i3) == null) || (videoClipLayout = this.o) == null) {
            return;
        }
        videoClipLayout.setRange(i2, i3);
    }

    public void setOnlyClip(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048606, this, z) == null) {
            this.f22338i.setVisibility(z ? 8 : 0);
            this.j.setVisibility(z ? 8 : 0);
            this.f22337h.setVisibility(z ? 8 : 0);
        }
    }

    public void setOnlyOneVideo() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            this.r.setVisibility(8);
        }
    }

    public void setPageContext(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, tbPageContext) == null) {
        }
    }

    public void setSingleClipFrom(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048609, this, j) == null) {
            this.t = j;
        }
    }

    public void setSingleClipTo(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048610, this, j) == null) {
            this.u = j;
        }
    }

    public void setSingleMediaAlbumInfoData(VlogEditManager vlogEditManager, List<MultiMediaData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048611, this, vlogEditManager, list) == null) {
            setSingleMediaAlbumInfoData(vlogEditManager, list, true);
        }
    }

    public void setSingleMediaStartDuration(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048613, this, i2) == null) {
            this.s = i2;
        }
    }

    public void setSingleRotation(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048614, this, i2) == null) {
            this.x = i2;
        }
    }

    public void setSpeedBtnVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048615, this, z) == null) {
            this.j.setVisibility(z ? 0 : 8);
        }
    }

    public void t() {
        VideoClipLayout videoClipLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048616, this) == null) || (videoClipLayout = this.o) == null) {
            return;
        }
        videoClipLayout.P();
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            for (d.a.s0.z3.m.c.c.a aVar : this.f22335f.n()) {
                aVar.d(false);
            }
            this.f22335f.n().get(0).d(true);
        }
    }

    public void v(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048618, this, i2, i3) == null) || this.B || this.A) {
            return;
        }
        if (i2 == -1) {
            for (d.a.s0.z3.m.c.c.a aVar : this.f22335f.n()) {
                aVar.d(false);
            }
            this.f22335f.notifyDataSetChanged();
        }
        d.a.s0.z3.m.c.c.a aVar2 = (d.a.s0.z3.m.c.c.a) ListUtils.getItem(this.f22335f.n(), i2);
        if (aVar2 != null) {
            aVar2.d(false);
            this.f22335f.notifyItemChanged(i2, aVar2);
        }
        d.a.s0.z3.m.c.c.a aVar3 = (d.a.s0.z3.m.c.c.a) ListUtils.getItem(this.f22335f.n(), i3);
        if (aVar3 != null) {
            aVar3.d(true);
            this.f22335f.notifyItemChanged(i3, aVar3);
        }
    }

    public void w(boolean z) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048619, this, z) == null) || (imageView = this.f22338i) == null) {
            return;
        }
        if (z) {
            imageView.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_topbar_pingmubili44, getResources().getColor(R.color.CAM_X0302), null));
        } else {
            imageView.setImageDrawable(getResources().getDrawable(R.drawable.icon_pure_topbar_pingmubili44));
        }
    }

    public void x(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048620, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || this.j == null) {
            return;
        }
        int i2 = R.drawable.icon_pure_topbar_biansu_off44;
        if (z) {
            i2 = R.drawable.icon_pure_topbar_biansu_on44;
        }
        if (z2) {
            this.j.setImageDrawable(WebPManager.getPureDrawable(i2, getResources().getColor(R.color.CAM_X0302), null));
        } else {
            this.j.setImageDrawable(getResources().getDrawable(i2));
        }
    }

    public void y(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048621, this, j) == null) {
            VideoClipLayout videoClipLayout = this.p;
            if (videoClipLayout != null) {
                videoClipLayout.C((int) j);
            }
            VideoClipLayout videoClipLayout2 = this.o;
            if (videoClipLayout2 != null) {
                videoClipLayout2.C((int) j);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MultiMediaEditLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
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
    }

    public void setLocalAlbumInfoData(VlogEditManager vlogEditManager, List<MultiMediaData> list, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(1048604, this, vlogEditManager, list, z) == null) || this.o == null) {
            return;
        }
        if (list.size() == 1) {
            this.o.setMediaIndex(0);
        } else {
            this.o.setMediaIndex(-1);
        }
        this.o.setLocalAlbumInfoData(vlogEditManager, list, z);
    }

    public void setSingleMediaAlbumInfoData(VlogEditManager vlogEditManager, List<MultiMediaData> list, boolean z) {
        VideoClipLayout videoClipLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(1048612, this, vlogEditManager, list, z) == null) || (videoClipLayout = this.p) == null) {
            return;
        }
        if (vlogEditManager != null) {
            videoClipLayout.setMediaIndex(this.n);
        }
        this.p.setLocalAlbumInfoData(vlogEditManager, list, z);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiMediaEditLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
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
        this.s = 0;
        this.x = 360;
        this.z = 0.0f;
        this.A = false;
        this.B = false;
        this.C = -1;
        this.D = 0;
        this.E = 0;
        this.G = false;
        this.H = false;
        FrameLayout.inflate(context, R.layout.layout_multi_media_edit, this);
        this.f22334e = (RecyclerView) findViewById(R.id.multi_media_recycler_view);
        this.f22336g = (ImageView) findViewById(R.id.img_delete_media);
        this.f22337h = (ImageView) findViewById(R.id.img_rotation_media);
        this.j = (ImageView) findViewById(R.id.img_change_speed);
        this.o = (VideoClipLayout) findViewById(R.id.multiVideoClipLayout);
        this.p = (VideoClipLayout) findViewById(R.id.singleVideoClipLayout);
        this.k = (TextView) findViewById(R.id.tv_edit_tip);
        this.l = (TextView) findViewById(R.id.tv_select_total_time);
        this.m = (SimpleDraweeView) findViewById(R.id.image_single_media);
        ImageView imageView = (ImageView) findViewById(R.id.img_change_resolution);
        this.f22338i = imageView;
        imageView.setOnClickListener(this);
        GenericDraweeHierarchy hierarchy = this.m.getHierarchy();
        hierarchy.setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP);
        RoundingParams roundingParams = hierarchy.getRoundingParams();
        roundingParams = roundingParams == null ? new RoundingParams() : roundingParams;
        roundingParams.setCornersRadius(UtilHelper.getDimenPixelSize(R.dimen.tbds3));
        hierarchy.setRoundingParams(roundingParams);
        this.r = findViewById(R.id.layout_medias);
        MultiMediaAdapter multiMediaAdapter = new MultiMediaAdapter();
        this.f22335f = multiMediaAdapter;
        multiMediaAdapter.s(this);
        this.f22334e.setAdapter(this.f22335f);
        this.f22334e.setHasFixedSize(true);
        this.f22334e.setLayoutManager(new LinearLayoutManager(context, 0, false));
        this.f22334e.addItemDecoration(new a(this));
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new DragMultiMediaItemCallback(" ", "", this.f22335f, this));
        this.F = itemTouchHelper;
        itemTouchHelper.attachToRecyclerView(this.f22334e);
        this.f22336g.setOnClickListener(this);
        this.f22337h.setOnClickListener(this);
        this.j.setOnClickListener(this);
        this.o.setVideoClipListener(this);
        this.p.setVideoClipListener(this);
    }
}
