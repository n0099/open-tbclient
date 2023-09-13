package com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputtool.robotfloor.botpanel;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.hs8;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputtool.robotfloor.botpanel.BotItemViewHolderFactory;
import com.baidu.tieba.immessagecenter.chatgroup.utility.tag.core.BaseTagItemViewHolder;
import com.baidu.tieba.kq8;
import com.baidu.tieba.ks8;
import com.baidu.tieba.lm6;
import com.baidu.tieba.mq8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
/* loaded from: classes6.dex */
public class BotItemViewHolderFactory extends ks8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final mq8 d;

    /* loaded from: classes6.dex */
    public static class a extends BaseTagItemViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public CardView c;
        public ImageView d;

        /* renamed from: com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputtool.robotfloor.botpanel.BotItemViewHolderFactory$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class View$OnClickListenerC0340a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ mq8 a;
            public final /* synthetic */ a b;

            public View$OnClickListenerC0340a(a aVar, mq8 mq8Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, mq8Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = aVar;
                this.a = mq8Var;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                mq8 mq8Var;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (this.b.d() instanceof kq8) && (mq8Var = this.a) != null) {
                    mq8Var.a(((kq8) this.b.d()).b());
                }
            }
        }

        /* loaded from: classes6.dex */
        public class b implements RequestListener<Drawable> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;
            public final /* synthetic */ GlideUrl b;
            public final /* synthetic */ a c;

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.bumptech.glide.request.RequestListener
            /* renamed from: b */
            public boolean onResourceReady(Drawable drawable, Object obj, Target<Drawable> target, DataSource dataSource, boolean z) {
                InterceptResult invokeCommon;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{drawable, obj, target, dataSource, Boolean.valueOf(z)})) == null) {
                    return false;
                }
                return invokeCommon.booleanValue;
            }

            public b(a aVar, int i, GlideUrl glideUrl) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, Integer.valueOf(i), glideUrl};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = aVar;
                this.a = i;
                this.b = glideUrl;
            }

            public /* synthetic */ void a(Target target, int i, GlideUrl glideUrl) {
                target.getRequest().clear();
                this.c.p(i + 1, glideUrl);
            }

            @Override // com.bumptech.glide.request.RequestListener
            public boolean onLoadFailed(@Nullable GlideException glideException, Object obj, final Target<Drawable> target, boolean z) {
                InterceptResult invokeCommon;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{glideException, obj, target, Boolean.valueOf(z)})) == null) {
                    lm6.a a = lm6.a();
                    final int i = this.a;
                    final GlideUrl glideUrl = this.b;
                    a.c(new Runnable() { // from class: com.baidu.tieba.iq8
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        @Override // java.lang.Runnable
                        public final void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                BotItemViewHolderFactory.a.b.this.a(target, i, glideUrl);
                            }
                        }
                    });
                    return false;
                }
                return invokeCommon.booleanValue;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(View view2, mq8 mq8Var) {
            super(view2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2, mq8Var};
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
            this.c = (CardView) view2.findViewById(R.id.obfuscated_res_0x7f090447);
            this.d = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090448);
            view2.setOnClickListener(new View$OnClickListenerC0340a(this, mq8Var));
        }

        @Override // com.baidu.tieba.immessagecenter.chatgroup.utility.tag.core.BaseTagItemViewHolder
        public void h(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                super.h(i);
                o();
            }
        }

        @Override // com.baidu.tieba.immessagecenter.chatgroup.utility.tag.core.BaseTagItemViewHolder
        public void f(hs8 hs8Var, Context context, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLI(1048576, this, hs8Var, context, i) == null) && (hs8Var instanceof kq8)) {
                p(1, new GlideUrl(((kq8) hs8Var).c()));
                o();
            }
        }

        public final void o() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                EMManager.from(this.d).setCorner(R.string.J_X05).setBorderWidth(R.dimen.obfuscated_res_0x7f0708c5).setBorderColor(R.color.CAM_X0401);
            }
        }

        public final void p(int i, GlideUrl glideUrl) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeIL(1048579, this, i, glideUrl) == null) && i <= 2) {
                Glide.with(this.d.getContext()).load((Object) glideUrl).placeholder((int) R.drawable.pic_use_header_40_n).listener(new b(this, i, glideUrl)).into(this.d);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class BotThinkItemDecoration extends RecyclerView.ItemDecoration {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public BotThinkItemDecoration() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NonNull Rect rect, @NonNull View view2, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(1048576, this, rect, view2, recyclerView, state) == null) {
                super.getItemOffsets(rect, view2, recyclerView, state);
                int childAdapterPosition = recyclerView.getChildAdapterPosition(view2);
                int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) / 2;
                if (childAdapterPosition == 0) {
                    i = UtilHelper.getDimenPixelSize(R.dimen.tbds0);
                } else {
                    i = dimenPixelSize;
                }
                rect.set(i, 0, dimenPixelSize, 0);
            }
        }
    }

    public BotItemViewHolderFactory(mq8 mq8Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mq8Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = mq8Var;
    }

    @Override // com.baidu.tieba.ks8
    public BaseTagItemViewHolder b(ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, viewGroup, i)) == null) {
            if (i == 1) {
                return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d0180, viewGroup, false), this.d);
            }
            return null;
        }
        return (BaseTagItemViewHolder) invokeLI.objValue;
    }
}
