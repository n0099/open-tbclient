package com.baidu.tieba.vote;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.LinearLayout;
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
import com.baidu.tbadk.data.g;
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
    private com.baidu.tbadk.widget.vote.b aTh;
    private PbActivity eDo;
    private View gCU;
    private VotePhotoGroupView gCV;
    private VoteTextGroupView gCW;
    private VoteView gCX;
    private LinearLayout gCY;
    private TextView gCZ;
    private TextView gDa;
    private TextView gDb;
    private TextView gDc;
    private VoteDataInfo gDd;
    private final List<b> gDe;
    private boolean gDf;
    private com.baidu.tbadk.core.view.c gDg;
    private final com.baidu.adp.framework.listener.a gDh;
    private long mForumId;
    private final View.OnClickListener mOnClickListener;
    private int mSkinType;
    private long mThreadId;
    private int maxWidth;

    public void setVisibility(int i) {
        if (this.gCU != null) {
            this.gCU.setVisibility(i);
        }
    }

    public void bxR() {
        if (this.gCV != null) {
            this.gCV.setPadding(0, 0, 0, 0);
        }
    }

    public a(PbActivity pbActivity) {
        super(pbActivity.getPageContext());
        this.mSkinType = 3;
        this.gDe = new ArrayList();
        this.gDf = false;
        this.maxWidth = 0;
        this.aTh = new com.baidu.tbadk.widget.vote.b() { // from class: com.baidu.tieba.vote.a.2
            @Override // com.baidu.tbadk.widget.vote.b
            public void a(com.baidu.tbadk.widget.vote.a aVar, int i, boolean z) {
                if (a.this.gDd != null && a.this.gDd.getOptions() != null && i >= 0 && i < a.this.gDd.getOptions().size()) {
                    ((b) a.this.gDd.getOptions().get(i)).setSelected(z);
                }
            }
        };
        this.gDh = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_ADD_VOTE, 309006) { // from class: com.baidu.tieba.vote.a.3
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                a.this.gDf = false;
                if (a.this.checkMessageIsBelongToCurPage(responsedMessage)) {
                    if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                        String errorString = responsedMessage.getErrorString();
                        String string = TbadkCoreApplication.getInst().getString(d.l.neterror);
                        if (!StringUtils.isNull(errorString)) {
                            string = errorString;
                        }
                        l.showToast(TbadkCoreApplication.getInst(), string);
                    } else if (responsedMessage instanceof AddVoteHttpProtoResponse) {
                        a.this.bxT();
                    } else if (responsedMessage instanceof AddVoteSocketResponse) {
                        a.this.bxT();
                    }
                }
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.vote.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == d.h.btn_pb_vote && a.this.eDo != null && a.this.eDo.checkUpIsLogin() && a.this.gDd != null && a.this.mForumId > 0 && a.this.mThreadId > 0 && !a.this.gDf) {
                    AddVoteModel addVoteModel = new AddVoteModel(a.this.eDo);
                    StringBuilder sb = new StringBuilder();
                    List<com.baidu.tbadk.widget.vote.a> options = a.this.gDd.getOptions();
                    if (options != null) {
                        for (com.baidu.tbadk.widget.vote.a aVar : options) {
                            if (aVar != null && aVar.isSelected()) {
                                sb.append(aVar.getId()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                                a.this.gDe.add((b) aVar);
                                if (a.this.gDd.getIsMulti() != 1) {
                                    break;
                                }
                            }
                        }
                        if (sb.toString().endsWith(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                            sb.deleteCharAt(sb.length() - 1);
                        }
                        if (TextUtils.isEmpty(sb.toString())) {
                            UtilHelper.showToast(a.this.eDo.getActivity(), d.l.vote_checked_less_one);
                            return;
                        }
                        addVoteModel.a(a.this.mForumId, a.this.mThreadId, sb.toString());
                        a.this.gDf = true;
                    }
                }
            }
        };
        this.eDo = pbActivity;
        pbActivity.registerListener(this.gDh);
        this.maxWidth = l.ad(TbadkCoreApplication.getInst()) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds120);
        this.gDg = new com.baidu.tbadk.core.view.c();
    }

    public void a(View view, f fVar) {
        if (fVar != null && fVar.aMU() != null && fVar.aMW() != null && view != null) {
            this.mForumId = com.baidu.adp.lib.g.b.c(fVar.aMU().getId(), 0L);
            this.mThreadId = com.baidu.adp.lib.g.b.c(fVar.aMW().getId(), 0L);
            if (fVar.aMW().sa() && fVar.aMW().rc() != null) {
                if (this.gCU == null) {
                    this.gCU = ((ViewStub) view.findViewById(d.h.vote_card_layout)).inflate();
                    this.gDc = (TextView) this.gCU.findViewById(d.h.btn_pb_vote);
                    this.gDd = fVar.aMT();
                    b((PostData) v.c(fVar.aMY(), 0), this.gCU);
                    a(this.gDd, false);
                }
                if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                    onChangeSkinType();
                }
                this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
                if (!this.gCU.isShown()) {
                    this.gCU.setVisibility(0);
                }
            } else if (this.gCU != null && this.gCU.isShown()) {
                this.gCU.setVisibility(8);
            }
        }
    }

    private void b(PostData postData, View view) {
        this.gCY = (LinearLayout) view.findViewById(d.h.pb_vote_location_container);
        this.gCZ = (TextView) view.findViewById(d.h.pb_vote_first_floor_name);
        this.gDa = (TextView) view.findViewById(d.h.pb_item_vote_reply_time);
        this.gDb = (TextView) view.findViewById(d.h.pb_item_vote_location_address);
        g gVar = null;
        if (postData != null) {
            this.gDa.setText(postData.brs());
            gVar = postData.brt();
        }
        if (gVar != null && !TextUtils.isEmpty(gVar.getName()) && !TextUtils.isEmpty(gVar.getName().trim())) {
            final String name = gVar.getName();
            final String lat = gVar.getLat();
            final String lng = gVar.getLng();
            this.gDb.setVisibility(0);
            this.gDb.setText(gVar.getName());
            this.gDb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.vote.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (TbadkCoreApplication.getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(lat) && !StringUtils.isNull(lng)) {
                        if (!j.hh()) {
                            a.this.eDo.showToast(d.l.neterror);
                        } else {
                            com.baidu.tbadk.browser.a.O(a.this.eDo.getPageContext().getPageActivity(), String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", lat + Constants.ACCEPT_TIME_SEPARATOR_SP + lng, name, name, a.this.mContext.getString(d.l.app_info_for_map)));
                        }
                    }
                }
            });
            return;
        }
        this.gDb.setVisibility(8);
    }

    private void a(VoteDataInfo voteDataInfo, boolean z) {
        this.gDd = voteDataInfo;
        if (this.gDd != null) {
            if (this.gDd.getStatus() == 2 || this.gDd.getIsPolled() == 0) {
                for (com.baidu.tbadk.widget.vote.a aVar : this.gDd.getOptions()) {
                    if (aVar != null && (aVar instanceof b)) {
                        ((b) aVar).setSelected(false);
                    }
                }
            }
            aXb();
            if (this.gDd.getVoteType() == 1) {
                if (this.gDd.getStatus() == 2 || this.gDd.getIsPolled() == 1) {
                    nj(z);
                } else {
                    bxS();
                }
            } else if (this.gDd.getVoteType() == 2) {
                if (this.gDd.getStatus() == 2 || this.gDd.getIsPolled() == 1) {
                    E(2, z);
                } else {
                    E(this.gDd.getIsMulti() == 1 ? 1 : 3, z);
                }
            }
        }
    }

    private void E(int i, boolean z) {
        if (this.gCU != null && this.gDd != null) {
            this.gCV = (VotePhotoGroupView) this.gCU.findViewById(d.h.picvote_view);
            this.gCV.setOnVoteCheckedChangedListener(this.aTh);
            this.gCV.setVisibility(0);
            this.gCV.setMode(i);
            this.gCV.a(this.gDd.getOptions(), z, this.gDd.getIsPolled() == 1);
        }
    }

    private void aXb() {
        if (this.gCU != null && this.gDd != null) {
            ((TextView) this.gCU.findViewById(d.h.tv_vote_endtime)).setText(this.gDd.getTips());
            ((TextView) this.gCU.findViewById(d.h.vote_num)).setText(getPageContext().getPageActivity().getString(d.l.pb_vote_num, new Object[]{Long.valueOf(this.gDd.getTotalNum())}));
            bxU();
        }
    }

    private void bxS() {
        if (this.gCU != null && this.gDd != null) {
            this.gCW = (VoteTextGroupView) this.gCU.findViewById(d.h.textvote_view);
            this.gCW.setOnVoteCheckedChangedListener(this.aTh);
            this.gCW.setVisibility(0);
            this.gCW.setMode(this.gDd.getIsMulti() == 1 ? 1 : 2);
            this.gCW.H(this.gDd.getOptions());
            this.gCW.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void nj(boolean z) {
        if (this.gCU != null && this.gDd != null) {
            this.gCV = (VotePhotoGroupView) this.gCU.findViewById(d.h.picvote_view);
            this.gCW = (VoteTextGroupView) this.gCU.findViewById(d.h.textvote_view);
            this.gCX = (VoteView) this.gCU.findViewById(d.h.result_vote_view);
            this.gCW.setVisibility(8);
            this.gCV.setVisibility(8);
            this.gCX.setVisibility(0);
            this.gCX.setWidth(this.maxWidth);
            this.gCX.b(this.gDd.getOptions(), z);
            this.gCX.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxT() {
        if (this.gDd != null) {
            if (this.gDg != null && this.eDo != null) {
                this.gDg.c(this.eDo.getActivity().getString(d.l.vote_succ));
            }
            this.gDd.setIsPolled(1);
            this.gDd.setTotalNum(this.gDd.getTotalNum() + 1);
            this.gDd.setTotalPoll(this.gDd.getTotalPoll() + this.gDe.size());
            for (b bVar : this.gDe) {
                if (bVar != null) {
                    bVar.setNum(bVar.getNum() + 1);
                }
            }
            if (this.gDd.getTotalPoll() > 0) {
                for (com.baidu.tbadk.widget.vote.a aVar : this.gDd.getOptions()) {
                    if (aVar instanceof b) {
                        b bVar2 = (b) aVar;
                        bVar2.setPercent((int) ((bVar2.getNum() * 100) / this.gDd.getTotalPoll()));
                    }
                }
            }
            a(this.gDd, true);
            this.gDe.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkMessageIsBelongToCurPage(ResponsedMessage<?> responsedMessage) {
        return (responsedMessage == null || this.mContext == null || responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() != this.mContext.getUniqueId()) ? false : true;
    }

    public void onChangeSkinType() {
        if (this.gCU != null) {
            com.baidu.tbadk.n.a.a(this.eDo.getPageContext(), this.gCU);
        }
        bxU();
    }

    private void bxU() {
        if (this.gDc != null && this.gDd != null) {
            if (this.gDd.getStatus() == 2) {
                aj.j(this.gDc, d.g.bg_gray_circle);
                this.gDc.setText(getPageContext().getString(d.l.pb_vote_over));
                this.gDc.setEnabled(false);
            } else if (this.gDd.getIsPolled() == 1) {
                aj.j(this.gDc, d.g.bg_gray_circle);
                this.gDc.setText(getPageContext().getString(d.l.pb_voted));
                this.gDc.setEnabled(false);
            } else if (this.gDd.getIsPolled() == 0) {
                aj.j(this.gDc, d.g.btn_pb_vote_selector);
                this.gDc.setText(getPageContext().getString(d.l.vote));
                this.gDc.setEnabled(true);
                this.gDc.setOnClickListener(this.mOnClickListener);
            }
            aj.c(this.gDc, d.e.cp_cont_i, 1);
        }
    }
}
