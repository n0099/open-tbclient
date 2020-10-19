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
import com.baidu.tieba.card.m;
import com.baidu.tieba.pb.a.c;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
/* loaded from: classes22.dex */
public class m extends o<PostData, n> implements View.OnClickListener {
    private int aIS;
    private View.OnClickListener aXk;
    private LayerDrawable ajD;
    private LayerDrawable ajE;
    private int beM;
    private String bfg;
    private com.baidu.tieba.pb.a.c eTx;
    private TbRichTextView.i frJ;
    private boolean fuV;
    private int iWE;
    private int iWe;
    private com.baidu.adp.lib.d.b<ConstrainImageLayout> ivs;
    private com.baidu.adp.lib.d.b<TbImageView> ivt;
    private int kWy;
    private LayerDrawable kWz;
    protected com.baidu.tieba.pb.data.f kXV;
    private boolean kXW;
    private TbRichTextView.c kYL;
    private com.baidu.tieba.pb.pb.sub.b kYM;
    private boolean kYN;
    private boolean kYO;
    private boolean kYP;
    private com.baidu.tieba.pb.a.c kYQ;
    private View.OnClickListener kYf;
    private View.OnLongClickListener mOnLongClickListener;

    /* JADX INFO: Access modifiers changed from: private */
    public void cY(View view) {
        if (view != null && (view.getTag() instanceof n)) {
            n nVar = (n) view.getTag();
            if (this.kYN && nVar.kZu != null && nVar.kZu.getData() != null) {
                nVar.kZu.bnL();
            }
            if (nVar.kZd != null && nVar.kZd.getData() != null) {
                nVar.kZd.bnL();
            }
        }
    }

