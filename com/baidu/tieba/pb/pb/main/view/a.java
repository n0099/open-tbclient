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
import com.baidu.tieba.pb.data.i;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.util.f;
import com.baidu.tieba.view.VoteCountDownView;
import java.util.HashMap;
import java.util.Iterator;
/* loaded from: classes9.dex */
public class a {
    private e jHu;
    private i jWM;
    private TextView jWN;
    private View jWO;
    private TextView jWP;
    private TBSpecificationBtn jWQ;
    private TextView jWR;
    private View jWS;
    private TextView jWT;
    private VoteCountDownView jWU;
    private View jWV;
    private TextView jWW;
    private SelectRuleView jWX;
    private TextView jWY;
    private TbPageContext mPageContext;
    private View mRootView;
    private int status;
    private VoteCountDownView.a jWZ = new VoteCountDownView.a() { // from class: com.baidu.tieba.pb.pb.main.view.a.1
        @Override // com.baidu.tieba.view.VoteCountDownView.a
        public void Qv() {
            if (a.this.mRootView != null) {
                if (a.this.jHu == null || a.this.jHu.jDX == null) {
                    a.this.mRootView.setVisibility(8);
                    return;
                }
                a.this.jHu.jDX.setStatus(3);
                a.this.setData(a.this.jHu);
            }
        }
    };
    private View.OnClickListener ege = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.pb_jump_to_vote_page) {
                if (a.this.jHu != null && a.this.mPageContext != null && bc.checkUpIsLogin(a.this.mPageContext.getPageActivity())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921408, new BarVoteActivityConfig(a.this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(a.this.jHu.getForumId(), 0L), 3)));
                }
            } else if (view.getId() == R.id.pb_vote_button && bc.checkUpIsLogin(a.this.mPageContext.getPageActivity()) && a.this.jHu != null && a.this.jWM != null && a.this.jHu.cCi() != null) {
                if (a.this.jWM.bKl()) {
                    new an("c13444").dh("forum_id", a.this.jHu.getForumId()).aUS();
                    d dVar = new d();
                    dVar.setThreadId(com.baidu.adp.lib.f.b.toLong(a.this.jHu.getThreadId(), 0L));
                    dVar.setForumId(com.baidu.adp.lib.f.b.toLong(a.this.jHu.getForumId(), 0L));
                    String str = "";
                    PostData H = a.this.H(a.this.jHu);
                    if (H != null && H.aQx() != null) {
                        str = H.aQx().getUserId();
                    }
                    dVar.fd(com.baidu.adp.lib.f.b.toLong(str, 0L));
                    dVar.zP(2);
                    dVar.t(a.this.mPageContext.getUniqueId());
                    CustomMessage customMessage = new CustomMessage(2921411);
                    customMessage.setData(dVar);
                    MessageManager.getInstance().sendMessage(customMessage);
                    return;
                }
                l.showToast(TbadkCoreApplication.getInst(), (int) R.string.has_not_other_ticket);
            }
        }
    };
    private HttpMessageListener gwC = new HttpMessageListener(CmdConfigHttp.CMD_BAR_VOTE) { // from class: com.baidu.tieba.pb.pb.main.view.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            String errorString;
            if (httpResponsedMessage != null && httpResponsedMessage.getOrginalMessage() != null) {
                int error = httpResponsedMessage.getError();
                if ((httpResponsedMessage instanceof CommitVoteResMsg) && a.this.jHu != null && a.this.jHu.jDX != null && a.this.mPageContext != null && httpResponsedMessage.getOrginalMessage().getTag() == a.this.mPageContext.getUniqueId()) {
                    if (error == 0) {
                        l.showToast(TbadkCoreApplication.getInst(), (int) R.string.bar_manager_vote_success);
                        a.this.jHu.jDX.zU(a.this.jHu.jDX.cCR() + 1);
                        a.this.jHu.jDX.lI(false);
                        a.this.setData(a.this.jHu);
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

    public View G(e eVar) {
        if (this.mPageContext == null) {
            return null;
        }
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.bar_manager_select_view, (ViewGroup) null);
        this.jWN = (TextView) this.mRootView.findViewById(R.id.pb_bar_manager_select_warn);
        this.jWO = this.mRootView.findViewById(R.id.pb_vote_button_container);
        this.jWT = (TextView) this.mRootView.findViewById(R.id.pb_count_down_title);
        this.jWQ = (TBSpecificationBtn) this.mRootView.findViewById(R.id.pb_vote_button);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        bVar.a(GradientDrawable.Orientation.TL_BR);
        this.jWQ.setText(TbadkCoreApplication.getInst().getString(R.string.pb_vote_text));
        this.jWQ.setTextSize(R.dimen.tbfontsize44);
        this.jWQ.setConfig(bVar);
        this.jWP = (TextView) this.mRootView.findViewById(R.id.pb_vote_num);
        this.jWR = (TextView) this.mRootView.findViewById(R.id.pb_bar_manager_ueg_tip);
        this.jWS = this.mRootView.findViewById(R.id.pb_count_down_container);
        this.jWU = (VoteCountDownView) this.mRootView.findViewById(R.id.pb_vote_count_down_view);
        this.jWV = this.mRootView.findViewById(R.id.pb_vote_rule);
        this.jWW = (TextView) this.mRootView.findViewById(R.id.pb_vote_rule_title);
        this.jWX = (SelectRuleView) this.mRootView.findViewById(R.id.pb_vote_rule_content);
        this.jWY = (TextView) this.mRootView.findViewById(R.id.pb_jump_to_vote_page);
        MessageManager.getInstance().registerListener(this.gwC);
        setData(eVar);
        return this.mRootView;
    }

    public void setData(e eVar) {
        if (this.mRootView != null) {
            if (eVar == null || eVar.jDX == null) {
                this.mRootView.setVisibility(8);
                return;
            }
            this.jHu = eVar;
            this.jWM = eVar.jDX;
            if (this.jWM.getStatus() != 0) {
                this.status = this.jWM.getStatus();
                if (this.status == 2) {
                    this.jWO.setVisibility(8);
                    this.jWS.setVisibility(0);
                    this.jWU.setOnCountDownFinished(this.jWZ);
                    this.jWU.setData(this.jWM.cCQ() * 1000);
                    this.jWY.setVisibility(8);
                } else if (this.status == 3) {
                    this.jWO.setVisibility(0);
                    this.jWQ.setOnClickListener(this.ege);
                    this.jWS.setVisibility(8);
                    this.jWY.setVisibility(0);
                    this.jWY.setOnClickListener(this.ege);
                    this.jWP.setText(this.jWM.cCR() + "票");
                } else if (this.status == 4 || this.status == 5) {
                    this.jWO.setVisibility(0);
                    this.jWQ.setEnabled(false);
                    this.jWS.setVisibility(8);
                    this.jWY.setVisibility(0);
                    this.jWY.setOnClickListener(this.ege);
                    this.jWP.setText(this.jWM.cCR() + "票");
                } else if (this.status == 6) {
                    this.jWO.setVisibility(0);
                    this.jWQ.setEnabled(false);
                    this.jWS.setVisibility(8);
                    this.jWP.setText(this.jWM.cCR() + "票");
                    this.jWY.setVisibility(8);
                } else {
                    this.mRootView.setVisibility(8);
                    return;
                }
                if (!v.isEmpty(this.jWM.cCS()) || !v.isEmpty(this.jWM.cCT())) {
                    this.jWX.setColumn(2);
                    this.jWX.setData(this.jWM.cCS(), this.jWM.cCT());
                }
                qi(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public void qi(int i) {
        am.setViewTextColor(this.jWP, R.color.cp_link_tip_c, 1, i);
        am.setViewTextColor(this.jWN, R.color.cp_cont_d, 1, i);
        am.setViewTextColor(this.jWR, R.color.cp_cont_d, 1, i);
        am.setViewTextColor(this.jWW, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.jWY, R.color.cp_link_tip_c, 1, i);
        am.setViewTextColor(this.jWT, R.color.cp_cont_b, 1, i);
        if (this.jWQ != null) {
            this.jWQ.aWq();
        }
        am.setBackgroundColor(this.jWV, R.color.cp_bg_line_g, i);
        if (this.jWU != null) {
            this.jWU.qi(i);
        }
        if (this.jWX != null) {
            this.jWX.nJ(i);
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public PostData H(e eVar) {
        PostData postData;
        if (eVar == null) {
            return null;
        }
        if (eVar.cCv() != null) {
            return eVar.cCv();
        }
        if (!v.isEmpty(eVar.cCk())) {
            Iterator<PostData> it = eVar.cCk().iterator();
            while (it.hasNext()) {
                postData = it.next();
                if (postData != null && postData.ddu() == 1) {
                    break;
                }
            }
        }
        postData = null;
        if (postData == null) {
            postData = eVar.cCr();
        }
        if (postData == null) {
            postData = a(eVar);
        }
        if (postData != null && postData.aQx() != null && postData.aQx().getUserTbVipInfoData() != null && postData.aQx().getUserTbVipInfoData().getvipIntro() != null) {
            postData.aQx().getGodUserData().setIntro(postData.aQx().getUserTbVipInfoData().getvipIntro());
            return postData;
        }
        return postData;
    }

    private PostData a(e eVar) {
        MetaData metaData;
        if (eVar == null || eVar.cCi() == null || eVar.cCi().aQx() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData aQx = eVar.cCi().aQx();
        String userId = aQx.getUserId();
        HashMap<String, MetaData> userMap = eVar.cCi().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = aQx;
        }
        postData.DS(1);
        postData.setId(eVar.cCi().aQP());
        postData.setTitle(eVar.cCi().getTitle());
        postData.setTime(eVar.cCi().getCreateTime());
        postData.a(metaData);
        return postData;
    }
}
