package com.baidu.tieba.payment.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.core.util.UtilHelper;
import java.io.Serializable;
/* loaded from: classes5.dex */
public class PaymentConfirmInfoData extends OrmObject implements Serializable {
    public static final int FALSE = 0;
    public static final int TRUE = 1;
    public static final long serialVersionUID = -5200544926446191689L;
    public GoodsInfo goods_info;
    public OrderInfo order_info;
    public String tbs;
    public UserInfo user_info;

    /* loaded from: classes5.dex */
    public static final class GoodsInfo extends OrmObject implements Serializable {
        public static final int NAME_LENGTH_MAX = 7;
        public static final long serialVersionUID = 3616864478965520380L;
        public int currency;
        public int goods_duration;
        public String goods_name;
        public int goods_num;
        public String goods_pic;
        public String goods_unit;
        public int goods_user_level;
        public long tdou_num;

        public int getCurrency() {
            return this.currency;
        }

        public int getGoods_duration() {
            return this.goods_duration;
        }

        public String getGoods_name() {
            String fixedText = UtilHelper.getFixedText(this.goods_name, 7);
            this.goods_name = fixedText;
            return fixedText;
        }

        public int getGoods_num() {
            return this.goods_num;
        }

        public String getGoods_pic() {
            return this.goods_pic;
        }

        public String getGoods_unit() {
            return this.goods_unit;
        }

        public int getGoods_user_level() {
            return this.goods_user_level;
        }

        public long getTdou_num() {
            return this.tdou_num;
        }

        public void setCurrency(int i2) {
            this.currency = i2;
        }

        public void setGoods_duration(int i2) {
            this.goods_duration = i2;
        }

        public void setGoods_name(String str) {
            this.goods_name = str;
        }

        public void setGoods_num(int i2) {
            this.goods_num = i2;
        }

        public void setGoods_pic(String str) {
            this.goods_pic = str;
        }

        public void setGoods_unit(String str) {
            this.goods_unit = str;
        }

        public void setGoods_user_level(int i2) {
            this.goods_user_level = i2;
        }

        public void setTdou_num(long j) {
            this.tdou_num = j;
        }
    }

    /* loaded from: classes5.dex */
    public static final class OrderInfo extends OrmObject implements Serializable {
        public static final long serialVersionUID = -2732450616226807443L;
        public Cpath cpath;
        public String from;
        public String open_id;
        public String order_id;
        public int pay_type;
        public long scene_id;
        public long timestamp;

        /* loaded from: classes5.dex */
        public static final class Cpath extends OrmObject implements Serializable {
            public static final long serialVersionUID = -7950965099930244673L;
            public int gettdou_cashier;
            public Member member;
            public int pay_cashier;
            public int purchase;
            public int tip_days;
            public int tip_exist;

            /* loaded from: classes5.dex */
            public static final class Member extends OrmObject implements Serializable {
                public static final long serialVersionUID = 8094155826429200428L;
                public String desc;
                public String icon;

                public String getDesc() {
                    return this.desc;
                }

                public String getIcon() {
                    return this.icon;
                }

                public void setDesc(String str) {
                    this.desc = str;
                }

                public void setIcon(String str) {
                    this.icon = str;
                }
            }

            public int getGettdou_cashier() {
                return this.gettdou_cashier;
            }

            public Member getMember() {
                return this.member;
            }

            public int getPay_cashier() {
                return this.pay_cashier;
            }

            public int getPurchase() {
                return this.purchase;
            }

            public int getTip_days() {
                return this.tip_days;
            }

            public int getTip_exist() {
                return this.tip_exist;
            }

            public void setGettdou_cashier(int i2) {
                this.gettdou_cashier = i2;
            }

            public void setMember(Member member) {
                this.member = member;
            }

            public void setPay_cashier(int i2) {
                this.pay_cashier = i2;
            }

            public void setPurchase(int i2) {
                this.purchase = i2;
            }

            public void setTip_days(int i2) {
                this.tip_days = i2;
            }

            public void setTip_exist(int i2) {
                this.tip_exist = i2;
            }
        }

        public Cpath getCpath() {
            return this.cpath;
        }

        public String getFrom() {
            return this.from;
        }

        public String getOpen_id() {
            return this.open_id;
        }

