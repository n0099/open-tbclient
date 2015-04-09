package com.baidu.tieba.pb.pb.sub;

import android.os.Handler;
import android.text.InputFilter;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.game.GameInfoData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.view.ClickableLayout4Frame;
import com.baidu.tieba.tbadkCore.PbEditor.PbEditor;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class l {
    private static final int aRv = TbadkCoreApplication.m411getInst().getListItemRule().uF();
    protected UserIconBox aIp;
    protected View.OnClickListener aNa;
    protected UserIconBox aOz;
    protected TextView azB;
    private com.baidu.tieba.pb.b.d bIs;
    protected HeadImageView bKn;
    protected ImageView bKo;
    protected ImageView bKp;
    protected TextView bKr;
    protected ImageView bKs;
    protected ImageView bKt;
    protected TbRichTextView bKu;
    private com.baidu.tieba.pb.a.c bNJ;
    protected View.OnClickListener bNp;
    protected ClickableLayout4Frame bOc;
    protected TextView bOd;
    protected Button bOe;
    protected d bOf;
    protected View bOg;
    protected View.OnClickListener bOi;
    protected View.OnClickListener bOj;
    protected View.OnClickListener bOk;
    private ArrayList<com.baidu.tieba.tbadkCore.c.j> bOo;
    private String bOp;
    protected BaseActivity mActivity;
    protected Handler mHandler;
    protected BdListView mListView;
    protected ProgressBar mProgress;
    protected View rootView = null;
    protected View bOa = null;
    protected a bOb = null;
    protected LinearLayout bOh = null;
    protected int mImageMaxWidth = 0;
    protected boolean bJa = true;
    protected boolean bJb = true;
    private boolean mIsFromCDN = true;
    protected Button bOl = null;
    protected com.baidu.tbadk.widget.richText.s atd = null;
    protected com.baidu.tbadk.widget.richText.r bMO = null;
    protected View.OnLongClickListener bOm = null;
    private ArrayList<IconData> bJW = null;
    private ArrayList<IconData> aIa = null;
    protected PbEditor aIG = null;
    private String bOn = null;
    private String bOq = null;
    private boolean bOr = false;
    public v bOs = null;
    private boolean bOt = false;
    protected AdapterView.OnItemClickListener bOu = new m(this);
    protected AdapterView.OnItemLongClickListener HG = new n(this);

    public l(BaseActivity baseActivity, boolean z, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3, View.OnClickListener onClickListener4, View.OnClickListener onClickListener5) {
        this.mListView = null;
        this.mActivity = null;
        this.bOc = null;
        this.bKn = null;
        this.azB = null;
        this.bKo = null;
        this.bKp = null;
        this.bOd = null;
        this.bKs = null;
        this.bKr = null;
        this.bKu = null;
        this.bKt = null;
        this.bOe = null;
        this.bOf = null;
        this.bOg = null;
        this.aOz = null;
        this.aIp = null;
        this.aNa = null;
        this.bOi = null;
        this.bNp = null;
        this.bOj = null;
        this.bOk = null;
        this.mHandler = null;
        this.mProgress = null;
        this.mActivity = baseActivity;
        this.mHandler = new Handler();
        this.aNa = onClickListener;
        this.bNp = onClickListener2;
        this.bOi = onClickListener3;
        this.bOj = onClickListener4;
        this.bOk = onClickListener5;
        acx();
        this.bOc = (ClickableLayout4Frame) this.rootView.findViewById(com.baidu.tieba.v.sub_pb_body_layout);
        this.mListView = (BdListView) this.rootView.findViewById(com.baidu.tieba.v.new_sub_pb_list);
        this.bOa.setOnClickListener(new o(this));
        acp();
        this.bIs = new com.baidu.tieba.pb.b.d(new p(this));
        this.bKn = (HeadImageView) this.bOa.findViewById(com.baidu.tieba.v.photo);
        this.azB = (TextView) this.bOa.findViewById(com.baidu.tieba.v.user_name);
        this.bKo = (ImageView) this.bOa.findViewById(com.baidu.tieba.v.user_rank);
        this.bKp = (ImageView) this.bOa.findViewById(com.baidu.tieba.v.user_gender);
        this.bKt = (ImageView) this.bOa.findViewById(com.baidu.tieba.v.reply);
        this.bOe = (Button) this.bOa.findViewById(com.baidu.tieba.v.manage_btn);
        this.bOd = (TextView) this.bOa.findViewById(com.baidu.tieba.v.floor);
        this.bKs = (ImageView) this.bOa.findViewById(com.baidu.tieba.v.floor_owner);
        this.bKr = (TextView) this.bOa.findViewById(com.baidu.tieba.v.time);
        this.aOz = (UserIconBox) this.bOa.findViewById(com.baidu.tieba.v.user_icon_box);
        this.aIp = (UserIconBox) this.bOa.findViewById(com.baidu.tieba.v.user_tshow_icon_box);
        this.bKu = (TbRichTextView) this.bOa.findViewById(com.baidu.tieba.v.richText);
        this.bKu.DS();
        this.bKu.setTextSize(TbConfig.getContentSize());
        this.bKu.setVoiceViewRes(w.voice_play_btn);
        this.bKu.setOnTouchListener(this.bIs);
        this.mListView.addHeaderView(this.bOa);
        y(onClickListener3);
        this.bOf = new d(this.mActivity.getPageContext().getPageActivity());
        this.bOg = this.bOf.getView();
        this.bOf.setOnClickListener(this.aNa);
        this.mListView.setOnItemClickListener(this.bOu);
        this.mListView.setOnItemLongClickListener(this.HG);
        this.mListView.setOnTouchListener(this.bIs);
        this.mProgress = (ProgressBar) this.rootView.findViewById(com.baidu.tieba.v.progress);
        this.bKn.setOnClickListener(onClickListener3);
        init();
        if (this.bOa != null) {
            this.bOa.setVisibility(4);
        }
        if (this.bOc != null) {
            this.bOc.setVisibility(4);
        }
    }

    public void a(v vVar) {
        this.bOs = vVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dR(boolean z) {
        if (this.mListView != null) {
            if (!z) {
                this.mListView.setEnabled(z);
            } else {
                this.mListView.postDelayed(new q(this, z), 10L);
            }
        }
    }

    public void L(View view) {
        if (this.bOs != null) {
            this.bOs.N(view);
        }
    }

    protected void acp() {
        this.aIG = (PbEditor) this.rootView.findViewById(com.baidu.tieba.v.sub_pb_editor);
        this.aIG.aQ(true);
        this.aIG.getEditText().setFilters(new InputFilter[]{new InputFilter.LengthFilter(140)});
        this.aIG.setMaxTextCount(140);
    }

    protected void y(View.OnClickListener onClickListener) {
        this.bOb = new a(this.mActivity.getPageContext().getPageActivity(), onClickListener);
        this.bOb.x(this.bNp);
        this.bOb.setIsFromCDN(this.mIsFromCDN);
        this.mListView.setAdapter((ListAdapter) this.bOb);
    }

    protected void acx() {
        this.rootView = com.baidu.adp.lib.g.b.hH().inflate(this.mActivity.getPageContext().getPageActivity(), w.new_sub_pb_layout, null);
        this.bOa = com.baidu.adp.lib.g.b.hH().inflate(this.mActivity.getPageContext().getPageActivity(), w.new_sub_pb_head, null);
    }

    protected void init() {
        this.mImageMaxWidth = Math.min(com.baidu.adp.lib.util.n.dip2px(this.mActivity.getPageContext().getPageActivity(), 427.0f), (int) TbConfig.PB_IMAGE_NEW_MAX_WIDTH);
        acA();
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public void acy() {
        if (!this.aIG.alK()) {
            hT(null);
        }
    }

    public String acz() {
        return this.bOp;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(int i, View view) {
        new Handler().postDelayed(new r(this, view, i), 300L);
    }

    protected void acA() {
        TextView textView = new TextView(this.mActivity.getPageContext().getPageActivity());
        textView.setLineSpacing(0.0f, 1.2f);
        textView.setTextSize(TbConfig.getContentSize());
    }

    public void setAudioFocusable(boolean z) {
        this.aIG.setAudioFocusable(z);
    }

    public boolean aco() {
        this.bOr = false;
        if (this.aIG.isVisible()) {
            this.aIG.amh();
            this.aIG.hide();
            return true;
        }
        this.aIG.clearData();
        this.bOn = null;
        this.bOp = null;
        this.bOo = null;
        return false;
    }

    public void dI(boolean z) {
        this.bJb = z;
        this.bOb.dI(z);
    }

    public boolean hasMore() {
        return this.bOb.bNt;
    }

    public void setOnImageClickListener(com.baidu.tbadk.widget.richText.s sVar) {
        this.atd = sVar;
    }

    public void setOnEmotionClickListener(com.baidu.tbadk.widget.richText.r rVar) {
        this.bMO = rVar;
    }

    public void hv(int i) {
        this.bKu.setMaxImageWidth(i);
        this.bKu.setMaxImageHeight((int) (i * 1.618f));
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.mListView.setOnScrollListener(onScrollListener);
    }

    public void e(x xVar) {
        this.mListView.setOnSrollToBottomListener(xVar);
    }

    public void abm() {
        this.aIG.abm();
    }

    public void abn() {
        this.aIG.abn();
    }

    public View getRootView() {
        return this.rootView;
    }

    public VoiceData.VoiceModel getAudioData() {
        return this.aIG.getAudioData();
    }

    public void Jn() {
        this.aIG.Jn();
    }

    public void v(ArrayList<String> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                sb.append("@");
                sb.append(arrayList.get(i2));
                sb.append(" ");
                i = i2 + 1;
            }
            String sb2 = sb.toString();
            int selectionStart = this.aIG.getEditText().getSelectionStart();
            if (selectionStart < 0) {
                this.aIG.getEditText().setText(sb2);
            } else {
                this.aIG.getEditText().getText().insert(selectionStart, sb2);
            }
        }
    }

    public void aQ(String str, String str2) {
        this.bOp = str2;
        hT(str);
        new Handler().postDelayed(new s(this, str2), 200L);
    }

    public void hT(String str) {
        this.bOr = true;
        this.aIG.Cf();
        if (str != null) {
            this.aIG.getEditText().setText(this.mActivity.getResources().getString(y.reply_sub_floor).replace("%s", str));
            this.aIG.getEditText().setSelection(this.aIG.getEditText().getText().length());
        }
        if (this.aIG.alK()) {
            this.aIG.amg();
            this.aIG.acy();
        } else {
            this.aIG.getEditText().requestFocus();
            this.mActivity.ShowSoftKeyPadDelay(this.aIG.getEditText(), 200);
        }
        TiebaStatic.eventStat(this.mActivity.getPageContext().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hU(String str) {
        this.bOr = true;
        this.aIG.Cf();
        this.aIG.getEditText().setText(str);
        this.aIG.getEditText().setSelection(this.aIG.getEditText().getText().length());
        if (this.aIG.alK()) {
            this.aIG.amg();
            this.aIG.acy();
        } else {
            this.aIG.getEditText().requestFocus();
            this.mActivity.ShowSoftKeyPadDelay(this.aIG.getEditText(), 200);
        }
        TiebaStatic.eventStat(this.mActivity.getPageContext().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    public void acB() {
        this.bOr = false;
        this.aIG.hide();
    }

    public void acC() {
        this.mListView.setNextPage(this.bOf);
        this.bOf.startLoadData();
    }

    public void dH(boolean z) {
        this.bJa = z;
    }

    public void MJ() {
        this.bOb.setDatas(null);
        this.bOb.notifyDataSetChanged();
        this.aIG.getEditText().setText("");
        this.aIG.clearData();
    }

    public String acD() {
        return this.bOn;
    }

    public void a(com.baidu.tieba.pb.a.c cVar, int i) {
        int i2;
        int i3;
        int i4;
        String userId;
        boolean z = false;
        this.bNJ = cVar;
        if (cVar != null) {
            if (this.bOa != null) {
                this.bOa.setVisibility(0);
            }
            if (this.bOc != null) {
                this.bOc.setVisibility(0);
            }
            if (cVar.Zj() != null) {
                this.bOn = cVar.Zj().getId();
            }
            if (cVar.hasMore()) {
                this.bOf.startLoadData();
                this.bOb.dZ(true);
            } else {
                this.bOf.tO();
                this.bOb.dZ(false);
            }
            this.bOo = cVar.Zl();
            if (this.bOo == null || this.bOo.size() == 0) {
                this.mListView.setNextPage(null);
            } else {
                this.mListView.setNextPage(this.bOf);
            }
            if (this.bOo == null || this.bOo.size() <= aRv) {
                i2 = 0;
                i3 = 0;
                i4 = 0;
            } else {
                i4 = this.bOo.size() - aRv;
                hw(i4);
                i3 = this.mListView.getFirstVisiblePosition() - i4;
                View childAt = this.mListView.getChildAt(0);
                i2 = childAt == null ? 0 : childAt.getTop();
            }
            this.bOb.setDatas(this.bOo);
            if (cVar.Zq() != null && cVar.Zq().getAuthor() != null && (userId = cVar.Zq().getAuthor().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                z = true;
            }
            this.bOb.q(i, z);
            this.bOb.notifyDataSetChanged();
            a(cVar.Zj(), cVar.Te(), cVar.oQ(), i);
            if (i4 > 0) {
                this.mListView.setSelectionFromTop(i3, i2);
            }
        }
    }

    private void hw(int i) {
        if (this.bOo != null) {
            if (this.bOo.size() <= i) {
                this.bOo.clear();
            }
            int i2 = 0;
            Iterator<com.baidu.tieba.tbadkCore.c.j> it = this.bOo.iterator();
            while (it.hasNext()) {
                it.next();
                i2++;
                it.remove();
                if (i2 >= i) {
                    return;
                }
            }
        }
    }

    public void setOnActionListener(com.baidu.tbadk.editortool.v vVar) {
        if (vVar != null) {
            this.aIG.a(this.mActivity.getPageContext(), new t(this, vVar));
        }
    }

    protected int c(com.baidu.tieba.pb.a.c cVar) {
        if (cVar == null) {
            return 0;
        }
        return cVar.getTotalCount() - cVar.Zl().size();
    }

    public void setPosition(int i) {
        this.mListView.setSelection(i);
        this.mListView.invalidate();
    }

    public void hV(String str) {
        int hP;
        if (str != null && !str.equals("") && (hP = this.bOb.hP(str)) >= 0) {
            this.mListView.setSelection(hP + 1);
            this.mListView.invalidate();
        }
    }

    public void clearContent() {
        this.aIG.clearData();
    }

    public View acE() {
        return this.bKt;
    }

    protected void a(com.baidu.tieba.tbadkCore.c.j jVar, boolean z, boolean z2, int i) {
        int i2;
        if (jVar != null) {
            this.bKn.setTag(null);
            this.bKn.setUserId(null);
            SparseArray<Object> sparseArray = (SparseArray) this.bOa.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                this.bOa.setTag(sparseArray);
            }
            sparseArray.clear();
            sparseArray.put(com.baidu.tieba.v.tag_clip_board, jVar);
            sparseArray.put(com.baidu.tieba.v.tag_is_subpb, false);
            a(jVar, i, sparseArray);
            this.bKt.setTag(sparseArray);
            if (!this.bJb) {
                this.bKn.setVisibility(8);
            }
            this.azB.setOnClickListener(this.bOi);
            this.azB.setText((CharSequence) null);
            this.bKs.setVisibility(8);
            this.bOd.setText((CharSequence) null);
            this.bKt.setOnClickListener(this.aNa);
            TbadkCoreApplication.m411getInst().getSkinType();
            ba.b(this.bKr, com.baidu.tieba.s.pb_listitem_post_time, 1);
            this.bKr.setText(bd.n(jVar.getTime()));
            if (z) {
                this.bKs.setVisibility(0);
                ba.c(this.bKs, com.baidu.tieba.u.icon_floorhost);
            }
            if (this.bJa) {
                i2 = com.baidu.tieba.u.img_default_100;
            } else {
                i2 = com.baidu.tieba.u.icon_click;
            }
            this.bKu.setDefaultImageId(i2);
            this.bOd.setText(String.format(this.mActivity.getPageContext().getString(y.is_floor), Integer.valueOf(jVar.amP())));
            String portrait = jVar.getAuthor().getPortrait();
            if (jVar.getAuthor() != null) {
                this.azB.setText(jVar.getAuthor().getName_show());
                ArrayList<IconData> tShowInfo = jVar.getAuthor().getTShowInfo();
                if (tShowInfo != null && tShowInfo.size() > 0) {
                    ba.b(this.azB, com.baidu.tieba.s.cp_cont_h, 1);
                } else {
                    ba.b(this.azB, com.baidu.tieba.s.cp_cont_f, 1);
                }
                int level_id = jVar.getAuthor().getLevel_id();
                int is_bawu = jVar.getAuthor().getIs_bawu();
                String bawu_type = jVar.getAuthor().getBawu_type();
                int i3 = 3;
                if (level_id != 0) {
                    this.bKo.setVisibility(0);
                    ba.c(this.bKo, com.baidu.tbadk.core.util.c.bR(level_id));
                    this.bKo.setOnClickListener(null);
                    i3 = 2;
                } else {
                    this.bKo.setVisibility(8);
                }
                if (is_bawu != 0) {
                    if (bawu_type.equals("manager")) {
                        ba.c(this.bKo, com.baidu.tieba.u.pb_manager);
                        this.bKo.setOnClickListener(this.bOj);
                    } else if (bawu_type.equals("assist")) {
                        ba.c(this.bKo, com.baidu.tieba.u.pb_assist);
                        this.bKo.setOnClickListener(this.bOj);
                    }
                }
                if (jVar.getAuthor().getGender() == 2) {
                    ba.c(this.bKp, com.baidu.tieba.u.icon_pop_girl_square);
                    this.bKp.setVisibility(0);
                } else {
                    this.bKp.setVisibility(8);
                }
                this.bJW = jVar.getAuthor().getIconInfo();
                this.aIa = jVar.getAuthor().getTShowInfo();
                if (this.aOz != null) {
                    this.aOz.setOnClickListener(this.bOj);
                    this.aOz.a(this.bJW, i3, this.mActivity.getResources().getDimensionPixelSize(com.baidu.tieba.t.pb_icon_width), this.mActivity.getResources().getDimensionPixelSize(com.baidu.tieba.t.pb_icon_height), this.mActivity.getResources().getDimensionPixelSize(com.baidu.tieba.t.pb_icon_margin));
                }
                if (this.aIp != null) {
                    this.aIp.setOnClickListener(this.bOk);
                    this.aIp.a(this.aIa, 2, this.mActivity.getResources().getDimensionPixelSize(com.baidu.tieba.t.big_icon_width), this.mActivity.getResources().getDimensionPixelSize(com.baidu.tieba.t.big_icon_height), this.mActivity.getResources().getDimensionPixelSize(com.baidu.tieba.t.big_icon_margin), true);
                }
            }
            this.bKn.setUserId(jVar.getAuthor().getUserId());
            this.bKn.setUserName(jVar.getAuthor().getUserName());
            this.azB.setTag(com.baidu.tieba.v.tag_user_id, jVar.getAuthor().getUserId());
            this.azB.setTag(com.baidu.tieba.v.tag_user_name, jVar.getAuthor().getUserName());
            this.bKn.setDefaultResource(com.baidu.tieba.u.icon_default_avatar100);
            this.bKn.c(portrait, 28, false);
            this.bKu.b(this.bJa, false);
            this.bKu.setIsFromCDN(this.mIsFromCDN);
            this.bKu.setText(jVar.amQ());
            this.bKu.setOnImageClickListener(this.atd);
            this.bKu.setOnEmotionClickListener(this.bMO);
            this.bOe.setVisibility(8);
            if (!TextUtils.isEmpty(jVar.getBimg_url()) && this.bJa) {
                this.bKu.setBackgroundDrawable(null);
                this.bKu.setTag(jVar.getBimg_url());
                com.baidu.adp.lib.f.d.hB().a(jVar.getBimg_url(), 19, new u(this), null);
                return;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bKu.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            this.bKu.setPadding(0, 0, 0, 0);
            this.bKu.setLayoutParams(layoutParams);
            this.bKu.setBackgroundDrawable(null);
        }
    }

    public void a(com.baidu.tieba.tbadkCore.c.j jVar, int i, SparseArray<Object> sparseArray) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4 = true;
        if (jVar != null) {
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
            }
            if (i != 0) {
                String userId = jVar.getAuthor().getUserId();
                boolean z5 = userId == null || !userId.equals(TbadkCoreApplication.getCurrentAccount());
                if (userId == null || userId.equals(GameInfoData.NOT_FROM_DETAIL) || userId.length() == 0) {
                    z = true;
                    z2 = false;
                } else {
                    z2 = z5;
                    z = true;
                }
            } else {
                String userId2 = jVar.getAuthor().getUserId();
                if (userId2 == null || !userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z = false;
                    z2 = false;
                } else {
                    z = true;
                    z2 = false;
                }
            }
            int i2 = jVar.amP() == 1 ? 0 : 1;
            if (z2) {
                sparseArray.put(com.baidu.tieba.v.tag_manage_user_identity, Integer.valueOf(i));
                sparseArray.put(com.baidu.tieba.v.tag_forbid_user_name, jVar.getAuthor().getUserName());
                sparseArray.put(com.baidu.tieba.v.tag_forbid_user_post_id, jVar.getId());
                z3 = true;
            } else {
                sparseArray.put(com.baidu.tieba.v.tag_forbid_user_name, "");
                z3 = false;
            }
            if (z) {
                sparseArray.put(com.baidu.tieba.v.tag_manage_user_identity, Integer.valueOf(i));
                sparseArray.put(com.baidu.tieba.v.tag_del_post_is_self, true);
                sparseArray.put(com.baidu.tieba.v.tag_del_post_type, Integer.valueOf(i2));
                sparseArray.put(com.baidu.tieba.v.tag_del_post_id, jVar.getId());
            } else {
                sparseArray.put(com.baidu.tieba.v.tag_del_post_is_self, false);
                sparseArray.put(com.baidu.tieba.v.tag_del_post_type, 0);
                sparseArray.put(com.baidu.tieba.v.tag_del_post_id, "");
                z4 = z3;
            }
            sparseArray.put(com.baidu.tieba.v.tag_should_manage_visible, Boolean.valueOf(z4));
        }
    }

    public View acF() {
        return this.bOg;
    }

    public String acG() {
        return this.aIG.getEditText().getText().toString();
    }

    public void onChangeSkinType(int i) {
        this.mActivity.getLayoutMode().X(i == 1);
        this.mActivity.getLayoutMode().h(this.rootView);
        this.mActivity.getLayoutMode().h(this.bOa);
        this.mActivity.getLayoutMode().h(this.bOg);
        ba.i((View) this.bOl, com.baidu.tieba.u.btn_pb_editor_post_btn);
        ba.c(this.bKt, com.baidu.tieba.u.btn_pb_reply_selector);
        this.bKu.setTextColor(ba.getColor(com.baidu.tieba.s.pb_listitem_content));
        this.bKu.setVideoImageId(com.baidu.tieba.u.pic_video);
        this.aIG.b(this.mActivity.getPageContext(), i);
    }

    public void aaX() {
        this.mListView.setVisibility(8);
        this.mProgress.setVisibility(0);
    }

    public void acH() {
        this.mProgress.setVisibility(0);
    }

    public void acI() {
        this.mProgress.setVisibility(8);
    }

    public void acJ() {
        this.mListView.setVisibility(0);
        this.mProgress.setVisibility(8);
        if (!com.baidu.adp.lib.util.n.isNetOk()) {
            this.bOf.ht(c(this.bNJ));
            return;
        }
        this.bOf.tO();
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.bOm = onLongClickListener;
        this.bOa.setOnLongClickListener(this.bOm);
    }

    public View acK() {
        return this.bOa;
    }

    public void hS(String str) {
        int hP = this.bOb.hP(str);
        if (hP > -1) {
            this.mListView.setSelection(hP + 1);
            this.mListView.invalidate();
        }
    }

    public void eb(boolean z) {
        this.mIsFromCDN = z;
    }

    public boolean Ji() {
        return this.aIG.Ji();
    }

    public PbEditor Je() {
        return this.aIG;
    }
}
