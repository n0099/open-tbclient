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
    private d hMS;
    private g hYk;
    private TextView hYl;
    private View hYm;
    private TextView hYn;
    private TextView hYo;
    private TextView hYp;
    private View hYq;
    private TextView hYr;
    private VoteCountDownView hYs;
    private View hYt;
    private TextView hYu;
    private TextView hYv;
    private TextView hYw;
    private TbPageContext mPageContext;
    private View mRootView;
    private int status;
    private VoteCountDownView.a ezA = new VoteCountDownView.a() { // from class: com.baidu.tieba.pb.pb.main.view.a.1
        @Override // com.baidu.tieba.view.VoteCountDownView.a
        public void onFinished() {
            if (a.this.mRootView != null) {
                if (a.this.hMS == null || a.this.hMS.hHV == null) {
                    a.this.mRootView.setVisibility(8);
                    return;
                }
                a.this.hMS.hHV.setStatus(3);
                a.this.setData(a.this.hMS);
            }
        }
    };
    private View.OnClickListener clU = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.pb_jump_to_vote_page) {
                if (a.this.hMS != null && a.this.mPageContext != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921408, new BarVoteActivityConfig(a.this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.c(a.this.hMS.getForumId(), 0L), 3)));
                }
            } else if (view.getId() == R.id.pb_vote_button && bd.cF(a.this.mPageContext.getPageActivity()) && a.this.hMS != null && a.this.hYk != null && a.this.hMS.bSx() != null) {
                if (a.this.hYk.aYM()) {
                    new an("c13444").bT("forum_id", a.this.hMS.getForumId()).aji();
                    com.baidu.tieba.pb.d dVar = new com.baidu.tieba.pb.d();
                    dVar.setThreadId(com.baidu.adp.lib.g.b.c(a.this.hMS.getThreadId(), 0L));
                    dVar.setForumId(com.baidu.adp.lib.g.b.c(a.this.hMS.getForumId(), 0L));
                    String str = "";
                    PostData t = a.this.t(a.this.hMS);
                    if (t != null && t.aex() != null) {
                        str = t.aex().getUserId();
                    }
                    dVar.ej(com.baidu.adp.lib.g.b.c(str, 0L));
                    dVar.xz(2);
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
    private HttpMessageListener euO = new HttpMessageListener(CmdConfigHttp.CMD_BAR_VOTE) { // from class: com.baidu.tieba.pb.pb.main.view.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            String errorString;
            if (httpResponsedMessage != null && httpResponsedMessage.getOrginalMessage() != null) {
                int error = httpResponsedMessage.getError();
                if ((httpResponsedMessage instanceof CommitVoteResMsg) && a.this.hMS != null && a.this.hMS.hHV != null && a.this.mPageContext != null && httpResponsedMessage.getOrginalMessage().getTag() == a.this.mPageContext.getUniqueId()) {
                    if (error == 0) {
                        l.showToast(TbadkCoreApplication.getInst(), (int) R.string.bar_manager_vote_success);
                        a.this.hMS.hHV.xD(a.this.hMS.hHV.bTa() + 1);
                        a.this.hMS.hHV.iu(false);
                        a.this.setData(a.this.hMS);
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
        this.hYl = (TextView) this.mRootView.findViewById(R.id.pb_bar_manager_select_warn);
        this.hYm = this.mRootView.findViewById(R.id.pb_vote_button_container);
        this.hYr = (TextView) this.mRootView.findViewById(R.id.pb_count_down_title);
        this.hYo = (TextView) this.mRootView.findViewById(R.id.pb_vote_button);
        this.hYn = (TextView) this.mRootView.findViewById(R.id.pb_vote_num);
        this.hYp = (TextView) this.mRootView.findViewById(R.id.pb_bar_manager_ueg_tip);
        this.hYq = this.mRootView.findViewById(R.id.pb_count_down_container);
        this.hYs = (VoteCountDownView) this.mRootView.findViewById(R.id.pb_vote_count_down_view);
        this.hYt = this.mRootView.findViewById(R.id.pb_vote_rule);
        this.hYu = (TextView) this.mRootView.findViewById(R.id.pb_vote_rule_title);
        this.hYv = (TextView) this.mRootView.findViewById(R.id.pb_vote_rule_content);
        this.hYw = (TextView) this.mRootView.findViewById(R.id.pb_jump_to_vote_page);
        MessageManager.getInstance().registerListener(this.euO);
        setData(dVar);
        return this.mRootView;
    }

    public void setData(d dVar) {
        if (this.mRootView != null) {
            if (dVar == null || dVar.hHV == null) {
                this.mRootView.setVisibility(8);
                return;
            }
            this.hMS = dVar;
            this.hYk = dVar.hHV;
            if (this.hYk.getStatus() != 0) {
                this.status = this.hYk.getStatus();
                if (this.status == 2) {
                    this.hYm.setVisibility(8);
                    this.hYq.setVisibility(0);
                    this.hYs.setOnCountDownFinished(this.ezA);
                    this.hYs.setData(this.hYk.bSZ() * 1000);
                    this.hYw.setVisibility(8);
                } else if (this.status == 3) {
                    this.hYm.setVisibility(0);
                    this.hYo.setOnClickListener(this.clU);
                    this.hYq.setVisibility(8);
                    this.hYw.setVisibility(0);
                    this.hYw.setOnClickListener(this.clU);
                    this.hYn.setText(this.hYk.bTa() + "票");
                } else if (this.status == 4 || this.status == 5) {
                    this.hYm.setVisibility(0);
                    this.hYo.setEnabled(false);
                    this.hYq.setVisibility(8);
                    this.hYw.setVisibility(0);
                    this.hYw.setOnClickListener(this.clU);
                    this.hYn.setText(this.hYk.bTa() + "票");
                } else if (this.status == 6) {
                    this.hYm.setVisibility(0);
                    this.hYo.setEnabled(false);
                    this.hYq.setVisibility(8);
                    this.hYn.setText(this.hYk.bTa() + "票");
                    this.hYw.setVisibility(8);
                } else {
                    this.mRootView.setVisibility(8);
                    return;
                }
                if (this.hYk.bTb() != null && !v.aa(this.hYk.bTb())) {
                    StringBuilder sb = new StringBuilder(this.hYk.bTb().get(0));
                    int i = 1;
                    while (i < this.hYk.bTb().size()) {
                        StringBuilder append = sb.append("\n").append(this.hYk.bTb().get(i));
                        i++;
                        sb = append;
                    }
                    this.hYv.setText(sb);
                }
                nz(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public void nz(int i) {
        am.d(this.hYn, R.color.cp_cont_b, 1, i);
        am.d(this.hYl, R.color.cp_cont_d, 1, i);
        am.d(this.hYp, R.color.cp_cont_d, 1, i);
        am.d(this.hYu, R.color.cp_cont_b, 1, i);
        am.d(this.hYv, R.color.cp_cont_b, 1, i);
        am.d(this.hYw, R.color.cp_link_tip_c, 1, i);
        am.d(this.hYr, R.color.cp_cont_b, 1, i);
        am.g(this.hYo, R.drawable.pb_vote_button_bg, i);
        am.h(this.hYt, R.color.cp_bg_line_e, i);
        if (this.hYs != null) {
            this.hYs.nz(i);
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
        if (dVar.bSH() != null) {
            return dVar.bSH();
        }
        if (!v.aa(dVar.bSz())) {
            Iterator<PostData> it = dVar.bSz().iterator();
            while (it.hasNext()) {
                postData = it.next();
                if (postData != null && postData.cpp() == 1) {
                    break;
                }
            }
        }
        postData = null;
        if (postData == null) {
            postData = dVar.bSE();
        }
        if (postData == null) {
            postData = a(dVar);
        }
        if (postData != null && postData.aex() != null && postData.aex().getUserTbVipInfoData() != null && postData.aex().getUserTbVipInfoData().getvipIntro() != null) {
            postData.aex().getGodUserData().setIntro(postData.aex().getUserTbVipInfoData().getvipIntro());
            return postData;
        }
        return postData;
    }

    private PostData a(d dVar) {
        MetaData metaData;
        if (dVar == null || dVar.bSx() == null || dVar.bSx().aex() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData aex = dVar.bSx().aex();
        String userId = aex.getUserId();
        HashMap<String, MetaData> userMap = dVar.bSx().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = aex;
        }
        postData.Be(1);
        postData.setId(dVar.bSx().aeN());
        postData.setTitle(dVar.bSx().getTitle());
        postData.setTime(dVar.bSx().getCreateTime());
        postData.a(metaData);
        return postData;
    }
}
