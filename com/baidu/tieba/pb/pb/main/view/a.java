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
    private e jIA;
    private i jXS;
    private TextView jXT;
    private View jXU;
    private TextView jXV;
    private TBSpecificationBtn jXW;
    private TextView jXX;
    private View jXY;
    private TextView jXZ;
    private VoteCountDownView jYa;
    private View jYb;
    private TextView jYc;
    private SelectRuleView jYd;
    private TextView jYe;
    private TbPageContext mPageContext;
    private View mRootView;
    private int status;
    private VoteCountDownView.a jYf = new VoteCountDownView.a() { // from class: com.baidu.tieba.pb.pb.main.view.a.1
        @Override // com.baidu.tieba.view.VoteCountDownView.a
        public void Qv() {
            if (a.this.mRootView != null) {
                if (a.this.jIA == null || a.this.jIA.jFd == null) {
                    a.this.mRootView.setVisibility(8);
                    return;
                }
                a.this.jIA.jFd.setStatus(3);
                a.this.setData(a.this.jIA);
            }
        }
    };
    private View.OnClickListener ege = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.pb_jump_to_vote_page) {
                if (a.this.jIA != null && a.this.mPageContext != null && bc.checkUpIsLogin(a.this.mPageContext.getPageActivity())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921408, new BarVoteActivityConfig(a.this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(a.this.jIA.getForumId(), 0L), 3)));
                }
            } else if (view.getId() == R.id.pb_vote_button && bc.checkUpIsLogin(a.this.mPageContext.getPageActivity()) && a.this.jIA != null && a.this.jXS != null && a.this.jIA.cCy() != null) {
                if (a.this.jXS.bKn()) {
                    new an("c13444").dh("forum_id", a.this.jIA.getForumId()).aUT();
                    d dVar = new d();
                    dVar.setThreadId(com.baidu.adp.lib.f.b.toLong(a.this.jIA.getThreadId(), 0L));
                    dVar.setForumId(com.baidu.adp.lib.f.b.toLong(a.this.jIA.getForumId(), 0L));
                    String str = "";
                    PostData H = a.this.H(a.this.jIA);
                    if (H != null && H.aQx() != null) {
                        str = H.aQx().getUserId();
                    }
                    dVar.fd(com.baidu.adp.lib.f.b.toLong(str, 0L));
                    dVar.zR(2);
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
    private HttpMessageListener gwN = new HttpMessageListener(CmdConfigHttp.CMD_BAR_VOTE) { // from class: com.baidu.tieba.pb.pb.main.view.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            String errorString;
            if (httpResponsedMessage != null && httpResponsedMessage.getOrginalMessage() != null) {
                int error = httpResponsedMessage.getError();
                if ((httpResponsedMessage instanceof CommitVoteResMsg) && a.this.jIA != null && a.this.jIA.jFd != null && a.this.mPageContext != null && httpResponsedMessage.getOrginalMessage().getTag() == a.this.mPageContext.getUniqueId()) {
                    if (error == 0) {
                        l.showToast(TbadkCoreApplication.getInst(), (int) R.string.bar_manager_vote_success);
                        a.this.jIA.jFd.zW(a.this.jIA.jFd.cDh() + 1);
                        a.this.jIA.jFd.lI(false);
                        a.this.setData(a.this.jIA);
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
        this.jXT = (TextView) this.mRootView.findViewById(R.id.pb_bar_manager_select_warn);
        this.jXU = this.mRootView.findViewById(R.id.pb_vote_button_container);
        this.jXZ = (TextView) this.mRootView.findViewById(R.id.pb_count_down_title);
        this.jXW = (TBSpecificationBtn) this.mRootView.findViewById(R.id.pb_vote_button);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        bVar.a(GradientDrawable.Orientation.TL_BR);
        this.jXW.setText(TbadkCoreApplication.getInst().getString(R.string.pb_vote_text));
        this.jXW.setTextSize(R.dimen.tbfontsize44);
        this.jXW.setConfig(bVar);
        this.jXV = (TextView) this.mRootView.findViewById(R.id.pb_vote_num);
        this.jXX = (TextView) this.mRootView.findViewById(R.id.pb_bar_manager_ueg_tip);
        this.jXY = this.mRootView.findViewById(R.id.pb_count_down_container);
        this.jYa = (VoteCountDownView) this.mRootView.findViewById(R.id.pb_vote_count_down_view);
        this.jYb = this.mRootView.findViewById(R.id.pb_vote_rule);
        this.jYc = (TextView) this.mRootView.findViewById(R.id.pb_vote_rule_title);
        this.jYd = (SelectRuleView) this.mRootView.findViewById(R.id.pb_vote_rule_content);
        this.jYe = (TextView) this.mRootView.findViewById(R.id.pb_jump_to_vote_page);
        MessageManager.getInstance().registerListener(this.gwN);
        setData(eVar);
        return this.mRootView;
    }

    public void setData(e eVar) {
        if (this.mRootView != null) {
            if (eVar == null || eVar.jFd == null) {
                this.mRootView.setVisibility(8);
                return;
            }
            this.jIA = eVar;
            this.jXS = eVar.jFd;
            if (this.jXS.getStatus() != 0) {
                this.status = this.jXS.getStatus();
                if (this.status == 2) {
                    this.jXU.setVisibility(8);
                    this.jXY.setVisibility(0);
                    this.jYa.setOnCountDownFinished(this.jYf);
                    this.jYa.setData(this.jXS.cDg() * 1000);
                    this.jYe.setVisibility(8);
                } else if (this.status == 3) {
                    this.jXU.setVisibility(0);
                    this.jXW.setOnClickListener(this.ege);
                    this.jXY.setVisibility(8);
                    this.jYe.setVisibility(0);
                    this.jYe.setOnClickListener(this.ege);
                    this.jXV.setText(this.jXS.cDh() + "票");
                } else if (this.status == 4 || this.status == 5) {
                    this.jXU.setVisibility(0);
                    this.jXW.setEnabled(false);
                    this.jXY.setVisibility(8);
                    this.jYe.setVisibility(0);
                    this.jYe.setOnClickListener(this.ege);
                    this.jXV.setText(this.jXS.cDh() + "票");
                } else if (this.status == 6) {
                    this.jXU.setVisibility(0);
                    this.jXW.setEnabled(false);
                    this.jXY.setVisibility(8);
                    this.jXV.setText(this.jXS.cDh() + "票");
                    this.jYe.setVisibility(8);
                } else {
                    this.mRootView.setVisibility(8);
                    return;
                }
                if (!v.isEmpty(this.jXS.cDi()) || !v.isEmpty(this.jXS.cDj())) {
                    this.jYd.setColumn(2);
                    this.jYd.setData(this.jXS.cDi(), this.jXS.cDj());
                }
                qk(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public void qk(int i) {
        am.setViewTextColor(this.jXV, R.color.cp_link_tip_c, 1, i);
        am.setViewTextColor(this.jXT, R.color.cp_cont_d, 1, i);
        am.setViewTextColor(this.jXX, R.color.cp_cont_d, 1, i);
        am.setViewTextColor(this.jYc, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.jYe, R.color.cp_link_tip_c, 1, i);
        am.setViewTextColor(this.jXZ, R.color.cp_cont_b, 1, i);
        if (this.jXW != null) {
            this.jXW.aWr();
        }
        am.setBackgroundColor(this.jYb, R.color.cp_bg_line_g, i);
        if (this.jYa != null) {
            this.jYa.qk(i);
        }
        if (this.jYd != null) {
            this.jYd.nL(i);
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
        if (eVar.cCL() != null) {
            return eVar.cCL();
        }
        if (!v.isEmpty(eVar.cCA())) {
            Iterator<PostData> it = eVar.cCA().iterator();
            while (it.hasNext()) {
                postData = it.next();
                if (postData != null && postData.ddJ() == 1) {
                    break;
                }
            }
        }
        postData = null;
        if (postData == null) {
            postData = eVar.cCH();
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
        if (eVar == null || eVar.cCy() == null || eVar.cCy().aQx() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData aQx = eVar.cCy().aQx();
        String userId = aQx.getUserId();
        HashMap<String, MetaData> userMap = eVar.cCy().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = aQx;
        }
        postData.DU(1);
        postData.setId(eVar.cCy().aQP());
        postData.setTitle(eVar.cCy().getTitle());
        postData.setTime(eVar.cCy().getCreateTime());
        postData.a(metaData);
        return postData;
    }
}
