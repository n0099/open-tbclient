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
    private com.baidu.tbadk.widget.vote.b aWu;
    private PbActivity eUm;
    private View gYQ;
    private VotePhotoGroupView gYR;
    private VoteTextGroupView gYS;
    private VoteView gYT;
    private TextView gYU;
    private TextView gYV;
    private TextView gYW;
    private VoteDataInfo gYX;
    private final List<b> gYY;
    private boolean gYZ;
    private com.baidu.tbadk.core.view.c gZa;
    private final com.baidu.adp.framework.listener.a gZb;
    private long mForumId;
    private final View.OnClickListener mOnClickListener;
    private int mSkinType;
    private long mThreadId;
    private int maxWidth;

    public void setVisibility(int i) {
        if (this.gYQ != null) {
            this.gYQ.setVisibility(i);
        }
    }

    public void bEc() {
        if (this.gYR != null) {
            this.gYR.setPadding(0, 0, 0, 0);
        }
    }

    public a(PbActivity pbActivity) {
        super(pbActivity.getPageContext());
        this.mSkinType = 3;
        this.gYY = new ArrayList();
        this.gYZ = false;
        this.maxWidth = 0;
        this.aWu = new com.baidu.tbadk.widget.vote.b() { // from class: com.baidu.tieba.vote.a.2
            @Override // com.baidu.tbadk.widget.vote.b
            public void a(com.baidu.tbadk.widget.vote.a aVar, int i, boolean z) {
                if (a.this.gYX != null && a.this.gYX.getOptions() != null && i >= 0 && i < a.this.gYX.getOptions().size()) {
                    ((b) a.this.gYX.getOptions().get(i)).setSelected(z);
                }
            }
        };
        this.gZb = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_ADD_VOTE, 309006) { // from class: com.baidu.tieba.vote.a.3
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                a.this.gYZ = false;
                if (a.this.checkMessageIsBelongToCurPage(responsedMessage)) {
                    if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                        String errorString = responsedMessage.getErrorString();
                        String string = TbadkCoreApplication.getInst().getString(d.j.neterror);
                        if (!StringUtils.isNull(errorString)) {
                            string = errorString;
                        }
                        l.showToast(TbadkCoreApplication.getInst(), string);
                    } else if (responsedMessage instanceof AddVoteHttpProtoResponse) {
                        a.this.bEe();
                    } else if (responsedMessage instanceof AddVoteSocketResponse) {
                        a.this.bEe();
                    }
                }
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.vote.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == d.g.btn_pb_vote && a.this.eUm != null && a.this.eUm.checkUpIsLogin() && a.this.gYX != null && a.this.mForumId > 0 && a.this.mThreadId > 0 && !a.this.gYZ) {
                    AddVoteModel addVoteModel = new AddVoteModel(a.this.eUm);
                    StringBuilder sb = new StringBuilder();
                    List<com.baidu.tbadk.widget.vote.a> options = a.this.gYX.getOptions();
                    if (options != null) {
                        for (com.baidu.tbadk.widget.vote.a aVar : options) {
                            if (aVar != null && aVar.isSelected()) {
                                sb.append(aVar.getId()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                                a.this.gYY.add((b) aVar);
                                if (a.this.gYX.getIsMulti() != 1) {
                                    break;
                                }
                            }
                        }
                        if (sb.toString().endsWith(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                            sb.deleteCharAt(sb.length() - 1);
                        }
                        if (TextUtils.isEmpty(sb.toString())) {
                            UtilHelper.showToast(a.this.eUm.getActivity(), d.j.vote_checked_less_one);
                            return;
                        }
                        addVoteModel.a(a.this.mForumId, a.this.mThreadId, sb.toString());
                        a.this.gYZ = true;
                    }
                }
            }
        };
        this.eUm = pbActivity;
        pbActivity.registerListener(this.gZb);
        this.maxWidth = l.ac(TbadkCoreApplication.getInst()) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds120);
        this.gZa = new com.baidu.tbadk.core.view.c();
    }

    public void a(View view, f fVar) {
        if (fVar != null && fVar.aRf() != null && fVar.aRh() != null && view != null) {
            this.mForumId = com.baidu.adp.lib.g.b.c(fVar.aRf().getId(), 0L);
            this.mThreadId = com.baidu.adp.lib.g.b.c(fVar.aRh().getId(), 0L);
            if (fVar.aRh().sj() && fVar.aRh().rj() != null) {
                if (this.gYQ == null) {
                    this.gYQ = ((ViewStub) view.findViewById(d.g.vote_card_layout)).inflate();
                    this.gYW = (TextView) this.gYQ.findViewById(d.g.btn_pb_vote);
                    this.gYX = fVar.aRe();
                    b((PostData) v.c(fVar.aRj(), 0), this.gYQ);
                    a(this.gYX, false);
                }
                if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                    onChangeSkinType();
                }
                this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
                if (!this.gYQ.isShown()) {
                    this.gYQ.setVisibility(0);
                }
            } else if (this.gYQ != null && this.gYQ.isShown()) {
                this.gYQ.setVisibility(8);
            }
        }
    }

    private void b(PostData postData, View view) {
        this.gYU = (TextView) view.findViewById(d.g.pb_item_vote_reply_time);
        this.gYV = (TextView) view.findViewById(d.g.pb_item_vote_location_address);
        i iVar = null;
        if (postData != null) {
            this.gYU.setText(postData.bwq());
            iVar = postData.bws();
        }
        if (iVar != null && !TextUtils.isEmpty(iVar.getName()) && !TextUtils.isEmpty(iVar.getName().trim())) {
            final String name = iVar.getName();
            final String lat = iVar.getLat();
            final String lng = iVar.getLng();
            this.gYV.setVisibility(0);
            this.gYV.setText(iVar.getName());
            this.gYV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.vote.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (TbadkCoreApplication.getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(lat) && !StringUtils.isNull(lng)) {
                        if (!j.hh()) {
                            a.this.eUm.showToast(d.j.neterror);
                        } else {
                            com.baidu.tbadk.browser.a.P(a.this.eUm.getPageContext().getPageActivity(), String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", lat + Constants.ACCEPT_TIME_SEPARATOR_SP + lng, name, name, a.this.mContext.getString(d.j.app_info_for_map)));
                        }
                    }
                }
            });
            return;
        }
        this.gYV.setVisibility(8);
    }

    private void a(VoteDataInfo voteDataInfo, boolean z) {
        this.gYX = voteDataInfo;
        if (this.gYX != null) {
            if (this.gYX.getStatus() == 2 || this.gYX.getIsPolled() == 0) {
                for (com.baidu.tbadk.widget.vote.a aVar : this.gYX.getOptions()) {
                    if (aVar != null && (aVar instanceof b)) {
                        ((b) aVar).setSelected(false);
                    }
                }
            }
            bbS();
            if (this.gYX.getVoteType() == 1) {
                if (this.gYX.getStatus() == 2 || this.gYX.getIsPolled() == 1) {
                    nP(z);
                } else {
                    bEd();
                }
            } else if (this.gYX.getVoteType() == 2) {
                if (this.gYX.getStatus() == 2 || this.gYX.getIsPolled() == 1) {
                    G(2, z);
                } else {
                    G(this.gYX.getIsMulti() == 1 ? 1 : 3, z);
                }
            }
        }
    }

    private void G(int i, boolean z) {
        if (this.gYQ != null && this.gYX != null) {
            this.gYR = (VotePhotoGroupView) this.gYQ.findViewById(d.g.picvote_view);
            this.gYR.setOnVoteCheckedChangedListener(this.aWu);
            this.gYR.setVisibility(0);
            this.gYR.setMode(i);
            this.gYR.a(this.gYX.getOptions(), z, this.gYX.getIsPolled() == 1);
        }
    }

    private void bbS() {
        if (this.gYQ != null && this.gYX != null) {
            ((TextView) this.gYQ.findViewById(d.g.tv_vote_endtime)).setText(this.gYX.getTips());
            ((TextView) this.gYQ.findViewById(d.g.vote_num)).setText(getPageContext().getPageActivity().getString(d.j.pb_vote_num, new Object[]{Long.valueOf(this.gYX.getTotalNum())}));
            bEf();
        }
    }

    private void bEd() {
        if (this.gYQ != null && this.gYX != null) {
            this.gYS = (VoteTextGroupView) this.gYQ.findViewById(d.g.textvote_view);
            this.gYS.setOnVoteCheckedChangedListener(this.aWu);
            this.gYS.setVisibility(0);
            this.gYS.setMode(this.gYX.getIsMulti() == 1 ? 1 : 2);
            this.gYS.J(this.gYX.getOptions());
            this.gYS.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void nP(boolean z) {
        if (this.gYQ != null && this.gYX != null) {
            this.gYR = (VotePhotoGroupView) this.gYQ.findViewById(d.g.picvote_view);
            this.gYS = (VoteTextGroupView) this.gYQ.findViewById(d.g.textvote_view);
            this.gYT = (VoteView) this.gYQ.findViewById(d.g.result_vote_view);
            this.gYS.setVisibility(8);
            this.gYR.setVisibility(8);
            this.gYT.setVisibility(0);
            this.gYT.setWidth(this.maxWidth);
            this.gYT.b(this.gYX.getOptions(), z);
            this.gYT.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEe() {
        if (this.gYX != null) {
            if (this.gZa != null && this.eUm != null) {
                this.gZa.c(this.eUm.getActivity().getString(d.j.vote_succ));
            }
            this.gYX.setIsPolled(1);
            this.gYX.setTotalNum(this.gYX.getTotalNum() + 1);
            this.gYX.setTotalPoll(this.gYX.getTotalPoll() + this.gYY.size());
            for (b bVar : this.gYY) {
                if (bVar != null) {
                    bVar.setNum(bVar.getNum() + 1);
                }
            }
            if (this.gYX.getTotalPoll() > 0) {
                for (com.baidu.tbadk.widget.vote.a aVar : this.gYX.getOptions()) {
                    if (aVar instanceof b) {
                        b bVar2 = (b) aVar;
                        bVar2.setPercent((int) ((bVar2.getNum() * 100) / this.gYX.getTotalPoll()));
                    }
                }
            }
            a(this.gYX, true);
            this.gYY.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkMessageIsBelongToCurPage(ResponsedMessage<?> responsedMessage) {
        return (responsedMessage == null || this.mContext == null || responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() != this.mContext.getUniqueId()) ? false : true;
    }

    public void onChangeSkinType() {
        if (this.gYQ != null) {
            com.baidu.tbadk.n.a.a(this.eUm.getPageContext(), this.gYQ);
        }
        bEf();
    }

    private void bEf() {
        if (this.gYW != null && this.gYX != null) {
            if (this.gYX.getStatus() == 2) {
                aj.j(this.gYW, d.f.bg_gray_circle);
                this.gYW.setText(getPageContext().getString(d.j.pb_vote_over));
                this.gYW.setEnabled(false);
            } else if (this.gYX.getIsPolled() == 1) {
                aj.j(this.gYW, d.f.bg_gray_circle);
                this.gYW.setText(getPageContext().getString(d.j.pb_voted));
                this.gYW.setEnabled(false);
            } else if (this.gYX.getIsPolled() == 0) {
                aj.j(this.gYW, d.f.btn_pb_vote_selector);
                this.gYW.setText(getPageContext().getString(d.j.vote));
                this.gYW.setEnabled(true);
                this.gYW.setOnClickListener(this.mOnClickListener);
            }
            aj.c(this.gYW, d.C0082d.cp_cont_i, 1);
        }
    }
}
