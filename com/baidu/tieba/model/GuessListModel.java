package com.baidu.tieba.model;

import com.baidu.tieba.data.PageData;
import com.baidu.tieba.data.ThreadData;
import com.baidu.tieba.util.TiebaLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class GuessListModel {
    private ArrayList<ThreadData> guess_list = new ArrayList<>();
    private PageData page = new PageData();

    public ArrayList<ThreadData> getGuess_list() {
        return this.guess_list;
    }

    public void setGuess_list(ArrayList<ThreadData> guess_list) {
        this.guess_list = guess_list;
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
            JSONArray list = json.optJSONArray("thread_list");
            if (list != null) {
                for (int i = 0; i < list.length(); i++) {
                    ThreadData tmp = new ThreadData();
                    tmp.parserJson(list.optJSONObject(i));
                    tmp.parser_title();
                    this.guess_list.add(tmp);
                }
            }
            this.page.parserJson(json.optJSONObject("page"));
        } catch (Exception ex) {
            TiebaLog.e("GuessListModel", "parserJson", "error = " + ex.getMessage());
        }
    }
}
