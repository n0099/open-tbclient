package com.baidu.tieba.model;

import android.content.Context;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class BarSuggestModel extends com.baidu.adp.base.e implements Serializable {
    private static final long serialVersionUID = 6239604692561216871L;
    public ArrayList<Forum> forum_list;

    /* loaded from: classes.dex */
    public class Forum extends com.baidu.adp.lib.a.b.a.a.i implements Serializable {
        private static final long serialVersionUID = 9180642468980325020L;
        public String forum_name = "";
        public int forum_id = 0;
        public String avatar = "";
        public String slogan = "";
        public int member_num = 0;
        public int thread_num = 0;
    }

    public BarSuggestModel() {
    }

    protected BarSuggestModel(Context context) {
        super(context);
    }

    public static BarSuggestModel parserJson(String str) {
        return (BarSuggestModel) com.baidu.adp.lib.a.b.a.a.i.objectWithJsonStr(str, BarSuggestModel.class);
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }
}
