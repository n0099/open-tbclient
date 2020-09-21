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
/* loaded from: classes21.dex */
public class a {
    private f kIK;
    private k kYY;
    private TextView kYZ;
    private View kZa;
    private TextView kZb;
    private TBSpecificationBtn kZc;
    private TextView kZd;
    private View kZe;
    private TextView kZf;
    private VoteCountDownView kZg;
    private View kZh;
    private TextView kZi;
    private SelectRuleView kZj;
    private TextView kZk;
    private TbPageContext mPageContext;
    private View mRootView;
    private int status;
    private VoteCountDownView.a kZl = new VoteCountDownView.a() { // from class: com.baidu.tieba.pb.pb.main.view.a.1
        @Override // com.baidu.tieba.view.VoteCountDownView.a
        public void Yu() {
            if (a.this.mRootView != null) {
                if (a.this.kIK == null || a.this.kIK.kFp == null) {
                    a.this.mRootView.setVisibility(8);
                    return;
                }
                a.this.kIK.kFp.setStatus(3);
                a.this.setData(a.this.kIK);
            }
        }
    };
    private View.OnClickListener eHN = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.pb_jump_to_vote_page) {
                if (a.this.kIK != null && a.this.mPageContext != null && bg.checkUpIsLogin(a.this.mPageContext.getPageActivity())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921408, new BarVoteActivityConfig(a.this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(a.this.kIK.getForumId(), 0L), 3)));
                }
            } else if (view.getId() == R.id.pb_vote_button && bg.checkUpIsLogin(a.this.mPageContext.getPageActivity()) && a.this.kIK != null && a.this.kYY != null && a.this.kIK.cYR() != null) {
                if (a.this.kYY.cee()) {
                    new aq("c13444").dF("forum_id", a.this.kIK.getForumId()).bki();
                    d dVar = new d();
                    dVar.setThreadId(com.baidu.adp.lib.f.b.toLong(a.this.kIK.getThreadId(), 0L));
                    dVar.setForumId(com.baidu.adp.lib.f.b.toLong(a.this.kIK.getForumId(), 0L));
                    String str = "";
                    PostData I = a.this.I(a.this.kIK);
                    if (I != null && I.bfy() != null) {
                        str = I.bfy().getUserId();
                    }
                    dVar.fU(com.baidu.adp.lib.f.b.toLong(str, 0L));
                    dVar.Em(2);
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
    private HttpMessageListener hja = new HttpMessageListener(CmdConfigHttp.CMD_BAR_VOTE) { // from class: com.baidu.tieba.pb.pb.main.view.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            String errorString;
            if (httpResponsedMessage != null && httpResponsedMessage.getOrginalMessage() != null) {
                int error = httpResponsedMessage.getError();
                if ((httpResponsedMessage instanceof CommitVoteResMsg) && a.this.kIK != null && a.this.kIK.kFp != null && a.this.mPageContext != null && httpResponsedMessage.getOrginalMessage().getTag() == a.this.mPageContext.getUniqueId()) {
                    if (error == 0) {
                        l.showToast(TbadkCoreApplication.getInst(), R.string.bar_manager_vote_success);
                        a.this.kIK.kFp.Er(a.this.kIK.kFp.cZC() + 1);
                        a.this.kIK.kFp.nh(false);
                        a.this.setData(a.this.kIK);
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
        this.kYZ = (TextView) this.mRootView.findViewById(R.id.pb_bar_manager_select_warn);
        this.kZa = this.mRootView.findViewById(R.id.pb_vote_button_container);
        this.kZf = (TextView) this.mRootView.findViewById(R.id.pb_count_down_title);
        this.kZc = (TBSpecificationBtn) this.mRootView.findViewById(R.id.pb_vote_button);
        com.baidu.tbadk.core.view.commonBtn.a aVar = new com.baidu.tbadk.core.view.commonBtn.a();
        aVar.a(GradientDrawable.Orientation.TL_BR);
        this.kZc.setText(TbadkCoreApplication.getInst().getString(R.string.pb_vote_text));
        this.kZc.setTextSize(R.dimen.tbfontsize44);
        this.kZc.setConfig(aVar);
        this.kZb = (TextView) this.mRootView.findViewById(R.id.pb_vote_num);
        this.kZd = (TextView) this.mRootView.findViewById(R.id.pb_bar_manager_ueg_tip);
        this.kZe = this.mRootView.findViewById(R.id.pb_count_down_container);
        this.kZg = (VoteCountDownView) this.mRootView.findViewById(R.id.pb_vote_count_down_view);
        this.kZh = this.mRootView.findViewById(R.id.pb_vote_rule);
        this.kZi = (TextView) this.mRootView.findViewById(R.id.pb_vote_rule_title);
        this.kZj = (SelectRuleView) this.mRootView.findViewById(R.id.pb_vote_rule_content);
        this.kZk = (TextView) this.mRootView.findViewById(R.id.pb_jump_to_vote_page);
        if (this.hja != null) {
            if (this.mPageContext.getPageActivity() instanceof BaseActivity) {
                this.hja.setTag(((BaseActivity) this.mPageContext.getPageActivity()).getUniqueId());
            } else if (this.mPageContext.getPageActivity() instanceof BaseFragmentActivity) {
                this.hja.setTag(((BaseFragmentActivity) this.mPageContext.getPageActivity()).getUniqueId());
            }
            MessageManager.getInstance().registerListener(this.hja);
        }
        setData(fVar);
        return this.mRootView;
    }

    public void setData(com.baidu.tieba.pb.data.f fVar) {
        if (this.mRootView != null) {
            if (fVar == null || fVar.kFp == null) {
                this.mRootView.setVisibility(8);
                return;
            }
            this.kIK = fVar;
            this.kYY = fVar.kFp;
            if (this.kYY.getStatus() != 0) {
                this.status = this.kYY.getStatus();
                if (this.status == 2) {
                    this.kZa.setVisibility(8);
                    this.kZe.setVisibility(0);
                    this.kZg.setOnCountDownFinished(this.kZl);
                    this.kZg.setData(this.kYY.cZB() * 1000);
                    this.kZk.setVisibility(8);
                } else if (this.status == 3) {
                    this.kZa.setVisibility(0);
                    this.kZc.setOnClickListener(this.eHN);
                    this.kZe.setVisibility(8);
                    this.kZk.setVisibility(0);
                    this.kZk.setOnClickListener(this.eHN);
                    this.kZb.setText(this.kYY.cZC() + "票");
                } else if (this.status == 4 || this.status == 5) {
                    this.kZa.setVisibility(0);
                    this.kZc.setEnabled(false);
                    this.kZe.setVisibility(8);
                    this.kZk.setVisibility(0);
                    this.kZk.setOnClickListener(this.eHN);
                    this.kZb.setText(this.kYY.cZC() + "票");
                } else if (this.status == 6) {
                    this.kZa.setVisibility(0);
                    this.kZc.setEnabled(false);
                    this.kZe.setVisibility(8);
                    this.kZb.setText(this.kYY.cZC() + "票");
                    this.kZk.setVisibility(8);
                } else {
                    this.mRootView.setVisibility(8);
                    return;
                }
                if (!y.isEmpty(this.kYY.cZD()) || !y.isEmpty(this.kYY.cZE())) {
                    this.kZj.setColumn(2);
                    this.kZj.setData(this.kYY.cZD(), this.kYY.cZE());
                }
                tE(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public void tE(int i) {
        ap.setViewTextColor(this.kZb, R.color.cp_link_tip_c, 1, i);
        ap.setViewTextColor(this.kYZ, R.color.cp_cont_d, 1, i);
        ap.setViewTextColor(this.kZd, R.color.cp_cont_d, 1, i);
        ap.setViewTextColor(this.kZi, R.color.cp_cont_b, 1, i);
        ap.setViewTextColor(this.kZk, R.color.cp_link_tip_c, 1, i);
        ap.setViewTextColor(this.kZf, R.color.cp_cont_b, 1, i);
        if (this.kZc != null) {
            this.kZc.blA();
        }
        ap.setBackgroundColor(this.kZh, R.color.cp_bg_line_g, i);
        if (this.kZg != null) {
            this.kZg.tE(i);
        }
        if (this.kZj != null) {
            this.kZj.rd(i);
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
        if (fVar.cZe() != null) {
            return fVar.cZe();
        }
        if (!y.isEmpty(fVar.cYT())) {
            Iterator<PostData> it = fVar.cYT().iterator();
            while (it.hasNext()) {
                postData = it.next();
                if (postData != null && postData.dAD() == 1) {
                    break;
                }
            }
        }
        postData = null;
        if (postData == null) {
            postData = fVar.cZa();
        }
        if (postData == null) {
            postData = a(fVar);
        }
        if (postData != null && postData.bfy() != null && postData.bfy().getUserTbVipInfoData() != null && postData.bfy().getUserTbVipInfoData().getvipIntro() != null) {
            postData.bfy().getGodUserData().setIntro(postData.bfy().getUserTbVipInfoData().getvipIntro());
            return postData;
        }
        return postData;
    }

    private PostData a(com.baidu.tieba.pb.data.f fVar) {
        MetaData metaData;
        if (fVar == null || fVar.cYR() == null || fVar.cYR().bfy() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData bfy = fVar.cYR().bfy();
        String userId = bfy.getUserId();
        HashMap<String, MetaData> userMap = fVar.cYR().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = bfy;
        }
        postData.Is(1);
        postData.setId(fVar.cYR().bfP());
        postData.setTitle(fVar.cYR().getTitle());
        postData.setTime(fVar.cYR().getCreateTime());
        postData.a(metaData);
        return postData;
    }
}
