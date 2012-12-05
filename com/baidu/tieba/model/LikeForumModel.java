package com.baidu.tieba.model;

import com.baidu.tieba.data.LikeForumData;
import com.baidu.tieba.data.PageData;
import com.baidu.tieba.util.TiebaLog;
import java.util.ArrayList;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class LikeForumModel {
    private ArrayList<LikeForumData> like_forums = new ArrayList<>();
    private ArrayList<LikeForumData> recommend_forums = new ArrayList<>();
    private PageData page = new PageData();
    private Date time = null;
    private boolean isSucc = true;
    private int isLogin = 0;

    public boolean isSucc() {
        return this.isSucc;
    }

    public Date getTime() {
        return this.time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public int getIsLogin() {
        return this.isLogin;
    }

    public ArrayList<LikeForumData> getLike_Forums() {
        return this.like_forums;
    }

    public void setLike_Forums(ArrayList<LikeForumData> like_forums) {
        this.like_forums = like_forums;
    }

    public ArrayList<LikeForumData> getRecommend_Forums() {
        return this.recommend_forums;
    }

    public void setRecommend_Forums(ArrayList<LikeForumData> recommend_forums) {
        this.recommend_forums = recommend_forums;
    }

    public PageData getPage() {
        return this.page;
    }

    public void setPage(PageData page) {
        this.page = page;
    }

    public void parserJson(String data) {
        try {
            JSONObject json = new JSONObject(data);
            parserJson(json);
        } catch (Exception ex) {
            this.isSucc = false;
            TiebaLog.e("LikeForumModel", "parserJson", "error = " + ex.getMessage());
        }
    }

    public void parserJson(JSONObject json) {
        try {
            JSONArray list = json.optJSONArray("forum_list");
            if (list != null) {
                for (int i = 0; i < list.length(); i++) {
                    LikeForumData tmp = new LikeForumData();
                    tmp.parserJson(list.getJSONObject(i));
                    this.like_forums.add(tmp);
                }
            }
            JSONArray list2 = json.optJSONArray("commend_forum_list");
            if (list2 != null) {
                for (int i2 = 0; i2 < list2.length(); i2++) {
                    LikeForumData tmp2 = new LikeForumData();
                    tmp2.parserJson(list2.getJSONObject(i2));
                    this.recommend_forums.add(tmp2);
                }
            }
            this.page.parserJson(json.optJSONObject("page"));
            long longTime = json.optLong("ctime", 0L);
            if (longTime > 0) {
                this.time = new Date(longTime);
            } else {
                this.time = new Date();
            }
            this.isLogin = json.optInt("is_login", 0);
        } catch (Exception ex) {
            this.isSucc = false;
            TiebaLog.e("LikeForumModel", "parserJson", "error = " + ex.getMessage());
        }
    }

    public void logPrint() {
        for (int i = 0; i < this.like_forums.size(); i++) {
            this.like_forums.get(i).logPrint();
        }
        for (int i2 = 0; i2 < this.recommend_forums.size(); i2++) {
            this.recommend_forums.get(i2).logPrint();
        }
        this.page.logPrint();
    }
}
