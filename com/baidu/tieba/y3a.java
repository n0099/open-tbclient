package com.baidu.tieba;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BdToken.BdUniDispatchSchemeController;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BigImgPbActivityConfig;
import com.baidu.tbadk.core.atomData.BookCoverActivityConfig;
import com.baidu.tbadk.core.atomData.MangaCoverActivityConfig;
import com.baidu.tbadk.core.atomData.PaymentConfirmActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.VideoRecommentPlayActivityConfig;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.util.WebviewHelper;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
/* loaded from: classes9.dex */
public final class y3a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final int a(String link, TbPageContext<?> pageContext) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, link, pageContext)) == null) {
            Intrinsics.checkNotNullParameter(link, "link");
            Intrinsics.checkNotNullParameter(pageContext, "pageContext");
            String substring = link.substring(10);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
            Map<String, String> paramPair = UrlManager.getParamPair(substring);
            if (paramPair != null && !paramPair.isEmpty()) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                return 0;
            }
            if (JavaTypesHelper.toInt(paramPair.get(PaymentConfirmActivityConfig.BOOK_TYPE), 1) == 3) {
                if (!TbadkCoreApplication.getInst().appResponseToIntentClass(MangaCoverActivityConfig.class)) {
                    BdUtilHelper.showToast(pageContext.getPageActivity(), (int) R.string.manga_plugin_not_install_tip);
                    return 0;
                }
            } else if (!TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                BdUtilHelper.showToast(pageContext.getPageActivity(), (int) R.string.book_plugin_not_install_tip);
                return 0;
            }
            return 3;
        }
        return invokeLL.intValue;
    }

    public static final int b(boolean z, boolean z2, String str, TbPageContext<?> pageContext, String str2, String str3, String str4, String videoSource, boolean z3, String str5, String fromPraiseType, boolean z4) {
        InterceptResult invokeCommon;
        VideoRecommentPlayActivityConfig videoRecommentPlayActivityConfig;
        PbActivityConfig createNormalCfg;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str, pageContext, str2, str3, str4, videoSource, Boolean.valueOf(z3), str5, fromPraiseType, Boolean.valueOf(z4)})) == null) {
            Intrinsics.checkNotNullParameter(pageContext, "pageContext");
            Intrinsics.checkNotNullParameter(videoSource, "videoSource");
            Intrinsics.checkNotNullParameter(fromPraiseType, "fromPraiseType");
            if (!z && !z2) {
                if (StringUtils.isNull(str3)) {
                    createNormalCfg = new PbActivityConfig(pageContext.getPageActivity()).createNormalCfg(str, null, str4);
                    Intrinsics.checkNotNullExpressionValue(createNormalCfg, "{\n            PbActivity…, null, stType)\n        }");
                } else {
                    createNormalCfg = new PbActivityConfig(pageContext.getPageActivity()).createNormalCfg(str, str3, str4);
                    Intrinsics.checkNotNullExpressionValue(createNormalCfg, "{\n            PbActivity…, mPid, stType)\n        }");
                }
                if (str2 != null && !TextUtils.isEmpty(str2) && StringsKt__StringsKt.contains$default((CharSequence) str2, (CharSequence) BigImgPbActivityConfig.OPEN_COMMON, false, 2, (Object) null) && Intrinsics.areEqual("1", WebviewHelper.getMatchStringFromURL(str2, BigImgPbActivityConfig.OPEN_COMMON))) {
                    createNormalCfg.setUserName(WebviewHelper.getMatchStringFromURL(str2, BigImgPbActivityConfig.BIG_PB_USER_NAME));
                }
                createNormalCfg.setVideo_source(videoSource);
                createNormalCfg.setStartFrom(25);
                if (z3) {
                    createNormalCfg.setFromPushNotify();
                    createNormalCfg.setStartFrom(7);
                }
                if (str2 != null && StringsKt__StringsKt.contains$default((CharSequence) str2, (CharSequence) UrlSchemaHelper.FROM_YUN_PUSH, false, 2, (Object) null)) {
                    createNormalCfg.setStartFrom(7);
                }
                if (str2 != null && (StringsKt__StringsKt.contains$default((CharSequence) str2, (CharSequence) UrlSchemaHelper.FROM_YUN_PUSH, false, 2, (Object) null) || StringsKt__StringsKt.contains$default((CharSequence) str2, (CharSequence) UrlSchemaHelper.FROM_YUN_PUSH_TWO, false, 2, (Object) null))) {
                    createNormalCfg.setStartFrom(7);
                }
                if (!StringUtils.isNull(str5)) {
                    createNormalCfg.setOfficialBarMessageId(str5);
                }
                if (str2 != null && StringsKt__StringsKt.contains$default((CharSequence) str2, (CharSequence) "fr=collect", false, 2, (Object) null)) {
                    createNormalCfg.setJumpToCommentArea(true);
                }
                pageContext.sendMessage(new CustomMessage(2004001, createNormalCfg));
                if (str2 == null || TextUtils.isEmpty(str2) || StringsKt__StringsKt.contains$default((CharSequence) str2, (CharSequence) fromPraiseType, false, 2, (Object) null) || z4) {
                    return 0;
                }
            } else {
                ArrayList arrayList = new ArrayList();
                VideoItemData videoItemData = new VideoItemData();
                videoItemData.thread_id = str;
                arrayList.add(videoItemData);
                if (z) {
                    videoRecommentPlayActivityConfig = new VideoRecommentPlayActivityConfig(pageContext.getPageActivity(), arrayList, null, VideoRecommentPlayActivityConfig.FROM_LINK_PAGE);
                } else {
                    videoRecommentPlayActivityConfig = new VideoRecommentPlayActivityConfig(pageContext.getPageActivity(), arrayList, null, VideoRecommentPlayActivityConfig.FROM_OFFICAL_VIDEO);
                }
                if (str2 != null && (StringsKt__StringsKt.contains$default((CharSequence) str2, (CharSequence) UrlSchemaHelper.FROM_YUN_PUSH, false, 2, (Object) null) || StringsKt__StringsKt.contains$default((CharSequence) str2, (CharSequence) UrlSchemaHelper.FROM_YUN_PUSH_TWO, false, 2, (Object) null))) {
                    videoRecommentPlayActivityConfig.setStartFrom(7);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, videoRecommentPlayActivityConfig));
            }
            return 0;
        }
        return invokeCommon.intValue;
    }

    public static final int c(String link, String id) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, link, id)) == null) {
            Intrinsics.checkNotNullParameter(link, "link");
            Intrinsics.checkNotNullParameter(id, "id");
            xb.c(TbadkCoreApplication.getInst(), m1a.j(TbadkCoreApplication.getInst(), id));
            StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_SCHEME_JUMP_CALL_NATIVE).param("obj_locate", 3).param("obj_type", 2).param("obj_name", TbadkCoreApplication.getInst().getStartType()).param(TiebaStatic.Params.OBJ_PARAM3, 1);
            fp4.a(param, link);
            TiebaStatic.log(param);
            return 1;
        }
        return invokeLL.intValue;
    }

    public static final int d(TbPageContext<?> pageContext, String link) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, pageContext, link)) == null) {
            Intrinsics.checkNotNullParameter(pageContext, "pageContext");
            Intrinsics.checkNotNullParameter(link, "link");
            Uri parse = Uri.parse(link);
            if (parse != null) {
                String queryParameter = parse.getQueryParameter(BdUniDispatchSchemeController.PARAM_SOURCE);
                if (!StringUtils.isNull(queryParameter)) {
                    TbSingleton.getInstance().setFromWhichSearchSource(queryParameter);
                }
            }
            if (parse != null) {
                String queryParameter2 = parse.getQueryParameter("obj_param1");
                if (!Intrinsics.areEqual(BdUniDispatchSchemeController.PARAM_VIDEO, queryParameter2) && !Intrinsics.areEqual("2", queryParameter2)) {
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(pageContext.getPageActivity());
                    pbActivityConfig.setUri(Uri.parse(link));
                    String queryParameter3 = parse.getQueryParameter("comment_sort_type");
                    String queryParameter4 = parse.getQueryParameter("is_anchor_to_comment");
                    String queryParameter5 = parse.getQueryParameter("hightlight_anchor_pid");
                    String queryParameter6 = parse.getQueryParameter("pageStartFrom");
                    if (TextUtils.isEmpty(queryParameter6)) {
                        queryParameter6 = parse.getQueryParameter("pagestartfrom");
                    }
                    String queryParameter7 = parse.getQueryParameter("novelchannel");
                    if (!TextUtils.isEmpty(queryParameter3) && queryParameter3 != null) {
                        switch (queryParameter3.hashCode()) {
                            case 48:
                                if (queryParameter3.equals("0")) {
                                    pbActivityConfig.setSortType(0);
                                    break;
                                }
                                break;
                            case 49:
                                if (queryParameter3.equals("1")) {
                                    pbActivityConfig.setSortType(1);
                                    break;
                                }
                                break;
                            case 50:
                                if (queryParameter3.equals("2")) {
                                    pbActivityConfig.setSortType(2);
                                    break;
                                }
                                break;
                        }
                    }
                    if (!TextUtils.isEmpty(queryParameter4)) {
                        if (Intrinsics.areEqual(queryParameter4, "0")) {
                            pbActivityConfig.setJumpToCommentArea(false);
                        } else if (Intrinsics.areEqual(queryParameter4, "1")) {
                            pbActivityConfig.setJumpToCommentArea(true);
                        }
                        if (!TextUtils.isEmpty(queryParameter5)) {
                            pbActivityConfig.setHighLightPostId(queryParameter5);
                        }
                    }
                    if (StringsKt__StringsKt.contains$default((CharSequence) link, (CharSequence) UrlSchemaHelper.FROM_YUN_PUSH, false, 2, (Object) null)) {
                        pbActivityConfig.setStartFrom(7);
                    }
                    if (!TextUtils.isEmpty(queryParameter6)) {
                        pbActivityConfig.setStartFrom(JavaTypesHelper.toInt(queryParameter6, 0));
                    }
                    if (!TextUtils.isEmpty(queryParameter7)) {
                        pbActivityConfig.setChannelId(queryParameter7);
                    }
                    pageContext.sendMessage(new CustomMessage(2004001, pbActivityConfig));
                } else {
                    String queryParameter8 = parse.getQueryParameter("tid");
                    ArrayList arrayList = new ArrayList();
                    VideoItemData videoItemData = new VideoItemData();
                    videoItemData.thread_id = queryParameter8;
                    arrayList.add(videoItemData);
                    new VideoRecommentPlayActivityConfig(pageContext.getPageActivity(), arrayList, null, VideoRecommentPlayActivityConfig.FROM_PB_VIDEO_SCHEME).setUri(parse).start();
                }
            }
            return 0;
        }
        return invokeLL.intValue;
    }
}
