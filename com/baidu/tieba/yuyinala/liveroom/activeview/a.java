package com.baidu.tieba.yuyinala.liveroom.activeview;

import android.view.View;
import com.baidu.live.data.p;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.widget.TbImageView;
/* loaded from: classes11.dex */
public class a {
    private View hpt;
    private int mPosition;
    private View mRoot;
    private TbImageView omt;

    public a(View view, int i) {
        this.mRoot = view;
        this.omt = (TbImageView) view.findViewById(a.f.ala_live_active_view_img);
        this.hpt = view.findViewById(a.f.new_icon);
        this.omt.setDefaultErrorResource(0);
        this.omt.setDefaultBgResource(a.c.sdk_transparent);
        this.omt.setAutoChangeStyle(false);
        this.mPosition = i;
    }

    public View getRootView() {
        return this.mRoot;
    }

    public void b(p pVar) {
        if (pVar != null) {
            this.mRoot.setTag(a.f.ala_active_view_position, Integer.valueOf(this.mPosition));
            this.mRoot.setTag(a.f.ala_active_view_data, pVar);
            this.omt.startLoad(pVar.pic_url, 10, false);
            if (pVar.aJX) {
                this.hpt.setVisibility(0);
            } else {
                this.hpt.setVisibility(4);
            }
        }
    }
}
