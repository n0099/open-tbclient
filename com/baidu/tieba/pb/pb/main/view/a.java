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
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BarVoteActivityConfig;
import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.data.CommitVoteResMsg;
import com.baidu.tbadk.widget.SelectRuleView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.d;
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.pb.data.k;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.util.f;
import com.baidu.tieba.view.VoteCountDownView;
import java.util.HashMap;
import java.util.Iterator;
/* loaded from: classes16.dex */
public class a {
    private k kAI;
    private TextView kAJ;
    private View kAK;
    private TextView kAL;
    private TBSpecificationBtn kAM;
    private TextView kAN;
    private View kAO;
    private TextView kAP;
    private VoteCountDownView kAQ;
    private View kAR;
    private TextView kAS;
    private SelectRuleView kAT;
    private TextView kAU;
    private f kkM;
    private TbPageContext mPageContext;
    private View mRootView;
    private int status;
    private VoteCountDownView.a kAV = new VoteCountDownView.a() { // from class: com.baidu.tieba.pb.pb.main.view.a.1
        @Override // com.baidu.tieba.view.VoteCountDownView.a
        public void RQ() {
            if (a.this.mRootView != null) {
                if (a.this.kkM == null || a.this.kkM.kho == null) {
                    a.this.mRootView.setVisibility(8);
                    return;
                }
                a.this.kkM.kho.setStatus(3);
                a.this.setData(a.this.kkM);
            }
        }
    };
    private View.OnClickListener eve = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.pb_jump_to_vote_page) {
                if (a.this.kkM != null && a.this.mPageContext != null && bf.checkUpIsLogin(a.this.mPageContext.getPageActivity())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921408, new BarVoteActivityConfig(a.this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(a.this.kkM.getForumId(), 0L), 3)));
                }
            } else if (view.getId() == R.id.pb_vote_button && bf.checkUpIsLogin(a.this.mPageContext.getPageActivity()) && a.this.kkM != null && a.this.kAI != null && a.this.kkM.cKx() != null) {
                if (a.this.kAI.bQE()) {
                    new ap("c13444").dn("forum_id", a.this.kkM.getForumId()).baO();
                    d dVar = new d();
                    dVar.setThreadId(com.baidu.adp.lib.f.b.toLong(a.this.kkM.getThreadId(), 0L));
                    dVar.setForumId(com.baidu.adp.lib.f.b.toLong(a.this.kkM.getForumId(), 0L));
                    String str = "";
                    PostData I = a.this.I(a.this.kkM);
                    if (I != null && I.aWl() != null) {
                        str = I.aWl().getUserId();
                    }
                    dVar.fu(com.baidu.adp.lib.f.b.toLong(str, 0L));
                    dVar.Bs(2);
                    dVar.u(a.this.mPageContext.getUniqueId());
                    CustomMessage customMessage = new CustomMessage(2921411);
                    customMessage.setData(dVar);
                    MessageManager.getInstance().sendMessage(customMessage);
                    return;
                }
                l.showToast(TbadkCoreApplication.getInst(), R.string.has_not_other_ticket);
            }
        }
    };
    private HttpMessageListener gPh = new HttpMessageListener(CmdConfigHttp.CMD_BAR_VOTE) { // from class: com.baidu.tieba.pb.pb.main.view.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            String errorString;
            if (httpResponsedMessage != null && httpResponsedMessage.getOrginalMessage() != null) {
                int error = httpResponsedMessage.getError();
                if ((httpResponsedMessage instanceof CommitVoteResMsg) && a.this.kkM != null && a.this.kkM.kho != null && a.this.mPageContext != null && httpResponsedMessage.getOrginalMessage().getTag() == a.this.mPageContext.getUniqueId()) {
                    if (error == 0) {
                        l.showToast(TbadkCoreApplication.getInst(), R.string.bar_manager_vote_success);
                        a.this.kkM.kho.Bx(a.this.kkM.kho.cLi() + 1);
                        a.this.kkM.kho.mw(false);
                        a.this.setData(a.this.kkM);
                    } else if (error == 3250023) {
                        com.baidu.tieba.tbadkCore.util.f.a(error, "", (f.a) null);
                    } else if (error == 3250021) {
                        com.baidu.tieba.tbadkCore.util.f.a(error, ((CommitVoteResMsg) httpResponsedMessage).getTokenData(), (f.a) null);
                    } else if (error == 3250002 || error == 3250004) {
                        BlockPopInfoData blockPopInfoData = new BlockPopInfoData();
                        if (as.isEmpty(httpResponsedMessage.getErrorString())) {
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

    public View H(com.baidu.tieba.pb.data.f fVar) {
        if (this.mPageContext == null) {
            return null;
        }
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.bar_manager_select_view, (ViewGroup) null);
        this.kAJ = (TextView) this.mRootView.findViewById(R.id.pb_bar_manager_select_warn);
        this.kAK = this.mRootView.findViewById(R.id.pb_vote_button_container);
        this.kAP = (TextView) this.mRootView.findViewById(R.id.pb_count_down_title);
        this.kAM = (TBSpecificationBtn) this.mRootView.findViewById(R.id.pb_vote_button);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        bVar.a(GradientDrawable.Orientation.TL_BR);
        this.kAM.setText(TbadkCoreApplication.getInst().getString(R.string.pb_vote_text));
        this.kAM.setTextSize(R.dimen.tbfontsize44);
        this.kAM.setConfig(bVar);
        this.kAL = (TextView) this.mRootView.findViewById(R.id.pb_vote_num);
        this.kAN = (TextView) this.mRootView.findViewById(R.id.pb_bar_manager_ueg_tip);
        this.kAO = this.mRootView.findViewById(R.id.pb_count_down_container);
        this.kAQ = (VoteCountDownView) this.mRootView.findViewById(R.id.pb_vote_count_down_view);
        this.kAR = this.mRootView.findViewById(R.id.pb_vote_rule);
        this.kAS = (TextView) this.mRootView.findViewById(R.id.pb_vote_rule_title);
        this.kAT = (SelectRuleView) this.mRootView.findViewById(R.id.pb_vote_rule_content);
        this.kAU = (TextView) this.mRootView.findViewById(R.id.pb_jump_to_vote_page);
        if (this.gPh != null) {
            if (this.mPageContext.getPageActivity() instanceof BaseActivity) {
                this.gPh.setTag(((BaseActivity) this.mPageContext.getPageActivity()).getUniqueId());
            } else if (this.mPageContext.getPageActivity() instanceof BaseFragmentActivity) {
                this.gPh.setTag(((BaseFragmentActivity) this.mPageContext.getPageActivity()).getUniqueId());
            }
            MessageManager.getInstance().registerListener(this.gPh);
        }
        setData(fVar);
        return this.mRootView;
    }

    public void setData(com.baidu.tieba.pb.data.f fVar) {
        if (this.mRootView != null) {
            if (fVar == null || fVar.kho == null) {
                this.mRootView.setVisibility(8);
                return;
            }
            this.kkM = fVar;
            this.kAI = fVar.kho;
            if (this.kAI.getStatus() != 0) {
                this.status = this.kAI.getStatus();
                if (this.status == 2) {
                    this.kAK.setVisibility(8);
                    this.kAO.setVisibility(0);
                    this.kAQ.setOnCountDownFinished(this.kAV);
                    this.kAQ.setData(this.kAI.cLh() * 1000);
                    this.kAU.setVisibility(8);
                } else if (this.status == 3) {
                    this.kAK.setVisibility(0);
                    this.kAM.setOnClickListener(this.eve);
                    this.kAO.setVisibility(8);
                    this.kAU.setVisibility(0);
                    this.kAU.setOnClickListener(this.eve);
                    this.kAL.setText(this.kAI.cLi() + "票");
                } else if (this.status == 4 || this.status == 5) {
                    this.kAK.setVisibility(0);
                    this.kAM.setEnabled(false);
                    this.kAO.setVisibility(8);
                    this.kAU.setVisibility(0);
                    this.kAU.setOnClickListener(this.eve);
                    this.kAL.setText(this.kAI.cLi() + "票");
                } else if (this.status == 6) {
                    this.kAK.setVisibility(0);
                    this.kAM.setEnabled(false);
                    this.kAO.setVisibility(8);
                    this.kAL.setText(this.kAI.cLi() + "票");
                    this.kAU.setVisibility(8);
                } else {
                    this.mRootView.setVisibility(8);
                    return;
                }
                if (!x.isEmpty(this.kAI.cLj()) || !x.isEmpty(this.kAI.cLk())) {
                    this.kAT.setColumn(2);
                    this.kAT.setData(this.kAI.cLj(), this.kAI.cLk());
                }
                qZ(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public void qZ(int i) {
        ao.setViewTextColor(this.kAL, R.color.cp_link_tip_c, 1, i);
        ao.setViewTextColor(this.kAJ, R.color.cp_cont_d, 1, i);
        ao.setViewTextColor(this.kAN, R.color.cp_cont_d, 1, i);
        ao.setViewTextColor(this.kAS, R.color.cp_cont_b, 1, i);
        ao.setViewTextColor(this.kAU, R.color.cp_link_tip_c, 1, i);
        ao.setViewTextColor(this.kAP, R.color.cp_cont_b, 1, i);
        if (this.kAM != null) {
            this.kAM.bci();
        }
        ao.setBackgroundColor(this.kAR, R.color.cp_bg_line_g, i);
        if (this.kAQ != null) {
            this.kAQ.qZ(i);
        }
        if (this.kAT != null) {
            this.kAT.oA(i);
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public PostData I(com.baidu.tieba.pb.data.f fVar) {
        PostData postData;
        if (fVar == null) {
            return null;
        }
        if (fVar.cKK() != null) {
            return fVar.cKK();
        }
        if (!x.isEmpty(fVar.cKz())) {
            Iterator<PostData> it = fVar.cKz().iterator();
            while (it.hasNext()) {
                postData = it.next();
                if (postData != null && postData.dlh() == 1) {
                    break;
                }
            }
        }
        postData = null;
        if (postData == null) {
            postData = fVar.cKG();
        }
        if (postData == null) {
            postData = a(fVar);
        }
        if (postData != null && postData.aWl() != null && postData.aWl().getUserTbVipInfoData() != null && postData.aWl().getUserTbVipInfoData().getvipIntro() != null) {
            postData.aWl().getGodUserData().setIntro(postData.aWl().getUserTbVipInfoData().getvipIntro());
            return postData;
        }
        return postData;
    }

    private PostData a(com.baidu.tieba.pb.data.f fVar) {
        MetaData metaData;
        if (fVar == null || fVar.cKx() == null || fVar.cKx().aWl() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData aWl = fVar.cKx().aWl();
        String userId = aWl.getUserId();
        HashMap<String, MetaData> userMap = fVar.cKx().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = aWl;
        }
        postData.Fs(1);
        postData.setId(fVar.cKx().aWC());
        postData.setTitle(fVar.cKx().getTitle());
        postData.setTime(fVar.cKx().getCreateTime());
        postData.a(metaData);
        return postData;
    }
}
