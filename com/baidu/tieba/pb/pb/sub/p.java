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
    final /* synthetic */ NewSubPbActivity erC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(NewSubPbActivity newSubPbActivity) {
        this.erC = newSubPbActivity;
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
            aoVar30 = this.erC.ern;
            if (aoVar30 == null) {
                return;
            }
        }
        aoVar = this.erC.ern;
        if (view == aoVar.aPk()) {
            aoVar29 = this.erC.ern;
            aoVar29.axs();
            String str = view.getTag(r.h.tag_user_id) instanceof String ? (String) view.getTag(r.h.tag_user_id) : null;
            String str2 = view.getTag(r.h.tag_user_name) instanceof String ? (String) view.getTag(r.h.tag_user_name) : null;
            String str3 = view.getTag(r.h.tag_virtual_user_url) instanceof String ? (String) view.getTag(r.h.tag_virtual_user_url) : null;
            if (str3 != null) {
                if (this.erC.checkUpIsLogin()) {
                    com.baidu.tbadk.core.util.ba.vt().c(this.erC.getPageContext(), new String[]{str3});
                    return;
                }
                return;
            } else if (str != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.erC.getPageContext().getPageActivity(), str, str2, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
                return;
            } else {
                return;
            }
        }
        aoVar2 = this.erC.ern;
        if (view == aoVar2.aPd()) {
            aoVar27 = this.erC.ern;
            aoVar27.aOU();
            aoVar28 = this.erC.ern;
            aoVar28.aOV();
            nVar5 = this.erC.dkr;
            if (nVar5 != null) {
                nVar6 = this.erC.dkr;
                nVar6.Dw();
                bVar3 = this.erC.erz;
                if (bVar3 != null) {
                    bVar4 = this.erC.erz;
                    bVar4.aOH();
                    return;
                }
                return;
            }
            return;
        }
        aoVar3 = this.erC.ern;
        if (view == aoVar3.aOZ()) {
            aoVar25 = this.erC.ern;
            aoVar25.axs();
            subPbModel6 = this.erC.erl;
            if (subPbModel6.EH()) {
                aoVar26 = this.erC.ern;
                aoVar26.aOX();
                return;
            }
            return;
        }
        aoVar4 = this.erC.ern;
        if (view != aoVar4.aPe()) {
            aoVar5 = this.erC.ern;
            if (view != aoVar5.aPf()) {
                aoVar6 = this.erC.ern;
                if (view != aoVar6.aPh()) {
                    aoVar7 = this.erC.ern;
                    if (aoVar7.aPi() != null) {
                        aoVar23 = this.erC.ern;
                        if (view == aoVar23.aPi().aMz()) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11739").s("obj_locate", 2));
                            aoVar24 = this.erC.ern;
                            aoVar24.axs();
                            if (this.erC.checkUpIsLogin()) {
                                subPbModel4 = this.erC.erl;
                                if (subPbModel4.aPn() != null) {
                                    NewSubPbActivity newSubPbActivity = this.erC;
                                    subPbModel5 = this.erC.erl;
                                    newSubPbActivity.d(subPbModel5.aPn().aKw());
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                    }
                    aoVar8 = this.erC.ern;
                    if (aoVar8.aPi() != null) {
                        aoVar21 = this.erC.ern;
                        if (view == aoVar21.aPi().aME()) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11739").s("obj_locate", 1));
                            aoVar22 = this.erC.ern;
                            aoVar22.axs();
                            if (this.erC.checkUpIsLogin()) {
                                nVar4 = this.erC.dkr;
                                nVar4.fJ(null);
                                bVar = this.erC.erz;
                                if (bVar != null) {
                                    bVar2 = this.erC.erz;
                                    bVar2.aOH();
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                    }
                    aoVar9 = this.erC.ern;
                    if (aoVar9.aPi() != null) {
                        aoVar18 = this.erC.ern;
                        if (view == aoVar18.aPi().aMC()) {
                            aoVar19 = this.erC.ern;
                            aoVar19.axs();
                            SparseArray sparseArray = (SparseArray) view.getTag();
                            if (sparseArray != null) {
                                aoVar20 = this.erC.ern;
                                aoVar20.a(((Integer) sparseArray.get(r.h.tag_del_post_type)).intValue(), (String) sparseArray.get(r.h.tag_del_post_id), ((Integer) sparseArray.get(r.h.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(r.h.tag_del_post_is_self)).booleanValue());
                                return;
                            }
                            return;
                        }
                    }
                    aoVar10 = this.erC.ern;
                    if (aoVar10.aPi() != null) {
                        aoVar16 = this.erC.ern;
                        if (view == aoVar16.aPi().aMA()) {
                            if (com.baidu.adp.lib.util.i.gk()) {
                                aoVar17 = this.erC.ern;
                                aoVar17.axs();
                                if (!this.erC.checkUpIsLogin()) {
                                    return;
                                }
                                this.erC.bf(view);
                                return;
                            }
                            this.erC.showToast(r.l.network_not_available);
                            return;
                        }
                    }
                    aoVar11 = this.erC.ern;
                    if (aoVar11.aPi() != null) {
                        aoVar14 = this.erC.ern;
                        if (view == aoVar14.aPi().aMB()) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11739").s("obj_locate", 4));
                            if (!com.baidu.adp.lib.util.i.gk()) {
                                this.erC.showToast(r.l.network_not_available);
                                return;
                            }
                            Object tag = view.getTag();
                            aoVar15 = this.erC.ern;
                            aoVar15.axs();
                            if (tag instanceof String) {
                                subPbModel3 = this.erC.erl;
                                String CS = subPbModel3.CS();
                                if (this.erC.checkUpIsLogin()) {
                                    this.erC.oi(CS);
                                    return;
                                }
                                return;
                            } else if (tag instanceof SparseArray) {
                                SparseArray<Object> sparseArray2 = (SparseArray) tag;
                                if ((sparseArray2.get(r.h.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray2.get(r.h.tag_user_mute_visible)).booleanValue()) {
                                    sparseArray2.put(r.h.tag_from, 0);
                                    this.erC.d(sparseArray2);
                                    return;
                                }
                                return;
                            } else {
                                return;
                            }
                        }
                    }
                    aoVar12 = this.erC.ern;
                    if (view != aoVar12.aPc()) {
                        aoVar13 = this.erC.ern;
                        if (view != aoVar13.aPh()) {
                            return;
                        }
                    }
                    if (this.erC.checkUpIsLogin()) {
                        nVar = this.erC.dkr;
                        if (nVar.Du()) {
                            nVar3 = this.erC.dkr;
                            nVar3.Dv();
                            return;
                        }
                        nVar2 = this.erC.dkr;
                        nVar2.fJ(null);
                        return;
                    }
                    return;
                }
            }
        }
        z = this.erC.ery;
        if (z) {
            this.erC.ery = false;
            return;
        }
        MessageManager messageManager = MessageManager.getInstance();
        PbActivityConfig pbActivityConfig = new PbActivityConfig(this.erC.getActivity());
        subPbModel = this.erC.erl;
        String threadID = subPbModel.getThreadID();
        subPbModel2 = this.erC.erl;
        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig.createNormalCfg(threadID, subPbModel2.CS(), "")));
    }
}
