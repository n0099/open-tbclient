package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.net.Uri;
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
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.FloatingLayout;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BigImgPbActivityConfig;
import com.baidu.tbadk.core.atomData.BookCoverActivityConfig;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tbadk.core.atomData.MangaCoverActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PbFullScreenEditorActivityConfig;
import com.baidu.tbadk.core.atomData.PbSearchEmotionActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
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
/* loaded from: classes9.dex */
public class PbActivityStatic {
    private static BdAsyncTaskParallel jIi = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());

    static {
        bUs();
        bqv();
        cEd();
        cEf();
        cEi();
        cEg();
        cEh();
        cEc();
        SwitchManager.getInstance().registerSwitch(n.class);
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.START_PB_ACTIVITY, new CustomMessageTask.CustomRunnable<PbActivityConfig>() { // from class: com.baidu.tieba.pb.pb.main.PbActivityStatic.5
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<PbActivityConfig> customMessage) {
                if (customMessage != null && customMessage.getData() != null) {
                    if ("1".equals(customMessage.getData().getIntent().getStringExtra("is_start_for_result"))) {
                        customMessage.getData().startActivityForResult(customMessage.getData().getIntent().getIntExtra("request_code", 0), PbActivity.class);
                    } else {
                        customMessage.getData().startActivity(PbActivity.class);
                    }
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        bOG();
        cEe();
        BdAsyncTask<Void, Void, Void> bdAsyncTask = new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.pb.pb.main.PbActivityStatic.6
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                com.baidu.tbadk.util.ai.a(PbPageRequestMessage.WIRE, PbPageResIdl.class);
                return null;
            }
        };
        bdAsyncTask.setSelfExecute(true);
        bdAsyncTask.setPriority(4);
        bdAsyncTask.execute(new Void[0]);
    }

    private static void bqv() {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_PB_PAGE, pbPageSocketResponseMessage.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1001801, com.baidu.tieba.tbadkCore.a.a.bF(Config.PB_ADDRESS, CmdConfigSocket.CMD_PB_PAGE));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(pbPageHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        LocationModel.dex();
        cEj();
    }

    private static void cEc() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1001601, TbConfig.SERVER_ADDRESS + TbConfig.PB_FLOOR_AGREE_URL);
        tbHttpMessageTask.setResponsedClass(PbFloorAgreeResponseMessage.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void cEd() {
        com.baidu.tieba.tbadkCore.a.a.b(CmdConfigCustom.PB_PAGE_CACHE_CMD, ay.class);
    }

    private static void cEe() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003066, TbConfig.SERVER_ADDRESS + TbConfig.URL_APPLY_COPY_THREAD);
        tbHttpMessageTask.setResponsedClass(ApplyCopyThreadResponseMessage.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public static void bUs() {
        com.baidu.tbadk.ala.b.aMC().a(2, new com.baidu.tbadk.ala.e() { // from class: com.baidu.tieba.pb.pb.main.PbActivityStatic.1
            @Override // com.baidu.tbadk.ala.e
            public View createView(Context context) {
                TextView dB = com.baidu.tbadk.ala.c.dB(context);
                if (dB != null) {
                    FloatingLayout.LayoutParams layoutParams = new FloatingLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 16;
                    com.baidu.tbadk.core.util.am.setViewTextColor(dB, (int) R.color.cp_link_tip_a);
                    layoutParams.setMargins(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.ds8), com.baidu.adp.lib.util.l.getDimens(context, R.dimen.ds4), 0, 0);
                    dB.setLayoutParams(layoutParams);
                }
                return dB;
            }
        });
        com.baidu.tbadk.ala.b.aMC().a(3, new com.baidu.tbadk.ala.e() { // from class: com.baidu.tieba.pb.pb.main.PbActivityStatic.2
            @Override // com.baidu.tbadk.ala.e
            public View createView(Context context) {
                TextView dB = com.baidu.tbadk.ala.c.dB(context);
                if (dB != null) {
                    com.baidu.tbadk.core.util.am.setViewTextColor(dB, (int) R.color.cp_link_tip_a);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.setMargins(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.ds8), com.baidu.adp.lib.util.l.getDimens(context, R.dimen.ds2), 0, 0);
                    layoutParams.gravity = 16;
                    dB.setLayoutParams(layoutParams);
                }
                return dB;
            }
        });
        com.baidu.tbadk.ala.b.aMC().a(4, new com.baidu.tbadk.ala.e() { // from class: com.baidu.tieba.pb.pb.main.PbActivityStatic.3
            @Override // com.baidu.tbadk.ala.e
            public View createView(Context context) {
                TextView dB = com.baidu.tbadk.ala.c.dB(context);
                if (dB != null) {
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    com.baidu.tbadk.core.util.am.setViewTextColor(dB, (int) R.color.cp_link_tip_a);
                    layoutParams.setMargins(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.ds8), com.baidu.adp.lib.util.l.getDimens(context, R.dimen.ds2), 0, 0);
                    layoutParams.gravity = 16;
                    dB.setLayoutParams(layoutParams);
                }
                return dB;
            }
        });
        com.baidu.tbadk.ala.b.aMC().a(6, new com.baidu.tbadk.ala.e() { // from class: com.baidu.tieba.pb.pb.main.PbActivityStatic.4
            @Override // com.baidu.tbadk.ala.e
            public View createView(Context context) {
                TextView dB = com.baidu.tbadk.ala.c.dB(context);
                if (dB != null) {
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    com.baidu.tbadk.core.util.am.setViewTextColor(dB, (int) R.color.cp_link_tip_a);
                    layoutParams.setMargins(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.ds8), com.baidu.adp.lib.util.l.getDimens(context, R.dimen.ds2), 0, 0);
                    layoutParams.gravity = 16;
                    dB.setLayoutParams(layoutParams);
                }
                return dB;
            }
        });
    }

    private static void cEf() {
        TbadkCoreApplication.getInst().RegisterIntent(SubPbActivityConfig.class, NewSubPbActivity.class);
        com.baidu.tbadk.task.b a = com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_SUBPB_FLOOR, SubPbSocketResponseMessage.class, false, false);
        TbHttpMessageTask a2 = com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_SUBPB_FLOOR, 1002100, Config.FLOOR_ADDRESS, SubPbHttpResponseMessage.class, false, false, false, false);
        a.setParallel(jIi);
        a2.setParallel(jIi);
    }

    private static void cEg() {
        TbadkCoreApplication.getInst().RegisterIntent(PbSearchEmotionActivityConfig.class, PbSearchEmotionActivity.class);
    }

    private static void cEh() {
        TbadkCoreApplication.getInst().RegisterIntent(PbFullScreenEditorActivityConfig.class, PbFullScreenEditorActivity.class);
    }

    private static void cEi() {
        TbadkCoreApplication.getInst().RegisterIntent(ForbidActivityConfig.class, ForbidActivity.class);
    }

    private static void bOG() {
        com.baidu.tbadk.core.util.ba.aVa().a(new ba.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivityStatic.7
            Pattern hfk = Pattern.compile("http[s]?://tieba.baidu.com/p/([\\d]+)");

            /* JADX WARN: Code restructure failed: missing block: B:80:0x0236, code lost:
                if (com.baidu.adp.lib.util.StringUtils.isNull(r1) == false) goto L89;
             */
            @Override // com.baidu.tbadk.core.util.ba.a
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
                String matchStringFromURL;
                String str;
                String str2;
                boolean z;
                boolean z2;
                boolean z3;
                String str3;
                PbActivityConfig createNormalCfg;
                boolean z4;
                String str4;
                if (strArr == null || strArr.length == 0 || strArr[0] == null) {
                    return 3;
                }
                boolean z5 = strArr.length > 1 && !StringUtils.isNull(strArr[1]) && strArr[1].toLowerCase().contains("n/video/opersquare");
                String lowerCase = strArr[0].toLowerCase();
                Matcher matcher = this.hfk.matcher(lowerCase);
                String str5 = "push";
                boolean z6 = false;
                if (Pattern.compile("http[s]?://tieba\\.baidu\\.com/p/([\\d]+)\\?pid=([\\d]+)&tid=([\\d]+)&threadtype=([\\d]+)&jump_type=(.*)&jump_tieba_native=1").matcher(lowerCase).find() || lowerCase.contains("isbaijiahao=1")) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SEARCH_JUMP_PB, new com.baidu.tbadk.data.h(tbPageContext, lowerCase)));
                    return 0;
                } else if (lowerCase.contains("unidispatch/pb")) {
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(tbPageContext.getPageActivity());
                    pbActivityConfig.setUri(Uri.parse(lowerCase));
                    tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
                    return 0;
                } else {
                    if (lowerCase.contains("tieba.baidu.com/subp")) {
                        String paramStr = com.baidu.tbadk.core.util.ba.getParamStr(lowerCase);
                        if (!TextUtils.isEmpty(paramStr)) {
                            Map<String, String> paramPair = com.baidu.tbadk.core.util.ba.getParamPair(paramStr);
                            if (!paramPair.isEmpty()) {
                                String str6 = paramPair.get("tid");
                                String str7 = paramPair.get("pid");
                                if (!TextUtils.isEmpty(str6) && !TextUtils.isEmpty(str7)) {
                                    SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(tbPageContext.getPageActivity()).createSubPbActivityConfig(str6, str7, "", true);
                                    createSubPbActivityConfig.setIsFromeSchema(true);
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createSubPbActivityConfig));
                                    return 0;
                                }
                            }
                        }
                    }
                    if (lowerCase.contains("bookcover:")) {
                        Map<String, String> paramPair2 = com.baidu.tbadk.core.util.ba.getParamPair(lowerCase.substring("bookcover:".length()));
                        if (paramPair2 == null || paramPair2.size() <= 0) {
                            return 0;
                        }
                        if (com.baidu.adp.lib.f.b.toInt(paramPair2.get("book_type"), 1) == 3) {
                            if (!TbadkCoreApplication.getInst().appResponseToIntentClass(MangaCoverActivityConfig.class)) {
                                com.baidu.adp.lib.util.l.showToast(tbPageContext.getPageActivity(), (int) R.string.manga_plugin_not_install_tip);
                                return 0;
                            }
                            return 3;
                        } else if (!TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                            com.baidu.adp.lib.util.l.showToast(tbPageContext.getPageActivity(), (int) R.string.book_plugin_not_install_tip);
                            return 0;
                        } else {
                            return 3;
                        }
                    }
                    if (matcher.find()) {
                        String group = matcher.group(1);
                        String queryParameter = Uri.parse(lowerCase).getQueryParameter("pid");
                        if (lowerCase == null) {
                            z4 = false;
                        } else {
                            String[] split = lowerCase.split(ETAG.ITEM_SEPARATOR);
                            String str8 = "push";
                            for (int i = 0; i < split.length; i++) {
                                if (split[i] != null) {
                                    if (split[i].startsWith("thread_type=")) {
                                        split[i].substring("thread_type=".length());
                                    } else if (split[i].startsWith("playstatkey=")) {
                                        str8 = split[i].substring("playstatkey=".length());
                                    }
                                }
                            }
                            z4 = com.baidu.adp.lib.f.b.toBoolean(com.baidu.tbadk.util.ah.getMatchStringFromURL(lowerCase, "is_from_push="), false);
                            str5 = str8;
                        }
                        if (lowerCase != null && lowerCase.contains("?")) {
                            String[] split2 = lowerCase.substring(lowerCase.indexOf("?") + 1, lowerCase.length()).split(ETAG.ITEM_SEPARATOR);
                            int length = split2.length;
                            int i2 = 0;
                            while (true) {
                                if (i2 >= length) {
                                    break;
                                }
                                String str9 = split2[i2];
                                if (!str9.startsWith("playstatkey=")) {
                                    i2++;
                                } else {
                                    str5 = str9.substring("playstatkey=".length());
                                    break;
                                }
                            }
                        }
                        if (lowerCase != null) {
                            str4 = com.baidu.tbadk.util.ah.getMatchStringFromURL(lowerCase, "sttype=");
                        }
                        str4 = "allthread";
                        z6 = true;
                        z = false;
                        z2 = z4;
                        matchStringFromURL = group;
                        String str10 = str4;
                        str2 = queryParameter;
                        str = str10;
                    } else if (lowerCase != null && (lowerCase.startsWith("http://tieba.baidu.com/f?") || lowerCase.startsWith("http://tieba.baidu.com/f?"))) {
                        String str11 = null;
                        if (lowerCase.startsWith("http://tieba.baidu.com/f?")) {
                            str11 = lowerCase.substring("http://tieba.baidu.com/f?".length());
                        } else if (lowerCase.startsWith("http://tieba.baidu.com/f?")) {
                            str11 = lowerCase.substring("http://tieba.baidu.com/f?".length());
                        }
                        if (str11 == null) {
                            z3 = false;
                            str3 = null;
                        } else {
                            String[] split3 = str11.split(ETAG.ITEM_SEPARATOR);
                            int i3 = 0;
                            while (true) {
                                if (i3 >= split3.length) {
                                    str3 = null;
                                    z3 = false;
                                    break;
                                } else if (split3[i3] == null || !split3[i3].startsWith("kz=")) {
                                    i3++;
                                } else {
                                    str3 = split3[i3].substring(3);
                                    z3 = true;
                                    break;
                                }
                            }
                            if (!TextUtils.isEmpty(str3) && str3.contains(ETAG.ITEM_SEPARATOR)) {
                                str3 = str3.split(ETAG.ITEM_SEPARATOR)[0];
                            }
                            if (TextUtils.isEmpty(str3)) {
                                str3 = null;
                            }
                        }
                        str = "allthread";
                        z = false;
                        z6 = z3;
                        matchStringFromURL = str3;
                        str2 = "";
                        z2 = false;
                    } else if (lowerCase.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                        String substring = lowerCase.substring(3);
                        z6 = true;
                        if (strArr.length <= 1) {
                            matchStringFromURL = substring;
                            str = null;
                            str2 = "";
                            z = false;
                            z2 = false;
                        } else {
                            str = strArr[1];
                            z = false;
                            matchStringFromURL = substring;
                            str2 = "";
                            z2 = false;
                        }
                    } else if (lowerCase.startsWith("com.baidu.tieba://?kz=")) {
                        str = null;
                        z = true;
                        matchStringFromURL = lowerCase.substring("com.baidu.tieba://?kz=".length());
                        str2 = "";
                        z2 = false;
                    } else if (lowerCase.contains("jump_tieba_native=1") && lowerCase.contains("kz=")) {
                        matchStringFromURL = com.baidu.tbadk.util.ah.getMatchStringFromURL(lowerCase, "kz=");
                        str = null;
                        str2 = "";
                        z = false;
                        z2 = false;
                    } else {
                        return 3;
                    }
                    if (!StringUtils.isNull(matchStringFromURL, true) && tbPageContext != null) {
                        if (StringUtils.isNull(str2)) {
                            createNormalCfg = new PbActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(matchStringFromURL, null, str);
                        } else {
                            createNormalCfg = new PbActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(matchStringFromURL, str2, str);
                        }
                        if (lowerCase.contains(BigImgPbActivityConfig.OPEN_COMMON) && "1".equals(com.baidu.tbadk.util.ah.getMatchStringFromURL(lowerCase, BigImgPbActivityConfig.OPEN_COMMON))) {
                            createNormalCfg.setUserName(com.baidu.tbadk.util.ah.getMatchStringFromURL(lowerCase, BigImgPbActivityConfig.BIG_PB_USER_NAME));
                        }
                        createNormalCfg.setVideo_source(str5);
                        if (z2) {
                            createNormalCfg.setFromPushNotify();
                            createNormalCfg.setStartFrom(7);
                        }
                        tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                        if (lowerCase.contains("from=threadcard2") || z5) {
                            return 0;
                        }
                        return 0;
                    } else if (z && !TextUtils.isEmpty(matchStringFromURL)) {
                        com.baidu.adp.lib.f.f.startService(TbadkCoreApplication.getInst(), au.aC(TbadkCoreApplication.getInst(), matchStringFromURL));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10320").ag("obj_locate", 3).ag("obj_type", 2));
                        return 1;
                    } else if (z6) {
                        tbPageContext.showToast((int) R.string.page_not_found);
                        return 1;
                    } else {
                        return 3;
                    }
                }
            }
        });
    }

    private static void cEj() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMS_TBEAN_RESOURCE_URL_AND_PHOTO, new CustomMessageTask.CustomRunnable<Context>() { // from class: com.baidu.tieba.pb.pb.main.PbActivityStatic.8
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<com.baidu.tieba.ueg.a> run(CustomMessage<Context> customMessage) {
                if (customMessage == null || !(customMessage.getData() instanceof Context)) {
                    return null;
                }
                return new CustomResponsedMessage<>(CmdConfigCustom.CMS_TBEAN_RESOURCE_URL_AND_PHOTO, new com.baidu.tieba.pb.pb.report.a(customMessage.getData()));
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
