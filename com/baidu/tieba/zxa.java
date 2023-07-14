package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.jca;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class zxa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a implements jca.f {
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

        @Override // com.baidu.tieba.jca.f
        public void onRefresh() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.D(new zi5(2, 12, null));
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class b implements jca.f {
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

        @Override // com.baidu.tieba.jca.f
        public void onRefresh() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.D(new zi5(2, 12, null));
            }
        }
    }

    public static yva a(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, tbPageContext)) == null) {
            return new yva(tbPageContext);
        }
        return (yva) invokeL.objValue;
    }

    public static awa b(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, tbPageContext)) == null) {
            return new awa(tbPageContext);
        }
        return (awa) invokeL.objValue;
    }

    public static cwa d(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, tbPageContext)) == null) {
            return new cwa(tbPageContext);
        }
        return (cwa) invokeL.objValue;
    }

    public static dwa e(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, tbPageContext)) == null) {
            return new dwa(tbPageContext);
        }
        return (dwa) invokeL.objValue;
    }

    public static ewa f(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, tbPageContext)) == null) {
            return new ewa(tbPageContext);
        }
        return (ewa) invokeL.objValue;
    }

    public static fwa g(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, tbPageContext)) == null) {
            return new fwa(tbPageContext);
        }
        return (fwa) invokeL.objValue;
    }

    public static hwa i(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, tbPageContext)) == null) {
            return new hwa(tbPageContext);
        }
        return (hwa) invokeL.objValue;
    }

    public static iwa j(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, tbPageContext)) == null) {
            return new iwa(tbPageContext);
        }
        return (iwa) invokeL.objValue;
    }

    public static jwa k(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, tbPageContext)) == null) {
            return new jwa(tbPageContext);
        }
        return (jwa) invokeL.objValue;
    }

    public static kwa l(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, tbPageContext)) == null) {
            return new kwa(tbPageContext);
        }
        return (kwa) invokeL.objValue;
    }

    public static nwa o(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, tbPageContext)) == null) {
            return new nwa(tbPageContext);
        }
        return (nwa) invokeL.objValue;
    }

    public static owa p(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, tbPageContext)) == null) {
            return new owa(tbPageContext);
        }
        return (owa) invokeL.objValue;
    }

    public static pwa q(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, tbPageContext)) == null) {
            return new pwa(tbPageContext);
        }
        return (pwa) invokeL.objValue;
    }

    public static qwa r(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, tbPageContext)) == null) {
            return new qwa(tbPageContext);
        }
        return (qwa) invokeL.objValue;
    }

    public static bwa c(@NonNull TbPageContext<?> tbPageContext, @NonNull swa swaVar, @NonNull EditorTools editorTools, @NonNull lva lvaVar, @NonNull dya dyaVar) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65538, null, tbPageContext, swaVar, editorTools, lvaVar, dyaVar)) == null) {
            bwa bwaVar = new bwa(tbPageContext, lvaVar, dyaVar);
            bwaVar.U(swaVar);
            bwaVar.b0(new a(editorTools));
            return bwaVar;
        }
        return (bwa) invokeLLLLL.objValue;
    }

    public static gwa h(@NonNull TbPageContext<?> tbPageContext, @NonNull hya hyaVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, tbPageContext, hyaVar)) == null) {
            return new gwa(tbPageContext, hyaVar);
        }
        return (gwa) invokeLL.objValue;
    }

    public static lwa m(@NonNull TbPageContext<?> tbPageContext, @NonNull swa swaVar, @NonNull EditorTools editorTools, @NonNull hya hyaVar, @NonNull lva lvaVar, @NonNull dya dyaVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{tbPageContext, swaVar, editorTools, hyaVar, lvaVar, dyaVar})) == null) {
            lwa lwaVar = new lwa(tbPageContext, hyaVar, lvaVar, dyaVar);
            lwaVar.W(swaVar);
            lwaVar.Y(new b(editorTools));
            return lwaVar;
        }
        return (lwa) invokeCommon.objValue;
    }

    public static mwa n(@NonNull TbPageContext<?> tbPageContext, @NonNull swa swaVar, @NonNull lva lvaVar, @NonNull dya dyaVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65549, null, tbPageContext, swaVar, lvaVar, dyaVar)) == null) {
            mwa mwaVar = new mwa(tbPageContext, lvaVar, dyaVar);
            mwaVar.M(swaVar);
            return mwaVar;
        }
        return (mwa) invokeLLLL.objValue;
    }
}
