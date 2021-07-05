package com.baidu.tieba.imageProblem.httpNet;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.j;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class CdnCacheItem implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int TB_CDNCACHEITEM_ERROR = -1;
    public static final int TB_CDN_IP_DISABLE_TIME = 3600000;
    public static Object mDomainLock = null;
    public static Object mLock = null;
    public static final long serialVersionUID = 6622778689529331355L;
    public transient /* synthetic */ FieldHolder $fh;
    public int cdnDomainRank;
    public HashMap<String, Long> disableIpMap;
    public long firstUseIpTime;
    public String identifier;
    public int ipDisableTime;
    public HashMap<String, String> ipHashMap;
    public ArrayList<TBIPListItem> ipList;
    public boolean isUsedIp;
    public long lastTachometerTime;
    public int mobileCdnDomainRank;
    public ArrayList<TBIPListItem> mobileIpList;
    public boolean mobileIsUsedIp;
    public long mobileLastTachometerTime;

    /* renamed from: com.baidu.tieba.imageProblem.httpNet.CdnCacheItem$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1913689156, "Lcom/baidu/tieba/imageProblem/httpNet/CdnCacheItem;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1913689156, "Lcom/baidu/tieba/imageProblem/httpNet/CdnCacheItem;");
                return;
            }
        }
        mLock = new Object();
        mDomainLock = new Object();
    }

    public CdnCacheItem() {
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
        this.isUsedIp = false;
        this.ipList = null;
        this.lastTachometerTime = 0L;
        this.firstUseIpTime = 0L;
        this.identifier = null;
        this.cdnDomainRank = 0;
        this.mobileIpList = null;
        this.mobileCdnDomainRank = 0;
        this.mobileLastTachometerTime = 0L;
        this.ipList = new ArrayList<>();
        this.ipHashMap = new HashMap<>();
        this.mobileIpList = new ArrayList<>();
    }

    private int disableIpTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            int i2 = this.ipDisableTime;
            if (i2 < 0) {
                return 3600000;
            }
            return i2;
        }
        return invokeV.intValue;
    }

    private void setDisableIpMap() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65539, this) == null) && this.disableIpMap == null) {
            this.disableIpMap = new HashMap<>();
        }
    }

    public String getAllIpFromItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ArrayList<TBIPListItem> arrayList = this.ipList;
            if (arrayList == null || arrayList.size() == 0) {
                return null;
            }
            StringBuilder sb = new StringBuilder(50);
            int size = this.ipList.size();
            for (int i2 = 0; i2 < size; i2++) {
                sb.append(this.ipList.get(i2).cdnIp);
                sb.append(",");
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public String getIpString(int i2) {
        InterceptResult invokeI;
        ArrayList<TBIPListItem> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            if (!this.isUsedIp || (arrayList = this.ipList) == null || arrayList.size() == 0) {
                return null;
            }
            synchronized (mLock) {
                if (this.ipList != null && this.ipList.size() != 0) {
                    int size = i2 % this.ipList.size();
                    if (size >= this.ipList.size()) {
                        return null;
                    }
                    TBIPListItem tBIPListItem = this.ipList.get(size);
                    if (tBIPListItem == null) {
                        return null;
                    }
                    return tBIPListItem.cdnIp;
                }
                return null;
            }
        }
        return (String) invokeI.objValue;
    }

    public boolean getIsUsedIp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.isUsedIp : invokeV.booleanValue;
    }

    public String getMobileCdnIp(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            ArrayList<TBIPListItem> arrayList = this.mobileIpList;
            if (arrayList == null || arrayList.size() == 0) {
                return null;
            }
            synchronized (mLock) {
                if (this.mobileIpList != null && this.mobileIpList.size() != 0) {
                    int size = i2 % this.mobileIpList.size();
                    if (size >= this.mobileIpList.size()) {
                        return null;
                    }
                    TBIPListItem tBIPListItem = this.mobileIpList.get(size);
                    if (tBIPListItem == null) {
                        return null;
                    }
                    return tBIPListItem.cdnIp;
                }
                return null;
            }
        }
        return (String) invokeI.objValue;
    }

    public boolean hasImageProblem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? j.H() ? this.cdnDomainRank > 0 || this.isUsedIp : this.cdnDomainRank > 0 || this.mobileIsUsedIp : invokeV.booleanValue;
    }

    public boolean mobileIsUsedIp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mobileIsUsedIp : invokeV.booleanValue;
    }

    public int setCdnDomainRank(int i2, float f2) {
        InterceptResult invokeCommon;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)})) == null) {
            synchronized (mDomainLock) {
                int i4 = this.cdnDomainRank + i2;
                this.cdnDomainRank = i4;
                if (i4 < 0) {
                    this.cdnDomainRank = 0;
                }
                i3 = this.cdnDomainRank;
                if (this.cdnDomainRank > f2) {
                    this.cdnDomainRank = 0;
                    this.isUsedIp = true;
                }
            }
            return i3;
        }
        return invokeCommon.intValue;
    }

    public int setIPRank(int i2, float f2, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), str})) == null) {
            if (str == null) {
                return -1;
            }
            synchronized (mLock) {
                TBIPListItem tBIPListItem = null;
                int size = this.ipList.size();
                int i3 = 0;
                while (true) {
                    if (i3 >= size) {
                        i3 = 0;
                        break;
                    }
                    TBIPListItem tBIPListItem2 = this.ipList.get(i3);
                    if (str.equalsIgnoreCase(tBIPListItem2.cdnIp)) {
                        tBIPListItem = tBIPListItem2;
                        break;
                    }
                    i3++;
                }
                if (tBIPListItem == null) {
                    return -1;
                }
                int i4 = tBIPListItem.ipRank + i2;
                tBIPListItem.ipRank = i4;
                if (i4 >= f2) {
                    this.ipHashMap.remove(tBIPListItem.cdnIp);
                    this.ipList.remove(i3);
                    long currentTimeMillis = System.currentTimeMillis();
                    setDisableIpMap();
                    this.disableIpMap.put(tBIPListItem.cdnIp, Long.valueOf(currentTimeMillis));
                }
                if (tBIPListItem.ipRank < 0) {
                    tBIPListItem.ipRank = 0;
                }
                if (this.ipList.size() == 0) {
                    this.isUsedIp = false;
                }
                return tBIPListItem.ipRank;
            }
        }
        return invokeCommon.intValue;
    }

    public void setIpDisableTime(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.ipDisableTime = i2 * 1000;
        }
    }

    public void setIpList(ArrayList<String> arrayList, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{arrayList, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || arrayList == null || arrayList.size() == 0) {
            return;
        }
        synchronized (mLock) {
            setDisableIpMap();
            if (z2) {
                this.ipList.clear();
                this.ipHashMap.clear();
            }
            this.isUsedIp = z;
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                String str = arrayList.get(i2);
                Long l = this.disableIpMap.get(str);
                if (l != null && System.currentTimeMillis() - l.longValue() >= disableIpTime()) {
                    this.disableIpMap.remove(str);
                }
                if (this.ipHashMap.get(str) == null && this.disableIpMap.get(str) == null) {
                    TBIPListItem tBIPListItem = new TBIPListItem(this, null);
                    tBIPListItem.cdnIp = str;
                    this.ipList.add(tBIPListItem);
                    this.ipHashMap.put(str, "1");
                }
            }
        }
    }

    public void setMobileIpList(ArrayList<String> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, arrayList) == null) || arrayList == null || arrayList.size() == 0) {
            return;
        }
        synchronized (mLock) {
            this.mobileIpList.clear();
            TBIPListItem tBIPListItem = new TBIPListItem(this, null);
            tBIPListItem.cdnIp = "c.hiphotos.baidu.com";
            this.mobileIpList.add(tBIPListItem);
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                TBIPListItem tBIPListItem2 = new TBIPListItem(this, null);
                tBIPListItem2.cdnIp = arrayList.get(i2);
                this.mobileIpList.add(tBIPListItem2);
            }
        }
    }

    public int setMoblieIPRank(int i2, float f2, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), str})) == null) {
            synchronized (mLock) {
                if (str == null) {
                    int i3 = this.mobileCdnDomainRank + i2;
                    this.mobileCdnDomainRank = i3;
                    if (i3 < 0) {
                        this.mobileCdnDomainRank = 0;
                    }
                    int i4 = this.mobileCdnDomainRank;
                    if (this.mobileCdnDomainRank > f2) {
                        this.mobileCdnDomainRank = 0;
                        this.mobileIsUsedIp = true;
                    }
                    return i4;
                }
                TBIPListItem tBIPListItem = null;
                int size = this.mobileIpList.size();
                int i5 = 0;
                while (true) {
                    if (i5 >= size) {
                        i5 = 0;
                        break;
                    }
                    TBIPListItem tBIPListItem2 = this.mobileIpList.get(i5);
                    if (str.equalsIgnoreCase(tBIPListItem2.cdnIp)) {
                        tBIPListItem = tBIPListItem2;
                        break;
                    }
                    i5++;
                }
                if (tBIPListItem == null) {
                    return -1;
                }
                int i6 = tBIPListItem.ipRank + i2;
                tBIPListItem.ipRank = i6;
                if (i6 >= f2) {
                    this.mobileIpList.remove(i5);
                    this.mobileIsUsedIp = true;
                }
                if (tBIPListItem.ipRank < 0) {
                    tBIPListItem.ipRank = 0;
                }
                if (this.mobileIpList.size() == 0) {
                    this.mobileIsUsedIp = false;
                }
                return tBIPListItem.ipRank;
            }
        }
        return invokeCommon.intValue;
    }

    /* loaded from: classes5.dex */
    public class TBIPListItem implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -99289965442562023L;
        public transient /* synthetic */ FieldHolder $fh;
        public String cdnIp;
        public int ipRank;
        public final /* synthetic */ CdnCacheItem this$0;

        public TBIPListItem(CdnCacheItem cdnCacheItem) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cdnCacheItem};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = cdnCacheItem;
            this.ipRank = 0;
        }

        public /* synthetic */ TBIPListItem(CdnCacheItem cdnCacheItem, AnonymousClass1 anonymousClass1) {
            this(cdnCacheItem);
        }
    }
}
