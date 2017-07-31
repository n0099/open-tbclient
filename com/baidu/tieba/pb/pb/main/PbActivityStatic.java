package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.FloatingLayout;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BigImgPbActivityConfig;
import com.baidu.tbadk.core.atomData.BookCoverActivityConfig;
import com.baidu.tbadk.core.atomData.EmotionEditActivityConfig;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tbadk.core.atomData.MangaCoverActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PbSearchEmotionActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.account.forbid.ForbidActivity;
import com.baidu.tieba.pb.pb.main.emotion.EmotionEditActivity;
import com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
import com.baidu.tieba.pb.pb.sub.SubPbHttpResponseMessage;
import com.baidu.tieba.pb.pb.sub.SubPbSocketResponseMessage;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import tbclient.PbPage.PbPageResIdl;
/* loaded from: classes.dex */
public class PbActivityStatic {
    private static BdAsyncTaskParallel eJb = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());

    static {
        aeK();
        MQ();
        aRb();
        aRd();
        aRf();
        aRe();
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.START_PB_ACTIVITY, new CustomMessageTask.CustomRunnable<PbActivityConfig>() { // from class: com.baidu.tieba.pb.pb.main.PbActivityStatic.5
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<PbActivityConfig> customMessage) {
                if (customMessage != null && customMessage.getData() != null) {
                    if ("1".equals(customMessage.getData().getIntent().getStringExtra(PbActivityConfig.KYE_IS_START_FOR_RESULT))) {
                        customMessage.getData().startActivityForResult(customMessage.getData().getIntent().getIntExtra(IntentConfig.REQUEST_CODE, 0), PbActivity.class);
                    } else {
                        customMessage.getData().startActivity(PbActivity.class);
                    }
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        apV();
        aRc();
        BdAsyncTask<Void, Void, Void> bdAsyncTask = new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.pb.pb.main.PbActivityStatic.6
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                com.baidu.tbadk.util.z.a(PbPageRequestMessage.WIRE, PbPageResIdl.class);
                return null;
            }
        };
        bdAsyncTask.setSelfExecute(true);
        bdAsyncTask.setPriority(4);
        bdAsyncTask.execute(new Void[0]);
    }

    private static void MQ() {
        com.baidu.tieba.tbadkCore.a.a.a(302001, pbPageSocketResponseMessage.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PB_PAGE_HTTP_CMD, com.baidu.tieba.tbadkCore.a.a.az("c/f/pb/page", 302001));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(pbPageHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        LocationModel.btj();
    }

    private static void aRb() {
        com.baidu.tieba.tbadkCore.a.a.b(CmdConfigCustom.PB_PAGE_CACHE_CMD, as.class);
    }

    private static void aRc() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_APPLY_COPY_THREAD, TbConfig.SERVER_ADDRESS + TbConfig.URL_APPLY_COPY_THREAD);
        tbHttpMessageTask.setResponsedClass(ApplyCopyThreadResponseMessage.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public static void aeK() {
        com.baidu.tbadk.ala.b.nC().a(2, new com.baidu.tbadk.ala.d() { // from class: com.baidu.tieba.pb.pb.main.PbActivityStatic.1
            @Override // com.baidu.tbadk.ala.d
            public View ar(Context context) {
                TextView aq = com.baidu.tbadk.ala.c.aq(context);
                if (aq != null) {
                    FloatingLayout.a aVar = new FloatingLayout.a(-2, -2);
                    aVar.gravity = 16;
                    com.baidu.tbadk.core.util.ai.i(aq, d.e.cp_link_tip_a);
                    aVar.setMargins(com.baidu.adp.lib.util.k.g(context, d.f.ds8), com.baidu.adp.lib.util.k.g(context, d.f.ds4), 0, 0);
                    aq.setLayoutParams(aVar);
                }
                return aq;
            }
        });
        com.baidu.tbadk.ala.b.nC().a(3, new com.baidu.tbadk.ala.d() { // from class: com.baidu.tieba.pb.pb.main.PbActivityStatic.2
            @Override // com.baidu.tbadk.ala.d
            public View ar(Context context) {
                TextView aq = com.baidu.tbadk.ala.c.aq(context);
                if (aq != null) {
                    com.baidu.tbadk.core.util.ai.i(aq, d.e.cp_link_tip_a);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.setMargins(com.baidu.adp.lib.util.k.g(context, d.f.ds8), com.baidu.adp.lib.util.k.g(context, d.f.ds2), 0, 0);
                    layoutParams.gravity = 16;
                    aq.setLayoutParams(layoutParams);
                }
                return aq;
            }
        });
        com.baidu.tbadk.ala.b.nC().a(4, new com.baidu.tbadk.ala.d() { // from class: com.baidu.tieba.pb.pb.main.PbActivityStatic.3
            @Override // com.baidu.tbadk.ala.d
            public View ar(Context context) {
                TextView aq = com.baidu.tbadk.ala.c.aq(context);
                if (aq != null) {
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    com.baidu.tbadk.core.util.ai.i(aq, d.e.cp_link_tip_a);
                    layoutParams.setMargins(com.baidu.adp.lib.util.k.g(context, d.f.ds8), com.baidu.adp.lib.util.k.g(context, d.f.ds2), 0, 0);
                    layoutParams.gravity = 16;
                    aq.setLayoutParams(layoutParams);
                }
                return aq;
            }
        });
        com.baidu.tbadk.ala.b.nC().a(6, new com.baidu.tbadk.ala.d() { // from class: com.baidu.tieba.pb.pb.main.PbActivityStatic.4
            @Override // com.baidu.tbadk.ala.d
            public View ar(Context context) {
                TextView aq = com.baidu.tbadk.ala.c.aq(context);
                if (aq != null) {
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    com.baidu.tbadk.core.util.ai.i(aq, d.e.cp_link_tip_a);
                    layoutParams.setMargins(com.baidu.adp.lib.util.k.g(context, d.f.ds8), com.baidu.adp.lib.util.k.g(context, d.f.ds2), 0, 0);
                    layoutParams.gravity = 16;
                    aq.setLayoutParams(layoutParams);
                }
                return aq;
            }
        });
    }

    private static void aRd() {
        TbadkCoreApplication.getInst().RegisterIntent(SubPbActivityConfig.class, NewSubPbActivity.class);
        com.baidu.tbadk.task.b a = com.baidu.tieba.tbadkCore.a.a.a(302002, SubPbSocketResponseMessage.class, false, false);
        TbHttpMessageTask a2 = com.baidu.tieba.tbadkCore.a.a.a(302002, CmdConfigHttp.SubPb_HTTP_CMD, "c/f/pb/floor", SubPbHttpResponseMessage.class, false, false, false, false);
        a.setParallel(eJb);
        a2.setParallel(eJb);
    }

    private static void aRe() {
        TbadkCoreApplication.getInst().RegisterIntent(PbSearchEmotionActivityConfig.class, PbSearchEmotionActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(EmotionEditActivityConfig.class, EmotionEditActivity.class);
    }

    private static void aRf() {
        TbadkCoreApplication.getInst().RegisterIntent(ForbidActivityConfig.class, ForbidActivity.class);
    }

    private static void apV() {
        com.baidu.tbadk.core.util.at.wf().a(new at.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivityStatic.7
            Pattern eJc = Pattern.compile("http[s]?://tieba.baidu.com/p/([\\d]+)");

            @Override // com.baidu.tbadk.core.util.at.a
            public int a(TbPageContext<?> tbPageContext, String[] strArr) {
                String aq;
                boolean z;
                String str;
                boolean z2;
                boolean z3;
                boolean z4;
                String str2;
                if (strArr == null || strArr.length == 0 || strArr[0] == null) {
                    return 3;
                }
                boolean z5 = strArr.length > 1 && !StringUtils.isNull(strArr[1]) && strArr[1].toLowerCase().contains("n/video/opersquare");
                String lowerCase = strArr[0].toLowerCase();
                Matcher matcher = this.eJc.matcher(lowerCase);
                String str3 = "";
                boolean z6 = false;
                if (Pattern.compile("http[s]?://tieba\\.baidu\\.com/p/([\\d]+)\\?pid=([\\d]+)&tid=([\\d]+)&threadtype=([\\d]+)&jump_type=(.*)&jump_tieba_native=1").matcher(lowerCase).find()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SEARCH_JUMP_PB, lowerCase));
                    return 0;
                } else if (lowerCase.contains("bookcover:")) {
                    Map<String, String> ee = com.baidu.tbadk.core.util.at.ee(lowerCase.substring("bookcover:".length()));
                    if (ee == null || ee.size() <= 0) {
                        return 0;
                    }
                    if (com.baidu.adp.lib.g.b.g(ee.get("book_type"), 1) == 3) {
                        if (!TbadkCoreApplication.getInst().appResponseToIntentClass(MangaCoverActivityConfig.class)) {
                            com.baidu.adp.lib.util.k.showToast(tbPageContext.getPageActivity(), d.l.manga_plugin_not_install_tip);
                            return 0;
                        }
                        return 3;
                    } else if (!TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                        com.baidu.adp.lib.util.k.showToast(tbPageContext.getPageActivity(), d.l.book_plugin_not_install_tip);
                        return 0;
                    } else {
                        return 3;
                    }
                } else {
                    if (matcher.find()) {
                        aq = matcher.group(1);
                        if (lowerCase == null) {
                            z4 = false;
                            str2 = "";
                        } else {
                            String[] split = lowerCase.split("&");
                            int i = 0;
                            while (true) {
                                if (i >= split.length) {
                                    str2 = "";
                                    break;
                                } else if (split[i] != null && split[i].startsWith("thread_type=")) {
                                    str2 = split[i].substring("thread_type=".length());
                                    break;
                                } else {
                                    i++;
                                }
                            }
                            z4 = com.baidu.adp.lib.g.b.d(com.baidu.tbadk.util.y.aq(lowerCase, "is_from_push="), false);
                        }
                        z6 = true;
                        z = false;
                        z2 = z4;
                        str3 = str2;
                        str = "allthread";
                    } else if (lowerCase != null && (lowerCase.startsWith("http://tieba.baidu.com/f?") || lowerCase.startsWith("http://tieba.baidu.com/f?"))) {
                        String str4 = null;
                        if (lowerCase.startsWith("http://tieba.baidu.com/f?")) {
                            str4 = lowerCase.substring("http://tieba.baidu.com/f?".length());
                        } else if (lowerCase.startsWith("http://tieba.baidu.com/f?")) {
                            str4 = lowerCase.substring("http://tieba.baidu.com/f?".length());
                        }
                        if (str4 == null) {
                            z3 = false;
                            aq = null;
                        } else {
                            String[] split2 = str4.split("&");
                            int i2 = 0;
                            while (true) {
                                if (i2 >= split2.length) {
                                    aq = null;
                                    z3 = false;
                                    break;
                                } else if (split2[i2] == null || !split2[i2].startsWith("kz=")) {
                                    i2++;
                                } else {
                                    aq = split2[i2].substring(3);
                                    z3 = true;
                                    break;
                                }
                            }
                            if (!TextUtils.isEmpty(aq) && aq.contains("&")) {
                                aq = aq.split("&")[0];
                            }
                            if (TextUtils.isEmpty(aq)) {
                                aq = null;
                            }
                        }
                        z = false;
                        z6 = z3;
                        z2 = false;
                        str = "allthread";
                    } else if (lowerCase.startsWith("pb:")) {
                        aq = lowerCase.substring(3);
                        z6 = true;
                        if (strArr.length > 1) {
                            z = false;
                            str = strArr[1];
                            z2 = false;
                        } else {
                            z = false;
                            str = null;
                            z2 = false;
                        }
                    } else if (lowerCase.startsWith("com.baidu.tieba://?kz=")) {
                        aq = lowerCase.substring("com.baidu.tieba://?kz=".length());
                        z = true;
                        z2 = false;
                        str = null;
                    } else if (lowerCase.contains(TbConfig.WEB_VIEW_JUMP2NATIVE) && lowerCase.contains("kz=")) {
                        aq = com.baidu.tbadk.util.y.aq(lowerCase, "kz=");
                        z = false;
                        str = null;
                        z2 = false;
                    } else {
                        return 3;
                    }
                    if (!StringUtils.isNull(aq, true) && tbPageContext != null) {
                        if (!StringUtils.isNull(str3) && com.baidu.adp.lib.g.b.g(str3, 0) == 33 && TbadkCoreApplication.getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                            tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(tbPageContext.getPageActivity(), aq).pn()));
                        } else {
                            PbActivityConfig createNormalCfg = new PbActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(aq, null, str);
                            if (lowerCase.contains(BigImgPbActivityConfig.OPEN_COMMON) && "1".equals(com.baidu.tbadk.util.y.aq(lowerCase, BigImgPbActivityConfig.OPEN_COMMON))) {
                                createNormalCfg.setUserName(com.baidu.tbadk.util.y.aq(lowerCase, BigImgPbActivityConfig.BIG_PB_USER_NAME));
                            }
                            createNormalCfg.setVideo_source("push");
                            if (z2) {
                                createNormalCfg.setFromPushNotify();
                            }
                            tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                        }
                        if (lowerCase.contains("from=threadcard2") || z5) {
                            return 0;
                        }
                        return 1;
                    } else if (z && !TextUtils.isEmpty(aq)) {
                        com.baidu.adp.lib.g.f.h(TbadkCoreApplication.getInst(), ap.ah(TbadkCoreApplication.getInst(), aq));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c10320").r("obj_locate", 3).r("obj_type", 2));
                        return 1;
                    } else if (z6) {
                        tbPageContext.showToast(d.l.page_not_found);
                        return 1;
                    } else {
                        return 3;
                    }
                }
            }
        });
    }
}
