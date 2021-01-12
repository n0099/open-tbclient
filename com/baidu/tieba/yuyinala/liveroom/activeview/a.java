package com.baidu.tieba.yuyinala.liveroom.activeview;

import android.view.View;
import com.baidu.live.data.p;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.widget.TbImageView;
/* loaded from: classes10.dex */
public class a {
    private View hkM;
    private int mPosition;
    private View mRoot;
    private TbImageView ohN;

    public a(View view, int i) {
        this.mRoot = view;
        this.ohN = (TbImageView) view.findViewById(a.f.ala_live_active_view_img);
        this.hkM = view.findViewById(a.f.new_icon);
        this.ohN.setDefaultErrorResource(0);
        this.ohN.setDefaultBgResource(a.c.sdk_transparent);
        this.ohN.setAutoChangeStyle(false);
        this.mPosition = i;
    }

    public View getRootView() {
        return this.mRoot;
    }

    public void b(p pVar) {
        if (pVar != null) {
            this.mRoot.setTag(a.f.ala_active_view_position, Integer.valueOf(this.mPosition));
            this.mRoot.setTag(a.f.ala_active_view_data, pVar);
            this.ohN.startLoad(pVar.pic_url, 10, false);
            if (pVar.aFk) {
                this.hkM.setVisibility(0);
            } else {
                this.hkM.setVisibility(4);
            }
        }
    }
}
