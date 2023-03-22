package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.lego.card.exception.CardParseException;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class j38 extends l38 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<l38> c;

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    @Override // com.baidu.tieba.l38
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    @Override // com.baidu.tieba.l38
    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "lego_main" : (String) invokeV.objValue;
    }

    /* loaded from: classes5.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final j38 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-738752548, "Lcom/baidu/tieba/j38$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-738752548, "Lcom/baidu/tieba/j38$b;");
                    return;
                }
            }
            a = new j38(null);
        }
    }

    public j38() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = new ArrayList(4);
    }

    public static j38 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return b.a;
        }
        return (j38) invokeV.objValue;
    }

    public /* synthetic */ j38(a aVar) {
        this();
    }

    public static ICardInfo j(JSONObject jSONObject) throws CardParseException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject)) == null) {
            return h().b(jSONObject, jSONObject.optInt("card_type"));
        }
        return (ICardInfo) invokeL.objValue;
    }

    public synchronized void g(l38 l38Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, l38Var) == null) {
            synchronized (this) {
                this.c.add(l38Var);
            }
        }
    }

    public static ICardInfo i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            try {
                ICardInfo j = j(new JSONObject(str));
                if (j != null) {
                    if (j.isValid()) {
                        return j;
                    }
                }
                return null;
            } catch (CardParseException e) {
                BdLog.detailException("CardFactory.getPageCardInfo", e);
                return null;
            } catch (JSONException e2) {
                BdLog.detailException("CardFactory.getPageCardInfo", e2);
                return null;
            }
        }
        return (ICardInfo) invokeL.objValue;
    }

    @Override // com.baidu.tieba.l38
    public <T> e48 a(TbPageContext<T> tbPageContext, ICardInfo iCardInfo, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048576, this, tbPageContext, iCardInfo, i)) == null) {
            e48 e = e(tbPageContext, iCardInfo, i);
            if (e != null) {
                e.setBusinessType(i);
            }
            return e;
        }
        return (e48) invokeLLI.objValue;
    }

    @Override // com.baidu.tieba.l38
    public ICardInfo b(JSONObject jSONObject, int i) throws CardParseException {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject, i)) == null) {
            return f(jSONObject, i);
        }
        return (ICardInfo) invokeLI.objValue;
    }

    public final <T> e48 e(TbPageContext<T> tbPageContext, ICardInfo iCardInfo, int i) {
        InterceptResult invokeLLI;
        int cardType;
        e48 a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048580, this, tbPageContext, iCardInfo, i)) == null) {
            for (l38 l38Var : this.c) {
                try {
                    a2 = l38Var.a(tbPageContext, iCardInfo, i);
                } catch (Throwable th) {
                    BdLog.detailException("factory <" + l38Var.d() + "> respond exception", th);
                }
                if (a2 != null) {
                    return a2;
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("No card factory for card type ");
            if (iCardInfo == null) {
                cardType = -1;
            } else {
                cardType = iCardInfo.getCardType();
            }
            sb.append(cardType);
            BdLog.e(sb.toString());
            return null;
        }
        return (e48) invokeLLI.objValue;
    }

    public final ICardInfo f(JSONObject jSONObject, int i) throws CardParseException {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, jSONObject, i)) == null) {
            for (l38 l38Var : this.c) {
                try {
                    ICardInfo b2 = l38Var.b(jSONObject, i);
                    if (b2 != null) {
                        return b2;
                    }
                } catch (Throwable th) {
                    throw new CardParseException("Card type " + i + ", factory <" + l38Var.d() + "> respond exception", th);
                }
            }
            BdLog.e("No card factory for card type " + i);
            return null;
        }
        return (ICardInfo) invokeLI.objValue;
    }
}
