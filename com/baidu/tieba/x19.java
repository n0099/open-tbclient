package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.memberCenter.tail.data.TailData;
import com.baidu.tieba.memberCenter.tail.data.TailDataList;
import com.baidu.tieba.memberCenter.tail.message.DeleteTailHttpResponseMessage;
import com.baidu.tieba.memberCenter.tail.message.DeleteTailNetMessage;
import com.baidu.tieba.memberCenter.tail.message.DeleteTailSocketResponseMessage;
import com.baidu.tieba.memberCenter.tail.message.GetTailsHttpResponseMessage;
import com.baidu.tieba.memberCenter.tail.message.GetTailsNetMessage;
import com.baidu.tieba.memberCenter.tail.message.GetTailsSocketResponseMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes8.dex */
public class x19 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public boolean b;
    public List<TailData> c;
    public i29<Void> d;
    public i29<Integer> e;
    public kb f;
    public kb g;
    public CustomMessageListener h;

    /* loaded from: classes8.dex */
    public class a extends kb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x19 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(x19 x19Var, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x19Var, Integer.valueOf(i), Integer.valueOf(i2)};
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
            this.a = x19Var;
        }

        @Override // com.baidu.tieba.kb
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            j19 j19Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) && this.a.d != null) {
                if (responsedMessage instanceof GetTailsHttpResponseMessage) {
                    j19Var = ((GetTailsHttpResponseMessage) responsedMessage).getResultData();
                } else if (responsedMessage instanceof GetTailsSocketResponseMessage) {
                    j19Var = ((GetTailsSocketResponseMessage) responsedMessage).getResultData();
                } else {
                    j19Var = null;
                }
                if (j19Var != null) {
                    this.a.c = j19Var.c();
                }
                this.a.d.a(responsedMessage.hasError(), responsedMessage.getErrorString(), null);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends kb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x19 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(x19 x19Var, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x19Var, Integer.valueOf(i), Integer.valueOf(i2)};
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
            this.a = x19Var;
        }

        @Override // com.baidu.tieba.kb
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            i19 i19Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) && this.a.e != null) {
                Integer num = null;
                if (responsedMessage instanceof DeleteTailHttpResponseMessage) {
                    i19Var = ((DeleteTailHttpResponseMessage) responsedMessage).getResultData();
                } else if (responsedMessage instanceof DeleteTailSocketResponseMessage) {
                    i19Var = ((DeleteTailSocketResponseMessage) responsedMessage).getResultData();
                } else {
                    i19Var = null;
                }
                if (i19Var != null) {
                    num = Integer.valueOf(i19Var.a());
                }
                this.a.e.a(responsedMessage.hasError(), responsedMessage.getErrorString(), num);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x19 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(x19 x19Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x19Var, Integer.valueOf(i)};
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
            this.a = x19Var;
        }

        public final void a(k19 k19Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, k19Var) == null) {
                boolean z = false;
                int i = 0;
                while (true) {
                    if (i >= this.a.c.size()) {
                        break;
                    } else if (((TailData) this.a.c.get(i)).getId() == k19Var.b.getId()) {
                        z = true;
                        break;
                    } else {
                        i++;
                    }
                }
                if (!z) {
                    this.a.c.add(k19Var.b);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048579, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof k19) && this.a.d != null) {
                k19 k19Var = (k19) customResponsedMessage.getData();
                if (k19Var.b != null && this.a.c != null) {
                    int i = k19Var.a;
                    if (i == 1) {
                        a(k19Var);
                    } else if (i == 3) {
                        b(k19Var);
                    } else if (i == 2) {
                        c(k19Var);
                    }
                    this.a.d.a(customResponsedMessage.hasError(), customResponsedMessage.getErrorString(), null);
                }
            }
        }

        public final void b(k19 k19Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, k19Var) == null) {
                boolean z = false;
                for (int i = 0; i < this.a.c.size(); i++) {
                    if (((TailData) this.a.c.get(i)).getId() == k19Var.b.getId()) {
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

        public final void c(k19 k19Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, k19Var) == null) {
                for (int i = 0; i < this.a.c.size(); i++) {
                    if (((TailData) this.a.c.get(i)).getId() == k19Var.b.getId()) {
                        ((TailData) this.a.c.get(i)).setContent(k19Var.b.getContent());
                        ((TailData) this.a.c.get(i)).setFontColor(k19Var.b.getFontColor());
                        ((TailData) this.a.c.get(i)).setSelected(k19Var.b.isSelected());
                        return;
                    }
                }
            }
        }
    }

    public x19(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = false;
        this.f = new a(this, CmdConfigHttp.CMD_TAIL_GET, 305001);
        this.g = new b(this, CmdConfigHttp.CMD_TAIL_DELETE, 305103);
        this.h = new c(this, 2001340);
        this.a = tbPageContext;
        this.c = new ArrayList();
        this.a.registerListener(this.f);
        this.a.registerListener(this.g);
        this.a.registerListener(this.h);
    }

    public void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            this.a.sendMessage(new DeleteTailNetMessage(i));
        }
    }

    public boolean i(Serializable serializable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, serializable)) == null) {
            if (serializable != null && (serializable instanceof TailDataList)) {
                this.c = ((TailDataList) serializable).getTails();
                return true;
            }
            j();
            return false;
        }
        return invokeL.booleanValue;
    }

    public void k(i29<Integer> i29Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, i29Var) == null) {
            this.e = i29Var;
        }
    }

    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.b = z;
        }
    }

    public void m(i29<Void> i29Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i29Var) == null) {
            this.d = i29Var;
        }
    }

    public void n(List<TailData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            if (list == null) {
                this.c.clear();
            } else {
                this.c = list;
            }
        }
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 3 - this.c.size();
        }
        return invokeV.intValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.b;
        }
        return invokeV.booleanValue;
    }

    public List<TailData> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.c;
        }
        return (List) invokeV.objValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.a.sendMessage(new GetTailsNetMessage("stat"));
        }
    }
}
