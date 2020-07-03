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
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.SvgManager;
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
import com.baidu.tieba.card.m;
import com.baidu.tieba.pb.a.c;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
/* loaded from: classes9.dex */
public class k extends m<PostData, l> implements View.OnClickListener {
    private View.OnClickListener aLl;
    private int aRW;
    private String aSp;
    private LayerDrawable ahK;
    private LayerDrawable ahL;
    private int ayd;
    private TbRichTextView.i eLw;
    private boolean eOG;
    private com.baidu.tieba.pb.a.c eor;
    private com.baidu.adp.lib.d.b<ConstrainImageLayout> hFi;
    private com.baidu.adp.lib.d.b<TbImageView> hFj;
    private int ifH;
    private int igf;
    private int kaL;
    private LayerDrawable kaM;
    private TbRichTextView.c kcZ;
    protected com.baidu.tieba.pb.data.e kck;
    private boolean kcl;
    private View.OnClickListener kcu;
    private com.baidu.tieba.pb.pb.sub.b kda;
    private boolean kdb;
    private boolean kdc;
    private com.baidu.tieba.pb.a.c kdd;
    private View.OnLongClickListener mOnLongClickListener;

    /* JADX INFO: Access modifiers changed from: private */
    public void cB(View view) {
        if (view != null && (view.getTag() instanceof l)) {
            l lVar = (l) view.getTag();
            if (lVar.kdp != null && lVar.kdp.getData() != null) {
                if (!this.kdb) {
                    com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
                    cVar.dHq = 5;
                    cVar.dHs = 2;
                    lVar.kdp.setStatisticData(cVar);
                }
                lVar.kdp.aXK();
            }
        }
    }

