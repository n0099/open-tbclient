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
    private static i fXs;
    private SQLiteDatabase fXt = new j(TbadkCoreApplication.getInst().getApp()).getWritableDatabase();

    public static synchronized i bof() {
        i iVar;
        synchronized (i.class) {
            if (fXs == null) {
                fXs = new i();
            }
            iVar = fXs;
        }
        return iVar;
    }

    private i() {
    }

    public void rA(String str) {
        new j(TbadkCoreApplication.getInst().getApp()).f(this.fXt, str);
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
        contentValues.put("pagefrom", Integer.valueOf(bVar.fXp));
        contentValues.put("create_video_path", bVar.gcg);
        contentValues.put("sticer_path", bVar.gch);
        contentValues.put("origin_video_path", bVar.gcf);
        contentValues.put("pic_path", bVar.gce);
        contentValues.put("mute", Integer.valueOf(bVar.gcc ? 1 : 0));
        contentValues.put("need_pub", Integer.valueOf(bVar.gci ? 1 : 0));
        contentValues.put("only_pub", Integer.valueOf(bVar.gcj ? 1 : 0));
        contentValues.put("need_composite", Integer.valueOf(bVar.gck ? 1 : 0));
        contentValues.put(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, "" + System.currentTimeMillis());
        contentValues.put("target_width", Integer.valueOf(bVar.gcl));
        contentValues.put("target_height", Integer.valueOf(bVar.gcm));
        contentValues.put("locate_x", Integer.valueOf(bVar.gcn));
        contentValues.put("locate_y", Integer.valueOf(bVar.gco));
        return contentValues;
    }

    public boolean b(com.baidu.tieba.story.process.b bVar) {
        ContentValues a;
        String str;
        if (bVar != null && (a = a(bVar)) != null) {
            if (StringUtils.isNull(bVar.gcp)) {
                str = TbadkCoreApplication.getCurrentAccount();
            } else {
                str = bVar.gcp;
            }
            if (this.fXt == null || StringUtils.isNull(str)) {
                return false;
            }
            return cK(bVar.forumId) == null ? ((bVar.state == 3 || bVar.state == 2) && this.fXt.insert(new StringBuilder().append("story_").append(str).toString(), null, a) > 0) ? true : true : this.fXt.update(new StringBuilder().append("story_").append(str).toString(), a, "forum_id = ?", new String[]{new StringBuilder().append("").append(bVar.forumId).toString()}) > 0;
        }
        return false;
    }

    public boolean cJ(long j) {
        if (j < 0) {
            return false;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        return (this.fXt == null || StringUtils.isNull(currentAccount) || this.fXt.delete(new StringBuilder().append("story_").append(currentAccount).toString(), "forum_id = ?", new String[]{String.valueOf(j)}) <= 0) ? false : true;
    }

    public com.baidu.tieba.story.process.b cK(long j) {
        Cursor rawQuery;
        com.baidu.tieba.story.process.b bVar = null;
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (this.fXt != null && !StringUtils.isNull(currentAccount) && (rawQuery = this.fXt.rawQuery("SELECT * FROM story_" + currentAccount + " WHERE forum_id=?", new String[]{String.valueOf(j)})) != null && rawQuery.getCount() > 0) {
            if (rawQuery.moveToFirst()) {
                com.baidu.tieba.story.process.b bVar2 = new com.baidu.tieba.story.process.b();
                bVar2.forumId = j;
                bVar2.forumName = rawQuery.getString(rawQuery.getColumnIndex("forum_name"));
                bVar2.fXp = rawQuery.getInt(rawQuery.getColumnIndex("pagefrom"));
                bVar2.type = rawQuery.getInt(rawQuery.getColumnIndex("type"));
                bVar2.state = rawQuery.getInt(rawQuery.getColumnIndex("status"));
                bVar2.gcg = rawQuery.getString(rawQuery.getColumnIndex("create_video_path"));
                bVar2.gcf = rawQuery.getString(rawQuery.getColumnIndex("origin_video_path"));
                bVar2.gce = rawQuery.getString(rawQuery.getColumnIndex("pic_path"));
                bVar2.gcc = rawQuery.getInt(rawQuery.getColumnIndex("mute")) == 1;
                bVar2.gci = rawQuery.getInt(rawQuery.getColumnIndex("need_pub")) == 1;
                bVar2.gcj = rawQuery.getInt(rawQuery.getColumnIndex("only_pub")) == 1;
                bVar2.gck = rawQuery.getInt(rawQuery.getColumnIndex("need_composite")) == 1;
                bVar2.gch = rawQuery.getString(rawQuery.getColumnIndex("sticer_path"));
                bVar2.timestamp = rawQuery.getString(rawQuery.getColumnIndex(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME));
                bVar2.gcl = rawQuery.getInt(rawQuery.getColumnIndex("target_width"));
                bVar2.gcm = rawQuery.getInt(rawQuery.getColumnIndex("target_height"));
                bVar2.gcn = rawQuery.getInt(rawQuery.getColumnIndex("locate_x"));
                bVar2.gco = rawQuery.getInt(rawQuery.getColumnIndex("locate_y"));
                bVar = bVar2;
            }
            com.baidu.adp.lib.util.m.e(rawQuery);
        }
        return bVar;
    }

    public List<com.baidu.tieba.story.process.b> rB(String str) {
        if (this.fXt == null || StringUtils.isNull(str)) {
            return null;
        }
        this.fXt.beginTransaction();
        Cursor rawQuery = this.fXt.rawQuery("SELECT * FROM " + str, null);
        if (rawQuery != null) {
            ArrayList arrayList = new ArrayList();
            while (rawQuery.moveToNext()) {
                com.baidu.tieba.story.process.b bVar = new com.baidu.tieba.story.process.b();
                bVar.forumId = rawQuery.getInt(rawQuery.getColumnIndex("forum_id"));
                bVar.forumName = rawQuery.getString(rawQuery.getColumnIndex("forum_name"));
                bVar.fXp = rawQuery.getInt(rawQuery.getColumnIndex("pagefrom"));
                bVar.type = rawQuery.getInt(rawQuery.getColumnIndex("type"));
                bVar.state = rawQuery.getInt(rawQuery.getColumnIndex("status"));
                bVar.gcg = rawQuery.getString(rawQuery.getColumnIndex("create_video_path"));
                bVar.gcf = rawQuery.getString(rawQuery.getColumnIndex("origin_video_path"));
                bVar.gce = rawQuery.getString(rawQuery.getColumnIndex("pic_path"));
                bVar.gcc = rawQuery.getInt(rawQuery.getColumnIndex("mute")) == 1;
                bVar.gci = rawQuery.getInt(rawQuery.getColumnIndex("need_pub")) == 1;
                bVar.gcj = rawQuery.getInt(rawQuery.getColumnIndex("only_pub")) == 1;
                bVar.gck = rawQuery.getInt(rawQuery.getColumnIndex("need_composite")) == 1;
                bVar.gch = rawQuery.getString(rawQuery.getColumnIndex("sticer_path"));
                bVar.timestamp = rawQuery.getString(rawQuery.getColumnIndex(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME));
                bVar.gcl = rawQuery.getInt(rawQuery.getColumnIndex("target_width"));
                bVar.gcm = rawQuery.getInt(rawQuery.getColumnIndex("target_height"));
                bVar.gcn = rawQuery.getInt(rawQuery.getColumnIndex("locate_x"));
                bVar.gco = rawQuery.getInt(rawQuery.getColumnIndex("locate_y"));
                arrayList.add(bVar);
            }
            com.baidu.adp.lib.util.m.e(rawQuery);
            this.fXt.setTransactionSuccessful();
            this.fXt.endTransaction();
            return arrayList;
        }
        return null;
    }
}
