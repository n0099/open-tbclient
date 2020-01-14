package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.util.time.DateTimeUtil;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.switchs.NickNameActivitySwitch;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.TbListTextView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.l;
import com.baidu.tieba.pb.a.c;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
/* loaded from: classes7.dex */
public class k extends m<PostData, l> implements View.OnClickListener {
    private LayerDrawable MV;
    private LayerDrawable MW;
    private int WJ;
    private View.OnClickListener ain;
    private String anD;
    private int anq;
    private int anr;
    private TbRichTextView.i dIr;
    private boolean dKZ;
    private com.baidu.tieba.pb.a.c dmA;
    private com.baidu.adp.lib.d.b<ConstrainImageLayout> gri;
    private com.baidu.adp.lib.d.b<TbImageView> grj;
    private int iBt;
    private LayerDrawable iBu;
    protected com.baidu.tieba.pb.data.f iCZ;
    private int iDR;
    private TbRichTextView.c iDS;
    private com.baidu.tieba.pb.pb.sub.b iDT;
    private com.baidu.tieba.pb.a.c iDU;
    private boolean iDa;
    private View.OnClickListener iDj;
    private View.OnLongClickListener mOnLongClickListener;

    /* JADX INFO: Access modifiers changed from: private */
    public void ct(View view) {
        if (view != null && (view.getTag() instanceof l)) {
            l lVar = (l) view.getTag();
            if (lVar.iEe != null && lVar.iEe.getData() != null) {
                com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
                dVar.cJx = 5;
                dVar.cJz = 2;
                lVar.iEe.setStatisticData(dVar);
                lVar.iEe.aFe();
            }
        }
    }

    public k(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId) {
        super(bVar, bdUniqueId);
        this.anr = 0;
        this.iDR = 0;
        this.iBt = 0;
        this.anq = 0;
        this.iDS = null;
        this.iDa = true;
        this.anD = null;
        this.iCZ = null;
        this.iDj = null;
        this.ain = null;
        this.dIr = null;
        this.dmA = null;
        this.mOnLongClickListener = null;
        this.iDT = null;
        this.dKZ = true;
        this.gri = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.pb.pb.main.k.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: bEy */
            public ConstrainImageLayout makeObject() {
                return new ConstrainImageLayout(k.this.mContext);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: c */
            public void destroyObject(ConstrainImageLayout constrainImageLayout) {
                constrainImageLayout.removeAllViews();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: d */
            public ConstrainImageLayout activateObject(ConstrainImageLayout constrainImageLayout) {
                return constrainImageLayout;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: e */
            public ConstrainImageLayout passivateObject(ConstrainImageLayout constrainImageLayout) {
                return constrainImageLayout;
            }
        }, 6, 0);
        this.grj = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<TbImageView>() { // from class: com.baidu.tieba.pb.pb.main.k.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: aFP */
            public TbImageView makeObject() {
                TbImageView tbImageView = new TbImageView(k.this.mContext);
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(com.baidu.tbadk.core.util.am.getColor(R.color.common_color_10043));
                tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds1));
                return tbImageView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: a */
            public void destroyObject(TbImageView tbImageView) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: b */
            public TbImageView activateObject(TbImageView tbImageView) {
                return tbImageView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: c */
            public TbImageView passivateObject(TbImageView tbImageView) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
                return tbImageView;
            }
        }, 12, 0);
        this.iDU = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.k.3
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean onDoubleTap(View view, MotionEvent motionEvent) {
                if (view != null && (k.this.iCe == null || k.this.iCe.ckX() == null || k.this.iCe.ckX().cnS())) {
                    if (view instanceof RelativeLayout) {
                        k.this.ct(view);
                    } else {
                        ViewParent parent = view.getParent();
                        int i = 0;
                        while (true) {
                            if (parent == null || i >= 10) {
                                break;
                            } else if (parent instanceof RelativeLayout) {
                                k.this.ct((RelativeLayout) parent);
                                break;
                            } else {
                                i++;
                                parent = parent.getParent();
                            }
                        }
                    }
                }
                return true;
            }

            @Override // com.baidu.tieba.pb.a.c.a
            public boolean onDoubleTapEvent(View view, MotionEvent motionEvent) {
                return false;
            }

