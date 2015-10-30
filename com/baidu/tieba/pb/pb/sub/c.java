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
    final /* synthetic */ NewSubPbActivity cmC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(NewSubPbActivity newSubPbActivity) {
        this.cmC = newSubPbActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        t tVar;
        t tVar2;
        t tVar3;
        t tVar4;
        t tVar5;
        t tVar6;
        t tVar7;
        t tVar8;
        t tVar9;
        String str;
        String str2;
        String str3;
        t tVar10;
        t tVar11;
        t tVar12;
        String str4;
        t tVar13;
        t tVar14;
        t tVar15;
        com.baidu.tbadk.editortools.c.n nVar;
        com.baidu.tbadk.editortools.c.n nVar2;
        com.baidu.tbadk.editortools.c.n nVar3;
        t tVar16;
        t tVar17;
        t tVar18;
        ak akVar;
        ak akVar2;
        t tVar19;
        t tVar20;
        ak akVar3;
        t tVar21;
        t tVar22;
        com.baidu.tbadk.editortools.c.n nVar4;
        t tVar23;
        t tVar24;
        t tVar25;
        t tVar26;
        ak akVar4;
        ak akVar5;
        t tVar27;
        ak akVar6;
        ak akVar7;
        t tVar28;
        ak akVar8;
        t tVar29;
        tVar = this.cmC.cmv;
        if (view == tVar.ahh()) {
            tVar28 = this.cmC.cmv;
            tVar28.agI();
            akVar8 = this.cmC.cmt;
            if (akVar8.CP()) {
                tVar29 = this.cmC.cmv;
                tVar29.ahe();
                return;
            }
            return;
        }
        tVar2 = this.cmC.cmv;
        if (view != tVar2.ahl()) {
            tVar3 = this.cmC.cmv;
            if (view == tVar3.ahf()) {
                tVar27 = this.cmC.cmv;
                tVar27.agI();
                this.cmC.replyPost(view);
                return;
            }
            tVar4 = this.cmC.cmv;
            if (tVar4.ahm() != null) {
                tVar25 = this.cmC.cmv;
                if (view == tVar25.ahm().afU()) {
                    tVar26 = this.cmC.cmv;
                    com.baidu.adp.lib.g.j.a(tVar26.ahn(), this.cmC.getPageContext().getPageActivity());
                    if (this.cmC.checkUpIsLogin()) {
                        akVar4 = this.cmC.cmt;
                        if (akVar4.ahw() != null) {
                            NewSubPbActivity newSubPbActivity = this.cmC;
                            akVar5 = this.cmC.cmt;
                            newSubPbActivity.c(akVar5.ahw().aeV());
                            return;
                        }
                        return;
                    }
                    return;
                }
            }
            tVar5 = this.cmC.cmv;
            if (tVar5.ahn() != null) {
                tVar23 = this.cmC.cmv;
                if (view == tVar23.ahm().agg()) {
                    tVar24 = this.cmC.cmv;
                    com.baidu.adp.lib.g.j.a(tVar24.ahn(), this.cmC.getPageContext().getPageActivity());
                    if (!this.cmC.checkUpIsLogin()) {
                        return;
                    }
                    this.cmC.ad(view);
                    return;
                }
            }
            tVar6 = this.cmC.cmv;
            if (tVar6.ahm() != null) {
                tVar21 = this.cmC.cmv;
                if (view == tVar21.ahm().agf()) {
                    tVar22 = this.cmC.cmv;
                    tVar22.agI();
                    if (this.cmC.checkUpIsLogin()) {
                        nVar4 = this.cmC.caU;
                        nVar4.fe(null);
                        return;
                    }
                    return;
                }
            }
            tVar7 = this.cmC.cmv;
            if (tVar7.ahm() != null) {
                tVar19 = this.cmC.cmv;
                if (view == tVar19.ahm().agh()) {
                    Object tag = view.getTag();
                    tVar20 = this.cmC.cmv;
                    com.baidu.adp.lib.g.j.a(tVar20.ahn(), this.cmC.getPageContext().getPageActivity());
                    if (tag instanceof String) {
                        akVar3 = this.cmC.cmt;
                        String Bi = akVar3.Bi();
                        if (this.cmC.checkUpIsLogin()) {
                            this.cmC.jI(Bi);
                            return;
                        }
                        return;
                    } else if (tag instanceof SparseArray) {
                        SparseArray<Object> sparseArray = (SparseArray) tag;
                        if ((sparseArray.get(i.f.tag_display_reply_visible) instanceof Boolean) && ((Boolean) sparseArray.get(i.f.tag_display_reply_visible)).booleanValue()) {
                            sparseArray.put(i.f.tag_from, 0);
                            this.cmC.d(sparseArray);
                            return;
                        }
                        return;
                    } else {
                        return;
                    }
                }
            }
            tVar8 = this.cmC.cmv;
            if (view != tVar8.aho()) {
                tVar10 = this.cmC.cmv;
                if (view != tVar10.getUserNameView()) {
                    tVar11 = this.cmC.cmv;
                    if (view != tVar11.ahp()) {
                        tVar13 = this.cmC.cmv;
                        if (view != tVar13.ahq()) {
                            tVar14 = this.cmC.cmv;
                            if (view != tVar14.ahr()) {
                                tVar15 = this.cmC.cmv;
                                if (view != tVar15.ahk()) {
                                    tVar16 = this.cmC.cmv;
                                    if (view != tVar16.ahu()) {
                                        tVar17 = this.cmC.cmv;
                                        if (view == tVar17.aht()) {
                                            akVar = this.cmC.cmt;
                                            if (akVar != null) {
                                                NewSubPbActivity newSubPbActivity2 = this.cmC;
                                                akVar2 = this.cmC.cmt;
                                                newSubPbActivity2.jS(akVar2.Bi());
                                                return;
                                            }
                                            return;
                                        }
                                        tVar18 = this.cmC.cmv;
                                        if (view == tVar18.ahs()) {
                                            String string = TbadkCoreApplication.m411getInst().getString(i.h.tail_web_view_title);
                                            String string2 = com.baidu.tbadk.core.sharedPref.b.tr().getString("tail_link", "");
                                            if (!StringUtils.isNull(string2)) {
                                                com.baidu.tbadk.browser.g.a(view.getContext(), string, string2, true, true, true);
                                                return;
                                            }
                                            return;
                                        }
                                        return;
                                    }
                                }
                                if (this.cmC.checkUpIsLogin()) {
                                    nVar = this.cmC.caU;
                                    if (nVar.BI()) {
                                        nVar3 = this.cmC.caU;
                                        nVar3.BJ();
                                        return;
                                    }
                                    nVar2 = this.cmC.caU;
                                    nVar2.fe(null);
                                    return;
                                }
                                return;
                            }
                            this.cmC.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MemberPrivilegeActivityConfig(this.cmC.getPageContext().getPageActivity())));
                            return;
                        }
                    }
                    tVar12 = this.cmC.cmv;
                    tVar12.agI();
                    Activity pageActivity = this.cmC.getPageContext().getPageActivity();
                    String string3 = this.cmC.getPageContext().getString(i.h.user_icon_intro);
                    str4 = NewSubPbActivity.clM;
                    com.baidu.tbadk.browser.g.a(pageActivity, string3, String.valueOf(str4) + "?st_type=pb_user_icon", true, false, false);
                    return;
                }
            }
            tVar9 = this.cmC.cmv;
            tVar9.agI();
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
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.cmC.getPageContext().getPageActivity(), str3, str2, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
                return;
            }
            return;
        }
        MessageManager messageManager = MessageManager.getInstance();
        PbActivityConfig pbActivityConfig = new PbActivityConfig(this.cmC.getActivity());
        akVar6 = this.cmC.cmt;
        String threadID = akVar6.getThreadID();
        akVar7 = this.cmC.cmt;
        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig.createNormalCfg(threadID, akVar7.Bi(), "")));
    }
}
