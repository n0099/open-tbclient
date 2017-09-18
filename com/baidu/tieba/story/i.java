package com.baidu.tieba.story;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class i {
    private static i fYK;
    private SQLiteDatabase fYL = new j(TbadkCoreApplication.getInst().getApp()).getWritableDatabase();

    public static synchronized i bod() {
        i iVar;
        synchronized (i.class) {
            if (fYK == null) {
                fYK = new i();
            }
            iVar = fYK;
        }
        return iVar;
    }

    private i() {
    }

    public void rE(String str) {
        new j(TbadkCoreApplication.getInst().getApp()).f(this.fYL, str);
    }

    private ContentValues a(com.baidu.tieba.story.process.b bVar) {
        if (bVar == null) {
            return null;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("forum_id", Long.valueOf(bVar.forumId));
        contentValues.put("forum_name", bVar.forumName);
        contentValues.put("status", Integer.valueOf(bVar.state));
        contentValues.put("type", Integer.valueOf(bVar.type));
        contentValues.put("pagefrom", Integer.valueOf(bVar.fYH));
        contentValues.put("create_video_path", bVar.gdC);
        contentValues.put("sticer_path", bVar.gdD);
        contentValues.put("origin_video_path", bVar.gdB);
        contentValues.put("pic_path", bVar.gdA);
        contentValues.put("mute", Integer.valueOf(bVar.gdy ? 1 : 0));
        contentValues.put("need_pub", Integer.valueOf(bVar.gdE ? 1 : 0));
        contentValues.put("only_pub", Integer.valueOf(bVar.gdF ? 1 : 0));
        contentValues.put("need_composite", Integer.valueOf(bVar.gdG ? 1 : 0));
        contentValues.put(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, "" + System.currentTimeMillis());
        contentValues.put("target_width", Integer.valueOf(bVar.gdH));
        contentValues.put("target_height", Integer.valueOf(bVar.gdI));
        contentValues.put("locate_x", Integer.valueOf(bVar.gdJ));
        contentValues.put("locate_y", Integer.valueOf(bVar.gdK));
        return contentValues;
    }

    public boolean b(com.baidu.tieba.story.process.b bVar) {
        ContentValues a;
        String str;
        if (bVar != null && (a = a(bVar)) != null) {
            if (StringUtils.isNull(bVar.gdL)) {
                str = TbadkCoreApplication.getCurrentAccount();
            } else {
                str = bVar.gdL;
            }
            if (this.fYL == null || StringUtils.isNull(str)) {
                return false;
            }
            return cF(bVar.forumId) == null ? ((bVar.state == 3 || bVar.state == 2) && this.fYL.insert(new StringBuilder().append("story_").append(str).toString(), null, a) > 0) ? true : true : this.fYL.update(new StringBuilder().append("story_").append(str).toString(), a, "forum_id = ?", new String[]{new StringBuilder().append("").append(bVar.forumId).toString()}) > 0;
        }
        return false;
    }

    public boolean cE(long j) {
        if (j < 0) {
            return false;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        return (this.fYL == null || StringUtils.isNull(currentAccount) || this.fYL.delete(new StringBuilder().append("story_").append(currentAccount).toString(), "forum_id = ?", new String[]{String.valueOf(j)}) <= 0) ? false : true;
    }

    public com.baidu.tieba.story.process.b cF(long j) {
        Cursor rawQuery;
        com.baidu.tieba.story.process.b bVar = null;
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (this.fYL != null && !StringUtils.isNull(currentAccount) && (rawQuery = this.fYL.rawQuery("SELECT * FROM story_" + currentAccount + " WHERE forum_id=?", new String[]{String.valueOf(j)})) != null && rawQuery.getCount() > 0) {
            if (rawQuery.moveToFirst()) {
                com.baidu.tieba.story.process.b bVar2 = new com.baidu.tieba.story.process.b();
                bVar2.forumId = j;
                bVar2.forumName = rawQuery.getString(rawQuery.getColumnIndex("forum_name"));
                bVar2.fYH = rawQuery.getInt(rawQuery.getColumnIndex("pagefrom"));
                bVar2.type = rawQuery.getInt(rawQuery.getColumnIndex("type"));
                bVar2.state = rawQuery.getInt(rawQuery.getColumnIndex("status"));
                bVar2.gdC = rawQuery.getString(rawQuery.getColumnIndex("create_video_path"));
                bVar2.gdB = rawQuery.getString(rawQuery.getColumnIndex("origin_video_path"));
                bVar2.gdA = rawQuery.getString(rawQuery.getColumnIndex("pic_path"));
                bVar2.gdy = rawQuery.getInt(rawQuery.getColumnIndex("mute")) == 1;
                bVar2.gdE = rawQuery.getInt(rawQuery.getColumnIndex("need_pub")) == 1;
                bVar2.gdF = rawQuery.getInt(rawQuery.getColumnIndex("only_pub")) == 1;
                bVar2.gdG = rawQuery.getInt(rawQuery.getColumnIndex("need_composite")) == 1;
                bVar2.gdD = rawQuery.getString(rawQuery.getColumnIndex("sticer_path"));
                bVar2.timestamp = rawQuery.getString(rawQuery.getColumnIndex(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME));
                bVar2.gdH = rawQuery.getInt(rawQuery.getColumnIndex("target_width"));
                bVar2.gdI = rawQuery.getInt(rawQuery.getColumnIndex("target_height"));
                bVar2.gdJ = rawQuery.getInt(rawQuery.getColumnIndex("locate_x"));
                bVar2.gdK = rawQuery.getInt(rawQuery.getColumnIndex("locate_y"));
                bVar = bVar2;
            }
            com.baidu.adp.lib.util.m.e(rawQuery);
        }
        return bVar;
    }

    public List<com.baidu.tieba.story.process.b> rF(String str) {
        if (this.fYL == null || StringUtils.isNull(str)) {
            return null;
        }
        this.fYL.beginTransaction();
        Cursor rawQuery = this.fYL.rawQuery("SELECT * FROM " + str, null);
        if (rawQuery != null) {
            ArrayList arrayList = new ArrayList();
            while (rawQuery.moveToNext()) {
                com.baidu.tieba.story.process.b bVar = new com.baidu.tieba.story.process.b();
                bVar.forumId = rawQuery.getInt(rawQuery.getColumnIndex("forum_id"));
                bVar.forumName = rawQuery.getString(rawQuery.getColumnIndex("forum_name"));
                bVar.fYH = rawQuery.getInt(rawQuery.getColumnIndex("pagefrom"));
                bVar.type = rawQuery.getInt(rawQuery.getColumnIndex("type"));
                bVar.state = rawQuery.getInt(rawQuery.getColumnIndex("status"));
                bVar.gdC = rawQuery.getString(rawQuery.getColumnIndex("create_video_path"));
                bVar.gdB = rawQuery.getString(rawQuery.getColumnIndex("origin_video_path"));
                bVar.gdA = rawQuery.getString(rawQuery.getColumnIndex("pic_path"));
                bVar.gdy = rawQuery.getInt(rawQuery.getColumnIndex("mute")) == 1;
                bVar.gdE = rawQuery.getInt(rawQuery.getColumnIndex("need_pub")) == 1;
                bVar.gdF = rawQuery.getInt(rawQuery.getColumnIndex("only_pub")) == 1;
                bVar.gdG = rawQuery.getInt(rawQuery.getColumnIndex("need_composite")) == 1;
                bVar.gdD = rawQuery.getString(rawQuery.getColumnIndex("sticer_path"));
                bVar.timestamp = rawQuery.getString(rawQuery.getColumnIndex(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME));
                bVar.gdH = rawQuery.getInt(rawQuery.getColumnIndex("target_width"));
                bVar.gdI = rawQuery.getInt(rawQuery.getColumnIndex("target_height"));
                bVar.gdJ = rawQuery.getInt(rawQuery.getColumnIndex("locate_x"));
                bVar.gdK = rawQuery.getInt(rawQuery.getColumnIndex("locate_y"));
                arrayList.add(bVar);
            }
            com.baidu.adp.lib.util.m.e(rawQuery);
            this.fYL.setTransactionSuccessful();
            this.fYL.endTransaction();
            return arrayList;
        }
        return null;
    }
}
