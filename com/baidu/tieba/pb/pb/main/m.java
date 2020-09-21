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
/* loaded from: classes21.dex */
public class m extends o<PostData, n> implements View.OnClickListener {
    private int aFO;
    private View.OnClickListener aTZ;
    private LayerDrawable ajl;
    private LayerDrawable ajm;
    private int bbc;
    private String bbv;
    private com.baidu.tieba.pb.a.c eHq;
    private TbRichTextView.i ffu;
    private boolean fiH;
    private int iHO;
    private int iHo;
    private com.baidu.adp.lib.d.b<ConstrainImageLayout> igv;
    private com.baidu.adp.lib.d.b<TbImageView> igw;
    private int kHn;
    private LayerDrawable kHo;
    protected com.baidu.tieba.pb.data.f kIK;
    private boolean kIL;
    private View.OnClickListener kIU;
    private TbRichTextView.c kJA;
    private com.baidu.tieba.pb.pb.sub.b kJB;
    private boolean kJC;
    private boolean kJD;
    private boolean kJE;
    private com.baidu.tieba.pb.a.c kJF;
    private View.OnLongClickListener mOnLongClickListener;

    /* JADX INFO: Access modifiers changed from: private */
    public void cU(View view) {
        if (view != null && (view.getTag() instanceof n)) {
            n nVar = (n) view.getTag();
            if (this.kJC && nVar.kKj != null && nVar.kKj.getData() != null) {
                nVar.kKj.blb();
            }
            if (nVar.kJS != null && nVar.kJS.getData() != null) {
                nVar.kJS.blb();
            }
        }
    }

