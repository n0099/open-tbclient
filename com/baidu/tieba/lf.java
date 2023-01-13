package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.tieba.mf;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public abstract class lf {
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
    public mf.a mSwitchListener;

    public abstract void changeSettingByType(int i);

    public abstract String[] getCrashKeys();

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

    /* loaded from: classes5.dex */
    public class a implements mf.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lf a;

        public a(lf lfVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lfVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lfVar;
        }

        @Override // com.baidu.tieba.mf.a
        public void a(String str, int i, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{str, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
                this.a.changeSettingByType(i);
            }
        }
    }

    public lf() {
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
            mf mfVar = new mf(this.mName, this.mDefaultType, this.mSwitchListener);
            mfVar.i(this.mMaxCrashTimes, this.mKey, this.mOffType);
            mfVar.j(getSwitchLibs());
            SwitchManager.getInstance().addSwitchData(mfVar);
        }
    }

    public void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.mName = getName();
            this.mKey = getCrashKeys();
            this.mDefaultType = getDefaultType();
            this.mOffType = getOffType();
            this.mMaxCrashTimes = getMaxCrashTimes();
        }
    }
}
