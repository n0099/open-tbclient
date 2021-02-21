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
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BarVoteActivityConfig;
import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.data.CommitVoteResMsg;
import com.baidu.tbadk.widget.SelectRuleView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.d;
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.pb.data.l;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.util.f;
import com.baidu.tieba.view.VoteCountDownView;
import java.util.HashMap;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class a {
    private f lOi;
    private TbPageContext mPageContext;
    private View mRootView;
    private l mfb;
    private TextView mfc;
    private View mfd;
    private TextView mfe;
    private TBSpecificationBtn mff;
    private TextView mfg;
    private View mfh;
    private TextView mfi;
    private VoteCountDownView mfj;
    private View mfk;
    private TextView mfl;
    private SelectRuleView mfm;
    private TextView mfn;
    private int status;
    private VoteCountDownView.a mfo = new VoteCountDownView.a() { // from class: com.baidu.tieba.pb.pb.main.view.a.1
        @Override // com.baidu.tieba.view.VoteCountDownView.a
        public void ciA() {
            if (a.this.mRootView != null) {
                if (a.this.lOi == null || a.this.lOi.lKo == null) {
                    a.this.mRootView.setVisibility(8);
                    return;
                }
                a.this.lOi.lKo.setStatus(3);
                a.this.setData(a.this.lOi);
            }
        }
    };
    private View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.pb_jump_to_vote_page) {
                if (a.this.lOi != null && a.this.mPageContext != null && bh.checkUpIsLogin(a.this.mPageContext.getPageActivity())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921408, new BarVoteActivityConfig(a.this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(a.this.lOi.getForumId(), 0L), 3)));
                }
            } else if (view.getId() == R.id.pb_vote_button && bh.checkUpIsLogin(a.this.mPageContext.getPageActivity()) && a.this.lOi != null && a.this.mfb != null && a.this.lOi.dlg() != null) {
                if (a.this.mfb.crs()) {
                    new ar("c13444").dR("forum_id", a.this.lOi.getForumId()).bsO();
                    d dVar = new d();
                    dVar.setThreadId(com.baidu.adp.lib.f.b.toLong(a.this.lOi.getThreadId(), 0L));
                    dVar.setForumId(com.baidu.adp.lib.f.b.toLong(a.this.lOi.getForumId(), 0L));
                    String str = "";
                    PostData L = a.this.L(a.this.lOi);
                    if (L != null && L.bnQ() != null) {
                        str = L.bnQ().getUserId();
                    }
                    dVar.hr(com.baidu.adp.lib.f.b.toLong(str, 0L));
                    dVar.Fq(2);
                    dVar.u(a.this.mPageContext.getUniqueId());
                    CustomMessage customMessage = new CustomMessage(2921411);
                    customMessage.setData(dVar);
                    MessageManager.getInstance().sendMessage(customMessage);
                    return;
                }
                com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), R.string.has_not_other_ticket);
            }
        }
    };
    private HttpMessageListener ipx = new HttpMessageListener(CmdConfigHttp.CMD_BAR_VOTE) { // from class: com.baidu.tieba.pb.pb.main.view.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            String errorString;
            if (httpResponsedMessage != null && httpResponsedMessage.getOrginalMessage() != null) {
                int error = httpResponsedMessage.getError();
                if ((httpResponsedMessage instanceof CommitVoteResMsg) && a.this.lOi != null && a.this.lOi.lKo != null && a.this.mPageContext != null && httpResponsedMessage.getOrginalMessage().getTag() == a.this.mPageContext.getUniqueId()) {
                    if (error == 0) {
                        com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), R.string.bar_manager_vote_success);
                        a.this.lOi.lKo.Fv(a.this.lOi.lKo.dlT() + 1);
                        a.this.lOi.lKo.pq(false);
                        a.this.setData(a.this.lOi);
                    } else if (error == 3250023) {
                        com.baidu.tieba.tbadkCore.util.f.a(error, "", (f.a) null);
                    } else if (error == 3250021) {
                        com.baidu.tieba.tbadkCore.util.f.a(error, ((CommitVoteResMsg) httpResponsedMessage).getTokenData(), (f.a) null);
                    } else if (error == 3250002 || error == 3250004) {
                        BlockPopInfoData blockPopInfoData = new BlockPopInfoData();
                        if (au.isEmpty(httpResponsedMessage.getErrorString())) {
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
                        com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), httpResponsedMessage.getErrorString());
                    }
                }
            }
        }
    };

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public View K(com.baidu.tieba.pb.data.f fVar) {
        if (this.mPageContext == null) {
            return null;
        }
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.bar_manager_select_view, (ViewGroup) null);
        this.mfc = (TextView) this.mRootView.findViewById(R.id.pb_bar_manager_select_warn);
        this.mfd = this.mRootView.findViewById(R.id.pb_vote_button_container);
        this.mfi = (TextView) this.mRootView.findViewById(R.id.pb_count_down_title);
        this.mff = (TBSpecificationBtn) this.mRootView.findViewById(R.id.pb_vote_button);
        com.baidu.tbadk.core.view.commonBtn.a aVar = new com.baidu.tbadk.core.view.commonBtn.a();
        aVar.a(GradientDrawable.Orientation.TL_BR);
        this.mff.setText(TbadkCoreApplication.getInst().getString(R.string.pb_vote_text));
        this.mff.setTextSize(R.dimen.tbfontsize44);
        this.mff.setConfig(aVar);
        this.mfe = (TextView) this.mRootView.findViewById(R.id.pb_vote_num);
        this.mfg = (TextView) this.mRootView.findViewById(R.id.pb_bar_manager_ueg_tip);
        this.mfh = this.mRootView.findViewById(R.id.pb_count_down_container);
        this.mfj = (VoteCountDownView) this.mRootView.findViewById(R.id.pb_vote_count_down_view);
        this.mfk = this.mRootView.findViewById(R.id.pb_vote_rule);
        this.mfl = (TextView) this.mRootView.findViewById(R.id.pb_vote_rule_title);
        this.mfm = (SelectRuleView) this.mRootView.findViewById(R.id.pb_vote_rule_content);
        this.mfn = (TextView) this.mRootView.findViewById(R.id.pb_jump_to_vote_page);
        if (this.ipx != null) {
            if (this.mPageContext.getPageActivity() instanceof BaseActivity) {
                this.ipx.setTag(((BaseActivity) this.mPageContext.getPageActivity()).getUniqueId());
            } else if (this.mPageContext.getPageActivity() instanceof BaseFragmentActivity) {
                this.ipx.setTag(((BaseFragmentActivity) this.mPageContext.getPageActivity()).getUniqueId());
            }
            MessageManager.getInstance().registerListener(this.ipx);
        }
        setData(fVar);
        return this.mRootView;
    }

    public void setData(com.baidu.tieba.pb.data.f fVar) {
        if (this.mRootView != null) {
            if (fVar == null || fVar.lKo == null) {
                this.mRootView.setVisibility(8);
                return;
            }
            this.lOi = fVar;
            this.mfb = fVar.lKo;
            if (this.mfb.getStatus() != 0) {
                this.status = this.mfb.getStatus();
                if (this.status == 2) {
                    this.mfd.setVisibility(8);
                    this.mfh.setVisibility(0);
                    this.mfj.setOnCountDownFinished(this.mfo);
                    this.mfj.setData(this.mfb.dlS() * 1000);
                    this.mfn.setVisibility(8);
                } else if (this.status == 3) {
                    this.mfd.setVisibility(0);
                    this.mff.setOnClickListener(this.onClickListener);
                    this.mfh.setVisibility(8);
                    this.mfn.setVisibility(0);
                    this.mfn.setOnClickListener(this.onClickListener);
                    this.mfe.setText(this.mfb.dlT() + "票");
                } else if (this.status == 4 || this.status == 5) {
                    this.mfd.setVisibility(0);
                    this.mff.setEnabled(false);
                    this.mfh.setVisibility(8);
                    this.mfn.setVisibility(0);
                    this.mfn.setOnClickListener(this.onClickListener);
                    this.mfe.setText(this.mfb.dlT() + "票");
                } else if (this.status == 6) {
                    this.mfd.setVisibility(0);
                    this.mff.setEnabled(false);
                    this.mfh.setVisibility(8);
                    this.mfe.setText(this.mfb.dlT() + "票");
                    this.mfn.setVisibility(8);
                } else {
                    this.mRootView.setVisibility(8);
                    return;
                }
                if (!y.isEmpty(this.mfb.dlU()) || !y.isEmpty(this.mfb.dlV())) {
                    this.mfm.setColumn(2);
                    this.mfm.setData(this.mfb.dlU(), this.mfb.dlV());
                }
                uu(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public void uu(int i) {
        ap.setViewTextColor(this.mfe, R.color.CAM_X0304, 1, i);
        ap.setViewTextColor(this.mfc, R.color.CAM_X0109, 1, i);
        ap.setViewTextColor(this.mfg, R.color.CAM_X0109, 1, i);
        ap.setViewTextColor(this.mfl, R.color.CAM_X0105, 1, i);
        ap.setViewTextColor(this.mfn, R.color.CAM_X0304, 1, i);
        ap.setViewTextColor(this.mfi, R.color.CAM_X0105, 1, i);
        if (this.mff != null) {
            this.mff.bup();
        }
        ap.setBackgroundColor(this.mfk, R.color.CAM_X0206, i);
        if (this.mfj != null) {
            this.mfj.uu(i);
        }
        if (this.mfm != null) {
            this.mfm.rH(i);
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public PostData L(com.baidu.tieba.pb.data.f fVar) {
        PostData postData;
        if (fVar == null) {
            return null;
        }
        if (fVar.dlt() != null) {
            return fVar.dlt();
        }
        if (!y.isEmpty(fVar.dli())) {
            Iterator<PostData> it = fVar.dli().iterator();
            while (it.hasNext()) {
                postData = it.next();
                if (postData != null && postData.dNF() == 1) {
                    break;
                }
            }
        }
        postData = null;
        if (postData == null) {
            postData = fVar.dlp();
        }
        if (postData == null) {
            postData = a(fVar);
        }
        if (postData != null && postData.bnQ() != null && postData.bnQ().getUserTbVipInfoData() != null && postData.bnQ().getUserTbVipInfoData().getvipIntro() != null) {
            postData.bnQ().getGodUserData().setIntro(postData.bnQ().getUserTbVipInfoData().getvipIntro());
            return postData;
        }
        return postData;
    }

    private PostData a(com.baidu.tieba.pb.data.f fVar) {
        MetaData metaData;
        if (fVar == null || fVar.dlg() == null || fVar.dlg().bnQ() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData bnQ = fVar.dlg().bnQ();
        String userId = bnQ.getUserId();
        HashMap<String, MetaData> userMap = fVar.dlg().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = bnQ;
        }
        postData.JE(1);
        postData.setId(fVar.dlg().bog());
        postData.setTitle(fVar.dlg().getTitle());
        postData.setTime(fVar.dlg().getCreateTime());
        postData.a(metaData);
        return postData;
    }
}
