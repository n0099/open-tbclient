package com.baidu.tieba.model;

import android.content.Context;
import com.baidu.tieba.data.UserData;
import com.baidu.tieba.util.AsyncImageLoader;
import com.baidu.tieba.util.TiebaLog;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class PersonInfoModel {
    private AsyncImageLoader mImageLoader;
    private String mName;
    private long notify_fans;
    private boolean mIsSelf = true;
    private String mId = null;
    private int mMark = 0;
    private UserData mUser = null;
    private boolean mTabPage = false;

    public PersonInfoModel(Context context) {
        setNotify_fans(0L);
        this.mImageLoader = new AsyncImageLoader(context);
    }

    public String getId() {
        return this.mId;
    }

    public void setId(String id) {
        this.mId = id;
    }

    public void setIsSelf(boolean isSelf) {
        this.mIsSelf = isSelf;
    }

    public boolean getIsSelf() {
        return this.mIsSelf;
    }

    public int getMark() {
        return this.mMark;
    }

    public void setMark(int mark) {
        this.mMark = mark;
    }

    public void setUser(UserData user) {
        this.mUser = user;
    }

    public UserData getUser() {
        return this.mUser;
    }

    public void parserJson(String data) {
        try {
            JSONObject json = new JSONObject(data);
            parserJson(json);
        } catch (Exception ex) {
            TiebaLog.e(getClass().getName(), "parserJson", "error = " + ex.getMessage());
        }
    }

    public void parserJson(JSONObject json) {
        if (json != null) {
            try {
                this.mUser = new UserData();
                this.mUser.parserJson(json.optJSONObject("user"));
            } catch (Exception ex) {
                TiebaLog.e(getClass().getName(), "parserJson", "error = " + ex.getMessage());
            }
        }
    }

    public void logPrint() {
        TiebaLog.v(getClass().getName(), "logPrint", "mIsSelf = " + String.valueOf(this.mIsSelf));
        TiebaLog.v(getClass().getName(), "logPrint", "mId = " + this.mId);
        TiebaLog.v(getClass().getName(), "logPrint", "mMark = " + String.valueOf(this.mMark));
        this.mUser.logPrint();
    }

    public void setImageLoader(AsyncImageLoader imageLoader) {
        this.mImageLoader = imageLoader;
    }

    public AsyncImageLoader getImageLoader() {
        return this.mImageLoader;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public String getName() {
        return this.mName;
    }

    public void setNotify_fans(long notify_fans) {
        this.notify_fans = notify_fans;
    }

    public long getNotify_fans() {
        return this.notify_fans;
    }

    public void setTabPage(boolean tabPage) {
        this.mTabPage = tabPage;
    }

    public boolean isTabPage() {
        return this.mTabPage;
    }
}
