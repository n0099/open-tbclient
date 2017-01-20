package com.baidu.tieba.pb.pb.main;

import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.a.d;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class s implements d.a {
    final /* synthetic */ PbActivity eiV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(PbActivity pbActivity) {
        this.eiV = pbActivity;
    }

    @Override // com.baidu.tieba.pb.a.d.a
    public boolean a(View view, MotionEvent motionEvent) {
        ez ezVar;
        ez ezVar2;
        ez ezVar3;
        com.baidu.tbadk.editortools.pb.c cVar;
        ez ezVar4;
        ez ezVar5;
        com.baidu.tbadk.editortools.pb.c cVar2;
        com.baidu.tieba.pb.pb.main.a.f fVar;
        com.baidu.tieba.pb.pb.main.a.f fVar2;
        ez ezVar6;
        ez ezVar7;
        com.baidu.tbadk.editortools.pb.c cVar3;
        ezVar = this.eiV.ehV;
        if (ezVar.aOq()) {
            return true;
        }
        ezVar2 = this.eiV.ehV;
        if (ezVar2 == null) {
            return false;
        }
        ezVar3 = this.eiV.ehV;
        ezVar3.iO(false);
        cVar = this.eiV.eih;
        if (cVar != null) {
            ezVar7 = this.eiV.ehV;
            cVar3 = this.eiV.eih;
            ezVar7.gK(cVar3.Dd());
        }
        ezVar4 = this.eiV.ehV;
        ezVar4.bc(view);
        ezVar5 = this.eiV.ehV;
        ezVar5.iO(true);
        cVar2 = this.eiV.eih;
        cVar2.Dg();
        fVar = this.eiV.ehA;
        if (fVar != null) {
            fVar2 = this.eiV.ehA;
            ezVar6 = this.eiV.ehV;
            fVar2.ja(ezVar6.isFullScreen());
            return true;
        }
        return true;
    }

    @Override // com.baidu.tieba.pb.a.d.a
    public boolean b(View view, MotionEvent motionEvent) {
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x00b7, code lost:
        if (r5 == r0.aOo()) goto L27;
     */
    @Override // com.baidu.tieba.pb.a.d.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean c(View view, MotionEvent motionEvent) {
        com.baidu.tbadk.editortools.pb.c cVar;
        ez ezVar;
        com.baidu.tbadk.editortools.pb.c cVar2;
        ez ezVar2;
        ez ezVar3;
        com.baidu.tbadk.editortools.pb.c cVar3;
        ez ezVar4;
        ez ezVar5;
        ez ezVar6;
        boolean aY;
        if (view != null) {
            if (view.getId() != r.h.richText) {
                if (view.getId() == r.h.pb_list_item_layout) {
                    if (view.getTag(r.h.tag_from) instanceof SparseArray) {
                        this.eiV.e((SparseArray) view.getTag(r.h.tag_from));
                    }
                } else if (!(view instanceof TbRichTextView) && view.getId() != r.h.pb_post_header_layout) {
                    ezVar4 = this.eiV.ehV;
                    if (ezVar4 != null) {
                        ezVar5 = this.eiV.ehV;
                        if (ezVar5.aKQ()) {
                            if (view.getId() != r.h.pb_head_user_info_root) {
                                ezVar6 = this.eiV.ehV;
                            }
                            if (view.getTag(r.h.tag_user_id) instanceof String) {
                                TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c10630").ab("obj_id", (String) view.getTag(r.h.tag_user_id)));
                            }
                            if (this.eiV.ehW != null && this.eiV.ehW.eqy != null) {
                                this.eiV.ehW.eqy.onClick(view);
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
                    this.eiV.e(sparseArray);
                }
            } else {
                aY = this.eiV.aY(view);
                if (aY) {
                    return true;
                }
            }
        }
        cVar = this.eiV.eih;
        if (cVar != null) {
            ezVar3 = this.eiV.ehV;
            cVar3 = this.eiV.eih;
            ezVar3.gK(cVar3.Dd());
        }
        ezVar = this.eiV.ehV;
        ezVar.aNr();
        cVar2 = this.eiV.eih;
        cVar2.Dg();
        ezVar2 = this.eiV.ehV;
        ezVar2.axs();
        return true;
    }
}
