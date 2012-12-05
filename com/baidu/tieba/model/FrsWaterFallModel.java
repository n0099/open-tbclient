package com.baidu.tieba.model;

import com.baidu.tieba.data.AntiData;
import com.baidu.tieba.data.ForumData;
import com.baidu.tieba.data.OwnerData;
import com.baidu.tieba.data.ThreadWaterData;
import com.baidu.tieba.util.TiebaLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class FrsWaterFallModel {
    private ForumData mForum = new ForumData();
    private ArrayList<ThreadWaterData> mThread = new ArrayList<>();
    private ArrayList<String> mIdList = new ArrayList<>();
    private int mHasMore = 0;
    private int mTotal = 0;
    private int mCurrentCount = 0;
    private AntiData mAnti = new AntiData();
    private OwnerData mOwner = new OwnerData();

    public ForumData getForum() {
        return this.mForum;
    }

    public void setForum(ForumData forum) {
        this.mForum = forum;
    }

    public ArrayList<ThreadWaterData> getThread() {
        return this.mThread;
    }

    public void setThread(ArrayList<ThreadWaterData> thread) {
        this.mThread = thread;
    }

    public ArrayList<String> getIdList() {
        return this.mIdList;
    }

    public void setIdList(ArrayList<String> idList) {
        this.mIdList = idList;
    }

    public int getHasMore() {
        return this.mHasMore;
    }

    public void setHasMore(int hasMore) {
        this.mHasMore = hasMore;
    }

    public int getTotal() {
        return this.mTotal;
    }

    public void setTotal(int total) {
        this.mTotal = total;
    }

    public int getCurrentCount() {
        return this.mCurrentCount;
    }

    public void setCurrentCount(int currentCount) {
        this.mCurrentCount = currentCount;
    }

    public AntiData getAnti() {
        return this.mAnti;
    }

    public void setAnti(AntiData anti) {
        this.mAnti = anti;
    }

    public void parserJson(JSONObject json) {
        if (json != null) {
            try {
                this.mForum.parserJson(json.optJSONObject("forum"));
                this.mOwner.parserJson(json.optJSONObject("user"));
                this.mAnti.parserJson(json.optJSONObject("anti"));
                JSONObject json2 = json.optJSONObject("photo_data");
                if (json2 != null) {
                    JSONArray list = json2.optJSONArray("thread_list");
                    if (list != null) {
                        for (int i = 0; i < list.length(); i++) {
                            ThreadWaterData tmp = new ThreadWaterData();
                            tmp.parserJson(list.optJSONObject(i));
                            this.mThread.add(tmp);
                        }
                    }
                    JSONArray list2 = json2.optJSONArray("alb_id_list");
                    if (list2 != null) {
                        for (int i2 = 0; i2 < list2.length(); i2++) {
                            this.mIdList.add(list2.optString(i2));
                        }
                    }
                    this.mHasMore = json2.optInt("has_more", 0);
                    this.mTotal = json2.optInt("amount", 0);
                    this.mCurrentCount = json2.optInt("current_count", 0);
                }
            } catch (Exception ex) {
                TiebaLog.e(getClass().getName(), "parserJson", "error = " + ex.getMessage());
            }
        }
    }

    public void parserJson(String data) {
        try {
            JSONObject json = new JSONObject(data);
            parserJson(json);
        } catch (Exception ex) {
            TiebaLog.e(getClass().getName(), "parserJson", "error = " + ex.getMessage());
        }
    }
}
