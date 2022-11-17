package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.abtest.group.AbsGroupUbsABTest;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Message;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;
import tbclient.AdMixFloor;
import tbclient.App;
import tbclient.GeneralTabList.DataRes;
import tbclient.ItemInfo;
import tbclient.SportPageHeadInfo;
import tbclient.SportScheduleInfo;
import tbclient.ThreadInfo;
import tbclient.User;
/* loaded from: classes4.dex */
public class lm6 implements cd5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public HashMap<String, MetaData> b;
    public ArrayList<xn> c;
    public int d;
    public String e;
    public String f;
    public boolean g;
    public SportScheduleInfo h;
    public int i;
    public ItemInfo j;
    public List<App> k;
    public int l;
    public List<AdMixFloor> m;

    @Override // com.baidu.tieba.cd5
    public void initByJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
        }
    }

    @Override // com.baidu.tieba.cd5
    public void initByProtobuf(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, message) == null) {
        }
    }

    public lm6() {
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
        this.b = new HashMap<>();
        this.c = new ArrayList<>();
        this.i = 1;
    }

    public void a(DataRes dataRes) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, dataRes) != null) || dataRes == null) {
            return;
        }
        boolean z2 = false;
        if (dataRes.has_more.intValue() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.a = z;
        if (!ListUtils.isEmpty(dataRes.user_list)) {
            for (User user : dataRes.user_list) {
                if (user != null) {
                    MetaData metaData = new MetaData();
                    metaData.parserProtobuf(user);
                    String userId = metaData.getUserId();
                    if (userId != null && !"0".equals(userId)) {
                        this.b.put(userId, metaData);
                    }
                }
            }
        }
        if (!ListUtils.isEmpty(dataRes.general_list)) {
            for (ThreadInfo threadInfo : dataRes.general_list) {
                if (threadInfo != null) {
                    ThreadData threadData = new ThreadData();
                    threadData.setUserMap(this.b);
                    threadData.forceReadUserMap = true;
                    threadData.parserProtobuf(threadInfo);
                    threadData.parser_title();
                    threadData.insertItemToTitleOrAbstractText();
                    threadData.setFromFrsTab(true);
                    this.c.add(threadData);
                }
            }
        }
        this.l = dataRes.ad_show_select.intValue();
        this.m = dataRes.ad_mix_list;
        String str = dataRes.ad_sample_map_key;
        this.k = dataRes.app_list;
        AbsGroupUbsABTest.setCardInfoUbsABTest(this.c);
        this.d = dataRes.new_thread_num.intValue();
        SportPageHeadInfo sportPageHeadInfo = dataRes.sport_head_info;
        if (sportPageHeadInfo != null) {
            this.e = sportPageHeadInfo.head_url;
            this.f = sportPageHeadInfo.jump_url;
            if (sportPageHeadInfo.is_ad.intValue() == 1) {
                z2 = true;
            }
            this.g = z2;
        }
        this.h = dataRes.sport_schedule_info;
        this.i = dataRes.sort_type.intValue();
        this.j = dataRes.item_info;
    }
}
