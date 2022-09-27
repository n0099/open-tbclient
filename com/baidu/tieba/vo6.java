package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Message;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
import tbclient.AlbumElement;
import tbclient.ItemGameCode;
import tbclient.ItemGameInfo;
import tbclient.ItemInfo;
import tbclient.ItemPage.DataRes;
import tbclient.RecentUpdate;
import tbclient.ThreadInfo;
/* loaded from: classes6.dex */
public class vo6 implements tb5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ItemInfo a;
    public List<AlbumElement> b;
    public ArrayList<Cdo> c;
    public boolean d;

    public vo6() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = new ArrayList<>();
    }

    public void a(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, dataRes) == null) || dataRes == null) {
            return;
        }
        ItemInfo itemInfo = dataRes.item_info;
        this.a = itemInfo;
        if (itemInfo == null) {
            return;
        }
        this.b = dataRes.album_list;
        int i = 1;
        this.d = dataRes.has_tornado.intValue() == 1;
        ItemGameCode itemGameCode = dataRes.item_game_code;
        if (itemGameCode != null && ListUtils.getCount(itemGameCode.game_code_list) != 0) {
            np6 np6Var = new np6();
            np6Var.h(dataRes.item_game_code);
            this.c.add(np6Var);
        }
        ItemGameInfo itemGameInfo = dataRes.item_game_info;
        if (itemGameInfo != null) {
            List<ThreadInfo> list = itemGameInfo.hot_videos;
            if (list != null && ListUtils.getCount(list) >= 3) {
                op6 op6Var = new op6();
                op6Var.f(dataRes.item_game_info.hot_videos);
                this.c.add(op6Var);
            }
            RecentUpdate recentUpdate = dataRes.item_game_info.recent_update;
            if (recentUpdate != null && !dj.isEmpty(recentUpdate.log)) {
                pp6 pp6Var = new pp6();
                pp6Var.f(dataRes.item_game_info.recent_update);
                this.c.add(pp6Var);
            }
        }
        if (!ListUtils.isEmpty(dataRes.thread_list)) {
            lp6 lp6Var = new lp6();
            lp6Var.setSupportType(BaseCardInfo.SupportType.TOP);
            this.c.add(lp6Var);
            for (ThreadInfo threadInfo : dataRes.thread_list) {
                if (threadInfo != null) {
                    ThreadData threadData = new ThreadData();
                    threadData.parserProtobuf(threadInfo);
                    threadData.parser_title();
                    threadData.setPositionInFrsItemTab(i);
                    i++;
                    threadData.insertItemToTitleOrAbstractText();
                    this.c.add(threadData);
                    lp6 lp6Var2 = new lp6();
                    lp6Var2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                    this.c.add(lp6Var2);
                }
            }
            lp6 lp6Var3 = new lp6();
            lp6Var3.f(this.a.id.intValue());
            lp6Var3.setPositionInFrsItemTab(i);
            lp6Var3.setSupportType(BaseCardInfo.SupportType.BOTTOM);
            this.c.add(lp6Var3);
        }
        mp6 mp6Var = new mp6();
        mp6Var.h(dataRes.item_info);
        if (mp6Var.f()) {
            this.c.add(mp6Var);
        }
        qp6 qp6Var = new qp6();
        qp6Var.f(dataRes.recommend_item);
        this.c.add(qp6Var);
    }

    @Override // com.baidu.tieba.tb5
    public void initByJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
        }
    }

    @Override // com.baidu.tieba.tb5
    public void initByProtobuf(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, message) == null) {
        }
    }
}
