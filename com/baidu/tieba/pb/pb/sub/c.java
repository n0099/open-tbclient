package com.baidu.tieba.pb.pb.sub;

import android.app.Activity;
import android.util.SparseArray;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPrivilegeActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ NewSubPbActivity cnS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(NewSubPbActivity newSubPbActivity) {
        this.cnS = newSubPbActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        v vVar;
        v vVar2;
        v vVar3;
        v vVar4;
        v vVar5;
        v vVar6;
        v vVar7;
        v vVar8;
        v vVar9;
        String str;
        String str2;
        String str3;
        v vVar10;
        v vVar11;
        v vVar12;
        String str4;
        v vVar13;
        v vVar14;
        v vVar15;
        com.baidu.tbadk.editortools.c.p pVar;
        com.baidu.tbadk.editortools.c.p pVar2;
        com.baidu.tbadk.editortools.c.p pVar3;
        v vVar16;
        v vVar17;
        v vVar18;
        am amVar;
        am amVar2;
        v vVar19;
        v vVar20;
        am amVar3;
        v vVar21;
        v vVar22;
        com.baidu.tbadk.editortools.c.p pVar4;
        v vVar23;
        v vVar24;
        v vVar25;
        v vVar26;
        am amVar4;
        am amVar5;
        v vVar27;
        am amVar6;
        am amVar7;
        v vVar28;
        am amVar8;
        v vVar29;
        vVar = this.cnS.cnJ;
        if (view == vVar.ahN()) {
            vVar28 = this.cnS.cnJ;
            vVar28.aho();
            amVar8 = this.cnS.cnH;
            if (amVar8.CI()) {
                vVar29 = this.cnS.cnJ;
                vVar29.ahK();
                return;
            }
            return;
        }
        vVar2 = this.cnS.cnJ;
        if (view != vVar2.ahR()) {
            vVar3 = this.cnS.cnJ;
            if (view == vVar3.ahL()) {
                vVar27 = this.cnS.cnJ;
                vVar27.aho();
                this.cnS.replyPost(view);
                return;
            }
            vVar4 = this.cnS.cnJ;
            if (vVar4.ahS() != null) {
                vVar25 = this.cnS.cnJ;
                if (view == vVar25.ahS().agz()) {
                    vVar26 = this.cnS.cnJ;
                    com.baidu.adp.lib.g.j.a(vVar26.ahT(), this.cnS.getPageContext().getPageActivity());
                    if (this.cnS.checkUpIsLogin()) {
                        amVar4 = this.cnS.cnH;
                        if (amVar4.aic() != null) {
                            NewSubPbActivity newSubPbActivity = this.cnS;
                            amVar5 = this.cnS.cnH;
                            newSubPbActivity.c(amVar5.aic().afs());
                            return;
                        }
                        return;
                    }
                    return;
                }
            }
            vVar5 = this.cnS.cnJ;
            if (vVar5.ahT() != null) {
                vVar23 = this.cnS.cnJ;
                if (view == vVar23.ahS().agL()) {
                    vVar24 = this.cnS.cnJ;
                    com.baidu.adp.lib.g.j.a(vVar24.ahT(), this.cnS.getPageContext().getPageActivity());
                    if (!this.cnS.checkUpIsLogin()) {
                        return;
                    }
                    this.cnS.ac(view);
                    return;
                }
            }
            vVar6 = this.cnS.cnJ;
            if (vVar6.ahS() != null) {
                vVar21 = this.cnS.cnJ;
                if (view == vVar21.ahS().agK()) {
                    vVar22 = this.cnS.cnJ;
                    vVar22.aho();
                    if (this.cnS.checkUpIsLogin()) {
                        pVar4 = this.cnS.cbv;
                        pVar4.fg(null);
                        return;
                    }
                    return;
                }
            }
            vVar7 = this.cnS.cnJ;
            if (vVar7.ahS() != null) {
                vVar19 = this.cnS.cnJ;
                if (view == vVar19.ahS().agM()) {
                    Object tag = view.getTag();
                    vVar20 = this.cnS.cnJ;
                    com.baidu.adp.lib.g.j.a(vVar20.ahT(), this.cnS.getPageContext().getPageActivity());
                    if (tag instanceof String) {
                        amVar3 = this.cnS.cnH;
                        String AV = amVar3.AV();
                        if (this.cnS.checkUpIsLogin()) {
                            this.cnS.jK(AV);
                            return;
                        }
                        return;
                    } else if (tag instanceof SparseArray) {
                        SparseArray<Object> sparseArray = (SparseArray) tag;
                        if ((sparseArray.get(i.f.tag_display_reply_visible) instanceof Boolean) && ((Boolean) sparseArray.get(i.f.tag_display_reply_visible)).booleanValue()) {
                            sparseArray.put(i.f.tag_from, 0);
                            this.cnS.d(sparseArray);
                            return;
                        }
                        return;
                    } else {
                        return;
                    }
                }
            }
            vVar8 = this.cnS.cnJ;
            if (view != vVar8.ahU()) {
                vVar10 = this.cnS.cnJ;
                if (view != vVar10.getUserNameView()) {
                    vVar11 = this.cnS.cnJ;
                    if (view != vVar11.ahV()) {
                        vVar13 = this.cnS.cnJ;
                        if (view != vVar13.ahW()) {
                            vVar14 = this.cnS.cnJ;
                            if (view != vVar14.ahX()) {
                                vVar15 = this.cnS.cnJ;
                                if (view != vVar15.ahQ()) {
                                    vVar16 = this.cnS.cnJ;
                                    if (view != vVar16.aia()) {
                                        vVar17 = this.cnS.cnJ;
                                        if (view == vVar17.ahZ()) {
                                            amVar = this.cnS.cnH;
                                            if (amVar != null) {
                                                NewSubPbActivity newSubPbActivity2 = this.cnS;
                                                amVar2 = this.cnS.cnH;
                                                newSubPbActivity2.jV(amVar2.AV());
                                                return;
                                            }
                                            return;
                                        }
                                        vVar18 = this.cnS.cnJ;
                                        if (view == vVar18.ahY()) {
                                            String string = TbadkCoreApplication.m411getInst().getString(i.h.tail_web_view_title);
                                            String string2 = com.baidu.tbadk.core.sharedPref.b.tu().getString("tail_link", "");
                                            if (!StringUtils.isNull(string2)) {
                                                com.baidu.tbadk.browser.g.a(view.getContext(), string, string2, true, true, true);
                                                return;
                                            }
                                            return;
                                        }
                                        return;
                                    }
                                }
                                if (this.cnS.checkUpIsLogin()) {
                                    pVar = this.cnS.cbv;
                                    if (pVar.BB()) {
                                        pVar3 = this.cnS.cbv;
                                        pVar3.BC();
                                        return;
                                    }
                                    pVar2 = this.cnS.cbv;
                                    pVar2.fg(null);
                                    return;
                                }
                                return;
                            }
                            this.cnS.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MemberPrivilegeActivityConfig(this.cnS.getPageContext().getPageActivity())));
                            return;
                        }
                    }
                    vVar12 = this.cnS.cnJ;
                    vVar12.aho();
                    Activity pageActivity = this.cnS.getPageContext().getPageActivity();
                    String string3 = this.cnS.getPageContext().getString(i.h.user_icon_intro);
                    str4 = NewSubPbActivity.cnb;
                    com.baidu.tbadk.browser.g.a(pageActivity, string3, String.valueOf(str4) + "?st_type=pb_user_icon", true, false, false);
                    return;
                }
            }
            vVar9 = this.cnS.cnJ;
            vVar9.aho();
            if (view instanceof HeadImageView) {
                String userId = ((HeadImageView) view).getUserId();
                str2 = ((HeadImageView) view).getUserName();
                str3 = userId;
            } else {
                if (view.getTag(i.f.tag_user_id) instanceof String) {
                    str = (String) view.getTag(i.f.tag_user_id);
                } else {
                    str = view.getTag() instanceof String ? (String) view.getTag() : null;
                }
                if (view.getTag(i.f.tag_user_name) instanceof String) {
                    str2 = (String) view.getTag(i.f.tag_user_name);
                    str3 = str;
                } else {
                    str2 = null;
                    str3 = str;
                }
            }
            if (str3 != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.cnS.getPageContext().getPageActivity(), str3, str2, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
                return;
            }
            return;
        }
        MessageManager messageManager = MessageManager.getInstance();
        PbActivityConfig pbActivityConfig = new PbActivityConfig(this.cnS.getActivity());
        amVar6 = this.cnS.cnH;
        String threadID = amVar6.getThreadID();
        amVar7 = this.cnS.cnH;
        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig.createNormalCfg(threadID, amVar7.AV(), "")));
    }
}
