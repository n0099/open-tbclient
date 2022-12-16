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
import com.baidu.tieba.fx4;
import com.baidu.tieba.jx4;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.vq4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;
/* loaded from: classes7.dex */
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

    /* JADX WARN: Removed duplicated region for block: B:104:0x020f A[Catch: Exception -> 0x03f9, TryCatch #1 {Exception -> 0x03f9, blocks: (B:5:0x002b, B:7:0x0031, B:9:0x0043, B:12:0x005a, B:14:0x0061, B:16:0x0067, B:18:0x0070, B:20:0x0076, B:22:0x0084, B:25:0x008b, B:26:0x00a2, B:28:0x00a5, B:31:0x00ad, B:33:0x00b5, B:36:0x00be, B:56:0x00ff, B:58:0x0107, B:60:0x010d, B:62:0x0113, B:75:0x0133, B:88:0x0165, B:97:0x018d, B:99:0x01ff, B:128:0x025d, B:132:0x0273, B:133:0x027a, B:137:0x0291, B:143:0x02bb, B:145:0x02c5, B:146:0x02cd, B:150:0x02d8, B:152:0x02de, B:157:0x030d, B:156:0x030a, B:158:0x0311, B:160:0x0357, B:162:0x035f, B:167:0x0387, B:166:0x0384, B:168:0x038a, B:170:0x0392, B:171:0x03a4, B:173:0x03ac, B:174:0x03c3, B:176:0x03cb, B:178:0x03e6, B:180:0x03ee, B:159:0x0336, B:142:0x02b8, B:102:0x0209, B:104:0x020f, B:107:0x0219, B:109:0x021f, B:112:0x0228, B:114:0x022e, B:117:0x0239, B:119:0x023f, B:122:0x024a, B:124:0x0250, B:92:0x0177, B:78:0x0140, B:81:0x014b, B:84:0x0157, B:39:0x00c8, B:42:0x00d2, B:45:0x00db, B:48:0x00e6, B:51:0x00f1, B:153:0x02ed, B:139:0x029e, B:163:0x036e), top: B:191:0x002b, inners: #0, #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:114:0x022e A[Catch: Exception -> 0x03f9, TryCatch #1 {Exception -> 0x03f9, blocks: (B:5:0x002b, B:7:0x0031, B:9:0x0043, B:12:0x005a, B:14:0x0061, B:16:0x0067, B:18:0x0070, B:20:0x0076, B:22:0x0084, B:25:0x008b, B:26:0x00a2, B:28:0x00a5, B:31:0x00ad, B:33:0x00b5, B:36:0x00be, B:56:0x00ff, B:58:0x0107, B:60:0x010d, B:62:0x0113, B:75:0x0133, B:88:0x0165, B:97:0x018d, B:99:0x01ff, B:128:0x025d, B:132:0x0273, B:133:0x027a, B:137:0x0291, B:143:0x02bb, B:145:0x02c5, B:146:0x02cd, B:150:0x02d8, B:152:0x02de, B:157:0x030d, B:156:0x030a, B:158:0x0311, B:160:0x0357, B:162:0x035f, B:167:0x0387, B:166:0x0384, B:168:0x038a, B:170:0x0392, B:171:0x03a4, B:173:0x03ac, B:174:0x03c3, B:176:0x03cb, B:178:0x03e6, B:180:0x03ee, B:159:0x0336, B:142:0x02b8, B:102:0x0209, B:104:0x020f, B:107:0x0219, B:109:0x021f, B:112:0x0228, B:114:0x022e, B:117:0x0239, B:119:0x023f, B:122:0x024a, B:124:0x0250, B:92:0x0177, B:78:0x0140, B:81:0x014b, B:84:0x0157, B:39:0x00c8, B:42:0x00d2, B:45:0x00db, B:48:0x00e6, B:51:0x00f1, B:153:0x02ed, B:139:0x029e, B:163:0x036e), top: B:191:0x002b, inners: #0, #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:119:0x023f A[Catch: Exception -> 0x03f9, TryCatch #1 {Exception -> 0x03f9, blocks: (B:5:0x002b, B:7:0x0031, B:9:0x0043, B:12:0x005a, B:14:0x0061, B:16:0x0067, B:18:0x0070, B:20:0x0076, B:22:0x0084, B:25:0x008b, B:26:0x00a2, B:28:0x00a5, B:31:0x00ad, B:33:0x00b5, B:36:0x00be, B:56:0x00ff, B:58:0x0107, B:60:0x010d, B:62:0x0113, B:75:0x0133, B:88:0x0165, B:97:0x018d, B:99:0x01ff, B:128:0x025d, B:132:0x0273, B:133:0x027a, B:137:0x0291, B:143:0x02bb, B:145:0x02c5, B:146:0x02cd, B:150:0x02d8, B:152:0x02de, B:157:0x030d, B:156:0x030a, B:158:0x0311, B:160:0x0357, B:162:0x035f, B:167:0x0387, B:166:0x0384, B:168:0x038a, B:170:0x0392, B:171:0x03a4, B:173:0x03ac, B:174:0x03c3, B:176:0x03cb, B:178:0x03e6, B:180:0x03ee, B:159:0x0336, B:142:0x02b8, B:102:0x0209, B:104:0x020f, B:107:0x0219, B:109:0x021f, B:112:0x0228, B:114:0x022e, B:117:0x0239, B:119:0x023f, B:122:0x024a, B:124:0x0250, B:92:0x0177, B:78:0x0140, B:81:0x014b, B:84:0x0157, B:39:0x00c8, B:42:0x00d2, B:45:0x00db, B:48:0x00e6, B:51:0x00f1, B:153:0x02ed, B:139:0x029e, B:163:0x036e), top: B:191:0x002b, inners: #0, #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0250 A[Catch: Exception -> 0x03f9, TryCatch #1 {Exception -> 0x03f9, blocks: (B:5:0x002b, B:7:0x0031, B:9:0x0043, B:12:0x005a, B:14:0x0061, B:16:0x0067, B:18:0x0070, B:20:0x0076, B:22:0x0084, B:25:0x008b, B:26:0x00a2, B:28:0x00a5, B:31:0x00ad, B:33:0x00b5, B:36:0x00be, B:56:0x00ff, B:58:0x0107, B:60:0x010d, B:62:0x0113, B:75:0x0133, B:88:0x0165, B:97:0x018d, B:99:0x01ff, B:128:0x025d, B:132:0x0273, B:133:0x027a, B:137:0x0291, B:143:0x02bb, B:145:0x02c5, B:146:0x02cd, B:150:0x02d8, B:152:0x02de, B:157:0x030d, B:156:0x030a, B:158:0x0311, B:160:0x0357, B:162:0x035f, B:167:0x0387, B:166:0x0384, B:168:0x038a, B:170:0x0392, B:171:0x03a4, B:173:0x03ac, B:174:0x03c3, B:176:0x03cb, B:178:0x03e6, B:180:0x03ee, B:159:0x0336, B:142:0x02b8, B:102:0x0209, B:104:0x020f, B:107:0x0219, B:109:0x021f, B:112:0x0228, B:114:0x022e, B:117:0x0239, B:119:0x023f, B:122:0x024a, B:124:0x0250, B:92:0x0177, B:78:0x0140, B:81:0x014b, B:84:0x0157, B:39:0x00c8, B:42:0x00d2, B:45:0x00db, B:48:0x00e6, B:51:0x00f1, B:153:0x02ed, B:139:0x029e, B:163:0x036e), top: B:191:0x002b, inners: #0, #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0272  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x028e  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0290  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x029e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00ad A[Catch: Exception -> 0x03f9, TRY_ENTER, TryCatch #1 {Exception -> 0x03f9, blocks: (B:5:0x002b, B:7:0x0031, B:9:0x0043, B:12:0x005a, B:14:0x0061, B:16:0x0067, B:18:0x0070, B:20:0x0076, B:22:0x0084, B:25:0x008b, B:26:0x00a2, B:28:0x00a5, B:31:0x00ad, B:33:0x00b5, B:36:0x00be, B:56:0x00ff, B:58:0x0107, B:60:0x010d, B:62:0x0113, B:75:0x0133, B:88:0x0165, B:97:0x018d, B:99:0x01ff, B:128:0x025d, B:132:0x0273, B:133:0x027a, B:137:0x0291, B:143:0x02bb, B:145:0x02c5, B:146:0x02cd, B:150:0x02d8, B:152:0x02de, B:157:0x030d, B:156:0x030a, B:158:0x0311, B:160:0x0357, B:162:0x035f, B:167:0x0387, B:166:0x0384, B:168:0x038a, B:170:0x0392, B:171:0x03a4, B:173:0x03ac, B:174:0x03c3, B:176:0x03cb, B:178:0x03e6, B:180:0x03ee, B:159:0x0336, B:142:0x02b8, B:102:0x0209, B:104:0x020f, B:107:0x0219, B:109:0x021f, B:112:0x0228, B:114:0x022e, B:117:0x0239, B:119:0x023f, B:122:0x024a, B:124:0x0250, B:92:0x0177, B:78:0x0140, B:81:0x014b, B:84:0x0157, B:39:0x00c8, B:42:0x00d2, B:45:0x00db, B:48:0x00e6, B:51:0x00f1, B:153:0x02ed, B:139:0x029e, B:163:0x036e), top: B:191:0x002b, inners: #0, #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0107 A[Catch: Exception -> 0x03f9, TryCatch #1 {Exception -> 0x03f9, blocks: (B:5:0x002b, B:7:0x0031, B:9:0x0043, B:12:0x005a, B:14:0x0061, B:16:0x0067, B:18:0x0070, B:20:0x0076, B:22:0x0084, B:25:0x008b, B:26:0x00a2, B:28:0x00a5, B:31:0x00ad, B:33:0x00b5, B:36:0x00be, B:56:0x00ff, B:58:0x0107, B:60:0x010d, B:62:0x0113, B:75:0x0133, B:88:0x0165, B:97:0x018d, B:99:0x01ff, B:128:0x025d, B:132:0x0273, B:133:0x027a, B:137:0x0291, B:143:0x02bb, B:145:0x02c5, B:146:0x02cd, B:150:0x02d8, B:152:0x02de, B:157:0x030d, B:156:0x030a, B:158:0x0311, B:160:0x0357, B:162:0x035f, B:167:0x0387, B:166:0x0384, B:168:0x038a, B:170:0x0392, B:171:0x03a4, B:173:0x03ac, B:174:0x03c3, B:176:0x03cb, B:178:0x03e6, B:180:0x03ee, B:159:0x0336, B:142:0x02b8, B:102:0x0209, B:104:0x020f, B:107:0x0219, B:109:0x021f, B:112:0x0228, B:114:0x022e, B:117:0x0239, B:119:0x023f, B:122:0x024a, B:124:0x0250, B:92:0x0177, B:78:0x0140, B:81:0x014b, B:84:0x0157, B:39:0x00c8, B:42:0x00d2, B:45:0x00db, B:48:0x00e6, B:51:0x00f1, B:153:0x02ed, B:139:0x029e, B:163:0x036e), top: B:191:0x002b, inners: #0, #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0113 A[Catch: Exception -> 0x03f9, TryCatch #1 {Exception -> 0x03f9, blocks: (B:5:0x002b, B:7:0x0031, B:9:0x0043, B:12:0x005a, B:14:0x0061, B:16:0x0067, B:18:0x0070, B:20:0x0076, B:22:0x0084, B:25:0x008b, B:26:0x00a2, B:28:0x00a5, B:31:0x00ad, B:33:0x00b5, B:36:0x00be, B:56:0x00ff, B:58:0x0107, B:60:0x010d, B:62:0x0113, B:75:0x0133, B:88:0x0165, B:97:0x018d, B:99:0x01ff, B:128:0x025d, B:132:0x0273, B:133:0x027a, B:137:0x0291, B:143:0x02bb, B:145:0x02c5, B:146:0x02cd, B:150:0x02d8, B:152:0x02de, B:157:0x030d, B:156:0x030a, B:158:0x0311, B:160:0x0357, B:162:0x035f, B:167:0x0387, B:166:0x0384, B:168:0x038a, B:170:0x0392, B:171:0x03a4, B:173:0x03ac, B:174:0x03c3, B:176:0x03cb, B:178:0x03e6, B:180:0x03ee, B:159:0x0336, B:142:0x02b8, B:102:0x0209, B:104:0x020f, B:107:0x0219, B:109:0x021f, B:112:0x0228, B:114:0x022e, B:117:0x0239, B:119:0x023f, B:122:0x024a, B:124:0x0250, B:92:0x0177, B:78:0x0140, B:81:0x014b, B:84:0x0157, B:39:0x00c8, B:42:0x00d2, B:45:0x00db, B:48:0x00e6, B:51:0x00f1, B:153:0x02ed, B:139:0x029e, B:163:0x036e), top: B:191:0x002b, inners: #0, #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0133 A[Catch: Exception -> 0x03f9, TryCatch #1 {Exception -> 0x03f9, blocks: (B:5:0x002b, B:7:0x0031, B:9:0x0043, B:12:0x005a, B:14:0x0061, B:16:0x0067, B:18:0x0070, B:20:0x0076, B:22:0x0084, B:25:0x008b, B:26:0x00a2, B:28:0x00a5, B:31:0x00ad, B:33:0x00b5, B:36:0x00be, B:56:0x00ff, B:58:0x0107, B:60:0x010d, B:62:0x0113, B:75:0x0133, B:88:0x0165, B:97:0x018d, B:99:0x01ff, B:128:0x025d, B:132:0x0273, B:133:0x027a, B:137:0x0291, B:143:0x02bb, B:145:0x02c5, B:146:0x02cd, B:150:0x02d8, B:152:0x02de, B:157:0x030d, B:156:0x030a, B:158:0x0311, B:160:0x0357, B:162:0x035f, B:167:0x0387, B:166:0x0384, B:168:0x038a, B:170:0x0392, B:171:0x03a4, B:173:0x03ac, B:174:0x03c3, B:176:0x03cb, B:178:0x03e6, B:180:0x03ee, B:159:0x0336, B:142:0x02b8, B:102:0x0209, B:104:0x020f, B:107:0x0219, B:109:0x021f, B:112:0x0228, B:114:0x022e, B:117:0x0239, B:119:0x023f, B:122:0x024a, B:124:0x0250, B:92:0x0177, B:78:0x0140, B:81:0x014b, B:84:0x0157, B:39:0x00c8, B:42:0x00d2, B:45:0x00db, B:48:0x00e6, B:51:0x00f1, B:153:0x02ed, B:139:0x029e, B:163:0x036e), top: B:191:0x002b, inners: #0, #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01ff A[Catch: Exception -> 0x03f9, TryCatch #1 {Exception -> 0x03f9, blocks: (B:5:0x002b, B:7:0x0031, B:9:0x0043, B:12:0x005a, B:14:0x0061, B:16:0x0067, B:18:0x0070, B:20:0x0076, B:22:0x0084, B:25:0x008b, B:26:0x00a2, B:28:0x00a5, B:31:0x00ad, B:33:0x00b5, B:36:0x00be, B:56:0x00ff, B:58:0x0107, B:60:0x010d, B:62:0x0113, B:75:0x0133, B:88:0x0165, B:97:0x018d, B:99:0x01ff, B:128:0x025d, B:132:0x0273, B:133:0x027a, B:137:0x0291, B:143:0x02bb, B:145:0x02c5, B:146:0x02cd, B:150:0x02d8, B:152:0x02de, B:157:0x030d, B:156:0x030a, B:158:0x0311, B:160:0x0357, B:162:0x035f, B:167:0x0387, B:166:0x0384, B:168:0x038a, B:170:0x0392, B:171:0x03a4, B:173:0x03ac, B:174:0x03c3, B:176:0x03cb, B:178:0x03e6, B:180:0x03ee, B:159:0x0336, B:142:0x02b8, B:102:0x0209, B:104:0x020f, B:107:0x0219, B:109:0x021f, B:112:0x0228, B:114:0x022e, B:117:0x0239, B:119:0x023f, B:122:0x024a, B:124:0x0250, B:92:0x0177, B:78:0x0140, B:81:0x014b, B:84:0x0157, B:39:0x00c8, B:42:0x00d2, B:45:0x00db, B:48:0x00e6, B:51:0x00f1, B:153:0x02ed, B:139:0x029e, B:163:0x036e), top: B:191:0x002b, inners: #0, #2, #3 }] */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onCreate(Bundle bundle) {
        String str;
        String str2;
        String str3;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        String str4;
        String str5;
        int i7;
        int i8;
        int i9;
        int i10;
        Matcher matcher;
        int i11;
        int i12;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.PUSH_SCHEME_MID_ACTIVITY_ONCREATE_START_STAMP_KEY);
            fx4.t(this);
            super.onCreate(bundle);
            try {
                Intent intent = getIntent();
                if (intent != null) {
                    String uri = intent.getData().toString();
                    fx4.r(uri, false);
                    if (uri.contains("tbyunpushnotifybody=")) {
                        JSONObject jSONObject = new JSONObject(uri.substring(uri.indexOf("tbyunpushnotifybody=") + 20));
                        if (jSONObject.isNull("task_id")) {
                            str = "";
                        } else {
                            str = jSONObject.getString("task_id");
                        }
                        if (jSONObject.isNull("service_id")) {
                            str2 = "";
                        } else {
                            str2 = jSONObject.getString("service_id");
                        }
                        if (!jSONObject.isNull("jump_scheme")) {
                            str3 = jSONObject.getString("jump_scheme");
                            if (Uri.parse(str3).isOpaque()) {
                                if (vq4.e()) {
                                    throw new IllegalStateException(str3 + "：scheme 格式非法");
                                }
                            }
                            if (!StringUtils.isNull(str3)) {
                                if (!str3.equals(UrlSchemaHelper.JUMP_TO_CHAT) && !str3.startsWith(UrlSchemaHelper.SCHEMA_FANS_PAGE)) {
                                    if (str3.contains(UrlSchemaHelper.GOTO_OFFICIAL_CHAT)) {
                                        i = 2;
                                    } else if (str3.contains(UrlSchemaHelper.GOTO_PERSONAL_CHAT)) {
                                        i = 3;
                                    } else if (str3.startsWith(UrlSchemaHelper.SCHEMA_REPLY_ME)) {
                                        i = 10;
                                    } else if (str3.startsWith(UrlSchemaHelper.SCHEMA_AGREE_ME)) {
                                        i = 11;
                                    } else if (str3.startsWith(UrlSchemaHelper.SCHEMA_AT_ME)) {
                                        i = 12;
                                    } else if (str3.startsWith("flt://SignTogetherPage")) {
                                        i = 14;
                                    }
                                    String str6 = null;
                                    if (jSONObject.isNull(MainTabActivityConfig.PUSH_FOLLOW_UP_ACTION)) {
                                        i2 = jSONObject.optInt(MainTabActivityConfig.PUSH_FOLLOW_UP_ACTION);
                                    } else {
                                        i2 = 0;
                                    }
                                    if (!jSONObject.isNull(MainTabActivityConfig.PUSH_DES_PAGE)) {
                                        str6 = jSONObject.getString(MainTabActivityConfig.PUSH_DES_PAGE);
                                    }
                                    int i13 = i;
                                    String str7 = str6;
                                    if (i2 != 1) {
                                        i4 = i13;
                                        i5 = 2;
                                        i3 = 2;
                                    } else {
                                        i3 = 2;
                                        i4 = i13;
                                        if (i2 == 2) {
                                            i5 = 1;
                                        } else {
                                            i5 = 0;
                                        }
                                    }
                                    if (i2 != i3) {
                                        i6 = 1;
                                    } else {
                                        i6 = 0;
                                    }
                                    if (str3 == null) {
                                        str4 = str7;
                                        if (str3.contains("type=interaction")) {
                                            i12 = 2;
                                        } else if (str3.contains("type=recommend")) {
                                            i12 = 3;
                                        } else if (str3.contains("type=attention-bazhu")) {
                                            i12 = 4;
                                        } else if (str3.contains("type=attention-common")) {
                                            i12 = 5;
                                        } else {
                                            i12 = 1;
                                        }
                                        if (str3.contains("force_jump=frs")) {
                                            str5 = "pid";
                                            i9 = 6;
                                        } else {
                                            str5 = "pid";
                                            if (str3.contains("force_jump=maintab")) {
                                                i9 = 1;
                                            } else {
                                                i9 = 0;
                                            }
                                        }
                                        int i14 = i12;
                                        i7 = i2;
                                        i8 = i14;
                                    } else {
                                        str4 = str7;
                                        str5 = "pid";
                                        i7 = i2;
                                        i8 = 1;
                                        i9 = 0;
                                    }
                                    StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.PUSH_CCLICK).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", 2).param("task_id", str).param("service_id", str2).param("shoubai_cuid", TbadkCoreApplication.getInst().getCuidGalaxy2()).param(TiebaStatic.Params.OBJ_TO, str3).param("obj_locate", i5).param("obj_param1", i6).param(TiebaStatic.Params.OBJ_PARAM2, i9).param(TiebaStatic.Params.OBJ_PARAM3, i8).param("hdid", TbadkCoreApplication.getInst().getHdid()).param("obj_id", TbadkCoreApplication.getInst().getStartType()).param(TiebaStatic.Params.OBJ_ISHOST, 1);
                                    if (TextUtils.isEmpty(str3) && str3.contains("HotThreadList")) {
                                        i10 = 6;
                                    } else {
                                        if ((!TextUtils.isEmpty(str3) || !str3.contains("HotInteraction")) && (TextUtils.isEmpty(str3) || !str3.contains("frs?kw="))) {
                                            if (TextUtils.isEmpty(str3) && str3.contains("collect")) {
                                                i10 = 8;
                                            } else if (TextUtils.isEmpty(str3) && str3.contains("push_type=question_answer_invite")) {
                                                i10 = 15;
                                            } else if (TextUtils.isEmpty(str3) && str3.contains("push_type=answer_top")) {
                                                i10 = 16;
                                            } else {
                                                i10 = i4;
                                            }
                                        }
                                        i10 = 7;
                                    }
                                    param.param("obj_source", i10);
                                    matcher = Pattern.compile(UrlSchemaHelper.PB_URL).matcher(str3);
                                    if (matcher.find()) {
                                        param.addParam("tid", matcher.group(1));
                                    }
                                    TiebaStatic.log(param);
                                    StatisticItem statisticItem = new StatisticItem("PushOptCount");
                                    if (!jx4.a().d()) {
                                        i11 = 1;
                                    } else {
                                        i11 = 2;
                                    }
                                    TiebaStatic.log(statisticItem.param("obj_param1", i11));
                                    if (!TextUtils.isEmpty(str3)) {
                                        try {
                                            str3 = Uri.parse(str3).buildUpon().appendQueryParameter("from_yunpush", "1").build().toString();
                                        } catch (Exception e) {
                                            BdLog.e(e);
                                        }
                                        if (jx4.a().d()) {
                                            jx4.a().i(2);
                                        }
                                        if (v1(str3)) {
                                            int i15 = -1;
                                            if (str3.startsWith(UrlSchemaHelper.SCHEMA_REPLY_ME)) {
                                                StatisticItem param2 = new StatisticItem(TbadkCoreStatisticKey.KEY_MSG_REPLY_CLICK).param("uid", TbadkCoreApplication.getCurrentAccountId());
                                                try {
                                                    Uri parse = Uri.parse(str3);
                                                    String queryParameter = parse.getQueryParameter("fid");
                                                    String queryParameter2 = parse.getQueryParameter("tid");
                                                    String str8 = str5;
                                                    String queryParameter3 = parse.getQueryParameter(str8);
                                                    param2.param("fid", queryParameter);
                                                    param2.param(str8, queryParameter3);
                                                    param2.param("tid", queryParameter2);
                                                } catch (Exception e2) {
                                                    BdLog.e(e2);
                                                }
                                                TiebaStatic.log(param2);
                                                i15 = 3;
                                            }
                                            MainTabActivityConfig mainTabActivityConfig = new MainTabActivityConfig(this);
                                            mainTabActivityConfig.setTargetScheme(str3);
                                            mainTabActivityConfig.setPushFollowUpAction(i7);
                                            mainTabActivityConfig.setPushDesPage(str4);
                                            mainTabActivityConfig.setBottomTab(i15);
                                            MessageManager.getInstance().sendMessage(new CustomMessage(2015002, mainTabActivityConfig));
                                        } else {
                                            GrowthStatsUtil.statisticChannel("push", str3);
                                            Class.forName("com.baidu.tieba.imMessageCenter.im.chat.PersonalChatActivityStatic");
                                            UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{str3, UrlManager.YUN_PUSH_TAG});
                                        }
                                        if (str3.contains("ForumGradePage")) {
                                            StatisticItem param3 = new StatisticItem("c13782").param("uid", TbadkCoreApplication.getCurrentAccountId());
                                            try {
                                                Uri parse2 = Uri.parse(str3);
                                                String queryParameter4 = parse2.getQueryParameter("forum_id");
                                                String queryParameter5 = parse2.getQueryParameter("obj_type");
                                                param3.param("fid", queryParameter4);
                                                param3.param("obj_type", queryParameter5);
                                            } catch (Exception e3) {
                                                BdLog.e(e3);
                                            }
                                            TiebaStatic.log(param3);
                                        }
                                        if (str3.contains("unidispatch/hotuserrank")) {
                                            TiebaStatic.log(new StatisticItem("c13662").param("uid", TbadkCoreApplication.getCurrentAccountId()));
                                        }
                                        if (str3.contains("weeklygodview")) {
                                            TiebaStatic.log(new StatisticItem("c13691").param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_source", 2));
                                        }
                                        if (str3.contains(PbModel.UNIDISPATCH_PB)) {
                                            Uri parse3 = Uri.parse(str3);
                                            String queryParameter6 = parse3.getQueryParameter("obj_param1");
                                            String queryParameter7 = parse3.getQueryParameter("tid");
                                            StatisticItem statisticItem2 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_FROM_OUTSIDE);
                                            if (BdUniDispatchSchemeController.PARAM_VIDEO.equals(queryParameter6) || "2".equals(queryParameter6)) {
                                                statisticItem2.param("obj_source", 1);
                                                statisticItem2.param("tid", queryParameter7);
                                                TiebaStatic.log(statisticItem2);
                                            }
                                        }
                                    }
                                }
                                i = 1;
                                String str62 = null;
                                if (jSONObject.isNull(MainTabActivityConfig.PUSH_FOLLOW_UP_ACTION)) {
                                }
                                if (!jSONObject.isNull(MainTabActivityConfig.PUSH_DES_PAGE)) {
                                }
                                int i132 = i;
                                String str72 = str62;
                                if (i2 != 1) {
                                }
                                if (i2 != i3) {
                                }
                                if (str3 == null) {
                                }
                                StatisticItem param4 = new StatisticItem(TbadkCoreStatisticKey.PUSH_CCLICK).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", 2).param("task_id", str).param("service_id", str2).param("shoubai_cuid", TbadkCoreApplication.getInst().getCuidGalaxy2()).param(TiebaStatic.Params.OBJ_TO, str3).param("obj_locate", i5).param("obj_param1", i6).param(TiebaStatic.Params.OBJ_PARAM2, i9).param(TiebaStatic.Params.OBJ_PARAM3, i8).param("hdid", TbadkCoreApplication.getInst().getHdid()).param("obj_id", TbadkCoreApplication.getInst().getStartType()).param(TiebaStatic.Params.OBJ_ISHOST, 1);
                                if (TextUtils.isEmpty(str3)) {
                                }
                                if (!TextUtils.isEmpty(str3)) {
                                }
                                if (TextUtils.isEmpty(str3)) {
                                }
                                if (TextUtils.isEmpty(str3)) {
                                }
                                if (TextUtils.isEmpty(str3)) {
                                }
                                i10 = i4;
                                param4.param("obj_source", i10);
                                matcher = Pattern.compile(UrlSchemaHelper.PB_URL).matcher(str3);
                                if (matcher.find()) {
                                }
                                TiebaStatic.log(param4);
                                StatisticItem statisticItem3 = new StatisticItem("PushOptCount");
                                if (!jx4.a().d()) {
                                }
                                TiebaStatic.log(statisticItem3.param("obj_param1", i11));
                                if (!TextUtils.isEmpty(str3)) {
                                }
                            }
                            i = 0;
                            String str622 = null;
                            if (jSONObject.isNull(MainTabActivityConfig.PUSH_FOLLOW_UP_ACTION)) {
                            }
                            if (!jSONObject.isNull(MainTabActivityConfig.PUSH_DES_PAGE)) {
                            }
                            int i1322 = i;
                            String str722 = str622;
                            if (i2 != 1) {
                            }
                            if (i2 != i3) {
                            }
                            if (str3 == null) {
                            }
                            StatisticItem param42 = new StatisticItem(TbadkCoreStatisticKey.PUSH_CCLICK).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", 2).param("task_id", str).param("service_id", str2).param("shoubai_cuid", TbadkCoreApplication.getInst().getCuidGalaxy2()).param(TiebaStatic.Params.OBJ_TO, str3).param("obj_locate", i5).param("obj_param1", i6).param(TiebaStatic.Params.OBJ_PARAM2, i9).param(TiebaStatic.Params.OBJ_PARAM3, i8).param("hdid", TbadkCoreApplication.getInst().getHdid()).param("obj_id", TbadkCoreApplication.getInst().getStartType()).param(TiebaStatic.Params.OBJ_ISHOST, 1);
                            if (TextUtils.isEmpty(str3)) {
                            }
                            if (!TextUtils.isEmpty(str3)) {
                            }
                            if (TextUtils.isEmpty(str3)) {
                            }
                            if (TextUtils.isEmpty(str3)) {
                            }
                            if (TextUtils.isEmpty(str3)) {
                            }
                            i10 = i4;
                            param42.param("obj_source", i10);
                            matcher = Pattern.compile(UrlSchemaHelper.PB_URL).matcher(str3);
                            if (matcher.find()) {
                            }
                            TiebaStatic.log(param42);
                            StatisticItem statisticItem32 = new StatisticItem("PushOptCount");
                            if (!jx4.a().d()) {
                            }
                            TiebaStatic.log(statisticItem32.param("obj_param1", i11));
                            if (!TextUtils.isEmpty(str3)) {
                            }
                        }
                        str3 = "";
                        if (!StringUtils.isNull(str3)) {
                        }
                        i = 0;
                        String str6222 = null;
                        if (jSONObject.isNull(MainTabActivityConfig.PUSH_FOLLOW_UP_ACTION)) {
                        }
                        if (!jSONObject.isNull(MainTabActivityConfig.PUSH_DES_PAGE)) {
                        }
                        int i13222 = i;
                        String str7222 = str6222;
                        if (i2 != 1) {
                        }
                        if (i2 != i3) {
                        }
                        if (str3 == null) {
                        }
                        StatisticItem param422 = new StatisticItem(TbadkCoreStatisticKey.PUSH_CCLICK).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", 2).param("task_id", str).param("service_id", str2).param("shoubai_cuid", TbadkCoreApplication.getInst().getCuidGalaxy2()).param(TiebaStatic.Params.OBJ_TO, str3).param("obj_locate", i5).param("obj_param1", i6).param(TiebaStatic.Params.OBJ_PARAM2, i9).param(TiebaStatic.Params.OBJ_PARAM3, i8).param("hdid", TbadkCoreApplication.getInst().getHdid()).param("obj_id", TbadkCoreApplication.getInst().getStartType()).param(TiebaStatic.Params.OBJ_ISHOST, 1);
                        if (TextUtils.isEmpty(str3)) {
                        }
                        if (!TextUtils.isEmpty(str3)) {
                        }
                        if (TextUtils.isEmpty(str3)) {
                        }
                        if (TextUtils.isEmpty(str3)) {
                        }
                        if (TextUtils.isEmpty(str3)) {
                        }
                        i10 = i4;
                        param422.param("obj_source", i10);
                        matcher = Pattern.compile(UrlSchemaHelper.PB_URL).matcher(str3);
                        if (matcher.find()) {
                        }
                        TiebaStatic.log(param422);
                        StatisticItem statisticItem322 = new StatisticItem("PushOptCount");
                        if (!jx4.a().d()) {
                        }
                        TiebaStatic.log(statisticItem322.param("obj_param1", i11));
                        if (!TextUtils.isEmpty(str3)) {
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

    public final boolean v1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (SchemeActionHelper.needMainTabActivity(str)) {
                return true;
            }
            if (Pattern.compile("http[s]?://tieba.baidu.com/p").matcher(str).find()) {
                return false;
            }
            if (str.contains(UrlSchemaHelper.HTTP_JUMP_TOPIC_DETAIL) || str.startsWith(UrlSchemaHelper.SCHEMA_TB_FLUTTER) || str.startsWith(UrlSchemaHelper.SCHEMA_LIVE_SDK) || str.startsWith(UrlSchemaHelper.SCHEMA_CHUSHOU_LIVE_SDK) || str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_SWAN) || str.contains("achievement=")) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
