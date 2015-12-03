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
    final /* synthetic */ NewSubPbActivity cHd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(NewSubPbActivity newSubPbActivity) {
        this.cHd = newSubPbActivity;
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
        an anVar;
        an anVar2;
        w wVar19;
        w wVar20;
        an anVar3;
        w wVar21;
        w wVar22;
        com.baidu.tbadk.editortools.d.p pVar4;
        w wVar23;
        w wVar24;
        w wVar25;
        w wVar26;
        an anVar4;
        an anVar5;
        w wVar27;
        an anVar6;
        an anVar7;
        w wVar28;
        an anVar8;
        w wVar29;
        wVar = this.cHd.cGU;
        if (view == wVar.amq()) {
            wVar28 = this.cHd.cGU;
            wVar28.alO();
            anVar8 = this.cHd.cGS;
            if (anVar8.DJ()) {
                wVar29 = this.cHd.cGU;
                wVar29.amn();
                return;
            }
            return;
        }
        wVar2 = this.cHd.cGU;
        if (view != wVar2.amu()) {
            wVar3 = this.cHd.cGU;
            if (view == wVar3.amo()) {
                wVar27 = this.cHd.cGU;
                wVar27.alO();
                this.cHd.replyPost(view);
                return;
            }
            wVar4 = this.cHd.cGU;
            if (wVar4.amv() != null) {
                wVar25 = this.cHd.cGU;
                if (view == wVar25.amv().akU()) {
                    wVar26 = this.cHd.cGU;
                    com.baidu.adp.lib.h.j.a(wVar26.amw(), this.cHd.getPageContext().getPageActivity());
                    if (this.cHd.checkUpIsLogin()) {
                        anVar4 = this.cHd.cGS;
                        if (anVar4.amF() != null) {
                            NewSubPbActivity newSubPbActivity = this.cHd;
                            anVar5 = this.cHd.cGS;
                            newSubPbActivity.c(anVar5.amF().ajK());
                            return;
                        }
                        return;
                    }
                    return;
                }
            }
            wVar5 = this.cHd.cGU;
            if (wVar5.amw() != null) {
                wVar23 = this.cHd.cGU;
                if (view == wVar23.amv().alj()) {
                    wVar24 = this.cHd.cGU;
                    com.baidu.adp.lib.h.j.a(wVar24.amw(), this.cHd.getPageContext().getPageActivity());
                    if (!this.cHd.checkUpIsLogin()) {
                        return;
                    }
                    this.cHd.al(view);
                    return;
                }
            }
            wVar6 = this.cHd.cGU;
            if (wVar6.amv() != null) {
                wVar21 = this.cHd.cGU;
                if (view == wVar21.amv().ali()) {
                    wVar22 = this.cHd.cGU;
                    wVar22.alO();
                    if (this.cHd.checkUpIsLogin()) {
                        pVar4 = this.cHd.ceY;
                        pVar4.fv(null);
                        return;
                    }
                    return;
                }
            }
            wVar7 = this.cHd.cGU;
            if (wVar7.amv() != null) {
                wVar19 = this.cHd.cGU;
                if (view == wVar19.amv().alk()) {
                    Object tag = view.getTag();
                    wVar20 = this.cHd.cGU;
                    com.baidu.adp.lib.h.j.a(wVar20.amw(), this.cHd.getPageContext().getPageActivity());
                    if (tag instanceof String) {
                        anVar3 = this.cHd.cGS;
                        String BU = anVar3.BU();
                        if (this.cHd.checkUpIsLogin()) {
                            this.cHd.kz(BU);
                            return;
                        }
                        return;
                    } else if (tag instanceof SparseArray) {
                        SparseArray<Object> sparseArray = (SparseArray) tag;
                        if ((sparseArray.get(n.f.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray.get(n.f.tag_user_mute_visible)).booleanValue()) {
                            sparseArray.put(n.f.tag_from, 0);
                            this.cHd.d(sparseArray);
                            return;
                        }
                        return;
                    } else {
                        return;
                    }
                }
            }
            wVar8 = this.cHd.cGU;
            if (view != wVar8.amx()) {
                wVar10 = this.cHd.cGU;
                if (view != wVar10.getUserNameView()) {
                    wVar11 = this.cHd.cGU;
                    if (view != wVar11.amy()) {
                        wVar13 = this.cHd.cGU;
                        if (view != wVar13.amz()) {
                            wVar14 = this.cHd.cGU;
                            if (view != wVar14.amA()) {
                                wVar15 = this.cHd.cGU;
                                if (view != wVar15.amt()) {
                                    wVar16 = this.cHd.cGU;
                                    if (view != wVar16.amD()) {
                                        wVar17 = this.cHd.cGU;
                                        if (view == wVar17.amC()) {
                                            anVar = this.cHd.cGS;
                                            if (anVar != null) {
                                                NewSubPbActivity newSubPbActivity2 = this.cHd;
                                                anVar2 = this.cHd.cGS;
                                                newSubPbActivity2.kN(anVar2.BU());
                                                return;
                                            }
                                            return;
                                        }
                                        wVar18 = this.cHd.cGU;
                                        if (view == wVar18.amB()) {
                                            String string = TbadkCoreApplication.m411getInst().getString(n.i.tail_web_view_title);
                                            String string2 = com.baidu.tbadk.core.sharedPref.b.tZ().getString("tail_link", "");
                                            if (!StringUtils.isNull(string2)) {
                                                com.baidu.tbadk.browser.f.a(view.getContext(), string, string2, true, true, true);
                                                return;
                                            }
                                            return;
                                        }
                                        return;
                                    }
                                }
                                if (this.cHd.checkUpIsLogin()) {
                                    pVar = this.cHd.ceY;
                                    if (pVar.CC()) {
                                        pVar3 = this.cHd.ceY;
                                        pVar3.CD();
                                        return;
                                    }
                                    pVar2 = this.cHd.ceY;
                                    pVar2.fv(null);
                                    return;
                                }
                                return;
                            }
                            String str5 = view.getTag() != null ? (String) view.getTag() : null;
                            if (bj.ah(this.cHd.getActivity())) {
                                if (!StringUtils.isNull(str5) && !str5.startsWith("vipcenter:") && !str5.startsWith("membercenter:")) {
                                    com.baidu.tbadk.browser.f.f(this.cHd.getActivity(), this.cHd.getActivity().getResources().getString(n.i.membercenter_title), str5);
                                    return;
                                } else {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MembercenterActivityConfig(this.cHd.getActivity())));
                                    return;
                                }
                            }
                            return;
                        }
                    }
                    wVar12 = this.cHd.cGU;
                    wVar12.alO();
                    Activity pageActivity = this.cHd.getPageContext().getPageActivity();
                    String string3 = this.cHd.getPageContext().getString(n.i.user_icon_intro);
                    str4 = NewSubPbActivity.cGm;
                    com.baidu.tbadk.browser.f.a(pageActivity, string3, String.valueOf(str4) + "?st_type=pb_user_icon", true, false, false);
                    return;
                }
            }
            wVar9 = this.cHd.cGU;
            wVar9.alO();
            if (view instanceof HeadImageView) {
                String userId = ((HeadImageView) view).getUserId();
                str2 = ((HeadImageView) view).getUserName();
                str3 = userId;
            } else {
                if (view.getTag(n.f.tag_user_id) instanceof String) {
                    str = (String) view.getTag(n.f.tag_user_id);
                } else {
                    str = view.getTag() instanceof String ? (String) view.getTag() : null;
                }
                if (view.getTag(n.f.tag_user_name) instanceof String) {
                    str2 = (String) view.getTag(n.f.tag_user_name);
                    str3 = str;
                } else {
                    str2 = null;
                    str3 = str;
                }
            }
            if (str3 != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.cHd.getPageContext().getPageActivity(), str3, str2, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
                return;
            }
            return;
        }
        MessageManager messageManager = MessageManager.getInstance();
        PbActivityConfig pbActivityConfig = new PbActivityConfig(this.cHd.getActivity());
        anVar6 = this.cHd.cGS;
        String threadID = anVar6.getThreadID();
        anVar7 = this.cHd.cGS;
        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig.createNormalCfg(threadID, anVar7.BU(), "")));
    }
}
