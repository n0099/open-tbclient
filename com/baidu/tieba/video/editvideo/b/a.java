package com.baidu.tieba.video.editvideo.b;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
import com.baidu.tieba.video.editvideo.b.b;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private com.baidu.tieba.video.editvideo.data.a hoj;
    private b hok;
    b.a hol;
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void a(com.baidu.tieba.video.editvideo.data.a aVar) {
        this.hoj = aVar;
    }

    public boolean bAB() {
        return (this.hoj == null || "normal".equalsIgnoreCase(this.hoj.value)) ? false : true;
    }

    public void tz(String str) {
        if ((this.hok == null || !this.hok.isRunning()) && !TextUtils.isEmpty(str) && new File(str).exists()) {
            String bAE = bAE();
            String str2 = "normal";
            if (this.hoj != null) {
                str2 = this.hoj.value;
            }
            this.hok = new b(this.mContext, str, bAE, str2);
            if (this.hol != null) {
                this.hok.a(this.hol);
            }
            this.hok.bAF();
        }
    }

    public boolean bAC() {
        if (this.hok != null) {
            return this.hok.isRunning();
        }
        return false;
    }

    public void bAD() {
        if (this.hok != null) {
            this.hok.bAG();
        }
    }

    public void a(b.a aVar) {
        this.hol = aVar;
        if (this.hok != null) {
            this.hok.a(this.hol);
        }
    }

    public static List<com.baidu.tieba.video.editvideo.data.a> cn(Context context) {
        ArrayList arrayList = new ArrayList();
        if (context == null) {
            context = TbadkCoreApplication.getInst();
        }
        a(arrayList, d.f.filter_icon_avatar_default, context.getString(d.j.filter_nature), "nature");
        a(arrayList, d.f.filter_icon_avatar_hongkong, context.getString(d.j.filter_hongkong), "hongkong");
        a(arrayList, d.f.filter_icon_avatar_refreshing, context.getString(d.j.filter_refreshing), "refreshing");
        a(arrayList, d.f.filter_icon_avatar_girly, context.getString(d.j.filter_girly), "girly");
        a(arrayList, d.f.filter_icon_avatar_concrete, context.getString(d.j.filter_concrete), "concrete");
        a(arrayList, d.f.filter_icon_avatar_warm, context.getString(d.j.filter_warm), "warm");
        a(arrayList, d.f.filter_icon_avatar_cold, context.getString(d.j.filter_cold), "cold");
        a(arrayList, d.f.filter_icon_avatar_japanese, context.getString(d.j.filter_japanese), "Japanese");
        a(arrayList, d.f.filter_icon_avatar_cruz, context.getString(d.j.filter_hdr), "cruz");
        a(arrayList, d.f.filter_icon_avatar_abao, context.getString(d.j.filter_abao), "abao");
        a(arrayList, d.f.filter_icon_avatar_dew, context.getString(d.j.filter_dew), "dew");
        a(arrayList, d.f.filter_icon_avatar_slowlived, context.getString(d.j.filter_slowlived), "slowlived");
        a(arrayList, d.f.filter_icon_avatar_sweet, context.getString(d.j.filter_sweet), "sweet");
        a(arrayList, d.f.filter_icon_avatar_boardwalk, context.getString(d.j.filter_boardwalk), "boardwalk");
        a(arrayList, d.f.filter_icon_avatar_keylime, context.getString(d.j.filter_keylime), "keylime");
        a(arrayList, d.f.filter_icon_avatar_electric, context.getString(d.j.filter_electric), "electric");
        a(arrayList, d.f.filter_icon_avatar_silver, context.getString(d.j.filter_silver), "silver");
        a(arrayList, d.f.filter_icon_avatar_blackwhite, context.getString(d.j.filter_blackwhite), "blackwhite");
        return arrayList;
    }

    private static void a(List<com.baidu.tieba.video.editvideo.data.a> list, int i, String str, String str2) {
        if (list != null) {
            list.add(new com.baidu.tieba.video.editvideo.data.a(str, i, str2));
        }
    }

    private static String bAE() {
        return com.baidu.tieba.video.b.hmh + "video_addfilter_" + System.currentTimeMillis() + ".mp4";
    }
}
