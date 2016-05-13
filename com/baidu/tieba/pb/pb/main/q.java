package com.baidu.tieba.pb.pb.main;

import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.a.d;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class q implements d.a {
    final /* synthetic */ PbActivity djE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(PbActivity pbActivity) {
        this.djE = pbActivity;
    }

    @Override // com.baidu.tieba.pb.a.d.a
    public boolean a(View view, MotionEvent motionEvent) {
        el elVar;
        el elVar2;
        com.baidu.tbadk.editortools.d.e eVar;
        el elVar3;
        el elVar4;
        com.baidu.tbadk.editortools.d.e eVar2;
        com.baidu.tieba.pb.pb.main.a.f fVar;
        com.baidu.tieba.pb.pb.main.a.f fVar2;
        el elVar5;
        el elVar6;
        com.baidu.tbadk.editortools.d.e eVar3;
        elVar = this.djE.diR;
        if (elVar == null) {
            return false;
        }
        elVar2 = this.djE.diR;
        elVar2.gR(false);
        eVar = this.djE.dja;
        if (eVar != null) {
            elVar6 = this.djE.diR;
            eVar3 = this.djE.dja;
            elVar6.fn(eVar3.BN());
        }
        elVar3 = this.djE.diR;
        elVar3.aQ(view);
        elVar4 = this.djE.diR;
        elVar4.gR(true);
        eVar2 = this.djE.dja;
        eVar2.BQ();
        fVar = this.djE.diy;
        if (fVar != null) {
            fVar2 = this.djE.diy;
            elVar5 = this.djE.diR;
            fVar2.hc(elVar5.isFullScreen());
        }
        return true;
    }

    @Override // com.baidu.tieba.pb.a.d.a
    public boolean b(View view, MotionEvent motionEvent) {
        return false;
    }

    @Override // com.baidu.tieba.pb.a.d.a
    public boolean c(View view, MotionEvent motionEvent) {
        com.baidu.tbadk.editortools.d.e eVar;
        el elVar;
        com.baidu.tbadk.editortools.d.e eVar2;
        el elVar2;
        el elVar3;
        com.baidu.tbadk.editortools.d.e eVar3;
        SparseArray sparseArray;
        boolean aN;
        if (view != null) {
            if (view.getId() != t.g.richText) {
                if (view.getId() == t.g.pb_list_item_layout) {
                    if (view.getTag(t.g.tag_from) instanceof SparseArray) {
                        this.djE.e((SparseArray) view.getTag(t.g.tag_from));
                    }
                } else if ((view instanceof TbRichTextView) || view.getId() == t.g.pb_post_header_layout) {
                    try {
                        sparseArray = (SparseArray) view.getTag();
                    } catch (ClassCastException e) {
                        e.printStackTrace();
                        sparseArray = null;
                    }
                    if (sparseArray == null) {
                        return false;
                    }
                    this.djE.e(sparseArray);
                }
            } else {
                aN = this.djE.aN(view);
                if (aN) {
                    return true;
                }
            }
        }
        eVar = this.djE.dja;
        if (eVar != null) {
            elVar3 = this.djE.diR;
            eVar3 = this.djE.dja;
            elVar3.fn(eVar3.BN());
        }
        elVar = this.djE.diR;
        elVar.ayK();
        eVar2 = this.djE.dja;
        eVar2.BQ();
        elVar2 = this.djE.diR;
        elVar2.amT();
        return true;
    }
}
