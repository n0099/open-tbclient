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
    private k lGL;
    private TextView lGM;
    private View lGN;
    private TextView lGO;
    private TBSpecificationBtn lGP;
    private TextView lGQ;
    private View lGR;
    private TextView lGS;
    private VoteCountDownView lGT;
    private View lGU;
    private TextView lGV;
    private SelectRuleView lGW;
    private TextView lGX;
    private f lqv;
    private TbPageContext mPageContext;
    private View mRootView;
    private int status;
    private VoteCountDownView.a lGY = new VoteCountDownView.a() { // from class: com.baidu.tieba.pb.pb.main.view.a.1
        @Override // com.baidu.tieba.view.VoteCountDownView.a
        public void afA() {
            if (a.this.mRootView != null) {
                if (a.this.lqv == null || a.this.lqv.lmV == null) {
                    a.this.mRootView.setVisibility(8);
                    return;
                }
                a.this.lqv.lmV.setStatus(3);
                a.this.setData(a.this.lqv);
            }
        }
    };
    private View.OnClickListener fii = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.pb_jump_to_vote_page) {
                if (a.this.lqv != null && a.this.mPageContext != null && bg.checkUpIsLogin(a.this.mPageContext.getPageActivity())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921408, new BarVoteActivityConfig(a.this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(a.this.lqv.getForumId(), 0L), 3)));
                }
            } else if (view.getId() == R.id.pb_vote_button && bg.checkUpIsLogin(a.this.mPageContext.getPageActivity()) && a.this.lqv != null && a.this.lGL != null && a.this.lqv.dik() != null) {
                if (a.this.lGL.cnj()) {
                    new aq("c13444").dR("forum_id", a.this.lqv.getForumId()).brk();
                    d dVar = new d();
                    dVar.setThreadId(com.baidu.adp.lib.f.b.toLong(a.this.lqv.getThreadId(), 0L));
                    dVar.setForumId(com.baidu.adp.lib.f.b.toLong(a.this.lqv.getForumId(), 0L));
                    String str = "";
                    PostData I = a.this.I(a.this.lqv);
                    if (I != null && I.bmA() != null) {
                        str = I.bmA().getUserId();
                    }
                    dVar.gJ(com.baidu.adp.lib.f.b.toLong(str, 0L));
                    dVar.Fy(2);
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
    private HttpMessageListener hQo = new HttpMessageListener(CmdConfigHttp.CMD_BAR_VOTE) { // from class: com.baidu.tieba.pb.pb.main.view.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            String errorString;
            if (httpResponsedMessage != null && httpResponsedMessage.getOrginalMessage() != null) {
                int error = httpResponsedMessage.getError();
                if ((httpResponsedMessage instanceof CommitVoteResMsg) && a.this.lqv != null && a.this.lqv.lmV != null && a.this.mPageContext != null && httpResponsedMessage.getOrginalMessage().getTag() == a.this.mPageContext.getUniqueId()) {
                    if (error == 0) {
                        l.showToast(TbadkCoreApplication.getInst(), R.string.bar_manager_vote_success);
                        a.this.lqv.lmV.FD(a.this.lqv.lmV.diV() + 1);
                        a.this.lqv.lmV.on(false);
                        a.this.setData(a.this.lqv);
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
        this.lGM = (TextView) this.mRootView.findViewById(R.id.pb_bar_manager_select_warn);
        this.lGN = this.mRootView.findViewById(R.id.pb_vote_button_container);
        this.lGS = (TextView) this.mRootView.findViewById(R.id.pb_count_down_title);
        this.lGP = (TBSpecificationBtn) this.mRootView.findViewById(R.id.pb_vote_button);
        com.baidu.tbadk.core.view.commonBtn.a aVar = new com.baidu.tbadk.core.view.commonBtn.a();
        aVar.a(GradientDrawable.Orientation.TL_BR);
        this.lGP.setText(TbadkCoreApplication.getInst().getString(R.string.pb_vote_text));
        this.lGP.setTextSize(R.dimen.tbfontsize44);
        this.lGP.setConfig(aVar);
        this.lGO = (TextView) this.mRootView.findViewById(R.id.pb_vote_num);
        this.lGQ = (TextView) this.mRootView.findViewById(R.id.pb_bar_manager_ueg_tip);
        this.lGR = this.mRootView.findViewById(R.id.pb_count_down_container);
        this.lGT = (VoteCountDownView) this.mRootView.findViewById(R.id.pb_vote_count_down_view);
        this.lGU = this.mRootView.findViewById(R.id.pb_vote_rule);
        this.lGV = (TextView) this.mRootView.findViewById(R.id.pb_vote_rule_title);
        this.lGW = (SelectRuleView) this.mRootView.findViewById(R.id.pb_vote_rule_content);
        this.lGX = (TextView) this.mRootView.findViewById(R.id.pb_jump_to_vote_page);
        if (this.hQo != null) {
            if (this.mPageContext.getPageActivity() instanceof BaseActivity) {
                this.hQo.setTag(((BaseActivity) this.mPageContext.getPageActivity()).getUniqueId());
            } else if (this.mPageContext.getPageActivity() instanceof BaseFragmentActivity) {
                this.hQo.setTag(((BaseFragmentActivity) this.mPageContext.getPageActivity()).getUniqueId());
            }
            MessageManager.getInstance().registerListener(this.hQo);
        }
        setData(fVar);
        return this.mRootView;
    }

    public void setData(com.baidu.tieba.pb.data.f fVar) {
        if (this.mRootView != null) {
            if (fVar == null || fVar.lmV == null) {
                this.mRootView.setVisibility(8);
                return;
            }
            this.lqv = fVar;
            this.lGL = fVar.lmV;
            if (this.lGL.getStatus() != 0) {
                this.status = this.lGL.getStatus();
                if (this.status == 2) {
                    this.lGN.setVisibility(8);
                    this.lGR.setVisibility(0);
                    this.lGT.setOnCountDownFinished(this.lGY);
                    this.lGT.setData(this.lGL.diU() * 1000);
                    this.lGX.setVisibility(8);
                } else if (this.status == 3) {
                    this.lGN.setVisibility(0);
                    this.lGP.setOnClickListener(this.fii);
                    this.lGR.setVisibility(8);
                    this.lGX.setVisibility(0);
                    this.lGX.setOnClickListener(this.fii);
                    this.lGO.setText(this.lGL.diV() + "票");
                } else if (this.status == 4 || this.status == 5) {
                    this.lGN.setVisibility(0);
                    this.lGP.setEnabled(false);
                    this.lGR.setVisibility(8);
                    this.lGX.setVisibility(0);
                    this.lGX.setOnClickListener(this.fii);
                    this.lGO.setText(this.lGL.diV() + "票");
                } else if (this.status == 6) {
                    this.lGN.setVisibility(0);
                    this.lGP.setEnabled(false);
                    this.lGR.setVisibility(8);
                    this.lGO.setText(this.lGL.diV() + "票");
                    this.lGX.setVisibility(8);
                } else {
                    this.mRootView.setVisibility(8);
                    return;
                }
                if (!y.isEmpty(this.lGL.diW()) || !y.isEmpty(this.lGL.diX())) {
                    this.lGW.setColumn(2);
                    this.lGW.setData(this.lGL.diW(), this.lGL.diX());
                }
                uE(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public void uE(int i) {
        ap.setViewTextColor(this.lGO, R.color.cp_link_tip_c, 1, i);
        ap.setViewTextColor(this.lGM, R.color.cp_cont_d, 1, i);
        ap.setViewTextColor(this.lGQ, R.color.cp_cont_d, 1, i);
        ap.setViewTextColor(this.lGV, R.color.cp_cont_b, 1, i);
        ap.setViewTextColor(this.lGX, R.color.cp_link_tip_c, 1, i);
        ap.setViewTextColor(this.lGS, R.color.cp_cont_b, 1, i);
        if (this.lGP != null) {
            this.lGP.bsD();
        }
        ap.setBackgroundColor(this.lGU, R.color.cp_bg_line_g, i);
        if (this.lGT != null) {
            this.lGT.uE(i);
        }
        if (this.lGW != null) {
            this.lGW.rW(i);
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
        if (fVar.dix() != null) {
            return fVar.dix();
        }
        if (!y.isEmpty(fVar.dim())) {
            Iterator<PostData> it = fVar.dim().iterator();
            while (it.hasNext()) {
                postData = it.next();
                if (postData != null && postData.dJZ() == 1) {
                    break;
                }
            }
        }
        postData = null;
        if (postData == null) {
            postData = fVar.dit();
        }
        if (postData == null) {
            postData = a(fVar);
        }
        if (postData != null && postData.bmA() != null && postData.bmA().getUserTbVipInfoData() != null && postData.bmA().getUserTbVipInfoData().getvipIntro() != null) {
            postData.bmA().getGodUserData().setIntro(postData.bmA().getUserTbVipInfoData().getvipIntro());
            return postData;
        }
        return postData;
    }

    private PostData a(com.baidu.tieba.pb.data.f fVar) {
        MetaData metaData;
        if (fVar == null || fVar.dik() == null || fVar.dik().bmA() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData bmA = fVar.dik().bmA();
        String userId = bmA.getUserId();
        HashMap<String, MetaData> userMap = fVar.dik().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = bmA;
        }
        postData.JD(1);
        postData.setId(fVar.dik().bmR());
        postData.setTitle(fVar.dik().getTitle());
        postData.setTime(fVar.dik().getCreateTime());
        postData.a(metaData);
        return postData;
    }
}
