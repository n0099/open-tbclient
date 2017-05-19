package com.baidu.tieba.pb.pb.sub;

import android.util.SparseArray;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements View.OnClickListener {
    final /* synthetic */ NewSubPbActivity eqU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(NewSubPbActivity newSubPbActivity) {
        this.eqU = newSubPbActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v13, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
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
        SubPbModel subPbModel3;
        SubPbModel subPbModel4;
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
        SubPbModel subPbModel5;
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
        SubPbModel subPbModel6;
        SubPbModel subPbModel7;
        ao aoVar25;
        SubPbModel subPbModel8;
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
            aoVar30 = this.eqU.eqF;
            if (aoVar30 == null) {
                return;
            }
        }
        aoVar = this.eqU.eqF;
        if (view == aoVar.aNb()) {
            aoVar29 = this.eqU.eqF;
            aoVar29.auE();
            String str = view.getTag(w.h.tag_user_id) instanceof String ? (String) view.getTag(w.h.tag_user_id) : null;
            String str2 = view.getTag(w.h.tag_user_name) instanceof String ? (String) view.getTag(w.h.tag_user_name) : null;
            String str3 = view.getTag(w.h.tag_virtual_user_url) instanceof String ? (String) view.getTag(w.h.tag_virtual_user_url) : null;
            if (str3 != null) {
                if (this.eqU.checkUpIsLogin()) {
                    com.baidu.tbadk.core.util.bb.vB().c(this.eqU.getPageContext(), new String[]{str3});
                    return;
                }
                return;
            } else if (str != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.eqU.getPageContext().getPageActivity(), str, str2, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
                return;
            } else {
                return;
            }
        }
        aoVar2 = this.eqU.eqF;
        if (view == aoVar2.aMU()) {
            aoVar27 = this.eqU.eqF;
            aoVar27.aML();
            aoVar28 = this.eqU.eqF;
            aoVar28.aMM();
            nVar5 = this.eqU.dhG;
            if (nVar5 != null) {
                nVar6 = this.eqU.dhG;
                nVar6.Dr();
                bVar3 = this.eqU.eqR;
                if (bVar3 != null) {
                    bVar4 = this.eqU.eqR;
                    bVar4.aMx();
                    return;
                }
                return;
            }
            return;
        }
        aoVar3 = this.eqU.eqF;
        if (view == aoVar3.aMQ()) {
            aoVar25 = this.eqU.eqF;
            aoVar25.auE();
            subPbModel8 = this.eqU.eqD;
            if (subPbModel8.EG()) {
                aoVar26 = this.eqU.eqF;
                aoVar26.aMO();
                return;
            }
            return;
        }
        aoVar4 = this.eqU.eqF;
        if (view != aoVar4.aMV()) {
            aoVar5 = this.eqU.eqF;
            if (view != aoVar5.aMW()) {
                aoVar6 = this.eqU.eqF;
                if (view != aoVar6.aMY()) {
                    aoVar7 = this.eqU.eqF;
                    if (aoVar7.aMZ() != null) {
                        aoVar23 = this.eqU.eqF;
                        if (view == aoVar23.aMZ().aKy()) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11739").s("obj_locate", 2));
                            aoVar24 = this.eqU.eqF;
                            aoVar24.auE();
                            if (this.eqU.checkUpIsLogin()) {
                                subPbModel6 = this.eqU.eqD;
                                if (subPbModel6.aNe() != null) {
                                    NewSubPbActivity newSubPbActivity = this.eqU;
                                    subPbModel7 = this.eqU.eqD;
                                    newSubPbActivity.f(subPbModel7.aNe().aIr());
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                    }
                    aoVar8 = this.eqU.eqF;
                    if (aoVar8.aMZ() != null) {
                        aoVar21 = this.eqU.eqF;
                        if (view == aoVar21.aMZ().aKD()) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11739").s("obj_locate", 1));
                            aoVar22 = this.eqU.eqF;
                            aoVar22.auE();
                            if (this.eqU.checkUpIsLogin()) {
                                nVar4 = this.eqU.dhG;
                                nVar4.fB(null);
                                bVar = this.eqU.eqR;
                                if (bVar != null) {
                                    bVar2 = this.eqU.eqR;
                                    bVar2.aMx();
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                    }
                    aoVar9 = this.eqU.eqF;
                    if (aoVar9.aMZ() != null) {
                        aoVar18 = this.eqU.eqF;
                        if (view == aoVar18.aMZ().aKB()) {
                            aoVar19 = this.eqU.eqF;
                            aoVar19.auE();
                            SparseArray sparseArray = (SparseArray) view.getTag();
                            if (sparseArray != null) {
                                aoVar20 = this.eqU.eqF;
                                aoVar20.a(((Integer) sparseArray.get(w.h.tag_del_post_type)).intValue(), (String) sparseArray.get(w.h.tag_del_post_id), ((Integer) sparseArray.get(w.h.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(w.h.tag_del_post_is_self)).booleanValue());
                                return;
                            }
                            return;
                        }
                    }
                    aoVar10 = this.eqU.eqF;
                    if (aoVar10.aMZ() != null) {
                        aoVar16 = this.eqU.eqF;
                        if (view == aoVar16.aMZ().aKz()) {
                            if (com.baidu.adp.lib.util.i.hk()) {
                                aoVar17 = this.eqU.eqF;
                                aoVar17.auE();
                                if (!this.eqU.checkUpIsLogin()) {
                                    return;
                                }
                                this.eqU.aY(view);
                                return;
                            }
                            this.eqU.showToast(w.l.network_not_available);
                            return;
                        }
                    }
                    aoVar11 = this.eqU.eqF;
                    if (aoVar11.aMZ() != null) {
                        aoVar14 = this.eqU.eqF;
                        if (view == aoVar14.aMZ().aKA()) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11739").s("obj_locate", 4));
                            if (!com.baidu.adp.lib.util.i.hk()) {
                                this.eqU.showToast(w.l.network_not_available);
                                return;
                            }
                            Object tag = view.getTag();
                            aoVar15 = this.eqU.eqF;
                            aoVar15.auE();
                            if (tag instanceof String) {
                                subPbModel5 = this.eqU.eqD;
                                String CN = subPbModel5.CN();
                                if (this.eqU.checkUpIsLogin()) {
                                    this.eqU.nD(CN);
                                    return;
                                }
                                return;
                            } else if (tag instanceof SparseArray) {
                                SparseArray<Object> sparseArray2 = (SparseArray) tag;
                                if ((sparseArray2.get(w.h.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray2.get(w.h.tag_user_mute_visible)).booleanValue()) {
                                    sparseArray2.put(w.h.tag_from, 0);
                                    this.eqU.d(sparseArray2);
                                    return;
                                }
                                return;
                            } else {
                                return;
                            }
                        }
                    }
                    aoVar12 = this.eqU.eqF;
                    if (view != aoVar12.aMT()) {
                        aoVar13 = this.eqU.eqF;
                        if (view != aoVar13.aMY()) {
                            return;
                        }
                    }
                    if (this.eqU.checkUpIsLogin()) {
                        nVar = this.eqU.dhG;
                        if (nVar.Dp()) {
                            nVar3 = this.eqU.dhG;
                            nVar3.Dq();
                            return;
                        }
                        nVar2 = this.eqU.dhG;
                        nVar2.fB(null);
                        return;
                    }
                    return;
                }
            }
        }
        z = this.eqU.eqQ;
        if (z) {
            this.eqU.eqQ = false;
            return;
        }
        PbActivityConfig pbActivityConfig = new PbActivityConfig(this.eqU.getActivity());
        subPbModel = this.eqU.eqD;
        String threadID = subPbModel.getThreadID();
        subPbModel2 = this.eqU.eqD;
        PbActivityConfig createNormalCfg = pbActivityConfig.createNormalCfg(threadID, subPbModel2.CN(), "");
        subPbModel3 = this.eqU.eqD;
        if (!StringUtils.isNull(subPbModel3.aNx())) {
            subPbModel4 = this.eqU.eqD;
            createNormalCfg.setForumId(subPbModel4.aNx());
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
    }
}
