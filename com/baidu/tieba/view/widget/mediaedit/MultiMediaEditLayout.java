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
import c.a.e.e.m.e;
import c.a.e.e.p.l;
import c.a.x0.t.t;
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
import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes7.dex */
public class MultiMediaEditLayout extends FrameLayout implements MultiMediaAdapter.a, View.OnClickListener, VideoClipLayout.g, c.a.r0.b4.l.c.e.a {
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
    public RecyclerView f58559e;

    /* renamed from: f  reason: collision with root package name */
    public MultiMediaAdapter f58560f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f58561g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f58562h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f58563i;

    /* renamed from: j  reason: collision with root package name */
    public ImageView f58564j;
    public TextView k;
    public TextView l;
    public SimpleDraweeView m;
    public int n;
    public VideoClipLayout o;
    public VideoClipLayout p;
    public c.a.r0.b4.l.c.a q;
    public View r;
    public int s;
    public long t;
    public long u;
    public int v;
    public int w;
    public int x;
    public int y;
    public float z;

    /* loaded from: classes7.dex */
    public class a extends RecyclerView.ItemDecoration {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MultiMediaEditLayout f58565a;

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
            this.f58565a = multiMediaEditLayout;
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
                MultiMediaEditLayout multiMediaEditLayout = this.f58565a;
                if (!multiMediaEditLayout.H && !multiMediaEditLayout.G) {
                    rect.left = (int) t.i(R.dimen.ds32);
                } else {
                    MultiMediaEditLayout multiMediaEditLayout2 = this.f58565a;
                    if (multiMediaEditLayout2.H || multiMediaEditLayout2.G) {
                        if (this.f58565a.C == 0) {
                            rect.left = ((int) t.i(R.dimen.ds32)) + (this.f58565a.D * ((int) t.i(R.dimen.ds100)));
                        } else if (this.f58565a.E > this.f58565a.C * ((int) t.i(R.dimen.ds104))) {
                            rect.left = ((((int) t.i(R.dimen.ds32)) + this.f58565a.E) - (this.f58565a.C * ((int) t.i(R.dimen.ds104)))) + (this.f58565a.D * ((int) t.i(R.dimen.ds100)));
                        }
                    }
                }
            } else {
                rect.left = -((int) t.i(R.dimen.ds26));
            }
            if (childAdapterPosition == itemCount - 1) {
                MultiMediaEditLayout multiMediaEditLayout3 = this.f58565a;
                if ((multiMediaEditLayout3.H || multiMediaEditLayout3.G) && this.f58565a.C > 0 && l.k(this.f58565a.getContext()) - this.f58565a.E >= (this.f58565a.f58560f.getItemCount() - this.f58565a.C) * ((int) t.i(R.dimen.ds104))) {
                    rect.right = (l.k(this.f58565a.getContext()) - this.f58565a.E) - (((this.f58565a.f58560f.getItemCount() - this.f58565a.C) + this.f58565a.D) * ((int) t.i(R.dimen.ds104)));
                } else {
                    rect.right = (int) t.i(R.dimen.ds32);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f58566e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ MultiMediaEditLayout f58567f;

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
            this.f58567f = multiMediaEditLayout;
            this.f58566e = z;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                this.f58567f.B = false;
                if (!this.f58566e) {
                    this.f58567f.f58559e.setVisibility(8);
                    this.f58567f.m.setAlpha(1.0f);
                    this.f58567f.m.setVisibility(0);
                } else if (this.f58567f.q != null) {
                    this.f58567f.q.b();
                }
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                super.onAnimationStart(animator);
                if (this.f58566e) {
                    return;
                }
                this.f58567f.m.setAlpha(0.01f);
                this.f58567f.m.setVisibility(0);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MultiMediaEditLayout f58568e;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f58569e;

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
                this.f58569e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    MultiMediaEditLayout multiMediaEditLayout = this.f58569e.f58568e;
                    if (multiMediaEditLayout.G) {
                        multiMediaEditLayout.H = true;
                        multiMediaEditLayout.G = false;
                        multiMediaEditLayout.f58560f.setLongPressed(false);
                        MultiMediaEditLayout multiMediaEditLayout2 = this.f58569e.f58568e;
                        multiMediaEditLayout2.F.startDrag(multiMediaEditLayout2.f58559e.findViewHolderForAdapterPosition(this.f58569e.f58568e.C));
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
            this.f58568e = multiMediaEditLayout;
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

    public void cancelTimer() {
        Timer timer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (timer = this.I) == null) {
            return;
        }
        timer.cancel();
        this.I = null;
    }

    public void enableResolutionRatio(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            j();
        }
    }

    public int getAllClipFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.v : invokeV.intValue;
    }

