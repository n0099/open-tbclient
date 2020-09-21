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
/* loaded from: classes21.dex */
public class a extends o<PostData, b> implements View.OnClickListener, com.baidu.tieba.pb.pb.a.a {
    private View.OnClickListener aTZ;
    private c eHq;
    private TbRichTextView.i ffu;
    private f kIK;
    private boolean kIL;
    private boolean kIM;
    private int kIS;
    private boolean kKN;
    private final boolean kKO;
    private int ljA;
    private int ljB;
    private boolean ljz;
    private View.OnLongClickListener mOnLongClickListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
        boolean z = true;
        this.kIS = 0;
        this.kIL = true;
        this.ljz = true;
        this.kIK = null;
        this.kIM = true;
        this.aTZ = null;
        this.ffu = null;
        this.eHq = null;
        this.mOnLongClickListener = null;
        this.kKN = false;
        this.kKO = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        a(pbFragment);
    }

    @Override // com.baidu.tieba.pb.pb.main.o
    public void a(com.baidu.tieba.pb.videopb.b bVar) {
        super.a(bVar);
        if (bVar != null) {
            this.ljA = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds30);
            this.ljB = l.getEquipmentWidth(this.mContext) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds60);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cv */
    public b c(ViewGroup viewGroup) {
        return new b(LayoutInflater.from(this.mContext).inflate(R.layout.pb_interview_normal_item, viewGroup, false), this.ljz, this.kIL, this.kIS, false);
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
            a(bVar.kKX, (int) this.mContext.getResources().getDimension(R.dimen.ds30));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.kKX.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            bVar.kKX.setLayoutParams(layoutParams);
            bVar.kKX.setPadding(0, 0, 0, 0);
            bVar.kKX.Dr(null);
            postData.bgK();
            if (postData.dAD() == 1) {
                bVar.ljF.setVisibility(0);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.bfy() != null) {
                    j = postData.bfy().getUserIdLong();
                    str = postData.bfy().getUserName();
                    str2 = postData.bfy().getName_show();
                }
                bVar.ljF.a(postData.dAL(), str, str2, j, com.baidu.adp.lib.f.b.toLong(this.kIK.cYR().getId(), 0L), com.baidu.adp.lib.f.b.toLong(postData.getId(), 0L));
                bVar.ljF.onChangeSkinType();
                if (this.kIM) {
                    PraiseData bfj = this.kIK.cYR().bfj();
                    if (bfj != null && bfj.getUser() != null && bfj.getUser().size() > 0) {
                        bVar.ljG.setVisibility(0);
                        bVar.ljE.setVisibility(0);
                        bVar.ljH.setVisibility(0);
                        bVar.ljG.setIsFromPb(true);
                        bVar.ljG.setData(bfj, this.kIK.cYR().getId(), bfj.getPostId(), true);
                        bVar.ljG.onChangeSkin(this.mSkinType);
                    } else {
                        bVar.ljG.setVisibility(8);
                        bVar.ljE.setVisibility(8);
                        bVar.ljH.setVisibility(8);
                    }
                } else {
                    bVar.ljG.setVisibility(8);
                    bVar.ljE.setVisibility(8);
                    bVar.ljH.setVisibility(8);
                }
                bVar.ljG.setVisibility(0);
                bVar.ljE.setVisibility(0);
                bVar.ljH.setVisibility(0);
                a(bVar.kKX, (int) this.mContext.getResources().getDimension(R.dimen.ds30));
            } else {
                bVar.ljF.setVisibility(8);
            }
            bVar.kKX.getLayoutStrategy().rt(R.drawable.pic_video);
            bVar.kKX.setTextColor(ap.getColor(R.color.common_color_10039));
            bVar.kKX.setLinkTextColor(ap.getColor(R.color.cp_link_tip_c));
            bVar.kKX.setLinkTextColor(ap.getColor(R.color.cp_link_tip_c));
            if (this.kIL) {
                bVar.kKX.getLayoutStrategy().rw(R.drawable.transparent_bg);
            } else {
                bVar.kKX.getLayoutStrategy().rw(R.drawable.icon_click);
            }
            bVar.kKX.setIsFromCDN(this.mIsFromCDN);
            TbRichText tbRichText = null;
            if (0 == 0) {
                tbRichText = postData.dAF();
            }
            if (this.kKN || !this.kKO) {
                bVar.kKX.setText(tbRichText, false);
            } else {
                bVar.kKX.setText(tbRichText, true);
            }
            bu bfe = this.kIK.cYR().bfe();
            if (bfe != null) {
                bVar.ljD.startLoad(this.kIK.cYR().bfe().getThreadImgUrl(), this.mIsFromCDN ? 17 : 18, false);
                int equipmentWidth = l.getEquipmentWidth(this.mContext);
                float beT = bfe.beT() / bfe.beS();
                if (beT > 1.0f) {
                    i = (int) (1.0f * equipmentWidth);
                } else if (beT < 0.2f) {
                    i = (int) (equipmentWidth * 0.2f);
                } else {
                    i = (int) (equipmentWidth * beT);
                }
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.ljD.getLayoutParams();
                layoutParams2.height = i;
                layoutParams2.width = equipmentWidth;
                bVar.ljD.setLayoutParams(layoutParams2);
            } else {
                bVar.ljD.setVisibility(8);
            }
            b(bVar, postData);
        }
    }

    private void b(b bVar, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.kIL) {
            bVar.kKX.setOnClickListener(null);
        } else {
            bVar.kKX.setOnClickListener(this.aTZ);
        }
        bVar.kKX.setTextViewCheckSelection(false);
        bVar.kKX.setTextViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.getLayoutStrategy().ru(this.ljB - (i - this.ljA));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private void a(b bVar) {
        bVar.kKX.setOnLongClickListener(this.mOnLongClickListener);
        bVar.kKX.setOnTouchListener(this.eHq);
        bVar.kKX.setOnImageClickListener(this.ffu);
        if (this.kKB != null && this.kKB.dbM() != null) {
            bVar.kKX.setOnEmotionClickListener(this.kKB.dbM().kIj.kYp);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setData(f fVar) {
        this.kIK = fVar;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void gY(String str) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setImageMaxWidth(int i) {
        this.kIS = i;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void sM(boolean z) {
        this.kIL = z;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void sN(boolean z) {
        this.kIM = z;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void sO(boolean z) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void S(View.OnClickListener onClickListener) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.ffu = iVar;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void A(View.OnClickListener onClickListener) {
        this.aTZ = onClickListener;
    }
}
