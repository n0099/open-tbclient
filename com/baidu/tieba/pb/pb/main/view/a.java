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
/* loaded from: classes16.dex */
public class a {
    private f kAn;
    private TBSpecificationBtn kQA;
    private TextView kQB;
    private View kQC;
    private TextView kQD;
    private VoteCountDownView kQE;
    private View kQF;
    private TextView kQG;
    private SelectRuleView kQH;
    private TextView kQI;
    private k kQw;
    private TextView kQx;
    private View kQy;
    private TextView kQz;
    private TbPageContext mPageContext;
    private View mRootView;
    private int status;
    private VoteCountDownView.a kQJ = new VoteCountDownView.a() { // from class: com.baidu.tieba.pb.pb.main.view.a.1
        @Override // com.baidu.tieba.view.VoteCountDownView.a
        public void XL() {
            if (a.this.mRootView != null) {
                if (a.this.kAn == null || a.this.kAn.kwQ == null) {
                    a.this.mRootView.setVisibility(8);
                    return;
                }
                a.this.kAn.kwQ.setStatus(3);
                a.this.setData(a.this.kAn);
            }
        }
    };
    private View.OnClickListener eFG = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.pb_jump_to_vote_page) {
                if (a.this.kAn != null && a.this.mPageContext != null && bg.checkUpIsLogin(a.this.mPageContext.getPageActivity())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921408, new BarVoteActivityConfig(a.this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(a.this.kAn.getForumId(), 0L), 3)));
                }
            } else if (view.getId() == R.id.pb_vote_button && bg.checkUpIsLogin(a.this.mPageContext.getPageActivity()) && a.this.kAn != null && a.this.kQw != null && a.this.kAn.cVm() != null) {
                if (a.this.kQw.caQ()) {
                    new aq("c13444").dD("forum_id", a.this.kAn.getForumId()).bjn();
                    d dVar = new d();
                    dVar.setThreadId(com.baidu.adp.lib.f.b.toLong(a.this.kAn.getThreadId(), 0L));
                    dVar.setForumId(com.baidu.adp.lib.f.b.toLong(a.this.kAn.getForumId(), 0L));
                    String str = "";
                    PostData I = a.this.I(a.this.kAn);
                    if (I != null && I.beE() != null) {
                        str = I.beE().getUserId();
                    }
                    dVar.fG(com.baidu.adp.lib.f.b.toLong(str, 0L));
                    dVar.DL(2);
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
    private HttpMessageListener hcb = new HttpMessageListener(CmdConfigHttp.CMD_BAR_VOTE) { // from class: com.baidu.tieba.pb.pb.main.view.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            String errorString;
            if (httpResponsedMessage != null && httpResponsedMessage.getOrginalMessage() != null) {
                int error = httpResponsedMessage.getError();
                if ((httpResponsedMessage instanceof CommitVoteResMsg) && a.this.kAn != null && a.this.kAn.kwQ != null && a.this.mPageContext != null && httpResponsedMessage.getOrginalMessage().getTag() == a.this.mPageContext.getUniqueId()) {
                    if (error == 0) {
                        l.showToast(TbadkCoreApplication.getInst(), R.string.bar_manager_vote_success);
                        a.this.kAn.kwQ.DQ(a.this.kAn.kwQ.cVX() + 1);
                        a.this.kAn.kwQ.nb(false);
                        a.this.setData(a.this.kAn);
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
        this.kQx = (TextView) this.mRootView.findViewById(R.id.pb_bar_manager_select_warn);
        this.kQy = this.mRootView.findViewById(R.id.pb_vote_button_container);
        this.kQD = (TextView) this.mRootView.findViewById(R.id.pb_count_down_title);
        this.kQA = (TBSpecificationBtn) this.mRootView.findViewById(R.id.pb_vote_button);
        com.baidu.tbadk.core.view.commonBtn.a aVar = new com.baidu.tbadk.core.view.commonBtn.a();
        aVar.a(GradientDrawable.Orientation.TL_BR);
        this.kQA.setText(TbadkCoreApplication.getInst().getString(R.string.pb_vote_text));
        this.kQA.setTextSize(R.dimen.tbfontsize44);
        this.kQA.setConfig(aVar);
        this.kQz = (TextView) this.mRootView.findViewById(R.id.pb_vote_num);
        this.kQB = (TextView) this.mRootView.findViewById(R.id.pb_bar_manager_ueg_tip);
        this.kQC = this.mRootView.findViewById(R.id.pb_count_down_container);
        this.kQE = (VoteCountDownView) this.mRootView.findViewById(R.id.pb_vote_count_down_view);
        this.kQF = this.mRootView.findViewById(R.id.pb_vote_rule);
        this.kQG = (TextView) this.mRootView.findViewById(R.id.pb_vote_rule_title);
        this.kQH = (SelectRuleView) this.mRootView.findViewById(R.id.pb_vote_rule_content);
        this.kQI = (TextView) this.mRootView.findViewById(R.id.pb_jump_to_vote_page);
        if (this.hcb != null) {
            if (this.mPageContext.getPageActivity() instanceof BaseActivity) {
                this.hcb.setTag(((BaseActivity) this.mPageContext.getPageActivity()).getUniqueId());
            } else if (this.mPageContext.getPageActivity() instanceof BaseFragmentActivity) {
                this.hcb.setTag(((BaseFragmentActivity) this.mPageContext.getPageActivity()).getUniqueId());
            }
            MessageManager.getInstance().registerListener(this.hcb);
        }
        setData(fVar);
        return this.mRootView;
    }

    public void setData(com.baidu.tieba.pb.data.f fVar) {
        if (this.mRootView != null) {
            if (fVar == null || fVar.kwQ == null) {
                this.mRootView.setVisibility(8);
                return;
            }
            this.kAn = fVar;
            this.kQw = fVar.kwQ;
            if (this.kQw.getStatus() != 0) {
                this.status = this.kQw.getStatus();
                if (this.status == 2) {
                    this.kQy.setVisibility(8);
                    this.kQC.setVisibility(0);
                    this.kQE.setOnCountDownFinished(this.kQJ);
                    this.kQE.setData(this.kQw.cVW() * 1000);
                    this.kQI.setVisibility(8);
                } else if (this.status == 3) {
                    this.kQy.setVisibility(0);
                    this.kQA.setOnClickListener(this.eFG);
                    this.kQC.setVisibility(8);
                    this.kQI.setVisibility(0);
                    this.kQI.setOnClickListener(this.eFG);
                    this.kQz.setText(this.kQw.cVX() + "票");
                } else if (this.status == 4 || this.status == 5) {
                    this.kQy.setVisibility(0);
                    this.kQA.setEnabled(false);
                    this.kQC.setVisibility(8);
                    this.kQI.setVisibility(0);
                    this.kQI.setOnClickListener(this.eFG);
                    this.kQz.setText(this.kQw.cVX() + "票");
                } else if (this.status == 6) {
                    this.kQy.setVisibility(0);
                    this.kQA.setEnabled(false);
                    this.kQC.setVisibility(8);
                    this.kQz.setText(this.kQw.cVX() + "票");
                    this.kQI.setVisibility(8);
                } else {
                    this.mRootView.setVisibility(8);
                    return;
                }
                if (!y.isEmpty(this.kQw.cVY()) || !y.isEmpty(this.kQw.cVZ())) {
                    this.kQH.setColumn(2);
                    this.kQH.setData(this.kQw.cVY(), this.kQw.cVZ());
                }
                tl(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public void tl(int i) {
        ap.setViewTextColor(this.kQz, R.color.cp_link_tip_c, 1, i);
        ap.setViewTextColor(this.kQx, R.color.cp_cont_d, 1, i);
        ap.setViewTextColor(this.kQB, R.color.cp_cont_d, 1, i);
        ap.setViewTextColor(this.kQG, R.color.cp_cont_b, 1, i);
        ap.setViewTextColor(this.kQI, R.color.cp_link_tip_c, 1, i);
        ap.setViewTextColor(this.kQD, R.color.cp_cont_b, 1, i);
        if (this.kQA != null) {
            this.kQA.bkF();
        }
        ap.setBackgroundColor(this.kQF, R.color.cp_bg_line_g, i);
        if (this.kQE != null) {
            this.kQE.tl(i);
        }
        if (this.kQH != null) {
            this.kQH.qM(i);
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
        if (fVar.cVz() != null) {
            return fVar.cVz();
        }
        if (!y.isEmpty(fVar.cVo())) {
            Iterator<PostData> it = fVar.cVo().iterator();
            while (it.hasNext()) {
                postData = it.next();
                if (postData != null && postData.dwK() == 1) {
                    break;
                }
            }
        }
        postData = null;
        if (postData == null) {
            postData = fVar.cVv();
        }
        if (postData == null) {
            postData = a(fVar);
        }
        if (postData != null && postData.beE() != null && postData.beE().getUserTbVipInfoData() != null && postData.beE().getUserTbVipInfoData().getvipIntro() != null) {
            postData.beE().getGodUserData().setIntro(postData.beE().getUserTbVipInfoData().getvipIntro());
            return postData;
        }
        return postData;
    }

    private PostData a(com.baidu.tieba.pb.data.f fVar) {
        MetaData metaData;
        if (fVar == null || fVar.cVm() == null || fVar.cVm().beE() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData beE = fVar.cVm().beE();
        String userId = beE.getUserId();
        HashMap<String, MetaData> userMap = fVar.cVm().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = beE;
        }
        postData.HP(1);
        postData.setId(fVar.cVm().beV());
        postData.setTitle(fVar.cVm().getTitle());
        postData.setTime(fVar.cVm().getCreateTime());
        postData.a(metaData);
        return postData;
    }
}
