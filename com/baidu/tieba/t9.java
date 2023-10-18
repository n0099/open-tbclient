package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.tieba.x9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public abstract class t9 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEF_CRASHTIME_LIMIT = 10;
    public static final int OFF_TYPE = 0;
    public static final int ON_TYPE = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public int mDefaultType;
    public String[] mKey;
    public int mMaxCrashTimes;
    public String mName;
    public int mOffType;
    public x9.a mSwitchListener;

    public abstract void changeSettingByType(int i);

    /* renamed from: getCrashKeys */
    public abstract String[] mo130getCrashKeys();

    public abstract int getDefaultType();

    public abstract int getMaxCrashTimes();

    public abstract String getName();

    public abstract int getOffType();

    public String[] getSwitchLibs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return null;
        }
        return (String[]) invokeV.objValue;
    }

    /* loaded from: classes8.dex */
    public class a implements x9.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t9 a;

        public a(t9 t9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t9Var;
        }

        @Override // com.baidu.tieba.x9.a
        public void a(String str, int i, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{str, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
                this.a.changeSettingByType(i);
            }
        }
    }

    public t9() {
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
        this.mDefaultType = 0;
        this.mOffType = 1;
        this.mMaxCrashTimes = 10;
        this.mSwitchListener = new a(this);
        initData();
        addToManager();
    }

    public void addToManager() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            x9 x9Var = new x9(this.mName, this.mDefaultType, this.mSwitchListener);
            x9Var.i(this.mMaxCrashTimes, this.mKey, this.mOffType);
            x9Var.j(getSwitchLibs());
            SwitchManager.getInstance().addSwitchData(x9Var);
        }
    }

    public void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.mName = getName();
            this.mKey = mo130getCrashKeys();
            this.mDefaultType = getDefaultType();
            this.mOffType = getOffType();
            this.mMaxCrashTimes = getMaxCrashTimes();
        }
    }
}
