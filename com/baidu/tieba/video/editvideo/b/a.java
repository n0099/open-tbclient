package com.baidu.tieba.video.editvideo.b;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.f;
import com.baidu.tieba.video.editvideo.b.b;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private com.baidu.tieba.video.editvideo.data.a hdH;
    private b hdI;
    b.a hdJ;
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void a(com.baidu.tieba.video.editvideo.data.a aVar) {
        this.hdH = aVar;
    }

    public boolean bAO() {
        return (this.hdH == null || "normal".equalsIgnoreCase(this.hdH.value)) ? false : true;
    }

    public void uN(String str) {
        if ((this.hdI == null || !this.hdI.isRunning()) && !TextUtils.isEmpty(str) && new File(str).exists()) {
            String bAR = bAR();
            String str2 = "normal";
            if (this.hdH != null) {
                str2 = this.hdH.value;
            }
            this.hdI = new b(this.mContext, str, bAR, str2);
            if (this.hdJ != null) {
                this.hdI.a(this.hdJ);
            }
            this.hdI.bAS();
        }
    }

    public boolean bAP() {
        if (this.hdI != null) {
            return this.hdI.isRunning();
        }
        return false;
    }

    public void bAQ() {
        if (this.hdI != null) {
            this.hdI.bAT();
        }
    }

    public void a(b.a aVar) {
        this.hdJ = aVar;
        if (this.hdI != null) {
            this.hdI.a(this.hdJ);
        }
    }

    public static List<com.baidu.tieba.video.editvideo.data.a> cl(Context context) {
        ArrayList arrayList = new ArrayList();
        if (context == null) {
            context = TbadkCoreApplication.getInst();
        }
        a(arrayList, f.C0146f.filter_icon_avatar_default, context.getString(f.j.filter_nature), "nature");
        a(arrayList, f.C0146f.filter_icon_avatar_hongkong, context.getString(f.j.filter_hongkong), "hongkong");
        a(arrayList, f.C0146f.filter_icon_avatar_refreshing, context.getString(f.j.filter_refreshing), "refreshing");
        a(arrayList, f.C0146f.filter_icon_avatar_girly, context.getString(f.j.filter_girly), "girly");
        a(arrayList, f.C0146f.filter_icon_avatar_concrete, context.getString(f.j.filter_concrete), "concrete");
        a(arrayList, f.C0146f.filter_icon_avatar_warm, context.getString(f.j.filter_warm), "warm");
        a(arrayList, f.C0146f.filter_icon_avatar_cold, context.getString(f.j.filter_cold), "cold");
        a(arrayList, f.C0146f.filter_icon_avatar_japanese, context.getString(f.j.filter_japanese), "Japanese");
        a(arrayList, f.C0146f.filter_icon_avatar_cruz, context.getString(f.j.filter_hdr), "cruz");
        a(arrayList, f.C0146f.filter_icon_avatar_abao, context.getString(f.j.filter_abao), "abao");
        a(arrayList, f.C0146f.filter_icon_avatar_dew, context.getString(f.j.filter_dew), "dew");
        a(arrayList, f.C0146f.filter_icon_avatar_slowlived, context.getString(f.j.filter_slowlived), "slowlived");
        a(arrayList, f.C0146f.filter_icon_avatar_sweet, context.getString(f.j.filter_sweet), "sweet");
        a(arrayList, f.C0146f.filter_icon_avatar_boardwalk, context.getString(f.j.filter_boardwalk), "boardwalk");
        a(arrayList, f.C0146f.filter_icon_avatar_keylime, context.getString(f.j.filter_keylime), "keylime");
        a(arrayList, f.C0146f.filter_icon_avatar_electric, context.getString(f.j.filter_electric), "electric");
        a(arrayList, f.C0146f.filter_icon_avatar_silver, context.getString(f.j.filter_silver), "silver");
        a(arrayList, f.C0146f.filter_icon_avatar_blackwhite, context.getString(f.j.filter_blackwhite), "blackwhite");
        return arrayList;
    }

    private static void a(List<com.baidu.tieba.video.editvideo.data.a> list, int i, String str, String str2) {
        if (list != null) {
            list.add(new com.baidu.tieba.video.editvideo.data.a(str, i, str2));
        }
    }

    private static String bAR() {
        return com.baidu.tieba.video.c.hbE + "video_addfilter_" + System.currentTimeMillis() + ".mp4";
    }
}
