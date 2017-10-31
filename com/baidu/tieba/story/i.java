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
    private static i geN;
    private SQLiteDatabase geO = new j(TbadkCoreApplication.getInst().getApp()).getWritableDatabase();

    public static synchronized i bpU() {
        i iVar;
        synchronized (i.class) {
            if (geN == null) {
                geN = new i();
            }
            iVar = geN;
        }
        return iVar;
    }

    private i() {
    }

    public void rV(String str) {
        new j(TbadkCoreApplication.getInst().getApp()).f(this.geO, str);
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
        contentValues.put("pagefrom", Integer.valueOf(bVar.geK));
        contentValues.put("create_video_path", bVar.gjH);
        contentValues.put("sticer_path", bVar.gjI);
        contentValues.put("origin_video_path", bVar.gjG);
        contentValues.put("pic_path", bVar.gjF);
        contentValues.put("mute", Integer.valueOf(bVar.gjD ? 1 : 0));
        contentValues.put("need_pub", Integer.valueOf(bVar.gjJ ? 1 : 0));
        contentValues.put("only_pub", Integer.valueOf(bVar.gjK ? 1 : 0));
        contentValues.put("need_composite", Integer.valueOf(bVar.gjL ? 1 : 0));
        contentValues.put(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, "" + System.currentTimeMillis());
        contentValues.put("target_width", Integer.valueOf(bVar.gjM));
        contentValues.put("target_height", Integer.valueOf(bVar.gjN));
        contentValues.put("locate_x", Integer.valueOf(bVar.gjO));
        contentValues.put("locate_y", Integer.valueOf(bVar.gjP));
        return contentValues;
    }

    public boolean b(com.baidu.tieba.story.process.b bVar) {
        ContentValues a;
        String str;
        if (bVar != null && (a = a(bVar)) != null) {
            if (StringUtils.isNull(bVar.gjQ)) {
                str = TbadkCoreApplication.getCurrentAccount();
            } else {
                str = bVar.gjQ;
            }
            if (this.geO == null || StringUtils.isNull(str)) {
                return false;
            }
            return cF(bVar.forumId) == null ? ((bVar.state == 3 || bVar.state == 2) && this.geO.insert(new StringBuilder().append("story_").append(str).toString(), null, a) > 0) ? true : true : this.geO.update(new StringBuilder().append("story_").append(str).toString(), a, "forum_id = ?", new String[]{new StringBuilder().append("").append(bVar.forumId).toString()}) > 0;
        }
        return false;
    }

    public boolean cE(long j) {
        if (j < 0) {
            return false;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        return (this.geO == null || StringUtils.isNull(currentAccount) || this.geO.delete(new StringBuilder().append("story_").append(currentAccount).toString(), "forum_id = ?", new String[]{String.valueOf(j)}) <= 0) ? false : true;
    }

    public com.baidu.tieba.story.process.b cF(long j) {
        Cursor rawQuery;
        com.baidu.tieba.story.process.b bVar = null;
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (this.geO != null && !StringUtils.isNull(currentAccount) && (rawQuery = this.geO.rawQuery("SELECT * FROM story_" + currentAccount + " WHERE forum_id=?", new String[]{String.valueOf(j)})) != null && rawQuery.getCount() > 0) {
            if (rawQuery.moveToFirst()) {
                com.baidu.tieba.story.process.b bVar2 = new com.baidu.tieba.story.process.b();
                bVar2.forumId = j;
                bVar2.forumName = rawQuery.getString(rawQuery.getColumnIndex("forum_name"));
                bVar2.geK = rawQuery.getInt(rawQuery.getColumnIndex("pagefrom"));
                bVar2.type = rawQuery.getInt(rawQuery.getColumnIndex("type"));
                bVar2.state = rawQuery.getInt(rawQuery.getColumnIndex("status"));
                bVar2.gjH = rawQuery.getString(rawQuery.getColumnIndex("create_video_path"));
                bVar2.gjG = rawQuery.getString(rawQuery.getColumnIndex("origin_video_path"));
                bVar2.gjF = rawQuery.getString(rawQuery.getColumnIndex("pic_path"));
                bVar2.gjD = rawQuery.getInt(rawQuery.getColumnIndex("mute")) == 1;
                bVar2.gjJ = rawQuery.getInt(rawQuery.getColumnIndex("need_pub")) == 1;
                bVar2.gjK = rawQuery.getInt(rawQuery.getColumnIndex("only_pub")) == 1;
                bVar2.gjL = rawQuery.getInt(rawQuery.getColumnIndex("need_composite")) == 1;
                bVar2.gjI = rawQuery.getString(rawQuery.getColumnIndex("sticer_path"));
                bVar2.timestamp = rawQuery.getString(rawQuery.getColumnIndex(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME));
                bVar2.gjM = rawQuery.getInt(rawQuery.getColumnIndex("target_width"));
                bVar2.gjN = rawQuery.getInt(rawQuery.getColumnIndex("target_height"));
                bVar2.gjO = rawQuery.getInt(rawQuery.getColumnIndex("locate_x"));
                bVar2.gjP = rawQuery.getInt(rawQuery.getColumnIndex("locate_y"));
                bVar = bVar2;
            }
            n.e(rawQuery);
        }
        return bVar;
    }

    public List<com.baidu.tieba.story.process.b> rW(String str) {
        if (this.geO == null || StringUtils.isNull(str)) {
            return null;
        }
        this.geO.beginTransaction();
        Cursor rawQuery = this.geO.rawQuery("SELECT * FROM " + str, null);
        if (rawQuery != null) {
            ArrayList arrayList = new ArrayList();
            while (rawQuery.moveToNext()) {
                com.baidu.tieba.story.process.b bVar = new com.baidu.tieba.story.process.b();
                bVar.forumId = rawQuery.getInt(rawQuery.getColumnIndex("forum_id"));
                bVar.forumName = rawQuery.getString(rawQuery.getColumnIndex("forum_name"));
                bVar.geK = rawQuery.getInt(rawQuery.getColumnIndex("pagefrom"));
                bVar.type = rawQuery.getInt(rawQuery.getColumnIndex("type"));
                bVar.state = rawQuery.getInt(rawQuery.getColumnIndex("status"));
                bVar.gjH = rawQuery.getString(rawQuery.getColumnIndex("create_video_path"));
                bVar.gjG = rawQuery.getString(rawQuery.getColumnIndex("origin_video_path"));
                bVar.gjF = rawQuery.getString(rawQuery.getColumnIndex("pic_path"));
                bVar.gjD = rawQuery.getInt(rawQuery.getColumnIndex("mute")) == 1;
                bVar.gjJ = rawQuery.getInt(rawQuery.getColumnIndex("need_pub")) == 1;
                bVar.gjK = rawQuery.getInt(rawQuery.getColumnIndex("only_pub")) == 1;
                bVar.gjL = rawQuery.getInt(rawQuery.getColumnIndex("need_composite")) == 1;
                bVar.gjI = rawQuery.getString(rawQuery.getColumnIndex("sticer_path"));
                bVar.timestamp = rawQuery.getString(rawQuery.getColumnIndex(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME));
                bVar.gjM = rawQuery.getInt(rawQuery.getColumnIndex("target_width"));
                bVar.gjN = rawQuery.getInt(rawQuery.getColumnIndex("target_height"));
                bVar.gjO = rawQuery.getInt(rawQuery.getColumnIndex("locate_x"));
                bVar.gjP = rawQuery.getInt(rawQuery.getColumnIndex("locate_y"));
                arrayList.add(bVar);
            }
            n.e(rawQuery);
            this.geO.setTransactionSuccessful();
            this.geO.endTransaction();
            return arrayList;
        }
        return null;
    }
}
