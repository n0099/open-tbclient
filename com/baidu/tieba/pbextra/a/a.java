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
/* loaded from: classes22.dex */
public class a extends o<PostData, b> implements View.OnClickListener, com.baidu.tieba.pb.pb.a.a {
    private View.OnClickListener aXk;
    private c eTx;
    private TbRichTextView.i frJ;
    private f kXV;
    private boolean kXW;
    private boolean kXX;
    private int kYd;
    private boolean kZY;
    private final boolean kZZ;
    private boolean lyR;
    private int lyS;
    private int lyT;
    private View.OnLongClickListener mOnLongClickListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
        boolean z = true;
        this.kYd = 0;
        this.kXW = true;
        this.lyR = true;
        this.kXV = null;
        this.kXX = true;
        this.aXk = null;
        this.frJ = null;
        this.eTx = null;
        this.mOnLongClickListener = null;
        this.kZY = false;
        this.kZZ = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        a(pbFragment);
    }

    @Override // com.baidu.tieba.pb.pb.main.o
    public void a(com.baidu.tieba.pb.videopb.b bVar) {
        super.a(bVar);
        if (bVar != null) {
            this.lyS = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds30);
            this.lyT = l.getEquipmentWidth(this.mContext) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds60);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cx */
    public b c(ViewGroup viewGroup) {
        return new b(LayoutInflater.from(this.mContext).inflate(R.layout.pb_interview_normal_item, viewGroup, false), this.lyR, this.kXW, this.kYd, false);
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
            a(bVar.lai, (int) this.mContext.getResources().getDimension(R.dimen.ds30));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.lai.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            bVar.lai.setLayoutParams(layoutParams);
            bVar.lai.setPadding(0, 0, 0, 0);
            bVar.lai.Ed(null);
            postData.bjt();
            if (postData.dEp() == 1) {
                bVar.lyX.setVisibility(0);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.bih() != null) {
                    j = postData.bih().getUserIdLong();
                    str = postData.bih().getUserName();
                    str2 = postData.bih().getName_show();
                }
                bVar.lyX.a(postData.dEx(), str, str2, j, com.baidu.adp.lib.f.b.toLong(this.kXV.dcA().getId(), 0L), com.baidu.adp.lib.f.b.toLong(postData.getId(), 0L));
                bVar.lyX.onChangeSkinType();
                if (this.kXX) {
                    PraiseData bhS = this.kXV.dcA().bhS();
                    if (bhS != null && bhS.getUser() != null && bhS.getUser().size() > 0) {
                        bVar.lyY.setVisibility(0);
                        bVar.lyW.setVisibility(0);
                        bVar.lyZ.setVisibility(0);
                        bVar.lyY.setIsFromPb(true);
                        bVar.lyY.setData(bhS, this.kXV.dcA().getId(), bhS.getPostId(), true);
                        bVar.lyY.onChangeSkin(this.mSkinType);
                    } else {
                        bVar.lyY.setVisibility(8);
                        bVar.lyW.setVisibility(8);
                        bVar.lyZ.setVisibility(8);
                    }
                } else {
                    bVar.lyY.setVisibility(8);
                    bVar.lyW.setVisibility(8);
                    bVar.lyZ.setVisibility(8);
                }
                bVar.lyY.setVisibility(0);
                bVar.lyW.setVisibility(0);
                bVar.lyZ.setVisibility(0);
                a(bVar.lai, (int) this.mContext.getResources().getDimension(R.dimen.ds30));
            } else {
                bVar.lyX.setVisibility(8);
            }
            bVar.lai.getLayoutStrategy().rR(R.drawable.pic_video);
            bVar.lai.setTextColor(ap.getColor(R.color.common_color_10039));
            bVar.lai.setLinkTextColor(ap.getColor(R.color.cp_link_tip_c));
            bVar.lai.setLinkTextColor(ap.getColor(R.color.cp_link_tip_c));
            if (this.kXW) {
                bVar.lai.getLayoutStrategy().rU(R.drawable.transparent_bg);
            } else {
                bVar.lai.getLayoutStrategy().rU(R.drawable.icon_click);
            }
            bVar.lai.setIsFromCDN(this.mIsFromCDN);
            TbRichText tbRichText = null;
            if (0 == 0) {
                tbRichText = postData.dEr();
            }
            if (this.kZY || !this.kZZ) {
                bVar.lai.setText(tbRichText, false);
            } else {
                bVar.lai.setText(tbRichText, true);
            }
            bu bhN = this.kXV.dcA().bhN();
            if (bhN != null) {
                bVar.lyV.startLoad(this.kXV.dcA().bhN().getThreadImgUrl(), this.mIsFromCDN ? 17 : 18, false);
                int equipmentWidth = l.getEquipmentWidth(this.mContext);
                float bhC = bhN.bhC() / bhN.bhB();
                if (bhC > 1.0f) {
                    i = (int) (1.0f * equipmentWidth);
                } else if (bhC < 0.2f) {
                    i = (int) (equipmentWidth * 0.2f);
                } else {
                    i = (int) (equipmentWidth * bhC);
                }
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.lyV.getLayoutParams();
                layoutParams2.height = i;
                layoutParams2.width = equipmentWidth;
                bVar.lyV.setLayoutParams(layoutParams2);
            } else {
                bVar.lyV.setVisibility(8);
            }
            b(bVar, postData);
        }
    }

    private void b(b bVar, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.kXW) {
            bVar.lai.setOnClickListener(null);
        } else {
            bVar.lai.setOnClickListener(this.aXk);
        }
        bVar.lai.setTextViewCheckSelection(false);
        bVar.lai.setTextViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.getLayoutStrategy().rS(this.lyT - (i - this.lyS));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private void a(b bVar) {
        bVar.lai.setOnLongClickListener(this.mOnLongClickListener);
        bVar.lai.setOnTouchListener(this.eTx);
        bVar.lai.setOnImageClickListener(this.frJ);
        if (this.kZM != null && this.kZM.dfv() != null) {
            bVar.lai.setOnEmotionClickListener(this.kZM.dfv().kXu.lnD);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setData(f fVar) {
        this.kXV = fVar;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void hp(String str) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setImageMaxWidth(int i) {
        this.kYd = i;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void tt(boolean z) {
        this.kXW = z;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void tu(boolean z) {
        this.kXX = z;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void tv(boolean z) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void S(View.OnClickListener onClickListener) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.frJ = iVar;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void A(View.OnClickListener onClickListener) {
        this.aXk = onClickListener;
    }
}
