package com.baidu.tieba.yuyinala.liveroom.activeview;

import android.view.View;
import com.baidu.live.data.t;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.widget.TbImageView;
/* loaded from: classes11.dex */
public class a {
    private View hpn;
    private int mPosition;
    private View mRoot;
    private TbImageView osi;

    public a(View view, int i) {
        this.mRoot = view;
        this.osi = (TbImageView) view.findViewById(a.f.ala_live_active_view_img);
        this.hpn = view.findViewById(a.f.new_icon);
        this.osi.setDefaultErrorResource(0);
        this.osi.setDefaultBgResource(a.c.sdk_transparent);
        this.osi.setAutoChangeStyle(false);
        this.mPosition = i;
    }

    public View getRootView() {
        return this.mRoot;
    }

    public void b(t tVar) {
        if (tVar != null) {
            this.mRoot.setTag(a.f.ala_active_view_position, Integer.valueOf(this.mPosition));
            this.mRoot.setTag(a.f.ala_active_view_data, tVar);
            this.osi.startLoad(tVar.pic_url, 10, false);
            if (tVar.aHG) {
                this.hpn.setVisibility(0);
            } else {
                this.hpn.setVisibility(4);
            }
        }
    }
}
