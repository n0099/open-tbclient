package com.baidu.tieba.model;

import com.baidu.tieba.data.ForumData;
import com.baidu.tieba.data.PageData;
import com.baidu.tieba.util.TiebaLog;
import java.util.ArrayList;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class BarlistModel {
    private ArrayList<ForumData> forum_list = new ArrayList<>();
    private PageData page = new PageData();
    private Date time = null;
    private boolean isSucc = true;

    public boolean isSucc() {
        return this.isSucc;
    }

    public Date getTime() {
        return this.time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public ArrayList<ForumData> getForum_list() {
        return this.forum_list;
    }

    public void setForum_list(ArrayList<ForumData> forum_list) {
        this.forum_list = forum_list;
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
            TiebaLog.e("BarlistModel", "parserJson", "error = " + ex.getMessage());
        }
    }

    public void parserJson(JSONObject json) {
        try {
            JSONArray list = json.optJSONArray("forum_list");
            if (list != null) {
                for (int i = 0; i < list.length(); i++) {
                    ForumData tmp = new ForumData();
                    tmp.parserJson(list.getJSONObject(i));
                    this.forum_list.add(tmp);
                }
            }
            this.page.parserJson(json.optJSONObject("page"));
            long longTime = json.optLong("ctime", 0L);
            if (longTime > 0) {
                this.time = new Date(longTime);
            } else {
                this.time = new Date();
            }
        } catch (Exception ex) {
            this.isSucc = false;
            TiebaLog.e("BarlistModel", "parserJson", "error = " + ex.getMessage());
        }
    }

    public void logPrint() {
        for (int i = 0; i < this.forum_list.size(); i++) {
            this.forum_list.get(i).logPrint();
        }
        this.page.logPrint();
    }
}
