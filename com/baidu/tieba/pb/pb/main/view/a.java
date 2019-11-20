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
import com.baidu.tieba.pb.data.d;
import com.baidu.tieba.pb.data.g;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.util.f;
import com.baidu.tieba.view.VoteCountDownView;
import java.util.HashMap;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class a {
    private d hNw;
    private g hYT;
    private TextView hYU;
    private View hYV;
    private TextView hYW;
    private TextView hYX;
    private TextView hYY;
    private View hYZ;
    private TextView hZa;
    private VoteCountDownView hZb;
    private View hZc;
    private TextView hZd;
    private TextView hZe;
    private TextView hZf;
    private TbPageContext mPageContext;
    private View mRootView;
    private int status;
    private VoteCountDownView.a eJh = new VoteCountDownView.a() { // from class: com.baidu.tieba.pb.pb.main.view.a.1
        @Override // com.baidu.tieba.view.VoteCountDownView.a
        public void onFinished() {
            if (a.this.mRootView != null) {
                if (a.this.hNw == null || a.this.hNw.hIx == null) {
                    a.this.mRootView.setVisibility(8);
                    return;
                }
                a.this.hNw.hIx.setStatus(3);
                a.this.setData(a.this.hNw);
            }
        }
    };
    private View.OnClickListener cze = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.pb_jump_to_vote_page) {
                if (a.this.hNw != null && a.this.mPageContext != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921408, new BarVoteActivityConfig(a.this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.toLong(a.this.hNw.getForumId(), 0L), 3)));
                }
            } else if (view.getId() == R.id.pb_vote_button && bc.checkUpIsLogin(a.this.mPageContext.getPageActivity()) && a.this.hNw != null && a.this.hYT != null && a.this.hNw.bQx() != null) {
                if (a.this.hYT.aZt()) {
                    new an("c13444").bS("forum_id", a.this.hNw.getForumId()).amI();
                    com.baidu.tieba.pb.d dVar = new com.baidu.tieba.pb.d();
                    dVar.setThreadId(com.baidu.adp.lib.g.b.toLong(a.this.hNw.getThreadId(), 0L));
                    dVar.setForumId(com.baidu.adp.lib.g.b.toLong(a.this.hNw.getForumId(), 0L));
                    String str = "";
                    PostData t = a.this.t(a.this.hNw);
                    if (t != null && t.aiE() != null) {
                        str = t.aiE().getUserId();
                    }
                    dVar.dG(com.baidu.adp.lib.g.b.toLong(str, 0L));
                    dVar.wj(2);
                    dVar.q(a.this.mPageContext.getUniqueId());
                    CustomMessage customMessage = new CustomMessage(2921411);
                    customMessage.setData(dVar);
                    MessageManager.getInstance().sendMessage(customMessage);
                    return;
                }
                l.showToast(TbadkCoreApplication.getInst(), (int) R.string.has_not_other_ticket);
            }
        }
    };
    private HttpMessageListener eEA = new HttpMessageListener(CmdConfigHttp.CMD_BAR_VOTE) { // from class: com.baidu.tieba.pb.pb.main.view.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            String errorString;
            if (httpResponsedMessage != null && httpResponsedMessage.getOrginalMessage() != null) {
                int error = httpResponsedMessage.getError();
                if ((httpResponsedMessage instanceof CommitVoteResMsg) && a.this.hNw != null && a.this.hNw.hIx != null && a.this.mPageContext != null && httpResponsedMessage.getOrginalMessage().getTag() == a.this.mPageContext.getUniqueId()) {
                    if (error == 0) {
                        l.showToast(TbadkCoreApplication.getInst(), (int) R.string.bar_manager_vote_success);
                        a.this.hNw.hIx.wn(a.this.hNw.hIx.bRa() + 1);
                        a.this.hNw.hIx.iA(false);
                        a.this.setData(a.this.hNw);
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

    public View s(d dVar) {
        if (this.mPageContext == null) {
            return null;
        }
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.bar_manager_select_view, (ViewGroup) null);
        this.hYU = (TextView) this.mRootView.findViewById(R.id.pb_bar_manager_select_warn);
        this.hYV = this.mRootView.findViewById(R.id.pb_vote_button_container);
        this.hZa = (TextView) this.mRootView.findViewById(R.id.pb_count_down_title);
        this.hYX = (TextView) this.mRootView.findViewById(R.id.pb_vote_button);
        this.hYW = (TextView) this.mRootView.findViewById(R.id.pb_vote_num);
        this.hYY = (TextView) this.mRootView.findViewById(R.id.pb_bar_manager_ueg_tip);
        this.hYZ = this.mRootView.findViewById(R.id.pb_count_down_container);
        this.hZb = (VoteCountDownView) this.mRootView.findViewById(R.id.pb_vote_count_down_view);
        this.hZc = this.mRootView.findViewById(R.id.pb_vote_rule);
        this.hZd = (TextView) this.mRootView.findViewById(R.id.pb_vote_rule_title);
        this.hZe = (TextView) this.mRootView.findViewById(R.id.pb_vote_rule_content);
        this.hZf = (TextView) this.mRootView.findViewById(R.id.pb_jump_to_vote_page);
        MessageManager.getInstance().registerListener(this.eEA);
        setData(dVar);
        return this.mRootView;
    }

    public void setData(d dVar) {
        if (this.mRootView != null) {
            if (dVar == null || dVar.hIx == null) {
                this.mRootView.setVisibility(8);
                return;
            }
            this.hNw = dVar;
            this.hYT = dVar.hIx;
            if (this.hYT.getStatus() != 0) {
                this.status = this.hYT.getStatus();
                if (this.status == 2) {
                    this.hYV.setVisibility(8);
                    this.hYZ.setVisibility(0);
                    this.hZb.setOnCountDownFinished(this.eJh);
                    this.hZb.setData(this.hYT.bQZ() * 1000);
                    this.hZf.setVisibility(8);
                } else if (this.status == 3) {
                    this.hYV.setVisibility(0);
                    this.hYX.setOnClickListener(this.cze);
                    this.hYZ.setVisibility(8);
                    this.hZf.setVisibility(0);
                    this.hZf.setOnClickListener(this.cze);
                    this.hYW.setText(this.hYT.bRa() + "票");
                } else if (this.status == 4 || this.status == 5) {
                    this.hYV.setVisibility(0);
                    this.hYX.setEnabled(false);
                    this.hYZ.setVisibility(8);
                    this.hZf.setVisibility(0);
                    this.hZf.setOnClickListener(this.cze);
                    this.hYW.setText(this.hYT.bRa() + "票");
                } else if (this.status == 6) {
                    this.hYV.setVisibility(0);
                    this.hYX.setEnabled(false);
                    this.hYZ.setVisibility(8);
                    this.hYW.setText(this.hYT.bRa() + "票");
                    this.hZf.setVisibility(8);
                } else {
                    this.mRootView.setVisibility(8);
                    return;
                }
                if (this.hYT.bRb() != null && !v.isEmpty(this.hYT.bRb())) {
                    StringBuilder sb = new StringBuilder(this.hYT.bRb().get(0));
                    int i = 1;
                    while (i < this.hYT.bRb().size()) {
                        StringBuilder append = sb.append("\n").append(this.hYT.bRb().get(i));
                        i++;
                        sb = append;
                    }
                    this.hZe.setText(sb);
                }
                mD(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public void mD(int i) {
        am.setViewTextColor(this.hYW, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.hYU, R.color.cp_cont_d, 1, i);
        am.setViewTextColor(this.hYY, R.color.cp_cont_d, 1, i);
        am.setViewTextColor(this.hZd, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.hZe, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.hZf, R.color.cp_link_tip_c, 1, i);
        am.setViewTextColor(this.hZa, R.color.cp_cont_b, 1, i);
        am.setBackgroundResource(this.hYX, R.drawable.pb_vote_button_bg, i);
        am.setBackgroundColor(this.hZc, R.color.cp_bg_line_e, i);
        if (this.hZb != null) {
            this.hZb.mD(i);
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public PostData t(d dVar) {
        PostData postData;
        if (dVar == null) {
            return null;
        }
        if (dVar.bQH() != null) {
            return dVar.bQH();
        }
        if (!v.isEmpty(dVar.bQz())) {
            Iterator<PostData> it = dVar.bQz().iterator();
            while (it.hasNext()) {
                postData = it.next();
                if (postData != null && postData.con() == 1) {
                    break;
                }
            }
        }
        postData = null;
        if (postData == null) {
            postData = dVar.bQE();
        }
        if (postData == null) {
            postData = a(dVar);
        }
        if (postData != null && postData.aiE() != null && postData.aiE().getUserTbVipInfoData() != null && postData.aiE().getUserTbVipInfoData().getvipIntro() != null) {
            postData.aiE().getGodUserData().setIntro(postData.aiE().getUserTbVipInfoData().getvipIntro());
            return postData;
        }
        return postData;
    }

    private PostData a(d dVar) {
        MetaData metaData;
        if (dVar == null || dVar.bQx() == null || dVar.bQx().aiE() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData aiE = dVar.bQx().aiE();
        String userId = aiE.getUserId();
        HashMap<String, MetaData> userMap = dVar.bQx().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = aiE;
        }
        postData.zQ(1);
        postData.setId(dVar.bQx().aiU());
        postData.setTitle(dVar.bQx().getTitle());
        postData.setTime(dVar.bQx().getCreateTime());
        postData.a(metaData);
        return postData;
    }
}
