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
    final /* synthetic */ NewSubPbActivity evm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(NewSubPbActivity newSubPbActivity) {
        this.evm = newSubPbActivity;
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
            aoVar30 = this.evm.euX;
            if (aoVar30 == null) {
                return;
            }
        }
        aoVar = this.evm.euX;
        if (view == aoVar.aPL()) {
            aoVar29 = this.evm.euX;
            aoVar29.axI();
            String str = view.getTag(w.h.tag_user_id) instanceof String ? (String) view.getTag(w.h.tag_user_id) : null;
            String str2 = view.getTag(w.h.tag_user_name) instanceof String ? (String) view.getTag(w.h.tag_user_name) : null;
            String str3 = view.getTag(w.h.tag_virtual_user_url) instanceof String ? (String) view.getTag(w.h.tag_virtual_user_url) : null;
            if (str3 != null) {
                if (this.evm.checkUpIsLogin()) {
                    com.baidu.tbadk.core.util.bb.wn().c(this.evm.getPageContext(), new String[]{str3});
                    return;
                }
                return;
            } else if (str != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.evm.getPageContext().getPageActivity(), str, str2, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
                return;
            } else {
                return;
            }
        }
        aoVar2 = this.evm.euX;
        if (view == aoVar2.aPE()) {
            aoVar27 = this.evm.euX;
            aoVar27.aPv();
            aoVar28 = this.evm.euX;
            aoVar28.aPw();
            nVar5 = this.evm.dnB;
            if (nVar5 != null) {
                nVar6 = this.evm.dnB;
                nVar6.En();
                bVar3 = this.evm.evj;
                if (bVar3 != null) {
                    bVar4 = this.evm.evj;
                    bVar4.aPi();
                    return;
                }
                return;
            }
            return;
        }
        aoVar3 = this.evm.euX;
        if (view == aoVar3.aPA()) {
            aoVar25 = this.evm.euX;
            aoVar25.axI();
            subPbModel6 = this.evm.euV;
            if (subPbModel6.FC()) {
                aoVar26 = this.evm.euX;
                aoVar26.aPy();
                return;
            }
            return;
        }
        aoVar4 = this.evm.euX;
        if (view != aoVar4.aPF()) {
            aoVar5 = this.evm.euX;
            if (view != aoVar5.aPG()) {
                aoVar6 = this.evm.euX;
                if (view != aoVar6.aPI()) {
                    aoVar7 = this.evm.euX;
                    if (aoVar7.aPJ() != null) {
                        aoVar23 = this.evm.euX;
                        if (view == aoVar23.aPJ().aNg()) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11739").s("obj_locate", 2));
                            aoVar24 = this.evm.euX;
                            aoVar24.axI();
                            if (this.evm.checkUpIsLogin()) {
                                subPbModel4 = this.evm.euV;
                                if (subPbModel4.aPO() != null) {
                                    NewSubPbActivity newSubPbActivity = this.evm;
                                    subPbModel5 = this.evm.euV;
                                    newSubPbActivity.d(subPbModel5.aPO().aKW());
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                    }
                    aoVar8 = this.evm.euX;
                    if (aoVar8.aPJ() != null) {
                        aoVar21 = this.evm.euX;
                        if (view == aoVar21.aPJ().aNl()) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11739").s("obj_locate", 1));
                            aoVar22 = this.evm.euX;
                            aoVar22.axI();
                            if (this.evm.checkUpIsLogin()) {
                                nVar4 = this.evm.dnB;
                                nVar4.fE(null);
                                bVar = this.evm.evj;
                                if (bVar != null) {
                                    bVar2 = this.evm.evj;
                                    bVar2.aPi();
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                    }
                    aoVar9 = this.evm.euX;
                    if (aoVar9.aPJ() != null) {
                        aoVar18 = this.evm.euX;
                        if (view == aoVar18.aPJ().aNj()) {
                            aoVar19 = this.evm.euX;
                            aoVar19.axI();
                            SparseArray sparseArray = (SparseArray) view.getTag();
                            if (sparseArray != null) {
                                aoVar20 = this.evm.euX;
                                aoVar20.a(((Integer) sparseArray.get(w.h.tag_del_post_type)).intValue(), (String) sparseArray.get(w.h.tag_del_post_id), ((Integer) sparseArray.get(w.h.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(w.h.tag_del_post_is_self)).booleanValue());
                                return;
                            }
                            return;
                        }
                    }
                    aoVar10 = this.evm.euX;
                    if (aoVar10.aPJ() != null) {
                        aoVar16 = this.evm.euX;
                        if (view == aoVar16.aPJ().aNh()) {
                            if (com.baidu.adp.lib.util.i.hk()) {
                                aoVar17 = this.evm.euX;
                                aoVar17.axI();
                                if (!this.evm.checkUpIsLogin()) {
                                    return;
                                }
                                this.evm.bc(view);
                                return;
                            }
                            this.evm.showToast(w.l.network_not_available);
                            return;
                        }
                    }
                    aoVar11 = this.evm.euX;
                    if (aoVar11.aPJ() != null) {
                        aoVar14 = this.evm.euX;
                        if (view == aoVar14.aPJ().aNi()) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11739").s("obj_locate", 4));
                            if (!com.baidu.adp.lib.util.i.hk()) {
                                this.evm.showToast(w.l.network_not_available);
                                return;
                            }
                            Object tag = view.getTag();
                            aoVar15 = this.evm.euX;
                            aoVar15.axI();
                            if (tag instanceof String) {
                                subPbModel3 = this.evm.euV;
                                String DJ = subPbModel3.DJ();
                                if (this.evm.checkUpIsLogin()) {
                                    this.evm.nw(DJ);
                                    return;
                                }
                                return;
                            } else if (tag instanceof SparseArray) {
                                SparseArray<Object> sparseArray2 = (SparseArray) tag;
                                if ((sparseArray2.get(w.h.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray2.get(w.h.tag_user_mute_visible)).booleanValue()) {
                                    sparseArray2.put(w.h.tag_from, 0);
                                    this.evm.d(sparseArray2);
                                    return;
                                }
                                return;
                            } else {
                                return;
                            }
                        }
                    }
                    aoVar12 = this.evm.euX;
                    if (view != aoVar12.aPD()) {
                        aoVar13 = this.evm.euX;
                        if (view != aoVar13.aPI()) {
                            return;
                        }
                    }
                    if (this.evm.checkUpIsLogin()) {
                        nVar = this.evm.dnB;
                        if (nVar.El()) {
                            nVar3 = this.evm.dnB;
                            nVar3.Em();
                            return;
                        }
                        nVar2 = this.evm.dnB;
                        nVar2.fE(null);
                        return;
                    }
                    return;
                }
            }
        }
        z = this.evm.evi;
        if (z) {
            this.evm.evi = false;
            return;
        }
        MessageManager messageManager = MessageManager.getInstance();
        PbActivityConfig pbActivityConfig = new PbActivityConfig(this.evm.getActivity());
        subPbModel = this.evm.euV;
        String threadID = subPbModel.getThreadID();
        subPbModel2 = this.evm.euV;
        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig.createNormalCfg(threadID, subPbModel2.DJ(), "")));
    }
}
