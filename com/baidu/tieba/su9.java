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
import com.baidu.tieba.fx9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
/* loaded from: classes6.dex */
public class su9 extends uu9<sv9> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public RelativeLayout g;
    @Nullable
    public fx9 h;

    /* loaded from: classes6.dex */
    public class a implements fx9.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ su9 a;

        public a(su9 su9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {su9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = su9Var;
        }

        @Override // com.baidu.tieba.fx9.b
        public void a(WriteVoteData writeVoteData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, writeVoteData) == null) {
                if (this.a.b != null) {
                    this.a.b.w();
                }
                ((sv9) this.a.d).a = writeVoteData;
                if (this.a.e != null) {
                    this.a.e.setWriteVoteData(writeVoteData);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteVoteData a;
        public final /* synthetic */ su9 b;

        public b(su9 su9Var, WriteVoteData writeVoteData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {su9Var, writeVoteData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = su9Var;
            this.a = writeVoteData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.b.F(this.a);
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_WRITE_VOTE_VIEW_SHOW).param("obj_source", 3));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public su9(TbPageContext<?> tbPageContext) {
        super(tbPageContext, sv9.class);
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

    public final void F(WriteVoteData writeVoteData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, writeVoteData) == null) {
            WriteVoteActivityConfig writeVoteActivityConfig = new WriteVoteActivityConfig(this.a.getPageActivity(), 25048);
            if (writeVoteData != null) {
                writeVoteActivityConfig.setExtraData(writeVoteData);
            }
            this.a.sendMessage(new CustomMessage(2002001, writeVoteActivityConfig));
        }
    }

    @Override // com.baidu.tieba.zu9
    public void a(@NonNull WriteData writeData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, writeData) == null) && this.e != null && writeData.getWriteVoteData() != null) {
            this.e.setWriteVoteData(writeData.getWriteVoteData());
            G();
        }
    }

    @Override // com.baidu.tieba.zu9
    public void c(WriteData writeData) {
        fx9 fx9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, writeData) == null) && (fx9Var = this.h) != null) {
            writeData.setWriteVoteData(fx9Var.c());
        }
    }

    @Override // com.baidu.tieba.zu9
    public void e(@NonNull WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, writeData) == null) {
            writeData.setWriteVoteData(((sv9) this.d).a);
        }
    }

    @Override // com.baidu.tieba.zu9
    public void onChangeSkinType(int i) {
        fx9 fx9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048582, this, i) == null) && (fx9Var = this.h) != null) {
            fx9Var.d(i);
        }
    }

    public final void G() {
        WriteData writeData;
        WriteVoteData writeVoteData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || (writeData = this.e) == null || this.h == null) {
            return;
        }
        D d = this.d;
        if (((sv9) d).a != null) {
            writeVoteData = ((sv9) d).a;
            writeData.setWriteVoteData(writeVoteData);
        } else if (writeData.getWriteVoteData() != null) {
            ((sv9) this.d).a = this.e.getWriteVoteData();
            writeVoteData = this.e.getWriteVoteData();
        } else {
            ((sv9) this.d).a = null;
            return;
        }
        b bVar = new b(this, writeVoteData);
        this.h.g(bVar);
        this.h.f(bVar);
        this.h.h(writeVoteData);
        this.h.i(true);
        bv9 bv9Var = this.b;
        if (bv9Var != null) {
            bv9Var.i();
        }
    }

    @Override // com.baidu.tieba.uu9, com.baidu.tieba.zu9
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048581, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            if (i2 != -1 || i != 25048 || intent == null) {
                return;
            }
            Serializable serializableExtra = intent.getSerializableExtra(IntentConfig.WRITE_VOTE_DATA);
            if (serializableExtra instanceof WriteVoteData) {
                ((sv9) this.d).a = (WriteVoteData) serializableExtra;
                G();
            }
        }
    }

    @Override // com.baidu.tieba.uu9, com.baidu.tieba.zu9
    public void r(lb5 lb5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, lb5Var) == null) {
            super.r(lb5Var);
            if (lb5Var.a == 22) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FUNCTION_PANEL_CLIKED).param("obj_locate", 10));
                WriteVoteData writeVoteData = null;
                fx9 fx9Var = this.h;
                if (fx9Var != null && fx9Var.c() != null) {
                    writeVoteData = this.h.c();
                }
                F(writeVoteData);
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_WRITE_VOTE_VIEW_SHOW).param("obj_source", 2));
                bv9 bv9Var = this.b;
                if (bv9Var != null) {
                    bv9Var.E();
                }
            }
        }
    }

    @Override // com.baidu.tieba.zu9
    public View s(@NonNull ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d055a, viewGroup, false);
            this.c = inflate;
            RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(R.id.obfuscated_res_0x7f092846);
            this.g = relativeLayout;
            fx9 fx9Var = new fx9(this.a, relativeLayout);
            this.h = fx9Var;
            fx9Var.e(new a(this));
            WriteData writeData = this.e;
            if (writeData != null) {
                ((sv9) this.d).a = writeData.getWriteVoteData();
                G();
            }
            return this.c;
        }
        return (View) invokeL.objValue;
    }

    @Override // com.baidu.tieba.uu9, com.baidu.tieba.zu9
    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (((sv9) this.d).a != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
