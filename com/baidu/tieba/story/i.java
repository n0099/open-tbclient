package com.baidu.tieba.story;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.n;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class i {
    private static i goH;
    private SQLiteDatabase goI = new j(TbadkCoreApplication.getInst().getApp()).getWritableDatabase();

    public static synchronized i brN() {
        i iVar;
        synchronized (i.class) {
            if (goH == null) {
                goH = new i();
            }
            iVar = goH;
        }
        return iVar;
    }

    private i() {
    }

    public void sx(String str) {
        new j(TbadkCoreApplication.getInst().getApp()).f(this.goI, str);
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
        contentValues.put("pagefrom", Integer.valueOf(bVar.eYe));
        contentValues.put("create_video_path", bVar.gtA);
        contentValues.put("sticer_path", bVar.gtB);
        contentValues.put("origin_video_path", bVar.gtz);
        contentValues.put("pic_path", bVar.gty);
        contentValues.put("mute", Integer.valueOf(bVar.gtw ? 1 : 0));
        contentValues.put("need_pub", Integer.valueOf(bVar.gtC ? 1 : 0));
        contentValues.put("only_pub", Integer.valueOf(bVar.gtD ? 1 : 0));
        contentValues.put("need_composite", Integer.valueOf(bVar.gtE ? 1 : 0));
        contentValues.put(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, "" + System.currentTimeMillis());
        contentValues.put("target_width", Integer.valueOf(bVar.gtF));
        contentValues.put("target_height", Integer.valueOf(bVar.gtG));
        contentValues.put("locate_x", Integer.valueOf(bVar.gtH));
        contentValues.put("locate_y", Integer.valueOf(bVar.gtI));
        return contentValues;
    }

    public boolean b(com.baidu.tieba.story.process.b bVar) {
        ContentValues a;
        String str;
        if (bVar != null && (a = a(bVar)) != null) {
            if (StringUtils.isNull(bVar.gtJ)) {
                str = TbadkCoreApplication.getCurrentAccount();
            } else {
                str = bVar.gtJ;
            }
            if (this.goI == null || StringUtils.isNull(str)) {
                return false;
            }
            return cO(bVar.forumId) == null ? ((bVar.state == 3 || bVar.state == 2) && this.goI.insert(new StringBuilder().append("story_").append(str).toString(), null, a) > 0) ? true : true : this.goI.update(new StringBuilder().append("story_").append(str).toString(), a, "forum_id = ?", new String[]{new StringBuilder().append("").append(bVar.forumId).toString()}) > 0;
        }
        return false;
    }

    public boolean cN(long j) {
        if (j < 0) {
            return false;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        return (this.goI == null || StringUtils.isNull(currentAccount) || this.goI.delete(new StringBuilder().append("story_").append(currentAccount).toString(), "forum_id = ?", new String[]{String.valueOf(j)}) <= 0) ? false : true;
    }

    public com.baidu.tieba.story.process.b cO(long j) {
        Cursor rawQuery;
        com.baidu.tieba.story.process.b bVar = null;
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (this.goI != null && !StringUtils.isNull(currentAccount) && (rawQuery = this.goI.rawQuery("SELECT * FROM story_" + currentAccount + " WHERE forum_id=?", new String[]{String.valueOf(j)})) != null && rawQuery.getCount() > 0) {
            if (rawQuery.moveToFirst()) {
                com.baidu.tieba.story.process.b bVar2 = new com.baidu.tieba.story.process.b();
                bVar2.forumId = j;
                bVar2.forumName = rawQuery.getString(rawQuery.getColumnIndex("forum_name"));
                bVar2.eYe = rawQuery.getInt(rawQuery.getColumnIndex("pagefrom"));
                bVar2.type = rawQuery.getInt(rawQuery.getColumnIndex("type"));
                bVar2.state = rawQuery.getInt(rawQuery.getColumnIndex("status"));
                bVar2.gtA = rawQuery.getString(rawQuery.getColumnIndex("create_video_path"));
                bVar2.gtz = rawQuery.getString(rawQuery.getColumnIndex("origin_video_path"));
                bVar2.gty = rawQuery.getString(rawQuery.getColumnIndex("pic_path"));
                bVar2.gtw = rawQuery.getInt(rawQuery.getColumnIndex("mute")) == 1;
                bVar2.gtC = rawQuery.getInt(rawQuery.getColumnIndex("need_pub")) == 1;
                bVar2.gtD = rawQuery.getInt(rawQuery.getColumnIndex("only_pub")) == 1;
                bVar2.gtE = rawQuery.getInt(rawQuery.getColumnIndex("need_composite")) == 1;
                bVar2.gtB = rawQuery.getString(rawQuery.getColumnIndex("sticer_path"));
                bVar2.timestamp = rawQuery.getString(rawQuery.getColumnIndex(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME));
                bVar2.gtF = rawQuery.getInt(rawQuery.getColumnIndex("target_width"));
                bVar2.gtG = rawQuery.getInt(rawQuery.getColumnIndex("target_height"));
                bVar2.gtH = rawQuery.getInt(rawQuery.getColumnIndex("locate_x"));
                bVar2.gtI = rawQuery.getInt(rawQuery.getColumnIndex("locate_y"));
                bVar = bVar2;
            }
            n.e(rawQuery);
        }
        return bVar;
    }

    public List<com.baidu.tieba.story.process.b> sy(String str) {
        if (this.goI == null || StringUtils.isNull(str)) {
            return null;
        }
        this.goI.beginTransaction();
        Cursor rawQuery = this.goI.rawQuery("SELECT * FROM " + str, null);
        if (rawQuery != null) {
            ArrayList arrayList = new ArrayList();
            while (rawQuery.moveToNext()) {
                com.baidu.tieba.story.process.b bVar = new com.baidu.tieba.story.process.b();
                bVar.forumId = rawQuery.getInt(rawQuery.getColumnIndex("forum_id"));
                bVar.forumName = rawQuery.getString(rawQuery.getColumnIndex("forum_name"));
                bVar.eYe = rawQuery.getInt(rawQuery.getColumnIndex("pagefrom"));
                bVar.type = rawQuery.getInt(rawQuery.getColumnIndex("type"));
                bVar.state = rawQuery.getInt(rawQuery.getColumnIndex("status"));
                bVar.gtA = rawQuery.getString(rawQuery.getColumnIndex("create_video_path"));
                bVar.gtz = rawQuery.getString(rawQuery.getColumnIndex("origin_video_path"));
                bVar.gty = rawQuery.getString(rawQuery.getColumnIndex("pic_path"));
                bVar.gtw = rawQuery.getInt(rawQuery.getColumnIndex("mute")) == 1;
                bVar.gtC = rawQuery.getInt(rawQuery.getColumnIndex("need_pub")) == 1;
                bVar.gtD = rawQuery.getInt(rawQuery.getColumnIndex("only_pub")) == 1;
                bVar.gtE = rawQuery.getInt(rawQuery.getColumnIndex("need_composite")) == 1;
                bVar.gtB = rawQuery.getString(rawQuery.getColumnIndex("sticer_path"));
                bVar.timestamp = rawQuery.getString(rawQuery.getColumnIndex(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME));
                bVar.gtF = rawQuery.getInt(rawQuery.getColumnIndex("target_width"));
                bVar.gtG = rawQuery.getInt(rawQuery.getColumnIndex("target_height"));
                bVar.gtH = rawQuery.getInt(rawQuery.getColumnIndex("locate_x"));
                bVar.gtI = rawQuery.getInt(rawQuery.getColumnIndex("locate_y"));
                arrayList.add(bVar);
            }
            n.e(rawQuery);
            this.goI.setTransactionSuccessful();
            this.goI.endTransaction();
            return arrayList;
        }
        return null;
    }
}
