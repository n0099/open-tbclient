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
import com.baidu.live.tbadk.core.util.TiebaInitialize;
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
import com.baidu.tbadk.core.util.bf;
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
/* loaded from: classes2.dex */
public class PbActivityStatic {
    private static BdAsyncTaskParallel lPP = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());

    static {
        cCb();
        bRn();
        dmW();
        dmY();
        dnb();
        dmZ();
        dna();
        dmV();
        SwitchManager.getInstance().registerSwitch(m.class);
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
        cwh();
        dmX();
        BdAsyncTask<Void, Void, Void> bdAsyncTask = new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.pb.pb.main.PbActivityStatic.6
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                com.baidu.tbadk.util.am.a(PbPageRequestMessage.WIRE, PbPageResIdl.class);
                return null;
            }
        };
        bdAsyncTask.setSelfExecute(true);
        bdAsyncTask.setPriority(4);
        bdAsyncTask.execute(new Void[0]);
    }

    private static void bRn() {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_PB_PAGE, pbPageSocketResponseMessage.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1001801, com.baidu.tieba.tbadkCore.a.a.bV(Config.PB_ADDRESS, CmdConfigSocket.CMD_PB_PAGE));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(pbPageHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        LocationModel.dOH();
        dnc();
    }

    private static void dmV() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1001601, TbConfig.SERVER_ADDRESS + TbConfig.PB_FLOOR_AGREE_URL);
        tbHttpMessageTask.setResponsedClass(PbFloorAgreeResponseMessage.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void dmW() {
        com.baidu.tieba.tbadkCore.a.a.e(CmdConfigCustom.PB_PAGE_CACHE_CMD, as.class);
    }

    private static void dmX() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003066, TbConfig.SERVER_ADDRESS + TbConfig.URL_APPLY_COPY_THREAD);
        tbHttpMessageTask.setResponsedClass(ApplyCopyThreadResponseMessage.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public static void cCb() {
        com.baidu.tbadk.ala.b.bjS().a(2, new com.baidu.tbadk.ala.e() { // from class: com.baidu.tieba.pb.pb.main.PbActivityStatic.1
            @Override // com.baidu.tbadk.ala.e
            public View createView(Context context) {
                TextView eN = com.baidu.tbadk.ala.c.eN(context);
                if (eN != null) {
                    FloatingLayout.LayoutParams layoutParams = new FloatingLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 16;
                    com.baidu.tbadk.core.util.ap.setViewTextColor(eN, R.color.CAM_X0302);
                    layoutParams.setMargins(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.ds8), com.baidu.adp.lib.util.l.getDimens(context, R.dimen.ds4), 0, 0);
                    eN.setLayoutParams(layoutParams);
                }
                return eN;
            }
        });
        com.baidu.tbadk.ala.b.bjS().a(3, new com.baidu.tbadk.ala.e() { // from class: com.baidu.tieba.pb.pb.main.PbActivityStatic.2
            @Override // com.baidu.tbadk.ala.e
            public View createView(Context context) {
                TextView eN = com.baidu.tbadk.ala.c.eN(context);
                if (eN != null) {
                    com.baidu.tbadk.core.util.ap.setViewTextColor(eN, R.color.CAM_X0302);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.setMargins(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.ds8), com.baidu.adp.lib.util.l.getDimens(context, R.dimen.ds2), 0, 0);
                    layoutParams.gravity = 16;
                    eN.setLayoutParams(layoutParams);
                }
                return eN;
            }
        });
        com.baidu.tbadk.ala.b.bjS().a(4, new com.baidu.tbadk.ala.e() { // from class: com.baidu.tieba.pb.pb.main.PbActivityStatic.3
            @Override // com.baidu.tbadk.ala.e
            public View createView(Context context) {
                TextView eN = com.baidu.tbadk.ala.c.eN(context);
                if (eN != null) {
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    com.baidu.tbadk.core.util.ap.setViewTextColor(eN, R.color.CAM_X0302);
                    layoutParams.setMargins(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.ds8), com.baidu.adp.lib.util.l.getDimens(context, R.dimen.ds2), 0, 0);
                    layoutParams.gravity = 16;
                    eN.setLayoutParams(layoutParams);
                }
                return eN;
            }
        });
        com.baidu.tbadk.ala.b.bjS().a(6, new com.baidu.tbadk.ala.e() { // from class: com.baidu.tieba.pb.pb.main.PbActivityStatic.4
            @Override // com.baidu.tbadk.ala.e
            public View createView(Context context) {
                TextView eN = com.baidu.tbadk.ala.c.eN(context);
                if (eN != null) {
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    com.baidu.tbadk.core.util.ap.setViewTextColor(eN, R.color.CAM_X0302);
                    layoutParams.setMargins(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.ds8), com.baidu.adp.lib.util.l.getDimens(context, R.dimen.ds2), 0, 0);
                    layoutParams.gravity = 16;
                    eN.setLayoutParams(layoutParams);
                }
                return eN;
            }
        });
    }

    private static void dmY() {
        TbadkCoreApplication.getInst().RegisterIntent(SubPbActivityConfig.class, NewSubPbActivity.class);
        com.baidu.tbadk.task.b a2 = com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_SUBPB_FLOOR, SubPbSocketResponseMessage.class, false, false);
        TbHttpMessageTask a3 = com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_SUBPB_FLOOR, 1002100, Config.FLOOR_ADDRESS, SubPbHttpResponseMessage.class, false, false, false, false);
        a2.setParallel(lPP);
        a3.setParallel(lPP);
    }

    private static void dmZ() {
        TbadkCoreApplication.getInst().RegisterIntent(PbSearchEmotionActivityConfig.class, PbSearchEmotionActivity.class);
    }

    private static void dna() {
        TbadkCoreApplication.getInst().RegisterIntent(PbFullScreenEditorActivityConfig.class, PbFullScreenEditorActivity.class);
    }

    private static void dnb() {
        TbadkCoreApplication.getInst().RegisterIntent(ForbidActivityConfig.class, ForbidActivity.class);
    }

    private static void cwh() {
        bf.bsY().a(new bf.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivityStatic.7
            Pattern iZO = Pattern.compile("http[s]?://tieba.baidu.com/p/([\\d]+)");

            /* JADX WARN: Code restructure failed: missing block: B:140:0x034d, code lost:
                if (android.text.TextUtils.isEmpty(r1) == false) goto L161;
             */
            /* JADX WARN: Code restructure failed: missing block: B:85:0x024a, code lost:
                if (com.baidu.adp.lib.util.StringUtils.isNull(r1) == false) goto L94;
             */
            @Override // com.baidu.tbadk.core.util.bf.a
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
                String str;
                String matchStringFromURL;
                String str2;
                PbActivityConfig createNormalCfg;
                String str3;
                if (strArr == null || strArr.length == 0 || strArr[0] == null) {
                    return 3;
                }
                boolean z = strArr.length > 1 && !StringUtils.isNull(strArr[1]) && strArr[1].toLowerCase().contains("n/video/opersquare");
                boolean z2 = false;
                boolean z3 = false;
                String lowerCase = strArr[0].toLowerCase();
                String str4 = null;
                String str5 = null;
                Matcher matcher = this.iZO.matcher(lowerCase);
                String str6 = "push";
                boolean z4 = false;
                if (Pattern.compile("http[s]?://tieba\\.baidu\\.com/p/([\\d]+)\\?pid=([\\d]+)&tid=([\\d]+)&threadtype=([\\d]+)&jump_type=(.*)&jump_tieba_native=1").matcher(lowerCase).find() || lowerCase.contains("isbaijiahao=1")) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SEARCH_JUMP_PB, new com.baidu.tbadk.data.i(tbPageContext, lowerCase)));
                    return 0;
                } else if (lowerCase.contains("unidispatch/pb")) {
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(tbPageContext.getPageActivity());
                    pbActivityConfig.setUri(Uri.parse(lowerCase));
                    if (lowerCase != null && lowerCase.contains("&from_yunpush=1")) {
                        pbActivityConfig.setStartFrom(7);
                    }
                    tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
                    return 0;
                } else {
                    if (lowerCase.contains("tieba.baidu.com/subp")) {
                        String paramStr = bf.getParamStr(lowerCase);
                        if (!TextUtils.isEmpty(paramStr)) {
                            Map<String, String> paramPair = bf.getParamPair(paramStr);
                            if (!paramPair.isEmpty()) {
                                String str7 = paramPair.get("tid");
                                String str8 = paramPair.get("pid");
                                if (!TextUtils.isEmpty(str7) && !TextUtils.isEmpty(str8)) {
                                    SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(tbPageContext.getPageActivity()).createSubPbActivityConfig(str7, str8, "", true);
                                    createSubPbActivityConfig.setIsFromeSchema(true);
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createSubPbActivityConfig));
                                    return 0;
                                }
                            }
                        }
                    }
                    if (lowerCase.contains("bookcover:")) {
                        Map<String, String> paramPair2 = bf.getParamPair(lowerCase.substring("bookcover:".length()));
                        if (paramPair2 == null || paramPair2.size() <= 0) {
                            return 0;
                        }
                        if (com.baidu.adp.lib.f.b.toInt(paramPair2.get("book_type"), 1) == 3) {
                            if (!TbadkCoreApplication.getInst().appResponseToIntentClass(MangaCoverActivityConfig.class)) {
                                com.baidu.adp.lib.util.l.showToast(tbPageContext.getPageActivity(), R.string.manga_plugin_not_install_tip);
                                return 0;
                            }
                            return 3;
                        } else if (!TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                            com.baidu.adp.lib.util.l.showToast(tbPageContext.getPageActivity(), R.string.book_plugin_not_install_tip);
                            return 0;
                        } else {
                            return 3;
                        }
                    }
                    if (matcher.find()) {
                        matchStringFromURL = matcher.group(1);
                        Uri parse = Uri.parse(lowerCase);
                        String queryParameter = parse.getQueryParameter("pid");
                        String queryParameter2 = parse.getQueryParameter("broadcast_id");
                        if (lowerCase != null) {
                            String[] split = lowerCase.split(ETAG.ITEM_SEPARATOR);
                            String str9 = "push";
                            for (int i = 0; i < split.length; i++) {
                                if (split[i] != null) {
                                    if (split[i].startsWith("thread_type=")) {
                                        split[i].substring("thread_type=".length());
                                    } else if (split[i].startsWith("playstatkey=")) {
                                        str9 = split[i].substring("playstatkey=".length());
                                    }
                                }
                            }
                            z3 = com.baidu.adp.lib.f.b.toBoolean(com.baidu.tbadk.util.al.getMatchStringFromURL(lowerCase, "is_from_push="), false);
                            str6 = str9;
                        }
                        if (lowerCase != null && lowerCase.contains("?")) {
                            String[] split2 = lowerCase.substring(lowerCase.indexOf("?") + 1, lowerCase.length()).split(ETAG.ITEM_SEPARATOR);
                            int length = split2.length;
                            int i2 = 0;
                            while (true) {
                                if (i2 >= length) {
                                    break;
                                }
                                String str10 = split2[i2];
                                if (!str10.startsWith("playstatkey=")) {
                                    i2++;
                                } else {
                                    str6 = str10.substring("playstatkey=".length());
                                    break;
                                }
                            }
                        }
                        if (lowerCase != null) {
                            str3 = com.baidu.tbadk.util.al.getMatchStringFromURL(lowerCase, "sttype=");
                        }
                        str3 = "allthread";
                        z4 = true;
                        str = queryParameter;
                        str5 = queryParameter2;
                        str4 = str3;
                    } else if (lowerCase != null && (lowerCase.startsWith("http://tieba.baidu.com/f?") || lowerCase.startsWith("http://tieba.baidu.com/f?"))) {
                        String str11 = null;
                        if (lowerCase.startsWith("http://tieba.baidu.com/f?")) {
                            str11 = lowerCase.substring("http://tieba.baidu.com/f?".length());
                        } else if (lowerCase.startsWith("http://tieba.baidu.com/f?")) {
                            str11 = lowerCase.substring("http://tieba.baidu.com/f?".length());
                        }
                        if (str11 != null) {
                            String[] split3 = str11.split(ETAG.ITEM_SEPARATOR);
                            int i3 = 0;
                            while (true) {
                                if (i3 >= split3.length) {
                                    str2 = null;
                                    break;
                                } else if (split3[i3] == null || !split3[i3].startsWith("kz=")) {
                                    i3++;
                                } else {
                                    str2 = split3[i3].substring(3);
                                    z4 = true;
                                    break;
                                }
                            }
                            if (!TextUtils.isEmpty(str2) && str2.contains(ETAG.ITEM_SEPARATOR)) {
                                str2 = str2.split(ETAG.ITEM_SEPARATOR)[0];
                            }
                        }
                        str2 = null;
                        str = "";
                        matchStringFromURL = str2;
                        str4 = "allthread";
                    } else if (lowerCase.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                        String substring = lowerCase.substring(3);
                        z4 = true;
                        if (strArr.length > 1) {
                            str = "";
                            matchStringFromURL = substring;
                            str4 = strArr[1];
                        } else {
                            str = "";
                            matchStringFromURL = substring;
                        }
                    } else if (lowerCase.startsWith("com.baidu.tieba://?kz=")) {
                        str = "";
                        matchStringFromURL = lowerCase.substring("com.baidu.tieba://?kz=".length());
                        z2 = true;
                    } else if (lowerCase.contains("jump_tieba_native=1") && lowerCase.contains("kz=")) {
                        str = "";
                        matchStringFromURL = com.baidu.tbadk.util.al.getMatchStringFromURL(lowerCase, "kz=");
                    } else {
                        return 3;
                    }
                    if (!StringUtils.isNull(matchStringFromURL, true) && tbPageContext != null) {
                        if (StringUtils.isNull(str)) {
                            createNormalCfg = new PbActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(matchStringFromURL, null, str4);
                        } else {
                            createNormalCfg = new PbActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(matchStringFromURL, str, str4);
                        }
                        if (lowerCase.contains(BigImgPbActivityConfig.OPEN_COMMON) && "1".equals(com.baidu.tbadk.util.al.getMatchStringFromURL(lowerCase, BigImgPbActivityConfig.OPEN_COMMON))) {
                            createNormalCfg.setUserName(com.baidu.tbadk.util.al.getMatchStringFromURL(lowerCase, BigImgPbActivityConfig.BIG_PB_USER_NAME));
                        }
                        createNormalCfg.setVideo_source(str6);
                        if (z3) {
                            createNormalCfg.setFromPushNotify();
                            createNormalCfg.setStartFrom(7);
                        }
                        if (lowerCase != null && lowerCase.contains("&from_yunpush=1")) {
                            createNormalCfg.setStartFrom(7);
                        }
                        if (!StringUtils.isNull(str5)) {
                            createNormalCfg.setOfficialBarMessageId(str5);
                        }
                        if (lowerCase != null && lowerCase.contains(PbActivityConfig.KEY_PUSH_COLLECT)) {
                            createNormalCfg.setJumpToCommentArea(true);
                        }
                        tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                        if (lowerCase.contains("from=threadcard2") || z) {
                            return 0;
                        }
                        return 0;
                    } else if (z2 && !TextUtils.isEmpty(matchStringFromURL)) {
                        com.baidu.adp.lib.f.f.startService(TbadkCoreApplication.getInst(), ao.aQ(TbadkCoreApplication.getInst(), matchStringFromURL));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c10320").aq("obj_locate", 3).aq("obj_type", 2).aq("obj_name", TbadkCoreApplication.getInst().getStartType()).aq(TiebaInitialize.Params.OBJ_PARAM3, 1));
                        return 1;
                    } else if (z4) {
                        tbPageContext.showToast(R.string.page_not_found);
                        return 1;
                    } else {
                        return 3;
                    }
                }
            }
        });
    }

    private static void dnc() {
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
