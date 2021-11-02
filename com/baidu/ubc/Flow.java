package com.baidu.ubc;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class Flow implements Parcelable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Parcelable.Creator<Flow> CREATOR;
    public static final int INVALID_HANDLE = -1;
    public transient /* synthetic */ FieldHolder $fh;
    public int mHandle;
    public boolean mHasEnd;
    public String mId;
    public int mOption;
    public HashMap<String, Slot> mSlotMaps;
    public long mStartTime;
    public boolean mValid;

    /* loaded from: classes10.dex */
    public static class a implements Parcelable.Creator<Flow> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public Flow createFromParcel(Parcel parcel) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, parcel)) == null) ? new Flow(parcel) : (Flow) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public Flow[] newArray(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? new Flow[i2] : (Flow[]) invokeI.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1362844038, "Lcom/baidu/ubc/Flow;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1362844038, "Lcom/baidu/ubc/Flow;");
                return;
            }
        }
        CREATOR = new a();
    }

    public Flow() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mValid = true;
        this.mHasEnd = false;
        this.mId = "";
        this.mHandle = -1;
        this.mOption = 0;
        this.mStartTime = System.currentTimeMillis();
        this.mSlotMaps = new HashMap<>();
    }

    @Deprecated
    public final void addEvent(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            addEvent(str, null);
        }
    }

    @Deprecated
    public final void cancel() {
        UBCManager uBCManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (uBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)) == null) {
            return;
        }
        uBCManager.flowCancel(this);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Deprecated
    public final void end() {
        UBCManager uBCManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (uBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)) == null) {
            return;
        }
        uBCManager.flowEnd(this);
    }

    @Deprecated
    public final void endSlot(String str) {
        UBCManager uBCManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || (uBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)) == null) {
            return;
        }
        uBCManager.flowEndSlot(this, str);
    }

    public int getHandle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mHandle : invokeV.intValue;
    }

    public String getId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mId : (String) invokeV.objValue;
    }

    public int getOption() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mOption : invokeV.intValue;
    }

    public HashMap<String, Slot> getSlotMaps() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mSlotMaps : (HashMap) invokeV.objValue;
    }

    public long getStartTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mStartTime : invokeV.longValue;
    }

    public boolean getValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mValid : invokeV.booleanValue;
    }

    public boolean hasEnd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.mHasEnd : invokeV.booleanValue;
    }

    public void markEnd() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.mHasEnd = true;
        }
    }

    public void setValid(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.mValid = z;
        }
    }

    @Deprecated
    public final void setValue(String str) {
        UBCManager uBCManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, str) == null) || (uBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)) == null) {
            return;
        }
        uBCManager.flowSetValue(this, str);
    }

    @Deprecated
    public void setValueWithDuration(String str) {
        UBCManager uBCManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, str) == null) || (uBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)) == null) {
            return;
        }
        uBCManager.flowSetValueWithDuration(this, str);
    }

    @Deprecated
    public final void startSlot(String str, JSONObject jSONObject) {
        UBCManager uBCManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048595, this, str, jSONObject) == null) || (uBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)) == null) {
            return;
        }
        uBCManager.flowStartSlot(this, str, jSONObject);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048596, this, parcel, i2) == null) {
            parcel.writeString(this.mId);
            parcel.writeInt(this.mHandle);
            parcel.writeInt(this.mOption);
            parcel.writeLong(this.mStartTime);
            parcel.writeByte(this.mValid ? (byte) 1 : (byte) 0);
            parcel.writeMap(this.mSlotMaps);
        }
    }

    @Deprecated
    public final void addEvent(String str, String str2) {
        UBCManager uBCManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) || (uBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)) == null) {
            return;
        }
        uBCManager.flowAddEvent(this, str, str2);
    }

    @Deprecated
    public void setValue(Map<String, String> map) {
        UBCManager uBCManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, map) == null) || (uBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)) == null) {
            return;
        }
        uBCManager.flowSetValue(this, map);
    }

    @Deprecated
    public final void addEvent(String str, String str2, long j) {
        UBCManager uBCManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, str2, Long.valueOf(j)}) == null) || (uBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)) == null) {
            return;
        }
        uBCManager.flowAddEventWithDate(this, str, str2, j);
    }

    public Flow(String str, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.mValid = true;
        this.mHasEnd = false;
        this.mId = str;
        this.mHandle = i2;
        this.mOption = i3;
        this.mStartTime = System.currentTimeMillis();
        this.mSlotMaps = new HashMap<>();
    }

    public Flow(Parcel parcel) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {parcel};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mValid = true;
        this.mHasEnd = false;
        this.mId = parcel.readString();
        this.mHandle = parcel.readInt();
        this.mOption = parcel.readInt();
        this.mStartTime = parcel.readLong();
        this.mValid = parcel.readByte() != 0;
        this.mSlotMaps = parcel.readHashMap(Flow.class.getClassLoader());
    }
}
