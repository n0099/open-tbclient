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
/* loaded from: classes16.dex */
public class m extends o<PostData, n> implements View.OnClickListener {
    private int aED;
    private View.OnClickListener aRW;
    private int aYF;
    private String aYY;
    private LayerDrawable aiR;
    private LayerDrawable aiS;
    private com.baidu.tieba.pb.a.c eFj;
    private TbRichTextView.i fcC;
    private boolean ffN;
    private com.baidu.adp.lib.d.b<ConstrainImageLayout> hZr;
    private com.baidu.adp.lib.d.b<TbImageView> hZs;
    private int iAt;
    private int izT;
    protected com.baidu.tieba.pb.data.f kAn;
    private boolean kAo;
    private View.OnClickListener kAx;
    private TbRichTextView.c kBd;
    private com.baidu.tieba.pb.pb.sub.b kBe;
    private boolean kBf;
    private boolean kBg;
    private com.baidu.tieba.pb.a.c kBh;
    private int kyQ;
    private LayerDrawable kyR;
    private View.OnLongClickListener mOnLongClickListener;

    /* JADX INFO: Access modifiers changed from: private */
    public void cL(View view) {
        if (view != null && (view.getTag() instanceof n)) {
            n nVar = (n) view.getTag();
            if (this.kBf && nVar.kBL != null && nVar.kBL.getData() != null) {
                nVar.kBL.bkg();
            }
            if (nVar.kBu != null && nVar.kBu.getData() != null) {
                nVar.kBu.bkg();
            }
        }
    }