            @Override // com.baidu.tieba.pb.a.c.a
            public boolean onSingleTapConfirmed(View view, MotionEvent motionEvent) {
                if (k.this.dmA != null) {
                    if (!(view instanceof TbListTextView) || k.this.ain == null) {
                        k.this.dmA.Q(view);
                        k.this.dmA.onSingleTapConfirmed(motionEvent);
                        return true;
                    }
                    k.this.ain.onClick(view);
                    return true;
                }
                return true;
            }
        });
        if (bVar != null && bVar.ckc() != null) {
            this.WJ = bVar.ckc().cmO();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bF */
    public l b(ViewGroup viewGroup) {
        l lVar = new l(this.iEA.clM().getPageContext(), LayoutInflater.from(this.mContext).inflate(R.layout.pb_reply_floor_item_layout, viewGroup, false), this.WJ);
        lVar.iEh.setConstrainLayoutPool(this.gri);
        lVar.iEh.setImageViewPool(this.grj);
        a(lVar);
        this.anr = getDimensionPixelSize(R.dimen.tbds10);
        this.iDR = getDimensionPixelSize(R.dimen.tbds14);
        this.iBt = getDimensionPixelSize(R.dimen.tbds40);
        this.anq = getDimensionPixelSize(R.dimen.tbds6);
        if (lVar.iEg != null) {
            lVar.iEg.setDuiEnabled(this.dKZ);
        }
        nf();
        return lVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.m, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, PostData postData, l lVar) {
        super.a(i, view, viewGroup, (ViewGroup) postData, (PostData) lVar);
        a(lVar);
        b(lVar);
        c(lVar);
        PostData postData2 = (PostData) getItem(i);
        if (postData2 != null) {
            postData2.locate = i + 1;
            h(postData2);
            i(postData2);
            postData2.aBh();
            g(postData2);
            a(lVar, postData2, view, i);
        }
        return view;
    }

    public void setDuiEnabled(boolean z) {
        this.dKZ = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private void g(PostData postData) {
        if (postData != null) {
            int i = 8;
            if (postData.kgn) {
                i = 2;
            }
            com.baidu.tbadk.core.util.an b = com.baidu.tieba.pb.c.a.b(this.iCZ, postData, postData.locate, i, 6);
            postData.kgo = b;
            if (!com.baidu.tbadk.core.util.v.isEmpty(postData.cJw())) {
                Iterator<PostData> it = postData.cJw().iterator();
                while (it.hasNext()) {
                    it.next().kgo = b;
                }
            }
        }
    }

    private void a(l lVar, PostData postData, View view, int i) {
        if (lVar != null && postData != null) {
            b(lVar, postData, view, i);
            f(lVar, postData);
            a(lVar, postData, view);
            c(lVar, postData, view, i);
            g(lVar, postData);
            a(lVar, postData);
            h(lVar, postData);
            c(lVar, postData);
            e(lVar, postData);
            i(lVar, postData);
            b(lVar, postData);
        }
    }

    private void b(l lVar, PostData postData) {
        if (lVar != null && lVar.iDY != null) {
            if (this.iEA != null && this.iEA.ckc() != null && this.iEA.ckc().cmW() && com.baidu.tbadk.core.util.aq.equals(this.iEA.ckc().cmb(), postData.getId())) {
                com.baidu.tbadk.core.util.am.setBackgroundColor(lVar.iDY, R.color.cp_other_g);
            } else {
                com.baidu.tbadk.core.util.am.setBackgroundColor(lVar.iDY, R.color.cp_bg_line_e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(l lVar, boolean z, String str) {
        if (z) {
            lVar.iEw.setVisibility(8);
            if (StringUtils.isNull(str)) {
                lVar.iEy.setText(R.string.expand_content);
                return;
            } else {
                lVar.iEy.setText(str);
                return;
            }
        }
        lVar.iEw.setVisibility(0);
        lVar.iEy.setText(R.string.close_content);
    }

    private void c(final l lVar, final PostData postData) {
        if (postData.cJL() == 2 || postData.cJL() == 4) {
            lVar.iEx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.k.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    boolean z = lVar.iEw.getVisibility() == 8;
                    k.this.a(lVar, !z, postData.cja());
                    postData.sH(z ? false : true);
                    k.this.d(lVar, postData);
                    if (k.this.iCe != null && k.this.iCe.ckX() != null && k.this.iCe.ckX().coT() != null && k.this.iCe.ckX().getListView() != null && !z && lVar.getView().getTop() < k.this.iCe.ckX().coT().getMeasuredHeight()) {
                        k.this.iCe.ckX().getListView().setSelectionFromTop(com.baidu.tbadk.core.util.v.getPosition(k.this.iCe.ckX().getListView().getData(), postData) + k.this.iCe.ckX().getListView().getHeaderViewsCount(), k.this.iCe.ckX().coT().getMeasuredHeight());
                    }
                }
            });
            lVar.iEx.setVisibility(0);
            a(lVar, postData.cJu(), postData.cja());
            a(true, lVar, postData);
        } else {
            lVar.iEx.setVisibility(8);
            lVar.iEw.setVisibility(0);
            a(false, lVar, postData);
        }
        d(lVar, postData);
    }

    private void a(boolean z, l lVar, PostData postData) {
        if (lVar != null && lVar.mBottomLine != null && lVar.iEx != null && (lVar.mBottomLine.getLayoutParams() instanceof RelativeLayout.LayoutParams) && (lVar.iEx.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            boolean z2 = !com.baidu.tbadk.core.util.v.isEmpty(postData.cJw());
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) lVar.mBottomLine.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) lVar.iEx.getLayoutParams();
            if (z) {
                lVar.iEg.getLayoutStrategy().mZ(0);
                if (z2) {
                    lVar.iEg.getLayoutStrategy().mY(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
                    if (layoutParams2 != null) {
                        layoutParams2.topMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds26);
                    }
                } else {
                    lVar.iEg.getLayoutStrategy().mY(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds8));
                    if (layoutParams2 != null) {
                        layoutParams2.topMargin = 0;
                    }
                }
                lVar.iEx.setLayoutParams(layoutParams2);
                if (layoutParams != null) {
                    layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44);
                    lVar.mBottomLine.setLayoutParams(layoutParams);
                    return;
                }
                return;
            }
            lVar.iEg.getLayoutStrategy().mY(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
            lVar.iEg.getLayoutStrategy().mZ(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds12));
            if (layoutParams != null) {
                layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds38);
                lVar.mBottomLine.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(l lVar, PostData postData) {
        TbRichText cJB = postData.cJB();
        cJB.isChanged = true;
        lVar.iEg.setText(cJB, true, this.iDS);
    }

    private void h(PostData postData) {
        if (postData.cOH == 0 && postData.gtC) {
            com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c12203");
            anVar.cp("post_id", postData.getId());
            anVar.cp("uid", TbadkCoreApplication.getCurrentAccount());
            anVar.cp("cuid", TbadkCoreApplication.getInst().getCuid());
            anVar.cp("cuid_galaxy2", TbadkCoreApplication.getInst().getCuidGalaxy2());
            anVar.cp("cuid_gid", TbadkCoreApplication.getInst().getCuidGid());
            anVar.s(TiebaInitialize.Params.EXPOSURE_TIME, System.currentTimeMillis());
            if (this.iEA != null) {
                int cmO = this.iEA.ckc().cmO();
                if (1 == cmO || 2 == cmO) {
                    anVar.cp("obj_source", "1");
                } else if (3 == cmO) {
                    anVar.cp("obj_source", "2");
                } else {
                    anVar.cp("obj_source", "0");
                }
            }
            TiebaStatic.log(anVar);
        }
    }

    private void i(PostData postData) {
        if (this.iCZ != null) {
            if (this.iCZ.cjp()) {
                if (this.iEB != null) {
                    com.baidu.tieba.pb.c.a.a(this.iEB.getUniqueId(), this.iCZ, postData, postData.locate, postData.kgn ? 2 : 8);
                }
            } else if (this.iCe != null) {
                com.baidu.tieba.pb.c.a.a(this.iCe.getUniqueId(), this.iCZ, postData, postData.locate, postData.kgn ? 2 : 8);
            }
        }
    }

    private void a(l lVar, PostData postData) {
        if (postData == null || postData.cqG() == null) {
            lVar.iEq.setVisibility(8);
            return;
        }
        TbRichText cJB = postData.cJB();
        com.baidu.tieba.pb.view.b.a(postData.cqG(), lVar.iEq, false, false, cJB != null && StringUtils.isNull(cJB.toString()) && StringUtils.isNull(postData.getBimg_url()));
    }

    private void e(l lVar, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.iDa) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) lVar.iEg.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            lVar.iEg.setLayoutParams(layoutParams);
            lVar.iEg.setPadding(0, 0, 0, 0);
            lVar.iEg.vN(null);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) lVar.iEg.getLayoutParams();
            layoutParams2.topMargin = getDimensionPixelSize(R.dimen.ds20);
            layoutParams2.bottomMargin = getDimensionPixelSize(R.dimen.ds20);
            lVar.iEg.setLayoutParams(layoutParams2);
            lVar.iEg.vN(postData.getBimg_url());
        }
        lVar.iEg.setTextViewOnTouchListener(this.iDU);
        lVar.iEg.setTextViewCheckSelection(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:172:0x0494  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x04a0  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x04bb  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x04c6  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x04ca  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0517  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0584  */
    /* JADX WARN: Removed duplicated region for block: B:281:0x08a7  */
    /* JADX WARN: Removed duplicated region for block: B:282:0x08b4  */
    /* JADX WARN: Removed duplicated region for block: B:283:0x08c1  */
    /* JADX WARN: Removed duplicated region for block: B:284:0x08ce  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(l lVar, PostData postData, View view, int i) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        String userId;
        if (lVar != null && postData != null) {
            if (postData.azX() == null || postData.azX().getBaijiahaoInfo() != null) {
            }
            if (postData.kgd) {
                com.baidu.tbadk.core.util.am.setBackgroundColor(lVar.mTopLine, R.color.cp_bg_line_c);
                lVar.mTopLine.setVisibility(0);
            } else {
                lVar.mTopLine.setVisibility(8);
            }
            lVar.iEf.setTag(null);
            lVar.iEf.setUserId(null);
            lVar.ftZ.setText((CharSequence) null);
            lVar.iEn.getHeadView().setUserId(null);
            lVar.iEg.setIsHost(false);
            if (postData.azX() != null) {
                if (this.anD != null && !this.anD.equals("0") && this.anD.equals(postData.azX().getUserId())) {
                    lVar.iEg.setIsHost(true);
                }
                ArrayList<IconData> iconInfo = postData.azX().getIconInfo();
                ArrayList<IconData> tShowInfoNew = postData.azX().getTShowInfoNew();
                if (lVar.iEp != null) {
                    lVar.iEp.setTag(R.id.tag_user_id, postData.azX().getUserId());
                    if (this.iEA != null && this.iEA.clM() != null) {
                        lVar.iEp.setOnClickListener(this.iEA.clM().iCz.iRh);
                    }
                    lVar.iEp.a(iconInfo, 2, this.iBt, this.iBt, this.anr);
                }
                if (lVar.iEo != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        lVar.iEo.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    if (this.iEA != null && this.iEA.clM() != null) {
                        lVar.iEo.setOnClickListener(this.iEA.clM().iCz.iRi);
                    }
                    lVar.iEo.a(tShowInfoNew, 3, this.iBt, this.iBt, this.anr, true);
                }
                if (!com.baidu.tbadk.core.util.v.isEmpty(tShowInfoNew) || postData.azX().isBigV()) {
                    com.baidu.tbadk.core.util.am.setViewTextColor(lVar.ftZ, R.color.cp_cont_h, 1);
                } else {
                    com.baidu.tbadk.core.util.am.setViewTextColor(lVar.ftZ, R.color.cp_cont_b, 1);
                }
                String avater = postData.azX().getAvater();
                int i2 = 8;
                if (postData.kgn) {
                    i2 = 2;
                }
                lVar.ftZ.setTag(R.id.tag_user_id, postData.azX().getUserId());
                lVar.ftZ.setTag(R.id.tag_user_name, postData.azX().getUserName());
                lVar.ftZ.setTag(R.id.tag_virtual_user_url, postData.azX().getVirtualUserUrl());
                lVar.ftZ.setTag(R.id.tag_statistic_item, com.baidu.tieba.pb.c.a.b(this.iCZ, postData, postData.locate, i2, 2));
                String name_show = postData.azX().getName_show();
                String userName = postData.azX().getUserName();
                if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                    lVar.ftZ.setText(com.baidu.tieba.pb.d.ba(this.mContext, lVar.ftZ.getText().toString()));
                    lVar.ftZ.setGravity(16);
                    lVar.ftZ.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.d.cix());
                    com.baidu.tbadk.core.util.am.setViewTextColor(lVar.ftZ, R.color.cp_other_f, 1);
                }
                if (postData.azX().getPendantData() != null && !StringUtils.isNull(postData.azX().getPendantData().ayq())) {
                    lVar.iEn.b(postData.azX());
                    lVar.iEf.setVisibility(8);
                    lVar.iEn.setVisibility(0);
                    lVar.iEn.getHeadView().startLoad(avater, 28, false);
                    lVar.iEn.getHeadView().setUserId(postData.azX().getUserId());
                    lVar.iEn.getHeadView().setUserName(postData.azX().getUserName());
                    lVar.iEn.getHeadView().setFid(this.iCZ != null ? this.iCZ.getForumId() : "");
                    lVar.iEn.getHeadView().setTid(postData.getId());
                    lVar.iEn.getHeadView().setTag(R.id.tag_statistic_item, com.baidu.tieba.pb.c.a.b(this.iCZ, postData, postData.locate, i2, 2));
                    lVar.iEn.tC(postData.azX().getPendantData().ayq());
                } else {
                    UtilHelper.showHeadImageViewBigV(lVar.iEf, postData.azX(), 0);
                    lVar.iEf.setUserId(postData.azX().getUserId());
                    lVar.iEf.setFid(this.iCZ != null ? this.iCZ.getForumId() : "");
                    lVar.iEf.setTid(postData.getId());
                    lVar.iEf.setUserName(postData.azX().getUserName(), postData.cJJ());
                    lVar.iEf.setTag(R.id.tag_virtual_user_url, postData.azX().getVirtualUserUrl());
                    lVar.iEf.setTag(R.id.tag_statistic_item, com.baidu.tieba.pb.c.a.b(this.iCZ, postData, postData.locate, i2, 2));
                    lVar.iEf.setImageDrawable(null);
                    lVar.iEf.startLoad(avater, 28, false);
                    lVar.iEf.setVisibility(0);
                    lVar.iEn.setVisibility(8);
                }
                if (this.iCZ != null && this.iCZ.cjs()) {
                    lVar.iDZ.setVisibility(8);
                    lVar.iDZ.setTag(null);
                } else if (postData.azX() != null) {
                    MetaData azX = postData.azX();
                    com.baidu.tbadk.core.util.am.setViewTextColor(lVar.iDZ, (int) R.color.cp_cont_a);
                    if (this.anD != null && !this.anD.equals("0") && this.anD.equals(azX.getUserId())) {
                        lVar.iDZ.setTag("HOST");
                        if (lVar.mSkinType == 1) {
                            if (this.iBu.getDrawable(1) != null) {
                                this.iBu.getDrawable(1).setAlpha(255);
                            }
                        } else if (this.iBu.getDrawable(1) != null) {
                            this.iBu.getDrawable(1).setAlpha(0);
                        }
                        lVar.iDZ.setBackgroundDrawable(this.iBu);
                        lVar.iDZ.setVisibility(0);
                        lVar.iDZ.setText(R.string.host_name);
                    } else if (azX.getIs_bawu() == 1 && postData.cJr()) {
                        com.baidu.tbadk.core.util.am.setBackgroundResource(lVar.iDZ, R.drawable.brand_official_btn);
                        lVar.iDZ.setTag(Integer.valueOf((int) R.drawable.brand_official_btn));
                        lVar.iDZ.setVisibility(0);
                        lVar.iDZ.setText(R.string.brand_Official);
                    } else if (azX.getIs_bawu() == 1 && Config.BAWU_TYPE_MANAGER.equals(azX.getBawu_type())) {
                        lVar.iDZ.setTag("BA_ZHU_BG");
                        if (lVar.mSkinType == 1) {
                            if (this.MV.getDrawable(1) != null) {
                                this.MV.getDrawable(1).setAlpha(255);
                            }
                        } else if (this.MV.getDrawable(1) != null) {
                            this.MV.getDrawable(1).setAlpha(0);
                        }
                        lVar.iDZ.setBackgroundDrawable(this.MV);
                        lVar.iDZ.setVisibility(0);
                        lVar.iDZ.setText(R.string.bawu_member_bazhu_tip);
                    } else if (azX.getIs_bawu() == 1 && Config.BAWU_TYPE_ASSIST.equals(azX.getBawu_type())) {
                        lVar.iDZ.setTag("XIAO_BA_ZHU_BG");
                        if (lVar.mSkinType == 1) {
                            if (this.MW.getDrawable(1) != null) {
                                this.MW.getDrawable(1).setAlpha(255);
                            }
                        } else if (this.MW.getDrawable(1) != null) {
                            this.MW.getDrawable(1).setAlpha(0);
                        }
                        lVar.iDZ.setBackgroundDrawable(this.MW);
                        lVar.iDZ.setVisibility(0);
                        lVar.iDZ.setText(R.string.bawu_member_xbazhu_tip);
                    } else if (azX.getIs_bawu() == 1 && "pri_content_assist".equals(azX.getBawu_type())) {
                        int kd = com.baidu.tbadk.core.util.am.kd(R.drawable.bg_user_identity_btn);
                        com.baidu.tbadk.core.util.am.setBackgroundResource(lVar.iDZ, kd);
                        lVar.iDZ.setTag(Integer.valueOf(kd));
                        lVar.iDZ.setVisibility(0);
                        lVar.iDZ.setText(R.string.bawu_content_assist_tip);
                    } else if (azX.getIs_bawu() == 1 && "pri_manage_assist".equals(azX.getBawu_type())) {
                        int kd2 = com.baidu.tbadk.core.util.am.kd(R.drawable.bg_user_identity_btn);
                        com.baidu.tbadk.core.util.am.setBackgroundResource(lVar.iDZ, kd2);
                        lVar.iDZ.setTag(Integer.valueOf(kd2));
                        lVar.iDZ.setVisibility(0);
                        lVar.iDZ.setText(R.string.bawu_manage_assist_tip);
                    } else {
                        lVar.iDZ.setVisibility(8);
                        lVar.iDZ.setTag(null);
                    }
                } else {
                    lVar.iDZ.setVisibility(8);
                    lVar.iDZ.setTag(null);
                }
            }
            int i3 = 0;
            if (this.iEA != null && this.iEA.clM() != null && this.iEA.clM().cjR() && postData.azX() != null) {
                i3 = postData.azX().getLevel_id();
            }
            if (this.iCZ != null && this.iCZ.cjs()) {
                i3 = 0;
            }
            if (i3 > 0) {
                lVar.iEm.setVisibility(0);
                com.baidu.tbadk.core.util.am.setImageResource(lVar.iEm, BitmapHelper.getGradeResourceIdInEnterForum(i3));
            } else {
                lVar.iEm.setVisibility(8);
            }
            int i4 = 15;
            if (lVar.iEp.getChildCount() == 1) {
                i4 = 13;
            } else if (lVar.iEp.getChildCount() > 1) {
                i4 = 11;
            }
            if (lVar.iDZ.getVisibility() == 0) {
                i4 -= 2;
            }
            if (lVar.iEo.getChildCount() > 0) {
                i4 -= 2;
            }
            if (postData.aBt() > 1000) {
                i4 -= 2;
            }
            if (postData.aBt() > 10) {
                i4 -= 2;
            }
            if (i4 < 10) {
                lVar.iEp.setVisibility(8);
                if (lVar.iEp.getChildCount() == 1) {
                    i4 += 2;
                } else if (lVar.iEp.getChildCount() > 1) {
                    i4 += 4;
                }
                if (i4 < 10 && lVar.iDZ.getVisibility() == 0) {
                    i4 += 2;
                    lVar.iDZ.setVisibility(8);
                }
                if (i4 < 10 && lVar.iEm.getVisibility() == 0) {
                    i4 += 2;
                    lVar.iEm.setVisibility(8);
                }
            }
            String name_show2 = postData.azX() != null ? postData.azX().getName_show() : "";
            int textLengthWithEmoji = com.baidu.tbadk.util.ad.getTextLengthWithEmoji(name_show2);
            if (postData.azX() != null && !StringUtils.isNull(postData.azX().getSealPrefix())) {
                if (textLengthWithEmoji > i4 - 2) {
                    name_show2 = com.baidu.tbadk.util.ad.subStringWithEmoji(name_show2, i4 - 2) + StringHelper.STRING_MORE;
                }
            } else if (textLengthWithEmoji > i4) {
                name_show2 = com.baidu.tbadk.util.ad.subStringWithEmoji(name_show2, i4) + StringHelper.STRING_MORE;
            }
            if (postData.azX() != null && !StringUtils.isNull(postData.azX().getSealPrefix())) {
                lVar.ftZ.setText(cs(postData.azX().getSealPrefix(), name_show2));
            } else {
                lVar.ftZ.setText(name_show2);
            }
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_load_sub_data, postData);
            sparseArray.put(R.id.tag_load_sub_view, view);
            sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(postData.cJz()));
            sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
            boolean z9 = false;
            if (postData.azX() != null && !StringUtils.isNull(postData.azX().getVirtualUserUrl())) {
                z9 = true;
            }
            boolean z10 = false;
            boolean z11 = false;
            boolean z12 = false;
            if (this.iCZ != null && this.iCZ.cje() != 0) {
                if (this.iCZ.cje() != 1002 && this.iCZ.cje() != 3) {
                    z10 = true;
                }
                if (this.iCZ.cje() != 3 && !this.iCZ.cjs()) {
                    z11 = true;
                }
                if (postData != null && postData.azX() != null) {
                    String userId2 = postData.azX().getUserId();
                    if (UtilHelper.isCurrentAccount(userId2)) {
                        z10 = false;
                    }
                    if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                        boolean z13 = z11;
                        z = false;
                        z2 = z13;
                        if (this.iCZ != null && this.iCZ.ciS() != null && this.iCZ.ciS().azX() != null && postData.azX() != null) {
                            userId = this.iCZ.ciS().azX().getUserId();
                            String userId3 = postData.azX().getUserId();
                            if (UtilHelper.isCurrentAccount(userId)) {
                                z3 = true;
                                z4 = true;
                                if (UtilHelper.isCurrentAccount(userId3)) {
                                    z4 = false;
                                    z12 = true;
                                }
                                if (postData == null && postData.azX() != null && UtilHelper.isCurrentAccount(postData.azX().getUserId())) {
                                    z5 = true;
                                    z6 = true;
                                } else {
                                    boolean z14 = z12;
                                    z5 = z3;
                                    z6 = z14;
                                }
                                if (z9) {
                                    z = false;
                                    z8 = false;
                                    z7 = false;
                                } else {
                                    z7 = z4;
                                    z8 = z5;
                                }
                                int i5 = 1;
                                if (postData.cJz() == 1) {
                                    i5 = 0;
                                }
                                if (z) {
                                    sparseArray.put(R.id.tag_should_manage_visible, true);
                                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.iCZ.cje()));
                                    if (postData.azX() != null) {
                                        sparseArray.put(R.id.tag_forbid_user_name, postData.azX().getUserName());
                                        sparseArray.put(R.id.tag_forbid_user_name_show, postData.azX().getName_show());
                                        sparseArray.put(R.id.tag_forbid_user_portrait, postData.azX().getPortrait());
                                    }
                                } else {
                                    sparseArray.put(R.id.tag_should_manage_visible, false);
                                }
                                if (z7) {
                                    sparseArray.put(R.id.tag_user_mute_visible, true);
                                    sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                                    if (postData.azX() != null) {
                                        sparseArray.put(R.id.tag_user_mute_mute_userid, postData.azX().getUserId());
                                        sparseArray.put(R.id.tag_user_mute_mute_username, postData.azX().getUserName());
                                        sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.azX().getName_show());
                                    }
                                    if (this.iCZ.ciS() != null) {
                                        sparseArray.put(R.id.tag_user_mute_thread_id, this.iCZ.ciS().getId());
                                    }
                                    sparseArray.put(R.id.tag_user_mute_post_id, postData.getId());
                                } else {
                                    sparseArray.put(R.id.tag_user_mute_visible, false);
                                }
                                if (z8) {
                                    sparseArray.put(R.id.tag_should_delete_visible, true);
                                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.iCZ.cje()));
                                    sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z6));
                                    sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i5));
                                    sparseArray.put(R.id.tag_del_post_id, postData.getId());
                                } else {
                                    sparseArray.put(R.id.tag_should_delete_visible, false);
                                }
                                lVar.iEg.setTag(sparseArray);
                            }
                        }
                        z3 = z2;
                        z4 = false;
                        if (postData == null) {
                        }
                        boolean z142 = z12;
                        z5 = z3;
                        z6 = z142;
                        if (z9) {
                        }
                        int i52 = 1;
                        if (postData.cJz() == 1) {
                        }
                        if (z) {
                        }
                        if (z7) {
                        }
                        if (z8) {
                        }
                        lVar.iEg.setTag(sparseArray);
                    }
                }
            }
            boolean z15 = z11;
            z = z10;
            z2 = z15;
            if (this.iCZ != null) {
                userId = this.iCZ.ciS().azX().getUserId();
                String userId32 = postData.azX().getUserId();
                if (UtilHelper.isCurrentAccount(userId)) {
                }
            }
            z3 = z2;
            z4 = false;
            if (postData == null) {
            }
            boolean z1422 = z12;
            z5 = z3;
            z6 = z1422;
            if (z9) {
            }
            int i522 = 1;
            if (postData.cJz() == 1) {
            }
            if (z) {
            }
            if (z7) {
            }
            if (z8) {
            }
            lVar.iEg.setTag(sparseArray);
        }
    }

    private void f(l lVar, PostData postData) {
        if (lVar != null && postData != null && postData.aBM() != null) {
            postData.aBM().threadId = this.iEA.ckc().cmc();
            postData.aBM().objType = 1;
            postData.aBM().isInPost = true;
            bj bjVar = null;
            if (this.iCZ != null && this.iCZ.ciS() != null) {
                bjVar = this.iCZ.ciS();
            }
            if (bjVar != null && bjVar.aBV()) {
                lVar.iEe.setAgreeAlone(true);
            }
            lVar.iEe.setData(postData.aBM());
        }
    }

    private void g(l lVar, PostData postData) {
        boolean z;
        int i;
        int i2;
        if (lVar != null && postData != null) {
            if (postData.cJz() > 0 && this.iCZ != null && !this.iCZ.cjs()) {
                String format = String.format(this.mContext.getString(R.string.is_floor), Integer.valueOf(postData.cJz()));
                lVar.iEl.setVisibility(0);
                lVar.iEl.setText(format);
                z = true;
            } else {
                lVar.iEl.setVisibility(8);
                z = false;
            }
            com.baidu.tbadk.data.f cJC = postData.cJC();
            boolean z2 = (cJC == null || StringUtils.isNull(cJC.getName()) || this.iCZ == null || this.iCZ.cjs()) ? false : true;
            if (z) {
                lVar.iEb.setVisibility(0);
                i = this.iDR;
            } else {
                lVar.iEb.setVisibility(8);
                i = 0;
            }
            if (z2) {
                lVar.iEc.setVisibility(0);
                i2 = this.iDR;
            } else {
                lVar.iEc.setVisibility(8);
                i2 = 0;
            }
            lVar.iEa.setPadding(i, 0, i2, 0);
            if (StringUtils.SimpleDateFormat(new Date(), DateTimeUtil.YEAR_FORMAT).equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), DateTimeUtil.YEAR_FORMAT))) {
                lVar.iEa.setText(com.baidu.tbadk.core.util.aq.getFormatTimeShort(postData.getTime()));
            } else {
                lVar.iEa.setText(com.baidu.tbadk.core.util.aq.getFormatTime(postData.getTime()));
            }
            if (z2) {
                lVar.iEd.setVisibility(0);
                lVar.iEd.setPadding(this.iDR, 0, 0, 0);
                if (postData.kgl) {
                    lVar.iEd.setText(com.baidu.tbadk.core.util.aq.cutStringWithSuffix(cJC.getName(), 7, StringHelper.STRING_MORE));
                    return;
                } else {
                    lVar.iEd.setText(cJC.getName());
                    return;
                }
            }
            lVar.iEd.setVisibility(8);
        }
    }

    private void a(l lVar, PostData postData, View view) {
        if (lVar != null && postData != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) lVar.iEg.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44);
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds166);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            lVar.iEg.setPadding(0, 0, 0, 0);
            if (!this.iDa) {
                lVar.iEg.getLayoutStrategy().mT(R.drawable.icon_click);
            } else {
                lVar.iEg.vN(null);
                lVar.iEg.setBackgroundDrawable(null);
                lVar.iEg.getLayoutStrategy().mT(R.drawable.transparent_bg);
            }
            lVar.iEg.getLayoutStrategy().mQ(R.drawable.pic_video);
            a(lVar.iEg, view, !StringUtils.isNull(postData.getBimg_url()));
            lVar.iEg.setLayoutParams(layoutParams);
            lVar.iEg.setLinkTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_link_tip_c));
            lVar.iEg.setIsFromCDN(this.mIsFromCDN);
            TbRichText cJB = postData.cJB();
            lVar.iEg.setIsUseGridImage(postData.cJM());
            lVar.iEg.setText(cJB, true, this.iDS);
            SparseArray sparseArray = (SparseArray) lVar.iEg.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, false);
            lVar.iEg.setTag(sparseArray);
            lVar.iDY.setTag(R.id.tag_from, sparseArray);
        }
    }

    private void a(TbRichTextView tbRichTextView, View view, boolean z) {
        if (tbRichTextView != null && view != null) {
            int equipmentWidth = (((com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
            if (tbRichTextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) tbRichTextView.getLayoutParams();
                equipmentWidth = (equipmentWidth - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin;
            }
            int dimensionPixelSize = z ? getDimensionPixelSize(R.dimen.tbds90) : 0;
            tbRichTextView.getLayoutStrategy().mR(equipmentWidth - dimensionPixelSize);
            tbRichTextView.getLayoutStrategy().dJT = (equipmentWidth - dimensionPixelSize) - getDimensionPixelSize(R.dimen.tbds122);
            tbRichTextView.getLayoutStrategy().mS((int) (equipmentWidth * 1.618f));
        }
    }

    private void c(l lVar, PostData postData, View view, int i) {
        if (lVar != null && postData != null) {
            if (postData.cJD() > 0) {
                lVar.iEk.setVisibility(8);
            } else {
                SparseArray sparseArray = (SparseArray) lVar.iEk.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    lVar.iEk.setTag(sparseArray);
                }
                sparseArray.put(R.id.tag_load_sub_data, postData);
                if (postData.cJL() == 2) {
                    lVar.iEk.setVisibility(8);
                } else {
                    lVar.iEk.setVisibility(0);
                }
                lVar.iEj.setVisibility(8);
            }
            if (TbSingleton.getInstance().isPbFold()) {
                if (postData.cJD() > 0) {
                    lVar.iEj.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.sub_pb_load_more, Integer.valueOf(postData.cJD())));
                    SparseArray sparseArray2 = (SparseArray) lVar.iEj.getTag();
                    if (sparseArray2 == null) {
                        sparseArray2 = new SparseArray();
                        lVar.iEj.setTag(sparseArray2);
                    }
                    sparseArray2.put(R.id.tag_load_sub_data, postData);
                    lVar.iEj.setVisibility(0);
                    lVar.iEk.setVisibility(8);
                    lVar.iEi.setVisibility(8);
                }
            } else {
                lVar.iEj.setVisibility(8);
                if (postData.cJD() > 0 && postData.cJw() != null && postData.cJw().size() > 0) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) lVar.iEi.getLayoutParams();
                    layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds10);
                    layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds166);
                    layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44);
                    layoutParams.bottomMargin = 0;
                    lVar.iEi.setLayoutParams(layoutParams);
                    if (this.iDT == null) {
                        this.iDT = new com.baidu.tieba.pb.pb.sub.b(this.mContext);
                        this.iDT.setIsFromCDN(this.mIsFromCDN);
                        this.iDT.setOnLongClickListener(this.mOnLongClickListener);
                        this.iDT.S(this.iDj);
                        this.iDT.x(this.ain);
                        String str = null;
                        if (this.iCZ != null && this.iCZ.ciS() != null && this.iCZ.ciS().azX() != null) {
                            str = this.iCZ.ciS().azX().getUserId();
                        }
                        boolean z = str != null && str.equals(TbadkCoreApplication.getCurrentAccount());
                        if (this.iCZ != null) {
                            this.iDT.P(this.iCZ.cje(), z);
                            this.iDT.setThreadData(this.iCZ.ciS());
                        }
                    }
                    this.iDT.Gc(postData.getId());
                    lVar.iEi.setSubPbAdapter(this.iDT);
                    lVar.iEi.setVisibility(0);
                    lVar.iEi.setData(postData, view);
                    lVar.iEi.setChildOnClickListener(this.ain);
                    lVar.iEi.setChildOnLongClickListener(this.mOnLongClickListener);
                    lVar.iEi.setChildOnTouchListener(this.iDU);
                } else {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) lVar.iEi.getLayoutParams();
                    layoutParams2.topMargin = 0;
                    layoutParams2.leftMargin = 0;
                    layoutParams2.rightMargin = 0;
                    layoutParams2.bottomMargin = 0;
                    lVar.iEi.setLayoutParams(layoutParams2);
                    lVar.iEi.setVisibility(8);
                }
            }
            if (postData.kgb) {
                lVar.mBottomLine.setVisibility(0);
            } else {
                lVar.mBottomLine.setVisibility(4);
            }
        }
    }

    private void h(l lVar, PostData postData) {
        if (lVar != null && lVar.iEu != null && lVar.iEr != null) {
            if (postData == null || postData.kgf == null || StringUtils.isNull(postData.kgf.liveTitle)) {
                lVar.iEr.setVisibility(8);
                return;
            }
            lVar.iEu.setText(postData.kgf.liveTitle);
            lVar.iEr.setTag(postData.kgf);
            lVar.iEr.setVisibility(0);
            com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c12639");
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                anVar.cp("uid", TbadkCoreApplication.getCurrentAccount());
            }
            TiebaStatic.log(anVar);
        }
    }

    private void i(l lVar, PostData postData) {
        if (lVar != null && postData != null) {
            lVar.iEz.setVisibility(postData.kgl ? 0 : 8);
        }
    }

    private void a(l lVar) {
        LayerDrawable layerDrawable;
        if (lVar != null) {
            if (lVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                com.baidu.tbadk.core.util.am.setViewTextColor(lVar.ftZ, R.color.cp_cont_b, 1);
                if (lVar.iDZ.getTag() instanceof Integer) {
                    com.baidu.tbadk.core.util.am.setBackgroundResource(lVar.iDZ, ((Integer) lVar.iDZ.getTag()).intValue());
                } else if (lVar.iDZ.getTag() instanceof String) {
                    if (lVar.iDZ.getTag().equals("BA_ZHU_BG")) {
                        layerDrawable = this.MV;
                    } else if (lVar.iDZ.getTag().equals("XIAO_BA_ZHU_BG")) {
                        layerDrawable = this.MW;
                    } else {
                        layerDrawable = lVar.iDZ.getTag().equals("HOST") ? this.iBu : null;
                    }
                    if (layerDrawable != null && layerDrawable.getDrawable(1) != null) {
                        if (lVar.mSkinType == 1) {
                            layerDrawable.getDrawable(1).setAlpha(255);
                        } else {
                            layerDrawable.getDrawable(1).setAlpha(0);
                        }
                        lVar.iDZ.setBackgroundDrawable(layerDrawable);
                    }
                }
                com.baidu.tbadk.core.util.am.setViewTextColor(lVar.iEa, R.color.cp_cont_d, 1);
                com.baidu.tbadk.core.util.am.setViewTextColor(lVar.iEb, (int) R.color.cp_cont_d);
                com.baidu.tbadk.core.util.am.setViewTextColor(lVar.iEc, (int) R.color.cp_cont_d);
                com.baidu.tbadk.core.util.am.setViewTextColor(lVar.iEl, R.color.cp_cont_d, 1);
                com.baidu.tbadk.core.util.am.setViewTextColor(lVar.iEd, R.color.cp_cont_d, 1);
                lVar.iEg.setTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_cont_b));
                com.baidu.tbadk.core.util.am.setBackgroundColor(lVar.iEi, R.color.cp_bg_line_g);
                com.baidu.tbadk.core.util.am.setViewTextColor(lVar.iEj, (int) R.color.cp_cont_c);
                lVar.iEj.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.am.getDrawable(R.drawable.icon_pb_comment_more_n), (Drawable) null);
                com.baidu.tbadk.core.util.am.setViewTextColor(lVar.iEk, (int) R.color.cp_cont_c);
                lVar.iEi.onChangeSkinType();
                lVar.iEh.onChangeSkinType();
                com.baidu.tbadk.core.util.am.setViewTextColor(lVar.iEu, R.color.cp_link_tip_c, 1);
                com.baidu.tbadk.core.util.am.setViewTextColor(lVar.iEs, R.color.cp_cont_f, 1);
                com.baidu.tbadk.core.util.am.setBackgroundResource(lVar.iEr, R.color.cp_bg_line_e);
                com.baidu.tbadk.core.util.am.setBackgroundResource(lVar.iEt, R.color.cp_cont_d);
                com.baidu.tbadk.core.util.am.setImageResource(lVar.iEv, R.drawable.icon_arrow_more_gray);
                com.baidu.tbadk.core.util.am.setViewTextColor(lVar.iEy, (int) R.color.cp_cont_c);
                if (lVar.iEw.getVisibility() == 8) {
                    lVar.iEy.setText(R.string.close_content);
                } else if (this.iCZ != null && StringUtils.isNull(this.iCZ.cja())) {
                    lVar.iEy.setText(this.iCZ.cja());
                } else {
                    lVar.iEy.setText(R.string.expand_content);
                }
                lVar.iEe.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
            lVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    private void b(l lVar) {
        lVar.iDY.setOnTouchListener(this.iDU);
        lVar.iDY.setOnLongClickListener(this.mOnLongClickListener);
        if (this.iEA.clM() != null && this.iEA.clM().getPageContext() != null && this.iEA.clM().getPageContext().getOrignalPage() != 0) {
            com.baidu.tieba.pb.pb.main.b.a aVar = this.iEA.clM().iCz;
            lVar.ftZ.setOnClickListener(aVar.gOU);
            lVar.iEf.setOnClickListener(aVar.gOU);
            lVar.iEn.setOnClickListener(aVar.gOU);
            lVar.iEn.getHeadView().setOnClickListener(aVar.gOU);
            lVar.iEg.setOnLongClickListener(this.mOnLongClickListener);
            lVar.iEg.setOnTouchListener(this.iDU);
            lVar.iEg.setCommonTextViewOnClickListener(this.ain);
            lVar.iEg.setOnImageClickListener(this.dIr);
            lVar.iEg.setOnImageTouchListener(this.iDU);
            lVar.iEg.setOnEmotionClickListener(aVar.iRj);
            lVar.iEg.setOnVoiceAfterClickListener(this.ain);
            lVar.iEq.setOnClickListener(this.ain);
            lVar.iEr.setOnClickListener(this.ain);
            lVar.iEj.setOnClickListener(this.ain);
            lVar.iEk.setOnClickListener(this.ain);
        }
    }

    private void nf() {
        this.MV = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.f.a.b.aEN().kk(0).ag(this.anq).b("TL_BR", R.color.ba_zhu_start, R.color.ba_zhu_end).aEP(), com.baidu.tbadk.core.util.f.a.b.aEN().kk(0).ag(this.anq).tw("#4D000000").aEP()});
        this.MW = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.f.a.b.aEN().kk(0).ag(this.anq).b("TL_BR", R.color.xiao_ba_zhu_start, R.color.xiao_ba_zhu_end).aEP(), com.baidu.tbadk.core.util.f.a.b.aEN().kk(0).ag(this.anq).tw("#4D000000").aEP()});
        this.iBu = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.f.a.b.aEN().kk(0).ag(this.anq).b("TL_BR", R.color.floor_host_start, R.color.floor_host_end).aEP(), com.baidu.tbadk.core.util.f.a.b.aEN().kk(0).ag(this.anq).tw("#4D000000").aEP()});
    }

    public void a(TbRichTextView.c cVar) {
        this.iDS = cVar;
    }

    public void setData(com.baidu.tieba.pb.data.f fVar) {
        this.iCZ = fVar;
    }

    public void dx(String str) {
        this.anD = str;
    }

    public void pt(boolean z) {
        this.iDa = z;
    }

    private SpannableStringBuilder cs(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new l.a(str, R.drawable.pic_smalldot_title));
            return com.baidu.tieba.card.l.a((Context) this.iEA.clM(), str2, (ArrayList<l.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    private void c(l lVar) {
        lVar.iEg.setTextViewOnTouchListener(this.dmA);
        lVar.iEg.setTextViewCheckSelection(false);
    }

    public void O(View.OnClickListener onClickListener) {
        this.iDj = onClickListener;
    }

    public void x(View.OnClickListener onClickListener) {
        this.ain = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.dIr = iVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.dmA = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }
}
