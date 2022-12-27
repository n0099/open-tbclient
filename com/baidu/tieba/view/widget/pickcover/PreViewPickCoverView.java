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
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.bk9;
import com.baidu.tieba.ek9;
import com.baidu.tieba.q69;
import com.baidu.tieba.view.widget.mediaedit.SimpleDraweeView;
import com.baidu.tieba.view.widget.pickcover.PickCoverLayout;
import com.baidu.tieba.vm9;
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
/* loaded from: classes6.dex */
public class PreViewPickCoverView extends FrameLayout implements View.OnClickListener, PickCoverLayout.i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public TextEditToolView b;
    public q69 c;
    public PickCoverLayout d;
    public c e;
    public Context f;
    public EMTextView g;
    public EMTextView h;
    public RecyclerView i;
    public CoverStyleAdapter j;
    public List<TextWordsEntity.TextStyleEntity> k;
    public boolean l;

    /* loaded from: classes6.dex */
    public interface c {
        void a(float f);

        void b(long j);

        void h(TextWordsEntity.TextStyleEntity textStyleEntity);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, view2) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class CoverStyleAdapter extends RecyclerView.Adapter<CoverStyleViewHolder> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<TextWordsEntity.TextStyleEntity> a;
        public final /* synthetic */ PreViewPickCoverView b;

        /* loaded from: classes6.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;
            public final /* synthetic */ CoverStyleAdapter b;

            public a(CoverStyleAdapter coverStyleAdapter, int i) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {coverStyleAdapter, Integer.valueOf(i)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = coverStyleAdapter;
                this.a = i;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                    return;
                }
                this.b.b.k(view2, this.a);
            }
        }

        public CoverStyleAdapter(PreViewPickCoverView preViewPickCoverView, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {preViewPickCoverView, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = preViewPickCoverView;
            this.a = new ArrayList();
        }

        public TextWordsEntity.TextStyleEntity d(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                if (i >= 0 && i < getItemCount()) {
                    return this.a.get(i);
                }
                return null;
            }
            return (TextWordsEntity.TextStyleEntity) invokeI.objValue;
        }

        public void setData(List<TextWordsEntity.TextStyleEntity> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, list) == null) {
                this.a.clear();
                this.a.addAll(list);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: e */
        public void onBindViewHolder(@NonNull CoverStyleViewHolder coverStyleViewHolder, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, coverStyleViewHolder, i) == null) {
                coverStyleViewHolder.a(i, d(i));
                coverStyleViewHolder.itemView.setOnClickListener(new a(this, i));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: f */
        public CoverStyleViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, viewGroup, i)) == null) {
                return new CoverStyleViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d077a, viewGroup, false));
            }
            return (CoverStyleViewHolder) invokeLI.objValue;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                List<TextWordsEntity.TextStyleEntity> list = this.a;
                if (list == null) {
                    return 0;
                }
                return list.size();
            }
            return invokeV.intValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class CoverStyleViewHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final SimpleDraweeView a;
        public ImageView b;
        public ObjectAnimator c;
        public FrameLayout d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CoverStyleViewHolder(View view2) {
            super(view2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f09103f);
            this.a = (SimpleDraweeView) view2.findViewById(R.id.obfuscated_res_0x7f090751);
            this.b = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090752);
            this.a.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.FIT_CENTER);
            this.d.setTag(this);
        }

        public void a(int i, TextWordsEntity.TextStyleEntity textStyleEntity) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, textStyleEntity) == null) {
                if (textStyleEntity != null && (str = textStyleEntity.mIconUrl) != null) {
                    this.a.setImageURI(Uri.parse(str));
                }
                c();
                TextWordsEntity.StyleBackgroudInfoEntity styleBackgroudInfoEntity = textStyleEntity.mBackgroudInfoEntity;
                if (styleBackgroudInfoEntity == null) {
                    this.b.setVisibility(4);
                } else if (!styleBackgroudInfoEntity.isLoaded() && !textStyleEntity.mBackgroudInfoEntity.isNeedDown()) {
                    if (!TextUtils.isEmpty(textStyleEntity.mBackgroudInfoEntity.mBackgroudImageUrl) && bk9.h().k(textStyleEntity.mBackgroudInfoEntity.mBackgroudImageUrl)) {
                        this.b.setVisibility(0);
                        b();
                        return;
                    }
                    this.b.setVisibility(0);
                    this.b.setRotation(0.0f);
                    this.b.setImageResource(R.drawable.obfuscated_res_0x7f0812d3);
                } else {
                    this.b.setVisibility(4);
                }
            }
        }

        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (this.c == null) {
                    ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.b, "rotation", 0.0f, 359.0f);
                    this.c = ofFloat;
                    ofFloat.setRepeatCount(-1);
                    this.c.setDuration(1000L);
                }
                if (!this.c.isRunning()) {
                    this.b.setImageResource(R.drawable.obfuscated_res_0x7f0812d2);
                    this.c.start();
                }
            }
        }

        public void c() {
            ObjectAnimator objectAnimator;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (objectAnimator = this.c) != null && objectAnimator.isRunning()) {
                this.c.cancel();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class GridSpaceItemDecoration extends RecyclerView.ItemDecoration {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int a;

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view2, RecyclerView recyclerView, RecyclerView.State state) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(1048576, this, rect, view2, recyclerView, state) == null) {
                int i = this.a;
                rect.right = i;
                rect.bottom = i;
                rect.top = i;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a extends ek9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ CoverStyleViewHolder b;
        public final /* synthetic */ int c;
        public final /* synthetic */ PreViewPickCoverView d;

        public a(PreViewPickCoverView preViewPickCoverView, String str, CoverStyleViewHolder coverStyleViewHolder, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {preViewPickCoverView, str, coverStyleViewHolder, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = preViewPickCoverView;
            this.a = str;
            this.b = coverStyleViewHolder;
            this.c = i;
        }

        @Override // com.baidu.tieba.ek9
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                super.a(str);
                this.d.f(this.c);
                this.d.j.notifyDataSetChanged();
            }
        }

        @Override // com.baidu.tieba.ek9
        public void f(DownloadException downloadException) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadException) == null) {
                super.f(downloadException);
                this.d.j.notifyDataSetChanged();
            }
        }

        @Override // com.baidu.tieba.ek9
        public void g(long j, long j2, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i)}) == null) {
                super.g(j, j2, i);
            }
        }

        @Override // com.baidu.tieba.ek9
        public void h() {
            CoverStyleViewHolder coverStyleViewHolder;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                super.h();
                if (bk9.h().k(this.a) && (coverStyleViewHolder = this.b) != null) {
                    coverStyleViewHolder.b();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;
        public final /* synthetic */ int b;
        public final /* synthetic */ View c;

        public b(View view2, int i, View view3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2, Integer.valueOf(i), view3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = view2;
            this.b = i;
            this.c = view3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Rect rect = new Rect();
                this.a.getHitRect(rect);
                int i = rect.top;
                int i2 = this.b;
                rect.top = i - i2;
                rect.bottom += i2;
                rect.left -= i2;
                rect.right += i2;
                this.c.setTouchDelegate(new TouchDelegate(rect, this.a));
            }
        }
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

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PreViewPickCoverView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PreViewPickCoverView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
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
        this.a = 1;
        this.l = true;
        this.f = context;
        FrameLayout.inflate(context, R.layout.obfuscated_res_0x7f0d08df, this);
        j();
        i();
    }

    public static void setTouchDelegate(View view2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65542, null, view2, i) == null) {
            View view3 = (View) view2.getParent();
            view3.post(new b(view2, i, view3));
        }
    }

    @Override // com.baidu.tieba.view.widget.pickcover.PickCoverLayout.i
    public void a(float f) {
        c cVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeF(1048576, this, f) == null) && (cVar = this.e) != null) {
            cVar.a(f);
        }
    }

    @Override // com.baidu.tieba.view.widget.pickcover.PickCoverLayout.i
    public void b(long j) {
        c cVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) && (cVar = this.e) != null) {
            cVar.b(j);
        }
    }

    public final void f(int i) {
        c cVar;
        CoverStyleAdapter coverStyleAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) != null) || i < 0 || (cVar = this.e) == null || (coverStyleAdapter = this.j) == null) {
            return;
        }
        cVar.h(coverStyleAdapter.d(i));
    }

    public void o(String str) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            if (this.b.getParent() == null) {
                z = true;
                addView(this.b);
            } else {
                z = false;
            }
            this.b.l(z, str);
        }
    }

    public void q(float f) {
        PickCoverLayout pickCoverLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeF(1048600, this, f) == null) && (pickCoverLayout = this.d) != null) {
            pickCoverLayout.n(f);
        }
    }

    public void r(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048601, this, bitmap) == null) && bitmap != null) {
            this.d.m(bitmap);
        }
    }

    public void setCoverEntity(TextWordsEntity textWordsEntity) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048602, this, textWordsEntity) != null) || textWordsEntity == null) {
            return;
        }
        this.k = textWordsEntity.mCoverStyleList;
    }

    public void setCurrentMode(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i) == null) {
            this.a = i;
            p();
        }
    }

    public void setLastPercent(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048605, this, f) == null) {
            if (f > 1.0f) {
                f = 0.95f;
            }
            this.d.setLastPercent(f);
        }
    }

    public void setMultiMediaData(MultiMediaData multiMediaData) {
        PickCoverLayout pickCoverLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048606, this, multiMediaData) == null) && (pickCoverLayout = this.d) != null) {
            pickCoverLayout.setMultiMeidaData(multiMediaData);
        }
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, onClickListener) == null) {
            super.setOnClickListener(onClickListener);
            this.g.setOnClickListener(onClickListener);
            this.h.setOnClickListener(onClickListener);
            getCoverImageView().setOnClickListener(onClickListener);
        }
    }

    public void setOnTextWordsEditListener(q69 q69Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, q69Var) == null) {
            this.c = q69Var;
            this.b.setOnTextWordsEditListener(q69Var);
        }
    }

    public void setPreViewPickCoverViewListener(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, cVar) == null) {
            this.e = cVar;
        }
    }

    public void setDataByCartoon(MultiMediaData multiMediaData, long j, int i) {
        PickCoverLayout pickCoverLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048604, this, new Object[]{multiMediaData, Long.valueOf(j), Integer.valueOf(i)}) == null) && (pickCoverLayout = this.d) != null) {
            pickCoverLayout.setDataByCartoon(multiMediaData, j, i);
        }
    }

    public void g() {
        PickCoverLayout pickCoverLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (pickCoverLayout = this.d) != null) {
            pickCoverLayout.f();
        }
    }

    public View getCoverImageView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.d.getChangeImageCover();
        }
        return (View) invokeV.objValue;
    }

    public int getCurrentMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.a;
        }
        return invokeV.intValue;
    }

    public TextView getImagePick() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.h;
        }
        return (TextView) invokeV.objValue;
    }

    public int getItemImageHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.d.getItemImageHeight();
        }
        return invokeV.intValue;
    }

    public int getItemImageWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.d.getItemImageWidth();
        }
        return invokeV.intValue;
    }

    public int getToolsViewHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.b.getToolsViewHeight();
        }
        return invokeV.intValue;
    }

    public TextView getVideoPick() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.g;
        }
        return (TextView) invokeV.objValue;
    }

    public int getViewHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return getHeight();
        }
        return invokeV.intValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.b.j();
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.d.setPickCoverListener(this);
        }
    }

    public void l() {
        PickCoverLayout pickCoverLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && (pickCoverLayout = this.d) != null) {
            pickCoverLayout.k();
        }
    }

    public void n() {
        PickCoverLayout pickCoverLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048594, this) == null) && (pickCoverLayout = this.d) != null) {
            pickCoverLayout.l();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            super.onAttachedToWindow();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            super.onDetachedFromWindow();
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.d = (PickCoverLayout) findViewById(R.id.obfuscated_res_0x7f0925b6);
            this.i = (RecyclerView) findViewById(R.id.obfuscated_res_0x7f091a84);
            this.g = (EMTextView) findViewById(R.id.obfuscated_res_0x7f092618);
            this.h = (EMTextView) findViewById(R.id.obfuscated_res_0x7f090f2b);
            p();
            TextEditToolView textEditToolView = new TextEditToolView(getContext());
            this.b = textEditToolView;
            textEditToolView.setVisibility(8);
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048593, this) != null) || !this.l) {
            return;
        }
        List<TextWordsEntity.TextStyleEntity> list = this.k;
        if (list != null && list.size() > 0) {
            this.i.setVisibility(0);
            CoverStyleAdapter coverStyleAdapter = this.j;
            if (coverStyleAdapter != null) {
                coverStyleAdapter.notifyDataSetChanged();
                return;
            }
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.f);
            this.i.setLayoutManager(linearLayoutManager);
            linearLayoutManager.setOrientation(0);
            CoverStyleAdapter coverStyleAdapter2 = new CoverStyleAdapter(this, this.f);
            this.j = coverStyleAdapter2;
            coverStyleAdapter2.setData(this.k);
            this.i.setAdapter(this.j);
            return;
        }
        this.i.setVisibility(8);
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            int i = this.a;
            if (i == 1) {
                this.h.setAlpha(SkinManager.RESOURCE_ALPHA_PRESS);
                this.g.setAlpha(1.0f);
                this.d.setPickCoverMask(SkinManager.getColor(0, (int) R.color.CAM_X0605));
                this.d.setSlideBarMask(false);
            } else if (i == 2) {
                this.g.setAlpha(SkinManager.RESOURCE_ALPHA_PRESS);
                this.h.setAlpha(1.0f);
                this.d.setPickCoverMask(SkinManager.getColor(0, (int) R.color.CAM_X0609));
                this.d.setSlideBarMask(true);
            }
        }
    }

    public final void k(View view2, int i) {
        TextWordsEntity.TextStyleEntity d;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048591, this, view2, i) != null) || (d = this.j.d(i)) == null) {
            return;
        }
        TextWordsEntity.StyleBackgroudInfoEntity styleBackgroudInfoEntity = d.mBackgroudInfoEntity;
        if (styleBackgroudInfoEntity == null) {
            f(i);
        } else if (!styleBackgroudInfoEntity.isNeedDown() && !styleBackgroudInfoEntity.isLoaded()) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                vm9.a(R.string.obfuscated_res_0x7f0f1532);
                return;
            }
            String str = styleBackgroudInfoEntity.mBackgroudImageUrl;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            CoverStyleViewHolder coverStyleViewHolder = null;
            if (view2.getTag() instanceof CoverStyleViewHolder) {
                coverStyleViewHolder = (CoverStyleViewHolder) view2.getTag();
            }
            File sourceFile = styleBackgroudInfoEntity.getSourceFile();
            bk9.h().g(str, sourceFile.getParent(), sourceFile.getName(), new a(this, str, coverStyleViewHolder, i));
        } else {
            f(i);
        }
    }
}
