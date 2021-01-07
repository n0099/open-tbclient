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
    private f lJH;
    private TbPageContext mPageContext;
    private View mRootView;
    private TextView maA;
    private k mam;
    private TextView man;
    private View mao;
    private TextView maq;
    private TBSpecificationBtn mar;
    private TextView mas;
    private View mat;
    private TextView mau;
    private VoteCountDownView mav;
    private View maw;
    private TextView may;
    private SelectRuleView maz;
    private int status;
    private VoteCountDownView.a maB = new VoteCountDownView.a() { // from class: com.baidu.tieba.pb.pb.main.view.a.1
        @Override // com.baidu.tieba.view.VoteCountDownView.a
        public void cls() {
            if (a.this.mRootView != null) {
                if (a.this.lJH == null || a.this.lJH.lFS == null) {
                    a.this.mRootView.setVisibility(8);
                    return;
                }
                a.this.lJH.lFS.setStatus(3);
                a.this.setData(a.this.lJH);
            }
        }
    };
    private View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.pb_jump_to_vote_page) {
                if (a.this.lJH != null && a.this.mPageContext != null && bg.checkUpIsLogin(a.this.mPageContext.getPageActivity())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921408, new BarVoteActivityConfig(a.this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(a.this.lJH.getForumId(), 0L), 3)));
                }
            } else if (view.getId() == R.id.pb_vote_button && bg.checkUpIsLogin(a.this.mPageContext.getPageActivity()) && a.this.lJH != null && a.this.mam != null && a.this.lJH.dmF() != null) {
                if (a.this.mam.ctT()) {
                    new aq("c13444").dX("forum_id", a.this.lJH.getForumId()).bwo();
                    d dVar = new d();
                    dVar.setThreadId(com.baidu.adp.lib.f.b.toLong(a.this.lJH.getThreadId(), 0L));
                    dVar.setForumId(com.baidu.adp.lib.f.b.toLong(a.this.lJH.getForumId(), 0L));
                    String str = "";
                    PostData L = a.this.L(a.this.lJH);
                    if (L != null && L.brr() != null) {
                        str = L.brr().getUserId();
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
                if ((httpResponsedMessage instanceof CommitVoteResMsg) && a.this.lJH != null && a.this.lJH.lFS != null && a.this.mPageContext != null && httpResponsedMessage.getOrginalMessage().getTag() == a.this.mPageContext.getUniqueId()) {
                    if (error == 0) {
                        l.showToast(TbadkCoreApplication.getInst(), R.string.bar_manager_vote_success);
                        a.this.lJH.lFS.GI(a.this.lJH.lFS.dnt() + 1);
                        a.this.lJH.lFS.pk(false);
                        a.this.setData(a.this.lJH);
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
        this.man = (TextView) this.mRootView.findViewById(R.id.pb_bar_manager_select_warn);
        this.mao = this.mRootView.findViewById(R.id.pb_vote_button_container);
        this.mau = (TextView) this.mRootView.findViewById(R.id.pb_count_down_title);
        this.mar = (TBSpecificationBtn) this.mRootView.findViewById(R.id.pb_vote_button);
        com.baidu.tbadk.core.view.commonBtn.a aVar = new com.baidu.tbadk.core.view.commonBtn.a();
        aVar.a(GradientDrawable.Orientation.TL_BR);
        this.mar.setText(TbadkCoreApplication.getInst().getString(R.string.pb_vote_text));
        this.mar.setTextSize(R.dimen.tbfontsize44);
        this.mar.setConfig(aVar);
        this.maq = (TextView) this.mRootView.findViewById(R.id.pb_vote_num);
        this.mas = (TextView) this.mRootView.findViewById(R.id.pb_bar_manager_ueg_tip);
        this.mat = this.mRootView.findViewById(R.id.pb_count_down_container);
        this.mav = (VoteCountDownView) this.mRootView.findViewById(R.id.pb_vote_count_down_view);
        this.maw = this.mRootView.findViewById(R.id.pb_vote_rule);
        this.may = (TextView) this.mRootView.findViewById(R.id.pb_vote_rule_title);
        this.maz = (SelectRuleView) this.mRootView.findViewById(R.id.pb_vote_rule_content);
        this.maA = (TextView) this.mRootView.findViewById(R.id.pb_jump_to_vote_page);
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
            if (fVar == null || fVar.lFS == null) {
                this.mRootView.setVisibility(8);
                return;
            }
            this.lJH = fVar;
            this.mam = fVar.lFS;
            if (this.mam.getStatus() != 0) {
                this.status = this.mam.getStatus();
                if (this.status == 2) {
                    this.mao.setVisibility(8);
                    this.mat.setVisibility(0);
                    this.mav.setOnCountDownFinished(this.maB);
                    this.mav.setData(this.mam.dnr() * 1000);
                    this.maA.setVisibility(8);
                } else if (this.status == 3) {
                    this.mao.setVisibility(0);
                    this.mar.setOnClickListener(this.onClickListener);
                    this.mat.setVisibility(8);
                    this.maA.setVisibility(0);
                    this.maA.setOnClickListener(this.onClickListener);
                    this.maq.setText(this.mam.dnt() + "票");
                } else if (this.status == 4 || this.status == 5) {
                    this.mao.setVisibility(0);
                    this.mar.setEnabled(false);
                    this.mat.setVisibility(8);
                    this.maA.setVisibility(0);
                    this.maA.setOnClickListener(this.onClickListener);
                    this.maq.setText(this.mam.dnt() + "票");
                } else if (this.status == 6) {
                    this.mao.setVisibility(0);
                    this.mar.setEnabled(false);
                    this.mat.setVisibility(8);
                    this.maq.setText(this.mam.dnt() + "票");
                    this.maA.setVisibility(8);
                } else {
                    this.mRootView.setVisibility(8);
                    return;
                }
                if (!x.isEmpty(this.mam.dnu()) || !x.isEmpty(this.mam.dnv())) {
                    this.maz.setColumn(2);
                    this.maz.setData(this.mam.dnu(), this.mam.dnv());
                }
                vU(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public void vU(int i) {
        ao.setViewTextColor(this.maq, R.color.CAM_X0304, 1, i);
        ao.setViewTextColor(this.man, R.color.CAM_X0109, 1, i);
        ao.setViewTextColor(this.mas, R.color.CAM_X0109, 1, i);
        ao.setViewTextColor(this.may, R.color.CAM_X0105, 1, i);
        ao.setViewTextColor(this.maA, R.color.CAM_X0304, 1, i);
        ao.setViewTextColor(this.mau, R.color.CAM_X0105, 1, i);
        if (this.mar != null) {
            this.mar.bxP();
        }
        ao.setBackgroundColor(this.maw, R.color.CAM_X0206, i);
        if (this.mav != null) {
            this.mav.vU(i);
        }
        if (this.maz != null) {
            this.maz.ti(i);
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
        if (fVar.dmS() != null) {
            return fVar.dmS();
        }
        if (!x.isEmpty(fVar.dmH())) {
            Iterator<PostData> it = fVar.dmH().iterator();
            while (it.hasNext()) {
                postData = it.next();
                if (postData != null && postData.dPe() == 1) {
                    break;
                }
            }
        }
        postData = null;
        if (postData == null) {
            postData = fVar.dmO();
        }
        if (postData == null) {
            postData = a(fVar);
        }
        if (postData != null && postData.brr() != null && postData.brr().getUserTbVipInfoData() != null && postData.brr().getUserTbVipInfoData().getvipIntro() != null) {
            postData.brr().getGodUserData().setIntro(postData.brr().getUserTbVipInfoData().getvipIntro());
            return postData;
        }
        return postData;
    }

    private PostData a(com.baidu.tieba.pb.data.f fVar) {
        MetaData metaData;
        if (fVar == null || fVar.dmF() == null || fVar.dmF().brr() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData brr = fVar.dmF().brr();
        String userId = brr.getUserId();
        HashMap<String, MetaData> userMap = fVar.dmF().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = brr;
        }
        postData.KR(1);
        postData.setId(fVar.dmF().brH());
        postData.setTitle(fVar.dmF().getTitle());
        postData.setTime(fVar.dmF().getCreateTime());
        postData.a(metaData);
        return postData;
    }
}
