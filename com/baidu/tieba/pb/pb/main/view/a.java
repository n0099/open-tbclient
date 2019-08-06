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
import com.baidu.tbadk.core.util.bd;
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
    private d hNM;
    private g hZg;
    private TextView hZh;
    private View hZi;
    private TextView hZj;
    private TextView hZk;
    private TextView hZl;
    private View hZm;
    private TextView hZn;
    private VoteCountDownView hZo;
    private View hZp;
    private TextView hZq;
    private TextView hZr;
    private TextView hZs;
    private TbPageContext mPageContext;
    private View mRootView;
    private int status;
    private VoteCountDownView.a ezH = new VoteCountDownView.a() { // from class: com.baidu.tieba.pb.pb.main.view.a.1
        @Override // com.baidu.tieba.view.VoteCountDownView.a
        public void onFinished() {
            if (a.this.mRootView != null) {
                if (a.this.hNM == null || a.this.hNM.hIN == null) {
                    a.this.mRootView.setVisibility(8);
                    return;
                }
                a.this.hNM.hIN.setStatus(3);
                a.this.setData(a.this.hNM);
            }
        }
    };
    private View.OnClickListener cmb = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.pb_jump_to_vote_page) {
                if (a.this.hNM != null && a.this.mPageContext != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921408, new BarVoteActivityConfig(a.this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.c(a.this.hNM.getForumId(), 0L), 3)));
                }
            } else if (view.getId() == R.id.pb_vote_button && bd.cF(a.this.mPageContext.getPageActivity()) && a.this.hNM != null && a.this.hZg != null && a.this.hNM.bSL() != null) {
                if (a.this.hZg.aYO()) {
                    new an("c13444").bT("forum_id", a.this.hNM.getForumId()).ajk();
                    com.baidu.tieba.pb.d dVar = new com.baidu.tieba.pb.d();
                    dVar.setThreadId(com.baidu.adp.lib.g.b.c(a.this.hNM.getThreadId(), 0L));
                    dVar.setForumId(com.baidu.adp.lib.g.b.c(a.this.hNM.getForumId(), 0L));
                    String str = "";
                    PostData t = a.this.t(a.this.hNM);
                    if (t != null && t.aey() != null) {
                        str = t.aey().getUserId();
                    }
                    dVar.ej(com.baidu.adp.lib.g.b.c(str, 0L));
                    dVar.xB(2);
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
    private HttpMessageListener euV = new HttpMessageListener(CmdConfigHttp.CMD_BAR_VOTE) { // from class: com.baidu.tieba.pb.pb.main.view.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            String errorString;
            if (httpResponsedMessage != null && httpResponsedMessage.getOrginalMessage() != null) {
                int error = httpResponsedMessage.getError();
                if ((httpResponsedMessage instanceof CommitVoteResMsg) && a.this.hNM != null && a.this.hNM.hIN != null && a.this.mPageContext != null && httpResponsedMessage.getOrginalMessage().getTag() == a.this.mPageContext.getUniqueId()) {
                    if (error == 0) {
                        l.showToast(TbadkCoreApplication.getInst(), (int) R.string.bar_manager_vote_success);
                        a.this.hNM.hIN.xF(a.this.hNM.hIN.bTo() + 1);
                        a.this.hNM.hIN.iu(false);
                        a.this.setData(a.this.hNM);
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
        this.hZh = (TextView) this.mRootView.findViewById(R.id.pb_bar_manager_select_warn);
        this.hZi = this.mRootView.findViewById(R.id.pb_vote_button_container);
        this.hZn = (TextView) this.mRootView.findViewById(R.id.pb_count_down_title);
        this.hZk = (TextView) this.mRootView.findViewById(R.id.pb_vote_button);
        this.hZj = (TextView) this.mRootView.findViewById(R.id.pb_vote_num);
        this.hZl = (TextView) this.mRootView.findViewById(R.id.pb_bar_manager_ueg_tip);
        this.hZm = this.mRootView.findViewById(R.id.pb_count_down_container);
        this.hZo = (VoteCountDownView) this.mRootView.findViewById(R.id.pb_vote_count_down_view);
        this.hZp = this.mRootView.findViewById(R.id.pb_vote_rule);
        this.hZq = (TextView) this.mRootView.findViewById(R.id.pb_vote_rule_title);
        this.hZr = (TextView) this.mRootView.findViewById(R.id.pb_vote_rule_content);
        this.hZs = (TextView) this.mRootView.findViewById(R.id.pb_jump_to_vote_page);
        MessageManager.getInstance().registerListener(this.euV);
        setData(dVar);
        return this.mRootView;
    }

    public void setData(d dVar) {
        if (this.mRootView != null) {
            if (dVar == null || dVar.hIN == null) {
                this.mRootView.setVisibility(8);
                return;
            }
            this.hNM = dVar;
            this.hZg = dVar.hIN;
            if (this.hZg.getStatus() != 0) {
                this.status = this.hZg.getStatus();
                if (this.status == 2) {
                    this.hZi.setVisibility(8);
                    this.hZm.setVisibility(0);
                    this.hZo.setOnCountDownFinished(this.ezH);
                    this.hZo.setData(this.hZg.bTn() * 1000);
                    this.hZs.setVisibility(8);
                } else if (this.status == 3) {
                    this.hZi.setVisibility(0);
                    this.hZk.setOnClickListener(this.cmb);
                    this.hZm.setVisibility(8);
                    this.hZs.setVisibility(0);
                    this.hZs.setOnClickListener(this.cmb);
                    this.hZj.setText(this.hZg.bTo() + "票");
                } else if (this.status == 4 || this.status == 5) {
                    this.hZi.setVisibility(0);
                    this.hZk.setEnabled(false);
                    this.hZm.setVisibility(8);
                    this.hZs.setVisibility(0);
                    this.hZs.setOnClickListener(this.cmb);
                    this.hZj.setText(this.hZg.bTo() + "票");
                } else if (this.status == 6) {
                    this.hZi.setVisibility(0);
                    this.hZk.setEnabled(false);
                    this.hZm.setVisibility(8);
                    this.hZj.setText(this.hZg.bTo() + "票");
                    this.hZs.setVisibility(8);
                } else {
                    this.mRootView.setVisibility(8);
                    return;
                }
                if (this.hZg.bTp() != null && !v.aa(this.hZg.bTp())) {
                    StringBuilder sb = new StringBuilder(this.hZg.bTp().get(0));
                    int i = 1;
                    while (i < this.hZg.bTp().size()) {
                        StringBuilder append = sb.append("\n").append(this.hZg.bTp().get(i));
                        i++;
                        sb = append;
                    }
                    this.hZr.setText(sb);
                }
                nA(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public void nA(int i) {
        am.d(this.hZj, R.color.cp_cont_b, 1, i);
        am.d(this.hZh, R.color.cp_cont_d, 1, i);
        am.d(this.hZl, R.color.cp_cont_d, 1, i);
        am.d(this.hZq, R.color.cp_cont_b, 1, i);
        am.d(this.hZr, R.color.cp_cont_b, 1, i);
        am.d(this.hZs, R.color.cp_link_tip_c, 1, i);
        am.d(this.hZn, R.color.cp_cont_b, 1, i);
        am.g(this.hZk, R.drawable.pb_vote_button_bg, i);
        am.h(this.hZp, R.color.cp_bg_line_e, i);
        if (this.hZo != null) {
            this.hZo.nA(i);
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
        if (dVar.bSV() != null) {
            return dVar.bSV();
        }
        if (!v.aa(dVar.bSN())) {
            Iterator<PostData> it = dVar.bSN().iterator();
            while (it.hasNext()) {
                postData = it.next();
                if (postData != null && postData.cpL() == 1) {
                    break;
                }
            }
        }
        postData = null;
        if (postData == null) {
            postData = dVar.bSS();
        }
        if (postData == null) {
            postData = a(dVar);
        }
        if (postData != null && postData.aey() != null && postData.aey().getUserTbVipInfoData() != null && postData.aey().getUserTbVipInfoData().getvipIntro() != null) {
            postData.aey().getGodUserData().setIntro(postData.aey().getUserTbVipInfoData().getvipIntro());
            return postData;
        }
        return postData;
    }

    private PostData a(d dVar) {
        MetaData metaData;
        if (dVar == null || dVar.bSL() == null || dVar.bSL().aey() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData aey = dVar.bSL().aey();
        String userId = aey.getUserId();
        HashMap<String, MetaData> userMap = dVar.bSL().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = aey;
        }
        postData.Bg(1);
        postData.setId(dVar.bSL().aeO());
        postData.setTitle(dVar.bSL().getTitle());
        postData.setTime(dVar.bSL().getCreateTime());
        postData.a(metaData);
        return postData;
    }
}
