package com.baidu.tieba.yunpush;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.stats.SpeedStatsManager;
import com.baidu.searchbox.launch.stats.SpeedStatsStampTable;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.BdToken.BdUniDispatchSchemeController;
import com.baidu.tbadk.GrowthStatsUtil;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.util.schemeaction.SchemeActionHelper;
import com.baidu.tbadk.switchs.JumpPbDirectSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.js4;
import com.repackage.ns4;
import com.repackage.um4;
import java.util.regex.Pattern;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class YunPushProxyActivity extends BaseActivity<YunPushProxyActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public YunPushProxyActivity() {
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

    public final boolean A1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (SchemeActionHelper.needMainTabActivity(str)) {
                return true;
            }
            if (Pattern.compile("http[s]?://tieba.baidu.com/p").matcher(str).find()) {
                return !JumpPbDirectSwitch.getIsOn();
            }
            return str.startsWith("https://tieba.baidu.com/mo/q/newtopic/detail") || str.startsWith("https://tieba.baidu.com/mo/q/newtopic/detail") || str.startsWith(UrlSchemaHelper.SCHEMA_TB_FLUTTER) || str.startsWith(UrlSchemaHelper.SCHEMA_LIVE_SDK) || str.startsWith(UrlSchemaHelper.SCHEMA_CHUSHOU_LIVE_SDK) || str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_SWAN) || str.contains("achievement=");
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x01e9 A[Catch: Exception -> 0x0397, TryCatch #1 {Exception -> 0x0397, blocks: (B:5:0x002b, B:7:0x0031, B:9:0x0043, B:12:0x005a, B:14:0x0060, B:16:0x0066, B:18:0x006c, B:20:0x0072, B:22:0x0080, B:25:0x0087, B:26:0x009d, B:28:0x009f, B:31:0x00ac, B:33:0x00b2, B:35:0x00b8, B:38:0x00c1, B:55:0x00f7, B:57:0x00fe, B:59:0x0104, B:61:0x010a, B:73:0x0122, B:79:0x0136, B:94:0x016b, B:96:0x01d9, B:114:0x0212, B:118:0x022c, B:124:0x0256, B:126:0x0260, B:127:0x0268, B:131:0x0277, B:133:0x027d, B:138:0x02ac, B:137:0x02a9, B:139:0x02b0, B:141:0x02f5, B:143:0x02fd, B:148:0x0325, B:147:0x0322, B:149:0x0328, B:151:0x0330, B:152:0x0342, B:154:0x034a, B:155:0x0361, B:157:0x0369, B:159:0x0384, B:161:0x038c, B:140:0x02d5, B:123:0x0253, B:99:0x01e3, B:101:0x01e9, B:104:0x01f3, B:106:0x01f9, B:109:0x0202, B:111:0x0208, B:82:0x0144, B:85:0x0150, B:89:0x015c, B:41:0x00cb, B:44:0x00d5, B:47:0x00de, B:50:0x00e9, B:134:0x028c, B:120:0x0239, B:144:0x030c), top: B:172:0x002b, inners: #0, #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0208 A[Catch: Exception -> 0x0397, TryCatch #1 {Exception -> 0x0397, blocks: (B:5:0x002b, B:7:0x0031, B:9:0x0043, B:12:0x005a, B:14:0x0060, B:16:0x0066, B:18:0x006c, B:20:0x0072, B:22:0x0080, B:25:0x0087, B:26:0x009d, B:28:0x009f, B:31:0x00ac, B:33:0x00b2, B:35:0x00b8, B:38:0x00c1, B:55:0x00f7, B:57:0x00fe, B:59:0x0104, B:61:0x010a, B:73:0x0122, B:79:0x0136, B:94:0x016b, B:96:0x01d9, B:114:0x0212, B:118:0x022c, B:124:0x0256, B:126:0x0260, B:127:0x0268, B:131:0x0277, B:133:0x027d, B:138:0x02ac, B:137:0x02a9, B:139:0x02b0, B:141:0x02f5, B:143:0x02fd, B:148:0x0325, B:147:0x0322, B:149:0x0328, B:151:0x0330, B:152:0x0342, B:154:0x034a, B:155:0x0361, B:157:0x0369, B:159:0x0384, B:161:0x038c, B:140:0x02d5, B:123:0x0253, B:99:0x01e3, B:101:0x01e9, B:104:0x01f3, B:106:0x01f9, B:109:0x0202, B:111:0x0208, B:82:0x0144, B:85:0x0150, B:89:0x015c, B:41:0x00cb, B:44:0x00d5, B:47:0x00de, B:50:0x00e9, B:134:0x028c, B:120:0x0239, B:144:0x030c), top: B:172:0x002b, inners: #0, #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0229  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0239 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00fe A[Catch: Exception -> 0x0397, TryCatch #1 {Exception -> 0x0397, blocks: (B:5:0x002b, B:7:0x0031, B:9:0x0043, B:12:0x005a, B:14:0x0060, B:16:0x0066, B:18:0x006c, B:20:0x0072, B:22:0x0080, B:25:0x0087, B:26:0x009d, B:28:0x009f, B:31:0x00ac, B:33:0x00b2, B:35:0x00b8, B:38:0x00c1, B:55:0x00f7, B:57:0x00fe, B:59:0x0104, B:61:0x010a, B:73:0x0122, B:79:0x0136, B:94:0x016b, B:96:0x01d9, B:114:0x0212, B:118:0x022c, B:124:0x0256, B:126:0x0260, B:127:0x0268, B:131:0x0277, B:133:0x027d, B:138:0x02ac, B:137:0x02a9, B:139:0x02b0, B:141:0x02f5, B:143:0x02fd, B:148:0x0325, B:147:0x0322, B:149:0x0328, B:151:0x0330, B:152:0x0342, B:154:0x034a, B:155:0x0361, B:157:0x0369, B:159:0x0384, B:161:0x038c, B:140:0x02d5, B:123:0x0253, B:99:0x01e3, B:101:0x01e9, B:104:0x01f3, B:106:0x01f9, B:109:0x0202, B:111:0x0208, B:82:0x0144, B:85:0x0150, B:89:0x015c, B:41:0x00cb, B:44:0x00d5, B:47:0x00de, B:50:0x00e9, B:134:0x028c, B:120:0x0239, B:144:0x030c), top: B:172:0x002b, inners: #0, #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x010a A[Catch: Exception -> 0x0397, TryCatch #1 {Exception -> 0x0397, blocks: (B:5:0x002b, B:7:0x0031, B:9:0x0043, B:12:0x005a, B:14:0x0060, B:16:0x0066, B:18:0x006c, B:20:0x0072, B:22:0x0080, B:25:0x0087, B:26:0x009d, B:28:0x009f, B:31:0x00ac, B:33:0x00b2, B:35:0x00b8, B:38:0x00c1, B:55:0x00f7, B:57:0x00fe, B:59:0x0104, B:61:0x010a, B:73:0x0122, B:79:0x0136, B:94:0x016b, B:96:0x01d9, B:114:0x0212, B:118:0x022c, B:124:0x0256, B:126:0x0260, B:127:0x0268, B:131:0x0277, B:133:0x027d, B:138:0x02ac, B:137:0x02a9, B:139:0x02b0, B:141:0x02f5, B:143:0x02fd, B:148:0x0325, B:147:0x0322, B:149:0x0328, B:151:0x0330, B:152:0x0342, B:154:0x034a, B:155:0x0361, B:157:0x0369, B:159:0x0384, B:161:0x038c, B:140:0x02d5, B:123:0x0253, B:99:0x01e3, B:101:0x01e9, B:104:0x01f3, B:106:0x01f9, B:109:0x0202, B:111:0x0208, B:82:0x0144, B:85:0x0150, B:89:0x015c, B:41:0x00cb, B:44:0x00d5, B:47:0x00de, B:50:0x00e9, B:134:0x028c, B:120:0x0239, B:144:0x030c), top: B:172:0x002b, inners: #0, #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0120 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0136 A[Catch: Exception -> 0x0397, TryCatch #1 {Exception -> 0x0397, blocks: (B:5:0x002b, B:7:0x0031, B:9:0x0043, B:12:0x005a, B:14:0x0060, B:16:0x0066, B:18:0x006c, B:20:0x0072, B:22:0x0080, B:25:0x0087, B:26:0x009d, B:28:0x009f, B:31:0x00ac, B:33:0x00b2, B:35:0x00b8, B:38:0x00c1, B:55:0x00f7, B:57:0x00fe, B:59:0x0104, B:61:0x010a, B:73:0x0122, B:79:0x0136, B:94:0x016b, B:96:0x01d9, B:114:0x0212, B:118:0x022c, B:124:0x0256, B:126:0x0260, B:127:0x0268, B:131:0x0277, B:133:0x027d, B:138:0x02ac, B:137:0x02a9, B:139:0x02b0, B:141:0x02f5, B:143:0x02fd, B:148:0x0325, B:147:0x0322, B:149:0x0328, B:151:0x0330, B:152:0x0342, B:154:0x034a, B:155:0x0361, B:157:0x0369, B:159:0x0384, B:161:0x038c, B:140:0x02d5, B:123:0x0253, B:99:0x01e3, B:101:0x01e9, B:104:0x01f3, B:106:0x01f9, B:109:0x0202, B:111:0x0208, B:82:0x0144, B:85:0x0150, B:89:0x015c, B:41:0x00cb, B:44:0x00d5, B:47:0x00de, B:50:0x00e9, B:134:0x028c, B:120:0x0239, B:144:0x030c), top: B:172:0x002b, inners: #0, #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01d9 A[Catch: Exception -> 0x0397, TryCatch #1 {Exception -> 0x0397, blocks: (B:5:0x002b, B:7:0x0031, B:9:0x0043, B:12:0x005a, B:14:0x0060, B:16:0x0066, B:18:0x006c, B:20:0x0072, B:22:0x0080, B:25:0x0087, B:26:0x009d, B:28:0x009f, B:31:0x00ac, B:33:0x00b2, B:35:0x00b8, B:38:0x00c1, B:55:0x00f7, B:57:0x00fe, B:59:0x0104, B:61:0x010a, B:73:0x0122, B:79:0x0136, B:94:0x016b, B:96:0x01d9, B:114:0x0212, B:118:0x022c, B:124:0x0256, B:126:0x0260, B:127:0x0268, B:131:0x0277, B:133:0x027d, B:138:0x02ac, B:137:0x02a9, B:139:0x02b0, B:141:0x02f5, B:143:0x02fd, B:148:0x0325, B:147:0x0322, B:149:0x0328, B:151:0x0330, B:152:0x0342, B:154:0x034a, B:155:0x0361, B:157:0x0369, B:159:0x0384, B:161:0x038c, B:140:0x02d5, B:123:0x0253, B:99:0x01e3, B:101:0x01e9, B:104:0x01f3, B:106:0x01f9, B:109:0x0202, B:111:0x0208, B:82:0x0144, B:85:0x0150, B:89:0x015c, B:41:0x00cb, B:44:0x00d5, B:47:0x00de, B:50:0x00e9, B:134:0x028c, B:120:0x0239, B:144:0x030c), top: B:172:0x002b, inners: #0, #2, #3 }] */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onCreate(Bundle bundle) {
        int i;
        int optInt;
        String string;
        int i2;
        int i3;
        int i4;
        String str;
        int i5;
        int i6;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.PUSH_SCHEME_MID_ACTIVITY_ONCREATE_START_STAMP_KEY);
            js4.v(this);
            super.onCreate(bundle);
            try {
                Intent intent = getIntent();
                if (intent != null) {
                    String uri = intent.getData().toString();
                    js4.t(uri, false);
                    if (uri.contains("tbyunpushnotifybody=")) {
                        JSONObject jSONObject = new JSONObject(uri.substring(uri.indexOf("tbyunpushnotifybody=") + 20));
                        String str2 = "";
                        String string2 = !jSONObject.isNull("task_id") ? jSONObject.getString("task_id") : "";
                        String string3 = !jSONObject.isNull("service_id") ? jSONObject.getString("service_id") : "";
                        if (!jSONObject.isNull("jump_scheme")) {
                            String string4 = jSONObject.getString("jump_scheme");
                            if (!Uri.parse(string4).isOpaque()) {
                                str2 = string4;
                            } else if (um4.e()) {
                                throw new IllegalStateException(string4 + "：scheme 格式非法");
                            }
                        }
                        if (!StringUtils.isNull(str2)) {
                            if (!str2.equals("https://tieba.baidu.com/mo/q/chat") && !str2.equals("https://tieba.baidu.com/mo/q/chat") && !str2.startsWith(UrlSchemaHelper.SCHEMA_FANS_PAGE)) {
                                if (str2.contains(UrlSchemaHelper.GOTO_OFFICIAL_CHAT)) {
                                    i = 2;
                                } else if (str2.contains(UrlSchemaHelper.GOTO_PERSONAL_CHAT)) {
                                    i = 3;
                                } else if (str2.startsWith(UrlSchemaHelper.SCHEMA_REPLY_ME)) {
                                    i = 10;
                                } else if (str2.startsWith(UrlSchemaHelper.SCHEMA_AGREE_ME)) {
                                    i = 11;
                                } else if (str2.startsWith(UrlSchemaHelper.SCHEMA_AT_ME)) {
                                    i = 12;
                                }
                                optInt = !jSONObject.isNull(MainTabActivityConfig.PUSH_FOLLOW_UP_ACTION) ? jSONObject.optInt(MainTabActivityConfig.PUSH_FOLLOW_UP_ACTION) : 0;
                                string = jSONObject.isNull(MainTabActivityConfig.PUSH_DES_PAGE) ? null : jSONObject.getString(MainTabActivityConfig.PUSH_DES_PAGE);
                                if (optInt == 1) {
                                    i3 = 2;
                                    i2 = 2;
                                } else {
                                    i2 = 2;
                                    i3 = optInt == 2 ? 1 : 0;
                                }
                                int i7 = optInt == i2 ? 1 : 0;
                                if (string == null && optInt == 1) {
                                    i4 = string.equals(getString(R.string.obfuscated_res_0x7f0f04c5)) ? 1 : 2;
                                } else {
                                    i4 = 0;
                                }
                                if (str2 != null) {
                                    str = string;
                                    if (str2.contains("type=interaction")) {
                                        i5 = optInt;
                                        i6 = 2;
                                    } else if (str2.contains("type=recommend")) {
                                        i5 = optInt;
                                        i6 = 3;
                                    } else {
                                        if (str2.contains("type=attention-bazhu")) {
                                            i6 = 4;
                                        } else {
                                            i6 = str2.contains("type=attention-common") ? 5 : 5;
                                        }
                                        i5 = optInt;
                                    }
                                    StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.PUSH_CCLICK).param("obj_type", 2).param("task_id", string2).param("service_id", string3).param("shoubai_cuid", TbadkCoreApplication.getInst().getCuidGalaxy2()).param(TiebaStatic.Params.OBJ_TO, str2).param("obj_source", i).param("obj_locate", i3).param("obj_param1", i7).param(TiebaStatic.Params.OBJ_PARAM2, i4).param(TiebaStatic.Params.OBJ_PARAM3, i6).param("hdid", TbadkCoreApplication.getInst().getHdid()).param("obj_id", TbadkCoreApplication.getInst().getStartType()).param(TiebaStatic.Params.OBJ_ISHOST, 1);
                                    if (TextUtils.isEmpty(str2) && str2.contains("HotThreadList")) {
                                        i = 6;
                                    } else {
                                        if ((!TextUtils.isEmpty(str2) || !str2.contains("HotInteraction")) && (TextUtils.isEmpty(str2) || !str2.contains("frs?kw="))) {
                                            if (!TextUtils.isEmpty(str2) && str2.contains("collect")) {
                                                i = 8;
                                            }
                                        }
                                        i = 7;
                                    }
                                    param.param("obj_source", i);
                                    TiebaStatic.log(param);
                                    TiebaStatic.log(new StatisticItem("PushOptCount").param("obj_param1", !ns4.a().d() ? 1 : 2));
                                    if (!TextUtils.isEmpty(str2)) {
                                        try {
                                            str2 = Uri.parse(str2).buildUpon().appendQueryParameter("from_yunpush", "1").build().toString();
                                        } catch (Exception e) {
                                            BdLog.e(e);
                                        }
                                        if (ns4.a().d()) {
                                            ns4.a().i(2);
                                        }
                                        if (A1(str2)) {
                                            int i8 = -1;
                                            if (str2.startsWith(UrlSchemaHelper.SCHEMA_REPLY_ME)) {
                                                StatisticItem param2 = new StatisticItem(TbadkCoreStatisticKey.KEY_MSG_REPLY_CLICK).param("uid", TbadkCoreApplication.getCurrentAccountId());
                                                try {
                                                    Uri parse = Uri.parse(str2);
                                                    String queryParameter = parse.getQueryParameter("fid");
                                                    String queryParameter2 = parse.getQueryParameter("tid");
                                                    String queryParameter3 = parse.getQueryParameter("pid");
                                                    param2.param("fid", queryParameter);
                                                    param2.param("pid", queryParameter3);
                                                    param2.param("tid", queryParameter2);
                                                } catch (Exception e2) {
                                                    BdLog.e(e2);
                                                }
                                                TiebaStatic.log(param2);
                                                i8 = 3;
                                            }
                                            MainTabActivityConfig mainTabActivityConfig = new MainTabActivityConfig(this);
                                            mainTabActivityConfig.setTargetScheme(str2);
                                            mainTabActivityConfig.setPushFollowUpAction(i5);
                                            mainTabActivityConfig.setPushDesPage(str);
                                            mainTabActivityConfig.setBottomTab(i8);
                                            MessageManager.getInstance().sendMessage(new CustomMessage(2015002, mainTabActivityConfig));
                                        } else {
                                            GrowthStatsUtil.statisticChannel("push", str2);
                                            Class.forName("com.baidu.tieba.imMessageCenter.im.chat.PersonalChatActivityStatic");
                                            UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{str2, UrlManager.YUN_PUSH_TAG});
                                        }
                                        if (str2.contains("ForumGradePage")) {
                                            StatisticItem param3 = new StatisticItem("c13782").param("uid", TbadkCoreApplication.getCurrentAccountId());
                                            try {
                                                Uri parse2 = Uri.parse(str2);
                                                String queryParameter4 = parse2.getQueryParameter("forum_id");
                                                String queryParameter5 = parse2.getQueryParameter("obj_type");
                                                param3.param("fid", queryParameter4);
                                                param3.param("obj_type", queryParameter5);
                                            } catch (Exception e3) {
                                                BdLog.e(e3);
                                            }
                                            TiebaStatic.log(param3);
                                        }
                                        if (str2.contains("unidispatch/hotuserrank")) {
                                            TiebaStatic.log(new StatisticItem("c13662").param("uid", TbadkCoreApplication.getCurrentAccountId()));
                                        }
                                        if (str2.contains("weeklygodview")) {
                                            TiebaStatic.log(new StatisticItem("c13691").param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_source", 2));
                                        }
                                        if (str2.contains(PbModel.UNIDISPATCH_PB)) {
                                            Uri parse3 = Uri.parse(str2);
                                            String queryParameter6 = parse3.getQueryParameter("obj_param1");
                                            String queryParameter7 = parse3.getQueryParameter("tid");
                                            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_FROM_OUTSIDE);
                                            if (BdUniDispatchSchemeController.PARAM_VIDEO.equals(queryParameter6) || "2".equals(queryParameter6)) {
                                                statisticItem.param("obj_source", 1);
                                                statisticItem.param("tid", queryParameter7);
                                                TiebaStatic.log(statisticItem);
                                            }
                                        }
                                    }
                                } else {
                                    str = string;
                                }
                                i5 = optInt;
                                i6 = 1;
                                StatisticItem param4 = new StatisticItem(TbadkCoreStatisticKey.PUSH_CCLICK).param("obj_type", 2).param("task_id", string2).param("service_id", string3).param("shoubai_cuid", TbadkCoreApplication.getInst().getCuidGalaxy2()).param(TiebaStatic.Params.OBJ_TO, str2).param("obj_source", i).param("obj_locate", i3).param("obj_param1", i7).param(TiebaStatic.Params.OBJ_PARAM2, i4).param(TiebaStatic.Params.OBJ_PARAM3, i6).param("hdid", TbadkCoreApplication.getInst().getHdid()).param("obj_id", TbadkCoreApplication.getInst().getStartType()).param(TiebaStatic.Params.OBJ_ISHOST, 1);
                                if (TextUtils.isEmpty(str2)) {
                                }
                                if (!TextUtils.isEmpty(str2)) {
                                }
                                if (!TextUtils.isEmpty(str2)) {
                                    i = 8;
                                }
                                param4.param("obj_source", i);
                                TiebaStatic.log(param4);
                                TiebaStatic.log(new StatisticItem("PushOptCount").param("obj_param1", !ns4.a().d() ? 1 : 2));
                                if (!TextUtils.isEmpty(str2)) {
                                }
                            }
                            i = 1;
                            if (!jSONObject.isNull(MainTabActivityConfig.PUSH_FOLLOW_UP_ACTION)) {
                            }
                            if (jSONObject.isNull(MainTabActivityConfig.PUSH_DES_PAGE)) {
                            }
                            if (optInt == 1) {
                            }
                            if (optInt == i2) {
                            }
                            if (string == null) {
                            }
                            i4 = 0;
                            if (str2 != null) {
                            }
                            i5 = optInt;
                            i6 = 1;
                            StatisticItem param42 = new StatisticItem(TbadkCoreStatisticKey.PUSH_CCLICK).param("obj_type", 2).param("task_id", string2).param("service_id", string3).param("shoubai_cuid", TbadkCoreApplication.getInst().getCuidGalaxy2()).param(TiebaStatic.Params.OBJ_TO, str2).param("obj_source", i).param("obj_locate", i3).param("obj_param1", i7).param(TiebaStatic.Params.OBJ_PARAM2, i4).param(TiebaStatic.Params.OBJ_PARAM3, i6).param("hdid", TbadkCoreApplication.getInst().getHdid()).param("obj_id", TbadkCoreApplication.getInst().getStartType()).param(TiebaStatic.Params.OBJ_ISHOST, 1);
                            if (TextUtils.isEmpty(str2)) {
                            }
                            if (!TextUtils.isEmpty(str2)) {
                            }
                            if (!TextUtils.isEmpty(str2)) {
                            }
                            param42.param("obj_source", i);
                            TiebaStatic.log(param42);
                            TiebaStatic.log(new StatisticItem("PushOptCount").param("obj_param1", !ns4.a().d() ? 1 : 2));
                            if (!TextUtils.isEmpty(str2)) {
                            }
                        }
                        i = 0;
                        if (!jSONObject.isNull(MainTabActivityConfig.PUSH_FOLLOW_UP_ACTION)) {
                        }
                        if (jSONObject.isNull(MainTabActivityConfig.PUSH_DES_PAGE)) {
                        }
                        if (optInt == 1) {
                        }
                        if (optInt == i2) {
                        }
                        if (string == null) {
                        }
                        i4 = 0;
                        if (str2 != null) {
                        }
                        i5 = optInt;
                        i6 = 1;
                        StatisticItem param422 = new StatisticItem(TbadkCoreStatisticKey.PUSH_CCLICK).param("obj_type", 2).param("task_id", string2).param("service_id", string3).param("shoubai_cuid", TbadkCoreApplication.getInst().getCuidGalaxy2()).param(TiebaStatic.Params.OBJ_TO, str2).param("obj_source", i).param("obj_locate", i3).param("obj_param1", i7).param(TiebaStatic.Params.OBJ_PARAM2, i4).param(TiebaStatic.Params.OBJ_PARAM3, i6).param("hdid", TbadkCoreApplication.getInst().getHdid()).param("obj_id", TbadkCoreApplication.getInst().getStartType()).param(TiebaStatic.Params.OBJ_ISHOST, 1);
                        if (TextUtils.isEmpty(str2)) {
                        }
                        if (!TextUtils.isEmpty(str2)) {
                        }
                        if (!TextUtils.isEmpty(str2)) {
                        }
                        param422.param("obj_source", i);
                        TiebaStatic.log(param422);
                        TiebaStatic.log(new StatisticItem("PushOptCount").param("obj_param1", !ns4.a().d() ? 1 : 2));
                        if (!TextUtils.isEmpty(str2)) {
                        }
                    }
                }
            } catch (Exception e4) {
                BdLog.e(e4);
            }
            finish();
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.PUSH_SCHEME_MID_ACTIVITY_ONCREATE_END_STAMP_KEY);
        }
    }
}
