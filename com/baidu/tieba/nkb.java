package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.zva;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class nkb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements zva.f {
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

        @Override // com.baidu.tieba.zva.f
        public void onRefresh() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.K(new he5(2, 12, null));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements zva.f {
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

        @Override // com.baidu.tieba.zva.f
        public void onRefresh() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.K(new he5(2, 12, null));
            }
        }
    }

    public static mib a(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, tbPageContext)) == null) {
            return new mib(tbPageContext);
        }
        return (mib) invokeL.objValue;
    }

    public static oib b(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, tbPageContext)) == null) {
            return new oib(tbPageContext);
        }
        return (oib) invokeL.objValue;
    }

    public static qib d(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, tbPageContext)) == null) {
            return new qib(tbPageContext);
        }
        return (qib) invokeL.objValue;
    }

    public static rib e(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, tbPageContext)) == null) {
            return new rib(tbPageContext);
        }
        return (rib) invokeL.objValue;
    }

    public static sib f(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, tbPageContext)) == null) {
            return new sib(tbPageContext);
        }
        return (sib) invokeL.objValue;
    }

    public static tib g(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, tbPageContext)) == null) {
            return new tib(tbPageContext);
        }
        return (tib) invokeL.objValue;
    }

    public static vib i(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, tbPageContext)) == null) {
            return new vib(tbPageContext);
        }
        return (vib) invokeL.objValue;
    }

    public static wib j(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, tbPageContext)) == null) {
            return new wib(tbPageContext);
        }
        return (wib) invokeL.objValue;
    }

    public static xib k(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, tbPageContext)) == null) {
            return new xib(tbPageContext);
        }
        return (xib) invokeL.objValue;
    }

    public static yib l(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, tbPageContext)) == null) {
            return new yib(tbPageContext);
        }
        return (yib) invokeL.objValue;
    }

    public static bjb o(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, tbPageContext)) == null) {
            return new bjb(tbPageContext);
        }
        return (bjb) invokeL.objValue;
    }

    public static cjb p(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, tbPageContext)) == null) {
            return new cjb(tbPageContext);
        }
        return (cjb) invokeL.objValue;
    }

    public static djb q(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, tbPageContext)) == null) {
            return new djb(tbPageContext);
        }
        return (djb) invokeL.objValue;
    }

    public static ejb r(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, tbPageContext)) == null) {
            return new ejb(tbPageContext);
        }
        return (ejb) invokeL.objValue;
    }

    public static pib c(@NonNull TbPageContext<?> tbPageContext, @NonNull gjb gjbVar, @NonNull EditorTools editorTools, @NonNull zhb zhbVar, @NonNull rkb rkbVar) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65538, null, tbPageContext, gjbVar, editorTools, zhbVar, rkbVar)) == null) {
            pib pibVar = new pib(tbPageContext, zhbVar, rkbVar);
            pibVar.U(gjbVar);
            pibVar.c0(new a(editorTools));
            return pibVar;
        }
        return (pib) invokeLLLLL.objValue;
    }

    public static uib h(@NonNull TbPageContext<?> tbPageContext, @NonNull vkb vkbVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, tbPageContext, vkbVar)) == null) {
            return new uib(tbPageContext, vkbVar);
        }
        return (uib) invokeLL.objValue;
    }

    public static zib m(@NonNull TbPageContext<?> tbPageContext, @NonNull gjb gjbVar, @NonNull EditorTools editorTools, @NonNull vkb vkbVar, @NonNull zhb zhbVar, @NonNull rkb rkbVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{tbPageContext, gjbVar, editorTools, vkbVar, zhbVar, rkbVar})) == null) {
            zib zibVar = new zib(tbPageContext, vkbVar, zhbVar, rkbVar);
            zibVar.W(gjbVar);
            zibVar.Z(new b(editorTools));
            return zibVar;
        }
        return (zib) invokeCommon.objValue;
    }

    public static ajb n(@NonNull TbPageContext<?> tbPageContext, @NonNull gjb gjbVar, @NonNull zhb zhbVar, @NonNull rkb rkbVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65549, null, tbPageContext, gjbVar, zhbVar, rkbVar)) == null) {
            ajb ajbVar = new ajb(tbPageContext, zhbVar, rkbVar);
            ajbVar.M(gjbVar);
            return ajbVar;
        }
        return (ajb) invokeLLLL.objValue;
    }
}
