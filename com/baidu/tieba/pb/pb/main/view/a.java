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
import com.baidu.tieba.pb.data.k;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.util.f;
import com.baidu.tieba.view.VoteCountDownView;
import java.util.HashMap;
import java.util.Iterator;
/* loaded from: classes22.dex */
public class a {
    private f lEv;
    private k lVa;
    private TextView lVb;
    private View lVc;
    private TextView lVd;
    private TBSpecificationBtn lVe;
    private TextView lVf;
    private View lVg;
    private TextView lVh;
    private VoteCountDownView lVi;
    private View lVj;
    private TextView lVk;
    private SelectRuleView lVl;
    private TextView lVm;
    private TbPageContext mPageContext;
    private View mRootView;
    private int status;
    private VoteCountDownView.a lVn = new VoteCountDownView.a() { // from class: com.baidu.tieba.pb.pb.main.view.a.1
        @Override // com.baidu.tieba.view.VoteCountDownView.a
        public void aia() {
            if (a.this.mRootView != null) {
                if (a.this.lEv == null || a.this.lEv.lAN == null) {
                    a.this.mRootView.setVisibility(8);
                    return;
                }
                a.this.lEv.lAN.setStatus(3);
                a.this.setData(a.this.lEv);
            }
        }
    };
    private View.OnClickListener foP = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.pb_jump_to_vote_page) {
                if (a.this.lEv != null && a.this.mPageContext != null && bh.checkUpIsLogin(a.this.mPageContext.getPageActivity())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921408, new BarVoteActivityConfig(a.this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(a.this.lEv.getForumId(), 0L), 3)));
                }
            } else if (view.getId() == R.id.pb_vote_button && bh.checkUpIsLogin(a.this.mPageContext.getPageActivity()) && a.this.lEv != null && a.this.lVa != null && a.this.lEv.dmU() != null) {
                if (a.this.lVa.cqZ()) {
                    new ar("c13444").dY("forum_id", a.this.lEv.getForumId()).btT();
                    d dVar = new d();
                    dVar.setThreadId(com.baidu.adp.lib.f.b.toLong(a.this.lEv.getThreadId(), 0L));
                    dVar.setForumId(com.baidu.adp.lib.f.b.toLong(a.this.lEv.getForumId(), 0L));
                    String str = "";
                    PostData L = a.this.L(a.this.lEv);
                    if (L != null && L.boP() != null) {
                        str = L.boP().getUserId();
                    }
                    dVar.hr(com.baidu.adp.lib.f.b.toLong(str, 0L));
                    dVar.GL(2);
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
    private HttpMessageListener ibK = new HttpMessageListener(CmdConfigHttp.CMD_BAR_VOTE) { // from class: com.baidu.tieba.pb.pb.main.view.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            String errorString;
            if (httpResponsedMessage != null && httpResponsedMessage.getOrginalMessage() != null) {
                int error = httpResponsedMessage.getError();
                if ((httpResponsedMessage instanceof CommitVoteResMsg) && a.this.lEv != null && a.this.lEv.lAN != null && a.this.mPageContext != null && httpResponsedMessage.getOrginalMessage().getTag() == a.this.mPageContext.getUniqueId()) {
                    if (error == 0) {
                        l.showToast(TbadkCoreApplication.getInst(), R.string.bar_manager_vote_success);
                        a.this.lEv.lAN.GQ(a.this.lEv.lAN.dnI() + 1);
                        a.this.lEv.lAN.oL(false);
                        a.this.setData(a.this.lEv);
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
        this.lVb = (TextView) this.mRootView.findViewById(R.id.pb_bar_manager_select_warn);
        this.lVc = this.mRootView.findViewById(R.id.pb_vote_button_container);
        this.lVh = (TextView) this.mRootView.findViewById(R.id.pb_count_down_title);
        this.lVe = (TBSpecificationBtn) this.mRootView.findViewById(R.id.pb_vote_button);
        com.baidu.tbadk.core.view.commonBtn.a aVar = new com.baidu.tbadk.core.view.commonBtn.a();
        aVar.a(GradientDrawable.Orientation.TL_BR);
        this.lVe.setText(TbadkCoreApplication.getInst().getString(R.string.pb_vote_text));
        this.lVe.setTextSize(R.dimen.tbfontsize44);
        this.lVe.setConfig(aVar);
        this.lVd = (TextView) this.mRootView.findViewById(R.id.pb_vote_num);
        this.lVf = (TextView) this.mRootView.findViewById(R.id.pb_bar_manager_ueg_tip);
        this.lVg = this.mRootView.findViewById(R.id.pb_count_down_container);
        this.lVi = (VoteCountDownView) this.mRootView.findViewById(R.id.pb_vote_count_down_view);
        this.lVj = this.mRootView.findViewById(R.id.pb_vote_rule);
        this.lVk = (TextView) this.mRootView.findViewById(R.id.pb_vote_rule_title);
        this.lVl = (SelectRuleView) this.mRootView.findViewById(R.id.pb_vote_rule_content);
        this.lVm = (TextView) this.mRootView.findViewById(R.id.pb_jump_to_vote_page);
        if (this.ibK != null) {
            if (this.mPageContext.getPageActivity() instanceof BaseActivity) {
                this.ibK.setTag(((BaseActivity) this.mPageContext.getPageActivity()).getUniqueId());
            } else if (this.mPageContext.getPageActivity() instanceof BaseFragmentActivity) {
                this.ibK.setTag(((BaseFragmentActivity) this.mPageContext.getPageActivity()).getUniqueId());
            }
            MessageManager.getInstance().registerListener(this.ibK);
        }
        setData(fVar);
        return this.mRootView;
    }

    public void setData(com.baidu.tieba.pb.data.f fVar) {
        if (this.mRootView != null) {
            if (fVar == null || fVar.lAN == null) {
                this.mRootView.setVisibility(8);
                return;
            }
            this.lEv = fVar;
            this.lVa = fVar.lAN;
            if (this.lVa.getStatus() != 0) {
                this.status = this.lVa.getStatus();
                if (this.status == 2) {
                    this.lVc.setVisibility(8);
                    this.lVg.setVisibility(0);
                    this.lVi.setOnCountDownFinished(this.lVn);
                    this.lVi.setData(this.lVa.dnH() * 1000);
                    this.lVm.setVisibility(8);
                } else if (this.status == 3) {
                    this.lVc.setVisibility(0);
                    this.lVe.setOnClickListener(this.foP);
                    this.lVg.setVisibility(8);
                    this.lVm.setVisibility(0);
                    this.lVm.setOnClickListener(this.foP);
                    this.lVd.setText(this.lVa.dnI() + "票");
                } else if (this.status == 4 || this.status == 5) {
                    this.lVc.setVisibility(0);
                    this.lVe.setEnabled(false);
                    this.lVg.setVisibility(8);
                    this.lVm.setVisibility(0);
                    this.lVm.setOnClickListener(this.foP);
                    this.lVd.setText(this.lVa.dnI() + "票");
                } else if (this.status == 6) {
                    this.lVc.setVisibility(0);
                    this.lVe.setEnabled(false);
                    this.lVg.setVisibility(8);
                    this.lVd.setText(this.lVa.dnI() + "票");
                    this.lVm.setVisibility(8);
                } else {
                    this.mRootView.setVisibility(8);
                    return;
                }
                if (!y.isEmpty(this.lVa.dnJ()) || !y.isEmpty(this.lVa.dnK())) {
                    this.lVl.setColumn(2);
                    this.lVl.setData(this.lVa.dnJ(), this.lVa.dnK());
                }
                vJ(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public void vJ(int i) {
        ap.setViewTextColor(this.lVd, R.color.CAM_X0304, 1, i);
        ap.setViewTextColor(this.lVb, R.color.CAM_X0109, 1, i);
        ap.setViewTextColor(this.lVf, R.color.CAM_X0109, 1, i);
        ap.setViewTextColor(this.lVk, R.color.CAM_X0105, 1, i);
        ap.setViewTextColor(this.lVm, R.color.CAM_X0304, 1, i);
        ap.setViewTextColor(this.lVh, R.color.CAM_X0105, 1, i);
        if (this.lVe != null) {
            this.lVe.bvt();
        }
        ap.setBackgroundColor(this.lVj, R.color.CAM_X0206, i);
        if (this.lVi != null) {
            this.lVi.vJ(i);
        }
        if (this.lVl != null) {
            this.lVl.sX(i);
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
        if (fVar.dnh() != null) {
            return fVar.dnh();
        }
        if (!y.isEmpty(fVar.dmW())) {
            Iterator<PostData> it = fVar.dmW().iterator();
            while (it.hasNext()) {
                postData = it.next();
                if (postData != null && postData.dPh() == 1) {
                    break;
                }
            }
        }
        postData = null;
        if (postData == null) {
            postData = fVar.dnd();
        }
        if (postData == null) {
            postData = a(fVar);
        }
        if (postData != null && postData.boP() != null && postData.boP().getUserTbVipInfoData() != null && postData.boP().getUserTbVipInfoData().getvipIntro() != null) {
            postData.boP().getGodUserData().setIntro(postData.boP().getUserTbVipInfoData().getvipIntro());
            return postData;
        }
        return postData;
    }

    private PostData a(com.baidu.tieba.pb.data.f fVar) {
        MetaData metaData;
        if (fVar == null || fVar.dmU() == null || fVar.dmU().boP() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData boP = fVar.dmU().boP();
        String userId = boP.getUserId();
        HashMap<String, MetaData> userMap = fVar.dmU().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = boP;
        }
        postData.KV(1);
        postData.setId(fVar.dmU().bpg());
        postData.setTitle(fVar.dmU().getTitle());
        postData.setTime(fVar.dmU().getCreateTime());
        postData.a(metaData);
        return postData;
    }
}
