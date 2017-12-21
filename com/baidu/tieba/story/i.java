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
    private static i grt;
    private SQLiteDatabase gru = new j(TbadkCoreApplication.getInst().getApp()).getWritableDatabase();

    public static synchronized i bst() {
        i iVar;
        synchronized (i.class) {
            if (grt == null) {
                grt = new i();
            }
            iVar = grt;
        }
        return iVar;
    }

    private i() {
    }

    public void sC(String str) {
        new j(TbadkCoreApplication.getInst().getApp()).f(this.gru, str);
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
        contentValues.put("pagefrom", Integer.valueOf(bVar.eZm));
        contentValues.put("create_video_path", bVar.gwm);
        contentValues.put("sticer_path", bVar.gwn);
        contentValues.put("origin_video_path", bVar.gwl);
        contentValues.put("pic_path", bVar.gwk);
        contentValues.put("mute", Integer.valueOf(bVar.gwi ? 1 : 0));
        contentValues.put("need_pub", Integer.valueOf(bVar.gwo ? 1 : 0));
        contentValues.put("only_pub", Integer.valueOf(bVar.gwp ? 1 : 0));
        contentValues.put("need_composite", Integer.valueOf(bVar.gwq ? 1 : 0));
        contentValues.put(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, "" + System.currentTimeMillis());
        contentValues.put("target_width", Integer.valueOf(bVar.gwr));
        contentValues.put("target_height", Integer.valueOf(bVar.gws));
        contentValues.put("locate_x", Integer.valueOf(bVar.gwt));
        contentValues.put("locate_y", Integer.valueOf(bVar.gwu));
        return contentValues;
    }

    public boolean b(com.baidu.tieba.story.process.b bVar) {
        ContentValues a;
        String str;
        if (bVar != null && (a = a(bVar)) != null) {
            if (StringUtils.isNull(bVar.gwv)) {
                str = TbadkCoreApplication.getCurrentAccount();
            } else {
                str = bVar.gwv;
            }
            if (this.gru == null || StringUtils.isNull(str)) {
                return false;
            }
            return cP(bVar.forumId) == null ? ((bVar.state == 3 || bVar.state == 2) && this.gru.insert(new StringBuilder().append("story_").append(str).toString(), null, a) > 0) ? true : true : this.gru.update(new StringBuilder().append("story_").append(str).toString(), a, "forum_id = ?", new String[]{new StringBuilder().append("").append(bVar.forumId).toString()}) > 0;
        }
        return false;
    }

    public boolean cO(long j) {
        if (j < 0) {
            return false;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        return (this.gru == null || StringUtils.isNull(currentAccount) || this.gru.delete(new StringBuilder().append("story_").append(currentAccount).toString(), "forum_id = ?", new String[]{String.valueOf(j)}) <= 0) ? false : true;
    }

    public com.baidu.tieba.story.process.b cP(long j) {
        Cursor rawQuery;
        com.baidu.tieba.story.process.b bVar = null;
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (this.gru != null && !StringUtils.isNull(currentAccount) && (rawQuery = this.gru.rawQuery("SELECT * FROM story_" + currentAccount + " WHERE forum_id=?", new String[]{String.valueOf(j)})) != null && rawQuery.getCount() > 0) {
            if (rawQuery.moveToFirst()) {
                com.baidu.tieba.story.process.b bVar2 = new com.baidu.tieba.story.process.b();
                bVar2.forumId = j;
                bVar2.forumName = rawQuery.getString(rawQuery.getColumnIndex("forum_name"));
                bVar2.eZm = rawQuery.getInt(rawQuery.getColumnIndex("pagefrom"));
                bVar2.type = rawQuery.getInt(rawQuery.getColumnIndex("type"));
                bVar2.state = rawQuery.getInt(rawQuery.getColumnIndex("status"));
                bVar2.gwm = rawQuery.getString(rawQuery.getColumnIndex("create_video_path"));
                bVar2.gwl = rawQuery.getString(rawQuery.getColumnIndex("origin_video_path"));
                bVar2.gwk = rawQuery.getString(rawQuery.getColumnIndex("pic_path"));
                bVar2.gwi = rawQuery.getInt(rawQuery.getColumnIndex("mute")) == 1;
                bVar2.gwo = rawQuery.getInt(rawQuery.getColumnIndex("need_pub")) == 1;
                bVar2.gwp = rawQuery.getInt(rawQuery.getColumnIndex("only_pub")) == 1;
                bVar2.gwq = rawQuery.getInt(rawQuery.getColumnIndex("need_composite")) == 1;
                bVar2.gwn = rawQuery.getString(rawQuery.getColumnIndex("sticer_path"));
                bVar2.timestamp = rawQuery.getString(rawQuery.getColumnIndex(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME));
                bVar2.gwr = rawQuery.getInt(rawQuery.getColumnIndex("target_width"));
                bVar2.gws = rawQuery.getInt(rawQuery.getColumnIndex("target_height"));
                bVar2.gwt = rawQuery.getInt(rawQuery.getColumnIndex("locate_x"));
                bVar2.gwu = rawQuery.getInt(rawQuery.getColumnIndex("locate_y"));
                bVar = bVar2;
            }
            n.e(rawQuery);
        }
        return bVar;
    }

    public List<com.baidu.tieba.story.process.b> sD(String str) {
        if (this.gru == null || StringUtils.isNull(str)) {
            return null;
        }
        this.gru.beginTransaction();
        Cursor rawQuery = this.gru.rawQuery("SELECT * FROM " + str, null);
        if (rawQuery != null) {
            ArrayList arrayList = new ArrayList();
            while (rawQuery.moveToNext()) {
                com.baidu.tieba.story.process.b bVar = new com.baidu.tieba.story.process.b();
                bVar.forumId = rawQuery.getInt(rawQuery.getColumnIndex("forum_id"));
                bVar.forumName = rawQuery.getString(rawQuery.getColumnIndex("forum_name"));
                bVar.eZm = rawQuery.getInt(rawQuery.getColumnIndex("pagefrom"));
                bVar.type = rawQuery.getInt(rawQuery.getColumnIndex("type"));
                bVar.state = rawQuery.getInt(rawQuery.getColumnIndex("status"));
                bVar.gwm = rawQuery.getString(rawQuery.getColumnIndex("create_video_path"));
                bVar.gwl = rawQuery.getString(rawQuery.getColumnIndex("origin_video_path"));
                bVar.gwk = rawQuery.getString(rawQuery.getColumnIndex("pic_path"));
                bVar.gwi = rawQuery.getInt(rawQuery.getColumnIndex("mute")) == 1;
                bVar.gwo = rawQuery.getInt(rawQuery.getColumnIndex("need_pub")) == 1;
                bVar.gwp = rawQuery.getInt(rawQuery.getColumnIndex("only_pub")) == 1;
                bVar.gwq = rawQuery.getInt(rawQuery.getColumnIndex("need_composite")) == 1;
                bVar.gwn = rawQuery.getString(rawQuery.getColumnIndex("sticer_path"));
                bVar.timestamp = rawQuery.getString(rawQuery.getColumnIndex(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME));
                bVar.gwr = rawQuery.getInt(rawQuery.getColumnIndex("target_width"));
                bVar.gws = rawQuery.getInt(rawQuery.getColumnIndex("target_height"));
                bVar.gwt = rawQuery.getInt(rawQuery.getColumnIndex("locate_x"));
                bVar.gwu = rawQuery.getInt(rawQuery.getColumnIndex("locate_y"));
                arrayList.add(bVar);
            }
            n.e(rawQuery);
            this.gru.setTransactionSuccessful();
            this.gru.endTransaction();
            return arrayList;
        }
        return null;
    }
}
