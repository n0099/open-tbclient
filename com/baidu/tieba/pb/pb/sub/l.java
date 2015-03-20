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
/* loaded from: classes.dex */
public class l {
    protected UserIconBox aIh;
    protected View.OnClickListener aMP;
    protected UserIconBox aOi;
    protected TextView azt;
    private com.baidu.tieba.pb.b.d bIf;
    protected HeadImageView bJY;
    protected ImageView bJZ;
    protected ImageView bKa;
    protected TextView bKc;
    protected ImageView bKd;
    protected ImageView bKe;
    protected TbRichTextView bKf;
    protected View.OnClickListener bMZ;
    protected ClickableLayout4Frame bNM;
    protected TextView bNN;
    protected Button bNO;
    protected d bNP;
    protected View bNQ;
    protected View.OnClickListener bNS;
    protected View.OnClickListener bNT;
    protected View.OnClickListener bNU;
    private ArrayList<com.baidu.tieba.tbadkCore.c.j> bNY;
    private String bNZ;
    protected BaseActivity mActivity;
    protected Handler mHandler;
    protected BdListView mListView;
    protected ProgressBar mProgress;
    protected View rootView = null;
    protected View bNK = null;
    protected a bNL = null;
    protected LinearLayout bNR = null;
    protected int mImageMaxWidth = 0;
    protected boolean bIM = true;
    protected boolean bIN = true;
    private boolean mIsFromCDN = true;
    protected Button bNV = null;
    protected com.baidu.tbadk.widget.richText.s asV = null;
    protected com.baidu.tbadk.widget.richText.r bMy = null;
    protected View.OnLongClickListener bNW = null;
    private ArrayList<IconData> bJH = null;
    private ArrayList<IconData> aHS = null;
    protected PbEditor aIy = null;
    private String bNX = null;
    private String bOa = null;
    private boolean bOb = false;
    public v bOc = null;
    private boolean bOd = false;
    protected AdapterView.OnItemClickListener bOe = new m(this);
    protected AdapterView.OnItemLongClickListener HE = new n(this);

    public l(BaseActivity baseActivity, boolean z, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3, View.OnClickListener onClickListener4, View.OnClickListener onClickListener5) {
        this.mListView = null;
        this.mActivity = null;
        this.bNM = null;
        this.bJY = null;
        this.azt = null;
        this.bJZ = null;
        this.bKa = null;
        this.bNN = null;
        this.bKd = null;
        this.bKc = null;
        this.bKf = null;
        this.bKe = null;
        this.bNO = null;
        this.bNP = null;
        this.bNQ = null;
        this.aOi = null;
        this.aIh = null;
        this.aMP = null;
        this.bNS = null;
        this.bMZ = null;
        this.bNT = null;
        this.bNU = null;
        this.mHandler = null;
        this.mProgress = null;
        this.mActivity = baseActivity;
        this.mHandler = new Handler();
        this.aMP = onClickListener;
        this.bMZ = onClickListener2;
        this.bNS = onClickListener3;
        this.bNT = onClickListener4;
        this.bNU = onClickListener5;
        aci();
        this.bNM = (ClickableLayout4Frame) this.rootView.findViewById(com.baidu.tieba.v.sub_pb_body_layout);
        this.mListView = (BdListView) this.rootView.findViewById(com.baidu.tieba.v.new_sub_pb_list);
        this.bNK.setOnClickListener(new o(this));
        aca();
        this.bIf = new com.baidu.tieba.pb.b.d(new p(this));
        this.bJY = (HeadImageView) this.bNK.findViewById(com.baidu.tieba.v.photo);
        this.azt = (TextView) this.bNK.findViewById(com.baidu.tieba.v.user_name);
        this.bJZ = (ImageView) this.bNK.findViewById(com.baidu.tieba.v.user_rank);
        this.bKa = (ImageView) this.bNK.findViewById(com.baidu.tieba.v.user_gender);
        this.bKe = (ImageView) this.bNK.findViewById(com.baidu.tieba.v.reply);
        this.bNO = (Button) this.bNK.findViewById(com.baidu.tieba.v.manage_btn);
        this.bNN = (TextView) this.bNK.findViewById(com.baidu.tieba.v.floor);
        this.bKd = (ImageView) this.bNK.findViewById(com.baidu.tieba.v.floor_owner);
        this.bKc = (TextView) this.bNK.findViewById(com.baidu.tieba.v.time);
        this.aOi = (UserIconBox) this.bNK.findViewById(com.baidu.tieba.v.user_icon_box);
        this.aIh = (UserIconBox) this.bNK.findViewById(com.baidu.tieba.v.user_tshow_icon_box);
        this.bKf = (TbRichTextView) this.bNK.findViewById(com.baidu.tieba.v.richText);
        this.bKf.DM();
        this.bKf.setTextSize(TbConfig.getContentSize());
        this.bKf.setVoiceViewRes(w.voice_play_btn);
        this.bKf.setOnTouchListener(this.bIf);
        this.mListView.addHeaderView(this.bNK);
        x(onClickListener3);
        this.bNP = new d(this.mActivity.getPageContext().getPageActivity());
        this.bNQ = this.bNP.getView();
        this.mListView.setNextPage(this.bNP);
        this.bNP.setOnClickListener(this.aMP);
        this.mListView.setOnItemClickListener(this.bOe);
        this.mListView.setOnItemLongClickListener(this.HE);
        this.mListView.setOnTouchListener(this.bIf);
        this.mProgress = (ProgressBar) this.rootView.findViewById(com.baidu.tieba.v.progress);
        this.bJY.setOnClickListener(onClickListener3);
        init();
        if (this.bNK != null) {
            this.bNK.setVisibility(4);
        }
        if (this.bNM != null) {
            this.bNM.setVisibility(4);
        }
    }

