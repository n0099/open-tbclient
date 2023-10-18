package com.baidu.tieba.yunpush;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
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
import com.baidu.tbadk.core.GlobalBuildConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.growthFunnel.GrowthFunnelHelper;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.util.schemeaction.SchemeActionHelper;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.q25;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;
/* loaded from: classes9.dex */
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

    public final boolean M0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
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

    /* JADX WARN: Removed duplicated region for block: B:101:0x021e A[Catch: Exception -> 0x0119, TryCatch #2 {Exception -> 0x0119, blocks: (B:31:0x00c7, B:33:0x00d0, B:36:0x00d9, B:58:0x011f, B:60:0x0127, B:62:0x012d, B:64:0x0133, B:77:0x014e, B:90:0x0184, B:99:0x01ac, B:101:0x021e, B:130:0x027c, B:134:0x0293, B:135:0x029a, B:139:0x02b1, B:145:0x02f0, B:147:0x02fa, B:144:0x02d8, B:104:0x0228, B:106:0x022e, B:109:0x0238, B:111:0x023e, B:114:0x0247, B:116:0x024d, B:119:0x0258, B:121:0x025e, B:124:0x0269, B:126:0x026f, B:94:0x0196, B:80:0x015c, B:83:0x0168, B:86:0x0175, B:39:0x00e3, B:42:0x00ed, B:45:0x00f6, B:48:0x0101, B:51:0x010c, B:141:0x02be), top: B:196:0x00c7, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:106:0x022e A[Catch: Exception -> 0x0119, TryCatch #2 {Exception -> 0x0119, blocks: (B:31:0x00c7, B:33:0x00d0, B:36:0x00d9, B:58:0x011f, B:60:0x0127, B:62:0x012d, B:64:0x0133, B:77:0x014e, B:90:0x0184, B:99:0x01ac, B:101:0x021e, B:130:0x027c, B:134:0x0293, B:135:0x029a, B:139:0x02b1, B:145:0x02f0, B:147:0x02fa, B:144:0x02d8, B:104:0x0228, B:106:0x022e, B:109:0x0238, B:111:0x023e, B:114:0x0247, B:116:0x024d, B:119:0x0258, B:121:0x025e, B:124:0x0269, B:126:0x026f, B:94:0x0196, B:80:0x015c, B:83:0x0168, B:86:0x0175, B:39:0x00e3, B:42:0x00ed, B:45:0x00f6, B:48:0x0101, B:51:0x010c, B:141:0x02be), top: B:196:0x00c7, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:116:0x024d A[Catch: Exception -> 0x0119, TryCatch #2 {Exception -> 0x0119, blocks: (B:31:0x00c7, B:33:0x00d0, B:36:0x00d9, B:58:0x011f, B:60:0x0127, B:62:0x012d, B:64:0x0133, B:77:0x014e, B:90:0x0184, B:99:0x01ac, B:101:0x021e, B:130:0x027c, B:134:0x0293, B:135:0x029a, B:139:0x02b1, B:145:0x02f0, B:147:0x02fa, B:144:0x02d8, B:104:0x0228, B:106:0x022e, B:109:0x0238, B:111:0x023e, B:114:0x0247, B:116:0x024d, B:119:0x0258, B:121:0x025e, B:124:0x0269, B:126:0x026f, B:94:0x0196, B:80:0x015c, B:83:0x0168, B:86:0x0175, B:39:0x00e3, B:42:0x00ed, B:45:0x00f6, B:48:0x0101, B:51:0x010c, B:141:0x02be), top: B:196:0x00c7, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:121:0x025e A[Catch: Exception -> 0x0119, TryCatch #2 {Exception -> 0x0119, blocks: (B:31:0x00c7, B:33:0x00d0, B:36:0x00d9, B:58:0x011f, B:60:0x0127, B:62:0x012d, B:64:0x0133, B:77:0x014e, B:90:0x0184, B:99:0x01ac, B:101:0x021e, B:130:0x027c, B:134:0x0293, B:135:0x029a, B:139:0x02b1, B:145:0x02f0, B:147:0x02fa, B:144:0x02d8, B:104:0x0228, B:106:0x022e, B:109:0x0238, B:111:0x023e, B:114:0x0247, B:116:0x024d, B:119:0x0258, B:121:0x025e, B:124:0x0269, B:126:0x026f, B:94:0x0196, B:80:0x015c, B:83:0x0168, B:86:0x0175, B:39:0x00e3, B:42:0x00ed, B:45:0x00f6, B:48:0x0101, B:51:0x010c, B:141:0x02be), top: B:196:0x00c7, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:126:0x026f A[Catch: Exception -> 0x0119, TryCatch #2 {Exception -> 0x0119, blocks: (B:31:0x00c7, B:33:0x00d0, B:36:0x00d9, B:58:0x011f, B:60:0x0127, B:62:0x012d, B:64:0x0133, B:77:0x014e, B:90:0x0184, B:99:0x01ac, B:101:0x021e, B:130:0x027c, B:134:0x0293, B:135:0x029a, B:139:0x02b1, B:145:0x02f0, B:147:0x02fa, B:144:0x02d8, B:104:0x0228, B:106:0x022e, B:109:0x0238, B:111:0x023e, B:114:0x0247, B:116:0x024d, B:119:0x0258, B:121:0x025e, B:124:0x0269, B:126:0x026f, B:94:0x0196, B:80:0x015c, B:83:0x0168, B:86:0x0175, B:39:0x00e3, B:42:0x00ed, B:45:0x00f6, B:48:0x0101, B:51:0x010c, B:141:0x02be), top: B:196:0x00c7, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0292  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x02ae  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x02b0  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x045c  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x02be A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0127 A[Catch: Exception -> 0x0119, TryCatch #2 {Exception -> 0x0119, blocks: (B:31:0x00c7, B:33:0x00d0, B:36:0x00d9, B:58:0x011f, B:60:0x0127, B:62:0x012d, B:64:0x0133, B:77:0x014e, B:90:0x0184, B:99:0x01ac, B:101:0x021e, B:130:0x027c, B:134:0x0293, B:135:0x029a, B:139:0x02b1, B:145:0x02f0, B:147:0x02fa, B:144:0x02d8, B:104:0x0228, B:106:0x022e, B:109:0x0238, B:111:0x023e, B:114:0x0247, B:116:0x024d, B:119:0x0258, B:121:0x025e, B:124:0x0269, B:126:0x026f, B:94:0x0196, B:80:0x015c, B:83:0x0168, B:86:0x0175, B:39:0x00e3, B:42:0x00ed, B:45:0x00f6, B:48:0x0101, B:51:0x010c, B:141:0x02be), top: B:196:0x00c7, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0133 A[Catch: Exception -> 0x0119, TryCatch #2 {Exception -> 0x0119, blocks: (B:31:0x00c7, B:33:0x00d0, B:36:0x00d9, B:58:0x011f, B:60:0x0127, B:62:0x012d, B:64:0x0133, B:77:0x014e, B:90:0x0184, B:99:0x01ac, B:101:0x021e, B:130:0x027c, B:134:0x0293, B:135:0x029a, B:139:0x02b1, B:145:0x02f0, B:147:0x02fa, B:144:0x02d8, B:104:0x0228, B:106:0x022e, B:109:0x0238, B:111:0x023e, B:114:0x0247, B:116:0x024d, B:119:0x0258, B:121:0x025e, B:124:0x0269, B:126:0x026f, B:94:0x0196, B:80:0x015c, B:83:0x0168, B:86:0x0175, B:39:0x00e3, B:42:0x00ed, B:45:0x00f6, B:48:0x0101, B:51:0x010c, B:141:0x02be), top: B:196:0x00c7, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x014e A[Catch: Exception -> 0x0119, TryCatch #2 {Exception -> 0x0119, blocks: (B:31:0x00c7, B:33:0x00d0, B:36:0x00d9, B:58:0x011f, B:60:0x0127, B:62:0x012d, B:64:0x0133, B:77:0x014e, B:90:0x0184, B:99:0x01ac, B:101:0x021e, B:130:0x027c, B:134:0x0293, B:135:0x029a, B:139:0x02b1, B:145:0x02f0, B:147:0x02fa, B:144:0x02d8, B:104:0x0228, B:106:0x022e, B:109:0x0238, B:111:0x023e, B:114:0x0247, B:116:0x024d, B:119:0x0258, B:121:0x025e, B:124:0x0269, B:126:0x026f, B:94:0x0196, B:80:0x015c, B:83:0x0168, B:86:0x0175, B:39:0x00e3, B:42:0x00ed, B:45:0x00f6, B:48:0x0101, B:51:0x010c, B:141:0x02be), top: B:196:0x00c7, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01a4  */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onCreate(Bundle bundle) {
        String str;
        String str2;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        String str3;
        int i8;
        int i9;
        int i10;
        Matcher matcher;
        int i11;
        int i12;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.PUSH_SCHEME_MID_ACTIVITY_ONCREATE_START_STAMP_KEY);
            GrowthFunnelHelper.updateAppStartInfoForActivity(this);
            super.onCreate(bundle);
            try {
                Intent intent = getIntent();
                if (intent != null) {
                    String uri = intent.getData().toString();
                    TbLog yunPushLog = YunPushLog.getInstance();
                    yunPushLog.i(BaiduYunPushMessageReceiver.TAG, "YunPushProxyActivity onCreate path:" + uri);
                    GrowthFunnelHelper.updateAppStartInfo(uri, false);
                    if (uri.contains("tbyunpushnotifybody=")) {
                        JSONObject jSONObject = new JSONObject(uri.substring(uri.indexOf("tbyunpushnotifybody=") + 20));
                        String str4 = "";
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
                            String string = jSONObject.getString("jump_scheme");
                            if (Uri.parse(string).isOpaque()) {
                                if (GlobalBuildConfig.isDebug()) {
                                    throw new IllegalStateException(string + "：scheme 格式非法");
                                }
                            } else {
                                str4 = string;
                            }
                        }
                        if (!StringUtils.isNull(str4)) {
                            try {
                                if (!str4.equals(UrlSchemaHelper.JUMP_TO_CHAT) && !str4.startsWith(UrlSchemaHelper.SCHEMA_FANS_PAGE)) {
                                    if (str4.contains(UrlSchemaHelper.GOTO_OFFICIAL_CHAT)) {
                                        i = 2;
                                    } else if (str4.contains(UrlSchemaHelper.GOTO_PERSONAL_CHAT)) {
                                        i = 3;
                                    } else if (str4.startsWith(UrlSchemaHelper.SCHEMA_REPLY_ME)) {
                                        i = 10;
                                    } else if (str4.startsWith(UrlSchemaHelper.SCHEMA_AGREE_ME)) {
                                        i = 11;
                                    } else if (str4.startsWith(UrlSchemaHelper.SCHEMA_AT_ME)) {
                                        i = 12;
                                    } else if (str4.startsWith("flt://SignTogetherPage")) {
                                        i = 14;
                                    }
                                    String str5 = null;
                                    if (!jSONObject.isNull(MainTabActivityConfig.PUSH_FOLLOW_UP_ACTION)) {
                                        i2 = jSONObject.optInt(MainTabActivityConfig.PUSH_FOLLOW_UP_ACTION);
                                    } else {
                                        i2 = 0;
                                    }
                                    if (!jSONObject.isNull(MainTabActivityConfig.PUSH_DES_PAGE)) {
                                        str5 = jSONObject.getString(MainTabActivityConfig.PUSH_DES_PAGE);
                                    }
                                    String str6 = str5;
                                    if (i2 == 1) {
                                        i4 = 2;
                                        i3 = 2;
                                    } else {
                                        i3 = 2;
                                        if (i2 == 2) {
                                            i4 = 1;
                                        } else {
                                            i4 = 0;
                                        }
                                    }
                                    if (i2 == i3) {
                                        i5 = 1;
                                    } else {
                                        i5 = 0;
                                    }
                                    if (str4 != null) {
                                        i6 = i;
                                        if (str4.contains("type=interaction")) {
                                            i12 = 2;
                                        } else if (str4.contains("type=recommend")) {
                                            i12 = 3;
                                        } else if (str4.contains("type=attention-bazhu")) {
                                            i12 = 4;
                                        } else if (str4.contains("type=attention-common")) {
                                            i12 = 5;
                                        } else {
                                            i12 = 1;
                                        }
                                        if (str4.contains("force_jump=frs")) {
                                            i7 = i2;
                                            i8 = 6;
                                        } else {
                                            i7 = i2;
                                            if (str4.contains("force_jump=maintab")) {
                                                i8 = 1;
                                            } else {
                                                i8 = 0;
                                            }
                                        }
                                        int i13 = i12;
                                        str3 = str6;
                                        i9 = i13;
                                    } else {
                                        i6 = i;
                                        i7 = i2;
                                        str3 = str6;
                                        i8 = 0;
                                        i9 = 1;
                                    }
                                    StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.PUSH_CCLICK).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", 2).param("task_id", str).param("service_id", str2).param("shoubai_cuid", TbadkCoreApplication.getInst().getCuidGalaxy2()).param(TiebaStatic.Params.OBJ_TO, str4).param("obj_locate", i4).param("obj_param1", i5).param(TiebaStatic.Params.OBJ_PARAM2, i8).param(TiebaStatic.Params.OBJ_PARAM3, i9).param("hdid", TbadkCoreApplication.getInst().getHdid()).param("obj_id", TbadkCoreApplication.getInst().getStartType()).param(TiebaStatic.Params.OBJ_ISHOST, 1);
                                    if (TextUtils.isEmpty(str4) && str4.contains("HotThreadList")) {
                                        i10 = 6;
                                    } else {
                                        if ((!TextUtils.isEmpty(str4) || !str4.contains("HotInteraction")) && (TextUtils.isEmpty(str4) || !str4.contains("frs?kw="))) {
                                            if (TextUtils.isEmpty(str4) && str4.contains("collect")) {
                                                i10 = 8;
                                            } else if (TextUtils.isEmpty(str4) && str4.contains("push_type=question_answer_invite")) {
                                                i10 = 15;
                                            } else if (TextUtils.isEmpty(str4) && str4.contains("push_type=answer_top")) {
                                                i10 = 16;
                                            } else {
                                                i10 = i6;
                                            }
                                        }
                                        i10 = 7;
                                    }
                                    param.param("obj_source", i10);
                                    matcher = Pattern.compile(UrlSchemaHelper.PB_URL).matcher(str4);
                                    if (matcher.find()) {
                                        param.addParam("tid", matcher.group(1));
                                    }
                                    TiebaStatic.log(param);
                                    StatisticItem statisticItem = new StatisticItem("PushOptCount");
                                    if (q25.a().d()) {
                                        i11 = 1;
                                    } else {
                                        i11 = 2;
                                    }
                                    TiebaStatic.log(statisticItem.param("obj_param1", i11));
                                    if (!TextUtils.isEmpty(str4)) {
                                        try {
                                            str4 = Uri.parse(str4).buildUpon().appendQueryParameter("from_yunpush", "1").build().toString();
                                        } catch (Exception e) {
                                            TbLog yunPushLog2 = YunPushLog.getInstance();
                                            yunPushLog2.e(BaiduYunPushMessageReceiver.TAG, "YunPushProxyActivity parse Exception:" + e);
                                        }
                                        if (q25.a().d()) {
                                            q25.a().i(2);
                                        }
                                        if (M0(str4)) {
                                            int i14 = -1;
                                            if (str4.startsWith(UrlSchemaHelper.SCHEMA_REPLY_ME)) {
                                                StatisticItem param2 = new StatisticItem(TbadkCoreStatisticKey.KEY_MSG_REPLY_CLICK).param("uid", TbadkCoreApplication.getCurrentAccountId());
                                                try {
                                                    Uri parse = Uri.parse(str4);
                                                    String queryParameter = parse.getQueryParameter("fid");
                                                    String queryParameter2 = parse.getQueryParameter("tid");
                                                    String queryParameter3 = parse.getQueryParameter("pid");
                                                    param2.param("fid", queryParameter);
                                                    param2.param("pid", queryParameter3);
                                                    param2.param("tid", queryParameter2);
                                                } catch (Exception e2) {
                                                    TbLog yunPushLog3 = YunPushLog.getInstance();
                                                    yunPushLog3.e(BaiduYunPushMessageReceiver.TAG, "YunPushProxyActivity ToMainTab Exception:" + e2);
                                                }
                                                TiebaStatic.log(param2);
                                                i14 = 3;
                                            }
                                            MainTabActivityConfig mainTabActivityConfig = new MainTabActivityConfig(this);
                                            mainTabActivityConfig.setTargetScheme(str4);
                                            mainTabActivityConfig.setPushFollowUpAction(i7);
                                            mainTabActivityConfig.setPushDesPage(str3);
                                            mainTabActivityConfig.setBottomTab(i14);
                                            MessageManager.getInstance().sendMessage(new CustomMessage(2015002, mainTabActivityConfig));
                                        } else {
                                            GrowthStatsUtil.statisticChannel("push", str4);
                                            Class.forName("com.baidu.tieba.immessagecenter.im.chat.PersonalChatActivityStatic");
                                            UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{str4, UrlManager.YUN_PUSH_TAG});
                                        }
                                        if (str4.contains("ForumGradePage")) {
                                            StatisticItem param3 = new StatisticItem("c13782").param("uid", TbadkCoreApplication.getCurrentAccountId());
                                            try {
                                                Uri parse2 = Uri.parse(str4);
                                                String queryParameter4 = parse2.getQueryParameter("forum_id");
                                                String queryParameter5 = parse2.getQueryParameter("obj_type");
                                                param3.param("fid", queryParameter4);
                                                param3.param("obj_type", queryParameter5);
                                            } catch (Exception e3) {
                                                TbLog yunPushLog4 = YunPushLog.getInstance();
                                                yunPushLog4.e(BaiduYunPushMessageReceiver.TAG, "YunPushProxyActivity ForumGradePage Exception:" + e3);
                                            }
                                            TiebaStatic.log(param3);
                                        }
                                        if (str4.contains("unidispatch/hotuserrank")) {
                                            TiebaStatic.log(new StatisticItem("c13662").param("uid", TbadkCoreApplication.getCurrentAccountId()));
                                        }
                                        if (str4.contains("weeklygodview")) {
                                            TiebaStatic.log(new StatisticItem("c13691").param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_source", 2));
                                        }
                                        if (str4.contains(PbModel.UNIDISPATCH_PB)) {
                                            Uri parse3 = Uri.parse(str4);
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
                                String str52 = null;
                                if (!jSONObject.isNull(MainTabActivityConfig.PUSH_FOLLOW_UP_ACTION)) {
                                }
                                if (!jSONObject.isNull(MainTabActivityConfig.PUSH_DES_PAGE)) {
                                }
                                String str62 = str52;
                                if (i2 == 1) {
                                }
                                if (i2 == i3) {
                                }
                                if (str4 != null) {
                                }
                                StatisticItem param4 = new StatisticItem(TbadkCoreStatisticKey.PUSH_CCLICK).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", 2).param("task_id", str).param("service_id", str2).param("shoubai_cuid", TbadkCoreApplication.getInst().getCuidGalaxy2()).param(TiebaStatic.Params.OBJ_TO, str4).param("obj_locate", i4).param("obj_param1", i5).param(TiebaStatic.Params.OBJ_PARAM2, i8).param(TiebaStatic.Params.OBJ_PARAM3, i9).param("hdid", TbadkCoreApplication.getInst().getHdid()).param("obj_id", TbadkCoreApplication.getInst().getStartType()).param(TiebaStatic.Params.OBJ_ISHOST, 1);
                                if (TextUtils.isEmpty(str4)) {
                                }
                                if (!TextUtils.isEmpty(str4)) {
                                }
                                if (TextUtils.isEmpty(str4)) {
                                }
                                if (TextUtils.isEmpty(str4)) {
                                }
                                if (TextUtils.isEmpty(str4)) {
                                }
                                i10 = i6;
                                param4.param("obj_source", i10);
                                matcher = Pattern.compile(UrlSchemaHelper.PB_URL).matcher(str4);
                                if (matcher.find()) {
                                }
                                TiebaStatic.log(param4);
                                StatisticItem statisticItem3 = new StatisticItem("PushOptCount");
                                if (q25.a().d()) {
                                }
                                TiebaStatic.log(statisticItem3.param("obj_param1", i11));
                                if (!TextUtils.isEmpty(str4)) {
                                }
                            } catch (Exception e4) {
                                e = e4;
                                TbLog yunPushLog5 = YunPushLog.getInstance();
                                yunPushLog5.e(BaiduYunPushMessageReceiver.TAG, "YunPushProxyActivity onCreate Exception:" + e);
                                BaseVM.m(3);
                                TbSingleton.getInstance().setPushOrSchemeLog(true);
                                finish();
                                SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.PUSH_SCHEME_MID_ACTIVITY_ONCREATE_END_STAMP_KEY);
                            }
                        }
                        i = 0;
                        String str522 = null;
                        if (!jSONObject.isNull(MainTabActivityConfig.PUSH_FOLLOW_UP_ACTION)) {
                        }
                        if (!jSONObject.isNull(MainTabActivityConfig.PUSH_DES_PAGE)) {
                        }
                        String str622 = str522;
                        if (i2 == 1) {
                        }
                        if (i2 == i3) {
                        }
                        if (str4 != null) {
                        }
                        StatisticItem param42 = new StatisticItem(TbadkCoreStatisticKey.PUSH_CCLICK).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", 2).param("task_id", str).param("service_id", str2).param("shoubai_cuid", TbadkCoreApplication.getInst().getCuidGalaxy2()).param(TiebaStatic.Params.OBJ_TO, str4).param("obj_locate", i4).param("obj_param1", i5).param(TiebaStatic.Params.OBJ_PARAM2, i8).param(TiebaStatic.Params.OBJ_PARAM3, i9).param("hdid", TbadkCoreApplication.getInst().getHdid()).param("obj_id", TbadkCoreApplication.getInst().getStartType()).param(TiebaStatic.Params.OBJ_ISHOST, 1);
                        if (TextUtils.isEmpty(str4)) {
                        }
                        if (!TextUtils.isEmpty(str4)) {
                        }
                        if (TextUtils.isEmpty(str4)) {
                        }
                        if (TextUtils.isEmpty(str4)) {
                        }
                        if (TextUtils.isEmpty(str4)) {
                        }
                        i10 = i6;
                        param42.param("obj_source", i10);
                        matcher = Pattern.compile(UrlSchemaHelper.PB_URL).matcher(str4);
                        if (matcher.find()) {
                        }
                        TiebaStatic.log(param42);
                        StatisticItem statisticItem32 = new StatisticItem("PushOptCount");
                        if (q25.a().d()) {
                        }
                        TiebaStatic.log(statisticItem32.param("obj_param1", i11));
                        if (!TextUtils.isEmpty(str4)) {
                        }
                    }
                }
            } catch (Exception e5) {
                e = e5;
                TbLog yunPushLog52 = YunPushLog.getInstance();
                yunPushLog52.e(BaiduYunPushMessageReceiver.TAG, "YunPushProxyActivity onCreate Exception:" + e);
                BaseVM.m(3);
                TbSingleton.getInstance().setPushOrSchemeLog(true);
                finish();
                SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.PUSH_SCHEME_MID_ACTIVITY_ONCREATE_END_STAMP_KEY);
            }
            BaseVM.m(3);
            TbSingleton.getInstance().setPushOrSchemeLog(true);
            finish();
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.PUSH_SCHEME_MID_ACTIVITY_ONCREATE_END_STAMP_KEY);
        }
    }
}
