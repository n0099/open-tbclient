package com.baidu.tieba.model;

import com.baidu.tieba.util.TiebaLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class SuggestModel {
    private ArrayList<String> forum_list = new ArrayList<>();

    public ArrayList<String> getForum_list() {
        return this.forum_list;
    }

    public void setForum_list(ArrayList<String> forum_list) {
        this.forum_list = forum_list;
    }

    public void parserJson(String data) {
        try {
            JSONObject json = new JSONObject(data);
            parserJson(json);
        } catch (Exception ex) {
            TiebaLog.e("BarlistModel", "parserJson", "error = " + ex.getMessage());
        }
    }

    public void parserJson(JSONObject json) {
        try {
            JSONArray list = json.optJSONArray("fname");
            if (list != null) {
                for (int i = 0; i < list.length(); i++) {
                    String name = list.getString(i);
                    this.forum_list.add(name);
                }
            }
        } catch (Exception ex) {
            TiebaLog.e("BarlistModel", "parserJson", "error = " + ex.getMessage());
        }
    }

    public void logPrint() {
        for (int i = 0; i < this.forum_list.size(); i++) {
            TiebaLog.v("ForumData", "logPrint", "forum = " + this.forum_list.get(i));
        }
    }
}
