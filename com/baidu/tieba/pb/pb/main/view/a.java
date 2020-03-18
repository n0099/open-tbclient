package com.baidu.tieba.pb.pb.main.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BarVoteActivityConfig;
import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.data.CommitVoteResMsg;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.d;
import com.baidu.tieba.pb.data.e;
import com.baidu.tieba.pb.data.h;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.util.f;
import com.baidu.tieba.view.VoteCountDownView;
import java.util.HashMap;
import java.util.Iterator;
/* loaded from: classes9.dex */
public class a {
    private e iGv;
    private h iUY;
    private TextView iUZ;
    private View iVa;
    private TextView iVb;
    private TextView iVc;
    private TextView iVd;
    private View iVe;
    private TextView iVf;
    private VoteCountDownView iVg;
    private View iVh;
    private TextView iVi;
    private TextView iVj;
    private TextView iVk;
    private TbPageContext mPageContext;
    private View mRootView;
    private int status;
    private VoteCountDownView.a fHJ = new VoteCountDownView.a() { // from class: com.baidu.tieba.pb.pb.main.view.a.1
        @Override // com.baidu.tieba.view.VoteCountDownView.a
        public void onFinished() {
            if (a.this.mRootView != null) {
                if (a.this.iGv == null || a.this.iGv.iDr == null) {
                    a.this.mRootView.setVisibility(8);
                    return;
                }
                a.this.iGv.iDr.setStatus(3);
                a.this.setData(a.this.iGv);
            }
        }
    };
    private View.OnClickListener drJ = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.pb_jump_to_vote_page) {
                if (a.this.iGv != null && a.this.mPageContext != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921408, new BarVoteActivityConfig(a.this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(a.this.iGv.getForumId(), 0L), 3)));
                }
            } else if (view.getId() == R.id.pb_vote_button && bc.checkUpIsLogin(a.this.mPageContext.getPageActivity()) && a.this.iGv != null && a.this.iUY != null && a.this.iGv.ckP() != null) {
                if (a.this.iUY.bul()) {
                    new an("c13444").cx("forum_id", a.this.iGv.getForumId()).aGD();
                    d dVar = new d();
                    dVar.setThreadId(com.baidu.adp.lib.f.b.toLong(a.this.iGv.getThreadId(), 0L));
                    dVar.setForumId(com.baidu.adp.lib.f.b.toLong(a.this.iGv.getForumId(), 0L));
                    String str = "";
                    PostData F = a.this.F(a.this.iGv);
                    if (F != null && F.aCr() != null) {
                        str = F.aCr().getUserId();
                    }
                    dVar.es(com.baidu.adp.lib.f.b.toLong(str, 0L));
                    dVar.yE(2);
                    dVar.r(a.this.mPageContext.getUniqueId());
                    CustomMessage customMessage = new CustomMessage(2921411);
                    customMessage.setData(dVar);
                    MessageManager.getInstance().sendMessage(customMessage);
                    return;
                }
                l.showToast(TbadkCoreApplication.getInst(), (int) R.string.has_not_other_ticket);
            }
        }
    };
    private HttpMessageListener fDe = new HttpMessageListener(CmdConfigHttp.CMD_BAR_VOTE) { // from class: com.baidu.tieba.pb.pb.main.view.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            String errorString;
            if (httpResponsedMessage != null && httpResponsedMessage.getOrginalMessage() != null) {
                int error = httpResponsedMessage.getError();
                if ((httpResponsedMessage instanceof CommitVoteResMsg) && a.this.iGv != null && a.this.iGv.iDr != null && a.this.mPageContext != null && httpResponsedMessage.getOrginalMessage().getTag() == a.this.mPageContext.getUniqueId()) {
                    if (error == 0) {
                        l.showToast(TbadkCoreApplication.getInst(), (int) R.string.bar_manager_vote_success);
                        a.this.iGv.iDr.yJ(a.this.iGv.iDr.clv() + 1);
                        a.this.iGv.iDr.kj(false);
                        a.this.setData(a.this.iGv);
                    } else if (error == 3250023) {
                        f.a(error, "", (f.a) null);
                    } else if (error == 3250021) {
                        f.a(error, ((CommitVoteResMsg) httpResponsedMessage).getTokenData(), (f.a) null);
                    } else if (error == 3250002 || error == 3250004) {
                        BlockPopInfoData blockPopInfoData = new BlockPopInfoData();
                        if (aq.isEmpty(httpResponsedMessage.getErrorString())) {
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

    public View E(e eVar) {
        if (this.mPageContext == null) {
            return null;
        }
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.bar_manager_select_view, (ViewGroup) null);
        this.iUZ = (TextView) this.mRootView.findViewById(R.id.pb_bar_manager_select_warn);
        this.iVa = this.mRootView.findViewById(R.id.pb_vote_button_container);
        this.iVf = (TextView) this.mRootView.findViewById(R.id.pb_count_down_title);
        this.iVc = (TextView) this.mRootView.findViewById(R.id.pb_vote_button);
        this.iVb = (TextView) this.mRootView.findViewById(R.id.pb_vote_num);
        this.iVd = (TextView) this.mRootView.findViewById(R.id.pb_bar_manager_ueg_tip);
        this.iVe = this.mRootView.findViewById(R.id.pb_count_down_container);
        this.iVg = (VoteCountDownView) this.mRootView.findViewById(R.id.pb_vote_count_down_view);
        this.iVh = this.mRootView.findViewById(R.id.pb_vote_rule);
        this.iVi = (TextView) this.mRootView.findViewById(R.id.pb_vote_rule_title);
        this.iVj = (TextView) this.mRootView.findViewById(R.id.pb_vote_rule_content);
        this.iVk = (TextView) this.mRootView.findViewById(R.id.pb_jump_to_vote_page);
        MessageManager.getInstance().registerListener(this.fDe);
        setData(eVar);
        return this.mRootView;
    }

    public void setData(e eVar) {
        if (this.mRootView != null) {
            if (eVar == null || eVar.iDr == null) {
                this.mRootView.setVisibility(8);
                return;
            }
            this.iGv = eVar;
            this.iUY = eVar.iDr;
            if (this.iUY.getStatus() != 0) {
                this.status = this.iUY.getStatus();
                if (this.status == 2) {
                    this.iVa.setVisibility(8);
                    this.iVe.setVisibility(0);
                    this.iVg.setOnCountDownFinished(this.fHJ);
                    this.iVg.setData(this.iUY.clu() * 1000);
                    this.iVk.setVisibility(8);
                } else if (this.status == 3) {
                    this.iVa.setVisibility(0);
                    this.iVc.setOnClickListener(this.drJ);
                    this.iVe.setVisibility(8);
                    this.iVk.setVisibility(0);
                    this.iVk.setOnClickListener(this.drJ);
                    this.iVb.setText(this.iUY.clv() + "票");
                } else if (this.status == 4 || this.status == 5) {
                    this.iVa.setVisibility(0);
                    this.iVc.setEnabled(false);
                    this.iVe.setVisibility(8);
                    this.iVk.setVisibility(0);
                    this.iVk.setOnClickListener(this.drJ);
                    this.iVb.setText(this.iUY.clv() + "票");
                } else if (this.status == 6) {
                    this.iVa.setVisibility(0);
                    this.iVc.setEnabled(false);
                    this.iVe.setVisibility(8);
                    this.iVb.setText(this.iUY.clv() + "票");
                    this.iVk.setVisibility(8);
                } else {
                    this.mRootView.setVisibility(8);
                    return;
                }
                if (this.iUY.clw() != null && !v.isEmpty(this.iUY.clw())) {
                    StringBuilder sb = new StringBuilder(this.iUY.clw().get(0));
                    int i = 1;
                    while (i < this.iUY.clw().size()) {
                        StringBuilder append = sb.append("\n").append(this.iUY.clw().get(i));
                        i++;
                        sb = append;
                    }
                    this.iVj.setText(sb);
                }
                pm(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public void pm(int i) {
        am.setViewTextColor(this.iVb, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.iUZ, R.color.cp_cont_d, 1, i);
        am.setViewTextColor(this.iVd, R.color.cp_cont_d, 1, i);
        am.setViewTextColor(this.iVi, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.iVj, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.iVk, R.color.cp_link_tip_c, 1, i);
        am.setViewTextColor(this.iVf, R.color.cp_cont_b, 1, i);
        am.setBackgroundResource(this.iVc, R.drawable.pb_vote_button_bg, i);
        am.setBackgroundColor(this.iVh, R.color.cp_bg_line_e, i);
        if (this.iVg != null) {
            this.iVg.pm(i);
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public PostData F(e eVar) {
        PostData postData;
        if (eVar == null) {
            return null;
        }
        if (eVar.ckZ() != null) {
            return eVar.ckZ();
        }
        if (!v.isEmpty(eVar.ckR())) {
            Iterator<PostData> it = eVar.ckR().iterator();
            while (it.hasNext()) {
                postData = it.next();
                if (postData != null && postData.cLv() == 1) {
                    break;
                }
            }
        }
        postData = null;
        if (postData == null) {
            postData = eVar.ckW();
        }
        if (postData == null) {
            postData = a(eVar);
        }
        if (postData != null && postData.aCr() != null && postData.aCr().getUserTbVipInfoData() != null && postData.aCr().getUserTbVipInfoData().getvipIntro() != null) {
            postData.aCr().getGodUserData().setIntro(postData.aCr().getUserTbVipInfoData().getvipIntro());
            return postData;
        }
        return postData;
    }

    private PostData a(e eVar) {
        MetaData metaData;
        if (eVar == null || eVar.ckP() == null || eVar.ckP().aCr() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData aCr = eVar.ckP().aCr();
        String userId = aCr.getUserId();
        HashMap<String, MetaData> userMap = eVar.ckP().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = aCr;
        }
        postData.CE(1);
        postData.setId(eVar.ckP().aCH());
        postData.setTitle(eVar.ckP().getTitle());
        postData.setTime(eVar.ckP().getCreateTime());
        postData.a(metaData);
        return postData;
    }
}
