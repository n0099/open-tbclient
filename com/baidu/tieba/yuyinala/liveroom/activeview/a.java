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
    private TbImageView oms;

    public a(View view, int i) {
        this.mRoot = view;
        this.oms = (TbImageView) view.findViewById(a.f.ala_live_active_view_img);
        this.hpt = view.findViewById(a.f.new_icon);
        this.oms.setDefaultErrorResource(0);
        this.oms.setDefaultBgResource(a.c.sdk_transparent);
        this.oms.setAutoChangeStyle(false);
        this.mPosition = i;
    }

    public View getRootView() {
        return this.mRoot;
    }

    public void b(p pVar) {
        if (pVar != null) {
            this.mRoot.setTag(a.f.ala_active_view_position, Integer.valueOf(this.mPosition));
            this.mRoot.setTag(a.f.ala_active_view_data, pVar);
            this.oms.startLoad(pVar.pic_url, 10, false);
            if (pVar.aJX) {
                this.hpt.setVisibility(0);
            } else {
                this.hpt.setVisibility(4);
            }
        }
    }
}
