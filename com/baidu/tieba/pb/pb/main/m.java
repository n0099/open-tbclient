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
import com.baidu.tbadk.core.data.bw;
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
import com.baidu.tieba.card.n;
import com.baidu.tieba.pb.a.c;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
/* loaded from: classes22.dex */
public class m extends o<PostData, n> implements View.OnClickListener {
    private int aJu;
    private View.OnClickListener aYF;
    private LayerDrawable ajE;
    private LayerDrawable ajF;
    private int bgc;
    private String bgw;
    private TbRichTextView.i fAg;
    private boolean fDq;
    private com.baidu.tieba.pb.a.c fbT;
    private com.baidu.adp.lib.d.b<ConstrainImageLayout> iHO;
    private com.baidu.adp.lib.d.b<TbImageView> iHP;
    private int jiB;
    private int jjb;
    private int liX;
    private LayerDrawable liY;
    private View.OnClickListener lkE;
    protected com.baidu.tieba.pb.data.f lku;
    private boolean lkv;
    private TbRichTextView.c llk;
    private com.baidu.tieba.pb.pb.sub.b lll;
    private boolean llm;
    private boolean lln;
    private boolean llo;
    private com.baidu.tieba.pb.a.c llp;
    private View.OnLongClickListener mOnLongClickListener;

    /* JADX INFO: Access modifiers changed from: private */
    public void dc(View view) {
        if (view != null && (view.getTag() instanceof n)) {
            n nVar = (n) view.getTag();
            if (this.llm && nVar.llT != null && nVar.llT.getData() != null) {
                nVar.llT.bpE();
            }
            if (nVar.llC != null && nVar.llC.getData() != null) {
                nVar.llC.bpE();
            }
        }
    }

