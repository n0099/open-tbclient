package com.baidu.tieba.pb.pb.praise;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.v;
/* loaded from: classes.dex */
public class b extends com.baidu.tbadk.mvc.j.a<a, com.baidu.tbadk.mvc.e.c> {
    private HeadImageView mItemHead;
    private ImageView mItemLineBottom;
    private TextView mItemName;
    private TextView mItemTime;

    public b(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.mItemHead = null;
        this.mItemName = null;
        this.mItemTime = null;
        this.mItemLineBottom = null;
        this.mItemHead = (HeadImageView) view.findViewById(v.zan_list_item_head);
        this.mItemName = (TextView) view.findViewById(v.zan_list_item_name);
        this.mItemTime = (TextView) view.findViewById(v.zan_list_item_time);
        this.mItemLineBottom = (ImageView) view.findViewById(v.zan_list_item_line_bottom);
        this.mItemLineBottom.setVisibility(0);
    }

    @Override // com.baidu.tieba.tbadkCore.ab
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.f.a.a(tbPageContext, getRootView());
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.j.e
    /* renamed from: a */
    public void A(a aVar) {
        super.A(aVar);
        this.mItemName.setText(aVar.getUserName());
        this.mItemHead.setImageDrawable(null);
        this.mItemTime.setText(bd.n(aVar.abC()));
        this.mItemHead.c(aVar.getPortrait(), 28, false);
    }
}
