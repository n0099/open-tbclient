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
    private com.baidu.tieba.video.editvideo.data.a gRE;
    private b gRF;
    b.a gRG;
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void a(com.baidu.tieba.video.editvideo.data.a aVar) {
        this.gRE = aVar;
    }

    public boolean bBH() {
        return (this.gRE == null || "normal".equalsIgnoreCase(this.gRE.value)) ? false : true;
    }

    public void ud(String str) {
        if ((this.gRF == null || !this.gRF.isRunning()) && !TextUtils.isEmpty(str) && new File(str).exists()) {
            String bBK = bBK();
            String str2 = "normal";
            if (this.gRE != null) {
                str2 = this.gRE.value;
            }
            this.gRF = new b(this.mContext, str, bBK, str2);
            if (this.gRG != null) {
                this.gRF.a(this.gRG);
            }
            this.gRF.bBL();
        }
    }

    public boolean bBI() {
        if (this.gRF != null) {
            return this.gRF.isRunning();
        }
        return false;
    }

    public void bBJ() {
        if (this.gRF != null) {
            this.gRF.bBM();
        }
    }

    public void a(b.a aVar) {
        this.gRG = aVar;
        if (this.gRF != null) {
            this.gRF.a(this.gRG);
        }
    }

    public static List<com.baidu.tieba.video.editvideo.data.a> cg(Context context) {
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

    private static String bBK() {
        return com.baidu.tieba.video.b.gPG + "video_addfilter_" + System.currentTimeMillis() + ".mp4";
    }
}