    public int getAllClipTo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.w : invokeV.intValue;
    }

    public int getCurrentMediaPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.n : invokeV.intValue;
    }

    public int[] getRatioGuideTransPos() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            int[] iArr = new int[2];
            ImageView imageView = this.f58563i;
            if (imageView != null && imageView.getVisibility() == 0) {
                this.f58563i.getLocationOnScreen(iArr);
                iArr[0] = iArr[0] + (this.f58563i.getWidth() >> 1);
            }
            return iArr;
        }
        return (int[]) invokeV.objValue;
    }

    public long getSingleClipFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.t : invokeV.longValue;
    }

    public long getSingleClipTo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.u : invokeV.longValue;
    }

    public int getSingleMediaStartDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.s : invokeV.intValue;
    }

    public int getSingleRotation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.y : invokeV.intValue;
    }

    public boolean hideSingleMediaImage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (isInSingleMedia()) {
                this.A = false;
                j();
                i(this.n, true);
                c.a.r0.b4.l.c.a aVar = this.q;
                if (aVar != null) {
                    aVar.a(this.n);
                }
                this.n = -1;
                this.s = 0;
                this.x = 0;
                this.f58559e.setVisibility(0);
                this.m.setVisibility(4);
                this.f58561g.setVisibility(8);
                this.p.setVisibility(8);
                this.o.setVisibility(0);
                this.k.setVisibility(0);
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void i(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < this.f58559e.getChildCount(); i3++) {
                View childAt = this.f58559e.getChildAt(i3);
                if (childAt != null) {
                    int childAdapterPosition = this.f58559e.getChildAdapterPosition(childAt);
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

    public void initMultiMediaItems(List<c.a.r0.b4.l.c.c.a> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        this.f58560f.setMultiMediaItems(list);
    }

    public boolean isDisableBack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.B : invokeV.booleanValue;
    }

    public boolean isInSingleMedia() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.A : invokeV.booleanValue;
    }

    @Override // c.a.r0.b4.l.c.e.a
    public void isLongPress() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.G = true;
            this.f58560f.setLongPressed(true);
        }
    }

    public boolean isRatioImageVisible() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f58563i.getVisibility() == 0 : invokeV.booleanValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.f58563i.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        c.a.r0.b4.l.c.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, view) == null) {
            if (view == this.f58561g) {
                c.a.r0.b4.l.c.a aVar2 = this.q;
                if (aVar2 != null) {
                    aVar2.f(this.n);
                }
            } else if (view == this.f58562h) {
                if (this.q != null) {
                    if (isInSingleMedia()) {
                        if (this.x == 0) {
                            this.x = 360;
                        }
                        int i2 = this.x;
                        int i3 = i2 - 90;
                        this.x = i3;
                        this.q.i(this.n, i2, i3);
                    } else {
                        if (this.y == 0) {
                            this.y = 360;
                        }
                        int i4 = this.y;
                        int i5 = i4 - 90;
                        this.y = i5;
                        this.q.g(i4, i5);
                    }
                }
            } else if (view == this.f58564j) {
                c.a.r0.b4.l.c.a aVar3 = this.q;
                if (aVar3 != null) {
                    aVar3.q();
                }
            } else if (view == this.f58563i && (aVar = this.q) != null) {
                aVar.o();
            }
            c.a.r0.b4.l.c.a aVar4 = this.q;
            if (aVar4 != null) {
                aVar4.onClick();
            }
        }
    }

    @Override // com.baidu.tieba.view.widget.mediaedit.VideoClipLayout.g
    public void onClipTime(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048595, this, i2, i3) == null) || this.q == null) {
            return;
        }
        if (isInSingleMedia()) {
            long j2 = i2;
            this.t = j2;
            long j3 = i3;
            this.u = j3;
            this.q.r(j2 + this.s, j3);
            return;
        }
        this.v = i2;
        this.w = i3;
        this.q.s(i2, i3);
    }

    @Override // com.baidu.tieba.view.widget.mediaedit.VideoClipLayout.g
    public void onDragCancel(float f2) {
        c.a.r0.b4.l.c.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048596, this, f2) == null) || (aVar = this.q) == null) {
            return;
        }
        aVar.e(this.s + f2);
    }

    @Override // com.baidu.tieba.view.widget.mediaedit.VideoClipLayout.g
    public void onDraging(double d2) {
        c.a.r0.b4.l.c.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{Double.valueOf(d2)}) == null) || (aVar = this.q) == null) {
            return;
        }
        aVar.p(this.s + d2);
    }

    @Override // com.baidu.tieba.view.widget.mediaedit.VideoClipLayout.g
    public void onHaveSelectedTime(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048598, this, j2) == null) {
            float f2 = (((float) j2) * 1.0f) / 1000.0f;
            if (!isInSingleMedia()) {
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

    public void onLeftLayoutClick(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048599, this, view) == null) || this.q == null || isDisableBack()) {
            return;
        }
        this.q.l(this.n);
    }

    @Override // com.baidu.tieba.view.widget.mediaedit.adapter.MultiMediaAdapter.a
    public void onMultiMediaItemClick(int i2, View view, c.a.r0.b4.l.c.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048600, this, i2, view, aVar) == null) {
            this.A = true;
            this.f58563i.setVisibility(8);
            i(i2, false);
            this.n = i2;
            this.f58561g.setVisibility(0);
            this.p.setVisibility(0);
            this.o.setVisibility(8);
            this.k.setVisibility(4);
            this.m.setImageURI(Uri.fromFile(new File(aVar.a().path)));
            c.a.r0.b4.l.c.a aVar2 = this.q;
            if (aVar2 != null) {
                aVar2.m(i2, aVar);
            }
        }
    }

    @Override // c.a.r0.b4.l.c.e.a
    public void onMutiItemPosChanged(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048601, this, i2, i3) == null) {
            resetToFirstPlayIndex();
            this.q.h(i2, i3);
        }
    }

    public void onOperateItemClick(int i2, View view) {
        c.a.r0.b4.l.c.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048602, this, i2, view) == null) || (aVar = this.q) == null) {
            return;
        }
        aVar.n(i2);
    }

    @Override // com.baidu.tieba.view.widget.mediaedit.VideoClipLayout.g
    public void onPause() {
        c.a.r0.b4.l.c.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048603, this) == null) || (aVar = this.q) == null) {
            return;
        }
        aVar.k();
    }

    public void onRightLayoutClick(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048604, this, view) == null) || this.q == null || isDisableBack() || c.a.r0.w3.b.a()) {
            return;
        }
        this.q.d(this.n);
    }

    @Override // com.baidu.tieba.view.widget.mediaedit.VideoClipLayout.g
    public void onSeekTo(long j2) {
        c.a.r0.b4.l.c.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048605, this, j2) == null) || (aVar = this.q) == null) {
            return;
        }
        aVar.c(this.s + j2);
    }

    @Override // com.baidu.tieba.view.widget.mediaedit.VideoClipLayout.g
    public void onStart() {
        c.a.r0.b4.l.c.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048606, this) == null) || (aVar = this.q) == null) {
            return;
        }
        aVar.j();
    }

    public void pauseLayout() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            cancelTimer();
        }
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            VideoClipLayout videoClipLayout = this.p;
            if (videoClipLayout != null) {
                videoClipLayout.release();
            }
            VideoClipLayout videoClipLayout2 = this.o;
            if (videoClipLayout2 != null) {
                videoClipLayout2.release();
            }
        }
    }

    public void resetRangeSlider() {
        VideoClipLayout videoClipLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048609, this) == null) || (videoClipLayout = this.o) == null) {
            return;
        }
        videoClipLayout.resetRangeSlider();
    }

    public void resetToFirstPlayIndex() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            for (c.a.r0.b4.l.c.c.a aVar : this.f58560f.getMultiMediaItems()) {
                aVar.d(false);
            }
            this.f58560f.getMultiMediaItems().get(0).d(true);
        }
    }

    @Override // c.a.r0.b4.l.c.e.a
    public void setDragMode(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048611, this, i2, i3) == null) {
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
                this.f58560f.notifyDataSetChanged();
                int k = l.k(getContext());
                if (this.E + (this.D * ((int) t.i(R.dimen.ds100))) > this.C * ((int) t.i(R.dimen.ds104))) {
                    this.f58559e.scrollToPosition(i2);
                    this.f58559e.smoothScrollBy((-this.D) * ((int) t.i(R.dimen.ds100)), 0);
                }
                if (this.E < this.C * ((int) t.i(R.dimen.ds104)) && k - this.E < (this.f58560f.getItemCount() - this.C) * ((int) t.i(R.dimen.ds100))) {
                    this.f58559e.scrollToPosition(i2);
                    this.f58559e.smoothScrollBy((-this.D) * ((int) t.i(R.dimen.ds100)), 0);
                }
                if (this.I == null) {
                    this.I = new Timer();
                }
                this.I.schedule(new c(this), 300L);
            } catch (Exception unused) {
            }
        }
    }

    public void setIMultiMediaEditView(c.a.r0.b4.l.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, aVar) == null) {
            this.q = aVar;
        }
    }

    public void setIsCortoon(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048613, this, z) == null) {
            VideoClipLayout videoClipLayout = this.o;
            if (videoClipLayout != null) {
                videoClipLayout.setIsCortoon(z);
            }
            j();
        }
    }

    public void setIsShowSpeedChanger(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048614, this, z) == null) {
            this.f58564j.setSelected(z);
        }
    }

    public void setLocalAlbumInfoData(VlogEditManager vlogEditManager, List<MultiMediaData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048615, this, vlogEditManager, list) == null) {
            setLocalAlbumInfoData(vlogEditManager, list, true);
        }
    }

    public void setMultiVideoClipLayoutRange(int i2, int i3) {
        VideoClipLayout videoClipLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048617, this, i2, i3) == null) || (videoClipLayout = this.o) == null) {
            return;
        }
        videoClipLayout.setRange(i2, i3);
    }

    public void setOnlyClip(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048618, this, z) == null) {
            this.f58563i.setVisibility(z ? 8 : 0);
            this.f58564j.setVisibility(z ? 8 : 0);
            this.f58562h.setVisibility(z ? 8 : 0);
        }
    }

    public void setOnlyOneVideo() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            this.r.setVisibility(8);
        }
    }

    public void setPageContext(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, tbPageContext) == null) {
        }
    }

    public void setSingleClipFrom(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048621, this, j2) == null) {
            this.t = j2;
        }
    }

    public void setSingleClipTo(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048622, this, j2) == null) {
            this.u = j2;
        }
    }

    public void setSingleMediaAlbumInfoData(VlogEditManager vlogEditManager, List<MultiMediaData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048623, this, vlogEditManager, list) == null) {
            setSingleMediaAlbumInfoData(vlogEditManager, list, true);
        }
    }

    public void setSingleMediaStartDuration(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048625, this, i2) == null) {
            this.s = i2;
        }
    }

    public void setSingleRotation(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048626, this, i2) == null) {
            this.x = i2;
        }
    }

    public void setSpeedBtnVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048627, this, z) == null) {
            this.f58564j.setVisibility(z ? 0 : 8);
        }
    }

    public void updateAllMultiMediaItems() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            this.f58560f.notifyDataSetChanged();
        }
    }

    public void updateCurrentPlayIndex(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048629, this, i2, i3) == null) || this.B || this.A) {
            return;
        }
        if (i2 == -1) {
            for (c.a.r0.b4.l.c.c.a aVar : this.f58560f.getMultiMediaItems()) {
                aVar.d(false);
            }
            this.f58560f.notifyDataSetChanged();
        }
        c.a.r0.b4.l.c.c.a aVar2 = (c.a.r0.b4.l.c.c.a) ListUtils.getItem(this.f58560f.getMultiMediaItems(), i2);
        if (aVar2 != null) {
            aVar2.d(false);
            this.f58560f.notifyItemChanged(i2, aVar2);
        }
        c.a.r0.b4.l.c.c.a aVar3 = (c.a.r0.b4.l.c.c.a) ListUtils.getItem(this.f58560f.getMultiMediaItems(), i3);
        if (aVar3 != null) {
            aVar3.d(true);
            this.f58560f.notifyItemChanged(i3, aVar3);
        }
    }

    public void updateCurrentPosition(int i2) {
        MultiMediaAdapter multiMediaAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048630, this, i2) == null) || (multiMediaAdapter = this.f58560f) == null) {
            return;
        }
        multiMediaAdapter.notifyItemChanged(i2);
    }

    public void updateMultiMediaItems(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048631, this, i2, i3) == null) {
            this.f58560f.updateAdapterList();
            this.f58560f.notifyItemRangeChanged(i2, i3);
        }
    }

    public void updateRatioButtonStyle(boolean z) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048632, this, z) == null) || (imageView = this.f58563i) == null) {
            return;
        }
        if (z) {
            imageView.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_topbar_pingmubili44, getResources().getColor(R.color.CAM_X0302), null));
        } else {
            imageView.setImageDrawable(getResources().getDrawable(R.drawable.icon_pure_topbar_pingmubili44));
        }
    }

    public void updateSpeedButtonStyle(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048633, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || this.f58564j == null) {
            return;
        }
        int i2 = R.drawable.icon_pure_topbar_biansu_off44;
        if (z) {
            i2 = R.drawable.icon_pure_topbar_biansu_on44;
        }
        if (z2) {
            this.f58564j.setImageDrawable(WebPManager.getPureDrawable(i2, getResources().getColor(R.color.CAM_X0302), null));
        } else {
            this.f58564j.setImageDrawable(getResources().getDrawable(i2));
        }
    }

    public void updateTimeline(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048634, this, j2) == null) {
            VideoClipLayout videoClipLayout = this.p;
            if (videoClipLayout != null) {
                videoClipLayout.doCheckProgress((int) j2);
            }
            VideoClipLayout videoClipLayout2 = this.o;
            if (videoClipLayout2 != null) {
                videoClipLayout2.doCheckProgress((int) j2);
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
        if (!(interceptable == null || interceptable.invokeLLZ(1048616, this, vlogEditManager, list, z) == null) || this.o == null) {
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
        if (!(interceptable == null || interceptable.invokeLLZ(1048624, this, vlogEditManager, list, z) == null) || (videoClipLayout = this.p) == null) {
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
        this.f58559e = (RecyclerView) findViewById(R.id.multi_media_recycler_view);
        this.f58561g = (ImageView) findViewById(R.id.img_delete_media);
        this.f58562h = (ImageView) findViewById(R.id.img_rotation_media);
        this.f58564j = (ImageView) findViewById(R.id.img_change_speed);
        this.o = (VideoClipLayout) findViewById(R.id.multiVideoClipLayout);
        this.p = (VideoClipLayout) findViewById(R.id.singleVideoClipLayout);
        this.k = (TextView) findViewById(R.id.tv_edit_tip);
        this.l = (TextView) findViewById(R.id.tv_select_total_time);
        this.m = (SimpleDraweeView) findViewById(R.id.image_single_media);
        ImageView imageView = (ImageView) findViewById(R.id.img_change_resolution);
        this.f58563i = imageView;
        imageView.setOnClickListener(this);
        GenericDraweeHierarchy hierarchy = this.m.getHierarchy();
        hierarchy.setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP);
        RoundingParams roundingParams = hierarchy.getRoundingParams();
        roundingParams = roundingParams == null ? new RoundingParams() : roundingParams;
        roundingParams.setCornersRadius(UtilHelper.getDimenPixelSize(R.dimen.tbds3));
        hierarchy.setRoundingParams(roundingParams);
        this.r = findViewById(R.id.layout_medias);
        MultiMediaAdapter multiMediaAdapter = new MultiMediaAdapter();
        this.f58560f = multiMediaAdapter;
        multiMediaAdapter.setOnItemClickLitener(this);
        this.f58559e.setAdapter(this.f58560f);
        this.f58559e.setHasFixedSize(true);
        this.f58559e.setLayoutManager(new LinearLayoutManager(context, 0, false));
        this.f58559e.addItemDecoration(new a(this));
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new DragMultiMediaItemCallback(" ", "", this.f58560f, this));
        this.F = itemTouchHelper;
        itemTouchHelper.attachToRecyclerView(this.f58559e);
        this.f58561g.setOnClickListener(this);
        this.f58562h.setOnClickListener(this);
        this.f58564j.setOnClickListener(this);
        this.o.setVideoClipListener(this);
        this.p.setVideoClipListener(this);
    }
}
