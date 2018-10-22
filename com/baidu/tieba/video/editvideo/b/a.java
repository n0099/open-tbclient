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
    private com.baidu.tieba.video.editvideo.data.a hsP;
    private b hsQ;
    b.a hsR;
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void a(com.baidu.tieba.video.editvideo.data.a aVar) {
        this.hsP = aVar;
    }

    public boolean bGR() {
        return (this.hsP == null || "normal".equalsIgnoreCase(this.hsP.value)) ? false : true;
    }

    public void vY(String str) {
        if ((this.hsQ == null || !this.hsQ.isRunning()) && !TextUtils.isEmpty(str) && new File(str).exists()) {
            String bGU = bGU();
            String str2 = "normal";
            if (this.hsP != null) {
                str2 = this.hsP.value;
            }
            this.hsQ = new b(this.mContext, str, bGU, str2);
            if (this.hsR != null) {
                this.hsQ.a(this.hsR);
            }
            this.hsQ.bGV();
        }
    }

    public boolean bGS() {
        if (this.hsQ != null) {
            return this.hsQ.isRunning();
        }
        return false;
    }

    public void bGT() {
        if (this.hsQ != null) {
            this.hsQ.bGW();
        }
    }

    public void a(b.a aVar) {
        this.hsR = aVar;
        if (this.hsQ != null) {
            this.hsQ.a(this.hsR);
        }
    }

    public static List<com.baidu.tieba.video.editvideo.data.a> de(Context context) {
        ArrayList arrayList = new ArrayList();
        if (context == null) {
            context = TbadkCoreApplication.getInst();
        }
        a(arrayList, e.f.filter_icon_avatar_default, context.getString(e.j.filter_nature), "nature");
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

    private static String bGU() {
        return com.baidu.tieba.video.c.hqN + "video_addfilter_" + System.currentTimeMillis() + ".mp4";
    }
}
