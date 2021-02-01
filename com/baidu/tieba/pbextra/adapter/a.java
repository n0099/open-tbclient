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
    private View.OnClickListener bbI;
    private TbRichTextView.i fUw;
    private c fvK;
    private f lNT;
    private boolean lNU;
    private boolean lNV;
    private int lOb;
    private boolean lQg;
    private final boolean lQh;
    private View.OnLongClickListener mOnLongClickListener;
    private boolean mpq;
    private int mpr;
    private int mps;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
        boolean z = true;
        this.lOb = 0;
        this.lNU = true;
        this.mpq = true;
        this.lNT = null;
        this.lNV = true;
        this.bbI = null;
        this.fUw = null;
        this.fvK = null;
        this.mOnLongClickListener = null;
        this.lQg = false;
        this.lQh = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        a(pbFragment);
    }

    @Override // com.baidu.tieba.pb.pb.main.l
    public void a(b bVar) {
        super.a(bVar);
        if (bVar != null) {
            this.mpr = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds30);
            this.mps = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds60);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cM */
    public PbInterviewLiveNormalItemViewHolder e(ViewGroup viewGroup) {
        return new PbInterviewLiveNormalItemViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.pb_interview_normal_item, viewGroup, false), this.mpq, this.lNU, this.lOb, false);
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
            a(pbInterviewLiveNormalItemViewHolder.lQq, (int) this.mContext.getResources().getDimension(R.dimen.ds30));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbInterviewLiveNormalItemViewHolder.lQq.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            pbInterviewLiveNormalItemViewHolder.lQq.setLayoutParams(layoutParams);
            pbInterviewLiveNormalItemViewHolder.lQq.setPadding(0, 0, 0, 0);
            pbInterviewLiveNormalItemViewHolder.lQq.Eh(null);
            postData.bpd();
            if (postData.dNx() == 1) {
                pbInterviewLiveNormalItemViewHolder.mpw.setVisibility(0);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.bnQ() != null) {
                    j = postData.bnQ().getUserIdLong();
                    str = postData.bnQ().getUserName();
                    str2 = postData.bnQ().getName_show();
                }
                pbInterviewLiveNormalItemViewHolder.mpw.a(postData.dNF(), str, str2, j, com.baidu.adp.lib.f.b.toLong(this.lNT.dkZ().getId(), 0L), com.baidu.adp.lib.f.b.toLong(postData.getId(), 0L));
                pbInterviewLiveNormalItemViewHolder.mpw.onChangeSkinType();
                if (this.lNV) {
                    PraiseData bnB = this.lNT.dkZ().bnB();
                    if (bnB != null && bnB.getUser() != null && bnB.getUser().size() > 0) {
                        pbInterviewLiveNormalItemViewHolder.mpx.setVisibility(0);
                        pbInterviewLiveNormalItemViewHolder.mpv.setVisibility(0);
                        pbInterviewLiveNormalItemViewHolder.mpy.setVisibility(0);
                        pbInterviewLiveNormalItemViewHolder.mpx.setIsFromPb(true);
                        pbInterviewLiveNormalItemViewHolder.mpx.setData(bnB, this.lNT.dkZ().getId(), bnB.getPostId(), true);
                        pbInterviewLiveNormalItemViewHolder.mpx.onChangeSkin(this.mSkinType);
                    } else {
                        pbInterviewLiveNormalItemViewHolder.mpx.setVisibility(8);
                        pbInterviewLiveNormalItemViewHolder.mpv.setVisibility(8);
                        pbInterviewLiveNormalItemViewHolder.mpy.setVisibility(8);
                    }
                } else {
                    pbInterviewLiveNormalItemViewHolder.mpx.setVisibility(8);
                    pbInterviewLiveNormalItemViewHolder.mpv.setVisibility(8);
                    pbInterviewLiveNormalItemViewHolder.mpy.setVisibility(8);
                }
                pbInterviewLiveNormalItemViewHolder.mpx.setVisibility(0);
                pbInterviewLiveNormalItemViewHolder.mpv.setVisibility(0);
                pbInterviewLiveNormalItemViewHolder.mpy.setVisibility(0);
                a(pbInterviewLiveNormalItemViewHolder.lQq, (int) this.mContext.getResources().getDimension(R.dimen.ds30));
            } else {
                pbInterviewLiveNormalItemViewHolder.mpw.setVisibility(8);
            }
            pbInterviewLiveNormalItemViewHolder.lQq.getLayoutStrategy().rX(R.drawable.pic_video);
            pbInterviewLiveNormalItemViewHolder.lQq.setTextColor(ap.getColor(R.color.common_color_10039));
            pbInterviewLiveNormalItemViewHolder.lQq.setLinkTextColor(ap.getColor(R.color.CAM_X0304));
            pbInterviewLiveNormalItemViewHolder.lQq.setLinkTextColor(ap.getColor(R.color.CAM_X0304));
            if (this.lNU) {
                pbInterviewLiveNormalItemViewHolder.lQq.getLayoutStrategy().sa(R.drawable.transparent_bg);
            } else {
                pbInterviewLiveNormalItemViewHolder.lQq.getLayoutStrategy().sa(R.drawable.icon_click);
            }
            pbInterviewLiveNormalItemViewHolder.lQq.setIsFromCDN(this.mIsFromCDN);
            TbRichText tbRichText = null;
            if (0 == 0) {
                tbRichText = postData.dNz();
            }
            if (this.lQg || !this.lQh) {
                pbInterviewLiveNormalItemViewHolder.lQq.setText(tbRichText, false);
            } else {
                pbInterviewLiveNormalItemViewHolder.lQq.setText(tbRichText, true);
            }
            bz bnw = this.lNT.dkZ().bnw();
            if (bnw != null) {
                pbInterviewLiveNormalItemViewHolder.mpu.startLoad(this.lNT.dkZ().bnw().getThreadImgUrl(), this.mIsFromCDN ? 17 : 18, false);
                int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext);
                float bnl = bnw.bnl() / bnw.bnk();
                if (bnl > 1.0f) {
                    i = (int) (1.0f * equipmentWidth);
                } else if (bnl < 0.2f) {
                    i = (int) (equipmentWidth * 0.2f);
                } else {
                    i = (int) (equipmentWidth * bnl);
                }
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pbInterviewLiveNormalItemViewHolder.mpu.getLayoutParams();
                layoutParams2.height = i;
                layoutParams2.width = equipmentWidth;
                pbInterviewLiveNormalItemViewHolder.mpu.setLayoutParams(layoutParams2);
            } else {
                pbInterviewLiveNormalItemViewHolder.mpu.setVisibility(8);
            }
            b(pbInterviewLiveNormalItemViewHolder, postData);
        }
    }

    private void b(PbInterviewLiveNormalItemViewHolder pbInterviewLiveNormalItemViewHolder, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.lNU) {
            pbInterviewLiveNormalItemViewHolder.lQq.setOnClickListener(null);
        } else {
            pbInterviewLiveNormalItemViewHolder.lQq.setOnClickListener(this.bbI);
        }
        pbInterviewLiveNormalItemViewHolder.lQq.setTextViewCheckSelection(false);
        pbInterviewLiveNormalItemViewHolder.lQq.setTextViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.adapter.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.getLayoutStrategy().rY(this.mps - (i - this.mpr));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private void a(PbInterviewLiveNormalItemViewHolder pbInterviewLiveNormalItemViewHolder) {
        pbInterviewLiveNormalItemViewHolder.lQq.setOnLongClickListener(this.mOnLongClickListener);
        pbInterviewLiveNormalItemViewHolder.lQq.setOnTouchListener(this.fvK);
        pbInterviewLiveNormalItemViewHolder.lQq.setOnImageClickListener(this.fUw);
        if (this.lPU != null && this.lPU.doa() != null) {
            pbInterviewLiveNormalItemViewHolder.lQq.setOnEmotionClickListener(this.lPU.doa().lNj.mdZ);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.pb.pb.adapter.a
    public void setData(f fVar) {
        this.lNT = fVar;
    }

    @Override // com.baidu.tieba.pb.pb.adapter.a
    public void gW(String str) {
    }

    @Override // com.baidu.tieba.pb.pb.adapter.a
    public void setImageMaxWidth(int i) {
        this.lOb = i;
    }

    @Override // com.baidu.tieba.pb.pb.adapter.a
    public void uJ(boolean z) {
        this.lNU = z;
    }

    @Override // com.baidu.tieba.pb.pb.adapter.a
    public void uK(boolean z) {
        this.lNV = z;
    }

    @Override // com.baidu.tieba.pb.pb.adapter.a
    public void uL(boolean z) {
    }

    @Override // com.baidu.tieba.pb.pb.adapter.a
    public void U(View.OnClickListener onClickListener) {
    }

    @Override // com.baidu.tieba.pb.pb.adapter.a
    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.fUw = iVar;
    }

    @Override // com.baidu.tieba.pb.pb.adapter.a
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    @Override // com.baidu.tieba.pb.pb.adapter.a
    public void C(View.OnClickListener onClickListener) {
        this.bbI = onClickListener;
    }
}
