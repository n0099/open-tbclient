package com.baidu.yuyinala.privatemessage.implugin.ma;
/* loaded from: classes11.dex */
public class MABottomToolBar {
    private CommonMenuType pas;
    private CommonToolBarType pat;
    private a pau;
    private b pav;

    @Deprecated
    /* loaded from: classes11.dex */
    public enum CommonMenuType {
        MENU_STYLE_AD_IMMERSIVE_LANDING_PAGE,
        MENU_STYLE_NO,
        MENU_STYLE_NS_H5,
        MENU_STYLE_NS_NA
    }

    /* loaded from: classes11.dex */
    public enum CommonToolBarType {
        TOOL_BAR_STYLE_AD_IMMERSIVE_LANDING_PAGE,
        TOOL_BAR_STYLE_NEWS,
        TOOL_BAR_STYLE_NO,
        TOOL_BAR_STYLE_NS
    }

    @Deprecated
    /* loaded from: classes11.dex */
    public interface a {
    }

    @Deprecated
    /* loaded from: classes11.dex */
    public interface b {
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("mCommonToolBarType = " + this.pat + "\n");
        sb.append("mCommonMenuType = " + this.pas + "\n");
        sb.append("mOnCommonToolBarClickListener = " + this.pau + "\n");
        sb.append("mOnCommonToolMenuClickListener = " + this.pav);
        return sb.toString();
    }
}
