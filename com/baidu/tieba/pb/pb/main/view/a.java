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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.util.x;
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
/* loaded from: classes2.dex */
public class a {
    private f lJI;
    private TbPageContext mPageContext;
    private View mRootView;
    private SelectRuleView maA;
    private TextView maB;
    private k man;
    private TextView mao;
    private View maq;
    private TextView mar;
    private TBSpecificationBtn mas;
    private TextView mat;
    private View mau;
    private TextView mav;
    private VoteCountDownView maw;
    private View may;
    private TextView maz;
    private int status;
    private VoteCountDownView.a maC = new VoteCountDownView.a() { // from class: com.baidu.tieba.pb.pb.main.view.a.1
        @Override // com.baidu.tieba.view.VoteCountDownView.a
        public void clr() {
            if (a.this.mRootView != null) {
                if (a.this.lJI == null || a.this.lJI.lFT == null) {
                    a.this.mRootView.setVisibility(8);
                    return;
                }
                a.this.lJI.lFT.setStatus(3);
                a.this.setData(a.this.lJI);
            }
        }
    };
    private View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.pb_jump_to_vote_page) {
                if (a.this.lJI != null && a.this.mPageContext != null && bg.checkUpIsLogin(a.this.mPageContext.getPageActivity())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921408, new BarVoteActivityConfig(a.this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(a.this.lJI.getForumId(), 0L), 3)));
                }
            } else if (view.getId() == R.id.pb_vote_button && bg.checkUpIsLogin(a.this.mPageContext.getPageActivity()) && a.this.lJI != null && a.this.man != null && a.this.lJI.dmE() != null) {
                if (a.this.man.ctS()) {
                    new aq("c13444").dX("forum_id", a.this.lJI.getForumId()).bwn();
                    d dVar = new d();
                    dVar.setThreadId(com.baidu.adp.lib.f.b.toLong(a.this.lJI.getThreadId(), 0L));
                    dVar.setForumId(com.baidu.adp.lib.f.b.toLong(a.this.lJI.getForumId(), 0L));
                    String str = "";
                    PostData L = a.this.L(a.this.lJI);
                    if (L != null && L.brq() != null) {
                        str = L.brq().getUserId();
                    }
                    dVar.hm(com.baidu.adp.lib.f.b.toLong(str, 0L));
                    dVar.GD(2);
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
    private HttpMessageListener iok = new HttpMessageListener(CmdConfigHttp.CMD_BAR_VOTE) { // from class: com.baidu.tieba.pb.pb.main.view.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            String errorString;
            if (httpResponsedMessage != null && httpResponsedMessage.getOrginalMessage() != null) {
                int error = httpResponsedMessage.getError();
                if ((httpResponsedMessage instanceof CommitVoteResMsg) && a.this.lJI != null && a.this.lJI.lFT != null && a.this.mPageContext != null && httpResponsedMessage.getOrginalMessage().getTag() == a.this.mPageContext.getUniqueId()) {
                    if (error == 0) {
                        l.showToast(TbadkCoreApplication.getInst(), R.string.bar_manager_vote_success);
                        a.this.lJI.lFT.GI(a.this.lJI.lFT.dnr() + 1);
                        a.this.lJI.lFT.pk(false);
                        a.this.setData(a.this.lJI);
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

    public View K(com.baidu.tieba.pb.data.f fVar) {
        if (this.mPageContext == null) {
            return null;
        }
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.bar_manager_select_view, (ViewGroup) null);
        this.mao = (TextView) this.mRootView.findViewById(R.id.pb_bar_manager_select_warn);
        this.maq = this.mRootView.findViewById(R.id.pb_vote_button_container);
        this.mav = (TextView) this.mRootView.findViewById(R.id.pb_count_down_title);
        this.mas = (TBSpecificationBtn) this.mRootView.findViewById(R.id.pb_vote_button);
        com.baidu.tbadk.core.view.commonBtn.a aVar = new com.baidu.tbadk.core.view.commonBtn.a();
        aVar.a(GradientDrawable.Orientation.TL_BR);
        this.mas.setText(TbadkCoreApplication.getInst().getString(R.string.pb_vote_text));
        this.mas.setTextSize(R.dimen.tbfontsize44);
        this.mas.setConfig(aVar);
        this.mar = (TextView) this.mRootView.findViewById(R.id.pb_vote_num);
        this.mat = (TextView) this.mRootView.findViewById(R.id.pb_bar_manager_ueg_tip);
        this.mau = this.mRootView.findViewById(R.id.pb_count_down_container);
        this.maw = (VoteCountDownView) this.mRootView.findViewById(R.id.pb_vote_count_down_view);
        this.may = this.mRootView.findViewById(R.id.pb_vote_rule);
        this.maz = (TextView) this.mRootView.findViewById(R.id.pb_vote_rule_title);
        this.maA = (SelectRuleView) this.mRootView.findViewById(R.id.pb_vote_rule_content);
        this.maB = (TextView) this.mRootView.findViewById(R.id.pb_jump_to_vote_page);
        if (this.iok != null) {
            if (this.mPageContext.getPageActivity() instanceof BaseActivity) {
                this.iok.setTag(((BaseActivity) this.mPageContext.getPageActivity()).getUniqueId());
            } else if (this.mPageContext.getPageActivity() instanceof BaseFragmentActivity) {
                this.iok.setTag(((BaseFragmentActivity) this.mPageContext.getPageActivity()).getUniqueId());
            }
            MessageManager.getInstance().registerListener(this.iok);
        }
        setData(fVar);
        return this.mRootView;
    }

    public void setData(com.baidu.tieba.pb.data.f fVar) {
        if (this.mRootView != null) {
            if (fVar == null || fVar.lFT == null) {
                this.mRootView.setVisibility(8);
                return;
            }
            this.lJI = fVar;
            this.man = fVar.lFT;
            if (this.man.getStatus() != 0) {
                this.status = this.man.getStatus();
                if (this.status == 2) {
                    this.maq.setVisibility(8);
                    this.mau.setVisibility(0);
                    this.maw.setOnCountDownFinished(this.maC);
                    this.maw.setData(this.man.dnq() * 1000);
                    this.maB.setVisibility(8);
                } else if (this.status == 3) {
                    this.maq.setVisibility(0);
                    this.mas.setOnClickListener(this.onClickListener);
                    this.mau.setVisibility(8);
                    this.maB.setVisibility(0);
                    this.maB.setOnClickListener(this.onClickListener);
                    this.mar.setText(this.man.dnr() + "票");
                } else if (this.status == 4 || this.status == 5) {
                    this.maq.setVisibility(0);
                    this.mas.setEnabled(false);
                    this.mau.setVisibility(8);
                    this.maB.setVisibility(0);
                    this.maB.setOnClickListener(this.onClickListener);
                    this.mar.setText(this.man.dnr() + "票");
                } else if (this.status == 6) {
                    this.maq.setVisibility(0);
                    this.mas.setEnabled(false);
                    this.mau.setVisibility(8);
                    this.mar.setText(this.man.dnr() + "票");
                    this.maB.setVisibility(8);
                } else {
                    this.mRootView.setVisibility(8);
                    return;
                }
                if (!x.isEmpty(this.man.dnt()) || !x.isEmpty(this.man.dnu())) {
                    this.maA.setColumn(2);
                    this.maA.setData(this.man.dnt(), this.man.dnu());
                }
                vU(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public void vU(int i) {
        ao.setViewTextColor(this.mar, R.color.CAM_X0304, 1, i);
        ao.setViewTextColor(this.mao, R.color.CAM_X0109, 1, i);
        ao.setViewTextColor(this.mat, R.color.CAM_X0109, 1, i);
        ao.setViewTextColor(this.maz, R.color.CAM_X0105, 1, i);
        ao.setViewTextColor(this.maB, R.color.CAM_X0304, 1, i);
        ao.setViewTextColor(this.mav, R.color.CAM_X0105, 1, i);
        if (this.mas != null) {
            this.mas.bxO();
        }
        ao.setBackgroundColor(this.may, R.color.CAM_X0206, i);
        if (this.maw != null) {
            this.maw.vU(i);
        }
        if (this.maA != null) {
            this.maA.ti(i);
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
        if (fVar.dmR() != null) {
            return fVar.dmR();
        }
        if (!x.isEmpty(fVar.dmG())) {
            Iterator<PostData> it = fVar.dmG().iterator();
            while (it.hasNext()) {
                postData = it.next();
                if (postData != null && postData.dPd() == 1) {
                    break;
                }
            }
        }
        postData = null;
        if (postData == null) {
            postData = fVar.dmN();
        }
        if (postData == null) {
            postData = a(fVar);
        }
        if (postData != null && postData.brq() != null && postData.brq().getUserTbVipInfoData() != null && postData.brq().getUserTbVipInfoData().getvipIntro() != null) {
            postData.brq().getGodUserData().setIntro(postData.brq().getUserTbVipInfoData().getvipIntro());
            return postData;
        }
        return postData;
    }

    private PostData a(com.baidu.tieba.pb.data.f fVar) {
        MetaData metaData;
        if (fVar == null || fVar.dmE() == null || fVar.dmE().brq() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData brq = fVar.dmE().brq();
        String userId = brq.getUserId();
        HashMap<String, MetaData> userMap = fVar.dmE().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = brq;
        }
        postData.KR(1);
        postData.setId(fVar.dmE().brG());
        postData.setTitle(fVar.dmE().getTitle());
        postData.setTime(fVar.dmE().getCreateTime());
        postData.a(metaData);
        return postData;
    }
}
