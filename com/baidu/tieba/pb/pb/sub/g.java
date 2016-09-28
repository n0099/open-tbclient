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
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.core.util.bm;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements View.OnClickListener {
    final /* synthetic */ NewSubPbActivity exF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(NewSubPbActivity newSubPbActivity) {
        this.exF = newSubPbActivity;
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
        com.baidu.tbadk.editortools.e.p pVar;
        com.baidu.tbadk.editortools.e.p pVar2;
        com.baidu.tbadk.editortools.e.p pVar3;
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
        boolean hZ;
        ag agVar35;
        ag agVar36;
        com.baidu.tbadk.editortools.e.p pVar4;
        ax axVar7;
        ax axVar8;
        ag agVar37;
        ax axVar9;
        ag agVar38;
        ag agVar39;
        if (view == null) {
            agVar39 = this.exF.exu;
            if (agVar39 == null) {
                return;
            }
        }
        agVar = this.exF.exu;
        if (view == agVar.aQZ()) {
            agVar37 = this.exF.exu;
            agVar37.aBc();
            axVar9 = this.exF.exr;
            if (axVar9.Fa()) {
                agVar38 = this.exF.exu;
                agVar38.aQW();
                return;
            }
            return;
        }
        agVar2 = this.exF.exu;
        if (view == agVar2.aRd()) {
            MessageManager messageManager = MessageManager.getInstance();
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.exF.getActivity());
            axVar7 = this.exF.exr;
            String threadID = axVar7.getThreadID();
            axVar8 = this.exF.exr;
            messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig.createNormalCfg(threadID, axVar8.Dg(), "")));
            return;
        }
        if (view != null) {
            agVar35 = this.exF.exu;
            if (view == agVar35.aQX()) {
                agVar36 = this.exF.exu;
                agVar36.aBc();
                SparseArray sparseArray = (SparseArray) view.getTag();
                com.baidu.tieba.tbadkCore.data.q qVar = sparseArray.get(r.g.tag_load_sub_data) instanceof com.baidu.tieba.tbadkCore.data.q ? (com.baidu.tieba.tbadkCore.data.q) sparseArray.get(r.g.tag_load_sub_data) : null;
                View view2 = sparseArray.get(r.g.tag_load_sub_view) instanceof View ? (View) sparseArray.get(r.g.tag_load_sub_view) : null;
                SparseArray sparseArray2 = new SparseArray();
                sparseArray2.put(r.g.tag_load_sub_data, qVar);
                sparseArray2.put(r.g.tag_load_sub_view, view2);
                view.setTag(sparseArray2);
                if (this.exF.checkUpIsLogin()) {
                    pVar4 = this.exF.duz;
                    pVar4.fN(null);
                    return;
                }
                return;
            }
        }
        agVar3 = this.exF.exu;
        if (view == agVar3.abF()) {
            agVar30 = this.exF.exu;
            agVar30.aBc();
            agVar31 = this.exF.exu;
            if (agVar31.aRo() == null) {
                if (view != null && view.getTag() != null) {
                    SparseArray sparseArray3 = (SparseArray) view.getTag();
                    if (sparseArray3.get(r.g.tag_del_post_is_self) instanceof Boolean) {
                        z = ((Boolean) sparseArray3.get(r.g.tag_del_post_is_self)).booleanValue();
                        axVar6 = this.exF.exr;
                        boolean isMarked = axVar6.isMarked();
                        agVar34 = this.exF.exu;
                        hZ = this.exF.hZ(z);
                        agVar34.a(view, hZ, isMarked);
                    }
                }
                z = false;
                axVar6 = this.exF.exr;
                boolean isMarked2 = axVar6.isMarked();
                agVar34 = this.exF.exu;
                hZ = this.exF.hZ(z);
                agVar34.a(view, hZ, isMarked2);
            }
            agVar32 = this.exF.exu;
            if (agVar32.aRo() != null) {
                agVar33 = this.exF.exu;
                agVar33.aRo().GM();
                return;
            }
            return;
        }
        agVar4 = this.exF.exu;
        if (agVar4.aRo() != null) {
            agVar28 = this.exF.exu;
            if (view == agVar28.aRo().aOU()) {
                agVar29 = this.exF.exu;
                agVar29.aBc();
                if (this.exF.checkUpIsLogin()) {
                    axVar4 = this.exF.exr;
                    if (axVar4.aRs() != null) {
                        NewSubPbActivity newSubPbActivity = this.exF;
                        axVar5 = this.exF.exr;
                        newSubPbActivity.d(axVar5.aRs().aMN());
                        return;
                    }
                    return;
                }
                return;
            }
        }
        agVar5 = this.exF.exu;
        if (agVar5.aRo() != null) {
            agVar25 = this.exF.exu;
            if (view == agVar25.aRo().aOX()) {
                agVar26 = this.exF.exu;
                agVar26.aBc();
                SparseArray sparseArray4 = (SparseArray) view.getTag();
                if (sparseArray4 != null) {
                    agVar27 = this.exF.exu;
                    agVar27.a(((Integer) sparseArray4.get(r.g.tag_del_post_type)).intValue(), (String) sparseArray4.get(r.g.tag_del_post_id), ((Integer) sparseArray4.get(r.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray4.get(r.g.tag_del_post_is_self)).booleanValue());
                    return;
                }
                return;
            }
        }
        agVar6 = this.exF.exu;
        if (agVar6.aRo() != null) {
            agVar23 = this.exF.exu;
            if (view == agVar23.aRo().aOV()) {
                agVar24 = this.exF.exu;
                agVar24.aBc();
                if (!this.exF.checkUpIsLogin()) {
                    return;
                }
                this.exF.aZ(view);
                return;
            }
        }
        agVar7 = this.exF.exu;
        if (agVar7.aRo() != null) {
            agVar21 = this.exF.exu;
            if (view == agVar21.aRo().aOW()) {
                Object tag = view.getTag();
                agVar22 = this.exF.exu;
                agVar22.aBc();
                if (tag instanceof String) {
                    axVar3 = this.exF.exr;
                    String Dg = axVar3.Dg();
                    if (this.exF.checkUpIsLogin()) {
                        this.exF.pd(Dg);
                        return;
                    }
                    return;
                } else if (tag instanceof SparseArray) {
                    SparseArray<Object> sparseArray5 = (SparseArray) tag;
                    if ((sparseArray5.get(r.g.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray5.get(r.g.tag_user_mute_visible)).booleanValue()) {
                        sparseArray5.put(r.g.tag_from, 0);
                        this.exF.d(sparseArray5);
                        return;
                    }
                    return;
                } else {
                    return;
                }
            }
        }
        agVar8 = this.exF.exu;
        if (view != agVar8.aRf()) {
            agVar10 = this.exF.exu;
            if (view != agVar10.getUserNameView()) {
                agVar11 = this.exF.exu;
                if (view != agVar11.aRg()) {
                    agVar12 = this.exF.exu;
                    if (view != agVar12.aRn()) {
                        agVar13 = this.exF.exu;
                        if (view != agVar13.aRh()) {
                            agVar15 = this.exF.exu;
                            if (view != agVar15.aRi()) {
                                agVar16 = this.exF.exu;
                                if (view != agVar16.aRj()) {
                                    agVar17 = this.exF.exu;
                                    if (view != agVar17.aRc()) {
                                        agVar18 = this.exF.exu;
                                        if (view != agVar18.aRm()) {
                                            agVar19 = this.exF.exu;
                                            if (view == agVar19.aRl()) {
                                                axVar = this.exF.exr;
                                                if (axVar != null) {
                                                    NewSubPbActivity newSubPbActivity2 = this.exF;
                                                    axVar2 = this.exF.exr;
                                                    newSubPbActivity2.pv(axVar2.Dg());
                                                    return;
                                                }
                                                return;
                                            }
                                            agVar20 = this.exF.exu;
                                            if (view == agVar20.aRk()) {
                                                String string = TbadkCoreApplication.m9getInst().getString(r.j.tail_web_view_title);
                                                String string2 = com.baidu.tbadk.core.sharedPref.b.uh().getString("tail_link", "");
                                                if (!StringUtils.isNull(string2)) {
                                                    com.baidu.tbadk.browser.f.a(view.getContext(), string, string2, true, true, true);
                                                    return;
                                                }
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                    if (this.exF.checkUpIsLogin()) {
                                        pVar = this.exF.duz;
                                        if (pVar.DN()) {
                                            pVar3 = this.exF.duz;
                                            pVar3.DO();
                                            return;
                                        }
                                        pVar2 = this.exF.duz;
                                        pVar2.fN(null);
                                        return;
                                    }
                                    return;
                                }
                                String str5 = view.getTag() != null ? (String) view.getTag() : null;
                                if (bm.ak(this.exF.getActivity()) && str5 != null) {
                                    bh.vL().c(this.exF.getPageContext(), new String[]{str5});
                                    return;
                                }
                                return;
                            }
                        }
                        agVar14 = this.exF.exu;
                        agVar14.aBc();
                        if (view.getTag(r.g.tag_user_id) instanceof String) {
                            str4 = NewSubPbActivity.ewV;
                            com.baidu.tbadk.browser.f.a(this.exF.getPageContext().getPageActivity(), TbadkCoreApplication.m9getInst().getString(r.j.user_icon_intro), String.valueOf(str4) + "?user_id=" + ((String) view.getTag(r.g.tag_user_id)) + "?st_type=pb_user_icon", true, false, true);
                            return;
                        }
                        return;
                    }
                }
            }
        }
        agVar9 = this.exF.exu;
        agVar9.aBc();
        if (view instanceof HeadImageView) {
            String userId = ((HeadImageView) view).getUserId();
            str2 = ((HeadImageView) view).getUserName();
            str3 = userId;
        } else {
            if (view.getTag(r.g.tag_user_id) instanceof String) {
                str = (String) view.getTag(r.g.tag_user_id);
            } else {
                str = view.getTag() instanceof String ? (String) view.getTag() : null;
            }
            if (view.getTag(r.g.tag_user_name) instanceof String) {
                str2 = (String) view.getTag(r.g.tag_user_name);
                str3 = str;
            } else {
                str2 = null;
                str3 = str;
            }
        }
        if (str3 != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.exF.getPageContext().getPageActivity(), str3, str2, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
        }
    }
}
