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
import com.baidu.prologue.business.data.BaseVM;
import com.baidu.searchbox.launch.stats.SpeedStatsManager;
import com.baidu.searchbox.launch.stats.SpeedStatsStampTable;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.BdToken.BdUniDispatchSchemeController;
import com.baidu.tbadk.GrowthStatsUtil;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.util.schemeaction.SchemeActionHelper;
import com.baidu.tieba.jv4;
import com.baidu.tieba.np4;
import com.baidu.tieba.nv4;
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

    /* JADX WARN: Removed duplicated region for block: B:104:0x020e A[Catch: Exception -> 0x03f7, TryCatch #1 {Exception -> 0x03f7, blocks: (B:5:0x002b, B:7:0x0031, B:9:0x0043, B:12:0x005a, B:14:0x0061, B:16:0x0067, B:18:0x0070, B:20:0x0076, B:22:0x0084, B:25:0x008b, B:26:0x00a1, B:28:0x00a4, B:31:0x00ac, B:33:0x00b4, B:36:0x00bd, B:56:0x00fe, B:58:0x0106, B:60:0x010c, B:62:0x0112, B:75:0x0132, B:88:0x0164, B:97:0x018c, B:99:0x01fe, B:128:0x025c, B:132:0x0272, B:133:0x0279, B:137:0x0290, B:143:0x02ba, B:145:0x02c4, B:146:0x02cc, B:150:0x02d7, B:152:0x02dd, B:157:0x030c, B:156:0x0309, B:158:0x0310, B:160:0x0355, B:162:0x035d, B:167:0x0385, B:166:0x0382, B:168:0x0388, B:170:0x0390, B:171:0x03a2, B:173:0x03aa, B:174:0x03c1, B:176:0x03c9, B:178:0x03e4, B:180:0x03ec, B:159:0x0335, B:142:0x02b7, B:102:0x0208, B:104:0x020e, B:107:0x0218, B:109:0x021e, B:112:0x0227, B:114:0x022d, B:117:0x0238, B:119:0x023e, B:122:0x0249, B:124:0x024f, B:92:0x0176, B:78:0x013f, B:81:0x014a, B:84:0x0156, B:39:0x00c7, B:42:0x00d1, B:45:0x00da, B:48:0x00e5, B:51:0x00f0, B:153:0x02ec, B:139:0x029d, B:163:0x036c), top: B:191:0x002b, inners: #0, #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:114:0x022d A[Catch: Exception -> 0x03f7, TryCatch #1 {Exception -> 0x03f7, blocks: (B:5:0x002b, B:7:0x0031, B:9:0x0043, B:12:0x005a, B:14:0x0061, B:16:0x0067, B:18:0x0070, B:20:0x0076, B:22:0x0084, B:25:0x008b, B:26:0x00a1, B:28:0x00a4, B:31:0x00ac, B:33:0x00b4, B:36:0x00bd, B:56:0x00fe, B:58:0x0106, B:60:0x010c, B:62:0x0112, B:75:0x0132, B:88:0x0164, B:97:0x018c, B:99:0x01fe, B:128:0x025c, B:132:0x0272, B:133:0x0279, B:137:0x0290, B:143:0x02ba, B:145:0x02c4, B:146:0x02cc, B:150:0x02d7, B:152:0x02dd, B:157:0x030c, B:156:0x0309, B:158:0x0310, B:160:0x0355, B:162:0x035d, B:167:0x0385, B:166:0x0382, B:168:0x0388, B:170:0x0390, B:171:0x03a2, B:173:0x03aa, B:174:0x03c1, B:176:0x03c9, B:178:0x03e4, B:180:0x03ec, B:159:0x0335, B:142:0x02b7, B:102:0x0208, B:104:0x020e, B:107:0x0218, B:109:0x021e, B:112:0x0227, B:114:0x022d, B:117:0x0238, B:119:0x023e, B:122:0x0249, B:124:0x024f, B:92:0x0176, B:78:0x013f, B:81:0x014a, B:84:0x0156, B:39:0x00c7, B:42:0x00d1, B:45:0x00da, B:48:0x00e5, B:51:0x00f0, B:153:0x02ec, B:139:0x029d, B:163:0x036c), top: B:191:0x002b, inners: #0, #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:119:0x023e A[Catch: Exception -> 0x03f7, TryCatch #1 {Exception -> 0x03f7, blocks: (B:5:0x002b, B:7:0x0031, B:9:0x0043, B:12:0x005a, B:14:0x0061, B:16:0x0067, B:18:0x0070, B:20:0x0076, B:22:0x0084, B:25:0x008b, B:26:0x00a1, B:28:0x00a4, B:31:0x00ac, B:33:0x00b4, B:36:0x00bd, B:56:0x00fe, B:58:0x0106, B:60:0x010c, B:62:0x0112, B:75:0x0132, B:88:0x0164, B:97:0x018c, B:99:0x01fe, B:128:0x025c, B:132:0x0272, B:133:0x0279, B:137:0x0290, B:143:0x02ba, B:145:0x02c4, B:146:0x02cc, B:150:0x02d7, B:152:0x02dd, B:157:0x030c, B:156:0x0309, B:158:0x0310, B:160:0x0355, B:162:0x035d, B:167:0x0385, B:166:0x0382, B:168:0x0388, B:170:0x0390, B:171:0x03a2, B:173:0x03aa, B:174:0x03c1, B:176:0x03c9, B:178:0x03e4, B:180:0x03ec, B:159:0x0335, B:142:0x02b7, B:102:0x0208, B:104:0x020e, B:107:0x0218, B:109:0x021e, B:112:0x0227, B:114:0x022d, B:117:0x0238, B:119:0x023e, B:122:0x0249, B:124:0x024f, B:92:0x0176, B:78:0x013f, B:81:0x014a, B:84:0x0156, B:39:0x00c7, B:42:0x00d1, B:45:0x00da, B:48:0x00e5, B:51:0x00f0, B:153:0x02ec, B:139:0x029d, B:163:0x036c), top: B:191:0x002b, inners: #0, #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:124:0x024f A[Catch: Exception -> 0x03f7, TryCatch #1 {Exception -> 0x03f7, blocks: (B:5:0x002b, B:7:0x0031, B:9:0x0043, B:12:0x005a, B:14:0x0061, B:16:0x0067, B:18:0x0070, B:20:0x0076, B:22:0x0084, B:25:0x008b, B:26:0x00a1, B:28:0x00a4, B:31:0x00ac, B:33:0x00b4, B:36:0x00bd, B:56:0x00fe, B:58:0x0106, B:60:0x010c, B:62:0x0112, B:75:0x0132, B:88:0x0164, B:97:0x018c, B:99:0x01fe, B:128:0x025c, B:132:0x0272, B:133:0x0279, B:137:0x0290, B:143:0x02ba, B:145:0x02c4, B:146:0x02cc, B:150:0x02d7, B:152:0x02dd, B:157:0x030c, B:156:0x0309, B:158:0x0310, B:160:0x0355, B:162:0x035d, B:167:0x0385, B:166:0x0382, B:168:0x0388, B:170:0x0390, B:171:0x03a2, B:173:0x03aa, B:174:0x03c1, B:176:0x03c9, B:178:0x03e4, B:180:0x03ec, B:159:0x0335, B:142:0x02b7, B:102:0x0208, B:104:0x020e, B:107:0x0218, B:109:0x021e, B:112:0x0227, B:114:0x022d, B:117:0x0238, B:119:0x023e, B:122:0x0249, B:124:0x024f, B:92:0x0176, B:78:0x013f, B:81:0x014a, B:84:0x0156, B:39:0x00c7, B:42:0x00d1, B:45:0x00da, B:48:0x00e5, B:51:0x00f0, B:153:0x02ec, B:139:0x029d, B:163:0x036c), top: B:191:0x002b, inners: #0, #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0271  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x028d  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x028f  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x029d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00ac A[Catch: Exception -> 0x03f7, TRY_ENTER, TryCatch #1 {Exception -> 0x03f7, blocks: (B:5:0x002b, B:7:0x0031, B:9:0x0043, B:12:0x005a, B:14:0x0061, B:16:0x0067, B:18:0x0070, B:20:0x0076, B:22:0x0084, B:25:0x008b, B:26:0x00a1, B:28:0x00a4, B:31:0x00ac, B:33:0x00b4, B:36:0x00bd, B:56:0x00fe, B:58:0x0106, B:60:0x010c, B:62:0x0112, B:75:0x0132, B:88:0x0164, B:97:0x018c, B:99:0x01fe, B:128:0x025c, B:132:0x0272, B:133:0x0279, B:137:0x0290, B:143:0x02ba, B:145:0x02c4, B:146:0x02cc, B:150:0x02d7, B:152:0x02dd, B:157:0x030c, B:156:0x0309, B:158:0x0310, B:160:0x0355, B:162:0x035d, B:167:0x0385, B:166:0x0382, B:168:0x0388, B:170:0x0390, B:171:0x03a2, B:173:0x03aa, B:174:0x03c1, B:176:0x03c9, B:178:0x03e4, B:180:0x03ec, B:159:0x0335, B:142:0x02b7, B:102:0x0208, B:104:0x020e, B:107:0x0218, B:109:0x021e, B:112:0x0227, B:114:0x022d, B:117:0x0238, B:119:0x023e, B:122:0x0249, B:124:0x024f, B:92:0x0176, B:78:0x013f, B:81:0x014a, B:84:0x0156, B:39:0x00c7, B:42:0x00d1, B:45:0x00da, B:48:0x00e5, B:51:0x00f0, B:153:0x02ec, B:139:0x029d, B:163:0x036c), top: B:191:0x002b, inners: #0, #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0106 A[Catch: Exception -> 0x03f7, TryCatch #1 {Exception -> 0x03f7, blocks: (B:5:0x002b, B:7:0x0031, B:9:0x0043, B:12:0x005a, B:14:0x0061, B:16:0x0067, B:18:0x0070, B:20:0x0076, B:22:0x0084, B:25:0x008b, B:26:0x00a1, B:28:0x00a4, B:31:0x00ac, B:33:0x00b4, B:36:0x00bd, B:56:0x00fe, B:58:0x0106, B:60:0x010c, B:62:0x0112, B:75:0x0132, B:88:0x0164, B:97:0x018c, B:99:0x01fe, B:128:0x025c, B:132:0x0272, B:133:0x0279, B:137:0x0290, B:143:0x02ba, B:145:0x02c4, B:146:0x02cc, B:150:0x02d7, B:152:0x02dd, B:157:0x030c, B:156:0x0309, B:158:0x0310, B:160:0x0355, B:162:0x035d, B:167:0x0385, B:166:0x0382, B:168:0x0388, B:170:0x0390, B:171:0x03a2, B:173:0x03aa, B:174:0x03c1, B:176:0x03c9, B:178:0x03e4, B:180:0x03ec, B:159:0x0335, B:142:0x02b7, B:102:0x0208, B:104:0x020e, B:107:0x0218, B:109:0x021e, B:112:0x0227, B:114:0x022d, B:117:0x0238, B:119:0x023e, B:122:0x0249, B:124:0x024f, B:92:0x0176, B:78:0x013f, B:81:0x014a, B:84:0x0156, B:39:0x00c7, B:42:0x00d1, B:45:0x00da, B:48:0x00e5, B:51:0x00f0, B:153:0x02ec, B:139:0x029d, B:163:0x036c), top: B:191:0x002b, inners: #0, #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0112 A[Catch: Exception -> 0x03f7, TryCatch #1 {Exception -> 0x03f7, blocks: (B:5:0x002b, B:7:0x0031, B:9:0x0043, B:12:0x005a, B:14:0x0061, B:16:0x0067, B:18:0x0070, B:20:0x0076, B:22:0x0084, B:25:0x008b, B:26:0x00a1, B:28:0x00a4, B:31:0x00ac, B:33:0x00b4, B:36:0x00bd, B:56:0x00fe, B:58:0x0106, B:60:0x010c, B:62:0x0112, B:75:0x0132, B:88:0x0164, B:97:0x018c, B:99:0x01fe, B:128:0x025c, B:132:0x0272, B:133:0x0279, B:137:0x0290, B:143:0x02ba, B:145:0x02c4, B:146:0x02cc, B:150:0x02d7, B:152:0x02dd, B:157:0x030c, B:156:0x0309, B:158:0x0310, B:160:0x0355, B:162:0x035d, B:167:0x0385, B:166:0x0382, B:168:0x0388, B:170:0x0390, B:171:0x03a2, B:173:0x03aa, B:174:0x03c1, B:176:0x03c9, B:178:0x03e4, B:180:0x03ec, B:159:0x0335, B:142:0x02b7, B:102:0x0208, B:104:0x020e, B:107:0x0218, B:109:0x021e, B:112:0x0227, B:114:0x022d, B:117:0x0238, B:119:0x023e, B:122:0x0249, B:124:0x024f, B:92:0x0176, B:78:0x013f, B:81:0x014a, B:84:0x0156, B:39:0x00c7, B:42:0x00d1, B:45:0x00da, B:48:0x00e5, B:51:0x00f0, B:153:0x02ec, B:139:0x029d, B:163:0x036c), top: B:191:0x002b, inners: #0, #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0132 A[Catch: Exception -> 0x03f7, TryCatch #1 {Exception -> 0x03f7, blocks: (B:5:0x002b, B:7:0x0031, B:9:0x0043, B:12:0x005a, B:14:0x0061, B:16:0x0067, B:18:0x0070, B:20:0x0076, B:22:0x0084, B:25:0x008b, B:26:0x00a1, B:28:0x00a4, B:31:0x00ac, B:33:0x00b4, B:36:0x00bd, B:56:0x00fe, B:58:0x0106, B:60:0x010c, B:62:0x0112, B:75:0x0132, B:88:0x0164, B:97:0x018c, B:99:0x01fe, B:128:0x025c, B:132:0x0272, B:133:0x0279, B:137:0x0290, B:143:0x02ba, B:145:0x02c4, B:146:0x02cc, B:150:0x02d7, B:152:0x02dd, B:157:0x030c, B:156:0x0309, B:158:0x0310, B:160:0x0355, B:162:0x035d, B:167:0x0385, B:166:0x0382, B:168:0x0388, B:170:0x0390, B:171:0x03a2, B:173:0x03aa, B:174:0x03c1, B:176:0x03c9, B:178:0x03e4, B:180:0x03ec, B:159:0x0335, B:142:0x02b7, B:102:0x0208, B:104:0x020e, B:107:0x0218, B:109:0x021e, B:112:0x0227, B:114:0x022d, B:117:0x0238, B:119:0x023e, B:122:0x0249, B:124:0x024f, B:92:0x0176, B:78:0x013f, B:81:0x014a, B:84:0x0156, B:39:0x00c7, B:42:0x00d1, B:45:0x00da, B:48:0x00e5, B:51:0x00f0, B:153:0x02ec, B:139:0x029d, B:163:0x036c), top: B:191:0x002b, inners: #0, #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01fe A[Catch: Exception -> 0x03f7, TryCatch #1 {Exception -> 0x03f7, blocks: (B:5:0x002b, B:7:0x0031, B:9:0x0043, B:12:0x005a, B:14:0x0061, B:16:0x0067, B:18:0x0070, B:20:0x0076, B:22:0x0084, B:25:0x008b, B:26:0x00a1, B:28:0x00a4, B:31:0x00ac, B:33:0x00b4, B:36:0x00bd, B:56:0x00fe, B:58:0x0106, B:60:0x010c, B:62:0x0112, B:75:0x0132, B:88:0x0164, B:97:0x018c, B:99:0x01fe, B:128:0x025c, B:132:0x0272, B:133:0x0279, B:137:0x0290, B:143:0x02ba, B:145:0x02c4, B:146:0x02cc, B:150:0x02d7, B:152:0x02dd, B:157:0x030c, B:156:0x0309, B:158:0x0310, B:160:0x0355, B:162:0x035d, B:167:0x0385, B:166:0x0382, B:168:0x0388, B:170:0x0390, B:171:0x03a2, B:173:0x03aa, B:174:0x03c1, B:176:0x03c9, B:178:0x03e4, B:180:0x03ec, B:159:0x0335, B:142:0x02b7, B:102:0x0208, B:104:0x020e, B:107:0x0218, B:109:0x021e, B:112:0x0227, B:114:0x022d, B:117:0x0238, B:119:0x023e, B:122:0x0249, B:124:0x024f, B:92:0x0176, B:78:0x013f, B:81:0x014a, B:84:0x0156, B:39:0x00c7, B:42:0x00d1, B:45:0x00da, B:48:0x00e5, B:51:0x00f0, B:153:0x02ec, B:139:0x029d, B:163:0x036c), top: B:191:0x002b, inners: #0, #2, #3 }] */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onCreate(Bundle bundle) {
        String str;
        int i;
        int optInt;
        int i2;
        int i3;
        int i4;
        String str2;
        String str3;
        int i5;
        int i6;
        int i7;
        int i8;
        Matcher matcher;
        int i9;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.PUSH_SCHEME_MID_ACTIVITY_ONCREATE_START_STAMP_KEY);
            jv4.u(this);
            super.onCreate(bundle);
            try {
                Intent intent = getIntent();
                if (intent != null) {
                    String uri = intent.getData().toString();
                    jv4.s(uri, false);
                    if (uri.contains("tbyunpushnotifybody=")) {
                        JSONObject jSONObject = new JSONObject(uri.substring(uri.indexOf("tbyunpushnotifybody=") + 20));
                        String string = !jSONObject.isNull("task_id") ? jSONObject.getString("task_id") : "";
                        String string2 = !jSONObject.isNull("service_id") ? jSONObject.getString("service_id") : "";
                        if (!jSONObject.isNull("jump_scheme")) {
                            str = jSONObject.getString("jump_scheme");
                            if (Uri.parse(str).isOpaque()) {
                                if (np4.e()) {
                                    throw new IllegalStateException(str + "：scheme 格式非法");
                                }
                            }
                            if (!StringUtils.isNull(str)) {
                                if (!str.equals(UrlSchemaHelper.JUMP_TO_CHAT) && !str.startsWith(UrlSchemaHelper.SCHEMA_FANS_PAGE)) {
                                    if (str.contains(UrlSchemaHelper.GOTO_OFFICIAL_CHAT)) {
                                        i = 2;
                                    } else if (str.contains(UrlSchemaHelper.GOTO_PERSONAL_CHAT)) {
                                        i = 3;
                                    } else if (str.startsWith(UrlSchemaHelper.SCHEMA_REPLY_ME)) {
                                        i = 10;
                                    } else if (str.startsWith(UrlSchemaHelper.SCHEMA_AGREE_ME)) {
                                        i = 11;
                                    } else if (str.startsWith(UrlSchemaHelper.SCHEMA_AT_ME)) {
                                        i = 12;
                                    } else if (str.startsWith("flt://SignTogetherPage")) {
                                        i = 14;
                                    }
                                    optInt = jSONObject.isNull(MainTabActivityConfig.PUSH_FOLLOW_UP_ACTION) ? jSONObject.optInt(MainTabActivityConfig.PUSH_FOLLOW_UP_ACTION) : 0;
                                    int i10 = i;
                                    String string3 = jSONObject.isNull(MainTabActivityConfig.PUSH_DES_PAGE) ? null : jSONObject.getString(MainTabActivityConfig.PUSH_DES_PAGE);
                                    if (optInt != 1) {
                                        i3 = i10;
                                        i4 = 2;
                                        i2 = 2;
                                    } else {
                                        i2 = 2;
                                        i3 = i10;
                                        i4 = optInt == 2 ? 1 : 0;
                                    }
                                    int i11 = optInt != i2 ? 1 : 0;
                                    if (str == null) {
                                        str2 = string3;
                                        if (str.contains("type=interaction")) {
                                            i9 = 2;
                                        } else if (str.contains("type=recommend")) {
                                            i9 = 3;
                                        } else if (str.contains("type=attention-bazhu")) {
                                            i9 = 4;
                                        } else {
                                            i9 = str.contains("type=attention-common") ? 5 : 1;
                                        }
                                        if (str.contains("force_jump=frs")) {
                                            str3 = "pid";
                                            i7 = 6;
                                        } else {
                                            str3 = "pid";
                                            i7 = str.contains("force_jump=maintab") ? 1 : 0;
                                        }
                                        int i12 = i9;
                                        i5 = optInt;
                                        i6 = i12;
                                    } else {
                                        str2 = string3;
                                        str3 = "pid";
                                        i5 = optInt;
                                        i6 = 1;
                                        i7 = 0;
                                    }
                                    StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.PUSH_CCLICK).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", 2).param("task_id", string).param("service_id", string2).param("shoubai_cuid", TbadkCoreApplication.getInst().getCuidGalaxy2()).param(TiebaStatic.Params.OBJ_TO, str).param("obj_locate", i4).param("obj_param1", i11).param(TiebaStatic.Params.OBJ_PARAM2, i7).param(TiebaStatic.Params.OBJ_PARAM3, i6).param("hdid", TbadkCoreApplication.getInst().getHdid()).param("obj_id", TbadkCoreApplication.getInst().getStartType()).param(TiebaStatic.Params.OBJ_ISHOST, 1);
                                    if (TextUtils.isEmpty(str) && str.contains("HotThreadList")) {
                                        i8 = 6;
                                    } else {
                                        if ((!TextUtils.isEmpty(str) || !str.contains("HotInteraction")) && (TextUtils.isEmpty(str) || !str.contains("frs?kw="))) {
                                            if (TextUtils.isEmpty(str) && str.contains("collect")) {
                                                i8 = 8;
                                            } else if (TextUtils.isEmpty(str) && str.contains("push_type=question_answer_invite")) {
                                                i8 = 15;
                                            } else {
                                                i8 = (TextUtils.isEmpty(str) && str.contains("push_type=answer_top")) ? 16 : i3;
                                            }
                                        }
                                        i8 = 7;
                                    }
                                    param.param("obj_source", i8);
                                    matcher = Pattern.compile(UrlSchemaHelper.PB_URL).matcher(str);
                                    if (matcher.find()) {
                                        param.addParam("tid", matcher.group(1));
                                    }
                                    TiebaStatic.log(param);
                                    TiebaStatic.log(new StatisticItem("PushOptCount").param("obj_param1", !nv4.a().d() ? 1 : 2));
                                    if (!TextUtils.isEmpty(str)) {
                                        try {
                                            str = Uri.parse(str).buildUpon().appendQueryParameter("from_yunpush", "1").build().toString();
                                        } catch (Exception e) {
                                            BdLog.e(e);
                                        }
                                        if (nv4.a().d()) {
                                            nv4.a().i(2);
                                        }
                                        if (z1(str)) {
                                            int i13 = -1;
                                            if (str.startsWith(UrlSchemaHelper.SCHEMA_REPLY_ME)) {
                                                StatisticItem param2 = new StatisticItem(TbadkCoreStatisticKey.KEY_MSG_REPLY_CLICK).param("uid", TbadkCoreApplication.getCurrentAccountId());
                                                try {
                                                    Uri parse = Uri.parse(str);
                                                    String queryParameter = parse.getQueryParameter("fid");
                                                    String queryParameter2 = parse.getQueryParameter("tid");
                                                    String str4 = str3;
                                                    String queryParameter3 = parse.getQueryParameter(str4);
                                                    param2.param("fid", queryParameter);
                                                    param2.param(str4, queryParameter3);
                                                    param2.param("tid", queryParameter2);
                                                } catch (Exception e2) {
                                                    BdLog.e(e2);
                                                }
                                                TiebaStatic.log(param2);
                                                i13 = 3;
                                            }
                                            MainTabActivityConfig mainTabActivityConfig = new MainTabActivityConfig(this);
                                            mainTabActivityConfig.setTargetScheme(str);
                                            mainTabActivityConfig.setPushFollowUpAction(i5);
                                            mainTabActivityConfig.setPushDesPage(str2);
                                            mainTabActivityConfig.setBottomTab(i13);
                                            MessageManager.getInstance().sendMessage(new CustomMessage(2015002, mainTabActivityConfig));
                                        } else {
                                            GrowthStatsUtil.statisticChannel("push", str);
                                            Class.forName("com.baidu.tieba.imMessageCenter.im.chat.PersonalChatActivityStatic");
                                            UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{str, UrlManager.YUN_PUSH_TAG});
                                        }
                                        if (str.contains("ForumGradePage")) {
                                            StatisticItem param3 = new StatisticItem("c13782").param("uid", TbadkCoreApplication.getCurrentAccountId());
                                            try {
                                                Uri parse2 = Uri.parse(str);
                                                String queryParameter4 = parse2.getQueryParameter("forum_id");
                                                String queryParameter5 = parse2.getQueryParameter("obj_type");
                                                param3.param("fid", queryParameter4);
                                                param3.param("obj_type", queryParameter5);
                                            } catch (Exception e3) {
                                                BdLog.e(e3);
                                            }
                                            TiebaStatic.log(param3);
                                        }
                                        if (str.contains("unidispatch/hotuserrank")) {
                                            TiebaStatic.log(new StatisticItem("c13662").param("uid", TbadkCoreApplication.getCurrentAccountId()));
                                        }
                                        if (str.contains("weeklygodview")) {
                                            TiebaStatic.log(new StatisticItem("c13691").param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_source", 2));
                                        }
                                        if (str.contains(PbModel.UNIDISPATCH_PB)) {
                                            Uri parse3 = Uri.parse(str);
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
                                if (jSONObject.isNull(MainTabActivityConfig.PUSH_FOLLOW_UP_ACTION)) {
                                }
                                int i102 = i;
                                String string32 = jSONObject.isNull(MainTabActivityConfig.PUSH_DES_PAGE) ? null : jSONObject.getString(MainTabActivityConfig.PUSH_DES_PAGE);
                                if (optInt != 1) {
                                }
                                if (optInt != i2) {
                                }
                                if (str == null) {
                                }
                                StatisticItem param4 = new StatisticItem(TbadkCoreStatisticKey.PUSH_CCLICK).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", 2).param("task_id", string).param("service_id", string2).param("shoubai_cuid", TbadkCoreApplication.getInst().getCuidGalaxy2()).param(TiebaStatic.Params.OBJ_TO, str).param("obj_locate", i4).param("obj_param1", i11).param(TiebaStatic.Params.OBJ_PARAM2, i7).param(TiebaStatic.Params.OBJ_PARAM3, i6).param("hdid", TbadkCoreApplication.getInst().getHdid()).param("obj_id", TbadkCoreApplication.getInst().getStartType()).param(TiebaStatic.Params.OBJ_ISHOST, 1);
                                if (TextUtils.isEmpty(str)) {
                                }
                                if (!TextUtils.isEmpty(str)) {
                                }
                                if (TextUtils.isEmpty(str)) {
                                }
                                if (TextUtils.isEmpty(str)) {
                                }
                                if (TextUtils.isEmpty(str)) {
                                }
                                param4.param("obj_source", i8);
                                matcher = Pattern.compile(UrlSchemaHelper.PB_URL).matcher(str);
                                if (matcher.find()) {
                                }
                                TiebaStatic.log(param4);
                                TiebaStatic.log(new StatisticItem("PushOptCount").param("obj_param1", !nv4.a().d() ? 1 : 2));
                                if (!TextUtils.isEmpty(str)) {
                                }
                            }
                            i = 0;
                            if (jSONObject.isNull(MainTabActivityConfig.PUSH_FOLLOW_UP_ACTION)) {
                            }
                            int i1022 = i;
                            String string322 = jSONObject.isNull(MainTabActivityConfig.PUSH_DES_PAGE) ? null : jSONObject.getString(MainTabActivityConfig.PUSH_DES_PAGE);
                            if (optInt != 1) {
                            }
                            if (optInt != i2) {
                            }
                            if (str == null) {
                            }
                            StatisticItem param42 = new StatisticItem(TbadkCoreStatisticKey.PUSH_CCLICK).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", 2).param("task_id", string).param("service_id", string2).param("shoubai_cuid", TbadkCoreApplication.getInst().getCuidGalaxy2()).param(TiebaStatic.Params.OBJ_TO, str).param("obj_locate", i4).param("obj_param1", i11).param(TiebaStatic.Params.OBJ_PARAM2, i7).param(TiebaStatic.Params.OBJ_PARAM3, i6).param("hdid", TbadkCoreApplication.getInst().getHdid()).param("obj_id", TbadkCoreApplication.getInst().getStartType()).param(TiebaStatic.Params.OBJ_ISHOST, 1);
                            if (TextUtils.isEmpty(str)) {
                            }
                            if (!TextUtils.isEmpty(str)) {
                            }
                            if (TextUtils.isEmpty(str)) {
                            }
                            if (TextUtils.isEmpty(str)) {
                            }
                            if (TextUtils.isEmpty(str)) {
                            }
                            param42.param("obj_source", i8);
                            matcher = Pattern.compile(UrlSchemaHelper.PB_URL).matcher(str);
                            if (matcher.find()) {
                            }
                            TiebaStatic.log(param42);
                            TiebaStatic.log(new StatisticItem("PushOptCount").param("obj_param1", !nv4.a().d() ? 1 : 2));
                            if (!TextUtils.isEmpty(str)) {
                            }
                        }
                        str = "";
                        if (!StringUtils.isNull(str)) {
                        }
                        i = 0;
                        if (jSONObject.isNull(MainTabActivityConfig.PUSH_FOLLOW_UP_ACTION)) {
                        }
                        int i10222 = i;
                        String string3222 = jSONObject.isNull(MainTabActivityConfig.PUSH_DES_PAGE) ? null : jSONObject.getString(MainTabActivityConfig.PUSH_DES_PAGE);
                        if (optInt != 1) {
                        }
                        if (optInt != i2) {
                        }
                        if (str == null) {
                        }
                        StatisticItem param422 = new StatisticItem(TbadkCoreStatisticKey.PUSH_CCLICK).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", 2).param("task_id", string).param("service_id", string2).param("shoubai_cuid", TbadkCoreApplication.getInst().getCuidGalaxy2()).param(TiebaStatic.Params.OBJ_TO, str).param("obj_locate", i4).param("obj_param1", i11).param(TiebaStatic.Params.OBJ_PARAM2, i7).param(TiebaStatic.Params.OBJ_PARAM3, i6).param("hdid", TbadkCoreApplication.getInst().getHdid()).param("obj_id", TbadkCoreApplication.getInst().getStartType()).param(TiebaStatic.Params.OBJ_ISHOST, 1);
                        if (TextUtils.isEmpty(str)) {
                        }
                        if (!TextUtils.isEmpty(str)) {
                        }
                        if (TextUtils.isEmpty(str)) {
                        }
                        if (TextUtils.isEmpty(str)) {
                        }
                        if (TextUtils.isEmpty(str)) {
                        }
                        param422.param("obj_source", i8);
                        matcher = Pattern.compile(UrlSchemaHelper.PB_URL).matcher(str);
                        if (matcher.find()) {
                        }
                        TiebaStatic.log(param422);
                        TiebaStatic.log(new StatisticItem("PushOptCount").param("obj_param1", !nv4.a().d() ? 1 : 2));
                        if (!TextUtils.isEmpty(str)) {
                        }
                    }
                }
            } catch (Exception e4) {
                BdLog.e(e4);
            }
            BaseVM.m(3);
            TbSingleton.getInstance().setPushOrSchemeLog(true);
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
