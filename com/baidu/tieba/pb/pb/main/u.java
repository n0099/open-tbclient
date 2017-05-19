package com.baidu.tieba.pb.pb.main;

import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.a.d;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class u implements d.a {
    final /* synthetic */ PbActivity ehy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(PbActivity pbActivity) {
        this.ehy = pbActivity;
    }

    @Override // com.baidu.tieba.pb.a.d.a
    public boolean a(View view, MotionEvent motionEvent) {
        fm fmVar;
        fm fmVar2;
        fm fmVar3;
        com.baidu.tbadk.editortools.pb.c cVar;
        fm fmVar4;
        fm fmVar5;
        com.baidu.tbadk.editortools.pb.c cVar2;
        com.baidu.tieba.pb.pb.main.a.f fVar;
        com.baidu.tieba.pb.pb.main.a.f fVar2;
        fm fmVar6;
        fm fmVar7;
        com.baidu.tbadk.editortools.pb.c cVar3;
        fmVar = this.ehy.egt;
        if (fmVar.aMh()) {
            return true;
        }
        fmVar2 = this.ehy.egt;
        if (fmVar2 == null) {
            return false;
        }
        fmVar3 = this.ehy.egt;
        fmVar3.ix(false);
        cVar = this.ehy.egG;
        if (cVar != null) {
            fmVar7 = this.ehy.egt;
            cVar3 = this.ehy.egG;
            fmVar7.gm(cVar3.CY());
        }
        fmVar4 = this.ehy.egt;
        fmVar4.aV(view);
        fmVar5 = this.ehy.egt;
        fmVar5.ix(true);
        cVar2 = this.ehy.egG;
        cVar2.Db();
        fVar = this.ehy.efX;
        if (fVar != null) {
            fVar2 = this.ehy.efX;
            fmVar6 = this.ehy.egt;
            fVar2.iI(fmVar6.isFullScreen());
            return true;
        }
        return true;
    }

    @Override // com.baidu.tieba.pb.a.d.a
    public boolean b(View view, MotionEvent motionEvent) {
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x00b7, code lost:
        if (r5 == r0.aMg()) goto L27;
     */
    @Override // com.baidu.tieba.pb.a.d.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean c(View view, MotionEvent motionEvent) {
        com.baidu.tbadk.editortools.pb.c cVar;
        fm fmVar;
        com.baidu.tbadk.editortools.pb.c cVar2;
        fm fmVar2;
        fm fmVar3;
        com.baidu.tbadk.editortools.pb.c cVar3;
        fm fmVar4;
        fm fmVar5;
        fm fmVar6;
        boolean aR;
        if (view != null) {
            if (view.getId() != w.h.richText) {
                if (view.getId() == w.h.pb_floor_item_layout) {
                    if (view.getTag(w.h.tag_from) instanceof SparseArray) {
                        this.ehy.e((SparseArray) view.getTag(w.h.tag_from));
                    }
                } else if (!(view instanceof TbRichTextView) && view.getId() != w.h.pb_post_header_layout) {
                    fmVar4 = this.ehy.egt;
                    if (fmVar4 != null) {
                        fmVar5 = this.ehy.egt;
                        if (fmVar5.aIO()) {
                            if (view.getId() != w.h.pb_head_user_info_root) {
                                fmVar6 = this.ehy.egt;
                            }
                            if (view.getTag(w.h.tag_user_id) instanceof String) {
                                TiebaStatic.log(new com.baidu.tbadk.core.util.as("c10630").aa("obj_id", (String) view.getTag(w.h.tag_user_id)));
                            }
                            if (this.ehy.egu != null && this.ehy.egu.epB != null) {
                                this.ehy.egu.epB.onClick(view);
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
                    this.ehy.e(sparseArray);
                }
            } else {
                aR = this.ehy.aR(view);
                if (aR) {
                    return true;
                }
            }
        }
        cVar = this.ehy.egG;
        if (cVar != null) {
            fmVar3 = this.ehy.egt;
            cVar3 = this.ehy.egG;
            fmVar3.gm(cVar3.CY());
        }
        fmVar = this.ehy.egt;
        fmVar.aLl();
        cVar2 = this.ehy.egG;
        cVar2.Db();
        fmVar2 = this.ehy.egt;
        fmVar2.auE();
        return true;
    }
}
