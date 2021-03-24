package com.baidu.wallet.home.datamodel;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.apollon.beans.IBeanResponse;
import com.baidu.wallet.core.NoProguard;
import com.baidu.wallet.home.storage.HomeDataCacheManager;
import java.io.Serializable;
/* loaded from: classes5.dex */
public class HomeCfgResponse implements IBeanResponse {
    public String abtype;
    public String changedSign;
    public AllConfig layout_content;
    public FooterConfig layout_footer;
    public TitleConfig layout_title;
    public String version;
    public String android_prefix = "";
    public String is_login = "0";

    /* loaded from: classes5.dex */
    public static class AllConfig implements NoProguard, Serializable {
        public static final long serialVersionUID = 6644260416559855999L;
        public ConfigData[] data;
        public String fingerprint = "";
    }

    /* loaded from: classes5.dex */
    public static class ConfigData implements NoProguard, Serializable {
        public static final String GROUP_LAYOUR_GAP = "100";
        public static final String GROUP_LAYOUT_TYPE1 = "1";
        public static final String GROUP_LAYOUT_TYPE2 = "2";
        public static final String GROUP_LAYOUT_TYPE201 = "201";
        public static final String GROUP_LAYOUT_TYPE202 = "202";
        public static final String GROUP_LAYOUT_TYPE203 = "203";
        public static final String GROUP_LAYOUT_TYPE204 = "204";
        public static final String GROUP_LAYOUT_TYPE205 = "205";
        public static final String GROUP_LAYOUT_TYPE206 = "206";
        public static final String GROUP_LAYOUT_TYPE207 = "207";
        public static final String GROUP_LAYOUT_TYPE208 = "208";
        public static final String GROUP_LAYOUT_TYPE209 = "209";
        public static final String GROUP_LAYOUT_TYPE210 = "210";
        public static final String GROUP_LAYOUT_TYPE3 = "3";
        public static final String GROUP_LAYOUT_TYPE4 = "4";
        public static final String GROUP_LAYOUT_TYPE5 = "5";
        public static final String GROUP_LAYOUT_TYPE501 = "501";
        public static final String GROUP_LAYOUT_TYPE502 = "502";
        public static final String GROUP_LAYOUT_TYPE503 = "503";
        public static final String GROUP_LAYOUT_TYPE504 = "504";
        public static final String GROUP_LAYOUT_TYPE505 = "505";
        public static final String GROUP_LAYOUT_TYPE506 = "506";
        public static final String GROUP_LAYOUT_TYPE507 = "507";
        public static final String GROUP_LAYOUT_TYPE508 = "508";
        public static final String GROUP_LAYOUT_TYPE509 = "509";
        public static final String GROUP_LAYOUT_TYPE510 = "510";
        public static final String GROUP_LAYOUT_TYPE6 = "6";
        public static final String GROUP_LAYOUT_TYPE601 = "601";
        public static final String GROUP_LAYOUT_TYPE602 = "602";
        public static final String GROUP_LAYOUT_TYPE603 = "603";
        public static final String GROUP_LAYOUT_TYPE604 = "604";
        public static final String GROUP_LAYOUT_TYPE605 = "605";
        public static final String GROUP_LAYOUT_TYPE606 = "606";
        public static final String GROUP_LAYOUT_TYPE7 = "7";
        public static final String GROUP_LAYOUT_TYPE8 = "8";
        public static final String GROUP_LAYOUT_TYPE9 = "9";
        public static final long serialVersionUID = 2256676692121528029L;
        public String group_background;
        public String group_corner_addr;
        public String group_desc;
        public String group_has_background;
        public String group_has_gap;
        public String group_layout;
        public String group_link;
        public String group_logo;
        public String group_name;
        public String group_prevlogin;
        public String group_type;
        public DataItem[] list;
        public Stat stat;

        public String getGroup_desc() {
            return this.group_desc;
        }

        public String getGroup_layout() {
            return this.group_layout;
        }

        public String getGroup_link() {
            return this.group_link;
        }

        public String getGroup_logo() {
            return this.group_logo;
        }

        public String getGroup_name() {
            return this.group_name;
        }

        public boolean getGroup_prevlogin() {
            return "1".equalsIgnoreCase(this.group_prevlogin);
        }

        public String getGroup_type() {
            return this.group_type;
        }

