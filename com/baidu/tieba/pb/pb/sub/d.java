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
import com.baidu.tbadk.core.util.bi;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ NewSubPbActivity cTK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(NewSubPbActivity newSubPbActivity) {
        this.cTK = newSubPbActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        w wVar;
        w wVar2;
        w wVar3;
        w wVar4;
        w wVar5;
        w wVar6;
        w wVar7;
        w wVar8;
        w wVar9;
        String str;
        String str2;
        String str3;
        w wVar10;
        w wVar11;
        w wVar12;
        w wVar13;
        String str4;
        w wVar14;
        w wVar15;
        w wVar16;
        com.baidu.tbadk.editortools.d.p pVar;
        com.baidu.tbadk.editortools.d.p pVar2;
        com.baidu.tbadk.editortools.d.p pVar3;
        w wVar17;
        w wVar18;
        w wVar19;
        ao aoVar;
        ao aoVar2;
        w wVar20;
        w wVar21;
        ao aoVar3;
        w wVar22;
        w wVar23;
        com.baidu.tbadk.editortools.d.p pVar4;
        w wVar24;
        w wVar25;
        w wVar26;
        w wVar27;
        ao aoVar4;
        ao aoVar5;
        w wVar28;
        ao aoVar6;
        ao aoVar7;
        w wVar29;
        ao aoVar8;
        w wVar30;
        wVar = this.cTK.cTB;
        if (view == wVar.asf()) {
            wVar29 = this.cTK.cTB;
            wVar29.ajp();
            aoVar8 = this.cTK.cTz;
            if (aoVar8.ET()) {
                wVar30 = this.cTK.cTB;
                wVar30.asc();
                return;
            }
            return;
        }
        wVar2 = this.cTK.cTB;
        if (view != wVar2.asj()) {
            wVar3 = this.cTK.cTB;
            if (view == wVar3.asd()) {
                wVar28 = this.cTK.cTB;
                wVar28.ajp();
                this.cTK.replyPost(view);
                return;
            }
            wVar4 = this.cTK.cTB;
            if (wVar4.ask() != null) {
                wVar26 = this.cTK.cTB;
                if (view == wVar26.ask().aql()) {
                    wVar27 = this.cTK.cTB;
                    com.baidu.adp.lib.h.j.a(wVar27.asl(), this.cTK.getPageContext().getPageActivity());
                    if (this.cTK.checkUpIsLogin()) {
                        aoVar4 = this.cTK.cTz;
                        if (aoVar4.asw() != null) {
                            NewSubPbActivity newSubPbActivity = this.cTK;
                            aoVar5 = this.cTK.cTz;
                            newSubPbActivity.d(aoVar5.asw().aoQ());
                            return;
                        }
                        return;
                    }
                    return;
                }
            }
            wVar5 = this.cTK.cTB;
            if (wVar5.asl() != null) {
                wVar24 = this.cTK.cTB;
                if (view == wVar24.ask().aqP()) {
                    wVar25 = this.cTK.cTB;
                    com.baidu.adp.lib.h.j.a(wVar25.asl(), this.cTK.getPageContext().getPageActivity());
                    if (!this.cTK.checkUpIsLogin()) {
                        return;
                    }
                    this.cTK.aG(view);
                    return;
                }
            }
            wVar6 = this.cTK.cTB;
            if (wVar6.ask() != null) {
                wVar22 = this.cTK.cTB;
                if (view == wVar22.ask().aqO()) {
                    wVar23 = this.cTK.cTB;
                    wVar23.ajp();
                    if (this.cTK.checkUpIsLogin()) {
                        pVar4 = this.cTK.cnC;
                        pVar4.fx(null);
                        return;
                    }
                    return;
                }
            }
            wVar7 = this.cTK.cTB;
            if (wVar7.ask() != null) {
                wVar20 = this.cTK.cTB;
                if (view == wVar20.ask().aqQ()) {
                    Object tag = view.getTag();
                    wVar21 = this.cTK.cTB;
                    com.baidu.adp.lib.h.j.a(wVar21.asl(), this.cTK.getPageContext().getPageActivity());
                    if (tag instanceof String) {
                        aoVar3 = this.cTK.cTz;
                        String CZ = aoVar3.CZ();
                        if (this.cTK.checkUpIsLogin()) {
                            this.cTK.kA(CZ);
                            return;
                        }
                        return;
                    } else if (tag instanceof SparseArray) {
                        SparseArray<Object> sparseArray = (SparseArray) tag;
                        if ((sparseArray.get(t.g.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray.get(t.g.tag_user_mute_visible)).booleanValue()) {
                            sparseArray.put(t.g.tag_from, 0);
                            this.cTK.d(sparseArray);
                            return;
                        }
                        return;
                    } else {
                        return;
                    }
                }
            }
            wVar8 = this.cTK.cTB;
            if (view != wVar8.asm()) {
                wVar10 = this.cTK.cTB;
                if (view != wVar10.getUserNameView()) {
                    wVar11 = this.cTK.cTB;
                    if (view != wVar11.asn()) {
                        wVar12 = this.cTK.cTB;
                        if (view != wVar12.aso()) {
                            wVar14 = this.cTK.cTB;
                            if (view != wVar14.asp()) {
                                wVar15 = this.cTK.cTB;
                                if (view != wVar15.asq()) {
                                    wVar16 = this.cTK.cTB;
                                    if (view != wVar16.asi()) {
                                        wVar17 = this.cTK.cTB;
                                        if (view != wVar17.asu()) {
                                            wVar18 = this.cTK.cTB;
                                            if (view == wVar18.ast()) {
                                                aoVar = this.cTK.cTz;
                                                if (aoVar != null) {
                                                    NewSubPbActivity newSubPbActivity2 = this.cTK;
                                                    aoVar2 = this.cTK.cTz;
                                                    newSubPbActivity2.kR(aoVar2.CZ());
                                                    return;
                                                }
                                                return;
                                            }
                                            wVar19 = this.cTK.cTB;
                                            if (view == wVar19.asr()) {
                                                String string = TbadkCoreApplication.m411getInst().getString(t.j.tail_web_view_title);
                                                String string2 = com.baidu.tbadk.core.sharedPref.b.uO().getString("tail_link", "");
                                                if (!StringUtils.isNull(string2)) {
                                                    com.baidu.tbadk.browser.f.a(view.getContext(), string, string2, true, true, true);
                                                    return;
                                                }
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                    if (this.cTK.checkUpIsLogin()) {
                                        pVar = this.cTK.cnC;
                                        if (pVar.DH()) {
                                            pVar3 = this.cTK.cnC;
                                            pVar3.DI();
                                            return;
                                        }
                                        pVar2 = this.cTK.cnC;
                                        pVar2.fx(null);
                                        return;
                                    }
                                    return;
                                }
                                String str5 = view.getTag() != null ? (String) view.getTag() : null;
                                if (bi.ah(this.cTK.getActivity())) {
                                    if (!StringUtils.isNull(str5) && !str5.startsWith("vipcenter:") && !str5.startsWith("membercenter:")) {
                                        com.baidu.tbadk.browser.f.f(this.cTK.getActivity(), this.cTK.getActivity().getResources().getString(t.j.membercenter_title), str5);
                                        return;
                                    } else {
                                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MembercenterActivityConfig(this.cTK.getActivity())));
                                        return;
                                    }
                                }
                                return;
                            }
                        }
                        wVar13 = this.cTK.cTB;
                        wVar13.ajp();
                        Activity pageActivity = this.cTK.getPageContext().getPageActivity();
                        String string3 = this.cTK.getPageContext().getString(t.j.user_icon_intro);
                        str4 = NewSubPbActivity.cSD;
                        com.baidu.tbadk.browser.f.a(pageActivity, string3, String.valueOf(str4) + "?st_type=pb_user_icon", true, false, false);
                        return;
                    }
                }
            }
            wVar9 = this.cTK.cTB;
            wVar9.ajp();
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
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.cTK.getPageContext().getPageActivity(), str3, str2, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
                return;
            }
            return;
        }
        MessageManager messageManager = MessageManager.getInstance();
        PbActivityConfig pbActivityConfig = new PbActivityConfig(this.cTK.getActivity());
        aoVar6 = this.cTK.cTz;
        String threadID = aoVar6.getThreadID();
        aoVar7 = this.cTK.cTz;
        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig.createNormalCfg(threadID, aoVar7.CZ(), "")));
    }
}
