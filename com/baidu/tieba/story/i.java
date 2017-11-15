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
    private static i gfP;
    private SQLiteDatabase gfQ = new j(TbadkCoreApplication.getInst().getApp()).getWritableDatabase();

    public static synchronized i bqf() {
        i iVar;
        synchronized (i.class) {
            if (gfP == null) {
                gfP = new i();
            }
            iVar = gfP;
        }
        return iVar;
    }

    private i() {
    }

    public void sb(String str) {
        new j(TbadkCoreApplication.getInst().getApp()).f(this.gfQ, str);
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
        contentValues.put("pagefrom", Integer.valueOf(bVar.gfM));
        contentValues.put("create_video_path", bVar.gkJ);
        contentValues.put("sticer_path", bVar.gkK);
        contentValues.put("origin_video_path", bVar.gkI);
        contentValues.put("pic_path", bVar.gkH);
        contentValues.put("mute", Integer.valueOf(bVar.gkF ? 1 : 0));
        contentValues.put("need_pub", Integer.valueOf(bVar.gkL ? 1 : 0));
        contentValues.put("only_pub", Integer.valueOf(bVar.gkM ? 1 : 0));
        contentValues.put("need_composite", Integer.valueOf(bVar.gkN ? 1 : 0));
        contentValues.put(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, "" + System.currentTimeMillis());
        contentValues.put("target_width", Integer.valueOf(bVar.gkO));
        contentValues.put("target_height", Integer.valueOf(bVar.gkP));
        contentValues.put("locate_x", Integer.valueOf(bVar.gkQ));
        contentValues.put("locate_y", Integer.valueOf(bVar.gkR));
        return contentValues;
    }

    public boolean b(com.baidu.tieba.story.process.b bVar) {
        ContentValues a;
        String str;
        if (bVar != null && (a = a(bVar)) != null) {
            if (StringUtils.isNull(bVar.gkS)) {
                str = TbadkCoreApplication.getCurrentAccount();
            } else {
                str = bVar.gkS;
            }
            if (this.gfQ == null || StringUtils.isNull(str)) {
                return false;
            }
            return cH(bVar.forumId) == null ? ((bVar.state == 3 || bVar.state == 2) && this.gfQ.insert(new StringBuilder().append("story_").append(str).toString(), null, a) > 0) ? true : true : this.gfQ.update(new StringBuilder().append("story_").append(str).toString(), a, "forum_id = ?", new String[]{new StringBuilder().append("").append(bVar.forumId).toString()}) > 0;
        }
        return false;
    }

    public boolean cG(long j) {
        if (j < 0) {
            return false;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        return (this.gfQ == null || StringUtils.isNull(currentAccount) || this.gfQ.delete(new StringBuilder().append("story_").append(currentAccount).toString(), "forum_id = ?", new String[]{String.valueOf(j)}) <= 0) ? false : true;
    }

    public com.baidu.tieba.story.process.b cH(long j) {
        Cursor rawQuery;
        com.baidu.tieba.story.process.b bVar = null;
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (this.gfQ != null && !StringUtils.isNull(currentAccount) && (rawQuery = this.gfQ.rawQuery("SELECT * FROM story_" + currentAccount + " WHERE forum_id=?", new String[]{String.valueOf(j)})) != null && rawQuery.getCount() > 0) {
            if (rawQuery.moveToFirst()) {
                com.baidu.tieba.story.process.b bVar2 = new com.baidu.tieba.story.process.b();
                bVar2.forumId = j;
                bVar2.forumName = rawQuery.getString(rawQuery.getColumnIndex("forum_name"));
                bVar2.gfM = rawQuery.getInt(rawQuery.getColumnIndex("pagefrom"));
                bVar2.type = rawQuery.getInt(rawQuery.getColumnIndex("type"));
                bVar2.state = rawQuery.getInt(rawQuery.getColumnIndex("status"));
                bVar2.gkJ = rawQuery.getString(rawQuery.getColumnIndex("create_video_path"));
                bVar2.gkI = rawQuery.getString(rawQuery.getColumnIndex("origin_video_path"));
                bVar2.gkH = rawQuery.getString(rawQuery.getColumnIndex("pic_path"));
                bVar2.gkF = rawQuery.getInt(rawQuery.getColumnIndex("mute")) == 1;
                bVar2.gkL = rawQuery.getInt(rawQuery.getColumnIndex("need_pub")) == 1;
                bVar2.gkM = rawQuery.getInt(rawQuery.getColumnIndex("only_pub")) == 1;
                bVar2.gkN = rawQuery.getInt(rawQuery.getColumnIndex("need_composite")) == 1;
                bVar2.gkK = rawQuery.getString(rawQuery.getColumnIndex("sticer_path"));
                bVar2.timestamp = rawQuery.getString(rawQuery.getColumnIndex(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME));
                bVar2.gkO = rawQuery.getInt(rawQuery.getColumnIndex("target_width"));
                bVar2.gkP = rawQuery.getInt(rawQuery.getColumnIndex("target_height"));
                bVar2.gkQ = rawQuery.getInt(rawQuery.getColumnIndex("locate_x"));
                bVar2.gkR = rawQuery.getInt(rawQuery.getColumnIndex("locate_y"));
                bVar = bVar2;
            }
            n.e(rawQuery);
        }
        return bVar;
    }

    public List<com.baidu.tieba.story.process.b> sc(String str) {
        if (this.gfQ == null || StringUtils.isNull(str)) {
            return null;
        }
        this.gfQ.beginTransaction();
        Cursor rawQuery = this.gfQ.rawQuery("SELECT * FROM " + str, null);
        if (rawQuery != null) {
            ArrayList arrayList = new ArrayList();
            while (rawQuery.moveToNext()) {
                com.baidu.tieba.story.process.b bVar = new com.baidu.tieba.story.process.b();
                bVar.forumId = rawQuery.getInt(rawQuery.getColumnIndex("forum_id"));
                bVar.forumName = rawQuery.getString(rawQuery.getColumnIndex("forum_name"));
                bVar.gfM = rawQuery.getInt(rawQuery.getColumnIndex("pagefrom"));
                bVar.type = rawQuery.getInt(rawQuery.getColumnIndex("type"));
                bVar.state = rawQuery.getInt(rawQuery.getColumnIndex("status"));
                bVar.gkJ = rawQuery.getString(rawQuery.getColumnIndex("create_video_path"));
                bVar.gkI = rawQuery.getString(rawQuery.getColumnIndex("origin_video_path"));
                bVar.gkH = rawQuery.getString(rawQuery.getColumnIndex("pic_path"));
                bVar.gkF = rawQuery.getInt(rawQuery.getColumnIndex("mute")) == 1;
                bVar.gkL = rawQuery.getInt(rawQuery.getColumnIndex("need_pub")) == 1;
                bVar.gkM = rawQuery.getInt(rawQuery.getColumnIndex("only_pub")) == 1;
                bVar.gkN = rawQuery.getInt(rawQuery.getColumnIndex("need_composite")) == 1;
                bVar.gkK = rawQuery.getString(rawQuery.getColumnIndex("sticer_path"));
                bVar.timestamp = rawQuery.getString(rawQuery.getColumnIndex(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME));
                bVar.gkO = rawQuery.getInt(rawQuery.getColumnIndex("target_width"));
                bVar.gkP = rawQuery.getInt(rawQuery.getColumnIndex("target_height"));
                bVar.gkQ = rawQuery.getInt(rawQuery.getColumnIndex("locate_x"));
                bVar.gkR = rawQuery.getInt(rawQuery.getColumnIndex("locate_y"));
                arrayList.add(bVar);
            }
            n.e(rawQuery);
            this.gfQ.setTransactionSuccessful();
            this.gfQ.endTransaction();
            return arrayList;
        }
        return null;
    }
}
