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
    private View.OnClickListener aRW;
    private c eFj;
    private TbRichTextView.i fcC;
    private f kAn;
    private boolean kAo;
    private boolean kAp;
    private int kAv;
    private boolean kCp;
    private final boolean kCq;
    private boolean laI;
    private int laJ;
    private int laK;
    private View.OnLongClickListener mOnLongClickListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
        boolean z = true;
        this.kAv = 0;
        this.kAo = true;
        this.laI = true;
        this.kAn = null;
        this.kAp = true;
        this.aRW = null;
        this.fcC = null;
        this.eFj = null;
        this.mOnLongClickListener = null;
        this.kCp = false;
        this.kCq = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        a(pbFragment);
    }

    @Override // com.baidu.tieba.pb.pb.main.o
    public void a(com.baidu.tieba.pb.videopb.b bVar) {
        super.a(bVar);
        if (bVar != null) {
            this.laJ = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds30);
            this.laK = l.getEquipmentWidth(this.mContext) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds60);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cu */
    public b b(ViewGroup viewGroup) {
        return new b(LayoutInflater.from(this.mContext).inflate(R.layout.pb_interview_normal_item, viewGroup, false), this.laI, this.kAo, this.kAv, false);
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
            a(bVar.kCz, (int) this.mContext.getResources().getDimension(R.dimen.ds30));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.kCz.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            bVar.kCz.setLayoutParams(layoutParams);
            bVar.kCz.setPadding(0, 0, 0, 0);
            bVar.kCz.CV(null);
            postData.bfQ();
            if (postData.dwK() == 1) {
                bVar.laO.setVisibility(0);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.beE() != null) {
                    j = postData.beE().getUserIdLong();
                    str = postData.beE().getUserName();
                    str2 = postData.beE().getName_show();
                }
                bVar.laO.a(postData.dwS(), str, str2, j, com.baidu.adp.lib.f.b.toLong(this.kAn.cVm().getId(), 0L), com.baidu.adp.lib.f.b.toLong(postData.getId(), 0L));
                bVar.laO.onChangeSkinType();
                if (this.kAp) {
                    PraiseData bep = this.kAn.cVm().bep();
                    if (bep != null && bep.getUser() != null && bep.getUser().size() > 0) {
                        bVar.laP.setVisibility(0);
                        bVar.laN.setVisibility(0);
                        bVar.laQ.setVisibility(0);
                        bVar.laP.setIsFromPb(true);
                        bVar.laP.setData(bep, this.kAn.cVm().getId(), bep.getPostId(), true);
                        bVar.laP.onChangeSkin(this.mSkinType);
                    } else {
                        bVar.laP.setVisibility(8);
                        bVar.laN.setVisibility(8);
                        bVar.laQ.setVisibility(8);
                    }
                } else {
                    bVar.laP.setVisibility(8);
                    bVar.laN.setVisibility(8);
                    bVar.laQ.setVisibility(8);
                }
                bVar.laP.setVisibility(0);
                bVar.laN.setVisibility(0);
                bVar.laQ.setVisibility(0);
                a(bVar.kCz, (int) this.mContext.getResources().getDimension(R.dimen.ds30));
            } else {
                bVar.laO.setVisibility(8);
            }
            bVar.kCz.getLayoutStrategy().rc(R.drawable.pic_video);
            bVar.kCz.setTextColor(ap.getColor(R.color.common_color_10039));
            bVar.kCz.setLinkTextColor(ap.getColor(R.color.cp_link_tip_c));
            bVar.kCz.setLinkTextColor(ap.getColor(R.color.cp_link_tip_c));
            if (this.kAo) {
                bVar.kCz.getLayoutStrategy().rf(R.drawable.transparent_bg);
            } else {
                bVar.kCz.getLayoutStrategy().rf(R.drawable.icon_click);
            }
            bVar.kCz.setIsFromCDN(this.mIsFromCDN);
            TbRichText tbRichText = null;
            if (0 == 0) {
                tbRichText = postData.dwM();
            }
            if (this.kCp || !this.kCq) {
                bVar.kCz.setText(tbRichText, false);
            } else {
                bVar.kCz.setText(tbRichText, true);
            }
            bu bek = this.kAn.cVm().bek();
            if (bek != null) {
                bVar.laM.startLoad(this.kAn.cVm().bek().getThreadImgUrl(), this.mIsFromCDN ? 17 : 18, false);
                int equipmentWidth = l.getEquipmentWidth(this.mContext);
                float bdZ = bek.bdZ() / bek.bdY();
                if (bdZ > 1.0f) {
                    i = (int) (1.0f * equipmentWidth);
                } else if (bdZ < 0.2f) {
                    i = (int) (equipmentWidth * 0.2f);
                } else {
                    i = (int) (equipmentWidth * bdZ);
                }
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.laM.getLayoutParams();
                layoutParams2.height = i;
                layoutParams2.width = equipmentWidth;
                bVar.laM.setLayoutParams(layoutParams2);
            } else {
                bVar.laM.setVisibility(8);
            }
            b(bVar, postData);
        }
    }

    private void b(b bVar, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.kAo) {
            bVar.kCz.setOnClickListener(null);
        } else {
            bVar.kCz.setOnClickListener(this.aRW);
        }
        bVar.kCz.setTextViewCheckSelection(false);
        bVar.kCz.setTextViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.getLayoutStrategy().rd(this.laK - (i - this.laJ));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private void a(b bVar) {
        bVar.kCz.setOnLongClickListener(this.mOnLongClickListener);
        bVar.kCz.setOnTouchListener(this.eFj);
        bVar.kCz.setOnImageClickListener(this.fcC);
        if (this.kCd != null && this.kCd.cYj() != null) {
            bVar.kCz.setOnEmotionClickListener(this.kCd.cYj().kzM.kPN);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setData(f fVar) {
        this.kAn = fVar;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void gM(String str) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setImageMaxWidth(int i) {
        this.kAv = i;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void sF(boolean z) {
        this.kAo = z;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void sG(boolean z) {
        this.kAp = z;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void sH(boolean z) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void S(View.OnClickListener onClickListener) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.fcC = iVar;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void A(View.OnClickListener onClickListener) {
        this.aRW = onClickListener;
    }
}
