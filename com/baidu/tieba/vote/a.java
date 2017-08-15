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
    private com.baidu.tbadk.widget.vote.b aSN;
    private PbActivity eIu;
    private View gyI;
    private VotePhotoGroupView gyJ;
    private VoteTextGroupView gyK;
    private VoteView gyL;
    private LinearLayout gyM;
    private TextView gyN;
    private TextView gyO;
    private TextView gyP;
    private TextView gyQ;
    private VoteDataInfo gyR;
    private final List<b> gyS;
    private boolean gyT;
    private com.baidu.tbadk.core.view.c gyU;
    private final com.baidu.adp.framework.listener.a gyV;
    private long mForumId;
    private final View.OnClickListener mOnClickListener;
    private int mSkinType;
    private long mThreadId;
    private int maxWidth;

    public void setVisibility(int i) {
        if (this.gyI != null) {
            this.gyI.setVisibility(i);
        }
    }

    public void bxr() {
        if (this.gyJ != null) {
            this.gyJ.setPadding(0, 0, 0, 0);
        }
    }

    public a(PbActivity pbActivity) {
        super(pbActivity.getPageContext());
        this.mSkinType = 3;
        this.gyS = new ArrayList();
        this.gyT = false;
        this.maxWidth = 0;
        this.aSN = new com.baidu.tbadk.widget.vote.b() { // from class: com.baidu.tieba.vote.a.2
            @Override // com.baidu.tbadk.widget.vote.b
            public void a(com.baidu.tbadk.widget.vote.a aVar, int i, boolean z) {
                if (a.this.gyR != null && a.this.gyR.getOptions() != null && i >= 0 && i < a.this.gyR.getOptions().size()) {
                    ((b) a.this.gyR.getOptions().get(i)).setSelected(z);
                }
            }
        };
        this.gyV = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_ADD_VOTE, 309006) { // from class: com.baidu.tieba.vote.a.3
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                a.this.gyT = false;
                if (a.this.checkMessageIsBelongToCurPage(responsedMessage)) {
                    if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                        String errorString = responsedMessage.getErrorString();
                        String string = TbadkCoreApplication.getInst().getString(d.l.neterror);
                        if (!StringUtils.isNull(errorString)) {
                            string = errorString;
                        }
                        k.showToast(TbadkCoreApplication.getInst(), string);
                    } else if (responsedMessage instanceof AddVoteHttpProtoResponse) {
                        a.this.bxt();
                    } else if (responsedMessage instanceof AddVoteSocketResponse) {
                        a.this.bxt();
                    }
                }
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.vote.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == d.h.btn_pb_vote && a.this.eIu != null && a.this.eIu.checkUpIsLogin() && a.this.gyR != null && a.this.mForumId > 0 && a.this.mThreadId > 0 && !a.this.gyT) {
                    AddVoteModel addVoteModel = new AddVoteModel(a.this.eIu);
                    StringBuilder sb = new StringBuilder();
                    List<com.baidu.tbadk.widget.vote.a> options = a.this.gyR.getOptions();
                    if (options != null) {
                        for (com.baidu.tbadk.widget.vote.a aVar : options) {
                            if (aVar != null && aVar.isSelected()) {
                                sb.append(aVar.getId()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                                a.this.gyS.add((b) aVar);
                                if (a.this.gyR.getIsMulti() != 1) {
                                    break;
                                }
                            }
                        }
                        if (sb.toString().endsWith(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                            sb.deleteCharAt(sb.length() - 1);
                        }
                        if (TextUtils.isEmpty(sb.toString())) {
                            UtilHelper.showToast(a.this.eIu.getActivity(), d.l.vote_checked_less_one);
                            return;
                        }
                        addVoteModel.a(a.this.mForumId, a.this.mThreadId, sb.toString());
                        a.this.gyT = true;
                    }
                }
            }
        };
        this.eIu = pbActivity;
        pbActivity.registerListener(this.gyV);
        this.maxWidth = k.ag(TbadkCoreApplication.getInst()) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds120);
        this.gyU = new com.baidu.tbadk.core.view.c();
    }

    public void a(View view, f fVar) {
        if (fVar != null && fVar.aPO() != null && fVar.aPQ() != null && view != null) {
            this.mForumId = com.baidu.adp.lib.g.b.d(fVar.aPO().getId(), 0L);
            this.mThreadId = com.baidu.adp.lib.g.b.d(fVar.aPQ().getId(), 0L);
            if (fVar.aPQ().sr() && fVar.aPQ().rt() != null) {
                if (this.gyI == null) {
                    this.gyI = ((ViewStub) view.findViewById(d.h.vote_card_layout)).inflate();
                    this.gyQ = (TextView) this.gyI.findViewById(d.h.btn_pb_vote);
                    this.gyR = fVar.aPN();
                    b((PostData) u.c(fVar.aPS(), 0), this.gyI);
                    a(this.gyR, false);
                }
                if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                    onChangeSkinType();
                }
                this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
                if (!this.gyI.isShown()) {
                    this.gyI.setVisibility(0);
                }
            } else if (this.gyI != null && this.gyI.isShown()) {
                this.gyI.setVisibility(8);
            }
        }
    }

    private void b(PostData postData, View view) {
        this.gyM = (LinearLayout) view.findViewById(d.h.pb_vote_location_container);
        this.gyN = (TextView) view.findViewById(d.h.pb_vote_first_floor_name);
        this.gyO = (TextView) view.findViewById(d.h.pb_item_vote_reply_time);
        this.gyP = (TextView) view.findViewById(d.h.pb_item_vote_location_address);
        h hVar = null;
        if (postData != null) {
            this.gyO.setText(postData.bti());
            hVar = postData.btj();
        }
        if (hVar != null && !TextUtils.isEmpty(hVar.getName()) && !TextUtils.isEmpty(hVar.getName().trim())) {
            final String name = hVar.getName();
            final String lat = hVar.getLat();
            final String lng = hVar.getLng();
            this.gyP.setVisibility(0);
            this.gyP.setText(hVar.getName());
            this.gyP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.vote.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (TbadkCoreApplication.getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(lat) && !StringUtils.isNull(lng)) {
                        if (!i.hr()) {
                            a.this.eIu.showToast(d.l.neterror);
                        } else {
                            com.baidu.tbadk.browser.a.T(a.this.eIu.getPageContext().getPageActivity(), String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", lat + Constants.ACCEPT_TIME_SEPARATOR_SP + lng, name, name, a.this.mContext.getString(d.l.app_info_for_map)));
                        }
                    }
                }
            });
            return;
        }
        this.gyP.setVisibility(8);
    }

    private void a(VoteDataInfo voteDataInfo, boolean z) {
        this.gyR = voteDataInfo;
        if (this.gyR != null) {
            if (this.gyR.getStatus() == 2 || this.gyR.getIsPolled() == 0) {
                for (com.baidu.tbadk.widget.vote.a aVar : this.gyR.getOptions()) {
                    if (aVar != null && (aVar instanceof b)) {
                        ((b) aVar).setSelected(false);
                    }
                }
            }
            aZq();
            if (this.gyR.getVoteType() == 1) {
                if (this.gyR.getStatus() == 2 || this.gyR.getIsPolled() == 1) {
                    mY(z);
                } else {
                    bxs();
                }
            } else if (this.gyR.getVoteType() == 2) {
                if (this.gyR.getStatus() == 2 || this.gyR.getIsPolled() == 1) {
                    H(2, z);
                } else {
                    H(this.gyR.getIsMulti() == 1 ? 1 : 3, z);
                }
            }
        }
    }

    private void H(int i, boolean z) {
        if (this.gyI != null && this.gyR != null) {
            this.gyJ = (VotePhotoGroupView) this.gyI.findViewById(d.h.picvote_view);
            this.gyJ.setOnVoteCheckedChangedListener(this.aSN);
            this.gyJ.setVisibility(0);
            this.gyJ.setMode(i);
            this.gyJ.a(this.gyR.getOptions(), z, this.gyR.getIsPolled() == 1);
        }
    }

    private void aZq() {
        if (this.gyI != null && this.gyR != null) {
            ((TextView) this.gyI.findViewById(d.h.tv_vote_endtime)).setText(this.gyR.getTips());
            ((TextView) this.gyI.findViewById(d.h.vote_num)).setText(getPageContext().getPageActivity().getString(d.l.pb_vote_num, new Object[]{Long.valueOf(this.gyR.getTotalNum())}));
            bxu();
        }
    }

    private void bxs() {
        if (this.gyI != null && this.gyR != null) {
            this.gyK = (VoteTextGroupView) this.gyI.findViewById(d.h.textvote_view);
            this.gyK.setOnVoteCheckedChangedListener(this.aSN);
            this.gyK.setVisibility(0);
            this.gyK.setMode(this.gyR.getIsMulti() == 1 ? 1 : 2);
            this.gyK.I(this.gyR.getOptions());
            this.gyK.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void mY(boolean z) {
        if (this.gyI != null && this.gyR != null) {
            this.gyJ = (VotePhotoGroupView) this.gyI.findViewById(d.h.picvote_view);
            this.gyK = (VoteTextGroupView) this.gyI.findViewById(d.h.textvote_view);
            this.gyL = (VoteView) this.gyI.findViewById(d.h.result_vote_view);
            this.gyK.setVisibility(8);
            this.gyJ.setVisibility(8);
            this.gyL.setVisibility(0);
            this.gyL.setWidth(this.maxWidth);
            this.gyL.b(this.gyR.getOptions(), z);
            this.gyL.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxt() {
        if (this.gyR != null) {
            if (this.gyU != null && this.eIu != null) {
                this.gyU.c(this.eIu.getActivity().getString(d.l.vote_succ));
            }
            this.gyR.setIsPolled(1);
            this.gyR.setTotalNum(this.gyR.getTotalNum() + 1);
            this.gyR.setTotalPoll(this.gyR.getTotalPoll() + this.gyS.size());
            for (b bVar : this.gyS) {
                if (bVar != null) {
                    bVar.setNum(bVar.getNum() + 1);
                }
            }
            if (this.gyR.getTotalPoll() > 0) {
                for (com.baidu.tbadk.widget.vote.a aVar : this.gyR.getOptions()) {
                    if (aVar instanceof b) {
                        b bVar2 = (b) aVar;
                        bVar2.ck((int) ((bVar2.getNum() * 100) / this.gyR.getTotalPoll()));
                    }
                }
            }
            a(this.gyR, true);
            this.gyS.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkMessageIsBelongToCurPage(ResponsedMessage<?> responsedMessage) {
        return (responsedMessage == null || this.mContext == null || responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() != this.mContext.getUniqueId()) ? false : true;
    }

    public void onChangeSkinType() {
        if (this.gyI != null) {
            com.baidu.tbadk.o.a.a(this.eIu.getPageContext(), this.gyI);
        }
        bxu();
    }

    private void bxu() {
        if (this.gyQ != null && this.gyR != null) {
            if (this.gyR.getStatus() == 2) {
                ai.j(this.gyQ, d.g.bg_gray_circle);
                this.gyQ.setText(getPageContext().getString(d.l.pb_vote_over));
                this.gyQ.setEnabled(false);
            } else if (this.gyR.getIsPolled() == 1) {
                ai.j(this.gyQ, d.g.bg_gray_circle);
                this.gyQ.setText(getPageContext().getString(d.l.pb_voted));
                this.gyQ.setEnabled(false);
            } else if (this.gyR.getIsPolled() == 0) {
                ai.j(this.gyQ, d.g.btn_pb_vote_selector);
                this.gyQ.setText(getPageContext().getString(d.l.vote));
                this.gyQ.setEnabled(true);
                this.gyQ.setOnClickListener(this.mOnClickListener);
            }
            ai.c(this.gyQ, d.e.cp_cont_i, 1);
        }
    }
}
