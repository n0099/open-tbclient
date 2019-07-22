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
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.view.DistributeVideoView;
import com.baidu.tieba.recapp.widget.CriusTbClipImageView;
import com.davemorrissey.labs.subscaleview.decoder.SkiaImageDecoder;
import tbclient.VideoInfo;
/* loaded from: classes3.dex */
public class q implements com.baidu.c.a.b.c {
    @Override // com.baidu.c.a.b.c
    public View L(Context context, String str) {
        if ("image".equalsIgnoreCase(str)) {
            CriusTbClipImageView criusTbClipImageView = new CriusTbClipImageView(context);
            criusTbClipImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            criusTbClipImageView.setDrawerType(1);
            criusTbClipImageView.setDefaultResource(17170445);
            criusTbClipImageView.setDefaultBgResource(R.color.cp_bg_line_e);
            return criusTbClipImageView;
        } else if ("video".equalsIgnoreCase(str)) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.ad_card_video_view, (ViewGroup) null);
            DistributeVideoView distributeVideoView = (DistributeVideoView) inflate.findViewById(R.id.advert_video);
            if (distributeVideoView != null) {
                distributeVideoView.setHolderView(inflate);
            }
            return inflate;
        } else {
            return null;
        }
    }

    @Override // com.baidu.c.a.b.c
    public boolean a(String str, View view, com.baidu.c.a.a.a aVar) {
        DistributeVideoView distributeVideoView;
        if (aVar == null || view == null) {
            return false;
        }
        if (view instanceof CriusTbClipImageView) {
            float f = view.getResources().getDisplayMetrics().density;
            if (aVar.abe > 0.0f) {
                int D = D(aVar.abe, f);
                ((CriusTbClipImageView) view).setRadius(D, D, D, D);
            } else {
                ((CriusTbClipImageView) view).setRadius(D(aVar.abf, f), D(aVar.abg, f), D(aVar.abh, f), D(aVar.abi, f));
            }
            ((CriusTbClipImageView) view).startLoad(aVar.src, 30, false);
            return true;
        } else if (!"video".equalsIgnoreCase(str) || (distributeVideoView = (DistributeVideoView) view.findViewById(R.id.advert_video)) == null) {
            return false;
        } else {
            int dimension = (int) view.getContext().getResources().getDimension(R.dimen.ds278);
            VideoInfo.Builder builder = new VideoInfo.Builder();
            builder.video_url = aVar.src;
            builder.thumbnail_url = aVar.abd;
            builder.video_duration = Integer.valueOf(aVar.videoDuration);
            builder.video_width = Integer.valueOf(aVar.width);
            builder.video_height = Integer.valueOf(aVar.height);
            distributeVideoView.setData(builder.build(true), (int) (com.baidu.adp.lib.util.l.af(view.getContext()) - (view.getContext().getResources().getDimension(R.dimen.ds44) * 2.0f)), dimension, (int) view.getContext().getResources().getDimension(R.dimen.ds640));
            return true;
        }
    }

    @Override // com.baidu.c.a.b.c
    public boolean a(String str, final View view, final String str2, String str3) {
        if (view == null || TextUtils.isEmpty(str2)) {
            return false;
        }
        if (str2.startsWith(SkiaImageDecoder.FILE_PREFIX) && str2.length() > 7) {
            int identifier = com.baidu.adp.base.g.eZ().getResources().getIdentifier(str2.substring(7), "drawable", BdBaseApplication.getInst().getPackageName());
            if (!TextUtils.isEmpty(str3) && str3.startsWith(SkiaImageDecoder.FILE_PREFIX) && str3.length() > 7) {
                int identifier2 = com.baidu.adp.base.g.eZ().getResources().getIdentifier(str3.substring(7), "drawable", BdBaseApplication.getInst().getPackageName());
                if (identifier2 <= 0 || identifier <= 0) {
                    return true;
                }
                StateListDrawable stateListDrawable = new StateListDrawable();
                Drawable drawable = view.getResources().getDrawable(identifier2);
                Drawable drawable2 = view.getResources().getDrawable(identifier);
                stateListDrawable.addState(new int[]{16842919}, drawable);
                stateListDrawable.addState(new int[]{-16842919}, drawable2);
                view.setBackgroundDrawable(stateListDrawable);
                return true;
            } else if (identifier > 0) {
                view.setBackgroundResource(identifier);
                return true;
            } else {
                return true;
            }
        }
        com.baidu.adp.lib.f.c.iE().a(str2, 17, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.recapp.q.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str4, int i) {
                if (str2.equalsIgnoreCase(str4)) {
                    view.setBackgroundDrawable(aVar.nM());
                }
            }
        }, null);
        return true;
    }

    private int D(float f, float f2) {
        return (int) (Math.max(f, 0.0f) * f2);
    }
}
