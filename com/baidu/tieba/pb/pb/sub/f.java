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
    final /* synthetic */ NewSubPbActivity ejr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(NewSubPbActivity newSubPbActivity) {
        this.ejr = newSubPbActivity;
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
        boolean hA;
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
            afVar38 = this.ejr.ejg;
            if (afVar38 == null) {
                return;
            }
        }
        afVar = this.ejr.ejg;
        if (view == afVar.aLB()) {
            afVar36 = this.ejr.ejg;
            afVar36.avR();
            awVar9 = this.ejr.eje;
            if (awVar9.DG()) {
                afVar37 = this.ejr.ejg;
                afVar37.aLy();
                return;
            }
            return;
        }
        afVar2 = this.ejr.ejg;
        if (view == afVar2.aLF()) {
            MessageManager messageManager = MessageManager.getInstance();
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.ejr.getActivity());
            awVar7 = this.ejr.eje;
            String threadID = awVar7.getThreadID();
            awVar8 = this.ejr.eje;
            messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig.createNormalCfg(threadID, awVar8.BL(), "")));
            return;
        }
        if (view != null) {
            afVar34 = this.ejr.ejg;
            if (view == afVar34.aLz()) {
                afVar35 = this.ejr.ejg;
                afVar35.avR();
                SparseArray sparseArray = (SparseArray) view.getTag();
                com.baidu.tieba.tbadkCore.data.s sVar = sparseArray.get(u.g.tag_load_sub_data) instanceof com.baidu.tieba.tbadkCore.data.s ? (com.baidu.tieba.tbadkCore.data.s) sparseArray.get(u.g.tag_load_sub_data) : null;
                View view2 = sparseArray.get(u.g.tag_load_sub_view) instanceof View ? (View) sparseArray.get(u.g.tag_load_sub_view) : null;
                SparseArray sparseArray2 = new SparseArray();
                sparseArray2.put(u.g.tag_load_sub_data, sVar);
                sparseArray2.put(u.g.tag_load_sub_view, view2);
                view.setTag(sparseArray2);
                if (this.ejr.checkUpIsLogin()) {
                    pVar4 = this.ejr.dhw;
                    pVar4.fG(null);
                    return;
                }
                return;
            }
        }
        afVar3 = this.ejr.ejg;
        if (view == afVar3.Wx()) {
            afVar29 = this.ejr.ejg;
            afVar29.avR();
            afVar30 = this.ejr.ejg;
            if (afVar30.aLP() == null) {
                if (view != null && view.getTag() != null) {
                    SparseArray sparseArray3 = (SparseArray) view.getTag();
                    if (sparseArray3.get(u.g.tag_del_post_is_self) instanceof Boolean) {
                        z = ((Boolean) sparseArray3.get(u.g.tag_del_post_is_self)).booleanValue();
                        awVar6 = this.ejr.eje;
                        boolean isMarked = awVar6.isMarked();
                        afVar33 = this.ejr.ejg;
                        hA = this.ejr.hA(z);
                        afVar33.a(view, hA, isMarked);
                    }
                }
                z = false;
                awVar6 = this.ejr.eje;
                boolean isMarked2 = awVar6.isMarked();
                afVar33 = this.ejr.ejg;
                hA = this.ejr.hA(z);
                afVar33.a(view, hA, isMarked2);
            }
            afVar31 = this.ejr.ejg;
            if (afVar31.aLP() != null) {
                afVar32 = this.ejr.ejg;
                afVar32.aLP().Ft();
                return;
            }
            return;
        }
        afVar4 = this.ejr.ejg;
        if (afVar4.aLP() != null) {
            afVar27 = this.ejr.ejg;
            if (view == afVar27.aLP().aJv()) {
                afVar28 = this.ejr.ejg;
                afVar28.avR();
                if (this.ejr.checkUpIsLogin()) {
                    awVar4 = this.ejr.eje;
                    if (awVar4.aLS() != null) {
                        NewSubPbActivity newSubPbActivity = this.ejr;
                        awVar5 = this.ejr.eje;
                        newSubPbActivity.d(awVar5.aLS().aHp());
                        return;
                    }
                    return;
                }
                return;
            }
        }
        afVar5 = this.ejr.ejg;
        if (afVar5.aLP() != null) {
            afVar24 = this.ejr.ejg;
            if (view == afVar24.aLP().aJy()) {
                afVar25 = this.ejr.ejg;
                afVar25.avR();
                SparseArray sparseArray4 = (SparseArray) view.getTag();
                if (sparseArray4 != null) {
                    afVar26 = this.ejr.ejg;
                    afVar26.a(((Integer) sparseArray4.get(u.g.tag_del_post_type)).intValue(), (String) sparseArray4.get(u.g.tag_del_post_id), ((Integer) sparseArray4.get(u.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray4.get(u.g.tag_del_post_is_self)).booleanValue());
                    return;
                }
                return;
            }
        }
        afVar6 = this.ejr.ejg;
        if (afVar6.aLP() != null) {
            afVar22 = this.ejr.ejg;
            if (view == afVar22.aLP().aJw()) {
                afVar23 = this.ejr.ejg;
                afVar23.avR();
                if (!this.ejr.checkUpIsLogin()) {
                    return;
                }
                this.ejr.ba(view);
                return;
            }
        }
        afVar7 = this.ejr.ejg;
        if (afVar7.aLP() != null) {
            afVar20 = this.ejr.ejg;
            if (view == afVar20.aLP().aJx()) {
                Object tag = view.getTag();
                afVar21 = this.ejr.ejg;
                afVar21.avR();
                if (tag instanceof String) {
                    awVar3 = this.ejr.eje;
                    String BL = awVar3.BL();
                    if (this.ejr.checkUpIsLogin()) {
                        this.ejr.oe(BL);
                        return;
                    }
                    return;
                } else if (tag instanceof SparseArray) {
                    SparseArray<Object> sparseArray5 = (SparseArray) tag;
                    if ((sparseArray5.get(u.g.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray5.get(u.g.tag_user_mute_visible)).booleanValue()) {
                        sparseArray5.put(u.g.tag_from, 0);
                        this.ejr.d(sparseArray5);
                        return;
                    }
                    return;
                } else {
                    return;
                }
            }
        }
        afVar8 = this.ejr.ejg;
        if (view != afVar8.aLH()) {
            afVar10 = this.ejr.ejg;
            if (view != afVar10.getUserNameView()) {
                afVar11 = this.ejr.ejg;
                if (view != afVar11.aLI()) {
                    afVar12 = this.ejr.ejg;
                    if (view != afVar12.aLJ()) {
                        afVar14 = this.ejr.ejg;
                        if (view != afVar14.aLK()) {
                            afVar15 = this.ejr.ejg;
                            if (view != afVar15.aLL()) {
                                afVar16 = this.ejr.ejg;
                                if (view != afVar16.aLE()) {
                                    afVar17 = this.ejr.ejg;
                                    if (view != afVar17.aLO()) {
                                        afVar18 = this.ejr.ejg;
                                        if (view == afVar18.aLN()) {
                                            awVar = this.ejr.eje;
                                            if (awVar != null) {
                                                NewSubPbActivity newSubPbActivity2 = this.ejr;
                                                awVar2 = this.ejr.eje;
                                                newSubPbActivity2.ow(awVar2.BL());
                                                return;
                                            }
                                            return;
                                        }
                                        afVar19 = this.ejr.ejg;
                                        if (view == afVar19.aLM()) {
                                            String string = TbadkCoreApplication.m10getInst().getString(u.j.tail_web_view_title);
                                            String string2 = com.baidu.tbadk.core.sharedPref.b.sN().getString("tail_link", "");
                                            if (!StringUtils.isNull(string2)) {
                                                com.baidu.tbadk.browser.f.a(view.getContext(), string, string2, true, true, true);
                                                return;
                                            }
                                            return;
                                        }
                                        return;
                                    }
                                }
                                if (this.ejr.checkUpIsLogin()) {
                                    pVar = this.ejr.dhw;
                                    if (pVar.Cs()) {
                                        pVar3 = this.ejr.dhw;
                                        pVar3.Ct();
                                        return;
                                    }
                                    pVar2 = this.ejr.dhw;
                                    pVar2.fG(null);
                                    return;
                                }
                                return;
                            }
                            String str5 = view.getTag() != null ? (String) view.getTag() : null;
                            if (bn.ab(this.ejr.getActivity()) && str5 != null) {
                                bi.us().c(this.ejr.getPageContext(), new String[]{str5});
                                return;
                            }
                            return;
                        }
                    }
                    afVar13 = this.ejr.ejg;
                    afVar13.avR();
                    if (view.getTag(u.g.tag_user_id) instanceof String) {
                        str4 = NewSubPbActivity.eiI;
                        com.baidu.tbadk.browser.f.a(this.ejr.getPageContext().getPageActivity(), TbadkCoreApplication.m10getInst().getString(u.j.user_icon_intro), String.valueOf(str4) + "?user_id=" + ((String) view.getTag(u.g.tag_user_id)) + "?st_type=pb_user_icon", true, false, true);
                        return;
                    }
                    return;
                }
            }
        }
        afVar9 = this.ejr.ejg;
        afVar9.avR();
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
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.ejr.getPageContext().getPageActivity(), str3, str2, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
        }
    }
}
