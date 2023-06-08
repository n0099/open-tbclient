package com.baidu.tieba;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.bdtask.ctrl.model.TaskProcess;
import com.baidu.tbadk.core.data.ItemData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import tbclient.ApkDetail;
/* loaded from: classes6.dex */
public class kw6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(zv6 zv6Var) {
        ItemData itemData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65536, null, zv6Var) == null) && zv6Var != null && (itemData = zv6Var.a) != null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_UPLOAD_DOWNLOAD_INFO);
            httpMessage.addParam("item_id", itemData.itemId);
            httpMessage.addParam("app_name", itemData.mTitle);
            httpMessage.addParam("source_type", zv6Var.b);
            httpMessage.addParam("icon_url", itemData.mIconUrl);
            httpMessage.addParam("score", Double.valueOf(itemData.mScore));
            httpMessage.addParam(TaskProcess.keyTags, itemData.mTags);
            httpMessage.addParam("apk_name", itemData.pkgName);
            ApkDetail apkDetail = itemData.apkDetail;
            if (apkDetail != null) {
                httpMessage.addParam("developer", apkDetail.developer);
                httpMessage.addParam("privacy_url", itemData.apkDetail.privacy_url);
                httpMessage.addParam("authority_url", itemData.apkDetail.authority_url);
                httpMessage.addParam("version", itemData.apkDetail.version);
                httpMessage.addParam("version_code", itemData.apkDetail.version_code);
            }
            MessageManager.getInstance().sendMessageFromBackground(httpMessage);
        }
    }
}
