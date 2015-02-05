package com.baidu.tieba.pb.sub;

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
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.PbEditor.PbEditor;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.view.ClickableLayout4Frame;
import com.baidu.tieba.w;
import com.baidu.tieba.x;
import com.baidu.tieba.z;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class l {
    protected UserIconBox aCl;
    protected TextView aHc;
    protected View.OnClickListener aHz;
    protected UserIconBox aVt;
    protected HeadImageView bBB;
    protected TextView bBC;
    protected ImageView bBD;
    protected TextView bBF;
    protected ImageView bBG;
    protected ImageView bBH;
    protected TbRichTextView bBI;
    protected View.OnClickListener bFs;
    protected ClickableLayout4Frame bGd;
    protected TextView bGe;
    protected Button bGf;
    protected d bGg;
    protected LinearLayout bGh;
    protected TextView bGi;
    protected View bGj;
    protected View.OnClickListener bGl;
    protected View.OnClickListener bGm;
    protected View.OnClickListener bGn;
    private ArrayList<com.baidu.tieba.tbadkCore.b.k> bGr;
    private String bGs;
    protected BaseActivity mActivity;
    protected Handler mHandler;
    protected BdListView mListView;
    protected ProgressBar mProgress;
    protected View rootView = null;
    protected View bGb = null;
    protected a bGc = null;
    protected LinearLayout bGk = null;
    protected int mImageMaxWidth = 0;
    protected boolean bBh = true;
    protected boolean bBi = true;
    private boolean mIsFromCDN = true;
    protected Button bGo = null;
    protected com.baidu.tbadk.widget.richText.s akw = null;
    protected com.baidu.tbadk.widget.richText.r bER = null;
    protected View.OnLongClickListener bGp = null;
    private ArrayList<IconData> bBo = null;
    private ArrayList<IconData> aBY = null;
    protected PbEditor aCC = null;
    private String bGq = null;
    private String bGt = null;
    private boolean bGu = false;
    protected AdapterView.OnItemClickListener bGv = new m(this);
    protected AdapterView.OnItemLongClickListener wM = new n(this);

    public l(BaseActivity baseActivity, boolean z, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3, View.OnClickListener onClickListener4, View.OnClickListener onClickListener5) {
        this.mListView = null;
        this.mActivity = null;
        this.bGd = null;
        this.bBB = null;
        this.aHc = null;
        this.bBC = null;
        this.bBD = null;
        this.bGe = null;
        this.bBG = null;
        this.bBF = null;
        this.bBI = null;
        this.bBH = null;
        this.bGf = null;
        this.bGg = null;
        this.bGh = null;
        this.bGi = null;
        this.bGj = null;
        this.aVt = null;
        this.aCl = null;
        this.aHz = null;
        this.bGl = null;
        this.bFs = null;
        this.bGm = null;
        this.bGn = null;
        this.mHandler = null;
        this.mProgress = null;
        this.mActivity = baseActivity;
        this.mHandler = new Handler();
        this.aHz = onClickListener;
        this.bFs = onClickListener2;
        this.bGl = onClickListener3;
        this.bGm = onClickListener4;
        this.bGn = onClickListener5;
        ZY();
        this.bGd = (ClickableLayout4Frame) this.rootView.findViewById(w.sub_pb_body_layout);
        this.mListView = (BdListView) this.rootView.findViewById(w.new_sub_pb_list);
        this.bGb.setOnClickListener(new o(this));
        this.bGh = (LinearLayout) this.rootView.findViewById(w.sub_pb_bottom_layout);
        ZQ();
        this.bGi = (TextView) this.rootView.findViewById(w.sub_pb_bottom_text);
        this.bBB = (HeadImageView) this.bGb.findViewById(w.photo);
        this.aHc = (TextView) this.bGb.findViewById(w.user_name);
        this.bBC = (TextView) this.bGb.findViewById(w.user_rank);
        this.bBD = (ImageView) this.bGb.findViewById(w.user_gender);
        this.bBH = (ImageView) this.bGb.findViewById(w.reply);
        this.bGf = (Button) this.bGb.findViewById(w.manage_btn);
        this.bGe = (TextView) this.bGb.findViewById(w.floor);
        this.bBG = (ImageView) this.bGb.findViewById(w.floor_owner);
        this.bBF = (TextView) this.bGb.findViewById(w.time);
        this.aVt = (UserIconBox) this.bGb.findViewById(w.user_icon_box);
        this.aCl = (UserIconBox) this.bGb.findViewById(w.user_tshow_icon_box);
        this.bBI = (TbRichTextView) this.bGb.findViewById(w.richText);
        this.bBI.setTextSize(TbConfig.getContentSize());
        this.bBI.setVoiceViewRes(x.voice_play_btn);
        this.mListView.addHeaderView(this.bGb);
        C(onClickListener3);
        this.bGg = new d(this.mActivity.getPageContext().getPageActivity());
        this.bGj = this.bGg.getView();
        this.mListView.setNextPage(this.bGg);
        this.bGg.setOnClickListener(this.aHz);
        this.mListView.setOnItemClickListener(this.bGv);
        this.mListView.setOnItemLongClickListener(this.wM);
        this.bGh.setOnClickListener(this.aHz);
        this.mProgress = (ProgressBar) this.rootView.findViewById(w.progress);
        this.bBB.setOnClickListener(onClickListener3);
        init();
        if (this.bGb != null) {
            this.bGb.setVisibility(4);
        }
        if (this.bGd != null) {
            this.bGd.setVisibility(4);
        }
        if (this.bGh != null) {
            this.bGh.setVisibility(4);
        }
    }

    protected void ZQ() {
        this.aCC = (PbEditor) this.rootView.findViewById(w.sub_pb_editor);
        this.aCC.aK(true);
        this.aCC.getEditText().setFilters(new InputFilter[]{new InputFilter.LengthFilter(140)});
        this.aCC.setMaxTextCount(140);
    }

    protected void C(View.OnClickListener onClickListener) {
        this.bGc = new a(this.mActivity.getPageContext().getPageActivity(), onClickListener);
        this.bGc.B(this.bFs);
        this.bGc.setIsFromCDN(this.mIsFromCDN);
        this.mListView.setAdapter((ListAdapter) this.bGc);
    }

    protected void ZY() {
        this.rootView = com.baidu.adp.lib.g.b.ei().inflate(this.mActivity.getPageContext().getPageActivity(), x.new_sub_pb_layout, null);
        this.bGb = com.baidu.adp.lib.g.b.ei().inflate(this.mActivity.getPageContext().getPageActivity(), x.new_sub_pb_head, null);
    }

    protected void init() {
        this.mImageMaxWidth = Math.min(com.baidu.adp.lib.util.l.dip2px(this.mActivity.getPageContext().getPageActivity(), 427.0f), (int) TbConfig.PB_IMAGE_NEW_MAX_WIDTH);
        aab();
        onChangeSkinType(TbadkCoreApplication.m255getInst().getSkinType());
    }

    public void ZZ() {
        if (!this.aCC.afI()) {
            hG(null);
        }
    }

    public String aaa() {
        return this.bGs;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(int i, View view) {
        new Handler().postDelayed(new p(this, view, i), 300L);
    }

    protected void aab() {
        TextView textView = new TextView(this.mActivity.getPageContext().getPageActivity());
        textView.setLineSpacing(0.0f, 1.2f);
        textView.setTextSize(TbConfig.getContentSize());
    }

    public void setAudioFocusable(boolean z) {
        this.aCC.setAudioFocusable(z);
    }

    public boolean ZP() {
        this.bGu = false;
        if (this.aCC.isVisible()) {
            this.aCC.agf();
            this.aCC.hide();
            this.bGh.setEnabled(true);
            return true;
        }
        this.aCC.clearData();
        this.bGq = null;
        this.bGs = null;
        this.bGr = null;
        return false;
    }

    public void dP(boolean z) {
        this.bBi = z;
        this.bGc.dP(z);
    }

    public void setOnImageClickListener(com.baidu.tbadk.widget.richText.s sVar) {
        this.akw = sVar;
    }

    public void setOnEmotionClickListener(com.baidu.tbadk.widget.richText.r rVar) {
        this.bER = rVar;
    }

    public void hi(int i) {
        this.bBI.setMaxImageWidth(i);
        this.bBI.setMaxImageHeight((int) (i * 1.618f));
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.mListView.setOnScrollListener(onScrollListener);
    }

    public void YO() {
        this.aCC.YO();
    }

    public void YP() {
        this.aCC.YP();
    }

    public View getRootView() {
        return this.rootView;
    }

    public VoiceData.VoiceModel getAudioData() {
        return this.aCC.getAudioData();
    }

    public void FI() {
        this.aCC.FI();
    }

    public void A(ArrayList<String> arrayList) {
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
            int selectionStart = this.aCC.getEditText().getSelectionStart();
            if (selectionStart < 0) {
                this.aCC.getEditText().setText(sb2);
            } else {
                this.aCC.getEditText().getText().insert(selectionStart, sb2);
            }
        }
    }

    public void aO(String str, String str2) {
        this.bGs = str2;
        hG(str);
        new Handler().postDelayed(new q(this, str2), 200L);
    }

    public void hG(String str) {
        this.bGu = true;
        this.aCC.yL();
        this.bGh.setEnabled(false);
        if (str != null) {
            this.aCC.getEditText().setText(this.mActivity.getResources().getString(z.reply_sub_floor).replace("%s", str));
            this.aCC.getEditText().setSelection(this.aCC.getEditText().getText().length());
        }
        if (this.aCC.afI()) {
            this.aCC.age();
            this.aCC.ZZ();
        } else {
            this.aCC.getEditText().requestFocus();
            this.mActivity.ShowSoftKeyPadDelay(this.aCC.getEditText(), 200);
        }
        TiebaStatic.eventStat(this.mActivity.getPageContext().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hH(String str) {
        this.bGu = true;
        this.aCC.yL();
        this.bGh.setEnabled(false);
        this.aCC.getEditText().setText(str);
        this.aCC.getEditText().setSelection(this.aCC.getEditText().getText().length());
        if (this.aCC.afI()) {
            this.aCC.age();
            this.aCC.ZZ();
        } else {
            this.aCC.getEditText().requestFocus();
            this.mActivity.ShowSoftKeyPadDelay(this.aCC.getEditText(), 200);
        }
        TiebaStatic.eventStat(this.mActivity.getPageContext().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    public void aac() {
        this.bGu = false;
        this.aCC.hide();
        this.bGh.setEnabled(true);
    }

    public void aad() {
        this.mListView.setNextPage(this.bGg);
        this.bGg.startLoadData();
    }

    public void dO(boolean z) {
        this.bBh = z;
    }

    public void IK() {
        this.bGc.setDatas(null);
        this.bGc.notifyDataSetChanged();
        this.aCC.getEditText().setText("");
        this.aCC.clearData();
    }

    public String aae() {
        return this.bGq;
    }

    public void a(com.baidu.tieba.tbadkCore.b.o oVar, int i) {
        String userId;
        boolean z = true;
        if (oVar != null) {
            if (this.bGb != null) {
                this.bGb.setVisibility(0);
            }
            if (this.bGd != null) {
                this.bGd.setVisibility(0);
            }
            if (this.bGh != null) {
                this.bGh.setVisibility(0);
            }
            if (oVar.ahC() != null) {
                this.bGq = oVar.ahC().getId();
            }
            if (oVar.hasMore()) {
                this.mListView.setNextPage(this.bGg);
                this.bGc.ee(true);
            } else {
                this.mListView.setNextPage(null);
                this.bGc.ee(false);
            }
            this.bGg.hh(c(oVar));
            this.bGr = oVar.ahE();
            this.bGc.setDatas(this.bGr);
            if (oVar.ahH() == null || oVar.ahH().getAuthor() == null || (userId = oVar.ahH().getAuthor().getUserId()) == null || !userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                z = false;
            }
            this.bGc.u(i, z);
            this.bGc.notifyDataSetChanged();
            a(oVar.ahC(), oVar.RM(), oVar.lb());
        }
    }

    public void setOnActionListener(com.baidu.tbadk.editortool.w wVar) {
        if (wVar != null) {
            this.aCC.a(this.mActivity.getPageContext(), new r(this, wVar));
        }
    }

    protected int c(com.baidu.tieba.tbadkCore.b.o oVar) {
        if (oVar == null) {
            return 0;
        }
        return oVar.getTotalCount() - oVar.ahE().size();
    }

    public void setPosition(int i) {
        this.mListView.setSelection(i);
        this.mListView.invalidate();
    }

    public void hI(String str) {
        int hC;
        if (str != null && !str.equals("") && (hC = this.bGc.hC(str)) >= 0) {
            this.mListView.setSelection(hC + 1);
            this.mListView.invalidate();
        }
    }

    public void clearContent() {
        this.aCC.clearData();
    }

    public View aaf() {
        return this.bBH;
    }

    protected void a(com.baidu.tieba.tbadkCore.b.k kVar, boolean z, boolean z2) {
        int i;
        if (kVar != null) {
            this.bBB.setTag(null);
            this.bBB.setUserId(null);
            SparseArray sparseArray = (SparseArray) this.bGb.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                this.bGb.setTag(sparseArray);
            }
            sparseArray.clear();
            sparseArray.put(w.tag_clip_board, kVar);
            sparseArray.put(w.tag_is_subpb, false);
            this.bBH.setTag(sparseArray);
            if (!this.bBi) {
                this.bBB.setVisibility(8);
            }
            this.aHc.setOnClickListener(this.bGl);
            this.aHc.setText((CharSequence) null);
            this.bBC.setText((CharSequence) null);
            this.bBC.setBackgroundDrawable(null);
            this.bBG.setVisibility(8);
            this.bGe.setText((CharSequence) null);
            this.bBH.setOnClickListener(this.aHz);
            bc.b(this.bBF, t.pb_listitem_post_time, 1);
            this.bBF.setText(bf.n(kVar.getTime()));
            if (z) {
                this.bBG.setVisibility(0);
                bc.c(this.bBG, v.icon_floorhost);
            }
            if (this.bBh) {
                i = v.img_default_100;
            } else {
                i = v.icon_click;
            }
            this.bBI.setDefaultImageId(i);
            this.bGe.setText(String.format(this.mActivity.getPageContext().getString(z.is_floor), Integer.valueOf(kVar.aht())));
            String portrait = kVar.getAuthor().getPortrait();
            if (kVar.getAuthor() != null) {
                this.aHc.setText(kVar.getAuthor().getName_show());
                ArrayList<IconData> tShowInfo = kVar.getAuthor().getTShowInfo();
                if (tShowInfo != null && tShowInfo.size() > 0) {
                    bc.b(this.aHc, t.cp_cont_h, 1);
                } else {
                    bc.b(this.aHc, t.cp_cont_f, 1);
                }
                int level_id = kVar.getAuthor().getLevel_id();
                int is_bawu = kVar.getAuthor().getIs_bawu();
                String bawu_type = kVar.getAuthor().getBawu_type();
                int i2 = 3;
                if (level_id != 0) {
                    this.bBC.setVisibility(0);
                    this.bBC.setText(String.valueOf(level_id));
                    bc.i((View) this.bBC, com.baidu.tbadk.core.util.d.bP(level_id));
                    this.bBC.setOnClickListener(null);
                    i2 = 2;
                } else {
                    this.bBC.setVisibility(8);
                }
                if (is_bawu != 0) {
                    if (bawu_type.equals("manager")) {
                        this.bBC.setText((CharSequence) null);
                        bc.i((View) this.bBC, v.pb_manager);
                        this.bBC.setOnClickListener(this.bGm);
                    } else if (bawu_type.equals("assist")) {
                        this.bBC.setText((CharSequence) null);
                        bc.i((View) this.bBC, v.pb_assist);
                        this.bBC.setOnClickListener(this.bGm);
                    }
                }
                if (kVar.getAuthor().getGender() == 2) {
                    bc.c(this.bBD, v.icon_pop_girl_square);
                    this.bBD.setVisibility(0);
                } else {
                    this.bBD.setVisibility(8);
                }
                this.bBo = kVar.getAuthor().getIconInfo();
                this.aBY = kVar.getAuthor().getTShowInfo();
                if (this.aVt != null) {
                    this.aVt.setOnClickListener(this.bGm);
                    this.aVt.a(this.bBo, i2, this.mActivity.getResources().getDimensionPixelSize(u.pb_icon_width), this.mActivity.getResources().getDimensionPixelSize(u.pb_icon_height), this.mActivity.getResources().getDimensionPixelSize(u.pb_icon_margin));
                }
                if (this.aCl != null) {
                    this.aCl.setOnClickListener(this.bGn);
                    this.aCl.a(this.aBY, 2, this.mActivity.getResources().getDimensionPixelSize(u.big_icon_width), this.mActivity.getResources().getDimensionPixelSize(u.big_icon_height), this.mActivity.getResources().getDimensionPixelSize(u.big_icon_margin), true);
                }
            }
            this.bBB.setUserId(kVar.getAuthor().getUserId());
            this.bBB.setUserName(kVar.getAuthor().getUserName());
            this.aHc.setTag(w.tag_user_id, kVar.getAuthor().getUserId());
            this.aHc.setTag(w.tag_user_name, kVar.getAuthor().getUserName());
            this.bBB.setDefaultResource(v.photo);
            this.bBB.d(portrait, 28, false);
            this.bBI.c(this.bBh, false);
            this.bBI.setIsFromCDN(this.mIsFromCDN);
            this.bBI.setText(kVar.ahu());
            this.bBI.setOnImageClickListener(this.akw);
            this.bBI.setOnEmotionClickListener(this.bER);
            this.bGf.setVisibility(8);
            if (!TextUtils.isEmpty(kVar.getBimg_url()) && this.bBh) {
                this.bBI.setBackgroundDrawable(null);
                this.bBI.setTag(kVar.getBimg_url());
                com.baidu.adp.lib.f.d.ec().a(kVar.getBimg_url(), 19, new s(this), null);
                return;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bBI.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            this.bBI.setPadding(0, 0, 0, 0);
            this.bBI.setLayoutParams(layoutParams);
            this.bBI.setBackgroundDrawable(null);
        }
    }

    public View aag() {
        return this.bGj;
    }

    public String aah() {
        return this.aCC.getEditText().getText().toString();
    }

    public void onChangeSkinType(int i) {
        this.mActivity.getLayoutMode().ab(i == 1);
        this.mActivity.getLayoutMode().h(this.rootView);
        this.mActivity.getLayoutMode().h(this.bGb);
        this.mActivity.getLayoutMode().h(this.bGj);
        bc.i((View) this.bGo, v.btn_pb_editor_post_btn);
        bc.c(this.bBH, v.btn_pb_reply_selector);
        this.bBI.setTextColor(bc.getColor(t.pb_listitem_content));
        this.bBI.setVideoImageId(v.pic_video);
        this.aCC.b(this.mActivity.getPageContext(), i);
    }

    public void YA() {
        this.mListView.setVisibility(8);
        this.mProgress.setVisibility(0);
    }

    public void aai() {
        this.mProgress.setVisibility(0);
    }

    public void aaj() {
        this.mProgress.setVisibility(8);
    }

    public void aak() {
        this.mListView.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.bGg.qE();
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.bGp = onLongClickListener;
        this.bGb.setOnLongClickListener(this.bGp);
    }

    public View aal() {
        return this.bGb;
    }

    public void hF(String str) {
        int hC = this.bGc.hC(str);
        if (hC > -1) {
            this.mListView.setSelection(hC + 1);
            this.mListView.invalidate();
        }
    }

    public void eg(boolean z) {
        this.mIsFromCDN = z;
    }

    public boolean FD() {
        return this.aCC.FD();
    }

    public PbEditor Fz() {
        return this.aCC;
    }
}
