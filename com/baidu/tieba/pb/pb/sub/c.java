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
    final /* synthetic */ NewSubPbActivity cmr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(NewSubPbActivity newSubPbActivity) {
        this.cmr = newSubPbActivity;
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
        tVar = this.cmr.cmk;
        if (view == tVar.ahl()) {
            tVar28 = this.cmr.cmk;
            tVar28.agM();
            akVar8 = this.cmr.cmi;
            if (akVar8.CS()) {
                tVar29 = this.cmr.cmk;
                tVar29.ahi();
                return;
            }
            return;
        }
        tVar2 = this.cmr.cmk;
        if (view != tVar2.ahp()) {
            tVar3 = this.cmr.cmk;
            if (view == tVar3.ahj()) {
                tVar27 = this.cmr.cmk;
                tVar27.agM();
                this.cmr.replyPost(view);
                return;
            }
            tVar4 = this.cmr.cmk;
            if (tVar4.ahq() != null) {
                tVar25 = this.cmr.cmk;
                if (view == tVar25.ahq().afY()) {
                    tVar26 = this.cmr.cmk;
                    com.baidu.adp.lib.g.j.a(tVar26.ahr(), this.cmr.getPageContext().getPageActivity());
                    if (this.cmr.checkUpIsLogin()) {
                        akVar4 = this.cmr.cmi;
                        if (akVar4.ahA() != null) {
                            NewSubPbActivity newSubPbActivity = this.cmr;
                            akVar5 = this.cmr.cmi;
                            newSubPbActivity.c(akVar5.ahA().aeZ());
                            return;
                        }
                        return;
                    }
                    return;
                }
            }
            tVar5 = this.cmr.cmk;
            if (tVar5.ahr() != null) {
                tVar23 = this.cmr.cmk;
                if (view == tVar23.ahq().agk()) {
                    tVar24 = this.cmr.cmk;
                    com.baidu.adp.lib.g.j.a(tVar24.ahr(), this.cmr.getPageContext().getPageActivity());
                    if (!this.cmr.checkUpIsLogin()) {
                        return;
                    }
                    this.cmr.ad(view);
                    return;
                }
            }
            tVar6 = this.cmr.cmk;
            if (tVar6.ahq() != null) {
                tVar21 = this.cmr.cmk;
                if (view == tVar21.ahq().agj()) {
                    tVar22 = this.cmr.cmk;
                    tVar22.agM();
                    if (this.cmr.checkUpIsLogin()) {
                        nVar4 = this.cmr.caJ;
                        nVar4.fe(null);
                        return;
                    }
                    return;
                }
            }
            tVar7 = this.cmr.cmk;
            if (tVar7.ahq() != null) {
                tVar19 = this.cmr.cmk;
                if (view == tVar19.ahq().agl()) {
                    Object tag = view.getTag();
                    tVar20 = this.cmr.cmk;
                    com.baidu.adp.lib.g.j.a(tVar20.ahr(), this.cmr.getPageContext().getPageActivity());
                    if (tag instanceof String) {
                        akVar3 = this.cmr.cmi;
                        String Bl = akVar3.Bl();
                        if (this.cmr.checkUpIsLogin()) {
                            this.cmr.jI(Bl);
                            return;
                        }
                        return;
                    } else if (tag instanceof SparseArray) {
                        SparseArray<Object> sparseArray = (SparseArray) tag;
                        if ((sparseArray.get(i.f.tag_display_reply_visible) instanceof Boolean) && ((Boolean) sparseArray.get(i.f.tag_display_reply_visible)).booleanValue()) {
                            sparseArray.put(i.f.tag_from, 0);
                            this.cmr.d(sparseArray);
                            return;
                        }
                        return;
                    } else {
                        return;
                    }
                }
            }
            tVar8 = this.cmr.cmk;
            if (view != tVar8.ahs()) {
                tVar10 = this.cmr.cmk;
                if (view != tVar10.getUserNameView()) {
                    tVar11 = this.cmr.cmk;
                    if (view != tVar11.aht()) {
                        tVar13 = this.cmr.cmk;
                        if (view != tVar13.ahu()) {
                            tVar14 = this.cmr.cmk;
                            if (view != tVar14.ahv()) {
                                tVar15 = this.cmr.cmk;
                                if (view != tVar15.aho()) {
                                    tVar16 = this.cmr.cmk;
                                    if (view != tVar16.ahy()) {
                                        tVar17 = this.cmr.cmk;
                                        if (view == tVar17.ahx()) {
                                            akVar = this.cmr.cmi;
                                            if (akVar != null) {
                                                NewSubPbActivity newSubPbActivity2 = this.cmr;
                                                akVar2 = this.cmr.cmi;
                                                newSubPbActivity2.jS(akVar2.Bl());
                                                return;
                                            }
                                            return;
                                        }
                                        tVar18 = this.cmr.cmk;
                                        if (view == tVar18.ahw()) {
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
                                if (this.cmr.checkUpIsLogin()) {
                                    nVar = this.cmr.caJ;
                                    if (nVar.BL()) {
                                        nVar3 = this.cmr.caJ;
                                        nVar3.BM();
                                        return;
                                    }
                                    nVar2 = this.cmr.caJ;
                                    nVar2.fe(null);
                                    return;
                                }
                                return;
                            }
                            this.cmr.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MemberPrivilegeActivityConfig(this.cmr.getPageContext().getPageActivity())));
                            return;
                        }
                    }
                    tVar12 = this.cmr.cmk;
                    tVar12.agM();
                    Activity pageActivity = this.cmr.getPageContext().getPageActivity();
                    String string3 = this.cmr.getPageContext().getString(i.h.user_icon_intro);
                    str4 = NewSubPbActivity.clB;
                    com.baidu.tbadk.browser.g.a(pageActivity, string3, String.valueOf(str4) + "?st_type=pb_user_icon", true, false, false);
                    return;
                }
            }
            tVar9 = this.cmr.cmk;
            tVar9.agM();
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
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.cmr.getPageContext().getPageActivity(), str3, str2, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
                return;
            }
            return;
        }
        MessageManager messageManager = MessageManager.getInstance();
        PbActivityConfig pbActivityConfig = new PbActivityConfig(this.cmr.getActivity());
        akVar6 = this.cmr.cmi;
        String threadID = akVar6.getThreadID();
        akVar7 = this.cmr.cmi;
        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig.createNormalCfg(threadID, akVar7.Bl(), "")));
    }
}
