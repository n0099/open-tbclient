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
import c.a.d.f.m.e;
import c.a.d.f.p.n;
import c.a.v0.r.t;
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
import com.tachikoma.core.component.anim.AnimationProperty;
import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes6.dex */
public class MultiMediaEditLayout extends FrameLayout implements MultiMediaAdapter.a, View.OnClickListener, VideoClipLayout.g, c.a.p0.q4.n.c.e.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public ItemTouchHelper B;
    public boolean C;
    public boolean D;
    public Timer E;
    public RecyclerView a;

    /* renamed from: b  reason: collision with root package name */
    public MultiMediaAdapter f37134b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f37135c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f37136d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f37137e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f37138f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f37139g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f37140h;
    public SimpleDraweeView i;
    public int j;
    public VideoClipLayout k;
    public VideoClipLayout l;
    public c.a.p0.q4.n.c.a m;
    public View n;
    public int o;
    public long p;
    public long q;
    public int r;
    public int s;
    public int t;
    public int u;
    public float v;
    public boolean w;
    public boolean x;
    public int y;
    public int z;

    /* loaded from: classes6.dex */
    public class a extends RecyclerView.ItemDecoration {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MultiMediaEditLayout a;

        public a(MultiMediaEditLayout multiMediaEditLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {multiMediaEditLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = multiMediaEditLayout;
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
                MultiMediaEditLayout multiMediaEditLayout = this.a;
                if (!multiMediaEditLayout.D && !multiMediaEditLayout.C) {
                    rect.left = (int) t.i(R.dimen.obfuscated_res_0x7f070207);
                } else {
                    MultiMediaEditLayout multiMediaEditLayout2 = this.a;
                    if (multiMediaEditLayout2.D || multiMediaEditLayout2.C) {
                        if (this.a.y == 0) {
                            rect.left = ((int) t.i(R.dimen.obfuscated_res_0x7f070207)) + (this.a.z * ((int) t.i(R.dimen.obfuscated_res_0x7f07019a)));
                        } else if (this.a.A > this.a.y * ((int) t.i(R.dimen.obfuscated_res_0x7f07019c))) {
                            rect.left = ((((int) t.i(R.dimen.obfuscated_res_0x7f070207)) + this.a.A) - (this.a.y * ((int) t.i(R.dimen.obfuscated_res_0x7f07019c)))) + (this.a.z * ((int) t.i(R.dimen.obfuscated_res_0x7f07019a)));
                        }
                    }
                }
            } else {
                rect.left = -((int) t.i(R.dimen.obfuscated_res_0x7f0701f0));
            }
            if (childAdapterPosition == itemCount - 1) {
                MultiMediaEditLayout multiMediaEditLayout3 = this.a;
                if ((multiMediaEditLayout3.D || multiMediaEditLayout3.C) && this.a.y > 0 && n.k(this.a.getContext()) - this.a.A >= (this.a.f37134b.getItemCount() - this.a.y) * ((int) t.i(R.dimen.obfuscated_res_0x7f07019c))) {
                    rect.right = (n.k(this.a.getContext()) - this.a.A) - (((this.a.f37134b.getItemCount() - this.a.y) + this.a.z) * ((int) t.i(R.dimen.obfuscated_res_0x7f07019c)));
                } else {
                    rect.right = (int) t.i(R.dimen.obfuscated_res_0x7f070207);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ MultiMediaEditLayout f37141b;

        public b(MultiMediaEditLayout multiMediaEditLayout, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {multiMediaEditLayout, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f37141b = multiMediaEditLayout;
            this.a = z;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                this.f37141b.x = false;
                if (!this.a) {
                    this.f37141b.a.setVisibility(8);
                    this.f37141b.i.setAlpha(1.0f);
                    this.f37141b.i.setVisibility(0);
                } else if (this.f37141b.m != null) {
                    this.f37141b.m.a();
                }
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                super.onAnimationStart(animator);
                if (this.a) {
                    return;
                }
                this.f37141b.i.setAlpha(0.01f);
                this.f37141b.i.setVisibility(0);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MultiMediaEditLayout a;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

            public a(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    MultiMediaEditLayout multiMediaEditLayout = this.a.a;
                    if (multiMediaEditLayout.C) {
                        multiMediaEditLayout.D = true;
                        multiMediaEditLayout.C = false;
                        multiMediaEditLayout.f37134b.i(false);
                        MultiMediaEditLayout multiMediaEditLayout2 = this.a.a;
                        multiMediaEditLayout2.B.startDrag(multiMediaEditLayout2.a.findViewHolderForAdapterPosition(this.a.a.y));
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = multiMediaEditLayout;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
        c.a.p0.q4.n.c.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048576, this, f2) == null) || (aVar = this.m) == null) {
            return;
        }
        aVar.c(this.o + f2);
    }

    @Override // com.baidu.tieba.view.widget.mediaedit.VideoClipLayout.g
    public void b(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
            float f2 = (((float) j) * 1.0f) / 1000.0f;
            if (!r()) {
                if (f2 < 3.0f) {
                    this.f37140h.setTextColor(getResources().getColor(R.color.CAM_X0302));
                } else {
                    this.f37140h.setTextColor(getResources().getColor(R.color.CAM_X0201));
                }
                this.f37140h.setText(getResources().getString(R.string.obfuscated_res_0x7f0f145b, Float.valueOf(f2)));
                return;
            }
            this.f37140h.setText(getResources().getString(R.string.obfuscated_res_0x7f0f145e, Float.valueOf(f2)));
            this.f37140h.setTextColor(getResources().getColor(R.color.CAM_X0201));
        }
    }

    @Override // c.a.p0.q4.n.c.e.a
    public void c(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            u();
            this.m.f(i, i2);
        }
    }

    @Override // com.baidu.tieba.view.widget.mediaedit.VideoClipLayout.g
    public void d(int i, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048579, this, i, i2) == null) || this.m == null) {
            return;
        }
        if (r()) {
            long j = i;
            this.p = j;
            long j2 = i2;
            this.q = j2;
            this.m.n(j + this.o, j2);
            return;
        }
        this.r = i;
        this.s = i2;
        this.m.o(i, i2);
    }

    @Override // com.baidu.tieba.view.widget.mediaedit.adapter.MultiMediaAdapter.a
    public void e(int i, View view, c.a.p0.q4.n.c.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048580, this, i, view, aVar) == null) {
            this.w = true;
            this.f37137e.setVisibility(8);
            p(i, false);
            this.j = i;
            this.f37135c.setVisibility(0);
            this.l.setVisibility(0);
            this.k.setVisibility(8);
            this.f37139g.setVisibility(4);
            this.i.setImageURI(Uri.fromFile(new File(aVar.a().path)));
            c.a.p0.q4.n.c.a aVar2 = this.m;
            if (aVar2 != null) {
                aVar2.j(i, aVar);
            }
        }
    }

    @Override // c.a.p0.q4.n.c.e.a
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.C = true;
            this.f37134b.i(true);
        }
    }

    @Override // com.baidu.tieba.view.widget.mediaedit.VideoClipLayout.g
    public void g(double d2) {
        c.a.p0.q4.n.c.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Double.valueOf(d2)}) == null) || (aVar = this.m) == null) {
            return;
        }
        aVar.l(this.o + d2);
    }

    public int getAllClipFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.r : invokeV.intValue;
    }

    public int getAllClipTo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.s : invokeV.intValue;
    }

    public int getCurrentMediaPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.j : invokeV.intValue;
    }

    public int[] getRatioGuideTransPos() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            int[] iArr = new int[2];
            ImageView imageView = this.f37137e;
            if (imageView != null && imageView.getVisibility() == 0) {
                this.f37137e.getLocationOnScreen(iArr);
                iArr[0] = iArr[0] + (this.f37137e.getWidth() >> 1);
            }
            return iArr;
        }
        return (int[]) invokeV.objValue;
    }

    public long getSingleClipFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.p : invokeV.longValue;
    }

    public long getSingleClipTo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.q : invokeV.longValue;
    }

    public int getSingleMediaStartDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.o : invokeV.intValue;
    }

    public int getSingleRotation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.u : invokeV.intValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        c.a.p0.q4.n.c.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, view) == null) {
            if (view == this.f37135c) {
                c.a.p0.q4.n.c.a aVar2 = this.m;
                if (aVar2 != null) {
                    aVar2.d(this.j);
                }
            } else if (view == this.f37136d) {
                if (this.m != null) {
                    if (r()) {
                        if (this.t == 0) {
                            this.t = 360;
                        }
                        int i = this.t;
                        int i2 = i - 90;
                        this.t = i2;
                        this.m.g(this.j, i, i2);
                    } else {
                        if (this.u == 0) {
                            this.u = 360;
                        }
                        int i3 = this.u;
                        int i4 = i3 - 90;
                        this.u = i4;
                        this.m.e(i3, i4);
                    }
                }
            } else if (view == this.f37138f) {
                c.a.p0.q4.n.c.a aVar3 = this.m;
                if (aVar3 != null) {
                    aVar3.m();
                }
            } else if (view == this.f37137e && (aVar = this.m) != null) {
                aVar.k();
            }
            c.a.p0.q4.n.c.a aVar4 = this.m;
            if (aVar4 != null) {
                aVar4.onClick();
            }
        }
    }

    @Override // com.baidu.tieba.view.widget.mediaedit.VideoClipLayout.g
    public void onPause() {
        c.a.p0.q4.n.c.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (aVar = this.m) == null) {
            return;
        }
        aVar.i();
    }

    @Override // com.baidu.tieba.view.widget.mediaedit.VideoClipLayout.g
    public void onSeekTo(long j) {
        c.a.p0.q4.n.c.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048593, this, j) == null) || (aVar = this.m) == null) {
            return;
        }
        aVar.b(this.o + j);
    }

    @Override // com.baidu.tieba.view.widget.mediaedit.VideoClipLayout.g
    public void onStart() {
        c.a.p0.q4.n.c.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (aVar = this.m) == null) {
            return;
        }
        aVar.h();
    }

    public final void p(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < this.a.getChildCount(); i2++) {
                View childAt = this.a.getChildAt(i2);
                if (childAt != null) {
                    int childAdapterPosition = this.a.getChildAdapterPosition(childAt);
                    if (childAdapterPosition > i) {
                        float k = n.k(getContext());
                        if (z) {
                            arrayList.add(ObjectAnimator.ofFloat(childAt, AnimationProperty.TRANSLATE_X, k, 0.0f));
                        } else {
                            arrayList.add(ObjectAnimator.ofFloat(childAt, AnimationProperty.TRANSLATE_X, 0.0f, k));
                        }
                    } else if (childAdapterPosition < i) {
                        float f2 = -n.k(getContext());
                        if (z) {
                            arrayList.add(ObjectAnimator.ofFloat(childAt, AnimationProperty.TRANSLATE_X, f2, 0.0f));
                        } else {
                            arrayList.add(ObjectAnimator.ofFloat(childAt, AnimationProperty.TRANSLATE_X, 0.0f, f2));
                        }
                    } else {
                        if (!z) {
                            this.v = this.i.getX() - childAt.getX();
                        }
                        if (z) {
                            arrayList.add(ObjectAnimator.ofFloat(childAt, AnimationProperty.TRANSLATE_X, this.v, 0.0f));
                        } else {
                            arrayList.add(ObjectAnimator.ofFloat(childAt, AnimationProperty.TRANSLATE_X, 0.0f, this.v));
                        }
                    }
                }
            }
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.addListener(new b(this, z));
            this.x = true;
            animatorSet.setDuration(500L);
            animatorSet.playTogether(arrayList);
            animatorSet.start();
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.f37137e.setVisibility(0);
        }
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.w : invokeV.booleanValue;
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            VideoClipLayout videoClipLayout = this.l;
            if (videoClipLayout != null) {
                videoClipLayout.O();
            }
            VideoClipLayout videoClipLayout2 = this.k;
            if (videoClipLayout2 != null) {
                videoClipLayout2.O();
            }
        }
    }

    @Override // c.a.p0.q4.n.c.e.a
    public void setDragMode(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048599, this, i, i2) == null) {
            if (i < 0) {
                if (this.C) {
                    return;
                }
                this.D = false;
                return;
            }
            this.y = i;
            if (this.D) {
                return;
            }
            this.A = i2;
            try {
                Field declaredField = this.B.getClass().getDeclaredField("mInitialTouchX");
                declaredField.setAccessible(true);
                this.z = ((((int) ((Float) declaredField.get(this.B)).floatValue()) - this.A) - ((int) t.i(R.dimen.obfuscated_res_0x7f070207))) / ((int) t.i(R.dimen.obfuscated_res_0x7f07019a));
                this.f37134b.notifyDataSetChanged();
                int k = n.k(getContext());
                if (this.A + (this.z * ((int) t.i(R.dimen.obfuscated_res_0x7f07019a))) > this.y * ((int) t.i(R.dimen.obfuscated_res_0x7f07019c))) {
                    this.a.scrollToPosition(i);
                    this.a.smoothScrollBy((-this.z) * ((int) t.i(R.dimen.obfuscated_res_0x7f07019a)), 0);
                }
                if (this.A < this.y * ((int) t.i(R.dimen.obfuscated_res_0x7f07019c)) && k - this.A < (this.f37134b.getItemCount() - this.y) * ((int) t.i(R.dimen.obfuscated_res_0x7f07019a))) {
                    this.a.scrollToPosition(i);
                    this.a.smoothScrollBy((-this.z) * ((int) t.i(R.dimen.obfuscated_res_0x7f07019a)), 0);
                }
                if (this.E == null) {
                    this.E = new Timer();
                }
                this.E.schedule(new c(this), 300L);
            } catch (Exception unused) {
            }
        }
    }

    public void setIMultiMediaEditView(c.a.p0.q4.n.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, aVar) == null) {
            this.m = aVar;
        }
    }

    public void setIsCortoon(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            VideoClipLayout videoClipLayout = this.k;
            if (videoClipLayout != null) {
                videoClipLayout.setIsCortoon(z);
            }
            q();
        }
    }

    public void setIsShowSpeedChanger(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
            this.f37138f.setSelected(z);
        }
    }

    public void setLocalAlbumInfoData(VlogEditManager vlogEditManager, List<MultiMediaData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048603, this, vlogEditManager, list) == null) {
            setLocalAlbumInfoData(vlogEditManager, list, true);
        }
    }

    public void setMultiVideoClipLayoutRange(int i, int i2) {
        VideoClipLayout videoClipLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048605, this, i, i2) == null) || (videoClipLayout = this.k) == null) {
            return;
        }
        videoClipLayout.setRange(i, i2);
    }

    public void setOnlyClip(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048606, this, z) == null) {
            this.f37137e.setVisibility(z ? 8 : 0);
            this.f37138f.setVisibility(z ? 8 : 0);
            this.f37136d.setVisibility(z ? 8 : 0);
        }
    }

    public void setOnlyOneVideo() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            this.n.setVisibility(8);
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
            this.p = j;
        }
    }

    public void setSingleClipTo(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048610, this, j) == null) {
            this.q = j;
        }
    }

    public void setSingleMediaAlbumInfoData(VlogEditManager vlogEditManager, List<MultiMediaData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048611, this, vlogEditManager, list) == null) {
            setSingleMediaAlbumInfoData(vlogEditManager, list, true);
        }
    }

    public void setSingleMediaStartDuration(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048613, this, i) == null) {
            this.o = i;
        }
    }

    public void setSingleRotation(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048614, this, i) == null) {
            this.t = i;
        }
    }

    public void setSpeedBtnVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048615, this, z) == null) {
            this.f37138f.setVisibility(z ? 0 : 8);
        }
    }

    public void t() {
        VideoClipLayout videoClipLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048616, this) == null) || (videoClipLayout = this.k) == null) {
            return;
        }
        videoClipLayout.P();
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            for (c.a.p0.q4.n.c.c.a aVar : this.f37134b.e()) {
                aVar.c(false);
            }
            this.f37134b.e().get(0).c(true);
        }
    }

    public void v(int i, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048618, this, i, i2) == null) || this.x || this.w) {
            return;
        }
        if (i == -1) {
            for (c.a.p0.q4.n.c.c.a aVar : this.f37134b.e()) {
                aVar.c(false);
            }
            this.f37134b.notifyDataSetChanged();
        }
        c.a.p0.q4.n.c.c.a aVar2 = (c.a.p0.q4.n.c.c.a) ListUtils.getItem(this.f37134b.e(), i);
        if (aVar2 != null) {
            aVar2.c(false);
            this.f37134b.notifyItemChanged(i, aVar2);
        }
        c.a.p0.q4.n.c.c.a aVar3 = (c.a.p0.q4.n.c.c.a) ListUtils.getItem(this.f37134b.e(), i2);
        if (aVar3 != null) {
            aVar3.c(true);
            this.f37134b.notifyItemChanged(i2, aVar3);
        }
    }

    public void w(boolean z) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048619, this, z) == null) || (imageView = this.f37137e) == null) {
            return;
        }
        if (z) {
            imageView.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809bb, getResources().getColor(R.color.CAM_X0302), null));
        } else {
            imageView.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f0809bb));
        }
    }

    public void x(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048620, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || this.f37138f == null) {
            return;
        }
        int i = R.drawable.obfuscated_res_0x7f0809a2;
        if (z) {
            i = R.drawable.obfuscated_res_0x7f0809a3;
        }
        if (z2) {
            this.f37138f.setImageDrawable(WebPManager.getPureDrawable(i, getResources().getColor(R.color.CAM_X0302), null));
        } else {
            this.f37138f.setImageDrawable(getResources().getDrawable(i));
        }
    }

    public void y(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048621, this, j) == null) {
            VideoClipLayout videoClipLayout = this.l;
            if (videoClipLayout != null) {
                videoClipLayout.C((int) j);
            }
            VideoClipLayout videoClipLayout2 = this.k;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
        if (!(interceptable == null || interceptable.invokeLLZ(1048604, this, vlogEditManager, list, z) == null) || this.k == null) {
            return;
        }
        if (list.size() == 1) {
            this.k.setMediaIndex(0);
        } else {
            this.k.setMediaIndex(-1);
        }
        this.k.setLocalAlbumInfoData(vlogEditManager, list, z);
    }

    public void setSingleMediaAlbumInfoData(VlogEditManager vlogEditManager, List<MultiMediaData> list, boolean z) {
        VideoClipLayout videoClipLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(1048612, this, vlogEditManager, list, z) == null) || (videoClipLayout = this.l) == null) {
            return;
        }
        if (vlogEditManager != null) {
            videoClipLayout.setMediaIndex(this.j);
        }
        this.l.setLocalAlbumInfoData(vlogEditManager, list, z);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiMediaEditLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.o = 0;
        this.t = 360;
        this.v = 0.0f;
        this.w = false;
        this.x = false;
        this.y = -1;
        this.z = 0;
        this.A = 0;
        this.C = false;
        this.D = false;
        FrameLayout.inflate(context, R.layout.obfuscated_res_0x7f0d04a4, this);
        this.a = (RecyclerView) findViewById(R.id.obfuscated_res_0x7f091481);
        this.f37135c = (ImageView) findViewById(R.id.obfuscated_res_0x7f090eb0);
        this.f37136d = (ImageView) findViewById(R.id.obfuscated_res_0x7f090ed2);
        this.f37138f = (ImageView) findViewById(R.id.obfuscated_res_0x7f090ea8);
        this.k = (VideoClipLayout) findViewById(R.id.obfuscated_res_0x7f091476);
        this.l = (VideoClipLayout) findViewById(R.id.obfuscated_res_0x7f091d25);
        this.f37139g = (TextView) findViewById(R.id.obfuscated_res_0x7f0921a5);
        this.f37140h = (TextView) findViewById(R.id.obfuscated_res_0x7f092206);
        this.i = (SimpleDraweeView) findViewById(R.id.obfuscated_res_0x7f090e80);
        ImageView imageView = (ImageView) findViewById(R.id.obfuscated_res_0x7f090ea7);
        this.f37137e = imageView;
        imageView.setOnClickListener(this);
        GenericDraweeHierarchy hierarchy = this.i.getHierarchy();
        hierarchy.setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP);
        RoundingParams roundingParams = hierarchy.getRoundingParams();
        roundingParams = roundingParams == null ? new RoundingParams() : roundingParams;
        roundingParams.setCornersRadius(UtilHelper.getDimenPixelSize(R.dimen.tbds3));
        hierarchy.setRoundingParams(roundingParams);
        this.n = findViewById(R.id.obfuscated_res_0x7f0911eb);
        MultiMediaAdapter multiMediaAdapter = new MultiMediaAdapter();
        this.f37134b = multiMediaAdapter;
        multiMediaAdapter.j(this);
        this.a.setAdapter(this.f37134b);
        this.a.setHasFixedSize(true);
        this.a.setLayoutManager(new LinearLayoutManager(context, 0, false));
        this.a.addItemDecoration(new a(this));
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new DragMultiMediaItemCallback(" ", "", this.f37134b, this));
        this.B = itemTouchHelper;
        itemTouchHelper.attachToRecyclerView(this.a);
        this.f37135c.setOnClickListener(this);
        this.f37136d.setOnClickListener(this);
        this.f37138f.setOnClickListener(this);
        this.k.setVideoClipListener(this);
        this.l.setVideoClipListener(this);
    }
}
