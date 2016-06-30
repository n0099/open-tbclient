package com.baidu.tieba.pb.pb.main;

import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.a.d;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
class s implements d.a {
    final /* synthetic */ PbActivity dPF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(PbActivity pbActivity) {
        this.dPF = pbActivity;
    }

    @Override // com.baidu.tieba.pb.a.d.a
    public boolean a(View view, MotionEvent motionEvent) {
        es esVar;
        es esVar2;
        es esVar3;
        com.baidu.tbadk.editortools.d.e eVar;
        es esVar4;
        es esVar5;
        com.baidu.tbadk.editortools.d.e eVar2;
        com.baidu.tieba.pb.pb.main.a.f fVar;
        com.baidu.tieba.pb.pb.main.a.f fVar2;
        es esVar6;
        es esVar7;
        com.baidu.tbadk.editortools.d.e eVar3;
        esVar = this.dPF.dOO;
        if (esVar.aHZ()) {
            return true;
        }
        esVar2 = this.dPF.dOO;
        if (esVar2 == null) {
            return false;
        }
        esVar3 = this.dPF.dOO;
        esVar3.hK(false);
        eVar = this.dPF.dOX;
        if (eVar != null) {
            esVar7 = this.dPF.dOO;
            eVar3 = this.dPF.dOX;
            esVar7.gb(eVar3.BW());
        }
        esVar4 = this.dPF.dOO;
        esVar4.aY(view);
        esVar5 = this.dPF.dOO;
        esVar5.hK(true);
        eVar2 = this.dPF.dOX;
        eVar2.BZ();
        fVar = this.dPF.dOx;
        if (fVar != null) {
            fVar2 = this.dPF.dOx;
            esVar6 = this.dPF.dOO;
            fVar2.hV(esVar6.isFullScreen());
            return true;
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
        es esVar;
        com.baidu.tbadk.editortools.d.e eVar2;
        es esVar2;
        es esVar3;
        com.baidu.tbadk.editortools.d.e eVar3;
        boolean aV;
        if (view != null) {
            if (view.getId() != u.g.richText) {
                if (view.getId() == u.g.pb_list_item_layout) {
                    if (view.getTag(u.g.tag_from) instanceof SparseArray) {
                        this.dPF.e((SparseArray) view.getTag(u.g.tag_from));
                    }
                } else if ((view instanceof TbRichTextView) || view.getId() == u.g.pb_post_header_layout) {
                    SparseArray sparseArray = null;
                    if (view.getTag() instanceof SparseArray) {
                        sparseArray = (SparseArray) view.getTag();
                    }
                    if (sparseArray == null) {
                        return false;
                    }
                    this.dPF.e(sparseArray);
                }
            } else {
                aV = this.dPF.aV(view);
                if (aV) {
                    return true;
                }
            }
        }
        eVar = this.dPF.dOX;
        if (eVar != null) {
            esVar3 = this.dPF.dOO;
            eVar3 = this.dPF.dOX;
            esVar3.gb(eVar3.BW());
        }
        esVar = this.dPF.dOO;
        esVar.aGT();
        eVar2 = this.dPF.dOX;
        eVar2.BZ();
        esVar2 = this.dPF.dOO;
        esVar2.avf();
        return true;
    }
}
