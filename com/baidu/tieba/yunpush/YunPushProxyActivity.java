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
import com.baidu.tieba.ct4;
import com.baidu.tieba.gt4;
import com.baidu.tieba.mn4;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;
/* loaded from: classes6.dex */
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

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x0208 A[Catch: Exception -> 0x03f1, TryCatch #3 {Exception -> 0x03f1, blocks: (B:5:0x002b, B:7:0x0031, B:9:0x0043, B:12:0x005a, B:14:0x0060, B:16:0x0066, B:18:0x006c, B:20:0x0072, B:22:0x0080, B:25:0x0087, B:26:0x009d, B:28:0x009f, B:31:0x00ac, B:33:0x00b4, B:36:0x00bd, B:56:0x00fe, B:58:0x0106, B:60:0x010c, B:62:0x0112, B:75:0x012c, B:88:0x015e, B:97:0x0186, B:99:0x01f8, B:128:0x0256, B:132:0x026c, B:133:0x0273, B:137:0x028a, B:143:0x02b4, B:145:0x02be, B:146:0x02c6, B:150:0x02d1, B:152:0x02d7, B:157:0x0306, B:156:0x0303, B:158:0x030a, B:160:0x034f, B:162:0x0357, B:167:0x037f, B:166:0x037c, B:168:0x0382, B:170:0x038a, B:171:0x039c, B:173:0x03a4, B:174:0x03bb, B:176:0x03c3, B:178:0x03de, B:180:0x03e6, B:159:0x032f, B:142:0x02b1, B:102:0x0202, B:104:0x0208, B:107:0x0212, B:109:0x0218, B:112:0x0221, B:114:0x0227, B:117:0x0232, B:119:0x0238, B:122:0x0243, B:124:0x0249, B:92:0x0170, B:78:0x0139, B:81:0x0144, B:84:0x0150, B:39:0x00c7, B:42:0x00d1, B:45:0x00da, B:48:0x00e5, B:51:0x00f0, B:139:0x0297, B:163:0x0366, B:153:0x02e6), top: B:195:0x002b, inners: #0, #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0227 A[Catch: Exception -> 0x03f1, TryCatch #3 {Exception -> 0x03f1, blocks: (B:5:0x002b, B:7:0x0031, B:9:0x0043, B:12:0x005a, B:14:0x0060, B:16:0x0066, B:18:0x006c, B:20:0x0072, B:22:0x0080, B:25:0x0087, B:26:0x009d, B:28:0x009f, B:31:0x00ac, B:33:0x00b4, B:36:0x00bd, B:56:0x00fe, B:58:0x0106, B:60:0x010c, B:62:0x0112, B:75:0x012c, B:88:0x015e, B:97:0x0186, B:99:0x01f8, B:128:0x0256, B:132:0x026c, B:133:0x0273, B:137:0x028a, B:143:0x02b4, B:145:0x02be, B:146:0x02c6, B:150:0x02d1, B:152:0x02d7, B:157:0x0306, B:156:0x0303, B:158:0x030a, B:160:0x034f, B:162:0x0357, B:167:0x037f, B:166:0x037c, B:168:0x0382, B:170:0x038a, B:171:0x039c, B:173:0x03a4, B:174:0x03bb, B:176:0x03c3, B:178:0x03de, B:180:0x03e6, B:159:0x032f, B:142:0x02b1, B:102:0x0202, B:104:0x0208, B:107:0x0212, B:109:0x0218, B:112:0x0221, B:114:0x0227, B:117:0x0232, B:119:0x0238, B:122:0x0243, B:124:0x0249, B:92:0x0170, B:78:0x0139, B:81:0x0144, B:84:0x0150, B:39:0x00c7, B:42:0x00d1, B:45:0x00da, B:48:0x00e5, B:51:0x00f0, B:139:0x0297, B:163:0x0366, B:153:0x02e6), top: B:195:0x002b, inners: #0, #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0238 A[Catch: Exception -> 0x03f1, TryCatch #3 {Exception -> 0x03f1, blocks: (B:5:0x002b, B:7:0x0031, B:9:0x0043, B:12:0x005a, B:14:0x0060, B:16:0x0066, B:18:0x006c, B:20:0x0072, B:22:0x0080, B:25:0x0087, B:26:0x009d, B:28:0x009f, B:31:0x00ac, B:33:0x00b4, B:36:0x00bd, B:56:0x00fe, B:58:0x0106, B:60:0x010c, B:62:0x0112, B:75:0x012c, B:88:0x015e, B:97:0x0186, B:99:0x01f8, B:128:0x0256, B:132:0x026c, B:133:0x0273, B:137:0x028a, B:143:0x02b4, B:145:0x02be, B:146:0x02c6, B:150:0x02d1, B:152:0x02d7, B:157:0x0306, B:156:0x0303, B:158:0x030a, B:160:0x034f, B:162:0x0357, B:167:0x037f, B:166:0x037c, B:168:0x0382, B:170:0x038a, B:171:0x039c, B:173:0x03a4, B:174:0x03bb, B:176:0x03c3, B:178:0x03de, B:180:0x03e6, B:159:0x032f, B:142:0x02b1, B:102:0x0202, B:104:0x0208, B:107:0x0212, B:109:0x0218, B:112:0x0221, B:114:0x0227, B:117:0x0232, B:119:0x0238, B:122:0x0243, B:124:0x0249, B:92:0x0170, B:78:0x0139, B:81:0x0144, B:84:0x0150, B:39:0x00c7, B:42:0x00d1, B:45:0x00da, B:48:0x00e5, B:51:0x00f0, B:139:0x0297, B:163:0x0366, B:153:0x02e6), top: B:195:0x002b, inners: #0, #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0249 A[Catch: Exception -> 0x03f1, TryCatch #3 {Exception -> 0x03f1, blocks: (B:5:0x002b, B:7:0x0031, B:9:0x0043, B:12:0x005a, B:14:0x0060, B:16:0x0066, B:18:0x006c, B:20:0x0072, B:22:0x0080, B:25:0x0087, B:26:0x009d, B:28:0x009f, B:31:0x00ac, B:33:0x00b4, B:36:0x00bd, B:56:0x00fe, B:58:0x0106, B:60:0x010c, B:62:0x0112, B:75:0x012c, B:88:0x015e, B:97:0x0186, B:99:0x01f8, B:128:0x0256, B:132:0x026c, B:133:0x0273, B:137:0x028a, B:143:0x02b4, B:145:0x02be, B:146:0x02c6, B:150:0x02d1, B:152:0x02d7, B:157:0x0306, B:156:0x0303, B:158:0x030a, B:160:0x034f, B:162:0x0357, B:167:0x037f, B:166:0x037c, B:168:0x0382, B:170:0x038a, B:171:0x039c, B:173:0x03a4, B:174:0x03bb, B:176:0x03c3, B:178:0x03de, B:180:0x03e6, B:159:0x032f, B:142:0x02b1, B:102:0x0202, B:104:0x0208, B:107:0x0212, B:109:0x0218, B:112:0x0221, B:114:0x0227, B:117:0x0232, B:119:0x0238, B:122:0x0243, B:124:0x0249, B:92:0x0170, B:78:0x0139, B:81:0x0144, B:84:0x0150, B:39:0x00c7, B:42:0x00d1, B:45:0x00da, B:48:0x00e5, B:51:0x00f0, B:139:0x0297, B:163:0x0366, B:153:0x02e6), top: B:195:0x002b, inners: #0, #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:131:0x026b  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0287  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0289  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0297 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0106 A[Catch: Exception -> 0x03f1, TryCatch #3 {Exception -> 0x03f1, blocks: (B:5:0x002b, B:7:0x0031, B:9:0x0043, B:12:0x005a, B:14:0x0060, B:16:0x0066, B:18:0x006c, B:20:0x0072, B:22:0x0080, B:25:0x0087, B:26:0x009d, B:28:0x009f, B:31:0x00ac, B:33:0x00b4, B:36:0x00bd, B:56:0x00fe, B:58:0x0106, B:60:0x010c, B:62:0x0112, B:75:0x012c, B:88:0x015e, B:97:0x0186, B:99:0x01f8, B:128:0x0256, B:132:0x026c, B:133:0x0273, B:137:0x028a, B:143:0x02b4, B:145:0x02be, B:146:0x02c6, B:150:0x02d1, B:152:0x02d7, B:157:0x0306, B:156:0x0303, B:158:0x030a, B:160:0x034f, B:162:0x0357, B:167:0x037f, B:166:0x037c, B:168:0x0382, B:170:0x038a, B:171:0x039c, B:173:0x03a4, B:174:0x03bb, B:176:0x03c3, B:178:0x03de, B:180:0x03e6, B:159:0x032f, B:142:0x02b1, B:102:0x0202, B:104:0x0208, B:107:0x0212, B:109:0x0218, B:112:0x0221, B:114:0x0227, B:117:0x0232, B:119:0x0238, B:122:0x0243, B:124:0x0249, B:92:0x0170, B:78:0x0139, B:81:0x0144, B:84:0x0150, B:39:0x00c7, B:42:0x00d1, B:45:0x00da, B:48:0x00e5, B:51:0x00f0, B:139:0x0297, B:163:0x0366, B:153:0x02e6), top: B:195:0x002b, inners: #0, #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0112 A[Catch: Exception -> 0x03f1, TryCatch #3 {Exception -> 0x03f1, blocks: (B:5:0x002b, B:7:0x0031, B:9:0x0043, B:12:0x005a, B:14:0x0060, B:16:0x0066, B:18:0x006c, B:20:0x0072, B:22:0x0080, B:25:0x0087, B:26:0x009d, B:28:0x009f, B:31:0x00ac, B:33:0x00b4, B:36:0x00bd, B:56:0x00fe, B:58:0x0106, B:60:0x010c, B:62:0x0112, B:75:0x012c, B:88:0x015e, B:97:0x0186, B:99:0x01f8, B:128:0x0256, B:132:0x026c, B:133:0x0273, B:137:0x028a, B:143:0x02b4, B:145:0x02be, B:146:0x02c6, B:150:0x02d1, B:152:0x02d7, B:157:0x0306, B:156:0x0303, B:158:0x030a, B:160:0x034f, B:162:0x0357, B:167:0x037f, B:166:0x037c, B:168:0x0382, B:170:0x038a, B:171:0x039c, B:173:0x03a4, B:174:0x03bb, B:176:0x03c3, B:178:0x03de, B:180:0x03e6, B:159:0x032f, B:142:0x02b1, B:102:0x0202, B:104:0x0208, B:107:0x0212, B:109:0x0218, B:112:0x0221, B:114:0x0227, B:117:0x0232, B:119:0x0238, B:122:0x0243, B:124:0x0249, B:92:0x0170, B:78:0x0139, B:81:0x0144, B:84:0x0150, B:39:0x00c7, B:42:0x00d1, B:45:0x00da, B:48:0x00e5, B:51:0x00f0, B:139:0x0297, B:163:0x0366, B:153:0x02e6), top: B:195:0x002b, inners: #0, #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x012c A[Catch: Exception -> 0x03f1, TryCatch #3 {Exception -> 0x03f1, blocks: (B:5:0x002b, B:7:0x0031, B:9:0x0043, B:12:0x005a, B:14:0x0060, B:16:0x0066, B:18:0x006c, B:20:0x0072, B:22:0x0080, B:25:0x0087, B:26:0x009d, B:28:0x009f, B:31:0x00ac, B:33:0x00b4, B:36:0x00bd, B:56:0x00fe, B:58:0x0106, B:60:0x010c, B:62:0x0112, B:75:0x012c, B:88:0x015e, B:97:0x0186, B:99:0x01f8, B:128:0x0256, B:132:0x026c, B:133:0x0273, B:137:0x028a, B:143:0x02b4, B:145:0x02be, B:146:0x02c6, B:150:0x02d1, B:152:0x02d7, B:157:0x0306, B:156:0x0303, B:158:0x030a, B:160:0x034f, B:162:0x0357, B:167:0x037f, B:166:0x037c, B:168:0x0382, B:170:0x038a, B:171:0x039c, B:173:0x03a4, B:174:0x03bb, B:176:0x03c3, B:178:0x03de, B:180:0x03e6, B:159:0x032f, B:142:0x02b1, B:102:0x0202, B:104:0x0208, B:107:0x0212, B:109:0x0218, B:112:0x0221, B:114:0x0227, B:117:0x0232, B:119:0x0238, B:122:0x0243, B:124:0x0249, B:92:0x0170, B:78:0x0139, B:81:0x0144, B:84:0x0150, B:39:0x00c7, B:42:0x00d1, B:45:0x00da, B:48:0x00e5, B:51:0x00f0, B:139:0x0297, B:163:0x0366, B:153:0x02e6), top: B:195:0x002b, inners: #0, #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01f8 A[Catch: Exception -> 0x03f1, TryCatch #3 {Exception -> 0x03f1, blocks: (B:5:0x002b, B:7:0x0031, B:9:0x0043, B:12:0x005a, B:14:0x0060, B:16:0x0066, B:18:0x006c, B:20:0x0072, B:22:0x0080, B:25:0x0087, B:26:0x009d, B:28:0x009f, B:31:0x00ac, B:33:0x00b4, B:36:0x00bd, B:56:0x00fe, B:58:0x0106, B:60:0x010c, B:62:0x0112, B:75:0x012c, B:88:0x015e, B:97:0x0186, B:99:0x01f8, B:128:0x0256, B:132:0x026c, B:133:0x0273, B:137:0x028a, B:143:0x02b4, B:145:0x02be, B:146:0x02c6, B:150:0x02d1, B:152:0x02d7, B:157:0x0306, B:156:0x0303, B:158:0x030a, B:160:0x034f, B:162:0x0357, B:167:0x037f, B:166:0x037c, B:168:0x0382, B:170:0x038a, B:171:0x039c, B:173:0x03a4, B:174:0x03bb, B:176:0x03c3, B:178:0x03de, B:180:0x03e6, B:159:0x032f, B:142:0x02b1, B:102:0x0202, B:104:0x0208, B:107:0x0212, B:109:0x0218, B:112:0x0221, B:114:0x0227, B:117:0x0232, B:119:0x0238, B:122:0x0243, B:124:0x0249, B:92:0x0170, B:78:0x0139, B:81:0x0144, B:84:0x0150, B:39:0x00c7, B:42:0x00d1, B:45:0x00da, B:48:0x00e5, B:51:0x00f0, B:139:0x0297, B:163:0x0366, B:153:0x02e6), top: B:195:0x002b, inners: #0, #1, #2 }] */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onCreate(Bundle bundle) {
        int i;
        int optInt;
        int i2;
        int i3;
        int i4;
        int i5;
        String str;
        int i6;
        int i7;
        int i8;
        Matcher matcher;
        int i9;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.PUSH_SCHEME_MID_ACTIVITY_ONCREATE_START_STAMP_KEY);
            ct4.u(this);
            super.onCreate(bundle);
            try {
                Intent intent = getIntent();
                if (intent != null) {
                    String uri = intent.getData().toString();
                    ct4.s(uri, false);
                    if (uri.contains("tbyunpushnotifybody=")) {
                        JSONObject jSONObject = new JSONObject(uri.substring(uri.indexOf("tbyunpushnotifybody=") + 20));
                        String str2 = "";
                        String string = !jSONObject.isNull("task_id") ? jSONObject.getString("task_id") : "";
                        String string2 = !jSONObject.isNull("service_id") ? jSONObject.getString("service_id") : "";
                        if (!jSONObject.isNull("jump_scheme")) {
                            String string3 = jSONObject.getString("jump_scheme");
                            if (!Uri.parse(string3).isOpaque()) {
                                str2 = string3;
                            } else if (mn4.e()) {
                                throw new IllegalStateException(string3 + "：scheme 格式非法");
                            }
                        }
                        if (!StringUtils.isNull(str2)) {
                            if (!str2.equals(UrlSchemaHelper.JUMP_TO_CHAT) && !str2.startsWith(UrlSchemaHelper.SCHEMA_FANS_PAGE)) {
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
                                } else if (str2.startsWith("flt://SignTogetherPage")) {
                                    i = 14;
                                }
                                optInt = !jSONObject.isNull(MainTabActivityConfig.PUSH_FOLLOW_UP_ACTION) ? jSONObject.optInt(MainTabActivityConfig.PUSH_FOLLOW_UP_ACTION) : 0;
                                String string4 = jSONObject.isNull(MainTabActivityConfig.PUSH_DES_PAGE) ? null : jSONObject.getString(MainTabActivityConfig.PUSH_DES_PAGE);
                                if (optInt == 1) {
                                    i3 = 2;
                                    i2 = 2;
                                } else {
                                    i2 = 2;
                                    i3 = optInt == 2 ? 1 : 0;
                                }
                                int i10 = optInt == i2 ? 1 : 0;
                                if (str2 != null) {
                                    i4 = i;
                                    if (str2.contains("type=interaction")) {
                                        i9 = 2;
                                    } else if (str2.contains("type=recommend")) {
                                        i9 = 3;
                                    } else if (str2.contains("type=attention-bazhu")) {
                                        i9 = 4;
                                    } else {
                                        i9 = str2.contains("type=attention-common") ? 5 : 1;
                                    }
                                    if (str2.contains("force_jump=frs")) {
                                        i5 = optInt;
                                        i6 = 6;
                                    } else {
                                        i5 = optInt;
                                        i6 = str2.contains("force_jump=maintab") ? 1 : 0;
                                    }
                                    int i11 = i9;
                                    str = string4;
                                    i7 = i11;
                                } else {
                                    i4 = i;
                                    i5 = optInt;
                                    str = string4;
                                    i6 = 0;
                                    i7 = 1;
                                }
                                StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.PUSH_CCLICK).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", 2).param("task_id", string).param("service_id", string2).param("shoubai_cuid", TbadkCoreApplication.getInst().getCuidGalaxy2()).param(TiebaStatic.Params.OBJ_TO, str2).param("obj_locate", i3).param("obj_param1", i10).param(TiebaStatic.Params.OBJ_PARAM2, i6).param(TiebaStatic.Params.OBJ_PARAM3, i7).param("hdid", TbadkCoreApplication.getInst().getHdid()).param("obj_id", TbadkCoreApplication.getInst().getStartType()).param(TiebaStatic.Params.OBJ_ISHOST, 1);
                                if (TextUtils.isEmpty(str2) && str2.contains("HotThreadList")) {
                                    i8 = 6;
                                } else {
                                    if ((!TextUtils.isEmpty(str2) || !str2.contains("HotInteraction")) && (TextUtils.isEmpty(str2) || !str2.contains("frs?kw="))) {
                                        if (TextUtils.isEmpty(str2) && str2.contains("collect")) {
                                            i8 = 8;
                                        } else if (TextUtils.isEmpty(str2) && str2.contains("push_type=question_answer_invite")) {
                                            i8 = 15;
                                        } else {
                                            i8 = (TextUtils.isEmpty(str2) && str2.contains("push_type=answer_top")) ? 16 : i4;
                                        }
                                    }
                                    i8 = 7;
                                }
                                param.param("obj_source", i8);
                                matcher = Pattern.compile(UrlSchemaHelper.PB_URL).matcher(str2);
                                if (matcher.find()) {
                                    param.addParam("tid", matcher.group(1));
                                }
                                TiebaStatic.log(param);
                                TiebaStatic.log(new StatisticItem("PushOptCount").param("obj_param1", gt4.a().d() ? 1 : 2));
                                if (!TextUtils.isEmpty(str2)) {
                                    try {
                                        str2 = Uri.parse(str2).buildUpon().appendQueryParameter("from_yunpush", "1").build().toString();
                                    } catch (Exception e) {
                                        BdLog.e(e);
                                    }
                                    if (gt4.a().d()) {
                                        gt4.a().i(2);
                                    }
                                    if (z1(str2)) {
                                        int i12 = -1;
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
                                            i12 = 3;
                                        }
                                        MainTabActivityConfig mainTabActivityConfig = new MainTabActivityConfig(this);
                                        mainTabActivityConfig.setTargetScheme(str2);
                                        mainTabActivityConfig.setPushFollowUpAction(i5);
                                        mainTabActivityConfig.setPushDesPage(str);
                                        mainTabActivityConfig.setBottomTab(i12);
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
                            }
                            i = 1;
                            if (!jSONObject.isNull(MainTabActivityConfig.PUSH_FOLLOW_UP_ACTION)) {
                            }
                            String string42 = jSONObject.isNull(MainTabActivityConfig.PUSH_DES_PAGE) ? null : jSONObject.getString(MainTabActivityConfig.PUSH_DES_PAGE);
                            if (optInt == 1) {
                            }
                            if (optInt == i2) {
                            }
                            if (str2 != null) {
                            }
                            StatisticItem param4 = new StatisticItem(TbadkCoreStatisticKey.PUSH_CCLICK).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", 2).param("task_id", string).param("service_id", string2).param("shoubai_cuid", TbadkCoreApplication.getInst().getCuidGalaxy2()).param(TiebaStatic.Params.OBJ_TO, str2).param("obj_locate", i3).param("obj_param1", i10).param(TiebaStatic.Params.OBJ_PARAM2, i6).param(TiebaStatic.Params.OBJ_PARAM3, i7).param("hdid", TbadkCoreApplication.getInst().getHdid()).param("obj_id", TbadkCoreApplication.getInst().getStartType()).param(TiebaStatic.Params.OBJ_ISHOST, 1);
                            if (TextUtils.isEmpty(str2)) {
                            }
                            if (!TextUtils.isEmpty(str2)) {
                            }
                            if (TextUtils.isEmpty(str2)) {
                            }
                            if (TextUtils.isEmpty(str2)) {
                            }
                            if (TextUtils.isEmpty(str2)) {
                            }
                            param4.param("obj_source", i8);
                            matcher = Pattern.compile(UrlSchemaHelper.PB_URL).matcher(str2);
                            if (matcher.find()) {
                            }
                            TiebaStatic.log(param4);
                            TiebaStatic.log(new StatisticItem("PushOptCount").param("obj_param1", gt4.a().d() ? 1 : 2));
                            if (!TextUtils.isEmpty(str2)) {
                            }
                        }
                        i = 0;
                        if (!jSONObject.isNull(MainTabActivityConfig.PUSH_FOLLOW_UP_ACTION)) {
                        }
                        String string422 = jSONObject.isNull(MainTabActivityConfig.PUSH_DES_PAGE) ? null : jSONObject.getString(MainTabActivityConfig.PUSH_DES_PAGE);
                        if (optInt == 1) {
                        }
                        if (optInt == i2) {
                        }
                        if (str2 != null) {
                        }
                        StatisticItem param42 = new StatisticItem(TbadkCoreStatisticKey.PUSH_CCLICK).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", 2).param("task_id", string).param("service_id", string2).param("shoubai_cuid", TbadkCoreApplication.getInst().getCuidGalaxy2()).param(TiebaStatic.Params.OBJ_TO, str2).param("obj_locate", i3).param("obj_param1", i10).param(TiebaStatic.Params.OBJ_PARAM2, i6).param(TiebaStatic.Params.OBJ_PARAM3, i7).param("hdid", TbadkCoreApplication.getInst().getHdid()).param("obj_id", TbadkCoreApplication.getInst().getStartType()).param(TiebaStatic.Params.OBJ_ISHOST, 1);
                        if (TextUtils.isEmpty(str2)) {
                        }
                        if (!TextUtils.isEmpty(str2)) {
                        }
                        if (TextUtils.isEmpty(str2)) {
                        }
                        if (TextUtils.isEmpty(str2)) {
                        }
                        if (TextUtils.isEmpty(str2)) {
                        }
                        param42.param("obj_source", i8);
                        matcher = Pattern.compile(UrlSchemaHelper.PB_URL).matcher(str2);
                        if (matcher.find()) {
                        }
                        TiebaStatic.log(param42);
                        TiebaStatic.log(new StatisticItem("PushOptCount").param("obj_param1", gt4.a().d() ? 1 : 2));
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

    public final boolean z1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (SchemeActionHelper.needMainTabActivity(str)) {
                return true;
            }
            if (Pattern.compile("http[s]?://tieba.baidu.com/p").matcher(str).find()) {
                return false;
            }
            return str.contains(UrlSchemaHelper.HTTP_JUMP_TOPIC_DETAIL) || str.startsWith(UrlSchemaHelper.SCHEMA_TB_FLUTTER) || str.startsWith(UrlSchemaHelper.SCHEMA_LIVE_SDK) || str.startsWith(UrlSchemaHelper.SCHEMA_CHUSHOU_LIVE_SDK) || str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_SWAN) || str.contains("achievement=");
        }
        return invokeL.booleanValue;
    }
}
