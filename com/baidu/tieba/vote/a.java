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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.v;
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
    private com.baidu.tbadk.widget.vote.b aSy;
    private PbActivity eGQ;
    private View gxi;
    private VotePhotoGroupView gxj;
    private VoteTextGroupView gxk;
    private VoteView gxl;
    private LinearLayout gxm;
    private TextView gxn;
    private TextView gxo;
    private TextView gxp;
    private TextView gxq;
    private VoteDataInfo gxr;
    private final List<b> gxs;
    private boolean gxt;
    private com.baidu.tbadk.core.view.c gxu;
    private final com.baidu.adp.framework.listener.a gxv;
    private long mForumId;
    private final View.OnClickListener mOnClickListener;
    private int mSkinType;
    private long mThreadId;
    private int maxWidth;

    public void setVisibility(int i) {
        if (this.gxi != null) {
            this.gxi.setVisibility(i);
        }
    }

    public void bwA() {
        if (this.gxj != null) {
            this.gxj.setPadding(0, 0, 0, 0);
        }
    }

    public a(PbActivity pbActivity) {
        super(pbActivity.getPageContext());
        this.mSkinType = 3;
        this.gxs = new ArrayList();
        this.gxt = false;
        this.maxWidth = 0;
        this.aSy = new com.baidu.tbadk.widget.vote.b() { // from class: com.baidu.tieba.vote.a.2
            @Override // com.baidu.tbadk.widget.vote.b
            public void a(com.baidu.tbadk.widget.vote.a aVar, int i, boolean z) {
                if (a.this.gxr != null && a.this.gxr.getOptions() != null && i >= 0 && i < a.this.gxr.getOptions().size()) {
                    ((b) a.this.gxr.getOptions().get(i)).setSelected(z);
                }
            }
        };
        this.gxv = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_ADD_VOTE, 309006) { // from class: com.baidu.tieba.vote.a.3
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                a.this.gxt = false;
                if (a.this.checkMessageIsBelongToCurPage(responsedMessage)) {
                    if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                        String errorString = responsedMessage.getErrorString();
                        String string = TbadkCoreApplication.getInst().getString(d.l.neterror);
                        if (!StringUtils.isNull(errorString)) {
                            string = errorString;
                        }
                        k.showToast(TbadkCoreApplication.getInst(), string);
                    } else if (responsedMessage instanceof AddVoteHttpProtoResponse) {
                        a.this.bwC();
                    } else if (responsedMessage instanceof AddVoteSocketResponse) {
                        a.this.bwC();
                    }
                }
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.vote.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == d.h.btn_pb_vote && a.this.eGQ != null && a.this.eGQ.checkUpIsLogin() && a.this.gxr != null && a.this.mForumId > 0 && a.this.mThreadId > 0 && !a.this.gxt) {
                    AddVoteModel addVoteModel = new AddVoteModel(a.this.eGQ);
                    StringBuilder sb = new StringBuilder();
                    List<com.baidu.tbadk.widget.vote.a> options = a.this.gxr.getOptions();
                    if (options != null) {
                        for (com.baidu.tbadk.widget.vote.a aVar : options) {
                            if (aVar != null && aVar.isSelected()) {
                                sb.append(aVar.getId()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                                a.this.gxs.add((b) aVar);
                                if (a.this.gxr.getIsMulti() != 1) {
                                    break;
                                }
                            }
                        }
                        if (sb.toString().endsWith(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                            sb.deleteCharAt(sb.length() - 1);
                        }
                        if (TextUtils.isEmpty(sb.toString())) {
                            UtilHelper.showToast(a.this.eGQ.getActivity(), d.l.vote_checked_less_one);
                            return;
                        }
                        addVoteModel.a(a.this.mForumId, a.this.mThreadId, sb.toString());
                        a.this.gxt = true;
                    }
                }
            }
        };
        this.eGQ = pbActivity;
        pbActivity.registerListener(this.gxv);
        this.maxWidth = k.ad(TbadkCoreApplication.getInst()) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds120);
        this.gxu = new com.baidu.tbadk.core.view.c();
    }

    public void a(View view, f fVar) {
        if (fVar != null && fVar.aOV() != null && fVar.aOX() != null && view != null) {
            this.mForumId = com.baidu.adp.lib.g.b.c(fVar.aOV().getId(), 0L);
            this.mThreadId = com.baidu.adp.lib.g.b.c(fVar.aOX().getId(), 0L);
            if (fVar.aOX().sn() && fVar.aOX().rp() != null) {
                if (this.gxi == null) {
                    this.gxi = ((ViewStub) view.findViewById(d.h.vote_card_layout)).inflate();
                    this.gxq = (TextView) this.gxi.findViewById(d.h.btn_pb_vote);
                    this.gxr = fVar.aOU();
                    b((PostData) v.c(fVar.aOZ(), 0), this.gxi);
                    a(this.gxr, false);
                }
                if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                    onChangeSkinType();
                }
                this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
                if (!this.gxi.isShown()) {
                    this.gxi.setVisibility(0);
                }
            } else if (this.gxi != null && this.gxi.isShown()) {
                this.gxi.setVisibility(8);
            }
        }
    }

    private void b(PostData postData, View view) {
        this.gxm = (LinearLayout) view.findViewById(d.h.pb_vote_location_container);
        this.gxn = (TextView) view.findViewById(d.h.pb_vote_first_floor_name);
        this.gxo = (TextView) view.findViewById(d.h.pb_item_vote_reply_time);
        this.gxp = (TextView) view.findViewById(d.h.pb_item_vote_location_address);
        h hVar = null;
        if (postData != null) {
            this.gxo.setText(postData.bsq());
            hVar = postData.bsr();
        }
        if (hVar != null && !TextUtils.isEmpty(hVar.getName()) && !TextUtils.isEmpty(hVar.getName().trim())) {
            final String name = hVar.getName();
            final String lat = hVar.getLat();
            final String lng = hVar.getLng();
            this.gxp.setVisibility(0);
            this.gxp.setText(hVar.getName());
            this.gxp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.vote.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (TbadkCoreApplication.getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(lat) && !StringUtils.isNull(lng)) {
                        if (!i.hi()) {
                            a.this.eGQ.showToast(d.l.neterror);
                        } else {
                            com.baidu.tbadk.browser.a.T(a.this.eGQ.getPageContext().getPageActivity(), String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", lat + Constants.ACCEPT_TIME_SEPARATOR_SP + lng, name, name, a.this.mContext.getString(d.l.app_info_for_map)));
                        }
                    }
                }
            });
            return;
        }
        this.gxp.setVisibility(8);
    }

    private void a(VoteDataInfo voteDataInfo, boolean z) {
        this.gxr = voteDataInfo;
        if (this.gxr != null) {
            if (this.gxr.getStatus() == 2 || this.gxr.getIsPolled() == 0) {
                for (com.baidu.tbadk.widget.vote.a aVar : this.gxr.getOptions()) {
                    if (aVar != null && (aVar instanceof b)) {
                        ((b) aVar).setSelected(false);
                    }
                }
            }
            aYx();
            if (this.gxr.getVoteType() == 1) {
                if (this.gxr.getStatus() == 2 || this.gxr.getIsPolled() == 1) {
                    ne(z);
                } else {
                    bwB();
                }
            } else if (this.gxr.getVoteType() == 2) {
                if (this.gxr.getStatus() == 2 || this.gxr.getIsPolled() == 1) {
                    D(2, z);
                } else {
                    D(this.gxr.getIsMulti() == 1 ? 1 : 3, z);
                }
            }
        }
    }

    private void D(int i, boolean z) {
        if (this.gxi != null && this.gxr != null) {
            this.gxj = (VotePhotoGroupView) this.gxi.findViewById(d.h.picvote_view);
            this.gxj.setOnVoteCheckedChangedListener(this.aSy);
            this.gxj.setVisibility(0);
            this.gxj.setMode(i);
            this.gxj.a(this.gxr.getOptions(), z, this.gxr.getIsPolled() == 1);
        }
    }

    private void aYx() {
        if (this.gxi != null && this.gxr != null) {
            ((TextView) this.gxi.findViewById(d.h.tv_vote_endtime)).setText(this.gxr.getTips());
            ((TextView) this.gxi.findViewById(d.h.vote_num)).setText(getPageContext().getPageActivity().getString(d.l.pb_vote_num, new Object[]{Long.valueOf(this.gxr.getTotalNum())}));
            bwD();
        }
    }

    private void bwB() {
        if (this.gxi != null && this.gxr != null) {
            this.gxk = (VoteTextGroupView) this.gxi.findViewById(d.h.textvote_view);
            this.gxk.setOnVoteCheckedChangedListener(this.aSy);
            this.gxk.setVisibility(0);
            this.gxk.setMode(this.gxr.getIsMulti() == 1 ? 1 : 2);
            this.gxk.I(this.gxr.getOptions());
            this.gxk.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void ne(boolean z) {
        if (this.gxi != null && this.gxr != null) {
            this.gxj = (VotePhotoGroupView) this.gxi.findViewById(d.h.picvote_view);
            this.gxk = (VoteTextGroupView) this.gxi.findViewById(d.h.textvote_view);
            this.gxl = (VoteView) this.gxi.findViewById(d.h.result_vote_view);
            this.gxk.setVisibility(8);
            this.gxj.setVisibility(8);
            this.gxl.setVisibility(0);
            this.gxl.setWidth(this.maxWidth);
            this.gxl.b(this.gxr.getOptions(), z);
            this.gxl.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwC() {
        if (this.gxr != null) {
            if (this.gxu != null && this.eGQ != null) {
                this.gxu.c(this.eGQ.getActivity().getString(d.l.vote_succ));
            }
            this.gxr.setIsPolled(1);
            this.gxr.setTotalNum(this.gxr.getTotalNum() + 1);
            this.gxr.setTotalPoll(this.gxr.getTotalPoll() + this.gxs.size());
            for (b bVar : this.gxs) {
                if (bVar != null) {
                    bVar.setNum(bVar.getNum() + 1);
                }
            }
            if (this.gxr.getTotalPoll() > 0) {
                for (com.baidu.tbadk.widget.vote.a aVar : this.gxr.getOptions()) {
                    if (aVar instanceof b) {
                        b bVar2 = (b) aVar;
                        bVar2.ck((int) ((bVar2.getNum() * 100) / this.gxr.getTotalPoll()));
                    }
                }
            }
            a(this.gxr, true);
            this.gxs.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkMessageIsBelongToCurPage(ResponsedMessage<?> responsedMessage) {
        return (responsedMessage == null || this.mContext == null || responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() != this.mContext.getUniqueId()) ? false : true;
    }

    public void onChangeSkinType() {
        if (this.gxi != null) {
            com.baidu.tbadk.o.a.a(this.eGQ.getPageContext(), this.gxi);
        }
        bwD();
    }

    private void bwD() {
        if (this.gxq != null && this.gxr != null) {
            if (this.gxr.getStatus() == 2) {
                aj.j(this.gxq, d.g.bg_gray_circle);
                this.gxq.setText(getPageContext().getString(d.l.pb_vote_over));
                this.gxq.setEnabled(false);
            } else if (this.gxr.getIsPolled() == 1) {
                aj.j(this.gxq, d.g.bg_gray_circle);
                this.gxq.setText(getPageContext().getString(d.l.pb_voted));
                this.gxq.setEnabled(false);
            } else if (this.gxr.getIsPolled() == 0) {
                aj.j(this.gxq, d.g.btn_pb_vote_selector);
                this.gxq.setText(getPageContext().getString(d.l.vote));
                this.gxq.setEnabled(true);
                this.gxq.setOnClickListener(this.mOnClickListener);
            }
            aj.c(this.gxq, d.e.cp_cont_i, 1);
        }
    }
}
