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
import com.baidu.tbadk.data.f;
import com.baidu.tbadk.widget.vote.VotePhotoGroupView;
import com.baidu.tbadk.widget.vote.VoteTextGroupView;
import com.baidu.tbadk.widget.vote.VoteView;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a extends c<PbActivity> {
    private com.baidu.tbadk.widget.vote.b bMJ;
    private PbActivity fNb;
    private final com.baidu.adp.framework.listener.a hBA;
    private View hBp;
    private VotePhotoGroupView hBq;
    private VoteTextGroupView hBr;
    private VoteView hBs;
    private TextView hBt;
    private TextView hBu;
    private TextView hBv;
    private VoteDataInfo hBw;
    private final List<b> hBx;
    private boolean hBy;
    private e hBz;
    private long mForumId;
    private final View.OnClickListener mOnClickListener;
    private int mSkinType;
    private long mThreadId;
    private int maxWidth;

    public void setVisibility(int i) {
        if (this.hBp != null) {
            this.hBp.setVisibility(i);
        }
    }

    public void bEP() {
        if (this.hBq != null) {
            this.hBq.setPadding(0, 0, 0, 0);
        }
    }

    public a(PbActivity pbActivity) {
        super(pbActivity.getPageContext());
        this.mSkinType = 3;
        this.hBx = new ArrayList();
        this.hBy = false;
        this.maxWidth = 0;
        this.bMJ = new com.baidu.tbadk.widget.vote.b() { // from class: com.baidu.tieba.vote.a.2
            @Override // com.baidu.tbadk.widget.vote.b
            public void a(com.baidu.tbadk.widget.vote.a aVar, int i, boolean z) {
                if (a.this.hBw != null && a.this.hBw.getOptions() != null && i >= 0 && i < a.this.hBw.getOptions().size()) {
                    ((b) a.this.hBw.getOptions().get(i)).setSelected(z);
                }
            }
        };
        this.hBA = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_ADD_VOTE, 309006) { // from class: com.baidu.tieba.vote.a.3
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                a.this.hBy = false;
                if (a.this.checkMessageIsBelongToCurPage(responsedMessage)) {
                    if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                        String errorString = responsedMessage.getErrorString();
                        String string = TbadkCoreApplication.getInst().getString(d.j.neterror);
                        if (!StringUtils.isNull(errorString)) {
                            string = errorString;
                        }
                        l.showToast(TbadkCoreApplication.getInst(), string);
                    } else if (responsedMessage instanceof AddVoteHttpProtoResponse) {
                        a.this.bER();
                    } else if (responsedMessage instanceof AddVoteSocketResponse) {
                        a.this.bER();
                    }
                }
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.vote.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == d.g.btn_pb_vote && a.this.fNb != null && a.this.fNb.checkUpIsLogin() && a.this.hBw != null && a.this.mForumId > 0 && a.this.mThreadId > 0 && !a.this.hBy) {
                    AddVoteModel addVoteModel = new AddVoteModel(a.this.fNb);
                    StringBuilder sb = new StringBuilder();
                    List<com.baidu.tbadk.widget.vote.a> options = a.this.hBw.getOptions();
                    if (options != null) {
                        for (com.baidu.tbadk.widget.vote.a aVar : options) {
                            if (aVar != null && aVar.isSelected()) {
                                sb.append(aVar.getId()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                                a.this.hBx.add((b) aVar);
                                if (a.this.hBw.getIsMulti() != 1) {
                                    break;
                                }
                            }
                        }
                        if (sb.toString().endsWith(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                            sb.deleteCharAt(sb.length() - 1);
                        }
                        if (TextUtils.isEmpty(sb.toString())) {
                            UtilHelper.showToast(a.this.fNb.getActivity(), d.j.vote_checked_less_one);
                            return;
                        }
                        addVoteModel.a(a.this.mForumId, a.this.mThreadId, sb.toString());
                        a.this.hBy = true;
                    }
                }
            }
        };
        this.fNb = pbActivity;
        pbActivity.registerListener(this.hBA);
        this.maxWidth = l.ao(TbadkCoreApplication.getInst()) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds120);
        this.hBz = new e();
    }

    public void a(View view, com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && dVar.bas() != null && dVar.bau() != null && view != null) {
            this.mForumId = com.baidu.adp.lib.g.b.c(dVar.bas().getId(), 0L);
            this.mThreadId = com.baidu.adp.lib.g.b.c(dVar.bau().getId(), 0L);
            if (dVar.bau().zZ() && dVar.bau().yZ() != null) {
                if (this.hBp == null) {
                    this.hBp = ((ViewStub) view.findViewById(d.g.vote_card_layout)).inflate();
                    this.hBv = (TextView) this.hBp.findViewById(d.g.btn_pb_vote);
                    this.hBw = dVar.bar();
                    b((PostData) v.f(dVar.baw(), 0), this.hBp);
                    a(this.hBw, false);
                }
                if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                    onChangeSkinType();
                }
                this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
                if (!this.hBp.isShown()) {
                    this.hBp.setVisibility(0);
                }
            } else if (this.hBp != null && this.hBp.isShown()) {
                this.hBp.setVisibility(8);
            }
        }
    }

    private void b(PostData postData, View view) {
        this.hBt = (TextView) view.findViewById(d.g.pb_item_vote_reply_time);
        this.hBu = (TextView) view.findViewById(d.g.pb_item_vote_location_address);
        f fVar = null;
        if (postData != null) {
            this.hBt.setText(postData.bwW());
            fVar = postData.bwY();
        }
        if (fVar != null && !TextUtils.isEmpty(fVar.getName()) && !TextUtils.isEmpty(fVar.getName().trim())) {
            final String name = fVar.getName();
            final String lat = fVar.getLat();
            final String lng = fVar.getLng();
            this.hBu.setVisibility(0);
            this.hBu.setText(fVar.getName());
            this.hBu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.vote.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (TbadkCoreApplication.getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(lat) && !StringUtils.isNull(lng)) {
                        if (!j.oJ()) {
                            a.this.fNb.showToast(d.j.neterror);
                        } else {
                            com.baidu.tbadk.browser.b.R(a.this.fNb.getPageContext().getPageActivity(), String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", lat + Constants.ACCEPT_TIME_SEPARATOR_SP + lng, name, name, a.this.mContext.getString(d.j.app_info_for_map)));
                        }
                    }
                }
            });
            return;
        }
        this.hBu.setVisibility(8);
    }

    private void a(VoteDataInfo voteDataInfo, boolean z) {
        this.hBw = voteDataInfo;
        if (this.hBw != null) {
            if (this.hBw.getStatus() == 2 || this.hBw.getIsPolled() == 0) {
                for (com.baidu.tbadk.widget.vote.a aVar : this.hBw.getOptions()) {
                    if (aVar != null && (aVar instanceof b)) {
                        ((b) aVar).setSelected(false);
                    }
                }
            }
            bkF();
            if (this.hBw.getVoteType() == 1) {
                if (this.hBw.getStatus() == 2 || this.hBw.getIsPolled() == 1) {
                    nx(z);
                } else {
                    bEQ();
                }
            } else if (this.hBw.getVoteType() == 2) {
                if (this.hBw.getStatus() == 2 || this.hBw.getIsPolled() == 1) {
                    X(2, z);
                } else {
                    X(this.hBw.getIsMulti() == 1 ? 1 : 3, z);
                }
            }
        }
    }

    private void X(int i, boolean z) {
        if (this.hBp != null && this.hBw != null) {
            this.hBq = (VotePhotoGroupView) this.hBp.findViewById(d.g.picvote_view);
            this.hBq.setOnVoteCheckedChangedListener(this.bMJ);
            this.hBq.setVisibility(0);
            this.hBq.setMode(i);
            this.hBq.a(this.hBw.getOptions(), z, this.hBw.getIsPolled() == 1);
        }
    }

    private void bkF() {
        if (this.hBp != null && this.hBw != null) {
            ((TextView) this.hBp.findViewById(d.g.tv_vote_endtime)).setText(this.hBw.getTips());
            ((TextView) this.hBp.findViewById(d.g.vote_num)).setText(getPageContext().getPageActivity().getString(d.j.pb_vote_num, new Object[]{Long.valueOf(this.hBw.getTotalNum())}));
            bES();
        }
    }

    private void bEQ() {
        if (this.hBp != null && this.hBw != null) {
            this.hBr = (VoteTextGroupView) this.hBp.findViewById(d.g.textvote_view);
            this.hBr.setOnVoteCheckedChangedListener(this.bMJ);
            this.hBr.setVisibility(0);
            this.hBr.setMode(this.hBw.getIsMulti() == 1 ? 1 : 2);
            this.hBr.S(this.hBw.getOptions());
            this.hBr.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void nx(boolean z) {
        if (this.hBp != null && this.hBw != null) {
            this.hBq = (VotePhotoGroupView) this.hBp.findViewById(d.g.picvote_view);
            this.hBr = (VoteTextGroupView) this.hBp.findViewById(d.g.textvote_view);
            this.hBs = (VoteView) this.hBp.findViewById(d.g.result_vote_view);
            this.hBr.setVisibility(8);
            this.hBq.setVisibility(8);
            this.hBs.setVisibility(0);
            this.hBs.setWidth(this.maxWidth);
            this.hBs.b(this.hBw.getOptions(), z);
            this.hBs.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bER() {
        if (this.hBw != null) {
            if (this.hBz != null && this.fNb != null) {
                this.hBz.q(this.fNb.getActivity().getString(d.j.vote_succ));
            }
            this.hBw.setIsPolled(1);
            this.hBw.setTotalNum(this.hBw.getTotalNum() + 1);
            this.hBw.setTotalPoll(this.hBw.getTotalPoll() + this.hBx.size());
            for (b bVar : this.hBx) {
                if (bVar != null) {
                    bVar.setNum(bVar.getNum() + 1);
                }
            }
            if (this.hBw.getTotalPoll() > 0) {
                for (com.baidu.tbadk.widget.vote.a aVar : this.hBw.getOptions()) {
                    if (aVar instanceof b) {
                        b bVar2 = (b) aVar;
                        bVar2.setPercent((int) ((bVar2.getNum() * 100) / this.hBw.getTotalPoll()));
                    }
                }
            }
            a(this.hBw, true);
            this.hBx.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkMessageIsBelongToCurPage(ResponsedMessage<?> responsedMessage) {
        return (responsedMessage == null || this.mContext == null || responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() != this.mContext.getUniqueId()) ? false : true;
    }

    public void onChangeSkinType() {
        if (this.hBp != null) {
            com.baidu.tbadk.n.a.a(this.fNb.getPageContext(), this.hBp);
        }
        bES();
    }

    private void bES() {
        if (this.hBv != null && this.hBw != null) {
            if (this.hBw.getStatus() == 2) {
                aj.s(this.hBv, d.f.bg_gray_circle);
                this.hBv.setText(getPageContext().getString(d.j.pb_vote_over));
                this.hBv.setEnabled(false);
            } else if (this.hBw.getIsPolled() == 1) {
                aj.s(this.hBv, d.f.bg_gray_circle);
                this.hBv.setText(getPageContext().getString(d.j.pb_voted));
                this.hBv.setEnabled(false);
            } else if (this.hBw.getIsPolled() == 0) {
                aj.s(this.hBv, d.f.btn_pb_vote_selector);
                this.hBv.setText(getPageContext().getString(d.j.vote));
                this.hBv.setEnabled(true);
                this.hBv.setOnClickListener(this.mOnClickListener);
            }
            aj.e(this.hBv, d.C0140d.cp_cont_i, 1);
        }
    }
}
