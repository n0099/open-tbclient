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
import com.baidu.tbadk.core.atomData.GodFansCallWebViewActivityConfig;
import com.baidu.tbadk.core.atomData.MangaCoverActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PbSearchEmotionActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.account.forbid.ForbidActivity;
import com.baidu.tieba.pb.pb.main.PbFloorAgreeModel;
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
    private static BdAsyncTaskParallel eMg = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());

    static {
        aiH();
        ND();
        aSb();
        aSd();
        aSf();
        aSe();
        aSa();
        com.baidu.adp.lib.b.d.eV().f(n.class);
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
        atr();
        aSc();
        BdAsyncTask<Void, Void, Void> bdAsyncTask = new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.pb.pb.main.PbActivityStatic.6
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                com.baidu.tbadk.util.aa.a(PbPageRequestMessage.WIRE, PbPageResIdl.class);
                return null;
            }
        };
        bdAsyncTask.setSelfExecute(true);
        bdAsyncTask.setPriority(4);
        bdAsyncTask.execute(new Void[0]);
        TbadkCoreApplication.getInst().RegisterIntent(GodFansCallWebViewActivityConfig.class, GodFansCallWebViewActivity.class);
    }

    private static void ND() {
        com.baidu.tieba.tbadkCore.a.a.a(302001, pbPageSocketResponseMessage.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PB_PAGE_HTTP_CMD, com.baidu.tieba.tbadkCore.a.a.aE("c/f/pb/page", 302001));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(pbPageHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        LocationModel.bvf();
    }

    private static void aSa() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_PB_FLOOR_AGREE, TbConfig.SERVER_ADDRESS + TbConfig.PB_FLOOR_AGREE_URL);
        tbHttpMessageTask.setResponsedClass(PbFloorAgreeModel.PbFloorAgreeResponseMessage.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void aSb() {
        com.baidu.tieba.tbadkCore.a.a.b(CmdConfigCustom.PB_PAGE_CACHE_CMD, as.class);
    }

    private static void aSc() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_APPLY_COPY_THREAD, TbConfig.SERVER_ADDRESS + TbConfig.URL_APPLY_COPY_THREAD);
        tbHttpMessageTask.setResponsedClass(ApplyCopyThreadResponseMessage.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public static void aiH() {
        com.baidu.tbadk.ala.b.nu().a(2, new com.baidu.tbadk.ala.d() { // from class: com.baidu.tieba.pb.pb.main.PbActivityStatic.1
            @Override // com.baidu.tbadk.ala.d
            public View aw(Context context) {
                TextView av = com.baidu.tbadk.ala.c.av(context);
                if (av != null) {
                    FloatingLayout.a aVar = new FloatingLayout.a(-2, -2);
                    aVar.gravity = 16;
                    com.baidu.tbadk.core.util.aj.i(av, d.C0080d.cp_link_tip_a);
                    aVar.setMargins(com.baidu.adp.lib.util.l.f(context, d.e.ds8), com.baidu.adp.lib.util.l.f(context, d.e.ds4), 0, 0);
                    av.setLayoutParams(aVar);
                }
                return av;
            }
        });
        com.baidu.tbadk.ala.b.nu().a(3, new com.baidu.tbadk.ala.d() { // from class: com.baidu.tieba.pb.pb.main.PbActivityStatic.2
            @Override // com.baidu.tbadk.ala.d
            public View aw(Context context) {
                TextView av = com.baidu.tbadk.ala.c.av(context);
                if (av != null) {
                    com.baidu.tbadk.core.util.aj.i(av, d.C0080d.cp_link_tip_a);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.setMargins(com.baidu.adp.lib.util.l.f(context, d.e.ds8), com.baidu.adp.lib.util.l.f(context, d.e.ds2), 0, 0);
                    layoutParams.gravity = 16;
                    av.setLayoutParams(layoutParams);
                }
                return av;
            }
        });
        com.baidu.tbadk.ala.b.nu().a(4, new com.baidu.tbadk.ala.d() { // from class: com.baidu.tieba.pb.pb.main.PbActivityStatic.3
            @Override // com.baidu.tbadk.ala.d
            public View aw(Context context) {
                TextView av = com.baidu.tbadk.ala.c.av(context);
                if (av != null) {
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    com.baidu.tbadk.core.util.aj.i(av, d.C0080d.cp_link_tip_a);
                    layoutParams.setMargins(com.baidu.adp.lib.util.l.f(context, d.e.ds8), com.baidu.adp.lib.util.l.f(context, d.e.ds2), 0, 0);
                    layoutParams.gravity = 16;
                    av.setLayoutParams(layoutParams);
                }
                return av;
            }
        });
        com.baidu.tbadk.ala.b.nu().a(6, new com.baidu.tbadk.ala.d() { // from class: com.baidu.tieba.pb.pb.main.PbActivityStatic.4
            @Override // com.baidu.tbadk.ala.d
            public View aw(Context context) {
                TextView av = com.baidu.tbadk.ala.c.av(context);
                if (av != null) {
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    com.baidu.tbadk.core.util.aj.i(av, d.C0080d.cp_link_tip_a);
                    layoutParams.setMargins(com.baidu.adp.lib.util.l.f(context, d.e.ds8), com.baidu.adp.lib.util.l.f(context, d.e.ds2), 0, 0);
                    layoutParams.gravity = 16;
                    av.setLayoutParams(layoutParams);
                }
                return av;
            }
        });
    }

    private static void aSd() {
        TbadkCoreApplication.getInst().RegisterIntent(SubPbActivityConfig.class, NewSubPbActivity.class);
        com.baidu.tbadk.task.b a = com.baidu.tieba.tbadkCore.a.a.a(302002, SubPbSocketResponseMessage.class, false, false);
        TbHttpMessageTask a2 = com.baidu.tieba.tbadkCore.a.a.a(302002, CmdConfigHttp.SubPb_HTTP_CMD, "c/f/pb/floor", SubPbHttpResponseMessage.class, false, false, false, false);
        a.setParallel(eMg);
        a2.setParallel(eMg);
    }

    private static void aSe() {
        TbadkCoreApplication.getInst().RegisterIntent(PbSearchEmotionActivityConfig.class, PbSearchEmotionActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(EmotionEditActivityConfig.class, EmotionEditActivity.class);
    }

    private static void aSf() {
        TbadkCoreApplication.getInst().RegisterIntent(ForbidActivityConfig.class, ForbidActivity.class);
    }

    private static void atr() {
        av.vI().a(new av.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivityStatic.7
            Pattern crV = Pattern.compile("http[s]?://tieba.baidu.com/p/([\\d]+)");

            @Override // com.baidu.tbadk.core.util.av.a
            public int a(TbPageContext<?> tbPageContext, String[] strArr) {
                String ar;
                boolean z;
                boolean z2;
                boolean z3;
                String str;
                boolean z4;
                if (strArr == null || strArr.length == 0 || strArr[0] == null) {
                    return 3;
                }
                boolean z5 = strArr.length > 1 && !StringUtils.isNull(strArr[1]) && strArr[1].toLowerCase().contains("n/video/opersquare");
                String lowerCase = strArr[0].toLowerCase();
                String str2 = null;
                Matcher matcher = this.crV.matcher(lowerCase);
                String str3 = "";
                String str4 = "push";
                boolean z6 = false;
                if (Pattern.compile("http[s]?://tieba\\.baidu\\.com/p/([\\d]+)\\?pid=([\\d]+)&tid=([\\d]+)&threadtype=([\\d]+)&jump_type=(.*)&jump_tieba_native=1").matcher(lowerCase).find()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SEARCH_JUMP_PB, lowerCase));
                    return 0;
                } else if (lowerCase.contains("bookcover:")) {
                    Map<String, String> dY = av.dY(lowerCase.substring("bookcover:".length()));
                    if (dY == null || dY.size() <= 0) {
                        return 0;
                    }
                    if (com.baidu.adp.lib.g.b.g(dY.get("book_type"), 1) == 3) {
                        if (!TbadkCoreApplication.getInst().appResponseToIntentClass(MangaCoverActivityConfig.class)) {
                            com.baidu.adp.lib.util.l.showToast(tbPageContext.getPageActivity(), d.j.manga_plugin_not_install_tip);
                            return 0;
                        }
                        return 3;
                    } else if (!TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                        com.baidu.adp.lib.util.l.showToast(tbPageContext.getPageActivity(), d.j.book_plugin_not_install_tip);
                        return 0;
                    } else {
                        return 3;
                    }
                } else {
                    if (matcher.find()) {
                        String group = matcher.group(1);
                        if (lowerCase == null) {
                            str = "push";
                            z4 = false;
                        } else {
                            String[] split = lowerCase.split("&");
                            str = "push";
                            String str5 = "";
                            for (int i = 0; i < split.length; i++) {
                                if (split[i] != null) {
                                    if (split[i].startsWith("thread_type=")) {
                                        str5 = split[i].substring("thread_type=".length());
                                    } else if (split[i].startsWith("playstatkey=")) {
                                        str = split[i].substring("playstatkey=".length());
                                    }
                                }
                            }
                            str3 = str5;
                            z4 = com.baidu.adp.lib.g.b.d(com.baidu.tbadk.util.z.ar(lowerCase, "is_from_push="), false);
                        }
                        if (lowerCase != null && lowerCase.contains("?")) {
                            String[] split2 = lowerCase.substring(lowerCase.indexOf("?") + 1, lowerCase.length()).split("&");
                            int length = split2.length;
                            int i2 = 0;
                            while (true) {
                                if (i2 >= length) {
                                    break;
                                }
                                String str6 = split2[i2];
                                if (!str6.startsWith("playstatkey=")) {
                                    i2++;
                                } else {
                                    str = str6.substring("playstatkey=".length());
                                    break;
                                }
                            }
                        }
                        z6 = true;
                        z2 = false;
                        str2 = "allthread";
                        z = z4;
                        str4 = str;
                        ar = group;
                    } else if (lowerCase != null && (lowerCase.startsWith("http://tieba.baidu.com/f?") || lowerCase.startsWith("http://tieba.baidu.com/f?"))) {
                        String str7 = null;
                        if (lowerCase.startsWith("http://tieba.baidu.com/f?")) {
                            str7 = lowerCase.substring("http://tieba.baidu.com/f?".length());
                        } else if (lowerCase.startsWith("http://tieba.baidu.com/f?")) {
                            str7 = lowerCase.substring("http://tieba.baidu.com/f?".length());
                        }
                        if (str7 == null) {
                            z3 = false;
                            ar = null;
                        } else {
                            String[] split3 = str7.split("&");
                            int i3 = 0;
                            while (true) {
                                if (i3 >= split3.length) {
                                    ar = null;
                                    z3 = false;
                                    break;
                                } else if (split3[i3] == null || !split3[i3].startsWith("kz=")) {
                                    i3++;
                                } else {
                                    ar = split3[i3].substring(3);
                                    z3 = true;
                                    break;
                                }
                            }
                            if (!TextUtils.isEmpty(ar) && ar.contains("&")) {
                                ar = ar.split("&")[0];
                            }
                            if (TextUtils.isEmpty(ar)) {
                                ar = null;
                            }
                        }
                        z = false;
                        z2 = false;
                        boolean z7 = z3;
                        str2 = "allthread";
                        z6 = z7;
                    } else if (lowerCase.startsWith("pb:")) {
                        ar = lowerCase.substring(3);
                        z6 = true;
                        if (strArr.length <= 1) {
                            z = false;
                            z2 = false;
                        } else {
                            str2 = strArr[1];
                            z = false;
                            z2 = false;
                        }
                    } else if (lowerCase.startsWith("com.baidu.tieba://?kz=")) {
                        ar = lowerCase.substring("com.baidu.tieba://?kz=".length());
                        z2 = true;
                        z = false;
                    } else if (lowerCase.contains(TbConfig.WEB_VIEW_JUMP2NATIVE) && lowerCase.contains("kz=")) {
                        ar = com.baidu.tbadk.util.z.ar(lowerCase, "kz=");
                        z = false;
                        z2 = false;
                    } else {
                        return 3;
                    }
                    if (!StringUtils.isNull(ar, true) && tbPageContext != null) {
                        if (!StringUtils.isNull(str3) && com.baidu.adp.lib.g.b.g(str3, 0) == 33 && TbadkCoreApplication.getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                            tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(tbPageContext.getPageActivity(), ar).pi()));
                        } else {
                            PbActivityConfig createNormalCfg = new PbActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(ar, null, str2);
                            if (lowerCase.contains(BigImgPbActivityConfig.OPEN_COMMON) && "1".equals(com.baidu.tbadk.util.z.ar(lowerCase, BigImgPbActivityConfig.OPEN_COMMON))) {
                                createNormalCfg.setUserName(com.baidu.tbadk.util.z.ar(lowerCase, BigImgPbActivityConfig.BIG_PB_USER_NAME));
                            }
                            createNormalCfg.setVideo_source(str4);
                            if (z) {
                                createNormalCfg.setFromPushNotify();
                            }
                            tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                        }
                        if (lowerCase.contains("from=threadcard2") || z5) {
                            return 0;
                        }
                        return 0;
                    } else if (z2 && !TextUtils.isEmpty(ar)) {
                        com.baidu.adp.lib.g.f.f(TbadkCoreApplication.getInst(), ao.ac(TbadkCoreApplication.getInst(), ar));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10320").r("obj_locate", 3).r("obj_type", 2));
                        return 1;
                    } else if (z6) {
                        tbPageContext.showToast(d.j.page_not_found);
                        return 1;
                    } else {
                        return 3;
                    }
                }
            }
        });
    }
}
