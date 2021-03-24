package com.baidu.tieba.write.write.relevance;

import com.baidu.tieba.write.write.relevance.list.ReleavanceItemListData;
import com.google.gson.Gson;
import java.io.Serializable;
/* loaded from: classes5.dex */
public class RelevanceItemSearchData implements Serializable {
    public Gson gson = new Gson();
    public ReleavanceItemListData mDataList;

    public ReleavanceItemListData getData() {
        return this.mDataList;
    }

    public void parseJson(String str) {
        if (str == null) {
            return;
        }
        this.mDataList = (ReleavanceItemListData) this.gson.fromJson(str, (Class<Object>) ReleavanceItemListData.class);
    }
}
