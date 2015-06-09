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
    final /* synthetic */ NewSubPbActivity bPx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(NewSubPbActivity newSubPbActivity) {
        this.bPx = newSubPbActivity;
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
        sVar = this.bPx.bPr;
        if (view == sVar.adk()) {
            sVar30 = this.bPx.bPr;
            sVar30.acx();
            akVar6 = this.bPx.bPo;
            if (akVar6.BM()) {
                sVar31 = this.bPx.bPr;
                sVar31.adg();
                return;
            }
            return;
        }
        sVar2 = this.bPx.bPr;
        if (view != sVar2.adr()) {
            sVar3 = this.bPx.bPr;
            if (view == sVar3.adi()) {
                sVar29 = this.bPx.bPr;
                sVar29.acx();
                this.bPx.replyPost(view);
                return;
            }
            sVar4 = this.bPx.bPr;
            if (sVar4.ads() != null) {
                sVar27 = this.bPx.bPr;
                if (view == sVar27.ads().abF()) {
                    akVar2 = this.bPx.bPo;
                    if (akVar2.adC() != null) {
                        NewSubPbActivity newSubPbActivity = this.bPx;
                        akVar3 = this.bPx.bPo;
                        newSubPbActivity.b(akVar3.adC().aaB());
                    }
                    sVar28 = this.bPx.bPr;
                    com.baidu.adp.lib.g.k.a(sVar28.adt(), this.bPx.getPageContext().getPageActivity());
                    return;
                }
            }
            sVar5 = this.bPx.bPr;
            if (sVar5.adt() != null) {
                sVar25 = this.bPx.bPr;
                if (view == sVar25.ads().abR()) {
                    this.bPx.doManager(view);
                    sVar26 = this.bPx.bPr;
                    com.baidu.adp.lib.g.k.a(sVar26.adt(), this.bPx.getPageContext().getPageActivity());
                    return;
                }
            }
            sVar6 = this.bPx.bPr;
            if (sVar6.ads() != null) {
                sVar22 = this.bPx.bPr;
                if (view == sVar22.ads().abQ()) {
                    sVar23 = this.bPx.bPr;
                    sVar23.acx();
                    sVar24 = this.bPx.bPr;
                    sVar24.iu(null);
                    return;
                }
            }
            sVar7 = this.bPx.bPr;
            if (sVar7.ads() != null) {
                sVar20 = this.bPx.bPr;
                if (view == sVar20.ads().abS()) {
                    akVar = this.bPx.bPo;
                    String ZQ = akVar.ZQ();
                    sVar21 = this.bPx.bPr;
                    com.baidu.adp.lib.g.k.a(sVar21.adt(), this.bPx.getPageContext().getPageActivity());
                    this.bPx.im(ZQ);
                    return;
                }
            }
            sVar8 = this.bPx.bPr;
            if (view != sVar8.adu()) {
                sVar10 = this.bPx.bPr;
                if (view != sVar10.adv()) {
                    sVar11 = this.bPx.bPr;
                    if (view != sVar11.adw()) {
                        sVar13 = this.bPx.bPr;
                        if (view != sVar13.adx()) {
                            sVar14 = this.bPx.bPr;
                            if (view != sVar14.ady()) {
                                sVar15 = this.bPx.bPr;
                                if (view == sVar15.adp()) {
                                    sVar17 = this.bPx.bPr;
                                    if (sVar17.adq()) {
                                        sVar19 = this.bPx.bPr;
                                        sVar19.adf();
                                        return;
                                    }
                                    sVar18 = this.bPx.bPr;
                                    sVar18.iu(null);
                                    return;
                                }
                                sVar16 = this.bPx.bPr;
                                sVar16.acx();
                                this.bPx.doManager(view);
                                return;
                            }
                            this.bPx.sendMessage(new CustomMessage(2002001, new MemberPrivilegeActivityConfig(this.bPx.getPageContext().getPageActivity())));
                            return;
                        }
                    }
                    sVar12 = this.bPx.bPr;
                    sVar12.acx();
                    Activity pageActivity = this.bPx.getPageContext().getPageActivity();
                    String string = this.bPx.getPageContext().getString(com.baidu.tieba.t.user_icon_intro);
                    str4 = NewSubPbActivity.bOJ;
                    com.baidu.tbadk.browser.f.a(pageActivity, string, String.valueOf(str4) + "?st_type=pb_user_icon", true, false, false);
                    return;
                }
            }
            sVar9 = this.bPx.bPr;
            sVar9.acx();
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
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.bPx.getPageContext().getPageActivity(), str3, str2, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
                return;
            }
            return;
        }
        MessageManager messageManager = MessageManager.getInstance();
        PbActivityConfig pbActivityConfig = new PbActivityConfig(this.bPx.getActivity());
        akVar4 = this.bPx.bPo;
        String abp = akVar4.abp();
        akVar5 = this.bPx.bPo;
        messageManager.sendMessage(new CustomMessage(2004001, pbActivityConfig.createNormalCfg(abp, akVar5.ZQ(), "")));
    }
}
