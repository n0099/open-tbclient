package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.frs.itemtab.gamecode.GameCodeGetResponseMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class rg6 extends BdAsyncTask<Void, Void, String> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public rg6() {
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public String doInBackground(Void... voidArr) {
        InterceptResult invokeL;
        String str;
        String a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
            String modName = TbSingleton.getInstance().getModName();
            if (TextUtils.isEmpty(modName)) {
                return null;
            }
            pg6 d = d(modName);
            NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.URL_UPLOAD_OFFLINE_PACK_STATUS);
            netWork.addPostData("cuid", TbadkCoreApplication.getInst().getCuid());
            netWork.addPostData("mod_name", modName);
            if (d.b()) {
                str = "1";
            } else {
                str = "2";
            }
            netWork.addPostData("status", str);
            if (d.b()) {
                a = "";
            } else {
                a = d.a();
            }
            netWork.addPostData("fail_reason", a);
            netWork.postNetData();
            return null;
        }
        return (String) invokeL.objValue;
    }

    public final void c(String str, pg6 pg6Var) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, pg6Var) == null) {
            if (StringUtils.isNull(str)) {
                pg6Var.c("serve return is null");
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.optInt("error_code") == 0) {
                    z = true;
                } else {
                    z = false;
                }
                pg6Var.d(z);
                pg6Var.c(jSONObject.optString(GameCodeGetResponseMsg.PARAM_ERROR_MSG));
            } catch (JSONException e) {
                pg6Var.c("parse json exception");
                BdLog.e(e);
            }
        }
    }

    public final pg6 d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            pg6 pg6Var = new pg6();
            if (TextUtils.isEmpty(str)) {
                pg6Var.c("module not exit");
                return pg6Var;
            }
            File file = new File(mg6.l().k(), str);
            String n = mg6.l().n(str);
            if (TbSingleton.getInstance().isUploadOffPack()) {
                pg6Var.d(false);
                if (!file.exists()) {
                    pg6Var.c("bundle not exist");
                    return pg6Var;
                } else if (TextUtils.isEmpty(n)) {
                    pg6Var.c("the local has no valid version name");
                    return pg6Var;
                } else {
                    String str2 = file.getAbsolutePath() + "/" + n + "/";
                    if (!new File(str2).exists()) {
                        pg6Var.c("bundle not exist");
                        return pg6Var;
                    }
                    String str3 = file.getAbsolutePath() + "/" + n + ".zip";
                    File file2 = new File(str3);
                    if (file2.exists()) {
                        FileHelper.deleteFileOrDir(file2);
                    }
                    if (w55.e(str2, str3)) {
                        NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.URL_UPLOAD_OFFLINE_PACK);
                        netWork.addPostData("offline_pack_version", n);
                        netWork.addPostData("mod_name", str);
                        netWork.getNetContext().getRequest().mNeedBackgroundLogin = false;
                        netWork.getNetContext().getRequest().mIsUseCurrentBDUSS = false;
                        c(netWork.uploadFile("offline_pack_file_stream", str3), pg6Var);
                        if (!pg6Var.b()) {
                            return pg6Var;
                        }
                    } else {
                        pg6Var.c("zip bundle error");
                        return pg6Var;
                    }
                }
            } else {
                pg6Var.d(true);
            }
            if (TbSingleton.getInstance().isClearOffPack()) {
                mg6.l().g(str);
                if (!TextUtils.isEmpty(n)) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_UPDATE_OFFLINE_PACK).param("obj_name", str).param("obj_id", n));
                }
                if (file.exists() && !StringUtils.isNull(n)) {
                    if (!new File(file.getAbsolutePath(), n).exists()) {
                        return pg6Var;
                    }
                    pg6Var.c("delete fail");
                    pg6Var.d(false);
                }
            }
            return pg6Var;
        }
        return (pg6) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            ug6.c();
        }
    }
}
