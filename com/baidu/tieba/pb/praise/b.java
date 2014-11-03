package com.baidu.tieba.pb.praise;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.v;
/* loaded from: classes.dex */
public class b extends com.baidu.tbadk.mvc.i.a<a, com.baidu.tbadk.mvc.e.c> {
    private HeadImageView bzv;
    private TextView bzw;
    private TextView bzx;
    private ImageView bzy;

    public b(View view, ViewEventCenter viewEventCenter) {
        super(view, viewEventCenter);
        this.bzv = null;
        this.bzw = null;
        this.bzx = null;
        this.bzy = null;
        this.bzv = (HeadImageView) view.findViewById(v.zan_list_item_head);
        this.bzw = (TextView) view.findViewById(v.zan_list_item_name);
        this.bzx = (TextView) view.findViewById(v.zan_list_item_time);
        this.bzy = (ImageView) view.findViewById(v.zan_list_item_line_bottom);
        this.bzy.setVisibility(0);
        dg(TbadkApplication.m251getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.e.a
    public boolean dg(int i) {
        com.baidu.tbadk.e.b.u(getRootView());
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.i.d
    /* renamed from: a */
    public void r(a aVar) {
        this.bzw.setText(aVar.getUserName());
        this.bzv.setImageDrawable(null);
        this.bzx.setText(az.j(aVar.Yw()));
        this.bzv.c(aVar.getPortrait(), 28, false);
    }
}