        public boolean isGroupCanClick() {
            if (TextUtils.isEmpty(this.group_link) || TextUtils.isEmpty(this.group_type)) {
                return false;
            }
            return this.group_type.equals("1") || this.group_type.equals("2") || this.group_type.equals("3") || this.group_type.equals("4");
        }

        public boolean isLayoutHasGap() {
            if (TextUtils.isEmpty(this.group_has_gap)) {
                return false;
            }
            return this.group_has_gap.equals("1");
        }
    }

    /* loaded from: classes5.dex */
    public static class DataButton implements NoProguard {
        public String btn_type;
        public String icon;
        public String link_addr;
        public String name;
        public String prevlogin;
        public Stat stat;
        public String type;
    }

    /* loaded from: classes5.dex */
    public static class DataIcon implements NoProguard {
        public String icon_link;
        public String name;
    }

    /* loaded from: classes5.dex */
    public static class DataItem extends WalletBannerItem implements NoProguard {
        public static final long serialVersionUID = -8579386834036716930L;
        public DataButton[] buttons;
        public String corner_addr;
        public String desc;
        public String detail;
        public boolean empty_view = false;
        public String has_credit;
        public DataIcon[] icons;
        public String key;
        public String label;
        public String link_addr;
        public String logo;
        public String name;
        public String notice;
        public String notice_style;
        public String prevlogin;
        public DataRepay repay;
        public Stat stat;
        public String timestamp;
        public String timestamp_icon;
        public String timestamp_value;
        public String type;
        public String unit;
        public String value1;
        public String value2;
        public String value3;

        @Override // com.baidu.wallet.home.datamodel.WalletBannerItem
        public String getCornerAddr() {
            return this.corner_addr;
        }

        @Override // com.baidu.wallet.base.widget.banner.BannerBaseItemInfo
        public String getLinkAddr() {
            return this.link_addr;
        }

        @Override // com.baidu.wallet.base.widget.banner.BannerBaseItemInfo
        public String getName() {
            return this.name;
        }

        @Override // com.baidu.wallet.base.widget.banner.BannerBaseItemInfo
        public String getPicAddr() {
            return this.logo;
        }

        @Override // com.baidu.wallet.base.widget.banner.BannerBaseItemInfo
        public boolean getPrevlogin() {
            return "1".equalsIgnoreCase(this.prevlogin);
        }

        @Override // com.baidu.wallet.base.widget.banner.BannerBaseItemInfo
        public String getStat() {
            Stat stat = this.stat;
            if (stat != null) {
                return stat.getName();
            }
            return null;
        }

        @Override // com.baidu.wallet.home.datamodel.WalletBannerItem
        public String getTimeStamp() {
            return this.timestamp;
        }

        @Override // com.baidu.wallet.home.datamodel.WalletBannerItem
        public String getTimeStampIconType() {
            return this.timestamp_icon;
        }

        public String getTimeStampValue() {
            return this.timestamp_value;
        }

        @Override // com.baidu.wallet.base.widget.banner.BannerBaseItemInfo
        public String getType() {
            return this.type;
        }

        @Override // com.baidu.wallet.home.datamodel.WalletBannerItem
        public String getValue1() {
            return this.value1;
        }

        @Override // com.baidu.wallet.home.datamodel.WalletBannerItem
        public String getValue2() {
            return this.value2;
        }
    }

    /* loaded from: classes5.dex */
    public static class DataRepay implements NoProguard {
        public DataButton[] buttons;
        public String desc;
        public String label;
        public String name;
        public String type;
        public String value;
    }

    /* loaded from: classes5.dex */
    public static class FooterConfig implements NoProguard, Serializable {
        public static final long serialVersionUID = 1;
        public FooterItemDate[] data;
        public String fingerprint;
    }

    /* loaded from: classes5.dex */
    public static class FooterItemDate implements NoProguard, Serializable {
        public static final long serialVersionUID = 1;
        public String footer_desc;
        public String footer_link_addr;
        public String footer_slogan;
        public String footer_type;
        public String footer_visible;

        public boolean isFooterVisible() {
            return !TextUtils.isEmpty(this.footer_visible) && this.footer_visible.equals("1");
        }
    }

    /* loaded from: classes5.dex */
    public static class Stat implements NoProguard {
        public String click;

