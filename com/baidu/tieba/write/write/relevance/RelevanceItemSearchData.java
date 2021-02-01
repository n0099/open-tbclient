package com.baidu.tieba.write.write.relevance;

import com.baidu.tieba.write.write.relevance.list.ReleavanceItemListData;
import com.google.gson.Gson;
import java.io.Serializable;
/* loaded from: classes8.dex */
public class RelevanceItemSearchData implements Serializable {
    Gson gson = new Gson();
    private ReleavanceItemListData mDataList;

    public void parseJson(String str) {
        if (str != null) {
            this.mDataList = (ReleavanceItemListData) this.gson.fromJson(str, (Class<Object>) ReleavanceItemListData.class);
        }
    }

    public ReleavanceItemListData getData() {
        return this.mDataList;
    }
}
