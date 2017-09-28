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
    private static i fWo;
    private SQLiteDatabase fWp = new j(TbadkCoreApplication.getInst().getApp()).getWritableDatabase();

    public static synchronized i bmX() {
        i iVar;
        synchronized (i.class) {
            if (fWo == null) {
                fWo = new i();
            }
            iVar = fWo;
        }
        return iVar;
    }

    private i() {
    }

    public void ro(String str) {
        new j(TbadkCoreApplication.getInst().getApp()).f(this.fWp, str);
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
        contentValues.put("pagefrom", Integer.valueOf(bVar.fWl));
        contentValues.put("create_video_path", bVar.gbj);
        contentValues.put("sticer_path", bVar.gbk);
        contentValues.put("origin_video_path", bVar.gbi);
        contentValues.put("pic_path", bVar.gbh);
        contentValues.put("mute", Integer.valueOf(bVar.gbf ? 1 : 0));
        contentValues.put("need_pub", Integer.valueOf(bVar.gbl ? 1 : 0));
        contentValues.put("only_pub", Integer.valueOf(bVar.gbm ? 1 : 0));
        contentValues.put("need_composite", Integer.valueOf(bVar.gbn ? 1 : 0));
        contentValues.put(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, "" + System.currentTimeMillis());
        contentValues.put("target_width", Integer.valueOf(bVar.gbo));
        contentValues.put("target_height", Integer.valueOf(bVar.gbp));
        contentValues.put("locate_x", Integer.valueOf(bVar.gbq));
        contentValues.put("locate_y", Integer.valueOf(bVar.gbr));
        return contentValues;
    }

    public boolean b(com.baidu.tieba.story.process.b bVar) {
        ContentValues a;
        String str;
        if (bVar != null && (a = a(bVar)) != null) {
            if (StringUtils.isNull(bVar.gbs)) {
                str = TbadkCoreApplication.getCurrentAccount();
            } else {
                str = bVar.gbs;
            }
            if (this.fWp == null || StringUtils.isNull(str)) {
                return false;
            }
            return cD(bVar.forumId) == null ? ((bVar.state == 3 || bVar.state == 2) && this.fWp.insert(new StringBuilder().append("story_").append(str).toString(), null, a) > 0) ? true : true : this.fWp.update(new StringBuilder().append("story_").append(str).toString(), a, "forum_id = ?", new String[]{new StringBuilder().append("").append(bVar.forumId).toString()}) > 0;
        }
        return false;
    }

    public boolean cC(long j) {
        if (j < 0) {
            return false;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        return (this.fWp == null || StringUtils.isNull(currentAccount) || this.fWp.delete(new StringBuilder().append("story_").append(currentAccount).toString(), "forum_id = ?", new String[]{String.valueOf(j)}) <= 0) ? false : true;
    }

    public com.baidu.tieba.story.process.b cD(long j) {
        Cursor rawQuery;
        com.baidu.tieba.story.process.b bVar = null;
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (this.fWp != null && !StringUtils.isNull(currentAccount) && (rawQuery = this.fWp.rawQuery("SELECT * FROM story_" + currentAccount + " WHERE forum_id=?", new String[]{String.valueOf(j)})) != null && rawQuery.getCount() > 0) {
            if (rawQuery.moveToFirst()) {
                com.baidu.tieba.story.process.b bVar2 = new com.baidu.tieba.story.process.b();
                bVar2.forumId = j;
                bVar2.forumName = rawQuery.getString(rawQuery.getColumnIndex("forum_name"));
                bVar2.fWl = rawQuery.getInt(rawQuery.getColumnIndex("pagefrom"));
                bVar2.type = rawQuery.getInt(rawQuery.getColumnIndex("type"));
                bVar2.state = rawQuery.getInt(rawQuery.getColumnIndex("status"));
                bVar2.gbj = rawQuery.getString(rawQuery.getColumnIndex("create_video_path"));
                bVar2.gbi = rawQuery.getString(rawQuery.getColumnIndex("origin_video_path"));
                bVar2.gbh = rawQuery.getString(rawQuery.getColumnIndex("pic_path"));
                bVar2.gbf = rawQuery.getInt(rawQuery.getColumnIndex("mute")) == 1;
                bVar2.gbl = rawQuery.getInt(rawQuery.getColumnIndex("need_pub")) == 1;
                bVar2.gbm = rawQuery.getInt(rawQuery.getColumnIndex("only_pub")) == 1;
                bVar2.gbn = rawQuery.getInt(rawQuery.getColumnIndex("need_composite")) == 1;
                bVar2.gbk = rawQuery.getString(rawQuery.getColumnIndex("sticer_path"));
                bVar2.timestamp = rawQuery.getString(rawQuery.getColumnIndex(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME));
                bVar2.gbo = rawQuery.getInt(rawQuery.getColumnIndex("target_width"));
                bVar2.gbp = rawQuery.getInt(rawQuery.getColumnIndex("target_height"));
                bVar2.gbq = rawQuery.getInt(rawQuery.getColumnIndex("locate_x"));
                bVar2.gbr = rawQuery.getInt(rawQuery.getColumnIndex("locate_y"));
                bVar = bVar2;
            }
            n.e(rawQuery);
        }
        return bVar;
    }

    public List<com.baidu.tieba.story.process.b> rp(String str) {
        if (this.fWp == null || StringUtils.isNull(str)) {
            return null;
        }
        this.fWp.beginTransaction();
        Cursor rawQuery = this.fWp.rawQuery("SELECT * FROM " + str, null);
        if (rawQuery != null) {
            ArrayList arrayList = new ArrayList();
            while (rawQuery.moveToNext()) {
                com.baidu.tieba.story.process.b bVar = new com.baidu.tieba.story.process.b();
                bVar.forumId = rawQuery.getInt(rawQuery.getColumnIndex("forum_id"));
                bVar.forumName = rawQuery.getString(rawQuery.getColumnIndex("forum_name"));
                bVar.fWl = rawQuery.getInt(rawQuery.getColumnIndex("pagefrom"));
                bVar.type = rawQuery.getInt(rawQuery.getColumnIndex("type"));
                bVar.state = rawQuery.getInt(rawQuery.getColumnIndex("status"));
                bVar.gbj = rawQuery.getString(rawQuery.getColumnIndex("create_video_path"));
                bVar.gbi = rawQuery.getString(rawQuery.getColumnIndex("origin_video_path"));
                bVar.gbh = rawQuery.getString(rawQuery.getColumnIndex("pic_path"));
                bVar.gbf = rawQuery.getInt(rawQuery.getColumnIndex("mute")) == 1;
                bVar.gbl = rawQuery.getInt(rawQuery.getColumnIndex("need_pub")) == 1;
                bVar.gbm = rawQuery.getInt(rawQuery.getColumnIndex("only_pub")) == 1;
                bVar.gbn = rawQuery.getInt(rawQuery.getColumnIndex("need_composite")) == 1;
                bVar.gbk = rawQuery.getString(rawQuery.getColumnIndex("sticer_path"));
                bVar.timestamp = rawQuery.getString(rawQuery.getColumnIndex(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME));
                bVar.gbo = rawQuery.getInt(rawQuery.getColumnIndex("target_width"));
                bVar.gbp = rawQuery.getInt(rawQuery.getColumnIndex("target_height"));
                bVar.gbq = rawQuery.getInt(rawQuery.getColumnIndex("locate_x"));
                bVar.gbr = rawQuery.getInt(rawQuery.getColumnIndex("locate_y"));
                arrayList.add(bVar);
            }
            n.e(rawQuery);
            this.fWp.setTransactionSuccessful();
            this.fWp.endTransaction();
            return arrayList;
        }
        return null;
    }
}
