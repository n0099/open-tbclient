package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.k;
import c.a.e.e.p.l;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes7.dex */
public class FloatingAnimationView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public FrameAnimationView f58004e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f58005f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f58006g;

    /* renamed from: h  reason: collision with root package name */
    public d f58007h;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FloatingAnimationView f58008e;

        public a(FloatingAnimationView floatingAnimationView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {floatingAnimationView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58008e = floatingAnimationView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f58008e.f58007h == null) {
                return;
            }
            this.f58008e.f58007h.b();
        }
    }

    /* loaded from: classes7.dex */
    public class b implements TbImageView.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FloatingAnimationView f58009a;

        public b(FloatingAnimationView floatingAnimationView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {floatingAnimationView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58009a = floatingAnimationView;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void a(TbImageView tbImageView, Canvas canvas) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, tbImageView, canvas) == null) {
            }
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void b(TbImageView tbImageView, Canvas canvas) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbImageView, canvas) == null) && this.f58009a.f58004e.getBdImage() == null && !k.isEmpty(this.f58009a.f58004e.getUrl())) {
                this.f58009a.f58004e.startLoad(this.f58009a.f58004e.getUrl(), 10, false);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FloatingAnimationView f58010e;

        public c(FloatingAnimationView floatingAnimationView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {floatingAnimationView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58010e = floatingAnimationView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f58010e.f58007h == null) {
                return;
            }
            this.f58010e.f58007h.a();
        }
    }

    /* loaded from: classes7.dex */
    public interface d {
        void a();

        void b();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FloatingAnimationView(@NonNull Context context) {
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

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Context context = getContext();
            FrameAnimationView frameAnimationView = new FrameAnimationView(context);
            this.f58004e = frameAnimationView;
            frameAnimationView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(l.g(context, R.dimen.tbds200), l.g(context, R.dimen.tbds200));
            layoutParams.gravity = 17;
            addView(this.f58004e, layoutParams);
            TbImageView tbImageView = new TbImageView(context);
            this.f58005f = tbImageView;
            tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(l.g(context, R.dimen.tbds62), l.g(context, R.dimen.tbds62));
            layoutParams2.gravity = 53;
            this.f58005f.setAutoChangeStyle(false);
            addView(this.f58005f, layoutParams2);
            ImageView imageView = new ImageView(context);
            this.f58006g = imageView;
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
            layoutParams3.gravity = 51;
            layoutParams3.topMargin = l.g(context, R.dimen.tbds14);
            addView(this.f58006g, layoutParams3);
            this.f58004e.setOnClickListener(new a(this));
            this.f58004e.setOnDrawListener(new b(this));
            this.f58005f.setOnClickListener(new c(this));
            onChangeSkinType();
        }
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            SkinManager.setImageResource(this.f58005f, R.drawable.icon_live_close_n);
        }
    }

    public void playAnimation() {
        FrameAnimationView frameAnimationView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (frameAnimationView = this.f58004e) == null) {
            return;
        }
        frameAnimationView.setImageResource(R.drawable.transparent_bg);
        this.f58004e.playAnimation();
    }

    public void release() {
        FrameAnimationView frameAnimationView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (frameAnimationView = this.f58004e) == null) {
            return;
        }
        frameAnimationView.release();
    }

    public void setCallback(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, dVar) == null) {
            this.f58007h = dVar;
        }
    }

    public void setData(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, str) == null) || k.isEmpty(str)) {
            return;
        }
        this.f58004e.setData(str);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        FrameAnimationView frameAnimationView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, bdUniqueId) == null) || (frameAnimationView = this.f58004e) == null) {
            return;
        }
        frameAnimationView.setPageId(bdUniqueId);
    }

    public void showTag(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            if (z) {
                this.f58006g.setVisibility(0);
                SkinManager.setImageResource(this.f58006g, R.drawable.icon_front_worldcup_new_n);
                return;
            }
            this.f58006g.setVisibility(8);
        }
    }

    public void stopAnimation() {
        FrameAnimationView frameAnimationView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (frameAnimationView = this.f58004e) == null) {
            return;
        }
        frameAnimationView.setImageDrawable(null);
        this.f58004e.stopAnimation();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FloatingAnimationView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
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
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        c();
    }

    public void setData(List<String> list, int i2) {
        FrameAnimationView frameAnimationView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048582, this, list, i2) == null) || (frameAnimationView = this.f58004e) == null) {
            return;
        }
        frameAnimationView.setData(list, i2);
    }
}
