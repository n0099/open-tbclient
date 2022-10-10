package com.baidu.tieba;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.WriteVoteActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.WriteVoteData;
import com.baidu.tieba.r69;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
/* loaded from: classes4.dex */
public class m49 extends n49<j59> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public RelativeLayout g;
    @Nullable
    public r69 h;

    /* loaded from: classes4.dex */
    public class a implements r69.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m49 a;

        public a(m49 m49Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m49Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m49Var;
        }

        @Override // com.baidu.tieba.r69.b
        public void a(WriteVoteData writeVoteData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, writeVoteData) == null) {
                if (this.a.b != null) {
                    this.a.b.w();
                }
                ((j59) this.a.d).a = writeVoteData;
                if (this.a.e != null) {
                    this.a.e.setWriteVoteData(writeVoteData);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteVoteData a;
        public final /* synthetic */ m49 b;

        public b(m49 m49Var, WriteVoteData writeVoteData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m49Var, writeVoteData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = m49Var;
            this.a = writeVoteData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.b.D(this.a);
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_WRITE_VOTE_VIEW_SHOW).param("obj_source", 3));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m49(TbPageContext<?> tbPageContext) {
        super(tbPageContext, j59.class);
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
    }

    public final void D(WriteVoteData writeVoteData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, writeVoteData) == null) {
            WriteVoteActivityConfig writeVoteActivityConfig = new WriteVoteActivityConfig(this.a.getPageActivity(), 25048);
            if (writeVoteData != null) {
                writeVoteActivityConfig.setExtraData(writeVoteData);
            }
            this.a.sendMessage(new CustomMessage(2002001, writeVoteActivityConfig));
        }
    }

    public final void E() {
        WriteData writeData;
        WriteVoteData writeVoteData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (writeData = this.e) == null || this.h == null) {
            return;
        }
        D d = this.d;
        if (((j59) d).a != null) {
            writeVoteData = ((j59) d).a;
            writeData.setWriteVoteData(writeVoteData);
        } else if (writeData.getWriteVoteData() != null) {
            ((j59) this.d).a = this.e.getWriteVoteData();
            writeVoteData = this.e.getWriteVoteData();
        } else {
            ((j59) this.d).a = null;
            return;
        }
        b bVar = new b(this, writeVoteData);
        this.h.g(bVar);
        this.h.f(bVar);
        this.h.h(writeVoteData);
        this.h.i(true);
        u49 u49Var = this.b;
        if (u49Var != null) {
            u49Var.h();
        }
    }

    @Override // com.baidu.tieba.s49
    public void b(WriteData writeData) {
        r69 r69Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, writeData) == null) || (r69Var = this.h) == null) {
            return;
        }
        writeData.setWriteVoteData(r69Var.c());
    }

    @Override // com.baidu.tieba.s49
    public void d(@NonNull WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, writeData) == null) {
            writeData.setWriteVoteData(((j59) this.d).a);
        }
    }

    @Override // com.baidu.tieba.s49
    public void k(@NonNull WriteData writeData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, writeData) == null) || this.e == null || writeData.getWriteVoteData() == null) {
            return;
        }
        this.e.setWriteVoteData(writeData.getWriteVoteData());
        E();
    }

    @Override // com.baidu.tieba.n49, com.baidu.tieba.s49
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048581, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            if (i2 == -1 && i == 25048 && intent != null) {
                Serializable serializableExtra = intent.getSerializableExtra(IntentConfig.WRITE_VOTE_DATA);
                if (serializableExtra instanceof WriteVoteData) {
                    ((j59) this.d).a = (WriteVoteData) serializableExtra;
                    E();
                }
            }
        }
    }

    @Override // com.baidu.tieba.s49
    public void onChangeSkinType(int i) {
        r69 r69Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048582, this, i) == null) || (r69Var = this.h) == null) {
            return;
        }
        r69Var.d(i);
    }

    @Override // com.baidu.tieba.n49, com.baidu.tieba.s49
    public void p(h55 h55Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, h55Var) == null) {
            super.p(h55Var);
            if (h55Var.a == 22) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FUNCTION_PANEL_CLIKED).param("obj_locate", 10));
                WriteVoteData writeVoteData = null;
                r69 r69Var = this.h;
                if (r69Var != null && r69Var.c() != null) {
                    writeVoteData = this.h.c();
                }
                D(writeVoteData);
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_WRITE_VOTE_VIEW_SHOW).param("obj_source", 2));
                u49 u49Var = this.b;
                if (u49Var != null) {
                    u49Var.E();
                }
            }
        }
    }

    @Override // com.baidu.tieba.s49
    public View q(@NonNull ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0519, viewGroup, false);
            this.c = inflate;
            RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(R.id.obfuscated_res_0x7f092632);
            this.g = relativeLayout;
            r69 r69Var = new r69(this.a, relativeLayout);
            this.h = r69Var;
            r69Var.e(new a(this));
            WriteData writeData = this.e;
            if (writeData != null) {
                ((j59) this.d).a = writeData.getWriteVoteData();
                E();
            }
            return this.c;
        }
        return (View) invokeL.objValue;
    }

    @Override // com.baidu.tieba.n49, com.baidu.tieba.s49
    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? ((j59) this.d).a != null : invokeV.booleanValue;
    }
}
