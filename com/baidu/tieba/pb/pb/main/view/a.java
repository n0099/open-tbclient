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
    private h jFl;
    private TextView jFm;
    private View jFn;
    private TextView jFo;
    private TBSpecificationBtn jFp;
    private TextView jFq;
    private View jFr;
    private TextView jFs;
    private VoteCountDownView jFt;
    private View jFu;
    private TextView jFv;
    private SelectRuleView jFw;
    private TextView jFx;
    private e jqG;
    private TbPageContext mPageContext;
    private View mRootView;
    private int status;
    private VoteCountDownView.a jFy = new VoteCountDownView.a() { // from class: com.baidu.tieba.pb.pb.main.view.a.1
        @Override // com.baidu.tieba.view.VoteCountDownView.a
        public void onFinished() {
            if (a.this.mRootView != null) {
                if (a.this.jqG == null || a.this.jqG.jnB == null) {
                    a.this.mRootView.setVisibility(8);
                    return;
                }
                a.this.jqG.jnB.setStatus(3);
                a.this.setData(a.this.jqG);
            }
        }
    };
    private View.OnClickListener dRK = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.pb_jump_to_vote_page) {
                if (a.this.jqG != null && a.this.mPageContext != null && bc.checkUpIsLogin(a.this.mPageContext.getPageActivity())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921408, new BarVoteActivityConfig(a.this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(a.this.jqG.getForumId(), 0L), 3)));
                }
            } else if (view.getId() == R.id.pb_vote_button && bc.checkUpIsLogin(a.this.mPageContext.getPageActivity()) && a.this.jqG != null && a.this.jFl != null && a.this.jqG.cvs() != null) {
                if (a.this.jFl.bDU()) {
                    new an("c13444").cI("forum_id", a.this.jqG.getForumId()).aOO();
                    d dVar = new d();
                    dVar.setThreadId(com.baidu.adp.lib.f.b.toLong(a.this.jqG.getThreadId(), 0L));
                    dVar.setForumId(com.baidu.adp.lib.f.b.toLong(a.this.jqG.getForumId(), 0L));
                    String str = "";
                    PostData F = a.this.F(a.this.jqG);
                    if (F != null && F.aKC() != null) {
                        str = F.aKC().getUserId();
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
    private HttpMessageListener ghL = new HttpMessageListener(CmdConfigHttp.CMD_BAR_VOTE) { // from class: com.baidu.tieba.pb.pb.main.view.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            String errorString;
            if (httpResponsedMessage != null && httpResponsedMessage.getOrginalMessage() != null) {
                int error = httpResponsedMessage.getError();
                if ((httpResponsedMessage instanceof CommitVoteResMsg) && a.this.jqG != null && a.this.jqG.jnB != null && a.this.mPageContext != null && httpResponsedMessage.getOrginalMessage().getTag() == a.this.mPageContext.getUniqueId()) {
                    if (error == 0) {
                        l.showToast(TbadkCoreApplication.getInst(), (int) R.string.bar_manager_vote_success);
                        a.this.jqG.jnB.zk(a.this.jqG.jnB.cvY() + 1);
                        a.this.jqG.jnB.lm(false);
                        a.this.setData(a.this.jqG);
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
        this.jFm = (TextView) this.mRootView.findViewById(R.id.pb_bar_manager_select_warn);
        this.jFn = this.mRootView.findViewById(R.id.pb_vote_button_container);
        this.jFs = (TextView) this.mRootView.findViewById(R.id.pb_count_down_title);
        this.jFp = (TBSpecificationBtn) this.mRootView.findViewById(R.id.pb_vote_button);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        bVar.a(GradientDrawable.Orientation.TL_BR);
        this.jFp.setText(TbadkCoreApplication.getInst().getString(R.string.pb_vote_text));
        this.jFp.setTextSize(R.dimen.tbfontsize44);
        this.jFp.setConfig(bVar);
        this.jFo = (TextView) this.mRootView.findViewById(R.id.pb_vote_num);
        this.jFq = (TextView) this.mRootView.findViewById(R.id.pb_bar_manager_ueg_tip);
        this.jFr = this.mRootView.findViewById(R.id.pb_count_down_container);
        this.jFt = (VoteCountDownView) this.mRootView.findViewById(R.id.pb_vote_count_down_view);
        this.jFu = this.mRootView.findViewById(R.id.pb_vote_rule);
        this.jFv = (TextView) this.mRootView.findViewById(R.id.pb_vote_rule_title);
        this.jFw = (SelectRuleView) this.mRootView.findViewById(R.id.pb_vote_rule_content);
        this.jFx = (TextView) this.mRootView.findViewById(R.id.pb_jump_to_vote_page);
        MessageManager.getInstance().registerListener(this.ghL);
        setData(eVar);
        return this.mRootView;
    }

    public void setData(e eVar) {
        if (this.mRootView != null) {
            if (eVar == null || eVar.jnB == null) {
                this.mRootView.setVisibility(8);
                return;
            }
            this.jqG = eVar;
            this.jFl = eVar.jnB;
            if (this.jFl.getStatus() != 0) {
                this.status = this.jFl.getStatus();
                if (this.status == 2) {
                    this.jFn.setVisibility(8);
                    this.jFr.setVisibility(0);
                    this.jFt.setOnCountDownFinished(this.jFy);
                    this.jFt.setData(this.jFl.cvX() * 1000);
                    this.jFx.setVisibility(8);
                } else if (this.status == 3) {
                    this.jFn.setVisibility(0);
                    this.jFp.setOnClickListener(this.dRK);
                    this.jFr.setVisibility(8);
                    this.jFx.setVisibility(0);
                    this.jFx.setOnClickListener(this.dRK);
                    this.jFo.setText(this.jFl.cvY() + "票");
                } else if (this.status == 4 || this.status == 5) {
                    this.jFn.setVisibility(0);
                    this.jFp.setEnabled(false);
                    this.jFr.setVisibility(8);
                    this.jFx.setVisibility(0);
                    this.jFx.setOnClickListener(this.dRK);
                    this.jFo.setText(this.jFl.cvY() + "票");
                } else if (this.status == 6) {
                    this.jFn.setVisibility(0);
                    this.jFp.setEnabled(false);
                    this.jFr.setVisibility(8);
                    this.jFo.setText(this.jFl.cvY() + "票");
                    this.jFx.setVisibility(8);
                } else {
                    this.mRootView.setVisibility(8);
                    return;
                }
                if (!v.isEmpty(this.jFl.cvZ()) || !v.isEmpty(this.jFl.cwa())) {
                    this.jFw.setColumn(2);
                    this.jFw.setData(this.jFl.cvZ(), this.jFl.cwa());
                }
                pH(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public void pH(int i) {
        am.setViewTextColor(this.jFo, R.color.cp_link_tip_c, 1, i);
        am.setViewTextColor(this.jFm, R.color.cp_cont_d, 1, i);
        am.setViewTextColor(this.jFq, R.color.cp_cont_d, 1, i);
        am.setViewTextColor(this.jFv, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.jFx, R.color.cp_link_tip_c, 1, i);
        am.setViewTextColor(this.jFs, R.color.cp_cont_b, 1, i);
        if (this.jFp != null) {
            this.jFp.aQm();
        }
        am.setBackgroundColor(this.jFu, R.color.cp_bg_line_g, i);
        if (this.jFt != null) {
            this.jFt.pH(i);
        }
        if (this.jFw != null) {
            this.jFw.nh(i);
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
        if (eVar.cvC() != null) {
            return eVar.cvC();
        }
        if (!v.isEmpty(eVar.cvu())) {
            Iterator<PostData> it = eVar.cvu().iterator();
            while (it.hasNext()) {
                postData = it.next();
                if (postData != null && postData.cWp() == 1) {
                    break;
                }
            }
        }
        postData = null;
        if (postData == null) {
            postData = eVar.cvz();
        }
        if (postData == null) {
            postData = a(eVar);
        }
        if (postData != null && postData.aKC() != null && postData.aKC().getUserTbVipInfoData() != null && postData.aKC().getUserTbVipInfoData().getvipIntro() != null) {
            postData.aKC().getGodUserData().setIntro(postData.aKC().getUserTbVipInfoData().getvipIntro());
            return postData;
        }
        return postData;
    }

    private PostData a(e eVar) {
        MetaData metaData;
        if (eVar == null || eVar.cvs() == null || eVar.cvs().aKC() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData aKC = eVar.cvs().aKC();
        String userId = aKC.getUserId();
        HashMap<String, MetaData> userMap = eVar.cvs().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = aKC;
        }
        postData.Di(1);
        postData.setId(eVar.cvs().aKS());
        postData.setTitle(eVar.cvs().getTitle());
        postData.setTime(eVar.cvs().getCreateTime());
        postData.a(metaData);
        return postData;
    }
}
