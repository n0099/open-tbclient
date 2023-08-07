package com.baidu.tieba.util;

import android.app.Activity;
import android.content.Context;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.browser.BrowserHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u0006\u001a\"\u0010\u000f\u001a\u00020\u000b2\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0001H\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"KEY_FRS_STATISTIC", "", "LIST_TYPE", "LIST_TYPE_ALL", "PAGE_KEY", "TOPIC_LIST_FRS_CLICK", "", "TOPIC_LIST_FRS_SHOW", "TOPIC_LIST_URL", "TOPIC_LIST_URL_PARAM", "frsStatistic", "", "objType", "fid", "objLocate", "openWebTopicListPage", "pageContext", "Lcom/baidu/tbadk/TbPageContext;", "listType", "tbadkcore_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
@JvmName(name = "TopicListUtil")
/* loaded from: classes8.dex */
public final class TopicListUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_FRS_STATISTIC = "c15112";
    public static final String LIST_TYPE = "&list_type=";
    public static final String LIST_TYPE_ALL = "all";
    public static final String PAGE_KEY = "&page_key=";
    public static final int TOPIC_LIST_FRS_CLICK = 2;
    public static final int TOPIC_LIST_FRS_SHOW = 1;
    public static final String TOPIC_LIST_URL = "https://tieba.baidu.com/mo/q/hybrid/hotTopicRank";
    public static final String TOPIC_LIST_URL_PARAM = "?customfullscreen=1&nonavigationbar=1";
    public transient /* synthetic */ FieldHolder $fh;

    @JvmOverloads
    public static final void openWebTopicListPage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            openWebTopicListPage$default(null, null, 3, null);
        }
    }

    @JvmOverloads
    public static final void openWebTopicListPage(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, tbPageContext) == null) {
            openWebTopicListPage$default(tbPageContext, null, 2, null);
        }
    }

    public static final void frsStatistic(int i, String fid, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{Integer.valueOf(i), fid, Integer.valueOf(i2)}) == null) {
            Intrinsics.checkNotNullParameter(fid, "fid");
            TiebaStatic.log(new StatisticItem(KEY_FRS_STATISTIC).param("obj_type", i).param("fid", fid).param("obj_locate", i2));
        }
    }

    @JvmOverloads
    public static final void openWebTopicListPage(TbPageContext<?> tbPageContext, String listType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, tbPageContext, listType) == null) {
            Intrinsics.checkNotNullParameter(listType, "listType");
            String str = "https://tieba.baidu.com/mo/q/hybrid/hotTopicRank?customfullscreen=1&nonavigationbar=1&list_type=" + listType;
            if (Intrinsics.areEqual("all", listType)) {
                str = str + "&page_key=a078";
            }
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            if (currentActivity != null) {
                BrowserHelper.startWebActivity((Context) currentActivity, (String) null, str, true);
            } else if (tbPageContext != null) {
                BrowserHelper.startWebActivity((Context) tbPageContext.getPageActivity(), (String) null, str, true);
            }
        }
    }

    public static /* synthetic */ void openWebTopicListPage$default(TbPageContext tbPageContext, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            tbPageContext = null;
        }
        if ((i & 2) != 0) {
            str = "all";
        }
        openWebTopicListPage(tbPageContext, str);
    }
}
