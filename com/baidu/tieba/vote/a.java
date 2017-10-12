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
    private com.baidu.tbadk.widget.vote.b aTu;
    private PbActivity eDC;
    private View gDj;
    private VotePhotoGroupView gDk;
    private VoteTextGroupView gDl;
    private VoteView gDm;
    private LinearLayout gDn;
    private TextView gDo;
    private TextView gDp;
    private TextView gDq;
    private TextView gDr;
    private VoteDataInfo gDs;
    private final List<b> gDt;
    private boolean gDu;
    private com.baidu.tbadk.core.view.c gDv;
    private final com.baidu.adp.framework.listener.a gDw;
    private long mForumId;
    private final View.OnClickListener mOnClickListener;
    private int mSkinType;
    private long mThreadId;
    private int maxWidth;

    public void setVisibility(int i) {
        if (this.gDj != null) {
            this.gDj.setVisibility(i);
        }
    }

    public void bxZ() {
        if (this.gDk != null) {
            this.gDk.setPadding(0, 0, 0, 0);
        }
    }

    public a(PbActivity pbActivity) {
        super(pbActivity.getPageContext());
        this.mSkinType = 3;
        this.gDt = new ArrayList();
        this.gDu = false;
        this.maxWidth = 0;
        this.aTu = new com.baidu.tbadk.widget.vote.b() { // from class: com.baidu.tieba.vote.a.2
            @Override // com.baidu.tbadk.widget.vote.b
            public void a(com.baidu.tbadk.widget.vote.a aVar, int i, boolean z) {
                if (a.this.gDs != null && a.this.gDs.getOptions() != null && i >= 0 && i < a.this.gDs.getOptions().size()) {
                    ((b) a.this.gDs.getOptions().get(i)).setSelected(z);
                }
            }
        };
        this.gDw = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_ADD_VOTE, 309006) { // from class: com.baidu.tieba.vote.a.3
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                a.this.gDu = false;
                if (a.this.checkMessageIsBelongToCurPage(responsedMessage)) {
                    if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                        String errorString = responsedMessage.getErrorString();
                        String string = TbadkCoreApplication.getInst().getString(d.l.neterror);
                        if (!StringUtils.isNull(errorString)) {
                            string = errorString;
                        }
                        l.showToast(TbadkCoreApplication.getInst(), string);
                    } else if (responsedMessage instanceof AddVoteHttpProtoResponse) {
                        a.this.byb();
                    } else if (responsedMessage instanceof AddVoteSocketResponse) {
                        a.this.byb();
                    }
                }
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.vote.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == d.h.btn_pb_vote && a.this.eDC != null && a.this.eDC.checkUpIsLogin() && a.this.gDs != null && a.this.mForumId > 0 && a.this.mThreadId > 0 && !a.this.gDu) {
                    AddVoteModel addVoteModel = new AddVoteModel(a.this.eDC);
                    StringBuilder sb = new StringBuilder();
                    List<com.baidu.tbadk.widget.vote.a> options = a.this.gDs.getOptions();
                    if (options != null) {
                        for (com.baidu.tbadk.widget.vote.a aVar : options) {
                            if (aVar != null && aVar.isSelected()) {
                                sb.append(aVar.getId()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                                a.this.gDt.add((b) aVar);
                                if (a.this.gDs.getIsMulti() != 1) {
                                    break;
                                }
                            }
                        }
                        if (sb.toString().endsWith(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                            sb.deleteCharAt(sb.length() - 1);
                        }
                        if (TextUtils.isEmpty(sb.toString())) {
                            UtilHelper.showToast(a.this.eDC.getActivity(), d.l.vote_checked_less_one);
                            return;
                        }
                        addVoteModel.a(a.this.mForumId, a.this.mThreadId, sb.toString());
                        a.this.gDu = true;
                    }
                }
            }
        };
        this.eDC = pbActivity;
        pbActivity.registerListener(this.gDw);
        this.maxWidth = l.ad(TbadkCoreApplication.getInst()) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds120);
        this.gDv = new com.baidu.tbadk.core.view.c();
    }

    public void a(View view, f fVar) {
        if (fVar != null && fVar.aMZ() != null && fVar.aNb() != null && view != null) {
            this.mForumId = com.baidu.adp.lib.g.b.c(fVar.aMZ().getId(), 0L);
            this.mThreadId = com.baidu.adp.lib.g.b.c(fVar.aNb().getId(), 0L);
            if (fVar.aNb().sh() && fVar.aNb().rj() != null) {
                if (this.gDj == null) {
                    this.gDj = ((ViewStub) view.findViewById(d.h.vote_card_layout)).inflate();
                    this.gDr = (TextView) this.gDj.findViewById(d.h.btn_pb_vote);
                    this.gDs = fVar.aMY();
                    b((PostData) v.c(fVar.aNd(), 0), this.gDj);
                    a(this.gDs, false);
                }
                if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                    onChangeSkinType();
                }
                this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
                if (!this.gDj.isShown()) {
                    this.gDj.setVisibility(0);
                }
            } else if (this.gDj != null && this.gDj.isShown()) {
                this.gDj.setVisibility(8);
            }
        }
    }

    private void b(PostData postData, View view) {
        this.gDn = (LinearLayout) view.findViewById(d.h.pb_vote_location_container);
        this.gDo = (TextView) view.findViewById(d.h.pb_vote_first_floor_name);
        this.gDp = (TextView) view.findViewById(d.h.pb_item_vote_reply_time);
        this.gDq = (TextView) view.findViewById(d.h.pb_item_vote_location_address);
        g gVar = null;
        if (postData != null) {
            this.gDp.setText(postData.brz());
            gVar = postData.brA();
        }
        if (gVar != null && !TextUtils.isEmpty(gVar.getName()) && !TextUtils.isEmpty(gVar.getName().trim())) {
            final String name = gVar.getName();
            final String lat = gVar.getLat();
            final String lng = gVar.getLng();
            this.gDq.setVisibility(0);
            this.gDq.setText(gVar.getName());
            this.gDq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.vote.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (TbadkCoreApplication.getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(lat) && !StringUtils.isNull(lng)) {
                        if (!j.hh()) {
                            a.this.eDC.showToast(d.l.neterror);
                        } else {
                            com.baidu.tbadk.browser.a.T(a.this.eDC.getPageContext().getPageActivity(), String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", lat + Constants.ACCEPT_TIME_SEPARATOR_SP + lng, name, name, a.this.mContext.getString(d.l.app_info_for_map)));
                        }
                    }
                }
            });
            return;
        }
        this.gDq.setVisibility(8);
    }

    private void a(VoteDataInfo voteDataInfo, boolean z) {
        this.gDs = voteDataInfo;
        if (this.gDs != null) {
            if (this.gDs.getStatus() == 2 || this.gDs.getIsPolled() == 0) {
                for (com.baidu.tbadk.widget.vote.a aVar : this.gDs.getOptions()) {
                    if (aVar != null && (aVar instanceof b)) {
                        ((b) aVar).setSelected(false);
                    }
                }
            }
            aXg();
            if (this.gDs.getVoteType() == 1) {
                if (this.gDs.getStatus() == 2 || this.gDs.getIsPolled() == 1) {
                    nk(z);
                } else {
                    bya();
                }
            } else if (this.gDs.getVoteType() == 2) {
                if (this.gDs.getStatus() == 2 || this.gDs.getIsPolled() == 1) {
                    E(2, z);
                } else {
                    E(this.gDs.getIsMulti() == 1 ? 1 : 3, z);
                }
            }
        }
    }

    private void E(int i, boolean z) {
        if (this.gDj != null && this.gDs != null) {
            this.gDk = (VotePhotoGroupView) this.gDj.findViewById(d.h.picvote_view);
            this.gDk.setOnVoteCheckedChangedListener(this.aTu);
            this.gDk.setVisibility(0);
            this.gDk.setMode(i);
            this.gDk.a(this.gDs.getOptions(), z, this.gDs.getIsPolled() == 1);
        }
    }

    private void aXg() {
        if (this.gDj != null && this.gDs != null) {
            ((TextView) this.gDj.findViewById(d.h.tv_vote_endtime)).setText(this.gDs.getTips());
            ((TextView) this.gDj.findViewById(d.h.vote_num)).setText(getPageContext().getPageActivity().getString(d.l.pb_vote_num, new Object[]{Long.valueOf(this.gDs.getTotalNum())}));
            byc();
        }
    }

    private void bya() {
        if (this.gDj != null && this.gDs != null) {
            this.gDl = (VoteTextGroupView) this.gDj.findViewById(d.h.textvote_view);
            this.gDl.setOnVoteCheckedChangedListener(this.aTu);
            this.gDl.setVisibility(0);
            this.gDl.setMode(this.gDs.getIsMulti() == 1 ? 1 : 2);
            this.gDl.H(this.gDs.getOptions());
            this.gDl.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void nk(boolean z) {
        if (this.gDj != null && this.gDs != null) {
            this.gDk = (VotePhotoGroupView) this.gDj.findViewById(d.h.picvote_view);
            this.gDl = (VoteTextGroupView) this.gDj.findViewById(d.h.textvote_view);
            this.gDm = (VoteView) this.gDj.findViewById(d.h.result_vote_view);
            this.gDl.setVisibility(8);
            this.gDk.setVisibility(8);
            this.gDm.setVisibility(0);
            this.gDm.setWidth(this.maxWidth);
            this.gDm.b(this.gDs.getOptions(), z);
            this.gDm.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void byb() {
        if (this.gDs != null) {
            if (this.gDv != null && this.eDC != null) {
                this.gDv.c(this.eDC.getActivity().getString(d.l.vote_succ));
            }
            this.gDs.setIsPolled(1);
            this.gDs.setTotalNum(this.gDs.getTotalNum() + 1);
            this.gDs.setTotalPoll(this.gDs.getTotalPoll() + this.gDt.size());
            for (b bVar : this.gDt) {
                if (bVar != null) {
                    bVar.setNum(bVar.getNum() + 1);
                }
            }
            if (this.gDs.getTotalPoll() > 0) {
                for (com.baidu.tbadk.widget.vote.a aVar : this.gDs.getOptions()) {
                    if (aVar instanceof b) {
                        b bVar2 = (b) aVar;
                        bVar2.setPercent((int) ((bVar2.getNum() * 100) / this.gDs.getTotalPoll()));
                    }
                }
            }
            a(this.gDs, true);
            this.gDt.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkMessageIsBelongToCurPage(ResponsedMessage<?> responsedMessage) {
        return (responsedMessage == null || this.mContext == null || responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() != this.mContext.getUniqueId()) ? false : true;
    }

    public void onChangeSkinType() {
        if (this.gDj != null) {
            com.baidu.tbadk.n.a.a(this.eDC.getPageContext(), this.gDj);
        }
        byc();
    }

    private void byc() {
        if (this.gDr != null && this.gDs != null) {
            if (this.gDs.getStatus() == 2) {
                aj.j(this.gDr, d.g.bg_gray_circle);
                this.gDr.setText(getPageContext().getString(d.l.pb_vote_over));
                this.gDr.setEnabled(false);
            } else if (this.gDs.getIsPolled() == 1) {
                aj.j(this.gDr, d.g.bg_gray_circle);
                this.gDr.setText(getPageContext().getString(d.l.pb_voted));
                this.gDr.setEnabled(false);
            } else if (this.gDs.getIsPolled() == 0) {
                aj.j(this.gDr, d.g.btn_pb_vote_selector);
                this.gDr.setText(getPageContext().getString(d.l.vote));
                this.gDr.setEnabled(true);
                this.gDr.setOnClickListener(this.mOnClickListener);
            }
            aj.c(this.gDr, d.e.cp_cont_i, 1);
        }
    }
}