    public m(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId) {
        super(bVar, bdUniqueId);
        this.beM = 0;
        this.iWe = 0;
        this.kWy = 0;
        this.iWE = 0;
        this.kYL = null;
        this.kXW = true;
        this.bfg = null;
        this.kXV = null;
        this.kYf = null;
        this.aXk = null;
        this.frJ = null;
        this.eTx = null;
        this.mOnLongClickListener = null;
        this.kYM = null;
        this.fuV = true;
        this.kYN = com.baidu.tbadk.a.d.bdC();
        this.kYO = com.baidu.tbadk.a.d.bdD();
        this.kYP = com.baidu.tbadk.a.d.bdy();
        this.ivs = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.pb.pb.main.m.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cvn */
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
        this.ivt = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<TbImageView>() { // from class: com.baidu.tieba.pb.pb.main.m.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: boG */
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
        this.kYQ = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.m.3
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean onDoubleTap(View view, MotionEvent motionEvent) {
                if (view != null && (m.this.kXi == null || m.this.kXi.deG() == null || m.this.kXi.deG().dhE())) {
                    if (view instanceof RelativeLayout) {
                        m.this.cY(view);
                    } else {
                        ViewParent parent = view.getParent();
                        int i = 0;
                        while (true) {
                            if (parent == null || i >= 10) {
                                break;
                            } else if (parent instanceof RelativeLayout) {
                                m.this.cY((RelativeLayout) parent);
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
                if (m.this.eTx != null) {
                    if (!(view instanceof TbListTextView) || m.this.aXk == null) {
                        m.this.eTx.Z(view);
                        m.this.eTx.onSingleTapConfirmed(motionEvent);
                        return true;
                    }
                    m.this.aXk.onClick(view);
                    return true;
                }
                return true;
            }
        });
        if (bVar != null && bVar.ddQ() != null) {
            this.aIS = bVar.ddQ().dgy();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cf */
    public n c(ViewGroup viewGroup) {
        n nVar = new n(this.kZM.dfv().getPageContext(), LayoutInflater.from(this.mContext).inflate(R.layout.pb_reply_floor_item_layout, viewGroup, false), this.aIS, this.kYN, this.kYO);
        nVar.kZg.setConstrainLayoutPool(this.ivs);
        nVar.kZg.setImageViewPool(this.ivt);
        if (nVar.kZi != null) {
            nVar.kZi.setShowChildComment(this.kYO);
        }
        a(nVar);
        this.beM = getDimensionPixelSize(R.dimen.tbds10);
        this.iWe = getDimensionPixelSize(R.dimen.tbds14);
        this.kWy = getDimensionPixelSize(R.dimen.tbds36);
        this.iWE = getDimensionPixelSize(R.dimen.tbds6);
        if (nVar.kZf != null) {
            nVar.kZf.setDuiEnabled(this.fuV);
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
            postData2.bjt();
            i(postData2);
            a(nVar, postData2, view, i);
        }
        return view;
    }

    public void setDuiEnabled(boolean z) {
        this.fuV = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private void i(PostData postData) {
        if (postData != null) {
            int i = 8;
            if (postData.mFb) {
                i = 2;
            }
            com.baidu.tbadk.core.util.aq b = com.baidu.tieba.pb.c.a.b(this.kXV, postData, postData.locate, i, 6);
            postData.mFc = b;
            if (!com.baidu.tbadk.core.util.y.isEmpty(postData.dEm())) {
                Iterator<PostData> it = postData.dEm().iterator();
                while (it.hasNext()) {
                    it.next().mFc = b;
                }
            }
        }
    }

    private void a(n nVar, PostData postData, View view, int i) {
        if (nVar != null && postData != null) {
            if (this.kYN && this.kYO) {
                nVar.kZh.setVisibility(8);
                nVar.kZm.setVisibility(0);
            } else if (this.kYN) {
                nVar.kZm.setVisibility(0);
                nVar.kZh.setVisibility(0);
                nVar.kZl.setVisibility(8);
                nVar.jrA.setVisibility(8);
                nVar.kZd.setVisibility(8);
            } else {
                nVar.kZm.setVisibility(8);
                nVar.kZh.setVisibility(0);
                nVar.kZl.setVisibility(0);
                nVar.jrA.setVisibility(0);
                nVar.kZd.setVisibility(0);
            }
            b(nVar, postData, view, i);
            f(nVar, postData);
            b(nVar, postData, this.kYN);
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
        if (nVar != null && nVar.kYX != null) {
            if (this.kZM != null && this.kZM.ddQ() != null && this.kZM.ddQ().dgG() && com.baidu.tbadk.core.util.at.equals(this.kZM.ddQ().dfN(), postData.getId())) {
                com.baidu.tbadk.core.util.ap.setBackgroundColor(nVar.kYX, R.color.cp_other_g);
            } else {
                com.baidu.tbadk.core.util.ap.setBackgroundColor(nVar.kYX, R.color.cp_bg_line_e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(n nVar, boolean z, String str) {
        if (z) {
            nVar.kZH.setVisibility(8);
            if (StringUtils.isNull(str)) {
                nVar.kZJ.setText(R.string.expand_content);
                return;
            } else {
                nVar.kZJ.setText(str);
                return;
            }
        }
        nVar.kZH.setVisibility(0);
        nVar.kZJ.setText(R.string.close_content);
    }

    private void c(final n nVar, final PostData postData) {
        if (postData.dEB() == 2 || postData.dEB() == 4) {
            nVar.kZI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.m.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    boolean z = nVar.kZH.getVisibility() == 8;
                    m.this.a(nVar, !z, postData.dcL());
                    postData.wR(z ? false : true);
                    m.this.d(nVar, postData);
                    if (m.this.kXi != null && m.this.kXi.deG() != null && m.this.kXi.deG().diG() != null && m.this.kXi.deG().getListView() != null && !z && nVar.getView().getTop() < m.this.kXi.deG().diG().getMeasuredHeight()) {
                        m.this.kXi.deG().getListView().setSelectionFromTop(com.baidu.tbadk.core.util.y.getPosition(m.this.kXi.deG().getListView().getData(), postData) + m.this.kXi.deG().getListView().getHeaderViewsCount(), m.this.kXi.deG().diG().getMeasuredHeight());
                    }
                }
            });
            nVar.kZI.setVisibility(0);
            a(nVar, postData.dEk(), postData.dcL());
            a(true, nVar, postData);
        } else {
            nVar.kZI.setVisibility(8);
            nVar.kZH.setVisibility(0);
            a(false, nVar, postData);
        }
        d(nVar, postData);
    }

    private void a(boolean z, n nVar, PostData postData) {
        if (nVar != null && nVar.mBottomLine != null && nVar.kZI != null && (nVar.mBottomLine.getLayoutParams() instanceof RelativeLayout.LayoutParams) && (nVar.kZI.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            boolean z2 = !com.baidu.tbadk.core.util.y.isEmpty(postData.dEm());
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) nVar.mBottomLine.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) nVar.kZI.getLayoutParams();
            if (z) {
                nVar.kZf.getLayoutStrategy().sa(0);
                if (z2) {
                    nVar.kZf.getLayoutStrategy().rZ(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
                    if (layoutParams2 != null) {
                        layoutParams2.topMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds26);
                    }
                } else {
                    nVar.kZf.getLayoutStrategy().rZ(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds8));
                    if (layoutParams2 != null) {
                        layoutParams2.topMargin = 0;
                    }
                }
                nVar.kZI.setLayoutParams(layoutParams2);
                if (layoutParams != null) {
                    layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44);
                    nVar.mBottomLine.setLayoutParams(layoutParams);
                    return;
                }
                return;
            }
            nVar.kZf.getLayoutStrategy().rZ(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
            nVar.kZf.getLayoutStrategy().sa(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds12));
            if (layoutParams != null) {
                if (this.kYN) {
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
        TbRichText dEr = postData.dEr();
        dEr.isChanged = true;
        nVar.kZf.setText(dEr, true, this.kYL);
    }

    private void j(PostData postData) {
        if (postData.eqR == 0 && postData.ixR) {
            com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c12203");
            aqVar.dK("post_id", postData.getId());
            aqVar.dK("uid", TbadkCoreApplication.getCurrentAccount());
            aqVar.dK("cuid", TbadkCoreApplication.getInst().getCuid());
            aqVar.dK("cuid_galaxy2", TbadkCoreApplication.getInst().getCuidGalaxy2());
            aqVar.dK("c3_aid", TbadkCoreApplication.getInst().getCuidGalaxy3());
            aqVar.dK("cuid_gid", TbadkCoreApplication.getInst().getCuidGid());
            aqVar.u(TiebaInitialize.Params.EXPOSURE_TIME, System.currentTimeMillis());
            if (this.kZM != null) {
                int dgy = this.kZM.ddQ().dgy();
                if (1 == dgy || 2 == dgy) {
                    aqVar.dK("obj_source", "1");
                } else if (3 == dgy) {
                    aqVar.dK("obj_source", "2");
                } else {
                    aqVar.dK("obj_source", "0");
                }
            }
            TiebaStatic.log(aqVar);
            if (postData.bih() != null && postData.bih().getAlaInfo() != null && postData.bih().getAlaInfo().live_status == 1) {
                k(postData);
            }
        }
    }

    private void k(PostData postData) {
        String userId = postData.bih().getUserId();
        String forumId = this.kXV != null ? this.kXV.getForumId() : "";
        String forumName = this.kXV != null ? this.kXV.getForumName() : "";
        int dEp = postData.dEp();
        String id = postData.getId();
        com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c13714");
        aqVar.dK("fid", forumId);
        aqVar.dK("fname", forumName);
        aqVar.dK("obj_param1", userId);
        aqVar.dK("uid", TbadkCoreApplication.getCurrentAccount());
        aqVar.dK("tid", id);
        aqVar.aj(TiebaInitialize.Params.OBJ_PARAM2, dEp);
        TiebaStatic.log(aqVar);
    }

    private void l(PostData postData) {
        if (this.kXV != null) {
            if (this.kXV.dda()) {
                if (this.kZN != null) {
                    com.baidu.tieba.pb.c.a.a(this.kZN.getUniqueId(), this.kXV, postData, postData.locate, postData.mFb ? 2 : 8);
                }
            } else if (this.kXi != null) {
                com.baidu.tieba.pb.c.a.a(this.kXi.getUniqueId(), this.kXV, postData, postData.locate, postData.mFb ? 2 : 8);
            }
        }
    }

    private void a(n nVar, PostData postData) {
        if (postData == null || postData.dkx() == null) {
            nVar.kZB.setVisibility(8);
            return;
        }
        TbRichText dEr = postData.dEr();
        com.baidu.tieba.pb.view.b.a(postData.dkx(), nVar.kZB, false, false, dEr != null && StringUtils.isNull(dEr.toString()) && StringUtils.isNull(postData.getBimg_url()));
    }

    private void e(n nVar, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.kXW) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) nVar.kZf.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            nVar.kZf.setLayoutParams(layoutParams);
            nVar.kZf.setPadding(0, 0, 0, 0);
            nVar.kZf.Ed(null);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) nVar.kZf.getLayoutParams();
            layoutParams2.topMargin = getDimensionPixelSize(R.dimen.ds20);
            layoutParams2.bottomMargin = getDimensionPixelSize(R.dimen.ds20);
            nVar.kZf.setLayoutParams(layoutParams2);
            nVar.kZf.Ed(postData.getBimg_url());
        }
        nVar.kZf.setTextViewOnTouchListener(this.kYQ);
        nVar.kZf.setTextViewCheckSelection(false);
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
            if (postData.bih() == null || postData.bih().isBaijiahaoUser()) {
            }
            if (postData.mES) {
                com.baidu.tbadk.core.util.ap.setBackgroundColor(nVar.mTopLine, R.color.cp_bg_line_c);
                nVar.mTopLine.setVisibility(0);
            } else {
                nVar.mTopLine.setVisibility(8);
            }
            nVar.kZe.setTag(null);
            nVar.kZe.setUserId(null);
            nVar.hoF.setText((CharSequence) null);
            nVar.kZx.getHeadView().setUserId(null);
            nVar.kZf.setIsHost(false);
            if (postData.bih() != null) {
                if (this.bfg != null && !this.bfg.equals("0") && this.bfg.equals(postData.bih().getUserId())) {
                    nVar.kZf.setIsHost(true);
                }
                ArrayList<IconData> iconInfo = postData.bih().getIconInfo();
                ArrayList<IconData> tShowInfoNew = postData.bih().getTShowInfoNew();
                if (nVar.kZz != null) {
                    nVar.kZz.setTag(R.id.tag_user_id, postData.bih().getUserId());
                    if (this.kZM != null && this.kZM.dfv() != null) {
                        nVar.kZz.setOnClickListener(this.kZM.dfv().kXu.lnB);
                    }
                    nVar.kZz.a(iconInfo, 2, this.kWy, this.kWy, this.beM);
                }
                if (nVar.kZy != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        nVar.kZy.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    if (this.kZM != null && this.kZM.dfv() != null) {
                        nVar.kZy.setOnClickListener(this.kZM.dfv().kXu.lnC);
                    }
                    nVar.kZy.a(tShowInfoNew, 3, this.kWy, this.kWy, this.beM, true);
                }
                if (!com.baidu.tbadk.core.util.y.isEmpty(tShowInfoNew) || postData.bih().isBigV()) {
                    com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.hoF, R.color.cp_cont_h, 1);
                } else {
                    com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.hoF, R.color.cp_cont_j, 1);
                }
                String avater = postData.bih().getAvater();
                int i2 = 8;
                if (postData.mFb) {
                    i2 = 2;
                }
                nVar.hoF.setTag(R.id.tag_user_id, postData.bih().getUserId());
                nVar.hoF.setTag(R.id.tag_user_name, postData.bih().getUserName());
                nVar.hoF.setTag(R.id.tag_virtual_user_url, postData.bih().getVirtualUserUrl());
                nVar.hoF.setTag(R.id.tag_statistic_item, com.baidu.tieba.pb.c.a.b(this.kXV, postData, postData.locate, i2, 2));
                String name_show = postData.bih().getName_show();
                String userName = postData.bih().getUserName();
                if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                    nVar.hoF.setText(com.baidu.tieba.pb.c.aS(this.mContext, nVar.hoF.getText().toString()));
                    nVar.hoF.setGravity(16);
                    nVar.hoF.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.dck());
                    com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.hoF, R.color.cp_other_f, 1);
                }
                if (postData.bih().getPendantData() != null && !StringUtils.isNull(postData.bih().getPendantData().bgd())) {
                    nVar.kZx.setBigVDimenSize(R.dimen.tbds32);
                    nVar.kZx.a(postData.bih(), 4);
                    nVar.kZe.setVisibility(8);
                    nVar.kZx.setVisibility(0);
                    nVar.kZx.getHeadView().startLoad(avater, 28, false);
                    nVar.kZx.getHeadView().setUserId(postData.bih().getUserId());
                    nVar.kZx.getHeadView().setUserName(postData.bih().getUserName());
                    nVar.kZx.getHeadView().setFid(this.kXV != null ? this.kXV.getForumId() : "");
                    nVar.kZx.getHeadView().setFName(this.kXV != null ? this.kXV.getForumName() : "");
                    nVar.kZx.getHeadView().setFloor(postData.dEp());
                    nVar.kZx.getHeadView().setTid(postData.getId());
                    nVar.kZx.getHeadView().setTag(R.id.tag_statistic_item, com.baidu.tieba.pb.c.a.b(this.kXV, postData, postData.locate, i2, 2));
                    nVar.kZx.BI(postData.bih().getPendantData().bgd());
                } else {
                    nVar.kZe.setGodIconWidth(R.dimen.tbds32);
                    UtilHelper.showHeadImageViewBigV(nVar.kZe, postData.bih(), 4);
                    nVar.kZe.setUserId(postData.bih().getUserId());
                    nVar.kZe.setFid(this.kXV != null ? this.kXV.getForumId() : "");
                    nVar.kZe.setFName(this.kXV != null ? this.kXV.getForumName() : "");
                    nVar.kZe.setFloor(postData.dEp());
                    nVar.kZe.setTid(postData.getId());
                    nVar.kZe.setUserName(postData.bih().getUserName(), postData.dEz());
                    nVar.kZe.setTag(R.id.tag_virtual_user_url, postData.bih().getVirtualUserUrl());
                    nVar.kZe.setTag(R.id.tag_statistic_item, com.baidu.tieba.pb.c.a.b(this.kXV, postData, postData.locate, i2, 2));
                    nVar.kZe.setImageDrawable(null);
                    nVar.kZe.startLoad(avater, 28, false);
                    nVar.kZe.setVisibility(0);
                    nVar.kZx.setVisibility(8);
                }
                if (postData.bih() != null && postData.bih().getAlaInfo() != null && postData.bih().getAlaUserData() != null && postData.bih().getAlaUserData().live_status == 1) {
                    nVar.sj(true);
                    nVar.kZe.setLiveStatus(1);
                    nVar.kZe.setAlaInfo(postData.bih().getAlaInfo());
                    nVar.kZx.getHeadView().setLiveStatus(1);
                    nVar.kZx.getHeadView().setAlaInfo(postData.bih().getAlaInfo());
                } else {
                    nVar.sj(false);
                    nVar.kZe.setLiveStatus(0);
                    nVar.kZe.setAlaInfo(null);
                    nVar.kZx.getHeadView().setLiveStatus(0);
                    nVar.kZx.getHeadView().setAlaInfo(null);
                }
                if (this.kXV != null && this.kXV.ddd()) {
                    nVar.kYY.setVisibility(8);
                    nVar.kYY.setTag(null);
                } else if (postData.bih() != null) {
                    MetaData bih = postData.bih();
                    com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.kYY, R.color.cp_cont_a);
                    if (this.bfg != null && !this.bfg.equals("0") && this.bfg.equals(bih.getUserId())) {
                        nVar.kYY.setTag("HOST");
                        if (nVar.mSkinType == 1) {
                            if (this.kWz.getDrawable(1) != null) {
                                this.kWz.getDrawable(1).setAlpha(255);
                            }
                        } else if (this.kWz.getDrawable(1) != null) {
                            this.kWz.getDrawable(1).setAlpha(0);
                        }
                        nVar.kYY.setBackgroundDrawable(this.kWz);
                        nVar.kYY.setVisibility(0);
                        nVar.kYY.setText(R.string.host_name);
                    } else if (bih.getIs_bawu() == 1 && postData.dEh()) {
                        int i3 = R.drawable.brand_official_btn;
                        com.baidu.tbadk.core.util.ap.setBackgroundResource(nVar.kYY, i3);
                        nVar.kYY.setTag(Integer.valueOf(i3));
                        nVar.kYY.setVisibility(0);
                        nVar.kYY.setText(R.string.brand_Official);
                    } else if (bih.getIs_bawu() == 1 && Config.BAWU_TYPE_MANAGER.equals(bih.getBawu_type())) {
                        nVar.kYY.setTag("BA_ZHU_BG");
                        if (nVar.mSkinType == 1) {
                            if (this.ajD.getDrawable(1) != null) {
                                this.ajD.getDrawable(1).setAlpha(255);
                            }
                        } else if (this.ajD.getDrawable(1) != null) {
                            this.ajD.getDrawable(1).setAlpha(0);
                        }
                        nVar.kYY.setBackgroundDrawable(this.ajD);
                        nVar.kYY.setVisibility(0);
                        nVar.kYY.setText(R.string.bawu_member_bazhu_tip);
                    } else if (bih.getIs_bawu() == 1 && Config.BAWU_TYPE_ASSIST.equals(bih.getBawu_type())) {
                        nVar.kYY.setTag("XIAO_BA_ZHU_BG");
                        if (nVar.mSkinType == 1) {
                            if (this.ajE.getDrawable(1) != null) {
                                this.ajE.getDrawable(1).setAlpha(255);
                            }
                        } else if (this.ajE.getDrawable(1) != null) {
                            this.ajE.getDrawable(1).setAlpha(0);
                        }
                        nVar.kYY.setBackgroundDrawable(this.ajE);
                        nVar.kYY.setVisibility(0);
                        nVar.kYY.setText(R.string.bawu_member_xbazhu_tip);
                    } else if (bih.getIs_bawu() == 1 && "pri_content_assist".equals(bih.getBawu_type())) {
                        int oB = com.baidu.tbadk.core.util.ap.oB(R.drawable.bg_user_identity_btn);
                        com.baidu.tbadk.core.util.ap.setBackgroundResource(nVar.kYY, oB);
                        nVar.kYY.setTag(Integer.valueOf(oB));
                        nVar.kYY.setVisibility(0);
                        nVar.kYY.setText(R.string.bawu_content_assist_tip);
                    } else if (bih.getIs_bawu() == 1 && "pri_manage_assist".equals(bih.getBawu_type())) {
                        int oB2 = com.baidu.tbadk.core.util.ap.oB(R.drawable.bg_user_identity_btn);
                        com.baidu.tbadk.core.util.ap.setBackgroundResource(nVar.kYY, oB2);
                        nVar.kYY.setTag(Integer.valueOf(oB2));
                        nVar.kYY.setVisibility(0);
                        nVar.kYY.setText(R.string.bawu_manage_assist_tip);
                    } else {
                        nVar.kYY.setVisibility(8);
                        nVar.kYY.setTag(null);
                    }
                } else {
                    nVar.kYY.setVisibility(8);
                    nVar.kYY.setTag(null);
                }
            }
            int i4 = 0;
            if (this.kZM != null && this.kZM.dfv() != null && this.kZM.dfv().ddG() && postData.bih() != null) {
                i4 = postData.bih().getLevel_id();
            }
            if (this.kXV != null && this.kXV.ddd()) {
                i4 = 0;
            }
            if (i4 > 0) {
                nVar.kZw.setVisibility(0);
                com.baidu.tbadk.core.util.ap.setImageResource(nVar.kZw, BitmapHelper.getGradeResourceIdInEnterForum(i4));
            } else {
                nVar.kZw.setVisibility(8);
            }
            int i5 = 15;
            if (nVar.kZz.getChildCount() == 1) {
                i5 = 13;
            } else if (nVar.kZz.getChildCount() > 1) {
                i5 = 11;
            }
            if (nVar.kYY.getVisibility() == 0) {
                i5 -= 2;
            }
            if (nVar.kZy.getChildCount() > 0) {
                i5 -= 2;
            }
            if (postData.bjG() > 1000) {
                i5 -= 2;
            }
            if (postData.bjG() > 10) {
                i5 -= 2;
            }
            if (i5 < 10) {
                nVar.kZz.setVisibility(8);
                if (nVar.kZz.getChildCount() == 1) {
                    i5 += 2;
                } else if (nVar.kZz.getChildCount() > 1) {
                    i5 += 4;
                }
                if (i5 < 10 && nVar.kYY.getVisibility() == 0) {
                    i5 += 2;
                    nVar.kYY.setVisibility(8);
                }
                if (i5 < 10 && nVar.kZw.getVisibility() == 0) {
                    i5 += 2;
                    nVar.kZw.setVisibility(8);
                }
            }
            String name_show2 = postData.bih() != null ? postData.bih().getName_show() : "";
            int textLengthWithEmoji = com.baidu.tbadk.util.af.getTextLengthWithEmoji(name_show2);
            if (postData.bih() != null && !StringUtils.isNull(postData.bih().getSealPrefix())) {
                if (textLengthWithEmoji > i5 - 2) {
                    name_show2 = com.baidu.tbadk.util.af.subStringWithEmoji(name_show2, i5 - 2) + StringHelper.STRING_MORE;
                }
            } else if (textLengthWithEmoji > i5) {
                name_show2 = com.baidu.tbadk.util.af.subStringWithEmoji(name_show2, i5) + StringHelper.STRING_MORE;
            }
            if (postData.bih() != null && !StringUtils.isNull(postData.bih().getSealPrefix())) {
                nVar.hoF.setText(dM(postData.bih().getSealPrefix(), name_show2));
            } else {
                nVar.hoF.setText(name_show2);
            }
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_load_sub_data, postData);
            sparseArray.put(R.id.tag_load_sub_view, view);
            sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(postData.dEp()));
            sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
            boolean z9 = false;
            if (postData.bih() != null && !StringUtils.isNull(postData.bih().getVirtualUserUrl())) {
                z9 = true;
            }
            boolean z10 = false;
            boolean z11 = false;
            boolean z12 = false;
            if (this.kXV != null && this.kXV.dcP() != 0) {
                if (this.kXV.dcP() != 1002 && this.kXV.dcP() != 3) {
                    z10 = true;
                }
                if (this.kXV.dcP() != 3 && !this.kXV.ddd()) {
                    z11 = true;
                }
                if (postData != null && postData.bih() != null) {
                    String userId2 = postData.bih().getUserId();
                    if (UtilHelper.isCurrentAccount(userId2)) {
                        z10 = false;
                    }
                    if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                        boolean z13 = z11;
                        z = false;
                        z2 = z13;
                        if (this.kXV != null && this.kXV.dcA() != null && this.kXV.dcA().bih() != null && postData.bih() != null) {
                            userId = this.kXV.dcA().bih().getUserId();
                            String userId3 = postData.bih().getUserId();
                            if (UtilHelper.isCurrentAccount(userId)) {
                                z3 = true;
                                z4 = true;
                                if (UtilHelper.isCurrentAccount(userId3)) {
                                    z4 = false;
                                    z12 = true;
                                }
                                if (postData == null && postData.bih() != null && UtilHelper.isCurrentAccount(postData.bih().getUserId())) {
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
                                if (postData.dEp() == 1) {
                                    i6 = 0;
                                }
                                if (z) {
                                    sparseArray.put(R.id.tag_should_manage_visible, true);
                                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.kXV.dcP()));
                                    if (postData.bih() != null) {
                                        sparseArray.put(R.id.tag_forbid_user_name, postData.bih().getUserName());
                                        sparseArray.put(R.id.tag_forbid_user_name_show, postData.bih().getName_show());
                                        sparseArray.put(R.id.tag_forbid_user_portrait, postData.bih().getPortrait());
                                    }
                                } else {
                                    sparseArray.put(R.id.tag_should_manage_visible, false);
                                }
                                if (z7) {
                                    sparseArray.put(R.id.tag_user_mute_visible, true);
                                    sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                                    if (postData.bih() != null) {
                                        sparseArray.put(R.id.tag_user_mute_mute_userid, postData.bih().getUserId());
                                        sparseArray.put(R.id.tag_user_mute_mute_username, postData.bih().getUserName());
                                        sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.bih().getName_show());
                                    }
                                    if (this.kXV.dcA() != null) {
                                        sparseArray.put(R.id.tag_user_mute_thread_id, this.kXV.dcA().getId());
                                    }
                                    sparseArray.put(R.id.tag_user_mute_post_id, postData.getId());
                                } else {
                                    sparseArray.put(R.id.tag_user_mute_visible, false);
                                }
                                if (z8) {
                                    sparseArray.put(R.id.tag_should_delete_visible, true);
                                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.kXV.dcP()));
                                    sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z6));
                                    sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i6));
                                    sparseArray.put(R.id.tag_del_post_id, postData.getId());
                                } else {
                                    sparseArray.put(R.id.tag_should_delete_visible, false);
                                }
                                nVar.kZf.setTag(sparseArray);
                                if (this.kYN) {
                                    nVar.kZA.setTag(sparseArray);
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
                        if (postData.dEp() == 1) {
                        }
                        if (z) {
                        }
                        if (z7) {
                        }
                        if (z8) {
                        }
                        nVar.kZf.setTag(sparseArray);
                        if (this.kYN) {
                        }
                    }
                }
            }
            boolean z15 = z11;
            z = z10;
            z2 = z15;
            if (this.kXV != null) {
                userId = this.kXV.dcA().bih().getUserId();
                String userId32 = postData.bih().getUserId();
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
            if (postData.dEp() == 1) {
            }
            if (z) {
            }
            if (z7) {
            }
            if (z8) {
            }
            nVar.kZf.setTag(sparseArray);
            if (this.kYN) {
            }
        }
    }

    private void f(n nVar, PostData postData) {
        if (nVar != null && postData != null && nVar.kZA != null && this.kXV != null) {
            if (this.kYN && !this.kXV.ddd()) {
                nVar.kZA.setVisibility(0);
                nVar.kZA.setOnClickListener(this.aXk);
                return;
            }
            nVar.kZA.setVisibility(8);
        }
    }

    private void b(n nVar, PostData postData, boolean z) {
        if (nVar != null && postData != null && postData.bjY() != null) {
            postData.bjY().threadId = this.kZM.ddQ().dfO();
            postData.bjY().objType = 1;
            postData.bjY().isInPost = true;
            bw bwVar = null;
            if (this.kXV != null && this.kXV.dcA() != null) {
                bwVar = this.kXV.dcA();
            }
            if (z) {
                nVar.kZu.setAgreeAlone(true);
                nVar.kZu.setThreadData(bwVar);
                nVar.kZu.setData(postData.bjY());
            }
            if (bwVar != null && bwVar.bgR()) {
                nVar.kZd.setAgreeAlone(true);
            }
            nVar.kZd.setThreadData(bwVar);
            nVar.kZd.setData(postData.bjY());
        }
    }

    private void g(n nVar, PostData postData) {
        boolean z;
        int i;
        int i2;
        if (nVar != null && postData != null) {
            if (postData.dEp() > 0 && this.kXV != null && !this.kXV.ddd()) {
                String format = String.format(this.mContext.getString(R.string.is_floor), Integer.valueOf(postData.dEp()));
                nVar.kZv.setVisibility(0);
                nVar.kZv.setText(format);
                z = true;
            } else {
                nVar.kZv.setVisibility(8);
                z = false;
            }
            com.baidu.tbadk.data.f dEs = postData.dEs();
            boolean z2 = (dEs == null || StringUtils.isNull(dEs.getName()) || this.kXV == null || this.kXV.ddd()) ? false : true;
            if (z) {
                nVar.kZa.setVisibility(0);
                i = this.iWe;
            } else {
                nVar.kZa.setVisibility(8);
                i = 0;
            }
            if (z2) {
                nVar.kZb.setVisibility(0);
                i2 = this.iWe;
            } else {
                nVar.kZb.setVisibility(8);
                i2 = 0;
            }
            nVar.kYZ.setPadding(i, 0, i2, 0);
            if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                nVar.kYZ.setText(com.baidu.tbadk.core.util.at.getFormatTimeShort(postData.getTime()));
            } else {
                nVar.kYZ.setText(com.baidu.tbadk.core.util.at.getFormatTime(postData.getTime()));
            }
            if (z2) {
                nVar.kZc.setVisibility(0);
                nVar.kZc.setPadding(this.iWe, 0, 0, 0);
                if (postData.mFa) {
                    nVar.kZc.setText(com.baidu.tbadk.core.util.at.cutStringWithSuffix(dEs.getName(), 7, StringHelper.STRING_MORE));
                    return;
                } else {
                    nVar.kZc.setText(dEs.getName());
                    return;
                }
            }
            nVar.kZc.setVisibility(8);
        }
    }

    private void a(n nVar, PostData postData, View view) {
        if (nVar != null && postData != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) nVar.kZf.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44);
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds166);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            nVar.kZf.setPadding(0, 0, 0, 0);
            if (!this.kXW) {
                nVar.kZf.getLayoutStrategy().rU(R.drawable.icon_click);
            } else {
                nVar.kZf.Ed(null);
                nVar.kZf.setBackgroundDrawable(null);
                nVar.kZf.getLayoutStrategy().rU(R.drawable.transparent_bg);
            }
            nVar.kZf.getLayoutStrategy().rR(R.drawable.pic_video);
            a(nVar.kZf, view, !StringUtils.isNull(postData.getBimg_url()));
            nVar.kZf.setLayoutParams(layoutParams);
            nVar.kZf.setLinkTextColor(com.baidu.tbadk.core.util.ap.getColor(R.color.cp_link_tip_c));
            nVar.kZf.setIsFromCDN(this.mIsFromCDN);
            nVar.kZf.setText(postData.dEr(), true, this.kYL);
            SparseArray sparseArray = (SparseArray) nVar.kZf.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, false);
            nVar.kZf.setTag(sparseArray);
            nVar.kYX.setTag(R.id.tag_from, sparseArray);
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
            if (this.kYP) {
                tbRichTextView.getLayoutStrategy().rS(((equipmentWidth - dimensionPixelSize) * 2) / 3);
            } else {
                tbRichTextView.getLayoutStrategy().rS(equipmentWidth - dimensionPixelSize);
            }
            tbRichTextView.getLayoutStrategy().ftO = (equipmentWidth - dimensionPixelSize) - getDimensionPixelSize(R.dimen.tbds122);
            if (this.kYP) {
                tbRichTextView.getLayoutStrategy().rT((int) (((equipmentWidth * 1.618f) * 2.0f) / 3.0f));
            } else {
                tbRichTextView.getLayoutStrategy().rT((int) (equipmentWidth * 1.618f));
            }
        }
    }

    private void c(n nVar, PostData postData, View view, int i) {
        String string;
        if (nVar != null && postData != null) {
            if (postData.dEt() > 0) {
                nVar.kZk.setVisibility(8);
            } else {
                SparseArray sparseArray = (SparseArray) nVar.kZk.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    nVar.kZk.setTag(sparseArray);
                }
                sparseArray.put(R.id.tag_load_sub_data, postData);
                if (postData.dEB() == 2) {
                    nVar.kZk.setVisibility(8);
                } else if (this.kYN) {
                    nVar.kZh.setVisibility(8);
                } else {
                    nVar.kZk.setVisibility(0);
                }
                nVar.kZj.setVisibility(8);
            }
            if (this.kYN) {
                if (com.baidu.tbadk.a.d.bdt()) {
                    string = postData.dEt() > 0 ? String.valueOf(postData.dEt()) : TbadkCoreApplication.getInst().getString(R.string.reply);
                } else {
                    string = TbadkCoreApplication.getInst().getString(R.string.reply);
                }
                nVar.kZt.setText(string);
                if (nVar.kZo != null) {
                    SparseArray sparseArray2 = (SparseArray) nVar.kZo.getTag();
                    if (sparseArray2 == null) {
                        sparseArray2 = new SparseArray();
                        nVar.kZo.setTag(sparseArray2);
                    }
                    sparseArray2.put(R.id.tag_load_sub_data, postData);
                }
                if (nVar.kZn != null) {
                    SparseArray sparseArray3 = (SparseArray) nVar.kZn.getTag();
                    if (sparseArray3 == null) {
                        sparseArray3 = new SparseArray();
                        nVar.kZn.setTag(sparseArray3);
                    }
                    sparseArray3.put(R.id.tag_load_sub_data, postData);
                }
            } else {
                if (nVar.kZl != null) {
                    SparseArray sparseArray4 = (SparseArray) nVar.kZl.getTag();
                    if (sparseArray4 == null) {
                        sparseArray4 = new SparseArray();
                        nVar.kZl.setTag(sparseArray4);
                    }
                    sparseArray4.put(R.id.tag_load_sub_data, postData);
                }
                if (nVar.jrA != null) {
                    SparseArray sparseArray5 = (SparseArray) nVar.jrA.getTag();
                    if (sparseArray5 == null) {
                        sparseArray5 = new SparseArray();
                        nVar.jrA.setTag(sparseArray5);
                    }
                    sparseArray5.put(R.id.tag_load_sub_data, postData);
                }
            }
            if (postData.dEt() > 0 && !this.kYO) {
                nVar.kZj.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.sub_pb_load_more, Integer.valueOf(postData.dEt())));
                SparseArray sparseArray6 = (SparseArray) nVar.kZj.getTag();
                if (sparseArray6 == null) {
                    sparseArray6 = new SparseArray();
                    nVar.kZj.setTag(sparseArray6);
                }
                sparseArray6.put(R.id.tag_load_sub_data, postData);
                nVar.kZj.setVisibility(0);
                nVar.kZk.setVisibility(8);
                nVar.kZi.setVisibility(8);
            } else {
                nVar.kZj.setVisibility(8);
                if (this.kYO) {
                    nVar.kZk.setVisibility(8);
                }
                if (postData.dEt() > 0 && postData.dEm() != null && postData.dEm().size() > 0) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) nVar.kZi.getLayoutParams();
                    layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds10);
                    layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds166);
                    layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44);
                    layoutParams.bottomMargin = 0;
                    nVar.kZi.setLayoutParams(layoutParams);
                    if (this.kYM == null) {
                        this.kYM = new com.baidu.tieba.pb.pb.sub.b(this.mContext);
                        this.kYM.setIsFromCDN(this.mIsFromCDN);
                        this.kYM.setOnLongClickListener(this.mOnLongClickListener);
                        this.kYM.W(this.kYf);
                        this.kYM.A(this.aXk);
                        String str = null;
                        if (this.kXV != null && this.kXV.dcA() != null && this.kXV.dcA().bih() != null) {
                            str = this.kXV.dcA().bih().getUserId();
                        }
                        boolean z = str != null && str.equals(TbadkCoreApplication.getCurrentAccount());
                        if (this.kXV != null) {
                            this.kYM.af(this.kXV.dcP(), z);
                            this.kYM.setThreadData(this.kXV.dcA());
                        }
                    }
                    this.kYM.Pp(postData.getId());
                    nVar.kZi.setSubPbAdapter(this.kYM);
                    nVar.kZi.setVisibility(0);
                    nVar.kZi.setData(postData, view);
                    nVar.kZi.setChildOnClickListener(this.aXk);
                    nVar.kZi.setChildOnLongClickListener(this.mOnLongClickListener);
                    nVar.kZi.setChildOnTouchListener(this.kYQ);
                } else {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) nVar.kZi.getLayoutParams();
                    layoutParams2.topMargin = 0;
                    layoutParams2.leftMargin = 0;
                    layoutParams2.rightMargin = 0;
                    layoutParams2.bottomMargin = 0;
                    nVar.kZi.setLayoutParams(layoutParams2);
                    nVar.kZi.setVisibility(8);
                }
            }
            if (postData.mEQ) {
                nVar.mBottomLine.setVisibility(0);
            } else {
                nVar.mBottomLine.setVisibility(4);
            }
        }
    }

    private void h(n nVar, PostData postData) {
        if (nVar != null && nVar.kZF != null && nVar.kZC != null) {
            if (postData == null || postData.mEU == null || StringUtils.isNull(postData.mEU.liveTitle)) {
                nVar.kZC.setVisibility(8);
                return;
            }
            nVar.kZF.setText(postData.mEU.liveTitle);
            nVar.kZC.setTag(postData.mEU);
            nVar.kZC.setVisibility(0);
            com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c12639");
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                aqVar.dK("uid", TbadkCoreApplication.getCurrentAccount());
            }
            TiebaStatic.log(aqVar);
        }
    }

    private void i(n nVar, PostData postData) {
        if (nVar != null && postData != null) {
            nVar.kZK.setVisibility(postData.mFa ? 0 : 8);
        }
    }

    private void a(n nVar) {
        LayerDrawable layerDrawable;
        if (nVar != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (nVar.mSkinType != skinType) {
                com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.hoF, R.color.cp_cont_d, 1);
                if (nVar.kYY.getTag() instanceof Integer) {
                    com.baidu.tbadk.core.util.ap.setBackgroundResource(nVar.kYY, ((Integer) nVar.kYY.getTag()).intValue());
                } else if (nVar.kYY.getTag() instanceof String) {
                    if (nVar.kYY.getTag().equals("BA_ZHU_BG")) {
                        layerDrawable = this.ajD;
                    } else if (nVar.kYY.getTag().equals("XIAO_BA_ZHU_BG")) {
                        layerDrawable = this.ajE;
                    } else {
                        layerDrawable = nVar.kYY.getTag().equals("HOST") ? this.kWz : null;
                    }
                    if (layerDrawable != null && layerDrawable.getDrawable(1) != null) {
                        if (nVar.mSkinType == 1) {
                            layerDrawable.getDrawable(1).setAlpha(255);
                        } else {
                            layerDrawable.getDrawable(1).setAlpha(0);
                        }
                        nVar.kYY.setBackgroundDrawable(layerDrawable);
                    }
                }
                com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.kYZ, R.color.cp_cont_d, 1);
                com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.kZa, R.color.cp_cont_d);
                com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.kZb, R.color.cp_cont_d);
                com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.kZv, R.color.cp_cont_d, 1);
                com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.kZc, R.color.cp_cont_d, 1);
                nVar.kZf.setTextColor(com.baidu.tbadk.core.util.ap.getColor(R.color.cp_cont_b));
                com.baidu.tbadk.core.util.ap.c(nVar.kZi, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10), R.color.cp_bg_line_g, R.color.cp_bg_line_g);
                com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.kZj, R.color.cp_cont_c);
                nVar.kZj.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.ap.getDrawable(R.drawable.icon_pb_comment_more_n), (Drawable) null);
                com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.kZk, R.color.cp_cont_c);
                if (this.kYN) {
                    SvgManager.bmU().a(nVar.kZA, R.drawable.ic_icon_pure_close24, R.color.cp_cont_g, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    SvgManager.bmU().a(nVar.kZs, R.drawable.icon_pure_pb_reply26_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    SvgManager.bmU().a(nVar.kZq, R.drawable.icon_pure_pb_share26_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    nVar.kZu.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                    com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.kZr, R.color.cp_cont_d);
                    com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.kZt, R.color.cp_cont_d);
                } else {
                    SvgManager.bmU().a(nVar.kZl, R.drawable.icon_pure_pb_reply26_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    SvgManager.bmU().a(nVar.jrA, R.drawable.icon_pure_pb_share26_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                }
                nVar.kZi.onChangeSkinType();
                nVar.kZg.onChangeSkinType();
                com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.kZF, R.color.cp_link_tip_c, 1);
                com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.kZD, R.color.cp_cont_f, 1);
                com.baidu.tbadk.core.util.ap.setBackgroundResource(nVar.kZC, R.color.cp_bg_line_e);
                com.baidu.tbadk.core.util.ap.setBackgroundResource(nVar.kZE, R.color.cp_cont_d);
                com.baidu.tbadk.core.util.ap.setImageResource(nVar.kZG, R.drawable.icon_arrow_more_gray);
                com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.kZJ, R.color.cp_cont_c);
                if (nVar.kZH.getVisibility() == 8) {
                    nVar.kZJ.setText(R.string.close_content);
                } else if (this.kXV != null && StringUtils.isNull(this.kXV.dcL())) {
                    nVar.kZJ.setText(this.kXV.dcL());
                } else {
                    nVar.kZJ.setText(R.string.expand_content);
                }
                nVar.kZd.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                nVar.Dj(skinType);
                com.baidu.tbadk.core.util.ap.setBackgroundColor(nVar.mBottomLine, R.color.cp_bg_line_b);
            }
            nVar.mSkinType = skinType;
        }
    }

    private void b(final n nVar) {
        nVar.kYX.setOnTouchListener(this.kYQ);
        nVar.kYX.setOnLongClickListener(this.mOnLongClickListener);
        if (this.kZM.dfv() != null && this.kZM.dfv().getPageContext() != null && this.kZM.dfv().getPageContext().getOrignalPage() != 0) {
            com.baidu.tieba.pb.pb.main.b.a aVar = this.kZM.dfv().kXu;
            nVar.hoF.setOnClickListener(aVar.hYm);
            nVar.kZe.setOnClickListener(aVar.hYm);
            nVar.kZx.setOnClickListener(aVar.hYm);
            nVar.kZx.getHeadView().setOnClickListener(aVar.hYm);
            nVar.kZf.setOnLongClickListener(this.mOnLongClickListener);
            nVar.kZf.setOnTouchListener(this.kYQ);
            nVar.kZf.setCommonTextViewOnClickListener(this.aXk);
            nVar.kZf.setOnImageClickListener(this.frJ);
            nVar.kZf.setOnImageTouchListener(this.kYQ);
            nVar.kZf.setOnEmotionClickListener(aVar.lnD);
            nVar.kZf.setOnVoiceAfterClickListener(this.aXk);
            nVar.kZB.setOnClickListener(this.aXk);
            nVar.kZC.setOnClickListener(this.aXk);
            nVar.kZj.setOnClickListener(this.aXk);
            nVar.kZk.setOnClickListener(this.aXk);
            final com.baidu.tieba.pb.pb.main.b.c cVar = this.kZM.dfv().kXv;
            if (this.kYN) {
                nVar.kZo.setOnClickListener(this.aXk);
                nVar.kZn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.m.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        final PostData postData;
                        if (view.getTag() instanceof SparseArray) {
                            SparseArray sparseArray = (SparseArray) view.getTag();
                            if ((sparseArray.get(R.id.tag_load_sub_data) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.tag_load_sub_data)) != null && nVar.kYX != null && cVar != null) {
                                com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.m.5.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        cVar.lnS.a(m.this.kXV, null, postData, nVar.kZf.getLayoutStrategy());
                                    }
                                }, 100L);
                                String threadId = m.this.kXV.getThreadId();
                                if ((StringUtils.isNull(threadId) || "0".equals(m.this.kXV.getThreadId())) && m.this.kXV.dcA() != null) {
                                    threadId = m.this.kXV.dcA().getNid();
                                }
                                TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13700").dK("tid", threadId).dK("fid", m.this.kXV.getForumId()).u("uid", TbadkCoreApplication.getCurrentAccountId()).dK("post_id", postData.getId()).aj("obj_type", 4));
                            }
                        }
                    }
                });
                nVar.kZu.eCQ = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.m.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (view != null && m.this.kXV != null && nVar != null && nVar.kZu != null && nVar.kZu.getData() != null) {
                            int i = view == nVar.kZu.getImgAgree() ? 1 : 2;
                            String threadId = m.this.kXV.getThreadId();
                            if ((StringUtils.isNull(threadId) || "0".equals(m.this.kXV.getThreadId())) && m.this.kXV.dcA() != null) {
                                threadId = m.this.kXV.dcA().getNid();
                            }
                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13700").dK("tid", threadId).dK("fid", m.this.kXV.getForumId()).u("uid", TbadkCoreApplication.getCurrentAccountId()).dK("post_id", nVar.kZu.getData().postId).aj("obj_type", i));
                        }
                    }
                };
                return;
            }
            nVar.kZl.setOnClickListener(this.aXk);
            nVar.jrA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.m.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    final PostData postData;
                    if (view.getTag() instanceof SparseArray) {
                        SparseArray sparseArray = (SparseArray) view.getTag();
                        if ((sparseArray.get(R.id.tag_load_sub_data) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.tag_load_sub_data)) != null && nVar.kYX != null && cVar != null) {
                            com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.m.7.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    cVar.lnS.a(m.this.kXV, null, postData, nVar.kZf.getLayoutStrategy());
                                }
                            }, 100L);
                            String threadId = m.this.kXV.getThreadId();
                            if ((StringUtils.isNull(threadId) || "0".equals(m.this.kXV.getThreadId())) && m.this.kXV.dcA() != null) {
                                threadId = m.this.kXV.dcA().getNid();
                            }
                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13700").dK("tid", threadId).dK("fid", m.this.kXV.getForumId()).u("uid", TbadkCoreApplication.getCurrentAccountId()).dK("post_id", postData.getId()).aj("obj_type", 4));
                        }
                    }
                }
            });
            nVar.kZd.eCQ = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.m.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (view != null && m.this.kXV != null && nVar != null && nVar.kZd != null && nVar.kZd.getData() != null) {
                        int i = view == nVar.kZd.getImgAgree() ? 1 : 2;
                        String threadId = m.this.kXV.getThreadId();
                        if ((StringUtils.isNull(threadId) || "0".equals(m.this.kXV.getThreadId())) && m.this.kXV.dcA() != null) {
                            threadId = m.this.kXV.dcA().getNid();
                        }
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13700").dK("tid", threadId).dK("fid", m.this.kXV.getForumId()).u("uid", TbadkCoreApplication.getCurrentAccountId()).dK("post_id", nVar.kZd.getData().postId).aj("obj_type", i));
                    }
                }
            };
        }
    }

    private void uo() {
        this.ajD = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.e.a.b.bnw().oO(0).X(this.iWE).b("TL_BR", R.color.ba_zhu_start, R.color.ba_zhu_end).bny(), com.baidu.tbadk.core.util.e.a.b.bnw().oO(0).X(this.iWE).BF("#4D000000").bny()});
        this.ajE = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.e.a.b.bnw().oO(0).X(this.iWE).b("TL_BR", R.color.xiao_ba_zhu_start, R.color.xiao_ba_zhu_end).bny(), com.baidu.tbadk.core.util.e.a.b.bnw().oO(0).X(this.iWE).BF("#4D000000").bny()});
        this.kWz = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.e.a.b.bnw().oO(0).X(this.iWE).b("TL_BR", R.color.floor_host_start, R.color.floor_host_end).bny(), com.baidu.tbadk.core.util.e.a.b.bnw().oO(0).X(this.iWE).BF("#4D000000").bny()});
    }

    public void a(TbRichTextView.c cVar) {
        this.kYL = cVar;
    }

    public void setData(com.baidu.tieba.pb.data.f fVar) {
        this.kXV = fVar;
    }

    public void hp(String str) {
        this.bfg = str;
    }

    public void tt(boolean z) {
        this.kXW = z;
    }

    private SpannableStringBuilder dM(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new m.a(str, R.drawable.pic_smalldot_title));
            return com.baidu.tieba.card.m.a((Context) this.kZM.dfv(), str2, (ArrayList<m.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    private void c(n nVar) {
        nVar.kZf.setTextViewOnTouchListener(this.eTx);
        nVar.kZf.setTextViewCheckSelection(false);
    }

    public void S(View.OnClickListener onClickListener) {
        this.kYf = onClickListener;
    }

    public void A(View.OnClickListener onClickListener) {
        this.aXk = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.frJ = iVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.eTx = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }
}
