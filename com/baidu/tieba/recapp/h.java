package com.baidu.tieba.recapp;

import android.view.View;
import com.baidu.tbadk.core.data.AdvertAppInfo;
/* loaded from: classes.dex */
public interface h {
    View getAdCloseView();

    int getCloseViewHeight();

    int getCloseViewWidth();

    void onChangeSkinType();

    void setData(AdvertAppInfo advertAppInfo);

    void setPage(int i);
}
