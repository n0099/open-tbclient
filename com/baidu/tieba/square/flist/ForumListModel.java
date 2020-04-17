package com.baidu.tieba.square.flist;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.cache.l;
import com.baidu.live.tbadk.core.atomdata.AlaLiveRoomActivityConfig;
import com.baidu.live.tbadk.data.Config;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumListActivityConfig;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.square.data.ForumInfoData;
import java.io.Serializable;
/* loaded from: classes10.dex */
public class ForumListModel extends BdBaseModel<ForumListActivity> implements Serializable {
    private static final String KEY = "_list";
    private static boolean isOk = false;
    private static String menu_name = null;
    private static final long serialVersionUID = -5006585496963439439L;
    public long ctime;
    public ForumInfoData[] editor_recommend;
    public int error_code;
    public String[] forum_class;
    public long logid;
    public List recommend_list_left;
    public List recommend_list_right;
    public long time;

    /* loaded from: classes10.dex */
    public static class List extends OrmObject implements Serializable {
        private static final long serialVersionUID = -3206282936395220632L;
        public ForumInfoData[] forum_list;
        public int has_more = 0;
    }

    /* loaded from: classes10.dex */
    public static class RequestParams extends OrmObject implements Serializable {
        private static final long serialVersionUID = -8487620337266534315L;
        public int rn = 6;
        public int offset = 0;
        public int recommend_type = 0;
        public String menu_name = "";
        public int menu_id = 0;
        public int menu_type = 0;
        public String parent_menu_name = "";
        public int parent_menu_id = 0;
        public String level_2_name = "";
    }

    public ForumListModel() {
        this.time = 0L;
        this.ctime = 0L;
        this.logid = 0L;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public ForumListModel(TbPageContext<ForumListActivity> tbPageContext) {
        super(tbPageContext);
        this.time = 0L;
        this.ctime = 0L;
        this.logid = 0L;
    }

    public boolean isOk() {
        return isOk;
    }

    public static ForumListModel new_fetch(RequestParams requestParams) {
        int i;
        l<String> ud;
        if (requestParams.menu_id == 0) {
            i = requestParams.menu_name.equals(requestParams.parent_menu_name) ? 9 : 10;
        } else {
            i = (requestParams.menu_type == 2 || !requestParams.menu_name.equals(requestParams.parent_menu_name)) ? 137 : 136;
        }
        menu_name = requestParams.menu_name;
        x xVar = new x(TbConfig.SERVER_ADDRESS + Config.FORUM_LIST_DETAIL);
        xVar.addPostData("rn", String.valueOf(requestParams.rn));
        xVar.addPostData("offset", String.valueOf(requestParams.offset));
        xVar.addPostData(AlaLiveRoomActivityConfig.SDK_EXTRA_RECOMMEND_TYPE, String.valueOf(requestParams.recommend_type));
        xVar.addPostData("menu_name", requestParams.menu_name);
        xVar.addPostData(ForumListActivityConfig.KEY_MENU_TYPE, String.valueOf(i));
        String postNetData = xVar.postNetData();
        isOk = xVar.isNetSuccess();
        ForumListModel forumListModel = (ForumListModel) OrmObject.objectWithJsonStr(postNetData, ForumListModel.class);
        if (requestParams.rn == 200 && requestParams.recommend_type == 0 && ((i == 9 || i == 136 || requestParams.menu_type == 2) && forumListModel != null && forumListModel.recommend_list_left != null && forumListModel.recommend_list_right != null && forumListModel.editor_recommend != null && forumListModel.forum_class != null && (ud = com.baidu.tbadk.core.c.a.aMT().ud("tb.my_posts")) != null)) {
            ud.set(TbadkCoreApplication.getCurrentAccount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + menu_name + KEY, postNetData, 86400000L);
        }
        return forumListModel;
    }
}
