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
    private View.OnClickListener bdp;
    private TbRichTextView.i fWO;
    private c fyb;
    private f lJH;
    private boolean lJI;
    private boolean lJJ;
    private int lJP;
    private boolean lLQ;
    private final boolean lLR;
    private View.OnLongClickListener mOnLongClickListener;
    private boolean mkT;
    private int mkU;
    private int mkV;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
        boolean z = true;
        this.lJP = 0;
        this.lJI = true;
        this.mkT = true;
        this.lJH = null;
        this.lJJ = true;
        this.bdp = null;
        this.fWO = null;
        this.fyb = null;
        this.mOnLongClickListener = null;
        this.lLQ = false;
        this.lLR = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        a(pbFragment);
    }

    @Override // com.baidu.tieba.pb.pb.main.l
    public void a(b bVar) {
        super.a(bVar);
        if (bVar != null) {
            this.mkU = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds30);
            this.mkV = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds60);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cL */
    public PbInterviewLiveNormalItemViewHolder e(ViewGroup viewGroup) {
        return new PbInterviewLiveNormalItemViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.pb_interview_normal_item, viewGroup, false), this.mkT, this.lJI, this.lJP, false);
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
            a(pbInterviewLiveNormalItemViewHolder.lMa, (int) this.mContext.getResources().getDimension(R.dimen.ds30));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbInterviewLiveNormalItemViewHolder.lMa.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            pbInterviewLiveNormalItemViewHolder.lMa.setLayoutParams(layoutParams);
            pbInterviewLiveNormalItemViewHolder.lMa.setPadding(0, 0, 0, 0);
            pbInterviewLiveNormalItemViewHolder.lMa.EV(null);
            postData.bsF();
            if (postData.dPe() == 1) {
                pbInterviewLiveNormalItemViewHolder.mkZ.setVisibility(0);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.brr() != null) {
                    j = postData.brr().getUserIdLong();
                    str = postData.brr().getUserName();
                    str2 = postData.brr().getName_show();
                }
                pbInterviewLiveNormalItemViewHolder.mkZ.a(postData.dPm(), str, str2, j, com.baidu.adp.lib.f.b.toLong(this.lJH.dmF().getId(), 0L), com.baidu.adp.lib.f.b.toLong(postData.getId(), 0L));
                pbInterviewLiveNormalItemViewHolder.mkZ.onChangeSkinType();
                if (this.lJJ) {
                    PraiseData brc = this.lJH.dmF().brc();
                    if (brc != null && brc.getUser() != null && brc.getUser().size() > 0) {
                        pbInterviewLiveNormalItemViewHolder.mla.setVisibility(0);
                        pbInterviewLiveNormalItemViewHolder.mkY.setVisibility(0);
                        pbInterviewLiveNormalItemViewHolder.mlb.setVisibility(0);
                        pbInterviewLiveNormalItemViewHolder.mla.setIsFromPb(true);
                        pbInterviewLiveNormalItemViewHolder.mla.setData(brc, this.lJH.dmF().getId(), brc.getPostId(), true);
                        pbInterviewLiveNormalItemViewHolder.mla.onChangeSkin(this.mSkinType);
                    } else {
                        pbInterviewLiveNormalItemViewHolder.mla.setVisibility(8);
                        pbInterviewLiveNormalItemViewHolder.mkY.setVisibility(8);
                        pbInterviewLiveNormalItemViewHolder.mlb.setVisibility(8);
                    }
                } else {
                    pbInterviewLiveNormalItemViewHolder.mla.setVisibility(8);
                    pbInterviewLiveNormalItemViewHolder.mkY.setVisibility(8);
                    pbInterviewLiveNormalItemViewHolder.mlb.setVisibility(8);
                }
                pbInterviewLiveNormalItemViewHolder.mla.setVisibility(0);
                pbInterviewLiveNormalItemViewHolder.mkY.setVisibility(0);
                pbInterviewLiveNormalItemViewHolder.mlb.setVisibility(0);
                a(pbInterviewLiveNormalItemViewHolder.lMa, (int) this.mContext.getResources().getDimension(R.dimen.ds30));
            } else {
                pbInterviewLiveNormalItemViewHolder.mkZ.setVisibility(8);
            }
            pbInterviewLiveNormalItemViewHolder.lMa.getLayoutStrategy().ty(R.drawable.pic_video);
            pbInterviewLiveNormalItemViewHolder.lMa.setTextColor(ao.getColor(R.color.common_color_10039));
            pbInterviewLiveNormalItemViewHolder.lMa.setLinkTextColor(ao.getColor(R.color.CAM_X0304));
            pbInterviewLiveNormalItemViewHolder.lMa.setLinkTextColor(ao.getColor(R.color.CAM_X0304));
            if (this.lJI) {
                pbInterviewLiveNormalItemViewHolder.lMa.getLayoutStrategy().tB(R.drawable.transparent_bg);
            } else {
                pbInterviewLiveNormalItemViewHolder.lMa.getLayoutStrategy().tB(R.drawable.icon_click);
            }
            pbInterviewLiveNormalItemViewHolder.lMa.setIsFromCDN(this.mIsFromCDN);
            TbRichText tbRichText = null;
            if (0 == 0) {
                tbRichText = postData.dPg();
            }
            if (this.lLQ || !this.lLR) {
                pbInterviewLiveNormalItemViewHolder.lMa.setText(tbRichText, false);
            } else {
                pbInterviewLiveNormalItemViewHolder.lMa.setText(tbRichText, true);
            }
            bx bqX = this.lJH.dmF().bqX();
            if (bqX != null) {
                pbInterviewLiveNormalItemViewHolder.mkX.startLoad(this.lJH.dmF().bqX().getThreadImgUrl(), this.mIsFromCDN ? 17 : 18, false);
                int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext);
                float bqM = bqX.bqM() / bqX.bqL();
                if (bqM > 1.0f) {
                    i = (int) (1.0f * equipmentWidth);
                } else if (bqM < 0.2f) {
                    i = (int) (equipmentWidth * 0.2f);
                } else {
                    i = (int) (equipmentWidth * bqM);
                }
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pbInterviewLiveNormalItemViewHolder.mkX.getLayoutParams();
                layoutParams2.height = i;
                layoutParams2.width = equipmentWidth;
                pbInterviewLiveNormalItemViewHolder.mkX.setLayoutParams(layoutParams2);
            } else {
                pbInterviewLiveNormalItemViewHolder.mkX.setVisibility(8);
            }
            b(pbInterviewLiveNormalItemViewHolder, postData);
        }
    }

    private void b(PbInterviewLiveNormalItemViewHolder pbInterviewLiveNormalItemViewHolder, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.lJI) {
            pbInterviewLiveNormalItemViewHolder.lMa.setOnClickListener(null);
        } else {
            pbInterviewLiveNormalItemViewHolder.lMa.setOnClickListener(this.bdp);
        }
        pbInterviewLiveNormalItemViewHolder.lMa.setTextViewCheckSelection(false);
        pbInterviewLiveNormalItemViewHolder.lMa.setTextViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.adapter.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.getLayoutStrategy().tz(this.mkV - (i - this.mkU));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private void a(PbInterviewLiveNormalItemViewHolder pbInterviewLiveNormalItemViewHolder) {
        pbInterviewLiveNormalItemViewHolder.lMa.setOnLongClickListener(this.mOnLongClickListener);
        pbInterviewLiveNormalItemViewHolder.lMa.setOnTouchListener(this.fyb);
        pbInterviewLiveNormalItemViewHolder.lMa.setOnImageClickListener(this.fWO);
        if (this.lLE != null && this.lLE.dpE() != null) {
            pbInterviewLiveNormalItemViewHolder.lMa.setOnEmotionClickListener(this.lLE.dpE().lIZ.lZz);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.pb.pb.adapter.a
    public void setData(f fVar) {
        this.lJH = fVar;
    }

    @Override // com.baidu.tieba.pb.pb.adapter.a
    public void hJ(String str) {
    }

    @Override // com.baidu.tieba.pb.pb.adapter.a
    public void setImageMaxWidth(int i) {
        this.lJP = i;
    }

    @Override // com.baidu.tieba.pb.pb.adapter.a
    public void uz(boolean z) {
        this.lJI = z;
    }

    @Override // com.baidu.tieba.pb.pb.adapter.a
    public void uA(boolean z) {
        this.lJJ = z;
    }

    @Override // com.baidu.tieba.pb.pb.adapter.a
    public void uB(boolean z) {
    }

    @Override // com.baidu.tieba.pb.pb.adapter.a
    public void U(View.OnClickListener onClickListener) {
    }

    @Override // com.baidu.tieba.pb.pb.adapter.a
    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.fWO = iVar;
    }

    @Override // com.baidu.tieba.pb.pb.adapter.a
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    @Override // com.baidu.tieba.pb.pb.adapter.a
    public void C(View.OnClickListener onClickListener) {
        this.bdp = onClickListener;
    }
}
