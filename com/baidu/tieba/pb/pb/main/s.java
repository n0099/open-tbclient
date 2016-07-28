package com.baidu.tieba.pb.pb.main;

import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.a.d;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
class s implements d.a {
    final /* synthetic */ PbActivity ebT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(PbActivity pbActivity) {
        this.ebT = pbActivity;
    }

    @Override // com.baidu.tieba.pb.a.d.a
    public boolean a(View view, MotionEvent motionEvent) {
        ew ewVar;
        ew ewVar2;
        ew ewVar3;
        com.baidu.tbadk.editortools.d.e eVar;
        ew ewVar4;
        ew ewVar5;
        com.baidu.tbadk.editortools.d.e eVar2;
        com.baidu.tieba.pb.pb.main.a.f fVar;
        com.baidu.tieba.pb.pb.main.a.f fVar2;
        ew ewVar6;
        ew ewVar7;
        com.baidu.tbadk.editortools.d.e eVar3;
        ewVar = this.ebT.ebb;
        if (ewVar.aLj()) {
            return true;
        }
        ewVar2 = this.ebT.ebb;
        if (ewVar2 == null) {
            return false;
        }
        ewVar3 = this.ebT.ebb;
        ewVar3.hW(false);
        eVar = this.ebT.ebk;
        if (eVar != null) {
            ewVar7 = this.ebT.ebb;
            eVar3 = this.ebT.ebk;
            ewVar7.ge(eVar3.BW());
        }
        ewVar4 = this.ebT.ebb;
        ewVar4.aY(view);
        ewVar5 = this.ebT.ebb;
        ewVar5.hW(true);
        eVar2 = this.ebT.ebk;
        eVar2.BZ();
        fVar = this.ebT.eaK;
        if (fVar != null) {
            fVar2 = this.ebT.eaK;
            ewVar6 = this.ebT.ebb;
            fVar2.ih(ewVar6.isFullScreen());
            return true;
        }
        return true;
    }

    @Override // com.baidu.tieba.pb.a.d.a
    public boolean b(View view, MotionEvent motionEvent) {
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x00bf, code lost:
        if (r5 == r0.aLk()) goto L29;
     */
    @Override // com.baidu.tieba.pb.a.d.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean c(View view, MotionEvent motionEvent) {
        com.baidu.tbadk.editortools.d.e eVar;
        ew ewVar;
        com.baidu.tbadk.editortools.d.e eVar2;
        ew ewVar2;
        ew ewVar3;
        com.baidu.tbadk.editortools.d.e eVar3;
        ew ewVar4;
        ew ewVar5;
        ew ewVar6;
        boolean aV;
        if (view != null) {
            if (view.getId() != u.g.richText) {
                if (view.getId() == u.g.pb_list_item_layout) {
                    if (view.getTag(u.g.tag_from) instanceof SparseArray) {
                        this.ebT.e((SparseArray) view.getTag(u.g.tag_from));
                    }
                } else if (!(view instanceof TbRichTextView) && view.getId() != u.g.pb_post_header_layout) {
                    ewVar4 = this.ebT.ebb;
                    if (ewVar4 != null) {
                        ewVar5 = this.ebT.ebb;
                        if (ewVar5.aHP()) {
                            if (view.getId() != u.g.pb_head_owner_root && view.getId() != u.g.pb_head_user_info_root) {
                                ewVar6 = this.ebT.ebb;
                            }
                            if (view.getTag(u.g.tag_user_id) instanceof String) {
                                TiebaStatic.log(new com.baidu.tbadk.core.util.ay("c10630").ab("obj_id", (String) view.getTag(u.g.tag_user_id)));
                            }
                            if (this.ebT.ebc != null && this.ebT.ebc.eiJ != null) {
                                this.ebT.ebc.eiJ.onClick(view);
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
                    this.ebT.e(sparseArray);
                }
            } else {
                aV = this.ebT.aV(view);
                if (aV) {
                    return true;
                }
            }
        }
        eVar = this.ebT.ebk;
        if (eVar != null) {
            ewVar3 = this.ebT.ebb;
            eVar3 = this.ebT.ebk;
            ewVar3.ge(eVar3.BW());
        }
        ewVar = this.ebT.ebb;
        ewVar.aKg();
        eVar2 = this.ebT.ebk;
        eVar2.BZ();
        ewVar2 = this.ebT.ebb;
        ewVar2.avR();
        return true;
    }
}
