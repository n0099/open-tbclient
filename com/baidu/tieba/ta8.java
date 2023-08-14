package com.baidu.tieba;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.im.chat.officialBar.MultiImageTextBottomView;
import com.baidu.tieba.im.chat.officialBar.MultiImageTextTopView;
import com.baidu.tieba.im.chat.officialBar.SingleImageTextView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class ta8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ag<MultiImageTextTopView> a;
    public ag<MultiImageTextBottomView> b;
    public ag<SingleImageTextView> c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948174590, "Lcom/baidu/tieba/ta8;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948174590, "Lcom/baidu/tieba/ta8;");
        }
    }

    /* loaded from: classes8.dex */
    public class a implements bg<MultiImageTextTopView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;

        public MultiImageTextTopView e(MultiImageTextTopView multiImageTextTopView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, multiImageTextTopView)) == null) ? multiImageTextTopView : (MultiImageTextTopView) invokeL.objValue;
        }

        public a(ta8 ta8Var, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ta8Var, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.bg
        public /* bridge */ /* synthetic */ MultiImageTextTopView a(MultiImageTextTopView multiImageTextTopView) {
            MultiImageTextTopView multiImageTextTopView2 = multiImageTextTopView;
            e(multiImageTextTopView2);
            return multiImageTextTopView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.bg
        public /* bridge */ /* synthetic */ MultiImageTextTopView c(MultiImageTextTopView multiImageTextTopView) {
            MultiImageTextTopView multiImageTextTopView2 = multiImageTextTopView;
            h(multiImageTextTopView2);
            return multiImageTextTopView2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.bg
        /* renamed from: f */
        public void b(MultiImageTextTopView multiImageTextTopView) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048581, this, multiImageTextTopView) == null) && (multiImageTextTopView instanceof MultiImageTextTopView)) {
                multiImageTextTopView.f();
            }
        }

        public MultiImageTextTopView h(MultiImageTextTopView multiImageTextTopView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, multiImageTextTopView)) == null) {
                if (multiImageTextTopView instanceof MultiImageTextTopView) {
                    multiImageTextTopView.f();
                }
                return multiImageTextTopView;
            }
            return (MultiImageTextTopView) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.bg
        /* renamed from: g */
        public MultiImageTextTopView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return new MultiImageTextTopView(this.a);
            }
            return (MultiImageTextTopView) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class b extends ag<MultiImageTextTopView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ta8 ta8Var, bg bgVar, int i, int i2) {
            super(bgVar, i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ta8Var, bgVar, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((bg) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements bg<MultiImageTextBottomView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;

        public MultiImageTextBottomView e(MultiImageTextBottomView multiImageTextBottomView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, multiImageTextBottomView)) == null) ? multiImageTextBottomView : (MultiImageTextBottomView) invokeL.objValue;
        }

        public c(ta8 ta8Var, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ta8Var, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.bg
        public /* bridge */ /* synthetic */ MultiImageTextBottomView a(MultiImageTextBottomView multiImageTextBottomView) {
            MultiImageTextBottomView multiImageTextBottomView2 = multiImageTextBottomView;
            e(multiImageTextBottomView2);
            return multiImageTextBottomView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.bg
        public /* bridge */ /* synthetic */ MultiImageTextBottomView c(MultiImageTextBottomView multiImageTextBottomView) {
            MultiImageTextBottomView multiImageTextBottomView2 = multiImageTextBottomView;
            h(multiImageTextBottomView2);
            return multiImageTextBottomView2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.bg
        /* renamed from: f */
        public void b(MultiImageTextBottomView multiImageTextBottomView) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048581, this, multiImageTextBottomView) == null) && (multiImageTextBottomView instanceof MultiImageTextBottomView)) {
                multiImageTextBottomView.h();
            }
        }

        public MultiImageTextBottomView h(MultiImageTextBottomView multiImageTextBottomView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, multiImageTextBottomView)) == null) {
                if (multiImageTextBottomView instanceof MultiImageTextBottomView) {
                    multiImageTextBottomView.h();
                }
                return multiImageTextBottomView;
            }
            return (MultiImageTextBottomView) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.bg
        /* renamed from: g */
        public MultiImageTextBottomView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return new MultiImageTextBottomView(this.a);
            }
            return (MultiImageTextBottomView) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class d extends ag<MultiImageTextBottomView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(ta8 ta8Var, bg bgVar, int i, int i2) {
            super(bgVar, i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ta8Var, bgVar, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((bg) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements bg<SingleImageTextView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;

        public SingleImageTextView e(SingleImageTextView singleImageTextView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, singleImageTextView)) == null) ? singleImageTextView : (SingleImageTextView) invokeL.objValue;
        }

        public e(ta8 ta8Var, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ta8Var, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.bg
        public /* bridge */ /* synthetic */ SingleImageTextView a(SingleImageTextView singleImageTextView) {
            SingleImageTextView singleImageTextView2 = singleImageTextView;
            e(singleImageTextView2);
            return singleImageTextView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.bg
        public /* bridge */ /* synthetic */ SingleImageTextView c(SingleImageTextView singleImageTextView) {
            SingleImageTextView singleImageTextView2 = singleImageTextView;
            h(singleImageTextView2);
            return singleImageTextView2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.bg
        /* renamed from: f */
        public void b(SingleImageTextView singleImageTextView) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048581, this, singleImageTextView) == null) && (singleImageTextView instanceof SingleImageTextView)) {
                singleImageTextView.l();
            }
        }

        public SingleImageTextView h(SingleImageTextView singleImageTextView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, singleImageTextView)) == null) {
                if (singleImageTextView instanceof SingleImageTextView) {
                    singleImageTextView.l();
                }
                return singleImageTextView;
            }
            return (SingleImageTextView) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.bg
        /* renamed from: g */
        public SingleImageTextView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return new SingleImageTextView(this.a);
            }
            return (SingleImageTextView) invokeV.objValue;
        }
    }

    public ta8() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            this.b = new d(this, new c(this, context), 9, 0);
        }
    }

    public final void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            this.c = new ag<>(new e(this, context), 1, 0);
        }
    }

    public final void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            this.a = new b(this, new a(this, context), 1, 0);
        }
    }

    public ag<MultiImageTextBottomView> d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
            if (this.b == null) {
                a(context);
            }
            return this.b;
        }
        return (ag) invokeL.objValue;
    }

    public ag<SingleImageTextView> e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) {
            if (this.c == null) {
                b(context);
            }
            return this.c;
        }
        return (ag) invokeL.objValue;
    }

    public ag<MultiImageTextTopView> f(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, context)) == null) {
            if (this.a == null) {
                c(context);
            }
            return this.a;
        }
        return (ag) invokeL.objValue;
    }
}
