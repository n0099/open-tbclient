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
    private com.baidu.tbadk.widget.vote.b bMw;
    private PbActivity fMQ;
    private View hBc;
    private VotePhotoGroupView hBd;
    private VoteTextGroupView hBe;
    private VoteView hBf;
    private TextView hBg;
    private TextView hBh;
    private TextView hBi;
    private VoteDataInfo hBj;
    private final List<b> hBk;
    private boolean hBl;
    private e hBm;
    private final com.baidu.adp.framework.listener.a hBn;
    private long mForumId;
    private final View.OnClickListener mOnClickListener;
    private int mSkinType;
    private long mThreadId;
    private int maxWidth;

    public void setVisibility(int i) {
        if (this.hBc != null) {
            this.hBc.setVisibility(i);
        }
    }

    public void bEO() {
        if (this.hBd != null) {
            this.hBd.setPadding(0, 0, 0, 0);
        }
    }

    public a(PbActivity pbActivity) {
        super(pbActivity.getPageContext());
        this.mSkinType = 3;
        this.hBk = new ArrayList();
        this.hBl = false;
        this.maxWidth = 0;
        this.bMw = new com.baidu.tbadk.widget.vote.b() { // from class: com.baidu.tieba.vote.a.2
            @Override // com.baidu.tbadk.widget.vote.b
            public void a(com.baidu.tbadk.widget.vote.a aVar, int i, boolean z) {
                if (a.this.hBj != null && a.this.hBj.getOptions() != null && i >= 0 && i < a.this.hBj.getOptions().size()) {
                    ((b) a.this.hBj.getOptions().get(i)).setSelected(z);
                }
            }
        };
        this.hBn = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_ADD_VOTE, 309006) { // from class: com.baidu.tieba.vote.a.3
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                a.this.hBl = false;
                if (a.this.checkMessageIsBelongToCurPage(responsedMessage)) {
                    if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                        String errorString = responsedMessage.getErrorString();
                        String string = TbadkCoreApplication.getInst().getString(d.j.neterror);
                        if (!StringUtils.isNull(errorString)) {
                            string = errorString;
                        }
                        l.showToast(TbadkCoreApplication.getInst(), string);
                    } else if (responsedMessage instanceof AddVoteHttpProtoResponse) {
                        a.this.bEQ();
                    } else if (responsedMessage instanceof AddVoteSocketResponse) {
                        a.this.bEQ();
                    }
                }
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.vote.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == d.g.btn_pb_vote && a.this.fMQ != null && a.this.fMQ.checkUpIsLogin() && a.this.hBj != null && a.this.mForumId > 0 && a.this.mThreadId > 0 && !a.this.hBl) {
                    AddVoteModel addVoteModel = new AddVoteModel(a.this.fMQ);
                    StringBuilder sb = new StringBuilder();
                    List<com.baidu.tbadk.widget.vote.a> options = a.this.hBj.getOptions();
                    if (options != null) {
                        for (com.baidu.tbadk.widget.vote.a aVar : options) {
                            if (aVar != null && aVar.isSelected()) {
                                sb.append(aVar.getId()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                                a.this.hBk.add((b) aVar);
                                if (a.this.hBj.getIsMulti() != 1) {
                                    break;
                                }
                            }
                        }
                        if (sb.toString().endsWith(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                            sb.deleteCharAt(sb.length() - 1);
                        }
                        if (TextUtils.isEmpty(sb.toString())) {
                            UtilHelper.showToast(a.this.fMQ.getActivity(), d.j.vote_checked_less_one);
                            return;
                        }
                        addVoteModel.a(a.this.mForumId, a.this.mThreadId, sb.toString());
                        a.this.hBl = true;
                    }
                }
            }
        };
        this.fMQ = pbActivity;
        pbActivity.registerListener(this.hBn);
        this.maxWidth = l.ao(TbadkCoreApplication.getInst()) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds120);
        this.hBm = new e();
    }

    public void a(View view, com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && dVar.bar() != null && dVar.bat() != null && view != null) {
            this.mForumId = com.baidu.adp.lib.g.b.c(dVar.bar().getId(), 0L);
            this.mThreadId = com.baidu.adp.lib.g.b.c(dVar.bat().getId(), 0L);
            if (dVar.bat().zZ() && dVar.bat().yZ() != null) {
                if (this.hBc == null) {
                    this.hBc = ((ViewStub) view.findViewById(d.g.vote_card_layout)).inflate();
                    this.hBi = (TextView) this.hBc.findViewById(d.g.btn_pb_vote);
                    this.hBj = dVar.baq();
                    b((PostData) v.f(dVar.bav(), 0), this.hBc);
                    a(this.hBj, false);
                }
                if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                    onChangeSkinType();
                }
                this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
                if (!this.hBc.isShown()) {
                    this.hBc.setVisibility(0);
                }
            } else if (this.hBc != null && this.hBc.isShown()) {
                this.hBc.setVisibility(8);
            }
        }
    }

    private void b(PostData postData, View view) {
        this.hBg = (TextView) view.findViewById(d.g.pb_item_vote_reply_time);
        this.hBh = (TextView) view.findViewById(d.g.pb_item_vote_location_address);
        f fVar = null;
        if (postData != null) {
            this.hBg.setText(postData.bwV());
            fVar = postData.bwX();
        }
        if (fVar != null && !TextUtils.isEmpty(fVar.getName()) && !TextUtils.isEmpty(fVar.getName().trim())) {
            final String name = fVar.getName();
            final String lat = fVar.getLat();
            final String lng = fVar.getLng();
            this.hBh.setVisibility(0);
            this.hBh.setText(fVar.getName());
            this.hBh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.vote.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (TbadkCoreApplication.getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(lat) && !StringUtils.isNull(lng)) {
                        if (!j.oJ()) {
                            a.this.fMQ.showToast(d.j.neterror);
                        } else {
                            com.baidu.tbadk.browser.b.R(a.this.fMQ.getPageContext().getPageActivity(), String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", lat + Constants.ACCEPT_TIME_SEPARATOR_SP + lng, name, name, a.this.mContext.getString(d.j.app_info_for_map)));
                        }
                    }
                }
            });
            return;
        }
        this.hBh.setVisibility(8);
    }

    private void a(VoteDataInfo voteDataInfo, boolean z) {
        this.hBj = voteDataInfo;
        if (this.hBj != null) {
            if (this.hBj.getStatus() == 2 || this.hBj.getIsPolled() == 0) {
                for (com.baidu.tbadk.widget.vote.a aVar : this.hBj.getOptions()) {
                    if (aVar != null && (aVar instanceof b)) {
                        ((b) aVar).setSelected(false);
                    }
                }
            }
            bkE();
            if (this.hBj.getVoteType() == 1) {
                if (this.hBj.getStatus() == 2 || this.hBj.getIsPolled() == 1) {
                    nx(z);
                } else {
                    bEP();
                }
            } else if (this.hBj.getVoteType() == 2) {
                if (this.hBj.getStatus() == 2 || this.hBj.getIsPolled() == 1) {
                    X(2, z);
                } else {
                    X(this.hBj.getIsMulti() == 1 ? 1 : 3, z);
                }
            }
        }
    }

    private void X(int i, boolean z) {
        if (this.hBc != null && this.hBj != null) {
            this.hBd = (VotePhotoGroupView) this.hBc.findViewById(d.g.picvote_view);
            this.hBd.setOnVoteCheckedChangedListener(this.bMw);
            this.hBd.setVisibility(0);
            this.hBd.setMode(i);
            this.hBd.a(this.hBj.getOptions(), z, this.hBj.getIsPolled() == 1);
        }
    }

    private void bkE() {
        if (this.hBc != null && this.hBj != null) {
            ((TextView) this.hBc.findViewById(d.g.tv_vote_endtime)).setText(this.hBj.getTips());
            ((TextView) this.hBc.findViewById(d.g.vote_num)).setText(getPageContext().getPageActivity().getString(d.j.pb_vote_num, new Object[]{Long.valueOf(this.hBj.getTotalNum())}));
            bER();
        }
    }

    private void bEP() {
        if (this.hBc != null && this.hBj != null) {
            this.hBe = (VoteTextGroupView) this.hBc.findViewById(d.g.textvote_view);
            this.hBe.setOnVoteCheckedChangedListener(this.bMw);
            this.hBe.setVisibility(0);
            this.hBe.setMode(this.hBj.getIsMulti() == 1 ? 1 : 2);
            this.hBe.S(this.hBj.getOptions());
            this.hBe.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void nx(boolean z) {
        if (this.hBc != null && this.hBj != null) {
            this.hBd = (VotePhotoGroupView) this.hBc.findViewById(d.g.picvote_view);
            this.hBe = (VoteTextGroupView) this.hBc.findViewById(d.g.textvote_view);
            this.hBf = (VoteView) this.hBc.findViewById(d.g.result_vote_view);
            this.hBe.setVisibility(8);
            this.hBd.setVisibility(8);
            this.hBf.setVisibility(0);
            this.hBf.setWidth(this.maxWidth);
            this.hBf.b(this.hBj.getOptions(), z);
            this.hBf.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEQ() {
        if (this.hBj != null) {
            if (this.hBm != null && this.fMQ != null) {
                this.hBm.q(this.fMQ.getActivity().getString(d.j.vote_succ));
            }
            this.hBj.setIsPolled(1);
            this.hBj.setTotalNum(this.hBj.getTotalNum() + 1);
            this.hBj.setTotalPoll(this.hBj.getTotalPoll() + this.hBk.size());
            for (b bVar : this.hBk) {
                if (bVar != null) {
                    bVar.setNum(bVar.getNum() + 1);
                }
            }
            if (this.hBj.getTotalPoll() > 0) {
                for (com.baidu.tbadk.widget.vote.a aVar : this.hBj.getOptions()) {
                    if (aVar instanceof b) {
                        b bVar2 = (b) aVar;
                        bVar2.setPercent((int) ((bVar2.getNum() * 100) / this.hBj.getTotalPoll()));
                    }
                }
            }
            a(this.hBj, true);
            this.hBk.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkMessageIsBelongToCurPage(ResponsedMessage<?> responsedMessage) {
        return (responsedMessage == null || this.mContext == null || responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() != this.mContext.getUniqueId()) ? false : true;
    }

    public void onChangeSkinType() {
        if (this.hBc != null) {
            com.baidu.tbadk.n.a.a(this.fMQ.getPageContext(), this.hBc);
        }
        bER();
    }

    private void bER() {
        if (this.hBi != null && this.hBj != null) {
            if (this.hBj.getStatus() == 2) {
                aj.s(this.hBi, d.f.bg_gray_circle);
                this.hBi.setText(getPageContext().getString(d.j.pb_vote_over));
                this.hBi.setEnabled(false);
            } else if (this.hBj.getIsPolled() == 1) {
                aj.s(this.hBi, d.f.bg_gray_circle);
                this.hBi.setText(getPageContext().getString(d.j.pb_voted));
                this.hBi.setEnabled(false);
            } else if (this.hBj.getIsPolled() == 0) {
                aj.s(this.hBi, d.f.btn_pb_vote_selector);
                this.hBi.setText(getPageContext().getString(d.j.vote));
                this.hBi.setEnabled(true);
                this.hBi.setOnClickListener(this.mOnClickListener);
            }
            aj.e(this.hBi, d.C0141d.cp_cont_i, 1);
        }
    }
}
