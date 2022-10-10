package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetInfluenceRank.DataRes;
import tbclient.NewGodInfo;
import tbclient.RankRuler;
import tbclient.User;
/* loaded from: classes6.dex */
public class v96 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public t96 a;
    public List<u96> b;
    public u96 c;
    public String d;
    public String e;
    public long f;
    public boolean g;

    public v96() {
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
        this.b = new ArrayList();
        this.g = true;
    }

    public final u96 a(User user) {
        InterceptResult invokeL;
        NewGodInfo newGodInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, user)) == null) {
            if (user == null) {
                return null;
            }
            u96 u96Var = new u96();
            u96Var.a = user.level_influence;
            u96Var.c = b(user);
            boolean z = true;
            if (!u96Var.g && (newGodInfo = user.new_god_data) != null && newGodInfo.status.intValue() == 3) {
                u96Var.d = user.new_god_data.field_name + oi5.b(user.new_god_data);
                u96Var.h = true;
            }
            if (user.influence == null) {
                u96Var.e = "";
            } else {
                u96Var.e = String.format(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0902), StringHelper.numFormatOverWanNa(user.influence.intValue()));
            }
            MetaData metaData = new MetaData();
            metaData.parserProtobuf(user);
            Integer num = user.has_concerned;
            metaData.setIsLike((num == null || num.intValue() == 0) ? false : false);
            u96Var.f = metaData;
            if (metaData.getAvater() != null && metaData.getAvater().startsWith("http")) {
                u96Var.b = metaData.getAvater();
            } else {
                u96Var.b = TbConfig.getPhotoSmallAddress() + metaData.getAvater();
            }
            return u96Var;
        }
        return (u96) invokeL.objValue;
    }

    public final String b(User user) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, user)) == null) {
            if (user == null) {
                return "";
            }
            String str = TextUtils.isEmpty("") ? user.name_show : "";
            return TextUtils.isEmpty(str) ? TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1512) : str;
        }
        return (String) invokeL.objValue;
    }

    public void c(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dataRes) == null) || dataRes == null) {
            return;
        }
        this.a = new t96();
        if (!ListUtils.isEmpty(dataRes.user_rank) && dataRes.user_rank.get(0) != null) {
            this.a.b = b(dataRes.user_rank.get(0));
            MetaData metaData = new MetaData();
            metaData.parserProtobuf(dataRes.user_rank.get(0));
            this.a.c = metaData;
            String avatarH = metaData.getAvatarH();
            if (TextUtils.isEmpty(avatarH)) {
                avatarH = metaData.getAvater();
            }
            if (avatarH != null && avatarH.startsWith("http")) {
                this.a.e = avatarH;
            } else {
                t96 t96Var = this.a;
                t96Var.e = "http://tb.himg.baidu.com/sys/portraith/item/" + avatarH;
            }
        }
        t96 t96Var2 = this.a;
        Long l = dataRes.timestamp;
        t96Var2.d = l == null ? 0L : l.longValue();
        this.a.f = dataRes.field_info;
        if (!ListUtils.isEmpty(dataRes.user_rank)) {
            for (User user : dataRes.user_rank) {
                if (user != null) {
                    this.b.add(a(user));
                }
            }
        }
        this.c = a(dataRes.current_user);
        RankRuler rankRuler = dataRes.rank_description;
        if (rankRuler != null) {
            this.d = rankRuler.top_link;
            this.e = rankRuler.bottom_link;
        }
        Long l2 = dataRes.timestamp;
        this.f = l2 != null ? l2.longValue() : 0L;
        Boolean bool = dataRes.has_more;
        this.g = bool != null ? bool.booleanValue() : false;
    }
}