    public m(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId) {
        super(bVar, bdUniqueId);
        this.bgc = 0;
        this.jiB = 0;
        this.liX = 0;
        this.jjb = 0;
        this.llk = null;
        this.lkv = true;
        this.bgw = null;
        this.lku = null;
        this.lkE = null;
        this.aYF = null;
        this.fAg = null;
        this.fbT = null;
        this.mOnLongClickListener = null;
        this.lll = null;
        this.fDq = true;
        this.llm = com.baidu.tbadk.a.d.bfv();
        this.lln = com.baidu.tbadk.a.d.bfw();
        this.llo = com.baidu.tbadk.a.d.bfr();
        this.iHO = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.pb.pb.main.m.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cyu */
            public ConstrainImageLayout makeObject() {
                return new ConstrainImageLayout(m.this.mContext);
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
        this.iHP = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<TbImageView>() { // from class: com.baidu.tieba.pb.pb.main.m.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: bqz */
            public TbImageView makeObject() {
                TbImageView tbImageView = new TbImageView(m.this.mContext);
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(com.baidu.tbadk.core.util.ap.getColor(R.color.common_color_10043));
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
        this.llp = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.m.3
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean onDoubleTap(View view, MotionEvent motionEvent) {
                if (view != null && (m.this.ljH == null || m.this.ljH.dhN() == null || m.this.ljH.dhN().dkL())) {
                    if (view instanceof RelativeLayout) {
                        m.this.dc(view);
                    } else {
                        ViewParent parent = view.getParent();
                        int i = 0;
                        while (true) {
                            if (parent == null || i >= 10) {
                                break;
                            } else if (parent instanceof RelativeLayout) {
                                m.this.dc((RelativeLayout) parent);
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
                if (m.this.fbT != null) {
                    if (!(view instanceof TbListTextView) || m.this.aYF == null) {
                        m.this.fbT.Z(view);
                        m.this.fbT.onSingleTapConfirmed(motionEvent);
                        return true;
                    }
                    m.this.aYF.onClick(view);
                    return true;
                }
                return true;
            }
        });
        if (bVar != null && bVar.dgX() != null) {
            this.aJu = bVar.dgX().djF();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cg */
    public n c(ViewGroup viewGroup) {
        n nVar = new n(this.lml.diC().getPageContext(), LayoutInflater.from(this.mContext).inflate(R.layout.pb_reply_floor_item_layout, viewGroup, false), this.aJu, this.llm, this.lln);
        nVar.llF.setConstrainLayoutPool(this.iHO);
        nVar.llF.setImageViewPool(this.iHP);
        if (nVar.llH != null) {
            nVar.llH.setShowChildComment(this.lln);
        }
        a(nVar);
        this.bgc = getDimensionPixelSize(R.dimen.tbds10);
        this.jiB = getDimensionPixelSize(R.dimen.tbds14);
        this.liX = getDimensionPixelSize(R.dimen.tbds36);
        this.jjb = getDimensionPixelSize(R.dimen.tbds6);
        if (nVar.llE != null) {
            nVar.llE.setDuiEnabled(this.fDq);
        }
        uo();
        return nVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.o, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, PostData postData, n nVar) {
        super.a(i, view, viewGroup, (ViewGroup) postData, (PostData) nVar);
        a(nVar);
        b(nVar);
        c(nVar);
        PostData postData2 = (PostData) getItem(i);
        if (postData2 != null) {
            postData2.locate = i + 1;
            j(postData2);
            l(postData2);
            postData2.blm();
            i(postData2);
            a(nVar, postData2, view, i);
        }
        return view;
    }

    public void setDuiEnabled(boolean z) {
        this.fDq = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private void i(PostData postData) {
        if (postData != null) {
            int i = 8;
            if (postData.mRI) {
                i = 2;
            }
            com.baidu.tbadk.core.util.aq b = com.baidu.tieba.pb.c.a.b(this.lku, postData, postData.locate, i, 6);
            postData.mRJ = b;
            if (!com.baidu.tbadk.core.util.y.isEmpty(postData.dHu())) {
                Iterator<PostData> it = postData.dHu().iterator();
                while (it.hasNext()) {
                    it.next().mRJ = b;
                }
            }
        }
    }

    private void a(n nVar, PostData postData, View view, int i) {
        if (nVar != null && postData != null) {
            if (this.llm && this.lln) {
                nVar.llG.setVisibility(8);
                nVar.llL.setVisibility(0);
            } else if (this.llm) {
                nVar.llL.setVisibility(0);
                nVar.llG.setVisibility(0);
                nVar.llK.setVisibility(8);
                nVar.jEa.setVisibility(8);
                nVar.llC.setVisibility(8);
            } else {
                nVar.llL.setVisibility(8);
                nVar.llG.setVisibility(0);
                nVar.llK.setVisibility(0);
                nVar.jEa.setVisibility(0);
                nVar.llC.setVisibility(0);
            }
            b(nVar, postData, view, i);
            f(nVar, postData);
            b(nVar, postData, this.llm);
            a(nVar, postData, view);
            c(nVar, postData, view, i);
            g(nVar, postData);
            a(nVar, postData);
            h(nVar, postData);
            c(nVar, postData);
            e(nVar, postData);
            i(nVar, postData);
            b(nVar, postData);
        }
    }

    private void b(n nVar, PostData postData) {
        if (nVar != null && nVar.llw != null) {
            if (this.lml != null && this.lml.dgX() != null && this.lml.dgX().djN() && com.baidu.tbadk.core.util.at.equals(this.lml.dgX().diU(), postData.getId())) {
                com.baidu.tbadk.core.util.ap.setBackgroundColor(nVar.llw, R.color.cp_other_g);
            } else {
                com.baidu.tbadk.core.util.ap.setBackgroundColor(nVar.llw, R.color.cp_bg_line_e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(n nVar, boolean z, String str) {
        if (z) {
            nVar.lmg.setVisibility(8);
            if (StringUtils.isNull(str)) {
                nVar.lmi.setText(R.string.expand_content);
                return;
            } else {
                nVar.lmi.setText(str);
                return;
            }
        }
        nVar.lmg.setVisibility(0);
        nVar.lmi.setText(R.string.close_content);
    }

    private void c(final n nVar, final PostData postData) {
        if (postData.dHJ() == 2 || postData.dHJ() == 4) {
            nVar.lmh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.m.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    boolean z = nVar.lmg.getVisibility() == 8;
                    m.this.a(nVar, !z, postData.dfT());
                    postData.xi(z ? false : true);
                    m.this.d(nVar, postData);
                    if (m.this.ljH != null && m.this.ljH.dhN() != null && m.this.ljH.dhN().dlN() != null && m.this.ljH.dhN().getListView() != null && !z && nVar.getView().getTop() < m.this.ljH.dhN().dlN().getMeasuredHeight()) {
                        m.this.ljH.dhN().getListView().setSelectionFromTop(com.baidu.tbadk.core.util.y.getPosition(m.this.ljH.dhN().getListView().getData(), postData) + m.this.ljH.dhN().getListView().getHeaderViewsCount(), m.this.ljH.dhN().dlN().getMeasuredHeight());
                    }
                }
            });
            nVar.lmh.setVisibility(0);
            a(nVar, postData.dHs(), postData.dfT());
            a(true, nVar, postData);
        } else {
            nVar.lmh.setVisibility(8);
            nVar.lmg.setVisibility(0);
            a(false, nVar, postData);
        }
        d(nVar, postData);
    }

    private void a(boolean z, n nVar, PostData postData) {
        if (nVar != null && nVar.mBottomLine != null && nVar.lmh != null && (nVar.mBottomLine.getLayoutParams() instanceof RelativeLayout.LayoutParams) && (nVar.lmh.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            boolean z2 = !com.baidu.tbadk.core.util.y.isEmpty(postData.dHu());
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) nVar.mBottomLine.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) nVar.lmh.getLayoutParams();
            if (z) {
                nVar.llE.getLayoutStrategy().sl(0);
                if (z2) {
                    nVar.llE.getLayoutStrategy().sk(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
                    if (layoutParams2 != null) {
                        layoutParams2.topMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds26);
                    }
                } else {
                    nVar.llE.getLayoutStrategy().sk(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds8));
                    if (layoutParams2 != null) {
                        layoutParams2.topMargin = 0;
                    }
                }
                nVar.lmh.setLayoutParams(layoutParams2);
                if (layoutParams != null) {
                    layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44);
                    nVar.mBottomLine.setLayoutParams(layoutParams);
                    return;
                }
                return;
            }
            nVar.llE.getLayoutStrategy().sk(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
            nVar.llE.getLayoutStrategy().sl(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds12));
            if (layoutParams != null) {
                if (this.llm) {
                    layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds0);
                } else {
                    layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds38);
                }
                nVar.mBottomLine.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(n nVar, PostData postData) {
        TbRichText dHz = postData.dHz();
        dHz.isChanged = true;
        nVar.llE.setText(dHz, true, this.llk);
    }

    private void j(PostData postData) {
        if (postData.ezs == 0 && postData.iKn) {
            com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c12203");
            aqVar.dR("post_id", postData.getId());
            aqVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
            aqVar.dR("cuid", TbadkCoreApplication.getInst().getCuid());
            aqVar.dR("cuid_galaxy2", TbadkCoreApplication.getInst().getCuidGalaxy2());
            aqVar.dR("c3_aid", TbadkCoreApplication.getInst().getCuidGalaxy3());
            aqVar.dR("cuid_gid", TbadkCoreApplication.getInst().getCuidGid());
            aqVar.w(TiebaInitialize.Params.EXPOSURE_TIME, System.currentTimeMillis());
            if (this.lml != null) {
                int djF = this.lml.dgX().djF();
                if (1 == djF || 2 == djF) {
                    aqVar.dR("obj_source", "1");
                } else if (3 == djF) {
                    aqVar.dR("obj_source", "2");
                } else {
                    aqVar.dR("obj_source", "0");
                }
            }
            TiebaStatic.log(aqVar);
            if (postData.bka() != null && postData.bka().getAlaInfo() != null && postData.bka().getAlaInfo().live_status == 1) {
                k(postData);
            }
        }
    }

    private void k(PostData postData) {
        String userId = postData.bka().getUserId();
        String forumId = this.lku != null ? this.lku.getForumId() : "";
        String forumName = this.lku != null ? this.lku.getForumName() : "";
        int dHx = postData.dHx();
        String id = postData.getId();
        com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c13714");
        aqVar.dR("fid", forumId);
        aqVar.dR("fname", forumName);
        aqVar.dR("obj_param1", userId);
        aqVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
        aqVar.dR("tid", id);
        aqVar.aj(TiebaInitialize.Params.OBJ_PARAM2, dHx);
        TiebaStatic.log(aqVar);
    }

    private void l(PostData postData) {
        if (this.lku != null) {
            if (this.lku.dgi()) {
                if (this.lmm != null) {
                    com.baidu.tieba.pb.c.a.a(this.lmm.getUniqueId(), this.lku, postData, postData.locate, postData.mRI ? 2 : 8);
                }
            } else if (this.ljH != null) {
                com.baidu.tieba.pb.c.a.a(this.ljH.getUniqueId(), this.lku, postData, postData.locate, postData.mRI ? 2 : 8);
            }
        }
    }

    private void a(n nVar, PostData postData) {
        if (postData == null || postData.dnF() == null) {
            nVar.lma.setVisibility(8);
            return;
        }
        TbRichText dHz = postData.dHz();
        com.baidu.tieba.pb.view.b.a(postData.dnF(), nVar.lma, false, false, dHz != null && StringUtils.isNull(dHz.toString()) && StringUtils.isNull(postData.getBimg_url()));
    }

    private void e(n nVar, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.lkv) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) nVar.llE.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            nVar.llE.setLayoutParams(layoutParams);
            nVar.llE.setPadding(0, 0, 0, 0);
            nVar.llE.Ew(null);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) nVar.llE.getLayoutParams();
            layoutParams2.topMargin = getDimensionPixelSize(R.dimen.ds20);
            layoutParams2.bottomMargin = getDimensionPixelSize(R.dimen.ds20);
            nVar.llE.setLayoutParams(layoutParams2);
            nVar.llE.Ew(postData.getBimg_url());
        }
        nVar.llE.setTextViewOnTouchListener(this.llp);
        nVar.llE.setTextViewCheckSelection(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:184:0x0505  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0511  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x052c  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0537  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x053b  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x0583  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x05e9  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x0626  */
    /* JADX WARN: Removed duplicated region for block: B:301:0x0951  */
    /* JADX WARN: Removed duplicated region for block: B:302:0x095d  */
    /* JADX WARN: Removed duplicated region for block: B:303:0x0969  */
    /* JADX WARN: Removed duplicated region for block: B:304:0x0975  */
    /* JADX WARN: Removed duplicated region for block: B:309:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(n nVar, PostData postData, View view, int i) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        String userId;
        if (nVar != null && postData != null) {
            if (postData.bka() == null || postData.bka().isBaijiahaoUser()) {
            }
            if (postData.mRz) {
                com.baidu.tbadk.core.util.ap.setBackgroundColor(nVar.mTopLine, R.color.cp_bg_line_c);
                nVar.mTopLine.setVisibility(0);
            } else {
                nVar.mTopLine.setVisibility(8);
            }
            nVar.llD.setTag(null);
            nVar.llD.setUserId(null);
            nVar.hAA.setText((CharSequence) null);
            nVar.llW.getHeadView().setUserId(null);
            nVar.llE.setIsHost(false);
            if (postData.bka() != null) {
                if (this.bgw != null && !this.bgw.equals("0") && this.bgw.equals(postData.bka().getUserId())) {
                    nVar.llE.setIsHost(true);
                }
                ArrayList<IconData> iconInfo = postData.bka().getIconInfo();
                ArrayList<IconData> tShowInfoNew = postData.bka().getTShowInfoNew();
                if (nVar.llY != null) {
                    nVar.llY.setTag(R.id.tag_user_id, postData.bka().getUserId());
                    if (this.lml != null && this.lml.diC() != null) {
                        nVar.llY.setOnClickListener(this.lml.diC().ljT.lAe);
                    }
                    nVar.llY.a(iconInfo, 2, this.liX, this.liX, this.bgc);
                }
                if (nVar.llX != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        nVar.llX.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    if (this.lml != null && this.lml.diC() != null) {
                        nVar.llX.setOnClickListener(this.lml.diC().ljT.lAf);
                    }
                    nVar.llX.a(tShowInfoNew, 3, this.liX, this.liX, this.bgc, true);
                }
                if (!com.baidu.tbadk.core.util.y.isEmpty(tShowInfoNew) || postData.bka().isBigV()) {
                    com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.hAA, R.color.cp_cont_h, 1);
                } else {
                    com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.hAA, R.color.cp_cont_j, 1);
                }
                String avater = postData.bka().getAvater();
                int i2 = 8;
                if (postData.mRI) {
                    i2 = 2;
                }
                nVar.hAA.setTag(R.id.tag_user_id, postData.bka().getUserId());
                nVar.hAA.setTag(R.id.tag_user_name, postData.bka().getUserName());
                nVar.hAA.setTag(R.id.tag_virtual_user_url, postData.bka().getVirtualUserUrl());
                nVar.hAA.setTag(R.id.tag_statistic_item, com.baidu.tieba.pb.c.a.b(this.lku, postData, postData.locate, i2, 2));
                String name_show = postData.bka().getName_show();
                String userName = postData.bka().getUserName();
                if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                    nVar.hAA.setText(com.baidu.tieba.pb.c.aU(this.mContext, nVar.hAA.getText().toString()));
                    nVar.hAA.setGravity(16);
                    nVar.hAA.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.dfs());
                    com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.hAA, R.color.cp_other_f, 1);
                }
                if (postData.bka().getPendantData() != null && !StringUtils.isNull(postData.bka().getPendantData().bhW())) {
                    nVar.llW.setBigVDimenSize(R.dimen.tbds32);
                    nVar.llW.a(postData.bka(), 4);
                    nVar.llD.setVisibility(8);
                    nVar.llW.setVisibility(0);
                    nVar.llW.getHeadView().startLoad(avater, 28, false);
                    nVar.llW.getHeadView().setUserId(postData.bka().getUserId());
                    nVar.llW.getHeadView().setUserName(postData.bka().getUserName());
                    nVar.llW.getHeadView().setFid(this.lku != null ? this.lku.getForumId() : "");
                    nVar.llW.getHeadView().setFName(this.lku != null ? this.lku.getForumName() : "");
                    nVar.llW.getHeadView().setFloor(postData.dHx());
                    nVar.llW.getHeadView().setTid(postData.getId());
                    nVar.llW.getHeadView().setTag(R.id.tag_statistic_item, com.baidu.tieba.pb.c.a.b(this.lku, postData, postData.locate, i2, 2));
                    nVar.llW.Cb(postData.bka().getPendantData().bhW());
                } else {
                    nVar.llD.setGodIconWidth(R.dimen.tbds32);
                    UtilHelper.showHeadImageViewBigV(nVar.llD, postData.bka(), 4);
                    nVar.llD.setUserId(postData.bka().getUserId());
                    nVar.llD.setFid(this.lku != null ? this.lku.getForumId() : "");
                    nVar.llD.setFName(this.lku != null ? this.lku.getForumName() : "");
                    nVar.llD.setFloor(postData.dHx());
                    nVar.llD.setTid(postData.getId());
                    nVar.llD.setUserName(postData.bka().getUserName(), postData.dHH());
                    nVar.llD.setTag(R.id.tag_virtual_user_url, postData.bka().getVirtualUserUrl());
                    nVar.llD.setTag(R.id.tag_statistic_item, com.baidu.tieba.pb.c.a.b(this.lku, postData, postData.locate, i2, 2));
                    nVar.llD.setImageDrawable(null);
                    nVar.llD.startLoad(avater, 28, false);
                    nVar.llD.setVisibility(0);
                    nVar.llW.setVisibility(8);
                }
                if (postData.bka() != null && postData.bka().getAlaInfo() != null && postData.bka().getAlaUserData() != null && postData.bka().getAlaUserData().live_status == 1) {
                    nVar.sB(true);
                    nVar.llD.setLiveStatus(1);
                    nVar.llD.setAlaInfo(postData.bka().getAlaInfo());
                    nVar.llW.getHeadView().setLiveStatus(1);
                    nVar.llW.getHeadView().setAlaInfo(postData.bka().getAlaInfo());
                } else {
                    nVar.sB(false);
                    nVar.llD.setLiveStatus(0);
                    nVar.llD.setAlaInfo(null);
                    nVar.llW.getHeadView().setLiveStatus(0);
                    nVar.llW.getHeadView().setAlaInfo(null);
                }
                if (this.lku != null && this.lku.dgl()) {
                    nVar.llx.setVisibility(8);
                    nVar.llx.setTag(null);
                } else if (postData.bka() != null) {
                    MetaData bka = postData.bka();
                    com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.llx, R.color.cp_cont_a);
                    if (this.bgw != null && !this.bgw.equals("0") && this.bgw.equals(bka.getUserId())) {
                        nVar.llx.setTag("HOST");
                        if (nVar.mSkinType == 1) {
                            if (this.liY.getDrawable(1) != null) {
                                this.liY.getDrawable(1).setAlpha(255);
                            }
                        } else if (this.liY.getDrawable(1) != null) {
                            this.liY.getDrawable(1).setAlpha(0);
                        }
                        nVar.llx.setBackgroundDrawable(this.liY);
                        nVar.llx.setVisibility(0);
                        nVar.llx.setText(R.string.host_name);
                    } else if (bka.getIs_bawu() == 1 && postData.dHp()) {
                        int i3 = R.drawable.brand_official_btn;
                        com.baidu.tbadk.core.util.ap.setBackgroundResource(nVar.llx, i3);
                        nVar.llx.setTag(Integer.valueOf(i3));
                        nVar.llx.setVisibility(0);
                        nVar.llx.setText(R.string.brand_Official);
                    } else if (bka.getIs_bawu() == 1 && Config.BAWU_TYPE_MANAGER.equals(bka.getBawu_type())) {
                        nVar.llx.setTag("BA_ZHU_BG");
                        if (nVar.mSkinType == 1) {
                            if (this.ajE.getDrawable(1) != null) {
                                this.ajE.getDrawable(1).setAlpha(255);
                            }
                        } else if (this.ajE.getDrawable(1) != null) {
                            this.ajE.getDrawable(1).setAlpha(0);
                        }
                        nVar.llx.setBackgroundDrawable(this.ajE);
                        nVar.llx.setVisibility(0);
                        nVar.llx.setText(R.string.bawu_member_bazhu_tip);
                    } else if (bka.getIs_bawu() == 1 && Config.BAWU_TYPE_ASSIST.equals(bka.getBawu_type())) {
                        nVar.llx.setTag("XIAO_BA_ZHU_BG");
                        if (nVar.mSkinType == 1) {
                            if (this.ajF.getDrawable(1) != null) {
                                this.ajF.getDrawable(1).setAlpha(255);
                            }
                        } else if (this.ajF.getDrawable(1) != null) {
                            this.ajF.getDrawable(1).setAlpha(0);
                        }
                        nVar.llx.setBackgroundDrawable(this.ajF);
                        nVar.llx.setVisibility(0);
                        nVar.llx.setText(R.string.bawu_member_xbazhu_tip);
                    } else if (bka.getIs_bawu() == 1 && "pri_content_assist".equals(bka.getBawu_type())) {
                        int oM = com.baidu.tbadk.core.util.ap.oM(R.drawable.bg_user_identity_btn);
                        com.baidu.tbadk.core.util.ap.setBackgroundResource(nVar.llx, oM);
                        nVar.llx.setTag(Integer.valueOf(oM));
                        nVar.llx.setVisibility(0);
                        nVar.llx.setText(R.string.bawu_content_assist_tip);
                    } else if (bka.getIs_bawu() == 1 && "pri_manage_assist".equals(bka.getBawu_type())) {
                        int oM2 = com.baidu.tbadk.core.util.ap.oM(R.drawable.bg_user_identity_btn);
                        com.baidu.tbadk.core.util.ap.setBackgroundResource(nVar.llx, oM2);
                        nVar.llx.setTag(Integer.valueOf(oM2));
                        nVar.llx.setVisibility(0);
                        nVar.llx.setText(R.string.bawu_manage_assist_tip);
                    } else {
                        nVar.llx.setVisibility(8);
                        nVar.llx.setTag(null);
                    }
                } else {
                    nVar.llx.setVisibility(8);
                    nVar.llx.setTag(null);
                }
            }
            int i4 = 0;
            if (this.lml != null && this.lml.diC() != null && this.lml.diC().dgO() && postData.bka() != null) {
                i4 = postData.bka().getLevel_id();
            }
            if (this.lku != null && this.lku.dgl()) {
                i4 = 0;
            }
            if (i4 > 0) {
                nVar.llV.setVisibility(0);
                com.baidu.tbadk.core.util.ap.setImageResource(nVar.llV, BitmapHelper.getGradeResourceIdInEnterForum(i4));
            } else {
                nVar.llV.setVisibility(8);
            }
            int i5 = 15;
            if (nVar.llY.getChildCount() == 1) {
                i5 = 13;
            } else if (nVar.llY.getChildCount() > 1) {
                i5 = 11;
            }
            if (nVar.llx.getVisibility() == 0) {
                i5 -= 2;
            }
            if (nVar.llX.getChildCount() > 0) {
                i5 -= 2;
            }
            if (postData.blz() > 1000) {
                i5 -= 2;
            }
            if (postData.blz() > 10) {
                i5 -= 2;
            }
            if (i5 < 10) {
                nVar.llY.setVisibility(8);
                if (nVar.llY.getChildCount() == 1) {
                    i5 += 2;
                } else if (nVar.llY.getChildCount() > 1) {
                    i5 += 4;
                }
                if (i5 < 10 && nVar.llx.getVisibility() == 0) {
                    i5 += 2;
                    nVar.llx.setVisibility(8);
                }
                if (i5 < 10 && nVar.llV.getVisibility() == 0) {
                    i5 += 2;
                    nVar.llV.setVisibility(8);
                }
            }
            String name_show2 = postData.bka() != null ? postData.bka().getName_show() : "";
            int textLengthWithEmoji = com.baidu.tbadk.util.af.getTextLengthWithEmoji(name_show2);
            if (postData.bka() != null && !StringUtils.isNull(postData.bka().getSealPrefix())) {
                if (textLengthWithEmoji > i5 - 2) {
                    name_show2 = com.baidu.tbadk.util.af.subStringWithEmoji(name_show2, i5 - 2) + StringHelper.STRING_MORE;
                }
            } else if (textLengthWithEmoji > i5) {
                name_show2 = com.baidu.tbadk.util.af.subStringWithEmoji(name_show2, i5) + StringHelper.STRING_MORE;
            }
            if (postData.bka() != null && !StringUtils.isNull(postData.bka().getSealPrefix())) {
                nVar.hAA.setText(dT(postData.bka().getSealPrefix(), name_show2));
            } else {
                nVar.hAA.setText(name_show2);
            }
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_load_sub_data, postData);
            sparseArray.put(R.id.tag_load_sub_view, view);
            sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(postData.dHx()));
            sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
            boolean z9 = false;
            if (postData.bka() != null && !StringUtils.isNull(postData.bka().getVirtualUserUrl())) {
                z9 = true;
            }
            boolean z10 = false;
            boolean z11 = false;
            boolean z12 = false;
            if (this.lku != null && this.lku.dfX() != 0) {
                if (this.lku.dfX() != 1002 && this.lku.dfX() != 3) {
                    z10 = true;
                }
                if (this.lku.dfX() != 3 && !this.lku.dgl()) {
                    z11 = true;
                }
                if (postData != null && postData.bka() != null) {
                    String userId2 = postData.bka().getUserId();
                    if (UtilHelper.isCurrentAccount(userId2)) {
                        z10 = false;
                    }
                    if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                        boolean z13 = z11;
                        z = false;
                        z2 = z13;
                        if (this.lku != null && this.lku.dfI() != null && this.lku.dfI().bka() != null && postData.bka() != null) {
                            userId = this.lku.dfI().bka().getUserId();
                            String userId3 = postData.bka().getUserId();
                            if (UtilHelper.isCurrentAccount(userId)) {
                                z3 = true;
                                z4 = true;
                                if (UtilHelper.isCurrentAccount(userId3)) {
                                    z4 = false;
                                    z12 = true;
                                }
                                if (postData == null && postData.bka() != null && UtilHelper.isCurrentAccount(postData.bka().getUserId())) {
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
                                int i6 = 1;
                                if (postData.dHx() == 1) {
                                    i6 = 0;
                                }
                                if (z) {
                                    sparseArray.put(R.id.tag_should_manage_visible, true);
                                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.lku.dfX()));
                                    if (postData.bka() != null) {
                                        sparseArray.put(R.id.tag_forbid_user_name, postData.bka().getUserName());
                                        sparseArray.put(R.id.tag_forbid_user_name_show, postData.bka().getName_show());
                                        sparseArray.put(R.id.tag_forbid_user_portrait, postData.bka().getPortrait());
                                    }
                                } else {
                                    sparseArray.put(R.id.tag_should_manage_visible, false);
                                }
                                if (z7) {
                                    sparseArray.put(R.id.tag_user_mute_visible, true);
                                    sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                                    if (postData.bka() != null) {
                                        sparseArray.put(R.id.tag_user_mute_mute_userid, postData.bka().getUserId());
                                        sparseArray.put(R.id.tag_user_mute_mute_username, postData.bka().getUserName());
                                        sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.bka().getName_show());
                                    }
                                    if (this.lku.dfI() != null) {
                                        sparseArray.put(R.id.tag_user_mute_thread_id, this.lku.dfI().getId());
                                    }
                                    sparseArray.put(R.id.tag_user_mute_post_id, postData.getId());
                                } else {
                                    sparseArray.put(R.id.tag_user_mute_visible, false);
                                }
                                if (z8) {
                                    sparseArray.put(R.id.tag_should_delete_visible, true);
                                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.lku.dfX()));
                                    sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z6));
                                    sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i6));
                                    sparseArray.put(R.id.tag_del_post_id, postData.getId());
                                } else {
                                    sparseArray.put(R.id.tag_should_delete_visible, false);
                                }
                                nVar.llE.setTag(sparseArray);
                                if (this.llm) {
                                    nVar.llZ.setTag(sparseArray);
                                    return;
                                }
                                return;
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
                        int i62 = 1;
                        if (postData.dHx() == 1) {
                        }
                        if (z) {
                        }
                        if (z7) {
                        }
                        if (z8) {
                        }
                        nVar.llE.setTag(sparseArray);
                        if (this.llm) {
                        }
                    }
                }
            }
            boolean z15 = z11;
            z = z10;
            z2 = z15;
            if (this.lku != null) {
                userId = this.lku.dfI().bka().getUserId();
                String userId32 = postData.bka().getUserId();
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
            int i622 = 1;
            if (postData.dHx() == 1) {
            }
            if (z) {
            }
            if (z7) {
            }
            if (z8) {
            }
            nVar.llE.setTag(sparseArray);
            if (this.llm) {
            }
        }
    }

    private void f(n nVar, PostData postData) {
        if (nVar != null && postData != null && nVar.llZ != null && this.lku != null) {
            if (this.llm && !this.lku.dgl()) {
                nVar.llZ.setVisibility(0);
                nVar.llZ.setOnClickListener(this.aYF);
                return;
            }
            nVar.llZ.setVisibility(8);
        }
    }

    private void b(n nVar, PostData postData, boolean z) {
        if (nVar != null && postData != null && postData.blR() != null) {
            postData.blR().threadId = this.lml.dgX().diV();
            postData.blR().objType = 1;
            postData.blR().isInPost = true;
            bw bwVar = null;
            if (this.lku != null && this.lku.dfI() != null) {
                bwVar = this.lku.dfI();
            }
            if (z) {
                nVar.llT.setAgreeAlone(true);
                nVar.llT.setThreadData(bwVar);
                nVar.llT.setData(postData.blR());
            }
            if (bwVar != null && bwVar.biK()) {
                nVar.llC.setAgreeAlone(true);
            }
            nVar.llC.setThreadData(bwVar);
            nVar.llC.setData(postData.blR());
        }
    }

    private void g(n nVar, PostData postData) {
        boolean z;
        int i;
        int i2;
        if (nVar != null && postData != null) {
            if (postData.dHx() > 0 && this.lku != null && !this.lku.dgl()) {
                String format = String.format(this.mContext.getString(R.string.is_floor), Integer.valueOf(postData.dHx()));
                nVar.llU.setVisibility(0);
                nVar.llU.setText(format);
                z = true;
            } else {
                nVar.llU.setVisibility(8);
                z = false;
            }
            com.baidu.tbadk.data.f dHA = postData.dHA();
            boolean z2 = (dHA == null || StringUtils.isNull(dHA.getName()) || this.lku == null || this.lku.dgl()) ? false : true;
            if (z) {
                nVar.llz.setVisibility(0);
                i = this.jiB;
            } else {
                nVar.llz.setVisibility(8);
                i = 0;
            }
            if (z2) {
                nVar.llA.setVisibility(0);
                i2 = this.jiB;
            } else {
                nVar.llA.setVisibility(8);
                i2 = 0;
            }
            nVar.lly.setPadding(i, 0, i2, 0);
            if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                nVar.lly.setText(com.baidu.tbadk.core.util.at.getFormatTimeShort(postData.getTime()));
            } else {
                nVar.lly.setText(com.baidu.tbadk.core.util.at.getFormatTime(postData.getTime()));
            }
            if (z2) {
                nVar.llB.setVisibility(0);
                nVar.llB.setPadding(this.jiB, 0, 0, 0);
                if (postData.mRH) {
                    nVar.llB.setText(com.baidu.tbadk.core.util.at.cutStringWithSuffix(dHA.getName(), 7, StringHelper.STRING_MORE));
                    return;
                } else {
                    nVar.llB.setText(dHA.getName());
                    return;
                }
            }
            nVar.llB.setVisibility(8);
        }
    }

    private void a(n nVar, PostData postData, View view) {
        if (nVar != null && postData != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) nVar.llE.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44);
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds166);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            nVar.llE.setPadding(0, 0, 0, 0);
            if (!this.lkv) {
                nVar.llE.getLayoutStrategy().sf(R.drawable.icon_click);
            } else {
                nVar.llE.Ew(null);
                nVar.llE.setBackgroundDrawable(null);
                nVar.llE.getLayoutStrategy().sf(R.drawable.transparent_bg);
            }
            nVar.llE.getLayoutStrategy().sc(R.drawable.pic_video);
            a(nVar.llE, view, !StringUtils.isNull(postData.getBimg_url()));
            nVar.llE.setLayoutParams(layoutParams);
            nVar.llE.setLinkTextColor(com.baidu.tbadk.core.util.ap.getColor(R.color.cp_link_tip_c));
            nVar.llE.setIsFromCDN(this.mIsFromCDN);
            nVar.llE.setText(postData.dHz(), true, this.llk);
            SparseArray sparseArray = (SparseArray) nVar.llE.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, false);
            nVar.llE.setTag(sparseArray);
            nVar.llw.setTag(R.id.tag_from, sparseArray);
        }
    }

    private void a(TbRichTextView tbRichTextView, View view, boolean z) {
        if (tbRichTextView != null && view != null) {
            int equipmentWidth = (((com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
            if (tbRichTextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) tbRichTextView.getLayoutParams();
                equipmentWidth = (equipmentWidth - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin;
            }
            int dimensionPixelSize = z ? getDimensionPixelSize(R.dimen.tbds115) : 0;
            if (this.llo) {
                tbRichTextView.getLayoutStrategy().sd(((equipmentWidth - dimensionPixelSize) * 2) / 3);
            } else {
                tbRichTextView.getLayoutStrategy().sd(equipmentWidth - dimensionPixelSize);
            }
            tbRichTextView.getLayoutStrategy().fCj = (equipmentWidth - dimensionPixelSize) - getDimensionPixelSize(R.dimen.tbds122);
            if (this.llo) {
                tbRichTextView.getLayoutStrategy().se((int) (((equipmentWidth * 1.618f) * 2.0f) / 3.0f));
            } else {
                tbRichTextView.getLayoutStrategy().se((int) (equipmentWidth * 1.618f));
            }
        }
    }

    private void c(n nVar, PostData postData, View view, int i) {
        String string;
        if (nVar != null && postData != null) {
            if (postData.dHB() > 0) {
                nVar.llJ.setVisibility(8);
            } else {
                SparseArray sparseArray = (SparseArray) nVar.llJ.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    nVar.llJ.setTag(sparseArray);
                }
                sparseArray.put(R.id.tag_load_sub_data, postData);
                if (postData.dHJ() == 2) {
                    nVar.llJ.setVisibility(8);
                } else if (this.llm) {
                    nVar.llG.setVisibility(8);
                } else {
                    nVar.llJ.setVisibility(0);
                }
                nVar.llI.setVisibility(8);
            }
            if (this.llm) {
                if (com.baidu.tbadk.a.d.bfm()) {
                    string = postData.dHB() > 0 ? String.valueOf(postData.dHB()) : TbadkCoreApplication.getInst().getString(R.string.reply);
                } else {
                    string = TbadkCoreApplication.getInst().getString(R.string.reply);
                }
                nVar.llS.setText(string);
                if (nVar.llN != null) {
                    SparseArray sparseArray2 = (SparseArray) nVar.llN.getTag();
                    if (sparseArray2 == null) {
                        sparseArray2 = new SparseArray();
                        nVar.llN.setTag(sparseArray2);
                    }
                    sparseArray2.put(R.id.tag_load_sub_data, postData);
                }
                if (nVar.llM != null) {
                    SparseArray sparseArray3 = (SparseArray) nVar.llM.getTag();
                    if (sparseArray3 == null) {
                        sparseArray3 = new SparseArray();
                        nVar.llM.setTag(sparseArray3);
                    }
                    sparseArray3.put(R.id.tag_load_sub_data, postData);
                }
            } else {
                if (nVar.llK != null) {
                    SparseArray sparseArray4 = (SparseArray) nVar.llK.getTag();
                    if (sparseArray4 == null) {
                        sparseArray4 = new SparseArray();
                        nVar.llK.setTag(sparseArray4);
                    }
                    sparseArray4.put(R.id.tag_load_sub_data, postData);
                }
                if (nVar.jEa != null) {
                    SparseArray sparseArray5 = (SparseArray) nVar.jEa.getTag();
                    if (sparseArray5 == null) {
                        sparseArray5 = new SparseArray();
                        nVar.jEa.setTag(sparseArray5);
                    }
                    sparseArray5.put(R.id.tag_load_sub_data, postData);
                }
            }
            if (postData.dHB() > 0 && !this.lln) {
                nVar.llI.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.sub_pb_load_more, Integer.valueOf(postData.dHB())));
                SparseArray sparseArray6 = (SparseArray) nVar.llI.getTag();
                if (sparseArray6 == null) {
                    sparseArray6 = new SparseArray();
                    nVar.llI.setTag(sparseArray6);
                }
                sparseArray6.put(R.id.tag_load_sub_data, postData);
                nVar.llI.setVisibility(0);
                nVar.llJ.setVisibility(8);
                nVar.llH.setVisibility(8);
            } else {
                nVar.llI.setVisibility(8);
                if (this.lln) {
                    nVar.llJ.setVisibility(8);
                }
                if (postData.dHB() > 0 && postData.dHu() != null && postData.dHu().size() > 0) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) nVar.llH.getLayoutParams();
                    layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds10);
                    layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds166);
                    layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44);
                    layoutParams.bottomMargin = 0;
                    nVar.llH.setLayoutParams(layoutParams);
                    if (this.lll == null) {
                        this.lll = new com.baidu.tieba.pb.pb.sub.b(this.mContext);
                        this.lll.setIsFromCDN(this.mIsFromCDN);
                        this.lll.setOnLongClickListener(this.mOnLongClickListener);
                        this.lll.W(this.lkE);
                        this.lll.A(this.aYF);
                        String str = null;
                        if (this.lku != null && this.lku.dfI() != null && this.lku.dfI().bka() != null) {
                            str = this.lku.dfI().bka().getUserId();
                        }
                        boolean z = str != null && str.equals(TbadkCoreApplication.getCurrentAccount());
                        if (this.lku != null) {
                            this.lll.af(this.lku.dfX(), z);
                            this.lll.setThreadData(this.lku.dfI());
                        }
                    }
                    this.lll.PN(postData.getId());
                    nVar.llH.setSubPbAdapter(this.lll);
                    nVar.llH.setVisibility(0);
                    nVar.llH.setData(postData, view);
                    nVar.llH.setChildOnClickListener(this.aYF);
                    nVar.llH.setChildOnLongClickListener(this.mOnLongClickListener);
                    nVar.llH.setChildOnTouchListener(this.llp);
                } else {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) nVar.llH.getLayoutParams();
                    layoutParams2.topMargin = 0;
                    layoutParams2.leftMargin = 0;
                    layoutParams2.rightMargin = 0;
                    layoutParams2.bottomMargin = 0;
                    nVar.llH.setLayoutParams(layoutParams2);
                    nVar.llH.setVisibility(8);
                }
            }
            if (postData.mRx) {
                nVar.mBottomLine.setVisibility(0);
            } else {
                nVar.mBottomLine.setVisibility(4);
            }
        }
    }

    private void h(n nVar, PostData postData) {
        if (nVar != null && nVar.lme != null && nVar.lmb != null) {
            if (postData == null || postData.mRB == null || StringUtils.isNull(postData.mRB.liveTitle)) {
                nVar.lmb.setVisibility(8);
                return;
            }
            nVar.lme.setText(postData.mRB.liveTitle);
            nVar.lmb.setTag(postData.mRB);
            nVar.lmb.setVisibility(0);
            com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c12639");
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                aqVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
            }
            TiebaStatic.log(aqVar);
        }
    }

    private void i(n nVar, PostData postData) {
        if (nVar != null && postData != null) {
            nVar.lmj.setVisibility(postData.mRH ? 0 : 8);
        }
    }

    private void a(n nVar) {
        LayerDrawable layerDrawable;
        if (nVar != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (nVar.mSkinType != skinType) {
                com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.hAA, R.color.cp_cont_d, 1);
                if (nVar.llx.getTag() instanceof Integer) {
                    com.baidu.tbadk.core.util.ap.setBackgroundResource(nVar.llx, ((Integer) nVar.llx.getTag()).intValue());
                } else if (nVar.llx.getTag() instanceof String) {
                    if (nVar.llx.getTag().equals("BA_ZHU_BG")) {
                        layerDrawable = this.ajE;
                    } else if (nVar.llx.getTag().equals("XIAO_BA_ZHU_BG")) {
                        layerDrawable = this.ajF;
                    } else {
                        layerDrawable = nVar.llx.getTag().equals("HOST") ? this.liY : null;
                    }
                    if (layerDrawable != null && layerDrawable.getDrawable(1) != null) {
                        if (nVar.mSkinType == 1) {
                            layerDrawable.getDrawable(1).setAlpha(255);
                        } else {
                            layerDrawable.getDrawable(1).setAlpha(0);
                        }
                        nVar.llx.setBackgroundDrawable(layerDrawable);
                    }
                }
                com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.lly, R.color.cp_cont_d, 1);
                com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.llz, R.color.cp_cont_d);
                com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.llA, R.color.cp_cont_d);
                com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.llU, R.color.cp_cont_d, 1);
                com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.llB, R.color.cp_cont_d, 1);
                nVar.llE.setTextColor(com.baidu.tbadk.core.util.ap.getColor(R.color.cp_cont_b));
                com.baidu.tbadk.core.util.ap.c(nVar.llH, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10), R.color.cp_bg_line_g, R.color.cp_bg_line_g);
                com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.llI, R.color.cp_cont_c);
                nVar.llI.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.ap.getDrawable(R.drawable.icon_pb_comment_more_n), (Drawable) null);
                com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.llJ, R.color.cp_cont_c);
                if (this.llm) {
                    SvgManager.boN().a(nVar.llZ, R.drawable.ic_icon_pure_close24, R.color.cp_cont_g, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    SvgManager.boN().a(nVar.llR, R.drawable.icon_pure_pb_reply26_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    SvgManager.boN().a(nVar.llP, R.drawable.icon_pure_pb_share26_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    nVar.llT.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                    com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.llQ, R.color.cp_cont_d);
                    com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.llS, R.color.cp_cont_d);
                } else {
                    SvgManager.boN().a(nVar.llK, R.drawable.icon_pure_pb_reply26_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    SvgManager.boN().a(nVar.jEa, R.drawable.icon_pure_pb_share26_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                }
                nVar.llH.onChangeSkinType();
                nVar.llF.onChangeSkinType();
                com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.lme, R.color.cp_link_tip_c, 1);
                com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.lmc, R.color.cp_cont_f, 1);
                com.baidu.tbadk.core.util.ap.setBackgroundResource(nVar.lmb, R.color.cp_bg_line_e);
                com.baidu.tbadk.core.util.ap.setBackgroundResource(nVar.lmd, R.color.cp_cont_d);
                com.baidu.tbadk.core.util.ap.setImageResource(nVar.lmf, R.drawable.icon_arrow_more_gray);
                com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.lmi, R.color.cp_cont_c);
                if (nVar.lmg.getVisibility() == 8) {
                    nVar.lmi.setText(R.string.close_content);
                } else if (this.lku != null && StringUtils.isNull(this.lku.dfT())) {
                    nVar.lmi.setText(this.lku.dfT());
                } else {
                    nVar.lmi.setText(R.string.expand_content);
                }
                nVar.llC.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                nVar.DC(skinType);
                com.baidu.tbadk.core.util.ap.setBackgroundColor(nVar.mBottomLine, R.color.cp_bg_line_b);
            }
            nVar.mSkinType = skinType;
        }
    }

    private void b(final n nVar) {
        nVar.llw.setOnTouchListener(this.llp);
        nVar.llw.setOnLongClickListener(this.mOnLongClickListener);
        if (this.lml.diC() != null && this.lml.diC().getPageContext() != null && this.lml.diC().getPageContext().getOrignalPage() != 0) {
            com.baidu.tieba.pb.pb.main.b.a aVar = this.lml.diC().ljT;
            nVar.hAA.setOnClickListener(aVar.ikM);
            nVar.llD.setOnClickListener(aVar.ikM);
            nVar.llW.setOnClickListener(aVar.ikM);
            nVar.llW.getHeadView().setOnClickListener(aVar.ikM);
            nVar.llE.setOnLongClickListener(this.mOnLongClickListener);
            nVar.llE.setOnTouchListener(this.llp);
            nVar.llE.setCommonTextViewOnClickListener(this.aYF);
            nVar.llE.setOnImageClickListener(this.fAg);
            nVar.llE.setOnImageTouchListener(this.llp);
            nVar.llE.setOnEmotionClickListener(aVar.lAg);
            nVar.llE.setOnVoiceAfterClickListener(this.aYF);
            nVar.lma.setOnClickListener(this.aYF);
            nVar.lmb.setOnClickListener(this.aYF);
            nVar.llI.setOnClickListener(this.aYF);
            nVar.llJ.setOnClickListener(this.aYF);
            final com.baidu.tieba.pb.pb.main.b.c cVar = this.lml.diC().ljU;
            if (this.llm) {
                nVar.llN.setOnClickListener(this.aYF);
                nVar.llM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.m.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        final PostData postData;
                        if (view.getTag() instanceof SparseArray) {
                            SparseArray sparseArray = (SparseArray) view.getTag();
                            if ((sparseArray.get(R.id.tag_load_sub_data) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.tag_load_sub_data)) != null && nVar.llw != null && cVar != null) {
                                com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.m.5.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        cVar.lAv.a(m.this.lku, null, postData, nVar.llE.getLayoutStrategy());
                                    }
                                }, 100L);
                                String threadId = m.this.lku.getThreadId();
                                if ((StringUtils.isNull(threadId) || "0".equals(m.this.lku.getThreadId())) && m.this.lku.dfI() != null) {
                                    threadId = m.this.lku.dfI().getNid();
                                }
                                TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13700").dR("tid", threadId).dR("fid", m.this.lku.getForumId()).w("uid", TbadkCoreApplication.getCurrentAccountId()).dR("post_id", postData.getId()).aj("obj_type", 4));
                            }
                        }
                    }
                });
                nVar.llT.eLm = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.m.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (view != null && m.this.lku != null && nVar != null && nVar.llT != null && nVar.llT.getData() != null) {
                            int i = view == nVar.llT.getImgAgree() ? 1 : 2;
                            String threadId = m.this.lku.getThreadId();
                            if ((StringUtils.isNull(threadId) || "0".equals(m.this.lku.getThreadId())) && m.this.lku.dfI() != null) {
                                threadId = m.this.lku.dfI().getNid();
                            }
                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13700").dR("tid", threadId).dR("fid", m.this.lku.getForumId()).w("uid", TbadkCoreApplication.getCurrentAccountId()).dR("post_id", nVar.llT.getData().postId).aj("obj_type", i));
                        }
                    }
                };
                return;
            }
            nVar.llK.setOnClickListener(this.aYF);
            nVar.jEa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.m.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    final PostData postData;
                    if (view.getTag() instanceof SparseArray) {
                        SparseArray sparseArray = (SparseArray) view.getTag();
                        if ((sparseArray.get(R.id.tag_load_sub_data) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.tag_load_sub_data)) != null && nVar.llw != null && cVar != null) {
                            com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.m.7.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    cVar.lAv.a(m.this.lku, null, postData, nVar.llE.getLayoutStrategy());
                                }
                            }, 100L);
                            String threadId = m.this.lku.getThreadId();
                            if ((StringUtils.isNull(threadId) || "0".equals(m.this.lku.getThreadId())) && m.this.lku.dfI() != null) {
                                threadId = m.this.lku.dfI().getNid();
                            }
                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13700").dR("tid", threadId).dR("fid", m.this.lku.getForumId()).w("uid", TbadkCoreApplication.getCurrentAccountId()).dR("post_id", postData.getId()).aj("obj_type", 4));
                        }
                    }
                }
            });
            nVar.llC.eLm = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.m.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (view != null && m.this.lku != null && nVar != null && nVar.llC != null && nVar.llC.getData() != null) {
                        int i = view == nVar.llC.getImgAgree() ? 1 : 2;
                        String threadId = m.this.lku.getThreadId();
                        if ((StringUtils.isNull(threadId) || "0".equals(m.this.lku.getThreadId())) && m.this.lku.dfI() != null) {
                            threadId = m.this.lku.dfI().getNid();
                        }
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13700").dR("tid", threadId).dR("fid", m.this.lku.getForumId()).w("uid", TbadkCoreApplication.getCurrentAccountId()).dR("post_id", nVar.llC.getData().postId).aj("obj_type", i));
                    }
                }
            };
        }
    }

    private void uo() {
        this.ajE = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.e.a.b.bpp().oZ(0).Z(this.jjb).b("TL_BR", R.color.ba_zhu_start, R.color.ba_zhu_end).bpr(), com.baidu.tbadk.core.util.e.a.b.bpp().oZ(0).Z(this.jjb).BY("#4D000000").bpr()});
        this.ajF = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.e.a.b.bpp().oZ(0).Z(this.jjb).b("TL_BR", R.color.xiao_ba_zhu_start, R.color.xiao_ba_zhu_end).bpr(), com.baidu.tbadk.core.util.e.a.b.bpp().oZ(0).Z(this.jjb).BY("#4D000000").bpr()});
        this.liY = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.e.a.b.bpp().oZ(0).Z(this.jjb).b("TL_BR", R.color.floor_host_start, R.color.floor_host_end).bpr(), com.baidu.tbadk.core.util.e.a.b.bpp().oZ(0).Z(this.jjb).BY("#4D000000").bpr()});
    }

    public void a(TbRichTextView.c cVar) {
        this.llk = cVar;
    }

    public void setData(com.baidu.tieba.pb.data.f fVar) {
        this.lku = fVar;
    }

    public void hx(String str) {
        this.bgw = str;
    }

    public void tK(boolean z) {
        this.lkv = z;
    }

    private SpannableStringBuilder dT(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new n.a(str, R.drawable.pic_smalldot_title));
            return com.baidu.tieba.card.n.a((Context) this.lml.diC(), str2, (ArrayList<n.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    private void c(n nVar) {
        nVar.llE.setTextViewOnTouchListener(this.fbT);
        nVar.llE.setTextViewCheckSelection(false);
    }

    public void S(View.OnClickListener onClickListener) {
        this.lkE = onClickListener;
    }

    public void A(View.OnClickListener onClickListener) {
        this.aYF = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.fAg = iVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.fbT = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }
}
