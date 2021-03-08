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
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.ap;
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
    private View.OnClickListener bdi;
    private TbRichTextView.i fVW;
    private c fxj;
    private f lQk;
    private boolean lQl;
    private boolean lQm;
    private int lQs;
    private boolean lSx;
    private final boolean lSy;
    private View.OnLongClickListener mOnLongClickListener;
    private boolean mrH;
    private int mrI;
    private int mrJ;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
        boolean z = true;
        this.lQs = 0;
        this.lQl = true;
        this.mrH = true;
        this.lQk = null;
        this.lQm = true;
        this.bdi = null;
        this.fVW = null;
        this.fxj = null;
        this.mOnLongClickListener = null;
        this.lSx = false;
        this.lSy = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        a(pbFragment);
    }

    @Override // com.baidu.tieba.pb.pb.main.l
    public void a(b bVar) {
        super.a(bVar);
        if (bVar != null) {
            this.mrI = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds30);
            this.mrJ = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds60);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cL */
    public PbInterviewLiveNormalItemViewHolder e(ViewGroup viewGroup) {
        return new PbInterviewLiveNormalItemViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.pb_interview_normal_item, viewGroup, false), this.mrH, this.lQl, this.lQs, false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.l, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, PostData postData, PbInterviewLiveNormalItemViewHolder pbInterviewLiveNormalItemViewHolder) {
        super.a(i, view, viewGroup, (ViewGroup) postData, (PostData) pbInterviewLiveNormalItemViewHolder);
        ap.setBackgroundColor(view, R.color.CAM_X0201);
        a(pbInterviewLiveNormalItemViewHolder);
        a(pbInterviewLiveNormalItemViewHolder, postData);
        return view;
    }

    private void a(PbInterviewLiveNormalItemViewHolder pbInterviewLiveNormalItemViewHolder, PostData postData) {
        int i;
        if (pbInterviewLiveNormalItemViewHolder != null && postData != null) {
            a(pbInterviewLiveNormalItemViewHolder.lSH, (int) this.mContext.getResources().getDimension(R.dimen.ds30));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbInterviewLiveNormalItemViewHolder.lSH.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            pbInterviewLiveNormalItemViewHolder.lSH.setLayoutParams(layoutParams);
            pbInterviewLiveNormalItemViewHolder.lSH.setPadding(0, 0, 0, 0);
            pbInterviewLiveNormalItemViewHolder.lSH.Em(null);
            postData.bpf();
            if (postData.dNO() == 1) {
                pbInterviewLiveNormalItemViewHolder.mrN.setVisibility(0);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.bnS() != null) {
                    j = postData.bnS().getUserIdLong();
                    str = postData.bnS().getUserName();
                    str2 = postData.bnS().getName_show();
                }
                pbInterviewLiveNormalItemViewHolder.mrN.a(postData.dNW(), str, str2, j, com.baidu.adp.lib.f.b.toLong(this.lQk.dlp().getId(), 0L), com.baidu.adp.lib.f.b.toLong(postData.getId(), 0L));
                pbInterviewLiveNormalItemViewHolder.mrN.onChangeSkinType();
                if (this.lQm) {
                    PraiseData bnD = this.lQk.dlp().bnD();
                    if (bnD != null && bnD.getUser() != null && bnD.getUser().size() > 0) {
                        pbInterviewLiveNormalItemViewHolder.mrO.setVisibility(0);
                        pbInterviewLiveNormalItemViewHolder.mrM.setVisibility(0);
                        pbInterviewLiveNormalItemViewHolder.mrP.setVisibility(0);
                        pbInterviewLiveNormalItemViewHolder.mrO.setIsFromPb(true);
                        pbInterviewLiveNormalItemViewHolder.mrO.setData(bnD, this.lQk.dlp().getId(), bnD.getPostId(), true);
                        pbInterviewLiveNormalItemViewHolder.mrO.onChangeSkin(this.mSkinType);
                    } else {
                        pbInterviewLiveNormalItemViewHolder.mrO.setVisibility(8);
                        pbInterviewLiveNormalItemViewHolder.mrM.setVisibility(8);
                        pbInterviewLiveNormalItemViewHolder.mrP.setVisibility(8);
                    }
                } else {
                    pbInterviewLiveNormalItemViewHolder.mrO.setVisibility(8);
                    pbInterviewLiveNormalItemViewHolder.mrM.setVisibility(8);
                    pbInterviewLiveNormalItemViewHolder.mrP.setVisibility(8);
                }
                pbInterviewLiveNormalItemViewHolder.mrO.setVisibility(0);
                pbInterviewLiveNormalItemViewHolder.mrM.setVisibility(0);
                pbInterviewLiveNormalItemViewHolder.mrP.setVisibility(0);
                a(pbInterviewLiveNormalItemViewHolder.lSH, (int) this.mContext.getResources().getDimension(R.dimen.ds30));
            } else {
                pbInterviewLiveNormalItemViewHolder.mrN.setVisibility(8);
            }
            pbInterviewLiveNormalItemViewHolder.lSH.getLayoutStrategy().rZ(R.drawable.pic_video);
            pbInterviewLiveNormalItemViewHolder.lSH.setTextColor(ap.getColor(R.color.common_color_10039));
            pbInterviewLiveNormalItemViewHolder.lSH.setLinkTextColor(ap.getColor(R.color.CAM_X0304));
            pbInterviewLiveNormalItemViewHolder.lSH.setLinkTextColor(ap.getColor(R.color.CAM_X0304));
            if (this.lQl) {
                pbInterviewLiveNormalItemViewHolder.lSH.getLayoutStrategy().sc(R.drawable.transparent_bg);
            } else {
                pbInterviewLiveNormalItemViewHolder.lSH.getLayoutStrategy().sc(R.drawable.icon_click);
            }
            pbInterviewLiveNormalItemViewHolder.lSH.setIsFromCDN(this.mIsFromCDN);
            TbRichText tbRichText = null;
            if (0 == 0) {
                tbRichText = postData.dNQ();
            }
            if (this.lSx || !this.lSy) {
                pbInterviewLiveNormalItemViewHolder.lSH.setText(tbRichText, false);
            } else {
                pbInterviewLiveNormalItemViewHolder.lSH.setText(tbRichText, true);
            }
            bz bny = this.lQk.dlp().bny();
            if (bny != null) {
                pbInterviewLiveNormalItemViewHolder.mrL.startLoad(this.lQk.dlp().bny().getThreadImgUrl(), this.mIsFromCDN ? 17 : 18, false);
                int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext);
                float bnn = bny.bnn() / bny.bnm();
                if (bnn > 1.0f) {
                    i = (int) (1.0f * equipmentWidth);
                } else if (bnn < 0.2f) {
                    i = (int) (equipmentWidth * 0.2f);
                } else {
                    i = (int) (equipmentWidth * bnn);
                }
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pbInterviewLiveNormalItemViewHolder.mrL.getLayoutParams();
                layoutParams2.height = i;
                layoutParams2.width = equipmentWidth;
                pbInterviewLiveNormalItemViewHolder.mrL.setLayoutParams(layoutParams2);
            } else {
                pbInterviewLiveNormalItemViewHolder.mrL.setVisibility(8);
            }
            b(pbInterviewLiveNormalItemViewHolder, postData);
        }
    }

    private void b(PbInterviewLiveNormalItemViewHolder pbInterviewLiveNormalItemViewHolder, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.lQl) {
            pbInterviewLiveNormalItemViewHolder.lSH.setOnClickListener(null);
        } else {
            pbInterviewLiveNormalItemViewHolder.lSH.setOnClickListener(this.bdi);
        }
        pbInterviewLiveNormalItemViewHolder.lSH.setTextViewCheckSelection(false);
        pbInterviewLiveNormalItemViewHolder.lSH.setTextViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.adapter.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.getLayoutStrategy().sa(this.mrJ - (i - this.mrI));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private void a(PbInterviewLiveNormalItemViewHolder pbInterviewLiveNormalItemViewHolder) {
        pbInterviewLiveNormalItemViewHolder.lSH.setOnLongClickListener(this.mOnLongClickListener);
        pbInterviewLiveNormalItemViewHolder.lSH.setOnTouchListener(this.fxj);
        pbInterviewLiveNormalItemViewHolder.lSH.setOnImageClickListener(this.fVW);
        if (this.lSl != null && this.lSl.doq() != null) {
            pbInterviewLiveNormalItemViewHolder.lSH.setOnEmotionClickListener(this.lSl.doq().lPA.mgr);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.pb.pb.adapter.a
    public void setData(f fVar) {
        this.lQk = fVar;
    }

    @Override // com.baidu.tieba.pb.pb.adapter.a
    public void hc(String str) {
    }

    @Override // com.baidu.tieba.pb.pb.adapter.a
    public void setImageMaxWidth(int i) {
        this.lQs = i;
    }

    @Override // com.baidu.tieba.pb.pb.adapter.a
    public void uJ(boolean z) {
        this.lQl = z;
    }

    @Override // com.baidu.tieba.pb.pb.adapter.a
    public void uK(boolean z) {
        this.lQm = z;
    }

    @Override // com.baidu.tieba.pb.pb.adapter.a
    public void uL(boolean z) {
    }

    @Override // com.baidu.tieba.pb.pb.adapter.a
    public void V(View.OnClickListener onClickListener) {
    }

    @Override // com.baidu.tieba.pb.pb.adapter.a
    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.fVW = iVar;
    }

    @Override // com.baidu.tieba.pb.pb.adapter.a
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    @Override // com.baidu.tieba.pb.pb.adapter.a
    public void C(View.OnClickListener onClickListener) {
        this.bdi = onClickListener;
    }
}
