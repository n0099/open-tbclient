package com.baidu.tieba.immessagecenter.chatgroup.grouppage.effect;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.platform.comapi.map.NodeType;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.data.FallingData;
import com.baidu.tbadk.widget.falling.FallingEventType;
import com.baidu.tbadk.widget.falling.FallingView;
import com.baidu.tieba.R;
import com.baidu.tieba.ii;
import com.baidu.tieba.pt4;
import com.baidu.tieba.st5;
import com.baidu.tieba.tt5;
import com.baidu.tieba.ut5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Random;
/* loaded from: classes5.dex */
public class ChatFallingView extends FallingView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements st5.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Random a;
        public final /* synthetic */ ChatFallingView b;

        public a(ChatFallingView chatFallingView, Random random) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {chatFallingView, random};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = chatFallingView;
            this.a = random;
        }

        @Override // com.baidu.tieba.st5.c
        public float a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return (this.a.nextInt(2) * 0.1f) + 0.8f;
            }
            return invokeV.floatValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatFallingView(@NonNull Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatFallingView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
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
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatFallingView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
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
    }

    @Override // com.baidu.tbadk.widget.falling.FallingView
    @NonNull
    public tt5 p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            tt5 a2 = tt5.a();
            a2.g(NodeType.E_PARTICLE);
            a2.k(19);
            a2.j(false);
            a2.h(false);
            a2.i(false);
            return a2;
        }
        return (tt5) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.widget.falling.FallingView
    @NonNull
    public st5 q(@NonNull Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap)) == null) {
            Random random = new Random();
            st5.b bVar = new st5.b(bitmap);
            bVar.p(true, true);
            bVar.o(ii.g(TbadkCoreApplication.getInst(), R.dimen.tbds8), true);
            bVar.n(ii.g(TbadkCoreApplication.getInst(), R.dimen.tbds200), ii.g(TbadkCoreApplication.getInst(), R.dimen.tbds200), true);
            bVar.l(ii.g(TbadkCoreApplication.getInst(), R.dimen.tbds100), ii.g(TbadkCoreApplication.getInst(), R.dimen.tbds100));
            bVar.m(new a(this, random));
            return bVar.k();
        }
        return (st5) invokeL.objValue;
    }

    @Override // com.baidu.tbadk.widget.falling.FallingView
    public void u(@NonNull View view2, @NonNull FallingData fallingData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, fallingData) == null) {
            ut5 ut5Var = this.r;
            if (ut5Var != null) {
                ut5Var.a(FallingEventType.CLICK, fallingData);
            }
            pt4.s(getContext(), fallingData.getJumpUrl());
        }
    }
}
