package com.baidu.tieba.recapp;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.a;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.c;
/* loaded from: classes.dex */
public interface m {
    void XT();

    void a(c cVar, String str);

    BaseActivity<?> getContext();

    String getFid();

    int getPageNum();

    a k(BdUniqueId bdUniqueId);
}
