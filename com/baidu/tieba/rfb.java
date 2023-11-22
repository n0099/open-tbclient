package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.gra;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class rfb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public class a implements gra.f {
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

        @Override // com.baidu.tieba.gra.f
        public void onRefresh() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.K(new yd5(2, 12, null));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements gra.f {
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

        @Override // com.baidu.tieba.gra.f
        public void onRefresh() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.K(new yd5(2, 12, null));
            }
        }
    }

    public static qdb a(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, tbPageContext)) == null) {
            return new qdb(tbPageContext);
        }
        return (qdb) invokeL.objValue;
    }

    public static sdb b(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, tbPageContext)) == null) {
            return new sdb(tbPageContext);
        }
        return (sdb) invokeL.objValue;
    }

    public static udb d(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, tbPageContext)) == null) {
            return new udb(tbPageContext);
        }
        return (udb) invokeL.objValue;
    }

    public static vdb e(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, tbPageContext)) == null) {
            return new vdb(tbPageContext);
        }
        return (vdb) invokeL.objValue;
    }

    public static wdb f(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, tbPageContext)) == null) {
            return new wdb(tbPageContext);
        }
        return (wdb) invokeL.objValue;
    }

    public static xdb g(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, tbPageContext)) == null) {
            return new xdb(tbPageContext);
        }
        return (xdb) invokeL.objValue;
    }

    public static zdb i(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, tbPageContext)) == null) {
            return new zdb(tbPageContext);
        }
        return (zdb) invokeL.objValue;
    }

    public static aeb j(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, tbPageContext)) == null) {
            return new aeb(tbPageContext);
        }
        return (aeb) invokeL.objValue;
    }

    public static beb k(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, tbPageContext)) == null) {
            return new beb(tbPageContext);
        }
        return (beb) invokeL.objValue;
    }

    public static ceb l(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, tbPageContext)) == null) {
            return new ceb(tbPageContext);
        }
        return (ceb) invokeL.objValue;
    }

    public static feb o(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, tbPageContext)) == null) {
            return new feb(tbPageContext);
        }
        return (feb) invokeL.objValue;
    }

    public static geb p(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, tbPageContext)) == null) {
            return new geb(tbPageContext);
        }
        return (geb) invokeL.objValue;
    }

    public static heb q(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, tbPageContext)) == null) {
            return new heb(tbPageContext);
        }
        return (heb) invokeL.objValue;
    }

    public static ieb r(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, tbPageContext)) == null) {
            return new ieb(tbPageContext);
        }
        return (ieb) invokeL.objValue;
    }

    public static tdb c(@NonNull TbPageContext<?> tbPageContext, @NonNull keb kebVar, @NonNull EditorTools editorTools, @NonNull ddb ddbVar, @NonNull vfb vfbVar) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65538, null, tbPageContext, kebVar, editorTools, ddbVar, vfbVar)) == null) {
            tdb tdbVar = new tdb(tbPageContext, ddbVar, vfbVar);
            tdbVar.U(kebVar);
            tdbVar.c0(new a(editorTools));
            return tdbVar;
        }
        return (tdb) invokeLLLLL.objValue;
    }

    public static ydb h(@NonNull TbPageContext<?> tbPageContext, @NonNull zfb zfbVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, tbPageContext, zfbVar)) == null) {
            return new ydb(tbPageContext, zfbVar);
        }
        return (ydb) invokeLL.objValue;
    }

    public static deb m(@NonNull TbPageContext<?> tbPageContext, @NonNull keb kebVar, @NonNull EditorTools editorTools, @NonNull zfb zfbVar, @NonNull ddb ddbVar, @NonNull vfb vfbVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{tbPageContext, kebVar, editorTools, zfbVar, ddbVar, vfbVar})) == null) {
            deb debVar = new deb(tbPageContext, zfbVar, ddbVar, vfbVar);
            debVar.W(kebVar);
            debVar.Z(new b(editorTools));
            return debVar;
        }
        return (deb) invokeCommon.objValue;
    }

    public static eeb n(@NonNull TbPageContext<?> tbPageContext, @NonNull keb kebVar, @NonNull ddb ddbVar, @NonNull vfb vfbVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65549, null, tbPageContext, kebVar, ddbVar, vfbVar)) == null) {
            eeb eebVar = new eeb(tbPageContext, ddbVar, vfbVar);
            eebVar.M(kebVar);
            return eebVar;
        }
        return (eeb) invokeLLLL.objValue;
    }
}
