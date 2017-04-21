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
    final /* synthetic */ PbActivity emk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(PbActivity pbActivity) {
        this.emk = pbActivity;
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
        eyVar = this.emk.eli;
        if (eyVar.aOT()) {
            return true;
        }
        eyVar2 = this.emk.eli;
        if (eyVar2 == null) {
            return false;
        }
        eyVar3 = this.emk.eli;
        eyVar3.iS(false);
        cVar = this.emk.elu;
        if (cVar != null) {
            eyVar7 = this.emk.eli;
            cVar3 = this.emk.elu;
            eyVar7.gL(cVar3.DU());
        }
        eyVar4 = this.emk.eli;
        eyVar4.aZ(view);
        eyVar5 = this.emk.eli;
        eyVar5.iS(true);
        cVar2 = this.emk.elu;
        cVar2.DX();
        fVar = this.emk.ekO;
        if (fVar != null) {
            fVar2 = this.emk.ekO;
            eyVar6 = this.emk.eli;
            fVar2.jd(eyVar6.isFullScreen());
            return true;
        }
        return true;
    }

    @Override // com.baidu.tieba.pb.a.d.a
    public boolean b(View view, MotionEvent motionEvent) {
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x00b7, code lost:
        if (r5 == r0.aOS()) goto L27;
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
                        this.emk.e((SparseArray) view.getTag(w.h.tag_from));
                    }
                } else if (!(view instanceof TbRichTextView) && view.getId() != w.h.pb_post_header_layout) {
                    eyVar4 = this.emk.eli;
                    if (eyVar4 != null) {
                        eyVar5 = this.emk.eli;
                        if (eyVar5.aLt()) {
                            if (view.getId() != w.h.pb_head_user_info_root) {
                                eyVar6 = this.emk.eli;
                            }
                            if (view.getTag(w.h.tag_user_id) instanceof String) {
                                TiebaStatic.log(new com.baidu.tbadk.core.util.as("c10630").aa("obj_id", (String) view.getTag(w.h.tag_user_id)));
                            }
                            if (this.emk.elj != null && this.emk.elj.eua != null) {
                                this.emk.elj.eua.onClick(view);
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
                    this.emk.e(sparseArray);
                }
            } else {
                aV = this.emk.aV(view);
                if (aV) {
                    return true;
                }
            }
        }
        cVar = this.emk.elu;
        if (cVar != null) {
            eyVar3 = this.emk.eli;
            cVar3 = this.emk.elu;
            eyVar3.gL(cVar3.DU());
        }
        eyVar = this.emk.eli;
        eyVar.aNU();
        cVar2 = this.emk.elu;
        cVar2.DX();
        eyVar2 = this.emk.eli;
        eyVar2.axI();
        return true;
    }
}
