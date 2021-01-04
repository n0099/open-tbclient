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
    private f lJI;
    private boolean lJJ;
    private boolean lJK;
    private int lJQ;
    private boolean lLR;
    private final boolean lLS;
    private View.OnLongClickListener mOnLongClickListener;
    private boolean mkU;
    private int mkV;
    private int mkW;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
        boolean z = true;
        this.lJQ = 0;
        this.lJJ = true;
        this.mkU = true;
        this.lJI = null;
        this.lJK = true;
        this.bdp = null;
        this.fWO = null;
        this.fyb = null;
        this.mOnLongClickListener = null;
        this.lLR = false;
        this.lLS = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        a(pbFragment);
    }

    @Override // com.baidu.tieba.pb.pb.main.l
    public void a(b bVar) {
        super.a(bVar);
        if (bVar != null) {
            this.mkV = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds30);
            this.mkW = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds60);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cL */
    public PbInterviewLiveNormalItemViewHolder e(ViewGroup viewGroup) {
        return new PbInterviewLiveNormalItemViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.pb_interview_normal_item, viewGroup, false), this.mkU, this.lJJ, this.lJQ, false);
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
            a(pbInterviewLiveNormalItemViewHolder.lMb, (int) this.mContext.getResources().getDimension(R.dimen.ds30));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbInterviewLiveNormalItemViewHolder.lMb.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            pbInterviewLiveNormalItemViewHolder.lMb.setLayoutParams(layoutParams);
            pbInterviewLiveNormalItemViewHolder.lMb.setPadding(0, 0, 0, 0);
            pbInterviewLiveNormalItemViewHolder.lMb.EW(null);
            postData.bsE();
            if (postData.dPd() == 1) {
                pbInterviewLiveNormalItemViewHolder.mla.setVisibility(0);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.brq() != null) {
                    j = postData.brq().getUserIdLong();
                    str = postData.brq().getUserName();
                    str2 = postData.brq().getName_show();
                }
                pbInterviewLiveNormalItemViewHolder.mla.a(postData.dPl(), str, str2, j, com.baidu.adp.lib.f.b.toLong(this.lJI.dmE().getId(), 0L), com.baidu.adp.lib.f.b.toLong(postData.getId(), 0L));
                pbInterviewLiveNormalItemViewHolder.mla.onChangeSkinType();
                if (this.lJK) {
                    PraiseData brb = this.lJI.dmE().brb();
                    if (brb != null && brb.getUser() != null && brb.getUser().size() > 0) {
                        pbInterviewLiveNormalItemViewHolder.mlb.setVisibility(0);
                        pbInterviewLiveNormalItemViewHolder.mkZ.setVisibility(0);
                        pbInterviewLiveNormalItemViewHolder.mlc.setVisibility(0);
                        pbInterviewLiveNormalItemViewHolder.mlb.setIsFromPb(true);
                        pbInterviewLiveNormalItemViewHolder.mlb.setData(brb, this.lJI.dmE().getId(), brb.getPostId(), true);
                        pbInterviewLiveNormalItemViewHolder.mlb.onChangeSkin(this.mSkinType);
                    } else {
                        pbInterviewLiveNormalItemViewHolder.mlb.setVisibility(8);
                        pbInterviewLiveNormalItemViewHolder.mkZ.setVisibility(8);
                        pbInterviewLiveNormalItemViewHolder.mlc.setVisibility(8);
                    }
                } else {
                    pbInterviewLiveNormalItemViewHolder.mlb.setVisibility(8);
                    pbInterviewLiveNormalItemViewHolder.mkZ.setVisibility(8);
                    pbInterviewLiveNormalItemViewHolder.mlc.setVisibility(8);
                }
                pbInterviewLiveNormalItemViewHolder.mlb.setVisibility(0);
                pbInterviewLiveNormalItemViewHolder.mkZ.setVisibility(0);
                pbInterviewLiveNormalItemViewHolder.mlc.setVisibility(0);
                a(pbInterviewLiveNormalItemViewHolder.lMb, (int) this.mContext.getResources().getDimension(R.dimen.ds30));
            } else {
                pbInterviewLiveNormalItemViewHolder.mla.setVisibility(8);
            }
            pbInterviewLiveNormalItemViewHolder.lMb.getLayoutStrategy().ty(R.drawable.pic_video);
            pbInterviewLiveNormalItemViewHolder.lMb.setTextColor(ao.getColor(R.color.common_color_10039));
            pbInterviewLiveNormalItemViewHolder.lMb.setLinkTextColor(ao.getColor(R.color.CAM_X0304));
            pbInterviewLiveNormalItemViewHolder.lMb.setLinkTextColor(ao.getColor(R.color.CAM_X0304));
            if (this.lJJ) {
                pbInterviewLiveNormalItemViewHolder.lMb.getLayoutStrategy().tB(R.drawable.transparent_bg);
            } else {
                pbInterviewLiveNormalItemViewHolder.lMb.getLayoutStrategy().tB(R.drawable.icon_click);
            }
            pbInterviewLiveNormalItemViewHolder.lMb.setIsFromCDN(this.mIsFromCDN);
            TbRichText tbRichText = null;
            if (0 == 0) {
                tbRichText = postData.dPf();
            }
            if (this.lLR || !this.lLS) {
                pbInterviewLiveNormalItemViewHolder.lMb.setText(tbRichText, false);
            } else {
                pbInterviewLiveNormalItemViewHolder.lMb.setText(tbRichText, true);
            }
            bx bqW = this.lJI.dmE().bqW();
            if (bqW != null) {
                pbInterviewLiveNormalItemViewHolder.mkY.startLoad(this.lJI.dmE().bqW().getThreadImgUrl(), this.mIsFromCDN ? 17 : 18, false);
                int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext);
                float bqL = bqW.bqL() / bqW.bqK();
                if (bqL > 1.0f) {
                    i = (int) (1.0f * equipmentWidth);
                } else if (bqL < 0.2f) {
                    i = (int) (equipmentWidth * 0.2f);
                } else {
                    i = (int) (equipmentWidth * bqL);
                }
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pbInterviewLiveNormalItemViewHolder.mkY.getLayoutParams();
                layoutParams2.height = i;
                layoutParams2.width = equipmentWidth;
                pbInterviewLiveNormalItemViewHolder.mkY.setLayoutParams(layoutParams2);
            } else {
                pbInterviewLiveNormalItemViewHolder.mkY.setVisibility(8);
            }
            b(pbInterviewLiveNormalItemViewHolder, postData);
        }
    }

    private void b(PbInterviewLiveNormalItemViewHolder pbInterviewLiveNormalItemViewHolder, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.lJJ) {
            pbInterviewLiveNormalItemViewHolder.lMb.setOnClickListener(null);
        } else {
            pbInterviewLiveNormalItemViewHolder.lMb.setOnClickListener(this.bdp);
        }
        pbInterviewLiveNormalItemViewHolder.lMb.setTextViewCheckSelection(false);
        pbInterviewLiveNormalItemViewHolder.lMb.setTextViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.adapter.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.getLayoutStrategy().tz(this.mkW - (i - this.mkV));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private void a(PbInterviewLiveNormalItemViewHolder pbInterviewLiveNormalItemViewHolder) {
        pbInterviewLiveNormalItemViewHolder.lMb.setOnLongClickListener(this.mOnLongClickListener);
        pbInterviewLiveNormalItemViewHolder.lMb.setOnTouchListener(this.fyb);
        pbInterviewLiveNormalItemViewHolder.lMb.setOnImageClickListener(this.fWO);
        if (this.lLF != null && this.lLF.dpD() != null) {
            pbInterviewLiveNormalItemViewHolder.lMb.setOnEmotionClickListener(this.lLF.dpD().lJa.lZA);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.pb.pb.adapter.a
    public void setData(f fVar) {
        this.lJI = fVar;
    }

    @Override // com.baidu.tieba.pb.pb.adapter.a
    public void hJ(String str) {
    }

    @Override // com.baidu.tieba.pb.pb.adapter.a
    public void setImageMaxWidth(int i) {
        this.lJQ = i;
    }

    @Override // com.baidu.tieba.pb.pb.adapter.a
    public void uz(boolean z) {
        this.lJJ = z;
    }

    @Override // com.baidu.tieba.pb.pb.adapter.a
    public void uA(boolean z) {
        this.lJK = z;
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
