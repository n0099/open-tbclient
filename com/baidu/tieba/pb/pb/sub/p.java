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
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements View.OnClickListener {
    final /* synthetic */ NewSubPbActivity eEs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(NewSubPbActivity newSubPbActivity) {
        this.eEs = newSubPbActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ao aoVar;
        ao aoVar2;
        ao aoVar3;
        ao aoVar4;
        boolean z;
        bc bcVar;
        bc bcVar2;
        ao aoVar5;
        ao aoVar6;
        ao aoVar7;
        ao aoVar8;
        ao aoVar9;
        ao aoVar10;
        ao aoVar11;
        ao aoVar12;
        com.baidu.tbadk.editortools.e.p pVar;
        com.baidu.tbadk.editortools.e.p pVar2;
        com.baidu.tbadk.editortools.e.p pVar3;
        ao aoVar13;
        ao aoVar14;
        ao aoVar15;
        bc bcVar3;
        ao aoVar16;
        ao aoVar17;
        ao aoVar18;
        ao aoVar19;
        ao aoVar20;
        ao aoVar21;
        ao aoVar22;
        com.baidu.tbadk.editortools.e.p pVar4;
        b bVar;
        b bVar2;
        ao aoVar23;
        ao aoVar24;
        bc bcVar4;
        bc bcVar5;
        ao aoVar25;
        bc bcVar6;
        ao aoVar26;
        ao aoVar27;
        ao aoVar28;
        com.baidu.tbadk.editortools.e.p pVar5;
        com.baidu.tbadk.editortools.e.p pVar6;
        b bVar3;
        b bVar4;
        ao aoVar29;
        ao aoVar30;
        if (view == null) {
            aoVar30 = this.eEs.eEd;
            if (aoVar30 == null) {
                return;
            }
        }
        aoVar = this.eEs.eEd;
        if (view == aoVar.aTx()) {
            aoVar29 = this.eEs.eEd;
            aoVar29.aCY();
            String str = view.getTag(r.g.tag_user_id) instanceof String ? (String) view.getTag(r.g.tag_user_id) : null;
            String str2 = view.getTag(r.g.tag_user_name) instanceof String ? (String) view.getTag(r.g.tag_user_name) : null;
            if (str != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.eEs.getPageContext().getPageActivity(), str, str2, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
                return;
            }
            return;
        }
        aoVar2 = this.eEs.eEd;
        if (view == aoVar2.aTq()) {
            aoVar27 = this.eEs.eEd;
            aoVar27.aTh();
            aoVar28 = this.eEs.eEd;
            aoVar28.aTi();
            pVar5 = this.eEs.dAe;
            if (pVar5 != null) {
                pVar6 = this.eEs.dAe;
                pVar6.DT();
                bVar3 = this.eEs.eEp;
                if (bVar3 != null) {
                    bVar4 = this.eEs.eEp;
                    bVar4.aSV();
                    return;
                }
                return;
            }
            return;
        }
        aoVar3 = this.eEs.eEd;
        if (view == aoVar3.aTm()) {
            aoVar25 = this.eEs.eEd;
            aoVar25.aCY();
            bcVar6 = this.eEs.eEb;
            if (bcVar6.Ff()) {
                aoVar26 = this.eEs.eEd;
                aoVar26.aTk();
                return;
            }
            return;
        }
        aoVar4 = this.eEs.eEd;
        if (view != aoVar4.aTr()) {
            aoVar5 = this.eEs.eEd;
            if (view != aoVar5.aTs()) {
                aoVar6 = this.eEs.eEd;
                if (view != aoVar6.aTu()) {
                    aoVar7 = this.eEs.eEd;
                    if (aoVar7.aTv() != null) {
                        aoVar23 = this.eEs.eEd;
                        if (view == aoVar23.aTv().aQN()) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.av("c11739").s("obj_locate", 2));
                            aoVar24 = this.eEs.eEd;
                            aoVar24.aCY();
                            if (this.eEs.checkUpIsLogin()) {
                                bcVar4 = this.eEs.eEb;
                                if (bcVar4.aTA() != null) {
                                    NewSubPbActivity newSubPbActivity = this.eEs;
                                    bcVar5 = this.eEs.eEb;
                                    newSubPbActivity.e(bcVar5.aTA().aOG());
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                    }
                    aoVar8 = this.eEs.eEd;
                    if (aoVar8.aTv() != null) {
                        aoVar21 = this.eEs.eEd;
                        if (view == aoVar21.aTv().aQS()) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.av("c11739").s("obj_locate", 1));
                            aoVar22 = this.eEs.eEd;
                            aoVar22.aCY();
                            if (this.eEs.checkUpIsLogin()) {
                                pVar4 = this.eEs.dAe;
                                pVar4.fQ(null);
                                bVar = this.eEs.eEp;
                                if (bVar != null) {
                                    bVar2 = this.eEs.eEp;
                                    bVar2.aSV();
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                    }
                    aoVar9 = this.eEs.eEd;
                    if (aoVar9.aTv() != null) {
                        aoVar18 = this.eEs.eEd;
                        if (view == aoVar18.aTv().aQQ()) {
                            aoVar19 = this.eEs.eEd;
                            aoVar19.aCY();
                            SparseArray sparseArray = (SparseArray) view.getTag();
                            if (sparseArray != null) {
                                aoVar20 = this.eEs.eEd;
                                aoVar20.a(((Integer) sparseArray.get(r.g.tag_del_post_type)).intValue(), (String) sparseArray.get(r.g.tag_del_post_id), ((Integer) sparseArray.get(r.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(r.g.tag_del_post_is_self)).booleanValue());
                                return;
                            }
                            return;
                        }
                    }
                    aoVar10 = this.eEs.eEd;
                    if (aoVar10.aTv() != null) {
                        aoVar16 = this.eEs.eEd;
                        if (view == aoVar16.aTv().aQO()) {
                            if (com.baidu.adp.lib.util.i.gm()) {
                                aoVar17 = this.eEs.eEd;
                                aoVar17.aCY();
                                if (!this.eEs.checkUpIsLogin()) {
                                    return;
                                }
                                this.eEs.aZ(view);
                                return;
                            }
                            this.eEs.showToast(r.j.network_not_available);
                            return;
                        }
                    }
                    aoVar11 = this.eEs.eEd;
                    if (aoVar11.aTv() != null) {
                        aoVar14 = this.eEs.eEd;
                        if (view == aoVar14.aTv().aQP()) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.av("c11739").s("obj_locate", 4));
                            if (!com.baidu.adp.lib.util.i.gm()) {
                                this.eEs.showToast(r.j.network_not_available);
                                return;
                            }
                            Object tag = view.getTag();
                            aoVar15 = this.eEs.eEd;
                            aoVar15.aCY();
                            if (tag instanceof String) {
                                bcVar3 = this.eEs.eEb;
                                String Do = bcVar3.Do();
                                if (this.eEs.checkUpIsLogin()) {
                                    this.eEs.pq(Do);
                                    return;
                                }
                                return;
                            } else if (tag instanceof SparseArray) {
                                SparseArray<Object> sparseArray2 = (SparseArray) tag;
                                if ((sparseArray2.get(r.g.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray2.get(r.g.tag_user_mute_visible)).booleanValue()) {
                                    sparseArray2.put(r.g.tag_from, 0);
                                    this.eEs.d(sparseArray2);
                                    return;
                                }
                                return;
                            } else {
                                return;
                            }
                        }
                    }
                    aoVar12 = this.eEs.eEd;
                    if (view != aoVar12.aTp()) {
                        aoVar13 = this.eEs.eEd;
                        if (view != aoVar13.aTu()) {
                            return;
                        }
                    }
                    if (this.eEs.checkUpIsLogin()) {
                        pVar = this.eEs.dAe;
                        if (pVar.DR()) {
                            pVar3 = this.eEs.dAe;
                            pVar3.DS();
                            return;
                        }
                        pVar2 = this.eEs.dAe;
                        pVar2.fQ(null);
                        return;
                    }
                    return;
                }
            }
        }
        z = this.eEs.eEo;
        if (z) {
            this.eEs.eEo = false;
            return;
        }
        MessageManager messageManager = MessageManager.getInstance();
        PbActivityConfig pbActivityConfig = new PbActivityConfig(this.eEs.getActivity());
        bcVar = this.eEs.eEb;
        String threadID = bcVar.getThreadID();
        bcVar2 = this.eEs.eEb;
        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig.createNormalCfg(threadID, bcVar2.Do(), "")));
    }
}
