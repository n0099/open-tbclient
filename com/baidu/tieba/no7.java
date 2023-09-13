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
/* loaded from: classes7.dex */
public class no7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static List<uo7> a(List<GameForumSubTab> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return null;
            }
            ArrayList arrayList = new ArrayList(list.size());
            for (GameForumSubTab gameForumSubTab : list) {
                uo7 uo7Var = new uo7();
                if (gameForumSubTab != null) {
                    uo7Var.a = gameForumSubTab.id.intValue();
                    uo7Var.b = gameForumSubTab.sub_tab_name;
                    LabelDataList labelDataList = new LabelDataList();
                    labelDataList.parseProtu(gameForumSubTab.sub_label_list);
                    uo7Var.c = labelDataList;
                    arrayList.add(uo7Var);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static List<cn> b(List<ThreadInfo> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return null;
            }
            LinkedList linkedList = new LinkedList();
            for (int i = 0; i < list.size(); i++) {
                lo7 lo7Var = new lo7();
                ThreadData threadData = new ThreadData();
                lo7Var.c(threadData);
                threadData.parserProtobuf(list.get(i));
                threadData.parser_title();
                if (!TextUtils.isEmpty(threadData.getLegoCard())) {
                    u25 u25Var = new u25();
                    u25Var.e(threadData.getLegoCard());
                    linkedList.add(u25Var);
                } else {
                    linkedList.add(lo7Var);
                }
            }
            return linkedList;
        }
        return (List) invokeL.objValue;
    }
}
