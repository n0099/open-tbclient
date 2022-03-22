package com.baidu.tieba.yunpush;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import c.a.o0.r.a0.a;
import c.a.o0.r.a0.c;
import c.a.p0.w2.l.b;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.BdToken.BdUniDispatchSchemeController;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.regex.Pattern;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class YunPushProxyActivity extends BaseActivity<YunPushProxyActivity> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String JUME_SCHEME = "jump_scheme";
    public static final String PUSH_BODY = "tbyunpushnotifybody=";
    public static final String SERVICE_ID = "service_id";
    public static final String TASK_ID = "task_id";
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isJumpPB;

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
                return;
            }
        }
        this.isJumpPB = false;
    }

    private boolean needToMainTab(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, str)) == null) {
            if (!Pattern.compile("http[s]?://tieba.baidu.com/p").matcher(str).find()) {
                return str.startsWith(UrlSchemaHelper.HTTP_JUMP_TOPIC_DETAIL) || str.startsWith(UrlSchemaHelper.HTTPS_JUMP_TOPIC_DETAIL) || str.startsWith(UrlSchemaHelper.SCHEMA_TB_FLUTTER) || str.startsWith(UrlSchemaHelper.SCHEMA_LIVE_SDK) || str.startsWith(UrlSchemaHelper.SCHEMA_CHUSHOU_LIVE_SDK) || str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_SWAN) || str.contains("achievement=");
            }
            this.isJumpPB = true;
            return true;
        }
        return invokeL.booleanValue;
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

    /* JADX WARN: Removed duplicated region for block: B:144:0x01c3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00a3 A[Catch: Exception -> 0x02fd, TryCatch #0 {Exception -> 0x02fd, blocks: (B:5:0x0020, B:7:0x0026, B:9:0x0038, B:12:0x004f, B:14:0x0055, B:16:0x005b, B:18:0x0061, B:20:0x0067, B:21:0x006b, B:23:0x0073, B:25:0x007b, B:28:0x0084, B:36:0x009b, B:38:0x00a3, B:40:0x00a9, B:42:0x00af, B:54:0x00c9, B:60:0x00dd, B:74:0x010e, B:76:0x017e, B:94:0x01b7, B:100:0x01e0, B:102:0x01ea, B:103:0x01f2, B:105:0x01f8, B:107:0x0202, B:109:0x020c, B:111:0x0210, B:112:0x0220, B:114:0x0256, B:117:0x0260, B:122:0x028a, B:121:0x0287, B:123:0x028d, B:125:0x0295, B:126:0x02a7, B:128:0x02af, B:129:0x02c6, B:131:0x02ce, B:133:0x02eb, B:135:0x02f3, B:113:0x0240, B:99:0x01dd, B:79:0x0188, B:81:0x018e, B:84:0x0198, B:86:0x019e, B:89:0x01a7, B:91:0x01ad, B:63:0x00e9, B:66:0x00f5, B:70:0x0101, B:31:0x008e, B:96:0x01c3, B:118:0x026f), top: B:142:0x0020, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00af A[Catch: Exception -> 0x02fd, TryCatch #0 {Exception -> 0x02fd, blocks: (B:5:0x0020, B:7:0x0026, B:9:0x0038, B:12:0x004f, B:14:0x0055, B:16:0x005b, B:18:0x0061, B:20:0x0067, B:21:0x006b, B:23:0x0073, B:25:0x007b, B:28:0x0084, B:36:0x009b, B:38:0x00a3, B:40:0x00a9, B:42:0x00af, B:54:0x00c9, B:60:0x00dd, B:74:0x010e, B:76:0x017e, B:94:0x01b7, B:100:0x01e0, B:102:0x01ea, B:103:0x01f2, B:105:0x01f8, B:107:0x0202, B:109:0x020c, B:111:0x0210, B:112:0x0220, B:114:0x0256, B:117:0x0260, B:122:0x028a, B:121:0x0287, B:123:0x028d, B:125:0x0295, B:126:0x02a7, B:128:0x02af, B:129:0x02c6, B:131:0x02ce, B:133:0x02eb, B:135:0x02f3, B:113:0x0240, B:99:0x01dd, B:79:0x0188, B:81:0x018e, B:84:0x0198, B:86:0x019e, B:89:0x01a7, B:91:0x01ad, B:63:0x00e9, B:66:0x00f5, B:70:0x0101, B:31:0x008e, B:96:0x01c3, B:118:0x026f), top: B:142:0x0020, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00c7 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00dd A[Catch: Exception -> 0x02fd, TryCatch #0 {Exception -> 0x02fd, blocks: (B:5:0x0020, B:7:0x0026, B:9:0x0038, B:12:0x004f, B:14:0x0055, B:16:0x005b, B:18:0x0061, B:20:0x0067, B:21:0x006b, B:23:0x0073, B:25:0x007b, B:28:0x0084, B:36:0x009b, B:38:0x00a3, B:40:0x00a9, B:42:0x00af, B:54:0x00c9, B:60:0x00dd, B:74:0x010e, B:76:0x017e, B:94:0x01b7, B:100:0x01e0, B:102:0x01ea, B:103:0x01f2, B:105:0x01f8, B:107:0x0202, B:109:0x020c, B:111:0x0210, B:112:0x0220, B:114:0x0256, B:117:0x0260, B:122:0x028a, B:121:0x0287, B:123:0x028d, B:125:0x0295, B:126:0x02a7, B:128:0x02af, B:129:0x02c6, B:131:0x02ce, B:133:0x02eb, B:135:0x02f3, B:113:0x0240, B:99:0x01dd, B:79:0x0188, B:81:0x018e, B:84:0x0198, B:86:0x019e, B:89:0x01a7, B:91:0x01ad, B:63:0x00e9, B:66:0x00f5, B:70:0x0101, B:31:0x008e, B:96:0x01c3, B:118:0x026f), top: B:142:0x0020, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x017e A[Catch: Exception -> 0x02fd, TryCatch #0 {Exception -> 0x02fd, blocks: (B:5:0x0020, B:7:0x0026, B:9:0x0038, B:12:0x004f, B:14:0x0055, B:16:0x005b, B:18:0x0061, B:20:0x0067, B:21:0x006b, B:23:0x0073, B:25:0x007b, B:28:0x0084, B:36:0x009b, B:38:0x00a3, B:40:0x00a9, B:42:0x00af, B:54:0x00c9, B:60:0x00dd, B:74:0x010e, B:76:0x017e, B:94:0x01b7, B:100:0x01e0, B:102:0x01ea, B:103:0x01f2, B:105:0x01f8, B:107:0x0202, B:109:0x020c, B:111:0x0210, B:112:0x0220, B:114:0x0256, B:117:0x0260, B:122:0x028a, B:121:0x0287, B:123:0x028d, B:125:0x0295, B:126:0x02a7, B:128:0x02af, B:129:0x02c6, B:131:0x02ce, B:133:0x02eb, B:135:0x02f3, B:113:0x0240, B:99:0x01dd, B:79:0x0188, B:81:0x018e, B:84:0x0198, B:86:0x019e, B:89:0x01a7, B:91:0x01ad, B:63:0x00e9, B:66:0x00f5, B:70:0x0101, B:31:0x008e, B:96:0x01c3, B:118:0x026f), top: B:142:0x0020, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x018e A[Catch: Exception -> 0x02fd, TryCatch #0 {Exception -> 0x02fd, blocks: (B:5:0x0020, B:7:0x0026, B:9:0x0038, B:12:0x004f, B:14:0x0055, B:16:0x005b, B:18:0x0061, B:20:0x0067, B:21:0x006b, B:23:0x0073, B:25:0x007b, B:28:0x0084, B:36:0x009b, B:38:0x00a3, B:40:0x00a9, B:42:0x00af, B:54:0x00c9, B:60:0x00dd, B:74:0x010e, B:76:0x017e, B:94:0x01b7, B:100:0x01e0, B:102:0x01ea, B:103:0x01f2, B:105:0x01f8, B:107:0x0202, B:109:0x020c, B:111:0x0210, B:112:0x0220, B:114:0x0256, B:117:0x0260, B:122:0x028a, B:121:0x0287, B:123:0x028d, B:125:0x0295, B:126:0x02a7, B:128:0x02af, B:129:0x02c6, B:131:0x02ce, B:133:0x02eb, B:135:0x02f3, B:113:0x0240, B:99:0x01dd, B:79:0x0188, B:81:0x018e, B:84:0x0198, B:86:0x019e, B:89:0x01a7, B:91:0x01ad, B:63:0x00e9, B:66:0x00f5, B:70:0x0101, B:31:0x008e, B:96:0x01c3, B:118:0x026f), top: B:142:0x0020, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01ad A[Catch: Exception -> 0x02fd, TryCatch #0 {Exception -> 0x02fd, blocks: (B:5:0x0020, B:7:0x0026, B:9:0x0038, B:12:0x004f, B:14:0x0055, B:16:0x005b, B:18:0x0061, B:20:0x0067, B:21:0x006b, B:23:0x0073, B:25:0x007b, B:28:0x0084, B:36:0x009b, B:38:0x00a3, B:40:0x00a9, B:42:0x00af, B:54:0x00c9, B:60:0x00dd, B:74:0x010e, B:76:0x017e, B:94:0x01b7, B:100:0x01e0, B:102:0x01ea, B:103:0x01f2, B:105:0x01f8, B:107:0x0202, B:109:0x020c, B:111:0x0210, B:112:0x0220, B:114:0x0256, B:117:0x0260, B:122:0x028a, B:121:0x0287, B:123:0x028d, B:125:0x0295, B:126:0x02a7, B:128:0x02af, B:129:0x02c6, B:131:0x02ce, B:133:0x02eb, B:135:0x02f3, B:113:0x0240, B:99:0x01dd, B:79:0x0188, B:81:0x018e, B:84:0x0198, B:86:0x019e, B:89:0x01a7, B:91:0x01ad, B:63:0x00e9, B:66:0x00f5, B:70:0x0101, B:31:0x008e, B:96:0x01c3, B:118:0x026f), top: B:142:0x0020, inners: #1, #2 }] */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onCreate(Bundle bundle) {
        int i;
        String string;
        int i2;
        String str;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            a.v(this);
            super.onCreate(bundle);
            try {
                Intent intent = getIntent();
                if (intent != null) {
                    String uri = intent.getData().toString();
                    a.u(uri, false);
                    if (uri.contains(PUSH_BODY)) {
                        JSONObject jSONObject = new JSONObject(uri.substring(uri.indexOf(PUSH_BODY) + 20));
                        String string2 = !jSONObject.isNull("task_id") ? jSONObject.getString("task_id") : "";
                        String string3 = !jSONObject.isNull("service_id") ? jSONObject.getString("service_id") : "";
                        String string4 = jSONObject.isNull(JUME_SCHEME) ? "" : jSONObject.getString(JUME_SCHEME);
                        if (!StringUtils.isNull(string4)) {
                            if (!string4.equals(UrlSchemaHelper.JUMP_TO_CHAT) && !string4.equals(UrlSchemaHelper.HTTPS_JUMP_TO_CHAT)) {
                                if (string4.contains(UrlSchemaHelper.GOTO_OFFICIAL_CHAT)) {
                                    i = 2;
                                } else if (string4.contains(UrlSchemaHelper.GOTO_PERSONAL_CHAT)) {
                                    i = 3;
                                }
                                int optInt = !jSONObject.isNull(MainTabActivityConfig.PUSH_FOLLOW_UP_ACTION) ? jSONObject.optInt(MainTabActivityConfig.PUSH_FOLLOW_UP_ACTION) : 0;
                                string = jSONObject.isNull(MainTabActivityConfig.PUSH_DES_PAGE) ? null : jSONObject.getString(MainTabActivityConfig.PUSH_DES_PAGE);
                                int i4 = optInt == 1 ? 2 : optInt == 2 ? 1 : 0;
                                int i5 = optInt == 2 ? 1 : 0;
                                if (string == null && optInt == 1) {
                                    i2 = string.equals(getString(R.string.obfuscated_res_0x7f0f04b6)) ? 1 : 2;
                                } else {
                                    i2 = 0;
                                }
                                if (string4 != null) {
                                    if (string4.contains("type=interaction")) {
                                        str = "tid";
                                        i3 = 2;
                                    } else if (string4.contains("type=recommend")) {
                                        str = "tid";
                                        i3 = 3;
                                    } else {
                                        if (string4.contains("type=attention-bazhu")) {
                                            i3 = 4;
                                        } else {
                                            i3 = string4.contains("type=attention-common") ? 5 : 5;
                                        }
                                        str = "tid";
                                    }
                                    StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.PUSH_CCLICK).param("obj_type", 2).param("task_id", string2).param("service_id", string3).param("shoubai_cuid", TbadkCoreApplication.getInst().getCuidGalaxy2()).param(TiebaStatic.Params.OBJ_TO, string4).param("obj_source", i).param("obj_locate", i4).param("obj_param1", i5).param(TiebaStatic.Params.OBJ_PARAM2, i2).param(TiebaStatic.Params.OBJ_PARAM3, i3).param("hdid", TbadkCoreApplication.getInst().getHdid()).param("obj_id", TbadkCoreApplication.getInst().getStartType()).param(TiebaStatic.Params.OBJ_ISHOST, 1);
                                    if (TextUtils.isEmpty(string4) && string4.contains("HotThreadList")) {
                                        i = 6;
                                    } else {
                                        if ((!TextUtils.isEmpty(string4) || !string4.contains("HotInteraction")) && (TextUtils.isEmpty(string4) || !string4.contains("frs?kw="))) {
                                            if (!TextUtils.isEmpty(string4) && string4.contains("collect")) {
                                                i = 8;
                                            }
                                        }
                                        i = 7;
                                    }
                                    param.param("obj_source", i);
                                    TiebaStatic.log(param);
                                    if (!TextUtils.isEmpty(string4)) {
                                        try {
                                            string4 = Uri.parse(string4).buildUpon().appendQueryParameter("from_yunpush", "1").build().toString();
                                        } catch (Exception e2) {
                                            BdLog.e(e2);
                                        }
                                        if (c.a().d()) {
                                            c.a().i(2);
                                        }
                                        if (needToMainTab(string4)) {
                                            if (c.a().d() && c.a.p0.w2.l.a.a().d() && this.isJumpPB) {
                                                c.a.p0.w2.l.a.a().f(true);
                                                b.m(new String[]{string4});
                                            }
                                            MainTabActivityConfig mainTabActivityConfig = new MainTabActivityConfig(this);
                                            mainTabActivityConfig.setTargetScheme(string4);
                                            mainTabActivityConfig.setPushFollowUpAction(optInt);
                                            mainTabActivityConfig.setPushDesPage(string);
                                            MessageManager.getInstance().sendMessage(new CustomMessage(2015002, mainTabActivityConfig));
                                        } else {
                                            UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{string4, UrlManager.YUN_PUSH_TAG});
                                        }
                                        if (string4.contains("ForumGradePage")) {
                                            StatisticItem param2 = new StatisticItem("c13782").param("uid", TbadkCoreApplication.getCurrentAccountId());
                                            try {
                                                Uri parse = Uri.parse(string4);
                                                String queryParameter = parse.getQueryParameter("forum_id");
                                                String queryParameter2 = parse.getQueryParameter("obj_type");
                                                param2.param("fid", queryParameter);
                                                param2.param("obj_type", queryParameter2);
                                            } catch (Exception e3) {
                                                BdLog.e(e3);
                                            }
                                            TiebaStatic.log(param2);
                                        }
                                        if (string4.contains("unidispatch/hotuserrank")) {
                                            TiebaStatic.log(new StatisticItem("c13662").param("uid", TbadkCoreApplication.getCurrentAccountId()));
                                        }
                                        if (string4.contains("weeklygodview")) {
                                            TiebaStatic.log(new StatisticItem("c13691").param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_source", 2));
                                        }
                                        if (string4.contains(PbModel.UNIDISPATCH_PB)) {
                                            Uri parse2 = Uri.parse(string4);
                                            String queryParameter3 = parse2.getQueryParameter("obj_param1");
                                            String str2 = str;
                                            String queryParameter4 = parse2.getQueryParameter(str2);
                                            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_FROM_OUTSIDE);
                                            if (BdUniDispatchSchemeController.PARAM_VIDEO.equals(queryParameter3) || "2".equals(queryParameter3)) {
                                                statisticItem.param("obj_source", 1);
                                                statisticItem.param(str2, queryParameter4);
                                                TiebaStatic.log(statisticItem);
                                            }
                                        }
                                    }
                                }
                                str = "tid";
                                i3 = 1;
                                StatisticItem param3 = new StatisticItem(TbadkCoreStatisticKey.PUSH_CCLICK).param("obj_type", 2).param("task_id", string2).param("service_id", string3).param("shoubai_cuid", TbadkCoreApplication.getInst().getCuidGalaxy2()).param(TiebaStatic.Params.OBJ_TO, string4).param("obj_source", i).param("obj_locate", i4).param("obj_param1", i5).param(TiebaStatic.Params.OBJ_PARAM2, i2).param(TiebaStatic.Params.OBJ_PARAM3, i3).param("hdid", TbadkCoreApplication.getInst().getHdid()).param("obj_id", TbadkCoreApplication.getInst().getStartType()).param(TiebaStatic.Params.OBJ_ISHOST, 1);
                                if (TextUtils.isEmpty(string4)) {
                                }
                                if (!TextUtils.isEmpty(string4)) {
                                }
                                if (!TextUtils.isEmpty(string4)) {
                                    i = 8;
                                }
                                param3.param("obj_source", i);
                                TiebaStatic.log(param3);
                                if (!TextUtils.isEmpty(string4)) {
                                }
                            }
                            i = 1;
                            if (!jSONObject.isNull(MainTabActivityConfig.PUSH_FOLLOW_UP_ACTION)) {
                            }
                            string = jSONObject.isNull(MainTabActivityConfig.PUSH_DES_PAGE) ? null : jSONObject.getString(MainTabActivityConfig.PUSH_DES_PAGE);
                            if (optInt == 1) {
                            }
                            if (optInt == 2) {
                            }
                            if (string == null) {
                            }
                            i2 = 0;
                            if (string4 != null) {
                            }
                            str = "tid";
                            i3 = 1;
                            StatisticItem param32 = new StatisticItem(TbadkCoreStatisticKey.PUSH_CCLICK).param("obj_type", 2).param("task_id", string2).param("service_id", string3).param("shoubai_cuid", TbadkCoreApplication.getInst().getCuidGalaxy2()).param(TiebaStatic.Params.OBJ_TO, string4).param("obj_source", i).param("obj_locate", i4).param("obj_param1", i5).param(TiebaStatic.Params.OBJ_PARAM2, i2).param(TiebaStatic.Params.OBJ_PARAM3, i3).param("hdid", TbadkCoreApplication.getInst().getHdid()).param("obj_id", TbadkCoreApplication.getInst().getStartType()).param(TiebaStatic.Params.OBJ_ISHOST, 1);
                            if (TextUtils.isEmpty(string4)) {
                            }
                            if (!TextUtils.isEmpty(string4)) {
                            }
                            if (!TextUtils.isEmpty(string4)) {
                            }
                            param32.param("obj_source", i);
                            TiebaStatic.log(param32);
                            if (!TextUtils.isEmpty(string4)) {
                            }
                        }
                        i = 0;
                        if (!jSONObject.isNull(MainTabActivityConfig.PUSH_FOLLOW_UP_ACTION)) {
                        }
                        string = jSONObject.isNull(MainTabActivityConfig.PUSH_DES_PAGE) ? null : jSONObject.getString(MainTabActivityConfig.PUSH_DES_PAGE);
                        if (optInt == 1) {
                        }
                        if (optInt == 2) {
                        }
                        if (string == null) {
                        }
                        i2 = 0;
                        if (string4 != null) {
                        }
                        str = "tid";
                        i3 = 1;
                        StatisticItem param322 = new StatisticItem(TbadkCoreStatisticKey.PUSH_CCLICK).param("obj_type", 2).param("task_id", string2).param("service_id", string3).param("shoubai_cuid", TbadkCoreApplication.getInst().getCuidGalaxy2()).param(TiebaStatic.Params.OBJ_TO, string4).param("obj_source", i).param("obj_locate", i4).param("obj_param1", i5).param(TiebaStatic.Params.OBJ_PARAM2, i2).param(TiebaStatic.Params.OBJ_PARAM3, i3).param("hdid", TbadkCoreApplication.getInst().getHdid()).param("obj_id", TbadkCoreApplication.getInst().getStartType()).param(TiebaStatic.Params.OBJ_ISHOST, 1);
                        if (TextUtils.isEmpty(string4)) {
                        }
                        if (!TextUtils.isEmpty(string4)) {
                        }
                        if (!TextUtils.isEmpty(string4)) {
                        }
                        param322.param("obj_source", i);
                        TiebaStatic.log(param322);
                        if (!TextUtils.isEmpty(string4)) {
                        }
                    }
                }
            } catch (Exception unused) {
            }
            finish();
        }
    }
}
