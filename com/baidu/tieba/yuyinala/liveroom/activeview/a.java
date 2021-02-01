package com.baidu.tieba.yuyinala.liveroom.activeview;

import android.view.View;
import com.baidu.live.data.t;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.widget.TbImageView;
/* loaded from: classes11.dex */
public class a {
    private View hoZ;
    private int mPosition;
    private View mRoot;
    private TbImageView orI;

    public a(View view, int i) {
        this.mRoot = view;
        this.orI = (TbImageView) view.findViewById(a.f.ala_live_active_view_img);
        this.hoZ = view.findViewById(a.f.new_icon);
        this.orI.setDefaultErrorResource(0);
        this.orI.setDefaultBgResource(a.c.sdk_transparent);
        this.orI.setAutoChangeStyle(false);
        this.mPosition = i;
    }

    public View getRootView() {
        return this.mRoot;
    }

    public void b(t tVar) {
        if (tVar != null) {
            this.mRoot.setTag(a.f.ala_active_view_position, Integer.valueOf(this.mPosition));
            this.mRoot.setTag(a.f.ala_active_view_data, tVar);
            this.orI.startLoad(tVar.pic_url, 10, false);
            if (tVar.aHG) {
                this.hoZ.setVisibility(0);
            } else {
                this.hoZ.setVisibility(4);
            }
        }
    }
}
