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
    final /* synthetic */ NewSubPbActivity euQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(NewSubPbActivity newSubPbActivity) {
        this.euQ = newSubPbActivity;
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
            aoVar30 = this.euQ.euB;
            if (aoVar30 == null) {
                return;
            }
        }
        aoVar = this.euQ.euB;
        if (view == aoVar.aOB()) {
            aoVar29 = this.euQ.euB;
            aoVar29.awO();
            String str = view.getTag(w.h.tag_user_id) instanceof String ? (String) view.getTag(w.h.tag_user_id) : null;
            String str2 = view.getTag(w.h.tag_user_name) instanceof String ? (String) view.getTag(w.h.tag_user_name) : null;
            String str3 = view.getTag(w.h.tag_virtual_user_url) instanceof String ? (String) view.getTag(w.h.tag_virtual_user_url) : null;
            if (str3 != null) {
                if (this.euQ.checkUpIsLogin()) {
                    com.baidu.tbadk.core.util.bb.vQ().c(this.euQ.getPageContext(), new String[]{str3});
                    return;
                }
                return;
            } else if (str != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.euQ.getPageContext().getPageActivity(), str, str2, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
                return;
            } else {
                return;
            }
        }
        aoVar2 = this.euQ.euB;
        if (view == aoVar2.aOu()) {
            aoVar27 = this.euQ.euB;
            aoVar27.aOl();
            aoVar28 = this.euQ.euB;
            aoVar28.aOm();
            nVar5 = this.euQ.dmL;
            if (nVar5 != null) {
                nVar6 = this.euQ.dmL;
                nVar6.DP();
                bVar3 = this.euQ.euN;
                if (bVar3 != null) {
                    bVar4 = this.euQ.euN;
                    bVar4.aNY();
                    return;
                }
                return;
            }
            return;
        }
        aoVar3 = this.euQ.euB;
        if (view == aoVar3.aOq()) {
            aoVar25 = this.euQ.euB;
            aoVar25.awO();
            subPbModel6 = this.euQ.euz;
            if (subPbModel6.Fe()) {
                aoVar26 = this.euQ.euB;
                aoVar26.aOo();
                return;
            }
            return;
        }
        aoVar4 = this.euQ.euB;
        if (view != aoVar4.aOv()) {
            aoVar5 = this.euQ.euB;
            if (view != aoVar5.aOw()) {
                aoVar6 = this.euQ.euB;
                if (view != aoVar6.aOy()) {
                    aoVar7 = this.euQ.euB;
                    if (aoVar7.aOz() != null) {
                        aoVar23 = this.euQ.euB;
                        if (view == aoVar23.aOz().aLW()) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11739").s("obj_locate", 2));
                            aoVar24 = this.euQ.euB;
                            aoVar24.awO();
                            if (this.euQ.checkUpIsLogin()) {
                                subPbModel4 = this.euQ.euz;
                                if (subPbModel4.aOE() != null) {
                                    NewSubPbActivity newSubPbActivity = this.euQ;
                                    subPbModel5 = this.euQ.euz;
                                    newSubPbActivity.d(subPbModel5.aOE().aJO());
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                    }
                    aoVar8 = this.euQ.euB;
                    if (aoVar8.aOz() != null) {
                        aoVar21 = this.euQ.euB;
                        if (view == aoVar21.aOz().aMb()) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11739").s("obj_locate", 1));
                            aoVar22 = this.euQ.euB;
                            aoVar22.awO();
                            if (this.euQ.checkUpIsLogin()) {
                                nVar4 = this.euQ.dmL;
                                nVar4.fy(null);
                                bVar = this.euQ.euN;
                                if (bVar != null) {
                                    bVar2 = this.euQ.euN;
                                    bVar2.aNY();
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                    }
                    aoVar9 = this.euQ.euB;
                    if (aoVar9.aOz() != null) {
                        aoVar18 = this.euQ.euB;
                        if (view == aoVar18.aOz().aLZ()) {
                            aoVar19 = this.euQ.euB;
                            aoVar19.awO();
                            SparseArray sparseArray = (SparseArray) view.getTag();
                            if (sparseArray != null) {
                                aoVar20 = this.euQ.euB;
                                aoVar20.a(((Integer) sparseArray.get(w.h.tag_del_post_type)).intValue(), (String) sparseArray.get(w.h.tag_del_post_id), ((Integer) sparseArray.get(w.h.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(w.h.tag_del_post_is_self)).booleanValue());
                                return;
                            }
                            return;
                        }
                    }
                    aoVar10 = this.euQ.euB;
                    if (aoVar10.aOz() != null) {
                        aoVar16 = this.euQ.euB;
                        if (view == aoVar16.aOz().aLX()) {
                            if (com.baidu.adp.lib.util.i.he()) {
                                aoVar17 = this.euQ.euB;
                                aoVar17.awO();
                                if (!this.euQ.checkUpIsLogin()) {
                                    return;
                                }
                                this.euQ.be(view);
                                return;
                            }
                            this.euQ.showToast(w.l.network_not_available);
                            return;
                        }
                    }
                    aoVar11 = this.euQ.euB;
                    if (aoVar11.aOz() != null) {
                        aoVar14 = this.euQ.euB;
                        if (view == aoVar14.aOz().aLY()) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11739").s("obj_locate", 4));
                            if (!com.baidu.adp.lib.util.i.he()) {
                                this.euQ.showToast(w.l.network_not_available);
                                return;
                            }
                            Object tag = view.getTag();
                            aoVar15 = this.euQ.euB;
                            aoVar15.awO();
                            if (tag instanceof String) {
                                subPbModel3 = this.euQ.euz;
                                String Dl = subPbModel3.Dl();
                                if (this.euQ.checkUpIsLogin()) {
                                    this.euQ.np(Dl);
                                    return;
                                }
                                return;
                            } else if (tag instanceof SparseArray) {
                                SparseArray<Object> sparseArray2 = (SparseArray) tag;
                                if ((sparseArray2.get(w.h.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray2.get(w.h.tag_user_mute_visible)).booleanValue()) {
                                    sparseArray2.put(w.h.tag_from, 0);
                                    this.euQ.d(sparseArray2);
                                    return;
                                }
                                return;
                            } else {
                                return;
                            }
                        }
                    }
                    aoVar12 = this.euQ.euB;
                    if (view != aoVar12.aOt()) {
                        aoVar13 = this.euQ.euB;
                        if (view != aoVar13.aOy()) {
                            return;
                        }
                    }
                    if (this.euQ.checkUpIsLogin()) {
                        nVar = this.euQ.dmL;
                        if (nVar.DN()) {
                            nVar3 = this.euQ.dmL;
                            nVar3.DO();
                            return;
                        }
                        nVar2 = this.euQ.dmL;
                        nVar2.fy(null);
                        return;
                    }
                    return;
                }
            }
        }
        z = this.euQ.euM;
        if (z) {
            this.euQ.euM = false;
            return;
        }
        MessageManager messageManager = MessageManager.getInstance();
        PbActivityConfig pbActivityConfig = new PbActivityConfig(this.euQ.getActivity());
        subPbModel = this.euQ.euz;
        String threadID = subPbModel.getThreadID();
        subPbModel2 = this.euQ.euz;
        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig.createNormalCfg(threadID, subPbModel2.Dl(), "")));
    }
}
