package com.baidu.tieba.recapp;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.a;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.AdvertAppInfo;
/* loaded from: classes.dex */
public interface s {
    void a(AdvertAppInfo advertAppInfo, String str);

    void aap();

    BaseActivity<?> getContext();

    String getFid();

    int getPageNum();

    a k(BdUniqueId bdUniqueId);
}
