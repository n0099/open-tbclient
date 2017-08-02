package com.baidu.tieba.vote;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.base.c;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.i;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.u;
import com.baidu.tbadk.data.h;
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
    private com.baidu.tbadk.widget.vote.b aRA;
    private PbActivity eFn;
    private View gvF;
    private VotePhotoGroupView gvG;
    private VoteTextGroupView gvH;
    private VoteView gvI;
    private LinearLayout gvJ;
    private TextView gvK;
    private TextView gvL;
    private TextView gvM;
    private TextView gvN;
    private VoteDataInfo gvO;
    private final List<b> gvP;
    private boolean gvQ;
    private com.baidu.tbadk.core.view.c gvR;
    private final com.baidu.adp.framework.listener.a gvS;
    private long mForumId;
    private final View.OnClickListener mOnClickListener;
    private int mSkinType;
    private long mThreadId;
    private int maxWidth;

    public void setVisibility(int i) {
        if (this.gvF != null) {
            this.gvF.setVisibility(i);
        }
    }

    public void bwC() {
        if (this.gvG != null) {
            this.gvG.setPadding(0, 0, 0, 0);
        }
    }

    public a(PbActivity pbActivity) {
        super(pbActivity.getPageContext());
        this.mSkinType = 3;
        this.gvP = new ArrayList();
        this.gvQ = false;
        this.maxWidth = 0;
        this.aRA = new com.baidu.tbadk.widget.vote.b() { // from class: com.baidu.tieba.vote.a.2
            @Override // com.baidu.tbadk.widget.vote.b
            public void a(com.baidu.tbadk.widget.vote.a aVar, int i, boolean z) {
                if (a.this.gvO != null && a.this.gvO.getOptions() != null && i >= 0 && i < a.this.gvO.getOptions().size()) {
                    ((b) a.this.gvO.getOptions().get(i)).setSelected(z);
                }
            }
        };
        this.gvS = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_ADD_VOTE, 309006) { // from class: com.baidu.tieba.vote.a.3
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                a.this.gvQ = false;
                if (a.this.checkMessageIsBelongToCurPage(responsedMessage)) {
                    if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                        String errorString = responsedMessage.getErrorString();
                        String string = TbadkCoreApplication.getInst().getString(d.l.neterror);
                        if (!StringUtils.isNull(errorString)) {
                            string = errorString;
                        }
                        k.showToast(TbadkCoreApplication.getInst(), string);
                    } else if (responsedMessage instanceof AddVoteHttpProtoResponse) {
                        a.this.bwE();
                    } else if (responsedMessage instanceof AddVoteSocketResponse) {
                        a.this.bwE();
                    }
                }
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.vote.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == d.h.btn_pb_vote && a.this.eFn != null && a.this.eFn.checkUpIsLogin() && a.this.gvO != null && a.this.mForumId > 0 && a.this.mThreadId > 0 && !a.this.gvQ) {
                    AddVoteModel addVoteModel = new AddVoteModel(a.this.eFn);
                    StringBuilder sb = new StringBuilder();
                    List<com.baidu.tbadk.widget.vote.a> options = a.this.gvO.getOptions();
                    if (options != null) {
                        for (com.baidu.tbadk.widget.vote.a aVar : options) {
                            if (aVar != null && aVar.isSelected()) {
                                sb.append(aVar.getId()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                                a.this.gvP.add((b) aVar);
                                if (a.this.gvO.getIsMulti() != 1) {
                                    break;
                                }
                            }
                        }
                        if (sb.toString().endsWith(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                            sb.deleteCharAt(sb.length() - 1);
                        }
                        if (TextUtils.isEmpty(sb.toString())) {
                            UtilHelper.showToast(a.this.eFn.getActivity(), d.l.vote_checked_less_one);
                            return;
                        }
                        addVoteModel.a(a.this.mForumId, a.this.mThreadId, sb.toString());
                        a.this.gvQ = true;
                    }
                }
            }
        };
        this.eFn = pbActivity;
        pbActivity.registerListener(this.gvS);
        this.maxWidth = k.af(TbadkCoreApplication.getInst()) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds120);
        this.gvR = new com.baidu.tbadk.core.view.c();
    }

    public void a(View view, f fVar) {
        if (fVar != null && fVar.aOW() != null && fVar.aOY() != null && view != null) {
            this.mForumId = com.baidu.adp.lib.g.b.c(fVar.aOW().getId(), 0L);
            this.mThreadId = com.baidu.adp.lib.g.b.c(fVar.aOY().getId(), 0L);
            if (fVar.aOY().sh() && fVar.aOY().rj() != null) {
                if (this.gvF == null) {
                    this.gvF = ((ViewStub) view.findViewById(d.h.vote_card_layout)).inflate();
                    this.gvN = (TextView) this.gvF.findViewById(d.h.btn_pb_vote);
                    this.gvO = fVar.aOV();
                    b((PostData) u.c(fVar.aPa(), 0), this.gvF);
                    a(this.gvO, false);
                }
                if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                    onChangeSkinType();
                }
                this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
                if (!this.gvF.isShown()) {
                    this.gvF.setVisibility(0);
                }
            } else if (this.gvF != null && this.gvF.isShown()) {
                this.gvF.setVisibility(8);
            }
        }
    }

    private void b(PostData postData, View view) {
        this.gvJ = (LinearLayout) view.findViewById(d.h.pb_vote_location_container);
        this.gvK = (TextView) view.findViewById(d.h.pb_vote_first_floor_name);
        this.gvL = (TextView) view.findViewById(d.h.pb_item_vote_reply_time);
        this.gvM = (TextView) view.findViewById(d.h.pb_item_vote_location_address);
        h hVar = null;
        if (postData != null) {
            this.gvL.setText(postData.bst());
            hVar = postData.bsu();
        }
        if (hVar != null && !TextUtils.isEmpty(hVar.getName()) && !TextUtils.isEmpty(hVar.getName().trim())) {
            final String name = hVar.getName();
            final String lat = hVar.getLat();
            final String lng = hVar.getLng();
            this.gvM.setVisibility(0);
            this.gvM.setText(hVar.getName());
            this.gvM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.vote.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (TbadkCoreApplication.getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(lat) && !StringUtils.isNull(lng)) {
                        if (!i.hh()) {
                            a.this.eFn.showToast(d.l.neterror);
                        } else {
                            com.baidu.tbadk.browser.a.T(a.this.eFn.getPageContext().getPageActivity(), String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", lat + Constants.ACCEPT_TIME_SEPARATOR_SP + lng, name, name, a.this.mContext.getString(d.l.app_info_for_map)));
                        }
                    }
                }
            });
            return;
        }
        this.gvM.setVisibility(8);
    }

    private void a(VoteDataInfo voteDataInfo, boolean z) {
        this.gvO = voteDataInfo;
        if (this.gvO != null) {
            if (this.gvO.getStatus() == 2 || this.gvO.getIsPolled() == 0) {
                for (com.baidu.tbadk.widget.vote.a aVar : this.gvO.getOptions()) {
                    if (aVar != null && (aVar instanceof b)) {
                        ((b) aVar).setSelected(false);
                    }
                }
            }
            aYy();
            if (this.gvO.getVoteType() == 1) {
                if (this.gvO.getStatus() == 2 || this.gvO.getIsPolled() == 1) {
                    mV(z);
                } else {
                    bwD();
                }
            } else if (this.gvO.getVoteType() == 2) {
                if (this.gvO.getStatus() == 2 || this.gvO.getIsPolled() == 1) {
                    G(2, z);
                } else {
                    G(this.gvO.getIsMulti() == 1 ? 1 : 3, z);
                }
            }
        }
    }

    private void G(int i, boolean z) {
        if (this.gvF != null && this.gvO != null) {
            this.gvG = (VotePhotoGroupView) this.gvF.findViewById(d.h.picvote_view);
            this.gvG.setOnVoteCheckedChangedListener(this.aRA);
            this.gvG.setVisibility(0);
            this.gvG.setMode(i);
            this.gvG.a(this.gvO.getOptions(), z, this.gvO.getIsPolled() == 1);
        }
    }

    private void aYy() {
        if (this.gvF != null && this.gvO != null) {
            ((TextView) this.gvF.findViewById(d.h.tv_vote_endtime)).setText(this.gvO.getTips());
            ((TextView) this.gvF.findViewById(d.h.vote_num)).setText(getPageContext().getPageActivity().getString(d.l.pb_vote_num, new Object[]{Long.valueOf(this.gvO.getTotalNum())}));
            bwF();
        }
    }

    private void bwD() {
        if (this.gvF != null && this.gvO != null) {
            this.gvH = (VoteTextGroupView) this.gvF.findViewById(d.h.textvote_view);
            this.gvH.setOnVoteCheckedChangedListener(this.aRA);
            this.gvH.setVisibility(0);
            this.gvH.setMode(this.gvO.getIsMulti() == 1 ? 1 : 2);
            this.gvH.I(this.gvO.getOptions());
            this.gvH.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void mV(boolean z) {
        if (this.gvF != null && this.gvO != null) {
            this.gvG = (VotePhotoGroupView) this.gvF.findViewById(d.h.picvote_view);
            this.gvH = (VoteTextGroupView) this.gvF.findViewById(d.h.textvote_view);
            this.gvI = (VoteView) this.gvF.findViewById(d.h.result_vote_view);
            this.gvH.setVisibility(8);
            this.gvG.setVisibility(8);
            this.gvI.setVisibility(0);
            this.gvI.setWidth(this.maxWidth);
            this.gvI.b(this.gvO.getOptions(), z);
            this.gvI.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwE() {
        if (this.gvO != null) {
            if (this.gvR != null && this.eFn != null) {
                this.gvR.c(this.eFn.getActivity().getString(d.l.vote_succ));
            }
            this.gvO.setIsPolled(1);
            this.gvO.setTotalNum(this.gvO.getTotalNum() + 1);
            this.gvO.setTotalPoll(this.gvO.getTotalPoll() + this.gvP.size());
            for (b bVar : this.gvP) {
                if (bVar != null) {
                    bVar.setNum(bVar.getNum() + 1);
                }
            }
            if (this.gvO.getTotalPoll() > 0) {
                for (com.baidu.tbadk.widget.vote.a aVar : this.gvO.getOptions()) {
                    if (aVar instanceof b) {
                        b bVar2 = (b) aVar;
                        bVar2.ci((int) ((bVar2.getNum() * 100) / this.gvO.getTotalPoll()));
                    }
                }
            }
            a(this.gvO, true);
            this.gvP.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkMessageIsBelongToCurPage(ResponsedMessage<?> responsedMessage) {
        return (responsedMessage == null || this.mContext == null || responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() != this.mContext.getUniqueId()) ? false : true;
    }

    public void onChangeSkinType() {
        if (this.gvF != null) {
            com.baidu.tbadk.o.a.a(this.eFn.getPageContext(), this.gvF);
        }
        bwF();
    }

    private void bwF() {
        if (this.gvN != null && this.gvO != null) {
            if (this.gvO.getStatus() == 2) {
                ai.j(this.gvN, d.g.bg_gray_circle);
                this.gvN.setText(getPageContext().getString(d.l.pb_vote_over));
                this.gvN.setEnabled(false);
            } else if (this.gvO.getIsPolled() == 1) {
                ai.j(this.gvN, d.g.bg_gray_circle);
                this.gvN.setText(getPageContext().getString(d.l.pb_voted));
                this.gvN.setEnabled(false);
            } else if (this.gvO.getIsPolled() == 0) {
                ai.j(this.gvN, d.g.btn_pb_vote_selector);
                this.gvN.setText(getPageContext().getString(d.l.vote));
                this.gvN.setEnabled(true);
                this.gvN.setOnClickListener(this.mOnClickListener);
            }
            ai.c(this.gvN, d.e.cp_cont_i, 1);
        }
    }
}
