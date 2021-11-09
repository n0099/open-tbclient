package com.baidu.tieba.view.widget.pickcover;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b.a.e.e.p.j;
import b.a.x0.t.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.view.widget.mediaedit.SimpleDraweeView;
import com.baidu.tieba.view.widget.pickcover.PickCoverLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.download.exception.DownloadException;
import com.baidu.ugc.editvideo.data.MultiMediaData;
import com.baidu.ugc.editvideo.data.TextWordsEntity;
import com.facebook.drawee.drawable.ScalingUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class PreViewPickCoverView extends FrameLayout implements View.OnClickListener, PickCoverLayout.i {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int PICK_MODE_IMAGE = 2;
    public static final int PICK_MODE_VIDEO = 1;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f55678e;

    /* renamed from: f  reason: collision with root package name */
    public TextEditToolView f55679f;

    /* renamed from: g  reason: collision with root package name */
    public b.a.r0.c4.l.d.a f55680g;

    /* renamed from: h  reason: collision with root package name */
    public PickCoverLayout f55681h;

    /* renamed from: i  reason: collision with root package name */
    public e f55682i;
    public Context j;
    public EMTextView k;
    public EMTextView l;
    public RecyclerView m;
    public CoverStyleAdapter n;
    public List<TextWordsEntity.TextStyleEntity> o;
    public boolean p;

    /* loaded from: classes9.dex */
    public class CoverStyleAdapter extends RecyclerView.Adapter<CoverStyleViewHolder> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public List<TextWordsEntity.TextStyleEntity> f55683a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PreViewPickCoverView f55684b;

        /* loaded from: classes9.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f55685e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ CoverStyleAdapter f55686f;

            public a(CoverStyleAdapter coverStyleAdapter, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {coverStyleAdapter, Integer.valueOf(i2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f55686f = coverStyleAdapter;
                this.f55685e = i2;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    this.f55686f.f55684b.g(view, this.f55685e);
                }
            }
        }

        public CoverStyleAdapter(PreViewPickCoverView preViewPickCoverView, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {preViewPickCoverView, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55684b = preViewPickCoverView;
            this.f55683a = new ArrayList();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                List<TextWordsEntity.TextStyleEntity> list = this.f55683a;
                if (list == null) {
                    return 0;
                }
                return list.size();
            }
            return invokeV.intValue;
        }

        public TextWordsEntity.TextStyleEntity getItemData(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
                if (i2 < 0 || i2 >= getItemCount()) {
                    return null;
                }
                return this.f55683a.get(i2);
            }
            return (TextWordsEntity.TextStyleEntity) invokeI.objValue;
        }

        public void setData(List<TextWordsEntity.TextStyleEntity> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, list) == null) {
                this.f55683a.clear();
                this.f55683a.addAll(list);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(@NonNull CoverStyleViewHolder coverStyleViewHolder, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048579, this, coverStyleViewHolder, i2) == null) {
                coverStyleViewHolder.onBind(i2, getItemData(i2));
                coverStyleViewHolder.itemView.setOnClickListener(new a(this, i2));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public CoverStyleViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, viewGroup, i2)) == null) ? new CoverStyleViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.preview_pick_cover_style_item_layout, viewGroup, false)) : (CoverStyleViewHolder) invokeLI.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class CoverStyleViewHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public ImageView f55687a;

        /* renamed from: b  reason: collision with root package name */
        public ObjectAnimator f55688b;

        /* renamed from: c  reason: collision with root package name */
        public FrameLayout f55689c;
        public final SimpleDraweeView mImage;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CoverStyleViewHolder(View view) {
            super(view);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55689c = (FrameLayout) view.findViewById(R.id.item_layout);
            this.mImage = (SimpleDraweeView) view.findViewById(R.id.cover_style_image);
            this.f55687a = (ImageView) view.findViewById(R.id.cover_style_load_img);
            this.mImage.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.FIT_CENTER);
            this.f55689c.setTag(this);
        }

        public void onBind(int i2, TextWordsEntity.TextStyleEntity textStyleEntity) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, textStyleEntity) == null) {
                if (textStyleEntity != null && (str = textStyleEntity.mIconUrl) != null) {
                    this.mImage.setImageURI(Uri.parse(str));
                }
                stopLoadingAnim();
                TextWordsEntity.StyleBackgroudInfoEntity styleBackgroudInfoEntity = textStyleEntity.mBackgroudInfoEntity;
                if (styleBackgroudInfoEntity == null) {
                    this.f55687a.setVisibility(4);
                } else if (!styleBackgroudInfoEntity.isLoaded() && !textStyleEntity.mBackgroudInfoEntity.isNeedDown()) {
                    if (!TextUtils.isEmpty(textStyleEntity.mBackgroudInfoEntity.mBackgroudImageUrl) && b.a.x0.k.b.h().k(textStyleEntity.mBackgroudInfoEntity.mBackgroudImageUrl)) {
                        this.f55687a.setVisibility(0);
                        startLoadingAnim();
                        return;
                    }
                    this.f55687a.setVisibility(0);
                    this.f55687a.setRotation(0.0f);
                    this.f55687a.setImageResource(R.drawable.ugc_capture_unload_icon);
                } else {
                    this.f55687a.setVisibility(4);
                }
            }
        }

        public void startLoadingAnim() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (this.f55688b == null) {
                    ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f55687a, Key.ROTATION, 0.0f, 359.0f);
                    this.f55688b = ofFloat;
                    ofFloat.setRepeatCount(-1);
                    this.f55688b.setDuration(1000L);
                }
                if (this.f55688b.isRunning()) {
                    return;
                }
                this.f55687a.setImageResource(R.drawable.ugc_capture_loading_icon);
                this.f55688b.start();
            }
        }

        public void stopLoadingAnim() {
            ObjectAnimator objectAnimator;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (objectAnimator = this.f55688b) != null && objectAnimator.isRunning()) {
                this.f55688b.cancel();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class GridSpaceItemDecoration extends RecyclerView.ItemDecoration {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final int f55690a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PreViewPickCoverView f55691b;

        public GridSpaceItemDecoration(PreViewPickCoverView preViewPickCoverView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {preViewPickCoverView, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55691b = preViewPickCoverView;
            this.f55690a = i2;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(1048576, this, rect, view, recyclerView, state) == null) {
                int i2 = this.f55690a;
                rect.right = i2;
                rect.bottom = i2;
                rect.top = i2;
            }
        }
    }

    /* loaded from: classes9.dex */
    public class a extends b.a.x0.k.e.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f55692a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CoverStyleViewHolder f55693b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f55694c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ PreViewPickCoverView f55695d;

        public a(PreViewPickCoverView preViewPickCoverView, String str, CoverStyleViewHolder coverStyleViewHolder, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {preViewPickCoverView, str, coverStyleViewHolder, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55695d = preViewPickCoverView;
            this.f55692a = str;
            this.f55693b = coverStyleViewHolder;
            this.f55694c = i2;
        }

        @Override // b.a.x0.k.e.a
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                super.a(str);
                this.f55695d.d(this.f55694c);
                this.f55695d.n.notifyDataSetChanged();
            }
        }

        @Override // b.a.x0.k.e.a
        public void f(DownloadException downloadException) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadException) == null) {
                super.f(downloadException);
                this.f55695d.n.notifyDataSetChanged();
            }
        }

        @Override // b.a.x0.k.e.a
        public void g(long j, long j2, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i2)}) == null) {
                super.g(j, j2, i2);
            }
        }

        @Override // b.a.x0.k.e.a
        public void h() {
            CoverStyleViewHolder coverStyleViewHolder;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                super.h();
                if (!b.a.x0.k.b.h().k(this.f55692a) || (coverStyleViewHolder = this.f55693b) == null) {
                    return;
                }
                coverStyleViewHolder.startLoadingAnim();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PreViewPickCoverView f55696e;

        /* loaded from: classes9.dex */
        public class a extends AnimatorListenerAdapter {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f55697e;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f55697e = bVar;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                    this.f55697e.f55696e.setVisibility(0);
                }
            }
        }

        public b(PreViewPickCoverView preViewPickCoverView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {preViewPickCoverView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55696e = preViewPickCoverView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                PreViewPickCoverView preViewPickCoverView = this.f55696e;
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(preViewPickCoverView, Key.TRANSLATION_Y, preViewPickCoverView.getHeight(), 0.0f);
                ofFloat.setDuration(250L);
                ofFloat.addListener(new a(this));
                ofFloat.start();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PreViewPickCoverView f55698e;

        /* loaded from: classes9.dex */
        public class a extends AnimatorListenerAdapter {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f55699e;

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
                this.f55699e = cVar;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                    this.f55699e.f55698e.setVisibility(4);
                }
            }
        }

        public c(PreViewPickCoverView preViewPickCoverView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {preViewPickCoverView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55698e = preViewPickCoverView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                PreViewPickCoverView preViewPickCoverView = this.f55698e;
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(preViewPickCoverView, Key.TRANSLATION_Y, 0.0f, preViewPickCoverView.getHeight());
                ofFloat.setDuration(250L);
                ofFloat.addListener(new a(this));
                ofFloat.start();
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f55700e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f55701f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ View f55702g;

        public d(View view, int i2, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view, Integer.valueOf(i2), view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55700e = view;
            this.f55701f = i2;
            this.f55702g = view2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Rect rect = new Rect();
                this.f55700e.getHitRect(rect);
                int i2 = rect.top;
                int i3 = this.f55701f;
                rect.top = i2 - i3;
                rect.bottom += i3;
                rect.left -= i3;
                rect.right += i3;
                this.f55702g.setTouchDelegate(new TouchDelegate(rect, this.f55700e));
            }
        }
    }

    /* loaded from: classes9.dex */
    public interface e {
        void f(TextWordsEntity.TextStyleEntity textStyleEntity);

        void updateVideoCover(long j);

        void updateVideoCoverPercent(float f2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PreViewPickCoverView(@NonNull Context context) {
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

    public static void setTouchDelegate(View view, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(AdIconUtil.BAIDU_LOGO_ID, null, view, i2) == null) {
            View view2 = (View) view.getParent();
            view2.post(new d(view, i2, view2));
        }
    }

    public final void d(int i2) {
        e eVar;
        CoverStyleAdapter coverStyleAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || i2 < 0 || (eVar = this.f55682i) == null || (coverStyleAdapter = this.n) == null) {
            return;
        }
        eVar.f(coverStyleAdapter.getItemData(i2));
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f55681h.setPickCoverListener(this);
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f55681h = (PickCoverLayout) findViewById(R.id.videoPickCoverLayout);
            this.m = (RecyclerView) findViewById(R.id.pick_cover_recycler_view);
            this.k = (EMTextView) findViewById(R.id.video_pick_cover);
            this.l = (EMTextView) findViewById(R.id.image_pick_cover);
            updatePickModeStyle();
            TextEditToolView textEditToolView = new TextEditToolView(getContext());
            this.f55679f = textEditToolView;
            textEditToolView.setVisibility(8);
        }
    }

    public final void g(View view, int i2) {
        TextWordsEntity.TextStyleEntity itemData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048579, this, view, i2) == null) || (itemData = this.n.getItemData(i2)) == null) {
            return;
        }
        TextWordsEntity.StyleBackgroudInfoEntity styleBackgroudInfoEntity = itemData.mBackgroudInfoEntity;
        if (styleBackgroudInfoEntity == null) {
            d(i2);
        } else if (!styleBackgroudInfoEntity.isNeedDown() && !styleBackgroudInfoEntity.isLoaded()) {
            if (!j.z()) {
                k.a(R.string.ugc_capture_network_error);
                return;
            }
            String str = styleBackgroudInfoEntity.mBackgroudImageUrl;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            CoverStyleViewHolder coverStyleViewHolder = view.getTag() instanceof CoverStyleViewHolder ? (CoverStyleViewHolder) view.getTag() : null;
            File sourceFile = styleBackgroudInfoEntity.getSourceFile();
            b.a.x0.k.b.h().g(str, sourceFile.getParent(), sourceFile.getName(), new a(this, str, coverStyleViewHolder, i2));
        } else {
            d(i2);
        }
    }

    public View getCoverImageView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f55681h.getChangeImageCover() : (View) invokeV.objValue;
    }

    public int getCurrentMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f55678e : invokeV.intValue;
    }

    public TextView getImagePick() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.l : (TextView) invokeV.objValue;
    }

    public int getItemImageHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f55681h.getItemImageHeight() : invokeV.intValue;
    }

    public int getItemImageWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f55681h.getItemImageWidth() : invokeV.intValue;
    }

    public int getToolsViewHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f55679f.getToolsViewHeight() : invokeV.intValue;
    }

    public TextView getVideoPick() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.k : (TextView) invokeV.objValue;
    }

    public int getViewHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? getHeight() : invokeV.intValue;
    }

    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            post(new c(this));
        }
    }

    public void hideCoverImage() {
        PickCoverLayout pickCoverLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (pickCoverLayout = this.f55681h) == null) {
            return;
        }
        pickCoverLayout.hideCoverImage();
    }

    public void hideToolView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.f55679f.hideToolView();
        }
    }

    public boolean isEditShowing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f55679f.isShowing() : invokeV.booleanValue;
    }

    public void makeCoverStable() {
        PickCoverLayout pickCoverLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (pickCoverLayout = this.f55681h) == null) {
            return;
        }
        pickCoverLayout.makeSlideRangeStable();
    }

    public void notifyCoverData() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && this.p) {
            List<TextWordsEntity.TextStyleEntity> list = this.o;
            if (list != null && list.size() > 0) {
                this.m.setVisibility(0);
                CoverStyleAdapter coverStyleAdapter = this.n;
                if (coverStyleAdapter != null) {
                    coverStyleAdapter.notifyDataSetChanged();
                    return;
                }
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.j);
                this.m.setLayoutManager(linearLayoutManager);
                linearLayoutManager.setOrientation(0);
                CoverStyleAdapter coverStyleAdapter2 = new CoverStyleAdapter(this, this.j);
                this.n = coverStyleAdapter2;
                coverStyleAdapter2.setData(this.o);
                this.m.setAdapter(this.n);
                return;
            }
            this.m.setVisibility(8);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            super.onAttachedToWindow();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, view) == null) {
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            super.onDetachedFromWindow();
        }
    }

    public void release() {
        PickCoverLayout pickCoverLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || (pickCoverLayout = this.f55681h) == null) {
            return;
        }
        pickCoverLayout.release();
    }

    public void setCoverEntity(TextWordsEntity textWordsEntity) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, textWordsEntity) == null) || textWordsEntity == null) {
            return;
        }
        this.o = textWordsEntity.mCoverStyleList;
    }

    public void setCurrentMode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i2) == null) {
            this.f55678e = i2;
            updatePickModeStyle();
        }
    }

    public void setDataByCartoon(MultiMediaData multiMediaData, long j, int i2) {
        PickCoverLayout pickCoverLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048600, this, new Object[]{multiMediaData, Long.valueOf(j), Integer.valueOf(i2)}) == null) || (pickCoverLayout = this.f55681h) == null) {
            return;
        }
        pickCoverLayout.setDataByCartoon(multiMediaData, j, i2);
    }

    public void setLastPercent(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048601, this, f2) == null) {
            if (f2 > 1.0f) {
                f2 = 0.95f;
            }
            this.f55681h.setLastPercent(f2);
        }
    }

    public void setMultiMediaData(MultiMediaData multiMediaData) {
        PickCoverLayout pickCoverLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048602, this, multiMediaData) == null) || (pickCoverLayout = this.f55681h) == null) {
            return;
        }
        pickCoverLayout.setMultiMeidaData(multiMediaData);
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, onClickListener) == null) {
            super.setOnClickListener(onClickListener);
            this.k.setOnClickListener(onClickListener);
            this.l.setOnClickListener(onClickListener);
            getCoverImageView().setOnClickListener(onClickListener);
        }
    }

    public void setOnTextWordsEditListener(b.a.r0.c4.l.d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, aVar) == null) {
            this.f55680g = aVar;
            this.f55679f.setOnTextWordsEditListener(aVar);
        }
    }

    public void setPreViewPickCoverViewListener(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, eVar) == null) {
            this.f55682i = eVar;
        }
    }

    public void show() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            post(new b(this));
        }
    }

    public void showToolView(String str) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, str) == null) {
            if (this.f55679f.getParent() == null) {
                z = true;
                addView(this.f55679f);
            } else {
                z = false;
            }
            this.f55679f.showToolView(z, str);
        }
    }

    public void updatePickModeStyle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            int i2 = this.f55678e;
            if (i2 == 1) {
                this.l.setAlpha(SkinManager.RESOURCE_ALPHA_PRESS);
                this.k.setAlpha(1.0f);
                this.f55681h.setPickCoverMask(SkinManager.getColor(0, R.color.CAM_X0605));
                this.f55681h.setSlideBarMask(false);
            } else if (i2 == 2) {
                this.k.setAlpha(SkinManager.RESOURCE_ALPHA_PRESS);
                this.l.setAlpha(1.0f);
                this.f55681h.setPickCoverMask(SkinManager.getColor(0, R.color.CAM_X0609));
                this.f55681h.setSlideBarMask(true);
            }
        }
    }

    public void updateSmartCover(float f2) {
        PickCoverLayout pickCoverLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048609, this, f2) == null) || (pickCoverLayout = this.f55681h) == null) {
            return;
        }
        pickCoverLayout.updateSlide(f2);
    }

    @Override // com.baidu.tieba.view.widget.pickcover.PickCoverLayout.i
    public void updateVideoCover(long j) {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048610, this, j) == null) || (eVar = this.f55682i) == null) {
            return;
        }
        eVar.updateVideoCover(j);
    }

    @Override // com.baidu.tieba.view.widget.pickcover.PickCoverLayout.i
    public void updateVideoCoverPercent(float f2) {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048612, this, f2) == null) || (eVar = this.f55682i) == null) {
            return;
        }
        eVar.updateVideoCoverPercent(f2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PreViewPickCoverView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PreViewPickCoverView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
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
        this.f55678e = 1;
        this.p = true;
        this.j = context;
        FrameLayout.inflate(context, R.layout.ugc_preview_view_pick_vover, this);
        f();
        e();
    }

    public void updateVideoCover(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048611, this, bitmap) == null) || bitmap == null) {
            return;
        }
        this.f55681h.updateCoverImage(bitmap);
    }
}
