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
    private com.baidu.tbadk.widget.vote.b aTl;
    private PbActivity eMh;
    private View gML;
    private VotePhotoGroupView gMM;
    private VoteTextGroupView gMN;
    private VoteView gMO;
    private TextView gMP;
    private TextView gMQ;
    private TextView gMR;
    private VoteDataInfo gMS;
    private final List<b> gMT;
    private boolean gMU;
    private com.baidu.tbadk.core.view.c gMV;
    private final com.baidu.adp.framework.listener.a gMW;
    private long mForumId;
    private final View.OnClickListener mOnClickListener;
    private int mSkinType;
    private long mThreadId;
    private int maxWidth;

    public void setVisibility(int i) {
        if (this.gML != null) {
            this.gML.setVisibility(i);
        }
    }

    public void bBk() {
        if (this.gMM != null) {
            this.gMM.setPadding(0, 0, 0, 0);
        }
    }

    public a(PbActivity pbActivity) {
        super(pbActivity.getPageContext());
        this.mSkinType = 3;
        this.gMT = new ArrayList();
        this.gMU = false;
        this.maxWidth = 0;
        this.aTl = new com.baidu.tbadk.widget.vote.b() { // from class: com.baidu.tieba.vote.a.2
            @Override // com.baidu.tbadk.widget.vote.b
            public void a(com.baidu.tbadk.widget.vote.a aVar, int i, boolean z) {
                if (a.this.gMS != null && a.this.gMS.getOptions() != null && i >= 0 && i < a.this.gMS.getOptions().size()) {
                    ((b) a.this.gMS.getOptions().get(i)).setSelected(z);
                }
            }
        };
        this.gMW = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_ADD_VOTE, 309006) { // from class: com.baidu.tieba.vote.a.3
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                a.this.gMU = false;
                if (a.this.checkMessageIsBelongToCurPage(responsedMessage)) {
                    if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                        String errorString = responsedMessage.getErrorString();
                        String string = TbadkCoreApplication.getInst().getString(d.j.neterror);
                        if (!StringUtils.isNull(errorString)) {
                            string = errorString;
                        }
                        l.showToast(TbadkCoreApplication.getInst(), string);
                    } else if (responsedMessage instanceof AddVoteHttpProtoResponse) {
                        a.this.bBm();
                    } else if (responsedMessage instanceof AddVoteSocketResponse) {
                        a.this.bBm();
                    }
                }
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.vote.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == d.g.btn_pb_vote && a.this.eMh != null && a.this.eMh.checkUpIsLogin() && a.this.gMS != null && a.this.mForumId > 0 && a.this.mThreadId > 0 && !a.this.gMU) {
                    AddVoteModel addVoteModel = new AddVoteModel(a.this.eMh);
                    StringBuilder sb = new StringBuilder();
                    List<com.baidu.tbadk.widget.vote.a> options = a.this.gMS.getOptions();
                    if (options != null) {
                        for (com.baidu.tbadk.widget.vote.a aVar : options) {
                            if (aVar != null && aVar.isSelected()) {
                                sb.append(aVar.getId()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                                a.this.gMT.add((b) aVar);
                                if (a.this.gMS.getIsMulti() != 1) {
                                    break;
                                }
                            }
                        }
                        if (sb.toString().endsWith(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                            sb.deleteCharAt(sb.length() - 1);
                        }
                        if (TextUtils.isEmpty(sb.toString())) {
                            UtilHelper.showToast(a.this.eMh.getActivity(), d.j.vote_checked_less_one);
                            return;
                        }
                        addVoteModel.a(a.this.mForumId, a.this.mThreadId, sb.toString());
                        a.this.gMU = true;
                    }
                }
            }
        };
        this.eMh = pbActivity;
        pbActivity.registerListener(this.gMW);
        this.maxWidth = l.ac(TbadkCoreApplication.getInst()) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds120);
        this.gMV = new com.baidu.tbadk.core.view.c();
    }

    public void a(View view, f fVar) {
        if (fVar != null && fVar.aPM() != null && fVar.aPO() != null && view != null) {
            this.mForumId = com.baidu.adp.lib.g.b.c(fVar.aPM().getId(), 0L);
            this.mThreadId = com.baidu.adp.lib.g.b.c(fVar.aPO().getId(), 0L);
            if (fVar.aPO().sg() && fVar.aPO().rf() != null) {
                if (this.gML == null) {
                    this.gML = ((ViewStub) view.findViewById(d.g.vote_card_layout)).inflate();
                    this.gMR = (TextView) this.gML.findViewById(d.g.btn_pb_vote);
                    this.gMS = fVar.aPL();
                    b((PostData) v.c(fVar.aPQ(), 0), this.gML);
                    a(this.gMS, false);
                }
                if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                    onChangeSkinType();
                }
                this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
                if (!this.gML.isShown()) {
                    this.gML.setVisibility(0);
                }
            } else if (this.gML != null && this.gML.isShown()) {
                this.gML.setVisibility(8);
            }
        }
    }

    private void b(PostData postData, View view) {
        this.gMP = (TextView) view.findViewById(d.g.pb_item_vote_reply_time);
        this.gMQ = (TextView) view.findViewById(d.g.pb_item_vote_location_address);
        i iVar = null;
        if (postData != null) {
            this.gMP.setText(postData.buw());
            iVar = postData.bux();
        }
        if (iVar != null && !TextUtils.isEmpty(iVar.getName()) && !TextUtils.isEmpty(iVar.getName().trim())) {
            final String name = iVar.getName();
            final String lat = iVar.getLat();
            final String lng = iVar.getLng();
            this.gMQ.setVisibility(0);
            this.gMQ.setText(iVar.getName());
            this.gMQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.vote.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (TbadkCoreApplication.getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(lat) && !StringUtils.isNull(lng)) {
                        if (!j.hh()) {
                            a.this.eMh.showToast(d.j.neterror);
                        } else {
                            com.baidu.tbadk.browser.a.O(a.this.eMh.getPageContext().getPageActivity(), String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", lat + Constants.ACCEPT_TIME_SEPARATOR_SP + lng, name, name, a.this.mContext.getString(d.j.app_info_for_map)));
                        }
                    }
                }
            });
            return;
        }
        this.gMQ.setVisibility(8);
    }

    private void a(VoteDataInfo voteDataInfo, boolean z) {
        this.gMS = voteDataInfo;
        if (this.gMS != null) {
            if (this.gMS.getStatus() == 2 || this.gMS.getIsPolled() == 0) {
                for (com.baidu.tbadk.widget.vote.a aVar : this.gMS.getOptions()) {
                    if (aVar != null && (aVar instanceof b)) {
                        ((b) aVar).setSelected(false);
                    }
                }
            }
            baj();
            if (this.gMS.getVoteType() == 1) {
                if (this.gMS.getStatus() == 2 || this.gMS.getIsPolled() == 1) {
                    nf(z);
                } else {
                    bBl();
                }
            } else if (this.gMS.getVoteType() == 2) {
                if (this.gMS.getStatus() == 2 || this.gMS.getIsPolled() == 1) {
                    F(2, z);
                } else {
                    F(this.gMS.getIsMulti() == 1 ? 1 : 3, z);
                }
            }
        }
    }

    private void F(int i, boolean z) {
        if (this.gML != null && this.gMS != null) {
            this.gMM = (VotePhotoGroupView) this.gML.findViewById(d.g.picvote_view);
            this.gMM.setOnVoteCheckedChangedListener(this.aTl);
            this.gMM.setVisibility(0);
            this.gMM.setMode(i);
            this.gMM.a(this.gMS.getOptions(), z, this.gMS.getIsPolled() == 1);
        }
    }

    private void baj() {
        if (this.gML != null && this.gMS != null) {
            ((TextView) this.gML.findViewById(d.g.tv_vote_endtime)).setText(this.gMS.getTips());
            ((TextView) this.gML.findViewById(d.g.vote_num)).setText(getPageContext().getPageActivity().getString(d.j.pb_vote_num, new Object[]{Long.valueOf(this.gMS.getTotalNum())}));
            bBn();
        }
    }

    private void bBl() {
        if (this.gML != null && this.gMS != null) {
            this.gMN = (VoteTextGroupView) this.gML.findViewById(d.g.textvote_view);
            this.gMN.setOnVoteCheckedChangedListener(this.aTl);
            this.gMN.setVisibility(0);
            this.gMN.setMode(this.gMS.getIsMulti() == 1 ? 1 : 2);
            this.gMN.I(this.gMS.getOptions());
            this.gMN.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void nf(boolean z) {
        if (this.gML != null && this.gMS != null) {
            this.gMM = (VotePhotoGroupView) this.gML.findViewById(d.g.picvote_view);
            this.gMN = (VoteTextGroupView) this.gML.findViewById(d.g.textvote_view);
            this.gMO = (VoteView) this.gML.findViewById(d.g.result_vote_view);
            this.gMN.setVisibility(8);
            this.gMM.setVisibility(8);
            this.gMO.setVisibility(0);
            this.gMO.setWidth(this.maxWidth);
            this.gMO.b(this.gMS.getOptions(), z);
            this.gMO.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBm() {
        if (this.gMS != null) {
            if (this.gMV != null && this.eMh != null) {
                this.gMV.c(this.eMh.getActivity().getString(d.j.vote_succ));
            }
            this.gMS.setIsPolled(1);
            this.gMS.setTotalNum(this.gMS.getTotalNum() + 1);
            this.gMS.setTotalPoll(this.gMS.getTotalPoll() + this.gMT.size());
            for (b bVar : this.gMT) {
                if (bVar != null) {
                    bVar.setNum(bVar.getNum() + 1);
                }
            }
            if (this.gMS.getTotalPoll() > 0) {
                for (com.baidu.tbadk.widget.vote.a aVar : this.gMS.getOptions()) {
                    if (aVar instanceof b) {
                        b bVar2 = (b) aVar;
                        bVar2.setPercent((int) ((bVar2.getNum() * 100) / this.gMS.getTotalPoll()));
                    }
                }
            }
            a(this.gMS, true);
            this.gMT.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkMessageIsBelongToCurPage(ResponsedMessage<?> responsedMessage) {
        return (responsedMessage == null || this.mContext == null || responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() != this.mContext.getUniqueId()) ? false : true;
    }

    public void onChangeSkinType() {
        if (this.gML != null) {
            com.baidu.tbadk.o.a.a(this.eMh.getPageContext(), this.gML);
        }
        bBn();
    }

    private void bBn() {
        if (this.gMR != null && this.gMS != null) {
            if (this.gMS.getStatus() == 2) {
                aj.j(this.gMR, d.f.bg_gray_circle);
                this.gMR.setText(getPageContext().getString(d.j.pb_vote_over));
                this.gMR.setEnabled(false);
            } else if (this.gMS.getIsPolled() == 1) {
                aj.j(this.gMR, d.f.bg_gray_circle);
                this.gMR.setText(getPageContext().getString(d.j.pb_voted));
                this.gMR.setEnabled(false);
            } else if (this.gMS.getIsPolled() == 0) {
                aj.j(this.gMR, d.f.btn_pb_vote_selector);
                this.gMR.setText(getPageContext().getString(d.j.vote));
                this.gMR.setEnabled(true);
                this.gMR.setOnClickListener(this.mOnClickListener);
            }
            aj.c(this.gMR, d.C0080d.cp_cont_i, 1);
        }
    }
}
