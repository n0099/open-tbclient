package com.baidu.tieba.pb.pb.sub;

import android.util.SparseArray;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements View.OnClickListener {
    final /* synthetic */ NewSubPbActivity esV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(NewSubPbActivity newSubPbActivity) {
        this.esV = newSubPbActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v10, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ao aoVar;
        ao aoVar2;
        ao aoVar3;
        ao aoVar4;
        boolean z;
        SubPbModel subPbModel;
        SubPbModel subPbModel2;
        ao aoVar5;
        ao aoVar6;
        ao aoVar7;
        ao aoVar8;
        ao aoVar9;
        ao aoVar10;
        ao aoVar11;
        ao aoVar12;
        com.baidu.tbadk.editortools.pb.n nVar;
        com.baidu.tbadk.editortools.pb.n nVar2;
        com.baidu.tbadk.editortools.pb.n nVar3;
        ao aoVar13;
        ao aoVar14;
        ao aoVar15;
        SubPbModel subPbModel3;
        ao aoVar16;
        ao aoVar17;
        ao aoVar18;
        ao aoVar19;
        ao aoVar20;
        ao aoVar21;
        ao aoVar22;
        com.baidu.tbadk.editortools.pb.n nVar4;
        b bVar;
        b bVar2;
        ao aoVar23;
        ao aoVar24;
        SubPbModel subPbModel4;
        SubPbModel subPbModel5;
        ao aoVar25;
        SubPbModel subPbModel6;
        ao aoVar26;
        ao aoVar27;
        ao aoVar28;
        com.baidu.tbadk.editortools.pb.n nVar5;
        com.baidu.tbadk.editortools.pb.n nVar6;
        b bVar3;
        b bVar4;
        ao aoVar29;
        ao aoVar30;
        if (view == null) {
            aoVar30 = this.esV.esG;
            if (aoVar30 == null) {
                return;
            }
        }
        aoVar = this.esV.esG;
        if (view == aoVar.aOK()) {
            aoVar29 = this.esV.esG;
            aoVar29.awH();
            String str = view.getTag(w.h.tag_user_id) instanceof String ? (String) view.getTag(w.h.tag_user_id) : null;
            String str2 = view.getTag(w.h.tag_user_name) instanceof String ? (String) view.getTag(w.h.tag_user_name) : null;
            String str3 = view.getTag(w.h.tag_virtual_user_url) instanceof String ? (String) view.getTag(w.h.tag_virtual_user_url) : null;
            if (str3 != null) {
                if (this.esV.checkUpIsLogin()) {
                    com.baidu.tbadk.core.util.bb.wn().c(this.esV.getPageContext(), new String[]{str3});
                    return;
                }
                return;
            } else if (str != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.esV.getPageContext().getPageActivity(), str, str2, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
                return;
            } else {
                return;
            }
        }
        aoVar2 = this.esV.esG;
        if (view == aoVar2.aOD()) {
            aoVar27 = this.esV.esG;
            aoVar27.aOu();
            aoVar28 = this.esV.esG;
            aoVar28.aOv();
            nVar5 = this.esV.dlk;
            if (nVar5 != null) {
                nVar6 = this.esV.dlk;
                nVar6.En();
                bVar3 = this.esV.esS;
                if (bVar3 != null) {
                    bVar4 = this.esV.esS;
                    bVar4.aOh();
                    return;
                }
                return;
            }
            return;
        }
        aoVar3 = this.esV.esG;
        if (view == aoVar3.aOz()) {
            aoVar25 = this.esV.esG;
            aoVar25.awH();
            subPbModel6 = this.esV.esE;
            if (subPbModel6.FC()) {
                aoVar26 = this.esV.esG;
                aoVar26.aOx();
                return;
            }
            return;
        }
        aoVar4 = this.esV.esG;
        if (view != aoVar4.aOE()) {
            aoVar5 = this.esV.esG;
            if (view != aoVar5.aOF()) {
                aoVar6 = this.esV.esG;
                if (view != aoVar6.aOH()) {
                    aoVar7 = this.esV.esG;
                    if (aoVar7.aOI() != null) {
                        aoVar23 = this.esV.esG;
                        if (view == aoVar23.aOI().aMf()) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11739").s("obj_locate", 2));
                            aoVar24 = this.esV.esG;
                            aoVar24.awH();
                            if (this.esV.checkUpIsLogin()) {
                                subPbModel4 = this.esV.esE;
                                if (subPbModel4.aON() != null) {
                                    NewSubPbActivity newSubPbActivity = this.esV;
                                    subPbModel5 = this.esV.esE;
                                    newSubPbActivity.d(subPbModel5.aON().aJV());
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                    }
                    aoVar8 = this.esV.esG;
                    if (aoVar8.aOI() != null) {
                        aoVar21 = this.esV.esG;
                        if (view == aoVar21.aOI().aMk()) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11739").s("obj_locate", 1));
                            aoVar22 = this.esV.esG;
                            aoVar22.awH();
                            if (this.esV.checkUpIsLogin()) {
                                nVar4 = this.esV.dlk;
                                nVar4.fE(null);
                                bVar = this.esV.esS;
                                if (bVar != null) {
                                    bVar2 = this.esV.esS;
                                    bVar2.aOh();
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                    }
                    aoVar9 = this.esV.esG;
                    if (aoVar9.aOI() != null) {
                        aoVar18 = this.esV.esG;
                        if (view == aoVar18.aOI().aMi()) {
                            aoVar19 = this.esV.esG;
                            aoVar19.awH();
                            SparseArray sparseArray = (SparseArray) view.getTag();
                            if (sparseArray != null) {
                                aoVar20 = this.esV.esG;
                                aoVar20.a(((Integer) sparseArray.get(w.h.tag_del_post_type)).intValue(), (String) sparseArray.get(w.h.tag_del_post_id), ((Integer) sparseArray.get(w.h.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(w.h.tag_del_post_is_self)).booleanValue());
                                return;
                            }
                            return;
                        }
                    }
                    aoVar10 = this.esV.esG;
                    if (aoVar10.aOI() != null) {
                        aoVar16 = this.esV.esG;
                        if (view == aoVar16.aOI().aMg()) {
                            if (com.baidu.adp.lib.util.i.hj()) {
                                aoVar17 = this.esV.esG;
                                aoVar17.awH();
                                if (!this.esV.checkUpIsLogin()) {
                                    return;
                                }
                                this.esV.bc(view);
                                return;
                            }
                            this.esV.showToast(w.l.network_not_available);
                            return;
                        }
                    }
                    aoVar11 = this.esV.esG;
                    if (aoVar11.aOI() != null) {
                        aoVar14 = this.esV.esG;
                        if (view == aoVar14.aOI().aMh()) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11739").s("obj_locate", 4));
                            if (!com.baidu.adp.lib.util.i.hj()) {
                                this.esV.showToast(w.l.network_not_available);
                                return;
                            }
                            Object tag = view.getTag();
                            aoVar15 = this.esV.esG;
                            aoVar15.awH();
                            if (tag instanceof String) {
                                subPbModel3 = this.esV.esE;
                                String DJ = subPbModel3.DJ();
                                if (this.esV.checkUpIsLogin()) {
                                    this.esV.nv(DJ);
                                    return;
                                }
                                return;
                            } else if (tag instanceof SparseArray) {
                                SparseArray<Object> sparseArray2 = (SparseArray) tag;
                                if ((sparseArray2.get(w.h.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray2.get(w.h.tag_user_mute_visible)).booleanValue()) {
                                    sparseArray2.put(w.h.tag_from, 0);
                                    this.esV.d(sparseArray2);
                                    return;
                                }
                                return;
                            } else {
                                return;
                            }
                        }
                    }
                    aoVar12 = this.esV.esG;
                    if (view != aoVar12.aOC()) {
                        aoVar13 = this.esV.esG;
                        if (view != aoVar13.aOH()) {
                            return;
                        }
                    }
                    if (this.esV.checkUpIsLogin()) {
                        nVar = this.esV.dlk;
                        if (nVar.El()) {
                            nVar3 = this.esV.dlk;
                            nVar3.Em();
                            return;
                        }
                        nVar2 = this.esV.dlk;
                        nVar2.fE(null);
                        return;
                    }
                    return;
                }
            }
        }
        z = this.esV.esR;
        if (z) {
            this.esV.esR = false;
            return;
        }
        MessageManager messageManager = MessageManager.getInstance();
        PbActivityConfig pbActivityConfig = new PbActivityConfig(this.esV.getActivity());
        subPbModel = this.esV.esE;
        String threadID = subPbModel.getThreadID();
        subPbModel2 = this.esV.esE;
        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig.createNormalCfg(threadID, subPbModel2.DJ(), "")));
    }
}
