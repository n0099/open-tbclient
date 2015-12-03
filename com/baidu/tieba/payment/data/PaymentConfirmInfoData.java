package com.baidu.tieba.payment.data;

import com.baidu.adp.lib.a.b.a.a.i;
import com.baidu.tbadk.core.util.UtilHelper;
import java.io.Serializable;
/* loaded from: classes.dex */
public class PaymentConfirmInfoData extends i implements Serializable {
    public static final int FALSE = 0;
    public static final int TRUE = 1;
    private static final long serialVersionUID = -5200544926446191689L;
    private GoodsInfo goods_info;
    private OrderInfo order_info;
    private String tbs;
    private UserInfo user_info;

    public GoodsInfo getGoods_info() {
        return this.goods_info;
    }

    public void setGoods_info(GoodsInfo goodsInfo) {
        this.goods_info = goodsInfo;
    }

    public OrderInfo getOrder_info() {
        return this.order_info;
    }

    public void setOrder_info(OrderInfo orderInfo) {
        this.order_info = orderInfo;
    }

    public UserInfo getUser_info() {
        return this.user_info;
    }

    public void setUser_info(UserInfo userInfo) {
        this.user_info = userInfo;
    }

    public String getTbs() {
        return this.tbs;
    }

    public void setTbs(String str) {
        this.tbs = str;
    }

    /* loaded from: classes.dex */
    public static final class GoodsInfo extends i implements Serializable {
        private static final long serialVersionUID = 3616864478965520380L;
        private int goods_duration;
        private String goods_name;
        private int goods_num;
        private String goods_pic;
        private String goods_unit;
        private int goods_user_level;
        private long tdou_num;

        public String getGoods_name() {
            this.goods_name = UtilHelper.getFixedText(this.goods_name, 7);
            return this.goods_name;
        }

        public void setGoods_name(String str) {
            this.goods_name = str;
        }

        public String getGoods_pic() {
            return this.goods_pic;
        }

        public void setGoods_pic(String str) {
            this.goods_pic = str;
        }

        public int getGoods_num() {
            return this.goods_num;
        }

        public void setGoods_num(int i) {
            this.goods_num = i;
        }

        public long getTdou_num() {
            return this.tdou_num;
        }

        public void setTdou_num(long j) {
            this.tdou_num = j;
        }

        public String getGoods_unit() {
            return this.goods_unit;
        }

        public void setGoods_unit(String str) {
            this.goods_unit = str;
        }

        public int getGoods_duration() {
            return this.goods_duration;
        }

        public void setGoods_duration(int i) {
            this.goods_duration = i;
        }

        public int getGoods_user_level() {
            return this.goods_user_level;
        }

        public void setGoods_user_level(int i) {
            this.goods_user_level = i;
        }
    }

    /* loaded from: classes.dex */
    public static final class OrderInfo extends i implements Serializable {
        private static final long serialVersionUID = -2732450616226807443L;
        private Cpath cpath;
        private String from;
        private String open_id;
        private String order_id;
        private int pay_type;
        private long scene_id;
        private long timestamp;

        public String getOrder_id() {
            return this.order_id;
        }

        public void setOrder_id(String str) {
            this.order_id = str;
        }

        public String getOpen_id() {
            return this.open_id;
        }

        public void setOpen_id(String str) {
            this.open_id = str;
        }

        public int getPay_type() {
            return this.pay_type;
        }

        public void setPay_type(int i) {
            this.pay_type = i;
        }

        public long getScene_id() {
            return this.scene_id;
        }

        public void setScene_id(long j) {
            this.scene_id = j;
        }

        public long getTimestamp() {
            return this.timestamp;
        }

        public void setTimestamp(long j) {
            this.timestamp = j;
        }

        public String getFrom() {
            return this.from;
        }

        public void setFrom(String str) {
            this.from = str;
        }

        public Cpath getCpath() {
            return this.cpath;
        }

        public void setCpath(Cpath cpath) {
            this.cpath = cpath;
        }

