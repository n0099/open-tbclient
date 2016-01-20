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
import com.baidu.tbadk.core.util.bj;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ NewSubPbActivity cLc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(NewSubPbActivity newSubPbActivity) {
        this.cLc = newSubPbActivity;
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
        String str4;
        w wVar13;
        w wVar14;
        w wVar15;
        com.baidu.tbadk.editortools.d.p pVar;
        com.baidu.tbadk.editortools.d.p pVar2;
        com.baidu.tbadk.editortools.d.p pVar3;
        w wVar16;
        w wVar17;
        w wVar18;
        ao aoVar;
        ao aoVar2;
        w wVar19;
        w wVar20;
        ao aoVar3;
        w wVar21;
        w wVar22;
        com.baidu.tbadk.editortools.d.p pVar4;
        w wVar23;
        w wVar24;
        w wVar25;
        w wVar26;
        ao aoVar4;
        ao aoVar5;
        w wVar27;
        ao aoVar6;
        ao aoVar7;
        w wVar28;
        ao aoVar8;
        w wVar29;
        wVar = this.cLc.cKT;
        if (view == wVar.anC()) {
            wVar28 = this.cLc.cKT;
            wVar28.ana();
            aoVar8 = this.cLc.cKR;
            if (aoVar8.Dy()) {
                wVar29 = this.cLc.cKT;
                wVar29.anz();
                return;
            }
            return;
        }
        wVar2 = this.cLc.cKT;
        if (view != wVar2.anG()) {
            wVar3 = this.cLc.cKT;
            if (view == wVar3.anA()) {
                wVar27 = this.cLc.cKT;
                wVar27.ana();
                this.cLc.replyPost(view);
                return;
            }
            wVar4 = this.cLc.cKT;
            if (wVar4.anH() != null) {
                wVar25 = this.cLc.cKT;
                if (view == wVar25.anH().amf()) {
                    wVar26 = this.cLc.cKT;
                    com.baidu.adp.lib.h.j.a(wVar26.anI(), this.cLc.getPageContext().getPageActivity());
                    if (this.cLc.checkUpIsLogin()) {
                        aoVar4 = this.cLc.cKR;
                        if (aoVar4.anR() != null) {
                            NewSubPbActivity newSubPbActivity = this.cLc;
                            aoVar5 = this.cLc.cKR;
                            newSubPbActivity.c(aoVar5.anR().akS());
                            return;
                        }
                        return;
                    }
                    return;
                }
            }
            wVar5 = this.cLc.cKT;
            if (wVar5.anI() != null) {
                wVar23 = this.cLc.cKT;
                if (view == wVar23.anH().amv()) {
                    wVar24 = this.cLc.cKT;
                    com.baidu.adp.lib.h.j.a(wVar24.anI(), this.cLc.getPageContext().getPageActivity());
                    if (!this.cLc.checkUpIsLogin()) {
                        return;
                    }
                    this.cLc.aq(view);
                    return;
                }
            }
            wVar6 = this.cLc.cKT;
            if (wVar6.anH() != null) {
                wVar21 = this.cLc.cKT;
                if (view == wVar21.anH().amu()) {
                    wVar22 = this.cLc.cKT;
                    wVar22.ana();
                    if (this.cLc.checkUpIsLogin()) {
                        pVar4 = this.cLc.cjc;
                        pVar4.fz(null);
                        return;
                    }
                    return;
                }
            }
            wVar7 = this.cLc.cKT;
            if (wVar7.anH() != null) {
                wVar19 = this.cLc.cKT;
                if (view == wVar19.anH().amw()) {
                    Object tag = view.getTag();
                    wVar20 = this.cLc.cKT;
                    com.baidu.adp.lib.h.j.a(wVar20.anI(), this.cLc.getPageContext().getPageActivity());
                    if (tag instanceof String) {
                        aoVar3 = this.cLc.cKR;
                        String BJ = aoVar3.BJ();
                        if (this.cLc.checkUpIsLogin()) {
                            this.cLc.kw(BJ);
                            return;
                        }
                        return;
                    } else if (tag instanceof SparseArray) {
                        SparseArray<Object> sparseArray = (SparseArray) tag;
                        if ((sparseArray.get(n.g.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray.get(n.g.tag_user_mute_visible)).booleanValue()) {
                            sparseArray.put(n.g.tag_from, 0);
                            this.cLc.d(sparseArray);
                            return;
                        }
                        return;
                    } else {
                        return;
                    }
                }
            }
            wVar8 = this.cLc.cKT;
            if (view != wVar8.anJ()) {
                wVar10 = this.cLc.cKT;
                if (view != wVar10.getUserNameView()) {
                    wVar11 = this.cLc.cKT;
                    if (view != wVar11.anK()) {
                        wVar13 = this.cLc.cKT;
                        if (view != wVar13.anL()) {
                            wVar14 = this.cLc.cKT;
                            if (view != wVar14.anM()) {
                                wVar15 = this.cLc.cKT;
                                if (view != wVar15.anF()) {
                                    wVar16 = this.cLc.cKT;
                                    if (view != wVar16.anP()) {
                                        wVar17 = this.cLc.cKT;
                                        if (view == wVar17.anO()) {
                                            aoVar = this.cLc.cKR;
                                            if (aoVar != null) {
                                                NewSubPbActivity newSubPbActivity2 = this.cLc;
                                                aoVar2 = this.cLc.cKR;
                                                newSubPbActivity2.kL(aoVar2.BJ());
                                                return;
                                            }
                                            return;
                                        }
                                        wVar18 = this.cLc.cKT;
                                        if (view == wVar18.anN()) {
                                            String string = TbadkCoreApplication.m411getInst().getString(n.j.tail_web_view_title);
                                            String string2 = com.baidu.tbadk.core.sharedPref.b.tJ().getString("tail_link", "");
                                            if (!StringUtils.isNull(string2)) {
                                                com.baidu.tbadk.browser.f.a(view.getContext(), string, string2, true, true, true);
                                                return;
                                            }
                                            return;
                                        }
                                        return;
                                    }
                                }
                                if (this.cLc.checkUpIsLogin()) {
                                    pVar = this.cLc.cjc;
                                    if (pVar.Cr()) {
                                        pVar3 = this.cLc.cjc;
                                        pVar3.Cs();
                                        return;
                                    }
                                    pVar2 = this.cLc.cjc;
                                    pVar2.fz(null);
                                    return;
                                }
                                return;
                            }
                            String str5 = view.getTag() != null ? (String) view.getTag() : null;
                            if (bj.ah(this.cLc.getActivity())) {
                                if (!StringUtils.isNull(str5) && !str5.startsWith("vipcenter:") && !str5.startsWith("membercenter:")) {
                                    com.baidu.tbadk.browser.f.f(this.cLc.getActivity(), this.cLc.getActivity().getResources().getString(n.j.membercenter_title), str5);
                                    return;
                                } else {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MembercenterActivityConfig(this.cLc.getActivity())));
                                    return;
                                }
                            }
                            return;
                        }
                    }
                    wVar12 = this.cLc.cKT;
                    wVar12.ana();
                    Activity pageActivity = this.cLc.getPageContext().getPageActivity();
                    String string3 = this.cLc.getPageContext().getString(n.j.user_icon_intro);
                    str4 = NewSubPbActivity.cKl;
                    com.baidu.tbadk.browser.f.a(pageActivity, string3, String.valueOf(str4) + "?st_type=pb_user_icon", true, false, false);
                    return;
                }
            }
            wVar9 = this.cLc.cKT;
            wVar9.ana();
            if (view instanceof HeadImageView) {
                String userId = ((HeadImageView) view).getUserId();
                str2 = ((HeadImageView) view).getUserName();
                str3 = userId;
            } else {
                if (view.getTag(n.g.tag_user_id) instanceof String) {
                    str = (String) view.getTag(n.g.tag_user_id);
                } else {
                    str = view.getTag() instanceof String ? (String) view.getTag() : null;
                }
                if (view.getTag(n.g.tag_user_name) instanceof String) {
                    str2 = (String) view.getTag(n.g.tag_user_name);
                    str3 = str;
                } else {
                    str2 = null;
                    str3 = str;
                }
            }
            if (str3 != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.cLc.getPageContext().getPageActivity(), str3, str2, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
                return;
            }
            return;
        }
        MessageManager messageManager = MessageManager.getInstance();
        PbActivityConfig pbActivityConfig = new PbActivityConfig(this.cLc.getActivity());
        aoVar6 = this.cLc.cKR;
        String threadID = aoVar6.getThreadID();
        aoVar7 = this.cLc.cKR;
        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig.createNormalCfg(threadID, aoVar7.BJ(), "")));
    }
}
