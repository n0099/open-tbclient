package com.baidu.tieba.immessagecenter.chatgroup.floatentrance;

import androidx.annotation.NonNull;
import com.baidu.searchbox.network.outback.EngineName;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class CollapseState implements Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Icon a;
    public State b;
    public Tip c;
    public long d;
    public String e;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes4.dex */
    public static final class Icon {
        public static final /* synthetic */ Icon[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final Icon DEFAULT;
        public static final Icon FORUM;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1386524376, "Lcom/baidu/tieba/immessagecenter/chatgroup/floatentrance/CollapseState$Icon;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1386524376, "Lcom/baidu/tieba/immessagecenter/chatgroup/floatentrance/CollapseState$Icon;");
                    return;
                }
            }
            DEFAULT = new Icon(EngineName.DEFAULT_ENGINE, 0);
            Icon icon = new Icon("FORUM", 1);
            FORUM = icon;
            $VALUES = new Icon[]{DEFAULT, icon};
        }

        public Icon(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static Icon valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (Icon) Enum.valueOf(Icon.class, str);
            }
            return (Icon) invokeL.objValue;
        }

        public static Icon[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (Icon[]) $VALUES.clone();
            }
            return (Icon[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes4.dex */
    public static final class State {
        public static final /* synthetic */ State[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final State COLLAPSE;
        public static final State EXPAND;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(334164116, "Lcom/baidu/tieba/immessagecenter/chatgroup/floatentrance/CollapseState$State;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(334164116, "Lcom/baidu/tieba/immessagecenter/chatgroup/floatentrance/CollapseState$State;");
                    return;
                }
            }
            COLLAPSE = new State("COLLAPSE", 0);
            State state = new State("EXPAND", 1);
            EXPAND = state;
            $VALUES = new State[]{COLLAPSE, state};
        }

        public State(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static State valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (State) Enum.valueOf(State.class, str);
            }
            return (State) invokeL.objValue;
        }

        public static State[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (State[]) $VALUES.clone();
            }
            return (State[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes4.dex */
    public static final class Tip {
        public static final /* synthetic */ Tip[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final Tip AT_ME;
        public static final Tip DEFAULT;
        public static final Tip THREE_EXP;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(183607370, "Lcom/baidu/tieba/immessagecenter/chatgroup/floatentrance/CollapseState$Tip;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(183607370, "Lcom/baidu/tieba/immessagecenter/chatgroup/floatentrance/CollapseState$Tip;");
                    return;
                }
            }
            DEFAULT = new Tip(EngineName.DEFAULT_ENGINE, 0);
            AT_ME = new Tip("AT_ME", 1);
            Tip tip = new Tip("THREE_EXP", 2);
            THREE_EXP = tip;
            $VALUES = new Tip[]{DEFAULT, AT_ME, tip};
        }

        public Tip(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static Tip valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (Tip) Enum.valueOf(Tip.class, str);
            }
            return (Tip) invokeL.objValue;
        }

        public static Tip[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (Tip[]) $VALUES.clone();
            }
            return (Tip[]) invokeV.objValue;
        }
    }

    public CollapseState() {
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
        this.a = Icon.DEFAULT;
        this.b = State.EXPAND;
        this.c = Tip.DEFAULT;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @NonNull
    /* renamed from: a */
    public CollapseState clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            CollapseState collapseState = new CollapseState();
            collapseState.b = this.b;
            collapseState.a = this.a;
            collapseState.c = this.c;
            collapseState.d = this.d;
            collapseState.e = this.e;
            return collapseState;
        }
        return (CollapseState) invokeV.objValue;
    }
}
