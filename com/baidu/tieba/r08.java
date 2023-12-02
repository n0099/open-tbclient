package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.mvc.data.IResponseData;
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
/* loaded from: classes8.dex */
public class r08 implements IResponseData {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ItemInfo a;
    public List<AlbumElement> b;
    public ArrayList<pi> c;
    public boolean d;

    @Override // com.baidu.tbadk.mvc.data.IResponseData
    public void initByJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
        }
    }

    @Override // com.baidu.tbadk.mvc.data.IResponseData
    public void initByProtobuf(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, message) == null) {
        }
    }

    public r08() {
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
            j18 j18Var = new j18();
            j18Var.e(dataRes.item_game_code);
            this.c.add(j18Var);
        }
        ItemGameInfo itemGameInfo = dataRes.item_game_info;
        if (itemGameInfo != null) {
            List<ThreadInfo> list = itemGameInfo.hot_videos;
            if (list != null && ListUtils.getCount(list) >= 3) {
                k18 k18Var = new k18();
                k18Var.d(dataRes.item_game_info.hot_videos);
                this.c.add(k18Var);
            }
            RecentUpdate recentUpdate = dataRes.item_game_info.recent_update;
            if (recentUpdate != null && !rd.isEmpty(recentUpdate.log)) {
                l18 l18Var = new l18();
                l18Var.d(dataRes.item_game_info.recent_update);
                this.c.add(l18Var);
            }
        }
        if (!ListUtils.isEmpty(dataRes.thread_list)) {
            h18 h18Var = new h18();
            h18Var.setSupportType(BaseCardInfo.SupportType.TOP);
            this.c.add(h18Var);
            for (ThreadInfo threadInfo : dataRes.thread_list) {
                if (threadInfo != null) {
                    ThreadData threadData = new ThreadData();
                    threadData.parserProtobuf(threadInfo);
                    threadData.parser_title();
                    threadData.setPositionInFrsItemTab(i);
                    i++;
                    threadData.insertItemToTitleOrAbstractText();
                    this.c.add(threadData);
                    h18 h18Var2 = new h18();
                    h18Var2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                    this.c.add(h18Var2);
                }
            }
            h18 h18Var3 = new h18();
            h18Var3.d(this.a.id.intValue());
            h18Var3.setPositionInFrsItemTab(i);
            h18Var3.setSupportType(BaseCardInfo.SupportType.BOTTOM);
            this.c.add(h18Var3);
        }
        i18 i18Var = new i18();
        i18Var.e(dataRes.item_info);
        if (i18Var.d()) {
            this.c.add(i18Var);
        }
        m18 m18Var = new m18();
        m18Var.d(dataRes.recommend_item);
        this.c.add(m18Var);
    }
}
