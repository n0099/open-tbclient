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
    final /* synthetic */ PbActivity evL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(PbActivity pbActivity) {
        this.evL = pbActivity;
    }

    @Override // com.baidu.tieba.pb.a.d.a
    public boolean a(View view, MotionEvent motionEvent) {
        ey eyVar;
        ey eyVar2;
        ey eyVar3;
        com.baidu.tbadk.editortools.e.e eVar;
        ey eyVar4;
        ey eyVar5;
        com.baidu.tbadk.editortools.e.e eVar2;
        com.baidu.tieba.pb.pb.main.a.j jVar;
        com.baidu.tieba.pb.pb.main.a.j jVar2;
        ey eyVar6;
        ey eyVar7;
        com.baidu.tbadk.editortools.e.e eVar3;
        eyVar = this.evL.euP;
        if (eyVar.aSF()) {
            return true;
        }
        eyVar2 = this.evL.euP;
        if (eyVar2 == null) {
            return false;
        }
        eyVar3 = this.evL.euP;
        eyVar3.iS(false);
        eVar = this.evL.evb;
        if (eVar != null) {
            eyVar7 = this.evL.euP;
            eVar3 = this.evL.evb;
            eyVar7.gX(eVar3.Dz());
        }
        eyVar4 = this.evL.euP;
        eyVar4.aW(view);
        eyVar5 = this.evL.euP;
        eyVar5.iS(true);
        eVar2 = this.evL.evb;
        eVar2.DC();
        jVar = this.evL.eux;
        if (jVar != null) {
            jVar2 = this.evL.eux;
            eyVar6 = this.evL.euP;
            jVar2.jc(eyVar6.isFullScreen());
            return true;
        }
        return true;
    }

    @Override // com.baidu.tieba.pb.a.d.a
    public boolean b(View view, MotionEvent motionEvent) {
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x00b7, code lost:
        if (r5 == r0.aSG()) goto L27;
     */
    @Override // com.baidu.tieba.pb.a.d.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean c(View view, MotionEvent motionEvent) {
        com.baidu.tbadk.editortools.e.e eVar;
        ey eyVar;
        com.baidu.tbadk.editortools.e.e eVar2;
        ey eyVar2;
        ey eyVar3;
        com.baidu.tbadk.editortools.e.e eVar3;
        ey eyVar4;
        ey eyVar5;
        ey eyVar6;
        boolean aS;
        if (view != null) {
            if (view.getId() != r.g.richText) {
                if (view.getId() == r.g.pb_list_item_layout) {
                    if (view.getTag(r.g.tag_from) instanceof SparseArray) {
                        this.evL.e((SparseArray) view.getTag(r.g.tag_from));
                    }
                } else if (!(view instanceof TbRichTextView) && view.getId() != r.g.pb_post_header_layout) {
                    eyVar4 = this.evL.euP;
                    if (eyVar4 != null) {
                        eyVar5 = this.evL.euP;
                        if (eyVar5.aPe()) {
                            if (view.getId() != r.g.pb_head_user_info_root) {
                                eyVar6 = this.evL.euP;
                            }
                            if (view.getTag(r.g.tag_user_id) instanceof String) {
                                TiebaStatic.log(new com.baidu.tbadk.core.util.av("c10630").ab("obj_id", (String) view.getTag(r.g.tag_user_id)));
                            }
                            if (this.evL.euQ != null && this.evL.euQ.eDj != null) {
                                this.evL.euQ.eDj.onClick(view);
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
                    this.evL.e(sparseArray);
                }
            } else {
                aS = this.evL.aS(view);
                if (aS) {
                    return true;
                }
            }
        }
        eVar = this.evL.evb;
        if (eVar != null) {
            eyVar3 = this.evL.euP;
            eVar3 = this.evL.evb;
            eyVar3.gX(eVar3.Dz());
        }
        eyVar = this.evL.euP;
        eyVar.aRJ();
        eVar2 = this.evL.evb;
        eVar2.DC();
        eyVar2 = this.evL.euP;
        eyVar2.aCY();
        return true;
    }
}
