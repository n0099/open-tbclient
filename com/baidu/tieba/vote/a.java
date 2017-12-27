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
import com.baidu.tbadk.core.view.d;
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
/* loaded from: classes2.dex */
public class a extends c<PbActivity> {
    private com.baidu.tbadk.widget.vote.b bKp;
    private PbActivity fHW;
    private View hJI;
    private VotePhotoGroupView hJJ;
    private VoteTextGroupView hJK;
    private VoteView hJL;
    private TextView hJM;
    private TextView hJN;
    private TextView hJO;
    private VoteDataInfo hJP;
    private final List<b> hJQ;
    private boolean hJR;
    private d hJS;
    private final com.baidu.adp.framework.listener.a hJT;
    private long mForumId;
    private final View.OnClickListener mOnClickListener;
    private int mSkinType;
    private long mThreadId;
    private int maxWidth;

    public void setVisibility(int i) {
        if (this.hJI != null) {
            this.hJI.setVisibility(i);
        }
    }

    public void bKx() {
        if (this.hJJ != null) {
            this.hJJ.setPadding(0, 0, 0, 0);
        }
    }

    public a(PbActivity pbActivity) {
        super(pbActivity.getPageContext());
        this.mSkinType = 3;
        this.hJQ = new ArrayList();
        this.hJR = false;
        this.maxWidth = 0;
        this.bKp = new com.baidu.tbadk.widget.vote.b() { // from class: com.baidu.tieba.vote.a.2
            @Override // com.baidu.tbadk.widget.vote.b
            public void a(com.baidu.tbadk.widget.vote.a aVar, int i, boolean z) {
                if (a.this.hJP != null && a.this.hJP.getOptions() != null && i >= 0 && i < a.this.hJP.getOptions().size()) {
                    ((b) a.this.hJP.getOptions().get(i)).setSelected(z);
                }
            }
        };
        this.hJT = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_ADD_VOTE, 309006) { // from class: com.baidu.tieba.vote.a.3
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                a.this.hJR = false;
                if (a.this.checkMessageIsBelongToCurPage(responsedMessage)) {
                    if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                        String errorString = responsedMessage.getErrorString();
                        String string = TbadkCoreApplication.getInst().getString(d.j.neterror);
                        if (!StringUtils.isNull(errorString)) {
                            string = errorString;
                        }
                        l.showToast(TbadkCoreApplication.getInst(), string);
                    } else if (responsedMessage instanceof AddVoteHttpProtoResponse) {
                        a.this.bKz();
                    } else if (responsedMessage instanceof AddVoteSocketResponse) {
                        a.this.bKz();
                    }
                }
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.vote.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == d.g.btn_pb_vote && a.this.fHW != null && a.this.fHW.checkUpIsLogin() && a.this.hJP != null && a.this.mForumId > 0 && a.this.mThreadId > 0 && !a.this.hJR) {
                    AddVoteModel addVoteModel = new AddVoteModel(a.this.fHW);
                    StringBuilder sb = new StringBuilder();
                    List<com.baidu.tbadk.widget.vote.a> options = a.this.hJP.getOptions();
                    if (options != null) {
                        for (com.baidu.tbadk.widget.vote.a aVar : options) {
                            if (aVar != null && aVar.isSelected()) {
                                sb.append(aVar.getId()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                                a.this.hJQ.add((b) aVar);
                                if (a.this.hJP.getIsMulti() != 1) {
                                    break;
                                }
                            }
                        }
                        if (sb.toString().endsWith(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                            sb.deleteCharAt(sb.length() - 1);
                        }
                        if (TextUtils.isEmpty(sb.toString())) {
                            UtilHelper.showToast(a.this.fHW.getActivity(), d.j.vote_checked_less_one);
                            return;
                        }
                        addVoteModel.a(a.this.mForumId, a.this.mThreadId, sb.toString());
                        a.this.hJR = true;
                    }
                }
            }
        };
        this.fHW = pbActivity;
        pbActivity.registerListener(this.hJT);
        this.maxWidth = l.ao(TbadkCoreApplication.getInst()) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds120);
        this.hJS = new com.baidu.tbadk.core.view.d();
    }

    public void a(View view, f fVar) {
        if (fVar != null && fVar.aYy() != null && fVar.aYA() != null && view != null) {
            this.mForumId = com.baidu.adp.lib.g.b.c(fVar.aYy().getId(), 0L);
            this.mThreadId = com.baidu.adp.lib.g.b.c(fVar.aYA().getId(), 0L);
            if (fVar.aYA().zJ() && fVar.aYA().yJ() != null) {
                if (this.hJI == null) {
                    this.hJI = ((ViewStub) view.findViewById(d.g.vote_card_layout)).inflate();
                    this.hJO = (TextView) this.hJI.findViewById(d.g.btn_pb_vote);
                    this.hJP = fVar.aYx();
                    b((PostData) v.f(fVar.aYC(), 0), this.hJI);
                    a(this.hJP, false);
                }
                if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                    onChangeSkinType();
                }
                this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
                if (!this.hJI.isShown()) {
                    this.hJI.setVisibility(0);
                }
            } else if (this.hJI != null && this.hJI.isShown()) {
                this.hJI.setVisibility(8);
            }
        }
    }

    private void b(PostData postData, View view) {
        this.hJM = (TextView) view.findViewById(d.g.pb_item_vote_reply_time);
        this.hJN = (TextView) view.findViewById(d.g.pb_item_vote_location_address);
        com.baidu.tbadk.data.f fVar = null;
        if (postData != null) {
            this.hJM.setText(postData.bCn());
            fVar = postData.bCp();
        }
        if (fVar != null && !TextUtils.isEmpty(fVar.getName()) && !TextUtils.isEmpty(fVar.getName().trim())) {
            final String name = fVar.getName();
            final String lat = fVar.getLat();
            final String lng = fVar.getLng();
            this.hJN.setVisibility(0);
            this.hJN.setText(fVar.getName());
            this.hJN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.vote.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (TbadkCoreApplication.getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(lat) && !StringUtils.isNull(lng)) {
                        if (!j.oI()) {
                            a.this.fHW.showToast(d.j.neterror);
                        } else {
                            com.baidu.tbadk.browser.a.R(a.this.fHW.getPageContext().getPageActivity(), String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", lat + Constants.ACCEPT_TIME_SEPARATOR_SP + lng, name, name, a.this.mContext.getString(d.j.app_info_for_map)));
                        }
                    }
                }
            });
            return;
        }
        this.hJN.setVisibility(8);
    }

    private void a(VoteDataInfo voteDataInfo, boolean z) {
        this.hJP = voteDataInfo;
        if (this.hJP != null) {
            if (this.hJP.getStatus() == 2 || this.hJP.getIsPolled() == 0) {
                for (com.baidu.tbadk.widget.vote.a aVar : this.hJP.getOptions()) {
                    if (aVar != null && (aVar instanceof b)) {
                        ((b) aVar).setSelected(false);
                    }
                }
            }
            bjt();
            if (this.hJP.getVoteType() == 1) {
                if (this.hJP.getStatus() == 2 || this.hJP.getIsPolled() == 1) {
                    ok(z);
                } else {
                    bKy();
                }
            } else if (this.hJP.getVoteType() == 2) {
                if (this.hJP.getStatus() == 2 || this.hJP.getIsPolled() == 1) {
                    R(2, z);
                } else {
                    R(this.hJP.getIsMulti() == 1 ? 1 : 3, z);
                }
            }
        }
    }

    private void R(int i, boolean z) {
        if (this.hJI != null && this.hJP != null) {
            this.hJJ = (VotePhotoGroupView) this.hJI.findViewById(d.g.picvote_view);
            this.hJJ.setOnVoteCheckedChangedListener(this.bKp);
            this.hJJ.setVisibility(0);
            this.hJJ.setMode(i);
            this.hJJ.a(this.hJP.getOptions(), z, this.hJP.getIsPolled() == 1);
        }
    }

    private void bjt() {
        if (this.hJI != null && this.hJP != null) {
            ((TextView) this.hJI.findViewById(d.g.tv_vote_endtime)).setText(this.hJP.getTips());
            ((TextView) this.hJI.findViewById(d.g.vote_num)).setText(getPageContext().getPageActivity().getString(d.j.pb_vote_num, new Object[]{Long.valueOf(this.hJP.getTotalNum())}));
            bKA();
        }
    }

    private void bKy() {
        if (this.hJI != null && this.hJP != null) {
            this.hJK = (VoteTextGroupView) this.hJI.findViewById(d.g.textvote_view);
            this.hJK.setOnVoteCheckedChangedListener(this.bKp);
            this.hJK.setVisibility(0);
            this.hJK.setMode(this.hJP.getIsMulti() == 1 ? 1 : 2);
            this.hJK.S(this.hJP.getOptions());
            this.hJK.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void ok(boolean z) {
        if (this.hJI != null && this.hJP != null) {
            this.hJJ = (VotePhotoGroupView) this.hJI.findViewById(d.g.picvote_view);
            this.hJK = (VoteTextGroupView) this.hJI.findViewById(d.g.textvote_view);
            this.hJL = (VoteView) this.hJI.findViewById(d.g.result_vote_view);
            this.hJK.setVisibility(8);
            this.hJJ.setVisibility(8);
            this.hJL.setVisibility(0);
            this.hJL.setWidth(this.maxWidth);
            this.hJL.b(this.hJP.getOptions(), z);
            this.hJL.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKz() {
        if (this.hJP != null) {
            if (this.hJS != null && this.fHW != null) {
                this.hJS.q(this.fHW.getActivity().getString(d.j.vote_succ));
            }
            this.hJP.setIsPolled(1);
            this.hJP.setTotalNum(this.hJP.getTotalNum() + 1);
            this.hJP.setTotalPoll(this.hJP.getTotalPoll() + this.hJQ.size());
            for (b bVar : this.hJQ) {
                if (bVar != null) {
                    bVar.setNum(bVar.getNum() + 1);
                }
            }
            if (this.hJP.getTotalPoll() > 0) {
                for (com.baidu.tbadk.widget.vote.a aVar : this.hJP.getOptions()) {
                    if (aVar instanceof b) {
                        b bVar2 = (b) aVar;
                        bVar2.setPercent((int) ((bVar2.getNum() * 100) / this.hJP.getTotalPoll()));
                    }
                }
            }
            a(this.hJP, true);
            this.hJQ.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkMessageIsBelongToCurPage(ResponsedMessage<?> responsedMessage) {
        return (responsedMessage == null || this.mContext == null || responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() != this.mContext.getUniqueId()) ? false : true;
    }

    public void onChangeSkinType() {
        if (this.hJI != null) {
            com.baidu.tbadk.n.a.a(this.fHW.getPageContext(), this.hJI);
        }
        bKA();
    }

    private void bKA() {
        if (this.hJO != null && this.hJP != null) {
            if (this.hJP.getStatus() == 2) {
                aj.s(this.hJO, d.f.bg_gray_circle);
                this.hJO.setText(getPageContext().getString(d.j.pb_vote_over));
                this.hJO.setEnabled(false);
            } else if (this.hJP.getIsPolled() == 1) {
                aj.s(this.hJO, d.f.bg_gray_circle);
                this.hJO.setText(getPageContext().getString(d.j.pb_voted));
                this.hJO.setEnabled(false);
            } else if (this.hJP.getIsPolled() == 0) {
                aj.s(this.hJO, d.f.btn_pb_vote_selector);
                this.hJO.setText(getPageContext().getString(d.j.vote));
                this.hJO.setEnabled(true);
                this.hJO.setOnClickListener(this.mOnClickListener);
            }
            aj.e(this.hJO, d.C0108d.cp_cont_i, 1);
        }
    }
}
