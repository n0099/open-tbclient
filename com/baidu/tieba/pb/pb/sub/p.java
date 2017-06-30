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
import com.baidu.tbadk.core.util.be;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements View.OnClickListener {
    final /* synthetic */ NewSubPbActivity eHC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(NewSubPbActivity newSubPbActivity) {
        this.eHC = newSubPbActivity;
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
            aoVar30 = this.eHC.eHn;
            if (aoVar30 == null) {
                return;
            }
        }
        aoVar = this.eHC.eHn;
        if (view == aoVar.aSj()) {
            aoVar29 = this.eHC.eHn;
            aoVar29.azw();
            String str = view.getTag(w.h.tag_user_id) instanceof String ? (String) view.getTag(w.h.tag_user_id) : null;
            String str2 = view.getTag(w.h.tag_user_name) instanceof String ? (String) view.getTag(w.h.tag_user_name) : null;
            String str3 = view.getTag(w.h.tag_virtual_user_url) instanceof String ? (String) view.getTag(w.h.tag_virtual_user_url) : null;
            if (str3 != null) {
                if (this.eHC.checkUpIsLogin()) {
                    be.vP().c(this.eHC.getPageContext(), new String[]{str3});
                    return;
                }
                return;
            } else if (str != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.eHC.getPageContext().getPageActivity(), str, str2, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
                return;
            } else {
                return;
            }
        }
        aoVar2 = this.eHC.eHn;
        if (view != aoVar2.aSc()) {
            aoVar3 = this.eHC.eHn;
            if (view == aoVar3.aRY()) {
                aoVar25 = this.eHC.eHn;
                aoVar25.azw();
                subPbModel8 = this.eHC.eHl;
                if (subPbModel8.EX()) {
                    aoVar26 = this.eHC.eHn;
                    aoVar26.aRW();
                    return;
                }
                return;
            }
            aoVar4 = this.eHC.eHn;
            if (view != aoVar4.aSd()) {
                aoVar5 = this.eHC.eHn;
                if (view != aoVar5.aSe()) {
                    aoVar6 = this.eHC.eHn;
                    if (view != aoVar6.aSg()) {
                        aoVar7 = this.eHC.eHn;
                        if (aoVar7.aSh() != null) {
                            aoVar23 = this.eHC.eHn;
                            if (view == aoVar23.aSh().aPr()) {
                                TiebaStatic.log(new com.baidu.tbadk.core.util.au("c11739").r("obj_locate", 2));
                                aoVar24 = this.eHC.eHn;
                                aoVar24.azw();
                                if (this.eHC.checkUpIsLogin()) {
                                    subPbModel6 = this.eHC.eHl;
                                    if (subPbModel6.aSm() != null) {
                                        NewSubPbActivity newSubPbActivity = this.eHC;
                                        subPbModel7 = this.eHC.eHl;
                                        newSubPbActivity.h(subPbModel7.aSm().aNd());
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                        }
                        aoVar8 = this.eHC.eHn;
                        if (aoVar8.aSh() != null) {
                            aoVar21 = this.eHC.eHn;
                            if (view == aoVar21.aSh().aPw()) {
                                TiebaStatic.log(new com.baidu.tbadk.core.util.au("c11739").r("obj_locate", 1));
                                aoVar22 = this.eHC.eHn;
                                aoVar22.azw();
                                if (this.eHC.checkUpIsLogin()) {
                                    nVar4 = this.eHC.duY;
                                    nVar4.fT(null);
                                    bVar = this.eHC.eHz;
                                    if (bVar != null) {
                                        bVar2 = this.eHC.eHz;
                                        bVar2.aRG();
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                        }
                        aoVar9 = this.eHC.eHn;
                        if (aoVar9.aSh() != null) {
                            aoVar18 = this.eHC.eHn;
                            if (view == aoVar18.aSh().aPu()) {
                                aoVar19 = this.eHC.eHn;
                                aoVar19.azw();
                                SparseArray sparseArray = (SparseArray) view.getTag();
                                if (sparseArray != null) {
                                    aoVar20 = this.eHC.eHn;
                                    aoVar20.a(((Integer) sparseArray.get(w.h.tag_del_post_type)).intValue(), (String) sparseArray.get(w.h.tag_del_post_id), ((Integer) sparseArray.get(w.h.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(w.h.tag_del_post_is_self)).booleanValue());
                                    return;
                                }
                                return;
                            }
                        }
                        aoVar10 = this.eHC.eHn;
                        if (aoVar10.aSh() != null) {
                            aoVar16 = this.eHC.eHn;
                            if (view == aoVar16.aSh().aPs()) {
                                if (com.baidu.adp.lib.util.i.hj()) {
                                    aoVar17 = this.eHC.eHn;
                                    aoVar17.azw();
                                    if (!this.eHC.checkUpIsLogin()) {
                                        return;
                                    }
                                    this.eHC.bc(view);
                                    return;
                                }
                                this.eHC.showToast(w.l.network_not_available);
                                return;
                            }
                        }
                        aoVar11 = this.eHC.eHn;
                        if (aoVar11.aSh() != null) {
                            aoVar14 = this.eHC.eHn;
                            if (view == aoVar14.aSh().aPt()) {
                                TiebaStatic.log(new com.baidu.tbadk.core.util.au("c11739").r("obj_locate", 4));
                                if (!com.baidu.adp.lib.util.i.hj()) {
                                    this.eHC.showToast(w.l.network_not_available);
                                    return;
                                }
                                Object tag = view.getTag();
                                aoVar15 = this.eHC.eHn;
                                aoVar15.azw();
                                if (tag instanceof String) {
                                    subPbModel5 = this.eHC.eHl;
                                    String Db = subPbModel5.Db();
                                    if (this.eHC.checkUpIsLogin()) {
                                        this.eHC.oJ(Db);
                                        return;
                                    }
                                    return;
                                } else if (tag instanceof SparseArray) {
                                    SparseArray<Object> sparseArray2 = (SparseArray) tag;
                                    if ((sparseArray2.get(w.h.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray2.get(w.h.tag_user_mute_visible)).booleanValue()) {
                                        sparseArray2.put(w.h.tag_from, 0);
                                        this.eHC.d(sparseArray2);
                                        return;
                                    }
                                    return;
                                } else {
                                    return;
                                }
                            }
                        }
                        aoVar12 = this.eHC.eHn;
                        if (view != aoVar12.aSb()) {
                            aoVar13 = this.eHC.eHn;
                            if (view != aoVar13.aSg()) {
                                return;
                            }
                        }
                        if (this.eHC.checkUpIsLogin()) {
                            nVar = this.eHC.duY;
                            if (nVar.DD()) {
                                nVar3 = this.eHC.duY;
                                nVar3.DE();
                                return;
                            }
                            nVar2 = this.eHC.duY;
                            nVar2.fT(null);
                            return;
                        }
                        return;
                    }
                }
            }
            z = this.eHC.eHy;
            if (z) {
                this.eHC.eHy = false;
                return;
            }
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.eHC.getActivity());
            subPbModel = this.eHC.eHl;
            String threadID = subPbModel.getThreadID();
            subPbModel2 = this.eHC.eHl;
            PbActivityConfig createNormalCfg = pbActivityConfig.createNormalCfg(threadID, subPbModel2.Db(), "");
            subPbModel3 = this.eHC.eHl;
            if (!StringUtils.isNull(subPbModel3.aSF())) {
                subPbModel4 = this.eHC.eHl;
                createNormalCfg.setForumId(subPbModel4.aSF());
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
        } else if (this.eHC.checkUpIsLogin()) {
            aoVar27 = this.eHC.eHn;
            aoVar27.aRT();
            aoVar28 = this.eHC.eHn;
            aoVar28.aRU();
            nVar5 = this.eHC.duY;
            if (nVar5 != null) {
                nVar6 = this.eHC.duY;
                nVar6.DF();
                bVar3 = this.eHC.eHz;
                if (bVar3 != null) {
                    bVar4 = this.eHC.eHz;
                    bVar4.aRG();
                }
            }
        }
    }
}
