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
    private d hOn;
    private g hZK;
    private TextView hZL;
    private View hZM;
    private TextView hZN;
    private TextView hZO;
    private TextView hZP;
    private View hZQ;
    private TextView hZR;
    private VoteCountDownView hZS;
    private View hZT;
    private TextView hZU;
    private TextView hZV;
    private TextView hZW;
    private TbPageContext mPageContext;
    private View mRootView;
    private int status;
    private VoteCountDownView.a eJY = new VoteCountDownView.a() { // from class: com.baidu.tieba.pb.pb.main.view.a.1
        @Override // com.baidu.tieba.view.VoteCountDownView.a
        public void onFinished() {
            if (a.this.mRootView != null) {
                if (a.this.hOn == null || a.this.hOn.hJo == null) {
                    a.this.mRootView.setVisibility(8);
                    return;
                }
                a.this.hOn.hJo.setStatus(3);
                a.this.setData(a.this.hOn);
            }
        }
    };
    private View.OnClickListener czV = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.pb_jump_to_vote_page) {
                if (a.this.hOn != null && a.this.mPageContext != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921408, new BarVoteActivityConfig(a.this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.toLong(a.this.hOn.getForumId(), 0L), 3)));
                }
            } else if (view.getId() == R.id.pb_vote_button && bc.checkUpIsLogin(a.this.mPageContext.getPageActivity()) && a.this.hOn != null && a.this.hZK != null && a.this.hOn.bQz() != null) {
                if (a.this.hZK.aZv()) {
                    new an("c13444").bS("forum_id", a.this.hOn.getForumId()).amK();
                    com.baidu.tieba.pb.d dVar = new com.baidu.tieba.pb.d();
                    dVar.setThreadId(com.baidu.adp.lib.g.b.toLong(a.this.hOn.getThreadId(), 0L));
                    dVar.setForumId(com.baidu.adp.lib.g.b.toLong(a.this.hOn.getForumId(), 0L));
                    String str = "";
                    PostData t = a.this.t(a.this.hOn);
                    if (t != null && t.aiG() != null) {
                        str = t.aiG().getUserId();
                    }
                    dVar.dH(com.baidu.adp.lib.g.b.toLong(str, 0L));
                    dVar.wk(2);
                    dVar.q(a.this.mPageContext.getUniqueId());
                    CustomMessage customMessage = new CustomMessage(2921411);
                    customMessage.setData(dVar);
                    MessageManager.getInstance().sendMessage(customMessage);
                    return;
                }
                l.showToast(TbadkCoreApplication.getInst(), (int) R.string.has_not_other_ticket);
            }
        }
    };
    private HttpMessageListener eFr = new HttpMessageListener(CmdConfigHttp.CMD_BAR_VOTE) { // from class: com.baidu.tieba.pb.pb.main.view.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            String errorString;
            if (httpResponsedMessage != null && httpResponsedMessage.getOrginalMessage() != null) {
                int error = httpResponsedMessage.getError();
                if ((httpResponsedMessage instanceof CommitVoteResMsg) && a.this.hOn != null && a.this.hOn.hJo != null && a.this.mPageContext != null && httpResponsedMessage.getOrginalMessage().getTag() == a.this.mPageContext.getUniqueId()) {
                    if (error == 0) {
                        l.showToast(TbadkCoreApplication.getInst(), (int) R.string.bar_manager_vote_success);
                        a.this.hOn.hJo.wo(a.this.hOn.hJo.bRc() + 1);
                        a.this.hOn.hJo.iA(false);
                        a.this.setData(a.this.hOn);
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

    public View s(d dVar) {
        if (this.mPageContext == null) {
            return null;
        }
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.bar_manager_select_view, (ViewGroup) null);
        this.hZL = (TextView) this.mRootView.findViewById(R.id.pb_bar_manager_select_warn);
        this.hZM = this.mRootView.findViewById(R.id.pb_vote_button_container);
        this.hZR = (TextView) this.mRootView.findViewById(R.id.pb_count_down_title);
        this.hZO = (TextView) this.mRootView.findViewById(R.id.pb_vote_button);
        this.hZN = (TextView) this.mRootView.findViewById(R.id.pb_vote_num);
        this.hZP = (TextView) this.mRootView.findViewById(R.id.pb_bar_manager_ueg_tip);
        this.hZQ = this.mRootView.findViewById(R.id.pb_count_down_container);
        this.hZS = (VoteCountDownView) this.mRootView.findViewById(R.id.pb_vote_count_down_view);
        this.hZT = this.mRootView.findViewById(R.id.pb_vote_rule);
        this.hZU = (TextView) this.mRootView.findViewById(R.id.pb_vote_rule_title);
        this.hZV = (TextView) this.mRootView.findViewById(R.id.pb_vote_rule_content);
        this.hZW = (TextView) this.mRootView.findViewById(R.id.pb_jump_to_vote_page);
        MessageManager.getInstance().registerListener(this.eFr);
        setData(dVar);
        return this.mRootView;
    }

    public void setData(d dVar) {
        if (this.mRootView != null) {
            if (dVar == null || dVar.hJo == null) {
                this.mRootView.setVisibility(8);
                return;
            }
            this.hOn = dVar;
            this.hZK = dVar.hJo;
            if (this.hZK.getStatus() != 0) {
                this.status = this.hZK.getStatus();
                if (this.status == 2) {
                    this.hZM.setVisibility(8);
                    this.hZQ.setVisibility(0);
                    this.hZS.setOnCountDownFinished(this.eJY);
                    this.hZS.setData(this.hZK.bRb() * 1000);
                    this.hZW.setVisibility(8);
                } else if (this.status == 3) {
                    this.hZM.setVisibility(0);
                    this.hZO.setOnClickListener(this.czV);
                    this.hZQ.setVisibility(8);
                    this.hZW.setVisibility(0);
                    this.hZW.setOnClickListener(this.czV);
                    this.hZN.setText(this.hZK.bRc() + "票");
                } else if (this.status == 4 || this.status == 5) {
                    this.hZM.setVisibility(0);
                    this.hZO.setEnabled(false);
                    this.hZQ.setVisibility(8);
                    this.hZW.setVisibility(0);
                    this.hZW.setOnClickListener(this.czV);
                    this.hZN.setText(this.hZK.bRc() + "票");
                } else if (this.status == 6) {
                    this.hZM.setVisibility(0);
                    this.hZO.setEnabled(false);
                    this.hZQ.setVisibility(8);
                    this.hZN.setText(this.hZK.bRc() + "票");
                    this.hZW.setVisibility(8);
                } else {
                    this.mRootView.setVisibility(8);
                    return;
                }
                if (this.hZK.bRd() != null && !v.isEmpty(this.hZK.bRd())) {
                    StringBuilder sb = new StringBuilder(this.hZK.bRd().get(0));
                    int i = 1;
                    while (i < this.hZK.bRd().size()) {
                        StringBuilder append = sb.append("\n").append(this.hZK.bRd().get(i));
                        i++;
                        sb = append;
                    }
                    this.hZV.setText(sb);
                }
                mE(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public void mE(int i) {
        am.setViewTextColor(this.hZN, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.hZL, R.color.cp_cont_d, 1, i);
        am.setViewTextColor(this.hZP, R.color.cp_cont_d, 1, i);
        am.setViewTextColor(this.hZU, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.hZV, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.hZW, R.color.cp_link_tip_c, 1, i);
        am.setViewTextColor(this.hZR, R.color.cp_cont_b, 1, i);
        am.setBackgroundResource(this.hZO, R.drawable.pb_vote_button_bg, i);
        am.setBackgroundColor(this.hZT, R.color.cp_bg_line_e, i);
        if (this.hZS != null) {
            this.hZS.mE(i);
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
        if (dVar.bQJ() != null) {
            return dVar.bQJ();
        }
        if (!v.isEmpty(dVar.bQB())) {
            Iterator<PostData> it = dVar.bQB().iterator();
            while (it.hasNext()) {
                postData = it.next();
                if (postData != null && postData.cop() == 1) {
                    break;
                }
            }
        }
        postData = null;
        if (postData == null) {
            postData = dVar.bQG();
        }
        if (postData == null) {
            postData = a(dVar);
        }
        if (postData != null && postData.aiG() != null && postData.aiG().getUserTbVipInfoData() != null && postData.aiG().getUserTbVipInfoData().getvipIntro() != null) {
            postData.aiG().getGodUserData().setIntro(postData.aiG().getUserTbVipInfoData().getvipIntro());
            return postData;
        }
        return postData;
    }

    private PostData a(d dVar) {
        MetaData metaData;
        if (dVar == null || dVar.bQz() == null || dVar.bQz().aiG() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData aiG = dVar.bQz().aiG();
        String userId = aiG.getUserId();
        HashMap<String, MetaData> userMap = dVar.bQz().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = aiG;
        }
        postData.zR(1);
        postData.setId(dVar.bQz().aiW());
        postData.setTitle(dVar.bQz().getTitle());
        postData.setTime(dVar.bQz().getCreateTime());
        postData.a(metaData);
        return postData;
    }
}
