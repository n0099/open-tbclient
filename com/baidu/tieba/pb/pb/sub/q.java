package com.baidu.tieba.pb.pb.sub;

import android.app.Activity;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPrivilegeActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.view.HeadImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements View.OnClickListener {
    final /* synthetic */ NewSubPbActivity bPw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(NewSubPbActivity newSubPbActivity) {
        this.bPw = newSubPbActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        s sVar;
        s sVar2;
        s sVar3;
        s sVar4;
        s sVar5;
        s sVar6;
        s sVar7;
        s sVar8;
        s sVar9;
        String str;
        String str2;
        String str3;
        s sVar10;
        s sVar11;
        s sVar12;
        String str4;
        s sVar13;
        s sVar14;
        s sVar15;
        s sVar16;
        s sVar17;
        s sVar18;
        s sVar19;
        s sVar20;
        ak akVar;
        s sVar21;
        s sVar22;
        s sVar23;
        s sVar24;
        s sVar25;
        s sVar26;
        s sVar27;
        ak akVar2;
        s sVar28;
        ak akVar3;
        s sVar29;
        ak akVar4;
        ak akVar5;
        s sVar30;
        ak akVar6;
        s sVar31;
        sVar = this.bPw.bPq;
        if (view == sVar.adj()) {
            sVar30 = this.bPw.bPq;
            sVar30.acw();
            akVar6 = this.bPw.bPn;
            if (akVar6.BL()) {
                sVar31 = this.bPw.bPq;
                sVar31.adf();
                return;
            }
            return;
        }
        sVar2 = this.bPw.bPq;
        if (view != sVar2.adq()) {
            sVar3 = this.bPw.bPq;
            if (view == sVar3.adh()) {
                sVar29 = this.bPw.bPq;
                sVar29.acw();
                this.bPw.replyPost(view);
                return;
            }
            sVar4 = this.bPw.bPq;
            if (sVar4.adr() != null) {
                sVar27 = this.bPw.bPq;
                if (view == sVar27.adr().abE()) {
                    akVar2 = this.bPw.bPn;
                    if (akVar2.adB() != null) {
                        NewSubPbActivity newSubPbActivity = this.bPw;
                        akVar3 = this.bPw.bPn;
                        newSubPbActivity.b(akVar3.adB().aaA());
                    }
                    sVar28 = this.bPw.bPq;
                    com.baidu.adp.lib.g.k.a(sVar28.ads(), this.bPw.getPageContext().getPageActivity());
                    return;
                }
            }
            sVar5 = this.bPw.bPq;
            if (sVar5.ads() != null) {
                sVar25 = this.bPw.bPq;
                if (view == sVar25.adr().abQ()) {
                    this.bPw.doManager(view);
                    sVar26 = this.bPw.bPq;
                    com.baidu.adp.lib.g.k.a(sVar26.ads(), this.bPw.getPageContext().getPageActivity());
                    return;
                }
            }
            sVar6 = this.bPw.bPq;
            if (sVar6.adr() != null) {
                sVar22 = this.bPw.bPq;
                if (view == sVar22.adr().abP()) {
                    sVar23 = this.bPw.bPq;
                    sVar23.acw();
                    sVar24 = this.bPw.bPq;
                    sVar24.iu(null);
                    return;
                }
            }
            sVar7 = this.bPw.bPq;
            if (sVar7.adr() != null) {
                sVar20 = this.bPw.bPq;
                if (view == sVar20.adr().abR()) {
                    akVar = this.bPw.bPn;
                    String ZP = akVar.ZP();
                    sVar21 = this.bPw.bPq;
                    com.baidu.adp.lib.g.k.a(sVar21.ads(), this.bPw.getPageContext().getPageActivity());
                    this.bPw.im(ZP);
                    return;
                }
            }
            sVar8 = this.bPw.bPq;
            if (view != sVar8.adt()) {
                sVar10 = this.bPw.bPq;
                if (view != sVar10.adu()) {
                    sVar11 = this.bPw.bPq;
                    if (view != sVar11.adv()) {
                        sVar13 = this.bPw.bPq;
                        if (view != sVar13.adw()) {
                            sVar14 = this.bPw.bPq;
                            if (view != sVar14.adx()) {
                                sVar15 = this.bPw.bPq;
                                if (view == sVar15.ado()) {
                                    sVar17 = this.bPw.bPq;
                                    if (sVar17.adp()) {
                                        sVar19 = this.bPw.bPq;
                                        sVar19.ade();
                                        return;
                                    }
                                    sVar18 = this.bPw.bPq;
                                    sVar18.iu(null);
                                    return;
                                }
                                sVar16 = this.bPw.bPq;
                                sVar16.acw();
                                this.bPw.doManager(view);
                                return;
                            }
                            this.bPw.sendMessage(new CustomMessage(2002001, new MemberPrivilegeActivityConfig(this.bPw.getPageContext().getPageActivity())));
                            return;
                        }
                    }
                    sVar12 = this.bPw.bPq;
                    sVar12.acw();
                    Activity pageActivity = this.bPw.getPageContext().getPageActivity();
                    String string = this.bPw.getPageContext().getString(com.baidu.tieba.t.user_icon_intro);
                    str4 = NewSubPbActivity.bOI;
                    com.baidu.tbadk.browser.f.a(pageActivity, string, String.valueOf(str4) + "?st_type=pb_user_icon", true, false, false);
                    return;
                }
            }
            sVar9 = this.bPw.bPq;
            sVar9.acw();
            if (view instanceof HeadImageView) {
                String userId = ((HeadImageView) view).getUserId();
                str2 = ((HeadImageView) view).getUserName();
                str3 = userId;
            } else {
                if (view.getTag(com.baidu.tieba.q.tag_user_id) instanceof String) {
                    str = (String) view.getTag(com.baidu.tieba.q.tag_user_id);
                } else {
                    str = view.getTag() instanceof String ? (String) view.getTag() : null;
                }
                if (view.getTag(com.baidu.tieba.q.tag_user_name) instanceof String) {
                    str2 = (String) view.getTag(com.baidu.tieba.q.tag_user_name);
                    str3 = str;
                } else {
                    str2 = null;
                    str3 = str;
                }
            }
            if (str3 != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.bPw.getPageContext().getPageActivity(), str3, str2, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
                return;
            }
            return;
        }
        MessageManager messageManager = MessageManager.getInstance();
        PbActivityConfig pbActivityConfig = new PbActivityConfig(this.bPw.getActivity());
        akVar4 = this.bPw.bPn;
        String abo = akVar4.abo();
        akVar5 = this.bPw.bPn;
        messageManager.sendMessage(new CustomMessage(2004001, pbActivityConfig.createNormalCfg(abo, akVar5.ZP(), "")));
    }
}