        public String getName() {
            return !TextUtils.isEmpty(this.click) ? this.click : "";
        }
    }

    /* loaded from: classes5.dex */
    public static class TitleConfig implements NoProguard, Serializable {
        public static final long serialVersionUID = 740046545863062188L;
        public TitleItem[] data;
        public String fingerprint;

        public boolean checkTitleConfig() {
            TitleItem[] titleItemArr = this.data;
            return (titleItemArr == null || titleItemArr.length <= 0 || titleItemArr[0] == null) ? false : true;
        }
    }

    /* loaded from: classes5.dex */
    public static class TitleItem implements NoProguard, Serializable {
        public static final long serialVersionUID = -710174975362084934L;
        public String fd_desc;
        public String fd_link_addr;
        public String fd_logo;
        public String fd_type;
        public String fd_visible;
        public TitleItemData[] list;
        public String safe_title;
        public String titlebar;

        public boolean isFeedBackVisible() {
            return (TextUtils.isEmpty(this.fd_visible) || !this.fd_visible.equals("1") || TextUtils.isEmpty(this.fd_desc) || TextUtils.isEmpty(this.fd_link_addr) || TextUtils.isEmpty(this.fd_type)) ? false : true;
        }
    }

    /* loaded from: classes5.dex */
    public static class TitleItemData extends WalletBannerItem implements NoProguard, Serializable {
        public static final long serialVersionUID = -1114980926835567633L;
        public String setting_addr;
        public String setting_icon;
        public String setting_name;
        public String setting_type;
        public String timestamp;
        public String timestamp_icon;

        @Override // com.baidu.wallet.home.datamodel.WalletBannerItem
        public String getCornerAddr() {
            return null;
        }

        @Override // com.baidu.wallet.base.widget.banner.BannerBaseItemInfo
        public String getLinkAddr() {
            return this.setting_addr;
        }

        @Override // com.baidu.wallet.base.widget.banner.BannerBaseItemInfo
        public String getName() {
            return this.setting_name;
        }

        @Override // com.baidu.wallet.base.widget.banner.BannerBaseItemInfo
        public String getPicAddr() {
            return this.setting_icon;
        }

        @Override // com.baidu.wallet.base.widget.banner.BannerBaseItemInfo
        public boolean getPrevlogin() {
            return false;
        }

        @Override // com.baidu.wallet.home.datamodel.WalletBannerItem
        public String getTimeStamp() {
            return this.timestamp;
        }

        @Override // com.baidu.wallet.home.datamodel.WalletBannerItem
        public String getTimeStampIconType() {
            return this.timestamp_icon;
        }

        @Override // com.baidu.wallet.base.widget.banner.BannerBaseItemInfo
        public String getType() {
            return this.setting_type;
        }

        @Override // com.baidu.wallet.home.datamodel.WalletBannerItem
        public String getValue1() {
            return null;
        }

        @Override // com.baidu.wallet.home.datamodel.WalletBannerItem
        public String getValue2() {
            return null;
        }
    }

    @Override // com.baidu.apollon.beans.IBeanResponse
    public boolean checkResponseValidity() {
        return true;
    }

    public HomeCfgResponse combineResponse(HomeCfgResponse homeCfgResponse) {
        AllConfig allConfig;
        ConfigData[] configDataArr;
        return (homeCfgResponse == null || (allConfig = homeCfgResponse.layout_content) == null || (configDataArr = allConfig.data) == null || configDataArr.length <= 0) ? this : homeCfgResponse;
    }

    public boolean doCheckValidity() {
        ConfigData[] configDataArr;
        AllConfig allConfig = this.layout_content;
        return (allConfig == null || (configDataArr = allConfig.data) == null || configDataArr.length <= 0) ? false : true;
    }

    public void doStoreResponse(final Context context, final String str) {
        new Thread() { // from class: com.baidu.wallet.home.datamodel.HomeCfgResponse.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                HomeDataCacheManager.getInstance().saveResponseDataToCache(context.getApplicationContext(), HomeCfgResponse.this, str);
            }
        }.start();
    }

    public boolean isLogin() {
        return "1".equalsIgnoreCase(this.is_login);
    }

    @Override // com.baidu.apollon.beans.IBeanResponse
    public void storeResponse(Context context) {
    }
}
