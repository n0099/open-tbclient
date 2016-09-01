package com.baidu.tieba.pb.pb.main;

import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.a.d;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class u implements d.a {
    final /* synthetic */ PbActivity eob;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(PbActivity pbActivity) {
        this.eob = pbActivity;
    }

    @Override // com.baidu.tieba.pb.a.d.a
    public boolean a(View view, MotionEvent motionEvent) {
        ex exVar;
        ex exVar2;
        ex exVar3;
        com.baidu.tbadk.editortools.d.e eVar;
        ex exVar4;
        ex exVar5;
        com.baidu.tbadk.editortools.d.e eVar2;
        com.baidu.tieba.pb.pb.main.a.f fVar;
        com.baidu.tieba.pb.pb.main.a.f fVar2;
        ex exVar6;
        ex exVar7;
        com.baidu.tbadk.editortools.d.e eVar3;
        exVar = this.eob.enh;
        if (exVar.aQa()) {
            return true;
        }
        exVar2 = this.eob.enh;
        if (exVar2 == null) {
            return false;
        }
        exVar3 = this.eob.enh;
        exVar3.ir(false);
        eVar = this.eob.ens;
        if (eVar != null) {
            exVar7 = this.eob.enh;
            eVar3 = this.eob.ens;
            exVar7.gA(eVar3.Dr());
        }
        exVar4 = this.eob.enh;
        exVar4.aY(view);
        exVar5 = this.eob.enh;
        exVar5.ir(true);
        eVar2 = this.eob.ens;
        eVar2.Du();
        fVar = this.eob.emP;
        if (fVar != null) {
            fVar2 = this.eob.emP;
            exVar6 = this.eob.enh;
            fVar2.iC(exVar6.isFullScreen());
            return true;
        }
        return true;
    }

    @Override // com.baidu.tieba.pb.a.d.a
    public boolean b(View view, MotionEvent motionEvent) {
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x00bf, code lost:
        if (r5 == r0.aQb()) goto L29;
     */
    @Override // com.baidu.tieba.pb.a.d.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean c(View view, MotionEvent motionEvent) {
        com.baidu.tbadk.editortools.d.e eVar;
        ex exVar;
        com.baidu.tbadk.editortools.d.e eVar2;
        ex exVar2;
        ex exVar3;
        com.baidu.tbadk.editortools.d.e eVar3;
        ex exVar4;
        ex exVar5;
        ex exVar6;
        boolean aV;
        if (view != null) {
            if (view.getId() != t.g.richText) {
                if (view.getId() == t.g.pb_list_item_layout) {
                    if (view.getTag(t.g.tag_from) instanceof SparseArray) {
                        this.eob.e((SparseArray) view.getTag(t.g.tag_from));
                    }
                } else if (!(view instanceof TbRichTextView) && view.getId() != t.g.pb_post_header_layout) {
                    exVar4 = this.eob.enh;
                    if (exVar4 != null) {
                        exVar5 = this.eob.enh;
                        if (exVar5.aMH()) {
                            if (view.getId() != t.g.pb_head_owner_root && view.getId() != t.g.pb_head_user_info_root) {
                                exVar6 = this.eob.enh;
                            }
                            if (view.getTag(t.g.tag_user_id) instanceof String) {
                                TiebaStatic.log(new com.baidu.tbadk.core.util.ay("c10630").ab("obj_id", (String) view.getTag(t.g.tag_user_id)));
                            }
                            if (this.eob.eni != null && this.eob.eni.euQ != null) {
                                this.eob.eni.euQ.onClick(view);
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
                    this.eob.e(sparseArray);
                }
            } else {
                aV = this.eob.aV(view);
                if (aV) {
                    return true;
                }
            }
        }
        eVar = this.eob.ens;
        if (eVar != null) {
            exVar3 = this.eob.enh;
            eVar3 = this.eob.ens;
            exVar3.gA(eVar3.Dr());
        }
        exVar = this.eob.enh;
        exVar.aOX();
        eVar2 = this.eob.ens;
        eVar2.Du();
        exVar2 = this.eob.enh;
        exVar2.aAE();
        return true;
    }
}
