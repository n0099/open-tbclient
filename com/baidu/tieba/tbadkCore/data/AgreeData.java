package com.baidu.tieba.tbadkCore.data;

import com.baidu.tbadk.core.data.BaijiahaoData;
import java.io.Serializable;
import org.json.JSONObject;
import tbclient.Agree;
/* loaded from: classes.dex */
public class AgreeData implements Serializable {
    public int agreeType;
    public BaijiahaoData baijiahaoData;
    public int cardType;
    public boolean isFromImageViewer;
    public String keyFromHomePage;
    public String mImageViewerFromPage;
    public String nid;
    public String objSource;
    public String recomAbTag;
    public String recomExtra;
    public String recomSource;
    public String recomWeight;
    public long diffAgreeNum = 0;
    public long agreeNum = 0;
    public long disAgreeNum = 0;
    public boolean hasAgree = false;
    public String threadId = "";
    public String forumId = "";
    public String postId = "";
    public boolean isInThread = false;
    public int objType = 0;
    public boolean isInPost = false;
    public long indexOfPic = 0;

    public void parseProtobuf(Agree agree) {
        if (agree != null) {
            this.agreeNum = agree.agree_num == null ? 0L : agree.agree_num.longValue();
            this.disAgreeNum = agree.disagree_num.longValue();
            this.agreeType = agree.agree_type == null ? 0 : agree.agree_type.intValue();
            this.hasAgree = agree.has_agree.intValue() == 1;
            this.diffAgreeNum = agree.diff_agree_num != null ? agree.diff_agree_num.longValue() : 0L;
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.agreeNum = jSONObject.optInt("agree_num");
            this.disAgreeNum = jSONObject.optLong("disagree_num");
            this.agreeType = jSONObject.optInt("agree_type");
            this.hasAgree = jSONObject.optInt("has_agree") == 1;
            this.diffAgreeNum = jSONObject.optLong("diff_agree_num");
        }
    }
}