        public String getOrder_id() {
            return this.order_id;
        }

        public int getPay_type() {
            return this.pay_type;
        }

        public long getScene_id() {
            return this.scene_id;
        }

        public long getTimestamp() {
            return this.timestamp;
        }

        public void setCpath(Cpath cpath) {
            this.cpath = cpath;
        }

        public void setFrom(String str) {
            this.from = str;
        }

        public void setOpen_id(String str) {
            this.open_id = str;
        }

        public void setOrder_id(String str) {
            this.order_id = str;
        }

        public void setPay_type(int i2) {
            this.pay_type = i2;
        }

        public void setScene_id(long j) {
            this.scene_id = j;
        }

        public void setTimestamp(long j) {
            this.timestamp = j;
        }
    }

    /* loaded from: classes5.dex */
    public static final class UserInfo extends OrmObject implements Serializable {
        public static final long serialVersionUID = -4710995963160510207L;
        public UserScores Parr_scores;
        public String email;
        public String mobile;
        public String portrait;
        public String user_id;
        public String user_name;
        public String user_name_utf8;
        public String user_nickname;

        /* loaded from: classes5.dex */
        public static final class UserScores extends OrmObject implements Serializable {
            public static final long serialVersionUID = -667999598567432177L;
            public int currency;
            public int level;
            public int limit;
            public int scores_fetch;
            public long scores_money;
            public long scores_other;
            public long scores_total;
            public long update_time;

            public int getCurrency() {
                return this.currency;
            }

            public int getLevel() {
                return this.level;
            }

            public int getLimit() {
                return this.limit;
            }

            public int getScores_fetch() {
                return this.scores_fetch;
            }

            public long getScores_money() {
                return this.scores_money;
            }

            public long getScores_other() {
                return this.scores_other;
            }

            public long getScores_total() {
                return this.scores_total;
            }

            public long getUpdate_time() {
                return this.update_time;
            }

            public void setCurrency(int i2) {
                this.currency = i2;
            }

            public void setLevel(int i2) {
                this.level = i2;
            }

            public void setLimit(int i2) {
                this.limit = i2;
            }

            public void setScores_fetch(int i2) {
                this.scores_fetch = i2;
            }

            public void setScores_money(long j) {
                this.scores_money = j;
            }

            public void setScores_other(long j) {
                this.scores_other = j;
            }

            public void setScores_total(long j) {
                this.scores_total = j;
            }

            public void setUpdate_time(long j) {
                this.update_time = j;
            }
        }

        public String getEmail() {
            return this.email;
        }

        public String getMobile() {
            return this.mobile;
        }

        public UserScores getParr_scores() {
            return this.Parr_scores;
        }

        public String getPortrait() {
            return this.portrait;
        }

        public String getUser_id() {
            return this.user_id;
        }

        public String getUser_name() {
            return this.user_name;
        }

        public String getUser_name_utf8() {
            return this.user_name_utf8;
        }

        public String getUser_nickname() {
            return this.user_nickname;
        }

        public void setEmail(String str) {
            this.email = str;
        }

        public void setMobile(String str) {
            this.mobile = str;
        }

        public void setParr_scores(UserScores userScores) {
            this.Parr_scores = userScores;
        }

        public void setPortrait(String str) {
            this.portrait = str;
        }

        public void setUser_id(String str) {
            this.user_id = str;
        }

        public void setUser_name(String str) {
            this.user_name = str;
        }

        public void setUser_name_utf8(String str) {
            this.user_name_utf8 = str;
        }

        public void setUser_nickname(String str) {
            this.user_nickname = str;
        }
    }

    public GoodsInfo getGoods_info() {
        return this.goods_info;
    }

    public OrderInfo getOrder_info() {
        return this.order_info;
    }

    public String getTbs() {
        return this.tbs;
    }

    public UserInfo getUser_info() {
        return this.user_info;
    }

    public void setGoods_info(GoodsInfo goodsInfo) {
        this.goods_info = goodsInfo;
    }

    public void setOrder_info(OrderInfo orderInfo) {
        this.order_info = orderInfo;
    }

    public void setTbs(String str) {
        this.tbs = str;
    }

    public void setUser_info(UserInfo userInfo) {
        this.user_info = userInfo;
    }
}
