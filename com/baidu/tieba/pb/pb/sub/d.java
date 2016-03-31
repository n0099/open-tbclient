package com.baidu.tieba.pb.pb.sub;

import android.app.Activity;
import android.util.SparseArray;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.MembercenterActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.bl;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ NewSubPbActivity doF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(NewSubPbActivity newSubPbActivity) {
        this.doF = newSubPbActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        x xVar;
        x xVar2;
        x xVar3;
        x xVar4;
        x xVar5;
        x xVar6;
        x xVar7;
        x xVar8;
        x xVar9;
        String str;
        String str2;
        String str3;
        x xVar10;
        x xVar11;
        x xVar12;
        x xVar13;
        String str4;
        x xVar14;
        x xVar15;
        x xVar16;
        com.baidu.tbadk.editortools.d.p pVar;
        com.baidu.tbadk.editortools.d.p pVar2;
        com.baidu.tbadk.editortools.d.p pVar3;
        x xVar17;
        x xVar18;
        x xVar19;
        ap apVar;
        ap apVar2;
        x xVar20;
        x xVar21;
        ap apVar3;
        x xVar22;
        x xVar23;
        com.baidu.tbadk.editortools.d.p pVar4;
        x xVar24;
        x xVar25;
        x xVar26;
        x xVar27;
        ap apVar4;
        ap apVar5;
        x xVar28;
        ap apVar6;
        ap apVar7;
        x xVar29;
        ap apVar8;
        x xVar30;
        xVar = this.doF.dow;
        if (view == xVar.azQ()) {
            xVar29 = this.doF.dow;
            xVar29.amI();
            apVar8 = this.doF.dou;
            if (apVar8.FG()) {
                xVar30 = this.doF.dow;
                xVar30.azN();
                return;
            }
            return;
        }
        xVar2 = this.doF.dow;
        if (view != xVar2.azU()) {
            xVar3 = this.doF.dow;
            if (view == xVar3.azO()) {
                xVar28 = this.doF.dow;
                xVar28.amI();
                this.doF.replyPost(view);
                return;
            }
            xVar4 = this.doF.dow;
            if (xVar4.azV() != null) {
                xVar26 = this.doF.dow;
                if (view == xVar26.azV().axB()) {
                    xVar27 = this.doF.dow;
                    com.baidu.adp.lib.h.j.a(xVar27.azW(), this.doF.getPageContext().getPageActivity());
                    if (this.doF.checkUpIsLogin()) {
                        apVar4 = this.doF.dou;
                        if (apVar4.aAg() != null) {
                            NewSubPbActivity newSubPbActivity = this.doF;
                            apVar5 = this.doF.dou;
                            newSubPbActivity.d(apVar5.aAg().avI());
                            return;
                        }
                        return;
                    }
                    return;
                }
            }
            xVar5 = this.doF.dow;
            if (xVar5.azW() != null) {
                xVar24 = this.doF.dow;
                if (view == xVar24.azV().ayf()) {
                    xVar25 = this.doF.dow;
                    com.baidu.adp.lib.h.j.a(xVar25.azW(), this.doF.getPageContext().getPageActivity());
                    if (!this.doF.checkUpIsLogin()) {
                        return;
                    }
                    this.doF.aO(view);
                    return;
                }
            }
            xVar6 = this.doF.dow;
            if (xVar6.azV() != null) {
                xVar22 = this.doF.dow;
                if (view == xVar22.azV().aye()) {
                    xVar23 = this.doF.dow;
                    xVar23.amI();
                    if (this.doF.checkUpIsLogin()) {
                        pVar4 = this.doF.cye;
                        pVar4.fF(null);
                        return;
                    }
                    return;
                }
            }
            xVar7 = this.doF.dow;
            if (xVar7.azV() != null) {
                xVar20 = this.doF.dow;
                if (view == xVar20.azV().ayg()) {
                    Object tag = view.getTag();
                    xVar21 = this.doF.dow;
                    com.baidu.adp.lib.h.j.a(xVar21.azW(), this.doF.getPageContext().getPageActivity());
                    if (tag instanceof String) {
                        apVar3 = this.doF.dou;
                        String DH = apVar3.DH();
                        if (this.doF.checkUpIsLogin()) {
                            this.doF.lN(DH);
                            return;
                        }
                        return;
                    } else if (tag instanceof SparseArray) {
                        SparseArray<Object> sparseArray = (SparseArray) tag;
                        if ((sparseArray.get(t.g.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray.get(t.g.tag_user_mute_visible)).booleanValue()) {
                            sparseArray.put(t.g.tag_from, 0);
                            this.doF.d(sparseArray);
                            return;
                        }
                        return;
                    } else {
                        return;
                    }
                }
            }
            xVar8 = this.doF.dow;
            if (view != xVar8.azX()) {
                xVar10 = this.doF.dow;
                if (view != xVar10.getUserNameView()) {
                    xVar11 = this.doF.dow;
                    if (view != xVar11.azY()) {
                        xVar12 = this.doF.dow;
                        if (view != xVar12.azZ()) {
                            xVar14 = this.doF.dow;
                            if (view != xVar14.aAa()) {
                                xVar15 = this.doF.dow;
                                if (view != xVar15.aAb()) {
                                    xVar16 = this.doF.dow;
                                    if (view != xVar16.azT()) {
                                        xVar17 = this.doF.dow;
                                        if (view != xVar17.aAe()) {
                                            xVar18 = this.doF.dow;
                                            if (view == xVar18.aAd()) {
                                                apVar = this.doF.dou;
                                                if (apVar != null) {
                                                    NewSubPbActivity newSubPbActivity2 = this.doF;
                                                    apVar2 = this.doF.dou;
                                                    newSubPbActivity2.me(apVar2.DH());
                                                    return;
                                                }
                                                return;
                                            }
                                            xVar19 = this.doF.dow;
                                            if (view == xVar19.aAc()) {
                                                String string = TbadkCoreApplication.m411getInst().getString(t.j.tail_web_view_title);
                                                String string2 = com.baidu.tbadk.core.sharedPref.b.vk().getString("tail_link", "");
                                                if (!StringUtils.isNull(string2)) {
                                                    com.baidu.tbadk.browser.f.a(view.getContext(), string, string2, true, true, true);
                                                    return;
                                                }
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                    if (this.doF.checkUpIsLogin()) {
                                        pVar = this.doF.cye;
                                        if (pVar.Er()) {
                                            pVar3 = this.doF.cye;
                                            pVar3.Es();
                                            return;
                                        }
                                        pVar2 = this.doF.cye;
                                        pVar2.fF(null);
                                        return;
                                    }
                                    return;
                                }
                                String str5 = view.getTag() != null ? (String) view.getTag() : null;
                                if (bl.ad(this.doF.getActivity())) {
                                    if (!StringUtils.isNull(str5) && !str5.startsWith("vipcenter:") && !str5.startsWith("membercenter:")) {
                                        com.baidu.tbadk.browser.f.c(this.doF.getActivity(), this.doF.getActivity().getResources().getString(t.j.membercenter_title), str5);
                                        return;
                                    } else {
                                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MembercenterActivityConfig(this.doF.getActivity())));
                                        return;
                                    }
                                }
                                return;
                            }
                        }
                        xVar13 = this.doF.dow;
                        xVar13.amI();
                        Activity pageActivity = this.doF.getPageContext().getPageActivity();
                        String string3 = this.doF.getPageContext().getString(t.j.user_icon_intro);
                        str4 = NewSubPbActivity.dnv;
                        com.baidu.tbadk.browser.f.a(pageActivity, string3, String.valueOf(str4) + "?st_type=pb_user_icon", true, false, false);
                        return;
                    }
                }
            }
            xVar9 = this.doF.dow;
            xVar9.amI();
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
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.doF.getPageContext().getPageActivity(), str3, str2, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
                return;
            }
            return;
        }
        MessageManager messageManager = MessageManager.getInstance();
        PbActivityConfig pbActivityConfig = new PbActivityConfig(this.doF.getActivity());
        apVar6 = this.doF.dou;
        String threadID = apVar6.getThreadID();
        apVar7 = this.doF.dou;
        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig.createNormalCfg(threadID, apVar7.DH(), "")));
    }
}
