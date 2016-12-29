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
    final /* synthetic */ PbActivity eah;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(PbActivity pbActivity) {
        this.eah = pbActivity;
    }

    @Override // com.baidu.tieba.pb.a.d.a
    public boolean a(View view, MotionEvent motionEvent) {
        er erVar;
        er erVar2;
        com.baidu.tbadk.editortools.e.e eVar;
        er erVar3;
        er erVar4;
        com.baidu.tbadk.editortools.e.e eVar2;
        com.baidu.tieba.pb.pb.main.a.j jVar;
        com.baidu.tieba.pb.pb.main.a.j jVar2;
        er erVar5;
        er erVar6;
        com.baidu.tbadk.editortools.e.e eVar3;
        erVar = this.eah.dZk;
        if (erVar == null) {
            return false;
        }
        erVar2 = this.eah.dZk;
        erVar2.iE(false);
        eVar = this.eah.dZw;
        if (eVar != null) {
            erVar6 = this.eah.dZk;
            eVar3 = this.eah.dZw;
            erVar6.gH(eVar3.Di());
        }
        erVar3 = this.eah.dZk;
        erVar3.aV(view);
        erVar4 = this.eah.dZk;
        erVar4.iE(true);
        eVar2 = this.eah.dZw;
        eVar2.Dl();
        jVar = this.eah.dYS;
        if (jVar != null) {
            jVar2 = this.eah.dYS;
            erVar5 = this.eah.dZk;
            jVar2.iO(erVar5.isFullScreen());
        }
        return true;
    }

    @Override // com.baidu.tieba.pb.a.d.a
    public boolean b(View view, MotionEvent motionEvent) {
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x00b7, code lost:
        if (r5 == r0.aMy()) goto L27;
     */
    @Override // com.baidu.tieba.pb.a.d.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean c(View view, MotionEvent motionEvent) {
        com.baidu.tbadk.editortools.e.e eVar;
        er erVar;
        com.baidu.tbadk.editortools.e.e eVar2;
        er erVar2;
        er erVar3;
        com.baidu.tbadk.editortools.e.e eVar3;
        er erVar4;
        er erVar5;
        er erVar6;
        boolean aR;
        if (view != null) {
            if (view.getId() != r.g.richText) {
                if (view.getId() == r.g.pb_list_item_layout) {
                    if (view.getTag(r.g.tag_from) instanceof SparseArray) {
                        this.eah.e((SparseArray) view.getTag(r.g.tag_from));
                    }
                } else if (!(view instanceof TbRichTextView) && view.getId() != r.g.pb_post_header_layout) {
                    erVar4 = this.eah.dZk;
                    if (erVar4 != null) {
                        erVar5 = this.eah.dZk;
                        if (erVar5.aJd()) {
                            if (view.getId() != r.g.pb_head_user_info_root) {
                                erVar6 = this.eah.dZk;
                            }
                            if (view.getTag(r.g.tag_user_id) instanceof String) {
                                TiebaStatic.log(new com.baidu.tbadk.core.util.at("c10630").ab("obj_id", (String) view.getTag(r.g.tag_user_id)));
                            }
                            if (this.eah.dZl != null && this.eah.dZl.ehp != null) {
                                this.eah.dZl.ehp.onClick(view);
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
                    this.eah.e(sparseArray);
                }
            } else {
                aR = this.eah.aR(view);
                if (aR) {
                    return true;
                }
            }
        }
        eVar = this.eah.dZw;
        if (eVar != null) {
            erVar3 = this.eah.dZk;
            eVar3 = this.eah.dZw;
            erVar3.gH(eVar3.Di());
        }
        erVar = this.eah.dZk;
        erVar.aLD();
        eVar2 = this.eah.dZw;
        eVar2.Dl();
        erVar2 = this.eah.dZk;
        erVar2.awl();
        return true;
    }
}
