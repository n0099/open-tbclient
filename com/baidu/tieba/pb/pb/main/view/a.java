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
/* loaded from: classes7.dex */
public class a {
    private f iCZ;
    private i iRO;
    private TextView iRP;
    private View iRQ;
    private TextView iRR;
    private TextView iRS;
    private TextView iRT;
    private View iRU;
    private TextView iRV;
    private VoteCountDownView iRW;
    private View iRX;
    private TextView iRY;
    private TextView iRZ;
    private TextView iSa;
    private TbPageContext mPageContext;
    private View mRootView;
    private int status;
    private VoteCountDownView.a fEp = new VoteCountDownView.a() { // from class: com.baidu.tieba.pb.pb.main.view.a.1
        @Override // com.baidu.tieba.view.VoteCountDownView.a
        public void onFinished() {
            if (a.this.mRootView != null) {
                if (a.this.iCZ == null || a.this.iCZ.izL == null) {
                    a.this.mRootView.setVisibility(8);
                    return;
                }
                a.this.iCZ.izL.setStatus(3);
                a.this.setData(a.this.iCZ);
            }
        }
    };
    private View.OnClickListener dmY = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.pb_jump_to_vote_page) {
                if (a.this.iCZ != null && a.this.mPageContext != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921408, new BarVoteActivityConfig(a.this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(a.this.iCZ.getForumId(), 0L), 3)));
                }
            } else if (view.getId() == R.id.pb_vote_button && bc.checkUpIsLogin(a.this.mPageContext.getPageActivity()) && a.this.iCZ != null && a.this.iRO != null && a.this.iCZ.ciS() != null) {
                if (a.this.iRO.bsz()) {
                    new an("c13444").cp("forum_id", a.this.iCZ.getForumId()).aEm();
                    e eVar = new e();
                    eVar.setThreadId(com.baidu.adp.lib.f.b.toLong(a.this.iCZ.getThreadId(), 0L));
                    eVar.setForumId(com.baidu.adp.lib.f.b.toLong(a.this.iCZ.getForumId(), 0L));
                    String str = "";
                    PostData E = a.this.E(a.this.iCZ);
                    if (E != null && E.azX() != null) {
                        str = E.azX().getUserId();
                    }
                    eVar.er(com.baidu.adp.lib.f.b.toLong(str, 0L));
                    eVar.yp(2);
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
    private HttpMessageListener fzJ = new HttpMessageListener(CmdConfigHttp.CMD_BAR_VOTE) { // from class: com.baidu.tieba.pb.pb.main.view.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            String errorString;
            if (httpResponsedMessage != null && httpResponsedMessage.getOrginalMessage() != null) {
                int error = httpResponsedMessage.getError();
                if ((httpResponsedMessage instanceof CommitVoteResMsg) && a.this.iCZ != null && a.this.iCZ.izL != null && a.this.mPageContext != null && httpResponsedMessage.getOrginalMessage().getTag() == a.this.mPageContext.getUniqueId()) {
                    if (error == 0) {
                        l.showToast(TbadkCoreApplication.getInst(), (int) R.string.bar_manager_vote_success);
                        a.this.iCZ.izL.yu(a.this.iCZ.izL.cjz() + 1);
                        a.this.iCZ.izL.kc(false);
                        a.this.setData(a.this.iCZ);
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
        this.iRP = (TextView) this.mRootView.findViewById(R.id.pb_bar_manager_select_warn);
        this.iRQ = this.mRootView.findViewById(R.id.pb_vote_button_container);
        this.iRV = (TextView) this.mRootView.findViewById(R.id.pb_count_down_title);
        this.iRS = (TextView) this.mRootView.findViewById(R.id.pb_vote_button);
        this.iRR = (TextView) this.mRootView.findViewById(R.id.pb_vote_num);
        this.iRT = (TextView) this.mRootView.findViewById(R.id.pb_bar_manager_ueg_tip);
        this.iRU = this.mRootView.findViewById(R.id.pb_count_down_container);
        this.iRW = (VoteCountDownView) this.mRootView.findViewById(R.id.pb_vote_count_down_view);
        this.iRX = this.mRootView.findViewById(R.id.pb_vote_rule);
        this.iRY = (TextView) this.mRootView.findViewById(R.id.pb_vote_rule_title);
        this.iRZ = (TextView) this.mRootView.findViewById(R.id.pb_vote_rule_content);
        this.iSa = (TextView) this.mRootView.findViewById(R.id.pb_jump_to_vote_page);
        MessageManager.getInstance().registerListener(this.fzJ);
        setData(fVar);
        return this.mRootView;
    }

    public void setData(com.baidu.tieba.pb.data.f fVar) {
        if (this.mRootView != null) {
            if (fVar == null || fVar.izL == null) {
                this.mRootView.setVisibility(8);
                return;
            }
            this.iCZ = fVar;
            this.iRO = fVar.izL;
            if (this.iRO.getStatus() != 0) {
                this.status = this.iRO.getStatus();
                if (this.status == 2) {
                    this.iRQ.setVisibility(8);
                    this.iRU.setVisibility(0);
                    this.iRW.setOnCountDownFinished(this.fEp);
                    this.iRW.setData(this.iRO.cjy() * 1000);
                    this.iSa.setVisibility(8);
                } else if (this.status == 3) {
                    this.iRQ.setVisibility(0);
                    this.iRS.setOnClickListener(this.dmY);
                    this.iRU.setVisibility(8);
                    this.iSa.setVisibility(0);
                    this.iSa.setOnClickListener(this.dmY);
                    this.iRR.setText(this.iRO.cjz() + "票");
                } else if (this.status == 4 || this.status == 5) {
                    this.iRQ.setVisibility(0);
                    this.iRS.setEnabled(false);
                    this.iRU.setVisibility(8);
                    this.iSa.setVisibility(0);
                    this.iSa.setOnClickListener(this.dmY);
                    this.iRR.setText(this.iRO.cjz() + "票");
                } else if (this.status == 6) {
                    this.iRQ.setVisibility(0);
                    this.iRS.setEnabled(false);
                    this.iRU.setVisibility(8);
                    this.iRR.setText(this.iRO.cjz() + "票");
                    this.iSa.setVisibility(8);
                } else {
                    this.mRootView.setVisibility(8);
                    return;
                }
                if (this.iRO.cjA() != null && !v.isEmpty(this.iRO.cjA())) {
                    StringBuilder sb = new StringBuilder(this.iRO.cjA().get(0));
                    int i = 1;
                    while (i < this.iRO.cjA().size()) {
                        StringBuilder append = sb.append("\n").append(this.iRO.cjA().get(i));
                        i++;
                        sb = append;
                    }
                    this.iRZ.setText(sb);
                }
                oU(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public void oU(int i) {
        am.setViewTextColor(this.iRR, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.iRP, R.color.cp_cont_d, 1, i);
        am.setViewTextColor(this.iRT, R.color.cp_cont_d, 1, i);
        am.setViewTextColor(this.iRY, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.iRZ, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.iSa, R.color.cp_link_tip_c, 1, i);
        am.setViewTextColor(this.iRV, R.color.cp_cont_b, 1, i);
        am.setBackgroundResource(this.iRS, R.drawable.pb_vote_button_bg, i);
        am.setBackgroundColor(this.iRX, R.color.cp_bg_line_e, i);
        if (this.iRW != null) {
            this.iRW.oU(i);
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
        if (fVar.cjc() != null) {
            return fVar.cjc();
        }
        if (!v.isEmpty(fVar.ciU())) {
            Iterator<PostData> it = fVar.ciU().iterator();
            while (it.hasNext()) {
                postData = it.next();
                if (postData != null && postData.cJz() == 1) {
                    break;
                }
            }
        }
        postData = null;
        if (postData == null) {
            postData = fVar.ciZ();
        }
        if (postData == null) {
            postData = a(fVar);
        }
        if (postData != null && postData.azX() != null && postData.azX().getUserTbVipInfoData() != null && postData.azX().getUserTbVipInfoData().getvipIntro() != null) {
            postData.azX().getGodUserData().setIntro(postData.azX().getUserTbVipInfoData().getvipIntro());
            return postData;
        }
        return postData;
    }

    private PostData a(com.baidu.tieba.pb.data.f fVar) {
        MetaData metaData;
        if (fVar == null || fVar.ciS() == null || fVar.ciS().azX() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData azX = fVar.ciS().azX();
        String userId = azX.getUserId();
        HashMap<String, MetaData> userMap = fVar.ciS().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = azX;
        }
        postData.Cq(1);
        postData.setId(fVar.ciS().aAn());
        postData.setTitle(fVar.ciS().getTitle());
        postData.setTime(fVar.ciS().getCreateTime());
        postData.a(metaData);
        return postData;
    }
}
