package com.baidu.tieba.model;

import android.content.Context;
import com.baidu.tieba.data.AntiData;
import com.baidu.tieba.data.ForumData;
import com.baidu.tieba.data.PostData;
import com.baidu.tieba.data.SubPbData;
import com.baidu.tieba.data.ThreadData;
import com.baidu.tieba.util.TiebaLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class SubPbModel {
    private Context mContext;
    private SubPbData mSubPbData = new SubPbData();

    public SubPbModel(Context context) {
        this.mContext = context;
    }

    public SubPbModel(Context context, String result) {
        this.mContext = context;
        parseJson(result);
    }

    private void parseJson(String result) {
        try {
            JSONObject json = new JSONObject(result);
            JSONObject post = json.optJSONObject("post");
            JSONArray subPosts = json.optJSONArray("subpost_list");
            JSONObject forum = json.optJSONObject("forum");
            JSONObject thread = json.optJSONObject("thread");
            JSONObject anti = json.optJSONObject("anti");
            AntiData antiData = new AntiData();
            antiData.parserJson(anti);
            this.mSubPbData.setAntiData(antiData);
            ThreadData threadData = new ThreadData();
            threadData.parserJson(thread);
            this.mSubPbData.setThreadData(threadData);
            ForumData forumData = new ForumData();
            forumData.parserJson(forum);
            this.mSubPbData.setForumData(forumData);
            PostData postData = new PostData();
            postData.parserJson(post);
            postData.uniteContentExcepFace(this.mContext);
            this.mSubPbData.setPostData(postData);
            int size = subPosts.length();
            List<PostData> subPostList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                JSONObject item = subPosts.getJSONObject(i);
                PostData data = new PostData();
                data.parserJson(item);
                data.uniteContentExcepFace(this.mContext);
                subPostList.add(data);
            }
            this.mSubPbData.setSubPbList(subPostList);
            JSONObject page = json.optJSONObject("page");
            int totalPage = page.optInt("total_page");
            int pageSize = page.optInt("page_size");
            int currentPage = page.optInt("current_page");
            int totalCount = page.optInt("total_count");
            this.mSubPbData.setCurrentPage(currentPage);
            this.mSubPbData.setPageSize(pageSize);
            this.mSubPbData.setTotalCount(totalCount);
            this.mSubPbData.setTotalPage(totalPage);
        } catch (Exception ex) {
            TiebaLog.e("SubPbModel", "parseJson", "error = " + ex.getMessage());
        }
    }

    public SubPbData getSubPbData() {
        return this.mSubPbData;
    }
}
