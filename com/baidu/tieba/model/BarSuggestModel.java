package com.baidu.tieba.model;

import com.google.gson.GsonBuilder;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class BarSuggestModel extends com.baidu.adp.a.c implements Serializable {
    public ArrayList<Forum> forum_list;

    /* loaded from: classes.dex */
    public class Forum implements Serializable {
        public String forum_name = "";
        public int forum_id = 0;
        public String avatar = "";
        public String slogan = "";
        public int member_num = 0;
        public int thread_num = 0;
    }

    public static BarSuggestModel parserJson(String str) {
        return (BarSuggestModel) new GsonBuilder().create().fromJson(str, (Class<Object>) BarSuggestModel.class);
    }

    @Override // com.baidu.adp.a.c
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.c
    public boolean cancelLoadData() {
        return false;
    }
}
