package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.fra;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class qfb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements fra.f {
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

        @Override // com.baidu.tieba.fra.f
        public void onRefresh() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.K(new xd5(2, 12, null));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements fra.f {
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

        @Override // com.baidu.tieba.fra.f
        public void onRefresh() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.K(new xd5(2, 12, null));
            }
        }
    }

    public static pdb a(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, tbPageContext)) == null) {
            return new pdb(tbPageContext);
        }
        return (pdb) invokeL.objValue;
    }

    public static rdb b(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, tbPageContext)) == null) {
            return new rdb(tbPageContext);
        }
        return (rdb) invokeL.objValue;
    }

    public static tdb d(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, tbPageContext)) == null) {
            return new tdb(tbPageContext);
        }
        return (tdb) invokeL.objValue;
    }

    public static udb e(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, tbPageContext)) == null) {
            return new udb(tbPageContext);
        }
        return (udb) invokeL.objValue;
    }

    public static vdb f(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, tbPageContext)) == null) {
            return new vdb(tbPageContext);
        }
        return (vdb) invokeL.objValue;
    }

    public static wdb g(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, tbPageContext)) == null) {
            return new wdb(tbPageContext);
        }
        return (wdb) invokeL.objValue;
    }

    public static ydb i(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, tbPageContext)) == null) {
            return new ydb(tbPageContext);
        }
        return (ydb) invokeL.objValue;
    }

    public static zdb j(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, tbPageContext)) == null) {
            return new zdb(tbPageContext);
        }
        return (zdb) invokeL.objValue;
    }

    public static aeb k(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, tbPageContext)) == null) {
            return new aeb(tbPageContext);
        }
        return (aeb) invokeL.objValue;
    }

    public static beb l(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, tbPageContext)) == null) {
            return new beb(tbPageContext);
        }
        return (beb) invokeL.objValue;
    }

    public static eeb o(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, tbPageContext)) == null) {
            return new eeb(tbPageContext);
        }
        return (eeb) invokeL.objValue;
    }

    public static feb p(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, tbPageContext)) == null) {
            return new feb(tbPageContext);
        }
        return (feb) invokeL.objValue;
    }

    public static geb q(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, tbPageContext)) == null) {
            return new geb(tbPageContext);
        }
        return (geb) invokeL.objValue;
    }

    public static heb r(@NonNull TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, tbPageContext)) == null) {
            return new heb(tbPageContext);
        }
        return (heb) invokeL.objValue;
    }

    public static sdb c(@NonNull TbPageContext<?> tbPageContext, @NonNull jeb jebVar, @NonNull EditorTools editorTools, @NonNull cdb cdbVar, @NonNull ufb ufbVar) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65538, null, tbPageContext, jebVar, editorTools, cdbVar, ufbVar)) == null) {
            sdb sdbVar = new sdb(tbPageContext, cdbVar, ufbVar);
            sdbVar.U(jebVar);
            sdbVar.c0(new a(editorTools));
            return sdbVar;
        }
        return (sdb) invokeLLLLL.objValue;
    }

    public static xdb h(@NonNull TbPageContext<?> tbPageContext, @NonNull yfb yfbVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, tbPageContext, yfbVar)) == null) {
            return new xdb(tbPageContext, yfbVar);
        }
        return (xdb) invokeLL.objValue;
    }

    public static ceb m(@NonNull TbPageContext<?> tbPageContext, @NonNull jeb jebVar, @NonNull EditorTools editorTools, @NonNull yfb yfbVar, @NonNull cdb cdbVar, @NonNull ufb ufbVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{tbPageContext, jebVar, editorTools, yfbVar, cdbVar, ufbVar})) == null) {
            ceb cebVar = new ceb(tbPageContext, yfbVar, cdbVar, ufbVar);
            cebVar.W(jebVar);
            cebVar.Z(new b(editorTools));
            return cebVar;
        }
        return (ceb) invokeCommon.objValue;
    }

    public static deb n(@NonNull TbPageContext<?> tbPageContext, @NonNull jeb jebVar, @NonNull cdb cdbVar, @NonNull ufb ufbVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65549, null, tbPageContext, jebVar, cdbVar, ufbVar)) == null) {
            deb debVar = new deb(tbPageContext, cdbVar, ufbVar);
            debVar.M(jebVar);
            return debVar;
        }
        return (deb) invokeLLLL.objValue;
    }
}
