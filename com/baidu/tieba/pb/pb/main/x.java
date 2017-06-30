package com.baidu.tieba.pb.pb.main;

import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.a.d;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class x implements d.a {
    final /* synthetic */ PbActivity ewh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(PbActivity pbActivity) {
        this.ewh = pbActivity;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0043, code lost:
        if (com.baidu.tieba.pb.i.N(r0.getPbData().aMv()) == false) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0067, code lost:
        if (r0.getPbData().aMS() != null) goto L19;
     */
    @Override // com.baidu.tieba.pb.a.d.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(View view, MotionEvent motionEvent) {
        gg ggVar;
        PbModel pbModel;
        PbModel pbModel2;
        PbModel pbModel3;
        PbModel pbModel4;
        long j;
        PbModel pbModel5;
        PbModel pbModel6;
        PbModel pbModel7;
        PbModel pbModel8;
        ggVar = this.ewh.euU;
        if (ggVar.aQf()) {
            TiebaStatic.log("c12181");
            if (this.ewh.checkUpIsLogin()) {
                pbModel = this.ewh.eue;
                if (pbModel != null) {
                    pbModel7 = this.ewh.eue;
                    if (pbModel7.getPbData() != null) {
                        pbModel8 = this.ewh.eue;
                    }
                }
                pbModel2 = this.ewh.eue;
                if (pbModel2 != null) {
                    pbModel3 = this.ewh.eue;
                    if (pbModel3.getPbData() == null) {
                        pbModel6 = this.ewh.eue;
                    }
                    pbModel4 = this.ewh.eue;
                    if (!pbModel4.getPbData().aMS().aMY()) {
                        this.ewh.f(this.ewh.findViewById(w.h.view_main_thread_praise_state), 2, false);
                        com.baidu.tbadk.core.util.au r = this.ewh.aNC().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 4);
                        pbModel5 = this.ewh.eue;
                        TiebaStatic.log(r.r("obj_id", pbModel5.getPbData().aMS().aMY() ? 0 : 1));
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    j = this.ewh.euK;
                    if (currentTimeMillis - j > 2000) {
                        new com.baidu.tieba.pb.view.d(this.ewh.getActivity()).startAnimation(false);
                        this.ewh.euK = System.currentTimeMillis();
                    }
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
        if (r5 == r0.aQY()) goto L27;
     */
    @Override // com.baidu.tieba.pb.a.d.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean c(View view, MotionEvent motionEvent) {
        com.baidu.tbadk.editortools.pb.c cVar;
        gg ggVar;
        com.baidu.tbadk.editortools.pb.c cVar2;
        gg ggVar2;
        gg ggVar3;
        com.baidu.tbadk.editortools.pb.c cVar3;
        gg ggVar4;
        gg ggVar5;
        gg ggVar6;
        boolean aU;
        if (view != null) {
            if (view.getId() != w.h.richText) {
                if (view.getId() == w.h.pb_floor_item_layout) {
                    if (view.getTag(w.h.tag_from) instanceof SparseArray) {
                        this.ewh.e((SparseArray) view.getTag(w.h.tag_from));
                    }
                } else if (!(view instanceof TbRichTextView) && view.getId() != w.h.pb_post_header_layout) {
                    ggVar4 = this.ewh.euU;
                    if (ggVar4 != null) {
                        ggVar5 = this.ewh.euU;
                        if (ggVar5.aNA()) {
                            if (view.getId() != w.h.pb_head_user_info_root) {
                                ggVar6 = this.ewh.euU;
                            }
                            if (view.getTag(w.h.tag_user_id) instanceof String) {
                                TiebaStatic.log(new com.baidu.tbadk.core.util.au("c10630").Z("obj_id", (String) view.getTag(w.h.tag_user_id)));
                            }
                            if (this.ewh.euV != null && this.ewh.euV.eFW != null) {
                                this.ewh.euV.eFW.onClick(view);
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
                    this.ewh.e(sparseArray);
                }
            } else {
                aU = this.ewh.aU(view);
                if (aU) {
                    return true;
                }
            }
        }
        cVar = this.ewh.evh;
        if (cVar != null) {
            ggVar3 = this.ewh.euU;
            cVar3 = this.ewh.evh;
            ggVar3.gT(cVar3.Dm());
        }
        ggVar = this.ewh.euU;
        ggVar.aOk();
        cVar2 = this.ewh.evh;
        cVar2.Dp();
        ggVar2 = this.ewh.euU;
        ggVar2.azw();
        return true;
    }
}
