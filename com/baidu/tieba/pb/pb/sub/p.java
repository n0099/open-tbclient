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
    final /* synthetic */ NewSubPbActivity eis;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(NewSubPbActivity newSubPbActivity) {
        this.eis = newSubPbActivity;
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
            aoVar30 = this.eis.eid;
            if (aoVar30 == null) {
                return;
            }
        }
        aoVar = this.eis.eid;
        if (view == aoVar.aNo()) {
            aoVar29 = this.eis.eid;
            aoVar29.awl();
            String str = view.getTag(r.g.tag_user_id) instanceof String ? (String) view.getTag(r.g.tag_user_id) : null;
            String str2 = view.getTag(r.g.tag_user_name) instanceof String ? (String) view.getTag(r.g.tag_user_name) : null;
            if (str != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.eis.getPageContext().getPageActivity(), str, str2, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
                return;
            }
            return;
        }
        aoVar2 = this.eis.eid;
        if (view == aoVar2.aNh()) {
            aoVar27 = this.eis.eid;
            aoVar27.aMY();
            aoVar28 = this.eis.eid;
            aoVar28.aMZ();
            pVar5 = this.eis.ddg;
            if (pVar5 != null) {
                pVar6 = this.eis.ddg;
                pVar6.DB();
                bVar3 = this.eis.eip;
                if (bVar3 != null) {
                    bVar4 = this.eis.eip;
                    bVar4.aMM();
                    return;
                }
                return;
            }
            return;
        }
        aoVar3 = this.eis.eid;
        if (view == aoVar3.aNd()) {
            aoVar25 = this.eis.eid;
            aoVar25.awl();
            bcVar6 = this.eis.eib;
            if (bcVar6.EN()) {
                aoVar26 = this.eis.eid;
                aoVar26.aNb();
                return;
            }
            return;
        }
        aoVar4 = this.eis.eid;
        if (view != aoVar4.aNi()) {
            aoVar5 = this.eis.eid;
            if (view != aoVar5.aNj()) {
                aoVar6 = this.eis.eid;
                if (view != aoVar6.aNl()) {
                    aoVar7 = this.eis.eid;
                    if (aoVar7.aNm() != null) {
                        aoVar23 = this.eis.eid;
                        if (view == aoVar23.aNm().aKM()) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.at("c11739").s("obj_locate", 2));
                            aoVar24 = this.eis.eid;
                            aoVar24.awl();
                            if (this.eis.checkUpIsLogin()) {
                                bcVar4 = this.eis.eib;
                                if (bcVar4.aNr() != null) {
                                    NewSubPbActivity newSubPbActivity = this.eis;
                                    bcVar5 = this.eis.eib;
                                    newSubPbActivity.e(bcVar5.aNr().aIF());
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                    }
                    aoVar8 = this.eis.eid;
                    if (aoVar8.aNm() != null) {
                        aoVar21 = this.eis.eid;
                        if (view == aoVar21.aNm().aKR()) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.at("c11739").s("obj_locate", 1));
                            aoVar22 = this.eis.eid;
                            aoVar22.awl();
                            if (this.eis.checkUpIsLogin()) {
                                pVar4 = this.eis.ddg;
                                pVar4.fM(null);
                                bVar = this.eis.eip;
                                if (bVar != null) {
                                    bVar2 = this.eis.eip;
                                    bVar2.aMM();
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                    }
                    aoVar9 = this.eis.eid;
                    if (aoVar9.aNm() != null) {
                        aoVar18 = this.eis.eid;
                        if (view == aoVar18.aNm().aKP()) {
                            aoVar19 = this.eis.eid;
                            aoVar19.awl();
                            SparseArray sparseArray = (SparseArray) view.getTag();
                            if (sparseArray != null) {
                                aoVar20 = this.eis.eid;
                                aoVar20.a(((Integer) sparseArray.get(r.g.tag_del_post_type)).intValue(), (String) sparseArray.get(r.g.tag_del_post_id), ((Integer) sparseArray.get(r.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(r.g.tag_del_post_is_self)).booleanValue());
                                return;
                            }
                            return;
                        }
                    }
                    aoVar10 = this.eis.eid;
                    if (aoVar10.aNm() != null) {
                        aoVar16 = this.eis.eid;
                        if (view == aoVar16.aNm().aKN()) {
                            if (com.baidu.adp.lib.util.i.gm()) {
                                aoVar17 = this.eis.eid;
                                aoVar17.awl();
                                if (!this.eis.checkUpIsLogin()) {
                                    return;
                                }
                                this.eis.aY(view);
                                return;
                            }
                            this.eis.showToast(r.j.network_not_available);
                            return;
                        }
                    }
                    aoVar11 = this.eis.eid;
                    if (aoVar11.aNm() != null) {
                        aoVar14 = this.eis.eid;
                        if (view == aoVar14.aNm().aKO()) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.at("c11739").s("obj_locate", 4));
                            if (!com.baidu.adp.lib.util.i.gm()) {
                                this.eis.showToast(r.j.network_not_available);
                                return;
                            }
                            Object tag = view.getTag();
                            aoVar15 = this.eis.eid;
                            aoVar15.awl();
                            if (tag instanceof String) {
                                bcVar3 = this.eis.eib;
                                String CX = bcVar3.CX();
                                if (this.eis.checkUpIsLogin()) {
                                    this.eis.nR(CX);
                                    return;
                                }
                                return;
                            } else if (tag instanceof SparseArray) {
                                SparseArray<Object> sparseArray2 = (SparseArray) tag;
                                if ((sparseArray2.get(r.g.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray2.get(r.g.tag_user_mute_visible)).booleanValue()) {
                                    sparseArray2.put(r.g.tag_from, 0);
                                    this.eis.d(sparseArray2);
                                    return;
                                }
                                return;
                            } else {
                                return;
                            }
                        }
                    }
                    aoVar12 = this.eis.eid;
                    if (view != aoVar12.aNg()) {
                        aoVar13 = this.eis.eid;
                        if (view != aoVar13.aNl()) {
                            return;
                        }
                    }
                    if (this.eis.checkUpIsLogin()) {
                        pVar = this.eis.ddg;
                        if (pVar.Dz()) {
                            pVar3 = this.eis.ddg;
                            pVar3.DA();
                            return;
                        }
                        pVar2 = this.eis.ddg;
                        pVar2.fM(null);
                        return;
                    }
                    return;
                }
            }
        }
        z = this.eis.eio;
        if (z) {
            this.eis.eio = false;
            return;
        }
        MessageManager messageManager = MessageManager.getInstance();
        PbActivityConfig pbActivityConfig = new PbActivityConfig(this.eis.getActivity());
        bcVar = this.eis.eib;
        String threadID = bcVar.getThreadID();
        bcVar2 = this.eis.eib;
        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig.createNormalCfg(threadID, bcVar2.CX(), "")));
    }
}
