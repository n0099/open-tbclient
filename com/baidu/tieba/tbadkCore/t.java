package com.baidu.tieba.tbadkCore;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.tbadk.core.data.FeedForumData;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class t {
    private String blockUrl;
    private int cur_score;
    private int errorCode;
    private String errorMsg;
    private String fid;
    private int is_like;
    private String level_name;
    private int levelup_score;
    private BlockPopInfoData mBlockPopInfoData;
    private List<FeedForumData> keo = new ArrayList();
    private int ken = 0;
    private int like_num = 0;
    private int user_level = 0;

    public t() {
        setLevelName("");
        setLike(0);
        setCurScore(0);
        setLevelupScore(0);
    }

    public String getFid() {
        return this.fid;
    }

    public void setFid(String str) {
        this.fid = str;
    }

    public int cHe() {
        return this.user_level;
    }

    public void BZ(int i) {
        if (i >= 0) {
            this.user_level = i;
        }
    }

    public void parserJson(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            parserJson(jSONObject.optJSONObject("info"));
            W(jSONObject.optJSONArray("feed_forum"));
            this.errorCode = jSONObject.optInt("error_code");
            this.errorMsg = jSONObject.optString(PushConstants.EXTRA_ERROR_CODE);
        } catch (Exception e) {
            BdLog.detailException(e);
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.ken = jSONObject.optInt("is_black", 0);
                this.like_num = jSONObject.optInt("like_num", 0);
                this.user_level = jSONObject.optInt("level_id", 0);
                setLike(jSONObject.optInt("is_like", 0));
                setLevelName(jSONObject.optString("level_name", ""));
                setLevelupScore(jSONObject.optInt("levelup_score", 0));
                setCurScore(jSONObject.optInt("cur_score", 0));
                parseBlockAnti(jSONObject);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    private void parseBlockAnti(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.blockUrl = jSONObject.optString("block_dealurl");
            String optString = jSONObject.optString("block_content");
            if (!StringUtils.isNull(optString)) {
                this.mBlockPopInfoData = new BlockPopInfoData();
                this.mBlockPopInfoData.block_info = optString;
                this.mBlockPopInfoData.ahead_url = this.blockUrl;
                this.mBlockPopInfoData.ahead_info = jSONObject.optString("block_confirm");
                this.mBlockPopInfoData.ok_info = jSONObject.optString("block_cancel");
            }
        }
    }

    public void W(JSONArray jSONArray) {
        int i = 0;
        while (true) {
            try {
                int i2 = i;
                if (i2 < jSONArray.length()) {
                    JSONObject jSONObject = (JSONObject) jSONArray.opt(i2);
                    FeedForumData feedForumData = new FeedForumData();
                    feedForumData.setForumId(jSONObject.optString("forum_id"));
                    feedForumData.setForumName(jSONObject.optString("forum_name"));
                    feedForumData.setMemberCount(jSONObject.optInt("member_count", 0));
                    feedForumData.setPostNum(jSONObject.optInt("post_num", 0));
                    feedForumData.setAvatar(jSONObject.optString(TableDefine.PaSubscribeColumns.COLUMN_AVATAR));
                    feedForumData.setReason(jSONObject.optString(TiebaInitialize.LogFields.REASON));
                    feedForumData.setIsLike(jSONObject.optInt("is_like", 0));
                    feedForumData.setPos(jSONObject.optInt("pos", 0));
                    this.keo.add(feedForumData);
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

    public List<FeedForumData> cIH() {
        return this.keo;
    }

    public BlockPopInfoData getBlockPopInfoData() {
        return this.mBlockPopInfoData;
    }

    public void setBlockPopInfoData(BlockPopInfoData blockPopInfoData) {
        this.mBlockPopInfoData = blockPopInfoData;
    }

    public String cIQ() {
        return this.blockUrl;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }
}
