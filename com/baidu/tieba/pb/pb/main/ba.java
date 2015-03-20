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
class ba implements View.OnClickListener {
    final /* synthetic */ PbActivity bIv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(PbActivity pbActivity) {
        this.bIv = pbActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v31, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Code restructure failed: missing block: B:228:0x0af2, code lost:
        if (r21 != r1.aao()) goto L292;
     */
    /* JADX WARN: Code restructure failed: missing block: B:289:0x0d65, code lost:
        if (r1 == null) goto L371;
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
        ci ciVar;
        ci ciVar2;
        ci ciVar3;
        ci ciVar4;
        bq bqVar;
        com.baidu.tieba.tbadkCore.h.a aVar;
        ci ciVar5;
        ci ciVar6;
        ci ciVar7;
        ci ciVar8;
        ci ciVar9;
        ci ciVar10;
        bq bqVar2;
        bq bqVar3;
        com.baidu.tieba.tbadkCore.h.a aVar2;
        ci ciVar11;
        ci ciVar12;
        ci ciVar13;
        ci ciVar14;
        ci ciVar15;
        ci ciVar16;
        ci ciVar17;
        ci ciVar18;
        ci ciVar19;
        ci ciVar20;
        ci ciVar21;
        ci ciVar22;
        ci ciVar23;
        ci ciVar24;
        ci ciVar25;
        ci ciVar26;
        ci ciVar27;
        ci ciVar28;
        ch chVar;
        ch chVar2;
        ci ciVar29;
        ch chVar3;
        ch chVar4;
        bq bqVar4;
        bq bqVar5;
        bq bqVar6;
        bq bqVar7;
        bq bqVar8;
        bq bqVar9;
        ci ciVar30;
        ci ciVar31;
        bq bqVar10;
        com.baidu.tieba.pb.pb.sub.e eVar;
        ci ciVar32;
        com.baidu.tieba.pb.pb.sub.e eVar2;
        ci ciVar33;
        MorePopupWindow morePopupWindow;
        MorePopupWindow morePopupWindow2;
        bq bqVar11;
        ch chVar5;
        ch chVar6;
        ch chVar7;
        MorePopupWindow morePopupWindow3;
        MorePopupWindow morePopupWindow4;
        ch chVar8;
        ch chVar9;
        bq bqVar12;
        ch chVar10;
        ch chVar11;
        boolean z;
        ch chVar12;
        boolean dG;
        ch chVar13;
        ch chVar14;
        ch chVar15;
        ch chVar16;
        ch chVar17;
        ch chVar18;
        ch chVar19;
        MorePopupWindow morePopupWindow5;
        ch chVar20;
        ci ciVar34;
        bq bqVar13;
        ci ciVar35;
        ci ciVar36;
        ci ciVar37;
        bq bqVar14;
        ci ciVar38;
        ch chVar21;
        bq bqVar15;
        ci ciVar39;
        bq bqVar16;
        com.baidu.tieba.pb.pb.sub.e eVar3;
        bq bqVar17;
        com.baidu.tieba.pb.pb.sub.e eVar4;
        com.baidu.tieba.pb.pb.sub.e eVar5;
        ch chVar22;
        Handler handler;
        ci ciVar40;
        bq bqVar18;
        ch chVar23;
        MorePopupWindow morePopupWindow6;
        ci ciVar41;
        bq bqVar19;
        ch chVar24;
        ch chVar25;
        MorePopupWindow morePopupWindow7;
        ci ciVar42;
        ch chVar26;
        ci ciVar43;
        ci ciVar44;
        ch chVar27;
        ci ciVar45;
        MorePopupWindow morePopupWindow8;
        ci ciVar46;
        ch chVar28;
        MorePopupWindow morePopupWindow9;
        ch chVar29;
        MorePopupWindow morePopupWindow10;
        ci ciVar47;
        bq bqVar20;
        bq bqVar21;
        bq bqVar22;
        ci ciVar48;
        bq bqVar23;
        bq bqVar24;
        bq bqVar25;
        ci ciVar49;
        ci ciVar50;
        ci ciVar51;
        bq bqVar26;
        ci ciVar52;
        ci ciVar53;
        bq bqVar27;
        ci ciVar54;
        bq bqVar28;
        ci ciVar55;
        ci ciVar56;
        ci ciVar57;
        ci ciVar58;
        boolean hh;
        bq bqVar29;
        ci ciVar59;
        bq bqVar30;
        bq bqVar31;
        bq bqVar32;
        bq bqVar33;
        bq bqVar34;
        bq bqVar35;
        boolean z2;
        ci ciVar60;
        ci ciVar61;
        ci ciVar62;
        bq bqVar36;
        bq bqVar37;
        bq bqVar38;
        bq bqVar39;
        bq bqVar40;
        bq bqVar41;
        bq bqVar42;
        bq bqVar43;
        com.baidu.tieba.pb.pb.sub.e eVar6;
        com.baidu.tieba.pb.pb.sub.e eVar7;
        com.baidu.tieba.pb.pb.sub.e eVar8;
        com.baidu.tieba.pb.pb.sub.e eVar9;
        ci ciVar63;
        MorePopupWindow morePopupWindow11;
        bq bqVar44;
        boolean z3;
        ch chVar30;
        ch chVar31;
        ch chVar32;
        MorePopupWindow morePopupWindow12;
        MorePopupWindow morePopupWindow13;
        SparseArray sparseArray;
        ch chVar33;
        ch chVar34;
        ch chVar35;
        ch chVar36;
        ch chVar37;
        ch chVar38;
        ch chVar39;
        bq bqVar45;
        bq bqVar46;
        ch chVar40;
        ch chVar41;
        bq bqVar47;
        bq bqVar48;
        ci ciVar64;
        bq bqVar49;
        bq bqVar50;
        ci ciVar65;
        ciVar = this.bIv.bHY;
        if (view == ciVar.getNextView()) {
            bqVar50 = this.bIv.bHT;
            if (bqVar50.dM(true)) {
                ciVar65 = this.bIv.bHY;
                ciVar65.aaL();
                return;
            }
            return;
        }
        ciVar2 = this.bIv.bHY;
        if (view == ciVar2.bKN.baY) {
            ciVar64 = this.bIv.bHY;
            bqVar49 = this.bIv.bHT;
            if (!ciVar64.dX(bqVar49.ZR())) {
                this.bIv.finish();
                return;
            } else {
                this.bIv.stopVoice();
                return;
            }
        }
        ciVar3 = this.bIv.bHY;
        if (view != ciVar3.abi()) {
            ciVar12 = this.bIv.bHY;
            if (view != ciVar12.abj()) {
                ciVar13 = this.bIv.bHY;
                if (view != ciVar13.abk()) {
                    ciVar14 = this.bIv.bHY;
                    if (view != ciVar14.abl()) {
                        ciVar15 = this.bIv.bHY;
                        if (view != ciVar15.aaH()) {
                            ciVar16 = this.bIv.bHY;
                            if (view == ciVar16.abt()) {
                                bqVar47 = this.bIv.bHT;
                                if (bqVar47 != null) {
                                    bqVar48 = this.bIv.bHT;
                                    com.baidu.tbadk.browser.f.x(this.bIv.getPageContext().getPageActivity(), bqVar48.getPbData().YP().qD().getLink());
                                    return;
                                }
                                return;
                            }
                            ciVar17 = this.bIv.bHY;
                            if (view != ciVar17.abm()) {
                                ciVar18 = this.bIv.bHY;
                                if (view == ciVar18.aaJ()) {
                                    eVar9 = this.bIv.bHW;
                                    if (eVar9.AT()) {
                                        ciVar63 = this.bIv.bHY;
                                        ciVar63.aaR();
                                        return;
                                    }
                                    return;
                                }
                                ciVar19 = this.bIv.bHY;
                                if (view == ciVar19.aaD()) {
                                    eVar6 = this.bIv.bHW;
                                    if (eVar6 != null) {
                                        eVar7 = this.bIv.bHW;
                                        if (eVar7.ZN() != null) {
                                            PbActivity pbActivity = this.bIv;
                                            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.bIv.getPageContext().getPageActivity());
                                            eVar8 = this.bIv.bHW;
                                            pbActivity.sendMessage(new CustomMessage(2004001, pbActivityConfig.createNormalCfg(eVar8.ZN(), null, null)));
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                }
                                ciVar20 = this.bIv.bHY;
                                if (view != ciVar20.bKN.bMA) {
                                    ciVar21 = this.bIv.bHY;
                                    if (view == ciVar21.bKN.bMC) {
                                        bqVar37 = this.bIv.bHT;
                                        if (bqVar37 != null) {
                                            bqVar38 = this.bIv.bHT;
                                            if (bqVar38.getPbData() != null) {
                                                bqVar39 = this.bIv.bHT;
                                                ArrayList<com.baidu.tieba.tbadkCore.c.j> YQ = bqVar39.getPbData().YQ();
                                                if (YQ == null || YQ.size() <= 0) {
                                                    bqVar40 = this.bIv.bHT;
                                                    if (bqVar40.ZO()) {
                                                        com.baidu.adp.lib.util.n.showToast(this.bIv.getPageContext().getPageActivity(), this.bIv.getPageContext().getString(com.baidu.tieba.y.pb_no_data_tips));
                                                        return;
                                                    }
                                                }
                                                this.bIv.Zm();
                                                return;
                                            }
                                        }
                                        com.baidu.adp.lib.util.n.showToast(this.bIv.getPageContext().getPageActivity(), this.bIv.getPageContext().getString(com.baidu.tieba.y.pb_no_data_tips));
                                        return;
                                    }
                                    ciVar22 = this.bIv.bHY;
                                    if (view == ciVar22.bKN.bMB) {
                                        z2 = this.bIv.akz;
                                        if (!z2) {
                                            this.bIv.akz = true;
                                            ciVar60 = this.bIv.bHY;
                                            ciVar60.bKN.bMB.setEnabled(false);
                                            ciVar61 = this.bIv.bHY;
                                            ciVar61.RD();
                                            this.bIv.stopVoice();
                                            ciVar62 = this.bIv.bHY;
                                            ciVar62.aaK();
                                            bqVar36 = this.bIv.bHT;
                                            bqVar36.ZW();
                                            TiebaStatic.eventStat(this.bIv.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                            return;
                                        }
                                        return;
                                    }
                                    ciVar23 = this.bIv.bHY;
                                    if (view == ciVar23.bKN.bMD) {
                                        bqVar30 = this.bIv.bHT;
                                        AdditionData YU = bqVar30.getPbData().YU();
                                        if (!TextUtils.isEmpty(YU.getWarnMsg())) {
                                            com.baidu.adp.lib.util.n.showToast(this.bIv.getPageContext().getPageActivity(), YU.getWarnMsg());
                                            return;
                                        } else if (YU.getAlreadyCount() != YU.getTotalCount()) {
                                            bqVar31 = this.bIv.bHT;
                                            ForumData YO = bqVar31.getPbData().YO();
                                            bqVar32 = this.bIv.bHT;
                                            com.baidu.tbadk.core.data.w YP = bqVar32.getPbData().YP();
                                            bqVar33 = this.bIv.bHT;
                                            AntiData qe = bqVar33.getPbData().qe();
                                            if (YP.getId() != null) {
                                                if (qe != null && qe.getIfpost() == 0) {
                                                    com.baidu.adp.lib.util.n.showToast(this.bIv.getPageContext().getPageActivity(), qe.getForbid_info());
                                                    return;
                                                }
                                                int i = 0;
                                                bqVar34 = this.bIv.bHT;
                                                if (bqVar34.getPbData().getUserData() != null) {
                                                    bqVar35 = this.bIv.bHT;
                                                    i = bqVar35.getPbData().getUserData().getIsMem();
                                                }
                                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteActivityConfig(this.bIv.getPageContext().getPageActivity(), 2, YO.getId(), YO.getName(), YP.getId(), YU.getPostId(), 0, qe, 13008, false, false, null, false, false, null, YU, null, i)));
                                                return;
                                            }
                                            return;
                                        } else {
                                            com.baidu.adp.lib.util.n.showToast(this.bIv.getPageContext().getPageActivity(), String.format(this.bIv.getPageContext().getString(com.baidu.tieba.y.write_addition_limit), Integer.valueOf(YU.getTotalCount())));
                                            return;
                                        }
                                    }
                                    ciVar24 = this.bIv.bHY;
                                    if (ciVar24.bKN.abA() != null) {
                                        ciVar57 = this.bIv.bHY;
                                        if (view == ciVar57.bKN.abA().aad()) {
                                            ciVar58 = this.bIv.bHY;
                                            ciVar58.abo();
                                            hh = this.bIv.hh(11009);
                                            if (hh) {
                                                bqVar29 = this.bIv.bHT;
                                                ciVar59 = this.bIv.bHY;
                                                if (bqVar29.hp(ciVar59.abb()) == null) {
                                                    return;
                                                }
                                                this.bIv.Zr();
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                    ciVar25 = this.bIv.bHY;
                                    if (ciVar25.bKN.abA() != null) {
                                        ciVar55 = this.bIv.bHY;
                                        if (view == ciVar55.bKN.abA().aae()) {
                                            ciVar56 = this.bIv.bHY;
                                            ciVar56.abo();
                                            this.bIv.stopVoice();
                                            this.bIv.showShareDialog();
                                            return;
                                        }
                                    }
                                    ciVar26 = this.bIv.bHY;
                                    if (ciVar26.bKN.abA() != null) {
                                        ciVar52 = this.bIv.bHY;
                                        if (view == ciVar52.bKN.abA().aag()) {
                                            ciVar53 = this.bIv.bHY;
                                            ciVar53.abo();
                                            bqVar27 = this.bIv.bHT;
                                            if (bqVar27.ZT() != null) {
                                                ciVar54 = this.bIv.bHY;
                                                bqVar28 = this.bIv.bHT;
                                                ciVar54.a(bqVar28.ZT());
                                            }
                                            TiebaStatic.eventStat(this.bIv.getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
                                            return;
                                        }
                                    }
                                    ciVar27 = this.bIv.bHY;
                                    if (ciVar27.bKN.abA() != null) {
                                        ciVar49 = this.bIv.bHY;
                                        if (view == ciVar49.bKN.abA().aah()) {
                                            ciVar50 = this.bIv.bHY;
                                            ciVar50.abo();
                                            this.bIv.stopVoice();
                                            ciVar51 = this.bIv.bHY;
                                            ciVar51.aaK();
                                            bqVar26 = this.bIv.bHT;
                                            bqVar26.ZX();
                                            TiebaStatic.eventStat(this.bIv.getPageContext().getPageActivity(), "pb_set_desc", "pbclick", 1, new Object[0]);
                                            return;
                                        }
                                    }
                                    ciVar28 = this.bIv.bHY;
                                    if (ciVar28.bKN.abA() != null) {
                                        ciVar47 = this.bIv.bHY;
                                        if (view == ciVar47.bKN.abA().aai()) {
                                            bqVar20 = this.bIv.bHT;
                                            if (bqVar20 != null) {
                                                bqVar21 = this.bIv.bHT;
                                                if (bqVar21.getPbData() != null) {
                                                    bqVar22 = this.bIv.bHT;
                                                    if (bqVar22.getPbData().YP() != null) {
                                                        ciVar48 = this.bIv.bHY;
                                                        ciVar48.bKN.oW();
                                                        bqVar23 = this.bIv.bHT;
                                                        if (bqVar23.getPbData().YQ() != null) {
                                                            bqVar24 = this.bIv.bHT;
                                                            if (bqVar24.getPbData().YQ().size() > 0) {
                                                                PbActivity pbActivity2 = this.bIv;
                                                                bqVar25 = this.bIv.bHT;
                                                                pbActivity2.hE(bqVar25.getPbData().YQ().get(0).getId());
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
                                    chVar = this.bIv.bId;
                                    if (chVar != null) {
                                        chVar29 = this.bIv.bId;
                                        if (view == chVar29.aaq()) {
                                            Object tag = view.getTag();
                                            if (tag instanceof String) {
                                                morePopupWindow10 = this.bIv.bIc;
                                                com.baidu.adp.lib.g.k.a(morePopupWindow10, this.bIv.getPageContext().getPageActivity());
                                                this.bIv.hE((String) tag);
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                    chVar2 = this.bIv.bId;
                                    if (chVar2 != null) {
                                        chVar28 = this.bIv.bId;
                                        if (view == chVar28.aad()) {
                                            this.bIv.H(view);
                                            morePopupWindow9 = this.bIv.bIc;
                                            com.baidu.adp.lib.g.k.a(morePopupWindow9, this.bIv.getPageContext().getPageActivity());
                                            return;
                                        }
                                    }
                                    ciVar29 = this.bIv.bHY;
                                    if (ciVar29.aax() != view) {
                                        chVar3 = this.bIv.bId;
                                        if (chVar3 != null) {
                                            chVar27 = this.bIv.bId;
                                            if (view == chVar27.aap()) {
                                                SparseArray sparseArray2 = (SparseArray) view.getTag();
                                                if (sparseArray2 != null) {
                                                    if ("".equals(sparseArray2.get(com.baidu.tieba.v.tag_forbid_user_name)) || "".equals(sparseArray2.get(com.baidu.tieba.v.tag_del_post_id))) {
                                                        ciVar45 = this.bIv.bHY;
                                                        ciVar45.a(((Integer) sparseArray2.get(com.baidu.tieba.v.tag_del_post_type)).intValue(), (String) sparseArray2.get(com.baidu.tieba.v.tag_del_post_id), ((Integer) sparseArray2.get(com.baidu.tieba.v.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(com.baidu.tieba.v.tag_del_post_is_self)).booleanValue());
                                                    } else {
                                                        ciVar46 = this.bIv.bHY;
                                                        ciVar46.M(view);
                                                    }
                                                    morePopupWindow8 = this.bIv.bIc;
                                                    com.baidu.adp.lib.g.k.a(morePopupWindow8, this.bIv.getPageContext().getPageActivity());
                                                    return;
                                                }
                                                return;
                                            }
                                        }
                                        if (view.getId() != com.baidu.tieba.v.pb_head_function_manage_delormanage) {
                                            chVar4 = this.bIv.bId;
                                            if (chVar4 != null) {
                                                chVar26 = this.bIv.bId;
                                            }
                                            if (view.getId() != com.baidu.tieba.v.sub_pb_more && view.getId() != com.baidu.tieba.v.sub_pb_item) {
                                                int id = view.getId();
                                                if (id == com.baidu.tieba.v.pb_u9_text_view) {
                                                    com.baidu.tbadk.core.data.aa aaVar = (com.baidu.tbadk.core.data.aa) view.getTag();
                                                    if (aaVar != null && !StringUtils.isNull(aaVar.rb())) {
                                                        com.baidu.tbadk.core.util.bk.tl().b(this.bIv.getPageContext(), new String[]{aaVar.rb()});
                                                        return;
                                                    }
                                                    return;
                                                } else if (id == com.baidu.tieba.v.dialog_button_ok) {
                                                    bqVar13 = this.bIv.bHT;
                                                    com.baidu.tbadk.core.data.q ZT = bqVar13.ZT();
                                                    ciVar35 = this.bIv.bHY;
                                                    int pageNum = ciVar35.getPageNum();
                                                    if (pageNum <= 0) {
                                                        this.bIv.showToast(com.baidu.tieba.y.pb_page_error);
                                                        return;
                                                    } else if (ZT == null || pageNum <= ZT.qh()) {
                                                        ciVar36 = this.bIv.bHY;
                                                        ciVar36.abo();
                                                        this.bIv.stopVoice();
                                                        ciVar37 = this.bIv.bHY;
                                                        ciVar37.aaK();
                                                        bqVar14 = this.bIv.bHT;
                                                        ciVar38 = this.bIv.bHY;
                                                        bqVar14.hk(ciVar38.getPageNum());
                                                        return;
                                                    } else {
                                                        this.bIv.showToast(com.baidu.tieba.y.pb_page_error);
                                                        return;
                                                    }
                                                } else if (id == com.baidu.tieba.v.dialog_button_cancel) {
                                                    ciVar34 = this.bIv.bHY;
                                                    ciVar34.abo();
                                                    return;
                                                } else if (id == com.baidu.tieba.v.reply) {
                                                    morePopupWindow = this.bIv.bIc;
                                                    if (morePopupWindow != null) {
                                                        chVar20 = this.bIv.bId;
                                                    }
                                                    this.bIv.Zk();
                                                    morePopupWindow2 = this.bIv.bIc;
                                                    if (morePopupWindow2.getIsIntercepted()) {
                                                        morePopupWindow5 = this.bIv.bIc;
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
                                                        chVar10 = this.bIv.bId;
                                                        chVar10.aao().setTag(sparseArray4);
                                                        SparseArray sparseArray5 = new SparseArray();
                                                        sparseArray5.put(com.baidu.tieba.v.tag_clip_board, (com.baidu.tieba.tbadkCore.c.j) ((SparseArray) view.getTag()).get(com.baidu.tieba.v.tag_clip_board));
                                                        sparseArray5.put(com.baidu.tieba.v.tag_is_subpb, false);
                                                        chVar11 = this.bIv.bId;
                                                        chVar11.aad().setTag(sparseArray5);
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
                                                            chVar12 = this.bIv.bId;
                                                            chVar12.aap().setVisibility(8);
                                                        } else {
                                                            SparseArray sparseArray7 = new SparseArray();
                                                            sparseArray7.put(com.baidu.tieba.v.tag_manage_user_identity, sparseArray6.get(com.baidu.tieba.v.tag_manage_user_identity));
                                                            sparseArray7.put(com.baidu.tieba.v.tag_del_post_is_self, Boolean.valueOf(z));
                                                            sparseArray7.put(com.baidu.tieba.v.tag_del_post_id, sparseArray6.get(com.baidu.tieba.v.tag_del_post_id));
                                                            sparseArray7.put(com.baidu.tieba.v.tag_del_post_type, sparseArray6.get(com.baidu.tieba.v.tag_del_post_type));
                                                            sparseArray7.put(com.baidu.tieba.v.tag_forbid_user_name, sparseArray6.get(com.baidu.tieba.v.tag_forbid_user_name));
                                                            sparseArray7.put(com.baidu.tieba.v.tag_forbid_user_post_id, str);
                                                            chVar16 = this.bIv.bId;
                                                            chVar16.aap().setTag(sparseArray7);
                                                            if ("".equals(sparseArray6.get(com.baidu.tieba.v.tag_forbid_user_name)) || "".equals(sparseArray6.get(com.baidu.tieba.v.tag_del_post_id))) {
                                                                chVar17 = this.bIv.bId;
                                                                com.baidu.tbadk.core.util.ba.c(chVar17.aap(), com.baidu.tieba.u.icon_pb_del_n);
                                                            } else {
                                                                chVar19 = this.bIv.bId;
                                                                com.baidu.tbadk.core.util.ba.c(chVar19.aap(), com.baidu.tieba.u.icon_pb_set_n);
                                                            }
                                                            chVar18 = this.bIv.bId;
                                                            chVar18.aap().setVisibility(0);
                                                        }
                                                        dG = this.bIv.dG(z);
                                                        if (dG) {
                                                            chVar14 = this.bIv.bId;
                                                            chVar14.aaq().setVisibility(0);
                                                            chVar15 = this.bIv.bId;
                                                            chVar15.aaq().setTag(str);
                                                        } else {
                                                            chVar13 = this.bIv.bId;
                                                            chVar13.aaq().setVisibility(8);
                                                        }
                                                    }
                                                    boolean z4 = false;
                                                    bqVar11 = this.bIv.bHT;
                                                    if (bqVar11.getPbData().oQ()) {
                                                        bqVar12 = this.bIv.bHT;
                                                        String oP = bqVar12.getPbData().oP();
                                                        if (jVar != null && !com.baidu.adp.lib.util.m.isEmpty(oP) && oP.equals(jVar.getId())) {
                                                            z4 = true;
                                                        }
                                                    }
                                                    if (z4) {
                                                        chVar8 = this.bIv.bId;
                                                        chVar8.aad().setText(com.baidu.tieba.y.marked);
                                                        chVar9 = this.bIv.bId;
                                                        chVar9.aad().setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.ba.getDrawable(com.baidu.tieba.u.icon_pb_collect_s), (Drawable) null, (Drawable) null, (Drawable) null);
                                                    } else {
                                                        chVar5 = this.bIv.bId;
                                                        chVar5.aad().setText(com.baidu.tieba.y.mark);
                                                        chVar6 = this.bIv.bId;
                                                        chVar6.aad().setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.ba.getDrawable(com.baidu.tieba.u.icon_pb_collect_n), (Drawable) null, (Drawable) null, (Drawable) null);
                                                    }
                                                    chVar7 = this.bIv.bId;
                                                    chVar7.dR(true);
                                                    morePopupWindow3 = this.bIv.bIc;
                                                    morePopupWindow3.reLayoutWidth();
                                                    morePopupWindow4 = this.bIv.bIc;
                                                    morePopupWindow4.showWindowInLeftCenterOfHost(view, false);
                                                    return;
                                                } else if (id == com.baidu.tieba.v.sub_post_load_more) {
                                                    eVar2 = this.bIv.bHW;
                                                    if (eVar2.AT()) {
                                                        ciVar33 = this.bIv.bHY;
                                                        ciVar33.aaR();
                                                        return;
                                                    }
                                                    return;
                                                } else if (id == com.baidu.tieba.v.btn_loadprevious) {
                                                    eVar = this.bIv.bHW;
                                                    if (eVar.abW()) {
                                                        ciVar32 = this.bIv.bHY;
                                                        ciVar32.aaS();
                                                        return;
                                                    }
                                                    return;
                                                } else if (id != com.baidu.tieba.v.pb_head_reverse_hint) {
                                                    if (id == com.baidu.tieba.v.pb_act_btn) {
                                                        bqVar4 = this.bIv.bHT;
                                                        if (bqVar4.getPbData() != null) {
                                                            bqVar5 = this.bIv.bHT;
                                                            if (bqVar5.getPbData().YP() != null) {
                                                                bqVar6 = this.bIv.bHT;
                                                                if (bqVar6.getPbData().YP().qR() != null) {
                                                                    Activity activity = this.bIv.getActivity();
                                                                    bqVar7 = this.bIv.bHT;
                                                                    com.baidu.tbadk.browser.f.x(activity, bqVar7.getPbData().YP().qR());
                                                                    bqVar8 = this.bIv.bHT;
                                                                    if (bqVar8.getPbData().YP().qP() != 1) {
                                                                        bqVar9 = this.bIv.bHT;
                                                                        if (bqVar9.getPbData().YP().qP() == 2) {
                                                                            TiebaStatic.eventStat(this.bIv.getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "pb");
                                                                            return;
                                                                        }
                                                                        return;
                                                                    }
                                                                    TiebaStatic.eventStat(this.bIv.getPageContext().getPageActivity(), "lottery", "click", 1, "page", "pb");
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
                                                    this.bIv.stopVoice();
                                                    ciVar30 = this.bIv.bHY;
                                                    ciVar30.abo();
                                                    ciVar31 = this.bIv.bHY;
                                                    ciVar31.aaK();
                                                    bqVar10 = this.bIv.bHT;
                                                    bqVar10.ZX();
                                                    return;
                                                }
                                            }
                                            chVar21 = this.bIv.bId;
                                            if (chVar21 != null) {
                                                chVar24 = this.bIv.bId;
                                                if (view == chVar24.aao()) {
                                                    chVar25 = this.bIv.bId;
                                                    if (!chVar25.aan()) {
                                                        morePopupWindow7 = this.bIv.bIc;
                                                        com.baidu.adp.lib.g.k.a(morePopupWindow7, this.bIv.getPageContext().getPageActivity());
                                                        ciVar42 = this.bIv.bHY;
                                                        ciVar42.dU(true);
                                                        return;
                                                    }
                                                }
                                            }
                                            try {
                                                bqVar15 = this.bIv.bHT;
                                                if (bqVar15.getPbData() != null) {
                                                    ciVar39 = this.bIv.bHY;
                                                    ciVar39.abo();
                                                    SparseArray sparseArray8 = (SparseArray) view.getTag();
                                                    com.baidu.tieba.tbadkCore.c.j jVar2 = (com.baidu.tieba.tbadkCore.c.j) sparseArray8.get(com.baidu.tieba.v.tag_load_sub_data);
                                                    View view2 = (View) sparseArray8.get(com.baidu.tieba.v.tag_load_sub_view);
                                                    if (jVar2 != null && view2 != null) {
                                                        bqVar16 = this.bIv.bHT;
                                                        com.baidu.tieba.pb.a.c c = bqVar16.c(jVar2);
                                                        eVar3 = this.bIv.bHW;
                                                        bqVar17 = this.bIv.bHT;
                                                        eVar3.hN(bqVar17.ZN());
                                                        eVar4 = this.bIv.bHW;
                                                        eVar4.hx(jVar2.getId());
                                                        eVar5 = this.bIv.bHW;
                                                        eVar5.resetData();
                                                        this.bIv.stopVoice();
                                                        chVar22 = this.bIv.bId;
                                                        if (chVar22 != null) {
                                                            chVar23 = this.bIv.bId;
                                                            if (view == chVar23.aao()) {
                                                                morePopupWindow6 = this.bIv.bIc;
                                                                com.baidu.adp.lib.g.k.a(morePopupWindow6, this.bIv.getPageContext().getPageActivity());
                                                                ciVar41 = this.bIv.bHY;
                                                                bqVar19 = this.bIv.bHT;
                                                                ciVar41.a(true, c, false, null, null, view2, bqVar19.getPbData().YS());
                                                                return;
                                                            }
                                                        }
                                                        if (view.getId() == com.baidu.tieba.v.sub_pb_item) {
                                                            SparseArray sparseArray9 = (SparseArray) view.getTag();
                                                            String str2 = (String) sparseArray9.get(com.baidu.tieba.v.tag_photo_username);
                                                            com.baidu.tieba.tbadkCore.c.j jVar3 = (com.baidu.tieba.tbadkCore.c.j) sparseArray9.get(com.baidu.tieba.v.tag_clip_board);
                                                            String str3 = null;
                                                            if (jVar3 != null) {
                                                                str3 = jVar3.getId();
                                                            }
                                                            ciVar40 = this.bIv.bHY;
                                                            bqVar18 = this.bIv.bHT;
                                                            ciVar40.a(true, c, false, str2, str3, view2, bqVar18.getPbData().YS());
                                                            return;
                                                        }
                                                        int i2 = 0;
                                                        if (view.getTag(com.baidu.tieba.v.tag_subpb_pos) instanceof Integer) {
                                                            i2 = ((Integer) view.getTag(com.baidu.tieba.v.tag_subpb_pos)).intValue();
                                                        }
                                                        handler = this.bIv.mHandler;
                                                        handler.post(new bb(this, i2, c, view2));
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
                                            ciVar44 = this.bIv.bHY;
                                            ciVar44.M(view);
                                            return;
                                        }
                                        ciVar43 = this.bIv.bHY;
                                        ciVar43.a(((Integer) sparseArray10.get(com.baidu.tieba.v.tag_del_post_type)).intValue(), (String) sparseArray10.get(com.baidu.tieba.v.tag_del_post_id), ((Integer) sparseArray10.get(com.baidu.tieba.v.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray10.get(com.baidu.tieba.v.tag_del_post_is_self)).booleanValue());
                                        return;
                                    }
                                    this.bIv.Zg();
                                    return;
                                }
                                TiebaStatic.eventStat(this.bIv.getPageContext().getPageActivity(), "pb_header_forum_name", "pbclick", 1, new Object[0]);
                                bqVar41 = this.bIv.bHT;
                                String name = bqVar41.getPbData().YO().getName();
                                bqVar42 = this.bIv.bHT;
                                if (!TextUtils.isEmpty(bqVar42.ZM())) {
                                    bqVar43 = this.bIv.bHT;
                                    if (bqVar43.ZM().equals(name)) {
                                        this.bIv.finish();
                                        return;
                                    }
                                }
                                if (com.baidu.tbadk.core.util.bd.aK(name)) {
                                    this.bIv.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.bIv.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_PB)));
                                    return;
                                }
                                return;
                            }
                            morePopupWindow11 = this.bIv.bIc;
                            if (morePopupWindow11 != null) {
                                chVar41 = this.bIv.bId;
                            }
                            this.bIv.Zk();
                            com.baidu.tieba.tbadkCore.c.j jVar4 = null;
                            if (view != null && view.getTag() != null) {
                                jVar4 = (com.baidu.tieba.tbadkCore.c.j) ((SparseArray) view.getTag()).get(com.baidu.tieba.v.tag_clip_board);
                                SparseArray sparseArray11 = new SparseArray();
                                sparseArray11.put(com.baidu.tieba.v.tag_clip_board, jVar4);
                                sparseArray11.put(com.baidu.tieba.v.tag_is_subpb, false);
                                chVar40 = this.bIv.bId;
                                chVar40.aad().setTag(sparseArray11);
                            }
                            bqVar44 = this.bIv.bHT;
                            if (bqVar44.getPbData() != null) {
                                bqVar45 = this.bIv.bHT;
                                if (bqVar45.getPbData().oQ()) {
                                    bqVar46 = this.bIv.bHT;
                                    String oP2 = bqVar46.getPbData().oP();
                                    if (jVar4 != null && !com.baidu.adp.lib.util.m.isEmpty(oP2) && oP2.equals(jVar4.getId())) {
                                        z3 = true;
                                        if (!z3) {
                                            chVar38 = this.bIv.bId;
                                            chVar38.aad().setText(com.baidu.tieba.y.marked);
                                            chVar39 = this.bIv.bId;
                                            chVar39.aad().setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.ba.getDrawable(com.baidu.tieba.u.icon_pb_collect_s), (Drawable) null, (Drawable) null, (Drawable) null);
                                        } else {
                                            chVar30 = this.bIv.bId;
                                            chVar30.aad().setText(com.baidu.tieba.y.mark);
                                            chVar31 = this.bIv.bId;
                                            chVar31.aad().setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.ba.getDrawable(com.baidu.tieba.u.icon_pb_collect_n), (Drawable) null, (Drawable) null, (Drawable) null);
                                        }
                                        if (view != null && view.getTag() != null) {
                                            sparseArray = (SparseArray) view.getTag();
                                            if (((Boolean) sparseArray.get(com.baidu.tieba.v.tag_should_manage_visible)).booleanValue()) {
                                                chVar33 = this.bIv.bId;
                                                chVar33.aap().setVisibility(8);
                                            } else {
                                                SparseArray sparseArray12 = new SparseArray();
                                                sparseArray12.put(com.baidu.tieba.v.tag_manage_user_identity, sparseArray.get(com.baidu.tieba.v.tag_manage_user_identity));
                                                sparseArray12.put(com.baidu.tieba.v.tag_del_post_is_self, sparseArray.get(com.baidu.tieba.v.tag_del_post_is_self));
                                                sparseArray12.put(com.baidu.tieba.v.tag_del_post_id, sparseArray.get(com.baidu.tieba.v.tag_del_post_id));
                                                sparseArray12.put(com.baidu.tieba.v.tag_del_post_type, sparseArray.get(com.baidu.tieba.v.tag_del_post_type));
                                                sparseArray12.put(com.baidu.tieba.v.tag_forbid_user_name, sparseArray.get(com.baidu.tieba.v.tag_forbid_user_name));
                                                sparseArray12.put(com.baidu.tieba.v.tag_forbid_user_post_id, sparseArray.get(com.baidu.tieba.v.tag_forbid_user_post_id));
                                                chVar34 = this.bIv.bId;
                                                chVar34.aap().setTag(sparseArray12);
                                                if ("".equals(sparseArray.get(com.baidu.tieba.v.tag_forbid_user_name)) || "".equals(sparseArray.get(com.baidu.tieba.v.tag_del_post_id))) {
                                                    chVar35 = this.bIv.bId;
                                                    com.baidu.tbadk.core.util.ba.c(chVar35.aap(), com.baidu.tieba.u.icon_pb_del_n);
                                                } else {
                                                    chVar37 = this.bIv.bId;
                                                    com.baidu.tbadk.core.util.ba.c(chVar37.aap(), com.baidu.tieba.u.icon_pb_set_n);
                                                }
                                                chVar36 = this.bIv.bId;
                                                chVar36.aap().setVisibility(0);
                                            }
                                        }
                                        chVar32 = this.bIv.bId;
                                        chVar32.dR(false);
                                        morePopupWindow12 = this.bIv.bIc;
                                        morePopupWindow12.reLayoutWidth();
                                        morePopupWindow13 = this.bIv.bIc;
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
                            chVar32 = this.bIv.bId;
                            chVar32.dR(false);
                            morePopupWindow12 = this.bIv.bIc;
                            morePopupWindow12.reLayoutWidth();
                            morePopupWindow13 = this.bIv.bIc;
                            morePopupWindow13.showWindowInLeftCenterOfHost(view, false);
                            return;
                        }
                    }
                }
            }
        }
        ciVar4 = this.bIv.bHY;
        ciVar4.abp();
        bqVar = this.bIv.bHT;
        if (bqVar.getPbData().YS() == 1) {
            aVar = this.bIv.bHX;
            if (!aVar.anm()) {
                ciVar5 = this.bIv.bHY;
                ciVar5.aaG();
                int i3 = 0;
                ciVar6 = this.bIv.bHY;
                if (view != ciVar6.abi()) {
                    ciVar7 = this.bIv.bHY;
                    if (view != ciVar7.abj()) {
                        ciVar8 = this.bIv.bHY;
                        if (view != ciVar8.abk()) {
                            ciVar9 = this.bIv.bHY;
                            if (view != ciVar9.abl()) {
                                ciVar10 = this.bIv.bHY;
                                if (view == ciVar10.aaH()) {
                                    i3 = 2;
                                }
                            } else {
                                i3 = 5;
                            }
                        } else {
                            i3 = 4;
                        }
                    } else {
                        i3 = 3;
                    }
                } else {
                    i3 = 6;
                }
                bqVar2 = this.bIv.bHT;
                ForumData YO2 = bqVar2.getPbData().YO();
                String name2 = YO2.getName();
                String id2 = YO2.getId();
                bqVar3 = this.bIv.bHT;
                String id3 = bqVar3.getPbData().YP().getId();
                aVar2 = this.bIv.bHX;
                ciVar11 = this.bIv.bHY;
                aVar2.b(id2, name2, id3, i3, ciVar11.aaI());
            }
        }
    }
}
