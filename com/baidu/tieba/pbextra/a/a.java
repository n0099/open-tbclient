package com.baidu.tieba.pbextra.a;

import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.a.c;
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.o;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes16.dex */
public class a extends o<PostData, b> implements View.OnClickListener, com.baidu.tieba.pb.pb.a.a {
    private View.OnClickListener aRU;
    private c eFf;
    private TbRichTextView.i fcy;
    private f kAg;
    private boolean kAh;
    private boolean kAi;
    private int kAo;
    private boolean kCi;
    private final boolean kCj;
    private boolean laB;
    private int laC;
    private int laD;
    private View.OnLongClickListener mOnLongClickListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
        boolean z = true;
        this.kAo = 0;
        this.kAh = true;
        this.laB = true;
        this.kAg = null;
        this.kAi = true;
        this.aRU = null;
        this.fcy = null;
        this.eFf = null;
        this.mOnLongClickListener = null;
        this.kCi = false;
        this.kCj = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        a(pbFragment);
    }

    @Override // com.baidu.tieba.pb.pb.main.o
    public void a(com.baidu.tieba.pb.videopb.b bVar) {
        super.a(bVar);
        if (bVar != null) {
            this.laC = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds30);
            this.laD = l.getEquipmentWidth(this.mContext) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds60);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cu */
    public b b(ViewGroup viewGroup) {
        return new b(LayoutInflater.from(this.mContext).inflate(R.layout.pb_interview_normal_item, viewGroup, false), this.laB, this.kAh, this.kAo, false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.o, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, PostData postData, b bVar) {
        super.a(i, view, viewGroup, (ViewGroup) postData, (PostData) bVar);
        ap.setBackgroundColor(view, R.color.cp_bg_line_d);
        a(bVar);
        a(bVar, postData);
        return view;
    }

    private void a(b bVar, PostData postData) {
        int i;
        if (bVar != null && postData != null) {
            a(bVar.kCs, (int) this.mContext.getResources().getDimension(R.dimen.ds30));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.kCs.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            bVar.kCs.setLayoutParams(layoutParams);
            bVar.kCs.setPadding(0, 0, 0, 0);
            bVar.kCs.CU(null);
            postData.bfQ();
            if (postData.dwF() == 1) {
                bVar.laH.setVisibility(0);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.beE() != null) {
                    j = postData.beE().getUserIdLong();
                    str = postData.beE().getUserName();
                    str2 = postData.beE().getName_show();
                }
                bVar.laH.a(postData.dwN(), str, str2, j, com.baidu.adp.lib.f.b.toLong(this.kAg.cVl().getId(), 0L), com.baidu.adp.lib.f.b.toLong(postData.getId(), 0L));
                bVar.laH.onChangeSkinType();
                if (this.kAi) {
                    PraiseData bep = this.kAg.cVl().bep();
                    if (bep != null && bep.getUser() != null && bep.getUser().size() > 0) {
                        bVar.laI.setVisibility(0);
                        bVar.laG.setVisibility(0);
                        bVar.laJ.setVisibility(0);
                        bVar.laI.setIsFromPb(true);
                        bVar.laI.setData(bep, this.kAg.cVl().getId(), bep.getPostId(), true);
                        bVar.laI.onChangeSkin(this.mSkinType);
                    } else {
                        bVar.laI.setVisibility(8);
                        bVar.laG.setVisibility(8);
                        bVar.laJ.setVisibility(8);
                    }
                } else {
                    bVar.laI.setVisibility(8);
                    bVar.laG.setVisibility(8);
                    bVar.laJ.setVisibility(8);
                }
                bVar.laI.setVisibility(0);
                bVar.laG.setVisibility(0);
                bVar.laJ.setVisibility(0);
                a(bVar.kCs, (int) this.mContext.getResources().getDimension(R.dimen.ds30));
            } else {
                bVar.laH.setVisibility(8);
            }
            bVar.kCs.getLayoutStrategy().rc(R.drawable.pic_video);
            bVar.kCs.setTextColor(ap.getColor(R.color.common_color_10039));
            bVar.kCs.setLinkTextColor(ap.getColor(R.color.cp_link_tip_c));
            bVar.kCs.setLinkTextColor(ap.getColor(R.color.cp_link_tip_c));
            if (this.kAh) {
                bVar.kCs.getLayoutStrategy().rf(R.drawable.transparent_bg);
            } else {
                bVar.kCs.getLayoutStrategy().rf(R.drawable.icon_click);
            }
            bVar.kCs.setIsFromCDN(this.mIsFromCDN);
            TbRichText tbRichText = null;
            if (0 == 0) {
                tbRichText = postData.dwH();
            }
            if (this.kCi || !this.kCj) {
                bVar.kCs.setText(tbRichText, false);
            } else {
                bVar.kCs.setText(tbRichText, true);
            }
            bu bek = this.kAg.cVl().bek();
            if (bek != null) {
                bVar.laF.startLoad(this.kAg.cVl().bek().getThreadImgUrl(), this.mIsFromCDN ? 17 : 18, false);
                int equipmentWidth = l.getEquipmentWidth(this.mContext);
                float bdZ = bek.bdZ() / bek.bdY();
                if (bdZ > 1.0f) {
                    i = (int) (1.0f * equipmentWidth);
                } else if (bdZ < 0.2f) {
                    i = (int) (equipmentWidth * 0.2f);
                } else {
                    i = (int) (equipmentWidth * bdZ);
                }
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.laF.getLayoutParams();
                layoutParams2.height = i;
                layoutParams2.width = equipmentWidth;
                bVar.laF.setLayoutParams(layoutParams2);
            } else {
                bVar.laF.setVisibility(8);
            }
            b(bVar, postData);
        }
    }

    private void b(b bVar, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.kAh) {
            bVar.kCs.setOnClickListener(null);
        } else {
            bVar.kCs.setOnClickListener(this.aRU);
        }
        bVar.kCs.setTextViewCheckSelection(false);
        bVar.kCs.setTextViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.getLayoutStrategy().rd(this.laD - (i - this.laC));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private void a(b bVar) {
        bVar.kCs.setOnLongClickListener(this.mOnLongClickListener);
        bVar.kCs.setOnTouchListener(this.eFf);
        bVar.kCs.setOnImageClickListener(this.fcy);
        if (this.kBW != null && this.kBW.cYi() != null) {
            bVar.kCs.setOnEmotionClickListener(this.kBW.cYi().kzF.kPG);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setData(f fVar) {
        this.kAg = fVar;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void gL(String str) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setImageMaxWidth(int i) {
        this.kAo = i;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void sD(boolean z) {
        this.kAh = z;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void sE(boolean z) {
        this.kAi = z;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void sF(boolean z) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void S(View.OnClickListener onClickListener) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.fcy = iVar;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void A(View.OnClickListener onClickListener) {
        this.aRU = onClickListener;
    }
}
