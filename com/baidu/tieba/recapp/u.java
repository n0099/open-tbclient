package com.baidu.tieba.recapp;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.a;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
/* loaded from: classes.dex */
public interface u {
    void Zn();

    void a(AdvertAppInfo advertAppInfo, String str);

    String getFid();

    int getPageNum();

    a k(BdUniqueId bdUniqueId);

    TbPageContext<?> xD();
}
