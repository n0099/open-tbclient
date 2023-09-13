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
import com.baidu.tieba.h7b;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
/* loaded from: classes7.dex */
public class s4b extends u4b<s5b> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public RelativeLayout g;
    @Nullable
    public h7b h;

    /* loaded from: classes7.dex */
    public class a implements h7b.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s4b a;

        public a(s4b s4bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s4bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = s4bVar;
        }

        @Override // com.baidu.tieba.h7b.b
        public void a(WriteVoteData writeVoteData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, writeVoteData) == null) {
                if (this.a.b != null) {
                    this.a.b.w();
                }
                ((s5b) this.a.d).a = writeVoteData;
                if (this.a.e != null) {
                    this.a.e.setWriteVoteData(writeVoteData);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteVoteData a;
        public final /* synthetic */ s4b b;

        public b(s4b s4bVar, WriteVoteData writeVoteData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s4bVar, writeVoteData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = s4bVar;
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
    public s4b(TbPageContext<?> tbPageContext) {
        super(tbPageContext, s5b.class);
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

    @Override // com.baidu.tieba.z4b
    public void a(WriteData writeData) {
        h7b h7bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, writeData) == null) && (h7bVar = this.h) != null) {
            writeData.setWriteVoteData(h7bVar.c());
        }
    }

    @Override // com.baidu.tieba.z4b
    public void c(@NonNull WriteData writeData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, writeData) == null) && this.e != null && writeData.getWriteVoteData() != null) {
            this.e.setWriteVoteData(writeData.getWriteVoteData());
            G();
        }
    }

    @Override // com.baidu.tieba.z4b
    public void e(@NonNull WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, writeData) == null) {
            writeData.setWriteVoteData(((s5b) this.d).a);
        }
    }

    @Override // com.baidu.tieba.z4b
    public void onChangeSkinType(int i) {
        h7b h7bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048582, this, i) == null) && (h7bVar = this.h) != null) {
            h7bVar.d(i);
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
        if (((s5b) d).a != null) {
            writeVoteData = ((s5b) d).a;
            writeData.setWriteVoteData(writeVoteData);
        } else if (writeData.getWriteVoteData() != null) {
            ((s5b) this.d).a = this.e.getWriteVoteData();
            writeVoteData = this.e.getWriteVoteData();
        } else {
            ((s5b) this.d).a = null;
            return;
        }
        b bVar = new b(this, writeVoteData);
        this.h.g(bVar);
        this.h.f(bVar);
        this.h.h(writeVoteData);
        this.h.i(true);
        b5b b5bVar = this.b;
        if (b5bVar != null) {
            b5bVar.j();
        }
    }

    @Override // com.baidu.tieba.u4b, com.baidu.tieba.z4b
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048581, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            if (i2 != -1 || i != 25048 || intent == null) {
                return;
            }
            Serializable serializableExtra = intent.getSerializableExtra(IntentConfig.WRITE_VOTE_DATA);
            if (serializableExtra instanceof WriteVoteData) {
                ((s5b) this.d).a = (WriteVoteData) serializableExtra;
                G();
            }
        }
    }

    @Override // com.baidu.tieba.u4b, com.baidu.tieba.z4b
    public void r(si5 si5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, si5Var) == null) {
            super.r(si5Var);
            if (si5Var.a == 22) {
                x3b.b(this.a.getPageActivity(), 10);
                WriteVoteData writeVoteData = null;
                h7b h7bVar = this.h;
                if (h7bVar != null && h7bVar.c() != null) {
                    writeVoteData = this.h.c();
                }
                WriteVoteActivityConfig writeVoteActivityConfig = new WriteVoteActivityConfig(this.a.getPageActivity(), 25048);
                if (writeVoteData != null) {
                    writeVoteActivityConfig.setExtraData(writeVoteData);
                }
                this.a.sendMessage(new CustomMessage(2002001, writeVoteActivityConfig));
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_WRITE_VOTE_VIEW_SHOW).param("obj_source", 2));
                b5b b5bVar = this.b;
                if (b5bVar != null) {
                    b5bVar.D();
                }
            }
        }
    }

    @Override // com.baidu.tieba.z4b
    public View s(@NonNull ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d05b2, viewGroup, false);
            this.c = inflate;
            RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(R.id.obfuscated_res_0x7f092a25);
            this.g = relativeLayout;
            h7b h7bVar = new h7b(this.a, relativeLayout);
            this.h = h7bVar;
            h7bVar.e(new a(this));
            WriteData writeData = this.e;
            if (writeData != null) {
                ((s5b) this.d).a = writeData.getWriteVoteData();
                G();
            }
            return this.c;
        }
        return (View) invokeL.objValue;
    }

    @Override // com.baidu.tieba.u4b, com.baidu.tieba.z4b
    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (((s5b) this.d).a != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
