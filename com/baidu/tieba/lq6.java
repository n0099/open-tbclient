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
/* loaded from: classes5.dex */
public class lq6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public jq6 a;
    public List<kq6> b;
    public kq6 c;
    public String d;
    public String e;
    public long f;
    public boolean g;

    public lq6() {
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

    public final kq6 a(User user) {
        InterceptResult invokeL;
        NewGodInfo newGodInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, user)) == null) {
            if (user == null) {
                return null;
            }
            kq6 kq6Var = new kq6();
            kq6Var.a = user.level_influence;
            kq6Var.c = b(user);
            boolean z = true;
            if (!kq6Var.g && (newGodInfo = user.new_god_data) != null && newGodInfo.status.intValue() == 3) {
                kq6Var.d = user.new_god_data.field_name + pr5.b(user.new_god_data);
                kq6Var.h = true;
            }
            if (user.influence == null) {
                kq6Var.e = "";
            } else {
                kq6Var.e = String.format(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f09a8), StringHelper.numFormatOverWanNa(user.influence.intValue()));
            }
            MetaData metaData = new MetaData();
            metaData.parserProtobuf(user);
            Integer num = user.has_concerned;
            metaData.setIsLike((num == null || num.intValue() == 0) ? false : false);
            kq6Var.f = metaData;
            if (metaData.getAvater() != null && metaData.getAvater().startsWith("http")) {
                kq6Var.b = metaData.getAvater();
            } else {
                kq6Var.b = TbConfig.getPhotoSmallAddress() + metaData.getAvater();
            }
            return kq6Var;
        }
        return (kq6) invokeL.objValue;
    }

    public void c(DataRes dataRes) {
        long longValue;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dataRes) != null) || dataRes == null) {
            return;
        }
        this.a = new jq6();
        boolean z = false;
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
                this.a.e = "http://tb.himg.baidu.com/sys/portraith/item/" + avatarH;
            }
        }
        jq6 jq6Var = this.a;
        Long l = dataRes.timestamp;
        long j = 0;
        if (l == null) {
            longValue = 0;
        } else {
            longValue = l.longValue();
        }
        jq6Var.d = longValue;
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
        if (l2 != null) {
            j = l2.longValue();
        }
        this.f = j;
        Boolean bool = dataRes.has_more;
        if (bool != null) {
            z = bool.booleanValue();
        }
        this.g = z;
    }

    public final String b(User user) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, user)) == null) {
            String str = "";
            if (user == null) {
                return "";
            }
            if (TextUtils.isEmpty("")) {
                str = user.name_show;
            }
            if (TextUtils.isEmpty(str)) {
                return TbadkCoreApplication.getInst().getString(R.string.user_name_default_txt);
            }
            return str;
        }
        return (String) invokeL.objValue;
    }
}
