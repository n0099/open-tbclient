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
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.pb.data.i;
import com.baidu.tieba.pb.e;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.util.f;
import com.baidu.tieba.view.VoteCountDownView;
import java.util.HashMap;
import java.util.Iterator;
/* loaded from: classes6.dex */
public class a {
    private i iOk;
    private TextView iOl;
    private View iOm;
    private TextView iOn;
    private TextView iOo;
    private TextView iOp;
    private View iOq;
    private TextView iOr;
    private VoteCountDownView iOs;
    private View iOt;
    private TextView iOu;
    private TextView iOv;
    private TextView iOw;
    private f izv;
    private TbPageContext mPageContext;
    private View mRootView;
    private int status;
    private VoteCountDownView.a fBe = new VoteCountDownView.a() { // from class: com.baidu.tieba.pb.pb.main.view.a.1
        @Override // com.baidu.tieba.view.VoteCountDownView.a
        public void onFinished() {
            if (a.this.mRootView != null) {
                if (a.this.izv == null || a.this.izv.iwh == null) {
                    a.this.mRootView.setVisibility(8);
                    return;
                }
                a.this.izv.iwh.setStatus(3);
                a.this.setData(a.this.izv);
            }
        }
    };
    private View.OnClickListener dmK = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.pb_jump_to_vote_page) {
                if (a.this.izv != null && a.this.mPageContext != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921408, new BarVoteActivityConfig(a.this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(a.this.izv.getForumId(), 0L), 3)));
                }
            } else if (view.getId() == R.id.pb_vote_button && bc.checkUpIsLogin(a.this.mPageContext.getPageActivity()) && a.this.izv != null && a.this.iOk != null && a.this.izv.chK() != null) {
                if (a.this.iOk.brx()) {
                    new an("c13444").cp("forum_id", a.this.izv.getForumId()).aDT();
                    e eVar = new e();
                    eVar.setThreadId(com.baidu.adp.lib.f.b.toLong(a.this.izv.getThreadId(), 0L));
                    eVar.setForumId(com.baidu.adp.lib.f.b.toLong(a.this.izv.getForumId(), 0L));
                    String str = "";
                    PostData E = a.this.E(a.this.izv);
                    if (E != null && E.azE() != null) {
                        str = E.azE().getUserId();
                    }
                    eVar.em(com.baidu.adp.lib.f.b.toLong(str, 0L));
                    eVar.yk(2);
                    eVar.r(a.this.mPageContext.getUniqueId());
                    CustomMessage customMessage = new CustomMessage(2921411);
                    customMessage.setData(eVar);
                    MessageManager.getInstance().sendMessage(customMessage);
                    return;
                }
                l.showToast(TbadkCoreApplication.getInst(), (int) R.string.has_not_other_ticket);
            }
        }
    };
    private HttpMessageListener fwy = new HttpMessageListener(CmdConfigHttp.CMD_BAR_VOTE) { // from class: com.baidu.tieba.pb.pb.main.view.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            String errorString;
            if (httpResponsedMessage != null && httpResponsedMessage.getOrginalMessage() != null) {
                int error = httpResponsedMessage.getError();
                if ((httpResponsedMessage instanceof CommitVoteResMsg) && a.this.izv != null && a.this.izv.iwh != null && a.this.mPageContext != null && httpResponsedMessage.getOrginalMessage().getTag() == a.this.mPageContext.getUniqueId()) {
                    if (error == 0) {
                        l.showToast(TbadkCoreApplication.getInst(), (int) R.string.bar_manager_vote_success);
                        a.this.izv.iwh.yp(a.this.izv.iwh.cir() + 1);
                        a.this.izv.iwh.jR(false);
                        a.this.setData(a.this.izv);
                    } else if (error == 3250023) {
                        com.baidu.tieba.tbadkCore.util.f.a(error, "", (f.a) null);
                    } else if (error == 3250021) {
                        com.baidu.tieba.tbadkCore.util.f.a(error, ((CommitVoteResMsg) httpResponsedMessage).getTokenData(), (f.a) null);
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

    public View D(com.baidu.tieba.pb.data.f fVar) {
        if (this.mPageContext == null) {
            return null;
        }
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.bar_manager_select_view, (ViewGroup) null);
        this.iOl = (TextView) this.mRootView.findViewById(R.id.pb_bar_manager_select_warn);
        this.iOm = this.mRootView.findViewById(R.id.pb_vote_button_container);
        this.iOr = (TextView) this.mRootView.findViewById(R.id.pb_count_down_title);
        this.iOo = (TextView) this.mRootView.findViewById(R.id.pb_vote_button);
        this.iOn = (TextView) this.mRootView.findViewById(R.id.pb_vote_num);
        this.iOp = (TextView) this.mRootView.findViewById(R.id.pb_bar_manager_ueg_tip);
        this.iOq = this.mRootView.findViewById(R.id.pb_count_down_container);
        this.iOs = (VoteCountDownView) this.mRootView.findViewById(R.id.pb_vote_count_down_view);
        this.iOt = this.mRootView.findViewById(R.id.pb_vote_rule);
        this.iOu = (TextView) this.mRootView.findViewById(R.id.pb_vote_rule_title);
        this.iOv = (TextView) this.mRootView.findViewById(R.id.pb_vote_rule_content);
        this.iOw = (TextView) this.mRootView.findViewById(R.id.pb_jump_to_vote_page);
        MessageManager.getInstance().registerListener(this.fwy);
        setData(fVar);
        return this.mRootView;
    }

    public void setData(com.baidu.tieba.pb.data.f fVar) {
        if (this.mRootView != null) {
            if (fVar == null || fVar.iwh == null) {
                this.mRootView.setVisibility(8);
                return;
            }
            this.izv = fVar;
            this.iOk = fVar.iwh;
            if (this.iOk.getStatus() != 0) {
                this.status = this.iOk.getStatus();
                if (this.status == 2) {
                    this.iOm.setVisibility(8);
                    this.iOq.setVisibility(0);
                    this.iOs.setOnCountDownFinished(this.fBe);
                    this.iOs.setData(this.iOk.ciq() * 1000);
                    this.iOw.setVisibility(8);
                } else if (this.status == 3) {
                    this.iOm.setVisibility(0);
                    this.iOo.setOnClickListener(this.dmK);
                    this.iOq.setVisibility(8);
                    this.iOw.setVisibility(0);
                    this.iOw.setOnClickListener(this.dmK);
                    this.iOn.setText(this.iOk.cir() + "票");
                } else if (this.status == 4 || this.status == 5) {
                    this.iOm.setVisibility(0);
                    this.iOo.setEnabled(false);
                    this.iOq.setVisibility(8);
                    this.iOw.setVisibility(0);
                    this.iOw.setOnClickListener(this.dmK);
                    this.iOn.setText(this.iOk.cir() + "票");
                } else if (this.status == 6) {
                    this.iOm.setVisibility(0);
                    this.iOo.setEnabled(false);
                    this.iOq.setVisibility(8);
                    this.iOn.setText(this.iOk.cir() + "票");
                    this.iOw.setVisibility(8);
                } else {
                    this.mRootView.setVisibility(8);
                    return;
                }
                if (this.iOk.cis() != null && !v.isEmpty(this.iOk.cis())) {
                    StringBuilder sb = new StringBuilder(this.iOk.cis().get(0));
                    int i = 1;
                    while (i < this.iOk.cis().size()) {
                        StringBuilder append = sb.append("\n").append(this.iOk.cis().get(i));
                        i++;
                        sb = append;
                    }
                    this.iOv.setText(sb);
                }
                oT(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public void oT(int i) {
        am.setViewTextColor(this.iOn, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.iOl, R.color.cp_cont_d, 1, i);
        am.setViewTextColor(this.iOp, R.color.cp_cont_d, 1, i);
        am.setViewTextColor(this.iOu, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.iOv, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.iOw, R.color.cp_link_tip_c, 1, i);
        am.setViewTextColor(this.iOr, R.color.cp_cont_b, 1, i);
        am.setBackgroundResource(this.iOo, R.drawable.pb_vote_button_bg, i);
        am.setBackgroundColor(this.iOt, R.color.cp_bg_line_e, i);
        if (this.iOs != null) {
            this.iOs.oT(i);
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public PostData E(com.baidu.tieba.pb.data.f fVar) {
        PostData postData;
        if (fVar == null) {
            return null;
        }
        if (fVar.chU() != null) {
            return fVar.chU();
        }
        if (!v.isEmpty(fVar.chM())) {
            Iterator<PostData> it = fVar.chM().iterator();
            while (it.hasNext()) {
                postData = it.next();
                if (postData != null && postData.cIt() == 1) {
                    break;
                }
            }
        }
        postData = null;
        if (postData == null) {
            postData = fVar.chR();
        }
        if (postData == null) {
            postData = a(fVar);
        }
        if (postData != null && postData.azE() != null && postData.azE().getUserTbVipInfoData() != null && postData.azE().getUserTbVipInfoData().getvipIntro() != null) {
            postData.azE().getGodUserData().setIntro(postData.azE().getUserTbVipInfoData().getvipIntro());
            return postData;
        }
        return postData;
    }

    private PostData a(com.baidu.tieba.pb.data.f fVar) {
        MetaData metaData;
        if (fVar == null || fVar.chK() == null || fVar.chK().azE() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData azE = fVar.chK().azE();
        String userId = azE.getUserId();
        HashMap<String, MetaData> userMap = fVar.chK().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = azE;
        }
        postData.Cl(1);
        postData.setId(fVar.chK().azU());
        postData.setTitle(fVar.chK().getTitle());
        postData.setTime(fVar.chK().getCreateTime());
        postData.a(metaData);
        return postData;
    }
}
