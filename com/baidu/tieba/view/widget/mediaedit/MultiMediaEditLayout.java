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
import androidx.constraintlayout.motion.widget.Key;
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
import com.baidu.tieba.ada;
import com.baidu.tieba.pva;
import com.baidu.tieba.rda;
import com.baidu.tieba.vi;
import com.baidu.tieba.view.widget.mediaedit.VideoClipLayout;
import com.baidu.tieba.view.widget.mediaedit.adapter.MultiMediaAdapter;
import com.baidu.tieba.view.widget.mediaedit.listener.DragMultiMediaItemCallback;
import com.baidu.tieba.wg;
import com.baidu.tieba.yca;
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
/* loaded from: classes8.dex */
public class MultiMediaEditLayout extends FrameLayout implements MultiMediaAdapter.a, View.OnClickListener, VideoClipLayout.g, rda {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public ItemTouchHelper B;
    public boolean C;
    public boolean D;
    public Timer E;
    public RecyclerView a;
    public MultiMediaAdapter b;
    public ImageView c;
    public ImageView d;
    public ImageView e;
    public ImageView f;
    public TextView g;
    public TextView h;
    public SimpleDraweeView i;
    public int j;
    public VideoClipLayout k;
    public VideoClipLayout l;
    public yca m;
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

    public void setPageContext(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, tbPageContext) == null) {
        }
    }

    /* loaded from: classes8.dex */
    public class c extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MultiMediaEditLayout a;

        /* loaded from: classes8.dex */
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
                        multiMediaEditLayout.b.p(false);
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
                wg.a().post(new a(this));
            }
        }
    }

    /* loaded from: classes8.dex */
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
        public void getItemOffsets(Rect rect, View view2, RecyclerView recyclerView, RecyclerView.State state) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLLLL(1048576, this, rect, view2, recyclerView, state) != null) || recyclerView == null) {
                return;
            }
            int childAdapterPosition = recyclerView.getChildAdapterPosition(view2);
            int i = 0;
            if (recyclerView.getAdapter() != null) {
                i = recyclerView.getAdapter().getItemCount();
            }
            if (childAdapterPosition == 0) {
                MultiMediaEditLayout multiMediaEditLayout = this.a;
                if (!multiMediaEditLayout.D && !multiMediaEditLayout.C) {
                    rect.left = (int) pva.i(R.dimen.obfuscated_res_0x7f070207);
                } else {
                    MultiMediaEditLayout multiMediaEditLayout2 = this.a;
                    if (multiMediaEditLayout2.D || multiMediaEditLayout2.C) {
                        if (this.a.y == 0) {
                            rect.left = ((int) pva.i(R.dimen.obfuscated_res_0x7f070207)) + (this.a.z * ((int) pva.i(R.dimen.obfuscated_res_0x7f07019a)));
                        } else if (this.a.A > this.a.y * ((int) pva.i(R.dimen.obfuscated_res_0x7f07019c))) {
                            rect.left = ((((int) pva.i(R.dimen.obfuscated_res_0x7f070207)) + this.a.A) - (this.a.y * ((int) pva.i(R.dimen.obfuscated_res_0x7f07019c)))) + (this.a.z * ((int) pva.i(R.dimen.obfuscated_res_0x7f07019a)));
                        }
                    }
                }
            } else {
                rect.left = -((int) pva.i(R.dimen.obfuscated_res_0x7f0701f0));
            }
            if (childAdapterPosition == i - 1) {
                MultiMediaEditLayout multiMediaEditLayout3 = this.a;
                if ((multiMediaEditLayout3.D || multiMediaEditLayout3.C) && this.a.y > 0 && vi.l(this.a.getContext()) - this.a.A >= (this.a.b.getItemCount() - this.a.y) * ((int) pva.i(R.dimen.obfuscated_res_0x7f07019c))) {
                    rect.right = (vi.l(this.a.getContext()) - this.a.A) - (((this.a.b.getItemCount() - this.a.y) + this.a.z) * ((int) pva.i(R.dimen.obfuscated_res_0x7f07019c)));
                } else {
                    rect.right = (int) pva.i(R.dimen.obfuscated_res_0x7f070207);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ MultiMediaEditLayout b;

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
            this.b = multiMediaEditLayout;
            this.a = z;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, animator) != null) {
                return;
            }
            this.b.x = false;
            if (!this.a) {
                this.b.a.setVisibility(8);
                this.b.i.setAlpha(1.0f);
                this.b.i.setVisibility(0);
            } else if (this.b.m != null) {
                this.b.m.a();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                super.onAnimationStart(animator);
                if (!this.a) {
                    this.b.i.setAlpha(0.01f);
                    this.b.i.setVisibility(0);
                }
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

    public void z(boolean z) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048621, this, z) != null) || (imageView = this.e) == null) {
            return;
        }
        if (z) {
            imageView.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080bf7, getResources().getColor(R.color.CAM_X0302), null));
        } else {
            imageView.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080bf7));
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

    public void A(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) != null) || this.f == null) {
            return;
        }
        int i = R.drawable.obfuscated_res_0x7f080bdc;
        if (z) {
            i = R.drawable.obfuscated_res_0x7f080bdd;
        }
        if (z2) {
            this.f.setImageDrawable(WebPManager.getPureDrawable(i, getResources().getColor(R.color.CAM_X0302), null));
        } else {
            this.f.setImageDrawable(getResources().getDrawable(i));
        }
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
        FrameLayout.inflate(context, R.layout.obfuscated_res_0x7f0d0521, this);
        this.a = (RecyclerView) findViewById(R.id.obfuscated_res_0x7f0917a3);
        this.c = (ImageView) findViewById(R.id.obfuscated_res_0x7f09109a);
        this.d = (ImageView) findViewById(R.id.obfuscated_res_0x7f0910c4);
        this.f = (ImageView) findViewById(R.id.obfuscated_res_0x7f091092);
        this.k = (VideoClipLayout) findViewById(R.id.obfuscated_res_0x7f091797);
        this.l = (VideoClipLayout) findViewById(R.id.obfuscated_res_0x7f09215c);
        this.g = (TextView) findViewById(R.id.obfuscated_res_0x7f092635);
        this.h = (TextView) findViewById(R.id.obfuscated_res_0x7f0926aa);
        this.i = (SimpleDraweeView) findViewById(R.id.obfuscated_res_0x7f091068);
        ImageView imageView = (ImageView) findViewById(R.id.obfuscated_res_0x7f091091);
        this.e = imageView;
        imageView.setOnClickListener(this);
        GenericDraweeHierarchy hierarchy = this.i.getHierarchy();
        hierarchy.setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP);
        RoundingParams roundingParams = hierarchy.getRoundingParams();
        roundingParams = roundingParams == null ? new RoundingParams() : roundingParams;
        roundingParams.setCornersRadius(UtilHelper.getDimenPixelSize(R.dimen.tbds3));
        hierarchy.setRoundingParams(roundingParams);
        this.n = findViewById(R.id.obfuscated_res_0x7f091469);
        MultiMediaAdapter multiMediaAdapter = new MultiMediaAdapter();
        this.b = multiMediaAdapter;
        multiMediaAdapter.q(this);
        this.a.setAdapter(this.b);
        this.a.setHasFixedSize(true);
        this.a.setLayoutManager(new LinearLayoutManager(context, 0, false));
        this.a.addItemDecoration(new a(this));
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new DragMultiMediaItemCallback(" ", "", this.b, this));
        this.B = itemTouchHelper;
        itemTouchHelper.attachToRecyclerView(this.a);
        this.c.setOnClickListener(this);
        this.d.setOnClickListener(this);
        this.f.setOnClickListener(this);
        this.k.setVideoClipListener(this);
        this.l.setVideoClipListener(this);
    }

    public void B(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
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

    @Override // com.baidu.tieba.view.widget.mediaedit.VideoClipLayout.g
    public void a(float f) {
        yca ycaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeF(Constants.METHOD_SEND_USER_MSG, this, f) == null) && (ycaVar = this.m) != null) {
            ycaVar.c(this.o + f);
        }
    }

    @Override // com.baidu.tieba.view.widget.mediaedit.VideoClipLayout.g
    public void g(double d) {
        yca ycaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Double.valueOf(d)}) == null) && (ycaVar = this.m) != null) {
            ycaVar.l(this.o + d);
        }
    }

    @Override // com.baidu.tieba.view.widget.mediaedit.VideoClipLayout.g
    public void h(long j) {
        yca ycaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(1048593, this, j) == null) && (ycaVar = this.m) != null) {
            ycaVar.b(this.o + j);
        }
    }

    public void setIMultiMediaEditView(yca ycaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, ycaVar) == null) {
            this.m = ycaVar;
        }
    }

    public void setIsCortoon(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
            VideoClipLayout videoClipLayout = this.k;
            if (videoClipLayout != null) {
                videoClipLayout.setIsCortoon(z);
            }
            r();
        }
    }

    public void setIsShowSpeedChanger(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
            this.f.setSelected(z);
        }
    }

    public void setOnlyClip(boolean z) {
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048607, this, z) == null) {
            ImageView imageView = this.e;
            int i3 = 8;
            if (z) {
                i = 8;
            } else {
                i = 0;
            }
            imageView.setVisibility(i);
            ImageView imageView2 = this.f;
            if (z) {
                i2 = 8;
            } else {
                i2 = 0;
            }
            imageView2.setVisibility(i2);
            ImageView imageView3 = this.d;
            if (!z) {
                i3 = 0;
            }
            imageView3.setVisibility(i3);
        }
    }

    public void setSingleClipFrom(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048610, this, j) == null) {
            this.p = j;
        }
    }

    public void setSingleClipTo(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048611, this, j) == null) {
            this.q = j;
        }
    }

    public void setSingleMediaStartDuration(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048614, this, i) == null) {
            this.o = i;
        }
    }

    public void setSingleRotation(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048615, this, i) == null) {
            this.t = i;
        }
    }

    public void setSpeedBtnVisible(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048616, this, z) == null) {
            ImageView imageView = this.f;
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            imageView.setVisibility(i);
        }
    }

    @Override // com.baidu.tieba.rda
    public void c(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048580, this, i, i2) == null) {
            x();
            this.m.f(i, i2);
        }
    }

    public void setLocalAlbumInfoData(VlogEditManager vlogEditManager, List<MultiMediaData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048604, this, vlogEditManager, list) == null) {
            setLocalAlbumInfoData(vlogEditManager, list, true);
        }
    }

    public void setMultiVideoClipLayoutRange(int i, int i2) {
        VideoClipLayout videoClipLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeII(1048606, this, i, i2) == null) && (videoClipLayout = this.k) != null) {
            videoClipLayout.setRange(i, i2);
        }
    }

    public void setSingleMediaAlbumInfoData(VlogEditManager vlogEditManager, List<MultiMediaData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048612, this, vlogEditManager, list) == null) {
            setSingleMediaAlbumInfoData(vlogEditManager, list, true);
        }
    }

    @Override // com.baidu.tieba.view.widget.mediaedit.VideoClipLayout.g
    public void b(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j) == null) {
            float f = (((float) j) * 1.0f) / 1000.0f;
            if (!s()) {
                if (f < 3.0f) {
                    this.h.setTextColor(getResources().getColor(R.color.CAM_X0302));
                } else {
                    this.h.setTextColor(getResources().getColor(R.color.CAM_X0201));
                }
                this.h.setText(getResources().getString(R.string.obfuscated_res_0x7f0f1727, Float.valueOf(f)));
                return;
            }
            this.h.setText(getResources().getString(R.string.obfuscated_res_0x7f0f172a, Float.valueOf(f)));
            this.h.setTextColor(getResources().getColor(R.color.CAM_X0201));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        yca ycaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, view2) == null) {
            if (view2 == this.c) {
                yca ycaVar2 = this.m;
                if (ycaVar2 != null) {
                    ycaVar2.d(this.j);
                }
            } else if (view2 == this.d) {
                if (this.m != null) {
                    if (s()) {
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
            } else if (view2 == this.f) {
                yca ycaVar3 = this.m;
                if (ycaVar3 != null) {
                    ycaVar3.m();
                }
            } else if (view2 == this.e && (ycaVar = this.m) != null) {
                ycaVar.k();
            }
            yca ycaVar4 = this.m;
            if (ycaVar4 != null) {
                ycaVar4.onClick();
            }
        }
    }

    @Override // com.baidu.tieba.view.widget.mediaedit.VideoClipLayout.g
    public void d(int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeII(1048581, this, i, i2) == null) && this.m != null) {
            if (s()) {
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
    }

    @Override // com.baidu.tieba.view.widget.mediaedit.adapter.MultiMediaAdapter.a
    public void e(int i, View view2, ada adaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048582, this, i, view2, adaVar) == null) {
            this.w = true;
            this.e.setVisibility(8);
            q(i, false);
            this.j = i;
            this.c.setVisibility(0);
            this.l.setVisibility(0);
            this.k.setVisibility(8);
            this.g.setVisibility(4);
            this.i.setImageURI(Uri.fromFile(new File(adaVar.a().path)));
            yca ycaVar = this.m;
            if (ycaVar != null) {
                ycaVar.j(i, adaVar);
            }
        }
    }

    @Override // com.baidu.tieba.rda
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.C = true;
            this.b.p(true);
        }
    }

    public int getAllClipFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.r;
        }
        return invokeV.intValue;
    }

    public int getAllClipTo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.s;
        }
        return invokeV.intValue;
    }

    public int getCurrentMediaPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.j;
        }
        return invokeV.intValue;
    }

    public long getSingleClipFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.p;
        }
        return invokeV.longValue;
    }

    public long getSingleClipTo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.q;
        }
        return invokeV.longValue;
    }

    public int getSingleMediaStartDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.o;
        }
        return invokeV.intValue;
    }

    public int getSingleRotation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.u;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.view.widget.mediaedit.VideoClipLayout.g
    public void onPause() {
        yca ycaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && (ycaVar = this.m) != null) {
            ycaVar.i();
        }
    }

    @Override // com.baidu.tieba.view.widget.mediaedit.VideoClipLayout.g
    public void onStart() {
        yca ycaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && (ycaVar = this.m) != null) {
            ycaVar.h();
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.e.setVisibility(0);
        }
    }

    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.w;
        }
        return invokeV.booleanValue;
    }

    public void setOnlyOneVideo() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            this.n.setVisibility(8);
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
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

    public void u() {
        VideoClipLayout videoClipLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048618, this) == null) && (videoClipLayout = this.k) != null) {
            videoClipLayout.P();
        }
    }

    public int[] getRatioGuideTransPos() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            int[] iArr = new int[2];
            ImageView imageView = this.e;
            if (imageView != null && imageView.getVisibility() == 0) {
                this.e.getLocationOnScreen(iArr);
                iArr[0] = iArr[0] + (this.e.getWidth() >> 1);
            }
            return iArr;
        }
        return (int[]) invokeV.objValue;
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            for (ada adaVar : this.b.l()) {
                adaVar.c(false);
            }
            this.b.l().get(0).c(true);
        }
    }

    public final void q(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < this.a.getChildCount(); i2++) {
                View childAt = this.a.getChildAt(i2);
                if (childAt != null) {
                    int childAdapterPosition = this.a.getChildAdapterPosition(childAt);
                    if (childAdapterPosition > i) {
                        float l = vi.l(getContext());
                        if (z) {
                            arrayList.add(ObjectAnimator.ofFloat(childAt, Key.TRANSLATION_X, l, 0.0f));
                        } else {
                            arrayList.add(ObjectAnimator.ofFloat(childAt, Key.TRANSLATION_X, 0.0f, l));
                        }
                    } else if (childAdapterPosition < i) {
                        float f = -vi.l(getContext());
                        if (z) {
                            arrayList.add(ObjectAnimator.ofFloat(childAt, Key.TRANSLATION_X, f, 0.0f));
                        } else {
                            arrayList.add(ObjectAnimator.ofFloat(childAt, Key.TRANSLATION_X, 0.0f, f));
                        }
                    } else {
                        if (!z) {
                            this.v = this.i.getX() - childAt.getX();
                        }
                        if (z) {
                            arrayList.add(ObjectAnimator.ofFloat(childAt, Key.TRANSLATION_X, this.v, 0.0f));
                        } else {
                            arrayList.add(ObjectAnimator.ofFloat(childAt, Key.TRANSLATION_X, 0.0f, this.v));
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

    @Override // com.baidu.tieba.rda
    public void setDragMode(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048600, this, i, i2) == null) {
            if (i < 0) {
                if (!this.C) {
                    this.D = false;
                    return;
                }
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
                this.z = ((((int) ((Float) declaredField.get(this.B)).floatValue()) - this.A) - ((int) pva.i(R.dimen.obfuscated_res_0x7f070207))) / ((int) pva.i(R.dimen.obfuscated_res_0x7f07019a));
                this.b.notifyDataSetChanged();
                int l = vi.l(getContext());
                if (this.A + (this.z * ((int) pva.i(R.dimen.obfuscated_res_0x7f07019a))) > this.y * ((int) pva.i(R.dimen.obfuscated_res_0x7f07019c))) {
                    this.a.scrollToPosition(i);
                    this.a.smoothScrollBy((-this.z) * ((int) pva.i(R.dimen.obfuscated_res_0x7f07019a)), 0);
                }
                if (this.A < this.y * ((int) pva.i(R.dimen.obfuscated_res_0x7f07019c)) && l - this.A < (this.b.getItemCount() - this.y) * ((int) pva.i(R.dimen.obfuscated_res_0x7f07019a))) {
                    this.a.scrollToPosition(i);
                    this.a.smoothScrollBy((-this.z) * ((int) pva.i(R.dimen.obfuscated_res_0x7f07019a)), 0);
                }
                if (this.E == null) {
                    this.E = new Timer();
                }
                this.E.schedule(new c(this), 300L);
            } catch (Exception unused) {
            }
        }
    }

    public void setLocalAlbumInfoData(VlogEditManager vlogEditManager, List<MultiMediaData> list, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLZ(1048605, this, vlogEditManager, list, z) == null) && this.k != null) {
            if (list.size() == 1) {
                this.k.setMediaIndex(0);
            } else {
                this.k.setMediaIndex(-1);
            }
            this.k.setLocalAlbumInfoData(vlogEditManager, list, z);
        }
    }

    public void setSingleMediaAlbumInfoData(VlogEditManager vlogEditManager, List<MultiMediaData> list, boolean z) {
        VideoClipLayout videoClipLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLZ(1048613, this, vlogEditManager, list, z) == null) && (videoClipLayout = this.l) != null) {
            if (vlogEditManager != null) {
                videoClipLayout.setMediaIndex(this.j);
            }
            this.l.setLocalAlbumInfoData(vlogEditManager, list, z);
        }
    }

    public void y(int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeII(1048620, this, i, i2) == null) && !this.x && !this.w) {
            if (i == -1) {
                for (ada adaVar : this.b.l()) {
                    adaVar.c(false);
                }
                this.b.notifyDataSetChanged();
            }
            ada adaVar2 = (ada) ListUtils.getItem(this.b.l(), i);
            if (adaVar2 != null) {
                adaVar2.c(false);
                this.b.notifyItemChanged(i, adaVar2);
            }
            ada adaVar3 = (ada) ListUtils.getItem(this.b.l(), i2);
            if (adaVar3 != null) {
                adaVar3.c(true);
                this.b.notifyItemChanged(i2, adaVar3);
            }
        }
    }
}
