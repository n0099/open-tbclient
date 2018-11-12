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
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BigImgPbActivityConfig;
import com.baidu.tbadk.core.atomData.BookCoverActivityConfig;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tbadk.core.atomData.GodFansCallWebViewActivityConfig;
import com.baidu.tbadk.core.atomData.MangaCoverActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PbFullScreenEditorActivityConfig;
import com.baidu.tbadk.core.atomData.PbSearchEmotionActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.e;
import com.baidu.tieba.pb.account.forbid.ForbidActivity;
import com.baidu.tieba.pb.data.PbFloorAgreeResponseMessage;
import com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
import com.baidu.tieba.pb.pb.sub.SubPbHttpResponseMessage;
import com.baidu.tieba.pb.pb.sub.SubPbSocketResponseMessage;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.webkit.internal.ETAG;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import tbclient.PbPage.PbPageResIdl;
/* loaded from: classes6.dex */
public class PbActivityStatic {
    private static BdAsyncTaskParallel fOd = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());

    static {
        ayC();
        YT();
        bgH();
        bgJ();
        bgM();
        bgK();
        bgL();
        bgG();
        com.baidu.adp.lib.b.d.iQ().i(l.class);
        CustomMessageTask customMessageTask = new CustomMessageTask(2004001, new CustomMessageTask.CustomRunnable<PbActivityConfig>() { // from class: com.baidu.tieba.pb.pb.main.PbActivityStatic.5
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<PbActivityConfig> customMessage) {
                if (customMessage != null && customMessage.getData() != null) {
                    if ("1".equals(customMessage.getData().getIntent().getStringExtra("is_start_for_result"))) {
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
        aKB();
        bgI();
        BdAsyncTask<Void, Void, Void> bdAsyncTask = new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.pb.pb.main.PbActivityStatic.6
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                com.baidu.tbadk.util.ac.a(PbPageRequestMessage.WIRE, PbPageResIdl.class);
                return null;
            }
        };
        bdAsyncTask.setSelfExecute(true);
        bdAsyncTask.setPriority(4);
        bdAsyncTask.execute(new Void[0]);
        TbadkCoreApplication.getInst().RegisterIntent(GodFansCallWebViewActivityConfig.class, GodFansCallWebViewActivity.class);
    }

    private static void YT() {
        com.baidu.tieba.tbadkCore.a.a.a(302001, pbPageSocketResponseMessage.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PB_PAGE_HTTP_CMD, com.baidu.tieba.tbadkCore.a.a.aT("c/f/pb/page", 302001));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(pbPageHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        LocationModel.bCh();
        bgN();
    }

    private static void bgG() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_PB_FLOOR_AGREE, TbConfig.SERVER_ADDRESS + TbConfig.PB_FLOOR_AGREE_URL);
        tbHttpMessageTask.setResponsedClass(PbFloorAgreeResponseMessage.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void bgH() {
        com.baidu.tieba.tbadkCore.a.a.b(2004003, au.class);
    }

    private static void bgI() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_APPLY_COPY_THREAD, TbConfig.SERVER_ADDRESS + TbConfig.URL_APPLY_COPY_THREAD);
        tbHttpMessageTask.setResponsedClass(ApplyCopyThreadResponseMessage.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public static void ayC() {
        com.baidu.tbadk.ala.b.uV().a(2, new com.baidu.tbadk.ala.e() { // from class: com.baidu.tieba.pb.pb.main.PbActivityStatic.1
            @Override // com.baidu.tbadk.ala.e
            public View createView(Context context) {
                TextView bn = com.baidu.tbadk.ala.c.bn(context);
                if (bn != null) {
                    FloatingLayout.a aVar = new FloatingLayout.a(-2, -2);
                    aVar.gravity = 16;
                    com.baidu.tbadk.core.util.al.h(bn, e.d.cp_link_tip_a);
                    aVar.setMargins(com.baidu.adp.lib.util.l.h(context, e.C0200e.ds8), com.baidu.adp.lib.util.l.h(context, e.C0200e.ds4), 0, 0);
                    bn.setLayoutParams(aVar);
                }
                return bn;
            }
        });
        com.baidu.tbadk.ala.b.uV().a(3, new com.baidu.tbadk.ala.e() { // from class: com.baidu.tieba.pb.pb.main.PbActivityStatic.2
            @Override // com.baidu.tbadk.ala.e
            public View createView(Context context) {
                TextView bn = com.baidu.tbadk.ala.c.bn(context);
                if (bn != null) {
                    com.baidu.tbadk.core.util.al.h(bn, e.d.cp_link_tip_a);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.setMargins(com.baidu.adp.lib.util.l.h(context, e.C0200e.ds8), com.baidu.adp.lib.util.l.h(context, e.C0200e.ds2), 0, 0);
                    layoutParams.gravity = 16;
                    bn.setLayoutParams(layoutParams);
                }
                return bn;
            }
        });
        com.baidu.tbadk.ala.b.uV().a(4, new com.baidu.tbadk.ala.e() { // from class: com.baidu.tieba.pb.pb.main.PbActivityStatic.3
            @Override // com.baidu.tbadk.ala.e
            public View createView(Context context) {
                TextView bn = com.baidu.tbadk.ala.c.bn(context);
                if (bn != null) {
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    com.baidu.tbadk.core.util.al.h(bn, e.d.cp_link_tip_a);
                    layoutParams.setMargins(com.baidu.adp.lib.util.l.h(context, e.C0200e.ds8), com.baidu.adp.lib.util.l.h(context, e.C0200e.ds2), 0, 0);
                    layoutParams.gravity = 16;
                    bn.setLayoutParams(layoutParams);
                }
                return bn;
            }
        });
        com.baidu.tbadk.ala.b.uV().a(6, new com.baidu.tbadk.ala.e() { // from class: com.baidu.tieba.pb.pb.main.PbActivityStatic.4
            @Override // com.baidu.tbadk.ala.e
            public View createView(Context context) {
                TextView bn = com.baidu.tbadk.ala.c.bn(context);
                if (bn != null) {
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    com.baidu.tbadk.core.util.al.h(bn, e.d.cp_link_tip_a);
                    layoutParams.setMargins(com.baidu.adp.lib.util.l.h(context, e.C0200e.ds8), com.baidu.adp.lib.util.l.h(context, e.C0200e.ds2), 0, 0);
                    layoutParams.gravity = 16;
                    bn.setLayoutParams(layoutParams);
                }
                return bn;
            }
        });
    }

    private static void bgJ() {
        TbadkCoreApplication.getInst().RegisterIntent(SubPbActivityConfig.class, NewSubPbActivity.class);
        com.baidu.tbadk.task.b a = com.baidu.tieba.tbadkCore.a.a.a(302002, SubPbSocketResponseMessage.class, false, false);
        TbHttpMessageTask a2 = com.baidu.tieba.tbadkCore.a.a.a(302002, CmdConfigHttp.SubPb_HTTP_CMD, "c/f/pb/floor", SubPbHttpResponseMessage.class, false, false, false, false);
        a.setParallel(fOd);
        a2.setParallel(fOd);
    }

    private static void bgK() {
        TbadkCoreApplication.getInst().RegisterIntent(PbSearchEmotionActivityConfig.class, PbSearchEmotionActivity.class);
    }

    private static void bgL() {
        TbadkCoreApplication.getInst().RegisterIntent(PbFullScreenEditorActivityConfig.class, PbFullScreenEditorActivity.class);
    }

    private static void bgM() {
        TbadkCoreApplication.getInst().RegisterIntent(ForbidActivityConfig.class, ForbidActivity.class);
    }

    private static void aKB() {
        ay.Db().a(new ay.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivityStatic.7
            Pattern dqg = Pattern.compile("http[s]?://tieba.baidu.com/p/([\\d]+)");

            /* JADX WARN: Code restructure failed: missing block: B:64:0x0186, code lost:
                if (com.baidu.adp.lib.util.StringUtils.isNull(r2) == false) goto L73;
             */
            @Override // com.baidu.tbadk.core.util.ay.a
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public int a(TbPageContext<?> tbPageContext, String[] strArr) {
                String aL;
                boolean z;
                boolean z2;
                boolean z3;
                String str;
                if (strArr == null || strArr.length == 0 || strArr[0] == null) {
                    return 3;
                }
                boolean z4 = strArr.length > 1 && !StringUtils.isNull(strArr[1]) && strArr[1].toLowerCase().contains("n/video/opersquare");
                boolean z5 = false;
                String lowerCase = strArr[0].toLowerCase();
                String str2 = null;
                Matcher matcher = this.dqg.matcher(lowerCase);
                String str3 = Config.PUSH;
                boolean z6 = false;
                if (Pattern.compile("http[s]?://tieba\\.baidu\\.com/p/([\\d]+)\\?pid=([\\d]+)&tid=([\\d]+)&threadtype=([\\d]+)&jump_type=(.*)&jump_tieba_native=1").matcher(lowerCase).find()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001609, lowerCase));
                    return 0;
                } else if (lowerCase.contains("bookcover:")) {
                    Map<String, String> fv = ay.fv(lowerCase.substring("bookcover:".length()));
                    if (fv == null || fv.size() <= 0) {
                        return 0;
                    }
                    if (com.baidu.adp.lib.g.b.l(fv.get("book_type"), 1) == 3) {
                        if (!TbadkCoreApplication.getInst().appResponseToIntentClass(MangaCoverActivityConfig.class)) {
                            com.baidu.adp.lib.util.l.showToast(tbPageContext.getPageActivity(), e.j.manga_plugin_not_install_tip);
                            return 0;
                        }
                        return 3;
                    } else if (!TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                        com.baidu.adp.lib.util.l.showToast(tbPageContext.getPageActivity(), e.j.book_plugin_not_install_tip);
                        return 0;
                    } else {
                        return 3;
                    }
                } else {
                    if (matcher.find()) {
                        String group = matcher.group(1);
                        if (lowerCase != null) {
                            String[] split = lowerCase.split(ETAG.ITEM_SEPARATOR);
                            String str4 = Config.PUSH;
                            for (int i = 0; i < split.length; i++) {
                                if (split[i] != null) {
                                    if (split[i].startsWith("thread_type=")) {
                                        split[i].substring("thread_type=".length());
                                    } else if (split[i].startsWith("playstatkey=")) {
                                        str4 = split[i].substring("playstatkey=".length());
                                    }
                                }
                            }
                            z5 = com.baidu.adp.lib.g.b.g(com.baidu.tbadk.util.ab.aL(lowerCase, "is_from_push="), false);
                            str3 = str4;
                        }
                        if (lowerCase != null && lowerCase.contains("?")) {
                            String[] split2 = lowerCase.substring(lowerCase.indexOf("?") + 1, lowerCase.length()).split(ETAG.ITEM_SEPARATOR);
                            int length = split2.length;
                            int i2 = 0;
                            while (true) {
                                if (i2 >= length) {
                                    break;
                                }
                                String str5 = split2[i2];
                                if (!str5.startsWith("playstatkey=")) {
                                    i2++;
                                } else {
                                    str3 = str5.substring("playstatkey=".length());
                                    break;
                                }
                            }
                        }
                        if (lowerCase != null) {
                            str = com.baidu.tbadk.util.ab.aL(lowerCase, "sttype=");
                        }
                        str = "allthread";
                        z6 = true;
                        str2 = str;
                        aL = group;
                        z = z5;
                        z2 = false;
                    } else if (lowerCase != null && (lowerCase.startsWith("http://tieba.baidu.com/f?") || lowerCase.startsWith("http://tieba.baidu.com/f?"))) {
                        String str6 = null;
                        if (lowerCase.startsWith("http://tieba.baidu.com/f?")) {
                            str6 = lowerCase.substring("http://tieba.baidu.com/f?".length());
                        } else if (lowerCase.startsWith("http://tieba.baidu.com/f?")) {
                            str6 = lowerCase.substring("http://tieba.baidu.com/f?".length());
                        }
                        if (str6 == null) {
                            z3 = false;
                            aL = null;
                        } else {
                            String[] split3 = str6.split(ETAG.ITEM_SEPARATOR);
                            int i3 = 0;
                            while (true) {
                                if (i3 >= split3.length) {
                                    aL = null;
                                    z3 = false;
                                    break;
                                } else if (split3[i3] == null || !split3[i3].startsWith("kz=")) {
                                    i3++;
                                } else {
                                    aL = split3[i3].substring(3);
                                    z3 = true;
                                    break;
                                }
                            }
                            if (!TextUtils.isEmpty(aL) && aL.contains(ETAG.ITEM_SEPARATOR)) {
                                aL = aL.split(ETAG.ITEM_SEPARATOR)[0];
                            }
                            if (TextUtils.isEmpty(aL)) {
                                aL = null;
                            }
                        }
                        z = false;
                        z2 = false;
                        boolean z7 = z3;
                        str2 = "allthread";
                        z6 = z7;
                    } else if (lowerCase.startsWith("pb:")) {
                        aL = lowerCase.substring(3);
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
                        aL = lowerCase.substring("com.baidu.tieba://?kz=".length());
                        z2 = true;
                        z = false;
                    } else if (lowerCase.contains(TbConfig.WEB_VIEW_JUMP2NATIVE) && lowerCase.contains("kz=")) {
                        aL = com.baidu.tbadk.util.ab.aL(lowerCase, "kz=");
                        z = false;
                        z2 = false;
                    } else {
                        return 3;
                    }
                    if (!StringUtils.isNull(aL, true) && tbPageContext != null) {
                        PbActivityConfig createNormalCfg = new PbActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(aL, null, str2);
                        if (lowerCase.contains(BigImgPbActivityConfig.OPEN_COMMON) && "1".equals(com.baidu.tbadk.util.ab.aL(lowerCase, BigImgPbActivityConfig.OPEN_COMMON))) {
                            createNormalCfg.setUserName(com.baidu.tbadk.util.ab.aL(lowerCase, BigImgPbActivityConfig.BIG_PB_USER_NAME));
                        }
                        createNormalCfg.setVideo_source(str3);
                        if (z) {
                            createNormalCfg.setFromPushNotify();
                            createNormalCfg.setStartFrom(7);
                        }
                        tbPageContext.sendMessage(new CustomMessage(2004001, createNormalCfg));
                        if (lowerCase.contains("from=threadcard2") || z4) {
                            return 0;
                        }
                        return 0;
                    } else if (z2 && !TextUtils.isEmpty(aL)) {
                        com.baidu.adp.lib.g.f.e(TbadkCoreApplication.getInst(), aq.at(TbadkCoreApplication.getInst(), aL));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10320").x("obj_locate", 3).x("obj_type", 2));
                        return 1;
                    } else if (z6) {
                        tbPageContext.showToast(e.j.page_not_found);
                        return 1;
                    } else {
                        return 3;
                    }
                }
            }
        });
    }

    private static void bgN() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2921343, new CustomMessageTask.CustomRunnable<Context>() { // from class: com.baidu.tieba.pb.pb.main.PbActivityStatic.8
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<com.baidu.tieba.ueg.a> run(CustomMessage<Context> customMessage) {
                if (customMessage == null || !(customMessage.getData() instanceof Context)) {
                    return null;
                }
                return new CustomResponsedMessage<>(2921343, new com.baidu.tieba.pb.pb.report.a(customMessage.getData()));
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
