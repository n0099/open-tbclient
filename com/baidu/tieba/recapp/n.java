package com.baidu.tieba.recapp;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
/* loaded from: classes.dex */
public interface n {
    void a(AdvertAppInfo advertAppInfo, String str);

    void bms();

    String getFid();

    int getPageNum();

    TbPageContext<?> getTbPageContext();
}
