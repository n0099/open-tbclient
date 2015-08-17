package com.baidu.tieba.pb.pb.sub;

import android.app.Activity;
import android.util.SparseArray;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
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
    final /* synthetic */ NewSubPbActivity cfY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(NewSubPbActivity newSubPbActivity) {
        this.cfY = newSubPbActivity;
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
        ak akVar;
        ak akVar2;
        t tVar18;
        t tVar19;
        ak akVar3;
        t tVar20;
        t tVar21;
        com.baidu.tbadk.editortools.c.n nVar4;
        t tVar22;
        t tVar23;
        t tVar24;
        t tVar25;
        ak akVar4;
        ak akVar5;
        t tVar26;
        ak akVar6;
        ak akVar7;
        t tVar27;
        ak akVar8;
        t tVar28;
        tVar = this.cfY.cfR;
        if (view == tVar.afa()) {
            tVar27 = this.cfY.cfR;
            tVar27.aeA();
            akVar8 = this.cfY.cfP;
            if (akVar8.CV()) {
                tVar28 = this.cfY.cfR;
                tVar28.aeX();
                return;
            }
            return;
        }
        tVar2 = this.cfY.cfR;
        if (view != tVar2.afe()) {
            tVar3 = this.cfY.cfR;
            if (view == tVar3.aeY()) {
                tVar26 = this.cfY.cfR;
                tVar26.aeA();
                this.cfY.replyPost(view);
                return;
            }
            tVar4 = this.cfY.cfR;
            if (tVar4.aff() != null) {
                tVar24 = this.cfY.cfR;
                if (view == tVar24.aff().adM()) {
                    tVar25 = this.cfY.cfR;
                    com.baidu.adp.lib.g.j.a(tVar25.afg(), this.cfY.getPageContext().getPageActivity());
                    if (this.cfY.checkUpIsLogin()) {
                        akVar4 = this.cfY.cfP;
                        if (akVar4.afo() != null) {
                            NewSubPbActivity newSubPbActivity = this.cfY;
                            akVar5 = this.cfY.cfP;
                            newSubPbActivity.b(akVar5.afo().acQ());
                            return;
                        }
                        return;
                    }
                    return;
                }
            }
            tVar5 = this.cfY.cfR;
            if (tVar5.afg() != null) {
                tVar22 = this.cfY.cfR;
                if (view == tVar22.aff().adY()) {
                    tVar23 = this.cfY.cfR;
                    com.baidu.adp.lib.g.j.a(tVar23.afg(), this.cfY.getPageContext().getPageActivity());
                    if (!this.cfY.checkUpIsLogin()) {
                        return;
                    }
                    this.cfY.ab(view);
                    return;
                }
            }
            tVar6 = this.cfY.cfR;
            if (tVar6.aff() != null) {
                tVar20 = this.cfY.cfR;
                if (view == tVar20.aff().adX()) {
                    tVar21 = this.cfY.cfR;
                    tVar21.aeA();
                    if (this.cfY.checkUpIsLogin()) {
                        nVar4 = this.cfY.bWp;
                        nVar4.eR(null);
                        return;
                    }
                    return;
                }
            }
            tVar7 = this.cfY.cfR;
            if (tVar7.aff() != null) {
                tVar18 = this.cfY.cfR;
                if (view == tVar18.aff().adZ()) {
                    Object tag = view.getTag();
                    tVar19 = this.cfY.cfR;
                    com.baidu.adp.lib.g.j.a(tVar19.afg(), this.cfY.getPageContext().getPageActivity());
                    if (tag instanceof String) {
                        akVar3 = this.cfY.cfP;
                        String Bl = akVar3.Bl();
                        if (this.cfY.checkUpIsLogin()) {
                            this.cfY.jh(Bl);
                            return;
                        }
                        return;
                    } else if (tag instanceof SparseArray) {
                        SparseArray<Object> sparseArray = (SparseArray) tag;
                        if ((sparseArray.get(i.f.tag_display_reply_visible) instanceof Boolean) && ((Boolean) sparseArray.get(i.f.tag_display_reply_visible)).booleanValue()) {
                            sparseArray.put(i.f.tag_from, 0);
                            this.cfY.d(sparseArray);
                            return;
                        }
                        return;
                    } else {
                        return;
                    }
                }
            }
            tVar8 = this.cfY.cfR;
            if (view != tVar8.afh()) {
                tVar10 = this.cfY.cfR;
                if (view != tVar10.getUserNameView()) {
                    tVar11 = this.cfY.cfR;
                    if (view != tVar11.afi()) {
                        tVar13 = this.cfY.cfR;
                        if (view != tVar13.afj()) {
                            tVar14 = this.cfY.cfR;
                            if (view != tVar14.afk()) {
                                tVar15 = this.cfY.cfR;
                                if (view != tVar15.afd()) {
                                    tVar16 = this.cfY.cfR;
                                    if (view != tVar16.afm()) {
                                        tVar17 = this.cfY.cfR;
                                        if (view == tVar17.afl()) {
                                            akVar = this.cfY.cfP;
                                            if (akVar != null) {
                                                NewSubPbActivity newSubPbActivity2 = this.cfY;
                                                akVar2 = this.cfY.cfP;
                                                newSubPbActivity2.jq(akVar2.Bl());
                                                return;
                                            }
                                            return;
                                        }
                                        return;
                                    }
                                }
                                if (this.cfY.checkUpIsLogin()) {
                                    nVar = this.cfY.bWp;
                                    if (nVar.BK()) {
                                        nVar3 = this.cfY.bWp;
                                        nVar3.BL();
                                        return;
                                    }
                                    nVar2 = this.cfY.bWp;
                                    nVar2.eR(null);
                                    return;
                                }
                                return;
                            }
                            this.cfY.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MemberPrivilegeActivityConfig(this.cfY.getPageContext().getPageActivity())));
                            return;
                        }
                    }
                    tVar12 = this.cfY.cfR;
                    tVar12.aeA();
                    Activity pageActivity = this.cfY.getPageContext().getPageActivity();
                    String string = this.cfY.getPageContext().getString(i.C0057i.user_icon_intro);
                    str4 = NewSubPbActivity.cfm;
                    com.baidu.tbadk.browser.f.a(pageActivity, string, String.valueOf(str4) + "?st_type=pb_user_icon", true, false, false);
                    return;
                }
            }
            tVar9 = this.cfY.cfR;
            tVar9.aeA();
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
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.cfY.getPageContext().getPageActivity(), str3, str2, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
                return;
            }
            return;
        }
        MessageManager messageManager = MessageManager.getInstance();
        PbActivityConfig pbActivityConfig = new PbActivityConfig(this.cfY.getActivity());
        akVar6 = this.cfY.cfP;
        String threadID = akVar6.getThreadID();
        akVar7 = this.cfY.cfP;
        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig.createNormalCfg(threadID, akVar7.Bl(), "")));
    }
}
