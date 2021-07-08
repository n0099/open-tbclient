package com.baidu.ugc.editvideo.record.source.multimedia;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.minivideo.effect.core.vlogedit.MediaAEffectConfig;
import com.baidu.minivideo.effect.core.vlogedit.MediaTransitionConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.record.entity.TemplateInfo;
import com.baidu.ugc.editvideo.record.source.multimedia.utils.MultiDataSourceUtil;
import com.baidu.ugc.utils.FileUtils;
import d.a.v0.t.w;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class VlogPkgManager {
    public static /* synthetic */ Interceptable $ic;
    public static VlogPkgManager mManager;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, MediaAEffectConfig> mMediaAEffectConfigMap;
    public Map<String, MediaTransitionConfig> mMediaTransitionConfigMap;
    public Map<String, TemplateInfo> mTemplateInfoMap;

    public VlogPkgManager() {
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
        this.mTemplateInfoMap = new HashMap();
        this.mMediaTransitionConfigMap = new HashMap();
        this.mMediaAEffectConfigMap = new HashMap();
    }

    public static VlogPkgManager getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (mManager == null) {
                synchronized (VlogPkgManager.class) {
                    if (mManager == null) {
                        mManager = new VlogPkgManager();
                    }
                }
            }
            return mManager;
        }
        return (VlogPkgManager) invokeV.objValue;
    }

    public TemplateInfo getTemplateInfoByKey(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (w.a(str) || this.mTemplateInfoMap.get(str) == null) {
                return null;
            }
            return this.mTemplateInfoMap.get(str);
        }
        return (TemplateInfo) invokeL.objValue;
    }

    public MediaAEffectConfig loadMediaAEffectConfig(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (this.mMediaAEffectConfigMap.get(str) != null) {
                return this.mMediaAEffectConfigMap.get(str);
            }
            MediaAEffectConfig loadMediaAEffectConfig = MultiDataSourceUtil.loadMediaAEffectConfig(str);
            this.mMediaAEffectConfigMap.put(str, loadMediaAEffectConfig);
            return loadMediaAEffectConfig;
        }
        return (MediaAEffectConfig) invokeL.objValue;
    }

    public TemplateInfo loadTemplateInfo(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            File file = new File(str);
            if (file.exists() && file.isDirectory()) {
                if (!FileUtils.isExists(str + "/theme_config.json")) {
                    File[] listFiles = file.listFiles();
                    int length = listFiles.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            str = "";
                            break;
                        }
                        File file2 = listFiles[i2];
                        if (file2.isDirectory()) {
                            if (FileUtils.isExists(file2.getAbsolutePath() + "/theme_config.json")) {
                                str = file2.getAbsolutePath();
                                break;
                            }
                        }
                        i2++;
                    }
                }
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                TemplateInfo templateInfoByKey = getTemplateInfoByKey(str);
                if (templateInfoByKey == null && !TextUtils.isEmpty(str)) {
                    TemplateInfo templateInfo = TemplateInfo.getTemplateInfo(str);
                    this.mTemplateInfoMap.put(str, templateInfo);
                    return templateInfo;
                }
                return templateInfoByKey;
            }
            return null;
        }
        return (TemplateInfo) invokeL.objValue;
    }

    public MediaTransitionConfig loadTransitionConfig(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (this.mMediaTransitionConfigMap.get(str) != null) {
                return this.mMediaTransitionConfigMap.get(str);
            }
            MediaTransitionConfig loadMediaTransitionConfig = MultiDataSourceUtil.loadMediaTransitionConfig(str);
            this.mMediaTransitionConfigMap.put(str, loadMediaTransitionConfig);
            return loadMediaTransitionConfig;
        }
        return (MediaTransitionConfig) invokeL.objValue;
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.mTemplateInfoMap.clear();
            this.mTemplateInfoMap = null;
            this.mMediaTransitionConfigMap.clear();
            this.mMediaTransitionConfigMap = null;
            this.mMediaAEffectConfigMap.clear();
            this.mMediaAEffectConfigMap = null;
        }
    }
}
