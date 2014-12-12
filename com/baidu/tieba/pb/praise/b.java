package com.baidu.tieba.pb.praise;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.w;
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
        this.mItemHead = (HeadImageView) view.findViewById(w.zan_list_item_head);
        this.mItemName = (TextView) view.findViewById(w.zan_list_item_name);
        this.mItemTime = (TextView) view.findViewById(w.zan_list_item_time);
        this.mItemLineBottom = (ImageView) view.findViewById(w.zan_list_item_line_bottom);
        this.mItemLineBottom.setVisibility(0);
    }

    @Override // com.baidu.tieba.tbadkCore.y
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.g.a.a(tbPageContext, getRootView());
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.j.d
    /* renamed from: a */
    public void y(a aVar) {
        super.y(aVar);
        this.mItemName.setText(aVar.getUserName());
        this.mItemHead.setImageDrawable(null);
        this.mItemTime.setText(ba.n(aVar.YU()));
        this.mItemHead.d(aVar.getPortrait(), 28, false);
    }
}
