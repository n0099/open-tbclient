package com.baidu.tieba.write.view;

import com.baidu.tieba.w;
import com.baidu.tieba.write.view.NewFrameMultiImgToolView;
/* loaded from: classes.dex */
class f implements com.baidu.tbadk.editortools.b {
    final /* synthetic */ NewFrameMultiImgToolView fXJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(NewFrameMultiImgToolView newFrameMultiImgToolView) {
        this.fXJ = newFrameMultiImgToolView;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        NewFrameMultiImgToolView.b bVar;
        int i;
        NewFrameMultiImgToolView.b bVar2;
        if (aVar != null) {
            switch (aVar.code) {
                case 9:
                    bVar = this.fXJ.fXH;
                    if (bVar != null) {
                        bVar2 = this.fXJ.fXH;
                        bVar2.notifyDataSetChanged();
                    }
                    NewFrameMultiImgToolView newFrameMultiImgToolView = this.fXJ;
                    i = this.fXJ.azS;
                    newFrameMultiImgToolView.b(new com.baidu.tbadk.editortools.a(2, i, null));
                    return;
                case 12:
                case w.n.View_hapticFeedbackEnabled /* 46 */:
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a)) {
                        this.fXJ.a(((com.baidu.tbadk.editortools.imagetool.a) aVar.data).azG, ((com.baidu.tbadk.editortools.imagetool.a) aVar.data).azH);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
