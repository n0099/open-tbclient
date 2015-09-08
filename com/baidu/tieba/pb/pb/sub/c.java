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
    final /* synthetic */ NewSubPbActivity cgV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(NewSubPbActivity newSubPbActivity) {
        this.cgV = newSubPbActivity;
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
        tVar = this.cgV.cgO;
        if (view == tVar.afo()) {
            tVar28 = this.cgV.cgO;
            tVar28.aeO();
            akVar8 = this.cgV.cgM;
            if (akVar8.Df()) {
                tVar29 = this.cgV.cgO;
                tVar29.afl();
                return;
            }
            return;
        }
        tVar2 = this.cgV.cgO;
        if (view != tVar2.afs()) {
            tVar3 = this.cgV.cgO;
            if (view == tVar3.afm()) {
                tVar27 = this.cgV.cgO;
                tVar27.aeO();
                this.cgV.replyPost(view);
                return;
            }
            tVar4 = this.cgV.cgO;
            if (tVar4.aft() != null) {
                tVar25 = this.cgV.cgO;
                if (view == tVar25.aft().aea()) {
                    tVar26 = this.cgV.cgO;
                    com.baidu.adp.lib.g.j.a(tVar26.afu(), this.cgV.getPageContext().getPageActivity());
                    if (this.cgV.checkUpIsLogin()) {
                        akVar4 = this.cgV.cgM;
                        if (akVar4.afD() != null) {
                            NewSubPbActivity newSubPbActivity = this.cgV;
                            akVar5 = this.cgV.cgM;
                            newSubPbActivity.b(akVar5.afD().adb());
                            return;
                        }
                        return;
                    }
                    return;
                }
            }
            tVar5 = this.cgV.cgO;
            if (tVar5.afu() != null) {
                tVar23 = this.cgV.cgO;
                if (view == tVar23.aft().aem()) {
                    tVar24 = this.cgV.cgO;
                    com.baidu.adp.lib.g.j.a(tVar24.afu(), this.cgV.getPageContext().getPageActivity());
                    if (!this.cgV.checkUpIsLogin()) {
                        return;
                    }
                    this.cgV.ab(view);
                    return;
                }
            }
            tVar6 = this.cgV.cgO;
            if (tVar6.aft() != null) {
                tVar21 = this.cgV.cgO;
                if (view == tVar21.aft().ael()) {
                    tVar22 = this.cgV.cgO;
                    tVar22.aeO();
                    if (this.cgV.checkUpIsLogin()) {
                        nVar4 = this.cgV.bWV;
                        nVar4.eZ(null);
                        return;
                    }
                    return;
                }
            }
            tVar7 = this.cgV.cgO;
            if (tVar7.aft() != null) {
                tVar19 = this.cgV.cgO;
                if (view == tVar19.aft().aen()) {
                    Object tag = view.getTag();
                    tVar20 = this.cgV.cgO;
                    com.baidu.adp.lib.g.j.a(tVar20.afu(), this.cgV.getPageContext().getPageActivity());
                    if (tag instanceof String) {
                        akVar3 = this.cgV.cgM;
                        String By = akVar3.By();
                        if (this.cgV.checkUpIsLogin()) {
                            this.cgV.jp(By);
                            return;
                        }
                        return;
                    } else if (tag instanceof SparseArray) {
                        SparseArray<Object> sparseArray = (SparseArray) tag;
                        if ((sparseArray.get(i.f.tag_display_reply_visible) instanceof Boolean) && ((Boolean) sparseArray.get(i.f.tag_display_reply_visible)).booleanValue()) {
                            sparseArray.put(i.f.tag_from, 0);
                            this.cgV.d(sparseArray);
                            return;
                        }
                        return;
                    } else {
                        return;
                    }
                }
            }
            tVar8 = this.cgV.cgO;
            if (view != tVar8.afv()) {
                tVar10 = this.cgV.cgO;
                if (view != tVar10.getUserNameView()) {
                    tVar11 = this.cgV.cgO;
                    if (view != tVar11.afw()) {
                        tVar13 = this.cgV.cgO;
                        if (view != tVar13.afx()) {
                            tVar14 = this.cgV.cgO;
                            if (view != tVar14.afy()) {
                                tVar15 = this.cgV.cgO;
                                if (view != tVar15.afr()) {
                                    tVar16 = this.cgV.cgO;
                                    if (view != tVar16.afB()) {
                                        tVar17 = this.cgV.cgO;
                                        if (view == tVar17.afA()) {
                                            akVar = this.cgV.cgM;
                                            if (akVar != null) {
                                                NewSubPbActivity newSubPbActivity2 = this.cgV;
                                                akVar2 = this.cgV.cgM;
                                                newSubPbActivity2.jy(akVar2.By());
                                                return;
                                            }
                                            return;
                                        }
                                        tVar18 = this.cgV.cgO;
                                        if (view == tVar18.afz()) {
                                            String string = TbadkCoreApplication.m411getInst().getString(i.h.tail_web_view_title);
                                            String string2 = com.baidu.tbadk.core.sharedPref.b.tx().getString("tail_link", "");
                                            if (!StringUtils.isNull(string2)) {
                                                com.baidu.tbadk.browser.g.a(view.getContext(), string, string2, true, true, true);
                                                return;
                                            }
                                            return;
                                        }
                                        return;
                                    }
                                }
                                if (this.cgV.checkUpIsLogin()) {
                                    nVar = this.cgV.bWV;
                                    if (nVar.BY()) {
                                        nVar3 = this.cgV.bWV;
                                        nVar3.BZ();
                                        return;
                                    }
                                    nVar2 = this.cgV.bWV;
                                    nVar2.eZ(null);
                                    return;
                                }
                                return;
                            }
                            this.cgV.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MemberPrivilegeActivityConfig(this.cgV.getPageContext().getPageActivity())));
                            return;
                        }
                    }
                    tVar12 = this.cgV.cgO;
                    tVar12.aeO();
                    Activity pageActivity = this.cgV.getPageContext().getPageActivity();
                    String string3 = this.cgV.getPageContext().getString(i.h.user_icon_intro);
                    str4 = NewSubPbActivity.cgj;
                    com.baidu.tbadk.browser.g.a(pageActivity, string3, String.valueOf(str4) + "?st_type=pb_user_icon", true, false, false);
                    return;
                }
            }
            tVar9 = this.cgV.cgO;
            tVar9.aeO();
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
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.cgV.getPageContext().getPageActivity(), str3, str2, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
                return;
            }
            return;
        }
        MessageManager messageManager = MessageManager.getInstance();
        PbActivityConfig pbActivityConfig = new PbActivityConfig(this.cgV.getActivity());
        akVar6 = this.cgV.cgM;
        String threadID = akVar6.getThreadID();
        akVar7 = this.cgV.cgM;
        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig.createNormalCfg(threadID, akVar7.By(), "")));
    }
}