    public void a(v vVar) {
        this.bOc = vVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dT(boolean z) {
        if (this.mListView != null) {
            if (!z) {
                this.mListView.setEnabled(z);
            } else {
                this.mListView.postDelayed(new q(this, z), 10L);
            }
        }
    }

    public void L(View view) {
        if (this.bOc != null) {
            this.bOc.N(view);
        }
    }

    protected void aca() {
        this.aIy = (PbEditor) this.rootView.findViewById(com.baidu.tieba.v.sub_pb_editor);
        this.aIy.aQ(true);
        this.aIy.getEditText().setFilters(new InputFilter[]{new InputFilter.LengthFilter(140)});
        this.aIy.setMaxTextCount(140);
    }

    protected void x(View.OnClickListener onClickListener) {
        this.bNL = new a(this.mActivity.getPageContext().getPageActivity(), onClickListener);
        this.bNL.w(this.bMZ);
        this.bNL.setIsFromCDN(this.mIsFromCDN);
        this.mListView.setAdapter((ListAdapter) this.bNL);
    }

    protected void aci() {
        this.rootView = com.baidu.adp.lib.g.b.hH().inflate(this.mActivity.getPageContext().getPageActivity(), w.new_sub_pb_layout, null);
        this.bNK = com.baidu.adp.lib.g.b.hH().inflate(this.mActivity.getPageContext().getPageActivity(), w.new_sub_pb_head, null);
    }

    protected void init() {
        this.mImageMaxWidth = Math.min(com.baidu.adp.lib.util.n.dip2px(this.mActivity.getPageContext().getPageActivity(), 427.0f), (int) TbConfig.PB_IMAGE_NEW_MAX_WIDTH);
        acl();
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public void acj() {
        if (!this.aIy.alv()) {
            hQ(null);
        }
    }

    public String ack() {
        return this.bNZ;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(int i, View view) {
        new Handler().postDelayed(new r(this, view, i), 300L);
    }

    protected void acl() {
        TextView textView = new TextView(this.mActivity.getPageContext().getPageActivity());
        textView.setLineSpacing(0.0f, 1.2f);
        textView.setTextSize(TbConfig.getContentSize());
    }

    public void setAudioFocusable(boolean z) {
        this.aIy.setAudioFocusable(z);
    }

    public boolean abZ() {
        this.bOb = false;
        if (this.aIy.isVisible()) {
            this.aIy.alS();
            this.aIy.hide();
            return true;
        }
        this.aIy.clearData();
        this.bNX = null;
        this.bNZ = null;
        this.bNY = null;
        return false;
    }

    public void dK(boolean z) {
        this.bIN = z;
        this.bNL.dK(z);
    }

    public void setOnImageClickListener(com.baidu.tbadk.widget.richText.s sVar) {
        this.asV = sVar;
    }

    public void setOnEmotionClickListener(com.baidu.tbadk.widget.richText.r rVar) {
        this.bMy = rVar;
    }

    public void ht(int i) {
        this.bKf.setMaxImageWidth(i);
        this.bKf.setMaxImageHeight((int) (i * 1.618f));
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.mListView.setOnScrollListener(onScrollListener);
    }

    public void aaY() {
        this.aIy.aaY();
    }

    public void aaZ() {
        this.aIy.aaZ();
    }

    public View getRootView() {
        return this.rootView;
    }

    public VoiceData.VoiceModel getAudioData() {
        return this.aIy.getAudioData();
    }

    public void Jh() {
        this.aIy.Jh();
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
            int selectionStart = this.aIy.getEditText().getSelectionStart();
            if (selectionStart < 0) {
                this.aIy.getEditText().setText(sb2);
            } else {
                this.aIy.getEditText().getText().insert(selectionStart, sb2);
            }
        }
    }

    public void aQ(String str, String str2) {
        this.bNZ = str2;
        hQ(str);
        new Handler().postDelayed(new s(this, str2), 200L);
    }

    public void hQ(String str) {
        this.bOb = true;
        this.aIy.BZ();
        if (str != null) {
            this.aIy.getEditText().setText(this.mActivity.getResources().getString(y.reply_sub_floor).replace("%s", str));
            this.aIy.getEditText().setSelection(this.aIy.getEditText().getText().length());
        }
        if (this.aIy.alv()) {
            this.aIy.alR();
            this.aIy.acj();
        } else {
            this.aIy.getEditText().requestFocus();
            this.mActivity.ShowSoftKeyPadDelay(this.aIy.getEditText(), 200);
        }
        TiebaStatic.eventStat(this.mActivity.getPageContext().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hR(String str) {
        this.bOb = true;
        this.aIy.BZ();
        this.aIy.getEditText().setText(str);
        this.aIy.getEditText().setSelection(this.aIy.getEditText().getText().length());
        if (this.aIy.alv()) {
            this.aIy.alR();
            this.aIy.acj();
        } else {
            this.aIy.getEditText().requestFocus();
            this.mActivity.ShowSoftKeyPadDelay(this.aIy.getEditText(), 200);
        }
        TiebaStatic.eventStat(this.mActivity.getPageContext().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    public void acm() {
        this.bOb = false;
        this.aIy.hide();
    }

    public void acn() {
        this.mListView.setNextPage(this.bNP);
        this.bNP.startLoadData();
    }

    public void dJ(boolean z) {
        this.bIM = z;
    }

    public void Mw() {
        this.bNL.setDatas(null);
        this.bNL.notifyDataSetChanged();
        this.aIy.getEditText().setText("");
        this.aIy.clearData();
    }

    public String aco() {
        return this.bNX;
    }

    public void a(com.baidu.tieba.pb.a.c cVar, int i) {
        String userId;
        boolean z = true;
        if (cVar != null) {
            if (this.bNK != null) {
                this.bNK.setVisibility(0);
            }
            if (this.bNM != null) {
                this.bNM.setVisibility(0);
            }
            if (cVar.YX() != null) {
                this.bNX = cVar.YX().getId();
            }
            if (cVar.hasMore()) {
                this.mListView.setNextPage(this.bNP);
                this.bNL.eb(true);
            } else {
                this.mListView.setNextPage(null);
                this.bNL.eb(false);
            }
            this.bNP.hr(c(cVar));
            this.bNY = cVar.YZ();
            this.bNL.setDatas(this.bNY);
            if (cVar.Zd() == null || cVar.Zd().getAuthor() == null || (userId = cVar.Zd().getAuthor().getUserId()) == null || !userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                z = false;
            }
            this.bNL.q(i, z);
            this.bNL.notifyDataSetChanged();
            a(cVar.YX(), cVar.SR(), cVar.oQ(), i);
        }
    }

    public void setOnActionListener(com.baidu.tbadk.editortool.v vVar) {
        if (vVar != null) {
            this.aIy.a(this.mActivity.getPageContext(), new t(this, vVar));
        }
    }

    protected int c(com.baidu.tieba.pb.a.c cVar) {
        if (cVar == null) {
            return 0;
        }
        return cVar.getTotalCount() - cVar.YZ().size();
    }

    public void setPosition(int i) {
        this.mListView.setSelection(i);
        this.mListView.invalidate();
    }

    public void hS(String str) {
        int hM;
        if (str != null && !str.equals("") && (hM = this.bNL.hM(str)) >= 0) {
            this.mListView.setSelection(hM + 1);
            this.mListView.invalidate();
        }
    }

    public void clearContent() {
        this.aIy.clearData();
    }

    public View acp() {
        return this.bKe;
    }

    protected void a(com.baidu.tieba.tbadkCore.c.j jVar, boolean z, boolean z2, int i) {
        int i2;
        if (jVar != null) {
            this.bJY.setTag(null);
            this.bJY.setUserId(null);
            SparseArray<Object> sparseArray = (SparseArray) this.bNK.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                this.bNK.setTag(sparseArray);
            }
            sparseArray.clear();
            sparseArray.put(com.baidu.tieba.v.tag_clip_board, jVar);
            sparseArray.put(com.baidu.tieba.v.tag_is_subpb, false);
            a(jVar, i, sparseArray);
            this.bKe.setTag(sparseArray);
            if (!this.bIN) {
                this.bJY.setVisibility(8);
            }
            this.azt.setOnClickListener(this.bNS);
            this.azt.setText((CharSequence) null);
            this.bKd.setVisibility(8);
            this.bNN.setText((CharSequence) null);
            this.bKe.setOnClickListener(this.aMP);
            TbadkCoreApplication.m411getInst().getSkinType();
            ba.b(this.bKc, com.baidu.tieba.s.pb_listitem_post_time, 1);
            this.bKc.setText(bd.n(jVar.getTime()));
            if (z) {
                this.bKd.setVisibility(0);
                ba.c(this.bKd, com.baidu.tieba.u.icon_floorhost);
            }
            if (this.bIM) {
                i2 = com.baidu.tieba.u.img_default_100;
            } else {
                i2 = com.baidu.tieba.u.icon_click;
            }
            this.bKf.setDefaultImageId(i2);
            this.bNN.setText(String.format(this.mActivity.getPageContext().getString(y.is_floor), Integer.valueOf(jVar.amA())));
            String portrait = jVar.getAuthor().getPortrait();
            if (jVar.getAuthor() != null) {
                this.azt.setText(jVar.getAuthor().getName_show());
                ArrayList<IconData> tShowInfo = jVar.getAuthor().getTShowInfo();
                if (tShowInfo != null && tShowInfo.size() > 0) {
                    ba.b(this.azt, com.baidu.tieba.s.cp_cont_h, 1);
                } else {
                    ba.b(this.azt, com.baidu.tieba.s.cp_cont_f, 1);
                }
                int level_id = jVar.getAuthor().getLevel_id();
                int is_bawu = jVar.getAuthor().getIs_bawu();
                String bawu_type = jVar.getAuthor().getBawu_type();
                int i3 = 3;
                if (level_id != 0) {
                    this.bJZ.setVisibility(0);
                    ba.c(this.bJZ, com.baidu.tbadk.core.util.c.bR(level_id));
                    this.bJZ.setOnClickListener(null);
                    i3 = 2;
                } else {
                    this.bJZ.setVisibility(8);
                }
                if (is_bawu != 0) {
                    if (bawu_type.equals("manager")) {
                        ba.c(this.bJZ, com.baidu.tieba.u.pb_manager);
                        this.bJZ.setOnClickListener(this.bNT);
                    } else if (bawu_type.equals("assist")) {
                        ba.c(this.bJZ, com.baidu.tieba.u.pb_assist);
                        this.bJZ.setOnClickListener(this.bNT);
                    }
                }
                if (jVar.getAuthor().getGender() == 2) {
                    ba.c(this.bKa, com.baidu.tieba.u.icon_pop_girl_square);
                    this.bKa.setVisibility(0);
                } else {
                    this.bKa.setVisibility(8);
                }
                this.bJH = jVar.getAuthor().getIconInfo();
                this.aHS = jVar.getAuthor().getTShowInfo();
                if (this.aOi != null) {
                    this.aOi.setOnClickListener(this.bNT);
                    this.aOi.a(this.bJH, i3, this.mActivity.getResources().getDimensionPixelSize(com.baidu.tieba.t.pb_icon_width), this.mActivity.getResources().getDimensionPixelSize(com.baidu.tieba.t.pb_icon_height), this.mActivity.getResources().getDimensionPixelSize(com.baidu.tieba.t.pb_icon_margin));
                }
                if (this.aIh != null) {
                    this.aIh.setOnClickListener(this.bNU);
                    this.aIh.a(this.aHS, 2, this.mActivity.getResources().getDimensionPixelSize(com.baidu.tieba.t.big_icon_width), this.mActivity.getResources().getDimensionPixelSize(com.baidu.tieba.t.big_icon_height), this.mActivity.getResources().getDimensionPixelSize(com.baidu.tieba.t.big_icon_margin), true);
                }
            }
            this.bJY.setUserId(jVar.getAuthor().getUserId());
            this.bJY.setUserName(jVar.getAuthor().getUserName());
            this.azt.setTag(com.baidu.tieba.v.tag_user_id, jVar.getAuthor().getUserId());
            this.azt.setTag(com.baidu.tieba.v.tag_user_name, jVar.getAuthor().getUserName());
            this.bJY.setDefaultResource(com.baidu.tieba.u.icon_default_avatar100);
            this.bJY.c(portrait, 28, false);
            this.bKf.b(this.bIM, false);
            this.bKf.setIsFromCDN(this.mIsFromCDN);
            this.bKf.setText(jVar.amB());
            this.bKf.setOnImageClickListener(this.asV);
            this.bKf.setOnEmotionClickListener(this.bMy);
            this.bNO.setVisibility(8);
            if (!TextUtils.isEmpty(jVar.getBimg_url()) && this.bIM) {
                this.bKf.setBackgroundDrawable(null);
                this.bKf.setTag(jVar.getBimg_url());
                com.baidu.adp.lib.f.d.hB().a(jVar.getBimg_url(), 19, new u(this), null);
                return;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bKf.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            this.bKf.setPadding(0, 0, 0, 0);
            this.bKf.setLayoutParams(layoutParams);
            this.bKf.setBackgroundDrawable(null);
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
            int i2 = jVar.amA() == 1 ? 0 : 1;
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

    public View acq() {
        return this.bNQ;
    }

    public String acr() {
        return this.aIy.getEditText().getText().toString();
    }

    public void onChangeSkinType(int i) {
        this.mActivity.getLayoutMode().X(i == 1);
        this.mActivity.getLayoutMode().h(this.rootView);
        this.mActivity.getLayoutMode().h(this.bNK);
        this.mActivity.getLayoutMode().h(this.bNQ);
        ba.i((View) this.bNV, com.baidu.tieba.u.btn_pb_editor_post_btn);
        ba.c(this.bKe, com.baidu.tieba.u.btn_pb_reply_selector);
        this.bKf.setTextColor(ba.getColor(com.baidu.tieba.s.pb_listitem_content));
        this.bKf.setVideoImageId(com.baidu.tieba.u.pic_video);
        this.aIy.b(this.mActivity.getPageContext(), i);
    }

    public void aaK() {
        this.mListView.setVisibility(8);
        this.mProgress.setVisibility(0);
    }

    public void acs() {
        this.mProgress.setVisibility(0);
    }

    public void act() {
        this.mProgress.setVisibility(8);
    }

    public void acu() {
        this.mListView.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.bNP.tO();
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.bNW = onLongClickListener;
        this.bNK.setOnLongClickListener(this.bNW);
    }

    public View acv() {
        return this.bNK;
    }

    public void hP(String str) {
        int hM = this.bNL.hM(str);
        if (hM > -1) {
            this.mListView.setSelection(hM + 1);
            this.mListView.invalidate();
        }
    }

    public void ed(boolean z) {
        this.mIsFromCDN = z;
    }

    public boolean Jc() {
        return this.aIy.Jc();
    }

    public PbEditor IY() {
        return this.aIy;
    }
}
