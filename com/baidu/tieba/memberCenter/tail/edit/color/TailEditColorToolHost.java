package com.baidu.tieba.memberCenter.tail.edit.color;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.NoPressedLinearLayout;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ai7;
import com.repackage.ci7;
import com.repackage.f05;
import com.repackage.sz4;
import com.repackage.yh7;
import com.repackage.zh7;
/* loaded from: classes3.dex */
public class TailEditColorToolHost extends NoPressedLinearLayout implements f05 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public yh7 b;
    public ai7 c;
    public ci7 d;
    public EditorTools e;
    public View.OnClickListener f;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TailEditColorToolHost a;

        public a(TailEditColorToolHost tailEditColorToolHost) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tailEditColorToolHost};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tailEditColorToolHost;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            zh7 zh7Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || (zh7Var = (zh7) view2.getTag()) == null) {
                return;
            }
            this.a.c.c(zh7Var.b());
            this.a.b.notifyDataSetChanged();
            this.a.e.A(new sz4(26, -1, zh7Var.b()));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TailEditColorToolHost(TbPageContext<?> tbPageContext, String str) {
        super(tbPageContext.getPageActivity());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, str};
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
        this.a = 0;
        this.f = new a(this);
        h(tbPageContext, str);
    }

    @Override // com.repackage.f05
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            setVisibility(0);
        }
    }

    @Override // com.repackage.f05
    public void g(sz4 sz4Var) {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sz4Var) == null) || (editorTools = this.e) == null) {
            return;
        }
        editorTools.A(sz4Var);
    }

    @Override // com.repackage.f05
    public int getToolId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a : invokeV.intValue;
    }

    public final void h(TbPageContext<?> tbPageContext, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, tbPageContext, str) == null) {
            LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d07ea, (ViewGroup) this, true);
            this.d = new ci7(this);
            ai7 ai7Var = new ai7(tbPageContext);
            this.c = ai7Var;
            ai7Var.c(str);
            yh7 yh7Var = new yh7(tbPageContext, this.c, this.f);
            this.b = yh7Var;
            this.d.a(yh7Var);
        }
    }

    @Override // com.repackage.f05
    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            setVisibility(8);
        }
    }

    @Override // com.repackage.f05
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    @Override // com.repackage.tz4
    public void onAction(sz4 sz4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, sz4Var) == null) {
        }
    }

    @Override // com.repackage.f05
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
        }
    }

    @Override // com.repackage.f05
    public void setEditorTools(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, editorTools) == null) {
            this.e = editorTools;
        }
    }

    @Override // com.repackage.f05
    public void setToolId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.a = i;
        }
    }
}
