package com.baidu.tieba.im.widget;

import android.text.TextUtils;
import com.baidu.tbadk.data.ShareFromFrsMsgData;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tieba.forumMember.tbtitle.TbTitleActivityConfig;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a<T> {
    private T payload;
    private int subType;
    private String title;

    /* JADX WARN: Type inference failed for: r1v3, types: [com.baidu.tbadk.data.ShareFromFrsMsgData, T] */
    /* JADX WARN: Type inference failed for: r1v4, types: [com.baidu.tbadk.data.ShareFromGameCenterMsgData, T] */
    /* JADX WARN: Type inference failed for: r2v10, types: [T, com.baidu.tbadk.data.ShareFromPBMsgData] */
    public int fx(String str, String str2) {
        int i = -1;
        if (str != null) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                if (jSONArray.length() == 3) {
                    this.title = jSONArray.optString(0);
                    this.subType = jSONArray.optInt(1);
                    JSONObject optJSONObject = jSONArray.optJSONObject(2);
                    if (1 == this.subType) {
                        String optString = optJSONObject.optString("button");
                        String optString2 = optJSONObject.optString("shareSourceIcon");
                        String optString3 = optJSONObject.optString("shareSource");
                        String optString4 = optJSONObject.optString("shareUrl");
                        String optString5 = optJSONObject.optString("shareSourceUrl");
                        if (TextUtils.isEmpty(optString4)) {
                            ?? r2 = (T) new ShareFromPBMsgData();
                            r2.setContent(optJSONObject.optString("themeContent"));
                            r2.setForumName(optJSONObject.optString(TbTitleActivityConfig.FORUM_NAME));
                            r2.setImageUrl(optJSONObject.optString("themeImageUrl"));
                            r2.setPostId(optJSONObject.optString("postID"));
                            r2.setThreadId(optJSONObject.optString("themeID"));
                            r2.setTitle(optJSONObject.optString("themeTitle"));
                            r2.setTheNewThemeId(optJSONObject.optString("theNewThemeID"));
                            r2.setThreadType(optJSONObject.optInt("threadType"));
                            this.payload = r2;
                            i = 0;
                        } else {
                            ?? r1 = (T) new ShareFromGameCenterMsgData();
                            r1.setContent(optJSONObject.optString("themeContent"));
                            r1.setForumName(optJSONObject.optString(TbTitleActivityConfig.FORUM_NAME));
                            r1.setImageUrl(optJSONObject.optString("themeImageUrl"));
                            r1.setPostId(optJSONObject.optString("postID"));
                            r1.setThreadId(optJSONObject.optString("themeID"));
                            r1.setTitle(optJSONObject.optString("themeTitle"));
                            r1.setButton(optString);
                            r1.setShareSource(optString3);
                            r1.setShareSourceIcon(optString2);
                            r1.setShareSourceUrl(optString5);
                            r1.setShareUrl(optString4);
                            this.payload = r1;
                            i = 1;
                        }
                    } else if (4 == this.subType) {
                        ?? r12 = (T) new ShareFromFrsMsgData();
                        r12.setName(optJSONObject.optString(TbTitleActivityConfig.FORUM_NAME));
                        r12.setImageUrl(optJSONObject.optString("themeImageUrl"));
                        r12.setMemberNum(optJSONObject.optInt("memberNum"));
                        r12.setPostNum(optJSONObject.optInt("postNum"));
                        this.payload = r12;
                        i = 2;
                    }
                }
            } catch (Exception e) {
            }
        }
        return i;
    }

    public int getSubType() {
        return this.subType;
    }

    public T cVz() {
        return this.payload;
    }
}
