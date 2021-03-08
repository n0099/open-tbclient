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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.util.AdExtParam;
import com.baidu.tieba.R;
import java.util.regex.Pattern;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class YunPushProxyActivity extends BaseActivity<YunPushProxyActivity> {
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:109:0x02ca  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x02d0  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x02d3  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x015e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0095 A[Catch: Exception -> 0x02be, TryCatch #1 {Exception -> 0x02be, blocks: (B:3:0x0008, B:5:0x000e, B:7:0x001f, B:9:0x0043, B:10:0x004b, B:12:0x0057, B:13:0x005f, B:15:0x006b, B:16:0x0072, B:18:0x0078, B:20:0x0081, B:67:0x0223, B:23:0x008b, B:25:0x0095, B:26:0x009d, B:28:0x00a6, B:35:0x00b8, B:39:0x00c7, B:76:0x0243, B:79:0x024f, B:82:0x025b, B:42:0x00d1, B:44:0x0145, B:47:0x014f, B:51:0x0179, B:53:0x017f, B:54:0x019c, B:56:0x01a5, B:58:0x01d6, B:106:0x02c2, B:59:0x01d9, B:61:0x01e2, B:62:0x01f8, B:64:0x0201, B:102:0x02a5, B:101:0x029f, B:85:0x0267, B:87:0x026d, B:90:0x0279, B:92:0x027f, B:95:0x028b, B:97:0x0291, B:70:0x022f, B:49:0x015e, B:57:0x01b8), top: B:118:0x0008, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00a6 A[Catch: Exception -> 0x02be, TryCatch #1 {Exception -> 0x02be, blocks: (B:3:0x0008, B:5:0x000e, B:7:0x001f, B:9:0x0043, B:10:0x004b, B:12:0x0057, B:13:0x005f, B:15:0x006b, B:16:0x0072, B:18:0x0078, B:20:0x0081, B:67:0x0223, B:23:0x008b, B:25:0x0095, B:26:0x009d, B:28:0x00a6, B:35:0x00b8, B:39:0x00c7, B:76:0x0243, B:79:0x024f, B:82:0x025b, B:42:0x00d1, B:44:0x0145, B:47:0x014f, B:51:0x0179, B:53:0x017f, B:54:0x019c, B:56:0x01a5, B:58:0x01d6, B:106:0x02c2, B:59:0x01d9, B:61:0x01e2, B:62:0x01f8, B:64:0x0201, B:102:0x02a5, B:101:0x029f, B:85:0x0267, B:87:0x026d, B:90:0x0279, B:92:0x027f, B:95:0x028b, B:97:0x0291, B:70:0x022f, B:49:0x015e, B:57:0x01b8), top: B:118:0x0008, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00c7 A[Catch: Exception -> 0x02be, TryCatch #1 {Exception -> 0x02be, blocks: (B:3:0x0008, B:5:0x000e, B:7:0x001f, B:9:0x0043, B:10:0x004b, B:12:0x0057, B:13:0x005f, B:15:0x006b, B:16:0x0072, B:18:0x0078, B:20:0x0081, B:67:0x0223, B:23:0x008b, B:25:0x0095, B:26:0x009d, B:28:0x00a6, B:35:0x00b8, B:39:0x00c7, B:76:0x0243, B:79:0x024f, B:82:0x025b, B:42:0x00d1, B:44:0x0145, B:47:0x014f, B:51:0x0179, B:53:0x017f, B:54:0x019c, B:56:0x01a5, B:58:0x01d6, B:106:0x02c2, B:59:0x01d9, B:61:0x01e2, B:62:0x01f8, B:64:0x0201, B:102:0x02a5, B:101:0x029f, B:85:0x0267, B:87:0x026d, B:90:0x0279, B:92:0x027f, B:95:0x028b, B:97:0x0291, B:70:0x022f, B:49:0x015e, B:57:0x01b8), top: B:118:0x0008, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x023b  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0240  */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onCreate(Bundle bundle) {
        String str;
        String str2;
        int i;
        int optInt;
        String str3;
        int i2;
        int i3;
        String str4;
        int i4 = 0;
        int i5 = 1;
        super.onCreate(bundle);
        try {
            Intent intent = getIntent();
            if (intent != null) {
                String uri = intent.getData().toString();
                if (uri.contains("tbyunpushnotifybody=")) {
                    JSONObject jSONObject = new JSONObject(uri.substring(uri.indexOf("tbyunpushnotifybody=") + "tbyunpushnotifybody=".length()));
                    if (jSONObject.isNull("task_id")) {
                        str = "";
                    } else {
                        str = jSONObject.getString("task_id");
                    }
                    if (jSONObject.isNull(Constants.EXTRA_SERVICE)) {
                        str2 = "";
                    } else {
                        str2 = jSONObject.getString(Constants.EXTRA_SERVICE);
                    }
                    String str5 = "";
                    if (!jSONObject.isNull("jump_scheme")) {
                        str5 = jSONObject.getString("jump_scheme");
                    }
                    if (!StringUtils.isNull(str5)) {
                        if (str5.equals(UrlSchemaHelper.JUMP_TO_CHAT) || str5.equals(UrlSchemaHelper.HTTPS_JUMP_TO_CHAT)) {
                            i = 1;
                        } else if (str5.contains(UrlSchemaHelper.GOTO_OFFICIAL_CHAT)) {
                            i = 2;
                        } else if (str5.contains(UrlSchemaHelper.GOTO_PERSONAL_CHAT)) {
                            i = 3;
                        }
                        optInt = jSONObject.isNull(MainTabActivityConfig.PUSH_FOLLOW_UP_ACTION) ? jSONObject.optInt(MainTabActivityConfig.PUSH_FOLLOW_UP_ACTION) : 0;
                        if (!jSONObject.isNull(MainTabActivityConfig.PUSH_DES_PAGE)) {
                            str3 = null;
                        } else {
                            str3 = jSONObject.getString(MainTabActivityConfig.PUSH_DES_PAGE);
                        }
                        if (optInt != 1) {
                            i2 = 2;
                        } else {
                            i2 = optInt == 2 ? 1 : 0;
                        }
                        int i6 = optInt != 2 ? 1 : 0;
                        if (str3 != null && optInt == 1) {
                            i4 = !str3.equals(getString(R.string.des_page_home_recommend)) ? 1 : 2;
                        }
                        if (str5 != null) {
                            if (str5.contains("type=interaction")) {
                                i5 = 2;
                            } else if (str5.contains("type=recommend")) {
                                i5 = 3;
                            } else if (str5.contains("type=attention-bazhu")) {
                                i5 = 4;
                            } else if (str5.contains("type=attention-common")) {
                                i5 = 5;
                            }
                        }
                        ar aq = new ar(TbadkCoreStatisticKey.PUSH_CCLICK).aq("obj_type", 2).dR("task_id", str).dR(Constants.EXTRA_SERVICE, str2).dR(AdExtParam.KEY_SHOUBAI_CUID, TbadkCoreApplication.getInst().getCuidGalaxy2()).dR(TiebaInitialize.Params.OBJ_TO, str5).aq("obj_source", i).aq("obj_locate", i2).aq("obj_param1", i6).aq(TiebaInitialize.Params.OBJ_PARAM2, i4).aq(TiebaInitialize.Params.OBJ_PARAM3, i5).aq("obj_id", TbadkCoreApplication.getInst().getStartType()).aq("obj_ishost", 1);
                        if (TextUtils.isEmpty(str5) && str5.contains("HotThreadList")) {
                            i3 = 6;
                        } else if (TextUtils.isEmpty(str5) && str5.contains("HotInteraction")) {
                            i3 = 7;
                        } else if (TextUtils.isEmpty(str5) && str5.contains("frs?kw=")) {
                            i3 = 7;
                        } else {
                            i3 = (TextUtils.isEmpty(str5) && str5.contains("collect")) ? 8 : i;
                        }
                        aq.aq("obj_source", i3);
                        TiebaStatic.log(aq);
                        if (!TextUtils.isEmpty(str5)) {
                            try {
                                str4 = Uri.parse(str5).buildUpon().appendQueryParameter("from_yunpush", "1").build().toString();
                            } catch (Exception e) {
                                BdLog.e(e);
                                str4 = str5;
                            }
                            if (VO(str4)) {
                                MainTabActivityConfig mainTabActivityConfig = new MainTabActivityConfig(this);
                                mainTabActivityConfig.setTargetScheme(str4);
                                mainTabActivityConfig.setPushFollowUpAction(optInt);
                                mainTabActivityConfig.setPushDesPage(str3);
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, mainTabActivityConfig));
                            } else {
                                bf.bsY().b(getPageContext(), new String[]{str4, "yun_push_tag"});
                            }
                            if (str4.contains("ForumGradePage")) {
                                ar v = new ar("c13782").v("uid", TbadkCoreApplication.getCurrentAccountId());
                                try {
                                    Uri parse = Uri.parse(str4);
                                    String queryParameter = parse.getQueryParameter("forum_id");
                                    String queryParameter2 = parse.getQueryParameter("obj_type");
                                    v.dR("fid", queryParameter);
                                    v.dR("obj_type", queryParameter2);
                                } catch (Exception e2) {
                                    BdLog.e(e2);
                                }
                                TiebaStatic.log(v);
                            }
                            if (str4.contains("unidispatch/hotuserrank")) {
                                TiebaStatic.log(new ar("c13662").v("uid", TbadkCoreApplication.getCurrentAccountId()));
                            }
                            if (str4.contains("weeklygodview")) {
                                TiebaStatic.log(new ar("c13691").v("uid", TbadkCoreApplication.getCurrentAccountId()).aq("obj_source", 2));
                            }
                        }
                    }
                    i = 0;
                    if (jSONObject.isNull(MainTabActivityConfig.PUSH_FOLLOW_UP_ACTION)) {
                    }
                    if (!jSONObject.isNull(MainTabActivityConfig.PUSH_DES_PAGE)) {
                    }
                    if (optInt != 1) {
                    }
                    if (optInt != 2) {
                    }
                    if (str3 != null) {
                        if (!str3.equals(getString(R.string.des_page_home_recommend))) {
                        }
                    }
                    if (str5 != null) {
                    }
                    ar aq2 = new ar(TbadkCoreStatisticKey.PUSH_CCLICK).aq("obj_type", 2).dR("task_id", str).dR(Constants.EXTRA_SERVICE, str2).dR(AdExtParam.KEY_SHOUBAI_CUID, TbadkCoreApplication.getInst().getCuidGalaxy2()).dR(TiebaInitialize.Params.OBJ_TO, str5).aq("obj_source", i).aq("obj_locate", i2).aq("obj_param1", i6).aq(TiebaInitialize.Params.OBJ_PARAM2, i4).aq(TiebaInitialize.Params.OBJ_PARAM3, i5).aq("obj_id", TbadkCoreApplication.getInst().getStartType()).aq("obj_ishost", 1);
                    if (TextUtils.isEmpty(str5)) {
                    }
                    if (TextUtils.isEmpty(str5)) {
                    }
                    if (TextUtils.isEmpty(str5)) {
                    }
                    if (TextUtils.isEmpty(str5)) {
                    }
                    aq2.aq("obj_source", i3);
                    TiebaStatic.log(aq2);
                    if (!TextUtils.isEmpty(str5)) {
                    }
                }
            }
        } catch (Exception e3) {
        }
        finish();
    }

    private boolean VO(String str) {
        return Pattern.compile("http[s]?://tieba.baidu.com/p").matcher(str).find() || str.startsWith("http://tieba.baidu.com/mo/q/newtopic/detail") || str.startsWith("https://tieba.baidu.com/mo/q/newtopic/detail") || str.startsWith("flt://") || str.startsWith("bdtiebalive://") || str.startsWith("tiebachushou://") || str.contains("achievement=");
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
    }
}
