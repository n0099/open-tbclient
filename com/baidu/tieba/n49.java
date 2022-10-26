package com.baidu.tieba;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.write.write.WriteImageGridView;
import com.baidu.tieba.y39;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class n49 extends y49 implements b59 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public WriteImageGridView g;
    public y39 h;
    public final o69 i;
    public final y39.b j;

    @Override // com.baidu.tieba.d59
    public void e(WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, writeData) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class a implements y39.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n49 a;

        public a(n49 n49Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n49Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n49Var;
        }

        @Override // com.baidu.tieba.y39.b
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.b != null) {
                this.a.b.x(new int[]{10, 34});
            }
        }

        @Override // com.baidu.tieba.y39.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (this.a.b != null) {
                    this.a.b.i();
                }
                n49 n49Var = this.a;
                n49Var.y(n49Var.d);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n49(TbPageContext tbPageContext, o69 o69Var) {
        super(tbPageContext, o59.class);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, o69Var};
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
        this.i = o69Var;
        o69Var.c(this);
    }

    @Override // com.baidu.tieba.d59
    public void c(WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, writeData) == null) {
            this.i.d(writeData);
        }
    }

    @Override // com.baidu.tieba.b59
    public void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            u(str);
        }
    }

    @Override // com.baidu.tieba.b59
    public void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            u(str);
        }
    }

    @Override // com.baidu.tieba.d59
    public void onChangeSkinType(int i) {
        y39 y39Var;
        x39 x39Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) && (y39Var = this.h) != null && (x39Var = y39Var.d) != null) {
            x39Var.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.y49, com.baidu.tieba.d59
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            this.i.n(bundle);
        }
    }

    @Override // com.baidu.tieba.b59
    public void u(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048589, this, str) != null) || this.e == null) {
            return;
        }
        F(str);
    }

    @Override // com.baidu.tieba.b59
    public void v(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048590, this, str) != null) || this.e == null) {
            return;
        }
        F(str);
    }

    public final void F(String str) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && str != null && this.b != null && this.h != null && this.e != null) {
            this.i.f().parseJson(str);
            this.i.f().updateQuality();
            this.h.u(this.i.f(), this.e.getFrom(), this.e.getForumId());
            o59 o59Var = (o59) this.d;
            if (this.h.o().getVisibility() == 0) {
                z = true;
            } else {
                z = false;
            }
            o59Var.a = z;
            y(this.d);
            this.b.w();
            this.b.i();
        }
    }

    @Override // com.baidu.tieba.y49, com.baidu.tieba.d59
    public void r(l55 l55Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, l55Var) == null) {
            super.r(l55Var);
            if (this.b != null && this.e != null && this.h != null && l55Var.a == 24) {
                Object obj = l55Var.c;
                if (!(obj instanceof j15)) {
                    return;
                }
                j15 j15Var = (j15) obj;
                if (EmotionGroupType.isSendAsPic(j15Var.getType()) && this.i.b(this.b, j15Var) != null) {
                    this.b.i();
                    this.b.x(new int[]{10, 34});
                    this.h.u(this.i.f(), this.e.getFrom(), this.e.getForumId());
                }
            }
        }
    }

    @Override // com.baidu.tieba.d59
    public void a(WriteData writeData) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, writeData) == null) && this.h != null && writeData.getWriteImagesInfo() != null) {
            this.i.q(writeData.getWriteImagesInfo());
            WriteData writeData2 = this.e;
            if (writeData2 != null) {
                writeData2.setWriteImagesInfo(writeData.getWriteImagesInfo());
                this.h.u(this.i.f(), this.e.getFrom(), this.e.getForumId());
            }
            o59 o59Var = (o59) this.d;
            if (this.h.o().getVisibility() == 0) {
                z = true;
            } else {
                z = false;
            }
            o59Var.a = z;
            y(this.d);
        }
    }

    @Override // com.baidu.tieba.y49, com.baidu.tieba.d59
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.d();
            this.i.p(this);
            y39 y39Var = this.h;
            if (y39Var != null) {
                y39Var.n();
            }
        }
    }

    @Override // com.baidu.tieba.y49, com.baidu.tieba.d59
    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            WriteImageGridView writeImageGridView = this.g;
            if (writeImageGridView != null && writeImageGridView.getVisibility() == 0 && this.i.f().size() > 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.y49, com.baidu.tieba.d59
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048583, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            this.i.l(i, i2, intent);
        }
    }

    @Override // com.baidu.tieba.d59
    public View s(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d04a1, viewGroup, false);
            this.c = inflate;
            this.g = (WriteImageGridView) inflate.findViewById(R.id.obfuscated_res_0x7f09269c);
            y39 y39Var = new y39(this.a, this.c);
            this.h = y39Var;
            y39Var.r(this.j);
            WriteData writeData = this.e;
            if (writeData != null) {
                this.h.q(writeData.getDisableAudioMessage(), this.e.getFirstDir(), this.e.getSecondDir(), this.e.getPrefixData(), this.e.getStatisticFrom(), this.e.isVoiceEnable());
                if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.e.getFrom())) {
                    this.h.s(false);
                } else {
                    this.h.t(true);
                }
                if (this.e.getType() == 14) {
                    this.h.p(true);
                }
            }
            this.h.u(this.i.f(), this.e.getFrom(), this.e.getForumId());
            return this.c;
        }
        return (View) invokeL.objValue;
    }
}
