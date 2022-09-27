package com.baidu.tieba;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public abstract class ow5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final RecyclerView.LayoutManager a;

    /* loaded from: classes5.dex */
    public static class a extends ow5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(RecyclerView.LayoutManager layoutManager) {
            super(layoutManager, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {layoutManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((RecyclerView.LayoutManager) objArr2[0], (a) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // com.baidu.tieba.ow5
        public int c(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view2.getLayoutParams();
                return this.a.getDecoratedMeasuredWidth(view2) + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
            }
            return invokeL.intValue;
        }

        @Override // com.baidu.tieba.ow5
        public int d(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2)) == null) ? this.a.getDecoratedLeft(view2) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view2.getLayoutParams())).leftMargin : invokeL.intValue;
        }

        @Override // com.baidu.tieba.ow5
        public int e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a.getWidth() : invokeV.intValue;
        }

        @Override // com.baidu.tieba.ow5
        public int f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a.getPaddingLeft() : invokeV.intValue;
        }

        @Override // com.baidu.tieba.ow5
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? (this.a.getWidth() - this.a.getPaddingLeft()) - this.a.getPaddingRight() : invokeV.intValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class b extends ow5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(RecyclerView.LayoutManager layoutManager) {
            super(layoutManager, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {layoutManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((RecyclerView.LayoutManager) objArr2[0], (a) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // com.baidu.tieba.ow5
        public int c(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view2.getLayoutParams();
                return this.a.getDecoratedMeasuredHeight(view2) + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
            }
            return invokeL.intValue;
        }

        @Override // com.baidu.tieba.ow5
        public int d(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2)) == null) ? this.a.getDecoratedTop(view2) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view2.getLayoutParams())).topMargin : invokeL.intValue;
        }

        @Override // com.baidu.tieba.ow5
        public int e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a.getHeight() : invokeV.intValue;
        }

        @Override // com.baidu.tieba.ow5
        public int f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a.getPaddingTop() : invokeV.intValue;
        }

        @Override // com.baidu.tieba.ow5
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? (this.a.getHeight() - this.a.getPaddingTop()) - this.a.getPaddingBottom() : invokeV.intValue;
        }
    }

    public /* synthetic */ ow5(RecyclerView.LayoutManager layoutManager, a aVar) {
        this(layoutManager);
    }

    public static ow5 a(RecyclerView.LayoutManager layoutManager) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, layoutManager)) == null) ? new a(layoutManager) : (ow5) invokeL.objValue;
    }

    public static ow5 b(RecyclerView.LayoutManager layoutManager) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, layoutManager)) == null) ? new b(layoutManager) : (ow5) invokeL.objValue;
    }

    public abstract int c(View view2);

    public abstract int d(View view2);

    public abstract int e();

    public abstract int f();

    public abstract int g();

    public ow5(RecyclerView.LayoutManager layoutManager) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {layoutManager};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        new Rect();
        this.a = layoutManager;
    }
}
