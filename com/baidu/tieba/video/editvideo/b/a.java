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
    private com.baidu.tieba.video.editvideo.data.a gMN;
    private b gMO;
    b.a gMP;
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void a(com.baidu.tieba.video.editvideo.data.a aVar) {
        this.gMN = aVar;
    }

    public boolean bwu() {
        return (this.gMN == null || "normal".equalsIgnoreCase(this.gMN.value)) ? false : true;
    }

    public void tV(String str) {
        if ((this.gMO == null || !this.gMO.isRunning()) && !TextUtils.isEmpty(str) && new File(str).exists()) {
            String bwx = bwx();
            String str2 = "normal";
            if (this.gMN != null) {
                str2 = this.gMN.value;
            }
            this.gMO = new b(this.mContext, str, bwx, str2);
            if (this.gMP != null) {
                this.gMO.a(this.gMP);
            }
            this.gMO.bwy();
        }
    }

    public boolean bwv() {
        if (this.gMO != null) {
            return this.gMO.isRunning();
        }
        return false;
    }

    public void bww() {
        if (this.gMO != null) {
            this.gMO.bwz();
        }
    }

    public void a(b.a aVar) {
        this.gMP = aVar;
        if (this.gMO != null) {
            this.gMO.a(this.gMP);
        }
    }

    public static List<com.baidu.tieba.video.editvideo.data.a> cc(Context context) {
        ArrayList arrayList = new ArrayList();
        if (context == null) {
            context = TbadkCoreApplication.getInst();
        }
        a(arrayList, d.f.filter_icon_avatar_default, context.getString(d.k.filter_nature), "nature");
        a(arrayList, d.f.filter_icon_avatar_hongkong, context.getString(d.k.filter_hongkong), "hongkong");
        a(arrayList, d.f.filter_icon_avatar_refreshing, context.getString(d.k.filter_refreshing), "refreshing");
        a(arrayList, d.f.filter_icon_avatar_girly, context.getString(d.k.filter_girly), "girly");
        a(arrayList, d.f.filter_icon_avatar_concrete, context.getString(d.k.filter_concrete), "concrete");
        a(arrayList, d.f.filter_icon_avatar_warm, context.getString(d.k.filter_warm), "warm");
        a(arrayList, d.f.filter_icon_avatar_cold, context.getString(d.k.filter_cold), "cold");
        a(arrayList, d.f.filter_icon_avatar_japanese, context.getString(d.k.filter_japanese), "Japanese");
        a(arrayList, d.f.filter_icon_avatar_cruz, context.getString(d.k.filter_hdr), "cruz");
        a(arrayList, d.f.filter_icon_avatar_abao, context.getString(d.k.filter_abao), "abao");
        a(arrayList, d.f.filter_icon_avatar_dew, context.getString(d.k.filter_dew), "dew");
        a(arrayList, d.f.filter_icon_avatar_slowlived, context.getString(d.k.filter_slowlived), "slowlived");
        a(arrayList, d.f.filter_icon_avatar_sweet, context.getString(d.k.filter_sweet), "sweet");
        a(arrayList, d.f.filter_icon_avatar_boardwalk, context.getString(d.k.filter_boardwalk), "boardwalk");
        a(arrayList, d.f.filter_icon_avatar_keylime, context.getString(d.k.filter_keylime), "keylime");
        a(arrayList, d.f.filter_icon_avatar_electric, context.getString(d.k.filter_electric), "electric");
        a(arrayList, d.f.filter_icon_avatar_silver, context.getString(d.k.filter_silver), "silver");
        a(arrayList, d.f.filter_icon_avatar_blackwhite, context.getString(d.k.filter_blackwhite), "blackwhite");
        return arrayList;
    }

    private static void a(List<com.baidu.tieba.video.editvideo.data.a> list, int i, String str, String str2) {
        if (list != null) {
            list.add(new com.baidu.tieba.video.editvideo.data.a(str, i, str2));
        }
    }

    private static String bwx() {
        return com.baidu.tieba.video.b.gKJ + "video_addfilter_" + System.currentTimeMillis() + ".mp4";
    }
}
