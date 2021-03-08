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
    private f lQk;
    private TbPageContext mPageContext;
    private View mRootView;
    private l mhd;
    private TextView mhe;
    private View mhf;
    private TextView mhg;
    private TBSpecificationBtn mhh;
    private TextView mhi;
    private View mhj;
    private TextView mhk;
    private VoteCountDownView mhl;
    private View mhm;
    private TextView mhn;
    private SelectRuleView mho;
    private TextView mhp;
    private int status;
    private VoteCountDownView.a mhq = new VoteCountDownView.a() { // from class: com.baidu.tieba.pb.pb.main.view.a.1
        @Override // com.baidu.tieba.view.VoteCountDownView.a
        public void ciG() {
            if (a.this.mRootView != null) {
                if (a.this.lQk == null || a.this.lQk.lMq == null) {
                    a.this.mRootView.setVisibility(8);
                    return;
                }
                a.this.lQk.lMq.setStatus(3);
                a.this.setData(a.this.lQk);
            }
        }
    };
    private View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.pb_jump_to_vote_page) {
                if (a.this.lQk != null && a.this.mPageContext != null && bh.checkUpIsLogin(a.this.mPageContext.getPageActivity())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921408, new BarVoteActivityConfig(a.this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(a.this.lQk.getForumId(), 0L), 3)));
                }
            } else if (view.getId() == R.id.pb_vote_button && bh.checkUpIsLogin(a.this.mPageContext.getPageActivity()) && a.this.lQk != null && a.this.mhd != null && a.this.lQk.dlp() != null) {
                if (a.this.mhd.cry()) {
                    new ar("c13444").dR("forum_id", a.this.lQk.getForumId()).bsR();
                    d dVar = new d();
                    dVar.setThreadId(com.baidu.adp.lib.f.b.toLong(a.this.lQk.getThreadId(), 0L));
                    dVar.setForumId(com.baidu.adp.lib.f.b.toLong(a.this.lQk.getForumId(), 0L));
                    String str = "";
                    PostData L = a.this.L(a.this.lQk);
                    if (L != null && L.bnS() != null) {
                        str = L.bnS().getUserId();
                    }
                    dVar.hr(com.baidu.adp.lib.f.b.toLong(str, 0L));
                    dVar.Ft(2);
                    dVar.v(a.this.mPageContext.getUniqueId());
                    CustomMessage customMessage = new CustomMessage(2921411);
                    customMessage.setData(dVar);
                    MessageManager.getInstance().sendMessage(customMessage);
                    return;
                }
                com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), R.string.has_not_other_ticket);
            }
        }
    };
    private HttpMessageListener irg = new HttpMessageListener(CmdConfigHttp.CMD_BAR_VOTE) { // from class: com.baidu.tieba.pb.pb.main.view.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            String errorString;
            if (httpResponsedMessage != null && httpResponsedMessage.getOrginalMessage() != null) {
                int error = httpResponsedMessage.getError();
                if ((httpResponsedMessage instanceof CommitVoteResMsg) && a.this.lQk != null && a.this.lQk.lMq != null && a.this.mPageContext != null && httpResponsedMessage.getOrginalMessage().getTag() == a.this.mPageContext.getUniqueId()) {
                    if (error == 0) {
                        com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), R.string.bar_manager_vote_success);
                        a.this.lQk.lMq.Fy(a.this.lQk.lMq.dmc() + 1);
                        a.this.lQk.lMq.pq(false);
                        a.this.setData(a.this.lQk);
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
        this.mhe = (TextView) this.mRootView.findViewById(R.id.pb_bar_manager_select_warn);
        this.mhf = this.mRootView.findViewById(R.id.pb_vote_button_container);
        this.mhk = (TextView) this.mRootView.findViewById(R.id.pb_count_down_title);
        this.mhh = (TBSpecificationBtn) this.mRootView.findViewById(R.id.pb_vote_button);
        com.baidu.tbadk.core.view.commonBtn.a aVar = new com.baidu.tbadk.core.view.commonBtn.a();
        aVar.a(GradientDrawable.Orientation.TL_BR);
        this.mhh.setText(TbadkCoreApplication.getInst().getString(R.string.pb_vote_text));
        this.mhh.setTextSize(R.dimen.tbfontsize44);
        this.mhh.setConfig(aVar);
        this.mhg = (TextView) this.mRootView.findViewById(R.id.pb_vote_num);
        this.mhi = (TextView) this.mRootView.findViewById(R.id.pb_bar_manager_ueg_tip);
        this.mhj = this.mRootView.findViewById(R.id.pb_count_down_container);
        this.mhl = (VoteCountDownView) this.mRootView.findViewById(R.id.pb_vote_count_down_view);
        this.mhm = this.mRootView.findViewById(R.id.pb_vote_rule);
        this.mhn = (TextView) this.mRootView.findViewById(R.id.pb_vote_rule_title);
        this.mho = (SelectRuleView) this.mRootView.findViewById(R.id.pb_vote_rule_content);
        this.mhp = (TextView) this.mRootView.findViewById(R.id.pb_jump_to_vote_page);
        if (this.irg != null) {
            if (this.mPageContext.getPageActivity() instanceof BaseActivity) {
                this.irg.setTag(((BaseActivity) this.mPageContext.getPageActivity()).getUniqueId());
            } else if (this.mPageContext.getPageActivity() instanceof BaseFragmentActivity) {
                this.irg.setTag(((BaseFragmentActivity) this.mPageContext.getPageActivity()).getUniqueId());
            }
            MessageManager.getInstance().registerListener(this.irg);
        }
        setData(fVar);
        return this.mRootView;
    }

    public void setData(com.baidu.tieba.pb.data.f fVar) {
        if (this.mRootView != null) {
            if (fVar == null || fVar.lMq == null) {
                this.mRootView.setVisibility(8);
                return;
            }
            this.lQk = fVar;
            this.mhd = fVar.lMq;
            if (this.mhd.getStatus() != 0) {
                this.status = this.mhd.getStatus();
                if (this.status == 2) {
                    this.mhf.setVisibility(8);
                    this.mhj.setVisibility(0);
                    this.mhl.setOnCountDownFinished(this.mhq);
                    this.mhl.setData(this.mhd.dmb() * 1000);
                    this.mhp.setVisibility(8);
                } else if (this.status == 3) {
                    this.mhf.setVisibility(0);
                    this.mhh.setOnClickListener(this.onClickListener);
                    this.mhj.setVisibility(8);
                    this.mhp.setVisibility(0);
                    this.mhp.setOnClickListener(this.onClickListener);
                    this.mhg.setText(this.mhd.dmc() + "票");
                } else if (this.status == 4 || this.status == 5) {
                    this.mhf.setVisibility(0);
                    this.mhh.setEnabled(false);
                    this.mhj.setVisibility(8);
                    this.mhp.setVisibility(0);
                    this.mhp.setOnClickListener(this.onClickListener);
                    this.mhg.setText(this.mhd.dmc() + "票");
                } else if (this.status == 6) {
                    this.mhf.setVisibility(0);
                    this.mhh.setEnabled(false);
                    this.mhj.setVisibility(8);
                    this.mhg.setText(this.mhd.dmc() + "票");
                    this.mhp.setVisibility(8);
                } else {
                    this.mRootView.setVisibility(8);
                    return;
                }
                if (!y.isEmpty(this.mhd.dmd()) || !y.isEmpty(this.mhd.dme())) {
                    this.mho.setColumn(2);
                    this.mho.setData(this.mhd.dmd(), this.mhd.dme());
                }
                uw(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public void uw(int i) {
        ap.setViewTextColor(this.mhg, R.color.CAM_X0304, 1, i);
        ap.setViewTextColor(this.mhe, R.color.CAM_X0109, 1, i);
        ap.setViewTextColor(this.mhi, R.color.CAM_X0109, 1, i);
        ap.setViewTextColor(this.mhn, R.color.CAM_X0105, 1, i);
        ap.setViewTextColor(this.mhp, R.color.CAM_X0304, 1, i);
        ap.setViewTextColor(this.mhk, R.color.CAM_X0105, 1, i);
        if (this.mhh != null) {
            this.mhh.bus();
        }
        ap.setBackgroundColor(this.mhm, R.color.CAM_X0206, i);
        if (this.mhl != null) {
            this.mhl.uw(i);
        }
        if (this.mho != null) {
            this.mho.rJ(i);
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
        if (fVar.dlC() != null) {
            return fVar.dlC();
        }
        if (!y.isEmpty(fVar.dlr())) {
            Iterator<PostData> it = fVar.dlr().iterator();
            while (it.hasNext()) {
                postData = it.next();
                if (postData != null && postData.dNO() == 1) {
                    break;
                }
            }
        }
        postData = null;
        if (postData == null) {
            postData = fVar.dly();
        }
        if (postData == null) {
            postData = a(fVar);
        }
        if (postData != null && postData.bnS() != null && postData.bnS().getUserTbVipInfoData() != null && postData.bnS().getUserTbVipInfoData().getvipIntro() != null) {
            postData.bnS().getGodUserData().setIntro(postData.bnS().getUserTbVipInfoData().getvipIntro());
            return postData;
        }
        return postData;
    }

    private PostData a(com.baidu.tieba.pb.data.f fVar) {
        MetaData metaData;
        if (fVar == null || fVar.dlp() == null || fVar.dlp().bnS() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData bnS = fVar.dlp().bnS();
        String userId = bnS.getUserId();
        HashMap<String, MetaData> userMap = fVar.dlp().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = bnS;
        }
        postData.JJ(1);
        postData.setId(fVar.dlp().boi());
        postData.setTitle(fVar.dlp().getTitle());
        postData.setTime(fVar.dlp().getCreateTime());
        postData.a(metaData);
        return postData;
    }
}
