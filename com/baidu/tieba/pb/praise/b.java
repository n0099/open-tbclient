package com.baidu.tieba.pb.praise;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.v;
/* loaded from: classes.dex */
public class b extends com.baidu.tbadk.mvc.i.a<a, com.baidu.tbadk.mvc.e.c> {
    private HeadImageView bzh;
    private TextView bzi;
    private TextView bzj;
    private ImageView bzk;

    public b(View view, ViewEventCenter viewEventCenter) {
        super(view, viewEventCenter);
        this.bzh = null;
        this.bzi = null;
        this.bzj = null;
        this.bzk = null;
        this.bzh = (HeadImageView) view.findViewById(v.zan_list_item_head);
        this.bzi = (TextView) view.findViewById(v.zan_list_item_name);
        this.bzj = (TextView) view.findViewById(v.zan_list_item_time);
        this.bzk = (ImageView) view.findViewById(v.zan_list_item_line_bottom);
        this.bzk.setVisibility(0);
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
        this.bzi.setText(aVar.getUserName());
        this.bzh.setImageDrawable(null);
        this.bzj.setText(ay.j(aVar.Yt()));
        this.bzh.c(aVar.getPortrait(), 28, false);
    }
}
