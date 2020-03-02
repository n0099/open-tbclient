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
    private e iEI;
    private h iTl;
    private TextView iTm;
    private View iTn;
    private TextView iTo;
    private TextView iTp;
    private TextView iTq;
    private View iTr;
    private TextView iTs;
    private VoteCountDownView iTt;
    private View iTu;
    private TextView iTv;
    private TextView iTw;
    private TextView iTx;
    private TbPageContext mPageContext;
    private View mRootView;
    private int status;
    private VoteCountDownView.a fGO = new VoteCountDownView.a() { // from class: com.baidu.tieba.pb.pb.main.view.a.1
        @Override // com.baidu.tieba.view.VoteCountDownView.a
        public void onFinished() {
            if (a.this.mRootView != null) {
                if (a.this.iEI == null || a.this.iEI.iBF == null) {
                    a.this.mRootView.setVisibility(8);
                    return;
                }
                a.this.iEI.iBF.setStatus(3);
                a.this.setData(a.this.iEI);
            }
        }
    };
    private View.OnClickListener dri = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.pb_jump_to_vote_page) {
                if (a.this.iEI != null && a.this.mPageContext != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921408, new BarVoteActivityConfig(a.this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(a.this.iEI.getForumId(), 0L), 3)));
                }
            } else if (view.getId() == R.id.pb_vote_button && bc.checkUpIsLogin(a.this.mPageContext.getPageActivity()) && a.this.iEI != null && a.this.iTl != null && a.this.iEI.cku() != null) {
                if (a.this.iTl.buf()) {
                    new an("c13444").cy("forum_id", a.this.iEI.getForumId()).aGz();
                    d dVar = new d();
                    dVar.setThreadId(com.baidu.adp.lib.f.b.toLong(a.this.iEI.getThreadId(), 0L));
                    dVar.setForumId(com.baidu.adp.lib.f.b.toLong(a.this.iEI.getForumId(), 0L));
                    String str = "";
                    PostData F = a.this.F(a.this.iEI);
                    if (F != null && F.aCo() != null) {
                        str = F.aCo().getUserId();
                    }
                    dVar.er(com.baidu.adp.lib.f.b.toLong(str, 0L));
                    dVar.yw(2);
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
    private HttpMessageListener fCj = new HttpMessageListener(CmdConfigHttp.CMD_BAR_VOTE) { // from class: com.baidu.tieba.pb.pb.main.view.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            String errorString;
            if (httpResponsedMessage != null && httpResponsedMessage.getOrginalMessage() != null) {
                int error = httpResponsedMessage.getError();
                if ((httpResponsedMessage instanceof CommitVoteResMsg) && a.this.iEI != null && a.this.iEI.iBF != null && a.this.mPageContext != null && httpResponsedMessage.getOrginalMessage().getTag() == a.this.mPageContext.getUniqueId()) {
                    if (error == 0) {
                        l.showToast(TbadkCoreApplication.getInst(), (int) R.string.bar_manager_vote_success);
                        a.this.iEI.iBF.yB(a.this.iEI.iBF.ckZ() + 1);
                        a.this.iEI.iBF.ke(false);
                        a.this.setData(a.this.iEI);
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
        this.iTm = (TextView) this.mRootView.findViewById(R.id.pb_bar_manager_select_warn);
        this.iTn = this.mRootView.findViewById(R.id.pb_vote_button_container);
        this.iTs = (TextView) this.mRootView.findViewById(R.id.pb_count_down_title);
        this.iTp = (TextView) this.mRootView.findViewById(R.id.pb_vote_button);
        this.iTo = (TextView) this.mRootView.findViewById(R.id.pb_vote_num);
        this.iTq = (TextView) this.mRootView.findViewById(R.id.pb_bar_manager_ueg_tip);
        this.iTr = this.mRootView.findViewById(R.id.pb_count_down_container);
        this.iTt = (VoteCountDownView) this.mRootView.findViewById(R.id.pb_vote_count_down_view);
        this.iTu = this.mRootView.findViewById(R.id.pb_vote_rule);
        this.iTv = (TextView) this.mRootView.findViewById(R.id.pb_vote_rule_title);
        this.iTw = (TextView) this.mRootView.findViewById(R.id.pb_vote_rule_content);
        this.iTx = (TextView) this.mRootView.findViewById(R.id.pb_jump_to_vote_page);
        MessageManager.getInstance().registerListener(this.fCj);
        setData(eVar);
        return this.mRootView;
    }

    public void setData(e eVar) {
        if (this.mRootView != null) {
            if (eVar == null || eVar.iBF == null) {
                this.mRootView.setVisibility(8);
                return;
            }
            this.iEI = eVar;
            this.iTl = eVar.iBF;
            if (this.iTl.getStatus() != 0) {
                this.status = this.iTl.getStatus();
                if (this.status == 2) {
                    this.iTn.setVisibility(8);
                    this.iTr.setVisibility(0);
                    this.iTt.setOnCountDownFinished(this.fGO);
                    this.iTt.setData(this.iTl.ckY() * 1000);
                    this.iTx.setVisibility(8);
                } else if (this.status == 3) {
                    this.iTn.setVisibility(0);
                    this.iTp.setOnClickListener(this.dri);
                    this.iTr.setVisibility(8);
                    this.iTx.setVisibility(0);
                    this.iTx.setOnClickListener(this.dri);
                    this.iTo.setText(this.iTl.ckZ() + "票");
                } else if (this.status == 4 || this.status == 5) {
                    this.iTn.setVisibility(0);
                    this.iTp.setEnabled(false);
                    this.iTr.setVisibility(8);
                    this.iTx.setVisibility(0);
                    this.iTx.setOnClickListener(this.dri);
                    this.iTo.setText(this.iTl.ckZ() + "票");
                } else if (this.status == 6) {
                    this.iTn.setVisibility(0);
                    this.iTp.setEnabled(false);
                    this.iTr.setVisibility(8);
                    this.iTo.setText(this.iTl.ckZ() + "票");
                    this.iTx.setVisibility(8);
                } else {
                    this.mRootView.setVisibility(8);
                    return;
                }
                if (this.iTl.cla() != null && !v.isEmpty(this.iTl.cla())) {
                    StringBuilder sb = new StringBuilder(this.iTl.cla().get(0));
                    int i = 1;
                    while (i < this.iTl.cla().size()) {
                        StringBuilder append = sb.append("\n").append(this.iTl.cla().get(i));
                        i++;
                        sb = append;
                    }
                    this.iTw.setText(sb);
                }
                pk(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public void pk(int i) {
        am.setViewTextColor(this.iTo, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.iTm, R.color.cp_cont_d, 1, i);
        am.setViewTextColor(this.iTq, R.color.cp_cont_d, 1, i);
        am.setViewTextColor(this.iTv, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.iTw, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.iTx, R.color.cp_link_tip_c, 1, i);
        am.setViewTextColor(this.iTs, R.color.cp_cont_b, 1, i);
        am.setBackgroundResource(this.iTp, R.drawable.pb_vote_button_bg, i);
        am.setBackgroundColor(this.iTu, R.color.cp_bg_line_e, i);
        if (this.iTt != null) {
            this.iTt.pk(i);
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
        if (eVar.ckE() != null) {
            return eVar.ckE();
        }
        if (!v.isEmpty(eVar.ckw())) {
            Iterator<PostData> it = eVar.ckw().iterator();
            while (it.hasNext()) {
                postData = it.next();
                if (postData != null && postData.cLa() == 1) {
                    break;
                }
            }
        }
        postData = null;
        if (postData == null) {
            postData = eVar.ckB();
        }
        if (postData == null) {
            postData = a(eVar);
        }
        if (postData != null && postData.aCo() != null && postData.aCo().getUserTbVipInfoData() != null && postData.aCo().getUserTbVipInfoData().getvipIntro() != null) {
            postData.aCo().getGodUserData().setIntro(postData.aCo().getUserTbVipInfoData().getvipIntro());
            return postData;
        }
        return postData;
    }

    private PostData a(e eVar) {
        MetaData metaData;
        if (eVar == null || eVar.cku() == null || eVar.cku().aCo() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData aCo = eVar.cku().aCo();
        String userId = aCo.getUserId();
        HashMap<String, MetaData> userMap = eVar.cku().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = aCo;
        }
        postData.Cw(1);
        postData.setId(eVar.cku().aCE());
        postData.setTitle(eVar.cku().getTitle());
        postData.setTime(eVar.cku().getCreateTime());
        postData.a(metaData);
        return postData;
    }
}
