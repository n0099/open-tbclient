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
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BarVoteActivityConfig;
import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.data.CommitVoteResMsg;
import com.baidu.tbadk.widget.SelectRuleView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.d;
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.pb.data.l;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.util.f;
import com.baidu.tieba.view.VoteCountDownView;
import java.util.HashMap;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class a {
    private f lNT;
    private TbPageContext mPageContext;
    private View mRootView;
    private l meM;
    private TextView meN;
    private View meO;
    private TextView meP;
    private TBSpecificationBtn meQ;
    private TextView meR;
    private View meS;
    private TextView meT;
    private VoteCountDownView meU;
    private View meV;
    private TextView meW;
    private SelectRuleView meX;
    private TextView meY;
    private int status;
    private VoteCountDownView.a meZ = new VoteCountDownView.a() { // from class: com.baidu.tieba.pb.pb.main.view.a.1
        @Override // com.baidu.tieba.view.VoteCountDownView.a
        public void cit() {
            if (a.this.mRootView != null) {
                if (a.this.lNT == null || a.this.lNT.lKa == null) {
                    a.this.mRootView.setVisibility(8);
                    return;
                }
                a.this.lNT.lKa.setStatus(3);
                a.this.setData(a.this.lNT);
            }
        }
    };
    private View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.pb_jump_to_vote_page) {
                if (a.this.lNT != null && a.this.mPageContext != null && bh.checkUpIsLogin(a.this.mPageContext.getPageActivity())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921408, new BarVoteActivityConfig(a.this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(a.this.lNT.getForumId(), 0L), 3)));
                }
            } else if (view.getId() == R.id.pb_vote_button && bh.checkUpIsLogin(a.this.mPageContext.getPageActivity()) && a.this.lNT != null && a.this.meM != null && a.this.lNT.dkZ() != null) {
                if (a.this.meM.crl()) {
                    new ar("c13444").dR("forum_id", a.this.lNT.getForumId()).bsO();
                    d dVar = new d();
                    dVar.setThreadId(com.baidu.adp.lib.f.b.toLong(a.this.lNT.getThreadId(), 0L));
                    dVar.setForumId(com.baidu.adp.lib.f.b.toLong(a.this.lNT.getForumId(), 0L));
                    String str = "";
                    PostData L = a.this.L(a.this.lNT);
                    if (L != null && L.bnQ() != null) {
                        str = L.bnQ().getUserId();
                    }
                    dVar.hr(com.baidu.adp.lib.f.b.toLong(str, 0L));
                    dVar.Fq(2);
                    dVar.u(a.this.mPageContext.getUniqueId());
                    CustomMessage customMessage = new CustomMessage(2921411);
                    customMessage.setData(dVar);
                    MessageManager.getInstance().sendMessage(customMessage);
                    return;
                }
                com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), R.string.has_not_other_ticket);
            }
        }
    };
    private HttpMessageListener ipj = new HttpMessageListener(CmdConfigHttp.CMD_BAR_VOTE) { // from class: com.baidu.tieba.pb.pb.main.view.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            String errorString;
            if (httpResponsedMessage != null && httpResponsedMessage.getOrginalMessage() != null) {
                int error = httpResponsedMessage.getError();
                if ((httpResponsedMessage instanceof CommitVoteResMsg) && a.this.lNT != null && a.this.lNT.lKa != null && a.this.mPageContext != null && httpResponsedMessage.getOrginalMessage().getTag() == a.this.mPageContext.getUniqueId()) {
                    if (error == 0) {
                        com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), R.string.bar_manager_vote_success);
                        a.this.lNT.lKa.Fv(a.this.lNT.lKa.dlM() + 1);
                        a.this.lNT.lKa.pq(false);
                        a.this.setData(a.this.lNT);
                    } else if (error == 3250023) {
                        com.baidu.tieba.tbadkCore.util.f.a(error, "", (f.a) null);
                    } else if (error == 3250021) {
                        com.baidu.tieba.tbadkCore.util.f.a(error, ((CommitVoteResMsg) httpResponsedMessage).getTokenData(), (f.a) null);
                    } else if (error == 3250002 || error == 3250004) {
                        BlockPopInfoData blockPopInfoData = new BlockPopInfoData();
                        if (au.isEmpty(httpResponsedMessage.getErrorString())) {
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
                        com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), httpResponsedMessage.getErrorString());
                    }
                }
            }
        }
    };

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public View K(com.baidu.tieba.pb.data.f fVar) {
        if (this.mPageContext == null) {
            return null;
        }
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.bar_manager_select_view, (ViewGroup) null);
        this.meN = (TextView) this.mRootView.findViewById(R.id.pb_bar_manager_select_warn);
        this.meO = this.mRootView.findViewById(R.id.pb_vote_button_container);
        this.meT = (TextView) this.mRootView.findViewById(R.id.pb_count_down_title);
        this.meQ = (TBSpecificationBtn) this.mRootView.findViewById(R.id.pb_vote_button);
        com.baidu.tbadk.core.view.commonBtn.a aVar = new com.baidu.tbadk.core.view.commonBtn.a();
        aVar.a(GradientDrawable.Orientation.TL_BR);
        this.meQ.setText(TbadkCoreApplication.getInst().getString(R.string.pb_vote_text));
        this.meQ.setTextSize(R.dimen.tbfontsize44);
        this.meQ.setConfig(aVar);
        this.meP = (TextView) this.mRootView.findViewById(R.id.pb_vote_num);
        this.meR = (TextView) this.mRootView.findViewById(R.id.pb_bar_manager_ueg_tip);
        this.meS = this.mRootView.findViewById(R.id.pb_count_down_container);
        this.meU = (VoteCountDownView) this.mRootView.findViewById(R.id.pb_vote_count_down_view);
        this.meV = this.mRootView.findViewById(R.id.pb_vote_rule);
        this.meW = (TextView) this.mRootView.findViewById(R.id.pb_vote_rule_title);
        this.meX = (SelectRuleView) this.mRootView.findViewById(R.id.pb_vote_rule_content);
        this.meY = (TextView) this.mRootView.findViewById(R.id.pb_jump_to_vote_page);
        if (this.ipj != null) {
            if (this.mPageContext.getPageActivity() instanceof BaseActivity) {
                this.ipj.setTag(((BaseActivity) this.mPageContext.getPageActivity()).getUniqueId());
            } else if (this.mPageContext.getPageActivity() instanceof BaseFragmentActivity) {
                this.ipj.setTag(((BaseFragmentActivity) this.mPageContext.getPageActivity()).getUniqueId());
            }
            MessageManager.getInstance().registerListener(this.ipj);
        }
        setData(fVar);
        return this.mRootView;
    }

    public void setData(com.baidu.tieba.pb.data.f fVar) {
        if (this.mRootView != null) {
            if (fVar == null || fVar.lKa == null) {
                this.mRootView.setVisibility(8);
                return;
            }
            this.lNT = fVar;
            this.meM = fVar.lKa;
            if (this.meM.getStatus() != 0) {
                this.status = this.meM.getStatus();
                if (this.status == 2) {
                    this.meO.setVisibility(8);
                    this.meS.setVisibility(0);
                    this.meU.setOnCountDownFinished(this.meZ);
                    this.meU.setData(this.meM.dlL() * 1000);
                    this.meY.setVisibility(8);
                } else if (this.status == 3) {
                    this.meO.setVisibility(0);
                    this.meQ.setOnClickListener(this.onClickListener);
                    this.meS.setVisibility(8);
                    this.meY.setVisibility(0);
                    this.meY.setOnClickListener(this.onClickListener);
                    this.meP.setText(this.meM.dlM() + "票");
                } else if (this.status == 4 || this.status == 5) {
                    this.meO.setVisibility(0);
                    this.meQ.setEnabled(false);
                    this.meS.setVisibility(8);
                    this.meY.setVisibility(0);
                    this.meY.setOnClickListener(this.onClickListener);
                    this.meP.setText(this.meM.dlM() + "票");
                } else if (this.status == 6) {
                    this.meO.setVisibility(0);
                    this.meQ.setEnabled(false);
                    this.meS.setVisibility(8);
                    this.meP.setText(this.meM.dlM() + "票");
                    this.meY.setVisibility(8);
                } else {
                    this.mRootView.setVisibility(8);
                    return;
                }
                if (!y.isEmpty(this.meM.dlN()) || !y.isEmpty(this.meM.dlO())) {
                    this.meX.setColumn(2);
                    this.meX.setData(this.meM.dlN(), this.meM.dlO());
                }
                uu(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public void uu(int i) {
        ap.setViewTextColor(this.meP, R.color.CAM_X0304, 1, i);
        ap.setViewTextColor(this.meN, R.color.CAM_X0109, 1, i);
        ap.setViewTextColor(this.meR, R.color.CAM_X0109, 1, i);
        ap.setViewTextColor(this.meW, R.color.CAM_X0105, 1, i);
        ap.setViewTextColor(this.meY, R.color.CAM_X0304, 1, i);
        ap.setViewTextColor(this.meT, R.color.CAM_X0105, 1, i);
        if (this.meQ != null) {
            this.meQ.bup();
        }
        ap.setBackgroundColor(this.meV, R.color.CAM_X0206, i);
        if (this.meU != null) {
            this.meU.uu(i);
        }
        if (this.meX != null) {
            this.meX.rH(i);
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public PostData L(com.baidu.tieba.pb.data.f fVar) {
        PostData postData;
        if (fVar == null) {
            return null;
        }
        if (fVar.dlm() != null) {
            return fVar.dlm();
        }
        if (!y.isEmpty(fVar.dlb())) {
            Iterator<PostData> it = fVar.dlb().iterator();
            while (it.hasNext()) {
                postData = it.next();
                if (postData != null && postData.dNx() == 1) {
                    break;
                }
            }
        }
        postData = null;
        if (postData == null) {
            postData = fVar.dli();
        }
        if (postData == null) {
            postData = a(fVar);
        }
        if (postData != null && postData.bnQ() != null && postData.bnQ().getUserTbVipInfoData() != null && postData.bnQ().getUserTbVipInfoData().getvipIntro() != null) {
            postData.bnQ().getGodUserData().setIntro(postData.bnQ().getUserTbVipInfoData().getvipIntro());
            return postData;
        }
        return postData;
    }

    private PostData a(com.baidu.tieba.pb.data.f fVar) {
        MetaData metaData;
        if (fVar == null || fVar.dkZ() == null || fVar.dkZ().bnQ() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData bnQ = fVar.dkZ().bnQ();
        String userId = bnQ.getUserId();
        HashMap<String, MetaData> userMap = fVar.dkZ().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = bnQ;
        }
        postData.JE(1);
        postData.setId(fVar.dkZ().bog());
        postData.setTitle(fVar.dkZ().getTitle());
        postData.setTime(fVar.dkZ().getCreateTime());
        postData.a(metaData);
        return postData;
    }
}
