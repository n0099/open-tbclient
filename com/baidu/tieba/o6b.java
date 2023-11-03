package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import tbclient.FrsPage.HeadCardCover;
import tbclient.FrsPage.HeaderCard;
import tbclient.QuizCard;
import tbclient.ThemeColorInfo;
import tbclient.ThreadInfo;
/* loaded from: classes7.dex */
public final class o6b implements oi {
    public static /* synthetic */ Interceptable $ic;
    @JvmField
    public static final BdUniqueId f;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public List<ThreadInfo> b;
    public ThemeColorInfo c;
    public m6b d;
    public n6b e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947985614, "Lcom/baidu/tieba/o6b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947985614, "Lcom/baidu/tieba/o6b;");
                return;
            }
        }
        BdUniqueId gen = BdUniqueId.gen();
        Intrinsics.checkNotNullExpressionValue(gen, "gen()");
        f = gen;
    }

    public o6b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public final ThemeColorInfo a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.c;
        }
        return (ThemeColorInfo) invokeV.objValue;
    }

    public final String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.a;
        }
        return (String) invokeV.objValue;
    }

    public final m6b c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.d;
        }
        return (m6b) invokeV.objValue;
    }

    public final n6b d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.e;
        }
        return (n6b) invokeV.objValue;
    }

    public final List<ThreadInfo> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.b;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.tieba.oi
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return f;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public final void f(HeaderCard headerCard) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, headerCard) != null) || headerCard == null) {
            return;
        }
        this.a = headerCard.card_title;
        this.b = headerCard.thread_list;
        QuizCard quizCard = headerCard.quiz_card;
        if (quizCard != null) {
            n6b n6bVar = new n6b();
            this.e = n6bVar;
            if (n6bVar != null) {
                n6bVar.h(quizCard);
            }
        }
        this.c = headerCard.card_background;
        HeadCardCover headCardCover = headerCard.cover;
        if (headCardCover != null) {
            m6b m6bVar = new m6b();
            this.d = m6bVar;
            if (m6bVar != null) {
                m6bVar.d(headCardCover);
            }
        }
    }

    public final void g(tbclient.Personalized.HeaderCard headerCard) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, headerCard) != null) || headerCard == null) {
            return;
        }
        this.a = headerCard.card_title;
        this.b = headerCard.thread_list;
        QuizCard quizCard = headerCard.quiz_card;
        if (quizCard != null) {
            n6b n6bVar = new n6b();
            this.e = n6bVar;
            if (n6bVar != null) {
                n6bVar.h(quizCard);
            }
        }
        this.c = headerCard.card_background;
        tbclient.Personalized.HeadCardCover headCardCover = headerCard.cover;
        if (headCardCover != null) {
            m6b m6bVar = new m6b();
            this.d = m6bVar;
            if (m6bVar != null) {
                m6bVar.e(headCardCover);
            }
        }
    }
}
