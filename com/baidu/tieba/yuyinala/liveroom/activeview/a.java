package com.baidu.tieba.yuyinala.liveroom.activeview;

import android.view.View;
import com.baidu.live.data.o;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.widget.TbImageView;
/* loaded from: classes4.dex */
public class a {
    private TbImageView gUq;
    private View gUr;
    private int mPosition;
    private View mRoot;

    public a(View view, int i) {
        this.mRoot = view;
        this.gUq = (TbImageView) view.findViewById(a.f.ala_live_active_view_img);
        this.gUr = view.findViewById(a.f.new_icon);
        this.gUq.setDefaultErrorResource(0);
        this.gUq.setDefaultBgResource(a.c.sdk_transparent);
        this.gUq.setAutoChangeStyle(false);
        this.mPosition = i;
    }

    public View getRootView() {
        return this.mRoot;
    }

    public void b(o oVar) {
        if (oVar != null) {
            this.mRoot.setTag(a.f.ala_active_view_position, Integer.valueOf(this.mPosition));
            this.mRoot.setTag(a.f.ala_active_view_data, oVar);
            this.gUq.startLoad(oVar.pic_url, 10, false);
            if (oVar.aGO) {
                this.gUr.setVisibility(0);
            } else {
                this.gUr.setVisibility(4);
            }
        }
    }
}
