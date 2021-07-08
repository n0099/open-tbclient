package com.baidu.wallet.home.datamodel;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.beans.IBeanResponse;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.core.NoProguard;
import com.baidu.wallet.home.storage.HomeDataCacheManager;
import java.io.Serializable;
/* loaded from: classes5.dex */
public class HomeCfgResponse implements IBeanResponse {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String abtype;
    public String android_prefix;
    public String changedSign;
    public String is_login;
    public AllConfig layout_content;
    public FooterConfig layout_footer;
    public TitleConfig layout_title;
    public String version;

    /* loaded from: classes5.dex */
    public static class AllConfig implements NoProguard, Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 6644260416559855999L;
        public transient /* synthetic */ FieldHolder $fh;
        public ConfigData[] data;
        public String fingerprint;

        public AllConfig() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.fingerprint = "";
        }
    }

    /* loaded from: classes5.dex */
    public static class ConfigData implements NoProguard, Serializable {
        public static /* synthetic */ Interceptable $ic = null;
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
        public transient /* synthetic */ FieldHolder $fh;
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

        public ConfigData() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public String getGroup_desc() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.group_desc : (String) invokeV.objValue;
        }

        public String getGroup_layout() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.group_layout : (String) invokeV.objValue;
        }

        public String getGroup_link() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.group_link : (String) invokeV.objValue;
        }

        public String getGroup_logo() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.group_logo : (String) invokeV.objValue;
        }

        public String getGroup_name() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.group_name : (String) invokeV.objValue;
        }

        public boolean getGroup_prevlogin() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? "1".equalsIgnoreCase(this.group_prevlogin) : invokeV.booleanValue;
        }

        public String getGroup_type() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.group_type : (String) invokeV.objValue;
        }

        public boolean isGroupCanClick() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                if (TextUtils.isEmpty(this.group_link) || TextUtils.isEmpty(this.group_type)) {
                    return false;
                }
                return this.group_type.equals("1") || this.group_type.equals("2") || this.group_type.equals("3") || this.group_type.equals("4");
            }
            return invokeV.booleanValue;
        }

        public boolean isLayoutHasGap() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                if (TextUtils.isEmpty(this.group_has_gap)) {
                    return false;
                }
                return this.group_has_gap.equals("1");
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class DataButton implements NoProguard {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String btn_type;
        public String icon;
        public String link_addr;
        public String name;
        public String prevlogin;
        public Stat stat;
        public String type;

        public DataButton() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class DataIcon implements NoProguard {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String icon_link;
        public String name;

        public DataIcon() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class DataItem extends WalletBannerItem implements NoProguard {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -8579386834036716930L;
        public transient /* synthetic */ FieldHolder $fh;
        public DataButton[] buttons;
        public String corner_addr;
        public String desc;
        public String detail;
        public boolean empty_view;
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

        public DataItem() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.empty_view = false;
        }

        @Override // com.baidu.wallet.home.datamodel.WalletBannerItem
        public String getCornerAddr() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.corner_addr : (String) invokeV.objValue;
        }

        @Override // com.baidu.wallet.base.widget.banner.BannerBaseItemInfo
        public String getLinkAddr() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.link_addr : (String) invokeV.objValue;
        }

        @Override // com.baidu.wallet.base.widget.banner.BannerBaseItemInfo
        public String getName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.name : (String) invokeV.objValue;
        }

        @Override // com.baidu.wallet.base.widget.banner.BannerBaseItemInfo
        public String getPicAddr() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.logo : (String) invokeV.objValue;
        }

        @Override // com.baidu.wallet.base.widget.banner.BannerBaseItemInfo
        public boolean getPrevlogin() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? "1".equalsIgnoreCase(this.prevlogin) : invokeV.booleanValue;
        }

        @Override // com.baidu.wallet.base.widget.banner.BannerBaseItemInfo
        public String getStat() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                Stat stat = this.stat;
                if (stat != null) {
                    return stat.getName();
                }
                return null;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.wallet.home.datamodel.WalletBannerItem
        public String getTimeStamp() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.timestamp : (String) invokeV.objValue;
        }

        @Override // com.baidu.wallet.home.datamodel.WalletBannerItem
        public String getTimeStampIconType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.timestamp_icon : (String) invokeV.objValue;
        }

        public String getTimeStampValue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.timestamp_value : (String) invokeV.objValue;
        }

        @Override // com.baidu.wallet.base.widget.banner.BannerBaseItemInfo
        public String getType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.type : (String) invokeV.objValue;
        }

        @Override // com.baidu.wallet.home.datamodel.WalletBannerItem
        public String getValue1() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.value1 : (String) invokeV.objValue;
        }

        @Override // com.baidu.wallet.home.datamodel.WalletBannerItem
        public String getValue2() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.value2 : (String) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class DataRepay implements NoProguard {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public DataButton[] buttons;
        public String desc;
        public String label;
        public String name;
        public String type;
        public String value;

        public DataRepay() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class FooterConfig implements NoProguard, Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 1;
        public transient /* synthetic */ FieldHolder $fh;
        public FooterItemDate[] data;
        public String fingerprint;

        public FooterConfig() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class FooterItemDate implements NoProguard, Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 1;
        public transient /* synthetic */ FieldHolder $fh;
        public String footer_desc;
        public String footer_link_addr;
        public String footer_slogan;
        public String footer_type;
        public String footer_visible;

        public FooterItemDate() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public boolean isFooterVisible() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? !TextUtils.isEmpty(this.footer_visible) && this.footer_visible.equals("1") : invokeV.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class Stat implements NoProguard {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String click;

        public Stat() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public String getName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? !TextUtils.isEmpty(this.click) ? this.click : "" : (String) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class TitleConfig implements NoProguard, Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 740046545863062188L;
        public transient /* synthetic */ FieldHolder $fh;
        public TitleItem[] data;
        public String fingerprint;

        public TitleConfig() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public boolean checkTitleConfig() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                TitleItem[] titleItemArr = this.data;
                return (titleItemArr == null || titleItemArr.length <= 0 || titleItemArr[0] == null) ? false : true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class TitleItem implements NoProguard, Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -710174975362084934L;
        public transient /* synthetic */ FieldHolder $fh;
        public String fd_desc;
        public String fd_link_addr;
        public String fd_logo;
        public String fd_type;
        public String fd_visible;
        public TitleItemData[] list;
        public String safe_title;
        public String titlebar;

        public TitleItem() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public boolean isFeedBackVisible() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (TextUtils.isEmpty(this.fd_visible) || !this.fd_visible.equals("1") || TextUtils.isEmpty(this.fd_desc) || TextUtils.isEmpty(this.fd_link_addr) || TextUtils.isEmpty(this.fd_type)) ? false : true : invokeV.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class TitleItemData extends WalletBannerItem implements NoProguard, Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -1114980926835567633L;
        public transient /* synthetic */ FieldHolder $fh;
        public String setting_addr;
        public String setting_icon;
        public String setting_name;
        public String setting_type;
        public String timestamp;
        public String timestamp_icon;

        public TitleItemData() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.wallet.home.datamodel.WalletBannerItem
        public String getCornerAddr() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return null;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.wallet.base.widget.banner.BannerBaseItemInfo
        public String getLinkAddr() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.setting_addr : (String) invokeV.objValue;
        }

        @Override // com.baidu.wallet.base.widget.banner.BannerBaseItemInfo
        public String getName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.setting_name : (String) invokeV.objValue;
        }

        @Override // com.baidu.wallet.base.widget.banner.BannerBaseItemInfo
        public String getPicAddr() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.setting_icon : (String) invokeV.objValue;
        }

        @Override // com.baidu.wallet.base.widget.banner.BannerBaseItemInfo
        public boolean getPrevlogin() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.wallet.home.datamodel.WalletBannerItem
        public String getTimeStamp() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.timestamp : (String) invokeV.objValue;
        }

        @Override // com.baidu.wallet.home.datamodel.WalletBannerItem
        public String getTimeStampIconType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.timestamp_icon : (String) invokeV.objValue;
        }

        @Override // com.baidu.wallet.base.widget.banner.BannerBaseItemInfo
        public String getType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.setting_type : (String) invokeV.objValue;
        }

        @Override // com.baidu.wallet.home.datamodel.WalletBannerItem
        public String getValue1() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                return null;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.wallet.home.datamodel.WalletBannerItem
        public String getValue2() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                return null;
            }
            return (String) invokeV.objValue;
        }
    }

    public HomeCfgResponse() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.android_prefix = "";
        this.is_login = "0";
    }

    @Override // com.baidu.apollon.beans.IBeanResponse
    public boolean checkResponseValidity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public HomeCfgResponse combineResponse(HomeCfgResponse homeCfgResponse) {
        InterceptResult invokeL;
        AllConfig allConfig;
        ConfigData[] configDataArr;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, homeCfgResponse)) == null) ? (homeCfgResponse == null || (allConfig = homeCfgResponse.layout_content) == null || (configDataArr = allConfig.data) == null || configDataArr.length <= 0) ? this : homeCfgResponse : (HomeCfgResponse) invokeL.objValue;
    }

    public boolean doCheckValidity() {
        InterceptResult invokeV;
        ConfigData[] configDataArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            AllConfig allConfig = this.layout_content;
            return (allConfig == null || (configDataArr = allConfig.data) == null || configDataArr.length <= 0) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public void doStoreResponse(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, context, str) == null) {
            new Thread(this, context, str) { // from class: com.baidu.wallet.home.datamodel.HomeCfgResponse.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Context f24988a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ String f24989b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ HomeCfgResponse f24990c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, context, str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f24990c = this;
                    this.f24988a = context;
                    this.f24989b = str;
                }

                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        HomeDataCacheManager.getInstance().saveResponseDataToCache(this.f24988a.getApplicationContext(), this.f24990c, this.f24989b);
                    }
                }
            }.start();
        }
    }

    public boolean isLogin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? "1".equalsIgnoreCase(this.is_login) : invokeV.booleanValue;
    }

    @Override // com.baidu.apollon.beans.IBeanResponse
    public void storeResponse(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, context) == null) {
        }
    }
}
