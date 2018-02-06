package com.baidu.tieba.mainentrance;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.BaseActivity;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class ForumSuggestModel extends BdBaseModel implements Serializable {
    private static final long serialVersionUID = 6239604692561216871L;
    public ArrayList<Forum> forum_list;

    /* loaded from: classes3.dex */
    public static class Forum extends OrmObject implements Serializable {
        private static final long serialVersionUID = 9180642468980325020L;
        public String forum_name = "";
        public int forum_id = 0;
        public String avatar = "";
        public String slogan = "";
        public int member_num = 0;
        public int thread_num = 0;
        public int is_offical = 0;
    }

    public ForumSuggestModel() {
    }

    protected ForumSuggestModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
    }

    public static ForumSuggestModel parserJson(String str) {
        return (ForumSuggestModel) OrmObject.objectWithJsonStr(str, ForumSuggestModel.class);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }
}
