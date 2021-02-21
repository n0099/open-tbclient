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
    private f lOi;
    private boolean lOj;
    private boolean lOk;
    private int lOq;
    private boolean lQv;
    private final boolean lQw;
    private View.OnLongClickListener mOnLongClickListener;
    private boolean mpF;
    private int mpG;
    private int mpH;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
        boolean z = true;
        this.lOq = 0;
        this.lOj = true;
        this.mpF = true;
        this.lOi = null;
        this.lOk = true;
        this.bbI = null;
        this.fUw = null;
        this.fvK = null;
        this.mOnLongClickListener = null;
        this.lQv = false;
        this.lQw = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        a(pbFragment);
    }

    @Override // com.baidu.tieba.pb.pb.main.l
    public void a(b bVar) {
        super.a(bVar);
        if (bVar != null) {
            this.mpG = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds30);
            this.mpH = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds60);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cM */
    public PbInterviewLiveNormalItemViewHolder e(ViewGroup viewGroup) {
        return new PbInterviewLiveNormalItemViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.pb_interview_normal_item, viewGroup, false), this.mpF, this.lOj, this.lOq, false);
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
            a(pbInterviewLiveNormalItemViewHolder.lQF, (int) this.mContext.getResources().getDimension(R.dimen.ds30));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbInterviewLiveNormalItemViewHolder.lQF.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            pbInterviewLiveNormalItemViewHolder.lQF.setLayoutParams(layoutParams);
            pbInterviewLiveNormalItemViewHolder.lQF.setPadding(0, 0, 0, 0);
            pbInterviewLiveNormalItemViewHolder.lQF.Ef(null);
            postData.bpd();
            if (postData.dNF() == 1) {
                pbInterviewLiveNormalItemViewHolder.mpL.setVisibility(0);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.bnQ() != null) {
                    j = postData.bnQ().getUserIdLong();
                    str = postData.bnQ().getUserName();
                    str2 = postData.bnQ().getName_show();
                }
                pbInterviewLiveNormalItemViewHolder.mpL.a(postData.dNN(), str, str2, j, com.baidu.adp.lib.f.b.toLong(this.lOi.dlg().getId(), 0L), com.baidu.adp.lib.f.b.toLong(postData.getId(), 0L));
                pbInterviewLiveNormalItemViewHolder.mpL.onChangeSkinType();
                if (this.lOk) {
                    PraiseData bnB = this.lOi.dlg().bnB();
                    if (bnB != null && bnB.getUser() != null && bnB.getUser().size() > 0) {
                        pbInterviewLiveNormalItemViewHolder.mpM.setVisibility(0);
                        pbInterviewLiveNormalItemViewHolder.mpK.setVisibility(0);
                        pbInterviewLiveNormalItemViewHolder.mpN.setVisibility(0);
                        pbInterviewLiveNormalItemViewHolder.mpM.setIsFromPb(true);
                        pbInterviewLiveNormalItemViewHolder.mpM.setData(bnB, this.lOi.dlg().getId(), bnB.getPostId(), true);
                        pbInterviewLiveNormalItemViewHolder.mpM.onChangeSkin(this.mSkinType);
                    } else {
                        pbInterviewLiveNormalItemViewHolder.mpM.setVisibility(8);
                        pbInterviewLiveNormalItemViewHolder.mpK.setVisibility(8);
                        pbInterviewLiveNormalItemViewHolder.mpN.setVisibility(8);
                    }
                } else {
                    pbInterviewLiveNormalItemViewHolder.mpM.setVisibility(8);
                    pbInterviewLiveNormalItemViewHolder.mpK.setVisibility(8);
                    pbInterviewLiveNormalItemViewHolder.mpN.setVisibility(8);
                }
                pbInterviewLiveNormalItemViewHolder.mpM.setVisibility(0);
                pbInterviewLiveNormalItemViewHolder.mpK.setVisibility(0);
                pbInterviewLiveNormalItemViewHolder.mpN.setVisibility(0);
                a(pbInterviewLiveNormalItemViewHolder.lQF, (int) this.mContext.getResources().getDimension(R.dimen.ds30));
            } else {
                pbInterviewLiveNormalItemViewHolder.mpL.setVisibility(8);
            }
            pbInterviewLiveNormalItemViewHolder.lQF.getLayoutStrategy().rX(R.drawable.pic_video);
            pbInterviewLiveNormalItemViewHolder.lQF.setTextColor(ap.getColor(R.color.common_color_10039));
            pbInterviewLiveNormalItemViewHolder.lQF.setLinkTextColor(ap.getColor(R.color.CAM_X0304));
            pbInterviewLiveNormalItemViewHolder.lQF.setLinkTextColor(ap.getColor(R.color.CAM_X0304));
            if (this.lOj) {
                pbInterviewLiveNormalItemViewHolder.lQF.getLayoutStrategy().sa(R.drawable.transparent_bg);
            } else {
                pbInterviewLiveNormalItemViewHolder.lQF.getLayoutStrategy().sa(R.drawable.icon_click);
            }
            pbInterviewLiveNormalItemViewHolder.lQF.setIsFromCDN(this.mIsFromCDN);
            TbRichText tbRichText = null;
            if (0 == 0) {
                tbRichText = postData.dNH();
            }
            if (this.lQv || !this.lQw) {
                pbInterviewLiveNormalItemViewHolder.lQF.setText(tbRichText, false);
            } else {
                pbInterviewLiveNormalItemViewHolder.lQF.setText(tbRichText, true);
            }
            bz bnw = this.lOi.dlg().bnw();
            if (bnw != null) {
                pbInterviewLiveNormalItemViewHolder.mpJ.startLoad(this.lOi.dlg().bnw().getThreadImgUrl(), this.mIsFromCDN ? 17 : 18, false);
                int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext);
                float bnl = bnw.bnl() / bnw.bnk();
                if (bnl > 1.0f) {
                    i = (int) (1.0f * equipmentWidth);
                } else if (bnl < 0.2f) {
                    i = (int) (equipmentWidth * 0.2f);
                } else {
                    i = (int) (equipmentWidth * bnl);
                }
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pbInterviewLiveNormalItemViewHolder.mpJ.getLayoutParams();
                layoutParams2.height = i;
                layoutParams2.width = equipmentWidth;
                pbInterviewLiveNormalItemViewHolder.mpJ.setLayoutParams(layoutParams2);
            } else {
                pbInterviewLiveNormalItemViewHolder.mpJ.setVisibility(8);
            }
            b(pbInterviewLiveNormalItemViewHolder, postData);
        }
    }

    private void b(PbInterviewLiveNormalItemViewHolder pbInterviewLiveNormalItemViewHolder, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.lOj) {
            pbInterviewLiveNormalItemViewHolder.lQF.setOnClickListener(null);
        } else {
            pbInterviewLiveNormalItemViewHolder.lQF.setOnClickListener(this.bbI);
        }
        pbInterviewLiveNormalItemViewHolder.lQF.setTextViewCheckSelection(false);
        pbInterviewLiveNormalItemViewHolder.lQF.setTextViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.adapter.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.getLayoutStrategy().rY(this.mpH - (i - this.mpG));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private void a(PbInterviewLiveNormalItemViewHolder pbInterviewLiveNormalItemViewHolder) {
        pbInterviewLiveNormalItemViewHolder.lQF.setOnLongClickListener(this.mOnLongClickListener);
        pbInterviewLiveNormalItemViewHolder.lQF.setOnTouchListener(this.fvK);
        pbInterviewLiveNormalItemViewHolder.lQF.setOnImageClickListener(this.fUw);
        if (this.lQj != null && this.lQj.doh() != null) {
            pbInterviewLiveNormalItemViewHolder.lQF.setOnEmotionClickListener(this.lQj.doh().lNy.mep);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.pb.pb.adapter.a
    public void setData(f fVar) {
        this.lOi = fVar;
    }

    @Override // com.baidu.tieba.pb.pb.adapter.a
    public void gW(String str) {
    }

    @Override // com.baidu.tieba.pb.pb.adapter.a
    public void setImageMaxWidth(int i) {
        this.lOq = i;
    }

    @Override // com.baidu.tieba.pb.pb.adapter.a
    public void uJ(boolean z) {
        this.lOj = z;
    }

    @Override // com.baidu.tieba.pb.pb.adapter.a
    public void uK(boolean z) {
        this.lOk = z;
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
