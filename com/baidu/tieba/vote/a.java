package com.baidu.tieba.vote;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import com.baidu.adp.base.c;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.e;
import com.baidu.tbadk.widget.vote.VotePhotoGroupView;
import com.baidu.tbadk.widget.vote.VoteTextGroupView;
import com.baidu.tbadk.widget.vote.VoteView;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a extends c<PbActivity> {
    private com.baidu.tbadk.widget.vote.b bKF;
    private PbActivity fJR;
    private View hzJ;
    private VotePhotoGroupView hzK;
    private VoteTextGroupView hzL;
    private VoteView hzM;
    private TextView hzN;
    private TextView hzO;
    private TextView hzP;
    private VoteDataInfo hzQ;
    private final List<b> hzR;
    private boolean hzS;
    private e hzT;
    private final com.baidu.adp.framework.listener.a hzU;
    private long mForumId;
    private final View.OnClickListener mOnClickListener;
    private int mSkinType;
    private long mThreadId;
    private int maxWidth;

    public void setVisibility(int i) {
        if (this.hzJ != null) {
            this.hzJ.setVisibility(i);
        }
    }

    public void bDZ() {
        if (this.hzK != null) {
            this.hzK.setPadding(0, 0, 0, 0);
        }
    }

    public a(PbActivity pbActivity) {
        super(pbActivity.getPageContext());
        this.mSkinType = 3;
        this.hzR = new ArrayList();
        this.hzS = false;
        this.maxWidth = 0;
        this.bKF = new com.baidu.tbadk.widget.vote.b() { // from class: com.baidu.tieba.vote.a.2
            @Override // com.baidu.tbadk.widget.vote.b
            public void a(com.baidu.tbadk.widget.vote.a aVar, int i, boolean z) {
                if (a.this.hzQ != null && a.this.hzQ.getOptions() != null && i >= 0 && i < a.this.hzQ.getOptions().size()) {
                    ((b) a.this.hzQ.getOptions().get(i)).setSelected(z);
                }
            }
        };
        this.hzU = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_ADD_VOTE, 309006) { // from class: com.baidu.tieba.vote.a.3
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                a.this.hzS = false;
                if (a.this.checkMessageIsBelongToCurPage(responsedMessage)) {
                    if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                        String errorString = responsedMessage.getErrorString();
                        String string = TbadkCoreApplication.getInst().getString(d.j.neterror);
                        if (!StringUtils.isNull(errorString)) {
                            string = errorString;
                        }
                        l.showToast(TbadkCoreApplication.getInst(), string);
                    } else if (responsedMessage instanceof AddVoteHttpProtoResponse) {
                        a.this.bEb();
                    } else if (responsedMessage instanceof AddVoteSocketResponse) {
                        a.this.bEb();
                    }
                }
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.vote.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == d.g.btn_pb_vote && a.this.fJR != null && a.this.fJR.checkUpIsLogin() && a.this.hzQ != null && a.this.mForumId > 0 && a.this.mThreadId > 0 && !a.this.hzS) {
                    AddVoteModel addVoteModel = new AddVoteModel(a.this.fJR);
                    StringBuilder sb = new StringBuilder();
                    List<com.baidu.tbadk.widget.vote.a> options = a.this.hzQ.getOptions();
                    if (options != null) {
                        for (com.baidu.tbadk.widget.vote.a aVar : options) {
                            if (aVar != null && aVar.isSelected()) {
                                sb.append(aVar.getId()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                                a.this.hzR.add((b) aVar);
                                if (a.this.hzQ.getIsMulti() != 1) {
                                    break;
                                }
                            }
                        }
                        if (sb.toString().endsWith(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                            sb.deleteCharAt(sb.length() - 1);
                        }
                        if (TextUtils.isEmpty(sb.toString())) {
                            UtilHelper.showToast(a.this.fJR.getActivity(), d.j.vote_checked_less_one);
                            return;
                        }
                        addVoteModel.a(a.this.mForumId, a.this.mThreadId, sb.toString());
                        a.this.hzS = true;
                    }
                }
            }
        };
        this.fJR = pbActivity;
        pbActivity.registerListener(this.hzU);
        this.maxWidth = l.ao(TbadkCoreApplication.getInst()) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds120);
        this.hzT = new e();
    }

    public void a(View view, f fVar) {
        if (fVar != null && fVar.aYJ() != null && fVar.aYL() != null && view != null) {
            this.mForumId = com.baidu.adp.lib.g.b.c(fVar.aYJ().getId(), 0L);
            this.mThreadId = com.baidu.adp.lib.g.b.c(fVar.aYL().getId(), 0L);
            if (fVar.aYL().zF() && fVar.aYL().yF() != null) {
                if (this.hzJ == null) {
                    this.hzJ = ((ViewStub) view.findViewById(d.g.vote_card_layout)).inflate();
                    this.hzP = (TextView) this.hzJ.findViewById(d.g.btn_pb_vote);
                    this.hzQ = fVar.aYI();
                    b((PostData) v.f(fVar.aYN(), 0), this.hzJ);
                    a(this.hzQ, false);
                }
                if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                    onChangeSkinType();
                }
                this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
                if (!this.hzJ.isShown()) {
                    this.hzJ.setVisibility(0);
                }
            } else if (this.hzJ != null && this.hzJ.isShown()) {
                this.hzJ.setVisibility(8);
            }
        }
    }

    private void b(PostData postData, View view) {
        this.hzN = (TextView) view.findViewById(d.g.pb_item_vote_reply_time);
        this.hzO = (TextView) view.findViewById(d.g.pb_item_vote_location_address);
        com.baidu.tbadk.data.f fVar = null;
        if (postData != null) {
            this.hzN.setText(postData.bvL());
            fVar = postData.bvN();
        }
        if (fVar != null && !TextUtils.isEmpty(fVar.getName()) && !TextUtils.isEmpty(fVar.getName().trim())) {
            final String name = fVar.getName();
            final String lat = fVar.getLat();
            final String lng = fVar.getLng();
            this.hzO.setVisibility(0);
            this.hzO.setText(fVar.getName());
            this.hzO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.vote.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (TbadkCoreApplication.getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(lat) && !StringUtils.isNull(lng)) {
                        if (!j.oJ()) {
                            a.this.fJR.showToast(d.j.neterror);
                        } else {
                            com.baidu.tbadk.browser.a.P(a.this.fJR.getPageContext().getPageActivity(), String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", lat + Constants.ACCEPT_TIME_SEPARATOR_SP + lng, name, name, a.this.mContext.getString(d.j.app_info_for_map)));
                        }
                    }
                }
            });
            return;
        }
        this.hzO.setVisibility(8);
    }

    private void a(VoteDataInfo voteDataInfo, boolean z) {
        this.hzQ = voteDataInfo;
        if (this.hzQ != null) {
            if (this.hzQ.getStatus() == 2 || this.hzQ.getIsPolled() == 0) {
                for (com.baidu.tbadk.widget.vote.a aVar : this.hzQ.getOptions()) {
                    if (aVar != null && (aVar instanceof b)) {
                        ((b) aVar).setSelected(false);
                    }
                }
            }
            bjv();
            if (this.hzQ.getVoteType() == 1) {
                if (this.hzQ.getStatus() == 2 || this.hzQ.getIsPolled() == 1) {
                    nq(z);
                } else {
                    bEa();
                }
            } else if (this.hzQ.getVoteType() == 2) {
                if (this.hzQ.getStatus() == 2 || this.hzQ.getIsPolled() == 1) {
                    R(2, z);
                } else {
                    R(this.hzQ.getIsMulti() == 1 ? 1 : 3, z);
                }
            }
        }
    }

    private void R(int i, boolean z) {
        if (this.hzJ != null && this.hzQ != null) {
            this.hzK = (VotePhotoGroupView) this.hzJ.findViewById(d.g.picvote_view);
            this.hzK.setOnVoteCheckedChangedListener(this.bKF);
            this.hzK.setVisibility(0);
            this.hzK.setMode(i);
            this.hzK.a(this.hzQ.getOptions(), z, this.hzQ.getIsPolled() == 1);
        }
    }

    private void bjv() {
        if (this.hzJ != null && this.hzQ != null) {
            ((TextView) this.hzJ.findViewById(d.g.tv_vote_endtime)).setText(this.hzQ.getTips());
            ((TextView) this.hzJ.findViewById(d.g.vote_num)).setText(getPageContext().getPageActivity().getString(d.j.pb_vote_num, new Object[]{Long.valueOf(this.hzQ.getTotalNum())}));
            bEc();
        }
    }

    private void bEa() {
        if (this.hzJ != null && this.hzQ != null) {
            this.hzL = (VoteTextGroupView) this.hzJ.findViewById(d.g.textvote_view);
            this.hzL.setOnVoteCheckedChangedListener(this.bKF);
            this.hzL.setVisibility(0);
            this.hzL.setMode(this.hzQ.getIsMulti() == 1 ? 1 : 2);
            this.hzL.Q(this.hzQ.getOptions());
            this.hzL.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void nq(boolean z) {
        if (this.hzJ != null && this.hzQ != null) {
            this.hzK = (VotePhotoGroupView) this.hzJ.findViewById(d.g.picvote_view);
            this.hzL = (VoteTextGroupView) this.hzJ.findViewById(d.g.textvote_view);
            this.hzM = (VoteView) this.hzJ.findViewById(d.g.result_vote_view);
            this.hzL.setVisibility(8);
            this.hzK.setVisibility(8);
            this.hzM.setVisibility(0);
            this.hzM.setWidth(this.maxWidth);
            this.hzM.b(this.hzQ.getOptions(), z);
            this.hzM.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEb() {
        if (this.hzQ != null) {
            if (this.hzT != null && this.fJR != null) {
                this.hzT.q(this.fJR.getActivity().getString(d.j.vote_succ));
            }
            this.hzQ.setIsPolled(1);
            this.hzQ.setTotalNum(this.hzQ.getTotalNum() + 1);
            this.hzQ.setTotalPoll(this.hzQ.getTotalPoll() + this.hzR.size());
            for (b bVar : this.hzR) {
                if (bVar != null) {
                    bVar.setNum(bVar.getNum() + 1);
                }
            }
            if (this.hzQ.getTotalPoll() > 0) {
                for (com.baidu.tbadk.widget.vote.a aVar : this.hzQ.getOptions()) {
                    if (aVar instanceof b) {
                        b bVar2 = (b) aVar;
                        bVar2.setPercent((int) ((bVar2.getNum() * 100) / this.hzQ.getTotalPoll()));
                    }
                }
            }
            a(this.hzQ, true);
            this.hzR.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkMessageIsBelongToCurPage(ResponsedMessage<?> responsedMessage) {
        return (responsedMessage == null || this.mContext == null || responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() != this.mContext.getUniqueId()) ? false : true;
    }

    public void onChangeSkinType() {
        if (this.hzJ != null) {
            com.baidu.tbadk.n.a.a(this.fJR.getPageContext(), this.hzJ);
        }
        bEc();
    }

    private void bEc() {
        if (this.hzP != null && this.hzQ != null) {
            if (this.hzQ.getStatus() == 2) {
                aj.s(this.hzP, d.f.bg_gray_circle);
                this.hzP.setText(getPageContext().getString(d.j.pb_vote_over));
                this.hzP.setEnabled(false);
            } else if (this.hzQ.getIsPolled() == 1) {
                aj.s(this.hzP, d.f.bg_gray_circle);
                this.hzP.setText(getPageContext().getString(d.j.pb_voted));
                this.hzP.setEnabled(false);
            } else if (this.hzQ.getIsPolled() == 0) {
                aj.s(this.hzP, d.f.btn_pb_vote_selector);
                this.hzP.setText(getPageContext().getString(d.j.vote));
                this.hzP.setEnabled(true);
                this.hzP.setOnClickListener(this.mOnClickListener);
            }
            aj.e(this.hzP, d.C0108d.cp_cont_i, 1);
        }
    }
}