        /* loaded from: classes.dex */
        public static final class Cpath extends i implements Serializable {
            private static final long serialVersionUID = -7950965099930244673L;
            private int gettdou_cashier;
            private Member member;
            private int pay_cashier;
            private int purchase;
            private int tip_days;
            private int tip_exist;

            public int getPurchase() {
                return this.purchase;
            }

            public void setPurchase(int i) {
                this.purchase = i;
            }

            public int getTip_exist() {
                return this.tip_exist;
            }

            public void setTip_exist(int i) {
                this.tip_exist = i;
            }

            public int getTip_days() {
                return this.tip_days;
            }

            public void setTip_days(int i) {
                this.tip_days = i;
            }

            public int getPay_cashier() {
                return this.pay_cashier;
            }

            public void setPay_cashier(int i) {
                this.pay_cashier = i;
            }

            public int getGettdou_cashier() {
                return this.gettdou_cashier;
            }

            public void setGettdou_cashier(int i) {
                this.gettdou_cashier = i;
            }

            public Member getMember() {
                return this.member;
            }

            public void setMember(Member member) {
                this.member = member;
            }

            /* loaded from: classes.dex */
            public static final class Member extends i implements Serializable {
                private static final long serialVersionUID = 8094155826429200428L;
                private String desc;
                private String icon;

                public String getIcon() {
                    return this.icon;
                }

                public void setIcon(String str) {
                    this.icon = str;
                }

                public String getDesc() {
                    return this.desc;
                }

                public void setDesc(String str) {
                    this.desc = str;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class UserInfo extends i implements Serializable {
        private static final long serialVersionUID = -4710995963160510207L;
        private UserScores Parr_scores;
        private String email;
        private String mobile;
        private String portrait;
        private String user_id;
        private String user_name;
        private String user_name_utf8;
        private String user_nickname;

        public String getUser_id() {
            return this.user_id;
        }

        public void setUser_id(String str) {
            this.user_id = str;
        }

        public String getUser_name() {
            return this.user_name;
        }

        public void setUser_name(String str) {
            this.user_name = str;
        }

        public String getUser_nickname() {
            return this.user_nickname;
        }

        public void setUser_nickname(String str) {
            this.user_nickname = str;
        }

        public String getUser_name_utf8() {
            return this.user_name_utf8;
        }

        public void setUser_name_utf8(String str) {
            this.user_name_utf8 = str;
        }

        public String getPortrait() {
            return this.portrait;
        }

        public void setPortrait(String str) {
            this.portrait = str;
        }

        public String getMobile() {
            return this.mobile;
        }

        public void setMobile(String str) {
            this.mobile = str;
        }

        public String getEmail() {
            return this.email;
        }

        public void setEmail(String str) {
            this.email = str;
        }

        public UserScores getParr_scores() {
            return this.Parr_scores;
        }

        public void setParr_scores(UserScores userScores) {
            this.Parr_scores = userScores;
        }

        /* loaded from: classes.dex */
        public static final class UserScores extends i implements Serializable {
            private static final long serialVersionUID = -667999598567432177L;
            private int level;
            private int limit;
            private int scores_fetch;
            private long scores_money;
            private long scores_other;
            private long scores_total;
            private long update_time;

            public long getScores_total() {
                return this.scores_total;
            }

            public void setScores_total(long j) {
                this.scores_total = j;
            }

            public int getScores_fetch() {
                return this.scores_fetch;
            }

            public void setScores_fetch(int i) {
                this.scores_fetch = i;
            }

            public long getScores_money() {
                return this.scores_money;
            }

            public void setScores_money(long j) {
                this.scores_money = j;
            }

            public long getScores_other() {
                return this.scores_other;
            }

            public void setScores_other(long j) {
                this.scores_other = j;
            }

            public long getUpdate_time() {
                return this.update_time;
            }

            public void setUpdate_time(long j) {
                this.update_time = j;
            }

            public int getLevel() {
                return this.level;
            }

            public void setLevel(int i) {
                this.level = i;
            }

            public int getLimit() {
                return this.limit;
            }

            public void setLimit(int i) {
                this.limit = i;
            }
        }
    }
}
