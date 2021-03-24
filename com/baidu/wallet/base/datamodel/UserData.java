package com.baidu.wallet.base.datamodel;

import android.text.TextUtils;
import com.baidu.apollon.armor.SafePay;
import com.baidu.wallet.core.NoProguard;
import java.io.Serializable;
import java.math.BigDecimal;
/* loaded from: classes5.dex */
public class UserData implements NoProguard {

    /* loaded from: classes5.dex */
    public static class FingerprintAuthInfo implements NoProguard, Serializable {
        public String uafRequest;
    }

    /* loaded from: classes5.dex */
    public static class Misc implements NoProguard, Serializable {
        public static final long serialVersionUID = 993460856554011232L;
        public ConfirmButtonMsg msg_pay_btn;
        public String no_mobilepwd_msg;
        public String nopass_msg;
        public String title_url;
        public String trans_need_to_pay;

        /* loaded from: classes5.dex */
        public static class ConfirmButtonMsg implements NoProguard, Serializable {
            public String default_msg;
            public String new_card;
            public String nopass;
            public String transfer2card;

            public String getDefault_msg() {
                return this.default_msg;
            }

            public String getNew_card() {
                return this.new_card;
            }

            public String getNopass() {
                return this.nopass;
            }
        }

        public String getInsideTransOrder() {
            return this.trans_need_to_pay;
        }

        public ConfirmButtonMsg getPayButtonMsg() {
            return this.msg_pay_btn;
        }
    }

    /* loaded from: classes5.dex */
    public static class SP implements NoProguard, Serializable {
        public static final long serialVersionUID = 993460856554011232L;
        public String goods_name;
        public String seller_user_id;
        public String serial_num;
        public String session_no;
        public String sp_company;
        public String sp_no;

        public String getSellerUserId() {
            return this.seller_user_id;
        }

        public String toString() {
            return "[sp_company=" + this.sp_company + "]";
        }
    }

    /* loaded from: classes5.dex */
    public static class UserModel implements NoProguard, Serializable {
        public static final String STATUS_LOGINED = "1";
        public static final long serialVersionUID = -1273103909085078415L;
        public Account account;
        public int auth_status;
        public String authorize_display_name;
        public int balance_pay_status;
        public String balance_unsupport_reason;
        public String can_use_pcpwd_verify;
        public String certificate_code;
        public String certificate_code_ec;
        public String certificate_type;
        public DisplayFlag display_flag;
        public String display_name;
        public String enable_fingerprint;
        public FingerprintAuthInfo fingerprint_auth_info;
        public FingerprintMsg fingerprint_msg;
        public String guide_to_open_fingerprint;
        public int is_authed;
        public String is_login;
        public int is_repaired;
        public String last3_paytype;
        public String login_name;
        public String mobile_ec;
        public String mobile_number;
        public String passfree_msg;
        public PassFreeProtocol passfree_protocol;
        public int pwd_left_count;
        public Score score;
        public int stark_account_level;
        public String stark_auth_msg;
        public String stark_balance_msg;
        public String true_name;
        public String user_id;
        public int has_mobile_password = 0;
        public String balance_support_status = "1";
        public String need_pay_password = "1";
        public String passfree_selected = "1";

        /* loaded from: classes5.dex */
        public static class Account implements Serializable {
            public static final long serialVersionUID = 2427773423716342178L;
            public String available_withdraw_amount;
            public String balance_amount;
            public String can_amount;
            public String can_amount3;
            public String freeze_amount;
            public String recv_amount;
            public String recv_create_time;
            public String recv_info;
            public String return_cash_content = "";
            public String return_cash_url = "";
            public String virtual_amount;

            public String getCanAmount() {
                return !TextUtils.isEmpty(this.can_amount) ? this.can_amount : "0";
            }

            public boolean hasCanAmount() {
                if (TextUtils.isEmpty(this.can_amount)) {
                    return false;
                }
                try {
                    return new BigDecimal(this.can_amount).compareTo(BigDecimal.ZERO) > 0;
                } catch (Exception unused) {
                    return false;
                }
            }

