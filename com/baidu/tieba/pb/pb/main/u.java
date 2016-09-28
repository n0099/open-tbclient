package com.baidu.tieba.pb.pb.main;

import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.a.d;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class u implements d.a {
    final /* synthetic */ PbActivity eqa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(PbActivity pbActivity) {
        this.eqa = pbActivity;
    }

    @Override // com.baidu.tieba.pb.a.d.a
    public boolean a(View view, MotionEvent motionEvent) {
        ex exVar;
        ex exVar2;
        ex exVar3;
        com.baidu.tbadk.editortools.e.e eVar;
        ex exVar4;
        ex exVar5;
        com.baidu.tbadk.editortools.e.e eVar2;
        com.baidu.tieba.pb.pb.main.a.f fVar;
        com.baidu.tieba.pb.pb.main.a.f fVar2;
        ex exVar6;
        ex exVar7;
        com.baidu.tbadk.editortools.e.e eVar3;
        exVar = this.eqa.epe;
        if (exVar.aQJ()) {
            return true;
        }
        exVar2 = this.eqa.epe;
        if (exVar2 == null) {
            return false;
        }
        exVar3 = this.eqa.epe;
        exVar3.iu(false);
        eVar = this.eqa.epp;
        if (eVar != null) {
            exVar7 = this.eqa.epe;
            eVar3 = this.eqa.epp;
            exVar7.gD(eVar3.Dr());
        }
        exVar4 = this.eqa.epe;
        exVar4.aX(view);
        exVar5 = this.eqa.epe;
        exVar5.iu(true);
        eVar2 = this.eqa.epp;
        eVar2.Du();
        fVar = this.eqa.eoN;
        if (fVar != null) {
            fVar2 = this.eqa.eoN;
            exVar6 = this.eqa.epe;
            fVar2.iF(exVar6.isFullScreen());
            return true;
        }
        return true;
    }

    @Override // com.baidu.tieba.pb.a.d.a
    public boolean b(View view, MotionEvent motionEvent) {
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x00bf, code lost:
        if (r5 == r0.aQK()) goto L29;
     */
    @Override // com.baidu.tieba.pb.a.d.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean c(View view, MotionEvent motionEvent) {
        com.baidu.tbadk.editortools.e.e eVar;
        ex exVar;
        com.baidu.tbadk.editortools.e.e eVar2;
        ex exVar2;
        ex exVar3;
        com.baidu.tbadk.editortools.e.e eVar3;
        ex exVar4;
        ex exVar5;
        ex exVar6;
        boolean aT;
        if (view != null) {
            if (view.getId() != r.g.richText) {
                if (view.getId() == r.g.pb_list_item_layout) {
                    if (view.getTag(r.g.tag_from) instanceof SparseArray) {
                        this.eqa.e((SparseArray) view.getTag(r.g.tag_from));
                    }
                } else if (!(view instanceof TbRichTextView) && view.getId() != r.g.pb_post_header_layout) {
                    exVar4 = this.eqa.epe;
                    if (exVar4 != null) {
                        exVar5 = this.eqa.epe;
                        if (exVar5.aNm()) {
                            if (view.getId() != r.g.pb_head_owner_root && view.getId() != r.g.pb_head_user_info_root) {
                                exVar6 = this.eqa.epe;
                            }
                            if (view.getTag(r.g.tag_user_id) instanceof String) {
                                TiebaStatic.log(new com.baidu.tbadk.core.util.ax("c10630").ab("obj_id", (String) view.getTag(r.g.tag_user_id)));
                            }
                            if (this.eqa.epf != null && this.eqa.epf.ewW != null) {
                                this.eqa.epf.ewW.onClick(view);
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
                    this.eqa.e(sparseArray);
                }
            } else {
                aT = this.eqa.aT(view);
                if (aT) {
                    return true;
                }
            }
        }
        eVar = this.eqa.epp;
        if (eVar != null) {
            exVar3 = this.eqa.epe;
            eVar3 = this.eqa.epp;
            exVar3.gD(eVar3.Dr());
        }
        exVar = this.eqa.epe;
        exVar.aPG();
        eVar2 = this.eqa.epp;
        eVar2.Du();
        exVar2 = this.eqa.epe;
        exVar2.aBc();
        return true;
    }
}