    public k(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId) {
        super(bVar, bdUniqueId);
        this.aRW = 0;
        this.ifH = 0;
        this.kaL = 0;
        this.igf = 0;
        this.kcZ = null;
        this.kcl = true;
        this.aSp = null;
        this.kck = null;
        this.kcu = null;
        this.aLl = null;
        this.eLw = null;
        this.eor = null;
        this.mOnLongClickListener = null;
        this.kda = null;
        this.eOG = true;
        this.kdb = com.baidu.tbadk.a.d.aNS();
        this.kdc = com.baidu.tbadk.a.d.aNR();
        this.hFi = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.pb.pb.main.k.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cay */
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
        this.hFj = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<TbImageView>() { // from class: com.baidu.tieba.pb.pb.main.k.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: aYG */
            public TbImageView makeObject() {
                TbImageView tbImageView = new TbImageView(k.this.mContext);
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(com.baidu.tbadk.core.util.an.getColor(R.color.common_color_10043));
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
        this.kdd = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.k.3
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean onDoubleTap(View view, MotionEvent motionEvent) {
                if (view != null && (k.this.kbv == null || k.this.kbv.cIU() == null || k.this.kbv.cIU().cLO())) {
                    if (view instanceof RelativeLayout) {
                        k.this.cB(view);
                    } else {
                        ViewParent parent = view.getParent();
                        int i = 0;
                        while (true) {
                            if (parent == null || i >= 10) {
                                break;
                            } else if (parent instanceof RelativeLayout) {
                                k.this.cB((RelativeLayout) parent);
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
                if (k.this.eor != null) {
                    if (!(view instanceof TbListTextView) || k.this.aLl == null) {
                        k.this.eor.T(view);
                        k.this.eor.onSingleTapConfirmed(motionEvent);
                        return true;
                    }
                    k.this.aLl.onClick(view);
                    return true;
                }
                return true;
            }
        });
        if (bVar != null && bVar.cIe() != null) {
            this.ayd = bVar.cIe().cKJ();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ce */
    public l b(ViewGroup viewGroup) {
        l lVar = new l(this.kdO.cJI().getPageContext(), LayoutInflater.from(this.mContext).inflate(R.layout.pb_reply_floor_item_layout, viewGroup, false), this.ayd, this.kdb);
        lVar.kdt.setConstrainLayoutPool(this.hFi);
        lVar.kdt.setImageViewPool(this.hFj);
        a(lVar);
        this.aRW = getDimensionPixelSize(R.dimen.tbds10);
        this.ifH = getDimensionPixelSize(R.dimen.tbds14);
        this.kaL = getDimensionPixelSize(R.dimen.tbds36);
        this.igf = getDimensionPixelSize(R.dimen.tbds6);
        if (lVar.kds != null) {
            lVar.kds.setDuiEnabled(this.eOG);
        }
        st();
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
            j(postData2);
            l(postData2);
            postData2.aTB();
            i(postData2);
            a(lVar, postData2, view, i);
        }
        return view;
    }

    public void setDuiEnabled(boolean z) {
        this.eOG = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private void i(PostData postData) {
        if (postData != null) {
            int i = 8;
            if (postData.lGH) {
                i = 2;
            }
            com.baidu.tbadk.core.util.ao b = com.baidu.tieba.pb.c.a.b(this.kck, postData, postData.locate, i, 6);
            postData.lGI = b;
            if (!com.baidu.tbadk.core.util.w.isEmpty(postData.dhV())) {
                Iterator<PostData> it = postData.dhV().iterator();
                while (it.hasNext()) {
                    it.next().lGI = b;
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
        if (lVar != null && lVar.kdj != null) {
            if (this.kdO != null && this.kdO.cIe() != null && this.kdO.cIe().cKR() && com.baidu.tbadk.core.util.ar.equals(this.kdO.cIe().cJY(), postData.getId())) {
                com.baidu.tbadk.core.util.an.setBackgroundColor(lVar.kdj, R.color.cp_other_g);
            } else {
                com.baidu.tbadk.core.util.an.setBackgroundColor(lVar.kdj, R.color.cp_bg_line_e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(l lVar, boolean z, String str) {
        if (z) {
            lVar.kdJ.setVisibility(8);
            if (StringUtils.isNull(str)) {
                lVar.kdL.setText(R.string.expand_content);
                return;
            } else {
                lVar.kdL.setText(str);
                return;
            }
        }
        lVar.kdJ.setVisibility(0);
        lVar.kdL.setText(R.string.close_content);
    }

    private void c(final l lVar, final PostData postData) {
        if (postData.dik() == 2 || postData.dik() == 4) {
            lVar.kdK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.k.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    boolean z = lVar.kdJ.getVisibility() == 8;
                    k.this.a(lVar, !z, postData.cGY());
                    postData.uG(z ? false : true);
                    k.this.d(lVar, postData);
                    if (k.this.kbv != null && k.this.kbv.cIU() != null && k.this.kbv.cIU().cMQ() != null && k.this.kbv.cIU().getListView() != null && !z && lVar.getView().getTop() < k.this.kbv.cIU().cMQ().getMeasuredHeight()) {
                        k.this.kbv.cIU().getListView().setSelectionFromTop(com.baidu.tbadk.core.util.w.getPosition(k.this.kbv.cIU().getListView().getData(), postData) + k.this.kbv.cIU().getListView().getHeaderViewsCount(), k.this.kbv.cIU().cMQ().getMeasuredHeight());
                    }
                }
            });
            lVar.kdK.setVisibility(0);
            a(lVar, postData.dhT(), postData.cGY());
            a(true, lVar, postData);
        } else {
            lVar.kdK.setVisibility(8);
            lVar.kdJ.setVisibility(0);
            a(false, lVar, postData);
        }
        d(lVar, postData);
    }

    private void a(boolean z, l lVar, PostData postData) {
        if (lVar != null && lVar.mBottomLine != null && lVar.kdK != null && (lVar.mBottomLine.getLayoutParams() instanceof RelativeLayout.LayoutParams) && (lVar.kdK.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            boolean z2 = !com.baidu.tbadk.core.util.w.isEmpty(postData.dhV());
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) lVar.mBottomLine.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) lVar.kdK.getLayoutParams();
            if (z) {
                lVar.kds.getLayoutStrategy().oG(0);
                if (z2) {
                    lVar.kds.getLayoutStrategy().oF(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
                    if (layoutParams2 != null) {
                        layoutParams2.topMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds26);
                    }
                } else {
                    lVar.kds.getLayoutStrategy().oF(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds8));
                    if (layoutParams2 != null) {
                        layoutParams2.topMargin = 0;
                    }
                }
                lVar.kdK.setLayoutParams(layoutParams2);
                if (layoutParams != null) {
                    layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44);
                    lVar.mBottomLine.setLayoutParams(layoutParams);
                    return;
                }
                return;
            }
            lVar.kds.getLayoutStrategy().oF(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
            lVar.kds.getLayoutStrategy().oG(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds12));
            if (layoutParams != null) {
                layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds38);
                lVar.mBottomLine.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(l lVar, PostData postData) {
        TbRichText dia = postData.dia();
        dia.isChanged = true;
        lVar.kds.setText(dia, true, this.kcZ);
    }

    private void j(PostData postData) {
        if (postData.dMR == 0 && postData.hHE) {
            com.baidu.tbadk.core.util.ao aoVar = new com.baidu.tbadk.core.util.ao("c12203");
            aoVar.dk("post_id", postData.getId());
            aoVar.dk("uid", TbadkCoreApplication.getCurrentAccount());
            aoVar.dk("cuid", TbadkCoreApplication.getInst().getCuid());
            aoVar.dk("cuid_galaxy2", TbadkCoreApplication.getInst().getCuidGalaxy2());
            aoVar.dk("c3_aid", TbadkCoreApplication.getInst().getCuidGalaxy3());
            aoVar.dk("cuid_gid", TbadkCoreApplication.getInst().getCuidGid());
            aoVar.s(TiebaInitialize.Params.EXPOSURE_TIME, System.currentTimeMillis());
            if (this.kdO != null) {
                int cKJ = this.kdO.cIe().cKJ();
                if (1 == cKJ || 2 == cKJ) {
                    aoVar.dk("obj_source", "1");
                } else if (3 == cKJ) {
                    aoVar.dk("obj_source", "2");
                } else {
                    aoVar.dk("obj_source", "0");
                }
            }
            TiebaStatic.log(aoVar);
            if (postData.aSp() != null && postData.aSp().getAlaInfo() != null && postData.aSp().getAlaInfo().live_status == 1) {
                k(postData);
            }
        }
    }

    private void k(PostData postData) {
        String userId = postData.aSp().getUserId();
        String forumId = this.kck != null ? this.kck.getForumId() : "";
        String forumName = this.kck != null ? this.kck.getForumName() : "";
        int dhY = postData.dhY();
        String id = postData.getId();
        com.baidu.tbadk.core.util.ao aoVar = new com.baidu.tbadk.core.util.ao("c13714");
        aoVar.dk("fid", forumId);
        aoVar.dk("fname", forumName);
        aoVar.dk("obj_param1", userId);
        aoVar.dk("uid", TbadkCoreApplication.getCurrentAccount());
        aoVar.dk("tid", id);
        aoVar.ag(TiebaInitialize.Params.OBJ_PARAM2, dhY);
        TiebaStatic.log(aoVar);
    }

    private void l(PostData postData) {
        if (this.kck != null) {
            if (this.kck.cHm()) {
                if (this.kdP != null) {
                    com.baidu.tieba.pb.c.a.a(this.kdP.getUniqueId(), this.kck, postData, postData.locate, postData.lGH ? 2 : 8);
                }
            } else if (this.kbv != null) {
                com.baidu.tieba.pb.c.a.a(this.kbv.getUniqueId(), this.kck, postData, postData.locate, postData.lGH ? 2 : 8);
            }
        }
    }

    private void a(l lVar, PostData postData) {
        if (postData == null || postData.cOE() == null) {
            lVar.kdD.setVisibility(8);
            return;
        }
        TbRichText dia = postData.dia();
        com.baidu.tieba.pb.view.b.a(postData.cOE(), lVar.kdD, false, false, dia != null && StringUtils.isNull(dia.toString()) && StringUtils.isNull(postData.getBimg_url()));
    }

    private void e(l lVar, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.kcl) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) lVar.kds.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            lVar.kds.setLayoutParams(layoutParams);
            lVar.kds.setPadding(0, 0, 0, 0);
            lVar.kds.zx(null);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) lVar.kds.getLayoutParams();
            layoutParams2.topMargin = getDimensionPixelSize(R.dimen.ds20);
            layoutParams2.bottomMargin = getDimensionPixelSize(R.dimen.ds20);
            lVar.kds.setLayoutParams(layoutParams2);
            lVar.kds.zx(postData.getBimg_url());
        }
        lVar.kds.setTextViewOnTouchListener(this.kdd);
        lVar.kds.setTextViewCheckSelection(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:184:0x0516  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0522  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x053d  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0548  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x054c  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x0599  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x0606  */
    /* JADX WARN: Removed duplicated region for block: B:299:0x0978  */
    /* JADX WARN: Removed duplicated region for block: B:300:0x0985  */
    /* JADX WARN: Removed duplicated region for block: B:301:0x0992  */
    /* JADX WARN: Removed duplicated region for block: B:302:0x099f  */
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
            if (postData.aSp() == null || postData.aSp().isBaijiahaoUser()) {
            }
            if (postData.lGy) {
                com.baidu.tbadk.core.util.an.setBackgroundColor(lVar.mTopLine, R.color.cp_bg_line_c);
                lVar.mTopLine.setVisibility(0);
            } else {
                lVar.mTopLine.setVisibility(8);
            }
            lVar.kdr.setTag(null);
            lVar.kdr.setUserId(null);
            lVar.gDT.setText((CharSequence) null);
            lVar.kdA.getHeadView().setUserId(null);
            lVar.kds.setIsHost(false);
            if (postData.aSp() != null) {
                if (this.aSp != null && !this.aSp.equals("0") && this.aSp.equals(postData.aSp().getUserId())) {
                    lVar.kds.setIsHost(true);
                }
                ArrayList<IconData> iconInfo = postData.aSp().getIconInfo();
                ArrayList<IconData> tShowInfoNew = postData.aSp().getTShowInfoNew();
                if (lVar.kdC != null) {
                    lVar.kdC.setTag(R.id.tag_user_id, postData.aSp().getUserId());
                    if (this.kdO != null && this.kdO.cJI() != null) {
                        lVar.kdC.setOnClickListener(this.kdO.cJI().kbH.kqZ);
                    }
                    lVar.kdC.a(iconInfo, 2, this.kaL, this.kaL, this.aRW);
                }
                if (lVar.kdB != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        lVar.kdB.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    if (this.kdO != null && this.kdO.cJI() != null) {
                        lVar.kdB.setOnClickListener(this.kdO.cJI().kbH.kra);
                    }
                    lVar.kdB.a(tShowInfoNew, 3, this.kaL, this.kaL, this.aRW, true);
                }
                if (!com.baidu.tbadk.core.util.w.isEmpty(tShowInfoNew) || postData.aSp().isBigV()) {
                    com.baidu.tbadk.core.util.an.setViewTextColor(lVar.gDT, R.color.cp_cont_h, 1);
                } else {
                    com.baidu.tbadk.core.util.an.setViewTextColor(lVar.gDT, R.color.cp_cont_b, 1);
                }
                String avater = postData.aSp().getAvater();
                int i2 = 8;
                if (postData.lGH) {
                    i2 = 2;
                }
                lVar.gDT.setTag(R.id.tag_user_id, postData.aSp().getUserId());
                lVar.gDT.setTag(R.id.tag_user_name, postData.aSp().getUserName());
                lVar.gDT.setTag(R.id.tag_virtual_user_url, postData.aSp().getVirtualUserUrl());
                lVar.gDT.setTag(R.id.tag_statistic_item, com.baidu.tieba.pb.c.a.b(this.kck, postData, postData.locate, i2, 2));
                String name_show = postData.aSp().getName_show();
                String userName = postData.aSp().getUserName();
                if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                    lVar.gDT.setText(com.baidu.tieba.pb.c.aK(this.mContext, lVar.gDT.getText().toString()));
                    lVar.gDT.setGravity(16);
                    lVar.gDT.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.cGx());
                    com.baidu.tbadk.core.util.an.setViewTextColor(lVar.gDT, R.color.cp_other_f, 1);
                }
                if (postData.aSp().getPendantData() != null && !StringUtils.isNull(postData.aSp().getPendantData().aQl())) {
                    lVar.kdA.setBigVDimenSize(R.dimen.tbds32);
                    lVar.kdA.a(postData.aSp(), 4);
                    lVar.kdr.setVisibility(8);
                    lVar.kdA.setVisibility(0);
                    lVar.kdA.getHeadView().startLoad(avater, 28, false);
                    lVar.kdA.getHeadView().setUserId(postData.aSp().getUserId());
                    lVar.kdA.getHeadView().setUserName(postData.aSp().getUserName());
                    lVar.kdA.getHeadView().setFid(this.kck != null ? this.kck.getForumId() : "");
                    lVar.kdA.getHeadView().setFName(this.kck != null ? this.kck.getForumName() : "");
                    lVar.kdA.getHeadView().setFloor(postData.dhY());
                    lVar.kdA.getHeadView().setTid(postData.getId());
                    lVar.kdA.getHeadView().setTag(R.id.tag_statistic_item, com.baidu.tieba.pb.c.a.b(this.kck, postData, postData.locate, i2, 2));
                    lVar.kdA.xg(postData.aSp().getPendantData().aQl());
                } else {
                    lVar.kdr.setGodIconWidth(R.dimen.tbds32);
                    UtilHelper.showHeadImageViewBigV(lVar.kdr, postData.aSp(), 4);
                    lVar.kdr.setUserId(postData.aSp().getUserId());
                    lVar.kdr.setFid(this.kck != null ? this.kck.getForumId() : "");
                    lVar.kdr.setFName(this.kck != null ? this.kck.getForumName() : "");
                    lVar.kdr.setFloor(postData.dhY());
                    lVar.kdr.setTid(postData.getId());
                    lVar.kdr.setUserName(postData.aSp().getUserName(), postData.dii());
                    lVar.kdr.setTag(R.id.tag_virtual_user_url, postData.aSp().getVirtualUserUrl());
                    lVar.kdr.setTag(R.id.tag_statistic_item, com.baidu.tieba.pb.c.a.b(this.kck, postData, postData.locate, i2, 2));
                    lVar.kdr.setImageDrawable(null);
                    lVar.kdr.startLoad(avater, 28, false);
                    lVar.kdr.setVisibility(0);
                    lVar.kdA.setVisibility(8);
                }
                if (postData.aSp() != null && postData.aSp().getAlaInfo() != null && postData.aSp().getAlaUserData() != null && postData.aSp().getAlaUserData().live_status == 1) {
                    lVar.qg(true);
                    lVar.kdr.setLiveStatus(1);
                    lVar.kdr.setAlaInfo(postData.aSp().getAlaInfo());
                    lVar.kdA.getHeadView().setLiveStatus(1);
                    lVar.kdA.getHeadView().setAlaInfo(postData.aSp().getAlaInfo());
                } else {
                    lVar.qg(false);
                    lVar.kdr.setLiveStatus(0);
                    lVar.kdr.setAlaInfo(null);
                    lVar.kdA.getHeadView().setLiveStatus(0);
                    lVar.kdA.getHeadView().setAlaInfo(null);
                }
                if (this.kck != null && this.kck.cHp()) {
                    lVar.kdk.setVisibility(8);
                    lVar.kdk.setTag(null);
                } else if (postData.aSp() != null) {
                    MetaData aSp = postData.aSp();
                    com.baidu.tbadk.core.util.an.setViewTextColor(lVar.kdk, (int) R.color.cp_cont_a);
                    if (this.aSp != null && !this.aSp.equals("0") && this.aSp.equals(aSp.getUserId())) {
                        lVar.kdk.setTag("HOST");
                        if (lVar.mSkinType == 1) {
                            if (this.kaM.getDrawable(1) != null) {
                                this.kaM.getDrawable(1).setAlpha(255);
                            }
                        } else if (this.kaM.getDrawable(1) != null) {
                            this.kaM.getDrawable(1).setAlpha(0);
                        }
                        lVar.kdk.setBackgroundDrawable(this.kaM);
                        lVar.kdk.setVisibility(0);
                        lVar.kdk.setText(R.string.host_name);
                    } else if (aSp.getIs_bawu() == 1 && postData.dhQ()) {
                        com.baidu.tbadk.core.util.an.setBackgroundResource(lVar.kdk, R.drawable.brand_official_btn);
                        lVar.kdk.setTag(Integer.valueOf((int) R.drawable.brand_official_btn));
                        lVar.kdk.setVisibility(0);
                        lVar.kdk.setText(R.string.brand_Official);
                    } else if (aSp.getIs_bawu() == 1 && Config.BAWU_TYPE_MANAGER.equals(aSp.getBawu_type())) {
                        lVar.kdk.setTag("BA_ZHU_BG");
                        if (lVar.mSkinType == 1) {
                            if (this.ahK.getDrawable(1) != null) {
                                this.ahK.getDrawable(1).setAlpha(255);
                            }
                        } else if (this.ahK.getDrawable(1) != null) {
                            this.ahK.getDrawable(1).setAlpha(0);
                        }
                        lVar.kdk.setBackgroundDrawable(this.ahK);
                        lVar.kdk.setVisibility(0);
                        lVar.kdk.setText(R.string.bawu_member_bazhu_tip);
                    } else if (aSp.getIs_bawu() == 1 && Config.BAWU_TYPE_ASSIST.equals(aSp.getBawu_type())) {
                        lVar.kdk.setTag("XIAO_BA_ZHU_BG");
                        if (lVar.mSkinType == 1) {
                            if (this.ahL.getDrawable(1) != null) {
                                this.ahL.getDrawable(1).setAlpha(255);
                            }
                        } else if (this.ahL.getDrawable(1) != null) {
                            this.ahL.getDrawable(1).setAlpha(0);
                        }
                        lVar.kdk.setBackgroundDrawable(this.ahL);
                        lVar.kdk.setVisibility(0);
                        lVar.kdk.setText(R.string.bawu_member_xbazhu_tip);
                    } else if (aSp.getIs_bawu() == 1 && "pri_content_assist".equals(aSp.getBawu_type())) {
                        int lr = com.baidu.tbadk.core.util.an.lr(R.drawable.bg_user_identity_btn);
                        com.baidu.tbadk.core.util.an.setBackgroundResource(lVar.kdk, lr);
                        lVar.kdk.setTag(Integer.valueOf(lr));
                        lVar.kdk.setVisibility(0);
                        lVar.kdk.setText(R.string.bawu_content_assist_tip);
                    } else if (aSp.getIs_bawu() == 1 && "pri_manage_assist".equals(aSp.getBawu_type())) {
                        int lr2 = com.baidu.tbadk.core.util.an.lr(R.drawable.bg_user_identity_btn);
                        com.baidu.tbadk.core.util.an.setBackgroundResource(lVar.kdk, lr2);
                        lVar.kdk.setTag(Integer.valueOf(lr2));
                        lVar.kdk.setVisibility(0);
                        lVar.kdk.setText(R.string.bawu_manage_assist_tip);
                    } else {
                        lVar.kdk.setVisibility(8);
                        lVar.kdk.setTag(null);
                    }
                } else {
                    lVar.kdk.setVisibility(8);
                    lVar.kdk.setTag(null);
                }
            }
            int i3 = 0;
            if (this.kdO != null && this.kdO.cJI() != null && this.kdO.cJI().cHU() && postData.aSp() != null) {
                i3 = postData.aSp().getLevel_id();
            }
            if (this.kck != null && this.kck.cHp()) {
                i3 = 0;
            }
            if (i3 > 0) {
                lVar.kdz.setVisibility(0);
                com.baidu.tbadk.core.util.an.setImageResource(lVar.kdz, BitmapHelper.getGradeResourceIdInEnterForum(i3));
            } else {
                lVar.kdz.setVisibility(8);
            }
            int i4 = 15;
            if (lVar.kdC.getChildCount() == 1) {
                i4 = 13;
            } else if (lVar.kdC.getChildCount() > 1) {
                i4 = 11;
            }
            if (lVar.kdk.getVisibility() == 0) {
                i4 -= 2;
            }
            if (lVar.kdB.getChildCount() > 0) {
                i4 -= 2;
            }
            if (postData.aTO() > 1000) {
                i4 -= 2;
            }
            if (postData.aTO() > 10) {
                i4 -= 2;
            }
            if (i4 < 10) {
                lVar.kdC.setVisibility(8);
                if (lVar.kdC.getChildCount() == 1) {
                    i4 += 2;
                } else if (lVar.kdC.getChildCount() > 1) {
                    i4 += 4;
                }
                if (i4 < 10 && lVar.kdk.getVisibility() == 0) {
                    i4 += 2;
                    lVar.kdk.setVisibility(8);
                }
                if (i4 < 10 && lVar.kdz.getVisibility() == 0) {
                    i4 += 2;
                    lVar.kdz.setVisibility(8);
                }
            }
            String name_show2 = postData.aSp() != null ? postData.aSp().getName_show() : "";
            int textLengthWithEmoji = com.baidu.tbadk.util.ae.getTextLengthWithEmoji(name_show2);
            if (postData.aSp() != null && !StringUtils.isNull(postData.aSp().getSealPrefix())) {
                if (textLengthWithEmoji > i4 - 2) {
                    name_show2 = com.baidu.tbadk.util.ae.subStringWithEmoji(name_show2, i4 - 2) + StringHelper.STRING_MORE;
                }
            } else if (textLengthWithEmoji > i4) {
                name_show2 = com.baidu.tbadk.util.ae.subStringWithEmoji(name_show2, i4) + StringHelper.STRING_MORE;
            }
            if (postData.aSp() != null && !StringUtils.isNull(postData.aSp().getSealPrefix())) {
                lVar.gDT.setText(dn(postData.aSp().getSealPrefix(), name_show2));
            } else {
                lVar.gDT.setText(name_show2);
            }
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_load_sub_data, postData);
            sparseArray.put(R.id.tag_load_sub_view, view);
            sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(postData.dhY()));
            sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
            boolean z9 = false;
            if (postData.aSp() != null && !StringUtils.isNull(postData.aSp().getVirtualUserUrl())) {
                z9 = true;
            }
            boolean z10 = false;
            boolean z11 = false;
            boolean z12 = false;
            if (this.kck != null && this.kck.cHc() != 0) {
                if (this.kck.cHc() != 1002 && this.kck.cHc() != 3) {
                    z10 = true;
                }
                if (this.kck.cHc() != 3 && !this.kck.cHp()) {
                    z11 = true;
                }
                if (postData != null && postData.aSp() != null) {
                    String userId2 = postData.aSp().getUserId();
                    if (UtilHelper.isCurrentAccount(userId2)) {
                        z10 = false;
                    }
                    if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                        boolean z13 = z11;
                        z = false;
                        z2 = z13;
                        if (this.kck != null && this.kck.cGN() != null && this.kck.cGN().aSp() != null && postData.aSp() != null) {
                            userId = this.kck.cGN().aSp().getUserId();
                            String userId3 = postData.aSp().getUserId();
                            if (UtilHelper.isCurrentAccount(userId)) {
                                z3 = true;
                                z4 = true;
                                if (UtilHelper.isCurrentAccount(userId3)) {
                                    z4 = false;
                                    z12 = true;
                                }
                                if (postData == null && postData.aSp() != null && UtilHelper.isCurrentAccount(postData.aSp().getUserId())) {
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
                                if (postData.dhY() == 1) {
                                    i5 = 0;
                                }
                                if (z) {
                                    sparseArray.put(R.id.tag_should_manage_visible, true);
                                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.kck.cHc()));
                                    if (postData.aSp() != null) {
                                        sparseArray.put(R.id.tag_forbid_user_name, postData.aSp().getUserName());
                                        sparseArray.put(R.id.tag_forbid_user_name_show, postData.aSp().getName_show());
                                        sparseArray.put(R.id.tag_forbid_user_portrait, postData.aSp().getPortrait());
                                    }
                                } else {
                                    sparseArray.put(R.id.tag_should_manage_visible, false);
                                }
                                if (z7) {
                                    sparseArray.put(R.id.tag_user_mute_visible, true);
                                    sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                                    if (postData.aSp() != null) {
                                        sparseArray.put(R.id.tag_user_mute_mute_userid, postData.aSp().getUserId());
                                        sparseArray.put(R.id.tag_user_mute_mute_username, postData.aSp().getUserName());
                                        sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.aSp().getName_show());
                                    }
                                    if (this.kck.cGN() != null) {
                                        sparseArray.put(R.id.tag_user_mute_thread_id, this.kck.cGN().getId());
                                    }
                                    sparseArray.put(R.id.tag_user_mute_post_id, postData.getId());
                                } else {
                                    sparseArray.put(R.id.tag_user_mute_visible, false);
                                }
                                if (z8) {
                                    sparseArray.put(R.id.tag_should_delete_visible, true);
                                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.kck.cHc()));
                                    sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z6));
                                    sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i5));
                                    sparseArray.put(R.id.tag_del_post_id, postData.getId());
                                } else {
                                    sparseArray.put(R.id.tag_should_delete_visible, false);
                                }
                                lVar.kds.setTag(sparseArray);
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
                        if (postData.dhY() == 1) {
                        }
                        if (z) {
                        }
                        if (z7) {
                        }
                        if (z8) {
                        }
                        lVar.kds.setTag(sparseArray);
                    }
                }
            }
            boolean z15 = z11;
            z = z10;
            z2 = z15;
            if (this.kck != null) {
                userId = this.kck.cGN().aSp().getUserId();
                String userId32 = postData.aSp().getUserId();
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
            if (postData.dhY() == 1) {
            }
            if (z) {
            }
            if (z7) {
            }
            if (z8) {
            }
            lVar.kds.setTag(sparseArray);
        }
    }

    private void f(l lVar, PostData postData) {
        if (lVar != null && postData != null && postData.aUg() != null) {
            postData.aUg().threadId = this.kdO.cIe().cJZ();
            postData.aUg().objType = 1;
            postData.aUg().isInPost = true;
            bu buVar = null;
            if (this.kck != null && this.kck.cGN() != null) {
                buVar = this.kck.cGN();
            }
            if (buVar != null && buVar.aQZ()) {
                lVar.kdp.setAgreeAlone(true);
            }
            lVar.kdp.setThreadData(buVar);
            lVar.kdp.setData(postData.aUg());
        }
    }

    private void g(l lVar, PostData postData) {
        boolean z;
        int i;
        int i2;
        if (lVar != null && postData != null) {
            if (postData.dhY() > 0 && this.kck != null && !this.kck.cHp()) {
                String format = String.format(this.mContext.getString(R.string.is_floor), Integer.valueOf(postData.dhY()));
                lVar.kdy.setVisibility(0);
                lVar.kdy.setText(format);
                z = true;
            } else {
                lVar.kdy.setVisibility(8);
                z = false;
            }
            com.baidu.tbadk.data.f dib = postData.dib();
            boolean z2 = (dib == null || StringUtils.isNull(dib.getName()) || this.kck == null || this.kck.cHp()) ? false : true;
            if (z) {
                lVar.kdm.setVisibility(0);
                i = this.ifH;
            } else {
                lVar.kdm.setVisibility(8);
                i = 0;
            }
            if (z2) {
                lVar.kdn.setVisibility(0);
                i2 = this.ifH;
            } else {
                lVar.kdn.setVisibility(8);
                i2 = 0;
            }
            lVar.kdl.setPadding(i, 0, i2, 0);
            if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                lVar.kdl.setText(com.baidu.tbadk.core.util.ar.getFormatTimeShort(postData.getTime()));
            } else {
                lVar.kdl.setText(com.baidu.tbadk.core.util.ar.getFormatTime(postData.getTime()));
            }
            if (z2) {
                lVar.kdo.setVisibility(0);
                lVar.kdo.setPadding(this.ifH, 0, 0, 0);
                if (postData.lGG) {
                    lVar.kdo.setText(com.baidu.tbadk.core.util.ar.cutStringWithSuffix(dib.getName(), 7, StringHelper.STRING_MORE));
                    return;
                } else {
                    lVar.kdo.setText(dib.getName());
                    return;
                }
            }
            lVar.kdo.setVisibility(8);
        }
    }

    private void a(l lVar, PostData postData, View view) {
        if (lVar != null && postData != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) lVar.kds.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44);
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds166);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            lVar.kds.setPadding(0, 0, 0, 0);
            if (!this.kcl) {
                lVar.kds.getLayoutStrategy().oA(R.drawable.icon_click);
            } else {
                lVar.kds.zx(null);
                lVar.kds.setBackgroundDrawable(null);
                lVar.kds.getLayoutStrategy().oA(R.drawable.transparent_bg);
            }
            lVar.kds.getLayoutStrategy().ox(R.drawable.pic_video);
            a(lVar.kds, view, !StringUtils.isNull(postData.getBimg_url()));
            lVar.kds.setLayoutParams(layoutParams);
            lVar.kds.setLinkTextColor(com.baidu.tbadk.core.util.an.getColor(R.color.cp_link_tip_c));
            lVar.kds.setIsFromCDN(this.mIsFromCDN);
            lVar.kds.setText(postData.dia(), true, this.kcZ);
            SparseArray sparseArray = (SparseArray) lVar.kds.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, false);
            lVar.kds.setTag(sparseArray);
            lVar.kdj.setTag(R.id.tag_from, sparseArray);
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
            tbRichTextView.getLayoutStrategy().oy(equipmentWidth - dimensionPixelSize);
            tbRichTextView.getLayoutStrategy().eNz = (equipmentWidth - dimensionPixelSize) - getDimensionPixelSize(R.dimen.tbds122);
            tbRichTextView.getLayoutStrategy().oz((int) (equipmentWidth * 1.618f));
        }
    }

    private void c(l lVar, PostData postData, View view, int i) {
        if (lVar != null && postData != null) {
            if (postData.dic() > 0) {
                lVar.kdw.setVisibility(8);
            } else {
                SparseArray sparseArray = (SparseArray) lVar.kdw.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    lVar.kdw.setTag(sparseArray);
                }
                sparseArray.put(R.id.tag_load_sub_data, postData);
                if (postData.dik() == 2) {
                    lVar.kdw.setVisibility(8);
                } else {
                    lVar.kdw.setVisibility(0);
                }
                lVar.kdv.setVisibility(8);
            }
            if (this.kdb) {
                if (lVar.kdx != null) {
                    SparseArray sparseArray2 = (SparseArray) lVar.kdx.getTag();
                    if (sparseArray2 == null) {
                        sparseArray2 = new SparseArray();
                        lVar.kdx.setTag(sparseArray2);
                    }
                    sparseArray2.put(R.id.tag_load_sub_data, postData);
                }
                if (lVar.iyL != null) {
                    SparseArray sparseArray3 = (SparseArray) lVar.iyL.getTag();
                    if (sparseArray3 == null) {
                        sparseArray3 = new SparseArray();
                        lVar.iyL.setTag(sparseArray3);
                    }
                    sparseArray3.put(R.id.tag_load_sub_data, postData);
                }
            }
            if (postData.dic() > 0) {
                lVar.kdv.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.sub_pb_load_more, Integer.valueOf(postData.dic())));
                SparseArray sparseArray4 = (SparseArray) lVar.kdv.getTag();
                if (sparseArray4 == null) {
                    sparseArray4 = new SparseArray();
                    lVar.kdv.setTag(sparseArray4);
                }
                sparseArray4.put(R.id.tag_load_sub_data, postData);
                lVar.kdv.setVisibility(0);
                lVar.kdw.setVisibility(8);
                lVar.kdu.setVisibility(8);
            } else {
                lVar.kdv.setVisibility(8);
                if (postData.dic() > 0 && postData.dhV() != null && postData.dhV().size() > 0) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) lVar.kdu.getLayoutParams();
                    layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds10);
                    layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds166);
                    layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44);
                    layoutParams.bottomMargin = 0;
                    lVar.kdu.setLayoutParams(layoutParams);
                    if (this.kda == null) {
                        this.kda = new com.baidu.tieba.pb.pb.sub.b(this.mContext);
                        this.kda.setIsFromCDN(this.mIsFromCDN);
                        this.kda.setOnLongClickListener(this.mOnLongClickListener);
                        this.kda.U(this.kcu);
                        this.kda.z(this.aLl);
                        String str = null;
                        if (this.kck != null && this.kck.cGN() != null && this.kck.cGN().aSp() != null) {
                            str = this.kck.cGN().aSp().getUserId();
                        }
                        boolean z = str != null && str.equals(TbadkCoreApplication.getCurrentAccount());
                        if (this.kck != null) {
                            this.kda.ab(this.kck.cHc(), z);
                            this.kda.setThreadData(this.kck.cGN());
                        }
                    }
                    this.kda.Kr(postData.getId());
                    lVar.kdu.setSubPbAdapter(this.kda);
                    lVar.kdu.setVisibility(0);
                    lVar.kdu.setData(postData, view);
                    lVar.kdu.setChildOnClickListener(this.aLl);
                    lVar.kdu.setChildOnLongClickListener(this.mOnLongClickListener);
                    lVar.kdu.setChildOnTouchListener(this.kdd);
                } else {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) lVar.kdu.getLayoutParams();
                    layoutParams2.topMargin = 0;
                    layoutParams2.leftMargin = 0;
                    layoutParams2.rightMargin = 0;
                    layoutParams2.bottomMargin = 0;
                    lVar.kdu.setLayoutParams(layoutParams2);
                    lVar.kdu.setVisibility(8);
                }
            }
            if (postData.lGw) {
                lVar.mBottomLine.setVisibility(0);
            } else {
                lVar.mBottomLine.setVisibility(4);
            }
        }
    }

    private void h(l lVar, PostData postData) {
        if (lVar != null && lVar.kdH != null && lVar.kdE != null) {
            if (postData == null || postData.lGA == null || StringUtils.isNull(postData.lGA.liveTitle)) {
                lVar.kdE.setVisibility(8);
                return;
            }
            lVar.kdH.setText(postData.lGA.liveTitle);
            lVar.kdE.setTag(postData.lGA);
            lVar.kdE.setVisibility(0);
            com.baidu.tbadk.core.util.ao aoVar = new com.baidu.tbadk.core.util.ao("c12639");
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                aoVar.dk("uid", TbadkCoreApplication.getCurrentAccount());
            }
            TiebaStatic.log(aoVar);
        }
    }

    private void i(l lVar, PostData postData) {
        if (lVar != null && postData != null) {
            lVar.kdM.setVisibility((!postData.lGG || this.kdc) ? 8 : 0);
        }
    }

    private void a(l lVar) {
        LayerDrawable layerDrawable;
        if (lVar != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (lVar.mSkinType != skinType) {
                com.baidu.tbadk.core.util.an.setViewTextColor(lVar.gDT, R.color.cp_cont_b, 1);
                if (lVar.kdk.getTag() instanceof Integer) {
                    com.baidu.tbadk.core.util.an.setBackgroundResource(lVar.kdk, ((Integer) lVar.kdk.getTag()).intValue());
                } else if (lVar.kdk.getTag() instanceof String) {
                    if (lVar.kdk.getTag().equals("BA_ZHU_BG")) {
                        layerDrawable = this.ahK;
                    } else if (lVar.kdk.getTag().equals("XIAO_BA_ZHU_BG")) {
                        layerDrawable = this.ahL;
                    } else {
                        layerDrawable = lVar.kdk.getTag().equals("HOST") ? this.kaM : null;
                    }
                    if (layerDrawable != null && layerDrawable.getDrawable(1) != null) {
                        if (lVar.mSkinType == 1) {
                            layerDrawable.getDrawable(1).setAlpha(255);
                        } else {
                            layerDrawable.getDrawable(1).setAlpha(0);
                        }
                        lVar.kdk.setBackgroundDrawable(layerDrawable);
                    }
                }
                com.baidu.tbadk.core.util.an.setViewTextColor(lVar.kdl, R.color.cp_cont_d, 1);
                com.baidu.tbadk.core.util.an.setViewTextColor(lVar.kdm, (int) R.color.cp_cont_d);
                com.baidu.tbadk.core.util.an.setViewTextColor(lVar.kdn, (int) R.color.cp_cont_d);
                com.baidu.tbadk.core.util.an.setViewTextColor(lVar.kdy, R.color.cp_cont_d, 1);
                com.baidu.tbadk.core.util.an.setViewTextColor(lVar.kdo, R.color.cp_cont_d, 1);
                lVar.kds.setTextColor(com.baidu.tbadk.core.util.an.getColor(R.color.cp_cont_b));
                com.baidu.tbadk.core.util.an.setBackgroundColor(lVar.kdu, R.color.cp_bg_line_g);
                com.baidu.tbadk.core.util.an.setViewTextColor(lVar.kdv, (int) R.color.cp_cont_c);
                lVar.kdv.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.an.getDrawable(R.drawable.icon_pb_comment_more_n), (Drawable) null);
                com.baidu.tbadk.core.util.an.setViewTextColor(lVar.kdw, (int) R.color.cp_cont_c);
                if (this.kdb) {
                    SvgManager.aWQ().a(lVar.kdx, R.drawable.icon_pure_pb_reply26_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    SvgManager.aWQ().a(lVar.iyL, R.drawable.icon_pure_pb_share26_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                }
                lVar.kdu.onChangeSkinType();
                lVar.kdt.onChangeSkinType();
                com.baidu.tbadk.core.util.an.setViewTextColor(lVar.kdH, R.color.cp_link_tip_c, 1);
                com.baidu.tbadk.core.util.an.setViewTextColor(lVar.kdF, R.color.cp_cont_f, 1);
                com.baidu.tbadk.core.util.an.setBackgroundResource(lVar.kdE, R.color.cp_bg_line_e);
                com.baidu.tbadk.core.util.an.setBackgroundResource(lVar.kdG, R.color.cp_cont_d);
                com.baidu.tbadk.core.util.an.setImageResource(lVar.kdI, R.drawable.icon_arrow_more_gray);
                com.baidu.tbadk.core.util.an.setViewTextColor(lVar.kdL, (int) R.color.cp_cont_c);
                if (lVar.kdJ.getVisibility() == 8) {
                    lVar.kdL.setText(R.string.close_content);
                } else if (this.kck != null && StringUtils.isNull(this.kck.cGY())) {
                    lVar.kdL.setText(this.kck.cGY());
                } else {
                    lVar.kdL.setText(R.string.expand_content);
                }
                lVar.kdp.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                lVar.zk(skinType);
            }
            lVar.mSkinType = skinType;
        }
    }

    private void b(final l lVar) {
        lVar.kdj.setOnTouchListener(this.kdd);
        lVar.kdj.setOnLongClickListener(this.mOnLongClickListener);
        if (this.kdO.cJI() != null && this.kdO.cJI().getPageContext() != null && this.kdO.cJI().getPageContext().getOrignalPage() != 0) {
            com.baidu.tieba.pb.pb.main.b.a aVar = this.kdO.cJI().kbH;
            lVar.gDT.setOnClickListener(aVar.hjK);
            lVar.kdr.setOnClickListener(aVar.hjK);
            lVar.kdA.setOnClickListener(aVar.hjK);
            lVar.kdA.getHeadView().setOnClickListener(aVar.hjK);
            lVar.kds.setOnLongClickListener(this.mOnLongClickListener);
            lVar.kds.setOnTouchListener(this.kdd);
            lVar.kds.setCommonTextViewOnClickListener(this.aLl);
            lVar.kds.setOnImageClickListener(this.eLw);
            lVar.kds.setOnImageTouchListener(this.kdd);
            lVar.kds.setOnEmotionClickListener(aVar.krb);
            lVar.kds.setOnVoiceAfterClickListener(this.aLl);
            lVar.kdD.setOnClickListener(this.aLl);
            lVar.kdE.setOnClickListener(this.aLl);
            lVar.kdv.setOnClickListener(this.aLl);
            lVar.kdw.setOnClickListener(this.aLl);
            final com.baidu.tieba.pb.pb.main.b.c cVar = this.kdO.cJI().kbI;
            if (this.kdb) {
                lVar.kdx.setOnClickListener(this.aLl);
                lVar.iyL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.k.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        final PostData postData;
                        if (view.getTag() instanceof SparseArray) {
                            SparseArray sparseArray = (SparseArray) view.getTag();
                            if ((sparseArray.get(R.id.tag_load_sub_data) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.tag_load_sub_data)) != null && lVar.kdj != null && cVar != null) {
                                com.baidu.adp.lib.f.e.lt().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.k.5.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        cVar.krq.a(k.this.kck, null, postData, lVar.kdj);
                                    }
                                }, 100L);
                                String threadId = k.this.kck.getThreadId();
                                if ((StringUtils.isNull(threadId) || "0".equals(k.this.kck.getThreadId())) && k.this.kck.cGN() != null) {
                                    threadId = k.this.kck.cGN().getNid();
                                }
                                TiebaStatic.log(new com.baidu.tbadk.core.util.ao("c13700").dk("tid", threadId).dk("fid", k.this.kck.getForumId()).s("uid", TbadkCoreApplication.getCurrentAccountId()).dk("post_id", postData.getId()).ag("obj_type", 4));
                            }
                        }
                    }
                });
                lVar.kdp.dYx = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.k.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (view != null && k.this.kck != null && lVar != null && lVar.kdp != null && lVar.kdp.getData() != null) {
                            int i = view == lVar.kdp.getImgAgree() ? 1 : 2;
                            String threadId = k.this.kck.getThreadId();
                            if ((StringUtils.isNull(threadId) || "0".equals(k.this.kck.getThreadId())) && k.this.kck.cGN() != null) {
                                threadId = k.this.kck.cGN().getNid();
                            }
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ao("c13700").dk("tid", threadId).dk("fid", k.this.kck.getForumId()).s("uid", TbadkCoreApplication.getCurrentAccountId()).dk("post_id", lVar.kdp.getData().postId).ag("obj_type", i));
                        }
                    }
                };
            }
        }
    }

    private void st() {
        this.ahK = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.e.a.c.aXu().lG(0).Q(this.igf).b("TL_BR", R.color.ba_zhu_start, R.color.ba_zhu_end).aXw(), com.baidu.tbadk.core.util.e.a.c.aXu().lG(0).Q(this.igf).xa("#4D000000").aXw()});
        this.ahL = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.e.a.c.aXu().lG(0).Q(this.igf).b("TL_BR", R.color.xiao_ba_zhu_start, R.color.xiao_ba_zhu_end).aXw(), com.baidu.tbadk.core.util.e.a.c.aXu().lG(0).Q(this.igf).xa("#4D000000").aXw()});
        this.kaM = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.e.a.c.aXu().lG(0).Q(this.igf).b("TL_BR", R.color.floor_host_start, R.color.floor_host_end).aXw(), com.baidu.tbadk.core.util.e.a.c.aXu().lG(0).Q(this.igf).xa("#4D000000").aXw()});
    }

    public void a(TbRichTextView.c cVar) {
        this.kcZ = cVar;
    }

    public void setData(com.baidu.tieba.pb.data.e eVar) {
        this.kck = eVar;
    }

    public void fr(String str) {
        this.aSp = str;
    }

    public void rr(boolean z) {
        this.kcl = z;
    }

    private SpannableStringBuilder dn(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new m.a(str, R.drawable.pic_smalldot_title));
            return com.baidu.tieba.card.m.a((Context) this.kdO.cJI(), str2, (ArrayList<m.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    private void c(l lVar) {
        lVar.kds.setTextViewOnTouchListener(this.eor);
        lVar.kds.setTextViewCheckSelection(false);
    }

    public void R(View.OnClickListener onClickListener) {
        this.kcu = onClickListener;
    }

    public void z(View.OnClickListener onClickListener) {
        this.aLl = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.eLw = iVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.eor = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }
}
