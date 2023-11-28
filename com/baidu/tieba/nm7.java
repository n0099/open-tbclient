package com.baidu.tieba;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tieba.forum.data.ForumTabItem;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class nm7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a(ForumTabItem tabItem, long j, int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{tabItem, Long.valueOf(j), Integer.valueOf(i)}) == null) {
            Intrinsics.checkNotNullParameter(tabItem, "tabItem");
            StatisticItem statisticItem = new StatisticItem("c13008");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("fid", j);
            int tabId = tabItem.getTabId();
            if (tabId != 1) {
                if (tabId != 49) {
                    if (tabId != 301) {
                        if (tabId != 404) {
                            if (tabId != 1120) {
                                if (tabId != 89) {
                                    if (tabId != 90) {
                                        if (tabId != 503) {
                                            if (tabId != 504) {
                                                i2 = 10;
                                            } else {
                                                i2 = 11;
                                            }
                                        } else {
                                            i2 = 6;
                                        }
                                    } else {
                                        i2 = 9;
                                    }
                                } else {
                                    i2 = 1;
                                }
                            }
                        } else {
                            i2 = 2;
                        }
                    } else {
                        i2 = 7;
                    }
                }
                i2 = 15;
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                i2 = 4;
            } else {
                i2 = 5;
            }
            int tabType = tabItem.getTabType();
            if (tabType != 1) {
                if (tabType != 3) {
                    if (tabType != 100) {
                        if (tabType == 102) {
                            i2 = 17;
                        }
                    } else {
                        i2 = 16;
                    }
                } else {
                    i2 = 13;
                }
            } else {
                i2 = 12;
            }
            statisticItem.param("obj_locate", i);
            statisticItem.param("obj_type", i2);
            statisticItem.eventStat();
        }
    }
}
