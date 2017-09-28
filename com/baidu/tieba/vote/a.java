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
    private View gDk;
    private VotePhotoGroupView gDl;
    private VoteTextGroupView gDm;
    private VoteView gDn;
    private LinearLayout gDo;
    private TextView gDp;
    private TextView gDq;
    private TextView gDr;
    private TextView gDs;
    private VoteDataInfo gDt;
    private final List<b> gDu;
    private boolean gDv;
    private com.baidu.tbadk.core.view.c gDw;
    private final com.baidu.adp.framework.listener.a gDx;
    private long mForumId;
    private final View.OnClickListener mOnClickListener;
    private int mSkinType;
    private long mThreadId;
    private int maxWidth;

    public void setVisibility(int i) {
        if (this.gDk != null) {
            this.gDk.setVisibility(i);
        }
    }

    public void bya() {
        if (this.gDl != null) {
            this.gDl.setPadding(0, 0, 0, 0);
        }
    }

    public a(PbActivity pbActivity) {
        super(pbActivity.getPageContext());
        this.mSkinType = 3;
        this.gDu = new ArrayList();
        this.gDv = false;
        this.maxWidth = 0;
        this.aTu = new com.baidu.tbadk.widget.vote.b() { // from class: com.baidu.tieba.vote.a.2
            @Override // com.baidu.tbadk.widget.vote.b
            public void a(com.baidu.tbadk.widget.vote.a aVar, int i, boolean z) {
                if (a.this.gDt != null && a.this.gDt.getOptions() != null && i >= 0 && i < a.this.gDt.getOptions().size()) {
                    ((b) a.this.gDt.getOptions().get(i)).setSelected(z);
                }
            }
        };
        this.gDx = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_ADD_VOTE, 309006) { // from class: com.baidu.tieba.vote.a.3
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                a.this.gDv = false;
                if (a.this.checkMessageIsBelongToCurPage(responsedMessage)) {
                    if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                        String errorString = responsedMessage.getErrorString();
                        String string = TbadkCoreApplication.getInst().getString(d.l.neterror);
                        if (!StringUtils.isNull(errorString)) {
                            string = errorString;
                        }
                        l.showToast(TbadkCoreApplication.getInst(), string);
                    } else if (responsedMessage instanceof AddVoteHttpProtoResponse) {
                        a.this.byc();
                    } else if (responsedMessage instanceof AddVoteSocketResponse) {
                        a.this.byc();
                    }
                }
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.vote.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == d.h.btn_pb_vote && a.this.eDC != null && a.this.eDC.checkUpIsLogin() && a.this.gDt != null && a.this.mForumId > 0 && a.this.mThreadId > 0 && !a.this.gDv) {
                    AddVoteModel addVoteModel = new AddVoteModel(a.this.eDC);
                    StringBuilder sb = new StringBuilder();
                    List<com.baidu.tbadk.widget.vote.a> options = a.this.gDt.getOptions();
                    if (options != null) {
                        for (com.baidu.tbadk.widget.vote.a aVar : options) {
                            if (aVar != null && aVar.isSelected()) {
                                sb.append(aVar.getId()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                                a.this.gDu.add((b) aVar);
                                if (a.this.gDt.getIsMulti() != 1) {
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
                        a.this.gDv = true;
                    }
                }
            }
        };
        this.eDC = pbActivity;
        pbActivity.registerListener(this.gDx);
        this.maxWidth = l.ad(TbadkCoreApplication.getInst()) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds120);
        this.gDw = new com.baidu.tbadk.core.view.c();
    }

    public void a(View view, f fVar) {
        if (fVar != null && fVar.aMZ() != null && fVar.aNb() != null && view != null) {
            this.mForumId = com.baidu.adp.lib.g.b.c(fVar.aMZ().getId(), 0L);
            this.mThreadId = com.baidu.adp.lib.g.b.c(fVar.aNb().getId(), 0L);
            if (fVar.aNb().sh() && fVar.aNb().rj() != null) {
                if (this.gDk == null) {
                    this.gDk = ((ViewStub) view.findViewById(d.h.vote_card_layout)).inflate();
                    this.gDs = (TextView) this.gDk.findViewById(d.h.btn_pb_vote);
                    this.gDt = fVar.aMY();
                    b((PostData) v.c(fVar.aNd(), 0), this.gDk);
                    a(this.gDt, false);
                }
                if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                    onChangeSkinType();
                }
                this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
                if (!this.gDk.isShown()) {
                    this.gDk.setVisibility(0);
                }
            } else if (this.gDk != null && this.gDk.isShown()) {
                this.gDk.setVisibility(8);
            }
        }
    }

    private void b(PostData postData, View view) {
        this.gDo = (LinearLayout) view.findViewById(d.h.pb_vote_location_container);
        this.gDp = (TextView) view.findViewById(d.h.pb_vote_first_floor_name);
        this.gDq = (TextView) view.findViewById(d.h.pb_item_vote_reply_time);
        this.gDr = (TextView) view.findViewById(d.h.pb_item_vote_location_address);
        g gVar = null;
        if (postData != null) {
            this.gDq.setText(postData.brA());
            gVar = postData.brB();
        }
        if (gVar != null && !TextUtils.isEmpty(gVar.getName()) && !TextUtils.isEmpty(gVar.getName().trim())) {
            final String name = gVar.getName();
            final String lat = gVar.getLat();
            final String lng = gVar.getLng();
            this.gDr.setVisibility(0);
            this.gDr.setText(gVar.getName());
            this.gDr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.vote.a.1
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
        this.gDr.setVisibility(8);
    }

    private void a(VoteDataInfo voteDataInfo, boolean z) {
        this.gDt = voteDataInfo;
        if (this.gDt != null) {
            if (this.gDt.getStatus() == 2 || this.gDt.getIsPolled() == 0) {
                for (com.baidu.tbadk.widget.vote.a aVar : this.gDt.getOptions()) {
                    if (aVar != null && (aVar instanceof b)) {
                        ((b) aVar).setSelected(false);
                    }
                }
            }
            aXh();
            if (this.gDt.getVoteType() == 1) {
                if (this.gDt.getStatus() == 2 || this.gDt.getIsPolled() == 1) {
                    nk(z);
                } else {
                    byb();
                }
            } else if (this.gDt.getVoteType() == 2) {
                if (this.gDt.getStatus() == 2 || this.gDt.getIsPolled() == 1) {
                    E(2, z);
                } else {
                    E(this.gDt.getIsMulti() == 1 ? 1 : 3, z);
                }
            }
        }
    }

    private void E(int i, boolean z) {
        if (this.gDk != null && this.gDt != null) {
            this.gDl = (VotePhotoGroupView) this.gDk.findViewById(d.h.picvote_view);
            this.gDl.setOnVoteCheckedChangedListener(this.aTu);
            this.gDl.setVisibility(0);
            this.gDl.setMode(i);
            this.gDl.a(this.gDt.getOptions(), z, this.gDt.getIsPolled() == 1);
        }
    }

    private void aXh() {
        if (this.gDk != null && this.gDt != null) {
            ((TextView) this.gDk.findViewById(d.h.tv_vote_endtime)).setText(this.gDt.getTips());
            ((TextView) this.gDk.findViewById(d.h.vote_num)).setText(getPageContext().getPageActivity().getString(d.l.pb_vote_num, new Object[]{Long.valueOf(this.gDt.getTotalNum())}));
            byd();
        }
    }

    private void byb() {
        if (this.gDk != null && this.gDt != null) {
            this.gDm = (VoteTextGroupView) this.gDk.findViewById(d.h.textvote_view);
            this.gDm.setOnVoteCheckedChangedListener(this.aTu);
            this.gDm.setVisibility(0);
            this.gDm.setMode(this.gDt.getIsMulti() == 1 ? 1 : 2);
            this.gDm.H(this.gDt.getOptions());
            this.gDm.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void nk(boolean z) {
        if (this.gDk != null && this.gDt != null) {
            this.gDl = (VotePhotoGroupView) this.gDk.findViewById(d.h.picvote_view);
            this.gDm = (VoteTextGroupView) this.gDk.findViewById(d.h.textvote_view);
            this.gDn = (VoteView) this.gDk.findViewById(d.h.result_vote_view);
            this.gDm.setVisibility(8);
            this.gDl.setVisibility(8);
            this.gDn.setVisibility(0);
            this.gDn.setWidth(this.maxWidth);
            this.gDn.b(this.gDt.getOptions(), z);
            this.gDn.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void byc() {
        if (this.gDt != null) {
            if (this.gDw != null && this.eDC != null) {
                this.gDw.c(this.eDC.getActivity().getString(d.l.vote_succ));
            }
            this.gDt.setIsPolled(1);
            this.gDt.setTotalNum(this.gDt.getTotalNum() + 1);
            this.gDt.setTotalPoll(this.gDt.getTotalPoll() + this.gDu.size());
            for (b bVar : this.gDu) {
                if (bVar != null) {
                    bVar.setNum(bVar.getNum() + 1);
                }
            }
            if (this.gDt.getTotalPoll() > 0) {
                for (com.baidu.tbadk.widget.vote.a aVar : this.gDt.getOptions()) {
                    if (aVar instanceof b) {
                        b bVar2 = (b) aVar;
                        bVar2.setPercent((int) ((bVar2.getNum() * 100) / this.gDt.getTotalPoll()));
                    }
                }
            }
            a(this.gDt, true);
            this.gDu.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkMessageIsBelongToCurPage(ResponsedMessage<?> responsedMessage) {
        return (responsedMessage == null || this.mContext == null || responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() != this.mContext.getUniqueId()) ? false : true;
    }

    public void onChangeSkinType() {
        if (this.gDk != null) {
            com.baidu.tbadk.n.a.a(this.eDC.getPageContext(), this.gDk);
        }
        byd();
    }

    private void byd() {
        if (this.gDs != null && this.gDt != null) {
            if (this.gDt.getStatus() == 2) {
                aj.j(this.gDs, d.g.bg_gray_circle);
                this.gDs.setText(getPageContext().getString(d.l.pb_vote_over));
                this.gDs.setEnabled(false);
            } else if (this.gDt.getIsPolled() == 1) {
                aj.j(this.gDs, d.g.bg_gray_circle);
                this.gDs.setText(getPageContext().getString(d.l.pb_voted));
                this.gDs.setEnabled(false);
            } else if (this.gDt.getIsPolled() == 0) {
                aj.j(this.gDs, d.g.btn_pb_vote_selector);
                this.gDs.setText(getPageContext().getString(d.l.vote));
                this.gDs.setEnabled(true);
                this.gDs.setOnClickListener(this.mOnClickListener);
            }
            aj.c(this.gDs, d.e.cp_cont_i, 1);
        }
    }
}
