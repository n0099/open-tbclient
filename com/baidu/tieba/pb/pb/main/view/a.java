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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.data.CommitVoteResMsg;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.d;
import com.baidu.tieba.pb.data.g;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.util.f;
import com.baidu.tieba.view.VoteCountDownView;
import java.util.HashMap;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class a {
    private d hGE;
    private g hRW;
    private TextView hRX;
    private View hRY;
    private TextView hRZ;
    private TextView hSa;
    private TextView hSb;
    private View hSc;
    private TextView hSd;
    private VoteCountDownView hSe;
    private View hSf;
    private TextView hSg;
    private TextView hSh;
    private TextView hSi;
    private TbPageContext mPageContext;
    private View mRootView;
    private int status;
    private VoteCountDownView.a euB = new VoteCountDownView.a() { // from class: com.baidu.tieba.pb.pb.main.view.a.1
        @Override // com.baidu.tieba.view.VoteCountDownView.a
        public void onFinished() {
            if (a.this.mRootView != null) {
                if (a.this.hGE == null || a.this.hGE.hBG == null) {
                    a.this.mRootView.setVisibility(8);
                    return;
                }
                a.this.hGE.hBG.setStatus(3);
                a.this.setData(a.this.hGE);
            }
        }
    };
    private View.OnClickListener ckH = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.pb_jump_to_vote_page) {
                if (a.this.hGE != null && a.this.mPageContext != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921408, new BarVoteActivityConfig(a.this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.c(a.this.hGE.getForumId(), 0L), 3)));
                }
            } else if (view.getId() == R.id.pb_vote_button && bc.cE(a.this.mPageContext.getPageActivity()) && a.this.hGE != null && a.this.hRW != null && a.this.hGE.bPL() != null) {
                if (a.this.hRW.aWQ()) {
                    new am("c13444").bT("forum_id", a.this.hGE.getForumId()).aif();
                    com.baidu.tieba.pb.d dVar = new com.baidu.tieba.pb.d();
                    dVar.setThreadId(com.baidu.adp.lib.g.b.c(a.this.hGE.getThreadId(), 0L));
                    dVar.setForumId(com.baidu.adp.lib.g.b.c(a.this.hGE.getForumId(), 0L));
                    String str = "";
                    PostData t = a.this.t(a.this.hGE);
                    if (t != null && t.adv() != null) {
                        str = t.adv().getUserId();
                    }
                    dVar.dZ(com.baidu.adp.lib.g.b.c(str, 0L));
                    dVar.setSource(2);
                    dVar.p(a.this.mPageContext.getUniqueId());
                    CustomMessage customMessage = new CustomMessage(2921411);
                    customMessage.setData(dVar);
                    MessageManager.getInstance().sendMessage(customMessage);
                    return;
                }
                l.showToast(TbadkCoreApplication.getInst(), (int) R.string.has_not_other_ticket);
            }
        }
    };
    private HttpMessageListener epQ = new HttpMessageListener(CmdConfigHttp.CMD_BAR_VOTE) { // from class: com.baidu.tieba.pb.pb.main.view.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            String errorString;
            if (httpResponsedMessage != null && httpResponsedMessage.getOrginalMessage() != null) {
                int error = httpResponsedMessage.getError();
                if ((httpResponsedMessage instanceof CommitVoteResMsg) && a.this.hGE != null && a.this.hGE.hBG != null && a.this.mPageContext != null && httpResponsedMessage.getOrginalMessage().getTag() == a.this.mPageContext.getUniqueId()) {
                    if (error == 0) {
                        l.showToast(TbadkCoreApplication.getInst(), (int) R.string.bar_manager_vote_success);
                        a.this.hGE.hBG.wZ(a.this.hGE.hBG.bQo() + 1);
                        a.this.hGE.hBG.il(false);
                        a.this.setData(a.this.hGE);
                    } else if (error == 3250023) {
                        f.a(error, "", (f.a) null);
                    } else if (error == 3250021) {
                        f.a(error, ((CommitVoteResMsg) httpResponsedMessage).getTokenData(), (f.a) null);
                    } else if (error == 3250002 || error == 3250004) {
                        BlockPopInfoData blockPopInfoData = new BlockPopInfoData();
                        if (ap.isEmpty(httpResponsedMessage.getErrorString())) {
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

    public View s(d dVar) {
        if (this.mPageContext == null) {
            return null;
        }
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.bar_manager_select_view, (ViewGroup) null);
        this.hRX = (TextView) this.mRootView.findViewById(R.id.pb_bar_manager_select_warn);
        this.hRY = this.mRootView.findViewById(R.id.pb_vote_button_container);
        this.hSd = (TextView) this.mRootView.findViewById(R.id.pb_count_down_title);
        this.hSa = (TextView) this.mRootView.findViewById(R.id.pb_vote_button);
        this.hRZ = (TextView) this.mRootView.findViewById(R.id.pb_vote_num);
        this.hSb = (TextView) this.mRootView.findViewById(R.id.pb_bar_manager_ueg_tip);
        this.hSc = this.mRootView.findViewById(R.id.pb_count_down_container);
        this.hSe = (VoteCountDownView) this.mRootView.findViewById(R.id.pb_vote_count_down_view);
        this.hSf = this.mRootView.findViewById(R.id.pb_vote_rule);
        this.hSg = (TextView) this.mRootView.findViewById(R.id.pb_vote_rule_title);
        this.hSh = (TextView) this.mRootView.findViewById(R.id.pb_vote_rule_content);
        this.hSi = (TextView) this.mRootView.findViewById(R.id.pb_jump_to_vote_page);
        MessageManager.getInstance().registerListener(this.epQ);
        setData(dVar);
        return this.mRootView;
    }

    public void setData(d dVar) {
        if (this.mRootView != null) {
            if (dVar == null || dVar.hBG == null) {
                this.mRootView.setVisibility(8);
                return;
            }
            this.hGE = dVar;
            this.hRW = dVar.hBG;
            if (this.hRW.getStatus() != 0) {
                this.status = this.hRW.getStatus();
                if (this.status == 2) {
                    this.hRY.setVisibility(8);
                    this.hSc.setVisibility(0);
                    this.hSe.setOnCountDownFinished(this.euB);
                    this.hSe.setData(this.hRW.bQn() * 1000);
                    this.hSi.setVisibility(8);
                } else if (this.status == 3) {
                    this.hRY.setVisibility(0);
                    this.hSa.setOnClickListener(this.ckH);
                    this.hSc.setVisibility(8);
                    this.hSi.setVisibility(0);
                    this.hSi.setOnClickListener(this.ckH);
                    this.hRZ.setText(this.hRW.bQo() + "票");
                } else if (this.status == 4 || this.status == 5) {
                    this.hRY.setVisibility(0);
                    this.hSa.setEnabled(false);
                    this.hSc.setVisibility(8);
                    this.hSi.setVisibility(0);
                    this.hSi.setOnClickListener(this.ckH);
                    this.hRZ.setText(this.hRW.bQo() + "票");
                } else if (this.status == 6) {
                    this.hRY.setVisibility(0);
                    this.hSa.setEnabled(false);
                    this.hSc.setVisibility(8);
                    this.hRZ.setText(this.hRW.bQo() + "票");
                    this.hSi.setVisibility(8);
                } else {
                    this.mRootView.setVisibility(8);
                    return;
                }
                if (this.hRW.bQp() != null && !v.aa(this.hRW.bQp())) {
                    StringBuilder sb = new StringBuilder(this.hRW.bQp().get(0));
                    int i = 1;
                    while (i < this.hRW.bQp().size()) {
                        StringBuilder append = sb.append("\n").append(this.hRW.bQp().get(i));
                        i++;
                        sb = append;
                    }
                    this.hSh.setText(sb);
                }
                nq(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public void nq(int i) {
        al.c(this.hRZ, R.color.cp_cont_b, 1, i);
        al.c(this.hRX, R.color.cp_cont_d, 1, i);
        al.c(this.hSb, R.color.cp_cont_d, 1, i);
        al.c(this.hSg, R.color.cp_cont_b, 1, i);
        al.c(this.hSh, R.color.cp_cont_b, 1, i);
        al.c(this.hSi, R.color.cp_link_tip_c, 1, i);
        al.c(this.hSd, R.color.cp_cont_b, 1, i);
        al.g(this.hSa, R.drawable.pb_vote_button_bg, i);
        al.h(this.hSf, R.color.cp_bg_line_e, i);
        if (this.hSe != null) {
            this.hSe.nq(i);
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public PostData t(d dVar) {
        PostData postData;
        if (dVar == null) {
            return null;
        }
        if (dVar.bPV() != null) {
            return dVar.bPV();
        }
        if (!v.aa(dVar.bPN())) {
            Iterator<PostData> it = dVar.bPN().iterator();
            while (it.hasNext()) {
                postData = it.next();
                if (postData != null && postData.cmw() == 1) {
                    break;
                }
            }
        }
        postData = null;
        if (postData == null) {
            postData = dVar.bPS();
        }
        if (postData == null) {
            postData = a(dVar);
        }
        if (postData != null && postData.adv() != null && postData.adv().getUserTbVipInfoData() != null && postData.adv().getUserTbVipInfoData().getvipIntro() != null) {
            postData.adv().getGodUserData().setIntro(postData.adv().getUserTbVipInfoData().getvipIntro());
            return postData;
        }
        return postData;
    }

    private PostData a(d dVar) {
        MetaData metaData;
        if (dVar == null || dVar.bPL() == null || dVar.bPL().adv() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData adv = dVar.bPL().adv();
        String userId = adv.getUserId();
        HashMap<String, MetaData> userMap = dVar.bPL().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = adv;
        }
        postData.Ay(1);
        postData.setId(dVar.bPL().adL());
        postData.setTitle(dVar.bPL().getTitle());
        postData.setTime(dVar.bPL().getCreateTime());
        postData.a(metaData);
        return postData;
    }
}