    public m(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId) {
        super(bVar, bdUniqueId);
        this.bbc = 0;
        this.iHo = 0;
        this.kHn = 0;
        this.iHO = 0;
        this.kJA = null;
        this.kIL = true;
        this.bbv = null;
        this.kIK = null;
        this.kIU = null;
        this.aTZ = null;
        this.ffu = null;
        this.eHq = null;
        this.mOnLongClickListener = null;
        this.kJB = null;
        this.fiH = true;
        this.kJC = com.baidu.tbadk.a.d.baU();
        this.kJD = com.baidu.tbadk.a.d.baV();
        this.kJE = com.baidu.tbadk.a.d.baQ();
        this.igv = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.pb.pb.main.m.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: crP */
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
        this.igw = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<TbImageView>() { // from class: com.baidu.tieba.pb.pb.main.m.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: blW */
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
        this.kJF = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.m.3
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean onDoubleTap(View view, MotionEvent motionEvent) {
                if (view != null && (m.this.kHX == null || m.this.kHX.daX() == null || m.this.kHX.daX().ddV())) {
                    if (view instanceof RelativeLayout) {
                        m.this.cU(view);
                    } else {
                        ViewParent parent = view.getParent();
                        int i = 0;
                        while (true) {
                            if (parent == null || i >= 10) {
                                break;
                            } else if (parent instanceof RelativeLayout) {
                                m.this.cU((RelativeLayout) parent);
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
                if (m.this.eHq != null) {
                    if (!(view instanceof TbListTextView) || m.this.aTZ == null) {
                        m.this.eHq.Z(view);
                        m.this.eHq.onSingleTapConfirmed(motionEvent);
                        return true;
                    }
                    m.this.aTZ.onClick(view);
                    return true;
                }
                return true;
            }
        });
        if (bVar != null && bVar.dah() != null) {
            this.aFO = bVar.dah().dcP();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cd */
    public n c(ViewGroup viewGroup) {
        n nVar = new n(this.kKB.dbM().getPageContext(), LayoutInflater.from(this.mContext).inflate(R.layout.pb_reply_floor_item_layout, viewGroup, false), this.aFO, this.kJC, this.kJD);
        nVar.kJV.setConstrainLayoutPool(this.igv);
        nVar.kJV.setImageViewPool(this.igw);
        if (nVar.kJX != null) {
            nVar.kJX.setShowChildComment(this.kJD);
        }
        a(nVar);
        this.bbc = getDimensionPixelSize(R.dimen.tbds10);
        this.iHo = getDimensionPixelSize(R.dimen.tbds14);
        this.kHn = getDimensionPixelSize(R.dimen.tbds36);
        this.iHO = getDimensionPixelSize(R.dimen.tbds6);
        if (nVar.kJU != null) {
            nVar.kJU.setDuiEnabled(this.fiH);
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
            postData2.bgK();
            i(postData2);
            a(nVar, postData2, view, i);
        }
        return view;
    }

    public void setDuiEnabled(boolean z) {
        this.fiH = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private void i(PostData postData) {
        if (postData != null) {
            int i = 8;
            if (postData.mpv) {
                i = 2;
            }
            com.baidu.tbadk.core.util.aq b = com.baidu.tieba.pb.c.a.b(this.kIK, postData, postData.locate, i, 6);
            postData.mpw = b;
            if (!com.baidu.tbadk.core.util.y.isEmpty(postData.dAA())) {
                Iterator<PostData> it = postData.dAA().iterator();
                while (it.hasNext()) {
                    it.next().mpw = b;
                }
            }
        }
    }

    private void a(n nVar, PostData postData, View view, int i) {
        if (nVar != null && postData != null) {
            if (this.kJC && this.kJD) {
                nVar.kJW.setVisibility(8);
                nVar.kKb.setVisibility(0);
            } else if (this.kJC) {
                nVar.kKb.setVisibility(0);
                nVar.kJW.setVisibility(0);
                nVar.kKa.setVisibility(8);
                nVar.jcB.setVisibility(8);
                nVar.kJS.setVisibility(8);
            } else {
                nVar.kKb.setVisibility(8);
                nVar.kJW.setVisibility(0);
                nVar.kKa.setVisibility(0);
                nVar.jcB.setVisibility(0);
                nVar.kJS.setVisibility(0);
            }
            b(nVar, postData, view, i);
            f(nVar, postData);
            b(nVar, postData, this.kJC);
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
        if (nVar != null && nVar.kJM != null) {
            if (this.kKB != null && this.kKB.dah() != null && this.kKB.dah().dcX() && com.baidu.tbadk.core.util.at.equals(this.kKB.dah().dce(), postData.getId())) {
                com.baidu.tbadk.core.util.ap.setBackgroundColor(nVar.kJM, R.color.cp_other_g);
            } else {
                com.baidu.tbadk.core.util.ap.setBackgroundColor(nVar.kJM, R.color.cp_bg_line_e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(n nVar, boolean z, String str) {
        if (z) {
            nVar.kKw.setVisibility(8);
            if (StringUtils.isNull(str)) {
                nVar.kKy.setText(R.string.expand_content);
                return;
            } else {
                nVar.kKy.setText(str);
                return;
            }
        }
        nVar.kKw.setVisibility(0);
        nVar.kKy.setText(R.string.close_content);
    }

    private void c(final n nVar, final PostData postData) {
        if (postData.dAP() == 2 || postData.dAP() == 4) {
            nVar.kKx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.m.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    boolean z = nVar.kKw.getVisibility() == 8;
                    m.this.a(nVar, !z, postData.cZc());
                    postData.wk(z ? false : true);
                    m.this.d(nVar, postData);
                    if (m.this.kHX != null && m.this.kHX.daX() != null && m.this.kHX.daX().deX() != null && m.this.kHX.daX().getListView() != null && !z && nVar.getView().getTop() < m.this.kHX.daX().deX().getMeasuredHeight()) {
                        m.this.kHX.daX().getListView().setSelectionFromTop(com.baidu.tbadk.core.util.y.getPosition(m.this.kHX.daX().getListView().getData(), postData) + m.this.kHX.daX().getListView().getHeaderViewsCount(), m.this.kHX.daX().deX().getMeasuredHeight());
                    }
                }
            });
            nVar.kKx.setVisibility(0);
            a(nVar, postData.dAy(), postData.cZc());
            a(true, nVar, postData);
        } else {
            nVar.kKx.setVisibility(8);
            nVar.kKw.setVisibility(0);
            a(false, nVar, postData);
        }
        d(nVar, postData);
    }

    private void a(boolean z, n nVar, PostData postData) {
        if (nVar != null && nVar.mBottomLine != null && nVar.kKx != null && (nVar.mBottomLine.getLayoutParams() instanceof RelativeLayout.LayoutParams) && (nVar.kKx.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            boolean z2 = !com.baidu.tbadk.core.util.y.isEmpty(postData.dAA());
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) nVar.mBottomLine.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) nVar.kKx.getLayoutParams();
            if (z) {
                nVar.kJU.getLayoutStrategy().rC(0);
                if (z2) {
                    nVar.kJU.getLayoutStrategy().rB(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
                    if (layoutParams2 != null) {
                        layoutParams2.topMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds26);
                    }
                } else {
                    nVar.kJU.getLayoutStrategy().rB(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds8));
                    if (layoutParams2 != null) {
                        layoutParams2.topMargin = 0;
                    }
                }
                nVar.kKx.setLayoutParams(layoutParams2);
                if (layoutParams != null) {
                    layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44);
                    nVar.mBottomLine.setLayoutParams(layoutParams);
                    return;
                }
                return;
            }
            nVar.kJU.getLayoutStrategy().rB(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
            nVar.kJU.getLayoutStrategy().rC(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds12));
            if (layoutParams != null) {
                if (this.kJC) {
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
        TbRichText dAF = postData.dAF();
        dAF.isChanged = true;
        nVar.kJU.setText(dAF, true, this.kJA);
    }

    private void j(PostData postData) {
        if (postData.eeM == 0 && postData.iiU) {
            com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c12203");
            aqVar.dF("post_id", postData.getId());
            aqVar.dF("uid", TbadkCoreApplication.getCurrentAccount());
            aqVar.dF("cuid", TbadkCoreApplication.getInst().getCuid());
            aqVar.dF("cuid_galaxy2", TbadkCoreApplication.getInst().getCuidGalaxy2());
            aqVar.dF("c3_aid", TbadkCoreApplication.getInst().getCuidGalaxy3());
            aqVar.dF("cuid_gid", TbadkCoreApplication.getInst().getCuidGid());
            aqVar.u(TiebaInitialize.Params.EXPOSURE_TIME, System.currentTimeMillis());
            if (this.kKB != null) {
                int dcP = this.kKB.dah().dcP();
                if (1 == dcP || 2 == dcP) {
                    aqVar.dF("obj_source", "1");
                } else if (3 == dcP) {
                    aqVar.dF("obj_source", "2");
                } else {
                    aqVar.dF("obj_source", "0");
                }
            }
            TiebaStatic.log(aqVar);
            if (postData.bfy() != null && postData.bfy().getAlaInfo() != null && postData.bfy().getAlaInfo().live_status == 1) {
                k(postData);
            }
        }
    }

    private void k(PostData postData) {
        String userId = postData.bfy().getUserId();
        String forumId = this.kIK != null ? this.kIK.getForumId() : "";
        String forumName = this.kIK != null ? this.kIK.getForumName() : "";
        int dAD = postData.dAD();
        String id = postData.getId();
        com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c13714");
        aqVar.dF("fid", forumId);
        aqVar.dF("fname", forumName);
        aqVar.dF("obj_param1", userId);
        aqVar.dF("uid", TbadkCoreApplication.getCurrentAccount());
        aqVar.dF("tid", id);
        aqVar.ai(TiebaInitialize.Params.OBJ_PARAM2, dAD);
        TiebaStatic.log(aqVar);
    }

    private void l(PostData postData) {
        if (this.kIK != null) {
            if (this.kIK.cZr()) {
                if (this.kKC != null) {
                    com.baidu.tieba.pb.c.a.a(this.kKC.getUniqueId(), this.kIK, postData, postData.locate, postData.mpv ? 2 : 8);
                }
            } else if (this.kHX != null) {
                com.baidu.tieba.pb.c.a.a(this.kHX.getUniqueId(), this.kIK, postData, postData.locate, postData.mpv ? 2 : 8);
            }
        }
    }

    private void a(n nVar, PostData postData) {
        if (postData == null || postData.dgO() == null) {
            nVar.kKq.setVisibility(8);
            return;
        }
        TbRichText dAF = postData.dAF();
        com.baidu.tieba.pb.view.b.a(postData.dgO(), nVar.kKq, false, false, dAF != null && StringUtils.isNull(dAF.toString()) && StringUtils.isNull(postData.getBimg_url()));
    }

    private void e(n nVar, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.kIL) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) nVar.kJU.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            nVar.kJU.setLayoutParams(layoutParams);
            nVar.kJU.setPadding(0, 0, 0, 0);
            nVar.kJU.Dr(null);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) nVar.kJU.getLayoutParams();
            layoutParams2.topMargin = getDimensionPixelSize(R.dimen.ds20);
            layoutParams2.bottomMargin = getDimensionPixelSize(R.dimen.ds20);
            nVar.kJU.setLayoutParams(layoutParams2);
            nVar.kJU.Dr(postData.getBimg_url());
        }
        nVar.kJU.setTextViewOnTouchListener(this.kJF);
        nVar.kJU.setTextViewCheckSelection(false);
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
            if (postData.bfy() == null || postData.bfy().isBaijiahaoUser()) {
            }
            if (postData.mpm) {
                com.baidu.tbadk.core.util.ap.setBackgroundColor(nVar.mTopLine, R.color.cp_bg_line_c);
                nVar.mTopLine.setVisibility(0);
            } else {
                nVar.mTopLine.setVisibility(8);
            }
            nVar.kJT.setTag(null);
            nVar.kJT.setUserId(null);
            nVar.gZE.setText((CharSequence) null);
            nVar.kKm.getHeadView().setUserId(null);
            nVar.kJU.setIsHost(false);
            if (postData.bfy() != null) {
                if (this.bbv != null && !this.bbv.equals("0") && this.bbv.equals(postData.bfy().getUserId())) {
                    nVar.kJU.setIsHost(true);
                }
                ArrayList<IconData> iconInfo = postData.bfy().getIconInfo();
                ArrayList<IconData> tShowInfoNew = postData.bfy().getTShowInfoNew();
                if (nVar.kKo != null) {
                    nVar.kKo.setTag(R.id.tag_user_id, postData.bfy().getUserId());
                    if (this.kKB != null && this.kKB.dbM() != null) {
                        nVar.kKo.setOnClickListener(this.kKB.dbM().kIj.kYn);
                    }
                    nVar.kKo.a(iconInfo, 2, this.kHn, this.kHn, this.bbc);
                }
                if (nVar.kKn != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        nVar.kKn.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    if (this.kKB != null && this.kKB.dbM() != null) {
                        nVar.kKn.setOnClickListener(this.kKB.dbM().kIj.kYo);
                    }
                    nVar.kKn.a(tShowInfoNew, 3, this.kHn, this.kHn, this.bbc, true);
                }
                if (!com.baidu.tbadk.core.util.y.isEmpty(tShowInfoNew) || postData.bfy().isBigV()) {
                    com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.gZE, R.color.cp_cont_h, 1);
                } else {
                    com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.gZE, R.color.cp_cont_j, 1);
                }
                String avater = postData.bfy().getAvater();
                int i2 = 8;
                if (postData.mpv) {
                    i2 = 2;
                }
                nVar.gZE.setTag(R.id.tag_user_id, postData.bfy().getUserId());
                nVar.gZE.setTag(R.id.tag_user_name, postData.bfy().getUserName());
                nVar.gZE.setTag(R.id.tag_virtual_user_url, postData.bfy().getVirtualUserUrl());
                nVar.gZE.setTag(R.id.tag_statistic_item, com.baidu.tieba.pb.c.a.b(this.kIK, postData, postData.locate, i2, 2));
                String name_show = postData.bfy().getName_show();
                String userName = postData.bfy().getUserName();
                if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                    nVar.gZE.setText(com.baidu.tieba.pb.c.aQ(this.mContext, nVar.gZE.getText().toString()));
                    nVar.gZE.setGravity(16);
                    nVar.gZE.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.cYB());
                    com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.gZE, R.color.cp_other_f, 1);
                }
                if (postData.bfy().getPendantData() != null && !StringUtils.isNull(postData.bfy().getPendantData().bdu())) {
                    nVar.kKm.setBigVDimenSize(R.dimen.tbds32);
                    nVar.kKm.a(postData.bfy(), 4);
                    nVar.kJT.setVisibility(8);
                    nVar.kKm.setVisibility(0);
                    nVar.kKm.getHeadView().startLoad(avater, 28, false);
                    nVar.kKm.getHeadView().setUserId(postData.bfy().getUserId());
                    nVar.kKm.getHeadView().setUserName(postData.bfy().getUserName());
                    nVar.kKm.getHeadView().setFid(this.kIK != null ? this.kIK.getForumId() : "");
                    nVar.kKm.getHeadView().setFName(this.kIK != null ? this.kIK.getForumName() : "");
                    nVar.kKm.getHeadView().setFloor(postData.dAD());
                    nVar.kKm.getHeadView().setTid(postData.getId());
                    nVar.kKm.getHeadView().setTag(R.id.tag_statistic_item, com.baidu.tieba.pb.c.a.b(this.kIK, postData, postData.locate, i2, 2));
                    nVar.kKm.AW(postData.bfy().getPendantData().bdu());
                } else {
                    nVar.kJT.setGodIconWidth(R.dimen.tbds32);
                    UtilHelper.showHeadImageViewBigV(nVar.kJT, postData.bfy(), 4);
                    nVar.kJT.setUserId(postData.bfy().getUserId());
                    nVar.kJT.setFid(this.kIK != null ? this.kIK.getForumId() : "");
                    nVar.kJT.setFName(this.kIK != null ? this.kIK.getForumName() : "");
                    nVar.kJT.setFloor(postData.dAD());
                    nVar.kJT.setTid(postData.getId());
                    nVar.kJT.setUserName(postData.bfy().getUserName(), postData.dAN());
                    nVar.kJT.setTag(R.id.tag_virtual_user_url, postData.bfy().getVirtualUserUrl());
                    nVar.kJT.setTag(R.id.tag_statistic_item, com.baidu.tieba.pb.c.a.b(this.kIK, postData, postData.locate, i2, 2));
                    nVar.kJT.setImageDrawable(null);
                    nVar.kJT.startLoad(avater, 28, false);
                    nVar.kJT.setVisibility(0);
                    nVar.kKm.setVisibility(8);
                }
                if (postData.bfy() != null && postData.bfy().getAlaInfo() != null && postData.bfy().getAlaUserData() != null && postData.bfy().getAlaUserData().live_status == 1) {
                    nVar.rD(true);
                    nVar.kJT.setLiveStatus(1);
                    nVar.kJT.setAlaInfo(postData.bfy().getAlaInfo());
                    nVar.kKm.getHeadView().setLiveStatus(1);
                    nVar.kKm.getHeadView().setAlaInfo(postData.bfy().getAlaInfo());
                } else {
                    nVar.rD(false);
                    nVar.kJT.setLiveStatus(0);
                    nVar.kJT.setAlaInfo(null);
                    nVar.kKm.getHeadView().setLiveStatus(0);
                    nVar.kKm.getHeadView().setAlaInfo(null);
                }
                if (this.kIK != null && this.kIK.cZu()) {
                    nVar.kJN.setVisibility(8);
                    nVar.kJN.setTag(null);
                } else if (postData.bfy() != null) {
                    MetaData bfy = postData.bfy();
                    com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.kJN, R.color.cp_cont_a);
                    if (this.bbv != null && !this.bbv.equals("0") && this.bbv.equals(bfy.getUserId())) {
                        nVar.kJN.setTag("HOST");
                        if (nVar.mSkinType == 1) {
                            if (this.kHo.getDrawable(1) != null) {
                                this.kHo.getDrawable(1).setAlpha(255);
                            }
                        } else if (this.kHo.getDrawable(1) != null) {
                            this.kHo.getDrawable(1).setAlpha(0);
                        }
                        nVar.kJN.setBackgroundDrawable(this.kHo);
                        nVar.kJN.setVisibility(0);
                        nVar.kJN.setText(R.string.host_name);
                    } else if (bfy.getIs_bawu() == 1 && postData.dAv()) {
                        int i3 = R.drawable.brand_official_btn;
                        com.baidu.tbadk.core.util.ap.setBackgroundResource(nVar.kJN, i3);
                        nVar.kJN.setTag(Integer.valueOf(i3));
                        nVar.kJN.setVisibility(0);
                        nVar.kJN.setText(R.string.brand_Official);
                    } else if (bfy.getIs_bawu() == 1 && Config.BAWU_TYPE_MANAGER.equals(bfy.getBawu_type())) {
                        nVar.kJN.setTag("BA_ZHU_BG");
                        if (nVar.mSkinType == 1) {
                            if (this.ajl.getDrawable(1) != null) {
                                this.ajl.getDrawable(1).setAlpha(255);
                            }
                        } else if (this.ajl.getDrawable(1) != null) {
                            this.ajl.getDrawable(1).setAlpha(0);
                        }
                        nVar.kJN.setBackgroundDrawable(this.ajl);
                        nVar.kJN.setVisibility(0);
                        nVar.kJN.setText(R.string.bawu_member_bazhu_tip);
                    } else if (bfy.getIs_bawu() == 1 && Config.BAWU_TYPE_ASSIST.equals(bfy.getBawu_type())) {
                        nVar.kJN.setTag("XIAO_BA_ZHU_BG");
                        if (nVar.mSkinType == 1) {
                            if (this.ajm.getDrawable(1) != null) {
                                this.ajm.getDrawable(1).setAlpha(255);
                            }
                        } else if (this.ajm.getDrawable(1) != null) {
                            this.ajm.getDrawable(1).setAlpha(0);
                        }
                        nVar.kJN.setBackgroundDrawable(this.ajm);
                        nVar.kJN.setVisibility(0);
                        nVar.kJN.setText(R.string.bawu_member_xbazhu_tip);
                    } else if (bfy.getIs_bawu() == 1 && "pri_content_assist".equals(bfy.getBawu_type())) {
                        int oe = com.baidu.tbadk.core.util.ap.oe(R.drawable.bg_user_identity_btn);
                        com.baidu.tbadk.core.util.ap.setBackgroundResource(nVar.kJN, oe);
                        nVar.kJN.setTag(Integer.valueOf(oe));
                        nVar.kJN.setVisibility(0);
                        nVar.kJN.setText(R.string.bawu_content_assist_tip);
                    } else if (bfy.getIs_bawu() == 1 && "pri_manage_assist".equals(bfy.getBawu_type())) {
                        int oe2 = com.baidu.tbadk.core.util.ap.oe(R.drawable.bg_user_identity_btn);
                        com.baidu.tbadk.core.util.ap.setBackgroundResource(nVar.kJN, oe2);
                        nVar.kJN.setTag(Integer.valueOf(oe2));
                        nVar.kJN.setVisibility(0);
                        nVar.kJN.setText(R.string.bawu_manage_assist_tip);
                    } else {
                        nVar.kJN.setVisibility(8);
                        nVar.kJN.setTag(null);
                    }
                } else {
                    nVar.kJN.setVisibility(8);
                    nVar.kJN.setTag(null);
                }
            }
            int i4 = 0;
            if (this.kKB != null && this.kKB.dbM() != null && this.kKB.dbM().cZX() && postData.bfy() != null) {
                i4 = postData.bfy().getLevel_id();
            }
            if (this.kIK != null && this.kIK.cZu()) {
                i4 = 0;
            }
            if (i4 > 0) {
                nVar.kKl.setVisibility(0);
                com.baidu.tbadk.core.util.ap.setImageResource(nVar.kKl, BitmapHelper.getGradeResourceIdInEnterForum(i4));
            } else {
                nVar.kKl.setVisibility(8);
            }
            int i5 = 15;
            if (nVar.kKo.getChildCount() == 1) {
                i5 = 13;
            } else if (nVar.kKo.getChildCount() > 1) {
                i5 = 11;
            }
            if (nVar.kJN.getVisibility() == 0) {
                i5 -= 2;
            }
            if (nVar.kKn.getChildCount() > 0) {
                i5 -= 2;
            }
            if (postData.bgX() > 1000) {
                i5 -= 2;
            }
            if (postData.bgX() > 10) {
                i5 -= 2;
            }
            if (i5 < 10) {
                nVar.kKo.setVisibility(8);
                if (nVar.kKo.getChildCount() == 1) {
                    i5 += 2;
                } else if (nVar.kKo.getChildCount() > 1) {
                    i5 += 4;
                }
                if (i5 < 10 && nVar.kJN.getVisibility() == 0) {
                    i5 += 2;
                    nVar.kJN.setVisibility(8);
                }
                if (i5 < 10 && nVar.kKl.getVisibility() == 0) {
                    i5 += 2;
                    nVar.kKl.setVisibility(8);
                }
            }
            String name_show2 = postData.bfy() != null ? postData.bfy().getName_show() : "";
            int textLengthWithEmoji = com.baidu.tbadk.util.af.getTextLengthWithEmoji(name_show2);
            if (postData.bfy() != null && !StringUtils.isNull(postData.bfy().getSealPrefix())) {
                if (textLengthWithEmoji > i5 - 2) {
                    name_show2 = com.baidu.tbadk.util.af.subStringWithEmoji(name_show2, i5 - 2) + StringHelper.STRING_MORE;
                }
            } else if (textLengthWithEmoji > i5) {
                name_show2 = com.baidu.tbadk.util.af.subStringWithEmoji(name_show2, i5) + StringHelper.STRING_MORE;
            }
            if (postData.bfy() != null && !StringUtils.isNull(postData.bfy().getSealPrefix())) {
                nVar.gZE.setText(dH(postData.bfy().getSealPrefix(), name_show2));
            } else {
                nVar.gZE.setText(name_show2);
            }
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_load_sub_data, postData);
            sparseArray.put(R.id.tag_load_sub_view, view);
            sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(postData.dAD()));
            sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
            boolean z9 = false;
            if (postData.bfy() != null && !StringUtils.isNull(postData.bfy().getVirtualUserUrl())) {
                z9 = true;
            }
            boolean z10 = false;
            boolean z11 = false;
            boolean z12 = false;
            if (this.kIK != null && this.kIK.cZg() != 0) {
                if (this.kIK.cZg() != 1002 && this.kIK.cZg() != 3) {
                    z10 = true;
                }
                if (this.kIK.cZg() != 3 && !this.kIK.cZu()) {
                    z11 = true;
                }
                if (postData != null && postData.bfy() != null) {
                    String userId2 = postData.bfy().getUserId();
                    if (UtilHelper.isCurrentAccount(userId2)) {
                        z10 = false;
                    }
                    if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                        boolean z13 = z11;
                        z = false;
                        z2 = z13;
                        if (this.kIK != null && this.kIK.cYR() != null && this.kIK.cYR().bfy() != null && postData.bfy() != null) {
                            userId = this.kIK.cYR().bfy().getUserId();
                            String userId3 = postData.bfy().getUserId();
                            if (UtilHelper.isCurrentAccount(userId)) {
                                z3 = true;
                                z4 = true;
                                if (UtilHelper.isCurrentAccount(userId3)) {
                                    z4 = false;
                                    z12 = true;
                                }
                                if (postData == null && postData.bfy() != null && UtilHelper.isCurrentAccount(postData.bfy().getUserId())) {
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
                                if (postData.dAD() == 1) {
                                    i6 = 0;
                                }
                                if (z) {
                                    sparseArray.put(R.id.tag_should_manage_visible, true);
                                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.kIK.cZg()));
                                    if (postData.bfy() != null) {
                                        sparseArray.put(R.id.tag_forbid_user_name, postData.bfy().getUserName());
                                        sparseArray.put(R.id.tag_forbid_user_name_show, postData.bfy().getName_show());
                                        sparseArray.put(R.id.tag_forbid_user_portrait, postData.bfy().getPortrait());
                                    }
                                } else {
                                    sparseArray.put(R.id.tag_should_manage_visible, false);
                                }
                                if (z7) {
                                    sparseArray.put(R.id.tag_user_mute_visible, true);
                                    sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                                    if (postData.bfy() != null) {
                                        sparseArray.put(R.id.tag_user_mute_mute_userid, postData.bfy().getUserId());
                                        sparseArray.put(R.id.tag_user_mute_mute_username, postData.bfy().getUserName());
                                        sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.bfy().getName_show());
                                    }
                                    if (this.kIK.cYR() != null) {
                                        sparseArray.put(R.id.tag_user_mute_thread_id, this.kIK.cYR().getId());
                                    }
                                    sparseArray.put(R.id.tag_user_mute_post_id, postData.getId());
                                } else {
                                    sparseArray.put(R.id.tag_user_mute_visible, false);
                                }
                                if (z8) {
                                    sparseArray.put(R.id.tag_should_delete_visible, true);
                                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.kIK.cZg()));
                                    sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z6));
                                    sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i6));
                                    sparseArray.put(R.id.tag_del_post_id, postData.getId());
                                } else {
                                    sparseArray.put(R.id.tag_should_delete_visible, false);
                                }
                                nVar.kJU.setTag(sparseArray);
                                if (this.kJC) {
                                    nVar.kKp.setTag(sparseArray);
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
                        if (postData.dAD() == 1) {
                        }
                        if (z) {
                        }
                        if (z7) {
                        }
                        if (z8) {
                        }
                        nVar.kJU.setTag(sparseArray);
                        if (this.kJC) {
                        }
                    }
                }
            }
            boolean z15 = z11;
            z = z10;
            z2 = z15;
            if (this.kIK != null) {
                userId = this.kIK.cYR().bfy().getUserId();
                String userId32 = postData.bfy().getUserId();
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
            if (postData.dAD() == 1) {
            }
            if (z) {
            }
            if (z7) {
            }
            if (z8) {
            }
            nVar.kJU.setTag(sparseArray);
            if (this.kJC) {
            }
        }
    }

    private void f(n nVar, PostData postData) {
        if (nVar != null && postData != null && nVar.kKp != null && this.kIK != null) {
            if (this.kJC && !this.kIK.cZu()) {
                nVar.kKp.setVisibility(0);
                nVar.kKp.setOnClickListener(this.aTZ);
                return;
            }
            nVar.kKp.setVisibility(8);
        }
    }

    private void b(n nVar, PostData postData, boolean z) {
        if (nVar != null && postData != null && postData.bhp() != null) {
            postData.bhp().threadId = this.kKB.dah().dcf();
            postData.bhp().objType = 1;
            postData.bhp().isInPost = true;
            bw bwVar = null;
            if (this.kIK != null && this.kIK.cYR() != null) {
                bwVar = this.kIK.cYR();
            }
            if (z) {
                nVar.kKj.setAgreeAlone(true);
                nVar.kKj.setThreadData(bwVar);
                nVar.kKj.setData(postData.bhp());
            }
            if (bwVar != null && bwVar.bei()) {
                nVar.kJS.setAgreeAlone(true);
            }
            nVar.kJS.setThreadData(bwVar);
            nVar.kJS.setData(postData.bhp());
        }
    }

    private void g(n nVar, PostData postData) {
        boolean z;
        int i;
        int i2;
        if (nVar != null && postData != null) {
            if (postData.dAD() > 0 && this.kIK != null && !this.kIK.cZu()) {
                String format = String.format(this.mContext.getString(R.string.is_floor), Integer.valueOf(postData.dAD()));
                nVar.kKk.setVisibility(0);
                nVar.kKk.setText(format);
                z = true;
            } else {
                nVar.kKk.setVisibility(8);
                z = false;
            }
            com.baidu.tbadk.data.f dAG = postData.dAG();
            boolean z2 = (dAG == null || StringUtils.isNull(dAG.getName()) || this.kIK == null || this.kIK.cZu()) ? false : true;
            if (z) {
                nVar.kJP.setVisibility(0);
                i = this.iHo;
            } else {
                nVar.kJP.setVisibility(8);
                i = 0;
            }
            if (z2) {
                nVar.kJQ.setVisibility(0);
                i2 = this.iHo;
            } else {
                nVar.kJQ.setVisibility(8);
                i2 = 0;
            }
            nVar.kJO.setPadding(i, 0, i2, 0);
            if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                nVar.kJO.setText(com.baidu.tbadk.core.util.at.getFormatTimeShort(postData.getTime()));
            } else {
                nVar.kJO.setText(com.baidu.tbadk.core.util.at.getFormatTime(postData.getTime()));
            }
            if (z2) {
                nVar.kJR.setVisibility(0);
                nVar.kJR.setPadding(this.iHo, 0, 0, 0);
                if (postData.mpu) {
                    nVar.kJR.setText(com.baidu.tbadk.core.util.at.cutStringWithSuffix(dAG.getName(), 7, StringHelper.STRING_MORE));
                    return;
                } else {
                    nVar.kJR.setText(dAG.getName());
                    return;
                }
            }
            nVar.kJR.setVisibility(8);
        }
    }

    private void a(n nVar, PostData postData, View view) {
        if (nVar != null && postData != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) nVar.kJU.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44);
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds166);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            nVar.kJU.setPadding(0, 0, 0, 0);
            if (!this.kIL) {
                nVar.kJU.getLayoutStrategy().rw(R.drawable.icon_click);
            } else {
                nVar.kJU.Dr(null);
                nVar.kJU.setBackgroundDrawable(null);
                nVar.kJU.getLayoutStrategy().rw(R.drawable.transparent_bg);
            }
            nVar.kJU.getLayoutStrategy().rt(R.drawable.pic_video);
            a(nVar.kJU, view, !StringUtils.isNull(postData.getBimg_url()));
            nVar.kJU.setLayoutParams(layoutParams);
            nVar.kJU.setLinkTextColor(com.baidu.tbadk.core.util.ap.getColor(R.color.cp_link_tip_c));
            nVar.kJU.setIsFromCDN(this.mIsFromCDN);
            nVar.kJU.setText(postData.dAF(), true, this.kJA);
            SparseArray sparseArray = (SparseArray) nVar.kJU.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, false);
            nVar.kJU.setTag(sparseArray);
            nVar.kJM.setTag(R.id.tag_from, sparseArray);
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
            if (this.kJE) {
                tbRichTextView.getLayoutStrategy().ru(((equipmentWidth - dimensionPixelSize) * 2) / 3);
            } else {
                tbRichTextView.getLayoutStrategy().ru(equipmentWidth - dimensionPixelSize);
            }
            tbRichTextView.getLayoutStrategy().fhx = (equipmentWidth - dimensionPixelSize) - getDimensionPixelSize(R.dimen.tbds122);
            if (this.kJE) {
                tbRichTextView.getLayoutStrategy().rv((int) (((equipmentWidth * 1.618f) * 2.0f) / 3.0f));
            } else {
                tbRichTextView.getLayoutStrategy().rv((int) (equipmentWidth * 1.618f));
            }
        }
    }

    private void c(n nVar, PostData postData, View view, int i) {
        String string;
        if (nVar != null && postData != null) {
            if (postData.dAH() > 0) {
                nVar.kJZ.setVisibility(8);
            } else {
                SparseArray sparseArray = (SparseArray) nVar.kJZ.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    nVar.kJZ.setTag(sparseArray);
                }
                sparseArray.put(R.id.tag_load_sub_data, postData);
                if (postData.dAP() == 2) {
                    nVar.kJZ.setVisibility(8);
                } else if (this.kJC) {
                    nVar.kJW.setVisibility(8);
                } else {
                    nVar.kJZ.setVisibility(0);
                }
                nVar.kJY.setVisibility(8);
            }
            if (this.kJC) {
                if (com.baidu.tbadk.a.d.baL()) {
                    string = postData.dAH() > 0 ? String.valueOf(postData.dAH()) : TbadkCoreApplication.getInst().getString(R.string.reply);
                } else {
                    string = TbadkCoreApplication.getInst().getString(R.string.reply);
                }
                nVar.kKi.setText(string);
                if (nVar.kKd != null) {
                    SparseArray sparseArray2 = (SparseArray) nVar.kKd.getTag();
                    if (sparseArray2 == null) {
                        sparseArray2 = new SparseArray();
                        nVar.kKd.setTag(sparseArray2);
                    }
                    sparseArray2.put(R.id.tag_load_sub_data, postData);
                }
                if (nVar.kKc != null) {
                    SparseArray sparseArray3 = (SparseArray) nVar.kKc.getTag();
                    if (sparseArray3 == null) {
                        sparseArray3 = new SparseArray();
                        nVar.kKc.setTag(sparseArray3);
                    }
                    sparseArray3.put(R.id.tag_load_sub_data, postData);
                }
            } else {
                if (nVar.kKa != null) {
                    SparseArray sparseArray4 = (SparseArray) nVar.kKa.getTag();
                    if (sparseArray4 == null) {
                        sparseArray4 = new SparseArray();
                        nVar.kKa.setTag(sparseArray4);
                    }
                    sparseArray4.put(R.id.tag_load_sub_data, postData);
                }
                if (nVar.jcB != null) {
                    SparseArray sparseArray5 = (SparseArray) nVar.jcB.getTag();
                    if (sparseArray5 == null) {
                        sparseArray5 = new SparseArray();
                        nVar.jcB.setTag(sparseArray5);
                    }
                    sparseArray5.put(R.id.tag_load_sub_data, postData);
                }
            }
            if (postData.dAH() > 0 && !this.kJD) {
                nVar.kJY.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.sub_pb_load_more, Integer.valueOf(postData.dAH())));
                SparseArray sparseArray6 = (SparseArray) nVar.kJY.getTag();
                if (sparseArray6 == null) {
                    sparseArray6 = new SparseArray();
                    nVar.kJY.setTag(sparseArray6);
                }
                sparseArray6.put(R.id.tag_load_sub_data, postData);
                nVar.kJY.setVisibility(0);
                nVar.kJZ.setVisibility(8);
                nVar.kJX.setVisibility(8);
            } else {
                nVar.kJY.setVisibility(8);
                if (this.kJD) {
                    nVar.kJZ.setVisibility(8);
                }
                if (postData.dAH() > 0 && postData.dAA() != null && postData.dAA().size() > 0) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) nVar.kJX.getLayoutParams();
                    layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds10);
                    layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds166);
                    layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44);
                    layoutParams.bottomMargin = 0;
                    nVar.kJX.setLayoutParams(layoutParams);
                    if (this.kJB == null) {
                        this.kJB = new com.baidu.tieba.pb.pb.sub.b(this.mContext);
                        this.kJB.setIsFromCDN(this.mIsFromCDN);
                        this.kJB.setOnLongClickListener(this.mOnLongClickListener);
                        this.kJB.W(this.kIU);
                        this.kJB.A(this.aTZ);
                        String str = null;
                        if (this.kIK != null && this.kIK.cYR() != null && this.kIK.cYR().bfy() != null) {
                            str = this.kIK.cYR().bfy().getUserId();
                        }
                        boolean z = str != null && str.equals(TbadkCoreApplication.getCurrentAccount());
                        if (this.kIK != null) {
                            this.kJB.ad(this.kIK.cZg(), z);
                            this.kJB.setThreadData(this.kIK.cYR());
                        }
                    }
                    this.kJB.OA(postData.getId());
                    nVar.kJX.setSubPbAdapter(this.kJB);
                    nVar.kJX.setVisibility(0);
                    nVar.kJX.setData(postData, view);
                    nVar.kJX.setChildOnClickListener(this.aTZ);
                    nVar.kJX.setChildOnLongClickListener(this.mOnLongClickListener);
                    nVar.kJX.setChildOnTouchListener(this.kJF);
                } else {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) nVar.kJX.getLayoutParams();
                    layoutParams2.topMargin = 0;
                    layoutParams2.leftMargin = 0;
                    layoutParams2.rightMargin = 0;
                    layoutParams2.bottomMargin = 0;
                    nVar.kJX.setLayoutParams(layoutParams2);
                    nVar.kJX.setVisibility(8);
                }
            }
            if (postData.mpk) {
                nVar.mBottomLine.setVisibility(0);
            } else {
                nVar.mBottomLine.setVisibility(4);
            }
        }
    }

    private void h(n nVar, PostData postData) {
        if (nVar != null && nVar.kKu != null && nVar.kKr != null) {
            if (postData == null || postData.mpo == null || StringUtils.isNull(postData.mpo.liveTitle)) {
                nVar.kKr.setVisibility(8);
                return;
            }
            nVar.kKu.setText(postData.mpo.liveTitle);
            nVar.kKr.setTag(postData.mpo);
            nVar.kKr.setVisibility(0);
            com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c12639");
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                aqVar.dF("uid", TbadkCoreApplication.getCurrentAccount());
            }
            TiebaStatic.log(aqVar);
        }
    }

    private void i(n nVar, PostData postData) {
        if (nVar != null && postData != null) {
            nVar.kKz.setVisibility(postData.mpu ? 0 : 8);
        }
    }

    private void a(n nVar) {
        LayerDrawable layerDrawable;
        if (nVar != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (nVar.mSkinType != skinType) {
                com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.gZE, R.color.cp_cont_d, 1);
                if (nVar.kJN.getTag() instanceof Integer) {
                    com.baidu.tbadk.core.util.ap.setBackgroundResource(nVar.kJN, ((Integer) nVar.kJN.getTag()).intValue());
                } else if (nVar.kJN.getTag() instanceof String) {
                    if (nVar.kJN.getTag().equals("BA_ZHU_BG")) {
                        layerDrawable = this.ajl;
                    } else if (nVar.kJN.getTag().equals("XIAO_BA_ZHU_BG")) {
                        layerDrawable = this.ajm;
                    } else {
                        layerDrawable = nVar.kJN.getTag().equals("HOST") ? this.kHo : null;
                    }
                    if (layerDrawable != null && layerDrawable.getDrawable(1) != null) {
                        if (nVar.mSkinType == 1) {
                            layerDrawable.getDrawable(1).setAlpha(255);
                        } else {
                            layerDrawable.getDrawable(1).setAlpha(0);
                        }
                        nVar.kJN.setBackgroundDrawable(layerDrawable);
                    }
                }
                com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.kJO, R.color.cp_cont_d, 1);
                com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.kJP, R.color.cp_cont_d);
                com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.kJQ, R.color.cp_cont_d);
                com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.kKk, R.color.cp_cont_d, 1);
                com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.kJR, R.color.cp_cont_d, 1);
                nVar.kJU.setTextColor(com.baidu.tbadk.core.util.ap.getColor(R.color.cp_cont_b));
                com.baidu.tbadk.core.util.ap.c(nVar.kJX, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10), R.color.cp_bg_line_g, R.color.cp_bg_line_g);
                com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.kJY, R.color.cp_cont_c);
                nVar.kJY.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.ap.getDrawable(R.drawable.icon_pb_comment_more_n), (Drawable) null);
                com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.kJZ, R.color.cp_cont_c);
                if (this.kJC) {
                    SvgManager.bkl().a(nVar.kKp, R.drawable.ic_icon_pure_close24, R.color.cp_cont_g, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    SvgManager.bkl().a(nVar.kKh, R.drawable.icon_pure_pb_reply26_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    SvgManager.bkl().a(nVar.kKf, R.drawable.icon_pure_pb_share26_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    nVar.kKj.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                    com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.kKg, R.color.cp_cont_d);
                    com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.kKi, R.color.cp_cont_d);
                } else {
                    SvgManager.bkl().a(nVar.kKa, R.drawable.icon_pure_pb_reply26_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    SvgManager.bkl().a(nVar.jcB, R.drawable.icon_pure_pb_share26_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                }
                nVar.kJX.onChangeSkinType();
                nVar.kJV.onChangeSkinType();
                com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.kKu, R.color.cp_link_tip_c, 1);
                com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.kKs, R.color.cp_cont_f, 1);
                com.baidu.tbadk.core.util.ap.setBackgroundResource(nVar.kKr, R.color.cp_bg_line_e);
                com.baidu.tbadk.core.util.ap.setBackgroundResource(nVar.kKt, R.color.cp_cont_d);
                com.baidu.tbadk.core.util.ap.setImageResource(nVar.kKv, R.drawable.icon_arrow_more_gray);
                com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.kKy, R.color.cp_cont_c);
                if (nVar.kKw.getVisibility() == 8) {
                    nVar.kKy.setText(R.string.close_content);
                } else if (this.kIK != null && StringUtils.isNull(this.kIK.cZc())) {
                    nVar.kKy.setText(this.kIK.cZc());
                } else {
                    nVar.kKy.setText(R.string.expand_content);
                }
                nVar.kJS.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                nVar.CD(skinType);
                com.baidu.tbadk.core.util.ap.setBackgroundColor(nVar.mBottomLine, R.color.cp_bg_line_b);
            }
            nVar.mSkinType = skinType;
        }
    }

    private void b(final n nVar) {
        nVar.kJM.setOnTouchListener(this.kJF);
        nVar.kJM.setOnLongClickListener(this.mOnLongClickListener);
        if (this.kKB.dbM() != null && this.kKB.dbM().getPageContext() != null && this.kKB.dbM().getPageContext().getOrignalPage() != 0) {
            com.baidu.tieba.pb.pb.main.b.a aVar = this.kKB.dbM().kIj;
            nVar.gZE.setOnClickListener(aVar.hJr);
            nVar.kJT.setOnClickListener(aVar.hJr);
            nVar.kKm.setOnClickListener(aVar.hJr);
            nVar.kKm.getHeadView().setOnClickListener(aVar.hJr);
            nVar.kJU.setOnLongClickListener(this.mOnLongClickListener);
            nVar.kJU.setOnTouchListener(this.kJF);
            nVar.kJU.setCommonTextViewOnClickListener(this.aTZ);
            nVar.kJU.setOnImageClickListener(this.ffu);
            nVar.kJU.setOnImageTouchListener(this.kJF);
            nVar.kJU.setOnEmotionClickListener(aVar.kYp);
            nVar.kJU.setOnVoiceAfterClickListener(this.aTZ);
            nVar.kKq.setOnClickListener(this.aTZ);
            nVar.kKr.setOnClickListener(this.aTZ);
            nVar.kJY.setOnClickListener(this.aTZ);
            nVar.kJZ.setOnClickListener(this.aTZ);
            final com.baidu.tieba.pb.pb.main.b.c cVar = this.kKB.dbM().kIk;
            if (this.kJC) {
                nVar.kKd.setOnClickListener(this.aTZ);
                nVar.kKc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.m.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        final PostData postData;
                        if (view.getTag() instanceof SparseArray) {
                            SparseArray sparseArray = (SparseArray) view.getTag();
                            if ((sparseArray.get(R.id.tag_load_sub_data) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.tag_load_sub_data)) != null && nVar.kJM != null && cVar != null) {
                                com.baidu.adp.lib.f.e.mX().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.m.5.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        cVar.kYE.a(m.this.kIK, null, postData, nVar.kJU.getLayoutStrategy());
                                    }
                                }, 100L);
                                String threadId = m.this.kIK.getThreadId();
                                if ((StringUtils.isNull(threadId) || "0".equals(m.this.kIK.getThreadId())) && m.this.kIK.cYR() != null) {
                                    threadId = m.this.kIK.cYR().getNid();
                                }
                                TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13700").dF("tid", threadId).dF("fid", m.this.kIK.getForumId()).u("uid", TbadkCoreApplication.getCurrentAccountId()).dF("post_id", postData.getId()).ai("obj_type", 4));
                            }
                        }
                    }
                });
                nVar.kKj.eqE = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.m.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (view != null && m.this.kIK != null && nVar != null && nVar.kKj != null && nVar.kKj.getData() != null) {
                            int i = view == nVar.kKj.getImgAgree() ? 1 : 2;
                            String threadId = m.this.kIK.getThreadId();
                            if ((StringUtils.isNull(threadId) || "0".equals(m.this.kIK.getThreadId())) && m.this.kIK.cYR() != null) {
                                threadId = m.this.kIK.cYR().getNid();
                            }
                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13700").dF("tid", threadId).dF("fid", m.this.kIK.getForumId()).u("uid", TbadkCoreApplication.getCurrentAccountId()).dF("post_id", nVar.kKj.getData().postId).ai("obj_type", i));
                        }
                    }
                };
                return;
            }
            nVar.kKa.setOnClickListener(this.aTZ);
            nVar.jcB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.m.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    final PostData postData;
                    if (view.getTag() instanceof SparseArray) {
                        SparseArray sparseArray = (SparseArray) view.getTag();
                        if ((sparseArray.get(R.id.tag_load_sub_data) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.tag_load_sub_data)) != null && nVar.kJM != null && cVar != null) {
                            com.baidu.adp.lib.f.e.mX().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.m.7.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    cVar.kYE.a(m.this.kIK, null, postData, nVar.kJU.getLayoutStrategy());
                                }
                            }, 100L);
                            String threadId = m.this.kIK.getThreadId();
                            if ((StringUtils.isNull(threadId) || "0".equals(m.this.kIK.getThreadId())) && m.this.kIK.cYR() != null) {
                                threadId = m.this.kIK.cYR().getNid();
                            }
                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13700").dF("tid", threadId).dF("fid", m.this.kIK.getForumId()).u("uid", TbadkCoreApplication.getCurrentAccountId()).dF("post_id", postData.getId()).ai("obj_type", 4));
                        }
                    }
                }
            });
            nVar.kJS.eqE = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.m.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (view != null && m.this.kIK != null && nVar != null && nVar.kJS != null && nVar.kJS.getData() != null) {
                        int i = view == nVar.kJS.getImgAgree() ? 1 : 2;
                        String threadId = m.this.kIK.getThreadId();
                        if ((StringUtils.isNull(threadId) || "0".equals(m.this.kIK.getThreadId())) && m.this.kIK.cYR() != null) {
                            threadId = m.this.kIK.cYR().getNid();
                        }
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13700").dF("tid", threadId).dF("fid", m.this.kIK.getForumId()).u("uid", TbadkCoreApplication.getCurrentAccountId()).dF("post_id", nVar.kJS.getData().postId).ai("obj_type", i));
                    }
                }
            };
        }
    }

    private void uo() {
        this.ajl = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.e.a.b.bkM().oq(0).V(this.iHO).b("TL_BR", R.color.ba_zhu_start, R.color.ba_zhu_end).bkO(), com.baidu.tbadk.core.util.e.a.b.bkM().oq(0).V(this.iHO).AT("#4D000000").bkO()});
        this.ajm = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.e.a.b.bkM().oq(0).V(this.iHO).b("TL_BR", R.color.xiao_ba_zhu_start, R.color.xiao_ba_zhu_end).bkO(), com.baidu.tbadk.core.util.e.a.b.bkM().oq(0).V(this.iHO).AT("#4D000000").bkO()});
        this.kHo = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.e.a.b.bkM().oq(0).V(this.iHO).b("TL_BR", R.color.floor_host_start, R.color.floor_host_end).bkO(), com.baidu.tbadk.core.util.e.a.b.bkM().oq(0).V(this.iHO).AT("#4D000000").bkO()});
    }

    public void a(TbRichTextView.c cVar) {
        this.kJA = cVar;
    }

    public void setData(com.baidu.tieba.pb.data.f fVar) {
        this.kIK = fVar;
    }

    public void gY(String str) {
        this.bbv = str;
    }

    public void sM(boolean z) {
        this.kIL = z;
    }

    private SpannableStringBuilder dH(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new m.a(str, R.drawable.pic_smalldot_title));
            return com.baidu.tieba.card.m.a((Context) this.kKB.dbM(), str2, (ArrayList<m.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    private void c(n nVar) {
        nVar.kJU.setTextViewOnTouchListener(this.eHq);
        nVar.kJU.setTextViewCheckSelection(false);
    }

    public void S(View.OnClickListener onClickListener) {
        this.kIU = onClickListener;
    }

    public void A(View.OnClickListener onClickListener) {
        this.aTZ = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.ffu = iVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.eHq = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }
}
