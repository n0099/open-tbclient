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
    private com.baidu.tbadk.widget.vote.b aSM;
    private PbActivity eGA;
    private View gwQ;
    private VotePhotoGroupView gwR;
    private VoteTextGroupView gwS;
    private VoteView gwT;
    private LinearLayout gwU;
    private TextView gwV;
    private TextView gwW;
    private TextView gwX;
    private TextView gwY;
    private VoteDataInfo gwZ;
    private final List<b> gxa;
    private boolean gxb;
    private com.baidu.tbadk.core.view.c gxc;
    private final com.baidu.adp.framework.listener.a gxd;
    private long mForumId;
    private final View.OnClickListener mOnClickListener;
    private int mSkinType;
    private long mThreadId;
    private int maxWidth;

    public void setVisibility(int i) {
        if (this.gwQ != null) {
            this.gwQ.setVisibility(i);
        }
    }

    public void bwJ() {
        if (this.gwR != null) {
            this.gwR.setPadding(0, 0, 0, 0);
        }
    }

    public a(PbActivity pbActivity) {
        super(pbActivity.getPageContext());
        this.mSkinType = 3;
        this.gxa = new ArrayList();
        this.gxb = false;
        this.maxWidth = 0;
        this.aSM = new com.baidu.tbadk.widget.vote.b() { // from class: com.baidu.tieba.vote.a.2
            @Override // com.baidu.tbadk.widget.vote.b
            public void a(com.baidu.tbadk.widget.vote.a aVar, int i, boolean z) {
                if (a.this.gwZ != null && a.this.gwZ.getOptions() != null && i >= 0 && i < a.this.gwZ.getOptions().size()) {
                    ((b) a.this.gwZ.getOptions().get(i)).setSelected(z);
                }
            }
        };
        this.gxd = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_ADD_VOTE, 309006) { // from class: com.baidu.tieba.vote.a.3
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                a.this.gxb = false;
                if (a.this.checkMessageIsBelongToCurPage(responsedMessage)) {
                    if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                        String errorString = responsedMessage.getErrorString();
                        String string = TbadkCoreApplication.getInst().getString(d.l.neterror);
                        if (!StringUtils.isNull(errorString)) {
                            string = errorString;
                        }
                        k.showToast(TbadkCoreApplication.getInst(), string);
                    } else if (responsedMessage instanceof AddVoteHttpProtoResponse) {
                        a.this.bwL();
                    } else if (responsedMessage instanceof AddVoteSocketResponse) {
                        a.this.bwL();
                    }
                }
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.vote.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == d.h.btn_pb_vote && a.this.eGA != null && a.this.eGA.checkUpIsLogin() && a.this.gwZ != null && a.this.mForumId > 0 && a.this.mThreadId > 0 && !a.this.gxb) {
                    AddVoteModel addVoteModel = new AddVoteModel(a.this.eGA);
                    StringBuilder sb = new StringBuilder();
                    List<com.baidu.tbadk.widget.vote.a> options = a.this.gwZ.getOptions();
                    if (options != null) {
                        for (com.baidu.tbadk.widget.vote.a aVar : options) {
                            if (aVar != null && aVar.isSelected()) {
                                sb.append(aVar.getId()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                                a.this.gxa.add((b) aVar);
                                if (a.this.gwZ.getIsMulti() != 1) {
                                    break;
                                }
                            }
                        }
                        if (sb.toString().endsWith(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                            sb.deleteCharAt(sb.length() - 1);
                        }
                        if (TextUtils.isEmpty(sb.toString())) {
                            UtilHelper.showToast(a.this.eGA.getActivity(), d.l.vote_checked_less_one);
                            return;
                        }
                        addVoteModel.a(a.this.mForumId, a.this.mThreadId, sb.toString());
                        a.this.gxb = true;
                    }
                }
            }
        };
        this.eGA = pbActivity;
        pbActivity.registerListener(this.gxd);
        this.maxWidth = k.ag(TbadkCoreApplication.getInst()) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds120);
        this.gxc = new com.baidu.tbadk.core.view.c();
    }

    public void a(View view, f fVar) {
        if (fVar != null && fVar.aPh() != null && fVar.aPj() != null && view != null) {
            this.mForumId = com.baidu.adp.lib.g.b.d(fVar.aPh().getId(), 0L);
            this.mThreadId = com.baidu.adp.lib.g.b.d(fVar.aPj().getId(), 0L);
            if (fVar.aPj().sr() && fVar.aPj().rt() != null) {
                if (this.gwQ == null) {
                    this.gwQ = ((ViewStub) view.findViewById(d.h.vote_card_layout)).inflate();
                    this.gwY = (TextView) this.gwQ.findViewById(d.h.btn_pb_vote);
                    this.gwZ = fVar.aPg();
                    b((PostData) u.c(fVar.aPl(), 0), this.gwQ);
                    a(this.gwZ, false);
                }
                if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                    onChangeSkinType();
                }
                this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
                if (!this.gwQ.isShown()) {
                    this.gwQ.setVisibility(0);
                }
            } else if (this.gwQ != null && this.gwQ.isShown()) {
                this.gwQ.setVisibility(8);
            }
        }
    }

    private void b(PostData postData, View view) {
        this.gwU = (LinearLayout) view.findViewById(d.h.pb_vote_location_container);
        this.gwV = (TextView) view.findViewById(d.h.pb_vote_first_floor_name);
        this.gwW = (TextView) view.findViewById(d.h.pb_item_vote_reply_time);
        this.gwX = (TextView) view.findViewById(d.h.pb_item_vote_location_address);
        h hVar = null;
        if (postData != null) {
            this.gwW.setText(postData.bsA());
            hVar = postData.bsB();
        }
        if (hVar != null && !TextUtils.isEmpty(hVar.getName()) && !TextUtils.isEmpty(hVar.getName().trim())) {
            final String name = hVar.getName();
            final String lat = hVar.getLat();
            final String lng = hVar.getLng();
            this.gwX.setVisibility(0);
            this.gwX.setText(hVar.getName());
            this.gwX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.vote.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (TbadkCoreApplication.getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(lat) && !StringUtils.isNull(lng)) {
                        if (!i.hr()) {
                            a.this.eGA.showToast(d.l.neterror);
                        } else {
                            com.baidu.tbadk.browser.a.T(a.this.eGA.getPageContext().getPageActivity(), String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", lat + Constants.ACCEPT_TIME_SEPARATOR_SP + lng, name, name, a.this.mContext.getString(d.l.app_info_for_map)));
                        }
                    }
                }
            });
            return;
        }
        this.gwX.setVisibility(8);
    }

    private void a(VoteDataInfo voteDataInfo, boolean z) {
        this.gwZ = voteDataInfo;
        if (this.gwZ != null) {
            if (this.gwZ.getStatus() == 2 || this.gwZ.getIsPolled() == 0) {
                for (com.baidu.tbadk.widget.vote.a aVar : this.gwZ.getOptions()) {
                    if (aVar != null && (aVar instanceof b)) {
                        ((b) aVar).setSelected(false);
                    }
                }
            }
            aYJ();
            if (this.gwZ.getVoteType() == 1) {
                if (this.gwZ.getStatus() == 2 || this.gwZ.getIsPolled() == 1) {
                    mV(z);
                } else {
                    bwK();
                }
            } else if (this.gwZ.getVoteType() == 2) {
                if (this.gwZ.getStatus() == 2 || this.gwZ.getIsPolled() == 1) {
                    H(2, z);
                } else {
                    H(this.gwZ.getIsMulti() == 1 ? 1 : 3, z);
                }
            }
        }
    }

    private void H(int i, boolean z) {
        if (this.gwQ != null && this.gwZ != null) {
            this.gwR = (VotePhotoGroupView) this.gwQ.findViewById(d.h.picvote_view);
            this.gwR.setOnVoteCheckedChangedListener(this.aSM);
            this.gwR.setVisibility(0);
            this.gwR.setMode(i);
            this.gwR.a(this.gwZ.getOptions(), z, this.gwZ.getIsPolled() == 1);
        }
    }

    private void aYJ() {
        if (this.gwQ != null && this.gwZ != null) {
            ((TextView) this.gwQ.findViewById(d.h.tv_vote_endtime)).setText(this.gwZ.getTips());
            ((TextView) this.gwQ.findViewById(d.h.vote_num)).setText(getPageContext().getPageActivity().getString(d.l.pb_vote_num, new Object[]{Long.valueOf(this.gwZ.getTotalNum())}));
            bwM();
        }
    }

    private void bwK() {
        if (this.gwQ != null && this.gwZ != null) {
            this.gwS = (VoteTextGroupView) this.gwQ.findViewById(d.h.textvote_view);
            this.gwS.setOnVoteCheckedChangedListener(this.aSM);
            this.gwS.setVisibility(0);
            this.gwS.setMode(this.gwZ.getIsMulti() == 1 ? 1 : 2);
            this.gwS.I(this.gwZ.getOptions());
            this.gwS.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void mV(boolean z) {
        if (this.gwQ != null && this.gwZ != null) {
            this.gwR = (VotePhotoGroupView) this.gwQ.findViewById(d.h.picvote_view);
            this.gwS = (VoteTextGroupView) this.gwQ.findViewById(d.h.textvote_view);
            this.gwT = (VoteView) this.gwQ.findViewById(d.h.result_vote_view);
            this.gwS.setVisibility(8);
            this.gwR.setVisibility(8);
            this.gwT.setVisibility(0);
            this.gwT.setWidth(this.maxWidth);
            this.gwT.b(this.gwZ.getOptions(), z);
            this.gwT.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwL() {
        if (this.gwZ != null) {
            if (this.gxc != null && this.eGA != null) {
                this.gxc.c(this.eGA.getActivity().getString(d.l.vote_succ));
            }
            this.gwZ.setIsPolled(1);
            this.gwZ.setTotalNum(this.gwZ.getTotalNum() + 1);
            this.gwZ.setTotalPoll(this.gwZ.getTotalPoll() + this.gxa.size());
            for (b bVar : this.gxa) {
                if (bVar != null) {
                    bVar.setNum(bVar.getNum() + 1);
                }
            }
            if (this.gwZ.getTotalPoll() > 0) {
                for (com.baidu.tbadk.widget.vote.a aVar : this.gwZ.getOptions()) {
                    if (aVar instanceof b) {
                        b bVar2 = (b) aVar;
                        bVar2.ck((int) ((bVar2.getNum() * 100) / this.gwZ.getTotalPoll()));
                    }
                }
            }
            a(this.gwZ, true);
            this.gxa.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkMessageIsBelongToCurPage(ResponsedMessage<?> responsedMessage) {
        return (responsedMessage == null || this.mContext == null || responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() != this.mContext.getUniqueId()) ? false : true;
    }

    public void onChangeSkinType() {
        if (this.gwQ != null) {
            com.baidu.tbadk.o.a.a(this.eGA.getPageContext(), this.gwQ);
        }
        bwM();
    }

    private void bwM() {
        if (this.gwY != null && this.gwZ != null) {
            if (this.gwZ.getStatus() == 2) {
                ai.j(this.gwY, d.g.bg_gray_circle);
                this.gwY.setText(getPageContext().getString(d.l.pb_vote_over));
                this.gwY.setEnabled(false);
            } else if (this.gwZ.getIsPolled() == 1) {
                ai.j(this.gwY, d.g.bg_gray_circle);
                this.gwY.setText(getPageContext().getString(d.l.pb_voted));
                this.gwY.setEnabled(false);
            } else if (this.gwZ.getIsPolled() == 0) {
                ai.j(this.gwY, d.g.btn_pb_vote_selector);
                this.gwY.setText(getPageContext().getString(d.l.vote));
                this.gwY.setEnabled(true);
                this.gwY.setOnClickListener(this.mOnClickListener);
            }
            ai.c(this.gwY, d.e.cp_cont_i, 1);
        }
    }
}
