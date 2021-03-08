package com.baidu.tieba.yuyinala.liveroom.activeview;

import android.view.View;
import com.baidu.live.data.t;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.widget.TbImageView;
/* loaded from: classes10.dex */
public class a {
    private View hqW;
    private int mPosition;
    private View mRoot;
    private TbImageView oun;

    public a(View view, int i) {
        this.mRoot = view;
        this.oun = (TbImageView) view.findViewById(a.f.ala_live_active_view_img);
        this.hqW = view.findViewById(a.f.new_icon);
        this.oun.setDefaultErrorResource(0);
        this.oun.setDefaultBgResource(a.c.sdk_transparent);
        this.oun.setAutoChangeStyle(false);
        this.mPosition = i;
    }

    public View getRootView() {
        return this.mRoot;
    }

    public void b(t tVar) {
        if (tVar != null) {
            this.mRoot.setTag(a.f.ala_active_view_position, Integer.valueOf(this.mPosition));
            this.mRoot.setTag(a.f.ala_active_view_data, tVar);
            this.oun.startLoad(tVar.pic_url, 10, false);
            if (tVar.aJg) {
                this.hqW.setVisibility(0);
            } else {
                this.hqW.setVisibility(4);
            }
        }
    }
}
