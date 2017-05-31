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
    final /* synthetic */ NewSubPbActivity eye;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(NewSubPbActivity newSubPbActivity) {
        this.eye = newSubPbActivity;
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
            aoVar30 = this.eye.exP;
            if (aoVar30 == null) {
                return;
            }
        }
        aoVar = this.eye.exP;
        if (view == aoVar.aOk()) {
            aoVar29 = this.eye.exP;
            aoVar29.avy();
            String str = view.getTag(w.h.tag_user_id) instanceof String ? (String) view.getTag(w.h.tag_user_id) : null;
            String str2 = view.getTag(w.h.tag_user_name) instanceof String ? (String) view.getTag(w.h.tag_user_name) : null;
            String str3 = view.getTag(w.h.tag_virtual_user_url) instanceof String ? (String) view.getTag(w.h.tag_virtual_user_url) : null;
            if (str3 != null) {
                if (this.eye.checkUpIsLogin()) {
                    com.baidu.tbadk.core.util.bb.vy().c(this.eye.getPageContext(), new String[]{str3});
                    return;
                }
                return;
            } else if (str != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.eye.getPageContext().getPageActivity(), str, str2, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
                return;
            } else {
                return;
            }
        }
        aoVar2 = this.eye.exP;
        if (view == aoVar2.aOd()) {
            aoVar27 = this.eye.exP;
            aoVar27.aNU();
            aoVar28 = this.eye.exP;
            aoVar28.aNV();
            nVar5 = this.eye.dnc;
            if (nVar5 != null) {
                nVar6 = this.eye.dnc;
                nVar6.Dl();
                bVar3 = this.eye.eyb;
                if (bVar3 != null) {
                    bVar4 = this.eye.eyb;
                    bVar4.aNG();
                    return;
                }
                return;
            }
            return;
        }
        aoVar3 = this.eye.exP;
        if (view == aoVar3.aNZ()) {
            aoVar25 = this.eye.exP;
            aoVar25.avy();
            subPbModel8 = this.eye.exN;
            if (subPbModel8.EA()) {
                aoVar26 = this.eye.exP;
                aoVar26.aNX();
                return;
            }
            return;
        }
        aoVar4 = this.eye.exP;
        if (view != aoVar4.aOe()) {
            aoVar5 = this.eye.exP;
            if (view != aoVar5.aOf()) {
                aoVar6 = this.eye.exP;
                if (view != aoVar6.aOh()) {
                    aoVar7 = this.eye.exP;
                    if (aoVar7.aOi() != null) {
                        aoVar23 = this.eye.exP;
                        if (view == aoVar23.aOi().aLt()) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11739").r("obj_locate", 2));
                            aoVar24 = this.eye.exP;
                            aoVar24.avy();
                            if (this.eye.checkUpIsLogin()) {
                                subPbModel6 = this.eye.exN;
                                if (subPbModel6.aOn() != null) {
                                    NewSubPbActivity newSubPbActivity = this.eye;
                                    subPbModel7 = this.eye.exN;
                                    newSubPbActivity.g(subPbModel7.aOn().aJj());
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                    }
                    aoVar8 = this.eye.exP;
                    if (aoVar8.aOi() != null) {
                        aoVar21 = this.eye.exP;
                        if (view == aoVar21.aOi().aLy()) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11739").r("obj_locate", 1));
                            aoVar22 = this.eye.exP;
                            aoVar22.avy();
                            if (this.eye.checkUpIsLogin()) {
                                nVar4 = this.eye.dnc;
                                nVar4.fz(null);
                                bVar = this.eye.eyb;
                                if (bVar != null) {
                                    bVar2 = this.eye.eyb;
                                    bVar2.aNG();
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                    }
                    aoVar9 = this.eye.exP;
                    if (aoVar9.aOi() != null) {
                        aoVar18 = this.eye.exP;
                        if (view == aoVar18.aOi().aLw()) {
                            aoVar19 = this.eye.exP;
                            aoVar19.avy();
                            SparseArray sparseArray = (SparseArray) view.getTag();
                            if (sparseArray != null) {
                                aoVar20 = this.eye.exP;
                                aoVar20.a(((Integer) sparseArray.get(w.h.tag_del_post_type)).intValue(), (String) sparseArray.get(w.h.tag_del_post_id), ((Integer) sparseArray.get(w.h.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(w.h.tag_del_post_is_self)).booleanValue());
                                return;
                            }
                            return;
                        }
                    }
                    aoVar10 = this.eye.exP;
                    if (aoVar10.aOi() != null) {
                        aoVar16 = this.eye.exP;
                        if (view == aoVar16.aOi().aLu()) {
                            if (com.baidu.adp.lib.util.i.hk()) {
                                aoVar17 = this.eye.exP;
                                aoVar17.avy();
                                if (!this.eye.checkUpIsLogin()) {
                                    return;
                                }
                                this.eye.aZ(view);
                                return;
                            }
                            this.eye.showToast(w.l.network_not_available);
                            return;
                        }
                    }
                    aoVar11 = this.eye.exP;
                    if (aoVar11.aOi() != null) {
                        aoVar14 = this.eye.exP;
                        if (view == aoVar14.aOi().aLv()) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11739").r("obj_locate", 4));
                            if (!com.baidu.adp.lib.util.i.hk()) {
                                this.eye.showToast(w.l.network_not_available);
                                return;
                            }
                            Object tag = view.getTag();
                            aoVar15 = this.eye.exP;
                            aoVar15.avy();
                            if (tag instanceof String) {
                                subPbModel5 = this.eye.exN;
                                String CH = subPbModel5.CH();
                                if (this.eye.checkUpIsLogin()) {
                                    this.eye.nP(CH);
                                    return;
                                }
                                return;
                            } else if (tag instanceof SparseArray) {
                                SparseArray<Object> sparseArray2 = (SparseArray) tag;
                                if ((sparseArray2.get(w.h.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray2.get(w.h.tag_user_mute_visible)).booleanValue()) {
                                    sparseArray2.put(w.h.tag_from, 0);
                                    this.eye.d(sparseArray2);
                                    return;
                                }
                                return;
                            } else {
                                return;
                            }
                        }
                    }
                    aoVar12 = this.eye.exP;
                    if (view != aoVar12.aOc()) {
                        aoVar13 = this.eye.exP;
                        if (view != aoVar13.aOh()) {
                            return;
                        }
                    }
                    if (this.eye.checkUpIsLogin()) {
                        nVar = this.eye.dnc;
                        if (nVar.Dj()) {
                            nVar3 = this.eye.dnc;
                            nVar3.Dk();
                            return;
                        }
                        nVar2 = this.eye.dnc;
                        nVar2.fz(null);
                        return;
                    }
                    return;
                }
            }
        }
        z = this.eye.eya;
        if (z) {
            this.eye.eya = false;
            return;
        }
        PbActivityConfig pbActivityConfig = new PbActivityConfig(this.eye.getActivity());
        subPbModel = this.eye.exN;
        String threadID = subPbModel.getThreadID();
        subPbModel2 = this.eye.exN;
        PbActivityConfig createNormalCfg = pbActivityConfig.createNormalCfg(threadID, subPbModel2.CH(), "");
        subPbModel3 = this.eye.exN;
        if (!StringUtils.isNull(subPbModel3.aOG())) {
            subPbModel4 = this.eye.exN;
            createNormalCfg.setForumId(subPbModel4.aOG());
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
    }
}
