package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.cr9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class zba {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a implements cr9.f {
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

        @Override // com.baidu.tieba.cr9.f
        public void onRefresh() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.C(new se5(2, 12, null));
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class b implements cr9.f {
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

        @Override // com.baidu.tieba.cr9.f
        public void onRefresh() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.C(new se5(2, 12, null));
            }
        }
    }

    public static y9a a(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, tbPageContext)) == null) {
            return new y9a(tbPageContext);
        }
        return (y9a) invokeL.objValue;
    }

    public static aaa b(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, tbPageContext)) == null) {
            return new aaa(tbPageContext);
        }
        return (aaa) invokeL.objValue;
    }

    public static caa d(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, tbPageContext)) == null) {
            return new caa(tbPageContext);
        }
        return (caa) invokeL.objValue;
    }

    public static daa e(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, tbPageContext)) == null) {
            return new daa(tbPageContext);
        }
        return (daa) invokeL.objValue;
    }

    public static eaa f(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, tbPageContext)) == null) {
            return new eaa(tbPageContext);
        }
        return (eaa) invokeL.objValue;
    }

    public static faa g(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, tbPageContext)) == null) {
            return new faa(tbPageContext);
        }
        return (faa) invokeL.objValue;
    }

    public static haa i(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, tbPageContext)) == null) {
            return new haa(tbPageContext);
        }
        return (haa) invokeL.objValue;
    }

    public static iaa j(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, tbPageContext)) == null) {
            return new iaa(tbPageContext);
        }
        return (iaa) invokeL.objValue;
    }

    public static jaa k(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, tbPageContext)) == null) {
            return new jaa(tbPageContext);
        }
        return (jaa) invokeL.objValue;
    }

    public static kaa l(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, tbPageContext)) == null) {
            return new kaa(tbPageContext);
        }
        return (kaa) invokeL.objValue;
    }

    public static naa o(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, tbPageContext)) == null) {
            return new naa(tbPageContext);
        }
        return (naa) invokeL.objValue;
    }

    public static oaa p(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, tbPageContext)) == null) {
            return new oaa(tbPageContext);
        }
        return (oaa) invokeL.objValue;
    }

    public static paa q(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, tbPageContext)) == null) {
            return new paa(tbPageContext);
        }
        return (paa) invokeL.objValue;
    }

    public static qaa r(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, tbPageContext)) == null) {
            return new qaa(tbPageContext);
        }
        return (qaa) invokeL.objValue;
    }

    public static baa c(@NonNull TbPageContext<?> tbPageContext, @NonNull saa saaVar, @NonNull EditorTools editorTools, @NonNull l9a l9aVar, @NonNull dca dcaVar) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65538, null, tbPageContext, saaVar, editorTools, l9aVar, dcaVar)) == null) {
            baa baaVar = new baa(tbPageContext, l9aVar, dcaVar);
            baaVar.T(saaVar);
            baaVar.a0(new a(editorTools));
            return baaVar;
        }
        return (baa) invokeLLLLL.objValue;
    }

    public static gaa h(@NonNull TbPageContext<?> tbPageContext, @NonNull hca hcaVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, tbPageContext, hcaVar)) == null) {
            return new gaa(tbPageContext, hcaVar);
        }
        return (gaa) invokeLL.objValue;
    }

    public static laa m(@NonNull TbPageContext<?> tbPageContext, @NonNull saa saaVar, @NonNull EditorTools editorTools, @NonNull hca hcaVar, @NonNull l9a l9aVar, @NonNull dca dcaVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{tbPageContext, saaVar, editorTools, hcaVar, l9aVar, dcaVar})) == null) {
            laa laaVar = new laa(tbPageContext, hcaVar, l9aVar, dcaVar);
            laaVar.W(saaVar);
            laaVar.Y(new b(editorTools));
            return laaVar;
        }
        return (laa) invokeCommon.objValue;
    }

    public static maa n(@NonNull TbPageContext<?> tbPageContext, @NonNull saa saaVar, @NonNull l9a l9aVar, @NonNull dca dcaVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65549, null, tbPageContext, saaVar, l9aVar, dcaVar)) == null) {
            maa maaVar = new maa(tbPageContext, l9aVar, dcaVar);
            maaVar.M(saaVar);
            return maaVar;
        }
        return (maa) invokeLLLL.objValue;
    }
}
