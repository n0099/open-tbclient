package com.baidu.yuyinala.privatemessage.implugin.ma;
/* loaded from: classes4.dex */
public class MABottomToolBar {
    private CommonMenuType onR;
    private CommonToolBarType onS;
    private a onT;
    private b onU;

    @Deprecated
    /* loaded from: classes4.dex */
    public enum CommonMenuType {
        MENU_STYLE_AD_IMMERSIVE_LANDING_PAGE,
        MENU_STYLE_NO,
        MENU_STYLE_NS_H5,
        MENU_STYLE_NS_NA
    }

    /* loaded from: classes4.dex */
    public enum CommonToolBarType {
        TOOL_BAR_STYLE_AD_IMMERSIVE_LANDING_PAGE,
        TOOL_BAR_STYLE_NEWS,
        TOOL_BAR_STYLE_NO,
        TOOL_BAR_STYLE_NS
    }

    @Deprecated
    /* loaded from: classes4.dex */
    public interface a {
    }

    @Deprecated
    /* loaded from: classes4.dex */
    public interface b {
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("mCommonToolBarType = " + this.onS + "\n");
        sb.append("mCommonMenuType = " + this.onR + "\n");
        sb.append("mOnCommonToolBarClickListener = " + this.onT + "\n");
        sb.append("mOnCommonToolMenuClickListener = " + this.onU);
        return sb.toString();
    }
}
