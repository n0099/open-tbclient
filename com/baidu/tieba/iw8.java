package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.memberCenter.tail.data.TailData;
import com.baidu.tieba.memberCenter.tail.message.AddTailHttpResponseMessage;
import com.baidu.tieba.memberCenter.tail.message.AddTailNetMessage;
import com.baidu.tieba.memberCenter.tail.message.AddTailSocketResponseMessage;
import com.baidu.tieba.memberCenter.tail.message.SetTailNetMessage;
import com.baidu.tieba.memberCenter.tail.message.UpdateTailHttpResponseMessage;
import com.baidu.tieba.memberCenter.tail.message.UpdateTailNetMessage;
import com.baidu.tieba.memberCenter.tail.message.UpdateTailSocketResponseMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.regex.Pattern;
/* loaded from: classes6.dex */
public class iw8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public boolean b;
    public TailData c;
    public TailData d;
    public TbPageContext<?> e;
    public dx8<Integer> f;
    public dx8<Integer> g;
    public jb h;
    public jb i;

    public boolean l(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) ? i == 50 : invokeI.booleanValue;
    }

    public boolean m(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) ? i > 50 : invokeI.booleanValue;
    }

    /* loaded from: classes6.dex */
    public class a extends jb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iw8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(iw8 iw8Var, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iw8Var, Integer.valueOf(i), Integer.valueOf(i2)};
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
            this.a = iw8Var;
        }

        @Override // com.baidu.tieba.jb
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            cw8 cw8Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                this.a.a = false;
                if (this.a.f != null) {
                    Integer num = null;
                    if (responsedMessage instanceof AddTailHttpResponseMessage) {
                        cw8Var = ((AddTailHttpResponseMessage) responsedMessage).getResultData();
                    } else if (responsedMessage instanceof AddTailSocketResponseMessage) {
                        cw8Var = ((AddTailSocketResponseMessage) responsedMessage).getResultData();
                    } else {
                        cw8Var = null;
                    }
                    if (cw8Var != null) {
                        num = Integer.valueOf(cw8Var.a());
                        if (this.a.b) {
                            this.a.p(num.intValue());
                        }
                    }
                    this.a.f.a(responsedMessage.hasError(), responsedMessage.getErrorString(), num);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends jb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iw8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(iw8 iw8Var, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iw8Var, Integer.valueOf(i), Integer.valueOf(i2)};
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
            this.a = iw8Var;
        }

        @Override // com.baidu.tieba.jb
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            hw8 hw8Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                this.a.a = false;
                if (this.a.g != null) {
                    Integer num = null;
                    if (responsedMessage instanceof UpdateTailHttpResponseMessage) {
                        hw8Var = ((UpdateTailHttpResponseMessage) responsedMessage).getResultData();
                    } else if (responsedMessage instanceof UpdateTailSocketResponseMessage) {
                        hw8Var = ((UpdateTailSocketResponseMessage) responsedMessage).getResultData();
                    } else {
                        hw8Var = null;
                    }
                    if (hw8Var != null) {
                        num = Integer.valueOf(hw8Var.a());
                    }
                    this.a.g.a(responsedMessage.hasError(), responsedMessage.getErrorString(), num);
                }
            }
        }
    }

    public iw8(TbPageContext<?> tbPageContext) {
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
        this.a = false;
        this.b = false;
        this.h = new a(this, CmdConfigHttp.CMD_TAIL_ADD, 305101);
        this.i = new b(this, CmdConfigHttp.CMD_TAIL_UPDATE, 305102);
        this.e = tbPageContext;
        tbPageContext.registerListener(this.h);
        this.e.registerListener(this.i);
        this.d = new TailData();
    }

    public int e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            return Pattern.compile("#\\([^#\\)\\(]+\\)").matcher(str).replaceAll(" ").length();
        }
        return invokeL.intValue;
    }

    public String f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (str != null && str.length() > 0) {
                return str.substring(0, str.length() - 1);
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public String h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            while (e(str) > 50) {
                str = f(str);
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public void n(dx8<Integer> dx8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, dx8Var) == null) {
            this.f = dx8Var;
        }
    }

    public void o(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.d.setFontColor(str);
        }
    }

    public void p(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            MessageManager.getInstance().sendMessage(new SetTailNetMessage(i, 1));
        }
    }

    public void q(dx8<Integer> dx8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, dx8Var) == null) {
            this.g = dx8Var;
        }
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.d.getFontColor();
        }
        return (String) invokeV.objValue;
    }

    public TailData i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.d;
        }
        return (TailData) invokeV.objValue;
    }

    public void j(int i, String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), str, str2, Boolean.valueOf(z)}) == null) {
            TailData tailData = new TailData();
            this.d = tailData;
            if (i != 0) {
                TailData tailData2 = new TailData();
                this.c = tailData2;
                tailData2.setId(i);
                this.c.setContent(str);
                this.c.setFontColor(str2);
                this.d.setId(i);
                this.d.setContent(str);
                this.d.setFontColor(str2);
                return;
            }
            tailData.setContent("");
            this.d.setFontColor("7a7c80");
            this.b = z;
        }
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            TailData tailData = this.d;
            if (tailData != null && tailData.getFontColor() != null) {
                TailData tailData2 = this.c;
                if (tailData2 == null) {
                    if (!StringUtils.isNull(this.d.getContent()) || !this.d.getFontColor().equals("7a7c80")) {
                        return true;
                    }
                } else if (tailData2.getContent() != null && this.c.getFontColor() != null && (!this.c.getContent().equals(this.d.getContent()) || !this.c.getFontColor().equals(this.d.getFontColor()))) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void r(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048589, this, str) != null) || this.a) {
            return;
        }
        String f = gx8.f(str);
        if (!StringUtils.isNull(f)) {
            this.e.showToast(f);
            return;
        }
        String b2 = gx8.b(str);
        this.d.setContent(b2);
        this.a = true;
        TailData tailData = this.c;
        if (tailData != null && tailData.getId() > 0) {
            this.e.sendMessage(new UpdateTailNetMessage(this.c.getId(), b2, this.d.getFontColor(), this.e.getString(R.string.tail_default_font)));
        } else {
            this.e.sendMessage(new AddTailNetMessage(b2, this.d.getFontColor(), this.e.getString(R.string.tail_default_font)));
        }
    }

    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (StringUtils.isNull(this.d.getContent()) || !k() || !StringUtils.isNull(gx8.f(this.d.getContent()))) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }
}
