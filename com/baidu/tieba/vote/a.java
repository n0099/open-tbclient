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
    private com.baidu.tbadk.widget.vote.b aTt;
    private PbActivity eMB;
    private View gNT;
    private VotePhotoGroupView gNU;
    private VoteTextGroupView gNV;
    private VoteView gNW;
    private TextView gNX;
    private TextView gNY;
    private TextView gNZ;
    private VoteDataInfo gOa;
    private final List<b> gOb;
    private boolean gOc;
    private com.baidu.tbadk.core.view.c gOd;
    private final com.baidu.adp.framework.listener.a gOe;
    private long mForumId;
    private final View.OnClickListener mOnClickListener;
    private int mSkinType;
    private long mThreadId;
    private int maxWidth;

    public void setVisibility(int i) {
        if (this.gNT != null) {
            this.gNT.setVisibility(i);
        }
    }

    public void bBw() {
        if (this.gNU != null) {
            this.gNU.setPadding(0, 0, 0, 0);
        }
    }

    public a(PbActivity pbActivity) {
        super(pbActivity.getPageContext());
        this.mSkinType = 3;
        this.gOb = new ArrayList();
        this.gOc = false;
        this.maxWidth = 0;
        this.aTt = new com.baidu.tbadk.widget.vote.b() { // from class: com.baidu.tieba.vote.a.2
            @Override // com.baidu.tbadk.widget.vote.b
            public void a(com.baidu.tbadk.widget.vote.a aVar, int i, boolean z) {
                if (a.this.gOa != null && a.this.gOa.getOptions() != null && i >= 0 && i < a.this.gOa.getOptions().size()) {
                    ((b) a.this.gOa.getOptions().get(i)).setSelected(z);
                }
            }
        };
        this.gOe = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_ADD_VOTE, 309006) { // from class: com.baidu.tieba.vote.a.3
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                a.this.gOc = false;
                if (a.this.checkMessageIsBelongToCurPage(responsedMessage)) {
                    if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                        String errorString = responsedMessage.getErrorString();
                        String string = TbadkCoreApplication.getInst().getString(d.j.neterror);
                        if (!StringUtils.isNull(errorString)) {
                            string = errorString;
                        }
                        l.showToast(TbadkCoreApplication.getInst(), string);
                    } else if (responsedMessage instanceof AddVoteHttpProtoResponse) {
                        a.this.bBy();
                    } else if (responsedMessage instanceof AddVoteSocketResponse) {
                        a.this.bBy();
                    }
                }
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.vote.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == d.g.btn_pb_vote && a.this.eMB != null && a.this.eMB.checkUpIsLogin() && a.this.gOa != null && a.this.mForumId > 0 && a.this.mThreadId > 0 && !a.this.gOc) {
                    AddVoteModel addVoteModel = new AddVoteModel(a.this.eMB);
                    StringBuilder sb = new StringBuilder();
                    List<com.baidu.tbadk.widget.vote.a> options = a.this.gOa.getOptions();
                    if (options != null) {
                        for (com.baidu.tbadk.widget.vote.a aVar : options) {
                            if (aVar != null && aVar.isSelected()) {
                                sb.append(aVar.getId()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                                a.this.gOb.add((b) aVar);
                                if (a.this.gOa.getIsMulti() != 1) {
                                    break;
                                }
                            }
                        }
                        if (sb.toString().endsWith(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                            sb.deleteCharAt(sb.length() - 1);
                        }
                        if (TextUtils.isEmpty(sb.toString())) {
                            UtilHelper.showToast(a.this.eMB.getActivity(), d.j.vote_checked_less_one);
                            return;
                        }
                        addVoteModel.a(a.this.mForumId, a.this.mThreadId, sb.toString());
                        a.this.gOc = true;
                    }
                }
            }
        };
        this.eMB = pbActivity;
        pbActivity.registerListener(this.gOe);
        this.maxWidth = l.ac(TbadkCoreApplication.getInst()) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds120);
        this.gOd = new com.baidu.tbadk.core.view.c();
    }

    public void a(View view, f fVar) {
        if (fVar != null && fVar.aPU() != null && fVar.aPW() != null && view != null) {
            this.mForumId = com.baidu.adp.lib.g.b.c(fVar.aPU().getId(), 0L);
            this.mThreadId = com.baidu.adp.lib.g.b.c(fVar.aPW().getId(), 0L);
            if (fVar.aPW().sg() && fVar.aPW().rf() != null) {
                if (this.gNT == null) {
                    this.gNT = ((ViewStub) view.findViewById(d.g.vote_card_layout)).inflate();
                    this.gNZ = (TextView) this.gNT.findViewById(d.g.btn_pb_vote);
                    this.gOa = fVar.aPT();
                    b((PostData) v.c(fVar.aPY(), 0), this.gNT);
                    a(this.gOa, false);
                }
                if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                    onChangeSkinType();
                }
                this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
                if (!this.gNT.isShown()) {
                    this.gNT.setVisibility(0);
                }
            } else if (this.gNT != null && this.gNT.isShown()) {
                this.gNT.setVisibility(8);
            }
        }
    }

    private void b(PostData postData, View view) {
        this.gNX = (TextView) view.findViewById(d.g.pb_item_vote_reply_time);
        this.gNY = (TextView) view.findViewById(d.g.pb_item_vote_location_address);
        i iVar = null;
        if (postData != null) {
            this.gNX.setText(postData.buI());
            iVar = postData.buJ();
        }
        if (iVar != null && !TextUtils.isEmpty(iVar.getName()) && !TextUtils.isEmpty(iVar.getName().trim())) {
            final String name = iVar.getName();
            final String lat = iVar.getLat();
            final String lng = iVar.getLng();
            this.gNY.setVisibility(0);
            this.gNY.setText(iVar.getName());
            this.gNY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.vote.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (TbadkCoreApplication.getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(lat) && !StringUtils.isNull(lng)) {
                        if (!j.hh()) {
                            a.this.eMB.showToast(d.j.neterror);
                        } else {
                            com.baidu.tbadk.browser.a.O(a.this.eMB.getPageContext().getPageActivity(), String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", lat + Constants.ACCEPT_TIME_SEPARATOR_SP + lng, name, name, a.this.mContext.getString(d.j.app_info_for_map)));
                        }
                    }
                }
            });
            return;
        }
        this.gNY.setVisibility(8);
    }

    private void a(VoteDataInfo voteDataInfo, boolean z) {
        this.gOa = voteDataInfo;
        if (this.gOa != null) {
            if (this.gOa.getStatus() == 2 || this.gOa.getIsPolled() == 0) {
                for (com.baidu.tbadk.widget.vote.a aVar : this.gOa.getOptions()) {
                    if (aVar != null && (aVar instanceof b)) {
                        ((b) aVar).setSelected(false);
                    }
                }
            }
            bar();
            if (this.gOa.getVoteType() == 1) {
                if (this.gOa.getStatus() == 2 || this.gOa.getIsPolled() == 1) {
                    nn(z);
                } else {
                    bBx();
                }
            } else if (this.gOa.getVoteType() == 2) {
                if (this.gOa.getStatus() == 2 || this.gOa.getIsPolled() == 1) {
                    G(2, z);
                } else {
                    G(this.gOa.getIsMulti() == 1 ? 1 : 3, z);
                }
            }
        }
    }

    private void G(int i, boolean z) {
        if (this.gNT != null && this.gOa != null) {
            this.gNU = (VotePhotoGroupView) this.gNT.findViewById(d.g.picvote_view);
            this.gNU.setOnVoteCheckedChangedListener(this.aTt);
            this.gNU.setVisibility(0);
            this.gNU.setMode(i);
            this.gNU.a(this.gOa.getOptions(), z, this.gOa.getIsPolled() == 1);
        }
    }

    private void bar() {
        if (this.gNT != null && this.gOa != null) {
            ((TextView) this.gNT.findViewById(d.g.tv_vote_endtime)).setText(this.gOa.getTips());
            ((TextView) this.gNT.findViewById(d.g.vote_num)).setText(getPageContext().getPageActivity().getString(d.j.pb_vote_num, new Object[]{Long.valueOf(this.gOa.getTotalNum())}));
            bBz();
        }
    }

    private void bBx() {
        if (this.gNT != null && this.gOa != null) {
            this.gNV = (VoteTextGroupView) this.gNT.findViewById(d.g.textvote_view);
            this.gNV.setOnVoteCheckedChangedListener(this.aTt);
            this.gNV.setVisibility(0);
            this.gNV.setMode(this.gOa.getIsMulti() == 1 ? 1 : 2);
            this.gNV.I(this.gOa.getOptions());
            this.gNV.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void nn(boolean z) {
        if (this.gNT != null && this.gOa != null) {
            this.gNU = (VotePhotoGroupView) this.gNT.findViewById(d.g.picvote_view);
            this.gNV = (VoteTextGroupView) this.gNT.findViewById(d.g.textvote_view);
            this.gNW = (VoteView) this.gNT.findViewById(d.g.result_vote_view);
            this.gNV.setVisibility(8);
            this.gNU.setVisibility(8);
            this.gNW.setVisibility(0);
            this.gNW.setWidth(this.maxWidth);
            this.gNW.b(this.gOa.getOptions(), z);
            this.gNW.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBy() {
        if (this.gOa != null) {
            if (this.gOd != null && this.eMB != null) {
                this.gOd.c(this.eMB.getActivity().getString(d.j.vote_succ));
            }
            this.gOa.setIsPolled(1);
            this.gOa.setTotalNum(this.gOa.getTotalNum() + 1);
            this.gOa.setTotalPoll(this.gOa.getTotalPoll() + this.gOb.size());
            for (b bVar : this.gOb) {
                if (bVar != null) {
                    bVar.setNum(bVar.getNum() + 1);
                }
            }
            if (this.gOa.getTotalPoll() > 0) {
                for (com.baidu.tbadk.widget.vote.a aVar : this.gOa.getOptions()) {
                    if (aVar instanceof b) {
                        b bVar2 = (b) aVar;
                        bVar2.setPercent((int) ((bVar2.getNum() * 100) / this.gOa.getTotalPoll()));
                    }
                }
            }
            a(this.gOa, true);
            this.gOb.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkMessageIsBelongToCurPage(ResponsedMessage<?> responsedMessage) {
        return (responsedMessage == null || this.mContext == null || responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() != this.mContext.getUniqueId()) ? false : true;
    }

    public void onChangeSkinType() {
        if (this.gNT != null) {
            com.baidu.tbadk.o.a.a(this.eMB.getPageContext(), this.gNT);
        }
        bBz();
    }

    private void bBz() {
        if (this.gNZ != null && this.gOa != null) {
            if (this.gOa.getStatus() == 2) {
                aj.j(this.gNZ, d.f.bg_gray_circle);
                this.gNZ.setText(getPageContext().getString(d.j.pb_vote_over));
                this.gNZ.setEnabled(false);
            } else if (this.gOa.getIsPolled() == 1) {
                aj.j(this.gNZ, d.f.bg_gray_circle);
                this.gNZ.setText(getPageContext().getString(d.j.pb_voted));
                this.gNZ.setEnabled(false);
            } else if (this.gOa.getIsPolled() == 0) {
                aj.j(this.gNZ, d.f.btn_pb_vote_selector);
                this.gNZ.setText(getPageContext().getString(d.j.vote));
                this.gNZ.setEnabled(true);
                this.gNZ.setOnClickListener(this.mOnClickListener);
            }
            aj.c(this.gNZ, d.C0080d.cp_cont_i, 1);
        }
    }
}
