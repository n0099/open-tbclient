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
    private com.baidu.tbadk.widget.vote.b bMz;
    private PbActivity fNg;
    private View hBA;
    private VotePhotoGroupView hBB;
    private VoteTextGroupView hBC;
    private VoteView hBD;
    private TextView hBE;
    private TextView hBF;
    private TextView hBG;
    private VoteDataInfo hBH;
    private final List<b> hBI;
    private boolean hBJ;
    private e hBK;
    private final com.baidu.adp.framework.listener.a hBL;
    private long mForumId;
    private final View.OnClickListener mOnClickListener;
    private int mSkinType;
    private long mThreadId;
    private int maxWidth;

    public void setVisibility(int i) {
        if (this.hBA != null) {
            this.hBA.setVisibility(i);
        }
    }

    public void bET() {
        if (this.hBB != null) {
            this.hBB.setPadding(0, 0, 0, 0);
        }
    }

    public a(PbActivity pbActivity) {
        super(pbActivity.getPageContext());
        this.mSkinType = 3;
        this.hBI = new ArrayList();
        this.hBJ = false;
        this.maxWidth = 0;
        this.bMz = new com.baidu.tbadk.widget.vote.b() { // from class: com.baidu.tieba.vote.a.2
            @Override // com.baidu.tbadk.widget.vote.b
            public void a(com.baidu.tbadk.widget.vote.a aVar, int i, boolean z) {
                if (a.this.hBH != null && a.this.hBH.getOptions() != null && i >= 0 && i < a.this.hBH.getOptions().size()) {
                    ((b) a.this.hBH.getOptions().get(i)).setSelected(z);
                }
            }
        };
        this.hBL = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_ADD_VOTE, 309006) { // from class: com.baidu.tieba.vote.a.3
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                a.this.hBJ = false;
                if (a.this.checkMessageIsBelongToCurPage(responsedMessage)) {
                    if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                        String errorString = responsedMessage.getErrorString();
                        String string = TbadkCoreApplication.getInst().getString(d.j.neterror);
                        if (!StringUtils.isNull(errorString)) {
                            string = errorString;
                        }
                        l.showToast(TbadkCoreApplication.getInst(), string);
                    } else if (responsedMessage instanceof AddVoteHttpProtoResponse) {
                        a.this.bEV();
                    } else if (responsedMessage instanceof AddVoteSocketResponse) {
                        a.this.bEV();
                    }
                }
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.vote.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == d.g.btn_pb_vote && a.this.fNg != null && a.this.fNg.checkUpIsLogin() && a.this.hBH != null && a.this.mForumId > 0 && a.this.mThreadId > 0 && !a.this.hBJ) {
                    AddVoteModel addVoteModel = new AddVoteModel(a.this.fNg);
                    StringBuilder sb = new StringBuilder();
                    List<com.baidu.tbadk.widget.vote.a> options = a.this.hBH.getOptions();
                    if (options != null) {
                        for (com.baidu.tbadk.widget.vote.a aVar : options) {
                            if (aVar != null && aVar.isSelected()) {
                                sb.append(aVar.getId()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                                a.this.hBI.add((b) aVar);
                                if (a.this.hBH.getIsMulti() != 1) {
                                    break;
                                }
                            }
                        }
                        if (sb.toString().endsWith(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                            sb.deleteCharAt(sb.length() - 1);
                        }
                        if (TextUtils.isEmpty(sb.toString())) {
                            UtilHelper.showToast(a.this.fNg.getActivity(), d.j.vote_checked_less_one);
                            return;
                        }
                        addVoteModel.a(a.this.mForumId, a.this.mThreadId, sb.toString());
                        a.this.hBJ = true;
                    }
                }
            }
        };
        this.fNg = pbActivity;
        pbActivity.registerListener(this.hBL);
        this.maxWidth = l.ao(TbadkCoreApplication.getInst()) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds120);
        this.hBK = new e();
    }

    public void a(View view, com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && dVar.bas() != null && dVar.bau() != null && view != null) {
            this.mForumId = com.baidu.adp.lib.g.b.c(dVar.bas().getId(), 0L);
            this.mThreadId = com.baidu.adp.lib.g.b.c(dVar.bau().getId(), 0L);
            if (dVar.bau().zZ() && dVar.bau().yZ() != null) {
                if (this.hBA == null) {
                    this.hBA = ((ViewStub) view.findViewById(d.g.vote_card_layout)).inflate();
                    this.hBG = (TextView) this.hBA.findViewById(d.g.btn_pb_vote);
                    this.hBH = dVar.bar();
                    b((PostData) v.f(dVar.baw(), 0), this.hBA);
                    a(this.hBH, false);
                }
                if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                    onChangeSkinType();
                }
                this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
                if (!this.hBA.isShown()) {
                    this.hBA.setVisibility(0);
                }
            } else if (this.hBA != null && this.hBA.isShown()) {
                this.hBA.setVisibility(8);
            }
        }
    }

    private void b(PostData postData, View view) {
        this.hBE = (TextView) view.findViewById(d.g.pb_item_vote_reply_time);
        this.hBF = (TextView) view.findViewById(d.g.pb_item_vote_location_address);
        f fVar = null;
        if (postData != null) {
            this.hBE.setText(postData.bxa());
            fVar = postData.bxc();
        }
        if (fVar != null && !TextUtils.isEmpty(fVar.getName()) && !TextUtils.isEmpty(fVar.getName().trim())) {
            final String name = fVar.getName();
            final String lat = fVar.getLat();
            final String lng = fVar.getLng();
            this.hBF.setVisibility(0);
            this.hBF.setText(fVar.getName());
            this.hBF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.vote.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (TbadkCoreApplication.getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(lat) && !StringUtils.isNull(lng)) {
                        if (!j.oJ()) {
                            a.this.fNg.showToast(d.j.neterror);
                        } else {
                            com.baidu.tbadk.browser.b.R(a.this.fNg.getPageContext().getPageActivity(), String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", lat + Constants.ACCEPT_TIME_SEPARATOR_SP + lng, name, name, a.this.mContext.getString(d.j.app_info_for_map)));
                        }
                    }
                }
            });
            return;
        }
        this.hBF.setVisibility(8);
    }

    private void a(VoteDataInfo voteDataInfo, boolean z) {
        this.hBH = voteDataInfo;
        if (this.hBH != null) {
            if (this.hBH.getStatus() == 2 || this.hBH.getIsPolled() == 0) {
                for (com.baidu.tbadk.widget.vote.a aVar : this.hBH.getOptions()) {
                    if (aVar != null && (aVar instanceof b)) {
                        ((b) aVar).setSelected(false);
                    }
                }
            }
            bkF();
            if (this.hBH.getVoteType() == 1) {
                if (this.hBH.getStatus() == 2 || this.hBH.getIsPolled() == 1) {
                    nC(z);
                } else {
                    bEU();
                }
            } else if (this.hBH.getVoteType() == 2) {
                if (this.hBH.getStatus() == 2 || this.hBH.getIsPolled() == 1) {
                    X(2, z);
                } else {
                    X(this.hBH.getIsMulti() == 1 ? 1 : 3, z);
                }
            }
        }
    }

    private void X(int i, boolean z) {
        if (this.hBA != null && this.hBH != null) {
            this.hBB = (VotePhotoGroupView) this.hBA.findViewById(d.g.picvote_view);
            this.hBB.setOnVoteCheckedChangedListener(this.bMz);
            this.hBB.setVisibility(0);
            this.hBB.setMode(i);
            this.hBB.a(this.hBH.getOptions(), z, this.hBH.getIsPolled() == 1);
        }
    }

    private void bkF() {
        if (this.hBA != null && this.hBH != null) {
            ((TextView) this.hBA.findViewById(d.g.tv_vote_endtime)).setText(this.hBH.getTips());
            ((TextView) this.hBA.findViewById(d.g.vote_num)).setText(getPageContext().getPageActivity().getString(d.j.pb_vote_num, new Object[]{Long.valueOf(this.hBH.getTotalNum())}));
            bEW();
        }
    }

    private void bEU() {
        if (this.hBA != null && this.hBH != null) {
            this.hBC = (VoteTextGroupView) this.hBA.findViewById(d.g.textvote_view);
            this.hBC.setOnVoteCheckedChangedListener(this.bMz);
            this.hBC.setVisibility(0);
            this.hBC.setMode(this.hBH.getIsMulti() == 1 ? 1 : 2);
            this.hBC.S(this.hBH.getOptions());
            this.hBC.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void nC(boolean z) {
        if (this.hBA != null && this.hBH != null) {
            this.hBB = (VotePhotoGroupView) this.hBA.findViewById(d.g.picvote_view);
            this.hBC = (VoteTextGroupView) this.hBA.findViewById(d.g.textvote_view);
            this.hBD = (VoteView) this.hBA.findViewById(d.g.result_vote_view);
            this.hBC.setVisibility(8);
            this.hBB.setVisibility(8);
            this.hBD.setVisibility(0);
            this.hBD.setWidth(this.maxWidth);
            this.hBD.b(this.hBH.getOptions(), z);
            this.hBD.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEV() {
        if (this.hBH != null) {
            if (this.hBK != null && this.fNg != null) {
                this.hBK.q(this.fNg.getActivity().getString(d.j.vote_succ));
            }
            this.hBH.setIsPolled(1);
            this.hBH.setTotalNum(this.hBH.getTotalNum() + 1);
            this.hBH.setTotalPoll(this.hBH.getTotalPoll() + this.hBI.size());
            for (b bVar : this.hBI) {
                if (bVar != null) {
                    bVar.setNum(bVar.getNum() + 1);
                }
            }
            if (this.hBH.getTotalPoll() > 0) {
                for (com.baidu.tbadk.widget.vote.a aVar : this.hBH.getOptions()) {
                    if (aVar instanceof b) {
                        b bVar2 = (b) aVar;
                        bVar2.setPercent((int) ((bVar2.getNum() * 100) / this.hBH.getTotalPoll()));
                    }
                }
            }
            a(this.hBH, true);
            this.hBI.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkMessageIsBelongToCurPage(ResponsedMessage<?> responsedMessage) {
        return (responsedMessage == null || this.mContext == null || responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() != this.mContext.getUniqueId()) ? false : true;
    }

    public void onChangeSkinType() {
        if (this.hBA != null) {
            com.baidu.tbadk.n.a.a(this.fNg.getPageContext(), this.hBA);
        }
        bEW();
    }

    private void bEW() {
        if (this.hBG != null && this.hBH != null) {
            if (this.hBH.getStatus() == 2) {
                aj.s(this.hBG, d.f.bg_gray_circle);
                this.hBG.setText(getPageContext().getString(d.j.pb_vote_over));
                this.hBG.setEnabled(false);
            } else if (this.hBH.getIsPolled() == 1) {
                aj.s(this.hBG, d.f.bg_gray_circle);
                this.hBG.setText(getPageContext().getString(d.j.pb_voted));
                this.hBG.setEnabled(false);
            } else if (this.hBH.getIsPolled() == 0) {
                aj.s(this.hBG, d.f.btn_pb_vote_selector);
                this.hBG.setText(getPageContext().getString(d.j.vote));
                this.hBG.setEnabled(true);
                this.hBG.setOnClickListener(this.mOnClickListener);
            }
            aj.e(this.hBG, d.C0141d.cp_cont_i, 1);
        }
    }
}
