package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.recapp.PbRecBaseViewHolder;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class cd extends cm<com.baidu.tieba.tbadkCore.data.r, PbRecBaseViewHolder> {
    /* JADX INFO: Access modifiers changed from: protected */
    public cd(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aF */
    public PbRecBaseViewHolder b(ViewGroup viewGroup) {
        return com.baidu.tieba.recapp.a.aLA().m(this.mContext, 1);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.cm, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.data.r rVar, PbRecBaseViewHolder pbRecBaseViewHolder) {
        super.a(i, view, viewGroup, (ViewGroup) rVar, (com.baidu.tieba.tbadkCore.data.r) pbRecBaseViewHolder);
        this.mSkinType = TbadkCoreApplication.m11getInst().getSkinType();
        this.dhY.getLayoutMode().ae(this.mSkinType == 1);
        this.dhY.getLayoutMode().x(view);
        if (pbRecBaseViewHolder.getRootView() != null) {
            com.baidu.tbadk.core.util.at.l(pbRecBaseViewHolder.getRootView(), t.d.cp_bg_line_d);
        }
        pbRecBaseViewHolder.update((com.baidu.tieba.tbadkCore.data.r) at(i), i, this.mIsFromCDN);
        return view;
    }
}