            /*  JADX ERROR: NullPointerException in pass: RegionMakerVisitor
                java.lang.NullPointerException: Cannot read field "wordsInUse" because "set" is null
                	at java.base/java.util.BitSet.or(BitSet.java:943)
                	at jadx.core.utils.BlockUtils.getPathCross(BlockUtils.java:732)
                	at jadx.core.utils.BlockUtils.getPathCross(BlockUtils.java:811)
                	at jadx.core.dex.visitors.regions.IfMakerHelper.restructureIf(IfMakerHelper.java:88)
                	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:706)
                	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:155)
                	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
                	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:730)
                	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:155)
                	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
                	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
                */
            public boolean isBalanceEnough(java.lang.String r4) {
                /*
                    r3 = this;
                    java.lang.String r0 = r3.can_amount
                    boolean r0 = android.text.TextUtils.isEmpty(r0)
                    r1 = 0
                    if (r0 != 0) goto L23
                    boolean r0 = android.text.TextUtils.isEmpty(r4)
                    if (r0 == 0) goto L10
                    goto L23
                L10:
                    java.math.BigDecimal r0 = new java.math.BigDecimal     // Catch: java.lang.Exception -> L23
                    java.lang.String r2 = r3.can_amount     // Catch: java.lang.Exception -> L23
                    r0.<init>(r2)     // Catch: java.lang.Exception -> L23
                    java.math.BigDecimal r2 = new java.math.BigDecimal     // Catch: java.lang.Exception -> L23
                    r2.<init>(r4)     // Catch: java.lang.Exception -> L23
                    int r4 = r0.compareTo(r2)     // Catch: java.lang.Exception -> L23
                    if (r4 < 0) goto L23
                    r1 = 1
                L23:
                    return r1
                */
                throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.base.datamodel.UserData.UserModel.Account.isBalanceEnough(java.lang.String):boolean");
            }

            public String toString() {
                return "钱包余额信息-->[balance_amount:" + this.balance_amount + "&freeze_amount:" + this.freeze_amount + "&virtual_amount:" + this.virtual_amount + "&can_amount:" + this.can_amount + "&available_withdraw_amount:" + this.available_withdraw_amount + "]";
            }
        }

        /* loaded from: classes5.dex */
        public static class DisplayFlag implements Serializable {
            public static final long serialVersionUID = -6111380299465016961L;
            public String true_name = "";
            public String mobile = "";
            public String certificate_code = "";

            public String getCodeFlag() {
                return this.certificate_code;
            }

            public String getMobileFlag() {
                return this.mobile;
            }

            public String getNameFlag() {
                return this.true_name;
            }
        }

        /* loaded from: classes5.dex */
        public static class FingerprintMsg implements NoProguard, Serializable {
            public Open open;
            public Reopen reopen;
            public Update update;

            /* loaded from: classes5.dex */
            public static class Open implements NoProguard, Serializable {
                public FingerprintProtocol fingerprint_protocol;
                public String[] hints;
                public String subtitle;
                public String title;

                /* loaded from: classes5.dex */
                public static class FingerprintProtocol implements NoProguard, Serializable {
                    public String fingerprint_protocol_msg;
                    public String fingerprint_protocol_prefix;
                    public String fingerprint_protocol_url;

                    public String getFingerprintProtocolMsg() {
                        return this.fingerprint_protocol_msg;
                    }

                    public String getFingerprintProtocolPrefix() {
                        return this.fingerprint_protocol_prefix;
                    }

                    public String getFingerprintProtocolUrl() {
                        return this.fingerprint_protocol_url;
                    }
                }

                public FingerprintProtocol getFingerprintProtocol() {
                    return this.fingerprint_protocol;
                }

                public String[] getHints() {
                    return this.hints;
                }

                public String getSubtitle() {
                    return this.subtitle;
                }

                public String getTitle() {
                    return this.title;
                }
            }

            /* loaded from: classes5.dex */
            public static class Reopen implements NoProguard, Serializable {
                public FingerprintProtocol fingerprint_protocol;
                public String subtitle;
                public String title;

                /* loaded from: classes5.dex */
                public static class FingerprintProtocol implements NoProguard, Serializable {
                    public String fingerprint_protocol_msg;
                    public String fingerprint_protocol_prefix;
                    public String fingerprint_protocol_url;

                    public String getFingerprintProtocolMsg() {
                        return this.fingerprint_protocol_msg;
                    }

                    public String getFingerprintProtocolPrefix() {
                        return this.fingerprint_protocol_prefix;
                    }

                    public String getFingerprintProtocolUrl() {
                        return this.fingerprint_protocol_url;
                    }
                }

                public FingerprintProtocol getFingerprintProtocol() {
                    return this.fingerprint_protocol;
                }

                public String getSubtitle() {
                    return this.subtitle;
                }

                public String getTitle() {
                    return this.title;
                }
            }

            /* loaded from: classes5.dex */
            public static class Update implements NoProguard, Serializable {
                public String subtitle;
                public String title;

                public String getSubtitle() {
                    return this.subtitle;
                }

