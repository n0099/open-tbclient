package com.baidu.tieba;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.SelectForumConfig;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.data.SelectForumData;
import com.baidu.tieba.j69;
import com.baidu.tieba.write.view.ForumSelectedView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class l49 extends y49 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ForumSelectedView g;
    public j69 h;
    public SelectForumData i;
    public final j69.b j;

    @Override // com.baidu.tieba.d59
    public void a(WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, writeData) == null) {
        }
    }

    @Override // com.baidu.tieba.d59
    public void e(WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, writeData) == null) {
        }
    }

    /* loaded from: classes4.dex */
    public class a implements j69.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l49 a;

        public a(l49 l49Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l49Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l49Var;
        }

        @Override // com.baidu.tieba.j69.b
        public void a(SelectForumData selectForumData) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, selectForumData) != null) {
                return;
            }
            this.a.i = selectForumData;
            if (this.a.e != null) {
                this.a.e.setForumId(selectForumData.forumId);
                this.a.e.setForumName(selectForumData.forumName);
            }
            if (this.a.g != null) {
                this.a.g.setSelectedForum(selectForumData.forumName);
            }
            this.a.y(selectForumData);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l49(TbPageContext tbPageContext) {
        super(tbPageContext, m59.class);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (Class) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = new a(this);
    }

    @Override // com.baidu.tieba.y49, com.baidu.tieba.d59
    public void q(List list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list) == null) {
            super.q(list);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                d59 d59Var = (d59) it.next();
                if (d59Var instanceof m49) {
                    w((m49) d59Var);
                } else if (d59Var instanceof u49) {
                    w((u49) d59Var);
                } else if (d59Var instanceof i49) {
                    w((i49) d59Var);
                }
            }
        }
    }

    @Override // com.baidu.tieba.d59
    public void c(WriteData writeData) {
        SelectForumData selectForumData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, writeData) == null) && (selectForumData = this.i) != null) {
            writeData.setForumId(selectForumData.forumId);
            writeData.setForumName(this.i.forumName);
        }
    }

    @Override // com.baidu.tieba.y49, com.baidu.tieba.d59
    public void j(f59 f59Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, f59Var) == null) {
            super.j(f59Var);
            if (this.h == null) {
                j69 j69Var = new j69();
                this.h = j69Var;
                j69Var.c(this.j);
            }
            this.h.b(this.a.getUniqueId());
        }
    }

    @Override // com.baidu.tieba.d59
    public void onChangeSkinType(int i) {
        ForumSelectedView forumSelectedView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048583, this, i) == null) && (forumSelectedView = this.g) != null) {
            forumSelectedView.c();
        }
    }

    public final boolean F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            WriteData writeData = this.e;
            if (writeData != null && "2".equals(writeData.getCallFrom())) {
                return TextUtils.isEmpty(this.e.getForumName());
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.y49, com.baidu.tieba.d59
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.d();
            j69 j69Var = this.h;
            if (j69Var != null) {
                j69Var.d();
            }
        }
    }

    @Override // com.baidu.tieba.y49, com.baidu.tieba.d59
    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (F()) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectForumConfig(this.a.getPageActivity())));
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.d59
    public View s(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d049d, viewGroup, false);
            this.c = inflate;
            ForumSelectedView forumSelectedView = (ForumSelectedView) inflate.findViewById(R.id.obfuscated_res_0x7f091e3b);
            this.g = forumSelectedView;
            WriteData writeData = this.e;
            if (writeData != null && forumSelectedView != null) {
                if ("main_tab".equals(writeData.getFrom()) && !this.e.isFromErrorDialog()) {
                    this.g.setVisibility(0);
                } else if (!TextUtils.isEmpty(this.e.getForumName())) {
                    this.g.setVisibility(0);
                    this.g.setSelectedForum(this.e.getForumName());
                    this.g.a();
                    this.g.setOnClickListener(null);
                } else {
                    this.g.setVisibility(8);
                }
            }
            return this.c;
        }
        return (View) invokeL.objValue;
    }
}
