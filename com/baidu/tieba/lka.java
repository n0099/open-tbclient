package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.mz9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class lka {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements mz9.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EditorTools a;

        public a(EditorTools editorTools) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {editorTools};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = editorTools;
        }

        @Override // com.baidu.tieba.mz9.f
        public void onRefresh() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.C(new yh5(2, 12, null));
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements mz9.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EditorTools a;

        public b(EditorTools editorTools) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {editorTools};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = editorTools;
        }

        @Override // com.baidu.tieba.mz9.f
        public void onRefresh() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.C(new yh5(2, 12, null));
            }
        }
    }

    public static kia a(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, tbPageContext)) == null) {
            return new kia(tbPageContext);
        }
        return (kia) invokeL.objValue;
    }

    public static mia b(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, tbPageContext)) == null) {
            return new mia(tbPageContext);
        }
        return (mia) invokeL.objValue;
    }

    public static oia d(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, tbPageContext)) == null) {
            return new oia(tbPageContext);
        }
        return (oia) invokeL.objValue;
    }

    public static pia e(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, tbPageContext)) == null) {
            return new pia(tbPageContext);
        }
        return (pia) invokeL.objValue;
    }

    public static qia f(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, tbPageContext)) == null) {
            return new qia(tbPageContext);
        }
        return (qia) invokeL.objValue;
    }

    public static ria g(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, tbPageContext)) == null) {
            return new ria(tbPageContext);
        }
        return (ria) invokeL.objValue;
    }

    public static tia i(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, tbPageContext)) == null) {
            return new tia(tbPageContext);
        }
        return (tia) invokeL.objValue;
    }

    public static uia j(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, tbPageContext)) == null) {
            return new uia(tbPageContext);
        }
        return (uia) invokeL.objValue;
    }

    public static via k(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, tbPageContext)) == null) {
            return new via(tbPageContext);
        }
        return (via) invokeL.objValue;
    }

    public static wia l(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, tbPageContext)) == null) {
            return new wia(tbPageContext);
        }
        return (wia) invokeL.objValue;
    }

    public static zia o(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, tbPageContext)) == null) {
            return new zia(tbPageContext);
        }
        return (zia) invokeL.objValue;
    }

    public static aja p(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, tbPageContext)) == null) {
            return new aja(tbPageContext);
        }
        return (aja) invokeL.objValue;
    }

    public static bja q(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, tbPageContext)) == null) {
            return new bja(tbPageContext);
        }
        return (bja) invokeL.objValue;
    }

    public static cja r(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, tbPageContext)) == null) {
            return new cja(tbPageContext);
        }
        return (cja) invokeL.objValue;
    }

    public static nia c(@NonNull TbPageContext<?> tbPageContext, @NonNull eja ejaVar, @NonNull EditorTools editorTools, @NonNull xha xhaVar, @NonNull pka pkaVar) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65538, null, tbPageContext, ejaVar, editorTools, xhaVar, pkaVar)) == null) {
            nia niaVar = new nia(tbPageContext, xhaVar, pkaVar);
            niaVar.U(ejaVar);
            niaVar.b0(new a(editorTools));
            return niaVar;
        }
        return (nia) invokeLLLLL.objValue;
    }

    public static sia h(@NonNull TbPageContext<?> tbPageContext, @NonNull tka tkaVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, tbPageContext, tkaVar)) == null) {
            return new sia(tbPageContext, tkaVar);
        }
        return (sia) invokeLL.objValue;
    }

    public static xia m(@NonNull TbPageContext<?> tbPageContext, @NonNull eja ejaVar, @NonNull EditorTools editorTools, @NonNull tka tkaVar, @NonNull xha xhaVar, @NonNull pka pkaVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{tbPageContext, ejaVar, editorTools, tkaVar, xhaVar, pkaVar})) == null) {
            xia xiaVar = new xia(tbPageContext, tkaVar, xhaVar, pkaVar);
            xiaVar.W(ejaVar);
            xiaVar.Y(new b(editorTools));
            return xiaVar;
        }
        return (xia) invokeCommon.objValue;
    }

    public static yia n(@NonNull TbPageContext<?> tbPageContext, @NonNull eja ejaVar, @NonNull xha xhaVar, @NonNull pka pkaVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65549, null, tbPageContext, ejaVar, xhaVar, pkaVar)) == null) {
            yia yiaVar = new yia(tbPageContext, xhaVar, pkaVar);
            yiaVar.M(ejaVar);
            return yiaVar;
        }
        return (yia) invokeLLLL.objValue;
    }
}
