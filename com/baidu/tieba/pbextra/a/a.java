package com.baidu.tieba.pbextra.a;

import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.a.c;
import com.baidu.tieba.pb.data.e;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.l;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes9.dex */
public class a extends l<PostData, b> implements View.OnClickListener, com.baidu.tieba.pb.pb.a.a {
    private View.OnClickListener akE;
    private TbRichTextView.i dNb;
    private c drk;
    private int iGD;
    private e iGv;
    private boolean iGw;
    private boolean iGx;
    private boolean iIf;
    private final boolean iIg;
    private boolean jeO;
    private int jeP;
    private int jeQ;
    private View.OnLongClickListener mOnLongClickListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
        boolean z = true;
        this.iGD = 0;
        this.iGw = true;
        this.jeO = true;
        this.iGv = null;
        this.iGx = true;
        this.akE = null;
        this.dNb = null;
        this.drk = null;
        this.mOnLongClickListener = null;
        this.iIf = false;
        this.iIg = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        a(pbFragment);
    }

    @Override // com.baidu.tieba.pb.pb.main.l
    public void a(com.baidu.tieba.pb.videopb.b bVar) {
        super.a(bVar);
        if (bVar != null) {
            this.jeP = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds30);
            this.jeQ = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds60);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bU */
    public b b(ViewGroup viewGroup) {
        return new b(LayoutInflater.from(this.mContext).inflate(R.layout.pb_interview_normal_item, viewGroup, false), this.jeO, this.iGw, this.iGD, false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.l, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, PostData postData, b bVar) {
        super.a(i, view, viewGroup, (ViewGroup) postData, (PostData) bVar);
        am.setBackgroundColor(view, R.color.cp_bg_line_d);
        a(bVar);
        a(bVar, postData);
        return view;
    }

    private void a(b bVar, PostData postData) {
        int i;
        if (bVar != null && postData != null) {
            a(bVar.iIp, (int) this.mContext.getResources().getDimension(R.dimen.ds30));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.iIp.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            bVar.iIp.setLayoutParams(layoutParams);
            bVar.iIp.setPadding(0, 0, 0, 0);
            bVar.iIp.wj(null);
            postData.aDA();
            if (postData.cLv() == 1) {
                bVar.jeU.setVisibility(0);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.aCr() != null) {
                    j = postData.aCr().getUserIdLong();
                    str = postData.aCr().getUserName();
                    str2 = postData.aCr().getName_show();
                }
                bVar.jeU.a(postData.cLD(), str, str2, j, com.baidu.adp.lib.f.b.toLong(this.iGv.ckP().getId(), 0L), com.baidu.adp.lib.f.b.toLong(postData.getId(), 0L));
                bVar.jeU.onChangeSkinType();
                if (this.iGx) {
                    PraiseData aCc = this.iGv.ckP().aCc();
                    if (aCc != null && aCc.getUser() != null && aCc.getUser().size() > 0) {
                        bVar.jeV.setVisibility(0);
                        bVar.jeT.setVisibility(0);
                        bVar.jeW.setVisibility(0);
                        bVar.jeV.setIsFromPb(true);
                        bVar.jeV.setData(aCc, this.iGv.ckP().getId(), aCc.getPostId(), true);
                        bVar.jeV.onChangeSkin(this.mSkinType);
                    } else {
                        bVar.jeV.setVisibility(8);
                        bVar.jeT.setVisibility(8);
                        bVar.jeW.setVisibility(8);
                    }
                } else {
                    bVar.jeV.setVisibility(8);
                    bVar.jeT.setVisibility(8);
                    bVar.jeW.setVisibility(8);
                }
                bVar.jeV.setVisibility(0);
                bVar.jeT.setVisibility(0);
                bVar.jeW.setVisibility(0);
                a(bVar.iIp, (int) this.mContext.getResources().getDimension(R.dimen.ds30));
            } else {
                bVar.jeU.setVisibility(8);
            }
            bVar.iIp.getLayoutStrategy().nj(R.drawable.pic_video);
            bVar.iIp.setTextColor(am.getColor(R.color.common_color_10039));
            bVar.iIp.setLinkTextColor(am.getColor(R.color.cp_link_tip_c));
            bVar.iIp.setLinkTextColor(am.getColor(R.color.cp_link_tip_c));
            if (this.iGw) {
                bVar.iIp.getLayoutStrategy().nm(R.drawable.transparent_bg);
            } else {
                bVar.iIp.getLayoutStrategy().nm(R.drawable.icon_click);
            }
            bVar.iIp.setIsFromCDN(this.mIsFromCDN);
            TbRichText tbRichText = null;
            if (0 == 0) {
                tbRichText = postData.cLx();
            }
            if (this.iIf || !this.iIg) {
                bVar.iIp.setText(tbRichText, false);
            } else {
                bVar.iIp.setText(tbRichText, true);
            }
            bh aBX = this.iGv.ckP().aBX();
            if (aBX != null) {
                bVar.jeS.startLoad(this.iGv.ckP().aBX().getThreadImgUrl(), this.mIsFromCDN ? 17 : 18, false);
                int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext);
                float aBN = aBX.aBN() / aBX.aBM();
                if (aBN > 1.0f) {
                    i = (int) (1.0f * equipmentWidth);
                } else if (aBN < 0.2f) {
                    i = (int) (equipmentWidth * 0.2f);
                } else {
                    i = (int) (equipmentWidth * aBN);
                }
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.jeS.getLayoutParams();
                layoutParams2.height = i;
                layoutParams2.width = equipmentWidth;
                bVar.jeS.setLayoutParams(layoutParams2);
            } else {
                bVar.jeS.setVisibility(8);
            }
            b(bVar, postData);
        }
    }

    private void b(b bVar, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.iGw) {
            bVar.iIp.setOnClickListener(null);
        } else {
            bVar.iIp.setOnClickListener(this.akE);
        }
        bVar.iIp.setTextViewCheckSelection(false);
        bVar.iIp.setTextViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.getLayoutStrategy().nk(this.jeQ - (i - this.jeP));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private void a(b bVar) {
        bVar.iIp.setOnLongClickListener(this.mOnLongClickListener);
        bVar.iIp.setOnTouchListener(this.drk);
        bVar.iIp.setOnImageClickListener(this.dNb);
        if (this.iHT != null && this.iHT.cnE() != null) {
            bVar.iIp.setOnEmotionClickListener(this.iHT.cnE().iFX.iUt);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setData(e eVar) {
        this.iGv = eVar;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void dH(String str) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setImageMaxWidth(int i) {
        this.iGD = i;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void pC(boolean z) {
        this.iGw = z;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void pD(boolean z) {
        this.iGx = z;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void pE(boolean z) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void P(View.OnClickListener onClickListener) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.dNb = iVar;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void y(View.OnClickListener onClickListener) {
        this.akE = onClickListener;
    }
}
