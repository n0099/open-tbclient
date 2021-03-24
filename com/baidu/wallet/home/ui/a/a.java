package com.baidu.wallet.home.ui.a;

import com.baidu.wallet.home.datamodel.HomeCfgResponse;
/* loaded from: classes5.dex */
public interface a {
    void hideRightZone();

    void refreshMenu(String str, HomeCfgResponse.TitleItemData[] titleItemDataArr, String str2);

    void refreshRightZone(int i);

    void refreshRightZone(String str);

    void refreshRightZoneDot(boolean z);

    void refreshSafeTip(String str);

    void refreshTitle(String str);

    void showMenu();
}
