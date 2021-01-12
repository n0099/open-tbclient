package com.baidu.tieba.pbextra.adapter;

import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.a.c;
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.l;
import com.baidu.tieba.pb.videopb.b;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes2.dex */
public class a extends l<PostData, PbInterviewLiveNormalItemViewHolder> implements View.OnClickListener, com.baidu.tieba.pb.pb.adapter.a {
    private View.OnClickListener aYB;
    private TbRichTextView.i fSh;
    private c ftt;
    private f lFd;
    private boolean lFe;
    private boolean lFf;
    private int lFl;
    private boolean lHm;
    private final boolean lHn;
    private View.OnLongClickListener mOnLongClickListener;
    private boolean mgn;
    private int mgo;
    private int mgp;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
        boolean z = true;
        this.lFl = 0;
        this.lFe = true;
        this.mgn = true;
        this.lFd = null;
        this.lFf = true;
        this.aYB = null;
        this.fSh = null;
        this.ftt = null;
        this.mOnLongClickListener = null;
        this.lHm = false;
        this.lHn = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        a(pbFragment);
    }

    @Override // com.baidu.tieba.pb.pb.main.l
    public void a(b bVar) {
        super.a(bVar);
        if (bVar != null) {
            this.mgo = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds30);
            this.mgp = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds60);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cL */
    public PbInterviewLiveNormalItemViewHolder e(ViewGroup viewGroup) {
        return new PbInterviewLiveNormalItemViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.pb_interview_normal_item, viewGroup, false), this.mgn, this.lFe, this.lFl, false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.l, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, PostData postData, PbInterviewLiveNormalItemViewHolder pbInterviewLiveNormalItemViewHolder) {
        super.a(i, view, viewGroup, (ViewGroup) postData, (PostData) pbInterviewLiveNormalItemViewHolder);
        ao.setBackgroundColor(view, R.color.CAM_X0201);
        a(pbInterviewLiveNormalItemViewHolder);
        a(pbInterviewLiveNormalItemViewHolder, postData);
        return view;
    }

    private void a(PbInterviewLiveNormalItemViewHolder pbInterviewLiveNormalItemViewHolder, PostData postData) {
        int i;
        if (pbInterviewLiveNormalItemViewHolder != null && postData != null) {
            a(pbInterviewLiveNormalItemViewHolder.lHw, (int) this.mContext.getResources().getDimension(R.dimen.ds30));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbInterviewLiveNormalItemViewHolder.lHw.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            pbInterviewLiveNormalItemViewHolder.lHw.setLayoutParams(layoutParams);
            pbInterviewLiveNormalItemViewHolder.lHw.setPadding(0, 0, 0, 0);
            pbInterviewLiveNormalItemViewHolder.lHw.DK(null);
            postData.boL();
            if (postData.dLm() == 1) {
                pbInterviewLiveNormalItemViewHolder.mgt.setVisibility(0);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.bnx() != null) {
                    j = postData.bnx().getUserIdLong();
                    str = postData.bnx().getUserName();
                    str2 = postData.bnx().getName_show();
                }
                pbInterviewLiveNormalItemViewHolder.mgt.a(postData.dLu(), str, str2, j, com.baidu.adp.lib.f.b.toLong(this.lFd.diN().getId(), 0L), com.baidu.adp.lib.f.b.toLong(postData.getId(), 0L));
                pbInterviewLiveNormalItemViewHolder.mgt.onChangeSkinType();
                if (this.lFf) {
                    PraiseData bni = this.lFd.diN().bni();
                    if (bni != null && bni.getUser() != null && bni.getUser().size() > 0) {
                        pbInterviewLiveNormalItemViewHolder.mgu.setVisibility(0);
                        pbInterviewLiveNormalItemViewHolder.mgs.setVisibility(0);
                        pbInterviewLiveNormalItemViewHolder.mgv.setVisibility(0);
                        pbInterviewLiveNormalItemViewHolder.mgu.setIsFromPb(true);
                        pbInterviewLiveNormalItemViewHolder.mgu.setData(bni, this.lFd.diN().getId(), bni.getPostId(), true);
                        pbInterviewLiveNormalItemViewHolder.mgu.onChangeSkin(this.mSkinType);
                    } else {
                        pbInterviewLiveNormalItemViewHolder.mgu.setVisibility(8);
                        pbInterviewLiveNormalItemViewHolder.mgs.setVisibility(8);
                        pbInterviewLiveNormalItemViewHolder.mgv.setVisibility(8);
                    }
                } else {
                    pbInterviewLiveNormalItemViewHolder.mgu.setVisibility(8);
                    pbInterviewLiveNormalItemViewHolder.mgs.setVisibility(8);
                    pbInterviewLiveNormalItemViewHolder.mgv.setVisibility(8);
                }
                pbInterviewLiveNormalItemViewHolder.mgu.setVisibility(0);
                pbInterviewLiveNormalItemViewHolder.mgs.setVisibility(0);
                pbInterviewLiveNormalItemViewHolder.mgv.setVisibility(0);
                a(pbInterviewLiveNormalItemViewHolder.lHw, (int) this.mContext.getResources().getDimension(R.dimen.ds30));
            } else {
                pbInterviewLiveNormalItemViewHolder.mgt.setVisibility(8);
            }
            pbInterviewLiveNormalItemViewHolder.lHw.getLayoutStrategy().rS(R.drawable.pic_video);
            pbInterviewLiveNormalItemViewHolder.lHw.setTextColor(ao.getColor(R.color.common_color_10039));
            pbInterviewLiveNormalItemViewHolder.lHw.setLinkTextColor(ao.getColor(R.color.CAM_X0304));
            pbInterviewLiveNormalItemViewHolder.lHw.setLinkTextColor(ao.getColor(R.color.CAM_X0304));
            if (this.lFe) {
                pbInterviewLiveNormalItemViewHolder.lHw.getLayoutStrategy().rV(R.drawable.transparent_bg);
            } else {
                pbInterviewLiveNormalItemViewHolder.lHw.getLayoutStrategy().rV(R.drawable.icon_click);
            }
            pbInterviewLiveNormalItemViewHolder.lHw.setIsFromCDN(this.mIsFromCDN);
            TbRichText tbRichText = null;
            if (0 == 0) {
                tbRichText = postData.dLo();
            }
            if (this.lHm || !this.lHn) {
                pbInterviewLiveNormalItemViewHolder.lHw.setText(tbRichText, false);
            } else {
                pbInterviewLiveNormalItemViewHolder.lHw.setText(tbRichText, true);
            }
            bx bnd = this.lFd.diN().bnd();
            if (bnd != null) {
                pbInterviewLiveNormalItemViewHolder.mgr.startLoad(this.lFd.diN().bnd().getThreadImgUrl(), this.mIsFromCDN ? 17 : 18, false);
                int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext);
                float bmS = bnd.bmS() / bnd.bmR();
                if (bmS > 1.0f) {
                    i = (int) (1.0f * equipmentWidth);
                } else if (bmS < 0.2f) {
                    i = (int) (equipmentWidth * 0.2f);
                } else {
                    i = (int) (equipmentWidth * bmS);
                }
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pbInterviewLiveNormalItemViewHolder.mgr.getLayoutParams();
                layoutParams2.height = i;
                layoutParams2.width = equipmentWidth;
                pbInterviewLiveNormalItemViewHolder.mgr.setLayoutParams(layoutParams2);
            } else {
                pbInterviewLiveNormalItemViewHolder.mgr.setVisibility(8);
            }
            b(pbInterviewLiveNormalItemViewHolder, postData);
        }
    }

    private void b(PbInterviewLiveNormalItemViewHolder pbInterviewLiveNormalItemViewHolder, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.lFe) {
            pbInterviewLiveNormalItemViewHolder.lHw.setOnClickListener(null);
        } else {
            pbInterviewLiveNormalItemViewHolder.lHw.setOnClickListener(this.aYB);
        }
        pbInterviewLiveNormalItemViewHolder.lHw.setTextViewCheckSelection(false);
        pbInterviewLiveNormalItemViewHolder.lHw.setTextViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.adapter.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.getLayoutStrategy().rT(this.mgp - (i - this.mgo));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private void a(PbInterviewLiveNormalItemViewHolder pbInterviewLiveNormalItemViewHolder) {
        pbInterviewLiveNormalItemViewHolder.lHw.setOnLongClickListener(this.mOnLongClickListener);
        pbInterviewLiveNormalItemViewHolder.lHw.setOnTouchListener(this.ftt);
        pbInterviewLiveNormalItemViewHolder.lHw.setOnImageClickListener(this.fSh);
        if (this.lHa != null && this.lHa.dlL() != null) {
            pbInterviewLiveNormalItemViewHolder.lHw.setOnEmotionClickListener(this.lHa.dlL().lEu.lUV);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.pb.pb.adapter.a
    public void setData(f fVar) {
        this.lFd = fVar;
    }

    @Override // com.baidu.tieba.pb.pb.adapter.a
    public void gy(String str) {
    }

    @Override // com.baidu.tieba.pb.pb.adapter.a
    public void setImageMaxWidth(int i) {
        this.lFl = i;
    }

    @Override // com.baidu.tieba.pb.pb.adapter.a
    public void uv(boolean z) {
        this.lFe = z;
    }

    @Override // com.baidu.tieba.pb.pb.adapter.a
    public void uw(boolean z) {
        this.lFf = z;
    }

    @Override // com.baidu.tieba.pb.pb.adapter.a
    public void ux(boolean z) {
    }

    @Override // com.baidu.tieba.pb.pb.adapter.a
    public void U(View.OnClickListener onClickListener) {
    }

    @Override // com.baidu.tieba.pb.pb.adapter.a
    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.fSh = iVar;
    }

    @Override // com.baidu.tieba.pb.pb.adapter.a
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    @Override // com.baidu.tieba.pb.pb.adapter.a
    public void C(View.OnClickListener onClickListener) {
        this.aYB = onClickListener;
    }
}
