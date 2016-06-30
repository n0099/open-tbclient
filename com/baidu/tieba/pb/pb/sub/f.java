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
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ NewSubPbActivity dWP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(NewSubPbActivity newSubPbActivity) {
        this.dWP = newSubPbActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v10, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        af afVar;
        af afVar2;
        af afVar3;
        af afVar4;
        af afVar5;
        af afVar6;
        af afVar7;
        af afVar8;
        af afVar9;
        String str;
        String str2;
        String str3;
        af afVar10;
        af afVar11;
        af afVar12;
        af afVar13;
        String str4;
        af afVar14;
        af afVar15;
        af afVar16;
        com.baidu.tbadk.editortools.d.p pVar;
        com.baidu.tbadk.editortools.d.p pVar2;
        com.baidu.tbadk.editortools.d.p pVar3;
        af afVar17;
        af afVar18;
        af afVar19;
        aw awVar;
        aw awVar2;
        af afVar20;
        af afVar21;
        aw awVar3;
        af afVar22;
        af afVar23;
        af afVar24;
        af afVar25;
        af afVar26;
        af afVar27;
        af afVar28;
        aw awVar4;
        aw awVar5;
        af afVar29;
        af afVar30;
        af afVar31;
        af afVar32;
        boolean z;
        aw awVar6;
        af afVar33;
        boolean hp;
        af afVar34;
        af afVar35;
        com.baidu.tbadk.editortools.d.p pVar4;
        aw awVar7;
        aw awVar8;
        af afVar36;
        aw awVar9;
        af afVar37;
        af afVar38;
        if (view == null) {
            afVar38 = this.dWP.dWE;
            if (afVar38 == null) {
                return;
            }
        }
        afVar = this.dWP.dWE;
        if (view == afVar.aIq()) {
            afVar36 = this.dWP.dWE;
            afVar36.avf();
            awVar9 = this.dWP.dWC;
            if (awVar9.DH()) {
                afVar37 = this.dWP.dWE;
                afVar37.aIn();
                return;
            }
            return;
        }
        afVar2 = this.dWP.dWE;
        if (view == afVar2.aIu()) {
            MessageManager messageManager = MessageManager.getInstance();
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.dWP.getActivity());
            awVar7 = this.dWP.dWC;
            String threadID = awVar7.getThreadID();
            awVar8 = this.dWP.dWC;
            messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig.createNormalCfg(threadID, awVar8.BL(), "")));
            return;
        }
        if (view != null) {
            afVar34 = this.dWP.dWE;
            if (view == afVar34.aIo()) {
                afVar35 = this.dWP.dWE;
                afVar35.avf();
                SparseArray sparseArray = (SparseArray) view.getTag();
                com.baidu.tieba.tbadkCore.data.s sVar = sparseArray.get(u.g.tag_load_sub_data) instanceof com.baidu.tieba.tbadkCore.data.s ? (com.baidu.tieba.tbadkCore.data.s) sparseArray.get(u.g.tag_load_sub_data) : null;
                View view2 = sparseArray.get(u.g.tag_load_sub_view) instanceof View ? (View) sparseArray.get(u.g.tag_load_sub_view) : null;
                SparseArray sparseArray2 = new SparseArray();
                sparseArray2.put(u.g.tag_load_sub_data, sVar);
                sparseArray2.put(u.g.tag_load_sub_view, view2);
                view.setTag(sparseArray2);
                if (this.dWP.checkUpIsLogin()) {
                    pVar4 = this.dWP.deA;
                    pVar4.fI(null);
                    return;
                }
                return;
            }
        }
        afVar3 = this.dWP.dWE;
        if (view == afVar3.Wg()) {
            afVar29 = this.dWP.dWE;
            afVar29.avf();
            afVar30 = this.dWP.dWE;
            if (afVar30.aIE() == null) {
                if (view != null && view.getTag() != null) {
                    SparseArray sparseArray3 = (SparseArray) view.getTag();
                    if (sparseArray3.get(u.g.tag_del_post_is_self) instanceof Boolean) {
                        z = ((Boolean) sparseArray3.get(u.g.tag_del_post_is_self)).booleanValue();
                        awVar6 = this.dWP.dWC;
                        boolean isMarked = awVar6.isMarked();
                        afVar33 = this.dWP.dWE;
                        hp = this.dWP.hp(z);
                        afVar33.a(view, hp, isMarked);
                    }
                }
                z = false;
                awVar6 = this.dWP.dWC;
                boolean isMarked2 = awVar6.isMarked();
                afVar33 = this.dWP.dWE;
                hp = this.dWP.hp(z);
                afVar33.a(view, hp, isMarked2);
            }
            afVar31 = this.dWP.dWE;
            if (afVar31.aIE() != null) {
                afVar32 = this.dWP.dWE;
                afVar32.aIE().Fs();
                return;
            }
            return;
        }
        afVar4 = this.dWP.dWE;
        if (afVar4.aIE() != null) {
            afVar27 = this.dWP.dWE;
            if (view == afVar27.aIE().aGk()) {
                afVar28 = this.dWP.dWE;
                afVar28.avf();
                if (this.dWP.checkUpIsLogin()) {
                    awVar4 = this.dWP.dWC;
                    if (awVar4.aIH() != null) {
                        NewSubPbActivity newSubPbActivity = this.dWP;
                        awVar5 = this.dWP.dWC;
                        newSubPbActivity.c(awVar5.aIH().aEe());
                        return;
                    }
                    return;
                }
                return;
            }
        }
        afVar5 = this.dWP.dWE;
        if (afVar5.aIE() != null) {
            afVar24 = this.dWP.dWE;
            if (view == afVar24.aIE().aGn()) {
                afVar25 = this.dWP.dWE;
                afVar25.avf();
                SparseArray sparseArray4 = (SparseArray) view.getTag();
                if (sparseArray4 != null) {
                    afVar26 = this.dWP.dWE;
                    afVar26.a(((Integer) sparseArray4.get(u.g.tag_del_post_type)).intValue(), (String) sparseArray4.get(u.g.tag_del_post_id), ((Integer) sparseArray4.get(u.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray4.get(u.g.tag_del_post_is_self)).booleanValue());
                    return;
                }
                return;
            }
        }
        afVar6 = this.dWP.dWE;
        if (afVar6.aIE() != null) {
            afVar22 = this.dWP.dWE;
            if (view == afVar22.aIE().aGl()) {
                afVar23 = this.dWP.dWE;
                afVar23.avf();
                if (!this.dWP.checkUpIsLogin()) {
                    return;
                }
                this.dWP.ba(view);
                return;
            }
        }
        afVar7 = this.dWP.dWE;
        if (afVar7.aIE() != null) {
            afVar20 = this.dWP.dWE;
            if (view == afVar20.aIE().aGm()) {
                Object tag = view.getTag();
                afVar21 = this.dWP.dWE;
                afVar21.avf();
                if (tag instanceof String) {
                    awVar3 = this.dWP.dWC;
                    String BL = awVar3.BL();
                    if (this.dWP.checkUpIsLogin()) {
                        this.dWP.ns(BL);
                        return;
                    }
                    return;
                } else if (tag instanceof SparseArray) {
                    SparseArray<Object> sparseArray5 = (SparseArray) tag;
                    if ((sparseArray5.get(u.g.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray5.get(u.g.tag_user_mute_visible)).booleanValue()) {
                        sparseArray5.put(u.g.tag_from, 0);
                        this.dWP.d(sparseArray5);
                        return;
                    }
                    return;
                } else {
                    return;
                }
            }
        }
        afVar8 = this.dWP.dWE;
        if (view != afVar8.aIw()) {
            afVar10 = this.dWP.dWE;
            if (view != afVar10.getUserNameView()) {
                afVar11 = this.dWP.dWE;
                if (view != afVar11.aIx()) {
                    afVar12 = this.dWP.dWE;
                    if (view != afVar12.aIy()) {
                        afVar14 = this.dWP.dWE;
                        if (view != afVar14.aIz()) {
                            afVar15 = this.dWP.dWE;
                            if (view != afVar15.aIA()) {
                                afVar16 = this.dWP.dWE;
                                if (view != afVar16.aIt()) {
                                    afVar17 = this.dWP.dWE;
                                    if (view != afVar17.aID()) {
                                        afVar18 = this.dWP.dWE;
                                        if (view == afVar18.aIC()) {
                                            awVar = this.dWP.dWC;
                                            if (awVar != null) {
                                                NewSubPbActivity newSubPbActivity2 = this.dWP;
                                                awVar2 = this.dWP.dWC;
                                                newSubPbActivity2.nJ(awVar2.BL());
                                                return;
                                            }
                                            return;
                                        }
                                        afVar19 = this.dWP.dWE;
                                        if (view == afVar19.aIB()) {
                                            String string = TbadkCoreApplication.m9getInst().getString(u.j.tail_web_view_title);
                                            String string2 = com.baidu.tbadk.core.sharedPref.b.sO().getString("tail_link", "");
                                            if (!StringUtils.isNull(string2)) {
                                                com.baidu.tbadk.browser.f.a(view.getContext(), string, string2, true, true, true);
                                                return;
                                            }
                                            return;
                                        }
                                        return;
                                    }
                                }
                                if (this.dWP.checkUpIsLogin()) {
                                    pVar = this.dWP.deA;
                                    if (pVar.Ct()) {
                                        pVar3 = this.dWP.deA;
                                        pVar3.Cu();
                                        return;
                                    }
                                    pVar2 = this.dWP.deA;
                                    pVar2.fI(null);
                                    return;
                                }
                                return;
                            }
                            String str5 = view.getTag() != null ? (String) view.getTag() : null;
                            if (bn.ab(this.dWP.getActivity()) && str5 != null) {
                                bi.us().c(this.dWP.getPageContext(), new String[]{str5});
                                return;
                            }
                            return;
                        }
                    }
                    afVar13 = this.dWP.dWE;
                    afVar13.avf();
                    if (view.getTag(u.g.tag_user_id) instanceof String) {
                        str4 = NewSubPbActivity.dWf;
                        com.baidu.tbadk.browser.f.a(this.dWP.getPageContext().getPageActivity(), TbadkCoreApplication.m9getInst().getString(u.j.user_icon_intro), String.valueOf(str4) + "?user_id=" + ((String) view.getTag(u.g.tag_user_id)) + "?st_type=pb_user_icon", true, false, true);
                        return;
                    }
                    return;
                }
            }
        }
        afVar9 = this.dWP.dWE;
        afVar9.avf();
        if (view instanceof HeadImageView) {
            String userId = ((HeadImageView) view).getUserId();
            str2 = ((HeadImageView) view).getUserName();
            str3 = userId;
        } else {
            if (view.getTag(u.g.tag_user_id) instanceof String) {
                str = (String) view.getTag(u.g.tag_user_id);
            } else {
                str = view.getTag() instanceof String ? (String) view.getTag() : null;
            }
            if (view.getTag(u.g.tag_user_name) instanceof String) {
                str2 = (String) view.getTag(u.g.tag_user_name);
                str3 = str;
            } else {
                str2 = null;
                str3 = str;
            }
        }
        if (str3 != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.dWP.getPageContext().getPageActivity(), str3, str2, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
        }
    }
}
