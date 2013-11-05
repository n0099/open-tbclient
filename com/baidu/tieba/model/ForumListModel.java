package com.baidu.tieba.model;

import android.content.Context;
import com.baidu.tieba.TiebaApplication;
import com.google.gson.GsonBuilder;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.Serializable;
import java.util.Arrays;
/* loaded from: classes.dex */
public class ForumListModel extends com.baidu.adp.a.d implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f1881a = false;
    private static String b = null;
    private static final long serialVersionUID = -5006585496963439439L;
    public Forum[] editor_recommend;
    public int error_code;
    public String[] forum_class;
    public List recommend_list_left;
    public List recommend_list_right;
    public long time = 0;
    public long ctime = 0;
    public long logid = 0;

    @Override // com.baidu.adp.a.d
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.d
    public boolean cancelLoadData() {
        return false;
    }

    public boolean isOk() {
        return f1881a;
    }

    /* loaded from: classes.dex */
    public class List implements Serializable {
        private static final long serialVersionUID = -3206282936395220632L;
        public Forum[] forum_list;
        public int has_more = 0;

        public String toString() {
            return "List{has_more=" + this.has_more + ", forum_list=" + Arrays.toString(this.forum_list) + '}';
        }
    }

    /* loaded from: classes.dex */
    public class Forum implements Serializable {
        private static final long serialVersionUID = -117403744113430260L;
        public String forum_name = "";
        public int forum_id = 0;
        public String avatar = "";
        public String slogan = "";
        public int member_count = 0;
        public int thread_count = 0;
        public int is_like = 0;
        public int mbr_inter_rank = 0;

        public String toString() {
            return "Forum{forum_name='" + this.forum_name + "', forum_id=" + this.forum_id + ", avatar='" + this.avatar + "', slogan='" + this.slogan + "', member_count=" + this.member_count + ", thread_count=" + this.thread_count + ", is_like=" + this.is_like + ", mbr_inter_rank=" + this.mbr_inter_rank + '}';
        }
    }

    public String toString() {
        return "DataProvider{error_code=" + this.error_code + ", editor_recommend=" + Arrays.toString(this.editor_recommend) + ", forum_class=" + Arrays.toString(this.forum_class) + ", recommend_list_left=" + this.recommend_list_left + ", recommend_list_right=" + this.recommend_list_right + ", time=" + this.time + ", ctime=" + this.ctime + ", logid=" + this.logid + '}';
    }

    public static ForumListModel new_fetch(Context context, RequestParams requestParams) {
        int i;
        com.baidu.adp.lib.cache.s<String> i2;
        if (requestParams.menu_id == 0) {
            i = requestParams.menu_name.equals(requestParams.parent_menu_name) ? 9 : 10;
        } else {
            i = (requestParams.menu_type == 2 || !requestParams.menu_name.equals(requestParams.parent_menu_name)) ? 137 : 136;
        }
        b = requestParams.menu_name;
        com.baidu.tieba.util.ag agVar = new com.baidu.tieba.util.ag(context, com.baidu.tieba.data.h.f1165a + "c/f/forum/forumrank");
        agVar.a("rn", String.valueOf(requestParams.rn));
        agVar.a("offset", String.valueOf(requestParams.offset));
        agVar.a("recommend_type", String.valueOf(requestParams.recommend_type));
        agVar.a("menu_name", requestParams.menu_name);
        agVar.a("menu_type", String.valueOf(i));
        String j = agVar.j();
        f1881a = agVar.d();
        com.baidu.tieba.util.be.e("DataProvider", "fetch", "fetched raw string\n" + j);
        ForumListModel forumListModel = (ForumListModel) new GsonBuilder().create().fromJson(j, (Class<Object>) ForumListModel.class);
        if (requestParams.rn == 10 && requestParams.recommend_type == 0 && ((i == 9 || i == 136 || requestParams.menu_type == 2) && forumListModel != null && forumListModel.recommend_list_left != null && forumListModel.recommend_list_right != null && forumListModel.editor_recommend != null && forumListModel.forum_class != null && (i2 = com.baidu.tieba.b.a.a().i()) != null)) {
            i2.a(TiebaApplication.C() + "_" + b + "_list", j, Util.MILLSECONDS_OF_DAY);
        }
        return forumListModel;
    }

    /* loaded from: classes.dex */
    public class RequestParams implements Serializable {
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

        public String toString() {
            return "?rn=" + this.rn + "&offset=" + this.offset + "&recommend_type=" + this.recommend_type + "&menu_name=" + this.menu_name + "&menu_id=" + this.menu_id + "&menu_type=" + this.menu_type + "&parent_menu_name=" + this.parent_menu_name + "&parent_menu_id=" + this.parent_menu_id;
        }
    }
}
