package com.baidu.tieba.recapp;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.tbadk.widget.TbClipImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.recapp.view.DistributeVideoView;
import com.davemorrissey.labs.subscaleview.decoder.SkiaImageDecoder;
import tbclient.VideoInfo;
/* loaded from: classes3.dex */
public class q implements com.baidu.b.a.b.c {
    @Override // com.baidu.b.a.b.c
    public View I(Context context, String str) {
        if ("image".equalsIgnoreCase(str)) {
            TbClipImageView tbClipImageView = new TbClipImageView(context);
            tbClipImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            tbClipImageView.setDrawerType(1);
            tbClipImageView.setDefaultResource(17170445);
            tbClipImageView.setDefaultBgResource(d.C0126d.cp_bg_line_e);
            return tbClipImageView;
        } else if ("video".equalsIgnoreCase(str)) {
            View inflate = LayoutInflater.from(context).inflate(d.i.ad_card_video_view, (ViewGroup) null);
            DistributeVideoView distributeVideoView = (DistributeVideoView) inflate.findViewById(d.g.advert_video);
            if (distributeVideoView != null) {
                distributeVideoView.setHolderView(inflate);
            }
            return inflate;
        } else {
            return null;
        }
    }

    @Override // com.baidu.b.a.b.c
    public boolean a(String str, View view2, com.baidu.b.a.a.a aVar) {
        DistributeVideoView distributeVideoView;
        if (aVar == null || view2 == null) {
            return false;
        }
        if (view2 instanceof TbClipImageView) {
            if (aVar.Ls > 0.0f) {
                ((TbClipImageView) view2).setRadius((int) (aVar.Ls * view2.getResources().getDisplayMetrics().density));
            } else {
                ((TbClipImageView) view2).setRadius(0);
            }
            ((TbClipImageView) view2).startLoad(aVar.src, 30, false);
            return true;
        } else if (!"video".equalsIgnoreCase(str) || (distributeVideoView = (DistributeVideoView) view2.findViewById(d.g.advert_video)) == null) {
            return false;
        } else {
            int dimension = (int) view2.getContext().getResources().getDimension(d.e.ds278);
            VideoInfo.Builder builder = new VideoInfo.Builder();
            builder.video_url = aVar.src;
            builder.thumbnail_url = aVar.Lr;
            builder.video_duration = Integer.valueOf(aVar.videoDuration);
            builder.video_width = Integer.valueOf(aVar.width);
            builder.video_height = Integer.valueOf(aVar.height);
            distributeVideoView.setData(builder.build(true), (int) (com.baidu.adp.lib.util.l.af(view2.getContext()) - (view2.getContext().getResources().getDimension(d.e.ds44) * 2.0f)), dimension, (int) view2.getContext().getResources().getDimension(d.e.ds640));
            return true;
        }
    }

    @Override // com.baidu.b.a.b.c
    public boolean a(String str, final View view2, final String str2, String str3) {
        if (view2 == null || TextUtils.isEmpty(str2)) {
            return false;
        }
        if (str2.startsWith(SkiaImageDecoder.FILE_PREFIX) && str2.length() > 7) {
            int identifier = com.baidu.adp.base.g.bP().getResources().getIdentifier(str2.substring(7), "drawable", BdBaseApplication.getInst().getPackageName());
            if (!TextUtils.isEmpty(str3) && str3.startsWith(SkiaImageDecoder.FILE_PREFIX) && str3.length() > 7) {
                int identifier2 = com.baidu.adp.base.g.bP().getResources().getIdentifier(str3.substring(7), "drawable", BdBaseApplication.getInst().getPackageName());
                if (identifier2 <= 0 || identifier <= 0) {
                    return true;
                }
                StateListDrawable stateListDrawable = new StateListDrawable();
                Drawable drawable = view2.getResources().getDrawable(identifier2);
                Drawable drawable2 = view2.getResources().getDrawable(identifier);
                stateListDrawable.addState(new int[]{16842919}, drawable);
                stateListDrawable.addState(new int[]{-16842919}, drawable2);
                view2.setBackgroundDrawable(stateListDrawable);
                return true;
            } else if (identifier > 0) {
                view2.setBackgroundResource(identifier);
                return true;
            } else {
                return true;
            }
        }
        com.baidu.adp.lib.f.c.fp().a(str2, 17, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.recapp.q.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str4, int i) {
                if (str2.equalsIgnoreCase(str4)) {
                    view2.setBackgroundDrawable(aVar.kn());
                }
            }
        }, null);
        return true;
    }
}
