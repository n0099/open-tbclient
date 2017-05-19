package com.baidu.tieba.write.view;

import com.baidu.tieba.write.view.NewFrameMultiImgToolView;
/* loaded from: classes.dex */
class f implements com.baidu.tbadk.editortools.b {
    final /* synthetic */ NewFrameMultiImgToolView fPN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(NewFrameMultiImgToolView newFrameMultiImgToolView) {
        this.fPN = newFrameMultiImgToolView;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        NewFrameMultiImgToolView.b bVar;
        int i;
        NewFrameMultiImgToolView.b bVar2;
        if (aVar != null) {
            switch (aVar.code) {
                case 9:
                    bVar = this.fPN.fPL;
                    if (bVar != null) {
                        bVar2 = this.fPN.fPL;
                        bVar2.notifyDataSetChanged();
                    }
                    NewFrameMultiImgToolView newFrameMultiImgToolView = this.fPN;
                    i = this.fPN.aAg;
                    newFrameMultiImgToolView.b(new com.baidu.tbadk.editortools.a(2, i, null));
                    return;
                case 12:
                case 46:
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a)) {
                        this.fPN.a(((com.baidu.tbadk.editortools.imagetool.a) aVar.data).azU, ((com.baidu.tbadk.editortools.imagetool.a) aVar.data).azV);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
