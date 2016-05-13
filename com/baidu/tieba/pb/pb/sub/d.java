package com.baidu.tieba.pb.pb.sub;

import android.app.Activity;
import android.util.SparseArray;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.util.bl;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ NewSubPbActivity dqn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(NewSubPbActivity newSubPbActivity) {
        this.dqn = newSubPbActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v9, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        y yVar;
        y yVar2;
        y yVar3;
        y yVar4;
        y yVar5;
        y yVar6;
        y yVar7;
        y yVar8;
        y yVar9;
        String str;
        String str2;
        String str3;
        y yVar10;
        y yVar11;
        y yVar12;
        y yVar13;
        String str4;
        y yVar14;
        y yVar15;
        y yVar16;
        com.baidu.tbadk.editortools.d.p pVar;
        com.baidu.tbadk.editortools.d.p pVar2;
        com.baidu.tbadk.editortools.d.p pVar3;
        y yVar17;
        y yVar18;
        y yVar19;
        ap apVar;
        ap apVar2;
        y yVar20;
        y yVar21;
        ap apVar3;
        y yVar22;
        y yVar23;
        y yVar24;
        y yVar25;
        y yVar26;
        y yVar27;
        y yVar28;
        ap apVar4;
        ap apVar5;
        y yVar29;
        y yVar30;
        y yVar31;
        y yVar32;
        boolean z;
        ap apVar6;
        y yVar33;
        boolean gw;
        y yVar34;
        y yVar35;
        com.baidu.tbadk.editortools.d.p pVar4;
        ap apVar7;
        ap apVar8;
        y yVar36;
        ap apVar9;
        y yVar37;
        y yVar38;
        if (view == null) {
            yVar38 = this.dqn.dqe;
            if (yVar38 == null) {
                return;
            }
        }
        yVar = this.dqn.dqe;
        if (view == yVar.aAa()) {
            yVar36 = this.dqn.dqe;
            yVar36.amT();
            apVar9 = this.dqn.dqc;
            if (apVar9.Dz()) {
                yVar37 = this.dqn.dqe;
                yVar37.azX();
                return;
            }
            return;
        }
        yVar2 = this.dqn.dqe;
        if (view == yVar2.aAe()) {
            MessageManager messageManager = MessageManager.getInstance();
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.dqn.getActivity());
            apVar7 = this.dqn.dqc;
            String threadID = apVar7.getThreadID();
            apVar8 = this.dqn.dqc;
            messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig.createNormalCfg(threadID, apVar8.BC(), "")));
            return;
        }
        if (view != null) {
            yVar34 = this.dqn.dqe;
            if (view == yVar34.azY()) {
                yVar35 = this.dqn.dqe;
                yVar35.amT();
                SparseArray sparseArray = (SparseArray) view.getTag();
                com.baidu.tieba.tbadkCore.data.s sVar = sparseArray.get(t.g.tag_load_sub_data) instanceof com.baidu.tieba.tbadkCore.data.s ? (com.baidu.tieba.tbadkCore.data.s) sparseArray.get(t.g.tag_load_sub_data) : null;
                View view2 = sparseArray.get(t.g.tag_load_sub_view) instanceof View ? (View) sparseArray.get(t.g.tag_load_sub_view) : null;
                SparseArray sparseArray2 = new SparseArray();
                sparseArray2.put(t.g.tag_load_sub_data, sVar);
                sparseArray2.put(t.g.tag_load_sub_view, view2);
                view.setTag(sparseArray2);
                if (this.dqn.checkUpIsLogin()) {
                    pVar4 = this.dqn.czd;
                    pVar4.fC(null);
                    return;
                }
                return;
            }
        }
        yVar3 = this.dqn.dqe;
        if (view == yVar3.QJ()) {
            yVar29 = this.dqn.dqe;
            yVar29.amT();
            yVar30 = this.dqn.dqe;
            if (yVar30.aAo() == null) {
                if (view != null && view.getTag() != null) {
                    SparseArray sparseArray3 = (SparseArray) view.getTag();
                    if (sparseArray3.get(t.g.tag_del_post_is_self) instanceof Boolean) {
                        z = ((Boolean) sparseArray3.get(t.g.tag_del_post_is_self)).booleanValue();
                        apVar6 = this.dqn.dqc;
                        boolean isMarked = apVar6.isMarked();
                        yVar33 = this.dqn.dqe;
                        gw = this.dqn.gw(z);
                        yVar33.a(view, gw, isMarked);
                    }
                }
                z = false;
                apVar6 = this.dqn.dqc;
                boolean isMarked2 = apVar6.isMarked();
                yVar33 = this.dqn.dqe;
                gw = this.dqn.gw(z);
                yVar33.a(view, gw, isMarked2);
            }
            yVar31 = this.dqn.dqe;
            if (yVar31.aAo() != null) {
                yVar32 = this.dqn.dqe;
                yVar32.aAo().Fk();
                return;
            }
            return;
        }
        yVar4 = this.dqn.dqe;
        if (yVar4.aAo() != null) {
            yVar27 = this.dqn.dqe;
            if (view == yVar27.aAo().ayb()) {
                yVar28 = this.dqn.dqe;
                yVar28.amT();
                if (this.dqn.checkUpIsLogin()) {
                    apVar4 = this.dqn.dqc;
                    if (apVar4.aAq() != null) {
                        NewSubPbActivity newSubPbActivity = this.dqn;
                        apVar5 = this.dqn.dqc;
                        newSubPbActivity.d(apVar5.aAq().avR());
                        return;
                    }
                    return;
                }
                return;
            }
        }
        yVar5 = this.dqn.dqe;
        if (yVar5.aAo() != null) {
            yVar24 = this.dqn.dqe;
            if (view == yVar24.aAo().aye()) {
                yVar25 = this.dqn.dqe;
                yVar25.amT();
                SparseArray sparseArray4 = (SparseArray) view.getTag();
                if (sparseArray4 != null) {
                    yVar26 = this.dqn.dqe;
                    yVar26.a(((Integer) sparseArray4.get(t.g.tag_del_post_type)).intValue(), (String) sparseArray4.get(t.g.tag_del_post_id), ((Integer) sparseArray4.get(t.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray4.get(t.g.tag_del_post_is_self)).booleanValue());
                    return;
                }
                return;
            }
        }
        yVar6 = this.dqn.dqe;
        if (yVar6.aAo() != null) {
            yVar22 = this.dqn.dqe;
            if (view == yVar22.aAo().ayc()) {
                yVar23 = this.dqn.dqe;
                yVar23.amT();
                if (!this.dqn.checkUpIsLogin()) {
                    return;
                }
                this.dqn.aS(view);
                return;
            }
        }
        yVar7 = this.dqn.dqe;
        if (yVar7.aAo() != null) {
            yVar20 = this.dqn.dqe;
            if (view == yVar20.aAo().ayd()) {
                Object tag = view.getTag();
                yVar21 = this.dqn.dqe;
                yVar21.amT();
                if (tag instanceof String) {
                    apVar3 = this.dqn.dqc;
                    String BC = apVar3.BC();
                    if (this.dqn.checkUpIsLogin()) {
                        this.dqn.lR(BC);
                        return;
                    }
                    return;
                } else if (tag instanceof SparseArray) {
                    SparseArray<Object> sparseArray5 = (SparseArray) tag;
                    if ((sparseArray5.get(t.g.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray5.get(t.g.tag_user_mute_visible)).booleanValue()) {
                        sparseArray5.put(t.g.tag_from, 0);
                        this.dqn.d(sparseArray5);
                        return;
                    }
                    return;
                } else {
                    return;
                }
            }
        }
        yVar8 = this.dqn.dqe;
        if (view != yVar8.aAg()) {
            yVar10 = this.dqn.dqe;
            if (view != yVar10.getUserNameView()) {
                yVar11 = this.dqn.dqe;
                if (view != yVar11.aAh()) {
                    yVar12 = this.dqn.dqe;
                    if (view != yVar12.aAi()) {
                        yVar14 = this.dqn.dqe;
                        if (view != yVar14.aAj()) {
                            yVar15 = this.dqn.dqe;
                            if (view != yVar15.aAk()) {
                                yVar16 = this.dqn.dqe;
                                if (view != yVar16.aAd()) {
                                    yVar17 = this.dqn.dqe;
                                    if (view != yVar17.aAn()) {
                                        yVar18 = this.dqn.dqe;
                                        if (view == yVar18.aAm()) {
                                            apVar = this.dqn.dqc;
                                            if (apVar != null) {
                                                NewSubPbActivity newSubPbActivity2 = this.dqn;
                                                apVar2 = this.dqn.dqc;
                                                newSubPbActivity2.mi(apVar2.BC());
                                                return;
                                            }
                                            return;
                                        }
                                        yVar19 = this.dqn.dqe;
                                        if (view == yVar19.aAl()) {
                                            String string = TbadkCoreApplication.m11getInst().getString(t.j.tail_web_view_title);
                                            String string2 = com.baidu.tbadk.core.sharedPref.b.sR().getString("tail_link", "");
                                            if (!StringUtils.isNull(string2)) {
                                                com.baidu.tbadk.browser.f.a(view.getContext(), string, string2, true, true, true);
                                                return;
                                            }
                                            return;
                                        }
                                        return;
                                    }
                                }
                                if (this.dqn.checkUpIsLogin()) {
                                    pVar = this.dqn.czd;
                                    if (pVar.Cl()) {
                                        pVar3 = this.dqn.czd;
                                        pVar3.Cm();
                                        return;
                                    }
                                    pVar2 = this.dqn.czd;
                                    pVar2.fC(null);
                                    return;
                                }
                                return;
                            }
                            String str5 = view.getTag() != null ? (String) view.getTag() : null;
                            if (bl.ac(this.dqn.getActivity()) && str5 != null) {
                                bg.ut().c(this.dqn.getPageContext(), new String[]{str5});
                                return;
                            }
                            return;
                        }
                    }
                    yVar13 = this.dqn.dqe;
                    yVar13.amT();
                    Activity pageActivity = this.dqn.getPageContext().getPageActivity();
                    String string3 = this.dqn.getPageContext().getString(t.j.user_icon_intro);
                    str4 = NewSubPbActivity.dpI;
                    com.baidu.tbadk.browser.f.a(pageActivity, string3, String.valueOf(str4) + "?st_type=pb_user_icon", true, false, false);
                    return;
                }
            }
        }
        yVar9 = this.dqn.dqe;
        yVar9.amT();
        if (view instanceof HeadImageView) {
            String userId = ((HeadImageView) view).getUserId();
            str2 = ((HeadImageView) view).getUserName();
            str3 = userId;
        } else {
            if (view.getTag(t.g.tag_user_id) instanceof String) {
                str = (String) view.getTag(t.g.tag_user_id);
            } else {
                str = view.getTag() instanceof String ? (String) view.getTag() : null;
            }
            if (view.getTag(t.g.tag_user_name) instanceof String) {
                str2 = (String) view.getTag(t.g.tag_user_name);
                str3 = str;
            } else {
                str2 = null;
                str3 = str;
            }
        }
        if (str3 != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.dqn.getPageContext().getPageActivity(), str3, str2, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
        }
    }
}
