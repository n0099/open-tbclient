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
import com.baidu.tbadk.core.view.d;
import com.baidu.tbadk.data.i;
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
/* loaded from: classes.dex */
public class a extends c<PbActivity> {
    private com.baidu.tbadk.widget.vote.b aWA;
    private PbActivity eVu;
    private View hbL;
    private VotePhotoGroupView hbM;
    private VoteTextGroupView hbN;
    private VoteView hbO;
    private TextView hbP;
    private TextView hbQ;
    private TextView hbR;
    private VoteDataInfo hbS;
    private final List<b> hbT;
    private boolean hbU;
    private d hbV;
    private final com.baidu.adp.framework.listener.a hbW;
    private long mForumId;
    private final View.OnClickListener mOnClickListener;
    private int mSkinType;
    private long mThreadId;
    private int maxWidth;

    public void setVisibility(int i) {
        if (this.hbL != null) {
            this.hbL.setVisibility(i);
        }
    }

    public void bEO() {
        if (this.hbM != null) {
            this.hbM.setPadding(0, 0, 0, 0);
        }
    }

    public a(PbActivity pbActivity) {
        super(pbActivity.getPageContext());
        this.mSkinType = 3;
        this.hbT = new ArrayList();
        this.hbU = false;
        this.maxWidth = 0;
        this.aWA = new com.baidu.tbadk.widget.vote.b() { // from class: com.baidu.tieba.vote.a.2
            @Override // com.baidu.tbadk.widget.vote.b
            public void a(com.baidu.tbadk.widget.vote.a aVar, int i, boolean z) {
                if (a.this.hbS != null && a.this.hbS.getOptions() != null && i >= 0 && i < a.this.hbS.getOptions().size()) {
                    ((b) a.this.hbS.getOptions().get(i)).setSelected(z);
                }
            }
        };
        this.hbW = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_ADD_VOTE, 309006) { // from class: com.baidu.tieba.vote.a.3
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                a.this.hbU = false;
                if (a.this.checkMessageIsBelongToCurPage(responsedMessage)) {
                    if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                        String errorString = responsedMessage.getErrorString();
                        String string = TbadkCoreApplication.getInst().getString(d.j.neterror);
                        if (!StringUtils.isNull(errorString)) {
                            string = errorString;
                        }
                        l.showToast(TbadkCoreApplication.getInst(), string);
                    } else if (responsedMessage instanceof AddVoteHttpProtoResponse) {
                        a.this.bEQ();
                    } else if (responsedMessage instanceof AddVoteSocketResponse) {
                        a.this.bEQ();
                    }
                }
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.vote.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == d.g.btn_pb_vote && a.this.eVu != null && a.this.eVu.checkUpIsLogin() && a.this.hbS != null && a.this.mForumId > 0 && a.this.mThreadId > 0 && !a.this.hbU) {
                    AddVoteModel addVoteModel = new AddVoteModel(a.this.eVu);
                    StringBuilder sb = new StringBuilder();
                    List<com.baidu.tbadk.widget.vote.a> options = a.this.hbS.getOptions();
                    if (options != null) {
                        for (com.baidu.tbadk.widget.vote.a aVar : options) {
                            if (aVar != null && aVar.isSelected()) {
                                sb.append(aVar.getId()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                                a.this.hbT.add((b) aVar);
                                if (a.this.hbS.getIsMulti() != 1) {
                                    break;
                                }
                            }
                        }
                        if (sb.toString().endsWith(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                            sb.deleteCharAt(sb.length() - 1);
                        }
                        if (TextUtils.isEmpty(sb.toString())) {
                            UtilHelper.showToast(a.this.eVu.getActivity(), d.j.vote_checked_less_one);
                            return;
                        }
                        addVoteModel.a(a.this.mForumId, a.this.mThreadId, sb.toString());
                        a.this.hbU = true;
                    }
                }
            }
        };
        this.eVu = pbActivity;
        pbActivity.registerListener(this.hbW);
        this.maxWidth = l.ac(TbadkCoreApplication.getInst()) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds120);
        this.hbV = new com.baidu.tbadk.core.view.d();
    }

    public void a(View view, f fVar) {
        if (fVar != null && fVar.aRo() != null && fVar.aRq() != null && view != null) {
            this.mForumId = com.baidu.adp.lib.g.b.c(fVar.aRo().getId(), 0L);
            this.mThreadId = com.baidu.adp.lib.g.b.c(fVar.aRq().getId(), 0L);
            if (fVar.aRq().sh() && fVar.aRq().rh() != null) {
                if (this.hbL == null) {
                    this.hbL = ((ViewStub) view.findViewById(d.g.vote_card_layout)).inflate();
                    this.hbR = (TextView) this.hbL.findViewById(d.g.btn_pb_vote);
                    this.hbS = fVar.aRn();
                    b((PostData) v.c(fVar.aRs(), 0), this.hbL);
                    a(this.hbS, false);
                }
                if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                    onChangeSkinType();
                }
                this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
                if (!this.hbL.isShown()) {
                    this.hbL.setVisibility(0);
                }
            } else if (this.hbL != null && this.hbL.isShown()) {
                this.hbL.setVisibility(8);
            }
        }
    }

    private void b(PostData postData, View view) {
        this.hbP = (TextView) view.findViewById(d.g.pb_item_vote_reply_time);
        this.hbQ = (TextView) view.findViewById(d.g.pb_item_vote_location_address);
        i iVar = null;
        if (postData != null) {
            this.hbP.setText(postData.bwX());
            iVar = postData.bwZ();
        }
        if (iVar != null && !TextUtils.isEmpty(iVar.getName()) && !TextUtils.isEmpty(iVar.getName().trim())) {
            final String name = iVar.getName();
            final String lat = iVar.getLat();
            final String lng = iVar.getLng();
            this.hbQ.setVisibility(0);
            this.hbQ.setText(iVar.getName());
            this.hbQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.vote.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (TbadkCoreApplication.getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(lat) && !StringUtils.isNull(lng)) {
                        if (!j.hh()) {
                            a.this.eVu.showToast(d.j.neterror);
                        } else {
                            com.baidu.tbadk.browser.a.O(a.this.eVu.getPageContext().getPageActivity(), String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", lat + Constants.ACCEPT_TIME_SEPARATOR_SP + lng, name, name, a.this.mContext.getString(d.j.app_info_for_map)));
                        }
                    }
                }
            });
            return;
        }
        this.hbQ.setVisibility(8);
    }

    private void a(VoteDataInfo voteDataInfo, boolean z) {
        this.hbS = voteDataInfo;
        if (this.hbS != null) {
            if (this.hbS.getStatus() == 2 || this.hbS.getIsPolled() == 0) {
                for (com.baidu.tbadk.widget.vote.a aVar : this.hbS.getOptions()) {
                    if (aVar != null && (aVar instanceof b)) {
                        ((b) aVar).setSelected(false);
                    }
                }
            }
            bca();
            if (this.hbS.getVoteType() == 1) {
                if (this.hbS.getStatus() == 2 || this.hbS.getIsPolled() == 1) {
                    nQ(z);
                } else {
                    bEP();
                }
            } else if (this.hbS.getVoteType() == 2) {
                if (this.hbS.getStatus() == 2 || this.hbS.getIsPolled() == 1) {
                    G(2, z);
                } else {
                    G(this.hbS.getIsMulti() == 1 ? 1 : 3, z);
                }
            }
        }
    }

    private void G(int i, boolean z) {
        if (this.hbL != null && this.hbS != null) {
            this.hbM = (VotePhotoGroupView) this.hbL.findViewById(d.g.picvote_view);
            this.hbM.setOnVoteCheckedChangedListener(this.aWA);
            this.hbM.setVisibility(0);
            this.hbM.setMode(i);
            this.hbM.a(this.hbS.getOptions(), z, this.hbS.getIsPolled() == 1);
        }
    }

    private void bca() {
        if (this.hbL != null && this.hbS != null) {
            ((TextView) this.hbL.findViewById(d.g.tv_vote_endtime)).setText(this.hbS.getTips());
            ((TextView) this.hbL.findViewById(d.g.vote_num)).setText(getPageContext().getPageActivity().getString(d.j.pb_vote_num, new Object[]{Long.valueOf(this.hbS.getTotalNum())}));
            bER();
        }
    }

    private void bEP() {
        if (this.hbL != null && this.hbS != null) {
            this.hbN = (VoteTextGroupView) this.hbL.findViewById(d.g.textvote_view);
            this.hbN.setOnVoteCheckedChangedListener(this.aWA);
            this.hbN.setVisibility(0);
            this.hbN.setMode(this.hbS.getIsMulti() == 1 ? 1 : 2);
            this.hbN.J(this.hbS.getOptions());
            this.hbN.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void nQ(boolean z) {
        if (this.hbL != null && this.hbS != null) {
            this.hbM = (VotePhotoGroupView) this.hbL.findViewById(d.g.picvote_view);
            this.hbN = (VoteTextGroupView) this.hbL.findViewById(d.g.textvote_view);
            this.hbO = (VoteView) this.hbL.findViewById(d.g.result_vote_view);
            this.hbN.setVisibility(8);
            this.hbM.setVisibility(8);
            this.hbO.setVisibility(0);
            this.hbO.setWidth(this.maxWidth);
            this.hbO.b(this.hbS.getOptions(), z);
            this.hbO.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEQ() {
        if (this.hbS != null) {
            if (this.hbV != null && this.eVu != null) {
                this.hbV.c(this.eVu.getActivity().getString(d.j.vote_succ));
            }
            this.hbS.setIsPolled(1);
            this.hbS.setTotalNum(this.hbS.getTotalNum() + 1);
            this.hbS.setTotalPoll(this.hbS.getTotalPoll() + this.hbT.size());
            for (b bVar : this.hbT) {
                if (bVar != null) {
                    bVar.setNum(bVar.getNum() + 1);
                }
            }
            if (this.hbS.getTotalPoll() > 0) {
                for (com.baidu.tbadk.widget.vote.a aVar : this.hbS.getOptions()) {
                    if (aVar instanceof b) {
                        b bVar2 = (b) aVar;
                        bVar2.setPercent((int) ((bVar2.getNum() * 100) / this.hbS.getTotalPoll()));
                    }
                }
            }
            a(this.hbS, true);
            this.hbT.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkMessageIsBelongToCurPage(ResponsedMessage<?> responsedMessage) {
        return (responsedMessage == null || this.mContext == null || responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() != this.mContext.getUniqueId()) ? false : true;
    }

    public void onChangeSkinType() {
        if (this.hbL != null) {
            com.baidu.tbadk.n.a.a(this.eVu.getPageContext(), this.hbL);
        }
        bER();
    }

    private void bER() {
        if (this.hbR != null && this.hbS != null) {
            if (this.hbS.getStatus() == 2) {
                aj.j(this.hbR, d.f.bg_gray_circle);
                this.hbR.setText(getPageContext().getString(d.j.pb_vote_over));
                this.hbR.setEnabled(false);
            } else if (this.hbS.getIsPolled() == 1) {
                aj.j(this.hbR, d.f.bg_gray_circle);
                this.hbR.setText(getPageContext().getString(d.j.pb_voted));
                this.hbR.setEnabled(false);
            } else if (this.hbS.getIsPolled() == 0) {
                aj.j(this.hbR, d.f.btn_pb_vote_selector);
                this.hbR.setText(getPageContext().getString(d.j.vote));
                this.hbR.setEnabled(true);
                this.hbR.setOnClickListener(this.mOnClickListener);
            }
            aj.c(this.hbR, d.C0095d.cp_cont_i, 1);
        }
    }
}
