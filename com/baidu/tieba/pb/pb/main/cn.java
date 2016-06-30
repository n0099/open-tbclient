package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.recapp.PbRecBaseViewHolder;
import com.baidu.tieba.u;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class cn extends cr<com.baidu.tieba.tbadkCore.data.r, PbRecBaseViewHolder> {
    private WeakReference<PbRecBaseViewHolder> dQp;

    /* JADX INFO: Access modifiers changed from: protected */
    public cn(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        this.dQp = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bf */
    public PbRecBaseViewHolder a(ViewGroup viewGroup) {
        return com.baidu.tieba.recapp.a.aUI().n(this.mContext, 2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.cr, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.data.r rVar, PbRecBaseViewHolder pbRecBaseViewHolder) {
        super.a(i, view, viewGroup, (ViewGroup) rVar, (com.baidu.tieba.tbadkCore.data.r) pbRecBaseViewHolder);
        this.mSkinType = TbadkCoreApplication.m9getInst().getSkinType();
        this.dOg.getLayoutMode().ad(this.mSkinType == 1);
        this.dOg.getLayoutMode().w(view);
        if (pbRecBaseViewHolder.getRootView() != null) {
            com.baidu.tbadk.core.util.av.l(pbRecBaseViewHolder.getRootView(), u.d.cp_bg_line_d);
        }
        pbRecBaseViewHolder.update((com.baidu.tieba.tbadkCore.data.r) at(i), i, this.mIsFromCDN);
        if (this.dQp == null || this.dQp.get() != pbRecBaseViewHolder) {
            this.dQp = new WeakReference<>(pbRecBaseViewHolder);
        }
        return view;
    }

    public void updateFontSize() {
        PbRecBaseViewHolder pbRecBaseViewHolder = this.dQp != null ? this.dQp.get() : null;
        if (pbRecBaseViewHolder != null) {
            pbRecBaseViewHolder.updateFontSize();
        }
    }
}
