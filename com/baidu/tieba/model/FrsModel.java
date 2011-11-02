package com.baidu.tieba.model;

import com.baidu.tieba.data.AntiData;
import com.baidu.tieba.data.ForumData;
import com.baidu.tieba.data.PageData;
import com.baidu.tieba.data.ThreadData;
import com.baidu.tieba.util.TiebaLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class FrsModel {
    private AntiData anti;
    private ForumData forum = new ForumData();
    private ArrayList<ThreadData> thread_list = new ArrayList<>();
    private PageData page = new PageData();

    public FrsModel() {
        setAnti(new AntiData());
    }

    public ForumData getForum() {
        return this.forum;
    }

    public void setForum(ForumData forum) {
        this.forum = forum;
    }

    public ArrayList<ThreadData> getThread_list() {
        return this.thread_list;
    }

    public void setThread_list(ArrayList<ThreadData> thread_list) {
        this.thread_list = thread_list;
    }

    public void setAnti(AntiData anti) {
        this.anti = anti;
    }

    public AntiData getAnti() {
        return this.anti;
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
            TiebaLog.e("FrsModel", "parserJson", "error = " + ex.getMessage());
        }
    }

    public void parserJson(JSONObject json) {
        try {
            this.forum.parserJson(json.optJSONObject("forum"));
            JSONArray list = json.optJSONArray("thread_list");
            if (list != null) {
                for (int i = 0; i < list.length(); i++) {
                    ThreadData tmp = new ThreadData();
                    tmp.parserJson(list.optJSONObject(i));
                    tmp.parser_title();
                    this.thread_list.add(tmp);
                }
            }
            this.anti.parserJson(json.optJSONObject("anti"));
            this.page.parserJson(json.optJSONObject("page"));
        } catch (Exception ex) {
            TiebaLog.e("FrsModel", "parserJson", "error = " + ex.getMessage());
        }
    }

    public void logPrint() {
        this.forum.logPrint();
        for (int i = 0; i < this.thread_list.size(); i++) {
            this.thread_list.get(i).logPrint();
        }
        this.anti.logPrint();
        this.page.logPrint();
    }
}
