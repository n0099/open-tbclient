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
    private com.baidu.tbadk.widget.vote.b aSv;
    private PbActivity eHK;
    private View gyc;
    private VotePhotoGroupView gyd;
    private VoteTextGroupView gye;
    private VoteView gyf;
    private LinearLayout gyg;
    private TextView gyh;
    private TextView gyi;
    private TextView gyj;
    private TextView gyk;
    private VoteDataInfo gyl;
    private final List<b> gym;
    private boolean gyn;
    private com.baidu.tbadk.core.view.c gyo;
    private final com.baidu.adp.framework.listener.a gyp;
    private long mForumId;
    private final View.OnClickListener mOnClickListener;
    private int mSkinType;
    private long mThreadId;
    private int maxWidth;

    public void setVisibility(int i) {
        if (this.gyc != null) {
            this.gyc.setVisibility(i);
        }
    }

    public void bwL() {
        if (this.gyd != null) {
            this.gyd.setPadding(0, 0, 0, 0);
        }
    }

    public a(PbActivity pbActivity) {
        super(pbActivity.getPageContext());
        this.mSkinType = 3;
        this.gym = new ArrayList();
        this.gyn = false;
        this.maxWidth = 0;
        this.aSv = new com.baidu.tbadk.widget.vote.b() { // from class: com.baidu.tieba.vote.a.2
            @Override // com.baidu.tbadk.widget.vote.b
            public void a(com.baidu.tbadk.widget.vote.a aVar, int i, boolean z) {
                if (a.this.gyl != null && a.this.gyl.getOptions() != null && i >= 0 && i < a.this.gyl.getOptions().size()) {
                    ((b) a.this.gyl.getOptions().get(i)).setSelected(z);
                }
            }
        };
        this.gyp = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_ADD_VOTE, 309006) { // from class: com.baidu.tieba.vote.a.3
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                a.this.gyn = false;
                if (a.this.checkMessageIsBelongToCurPage(responsedMessage)) {
                    if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                        String errorString = responsedMessage.getErrorString();
                        String string = TbadkCoreApplication.getInst().getString(d.l.neterror);
                        if (!StringUtils.isNull(errorString)) {
                            string = errorString;
                        }
                        k.showToast(TbadkCoreApplication.getInst(), string);
                    } else if (responsedMessage instanceof AddVoteHttpProtoResponse) {
                        a.this.bwN();
                    } else if (responsedMessage instanceof AddVoteSocketResponse) {
                        a.this.bwN();
                    }
                }
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.vote.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == d.h.btn_pb_vote && a.this.eHK != null && a.this.eHK.checkUpIsLogin() && a.this.gyl != null && a.this.mForumId > 0 && a.this.mThreadId > 0 && !a.this.gyn) {
                    AddVoteModel addVoteModel = new AddVoteModel(a.this.eHK);
                    StringBuilder sb = new StringBuilder();
                    List<com.baidu.tbadk.widget.vote.a> options = a.this.gyl.getOptions();
                    if (options != null) {
                        for (com.baidu.tbadk.widget.vote.a aVar : options) {
                            if (aVar != null && aVar.isSelected()) {
                                sb.append(aVar.getId()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                                a.this.gym.add((b) aVar);
                                if (a.this.gyl.getIsMulti() != 1) {
                                    break;
                                }
                            }
                        }
                        if (sb.toString().endsWith(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                            sb.deleteCharAt(sb.length() - 1);
                        }
                        if (TextUtils.isEmpty(sb.toString())) {
                            UtilHelper.showToast(a.this.eHK.getActivity(), d.l.vote_checked_less_one);
                            return;
                        }
                        addVoteModel.a(a.this.mForumId, a.this.mThreadId, sb.toString());
                        a.this.gyn = true;
                    }
                }
            }
        };
        this.eHK = pbActivity;
        pbActivity.registerListener(this.gyp);
        this.maxWidth = k.ae(TbadkCoreApplication.getInst()) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds120);
        this.gyo = new com.baidu.tbadk.core.view.c();
    }

    public void a(View view, f fVar) {
        if (fVar != null && fVar.aPg() != null && fVar.aPi() != null && view != null) {
            this.mForumId = com.baidu.adp.lib.g.b.c(fVar.aPg().getId(), 0L);
            this.mThreadId = com.baidu.adp.lib.g.b.c(fVar.aPi().getId(), 0L);
            if (fVar.aPi().sn() && fVar.aPi().rp() != null) {
                if (this.gyc == null) {
                    this.gyc = ((ViewStub) view.findViewById(d.h.vote_card_layout)).inflate();
                    this.gyk = (TextView) this.gyc.findViewById(d.h.btn_pb_vote);
                    this.gyl = fVar.aPf();
                    b((PostData) v.c(fVar.aPk(), 0), this.gyc);
                    a(this.gyl, false);
                }
                if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                    onChangeSkinType();
                }
                this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
                if (!this.gyc.isShown()) {
                    this.gyc.setVisibility(0);
                }
            } else if (this.gyc != null && this.gyc.isShown()) {
                this.gyc.setVisibility(8);
            }
        }
    }

    private void b(PostData postData, View view) {
        this.gyg = (LinearLayout) view.findViewById(d.h.pb_vote_location_container);
        this.gyh = (TextView) view.findViewById(d.h.pb_vote_first_floor_name);
        this.gyi = (TextView) view.findViewById(d.h.pb_item_vote_reply_time);
        this.gyj = (TextView) view.findViewById(d.h.pb_item_vote_location_address);
        h hVar = null;
        if (postData != null) {
            this.gyi.setText(postData.bsB());
            hVar = postData.bsC();
        }
        if (hVar != null && !TextUtils.isEmpty(hVar.getName()) && !TextUtils.isEmpty(hVar.getName().trim())) {
            final String name = hVar.getName();
            final String lat = hVar.getLat();
            final String lng = hVar.getLng();
            this.gyj.setVisibility(0);
            this.gyj.setText(hVar.getName());
            this.gyj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.vote.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (TbadkCoreApplication.getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(lat) && !StringUtils.isNull(lng)) {
                        if (!i.hi()) {
                            a.this.eHK.showToast(d.l.neterror);
                        } else {
                            com.baidu.tbadk.browser.a.T(a.this.eHK.getPageContext().getPageActivity(), String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", lat + Constants.ACCEPT_TIME_SEPARATOR_SP + lng, name, name, a.this.mContext.getString(d.l.app_info_for_map)));
                        }
                    }
                }
            });
            return;
        }
        this.gyj.setVisibility(8);
    }

    private void a(VoteDataInfo voteDataInfo, boolean z) {
        this.gyl = voteDataInfo;
        if (this.gyl != null) {
            if (this.gyl.getStatus() == 2 || this.gyl.getIsPolled() == 0) {
                for (com.baidu.tbadk.widget.vote.a aVar : this.gyl.getOptions()) {
                    if (aVar != null && (aVar instanceof b)) {
                        ((b) aVar).setSelected(false);
                    }
                }
            }
            aYI();
            if (this.gyl.getVoteType() == 1) {
                if (this.gyl.getStatus() == 2 || this.gyl.getIsPolled() == 1) {
                    nf(z);
                } else {
                    bwM();
                }
            } else if (this.gyl.getVoteType() == 2) {
                if (this.gyl.getStatus() == 2 || this.gyl.getIsPolled() == 1) {
                    D(2, z);
                } else {
                    D(this.gyl.getIsMulti() == 1 ? 1 : 3, z);
                }
            }
        }
    }

    private void D(int i, boolean z) {
        if (this.gyc != null && this.gyl != null) {
            this.gyd = (VotePhotoGroupView) this.gyc.findViewById(d.h.picvote_view);
            this.gyd.setOnVoteCheckedChangedListener(this.aSv);
            this.gyd.setVisibility(0);
            this.gyd.setMode(i);
            this.gyd.a(this.gyl.getOptions(), z, this.gyl.getIsPolled() == 1);
        }
    }

    private void aYI() {
        if (this.gyc != null && this.gyl != null) {
            ((TextView) this.gyc.findViewById(d.h.tv_vote_endtime)).setText(this.gyl.getTips());
            ((TextView) this.gyc.findViewById(d.h.vote_num)).setText(getPageContext().getPageActivity().getString(d.l.pb_vote_num, new Object[]{Long.valueOf(this.gyl.getTotalNum())}));
            bwO();
        }
    }

    private void bwM() {
        if (this.gyc != null && this.gyl != null) {
            this.gye = (VoteTextGroupView) this.gyc.findViewById(d.h.textvote_view);
            this.gye.setOnVoteCheckedChangedListener(this.aSv);
            this.gye.setVisibility(0);
            this.gye.setMode(this.gyl.getIsMulti() == 1 ? 1 : 2);
            this.gye.I(this.gyl.getOptions());
            this.gye.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void nf(boolean z) {
        if (this.gyc != null && this.gyl != null) {
            this.gyd = (VotePhotoGroupView) this.gyc.findViewById(d.h.picvote_view);
            this.gye = (VoteTextGroupView) this.gyc.findViewById(d.h.textvote_view);
            this.gyf = (VoteView) this.gyc.findViewById(d.h.result_vote_view);
            this.gye.setVisibility(8);
            this.gyd.setVisibility(8);
            this.gyf.setVisibility(0);
            this.gyf.setWidth(this.maxWidth);
            this.gyf.b(this.gyl.getOptions(), z);
            this.gyf.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwN() {
        if (this.gyl != null) {
            if (this.gyo != null && this.eHK != null) {
                this.gyo.c(this.eHK.getActivity().getString(d.l.vote_succ));
            }
            this.gyl.setIsPolled(1);
            this.gyl.setTotalNum(this.gyl.getTotalNum() + 1);
            this.gyl.setTotalPoll(this.gyl.getTotalPoll() + this.gym.size());
            for (b bVar : this.gym) {
                if (bVar != null) {
                    bVar.setNum(bVar.getNum() + 1);
                }
            }
            if (this.gyl.getTotalPoll() > 0) {
                for (com.baidu.tbadk.widget.vote.a aVar : this.gyl.getOptions()) {
                    if (aVar instanceof b) {
                        b bVar2 = (b) aVar;
                        bVar2.ck((int) ((bVar2.getNum() * 100) / this.gyl.getTotalPoll()));
                    }
                }
            }
            a(this.gyl, true);
            this.gym.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkMessageIsBelongToCurPage(ResponsedMessage<?> responsedMessage) {
        return (responsedMessage == null || this.mContext == null || responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() != this.mContext.getUniqueId()) ? false : true;
    }

    public void onChangeSkinType() {
        if (this.gyc != null) {
            com.baidu.tbadk.o.a.a(this.eHK.getPageContext(), this.gyc);
        }
        bwO();
    }

    private void bwO() {
        if (this.gyk != null && this.gyl != null) {
            if (this.gyl.getStatus() == 2) {
                aj.j(this.gyk, d.g.bg_gray_circle);
                this.gyk.setText(getPageContext().getString(d.l.pb_vote_over));
                this.gyk.setEnabled(false);
            } else if (this.gyl.getIsPolled() == 1) {
                aj.j(this.gyk, d.g.bg_gray_circle);
                this.gyk.setText(getPageContext().getString(d.l.pb_voted));
                this.gyk.setEnabled(false);
            } else if (this.gyl.getIsPolled() == 0) {
                aj.j(this.gyk, d.g.btn_pb_vote_selector);
                this.gyk.setText(getPageContext().getString(d.l.vote));
                this.gyk.setEnabled(true);
                this.gyk.setOnClickListener(this.mOnClickListener);
            }
            aj.c(this.gyk, d.e.cp_cont_i, 1);
        }
    }
}
