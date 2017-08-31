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
    private static i fXQ;
    private SQLiteDatabase fXR = new j(TbadkCoreApplication.getInst().getApp()).getWritableDatabase();

    public static synchronized i bnS() {
        i iVar;
        synchronized (i.class) {
            if (fXQ == null) {
                fXQ = new i();
            }
            iVar = fXQ;
        }
        return iVar;
    }

    private i() {
    }

    public void rC(String str) {
        new j(TbadkCoreApplication.getInst().getApp()).f(this.fXR, str);
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
        contentValues.put("pagefrom", Integer.valueOf(bVar.fXN));
        contentValues.put("create_video_path", bVar.gcI);
        contentValues.put("sticer_path", bVar.gcJ);
        contentValues.put("origin_video_path", bVar.gcH);
        contentValues.put("pic_path", bVar.gcG);
        contentValues.put("mute", Integer.valueOf(bVar.gcE ? 1 : 0));
        contentValues.put("need_pub", Integer.valueOf(bVar.gcK ? 1 : 0));
        contentValues.put("only_pub", Integer.valueOf(bVar.gcL ? 1 : 0));
        contentValues.put("need_composite", Integer.valueOf(bVar.gcM ? 1 : 0));
        contentValues.put(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, "" + System.currentTimeMillis());
        contentValues.put("target_width", Integer.valueOf(bVar.gcN));
        contentValues.put("target_height", Integer.valueOf(bVar.gcO));
        contentValues.put("locate_x", Integer.valueOf(bVar.gcP));
        contentValues.put("locate_y", Integer.valueOf(bVar.gcQ));
        return contentValues;
    }

    public boolean b(com.baidu.tieba.story.process.b bVar) {
        ContentValues a;
        String str;
        if (bVar != null && (a = a(bVar)) != null) {
            if (StringUtils.isNull(bVar.gcR)) {
                str = TbadkCoreApplication.getCurrentAccount();
            } else {
                str = bVar.gcR;
            }
            if (this.fXR == null || StringUtils.isNull(str)) {
                return false;
            }
            return cF(bVar.forumId) == null ? ((bVar.state == 3 || bVar.state == 2) && this.fXR.insert(new StringBuilder().append("story_").append(str).toString(), null, a) > 0) ? true : true : this.fXR.update(new StringBuilder().append("story_").append(str).toString(), a, "forum_id = ?", new String[]{new StringBuilder().append("").append(bVar.forumId).toString()}) > 0;
        }
        return false;
    }

    public boolean cE(long j) {
        if (j < 0) {
            return false;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        return (this.fXR == null || StringUtils.isNull(currentAccount) || this.fXR.delete(new StringBuilder().append("story_").append(currentAccount).toString(), "forum_id = ?", new String[]{String.valueOf(j)}) <= 0) ? false : true;
    }

    public com.baidu.tieba.story.process.b cF(long j) {
        Cursor rawQuery;
        com.baidu.tieba.story.process.b bVar = null;
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (this.fXR != null && !StringUtils.isNull(currentAccount) && (rawQuery = this.fXR.rawQuery("SELECT * FROM story_" + currentAccount + " WHERE forum_id=?", new String[]{String.valueOf(j)})) != null && rawQuery.getCount() > 0) {
            if (rawQuery.moveToFirst()) {
                com.baidu.tieba.story.process.b bVar2 = new com.baidu.tieba.story.process.b();
                bVar2.forumId = j;
                bVar2.forumName = rawQuery.getString(rawQuery.getColumnIndex("forum_name"));
                bVar2.fXN = rawQuery.getInt(rawQuery.getColumnIndex("pagefrom"));
                bVar2.type = rawQuery.getInt(rawQuery.getColumnIndex("type"));
                bVar2.state = rawQuery.getInt(rawQuery.getColumnIndex("status"));
                bVar2.gcI = rawQuery.getString(rawQuery.getColumnIndex("create_video_path"));
                bVar2.gcH = rawQuery.getString(rawQuery.getColumnIndex("origin_video_path"));
                bVar2.gcG = rawQuery.getString(rawQuery.getColumnIndex("pic_path"));
                bVar2.gcE = rawQuery.getInt(rawQuery.getColumnIndex("mute")) == 1;
                bVar2.gcK = rawQuery.getInt(rawQuery.getColumnIndex("need_pub")) == 1;
                bVar2.gcL = rawQuery.getInt(rawQuery.getColumnIndex("only_pub")) == 1;
                bVar2.gcM = rawQuery.getInt(rawQuery.getColumnIndex("need_composite")) == 1;
                bVar2.gcJ = rawQuery.getString(rawQuery.getColumnIndex("sticer_path"));
                bVar2.timestamp = rawQuery.getString(rawQuery.getColumnIndex(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME));
                bVar2.gcN = rawQuery.getInt(rawQuery.getColumnIndex("target_width"));
                bVar2.gcO = rawQuery.getInt(rawQuery.getColumnIndex("target_height"));
                bVar2.gcP = rawQuery.getInt(rawQuery.getColumnIndex("locate_x"));
                bVar2.gcQ = rawQuery.getInt(rawQuery.getColumnIndex("locate_y"));
                bVar = bVar2;
            }
            com.baidu.adp.lib.util.m.e(rawQuery);
        }
        return bVar;
    }

    public List<com.baidu.tieba.story.process.b> rD(String str) {
        if (this.fXR == null || StringUtils.isNull(str)) {
            return null;
        }
        this.fXR.beginTransaction();
        Cursor rawQuery = this.fXR.rawQuery("SELECT * FROM " + str, null);
        if (rawQuery != null) {
            ArrayList arrayList = new ArrayList();
            while (rawQuery.moveToNext()) {
                com.baidu.tieba.story.process.b bVar = new com.baidu.tieba.story.process.b();
                bVar.forumId = rawQuery.getInt(rawQuery.getColumnIndex("forum_id"));
                bVar.forumName = rawQuery.getString(rawQuery.getColumnIndex("forum_name"));
                bVar.fXN = rawQuery.getInt(rawQuery.getColumnIndex("pagefrom"));
                bVar.type = rawQuery.getInt(rawQuery.getColumnIndex("type"));
                bVar.state = rawQuery.getInt(rawQuery.getColumnIndex("status"));
                bVar.gcI = rawQuery.getString(rawQuery.getColumnIndex("create_video_path"));
                bVar.gcH = rawQuery.getString(rawQuery.getColumnIndex("origin_video_path"));
                bVar.gcG = rawQuery.getString(rawQuery.getColumnIndex("pic_path"));
                bVar.gcE = rawQuery.getInt(rawQuery.getColumnIndex("mute")) == 1;
                bVar.gcK = rawQuery.getInt(rawQuery.getColumnIndex("need_pub")) == 1;
                bVar.gcL = rawQuery.getInt(rawQuery.getColumnIndex("only_pub")) == 1;
                bVar.gcM = rawQuery.getInt(rawQuery.getColumnIndex("need_composite")) == 1;
                bVar.gcJ = rawQuery.getString(rawQuery.getColumnIndex("sticer_path"));
                bVar.timestamp = rawQuery.getString(rawQuery.getColumnIndex(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME));
                bVar.gcN = rawQuery.getInt(rawQuery.getColumnIndex("target_width"));
                bVar.gcO = rawQuery.getInt(rawQuery.getColumnIndex("target_height"));
                bVar.gcP = rawQuery.getInt(rawQuery.getColumnIndex("locate_x"));
                bVar.gcQ = rawQuery.getInt(rawQuery.getColumnIndex("locate_y"));
                arrayList.add(bVar);
            }
            com.baidu.adp.lib.util.m.e(rawQuery);
            this.fXR.setTransactionSuccessful();
            this.fXR.endTransaction();
            return arrayList;
        }
        return null;
    }
}
