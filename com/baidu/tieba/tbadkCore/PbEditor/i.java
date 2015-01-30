package com.baidu.tieba.tbadkCore.PbEditor;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.tbadkCore.bubble.BubbleListData;
/* loaded from: classes.dex */
class i implements ap {
    final /* synthetic */ b bVj;
    private final /* synthetic */ Context val$context;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(b bVar, Context context) {
        this.bVj = bVar;
        this.val$context = context;
    }

    @Override // com.baidu.tieba.tbadkCore.PbEditor.ap
    public View getView(int i, View view, ViewGroup viewGroup) {
        com.baidu.tieba.tbadkCore.bubble.z zVar;
        BubbleListData.BubbleData hM;
        Context context;
        BubbleListData bubbleListData;
        View.OnClickListener onClickListener;
        if (view == null) {
            zVar = new com.baidu.tieba.tbadkCore.bubble.z(this.val$context);
            view = zVar;
        } else {
            zVar = (com.baidu.tieba.tbadkCore.bubble.z) view;
        }
        hM = this.bVj.hM(i);
        if (hM != null) {
            bubbleListData = this.bVj.bUZ;
            zVar.a(hM, com.baidu.tieba.tbadkCore.bubble.h.aI(bubbleListData.getB_info()));
            zVar.setGravity(17);
            zVar.setTag(Integer.valueOf(i));
            onClickListener = this.bVj.bVg;
            zVar.setOnClickListener(onClickListener);
        }
        int skinType = TbadkCoreApplication.m255getInst().getSkinType();
        context = this.bVj.mContext;
        TbPageContext tbPageContext = (TbPageContext) com.baidu.adp.base.m.D(context);
        tbPageContext.getLayoutMode().ab(skinType == 1);
        tbPageContext.getLayoutMode().h(view);
        return view;
    }
}
