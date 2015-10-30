package com.baidu.tieba.tbadkCore;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class x {
    private int cXY;
    private int cXZ;
    private int cur_score;
    private String fid;
    private int is_like;
    private String level_name;
    private int levelup_score;
    private int user_level;

    public x() {
        setLike(0);
        this.cXY = 0;
        this.cXZ = 0;
        this.user_level = 0;
        setLevelName("");
        setCurScore(0);
        setLevelupScore(0);
    }

    public String getFid() {
        return this.fid;
    }

    public void lx(String str) {
        this.fid = str;
    }

    public int atz() {
        return this.user_level;
    }

    public void kF(int i) {
        if (i >= 0) {
            this.user_level = i;
        }
    }

    public void parserJson(String str) {
        try {
            parserJson(new JSONObject(str).optJSONObject(LoginActivityConfig.INFO));
        } catch (Exception e) {
            BdLog.detailException(e);
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                setLike(jSONObject.optInt("is_like", 0));
                this.cXY = jSONObject.optInt("is_black", 0);
                this.cXZ = jSONObject.optInt("like_num", 0);
                this.user_level = jSONObject.optInt("level_id", 0);
                setLevelName(jSONObject.optString("level_name", ""));
                setLevelupScore(jSONObject.optInt("levelup_score", 0));
                setCurScore(jSONObject.optInt("cur_score", 0));
            } catch (Exception e) {
                BdLog.detailException(e);
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
}
