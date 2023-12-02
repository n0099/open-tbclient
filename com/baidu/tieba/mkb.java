package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.yva;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class mkb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements yva.f {
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

        @Override // com.baidu.tieba.yva.f
        public void onRefresh() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.K(new he5(2, 12, null));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements yva.f {
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

        @Override // com.baidu.tieba.yva.f
        public void onRefresh() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.K(new he5(2, 12, null));
            }
        }
    }

    public static lib a(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, tbPageContext)) == null) {
            return new lib(tbPageContext);
        }
        return (lib) invokeL.objValue;
    }

    public static nib b(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, tbPageContext)) == null) {
            return new nib(tbPageContext);
        }
        return (nib) invokeL.objValue;
    }

    public static pib d(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, tbPageContext)) == null) {
            return new pib(tbPageContext);
        }
        return (pib) invokeL.objValue;
    }

    public static qib e(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, tbPageContext)) == null) {
            return new qib(tbPageContext);
        }
        return (qib) invokeL.objValue;
    }

    public static rib f(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, tbPageContext)) == null) {
            return new rib(tbPageContext);
        }
        return (rib) invokeL.objValue;
    }

    public static sib g(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, tbPageContext)) == null) {
            return new sib(tbPageContext);
        }
        return (sib) invokeL.objValue;
    }

    public static uib i(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, tbPageContext)) == null) {
            return new uib(tbPageContext);
        }
        return (uib) invokeL.objValue;
    }

    public static vib j(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, tbPageContext)) == null) {
            return new vib(tbPageContext);
        }
        return (vib) invokeL.objValue;
    }

    public static wib k(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, tbPageContext)) == null) {
            return new wib(tbPageContext);
        }
        return (wib) invokeL.objValue;
    }

    public static xib l(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, tbPageContext)) == null) {
            return new xib(tbPageContext);
        }
        return (xib) invokeL.objValue;
    }

    public static ajb o(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, tbPageContext)) == null) {
            return new ajb(tbPageContext);
        }
        return (ajb) invokeL.objValue;
    }

    public static bjb p(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, tbPageContext)) == null) {
            return new bjb(tbPageContext);
        }
        return (bjb) invokeL.objValue;
    }

    public static cjb q(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, tbPageContext)) == null) {
            return new cjb(tbPageContext);
        }
        return (cjb) invokeL.objValue;
    }

    public static djb r(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, tbPageContext)) == null) {
            return new djb(tbPageContext);
        }
        return (djb) invokeL.objValue;
    }

    public static oib c(@NonNull TbPageContext<?> tbPageContext, @NonNull fjb fjbVar, @NonNull EditorTools editorTools, @NonNull yhb yhbVar, @NonNull qkb qkbVar) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65538, null, tbPageContext, fjbVar, editorTools, yhbVar, qkbVar)) == null) {
            oib oibVar = new oib(tbPageContext, yhbVar, qkbVar);
            oibVar.U(fjbVar);
            oibVar.c0(new a(editorTools));
            return oibVar;
        }
        return (oib) invokeLLLLL.objValue;
    }

    public static tib h(@NonNull TbPageContext<?> tbPageContext, @NonNull ukb ukbVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, tbPageContext, ukbVar)) == null) {
            return new tib(tbPageContext, ukbVar);
        }
        return (tib) invokeLL.objValue;
    }

    public static yib m(@NonNull TbPageContext<?> tbPageContext, @NonNull fjb fjbVar, @NonNull EditorTools editorTools, @NonNull ukb ukbVar, @NonNull yhb yhbVar, @NonNull qkb qkbVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{tbPageContext, fjbVar, editorTools, ukbVar, yhbVar, qkbVar})) == null) {
            yib yibVar = new yib(tbPageContext, ukbVar, yhbVar, qkbVar);
            yibVar.W(fjbVar);
            yibVar.Z(new b(editorTools));
            return yibVar;
        }
        return (yib) invokeCommon.objValue;
    }

    public static zib n(@NonNull TbPageContext<?> tbPageContext, @NonNull fjb fjbVar, @NonNull yhb yhbVar, @NonNull qkb qkbVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65549, null, tbPageContext, fjbVar, yhbVar, qkbVar)) == null) {
            zib zibVar = new zib(tbPageContext, yhbVar, qkbVar);
            zibVar.M(fjbVar);
            return zibVar;
        }
        return (zib) invokeLLLL.objValue;
    }
}
