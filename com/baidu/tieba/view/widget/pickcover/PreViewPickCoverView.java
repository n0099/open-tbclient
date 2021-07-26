package com.baidu.tieba.view.widget.pickcover;

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
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
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
import d.a.d.e.p.j;
import d.a.w0.t.k;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class PreViewPickCoverView extends FrameLayout implements View.OnClickListener, PickCoverLayout.i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f22627e;

    /* renamed from: f  reason: collision with root package name */
    public TextEditToolView f22628f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.q0.z3.m.d.a f22629g;

    /* renamed from: h  reason: collision with root package name */
    public PickCoverLayout f22630h;

    /* renamed from: i  reason: collision with root package name */
    public c f22631i;
    public Context j;
    public EMTextView k;
    public EMTextView l;
    public RecyclerView m;
    public CoverStyleAdapter n;
    public List<TextWordsEntity.TextStyleEntity> o;
    public boolean p;

    /* loaded from: classes4.dex */
    public class CoverStyleAdapter extends RecyclerView.Adapter<CoverStyleViewHolder> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public List<TextWordsEntity.TextStyleEntity> f22632a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PreViewPickCoverView f22633b;

        /* loaded from: classes4.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f22634e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ CoverStyleAdapter f22635f;

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
                this.f22635f = coverStyleAdapter;
                this.f22634e = i2;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    this.f22635f.f22633b.k(view, this.f22634e);
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
            this.f22633b = preViewPickCoverView;
            this.f22632a = new ArrayList();
        }

        public TextWordsEntity.TextStyleEntity d(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                if (i2 < 0 || i2 >= getItemCount()) {
                    return null;
                }
                return this.f22632a.get(i2);
            }
            return (TextWordsEntity.TextStyleEntity) invokeI.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: e */
        public void onBindViewHolder(@NonNull CoverStyleViewHolder coverStyleViewHolder, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, coverStyleViewHolder, i2) == null) {
                coverStyleViewHolder.a(i2, d(i2));
                coverStyleViewHolder.itemView.setOnClickListener(new a(this, i2));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: f */
        public CoverStyleViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, viewGroup, i2)) == null) ? new CoverStyleViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.preview_pick_cover_style_item_layout, viewGroup, false)) : (CoverStyleViewHolder) invokeLI.objValue;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                List<TextWordsEntity.TextStyleEntity> list = this.f22632a;
                if (list == null) {
                    return 0;
                }
                return list.size();
            }
            return invokeV.intValue;
        }

        public void setData(List<TextWordsEntity.TextStyleEntity> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, list) == null) {
                this.f22632a.clear();
                this.f22632a.addAll(list);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class CoverStyleViewHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final SimpleDraweeView f22636a;

        /* renamed from: b  reason: collision with root package name */
        public ImageView f22637b;

        /* renamed from: c  reason: collision with root package name */
        public ObjectAnimator f22638c;

        /* renamed from: d  reason: collision with root package name */
        public FrameLayout f22639d;

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
            this.f22639d = (FrameLayout) view.findViewById(R.id.item_layout);
            this.f22636a = (SimpleDraweeView) view.findViewById(R.id.cover_style_image);
            this.f22637b = (ImageView) view.findViewById(R.id.cover_style_load_img);
            this.f22636a.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.FIT_CENTER);
            this.f22639d.setTag(this);
        }

        public void a(int i2, TextWordsEntity.TextStyleEntity textStyleEntity) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, textStyleEntity) == null) {
                if (textStyleEntity != null && (str = textStyleEntity.mIconUrl) != null) {
                    this.f22636a.setImageURI(Uri.parse(str));
                }
                c();
                TextWordsEntity.StyleBackgroudInfoEntity styleBackgroudInfoEntity = textStyleEntity.mBackgroudInfoEntity;
                if (styleBackgroudInfoEntity == null) {
                    this.f22637b.setVisibility(4);
                } else if (!styleBackgroudInfoEntity.isLoaded() && !textStyleEntity.mBackgroudInfoEntity.isNeedDown()) {
                    if (!TextUtils.isEmpty(textStyleEntity.mBackgroudInfoEntity.mBackgroudImageUrl) && d.a.w0.k.b.h().k(textStyleEntity.mBackgroudInfoEntity.mBackgroudImageUrl)) {
                        this.f22637b.setVisibility(0);
                        b();
                        return;
                    }
                    this.f22637b.setVisibility(0);
                    this.f22637b.setRotation(0.0f);
                    this.f22637b.setImageResource(R.drawable.ugc_capture_unload_icon);
                } else {
                    this.f22637b.setVisibility(4);
                }
            }
        }

        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (this.f22638c == null) {
                    ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f22637b, "rotation", 0.0f, 359.0f);
                    this.f22638c = ofFloat;
                    ofFloat.setRepeatCount(-1);
                    this.f22638c.setDuration(1000L);
                }
                if (this.f22638c.isRunning()) {
                    return;
                }
                this.f22637b.setImageResource(R.drawable.ugc_capture_loading_icon);
                this.f22638c.start();
            }
        }

        public void c() {
            ObjectAnimator objectAnimator;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (objectAnimator = this.f22638c) != null && objectAnimator.isRunning()) {
                this.f22638c.cancel();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class GridSpaceItemDecoration extends RecyclerView.ItemDecoration {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final int f22640a;

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(1048576, this, rect, view, recyclerView, state) == null) {
                int i2 = this.f22640a;
                rect.right = i2;
                rect.bottom = i2;
                rect.top = i2;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class a extends d.a.w0.k.e.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f22641a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CoverStyleViewHolder f22642b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f22643c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ PreViewPickCoverView f22644d;

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
            this.f22644d = preViewPickCoverView;
            this.f22641a = str;
            this.f22642b = coverStyleViewHolder;
            this.f22643c = i2;
        }

        @Override // d.a.w0.k.e.a
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                super.a(str);
                this.f22644d.f(this.f22643c);
                this.f22644d.n.notifyDataSetChanged();
            }
        }

        @Override // d.a.w0.k.e.a
        public void f(DownloadException downloadException) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadException) == null) {
                super.f(downloadException);
                this.f22644d.n.notifyDataSetChanged();
            }
        }

        @Override // d.a.w0.k.e.a
        public void g(long j, long j2, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i2)}) == null) {
                super.g(j, j2, i2);
            }
        }

        @Override // d.a.w0.k.e.a
        public void h() {
            CoverStyleViewHolder coverStyleViewHolder;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                super.h();
                if (!d.a.w0.k.b.h().k(this.f22641a) || (coverStyleViewHolder = this.f22642b) == null) {
                    return;
                }
                coverStyleViewHolder.b();
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f22645e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f22646f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ View f22647g;

        public b(View view, int i2, View view2) {
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
            this.f22645e = view;
            this.f22646f = i2;
            this.f22647g = view2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Rect rect = new Rect();
                this.f22645e.getHitRect(rect);
                int i2 = rect.top;
                int i3 = this.f22646f;
                rect.top = i2 - i3;
                rect.bottom += i3;
                rect.left -= i3;
                rect.right += i3;
                this.f22647g.setTouchDelegate(new TouchDelegate(rect, this.f22645e));
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        void a(float f2);

        void b(long j);

        void h(TextWordsEntity.TextStyleEntity textStyleEntity);
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
            view2.post(new b(view, i2, view2));
        }
    }

    @Override // com.baidu.tieba.view.widget.pickcover.PickCoverLayout.i
    public void a(float f2) {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048576, this, f2) == null) || (cVar = this.f22631i) == null) {
            return;
        }
        cVar.a(f2);
    }

    @Override // com.baidu.tieba.view.widget.pickcover.PickCoverLayout.i
    public void b(long j) {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) || (cVar = this.f22631i) == null) {
            return;
        }
        cVar.b(j);
    }

    public final void f(int i2) {
        c cVar;
        CoverStyleAdapter coverStyleAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) || i2 < 0 || (cVar = this.f22631i) == null || (coverStyleAdapter = this.n) == null) {
            return;
        }
        cVar.h(coverStyleAdapter.d(i2));
    }

    public void g() {
        PickCoverLayout pickCoverLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (pickCoverLayout = this.f22630h) == null) {
            return;
        }
        pickCoverLayout.f();
    }

    public View getCoverImageView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f22630h.getChangeImageCover() : (View) invokeV.objValue;
    }

    public int getCurrentMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f22627e : invokeV.intValue;
    }

    public TextView getImagePick() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.l : (TextView) invokeV.objValue;
    }

    public int getItemImageHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f22630h.getItemImageHeight() : invokeV.intValue;
    }

    public int getItemImageWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f22630h.getItemImageWidth() : invokeV.intValue;
    }

    public int getToolsViewHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f22628f.getToolsViewHeight() : invokeV.intValue;
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

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.f22628f.j();
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.f22630h.setPickCoverListener(this);
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.f22630h = (PickCoverLayout) findViewById(R.id.videoPickCoverLayout);
            this.m = (RecyclerView) findViewById(R.id.pick_cover_recycler_view);
            this.k = (EMTextView) findViewById(R.id.video_pick_cover);
            this.l = (EMTextView) findViewById(R.id.image_pick_cover);
            p();
            TextEditToolView textEditToolView = new TextEditToolView(getContext());
            this.f22628f = textEditToolView;
            textEditToolView.setVisibility(8);
        }
    }

    public final void k(View view, int i2) {
        TextWordsEntity.TextStyleEntity d2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048591, this, view, i2) == null) || (d2 = this.n.d(i2)) == null) {
            return;
        }
        TextWordsEntity.StyleBackgroudInfoEntity styleBackgroudInfoEntity = d2.mBackgroudInfoEntity;
        if (styleBackgroudInfoEntity == null) {
            f(i2);
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
            d.a.w0.k.b.h().g(str, sourceFile.getParent(), sourceFile.getName(), new a(this, str, coverStyleViewHolder, i2));
        } else {
            f(i2);
        }
    }

    public void l() {
        PickCoverLayout pickCoverLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (pickCoverLayout = this.f22630h) == null) {
            return;
        }
        pickCoverLayout.k();
    }

    public void m() {
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

    public void n() {
        PickCoverLayout pickCoverLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (pickCoverLayout = this.f22630h) == null) {
            return;
        }
        pickCoverLayout.l();
    }

    public void o(String str) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            if (this.f22628f.getParent() == null) {
                z = true;
                addView(this.f22628f);
            } else {
                z = false;
            }
            this.f22628f.l(z, str);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            super.onAttachedToWindow();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, view) == null) {
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            super.onDetachedFromWindow();
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            int i2 = this.f22627e;
            if (i2 == 1) {
                this.l.setAlpha(SkinManager.RESOURCE_ALPHA_PRESS);
                this.k.setAlpha(1.0f);
                this.f22630h.setPickCoverMask(SkinManager.getColor(0, R.color.CAM_X0605));
                this.f22630h.setSlideBarMask(false);
            } else if (i2 == 2) {
                this.k.setAlpha(SkinManager.RESOURCE_ALPHA_PRESS);
                this.l.setAlpha(1.0f);
                this.f22630h.setPickCoverMask(SkinManager.getColor(0, R.color.CAM_X0609));
                this.f22630h.setSlideBarMask(true);
            }
        }
    }

    public void q(float f2) {
        PickCoverLayout pickCoverLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048600, this, f2) == null) || (pickCoverLayout = this.f22630h) == null) {
            return;
        }
        pickCoverLayout.n(f2);
    }

    public void r(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048601, this, bitmap) == null) || bitmap == null) {
            return;
        }
        this.f22630h.m(bitmap);
    }

    public void setCoverEntity(TextWordsEntity textWordsEntity) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048602, this, textWordsEntity) == null) || textWordsEntity == null) {
            return;
        }
        this.o = textWordsEntity.mCoverStyleList;
    }

    public void setCurrentMode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i2) == null) {
            this.f22627e = i2;
            p();
        }
    }

    public void setDataByCartoon(MultiMediaData multiMediaData, long j, int i2) {
        PickCoverLayout pickCoverLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048604, this, new Object[]{multiMediaData, Long.valueOf(j), Integer.valueOf(i2)}) == null) || (pickCoverLayout = this.f22630h) == null) {
            return;
        }
        pickCoverLayout.setDataByCartoon(multiMediaData, j, i2);
    }

    public void setLastPercent(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048605, this, f2) == null) {
            if (f2 > 1.0f) {
                f2 = 0.95f;
            }
            this.f22630h.setLastPercent(f2);
        }
    }

    public void setMultiMediaData(MultiMediaData multiMediaData) {
        PickCoverLayout pickCoverLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048606, this, multiMediaData) == null) || (pickCoverLayout = this.f22630h) == null) {
            return;
        }
        pickCoverLayout.setMultiMeidaData(multiMediaData);
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, onClickListener) == null) {
            super.setOnClickListener(onClickListener);
            this.k.setOnClickListener(onClickListener);
            this.l.setOnClickListener(onClickListener);
            getCoverImageView().setOnClickListener(onClickListener);
        }
    }

    public void setOnTextWordsEditListener(d.a.q0.z3.m.d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, aVar) == null) {
            this.f22629g = aVar;
            this.f22628f.setOnTextWordsEditListener(aVar);
        }
    }

    public void setPreViewPickCoverViewListener(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, cVar) == null) {
            this.f22631i = cVar;
        }
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
        this.f22627e = 1;
        this.p = true;
        this.j = context;
        FrameLayout.inflate(context, R.layout.ugc_preview_view_pick_vover, this);
        j();
        i();
    }
}
