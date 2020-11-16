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
/* loaded from: classes21.dex */
public class a {
    private k lHd;
    private TextView lHe;
    private View lHf;
    private TextView lHg;
    private TBSpecificationBtn lHh;
    private TextView lHi;
    private View lHj;
    private TextView lHk;
    private VoteCountDownView lHl;
    private View lHm;
    private TextView lHn;
    private SelectRuleView lHo;
    private TextView lHp;
    private f lqK;
    private TbPageContext mPageContext;
    private View mRootView;
    private int status;
    private VoteCountDownView.a lHq = new VoteCountDownView.a() { // from class: com.baidu.tieba.pb.pb.main.view.a.1
        @Override // com.baidu.tieba.view.VoteCountDownView.a
        public void aeS() {
            if (a.this.mRootView != null) {
                if (a.this.lqK == null || a.this.lqK.lnm == null) {
                    a.this.mRootView.setVisibility(8);
                    return;
                }
                a.this.lqK.lnm.setStatus(3);
                a.this.setData(a.this.lqK);
            }
        }
    };
    private View.OnClickListener fhp = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.pb_jump_to_vote_page) {
                if (a.this.lqK != null && a.this.mPageContext != null && bh.checkUpIsLogin(a.this.mPageContext.getPageActivity())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921408, new BarVoteActivityConfig(a.this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(a.this.lqK.getForumId(), 0L), 3)));
                }
            } else if (view.getId() == R.id.pb_vote_button && bh.checkUpIsLogin(a.this.mPageContext.getPageActivity()) && a.this.lqK != null && a.this.lHd != null && a.this.lqK.dhH() != null) {
                if (a.this.lHd.cmL()) {
                    new ar("c13444").dR("forum_id", a.this.lqK.getForumId()).bqy();
                    d dVar = new d();
                    dVar.setThreadId(com.baidu.adp.lib.f.b.toLong(a.this.lqK.getThreadId(), 0L));
                    dVar.setForumId(com.baidu.adp.lib.f.b.toLong(a.this.lqK.getForumId(), 0L));
                    String str = "";
                    PostData K = a.this.K(a.this.lqK);
                    if (K != null && K.blC() != null) {
                        str = K.blC().getUserId();
                    }
                    dVar.gM(com.baidu.adp.lib.f.b.toLong(str, 0L));
                    dVar.FW(2);
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
    private HttpMessageListener hQO = new HttpMessageListener(CmdConfigHttp.CMD_BAR_VOTE) { // from class: com.baidu.tieba.pb.pb.main.view.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            String errorString;
            if (httpResponsedMessage != null && httpResponsedMessage.getOrginalMessage() != null) {
                int error = httpResponsedMessage.getError();
                if ((httpResponsedMessage instanceof CommitVoteResMsg) && a.this.lqK != null && a.this.lqK.lnm != null && a.this.mPageContext != null && httpResponsedMessage.getOrginalMessage().getTag() == a.this.mPageContext.getUniqueId()) {
                    if (error == 0) {
                        l.showToast(TbadkCoreApplication.getInst(), R.string.bar_manager_vote_success);
                        a.this.lqK.lnm.Gb(a.this.lqK.lnm.dis() + 1);
                        a.this.lqK.lnm.op(false);
                        a.this.setData(a.this.lqK);
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

    public View J(com.baidu.tieba.pb.data.f fVar) {
        if (this.mPageContext == null) {
            return null;
        }
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.bar_manager_select_view, (ViewGroup) null);
        this.lHe = (TextView) this.mRootView.findViewById(R.id.pb_bar_manager_select_warn);
        this.lHf = this.mRootView.findViewById(R.id.pb_vote_button_container);
        this.lHk = (TextView) this.mRootView.findViewById(R.id.pb_count_down_title);
        this.lHh = (TBSpecificationBtn) this.mRootView.findViewById(R.id.pb_vote_button);
        com.baidu.tbadk.core.view.commonBtn.a aVar = new com.baidu.tbadk.core.view.commonBtn.a();
        aVar.a(GradientDrawable.Orientation.TL_BR);
        this.lHh.setText(TbadkCoreApplication.getInst().getString(R.string.pb_vote_text));
        this.lHh.setTextSize(R.dimen.tbfontsize44);
        this.lHh.setConfig(aVar);
        this.lHg = (TextView) this.mRootView.findViewById(R.id.pb_vote_num);
        this.lHi = (TextView) this.mRootView.findViewById(R.id.pb_bar_manager_ueg_tip);
        this.lHj = this.mRootView.findViewById(R.id.pb_count_down_container);
        this.lHl = (VoteCountDownView) this.mRootView.findViewById(R.id.pb_vote_count_down_view);
        this.lHm = this.mRootView.findViewById(R.id.pb_vote_rule);
        this.lHn = (TextView) this.mRootView.findViewById(R.id.pb_vote_rule_title);
        this.lHo = (SelectRuleView) this.mRootView.findViewById(R.id.pb_vote_rule_content);
        this.lHp = (TextView) this.mRootView.findViewById(R.id.pb_jump_to_vote_page);
        if (this.hQO != null) {
            if (this.mPageContext.getPageActivity() instanceof BaseActivity) {
                this.hQO.setTag(((BaseActivity) this.mPageContext.getPageActivity()).getUniqueId());
            } else if (this.mPageContext.getPageActivity() instanceof BaseFragmentActivity) {
                this.hQO.setTag(((BaseFragmentActivity) this.mPageContext.getPageActivity()).getUniqueId());
            }
            MessageManager.getInstance().registerListener(this.hQO);
        }
        setData(fVar);
        return this.mRootView;
    }

    public void setData(com.baidu.tieba.pb.data.f fVar) {
        if (this.mRootView != null) {
            if (fVar == null || fVar.lnm == null) {
                this.mRootView.setVisibility(8);
                return;
            }
            this.lqK = fVar;
            this.lHd = fVar.lnm;
            if (this.lHd.getStatus() != 0) {
                this.status = this.lHd.getStatus();
                if (this.status == 2) {
                    this.lHf.setVisibility(8);
                    this.lHj.setVisibility(0);
                    this.lHl.setOnCountDownFinished(this.lHq);
                    this.lHl.setData(this.lHd.dir() * 1000);
                    this.lHp.setVisibility(8);
                } else if (this.status == 3) {
                    this.lHf.setVisibility(0);
                    this.lHh.setOnClickListener(this.fhp);
                    this.lHj.setVisibility(8);
                    this.lHp.setVisibility(0);
                    this.lHp.setOnClickListener(this.fhp);
                    this.lHg.setText(this.lHd.dis() + "票");
                } else if (this.status == 4 || this.status == 5) {
                    this.lHf.setVisibility(0);
                    this.lHh.setEnabled(false);
                    this.lHj.setVisibility(8);
                    this.lHp.setVisibility(0);
                    this.lHp.setOnClickListener(this.fhp);
                    this.lHg.setText(this.lHd.dis() + "票");
                } else if (this.status == 6) {
                    this.lHf.setVisibility(0);
                    this.lHh.setEnabled(false);
                    this.lHj.setVisibility(8);
                    this.lHg.setText(this.lHd.dis() + "票");
                    this.lHp.setVisibility(8);
                } else {
                    this.mRootView.setVisibility(8);
                    return;
                }
                if (!y.isEmpty(this.lHd.dit()) || !y.isEmpty(this.lHd.diu())) {
                    this.lHo.setColumn(2);
                    this.lHo.setData(this.lHd.dit(), this.lHd.diu());
                }
                vc(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public void vc(int i) {
        ap.setViewTextColor(this.lHg, R.color.CAM_X0304, 1, i);
        ap.setViewTextColor(this.lHe, R.color.CAM_X0109, 1, i);
        ap.setViewTextColor(this.lHi, R.color.CAM_X0109, 1, i);
        ap.setViewTextColor(this.lHn, R.color.CAM_X0105, 1, i);
        ap.setViewTextColor(this.lHp, R.color.CAM_X0304, 1, i);
        ap.setViewTextColor(this.lHk, R.color.CAM_X0105, 1, i);
        if (this.lHh != null) {
            this.lHh.brT();
        }
        ap.setBackgroundColor(this.lHm, R.color.CAM_X0206, i);
        if (this.lHl != null) {
            this.lHl.vc(i);
        }
        if (this.lHo != null) {
            this.lHo.su(i);
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public PostData K(com.baidu.tieba.pb.data.f fVar) {
        PostData postData;
        if (fVar == null) {
            return null;
        }
        if (fVar.dhU() != null) {
            return fVar.dhU();
        }
        if (!y.isEmpty(fVar.dhJ())) {
            Iterator<PostData> it = fVar.dhJ().iterator();
            while (it.hasNext()) {
                postData = it.next();
                if (postData != null && postData.dJQ() == 1) {
                    break;
                }
            }
        }
        postData = null;
        if (postData == null) {
            postData = fVar.dhQ();
        }
        if (postData == null) {
            postData = a(fVar);
        }
        if (postData != null && postData.blC() != null && postData.blC().getUserTbVipInfoData() != null && postData.blC().getUserTbVipInfoData().getvipIntro() != null) {
            postData.blC().getGodUserData().setIntro(postData.blC().getUserTbVipInfoData().getvipIntro());
            return postData;
        }
        return postData;
    }

    private PostData a(com.baidu.tieba.pb.data.f fVar) {
        MetaData metaData;
        if (fVar == null || fVar.dhH() == null || fVar.dhH().blC() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData blC = fVar.dhH().blC();
        String userId = blC.getUserId();
        HashMap<String, MetaData> userMap = fVar.dhH().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = blC;
        }
        postData.Kf(1);
        postData.setId(fVar.dhH().blT());
        postData.setTitle(fVar.dhH().getTitle());
        postData.setTime(fVar.dhH().getCreateTime());
        postData.a(metaData);
        return postData;
    }
}
