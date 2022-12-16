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
public class tr6 implements ud5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ItemInfo a;
    public List<AlbumElement> b;
    public ArrayList<xn> c;
    public boolean d;

    @Override // com.baidu.tieba.ud5
    public void initByJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
        }
    }

    @Override // com.baidu.tieba.ud5
    public void initByProtobuf(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, message) == null) {
        }
    }

    public tr6() {
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
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, dataRes) != null) || dataRes == null) {
            return;
        }
        ItemInfo itemInfo = dataRes.item_info;
        this.a = itemInfo;
        if (itemInfo == null) {
            return;
        }
        this.b = dataRes.album_list;
        int i = 1;
        if (dataRes.has_tornado.intValue() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.d = z;
        ItemGameCode itemGameCode = dataRes.item_game_code;
        if (itemGameCode != null && ListUtils.getCount(itemGameCode.game_code_list) != 0) {
            ls6 ls6Var = new ls6();
            ls6Var.g(dataRes.item_game_code);
            this.c.add(ls6Var);
        }
        ItemGameInfo itemGameInfo = dataRes.item_game_info;
        if (itemGameInfo != null) {
            List<ThreadInfo> list = itemGameInfo.hot_videos;
            if (list != null && ListUtils.getCount(list) >= 3) {
                ms6 ms6Var = new ms6();
                ms6Var.f(dataRes.item_game_info.hot_videos);
                this.c.add(ms6Var);
            }
            RecentUpdate recentUpdate = dataRes.item_game_info.recent_update;
            if (recentUpdate != null && !xi.isEmpty(recentUpdate.log)) {
                ns6 ns6Var = new ns6();
                ns6Var.f(dataRes.item_game_info.recent_update);
                this.c.add(ns6Var);
            }
        }
        if (!ListUtils.isEmpty(dataRes.thread_list)) {
            js6 js6Var = new js6();
            js6Var.setSupportType(BaseCardInfo.SupportType.TOP);
            this.c.add(js6Var);
            for (ThreadInfo threadInfo : dataRes.thread_list) {
                if (threadInfo != null) {
                    ThreadData threadData = new ThreadData();
                    threadData.parserProtobuf(threadInfo);
                    threadData.parser_title();
                    threadData.setPositionInFrsItemTab(i);
                    i++;
                    threadData.insertItemToTitleOrAbstractText();
                    this.c.add(threadData);
                    js6 js6Var2 = new js6();
                    js6Var2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                    this.c.add(js6Var2);
                }
            }
            js6 js6Var3 = new js6();
            js6Var3.f(this.a.id.intValue());
            js6Var3.setPositionInFrsItemTab(i);
            js6Var3.setSupportType(BaseCardInfo.SupportType.BOTTOM);
            this.c.add(js6Var3);
        }
        ks6 ks6Var = new ks6();
        ks6Var.g(dataRes.item_info);
        if (ks6Var.f()) {
            this.c.add(ks6Var);
        }
        os6 os6Var = new os6();
        os6Var.f(dataRes.recommend_item);
        this.c.add(os6Var);
    }
}
