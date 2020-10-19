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
    private f kXV;
    private TextView loA;
    private SelectRuleView loB;
    private TextView loC;
    private k lop;
    private TextView loq;
    private View lor;
    private TextView los;
    private TBSpecificationBtn lot;
    private TextView lou;
    private View lov;
    private TextView lox;
    private VoteCountDownView loy;
    private View loz;
    private TbPageContext mPageContext;
    private View mRootView;
    private int status;
    private VoteCountDownView.a loD = new VoteCountDownView.a() { // from class: com.baidu.tieba.pb.pb.main.view.a.1
        @Override // com.baidu.tieba.view.VoteCountDownView.a
        public void abg() {
            if (a.this.mRootView != null) {
                if (a.this.kXV == null || a.this.kXV.kUA == null) {
                    a.this.mRootView.setVisibility(8);
                    return;
                }
                a.this.kXV.kUA.setStatus(3);
                a.this.setData(a.this.kXV);
            }
        }
    };
    private View.OnClickListener eTU = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.pb_jump_to_vote_page) {
                if (a.this.kXV != null && a.this.mPageContext != null && bg.checkUpIsLogin(a.this.mPageContext.getPageActivity())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921408, new BarVoteActivityConfig(a.this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(a.this.kXV.getForumId(), 0L), 3)));
                }
            } else if (view.getId() == R.id.pb_vote_button && bg.checkUpIsLogin(a.this.mPageContext.getPageActivity()) && a.this.kXV != null && a.this.lop != null && a.this.kXV.dcA() != null) {
                if (a.this.lop.chA()) {
                    new aq("c13444").dK("forum_id", a.this.kXV.getForumId()).bmR();
                    d dVar = new d();
                    dVar.setThreadId(com.baidu.adp.lib.f.b.toLong(a.this.kXV.getThreadId(), 0L));
                    dVar.setForumId(com.baidu.adp.lib.f.b.toLong(a.this.kXV.getForumId(), 0L));
                    String str = "";
                    PostData I = a.this.I(a.this.kXV);
                    if (I != null && I.bih() != null) {
                        str = I.bih().getUserId();
                    }
                    dVar.gm(com.baidu.adp.lib.f.b.toLong(str, 0L));
                    dVar.ES(2);
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
    private HttpMessageListener hxV = new HttpMessageListener(CmdConfigHttp.CMD_BAR_VOTE) { // from class: com.baidu.tieba.pb.pb.main.view.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            String errorString;
            if (httpResponsedMessage != null && httpResponsedMessage.getOrginalMessage() != null) {
                int error = httpResponsedMessage.getError();
                if ((httpResponsedMessage instanceof CommitVoteResMsg) && a.this.kXV != null && a.this.kXV.kUA != null && a.this.mPageContext != null && httpResponsedMessage.getOrginalMessage().getTag() == a.this.mPageContext.getUniqueId()) {
                    if (error == 0) {
                        l.showToast(TbadkCoreApplication.getInst(), R.string.bar_manager_vote_success);
                        a.this.kXV.kUA.EX(a.this.kXV.kUA.ddl() + 1);
                        a.this.kXV.kUA.nM(false);
                        a.this.setData(a.this.kXV);
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
        this.loq = (TextView) this.mRootView.findViewById(R.id.pb_bar_manager_select_warn);
        this.lor = this.mRootView.findViewById(R.id.pb_vote_button_container);
        this.lox = (TextView) this.mRootView.findViewById(R.id.pb_count_down_title);
        this.lot = (TBSpecificationBtn) this.mRootView.findViewById(R.id.pb_vote_button);
        com.baidu.tbadk.core.view.commonBtn.a aVar = new com.baidu.tbadk.core.view.commonBtn.a();
        aVar.a(GradientDrawable.Orientation.TL_BR);
        this.lot.setText(TbadkCoreApplication.getInst().getString(R.string.pb_vote_text));
        this.lot.setTextSize(R.dimen.tbfontsize44);
        this.lot.setConfig(aVar);
        this.los = (TextView) this.mRootView.findViewById(R.id.pb_vote_num);
        this.lou = (TextView) this.mRootView.findViewById(R.id.pb_bar_manager_ueg_tip);
        this.lov = this.mRootView.findViewById(R.id.pb_count_down_container);
        this.loy = (VoteCountDownView) this.mRootView.findViewById(R.id.pb_vote_count_down_view);
        this.loz = this.mRootView.findViewById(R.id.pb_vote_rule);
        this.loA = (TextView) this.mRootView.findViewById(R.id.pb_vote_rule_title);
        this.loB = (SelectRuleView) this.mRootView.findViewById(R.id.pb_vote_rule_content);
        this.loC = (TextView) this.mRootView.findViewById(R.id.pb_jump_to_vote_page);
        if (this.hxV != null) {
            if (this.mPageContext.getPageActivity() instanceof BaseActivity) {
                this.hxV.setTag(((BaseActivity) this.mPageContext.getPageActivity()).getUniqueId());
            } else if (this.mPageContext.getPageActivity() instanceof BaseFragmentActivity) {
                this.hxV.setTag(((BaseFragmentActivity) this.mPageContext.getPageActivity()).getUniqueId());
            }
            MessageManager.getInstance().registerListener(this.hxV);
        }
        setData(fVar);
        return this.mRootView;
    }

    public void setData(com.baidu.tieba.pb.data.f fVar) {
        if (this.mRootView != null) {
            if (fVar == null || fVar.kUA == null) {
                this.mRootView.setVisibility(8);
                return;
            }
            this.kXV = fVar;
            this.lop = fVar.kUA;
            if (this.lop.getStatus() != 0) {
                this.status = this.lop.getStatus();
                if (this.status == 2) {
                    this.lor.setVisibility(8);
                    this.lov.setVisibility(0);
                    this.loy.setOnCountDownFinished(this.loD);
                    this.loy.setData(this.lop.ddk() * 1000);
                    this.loC.setVisibility(8);
                } else if (this.status == 3) {
                    this.lor.setVisibility(0);
                    this.lot.setOnClickListener(this.eTU);
                    this.lov.setVisibility(8);
                    this.loC.setVisibility(0);
                    this.loC.setOnClickListener(this.eTU);
                    this.los.setText(this.lop.ddl() + "票");
                } else if (this.status == 4 || this.status == 5) {
                    this.lor.setVisibility(0);
                    this.lot.setEnabled(false);
                    this.lov.setVisibility(8);
                    this.loC.setVisibility(0);
                    this.loC.setOnClickListener(this.eTU);
                    this.los.setText(this.lop.ddl() + "票");
                } else if (this.status == 6) {
                    this.lor.setVisibility(0);
                    this.lot.setEnabled(false);
                    this.lov.setVisibility(8);
                    this.los.setText(this.lop.ddl() + "票");
                    this.loC.setVisibility(8);
                } else {
                    this.mRootView.setVisibility(8);
                    return;
                }
                if (!y.isEmpty(this.lop.ddm()) || !y.isEmpty(this.lop.ddn())) {
                    this.loB.setColumn(2);
                    this.loB.setData(this.lop.ddm(), this.lop.ddn());
                }
                uc(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public void uc(int i) {
        ap.setViewTextColor(this.los, R.color.cp_link_tip_c, 1, i);
        ap.setViewTextColor(this.loq, R.color.cp_cont_d, 1, i);
        ap.setViewTextColor(this.lou, R.color.cp_cont_d, 1, i);
        ap.setViewTextColor(this.loA, R.color.cp_cont_b, 1, i);
        ap.setViewTextColor(this.loC, R.color.cp_link_tip_c, 1, i);
        ap.setViewTextColor(this.lox, R.color.cp_cont_b, 1, i);
        if (this.lot != null) {
            this.lot.bok();
        }
        ap.setBackgroundColor(this.loz, R.color.cp_bg_line_g, i);
        if (this.loy != null) {
            this.loy.uc(i);
        }
        if (this.loB != null) {
            this.loB.rB(i);
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
        if (fVar.dcN() != null) {
            return fVar.dcN();
        }
        if (!y.isEmpty(fVar.dcC())) {
            Iterator<PostData> it = fVar.dcC().iterator();
            while (it.hasNext()) {
                postData = it.next();
                if (postData != null && postData.dEp() == 1) {
                    break;
                }
            }
        }
        postData = null;
        if (postData == null) {
            postData = fVar.dcJ();
        }
        if (postData == null) {
            postData = a(fVar);
        }
        if (postData != null && postData.bih() != null && postData.bih().getUserTbVipInfoData() != null && postData.bih().getUserTbVipInfoData().getvipIntro() != null) {
            postData.bih().getGodUserData().setIntro(postData.bih().getUserTbVipInfoData().getvipIntro());
            return postData;
        }
        return postData;
    }

    private PostData a(com.baidu.tieba.pb.data.f fVar) {
        MetaData metaData;
        if (fVar == null || fVar.dcA() == null || fVar.dcA().bih() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData bih = fVar.dcA().bih();
        String userId = bih.getUserId();
        HashMap<String, MetaData> userMap = fVar.dcA().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = bih;
        }
        postData.IY(1);
        postData.setId(fVar.dcA().biy());
        postData.setTitle(fVar.dcA().getTitle());
        postData.setTime(fVar.dcA().getCreateTime());
        postData.a(metaData);
        return postData;
    }
}
