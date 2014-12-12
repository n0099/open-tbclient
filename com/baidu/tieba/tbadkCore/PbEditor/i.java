package com.baidu.tieba.tbadkCore.PbEditor;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.tbadkCore.bubble.BubbleListData;
/* loaded from: classes.dex */
class i implements ap {
    final /* synthetic */ b bTq;
    private final /* synthetic */ Context val$context;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(b bVar, Context context) {
        this.bTq = bVar;
        this.val$context = context;
    }

    @Override // com.baidu.tieba.tbadkCore.PbEditor.ap
    public View getView(int i, View view, ViewGroup viewGroup) {
        com.baidu.tieba.tbadkCore.bubble.z zVar;
        BubbleListData.BubbleData hD;
        Context context;
        BubbleListData bubbleListData;
        View.OnClickListener onClickListener;
        if (view == null) {
            zVar = new com.baidu.tieba.tbadkCore.bubble.z(this.val$context);
            view = zVar;
        } else {
            zVar = (com.baidu.tieba.tbadkCore.bubble.z) view;
        }
        hD = this.bTq.hD(i);
        if (hD != null) {
            bubbleListData = this.bTq.bTg;
            zVar.a(hD, com.baidu.tieba.tbadkCore.bubble.h.aF(bubbleListData.getB_info()));
            zVar.setGravity(17);
            zVar.setTag(Integer.valueOf(i));
            onClickListener = this.bTq.bTn;
            zVar.setOnClickListener(onClickListener);
        }
        int skinType = TbadkCoreApplication.m255getInst().getSkinType();
        context = this.bTq.mContext;
        TbPageContext tbPageContext = (TbPageContext) com.baidu.adp.base.m.D(context);
        tbPageContext.getLayoutMode().ab(skinType == 1);
        tbPageContext.getLayoutMode().h(view);
        return view;
    }
}
