package com.baidu.tieba.model;

import com.baidu.tieba.data.FeedData;
import com.baidu.tieba.data.MessageData;
import com.baidu.tieba.data.PageData;
import com.baidu.tieba.util.TiebaLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class MentionModel {
    private MessageData message = new MessageData();
    private ArrayList<FeedData> feed_list = new ArrayList<>();
    private PageData page = new PageData();
    private boolean isSucc = true;

    public boolean isSucc() {
        return this.isSucc;
    }

    public void setFeed_list(ArrayList<FeedData> feed_list) {
        this.feed_list = feed_list;
    }

    public ArrayList<FeedData> getFeed_list() {
        return this.feed_list;
    }

    public void setMessage(MessageData message) {
        this.message = message;
    }

    public MessageData getMessage() {
        return this.message;
    }

    public void setPage(PageData page) {
        this.page = page;
    }

    public PageData getPage() {
        return this.page;
    }

    public void parserJson(String data) {
        try {
            JSONObject json = new JSONObject(data);
            parserJson(json);
        } catch (Exception ex) {
            this.isSucc = false;
            TiebaLog.e("MentionModel", "parserJson", "error = " + ex.getMessage());
        }
    }

    public void parserJson(JSONObject json) {
        try {
            JSONArray list = json.optJSONArray("reply_list");
            if (list == null) {
                list = json.optJSONArray("at_list");
            }
            if (list != null) {
                for (int i = 0; i < list.length(); i++) {
                    FeedData tmp = new FeedData();
                    tmp.parserJson(list.optJSONObject(i));
                    this.feed_list.add(tmp);
                }
            }
            this.message.parserJson(json.optJSONObject("message"));
            this.page.parserJson(json.optJSONObject("page"));
        } catch (Exception ex) {
            this.isSucc = false;
            TiebaLog.e("MentionModel", "parserJson", "error = " + ex.getMessage());
        }
    }
}
