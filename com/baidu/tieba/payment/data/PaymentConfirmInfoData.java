package com.baidu.tieba.payment.data;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
/* loaded from: classes6.dex */
public class PaymentConfirmInfoData extends OrmObject implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int FALSE = 0;
    public static final int TRUE = 1;
    public static final long serialVersionUID = -5200544926446191689L;
    public transient /* synthetic */ FieldHolder $fh;
    public GoodsInfo goods_info;
    public OrderInfo order_info;
    public String tbs;
    public UserInfo user_info;

    /* loaded from: classes6.dex */
    public static final class OrderInfo extends OrmObject implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -2732450616226807443L;
        public transient /* synthetic */ FieldHolder $fh;
        public Cpath cpath;
        public String from;
        public String open_id;
        public String order_id;
        public int pay_type;
        public long scene_id;
        public long timestamp;

        /* loaded from: classes6.dex */
        public static final class Cpath extends OrmObject implements Serializable {
            public static /* synthetic */ Interceptable $ic = null;
            public static final long serialVersionUID = -7950965099930244673L;
            public transient /* synthetic */ FieldHolder $fh;
            public int gettdou_cashier;
            public Member member;
            public int pay_cashier;
            public int purchase;
            public int tip_days;
            public int tip_exist;

            /* loaded from: classes6.dex */
            public static final class Member extends OrmObject implements Serializable {
                public static /* synthetic */ Interceptable $ic = null;
                public static final long serialVersionUID = 8094155826429200428L;
                public transient /* synthetic */ FieldHolder $fh;
                public String desc;
                public String icon;

                public Member() {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                public String getDesc() {
                    InterceptResult invokeV;
                    Interceptable interceptable = $ic;
                    if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                        return this.desc;
                    }
                    return (String) invokeV.objValue;
                }

                public String getIcon() {
                    InterceptResult invokeV;
                    Interceptable interceptable = $ic;
                    if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        return this.icon;
                    }
                    return (String) invokeV.objValue;
                }

                public void setDesc(String str) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                        this.desc = str;
                    }
                }

                public void setIcon(String str) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                        this.icon = str;
                    }
                }
            }

            public Cpath() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            public int getGettdou_cashier() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    return this.gettdou_cashier;
                }
                return invokeV.intValue;
            }

            public Member getMember() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                    return this.member;
                }
                return (Member) invokeV.objValue;
            }

            public int getPay_cashier() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                    return this.pay_cashier;
                }
                return invokeV.intValue;
            }

            public int getPurchase() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                    return this.purchase;
                }
                return invokeV.intValue;
            }

            public int getTip_days() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                    return this.tip_days;
                }
                return invokeV.intValue;
            }

            public int getTip_exist() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                    return this.tip_exist;
                }
                return invokeV.intValue;
            }

            public void setGettdou_cashier(int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
                    this.gettdou_cashier = i;
                }
            }

            public void setMember(Member member) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048583, this, member) == null) {
                    this.member = member;
                }
            }

            public void setPay_cashier(int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
                    this.pay_cashier = i;
                }
            }

            public void setPurchase(int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
                    this.purchase = i;
                }
            }

            public void setTip_days(int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
                    this.tip_days = i;
                }
            }

            public void setTip_exist(int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
                    this.tip_exist = i;
                }
            }
        }

        public OrderInfo() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public Cpath getCpath() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.cpath;
            }
            return (Cpath) invokeV.objValue;
        }

        public String getFrom() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.from;
            }
            return (String) invokeV.objValue;
        }

        public String getOpen_id() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.open_id;
            }
            return (String) invokeV.objValue;
        }

        public String getOrder_id() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.order_id;
            }
            return (String) invokeV.objValue;
        }

        public int getPay_type() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.pay_type;
            }
            return invokeV.intValue;
        }

        public long getScene_id() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return this.scene_id;
            }
            return invokeV.longValue;
        }

        public long getTimestamp() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return this.timestamp;
            }
            return invokeV.longValue;
        }

        public void setCpath(Cpath cpath) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, cpath) == null) {
                this.cpath = cpath;
            }
        }

        public void setFrom(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
                this.from = str;
            }
        }

        public void setOpen_id(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
                this.open_id = str;
            }
        }

        public void setOrder_id(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
                this.order_id = str;
            }
        }

        public void setPay_type(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
                this.pay_type = i;
            }
        }

        public void setScene_id(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048588, this, j) == null) {
                this.scene_id = j;
            }
        }

        public void setTimestamp(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048589, this, j) == null) {
                this.timestamp = j;
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class UserInfo extends OrmObject implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -4710995963160510207L;
        public transient /* synthetic */ FieldHolder $fh;
        public UserScores Parr_scores;
        public String email;
        public String mobile;
        public String portrait;
        public String user_id;
        public String user_name;
        public String user_name_utf8;
        public String user_nickname;

        /* loaded from: classes6.dex */
        public static final class UserScores extends OrmObject implements Serializable {
            public static /* synthetic */ Interceptable $ic = null;
            public static final long serialVersionUID = -667999598567432177L;
            public transient /* synthetic */ FieldHolder $fh;
            public int currency;
            public int level;
            public int limit;
            public int scores_fetch;
            public long scores_money;
            public long scores_other;
            public long scores_total;
            public long update_time;

            public UserScores() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            public int getCurrency() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    return this.currency;
                }
                return invokeV.intValue;
            }

            public int getLevel() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                    return this.level;
                }
                return invokeV.intValue;
            }

            public int getLimit() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                    return this.limit;
                }
                return invokeV.intValue;
            }

            public int getScores_fetch() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                    return this.scores_fetch;
                }
                return invokeV.intValue;
            }

            public long getScores_money() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                    return this.scores_money;
                }
                return invokeV.longValue;
            }

            public long getScores_other() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                    return this.scores_other;
                }
                return invokeV.longValue;
            }

            public long getScores_total() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                    return this.scores_total;
                }
                return invokeV.longValue;
            }

            public long getUpdate_time() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                    return this.update_time;
                }
                return invokeV.longValue;
            }

            public void setCurrency(int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
                    this.currency = i;
                }
            }

            public void setLevel(int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
                    this.level = i;
                }
            }

            public void setLimit(int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
                    this.limit = i;
                }
            }

            public void setScores_fetch(int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
                    this.scores_fetch = i;
                }
            }

            public void setScores_money(long j) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeJ(1048588, this, j) == null) {
                    this.scores_money = j;
                }
            }

            public void setScores_other(long j) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeJ(1048589, this, j) == null) {
                    this.scores_other = j;
                }
            }

            public void setScores_total(long j) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeJ(1048590, this, j) == null) {
                    this.scores_total = j;
                }
            }

            public void setUpdate_time(long j) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeJ(1048591, this, j) == null) {
                    this.update_time = j;
                }
            }
        }

        public UserInfo() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public String getEmail() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.email;
            }
            return (String) invokeV.objValue;
        }

        public String getMobile() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.mobile;
            }
            return (String) invokeV.objValue;
        }

        public UserScores getParr_scores() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.Parr_scores;
            }
            return (UserScores) invokeV.objValue;
        }

        public String getPortrait() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.portrait;
            }
            return (String) invokeV.objValue;
        }

        public String getUser_id() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.user_id;
            }
            return (String) invokeV.objValue;
        }

        public String getUser_name() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return this.user_name;
            }
            return (String) invokeV.objValue;
        }

        public String getUser_name_utf8() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return this.user_name_utf8;
            }
            return (String) invokeV.objValue;
        }

        public String getUser_nickname() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                return this.user_nickname;
            }
            return (String) invokeV.objValue;
        }

        public void setEmail(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
                this.email = str;
            }
        }

        public void setMobile(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
                this.mobile = str;
            }
        }

        public void setParr_scores(UserScores userScores) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, userScores) == null) {
                this.Parr_scores = userScores;
            }
        }

        public void setPortrait(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
                this.portrait = str;
            }
        }

        public void setUser_id(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
                this.user_id = str;
            }
        }

        public void setUser_name(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
                this.user_name = str;
            }
        }

        public void setUser_name_utf8(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
                this.user_name_utf8 = str;
            }
        }

        public void setUser_nickname(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
                this.user_nickname = str;
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class GoodsInfo extends OrmObject implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int NAME_LENGTH_MAX = 7;
        public static final long serialVersionUID = 3616864478965520380L;
        public transient /* synthetic */ FieldHolder $fh;
        public int currency;
        public int goods_duration;
        public String goods_name;
        public int goods_num;
        public String goods_pic;
        public String goods_unit;
        public int goods_user_level;
        public long tdou_num;

        public GoodsInfo() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public int getCurrency() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.currency;
            }
            return invokeV.intValue;
        }

        public int getGoods_duration() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.goods_duration;
            }
            return invokeV.intValue;
        }

        public String getGoods_name() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                String fixedText = UtilHelper.getFixedText(this.goods_name, 7);
                this.goods_name = fixedText;
                return fixedText;
            }
            return (String) invokeV.objValue;
        }

        public int getGoods_num() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.goods_num;
            }
            return invokeV.intValue;
        }

        public String getGoods_pic() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.goods_pic;
            }
            return (String) invokeV.objValue;
        }

        public String getGoods_unit() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return this.goods_unit;
            }
            return (String) invokeV.objValue;
        }

        public int getGoods_user_level() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return this.goods_user_level;
            }
            return invokeV.intValue;
        }

        public long getTdou_num() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                return this.tdou_num;
            }
            return invokeV.longValue;
        }

        public void setCurrency(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
                this.currency = i;
            }
        }

        public void setGoods_duration(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
                this.goods_duration = i;
            }
        }

        public void setGoods_name(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
                this.goods_name = str;
            }
        }

        public void setGoods_num(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
                this.goods_num = i;
            }
        }

        public void setGoods_pic(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
                this.goods_pic = str;
            }
        }

        public void setGoods_unit(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
                this.goods_unit = str;
            }
        }

        public void setGoods_user_level(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
                this.goods_user_level = i;
            }
        }

        public void setTdou_num(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048591, this, j) == null) {
                this.tdou_num = j;
            }
        }
    }

    public PaymentConfirmInfoData() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public GoodsInfo getGoods_info() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.goods_info;
        }
        return (GoodsInfo) invokeV.objValue;
    }

    public OrderInfo getOrder_info() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.order_info;
        }
        return (OrderInfo) invokeV.objValue;
    }

    public String getTbs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.tbs;
        }
        return (String) invokeV.objValue;
    }

    public UserInfo getUser_info() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.user_info;
        }
        return (UserInfo) invokeV.objValue;
    }

    public void setGoods_info(GoodsInfo goodsInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, goodsInfo) == null) {
            this.goods_info = goodsInfo;
        }
    }

    public void setOrder_info(OrderInfo orderInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, orderInfo) == null) {
            this.order_info = orderInfo;
        }
    }

    public void setTbs(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.tbs = str;
        }
    }

    public void setUser_info(UserInfo userInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, userInfo) == null) {
            this.user_info = userInfo;
        }
    }
}
