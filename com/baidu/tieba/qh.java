package com.baidu.tieba;

import android.content.Context;
import android.util.Log;
import com.baidu.titan.sdk.internal.util.Files;
import com.baidu.titan.sdk.loader.LoaderHead;
import com.baidu.titan.sdk.loader.LoaderManager;
import com.baidu.titan.sdk.pm.PatchInstallInfo;
import com.baidu.titan.sdk.pm.PatchMetaInfo;
import com.baidu.titan.sdk.pm.TitanPaths;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.sticker.StickerDataChangeType;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class qh implements lh {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public qh() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public JSONObject a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                PatchInstallInfo currentPatchInfo = LoaderManager.getInstance().getCurrentPatchInfo();
                if (currentPatchInfo != null) {
                    jSONObject.put("info", PatchMetaInfo.createFromPatch(currentPatchInfo.getPatchFile()).toJson());
                } else {
                    jSONObject.put("error", "no-patch-loaded");
                }
            } catch (Exception e) {
                try {
                    jSONObject.put("error", Log.getStackTraceString(e));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            JSONObject jSONObject2 = new JSONObject();
            try {
                File headFile = TitanPaths.getHeadFile();
                if (headFile.exists()) {
                    String fileStringContent = Files.getFileStringContent(headFile);
                    jSONObject2.put("head", new JSONObject(fileStringContent));
                    LoaderHead createFromJson = LoaderHead.createFromJson(fileStringContent);
                    if (createFromJson != null) {
                        PatchMetaInfo createFromPatch = PatchMetaInfo.createFromPatch(new PatchInstallInfo(TitanPaths.getPatchDir(createFromJson.patchHash)).getPatchFile());
                        if (createFromPatch == null) {
                            jSONObject2.put("error", "patch file damage");
                        } else {
                            context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                            if (createFromPatch.versionInfo != null) {
                                jSONObject2.put("info", createFromPatch.toJson());
                            } else {
                                jSONObject2.put("error", "version info dismiss");
                            }
                        }
                    }
                } else {
                    jSONObject2.put("error", "no-patch-installed");
                }
            } catch (Exception e3) {
                try {
                    jSONObject2.put("error", Log.getStackTraceString(e3));
                } catch (JSONException e4) {
                    e4.printStackTrace();
                }
            }
            JSONObject jSONObject3 = new JSONObject();
            try {
                th d = th.d();
                d.g();
                jSONObject3.put("info", d.k());
            } catch (Exception e5) {
                try {
                    jSONObject3.put("error", Log.getStackTraceString(e5));
                } catch (JSONException e6) {
                    e6.printStackTrace();
                }
            }
            JSONObject jSONObject4 = new JSONObject();
            try {
                jSONObject4.put("load", jSONObject);
                jSONObject4.put("install", jSONObject2);
                jSONObject4.put(StickerDataChangeType.UPDATE, jSONObject3);
            } catch (JSONException e7) {
                e7.printStackTrace();
            }
            return jSONObject4;
        }
        return (JSONObject) invokeL.objValue;
    }
}
