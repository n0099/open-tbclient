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
    private static i fZm;
    private SQLiteDatabase fZn = new j(TbadkCoreApplication.getInst().getApp()).getWritableDatabase();

    public static synchronized i boE() {
        i iVar;
        synchronized (i.class) {
            if (fZm == null) {
                fZm = new i();
            }
            iVar = fZm;
        }
        return iVar;
    }

    private i() {
    }

    public void rH(String str) {
        new j(TbadkCoreApplication.getInst().getApp()).f(this.fZn, str);
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
        contentValues.put("pagefrom", Integer.valueOf(bVar.fZj));
        contentValues.put("create_video_path", bVar.gdY);
        contentValues.put("sticer_path", bVar.gdZ);
        contentValues.put("origin_video_path", bVar.gdX);
        contentValues.put("pic_path", bVar.gdW);
        contentValues.put("mute", Integer.valueOf(bVar.gdU ? 1 : 0));
        contentValues.put("need_pub", Integer.valueOf(bVar.gea ? 1 : 0));
        contentValues.put("only_pub", Integer.valueOf(bVar.geb ? 1 : 0));
        contentValues.put("need_composite", Integer.valueOf(bVar.gec ? 1 : 0));
        contentValues.put(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, "" + System.currentTimeMillis());
        contentValues.put("target_width", Integer.valueOf(bVar.ged));
        contentValues.put("target_height", Integer.valueOf(bVar.gee));
        contentValues.put("locate_x", Integer.valueOf(bVar.gef));
        contentValues.put("locate_y", Integer.valueOf(bVar.geg));
        return contentValues;
    }

    public boolean b(com.baidu.tieba.story.process.b bVar) {
        ContentValues a;
        String str;
        if (bVar != null && (a = a(bVar)) != null) {
            if (StringUtils.isNull(bVar.geh)) {
                str = TbadkCoreApplication.getCurrentAccount();
            } else {
                str = bVar.geh;
            }
            if (this.fZn == null || StringUtils.isNull(str)) {
                return false;
            }
            return cK(bVar.forumId) == null ? ((bVar.state == 3 || bVar.state == 2) && this.fZn.insert(new StringBuilder().append("story_").append(str).toString(), null, a) > 0) ? true : true : this.fZn.update(new StringBuilder().append("story_").append(str).toString(), a, "forum_id = ?", new String[]{new StringBuilder().append("").append(bVar.forumId).toString()}) > 0;
        }
        return false;
    }

    public boolean cJ(long j) {
        if (j < 0) {
            return false;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        return (this.fZn == null || StringUtils.isNull(currentAccount) || this.fZn.delete(new StringBuilder().append("story_").append(currentAccount).toString(), "forum_id = ?", new String[]{String.valueOf(j)}) <= 0) ? false : true;
    }

    public com.baidu.tieba.story.process.b cK(long j) {
        Cursor rawQuery;
        com.baidu.tieba.story.process.b bVar = null;
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (this.fZn != null && !StringUtils.isNull(currentAccount) && (rawQuery = this.fZn.rawQuery("SELECT * FROM story_" + currentAccount + " WHERE forum_id=?", new String[]{String.valueOf(j)})) != null && rawQuery.getCount() > 0) {
            if (rawQuery.moveToFirst()) {
                com.baidu.tieba.story.process.b bVar2 = new com.baidu.tieba.story.process.b();
                bVar2.forumId = j;
                bVar2.forumName = rawQuery.getString(rawQuery.getColumnIndex("forum_name"));
                bVar2.fZj = rawQuery.getInt(rawQuery.getColumnIndex("pagefrom"));
                bVar2.type = rawQuery.getInt(rawQuery.getColumnIndex("type"));
                bVar2.state = rawQuery.getInt(rawQuery.getColumnIndex("status"));
                bVar2.gdY = rawQuery.getString(rawQuery.getColumnIndex("create_video_path"));
                bVar2.gdX = rawQuery.getString(rawQuery.getColumnIndex("origin_video_path"));
                bVar2.gdW = rawQuery.getString(rawQuery.getColumnIndex("pic_path"));
                bVar2.gdU = rawQuery.getInt(rawQuery.getColumnIndex("mute")) == 1;
                bVar2.gea = rawQuery.getInt(rawQuery.getColumnIndex("need_pub")) == 1;
                bVar2.geb = rawQuery.getInt(rawQuery.getColumnIndex("only_pub")) == 1;
                bVar2.gec = rawQuery.getInt(rawQuery.getColumnIndex("need_composite")) == 1;
                bVar2.gdZ = rawQuery.getString(rawQuery.getColumnIndex("sticer_path"));
                bVar2.timestamp = rawQuery.getString(rawQuery.getColumnIndex(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME));
                bVar2.ged = rawQuery.getInt(rawQuery.getColumnIndex("target_width"));
                bVar2.gee = rawQuery.getInt(rawQuery.getColumnIndex("target_height"));
                bVar2.gef = rawQuery.getInt(rawQuery.getColumnIndex("locate_x"));
                bVar2.geg = rawQuery.getInt(rawQuery.getColumnIndex("locate_y"));
                bVar = bVar2;
            }
            com.baidu.adp.lib.util.m.e(rawQuery);
        }
        return bVar;
    }

    public List<com.baidu.tieba.story.process.b> rI(String str) {
        if (this.fZn == null || StringUtils.isNull(str)) {
            return null;
        }
        this.fZn.beginTransaction();
        Cursor rawQuery = this.fZn.rawQuery("SELECT * FROM " + str, null);
        if (rawQuery != null) {
            ArrayList arrayList = new ArrayList();
            while (rawQuery.moveToNext()) {
                com.baidu.tieba.story.process.b bVar = new com.baidu.tieba.story.process.b();
                bVar.forumId = rawQuery.getInt(rawQuery.getColumnIndex("forum_id"));
                bVar.forumName = rawQuery.getString(rawQuery.getColumnIndex("forum_name"));
                bVar.fZj = rawQuery.getInt(rawQuery.getColumnIndex("pagefrom"));
                bVar.type = rawQuery.getInt(rawQuery.getColumnIndex("type"));
                bVar.state = rawQuery.getInt(rawQuery.getColumnIndex("status"));
                bVar.gdY = rawQuery.getString(rawQuery.getColumnIndex("create_video_path"));
                bVar.gdX = rawQuery.getString(rawQuery.getColumnIndex("origin_video_path"));
                bVar.gdW = rawQuery.getString(rawQuery.getColumnIndex("pic_path"));
                bVar.gdU = rawQuery.getInt(rawQuery.getColumnIndex("mute")) == 1;
                bVar.gea = rawQuery.getInt(rawQuery.getColumnIndex("need_pub")) == 1;
                bVar.geb = rawQuery.getInt(rawQuery.getColumnIndex("only_pub")) == 1;
                bVar.gec = rawQuery.getInt(rawQuery.getColumnIndex("need_composite")) == 1;
                bVar.gdZ = rawQuery.getString(rawQuery.getColumnIndex("sticer_path"));
                bVar.timestamp = rawQuery.getString(rawQuery.getColumnIndex(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME));
                bVar.ged = rawQuery.getInt(rawQuery.getColumnIndex("target_width"));
                bVar.gee = rawQuery.getInt(rawQuery.getColumnIndex("target_height"));
                bVar.gef = rawQuery.getInt(rawQuery.getColumnIndex("locate_x"));
                bVar.geg = rawQuery.getInt(rawQuery.getColumnIndex("locate_y"));
                arrayList.add(bVar);
            }
            com.baidu.adp.lib.util.m.e(rawQuery);
            this.fZn.setTransactionSuccessful();
            this.fZn.endTransaction();
            return arrayList;
        }
        return null;
    }
}
