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
    private d hGF;
    private g hRX;
    private TextView hRY;
    private View hRZ;
    private TextView hSa;
    private TextView hSb;
    private TextView hSc;
    private View hSd;
    private TextView hSe;
    private VoteCountDownView hSf;
    private View hSg;
    private TextView hSh;
    private TextView hSi;
    private TextView hSj;
    private TbPageContext mPageContext;
    private View mRootView;
    private int status;
    private VoteCountDownView.a euB = new VoteCountDownView.a() { // from class: com.baidu.tieba.pb.pb.main.view.a.1
        @Override // com.baidu.tieba.view.VoteCountDownView.a
        public void onFinished() {
            if (a.this.mRootView != null) {
                if (a.this.hGF == null || a.this.hGF.hBH == null) {
                    a.this.mRootView.setVisibility(8);
                    return;
                }
                a.this.hGF.hBH.setStatus(3);
                a.this.setData(a.this.hGF);
            }
        }
    };
    private View.OnClickListener ckI = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.pb_jump_to_vote_page) {
                if (a.this.hGF != null && a.this.mPageContext != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921408, new BarVoteActivityConfig(a.this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.c(a.this.hGF.getForumId(), 0L), 3)));
                }
            } else if (view.getId() == R.id.pb_vote_button && bc.cE(a.this.mPageContext.getPageActivity()) && a.this.hGF != null && a.this.hRX != null && a.this.hGF.bPM() != null) {
                if (a.this.hRX.aWQ()) {
                    new am("c13444").bT("forum_id", a.this.hGF.getForumId()).aif();
                    com.baidu.tieba.pb.d dVar = new com.baidu.tieba.pb.d();
                    dVar.setThreadId(com.baidu.adp.lib.g.b.c(a.this.hGF.getThreadId(), 0L));
                    dVar.setForumId(com.baidu.adp.lib.g.b.c(a.this.hGF.getForumId(), 0L));
                    String str = "";
                    PostData t = a.this.t(a.this.hGF);
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
                if ((httpResponsedMessage instanceof CommitVoteResMsg) && a.this.hGF != null && a.this.hGF.hBH != null && a.this.mPageContext != null && httpResponsedMessage.getOrginalMessage().getTag() == a.this.mPageContext.getUniqueId()) {
                    if (error == 0) {
                        l.showToast(TbadkCoreApplication.getInst(), (int) R.string.bar_manager_vote_success);
                        a.this.hGF.hBH.wZ(a.this.hGF.hBH.bQp() + 1);
                        a.this.hGF.hBH.il(false);
                        a.this.setData(a.this.hGF);
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
        this.hRY = (TextView) this.mRootView.findViewById(R.id.pb_bar_manager_select_warn);
        this.hRZ = this.mRootView.findViewById(R.id.pb_vote_button_container);
        this.hSe = (TextView) this.mRootView.findViewById(R.id.pb_count_down_title);
        this.hSb = (TextView) this.mRootView.findViewById(R.id.pb_vote_button);
        this.hSa = (TextView) this.mRootView.findViewById(R.id.pb_vote_num);
        this.hSc = (TextView) this.mRootView.findViewById(R.id.pb_bar_manager_ueg_tip);
        this.hSd = this.mRootView.findViewById(R.id.pb_count_down_container);
        this.hSf = (VoteCountDownView) this.mRootView.findViewById(R.id.pb_vote_count_down_view);
        this.hSg = this.mRootView.findViewById(R.id.pb_vote_rule);
        this.hSh = (TextView) this.mRootView.findViewById(R.id.pb_vote_rule_title);
        this.hSi = (TextView) this.mRootView.findViewById(R.id.pb_vote_rule_content);
        this.hSj = (TextView) this.mRootView.findViewById(R.id.pb_jump_to_vote_page);
        MessageManager.getInstance().registerListener(this.epQ);
        setData(dVar);
        return this.mRootView;
    }

    public void setData(d dVar) {
        if (this.mRootView != null) {
            if (dVar == null || dVar.hBH == null) {
                this.mRootView.setVisibility(8);
                return;
            }
            this.hGF = dVar;
            this.hRX = dVar.hBH;
            if (this.hRX.getStatus() != 0) {
                this.status = this.hRX.getStatus();
                if (this.status == 2) {
                    this.hRZ.setVisibility(8);
                    this.hSd.setVisibility(0);
                    this.hSf.setOnCountDownFinished(this.euB);
                    this.hSf.setData(this.hRX.bQo() * 1000);
                    this.hSj.setVisibility(8);
                } else if (this.status == 3) {
                    this.hRZ.setVisibility(0);
                    this.hSb.setOnClickListener(this.ckI);
                    this.hSd.setVisibility(8);
                    this.hSj.setVisibility(0);
                    this.hSj.setOnClickListener(this.ckI);
                    this.hSa.setText(this.hRX.bQp() + "票");
                } else if (this.status == 4 || this.status == 5) {
                    this.hRZ.setVisibility(0);
                    this.hSb.setEnabled(false);
                    this.hSd.setVisibility(8);
                    this.hSj.setVisibility(0);
                    this.hSj.setOnClickListener(this.ckI);
                    this.hSa.setText(this.hRX.bQp() + "票");
                } else if (this.status == 6) {
                    this.hRZ.setVisibility(0);
                    this.hSb.setEnabled(false);
                    this.hSd.setVisibility(8);
                    this.hSa.setText(this.hRX.bQp() + "票");
                    this.hSj.setVisibility(8);
                } else {
                    this.mRootView.setVisibility(8);
                    return;
                }
                if (this.hRX.bQq() != null && !v.aa(this.hRX.bQq())) {
                    StringBuilder sb = new StringBuilder(this.hRX.bQq().get(0));
                    int i = 1;
                    while (i < this.hRX.bQq().size()) {
                        StringBuilder append = sb.append("\n").append(this.hRX.bQq().get(i));
                        i++;
                        sb = append;
                    }
                    this.hSi.setText(sb);
                }
                nq(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public void nq(int i) {
        al.c(this.hSa, R.color.cp_cont_b, 1, i);
        al.c(this.hRY, R.color.cp_cont_d, 1, i);
        al.c(this.hSc, R.color.cp_cont_d, 1, i);
        al.c(this.hSh, R.color.cp_cont_b, 1, i);
        al.c(this.hSi, R.color.cp_cont_b, 1, i);
        al.c(this.hSj, R.color.cp_link_tip_c, 1, i);
        al.c(this.hSe, R.color.cp_cont_b, 1, i);
        al.g(this.hSb, R.drawable.pb_vote_button_bg, i);
        al.h(this.hSg, R.color.cp_bg_line_e, i);
        if (this.hSf != null) {
            this.hSf.nq(i);
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
        if (dVar.bPW() != null) {
            return dVar.bPW();
        }
        if (!v.aa(dVar.bPO())) {
            Iterator<PostData> it = dVar.bPO().iterator();
            while (it.hasNext()) {
                postData = it.next();
                if (postData != null && postData.cmx() == 1) {
                    break;
                }
            }
        }
        postData = null;
        if (postData == null) {
            postData = dVar.bPT();
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
        if (dVar == null || dVar.bPM() == null || dVar.bPM().adv() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData adv = dVar.bPM().adv();
        String userId = adv.getUserId();
        HashMap<String, MetaData> userMap = dVar.bPM().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = adv;
        }
        postData.Ay(1);
        postData.setId(dVar.bPM().adL());
        postData.setTitle(dVar.bPM().getTitle());
        postData.setTime(dVar.bPM().getCreateTime());
        postData.a(metaData);
        return postData;
    }
}
