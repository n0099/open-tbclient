package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.frs.game.strategy.data.LabelDataList;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import tbclient.GameForumGuideTab.GameForumSubTab;
import tbclient.ThreadInfo;
/* loaded from: classes5.dex */
public class so6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static List<zo6> a(List<GameForumSubTab> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return null;
            }
            ArrayList arrayList = new ArrayList(list.size());
            for (GameForumSubTab gameForumSubTab : list) {
                zo6 zo6Var = new zo6();
                if (gameForumSubTab != null) {
                    zo6Var.a = gameForumSubTab.id.intValue();
                    zo6Var.b = gameForumSubTab.sub_tab_name;
                    LabelDataList labelDataList = new LabelDataList();
                    labelDataList.parseProtu(gameForumSubTab.sub_label_list);
                    zo6Var.c = labelDataList;
                    arrayList.add(zo6Var);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static List<wn> b(List<ThreadInfo> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return null;
            }
            LinkedList linkedList = new LinkedList();
            for (int i = 0; i < list.size(); i++) {
                qo6 qo6Var = new qo6();
                ThreadData threadData = new ThreadData();
                qo6Var.c(threadData);
                threadData.parserProtobuf(list.get(i));
                threadData.parser_title();
                if (!TextUtils.isEmpty(threadData.getLegoCard())) {
                    ht4 ht4Var = new ht4();
                    ht4Var.h(threadData.getLegoCard());
                    linkedList.add(ht4Var);
                } else {
                    linkedList.add(qo6Var);
                }
            }
            return linkedList;
        }
        return (List) invokeL.objValue;
    }
}
