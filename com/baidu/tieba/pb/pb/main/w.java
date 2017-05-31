package com.baidu.tieba.pb.pb.main;

import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.a.d;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class w implements d.a {
    final /* synthetic */ PbActivity enc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(PbActivity pbActivity) {
        this.enc = pbActivity;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0036, code lost:
        if (com.baidu.tieba.pb.e.M(r0.getPbData().aIB()) == false) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x005a, code lost:
        if (r0.getPbData().aIY() != null) goto L17;
     */
    @Override // com.baidu.tieba.pb.a.d.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(View view, MotionEvent motionEvent) {
        PbModel pbModel;
        PbModel pbModel2;
        PbModel pbModel3;
        PbModel pbModel4;
        long j;
        PbModel pbModel5;
        PbModel pbModel6;
        PbModel pbModel7;
        TiebaStatic.log("c12181");
        if (this.enc.checkUpIsLogin()) {
            pbModel = this.enc.ele;
            if (pbModel != null) {
                pbModel6 = this.enc.ele;
                if (pbModel6.getPbData() != null) {
                    pbModel7 = this.enc.ele;
                }
            }
            pbModel2 = this.enc.ele;
            if (pbModel2 != null) {
                pbModel3 = this.enc.ele;
                if (pbModel3.getPbData() == null) {
                    pbModel5 = this.enc.ele;
                }
                pbModel4 = this.enc.ele;
                if (!pbModel4.getPbData().aIY().aJe()) {
                    this.enc.f(this.enc.findViewById(w.h.view_main_thread_praise_state), 2, false);
                }
                long currentTimeMillis = System.currentTimeMillis();
                j = this.enc.elK;
                if (currentTimeMillis - j > 2000) {
                    new com.baidu.tieba.pb.view.d(this.enc.getActivity()).startAnimation(false);
                    this.enc.elK = System.currentTimeMillis();
                }
            }
        }
        return true;
    }

    @Override // com.baidu.tieba.pb.a.d.a
    public boolean b(View view, MotionEvent motionEvent) {
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x00b7, code lost:
        if (r5 == r0.aNa()) goto L27;
     */
    @Override // com.baidu.tieba.pb.a.d.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean c(View view, MotionEvent motionEvent) {
        com.baidu.tbadk.editortools.pb.c cVar;
        fx fxVar;
        com.baidu.tbadk.editortools.pb.c cVar2;
        fx fxVar2;
        fx fxVar3;
        com.baidu.tbadk.editortools.pb.c cVar3;
        fx fxVar4;
        fx fxVar5;
        fx fxVar6;
        boolean aS;
        if (view != null) {
            if (view.getId() != w.h.richText) {
                if (view.getId() == w.h.pb_floor_item_layout) {
                    if (view.getTag(w.h.tag_from) instanceof SparseArray) {
                        this.enc.e((SparseArray) view.getTag(w.h.tag_from));
                    }
                } else if (!(view instanceof TbRichTextView) && view.getId() != w.h.pb_post_header_layout) {
                    fxVar4 = this.enc.elU;
                    if (fxVar4 != null) {
                        fxVar5 = this.enc.elU;
                        if (fxVar5.aJG()) {
                            if (view.getId() != w.h.pb_head_user_info_root) {
                                fxVar6 = this.enc.elU;
                            }
                            if (view.getTag(w.h.tag_user_id) instanceof String) {
                                TiebaStatic.log(new com.baidu.tbadk.core.util.as("c10630").Z("obj_id", (String) view.getTag(w.h.tag_user_id)));
                            }
                            if (this.enc.elV != null && this.enc.elV.ewA != null) {
                                this.enc.elV.ewA.onClick(view);
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
                    this.enc.e(sparseArray);
                }
            } else {
                aS = this.enc.aS(view);
                if (aS) {
                    return true;
                }
            }
        }
        cVar = this.enc.emh;
        if (cVar != null) {
            fxVar3 = this.enc.elU;
            cVar3 = this.enc.emh;
            fxVar3.gz(cVar3.CS());
        }
        fxVar = this.enc.elU;
        fxVar.aKn();
        cVar2 = this.enc.emh;
        cVar2.CV();
        fxVar2 = this.enc.elU;
        fxVar2.avy();
        return true;
    }
}
