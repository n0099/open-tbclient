package com.baidu.tieba.personCenter.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.TbPageContext;
import java.util.List;
/* loaded from: classes2.dex */
public class c {
    private BdTypeListView gzp;
    private a mtN;

    public c(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.gzp = bdTypeListView;
        this.mtN = new a(bdTypeListView, tbPageContext, bdUniqueId);
    }

    public void setData(List<n> list) {
        this.gzp.setData(list);
    }

    public void notifyDataSetChanged() {
        this.mtN.onChangeSkinType();
    }

    public void onChangeSkinType() {
        this.mtN.onChangeSkinType();
    }

    public void dwF() {
        this.mtN.dwF();
    }

    public void dwG() {
        this.mtN.dwG();
    }
}
