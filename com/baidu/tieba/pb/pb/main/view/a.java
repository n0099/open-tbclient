package com.baidu.tieba.pb.pb.main.view;

import android.graphics.drawable.GradientDrawable;
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
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.data.CommitVoteResMsg;
import com.baidu.tbadk.widget.SelectRuleView;
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
    private h jFh;
    private TextView jFi;
    private View jFj;
    private TextView jFk;
    private TBSpecificationBtn jFl;
    private TextView jFm;
    private View jFn;
    private TextView jFo;
    private VoteCountDownView jFp;
    private View jFq;
    private TextView jFr;
    private SelectRuleView jFs;
    private TextView jFt;
    private e jqC;
    private TbPageContext mPageContext;
    private View mRootView;
    private int status;
    private VoteCountDownView.a jFu = new VoteCountDownView.a() { // from class: com.baidu.tieba.pb.pb.main.view.a.1
        @Override // com.baidu.tieba.view.VoteCountDownView.a
        public void onFinished() {
            if (a.this.mRootView != null) {
                if (a.this.jqC == null || a.this.jqC.jnx == null) {
                    a.this.mRootView.setVisibility(8);
                    return;
                }
                a.this.jqC.jnx.setStatus(3);
                a.this.setData(a.this.jqC);
            }
        }
    };
    private View.OnClickListener dRF = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.pb_jump_to_vote_page) {
                if (a.this.jqC != null && a.this.mPageContext != null && bc.checkUpIsLogin(a.this.mPageContext.getPageActivity())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921408, new BarVoteActivityConfig(a.this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(a.this.jqC.getForumId(), 0L), 3)));
                }
            } else if (view.getId() == R.id.pb_vote_button && bc.checkUpIsLogin(a.this.mPageContext.getPageActivity()) && a.this.jqC != null && a.this.jFh != null && a.this.jqC.cvu() != null) {
                if (a.this.jFh.bDV()) {
                    new an("c13444").cI("forum_id", a.this.jqC.getForumId()).aOR();
                    d dVar = new d();
                    dVar.setThreadId(com.baidu.adp.lib.f.b.toLong(a.this.jqC.getThreadId(), 0L));
                    dVar.setForumId(com.baidu.adp.lib.f.b.toLong(a.this.jqC.getForumId(), 0L));
                    String str = "";
                    PostData F = a.this.F(a.this.jqC);
                    if (F != null && F.aKE() != null) {
                        str = F.aKE().getUserId();
                    }
                    dVar.fc(com.baidu.adp.lib.f.b.toLong(str, 0L));
                    dVar.zf(2);
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
    private HttpMessageListener ghF = new HttpMessageListener(CmdConfigHttp.CMD_BAR_VOTE) { // from class: com.baidu.tieba.pb.pb.main.view.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            String errorString;
            if (httpResponsedMessage != null && httpResponsedMessage.getOrginalMessage() != null) {
                int error = httpResponsedMessage.getError();
                if ((httpResponsedMessage instanceof CommitVoteResMsg) && a.this.jqC != null && a.this.jqC.jnx != null && a.this.mPageContext != null && httpResponsedMessage.getOrginalMessage().getTag() == a.this.mPageContext.getUniqueId()) {
                    if (error == 0) {
                        l.showToast(TbadkCoreApplication.getInst(), (int) R.string.bar_manager_vote_success);
                        a.this.jqC.jnx.zk(a.this.jqC.jnx.cwa() + 1);
                        a.this.jqC.jnx.lm(false);
                        a.this.setData(a.this.jqC);
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
        this.jFi = (TextView) this.mRootView.findViewById(R.id.pb_bar_manager_select_warn);
        this.jFj = this.mRootView.findViewById(R.id.pb_vote_button_container);
        this.jFo = (TextView) this.mRootView.findViewById(R.id.pb_count_down_title);
        this.jFl = (TBSpecificationBtn) this.mRootView.findViewById(R.id.pb_vote_button);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        bVar.a(GradientDrawable.Orientation.TL_BR);
        this.jFl.setText(TbadkCoreApplication.getInst().getString(R.string.pb_vote_text));
        this.jFl.setTextSize(R.dimen.tbfontsize44);
        this.jFl.setConfig(bVar);
        this.jFk = (TextView) this.mRootView.findViewById(R.id.pb_vote_num);
        this.jFm = (TextView) this.mRootView.findViewById(R.id.pb_bar_manager_ueg_tip);
        this.jFn = this.mRootView.findViewById(R.id.pb_count_down_container);
        this.jFp = (VoteCountDownView) this.mRootView.findViewById(R.id.pb_vote_count_down_view);
        this.jFq = this.mRootView.findViewById(R.id.pb_vote_rule);
        this.jFr = (TextView) this.mRootView.findViewById(R.id.pb_vote_rule_title);
        this.jFs = (SelectRuleView) this.mRootView.findViewById(R.id.pb_vote_rule_content);
        this.jFt = (TextView) this.mRootView.findViewById(R.id.pb_jump_to_vote_page);
        MessageManager.getInstance().registerListener(this.ghF);
        setData(eVar);
        return this.mRootView;
    }

    public void setData(e eVar) {
        if (this.mRootView != null) {
            if (eVar == null || eVar.jnx == null) {
                this.mRootView.setVisibility(8);
                return;
            }
            this.jqC = eVar;
            this.jFh = eVar.jnx;
            if (this.jFh.getStatus() != 0) {
                this.status = this.jFh.getStatus();
                if (this.status == 2) {
                    this.jFj.setVisibility(8);
                    this.jFn.setVisibility(0);
                    this.jFp.setOnCountDownFinished(this.jFu);
                    this.jFp.setData(this.jFh.cvZ() * 1000);
                    this.jFt.setVisibility(8);
                } else if (this.status == 3) {
                    this.jFj.setVisibility(0);
                    this.jFl.setOnClickListener(this.dRF);
                    this.jFn.setVisibility(8);
                    this.jFt.setVisibility(0);
                    this.jFt.setOnClickListener(this.dRF);
                    this.jFk.setText(this.jFh.cwa() + "票");
                } else if (this.status == 4 || this.status == 5) {
                    this.jFj.setVisibility(0);
                    this.jFl.setEnabled(false);
                    this.jFn.setVisibility(8);
                    this.jFt.setVisibility(0);
                    this.jFt.setOnClickListener(this.dRF);
                    this.jFk.setText(this.jFh.cwa() + "票");
                } else if (this.status == 6) {
                    this.jFj.setVisibility(0);
                    this.jFl.setEnabled(false);
                    this.jFn.setVisibility(8);
                    this.jFk.setText(this.jFh.cwa() + "票");
                    this.jFt.setVisibility(8);
                } else {
                    this.mRootView.setVisibility(8);
                    return;
                }
                if (!v.isEmpty(this.jFh.cwb()) || !v.isEmpty(this.jFh.cwc())) {
                    this.jFs.setColumn(2);
                    this.jFs.setData(this.jFh.cwb(), this.jFh.cwc());
                }
                pH(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public void pH(int i) {
        am.setViewTextColor(this.jFk, R.color.cp_link_tip_c, 1, i);
        am.setViewTextColor(this.jFi, R.color.cp_cont_d, 1, i);
        am.setViewTextColor(this.jFm, R.color.cp_cont_d, 1, i);
        am.setViewTextColor(this.jFr, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.jFt, R.color.cp_link_tip_c, 1, i);
        am.setViewTextColor(this.jFo, R.color.cp_cont_b, 1, i);
        if (this.jFl != null) {
            this.jFl.aQp();
        }
        am.setBackgroundColor(this.jFq, R.color.cp_bg_line_g, i);
        if (this.jFp != null) {
            this.jFp.pH(i);
        }
        if (this.jFs != null) {
            this.jFs.nh(i);
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
        if (eVar.cvE() != null) {
            return eVar.cvE();
        }
        if (!v.isEmpty(eVar.cvw())) {
            Iterator<PostData> it = eVar.cvw().iterator();
            while (it.hasNext()) {
                postData = it.next();
                if (postData != null && postData.cWr() == 1) {
                    break;
                }
            }
        }
        postData = null;
        if (postData == null) {
            postData = eVar.cvB();
        }
        if (postData == null) {
            postData = a(eVar);
        }
        if (postData != null && postData.aKE() != null && postData.aKE().getUserTbVipInfoData() != null && postData.aKE().getUserTbVipInfoData().getvipIntro() != null) {
            postData.aKE().getGodUserData().setIntro(postData.aKE().getUserTbVipInfoData().getvipIntro());
            return postData;
        }
        return postData;
    }

    private PostData a(e eVar) {
        MetaData metaData;
        if (eVar == null || eVar.cvu() == null || eVar.cvu().aKE() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData aKE = eVar.cvu().aKE();
        String userId = aKE.getUserId();
        HashMap<String, MetaData> userMap = eVar.cvu().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = aKE;
        }
        postData.Di(1);
        postData.setId(eVar.cvu().aKU());
        postData.setTitle(eVar.cvu().getTitle());
        postData.setTime(eVar.cvu().getCreateTime());
        postData.a(metaData);
        return postData;
    }
}
