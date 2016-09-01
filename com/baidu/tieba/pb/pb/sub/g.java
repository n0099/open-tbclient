package com.baidu.tieba.pb.pb.sub;

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
import com.baidu.tbadk.core.util.bi;
import com.baidu.tbadk.core.util.bn;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements View.OnClickListener {
    final /* synthetic */ NewSubPbActivity evy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(NewSubPbActivity newSubPbActivity) {
        this.evy = newSubPbActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v10, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ag agVar;
        ag agVar2;
        ag agVar3;
        ag agVar4;
        ag agVar5;
        ag agVar6;
        ag agVar7;
        ag agVar8;
        ag agVar9;
        String str;
        String str2;
        String str3;
        ag agVar10;
        ag agVar11;
        ag agVar12;
        ag agVar13;
        ag agVar14;
        String str4;
        ag agVar15;
        ag agVar16;
        ag agVar17;
        com.baidu.tbadk.editortools.d.p pVar;
        com.baidu.tbadk.editortools.d.p pVar2;
        com.baidu.tbadk.editortools.d.p pVar3;
        ag agVar18;
        ag agVar19;
        ag agVar20;
        ax axVar;
        ax axVar2;
        ag agVar21;
        ag agVar22;
        ax axVar3;
        ag agVar23;
        ag agVar24;
        ag agVar25;
        ag agVar26;
        ag agVar27;
        ag agVar28;
        ag agVar29;
        ax axVar4;
        ax axVar5;
        ag agVar30;
        ag agVar31;
        ag agVar32;
        ag agVar33;
        boolean z;
        ax axVar6;
        ag agVar34;
        boolean hW;
        ag agVar35;
        ag agVar36;
        com.baidu.tbadk.editortools.d.p pVar4;
        ax axVar7;
        ax axVar8;
        ag agVar37;
        ax axVar9;
        ag agVar38;
        ag agVar39;
        if (view == null) {
            agVar39 = this.evy.evn;
            if (agVar39 == null) {
                return;
            }
        }
        agVar = this.evy.evn;
        if (view == agVar.aQr()) {
            agVar37 = this.evy.evn;
            agVar37.aAE();
            axVar9 = this.evy.evl;
            if (axVar9.Fa()) {
                agVar38 = this.evy.evn;
                agVar38.aQo();
                return;
            }
            return;
        }
        agVar2 = this.evy.evn;
        if (view == agVar2.aQv()) {
            MessageManager messageManager = MessageManager.getInstance();
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.evy.getActivity());
            axVar7 = this.evy.evl;
            String threadID = axVar7.getThreadID();
            axVar8 = this.evy.evl;
            messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig.createNormalCfg(threadID, axVar8.Dg(), "")));
            return;
        }
        if (view != null) {
            agVar35 = this.evy.evn;
            if (view == agVar35.aQp()) {
                agVar36 = this.evy.evn;
                agVar36.aAE();
                SparseArray sparseArray = (SparseArray) view.getTag();
                com.baidu.tieba.tbadkCore.data.q qVar = sparseArray.get(t.g.tag_load_sub_data) instanceof com.baidu.tieba.tbadkCore.data.q ? (com.baidu.tieba.tbadkCore.data.q) sparseArray.get(t.g.tag_load_sub_data) : null;
                View view2 = sparseArray.get(t.g.tag_load_sub_view) instanceof View ? (View) sparseArray.get(t.g.tag_load_sub_view) : null;
                SparseArray sparseArray2 = new SparseArray();
                sparseArray2.put(t.g.tag_load_sub_data, qVar);
                sparseArray2.put(t.g.tag_load_sub_view, view2);
                view.setTag(sparseArray2);
                if (this.evy.checkUpIsLogin()) {
                    pVar4 = this.evy.dtc;
                    pVar4.fJ(null);
                    return;
                }
                return;
            }
        }
        agVar3 = this.evy.evn;
        if (view == agVar3.abt()) {
            agVar30 = this.evy.evn;
            agVar30.aAE();
            agVar31 = this.evy.evn;
            if (agVar31.aQG() == null) {
                if (view != null && view.getTag() != null) {
                    SparseArray sparseArray3 = (SparseArray) view.getTag();
                    if (sparseArray3.get(t.g.tag_del_post_is_self) instanceof Boolean) {
                        z = ((Boolean) sparseArray3.get(t.g.tag_del_post_is_self)).booleanValue();
                        axVar6 = this.evy.evl;
                        boolean isMarked = axVar6.isMarked();
                        agVar34 = this.evy.evn;
                        hW = this.evy.hW(z);
                        agVar34.a(view, hW, isMarked);
                    }
                }
                z = false;
                axVar6 = this.evy.evl;
                boolean isMarked2 = axVar6.isMarked();
                agVar34 = this.evy.evn;
                hW = this.evy.hW(z);
                agVar34.a(view, hW, isMarked2);
            }
            agVar32 = this.evy.evn;
            if (agVar32.aQG() != null) {
                agVar33 = this.evy.evn;
                agVar33.aQG().GN();
                return;
            }
            return;
        }
        agVar4 = this.evy.evn;
        if (agVar4.aQG() != null) {
            agVar28 = this.evy.evn;
            if (view == agVar28.aQG().aOm()) {
                agVar29 = this.evy.evn;
                agVar29.aAE();
                if (this.evy.checkUpIsLogin()) {
                    axVar4 = this.evy.evl;
                    if (axVar4.aQK() != null) {
                        NewSubPbActivity newSubPbActivity = this.evy;
                        axVar5 = this.evy.evl;
                        newSubPbActivity.d(axVar5.aQK().aMh());
                        return;
                    }
                    return;
                }
                return;
            }
        }
        agVar5 = this.evy.evn;
        if (agVar5.aQG() != null) {
            agVar25 = this.evy.evn;
            if (view == agVar25.aQG().aOp()) {
                agVar26 = this.evy.evn;
                agVar26.aAE();
                SparseArray sparseArray4 = (SparseArray) view.getTag();
                if (sparseArray4 != null) {
                    agVar27 = this.evy.evn;
                    agVar27.a(((Integer) sparseArray4.get(t.g.tag_del_post_type)).intValue(), (String) sparseArray4.get(t.g.tag_del_post_id), ((Integer) sparseArray4.get(t.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray4.get(t.g.tag_del_post_is_self)).booleanValue());
                    return;
                }
                return;
            }
        }
        agVar6 = this.evy.evn;
        if (agVar6.aQG() != null) {
            agVar23 = this.evy.evn;
            if (view == agVar23.aQG().aOn()) {
                agVar24 = this.evy.evn;
                agVar24.aAE();
                if (!this.evy.checkUpIsLogin()) {
                    return;
                }
                this.evy.ba(view);
                return;
            }
        }
        agVar7 = this.evy.evn;
        if (agVar7.aQG() != null) {
            agVar21 = this.evy.evn;
            if (view == agVar21.aQG().aOo()) {
                Object tag = view.getTag();
                agVar22 = this.evy.evn;
                agVar22.aAE();
                if (tag instanceof String) {
                    axVar3 = this.evy.evl;
                    String Dg = axVar3.Dg();
                    if (this.evy.checkUpIsLogin()) {
                        this.evy.oO(Dg);
                        return;
                    }
                    return;
                } else if (tag instanceof SparseArray) {
                    SparseArray<Object> sparseArray5 = (SparseArray) tag;
                    if ((sparseArray5.get(t.g.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray5.get(t.g.tag_user_mute_visible)).booleanValue()) {
                        sparseArray5.put(t.g.tag_from, 0);
                        this.evy.d(sparseArray5);
                        return;
                    }
                    return;
                } else {
                    return;
                }
            }
        }
        agVar8 = this.evy.evn;
        if (view != agVar8.aQx()) {
            agVar10 = this.evy.evn;
            if (view != agVar10.getUserNameView()) {
                agVar11 = this.evy.evn;
                if (view != agVar11.aQy()) {
                    agVar12 = this.evy.evn;
                    if (view != agVar12.aQF()) {
                        agVar13 = this.evy.evn;
                        if (view != agVar13.aQz()) {
                            agVar15 = this.evy.evn;
                            if (view != agVar15.aQA()) {
                                agVar16 = this.evy.evn;
                                if (view != agVar16.aQB()) {
                                    agVar17 = this.evy.evn;
                                    if (view != agVar17.aQu()) {
                                        agVar18 = this.evy.evn;
                                        if (view != agVar18.aQE()) {
                                            agVar19 = this.evy.evn;
                                            if (view == agVar19.aQD()) {
                                                axVar = this.evy.evl;
                                                if (axVar != null) {
                                                    NewSubPbActivity newSubPbActivity2 = this.evy;
                                                    axVar2 = this.evy.evl;
                                                    newSubPbActivity2.pf(axVar2.Dg());
                                                    return;
                                                }
                                                return;
                                            }
                                            agVar20 = this.evy.evn;
                                            if (view == agVar20.aQC()) {
                                                String string = TbadkCoreApplication.m9getInst().getString(t.j.tail_web_view_title);
                                                String string2 = com.baidu.tbadk.core.sharedPref.b.tS().getString("tail_link", "");
                                                if (!StringUtils.isNull(string2)) {
                                                    com.baidu.tbadk.browser.f.a(view.getContext(), string, string2, true, true, true);
                                                    return;
                                                }
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                    if (this.evy.checkUpIsLogin()) {
                                        pVar = this.evy.dtc;
                                        if (pVar.DN()) {
                                            pVar3 = this.evy.dtc;
                                            pVar3.DO();
                                            return;
                                        }
                                        pVar2 = this.evy.dtc;
                                        pVar2.fJ(null);
                                        return;
                                    }
                                    return;
                                }
                                String str5 = view.getTag() != null ? (String) view.getTag() : null;
                                if (bn.al(this.evy.getActivity()) && str5 != null) {
                                    bi.vx().c(this.evy.getPageContext(), new String[]{str5});
                                    return;
                                }
                                return;
                            }
                        }
                        agVar14 = this.evy.evn;
                        agVar14.aAE();
                        if (view.getTag(t.g.tag_user_id) instanceof String) {
                            str4 = NewSubPbActivity.euP;
                            com.baidu.tbadk.browser.f.a(this.evy.getPageContext().getPageActivity(), TbadkCoreApplication.m9getInst().getString(t.j.user_icon_intro), String.valueOf(str4) + "?user_id=" + ((String) view.getTag(t.g.tag_user_id)) + "?st_type=pb_user_icon", true, false, true);
                            return;
                        }
                        return;
                    }
                }
            }
        }
        agVar9 = this.evy.evn;
        agVar9.aAE();
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
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.evy.getPageContext().getPageActivity(), str3, str2, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
        }
    }
}
