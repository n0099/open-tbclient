package com.baidu.tieba.tbadkCore;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.FeedForumData;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class v {
    private int cur_score;
    private String fid;
    private int fow;
    private int fox;
    private List<FeedForumData> foy = new ArrayList();
    private int is_like;
    private String level_name;
    private int levelup_score;
    private int user_level;

    public v() {
        setLike(0);
        this.fow = 0;
        this.fox = 0;
        this.user_level = 0;
        setLevelName("");
        setCurScore(0);
        setLevelupScore(0);
    }

    public String getFid() {
        return this.fid;
    }

    public void setFid(String str) {
        this.fid = str;
    }

    public int getUserLevel() {
        return this.user_level;
    }

    public void setUserLevel(int i) {
        if (i >= 0) {
            this.user_level = i;
        }
    }

    public void parserJson(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            parserJson(jSONObject.optJSONObject(LoginActivityConfig.INFO));
            f(jSONObject.optJSONArray("feed_forum"));
        } catch (Exception e) {
            BdLog.detailException(e);
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                setLike(jSONObject.optInt("is_like", 0));
                this.fow = jSONObject.optInt("is_black", 0);
                this.fox = jSONObject.optInt("like_num", 0);
                this.user_level = jSONObject.optInt("level_id", 0);
                setLevelName(jSONObject.optString("level_name", ""));
                setLevelupScore(jSONObject.optInt("levelup_score", 0));
                setCurScore(jSONObject.optInt("cur_score", 0));
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public void f(JSONArray jSONArray) {
        int i = 0;
        while (true) {
            try {
                int i2 = i;
                if (i2 < jSONArray.length()) {
                    JSONObject jSONObject = (JSONObject) jSONArray.opt(i2);
                    FeedForumData feedForumData = new FeedForumData();
                    feedForumData.setForumId(jSONObject.getString("forum_id"));
                    feedForumData.setForumName(jSONObject.getString("forum_name"));
                    feedForumData.setMemberCount(Integer.parseInt(jSONObject.getString("member_count")));
                    feedForumData.setPostNum(Integer.parseInt(jSONObject.getString("post_num")));
                    feedForumData.setAvatar(jSONObject.getString("avatar"));
                    feedForumData.setReason(jSONObject.getString("reason"));
                    feedForumData.setIsLike(Integer.parseInt(jSONObject.getString("is_like")));
                    feedForumData.setPos(Integer.parseInt(jSONObject.getString("pos")));
                    this.foy.add(feedForumData);
                    i = i2 + 1;
                } else {
                    return;
                }
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
    }

    public void setLike(int i) {
        this.is_like = i;
    }

    public int isLike() {
        return this.is_like;
    }

    public void setLevelName(String str) {
        this.level_name = str;
    }

    public String getLevelName() {
        return this.level_name;
    }

    public void setCurScore(int i) {
        this.cur_score = i;
    }

    public int getCurScore() {
        return this.cur_score;
    }

    public void setLevelupScore(int i) {
        this.levelup_score = i;
    }

    public int getLevelupScore() {
        return this.levelup_score;
    }

    public List<FeedForumData> bfI() {
        return this.foy;
    }
}
