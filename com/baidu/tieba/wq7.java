package com.baidu.tieba;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.memberCenter.tail.data.TailData;
import com.baidu.tieba.memberCenter.tail.message.GetTailsHttpResponseMessage;
import com.baidu.tieba.memberCenter.tail.message.GetTailsNetMessage;
import com.baidu.tieba.memberCenter.tail.message.GetTailsSocketResponseMessage;
import com.baidu.tieba.memberCenter.tail.message.SetTailHttpResponseMessage;
import com.baidu.tieba.memberCenter.tail.message.SetTailNetMessage;
import com.baidu.tieba.memberCenter.tail.message.SetTailSocketResponseMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public class wq7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public yq7<zp7> a;
    public yq7<Integer> b;
    public List<TailData> c;
    public Boolean d;
    public boolean e;
    public qb f;
    public qb g;
    public CustomMessageListener h;

    /* loaded from: classes6.dex */
    public class a extends qb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wq7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(wq7 wq7Var, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wq7Var, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wq7Var;
        }

        @Override // com.baidu.tieba.qb
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) && this.a.a != null) {
                zp7 zp7Var = null;
                if (responsedMessage instanceof GetTailsHttpResponseMessage) {
                    zp7Var = ((GetTailsHttpResponseMessage) responsedMessage).getResultData();
                } else if (responsedMessage instanceof GetTailsSocketResponseMessage) {
                    zp7Var = ((GetTailsSocketResponseMessage) responsedMessage).getResultData();
                }
                if (zp7Var == null) {
                    return;
                }
                this.a.c = new ArrayList();
                if (zp7Var.c() != null) {
                    for (TailData tailData : zp7Var.c()) {
                        TailData tailData2 = new TailData();
                        tailData2.setId(tailData.getId());
                        tailData2.setContent(tailData.getContent());
                        tailData2.setFontColor(tailData.getFontColor());
                        tailData2.setFontType(tailData.getFontType());
                        tailData2.setSelected(tailData.isSelected());
                        this.a.c.add(tailData2);
                    }
                }
                this.a.a.a(responsedMessage.hasError(), responsedMessage.getErrorString(), zp7Var);
                this.a.q();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends qb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wq7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(wq7 wq7Var, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wq7Var, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wq7Var;
        }

        @Override // com.baidu.tieba.qb
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            bq7 bq7Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) && this.a.a != null) {
                Integer num = null;
                if (responsedMessage instanceof SetTailHttpResponseMessage) {
                    bq7Var = ((SetTailHttpResponseMessage) responsedMessage).getResultData();
                } else if (responsedMessage instanceof SetTailSocketResponseMessage) {
                    bq7Var = ((SetTailSocketResponseMessage) responsedMessage).getResultData();
                } else {
                    bq7Var = null;
                }
                if (bq7Var != null) {
                    num = Integer.valueOf(bq7Var.a());
                }
                this.a.b.a(responsedMessage.hasError(), responsedMessage.getErrorString(), num);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wq7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(wq7 wq7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wq7Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wq7Var;
        }

        public final void a(aq7 aq7Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aq7Var) == null) {
                boolean z = false;
                int i = 0;
                while (true) {
                    if (i >= this.a.c.size()) {
                        break;
                    } else if (((TailData) this.a.c.get(i)).getId() == aq7Var.b.getId()) {
                        z = true;
                        break;
                    } else {
                        i++;
                    }
                }
                if (!z) {
                    this.a.c.add(aq7Var.b);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048579, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof aq7)) {
                aq7 aq7Var = (aq7) customResponsedMessage.getData();
                if (aq7Var.b != null && this.a.c != null) {
                    int i = aq7Var.a;
                    if (i == 1) {
                        a(aq7Var);
                    } else if (i == 3) {
                        b(aq7Var);
                    } else if (i == 2) {
                        c(aq7Var);
                    }
                    this.a.a.a(customResponsedMessage.hasError(), customResponsedMessage.getErrorString(), null);
                }
            }
        }

        public final void b(aq7 aq7Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aq7Var) == null) {
                boolean z = false;
                for (int i = 0; i < this.a.c.size(); i++) {
                    if (((TailData) this.a.c.get(i)).getId() == aq7Var.b.getId()) {
                        this.a.c.remove(i);
                        if (this.a.c.size() != 0) {
                            Iterator it = this.a.c.iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    if (((TailData) it.next()).isSelected()) {
                                        z = true;
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            }
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001344, Boolean.valueOf(z)));
                        return;
                    }
                }
            }
        }

        public final void c(aq7 aq7Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aq7Var) == null) {
                for (int i = 0; i < this.a.c.size(); i++) {
                    if (((TailData) this.a.c.get(i)).getId() == aq7Var.b.getId()) {
                        ((TailData) this.a.c.get(i)).setContent(aq7Var.b.getContent());
                        ((TailData) this.a.c.get(i)).setFontColor(aq7Var.b.getFontColor());
                        ((TailData) this.a.c.get(i)).setSelected(aq7Var.b.isSelected());
                        return;
                    }
                }
            }
        }
    }

    public wq7(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = Boolean.FALSE;
        this.e = false;
        this.f = new a(this, CmdConfigHttp.CMD_TAIL_GET, 305001);
        this.g = new b(this, CmdConfigHttp.CMD_TAIL_SET, 305104);
        this.h = new c(this, 2001340);
        this.c = new ArrayList();
        f();
    }

    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.e = z;
        }
    }

    public void n(yq7<Integer> yq7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, yq7Var) == null) {
            this.b = yq7Var;
        }
    }

    public void p(yq7<zp7> yq7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, yq7Var) == null) {
            this.a = yq7Var;
        }
    }

    public void o(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            MessageManager.getInstance().sendMessage(new SetTailNetMessage(i, z ? 1 : 0));
        }
    }

    public final void f() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (TbadkCoreApplication.getCurrentMemberType() != 0) {
                z = true;
            } else {
                z = false;
            }
            this.d = Boolean.valueOf(z);
        }
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.d.booleanValue();
        }
        return invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.e;
        }
        return invokeV.booleanValue;
    }

    public List<TailData> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.c;
        }
        return (List) invokeV.objValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            MessageManager.getInstance().sendMessage(new GetTailsNetMessage("stat"));
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            MessageManager.getInstance().registerListener(this.f);
            MessageManager.getInstance().registerListener(this.g);
            MessageManager.getInstance().registerListener(this.h);
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.f);
            MessageManager.getInstance().unRegisterListener(this.g);
            MessageManager.getInstance().unRegisterListener(this.h);
        }
    }

    public final void q() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            Iterator<TailData> it = this.c.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().isSelected()) {
                        z = true;
                        break;
                    }
                } else {
                    z = false;
                    break;
                }
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001344, Boolean.valueOf(z)));
        }
    }
}
