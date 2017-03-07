package com.baidu.tieba.pb.pb.main;

import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.a.d;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class s implements d.a {
    final /* synthetic */ PbActivity elO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(PbActivity pbActivity) {
        this.elO = pbActivity;
    }

    @Override // com.baidu.tieba.pb.a.d.a
    public boolean a(View view, MotionEvent motionEvent) {
        fa faVar;
        fa faVar2;
        fa faVar3;
        com.baidu.tbadk.editortools.pb.c cVar;
        fa faVar4;
        fa faVar5;
        com.baidu.tbadk.editortools.pb.c cVar2;
        com.baidu.tieba.pb.pb.main.a.f fVar;
        com.baidu.tieba.pb.pb.main.a.f fVar2;
        fa faVar6;
        fa faVar7;
        com.baidu.tbadk.editortools.pb.c cVar3;
        faVar = this.elO.ekM;
        if (faVar.aNJ()) {
            return true;
        }
        faVar2 = this.elO.ekM;
        if (faVar2 == null) {
            return false;
        }
        faVar3 = this.elO.ekM;
        faVar3.iJ(false);
        cVar = this.elO.ekY;
        if (cVar != null) {
            faVar7 = this.elO.ekM;
            cVar3 = this.elO.ekY;
            faVar7.gB(cVar3.Dw());
        }
        faVar4 = this.elO.ekM;
        faVar4.bb(view);
        faVar5 = this.elO.ekM;
        faVar5.iJ(true);
        cVar2 = this.elO.ekY;
        cVar2.Dz();
        fVar = this.elO.eks;
        if (fVar != null) {
            fVar2 = this.elO.eks;
            faVar6 = this.elO.ekM;
            fVar2.iU(faVar6.isFullScreen());
            return true;
        }
        return true;
    }

    @Override // com.baidu.tieba.pb.a.d.a
    public boolean b(View view, MotionEvent motionEvent) {
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x00b7, code lost:
        if (r5 == r0.aNI()) goto L27;
     */
    @Override // com.baidu.tieba.pb.a.d.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean c(View view, MotionEvent motionEvent) {
        com.baidu.tbadk.editortools.pb.c cVar;
        fa faVar;
        com.baidu.tbadk.editortools.pb.c cVar2;
        fa faVar2;
        fa faVar3;
        com.baidu.tbadk.editortools.pb.c cVar3;
        fa faVar4;
        fa faVar5;
        fa faVar6;
        boolean aX;
        if (view != null) {
            if (view.getId() != w.h.richText) {
                if (view.getId() == w.h.pb_list_item_layout) {
                    if (view.getTag(w.h.tag_from) instanceof SparseArray) {
                        this.elO.e((SparseArray) view.getTag(w.h.tag_from));
                    }
                } else if (!(view instanceof TbRichTextView) && view.getId() != w.h.pb_post_header_layout) {
                    faVar4 = this.elO.ekM;
                    if (faVar4 != null) {
                        faVar5 = this.elO.ekM;
                        if (faVar5.aKl()) {
                            if (view.getId() != w.h.pb_head_user_info_root) {
                                faVar6 = this.elO.ekM;
                            }
                            if (view.getTag(w.h.tag_user_id) instanceof String) {
                                TiebaStatic.log(new com.baidu.tbadk.core.util.as("c10630").Z("obj_id", (String) view.getTag(w.h.tag_user_id)));
                            }
                            if (this.elO.ekN != null && this.elO.ekN.etF != null) {
                                this.elO.ekN.etF.onClick(view);
                            }
                        }
                    }
                } else {
                    SparseArray sparseArray = null;
                    if (view.getTag() instanceof SparseArray) {
                        sparseArray = (SparseArray) view.getTag();
                    }
                    if (sparseArray == null) {
                        return false;
                    }
                    this.elO.e(sparseArray);
                }
            } else {
                aX = this.elO.aX(view);
                if (aX) {
                    return true;
                }
            }
        }
        cVar = this.elO.ekY;
        if (cVar != null) {
            faVar3 = this.elO.ekM;
            cVar3 = this.elO.ekY;
            faVar3.gB(cVar3.Dw());
        }
        faVar = this.elO.ekM;
        faVar.aMK();
        cVar2 = this.elO.ekY;
        cVar2.Dz();
        faVar2 = this.elO.ekM;
        faVar2.awO();
        return true;
    }
}
