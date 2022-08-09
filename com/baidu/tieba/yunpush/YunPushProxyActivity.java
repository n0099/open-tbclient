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
import com.repackage.at4;
import com.repackage.et4;
import com.repackage.ln4;
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

    /* JADX WARN: Removed duplicated region for block: B:100:0x01ea A[Catch: Exception -> 0x03cb, TryCatch #1 {Exception -> 0x03cb, blocks: (B:5:0x002b, B:7:0x0031, B:9:0x0043, B:12:0x005a, B:14:0x0060, B:16:0x0066, B:18:0x006c, B:20:0x0072, B:22:0x0080, B:25:0x0087, B:26:0x009d, B:28:0x009f, B:31:0x00ac, B:33:0x00b4, B:36:0x00bd, B:56:0x00fe, B:58:0x0106, B:60:0x010c, B:62:0x0112, B:77:0x012f, B:83:0x0143, B:98:0x0178, B:100:0x01ea, B:129:0x0248, B:133:0x0262, B:139:0x028c, B:141:0x0296, B:142:0x029e, B:146:0x02ab, B:148:0x02b1, B:153:0x02e0, B:152:0x02dd, B:154:0x02e4, B:156:0x0329, B:158:0x0331, B:163:0x0359, B:162:0x0356, B:164:0x035c, B:166:0x0364, B:167:0x0376, B:169:0x037e, B:170:0x0395, B:172:0x039d, B:174:0x03b8, B:176:0x03c0, B:155:0x0309, B:138:0x0289, B:103:0x01f4, B:105:0x01fa, B:108:0x0204, B:110:0x020a, B:113:0x0213, B:115:0x0219, B:118:0x0224, B:120:0x022a, B:123:0x0235, B:125:0x023b, B:86:0x0151, B:89:0x015d, B:93:0x0169, B:39:0x00c7, B:42:0x00d1, B:45:0x00da, B:48:0x00e5, B:51:0x00f0, B:149:0x02c0, B:135:0x026f, B:159:0x0340), top: B:187:0x002b, inners: #0, #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:105:0x01fa A[Catch: Exception -> 0x03cb, TryCatch #1 {Exception -> 0x03cb, blocks: (B:5:0x002b, B:7:0x0031, B:9:0x0043, B:12:0x005a, B:14:0x0060, B:16:0x0066, B:18:0x006c, B:20:0x0072, B:22:0x0080, B:25:0x0087, B:26:0x009d, B:28:0x009f, B:31:0x00ac, B:33:0x00b4, B:36:0x00bd, B:56:0x00fe, B:58:0x0106, B:60:0x010c, B:62:0x0112, B:77:0x012f, B:83:0x0143, B:98:0x0178, B:100:0x01ea, B:129:0x0248, B:133:0x0262, B:139:0x028c, B:141:0x0296, B:142:0x029e, B:146:0x02ab, B:148:0x02b1, B:153:0x02e0, B:152:0x02dd, B:154:0x02e4, B:156:0x0329, B:158:0x0331, B:163:0x0359, B:162:0x0356, B:164:0x035c, B:166:0x0364, B:167:0x0376, B:169:0x037e, B:170:0x0395, B:172:0x039d, B:174:0x03b8, B:176:0x03c0, B:155:0x0309, B:138:0x0289, B:103:0x01f4, B:105:0x01fa, B:108:0x0204, B:110:0x020a, B:113:0x0213, B:115:0x0219, B:118:0x0224, B:120:0x022a, B:123:0x0235, B:125:0x023b, B:86:0x0151, B:89:0x015d, B:93:0x0169, B:39:0x00c7, B:42:0x00d1, B:45:0x00da, B:48:0x00e5, B:51:0x00f0, B:149:0x02c0, B:135:0x026f, B:159:0x0340), top: B:187:0x002b, inners: #0, #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0219 A[Catch: Exception -> 0x03cb, TryCatch #1 {Exception -> 0x03cb, blocks: (B:5:0x002b, B:7:0x0031, B:9:0x0043, B:12:0x005a, B:14:0x0060, B:16:0x0066, B:18:0x006c, B:20:0x0072, B:22:0x0080, B:25:0x0087, B:26:0x009d, B:28:0x009f, B:31:0x00ac, B:33:0x00b4, B:36:0x00bd, B:56:0x00fe, B:58:0x0106, B:60:0x010c, B:62:0x0112, B:77:0x012f, B:83:0x0143, B:98:0x0178, B:100:0x01ea, B:129:0x0248, B:133:0x0262, B:139:0x028c, B:141:0x0296, B:142:0x029e, B:146:0x02ab, B:148:0x02b1, B:153:0x02e0, B:152:0x02dd, B:154:0x02e4, B:156:0x0329, B:158:0x0331, B:163:0x0359, B:162:0x0356, B:164:0x035c, B:166:0x0364, B:167:0x0376, B:169:0x037e, B:170:0x0395, B:172:0x039d, B:174:0x03b8, B:176:0x03c0, B:155:0x0309, B:138:0x0289, B:103:0x01f4, B:105:0x01fa, B:108:0x0204, B:110:0x020a, B:113:0x0213, B:115:0x0219, B:118:0x0224, B:120:0x022a, B:123:0x0235, B:125:0x023b, B:86:0x0151, B:89:0x015d, B:93:0x0169, B:39:0x00c7, B:42:0x00d1, B:45:0x00da, B:48:0x00e5, B:51:0x00f0, B:149:0x02c0, B:135:0x026f, B:159:0x0340), top: B:187:0x002b, inners: #0, #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:120:0x022a A[Catch: Exception -> 0x03cb, TryCatch #1 {Exception -> 0x03cb, blocks: (B:5:0x002b, B:7:0x0031, B:9:0x0043, B:12:0x005a, B:14:0x0060, B:16:0x0066, B:18:0x006c, B:20:0x0072, B:22:0x0080, B:25:0x0087, B:26:0x009d, B:28:0x009f, B:31:0x00ac, B:33:0x00b4, B:36:0x00bd, B:56:0x00fe, B:58:0x0106, B:60:0x010c, B:62:0x0112, B:77:0x012f, B:83:0x0143, B:98:0x0178, B:100:0x01ea, B:129:0x0248, B:133:0x0262, B:139:0x028c, B:141:0x0296, B:142:0x029e, B:146:0x02ab, B:148:0x02b1, B:153:0x02e0, B:152:0x02dd, B:154:0x02e4, B:156:0x0329, B:158:0x0331, B:163:0x0359, B:162:0x0356, B:164:0x035c, B:166:0x0364, B:167:0x0376, B:169:0x037e, B:170:0x0395, B:172:0x039d, B:174:0x03b8, B:176:0x03c0, B:155:0x0309, B:138:0x0289, B:103:0x01f4, B:105:0x01fa, B:108:0x0204, B:110:0x020a, B:113:0x0213, B:115:0x0219, B:118:0x0224, B:120:0x022a, B:123:0x0235, B:125:0x023b, B:86:0x0151, B:89:0x015d, B:93:0x0169, B:39:0x00c7, B:42:0x00d1, B:45:0x00da, B:48:0x00e5, B:51:0x00f0, B:149:0x02c0, B:135:0x026f, B:159:0x0340), top: B:187:0x002b, inners: #0, #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:125:0x023b A[Catch: Exception -> 0x03cb, TryCatch #1 {Exception -> 0x03cb, blocks: (B:5:0x002b, B:7:0x0031, B:9:0x0043, B:12:0x005a, B:14:0x0060, B:16:0x0066, B:18:0x006c, B:20:0x0072, B:22:0x0080, B:25:0x0087, B:26:0x009d, B:28:0x009f, B:31:0x00ac, B:33:0x00b4, B:36:0x00bd, B:56:0x00fe, B:58:0x0106, B:60:0x010c, B:62:0x0112, B:77:0x012f, B:83:0x0143, B:98:0x0178, B:100:0x01ea, B:129:0x0248, B:133:0x0262, B:139:0x028c, B:141:0x0296, B:142:0x029e, B:146:0x02ab, B:148:0x02b1, B:153:0x02e0, B:152:0x02dd, B:154:0x02e4, B:156:0x0329, B:158:0x0331, B:163:0x0359, B:162:0x0356, B:164:0x035c, B:166:0x0364, B:167:0x0376, B:169:0x037e, B:170:0x0395, B:172:0x039d, B:174:0x03b8, B:176:0x03c0, B:155:0x0309, B:138:0x0289, B:103:0x01f4, B:105:0x01fa, B:108:0x0204, B:110:0x020a, B:113:0x0213, B:115:0x0219, B:118:0x0224, B:120:0x022a, B:123:0x0235, B:125:0x023b, B:86:0x0151, B:89:0x015d, B:93:0x0169, B:39:0x00c7, B:42:0x00d1, B:45:0x00da, B:48:0x00e5, B:51:0x00f0, B:149:0x02c0, B:135:0x026f, B:159:0x0340), top: B:187:0x002b, inners: #0, #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:131:0x025f  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0261  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x026f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0106 A[Catch: Exception -> 0x03cb, TryCatch #1 {Exception -> 0x03cb, blocks: (B:5:0x002b, B:7:0x0031, B:9:0x0043, B:12:0x005a, B:14:0x0060, B:16:0x0066, B:18:0x006c, B:20:0x0072, B:22:0x0080, B:25:0x0087, B:26:0x009d, B:28:0x009f, B:31:0x00ac, B:33:0x00b4, B:36:0x00bd, B:56:0x00fe, B:58:0x0106, B:60:0x010c, B:62:0x0112, B:77:0x012f, B:83:0x0143, B:98:0x0178, B:100:0x01ea, B:129:0x0248, B:133:0x0262, B:139:0x028c, B:141:0x0296, B:142:0x029e, B:146:0x02ab, B:148:0x02b1, B:153:0x02e0, B:152:0x02dd, B:154:0x02e4, B:156:0x0329, B:158:0x0331, B:163:0x0359, B:162:0x0356, B:164:0x035c, B:166:0x0364, B:167:0x0376, B:169:0x037e, B:170:0x0395, B:172:0x039d, B:174:0x03b8, B:176:0x03c0, B:155:0x0309, B:138:0x0289, B:103:0x01f4, B:105:0x01fa, B:108:0x0204, B:110:0x020a, B:113:0x0213, B:115:0x0219, B:118:0x0224, B:120:0x022a, B:123:0x0235, B:125:0x023b, B:86:0x0151, B:89:0x015d, B:93:0x0169, B:39:0x00c7, B:42:0x00d1, B:45:0x00da, B:48:0x00e5, B:51:0x00f0, B:149:0x02c0, B:135:0x026f, B:159:0x0340), top: B:187:0x002b, inners: #0, #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0112 A[Catch: Exception -> 0x03cb, TryCatch #1 {Exception -> 0x03cb, blocks: (B:5:0x002b, B:7:0x0031, B:9:0x0043, B:12:0x005a, B:14:0x0060, B:16:0x0066, B:18:0x006c, B:20:0x0072, B:22:0x0080, B:25:0x0087, B:26:0x009d, B:28:0x009f, B:31:0x00ac, B:33:0x00b4, B:36:0x00bd, B:56:0x00fe, B:58:0x0106, B:60:0x010c, B:62:0x0112, B:77:0x012f, B:83:0x0143, B:98:0x0178, B:100:0x01ea, B:129:0x0248, B:133:0x0262, B:139:0x028c, B:141:0x0296, B:142:0x029e, B:146:0x02ab, B:148:0x02b1, B:153:0x02e0, B:152:0x02dd, B:154:0x02e4, B:156:0x0329, B:158:0x0331, B:163:0x0359, B:162:0x0356, B:164:0x035c, B:166:0x0364, B:167:0x0376, B:169:0x037e, B:170:0x0395, B:172:0x039d, B:174:0x03b8, B:176:0x03c0, B:155:0x0309, B:138:0x0289, B:103:0x01f4, B:105:0x01fa, B:108:0x0204, B:110:0x020a, B:113:0x0213, B:115:0x0219, B:118:0x0224, B:120:0x022a, B:123:0x0235, B:125:0x023b, B:86:0x0151, B:89:0x015d, B:93:0x0169, B:39:0x00c7, B:42:0x00d1, B:45:0x00da, B:48:0x00e5, B:51:0x00f0, B:149:0x02c0, B:135:0x026f, B:159:0x0340), top: B:187:0x002b, inners: #0, #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0143 A[Catch: Exception -> 0x03cb, TryCatch #1 {Exception -> 0x03cb, blocks: (B:5:0x002b, B:7:0x0031, B:9:0x0043, B:12:0x005a, B:14:0x0060, B:16:0x0066, B:18:0x006c, B:20:0x0072, B:22:0x0080, B:25:0x0087, B:26:0x009d, B:28:0x009f, B:31:0x00ac, B:33:0x00b4, B:36:0x00bd, B:56:0x00fe, B:58:0x0106, B:60:0x010c, B:62:0x0112, B:77:0x012f, B:83:0x0143, B:98:0x0178, B:100:0x01ea, B:129:0x0248, B:133:0x0262, B:139:0x028c, B:141:0x0296, B:142:0x029e, B:146:0x02ab, B:148:0x02b1, B:153:0x02e0, B:152:0x02dd, B:154:0x02e4, B:156:0x0329, B:158:0x0331, B:163:0x0359, B:162:0x0356, B:164:0x035c, B:166:0x0364, B:167:0x0376, B:169:0x037e, B:170:0x0395, B:172:0x039d, B:174:0x03b8, B:176:0x03c0, B:155:0x0309, B:138:0x0289, B:103:0x01f4, B:105:0x01fa, B:108:0x0204, B:110:0x020a, B:113:0x0213, B:115:0x0219, B:118:0x0224, B:120:0x022a, B:123:0x0235, B:125:0x023b, B:86:0x0151, B:89:0x015d, B:93:0x0169, B:39:0x00c7, B:42:0x00d1, B:45:0x00da, B:48:0x00e5, B:51:0x00f0, B:149:0x02c0, B:135:0x026f, B:159:0x0340), top: B:187:0x002b, inners: #0, #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0173  */
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
        int i5;
        String str;
        int i6;
        int i7;
        int i8;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.PUSH_SCHEME_MID_ACTIVITY_ONCREATE_START_STAMP_KEY);
            at4.v(this);
            super.onCreate(bundle);
            try {
                Intent intent = getIntent();
                if (intent != null) {
                    String uri = intent.getData().toString();
                    at4.t(uri, false);
                    if (uri.contains("tbyunpushnotifybody=")) {
                        JSONObject jSONObject = new JSONObject(uri.substring(uri.indexOf("tbyunpushnotifybody=") + 20));
                        String str2 = "";
                        String string2 = !jSONObject.isNull("task_id") ? jSONObject.getString("task_id") : "";
                        String string3 = !jSONObject.isNull("service_id") ? jSONObject.getString("service_id") : "";
                        if (!jSONObject.isNull("jump_scheme")) {
                            String string4 = jSONObject.getString("jump_scheme");
                            if (!Uri.parse(string4).isOpaque()) {
                                str2 = string4;
                            } else if (ln4.e()) {
                                throw new IllegalStateException(string4 + "：scheme 格式非法");
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
                                string = jSONObject.isNull(MainTabActivityConfig.PUSH_DES_PAGE) ? null : jSONObject.getString(MainTabActivityConfig.PUSH_DES_PAGE);
                                if (optInt == 1) {
                                    i3 = 2;
                                    i2 = 2;
                                } else {
                                    i2 = 2;
                                    i3 = optInt == 2 ? 1 : 0;
                                }
                                int i9 = optInt == i2 ? 1 : 0;
                                i4 = i;
                                if (string == null && optInt == 1) {
                                    i5 = string.equals(getString(R.string.obfuscated_res_0x7f0f04d2)) ? 1 : 2;
                                } else {
                                    i5 = 0;
                                }
                                if (str2 != null) {
                                    str = string;
                                    if (str2.contains("type=interaction")) {
                                        i6 = optInt;
                                        i7 = 2;
                                    } else if (str2.contains("type=recommend")) {
                                        i6 = optInt;
                                        i7 = 3;
                                    } else {
                                        if (str2.contains("type=attention-bazhu")) {
                                            i7 = 4;
                                        } else {
                                            i7 = str2.contains("type=attention-common") ? 5 : 5;
                                        }
                                        i6 = optInt;
                                    }
                                    StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.PUSH_CCLICK).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", 2).param("task_id", string2).param("service_id", string3).param("shoubai_cuid", TbadkCoreApplication.getInst().getCuidGalaxy2()).param(TiebaStatic.Params.OBJ_TO, str2).param("obj_locate", i3).param("obj_param1", i9).param(TiebaStatic.Params.OBJ_PARAM2, i5).param(TiebaStatic.Params.OBJ_PARAM3, i7).param("hdid", TbadkCoreApplication.getInst().getHdid()).param("obj_id", TbadkCoreApplication.getInst().getStartType()).param(TiebaStatic.Params.OBJ_ISHOST, 1);
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
                                    TiebaStatic.log(param);
                                    TiebaStatic.log(new StatisticItem("PushOptCount").param("obj_param1", !et4.a().d() ? 1 : 2));
                                    if (!TextUtils.isEmpty(str2)) {
                                        try {
                                            str2 = Uri.parse(str2).buildUpon().appendQueryParameter("from_yunpush", "1").build().toString();
                                        } catch (Exception e) {
                                            BdLog.e(e);
                                        }
                                        if (et4.a().d()) {
                                            et4.a().i(2);
                                        }
                                        if (z1(str2)) {
                                            int i10 = -1;
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
                                                i10 = 3;
                                            }
                                            MainTabActivityConfig mainTabActivityConfig = new MainTabActivityConfig(this);
                                            mainTabActivityConfig.setTargetScheme(str2);
                                            mainTabActivityConfig.setPushFollowUpAction(i6);
                                            mainTabActivityConfig.setPushDesPage(str);
                                            mainTabActivityConfig.setBottomTab(i10);
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
                                i6 = optInt;
                                i7 = 1;
                                StatisticItem param4 = new StatisticItem(TbadkCoreStatisticKey.PUSH_CCLICK).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", 2).param("task_id", string2).param("service_id", string3).param("shoubai_cuid", TbadkCoreApplication.getInst().getCuidGalaxy2()).param(TiebaStatic.Params.OBJ_TO, str2).param("obj_locate", i3).param("obj_param1", i9).param(TiebaStatic.Params.OBJ_PARAM2, i5).param(TiebaStatic.Params.OBJ_PARAM3, i7).param("hdid", TbadkCoreApplication.getInst().getHdid()).param("obj_id", TbadkCoreApplication.getInst().getStartType()).param(TiebaStatic.Params.OBJ_ISHOST, 1);
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
                                TiebaStatic.log(param4);
                                TiebaStatic.log(new StatisticItem("PushOptCount").param("obj_param1", !et4.a().d() ? 1 : 2));
                                if (!TextUtils.isEmpty(str2)) {
                                }
                            }
                            i = 1;
                            if (!jSONObject.isNull(MainTabActivityConfig.PUSH_FOLLOW_UP_ACTION)) {
                            }
                            string = jSONObject.isNull(MainTabActivityConfig.PUSH_DES_PAGE) ? null : jSONObject.getString(MainTabActivityConfig.PUSH_DES_PAGE);
                            if (optInt == 1) {
                            }
                            if (optInt == i2) {
                            }
                            i4 = i;
                            if (string == null) {
                            }
                            i5 = 0;
                            if (str2 != null) {
                            }
                            i6 = optInt;
                            i7 = 1;
                            StatisticItem param42 = new StatisticItem(TbadkCoreStatisticKey.PUSH_CCLICK).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", 2).param("task_id", string2).param("service_id", string3).param("shoubai_cuid", TbadkCoreApplication.getInst().getCuidGalaxy2()).param(TiebaStatic.Params.OBJ_TO, str2).param("obj_locate", i3).param("obj_param1", i9).param(TiebaStatic.Params.OBJ_PARAM2, i5).param(TiebaStatic.Params.OBJ_PARAM3, i7).param("hdid", TbadkCoreApplication.getInst().getHdid()).param("obj_id", TbadkCoreApplication.getInst().getStartType()).param(TiebaStatic.Params.OBJ_ISHOST, 1);
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
                            TiebaStatic.log(param42);
                            TiebaStatic.log(new StatisticItem("PushOptCount").param("obj_param1", !et4.a().d() ? 1 : 2));
                            if (!TextUtils.isEmpty(str2)) {
                            }
                        }
                        i = 0;
                        if (!jSONObject.isNull(MainTabActivityConfig.PUSH_FOLLOW_UP_ACTION)) {
                        }
                        string = jSONObject.isNull(MainTabActivityConfig.PUSH_DES_PAGE) ? null : jSONObject.getString(MainTabActivityConfig.PUSH_DES_PAGE);
                        if (optInt == 1) {
                        }
                        if (optInt == i2) {
                        }
                        i4 = i;
                        if (string == null) {
                        }
                        i5 = 0;
                        if (str2 != null) {
                        }
                        i6 = optInt;
                        i7 = 1;
                        StatisticItem param422 = new StatisticItem(TbadkCoreStatisticKey.PUSH_CCLICK).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", 2).param("task_id", string2).param("service_id", string3).param("shoubai_cuid", TbadkCoreApplication.getInst().getCuidGalaxy2()).param(TiebaStatic.Params.OBJ_TO, str2).param("obj_locate", i3).param("obj_param1", i9).param(TiebaStatic.Params.OBJ_PARAM2, i5).param(TiebaStatic.Params.OBJ_PARAM3, i7).param("hdid", TbadkCoreApplication.getInst().getHdid()).param("obj_id", TbadkCoreApplication.getInst().getStartType()).param(TiebaStatic.Params.OBJ_ISHOST, 1);
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
                        param422.param("obj_source", i8);
                        TiebaStatic.log(param422);
                        TiebaStatic.log(new StatisticItem("PushOptCount").param("obj_param1", !et4.a().d() ? 1 : 2));
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
                return !JumpPbDirectSwitch.getIsOn();
            }
            return str.contains(UrlSchemaHelper.HTTP_JUMP_TOPIC_DETAIL) || str.startsWith(UrlSchemaHelper.SCHEMA_TB_FLUTTER) || str.startsWith(UrlSchemaHelper.SCHEMA_LIVE_SDK) || str.startsWith(UrlSchemaHelper.SCHEMA_CHUSHOU_LIVE_SDK) || str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_SWAN) || str.contains("achievement=");
        }
        return invokeL.booleanValue;
    }
}
