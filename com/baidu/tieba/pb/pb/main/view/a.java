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
    private d hPJ;
    private g ibd;
    private TextView ibe;
    private View ibf;
    private TextView ibg;
    private TextView ibh;
    private TextView ibi;
    private View ibj;
    private TextView ibk;
    private VoteCountDownView ibl;
    private View ibm;
    private TextView ibn;
    private TextView ibo;
    private TextView ibp;
    private TbPageContext mPageContext;
    private View mRootView;
    private int status;
    private VoteCountDownView.a eBq = new VoteCountDownView.a() { // from class: com.baidu.tieba.pb.pb.main.view.a.1
        @Override // com.baidu.tieba.view.VoteCountDownView.a
        public void onFinished() {
            if (a.this.mRootView != null) {
                if (a.this.hPJ == null || a.this.hPJ.hKJ == null) {
                    a.this.mRootView.setVisibility(8);
                    return;
                }
                a.this.hPJ.hKJ.setStatus(3);
                a.this.setData(a.this.hPJ);
            }
        }
    };
    private View.OnClickListener cmX = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.pb_jump_to_vote_page) {
                if (a.this.hPJ != null && a.this.mPageContext != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921408, new BarVoteActivityConfig(a.this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.e(a.this.hPJ.getForumId(), 0L), 3)));
                }
            } else if (view.getId() == R.id.pb_vote_button && bc.cF(a.this.mPageContext.getPageActivity()) && a.this.hPJ != null && a.this.ibd != null && a.this.hPJ.bTy() != null) {
                if (a.this.ibd.aZs()) {
                    new an("c13444").bT("forum_id", a.this.hPJ.getForumId()).ajq();
                    com.baidu.tieba.pb.d dVar = new com.baidu.tieba.pb.d();
                    dVar.setThreadId(com.baidu.adp.lib.g.b.e(a.this.hPJ.getThreadId(), 0L));
                    dVar.setForumId(com.baidu.adp.lib.g.b.e(a.this.hPJ.getForumId(), 0L));
                    String str = "";
                    PostData t = a.this.t(a.this.hPJ);
                    if (t != null && t.aeC() != null) {
                        str = t.aeC().getUserId();
                    }
                    dVar.em(com.baidu.adp.lib.g.b.e(str, 0L));
                    dVar.xE(2);
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
    private HttpMessageListener ewF = new HttpMessageListener(CmdConfigHttp.CMD_BAR_VOTE) { // from class: com.baidu.tieba.pb.pb.main.view.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            String errorString;
            if (httpResponsedMessage != null && httpResponsedMessage.getOrginalMessage() != null) {
                int error = httpResponsedMessage.getError();
                if ((httpResponsedMessage instanceof CommitVoteResMsg) && a.this.hPJ != null && a.this.hPJ.hKJ != null && a.this.mPageContext != null && httpResponsedMessage.getOrginalMessage().getTag() == a.this.mPageContext.getUniqueId()) {
                    if (error == 0) {
                        l.showToast(TbadkCoreApplication.getInst(), (int) R.string.bar_manager_vote_success);
                        a.this.hPJ.hKJ.xI(a.this.hPJ.hKJ.bUb() + 1);
                        a.this.hPJ.hKJ.ix(false);
                        a.this.setData(a.this.hPJ);
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
        this.ibe = (TextView) this.mRootView.findViewById(R.id.pb_bar_manager_select_warn);
        this.ibf = this.mRootView.findViewById(R.id.pb_vote_button_container);
        this.ibk = (TextView) this.mRootView.findViewById(R.id.pb_count_down_title);
        this.ibh = (TextView) this.mRootView.findViewById(R.id.pb_vote_button);
        this.ibg = (TextView) this.mRootView.findViewById(R.id.pb_vote_num);
        this.ibi = (TextView) this.mRootView.findViewById(R.id.pb_bar_manager_ueg_tip);
        this.ibj = this.mRootView.findViewById(R.id.pb_count_down_container);
        this.ibl = (VoteCountDownView) this.mRootView.findViewById(R.id.pb_vote_count_down_view);
        this.ibm = this.mRootView.findViewById(R.id.pb_vote_rule);
        this.ibn = (TextView) this.mRootView.findViewById(R.id.pb_vote_rule_title);
        this.ibo = (TextView) this.mRootView.findViewById(R.id.pb_vote_rule_content);
        this.ibp = (TextView) this.mRootView.findViewById(R.id.pb_jump_to_vote_page);
        MessageManager.getInstance().registerListener(this.ewF);
        setData(dVar);
        return this.mRootView;
    }

    public void setData(d dVar) {
        if (this.mRootView != null) {
            if (dVar == null || dVar.hKJ == null) {
                this.mRootView.setVisibility(8);
                return;
            }
            this.hPJ = dVar;
            this.ibd = dVar.hKJ;
            if (this.ibd.getStatus() != 0) {
                this.status = this.ibd.getStatus();
                if (this.status == 2) {
                    this.ibf.setVisibility(8);
                    this.ibj.setVisibility(0);
                    this.ibl.setOnCountDownFinished(this.eBq);
                    this.ibl.setData(this.ibd.bUa() * 1000);
                    this.ibp.setVisibility(8);
                } else if (this.status == 3) {
                    this.ibf.setVisibility(0);
                    this.ibh.setOnClickListener(this.cmX);
                    this.ibj.setVisibility(8);
                    this.ibp.setVisibility(0);
                    this.ibp.setOnClickListener(this.cmX);
                    this.ibg.setText(this.ibd.bUb() + "票");
                } else if (this.status == 4 || this.status == 5) {
                    this.ibf.setVisibility(0);
                    this.ibh.setEnabled(false);
                    this.ibj.setVisibility(8);
                    this.ibp.setVisibility(0);
                    this.ibp.setOnClickListener(this.cmX);
                    this.ibg.setText(this.ibd.bUb() + "票");
                } else if (this.status == 6) {
                    this.ibf.setVisibility(0);
                    this.ibh.setEnabled(false);
                    this.ibj.setVisibility(8);
                    this.ibg.setText(this.ibd.bUb() + "票");
                    this.ibp.setVisibility(8);
                } else {
                    this.mRootView.setVisibility(8);
                    return;
                }
                if (this.ibd.bUc() != null && !v.aa(this.ibd.bUc())) {
                    StringBuilder sb = new StringBuilder(this.ibd.bUc().get(0));
                    int i = 1;
                    while (i < this.ibd.bUc().size()) {
                        StringBuilder append = sb.append("\n").append(this.ibd.bUc().get(i));
                        i++;
                        sb = append;
                    }
                    this.ibo.setText(sb);
                }
                nE(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public void nE(int i) {
        am.d(this.ibg, R.color.cp_cont_b, 1, i);
        am.d(this.ibe, R.color.cp_cont_d, 1, i);
        am.d(this.ibi, R.color.cp_cont_d, 1, i);
        am.d(this.ibn, R.color.cp_cont_b, 1, i);
        am.d(this.ibo, R.color.cp_cont_b, 1, i);
        am.d(this.ibp, R.color.cp_link_tip_c, 1, i);
        am.d(this.ibk, R.color.cp_cont_b, 1, i);
        am.g(this.ibh, R.drawable.pb_vote_button_bg, i);
        am.h(this.ibm, R.color.cp_bg_line_e, i);
        if (this.ibl != null) {
            this.ibl.nE(i);
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
        if (dVar.bTI() != null) {
            return dVar.bTI();
        }
        if (!v.aa(dVar.bTA())) {
            Iterator<PostData> it = dVar.bTA().iterator();
            while (it.hasNext()) {
                postData = it.next();
                if (postData != null && postData.cqz() == 1) {
                    break;
                }
            }
        }
        postData = null;
        if (postData == null) {
            postData = dVar.bTF();
        }
        if (postData == null) {
            postData = a(dVar);
        }
        if (postData != null && postData.aeC() != null && postData.aeC().getUserTbVipInfoData() != null && postData.aeC().getUserTbVipInfoData().getvipIntro() != null) {
            postData.aeC().getGodUserData().setIntro(postData.aeC().getUserTbVipInfoData().getvipIntro());
            return postData;
        }
        return postData;
    }

    private PostData a(d dVar) {
        MetaData metaData;
        if (dVar == null || dVar.bTy() == null || dVar.bTy().aeC() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData aeC = dVar.bTy().aeC();
        String userId = aeC.getUserId();
        HashMap<String, MetaData> userMap = dVar.bTy().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = aeC;
        }
        postData.Bk(1);
        postData.setId(dVar.bTy().aeS());
        postData.setTitle(dVar.bTy().getTitle());
        postData.setTime(dVar.bTy().getCreateTime());
        postData.a(metaData);
        return postData;
    }
}
