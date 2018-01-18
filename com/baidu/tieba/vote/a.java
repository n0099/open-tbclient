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
    private com.baidu.tbadk.widget.vote.b bKx;
    private PbActivity fJw;
    private final com.baidu.adp.framework.listener.a hzA;
    private View hzp;
    private VotePhotoGroupView hzq;
    private VoteTextGroupView hzr;
    private VoteView hzs;
    private TextView hzt;
    private TextView hzu;
    private TextView hzv;
    private VoteDataInfo hzw;
    private final List<b> hzx;
    private boolean hzy;
    private e hzz;
    private long mForumId;
    private final View.OnClickListener mOnClickListener;
    private int mSkinType;
    private long mThreadId;
    private int maxWidth;

    public void setVisibility(int i) {
        if (this.hzp != null) {
            this.hzp.setVisibility(i);
        }
    }

    public void bDX() {
        if (this.hzq != null) {
            this.hzq.setPadding(0, 0, 0, 0);
        }
    }

    public a(PbActivity pbActivity) {
        super(pbActivity.getPageContext());
        this.mSkinType = 3;
        this.hzx = new ArrayList();
        this.hzy = false;
        this.maxWidth = 0;
        this.bKx = new com.baidu.tbadk.widget.vote.b() { // from class: com.baidu.tieba.vote.a.2
            @Override // com.baidu.tbadk.widget.vote.b
            public void a(com.baidu.tbadk.widget.vote.a aVar, int i, boolean z) {
                if (a.this.hzw != null && a.this.hzw.getOptions() != null && i >= 0 && i < a.this.hzw.getOptions().size()) {
                    ((b) a.this.hzw.getOptions().get(i)).setSelected(z);
                }
            }
        };
        this.hzA = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_ADD_VOTE, 309006) { // from class: com.baidu.tieba.vote.a.3
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                a.this.hzy = false;
                if (a.this.checkMessageIsBelongToCurPage(responsedMessage)) {
                    if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                        String errorString = responsedMessage.getErrorString();
                        String string = TbadkCoreApplication.getInst().getString(d.j.neterror);
                        if (!StringUtils.isNull(errorString)) {
                            string = errorString;
                        }
                        l.showToast(TbadkCoreApplication.getInst(), string);
                    } else if (responsedMessage instanceof AddVoteHttpProtoResponse) {
                        a.this.bDZ();
                    } else if (responsedMessage instanceof AddVoteSocketResponse) {
                        a.this.bDZ();
                    }
                }
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.vote.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == d.g.btn_pb_vote && a.this.fJw != null && a.this.fJw.checkUpIsLogin() && a.this.hzw != null && a.this.mForumId > 0 && a.this.mThreadId > 0 && !a.this.hzy) {
                    AddVoteModel addVoteModel = new AddVoteModel(a.this.fJw);
                    StringBuilder sb = new StringBuilder();
                    List<com.baidu.tbadk.widget.vote.a> options = a.this.hzw.getOptions();
                    if (options != null) {
                        for (com.baidu.tbadk.widget.vote.a aVar : options) {
                            if (aVar != null && aVar.isSelected()) {
                                sb.append(aVar.getId()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                                a.this.hzx.add((b) aVar);
                                if (a.this.hzw.getIsMulti() != 1) {
                                    break;
                                }
                            }
                        }
                        if (sb.toString().endsWith(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                            sb.deleteCharAt(sb.length() - 1);
                        }
                        if (TextUtils.isEmpty(sb.toString())) {
                            UtilHelper.showToast(a.this.fJw.getActivity(), d.j.vote_checked_less_one);
                            return;
                        }
                        addVoteModel.a(a.this.mForumId, a.this.mThreadId, sb.toString());
                        a.this.hzy = true;
                    }
                }
            }
        };
        this.fJw = pbActivity;
        pbActivity.registerListener(this.hzA);
        this.maxWidth = l.ao(TbadkCoreApplication.getInst()) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds120);
        this.hzz = new e();
    }

    public void a(View view, f fVar) {
        if (fVar != null && fVar.aYE() != null && fVar.aYG() != null && view != null) {
            this.mForumId = com.baidu.adp.lib.g.b.c(fVar.aYE().getId(), 0L);
            this.mThreadId = com.baidu.adp.lib.g.b.c(fVar.aYG().getId(), 0L);
            if (fVar.aYG().zE() && fVar.aYG().yE() != null) {
                if (this.hzp == null) {
                    this.hzp = ((ViewStub) view.findViewById(d.g.vote_card_layout)).inflate();
                    this.hzv = (TextView) this.hzp.findViewById(d.g.btn_pb_vote);
                    this.hzw = fVar.aYD();
                    b((PostData) v.f(fVar.aYI(), 0), this.hzp);
                    a(this.hzw, false);
                }
                if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                    onChangeSkinType();
                }
                this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
                if (!this.hzp.isShown()) {
                    this.hzp.setVisibility(0);
                }
            } else if (this.hzp != null && this.hzp.isShown()) {
                this.hzp.setVisibility(8);
            }
        }
    }

    private void b(PostData postData, View view) {
        this.hzt = (TextView) view.findViewById(d.g.pb_item_vote_reply_time);
        this.hzu = (TextView) view.findViewById(d.g.pb_item_vote_location_address);
        com.baidu.tbadk.data.f fVar = null;
        if (postData != null) {
            this.hzt.setText(postData.bvJ());
            fVar = postData.bvL();
        }
        if (fVar != null && !TextUtils.isEmpty(fVar.getName()) && !TextUtils.isEmpty(fVar.getName().trim())) {
            final String name = fVar.getName();
            final String lat = fVar.getLat();
            final String lng = fVar.getLng();
            this.hzu.setVisibility(0);
            this.hzu.setText(fVar.getName());
            this.hzu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.vote.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (TbadkCoreApplication.getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(lat) && !StringUtils.isNull(lng)) {
                        if (!j.oI()) {
                            a.this.fJw.showToast(d.j.neterror);
                        } else {
                            com.baidu.tbadk.browser.a.Q(a.this.fJw.getPageContext().getPageActivity(), String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", lat + Constants.ACCEPT_TIME_SEPARATOR_SP + lng, name, name, a.this.mContext.getString(d.j.app_info_for_map)));
                        }
                    }
                }
            });
            return;
        }
        this.hzu.setVisibility(8);
    }

    private void a(VoteDataInfo voteDataInfo, boolean z) {
        this.hzw = voteDataInfo;
        if (this.hzw != null) {
            if (this.hzw.getStatus() == 2 || this.hzw.getIsPolled() == 0) {
                for (com.baidu.tbadk.widget.vote.a aVar : this.hzw.getOptions()) {
                    if (aVar != null && (aVar instanceof b)) {
                        ((b) aVar).setSelected(false);
                    }
                }
            }
            bju();
            if (this.hzw.getVoteType() == 1) {
                if (this.hzw.getStatus() == 2 || this.hzw.getIsPolled() == 1) {
                    nn(z);
                } else {
                    bDY();
                }
            } else if (this.hzw.getVoteType() == 2) {
                if (this.hzw.getStatus() == 2 || this.hzw.getIsPolled() == 1) {
                    R(2, z);
                } else {
                    R(this.hzw.getIsMulti() == 1 ? 1 : 3, z);
                }
            }
        }
    }

    private void R(int i, boolean z) {
        if (this.hzp != null && this.hzw != null) {
            this.hzq = (VotePhotoGroupView) this.hzp.findViewById(d.g.picvote_view);
            this.hzq.setOnVoteCheckedChangedListener(this.bKx);
            this.hzq.setVisibility(0);
            this.hzq.setMode(i);
            this.hzq.a(this.hzw.getOptions(), z, this.hzw.getIsPolled() == 1);
        }
    }

    private void bju() {
        if (this.hzp != null && this.hzw != null) {
            ((TextView) this.hzp.findViewById(d.g.tv_vote_endtime)).setText(this.hzw.getTips());
            ((TextView) this.hzp.findViewById(d.g.vote_num)).setText(getPageContext().getPageActivity().getString(d.j.pb_vote_num, new Object[]{Long.valueOf(this.hzw.getTotalNum())}));
            bEa();
        }
    }

    private void bDY() {
        if (this.hzp != null && this.hzw != null) {
            this.hzr = (VoteTextGroupView) this.hzp.findViewById(d.g.textvote_view);
            this.hzr.setOnVoteCheckedChangedListener(this.bKx);
            this.hzr.setVisibility(0);
            this.hzr.setMode(this.hzw.getIsMulti() == 1 ? 1 : 2);
            this.hzr.Q(this.hzw.getOptions());
            this.hzr.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void nn(boolean z) {
        if (this.hzp != null && this.hzw != null) {
            this.hzq = (VotePhotoGroupView) this.hzp.findViewById(d.g.picvote_view);
            this.hzr = (VoteTextGroupView) this.hzp.findViewById(d.g.textvote_view);
            this.hzs = (VoteView) this.hzp.findViewById(d.g.result_vote_view);
            this.hzr.setVisibility(8);
            this.hzq.setVisibility(8);
            this.hzs.setVisibility(0);
            this.hzs.setWidth(this.maxWidth);
            this.hzs.b(this.hzw.getOptions(), z);
            this.hzs.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDZ() {
        if (this.hzw != null) {
            if (this.hzz != null && this.fJw != null) {
                this.hzz.q(this.fJw.getActivity().getString(d.j.vote_succ));
            }
            this.hzw.setIsPolled(1);
            this.hzw.setTotalNum(this.hzw.getTotalNum() + 1);
            this.hzw.setTotalPoll(this.hzw.getTotalPoll() + this.hzx.size());
            for (b bVar : this.hzx) {
                if (bVar != null) {
                    bVar.setNum(bVar.getNum() + 1);
                }
            }
            if (this.hzw.getTotalPoll() > 0) {
                for (com.baidu.tbadk.widget.vote.a aVar : this.hzw.getOptions()) {
                    if (aVar instanceof b) {
                        b bVar2 = (b) aVar;
                        bVar2.setPercent((int) ((bVar2.getNum() * 100) / this.hzw.getTotalPoll()));
                    }
                }
            }
            a(this.hzw, true);
            this.hzx.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkMessageIsBelongToCurPage(ResponsedMessage<?> responsedMessage) {
        return (responsedMessage == null || this.mContext == null || responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() != this.mContext.getUniqueId()) ? false : true;
    }

    public void onChangeSkinType() {
        if (this.hzp != null) {
            com.baidu.tbadk.n.a.a(this.fJw.getPageContext(), this.hzp);
        }
        bEa();
    }

    private void bEa() {
        if (this.hzv != null && this.hzw != null) {
            if (this.hzw.getStatus() == 2) {
                aj.s(this.hzv, d.f.bg_gray_circle);
                this.hzv.setText(getPageContext().getString(d.j.pb_vote_over));
                this.hzv.setEnabled(false);
            } else if (this.hzw.getIsPolled() == 1) {
                aj.s(this.hzv, d.f.bg_gray_circle);
                this.hzv.setText(getPageContext().getString(d.j.pb_voted));
                this.hzv.setEnabled(false);
            } else if (this.hzw.getIsPolled() == 0) {
                aj.s(this.hzv, d.f.btn_pb_vote_selector);
                this.hzv.setText(getPageContext().getString(d.j.vote));
                this.hzv.setEnabled(true);
                this.hzv.setOnClickListener(this.mOnClickListener);
            }
            aj.e(this.hzv, d.C0107d.cp_cont_i, 1);
        }
    }
}