                public String getTitle() {
                    return this.title;
                }
            }

            public Open getOpen() {
                return this.open;
            }

            public Reopen getReopen() {
                return this.reopen;
            }

            public Update getUpdate() {
                return this.update;
            }
        }

        /* loaded from: classes5.dex */
        public static class PassFreeProtocol implements NoProguard, Serializable {
            public String passfree_protocol_msg;
            public String passfree_protocol_prefix;
            public String passfree_protocol_url;

            public String getPassfreeProtocolMsg() {
                return this.passfree_protocol_msg;
            }

            public String getPassfreeProtocolPrefix() {
                return this.passfree_protocol_prefix;
            }

            public String getPassfreeProtocolUrl() {
                return this.passfree_protocol_url;
            }
        }

        /* loaded from: classes5.dex */
        public static class Score implements Serializable {
            public static final long serialVersionUID = 606605370857740501L;
            public String can_cash;
            public String score_num;
            public String score_tip;

            /*  JADX ERROR: NullPointerException in pass: RegionMakerVisitor
                java.lang.NullPointerException: Cannot read field "wordsInUse" because "set" is null
                	at java.base/java.util.BitSet.or(BitSet.java:943)
                	at jadx.core.utils.BlockUtils.getPathCross(BlockUtils.java:732)
                	at jadx.core.utils.BlockUtils.getPathCross(BlockUtils.java:811)
                	at jadx.core.dex.visitors.regions.IfMakerHelper.restructureIf(IfMakerHelper.java:88)
                	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:706)
                	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:155)
                	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
                	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:730)
                	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:155)
                	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
                	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
                */
            public boolean hasScore() {
                /*
                    r3 = this;
                    java.lang.String r0 = r3.score_num
                    boolean r0 = android.text.TextUtils.isEmpty(r0)
                    r1 = 0
                    if (r0 != 0) goto L22
                    java.lang.String r0 = r3.can_cash
                    boolean r0 = android.text.TextUtils.isEmpty(r0)
                    if (r0 == 0) goto L12
                    goto L22
                L12:
                    java.math.BigDecimal r0 = new java.math.BigDecimal     // Catch: java.lang.Exception -> L22
                    java.lang.String r2 = r3.score_num     // Catch: java.lang.Exception -> L22
                    r0.<init>(r2)     // Catch: java.lang.Exception -> L22
                    java.math.BigDecimal r2 = java.math.BigDecimal.ZERO     // Catch: java.lang.Exception -> L22
                    int r0 = r0.compareTo(r2)     // Catch: java.lang.Exception -> L22
                    if (r0 <= 0) goto L22
                    r1 = 1
                L22:
                    return r1
                */
                throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.base.datamodel.UserData.UserModel.Score.hasScore():boolean");
            }
        }

        public void decrypt() {
            try {
                if (!TextUtils.isEmpty(this.certificate_code_ec)) {
                    this.certificate_code = SafePay.unicodeDecode(SafePay.getInstance().localDecryptProxy(this.certificate_code_ec));
                }
                if (TextUtils.isEmpty(this.mobile_ec)) {
                    return;
                }
                this.mobile_number = SafePay.unicodeDecode(SafePay.getInstance().localDecryptProxy(this.mobile_ec));
            } catch (Exception unused) {
            }
        }

        public String getCanAmount() {
            Account account = this.account;
            return account == null ? "0" : account.getCanAmount();
        }

        public FingerprintMsg getFingerprintMsg() {
            return this.fingerprint_msg;
        }

        public String getMoneyUrl() {
            Account account = this.account;
            return account != null ? account.return_cash_url : "";
        }

        public String getPassfreeMsg() {
            return this.passfree_msg;
        }

        public PassFreeProtocol getPassfreeProtocol() {
            return this.passfree_protocol;
        }

        public boolean getPassfreeSelected() {
            return "1".equals(this.passfree_selected);
        }

        public String getRecvInfo() {
            Account account = this.account;
            return account != null ? account.recv_info : "";
        }

        public String getTotalBackContent() {
            Account account = this.account;
            return account != null ? account.return_cash_content : "";
        }

        public boolean hasCanAmount() {
            Account account = this.account;
            if (account == null) {
                return false;
            }
            return account.hasCanAmount();
        }

        public boolean hasMobilePwd() {
            return this.has_mobile_password == 1;
        }

        public boolean isSupportBalance() {
            return "1".equals(this.balance_support_status);
        }

        public void setHasMobilePwd() {
            this.has_mobile_password = 1;
        }
    }
}
