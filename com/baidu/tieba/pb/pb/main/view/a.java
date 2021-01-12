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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.bg;
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
/* loaded from: classes2.dex */
public class a {
    private f lFd;
    private k lVH;
    private TextView lVI;
    private View lVJ;
    private TextView lVK;
    private TBSpecificationBtn lVL;
    private TextView lVM;
    private View lVN;
    private TextView lVO;
    private VoteCountDownView lVP;
    private View lVQ;
    private TextView lVR;
    private SelectRuleView lVS;
    private TextView lVT;
    private TbPageContext mPageContext;
    private View mRootView;
    private int status;
    private VoteCountDownView.a lVU = new VoteCountDownView.a() { // from class: com.baidu.tieba.pb.pb.main.view.a.1
        @Override // com.baidu.tieba.view.VoteCountDownView.a
        public void chA() {
            if (a.this.mRootView != null) {
                if (a.this.lFd == null || a.this.lFd.lBn == null) {
                    a.this.mRootView.setVisibility(8);
                    return;
                }
                a.this.lFd.lBn.setStatus(3);
                a.this.setData(a.this.lFd);
            }
        }
    };
    private View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.pb_jump_to_vote_page) {
                if (a.this.lFd != null && a.this.mPageContext != null && bg.checkUpIsLogin(a.this.mPageContext.getPageActivity())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921408, new BarVoteActivityConfig(a.this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(a.this.lFd.getForumId(), 0L), 3)));
                }
            } else if (view.getId() == R.id.pb_vote_button && bg.checkUpIsLogin(a.this.mPageContext.getPageActivity()) && a.this.lFd != null && a.this.lVH != null && a.this.lFd.diN() != null) {
                if (a.this.lVH.cqb()) {
                    new aq("c13444").dW("forum_id", a.this.lFd.getForumId()).bsu();
                    d dVar = new d();
                    dVar.setThreadId(com.baidu.adp.lib.f.b.toLong(a.this.lFd.getThreadId(), 0L));
                    dVar.setForumId(com.baidu.adp.lib.f.b.toLong(a.this.lFd.getForumId(), 0L));
                    String str = "";
                    PostData L = a.this.L(a.this.lFd);
                    if (L != null && L.bnx() != null) {
                        str = L.bnx().getUserId();
                    }
                    dVar.hm(com.baidu.adp.lib.f.b.toLong(str, 0L));
                    dVar.EX(2);
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
    private HttpMessageListener ijB = new HttpMessageListener(CmdConfigHttp.CMD_BAR_VOTE) { // from class: com.baidu.tieba.pb.pb.main.view.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            String errorString;
            if (httpResponsedMessage != null && httpResponsedMessage.getOrginalMessage() != null) {
                int error = httpResponsedMessage.getError();
                if ((httpResponsedMessage instanceof CommitVoteResMsg) && a.this.lFd != null && a.this.lFd.lBn != null && a.this.mPageContext != null && httpResponsedMessage.getOrginalMessage().getTag() == a.this.mPageContext.getUniqueId()) {
                    if (error == 0) {
                        l.showToast(TbadkCoreApplication.getInst(), R.string.bar_manager_vote_success);
                        a.this.lFd.lBn.Fc(a.this.lFd.lBn.djA() + 1);
                        a.this.lFd.lBn.pg(false);
                        a.this.setData(a.this.lFd);
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

    public View K(com.baidu.tieba.pb.data.f fVar) {
        if (this.mPageContext == null) {
            return null;
        }
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.bar_manager_select_view, (ViewGroup) null);
        this.lVI = (TextView) this.mRootView.findViewById(R.id.pb_bar_manager_select_warn);
        this.lVJ = this.mRootView.findViewById(R.id.pb_vote_button_container);
        this.lVO = (TextView) this.mRootView.findViewById(R.id.pb_count_down_title);
        this.lVL = (TBSpecificationBtn) this.mRootView.findViewById(R.id.pb_vote_button);
        com.baidu.tbadk.core.view.commonBtn.a aVar = new com.baidu.tbadk.core.view.commonBtn.a();
        aVar.a(GradientDrawable.Orientation.TL_BR);
        this.lVL.setText(TbadkCoreApplication.getInst().getString(R.string.pb_vote_text));
        this.lVL.setTextSize(R.dimen.tbfontsize44);
        this.lVL.setConfig(aVar);
        this.lVK = (TextView) this.mRootView.findViewById(R.id.pb_vote_num);
        this.lVM = (TextView) this.mRootView.findViewById(R.id.pb_bar_manager_ueg_tip);
        this.lVN = this.mRootView.findViewById(R.id.pb_count_down_container);
        this.lVP = (VoteCountDownView) this.mRootView.findViewById(R.id.pb_vote_count_down_view);
        this.lVQ = this.mRootView.findViewById(R.id.pb_vote_rule);
        this.lVR = (TextView) this.mRootView.findViewById(R.id.pb_vote_rule_title);
        this.lVS = (SelectRuleView) this.mRootView.findViewById(R.id.pb_vote_rule_content);
        this.lVT = (TextView) this.mRootView.findViewById(R.id.pb_jump_to_vote_page);
        if (this.ijB != null) {
            if (this.mPageContext.getPageActivity() instanceof BaseActivity) {
                this.ijB.setTag(((BaseActivity) this.mPageContext.getPageActivity()).getUniqueId());
            } else if (this.mPageContext.getPageActivity() instanceof BaseFragmentActivity) {
                this.ijB.setTag(((BaseFragmentActivity) this.mPageContext.getPageActivity()).getUniqueId());
            }
            MessageManager.getInstance().registerListener(this.ijB);
        }
        setData(fVar);
        return this.mRootView;
    }

    public void setData(com.baidu.tieba.pb.data.f fVar) {
        if (this.mRootView != null) {
            if (fVar == null || fVar.lBn == null) {
                this.mRootView.setVisibility(8);
                return;
            }
            this.lFd = fVar;
            this.lVH = fVar.lBn;
            if (this.lVH.getStatus() != 0) {
                this.status = this.lVH.getStatus();
                if (this.status == 2) {
                    this.lVJ.setVisibility(8);
                    this.lVN.setVisibility(0);
                    this.lVP.setOnCountDownFinished(this.lVU);
                    this.lVP.setData(this.lVH.djz() * 1000);
                    this.lVT.setVisibility(8);
                } else if (this.status == 3) {
                    this.lVJ.setVisibility(0);
                    this.lVL.setOnClickListener(this.onClickListener);
                    this.lVN.setVisibility(8);
                    this.lVT.setVisibility(0);
                    this.lVT.setOnClickListener(this.onClickListener);
                    this.lVK.setText(this.lVH.djA() + "票");
                } else if (this.status == 4 || this.status == 5) {
                    this.lVJ.setVisibility(0);
                    this.lVL.setEnabled(false);
                    this.lVN.setVisibility(8);
                    this.lVT.setVisibility(0);
                    this.lVT.setOnClickListener(this.onClickListener);
                    this.lVK.setText(this.lVH.djA() + "票");
                } else if (this.status == 6) {
                    this.lVJ.setVisibility(0);
                    this.lVL.setEnabled(false);
                    this.lVN.setVisibility(8);
                    this.lVK.setText(this.lVH.djA() + "票");
                    this.lVT.setVisibility(8);
                } else {
                    this.mRootView.setVisibility(8);
                    return;
                }
                if (!x.isEmpty(this.lVH.djB()) || !x.isEmpty(this.lVH.djC())) {
                    this.lVS.setColumn(2);
                    this.lVS.setData(this.lVH.djB(), this.lVH.djC());
                }
                uo(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public void uo(int i) {
        ao.setViewTextColor(this.lVK, R.color.CAM_X0304, 1, i);
        ao.setViewTextColor(this.lVI, R.color.CAM_X0109, 1, i);
        ao.setViewTextColor(this.lVM, R.color.CAM_X0109, 1, i);
        ao.setViewTextColor(this.lVR, R.color.CAM_X0105, 1, i);
        ao.setViewTextColor(this.lVT, R.color.CAM_X0304, 1, i);
        ao.setViewTextColor(this.lVO, R.color.CAM_X0105, 1, i);
        if (this.lVL != null) {
            this.lVL.btV();
        }
        ao.setBackgroundColor(this.lVQ, R.color.CAM_X0206, i);
        if (this.lVP != null) {
            this.lVP.uo(i);
        }
        if (this.lVS != null) {
            this.lVS.rC(i);
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
        if (fVar.dja() != null) {
            return fVar.dja();
        }
        if (!x.isEmpty(fVar.diP())) {
            Iterator<PostData> it = fVar.diP().iterator();
            while (it.hasNext()) {
                postData = it.next();
                if (postData != null && postData.dLm() == 1) {
                    break;
                }
            }
        }
        postData = null;
        if (postData == null) {
            postData = fVar.diW();
        }
        if (postData == null) {
            postData = a(fVar);
        }
        if (postData != null && postData.bnx() != null && postData.bnx().getUserTbVipInfoData() != null && postData.bnx().getUserTbVipInfoData().getvipIntro() != null) {
            postData.bnx().getGodUserData().setIntro(postData.bnx().getUserTbVipInfoData().getvipIntro());
            return postData;
        }
        return postData;
    }

    private PostData a(com.baidu.tieba.pb.data.f fVar) {
        MetaData metaData;
        if (fVar == null || fVar.diN() == null || fVar.diN().bnx() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData bnx = fVar.diN().bnx();
        String userId = bnx.getUserId();
        HashMap<String, MetaData> userMap = fVar.diN().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = bnx;
        }
        postData.Jk(1);
        postData.setId(fVar.diN().bnN());
        postData.setTitle(fVar.diN().getTitle());
        postData.setTime(fVar.diN().getCreateTime());
        postData.a(metaData);
        return postData;
    }
}
