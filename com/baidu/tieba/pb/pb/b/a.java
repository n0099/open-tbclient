package com.baidu.tieba.pb.pb.b;

import android.content.res.Resources;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.pb.pb.main.GetLotteryChanceActivityConfig;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.PbLotteryHttpResponseMessage;
import com.baidu.tieba.pb.pb.main.PbLotteryRequestMessage;
import com.baidu.tieba.pb.pb.main.cw;
import com.baidu.tieba.pb.pb.main.el;
import com.baidu.tieba.pb.pb.main.g;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.y;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.base.e<PbActivity> {
    private PbActivity dhQ;
    private PbLotteryHttpResponseMessage dhR;
    private HttpMessageListener dhS;
    private boolean mIsSenior;

    public boolean awh() {
        return this.mIsSenior;
    }

    public a(PbActivity pbActivity, boolean z) {
        super(pbActivity.getPageContext());
        this.dhS = new b(this, CmdConfigHttp.PB_LOTTERY_HTTP_CMD);
        this.mIsSenior = z;
        this.dhQ = pbActivity;
        this.dhS.setSelfListener(true);
        registerListener(this.dhS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean awi() {
        cw awu = this.dhQ.awu();
        return (awu == null || awu.getPbData() == null || !awu.getPbData().avG()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lG(int i) {
        cw awu = this.dhQ.awu();
        if (awu != null && awu.getPbData() != null && awu.getPbData().avA() != null) {
            awu.getPbData().avA().setLike(i);
            y yVar = new y();
            yVar.setLike(i);
            yVar.setUserLevel(-1);
            yVar.setLevelName("");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, yVar));
        }
    }

    public void awj() {
        if (this.dhQ.checkUpIsLogin()) {
            el awt = this.dhQ.awt();
            cw awu = this.dhQ.awu();
            if (awt != null) {
                awt.amQ();
                awt.ayH();
            }
            if (awu == null || awu.getPbData() == null || awu.getPbData().avA() == null) {
                lH(5);
                return;
            }
            com.baidu.tieba.pb.data.e pbData = awu.getPbData();
            if (pbData.avA().isLike() == 0) {
                lH(2);
            } else if (!this.dhQ.isProgressBarShown()) {
                if (pbData.avA() != null && pbData.avB() != null && pbData.avB().qU() != null && pbData.avB().qU().size() > 0 && pbData.avB().qU().get(0) != null) {
                    String id = pbData.avA().getId();
                    String id2 = pbData.avB().getId();
                    int activityId = pbData.avB().qU().get(0).getActivityId();
                    int ov = pbData.avB().qU().get(0).ov();
                    int ow = pbData.avB().qU().get(0).ow();
                    if (MessageManager.getInstance().findMessage(CmdConfigHttp.PB_LOTTERY_HTTP_CMD, getUniqueId()) == null || MessageManager.getInstance().findMessage(CmdConfigHttp.PB_LOTTERY_HTTP_CMD, getUniqueId()).size() == 0) {
                        if (!awi()) {
                            this.dhQ.showProgressBar(true, 0, 0);
                        }
                        sendMessage(new PbLotteryRequestMessage(TbadkCoreApplication.getCurrentAccount(), TbadkCoreApplication.getCurrentAccountName(), id, id2, 0, activityId, ov, ow, this.mIsSenior));
                        return;
                    }
                }
                lH(5);
            } else {
                return;
            }
            TiebaStatic.log(new aw("c10396").ac("fid", pbData.getForumId()).ac("tid", pbData.getThreadId()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(int i, String str) {
        this.dhQ.awt().ayE().G(i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lH(int i) {
        this.dhQ.awt().ayE().G(i, null);
    }

    public void H(int i, String str) {
        int type;
        if (this.dhR != null) {
            type = this.dhR.getType();
        } else {
            type = getType();
        }
        switch (type) {
            case 0:
                c(true, this.dhR);
                break;
            case 1:
                b(true, this.dhR);
                break;
            case 2:
                a(true, this.dhR);
                break;
            case 3:
                awk();
                break;
            case 4:
                b(this.dhR);
                break;
            default:
                a(this.dhR);
                break;
        }
        this.dhR = null;
    }

    private int getType() {
        cw awu = this.dhQ.awu();
        return (awu == null || awu.getPbData() == null || awu.getPbData().avA() == null || awu.getPbData().avA().isLike() != 0) ? 5 : 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PbLotteryHttpResponseMessage pbLotteryHttpResponseMessage) {
        if (pbLotteryHttpResponseMessage == null) {
            this.dhQ.showToast(t.j.neterror);
        } else if (pbLotteryHttpResponseMessage.hasError()) {
            if (!StringUtils.isNULL(pbLotteryHttpResponseMessage.getErrorString())) {
                this.dhQ.showToast(pbLotteryHttpResponseMessage.getErrorString());
            } else {
                this.dhQ.showToast(t.j.neterror);
            }
        } else if (pbLotteryHttpResponseMessage.getLotteryInfo() != null && !StringUtils.isNULL(pbLotteryHttpResponseMessage.getLotteryInfo().getStatusMsg())) {
            this.dhQ.showToast(pbLotteryHttpResponseMessage.getLotteryInfo().getStatusMsg());
        } else {
            this.dhQ.showToast(t.j.neterror);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, PbLotteryHttpResponseMessage pbLotteryHttpResponseMessage) {
        com.baidu.tieba.pb.pb.main.g gVar = new com.baidu.tieba.pb.pb.main.g(this.dhQ.getActivity());
        g.c cVar = new g.c();
        cVar.bLj = this.dhQ.getPageContext();
        Resources resources = this.dhQ.getResources();
        cVar.dis = resources.getString(t.j.no_attention_on_forum);
        cVar.dit = resources.getString(t.j.attention_before_lottery);
        cVar.dio = resources.getString(t.j.cancel);
        cVar.dip = resources.getString(t.j.attention);
        cVar.diq = new d(this);
        cVar.dir = new e(this, z);
        gVar.a(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awk() {
        com.baidu.tieba.pb.pb.main.g gVar = new com.baidu.tieba.pb.pb.main.g(this.dhQ.getActivity());
        g.c cVar = new g.c();
        cVar.bLj = this.dhQ.getPageContext();
        Resources resources = this.dhQ.getResources();
        cVar.dis = resources.getString(t.j.no_lottery_chance_tip);
        cVar.dit = resources.getString(t.j.get_more_lottery_chance_tip);
        cVar.dio = null;
        cVar.dip = resources.getString(t.j.confirm);
        cVar.diq = null;
        cVar.dir = new f(this);
        gVar.a(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(PbLotteryHttpResponseMessage pbLotteryHttpResponseMessage) {
        cw awu = this.dhQ.awu();
        if (awu != null) {
            PbLotteryRequestMessage pbLotteryRequestMessage = (PbLotteryRequestMessage) pbLotteryHttpResponseMessage.getOrginalMessage().getExtra();
            if (!this.dhQ.awT() && pbLotteryRequestMessage != null && awu.getPbData() != null && awu.getPbData().avA() != null && TbadkCoreApplication.m11getInst().appResponseToIntentClass(GetLotteryChanceActivityConfig.class)) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GetLotteryChanceActivityConfig(this.dhQ.getPageContext().getPageActivity(), pbLotteryHttpResponseMessage.getLotteryInfo().avw(), 24006, awu.getPbData().avA().getName(), pbLotteryRequestMessage.getForumId(), pbLotteryRequestMessage.getThreadId(), pbLotteryRequestMessage.getAwardActId(), awu.getPbData().avA().getSigned())));
            } else {
                this.dhQ.showToast(t.j.system_error);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z, PbLotteryHttpResponseMessage pbLotteryHttpResponseMessage) {
        String string;
        com.baidu.tieba.pb.pb.main.g gVar = new com.baidu.tieba.pb.pb.main.g(this.dhQ.getActivity());
        g.d dVar = new g.d();
        dVar.bLj = this.dhQ.getPageContext();
        Resources resources = this.dhQ.getResources();
        dVar.diu = resources.getString(t.j.aiyaya);
        dVar.div = resources.getString(t.j.not_win_lottery_tip);
        int chanceCount = (int) pbLotteryHttpResponseMessage.getLotteryInfo().avw().getChanceCount();
        dVar.diw = lI(chanceCount);
        dVar.dio = resources.getString(t.j.cancel);
        if (chanceCount <= 0) {
            string = resources.getString(t.j.add_lottery_chance);
        } else {
            string = resources.getString(t.j.continue_lottery_tip);
        }
        dVar.dip = string;
        dVar.diq = new g(this);
        dVar.dir = new h(this, pbLotteryHttpResponseMessage, z);
        gVar.a(dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awl() {
        this.dhQ.awt().ayE().awl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, PbLotteryHttpResponseMessage pbLotteryHttpResponseMessage) {
        com.baidu.tieba.pb.pb.main.g gVar = new com.baidu.tieba.pb.pb.main.g(this.dhQ.getActivity());
        g.a aVar = new g.a();
        aVar.bLj = this.dhQ.getPageContext();
        Resources resources = this.dhQ.getResources();
        aVar.dil = resources.getString(t.j.congratulation_to_get_lottery);
        aVar.dim = resources.getString(t.j.lottery_detail, pbLotteryHttpResponseMessage.getLotteryInfo().avv().avu());
        aVar.din = pbLotteryHttpResponseMessage.getLotteryInfo().avv().avt();
        aVar.dio = resources.getString(t.j.cancel);
        aVar.dip = resources.getString(t.j.check_immediately);
        aVar.diq = new i(this);
        aVar.dir = new j(this, pbLotteryHttpResponseMessage);
        gVar.a(aVar);
    }

    private CharSequence lI(int i) {
        String string = this.dhQ.getResources().getString(t.j.enable_lottery_chance_tip, Integer.valueOf(i));
        SpannableString spannableString = new SpannableString(string);
        int indexOf = string.indexOf(String.valueOf(i));
        spannableString.setSpan(new ForegroundColorSpan(at.getColor(t.d.cp_cont_h)), indexOf, String.valueOf(i).length() + indexOf, 33);
        return spannableString;
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }
}
