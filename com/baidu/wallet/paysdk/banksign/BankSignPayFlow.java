package com.baidu.wallet.paysdk.banksign;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.inner.util.log.ActLog;
/* loaded from: classes13.dex */
public class BankSignPayFlow {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Action a;

    /* renamed from: b  reason: collision with root package name */
    public com.baidu.wallet.paysdk.banksign.a f53954b;

    /* renamed from: com.baidu.wallet.paysdk.banksign.BankSignPayFlow$1  reason: invalid class name */
    /* loaded from: classes13.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1440499950, "Lcom/baidu/wallet/paysdk/banksign/BankSignPayFlow$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1440499950, "Lcom/baidu/wallet/paysdk/banksign/BankSignPayFlow$1;");
                    return;
                }
            }
            int[] iArr = new int[Action.values().length];
            a = iArr;
            try {
                iArr[Action.ShowGuide.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[Action.Fail.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[Action.Unknown.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[Action.JumpResign.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[Action.Pay.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[Action.BindCard.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[Action.Cancel.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[Action.FirstFail.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[Action.ChangePayType.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes13.dex */
    public static final class Action {
        public static final /* synthetic */ Action[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final Action BindCard;
        public static final Action Cancel;
        public static final Action ChangePayType;
        public static final Action Fail;
        public static final Action FirstFail;
        public static final Action JumpResign;
        public static final Action Null;
        public static final Action Pay;
        public static final Action ShowGuide;
        public static final Action Unknown;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(847741117, "Lcom/baidu/wallet/paysdk/banksign/BankSignPayFlow$Action;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(847741117, "Lcom/baidu/wallet/paysdk/banksign/BankSignPayFlow$Action;");
                    return;
                }
            }
            Null = new Action("Null", 0);
            ShowGuide = new Action("ShowGuide", 1);
            FirstFail = new Action("FirstFail", 2);
            Fail = new Action(ActLog.TYPE_FAIL, 3);
            Unknown = new Action("Unknown", 4);
            JumpResign = new Action("JumpResign", 5);
            Pay = new Action("Pay", 6);
            Cancel = new Action("Cancel", 7);
            ChangePayType = new Action("ChangePayType", 8);
            Action action = new Action("BindCard", 9);
            BindCard = action;
            $VALUES = new Action[]{Null, ShowGuide, FirstFail, Fail, Unknown, JumpResign, Pay, Cancel, ChangePayType, action};
        }

        public Action(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static Action valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (Action) Enum.valueOf(Action.class, str) : (Action) invokeL.objValue;
        }

        public static Action[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (Action[]) $VALUES.clone() : (Action[]) invokeV.objValue;
        }
    }

    /* loaded from: classes13.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static BankSignPayFlow a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1440498462, "Lcom/baidu/wallet/paysdk/banksign/BankSignPayFlow$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1440498462, "Lcom/baidu/wallet/paysdk/banksign/BankSignPayFlow$a;");
                    return;
                }
            }
            a = new BankSignPayFlow(null);
        }
    }

    public /* synthetic */ BankSignPayFlow(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static BankSignPayFlow a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? a.a : (BankSignPayFlow) invokeV.objValue;
    }

    public BankSignPayFlow() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = Action.Null;
        this.f53954b = new b();
    }

    public void a(Action action) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, action) == null) {
            if (action == null) {
                action = Action.Null;
            }
            this.a = action;
        }
    }

    public void a(Context context) {
        Action action;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, context) == null) || this.f53954b == null || (action = this.a) == null || Action.Null == action) {
            return;
        }
        switch (AnonymousClass1.a[action.ordinal()]) {
            case 1:
                this.f53954b.e(context);
                return;
            case 2:
            case 3:
            case 4:
                this.f53954b.b(context);
                return;
            case 5:
                this.f53954b.a();
                return;
            case 6:
                this.f53954b.c(context);
                this.a = Action.Cancel;
                return;
            case 7:
            case 8:
                this.f53954b.a(context);
                return;
            case 9:
                this.f53954b.d(context);
                this.a = Action.Cancel;
                return;
            default:
                return;
        }
    }
}
