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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.w;
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
    private e kck;
    private i krK;
    private TextView krL;
    private View krM;
    private TextView krN;
    private TBSpecificationBtn krO;
    private TextView krP;
    private View krQ;
    private TextView krR;
    private VoteCountDownView krS;
    private View krT;
    private TextView krU;
    private SelectRuleView krV;
    private TextView krW;
    private TbPageContext mPageContext;
    private View mRootView;
    private int status;
    private VoteCountDownView.a krX = new VoteCountDownView.a() { // from class: com.baidu.tieba.pb.pb.main.view.a.1
        @Override // com.baidu.tieba.view.VoteCountDownView.a
        public void RB() {
            if (a.this.mRootView != null) {
                if (a.this.kck == null || a.this.kck.jYN == null) {
                    a.this.mRootView.setVisibility(8);
                    return;
                }
                a.this.kck.jYN.setStatus(3);
                a.this.setData(a.this.kck);
            }
        }
    };
    private View.OnClickListener eoP = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.pb_jump_to_vote_page) {
                if (a.this.kck != null && a.this.mPageContext != null && be.checkUpIsLogin(a.this.mPageContext.getPageActivity())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921408, new BarVoteActivityConfig(a.this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(a.this.kck.getForumId(), 0L), 3)));
                }
            } else if (view.getId() == R.id.pb_vote_button && be.checkUpIsLogin(a.this.mPageContext.getPageActivity()) && a.this.kck != null && a.this.krK != null && a.this.kck.cGN() != null) {
                if (a.this.krK.bNs()) {
                    new ao("c13444").dk("forum_id", a.this.kck.getForumId()).aWN();
                    d dVar = new d();
                    dVar.setThreadId(com.baidu.adp.lib.f.b.toLong(a.this.kck.getThreadId(), 0L));
                    dVar.setForumId(com.baidu.adp.lib.f.b.toLong(a.this.kck.getForumId(), 0L));
                    String str = "";
                    PostData I = a.this.I(a.this.kck);
                    if (I != null && I.aSp() != null) {
                        str = I.aSp().getUserId();
                    }
                    dVar.fg(com.baidu.adp.lib.f.b.toLong(str, 0L));
                    dVar.AT(2);
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
    private HttpMessageListener gJB = new HttpMessageListener(CmdConfigHttp.CMD_BAR_VOTE) { // from class: com.baidu.tieba.pb.pb.main.view.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            String errorString;
            if (httpResponsedMessage != null && httpResponsedMessage.getOrginalMessage() != null) {
                int error = httpResponsedMessage.getError();
                if ((httpResponsedMessage instanceof CommitVoteResMsg) && a.this.kck != null && a.this.kck.jYN != null && a.this.mPageContext != null && httpResponsedMessage.getOrginalMessage().getTag() == a.this.mPageContext.getUniqueId()) {
                    if (error == 0) {
                        l.showToast(TbadkCoreApplication.getInst(), (int) R.string.bar_manager_vote_success);
                        a.this.kck.jYN.AY(a.this.kck.jYN.cHx() + 1);
                        a.this.kck.jYN.lR(false);
                        a.this.setData(a.this.kck);
                    } else if (error == 3250023) {
                        f.a(error, "", (f.a) null);
                    } else if (error == 3250021) {
                        f.a(error, ((CommitVoteResMsg) httpResponsedMessage).getTokenData(), (f.a) null);
                    } else if (error == 3250002 || error == 3250004) {
                        BlockPopInfoData blockPopInfoData = new BlockPopInfoData();
                        if (ar.isEmpty(httpResponsedMessage.getErrorString())) {
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

    public View H(e eVar) {
        if (this.mPageContext == null) {
            return null;
        }
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.bar_manager_select_view, (ViewGroup) null);
        this.krL = (TextView) this.mRootView.findViewById(R.id.pb_bar_manager_select_warn);
        this.krM = this.mRootView.findViewById(R.id.pb_vote_button_container);
        this.krR = (TextView) this.mRootView.findViewById(R.id.pb_count_down_title);
        this.krO = (TBSpecificationBtn) this.mRootView.findViewById(R.id.pb_vote_button);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        bVar.a(GradientDrawable.Orientation.TL_BR);
        this.krO.setText(TbadkCoreApplication.getInst().getString(R.string.pb_vote_text));
        this.krO.setTextSize(R.dimen.tbfontsize44);
        this.krO.setConfig(bVar);
        this.krN = (TextView) this.mRootView.findViewById(R.id.pb_vote_num);
        this.krP = (TextView) this.mRootView.findViewById(R.id.pb_bar_manager_ueg_tip);
        this.krQ = this.mRootView.findViewById(R.id.pb_count_down_container);
        this.krS = (VoteCountDownView) this.mRootView.findViewById(R.id.pb_vote_count_down_view);
        this.krT = this.mRootView.findViewById(R.id.pb_vote_rule);
        this.krU = (TextView) this.mRootView.findViewById(R.id.pb_vote_rule_title);
        this.krV = (SelectRuleView) this.mRootView.findViewById(R.id.pb_vote_rule_content);
        this.krW = (TextView) this.mRootView.findViewById(R.id.pb_jump_to_vote_page);
        MessageManager.getInstance().registerListener(this.gJB);
        setData(eVar);
        return this.mRootView;
    }

    public void setData(e eVar) {
        if (this.mRootView != null) {
            if (eVar == null || eVar.jYN == null) {
                this.mRootView.setVisibility(8);
                return;
            }
            this.kck = eVar;
            this.krK = eVar.jYN;
            if (this.krK.getStatus() != 0) {
                this.status = this.krK.getStatus();
                if (this.status == 2) {
                    this.krM.setVisibility(8);
                    this.krQ.setVisibility(0);
                    this.krS.setOnCountDownFinished(this.krX);
                    this.krS.setData(this.krK.cHw() * 1000);
                    this.krW.setVisibility(8);
                } else if (this.status == 3) {
                    this.krM.setVisibility(0);
                    this.krO.setOnClickListener(this.eoP);
                    this.krQ.setVisibility(8);
                    this.krW.setVisibility(0);
                    this.krW.setOnClickListener(this.eoP);
                    this.krN.setText(this.krK.cHx() + "票");
                } else if (this.status == 4 || this.status == 5) {
                    this.krM.setVisibility(0);
                    this.krO.setEnabled(false);
                    this.krQ.setVisibility(8);
                    this.krW.setVisibility(0);
                    this.krW.setOnClickListener(this.eoP);
                    this.krN.setText(this.krK.cHx() + "票");
                } else if (this.status == 6) {
                    this.krM.setVisibility(0);
                    this.krO.setEnabled(false);
                    this.krQ.setVisibility(8);
                    this.krN.setText(this.krK.cHx() + "票");
                    this.krW.setVisibility(8);
                } else {
                    this.mRootView.setVisibility(8);
                    return;
                }
                if (!w.isEmpty(this.krK.cHy()) || !w.isEmpty(this.krK.cHz())) {
                    this.krV.setColumn(2);
                    this.krV.setData(this.krK.cHy(), this.krK.cHz());
                }
                qJ(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public void qJ(int i) {
        an.setViewTextColor(this.krN, R.color.cp_link_tip_c, 1, i);
        an.setViewTextColor(this.krL, R.color.cp_cont_d, 1, i);
        an.setViewTextColor(this.krP, R.color.cp_cont_d, 1, i);
        an.setViewTextColor(this.krU, R.color.cp_cont_b, 1, i);
        an.setViewTextColor(this.krW, R.color.cp_link_tip_c, 1, i);
        an.setViewTextColor(this.krR, R.color.cp_cont_b, 1, i);
        if (this.krO != null) {
            this.krO.aYj();
        }
        an.setBackgroundColor(this.krT, R.color.cp_bg_line_g, i);
        if (this.krS != null) {
            this.krS.qJ(i);
        }
        if (this.krV != null) {
            this.krV.oh(i);
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public PostData I(e eVar) {
        PostData postData;
        if (eVar == null) {
            return null;
        }
        if (eVar.cHa() != null) {
            return eVar.cHa();
        }
        if (!w.isEmpty(eVar.cGP())) {
            Iterator<PostData> it = eVar.cGP().iterator();
            while (it.hasNext()) {
                postData = it.next();
                if (postData != null && postData.dhY() == 1) {
                    break;
                }
            }
        }
        postData = null;
        if (postData == null) {
            postData = eVar.cGW();
        }
        if (postData == null) {
            postData = a(eVar);
        }
        if (postData != null && postData.aSp() != null && postData.aSp().getUserTbVipInfoData() != null && postData.aSp().getUserTbVipInfoData().getvipIntro() != null) {
            postData.aSp().getGodUserData().setIntro(postData.aSp().getUserTbVipInfoData().getvipIntro());
            return postData;
        }
        return postData;
    }

    private PostData a(e eVar) {
        MetaData metaData;
        if (eVar == null || eVar.cGN() == null || eVar.cGN().aSp() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData aSp = eVar.cGN().aSp();
        String userId = aSp.getUserId();
        HashMap<String, MetaData> userMap = eVar.cGN().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = aSp;
        }
        postData.EW(1);
        postData.setId(eVar.cGN().aSG());
        postData.setTitle(eVar.cGN().getTitle());
        postData.setTime(eVar.cGN().getCreateTime());
        postData.a(metaData);
        return postData;
    }
}
