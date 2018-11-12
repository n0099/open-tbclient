package com.baidu.tieba.video.editvideo.b;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.e;
import com.baidu.tieba.video.editvideo.b.b;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class a {
    b.a huA;
    private com.baidu.tieba.video.editvideo.data.a huy;
    private b huz;
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void a(com.baidu.tieba.video.editvideo.data.a aVar) {
        this.huy = aVar;
    }

    public boolean bGq() {
        return (this.huy == null || "normal".equalsIgnoreCase(this.huy.value)) ? false : true;
    }

    public void wd(String str) {
        if ((this.huz == null || !this.huz.isRunning()) && !TextUtils.isEmpty(str) && new File(str).exists()) {
            String bGt = bGt();
            String str2 = "normal";
            if (this.huy != null) {
                str2 = this.huy.value;
            }
            this.huz = new b(this.mContext, str, bGt, str2);
            if (this.huA != null) {
                this.huz.a(this.huA);
            }
            this.huz.bGu();
        }
    }

    public boolean bGr() {
        if (this.huz != null) {
            return this.huz.isRunning();
        }
        return false;
    }

    public void bGs() {
        if (this.huz != null) {
            this.huz.bGv();
        }
    }

    public void a(b.a aVar) {
        this.huA = aVar;
        if (this.huz != null) {
            this.huz.a(this.huA);
        }
    }

    public static List<com.baidu.tieba.video.editvideo.data.a> cZ(Context context) {
        ArrayList arrayList = new ArrayList();
        if (context == null) {
            context = TbadkCoreApplication.getInst();
        }
        a(arrayList, e.f.filter_icon_avatar_default, context.getString(e.j.filter_nature), "origin");
        a(arrayList, e.f.filter_icon_avatar_hongkong, context.getString(e.j.filter_hongkong), "hongkong");
        a(arrayList, e.f.filter_icon_avatar_refreshing, context.getString(e.j.filter_refreshing), "refreshing");
        a(arrayList, e.f.filter_icon_avatar_girly, context.getString(e.j.filter_girly), "girly");
        a(arrayList, e.f.filter_icon_avatar_concrete, context.getString(e.j.filter_concrete), "concrete");
        a(arrayList, e.f.filter_icon_avatar_warm, context.getString(e.j.filter_warm), "warm");
        a(arrayList, e.f.filter_icon_avatar_cold, context.getString(e.j.filter_cold), "cold");
        a(arrayList, e.f.filter_icon_avatar_japanese, context.getString(e.j.filter_japanese), "Japanese");
        a(arrayList, e.f.filter_icon_avatar_cruz, context.getString(e.j.filter_hdr), "cruz");
        a(arrayList, e.f.filter_icon_avatar_abao, context.getString(e.j.filter_abao), "abao");
        a(arrayList, e.f.filter_icon_avatar_dew, context.getString(e.j.filter_dew), "dew");
        a(arrayList, e.f.filter_icon_avatar_slowlived, context.getString(e.j.filter_slowlived), "slowlived");
        a(arrayList, e.f.filter_icon_avatar_sweet, context.getString(e.j.filter_sweet), "sweet");
        a(arrayList, e.f.filter_icon_avatar_boardwalk, context.getString(e.j.filter_boardwalk), "boardwalk");
        a(arrayList, e.f.filter_icon_avatar_keylime, context.getString(e.j.filter_keylime), "keylime");
        a(arrayList, e.f.filter_icon_avatar_electric, context.getString(e.j.filter_electric), "electric");
        a(arrayList, e.f.filter_icon_avatar_silver, context.getString(e.j.filter_silver), "silver");
        a(arrayList, e.f.filter_icon_avatar_blackwhite, context.getString(e.j.filter_blackwhite), "blackwhite");
        return arrayList;
    }

    private static void a(List<com.baidu.tieba.video.editvideo.data.a> list, int i, String str, String str2) {
        if (list != null) {
            list.add(new com.baidu.tieba.video.editvideo.data.a(str, i, str2));
        }
    }

    private static String bGt() {
        return com.baidu.tieba.video.c.hsw + "video_addfilter_" + System.currentTimeMillis() + ".mp4";
    }
}
