package com.baidu.tieba.pb.pb.main.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BarVoteActivityConfig;
import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.data.CommitVoteResMsg;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.d;
import com.baidu.tieba.pb.data.e;
import com.baidu.tieba.pb.data.h;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.util.f;
import com.baidu.tieba.view.VoteCountDownView;
import java.util.HashMap;
import java.util.Iterator;
/* loaded from: classes9.dex */
public class a {
    private e iEU;
    private TextView iTA;
    private TextView iTB;
    private TextView iTC;
    private View iTD;
    private TextView iTE;
    private VoteCountDownView iTF;
    private View iTG;
    private TextView iTH;
    private TextView iTI;
    private TextView iTJ;
    private h iTx;
    private TextView iTy;
    private View iTz;
    private TbPageContext mPageContext;
    private View mRootView;
    private int status;
    private VoteCountDownView.a fHb = new VoteCountDownView.a() { // from class: com.baidu.tieba.pb.pb.main.view.a.1
        @Override // com.baidu.tieba.view.VoteCountDownView.a
        public void onFinished() {
            if (a.this.mRootView != null) {
                if (a.this.iEU == null || a.this.iEU.iBR == null) {
                    a.this.mRootView.setVisibility(8);
                    return;
                }
                a.this.iEU.iBR.setStatus(3);
                a.this.setData(a.this.iEU);
            }
        }
    };
    private View.OnClickListener drw = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.pb_jump_to_vote_page) {
                if (a.this.iEU != null && a.this.mPageContext != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921408, new BarVoteActivityConfig(a.this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(a.this.iEU.getForumId(), 0L), 3)));
                }
            } else if (view.getId() == R.id.pb_vote_button && bc.checkUpIsLogin(a.this.mPageContext.getPageActivity()) && a.this.iEU != null && a.this.iTx != null && a.this.iEU.ckv() != null) {
                if (a.this.iTx.bug()) {
                    new an("c13444").cy("forum_id", a.this.iEU.getForumId()).aGz();
                    d dVar = new d();
                    dVar.setThreadId(com.baidu.adp.lib.f.b.toLong(a.this.iEU.getThreadId(), 0L));
                    dVar.setForumId(com.baidu.adp.lib.f.b.toLong(a.this.iEU.getForumId(), 0L));
                    String str = "";
                    PostData F = a.this.F(a.this.iEU);
                    if (F != null && F.aCo() != null) {
                        str = F.aCo().getUserId();
                    }
                    dVar.er(com.baidu.adp.lib.f.b.toLong(str, 0L));
                    dVar.yw(2);
                    dVar.r(a.this.mPageContext.getUniqueId());
                    CustomMessage customMessage = new CustomMessage(2921411);
                    customMessage.setData(dVar);
                    MessageManager.getInstance().sendMessage(customMessage);
                    return;
                }
                l.showToast(TbadkCoreApplication.getInst(), (int) R.string.has_not_other_ticket);
            }
        }
    };
    private HttpMessageListener fCw = new HttpMessageListener(CmdConfigHttp.CMD_BAR_VOTE) { // from class: com.baidu.tieba.pb.pb.main.view.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            String errorString;
            if (httpResponsedMessage != null && httpResponsedMessage.getOrginalMessage() != null) {
                int error = httpResponsedMessage.getError();
                if ((httpResponsedMessage instanceof CommitVoteResMsg) && a.this.iEU != null && a.this.iEU.iBR != null && a.this.mPageContext != null && httpResponsedMessage.getOrginalMessage().getTag() == a.this.mPageContext.getUniqueId()) {
                    if (error == 0) {
                        l.showToast(TbadkCoreApplication.getInst(), (int) R.string.bar_manager_vote_success);
                        a.this.iEU.iBR.yB(a.this.iEU.iBR.cla() + 1);
                        a.this.iEU.iBR.ke(false);
                        a.this.setData(a.this.iEU);
                    } else if (error == 3250023) {
                        f.a(error, "", (f.a) null);
                    } else if (error == 3250021) {
                        f.a(error, ((CommitVoteResMsg) httpResponsedMessage).getTokenData(), (f.a) null);
                    } else if (error == 3250002 || error == 3250004) {
                        BlockPopInfoData blockPopInfoData = new BlockPopInfoData();
                        if (aq.isEmpty(httpResponsedMessage.getErrorString())) {
                            errorString = a.this.mPageContext.getResources().getString(R.string.block_user_tip);
                        } else {
                            errorString = httpResponsedMessage.getErrorString();
                        }
                        blockPopInfoData.block_info = errorString;
                        blockPopInfoData.ahead_info = a.this.mPageContext.getResources().getString(R.string.block_user_feed);
                        blockPopInfoData.ok_info = a.this.mPageContext.getResources().getString(R.string.know);
                        blockPopInfoData.ahead_url = "http://tieba.baidu.com/mo/q/userappeal";
                        AntiHelper.a(a.this.mPageContext.getPageActivity(), blockPopInfoData);
                    } else {
                        l.showToast(TbadkCoreApplication.getInst(), httpResponsedMessage.getErrorString());
                    }
                }
            }
        }
    };

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public View E(e eVar) {
        if (this.mPageContext == null) {
            return null;
        }
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.bar_manager_select_view, (ViewGroup) null);
        this.iTy = (TextView) this.mRootView.findViewById(R.id.pb_bar_manager_select_warn);
        this.iTz = this.mRootView.findViewById(R.id.pb_vote_button_container);
        this.iTE = (TextView) this.mRootView.findViewById(R.id.pb_count_down_title);
        this.iTB = (TextView) this.mRootView.findViewById(R.id.pb_vote_button);
        this.iTA = (TextView) this.mRootView.findViewById(R.id.pb_vote_num);
        this.iTC = (TextView) this.mRootView.findViewById(R.id.pb_bar_manager_ueg_tip);
        this.iTD = this.mRootView.findViewById(R.id.pb_count_down_container);
        this.iTF = (VoteCountDownView) this.mRootView.findViewById(R.id.pb_vote_count_down_view);
        this.iTG = this.mRootView.findViewById(R.id.pb_vote_rule);
        this.iTH = (TextView) this.mRootView.findViewById(R.id.pb_vote_rule_title);
        this.iTI = (TextView) this.mRootView.findViewById(R.id.pb_vote_rule_content);
        this.iTJ = (TextView) this.mRootView.findViewById(R.id.pb_jump_to_vote_page);
        MessageManager.getInstance().registerListener(this.fCw);
        setData(eVar);
        return this.mRootView;
    }

    public void setData(e eVar) {
        if (this.mRootView != null) {
            if (eVar == null || eVar.iBR == null) {
                this.mRootView.setVisibility(8);
                return;
            }
            this.iEU = eVar;
            this.iTx = eVar.iBR;
            if (this.iTx.getStatus() != 0) {
                this.status = this.iTx.getStatus();
                if (this.status == 2) {
                    this.iTz.setVisibility(8);
                    this.iTD.setVisibility(0);
                    this.iTF.setOnCountDownFinished(this.fHb);
                    this.iTF.setData(this.iTx.ckZ() * 1000);
                    this.iTJ.setVisibility(8);
                } else if (this.status == 3) {
                    this.iTz.setVisibility(0);
                    this.iTB.setOnClickListener(this.drw);
                    this.iTD.setVisibility(8);
                    this.iTJ.setVisibility(0);
                    this.iTJ.setOnClickListener(this.drw);
                    this.iTA.setText(this.iTx.cla() + "票");
                } else if (this.status == 4 || this.status == 5) {
                    this.iTz.setVisibility(0);
                    this.iTB.setEnabled(false);
                    this.iTD.setVisibility(8);
                    this.iTJ.setVisibility(0);
                    this.iTJ.setOnClickListener(this.drw);
                    this.iTA.setText(this.iTx.cla() + "票");
                } else if (this.status == 6) {
                    this.iTz.setVisibility(0);
                    this.iTB.setEnabled(false);
                    this.iTD.setVisibility(8);
                    this.iTA.setText(this.iTx.cla() + "票");
                    this.iTJ.setVisibility(8);
                } else {
                    this.mRootView.setVisibility(8);
                    return;
                }
                if (this.iTx.clb() != null && !v.isEmpty(this.iTx.clb())) {
                    StringBuilder sb = new StringBuilder(this.iTx.clb().get(0));
                    int i = 1;
                    while (i < this.iTx.clb().size()) {
                        StringBuilder append = sb.append("\n").append(this.iTx.clb().get(i));
                        i++;
                        sb = append;
                    }
                    this.iTI.setText(sb);
                }
                pk(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public void pk(int i) {
        am.setViewTextColor(this.iTA, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.iTy, R.color.cp_cont_d, 1, i);
        am.setViewTextColor(this.iTC, R.color.cp_cont_d, 1, i);
        am.setViewTextColor(this.iTH, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.iTI, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.iTJ, R.color.cp_link_tip_c, 1, i);
        am.setViewTextColor(this.iTE, R.color.cp_cont_b, 1, i);
        am.setBackgroundResource(this.iTB, R.drawable.pb_vote_button_bg, i);
        am.setBackgroundColor(this.iTG, R.color.cp_bg_line_e, i);
        if (this.iTF != null) {
            this.iTF.pk(i);
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public PostData F(e eVar) {
        PostData postData;
        if (eVar == null) {
            return null;
        }
        if (eVar.ckF() != null) {
            return eVar.ckF();
        }
        if (!v.isEmpty(eVar.ckx())) {
            Iterator<PostData> it = eVar.ckx().iterator();
            while (it.hasNext()) {
                postData = it.next();
                if (postData != null && postData.cLb() == 1) {
                    break;
                }
            }
        }
        postData = null;
        if (postData == null) {
            postData = eVar.ckC();
        }
        if (postData == null) {
            postData = a(eVar);
        }
        if (postData != null && postData.aCo() != null && postData.aCo().getUserTbVipInfoData() != null && postData.aCo().getUserTbVipInfoData().getvipIntro() != null) {
            postData.aCo().getGodUserData().setIntro(postData.aCo().getUserTbVipInfoData().getvipIntro());
            return postData;
        }
        return postData;
    }

    private PostData a(e eVar) {
        MetaData metaData;
        if (eVar == null || eVar.ckv() == null || eVar.ckv().aCo() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData aCo = eVar.ckv().aCo();
        String userId = aCo.getUserId();
        HashMap<String, MetaData> userMap = eVar.ckv().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = aCo;
        }
        postData.Cw(1);
        postData.setId(eVar.ckv().aCE());
        postData.setTitle(eVar.ckv().getTitle());
        postData.setTime(eVar.ckv().getCreateTime());
        postData.a(metaData);
        return postData;
    }
}
