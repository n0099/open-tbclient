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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.util.y;
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
/* loaded from: classes22.dex */
public class a {
    private k lAP;
    private TextView lAQ;
    private View lAR;
    private TextView lAS;
    private TBSpecificationBtn lAT;
    private TextView lAU;
    private View lAV;
    private TextView lAW;
    private VoteCountDownView lAX;
    private View lAY;
    private TextView lAZ;
    private SelectRuleView lBa;
    private TextView lBb;
    private f lku;
    private TbPageContext mPageContext;
    private View mRootView;
    private int status;
    private VoteCountDownView.a lBc = new VoteCountDownView.a() { // from class: com.baidu.tieba.pb.pb.main.view.a.1
        @Override // com.baidu.tieba.view.VoteCountDownView.a
        public void ada() {
            if (a.this.mRootView != null) {
                if (a.this.lku == null || a.this.lku.lgZ == null) {
                    a.this.mRootView.setVisibility(8);
                    return;
                }
                a.this.lku.lgZ.setStatus(3);
                a.this.setData(a.this.lku);
            }
        }
    };
    private View.OnClickListener fcr = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.pb_jump_to_vote_page) {
                if (a.this.lku != null && a.this.mPageContext != null && bg.checkUpIsLogin(a.this.mPageContext.getPageActivity())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921408, new BarVoteActivityConfig(a.this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(a.this.lku.getForumId(), 0L), 3)));
                }
            } else if (view.getId() == R.id.pb_vote_button && bg.checkUpIsLogin(a.this.mPageContext.getPageActivity()) && a.this.lku != null && a.this.lAP != null && a.this.lku.dfI() != null) {
                if (a.this.lAP.ckH()) {
                    new aq("c13444").dR("forum_id", a.this.lku.getForumId()).boK();
                    d dVar = new d();
                    dVar.setThreadId(com.baidu.adp.lib.f.b.toLong(a.this.lku.getThreadId(), 0L));
                    dVar.setForumId(com.baidu.adp.lib.f.b.toLong(a.this.lku.getForumId(), 0L));
                    String str = "";
                    PostData I = a.this.I(a.this.lku);
                    if (I != null && I.bka() != null) {
                        str = I.bka().getUserId();
                    }
                    dVar.gn(com.baidu.adp.lib.f.b.toLong(str, 0L));
                    dVar.Fl(2);
                    dVar.t(a.this.mPageContext.getUniqueId());
                    CustomMessage customMessage = new CustomMessage(2921411);
                    customMessage.setData(dVar);
                    MessageManager.getInstance().sendMessage(customMessage);
                    return;
                }
                l.showToast(TbadkCoreApplication.getInst(), R.string.has_not_other_ticket);
            }
        }
    };
    private HttpMessageListener hKr = new HttpMessageListener(CmdConfigHttp.CMD_BAR_VOTE) { // from class: com.baidu.tieba.pb.pb.main.view.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            String errorString;
            if (httpResponsedMessage != null && httpResponsedMessage.getOrginalMessage() != null) {
                int error = httpResponsedMessage.getError();
                if ((httpResponsedMessage instanceof CommitVoteResMsg) && a.this.lku != null && a.this.lku.lgZ != null && a.this.mPageContext != null && httpResponsedMessage.getOrginalMessage().getTag() == a.this.mPageContext.getUniqueId()) {
                    if (error == 0) {
                        l.showToast(TbadkCoreApplication.getInst(), R.string.bar_manager_vote_success);
                        a.this.lku.lgZ.Fq(a.this.lku.lgZ.dgt() + 1);
                        a.this.lku.lgZ.oe(false);
                        a.this.setData(a.this.lku);
                    } else if (error == 3250023) {
                        com.baidu.tieba.tbadkCore.util.f.a(error, "", (f.a) null);
                    } else if (error == 3250021) {
                        com.baidu.tieba.tbadkCore.util.f.a(error, ((CommitVoteResMsg) httpResponsedMessage).getTokenData(), (f.a) null);
                    } else if (error == 3250002 || error == 3250004) {
                        BlockPopInfoData blockPopInfoData = new BlockPopInfoData();
                        if (at.isEmpty(httpResponsedMessage.getErrorString())) {
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
        this.lAQ = (TextView) this.mRootView.findViewById(R.id.pb_bar_manager_select_warn);
        this.lAR = this.mRootView.findViewById(R.id.pb_vote_button_container);
        this.lAW = (TextView) this.mRootView.findViewById(R.id.pb_count_down_title);
        this.lAT = (TBSpecificationBtn) this.mRootView.findViewById(R.id.pb_vote_button);
        com.baidu.tbadk.core.view.commonBtn.a aVar = new com.baidu.tbadk.core.view.commonBtn.a();
        aVar.a(GradientDrawable.Orientation.TL_BR);
        this.lAT.setText(TbadkCoreApplication.getInst().getString(R.string.pb_vote_text));
        this.lAT.setTextSize(R.dimen.tbfontsize44);
        this.lAT.setConfig(aVar);
        this.lAS = (TextView) this.mRootView.findViewById(R.id.pb_vote_num);
        this.lAU = (TextView) this.mRootView.findViewById(R.id.pb_bar_manager_ueg_tip);
        this.lAV = this.mRootView.findViewById(R.id.pb_count_down_container);
        this.lAX = (VoteCountDownView) this.mRootView.findViewById(R.id.pb_vote_count_down_view);
        this.lAY = this.mRootView.findViewById(R.id.pb_vote_rule);
        this.lAZ = (TextView) this.mRootView.findViewById(R.id.pb_vote_rule_title);
        this.lBa = (SelectRuleView) this.mRootView.findViewById(R.id.pb_vote_rule_content);
        this.lBb = (TextView) this.mRootView.findViewById(R.id.pb_jump_to_vote_page);
        if (this.hKr != null) {
            if (this.mPageContext.getPageActivity() instanceof BaseActivity) {
                this.hKr.setTag(((BaseActivity) this.mPageContext.getPageActivity()).getUniqueId());
            } else if (this.mPageContext.getPageActivity() instanceof BaseFragmentActivity) {
                this.hKr.setTag(((BaseFragmentActivity) this.mPageContext.getPageActivity()).getUniqueId());
            }
            MessageManager.getInstance().registerListener(this.hKr);
        }
        setData(fVar);
        return this.mRootView;
    }

    public void setData(com.baidu.tieba.pb.data.f fVar) {
        if (this.mRootView != null) {
            if (fVar == null || fVar.lgZ == null) {
                this.mRootView.setVisibility(8);
                return;
            }
            this.lku = fVar;
            this.lAP = fVar.lgZ;
            if (this.lAP.getStatus() != 0) {
                this.status = this.lAP.getStatus();
                if (this.status == 2) {
                    this.lAR.setVisibility(8);
                    this.lAV.setVisibility(0);
                    this.lAX.setOnCountDownFinished(this.lBc);
                    this.lAX.setData(this.lAP.dgs() * 1000);
                    this.lBb.setVisibility(8);
                } else if (this.status == 3) {
                    this.lAR.setVisibility(0);
                    this.lAT.setOnClickListener(this.fcr);
                    this.lAV.setVisibility(8);
                    this.lBb.setVisibility(0);
                    this.lBb.setOnClickListener(this.fcr);
                    this.lAS.setText(this.lAP.dgt() + "票");
                } else if (this.status == 4 || this.status == 5) {
                    this.lAR.setVisibility(0);
                    this.lAT.setEnabled(false);
                    this.lAV.setVisibility(8);
                    this.lBb.setVisibility(0);
                    this.lBb.setOnClickListener(this.fcr);
                    this.lAS.setText(this.lAP.dgt() + "票");
                } else if (this.status == 6) {
                    this.lAR.setVisibility(0);
                    this.lAT.setEnabled(false);
                    this.lAV.setVisibility(8);
                    this.lAS.setText(this.lAP.dgt() + "票");
                    this.lBb.setVisibility(8);
                } else {
                    this.mRootView.setVisibility(8);
                    return;
                }
                if (!y.isEmpty(this.lAP.dgu()) || !y.isEmpty(this.lAP.dgv())) {
                    this.lBa.setColumn(2);
                    this.lBa.setData(this.lAP.dgu(), this.lAP.dgv());
                }
                uu(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public void uu(int i) {
        ap.setViewTextColor(this.lAS, R.color.cp_link_tip_c, 1, i);
        ap.setViewTextColor(this.lAQ, R.color.cp_cont_d, 1, i);
        ap.setViewTextColor(this.lAU, R.color.cp_cont_d, 1, i);
        ap.setViewTextColor(this.lAZ, R.color.cp_cont_b, 1, i);
        ap.setViewTextColor(this.lBb, R.color.cp_link_tip_c, 1, i);
        ap.setViewTextColor(this.lAW, R.color.cp_cont_b, 1, i);
        if (this.lAT != null) {
            this.lAT.bqd();
        }
        ap.setBackgroundColor(this.lAY, R.color.cp_bg_line_g, i);
        if (this.lAX != null) {
            this.lAX.uu(i);
        }
        if (this.lBa != null) {
            this.lBa.rM(i);
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
        if (fVar.dfV() != null) {
            return fVar.dfV();
        }
        if (!y.isEmpty(fVar.dfK())) {
            Iterator<PostData> it = fVar.dfK().iterator();
            while (it.hasNext()) {
                postData = it.next();
                if (postData != null && postData.dHx() == 1) {
                    break;
                }
            }
        }
        postData = null;
        if (postData == null) {
            postData = fVar.dfR();
        }
        if (postData == null) {
            postData = a(fVar);
        }
        if (postData != null && postData.bka() != null && postData.bka().getUserTbVipInfoData() != null && postData.bka().getUserTbVipInfoData().getvipIntro() != null) {
            postData.bka().getGodUserData().setIntro(postData.bka().getUserTbVipInfoData().getvipIntro());
            return postData;
        }
        return postData;
    }

    private PostData a(com.baidu.tieba.pb.data.f fVar) {
        MetaData metaData;
        if (fVar == null || fVar.dfI() == null || fVar.dfI().bka() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData bka = fVar.dfI().bka();
        String userId = bka.getUserId();
        HashMap<String, MetaData> userMap = fVar.dfI().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = bka;
        }
        postData.Jq(1);
        postData.setId(fVar.dfI().bkr());
        postData.setTitle(fVar.dfI().getTitle());
        postData.setTime(fVar.dfI().getCreateTime());
        postData.a(metaData);
        return postData;
    }
}
