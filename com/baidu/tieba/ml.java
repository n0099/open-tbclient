package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nps.pm.IBundleInfo;
import com.baidu.nps.pm.SubBundleInfo;
import com.baidu.searchbox.pms.bean.PackageInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdSdk;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class ml implements IBundleInfo {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PackageInfo a;
    public String b;
    public String c;
    public String d;
    public boolean e;
    public boolean f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;
    public List<SubBundleInfo> m;
    public List<String> n;
    public String o;

    @Override // com.baidu.nps.pm.IBundleInfo
    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public boolean isBroken() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public boolean isNeedRemove() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setAbi(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i) == null) {
        }
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setBroken(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048610, this, z) == null) {
        }
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setForbidden(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048616, this, z) == null) {
        }
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setForceUpdate(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048617, this, z) == null) {
        }
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setMinVersion(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048621, this, i) == null) {
        }
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setNeedRemove(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048623, this, z) == null) {
        }
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048634, this, i) == null) {
        }
    }

    public ml(PackageInfo packageInfo) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {packageInfo};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = true;
        this.f = false;
        this.a = packageInfo;
        String str = packageInfo.extraServer;
        if (packageInfo.isAllowSilence()) {
            this.j = 1;
        }
        if (this.a.isOnlyWifi()) {
            this.l = 1;
        }
        if (this.a.isAllowSilenceUpdate()) {
            this.k = 1;
        }
        if (!TextUtils.isEmpty(str)) {
            try {
                BdLog.e("LiveNPSPluginManager=" + str);
                JSONObject jSONObject = new JSONObject(str);
                this.b = jSONObject.optString("description");
                this.c = jSONObject.optString("icon_url");
                this.g = jSONObject.optInt("force_update");
                this.h = jSONObject.optInt("min_version");
                this.i = jSONObject.optInt("abi");
            } catch (JSONException unused) {
            }
        }
        if (!TextUtils.isEmpty(packageInfo.subBundle)) {
            try {
                JSONObject jSONObject2 = new JSONObject(packageInfo.subBundle);
                Iterator<String> keys = jSONObject2.keys();
                ArrayList arrayList = new ArrayList();
                while (keys.hasNext()) {
                    String next = keys.next();
                    JSONObject jSONObject3 = jSONObject2.getJSONObject(next);
                    int i3 = jSONObject3.getInt("min");
                    int i4 = jSONObject3.getInt(FunAdSdk.PLATFORM_MAX);
                    SubBundleInfo subBundleInfo = new SubBundleInfo();
                    subBundleInfo.setMaxVersion(i4);
                    subBundleInfo.setMinVersion(i3);
                    subBundleInfo.setPackageName(next);
                    arrayList.add(subBundleInfo);
                }
                setSubBundle(arrayList);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        if (!TextUtils.isEmpty(packageInfo.dependInfo)) {
            try {
                JSONObject jSONObject4 = new JSONObject(packageInfo.dependInfo);
                String optString = jSONObject4.optString("main_bundle");
                setMainBundle(optString);
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(optString);
                JSONArray optJSONArray = jSONObject4.optJSONArray("dependencies");
                if (optJSONArray != null) {
                    for (int i5 = 0; i5 < optJSONArray.length(); i5++) {
                        arrayList2.add(optJSONArray.optString(i5));
                    }
                }
                setDependency(arrayList2);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public int getAbi() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.i;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public String getApkPath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.a.filePath;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public String getDependence() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.d;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public List<String> getDependency() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.n;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public String getDescription() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public int getDownloadType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (!TextUtils.isEmpty(this.a.patchUrl) && !TextUtils.isEmpty(this.a.patchMD5)) {
                return 2;
            }
            return 1;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public String getDownloadUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (TextUtils.isEmpty(this.a.netWorkStrategy)) {
                return this.a.getTrafficUrl();
            }
            return this.a.getNetWorkStrategyUrl();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public String getExt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.a.extraServer;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public String getIconUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.c;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public String getMainBudble() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.o;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public String getMd5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.a.md5;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public int getMinVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.h;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.a.name;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public String getNetworkStrategy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.a.netWorkStrategy;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public String getPackageName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.a.packageName;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public String getPatchMD5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.a.patchMD5;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public String getPatchUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.a.patchUrl;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public String getSignature() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.a.sign;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public int getSilence() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.j;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public int getSilenceUpdate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.k;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public long getSize() {
        int i;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            try {
                i = Integer.parseInt(this.a.size);
            } catch (Exception e) {
                e.printStackTrace();
                i = 0;
            }
            return i;
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public List<SubBundleInfo> getSubBundle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.m;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public long getUpdateV() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.a.updateVersion;
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public int getVersionCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return (int) this.a.version;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public int getWifiOnly() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.l;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public boolean isForbidden() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            if (this.a.disable == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public boolean isRemovable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.f;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public boolean isVisible() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.e;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public boolean needForceUpdate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            if (this.g == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setApkPath(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, str) == null) {
            this.a.filePath = str;
        }
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setDependence(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, str) == null) {
            this.b = str;
        }
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setDependency(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, list) == null) {
            this.n = list;
        }
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setDescription(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, str) == null) {
            this.b = str;
        }
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setDownloadUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, str) == null) {
            this.a.downloadUrl = str;
        }
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setExt(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, str) == null) {
            this.a.extraServer = str;
        }
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setIconUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, str) == null) {
            this.c = str;
        }
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setMainBundle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, str) == null) {
            this.o = str;
        }
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setMd5(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, str) == null) {
            this.a.md5 = str;
        }
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, str) == null) {
            this.a.name = str;
        }
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setNetworkStrategy(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, str) == null) {
            this.a.netWorkStrategy = str;
        }
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setPackageName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, str) == null) {
            this.a.packageName = str;
        }
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setPatchMD5(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, str) == null) {
            this.a.patchMD5 = str;
        }
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setPatchUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, str) == null) {
            this.a.patchUrl = str;
        }
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setRemovable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048628, this, z) == null) {
            this.f = z;
        }
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setSignature(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, str) == null) {
            this.a.sign = str;
        }
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setSilence(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048630, this, i) == null) {
            this.j = i;
        }
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setSilenceUpdate(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048631, this, i) == null) {
            this.k = i;
        }
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setSize(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048632, this, j) == null) {
            PackageInfo packageInfo = this.a;
            packageInfo.size = j + "";
        }
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setSubBundle(List<SubBundleInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048633, this, list) == null) {
            this.m = list;
        }
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setUpdateV(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048635, this, j) == null) {
            this.a.updateVersion = j;
        }
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setVersionCode(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048636, this, i) == null) {
            this.a.version = i;
        }
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048637, this, z) == null) {
            this.e = z;
        }
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setWifiOnly(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048638, this, i) == null) {
            this.l = i;
        }
    }
}
