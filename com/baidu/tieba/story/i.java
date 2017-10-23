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
    private static i fVZ;
    private SQLiteDatabase fWa = new j(TbadkCoreApplication.getInst().getApp()).getWritableDatabase();

    public static synchronized i bmP() {
        i iVar;
        synchronized (i.class) {
            if (fVZ == null) {
                fVZ = new i();
            }
            iVar = fVZ;
        }
        return iVar;
    }

    private i() {
    }

    public void rn(String str) {
        new j(TbadkCoreApplication.getInst().getApp()).f(this.fWa, str);
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
        contentValues.put("pagefrom", Integer.valueOf(bVar.fVW));
        contentValues.put("create_video_path", bVar.gaU);
        contentValues.put("sticer_path", bVar.gaV);
        contentValues.put("origin_video_path", bVar.gaT);
        contentValues.put("pic_path", bVar.gaS);
        contentValues.put("mute", Integer.valueOf(bVar.gaQ ? 1 : 0));
        contentValues.put("need_pub", Integer.valueOf(bVar.gaW ? 1 : 0));
        contentValues.put("only_pub", Integer.valueOf(bVar.gaX ? 1 : 0));
        contentValues.put("need_composite", Integer.valueOf(bVar.gaY ? 1 : 0));
        contentValues.put(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, "" + System.currentTimeMillis());
        contentValues.put("target_width", Integer.valueOf(bVar.gaZ));
        contentValues.put("target_height", Integer.valueOf(bVar.gba));
        contentValues.put("locate_x", Integer.valueOf(bVar.gbb));
        contentValues.put("locate_y", Integer.valueOf(bVar.gbc));
        return contentValues;
    }

    public boolean b(com.baidu.tieba.story.process.b bVar) {
        ContentValues a;
        String str;
        if (bVar != null && (a = a(bVar)) != null) {
            if (StringUtils.isNull(bVar.gbd)) {
                str = TbadkCoreApplication.getCurrentAccount();
            } else {
                str = bVar.gbd;
            }
            if (this.fWa == null || StringUtils.isNull(str)) {
                return false;
            }
            return cE(bVar.forumId) == null ? ((bVar.state == 3 || bVar.state == 2) && this.fWa.insert(new StringBuilder().append("story_").append(str).toString(), null, a) > 0) ? true : true : this.fWa.update(new StringBuilder().append("story_").append(str).toString(), a, "forum_id = ?", new String[]{new StringBuilder().append("").append(bVar.forumId).toString()}) > 0;
        }
        return false;
    }

    public boolean cD(long j) {
        if (j < 0) {
            return false;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        return (this.fWa == null || StringUtils.isNull(currentAccount) || this.fWa.delete(new StringBuilder().append("story_").append(currentAccount).toString(), "forum_id = ?", new String[]{String.valueOf(j)}) <= 0) ? false : true;
    }

    public com.baidu.tieba.story.process.b cE(long j) {
        Cursor rawQuery;
        com.baidu.tieba.story.process.b bVar = null;
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (this.fWa != null && !StringUtils.isNull(currentAccount) && (rawQuery = this.fWa.rawQuery("SELECT * FROM story_" + currentAccount + " WHERE forum_id=?", new String[]{String.valueOf(j)})) != null && rawQuery.getCount() > 0) {
            if (rawQuery.moveToFirst()) {
                com.baidu.tieba.story.process.b bVar2 = new com.baidu.tieba.story.process.b();
                bVar2.forumId = j;
                bVar2.forumName = rawQuery.getString(rawQuery.getColumnIndex("forum_name"));
                bVar2.fVW = rawQuery.getInt(rawQuery.getColumnIndex("pagefrom"));
                bVar2.type = rawQuery.getInt(rawQuery.getColumnIndex("type"));
                bVar2.state = rawQuery.getInt(rawQuery.getColumnIndex("status"));
                bVar2.gaU = rawQuery.getString(rawQuery.getColumnIndex("create_video_path"));
                bVar2.gaT = rawQuery.getString(rawQuery.getColumnIndex("origin_video_path"));
                bVar2.gaS = rawQuery.getString(rawQuery.getColumnIndex("pic_path"));
                bVar2.gaQ = rawQuery.getInt(rawQuery.getColumnIndex("mute")) == 1;
                bVar2.gaW = rawQuery.getInt(rawQuery.getColumnIndex("need_pub")) == 1;
                bVar2.gaX = rawQuery.getInt(rawQuery.getColumnIndex("only_pub")) == 1;
                bVar2.gaY = rawQuery.getInt(rawQuery.getColumnIndex("need_composite")) == 1;
                bVar2.gaV = rawQuery.getString(rawQuery.getColumnIndex("sticer_path"));
                bVar2.timestamp = rawQuery.getString(rawQuery.getColumnIndex(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME));
                bVar2.gaZ = rawQuery.getInt(rawQuery.getColumnIndex("target_width"));
                bVar2.gba = rawQuery.getInt(rawQuery.getColumnIndex("target_height"));
                bVar2.gbb = rawQuery.getInt(rawQuery.getColumnIndex("locate_x"));
                bVar2.gbc = rawQuery.getInt(rawQuery.getColumnIndex("locate_y"));
                bVar = bVar2;
            }
            n.e(rawQuery);
        }
        return bVar;
    }

    public List<com.baidu.tieba.story.process.b> ro(String str) {
        if (this.fWa == null || StringUtils.isNull(str)) {
            return null;
        }
        this.fWa.beginTransaction();
        Cursor rawQuery = this.fWa.rawQuery("SELECT * FROM " + str, null);
        if (rawQuery != null) {
            ArrayList arrayList = new ArrayList();
            while (rawQuery.moveToNext()) {
                com.baidu.tieba.story.process.b bVar = new com.baidu.tieba.story.process.b();
                bVar.forumId = rawQuery.getInt(rawQuery.getColumnIndex("forum_id"));
                bVar.forumName = rawQuery.getString(rawQuery.getColumnIndex("forum_name"));
                bVar.fVW = rawQuery.getInt(rawQuery.getColumnIndex("pagefrom"));
                bVar.type = rawQuery.getInt(rawQuery.getColumnIndex("type"));
                bVar.state = rawQuery.getInt(rawQuery.getColumnIndex("status"));
                bVar.gaU = rawQuery.getString(rawQuery.getColumnIndex("create_video_path"));
                bVar.gaT = rawQuery.getString(rawQuery.getColumnIndex("origin_video_path"));
                bVar.gaS = rawQuery.getString(rawQuery.getColumnIndex("pic_path"));
                bVar.gaQ = rawQuery.getInt(rawQuery.getColumnIndex("mute")) == 1;
                bVar.gaW = rawQuery.getInt(rawQuery.getColumnIndex("need_pub")) == 1;
                bVar.gaX = rawQuery.getInt(rawQuery.getColumnIndex("only_pub")) == 1;
                bVar.gaY = rawQuery.getInt(rawQuery.getColumnIndex("need_composite")) == 1;
                bVar.gaV = rawQuery.getString(rawQuery.getColumnIndex("sticer_path"));
                bVar.timestamp = rawQuery.getString(rawQuery.getColumnIndex(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME));
                bVar.gaZ = rawQuery.getInt(rawQuery.getColumnIndex("target_width"));
                bVar.gba = rawQuery.getInt(rawQuery.getColumnIndex("target_height"));
                bVar.gbb = rawQuery.getInt(rawQuery.getColumnIndex("locate_x"));
                bVar.gbc = rawQuery.getInt(rawQuery.getColumnIndex("locate_y"));
                arrayList.add(bVar);
            }
            n.e(rawQuery);
            this.fWa.setTransactionSuccessful();
            this.fWa.endTransaction();
            return arrayList;
        }
        return null;
    }
}
