package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.forum.view.TopCardView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class lm7 extends ja7<TopCardView, u47> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public eh7 b;

    /* loaded from: classes7.dex */
    public class a implements TopCardView.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u47 a;
        public final /* synthetic */ lm7 b;

        public a(lm7 lm7Var, u47 u47Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lm7Var, u47Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = lm7Var;
            this.a = u47Var;
        }

        @Override // com.baidu.tieba.forum.view.TopCardView.a
        public void a(boolean z) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                u47 u47Var = this.a;
                int i2 = 2;
                if (z) {
                    i = 2;
                } else {
                    i = 1;
                }
                u47Var.p(i);
                eh7 eh7Var = this.b.b;
                if (!z) {
                    i2 = 1;
                }
                eh7Var.z(i2);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public lm7() {
        super("feed_top_card");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.ja7, com.baidu.tieba.za7
    @NonNull
    public View a(@NonNull ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            TopCardView topCardView = new TopCardView(viewGroup.getContext());
            sc7.i(topCardView, Integer.valueOf(sc7.e() * 2));
            return topCardView;
        }
        return (View) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.za7
    /* renamed from: f */
    public void b(@NonNull TopCardView topCardView, @NonNull u47 u47Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, topCardView, u47Var) == null) {
            if (topCardView.getContext() instanceof FragmentActivity) {
                eh7 C = ug7.k((FragmentActivity) topCardView.getContext()).C();
                this.b = C;
                C.x();
            }
            this.b.z(u47Var.l());
            this.b.w(topCardView, u47Var);
            topCardView.setUpdateFoldingListener(new a(this, u47Var));
            topCardView.r();
        }
    }
}
