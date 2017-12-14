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
    private com.baidu.tbadk.widget.vote.b aWw;
    private PbActivity eVp;
    private View hbG;
    private VotePhotoGroupView hbH;
    private VoteTextGroupView hbI;
    private VoteView hbJ;
    private TextView hbK;
    private TextView hbL;
    private TextView hbM;
    private VoteDataInfo hbN;
    private final List<b> hbO;
    private boolean hbP;
    private d hbQ;
    private final com.baidu.adp.framework.listener.a hbR;
    private long mForumId;
    private final View.OnClickListener mOnClickListener;
    private int mSkinType;
    private long mThreadId;
    private int maxWidth;

    public void setVisibility(int i) {
        if (this.hbG != null) {
            this.hbG.setVisibility(i);
        }
    }

    public void bEO() {
        if (this.hbH != null) {
            this.hbH.setPadding(0, 0, 0, 0);
        }
    }

    public a(PbActivity pbActivity) {
        super(pbActivity.getPageContext());
        this.mSkinType = 3;
        this.hbO = new ArrayList();
        this.hbP = false;
        this.maxWidth = 0;
        this.aWw = new com.baidu.tbadk.widget.vote.b() { // from class: com.baidu.tieba.vote.a.2
            @Override // com.baidu.tbadk.widget.vote.b
            public void a(com.baidu.tbadk.widget.vote.a aVar, int i, boolean z) {
                if (a.this.hbN != null && a.this.hbN.getOptions() != null && i >= 0 && i < a.this.hbN.getOptions().size()) {
                    ((b) a.this.hbN.getOptions().get(i)).setSelected(z);
                }
            }
        };
        this.hbR = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_ADD_VOTE, 309006) { // from class: com.baidu.tieba.vote.a.3
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                a.this.hbP = false;
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
                if (view.getId() == d.g.btn_pb_vote && a.this.eVp != null && a.this.eVp.checkUpIsLogin() && a.this.hbN != null && a.this.mForumId > 0 && a.this.mThreadId > 0 && !a.this.hbP) {
                    AddVoteModel addVoteModel = new AddVoteModel(a.this.eVp);
                    StringBuilder sb = new StringBuilder();
                    List<com.baidu.tbadk.widget.vote.a> options = a.this.hbN.getOptions();
                    if (options != null) {
                        for (com.baidu.tbadk.widget.vote.a aVar : options) {
                            if (aVar != null && aVar.isSelected()) {
                                sb.append(aVar.getId()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                                a.this.hbO.add((b) aVar);
                                if (a.this.hbN.getIsMulti() != 1) {
                                    break;
                                }
                            }
                        }
                        if (sb.toString().endsWith(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                            sb.deleteCharAt(sb.length() - 1);
                        }
                        if (TextUtils.isEmpty(sb.toString())) {
                            UtilHelper.showToast(a.this.eVp.getActivity(), d.j.vote_checked_less_one);
                            return;
                        }
                        addVoteModel.a(a.this.mForumId, a.this.mThreadId, sb.toString());
                        a.this.hbP = true;
                    }
                }
            }
        };
        this.eVp = pbActivity;
        pbActivity.registerListener(this.hbR);
        this.maxWidth = l.ac(TbadkCoreApplication.getInst()) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds120);
        this.hbQ = new com.baidu.tbadk.core.view.d();
    }

    public void a(View view, f fVar) {
        if (fVar != null && fVar.aRo() != null && fVar.aRq() != null && view != null) {
            this.mForumId = com.baidu.adp.lib.g.b.c(fVar.aRo().getId(), 0L);
            this.mThreadId = com.baidu.adp.lib.g.b.c(fVar.aRq().getId(), 0L);
            if (fVar.aRq().sh() && fVar.aRq().rh() != null) {
                if (this.hbG == null) {
                    this.hbG = ((ViewStub) view.findViewById(d.g.vote_card_layout)).inflate();
                    this.hbM = (TextView) this.hbG.findViewById(d.g.btn_pb_vote);
                    this.hbN = fVar.aRn();
                    b((PostData) v.c(fVar.aRs(), 0), this.hbG);
                    a(this.hbN, false);
                }
                if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                    onChangeSkinType();
                }
                this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
                if (!this.hbG.isShown()) {
                    this.hbG.setVisibility(0);
                }
            } else if (this.hbG != null && this.hbG.isShown()) {
                this.hbG.setVisibility(8);
            }
        }
    }

    private void b(PostData postData, View view) {
        this.hbK = (TextView) view.findViewById(d.g.pb_item_vote_reply_time);
        this.hbL = (TextView) view.findViewById(d.g.pb_item_vote_location_address);
        i iVar = null;
        if (postData != null) {
            this.hbK.setText(postData.bwX());
            iVar = postData.bwZ();
        }
        if (iVar != null && !TextUtils.isEmpty(iVar.getName()) && !TextUtils.isEmpty(iVar.getName().trim())) {
            final String name = iVar.getName();
            final String lat = iVar.getLat();
            final String lng = iVar.getLng();
            this.hbL.setVisibility(0);
            this.hbL.setText(iVar.getName());
            this.hbL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.vote.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (TbadkCoreApplication.getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(lat) && !StringUtils.isNull(lng)) {
                        if (!j.hh()) {
                            a.this.eVp.showToast(d.j.neterror);
                        } else {
                            com.baidu.tbadk.browser.a.O(a.this.eVp.getPageContext().getPageActivity(), String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", lat + Constants.ACCEPT_TIME_SEPARATOR_SP + lng, name, name, a.this.mContext.getString(d.j.app_info_for_map)));
                        }
                    }
                }
            });
            return;
        }
        this.hbL.setVisibility(8);
    }

    private void a(VoteDataInfo voteDataInfo, boolean z) {
        this.hbN = voteDataInfo;
        if (this.hbN != null) {
            if (this.hbN.getStatus() == 2 || this.hbN.getIsPolled() == 0) {
                for (com.baidu.tbadk.widget.vote.a aVar : this.hbN.getOptions()) {
                    if (aVar != null && (aVar instanceof b)) {
                        ((b) aVar).setSelected(false);
                    }
                }
            }
            bca();
            if (this.hbN.getVoteType() == 1) {
                if (this.hbN.getStatus() == 2 || this.hbN.getIsPolled() == 1) {
                    nQ(z);
                } else {
                    bEP();
                }
            } else if (this.hbN.getVoteType() == 2) {
                if (this.hbN.getStatus() == 2 || this.hbN.getIsPolled() == 1) {
                    G(2, z);
                } else {
                    G(this.hbN.getIsMulti() == 1 ? 1 : 3, z);
                }
            }
        }
    }

    private void G(int i, boolean z) {
        if (this.hbG != null && this.hbN != null) {
            this.hbH = (VotePhotoGroupView) this.hbG.findViewById(d.g.picvote_view);
            this.hbH.setOnVoteCheckedChangedListener(this.aWw);
            this.hbH.setVisibility(0);
            this.hbH.setMode(i);
            this.hbH.a(this.hbN.getOptions(), z, this.hbN.getIsPolled() == 1);
        }
    }

    private void bca() {
        if (this.hbG != null && this.hbN != null) {
            ((TextView) this.hbG.findViewById(d.g.tv_vote_endtime)).setText(this.hbN.getTips());
            ((TextView) this.hbG.findViewById(d.g.vote_num)).setText(getPageContext().getPageActivity().getString(d.j.pb_vote_num, new Object[]{Long.valueOf(this.hbN.getTotalNum())}));
            bER();
        }
    }

    private void bEP() {
        if (this.hbG != null && this.hbN != null) {
            this.hbI = (VoteTextGroupView) this.hbG.findViewById(d.g.textvote_view);
            this.hbI.setOnVoteCheckedChangedListener(this.aWw);
            this.hbI.setVisibility(0);
            this.hbI.setMode(this.hbN.getIsMulti() == 1 ? 1 : 2);
            this.hbI.J(this.hbN.getOptions());
            this.hbI.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void nQ(boolean z) {
        if (this.hbG != null && this.hbN != null) {
            this.hbH = (VotePhotoGroupView) this.hbG.findViewById(d.g.picvote_view);
            this.hbI = (VoteTextGroupView) this.hbG.findViewById(d.g.textvote_view);
            this.hbJ = (VoteView) this.hbG.findViewById(d.g.result_vote_view);
            this.hbI.setVisibility(8);
            this.hbH.setVisibility(8);
            this.hbJ.setVisibility(0);
            this.hbJ.setWidth(this.maxWidth);
            this.hbJ.b(this.hbN.getOptions(), z);
            this.hbJ.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEQ() {
        if (this.hbN != null) {
            if (this.hbQ != null && this.eVp != null) {
                this.hbQ.c(this.eVp.getActivity().getString(d.j.vote_succ));
            }
            this.hbN.setIsPolled(1);
            this.hbN.setTotalNum(this.hbN.getTotalNum() + 1);
            this.hbN.setTotalPoll(this.hbN.getTotalPoll() + this.hbO.size());
            for (b bVar : this.hbO) {
                if (bVar != null) {
                    bVar.setNum(bVar.getNum() + 1);
                }
            }
            if (this.hbN.getTotalPoll() > 0) {
                for (com.baidu.tbadk.widget.vote.a aVar : this.hbN.getOptions()) {
                    if (aVar instanceof b) {
                        b bVar2 = (b) aVar;
                        bVar2.setPercent((int) ((bVar2.getNum() * 100) / this.hbN.getTotalPoll()));
                    }
                }
            }
            a(this.hbN, true);
            this.hbO.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkMessageIsBelongToCurPage(ResponsedMessage<?> responsedMessage) {
        return (responsedMessage == null || this.mContext == null || responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() != this.mContext.getUniqueId()) ? false : true;
    }

    public void onChangeSkinType() {
        if (this.hbG != null) {
            com.baidu.tbadk.n.a.a(this.eVp.getPageContext(), this.hbG);
        }
        bER();
    }

    private void bER() {
        if (this.hbM != null && this.hbN != null) {
            if (this.hbN.getStatus() == 2) {
                aj.j(this.hbM, d.f.bg_gray_circle);
                this.hbM.setText(getPageContext().getString(d.j.pb_vote_over));
                this.hbM.setEnabled(false);
            } else if (this.hbN.getIsPolled() == 1) {
                aj.j(this.hbM, d.f.bg_gray_circle);
                this.hbM.setText(getPageContext().getString(d.j.pb_voted));
                this.hbM.setEnabled(false);
            } else if (this.hbN.getIsPolled() == 0) {
                aj.j(this.hbM, d.f.btn_pb_vote_selector);
                this.hbM.setText(getPageContext().getString(d.j.vote));
                this.hbM.setEnabled(true);
                this.hbM.setOnClickListener(this.mOnClickListener);
            }
            aj.c(this.hbM, d.C0096d.cp_cont_i, 1);
        }
    }
}
