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
    final /* synthetic */ PbActivity ejU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(PbActivity pbActivity) {
        this.ejU = pbActivity;
    }

    @Override // com.baidu.tieba.pb.a.d.a
    public boolean a(View view, MotionEvent motionEvent) {
        ey eyVar;
        ey eyVar2;
        ey eyVar3;
        com.baidu.tbadk.editortools.pb.c cVar;
        ey eyVar4;
        ey eyVar5;
        com.baidu.tbadk.editortools.pb.c cVar2;
        com.baidu.tieba.pb.pb.main.a.f fVar;
        com.baidu.tieba.pb.pb.main.a.f fVar2;
        ey eyVar6;
        ey eyVar7;
        com.baidu.tbadk.editortools.pb.c cVar3;
        eyVar = this.ejU.eiS;
        if (eyVar.aNS()) {
            return true;
        }
        eyVar2 = this.ejU.eiS;
        if (eyVar2 == null) {
            return false;
        }
        eyVar3 = this.ejU.eiS;
        eyVar3.iI(false);
        cVar = this.ejU.eje;
        if (cVar != null) {
            eyVar7 = this.ejU.eiS;
            cVar3 = this.ejU.eje;
            eyVar7.gB(cVar3.DU());
        }
        eyVar4 = this.ejU.eiS;
        eyVar4.aZ(view);
        eyVar5 = this.ejU.eiS;
        eyVar5.iI(true);
        cVar2 = this.ejU.eje;
        cVar2.DX();
        fVar = this.ejU.eiy;
        if (fVar != null) {
            fVar2 = this.ejU.eiy;
            eyVar6 = this.ejU.eiS;
            fVar2.iT(eyVar6.isFullScreen());
            return true;
        }
        return true;
    }

    @Override // com.baidu.tieba.pb.a.d.a
    public boolean b(View view, MotionEvent motionEvent) {
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x00b7, code lost:
        if (r5 == r0.aNR()) goto L27;
     */
    @Override // com.baidu.tieba.pb.a.d.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean c(View view, MotionEvent motionEvent) {
        com.baidu.tbadk.editortools.pb.c cVar;
        ey eyVar;
        com.baidu.tbadk.editortools.pb.c cVar2;
        ey eyVar2;
        ey eyVar3;
        com.baidu.tbadk.editortools.pb.c cVar3;
        ey eyVar4;
        ey eyVar5;
        ey eyVar6;
        boolean aV;
        if (view != null) {
            if (view.getId() != w.h.richText) {
                if (view.getId() == w.h.pb_list_item_layout) {
                    if (view.getTag(w.h.tag_from) instanceof SparseArray) {
                        this.ejU.e((SparseArray) view.getTag(w.h.tag_from));
                    }
                } else if (!(view instanceof TbRichTextView) && view.getId() != w.h.pb_post_header_layout) {
                    eyVar4 = this.ejU.eiS;
                    if (eyVar4 != null) {
                        eyVar5 = this.ejU.eiS;
                        if (eyVar5.aKs()) {
                            if (view.getId() != w.h.pb_head_user_info_root) {
                                eyVar6 = this.ejU.eiS;
                            }
                            if (view.getTag(w.h.tag_user_id) instanceof String) {
                                TiebaStatic.log(new com.baidu.tbadk.core.util.as("c10630").aa("obj_id", (String) view.getTag(w.h.tag_user_id)));
                            }
                            if (this.ejU.eiT != null && this.ejU.eiT.erI != null) {
                                this.ejU.eiT.erI.onClick(view);
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
                    this.ejU.e(sparseArray);
                }
            } else {
                aV = this.ejU.aV(view);
                if (aV) {
                    return true;
                }
            }
        }
        cVar = this.ejU.eje;
        if (cVar != null) {
            eyVar3 = this.ejU.eiS;
            cVar3 = this.ejU.eje;
            eyVar3.gB(cVar3.DU());
        }
        eyVar = this.ejU.eiS;
        eyVar.aMT();
        cVar2 = this.ejU.eje;
        cVar2.DX();
        eyVar2 = this.ejU.eiS;
        eyVar2.awH();
        return true;
    }
}
