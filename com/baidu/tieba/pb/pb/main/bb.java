package com.baidu.tieba.pb.pb.main;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.AdditionData;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.MorePopupWindow;
import java.util.ArrayList;
/* loaded from: classes.dex */
class bb implements View.OnClickListener {
    final /* synthetic */ PbActivity bIJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(PbActivity pbActivity) {
        this.bIJ = pbActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v31, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Code restructure failed: missing block: B:228:0x0af2, code lost:
        if (r21 != r1.aaB()) goto L289;
     */
    /* JADX WARN: Code restructure failed: missing block: B:286:0x0d4a, code lost:
        if (r1 == null) goto L368;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x01f1, code lost:
        if (r1 == null) goto L75;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:73:0x027a  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x02bf  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0379  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x03b6  */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onClick(View view) {
        cj cjVar;
        cj cjVar2;
        cj cjVar3;
        cj cjVar4;
        br brVar;
        com.baidu.tieba.tbadkCore.h.a aVar;
        cj cjVar5;
        cj cjVar6;
        cj cjVar7;
        cj cjVar8;
        cj cjVar9;
        cj cjVar10;
        br brVar2;
        br brVar3;
        com.baidu.tieba.tbadkCore.h.a aVar2;
        cj cjVar11;
        cj cjVar12;
        cj cjVar13;
        cj cjVar14;
        cj cjVar15;
        cj cjVar16;
        cj cjVar17;
        cj cjVar18;
        cj cjVar19;
        cj cjVar20;
        cj cjVar21;
        cj cjVar22;
        cj cjVar23;
        cj cjVar24;
        cj cjVar25;
        cj cjVar26;
        cj cjVar27;
        cj cjVar28;
        ci ciVar;
        ci ciVar2;
        cj cjVar29;
        ci ciVar3;
        ci ciVar4;
        br brVar4;
        br brVar5;
        br brVar6;
        br brVar7;
        br brVar8;
        br brVar9;
        cj cjVar30;
        cj cjVar31;
        br brVar10;
        com.baidu.tieba.pb.pb.sub.e eVar;
        cj cjVar32;
        com.baidu.tieba.pb.pb.sub.e eVar2;
        cj cjVar33;
        MorePopupWindow morePopupWindow;
        MorePopupWindow morePopupWindow2;
        br brVar11;
        ci ciVar5;
        ci ciVar6;
        ci ciVar7;
        MorePopupWindow morePopupWindow3;
        MorePopupWindow morePopupWindow4;
        ci ciVar8;
        ci ciVar9;
        br brVar12;
        ci ciVar10;
        ci ciVar11;
        boolean z;
        ci ciVar12;
        boolean dE;
        ci ciVar13;
        ci ciVar14;
        ci ciVar15;
        ci ciVar16;
        ci ciVar17;
        ci ciVar18;
        ci ciVar19;
        MorePopupWindow morePopupWindow5;
        ci ciVar20;
        cj cjVar34;
        br brVar13;
        cj cjVar35;
        cj cjVar36;
        cj cjVar37;
        br brVar14;
        cj cjVar38;
        ci ciVar21;
        br brVar15;
        cj cjVar39;
        br brVar16;
        com.baidu.tieba.pb.pb.sub.e eVar3;
        br brVar17;
        com.baidu.tieba.pb.pb.sub.e eVar4;
        com.baidu.tieba.pb.pb.sub.e eVar5;
        ci ciVar22;
        Handler handler;
        cj cjVar40;
        br brVar18;
        ci ciVar23;
        MorePopupWindow morePopupWindow6;
        cj cjVar41;
        br brVar19;
        ci ciVar24;
        ci ciVar25;
        MorePopupWindow morePopupWindow7;
        cj cjVar42;
        ci ciVar26;
        cj cjVar43;
        cj cjVar44;
        ci ciVar27;
        cj cjVar45;
        MorePopupWindow morePopupWindow8;
        cj cjVar46;
        ci ciVar28;
        MorePopupWindow morePopupWindow9;
        ci ciVar29;
        MorePopupWindow morePopupWindow10;
        cj cjVar47;
        br brVar20;
        br brVar21;
        br brVar22;
        cj cjVar48;
        br brVar23;
        br brVar24;
        br brVar25;
        cj cjVar49;
        cj cjVar50;
        cj cjVar51;
        br brVar26;
        cj cjVar52;
        cj cjVar53;
        br brVar27;
        cj cjVar54;
        br brVar28;
        cj cjVar55;
        cj cjVar56;
        cj cjVar57;
        cj cjVar58;
        boolean hj;
        br brVar29;
        cj cjVar59;
        br brVar30;
        br brVar31;
        br brVar32;
        br brVar33;
        br brVar34;
        br brVar35;
        boolean z2;
        cj cjVar60;
        cj cjVar61;
        cj cjVar62;
        br brVar36;
        br brVar37;
        br brVar38;
        br brVar39;
        br brVar40;
        br brVar41;
        br brVar42;
        br brVar43;
        com.baidu.tieba.pb.pb.sub.e eVar6;
        com.baidu.tieba.pb.pb.sub.e eVar7;
        com.baidu.tieba.pb.pb.sub.e eVar8;
        com.baidu.tieba.pb.pb.sub.e eVar9;
        cj cjVar63;
        MorePopupWindow morePopupWindow11;
        br brVar44;
        boolean z3;
        ci ciVar30;
        ci ciVar31;
        ci ciVar32;
        MorePopupWindow morePopupWindow12;
        MorePopupWindow morePopupWindow13;
        SparseArray sparseArray;
        ci ciVar33;
        ci ciVar34;
        ci ciVar35;
        ci ciVar36;
        ci ciVar37;
        ci ciVar38;
        ci ciVar39;
        br brVar45;
        br brVar46;
        ci ciVar40;
        ci ciVar41;
        br brVar47;
        br brVar48;
        cj cjVar64;
        br brVar49;
        br brVar50;
        cj cjVar65;
        cjVar = this.bIJ.bIl;
        if (view == cjVar.getNextView()) {
            brVar50 = this.bIJ.bIg;
            if (brVar50.dK(true)) {
                cjVar65 = this.bIJ.bIl;
                cjVar65.aaY();
                return;
            }
            return;
        }
        cjVar2 = this.bIJ.bIl;
        if (view == cjVar2.bLc.bbo) {
            cjVar64 = this.bIJ.bIl;
            brVar49 = this.bIJ.bIg;
            if (!cjVar64.dV(brVar49.aae())) {
                this.bIJ.finish();
                return;
            } else {
                this.bIJ.stopVoice();
                return;
            }
        }
        cjVar3 = this.bIJ.bIl;
        if (view != cjVar3.abw()) {
            cjVar12 = this.bIJ.bIl;
            if (view != cjVar12.abx()) {
                cjVar13 = this.bIJ.bIl;
                if (view != cjVar13.aby()) {
                    cjVar14 = this.bIJ.bIl;
                    if (view != cjVar14.abz()) {
                        cjVar15 = this.bIJ.bIl;
                        if (view != cjVar15.aaU()) {
                            cjVar16 = this.bIJ.bIl;
                            if (view == cjVar16.abI()) {
                                brVar47 = this.bIJ.bIg;
                                if (brVar47 != null) {
                                    brVar48 = this.bIJ.bIg;
                                    com.baidu.tbadk.browser.f.x(this.bIJ.getPageContext().getPageActivity(), brVar48.getPbData().Zb().qD().getLink());
                                    return;
                                }
                                return;
                            }
                            cjVar17 = this.bIJ.bIl;
                            if (view != cjVar17.abA()) {
                                cjVar18 = this.bIJ.bIl;
                                if (view == cjVar18.aaW()) {
                                    eVar9 = this.bIJ.bIj;
                                    if (eVar9.AZ()) {
                                        cjVar63 = this.bIJ.bIl;
                                        cjVar63.abe();
                                        return;
                                    }
                                    return;
                                }
                                cjVar19 = this.bIJ.bIl;
                                if (view == cjVar19.aaQ()) {
                                    eVar6 = this.bIJ.bIj;
                                    if (eVar6 != null) {
                                        eVar7 = this.bIJ.bIj;
                                        if (eVar7.aaa() != null) {
                                            PbActivity pbActivity = this.bIJ;
                                            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.bIJ.getPageContext().getPageActivity());
                                            eVar8 = this.bIJ.bIj;
                                            pbActivity.sendMessage(new CustomMessage(2004001, pbActivityConfig.createNormalCfg(eVar8.aaa(), null, null)));
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                }
                                cjVar20 = this.bIJ.bIl;
                                if (view != cjVar20.bLc.bMQ) {
                                    cjVar21 = this.bIJ.bIl;
                                    if (view == cjVar21.bLc.bMS) {
                                        brVar37 = this.bIJ.bIg;
                                        if (brVar37 != null) {
                                            brVar38 = this.bIJ.bIg;
                                            if (brVar38.getPbData() != null) {
                                                brVar39 = this.bIJ.bIg;
                                                ArrayList<com.baidu.tieba.tbadkCore.c.j> Zc = brVar39.getPbData().Zc();
                                                if (Zc == null || Zc.size() <= 0) {
                                                    brVar40 = this.bIJ.bIg;
                                                    if (brVar40.aab()) {
                                                        com.baidu.adp.lib.util.n.showToast(this.bIJ.getPageContext().getPageActivity(), this.bIJ.getPageContext().getString(com.baidu.tieba.y.pb_no_data_tips));
                                                        return;
                                                    }
                                                }
                                                this.bIJ.Zz();
                                                return;
                                            }
                                        }
                                        com.baidu.adp.lib.util.n.showToast(this.bIJ.getPageContext().getPageActivity(), this.bIJ.getPageContext().getString(com.baidu.tieba.y.pb_no_data_tips));
                                        return;
                                    }
                                    cjVar22 = this.bIJ.bIl;
                                    if (view == cjVar22.bLc.bMR) {
                                        z2 = this.bIJ.akH;
                                        if (!z2) {
                                            this.bIJ.akH = true;
                                            cjVar60 = this.bIJ.bIl;
                                            cjVar60.bLc.bMR.setEnabled(false);
                                            cjVar61 = this.bIJ.bIl;
                                            cjVar61.RQ();
                                            this.bIJ.stopVoice();
                                            cjVar62 = this.bIJ.bIl;
                                            cjVar62.aaX();
                                            brVar36 = this.bIJ.bIg;
                                            brVar36.aaj();
                                            TiebaStatic.eventStat(this.bIJ.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                            return;
                                        }
                                        return;
                                    }
                                    cjVar23 = this.bIJ.bIl;
                                    if (view == cjVar23.bLc.bMT) {
                                        brVar30 = this.bIJ.bIg;
                                        AdditionData Zg = brVar30.getPbData().Zg();
                                        if (!TextUtils.isEmpty(Zg.getWarnMsg())) {
                                            com.baidu.adp.lib.util.n.showToast(this.bIJ.getPageContext().getPageActivity(), Zg.getWarnMsg());
                                            return;
                                        } else if (Zg.getAlreadyCount() != Zg.getTotalCount()) {
                                            brVar31 = this.bIJ.bIg;
                                            ForumData Za = brVar31.getPbData().Za();
                                            brVar32 = this.bIJ.bIg;
                                            com.baidu.tbadk.core.data.w Zb = brVar32.getPbData().Zb();
                                            brVar33 = this.bIJ.bIg;
                                            AntiData qe = brVar33.getPbData().qe();
                                            if (Zb.getId() != null) {
                                                if (qe != null && qe.getIfpost() == 0) {
                                                    com.baidu.adp.lib.util.n.showToast(this.bIJ.getPageContext().getPageActivity(), qe.getForbid_info());
                                                    return;
                                                }
                                                int i = 0;
                                                brVar34 = this.bIJ.bIg;
                                                if (brVar34.getPbData().getUserData() != null) {
                                                    brVar35 = this.bIJ.bIg;
                                                    i = brVar35.getPbData().getUserData().getIsMem();
                                                }
                                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteActivityConfig(this.bIJ.getPageContext().getPageActivity(), 2, Za.getId(), Za.getName(), Zb.getId(), Zg.getPostId(), 0, qe, 13008, false, false, null, false, false, null, Zg, null, i)));
                                                return;
                                            }
                                            return;
                                        } else {
                                            com.baidu.adp.lib.util.n.showToast(this.bIJ.getPageContext().getPageActivity(), String.format(this.bIJ.getPageContext().getString(com.baidu.tieba.y.write_addition_limit), Integer.valueOf(Zg.getTotalCount())));
                                            return;
                                        }
                                    }
                                    cjVar24 = this.bIJ.bIl;
                                    if (cjVar24.bLc.abP() != null) {
                                        cjVar57 = this.bIJ.bIl;
                                        if (view == cjVar57.bLc.abP().aaq()) {
                                            cjVar58 = this.bIJ.bIl;
                                            cjVar58.abC();
                                            hj = this.bIJ.hj(11009);
                                            if (hj) {
                                                brVar29 = this.bIJ.bIg;
                                                cjVar59 = this.bIJ.bIl;
                                                if (brVar29.hr(cjVar59.abp()) == null) {
                                                    return;
                                                }
                                                this.bIJ.ZE();
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                    cjVar25 = this.bIJ.bIl;
                                    if (cjVar25.bLc.abP() != null) {
                                        cjVar55 = this.bIJ.bIl;
                                        if (view == cjVar55.bLc.abP().aar()) {
                                            cjVar56 = this.bIJ.bIl;
                                            cjVar56.abC();
                                            this.bIJ.stopVoice();
                                            this.bIJ.showShareDialog();
                                            return;
                                        }
                                    }
                                    cjVar26 = this.bIJ.bIl;
                                    if (cjVar26.bLc.abP() != null) {
                                        cjVar52 = this.bIJ.bIl;
                                        if (view == cjVar52.bLc.abP().aat()) {
                                            cjVar53 = this.bIJ.bIl;
                                            cjVar53.abC();
                                            brVar27 = this.bIJ.bIg;
                                            if (brVar27.aag() != null) {
                                                cjVar54 = this.bIJ.bIl;
                                                brVar28 = this.bIJ.bIg;
                                                cjVar54.a(brVar28.aag());
                                            }
                                            TiebaStatic.eventStat(this.bIJ.getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
                                            return;
                                        }
                                    }
                                    cjVar27 = this.bIJ.bIl;
                                    if (cjVar27.bLc.abP() != null) {
                                        cjVar49 = this.bIJ.bIl;
                                        if (view == cjVar49.bLc.abP().aau()) {
                                            cjVar50 = this.bIJ.bIl;
                                            cjVar50.abC();
                                            this.bIJ.stopVoice();
                                            cjVar51 = this.bIJ.bIl;
                                            cjVar51.aaX();
                                            brVar26 = this.bIJ.bIg;
                                            brVar26.aak();
                                            TiebaStatic.eventStat(this.bIJ.getPageContext().getPageActivity(), "pb_set_desc", "pbclick", 1, new Object[0]);
                                            return;
                                        }
                                    }
                                    cjVar28 = this.bIJ.bIl;
                                    if (cjVar28.bLc.abP() != null) {
                                        cjVar47 = this.bIJ.bIl;
                                        if (view == cjVar47.bLc.abP().aav()) {
                                            brVar20 = this.bIJ.bIg;
                                            if (brVar20 != null) {
                                                brVar21 = this.bIJ.bIg;
                                                if (brVar21.getPbData() != null) {
                                                    brVar22 = this.bIJ.bIg;
                                                    if (brVar22.getPbData().Zb() != null) {
                                                        cjVar48 = this.bIJ.bIl;
                                                        cjVar48.bLc.oW();
                                                        brVar23 = this.bIJ.bIg;
                                                        if (brVar23.getPbData().Zc() != null) {
                                                            brVar24 = this.bIJ.bIg;
                                                            if (brVar24.getPbData().Zc().size() > 0) {
                                                                PbActivity pbActivity2 = this.bIJ;
                                                                brVar25 = this.bIJ.bIg;
                                                                pbActivity2.hH(brVar25.getPbData().Zc().get(0).getId());
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    return;
                                                }
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                    ciVar = this.bIJ.bIq;
                                    if (ciVar != null) {
                                        ciVar29 = this.bIJ.bIq;
                                        if (view == ciVar29.aaD()) {
                                            Object tag = view.getTag();
                                            if (tag instanceof String) {
                                                morePopupWindow10 = this.bIJ.bIp;
                                                com.baidu.adp.lib.g.k.a(morePopupWindow10, this.bIJ.getPageContext().getPageActivity());
                                                this.bIJ.hH((String) tag);
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                    ciVar2 = this.bIJ.bIq;
                                    if (ciVar2 != null) {
                                        ciVar28 = this.bIJ.bIq;
                                        if (view == ciVar28.aaq()) {
                                            this.bIJ.H(view);
                                            morePopupWindow9 = this.bIJ.bIp;
                                            com.baidu.adp.lib.g.k.a(morePopupWindow9, this.bIJ.getPageContext().getPageActivity());
                                            return;
                                        }
                                    }
                                    cjVar29 = this.bIJ.bIl;
                                    if (cjVar29.aaK() != view) {
                                        ciVar3 = this.bIJ.bIq;
                                        if (ciVar3 != null) {
                                            ciVar27 = this.bIJ.bIq;
                                            if (view == ciVar27.aaC()) {
                                                SparseArray sparseArray2 = (SparseArray) view.getTag();
                                                if (sparseArray2 != null) {
                                                    if ("".equals(sparseArray2.get(com.baidu.tieba.v.tag_forbid_user_name)) || "".equals(sparseArray2.get(com.baidu.tieba.v.tag_del_post_id))) {
                                                        cjVar45 = this.bIJ.bIl;
                                                        cjVar45.a(((Integer) sparseArray2.get(com.baidu.tieba.v.tag_del_post_type)).intValue(), (String) sparseArray2.get(com.baidu.tieba.v.tag_del_post_id), ((Integer) sparseArray2.get(com.baidu.tieba.v.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(com.baidu.tieba.v.tag_del_post_is_self)).booleanValue());
                                                    } else {
                                                        cjVar46 = this.bIJ.bIl;
                                                        cjVar46.M(view);
                                                    }
                                                    morePopupWindow8 = this.bIJ.bIp;
                                                    com.baidu.adp.lib.g.k.a(morePopupWindow8, this.bIJ.getPageContext().getPageActivity());
                                                    return;
                                                }
                                                return;
                                            }
                                        }
                                        if (view.getId() != com.baidu.tieba.v.pb_head_function_manage_delormanage) {
                                            ciVar4 = this.bIJ.bIq;
                                            if (ciVar4 != null) {
                                                ciVar26 = this.bIJ.bIq;
                                            }
                                            if (view.getId() != com.baidu.tieba.v.sub_pb_more && view.getId() != com.baidu.tieba.v.sub_pb_item) {
                                                int id = view.getId();
                                                if (id == com.baidu.tieba.v.pb_u9_text_view) {
                                                    com.baidu.tbadk.core.data.aa aaVar = (com.baidu.tbadk.core.data.aa) view.getTag();
                                                    if (aaVar != null && !StringUtils.isNull(aaVar.rb())) {
                                                        com.baidu.tbadk.core.util.bk.tl().b(this.bIJ.getPageContext(), new String[]{aaVar.rb()});
                                                        return;
                                                    }
                                                    return;
                                                } else if (id == com.baidu.tieba.v.dialog_button_ok) {
                                                    brVar13 = this.bIJ.bIg;
                                                    com.baidu.tbadk.core.data.q aag = brVar13.aag();
                                                    cjVar35 = this.bIJ.bIl;
                                                    int pageNum = cjVar35.getPageNum();
                                                    if (pageNum <= 0) {
                                                        this.bIJ.showToast(com.baidu.tieba.y.pb_page_error);
                                                        return;
                                                    } else if (aag == null || pageNum <= aag.qh()) {
                                                        cjVar36 = this.bIJ.bIl;
                                                        cjVar36.abC();
                                                        this.bIJ.stopVoice();
                                                        cjVar37 = this.bIJ.bIl;
                                                        cjVar37.aaX();
                                                        brVar14 = this.bIJ.bIg;
                                                        cjVar38 = this.bIJ.bIl;
                                                        brVar14.hm(cjVar38.getPageNum());
                                                        return;
                                                    } else {
                                                        this.bIJ.showToast(com.baidu.tieba.y.pb_page_error);
                                                        return;
                                                    }
                                                } else if (id == com.baidu.tieba.v.dialog_button_cancel) {
                                                    cjVar34 = this.bIJ.bIl;
                                                    cjVar34.abC();
                                                    return;
                                                } else if (id == com.baidu.tieba.v.reply) {
                                                    morePopupWindow = this.bIJ.bIp;
                                                    if (morePopupWindow != null) {
                                                        ciVar20 = this.bIJ.bIq;
                                                    }
                                                    this.bIJ.Zx();
                                                    morePopupWindow2 = this.bIJ.bIp;
                                                    if (morePopupWindow2.getIsIntercepted()) {
                                                        morePopupWindow5 = this.bIJ.bIp;
                                                        morePopupWindow5.setIsIntercepted(false);
                                                        return;
                                                    }
                                                    com.baidu.tieba.tbadkCore.c.j jVar = null;
                                                    if (view != null && view.getTag() != null) {
                                                        SparseArray sparseArray3 = (SparseArray) view.getTag();
                                                        jVar = (com.baidu.tieba.tbadkCore.c.j) sparseArray3.get(com.baidu.tieba.v.tag_load_sub_data);
                                                        SparseArray sparseArray4 = new SparseArray();
                                                        sparseArray4.put(com.baidu.tieba.v.tag_load_sub_data, jVar);
                                                        sparseArray4.put(com.baidu.tieba.v.tag_load_sub_view, (View) sparseArray3.get(com.baidu.tieba.v.tag_load_sub_view));
                                                        ciVar10 = this.bIJ.bIq;
                                                        ciVar10.aaB().setTag(sparseArray4);
                                                        SparseArray sparseArray5 = new SparseArray();
                                                        sparseArray5.put(com.baidu.tieba.v.tag_clip_board, (com.baidu.tieba.tbadkCore.c.j) ((SparseArray) view.getTag()).get(com.baidu.tieba.v.tag_clip_board));
                                                        sparseArray5.put(com.baidu.tieba.v.tag_is_subpb, false);
                                                        ciVar11 = this.bIJ.bIq;
                                                        ciVar11.aaq().setTag(sparseArray5);
                                                        SparseArray sparseArray6 = (SparseArray) view.getTag();
                                                        boolean booleanValue = ((Boolean) sparseArray6.get(com.baidu.tieba.v.tag_should_manage_visible)).booleanValue();
                                                        if (!(sparseArray6.get(com.baidu.tieba.v.tag_del_post_is_self) instanceof Boolean)) {
                                                            z = false;
                                                        } else {
                                                            z = ((Boolean) sparseArray6.get(com.baidu.tieba.v.tag_del_post_is_self)).booleanValue();
                                                        }
                                                        String str = null;
                                                        if (sparseArray6.get(com.baidu.tieba.v.tag_forbid_user_post_id) instanceof String) {
                                                            str = (String) sparseArray6.get(com.baidu.tieba.v.tag_forbid_user_post_id);
                                                        }
                                                        if (!booleanValue) {
                                                            ciVar12 = this.bIJ.bIq;
                                                            ciVar12.aaC().setVisibility(8);
                                                        } else {
                                                            SparseArray sparseArray7 = new SparseArray();
                                                            sparseArray7.put(com.baidu.tieba.v.tag_manage_user_identity, sparseArray6.get(com.baidu.tieba.v.tag_manage_user_identity));
                                                            sparseArray7.put(com.baidu.tieba.v.tag_del_post_is_self, Boolean.valueOf(z));
                                                            sparseArray7.put(com.baidu.tieba.v.tag_del_post_id, sparseArray6.get(com.baidu.tieba.v.tag_del_post_id));
                                                            sparseArray7.put(com.baidu.tieba.v.tag_del_post_type, sparseArray6.get(com.baidu.tieba.v.tag_del_post_type));
                                                            sparseArray7.put(com.baidu.tieba.v.tag_forbid_user_name, sparseArray6.get(com.baidu.tieba.v.tag_forbid_user_name));
                                                            sparseArray7.put(com.baidu.tieba.v.tag_forbid_user_post_id, str);
                                                            ciVar16 = this.bIJ.bIq;
                                                            ciVar16.aaC().setTag(sparseArray7);
                                                            if ("".equals(sparseArray6.get(com.baidu.tieba.v.tag_forbid_user_name)) || "".equals(sparseArray6.get(com.baidu.tieba.v.tag_del_post_id))) {
                                                                ciVar17 = this.bIJ.bIq;
                                                                com.baidu.tbadk.core.util.ba.c(ciVar17.aaC(), com.baidu.tieba.u.icon_pb_del_n);
                                                            } else {
                                                                ciVar19 = this.bIJ.bIq;
                                                                com.baidu.tbadk.core.util.ba.c(ciVar19.aaC(), com.baidu.tieba.u.icon_pb_set_n);
                                                            }
                                                            ciVar18 = this.bIJ.bIq;
                                                            ciVar18.aaC().setVisibility(0);
                                                        }
                                                        dE = this.bIJ.dE(z);
                                                        if (dE) {
                                                            ciVar14 = this.bIJ.bIq;
                                                            ciVar14.aaD().setVisibility(0);
                                                            ciVar15 = this.bIJ.bIq;
                                                            ciVar15.aaD().setTag(str);
                                                        } else {
                                                            ciVar13 = this.bIJ.bIq;
                                                            ciVar13.aaD().setVisibility(8);
                                                        }
                                                    }
                                                    boolean z4 = false;
                                                    brVar11 = this.bIJ.bIg;
                                                    if (brVar11.getPbData().oQ()) {
                                                        brVar12 = this.bIJ.bIg;
                                                        String oP = brVar12.getPbData().oP();
                                                        if (jVar != null && !com.baidu.adp.lib.util.m.isEmpty(oP) && oP.equals(jVar.getId())) {
                                                            z4 = true;
                                                        }
                                                    }
                                                    if (z4) {
                                                        ciVar8 = this.bIJ.bIq;
                                                        ciVar8.aaq().setText(com.baidu.tieba.y.marked);
                                                        ciVar9 = this.bIJ.bIq;
                                                        ciVar9.aaq().setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.ba.getDrawable(com.baidu.tieba.u.icon_pb_collect_s), (Drawable) null, (Drawable) null, (Drawable) null);
                                                    } else {
                                                        ciVar5 = this.bIJ.bIq;
                                                        ciVar5.aaq().setText(com.baidu.tieba.y.mark);
                                                        ciVar6 = this.bIJ.bIq;
                                                        ciVar6.aaq().setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.ba.getDrawable(com.baidu.tieba.u.icon_pb_collect_n), (Drawable) null, (Drawable) null, (Drawable) null);
                                                    }
                                                    ciVar7 = this.bIJ.bIq;
                                                    ciVar7.dP(true);
                                                    morePopupWindow3 = this.bIJ.bIp;
                                                    morePopupWindow3.reLayoutWidth();
                                                    morePopupWindow4 = this.bIJ.bIp;
                                                    morePopupWindow4.showWindowInLeftCenterOfHost(view, false);
                                                    return;
                                                } else if (id == com.baidu.tieba.v.sub_post_load_more) {
                                                    eVar2 = this.bIJ.bIj;
                                                    if (eVar2.AZ()) {
                                                        cjVar33 = this.bIJ.bIl;
                                                        cjVar33.abe();
                                                        return;
                                                    }
                                                    return;
                                                } else if (id == com.baidu.tieba.v.btn_loadprevious) {
                                                    eVar = this.bIJ.bIj;
                                                    if (eVar.acl()) {
                                                        cjVar32 = this.bIJ.bIl;
                                                        cjVar32.abf();
                                                        return;
                                                    }
                                                    return;
                                                } else if (id != com.baidu.tieba.v.pb_head_reverse_hint) {
                                                    if (id == com.baidu.tieba.v.pb_act_btn) {
                                                        brVar4 = this.bIJ.bIg;
                                                        if (brVar4.getPbData() != null) {
                                                            brVar5 = this.bIJ.bIg;
                                                            if (brVar5.getPbData().Zb() != null) {
                                                                brVar6 = this.bIJ.bIg;
                                                                if (brVar6.getPbData().Zb().qR() != null) {
                                                                    Activity activity = this.bIJ.getActivity();
                                                                    brVar7 = this.bIJ.bIg;
                                                                    com.baidu.tbadk.browser.f.x(activity, brVar7.getPbData().Zb().qR());
                                                                    brVar8 = this.bIJ.bIg;
                                                                    if (brVar8.getPbData().Zb().qP() != 1) {
                                                                        brVar9 = this.bIJ.bIg;
                                                                        if (brVar9.getPbData().Zb().qP() == 2) {
                                                                            TiebaStatic.eventStat(this.bIJ.getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "pb");
                                                                            return;
                                                                        }
                                                                        return;
                                                                    }
                                                                    TiebaStatic.eventStat(this.bIJ.getPageContext().getPageActivity(), "lottery", "click", 1, "page", "pb");
                                                                    return;
                                                                }
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    return;
                                                } else {
                                                    this.bIJ.stopVoice();
                                                    cjVar30 = this.bIJ.bIl;
                                                    cjVar30.abC();
                                                    cjVar31 = this.bIJ.bIl;
                                                    cjVar31.aaX();
                                                    brVar10 = this.bIJ.bIg;
                                                    brVar10.aak();
                                                    return;
                                                }
                                            }
                                            ciVar21 = this.bIJ.bIq;
                                            if (ciVar21 != null) {
                                                ciVar24 = this.bIJ.bIq;
                                                if (view == ciVar24.aaB()) {
                                                    ciVar25 = this.bIJ.bIq;
                                                    if (!ciVar25.aaA()) {
                                                        morePopupWindow7 = this.bIJ.bIp;
                                                        com.baidu.adp.lib.g.k.a(morePopupWindow7, this.bIJ.getPageContext().getPageActivity());
                                                        cjVar42 = this.bIJ.bIl;
                                                        cjVar42.dS(true);
                                                        return;
                                                    }
                                                }
                                            }
                                            try {
                                                brVar15 = this.bIJ.bIg;
                                                if (brVar15.getPbData() != null) {
                                                    cjVar39 = this.bIJ.bIl;
                                                    cjVar39.abC();
                                                    SparseArray sparseArray8 = (SparseArray) view.getTag();
                                                    com.baidu.tieba.tbadkCore.c.j jVar2 = (com.baidu.tieba.tbadkCore.c.j) sparseArray8.get(com.baidu.tieba.v.tag_load_sub_data);
                                                    View view2 = (View) sparseArray8.get(com.baidu.tieba.v.tag_load_sub_view);
                                                    if (jVar2 != null && view2 != null) {
                                                        brVar16 = this.bIJ.bIg;
                                                        com.baidu.tieba.pb.a.c c = brVar16.c(jVar2);
                                                        eVar3 = this.bIJ.bIj;
                                                        brVar17 = this.bIJ.bIg;
                                                        eVar3.hQ(brVar17.aaa());
                                                        eVar4 = this.bIJ.bIj;
                                                        eVar4.hA(jVar2.getId());
                                                        eVar5 = this.bIJ.bIj;
                                                        eVar5.resetData();
                                                        this.bIJ.stopVoice();
                                                        ciVar22 = this.bIJ.bIq;
                                                        if (ciVar22 != null) {
                                                            ciVar23 = this.bIJ.bIq;
                                                            if (view == ciVar23.aaB()) {
                                                                morePopupWindow6 = this.bIJ.bIp;
                                                                com.baidu.adp.lib.g.k.a(morePopupWindow6, this.bIJ.getPageContext().getPageActivity());
                                                                cjVar41 = this.bIJ.bIl;
                                                                brVar19 = this.bIJ.bIg;
                                                                cjVar41.a(true, c, false, null, null, view2, brVar19.getPbData().Ze());
                                                                return;
                                                            }
                                                        }
                                                        if (view.getId() != com.baidu.tieba.v.sub_pb_item) {
                                                            handler = this.bIJ.mHandler;
                                                            handler.post(new bc(this, jVar2, c, view2));
                                                            return;
                                                        }
                                                        SparseArray sparseArray9 = (SparseArray) view.getTag();
                                                        String str2 = (String) sparseArray9.get(com.baidu.tieba.v.tag_photo_username);
                                                        com.baidu.tieba.tbadkCore.c.j jVar3 = (com.baidu.tieba.tbadkCore.c.j) sparseArray9.get(com.baidu.tieba.v.tag_clip_board);
                                                        String str3 = null;
                                                        if (jVar3 != null) {
                                                            str3 = jVar3.getId();
                                                        }
                                                        cjVar40 = this.bIJ.bIl;
                                                        brVar18 = this.bIJ.bIg;
                                                        cjVar40.a(true, c, false, str2, str3, view2, brVar18.getPbData().Ze());
                                                        return;
                                                    }
                                                    return;
                                                }
                                                return;
                                            } catch (Exception e) {
                                                BdLog.e(e.toString());
                                                return;
                                            }
                                        }
                                        SparseArray sparseArray10 = (SparseArray) view.getTag();
                                        if (((Boolean) sparseArray10.get(com.baidu.tieba.v.tag_should_manage_visible)).booleanValue()) {
                                            cjVar44 = this.bIJ.bIl;
                                            cjVar44.M(view);
                                            return;
                                        }
                                        cjVar43 = this.bIJ.bIl;
                                        cjVar43.a(((Integer) sparseArray10.get(com.baidu.tieba.v.tag_del_post_type)).intValue(), (String) sparseArray10.get(com.baidu.tieba.v.tag_del_post_id), ((Integer) sparseArray10.get(com.baidu.tieba.v.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray10.get(com.baidu.tieba.v.tag_del_post_is_self)).booleanValue());
                                        return;
                                    }
                                    this.bIJ.Zt();
                                    return;
                                }
                                TiebaStatic.eventStat(this.bIJ.getPageContext().getPageActivity(), "pb_header_forum_name", "pbclick", 1, new Object[0]);
                                brVar41 = this.bIJ.bIg;
                                String name = brVar41.getPbData().Za().getName();
                                brVar42 = this.bIJ.bIg;
                                if (!TextUtils.isEmpty(brVar42.ZZ())) {
                                    brVar43 = this.bIJ.bIg;
                                    if (brVar43.ZZ().equals(name)) {
                                        this.bIJ.finish();
                                        return;
                                    }
                                }
                                if (com.baidu.tbadk.core.util.bd.aK(name)) {
                                    this.bIJ.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.bIJ.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_PB)));
                                    return;
                                }
                                return;
                            }
                            morePopupWindow11 = this.bIJ.bIp;
                            if (morePopupWindow11 != null) {
                                ciVar41 = this.bIJ.bIq;
                            }
                            this.bIJ.Zx();
                            com.baidu.tieba.tbadkCore.c.j jVar4 = null;
                            if (view != null && view.getTag() != null) {
                                jVar4 = (com.baidu.tieba.tbadkCore.c.j) ((SparseArray) view.getTag()).get(com.baidu.tieba.v.tag_clip_board);
                                SparseArray sparseArray11 = new SparseArray();
                                sparseArray11.put(com.baidu.tieba.v.tag_clip_board, jVar4);
                                sparseArray11.put(com.baidu.tieba.v.tag_is_subpb, false);
                                ciVar40 = this.bIJ.bIq;
                                ciVar40.aaq().setTag(sparseArray11);
                            }
                            brVar44 = this.bIJ.bIg;
                            if (brVar44.getPbData() != null) {
                                brVar45 = this.bIJ.bIg;
                                if (brVar45.getPbData().oQ()) {
                                    brVar46 = this.bIJ.bIg;
                                    String oP2 = brVar46.getPbData().oP();
                                    if (jVar4 != null && !com.baidu.adp.lib.util.m.isEmpty(oP2) && oP2.equals(jVar4.getId())) {
                                        z3 = true;
                                        if (!z3) {
                                            ciVar38 = this.bIJ.bIq;
                                            ciVar38.aaq().setText(com.baidu.tieba.y.marked);
                                            ciVar39 = this.bIJ.bIq;
                                            ciVar39.aaq().setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.ba.getDrawable(com.baidu.tieba.u.icon_pb_collect_s), (Drawable) null, (Drawable) null, (Drawable) null);
                                        } else {
                                            ciVar30 = this.bIJ.bIq;
                                            ciVar30.aaq().setText(com.baidu.tieba.y.mark);
                                            ciVar31 = this.bIJ.bIq;
                                            ciVar31.aaq().setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.ba.getDrawable(com.baidu.tieba.u.icon_pb_collect_n), (Drawable) null, (Drawable) null, (Drawable) null);
                                        }
                                        if (view != null && view.getTag() != null) {
                                            sparseArray = (SparseArray) view.getTag();
                                            if (((Boolean) sparseArray.get(com.baidu.tieba.v.tag_should_manage_visible)).booleanValue()) {
                                                ciVar33 = this.bIJ.bIq;
                                                ciVar33.aaC().setVisibility(8);
                                            } else {
                                                SparseArray sparseArray12 = new SparseArray();
                                                sparseArray12.put(com.baidu.tieba.v.tag_manage_user_identity, sparseArray.get(com.baidu.tieba.v.tag_manage_user_identity));
                                                sparseArray12.put(com.baidu.tieba.v.tag_del_post_is_self, sparseArray.get(com.baidu.tieba.v.tag_del_post_is_self));
                                                sparseArray12.put(com.baidu.tieba.v.tag_del_post_id, sparseArray.get(com.baidu.tieba.v.tag_del_post_id));
                                                sparseArray12.put(com.baidu.tieba.v.tag_del_post_type, sparseArray.get(com.baidu.tieba.v.tag_del_post_type));
                                                sparseArray12.put(com.baidu.tieba.v.tag_forbid_user_name, sparseArray.get(com.baidu.tieba.v.tag_forbid_user_name));
                                                sparseArray12.put(com.baidu.tieba.v.tag_forbid_user_post_id, sparseArray.get(com.baidu.tieba.v.tag_forbid_user_post_id));
                                                ciVar34 = this.bIJ.bIq;
                                                ciVar34.aaC().setTag(sparseArray12);
                                                if ("".equals(sparseArray.get(com.baidu.tieba.v.tag_forbid_user_name)) || "".equals(sparseArray.get(com.baidu.tieba.v.tag_del_post_id))) {
                                                    ciVar35 = this.bIJ.bIq;
                                                    com.baidu.tbadk.core.util.ba.c(ciVar35.aaC(), com.baidu.tieba.u.icon_pb_del_n);
                                                } else {
                                                    ciVar37 = this.bIJ.bIq;
                                                    com.baidu.tbadk.core.util.ba.c(ciVar37.aaC(), com.baidu.tieba.u.icon_pb_set_n);
                                                }
                                                ciVar36 = this.bIJ.bIq;
                                                ciVar36.aaC().setVisibility(0);
                                            }
                                        }
                                        ciVar32 = this.bIJ.bIq;
                                        ciVar32.dP(false);
                                        morePopupWindow12 = this.bIJ.bIp;
                                        morePopupWindow12.reLayoutWidth();
                                        morePopupWindow13 = this.bIJ.bIp;
                                        morePopupWindow13.showWindowInLeftCenterOfHost(view, false);
                                        return;
                                    }
                                }
                            }
                            z3 = false;
                            if (!z3) {
                            }
                            if (view != null) {
                                sparseArray = (SparseArray) view.getTag();
                                if (((Boolean) sparseArray.get(com.baidu.tieba.v.tag_should_manage_visible)).booleanValue()) {
                                }
                            }
                            ciVar32 = this.bIJ.bIq;
                            ciVar32.dP(false);
                            morePopupWindow12 = this.bIJ.bIp;
                            morePopupWindow12.reLayoutWidth();
                            morePopupWindow13 = this.bIJ.bIp;
                            morePopupWindow13.showWindowInLeftCenterOfHost(view, false);
                            return;
                        }
                    }
                }
            }
        }
        cjVar4 = this.bIJ.bIl;
        cjVar4.abE();
        brVar = this.bIJ.bIg;
        if (brVar.getPbData().Ze() == 1) {
            aVar = this.bIJ.bIk;
            if (!aVar.anB()) {
                cjVar5 = this.bIJ.bIl;
                cjVar5.aaT();
                int i2 = 0;
                cjVar6 = this.bIJ.bIl;
                if (view != cjVar6.abw()) {
                    cjVar7 = this.bIJ.bIl;
                    if (view != cjVar7.abx()) {
                        cjVar8 = this.bIJ.bIl;
                        if (view != cjVar8.aby()) {
                            cjVar9 = this.bIJ.bIl;
                            if (view != cjVar9.abz()) {
                                cjVar10 = this.bIJ.bIl;
                                if (view == cjVar10.aaU()) {
                                    i2 = 2;
                                }
                            } else {
                                i2 = 5;
                            }
                        } else {
                            i2 = 4;
                        }
                    } else {
                        i2 = 3;
                    }
                } else {
                    i2 = 6;
                }
                brVar2 = this.bIJ.bIg;
                ForumData Za2 = brVar2.getPbData().Za();
                String name2 = Za2.getName();
                String id2 = Za2.getId();
                brVar3 = this.bIJ.bIg;
                String id3 = brVar3.getPbData().Zb().getId();
                aVar2 = this.bIJ.bIk;
                cjVar11 = this.bIJ.bIl;
                aVar2.b(id2, name2, id3, i2, cjVar11.aaV());
            }
        }
    }
}
