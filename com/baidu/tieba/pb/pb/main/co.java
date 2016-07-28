package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.recapp.PbRecBaseViewHolder;
import com.baidu.tieba.u;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class co extends cs<com.baidu.tieba.tbadkCore.data.r, PbRecBaseViewHolder> {
    private WeakReference<PbRecBaseViewHolder> ecE;

    /* JADX INFO: Access modifiers changed from: protected */
    public co(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        this.ecE = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bn */
    public PbRecBaseViewHolder a(ViewGroup viewGroup) {
        return com.baidu.tieba.recapp.a.aXW().n(this.mContext, 2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.cs, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.data.r rVar, PbRecBaseViewHolder pbRecBaseViewHolder) {
        super.a(i, view, viewGroup, (ViewGroup) rVar, (com.baidu.tieba.tbadkCore.data.r) pbRecBaseViewHolder);
        this.mSkinType = TbadkCoreApplication.m10getInst().getSkinType();
        this.eat.getLayoutMode().af(this.mSkinType == 1);
        this.eat.getLayoutMode().w(view);
        if (pbRecBaseViewHolder.getRootView() != null) {
            com.baidu.tbadk.core.util.av.l(pbRecBaseViewHolder.getRootView(), u.d.cp_bg_line_d);
        }
        pbRecBaseViewHolder.update((com.baidu.tieba.tbadkCore.data.r) aw(i), i, this.mIsFromCDN);
        if (this.ecE == null || this.ecE.get() != pbRecBaseViewHolder) {
            this.ecE = new WeakReference<>(pbRecBaseViewHolder);
        }
        return view;
    }

    public void updateFontSize() {
        PbRecBaseViewHolder pbRecBaseViewHolder = this.ecE != null ? this.ecE.get() : null;
        if (pbRecBaseViewHolder != null) {
            pbRecBaseViewHolder.updateFontSize();
        }
    }
}
