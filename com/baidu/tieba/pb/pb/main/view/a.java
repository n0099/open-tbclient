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
    private f lEt;
    private k lUY;
    private TextView lUZ;
    private View lVa;
    private TextView lVb;
    private TBSpecificationBtn lVc;
    private TextView lVd;
    private View lVe;
    private TextView lVf;
    private VoteCountDownView lVg;
    private View lVh;
    private TextView lVi;
    private SelectRuleView lVj;
    private TextView lVk;
    private TbPageContext mPageContext;
    private View mRootView;
    private int status;
    private VoteCountDownView.a lVl = new VoteCountDownView.a() { // from class: com.baidu.tieba.pb.pb.main.view.a.1
        @Override // com.baidu.tieba.view.VoteCountDownView.a
        public void aia() {
            if (a.this.mRootView != null) {
                if (a.this.lEt == null || a.this.lEt.lAL == null) {
                    a.this.mRootView.setVisibility(8);
                    return;
                }
                a.this.lEt.lAL.setStatus(3);
                a.this.setData(a.this.lEt);
            }
        }
    };
    private View.OnClickListener foP = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.pb_jump_to_vote_page) {
                if (a.this.lEt != null && a.this.mPageContext != null && bh.checkUpIsLogin(a.this.mPageContext.getPageActivity())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921408, new BarVoteActivityConfig(a.this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(a.this.lEt.getForumId(), 0L), 3)));
                }
            } else if (view.getId() == R.id.pb_vote_button && bh.checkUpIsLogin(a.this.mPageContext.getPageActivity()) && a.this.lEt != null && a.this.lUY != null && a.this.lEt.dmT() != null) {
                if (a.this.lUY.cqY()) {
                    new ar("c13444").dY("forum_id", a.this.lEt.getForumId()).btT();
                    d dVar = new d();
                    dVar.setThreadId(com.baidu.adp.lib.f.b.toLong(a.this.lEt.getThreadId(), 0L));
                    dVar.setForumId(com.baidu.adp.lib.f.b.toLong(a.this.lEt.getForumId(), 0L));
                    String str = "";
                    PostData L = a.this.L(a.this.lEt);
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
    private HttpMessageListener ibI = new HttpMessageListener(CmdConfigHttp.CMD_BAR_VOTE) { // from class: com.baidu.tieba.pb.pb.main.view.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            String errorString;
            if (httpResponsedMessage != null && httpResponsedMessage.getOrginalMessage() != null) {
                int error = httpResponsedMessage.getError();
                if ((httpResponsedMessage instanceof CommitVoteResMsg) && a.this.lEt != null && a.this.lEt.lAL != null && a.this.mPageContext != null && httpResponsedMessage.getOrginalMessage().getTag() == a.this.mPageContext.getUniqueId()) {
                    if (error == 0) {
                        l.showToast(TbadkCoreApplication.getInst(), R.string.bar_manager_vote_success);
                        a.this.lEt.lAL.GQ(a.this.lEt.lAL.dnH() + 1);
                        a.this.lEt.lAL.oL(false);
                        a.this.setData(a.this.lEt);
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
        this.lUZ = (TextView) this.mRootView.findViewById(R.id.pb_bar_manager_select_warn);
        this.lVa = this.mRootView.findViewById(R.id.pb_vote_button_container);
        this.lVf = (TextView) this.mRootView.findViewById(R.id.pb_count_down_title);
        this.lVc = (TBSpecificationBtn) this.mRootView.findViewById(R.id.pb_vote_button);
        com.baidu.tbadk.core.view.commonBtn.a aVar = new com.baidu.tbadk.core.view.commonBtn.a();
        aVar.a(GradientDrawable.Orientation.TL_BR);
        this.lVc.setText(TbadkCoreApplication.getInst().getString(R.string.pb_vote_text));
        this.lVc.setTextSize(R.dimen.tbfontsize44);
        this.lVc.setConfig(aVar);
        this.lVb = (TextView) this.mRootView.findViewById(R.id.pb_vote_num);
        this.lVd = (TextView) this.mRootView.findViewById(R.id.pb_bar_manager_ueg_tip);
        this.lVe = this.mRootView.findViewById(R.id.pb_count_down_container);
        this.lVg = (VoteCountDownView) this.mRootView.findViewById(R.id.pb_vote_count_down_view);
        this.lVh = this.mRootView.findViewById(R.id.pb_vote_rule);
        this.lVi = (TextView) this.mRootView.findViewById(R.id.pb_vote_rule_title);
        this.lVj = (SelectRuleView) this.mRootView.findViewById(R.id.pb_vote_rule_content);
        this.lVk = (TextView) this.mRootView.findViewById(R.id.pb_jump_to_vote_page);
        if (this.ibI != null) {
            if (this.mPageContext.getPageActivity() instanceof BaseActivity) {
                this.ibI.setTag(((BaseActivity) this.mPageContext.getPageActivity()).getUniqueId());
            } else if (this.mPageContext.getPageActivity() instanceof BaseFragmentActivity) {
                this.ibI.setTag(((BaseFragmentActivity) this.mPageContext.getPageActivity()).getUniqueId());
            }
            MessageManager.getInstance().registerListener(this.ibI);
        }
        setData(fVar);
        return this.mRootView;
    }

    public void setData(com.baidu.tieba.pb.data.f fVar) {
        if (this.mRootView != null) {
            if (fVar == null || fVar.lAL == null) {
                this.mRootView.setVisibility(8);
                return;
            }
            this.lEt = fVar;
            this.lUY = fVar.lAL;
            if (this.lUY.getStatus() != 0) {
                this.status = this.lUY.getStatus();
                if (this.status == 2) {
                    this.lVa.setVisibility(8);
                    this.lVe.setVisibility(0);
                    this.lVg.setOnCountDownFinished(this.lVl);
                    this.lVg.setData(this.lUY.dnG() * 1000);
                    this.lVk.setVisibility(8);
                } else if (this.status == 3) {
                    this.lVa.setVisibility(0);
                    this.lVc.setOnClickListener(this.foP);
                    this.lVe.setVisibility(8);
                    this.lVk.setVisibility(0);
                    this.lVk.setOnClickListener(this.foP);
                    this.lVb.setText(this.lUY.dnH() + "票");
                } else if (this.status == 4 || this.status == 5) {
                    this.lVa.setVisibility(0);
                    this.lVc.setEnabled(false);
                    this.lVe.setVisibility(8);
                    this.lVk.setVisibility(0);
                    this.lVk.setOnClickListener(this.foP);
                    this.lVb.setText(this.lUY.dnH() + "票");
                } else if (this.status == 6) {
                    this.lVa.setVisibility(0);
                    this.lVc.setEnabled(false);
                    this.lVe.setVisibility(8);
                    this.lVb.setText(this.lUY.dnH() + "票");
                    this.lVk.setVisibility(8);
                } else {
                    this.mRootView.setVisibility(8);
                    return;
                }
                if (!y.isEmpty(this.lUY.dnI()) || !y.isEmpty(this.lUY.dnJ())) {
                    this.lVj.setColumn(2);
                    this.lVj.setData(this.lUY.dnI(), this.lUY.dnJ());
                }
                vJ(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public void vJ(int i) {
        ap.setViewTextColor(this.lVb, R.color.CAM_X0304, 1, i);
        ap.setViewTextColor(this.lUZ, R.color.CAM_X0109, 1, i);
        ap.setViewTextColor(this.lVd, R.color.CAM_X0109, 1, i);
        ap.setViewTextColor(this.lVi, R.color.CAM_X0105, 1, i);
        ap.setViewTextColor(this.lVk, R.color.CAM_X0304, 1, i);
        ap.setViewTextColor(this.lVf, R.color.CAM_X0105, 1, i);
        if (this.lVc != null) {
            this.lVc.bvt();
        }
        ap.setBackgroundColor(this.lVh, R.color.CAM_X0206, i);
        if (this.lVg != null) {
            this.lVg.vJ(i);
        }
        if (this.lVj != null) {
            this.lVj.sX(i);
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
        if (fVar.dng() != null) {
            return fVar.dng();
        }
        if (!y.isEmpty(fVar.dmV())) {
            Iterator<PostData> it = fVar.dmV().iterator();
            while (it.hasNext()) {
                postData = it.next();
                if (postData != null && postData.dPg() == 1) {
                    break;
                }
            }
        }
        postData = null;
        if (postData == null) {
            postData = fVar.dnc();
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
        if (fVar == null || fVar.dmT() == null || fVar.dmT().boP() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData boP = fVar.dmT().boP();
        String userId = boP.getUserId();
        HashMap<String, MetaData> userMap = fVar.dmT().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = boP;
        }
        postData.KV(1);
        postData.setId(fVar.dmT().bpg());
        postData.setTitle(fVar.dmT().getTitle());
        postData.setTime(fVar.dmT().getCreateTime());
        postData.a(metaData);
        return postData;
    }
}