    public m(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId) {
        super(bVar, bdUniqueId);
        this.aYF = 0;
        this.izT = 0;
        this.kyQ = 0;
        this.iAt = 0;
        this.kBd = null;
        this.kAo = true;
        this.aYY = null;
        this.kAn = null;
        this.kAx = null;
        this.aRW = null;
        this.fcC = null;
        this.eFj = null;
        this.mOnLongClickListener = null;
        this.kBe = null;
        this.ffN = true;
        this.kBf = com.baidu.tbadk.a.d.baf();
        this.kBg = com.baidu.tbadk.a.d.bag();
        this.hZr = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.pb.pb.main.m.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: coC */
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
        this.hZs = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<TbImageView>() { // from class: com.baidu.tieba.pb.pb.main.m.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: blb */
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
        this.kBh = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.m.3
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean onDoubleTap(View view, MotionEvent motionEvent) {
                if (view != null && (m.this.kzA == null || m.this.kzA.cXu() == null || m.this.kzA.cXu().das())) {
                    if (view instanceof RelativeLayout) {
                        m.this.cL(view);
                    } else {
                        ViewParent parent = view.getParent();
                        int i = 0;
                        while (true) {
                            if (parent == null || i >= 10) {
                                break;
                            } else if (parent instanceof RelativeLayout) {
                                m.this.cL((RelativeLayout) parent);
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
                if (m.this.eFj != null) {
                    if (!(view instanceof TbListTextView) || m.this.aRW == null) {
                        m.this.eFj.X(view);
                        m.this.eFj.onSingleTapConfirmed(motionEvent);
                        return true;
                    }
                    m.this.aRW.onClick(view);
                    return true;
                }
                return true;
            }
        });
        if (bVar != null && bVar.cWE() != null) {
            this.aED = bVar.cWE().cZm();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cc */
    public n b(ViewGroup viewGroup) {
        n nVar = new n(this.kCd.cYj().getPageContext(), LayoutInflater.from(this.mContext).inflate(R.layout.pb_reply_floor_item_layout, viewGroup, false), this.aED, this.kBf, this.kBg);
        nVar.kBx.setConstrainLayoutPool(this.hZr);
        nVar.kBx.setImageViewPool(this.hZs);
        if (nVar.kBz != null) {
            nVar.kBz.setShowChildComment(this.kBg);
        }
        a(nVar);
        this.aYF = getDimensionPixelSize(R.dimen.tbds10);
        this.izT = getDimensionPixelSize(R.dimen.tbds14);
        this.kyQ = getDimensionPixelSize(R.dimen.tbds36);
        this.iAt = getDimensionPixelSize(R.dimen.tbds6);
        if (nVar.kBw != null) {
            nVar.kBw.setDuiEnabled(this.ffN);
        }
        ui();
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
            postData2.bfQ();
            i(postData2);
            a(nVar, postData2, view, i);
        }
        return view;
    }

    public void setDuiEnabled(boolean z) {
        this.ffN = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private void i(PostData postData) {
        if (postData != null) {
            int i = 8;
            if (postData.mfW) {
                i = 2;
            }
            com.baidu.tbadk.core.util.aq b = com.baidu.tieba.pb.c.a.b(this.kAn, postData, postData.locate, i, 6);
            postData.mfX = b;
            if (!com.baidu.tbadk.core.util.y.isEmpty(postData.dwH())) {
                Iterator<PostData> it = postData.dwH().iterator();
                while (it.hasNext()) {
                    it.next().mfX = b;
                }
            }
        }
    }

    private void a(n nVar, PostData postData, View view, int i) {
        if (nVar != null && postData != null) {
            if (this.kBf && this.kBg) {
                nVar.kBy.setVisibility(8);
                nVar.kBD.setVisibility(0);
            } else if (this.kBf) {
                nVar.kBD.setVisibility(0);
                nVar.kBy.setVisibility(0);
                nVar.kBC.setVisibility(8);
                nVar.iTV.setVisibility(8);
                nVar.kBu.setVisibility(8);
            } else {
                nVar.kBD.setVisibility(8);
                nVar.kBy.setVisibility(0);
                nVar.kBC.setVisibility(0);
                nVar.iTV.setVisibility(0);
                nVar.kBu.setVisibility(0);
            }
            b(nVar, postData, view, i);
            f(nVar, postData);
            b(nVar, postData, this.kBf);
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
        if (nVar != null && nVar.kBo != null) {
            if (this.kCd != null && this.kCd.cWE() != null && this.kCd.cWE().cZu() && com.baidu.tbadk.core.util.at.equals(this.kCd.cWE().cYB(), postData.getId())) {
                com.baidu.tbadk.core.util.ap.setBackgroundColor(nVar.kBo, R.color.cp_other_g);
            } else {
                com.baidu.tbadk.core.util.ap.setBackgroundColor(nVar.kBo, R.color.cp_bg_line_e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(n nVar, boolean z, String str) {
        if (z) {
            nVar.kBY.setVisibility(8);
            if (StringUtils.isNull(str)) {
                nVar.kCa.setText(R.string.expand_content);
                return;
            } else {
                nVar.kCa.setText(str);
                return;
            }
        }
        nVar.kBY.setVisibility(0);
        nVar.kCa.setText(R.string.close_content);
    }

    private void c(final n nVar, final PostData postData) {
        if (postData.dwW() == 2 || postData.dwW() == 4) {
            nVar.kBZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.m.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    boolean z = nVar.kBY.getVisibility() == 8;
                    m.this.a(nVar, !z, postData.cVx());
                    postData.wb(z ? false : true);
                    m.this.d(nVar, postData);
                    if (m.this.kzA != null && m.this.kzA.cXu() != null && m.this.kzA.cXu().dbu() != null && m.this.kzA.cXu().getListView() != null && !z && nVar.getView().getTop() < m.this.kzA.cXu().dbu().getMeasuredHeight()) {
                        m.this.kzA.cXu().getListView().setSelectionFromTop(com.baidu.tbadk.core.util.y.getPosition(m.this.kzA.cXu().getListView().getData(), postData) + m.this.kzA.cXu().getListView().getHeaderViewsCount(), m.this.kzA.cXu().dbu().getMeasuredHeight());
                    }
                }
            });
            nVar.kBZ.setVisibility(0);
            a(nVar, postData.dwF(), postData.cVx());
            a(true, nVar, postData);
        } else {
            nVar.kBZ.setVisibility(8);
            nVar.kBY.setVisibility(0);
            a(false, nVar, postData);
        }
        d(nVar, postData);
    }

    private void a(boolean z, n nVar, PostData postData) {
        if (nVar != null && nVar.mBottomLine != null && nVar.kBZ != null && (nVar.mBottomLine.getLayoutParams() instanceof RelativeLayout.LayoutParams) && (nVar.kBZ.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            boolean z2 = !com.baidu.tbadk.core.util.y.isEmpty(postData.dwH());
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) nVar.mBottomLine.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) nVar.kBZ.getLayoutParams();
            if (z) {
                nVar.kBw.getLayoutStrategy().rl(0);
                if (z2) {
                    nVar.kBw.getLayoutStrategy().rk(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
                    if (layoutParams2 != null) {
                        layoutParams2.topMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds26);
                    }
                } else {
                    nVar.kBw.getLayoutStrategy().rk(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds8));
                    if (layoutParams2 != null) {
                        layoutParams2.topMargin = 0;
                    }
                }
                nVar.kBZ.setLayoutParams(layoutParams2);
                if (layoutParams != null) {
                    layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44);
                    nVar.mBottomLine.setLayoutParams(layoutParams);
                    return;
                }
                return;
            }
            nVar.kBw.getLayoutStrategy().rk(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
            nVar.kBw.getLayoutStrategy().rl(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds12));
            if (layoutParams != null) {
                if (this.kBf) {
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
        TbRichText dwM = postData.dwM();
        dwM.isChanged = true;
        nVar.kBw.setText(dwM, true, this.kBd);
    }

    private void j(PostData postData) {
        if (postData.ecC == 0 && postData.ibQ) {
            com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c12203");
            aqVar.dD("post_id", postData.getId());
            aqVar.dD("uid", TbadkCoreApplication.getCurrentAccount());
            aqVar.dD("cuid", TbadkCoreApplication.getInst().getCuid());
            aqVar.dD("cuid_galaxy2", TbadkCoreApplication.getInst().getCuidGalaxy2());
            aqVar.dD("c3_aid", TbadkCoreApplication.getInst().getCuidGalaxy3());
            aqVar.dD("cuid_gid", TbadkCoreApplication.getInst().getCuidGid());
            aqVar.u(TiebaInitialize.Params.EXPOSURE_TIME, System.currentTimeMillis());
            if (this.kCd != null) {
                int cZm = this.kCd.cWE().cZm();
                if (1 == cZm || 2 == cZm) {
                    aqVar.dD("obj_source", "1");
                } else if (3 == cZm) {
                    aqVar.dD("obj_source", "2");
                } else {
                    aqVar.dD("obj_source", "0");
                }
            }
            TiebaStatic.log(aqVar);
            if (postData.beE() != null && postData.beE().getAlaInfo() != null && postData.beE().getAlaInfo().live_status == 1) {
                k(postData);
            }
        }
    }

    private void k(PostData postData) {
        String userId = postData.beE().getUserId();
        String forumId = this.kAn != null ? this.kAn.getForumId() : "";
        String forumName = this.kAn != null ? this.kAn.getForumName() : "";
        int dwK = postData.dwK();
        String id = postData.getId();
        com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c13714");
        aqVar.dD("fid", forumId);
        aqVar.dD("fname", forumName);
        aqVar.dD("obj_param1", userId);
        aqVar.dD("uid", TbadkCoreApplication.getCurrentAccount());
        aqVar.dD("tid", id);
        aqVar.ai(TiebaInitialize.Params.OBJ_PARAM2, dwK);
        TiebaStatic.log(aqVar);
    }

    private void l(PostData postData) {
        if (this.kAn != null) {
            if (this.kAn.cVM()) {
                if (this.kCe != null) {
                    com.baidu.tieba.pb.c.a.a(this.kCe.getUniqueId(), this.kAn, postData, postData.locate, postData.mfW ? 2 : 8);
                }
            } else if (this.kzA != null) {
                com.baidu.tieba.pb.c.a.a(this.kzA.getUniqueId(), this.kAn, postData, postData.locate, postData.mfW ? 2 : 8);
            }
        }
    }

    private void a(n nVar, PostData postData) {
        if (postData == null || postData.ddk() == null) {
            nVar.kBS.setVisibility(8);
            return;
        }
        TbRichText dwM = postData.dwM();
        com.baidu.tieba.pb.view.b.a(postData.ddk(), nVar.kBS, false, false, dwM != null && StringUtils.isNull(dwM.toString()) && StringUtils.isNull(postData.getBimg_url()));
    }

    private void e(n nVar, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.kAo) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) nVar.kBw.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            nVar.kBw.setLayoutParams(layoutParams);
            nVar.kBw.setPadding(0, 0, 0, 0);
            nVar.kBw.CV(null);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) nVar.kBw.getLayoutParams();
            layoutParams2.topMargin = getDimensionPixelSize(R.dimen.ds20);
            layoutParams2.bottomMargin = getDimensionPixelSize(R.dimen.ds20);
            nVar.kBw.setLayoutParams(layoutParams2);
            nVar.kBw.CV(postData.getBimg_url());
        }
        nVar.kBw.setTextViewOnTouchListener(this.kBh);
        nVar.kBw.setTextViewCheckSelection(false);
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
            if (postData.beE() == null || postData.beE().isBaijiahaoUser()) {
            }
            if (postData.mfN) {
                com.baidu.tbadk.core.util.ap.setBackgroundColor(nVar.mTopLine, R.color.cp_bg_line_c);
                nVar.mTopLine.setVisibility(0);
            } else {
                nVar.mTopLine.setVisibility(8);
            }
            nVar.kBv.setTag(null);
            nVar.kBv.setUserId(null);
            nVar.gVX.setText((CharSequence) null);
            nVar.kBO.getHeadView().setUserId(null);
            nVar.kBw.setIsHost(false);
            if (postData.beE() != null) {
                if (this.aYY != null && !this.aYY.equals("0") && this.aYY.equals(postData.beE().getUserId())) {
                    nVar.kBw.setIsHost(true);
                }
                ArrayList<IconData> iconInfo = postData.beE().getIconInfo();
                ArrayList<IconData> tShowInfoNew = postData.beE().getTShowInfoNew();
                if (nVar.kBQ != null) {
                    nVar.kBQ.setTag(R.id.tag_user_id, postData.beE().getUserId());
                    if (this.kCd != null && this.kCd.cYj() != null) {
                        nVar.kBQ.setOnClickListener(this.kCd.cYj().kzM.kPL);
                    }
                    nVar.kBQ.a(iconInfo, 2, this.kyQ, this.kyQ, this.aYF);
                }
                if (nVar.kBP != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        nVar.kBP.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    if (this.kCd != null && this.kCd.cYj() != null) {
                        nVar.kBP.setOnClickListener(this.kCd.cYj().kzM.kPM);
                    }
                    nVar.kBP.a(tShowInfoNew, 3, this.kyQ, this.kyQ, this.aYF, true);
                }
                if (!com.baidu.tbadk.core.util.y.isEmpty(tShowInfoNew) || postData.beE().isBigV()) {
                    com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.gVX, R.color.cp_cont_h, 1);
                } else {
                    com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.gVX, R.color.cp_cont_j, 1);
                }
                String avater = postData.beE().getAvater();
                int i2 = 8;
                if (postData.mfW) {
                    i2 = 2;
                }
                nVar.gVX.setTag(R.id.tag_user_id, postData.beE().getUserId());
                nVar.gVX.setTag(R.id.tag_user_name, postData.beE().getUserName());
                nVar.gVX.setTag(R.id.tag_virtual_user_url, postData.beE().getVirtualUserUrl());
                nVar.gVX.setTag(R.id.tag_statistic_item, com.baidu.tieba.pb.c.a.b(this.kAn, postData, postData.locate, i2, 2));
                String name_show = postData.beE().getName_show();
                String userName = postData.beE().getUserName();
                if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                    nVar.gVX.setText(com.baidu.tieba.pb.c.aN(this.mContext, nVar.gVX.getText().toString()));
                    nVar.gVX.setGravity(16);
                    nVar.gVX.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.cUW());
                    com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.gVX, R.color.cp_other_f, 1);
                }
                if (postData.beE().getPendantData() != null && !StringUtils.isNull(postData.beE().getPendantData().bcA())) {
                    nVar.kBO.setBigVDimenSize(R.dimen.tbds32);
                    nVar.kBO.a(postData.beE(), 4);
                    nVar.kBv.setVisibility(8);
                    nVar.kBO.setVisibility(0);
                    nVar.kBO.getHeadView().startLoad(avater, 28, false);
                    nVar.kBO.getHeadView().setUserId(postData.beE().getUserId());
                    nVar.kBO.getHeadView().setUserName(postData.beE().getUserName());
                    nVar.kBO.getHeadView().setFid(this.kAn != null ? this.kAn.getForumId() : "");
                    nVar.kBO.getHeadView().setFName(this.kAn != null ? this.kAn.getForumName() : "");
                    nVar.kBO.getHeadView().setFloor(postData.dwK());
                    nVar.kBO.getHeadView().setTid(postData.getId());
                    nVar.kBO.getHeadView().setTag(R.id.tag_statistic_item, com.baidu.tieba.pb.c.a.b(this.kAn, postData, postData.locate, i2, 2));
                    nVar.kBO.AA(postData.beE().getPendantData().bcA());
                } else {
                    nVar.kBv.setGodIconWidth(R.dimen.tbds32);
                    UtilHelper.showHeadImageViewBigV(nVar.kBv, postData.beE(), 4);
                    nVar.kBv.setUserId(postData.beE().getUserId());
                    nVar.kBv.setFid(this.kAn != null ? this.kAn.getForumId() : "");
                    nVar.kBv.setFName(this.kAn != null ? this.kAn.getForumName() : "");
                    nVar.kBv.setFloor(postData.dwK());
                    nVar.kBv.setTid(postData.getId());
                    nVar.kBv.setUserName(postData.beE().getUserName(), postData.dwU());
                    nVar.kBv.setTag(R.id.tag_virtual_user_url, postData.beE().getVirtualUserUrl());
                    nVar.kBv.setTag(R.id.tag_statistic_item, com.baidu.tieba.pb.c.a.b(this.kAn, postData, postData.locate, i2, 2));
                    nVar.kBv.setImageDrawable(null);
                    nVar.kBv.startLoad(avater, 28, false);
                    nVar.kBv.setVisibility(0);
                    nVar.kBO.setVisibility(8);
                }
                if (postData.beE() != null && postData.beE().getAlaInfo() != null && postData.beE().getAlaUserData() != null && postData.beE().getAlaUserData().live_status == 1) {
                    nVar.rv(true);
                    nVar.kBv.setLiveStatus(1);
                    nVar.kBv.setAlaInfo(postData.beE().getAlaInfo());
                    nVar.kBO.getHeadView().setLiveStatus(1);
                    nVar.kBO.getHeadView().setAlaInfo(postData.beE().getAlaInfo());
                } else {
                    nVar.rv(false);
                    nVar.kBv.setLiveStatus(0);
                    nVar.kBv.setAlaInfo(null);
                    nVar.kBO.getHeadView().setLiveStatus(0);
                    nVar.kBO.getHeadView().setAlaInfo(null);
                }
                if (this.kAn != null && this.kAn.cVP()) {
                    nVar.kBp.setVisibility(8);
                    nVar.kBp.setTag(null);
                } else if (postData.beE() != null) {
                    MetaData beE = postData.beE();
                    com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.kBp, R.color.cp_cont_a);
                    if (this.aYY != null && !this.aYY.equals("0") && this.aYY.equals(beE.getUserId())) {
                        nVar.kBp.setTag("HOST");
                        if (nVar.mSkinType == 1) {
                            if (this.kyR.getDrawable(1) != null) {
                                this.kyR.getDrawable(1).setAlpha(255);
                            }
                        } else if (this.kyR.getDrawable(1) != null) {
                            this.kyR.getDrawable(1).setAlpha(0);
                        }
                        nVar.kBp.setBackgroundDrawable(this.kyR);
                        nVar.kBp.setVisibility(0);
                        nVar.kBp.setText(R.string.host_name);
                    } else if (beE.getIs_bawu() == 1 && postData.dwC()) {
                        int i3 = R.drawable.brand_official_btn;
                        com.baidu.tbadk.core.util.ap.setBackgroundResource(nVar.kBp, i3);
                        nVar.kBp.setTag(Integer.valueOf(i3));
                        nVar.kBp.setVisibility(0);
                        nVar.kBp.setText(R.string.brand_Official);
                    } else if (beE.getIs_bawu() == 1 && Config.BAWU_TYPE_MANAGER.equals(beE.getBawu_type())) {
                        nVar.kBp.setTag("BA_ZHU_BG");
                        if (nVar.mSkinType == 1) {
                            if (this.aiR.getDrawable(1) != null) {
                                this.aiR.getDrawable(1).setAlpha(255);
                            }
                        } else if (this.aiR.getDrawable(1) != null) {
                            this.aiR.getDrawable(1).setAlpha(0);
                        }
                        nVar.kBp.setBackgroundDrawable(this.aiR);
                        nVar.kBp.setVisibility(0);
                        nVar.kBp.setText(R.string.bawu_member_bazhu_tip);
                    } else if (beE.getIs_bawu() == 1 && Config.BAWU_TYPE_ASSIST.equals(beE.getBawu_type())) {
                        nVar.kBp.setTag("XIAO_BA_ZHU_BG");
                        if (nVar.mSkinType == 1) {
                            if (this.aiS.getDrawable(1) != null) {
                                this.aiS.getDrawable(1).setAlpha(255);
                            }
                        } else if (this.aiS.getDrawable(1) != null) {
                            this.aiS.getDrawable(1).setAlpha(0);
                        }
                        nVar.kBp.setBackgroundDrawable(this.aiS);
                        nVar.kBp.setVisibility(0);
                        nVar.kBp.setText(R.string.bawu_member_xbazhu_tip);
                    } else if (beE.getIs_bawu() == 1 && "pri_content_assist".equals(beE.getBawu_type())) {
                        int nS = com.baidu.tbadk.core.util.ap.nS(R.drawable.bg_user_identity_btn);
                        com.baidu.tbadk.core.util.ap.setBackgroundResource(nVar.kBp, nS);
                        nVar.kBp.setTag(Integer.valueOf(nS));
                        nVar.kBp.setVisibility(0);
                        nVar.kBp.setText(R.string.bawu_content_assist_tip);
                    } else if (beE.getIs_bawu() == 1 && "pri_manage_assist".equals(beE.getBawu_type())) {
                        int nS2 = com.baidu.tbadk.core.util.ap.nS(R.drawable.bg_user_identity_btn);
                        com.baidu.tbadk.core.util.ap.setBackgroundResource(nVar.kBp, nS2);
                        nVar.kBp.setTag(Integer.valueOf(nS2));
                        nVar.kBp.setVisibility(0);
                        nVar.kBp.setText(R.string.bawu_manage_assist_tip);
                    } else {
                        nVar.kBp.setVisibility(8);
                        nVar.kBp.setTag(null);
                    }
                } else {
                    nVar.kBp.setVisibility(8);
                    nVar.kBp.setTag(null);
                }
            }
            int i4 = 0;
            if (this.kCd != null && this.kCd.cYj() != null && this.kCd.cYj().cWu() && postData.beE() != null) {
                i4 = postData.beE().getLevel_id();
            }
            if (this.kAn != null && this.kAn.cVP()) {
                i4 = 0;
            }
            if (i4 > 0) {
                nVar.kBN.setVisibility(0);
                com.baidu.tbadk.core.util.ap.setImageResource(nVar.kBN, BitmapHelper.getGradeResourceIdInEnterForum(i4));
            } else {
                nVar.kBN.setVisibility(8);
            }
            int i5 = 15;
            if (nVar.kBQ.getChildCount() == 1) {
                i5 = 13;
            } else if (nVar.kBQ.getChildCount() > 1) {
                i5 = 11;
            }
            if (nVar.kBp.getVisibility() == 0) {
                i5 -= 2;
            }
            if (nVar.kBP.getChildCount() > 0) {
                i5 -= 2;
            }
            if (postData.bgd() > 1000) {
                i5 -= 2;
            }
            if (postData.bgd() > 10) {
                i5 -= 2;
            }
            if (i5 < 10) {
                nVar.kBQ.setVisibility(8);
                if (nVar.kBQ.getChildCount() == 1) {
                    i5 += 2;
                } else if (nVar.kBQ.getChildCount() > 1) {
                    i5 += 4;
                }
                if (i5 < 10 && nVar.kBp.getVisibility() == 0) {
                    i5 += 2;
                    nVar.kBp.setVisibility(8);
                }
                if (i5 < 10 && nVar.kBN.getVisibility() == 0) {
                    i5 += 2;
                    nVar.kBN.setVisibility(8);
                }
            }
            String name_show2 = postData.beE() != null ? postData.beE().getName_show() : "";
            int textLengthWithEmoji = com.baidu.tbadk.util.ae.getTextLengthWithEmoji(name_show2);
            if (postData.beE() != null && !StringUtils.isNull(postData.beE().getSealPrefix())) {
                if (textLengthWithEmoji > i5 - 2) {
                    name_show2 = com.baidu.tbadk.util.ae.subStringWithEmoji(name_show2, i5 - 2) + StringHelper.STRING_MORE;
                }
            } else if (textLengthWithEmoji > i5) {
                name_show2 = com.baidu.tbadk.util.ae.subStringWithEmoji(name_show2, i5) + StringHelper.STRING_MORE;
            }
            if (postData.beE() != null && !StringUtils.isNull(postData.beE().getSealPrefix())) {
                nVar.gVX.setText(dF(postData.beE().getSealPrefix(), name_show2));
            } else {
                nVar.gVX.setText(name_show2);
            }
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_load_sub_data, postData);
            sparseArray.put(R.id.tag_load_sub_view, view);
            sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(postData.dwK()));
            sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
            boolean z9 = false;
            if (postData.beE() != null && !StringUtils.isNull(postData.beE().getVirtualUserUrl())) {
                z9 = true;
            }
            boolean z10 = false;
            boolean z11 = false;
            boolean z12 = false;
            if (this.kAn != null && this.kAn.cVB() != 0) {
                if (this.kAn.cVB() != 1002 && this.kAn.cVB() != 3) {
                    z10 = true;
                }
                if (this.kAn.cVB() != 3 && !this.kAn.cVP()) {
                    z11 = true;
                }
                if (postData != null && postData.beE() != null) {
                    String userId2 = postData.beE().getUserId();
                    if (UtilHelper.isCurrentAccount(userId2)) {
                        z10 = false;
                    }
                    if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                        boolean z13 = z11;
                        z = false;
                        z2 = z13;
                        if (this.kAn != null && this.kAn.cVm() != null && this.kAn.cVm().beE() != null && postData.beE() != null) {
                            userId = this.kAn.cVm().beE().getUserId();
                            String userId3 = postData.beE().getUserId();
                            if (UtilHelper.isCurrentAccount(userId)) {
                                z3 = true;
                                z4 = true;
                                if (UtilHelper.isCurrentAccount(userId3)) {
                                    z4 = false;
                                    z12 = true;
                                }
                                if (postData == null && postData.beE() != null && UtilHelper.isCurrentAccount(postData.beE().getUserId())) {
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
                                if (postData.dwK() == 1) {
                                    i6 = 0;
                                }
                                if (z) {
                                    sparseArray.put(R.id.tag_should_manage_visible, true);
                                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.kAn.cVB()));
                                    if (postData.beE() != null) {
                                        sparseArray.put(R.id.tag_forbid_user_name, postData.beE().getUserName());
                                        sparseArray.put(R.id.tag_forbid_user_name_show, postData.beE().getName_show());
                                        sparseArray.put(R.id.tag_forbid_user_portrait, postData.beE().getPortrait());
                                    }
                                } else {
                                    sparseArray.put(R.id.tag_should_manage_visible, false);
                                }
                                if (z7) {
                                    sparseArray.put(R.id.tag_user_mute_visible, true);
                                    sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                                    if (postData.beE() != null) {
                                        sparseArray.put(R.id.tag_user_mute_mute_userid, postData.beE().getUserId());
                                        sparseArray.put(R.id.tag_user_mute_mute_username, postData.beE().getUserName());
                                        sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.beE().getName_show());
                                    }
                                    if (this.kAn.cVm() != null) {
                                        sparseArray.put(R.id.tag_user_mute_thread_id, this.kAn.cVm().getId());
                                    }
                                    sparseArray.put(R.id.tag_user_mute_post_id, postData.getId());
                                } else {
                                    sparseArray.put(R.id.tag_user_mute_visible, false);
                                }
                                if (z8) {
                                    sparseArray.put(R.id.tag_should_delete_visible, true);
                                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.kAn.cVB()));
                                    sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z6));
                                    sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i6));
                                    sparseArray.put(R.id.tag_del_post_id, postData.getId());
                                } else {
                                    sparseArray.put(R.id.tag_should_delete_visible, false);
                                }
                                nVar.kBw.setTag(sparseArray);
                                if (this.kBf) {
                                    nVar.kBR.setTag(sparseArray);
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
                        if (postData.dwK() == 1) {
                        }
                        if (z) {
                        }
                        if (z7) {
                        }
                        if (z8) {
                        }
                        nVar.kBw.setTag(sparseArray);
                        if (this.kBf) {
                        }
                    }
                }
            }
            boolean z15 = z11;
            z = z10;
            z2 = z15;
            if (this.kAn != null) {
                userId = this.kAn.cVm().beE().getUserId();
                String userId32 = postData.beE().getUserId();
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
            if (postData.dwK() == 1) {
            }
            if (z) {
            }
            if (z7) {
            }
            if (z8) {
            }
            nVar.kBw.setTag(sparseArray);
            if (this.kBf) {
            }
        }
    }

    private void f(n nVar, PostData postData) {
        if (nVar != null && postData != null && nVar.kBR != null && this.kAn != null) {
            if (this.kBf && !this.kAn.cVP()) {
                nVar.kBR.setVisibility(0);
                nVar.kBR.setOnClickListener(this.aRW);
                return;
            }
            nVar.kBR.setVisibility(8);
        }
    }

    private void b(n nVar, PostData postData, boolean z) {
        if (nVar != null && postData != null && postData.bgv() != null) {
            postData.bgv().threadId = this.kCd.cWE().cYC();
            postData.bgv().objType = 1;
            postData.bgv().isInPost = true;
            bw bwVar = null;
            if (this.kAn != null && this.kAn.cVm() != null) {
                bwVar = this.kAn.cVm();
            }
            if (z) {
                nVar.kBL.setAgreeAlone(true);
                nVar.kBL.setThreadData(bwVar);
                nVar.kBL.setData(postData.bgv());
            }
            if (bwVar != null && bwVar.bdo()) {
                nVar.kBu.setAgreeAlone(true);
            }
            nVar.kBu.setThreadData(bwVar);
            nVar.kBu.setData(postData.bgv());
        }
    }

    private void g(n nVar, PostData postData) {
        boolean z;
        int i;
        int i2;
        if (nVar != null && postData != null) {
            if (postData.dwK() > 0 && this.kAn != null && !this.kAn.cVP()) {
                String format = String.format(this.mContext.getString(R.string.is_floor), Integer.valueOf(postData.dwK()));
                nVar.kBM.setVisibility(0);
                nVar.kBM.setText(format);
                z = true;
            } else {
                nVar.kBM.setVisibility(8);
                z = false;
            }
            com.baidu.tbadk.data.f dwN = postData.dwN();
            boolean z2 = (dwN == null || StringUtils.isNull(dwN.getName()) || this.kAn == null || this.kAn.cVP()) ? false : true;
            if (z) {
                nVar.kBr.setVisibility(0);
                i = this.izT;
            } else {
                nVar.kBr.setVisibility(8);
                i = 0;
            }
            if (z2) {
                nVar.kBs.setVisibility(0);
                i2 = this.izT;
            } else {
                nVar.kBs.setVisibility(8);
                i2 = 0;
            }
            nVar.kBq.setPadding(i, 0, i2, 0);
            if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                nVar.kBq.setText(com.baidu.tbadk.core.util.at.getFormatTimeShort(postData.getTime()));
            } else {
                nVar.kBq.setText(com.baidu.tbadk.core.util.at.getFormatTime(postData.getTime()));
            }
            if (z2) {
                nVar.kBt.setVisibility(0);
                nVar.kBt.setPadding(this.izT, 0, 0, 0);
                if (postData.mfV) {
                    nVar.kBt.setText(com.baidu.tbadk.core.util.at.cutStringWithSuffix(dwN.getName(), 7, StringHelper.STRING_MORE));
                    return;
                } else {
                    nVar.kBt.setText(dwN.getName());
                    return;
                }
            }
            nVar.kBt.setVisibility(8);
        }
    }

    private void a(n nVar, PostData postData, View view) {
        if (nVar != null && postData != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) nVar.kBw.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44);
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds166);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            nVar.kBw.setPadding(0, 0, 0, 0);
            if (!this.kAo) {
                nVar.kBw.getLayoutStrategy().rf(R.drawable.icon_click);
            } else {
                nVar.kBw.CV(null);
                nVar.kBw.setBackgroundDrawable(null);
                nVar.kBw.getLayoutStrategy().rf(R.drawable.transparent_bg);
            }
            nVar.kBw.getLayoutStrategy().rc(R.drawable.pic_video);
            a(nVar.kBw, view, !StringUtils.isNull(postData.getBimg_url()));
            nVar.kBw.setLayoutParams(layoutParams);
            nVar.kBw.setLinkTextColor(com.baidu.tbadk.core.util.ap.getColor(R.color.cp_link_tip_c));
            nVar.kBw.setIsFromCDN(this.mIsFromCDN);
            nVar.kBw.setText(postData.dwM(), true, this.kBd);
            SparseArray sparseArray = (SparseArray) nVar.kBw.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, false);
            nVar.kBw.setTag(sparseArray);
            nVar.kBo.setTag(R.id.tag_from, sparseArray);
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
            tbRichTextView.getLayoutStrategy().rd(equipmentWidth - dimensionPixelSize);
            tbRichTextView.getLayoutStrategy().feF = (equipmentWidth - dimensionPixelSize) - getDimensionPixelSize(R.dimen.tbds122);
            tbRichTextView.getLayoutStrategy().re((int) (equipmentWidth * 1.618f));
        }
    }

    private void c(n nVar, PostData postData, View view, int i) {
        String string;
        if (nVar != null && postData != null) {
            if (postData.dwO() > 0) {
                nVar.kBB.setVisibility(8);
            } else {
                SparseArray sparseArray = (SparseArray) nVar.kBB.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    nVar.kBB.setTag(sparseArray);
                }
                sparseArray.put(R.id.tag_load_sub_data, postData);
                if (postData.dwW() == 2) {
                    nVar.kBB.setVisibility(8);
                } else if (this.kBf) {
                    nVar.kBy.setVisibility(8);
                } else {
                    nVar.kBB.setVisibility(0);
                }
                nVar.kBA.setVisibility(8);
            }
            if (this.kBf) {
                if (com.baidu.tbadk.a.d.aZW()) {
                    string = postData.dwO() > 0 ? String.valueOf(postData.dwO()) : TbadkCoreApplication.getInst().getString(R.string.reply);
                } else {
                    string = TbadkCoreApplication.getInst().getString(R.string.reply);
                }
                nVar.kBK.setText(string);
                if (nVar.kBF != null) {
                    SparseArray sparseArray2 = (SparseArray) nVar.kBF.getTag();
                    if (sparseArray2 == null) {
                        sparseArray2 = new SparseArray();
                        nVar.kBF.setTag(sparseArray2);
                    }
                    sparseArray2.put(R.id.tag_load_sub_data, postData);
                }
                if (nVar.kBE != null) {
                    SparseArray sparseArray3 = (SparseArray) nVar.kBE.getTag();
                    if (sparseArray3 == null) {
                        sparseArray3 = new SparseArray();
                        nVar.kBE.setTag(sparseArray3);
                    }
                    sparseArray3.put(R.id.tag_load_sub_data, postData);
                }
            } else {
                if (nVar.kBC != null) {
                    SparseArray sparseArray4 = (SparseArray) nVar.kBC.getTag();
                    if (sparseArray4 == null) {
                        sparseArray4 = new SparseArray();
                        nVar.kBC.setTag(sparseArray4);
                    }
                    sparseArray4.put(R.id.tag_load_sub_data, postData);
                }
                if (nVar.iTV != null) {
                    SparseArray sparseArray5 = (SparseArray) nVar.iTV.getTag();
                    if (sparseArray5 == null) {
                        sparseArray5 = new SparseArray();
                        nVar.iTV.setTag(sparseArray5);
                    }
                    sparseArray5.put(R.id.tag_load_sub_data, postData);
                }
            }
            if (postData.dwO() > 0 && !this.kBg) {
                nVar.kBA.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.sub_pb_load_more, Integer.valueOf(postData.dwO())));
                SparseArray sparseArray6 = (SparseArray) nVar.kBA.getTag();
                if (sparseArray6 == null) {
                    sparseArray6 = new SparseArray();
                    nVar.kBA.setTag(sparseArray6);
                }
                sparseArray6.put(R.id.tag_load_sub_data, postData);
                nVar.kBA.setVisibility(0);
                nVar.kBB.setVisibility(8);
                nVar.kBz.setVisibility(8);
            } else {
                nVar.kBA.setVisibility(8);
                if (this.kBg) {
                    nVar.kBB.setVisibility(8);
                }
                if (postData.dwO() > 0 && postData.dwH() != null && postData.dwH().size() > 0) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) nVar.kBz.getLayoutParams();
                    layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds10);
                    layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds166);
                    layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44);
                    layoutParams.bottomMargin = 0;
                    nVar.kBz.setLayoutParams(layoutParams);
                    if (this.kBe == null) {
                        this.kBe = new com.baidu.tieba.pb.pb.sub.b(this.mContext);
                        this.kBe.setIsFromCDN(this.mIsFromCDN);
                        this.kBe.setOnLongClickListener(this.mOnLongClickListener);
                        this.kBe.W(this.kAx);
                        this.kBe.A(this.aRW);
                        String str = null;
                        if (this.kAn != null && this.kAn.cVm() != null && this.kAn.cVm().beE() != null) {
                            str = this.kAn.cVm().beE().getUserId();
                        }
                        boolean z = str != null && str.equals(TbadkCoreApplication.getCurrentAccount());
                        if (this.kAn != null) {
                            this.kBe.ac(this.kAn.cVB(), z);
                            this.kBe.setThreadData(this.kAn.cVm());
                        }
                    }
                    this.kBe.NZ(postData.getId());
                    nVar.kBz.setSubPbAdapter(this.kBe);
                    nVar.kBz.setVisibility(0);
                    nVar.kBz.setData(postData, view);
                    nVar.kBz.setChildOnClickListener(this.aRW);
                    nVar.kBz.setChildOnLongClickListener(this.mOnLongClickListener);
                    nVar.kBz.setChildOnTouchListener(this.kBh);
                } else {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) nVar.kBz.getLayoutParams();
                    layoutParams2.topMargin = 0;
                    layoutParams2.leftMargin = 0;
                    layoutParams2.rightMargin = 0;
                    layoutParams2.bottomMargin = 0;
                    nVar.kBz.setLayoutParams(layoutParams2);
                    nVar.kBz.setVisibility(8);
                }
            }
            if (postData.mfL) {
                nVar.mBottomLine.setVisibility(0);
            } else {
                nVar.mBottomLine.setVisibility(4);
            }
        }
    }

    private void h(n nVar, PostData postData) {
        if (nVar != null && nVar.kBW != null && nVar.kBT != null) {
            if (postData == null || postData.mfP == null || StringUtils.isNull(postData.mfP.liveTitle)) {
                nVar.kBT.setVisibility(8);
                return;
            }
            nVar.kBW.setText(postData.mfP.liveTitle);
            nVar.kBT.setTag(postData.mfP);
            nVar.kBT.setVisibility(0);
            com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c12639");
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                aqVar.dD("uid", TbadkCoreApplication.getCurrentAccount());
            }
            TiebaStatic.log(aqVar);
        }
    }

    private void i(n nVar, PostData postData) {
        if (nVar != null && postData != null) {
            nVar.kCb.setVisibility(postData.mfV ? 0 : 8);
        }
    }

    private void a(n nVar) {
        LayerDrawable layerDrawable;
        if (nVar != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (nVar.mSkinType != skinType) {
                com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.gVX, R.color.cp_cont_d, 1);
                if (nVar.kBp.getTag() instanceof Integer) {
                    com.baidu.tbadk.core.util.ap.setBackgroundResource(nVar.kBp, ((Integer) nVar.kBp.getTag()).intValue());
                } else if (nVar.kBp.getTag() instanceof String) {
                    if (nVar.kBp.getTag().equals("BA_ZHU_BG")) {
                        layerDrawable = this.aiR;
                    } else if (nVar.kBp.getTag().equals("XIAO_BA_ZHU_BG")) {
                        layerDrawable = this.aiS;
                    } else {
                        layerDrawable = nVar.kBp.getTag().equals("HOST") ? this.kyR : null;
                    }
                    if (layerDrawable != null && layerDrawable.getDrawable(1) != null) {
                        if (nVar.mSkinType == 1) {
                            layerDrawable.getDrawable(1).setAlpha(255);
                        } else {
                            layerDrawable.getDrawable(1).setAlpha(0);
                        }
                        nVar.kBp.setBackgroundDrawable(layerDrawable);
                    }
                }
                com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.kBq, R.color.cp_cont_d, 1);
                com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.kBr, R.color.cp_cont_d);
                com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.kBs, R.color.cp_cont_d);
                com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.kBM, R.color.cp_cont_d, 1);
                com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.kBt, R.color.cp_cont_d, 1);
                nVar.kBw.setTextColor(com.baidu.tbadk.core.util.ap.getColor(R.color.cp_cont_b));
                com.baidu.tbadk.core.util.ap.c(nVar.kBz, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10), R.color.cp_bg_line_g, R.color.cp_bg_line_g);
                com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.kBA, R.color.cp_cont_c);
                nVar.kBA.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.ap.getDrawable(R.drawable.icon_pb_comment_more_n), (Drawable) null);
                com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.kBB, R.color.cp_cont_c);
                if (this.kBf) {
                    SvgManager.bjq().a(nVar.kBR, R.drawable.ic_icon_pure_close24, R.color.cp_cont_g, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    SvgManager.bjq().a(nVar.kBJ, R.drawable.icon_pure_pb_reply26_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    SvgManager.bjq().a(nVar.kBH, R.drawable.icon_pure_pb_share26_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    nVar.kBL.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                    com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.kBI, R.color.cp_cont_d);
                    com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.kBK, R.color.cp_cont_d);
                } else {
                    SvgManager.bjq().a(nVar.kBC, R.drawable.icon_pure_pb_reply26_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    SvgManager.bjq().a(nVar.iTV, R.drawable.icon_pure_pb_share26_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                }
                nVar.kBz.onChangeSkinType();
                nVar.kBx.onChangeSkinType();
                com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.kBW, R.color.cp_link_tip_c, 1);
                com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.kBU, R.color.cp_cont_f, 1);
                com.baidu.tbadk.core.util.ap.setBackgroundResource(nVar.kBT, R.color.cp_bg_line_e);
                com.baidu.tbadk.core.util.ap.setBackgroundResource(nVar.kBV, R.color.cp_cont_d);
                com.baidu.tbadk.core.util.ap.setImageResource(nVar.kBX, R.drawable.icon_arrow_more_gray);
                com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.kCa, R.color.cp_cont_c);
                if (nVar.kBY.getVisibility() == 8) {
                    nVar.kCa.setText(R.string.close_content);
                } else if (this.kAn != null && StringUtils.isNull(this.kAn.cVx())) {
                    nVar.kCa.setText(this.kAn.cVx());
                } else {
                    nVar.kCa.setText(R.string.expand_content);
                }
                nVar.kBu.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                nVar.Cc(skinType);
                com.baidu.tbadk.core.util.ap.setBackgroundColor(nVar.mBottomLine, R.color.cp_bg_line_b);
            }
            nVar.mSkinType = skinType;
        }
    }

    private void b(final n nVar) {
        nVar.kBo.setOnTouchListener(this.kBh);
        nVar.kBo.setOnLongClickListener(this.mOnLongClickListener);
        if (this.kCd.cYj() != null && this.kCd.cYj().getPageContext() != null && this.kCd.cYj().getPageContext().getOrignalPage() != 0) {
            com.baidu.tieba.pb.pb.main.b.a aVar = this.kCd.cYj().kzM;
            nVar.gVX.setOnClickListener(aVar.hCp);
            nVar.kBv.setOnClickListener(aVar.hCp);
            nVar.kBO.setOnClickListener(aVar.hCp);
            nVar.kBO.getHeadView().setOnClickListener(aVar.hCp);
            nVar.kBw.setOnLongClickListener(this.mOnLongClickListener);
            nVar.kBw.setOnTouchListener(this.kBh);
            nVar.kBw.setCommonTextViewOnClickListener(this.aRW);
            nVar.kBw.setOnImageClickListener(this.fcC);
            nVar.kBw.setOnImageTouchListener(this.kBh);
            nVar.kBw.setOnEmotionClickListener(aVar.kPN);
            nVar.kBw.setOnVoiceAfterClickListener(this.aRW);
            nVar.kBS.setOnClickListener(this.aRW);
            nVar.kBT.setOnClickListener(this.aRW);
            nVar.kBA.setOnClickListener(this.aRW);
            nVar.kBB.setOnClickListener(this.aRW);
            final com.baidu.tieba.pb.pb.main.b.c cVar = this.kCd.cYj().kzN;
            if (this.kBf) {
                nVar.kBF.setOnClickListener(this.aRW);
                nVar.kBE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.m.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        final PostData postData;
                        if (view.getTag() instanceof SparseArray) {
                            SparseArray sparseArray = (SparseArray) view.getTag();
                            if ((sparseArray.get(R.id.tag_load_sub_data) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.tag_load_sub_data)) != null && nVar.kBo != null && cVar != null) {
                                com.baidu.adp.lib.f.e.mS().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.m.5.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        cVar.kQc.a(m.this.kAn, null, postData, nVar.kBo);
                                    }
                                }, 100L);
                                String threadId = m.this.kAn.getThreadId();
                                if ((StringUtils.isNull(threadId) || "0".equals(m.this.kAn.getThreadId())) && m.this.kAn.cVm() != null) {
                                    threadId = m.this.kAn.cVm().getNid();
                                }
                                TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13700").dD("tid", threadId).dD("fid", m.this.kAn.getForumId()).u("uid", TbadkCoreApplication.getCurrentAccountId()).dD("post_id", postData.getId()).ai("obj_type", 4));
                            }
                        }
                    }
                });
                nVar.kBL.eoo = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.m.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (view != null && m.this.kAn != null && nVar != null && nVar.kBL != null && nVar.kBL.getData() != null) {
                            int i = view == nVar.kBL.getImgAgree() ? 1 : 2;
                            String threadId = m.this.kAn.getThreadId();
                            if ((StringUtils.isNull(threadId) || "0".equals(m.this.kAn.getThreadId())) && m.this.kAn.cVm() != null) {
                                threadId = m.this.kAn.cVm().getNid();
                            }
                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13700").dD("tid", threadId).dD("fid", m.this.kAn.getForumId()).u("uid", TbadkCoreApplication.getCurrentAccountId()).dD("post_id", nVar.kBL.getData().postId).ai("obj_type", i));
                        }
                    }
                };
                return;
            }
            nVar.kBC.setOnClickListener(this.aRW);
            nVar.iTV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.m.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    final PostData postData;
                    if (view.getTag() instanceof SparseArray) {
                        SparseArray sparseArray = (SparseArray) view.getTag();
                        if ((sparseArray.get(R.id.tag_load_sub_data) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.tag_load_sub_data)) != null && nVar.kBo != null && cVar != null) {
                            com.baidu.adp.lib.f.e.mS().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.m.7.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    cVar.kQc.a(m.this.kAn, null, postData, nVar.kBo);
                                }
                            }, 100L);
                            String threadId = m.this.kAn.getThreadId();
                            if ((StringUtils.isNull(threadId) || "0".equals(m.this.kAn.getThreadId())) && m.this.kAn.cVm() != null) {
                                threadId = m.this.kAn.cVm().getNid();
                            }
                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13700").dD("tid", threadId).dD("fid", m.this.kAn.getForumId()).u("uid", TbadkCoreApplication.getCurrentAccountId()).dD("post_id", postData.getId()).ai("obj_type", 4));
                        }
                    }
                }
            });
            nVar.kBu.eoo = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.m.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (view != null && m.this.kAn != null && nVar != null && nVar.kBu != null && nVar.kBu.getData() != null) {
                        int i = view == nVar.kBu.getImgAgree() ? 1 : 2;
                        String threadId = m.this.kAn.getThreadId();
                        if ((StringUtils.isNull(threadId) || "0".equals(m.this.kAn.getThreadId())) && m.this.kAn.cVm() != null) {
                            threadId = m.this.kAn.cVm().getNid();
                        }
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13700").dD("tid", threadId).dD("fid", m.this.kAn.getForumId()).u("uid", TbadkCoreApplication.getCurrentAccountId()).dD("post_id", nVar.kBu.getData().postId).ai("obj_type", i));
                    }
                }
            };
        }
    }

    private void ui() {
        this.aiR = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.e.a.b.bjR().oe(0).V(this.iAt).b("TL_BR", R.color.ba_zhu_start, R.color.ba_zhu_end).bjT(), com.baidu.tbadk.core.util.e.a.b.bjR().oe(0).V(this.iAt).Ax("#4D000000").bjT()});
        this.aiS = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.e.a.b.bjR().oe(0).V(this.iAt).b("TL_BR", R.color.xiao_ba_zhu_start, R.color.xiao_ba_zhu_end).bjT(), com.baidu.tbadk.core.util.e.a.b.bjR().oe(0).V(this.iAt).Ax("#4D000000").bjT()});
        this.kyR = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.e.a.b.bjR().oe(0).V(this.iAt).b("TL_BR", R.color.floor_host_start, R.color.floor_host_end).bjT(), com.baidu.tbadk.core.util.e.a.b.bjR().oe(0).V(this.iAt).Ax("#4D000000").bjT()});
    }

    public void a(TbRichTextView.c cVar) {
        this.kBd = cVar;
    }

    public void setData(com.baidu.tieba.pb.data.f fVar) {
        this.kAn = fVar;
    }

    public void gM(String str) {
        this.aYY = str;
    }

    public void sF(boolean z) {
        this.kAo = z;
    }

    private SpannableStringBuilder dF(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new m.a(str, R.drawable.pic_smalldot_title));
            return com.baidu.tieba.card.m.a((Context) this.kCd.cYj(), str2, (ArrayList<m.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    private void c(n nVar) {
        nVar.kBw.setTextViewOnTouchListener(this.eFj);
        nVar.kBw.setTextViewCheckSelection(false);
    }

    public void S(View.OnClickListener onClickListener) {
        this.kAx = onClickListener;
    }

    public void A(View.OnClickListener onClickListener) {
        this.aRW = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.fcC = iVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.eFj = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }
}
