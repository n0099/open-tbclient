package com.baidu.tieba;

import android.content.ContentValues;
import android.database.Cursor;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.live.interfaces.defaultimpl.utils.MultiRatePlayUrlHelper;
import com.baidu.swan.apps.model.SwanAppBearInfo;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class tf4 extends uf4<PMSAppInfo> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public tf4() {
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
    @Override // com.baidu.tieba.uf4
    /* renamed from: g */
    public PMSAppInfo d(Cursor cursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, cursor)) == null) {
            if (cursor != null && cursor.getCount() > 0 && cursor.moveToFirst()) {
                return h(cursor);
            }
            return null;
        }
        return (PMSAppInfo) invokeL.objValue;
    }

    @Override // com.baidu.tieba.uf4
    public List<PMSAppInfo> e(Cursor cursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cursor)) == null) {
            ArrayList arrayList = new ArrayList();
            if (cursor != null && cursor.getCount() > 0 && cursor.moveToFirst()) {
                do {
                    arrayList.add(h(cursor));
                } while (cursor.moveToNext());
                return arrayList;
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.uf4
    /* renamed from: f */
    public ContentValues c(PMSAppInfo pMSAppInfo) throws IllegalArgumentException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, pMSAppInfo)) == null) {
            ContentValues contentValues = new ContentValues();
            if (pMSAppInfo == null) {
                return contentValues;
            }
            contentValues.put("app_id", pMSAppInfo.appId);
            contentValues.put(GameGuideConfigInfo.KEY_APP_KEY, pMSAppInfo.appKey);
            contentValues.put("app_sign", Long.valueOf(pMSAppInfo.appSign));
            contentValues.put("version_code", Long.valueOf(pMSAppInfo.versionCode));
            contentValues.put("version_name", pMSAppInfo.versionName);
            contentValues.put("description", pMSAppInfo.description);
            contentValues.put("app_status", Integer.valueOf(pMSAppInfo.appStatus));
            contentValues.put("status_detail", pMSAppInfo.statusDetail);
            contentValues.put("status_desc", pMSAppInfo.statusDesc);
            contentValues.put("resume_date", pMSAppInfo.resumeDate);
            contentValues.put("icon_url", pMSAppInfo.iconUrl);
            contentValues.put("app_name", pMSAppInfo.appName);
            contentValues.put("service_category", pMSAppInfo.serviceCategory);
            contentValues.put("subject_info", pMSAppInfo.subjectInfo);
            contentValues.put("type", Integer.valueOf(pMSAppInfo.type));
            contentValues.put("pkg_size", Long.valueOf(pMSAppInfo.pkgSize));
            contentValues.put("pending_err_code", Integer.valueOf(pMSAppInfo.pendingErrCode));
            contentValues.put("app_category", Integer.valueOf(pMSAppInfo.appCategory));
            contentValues.put("orientation", Integer.valueOf(pMSAppInfo.getOrientation()));
            contentValues.put("max_age", Long.valueOf(pMSAppInfo.maxAge));
            contentValues.put("create_time", Long.valueOf(pMSAppInfo.createTime));
            contentValues.put("webview_domains", pMSAppInfo.webViewDomains);
            contentValues.put("web_action", pMSAppInfo.webAction);
            contentValues.put("domains", pMSAppInfo.domains);
            contentValues.put(SwanAppBearInfo.BEAR_INFO, pMSAppInfo.bearInfo);
            contentValues.put("server_ext", pMSAppInfo.serverExt);
            contentValues.put("pay_protected", Integer.valueOf(pMSAppInfo.payProtected));
            contentValues.put("customer_service", Integer.valueOf(pMSAppInfo.customerService));
            contentValues.put("global_notice", Integer.valueOf(pMSAppInfo.globalNotice));
            contentValues.put("global_private", Integer.valueOf(pMSAppInfo.globalPrivate));
            contentValues.put("pa_number", pMSAppInfo.paNumber);
            contentValues.put(com.xiaomi.mipush.sdk.Constants.PHONE_BRAND, pMSAppInfo.brandsInfo);
            contentValues.put("quick_app_key", pMSAppInfo.quickAppKey);
            long lastLaunchTime = pMSAppInfo.getLastLaunchTime();
            if (0 < lastLaunchTime) {
                contentValues.put("last_launch_time", Long.valueOf(lastLaunchTime));
            }
            int launchCount = pMSAppInfo.getLaunchCount();
            if (launchCount > 0) {
                contentValues.put("launch_count", Integer.valueOf(launchCount));
            }
            int installSrc = pMSAppInfo.getInstallSrc();
            if (installSrc > 0) {
                contentValues.put("install_src", Integer.valueOf(installSrc));
            }
            contentValues.put("web_url", pMSAppInfo.webUrl);
            contentValues.put("web_permit", Integer.valueOf(pMSAppInfo.webPermit));
            contentValues.put("cs_protocol_version", Integer.valueOf(pMSAppInfo.csProtocolVersion));
            contentValues.put("user_action_apis", pMSAppInfo.userActionApis);
            contentValues.put(MultiRatePlayUrlHelper.RANK, Integer.valueOf(pMSAppInfo.rank));
            return contentValues;
        }
        return (ContentValues) invokeL.objValue;
    }

    public final PMSAppInfo h(Cursor cursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, cursor)) == null) {
            if (cursor != null) {
                int columnIndex = cursor.getColumnIndex("app_id");
                int columnIndex2 = cursor.getColumnIndex(GameGuideConfigInfo.KEY_APP_KEY);
                int columnIndex3 = cursor.getColumnIndex("app_sign");
                int columnIndex4 = cursor.getColumnIndex("version_code");
                int columnIndex5 = cursor.getColumnIndex("version_name");
                int columnIndex6 = cursor.getColumnIndex("description");
                int columnIndex7 = cursor.getColumnIndex("app_status");
                int columnIndex8 = cursor.getColumnIndex("status_detail");
                int columnIndex9 = cursor.getColumnIndex("status_desc");
                int columnIndex10 = cursor.getColumnIndex("resume_date");
                int columnIndex11 = cursor.getColumnIndex("icon_url");
                int columnIndex12 = cursor.getColumnIndex("app_name");
                int columnIndex13 = cursor.getColumnIndex("service_category");
                int columnIndex14 = cursor.getColumnIndex("subject_info");
                int columnIndex15 = cursor.getColumnIndex("type");
                int columnIndex16 = cursor.getColumnIndex("pkg_size");
                int columnIndex17 = cursor.getColumnIndex("pending_err_code");
                int columnIndex18 = cursor.getColumnIndex("app_category");
                int columnIndex19 = cursor.getColumnIndex("orientation");
                int columnIndex20 = cursor.getColumnIndex("max_age");
                int columnIndex21 = cursor.getColumnIndex("create_time");
                int columnIndex22 = cursor.getColumnIndex("webview_domains");
                int columnIndex23 = cursor.getColumnIndex("web_action");
                int columnIndex24 = cursor.getColumnIndex("domains");
                int columnIndex25 = cursor.getColumnIndex(SwanAppBearInfo.BEAR_INFO);
                int columnIndex26 = cursor.getColumnIndex("server_ext");
                int columnIndex27 = cursor.getColumnIndex("pay_protected");
                int columnIndex28 = cursor.getColumnIndex("customer_service");
                int columnIndex29 = cursor.getColumnIndex("global_notice");
                int columnIndex30 = cursor.getColumnIndex("global_private");
                int columnIndex31 = cursor.getColumnIndex("pa_number");
                int columnIndex32 = cursor.getColumnIndex(com.xiaomi.mipush.sdk.Constants.PHONE_BRAND);
                int columnIndex33 = cursor.getColumnIndex("last_launch_time");
                int columnIndex34 = cursor.getColumnIndex("launch_count");
                int columnIndex35 = cursor.getColumnIndex("install_src");
                int columnIndex36 = cursor.getColumnIndex("quick_app_key");
                int columnIndex37 = cursor.getColumnIndex("web_url");
                int columnIndex38 = cursor.getColumnIndex("web_permit");
                int columnIndex39 = cursor.getColumnIndex("cs_protocol_version");
                int columnIndex40 = cursor.getColumnIndex("user_action_apis");
                PMSAppInfo pMSAppInfo = new PMSAppInfo();
                pMSAppInfo.appId = cursor.getString(columnIndex);
                pMSAppInfo.appKey = cursor.getString(columnIndex2);
                pMSAppInfo.appSign = cursor.getLong(columnIndex3);
                pMSAppInfo.versionCode = cursor.getInt(columnIndex4);
                pMSAppInfo.versionName = cursor.getString(columnIndex5);
                pMSAppInfo.description = cursor.getString(columnIndex6);
                pMSAppInfo.appStatus = cursor.getInt(columnIndex7);
                pMSAppInfo.statusDetail = cursor.getString(columnIndex8);
                pMSAppInfo.statusDesc = cursor.getString(columnIndex9);
                pMSAppInfo.resumeDate = cursor.getString(columnIndex10);
                pMSAppInfo.iconUrl = cursor.getString(columnIndex11);
                pMSAppInfo.appName = cursor.getString(columnIndex12);
                pMSAppInfo.serviceCategory = cursor.getString(columnIndex13);
                pMSAppInfo.subjectInfo = cursor.getString(columnIndex14);
                pMSAppInfo.type = cursor.getInt(columnIndex15);
                pMSAppInfo.pkgSize = cursor.getLong(columnIndex16);
                pMSAppInfo.pendingErrCode = cursor.getInt(columnIndex17);
                pMSAppInfo.appCategory = cursor.getInt(columnIndex18);
                pMSAppInfo.setOrientation(cursor.getInt(columnIndex19));
                pMSAppInfo.maxAge = cursor.getLong(columnIndex20);
                pMSAppInfo.createTime = cursor.getLong(columnIndex21);
                pMSAppInfo.webViewDomains = cursor.getString(columnIndex22);
                pMSAppInfo.webAction = cursor.getString(columnIndex23);
                pMSAppInfo.domains = cursor.getString(columnIndex24);
                pMSAppInfo.bearInfo = cursor.getString(columnIndex25);
                pMSAppInfo.serverExt = cursor.getString(columnIndex26);
                pMSAppInfo.payProtected = cursor.getInt(columnIndex27);
                pMSAppInfo.customerService = cursor.getInt(columnIndex28);
                pMSAppInfo.globalNotice = cursor.getInt(columnIndex29);
                pMSAppInfo.globalPrivate = cursor.getInt(columnIndex30);
                pMSAppInfo.paNumber = cursor.getString(columnIndex31);
                pMSAppInfo.brandsInfo = cursor.getString(columnIndex32);
                pMSAppInfo.quickAppKey = cursor.getString(columnIndex36);
                pMSAppInfo.updateLastLaunchTime(cursor.getLong(columnIndex33));
                pMSAppInfo.updateLaunchCount(cursor.getInt(columnIndex34));
                pMSAppInfo.updateInstallSrc(cursor.getInt(columnIndex35));
                pMSAppInfo.webUrl = cursor.getString(columnIndex37);
                pMSAppInfo.webPermit = cursor.getInt(columnIndex38);
                pMSAppInfo.csProtocolVersion = cursor.getInt(columnIndex39);
                pMSAppInfo.userActionApis = cursor.getString(columnIndex40);
                pMSAppInfo.rank = cursor.getInt(cursor.getColumnIndex(MultiRatePlayUrlHelper.RANK));
                return pMSAppInfo;
            }
            return null;
        }
        return (PMSAppInfo) invokeL.objValue;
    }
}
