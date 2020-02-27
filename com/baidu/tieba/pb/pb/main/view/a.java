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
    private e iEG;
    private h iTj;
    private TextView iTk;
    private View iTl;
    private TextView iTm;
    private TextView iTn;
    private TextView iTo;
    private View iTp;
    private TextView iTq;
    private VoteCountDownView iTr;
    private View iTs;
    private TextView iTt;
    private TextView iTu;
    private TextView iTv;
    private TbPageContext mPageContext;
    private View mRootView;
    private int status;
    private VoteCountDownView.a fGM = new VoteCountDownView.a() { // from class: com.baidu.tieba.pb.pb.main.view.a.1
        @Override // com.baidu.tieba.view.VoteCountDownView.a
        public void onFinished() {
            if (a.this.mRootView != null) {
                if (a.this.iEG == null || a.this.iEG.iBD == null) {
                    a.this.mRootView.setVisibility(8);
                    return;
                }
                a.this.iEG.iBD.setStatus(3);
                a.this.setData(a.this.iEG);
            }
        }
    };
    private View.OnClickListener drh = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.pb_jump_to_vote_page) {
                if (a.this.iEG != null && a.this.mPageContext != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921408, new BarVoteActivityConfig(a.this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(a.this.iEG.getForumId(), 0L), 3)));
                }
            } else if (view.getId() == R.id.pb_vote_button && bc.checkUpIsLogin(a.this.mPageContext.getPageActivity()) && a.this.iEG != null && a.this.iTj != null && a.this.iEG.cks() != null) {
                if (a.this.iTj.bud()) {
                    new an("c13444").cy("forum_id", a.this.iEG.getForumId()).aGx();
                    d dVar = new d();
                    dVar.setThreadId(com.baidu.adp.lib.f.b.toLong(a.this.iEG.getThreadId(), 0L));
                    dVar.setForumId(com.baidu.adp.lib.f.b.toLong(a.this.iEG.getForumId(), 0L));
                    String str = "";
                    PostData F = a.this.F(a.this.iEG);
                    if (F != null && F.aCm() != null) {
                        str = F.aCm().getUserId();
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
    private HttpMessageListener fCh = new HttpMessageListener(CmdConfigHttp.CMD_BAR_VOTE) { // from class: com.baidu.tieba.pb.pb.main.view.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            String errorString;
            if (httpResponsedMessage != null && httpResponsedMessage.getOrginalMessage() != null) {
                int error = httpResponsedMessage.getError();
                if ((httpResponsedMessage instanceof CommitVoteResMsg) && a.this.iEG != null && a.this.iEG.iBD != null && a.this.mPageContext != null && httpResponsedMessage.getOrginalMessage().getTag() == a.this.mPageContext.getUniqueId()) {
                    if (error == 0) {
                        l.showToast(TbadkCoreApplication.getInst(), (int) R.string.bar_manager_vote_success);
                        a.this.iEG.iBD.yB(a.this.iEG.iBD.ckX() + 1);
                        a.this.iEG.iBD.ke(false);
                        a.this.setData(a.this.iEG);
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
        this.iTk = (TextView) this.mRootView.findViewById(R.id.pb_bar_manager_select_warn);
        this.iTl = this.mRootView.findViewById(R.id.pb_vote_button_container);
        this.iTq = (TextView) this.mRootView.findViewById(R.id.pb_count_down_title);
        this.iTn = (TextView) this.mRootView.findViewById(R.id.pb_vote_button);
        this.iTm = (TextView) this.mRootView.findViewById(R.id.pb_vote_num);
        this.iTo = (TextView) this.mRootView.findViewById(R.id.pb_bar_manager_ueg_tip);
        this.iTp = this.mRootView.findViewById(R.id.pb_count_down_container);
        this.iTr = (VoteCountDownView) this.mRootView.findViewById(R.id.pb_vote_count_down_view);
        this.iTs = this.mRootView.findViewById(R.id.pb_vote_rule);
        this.iTt = (TextView) this.mRootView.findViewById(R.id.pb_vote_rule_title);
        this.iTu = (TextView) this.mRootView.findViewById(R.id.pb_vote_rule_content);
        this.iTv = (TextView) this.mRootView.findViewById(R.id.pb_jump_to_vote_page);
        MessageManager.getInstance().registerListener(this.fCh);
        setData(eVar);
        return this.mRootView;
    }

    public void setData(e eVar) {
        if (this.mRootView != null) {
            if (eVar == null || eVar.iBD == null) {
                this.mRootView.setVisibility(8);
                return;
            }
            this.iEG = eVar;
            this.iTj = eVar.iBD;
            if (this.iTj.getStatus() != 0) {
                this.status = this.iTj.getStatus();
                if (this.status == 2) {
                    this.iTl.setVisibility(8);
                    this.iTp.setVisibility(0);
                    this.iTr.setOnCountDownFinished(this.fGM);
                    this.iTr.setData(this.iTj.ckW() * 1000);
                    this.iTv.setVisibility(8);
                } else if (this.status == 3) {
                    this.iTl.setVisibility(0);
                    this.iTn.setOnClickListener(this.drh);
                    this.iTp.setVisibility(8);
                    this.iTv.setVisibility(0);
                    this.iTv.setOnClickListener(this.drh);
                    this.iTm.setText(this.iTj.ckX() + "票");
                } else if (this.status == 4 || this.status == 5) {
                    this.iTl.setVisibility(0);
                    this.iTn.setEnabled(false);
                    this.iTp.setVisibility(8);
                    this.iTv.setVisibility(0);
                    this.iTv.setOnClickListener(this.drh);
                    this.iTm.setText(this.iTj.ckX() + "票");
                } else if (this.status == 6) {
                    this.iTl.setVisibility(0);
                    this.iTn.setEnabled(false);
                    this.iTp.setVisibility(8);
                    this.iTm.setText(this.iTj.ckX() + "票");
                    this.iTv.setVisibility(8);
                } else {
                    this.mRootView.setVisibility(8);
                    return;
                }
                if (this.iTj.ckY() != null && !v.isEmpty(this.iTj.ckY())) {
                    StringBuilder sb = new StringBuilder(this.iTj.ckY().get(0));
                    int i = 1;
                    while (i < this.iTj.ckY().size()) {
                        StringBuilder append = sb.append("\n").append(this.iTj.ckY().get(i));
                        i++;
                        sb = append;
                    }
                    this.iTu.setText(sb);
                }
                pk(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public void pk(int i) {
        am.setViewTextColor(this.iTm, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.iTk, R.color.cp_cont_d, 1, i);
        am.setViewTextColor(this.iTo, R.color.cp_cont_d, 1, i);
        am.setViewTextColor(this.iTt, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.iTu, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.iTv, R.color.cp_link_tip_c, 1, i);
        am.setViewTextColor(this.iTq, R.color.cp_cont_b, 1, i);
        am.setBackgroundResource(this.iTn, R.drawable.pb_vote_button_bg, i);
        am.setBackgroundColor(this.iTs, R.color.cp_bg_line_e, i);
        if (this.iTr != null) {
            this.iTr.pk(i);
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
        if (eVar.ckC() != null) {
            return eVar.ckC();
        }
        if (!v.isEmpty(eVar.cku())) {
            Iterator<PostData> it = eVar.cku().iterator();
            while (it.hasNext()) {
                postData = it.next();
                if (postData != null && postData.cKY() == 1) {
                    break;
                }
            }
        }
        postData = null;
        if (postData == null) {
            postData = eVar.ckz();
        }
        if (postData == null) {
            postData = a(eVar);
        }
        if (postData != null && postData.aCm() != null && postData.aCm().getUserTbVipInfoData() != null && postData.aCm().getUserTbVipInfoData().getvipIntro() != null) {
            postData.aCm().getGodUserData().setIntro(postData.aCm().getUserTbVipInfoData().getvipIntro());
            return postData;
        }
        return postData;
    }

    private PostData a(e eVar) {
        MetaData metaData;
        if (eVar == null || eVar.cks() == null || eVar.cks().aCm() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData aCm = eVar.cks().aCm();
        String userId = aCm.getUserId();
        HashMap<String, MetaData> userMap = eVar.cks().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = aCm;
        }
        postData.Cw(1);
        postData.setId(eVar.cks().aCC());
        postData.setTitle(eVar.cks().getTitle());
        postData.setTime(eVar.cks().getCreateTime());
        postData.a(metaData);
        return postData;
    }
}
