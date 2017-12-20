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
    private static i gro;
    private SQLiteDatabase grp = new j(TbadkCoreApplication.getInst().getApp()).getWritableDatabase();

    public static synchronized i bss() {
        i iVar;
        synchronized (i.class) {
            if (gro == null) {
                gro = new i();
            }
            iVar = gro;
        }
        return iVar;
    }

    private i() {
    }

    public void sC(String str) {
        new j(TbadkCoreApplication.getInst().getApp()).f(this.grp, str);
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
        contentValues.put("pagefrom", Integer.valueOf(bVar.eZh));
        contentValues.put("create_video_path", bVar.gwh);
        contentValues.put("sticer_path", bVar.gwi);
        contentValues.put("origin_video_path", bVar.gwg);
        contentValues.put("pic_path", bVar.gwf);
        contentValues.put("mute", Integer.valueOf(bVar.gwd ? 1 : 0));
        contentValues.put("need_pub", Integer.valueOf(bVar.gwj ? 1 : 0));
        contentValues.put("only_pub", Integer.valueOf(bVar.gwk ? 1 : 0));
        contentValues.put("need_composite", Integer.valueOf(bVar.gwl ? 1 : 0));
        contentValues.put(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, "" + System.currentTimeMillis());
        contentValues.put("target_width", Integer.valueOf(bVar.gwm));
        contentValues.put("target_height", Integer.valueOf(bVar.gwn));
        contentValues.put("locate_x", Integer.valueOf(bVar.gwo));
        contentValues.put("locate_y", Integer.valueOf(bVar.gwp));
        return contentValues;
    }

    public boolean b(com.baidu.tieba.story.process.b bVar) {
        ContentValues a;
        String str;
        if (bVar != null && (a = a(bVar)) != null) {
            if (StringUtils.isNull(bVar.gwq)) {
                str = TbadkCoreApplication.getCurrentAccount();
            } else {
                str = bVar.gwq;
            }
            if (this.grp == null || StringUtils.isNull(str)) {
                return false;
            }
            return cP(bVar.forumId) == null ? ((bVar.state == 3 || bVar.state == 2) && this.grp.insert(new StringBuilder().append("story_").append(str).toString(), null, a) > 0) ? true : true : this.grp.update(new StringBuilder().append("story_").append(str).toString(), a, "forum_id = ?", new String[]{new StringBuilder().append("").append(bVar.forumId).toString()}) > 0;
        }
        return false;
    }

    public boolean cO(long j) {
        if (j < 0) {
            return false;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        return (this.grp == null || StringUtils.isNull(currentAccount) || this.grp.delete(new StringBuilder().append("story_").append(currentAccount).toString(), "forum_id = ?", new String[]{String.valueOf(j)}) <= 0) ? false : true;
    }

    public com.baidu.tieba.story.process.b cP(long j) {
        Cursor rawQuery;
        com.baidu.tieba.story.process.b bVar = null;
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (this.grp != null && !StringUtils.isNull(currentAccount) && (rawQuery = this.grp.rawQuery("SELECT * FROM story_" + currentAccount + " WHERE forum_id=?", new String[]{String.valueOf(j)})) != null && rawQuery.getCount() > 0) {
            if (rawQuery.moveToFirst()) {
                com.baidu.tieba.story.process.b bVar2 = new com.baidu.tieba.story.process.b();
                bVar2.forumId = j;
                bVar2.forumName = rawQuery.getString(rawQuery.getColumnIndex("forum_name"));
                bVar2.eZh = rawQuery.getInt(rawQuery.getColumnIndex("pagefrom"));
                bVar2.type = rawQuery.getInt(rawQuery.getColumnIndex("type"));
                bVar2.state = rawQuery.getInt(rawQuery.getColumnIndex("status"));
                bVar2.gwh = rawQuery.getString(rawQuery.getColumnIndex("create_video_path"));
                bVar2.gwg = rawQuery.getString(rawQuery.getColumnIndex("origin_video_path"));
                bVar2.gwf = rawQuery.getString(rawQuery.getColumnIndex("pic_path"));
                bVar2.gwd = rawQuery.getInt(rawQuery.getColumnIndex("mute")) == 1;
                bVar2.gwj = rawQuery.getInt(rawQuery.getColumnIndex("need_pub")) == 1;
                bVar2.gwk = rawQuery.getInt(rawQuery.getColumnIndex("only_pub")) == 1;
                bVar2.gwl = rawQuery.getInt(rawQuery.getColumnIndex("need_composite")) == 1;
                bVar2.gwi = rawQuery.getString(rawQuery.getColumnIndex("sticer_path"));
                bVar2.timestamp = rawQuery.getString(rawQuery.getColumnIndex(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME));
                bVar2.gwm = rawQuery.getInt(rawQuery.getColumnIndex("target_width"));
                bVar2.gwn = rawQuery.getInt(rawQuery.getColumnIndex("target_height"));
                bVar2.gwo = rawQuery.getInt(rawQuery.getColumnIndex("locate_x"));
                bVar2.gwp = rawQuery.getInt(rawQuery.getColumnIndex("locate_y"));
                bVar = bVar2;
            }
            n.e(rawQuery);
        }
        return bVar;
    }

    public List<com.baidu.tieba.story.process.b> sD(String str) {
        if (this.grp == null || StringUtils.isNull(str)) {
            return null;
        }
        this.grp.beginTransaction();
        Cursor rawQuery = this.grp.rawQuery("SELECT * FROM " + str, null);
        if (rawQuery != null) {
            ArrayList arrayList = new ArrayList();
            while (rawQuery.moveToNext()) {
                com.baidu.tieba.story.process.b bVar = new com.baidu.tieba.story.process.b();
                bVar.forumId = rawQuery.getInt(rawQuery.getColumnIndex("forum_id"));
                bVar.forumName = rawQuery.getString(rawQuery.getColumnIndex("forum_name"));
                bVar.eZh = rawQuery.getInt(rawQuery.getColumnIndex("pagefrom"));
                bVar.type = rawQuery.getInt(rawQuery.getColumnIndex("type"));
                bVar.state = rawQuery.getInt(rawQuery.getColumnIndex("status"));
                bVar.gwh = rawQuery.getString(rawQuery.getColumnIndex("create_video_path"));
                bVar.gwg = rawQuery.getString(rawQuery.getColumnIndex("origin_video_path"));
                bVar.gwf = rawQuery.getString(rawQuery.getColumnIndex("pic_path"));
                bVar.gwd = rawQuery.getInt(rawQuery.getColumnIndex("mute")) == 1;
                bVar.gwj = rawQuery.getInt(rawQuery.getColumnIndex("need_pub")) == 1;
                bVar.gwk = rawQuery.getInt(rawQuery.getColumnIndex("only_pub")) == 1;
                bVar.gwl = rawQuery.getInt(rawQuery.getColumnIndex("need_composite")) == 1;
                bVar.gwi = rawQuery.getString(rawQuery.getColumnIndex("sticer_path"));
                bVar.timestamp = rawQuery.getString(rawQuery.getColumnIndex(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME));
                bVar.gwm = rawQuery.getInt(rawQuery.getColumnIndex("target_width"));
                bVar.gwn = rawQuery.getInt(rawQuery.getColumnIndex("target_height"));
                bVar.gwo = rawQuery.getInt(rawQuery.getColumnIndex("locate_x"));
                bVar.gwp = rawQuery.getInt(rawQuery.getColumnIndex("locate_y"));
                arrayList.add(bVar);
            }
            n.e(rawQuery);
            this.grp.setTransactionSuccessful();
            this.grp.endTransaction();
            return arrayList;
        }
        return null;
    }
}
